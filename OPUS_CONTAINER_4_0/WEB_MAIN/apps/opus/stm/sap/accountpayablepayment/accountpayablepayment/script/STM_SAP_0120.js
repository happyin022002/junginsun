/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0120.js
*@FileTitle  : Bank Balance Adjustment
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
 * @class STM_SAP_0120 : business script for STM_SAP_0120
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
    	    case "btn_new" :
    	    	formObj.reset();
    	    	sheetObjects[0].RemoveAll();
				comboObjects[0].RemoveAll();
				comboObjects[1].RemoveAll();
				comboObjects[2].RemoveAll();
    	    	doActionIBSheet(sheetObject, formObj, COMMAND01);
    	    	break;				
			case "btn_recalculate":
				doActionIBSheet(sheetObject, formObj, MULTI);
				break;
			case "btn_bankAccountInquiry":
				var ofcCd=formObj.ofc_cd.value;
				if (ofcCd != "") {
					var paramVal="?ofc_cd=" + ofcCd;
					ComOpenPopup('STM_SAP_0100.do' + paramVal, 1200, 660, "", "1,0,1,1,1,1,1", false, "","","","","", "yes");		
					//ComOpenPopup("STM_SAP_0100.do" + paramVal, 1024, 720, "", "0,0", false,false);
				}
				break;
			case "btns_search_ofc":
				var  office_type="";
				if(formObj.ctrl_ofc[0].checked) {
					office_type=formObj.ctrl_ofc[0].value;
				} else if(formObj.ctrl_ofc[1].checked) {
					office_type=formObj.ctrl_ofc[1].value;
				} else {
					office_type=formObj.ctrl_ofc[2].value;
				}
				var param="?ofc_type=" + office_type + "&ofc_code="+formObj.ofc_cd.value;
				ComOpenPopup("STM_SAP_0500.do"+param, 700, 420, "setFiOffice", "0,0", true, false);
				break;	
			case "btns_calStmtDt":
				var cal=new ComCalendar();
				cal.select(form.bank_stmt_dt, 'yyyy-MM-dd');
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
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
	for (var k=0; k<comboObjects.length; k++) {
		initCombo(comboObjects[k],k+1);
	}
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); // OFC, DATE, COMBO Setting
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
//	axon_event.addListenerFormat('blur', 'obj_blur'    ,   formObj); 	//- handling code when OnBeforeDeactivate(blur) event
//	axon_event.addListenerFormat('blur'  , 'obj_focus'   ,   formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
//    axon_event.addListenerFormat('keypress'        , 'obj_keypress',   formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    axon_event.addListenerForm('keyup'           , 'obj_keyup'   ,   formObj);
    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
}
//handling Axon event 2
function obj_blur(){
}
function obj_keypress(){
	switch(event.srcElement.dataformat){
	case "engup":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum');
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
		ComKeyOnlyAlphabet("num");
		break;     
	}	
}
function obj_keyup(){
	var formObj=document.form;
	switch(event.srcElement.name){ 	    	
		case "inv_curr_cd_text":
		$("#inv_curr_cd_text").val($("#inv_curr_cd_text").val().toUpperCase());
			break;
	}
}
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(event.srcElement);        
} 
/**
 * HTML Control onfocus validate event <br>
 **/
function obj_deactivate(){
	switch (ComGetEvent("name")) {
	case "bank_stmt_dt":
		ComAddSeparator(document.form.bank_stmt_dt, "ymd");
		break;
	}
	ComChkObjValid(ComGetEvent());	
}
/**
 * Combo Setting default
 * @param	{IBMultiCombo}	combo_obj.
 * @param	{Number}	comboNo		Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
    switch(comboObj.options.id) {
		   case "inv_curr_cd":
				with (comboObj) {
		        	SetDropHeight(200);
		 			SetMultiSelect(0);
		 			SetUseAutoComplete(1);
		 			SetMaxSelect(1);
		 			//SetTitle("Code");
		 			SetColAlign(0, "left");
		 			SetColWidth(0, "70");
		 			//ValidChar(2,0);
				   }
	            break;
		   case "bank_acct_tp_mn_cd":
			   with (comboObj) {
	        	   SetDropHeight(200);
	 			   SetMultiSelect(0);
	 			   SetUseAutoComplete(1);
	 			   SetMaxSelect(1);
	        	   SetTitle("Code|Desc");
	        	   SetColAlign(0, "left");
	        	   SetColAlign(1, "left");
	        	   SetColWidth(0, "50");
	        	   SetColWidth(1, "120");
	        	   //ValidChar(2,0);
			   }
               break;
		   case "bank_acct_tp_sub_cd":
			   with (comboObj) {
	        	   SetDropHeight(200);
	 			   SetMultiSelect(0);
	 			   SetUseAutoComplete(1);
	 			   SetMaxSelect(1);
	        	   SetTitle("Code|Desc");
	        	   SetColAlign(0, "left");
	        	   SetColAlign(1, "left");
	        	   SetColWidth(0, "50");
	        	   SetColWidth(1, "120");
	        	   //ValidChar(2,0);
			   }
               break;
		   default :
	           with (comboObj) {
			   //ValidChar(2,0);
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
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
	        var HeadTitle1="|CHK|Bank Name|Bank Branch Name|Bank Account No|Bank Account Name|Currency|Before Adjustment|Before Adjustment|Before Adjustment|Input Adjustment|Input Adjustment|After Adjustment|After Adjustment|After Adjustment|Description|Account Type(L)|Account Type(M)|||||";
	        var HeadTitle2="||Bank Name|Bank Branch Name|Bank Account No|Bank Account Name|Currency|Beginning Balance|Deposit|Withdrawal|Deposit(Ad)|Withdrawal(Ad)|Deposit|Withdrawal|Balance|Description|Account Type(L)|Account Type(M)|||adj_chk|trx_chk";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        (headCount, 2, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 2 } );
	
	        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"},
	                    { Text:HeadTitle2, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"save_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_brnc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_acct_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_bgn_bal_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_ttl_rct_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_ttl_pay_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"receipt_amt_today",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
	               {Type:"Float",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"payment_amt_today",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
	               {Type:"Float",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"aft_ttl_rct_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"aft_ttl_pay_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"aft_endg_bal_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_stmt_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_tp_mn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_tp_sub_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_stmt_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_prcs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"adj_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"trx_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);
	        SetRangeBackColor(1, 0, 1, 14,"#555555");
	        SetEditable(1);
	        //SetSheetHeight(370);
	        resizeSheet();
		}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	if (!validateForm(sheetObj, formObj, sAction)) return;
	switch (sAction) {		
		case COMMAND01: // RETRIEVE AP OFFICE, AP OFFICE LOCAL CURRENTY
			formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
			formObj.lgin_usr_ap_ofc.value=SapGetLoginAPOfc(sheetObj);
			var localTime=SapGetLocDate(sheetObj);
			formObj.lgin_usr_locl_tm.value=ComGetMaskedValue(localTime, "ymd");
			formObj.bank_stmt_dt.value=ComGetMaskedValue(localTime, "ymd");
	    	// Currency Combo
	 		var currComboItems=SapGetCurrComboItems(sheetObj, "");
	 		SapAddComboItem(comboObjects[0], currComboItems, "1", " ", " "); 
	    	// Bank Account Type(L) Combo
	 		var bankTpLComboItems=SapGetComboItems(sheetObj, "BANK ACCOUNT TYPE(L)", "");
	 		SapAddComboItem(comboObjects[1], bankTpLComboItems, "2", " ", " "); 
	    	// Bank Account Type(M) Combo
	 		var bankTpMComboItems=SapGetComboItems(sheetObj, "BANK ACCOUNT TYPE(M)", "");
	 		SapAddComboItem(comboObjects[2], bankTpMComboItems, "2", " ", " "); 
	 		break;
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("STM_SAP_0120GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case MULTI: // Recalculate
			//msgs["SAP00017"] = "Do you want to approval {?msg1}?";
			if (ComShowCodeConfirm("SAP00017", "recalculate?")) {
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObj, true, true);
		    	//if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	sParam = sParam.replace(/\%2C/gi, "");
		    	ComOpenWait(true);
		    	setTimeout( function () {   
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0120GS.do", sParam);
		    		SapOpenWait(false,true); 
					if (SAPDecideErrXmlSave(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SAP00018");
					}
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != undefined && ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "F" ) {
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
		    	} , 100);		    	
			}
		    break;			
	}
}
/**
 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 조회 후 메시지
 */	
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
    var point="";
    // calculation 
    var calcDeposit="";
    var calcWithdrawal="";
    var calcBalance="";
    if (sheetObj.RowCount()> 0 ) {
		for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++) {
			point=sheetObj.GetCellValue(i, prefix + "inv_curr_prcs");
			calcDeposit=sheetObj.GetCellProperty(i, prefix + "aft_ttl_rct_amt",  dpCalcuLogic);
			calcWithdrawal=sheetObj.GetCellProperty(i, prefix + "aft_ttl_pay_amt",  dpCalcuLogic);
			calcBalance=sheetObj.GetCellProperty(i, prefix + "aft_endg_bal_amt", dpCalcuLogic);
			if(point == "0" || point == undefined || point == "") {
				sheetObj.InitColumns(i, prefix + "ctrl_bgn_bal_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "ctrl_ttl_rct_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "ctrl_ttl_pay_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "receipt_amt_today",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "payment_amt_today",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "aft_ttl_rct_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "aft_ttl_pay_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
				sheetObj.InitColumns(i, prefix + "aft_endg_bal_amt",{ Type:"Data",Align:"Right",Format:"NullInteger"} );
			} else {
				sheetObj.InitColumns(i, prefix + "ctrl_bgn_bal_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "ctrl_ttl_rct_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "ctrl_ttl_pay_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "receipt_amt_today",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "payment_amt_today",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "aft_ttl_rct_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "aft_ttl_pay_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
				sheetObj.InitColumns(i, prefix + "aft_endg_bal_amt",{ Type:"Data",Align:"Right",Format:"NullFloat",PointCount:point} );
			}
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
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Value == "") return;
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	var formObj=document.form;
    with (sheetObj) {
        switch (ColSaveName(Col)) {
        	case prefix + "receipt_amt_today": 
        		if (GetCellValue(Row,Col) < 0) {
        			ComShowCodeMessage("COM132201", "Adjustment amount");
        			SetCellValue(Row, Col,"");
        			SelectCell(Row, Col);
        		}
            	break;
        	case prefix + "payment_amt_today":
        		if (GetCellValue(Row,Col) < 0) {
        			ComShowCodeMessage("COM132201", "Adjustment amount");
        			SetCellValue(Row, Col,"");
        			SelectCell(Row, Col);
        		}
            	break; 
        }
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
			if(formObj.bank_stmt_dt.value == ""){
				ComShowCodeMessage("COM12113", "By Date");
				ComSetFocus(document.all.item("bank_stmt_dt"));
				return false;
			}
			break;
		case MULTI: //Recalculate			
			if (sheetObj.SearchRows()== 0  ) {
				ComShowCodeMessage("SAP00036");
				return false;
			} else {
				var chkRows=sheetObj.CheckedRows("sheet1_save_chk");
				if ( chkRows < 1  ) {
					ComShowCodeMessage("SAP00010" , " data to recalculate");
					return false;
				}
			}
			break;
	}
	return true;
}
/**
 * Finance Office Code - return data from popup
 */
function setFiOffice(aryPopupData) {
	var formObj=document.form;
	if(aryPopupData[0][1] == "AP"){
		formObj.ctrl_ofc[0].checked=true;
		formObj.ofc_cd.value=aryPopupData[0][2];
	}else if(aryPopupData[0][1] == "AR"){
		formObj.ctrl_ofc[1].checked=true;
		formObj.ofc_cd.value=aryPopupData[0][2];
	}
}
/**
 *  bank account type(L) - OnChange
 */
function bank_acct_tp_mn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
	if (code != null && code != "") {
		formObj.bank_acct_tp_mn_cd.value=comboObj.GetText(code, 0);
		formObj.bank_acct_tp_mn_desc.value=comboObj.GetText(code, 1);
	}
}
/**
 *  bank account type(M) - OnChange
 */
function bank_acct_tp_sub_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
	if (code != null && code != "") {
		formObj.bank_acct_tp_sub_cd.value=comboObj.GetText(code, 0);
		formObj.bank_acct_tp_sub_desc.value=comboObj.GetText(code, 1);
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

