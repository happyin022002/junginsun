/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0556.js
*@FileTitle : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/

/****************************************************************************************
  	Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
function ESM_BKG_0556() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
var rdObjects=new Array();
var rdCnt=0;
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list
 *  adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBTab Object as list
 *  adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing tab
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "청구서", "");
			InsertItem( "수정", "");
		}
		break
	}
}
/**
 * in case of Tab click
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	beforetab=nItem;
	// tab Index begin 0 
	// update modified contents in case of first tab = "청구서" 
	if (nItem == 0) {
		doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	// create TAB 
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	// create IBSHEET
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	rdOpen(rdObjects[0], document.form, sheetObjects[0], "");
	initControl();
}
function initControl() {
	var formObject=document.form;
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComSetFocus(formObject.whf_ntc_dt1);
}
/**
 * processing when input search conditions
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
// handling process for sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0556GS.do", FormQueryString(formObj ) + "&" + ComGetPrefixParam("sheet1_"));
		}
		break;
	case IBSAVE: 
		var StringBuffer=function() {
			this.buffer=new Array();
		}
		StringBuffer.prototype.append=function(str) {
			this.buffer.push(str);
			return this;
		}
		StringBuffer.prototype.toString=function() {
			return this.buffer.join("");
		}
		var s=new StringBuffer();
		s.append("/rdata [");
		for ( var i=0; i < sheetObjects[0].RowCount(); i++) {
			if(sheetObjects[0].GetRowStatus(i+1) == "D") continue;
			s.append(sheetObjects[0].GetCellValue(i + 1, 2)).append("^").append(
					sheetObj.GetCellValue(i + 1, 3)).append("^").append(
					sheetObj.GetCellValue(i + 1, 5)).append("^").append(
					sheetObj.GetCellValue(i + 1, 6)).append("^").append(
					sheetObj.GetCellValue(i + 1, 7)).append("^").append(
					sheetObj.GetCellValue(i + 1, 8)).append("^").append(
					sheetObj.GetCellValue(i + 1, 9)).append("^").append(
					sheetObj.GetCellValue(i + 1, 10)).append("^").append(
					sheetObj.GetCellValue(i + 1, 11)).append("^").append(
					sheetObj.GetCellValue(i + 1, 12)).append("^").append(
					sheetObj.GetCellValue(i + 1, 15)).append("^").append(
					sheetObj.GetCellValue(i + 1, 16)).append("^").append(
					sheetObj.GetCellValue(i + 1, 17)).append("^").append(
					formObj.demand_month.value).append("^").append(
					formObj.calculate_month.value).append("^").append(
					formObj.represent.value).append("^").append(
					formObj.phone_num.value).append("^").append("~");
		}
		s.append("] /rnl [~]");
		s.append(" /rv b14[" + formObj.demand_month.value + "] "); 
		s.append("b15[" + formObj.calculate_month.value + "] "); 
		s.append("b16[" + formObj.phone_num.value + "] "); 
		s.append("b17[" + formObj.represent.value + "] "); 
		var Rdviewer=rdObjects[0];
		var xmldata="<?xml version=\"1.0\" encoding=\"euc-kr\"?><root><startdate>20080101</startdate><enddate>20081231</enddate><today>20090113</today><table1>	<a>		<a1>100 </a1>		<a2> 200</a2>		<a3>300 </a3>		<a4>400 </a4>		<a5>500 </a5>	</a></table1></root>";
		var mrdpath=RD_path + "apps/opus/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0556_2.mrd";
		Rdviewer.AutoAdjust=2;
		Rdviewer.ViewShowMode(0);
		Rdviewer.SetBackgroundColor(128, 128, 128);
		Rdviewer.SetPageLineColor(128, 128, 128);
		Rdviewer.ApplyLicense("0.0.0.0"); // new add
		Rdviewer.SetNoDataDialogInfo(0, "", ""); // hide no data message 
		Rdviewer.FileOpen(mrdpath, s.toString());
		
		break;
	case IBDELETE: 
		var checked=0;
		for ( var i=sheetObj.RowCount(); i > 0; i--) {
			if (sheetObj.GetCellValue(i, 1) == '1') {
				checked=1;	
				sheetObj.RowDelete(i,false);
			}
		}
		if (checked == 0)
			ComShowCodeMessage('BKG00249');
		sheetObj.ReNumberSeq();
		break;
	case IBDOWNEXCEL: // in processButtonClick()
		break;
	}
}
/*
 * Report 호출시에 기본 값 설정 및 호출 메서드.
 */
function rdOpen(rdObject, formObject, sheetObjects, paraArry) {
	/*
	 * var Rdviewer=rdObject;
	Rdviewer.AutoAdjust=true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.SetBackgroundColor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.SetNoDataDialogInfo(0, "", "");  // hide no data message 
	var strPath=RD_path + "apps/opus/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0556_2.mrd";
	var rdParam="/rdata []";
	Rdviewer.FileOpen(strPath, RDServer + rdParam);
	*/
}
//Event handler processing by button click event */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	var objs=document.all.item("tabLayer");
	var tab1Status=objs[0].style.display;
	var Rdviewer=rdObjects[0];
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			// if( tab1Status == "inline" ){
			var whfNtcDt1=formObject.whf_ntc_dt1.value;
			var whfNtcDt2=formObject.whf_ntc_dt2.value;
			var rdObject=rdObjects[0];
			// var paraAry = new Array('','','','','','','','');
			var whfBndCd='';
			for ( var i=0; i < formObject.whf_bnd_cd.length; i++) {
				if (formObject.whf_bnd_cd[i].checked == true)
					whfBndCd=formObject.whf_bnd_cd[i].value;
			}
			var portNm='';
			for ( var i=0; i < formObject.port_nm.length; i++) {
				if (formObject.port_nm[i].checked == true)
					portNm=formObject.port_nm[i].value;
			}
			var paraAry=new Array(whfNtcDt1.split("-").join(""), whfNtcDt2
					.split("-").join(""), whfBndCd, portNm,
					formObject.demand_month.value,
					formObject.calculate_month.value,
					formObject.represent.value, formObject.phone_num.value);
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			//doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;
		case "btn_downexcel":
			if(sheetObject1.RowCount() < 1){
				ComShowCodeMessage("COM132501");
			}else{
				sheetObject1.Down2Excel({ HiddenColumn:0,TreeLevel:false});
			}			
			break;
		case "btn_print":
			if (tab1Status == "inline") {
				Rdviewer.PrintDialog(); // open print dialog
			} else {
				return false;
			}
			break;
		case "btn_add":
			sheetObject1.DataInsert(-1);
			break;
		case "btn_del":
			doActionIBSheet(sheetObject1, document.form, IBDELETE);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.whf_ntc_dt1, formObject.whf_ntc_dt2,
					'yyyy-MM-dd');
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
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: 
		if (formObj.whf_ntc_dt1.value == "") {
			ComShowCodeMessage('BKG00887', '허가시작일자');
			return false;
		}
		if (formObj.whf_ntc_dt2.value == "") {
			ComShowCodeMessage('BKG00887', '허가종료일자');
			return false;
		}
		return true;
		break;
	}
}
/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
		      var HeadTitle1="||번호|선명|CODE|항차|호출부호|입출항횟수|외내항구분|반출입구분|입항일시|비관리청유무|고지번호|DEC NO|단/복수|납부금액|남부일자|대납경비";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix='sheet1_';

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hcnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"call_sgn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ichcnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ongubun",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_bnd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkrcisnot",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_ntc_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_decl_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_kind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ntc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"AutoSum",   Hidden:0, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"comm_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetCountPosition(0);
                SetColProperty(prefix+"ichcnt", {Format:"####-###"} );
		            //conversion of function[check again]CLT 			InitDataValid(0, prefix + "vsl_nm", vtEngUpOther, '0123456789');
		      //conversion of function[check again]CLT 			InitDataValid(0, prefix + "hcnt", vtEngUpOther, '0123456789');
		      //conversion of function[check again]CLT 			InitDataValid(0, prefix + "call_sgn_no", vtEngUpOther, '0123456789');
		      //conversion of function[check again]CLT 			InitDataValid(0, prefix + "whf_ntc_no", vtEngUpOther, '0123456789');
        		SetColProperty(prefix+"ongubun", {ComboText:"1", ComboCode:"1"} );
        		SetColProperty(prefix+"whf_bnd_cd", {ComboText:"1|2", ComboCode:"1|2"} );
        		SetColProperty(prefix+"bkrcisnot", {ComboText:"2", ComboCode:"2"} );
//		        SetSheetHeight(357);
        		resizeSheet();
		      }




		break;
	}
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SetSumText(0, 2,"");
	sheetObj.SetSumText(0, 3,"        TOTAL");
}
function sheet1_OnAfterEdit(sheetObj, Row, Col) {
	doActionIBSheet(sheetObj, document.form, IBSAVE);
}
/**
 * RD print
 * 
 * @param rdObject
 * @return
 */
function rdPrint(rdObject) {
	var Rdviewer=rdObject;
	Rdviewer.PrintDialog();
	// Rdviewer.CMPrint();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 
