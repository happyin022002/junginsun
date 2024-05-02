/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0210.js
*@FileTitle  : Invoices
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
     * @class Invoices : business script for STM_SAP_0210
     */
//    function stm_sap_0210() {
//    	this.processButtonClick=processButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
	var focusObj=null;
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheetObject1;
	var sheetObject2;
    var prefix1; 
	var prefix2;
	var save_pay_bat_seq;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheet1ChnFlag="N";		//sheet1 change Flag
	var editMainRow=1; 
	var searchRow;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*******************************************************/
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
     	try {
			var srcName=ComGetEvent("name");
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
				case "btn_capture":
			    	var mainRow=sheetObject1.GetSelectRow();
			    	if (mainRow == -1 || sheetObject1.CheckedRows(prefix1+ "chk_flg") == 0 ) {
			    		ComShowCodeMessage("SAP00009");  
			    		break;
			    	}
			    	if (sheet1ChnFlag == "N" && sheetObject2.IsDataModified()== false ) {
			    		doActionIBSheet(sheetObject1, formObj, MULTI03);
			    	} else {
			    		ComShowCodeMessage("SAP00044");  
			    		break;
			    	}		    		
					break;	
				case "btn_payConfirm":
			    	var mainRow=sheetObject1.GetSelectRow();
			    	if (mainRow == -1 || sheetObject1.CheckedRows(prefix1+ "chk_flg") == 0 ) {
			    		ComShowCodeMessage("SAP00009");  
			    		break;
			    	}
			    	if (sheet1ChnFlag == "N" && sheetObject2.IsDataModified()== false ) {
			    		doActionIBSheet(sheetObject1, formObj, MULTI04);
			    	} else {
			    		ComShowCodeMessage("SAP00044");  
			    		break;
			    	}
					break;	
				case "btns_search_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
					break;	
				case "btns_search_paygroup":
					var param="?lu_cd=" + encodeURIComponent(formObj.vndr_pay_grp_cd.value)+"&attr_ctnt1=" + formObj.ofc_cd.value;
					ComOpenPopup("STM_SAP_0004.do"+param, 400, 420, "setPayGroup", "0,0", true, false);
					break;	
				case "btns_search_batch":
					var param="?pay_bat_nm=" + encodeURIComponent(formObj.pay_bat_nm.value);
					ComOpenPopup("STM_SAP_0211.do"+param, 700, 420, "setBatchNm", "0,0", true, false);
					break;	
				case "btns_search_bankAccount":
					var param="?bank_acct_tp_nm=INTERNAL&bank_acct_nm=" + encodeURIComponent(formObj.bank_acct_nm.value);
					ComOpenPopup("STM_SAP_0063.do"+param, 700, 420, "setBankAccount", "0,0", true, false);
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
					if(searchRow== 0) {
						sheet1ChnFlag="N";
						sheetObject1.RemoveAll();
					}
					if (sheet1ChnFlag == "N" && sheetObject2.IsDataModified()== false ) {
						var row=sheetObject1.DataInsert(-1);
						sheetObject1.SetRowEditable(row,1);
						sheetObject1.SetCellValue(row, prefix1 + "chk_flg","1");
						sheetObject1.SetCellValue(row, prefix1 + "ofc_cd",formObj.login_ap_ofc.value);
						sheetObject1.SetCellValue(row, prefix1 + "pay_thru_dt",formObj.sys_curr_date.value);
						sheetObject1.SetCellValue(row, prefix1 + "pay_dt",formObj.sys_curr_date.value);
						sheetObject1.SetCellValue(row, prefix1 + "low_pay_prio_no","0");
						sheetObject1.SetCellValue(row, prefix1 + "high_pay_prio_no","99");
						sheetObject2.RemoveAll();
					} else {
						 if (ComShowCodeConfirm("COM130504")) {   
							 doActionIBSheet(sheetObject1, formObj, MULTI01);
							 break;
	                     } else {
	                    	 sheetObject1.ReturnData(editMainRow);
	                     }
					}
 					break;
				case "btn_sheet1RowDelete":
					if(sheetObject1.GetSelectRow()< 0) {
						break;
					}
					var row=sheetObject1.GetSelectRow();
					var pay_status=sheetObject1.GetCellValue(row, prefix1 + "pay_sts_cd");
					if(sheetObject1.GetCellValue(row, prefix1 + "pay_bat_seq") == "" || pay_status == "NEW") {
						sheetObject1.SetRowHidden(row,1);
						sheetObject1.SetRowStatus(row,"D");
					} else {
						ComShowCodeMessage("SAP00045");
						break;
					}
					sheet1ChnFlag="Y";
					break; 				
				case "btn_sheet1Save":
			    	var mainRow=sheetObject1.GetSelectRow();
			    	if (mainRow == -1 || sheetObject1.CheckedRows(prefix1+ "chk_flg") == 0 ) {
			    		ComShowCodeMessage("SAP00009");  
			    		break;
			    	}
					doActionIBSheet(sheetObject1, formObj, MULTI01);
					break;					 			
				case "btn_sheet2RowAdd":
					var mainRow=sheetObject1.GetSelectRow();
					var pay_status=sheetObject1.GetCellValue(mainRow, prefix1 + "pay_sts_cd");
					if (chkValidHeader() && (  "NEW" == pay_status ||  "CAPTURE" == pay_status ||  "" == pay_status ) ) {
						if ( "I" == sheetObject1.GetCellValue(mainRow, prefix1 + "ibflag") ) {
			    			ComShowCodeMessage("SAP00043");  
				    		break;
			    		}						
						var row=sheetObject2.DataInsert(-1);
						sheetObject2.SelectCell(row, prefix2+ "inv_no", true, "");
						sheetObject2.SetCellEditable(row, prefix2 + "inv_no",true);
			    	} 
 					break;
				case "btn_sheet2RowDelete":
					if(sheetObject2.GetSelectRow()< 0) {
						break;
					}
					var mainRow=sheetObject1.GetSelectRow();
					var pay_status=sheetObject1.GetCellValue(mainRow, prefix1 + "pay_sts_cd");
					if ( "SUCCESS" != pay_status) {
						if (ComShowCodeConfirm("COM12165")) {  
							var row=sheetObject2.GetSelectRow();
							sheetObject2.SetRowHidden(row,1);
							sheetObject2.SetRowStatus(row,"D");
						}
					}
					break; 	
				case "btn_sheet2Save":
					doActionIBSheet(sheetObject2, formObj, MULTI02);
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
		initControl();
		this.sheetObject1=sheetObjects[0];
		this.sheetObject2=sheetObjects[1];
	    this.prefix1=sheetObject1.id + "_"; 
	    this.prefix2=sheetObject2.id + "_";
	    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	    
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
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // hidden sheet (header) 
				with (sheetObj) {
			        var HeadTitle1="|Chk|Batch ID|Batch Name|Office|Pay Through To Date|Payment Date|Pay Period Name|Priority Low|Priority High|Pay Group|Bank Account Name|Bank Account No|Bank Account ID|Curr|Payment Method|Include Only Due|Include Zero Payment|Supplier Code|Supplier Name|Payment Status|Exchange Rate Type Code|Exchange Rate Type|Exchange Date|Exchange Rate|Document Number";
			        HeadTitle1=HeadTitle1 + "|ATTR_CATE_NM|ATTR_CTNT1|ATTR_CTNT2|ATTR_CTNT3|ATTR_CTNT4|ATTR_CTNT5|ATTR_CTNT6|ATTR_CTNT7|ATTR_CTNT8|ATTR_CTNT9|ATTR_CTNT10|ATTR_CTNT11|ATTR_CTNT12|ATTR_CTNT13|ATTR_CTNT14|ATTR_CTNT15|Start Doc Number|End Doc Number|First Available Doc No|Zero Invoice allow Flag|Future Date Payment Flag";
			        HeadTitle1=HeadTitle1 + "|period_chk";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			               {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_flg" },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_bat_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_bat_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_thru_dt",        KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",             KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_prd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"low_pay_prio_no",    KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"high_pay_prio_no",   KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_pay_grp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_curr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_ony_due_dt_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"zr_amt_alw_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xch_rt_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xch_rt_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_xch_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,  UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
			               {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_doc_no",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_cate_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt8",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt9",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt10",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt11",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt12",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt13",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt14",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt15",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"st_prn_doc_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"end_prn_doc_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"n1st_aval_doc_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"zr_inv_alw_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ftu_dt_pay_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"period_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			        InitColumns(cols);
			        SetEditable(1);
			        SetColProperty(0 ,prefix + "ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
			        SetColProperty(prefix+"pay_ony_due_dt_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
			        SetColProperty(prefix+"zr_amt_alw_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
			        SAPInitDataCurrCombo(sheetObj, prefix + "pay_curr_cd", "1", " " , " ") ;
			        SetColHidden(prefix + "chk_flg",1);
			        SapInitDataCombo(sheetObj, prefix + "pay_mzd_lu_cd", "2", " " , " ", "PAYMENT METHOD" , "", 1) ;
			        InitComboNoMatchText(true);
			        SetSheetHeight(200);
		    	}
			break;		
			case 2:      // apply sheet
				with (sheetObj) {
			        var HeadTitle1="|CSR Number|Invoice ID|Invoice Date|Vendor|Vendor Name|Curr|Amount|G/L Date|Description|Payment Amount|Account No|Payment Batch Sequence|Payment Batch Name|Payment Schedule No";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_bat_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_bat_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_skd_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			        InitColumns(cols);
			        SetEditable(1);
			        SetSheetHeight(180);
					break;
			}
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if(!validateForm(sheetObj,formObj,sAction)){
			return false;
		}
		
		this.sheetObject1=sheetObjects[0];
		this.sheetObject2=sheetObjects[1];
		
		switch (sAction) {
			case COMMAND01: // RETRIEVE INIT VALUES
 				var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH01);
				var apLoginOfc=ComGetEtcData(sXml, "ap_ofc_cd");
				var apLoginCurr=ComGetEtcData(sXml, "ar_curr_cd");
				formObj.ofc_cd.value=apLoginOfc;
				formObj.login_curr_cd.value=apLoginCurr;
				formObj.login_ap_ofc.value=apLoginOfc;
				var localTime=SapGetLocDate(sheetObj);
				var localStartTime=localTime.substr(0,6) + "01";
				formObj.fr_dt.value=ComGetMaskedValue(localStartTime, "ymd");				
				formObj.to_dt.value=ComGetMaskedValue(localTime, "ymd");
				var tmpArray=SapGetFunctionalCurrencyCode(sheetObj);
				formObj.f_curr.value=tmpArray[0];
				formObj.f_curr_prcs.value=tmpArray[1];
				ComBtnDisable("btn_capture");
				ComBtnDisable("btn_payConfirm");
				break;
			case IBSEARCH: // RETRIEVE 
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0210GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case SEARCH02: // RETRIEVE DETAIL
				formObj.f_cmd.value=SEARCH02;
				sheetObject2.RemoveAll();
				var pay_bat_nm=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), prefix1 + "pay_bat_nm");
				var pay_bat_seq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), prefix1 + "pay_bat_seq");
				var sParam="f_cmd=" + SEARCH02 + "&pay_bat_seq="+pay_bat_seq + "&pay_bat_nm=" + pay_bat_nm + "&" + ComGetPrefixParam(prefix);
				var sXml=sheetObject2.GetSearchData("STM_SAP_0210GS.do", sParam);
				sheetObject2.LoadSearchData(sXml,{Sync:1} );
				break;
			case IBROWSEARCH: // RETRIEVE LINE CSRNo DATA 
				var inv_no=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), prefix2 + "inv_no");
				var pay_bat_nm=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), prefix1 + "pay_bat_nm");
				var pay_bat_seq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), prefix1 + "pay_bat_seq");
//				var sParam=("f_cmd=" + SEARCH03 + "&Row=" + sheetObject2.SetSelectRow+"&pay_bat_seq="+pay_bat_seq + "&pay_bat_nm=" + pay_bat_nm + "&inv_no=" + inv_no + "&" + ComGetPrefixParam(prefix));
				var sParam = "f_cmd=" + SEARCH03 + "&Row=" + sheetObject2.GetSelectRow() +"&pay_bat_seq="+pay_bat_seq + "&pay_bat_nm=" + pay_bat_nm + "&inv_no=" + inv_no + "&" + ComGetPrefixParam(prefix);
 				var sXml=sheetObject2.GetSearchData("STM_SAP_0210GS.do", sParam);
				if (!SAPComEtcDataXmlToSheet(sXml, sheetObj, sheetObject2.GetSelectRow(), "", prefix2) ) {
					ComShowCodeMessage("SAP00015", inv_no); 
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), prefix2 + "inv_no","",0);
					break;
				}	
				break;	
			case MULTI01: // HEADER SAVE
				formObj.f_cmd.value=MULTI01;
				//var sParam = sheetObj.RowSaveStr(sheetObject1.SelectRow) + "&" +FormQueryString(formObj);
				var sParam=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam == "" ){
					return;
				}
				sParam += "&" +FormQueryString(formObj);
				ComOpenWait(true);
 				var sXml=sheetObject1.GetSaveData("STM_SAP_0210GS.do", sParam);
 				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				this.save_pay_bat_seq=ComGetEtcData(sXml, "pay_bat_seq");
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
			case MULTI02: // DETAIL SAVE
				formObj.f_cmd.value=MULTI02;
				if(sheetObject1.GetSelectRow()==-1)
					return;
				var sParam1=sheetObject1.RowSaveStr(sheetObject1.GetSelectRow());
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				if(sParam2 == "" ){
					return;
				}
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("STM_SAP_0210GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
                if (SAPDecideErrXml(sheetObj, sXml)) return;
                this.save_pay_bat_seq=ComGetEtcData(sXml, "pay_bat_seq");
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
			case MULTI03: // CAPTURE
				formObj.f_cmd.value=MULTI03;
				var sParam1=sheetObject1.RowSaveStr(sheetObject1.GetSelectRow());
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("STM_SAP_0210GS.do", sParam);
 				sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
                if (SAPDecideErrXml(sheetObj, sXml)) return;
                this.save_pay_bat_seq=ComGetEtcData(sXml, "pay_bat_seq");
                var updPayStsCd=ComGetEtcData(sXml, "pay_sts_cd");  //CAPTURE or CANCELLED NO PAYMENTS
				if (updPayStsCd != "CAPTURE" ) { 
					ComShowCodeMessage("SAP00047");
				}
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
			case MULTI04: // PAY CONFIRM
				formObj.f_cmd.value=MULTI04;
				var sParam1=sheetObject1.RowSaveStr(sheetObject1.GetSelectRow());
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("STM_SAP_0210GS.do", sParam);
 				sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
                this.save_pay_bat_seq=ComGetEtcData(sXml, "pay_bat_seq");
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
			case SEARCH02: // BATCH NAME CHECK
				formObj.f_cmd.value=COMMAND01;
				var sXml=sheetObj.GetSearchData("STM_SAP_0210GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;
			case SEARCH03: // SEARCH INV DATA 
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("STM_SAP_0210GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;	
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetObject1=sheetObjects[0];
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
			case MULTI01: //SAVE HEADER
				if ("" != sheetObject1.GetSaveString(false, false, prefix1+ "chk_flg")) {  // sheet1의 필수항목체크
					if (!ComChkValid(formObj)) return false;
					if (sheet1ChnFlag == "Y" || sheetObject2.IsDataModified()== true ) {
						if ( !chkValidHeader() ) return false;
					}
				} else {
		    		return false;
		    	}
				break;
			case MULTI03:  //CAPTURE
				if ( !chkValidHeader() ) return false;
				// Check Duplicate CSR_No
				var dupRow=sheetObject2.ColValueDup(prefix2+"inv_no");
	            if(dupRow != -1) {
	            	ComShowCodeMessage("COM131302", "CSR Number");
	            	sheetObject2.SetSelectRow(dupRow);
	            	return false;
	            }
				break;
			case MULTI04:  //CONFIRM
				if ( !chkValidHeader() ) return false;
				if (sheetObject2.SearchRows()== 0) {
					ComShowCodeMessage("SAP00015", " to confrim.");
					return false;
				}
				// Check Duplicate CSR_No
				var dupRow=sheetObject2.ColValueDup(prefix2+"inv_no");
	            if(dupRow != -1) {
	            	ComShowCodeMessage("COM131302", "CSR Number");
	            	sheetObject2.SetSelectRow(dupRow);
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
// 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
// 		axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
 		axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObj);   //blur  beforedeactivate  
 		axon_event.addListenerFormat('focus', 'obj_activate', formObj);
 		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
// 		axon_event.addListener('change', 'bank_acct_nm_onchange', 'bank_acct_nm', '');	
	}
    /**
     * Form Element의 keypress 이벤트
     */  
	function obj_keypress() {
		switch(event.srcElement.dataformat){
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
			case "ym":
				ComKeyOnlyNumber(ComGetEvent());
				break;	
			case "float":
				ComKeyOnlyNumber(ComGetEvent(), "-.");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(ComGetEvent());
		}
	}    
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
        switch(ComGetEvent("name")){ 	    	
	   		case "fr_dt":
	   			ComClearSeparator(ComGetEvent());        
	   			break;
	   		case "to_dt":
	   			ComClearSeparator(ComGetEvent());        
	   			break;	   		
		}        
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
		switch(ComGetEvent("name")){ 	    	
	   		case "fr_dt":
	   			ComAddSeparator(form.fr_dt, "ymd");
	   			ComChkObjValid(ComGetEvent());	
	   			break;
	   		case "to_dt":
	   			ComAddSeparator(form.to_dt, "ymd");
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
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {	
		searchRow = sheetObject1.SearchRows();
		sheet1ChnFlag="N";	
		if (ErrMsg != "") return;
		if ( sheetObj.RowCount()> 0 ) {
			var findRowIdx=sheetObj.FindText(prefix1 + "pay_bat_seq", save_pay_bat_seq);
			if (findRowIdx > -1) {
				sheetObj.SetSelectRow(findRowIdx);
				sheetObj.SetCellValue(findRowIdx, prefix1+"chk_flg","1",0);
				settingButtons(findRowIdx);
				searchDetailList(sheetObj, findRowIdx, 0);		
				sheetObj.SelectCell(findRowIdx,2);
				sheet1ChnFlag="N";				
			} else {
				sheetObj.SetCellValue(1, prefix1+"chk_flg","1",0);
				settingButtons(1);
				searchDetailList(sheetObj, 1, 0);
			}
		}
		//check editable
		for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
			var pay_status=sheetObject1.GetCellValue(i, prefix1 + "pay_sts_cd");
			if (pay_status == "NEW") {
				sheetObj.SetRowEditable(i,1);
			} else {
				sheetObj.SetRowEditable(i,0);
			}	
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
		if (Row != editMainRow) {
			if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I" &&   ( sheet1ChnFlag == "Y" || sheetObject2.IsDataModified()== true ) ) {
				if (ComShowCodeConfirm("COM130504")) {   
					 doActionIBSheet(sheetObject1, formObj, MULTI01);
					 return;
	           } else {
	        	   if( sheetObj.GetCellValue(editMainRow, prefix+"ibflag")!="I" ) {
	        		   sheetObject1.ReturnData(editMainRow);
	        		   sheetObject1.SetRowHidden(editMainRow,0);
	        	   } else {
	        		   sheetObject1.RowDelete(editMainRow, false);
	        	   }        		   
	        	   sheet1ChnFlag="N";
	           }
			} 
		}
		sheetObj.SetCellValue(Row, prefix+"chk_flg","1",0);
		settingButtons(Row);
		editMainRow=Row;
		if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I"  && ( sheetObj.GetCellValue(Row, prefix+"pay_bat_seq") != sheetObject2.GetCellValue(1, prefix2+"pay_bat_seq") ) ) {
	    	searchDetailList(sheetObject2, Row, Col);
	    }
	}		
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var param="";
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  prefix1 + "ofc_cd":    //Office
                	param="?ofc_cd=" + sheetObj.GetCellValue(Row, Col);
                	ComOpenPopup("STM_SAP_0001.do" + param, 400, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix1 + "pay_thru_dt":    //Pay Through To Date
                	var cal=new ComCalendarGrid();
                	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break; 
                case  prefix1 + "pay_dt":    //Payment Date
                	//var cal = new ComCalendarGrid(prefix2 + "pay_dt");
                	//cal.endFunction ="ComCalendar_EndFunction_pay_dt";
        			//cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
        			var cal=new ComCalendarGrid();
                	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;   
                case  prefix1 + "pay_mzd_lu_cd":    //Payment Method
                	param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col));
                	ComOpenPopup("STM_SAP_0007.do" + param, 500, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix1 + "bank_acct_nm":    //Bank Account No
                	param="?bank_acct_tp_nm=INTERNAL&bank_acct_nm=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&ofc_cd=" + sheetObj.GetCellValue(Row, prefix1 + "ofc_cd");
					ComOpenPopup("STM_SAP_0063.do"+param, 700, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
					break;		
                case  prefix1 + "bank_acct_no":    //Bank Account No
                	param="?bank_acct_tp_nm=INTERNAL&bank_acct_no=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&ofc_cd=" + sheetObj.GetCellValue(Row, prefix1 + "ofc_cd");
					ComOpenPopup("STM_SAP_0063.do"+param, 700, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
					break;	
                case  prefix1 + "pay_xch_dt":    //Exchange Date
                	var cal=new ComCalendarGrid();
                	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;  
                case  prefix1 + "vndr_no":    //Vendor
                	var param="?vndr_seq=" + sheetObj.GetCellValue(Row, Col) + "&delt_fla=N";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix1 + "vndr_pay_grp_cd":    //Pay Group
                	var param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&attr_ctnt1=" + sheetObj.GetCellValue(Row, prefix1 + "ofc_cd");
                	ComOpenPopup("STM_SAP_0004.do" + param, 400, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break; 
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
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
    	if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	var sheetObj=sheetObjects[ShtIdx];
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
                	case  prefix + "bank_acct_nm":    	//Bank Account Nm
                	case  prefix + "bank_acct_no":    	//Bank Account No
                		sheetObj.SetCellValue(Row, prefix + "bank_acct_nm",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, prefix + "bank_acct_no",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, prefix + "bank_acct_seq",aryPopupData[0][3]);
                    	sheetObj.SetCellValue(Row, prefix + "pay_curr_cd",aryPopupData[0][4]);
                    	break;
	                case  prefix + "ofc_cd":    		//Office
	                case  prefix + "pay_thru_dt":    	//Pay Through To Date
	                case  prefix + "pay_dt":    		//Payment Date
	                case  prefix + "pay_mzd_lu_cd":    //Payment Method	                
	                case  prefix + "pay_xch_dt":    	//Exchange Date
	                case  prefix + "vndr_no":    		//Vendor
	                case  prefix + "vndr_pay_grp_cd":  //Pay Group
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                }
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    }    
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (Value == "") return;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
        with (sheetObj) {
            switch (ColSaveName(Col)) {
            	case prefix + "pay_bat_nm":    // batch name
            		var pay_bat_nm=sheetObj.GetCellValue(Row, prefix + "pay_bat_nm");
 	            	var sXml=sheetObj.GetSearchData("STM_SAP_0210GS.do", "f_cmd=" + COMMAND01 + "&pay_bat_nm=" + pay_bat_nm );
	            	if (SAPDecideErrXml(sheetObj, sXml)) {
	            		sheetObj.SetCellValue(Row, Col, "");
	 					sheetObj.SelectCell(Row, Col, true, "");
	                 } else {
	                	 if ( pay_bat_nm != ComGetEtcData(sXml, "pay_bat_nm") ) {
	                		 ComShowCodeMessage("SAP00041", pay_bat_nm ); 
	                		 SetCellValue(Row, Col, "");
	                		 SelectCell(Row, Col, true, "");
	                		 break;		
	                	 } 	                	
	                 }
	            	break;
            	case prefix + "ofc_cd":    // office
                	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND07 + "&value0=" + sheetObj.GetCellValue(Row, prefix + "ofc_cd") );
                	if (SAPDecideErrXml(sheetObj, sXml)) {
                		sheetObj.SetCellValue(Row, Col, "");
     					sheetObj.SelectCell(Row, Col, true, "");
                     } else {
                    	 if ( "NO_DATA" == ComGetEtcData(sXml, "ofc_cd") ) {
                    		ComShowCodeMessage("COM132201", "Office Code" );  
                    		sheetObj.SetCellValue(Row, prefix + "ofc_cd", "");
         					sheetObj.SelectCell(Row, prefix + "ofc_cd", true, "");
         					break;		
                    	 } else {
                    		 sheetObj.SetCellValue(Row, prefix + "ofc_cd",ComGetEtcData(sXml, "ofc_cd"));
                    		 changeOfcAndGlDate(sheetObj, Row, Col);
                    	 }
                     }
                	break;
            	case prefix + "pay_dt":    // Payment Date
            		changeOfcAndGlDate(sheetObj, Row, Col);    
            		
            		var curr_cd=sheetObj.GetCellValue(Row,  prefix + "pay_curr_cd");
            		if (curr_cd != "") {
            			chkXRate(prefix + "pay_dt", Row);
            		}
            		
                	break;
                case prefix + "pay_curr_cd":    // Payment currency code	
                	var pay_curr_cd=sheetObj.GetCellValue(Row, prefix + "pay_curr_cd");
                	var pay_dt=sheetObj.GetCellValue(Row, prefix + "pay_dt");
                	var period_chk=sheetObj.GetCellValue(Row, prefix + "period_chk");
             		var f_curr_cd=formObj.f_curr.value;
             		if (pay_dt.length > 0 && pay_curr_cd.length > 0 && period_chk == "Y") {
             			if (pay_curr_cd != f_curr_cd) {
              				var xmlStr=GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + pay_dt + "&value1=" + pay_curr_cd + "&value2=" + f_curr_cd);
             				if (SAPDecideErrXml(sheetObj, xmlStr)) {
             					 SetCellValue(Row, Col, "");
                                 SelectCell(Row, Col, true, "");
                                 break;
                             } else {
                                 var x_rate=ComGetEtcData(xmlStr, "x_rate");
                                 var x_date=ComGetEtcData(xmlStr, "x_date");
                                 var x_type=ComGetEtcData(xmlStr, "x_type");
                                 var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                                 if ( x_rate != "NO_DATA") {
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt",x_rate,0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",x_date,0);
                                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd",x_type,0);
                                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_nm","Corporate",0);
                                 } else  {
                                 	ComShowCodeMessage("SAP00002", pay_dt, pay_curr_cd);  // currency 없음 
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_nm","",0);
                                 	SetCellValue(Row, Col, "");
                                 	SelectCell(Row, Col, true, "");
                             		break;
                                 }
                             }
             			} else {
             				sheetObj.SetCellValue(Row, prefix + "pay_xch_rt","",0);
                         	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt","",0);
                         	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd","",0);
                         	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_nm","",0);
             			}
             		} 
            		break;	
            	case prefix + "vndr_no":    		// vndr_no
            		var vndr_no=sheetObj.GetCellValue(Row, prefix + "vndr_no") ;
            		// Vendor Information
                	var vendorParam="&delt_flg=N&vndr_seq=" + vndr_no;
                 	var sXml2=sheetObj.GetSearchData("STM_SAP_0002GS.do", "f_cmd=" + SEARCH + vendorParam);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
        				break;
        			} else {      
        				if ("NO_DATA" == ComGetEtcData(sXml2, "vndr_lgl_eng_nm") ) {        					
        					ComShowCodeMessage("COM132201", "Supplier Code" ); 
        					sheetObj.SetCellValue(Row, prefix + "vndr_no", "");
        					sheetObj.SelectCell(Row, prefix + "vndr_no", true, "");
        					break;				
        				} else { 
	        				sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm",ComGetEtcData(sXml2, "vndr_lgl_eng_nm"));
		                }
                	}
            		break;
            	case prefix + "vndr_pay_grp_cd":    // Pay Group
            		var param="&lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&attr_ctnt1=" + sheetObj.GetCellValue(Row, prefix1 + "ofc_cd");
                 	var sXml2=sheetObj.GetSearchData("STM_SAP_0004GS.do", "f_cmd=" + SEARCH + param);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
                		SetCellValue(Row, Col, "");
               		 	SelectCell(Row, Col, true, "");
        				break;
        			} else {      
        				if (Value != ComGetEtcData(sXml2, "lu_cd")) {        					
        					ComShowCodeMessage("COM132201", "Pay Group" );   
        					SetCellValue(Row, Col, "");
                   		 	SelectCell(Row, Col, true, "");
        					break;					
        				} 
        			} 
                	break;
            	case prefix + "pay_mzd_lu_cd":    // Payment Method
            		var chkVal=SAPChkLookupOneData(sheetObj, "&lu_tp_cd=PAYMENT METHOD&lu_cd="+Value);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Payment Method" );   
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	} 
            		changeBankAndMethod(sheetObj, Row, Col);            	
            		break;  
            	case prefix + "bank_acct_nm":    // Bank Account Nm	
            	case prefix + "bank_acct_no":    // Bank Account No
            		var bank_no=sheetObj.GetCellValue(Row, prefix + "bank_acct_no");
            		var bank_nm=sheetObj.GetCellValue(Row, prefix + "bank_acct_nm");
            		var ofc_cd=sheetObj.GetCellValue(Row, prefix + "ofc_cd");
             		var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND01  + "&value1=" + bank_nm+ "&value2=" + bank_no + "&value3=" + ofc_cd);
                	if (SAPDecideErrXml(sheetObj, sXml)) {
                		sheetObj.SetCellValue(Row, Col, "");
     					sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                    	 if ( "NO_DATA" == ComGetEtcData(sXml, "bank_acct_no") ) {
                    		ComShowCodeMessage("COM132201", "Bank Account" );  
                    		sheetObj.SetCellValue(Row, prefix + "bank_acct_seq","");
                    		sheetObj.SetCellValue(Row, prefix + "bank_acct_no","");
                    		sheetObj.SetCellValue(Row, prefix + "bank_acct_nm","");
                    		SetCellValue(Row, Col, "");
                    		SelectCell(Row, Col, true, "");
         					break;		
                    	 }
                    }            		
            		break;     
            	case prefix + "bank_acct_seq":    // Bank Account Seq
            		changeBankAndMethod(sheetObj, Row, Col);          
                    break;      		
            }
        }
        sheet1ChnFlag="Y";
        editMainRow=Row;
	}
	/**
     * BATCH Condition Grid(Sheet1)의 상태에 따른 버튼 활성화/비활성화
     */	  	
	function settingButtons(Row) {
		var pay_sts_cd=sheetObject1.GetCellValue(Row, prefix1+"pay_sts_cd");
		if("NEW" == pay_sts_cd ) {
			ComBtnEnable("btn_capture");
			ComBtnDisable("btn_payConfirm");
		} else if("CAPTURE" == pay_sts_cd ) {
			ComBtnEnable("btn_payConfirm");
			ComBtnDisable("btn_capture");
		} else {
			ComBtnDisable("btn_payConfirm");
			ComBtnDisable("btn_capture");
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
                	ComShowCodeMessage("SAP00001", pay_dt, ofc_cd);  // inv_dt,, ofc_cd can't open.
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
	/**
     * IBSeet내의 데이터 중 ofc_cd 와 gl_date 변경시 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	   
    function changeBankAndMethod(sheetObj, Row, Col) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var bank_acct_seq=sheetObj.GetCellValue(Row, prefix + "bank_acct_seq");
		var pay_method=sheetObj.GetCellValue(Row, prefix + "pay_mzd_lu_cd");
		if ( bank_acct_seq.length > 0 && pay_method.length > 0 ) {
 			var sXml=sheetObj.GetSearchData("STM_SAP_0210GS.do", "f_cmd=" + COMMAND02 + "&value1=" + bank_acct_seq+ "&value2=" + pay_method );
        	if (SAPDecideErrXml(sheetObj, sXml)) {
        		    sheetObj.SetCellValue(Row, Col, "");
					sheetObj.SelectCell(Row, Col, true, "");
             } else {
            	 if ( "0" != ComGetEtcData(sXml, "cnt") ) {
            		 ComShowCodeMessage("SAP00042"); 
            		 sheetObj.SetCellValue(Row, Col, "");
            		 sheetObj.SelectCell(Row, Col, true, "");
            		 return;		
            	 } 	                	
             }
		}
		return;
    }    
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
        with (sheetObj) {
            switch (ColSaveName(Col)) {
                case prefix2 + "inv_no":
                	doActionIBSheet(sheetObject2,formObj,IBROWSEARCH);
                    break;    				    				
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    }
    /**
     * Header Sheet를 click 하거나 최초 조회시 발생
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @return 없음.
     */  
    function searchDetailList(sheetObj, row, col) {
		var formObj=document.form
   	    var sheetObject2=sheetObjects[1];
		sheetObject2.RemoveAll();
		with(sheetObject2){
	        doActionIBSheet(sheetObject2,formObj,SEARCH02);
	        return;
		}
    }
    /**
     * check selected header information
     */      
    function chkValidHeader() {
    	var formObj=document.form;
    	var mainRow=sheetObject1.GetSelectRow();
    	if (mainRow == -1 || sheetObject1.CheckedRows(prefix1+ "chk_flg") == 0 ) {
    		ComShowCodeMessage("SAP00009");  
    		return false;
    	}
    	if (!ComChkValid(formObj)) return false;
    	if ("" != sheetObject1.GetSaveString(false, false, prefix1+ "chk_flg")) {  // sheet1의 필수항목체크
    		// Check Duplicate CSR_No
			var dupRow=sheetObject1.ColValueDup(prefix1+"pay_bat_nm");
            if(dupRow != -1) {
            	ComShowCodeMessage("COM131302", "Batch Name");
            	sheetObject1.SetSelectRow(dupRow);
            	return false;
            }
            
            if (!changeOfcAndGlDate(sheetObjects[0], mainRow, prefix1 + "pay_dt")) {
    			return false;
    		}
            
    	} else {
    		return false;
    	}
    	return true;
	}  
    /**
     * Setting pay group by popup
     */    
    function setPayGroup(aryPopupData) {
    	document.form.vndr_pay_grp_cd.value=aryPopupData[0][1];
    }
    /**
     * Setting Batch Name by popup
     */    
    function setBatchNm(aryPopupData) {
    	document.form.pay_bat_nm.value=aryPopupData[0][1];
    }   
    /**
     * Setting Bank Account by popup
     */    
    function setBankAccount(aryPopupData) {
    	document.form.bank_acct_nm.value=aryPopupData[0][1];
    	document.form.bank_acct_num.value=aryPopupData[0][2];
    }  
    /**
     * initialize vendor name
     */ 
    function bank_acct_nm_onchange() {
    	document.form.bank_acct_num.value="";
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

		var curr_cd=sheetObj.GetCellValue(Row, prefix + "pay_curr_cd");
		var pay_dt=sheetObj.GetCellValue(Row, prefix + "pay_dt");
  		var f_curr_cd=formObj.f_curr.value;
  		var f_curr_prcs=formObj.f_curr_prcs.value;
  		
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
                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_nm","Corporate",0);
                 	//sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs",x_prcs,0);
                 } else  {
                 	ComShowCodeMessage("SAP00002", pay_dt, curr_cd);  // currency 없음 
                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt","",0);
                 	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt","",0);
                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd","",0);
                 	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_nm","",0);
                 	//sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs","",0);
                 	SetCellValue(Row, Col, "");
                 	SelectCell(Row, Col, true, "");
                 	return false;
                 }
             }
		} else {  //환율과 functional 환율이 같을 때          				
         	sheetObj.SetCellValue(Row, prefix + "pay_xch_rt",1,0);
         	sheetObj.SetCellValue(Row, prefix + "pay_xch_dt",sheetObj.GetCellValue(Row, prefix + "pay_dt"),0);
         	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_cd","1",0);
         	sheetObj.SetCellValue(Row, prefix + "xch_rt_tp_nm","Corporate",0);
         	//sheetObj.SetCellValue(Row, prefix + "pay_curr_prcs",f_curr_prcs,0);
		}

  		return true;
		
    }    