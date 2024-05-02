/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0215.js
*@FileTitle  : Add Call Information (Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class VOP_VSK_0215 : business script for VOP_VSK_0215
 */
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		
		switch (srcName) {
		case "btn_ok":
			if (validateForm(formObj)) {
				var info	= new Object();
				
				info.port_cd=formObj.port_cd.value;
				info.yard_cd=formObj.yard_cd.value;
				
				if(formObj.vt_add_call_flg != undefined && formObj.vt_add_call_flg.checked){
					info.vt_add_call_flg	= 'Y';
				}
				
				if(formObj.add_call_xter_flg != undefined && formObj.add_call_xter_flg.checked){
					info.add_call_xter_flg	= 'Y';
					//alert(formObj.add_call_xter_flg.checked);
				}
				
				//alert(formObj.vt_add_call_flg.checked);
				
				if(formObj.eta_day && formObj.eta_time){
					info.eta=formObj.eta_day.value + formObj.eta_time.value;
				}else{
					info.eta="";
				}
				info.etb=formObj.etb_day.value + formObj.etb_time.value;
				info.etd=formObj.etd_day.value + formObj.etd_time.value;
				if (formObj.turn_ind) {
					info.turn_ind=formObj.turn_ind.value;
				}
				info.eta=info.eta.replace(/\/|\-|\:|\./g, "");
				info.etb=info.etb.replace(/\/|\-|\:|\./g, "");
				info.etd=info.etd.replace(/\/|\-|\:|\./g, "");
				
				for ( var i=0; formObj.position
						&& i < formObj.position.length; i++) {
					if (formObj.position[i].checked) {
						info.position=formObj.position[i].value;
						break;
					}
				}
				ComPopUpReturnValue(info);
				//window.returnValue=info;
				//comPopupOK();
			}
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btn_search1": // Port Retrieve popup
			// var sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043";
			var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="
					+ formObj.port_cd.value;
			ComOpenPopup(sUrl, 450, 470, "rtnPortCd", "0,0", false);
			
			break;
		case "eta_btn_cal":
			var cal=new ComCalendar();
			cal.select(formObj.eta_day, 'yyyy-MM-dd');
			break;
		case "etb_btn_cal":
			var cal=new ComCalendar();
			cal.select(formObj.etb_day, 'yyyy-MM-dd');
			break;
		case "etd_btn_cal":
			var cal=new ComCalendar();
			cal.select(formObj.etd_day, 'yyyy-MM-dd');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Pop Up Open call back 함수 (PORT CD 조회) 
 */
function rtnPortCd(rtnVal ){
	var formObj=document.form;
	if( rtnVal != "" ){
		formObj.port_cd.value = rtnVal; 
	}
	
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
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
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	
	var formObj	= document.form;
	
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	if (document.form.pos_flg.value == "B") {
		document.form.position[1].checked=true;
		document.form.position[0].disabled=true;
	} else if (document.form.pos_flg.value == "A") {
		document.form.position[0].checked=true;
		document.form.position[1].disabled=true;
	}
	initControl();
	// if port_cd exist, retrieving yd_cd and showing
	// if yd_cd exist, selected option tag showing
	var portCd=formObj.port_cd.value;
	var yardCd="";
	if(formObj.yard_cd){
		yardCd=formObj.yard_cd.value;
		if(portCd!="" && yardCd==""){
			loadYdCd(portCd);
		}
	}
	
	/** Setting Virtaul Add Call Target **/
	if(formObj.add_call_xter_tgt_flg != undefined && formObj.add_call_xter_tgt_flg.value == "Y"){
		formObj.add_call_xter_flg.checked	= true;
	}else{
		formObj.add_call_xter_flg.checked	= false;
	}

	if(formObj.vt_add_call_tgt_flg != undefined && formObj.vt_add_call_tgt_flg.value == "Y"){
		formObj.vt_add_call_flg.checked		= true;
		formObj.add_call_xter_flg.checked	= false;
		
		$("input:checkbox[name='vt_add_call_flg']").attr("disabled",true);
		$("input:checkbox[name='add_call_xter_flg']").attr("disabled",true);
	}else{
		formObj.vt_add_call_flg.checked		= false;
	}
	
}

function initCombo(comboObj, comboNo) {
	var formObj=document.form;
    switch(comboObj.id) {
		case "yd_cd":
    		with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "25");
				SetColWidth(1, "340");
				SetDropHeight(160);
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
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			tabIndex=-1;
			var HeadTitle1="|";
	
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			 
			InitColumns(cols);
			SetEditable(0);
			SetVisible(false);
		}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // Port Retrieve
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		sParam=sParam + "&loc_cd=" + formObj.port_cd.value;
		//var rXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do", sParam);
		var rXml=sheetObj.GetSearchData("VOP_VSK_0215GS.do", sParam);
		ComOpenWait(false);
		var nm=ComGetEtcData(rXml, "loc_nm");
		if (!nm) {
			ComShowCodeMessage('VSK00029', formObj.port_cd.value);
			return false;
		}
		return true;
		break;
	case SEARCH01: // Yard Retrieve
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH01;
		var sParam=FormQueryString(formObj);
		sParam=sParam + "&loc_cd=" + formObj.port_cd.value;
		var rXml=sheetObj.GetSearchData("VOP_VSK_0215GS.do", sParam);
		ComOpenWait(false);
		var ydCds=ComGetEtcData(rXml, "yd_cd").split("|");
		var ydNms=ComGetEtcData(rXml, "yd_nm").split("|");
		//Showing last 2 words of ydCds
		for(var i=0; i<ydCds.length; i++){
			ydCds[i]=ydCds[i].substring(5, 7);
		}
		appendMultiComboItem(comboObjects[0], ydCds, ydNms, "");
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(formObj) {
	with (formObj) {
		// Checking Port Code
		if (ComChkLen(port_cd, 5) != 2) {
			ComShowCodeMessage("VSK00027", "Port Code");
			port_cd.select();
			return false;
		}
		// Checking Yard Code
		if("Y"==showYard.value && ComChkLen(yard_cd, 7) != 2) {
			ComShowCodeMessage("VSK00027", "Yard Code");
			return false;
		}
		// Checking ETA
		if (formObj.eta_day && !ComIsDate(eta_day.value)) {
			ComShowCodeMessage('VSK00003');
			eta_day.value='';
			eta_day.select();
			return false;
		}
		// Checking ETB
		if (!ComIsDate(etb_day.value)) {
			ComShowCodeMessage('VSK00003');
			etb_day.value='';
			etb_day.select();
			return false;
		}
		// Checking ETD
		if (!ComIsDate(etd_day.value)) {
			ComShowCodeMessage('VSK00003');
			etd_day.value='';
			etd_day.select();
			return false;
		}
		var form=null;
		var to=null;
		// Checking ETA - ETB
		if (formObj.eta_day && eta_day.value != "") {
			from=eta_day.value + eta_time.value;
			to=etb_day.value + etb_time.value;
			from=from.replace(/\/|\-|\:/g, ""); // Removing Date Separator
			to=to.replace(/\/|\-|\:/g, ""); // Removing Date Separator
			if (from - to >= 0) {
				ComShowCodeMessage('VSK00025', 'ETB', 'ETA');
				eta_day.select();
				return false;
			}
		}
		// Checking ETB - ETD
		from=etb_day.value + etb_time.value;
		to=etd_day.value + etd_time.value;
		from=from.replace(/\/|\-|\:/g, ""); // Removing Date Separator
		to=to.replace(/\/|\-|\:/g, ""); // Removing Date Separator
		if (from - to >= 0) {
			ComShowCodeMessage('VSK00025', 'ETD', 'ETB');
			etb_day.select();
			return false;
		}
		return true;
	}
}
function initControl() {
//	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//	axon_event.addListenerForm('focus', 'obj_focus', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListener('focus', 'obj_focus', 'eta_time' , 'etb_time' , 'etd_time' );
//	axon_event.addListener('keyup', "VskKeyFocus", 'form');
}
//function obj_keypress() {
//	switch (event.srcElement.dataformat) {
//	case "float":
//		ComKeyOnlyNumber(event.srcElement, ".");
//		break;
//	case "eng":
//		ComKeyOnlyAlphabet();
//		break;
//	case "engdn":
//		ComKeyOnlyAlphabet('lower');
//		break;
//	case "enguponly":
//		ComKeyOnlyAlphabet('upper');
//		break;
//	default:
//		ComKeyOnlyNumber(event.srcElement);
//	}
//}

function obj_focus(){
	 var obj = ComGetEvent();
	 org_value = obj.value;
	 obj.setSelectionRange(0,org_value.length);
}
/*function obj_focus() {
	// Removing mask separator
	switch (ComGetEvent("name")) {
	case "eta_day":
	case "eta_time":
	case "etb_day":
	case "etb_time":
	case "etd_day":
	case "etd_time":
		ComClearSeparator(ComGetEvent());
		break;
	}
	if(event.srcElement.options){
//		event.srcElement.focus();
	}else{
//		event.srcElement.select();
	}
}
*/
function obj_blur() {
	// Checking inputValidation and Masking
	switch (ComGetEvent("name")) {
	case "eta_day":
	case "eta_time":
	case "etb_day":
	case "etb_time":
	case "etd_day":
	case "etd_time":
		ComChkObjValid(ComGetEvent());
		break;
	default:
		break;
	}
}

function obj_change() {
	var formObj=document.form;
	var obj=ComGetEvent();
	switch(ComGetEvent("name")) {
//	case "eta_day":
//		if (obj.value != '' && !ComIsDate(obj.value, "ymd")) {
//			ComShowCodeMessage('VSK00003');
//			obj.value='';
//			obj.select();
//			return false;
//		}
//		break;
//	case "etb_day":
//		if (obj.value != '' && !ComIsDate(obj.value, "ymd")) {
//			ComShowCodeMessage('VSK00003');
//			obj.value='';
//			obj.select();
//			return false;
//		}
//		break;
//	case "etd_day":
//		if (obj.value != '' && !ComIsDate(obj.value, "ymd")) {
//			ComShowCodeMessage('VSK00003');
//			obj.value='';
//			obj.select();
//			return false;
//		}
//		break;
//	case "eta_time":
//		if (obj.value != '' && !ComIsTime(obj.value, "hm")) {
//			ComShowCodeMessage('VSK00004');
//			obj.value='';
//			obj.select();
//			return false;
//		}
//		break;
//	case "etb_time":
//		if (obj.value != '' && !ComIsTime(obj.value, "hm")) {
//			ComShowCodeMessage('VSK00004');
//			obj.value='';
//			obj.select();
//			return false;
//		}
//		break;
//	case "etd_time":
//		if (obj.value != '' && !ComIsTime(obj.value, "hm")) {
//			ComShowCodeMessage('VSK00004');
//			obj.value='';
//			obj.select();// obj.select();
//			return false;
//		}
//		break;
	
	case "port_cd":
		if (obj.value != '') {
			if(doActionIBSheet(sheetObjects[0], formObj, IBSEARCH)){
				if(formObj.yd_cd){
					loadYdCd(formObj.port_cd.value);
				}else{
					formObj.eta_day.focus();
				}
			}else{
				clearYdCd();
				formObj.port_cd.value='';
				formObj.port_cd.select();
			}
		}
		break;		
		
		
	case "vt_add_call_flg":
		
		if (formObj.vt_add_call_flg.checked) {
			//alert(formObj.turn_ind.selectedIndex);
			eval("document.form.turn_ind").selectedIndex	= 1;
			formObj.turn_ind.disabled						= true;
			formObj.add_call_xter_flg.checked				= false;
		}else{
			formObj.turn_ind.disabled						= false;
			//formObj.add_call_xter_flg.checked				= true;
		}
		break;
		
		
	case "add_call_xter_flg":
		
		if (formObj.add_call_xter_flg.checked) {
			formObj.turn_ind.disabled						= false;
			formObj.vt_add_call_flg.checked					= false;
		}else{
			//formObj.vt_add_call_flg.checked					= true;
		}
		break;
		
		
	}
}
function clearYdCd(){
	var formObj=document.form;
	if(formObj.yd_cd){
		formObj.yd_cd.RemoveAll();
		formObj.yard_cd.value="";
	}
}
function loadYdCd(portCd){
	var formObj=document.form;
	if(portCd){
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
		formObj.yd_cd.focus();
	}
}
/**
 * Adding item to Mutil Combo
 * @param comboObj
 * @param optionCds
 * @param optionTxts
 * @param selCode
 * @return
 */
function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
	comboObj.RemoveAll();
	for(var i=0; i<optionCds.length; i++) {
		comboObj.InsertItem(i, optionCds[i]+"|"+optionTxts[i], optionCds[i]);
	}
	comboObj.SetSelectCode(selCode,false);
}
function yd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	formObj.yard_cd.value=formObj.port_cd.value + comboObj.GetSelectCode();
}
