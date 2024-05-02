/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0904.js
*@FileTitle  :   ESM_BKG_0904
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG_0904 : ESM_BKG_0904 - task script definition for screen
 */
function ESM_BKG_0904() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
    this.setComboObject=setComboObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initCombo=initCombo;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var check=true;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {	
			case "btn_TEST":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;	
			case "btn_EDI":
				doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
				break;	
			case "btn_Close":
				ComClosePopup(); 
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj; 
}
/**
 * Combo Object initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "form_code_opr":
            var i=0;
            with(comboObj) {
            	SetColBackColor(0,"#CCFFFD");
            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            }
            break;
        case "form_haul_mode":
            with(comboObj) {
            	SetColBackColor(0,"#CCFFFD");
            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            }
            break;
    }
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(i=0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}
	// combo create
	SetComboData(document.form.code_list.value);
	//Event needed for screen
//	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * process when you enter retrieve condition
 */
//function obj_KeyUp() {
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//		ComSetNextFocus();
//	}
//}
/**
 * setting sheet initial values and header param : sheetObj , sheetNo 
 adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
		case "sheet1":
		    with(sheetObj){
	      var HeadTitle="|bkgNo|codeOpr|termVvd|termPol|termPod|nykVvd|nykPol|nykPod|fwrdAgnCd|tmnlBrthCd|haulMode|tranMode";

	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"code_opr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"term_vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:18,   Align:"Center",  ColMerge:0,   SaveName:"term_pol",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"term_pod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"nyk_vvd" },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nyk_pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nyk_pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:18,   Align:"Center",  ColMerge:0,   SaveName:"fwrd_agn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tmnl_brth_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"haul_mode",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:18,   Align:"Center",  ColMerge:0,   SaveName:"tran_mode",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetVisible(false);
	      SetEditable(1);
        }
		break;
		case "sheet2":
		    with(sheetObj){
			//(5, 0, 0, true);
	      var HeadTitle="|Type/Size|Type/Size|QTY|Gross Weight";

	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_size",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(100);
	      SetEditable(1);
        }
		break;		
	}
}
/**
 * handling sheet process 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSEARCH: // retrieve
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;	
			var sXml=sheetObj.GetSearchData("ESM_BKG_0904GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			}
			//IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "form_");
			formObj.form_nyk_pod.value=sheetObj.GetEtcData("nyk_pod");
			formObj.form_nyk_pol.value=sheetObj.GetEtcData("nyk_pol");
			formObj.form_term_pod.value=sheetObj.GetEtcData("term_pod");
			formObj.form_tmnl_brth_cd.value=sheetObj.GetEtcData("tmnl_brth_cd");//?
			formObj.form_term_pol.value=sheetObj.GetEtcData("term_pol");
			formObj.form_nyk_vvd.value=sheetObj.GetEtcData("nyk_vvd");
			form_code_opr.SetSelectCode(sheetObj.GetEtcData("code_opr"));
			form_haul_mode.SetSelectCode(sheetObj.GetEtcData("haul_mode"));
			
			formObj.form_term_vvd.value = sheetObj.GetEtcData("term_vvd");
			formObj.form_fwrd_agn_cd.value = sheetObj.GetEtcData("fwrd_agn_cd");
			ComOpenWait(false);
			break;
		case IBSEARCH_ASYNC01:	// EDI
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var tempType="";
			var tempWGT="";
			//alert(sheetObjects[1].RowCount);
			for ( var i=1 ; i<sheetObjects[0].RowCount()+1 ; i++ )
			{
				//alert(sheetObjects[0].CellValue(i,"cntr_type"));
				tempType=tempType + sheetObjects[0].GetCellValue(i,"cntr_type")+"|";
				if ( sheetObjects[0].GetCellValue(i,"grs_wgt") == "" )
					tempWGT=tempWGT + "`"+"|";
				else
					tempWGT=tempWGT + sheetObjects[0].GetCellValue(i,"grs_wgt")+"|";
			}
			tempType=tempType.substring(0,tempType.length-1);
			tempWGT=tempWGT.substring(0,tempWGT.length-1);
			formObj.form_cntr_type.value=tempType;
			formObj.form_grs_wgt.value=tempWGT;		
			var sXml=sheetObj.GetSaveData("ESM_BKG_0904GS.do", FormQueryString(formObj));
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
			ComShowMessage(ComResultMessage(sXml));
			//formObj.output.value = ComGetEtcData(sXml, "flatFile");
			ComOpenWait(false); 
			if(State == "S")
			{
				var opener = window.dialogArguments;
				if (!opener) opener=window.opener;  //이 코드 추가할것
				if (!opener) opener=parent; //이 코드 추가할것
				opener.location.reload(true);
				ComClosePopup(); 
			}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		if(formObj.bkg_no.value != "" && formObj.pol_cd.value != ""){
			return true;
		}else{
			if(formObj.bkg_no.value == ""){
				ComShowCodeMessage('BKG00626', "Booking No.");
			}
			else if(formObj.pol_cd.value == ""){
				ComShowCodeMessage('BKG00626', "POL");
			}
			return false;
		}
		break;
	case IBSEARCH_ASYNC01:
		//alert(formObj.form_term_pol.value);
		if(formObj.form_term_pol.value == "" || formObj.form_term_pol.value.length != 5){
			ComShowCodeMessage('BKG00626', "Terminal POL");
//			formObj.form_term_pol.focus();
			return false;
		}
		//if(formObj.form_term_pod.value == "" || formObj.form_term_pod.value.length != 5){
		//	ComShowCodeMessage('BKG00626', "Terminal POD");
		//	formObj.form_term_pod.focus();
		//	return false;
		//}		
		return true;
		break;
	case COMMAND01:	
		return true;
		break;			
	}
}
/**
 * combo data create
 */
function SetComboData(sXml){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
    var arrXml=sXml.split("|$$|");
    var arrCombo;
	ComXml2ComboItem(arrXml[0], form_code_opr, "val", "name");
	ComXml2ComboItem(arrXml[1], form_haul_mode, "val", "name");
}
