/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0110.js
*@FileTitle  : Bank Account Creation (Supplier Bank)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
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
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
    	    case "btn_new" :
    	    	form.reset();
				formObj.bank_acct_no.readOnly=false;
				formObj.bank_acct_no.className="input1";
				formObj.attr_ctnt7.value="99";
				ComSetObjValue(curr_cd, "");
    	    	break;
			case "btn_save":
				doActionIBSheet(sheetObject, formObj, MULTI);
				break;				
    	    case "btns_schBankAcctNo" :
    	    	ComOpenPopup("STM_SAP_0032.do?bank_acct_tp_nm=SUPPLIER", 500, 420, "setPopupData", "0,0", true);    	    	
    	    	break;				
			case "btns_inactDt":
				var cal=new ComCalendar();
				cal.select(formObj.inact_dt, 'yyyy-MM-dd');
				break;	
			case "btns_supplier":
				ComOpenPopup('STM_SAP_0002.do?delt_flg=N&vndr_seq='+formObj.bank_acct_vndr_seq.value, 900, 420, "setSupplier", "0,0", true, false);
				break;				
    	    case "btns_cntcAreaCd":  				
        	    var v_cnt_cd=form.cntc_area_cd.value;
        	    var classId="COM_ENS_0M1";
    		    var param='?cnt_cd='+v_cnt_cd+'&classId='+classId;
    		    var v_display="1,0,1,1,1,0,0";
    		    var chkStr=v_display.substring(0,3)
    		    if(chkStr == "1,0") {
    		    	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 700, 500, 'getCOM_ENS_0M1', v_display, true);
    		    } else {
    			    return;
    		    }	
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
	for (var i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); // combo
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
	/*axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    ,   formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   ,   formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
    axon_event.addListenerFormat('keypress'        , 'obj_keypress',   formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    axon_event.addListenerFormat('keyup'           , 'obj_keyup'   ,   formObj);
    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);*/
	//axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
	//axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);   //beforedeactivate   deactivate
	axon_event.addListenerFormat('focus', 'obj_activate', form);
    axon_event.addListener('change', 'bank_acct_vndr_seq_onchange', 'bank_acct_vndr_seq', '');
}
//handling Axon event 2
function obj_blur(){
}
/**
 *  Supplier Number / Name - OnChange
 */
function bank_acct_vndr_seq_onchange() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vndr_no=formObj.bank_acct_vndr_seq.value;
	document.form.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
}
function obj_keypress(){
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
		ComKeyOnlyAlphabet("num");
		break;     
	}	
}
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(ComGetEvent());        
} 
/**
 * HTML Control onfocus validate event <br>
 **/
function obj_deactivate(){
	ComAddSeparator(form.inact_dt, "ymd");
	ComChkObjValid(ComGetEvent());	
}
/**
 * Combo Setting default
 * @param	{IBMultiCombo}	combo_obj.
 * @param	{Number}	comboNo		Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
	var formObject=document.form
	switch (comboObj.options.id) {
	case "curr_cd":
           with (comboObj) {
		   	ValidChar(2);
	       }
       break;
	   default :
           with (comboObj) {
		   //ValidChar(2,0);
	       }
       break;
	}
    /*switch(comboObj.id) {
		   case "curr_cd":
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
		   default :
	           with (comboObj) {
			   //ValidChar(2,0);
		       }
           break;
     }*/
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
	    with(sheetObj){
		      var HeadTitle="";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [  ];       
		      //InitColumns(cols);
		      SetEditable(0);
		      SetWaitImageVisible(0);
		      SetVisible(false);
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
	    	// Currency Combo
	 		var currComboItems=SapGetCurrComboItems(sheetObj, "");
	 		SapAddComboItem(comboObjects[0], currComboItems, "1", " ", " ");
			break;
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
 			var sXml=sheetObj.GetSearchData("STM_SAP_0110GS.do", FormQueryString(formObj));
 			ComOpenWait(false);
			var arrXml=sXml.split("|$$|");
			if (sXml.length > 0) {	
				var list=SapXmlToListMap(arrXml[0]);
				if (list.length > 0) {
					formObj.bank_acct_no.readOnly=true;
					formObj.bank_acct_no.className="input2";
					formObj.bank_acct_no.value=list[0]["bank_acct_no"];
					formObj.bank_acct_nm.value=list[0]["bank_acct_nm"];
					formObj.bank_acct_vndr_seq.value=list[0]["bank_acct_vndr_seq"];
					formObj.vndr_lgl_eng_nm.value=list[0]["vndr_lgl_eng_nm"];
					formObj.inact_dt.value=list[0]["inact_dt"];
					formObj.attr_ctnt5.value=list[0]["attr_ctnt5"];
					formObj.attr_ctnt6.value=list[0]["attr_ctnt6"];
					formObj.iban_no.value=list[0]["iban_no"];
					formObj.attr_ctnt2.value=list[0]["attr_ctnt2"];
					formObj.cntc_area_cd.value=list[0]["cntc_area_cd"];
					formObj.cntc_area_nm.value=list[0]["cntc_area_nm"];
					// combo	
					ComSetObjValue(curr_cd, list[0]["curr_cd"]);
					if(list[0]["bank_acct_prio_cd"] == "Y") {
						formObj.bank_acct_prio_cd.checked=true;
					} else {
						formObj.bank_acct_prio_cd.checked=false;
					}
				} else {
					formObj.bank_acct_no.readOnly=false;
					formObj.bank_acct_no.className="input1";
					ComShowCodeMessage("COM130401");
				}
			}
			break;
		case MULTI: // save
			//msgs["SAP00017"] = "Do you want to approval {?msg1}?";
			if (ComShowCodeConfirm("SAP00017", "save?")) {
				formObj.f_cmd.value=MULTI;
				if (formObj.bank_acct_prio_cd.checked) {
					formObj.bank_acct_prio_cd.value="Y";
				} else {
					formObj.bank_acct_prio_cd.value="N";
				}
		    	ComOpenWait(true);	
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0110GS.do", FormQueryString(formObj));
		    		SapOpenWait(false,true); 
					if (SAPDecideErrXml(sheetObj, sXml)) {
						return;
					} else {
						formObj.sch_bank_acct_no.value=formObj.bank_acct_no.value;
						formObj.bank_acct_seq.value =  ComGetEtcData(sXml, "bank_acct_seq");
						
						ComShowCodeMessage("SAP00018");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	    		
		    	} , 100);
			}
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
			if(formObj.sch_bank_acct_no.value == ""){
				ComShowCodeMessage("COM12113", "Account Number");
				ComSetFocus(document.all.item("sch_bank_acct_no"));
				return false;
			}
			break;
		case MULTI: //Save
			if (!ComChkValid(formObj)) {
				return false;
			}
	        if(ComTrimAll(ComGetObjValue(curr_cd)).length == 0) {
	        	ComShowCodeMessage("SAP00010", "Currency");
	        	return false;
	        }
	        break;
	}
	return true;
}
/**
 * Setting supplier by popup
 */
function setSupplier(aryPopupData) {
	document.form.bank_acct_vndr_seq.value=aryPopupData[0][1];
	document.form.vndr_lgl_eng_nm.value=aryPopupData[0][2];
}
/**
 * Pop-Up Return Value 처리 부분<br>
 * @param aryPopupData
 */    
function setPopupData(aryPopupData) {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if (aryPopupData.length > 0 ) {
		formObj.sch_bank_acct_no.value=aryPopupData[0][1];
		formObj.bank_acct_seq.value = aryPopupData[0][5];		
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
}
/**
 * setting country data<br>
 * @author sangyoung cha
 * @param rowArray
 */
function getCOM_ENS_0M1(rowArray) {    	
	var colArray=rowArray[0];	
	document.all.cntc_area_cd.value=colArray[3];
	document.all.cntc_area_nm.value=colArray[4];    	
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
