/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0954.jsp
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
	var prefix='surcharge_';
	var sheetObjects=new Array();
	var sheetCnt=0;
	/**Event handler processing by button click event */
	document.onclick=processButtonClick;
	var opener1 = window.dialogArguments;
	if (!opener1) opener1=window.parent;
	if (!opener1) opener1=window.opener;
	
	/**Event handler processing by button name */
	function processButtonClick(){
		  /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
		 var sheetObject=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
//				case "btn_ok":
//					var checkList=sheetObject.FindCheckedRow('ibcheck');
//					if(checkList == ''){
//						ComShowCodeMessage('COM12176');
//						return false;
//					}
//					var checkArray=checkList.split('|');
//					for(var i=0; i<checkArray.length; i++){
//						if(sheetObjects[0].GetCellValue(checkArray[i], 'lgs_cost_full_nm') == 'Basic Amount'){
//							if(sheetObjects[0].GetCellValue(checkArray[i], 'bsz_bill_case') == '' || sheetObjects[0].GetCellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].GetCellValue(checkArray[i], 'biller_cd') == '' ){
//								ComShowCodeMessage('COM12114', 'Bill Case and 3rd Party');
//								return false;
//							}
//						} else {
//							if(sheetObjects[0].GetCellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].GetCellValue(checkArray[i], 'biller_cd') == '' ){
//								ComShowCodeMessage('COM12114', '3rd Party');							
//								return false;
//							}
//						}					
//					}
//					doActionIBSheet(sheetObject,formObject,IBSAVE);
//					ComClosePopup();
//					break;
				case "btn_close":
					ComClosePopup();
				  break;
				case "btng_save":
					var checkList=sheetObject.FindCheckedRow('ibcheck');
					if(checkList == ''){
						ComShowCodeMessage('COM12176');
						return false;
					}			
					var checkArray=checkList.split('|');
					for(var i=0; i<checkArray.length; i++){
						if(sheetObjects[0].GetCellValue(checkArray[i], 'lgs_cost_full_nm') == 'Basic Amount'){
							if(sheetObjects[0].GetCellValue(checkArray[i], 'bsz_bill_case') == '' || sheetObjects[0].GetCellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].GetCellValue(checkArray[i], 'biller_cd') == '' ){
								ComShowCodeMessage('COM12114', 'Bill Case and 3rd Party');
								return false;
							}
						} else {
							if(sheetObjects[0].GetCellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].GetCellValue(checkArray[i], 'biller_cd') == '' ){
								ComShowCodeMessage('COM12114', '3rd Party');							
								return false;
							}
						}
						if(sheetObjects[0].GetCellValue(checkArray[i], 'n3pty_amt') <= 0 ){
							ComShowMessage('Amount is more than 0.\n\n Please check profit.');							
							return false;
						}
					}
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
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
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		var bzc_sheetObj = opener1.sheetObjects[0];
		var surcharge_sheetObj = sheetObjects[1];
		var formObj = document.form;
		sheetObjects[0].SetWaitImageVisible(false);
		formObj.f_cmd.value = SEARCH04;
		sheetObjects[0].DoSearch("ESD_TRS_0023GS.do", TrsFrmQryString(formObj), {Sync:2});
		sheetObjects[0].InitDataCombo(0, 'bsz_bill_case', sheetObjects[0].GetEtcData('bil_cs_nm'), sheetObjects[0].GetEtcData('bil_cs_cd'));
		if (formObj.open_mode.value == 'search'){
			if(formObj.step_cd.value != 'AD') {
				doActionIBSheet(surcharge_sheetObj, formObj, 'SEARCH_BY_SHEET');
			}
			if(surcharge_sheetObj.RowCount() < 1){	
				doActionIBSheet(surcharge_sheetObj, formObj, IBSEARCH);				
			}
		} else if(formObj.open_mode.value == 'modify'){
			if(formObj.step_cd.value != 'AD') {
				doActionIBSheet(surcharge_sheetObj, formObj, 'SEARCH_BY_SHEET');
			}
			if(surcharge_sheetObj.RowCount() < 1){
				doActionIBSheet(surcharge_sheetObj, formObj, IBSEARCH);
			}
		}
		readSurchargeSheet(sheetObjects[0], surcharge_sheetObj, bzc_sheetObj);
		if (sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), 'lgs_cost_full_nm') == 'Basic Amount'){
			if(document.form.sheet_arr_no.value  == 3){
				sheetObjects[0].SetRowEditable(sheetObjects[0].RowCount(), false);
			} else if(document.form.open_mode.value == 'search'){
				sheetObjects[0].SetEditable(false);
			} else {
				sheetObjects[0].SetCellEditable(sheetObjects[0].RowCount(), 'bsz_bill_case', true)
			}
		} else{
			if(document.form.open_mode.value == 'search'){
				sheetObjects[0].SetEditable(false);
			}
		}
		initControl();
	}
	
	
	function initControl() {
	    axon_event.addListener  ('click', 'manual_click', 'manual');    //If you change BKG Creation tab manual
	    axon_event.addListenerFormat('blur',    'obj_blur',     form);  
	    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');  
	    
	    if(document.form.open_mode.value == 'search' || document.form.sheet_arr_no.value  == 3) {
	    	document.getElementById('btng_save').style.display = "none";
	    } else {
	    	document.getElementById('btng_save').style.display = "";
	    }
	}
	
	
	/**
	 * BKG Creation manual. <br>
	 **/
	function manual_click() {
	}
	
	/**
	 * HTML Control onblur event Validation check. <br>
	 **/
	function obj_blur(){
	}
	
	/**
	 * HTML Control for the separator to remove the mask from the onfocus event. <br>
	 **/
	function obj_focus(){
	}
	
	
	/**
	 *  corresponds to a user's login OFFICE CD that is set to CURRENCY.
	 */
	function initCurrency(){
	}
	
	/**
	 * 3rd Party Currency existing saved sets..
	 */
	function callCurrency(){
	}
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var formObj = document.form;
		switch(sheetNo) {
			case 1:      //t1sheet1 init
			    with(sheetObj){
				      var HeadTitle="|TRS code|Billing Case|Amount|3rd Party|3rd Party|Remarks" ;
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                   {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bsz_bill_case",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				      if (formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
				    	  cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_amt",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
				      } else {
				    	  cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 });
				      }
				      cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bill_case",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"biller_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"unique_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"n3pty_vndr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"n3pty_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" });

				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty('bill_case', {ComboText:bill_caseText, ComboCode:bill_caseCode} );
	                  SetColHidden('ibflag',1);
	                  SetSheetHeight(300);
			      }
			break;
			case 2: //surcharge sheet
			    with(sheetObj){
				      var HeadTitle="" ;
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_step_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incur_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_no',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no_split',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incur_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_no',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_dry_run_rlbl_pty_tp_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fne_cuz_desc',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fumg_cost_tp_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_mgst_tpsz_cd',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_insp_rf_pti_cstms_tp_cd', KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_knt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_cuz_desc',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_stop_loc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_grs_wgt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incrt_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scl_stop_plc_nod_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_sto_dys',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no_split',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_curr_cd',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetVisible(0);
		            }
			   break;
			 case 3:      //t1sheet1 init
			    with(sheetObj){
				      var HeadTitle="|Billing Case|Amount|Remarks|Billing Case|" ;
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_bill_case",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
				    	  cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_n3pty_amt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      } else{
				    	  cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_n3pty_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_n3pty_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_n3pty_vndr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bsz_n3pty_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				      cols.push({Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" });
				      InitColumns(cols);
				      SetEditable(1);
				      SetColHidden('ibflag',1);
				      SetVisible(0);
			      }
			    break;
			 case 4:      //t1sheet1 init
				    with(sheetObj){
					      var HeadTitle="SO OFC|SO SEQ|IF_FLG";
					      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					      var headers = [ { Text:HeadTitle, Align:"Center"} ];
					      InitHeaders(headers, info);
					      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'if_so_ofc',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
					                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'if_so_seq',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
					                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'if_flg',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 } ];
					      InitColumns(cols);
					      SetEditable(1);
					      SetVisible(0);
			            }
				break;     
		}
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var TPB_sheetObj=sheetObjects[3];
		switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_TRS_0918GS.do", TrsFrmQryString(formObj) ,{Sync:2});
				break;
			case IBSAVE:      //save
				if (TPB_sheetObj.GetCellValue(1, 'if_flg') == 'Y' ) {
					ComShowMessage("This S/O was already interfaced to TPB and no more interface is available. \n\n Please have them manually processed, if necessary, in TPB " );
					break;
	            }
				setSurchargeSheet(sheetObj, sheetObjects[1]);
				setBasicSheet(sheetObj, opener1.sheetObjects[0]);
				set3rdPartyBilling(sheetObjects[1], formObj);
				break;
			case 'SEARCH_BY_SHEET':
				var queryStr='';
				var colName='';
				var sheetObj_surcharge=opener1.sheetObjects[formObj.sheet_arr_no.value];
				for(var row=1; row<sheetObj_surcharge.RowCount()+1; row++){
					if(formObj.unique_cd.value == sheetObj_surcharge.GetCellValue(row, prefix+'trsp_so_seq')){
						for(var i=0; i<= sheetObj_surcharge.LastCol(); i++){
							colName=sheetObj_surcharge.ColSaveName(i);
							queryStr += '&'+colName +'='+sheetObj_surcharge.GetCellValue(row, colName);
						}
					}
				}
				sheetObj.DoSearch("ESD_TRS_0969.screen", queryStr+'&'+TrsFrmQryString(formObj),{Sync:2, Append:false} );
				break;
		}
	}
	
	
	/**
	 * Surcharge Input Inquiry popup are in the data transfer
	 **/
	function set3rdPartyBilling(pop_sheetObj, formObj)
	{
		var row=formObj.main_row.value;
		var unique_cd=formObj.unique_cd.value;
		var surcharge_sheetObj=opener1.sheetObjects[formObj.sheet_arr_no.value];
		var main_sheetObj=opener1.sheetObjects[0];
		for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
		{
			if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
		}
		var queryStr=pop_sheetObj.GetSaveString(true, true, prefix+'ibcheck');
		var url='?prefix='+prefix;
		surcharge_sheetObj.DoSearch("ESD_TRS_0969.screen"+url, queryStr,{Append:true, Sync:2} );
		main_sheetObj.SetCellValue(formObj.main_row.value, 'n3pty_bil_flg','Y');
		main_sheetObj.SetCellValue(formObj.main_row.value, 'n3pty_curr_cd', surcharge_sheetObj.GetCellValue(formObj.main_row.value, prefix+'n3pty_curr_cd'));
		ComShowCodeMessage('COM12116', 'Save');
	}
	
	
	/**
	 * Read surcharge sheet placed on the main sheet.
	 */
	function readSurchargeSheet(mainSheetObj, surchargeSheetObj, bzc_sheetObj){
		var formObj=document.form;
		var queryStr=surchargeSheetObj.GetSaveString(true, false);
		var queryStr2='';
		if(document.form.open_mode.value == 'search' || document.form.sheet_arr_no.value  == 3){
			formObj.f_cmd.value=SEARCH05;
			sheetObjects[2].DoSearch("ESD_TRS_0023GS.do", TrsFrmQryString(formObj) ,{Sync:2});
			queryStr2=sheetObjects[2].GetSaveString(true, false);
		} else {
			queryStr2='&po_basic_rt='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'po_basic_rt');
			queryStr2 += '&n3pty_bzc_amt='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_amt');
			queryStr2 += '&n3pty_bzc_vndr_seq='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_vndr_seq');
			queryStr2 += '&n3pty_bzc_ofc_cd='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_ofc_cd');
			queryStr2 += '&n3pty_bzc_desc='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_desc');
			queryStr2 += '&n3pty_bzc_cust_seq='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_cust_seq');
			queryStr2 += '&n3pty_bzc_cust_cnt_cd='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_cust_cnt_cd');
			queryStr2 += '&n3pty_bzc_tp_cd='+bzc_sheetObj.GetCellValue(document.form.main_row.value, 'n3pty_bzc_tp_cd');
		}
		mainSheetObj.DoSearch("ESD_TRS_0971.screen", queryStr+queryStr2+"&"+ TrsFrmQryString(formObj),{Append:true, Sync:2}  );
		if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
			for(var i=1; i< mainSheetObj.RowCount() + 1; i++){
				mainSheetObj.SetCellValue(i, 'n3pty_amt',chkAmtPos_JPY(mainSheetObj.GetCellValue(i, 'n3pty_amt')),0);
			}
		}
	}
	/**
	 * popup click event
	 */
	function sheet1_OnPopupClick (sheetObj , row , col )
	{
		var colName=sheetObj.ColSaveName(col);
		var value=sheetObj.GetCellValue(row, colName);
		switch(colName)
		{
			case('biller_cd'):
				if (sheetObj.GetCellValue(row, 'bill_case') == 'CS'){
					ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 460, 'getCustomerPop', '1,0,1,1,1,1,1,1',true, false,row,col);
				} else if(sheetObj.GetCellValue(row, 'bill_case') == 'SP'){
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 440, 'getVndrSeq', '1,0,1,1,1,1,1,1',true, false,row,col);
				} else if(sheetObj.GetCellValue(row, 'bill_case') == 'CT'){
					ComOpenPopup('/opuscntr/COM_ENS_091.do', 780, 540, 'getStaffPop', '1,0,1,1,1,1,1,1',true, false,row,col);
				}
			break;
		}
	}
	/**
	 * OnChange click event
	 */
	function sheet1_OnChange(sheetObj, row, col, value)
	{
		var colName=sheetObj.ColSaveName(col);
		var value=sheetObj.GetCellValue(row, colName);
		switch(colName)
		{
			case('bill_case'):
				sheetObj.SetCellValue(row, 'biller_cd','',0);
				sheetObj.SetCellValue(row, 'cust_cnt_cd','',0);
				sheetObj.SetCellValue(row, 'cust_seq','',0);
				sheetObj.SetCellValue(row, 'n3pty_vndr_seq','',0);
				sheetObj.SetCellValue(row, 'n3pty_ofc_cd','',0);
			break;
			
			case('n3pty_amt'):
			case('biller_cd'):
			case('n3pty_desc'):
			sheetObj.SetCellValue(row, 'ibcheck',1,0);
			break;
		}
	}
	/**
	 *  When an error occurs, save the results to a common processing function
	 * DataSheetObject.prototype.event_OnSearchEnd defined in IBSheetConfig.js
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var bil_curr_cd=null;
		var n3pty_curr_cd=null;
		if( errMsg != null && errMsg != '' ) {
			ComShowMessage(errMsg);
			formObj.f_cmd.value='';
		} else {
			if (formObj.f_cmd.value == SEARCH12){
				bil_curr_cd=sheetObj.GetEtcData('bil_curr_cd');
			} else if(formObj.f_cmd.value == SEARCH17){
				n3pty_curr_cd=sheetObj.GetEtcData('n3pty_curr_cd');
			}
			var selectObj=formObj.apply_currency;
			for(var i=0; i<selectObj.length; i++){
				if( selectObj.options[i].value == bil_curr_cd){
					selectObj.options[i].selected=true;
					selectedIdx=i;
					break;
				} else if(selectObj.options[i].value == n3pty_curr_cd){
					selectObj.options[i].selected=true;
					selectedIdx=i;
					break;
				}
			}
			
			if(document.form.sheet_arr_no.value  == 3) {
				sheetObjects[0].SetEditable(false);
			} else {
				for(var i =0; i < sheetObj.RowCount(); i++) {
					if(sheetObj.GetCellValue(i, 'lgs_cost_full_nm')!= 'Basic Amount'){
						sheetObj.SetCellEditable(i, 'bsz_bill_case', 0);
					}
				}
			}
			formObj.f_cmd.value='';
		}
	}
	/**
	 * When an error occurs, save the results to a common processing function
	 * 
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
	}
	/**
	 * Get the value from the pop-up  customer
	 */
	function getCustomerPop(rowArray, row, col){
		var formObj=document.form;
		var colArray='';
		if(rowArray.length>0)
		{
			colArray=rowArray[0][3];
		}
		sheetObjects[0].SetCellValue(row, 'biller_cd',colArray);
		sheetObjects[0].SetCellValue(row, 'cust_cnt_cd',colArray.substring(0,2),0);
		sheetObjects[0].SetCellValue(row, 'cust_seq',get_only_num(colArray),0);
	}
	/**
	 * call rep_commodity pop-up :If a single selection from a pop-up..
	 */
	function getVndrSeq(rowArray, row, col) {
		var formObj=document.form;
		var colArray='';
		if(rowArray.length>0)
		{
			colArray=get_only_num(rowArray[0][2]);
		}
		sheetObjects[0].SetCellValue(row, 'biller_cd',colArray);
		sheetObjects[0].SetCellValue(row, 'n3pty_vndr_seq',colArray,0);
	}
	/**
	 * Get the value from the pop-up staff
	 */
	function getStaffPop(rowArray, row, col){
		var formObj=document.form;
		var colArray='';
		if(rowArray.length>0)
		{
			colArray=rowArray[0][3];
		}
		sheetObjects[0].SetCellValue(row, 'biller_cd',colArray);
		sheetObjects[0].SetCellValue(row, 'n3pty_ofc_cd',colArray,0);
	}
	/**
	 * only  numbers
	 */
	function get_only_num(obj) {
		var str=escape(obj);
		var returnNum='';
		for (i=0; i<str.length; i++){
			if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
			returnNum += str.charAt(i);
		}
		return returnNum;
	}
	/**
	 * Surcharge sheet should move to the value of
	 */
	function setSurchargeSheet(mainSheet, surchargeSheet){
		var checkList=mainSheet.FindCheckedRow('ibcheck');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		var checkArray=checkList.split('|');
		var cnt=0;
		var index=0;
		var formObj=document.form;
		var invSurchgSheet=opener1.sheetObjects[3];
		for(var i=0; i<checkArray.length; i++)
		{		
			if(sheetObjects[0].GetCellValue(checkArray[i], 'lgs_cost_full_nm') == 'Basic Amount'){
				return false;
			}
			index=surchargeSheet.FindText(prefix+'lgs_cost_cd', mainSheet.GetCellValue(checkArray[i],'lgs_cost_cd'));
			surchargeSheet.SetCellValue(index, prefix+'unique_cd',formObj.unique_cd.value,0);
			surchargeSheet.SetCellValue(index, prefix+'n3pty_amt',mainSheet.GetCellValue(checkArray[i],'n3pty_amt'),0);
			surchargeSheet.SetCellValue(index, prefix+'n3pty_desc',mainSheet.GetCellValue(checkArray[i],'n3pty_desc'),0);
			surchargeSheet.SetCellValue(index, prefix+'cust_cnt_cd',mainSheet.GetCellValue(checkArray[i],'cust_cnt_cd'),0);
			surchargeSheet.SetCellValue(index, prefix+'cust_seq',mainSheet.GetCellValue(checkArray[i],'cust_seq'),0);
			surchargeSheet.SetCellValue(index, prefix+'n3pty_vndr_seq',mainSheet.GetCellValue(checkArray[i],'n3pty_vndr_seq'),0);
			surchargeSheet.SetCellValue(index, prefix+'n3pty_ofc_cd',mainSheet.GetCellValue(checkArray[i],'n3pty_ofc_cd'),0);
			surchargeSheet.SetCellValue(index, prefix+'n3pty_curr_cd',document.form.apply_currency.value,0);
			surchargeSheet.SetCellValue(index, prefix+'n3pty_bil_flg','Y',0);
		}
	}
	/**
	 * 
	 * Basic sheet should move to the value of
	 */
	function setBasicSheet(mainSheet, basicSheet){
		var checkList=mainSheet.FindCheckedRow('ibcheck');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		var formObj=document.form;
		var row=sheetObjects[0].RowCount();
		if(sheetObjects[0].GetCellValue(row, 'lgs_cost_full_nm') == 'Basic Amount' && sheetObjects[0].GetCellValue(row, 'ibcheck') == true){
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_amt',mainSheet.GetCellValue(mainSheet.RowCount(),'n3pty_amt'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_vndr_seq',mainSheet.GetCellValue(mainSheet.RowCount(),'n3pty_vndr_seq'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_ofc_cd',mainSheet.GetCellValue(mainSheet.RowCount(),'n3pty_ofc_cd'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_desc',mainSheet.GetCellValue(mainSheet.RowCount(),'n3pty_desc'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_cust_seq',mainSheet.GetCellValue(mainSheet.RowCount(),'cust_seq'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_cust_cnt_cd',mainSheet.GetCellValue(mainSheet.RowCount(),'cust_cnt_cd'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_tp_cd',mainSheet.GetCellValue(mainSheet.RowCount(),'bsz_bill_case'),0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_curr_cd',document.form.apply_currency.value,0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bil_flg','Y',0);
		}
	}
	/**
	 *Basic sheet should move to the value of
	 */
	function setBasicSheet2(mainSheet, basicSheet){
		var checkList=mainSheet.FindCheckedRow('ibcheck');
		if(checkList != ''){
			return false;
		}
		var formObj=document.form;
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_amt','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_vndr_seq','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_ofc_cd','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_desc','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_cust_seq','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_cust_cnt_cd','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_tp_cd','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bzc_curr_cd','',0);
			basicSheet.SetCellValue(document.form.main_row.value, 'n3pty_bil_flg','',0);
	}
	
	function checkTPBIf() {
		var formObj=document.form;
		var sheetObj=sheetObjects[3];
			formObj.f_cmd.value=SEARCH04;
			sheetObj.DoSearch("ESD_TRS_0918GS.do", TrsFrmQryString(formObj) ,{Sync:2});
		var if_flg=sheetObj.GetEtcData('if_flg')
		if (if_flg=='Y'){
				ComShowMessage("This S/O was already interfaced to TPB and no more interface is available. \n\n Please have them manually processed, if necessary, in TPB " );
		}
	 return if_flg;
	}