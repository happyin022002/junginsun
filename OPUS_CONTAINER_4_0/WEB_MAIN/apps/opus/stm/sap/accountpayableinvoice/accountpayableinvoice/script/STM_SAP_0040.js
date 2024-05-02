/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0040.js
*@FileTitle  : CSR Receipt Entry
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
 * @class STM_SAP_0040 : business script for STM_SAP_0040
 */

// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var ASAMsg="N";
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
				//sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
    	    case "btn_new" :
    	    	formObj.reset();
    	    	sheetObjects[0].RemoveAll();
    	    	doActionIBSheet(sheetObject, formObj, COMMAND01);
    	    	break;
			case "btn_save":
				doActionIBSheet(sheetObject, formObj, MULTI);
				break;				
			case "btn_confirm":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;		
			case "btn_release":
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;		
			case "btn_reject":
				doActionIBSheet(sheetObject, formObj, MULTI03);
				break;				
			case "btns_cal_invDtFm":
				var cal=new ComCalendar();
				cal.select(formObj.inv_dt_fm, 'yyyy-MM-dd');
				break;	
			case "btns_cal_invDtTo":
				var cal=new ComCalendar();
				cal.select(formObj.inv_dt_to, 'yyyy-MM-dd');
				break;
			case "btns_cal_glDtFm":
				var cal=new ComCalendar();
				cal.select(formObj.gl_dt_fm, 'yyyy-MM-dd');
				break;
			case "btns_cal_glDtTo":
				var cal=new ComCalendar();
				cal.select(formObj.gl_dt_to, 'yyyy-MM-dd');
				break;
			case "btns_ofc":
				ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+formObj.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
				break;				
			case "btns_apPayGrpLuCd":
				var param="?lu_cd=" + formObj.ap_pay_grp_lu_cd.value+"&attr_ctnt1=" + formObj.ofc_cd.value;
				ComOpenPopup("STM_SAP_0004.do"+param, 400, 420, "setPayGroup", "0,0", true, false);
				break;
			case "btns_supplier":
				//ComOpenPopupWithTarget('STM_SAP_0002.do?vndr_seq='+formObj.vndr_no.value, 900, 400,"vndr_lgl_eng_nm:vndr_lgl_eng_nm|vndr_seq:vndr_no", "0,0", true);
				ComOpenPopup('STM_SAP_0002.do?vndr_seq='+formObj.vndr_no.value, 900, 420, "setSupplier", "0,0", true, false);
				break;
			case "btns_csr":
				ComOpenPopupWithTarget('STM_SAP_0003.do?inv_no='+formObj.inv_no.value+"&ofc_cd=" + document.form.ofc_cd.value+"&inv_flg=A", 480, 550,"inv_no:inv_no", "0,0", true);
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
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); // OFC, DATE Setting
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
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    ,   formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   ,   formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
    //axon_event.addListenerFormat('keypress'        , 'obj_keypress',   formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    //axon_event.addListenerFormat('keyup'           , 'obj_keyup'   ,   formObj);
    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
    axon_event.addListenerForm ('change', 'obj_onchange', formObj);
    //axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');
}
//handling Axon event 2
function obj_blur(){
}
function obj_keypress(){
	switch(ComGetEvent("dataformat")){
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
function obj_keyup(){
	var formObj=document.form;
	switch (ComGetEvent("name")) {
	case "ofc_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}//end of switch
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
	ComChkObjValid(ComGetEvent());
	  var obj=ComGetEvent();
	     var formObj=document.form;
	  switch(ComGetEvent("name")){       
	      case "inv_dt_fm":
	       ComAddSeparator(obj, "ymd");
	       break;
	      case "gl_dt_fm":
	       ComAddSeparator(obj, "ymd");
	       break;
	      case "inv_dt_to":
		       ComAddSeparator(obj, "ymd");
		       break;
	      case "gl_dt_to":
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
		case "vndr_no":
			var vndr_no=formObj.vndr_no.value;
			formObj.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
	    	break;

		case "ofc_cd":
			var office_code=formObj.ofc_cd.value;
			formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
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
			var HeadTitle1="||Office|CSR No|Supplier No|Supplier Name|Curr|Invoice Amount|Description|Pay Group|Due Date|Payment Method|Terms|Inv Date|CSR Receipt No|Cre Date|Bank|Bank Branch|Bank Account|||";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"checkbox",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:135,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ap_pay_grp_lu_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
			             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_term_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_rct_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_brnc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pay_sts_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"gl_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"ap_inv_src_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			InitColumns(cols);
			//SetSheetHeight(410);
			SetEditable(1);
			SetImageList(0,"img/btns_calendar.gif");
			SetColProperty(prefix+"due_dt", {Format:"Ymd"} );
			SetColProperty(prefix+"inv_dt", {Format:"Ymd"} );
			SetColProperty(prefix+"cre_dt", {Format:"Ymd"} );
			
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
			var localStartTime=localTime.substr(0,6) + "01";
			formObj.lgin_usr_locl_tm.value=ComGetMaskedValue(localTime, "ymd");
			formObj.inv_dt_fm.value=ComGetMaskedValue(localStartTime, "ymd");
			formObj.inv_dt_to.value=ComGetMaskedValue(localTime, "ymd");		
			//Button disable
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_confirm");
			ComBtnDisable("btn_release");
			ComBtnDisable("btn_reject");
			break;
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			setTimeout(function(){
	 			var sXml=sheetObj.GetSearchData("STM_SAP_0040GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
			},100);
			break;
		case MULTI: // save
			//msgs["SAP00017"] = "Do you want to approval {?msg1}?";
			if (ComShowCodeConfirm("SAP00017", "save?")) {
				formObj.f_cmd.value=MULTI;
				for(var i=1;i<=sheetObj.RowCount();i++){
					var prefix=sheetObj.id + "_";
					var str = sheetObj.GetCellValue(i,prefix+"due_dt");
					var str2 = sheetObj.GetCellValue(i,prefix+"inv_dt");
					var str3 = sheetObj.GetCellValue(i,prefix+"cre_dt");
					str = str.substring(0,10);
					str = str.replace("-","");
					str2 = str2.substring(0,10);
					str2 = str2.replace("-","");
					str3 = str3.substring(0,10);
					str3 = str3.replace("-","");
					sheetObj.SetCellValue(i,prefix+"due_dt",str);
					sheetObj.SetCellValue(i,prefix+"inv_dt",str2);
					sheetObj.SetCellValue(i,prefix+"cre_dt",str3);
				}
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0040GS.do", sParam);
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
		case MULTI01: // Confirm
			//msgs["SAP00017"] = "Do you want to approval {?msg1}?";
			if (ComShowCodeConfirm("SAP00017", "confirm?")) {
				formObj.f_cmd.value=MULTI01;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0040GS.do", sParam);
		    		SapOpenWait(false,true);
					if (SAPDecideErrXml(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SAP00018");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    	} , 100);
 				
			}
		    break;
		case MULTI02: // Release
			if (ComShowCodeConfirm("SAP00017", "release?")) { 
				formObj.f_cmd.value=MULTI02;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0040GS.do", sParam);
		    		SapOpenWait(false,true);
					if (SAPDecideErrXml(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SAP00018");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);		   
		    	} , 100);
 						    
			}
			 break;
		case MULTI03: // Reject
			if (ASAMsg == "N") {
				if (ComShowCodeConfirm("SAP00017", "reject?")) { 
					formObj.f_cmd.value=MULTI03;
					var sParam=ComGetSaveString(sheetObj);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);
			    	ComOpenWait(true);
			    	setTimeout( function () {
			    		var sXml=sheetObj.GetSaveData("STM_SAP_0040GS.do", sParam);
			    		SapOpenWait(false,true);
						if (SAPDecideErrXml(sheetObj, sXml)) {
							return;
						} else {
							ComShowCodeMessage("SAP00018");
						}
						doActionIBSheet(sheetObj, formObj, IBSEARCH);		   		    
			    	} , 100);
				}
			} else {
				formObj.f_cmd.value=MULTI03;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0040GS.do", sParam);
		    		SapOpenWait(false,true);
					if (SAPDecideErrXml(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SAP00018");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);		   		    
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
	// button control
	if (sheetObj.RowCount()> 0 ) {
		if (formObj.rct_flg[0].checked) {
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_confirm");
			ComBtnDisable("btn_release");
			ComBtnEnable("btn_reject");
		} else {
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_confirm");
			ComBtnEnable("btn_release");
			ComBtnDisable("btn_reject");
		}
	} else {		
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_release");
		ComBtnDisable("btn_reject");
	}
	// PAY_STS_FLG = "Y" : Enable	
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	var payStsFlg="";
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++) {
		payStsFlg=sheetObj.GetCellValue(i, prefix + "pay_sts_flg");
		if(payStsFlg == "Y") {
			if (formObj.rct_flg[0].checked) {
				sheetObj.SetRowEditable(i,1);
				sheetObj.SetCellEditable(i, prefix + "ap_pay_grp_lu_cd",0);
				sheetObj.SetCellEditable(i, prefix + "due_dt",0);
				sheetObj.SetCellEditable(i, prefix + "pay_mzd_lu_cd",0);
				sheetObj.SetCellEditable(i, prefix + "inv_term_nm",0);
			} else { 
				sheetObj.SetRowEditable(i,0);
			}
		} else {
			if (formObj.rct_flg[1].checked) {
				sheetObj.SetCellEditable(i, prefix + "ap_pay_grp_lu_cd",0);
				sheetObj.SetCellEditable(i, prefix + "due_dt",0);
				sheetObj.SetCellEditable(i, prefix + "pay_mzd_lu_cd",0);
				sheetObj.SetCellEditable(i, prefix + "inv_term_nm",0);
			} else {
				sheetObj.SetRowEditable(i,1);
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
        	case prefix + "ap_pay_grp_lu_cd":    // Pay Group
        		var param="&lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&attr_ctnt1=" + sheetObj.GetCellValue(Row, prefix + "ofc_cd");
             	var sXml2=sheetObj.GetSearchData("STM_SAP_0004GS.do", "f_cmd=" + SEARCH + param);
            	if (SAPDecideErrXml(sheetObj, sXml2)) {
    				return;
    			} else {      
    				if (Value != ComGetEtcData(sXml2, "lu_cd")) {        					
    					ComShowCodeMessage("COM132201", "Pay Group" );   
    					SetCellValue(Row, Col, "");
               		 	SelectCell(Row, Col, true, "");
    					return false;					
    				} 
    			} 
            	break;
        	case prefix + "pay_mzd_lu_cd":    // Payment Method
        		var chkVal=chkLookupOneData(sheetObj, "&lu_tp_cd=PAYMENT METHOD&lu_cd="+Value);
        		if ( chkVal != Value ) {
            		ComShowCodeMessage("COM132201", "Payment Method" );
            		SetCellValue(Row, Col, "");
            		SelectCell(Row, Col, true, "");
 					return false;		
            	}
        		break;  
        	case prefix + "inv_term_nm":    // Terms
        		var chkVal=chkLookupOneData(sheetObj, "&lu_tp_cd=AP TERMS&lu_cd="+Value);
        		if ( chkVal != Value ) {
            		ComShowCodeMessage("COM132201", "Terms" ); 
            		SetCellValue(Row, Col, "");
            		SelectCell(Row, Col, true, "");
 					return false;		
            	}
        		break;   
        }
    }
}
/**
 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 */	
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	var param="";
	with (sheetObj) {
        switch (ColSaveName(Col)) {
            case  prefix + "ap_pay_grp_lu_cd":    //Pay Group
            	var param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&attr_ctnt1=" + sheetObj.GetCellValue(Row, prefix + "ofc_cd");
            	ComOpenPopup("STM_SAP_0004.do" + param, 400, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
            	break;
            case  prefix + "pay_mzd_lu_cd":    //Payment Method
            	param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col));
            	ComOpenPopup("STM_SAP_0007.do" + param, 500, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
            	break;
            case  prefix + "inv_term_nm":    //Terms
            	var param="?f_term=" + sheetObj.GetCellValue(Row, Col);
            	ComOpenPopup("STM_SAP_0033.do" + param, 450, 540, "setPopupData", "0,0", true, false, Row, Col, 0);
            	break;
            case  prefix + "due_dt":    //Due Date
    		    var cal=new ComCalendarGrid();
    		    cal.select(sheetObj, Row, Col, 'yyyyMMdd');
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
			if(formObj.inv_dt_fm.value == ""){
				ComShowCodeMessage("COM12113", "By Date");
				ComSetFocus(document.all.item("inv_dt_fm"));
				return false;
			}
			if(formObj.inv_dt_to.value == ""){
				ComShowCodeMessage("COM12113", "By Date");
				ComSetFocus(document.all.item("inv_dt_to"));
				return false;
			}
			if(formObj.gl_dt_fm.value != ""){
				if(formObj.gl_dt_to.value == ""){
					ComShowCodeMessage("COM12113", "By Date");
					ComSetFocus(document.all.item("gl_dt_to"));
					return false;
				}				
			}
			if(formObj.gl_dt_to.value != ""){
				if(formObj.gl_dt_fm.value == ""){
					ComShowCodeMessage("COM12113", "By Date");
					ComSetFocus(document.all.item("gl_dt_fm"));
					return false;
				}	
			}
			break;
		case MULTI: //Save
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			} else {
				var prefix=sheetObj.id + "_";
				for(k=1; k <= sheetObj.SearchRows(); k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						var payStsFlg=sheetObj.GetCellValue(k, prefix + "pay_sts_flg");
						if (payStsFlg == "Y" ) {
							ComShowCodeMessage("SAP00049",sheetObj.GetCellValue(k, prefix + "inv_no"), "save" );
							return false;
						}
					}
				}	
			}
			break;
		case MULTI01: //Confirm
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			}
			break;
		case MULTI02: //Release
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			}
			break;
		case MULTI03: //Reject
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			} else {
				var prefix=sheetObj.id + "_";
				for(k=1; k <= sheetObj.RowCount(); k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						var srcCd = sheetObj.GetCellValue(k, prefix + "ap_inv_src_cd");
						if (srcCd == "AR" ) {
							ComShowCodeMessage("SAP00071");
							return false;
						}
						
						var payStsFlg=sheetObj.GetCellValue(k, prefix + "pay_sts_flg");
						if (payStsFlg == "Y" ) {
							ComShowCodeMessage("SAP00049",sheetObj.GetCellValue(k, prefix + "inv_no"), "reject");
							return false;
						}
						
						var inv_seq = sheetObj.GetCellValue(k, prefix + "inv_seq");
						var inv_no = sheetObj.GetCellValue(k, prefix + "inv_no");
				        var sXml = sheetObj.GetSearchData("STM_SAP_0040GS.do", "f_cmd=" + COMMAND01 + "&value0=" + inv_seq);
						
						if (SAPDecideErrXml(sheetObj, sXml)) {
							
				        } else {	
				        	if(ComGetEtcData(sXml, "value0") != "Y") { // ASA Close 상태
				        		if (ComShowCodeConfirm("SAP00084", "[" + inv_no + "]")) {
				        			ASAMsg="Y";
				        			return true;
				        		} else {
				        			ASAMsg="N";
				        			return false;
				        		}
				        		//ComShowCodeMessage("SAP00064", "[" + inv_no + "]" ); 		        		
				        	} else {
				        		ASAMsg="N";
				        	}		        	
				        }
					}
				}	
			}
			break;		
	}
	return true;
}
/**
 * initialize vendor name
 */ 
/*function vndr_no_onchange() {
	//document.form.vndr_lgl_eng_nm.value = "";
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vndr_no=formObj.vndr_no.value;
	if(vndr_no==""){
		vndr_no="-1";
	}
	document.form.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
}*/
/**
 * Setting supplier by popup
 */
function setSupplier(aryPopupData) {
	document.form.vndr_no.value=aryPopupData[0][1];
	document.form.vndr_lgl_eng_nm.value=aryPopupData[0][2];
}
/**
 * Setting pay group by popup
 */    
function setPayGroup(aryPopupData) {
	document.form.ap_pay_grp_lu_cd.value=aryPopupData[0][1];
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
                default:
                    SetCellValue(Row, Col,aryPopupData[0][1]);
                    break;
            }
        }
    }
}
/**
 * chkLookupOneData 처리 부분<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {param}
 */
function chkLookupOneData(sheetObj, param) {
	if( ComTrim(param) == "") return "";
 	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + param);
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
    } else {
    	if ( ComGetEtcData(sXml, "one_lu_cd") == "NO_DATA" ) {
    		return "";
    	} else {
    		return ComGetEtcData(sXml, "one_lu_cd");
    	}        	
    } 
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

