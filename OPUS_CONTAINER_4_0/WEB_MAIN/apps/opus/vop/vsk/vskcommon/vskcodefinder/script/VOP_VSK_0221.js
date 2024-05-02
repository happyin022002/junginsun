/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0221.js
*@FileTitle  : Port Code Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/22
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
function VOP_VSK_0221() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
// public variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_retrieve":
			if (validateForm(sheetObject, document.form, IBSEARCH)) {
				doActionIBSheet(sheetObject, document.form, IBSEARCH);
			}
			break;
		case "btns_popup":
//			var sUrl="/opuscntr/COM_ENS_0M1.do";
//			ComOpenPopupWithTarget(sUrl, 670, 520, "cnt_cd:tmp_cnt_cd|cnt_nm:cnt_nm|cnt_cd:loc_cd", "0,0", true);
			ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 670, 520, "setCntCd", "0,0,1,1,1,1,1", true);
			formObj.cnt_cd.value=formObj.tmp_cnt_cd.value;
			
			
//			
//			var sUrl=""/opuscntr/ESM_PRI_4027.do?grp_cd=""+ RI_SG+""&commodity_cmd=C"";
//			ComOpenPopup(sUrl, 600, 330, "findCommodity", "1,0,1,1,1,1,1", true);
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

function setCntCd(codes) {
	var cols = codes[0];
	document.form.cnt_cd.value = cols[3];
	document.form.cnt_nm.value = cols[4];
	document.form.loc_cd.value = cols[3];
}

function findCommodity(rtnVal) {
    form.prc_cmdt_def_cd.value = rtnVal.cd;
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
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	initControl();
	
	//vskd_port_rhq_cd.SetText(0, 0, "ALL");
	vskd_port_rhq_cd.SetSelectText("ALL");
	//vskd_port_rhq_cd.Text="ALL";
	//document.form.vop_port_mntr_flg.disabled=false;
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	document.form.cnt_cd.focus();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
        with(sheetObj){
			tabIndex=-1;
			if (location.hostname != "")
			(6, 0, 0, true);
			var HeadTitle="|Port|Port Name|VOSI RHQ|Office Code|Monitoring";
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",                KeyField:0,   CalcLogic:"",   Format:"" },
			{Type:"Text",      Hidden:0, Width:450,  Align:"Left",    ColMerge:1,   SaveName:"loc_nm",                KeyField:0,   CalcLogic:"",   Format:"" },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vskd_port_rhq_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vop_port_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vop_port_mntr_flg",     KeyField:0,   CalcLogic:"",   Format:"" } ];
			
			InitColumns(cols);
			SetEditable(0);
			resizeSheet();
		}
		break;
	}
}
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
		case "vskd_port_rhq_cd":
			var i=0;
			with(comboObj) {
				//style.width=70px;
				SetDropHeight(150);
				InsertItem(i++,  "ALL",	"");
				SetBackColor("#CCFFFD");
				Code="%";
			}
			break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // Retrieving Port
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			var sParam=FormQueryString(formObj);
			sXml=sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
		}
		break;
	case SEARCH01: // Retrieving RHQ combo
		formObj.f_cmd.value=SEARCH01;
		var sParam=FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
		var rhqlist=ComGetEtcData(sXml, "rhqlist");
		if(rhqlist){
			var comboObj=comboObjects[0];
			var rhqs=rhqlist.split(":");
			for(var i=0; i<rhqs.length; i++){
				comboObj.InsertItem(-1, rhqs[i], rhqs[i]);
			}
		}
		break;
	case SEARCH02: // Retrieving Country Name
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH02;
		var sParam=FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
		ComOpenWait(false);
		var nm=ComGetEtcData(sXml, "cnt_nm");
		if (nm != null) {
			formObj.cnt_nm.value=nm;
			formObj.tmp_cnt_cd.value=formObj.cnt_cd.value;
			formObj.loc_cd.value=formObj.cnt_cd.value;
		} else {
			ComShowCodeMessage('VSK00021', formObj.cnt_cd.value);
			formObj.cnt_cd.value=formObj.tmp_cnt_cd.value;
		}
		break;
	}
	ComSetFocus(formObj.cnt_cd);
}
function setHtmlCombo(xmlStr, comboObj) {
	if (xmlStr == null || xmlStr == "")
		return;
	try {
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot=xmlDoc.documentElement;
		if (xmlRoot == null)
			return;
		var trNodes=xmlRoot.getElementsByTagName("TR");
		if (trNodes == null)
			return;
		for ( var i=0; i < trNodes.length; i++) {
			if (trNodes[i].nodeType != 1) {
				continue;
			}
			if (trNodes[i].firstChild == null) {
				// html += "<option></option>";
				comboObj.options.add(new Option('', ''));
			} else {
				// html += "<option value='" + trNodes[i].firstChild.nodeValue +
				// "'>" + trNodes[i].firstChild.nodeValue + "</option>";
				value=trNodes[i].firstChild.nodeValue;
				value=value.replace(/~/g, "");
				value=value.substring(2, value.length - 2);
				comboObj.options.add(new Option(value, value));
			}
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			var sCntCd=cnt_cd.value;
			var sLocCd=loc_cd.value;
			break;
		}
	}
	return true;
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change', 'obj_change', formObj);
	axon_event.addListenerForm('keypress', 'eng_keypress', formObj);
	axon_event.addListener('keyup', 'obj_keyup', 'cnt_cd');
//	axon_event.addListener('keypress', 'enter_keypress', 'form');
	axon_event.addListenerForm ('keydown', 'ComKeyEnter', formObj);
	axon_event.addListener('keyup', "VskKeyFocus", 'form');
}
function obj_change() {
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "cnt_cd":
			with (formObj) {
				if (cnt_cd.value == '') {
					loc_cd.value='';
					cnt_nm.value='';
					tmp_cnt_cd.value='';
				} else {
					if (ComChkLen(cnt_cd.value, 2) == 2) { // in case length is 2, retrieving country code
						if (tmp_cnt_cd.value != cnt_cd.value) {
							doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
						}
					}
				}
			}
			break;
		case "vskd_port_rhq_cd":
			if (0 != vskd_port_rhq_cd.selectedIndex) {
				formObj.vop_port_mntr_flg.disabled=false;
			} else {
				formObj.vop_port_mntr_flg.selectedIndex=0;
				formObj.vop_port_mntr_flg.disabled=true;
			}
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
function obj_keyup() {
	var formObj=document.form;
	var obj = ComGetEvent();
	if (obj.value == "") {
		formObj.loc_cd.value='';
		formObj.cnt_nm.value='';
		formObj.tmp_cnt_cd.value='';
	}
}
function eng_keypress() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	switch (srcName) {
	case "cnt_cd":
	case "loc_cd":
		ComKeyOnlyAlphabet('upper');
		break;
	case "loc_nm":
		//if (event.keyCode != 32) { // null
			////ComKeyOnlyAlphabet('upper');	//::스페이스와 @문자 입력도 입력가능:://
			ComKeyOnlyAlphabet('uppernum',"32|64");    //스페이스와 @문자 입력도 입력가능
		//}
		break;
	}
}
/**
 * Handling enter key
 */
function enter_keypress() {
	VskKeyEnter();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}