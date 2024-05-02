/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_2029.js
 *@FileTitle : Tariff Route Search Pop-Up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_2029() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

document.onclick = processButtonClick;

function processButtonClick() {
	var form = document.form;
	var rdoDateObj = form.rdoDate;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_ctryPopup":
			selectCountry();
			break;
		case "btn_pnt_loc_cd" :
		case "btn_bse_port_loc_cd" :
			 var sUrl = "/hanjin/ESM_PRI_4026.do?";
             sUrl += "group_cmd=" + PRI_SP_SCP;
             sUrl += "&location_cmd=L";
             sUrl += "&svc_scp_cd=" + form.svc_scp_cd.value;
             var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
             if (rtnVal != null){
                 if(srcName == "btn_pnt_loc_cd") {
                     form.pnt_loc_cd.value = rtnVal.cd;
                 }else if(srcName == "btn_bse_port_loc_cd"){
                     form.bse_port_loc_cd.value = rtnVal.cd;
                 }
             }
             break;	
         case "btn_Close":
			self.close();
			break;  
		case "btn_OK":
			ComOpenWait(true);
			comPopupOK();
			ComOpenWait(false);
			break;	  		
		}
	} catch (e) {

	}
}

function selectCountry(){
	var parameter = FormQueryString(document.form);
	ComOpenPopup("/hanjin/ESM_PRI_7027.do?" + parameter,565, 480, 'getCountry', "0,1,1,1,1", true);
}

function getCountry(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;
	if ( aryPopupData.length > 0 ) {
		var cntCdVal = "";
		for(var i =0; i < aryPopupData.length; i++) {
			cntCdVal += aryPopupData[i][3];
			if( i < aryPopupData.length-1) {
				cntCdVal += ",";
			}
		}
		formObj.cnt_cd.value = cntCdVal
	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		doActionComboSheet(sheetObjects[0], document.form, comboObjects[k]);
	}
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
}


function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			style.height = 365;
			SheetWidth = mainTable.clientWidth;

			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "Sel||Seq|Point|Description|LOC Group|Term|Base Port|Trans Mode|Cgo Type|Guideline(USD)|Guideline(USD)|Guideline(USD)|SVC Type||";
			var HeadTitle2 = "Sel||Seq|Point|Description|LOC Group|Term|Base Port|Trans Mode|Cgo Type|D2|D4|D5|SVC Type||";

			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			InitDataProperty(0, cnt++ , dtRadioCheck,	0,    	daCenter,  	true, "radio",						false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++ , dtCheckBox,  	20,    	daCenter,  	true,  "checkbox",     				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	true, "seq",          				false, "", dfNone, 0, false,true);
			InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, "pnt_loc_cd", 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, "pnt_loc_cd_nm", 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, "ihc_cost_loc_grp_no", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			60,	 	daCenter, 	true, "rcv_de_term_cd_nm", 			false, "", dfNone, 0, false, false);	
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, "bse_port_loc_cd", 			false, "", dfNone, 0, false, false);					
			InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, "prc_trsp_mod_cd_nm", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, "ihc_cgo_tp_cd", 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, "gline_20ft_frt_rt_amt", 		false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, "gline_40ft_frt_rt_amt", 		false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, "gline_50ft_frt_rt_amt", 		false, "gline_40ft_frt_rt_amt", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtCombo, 		80, 	daCenter, 	true, "svc_tp_cd",	 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, 	true, "prc_trsp_mod_cd", 			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 		60, 	daCenter, 	true, "rcv_de_term_cd", 			false, "", dfNone, 0, false, false);
			InitDataCombo(0, "svc_tp_cd", 'Add-on|IHC|Combined'    , '1|2|3');
		}
		break;
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "svc_tp_cd":
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;

			IMEMode = 0;
			ValidChar(2, 0);
		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, document.form, sAction)) {
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.WaitImageVisible = false;
				sheetObj.CheckAll(1) = 0;
				sheetObj.DoSearch("ESM_PRI_2029GS.do", FormQueryString(formObj));
			} 
			break;
		}
		
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}
	

function doActionComboSheet(sheetObj, formObj, comboObjects) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}

		sheetObj.ShowDebugMsg = false;
		switch (comboObjects.id) {
		case "svc_tp_cd":
			comboObjects.RemoveAll();
			comboObjects.InsertItem(0, '', ''); 
			comboObjects.InsertItem(1, 'Add-on', '1'); 
			comboObjects.InsertItem(2, 'IHC', '2'); 
			comboObjects.InsertItem(3, 'Combined', '3'); 
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}		
}	


function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if(!ComChkValid(formObj)) {
			return false;
		}
		break;
	}
	return true;
}

function svc_tp_cd_OnChange(Index_Code, Text) {
	var formObj = document.form;
	if(Text != '1') {
		formObj.pnt_loc_cd.setAttribute("required", "required");
		formObj.pnt_loc_cd.setAttribute("className", "input1");
	} else {
		formObj.pnt_loc_cd.removeAttribute("required");
		formObj.pnt_loc_cd.setAttribute("className", "input");
	}
}

function replaceAll(inputString, targetString, replacement)
{
	  var v_ret = null;
	  var v_regExp = new RegExp(targetString, "g");
	  v_ret = inputString.replace(v_regExp, replacement);
	  
	  return v_ret;
}

function DoPaste(){
	event.returnValue=false;
	var a = window.clipboardData.getData('Text');
	var b = replaceAll(a,'\r\n', ',');
	document.form.pnt_loc_cd.value=b;
}
