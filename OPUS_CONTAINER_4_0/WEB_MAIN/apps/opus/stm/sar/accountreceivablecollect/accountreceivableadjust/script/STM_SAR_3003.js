/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : STM_SAR_3003.js
 *@FileTitle  : Autosettlement Entry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class STM_SAR_3003 : business script for STM_SAR_3003
 */
// common global variable
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gCurRow = 0;
var prefix1 = "sheet1_";
var prefix2 = "sheet2_";

var selOfcCds = "";
var otsTpXcld = "";
var otsSrcXcld = "";

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() { 
	/** *** setting sheet object **** */
	var sheetObject1 = sheetObjects[0];
	
	/** **************************************************** */
	var formObj = document.form;
	
	try {
		var srcName = ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			if(!ComIsEmpty(formObj.multi_ofc_cd) && !ComIsEmpty(formObj.sail_arr_dt) && !ComIsEmpty(formObj.adj_dt) && !ComIsEmpty(formObj.bal_upd_dt)){
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}else{
				ComShowCodeMessage("COM130403", "Office Code, S/A Date, G/L Date, Balance Update Date");
			}
			break;
			
		case "btn_new":
			removeAll(formObj);
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;
			
		case "btns_sail_arr_dt_cal":
			var cal = new ComCalendar();
			cal.select(formObj.sail_arr_dt, 'yyyy-MM-dd');
			break;
			
		case "btns_adj_dt_cal":
			var cal = new ComCalendar();
			cal.select(formObj.adj_dt, 'yyyy-MM-dd');
			break;
			
		case "btns_bal_upd_dt_cal":
			var cal = new ComCalendar();
			cal.select(formObj.bal_upd_dt, 'yyyy-MM-dd');
			break;
			
		case "btns_xcld_ots_tp":
			var param = otsTpXcld;
			var popupMultiWin = ComOpenPopup('/opuscntr/STM_SAR_0161.do' + param, 600, 500, "getSTM_SAR_0161", "0,1", true, false);
			break;
			
		case "btn_multi_office_popup":
			var param = selOfcCds;
			var popupMultiWin = ComOpenPopup('/opuscntr/STM_SAR_0003.do' + param, 500, 470, 'getSTM_SAR_0003', '0,1', true, false);
			break;
			
		case "btns_xcld_ots_src":
			var param = otsSrcXcld;
			var popupMultiWin = ComOpenPopup('/opuscntr/STM_SAR_0004.do' + param, 580, 420, 'getSTM_SAR_0004', '0,1', true, false);
			break;
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBCombo Object as list param : combo_obj adding process for list
 * in case of needing batch processing with other items defining list on the top
 * of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	var sheetObject1 = sheetObjects[0];
	var formObj = document.form;
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	
	doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
}

/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sequence number in sheetObjects array
 */
function initControl() {
	// ** Date Separator **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	
	switch (sheetNo) {
		case 1: // t1sheet1 init
			with (sheetObj) {
				var HeadTitle1 = "|Del|Office|B/L No|Invoice No|Customer|Charge|Currency||||Balance|Balance LCL|Balance USD|VVD|S/A Date|OTS Source|OTS Type|||||||||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [ { Text : HeadTitle1, Align : "Center" } ];
				InitHeaders(headers, info);
				
				var cols = [ { Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : prefix1 + "ibflag" }, 
				             { Type : "CheckBox", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : prefix1 + "checkbox", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "clt_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 110, Align : "Center", ColMerge : 1, SaveName : prefix1 + "bl_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "inv_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "cust_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : prefix1 + "chg_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : prefix1 + "bl_curr_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix1 + "ots_bal_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 150, Align : "Right", ColMerge : 1, SaveName : prefix1 + "ots_bal_locl_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 150, Align : "Right", ColMerge : 1, SaveName : prefix1 + "ots_bal_usd_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 110, Align : "Right", ColMerge : 1, SaveName : prefix1 + "fmt_ots_bal_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 110, Align : "Right", ColMerge : 1, SaveName : prefix1 + "fmt_ots_bal_locl_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 110, Align : "Right", ColMerge : 1, SaveName : prefix1 + "fmt_ots_bal_usd_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "locl_vvd_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "sail_arr_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "ots_src_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "ots_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "adj_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "ots_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "bil_to_cust_cnt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "bil_to_cust_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "ots_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : prefix1 + "del_flag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix1 + "misc_lss_lmt_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix1 + "misc_incm_lmt_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix1 + "rhq_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix1 + "adj_no_key", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix1 + "bat_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }];
				InitColumns(cols);
				SetEditable(1);
				SetColProperty(prefix1+"sail_arr_dt", {Format:"####-##-##"} ); 
				SetSheetHeight(300);
				SetCountPosition(0);
				//resizeSheet();
			}
			break;
			
		case 2: // t1sheet2 init
			with (sheetObj) {
				var HeadTitle1 = "Office|B/L Count|Currency|Total Balance|Total LCL|Total USD||";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [ { Text : HeadTitle1, Align : "Center" } ];			
				InitHeaders(headers, info);
				
				var cols = [ { Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : prefix2 + "ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : prefix2 + "ofc_bl_cnt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : prefix2 + "ofc_bl_curr_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 115, Align : "Right", ColMerge : 1, SaveName : prefix2 + "ofc_bal_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 115, Align : "Right", ColMerge : 1, SaveName : prefix2 + "ofc_lcl_amt", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text", Hidden : 0, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix2 + "ofc_usd_amt", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix2 + "lcl_prcs", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
				             { Type : "Text", Hidden : 1, Width : 100, Align : "Right", ColMerge : 1, SaveName : prefix2 + "bl_prcs", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 }];
				InitColumns(cols);
				SetEditable(1);
//				SetSheetHeight(120, 1);
				SetCountPosition(0);
				resizeSheet();
			}
			break;
			
	}
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	
	switch (sAction) {
		case IBSEARCH: // retrieve adjust no
			if(validateForm(sheetObj, formObj, sAction)){
				formObj.f_cmd.value = SEARCH;
				formObj.backendjob_key.value = "";
				
				var prefixArr = new Array(prefix1, prefix2);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				setTimeout( function () {
					var sXml = sheetObj.GetSearchData("STM_SAR_3003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixArr));
					var rtnValue = sXml.split("|$$|"); 
					formObj.backendjob_key.value = ComGetEtcData(rtnValue[0], "BackEndJobKey");    
					
					sheetObj.LoadSearchData(rtnValue[0], { Sync : 1 });
					sheetObjects[1].LoadSearchData(rtnValue[1], { Sync : 1 });
					
					var ttlCnt = 0;
					var ttlUsd = 0; 
					
					for(var i=1; i <= sheetObjects[1].RowCount(); i++){
						var lclPrcs = sheetObjects[1].GetCellValue(i, prefix2 + "lcl_prcs");
						var blPrcs = sheetObjects[1].GetCellValue(i, prefix2 + "bl_prcs");
					
						if(blPrcs == "0") {
							sheetObjects[1].InitCellProperty(i, prefix2 + "ofc_bal_amt",{Type:"Int",Align:"Right",Format:"NullInteger"} );
						} else {
							sheetObjects[1].InitCellProperty(i, prefix2 + "ofc_bal_amt",{Type:"Float",Align:"Right",Format:"NullFloat",PointCount:blPrcs} );
						}
						
						if(lclPrcs == "0") {
							sheetObjects[1].InitCellProperty(i, prefix2 + "ofc_lcl_amt",{Type:"Int",Align:"Right",Format:"NullInteger"} );
						} else {
							sheetObjects[1].InitCellProperty(i, prefix2 + "ofc_lcl_amt",{Type:"Float",Align:"Right",Format:"NullFloat",PointCount:lclPrcs} );
						}
						
						sheetObjects[1].InitCellProperty(i, prefix2 + "ofc_usd_amt",{Type:"Float",Align:"Right",Format:"NullFloat",PointCount:2} );
						
						ttlCnt = parseInt(ttlCnt) + parseInt(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bl_cnt"));
						ttlUsd = ComRound(parseFloat(ttlUsd), 2) + ComRound(parseFloat(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_usd_amt")), 2);
					}
					
					if (sheetObjects[1].RowCount() >= 1) {		
						//formObj.tot_lcl_amt.value = sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), prefix2 + "ofc_lcl_amt");
						formObj.tot_usd_amt.value = ComAddComma2(ComRound(ttlUsd, 2)+"", "#,###.00");
						formObj.tot_cnt_amt.value = ttlCnt;
					}else {
		    			//formObj.tot_lcl_amt.value = "";
		        		formObj.tot_usd_amt.value = "";
		        		formObj.tot_cnt_amt.value = "";
		    		}
					ComOpenWait(false); 
				} , 100);
			}
			break;
			
		case IBSEARCH_ASYNC01: // retrieve Sail Arrival Date, GL Date, Balance
			// Update Date
			formObj.f_cmd.value = SEARCH01;
			
			var sXml = sheetObj.GetSearchData("STM_SAR_3003GS.do", FormQueryString(formObj));			
			var sStr = ComGetEtcData(sXml, "sail_arr_dt");
			var sStr1 = ComGetEtcData(sXml, "adj_dt");
			var sStr2 = ComGetEtcData(sXml, "bal_upd_dt");
			
			formObj.sail_arr_dt.value = ComGetMaskedValue(sStr, "ymd");
			formObj.adj_dt.value = ComGetMaskedValue(sStr1, "ymd");
			formObj.bal_upd_dt.value = ComGetMaskedValue(sStr2, "ymd");
			break;
			
		case IBSAVE: // save
			if(validateForm(sheetObj, formObj, sAction)){
				formObj.f_cmd.value = MULTI;
				
				var isHaveRow = false;
				for (var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++){
					if(sheetObjects[0].GetCellValue(i, prefix1 + "checkbox") == "0") {
						isHaveRow = true;
						break;
					}
				}
				
				if(!isHaveRow || ComIsNull(formObj.backendjob_key.value)){
					return;
				}
				var sParam1 = ComGetSaveString(sheetObjects[0], true, false, prefix1 + "checkbox");
			
				//msgs['SAR00038'] = 'Do you want to {?msg1}?';		
				if(!ComShowCodeConfirm("SAR00038", "proceed")) return;
				
				var sParam = sParam1 + "&" + FormQueryString(formObj);
				
				var sXml = sheetObj.GetSaveData("STM_SAR_3003GS.do", sParam);
				
				if(SarShowXmlMessage(sXml) != "") {
					ComShowCodeConfirm("COM132101");
					return;
				}else{
	 				// batch 가 running 상태일 경우, message 호출
	 				var batStsCd = ComGetEtcData(sXml, "batStsCd");
	 				if (!ComIsNull(batStsCd)) {
	 					if(batStsCd == "R"){
	 						//There is other {?msg1} execution in progress. Please try again after a few minutes.
	 						ComShowCodeMessage("SAR00079", "Autosettlement");		
	 						return;					
	 					}
	 				}					
				}
				
				sheetObjects[0].SetWaitImageVisible(0);
				ComOpenWait(true); 		 	
				sheetObjects[0].SetWaitTimeOut(10000);
				timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
			}
			break;		
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {		
		case IBSEARCH:
			var beforeSADate="";
			beforeSADate=ComGetDateAdd(formObj.adj_dt.value, "M", -2);
			if (formObj.sail_arr_dt.value > beforeSADate) {
	             ComShowCodeMessage("SAR00075", "S/A Date", "2");
	             formObj.sail_arr_dt.focus();
	             return false;
	        }
			
			var beforeUpDate="";
			beforeUpDate=ComGetDateAdd(formObj.adj_dt.value, "M", -1);
			if (formObj.bal_upd_dt.value > beforeUpDate) {
	             ComShowCodeMessage("SAR00075", "Update Date", "1");
	             formObj.bal_upd_dt.focus();
	             return false;
	        }
			
			break;
		
		case IBSAVE:
			var beforeSADate="";
			beforeSADate=ComGetDateAdd(formObj.adj_dt.value, "M", -2);
			if (formObj.sail_arr_dt.value > beforeSADate) {
				ComShowCodeMessage("SAR00075", "S/A Date", "2");
				formObj.sail_arr_dt.focus();
	             return false;
	        }
			
			var beforeUpDate="";
			beforeUpDate=ComGetDateAdd(formObj.adj_dt.value, "M", -1);
			if (formObj.bal_upd_dt.value > beforeUpDate) {
				ComShowCodeMessage("SAR00075", "Update Date", "1");
				formObj.bal_upd_dt.focus();
	             return false;
	        }

			break;
	}
	return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var ttlCnt = 0;
	var ttlUsd = 0;
	
	if (Col == 1) {
		for(var i = 1; i <= sheetObjects[1].RowCount(); i++) {
			if(sheetObj.GetCellValue(Row, prefix1 + "clt_ofc_cd") == sheetObjects[1].GetCellValue(i, prefix2 + "ofc_cd")
					&& sheetObj.GetCellValue(Row, prefix1 + "bl_curr_cd") == sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bl_curr_cd")
					&& sheetObj.GetCellValue(Row, prefix1 + "checkbox") == "1") {
				
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_bl_cnt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bl_cnt"))) - parseFloat(Number(1)));
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_lcl_amt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_lcl_amt"))) - parseFloat(Number(sheetObj.GetCellValue(Row, prefix1 + "ots_bal_locl_amt"))));
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_usd_amt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_usd_amt"))) - parseFloat(Number(sheetObj.GetCellValue(Row, prefix1 + "ots_bal_usd_amt"))));
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_bal_amt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bal_amt"))) - parseFloat(Number(sheetObj.GetCellValue(Row, prefix1 + "ots_bal_amt"))));
				
			}else if (sheetObj.GetCellValue(Row, prefix1 + "clt_ofc_cd") == sheetObjects[1].GetCellValue(i, prefix2 + "ofc_cd")
					&& sheetObj.GetCellValue(Row, prefix1 + "bl_curr_cd") == sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bl_curr_cd")
					&& sheetObj.GetCellValue(Row, prefix1 + "checkbox") == "0") {
				
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_bl_cnt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bl_cnt"))) + parseFloat(Number(1)));
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_lcl_amt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_lcl_amt"))) + parseFloat(Number(sheetObj.GetCellValue(Row, prefix1 + "ots_bal_locl_amt"))));
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_usd_amt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_usd_amt"))) + parseFloat(Number(sheetObj.GetCellValue(Row, prefix1 + "ots_bal_usd_amt"))));
				sheetObjects[1].SetCellValue(i, prefix2 + "ofc_bal_amt", parseFloat(Number(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bal_amt"))) + parseFloat(Number(sheetObj.GetCellValue(Row, prefix1 + "ots_bal_amt"))));
				
			}
			
			ttlCnt = parseInt(ttlCnt) + parseInt(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_bl_cnt"));
			ttlUsd = ComRound(parseFloat(ttlUsd), 2) + ComRound(parseFloat(sheetObjects[1].GetCellValue(i, prefix2 + "ofc_usd_amt")), 2);
		}
		
		//formObj.tot_lcl_amt.value = sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), prefix2 + "ofc_lcl_amt");
		formObj.tot_usd_amt.value = ComAddComma2(ComRound(ttlUsd, 2)+"", "#,###.00");
		formObj.tot_cnt_amt.value = ttlCnt;
	}
}

/**
 * call method when select event on popup(STM_SAR_0003)<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {array}
 *            rowArray
 * @return none
 * @see #
 * @author SHIN
 * @version 2014.04.03
 */
function getSTM_SAR_0003(data) {
	var multiOfcCd = "";
	selOfcCds = "";
	
	if(data.length > 0){
		for ( var i = 0; i < data.length; i++) {
			var row = data[i];
			if (i > 0) {
				multiOfcCd += " , '" + row[2] + "'";
				selOfcCds += "&selOfcCds=" + row[2];
			} else {
				multiOfcCd += "'" + row[2] + "'";
				selOfcCds += "?selOfcCds=" + row[2];
			}
		} 
	} else {
		selOfcCds = "";  
    	multiOfcCd = ""; 
    } 
	
	var frm = document.form;
	
	frm.multi_ofc_cd.value = multiOfcCd;
}

function getSTM_SAR_0161(data) {
	var multiOtsTpXcld = "";
	otsTpXcld = "";
	
	 if(data.length > 0){
    	 for(var i=0; i < data.length; i++) {
	        var row=data[i];
	        if (i > 0 ) {        	
	        	multiOtsTpXcld +=  " , '" + row[2] +"'";
	        	otsTpXcld +=  "&otsTpXcld=" + row[2];
	        } else {
	        	multiOtsTpXcld +=  "'" + row[2] +"'";
	        	otsTpXcld +=  "?otsTpXcld=" + row[2];
	        }    
	    } 
    } else {
    	otsTpXcld = "";
    	multiOtsTpXcld = "";
    } 
	
	var frm = document.form;
	
	frm.xcld_ots_tp_cd.value = multiOtsTpXcld;
}

function getSTM_SAR_0004(data) {
	var multiOtsTpXcld = "";
	otsSrcXcld = "";
	
	if(data.length > 0){
		for ( var i = 0; i < data.length; i++) {
			var row = data[i];
			if (i > 0) {
				multiOtsTpXcld += " , '" + row[2] + "'";
				otsSrcXcld += "&otsSrcXcld=" + row[2];
			} else {
				multiOtsTpXcld += "'" + row[2] + "'";
				otsSrcXcld += "?otsSrcXcld=" + row[2];
			}
		} 
	} else {
		otsSrcXcld = "";
		multiOtsTpXcld = "";
    } 
	var frm = document.form;
	
	frm.xcld_ots_src_cd.value = multiOtsTpXcld;
}

function removeAll(formObj) {
	var sheetObject1 = sheetObjects[0];
	var formObj = document.form;
	
	selOfcCds = "";
	otsTpXcld = "";
	otsSrcXcld = "";
	
	formObj.reset();
	formObj.xcld_ots_tp_cd.value = "";
	formObj.xcld_ots_src_cd = "";
	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[1],60);
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
	var formObj=document.form;
	var sheetObject=sheetObjects[0]; 
	formObj.f_cmd.value=SEARCH04;
	var param=FormQueryString(formObj);
	var sXml=sheetObject.GetSearchData("STM_SAR_3003GS.do", param);
 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
 	if(jobState == "3") {
    	clearInterval(timer);
    	ComOpenWait(false);
    	ComShowCodeMessage('SAR00004');
    	//조회
    	removeAll(formObj);	
    } else if(jobState == "4") {
    	// BackEndJob을 실패 하였습니다.
    	clearInterval(timer);
    	ComOpenWait(false);
    	ComShowCodeMessage('SAR00032');
    	removeAll(formObj);	
    }
}