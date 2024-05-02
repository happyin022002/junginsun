/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2098.js
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/



    /**
     * @extends 
     * @class ees_cgm_2098 : ees_cgm_2098 business script for
     */
	function ees_cgm_2098() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* developer job	*/



	// common global variables

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	tabLoad[2]= 0;
	tabLoad[3]= 0;


	var TAB_SAVE_STD = false;
	var copyFlg = false;
	var opener;
	// Event handler processing by button click event */
	document.onclick = processButtonClick;

	// Event handler processing by button name */
	function processButtonClick(){
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
	
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
		    switch(srcName) {
		    	
		    	case "btn_downExcel":
		    		if(tabObjects[0].GetSelectedIndex()== 0){
		    			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
		    		} else if(tabObjects[0].GetSelectedIndex()== 1){
		    			doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
		    		} else if(tabObjects[0].GetSelectedIndex()== 2){
		    			doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
		    		} else if(tabObjects[0].GetSelectedIndex()== 3){
		    			doActionIBSheet(sheetObject4, formObject, IBDOWNEXCEL);
		    		}
					break;
	
				case "btn_save":
					if(validateForm(sheetObject4,formObject,IBSAVE) != false) {
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					}
					break;
	
				case "btn_coin":
					
					if(tabObjects[0].GetSelectedIndex() == 1 || tabObjects[0].GetSelectedIndex() == 3){
						
						var strCheckedRows = sheetObjects[tabObjects[0].GetSelectedIndex()].FindCheckedRow("del_chk");
			    		var strStatusRows = sheetObjects[tabObjects[0].GetSelectedIndex()].FindStatusRow("I|U");		 
			    		
			    		var arrCheckedRows = strCheckedRows.split("|"); 
			    		var arrStatusRows = strStatusRows.split(";");	
			    		
			    		copyFlg = false;
			    		if(strCheckedRows == ""){
			    			ComShowCodeMessage('CGM10008');
			    			return;
			    		}
			    	
						if(tabObjects[0].GetSelectedIndex() == 1){
							// 
				    		//if(TAB2_SAVE_STD){
				    		//	ComShowCodeMessage('CGM10026','Discrepancy');
		    				//	return;
							//}
						} else if(tabObjects[0].GetSelectedIndex() == 3){
							//
							var tmpFindRows = sheetObjects[3].FindStatusRow('I');
							if(tmpFindRows != "")
							{
								ComShowCodeMessage('CGM10026','Invoice Only');
								return;
							}
						}
						
						var sColNms = "";
						
						if(tabObjects[0].GetSelectedIndex() == 1){
							sColNms = sColNms + "ibflag|eq_no|inv_no|agmt_no|inv_ref_no|eq_tpsz_cd|lse_chg_aud_sts_cd|chg_cd|eq_onh_loc_cd|";
							sColNms = sColNms + "eq_onh_dt|eq_bil_st_dt|eq_offh_loc_cd|eq_offh_dt|lse_rt_amt|";
							sColNms = sColNms + "lse_chg_amt|inv_bil_st_dt|inv_bil_end_dt|";
							sColNms = sColNms + "inv_eq_onh_loc_nm|inv_eq_offh_loc_nm|inv_lse_use_dys|inv_lse_rt_amt|inv_tax_amt|inv_cr_amt|";
							sColNms = sColNms + "inv_lse_chg_amt|intg_cd_val_dp_desc|pay_chg_aud_rmk|";
							sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|chg_seq";
							
						} else if(tabObjects[0].GetSelectedIndex() == 3){
							sColNms = sColNms + "ibflag|seq|inv_cust_eq_no|eq_no|inv_ref_no|";
							sColNms = sColNms + "inv_no|chg_cd|inv_bil_st_dt|inv_bil_end_dt|inv_eq_onh_loc_nm|";
							sColNms = sColNms + "inv_eq_offh_loc_nm|inv_lse_use_dys|inv_lse_rt_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_amt|";
							sColNms = sColNms + "aud_umch_eq_sts_evnt_yd_cd|aud_umch_eq_sts_evnt_dt|intg_cd_val_dp_desc|pay_chg_aud_rmk|";
							sColNms = sColNms + "lse_chg_aud_sts_cd|agmt_no|eq_tpsz_cd|";
							sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|chg_seq"; 
						}

						var sXml = ComCgmMakeSearchXml(sheetObjects[tabObjects[0].GetSelectedIndex()], "del_chk",sColNms, true);
						//sheetObjects[0].LoadSearchXml(sXml, true);

						sheetObjects[5].RemoveAll();
						sheetObjects[5].LoadSearchData(sXml,{Append:1 , Sync:1} );
						for(var i = sheetObjects[5].HeaderRows(); i <= sheetObjects[5].LastRow(); i++){
							copyFlg = true;
							var copyRow = sheetObjects[5].GetRangeValue(i, 0, i, sheetObjects[5].LastCol(), "|", "^");
							sheetObjects[0].DataInsert(-1);
							sheetObjects[0].SetRangeValue(copyRow, sheetObjects[0].LastRow(), 0, sheetObjects[0].LastRow(), sheetObjects[0].LastCol(), "|", "^");
						}
//						sheetObjects[5].Copy2SheetCol(sheetObjects[0],"","" ,-1 ,-1 ,-1 ,2 ,true,false,"","");
						TAB_SAVE_STD = true;
						doActionBtnEnable(tabObjects[0].GetSelectedIndex());	
						
					
						// Considency Tab
						if(sheetObjects[0].RowCount()> 0){
		         			var taxSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
		         			var crSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
		         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
			         		var lseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
			         		formObject.inv_smry_amt.value=ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);   
			         		formObject.pay_chg_smry_amt.value=ComCgmAmountFormat(lseChgAmt,2);
			         		formObject.tax_smry_amt.value=ComCgmAmountFormat(taxSmryAmt,2);
			         		formObject.cr_smry_amt.value=ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
		         		} else {
		         			formObject.inv_smry_amt.value='0.00';  
			         		formObject.pay_chg_smry_amt.value='0.00';
			         		formObject.tax_smry_amt.value='0.00';
			         		formObject.cr_smry_amt.value='0.00';
		         		}
						if(tabObjects[0].GetSelectedIndex()== 1){
							if(sheetObjects[1].RowCount()> 0){
								var lseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
			         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
			         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
			         			var invCrAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
			         			formObject.lse_chg_amt.value=ComCgmAmountFormat(lseChgAmt,2);
			         			formObject.inv_lse_chg_amt.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
			         			formObject.diff.value=ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
							} else {
								formObject.lse_chg_amt.value='0.00';
								formObject.inv_lse_chg_amt.value='0.00';
				         		formObject.diff.value='0.00';
							}	
						} else if(tabObjects[0].GetSelectedIndex()== 3){
							if(sheetObjects[3].RowCount()> 0){
								var invLseChgAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
			         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
			         			var invCrAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
			         			formObject.lse_chg_amt3.value='0.00';
			         			formObject.inv_lse_chg_amt3.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
			         			formObject.diff3.value=ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
							} else {
								formObject.lse_chg_amt3.value='0.00';
								formObject.inv_lse_chg_amt3.value='0.00';
								formObject.diff3.value='0.00';
							}
						}
					}
					sheetObjects[tabObjects[0].GetSelectedIndex()].CheckAll(1,0);   
					break;
	
				case "btn_coin_back":
					var strCheckedRows=sheetObjects[tabObjects[0].GetSelectedIndex()].FindCheckedRow("del_chk");
		    		var strStatusRows=sheetObjects[tabObjects[0].GetSelectedIndex()].FindStatusRow("I|U");
		    		var arrCheckedRows=strCheckedRows.split("|"); // Check  Row
		    		var arrStatusRows=strStatusRows.split(";");	//  inserting(I,U)  Row 
		    		
					
		    		copyFlg = false;
		    		if(strCheckedRows== ""){
		    			ComShowCodeMessage('CGM10008');
		    			return;
		    		}
		    		
		    		//--------------------
					// Sheet move
					//-------------------
		    		var sColNms = "";
					
		    		sColNms=sColNms + "ibflag|eq_no|inv_no|agmt_no|inv_ref_no|eq_tpsz_cd|lse_chg_aud_sts_cd|chg_cd|eq_onh_loc_cd|eq_onh_dt|";
					sColNms=sColNms + "eq_bil_st_dt|eq_offh_loc_cd|eq_offh_dt|lse_rt_amt|lse_chg_amt|";
					sColNms=sColNms + "inv_bil_st_dt|inv_bil_end_dt|inv_eq_onh_loc_nm|inv_eq_offh_loc_nm|";
					sColNms=sColNms + "inv_lse_use_dys|inv_lse_rt_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_amt|pay_chg_aud_rmk|";
					sColNms=sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|chg_seq|"
					sColNms=sColNms + "inv_cust_eq_no|aud_umch_eq_sts_evnt_yd_cd|aud_umch_eq_sts_evnt_dt|intg_cd_val_dp_desc"; // KyoungWan 추가 
		    		var sXml=ComCgmMakeSearchXml2(sheetObjects[0], "del_chk",sColNms, true, 'D');
					sheetObjects[6].RemoveAll();
					sheetObjects[6].LoadSearchData(sXml,{Append:1 , Sync:1} );
					for(var i = sheetObjects[6].HeaderRows(); i <= sheetObjects[6].LastRow(); i++){
						copyFlg = true;
						var copyRow = sheetObjects[6].GetRangeValue(i, 0, i, sheetObjects[6].LastCol(), "|", "^");
						sheetObjects[1].DataInsert(-1);
						sheetObjects[1].SetRangeValue(copyRow, sheetObjects[1].LastRow(), 0, sheetObjects[1].LastRow(), sheetObjects[1].LastCol(), "|", "^");
						
					}
					
//					sheetObjects[6].Copy2SheetCol(sheetObjects[1],"","",-1,-1,-1,2,true,false,"","");						
					var sXml2=ComCgmMakeSearchXml2(sheetObjects[0], "del_chk",sColNms, true, 'I');
					sheetObjects[7].RemoveAll();
					sheetObjects[7].LoadSearchData(sXml2,{Append:1 , Sync:1} );
					for(var i = sheetObjects[7].HeaderRows(); i <= sheetObjects[7].LastRow(); i++){
						copyFlg = true;
						var copyRow = sheetObjects[7].GetRangeValue(i, 0, i, sheetObjects[7].LastCol(), "|", "^");
						sheetObjects[3].DataInsert(-1);
						sheetObjects[3].SetRangeValue(copyRow, sheetObjects[3].LastRow(), 0, sheetObjects[3].LastRow(), sheetObjects[3].LastCol(), "|", "^");
					}
					
//					sheetObjects[7].Copy2SheetCol(sheetObjects[3],"","",-1,-1,-1,2,true,false,"","");
					var tmpFindRows=sheetObjects[3].FindStatusRow('I');
					if(tmpFindRows != "")
					{
						var tVars=tmpFindRows.split(";");	
						for(var i=0; i < tVars.length -1; i++){
							//sheetObjects[3].cellValue2(tVars[i],"ibflag") = "U";
							sheetObjects[3].SetRowStatus(tVars[i],"U");
						}							
					}
					TAB_SAVE_STD=true;
					doActionBtnEnable(tabObjects[0].GetSelectedIndex());
					//--------------------
					// 
					//-------------------
					// Considency Tab
	         		if(sheetObjects[0].RowCount()> 0){
	         			var taxSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
	         			var crSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
	         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
		         		var lseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
		         		formObject.inv_smry_amt.value=ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);   
		         		formObject.pay_chg_smry_amt.value=ComCgmAmountFormat(lseChgAmt,2);
		         		formObject.tax_smry_amt.value=ComCgmAmountFormat(taxSmryAmt,2);
		         		formObject.cr_smry_amt.value=ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
	         		} else {
	         			formObject.inv_smry_amt.value='0.00';  
		         		formObject.pay_chg_smry_amt.value='0.00';
		         		formObject.tax_smry_amt.value='0.00';
		         		formObject.cr_smry_amt.value='0.00';
	         		}
	         		// Discrepancy Tab
	         		if(sheetObjects[1].RowCount()> 0){
						var lseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
	         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
	         			var invCrAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
	         			formObject.lse_chg_amt.value=ComCgmAmountFormat(lseChgAmt,2);
	         			formObject.inv_lse_chg_amt.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         			formObject.diff.value=ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
					} else {
						formObject.lse_chg_amt.value='0.00';
						formObject.inv_lse_chg_amt.value='0.00';
		         		formObject.diff.value='0.00';
					}	
	         		// Invoice Only Tab
	         		if(sheetObjects[3].RowCount()> 0){
						var invLseChgAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
	         			var invCrAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
	         			formObject.lse_chg_amt3.value='0.00';
	         			formObject.inv_lse_chg_amt3.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         			formObject.diff3.value=ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
					} else {
						formObject.lse_chg_amt3.value='0.00';
						formObject.inv_lse_chg_amt3.value='0.00';
						formObject.diff3.value='0.00';
					}
	         		sheetObjects[tabObjects[0].GetSelectedIndex()].CheckAll(1,0);
					t4sheet1_enableEditingWhenLseChgAudStsCdIsNull();
					break;
					
				case "btn_add":
					doActionIBSheet(sheetObject4,formObject,IBINSERT);
					break;
	
				case "btn_delete":
					doActionIBSheet(sheetObject4,formObject,IBRESET);
					break;
	
				case "btn_soCreate":
					if(validateForm(sheetObject1,formObject,IBCREATE) != false) {
						if(TAB_SAVE_STD){
							ComShowCodeMessage('CGM10079','Concidence');
	    					return;
						}
						
						doActionIBSheet(sheetObject1,formObject,IBCREATE);
					}
					break;
					
				case "btn_remove":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;
					
				case "btns_inv_dt":
					var cal = new ComCalendar();
		    		cal.select(formObject.inv_dt, "yyyy-MM-dd");
		    		break;
		    		
				case "btn_Close":
					opener.closeSearch();
					ComClosePopup(); 
 					break;

	    	} // end switch
		}catch(e) {
			if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
	    }
	}

	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){

		sheetObjects[sheetCnt++] = sheet_obj;

	}

    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	opener = window.dialogArguments;
    	if (!opener)
    		opener = parent;
    	// event
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    	 
        for(i=0;i<sheetObjects.length;i++){

	        //
	        ComConfigSheet (sheetObjects[i] );
		    initSheet(sheetObjects[i],i+1);
		    //
		    ComEndConfigSheet(sheetObjects[i]);
		
        }
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        
    	var sysDate   = new Date();
    	var year = sysDate.getFullYear();
    	var month = sysDate.getMonth()+1;
    	var date = sysDate.getDate();

    	var today = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
    	
    	// todate setting (Issue Date)
    	document.form.inv_dt.value = today;
        
        // button enable/disable  reset
    	doActionBtnEnable(tabObjects[0].GetSelectedIndex());
        
        // vendor Name 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

        // Concidence, Despanc, Charge Only, Invoice Only list
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		//  Tab Save status saving (false:disable,true:eanable)
		TAB_SAVE_STD = false;				
	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
	    
		switch(sheetID) {

	    	case "t1sheet1":
	    		with (sheetObj) {

	                var HeadTitle1 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Loc.|Off-hHire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);

			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",              Wrap:1 },
			                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",             Wrap:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                 Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_bil_st_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lse_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"lse_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_st_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_end_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_onh_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_offh_loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_lse_use_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_cr_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_aud_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",     Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",            Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",         Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",        Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",             Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inv_cust_eq_no",      Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_yd_cd",             Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_dt",             Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"intg_cd_val_dp_desc",             Wrap:1 }];
			           
			          InitColumns(cols);

			          SetEditable(1);
			          SetSheetHeight(300);
			          SetRangeBackColor(1, 2, 1, 36,"#777777");
			    }
	    		break;

	    	case "t1sheet1_tmp":
	    		with (sheetObj) {
	    			
	                var HeadTitle1 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Loc.|Off-hHire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);

			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",              Wrap:1 },
			                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",             Wrap:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                 Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_bil_st_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lse_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"lse_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_st_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_end_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_onh_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_offh_loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_lse_use_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_cr_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_aud_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",     Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",            Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",         Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",        Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",             Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inv_cust_eq_no",      Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_yd_cd",             Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_dt",             Wrap:1 },
			                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"intg_cd_val_dp_desc",             Wrap:1 }];
			           
			          InitColumns(cols);
			          
			          SetEditable(1);
			          SetSheetHeight(300);
			          SetRangeBackColor(1, 2, 1, 36,"#777777");
			          SetVisible(0);
			                }


			            break;

	        case "t2sheet1":
	            with (sheetObj) {
	                
	                var HeadTitle1 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Lo.|Off-Hire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Audit Result|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"},
			                   { Text:HeadTitle2, Align:"Center"} ];
			         InitHeaders(headers, info);

			         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",               Wrap:1 },
			             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",              Wrap:1 },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                  Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_bil_st_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lse_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"lse_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_st_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_onh_loc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_offh_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_lse_use_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_cr_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_dp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_aud_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",      Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",             Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",          Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",         Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              Wrap:1 } ];
			          
			         InitColumns(cols);

			         SetEditable(1);
			         SetSheetHeight(302);
			         SetRangeBackColor(1, 2, 1, 36,"#777777");
			                  }


			            break;

	        case "t2sheet1_tmp":
	            with (sheetObj) {
	               
	                var HeadTitle1 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|M.G.Set No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Lo.|Off-Hire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Audit Result|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);

			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",               Wrap:1 },
			                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",              Wrap:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                  Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_bil_st_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lse_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"lse_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_st_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_onh_loc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_offh_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_lse_use_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_cr_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_dp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_aud_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",      Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",             Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",          Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",         Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              Wrap:1 } ];
			           
			          InitColumns(cols);

			          SetEditable(1);
			          SetSheetHeight(300);
			          SetRangeBackColor(1, 2, 1, 36,"#777777");
			          SetVisible(0);
			                }


			            break;

	        case "t3sheet1":
	        	with (sheetObj) {
	                
	                var HeadTitle1 = "|Seq.|M.G.Set No.|Agreement No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Used days|Rate|Charge\nTotal|Status|Event Date|";

					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			          InitHeaders(headers, info);

			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",              Wrap:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                 Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_onh_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_offh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lse_use_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lse_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"lse_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_aset_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sts_evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",             Wrap:1 } ];
			           
			          InitColumns(cols);

			          SetEditable(1);
			          SetSheetHeight(292);
			          SetRangeBackColor(1, 2, 1, 36,"#777777");
			                }


			            break;

	        case "t4sheet1":
	            with (sheetObj) {
	               
	                var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
	                HeadTitle1 += "|Invoice|Invoice|Invoice||||||||";
	                    		
	                var HeadTitle2 = "||Seq.|Customer\nM.G.Set No.|OWN M.G.Set No.|Invoice\nReference No.|Invoice No.|Charge\nType|Start Date|End Date|On-Hire\nLoc.|Off-Hire\nLoc.|Used Days|Rate|Tax|Credit|Invoice\nTotal";
	                HeadTitle2 += "|Yard|Event Date|Audit Result|Remark(s)||||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"},
			                   { Text:HeadTitle2, Align:"Center"} ];
			         InitHeaders(headers, info);

			         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                      Wrap:1 },
			             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                         Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_cust_eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"inv_ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3,     Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_st_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_end_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_onh_loc_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_offh_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_lse_use_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_cr_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_chg_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_dp_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pay_chg_aud_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",          Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",                     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                  Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",             Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",                    Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",                 Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",                Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",                     Wrap:1 } ];
			          
			         InitColumns(cols);

			         SetEditable(1);
			         SetColProperty(0, "inv_no" , {AcceptKeys:"E|[0123456789,_-!@#$%^&*()>?./]", InputCaseSensitive:1});
			         SetSheetHeight(302);
			         SetRangeBackColor(1, 2, 1, 36,"#777777");
			                  }


			            break; 

	        case "t4sheet1_tmp":
	            with (sheetObj) {
	                
	                var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
	                HeadTitle1 += "|Invoice|Invoice|Invoice||||||||";
	                    		
	                var HeadTitle2 = "||Seq.|Customer\nM.G.Set No.|OWN M.G.Set No.|Invoice\nReference No.|Invoice No.|Charge\nType|Start Date|End Date|On-Hire\nLoc.|Off-Hire\nLoc.|Used Days|Rate|Tax|Credit|Invoice\nTotal";
	                HeadTitle2 += "|Yard|Event Date|Audit Result|Remark(s)||||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);

			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                      Wrap:1 },
			                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                         Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_cust_eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"inv_ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3,     Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_st_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_end_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_onh_loc_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"inv_eq_offh_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_lse_use_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_cr_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"inv_lse_chg_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"aud_umch_eq_sts_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_dp_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pay_chg_aud_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_aud_sts_cd",          Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",                     Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                  Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",             Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",                    Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",                 Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",                Wrap:1 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",                     Wrap:1 } ];
			           
			          InitColumns(cols);

			          SetEditable(1);
			          SetSheetHeight(300);
			          SetRangeBackColor(1, 2, 1, 36,"#777777");
			          SetVisible(0);
			                }


			            break; 
	            
	        case "sheet":	// Hidden Sheet
	        	with(sheetObj){
	            
		          var HeadTitle1="";
		          var headCount=ComCountHeadTitle(HeadTitle1);

		          SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);

		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		           
		          InitColumns(cols);

		          SetEditable(1);
		          SetSheetHeight(100);
		          SetVisible(0);
		                }


		        	break;
	    }
	}

	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	        
		switch(sAction) {
	    	case IBSEARCH:      //retrieve
	    		
		    	formObj.f_cmd.value = SEARCH;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
	     			     		
				var sXml=sheetObj.GetSearchData("EES_CGM_2098GS.do" , FormQueryString(formObj), '', true);
         		var arrXml=sXml.split("|$$|");
         		
         	// tab1 Sheet Object
         		sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );

         		if(sheetObjects[0].RowCount()> 0){
         			var taxSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
         			var crSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         		var lseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
	         		formObj.inv_smry_amt.value=ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);  
	         		formObj.pay_chg_smry_amt.value=ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.tax_smry_amt.value=ComCgmAmountFormat(taxSmryAmt,2);
	         		formObj.cr_smry_amt.value=ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
	         		// chungpa 20100105 back error fix start
	         		for(var i=2; i<2+sheetObjects[0].RowCount(); i++)
	         		{
	         			if(sheetObjects[0].GetCellValue(i,"lse_chg_aud_sts_cd") == "C")
	         				sheetObjects[0].SetCellEditable(i, "del_chk",0);
	         		}
	         		// chungpa 20100105 back error fix end
         		} else {
         			formObj.inv_smry_amt.value='0.00';  
	         		formObj.pay_chg_smry_amt.value='0.00';
	         		formObj.tax_smry_amt.value='0.00';
	         		formObj.cr_smry_amt.value='0.00';
         		}
         		// tab2 Sheet Object
         		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
         		if(sheetObjects[1].RowCount()> 0){
         			var lseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
	         		formObj.lse_chg_amt.value=ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff.value=ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt.value='0.00';
	         		formObj.inv_lse_chg_amt.value='0.00';
	         		formObj.diff.value='0.00';
         		}
         		// tab3 Sheet Object
         		sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
         		if(sheetObjects[2].RowCount()> 0){
         			var lseChgAmt=ComReplaceStr(sheetObjects[2].ComputeSum("|lse_chg_amt|"),',','');
	         		formObj.lse_chg_amt2.value=ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt2.value='0.00';
	         		formObj.diff2.value=ComCgmAmountFormat(lseChgAmt,2);
         		} else {
         			formObj.lse_chg_amt2.value='0.00';
	         		formObj.inv_lse_chg_amt2.value='0.00';
	         		formObj.diff2.value='0.00';
         		}	
         		// tab4 Sheet Object
         		
         		sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
         		if(sheetObjects[3].RowCount()> 0){
         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
	         		formObj.lse_chg_amt3.value='0.00';
	         		formObj.inv_lse_chg_amt3.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff3.value=ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt3.value='0.00';
	         		formObj.inv_lse_chg_amt3.value='0.00';
	         		formObj.diff3.value='0.00';
         		}
         		ComOpenWait(false);
				t4sheet1_enableEditingWhenLseChgAudStsCdIsNull();
         		break;

	    	case IBSAVE:        //saving
	            
		    	formObj.f_cmd.value = MULTI01;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
	    	
	     		var strStatusRow = "";
	     		var sParam = "";
	         	/*
				if(tabObjects[0].SelectedIndex == 0){
					var sParam1 = sheetObjects[0].GetSaveString(false); 
					sParam = ComSetPrifix(sParam1, "t1sheet1");
					strStatusRow = sheetObjects[0].FindStatusRow("I|U");
				} else if(tabObjects[0].SelectedIndex == 1){
					var sParam2 = sheetObjects[1].GetSaveString(false);
					sParam = ComSetPrifix(sParam2, "t2sheet1");
				} else if(tabObjects[0].SelectedIndex == 3){
					var sParam3 = sheetObjects[3].GetSaveString(false);
					sParam = ComSetPrifix(sParam3, "t4sheet1");
				}
				*/
	     		
	     		strStatusRow=sheetObjects[0].FindStatusRow("I|U");
	     		var sParam1=sheetObjects[0].GetSaveString(false);
				sParam=sParam + ComSetPrifix(sParam1, "t1sheet1");
				sParam=sParam + "&";
				var sParam2=sheetObjects[1].GetSaveString(false);
				sParam=sParam + ComSetPrifix(sParam2, "t2sheet1");
				sParam=sParam + "&";
				var sParam3=sheetObjects[3].GetSaveString(false);
				sParam=sParam + ComSetPrifix(sParam3, "t4sheet1");
				sParam=sParam + "&";
				sParam=sParam + FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);		
				var sXml=sheetObj.GetSaveData("EES_CGM_2098GS.do", sParam);
				//if(tabObjects[0].SelectedIndex == 0){
				//	sheetObjects[0].LoadSaveXml(sXml);
					if(strStatusRow != ''){
						var arrStatusRow=strStatusRow.split(';');
						for(var i=0; i < arrStatusRow.length -1; i++){
							sheetObjects[0].SetCellValue(arrStatusRow[i],"ibflag","I");
							sheetObjects[0].SetCellEditable(arrStatusRow[i],"pay_chg_aud_rmk",1);
						}	
					}
				//} else if(tabObjects[0].SelectedIndex == 1){
				//	sheetObjects[1].LoadSaveXml(sXml);
				//} else if(tabObjects[0].SelectedIndex == 3){
					sheetObjects[3].LoadSaveData(sXml);
				//}
				ComOpenWait(false);
				t4sheet1_enableEditingWhenLseChgAudStsCdIsNull();
				copyFlg = false;
	            break;
	            
	    	case IBCREATE:
	    		formObj.f_cmd.value = MULTI02;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
	     		
	     		var sParam = sheetObjects[0].GetSaveString(false);
	     		//var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
	         	sParam = sParam + "&";
	         	sParam = sParam + FormQueryString(formObj);
	         	
	         	var strStatusRow = sheetObjects[0].FindStatusRow("I|U");
	         	
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);

	     		var sXml = sheetObjects[0].GetSaveData("EES_CGM_2098GS.do", sParam);
	     		sheetObjects[2].LoadSaveData(sXml);

				ComOpenWait(false);	
	     		
				if(strStatusRow != ''){
					var arrStatusRow=strStatusRow.split(';');
					for(var i=0; i < arrStatusRow.length -1; i++){
						sheetObjects[0].SetCellValue(arrStatusRow[i],"ibflag","I");
						sheetObjects[0].SetCellEditable(arrStatusRow[i],"pay_chg_aud_rmk",1);
					}	
				}
	     		
	    		break;
	    		
	    	case IBDELETE:
	    		formObj.f_cmd.value = REMOVE;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
					     		
	     		var sXml = sheetObjects[0].GetSaveData("EES_CGM_2098GS.do", FormQueryString(formObj));
	     			
	     		var arrXml = sXml.split("|$$|");
         		
	     		sheetObjects[0].LoadSaveData(arrXml[0]);
         		if(sheetObjects[0].RowCount()> 0){
         			var taxSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
         			var crSmryAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         		var lseChgAmt=Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
	         		formObj.inv_smry_amt.value=ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);  
	         		formObj.pay_chg_smry_amt.value=ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.tax_smry_amt.value=ComCgmAmountFormat(taxSmryAmt,2);
	         		formObj.cr_smry_amt.value=ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
         		} else {
         			formObj.inv_smry_amt.value='0.00';  
	         		formObj.pay_chg_smry_amt.value='0.00';
	         		formObj.tax_smry_amt.value='0.00';
	         		formObj.cr_smry_amt.value='0.00';
         		}
         		// tab2 Sheet Object
         		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
         		if(sheetObjects[1].RowCount()> 0){
         			var lseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt=Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
	         		formObj.lse_chg_amt.value=ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff.value=ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt.value='0.00';
	         		formObj.inv_lse_chg_amt.value='0.00';
	         		formObj.diff.value='0.00';
         		}
         		// tab3 Sheet Object
         		sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
         		if(sheetObjects[2].RowCount()> 0){
         			var lseChgAmt=ComReplaceStr(sheetObjects[2].ComputeSum("|lse_chg_amt|"),',','');
	         		formObj.lse_chg_amt2.value=ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt2.value='0.00';
	         		formObj.diff2.value=ComCgmAmountFormat(lseChgAmt,2);
         		} else {
         			formObj.lse_chg_amt2.value='0.00';
	         		formObj.inv_lse_chg_amt2.value='0.00';
	         		formObj.diff2.value='0.00';
         		}	
         		// tab4 Sheet Object
         		sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
         		if(sheetObjects[3].RowCount()> 0){
         			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
	         		formObj.lse_chg_amt3.value='0.00';
	         		formObj.inv_lse_chg_amt3.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff3.value=ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt3.value='0.00';
	         		formObj.inv_lse_chg_amt3.value='0.00';
	         		formObj.diff3.value='0.00';
         		}	
         		ComOpenWait(false);	
	    		break;

	    	case IBINSERT:      // row add
	    		var newRow=sheetObj.DataInsert(-1);
	    		sheetObj.InitCellProperty(newRow,"chg_cd",{ Type:"ComboEdit"} );
                sheetObj.CellComboItem(newRow,"chg_cd", {ComboText:"CRD|TAX|PDM", ComboCode:"CRD|TAX|PDM"} );
                sheetObj.SetCellValue(newRow, "chg_cd","CRD");
	    		sheetObj.SetCellEditable(newRow, "eq_no",0);
	    		TAB_SAVE_STD=true;	// Save button 
	    		doActionBtnEnable(tabObjects[0].GetSelectedIndex());
	    		// Invoice Only Charge Type  inserting enable/disable setting
	    		sheetObj.SetCellEditable(newRow, "inv_cr_amt",1);
	    		sheetObj.SetCellEditable(newRow, "inv_tax_amt",0);
	    		sheetObj.SetCellEditable(newRow, "inv_lse_chg_amt",0);
	            break;
	            
	    	case IBRESET:	 	// row deleting
	    		
	    		var strCheckedRows=sheetObj.FindCheckedRow("del_chk");
	    		var strStatusRows=sheetObj.FindStatusRow("I");
	    		var strStatusRows2=sheetObj.FindStatusRow("U");
	    		var arrStatusRows2=strStatusRows2.split(";");
	    		var strStatusRows3=sheetObj.FindStatusRow("R");
	    		var arrStatusRows3=strStatusRows3.split(";");
	    		var arrCheckedRows=strCheckedRows.split("|");
	    		var arrStatusRows=strStatusRows.split(";");
	    		var checkDeleteStatus=false;
	    		for(var i=arrCheckedRows.length-1; i >= 0; i--){
	    			for(var k=arrStatusRows2.length-1; k>=0; k-- ){
	    				if(arrCheckedRows[i] == arrStatusRows2[k]){
	    					if(sheetObj.GetCellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd") == '' )
	    					{
	    						sheetObj.SetRowHidden(arrCheckedRows[i],1);
	    						sheetObj.SetRowStatus(arrCheckedRows[i],"D");
	    						checkDeleteStatus=true;
	    					}
	    					break;
	    				}
	    			}
	    		}	    		
	    		var checkDeleteStatus=false;
	    		for(var i=arrCheckedRows.length-1; i >= 0; i--){
	    			for(var k=arrStatusRows3.length-1; k>=0; k-- ){
	    				if(arrCheckedRows[i] == arrStatusRows3[k]){
	    					if(sheetObj.GetCellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd") == '' )
	    					{
	    						sheetObj.SetRowHidden(arrCheckedRows[i],1);
	    						sheetObj.SetRowStatus(arrCheckedRows[i],"D");
	    						//alert("chungpa1>>>>"+ sheetObj.CellValue(arrCheckedRows[i],"inv_no") + " ::"+ sheetObj.CellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd"));
	    						checkDeleteStatus=true;
	    					}
	    					break;
	    				}
	    			}
	    		}	    		
	    		for(var i=arrCheckedRows.length-1; i >= 0; i--){
	    			sheetObj.SetCellValue(arrCheckedRows[i], "del_chk",0,0);
	    			for(var k=arrStatusRows.length-1; k>=0; k-- ){	
	    				if(arrCheckedRows[i] == arrStatusRows[k]){
	    					sheetObj.SetRowHidden(arrCheckedRows[i],1);
	    					sheetObj.SetRowStatus(arrCheckedRows[i],"D");
	    					break;
	    				}
	    			}
	    		}
	    		if(sheetObj.FindStatusRow("I|U")=='' && sheetObjects[1].FindStatusRow("I|U")=='' && sheetObjects[0].FindStatusRow("I")==''){
	    			TAB_SAVE_STD=false;
	    			doActionBtnEnable(tabObjects[0].GetSelectedIndex());
	    		}
	    		// Invoice Only 
	    		if(sheetObjects[3].RowCount()> 0){
	    			var invLseChgAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
	         		formObj.lse_chg_amt3.value='0.00';
	         		formObj.inv_lse_chg_amt3.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff3.value=ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
				} else {
					formObj.lse_chg_amt3.value='0.00';
					formObj.inv_lse_chg_amt3.value='0.00';
					formObj.diff3.value='0.00';
				}
	    		if(checkDeleteStatus == true)
	    		{
	    			TAB_SAVE_STD=true;	// Save button 
	    			doActionBtnEnable(tabObjects[0].GetSelectedIndex());
	    		}
	    		break;
	    	
	    	case IBSEARCH_ASYNC01:	// Vendor Code,Name retrieve
			
	        	formObj.f_cmd.value = SEARCH07;
	        	var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	        	var text = ComGetEtcData(sXml,"text");
	        	
	        	formObj.vndr_lgl_eng_nm.value = text;
	        	break;
	        	
	    	case IBDOWNEXCEL:
	    		if(sheetObj.RowCount() < 1){//no data
	    			ComShowCodeMessage("COM132501");
	    			}else{
	    				sheetObj.Down2Excel({  DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1});
	    			}
	    		break;
	    		
	    }
	}
	
	/**
     * Action button enable/disable setting. <br>
     * @param  
     * @return 
     * @author 
     * @version
     */	
    function doActionBtnEnable (tabIndex){
    
    	var formObj = document.form; 
     	
   
    	if(formObj.lse_chg_sts_cd.value == 'C'){
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_coin");
    		ComBtnDisable("btn_coin_back");
    		ComBtnDisable("btn_soCreate");
    		ComBtnDisable("btn_remove");
    		ComBtnDisable("btn_add");
    		ComBtnDisable("btn_delete");
    		
    		return;
    	}	
  
    	if(formObj.lse_chg_sts_cd.value == 'S'){
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_coin");
    		ComBtnDisable("btn_coin_back");
    		ComBtnDisable("btn_soCreate");
    		ComBtnDisable("btn_add");
    		ComBtnDisable("btn_delete");
    		
    		if(tabIndex == 0){
    			ComBtnEnable("btn_remove");
    		} else {
    			ComBtnDisable("btn_remove");
    		}
    		return;
    	}
     	
    	switch(tabIndex){
    		case 0:	// Tab Index = 0
    			ComBtnDisable("btn_coin");
    			ComBtnEnable("btn_coin_back");
    			ComBtnEnable("btn_soCreate");
    			ComBtnDisable("btn_remove");
    			if(TAB_SAVE_STD){
    				ComBtnEnable("btn_save");
    			} else {
    				ComBtnDisable("btn_save");
    			}
    			break;
    			
    		case 1:	// Tab Index = 1
    			ComBtnEnable("btn_coin");
    			ComBtnDisable("btn_coin_back");
    			ComBtnDisable("btn_soCreate");
    			ComBtnDisable("btn_remove");
    			if(TAB_SAVE_STD){
    				ComBtnEnable("btn_save");
    			} else {
    				ComBtnDisable("btn_save");
    			}
    			break;
    			
    		case 2:	// Tab Index = 2
    			ComBtnDisable("btn_coin");
    			ComBtnDisable("btn_coin_back");
    			ComBtnDisable("btn_soCreate");
    			ComBtnDisable("btn_remove");
    			if(TAB_SAVE_STD){
    				ComBtnEnable("btn_save");
    			} else {
    				ComBtnDisable("btn_save");
    			}
    			break;
    			
    		case 3:	// Tab Index = 3
    			ComBtnEnable("btn_coin");
    			ComBtnDisable("btn_coin_back");
    			ComBtnDisable("btn_soCreate");
    			ComBtnDisable("btn_remove");
    			if(TAB_SAVE_STD){
    				ComBtnEnable("btn_save");
    			} else {
    				ComBtnDisable("btn_save");
    			}
    			ComBtnEnable("btn_add");
    			ComBtnEnable("btn_delete");

    			break;
    			
    		case 5:	
    			ComBtnEnable("btn_save");
    			break;
    		
    		case 6:	// save button disable  
    			ComBtnDisable("btn_save");
    			break;
    			
    		default:	
	    		ComBtnDisable("btn_coin");
				ComBtnEnable("btn_soCreate");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_remove");
    			break;
    	}
    }
    
	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}

	/**
	 * initializing Tab
	 * setting Tab items
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
	    	case 1:
	    		with (tabObj) {
	    			var cnt  = 0 ;
	    			InsertItem( "Coincidence" , "");
	    			InsertItem( "Discrepancy" , "");
	    			InsertItem( "OWN Only" , "");
	    			InsertItem( "Lessor Only" , "");

	            }
	            break;
	    }
	}

    /**
	* Event when clicking Tab
	 */
	function tab1_OnChange(tabObj , nItem){

		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//------------------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;

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

        switch(sAction){
        	case IBSAVE:	// saving
        	
        		if(tabObjects[0].GetSelectedIndex()== 3){
	        		var strStatusRows=sheetObj.FindStatusRow("I");
	        		var arrStatusRows=strStatusRows.split(";");
	        		if(strStatusRows != ""){
	        			for(var i=0; i<arrStatusRows.length; i++){
		        			if(sheetObj.GetCellValue(arrStatusRows[i],"chg_cd") == 'PDM'){
		        				if(ComTrim(sheetObj.GetCellValue(arrStatusRows[i],"eq_no"))==""){
		        					ComShowCodeMessage('CGM10004','OWN Chassis No.');
			        				sheetObj.SelectCell(arrStatusRows[i], "eq_no", true);
		        					return false;
		        				}
		        			}	
		        			if(ComTrim(sheetObj.GetCellValue(arrStatusRows[i],"inv_ref_no"))==""){
		        				ComShowCodeMessage('CGM10004','Invoice Reference No.');
		        				sheetObj.SelectCell(arrStatusRows[i], "inv_ref_no", true);
		        				return false;
		        			} else if(ComTrim(sheetObj.GetCellValue(arrStatusRows[i],"inv_no"))==""){
		        				if(sheetObj.GetCellValue(arrStatusRows[i],"chg_cd") == "CRD")
		        				{
		        					ComShowCodeMessage('CGM10004','Invoice No.');
		        					sheetObj.SelectCell(arrStatusRows[i], "inv_no", true);
		        					return false;
		        				}else
		        				{
		        					ComShowCodeMessage('CGM10004','Invoice No.');
		        					sheetObj.SelectCell(arrStatusRows[i], "inv_no", true);
		        					return false;
		        				}
		        			} 
//		        			else if(ComTrim(sheetObj.GetCellValue(arrStatusRows[i],"inv_lse_chg_amt"))==""){
//		        				ComShowCodeMessage('CGM10004','Invoice Total');
//		        				sheetObj.SelectCell(arrStatusRows[i], "inv_lse_chg_amt", true);
//		        				return false;
//		        			}
		        		}
		        		for(var i=0; i<arrStatusRows.length; i++){
		        			var invNo=sheetObj.GetCellValue(arrStatusRows[i],"inv_no");
		        			var invRefNo=sheetObj.GetCellValue(arrStatusRows[i],"inv_ref_no");
		        			var concidenceRow=sheetObjects[0].FindText("inv_ref_no", invRefNo);
		        			if(concidenceRow == -1){
		        				ComShowCodeMessage('CGM10049',invRefNo);
		        				sheetObj.SelectCell(arrStatusRows[i], "inv_ref_no", true);
		        				return false;
		        			} else {
		        				sheetObj.SetCellValue(arrStatusRows[i], "agmt_ofc_cty_cd",sheetObjects[0].GetCellValue(concidenceRow,"agmt_ofc_cty_cd"));
		        				sheetObj.SetCellValue(arrStatusRows[i], "agmt_seq",sheetObjects[0].GetCellValue(concidenceRow,"agmt_seq"));
		        				sheetObj.SetCellValue(arrStatusRows[i], "agmt_ver_no",sheetObjects[0].GetCellValue(concidenceRow,"agmt_ver_no"));
		        				sheetObj.SetCellValue(arrStatusRows[i], "agmt_lstm_cd",sheetObjects[0].GetCellValue(concidenceRow,"agmt_lstm_cd"));
		        			}
		        			//if(sheetObj.cellValue(arrStatusRows[i], "chg_cd")=='CRD'){
			        			if(sheetObjects[0].FindText("inv_no", invNo) == -1){
			        				if(sheetObj.GetCellValue(arrStatusRows[i],"chg_cd") == "CRD")
			        				{
			        				}else
			        				{
				        				ComShowCodeMessage('CGM10025',invNo);
				        				sheetObj.SelectCell(arrStatusRows[i], "inv_no", true);
				        				return false;
			        				}
			        			}
		        			//}
		        		}
	        		}
	        		
        		}
        		break;
        		
        	case IBCREATE:
        		if(form.inv_dt.value == ''){
        			ComShowCodeMessage('CGM10004',"Issue Date");
        			form.inv_dt.focus();
        			return false;
        		}
        		
        		if(sheetObj.RowCount() == 0){
        			ComShowCodeMessage('CGM20043');
        			return false;
        		}
        		break;
        }
		
		return true;
	}
	
	/**
	 *  (tab1) click event. <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	 */	 
	function tab1_OnClick(tabObj, tabIndex){
		doActionBtnEnable(tabIndex);
	}
	
	/**
	 * sheet Object (Discrepancy) click event. <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	 */	 
	function t1sheet1_OnChange(sheetObj, Row, Col, Value)  {
			
		if(sheetObj.ColSaveName(Col) == 'pay_chg_aud_rmk'){
			TAB_SAVE_STD = true;	// Save button enable
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
		
	/**
	 * sheet Object (Discrepancy) click event. <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	 */	 
	function t2sheet1_OnChange(sheetObj, Row, Col, Value)  {
			
		if(sheetObj.ColSaveName(Col) == 'pay_chg_aud_rmk'){
			TAB_SAVE_STD = true;	// Save button enable
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	} 
	
	/**
	 * sheet Object (Invoice Only) click event. <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	 */	 
	function t4sheet1_OnChange(sheetObj, Row, Col, Value)  {
	 
		if(!copyFlg){
			var formObj=document.form;
			if(sheetObj.ColSaveName(Col) == "inv_ref_no"){
				var findRow=sheetObjects[0].FindText("inv_ref_no", sheetObj.GetCellValue(Row,"inv_ref_no"),-1);
				if(findRow!=-1){
					sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd",sheetObjects[0].GetCellValue(findRow,"agmt_ofc_cty_cd"));
					sheetObj.SetCellValue(Row,"agmt_seq",sheetObjects[0].GetCellValue(findRow,"agmt_seq"));
					sheetObj.SetCellValue(Row,"agmt_ver_no",sheetObjects[0].GetCellValue(findRow,"agmt_ver_no"));
				}
			}
			if(sheetObj.ColSaveName(Col) == "chg_cd"){
				if(sheetObj.GetCellValue(Row, "chg_cd") == 'CRD'){
					sheetObj.SetCellEditable(Row, "eq_no",0);
					sheetObj.SetCellEditable(Row, "inv_cr_amt",1);
					sheetObj.SetCellEditable(Row, "inv_tax_amt",0);
					sheetObj.SetCellEditable(Row, "inv_lse_chg_amt",0);
					sheetObj.SetCellValue(Row, "inv_tax_amt",0);
					sheetObj.SetCellValue(Row, "inv_lse_chg_amt",0);
				} else if(sheetObj.GetCellValue(Row, "chg_cd") == 'TAX'){
					sheetObj.SetCellEditable(Row, "eq_no",0);
					sheetObj.SetCellEditable(Row, "inv_cr_amt",0);
					sheetObj.SetCellEditable(Row, "inv_tax_amt",1);
					sheetObj.SetCellEditable(Row, "inv_lse_chg_amt",0);
					sheetObj.SetCellValue(Row, "inv_cr_amt",0);
					sheetObj.SetCellValue(Row, "inv_lse_chg_amt",0);
				} else if(sheetObj.GetCellValue(Row, "chg_cd") == 'PDM'){
					sheetObj.SetCellEditable(Row, "eq_no",1);
					sheetObj.SetCellEditable(Row, "inv_cr_amt",0);
					sheetObj.SetCellEditable(Row, "inv_tax_amt",0);
					sheetObj.SetCellEditable(Row, "inv_lse_chg_amt",1);
					sheetObj.SetCellValue(Row, "inv_cr_amt",0);
					sheetObj.SetCellValue(Row, "inv_tax_amt",0);
				}
			}
			if(sheetObj.ColSaveName(Col) == "inv_cr_amt" ){
				if(sheetObj.GetCellValue(Row, "chg_cd") == 'CRD'){
					sheetObj.SetCellValue(Row, "inv_cr_amt",-1 * Math.abs(sheetObj.GetCellValue(Row, "inv_cr_amt")));
				}
			}
			if(sheetObj.ColSaveName(Col) == "inv_lse_chg_amt" ||
					sheetObj.ColSaveName(Col) == "inv_tax_amt" || sheetObj.ColSaveName(Col) == "inv_cr_amt"  ){
				var invLseChgAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
	 			var invTaxAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
	 			var invCrAmt=Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
	 			formObj.lse_chg_amt3.value='0.00';
	     		formObj.inv_lse_chg_amt3.value=ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	     		formObj.diff3.value=ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
			}
			if(sheetObj.ColSaveName(Col) == "pay_chg_aud_rmk"){
				TAB_SAVE_STD=true;	// 
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
		 	}
			//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
			else if(sheetObj.ColSaveName(Col) == "chg_cd"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}else if(sheetObj.ColSaveName(Col) == "inv_ref_no"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}else if(sheetObj.ColSaveName(Col) == "inv_no"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}else if(sheetObj.ColSaveName(Col) == "eq_no"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}else if(sheetObj.ColSaveName(Col) == "inv_cr_amt"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}else if(sheetObj.ColSaveName(Col) == "inv_tax_amt"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}else if(sheetObj.ColSaveName(Col) == "inv_lse_chg_amt"){
				TAB_SAVE_STD=true;	// Save button enable
				doActionBtnEnable(tabObjects[0].GetSelectedIndex());
			}
			if(sheetObj.ColSaveName(Col) == "del_chk" ){
				//Row delte handling.
			}
			t4sheet1_ChkInvNo(sheetObj,Row,Col,Value);
		}
	}
	
	/**
	 * Sheet1 OnSaveEnd (Save) event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save button disable
			document.form.lse_chg_sts_cd.value='A';
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
	 
	/**
	 * Sheet1 OnSaveEnd (P.Amt Confirm) event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			document.form.lse_chg_sts_cd.value='S';
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}	 	 
	 
	/**
	 * Sheet2 OnSaveEnd (Save) event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save button disable
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
	 	
	/**
	 * Sheet4 OnSaveEnd (Save) event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function t4sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save button disable
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}	 
	 
	/** 
	 * Object Keypress event handling  <br>
	 * 
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */ 
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	      	 	
	    window.defaultStatus = obj.dataformat;
	      	 
	    switch(obj.dataformat) {
	     	case "ym": case "ymd":
	     		ComKeyOnlyNumber(obj);
	     		break;
	    	case "int":
	        	ComKeyOnlyNumber(obj);
	            break;
	     	case "float":
	 	        ComKeyOnlyNumber(obj, "-.");
	 	        break;    
	        case "eng":
	            ComKeyOnlyAlphabet(); 
	            break;
	        case "engup":
	      	    ComKeyOnlyAlphabet('upper');
	      	    break;
	      	case "engdn":
	      	    ComKeyOnlyAlphabet('lower');
	      	    break;
	    }
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
     	var formObj = document.form;
     	obj = event.srcElement;      	
     	
     	if(obj.name == 'inv_dt'){
     		ComChkObjValid(event.srcElement);
     	}
    } 
     /**
      * t1sheet1 Double Click -> info page <br>
      * @author 
      * @version
      */      
     function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
     	var formObj = document.form;
     	if(Col == 3) // chassis
     	{
       		var eqNo = sheetObj.CellValue(Row,Col);
     		if(eqNo != "")
     		{
 		  		var pgmNo = 'EES_CGM_2006';
 		  		var pgmUrl = '/opuscntr/EES_CGM_2006.do';
 		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';   
 		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 		    	ComOpenPopup("opusMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
 		    	ComOpenWindowCenter('/opuscntr/EES_CGM_2006.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 600, false);
     		}
     	}
     }
     /**
      * t2sheet1 Double Click -> info page <br>
      * @author 
      * @version 
      */      
     function t2sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
      	if(Col == 3) // chassis
     	{
       		var eqNo = sheetObj.CellValue(Row,Col);
     		if(eqNo != "")
     		{
 		  		var pgmNo = 'EES_CGM_2006';
 		  		var pgmUrl = '/opuscntr/EES_CGM_2006.do';
 		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';   
 		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 		    	ComOpenPopup("opusMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
 		    	ComOpenWindowCenter('/opuscntr/EES_CGM_2006.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 600, false);
     		}
     	}	
     }
    
     function t3sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
      	if(Col == 2) // chassis
     	{
       		var eqNo = sheetObj.CellValue(Row,Col);
     		if(eqNo != "")
     		{
 		  		var pgmNo = 'EES_CGM_2006';
 		  		var pgmUrl = '/opuscntr/EES_CGM_2006.do';
 		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';   
 		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 		    	ComOpenPopup("opusMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
 		    	ComOpenWindowCenter('/opuscntr/EES_CGM_2006.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 600, false);
     		}
     	}
     }

     function t4sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
        if(Col == 3) // Customer chassis
     	{
       		var eqNo = sheetObj.CellValue(Row,Col);
     		if(eqNo != "")
     		{
 		  		var pgmNo = 'EES_CGM_2006';
 		  		var pgmUrl = '/opuscntr/EES_CGM_2006.do';
 		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';   
 		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
//  		    	ComOpenPopup("opusMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
 		    	ComOpenWindowCenter('/opuscntr/EES_CGM_2006.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 600, false);
     		}
     	}else if(Col == 4) // OWN chassis
     	{
       		var eqNo = sheetObj.CellValue(Row,Col);
     		if(eqNo != "")
     		{
 		  		var pgmNo = 'EES_CGM_2006';
 		  		var pgmUrl = '/opuscntr/EES_CGM_2006.do';
 		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';   
 		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
//  		    	ComOpenPopup("opusMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
 		    	ComOpenWindowCenter('/opuscntr/EES_CGM_2006.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 600, false);
     		}
     	}
     }    
      
      

    function t4sheet1_ChkInvNo(sheetObj, Row, Col,Value)
     {
     	var formObj = document.form;
     	var t1sheet1 = sheetObjects[0];
     	var t2sheet1 = sheetObjects[1];
     	var t3sheet1 = sheetObjects[2];
     	var t4sheet1 = sheetObjects[3];
     	
     	var target=sheetObj.GetCellValue(Row,Col);
     	if(target == null || target == "")	return;
 		
     	if(Col == 5) // Invoice Reference No.
    	{
    		//check.
    		//sheet1
    		for(var i=0; i< t1sheet1.RowCount()-1; i++)
    		{
    			if(target == t1sheet1.GetCellValue(i+2, 6) )
    			{
    				return true;
    			}
    		}    		
    		//sheet2    		
    		for(var i=0; i< t2sheet1.RowCount()-1; i++)
    		{
    			if(target == t2sheet1.GetCellValue(i+2, 6) )
    			{
    				return true;
    			}
    		}
    		//sheet4    		
    		for(var i=0; i< t4sheet1.RowCount()-1; i++)
    		{
    			if(target == t4sheet1.GetCellValue(i+2, 5) )
    			{
    				return true;
    			}
    		}
    		ComShowCodeMessage("CGM20023", "Invoice Reference No.("+target+")");    		
    		sheetObj.SetCellValue(Row,Col,"",0);
    		return false;
    	}else if(Col == 6) // Invoice No.
    	{
    		if(t4sheet1.GetCellValue(Row, 7) != "CRD") // CRDcheck
    		{
	    		//check.
	    		for(var i=0; i< t1sheet1.RowCount()-1; i++)
	    		{
	    			if(target == t1sheet1.GetCellValue(i+2, 4) )
	    			{
	    				return true;
	    			}
	    		}    		
	    		for(var i=0; i< t2sheet1.RowCount()-1; i++)
	    		{
	    			if(target == t2sheet1.GetCellValue(i+2, 4) )
	    			{
	    				return true;
	    			}
	    		}    		
	    		for(var i=0; i< t4sheet1.RowCount()-1; i++)
	    		{
	    			if(target == t4sheet1.GetCellValue(i+2, 6) )
	    			{
	    				return true;
	    			}
	    		}
	    		ComShowCodeMessage("CGM20023", "Invoice No.("+target+")");
	    		sheetObj.SetCellValue(Row,Col,"",0);
	    		return false;
    		}else
    		{
    			return true; 
    		}
     	}
     }     
     
  
 function t4sheet1_enableEditingWhenLseChgAudStsCdIsNull(sheetObj, Row, Col,Value)
 {     
	 sheetObjects[3].SetEditable(1);
	for(var i=2; i<2+sheetObjects[3].RowCount(); i++)
	{
		if(sheetObjects[3].GetCellValue(i,"lse_chg_aud_sts_cd") == '')
		{
			sheetObjects[3].SetRowEditable(i,1);
			if(sheetObjects[3].GetCellValue(i, "chg_cd") == 'CRD'){
				sheetObjects[3].SetCellEditable(i, "chg_cd",0);
				sheetObjects[3].SetCellEditable(i, "inv_ref_no",1);
				sheetObjects[3].SetCellEditable(i, "inv_no",1);
				sheetObjects[3].SetCellEditable(i, "eq_no",0);
				sheetObjects[3].SetCellEditable(i, "inv_cr_amt",1);
				sheetObjects[3].SetCellEditable(i, "inv_tax_amt",0);
				sheetObjects[3].SetCellEditable(i, "inv_lse_chg_amt",0);
			} else if(sheetObjects[3].GetCellValue(i, "chg_cd") == 'TAX'){
				sheetObjects[3].SetCellEditable(i, "chg_cd",0);
				sheetObjects[3].SetCellEditable(i, "inv_ref_no",1);
				sheetObjects[3].SetCellEditable(i, "inv_no",1);
				sheetObjects[3].SetCellEditable(i, "eq_no",0);
				sheetObjects[3].SetCellEditable(i, "inv_cr_amt",0);
				sheetObjects[3].SetCellEditable(i, "inv_tax_amt",1);
				sheetObjects[3].SetCellEditable(i, "inv_lse_chg_amt",0);
			} else if(sheetObjects[3].GetCellValue(i, "chg_cd") == 'PDM'){
				sheetObjects[3].SetCellEditable(i, "chg_cd",0);
				sheetObjects[3].SetCellEditable(i, "inv_ref_no",1);
				sheetObjects[3].SetCellEditable(i, "inv_no",1);
				sheetObjects[3].SetCellEditable(i, "eq_no",0);
				sheetObjects[3].SetCellEditable(i, "inv_cr_amt",0);
				sheetObjects[3].SetCellEditable(i, "inv_tax_amt",0);
				sheetObjects[3].SetCellEditable(i, "inv_lse_chg_amt",1);
			}
			//sheetObjects[3].InitCellProperty(i,"chg_cd",dtComboEdit);
			//sheetObjects[3].CellComboItem(i, "chg_cd", "CRD|TAX|PDM","CRD|TAX|PDM");
	    	doActionBtnEnable(tabObjects[0].GetSelectedIndex());
		}	
		else
		{
			//sheetObjects[3].RowEditable(i) = false;
		}
	}
 }
	/* developer job end */