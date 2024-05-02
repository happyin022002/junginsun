/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : stm_sar_0241.js
 *@FileTitle : [STM_SAR-0242] Offset AR Search Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.04.03
 *@LastModifier : jinyoonoh
 *@LastVersion : 1.0
 * 2014.04.03 jinyoonoh
 * 1.0 Creation
=========================================================*/
/**
 * [STM_SAR-0242] Offset AR Search Popup
 * @extends
 * @class Offset AR Search 
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// global variable
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
// html form
var frm = null;
var comboObjects=new Array();
var comboCnt=0;

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

// ===================================================================================
// initializing
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 **/
function loadPage() {
    //global variable set 
    frm=document.form;
    sheet1=sheetObjects[0];   
    sheetCnt=sheetObjects.length ;
    
    //sheet initialize
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

    
    //Form event register
    initControl();
    
    doActionIBSheet(IBSEARCH_ASYNC01);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	
	switch (sheetObj.id) {
		case "sheet1":
		    with(sheetObj){
				var HeadTitle1="||Office|Customer|Customer Name|B/L No|Chg Type|Currency|Amount" +
				      			"|offset_tp|vvd_cd|bil_to_cust_cnt_cd|bil_to_cust_seq|rhq_cd|ots_ofc_cd"+
				      			"|bl_no|inv_no|inv_amt|adj_amt|locl_xch_rt|usd_xch_rt|bal_locl_amt|bal_usd_amt"+
				      			"|pol_cd|pod_cd|svc_scp_cd|bkg_io_bnd_cd|xch_rt_dt|xch_rt_tp_cd|ar_xch_rt|ar_xch_amt|max_ar_if_no|gl_dt";
				var ots_smry_cd = frm.ots_smry_cd.value;
			    var headCount = ComCountHeadTitle(HeadTitle1);
		
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			    InitHeaders(headers, info);
		
			    var cols = [ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bil_to_cust_num",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bl_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",   	Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"bal_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"offst_tp_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bil_to_cust_cnt_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bil_to_cust_seq" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ots_ofc_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_amt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"adj_amt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"locl_xch_rt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usd_xch_rt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bal_locl_amt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bal_usd_amt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_io_bnd_cd" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"xch_rt_dt" },
			                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"xch_rt_tp_cd" },
			             	 {Type:"Float",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:7 },
			             	 {Type:"Float",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_xch_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			             	 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"max_ar_if_no" },
			             	 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"gl_dt" },
			             	 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_prcs_knt" }
			             	 ];
			    
			    if (ots_smry_cd == "INV") {
			    	SetCellValue(0, "bl_inv_no","Invoice No",0);
			    }
			    
			    InitColumns(cols);
		
			    SetEditable(1);
//			    SetSheetHeight(330);
			    resizeSheet();
	        }
		    
		break;
	}
}

// ===================================================================================
// Private function
// ===================================================================================
/**
 * handling process for input validation
 */
function validateForm() {
	return true;
}

/**
 * cal total invoice amount
 */
function getTotalAmountNCount() {
	var ret = [];
	
	var totalSum = 0.00;
	var checked = 0;
	ret[0] = checked;
	ret[1] = totalSum;
	
	for(var i=1; i <= sheet1.RowCount(); i++) {
		if (sheet1.GetCellValue(i, "checkbox") == 1) {
			totalSum += ComRound(ComReplaceStr(sheet1.GetCellValue(i, "bal_amt"),",",""), 2);
			checked++; 
		}
	}
	
	if (checked > 0) {
		ret[0] = checked;
		ret[1] = SarRound(totalSum,2);
	}
	
	return ret;
}

// ===================================================================================
// Form Event Processing
// ===================================================================================

// Button event handler
document.onclick = processButtonClick;

/**
 * Button event handler function
 */
function processButtonClick() {
	
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	var chkALL = frm.chkALL;
	var chkBRH = frm.chkBRH;
	var chkAGT = frm.chkAGT;
	switch (srcName) {
		case "btns_cust":
			var cust_cnt_cd = frm.bil_to_cust_cnt_cd.value;
			var cust_seq = frm.bil_to_cust_seq.value;					
			var classId = "STM_SAR_9003";
			var param = '?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;		
			//sUrl, iWidth, iHeight, sFunc, sDisplay, bModal,b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll
			ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 450, 'getSTM_SAR_9003', '0,0', true, false, null, null, null,"cust_popup");		
			break; 
		case "btn_pop_credit_cust": 
			var formObject=document.form; 
			if(formObject.bil_to_cust_cnt_cd.value != "" && formObject.bil_to_cust_seq.value != "") { 
				var param='?cust_cnt_cd='+formObject.bil_to_cust_cnt_cd.value+'&cust_seq='+formObject.bil_to_cust_seq.value+'&pop_yn=Y&ret_yn=Y';
				ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1300, 650, 'getPopData', '0,0', false, false, "", "", 0);
			}
			break; 		
		case "btn_searchlist":
			if (validateForm()) {
				doActionIBSheet(SEARCHLIST);
			}
			break;
			
		case "btn_OK":
			comPopupOK();
			break;
			
		case "btn_Close":
			ComClosePopup(); 
			break;
			
	}
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
    switch (event.srcElement.name) {    
	    case "bil_to_cust_seq":
	    	if (frm.bil_to_cust_cnt_cd.value != '' && frm.bil_to_cust_seq.value != '') {
	    		var valueCustSeq = frm.bil_to_cust_seq.value;
	    		frm.bil_to_cust_seq.value = ComLpad(valueCustSeq,6,"0");
	    		
	    		//Search customer info when input customer code
	    		doActionIBSheet(IBSEARCH_ASYNC02);
	    	} else {
	    		ComClearObject(frm.cust_lgl_eng_nm);
	    	}
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
    var eleName = event.srcElement.name;
    var keyValue = null;
    
    if(event == undefined || event == null) {
    	keyValue = 13;
    }else {
    	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    }
    
    if (keyValue == 13){
    	doActionIBSheet(SEARCHLIST);
    }
}

/** 
 * call method when select event on popup(FNS_INV_0086)<br>
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
	var colArray = rowArray[0];
	var frm = document.form;	
	//SarShowPopupData(rowArray);	
	frm.bil_to_cust_cnt_cd.value = colArray[8];
	frm.bil_to_cust_seq.value = ComLpad(colArray[9], 6, '0');
	frm.cust_lgl_eng_nm.value = colArray[4];	
}

//===================================================================================
//Sheet Event
//===================================================================================
/**
* sheet1 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value 
* 
*/
function sheet1_OnChange(sheet, row, col ,value) {
	if (sheet.ColSaveName(col) == "checkbox" || sheet.ColSaveName(col) == "bal_amt") {
		var ret = getTotalAmountNCount();
		frm.bl_count.value = ComGetMaskedValue(ret[0], "int");
		frm.total_amount.value = ComGetMaskedValue(ret[1], "float");
	}  	
}

//===================================================================================
//do Action Processing 
//===================================================================================
/**
 * Do action 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST) {	
		ComOpenWait(true);
	    setTimeout( function () {
	    	frm.f_cmd.value=SEARCHLIST;
	    	var sXml = sheet1.GetSearchData("STM_SAR_0241GS.do", FormQueryString(frm));
			sheet1.LoadSearchData(sXml,{Sync:1} );
			frm.bl_count.value = "";
			frm.total_amount.value = "";
		    ComOpenWait(false);  
	    } , 100);
	}else if (sAction == IBSEARCH_ASYNC02) {
		frm.f_cmd.value = SEARCH06;
		frm.cust_cnt_cd.value = frm.bil_to_cust_cnt_cd.value;
		frm.cust_seq.value = frm.bil_to_cust_seq.value;
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(frm));
		
		if(SarShowXmlMessage(sXml) != "") {
			ComShowMessage(SarShowXmlMessage(sXml));
			
			ComClearObject(frm.bil_to_cust_cnt_cd);
			ComClearObject(frm.bil_to_cust_seq);
			ComClearObject(frm.cust_lgl_eng_nm);
		
			frm.rct_cust_cnt_cd.focus();
		}else{
			frm.cust_lgl_eng_nm.value = ComGetEtcData(sXml,"cust_nm");
		}	
		ComOpenWait(false);  
	}else if (sAction == IBSEARCH_ASYNC01) {
		//retrieve Currency Code
		ComOpenWait(true);
		frm.f_cmd.value=SEARCH08;
		var sXml=sheetObjects[0].GetSearchData("SARCommonGS.do", FormQueryString(frm));
		var sCurrStr=ComGetEtcData(sXml,"curr_cd_list");
		var arrCurrStr=sCurrStr.split("|");
		MakeComboObject(bl_curr_cd, arrCurrStr);
		
		//retrieve MDM Charge List 	
		frm.f_cmd.value=SEARCH12;
		var sXmlChg=sheetObjects[0].GetSearchData("SARCommonGS.do", FormQueryString(frm));
		var sChgStr=ComGetEtcData(sXmlChg,"chg_list");
		var arrChgStr=sChgStr.split("|");
		MakeComboObject(chg_tp_cd, arrChgStr);
		ComOpenWait(false);  
	}
}

/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Park sung yong
 * @version 2014.03.24
 */
function MakeComboObject(cmbObj, arrStr) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");			 
	for (var i=1; i < arrStr.length; i++ ) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);			 
	}
	cmbObj.SetDropHeight(190);
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
 * Combo Setting default
 * @param	{IBMultiCombo}	combo_obj.
 * @param	{Number}	comboNo		Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
    var formObject=document.form
    	switch (comboObj.options.id) {
		   case "bl_curr_cd":
	           with (comboObj) {
			   	ValidChar(2);
		       }
           break;
		   case "chg_tp_cd":
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
function resizeSheet(){
    ComResizeSheet(sheetObjects[0], 50);
}