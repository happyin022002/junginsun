/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2036.js
*@FileTitle  : Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_2036 : EES_CGM_2036 business script for
     */
    function EES_CGM_2036() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if (validateForm(sheetObject1, formObject, IBSEARCH) != false) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;
		case "btn_New":
			initControl();
			break;
		case "btns_Calendar1": // Agreement Date (To Date)
			if(cost_yrmon.GetSelectCode()== "cost_month")
    	  	{
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.inv_fm_date, "yyyy-MM");
    	  	}else
    	  	{
            	var cal=new ComCalendarFromTo();
            	cal.select(formObject.inv_fm_date,  formObject.inv_to_date,  'yyyy-MM-dd');
    	  	}
			break;
		case "btns_Calendar2": // Agreement Date (To Date)
			if(cost_yrmon.GetSelectCode()== "cost_month")
    	  	{
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.inv_to_date, "yyyy-MM");
    	  	}else
    	  	{
            	var cal=new ComCalendarFromTo();
            	cal.select(formObject.inv_fm_date,  formObject.inv_to_date,  'yyyy-MM-dd');
    	  	}			
			break;
		case "btns_office": // Office Code getting popup
			if (!formObject.cost_ofc_cd.readOnly) {
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 510,
						"ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
			}
			break;
		case "btns_vndr":
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, "callBackVendor",
					"1,0,1,1,1,1", true, false);
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * call back function. <br>
 * @param  {Array} aryPopupData	mandatory	 Array Object
 * @param  {Int} row				mandatoryselectedRow
 * @param  {Int} col				mandatoryselectedColumn
 * @param  {Int} sheetIdx			mandatory Sheet Index
 * @return 
 * @author 
 * @version
 */
function callBackVendor(aryPopupData, row, col, sheetIdx) {
	var formObj=document.form;
	var vndrSeq="";
	var vndrNm="";
	var i=0;
	for (i=0; i < aryPopupData.length; i++) {
		vndrSeq=vndrSeq + aryPopupData[i][2];
		vndrNm=vndrNm + aryPopupData[i][4];
		if (i < aryPopupData.length - 1) {
			vndrSeq=vndrSeq + ",";
			vndrNm=vndrNm + ",";
		}
	}
	formObj.vndr_seq.value=vndrSeq;
	formObj.vndr_nm.value=vndrNm;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		//
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// 
		ComEndConfigSheet(sheetObjects[i]);
	}
	//sheetObj.WaitImageVisible = false;
	// axon event regist
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	// axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListener('change', 'obj_change', 'cost_ofc_cd');
	axon_event.addListener('change', 'obj_change', 'inv_csr_no');
	// axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	axon_event.addListener('change', 'obj_change', 'vndr_seq');
//	axon_event.addListener('change', 'period_type_change', 'cost_yrmon');
	// Multi Combo reset
	comboObjects[comboCnt++]=cost_yrmon;
	comboObjects[comboCnt++]=inv_status;
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	// cost_yrmon value reset
	var arrActive=new Array();
	arrActive[0]="cost_month|Cost Month";
	arrActive[1]="issue_date|Issue Date";
	arrActive[2]="receive_date|Receive Date";
	arrActive[3]="confirm_date|Confirm Date";
	arrActive[4]="payment_date|Payment Date";
	makeComboObject(cost_yrmon, arrActive, 1, 0, 0);
	// INV_STATUS retrieve
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	initControl();
	//sheetObj.SetWaitImageVisible(1);
}
/**
 * sheet setting and init in case of load finish <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function sheet1_OnLoadFinish(sheetObj) {
	
}
/**
 * init control of form <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function initControl() {
	var formObj=document.form;
	var sheetObj1=sheetObjects[0];
	var sheetObj2=sheetObjects[1];
	// Form Object reset
	with (formObj) {
//		inv_fm_date.value = '200901'; //"";
//		inv_to_date.value = '200912';  //"";
//		cost_ofc_cd.value = 'SELPIO'; //formObj.ofc_cd.value;
//		cre_usr_id.value = '0360371'; //formObj.usr_id.value;
		inv_fm_date.value="";
		inv_to_date.value="";
		cost_ofc_cd.value=""; //formObj.ofc_cd.value;
		cre_usr_id.value=""; //formObj.usr_id.value;
		inv_csr_no_chk[0].checked=true;
		vndr_seq.value="";
		vndr_nm.value="";
	}
	// MultiCombo reset
	for ( var i=0; i < comboObjects.length; i++) {
		comboObjects[i].SetSelectText("",false);
	}
	// Sheet Object reset
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	// sheetObj.ColHidden("group1") = true;
	// init value setting
	comboObjects[0].SetSelectIndex(0);
	comboObjects[1].SetSelectIndex(0,false);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {

	        if (location.hostname != "")
	        var HeadTitle1="|Seq.|S.Provider|Invoice No.|CSR No.|Status|Cost Month|Rev Month|Net Amount|Tax DIV|Tax Rate(%)|Total Amount|Issue DT|Receive DT|Confirm DT|CRE User"
	        + "|pay_inv_seq";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        //(headCount, 5, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
	               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inv_sts_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rev_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"chg_smry_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_tax_clt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"inv_smry_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_cfm_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pay_inv_seq" } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetSheetHeight(172);//202;172
		}
		break;
	case "sheet2":
		with (sheetObj) {
	
	        if (location.hostname != "")
	        var HeadTitle1="|Seq.|Agreement No.|Term|Account|EQ No.|TP/SZ|Currency|CHG TP|Tax Rate(%)|Credit|Rental";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        //(headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
	               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pay_tax_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pay_cr_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pay_lse_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
//	        SetSheetHeight(220);//202;172
	        resizeSheet();
		}
		break;
	}
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[sheetObjects.length-1]);
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1")
			{
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				// Form Object value setting
		    	formObj.f_cmd.value=SEARCH;
		 		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
		 		// retrieve
		 		if(validateForm(sheetObj,formObj,sAction))
		 		{
			 		sheetObj.WaitImageVisible = false;
			 		ComOpenWait(true);
			 		var sXml=sheetObj.GetSearchData("EES_CGM_2036GS.do" , FormQueryString(formObj));
		 			sheetObj.LoadSearchData(sXml,{Sync:0} );
			 		ComOpenWait(false);
		 		}
			}
			else if (sheetObj.id == "sheet2")
			{
				sheetObjects[1].RemoveAll();
				// Form Object value setting
		    	formObj.f_cmd.value=SEARCH01;
		 		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
		 		// retrieve
		 		if(validateForm(sheetObj,formObj,sAction))
		 		{
			 		sheetObj.WaitImageVisible = false;
			 		ComOpenWait(true);
			 		var sXml=sheetObj.GetSearchData("EES_CGM_2036GS.do" , FormQueryString(formObj));
		 			sheetObj.LoadSearchData(sXml,{Sync:0} );
			 		ComOpenWait(false);
		 		}
			}
		break;
	case IBSEARCH_ASYNC03: // Option retrieve
		formObj.f_cmd.value=SEARCH;
		formObj.intg_cd_id.value=COM_CD_TYPE_CD02355;
		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj), '', true);
		var sStr=ComGetEtcData(sXml, "comboList");
		var arrStr=sStr.split("@");
		// combo control, result string, Text Index, Code Index
		MakeComboObjectAll(inv_status, arrStr, 1, 0);
		break;
	case IBSEARCH_ASYNC04:
		var ofcCd=formObj.ofc_cd.value;
		formObj.ofc_cd.value=formObj.cost_ofc_cd.value;
		formObj.f_cmd.value=COMMAND01;
		var sXml=sheetObj.GetSearchData("CgmValidationGS.do",
				FormQueryString(formObj), '', true);
		var sCheckResult=ComGetEtcData(sXml, "checkResult");
		if (sCheckResult == COM_VALIDATION_FALSE) {
			ComShowCodeMessage('CGM10009', 'Office');
			formObj.cost_ofc_cd.value="";
			formObj.cost_ofc_cd.focus();
		}
		formObj.ofc_cd.value=ofcCd;
		break;
 	case IBSEARCH_ASYNC05:	// Vendor Code,Name retrieve
		formObj.f_cmd.value=SEARCH07;
		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
		var text=ComCgmNullToBlank(ComGetEtcData(sXml,"text"));
		formObj.vndr_nm.value=text;
		break;			
	}
}
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			if (inv_fm_date.value == '') {
				ComShowCodeMessage('CGM10004', 'Period ');
				inv_fm_date.focus();
				return false;
			}
			if (inv_to_date.value == '') {
				ComShowCodeMessage('CGM10004', 'Period ');
				inv_to_date.focus();
				return false;
			}
			var dt_str=ComReplaceStr(document.form.inv_fm_date.value, "-", "");
			var dt_end=ComReplaceStr(document.form.inv_to_date.value, "-", "");
			if (dt_str != '' && dt_end != '') {
				if (dt_end < dt_str) {
					ComShowCodeMessage('COM12133', 'To date', 'From date',
							'greater');
					inv_fm_date.value='';
					inv_to_date.value='';
					inv_fm_date.focus();
					return false;
				}
			}
			/* 
			// Office check
			if (document.form.cost_ofc_cd.value == '') {
				ComShowCodeMessage('CGM10009', 'Invoice Office.');
				return false;
			}
			// Creation User ID check
			if (document.form.cre_usr_id.value == '') {
				ComShowCodeMessage('CGM10009', 'Creation User ID.');
				return false;
			}
			*/
			break;
		}
	}
	return true;
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) != "CHK")
		return; 
	var Col2=sheetObj.SaveNameCol("InvoiceNo");
	var sInvoiceNo=sheetObj.GetCellText(Row, Col2);
	var Row2=sheetObj.FindText(Col2, sInvoiceNo);
	while (Row2 > 0) {
		sheetObj.SetCellValue(Row2, Col,Value,0);
		Row2=sheetObj.FindText(Col2, sInvoiceNo, Row2 + 1);
	}
}
/** 
 * Object change event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function obj_change() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	obj=event.srcElement;
	switch(ComGetEvent("name")) {
	case "inv_csr_no":
		var invCsrNo=ComTrimAll(formObj.inv_csr_no.value);
		var arrInvCsrNo=invCsrNo.split(",");
		for ( var i=0; i < arrInvCsrNo.length; i++) {
			// 
			if (arrInvCsrNo[i] == '') {
				ComShowCodeMessage('CGM10009', 'Invoice No.');
				formObj.inv_csr_no.value="";
				ComSetFocus(formObj.inv_csr_no);
				break;
			}
		}
		break;
	case "cost_ofc_cd":
		if (formObj.cost_ofc_cd.value != '') {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
		}
		break;
	case "vndr_seq":
 		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
 		if(vndrSeq != ''){
	 		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
 		} else {
 			formObj.vndr_nm.value="";
 		}
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
function obj_activate() {
	ComClearSeparator(event.srcElement);
}
/** 
 * Object deactivate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function obj_deactivate() {
	var formObj=document.form;
	obj=event.srcElement;
	if (obj.name == "inv_fm_date") {
		with (formObj) {
			var creDtFr=ComReplaceStr(inv_fm_date.value, "-", "");
		}
		ComChkObjValid(event.srcElement);
	}
	if (obj.name == "inv_to_date") {
		with (formObj) {
			var creDtFr=ComReplaceStr(inv_to_date.value, "-", "");
		}
		ComChkObjValid(event.srcElement);
	}
}

/** 
 * Combo Object reset  <br>
 * @param  {object} comboObj	Combo Object
 * @return 
 * @author 
 * @version
 */
function initCombo(comboObj) {
	switch (comboObj) {
	case "cost_yrmon":
		var cnt=0;
		with (comboObj) {
			Code="";
			Text="";
			SetDropHeight(100);
			SetMultiSelect(0);
			SetMaxSelect(1);
//no support[check again]CLT 			UseCode=true;
			SetEnable(1);
		}
		break;
	case "inv_status":
		var cnt=0;
		with (comboObj) {
			Code="";
			Text="";
			SetBackColor("#FFFFFF");
			SetDropHeight(100);
			SetMultiSelect(0);
			SetMaxSelect(1);
//no support[check again]CLT 			UseCode=true;
			SetEnable(1);
		}
		break;
	}
}
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	cmbObj.RemoveAll();
	if (opt == 0) {
		for ( var i=0; i < arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
		}
	} else if (opt == 1) {
		cmbObj.InsertItem(0, "", "");
		for ( var i=0; i < arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i + 1, arrCode[txtCol], arrCode[codeCol]);
		}
	}
	cmbObj.SetSelectIndex("",false);
}
function MakeComboObjectAll(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "ALL|ALL", "ALL");
	for ( var i=0; i < arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		//cmbObj.InsertItem(i + 1, arrCode[txtCol], arrCode[codeCol]);
		cmbObj.InsertItem(i + 1, arrStr[i], arrCode[codeCol]);
	}
	//cmbObj.Index2 = "" ;
}
function MakeComboObject2(cmbObj, arrStr, col) {
	cmbObj.RemoveAll();
	for ( var i=0; i < arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		cmbObj.InsertItem(i, arrStr[i], arrCode[col]);
	}
	cmbObj.SetSelectIndex("",false);
}
function enterFire() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if (event.keyCode == 13) {
		if (validateForm(sheetObj, formObj, IBSEARCH)) {
			ComKeyEnter('search');
		}
	}
}
 function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH)
 {
	 var formObj=document.form;
	 if(sheetObj.GetCellValue(Row,"pay_inv_seq") != null 
			 && sheetObj.GetCellValue(Row,"pay_inv_seq") != '')
	 {
		 formObj.pay_inv_seq.value=sheetObj.GetCellValue(Row,"pay_inv_seq"); 
		 doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	 }
 }    
/** 
 * period_type change event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function cost_yrmon_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
//	alert("cost_yrmon_OnChange");
	var formObj=document.form;
	
//	formObj.cost_yrmon_text.value = comboObj.GetText(parseInt(newIndex), 0);

	var formObj=document.form;
	formObj.inv_fm_date.value="";
	formObj.inv_to_date.value="";
	
	if(cost_yrmon.GetSelectCode()== "cost_month") {
//		formObj.inv_fm_date.dataformat="ym";
//		formObj.inv_to_date.dataformat="ym";
//		formObj.inv_fm_date.maxlength="6";
//		formObj.inv_to_date.maxlength="6";
		formObj.inv_fm_date.setAttribute("dataformat","ym");
		formObj.inv_to_date.setAttribute("dataformat","ym");
	} else {
		//issue_date, receive_date, confirm_date, payment_date
//		formObj.inv_fm_date.dataformat="ymd";
//		formObj.inv_to_date.dataformat="ymd";
//		formObj.inv_fm_date.maxlength="8";
//		formObj.inv_to_date.maxlength="8";
		formObj.inv_fm_date.setAttribute("dataformat","ymd");
		formObj.inv_to_date.setAttribute("dataformat","ymd");
	}
	
//	alert(formObj.inv_fm_date.dataformat);
}
  
//function cost_yrmon_OnBlur() {
//	alert("cost_yrmon_OnBlur");
//	document.form.cost_yrmon_text.value = cost_yrmon.GetText(parseInt(cost_yrmon.GetSelectIndex()), 0);
//}
  
  function period_type_change(){
  	
  }    
	/* developer job end */
