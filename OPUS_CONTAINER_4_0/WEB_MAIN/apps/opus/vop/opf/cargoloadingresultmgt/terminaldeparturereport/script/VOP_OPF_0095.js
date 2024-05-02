/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0095.js
*@FileTitle  : Missing TDR Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11

=========================================================*/

/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
/**
 * @extends  
 * @class VOP_OPF_0095 : VOP_OPF_0095 business script for
 */
function VOP_OPF_0095() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}

/* Developer performance	*/
//common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var prefix="sheet1_";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	　
	var sheetObj=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
		case "btn_new":
			UF_reset();
			break;
		case "btn_downexcel":
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
				}
			break;
		case "btns_port":
			
	    	var sUrl	= "/opuscntr/VOP_VSK_0043.do?loc_cd="+formObj.loc_cd.value;
	    	////var rVal	= ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
	    	ComOpenPopup(sUrl, 422, 520, "getRtnVal", "0,0", true);
			
/*			if(rVal){
				sheetObjects[0].RemoveAll();
				formObj.port_cd.value	= rVal;
				////port_cd_keyup();//RHQ_OFC_CD setting		
				port_cd_onchange();
			}*/ 
			break;
		case "btns_slan":  
			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+formObj.slan_cd.value, 470, 480, "slan_cd_pop_event", "0,0", true);
			break;
        case "btns_period": // From calendar button
        	var cal=new ComCalendarFromTo();
        	cal.endFunction="cal_end_func";
        	cal.select(formObj.fr_dt, formObj.to_dt, 'yyyy-MM-dd');
            break;
		case "btn_vvd":
			var vslCd=ComGetObjValue(formObj.vsl_cd);
			var sUrl="";
			if (vslCd == "") {
				sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
				ComOpenPopup(sUrl, 520, 500, "setCallBackVSL", "0,0", true);
			} else {
				sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
				ComOpenPopup(sUrl, 370, 425, "setCallBackVVD", "0,0", true);
			}            
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function getRtnVal(rVal){
	var formObj	= document.form;

	if(rVal){
		sheetObjects[0].RemoveAll();
		formObj.loc_cd.value	= rVal;
		port_cd_onchange();
	}	
}

/**
 * method after selecting Calendar From To
 */
function cal_end_func(){
	sheetObjects[0].RemoveAll();
}
/**
 * method after selecting Lane Code 
 */
function slan_cd_pop_event(aryPopupData) {
	sheetObjects[0].RemoveAll();
	document.form.slan_cd.value=aryPopupData[0][1];
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
* param : combo_obj ==> comboobject
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
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	document.form.fr_dt.value=frDt;
	document.form.to_dt.value=toDt;
	initControl();
	setRhq_ofc_cd();
}

/* get RHQ combo  */
function setRhq_ofc_cd(){
	var formObj			= document.form;
	formObj.f_cmd.value	= SEARCH01;
	
	////var param			= FormQueryString(formObj)+"&comboCd=CD02723"
	////var sXml			= sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", param);
	
	var sXml			= sheetObjects[0].GetSearchData("VOP_OPF_0095GS.do", null);
	var sXml			= ComGetEtcData(sXml, "RHQ_CD_LIST");
	
	var rhq				= sXml.split("|");
	for(var i=1; i<rhq.length; i++){
		//alert('i = ['+i+'],  value = ['+rhq[i]+']');
		comboObjects[0].InsertItem(-1, rhq[i], rhq[i]);
	}	
	
	comboObjects[0].InsertItem		(0, "All", " ");
	comboObjects[0].SetSelectText	("All");
}

/**
* Loading event of HTML Control in page dynamically <br>
* initializing IBSheet by calling {@link #loadPage}Method <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {int}     sheetNo     sheetObjects 
**/
function initControl() {
	//** Date separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
 //Axon event1. event catch
	axon_event.addListenerFormat('blur',             'obj_blur',        formObj);
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); 
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); 
	axon_event.addListenerFormat('click'           , 'obj_onclick'   , 	formObj);
	axon_event.addListener('click', 'change_event_radio', 'crr_cd');
	
	axon_event.addListener('change', 'port_cd_onchange', 'loc_cd', ''); 
}
/**
 * OnBlur
 * 
 * @return
 */
function obj_deactivate(){
	ComChkObjValid(event.srcElement);
}
/**
* OnFocus
* @return
*/
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_onclick(){
	//var src = window.event.srcElement.getAttribute("name")
}
/**
 * handling work java script OnFocusOut event <br>
 **/
function obj_blur() {
	var formObj=document.form;
	with (event.srcElement) {	
		switch (name) {	
		    case "vsl_cd":
		    	if (value != ''){
		    		ComEnableObject(formObj.fr_dt, false);
			    	ComEnableObject(formObj.to_dt, false);
			    	ComEnableObject(formObj.btns_period, false);
		    		formObj.fr_dt.className="input2";
		    		formObj.to_dt.className="input2";

		    	}else{
		    		ComEnableObject(formObj.fr_dt, true);
			    	ComEnableObject(formObj.to_dt, true);
			    	ComEnableObject(formObj.btns_period, true);
		    		formObj.fr_dt.className="input1";
		    		formObj.to_dt.className="input1";
		    	}
		    	break;
			case "skd_dir_cd":	
				if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
					//get VVD Info 
					searchVVDInfo();
				}		
				break;
			default:
				break;
		}
	}
}

function change_event_radio(){
	sheetObjects[0].RemoveAll();
	if (document.form.crr_cd[1].checked){
		tdr_flg.SetSelectText("All",false);
	}else{
		tdr_flg.SetSelectCode("MSS",false);
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
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {

	        if (location.hostname != "")
	        var HeadTitle="SEQ|RHQ|Carrier|Port|Terminal|Terminal|Lane|Type|VVD|Arrival date|Departure date|Moves|Bay Plan|TDR";
	        var HeadTitle1="SEQ|RHQ|Carrier|Port|Yard|Name|Lane|Type|VVD|Arrival date|Departure date|Moves|Bay Plan|TDR";
	        var headCount=ComCountHeadTitle(HeadTitle);
	        //(headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"},
	                    { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",   ColMerge:1,   SaveName:prefix+"seq" },
	               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rhq_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"crr_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ar_dt",       KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dp_dt",       KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mv_cnt",      KeyField:0,   CalcLogic:"",   Format:"Float" },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bay_pln_flg", KeyField:0,   CalcLogic:"",   Format:"" },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tdr_flg",     KeyField:0,   CalcLogic:"",   Format:"" } ];
	         
	        InitColumns(cols);
	
	        SetEditable(0);
	        SetColProperty(prefix+"ar_dt", {Format:"####-##-## ##:##"} );
	        SetColProperty(prefix+"dp_dt", {Format:"####-##-## ##:##"} );
	        //SetSheetHeight(388);
	        resizeSheet();
		}
		break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


//handling process related Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {
		case IBSEARCH: //Retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_OPF_0095GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
//			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
//			}
			break;
	}
}
/**
* set Combo
* param :  comboObj , comboNo　
*adding case as numbers of counting combos
*/ 
function initCombo(comboObj, comboNo) {
	var formObj=document.form
	switch (comboObj.options.id) {
	// Carrier Code
	case "rhq_ofc_cd":
		with (comboObj) {
			SetMultiSelect(0);
			SetUseAutoComplete(0);
			SetColAlign(0, "left");
			SetColWidth(0, "70");
			SetDropHeight(160);
//no support[check again]CLT 			ValidChar(2, 0);
			SetMaxLength(5);
		}
		
//		comboObj.SetDropHeight(125);
//		comboObj.SetBackColor("#CCFFFD");
//		InsertItem(i++,  "ALL",  "^");
//		comboObj.SetSelectCode("^");		

		break;
	// Trade Code
	case "tdr_flg":
		with (comboObj) {
			SetMultiSelect(0);
			SetUseAutoComplete(0);
			SetColAlign(0, "left");
			SetColWidth(0, "70");
			SetDropHeight(160);
//no support[check again]CLT 			ValidChar(2, 0);
			SetMaxLength(3);
		}
		UF_setComboItem(comboObj, tdrList.split("|"));
		comboObj.SetSelectCode("MSS",false);
		break;
	case "svc_tp_cd":
		with (comboObj) {
			SetMultiSelect(0);
			SetUseAutoComplete(0);
			SetColAlign(0, "left");
			SetColWidth(0, "70");
			SetDropHeight(160);
//no support[check again]CLT 			ValidChar(2, 1);
			SetMaxLength(5);
		}
		UF_setComboItem(comboObj, svcList.split("|"));
		comboObj.SetSelectCode("TRK",false);
		break;
	case "ex_tpr_flg":
		with (comboObj) {
			SetMultiSelect(0);
			SetUseAutoComplete(0);
			SetColAlign(0, "left");
			SetColWidth(0, "70");
			SetDropHeight(160);
//no support[check again]CLT 			ValidChar(2, 0);
			SetMaxLength(3);
		}
		UF_setComboItem(comboObj, "Y,Y|N,N".split("|"));
		comboObj.SetSelectIndex(1,false);
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //Retrieve
			if(!ComIsNull(formObj.vsl_cd.value) && ComIsNull(formObj.skd_voy_no.value) && !ComIsNull(formObj.skd_dir_cd.value)  ){
				ComShowCodeMessage("COM130404", "VVD");
				ComSetFocus(formObj.skd_voy_no);
				return false;
			}
			break;
	}
	return true;
}
/**
* 
* @param sheetObj
* @param ErrMsg
* @return
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//
}
/**
 * Call after inputting 5 digit in case of Port Code Key-in
 */
function port_cd_onchange(){
	var formObj			= document.form;
	sheetObjects[0].SetWaitImageVisible(0);
	formObj.f_cmd.value	= SEARCH02;

	var sRhqXml = sheetObjects[0].GetSearchData("VOP_OPF_0095GS.do", FormQueryString(formObj));
	if(formObj.loc_cd.value == ""){
		rhq_ofc_cd.SetSelectCode(" ");
		return;
	}
	if(ComGetEtcData(sRhqXml, "RHQ_CD") == ""){		
		ComAlertFocus(formObj.loc_cd, ComGetMsg("OPF50004", "'Port Code'"));
		formObj.loc_cd.value	= "";
	}else{
		var rhqOfcCd	= ComGetEtcData(sRhqXml, "RHQ_CD");
		rhq_ofc_cd.SetSelectCode(rhqOfcCd == "" ? " " : rhqOfcCd, false);
		////ComKeyEnter('lengthnextfocus');
	}

}
/**
 * method called when completing 3 digit in case LANE COde Key-In
 */
function slan_cd_keyup(){
	var formObj=document.form;
	sheetObjects[0].SetWaitImageVisible(0);
	formObj.f_cmd.value=COMMAND12;
	var lanXml=sheetObjects[0].GetSearchData("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
	var strLanCdDesc=ComGetEtcData(lanXml, "checkLane");
	if(ComTrim(strLanCdDesc) == ""){
		ComAlertFocus(formObj.slan_cd, ComGetMsg("OPF50004", "'Lane Code'"));
		formObj.slan_cd.value="";
	}else{
		ComKeyEnter('lengthnextfocus');
	}	
}
/**
 * Combo Item setting
 * @param comboObj
 * @param comboItems
 */
function UF_setComboItem(comboObj, comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(",");
		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
	}   		
}
/**
 * RHQ onChange event
 * @param comboObj
 * @param Code
 * @param Text
 */
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function rhq_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	sheetObjects[0].RemoveAll();
	document.form.loc_cd.value	= "";
}
/**
 * TDR onChange event
 * @param comboObj
 * @param Code
 * @param Text
 */
function tdr_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	sheetObjects[0].RemoveAll();
}
/**
 * Service OnChange event
 * @param comboObj
 * @param Code
 * @param Text
 */
function svc_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	sheetObjects[0].RemoveAll();
	if (newCode == "TRK"){
		tdr_flg.SetSelectCode("MSS",false);
	}else{
		tdr_flg.SetSelectText("All",false);
	}
}
function ex_tpr_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	sheetObjects[0].RemoveAll();
}
function UF_reset(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	
	ComEnableObject(formObj.fr_dt, true);
	ComEnableObject(formObj.to_dt, true);
	ComEnableObject(formObj.btns_period, true);
	formObj.fr_dt.className="input1";
	formObj.to_dt.className="input1";
	
	formObj.fr_dt.value=frDt;
	formObj.to_dt.value=toDt;
	var dfltInx=comboObjects[0].FindItem(rhq_ofc_cd, 0);
	comboObjects[0].SetSelectText((dfltInx == "-1"?"All":dfltInx),false);
	formObj.loc_cd.value="";
	formObj.slan_cd.value="";
	
	ComSetObjValue(formObj.vsl_cd,     "");
	ComSetObjValue(formObj.skd_voy_no, "");
	ComSetObjValue(formObj.skd_dir_cd, "");
	
	formObj.crr_cd[0].checked=true;
	tdr_flg.SetSelectCode("MSS",false);
	svc_tp_cd.SetSelectCode("TRK",false);
	ex_tpr_flg.SetSelectCode("N",false);
	sheetObj.RemoveAll();
}
/**
 * setting data received from VSL Code Help (Pop-Up)<br>
 */
function setCallBackVSL(rtnObjs) {
	var formObj=document.form;
	if (rtnObjs) {
		var rtnDatas=rtnObjs[0];
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
				// change focus 
				ComSetFocus(formObj.skd_voy_no);
				
	    		ComEnableObject(formObj.fr_dt, false);
		    	ComEnableObject(formObj.to_dt, false);
		    	ComEnableObject(formObj.btns_period, false);
	    		formObj.fr_dt.className="input2";
	    		formObj.to_dt.className="input2";
			}
		}
	}
}

/**
 * setting data received from VVD Code Help (Pop-Up)<br>
 */
function setCallBackVVD(obj) {
	var formObj=document.form;
	var comboObj=comboObjects[0];
	if (obj) {
		var rtnDatas=obj[0];
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
				ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
				//get VVD Info 
				searchVVDInfo();
			}
		}
	}
}

/**
 * retrieve VVD Info <br>
 **/
function searchVVDInfo() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var comboObj=comboObjects[0];
	//initializing related item
	formObj.f_cmd.value=SEARCH05;
	sheetObj.SetWaitImageVisible(0);
	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
	var vvdData=ComOpfXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
	if (vvdData == null) {
		ComShowCodeMessage("OPF50004", 'Data');
		//initializing related item
		ComSetObjValue(formObj.vsl_cd,     "");
		ComSetObjValue(formObj.skd_voy_no, "");
		ComSetObjValue(formObj.skd_dir_cd, "");
		//change focus 
		ComSetFocus(formObj.vsl_cd);
	}
	sheetObj.SetWaitImageVisible(1);
}

/* Developer performance  end */
