/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2001.js
*@FileTitle  : Receipts
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Receipts : business script for STM_SAR_2001
     */
     
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var loadPageflg="";
	var retrieveFlg="";
	var payAcctCd="";
	var amtSgnCd="";
	var hdrDupFlg="N";
	var dtlDupFlg="N";
	var rdOpenFlg="N";
	var bfr_hdr_seq="";
	var bfrAplyAmt="";
	var pasteArray="";
	var pasteArrayLen=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
     	try {
			var srcName=ComGetEvent("name");  
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_deposit":
					var rctOfcCd=formObj.ots_ofc_cd.value;
					var classId="STM_SAR_0011";
					var param='?rct_ofc_cd='+rctOfcCd+'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_0011.do' + param, 910, 530, 'getSTM_SAR_0011', '0,0', true, false);
					break;
				case "btn_otsadd":
					formObj.ots_srch_flg.value="N";
					doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC11);
					break;
				case "btn_search":
					//Check mandatory items
					if(rct_tp_cd.GetSelectCode()== "CHQ"){
						if(ComIsEmpty(formObj.chq_no)){
							ComShowCodeMessage("COM130403", "Cheque No");
							ComSetFocus(formObj.chq_no);
							break;
						}
					}
					if(ComIsEmpty(formObj.bank_acct_nm)){
						ComShowCodeMessage("COM130403", "Bank");
						break;
					}
					if(ComIsEmpty(formObj.rct_dt)){
						ComShowCodeMessage("COM130403", "Receipt Date");
						ComSetFocus(formObj.rct_dt);
						break;
					}
					if(ComIsEmpty(formObj.rct_dps_dt)){
						ComShowCodeMessage("COM130403", "Deposit Date");
						ComSetFocus(formObj.rct_dps_dt);
						break;
					}
					if(ComIsEmpty(formObj.rct_amt)){
						ComShowCodeMessage("COM130403", "Receipt Amount");
						ComSetFocus(formObj.rct_amt);
						break;
					}
					if(rct_tp_cd.GetSelectCode() == ""){
						ComShowCodeMessage("COM130403", "Receipt Type");
						//ComSetFocus(rct_tp_cd);
						break;
					}
					if(formObj.local_chg_flag.value == "Y") {
						
						if(formObj.invoice_type.value == ""){
							ComShowCodeMessage("COM130403", "Invoice Type");
							break;
						}
						
						if(formObj.bound_type.value == ""){
							ComShowCodeMessage("COM130403", "Bound");
							break;
						}
					}
					
					var rctOfcCd=formObj.ots_ofc_cd.value;
					var rct_curr_cd = formObj.rct_curr_cd.value;
					var ots_rct_tmp_seq = formObj.ots_rct_tmp_seq.value;
					var rctTpCd = rct_tp_cd.GetSelectCode();
					var classId="STM_SAR_0012";
					var param='?rct_ofc_cd='+rctOfcCd+'&rct_curr_cd='+rct_curr_cd+'&ots_rct_tmp_seq='+ots_rct_tmp_seq+'&rct_tp_cd='+rctTpCd+'&pop_yn=Y&classId='+classId;
					if(formObj.local_chg_flag.value == "Y") {
						param = param + "&local_chg_flag=Y&bound_type=" + formObj.bound_type.value+"&invoice_type=" + formObj.invoice_type.value;
					}

					ComOpenPopup('/opuscntr/STM_SAR_0012.do' + param, 900, 610, 'getSTM_SAR_0012', '0,1', true, false);
					
					break;
				case "btn_reverse":
					if(sheetObject1.RowCount()== 0) break;
					var chkCnt=0;
					var unChkCnt=0;
					var unapyFlg=formObj.rct_unapy_flg.value;
					var point=formObj.dp_prcs_knt.value;
					var rvsAmt=0;
					var rctAmt=ComRound(parseFloat(ComReplaceStr(formObj.rct_amt.value, ",", "")), 3);
					var ttlAmt=ComRound(parseFloat(ComReplaceStr(ComNullToZero(formObj.ttl_amt.value), ",", "")), point);
 					for(var i=1; i <= sheetObject1.RowCount(); i++){
 						var selChk=sheetObject1.GetCellValue(i, "selchk");
 						var aplyFlg=sheetObject1.GetCellValue(i, "rct_aply_flg");
 						var hdr_seq=sheetObject1.GetCellValue(i, "rct_aply_hdr_seq");
 						if(selChk == 1) {
							for(var j=1; j <= sheetObject2.RowCount(); j++){
				 				var dtl_hdr_seq=sheetObject2.GetCellValue(j, "rct_aply_hdr_seq");
				 				if(hdr_seq == dtl_hdr_seq){
				 					rvsAmt = rvsAmt + ComRound(parseFloat(ComNullToZero(ComReplaceStr(sheetObject2.GetCellValue(j, "rct_aply_amt"), ",", ""))), point);
				 				}
							}	
							chkCnt++;
						}
						if(selChk == 0 && aplyFlg == "Y") unChkCnt++;
					}
					if(chkCnt == 0) break;
					if(unChkCnt == 0) formObj.rvs_all_flg.value="Y";
					else formObj.rvs_all_flg.value="N";
					//All B/L must be reversed in case of no unapply office
					if(unapyFlg == "N" && unChkCnt > 0){
						ComShowCodeMessage("SAR00015");
						break;
					}
					if((ttlAmt - rvsAmt) > rctAmt){
 						ComShowCodeMessage("SAR00081");
						break;
					}
					if(!ComShowCodeConfirm("SAR00062")) break;
					formObj.save_kind_cd.value="R";
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				case "btn_del1":
					if(sheetObject1.RowCount()== 0) break;
					//Can delete row only in case of new B/L info
					var aply_flg=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "rct_aply_flg");
					if(aply_flg == "Y") break;
					var hdr_seq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "rct_aply_hdr_seq");
					sheetObject1.RowDelete(sheetObject1.GetSelectRow(), false);
					sheetObject2.SetSelectRow(-1,false);
 					var dtlRows=sheetObject2.RowCount();
					//Delete detail rows matched with deleted header info
					for(var i=dtlRows; i >= 1; i--){
						var dtl_hdr_seq=sheetObject2.GetCellValue(i, "rct_aply_hdr_seq");
						if(hdr_seq == dtl_hdr_seq){
							sheetObject2.RowDelete(i, false);
						}
					}
					
					var point=formObj.dp_prcs_knt.value;
					var subTotal = SarRound(parseFloat(ComReplaceStr(formObj.bl_ttl_amt.value, ",", "")) * (-1), point);
					calTotalAmount(subTotal);
					
					sheetObject1.SelectCell(sheetObject1.GetSelectRow(), 0, false);
     				sheet1_OnDblClick(sheetObject1, sheetObject1.GetSelectRow());
     				if(sheetObject1.RowCount()== 0){
     					formObj.bank_chg_amt.value="";
     					ComEnableObject(formObj.bank_chg_amt, false);
     					formObj.bank_chg_amt.className="input2";
     					formObj.bank_acct_nm.className="input1";
     					rct_tp_cd.SetEnable(1);
     					formObj.btns_bank.disabled=false;
     					calApplyAmount();
     				}
					break;
				case "btn_add":
					if(sheetObject1.RowCount()== 0) break;
					sheetObject2.DataInsert(-1);
					var point=formObj.dp_prcs_knt.value;
					//Add new detail row
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_hdr_seq",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "rct_aply_hdr_seq"),0);
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_src_curr_cd",formObj.rct_curr_cd.value,0);
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_xch_rt","1",0);
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_curr_cd",formObj.rct_curr_cd.value,0);
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "dp_prcs_knt",point,0);
					sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_flg","N",0);
					sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "wrtf_cd",1);
					//Set apply amount precision
					if(point == '0' || point == "undefined" || point == "") {
 						sheetObject2.InitCellProperty(sheetObject2.GetSelectRow(), "ots_aply_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
 						sheetObject2.InitCellProperty(sheetObject2.GetSelectRow(), "rct_aply_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
     				} else {
      					sheetObject2.InitCellProperty(sheetObject2.GetSelectRow(), "ots_aply_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
      					sheetObject2.InitCellProperty(sheetObject2.GetSelectRow(), "rct_aply_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
     				}
					break;
				case "btn_del2":	
					if(sheetObject2.RowCount()== 0) break;
					var rowCnt=0;
 					for(var i=1; i <= sheetObject2.RowCount(); i++){
						if(!sheetObject2.GetRowHidden(i)){
							rowCnt++;
						}
					}
					if(rowCnt == 1){
						ComShowCodeMessage("SAR00009");
						break;
					}
					//Can delete row only in case of new B/L info
					var aply_flg=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "rct_aply_flg");
					if(aply_flg == "Y") break;
					if(!sheetObject2.GetRowHidden(sheetObject2.GetSelectRow())) {
						var point=formObj.dp_prcs_knt.value;
						var chgAmt=ComNullToZero(ComReplaceStr(sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "rct_aply_amt"), ",", ""));
						var subTotal = ComReplaceStr(formObj.bl_ttl_amt.value, ",", "");
						subTotal=ComRound(parseFloat(subTotal), point) - ComRound(parseFloat(chgAmt), point);

						formObj.bl_ttl_amt.value=ComRound(subTotal, point);
						if(point == "0"){
							formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###");
						} else if(point == "1"){
							formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.0");
						} else if(point == "" || point == "2"){
							formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.00");
						}
						calTotalAmount(SarRound(parseFloat(chgAmt) * (-1), point));
						sheetObject2.RowDelete(sheetObject2.GetSelectRow(), false);
					}
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1, formObj, IBCLEAR);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
 				case "btn_save":
 					if(ComIsEmpty(formObj.rct_seq) || 
 					   agn_ofc_cd.GetSelectCode() != formObj.tmp_agn_ofc_cd.value || 
 					   asa_no.GetSelectCode() != formObj.tmp_asa_no.value ||
 					   formObj.rct_cust_cnt_cd.value != formObj.tmp_cust_cnt_cd.value ||
 					   formObj.rct_cust_seq.value != formObj.tmp_cust_seq.value ||
 					   formObj.rct_rmk.value != formObj.tmp_rmk.value ||
 					   formObj.bank_chg_amt.value != formObj.tmp_bank_chg_amt.value ||
 					   sheetObject2.FindText("rct_aply_flg","N") != -1) {
 							formObj.save_kind_cd.value="S";
 							doActionIBSheet(sheetObject1, formObj, IBSAVE);
 					} else {
 						ComShowCodeMessage("SAR00059");
 					}
 					break;
 				case "btn_receipt":
 					rdOpenFlg = "Y";
 					
 					if(ComIsEmpty(formObj.rct_seq) || 
 					   agn_ofc_cd.GetSelectCode() != formObj.tmp_agn_ofc_cd.value || 
 					   asa_no.GetSelectCode() != formObj.tmp_asa_no.value ||
 					   formObj.rct_cust_cnt_cd.value != formObj.tmp_cust_cnt_cd.value ||
 					   formObj.rct_cust_seq.value != formObj.tmp_cust_seq.value ||
 					   formObj.rct_rmk.value != formObj.tmp_rmk.value ||
 					   formObj.bank_chg_amt.value != formObj.tmp_bank_chg_amt.value ||
 					   sheetObject2.FindText("rct_aply_flg","N") != -1) {
 							formObj.save_kind_cd.value="S";
 							doActionIBSheet(sheetObject1, formObj, IBSAVE);
 					} else {
 						if(formObj.rct_sts_cd.value!="UNID") rdOpen();
 						rdOpenFlg = "N";
 					}
 					
 					break;
				case "btn_cancel":
					var rct_dps_dt=formObj.rct_dps_dt.value;
					var rctOfcCd=formObj.ots_ofc_cd.value;
					var classId="STM_SAR_0013";
					var param='?rct_dps_dt=' + rct_dps_dt + '&rct_ofc_cd=' + rctOfcCd + '&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_0013.do' + param, 480, 260, 'getSTM_SAR_0013', '0,0', true, false);
					break;
				case "btns_bank":
					if(formObj.btns_bank.disabled == true) return;
					var rctTpCd= rct_tp_cd.GetSelectCode();
					var rctOfcCd=formObj.ots_ofc_cd.value;
					var bank_ctrl_cd=formObj.bank_ctrl_cd.value;
					var classId="STM_SAR_0005";
					var param='?rct_tp_cd='+rctTpCd+'&rct_ofc_cd='+rctOfcCd+'&bank_ctrl_cd='+bank_ctrl_cd+'&pop_yn=Y&classId='+classId;
					if(formObj.local_chg_flag.value == "Y") {
						param = param + "&local_chg_flag=Y&local_curr_cd=" + formObj.ar_curr_cd.value;
					}
					ComOpenPopup('/opuscntr/STM_SAR_0005.do' + param, 500, 470, 'getSTM_SAR_0005', '0,0', true, false);
					break;	
				case "btns_calendar1":
					if(formObj.btns_calendar1.disabled == true) return;
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.rct_dt, 'yyyy-MM-dd');
					break;	
				case "btns_calendar2":
					if(formObj.btns_calendar2.disabled == true) return;
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.rct_dps_dt, 'yyyy-MM-dd');
					break;	
				case "btns_cust":
					if(formObj.btns_cust.disabled == true) return;
					var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
					var cust_seq=formObj.rct_cust_seq.value;
					var classId="STM_SAR_9003";
					var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 400, 'getSTM_SAR_9003', '0,0', true, false);
					break;
				case "btns_cust_info":
					var formObject=document.form; 
					if(formObject.rct_cust_cnt_cd.value != "" && formObject.rct_cust_seq.value != "") {
						var param='?cust_cnt_cd='+formObject.rct_cust_cnt_cd.value+'&cust_seq='+formObject.rct_cust_seq.value+'&pop_yn=Y&ret_yn=Y';
						ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1150, 650, 'getPopData', '0,0', true, false, "", "", 0);
					}
					break; 
				case "btn_view_accounting":					
					if (validateForm(sheetObject1, formObj, IBSEARCH)) {
						sheetObject1.ShowDebugMsg(false);
						var param="rct_no=" + formObj.rct_no.value + "&rct_ofc_cd=" + formObj.ots_ofc_cd.value + "&ots_smry_cd=" + formObj.ots_smry_cd.value;
						var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_2005.do?" + param, "view_accounting_popup", 800, 520, false, "no");
						popupWin.focus();
					}
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
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		ComBtnDisable("btn_cancel");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
					var HeadTitle1="|Sel|B/L No|Invoice No|Booking No|Office|Customer|VVD|Trunk VVD|S/A Date|Bound|Due Date|Ex.Rate Type|Source|rhq cd|ofc cd|Issue Date|Cntry Code|Cust Seq|SRep Code|OTS RMK|Exrate Type Code|Exrate Date|CR FLG|MAX IF NO|Apply Amount|HDR Seq|Aply Flag";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"selchk" },
					             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ots_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bil_to_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"locl_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trnk_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"sail_arr_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"due_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xch_rt_tp_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ar_finc_src_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inv_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bil_to_cust_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bil_to_cust_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ots_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"xch_rt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"xch_rt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"max_ar_if_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_hdr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					InitColumns(cols);
					SetCountPosition(0);
					SetEditable(1);
					SetColProperty("sail_arr_dt", {Format:"Ymd"} );
					SetColProperty("due_dt", {Format:"Ymd"} );
					//SetSheetHeight(170);
					resizeSheet();
				}
			    break;
			case 2:      // sheet1 init
				with (sheetObj) {
					var HeadTitle1="|Write-Off|Charge|S.CUR|Outstanding|Amount|EX. Rate|T.CUR|Apply Amount|OTS Exrate|Write-Off Remark|AP Office|Vendor No|AP Remark|AP G/L Date|DP Prcs|DTL Seq|HDR Seq|Aply Flag|Pay Acct Cd";
					var headCount=ComCountHeadTitle(HeadTitle1) ;
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wrtf_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_chg_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_src_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ots_bal_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"ots_aply_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"rct_aply_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:6,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rct_curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"rct_aply_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ots_xch_rt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"wrtf_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ap_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ap_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ap_gl_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_prcs_knt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_dtl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_hdr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pay_acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					InitColumns(cols);
					SetCountPosition(0);
					SetEditable(1);
					//SetSheetHeight(170);
					resizeSheet();
					SetFocusEditMode(1);
//					SetExtendLastCol(0);
				}
				break;   
		}
	}
	function sheet1_OnClick(sheetObj, Row, Col) {
		sheet1_OnDblClick(sheetObj, Row, Col);
	}
	function sheet1_OnDblClick(sheetObj, Row, Col){
		var formObj=document.form;
		var sheetObject1=sheetObjects[1];	
		var hdr_seq=sheetObj.GetCellValue(Row, "rct_aply_hdr_seq");
		var dpRow="";
		var hidRow="";
		var point=formObj.dp_prcs_knt.value;
		var subTotal=0;
		//Display detail rows by selected header row
		if(sheetObject1.RowCount() > 0){	
 			for(var i=1; i <= sheetObject1.RowCount(); i++){
 				var dtl_hdr_seq=sheetObject1.GetCellValue(i, "rct_aply_hdr_seq");
				if(hdr_seq == dtl_hdr_seq){
					if(dpRow == "") dpRow = i;
					else dpRow = dpRow + "|" + i;
					var chgAmt=ComNullToZero(ComReplaceStr(sheetObject1.GetCellValue(i, "rct_aply_amt"), ",", ""));
					subTotal=ComRound(parseFloat(subTotal), point) + ComRound(parseFloat(chgAmt), point);
				}else{
					if(bfr_hdr_seq != "" && bfr_hdr_seq == dtl_hdr_seq) {
						if(hidRow == "") hidRow = i;
						else hidRow = hidRow + "|" + i;
					}
				}
			}
 			if(dpRow != "") sheetObject1.SetRowHidden(dpRow, 0);
 			if(hidRow != "") sheetObject1.SetRowHidden(hidRow, 1);
 			bfr_hdr_seq=sheetObj.GetCellValue(Row, "rct_aply_hdr_seq");
 			
 			formObj.bl_ttl_amt.value=ComRound(subTotal, point);
			if(point == "0"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###");
			} else if(point == "1"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.0");
			} else if(point == "" || point == "2"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.00");
			}	
		}
	}
	function sheet2Change(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var selIndex=sheetObj.GetComboInfo(Row, "wrtf_cd", "SelectedIndex");
		
		if(sheetObj.ColSaveName(Col) == "ots_aply_amt"){
			var chgCurrPoint=sheetObj.GetCellValue(Row, "dp_prcs_knt");
			sheetObj.SetCellValue(Row, "ots_aply_amt",ComTrunc(sheetObj.GetCellValue(Row, "ots_aply_amt"), chgCurrPoint),0);
		}
		
		//Check amount sign
		if(sheetObj.ColSaveName(Col) == "ots_aply_amt" || sheetObj.ColSaveName(Col) == "wrtf_cd"){
			if(amtSgnCd[selIndex] == "M" && sheetObj.GetCellValue(Row, "ots_aply_amt") > 0){
				ComShowCodeMessage("SAR00027", sheetObj.GetCellValue(Row, "wrtf_cd"));
				sheetObj.SetCellValue(Row, "ots_aply_amt", "");
				sheetObj.SelectCell(Row, "ots_aply_amt", true, "");
				return;
			}
			if(amtSgnCd[selIndex] == "P" && sheetObj.GetCellValue(Row, "ots_aply_amt") < 0){
				ComShowCodeMessage("SAR00026", sheetObj.GetCellValue(Row, "wrtf_cd"));
				sheetObj.SetCellValue(Row, "ots_aply_amt", "");
				sheetObj.SelectCell(Row, "ots_aply_amt", true, "");
				return;
			}
			//Check MI/ML Limit Amount 2014.09.16
			if((sheetObj.GetCellValue(Row, "wrtf_cd") == "MI" || sheetObj.GetCellValue(Row, "wrtf_cd") == "ML") && 
			    sheetObj.GetCellValue(Row, "ots_aply_amt") != "0" && sheetObj.GetCellValue(Row, "ots_aply_amt") != ""){
				formObj.misc_ofc_cd.value = formObj.ots_ofc_cd.value;
				formObj.misc_tp_cd.value = sheetObj.GetCellValue(Row, "wrtf_cd");
				formObj.misc_xch_rt_dt.value = formObj.rct_dt.value;
				formObj.misc_amt.value = sheetObj.GetCellValue(Row, "ots_aply_amt");
				formObj.misc_curr_cd.value = sheetObj.GetCellValue(Row, "rct_curr_cd");
				
				formObj.f_cmd.value = SEARCH13;
				var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var chkMiscLmt = ComGetEtcData(sXml,"chk_misc_lmt");
				
				if(chkMiscLmt != "Y") {
					if(chkMiscLmt == "R") ComShowCodeMessage("SAR00025");
					else if(chkMiscLmt == "X") ComShowCodeMessage("SAR00045");
					else if(chkMiscLmt == "N") ComShowCodeMessage("SAR00046", sheetObj.GetCellValue(Row, "wrtf_cd"));
				
					sheetObj.SetCellValue(Row, "ots_aply_amt", "");
					sheetObj.SelectCell(Row, "ots_aply_amt", true, "");
					return;
				}
			}
		}
		//Check exchange rate sign
		if(sheetObj.ColSaveName(Col) == "rct_aply_xch_rt"){
			if(sheetObj.GetCellValue(Row, "rct_aply_xch_rt") < 0){
				ComShowCodeMessage("SAR00028");
				sheetObj.SetCellValue(Row, "rct_aply_xch_rt", "0");
				sheetObj.SelectCell(Row, "rct_aply_xch_rt", true, "");
				return;
			}
		}
		//Calculate receipt currency's apply amount with apply amount and exchange rate
		if(sheetObj.ColSaveName(Col) == "ots_aply_amt" || sheetObj.ColSaveName(Col) == "rct_aply_xch_rt"){
			var point=formObj.dp_prcs_knt.value;
			sheetObj.SetCellValue(Row, "rct_aply_amt",SarRound(sheetObj.GetCellValue(Row, "ots_aply_amt") * sheetObj.GetCellValue(Row, "rct_aply_xch_rt"), point),0);
					
			var chgAmt=ComNullToZero(ComReplaceStr(sheetObj.GetCellValue(Row, "rct_aply_amt"), ",", ""));
			var subTotal = ComReplaceStr(formObj.bl_ttl_amt.value, ",", "");
			var difAmt = ComRound(parseFloat(chgAmt), point) - ComRound(parseFloat(bfrAplyAmt), point);
			subTotal=ComRound(parseFloat(subTotal), point) + ComRound(parseFloat(difAmt), point);

			formObj.bl_ttl_amt.value=ComRound(subTotal, point);
			if(point == "0"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###");
			} else if(point == "1"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.0");
			} else if(point == "" || point == "2"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.00");
			}
			calTotalAmount(difAmt);
		} 
		if(sheetObj.ColSaveName(Col) == "wrtf_cd"){
			sheetObj.SetCellValue(Row, "pay_acct_cd",payAcctCd[selIndex],0);
			if(!ComIsEmpty(payAcctCd[selIndex])){	
				var rct_dps_dt=formObj.rct_dps_dt.value;
				var classId="STM_SAR_0008";
				var param='?rct_dps_dt='+rct_dps_dt+'&pop_yn=Y&classId='+classId;
				ComOpenPopup('/opuscntr/STM_SAR_0008.do' + param, 700, 260, 'getSTM_SAR_0008', '0,0', true, false);
			} else {
				sheetObj.SetCellValue(Row, "wrtf_rmk","",0);
				sheetObj.SetCellValue(Row, "ap_ofc_cd","",0);
				sheetObj.SetCellValue(Row, "vndr_no","",0);
				sheetObj.SetCellValue(Row, "ap_gl_dt","",0);
				sheetObj.SetCellValue(Row, "ap_rmk","",0);
			}
		}
	}
	function sheet2_OnBeforeEdit(sheetObj, Row, Col) {
		var formObj=document.form;
		var currPoint=formObj.dp_prcs_knt.value;
		var point=sheetObj.GetCellValue(Row, "dp_prcs_knt");
		if(point == '0' || point == "undefined" || point == "") {
			sheetObj.InitCellProperty(Row, "ots_aply_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
			sheetObj.InitCellProperty(Row, "ots_aply_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		}	
		if(currPoint == '0' || currPoint == "undefined" || currPoint == "") {
			sheetObj.InitCellProperty(Row, "rct_aply_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
			sheetObj.InitCellProperty(Row, "rct_aply_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:currPoint} );
		}
	
		bfrAplyAmt = ComNullToZero(ComReplaceStr(sheetObj.GetCellValue(Row, "rct_aply_amt"), ",", ""));
				
	}
	function sheet2_OnAfterEdit(sheetObj, Row, Col) {
		sheet2Change(sheetObj, Row, Col, "");
	}
	function sheet2_OnBeforePaste(sheetObj, text) {	
				
		pasteArray = text.split("\n");	
		
		if(pasteArray[pasteArray.length - 1].trim() == "") pasteArrayLen = pasteArray.length - 1;
		else pasteArrayLen = pasteArray.length;
		
		var cnt = 0;
		
		for(var i=sheetObj.GetSelectRow(); i < sheetObj.RowCount()+1; i++){
			var chgCd = sheetObj.GetCellValue(i, "rct_aply_chg_cd");
			if(!sheetObj.GetRowHidden(i) && !ComIsEmpty(chgCd)) cnt++;
		}	
		
		if(pasteArrayLen > cnt) return false;
	}
	function sheet2_OnAfterPaste(sheetObj) {	
		
		var pasteStartRow = sheetObj.GetSelectRow();
		var pasteEndRow = sheetObj.GetSelectRow() + pasteArrayLen;
		
		for(var i=pasteStartRow; i < pasteEndRow; i++){		
			sheet2_OnBeforeEdit(sheetObj, i, sheetObj.GetSelectCol());
			sheet2_OnAfterEdit(sheetObj, i, sheetObj.GetSelectCol());				
		}

	}
	function sheet2_OnDblClick(sheetObj, Row, Col){
		var formObj=document.form;
		var selIndex=sheetObj.GetComboInfo(Row, "wrtf_cd", "SelectedIndex");
		if(!ComIsEmpty(payAcctCd[selIndex])){
			var rct_dps_dt=formObj.rct_dps_dt.value;
			var aply_flg=sheetObj.GetCellValue(Row, "rct_aply_flg");
			var wrtf_rmk=sheetObj.GetCellValue(Row, "wrtf_rmk");
			var ap_ofc_cd=sheetObj.GetCellValue(Row, "ap_ofc_cd");
			var vndr_no=sheetObj.GetCellValue(Row, "vndr_no");
			var ap_gl_dt=ComGetMaskedValue(sheetObj.GetCellValue(Row, "ap_gl_dt"), "ymd");
			var ap_rmk=sheetObj.GetCellValue(Row, "ap_rmk");
			var classId="STM_SAR_0008";
			var param='?rct_dps_dt='+rct_dps_dt+'&aply_flg='+aply_flg+'&wrtf_rmk='+wrtf_rmk+'&ap_ofc_cd='+ap_ofc_cd+'&vndr_no='+vndr_no+'&ap_gl_dt='+ap_gl_dt+'&ap_rmk='+ap_rmk+'&pop_yn=Y&classId='+classId;
			ComOpenPopup('/opuscntr/STM_SAR_0008.do' + param, 700, 260, 'getSTM_SAR_0008', '0,0', true, false);
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBCLEAR:
				//Reset all form and objects
				formObj.reset();
				
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				comboObjects[0].RemoveAll();
				comboObjects[1].RemoveAll();
				comboObjects[2].RemoveAll();
				comboObjects[3].RemoveAll();
				comboObjects[4].RemoveAll();
				comboObjects[5].RemoveAll();
				setObjectDisable(false);
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
				break;
			case IBSEARCH_ASYNC01: 
				loadPageflg="Y";
				//retrieve Receipt Type List
				var arrStr=SarGetComboItems(sheetObj, "RECEIPT TYPE");
				MakeRctTypeComboObject(rct_tp_cd, arrStr);
				//retrieve AR Office List 	
				formObj.f_cmd.value=SEARCH03;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
				var arrStr=sStr.split("|");
				MakeRctOfcComboObject(rct_ofc_cd, arrStr);
				for (var i=1; i < arrStr.length; i++ ) {
					var arrStr2=arrStr[i].split("^");
					if(arrStr2[0] == arrStr2[1]){
						rct_ofc_cd.SetSelectText(arrStr2[1]);
						formObj.ots_ofc_cd.value=arrStr2[1];
						formObj.rhq_cd.value=arrStr2[2];
						formObj.ots_smry_cd.value=arrStr2[3]; 
						formObj.ots_cd.value=arrStr2[4]; 
						formObj.rep_ots_ofc_cd.value=arrStr2[5]; 
						rct_tp_cd.SetSelectCode(arrStr2[6]);
						formObj.rct_unapy_flg.value=arrStr2[7]; 
						formObj.ofc_entr_lvl_cd.value=arrStr2[8]; 
						formObj.ar_curr_cd.value=arrStr2[9]; 
						formObj.bank_ctrl_cd.value=arrStr2[11];
						formObj.rct_doc_cd.value=arrStr2[17];
					}
				}
				var otsSmryCd=formObj.ots_smry_cd.value;
				if(otsSmryCd == "BL" || otsSmryCd == ""){
					document.all.item("bl_label").style.display="";
					document.all.item("bl_input").style.display="";
					document.all.item("inv_label").style.display="none";
					document.all.item("inv_input").style.display="none";
				} else if(otsSmryCd == "INV"){
					document.all.item("bl_label").style.display="none";
					document.all.item("bl_input").style.display="none";
					document.all.item("inv_label").style.display="";
					document.all.item("inv_input").style.display="";
				}
				//retrieve Agent Office List
				formObj.f_cmd.value=SEARCH04;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"agt_ofc_cd");
				var arrStr=sStr.split("|");
				MakeAgtOfcComboObject(agn_ofc_cd, arrStr);

				//retrieve Local Time
				formObj.f_cmd.value=SEARCH07;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"lcl_time");
				formObj.rct_dt.value=ComGetMaskedValue(sStr, "ymd");
				formObj.rct_dps_dt.value=ComGetMaskedValue(sStr, "ymd");
				
				//Bound Combo
				var strBoundCombo=SarGetComboItems(sheetObjects[0], "BOUND TYPE");
		 		SarAddComboItem(bound_type, strBoundCombo, "2", "", "");	
		 		
		 		//Invoice Type Combo
		 		var strFreightCombo=SarGetComboItems(sheetObjects[0], "FRT TYPE");
		 		SarAddComboItem(invoice_type, strFreightCombo, "2", "", "");	
		 		
				
				//check local charge office
				fncCheckLocalChargeOffice(); //Setting Bound Search Condition
		 		
				
				loadPageflg="N";
				break;
			case IBSEARCH_ASYNC02:	//Search Customer Info
				formObj.f_cmd.value=SEARCH06;
				formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
				formObj.cust_seq.value=formObj.rct_cust_seq.value;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				if(SarShowXmlMessage(sXml) != "") {
     				ComShowCodeMessage("SAR00076"); 
     				ComClearObject(formObj.rct_cust_cnt_cd);
     				ComClearObject(formObj.rct_cust_seq);
     				ComClearObject(formObj.rct_cust_nm);
     				ComClearObject(formObj.rct_cust_rgst_no);
     				ComClearObject(formObj.crd_mark);
     				ComClearObject(formObj.crd_ofc_cd);
     				ComClearObject(formObj.ib_crd_term);
     				ComClearObject(formObj.ob_crd_term);
     				ComClearObject(formObj.rls_cntl);
     				ComClearObject(formObj.iss_tp);
     				formObj.rct_cust_cnt_cd.focus();
     			}else{
					formObj.rct_cust_nm.value=ComGetEtcData(sXml,"cust_nm");
					formObj.rct_cust_rgst_no.value=ComGetEtcData(sXml,"cust_rgst_no");
					formObj.crd_mark.value=ComGetEtcData(sXml,"cr_flg");
					formObj.crd_ofc_cd.value=ComGetEtcData(sXml,"cr_clt_ofc_cd");
					formObj.ib_crd_term.value=ComGetEtcData(sXml,"ib_cr_term_dys");
					formObj.ob_crd_term.value=ComGetEtcData(sXml,"ob_cr_term_dys");
					formObj.rls_cntl.value=ComGetEtcData(sXml,"cust_rlse_ctrl_flg");
					formObj.iss_tp.value=ComGetEtcData(sXml,"iss_div_cd");
     			}
				break;
			case IBSEARCH_ASYNC03:	//Search Customer Info of among whole customer
				formObj.f_cmd.value=SEARCH06;
				formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
				formObj.cust_seq.value=formObj.rct_cust_seq.value;
				formObj.cust_use_flg.value="N";
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				if(SarShowXmlMessage(sXml) != "") {
     				ComShowMessage(SarShowXmlMessage(sXml));
     				ComClearObject(formObj.rct_cust_cnt_cd);
     				ComClearObject(formObj.rct_cust_seq);
     				ComClearObject(formObj.rct_cust_nm);
     				ComClearObject(formObj.rct_cust_rgst_no);
     				ComClearObject(formObj.crd_mark);
     				ComClearObject(formObj.crd_ofc_cd);
     				ComClearObject(formObj.ib_crd_term);
     				ComClearObject(formObj.ob_crd_term);
     				ComClearObject(formObj.rls_cntl);
     				ComClearObject(formObj.iss_tp);
     				formObj.rct_cust_cnt_cd.focus();
     			}else{
					formObj.rct_cust_nm.value=ComGetEtcData(sXml,"cust_nm");
					formObj.rct_cust_rgst_no.value=ComGetEtcData(sXml,"cust_rgst_no");
					formObj.crd_mark.value=ComGetEtcData(sXml,"cr_flg");
					formObj.crd_ofc_cd.value=ComGetEtcData(sXml,"cr_clt_ofc_cd");
					formObj.ib_crd_term.value=ComGetEtcData(sXml,"ib_cr_term_dys");
					formObj.ob_crd_term.value=ComGetEtcData(sXml,"ob_cr_term_dys");
					formObj.rls_cntl.value=ComGetEtcData(sXml,"cust_rlse_ctrl_flg");
					formObj.iss_tp.value=ComGetEtcData(sXml,"iss_div_cd");
     			}
				break;
			case IBSEARCH: // RETRIEVE 
				//retrieveFlg="Y";
				if(validateForm(sheetObj, formObj, sAction)){
					ComOpenWait(true);
					setTimeout(function(){
						formObj.f_cmd.value=SEARCH;
						var sheetObj1=sheetObjects[0];
						var sheetObj2=sheetObjects[1];
	 					var sXml=sheetObj.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
						if(SarShowXmlMessage(arrXml[0]) != "") {
		     				ComShowMessage(SarShowXmlMessage(arrXml[0]));
		     				formObj.rct_no.focus();
		     			} else {
		     				agn_ofc_cd.SetSelectCode("");
		     				formObj.rct_seq.value=ComGetEtcData(arrXml[0],"rct_seq");
		     				formObj.chq_no.value=ComGetEtcData(arrXml[0],"chq_no");
		     				formObj.bank_acct_seq.value=ComGetEtcData(arrXml[0],"bank_acct_seq");
		     				formObj.bank_acct_nm.value=ComGetEtcData(arrXml[0],"bank_acct_nm");
		     				formObj.dp_prcs_knt.value=ComGetEtcData(arrXml[0],"dp_prcs_knt");
		     				formObj.rct_dt.value=ComGetMaskedValue(ComGetEtcData(arrXml[0],"rct_dt"), "ymd");
		     				formObj.rct_dps_dt.value=ComGetMaskedValue(ComGetEtcData(arrXml[0],"rct_dps_dt"), "ymd");
		     				formObj.rct_curr_cd.value=ComGetEtcData(arrXml[0],"rct_curr_cd");
		     				formObj.rct_amt.value=ComGetEtcData(arrXml[0],"rct_amt");
		     				formObj.rct_cust_cnt_cd.value=ComGetEtcData(arrXml[0],"rct_cust_cnt_cd");
		     				formObj.rct_cust_seq.value=ComGetEtcData(arrXml[0],"rct_cust_seq");
		     				formObj.bfr_cust_cnt_cd.value = ComGetEtcData(arrXml[0],"rct_cust_cnt_cd");
		     				formObj.bfr_cust_seq.value = ComGetEtcData(arrXml[0],"rct_cust_seq");
		     				rct_tp_cd.SetSelectCode(ComGetEtcData(arrXml[0],"rct_tp_cd"), false);
		     				formObj.rct_rmk.value=ComGetEtcData(arrXml[0],"rct_rmk");
		     				formObj.bank_chg_amt.value=ComGetEtcData(arrXml[0],"bank_chg_amt"); 				
		     				formObj.unid_amt.value=ComGetEtcData(arrXml[0],"unid_amt");
		     				formObj.unapp_amt.value=ComGetEtcData(arrXml[0],"unapp_amt");
		     				formObj.app_amt.value=ComGetEtcData(arrXml[0],"app_amt");
		     				formObj.cxl_desc.value=ComGetEtcData(arrXml[0],"cxl_desc");
		     				formObj.bal_rct_amt.value=ComGetEtcData(arrXml[0],"bal_rct_amt");
		     				formObj.rct_sts_cd.value=ComGetEtcData(arrXml[0],"rct_sts_cd");
		     				agn_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0],"agn_ofc_cd"));
		     				formObj.agn_cd.value=ComGetEtcData(arrXml[0],"agn_cd");
		     				asa_no.SetSelectCode(ComGetEtcData(arrXml[0],"asa_no"));
		     				invoice_type.SetSelectCode(ComGetEtcData(arrXml[0],"invoice_type"));
		     				bound_type.SetSelectCode(ComGetEtcData(arrXml[0],"bound_type"));
		     				
		     				formObj.tmp_agn_ofc_cd.value = ComGetEtcData(arrXml[0],"agn_ofc_cd");
		     				formObj.tmp_asa_no.value = ComGetEtcData(arrXml[0],"asa_no");
		     				formObj.tmp_cust_cnt_cd.value = ComGetEtcData(arrXml[0],"rct_cust_cnt_cd");
		     				formObj.tmp_cust_seq.value = ComGetEtcData(arrXml[0],"rct_cust_seq");
		     				formObj.tmp_rmk.value = ComGetEtcData(arrXml[0],"rct_rmk");
		     				formObj.tmp_bank_chg_amt.value = ComGetEtcData(arrXml[0],"bank_chg_amt"); 
		     				
		     				if(!ComIsEmpty(formObj.rct_cust_cnt_cd) && !ComIsEmpty(formObj.rct_cust_seq)){
		     					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC03); //IBSEARCH_ASYNC02
		     				} else {
		     					ComClearObject(formObj.rct_cust_nm);
		         				ComClearObject(formObj.rct_cust_rgst_no);
		         				ComClearObject(formObj.crd_mark);
		         				ComClearObject(formObj.crd_ofc_cd);
		         				ComClearObject(formObj.ib_crd_term);
		         				ComClearObject(formObj.ob_crd_term);
		         				ComClearObject(formObj.rls_cntl);
		         				ComClearObject(formObj.iss_tp);
		     				}
		     				sheetObj1.LoadSearchData(arrXml[0],{Sync:1} );
		     				sheetObj2.LoadSearchData(arrXml[1],{Sync:1} );
	 	     				for(var i=1; i <= sheetObj2.RowCount(); i++){
		     					sheetObj2.SetCellEditable(i, "ots_aply_amt",0);
		     					sheetObj2.SetCellEditable(i, "rct_aply_xch_rt",0);
		     					sheetObj2.SetRowHidden(i, 1);
		     				}
		     				sheetObj1.SelectCell(1, 0, false);
		     				sheet1_OnDblClick(sheetObj1, 1);
		     				
		     				formObj.ttl_curr_cd.value=ComGetEtcData(arrXml[0],"rct_curr_cd");
		     				formObj.ttl_count.value=sheetObj1.RowCount();
		     				formObj.ttl_amt.value=ComGetEtcData(arrXml[0],"ttl_aply_amt");
		     				
		     				if(sheetObj1.RowCount()== 0) calApplyAmount();
		     				
		     				setObjectDisable(false);
		     				setObjectDisable(true);
		     			}
						ComOpenWait(false);
					},100);
				}
				//retrieveFlg="N";
				break;
			case IBSAVE: // SAVE
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=MULTI;
					var sheetObject1=sheetObjects[0];
			        var sheetObject2=sheetObjects[1];
			        var saveKindCd=formObj.save_kind_cd.value;
			        var sParam=FormQueryString(formObj);
			        if(saveKindCd == "R"){
			        	var sParam1=ComGetSaveString(sheetObject1, true, false, "selchk");
			        } else {
			        	var sParam1=ComGetSaveString(sheetObject1, true, true);
			        }
					var sParam2=ComGetSaveString(sheetObject2, true, true);
					sParam1=ComSetPrifix(sParam1, "sheet1_");
					sParam2=ComSetPrifix(sParam2, "sheet2_");
					sParam=sParam + "&" + sParam1 + "&" + sParam2;
 					var sXml=sheetObj.GetSaveData("STM_SAR_2001GS.do", sParam);					
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
					
					if (backendJobKey.length > 0) {
						formObj.backendjob_key.value = backendJobKey;
						sheetObject1.SetWaitImageVisible(0);
						ComOpenWait(true);			
						sheetObject1.SetWaitTimeOut(10000);
						timer = setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
					}
	
					if(SarShowXmlMessage(sXml) != "") {
	     				ComShowMessage(SarShowXmlMessage(sXml));
					}
					
				}
				break;
			case IBSEARCH_ASYNC11: // search by B/L NO, Invoice No
				if(validateForm(sheetObj, formObj, sAction)){
					var sheetObj1=sheetObjects[0];
					var sheetObj2=sheetObjects[1];
					var selectRow=sheetObj1.GetSelectRow();
					if(hdrDupFlg == "N"){
						formObj.f_cmd.value=SEARCH01;				
 						var sXml=sheetObj.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
						sheetObj1.LoadSearchData(sXml,{Append:1 , Sync:1} );
					}
					if(dtlDupFlg == "N"){
						formObj.f_cmd.value=SEARCH02;
 						var sXml=sheetObj.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
						sheetObj2.LoadSearchData(sXml,{Append:1 , Sync:1} );
					}
					hdrDupFlg="N";
					dtlDupFlg="N";
					//Add row in case of no existing B/L in OTS
					if(ComGetTotalRows(sXml) == 0) {
						if(ComIsEmpty(formObj.rct_cust_cnt_cd) || ComIsEmpty(formObj.rct_cust_seq)){
							ComShowCodeMessage("SAR00064");
							ComSetFocus(formObj.rct_cust_cnt_cd);
							break;
						} else {
							addHeaderDetailRow();
						}
					} else {
						if(ComIsEmpty(formObj.rct_cust_cnt_cd) || ComIsEmpty(formObj.rct_cust_seq)){
							formObj.rct_cust_cnt_cd.value=sheetObj1.GetCellValue(1, "bil_to_cust_cnt_cd");
							formObj.rct_cust_seq.value=ComLpad(sheetObj1.GetCellValue(1, "bil_to_cust_seq"), 6, "0");
	     					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
	     				}
					}
					
 					for(var i=1; i <= sheetObj1.RowCount(); i++){
 						var aply_flg=sheetObj1.GetCellValue(i, "rct_aply_flg");
     					if(aply_flg == "N")	sheetObj1.SetCellEditable(i, "selchk",0);
     				}
     				
 					//sheetObj1.SetCellEditable(sheetObj1.RowCount(), "selchk",0);
 					
 					for(var i=1; i <= sheetObj2.RowCount(); i++){
 						sheetObj2.SetRowHidden(i, 1);
 					}
 					
					//Set apply amount precision
 					/*
					var currPoint=formObj.dp_prcs_knt.value;
					for(var i=1; i <= sheetObj2.RowCount(); i++){
						var point=sheetObj2.GetCellValue(i, "dp_prcs_knt");
						var aply_flg=sheetObj2.GetCellValue(i, "rct_aply_flg");
						var aply_amt=sheetObj2.GetCellValue(i, "ots_aply_amt");
     					if(aply_flg == "N"){
		     				if(point == '0' || point == undefined || point == "") {
 		     					sheetObj2.InitCellProperty(i, "ots_aply_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		     				} else {
 		     					sheetObj2.InitCellProperty(i, "ots_aply_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		     				}	
		     				if(currPoint == '0' || currPoint == undefined || currPoint == "") {
 		     					sheetObj2.InitCellProperty(i, "rct_aply_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		     				} else {
 		     					sheetObj2.InitCellProperty(i, "rct_aply_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:currPoint} );
		     				}	
		     				if(ComIsEmpty(aply_amt)) sheetObj2.SetCellValue(i, "ots_aply_amt",sheetObj2.GetCellValue(i, "ots_bal_amt"));
     					}
     				}
     				*/
     				sheetObj1.SelectCell(sheetObj1.RowCount(), 0, false);
     				sheet1_OnDblClick(sheetObj1, sheetObj1.RowCount());
	     			ComClearObject(formObj.bl_no);
					ComClearObject(formObj.inv_no);
					var otsSmryCd=formObj.ots_smry_cd.value;
					if(otsSmryCd == "BL" || otsSmryCd == ""){
						ComSetFocus(formObj.bl_no);
					} else if(otsSmryCd == "INV"){
						ComSetFocus(formObj.inv_no);
					}
					var bankChgAmt=formObj.bank_chg_amt.value;
     				var rctTpCd=rct_tp_cd.GetSelectCode();
     				if(rctTpCd != "OFF" && ComIsEmpty(bankChgAmt)){
     					ComEnableObject(formObj.bank_chg_amt, true);
     					formObj.bank_chg_amt.className="input";
     				}
     				formObj.bank_acct_nm.className="input2";
     				rct_tp_cd.SetEnable(0);
     				formObj.btns_bank.disabled=true;
     				
     				calTotalAmount(ComGetEtcData(sXml,"ttl_aply_amt"));
				}
     			break;
			case IBSEARCH_ASYNC12: // search from OTS Temp
				
				var sheetObj1=sheetObjects[0];
				var sheetObj2=sheetObjects[1];
						
				formObj.f_cmd.value=SEARCH04;				
						
				var sXml=sheetObj.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				sheetObj1.LoadSearchData(arrXml[0],{Append:1 , Sync:1} );
				sheetObj2.LoadSearchData(arrXml[1],{Append:1 , Sync:1} );
							
				if(ComIsEmpty(formObj.rct_cust_cnt_cd) || ComIsEmpty(formObj.rct_cust_seq)){
					formObj.rct_cust_cnt_cd.value=sheetObj1.GetCellValue(1, "bil_to_cust_cnt_cd");
					formObj.rct_cust_seq.value=ComLpad(sheetObj1.GetCellValue(1, "bil_to_cust_seq"), 6, "0");
 					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
 				}
				
				for(var i=1; i <= sheetObj1.RowCount(); i++){
					var aply_flg=sheetObj1.GetCellValue(i, "rct_aply_flg");
 					if(aply_flg == "N")	sheetObj1.SetCellEditable(i, "selchk",0);
 				}
				
				for(var i=1; i <= sheetObj2.RowCount(); i++){
					sheetObj2.SetRowHidden(i, 1);
				}
				
 				sheetObj1.SelectCell(sheetObj1.RowCount(), 0, false);
 				sheet1_OnDblClick(sheetObj1, sheetObj1.RowCount());
     			
				var bankChgAmt=formObj.bank_chg_amt.value;
 				var rctTpCd=rct_tp_cd.GetSelectCode();
 				if(rctTpCd != "OFF" && ComIsEmpty(bankChgAmt)){
 					ComEnableObject(formObj.bank_chg_amt, true);
 					formObj.bank_chg_amt.className="input";
 				}
 				formObj.bank_acct_nm.className="input2";
 				rct_tp_cd.SetEnable(0);
 				formObj.btns_bank.disabled=true;
				
 				calTotalAmount(ComGetEtcData(arrXml[0],"ttl_aply_amt"));
 				
     			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {		
			case IBSEARCH:
				if(ComIsEmpty(formObj.rct_no)){
					ComShowCodeMessage("COM130403", "Receipt No");
					ComSetFocus(formObj.rct_no);
					return false;
				}
				break;
			case IBSEARCH_ASYNC11:
				//Check mandatory items
				if(rct_tp_cd.GetSelectCode() == "CHQ"){
					if(ComIsEmpty(formObj.chq_no)){
						ComShowCodeMessage("COM130403", "Cheque No");
						ComSetFocus(formObj.chq_no);
						return false;
					}
				}
				if(ComIsEmpty(formObj.bank_acct_nm)){
					ComShowCodeMessage("COM130403", "Bank");
					return false;
				}
				if(ComIsEmpty(formObj.rct_dt)){
					ComShowCodeMessage("COM130403", "Receipt Date"); 
					ComSetFocus(formObj.rct_dt);
					return false;
				}
				if(ComIsEmpty(formObj.rct_dps_dt)){
					ComShowCodeMessage("COM130403", "Deposit Date");
					ComSetFocus(formObj.rct_dps_dt);
					return false;
				}
				if(ComIsEmpty(formObj.rct_amt)){
					ComShowCodeMessage("COM130403", "Receipt Amount");
					ComSetFocus(formObj.rct_amt);
					return false;
				}
				if(rct_tp_cd.GetSelectCode() == ""){
					ComShowCodeMessage("COM130403", "Receipt Type");
//					ComSetFocus(rct_tp_cd);
					return false;
				}
				if(formObj.local_chg_flag.value == "Y") {
					if(formObj.invoice_type.value == ""){
						ComShowCodeMessage("COM130403", "Invoice Type");
						return false;
					}
					if(formObj.bound_type.value == ""){
						ComShowCodeMessage("COM130403", "Bound");
						return false;
					}
					formObj.ib_ob_cd.value = formObj.bound_type.value;
				}
				var otsSmryCd=formObj.ots_smry_cd.value;
				var otsSrchFlg=formObj.ots_srch_flg.value;
				var blCnt=0;
				var invCnt=0;
				//Check duplicated B/L No, Invoice No
 				for(var i=1; i <= sheetObjects[0].RowCount(); i++){
 					var aplyFlg=sheetObjects[0].GetCellValue(i, "rct_aply_flg");
 					if(aplyFlg == "N" && formObj.bl_no.value == sheetObjects[0].GetCellValue(i, "bl_no")) blCnt++;
 					if(aplyFlg == "N" && formObj.inv_no.value == sheetObjects[0].GetCellValue(i, "inv_no")) invCnt++;
				}
				if(otsSmryCd == "BL" || otsSmryCd == ""){
					if(ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("SAR00013", "B/L No");
						ComSetFocus(formObj.bl_no);
						return false;
					}
					if(otsSrchFlg == "N" && blCnt > 0){
						ComShowCodeMessage("SAR00014", "B/L No");
						ComSetFocus(formObj.bl_no);
						return false;
					}
				} else if(otsSmryCd == "INV"){
					if(ComIsEmpty(formObj.inv_no)){
						ComShowCodeMessage("SAR00013", "Invoice No");
						ComSetFocus(formObj.inv_no);
						return false;
					}
					if(otsSrchFlg == "N" && invCnt > 0){
						ComShowCodeMessage("SAR00014", "Invoice No");
						ComSetFocus(formObj.inv_no);
						return false;
					}
				}
				break;
			case IBSAVE:
				//Check mandatory items
				
				
				if(formObj.local_chg_flag.value == "Y") {
					if(formObj.invoice_type.value == ""){
						ComShowCodeMessage("COM130403", "Invoice Type");
						return false;
					}
					if(formObj.bound_type.value == ""){
						ComShowCodeMessage("COM130403", "Bound");
						return false;
					}
					formObj.ib_ob_cd.value = formObj.bound_type.value;
					
					if(formObj.invoice_type.value == "NFRT" && formObj.bound_type.value == "L") {
						/*if(sheetObjects[0].RowCount() > 1) {
							ComShowCodeMessage("SAR00070");
							return false;
						}*/
						
						if(sheetObjects[1].RowCount()> 0){

							var lclCnt = 0;
							var lclChgCd = "";
							var strTHLocalChgList = SARGetTHLocalChgList( sheetObjects[1]);
							
							for(var i=1; i <= sheetObjects[1].RowCount(); i++){
								var chgCd = sheetObjects[1].GetCellValue(i, "rct_aply_chg_cd");
								
								if ( !ComIsEmpty(chgCd) ) { 
									
									if (strTHLocalChgList.indexOf(chgCd) > -1) {
										if (lclChgCd == "") {
											lclChgCd = chgCd;
										}
										if (lclChgCd != chgCd) { //ignore same charge, but if charge is different, it's not allowed
											lclCnt++;
										} 
									}
								}
							}
							
							if(lclCnt > 0) {
								ComShowCodeMessage("SAR00071");
								return false;
							}
						}
					}
				}
				
				
				if(rct_tp_cd.GetSelectCode() == "CHQ"){
					if(ComIsEmpty(formObj.chq_no)){
						ComShowCodeMessage("COM130403", "Cheque No");
						ComSetFocus(formObj.chq_no);
						return false;
					}
				}
				if(ComIsEmpty(formObj.bank_acct_nm)){
					ComShowCodeMessage("COM130403", "Bank");
					return false;
				}
				if(ComIsEmpty(formObj.rct_dt)){
					ComShowCodeMessage("COM130403", "Receipt Date");
					ComSetFocus(formObj.rct_dt);
					return false;
				}
				if(ComIsEmpty(formObj.rct_dps_dt)){
					ComShowCodeMessage("COM130403", "Deposit Date");
					ComSetFocus(formObj.rct_dps_dt);
					return false;
				}
				var rctDt=ComReplaceStr(formObj.rct_dt.value, "-", "");
				var rctDpsDt=ComReplaceStr(formObj.rct_dps_dt.value, "-", "");
				if(ComChkPeriod(rctDt, rctDpsDt) < 1){
					ComShowCodeMessage("SAR00005");
					ComSetFocus(formObj.rct_dps_dt);
					return false;
				}
				if(ComIsEmpty(formObj.rct_amt)){
					ComShowCodeMessage("COM130403", "Receipt Amount");
					ComSetFocus(formObj.rct_amt);
					return false;
				}
				if(rct_tp_cd.GetSelectCode() == ""){ 
					ComShowCodeMessage("COM130403", "Receipt Type");
					//ComSetFocus();
					return false;
				}
				if(sheetObjects[0].RowCount()> 0){
					if(ComIsEmpty(formObj.rct_cust_cnt_cd) || ComIsEmpty(formObj.rct_cust_seq)){
						ComShowCodeMessage("COM130403", "Customer");
						ComSetFocus(formObj.rct_cust_cnt_cd);
						return false;
					}
				}
				if(!ComIsEmpty(formObj.rct_cust_cnt_cd) || !ComIsEmpty(formObj.rct_cust_seq)){
					formObj.f_cmd.value=SEARCH06;
					formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
					formObj.cust_seq.value=formObj.rct_cust_seq.value;
 					var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
					if(SarShowXmlMessage(sXml) != "") {
						ComShowCodeMessage("SAR00018");
						ComSetFocus(formObj.rct_cust_cnt_cd);
						return false;
					}
				}
				var rctTpCd=rct_tp_cd.GetSelectCode();
				var point=formObj.dp_prcs_knt.value;
				var unapyFlg=formObj.rct_unapy_flg.value;
				var rctAmt=ComRound(parseFloat(ComReplaceStr(formObj.rct_amt.value, ",", "")), 3);
				var ttlAmt=ComRound(parseFloat(ComReplaceStr(ComNullToZero(formObj.ttl_amt.value), ",", "")), point);
				var bankChgAmt=ComRound(parseFloat(ComReplaceStr(formObj.bank_chg_amt.value, ",", "")), 3);
				//Check sheet mandatory items
				if(sheetObjects[1].RowCount()> 0){
					for(var i=1; i <= sheetObjects[1].RowCount(); i++){
						var wrtfCd=sheetObjects[1].GetCellValue(i, "wrtf_cd");
						var chgCd=sheetObjects[1].GetCellValue(i, "rct_aply_chg_cd");
						var aplyAmt=sheetObjects[1].GetCellValue(i, "ots_aply_amt");
						var xchRt=sheetObjects[1].GetCellValue(i, "rct_aply_xch_rt");
						var apOfcCd=sheetObjects[1].GetCellValue(i, "ap_ofc_cd");
						var vndrNo=sheetObjects[1].GetCellValue(i, "vndr_no");
						var apGlDt=sheetObjects[1].GetCellValue(i, "ap_gl_dt");
						var apRmk=sheetObjects[1].GetCellValue(i, "ap_rmk");
						var selIndex=sheetObjects[1].GetComboInfo(i, "wrtf_cd", "SelectedIndex");
						var srcCurr=sheetObjects[1].GetCellValue(i, "rct_aply_src_curr_cd");
						var rctCurr=sheetObjects[1].GetCellValue(i, "rct_curr_cd");
						if(wrtfCd == "" && chgCd == ""){
							ComShowCodeMessage("SAR00006", "Write-Off");
							return false;
						}
						if(aplyAmt == "" || aplyAmt == 0){
							ComShowCodeMessage("SAR00006", "Amount");
							return false;
						}
						if(xchRt == "" || xchRt == 0){
							ComShowCodeMessage("SAR00006", "Ex.Rate");
							return false;
						}
						if(srcCurr == rctCurr && xchRt != 1){
							ComShowCodeMessage("SAR00074");
							return false;
						}
						if(!ComIsEmpty(payAcctCd[selIndex])){	
							if(ComIsEmpty(apOfcCd) || ComIsEmpty(vndrNo) || ComIsEmpty(apGlDt) || ComIsEmpty(apRmk)){
								ComShowCodeMessage("SAR00006", "Write-Off Info");
								return false;
							}
						}
					}
				}
				//Check receipt amount and total amount
				if(rctTpCd == "OFF"){
					if(sheetObjects[0].RowCount()== 0){
						ComShowCodeMessage("SAR00017");
						return false;	
					} else {
						if(ttlAmt != 0){
							ComShowCodeMessage("SAR00010");
							return false;
						}
					}
				} else {
					if(rctAmt <= 0){
						ComShowCodeMessage("SAR00011");
						ComSetFocus(formObj.rct_amt);
						return false;
					}
					if(rctAmt < ttlAmt){
						ComShowCodeMessage("SAR00007");
						return false;
					}
					if(sheetObjects[0].RowCount()> 0 && unapyFlg == "N" && rctAmt > ttlAmt){
						ComShowCodeMessage("SAR00008");
						return false;
					}
				}
				if(bankChgAmt <= 0){
					ComShowCodeMessage("SAR00026","Bank Charge");
					ComSetFocus(formObj.bank_chg_amt);
					return false;
				}
				if(!ComIsEmpty(agn_ofc_cd.GetSelectCode()) && ComIsEmpty(asa_no.GetSelectCode())){
					ComShowCodeMessage("SAR00042");
					//ComSetFocus(asa_no);
					return false;
				}
				var saveKindCd=formObj.save_kind_cd.value;
				if(saveKindCd == "S"){
					var asaCnt=0;
 					for(var i=1; i <= sheetObjects[0].RowCount(); i++){
					var src_cd=sheetObjects[0].GetCellValue(i, "ar_finc_src_cd");
	 					if(src_cd == "STM AR" || src_cd == "STM AP") asaCnt++;
	 				}
					if(asaCnt > 0 && (ComIsEmpty(agn_ofc_cd.GetSelectCode()) || ComIsEmpty(asa_no.GetSelectCode()))){
						if(!ComShowCodeConfirm("SAR00043")) return false;
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
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//		$(document).ready(function() {
//		    $("input:text")
//		        .mouseup(function (e) {e.preventDefault(); });
//		});
	}
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('upper'); 
				break;
			case "engnum":
				ComKeyOnlyAlphabet('uppernum'); 
				break;
			case "num":
	        	//only number
				ComKeyOnlyNumber('num');
	            break;
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				ComKeyOnlyNumber(event.srcElement, "-.");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet('upper');
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(event.srcElement);
		}
	}    
    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
		var formObj=document.form;
		var evtObj = ComGetEvent();
		switch (ComGetEvent("name")) {
			case "rct_dt":
				var rctDt=ComReplaceStr(evtObj.value,"-","");
				if (rctDt.length == 8) {
					formObj.rct_amt.focus();
				}
	 		break;
			case "rct_dps_dt":
				var rctDpsDt=ComReplaceStr(evtObj.value,"-","");
				if (rctDpsDt.length == 8) {
					formObj.rct_cust_cnt_cd.focus();
				}
	 		break;
			case "rct_cust_cnt_cd":
				var rctCustCntCd=evtObj.value;
				if (rctCustCntCd.length == 2) {
					formObj.rct_cust_seq.focus();
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
       		case "rct_dt":
       			ComClearSeparator(ComGetEvent());
       			break;
       		case "rct_dps_dt":
       			ComClearSeparator(ComGetEvent());
       			break;
       	}
       	ComGetEvent().select();
       
    }
	
    /** 
     * handling work javascript OnBlur event  <br>
     */    
    function obj_blur(){
    	 ComChkObjValid(ComGetEvent());
    }    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		switch(ComGetEvent("name")){
			case "rct_dt":
				ComAddSeparator(form.rct_dt, "ymd");
				ComChkObjValid(ComGetEvent());
				break;
			case "rct_dps_dt":
				ComAddSeparator(form.rct_dps_dt, "ymd");
				ComChkObjValid(ComGetEvent());
				break;
			case "rct_amt":
				ComChkObjValid(ComGetEvent());
				break;
			case "bank_chg_amt":
				ComChkObjValid(ComGetEvent());
				calApplyAmount();
				break;
		}
	}
	function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "rct_cust_cnt_cd":
				if (formObj.rct_cust_cnt_cd.value == '') {
					ComClearObject(formObj.rct_cust_seq);
					ComClearObject(formObj.rct_cust_nm);
     				ComClearObject(formObj.rct_cust_rgst_no);
     				ComClearObject(formObj.crd_mark);
     				ComClearObject(formObj.crd_ofc_cd);
     				ComClearObject(formObj.ib_crd_term);
     				ComClearObject(formObj.ob_crd_term);
     				ComClearObject(formObj.rls_cntl);
     				ComClearObject(formObj.iss_tp);
				}
				break;
				
			case "rct_cust_seq":
				if (formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					//Search customer info when input customer code
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				} else {
					ComClearObject(formObj.rct_cust_nm);
     				ComClearObject(formObj.rct_cust_rgst_no);
     				ComClearObject(formObj.crd_mark);
     				ComClearObject(formObj.crd_ofc_cd);
     				ComClearObject(formObj.ib_crd_term);
     				ComClearObject(formObj.ob_crd_term);
     				ComClearObject(formObj.rls_cntl);
     				ComClearObject(formObj.iss_tp);
				}
				break;
				
			case "rct_amt":
				
				if(ComIsEmpty(formObj.rct_curr_cd)){
					ComShowCodeMessage("COM130403", "Bank");
					formObj.rct_amt.value = "";
					ComSetFocus(formObj.btns_bank);
					return false;
				}
				
				var point=formObj.dp_prcs_knt.value;
				var rctAmt = ComRound(parseFloat(ComReplaceStr(formObj.rct_amt.value, ",", "")), point);
				
				if(point == "0"){
					formObj.rct_amt.value=ComAddComma2(rctAmt+"", "#,###");
				} else if(point == "1"){
					formObj.rct_amt.value=ComAddComma2(rctAmt+"", "#,###.0");
				} else if(point == "" || point == "2"){
					formObj.rct_amt.value=ComAddComma2(rctAmt+"", "#,###.00");
				}
				
				break;
				
			case "bank_chg_amt":
				
				if(!ComIsEmpty(formObj.bank_chg_amt)){
					var point=formObj.dp_prcs_knt.value;
					var bankChgAmt = ComRound(parseFloat(ComReplaceStr(formObj.bank_chg_amt.value, ",", "")), point);
					
					if(point == "0"){
						formObj.bank_chg_amt.value=ComAddComma2(bankChgAmt+"", "#,###");
					} else if(point == "1"){
						formObj.bank_chg_amt.value=ComAddComma2(bankChgAmt+"", "#,###.0");
					} else if(point == "" || point == "2"){
						formObj.bank_chg_amt.value=ComAddComma2(bankChgAmt+"", "#,###.00");
					}
				}
				
				break;
		}
	}
	/**
	 * function called when combo box agn_ofc_cd change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author Park sung yong
	 * @version 2014.03.26
	 */	
	function agn_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,value,text){ 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		comboObjects[1].RemoveAll();
		//retrieve ASA No List
		formObj.f_cmd.value=SEARCH03;
 		var sXml=sheetObj.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
		var sStr1=ComGetEtcData(sXml,"asa_no");
		var sStr2=ComGetEtcData(sXml,"curr_cd");
		var arrStr1=sStr1.split("|");
		var arrStr2=sStr2.split("|");
		MakeASANoComboObject(asa_no, arrStr1, arrStr2);
		asa_no.SetSelectCode(arrStr1[1]);
		formObj.agn_cd.value=newCode;
	}

	/**
	 * function called when combo box rct_ofc_cd change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author Park sung yong
	 * @version 2014.03.26
	 */	
//	function rct_ofc_cd_OnChange(comboObj,value,text){
	function rct_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){

		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var arrStr=newCode.split("^");
		if(loadPageflg == "Y") return;
		formObj.reset();
		comboObj.SetSelectText(newText);
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		comboObjects[0].RemoveAll();
		comboObjects[1].RemoveAll();
		setObjectDisable(false);
		//Set changed office's info
		formObj.ots_ofc_cd.value=arrStr[0];
		formObj.rhq_cd.value=arrStr[2];
		formObj.ots_smry_cd.value=arrStr[3]; 
		formObj.ots_cd.value=arrStr[4]; 
		formObj.rep_ots_ofc_cd.value=arrStr[5]; 
		rct_tp_cd.SetSelectCode(arrStr[6]);
		formObj.rct_unapy_flg.value=arrStr[7]; 
		formObj.ofc_entr_lvl_cd.value=arrStr[8]; 
		formObj.ar_curr_cd.value=arrStr[9]; 
		formObj.bank_ctrl_cd.value=arrStr[11];
		formObj.rct_doc_cd.value=arrStr[17];
		var otsSmryCd=formObj.ots_smry_cd.value;
		if(otsSmryCd == "BL" || otsSmryCd == ""){
			document.all.item("bl_label").style.display="";
			document.all.item("bl_input").style.display="";
			document.all.item("inv_label").style.display="none";
			document.all.item("inv_input").style.display="none";
		} else if(otsSmryCd == "INV"){
			document.all.item("bl_label").style.display="none";
			document.all.item("bl_input").style.display="none";
			document.all.item("inv_label").style.display="";
			document.all.item("inv_input").style.display="";
		}
		//retrieve Agent Office List
		formObj.f_cmd.value=SEARCH04;
 		var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"agt_ofc_cd");
		var arrStr=sStr.split("|");
		MakeAgtOfcComboObject(agn_ofc_cd, arrStr);
		//retrieve Local Time
		formObj.f_cmd.value=SEARCH07;
		var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"lcl_time");
		formObj.rct_dt.value=ComGetMaskedValue(sStr, "ymd");
		formObj.rct_dps_dt.value=ComGetMaskedValue(sStr, "ymd");
		//check local charge office
		fncCheckLocalChargeOffice();
	}
	/**
	 * function called when combo box rct_tp_cd change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author Park sung yong
	 * @version 2014.03.26
	 */	
	function rct_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,value,text){ 
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		//if(retrieveFlg == "Y") return;
		if(sheetObj1.RowCount()> 0){
			ComEnableObject(formObj.bank_chg_amt, true);
			formObj.bank_chg_amt.className="input";
		}
		formObj.chq_no.className="input";
		ComEnableObject(formObj.rct_amt, true);
		formObj.rct_amt.className="input1";
		ComClearObject(formObj.bank_acct_seq);
		ComClearObject(formObj.bank_acct_nm);	
		ComClearObject(formObj.rct_curr_cd);
		ComClearObject(formObj.dp_prcs_knt);
		if(newCode == "CHQ"){
			formObj.chq_no.className="input1";
		} else if(newCode == "OFF"){
			formObj.rct_amt.value="0";
			ComEnableObject(formObj.rct_amt, false);
			formObj.rct_amt.className="input2";
			formObj.bank_chg_amt.value="";
			ComEnableObject(formObj.bank_chg_amt, false);
			formObj.bank_chg_amt.className="input2";
			calApplyAmount();
		}
	}
	/** 
	 * call method when select event on popup(STM_SAR_9003)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_9003(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.rct_cust_cnt_cd.value=colArray[8];
		formObj.rct_cust_seq.value=ComLpad(colArray[9], 6, '0');
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
	}
	/** 
	 * call method when select event on popup(STM_SAR_0005)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_0005(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.bank_acct_seq.value=colArray[5];
		formObj.bank_acct_nm.value=colArray[1];	
		formObj.rct_curr_cd.value=colArray[2];
		formObj.dp_prcs_knt.value=colArray[8];
	}
	/** 
	 * call method when select event on popup(STM_SAR_0008)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_0008(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		var sheetObj=sheetObjects[1];
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "wrtf_rmk",colArray[1],0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ap_ofc_cd",colArray[2],0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_no",colArray[3],0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ap_gl_dt",colArray[4],0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ap_rmk",colArray[5],0);
	}
	/** 
	 * call method when select event on popup(STM_SAR_0011)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_0011(rowArray) {
		var formObj=document.form;
		var colArray=rowArray[0];
		formObj.rct_no.value=colArray[3];
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	/** 
	 * call method when select event on popup(STM_SAR_0012)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_0012() { 
		if(!ComIsEmpty(document.form.ots_rct_tmp_seq)) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC12);
		}
		/*
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var tmpRhqCd=formObj.rhq_cd.value;
		var tmpOtsOfcCd=formObj.ots_ofc_cd.value;
		var tmpOtsSmryCd=formObj.ots_smry_cd.value;
		var tmpOtsCd=formObj.ots_cd.value;
		var tmpRepOfcCd=formObj.rep_ots_ofc_cd.value;
		var tmpBlNo=formObj.bl_no.value;
		var tmpInvNo=formObj.inv_no.value;
		var tmpChgTpCd=formObj.chg_tp_cd.value;
		var tmpBlCurrCd=formObj.bl_curr_cd.value;
		formObj.ots_srch_flg.value="Y";
		for(var i=0; i < rowArray.length; i++){
			var colArray=rowArray[i];
			formObj.rhq_cd.value=colArray[2];
			formObj.ots_ofc_cd.value=colArray[9];
			formObj.ots_smry_cd.value=colArray[3];
			formObj.ots_cd.value=colArray[4];
			formObj.rep_ots_ofc_cd.value=colArray[5];
			formObj.bl_no.value=colArray[6];
			formObj.inv_no.value=colArray[7];
			formObj.chg_tp_cd.value=colArray[15];
			formObj.bl_curr_cd.value=colArray[16];
			var newHdrSeq=colArray[9] + colArray[6] + colArray[7];
			var newDtlSeq=colArray[9] + colArray[6] + colArray[7] + colArray[15] + colArray[16];
			hdrDupFlg="N";
			dtlDupFlg="N";
			//Check duplicated header info
 			for(var j=1; j < sheetObj1.RowCount() + 1; j++){
 				var oldHdrSeq=sheetObj1.GetCellValue(j, "rct_aply_hdr_seq");
 				var aplyFlg=sheetObj1.GetCellValue(j, "rct_aply_flg");
				if(aplyFlg == "N" && newHdrSeq == oldHdrSeq) hdrDupFlg="Y";
			}
			//Check duplicated detail info
 			for(var j=1; j < sheetObj2.RowCount() + 1; j++){
				var oldDtlSeq=sheetObj2.GetCellValue(j, "rct_aply_hdr_seq") + sheetObj2.GetCellValue(j, "rct_aply_chg_cd") + sheetObj2.GetCellValue(j, "rct_aply_src_curr_cd");
				var aplyFlg=sheetObj2.GetCellValue(j, "rct_aply_flg");
				if(aplyFlg == "N" && newDtlSeq == oldDtlSeq) dtlDupFlg="Y";
			}
			doActionIBSheet(sheetObj1, formObj, IBSEARCH_ASYNC11);
		}
		formObj.rhq_cd.value=tmpRhqCd;
		formObj.ots_ofc_cd.value=tmpOtsOfcCd;
		formObj.ots_smry_cd.value=tmpOtsSmryCd;
		formObj.ots_cd.value=tmpOtsCd;
		formObj.rep_ots_ofc_cd.value=tmpRepOfcCd;
		formObj.bl_no.value=tmpBlNo;
		formObj.inv_no.value=tmpInvNo;
		formObj.chg_tp_cd.value=tmpChgTpCd;
		formObj.bl_curr_cd.value=tmpBlCurrCd;
		*/
	}
	/** 
	 * call method when select event on popup(STM_SAR_0013)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_0013(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		formObj.rct_cxl_dt.value=colArray[1];
		formObj.rct_cxl_cate_cd.value=colArray[2];
		formObj.rct_cxl_rsn_cd.value=colArray[3];
		formObj.rct_cxl_rmk.value=colArray[4];
		formObj.save_kind_cd.value="C";
		doActionIBSheet(sheetObj1, formObj, IBSAVE);
		formObj.rct_cxl_dt.value="";
		formObj.rct_cxl_cate_cd.value="";
		formObj.rct_cxl_rsn_cd.value="";
		formObj.rct_cxl_rmk.value="";
	}
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeRctOfcComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeRctOfcComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("^");
			var ots_ofc_cd=arrStr2[0];
			cmbObj.InsertItem(i-1, ots_ofc_cd, arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeAgtOfcComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeAgtOfcComboObject(cmbObj, arrStr) {
		for (var i=0; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeRctTypeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeRctTypeComboObject(cmbObj, arrStr) {
		for (var i=0; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("=");
			cmbObj.InsertItem(i, arrStr2[1], arrStr2[0]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeASANoComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeASANoComboObject(cmbObj, arrStr1, arrStr2) {
		for (var i=1; i < arrStr1.length; i++ ) {
			cmbObj.InsertItem(i-1, arrStr1[i] + "|" + arrStr2[i], arrStr1[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	function calApplyAmount(){
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var point=formObj.dp_prcs_knt.value;
		var subTotal=0;
		var grandTotal=0;
		var cnt=0;
		if(sheetObj1.RowCount()== 0){
			formObj.ttl_curr_cd.value="";
			formObj.ttl_count.value="";
			formObj.bl_ttl_amt.value="";
			formObj.ttl_amt.value="";
			return;
		}
		formObj.ttl_curr_cd.value=formObj.rct_curr_cd.value;
		formObj.ttl_count.value=sheetObj1.RowCount();
		//Calculate sub total and grand total amount
 		for(var i=1; i < sheetObj2.RowCount()+1; i++){
 			var chgAmt=ComReplaceStr(sheetObj2.GetCellValue(i, "rct_aply_amt"), ",", "");
			if(chgAmt != ""){
				if(!sheetObj2.GetRowHidden(i)){
					subTotal=ComRound(parseFloat(subTotal), point) + ComRound(parseFloat(chgAmt), point);
				}
				grandTotal=ComRound(parseFloat(grandTotal), point) + ComRound(parseFloat(chgAmt), point);
				cnt++;
			}
		}
		//Add bank charge amount to grand total amount
		var bankAmt=ComReplaceStr(formObj.bank_chg_amt.value, ",", "");
		if(bankAmt != ""){
			grandTotal=ComRound(parseFloat(grandTotal), point) - ComRound(parseFloat(bankAmt), point);
		}
		if(cnt > 0){
			formObj.bl_ttl_amt.value=ComRound(subTotal, point);
			formObj.ttl_amt.value=ComRound(grandTotal, point);
			if(point == "0"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###");
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt, "#,###");
			} else if(point == "1"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.0");
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt, "#,###.0");
			} else if(point == "" || point == "2"){
				formObj.bl_ttl_amt.value=ComAddComma2(formObj.bl_ttl_amt, "#,###.00");
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt, "#,###.00");
			}
		}
	}
	function setObjectDisable(bDisable){
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var rctStsCd=formObj.rct_sts_cd.value;
		var rctTpCd=rct_tp_cd.GetSelectCode();
		var unapyFlg=formObj.rct_unapy_flg.value;
		var bankChgAmt=formObj.bank_chg_amt.value;
		//Set form objects's status to disable or enable
		if(bDisable){
			if(!ComIsEmpty(agn_ofc_cd.GetSelectCode())){
				agn_ofc_cd.SetEnable(0);
				asa_no.SetEnable(0);
			}
			invoice_type.SetEnable(0);
			bound_type.SetEnable(0);
			ComEnableObject(formObj.chq_no, false);
			formObj.bank_acct_nm.className="input2";
			ComEnableObject(formObj.rct_dt, false);
			ComEnableObject(formObj.rct_dps_dt, false);
			ComEnableObject(formObj.rct_amt, false);
			rct_tp_cd.SetEnable(0);
			formObj.btns_bank.disabled=true;
			formObj.btns_calendar1.disabled=true;
			formObj.btns_calendar2.disabled=true;
			if(rctStsCd == "UNID"){
				ComBtnEnable("btn_cancel");
			} else if(rctStsCd == "UNAPP"){
				if(sheetObj1.RowCount()> 0){
					ComEnableObject(formObj.rct_cust_cnt_cd, false);
					ComEnableObject(formObj.rct_cust_seq, false);
					formObj.btns_cust.disabled=true;
     				if(ComIsEmpty(bankChgAmt)){
     					ComEnableObject(formObj.bank_chg_amt, true);
						formObj.bank_chg_amt.className="input";
					}
				}
				ComBtnEnable("btn_cancel");
			} else if(rctStsCd == "APP"){
				if(rctTpCd == "OFF"){
					ComBtnDisable("btn_reverse");
				} else {
					if(unapyFlg == "Y" && ComIsEmpty(bankChgAmt)){
						ComEnableObject(formObj.bank_chg_amt, true);
						formObj.bank_chg_amt.className="input";
					}
				}
				ComEnableObject(formObj.rct_cust_cnt_cd, false);
				ComEnableObject(formObj.rct_cust_seq, false);
				formObj.btns_cust.disabled=true;
				if(rctTpCd != "OFF" && unapyFlg == "Y"){	
				} else {
					ComBtnDisable("btn_otsadd");
					ComBtnDisable("btn_search");
					ComBtnDisable("btn_del1");
					ComBtnDisable("btn_add");
					ComBtnDisable("btn_del2");
				}
				ComBtnEnable("btn_cancel");
			} else if(rctStsCd == "CXL"){
				ComEnableObject(formObj.rct_cust_cnt_cd, false);
				ComEnableObject(formObj.rct_cust_seq, false);
				formObj.btns_cust.disabled=true;
				ComEnableObject(formObj.rct_rmk, false);
				ComBtnDisable("btn_otsadd");
				ComBtnDisable("btn_search");
				ComBtnDisable("btn_reverse");
				ComBtnDisable("btn_del1");
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_del2");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_receipt");
				ComBtnDisable("btn_cancel");
				sheetObj1.SetColEditable(1,0);
			}
		} else {
			agn_ofc_cd.SetEnable(1);
			asa_no.SetEnable(1);
			invoice_type.SetEnable(1);
			bound_type.SetEnable(1);
			ComEnableObject(formObj.chq_no, true);
			formObj.bank_acct_nm.className="input1";
			ComEnableObject(formObj.rct_dt, true);
			ComEnableObject(formObj.rct_dps_dt, true);
			ComEnableObject(formObj.rct_amt, true);
			rct_tp_cd.SetEnable(1);
			formObj.btns_bank.disabled=false;
			formObj.btns_calendar1.disabled=false;
			formObj.btns_calendar2.disabled=false;
			ComEnableObject(formObj.rct_cust_cnt_cd, true);
			ComEnableObject(formObj.rct_cust_seq, true);
			formObj.btns_cust.disabled=false;
			ComEnableObject(formObj.rct_rmk, true);
			ComEnableObject(formObj.bank_chg_amt, false);
			formObj.bank_chg_amt.className="input2";
			ComBtnEnable("btn_otsadd");
			ComBtnEnable("btn_search");
			ComBtnEnable("btn_reverse");
			ComBtnEnable("btn_del1");
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_del2");
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_receipt");
			ComBtnDisable("btn_cancel");
			formObj.rct_dt.className="input1";
			formObj.rct_dps_dt.className="input1";
			formObj.rct_amt.className="input1";
			sheetObj1.SetColEditable(1,1);
		}
	}
	function addHeaderDetailRow(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var otsSmryCd=formObj.ots_smry_cd.value;
		if(otsSmryCd == "BL" || otsSmryCd == ""){
			var blNo=formObj.bl_no.value;
			var invNo='**********';
		} else if(otsSmryCd == "INV"){
			var blNo=formObj.inv_no.value;
			var invNo=formObj.inv_no.value;
		}
		//Add header row in case of no existing OTS info
		sheetObject1.DataInsert(-1);
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "bl_no",blNo,0);
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "inv_no",invNo,0);
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "rct_aply_hdr_seq",blNo + invNo,0);
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "rct_aply_flg","N",0);
		//Add detail row in case of no existing OTS info
		sheetObject2.DataInsert(-1);
		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_hdr_seq",blNo + invNo,0);
		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_src_curr_cd",formObj.rct_curr_cd.value,0);
		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_xch_rt","1",0);
		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_curr_cd",formObj.rct_curr_cd.value,0);
		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "dp_prcs_knt",formObj.dp_prcs_knt.value,0);
		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "rct_aply_flg","N",0);
		sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "wrtf_cd",1);
	}
	function rdOpen(){
		var formObj=document.form;
		var rctNo=formObj.rct_no.value;
		var usrId=formObj.usr_id.value;
		var bound = formObj.bound_type.value;
		$("input[name*='com_mrd']" ).remove();
			
		if(formObj.local_chg_flag.value == 'Y'){
			var rdParam='/rp ['+rctNo+'] ['+usrId+'] /riprnmargin /rwait /rappendpageinit [1]'; 
			var strPath="apps/opus/stm/sar/accountreceivablecollect/accountreceivablereceipt/report/";
			
			var inp = null;
			inp = document.createElement("input");
			inp.type = "hidden";
			inp.name = "com_mrdPath";
			inp.value = strPath + "STM_SAR_2002.mrd";
			formObj.appendChild(inp);
			inp = document.createElement("input");
			inp.type = "hidden";
			inp.name = "com_mrdArguments";
			inp.value = rdParam;
			formObj.appendChild(inp);
			
			inp = document.createElement("input");
			inp.type = "hidden";
			inp.name = "com_mrdPath";
			inp.value = strPath + "STM_SAR_2002_1.mrd";
			formObj.appendChild(inp);
			inp = document.createElement("input");
			inp.type = "hidden";
			inp.name = "com_mrdArguments";
			inp.value = rdParam;
			formObj.appendChild(inp);
			
			if(bound == "L" || bound == "O") {			
				inp = document.createElement("input");
				inp.type = "hidden";
				inp.name = "com_mrdPath";
				inp.value = strPath + "STM_SAR_2002_1.mrd";
				formObj.appendChild(inp);
				inp = document.createElement("input");
				inp.type = "hidden";
				inp.name = "com_mrdArguments";
				inp.value = rdParam;
				formObj.appendChild(inp); 			
			}
			
			ComOpenRDPopupModal("width=1000px,height=650px,status=0,resizable=1"); 
		} else {
			var rdParam='/rp ['+rctNo+'] ['+usrId+']';
	        
	        var sXml=sheetObjects[0].GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=RECEIPT DOC&lu_cd=" + formObj.rct_doc_cd.value);
	    	var luCdList=ComGetEtcData(sXml, "lu_cd_list").split("=");	
	       
	        var strPath="apps/opus/stm/sar/accountreceivablecollect/accountreceivablereceipt/report/" + luCdList[2];
	        
	        var inp = null;
			inp = document.createElement("input");
			inp.type = "hidden";
			inp.name = "com_mrdPath";
			inp.value = strPath;
			formObj.appendChild(inp);
			inp = document.createElement("input");
			inp.type = "hidden";
			inp.name = "com_mrdArguments";
			inp.value = rdParam;
			formObj.appendChild(inp);
			
	        ComOpenRDPopupModal("width=1000px,height=650px,status=0,resizable=1"); 
		}
    }

	function resizeSheet(){
		ComResizeSheet(sheetObjects[0],100);
		ComResizeSheet(sheetObjects[1],100);
	}
	
	function fncCheckLocalChargeOffice() {
		var formObj=document.form;
		if ( rct_ofc_cd.GetSelectText() == chkLookupOneData(sheetObjects[0], "&lu_tp_cd=OTH RCT OFC&lu_cd="+rct_ofc_cd.GetSelectText())) {
			formObj.local_chg_flag.value="Y";
			//var strBoundCombo=SarGetComboItems(sheetObjects[0], "BOUND TYPE");
	 		//SarAddComboItem(bound_type, strBoundCombo, "2", "", "");	
	 		document.all.item("bound_label").style.display="";
	 		document.all.item("bound_input").style.display="";
	 		
	 		//var strFreightCombo=SarGetComboItems(sheetObjects[0], "FRT TYPE");
	 		//SarAddComboItem(invoice_type, strFreightCombo, "2", "", "");	
	 		document.all.item("invoice_label").style.display="";
	 		document.all.item("invoice_input").style.display="";
		} else {
			formObj.local_chg_flag.value="N";
			document.all.item("bound_label").style.display="none";
			document.all.item("bound_input").style.display="none";
			document.all.item("invoice_label").style.display="none";
	 		document.all.item("invoice_input").style.display="none";
		}
		settingWriteOff();

	}
	
	function settingWriteOff() {
		var formObj=document.form;
		//retrieve Write-off List
		formObj.f_cmd.value=SEARCH05;
		formObj.acct_ctnt.value="WRTF";
		formObj.acct_ctnt2.value="DFLT";
		formObj.acct_ctnt3.value=formObj.local_chg_flag.value;   // LOCAL_CHG_FLAG
		formObj.acct_ctnt4.value=formObj.bound_type.value;   // BOUND_TYPE
		var sXml=sheetObjects[0].GetSearchData("SARCommonGS.do", FormQueryString(formObj));
		var sStr1=ComGetEtcData(sXml,"acct_tp_cd");
		var sStr2=ComGetEtcData(sXml,"acct_tp_nm");
		var sStr3=ComGetEtcData(sXml,"pay_acct_cd");
		var sStr4=ComGetEtcData(sXml,"amt_sgn_cd");
		sStr1=" " + sStr1;
		sStr2=" " + sStr2;
		payAcctCd=sStr3.split("|");
		amtSgnCd=sStr4.split("|");
		sheetObjects[1].SetColProperty("wrtf_cd", {ComboText:sStr2, ComboCode:sStr1} );
	}
	
	/**
	 * function called when combo box bound_type change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author clt
	 * @version 2014.11.20
	 */	
	function bound_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		
		settingWriteOff();
		
		if (formObj.rct_no.value == "") { 
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			ComBtnEnable("btns_bank");
			ComClearObject(formObj.bank_acct_seq);
			ComClearObject(formObj.bank_acct_nm);	
		}
	}
	
	/**
	 * function called when combo box bound_type change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author clt
	 * @version 2014.11.20
	 */	
	function invoice_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		
		bound_type.RemoveAll();
		
		if (formObj.rct_no.value == "") { 
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			ComBtnEnable("btns_bank");
			ComClearObject(formObj.bank_acct_seq);
			ComClearObject(formObj.bank_acct_nm);	
		}
		
		if (newCode == "NFRT") { 
			var strBoundCombo=SarGetComboItems(sheetObjects[0], "BOUND TYPE&attr_ctnt5=NFRT");
			SarAddComboItem(bound_type, strBoundCombo, "2", "", "");	
		} else {
			var strBoundCombo=SarGetComboItems(sheetObjects[0], "BOUND TYPE&attr_ctnt1=A");
			SarAddComboItem(bound_type, strBoundCombo, "2", "", "");	
		}
	}	
	
	
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
	 		case "invoice_type":
	 			var i=0;
	 			with (comboObj) {
	 				//BackColor = "cyan";
	 				SetDropHeight(200);
	 				SetMultiSelect(0);
	 				SetMaxSelect(1);
	 				SetUseAutoComplete(1);
	 				//MaxLength = 50;
	 				SetColWidth(0, "0");
	 				SetColWidth(1, "146");
	 			}
	 			break;
	 		case "bound_type":
	 			var i=0;
	 			with (comboObj) {
	 				//BackColor = "cyan";
	 				SetDropHeight(200);
	 				SetMultiSelect(0);
	 				SetMaxSelect(1);
	 				SetUseAutoComplete(1);
	 				//MaxLength = 50;
	 				SetColWidth(0, "0");
	 				SetColWidth(1, "66");
	 			}
	 			break;
	 		case "asa_no":
	 			var i=0; 
	 			with (comboObj) {
	 				SetDropHeight(200);
	 				SetMultiSelect(0);
	 				SetMaxSelect(1);
	 				SetUseAutoComplete(1);
	 				//MaxLength = 50;
	 				SetColWidth(0, "100");
	 				SetColWidth(1, "40"); 
	 			}
	 			break;	
		}
	}	

	function calTotalAmount(ttlAplyAmt){
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var point=formObj.dp_prcs_knt.value;
		var grandTotal=0;
		
		formObj.ttl_curr_cd.value=formObj.rct_curr_cd.value;
		formObj.ttl_count.value=sheetObj1.RowCount();
		grandTotal = ComReplaceStr(formObj.ttl_amt.value, ",", "");
		
		if(ComIsEmpty(grandTotal)) grandTotal = ComRound(parseFloat(ttlAplyAmt), point);
		else grandTotal = ComRound(parseFloat(grandTotal), point) + ComRound(parseFloat(ttlAplyAmt), point);
		
		formObj.ttl_amt.value = ComRound(grandTotal, point);
		if(point == "0"){
			formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt, "#,###");
		} else if(point == "1"){
			formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt, "#,###.0");
		} else if(point == "" || point == "2"){
			formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt, "#,###.00");
		}
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObject  = sheetObjects[0];
		
		formObj.f_cmd.value = SEARCH05;
		
	 	var sXml = sheetObject.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
	 	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	 	
	 	if(jobState == "3") {
	    	clearInterval(timer);
	    	ComOpenWait(false);
	    	ComShowCodeMessage('SAR00004');
	    	getBackEndJobLoadFile();
	    	rdOpenFlg = "N";
	    } else if(jobState == "4") {
	    	// BackEndJob을 실패 하였습니다.
	    	clearInterval(timer);
	    	ComOpenWait(false);
	    	
	    	var jbUsrErrMsg=getBackEndJobErrMsg( ComGetEtcData(sXml, "jb_usr_err_msg") ) ;
	    	
	    	if(ComGetEtcData(sXml, "jb_usr_err_msg").indexOf("ORA-30006") > -1){
	    		ComShowCodeMessage('SAR00080');
	    	} else {
	    		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '') ComShowMessage(jbUsrErrMsg);
	    		else ComShowCodeMessage('SAR00032');
	    	}
	    	
	    	rdOpenFlg = "N";
	    }
	 
	}
	
	function getBackEndJobErrMsg(params) {
		var ary=params.split('<||>');
		return ary[3];
	}
	
	/**
	 * BackEndJob 관련 결과값 ( rct_no )를 확인한다.
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObject  = sheetObjects[0];
		
		formObj.f_cmd.value = SEARCH06;
		
	 	var sXml = sheetObject.GetSearchData("STM_SAR_2001GS.do", FormQueryString(formObj));
	 	var rctNo = ComGetEtcData(sXml, "rct_no");
	 	
		if(rctNo != undefined && rctNo != "") {
			formObj.rct_no.value = rctNo;
			doActionIBSheet(sheetObject,formObj,IBSEARCH);
		}
		
		if(rdOpenFlg == "Y" && formObj.rct_sts_cd.value!="UNID") rdOpen();
		
	}
