/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_3002.js
*@FileTitle  : Offset Entry
*@author     : CLT
*@version    : 1.0
*@LastModify : 2014/12/15
*@since      : 2014/08/05
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;

// IBMultiCombo
var comboObjects=new Array();
var combo1=null
var comboCnt=0;

// html form
var frm=null; 
var dpPrcsMap = new HashMap();
var otsSmryText = ""; 

/**
 * IBSheet Object를 배열로 등록
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * 
 * @param {IBMultiCombo} combo_obj IBMultiCombo Object
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	// global variable set
    frm=document.form;
    
    sheet1=sheetObjects[0];   
    sheetCnt=sheetObjects.length ;
	// sheet initialize
	for (var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1 ,"", 2);
		ComEndConfigSheet(sheetObjects[i]);
	}
	  
	// IBMultiCombo초기화
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	
    // Form event register
    initControl();
    
    ComBtnDisable("btn_reverse");
    
    // combo 및 초기 데이타 취득
    doActionIBSheet(INIT);
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo,otsTypeText ,point) {
	var cnt=0;
	with (sheetObj) {
		switch (sheetObj.id) {
	        case "sheet1":     
	        	if(ComIsNull(otsTypeText)){ 
	        		otsTypeText = 'B/L No(Invoice No)';    
	        	}
	            var HeadTitle1="|Del|Office|Customer\nVendor|Customer\nVendor Name|Type|"+otsTypeText+"|Charge" +
	            "|Curr|Original Amount|Settled Amount|Ex.Rate|Equivalence\nAmount|Offset  No|Reverse|GL Date"+
	            "|bil_to_cust_cnt_cd|bil_to_cust_seq|rhq_cd|ots_ofc_cd|bl_no|inv_no|max_ar_if_no|offst_curr_cd|ap_inv_no|ar_offst_seq|ap_remark|ap_du_dt|ori_offst_amt|dp_prcs_knt";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            
	            SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            
	            var cols = [ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"CheckBox",  Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"offst_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bl_inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ots_bal_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	                         {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"offst_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	                         {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"offst_xch_rt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 } ];
	                         
	            if(point == '0' || point == undefined || point == "") {
	            	cols.push({Type:"Int",   Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"offst_xch_amt",    KeyField:0,   CalcLogic:"|offst_amt|*|offst_xch_rt|",Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 });
                } else {
                	cols.push({Type:"Float", Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"offst_xch_amt",    KeyField:0,   CalcLogic:"|offst_amt|*|offst_xch_rt|",Format:"NullFloat",       PointCount:point,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 });
                } 
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_offst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cxl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"gl_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });		
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bil_to_cnt_cd" });
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bil_to_cust_seq" });
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd" });
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ots_ofc_cd" });
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no" });
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no" });
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"max_ar_if_no" });	
	            cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"offst_curr_cd" });
                cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_inv_no" });
                cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_offst_seq" });
                cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_remark" });
                cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_du_dt" });
                cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_gl_dt" });		
                cols.push({Type:"Float",     Hidden:1,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ori_offst_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });		
                cols.push({Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_prcs_knt"});		
	          
                console.log(cols);
	            InitColumns(cols); 
	            SetEditable(1); 
//	            SetSheetHeight(340);
	            resizeSheet();
				break;			
		}
	}
}

/**
 * 콤보 초기설정값
 * 
 * @param {IBMultiCombo} comboObj comboObj
 */
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);	
	comboObj.SetLineColor("#7896B1");
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
	comboObj.SetBackColor("#CCFFFD");
}

// ===================================================================================
// Private function
// ===================================================================================
/**
 * handling process for input validation
 */
function validateForm() {
	if (ComIsNull(frm.ar_offst_no.value)) {
		// msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
		ComShowCodeMessage('COM130403', 'Offset No');
		frm.ar_offst_no.focus();
		
		return false;
	}
	
    return true;
}
 
/**
 * Validate Currency
 */
function validateCurr() {
	var offst_curr_cd=frm.offst_curr_cd.value;
	
	if(!ComIsNull(offst_curr_cd)) {
		if(offst_curr_cd.length == 3) {
			var param="f_cmd=" + SEARCH08 + "&curr_cd=" + offst_curr_cd;		
			var sXml=sheet1.GetSearchData("SARCommonGS.do", param);
			var sStr=ComGetEtcData(sXml,"curr_cd_list");
			
			if (ComIsNull(sStr)) {
				// msgs['COM130402'] = '{?msg1} doesn\'t exist';
				ComShowCodeMessage('COM130402', 'Offset CUR');
				frm.offst_curr_cd.focus();
				
				return  false;
			}
		} else {
			// msgs['COM130402'] = '{?msg1} doesn\'t exist';
			ComShowCodeMessage('COM130402', 'Offset CUR');
			frm.offst_curr_cd.focus();
			
			return  false;
		}
	}
	
	return  true;
}

/**
 * cal total ar,ap amount
 */
function calTotSum() {
	var totalSum=[];
	var apSum=0;
	var arSum=0;
	var point = 0;
	
	var offst_curr_cd=frm.offst_curr_cd.value;
	var dpPrcsKnt = dpPrcsMap.get(offst_curr_cd); 
	if(dpPrcsKnt == '0' || dpPrcsKnt == undefined || dpPrcsKnt == "") {
		point=new Number('0');
	} else {
		point=new Number(dpPrcsKnt);
	}
	
	for(var i=1; i <= sheet1.RowCount(); i++) {
		if (sheet1.GetCellValue(i, "offst_tp_cd") == 'AR') {
			arSum += parseFloat(ComRound(sheet1.GetCellValue(i, "offst_xch_amt"), point));
		} else if (sheet1.GetCellValue(i, "offst_tp_cd") == 'AP') {
			apSum += parseFloat(ComRound(sheet1.GetCellValue(i, "offst_xch_amt"), point));
		}
	}
	 
	totalSum[0]=SarRound(arSum,point);
	totalSum[1]=SarRound(apSum,point);
	
	return totalSum;
}

// ===================================================================================
// IBCombo Event
// ===================================================================================

//function combo1_OnChange(idx_cd, text) {
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var offstDt = frm.ar_offst_dt.value;
	resetForm();
	ComBtnDisable("btn_reverse");
	ComBtnEnable("btn_save");   
	sheet1.RemoveAll();		
	sheet1.SetEditable(1);
	
	frm.ar_offst_dt.value = offstDt;
	var selOfcInfo = newCode.split("^");
	var otsSmryCd = "";
	var dpPrcsKnt = "2";
	
	if (typeof selOfcInfo.length != "undefined") {
		frm.offst_curr_cd.length = 0;
		ComAddComboItem(frm.offst_curr_cd, selOfcInfo[9],  selOfcInfo[9]);
		dpPrcsMap.put(selOfcInfo[9],selOfcInfo[10]); 
		if (frm.offst_curr_cd.value != 'USD') {				
			ComAddComboItem(frm.offst_curr_cd, "USD",  "USD");
			dpPrcsMap.put("USD",'2'); 
		}
		frm.offst_curr_cd.value = selOfcInfo[9];
		frm.offst_ofc_cd.value = selOfcInfo[0];
		dpPrcsKnt = selOfcInfo[10];
		otsSmryCd = selOfcInfo[3];
	}	
	ComEnableObject(frm.ap_remark,true);
	frm.ap_remark.className = "input";
	frm.ap_duedate.value = ComGetNowInfo("ymd"); 
	ComEnableObject(frm.ap_duedate,true);
	frm.ap_duedate.className = "input1";
	ComSetDisplay("btns_ap_dudate", true);
	ComBtnEnable("btn_ar_search");
	ComBtnEnable("btn_ap_search");
	ComBtnEnable("btn_delete");
	 
	if(otsSmryCd == 'BL'){
		otsSmryText = "B/L No";
	} else {
		otsSmryText = "Invoice No";
	}
	sheetObjects[0] = sheetObjects[0].Reset();  
	ComConfigSheet(sheetObjects[0]);
	initSheet(sheetObjects[0],1,otsSmryText,dpPrcsKnt);	
	ComEndConfigSheet(sheetObjects[0]);
}

//Button event handler
document.onclick=processButtonClick;

/**
 * Button event handler function
 */
function processButtonClick() {
	
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
		case "btns_ap_dudate":
			var cal = new ComCalendar();
			cal.select(frm.ap_duedate, 'yyyy-MM-dd');
			break;
			
		case "btn_ar_search":
			var ofcInfos = combo1.GetSelectCode().split("^");
			var ots_smry_cd = ofcInfos[3];
			var rhq_cd = ofcInfos[2];
			var ots_cd = ofcInfos[4];
			var rep_ots_ofc_cd = ofcInfos[5];
			var ots_ofc_cd = ofcInfos[0];
			
			var offst_curr_cd = frm.offst_curr_cd.value;				
			if (ComIsNull(offst_curr_cd)) {
				ComShowCodeMessage("SAR00013", "Offset CUR");
				frm.offst_curr_cd.focus();
				
				return;
			}
			
			if (sheet1.RowCount()> 0) {
				var sheet1_offst_curr_cd = sheet1.GetCellValue(1, "offst_curr_cd");
				
				if (sheet1_offst_curr_cd != offst_curr_cd) {
					frm.offst_curr_cd.focus();
					
					return;				
				}
			}
			
			if (!validateCurr()) {
				return;
			}
			
			if (ComIsNull(combo1.GetSelectText())) {
				ComShowCodeMessage("SAR00013", "Office");			
				return;			
			}
			
			var param="ots_smry_cd="+ ots_smry_cd +"&rhq_cd="+ rhq_cd +"&ots_cd="+ ots_cd +
		            	"&rep_ots_ofc_cd="+ rep_ots_ofc_cd +"&inv_ofc_cd="+ ots_ofc_cd +
		            	"&offst_curr_cd="+ offst_curr_cd +"";
			//890 
			var popupWin=ComOpenPopup('/opuscntr/STM_SAR_0241.do?' + param, 900, 660, 'getSTM_SAR_0241', '0,1', true, false);
			
			break;
			
		case "btn_ap_search":		
			var offst_curr_cd = frm.offst_curr_cd.value;
			var ofcInfos = combo1.GetSelectCode().split("^");
			var ots_cd = ofcInfos[4];
			var rep_ots_ofc_cd = ofcInfos[5];
			
			if (ComIsNull(offst_curr_cd)) {
				ComShowCodeMessage("SAR00013", "Offset CUR");
				frm.offst_curr_cd.focus();
				
				return;
			}
			
			if (sheet1.RowCount()> 0) {
				var sheet1_offst_curr_cd = sheet1.GetCellValue(1, "offst_curr_cd");
				
				if (sheet1_offst_curr_cd != offst_curr_cd) {
					frm.offst_curr_cd.focus();
					
					return;				
				}
			}
			
			if (!validateCurr()) {
				return;
			}
			
			if (ComIsNull(combo1.GetSelectText())) {
				ComShowCodeMessage("SAR00013", "Office");			
				return;			
			}
			
			var param = 'ofc_cd=' + combo1.GetSelectText() + "&offst_curr_cd="+ offst_curr_cd +"&ots_cd="+ ots_cd +	"&rep_ots_ofc_cd="+ rep_ots_ofc_cd;
			var popupWin = ComOpenPopup('/opuscntr/STM_SAR_0242.do?' + param, 825, 630, 'getSTM_SAR_0242', '0,1', true, false);
			break;		
			
		case "btn_searchlist":		
			doActionIBSheet(SEARCHLIST);		
			break;
			
		case "btn_delete":		
			SarCheckedRowDelete(sheet1, "checkbox");
			// set offset amount
			setOffstAmt();
			if (sheet1.RowCount()== 0) {
				frm.offst_curr_cd.disabled = false;
			}
			break;
			
		case "btn_save":
			doActionIBSheet(MULTI);
			break;
			
		case "btn_reverse":
			doActionIBSheet(MODIFY);
			break;
			
		case "btn_new":
			resetForm();
			ComBtnDisable("btn_reverse");
			ComBtnEnable("btn_save");
			
			doActionIBSheet(INIT);
			sheet1.RemoveAll();
			sheet1.SetEditable(1);
			frm.offst_curr_cd.disabled = false;
			ComEnableObject(frm.ap_remark,true);
			frm.ap_remark.className = "input";
			frm.ap_duedate.value = ComGetNowInfo("ymd"); 
			ComEnableObject(frm.ap_duedate,true);
			frm.ap_duedate.className = "input1";
			ComSetDisplay("btns_ap_dudate", true);
			ComBtnEnable("btn_ar_search");
			ComBtnEnable("btn_ap_search");
			ComBtnEnable("btn_delete");
			break;
			
		case "btn_view_accounting":
			if(ComIsNull(frm.ar_offst_no.value)) {
				// msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
				ComShowCodeMessage('COM130403', 'Offset No');
				frm.ar_offst_no.focus();
				return;
			}
			
			if (sheet1.RowCount()== 0) {
				// msgs['COM12189'] = 'Nothing selected';
				ComShowCodeMessage("COM12189");
				return;
			}
			
			var param="adj_no=" + frm.ar_offst_no.value + "&ots_ofc_cd=" + combo1.GetSelectText() + "&action_type=OFF";
			var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_3004.do?" + param, "adj_view_accounting_popup", 1000, 550, false, "no");		
			popupWin.focus();
			break;
			
		case "btn_excel":
			if (sheet1.RowCount()<= 0 ) {
				// msgs["SAR00030"] = "There is no data to search.";
				ComShowCodeMessage("SAR00030");
				return false;
			}
			
			sheet1.Down2Excel({ HiddenColumn:false,DownCols:'2|3|4|5|6|7|8|9|10|11|12|13|14',TreeLevel:false,SheetName:"Offsetentry"});
			break;
	}
}

/**
 * call method when select event on popup(STM_SAR_0241)<br>
 * <br>
 * <b>AR Search Popup</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {array} data
 * @return none
 * @see #
 * @author jinyoonoh
 * @version 2014.03.24
 */
function getSTM_SAR_0241(data) {	
	// SarShowPopupData(data);
	if (data == null ||  data.length == 0) {
		return ;
	}
	
	// "||Office|Customer|Customer Name|B/L No|Chg Type|Currency|Amount" +
	// 01 2 3 4 5 6 7 8
    // "|offset_tp|vvd_cd|bil_to_cust_cnt_cd|bil_to_cust_seq|rhq_cd|ots_ofc_cd"+
	// 9 10 11 12 13 14
    // "|bl_no|inv_no|inv_amt|adj_amt|locl_xch_rt|usd_xch_rt|bal_locl_amt|bal_usd_amt";
	// 15 16 17 18 19 20 21 22
	// "|pol_cd|pod_cd|svc_scp_cd|bkg_io_bnd_cd|xch_rt_dt|xch_rt_tp_cd|ar_xch_rt|ar_xch_amt|max_ar_if_no|gl_dt|dp_prcs_knt";
	// 23 24 25 26 27 28 29 30 31 32 33
	
	for (var i=0; i < data.length; i++) {
		var row=data[i];
		
		for(var j=1; j <=  sheet1.RowCount(); j++) {
			if (sheet1.GetCellValue(j, "ofc_cd") == row[2] && sheet1.GetCellValue(j, "bl_inv_no") == row[5] 
				&& sheet1.GetCellValue(j, "chg_tp_cd") == row[6] && sheet1.GetCellValue(j, "curr_cd") == row[7]) {
				// msgs['SAR00022'] = 'Already selected {?msg1}';
				ComShowCodeMessage("SAR00022" , "AR" , "(NO:" + row[5] +",OFFICE:" + row[2] + ",CHG:" + row[6] + ",CURR:" + row[7] + ")");
				return;
			}
		}
		
		row[8] = ComReplaceStr(row[8],",","");
		var point = row[33];
		
		var rowIdx=sheet1.DataInsert(-1);
		
		if(point == '0' || point == undefined || point == "") {
			sheet1.InitCellProperty(rowIdx, "ots_bal_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			sheet1.InitCellProperty(rowIdx, "offst_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			sheet1.InitCellProperty(rowIdx, "ori_offst_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
			sheet1.InitCellProperty(rowIdx, "ots_bal_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheet1.InitCellProperty(rowIdx, "offst_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheet1.InitCellProperty(rowIdx, "ori_offst_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		}
		
		sheet1.SetCellValue(rowIdx, "ofc_cd",row[2],0);
		sheet1.SetCellValue(rowIdx, "vndr_no",row[3],0);
		sheet1.SetCellValue(rowIdx, "vndr_lgl_eng_nm",row[4],0);
		sheet1.SetCellValue(rowIdx, "offst_tp_cd",row[9],0);
		sheet1.SetCellValue(rowIdx, "bl_inv_no",row[5],0);
		sheet1.SetCellValue(rowIdx, "chg_tp_cd",row[6],0);
		sheet1.SetCellValue(rowIdx, "curr_cd",row[7],0);
		sheet1.SetCellValue(rowIdx, "ots_bal_amt",row[8],0);
		sheet1.SetCellValue(rowIdx, "offst_amt",row[8],0);
		sheet1.SetCellValue(rowIdx, "offst_xch_rt",row[29],0);
		sheet1.SetCellValue(rowIdx, "ar_offst_no","",0);
		sheet1.SetCellValue(rowIdx, "cxl_flg","N",0);
		sheet1.SetCellValue(rowIdx, "bil_to_cnt_cd",row[11],0);
		sheet1.SetCellValue(rowIdx, "bil_to_cust_seq",row[12],0);
		sheet1.SetCellValue(rowIdx, "rhq_cd",row[13],0);
		sheet1.SetCellValue(rowIdx, "ots_ofc_cd",row[14],0);
		sheet1.SetCellValue(rowIdx, "bl_no",row[15],0);
		sheet1.SetCellValue(rowIdx, "inv_no",row[16],0);
		sheet1.SetCellValue(rowIdx, "max_ar_if_no",row[31],0);
		sheet1.SetCellValue(rowIdx, "offst_curr_cd",frm.offst_curr_cd.value,0);
		sheet1.SetCellValue(rowIdx, "gl_dt",row[32],0);
		sheet1.SetCellEditable(rowIdx, "offst_xch_rt", 1);   
		sheet1.SetCellValue(rowIdx, "ori_offst_amt",row[8],0); 
	}
	
	frm.offst_curr_cd.disabled = true;
	
	// set offset amount
	setOffstAmt();
}

/**
 * call method when select event on popup(STM_SAR_0242)<br>
 * <br>
 * <b>AP Search Popup :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {array} data
 * @return none
 * @see #
 * @author jinyoonoh
 * @version 2014.03.24
 */
function getSTM_SAR_0242(data) {
	// SarShowPopupData(data);
	if (data == null ||  data.length == 0) {
		return ;
	}
	
	// "||Office|Supplier|Vendor Name|Invoice No|Invoice
	// Date|Currency|Amount|offset_tp|org_inv_amt|ap_xch_rt|gl_dt|dp_prcs_knt";
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
	for (var i=0; i < data.length; i++) {
		var row = data[i];
		
		for(var j=1; j <=  sheet1.RowCount(); j++) {
			if (sheet1.GetCellValue(j, "ofc_cd") == row[2] 
				&& sheet1.GetCellValue(j, "bl_inv_no") == row[5] && sheet1.GetCellValue(j, "curr_cd") == row[7]) {
				// msgs['SAR00022'] = 'Already selected {?msg1}';
				ComShowCodeMessage("SAR00022" , "AP", "(NO:" + row[5] +",OFFICE:" + row[2] + ",CURR:" + row[7] + ")");
				return;
			}
		}
		
		
		row[8] = ComReplaceStr(row[8],",","");
		var point = row[13];
		 
		var rowIdx=sheet1.DataInsert(-1);
		
		if(point == '0' || point == undefined || point == "") {
			sheet1.InitCellProperty(rowIdx, "ots_bal_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			sheet1.InitCellProperty(rowIdx, "offst_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			sheet1.InitCellProperty(rowIdx, "ori_offst_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
			sheet1.InitCellProperty(rowIdx, "ots_bal_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheet1.InitCellProperty(rowIdx, "offst_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheet1.InitCellProperty(rowIdx, "ori_offst_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		}
		
		sheet1.SetCellValue(rowIdx, "ofc_cd",row[2],0);
		sheet1.SetCellValue(rowIdx, "vndr_no",row[3],0);
		sheet1.SetCellValue(rowIdx, "vndr_lgl_eng_nm",row[4],0);
		sheet1.SetCellValue(rowIdx, "offst_tp_cd",row[9],0);
		sheet1.SetCellValue(rowIdx, "bl_inv_no",row[5],0);
		sheet1.SetCellValue(rowIdx, "chg_tp_cd","",0);
		sheet1.SetCellValue(rowIdx, "curr_cd",row[7],0);
		sheet1.SetCellValue(rowIdx, "ots_bal_amt",row[10],0);
		sheet1.SetCellValue(rowIdx, "offst_amt",row[8],0);
		sheet1.SetCellValue(rowIdx, "offst_xch_rt",row[11],0);
		sheet1.SetCellValue(rowIdx, "ar_offst_no","",0);
		sheet1.SetCellValue(rowIdx, "cxl_flg","N",0);
		sheet1.SetCellValue(rowIdx, "ap_inv_no",row[5],0);
		sheet1.SetCellValue(rowIdx, "gl_dt",row[12],0);
		sheet1.SetCellValue(rowIdx, "offst_curr_cd",frm.offst_curr_cd.value,0);
	}
	
	frm.offst_curr_cd.disabled = true;
	
	// set offset amount
	setOffstAmt();
}

/**
 * Form Event register
 */
function initControl() {
    axon_event.addListenerFormat('change', 'obj_change', frm);
    axon_event.addListenerFormat ('keydown', 'obj_keydown', frm);
}

/**
 * HTML Control onChange
 */
function obj_change() {
	switch (ComGetEvent("name")) {
		case "vndr_no":
			frm.vndr_lgl_eng_nm.value="";
			break;
			
		default:
			break;
	}	
}

/**
 * Handling OnKeyDown even <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param N/A
 * @return N/A
 * @author 
 * @version 2009.04.17
 */       
function obj_keydown(){
   //Proposal No,S/C No.,Retrieving by enter key
   var eleName = ComGetEvent("name");
  
   var keyValue = null;
   if(event == undefined || event == null) {
	   keyValue = 13;
   } else {
	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   }
 
   if (keyValue == 13 && eleName == "ar_offst_no"){
	   doActionIBSheet(SEARCHLIST);
   }
    
}

/**
 * sheet1 편집처리후 이벤트
 * 
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 * @param {string} col 해당 셀의 value
 */
function sheet1_OnChange(sheet, row, col ,value) {
	if (sheet.ColSaveName(col) == "offst_amt" || sheet.ColSaveName(col) == "offst_xch_rt") {  
		var otsbal = sheet.GetCellValue(row, "ots_bal_amt");
		var adjbal = sheet.GetCellValue(row, "offst_amt");
		var oriBal = sheet.GetCellValue(row, "ori_offst_amt");
		if(Math.abs(otsbal) < Math.abs(adjbal)){
			ComShowCodeMessage("SAR00061");
			sheet.SetCellValue(row, "offst_amt",oriBal, 0);    
			sheet.SelectCell(row, "offst_amt", true, "");  
		} 
		setOffstAmt(); 
	}
} 

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		if(sheetObj.HeaderRows() == i){
			var set_curr_cd= sheetObj.GetCellValue(i, "offst_curr_cd"); 
			$("select[name=offst_curr_cd] option[value="+set_curr_cd+"]").attr("selected",true); 
			ComEnableObject(frm.offst_curr_cd,false); 
		}
		
		var point = sheetObj.GetCellValue(i, "dp_prcs_knt"); 
		if(point == '0' || point == undefined || point == "") { 
			sheetObj.InitCellProperty(i, "ots_bal_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			sheetObj.InitCellProperty(i, "offst_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			sheetObj.InitCellProperty(i, "ori_offst_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
			sheetObj.InitCellProperty(i, "ots_bal_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheetObj.InitCellProperty(i, "offst_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheetObj.InitCellProperty(i, "ori_offst_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		}
	}
	setOffstAmt();
}

/**  
 * set offset amount
 */
function setOffstAmt() {
	var offst_curr_cd=frm.offst_curr_cd.value;
	var dpPrcsKnt = dpPrcsMap.get(offst_curr_cd); 
	if(dpPrcsKnt == '0' || dpPrcsKnt == undefined || dpPrcsKnt == "") {
		point=new Number('0');
	} else {
		point=new Number(dpPrcsKnt);
	}
	var sum=calTotSum();
		
	frm.tot_ar_offst_amt.value= SarMakeNumberFormat(sum[0],point); 
	frm.tot_ap_offst_amt.value=  SarMakeNumberFormat(sum[1],point);
	frm.offst_balance.value=  SarMakeNumberFormat(ComRound(sum[0] - sum[1], point),point);
}

/**
 * add float digits
 * 
 * @param {float} fval float value
 * @param {int} digits float digits
 * @param {float} add float digits
 * 
 */
function addDigits(fval, digits) {
	var sval = fval + "";
	
	if(sval.indexOf(".") >= 0) {
		return fval;
	}
	
	sval += ".";
	
	for(var i=0; i < digits; i++) {
		sval += "0";
	}
	
	return parseFloat(sval);
}

/**
 * Do action
 * 
 * @param {string} sAction
 */
function doActionIBSheet(sAction,hideYn) {
	// [Search]
	if (sAction == SEARCHLIST) {	
		if (validateForm()) {
			frm.f_cmd.value=sAction;
			
			sheet1.WaitImageVisible=false;
			if(hideYn){
				SarOpenWait(true,true);
			} else {
				ComOpenWait(true); 
			} 	
			setTimeout( function () {
				var sXml=sheet1.GetSearchData("STM_SAR_3002GS.do", FormQueryString(frm));
				sheet1.LoadSearchData(sXml,{Sync:1} );
				
				if (sheet1.RowCount()> 0) {
					var cxlFlg = sheet1.GetCellValue(1, "cxl_flg");
					
					if (cxlFlg == "N") {
						ComBtnEnable("btn_reverse");
					} else {
						ComBtnDisable("btn_reverse"); 
						frm.reverse_gl_dt.value = ComGetMaskedValue(sheet1.GetCellValue(1, "rev_gl_dt"), "ymd");    
					}
					ComBtnDisable("btn_save");
					sheet1.SetEditable(0);
					frm.gl_dt.value = ComGetMaskedValue(sheet1.GetCellValue(1, "gl_dt"), "ymd");
					frm.ap_remark.value = sheet1.GetCellValue(1, "ap_remark",0); 
					frm.ap_duedate.value = ComGetMaskedValue(sheet1.GetCellValue(1, "ap_du_dt"), "ymd"); 
					ComEnableObject(frm.ap_remark,false);
					frm.ap_remark.className = "input2";
					ComEnableObject(frm.ap_duedate,false); 
					frm.ap_duedate.className = "input2";
					ComSetDisplay("btns_ap_dudate", false);
					//setOffstAmt();
					ComBtnDisable("btn_ar_search");
					ComBtnDisable("btn_ap_search");
					ComBtnDisable("btn_delete");   
				} else {
					var offstDt = frm.ar_offst_dt.value;
					var arOffstNo = frm.ar_offst_no.value;
					resetForm();
					ComBtnDisable("btn_reverse");
					ComBtnEnable("btn_save");   
					sheet1.SetEditable(1);
					frm.ar_offst_dt.value = offstDt;
					frm.ar_offst_no.value = arOffstNo;
					var selOfcInfo = combo1.GetSelectCode().split("^"); 
					if (typeof selOfcInfo.length != "undefined") {
						frm.offst_curr_cd.length = 0;
						ComAddComboItem(frm.offst_curr_cd, selOfcInfo[9],  selOfcInfo[9]);
						dpPrcsMap.put(selOfcInfo[9],selOfcInfo[10]); 
						if (frm.offst_curr_cd.value != 'USD') {				
							ComAddComboItem(frm.offst_curr_cd, "USD",  "USD");
							dpPrcsMap.put("USD",'2');
						}
						frm.offst_curr_cd.value = selOfcInfo[9];
						frm.offst_ofc_cd.value = selOfcInfo[0];
					}	
					ComEnableObject(frm.ap_remark,true);
					frm.ap_remark.className = "input";
					frm.ap_duedate.value = ComGetNowInfo("ymd"); 
					ComEnableObject(frm.ap_duedate,true);
					frm.ap_duedate.className = "input1";
					ComSetDisplay("btns_ap_dudate", true);
					ComBtnEnable("btn_ar_search");
					ComBtnEnable("btn_ap_search");
					ComBtnEnable("btn_delete");
				}
				ComOpenWait(false); 
			} , 100);	
		}
	// [open]
	} else if (sAction == INIT) {
		// set combo outstanding offfice code
		var otsSmryCd = "";
		var dpPrcsKnt = "2";
		
		{
			frm.f_cmd.value=SEARCH03;	
			
			var sXml=sheet1.GetSearchData("SARCommonGS.do", FormQueryString(frm));
			var strOtsOfcCd = ComGetEtcData(sXml,"ots_ofc_cd");
			
			if (!ComIsNull(strOtsOfcCd)) {
				var ofcList=strOtsOfcCd.split("|");				
				// -------------------------------------------------------------------------------------------------------------------
				// |OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd
				// |0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10 ^11
				// -------------------------------------------------------------------------------------------------------------------
				combo1.RemoveAll();
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo = ofcList[i].split("^");	
					combo1.InsertItem(i-1, ofcInfo[0], ofcList[i]);
					otsSmryCd = ofcInfo[3];  
				}				
				
				combo1.SetSelectText(strUsr_ofc_cd,0);
				frm.offst_ofc_cd.value = combo1.GetSelectText();
				
				if(otsSmryCd == 'BL'){
					otsSmryText = "B/L No";
				} else {
					otsSmryText = "Invoice No";
				}
			}
		}
		 
		var selOfcInfo=combo1.GetSelectCode().split("^");
		if (typeof selOfcInfo.length != "undefined") {
			frm.offst_curr_cd.length = 0;
			ComAddComboItem(frm.offst_curr_cd, selOfcInfo[9],  selOfcInfo[9]);
			dpPrcsMap.put(selOfcInfo[9],selOfcInfo[10]); 
			if (frm.offst_curr_cd.value != 'USD') {				
				ComAddComboItem(frm.offst_curr_cd, "USD",  "USD");
				dpPrcsMap.put("USD",'2'); 
			}
			frm.offst_curr_cd.value = selOfcInfo[9];
			frm.offst_ofc_cd.value = selOfcInfo[0];
			dpPrcsKnt = selOfcInfo[10];
		}	
		
		sheetObjects[0] = sheetObjects[0].Reset();  
		ComConfigSheet(sheetObjects[0]);
		initSheet(sheetObjects[0],1,otsSmryText,dpPrcsKnt);	
		ComEndConfigSheet(sheetObjects[0]);  
		
		// retrieve Local Time
		var lcl_time="";
		
		{		 
			frm.f_cmd.value=SEARCH07;
			var sXml=sheet1.GetSearchData("SARCommonGS.do", FormQueryString(frm));
			lcl_time=ComGetEtcData(sXml,"lcl_time");			
			frm.ar_offst_dt.value=ComGetMaskedValue(lcl_time, "ymd");
		}
		
		frm.ap_duedate.value = ComGetNowInfo("ymd");
		frm.ap_duedate.className = "input1"; 
		ComSetDisplay("btns_ap_dudate", true);
	// [save]
	} else if (sAction == MULTI) {		
		if (!sheet1.IsDataModified()) {
			// msgs['COM130503'] = 'There is no updated data to save.';
			ComShowCodeMessage("COM130503");
			return; 
		}	
		
		if (sheet1.FindText("offst_tp_cd", "AR") == -1) {
			// msgs['COM12113'] = 'Please select {?msg1}';
			ComShowCodeMessage("COM12113", "AR");
			return;
		} 
		
		if (sheet1.FindText("offst_tp_cd", "AP") == -1) {
			// msgs['COM12113'] = 'Please select {?msg1}';
			ComShowCodeMessage("COM12113", "AP");
			return;
		} 
		
		var offst_balance=frm.offst_balance.value;	
		if (ComIsNull(offst_balance) || parseFloat(offst_balance) !=0 ) {
			// msgs['SAR00021'] = 'The balance is not zero.';
			ComShowCodeMessage("SAR00021");
			return;
		}
		
		if(!ComChkObjValid(frm.ap_duedate)){
			return;
		}
		
		if (ComIsNull(frm.ap_duedate.value)){
			ComShowCodeMessage("COM12113", "AP DUEDATE");
			return;
		}
		
		// 저장하시겠습니까?
		// msgs['COM130101'] = 'Do you want to save {?msg1}?';
		if(!ComShowCodeConfirm("COM130101", "changes")) return;
		
		var sXml;
		sheet1.WaitImageVisible=false;
		ComOpenWait(true); 
		setTimeout( function () {
			//ap_du_dt,ap_remark setting 
			for(var j = 1; j <=  sheet1.RowCount(); j++) {
				sheet1.SetCellValue(j, "ap_remark",frm.ap_remark.value,0);
				sheet1.SetCellValue(j, "ap_du_dt",frm.ap_duedate.value,0);
			}
			
			frm.f_cmd.value=sAction;
			ComEnableObject(frm.offst_curr_cd,false); 
			var param = FormQueryString(frm);
			param += "&" + sheet1.GetSaveString(false, true, -1, "sheet1_");
			ComEnableObject(frm.offst_curr_cd,true); 
			sXml=sheet1.GetSaveData("STM_SAR_3002GS.do", param);
			SarOpenWait(false,true);
		} , 100);	
		
		setTimeout( function () {
			if(SarShowXmlMessage(sXml) != "") {
				ComShowMessage(SarShowXmlMessage(sXml));
			}
			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_reverse");
				frm.ar_offst_no.value=ComGetEtcData(sXml, "ar_offst_no");
				sheet1.SetEditable(0);
				setOffstAmt();
				doActionIBSheet(SEARCHLIST,true); 
			} 
		} , 110);	
	// [reverse]
	} else if (sAction == MODIFY) {		
		// change row status
		for(var i=1; i <= sheet1.RowCount(); i++) {
			sheet1.SetRowStatus(i,"U");
		}
		
		if (!sheet1.IsDataModified()) {
			// msgs['COM130503'] = 'There is no updated data to save.';
			ComShowCodeMessage("COM130503");
			return; 
		}
		
		var sheet_ar_offst_no=sheet1.GetCellValue(1, "ar_offst_no");
		var frm_ar_offst_no=frm.ar_offst_no.value;
		
		if (ComIsNull(sheet_ar_offst_no) || sheet_ar_offst_no != frm_ar_offst_no) {
			// msgs['COM12114'] = 'Please check {?msg1}';
			ComShowCodeMessage("COM12114", "Offset No");
			frm.ar_offst_no.focus();
			return;
		}
		
		// msgs['COM12154'] = 'Do you want to update {?msg1}?';
		if(!ComShowCodeConfirm("COM12154", "reverse data"))return;
		
		frm.f_cmd.value = sAction;		
		
		var sXml;
		sheet1.WaitImageVisible=false;
		ComOpenWait(true); 
		setTimeout( function () {
			var param = FormQueryString(frm);
			param += "&" + sheet1.GetSaveString(false , true, -1, "sheet1_");
			sXml = sheet1.GetSaveData("STM_SAR_3002GS.do", param);
			SarOpenWait(false,true);
		} , 100);
			
		setTimeout( function () {
			if(SarShowXmlMessage(sXml) != "") {
				ComShowMessage(SarShowXmlMessage(sXml));
			}
			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
				ComBtnDisable("btn_reverse");
				ComBtnDisable("btn_save");
				frm.ar_offst_no.value = ComGetEtcData(sXml, "ar_offst_no");
				sheet1.SetEditable(0);
				setOffstAmt();
				doActionIBSheet(SEARCHLIST,true);
			} 
		} , 110);	
	} 
}

function change_event_combo(){ 
	var formObject=document.form; 
	var curr_cd = formObject.offst_curr_cd.value;
	var dpPrcsKnt = dpPrcsMap.get(curr_cd);
		
	sheetObjects[0] = sheetObjects[0].Reset();  
	ComConfigSheet(sheetObjects[0]); 
	initSheet(sheetObjects[0],1,otsSmryText,dpPrcsKnt);	 
	ComEndConfigSheet(sheetObjects[0]);   
}

function resetForm(){
	frm.ar_offst_no.value = "";
	frm.ap_remark.value = "";
	frm.ap_duedate.value = "";
	frm.tot_ar_offst_amt.value = "";
	frm.tot_ap_offst_amt.value = "";
	frm.offst_balance.value = "";
	frm.ar_offst_dt.value = "";
	frm.gl_dt.value = "";
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0], 130);
}