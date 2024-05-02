/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :STM_SAP_0060.js
*@FileTitle  : Payments
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Payments : business script for STM_SAP_0060
     */

	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObject1;
	var sheetObject2;        
    var prefix1; 
	var prefix2;
	var editMainRow=0; 
	var sheet1ChnFlag="N";		//sheet1 change 여부
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*******************************************************/
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
     	try {
			var srcName=ComGetEvent("name");
			var obj = event.target || event.srcElement;
			   if ($(obj).prop('disabled')) {
			 return;
			 }
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
	    	    case "btn_new" :
	    	    	formObj.reset();
	    	    	sheetObjects[0].RemoveAll();
	    	    	sheetObjects[1].RemoveAll();
	    	    	doActionIBSheet(sheetObject1, formObj, COMMAND01);
	    	    	break;
 				case "btn_save":
 					doActionIBSheet(sheetObject1, formObj, IBSAVE);
 					break;
 				case "btn_delete":
 					doActionIBSheet(sheetObject1, formObj, IBDELETE);
 					break;
				case "btn_print":
					doActionIBSheet(sheetObject1,formObj,RDPRINT);
					break;
				case "btn_void":
					doActionIBSheet(sheetObject1, formObj, MULTI02);
					break;					
				case "btns_search_ofc":					
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+formObj.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);					
					break;	
				case "btns_search_bankAccount":
					ComOpenPopupWithTarget('STM_SAP_0063.do?bank_acct_nm='+encodeURIComponent(formObj.bank_acct_nm.value)+"&bank_acct_tp_nm=INTERNAL", 700, 420,"bank_acct_nm:bank_acct_nm", "0,0", true);	
					break;	
				case "btns_search_paygroup":
					var param="?lu_cd=" + encodeURIComponent(formObj.vndr_pay_grp_cd.value)+"&attr_ctnt1=" + formObj.ofc_cd.value;
					ComOpenPopupWithTarget('STM_SAP_0004.do'+param, 400, 420,"lu_cd:vndr_pay_grp_cd", "0,0", true);
					break;	
				case "btns_search_doc":
					ComOpenPopupWithTarget('STM_SAP_0007.do?lu_cd='+formObj.pay_mzd_lu_cd.value, 500, 420,"lu_cd:pay_mzd_lu_cd", "0,0", true);
					break;						
				case "btns_search_supplier":
					var param="?vndr_lgl_eng_nm="+encodeURIComponent(formObj.vndr_nm.value);
					ComOpenPopupWithTarget('STM_SAP_0002.do'+param, 900, 420,"vndr_lgl_eng_nm:vndr_nm", "0,0", true);
					break;		
				case "btns_search_batch":
					ComOpenPopupWithTarget('STM_SAP_0211.do?pay_bat_nm='+formObj.pay_bat_nm.value, 700, 420,"pay_bat_nm:pay_bat_nm", "0,0", true);
					break;											
				case "btns_calFr":
					var cal=new ComCalendar();
					cal.select(form.fr_dt, 'yyyy-MM-dd');
					break;					
				case "btns_calTo":
					var cal=new ComCalendar();
					cal.select(form.to_dt, 'yyyy-MM-dd');
					break;						
				case "btn_sheet1RowAdd":	
					if (sheet1ChnFlag == "N" && sheetObject2.IsDataModified()== false  ) {
						if(sheetObject1.SearchRows()== 0) {
							sheetObject1.RemoveAll();
						}
						var row=sheetObject1.DataInsert(-1);
						sheetObject1.SetCellValue(row, prefix1 + "chk_flg","1");
						sheetObject1.SetCellValue(row, prefix1 + "pay_tp_cd","Manual");
						sheetObject1.SetCellValue(row, prefix1 + "ofc_cd",formObj.hid_login_ap_ofc.value);
						sheetObject1.SetCellValue(row, prefix1 + "pay_dt",formObj.hid_local_sysdate.value);
						sheetObject1.SetCellValue(row, prefix1 + "pay_xch_dt",sheetObject1.GetCellValue(row, prefix1 + "pay_dt"));
						sheetObject1.SetCellValue(row, prefix1 + "curr_cd",formObj.hid_login_curr_cd.value);
						sheetObject1.SetCellValue(row, prefix1 + "pay_sts_lu_cd","NEGOTIABLE");
						sheetObject1.SetCellValue(row, prefix1 + "xch_rt_tp_cd","Corporate");
						sheetObject2.RemoveAll();
						ComBtnEnable("btn_save");
					    ComBtnDisable("btn_delete");
					    ComBtnDisable("btn_print");
					    ComBtnDisable("btn_void");
					} else {
						 if (ComShowCodeConfirm("COM130504")) {   
							 doActionIBSheet(sheetObject1, formObj, IBSAVE);
							 return;
	                     } else {
	                    	 sheetObject1.ReturnData(editMainRow);
	                     }
					}
 					break;					
				case "btn_sheet1RowDelete":
					//sheetObject1.RowDelete(sheetObject1.SelectRow , false);
					var row=sheetObject1.GetSelectRow();
					if(sheetObject1.GetCellValue(row, prefix1 + "ibflag") != "I") {
						ComShowCodeMessage("SAP00032", "delete"); //You can't {?msg1} row, because this Header item was already saved.
						return;
					}															
					sheetObject1.SetRowHidden(row,1);
					sheetObject1.SetRowStatus(row,"D");
					sheetObject2.RemoveAll();
					break; 					
				case "btn_sheet2RowAdd":
					var mainRow=sheetObject1.GetSelectRow();
					if(mainRow == -1) {
						ComShowCodeMessage("SAP00010", "header" );  //Please select [{?msg1}]
						return;
					}
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "ibflag") != "I") {
						ComShowCodeMessage("SAP00032", "add new"); //You can't {?msg1} row, because this Header item was already saved.
						return;
					}					
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "bank_acct_nm") == "" || sheetObject1.GetCellValue(mainRow, prefix1 + "bank_acct_seq") == "") {
						ComShowCodeMessage("COM12118", "header", "Bank Account" );
						return;
					}
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_dt") == "") {
						ComShowCodeMessage("COM12118", "header", "Payment Data" );
						return;
					}					
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "ofc_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Office" );
						return;
					}											
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "vndr_nm") == "" || sheetObject1.GetCellValue(mainRow, prefix1 + "vndr_no") == "") {
						ComShowCodeMessage("COM12118", "header", "Supplier" );
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_amt") == "" || parseFloat(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_amt")) == 0) {
						ComShowCodeMessage("COM12130", "header", "Payment Amount" );
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_mzd_lu_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Payment Method" );
						return;
					}
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_xch_dt") == "") {
						ComShowCodeMessage("COM12130", "header", "Rate Date" );
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "xch_rt_tp_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Rate Type" );
						return;
					}	
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "curr_cd") == "") {
						ComShowCodeMessage("COM12130", "header", "currency" );
						return;
					}											
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_cnt_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Country" );
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_func_amt") == "") {
						ComShowCodeMessage("COM12118", "header", "Functional Amount" );
						return;
					}					
					var row=sheetObject2.DataInsert(-1);
					sheetObject2.SetRowHidden(sheetObject2.LastRow(),1);//pay_amt 합계를 위한 dtAutoSumEx 행 숨김
					settingPointFormat(sheetObject2, row);
 					break;
				case "btn_sheet2RowDelete":
					//sheetObject2.RowDelete(sheetObject2.SelectRow , false);
					var mainRow=sheetObject1.GetSelectRow();
					var row=sheetObject2.GetSelectRow();
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "ibflag") != "I") {
						ComShowCodeMessage("SAP00032", "delete"); //You can't {?msg1} row, because this Header item was already saved.
						return;
					}						
					sheetObject2.SetRowHidden(row,1);
					sheetObject2.SetRowStatus(row,"D");
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
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}	
		this.sheetObject1=sheetObjects[0];
		this.sheetObject2=sheetObjects[1];	    
	    this.prefix1=sheetObject1.id + "_"; 
	    this.prefix2=sheetObject2.id + "_";
	    doActionIBSheet(sheetObject1, formObj, COMMAND01); // OFC, DATE Setting	
		initControl();
		
		resizeSheet();
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
				   	  // SetTitle("code|name|attr1");
				       //SetColAlign("left|left|left");
				       //SetColWidth("50|170|100");
					   //DropHeight = 160;
			       }
	           break;
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
			       }
	           break;
	     }
	}		
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
		       
		      var HeadTitle1="|Chk|Type|Bank Account|Payment date|Office|Supplier Name|Supplier|Payment Amount|Remit-to Account Number|Currency|Voucher Num|Payment Process Name|Payment Method|Status|Rate Date|Rate Type|Payment Rate|Country|Functional Amount|pay_seq|Bank Account Sequence|Remit-to Account Sequence|Bank Acct No|period_chk|pay_curr_prcs|cnt_acctg_pst_flg_y";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_flg" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Popup",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_acct_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
		             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_amt",             KeyField:1,   CalcLogic:"",   Format:"NullFloat",            PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
		             {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"remit_to_acct_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"doc_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_bat_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_sts_lu_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_xch_dt",          KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xch_rt_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_xch_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_cnt_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_func_amt",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xter_bank_acct_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"period_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_curr_prcs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cnt_acctg_pst_flg_y", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      		InitColumns(cols);
		      		SetEditable(1);
				    SetColProperty(0 ,prefix +"pay_tp_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				    SetColProperty(0 ,prefix + "ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				    SetColProperty(0 ,prefix +"pay_sts_lu_cd" , {AcceptKeys:"E"});
				    SetColProperty(0 ,prefix +"xch_rt_tp_cd" , {AcceptKeys:"E"});
				    SetColProperty(0 ,prefix +"pay_cnt_cd" , {AcceptKeys:"E"});
				    SetColHidden(prefix + "chk_flg",1);
				    
				    SapInitDataCombo(sheetObj, prefix + "pay_mzd_lu_cd", "2", " " , " ", "PAYMENT METHOD" , "", 1) ;
				    
				    InitComboNoMatchText(true);
				    SetSheetHeight(200);
		      	}
				break;
			case 2:      // sheet1 init
			    with(sheetObj){
				      var HeadTitle1="|CSR No|Payment Number|Date|Inv Amount|GL Date|Payment Amount|Description|inv pay seq|pay seq|Functional Amount|liab_cd_cmb_seq|xter_bank_acct_seq|remit_vndr_no|inv_seq";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"Popup",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_skd_no",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",             KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"acctg_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_amt",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_pay_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_func_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_cd_cmb_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xter_bank_acct_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"remit_vndr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      InitComboNoMatchText(true);
				      SetSheetHeight(190);
				}
			  break;   
		}
	}
	function sheet1_OnDblClick(sheetObj, Row, Col){
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheet1ChnFlag="N";
		var prefix=sheetObj.id + "_";
		var formObj=document.form;
		if (sheetObj.RowCount()> 0) {
			sheet1_OnClick(sheetObj, 1, 0);
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_print");
			ComBtnEnable("btn_void");
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
		var paySeq=sheetObj.GetCellValue(Row, prefix + "pay_seq");
		var ibFlag=sheetObj.GetCellValue(Row, prefix+"ibflag");
		if (Row != editMainRow) {
			if ( sheetObj.GetCellValue(Row, prefix+"ibflag") != "I" &&  ( sheet1ChnFlag == "Y" || sheetObjects[1].IsDataModified()== true)) {
				if (ComShowCodeConfirm("COM130504")) {    // "Data was changed. Do you want to save it?"					 
					 sheetObj.SetSelectRow(editMainRow);
					 doActionIBSheet(sheetObj, formObj, IBSAVE);
					 return;
	           } else {
	        	   if( sheetObj.GetCellValue(editMainRow, prefix+"ibflag") != "I" ) {
	        		   sheetObj.ReturnData(editMainRow);
	        	   } else {
	        		   sheetObj.RowDelete(editMainRow, false);
	        	   }        		   
	        	   sheet1ChnFlag="N";
	           }
			} 			
		}
		sheetObj.SetCellValue(Row, prefix+"chk_flg","1",0);
	    // line grid 조회 				
		if (ibFlag != "I" && (paySeq != sheetObjects[1].GetCellValue(1, sheetObjects[1].id+"_pay_seq"))) {
	        formObj.hid_pay_seq.value=paySeq;	
	        sheetObjects[1].RemoveAll();
	        doActionIBSheet(sheetObjects[1], formObj, SEARCHLIST02);
	    }	
		if(sheetObj.GetCellValue(Row, prefix+"ibflag")!="I") {
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_print");
			ComBtnEnable("btn_void");
		} else {
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_void");
			ComBtnDisable("btn_print");			
		}		
		//버튼설정 
		if ( "0" != sheetObj.GetCellValue(Row, sheetObj.id+"_cnt_acctg_pst_flg_y") ) {
			ComBtnDisable("btn_delete");
			ComBtnEnable("btn_void");
		} else {
			ComBtnEnable("btn_delete");
			ComBtnDisable("btn_void");			
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
                	var sXml=sheetObj.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND03 + "&value0=" + sheetObj.GetCellValue(Row, prefix + "ofc_cd") );
     				if (SAPDecideErrXml(sheetObj, sXml)) {
     					sheetObj.SetCellValue(Row, Col, "");
     					sheetObj.SelectCell(Row, Col, true, "");
                     } else {
                    	 if ( "NO_DATA" == ComGetEtcData(sXml, "ofc_cd") ) {
                    		ComShowCodeMessage("COM132201", "Office Code" );   //{?msg1} is invalid.
                    		sheetObj.SetCellValue(Row, prefix + "ofc_cd", "");
         					sheetObj.SelectCell(Row, prefix + "ofc_cd", true, "");
                    	 } else {
                    		 sheetObj.SetCellValue(Row, prefix + "ofc_cd",ComGetEtcData(sXml, "ofc_cd"));
                    		 changeOfcAndGlDate(sheetObj, Row, Col);
                    	 }
                     }
                	break;
            	case prefix + "pay_dt":    
            		changeOfcAndGlDate(sheetObj, Row, Col);  
            		
            		var curr_cd=sheetObj.GetCellValue(Row,  prefix + "curr_cd");
            		if (curr_cd != "") {
            			chkXRate(prefix + "pay_xch_dt", Row);
            			
            			var pay_amt=sheetObj.GetCellValue(Row,  prefix + "pay_amt");
            			if(pay_amt != "") {
                			settingPointFormat(sheetObj, Row);
                			var pay_amt = parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row, prefix + "pay_amt"),",",""));
                			var pay_xch_rt = parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row, prefix + "pay_xch_rt"),",",""));
    	            		sheetObj.SetCellValue(Row, prefix + "pay_func_amt",SAPComRound(pay_amt * pay_xch_rt,f_curr_prcs),0);
                		}    
            		}
            		
                	break;
            	case prefix + "curr_cd":    //원래 bank account 변경시 이벤트이나 bank account 팝업에서 데이터를 설정하는 curr_cd 가 들어오지 않기 때문에 curr_cd 로 이벤트를 줌
            		if (Value == "") return;
            		var curr_cd=sheetObj.GetCellValue(Row, prefix + "curr_cd");
            		var pay_dt=sheetObj.GetCellValue(Row, prefix + "pay_dt");
            		var period_chk=sheetObj.GetCellValue(Row, prefix + "period_chk");
	          		var f_curr_cd=formObj.hid_func_curr_cd.value;
	          		var f_curr_prcs=formObj.hid_func_curr_prcs.value;
	          		if (pay_dt.length > 0 && curr_cd.length > 0 && period_chk == "Y") {
             			if (curr_cd != f_curr_cd) { //환율과 functional 환율이 다를 때.
             				var xmlStr=GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + pay_dt + "&value1=" + curr_cd + "&value2=" + f_curr_cd);
             				 if (SAPDecideErrXml(sheetObj, xmlStr)) { 
             					 SetCellValue(Row, Col, "");
                                 SelectCell(Row, Col, true, "");
                             } else {
                                 var x_rate=ComGetEtcData(xmlStr, "x_rate");
                                 var x_date=ComGetEtcData(xmlStr, "x_date");
                                 var x_type=ComGetEtcData(xmlStr, "x_type");
                                 var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                                 if ( x_rate != "X") {
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt",x_rate,0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",x_date,0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs",x_prcs,0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_func_amt","",0);
                                 } else  {
                                 	ComShowCodeMessage("SAP00002", pay_dt, curr_cd);  // currency 없음 
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_func_amt","",0);
                                 	SetCellValue(Row, Col, "");
                                 	SelectCell(Row, Col, true, "");
                                 }
                             }
             			} else {  //환율과 functional 환율이 같을 때          				
                         	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt",1,0);
                         	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",sheetObj.GetCellValue(Row, prefix + "pay_dt"),0);
                         	sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs",f_curr_prcs,0);
                         	sheetObj.SetCellValue(Row, prefix + "pay_func_amt","",0);
             			}
             		}
	          		settingPointFormat(sheetObj, Row);
            		break;
            	case prefix + "pay_amt":    
            		if (Value == "") return;
            		var f_curr_prcs=formObj.hid_func_curr_prcs.value;
            		if(sheetObj.GetCellValue(Row, prefix + "bank_acct_nm") == "") {
            			ComShowCodeMessage("SAP00010", "Bank Account");            			
            			sheetObj.SetCellValue(Row, Col,"",0);
            			sheetObj.SelectCell(Row, prefix + "bank_acct_nm");
            			return;
            		}            	
            		if(sheetObj.GetCellValue(Row, Col) != "") {
            			settingPointFormat(sheetObj, Row);
            			var pay_amt=parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row, prefix + "pay_amt"),",",""));
            			var pay_xch_rt=parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row, prefix + "pay_xch_rt"),",",""));
	            		sheetObj.SetCellValue(Row, prefix + "pay_func_amt",SAPComRound(pay_amt * pay_xch_rt,f_curr_prcs),0);
            		}            		
                	break;  
            	case prefix + "vndr_no":  
            		if (Value == "") return;
            		var vendorParam="&delt_flg=N&vndr_seq=" + sheetObj.GetCellValue(Row, Col);
            		var sXml2=sheetObj.GetSearchData("STM_SAP_0002GS.do", "f_cmd=" + SEARCH + vendorParam);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
        				return;
        			} else {      
        				if ("NO_DATA" == ComGetEtcData(sXml2, "vndr_lgl_eng_nm") ) {        					
        					ComShowCodeMessage("COM132201", "Supplier Code" );   
        					sheetObj.SetCellValue(Row, prefix + "vndr_nm","",0);
        					sheetObj.SelectCell(Row, prefix + "vndr_no", true, "");
        					sheetObj.SetCellValue(Row, prefix + "pay_cnt_cd","",0);
        				} else { 	        				
		                	sheetObj.SetCellValue(Row, prefix + "vndr_nm","",0);
		                	sheetObj.SetCellValue(Row, prefix + "vndr_nm",ComGetEtcData(sXml2, "vndr_lgl_eng_nm"));
		                	sheetObj.SetCellValue(Row, prefix + "pay_cnt_cd",ComGetEtcData(sXml2, "vndr_cnt_cd"));
		                	sheetObj.SetCellValue(Row, prefix + "pay_mzd_lu_cd",ComGetEtcData(sXml2, "sap_pay_mzd_cd"),0);
        				}
                	}            		
            		sheetObj.SetCellValue(Row, prefix + "remit_to_acct_no","",0);
            		//Remit-to Account Number Setting
            		var xml3Param = "&vndr_seq=" + sheetObj.GetCellValue(Row, Col)+"&call_flag=INVOICE";
            		var sXml3=sheetObj.GetSearchData("STM_SAP_0032GS.do", "f_cmd=" + SEARCH + xml3Param);
            		if (SAPDecideErrXml(sheetObj, sXml3)) {
        				break;
        			} else {      
        				if ("NO_DATA" == ComGetEtcData(sXml3, "bank_acct_no") ) {        					
        					sheetObj.SetCellValue(Row, prefix + "remit_to_acct_no","",0);
        				} else { 	        				
        					sheetObj.SetCellValue(Row, prefix + "remit_to_acct_no",ComGetEtcData(sXml3, "bank_acct_no"));
                       		sheetObj.SetCellValue(Row, prefix + "xter_bank_acct_seq",ComGetEtcData(sXml3, "bank_acct_seq"));
        				}
                	}         
            		break;
            }
        }
        sheet1ChnFlag="Y";	
        editMainRow=Row;
	}
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		if(sheetObj.ColSaveName(Col) == prefix + "pay_tp_cd"){
			ComOpenPopup("STM_SAP_0062.do", 600, 400, "setPopupData", "0,0", true, false, Row, Col, 0);				
		}		
		if(sheetObj.ColSaveName(Col) == prefix + "bank_acct_nm"){
			ComOpenPopup("STM_SAP_0063.do?ofc_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "ofc_cd")) + "&bank_acct_tp_nm=INTERNAL", 700, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
		}
		if(sheetObj.ColSaveName(Col) == prefix + "ofc_cd"){
			ComOpenPopup("STM_SAP_0001.do", 400, 430, "setPopupData", "0,0", true, false, Row, Col, 0);				
		}
		if(sheetObj.ColSaveName(Col) == prefix + "vndr_nm"){
			ComOpenPopup("STM_SAP_0002.do?delt_flg=N&vndr_lgl_eng_nm="+ encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "vndr_nm")), 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
		}
		if(sheetObj.ColSaveName(Col) == prefix + "vndr_no"){
			ComOpenPopup("STM_SAP_0002.do?delt_flg=N&vndr_seq="+ sheetObj.GetCellValue(Row, prefix + "vndr_no"), 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pay_mzd_lu_cd"){
			ComOpenPopup("STM_SAP_0007.do", 500, 420, "setPopupData", "0,0", true, false, Row, Col, 0);				
		}
		if(sheetObj.ColSaveName(Col) == prefix + "remit_to_acct_no"){
			if(sheetObj.GetCellValue(Row, prefix + "vndr_no") == "") {
				ComShowCodeMessage("SAP00010", "Supplier Code" );  //Please select [{?msg1}]
				return;  
			}
			ComOpenPopup("STM_SAP_0032.do?bank_acct_tp_nm=SUPPLIER&call_flag=INVOICE&vndr_seq="+ sheetObj.GetCellValue(Row, prefix + "vndr_no"), 650, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pay_dt"){
        	var cal=new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');							
		}		
	}
	function sheet2_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if(sheetObj.ColSaveName(Col) == prefix + "inv_no"){   //Invoice Type
			var mainRow=sheetObject1.GetSelectRow();
			var param="curr_cd=" + sheetObjects[0].GetCellValue(mainRow, sheetObjects[0].id + "_" + "curr_cd");
			param=param + "&vndr_no=" + sheetObjects[0].GetCellValue(mainRow, sheetObjects[0].id + "_" + "vndr_no");
			param=param + "&pay_mzd_lu_cd=" + sheetObjects[0].GetCellValue(mainRow, sheetObjects[0].id + "_" + "pay_mzd_lu_cd");
			param=param + "&inv_no=" + sheetObj.GetCellValue(Row, sheetObj.id + "_" + "inv_no");
			ComOpenPopup("STM_SAP_0064.do?"+param, 600, 540, "setPopupData2", "0,0", true, false, Row, Col, 1);		
		}		
		if(sheetObj.ColSaveName(Col) == prefix + "inv_dt" || sheetObj.ColSaveName(Col) == prefix + "acctg_dt"){   //Date, Gl Date
        	var cal=new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');	
		}		
	}
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		if (Value == "") return;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var f_curr_prcs=formObj.hid_func_curr_prcs.value;
        with (sheetObj) {
            switch (ColSaveName(Col)) {
                case prefix + "pay_amt":    // payment amount
                	if(sheetObj.GetCellValue(Row, Col) != "") {
            			settingPointFormat(sheetObj, Row);
            			var pay_amt=parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row, prefix + "pay_amt"),",",""));
            			var pay_xch_rt=parseFloat(ComReplaceStr(ComNullToZero(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), sheetObjects[0].id + "_pay_xch_rt")),",",""));
	            		sheetObj.SetCellValue(Row, prefix + "pay_func_amt",SAPComRound(pay_amt * pay_xch_rt,f_curr_prcs),0);
            		}                 	
            		break;
                case prefix + "inv_no":    // invoice number
                	break;
            }   
        }    
	}
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.SetRowHidden(sheetObj.LastRow(),1);//pay_amt 합계를 위한 dtAutoSumEx 행 숨김
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
			case COMMAND01: // Open or New
			    //office 코드 설정
				var sXml=sheetObjects[0].GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH01);
				var apLoginOfc=ComGetEtcData(sXml, "ap_ofc_cd");
				var apLoginCurr=ComGetEtcData(sXml, "ar_curr_cd");
				var apLoginLoc=ComGetEtcData(sXml, "loc_cd");
				formObj.ofc_cd.value=apLoginOfc;
				formObj.hid_login_curr_cd.value=apLoginCurr;
				formObj.hid_login_ap_ofc.value=apLoginOfc;
				formObj.hid_login_loc_cd.value=apLoginLoc;	 
			    //office local date 설정
				var localTime=SapGetLocDate(sheetObjects[0]);
				var localStartTime=localTime.substr(0,6) + "01";
				formObj.fr_dt.value=ComGetMaskedValue(localStartTime, "ymd");				
				formObj.to_dt.value=ComGetMaskedValue(localTime, "ymd");  	
				formObj.hid_local_sysdate.value=localTime;
				var tmpArray=SapGetFunctionalCurrencyCode(sheetObjects[0]);
				formObj.hid_func_curr_cd.value=tmpArray[0];
				formObj.hid_func_curr_prcs.value=tmpArray[1];
				ComBtnDisable("btn_save");
			    ComBtnDisable("btn_delete");
			    ComBtnDisable("btn_print");
			    ComBtnDisable("btn_void");
				break;
			case IBSEARCH: // RETRIEVE 
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("STM_SAP_0060GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case SEARCHLIST02: // RETRIEVE LINE
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("STM_SAP_0060GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
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
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
				setTimeout( function () {     
					var sXml=sheetObj.GetSaveData("STM_SAP_0060GS.do", sParam);
					SapOpenWait(false,true);
	               var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	               if(result != "F"){
	     				ComShowCodeMessage("COM130102", "Data");         				     				   				
	     				doActionIBSheet(sheetObj, formObj, IBSEARCH);     
	               }else{
	     				ComShowCodeMessage("COM130103", "data");
	               }				
				} , 100);				
				break;
			case IBDELETE: // DELETE
				formObj.f_cmd.value=REMOVE01;
				var row=sheetObj.GetSelectRow();
				var bank_acct_nm=sheetObj.GetCellValue(row, prefix + "bank_acct_nm");
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}			
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				if(sParam2 == "" ){
					return;
				}					
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
                if (ComShowCodeConfirm("COM12165", "[" + bank_acct_nm + "]")) {    // Do you want to delete {?msg1}?
                    ComOpenWait(true);    
                    setTimeout( function () { 
                    	 var sXml=sheetObj.GetSaveData("STM_SAP_0060GS.do", sParam);
                    	 SapOpenWait(false,true);
                         var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                         if(result != "F"){
               				ComShowCodeMessage("COM130303", "Data");         				     				   				
               				doActionIBSheet(sheetObj, formObj, IBSEARCH);     
                         }else{
               				ComShowCodeMessage("COM130304", "data");
                         }         
                    } , 100);                              
                }
				break;
			case MULTI02 : // VOID
				formObj.f_cmd.value=MULTI02;
				var row=sheetObj.GetSelectRow();
				var bank_acct_nm=sheetObj.GetCellValue(row, prefix + "bank_acct_nm");
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}				
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				if(sParam2 == "" ){
					return;
				}									
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);				
                if (ComShowCodeConfirm("SAP00024", "[" + bank_acct_nm + "]")) {    // Do you want to void {?msg1}?
                	SapOpenWait(false,true);
                    setTimeout( function () {   
                    	 var sXml=sheetObj.GetSaveData("STM_SAP_0060GS.do", sParam);
                         ComOpenWait(false);
                         var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                         if(result != "F"){
               				ComShowCodeMessage("SAP00025", "Data");         				     				   				
               				doActionIBSheet(sheetObj, formObj, IBSEARCH);     
                         }else{
               				ComShowCodeMessage("SAP00026", "data");
                         }       
                    } , 100);
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
				setTimeout( function () {    
					var sXml=sheetObj.GetSaveData("STM_SAP_0060GS.do", sParam);
					SapOpenWait(false,true);
					if (SAPDecideErrXml(sheetObj, sXml)) return;
					var print_seq=ComGetEtcData(sXml, "INV_RQST_SEQ");
					rdOpen(formObj, print_seq);
				} , 100);
		        break;	
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
		var prefix1=sheetObject1.id + "_";
		var prefix2=sheetObject2.id + "_";		
		switch (sAction) {
			case IBSEARCH: //retrieve
				if(formObj.ofc_cd.value == ""){
					ComShowCodeMessage("COM12113", "Office");
					ComSetFocus(document.all.item("ofc_cd"));
					return false;
				}
				if(formObj.fr_dt.value == ""){
					ComShowCodeMessage("COM12113", "From Payment Date");
					ComSetFocus(document.all.item("fr_dt"));
					return false;
				}
				if(formObj.to_dt.value == ""){
					ComShowCodeMessage("COM12113", "To Payment Date");
					ComSetFocus(document.all.item("to_dt"));
					return false;
				}				
				var frDt1=ComReplaceStr(formObj.fr_dt,"-","");
				var toDt1=ComReplaceStr(formObj.to_dt,"-","");
				if (ComGetDaysBetween(frDt1, toDt1) < 0){
					ComShowCodeMessage("COM132002");
					formObj.to_dt.focus();
					return false;
				}
				break;
			case IBSAVE : //save
				if(sheet1ChnFlag == "Y" || sheetObject2.IsDataModified()== true) {
					var mainRow=sheetObject1.GetSelectRow();
					if(sheetObject2.RowCount() < 1) {
						ComShowCodeMessage("SAP00027", "invoice"); //Please add {?msg1} data.
						return false;
					}
				
					/** grid1 유효성 체크 **/
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "bank_acct_nm") == "" || sheetObject1.GetCellValue(mainRow, prefix1 + "bank_acct_seq") == "") {
						ComShowCodeMessage("COM12118", "header", "Bank Account" );
						return;
					}
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_dt") == "") {
						ComShowCodeMessage("COM12118", "header", "Payment Data" );
						return;
					}	
					
					if (!changeOfcAndGlDate(sheetObjects[0], mainRow, prefix1 + "pay_dt")) {
		    			return false;
		    		}
					
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "ofc_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Office" );
						return;
					}											
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "vndr_nm") == "" || sheetObject1.GetCellValue(mainRow, prefix1 + "vndr_no") == "") {
						ComShowCodeMessage("COM12118", "header", "Supplier" );
						return;
					}	
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_amt") == ""  || parseFloat(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_amt")) <= 0 ) {
						ComShowCodeMessage("COM132202", "Payment Amount" );
						sheetObject1.SetCellValue(mainRow, prefix1 + "pay_amt", "");
						sheetObject1.SelectCell(mainRow, prefix1 + "pay_amt", true, "");
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_mzd_lu_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Payment Method" );
						return;
					}
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_xch_dt") == "") {
						ComShowCodeMessage("COM12130", "header", "Rate Date" );
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "xch_rt_tp_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Rate Type" );
						return;
					}	
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "curr_cd") == "") {
						ComShowCodeMessage("COM12130", "header", "currency" );
						return;
					}												
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_cnt_cd") == "") {
						ComShowCodeMessage("COM12118", "header", "Country" );
						return;
					}						
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_func_amt") == "") {
						ComShowCodeMessage("COM12118", "header", "Functional Amount" );
						return;
					}			
					
					// Check Gl Date, Inv Date
					var hGlDt=ComReplaceStr(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_dt"), "-", "");
					hGlMonth=hGlDt.substring(0,6);
					
					/** grid2 유효성 체크 **/
					var sheet2_row_cnt=sheetObject2.RowCount(); //dtAutoSumEx 행은 유효성 체크 하지 않음(-1)										
					for(var i=1; i <= sheet2_row_cnt; i++ ) { 
						if(sheetObject2.GetCellValue(i, prefix2 + "ibflag") != "D") {	//삭제행을 제외한 데이터 체크
							if(sheetObject2.GetCellValue(i, prefix2 + "inv_no") == "")
							{
								ComShowCodeMessage("COM12113", "Invoice Number" );   
								return false;
							}
							if(sheetObject2.GetCellValue(i, prefix2 + "inv_dt") == "")
							{
								ComShowCodeMessage("COM130404", "Date" , "Date");   
								return false;
							}				
							if(sheetObject2.GetCellValue(i, prefix2 + "acctg_dt") == "")
							{
								ComShowCodeMessage("COM130404", "GL Date" , "GL Date");   
								return false;
							}					
							if(sheetObject2.GetCellValue(i, prefix2 + "pay_amt") == "" || parseFloat(sheetObject2.GetCellValue(i, prefix2 + "pay_amt")) == 0)
							{
								ComShowCodeMessage("COM130404", "Payment Amount" , "Payment Amount");   
								return false;
							}		

							var dGlDt = ComReplaceStr(sheetObject2.GetCellValue(i, prefix2 + "acctg_dt"), "-", "").substring(0,6);
							if (dGlDt != hGlMonth) {
								ComShowCodeMessage("SAP00006", "Header's Payment Date month" ,  "Line's GL Date month" ); 
								return false;
							}

							/*if(ComReplaceStr(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_dt"),"-","") != ComReplaceStr(sheetObject2.GetCellValue(i, prefix2 + "acctg_dt"),"-","")) {
								ComShowCodeMessage("SAP00006", "Header's Payment Date" ,  "Line's GL Date" ); 
								return false;
							}*/

							//invoice number duplicate check
							for(var j=i+1; j<=sheet2_row_cnt; j++) {
								if(sheetObject2.GetCellValue(j, prefix2 + "ibflag") != "D") {	//삭제행을 제외한 데이터 체크
									if(sheetObject2.GetCellValue(i, prefix2 + "inv_no") == sheetObject2.GetCellValue(j, prefix2 + "inv_no") && sheetObject2.GetCellValue(i, prefix2 + "pay_skd_no") == sheetObject2.GetCellValue(j, prefix2 + "pay_skd_no")) {
										ComShowCodeMessage("COM12115", "Invoice Number[" + sheetObject2.GetCellValue(i, prefix2 + "inv_no") + "]");
										sheetObject2.SetSelectRow(i);
										return false;
									}
								}
							}
							//pay 가능 여부	체크		
							var inv_no=sheetObject2.GetCellValue(i, prefix2 + "inv_no");
							var sXml=sheetObject2.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND01 + "&value0=" + inv_no);
							if (SAPDecideErrXml(sheetObject2, sXml)) {
								sheetObject2.SetCellValue(i, prefix2 + "inv_no", "");
								sheetObject2.SelectCell(i, prefix2 + "inv_no", true, "");
					        } else {	
					        	if(parseInt(ComGetEtcData(sXml, "value0"),10) == 0) {
					        		ComShowCodeMessage("SAP00021", inv_no ); 
					        		return false;
					        	}
					        }
						}	
					} // for end
					//sheet2 pay_amt 합계와 sheet1 pay_amt 금액 동일여부 체크
					var sheet2_tot_pay_amt=parseFloat(ComReplaceStr(sheetObject2.GetCellValue(sheetObject2.LastRow(), prefix2 + "pay_amt"),",","")); //sheet2에 pay_amt 의 dtAutoSumEx 행의 합
					var sheet1_pay_amt=parseFloat(ComReplaceStr(sheetObject1.GetCellValue(mainRow, prefix1 + "pay_amt"),",","")); //sheet1의 pay_amt
					if(sheet2_tot_pay_amt != sheet1_pay_amt) {
						ComShowCodeMessage("SAP00029");   
						return false;
					}					
					//save 가능 여부 체크(전표 발행 여부)		
					if(sheetObject1.GetCellValue(mainRow, prefix1 + "ibflag") != "I") {
						var pay_seq=sheetObject1.GetCellValue(mainRow, prefix1 + "pay_seq");
						var bank_acct_nm=sheetObject1.GetCellValue(mainRow, prefix1 + "bank_acct_nm");
						var sXml=sheetObject1.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND02 + "&value0=" + pay_seq);
						if (SAPDecideErrXml(sheetObject1, sXml)) {
							sheetObject1.SelectCell(mainRow, prefix1 + "pay_seq", true, "");
				        } else {	
				        	if(ComGetEtcData(sXml, "value0") == "Y") { // 전표 발행시
				        		ComShowCodeMessage("SAP00028", "save [" + bank_acct_nm + "]" ); 
				        		return false;
				        	}		        	
				        }					
					}
				
				} else {
					ComShowCodeMessage("COM130503");   //"There is no updated data to save."
					return false;					
				}
				break;
			case IBDELETE : //DELETE
				//delete 가능 여부	체크(전표 발행 여부)		
				var row=sheetObject1.GetSelectRow();
				var pay_seq=sheetObject1.GetCellValue(row, prefix1 + "pay_seq");
				var bank_acct_nm=sheetObject1.GetCellValue(row, prefix1 + "bank_acct_nm");
				var sXml=sheetObject1.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND02 + "&value0=" + pay_seq);
				if (SAPDecideErrXml(sheetObject1, sXml)) {
					sheetObject1.SelectCell(row, prefix1 + "pay_seq", true, "");
		        } else {	
		        	if(ComGetEtcData(sXml, "value0") == "Y") { // 전표 발행시
		        		ComShowCodeMessage("SAP00028", "delete [" + bank_acct_nm + "]" ); 
		        		return false;
		        	}		        	
		        }	
				
				
				//정산여부 CHECK (APPLY 된 데이타는 삭제하지 못한다.)	
				var sXml2=sheetObject1.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND04 + "&hid_pay_seq=" + pay_seq);
				if (SAPDecideErrXml(sheetObject1, sXml2)) {
					sheetObject1.SelectCell(row, prefix1 + "pay_seq", true, "");
		        } else {	
		        	if(ComGetEtcData(sXml2, "apply_yn") == "Y") { 
		        		ComShowCodeMessage("SAP00061" ); 
		        		return false;
		        	}		        	
		        }	
				
				break;
			case MULTI02 : // void
				//void 가능 여부 체크(전표 발행 여부)		
				var row=sheetObject1.GetSelectRow();
				var pay_seq=sheetObject1.GetCellValue(row, prefix1 + "pay_seq");
				var bank_acct_nm=sheetObject1.GetCellValue(row, prefix1 + "bank_acct_nm");
				var sXml=sheetObject1.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND02 + "&value0=" + pay_seq);
				if (SAPDecideErrXml(sheetObject1, sXml)) {
					sheetObject1.SelectCell(row, prefix1 + "pay_seq", true, "");
		        } else {	
		        	if(ComGetEtcData(sXml, "value0") != "Y") { // 전표 미발행시
		        		ComShowCodeMessage("SAP00023", "[" + bank_acct_nm + "]" ); 		        		
		        		return false;
		        	}		        	
		        }	
				
				//정산여부 CHECK (APPLY 된 데이타는 삭제하지 못한다.)	
				var sXml2=sheetObject1.GetSearchData("STM_SAP_0060GS.do", "f_cmd=" + COMMAND04 + "&hid_pay_seq=" + pay_seq);
				if (SAPDecideErrXml(sheetObject1, sXml2)) {
					sheetObject1.SelectCell(row, prefix1 + "pay_seq", true, "");
		        } else {	
		        	if(ComGetEtcData(sXml2, "apply_yn") == "Y") { 
		        		ComShowCodeMessage("SAP00061" ); 
		        		return false;
		        	}		        	
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
		//axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
		axon_event.addListenerForm('keyup',    'obj_keyup',   	formObj);
		axon_event.addListenerForm('blur', 'obj_deactivate', formObj);   //beforedeactivate   deactivate
		axon_event.addListenerFormat('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}
    /**
     * Form Element의 keypress 이벤트
     */  
	/*function obj_keypress() {		
		switch(ComGetEvent().dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				ComKeyOnlyAlphabet('uppernum');
				break;	
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(ComGetEvent());
				break;				
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "float":
				ComKeyOnlyNumber(ComGetEvent(), "-.");
				break;
			default:
				//common standard: recognization only number, english
				//ComKeyOnlyAlphabet("num");
				break;     
		}
	}    */
    /** 
     * handling keyup event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
	}  
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
		ComChkObjValid(ComGetEvent());
		var obj=ComGetEvent();
	    var formObj=document.form;
		switch(ComGetEvent("name")){ 	    	
	   		case "to_dt":
	   			ComAddSeparator(obj, "ymd");
	   			break;
	   		case "fr_dt":
	   			ComAddSeparator(obj, "ymd");
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
			/*case "vndr_no":
				var vndr_no=formObj.vndr_no.value;
				formObj.vndr_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
		    	break;*/
				
			case "ofc_cd":
				var office_code=formObj.ofc_cd.value;
				formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
				break;
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
			var pay_dt=sheetObj.GetCellValue(Row, prefix + "pay_dt");
			var ofc_cd=sheetObj.GetCellValue(Row, prefix + "ofc_cd");
			if ( pay_dt.length > 0 && ofc_cd.length > 0 ) {
				var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + pay_dt + "&value1=" + ofc_cd);
				if (SAPDecideErrXml(sheetObj, xmlStr)) {
					SetCellValue(Row, Col, "");
	                SelectCell(Row, Col, true, "");
	                return false;
	            } else {
	                var chk_period=ComGetEtcData(xmlStr, "chk_period");
	                if ( chk_period != "O") {
	                	ComShowCodeMessage("SAP00001", pay_dt, ofc_cd);  // pay_dt,, ofc_cd can't open.
	                	sheetObj.SetCellValue(Row, prefix + "period_chk","N",0);
	                	sheetObj.SetCellValue(Row, prefix + "pay_dt","");
	                	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt","");
	                	//SetCellValue(Row, Col, "");
	                	sheetObj.SelectCell(Row, Col, true, "");
	                	return false;
	                } else  {
	                	sheetObj.SetCellValue(Row, prefix + "period_chk","Y",0);
	                	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",pay_dt,0);//Rate Date
	                	return true;
	                }
	            }
			}
			return true;
		} 
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	var sheetObj=sheetObjects[ShtIdx];
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
	               	case prefix + "vndr_nm":	
	               	case prefix + "vndr_no":	
	                	//clear
	               		sheetObj.SetCellValue(Row, prefix + "vndr_no","",0);
	                	sheetObj.SetCellValue(Row, prefix + "vndr_nm","",0);
	                	sheetObj.SetCellValue(Row, prefix + "pay_cnt_cd","",0);
	                	//setting
	                	sheetObj.SetCellValue(Row, prefix + "vndr_no",aryPopupData[0][1]);
	                	sheetObj.SetCellValue(Row, prefix + "vndr_nm",aryPopupData[0][2]);
	                	sheetObj.SetCellValue(Row, prefix + "pay_cnt_cd",aryPopupData[0][6]);
	                	break;   
	               	case prefix + "bank_acct_nm":
	                	//clear
	               		sheetObj.SetCellValue(Row, prefix + "bank_acct_nm","",0);
	               		sheetObj.SetCellValue(Row, prefix + "bank_acct_seq","",0);
	               		sheetObj.SetCellValue(Row, prefix + "bank_acct_no","",0);
	               		sheetObj.SetCellValue(Row, prefix + "curr_cd","",0);
	               		sheetObj.SetCellValue(Row, prefix + "pay_amt","",0);
	                	//setting
	                	sheetObj.SetCellValue(Row, prefix + "bank_acct_nm",aryPopupData[0][1]);
	                	sheetObj.SetCellValue(Row, prefix + "bank_acct_seq",aryPopupData[0][3]);
	                	sheetObj.SetCellValue(Row, prefix + "bank_acct_no",aryPopupData[0][2]);
	                	sheetObj.SetCellValue(Row, prefix + "curr_cd",aryPopupData[0][4]);
	               		break;
	               	case prefix + "remit_to_acct_no":
	               		sheetObj.SetCellValue(Row, prefix + "remit_to_acct_no","",0);
	               		sheetObj.SetCellValue(Row, prefix + "xter_bank_acct_seq","",0);
	               		sheetObj.SetCellValue(Row, prefix + "remit_to_acct_no",aryPopupData[0][1]);
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
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function setPopupData2(aryPopupData, Row, Col, ShtIdx) {	
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	var sheetObj=sheetObjects[ShtIdx];
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
	               	case prefix + "inv_no":	
	                	//clear
	               		sheetObj.SetCellValue(Row, prefix + "inv_no","",0);
	               		sheetObj.SetCellValue(Row, prefix + "inv_dt","",0);
	               		sheetObj.SetCellValue(Row, prefix + "inv_amt","",0);
	               		sheetObj.SetCellValue(Row, prefix + "acctg_dt","",0);
	               		sheetObj.SetCellValue(Row, prefix + "inv_desc","",0);
	               		sheetObj.SetCellValue(Row, prefix + "pay_amt","",0);
	               		sheetObj.SetCellValue(Row, prefix + "liab_cd_cmb_seq","",0);
	               		sheetObj.SetCellValue(Row, prefix + "xter_bank_acct_seq","",0);
	               		sheetObj.SetCellValue(Row, prefix + "remit_vndr_no","",0);
	               		sheetObj.SetCellValue(Row, prefix + "pay_skd_no","",0);
	               		sheetObj.SetCellValue(Row, prefix + "inv_seq","",0);
	                	//setting
	                	sheetObj.SetCellValue(Row, prefix + "inv_no",aryPopupData[0][1]);
	                	sheetObj.SetCellValue(Row, prefix + "inv_dt",aryPopupData[0][5]);
	                	sheetObj.SetCellValue(Row, prefix + "inv_amt",aryPopupData[0][8]);
	                	sheetObj.SetCellValue(Row, prefix + "acctg_dt",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), sheetObjects[0].id + "_pay_dt"));
	                	sheetObj.SetCellValue(Row, prefix + "inv_desc",aryPopupData[0][7]);
	                	sheetObj.SetCellValue(Row, prefix + "pay_amt",aryPopupData[0][3]);
	               		sheetObj.SetCellValue(Row, prefix + "liab_cd_cmb_seq",aryPopupData[0][9]);
	               		sheetObj.SetCellValue(Row, prefix + "xter_bank_acct_seq",aryPopupData[0][10]);
	               		sheetObj.SetCellValue(Row, prefix + "remit_vndr_no",aryPopupData[0][11]);
	               		sheetObj.SetCellValue(Row, prefix + "pay_skd_no",aryPopupData[0][2],0);
	               		sheetObj.SetCellValue(Row, prefix + "inv_seq",aryPopupData[0][12],0);
	                	break;   
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                }
            }
        }		
	}
    /**
     * Header sheet's Pay amount point format setting   
     */      
    function settingPointFormat(sheetObj, Row) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var f_curr_prcs=parseInt(ComNullToZero(formObj.hid_func_curr_prcs.value),10);	
		var pay_curr_prcs=null;
		var pay_amt=sheetObj.ComputeSum("|"+prefix + "pay_amt" +"|", Row, Row);
		if("sheet1" == sheetID) {
			pay_curr_prcs=parseInt(ComNullToZero(sheetObj.GetCellValue(Row, prefix + "pay_curr_prcs")),10);
		}
		else if ("sheet2" == sheetID) {
			var mainRow=sheetObjects[0].GetSelectRow();
			pay_curr_prcs=parseInt(ComNullToZero(sheetObjects[0].GetCellValue(mainRow, sheetObjects[0].id + "_pay_curr_prcs")),10);
		}
		//pay_amt 설정
		//if(pay_curr_prcs == 0)  sheetObj.InitCellProperty(Row, prefix + "pay_amt", dtData, daRight, prefix + "pay_amt", "", dfInteger);
		//else sheetObj.InitCellProperty(Row, prefix + "pay_amt", dtData, daRight, prefix + "pay_amt", "", dfNullFloat, pay_curr_prcs);
		sheetObj.SetCellValue(Row, prefix + "pay_amt",SAPComAddComma2( ComRound(pay_amt, pay_curr_prcs) + '', pay_curr_prcs) ,0);
		//pay_func_amt 설정
		if(f_curr_prcs == 0)  sheetObj.InitCellProperty(Row, prefix + "pay_func_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
		else sheetObj.InitCellProperty(Row, prefix + "pay_func_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:f_curr_prcs} );
		if ("sheet2" == sheetID) {
			//inv_amt 설정
			if(pay_curr_prcs == 0)  sheetObj.InitCellProperty(Row, prefix + "inv_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
			else sheetObj.InitCellProperty(Row, prefix + "inv_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:pay_curr_prcs} );
		}
    }
    function rdOpen( formObj, print_seq){
        var rdParam='/rp '+setRDParamStr(print_seq);
        var strPath="apps/opus/stm/sap/accountpayablepayment/accountpayablepayment/report/STM_SAP_1002.mrd";
        formObj.com_mrdPath.value=strPath;
        formObj.com_mrdArguments.value=rdParam;
        ComOpenRDPopupModal();
    }   
    function setRDParamStr(print_seq){
    	var rdParamStr="";
        var formObj=document.form;   
        rdParamStr += " ["+formObj.ofc_cd.value+"]";
        rdParamStr += " ["+formObj.fr_dt.value+"]";
        rdParamStr += " ["+formObj.to_dt.value+"]";
        rdParamStr += " ["+formObj.vndr_pay_grp_cd.value+"]";
        rdParamStr += " ["+formObj.pay_mzd_lu_cd.value+"]";        
        rdParamStr += " ["+print_seq+"]";
        return rdParamStr;
    }   
    
    function resizeSheet(){
        for (i=1; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
   
    
    function tab_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
        objs[beforetab].style.display="none";
        objs[nItem].style.display="Inline";
        beforetab=nItem;
        resizeSheet();
    }      

    function chkXRate(Col, Row) {
    	
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	//var Row =  sheetObj.GetSelectRow();
    	var prefix = sheetObj.id+ "_";

		var curr_cd=sheetObj.GetCellValue(Row, prefix + "curr_cd");
		var pay_dt=sheetObj.GetCellValue(Row, prefix + "pay_xch_dt");
  		var f_curr_cd=formObj.hid_func_curr_cd.value;
  		var f_curr_prcs=formObj.hid_func_curr_prcs.value;
  		
		if (curr_cd != f_curr_cd) { //환율과 functional 환율이 다를 때.
			var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + pay_dt + "&value1=" + curr_cd + "&value2=" + f_curr_cd);
			 if (SAPDecideErrXml(sheetObj, xmlStr)) { 
				 SetCellValue(Row, Col, "");
                 SelectCell(Row, Col, true, "");
                 return false;
             } else {
                 var x_rate=ComGetEtcData(xmlStr, "x_rate");
                 var x_date=ComGetEtcData(xmlStr, "x_date");
                 var x_type=ComGetEtcData(xmlStr, "x_type");
                 var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                 if ( x_rate != "NO_DATA") {
                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt",x_rate,0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",x_date,0);
                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd",x_type,0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs",x_prcs,0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_func_amt","",0);
                 } else  {
                 	ComShowCodeMessage("SAP00002", pay_dt, curr_cd);  // currency 없음 
                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt","",0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt","",0);
                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd","",0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs","",0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_func_amt","",0);
                 	SetCellValue(Row, Col, "");
                 	SelectCell(Row, Col, true, "");
                 	return false;
                 }
             }
		} else {  //환율과 functional 환율이 같을 때          				
         	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt",1,0);
         	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",sheetObj.GetCellValue(Row, prefix + "pay_dt"),0);
         	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd","1",0);
         	sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs",f_curr_prcs,0);
         	sheetObj.SetCellValue(Row, prefix + "pay_func_amt","",0);
		}

  		return true;
		
    }    