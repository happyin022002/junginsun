/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0231.js
*@FileTitle  : Agreement Inquiry by Route 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
document.onclick=processButtonClick;    
/* Branch processing event handler with the name of button */
function processButtonClick(){
	/***** . *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_retrieve":
			formObject.cur_page_cnt.value="1";
			doActionIBSheet(sheetObject,formObject,'IBSEARCH');
			break;
		case "btn_minimize":
			Mincount=(Mincount+1)%2;
			Minimize(Mincount);
			break;
		case "btng_downexcel":
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;
		case "btns_frmnode": //FromNode Popup
			openHireYardPopup('getFromNode');
			break;
		case "btns_vianode": //ViaNode Popup
			openHireYardPopup('getViaNode');
			break;
		case "btns_tonode": //ToNode Popup
			openHireYardPopup('getToNode');
			break;
		case "btns_dornode": //DoorLocation Popup
			openHireYardPopup('getDorLoc');
			break;
		case "btn_eqtpsz":
			rep_Multiful_inquiry(srcName);
			break;
		case "btn_serviceprovider":
			rep_OnPopupClick();
			break;
		case "reward":
			var ipageNo=formObject.cur_page_cnt.value;
			ipageNo--;
			if(Number(ipageNo) < 1){
				var errMessage=ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}  
			formObject.cur_page_cnt.value=ipageNo;
			doActionIBSheet(sheetObject,formObject,'IBSEARCH');
			break;
		case "forward":
			var ipageNo=formObject.cur_page_cnt.value;
			var totpage=formObject.tot_page_cnt.value;
			ipageNo++;  
			if( (Number(ipageNo) > Number(formObject.tot_page_cnt.value)) || totpage < 1){
				var errMessage=ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}
			formObject.cur_page_cnt.value=ipageNo;
			doActionIBSheet(sheetObject,formObject,'IBSEARCH');
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('TRS90404');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj, sheetNo) {
	var sheetObject=sheetObjects[0];
	var cnt=0;
	switch(sheetNo) {
	case 1: //sheet_main init
		with(sheetObj){
			var HeadTitle1="Seq|Service Provider|Service Provider|ofc_cty_cd|agmt_seq|Agreement\n No.|Remarks|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|From|Via|Door|To|Reverse|EQ Type\n/Size|Feeder Term|Feeder Term|No of\nChassis|Weight\nTier|UOM|Currency|Basic Rate|Basic Rate|COA|Effective Date|Effective Date|UDU" ;
			var HeadTitle2="Seq|Code|Name|ofc_cty_cd|agmt_seq|Agreement\n No.|Remarks|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|cust_cnt_cd|cust_seq|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|Via|Door|To|Reverse|EQ Type\n/Size|Receiving|Delivery|No of\nChassis|Weight\nTier|UOM|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)|COA|From|To|UDU" ;
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
			                { Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [
			         {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000},
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_trsp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
		             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"customer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_grp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rail_svc_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rvs_aply_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_eq_tp_sz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
		             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:"wtr_rcv_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wtr_de_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"trsp_agmt_bdl_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_wgt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Popup",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_one_wy_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		             {Type:"Popup",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rnd_rt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	                 {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cost_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
		             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
		             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"usr_def_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rt_tp_ser_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 } ];
			InitColumns(cols);
			SetEditable(1);     
			SetRangeBackColor(1,1,1,29,"#555555");
			resizeSheet();
		}
		break;
	}
}
/**
* Sheet
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case "IBSEARCH":
		if (!nodecheck()) return;
		formObj.f_cmd.value=SEARCH01;
		sheetObj.DoSearch("ESD_TRS_0231GS.do", TrsFrmQryString(formObj) );
		break;
	case IBDOWNEXCEL:
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
		}else{
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
		}
		break;
	}
}
/**
* node check
*/
function nodecheck(){
	var formObj=document.form;
	var search_fm_loc=formObj.search_fm_loc.value;
	var search_via_loc=formObj.search_via_loc.value;
	var search_door_loc=formObj.search_door_loc.value;
	var search_to_loc=formObj.search_to_loc.value;

	if( search_fm_loc == "" && search_to_loc == "" && search_via_loc == "" && search_door_loc == ""){
		ComShowCodeMessage('TRS90386', 'Please input at least more than one among From/Via/Door/To node.!');
		return false;
	}
	return true;
}
/**
 * General Node popup
 */
function openHireYardPopup(objName) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";   
	var classId=objName;
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	if( objName == "getDorLoc" ) {
		v6="zone"
	} else {
		v6="yard";
	}
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Calling rep_commodity pop-up
 */
function rep_Multiful_inquiry(objName)	{
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";   
	var classId="getTRS_ENS_906";
	var xx1=objName;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('ESD_TRS_0906.do' + param, 400, 390, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location : The case selecting one item at pop-up page
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject=document.form;
	if(x1 == 'btn_eqtpsz'){
		formObject.eqtpsz.value=rowArray;
	}
}
/**
  * Event clicking a tab
  * Activating the selected tab 
 */
function Minimize(nItem) {
	var objs=document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display="none";
		sheet_main.SetSheetHeight(ComGetSheetHeight(sheet_main, 19));
	} else {
		objs.style.display="inline";
		sheet_main.SetSheetHeight(ComGetSheetHeight(sheet_main, 16));
	}
}
/**
    * Validating inputted values of form
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
	return true;
}
/**
 * From Node popup's return value
 */
function getFromNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_fm_loc.value=lvLoc;
	getYardCombo(search_fm_yard, sheetObjects[0], formObject, lvLoc);
	search_fm_yard.SetSelectCode(lvYard);
}
/**
 * Via Node popup's return value
 */
function getViaNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_via_loc.value=lvLoc;
	getYardCombo(search_via_yard, sheetObjects[0], formObject, lvLoc);
	search_via_yard.SetSelectCode(lvYard);
}
/**
 * To Node popup's return value
 */
function getToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_to_loc.value=lvLoc;
	getYardCombo(search_to_yard, sheetObjects[0], formObject, lvLoc);
	search_to_yard.SetSelectCode(lvYard);
}
/**
 * Door Location popup's return value
 */
function getDorLoc(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_door_loc.value=lvLoc;
	getZoneCombo(search_door_yard, sheetObjects[0], formObject, lvLoc);
	search_door_yard.SetSelectCode(lvYard);
}
/*
 * Loading the list of external combo box (also in ESD_TRS_0003.js).
 */
function getComboList(obj, comObj, sep) { //object, value receiving part, kind of Node
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
	var charval="Y";
	obj.value=lvobj;

	if( comObj.name == 'search_fm_yard' ){
		comObj = search_fm_yard;
	}else if( comObj.name == 'search_via_yard' ){
		comObj = search_via_yard;
	}else if( comObj.name == 'search_to_yard' ){
		comObj = search_to_yard;
	}else if( comObj.name == 'search_door_yard' ){
		comObj = search_door_yard;
	}

	for (var i=0; i < lvobj.length; i++) {
		var oneChar=lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" )) {
			}else {
				charval="N";
				break;
			}
		} else {
			charval="N";
			break;
		}
	}
	if(charval=="Y") {
	} else {
		ComShowCodeMessage('COM12130','NODE','');
		obj.value="";
		obj.focus();
		return false;
	}
	if( lvobj == "" ) {
		obj.value="";
		obj = eval(obj.id);
		if(obj.name == 'search_fm_loc') yard_obj=search_fm_yard;
		else if(obj.name == 'search_via_loc') yard_obj=search_via_yard;
		else if(obj.name == 'search_to_loc') yard_obj=search_to_yard;
		else if(obj.name == 'search_door_loc') yard_obj=search_door_yard;
		var locValue=obj.value;
		if(ComTrim(locValue) == '') {
			yard_obj.RemoveAll();
			return;
		}
	} else if( lvobj.length != 5 ) {
		ComShowCodeMessage('TRS90074')
		if(sep=="F") {
			formObj.search_fm_loc.select();
			formObj.search_fm_loc.focus();
		} else if(sep=="V") {
			formObj.search_via_loc.select();
			formObj.search_via_loc.focus();
		} else if(sep=="T") {
			formObj.search_to_loc.select();
			formObj.search_to_loc.focus();
		} else if(sep=="D") {
			formObj.search_door_loc.select();
			formObj.search_door_loc.focus();
		} else {
		}
	} else {
		if( sep == 'F' ) {
			lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else if( sep == 'V' ) {
			lvViaNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else if( sep == 'T' ) {
			lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else if( sep == 'D' ) {
			lvDoorLoc=getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else {
		}
	}
}
/**
 * Capitalizing
 */
function upperCase(obj){
	var formObj=document.form;
	obj.value=obj.value.toUpperCase();
}
/**
 * Focusing
 */
function fun_Focus(obj){
	obj.select();
}
/*
 * popup
 */
function sheet_main_OnPopupClick(sheetObj, row, col) {
	var formObject=document.form;
	formObject.fm_rail_svc_tp_cd.value=sheetObj.GetCellValue(row, "rail_svc_tp_cd");
	formObject.fm_agmt_trsp_tp_cd_sheet.value=sheetObj.GetCellValue(row, "agmt_trsp_tp_cd");
	formObject.fm_trsp_agmt_ofc_cty_cd.value=sheetObj.GetCellValue(row, "trsp_agmt_ofc_cty_cd");
	formObject.fm_trsp_agmt_seq.value=sheetObj.GetCellValue(row, "trsp_agmt_seq");
	formObject.fm_trsp_agmt_rt_tp_ser_no.value=sheetObj.GetCellValue(row, "trsp_agmt_rt_tp_ser_no");
	formObject.fm_vndr_seq.value=sheetObj.GetCellValue(row, "vndr_seq");
	formObject.fm_ctrt_ofc_cd.value=sheetObj.GetCellValue(row, "ctrt_ofc_cd");
	formObject.fm_eq_knd_cd.value=formObject.eqtype.value;
	formObject.fm_trsp_agmt_eq_tp_sz_cd.value=sheetObj.GetCellValue(row, "trsp_agmt_eq_tp_sz_cd");
	formObject.fm_cgo_tp_cd.value=sheetObj.GetCellValue(row, "cgo_tp_cd");
	formObject.fm_trsp_cost_mod_cd.value=sheetObj.GetCellValue(row, "trsp_cost_mod_cd");
	formObject.fm_trsp_bnd_cd.value=sheetObj.GetCellValue(row, "trsp_bnd_cd");
	formObject.fm_fm_nod_cd.value=sheetObj.GetCellValue(row, "fm_nod_cd");
	formObject.fm_via_nod_cd.value=sheetObj.GetCellValue(row, "via_nod_cd");
	formObject.fm_dor_nod_cd.value=sheetObj.GetCellValue(row, "dor_nod_cd");
	formObject.fm_to_nod_cd.value=sheetObj.GetCellValue(row, "to_nod_cd");
	formObject.fm_trsp_agmt_bdl_qty.value=sheetObj.GetCellValue(row, "trsp_agmt_bdl_qty");
	formObject.fm_wgt_meas_ut_cd.value=sheetObj.GetCellValue(row, "wgt_meas_ut_cd");
	formObject.fm_curr_cd.value=sheetObj.GetCellValue(row, "curr_cd");
	if ( sheetObj.ColSaveName(col) == "trsp_one_wy_rt") {
		formObject.fm_way.value="ONE";
		formObject.fm_basic_rt.value=sheetObj.GetCellValue(row, "trsp_one_wy_rt");
		ComPostOpenWindow("ESD_TRS_0235.do", "OpenScg", "width=550,height=410,menubar=0,status=1,scrollbars=0,resizable=0");
		//formObject.target='OpenScg';
		//formObject.submit();
	} else {
		formObject.fm_way.value="RND";
		formObject.fm_basic_rt.value=sheetObj.GetCellValue(row, "trsp_rnd_rt");
		ComPostOpenWindow("ESD_TRS_0235.do", "OpenScg", "width=550,height=410,menubar=0,status=1,scrollbars=0,resizable=0");
		//formObject.target='OpenScg';
		//formObject.submit();
	}
}
 /**
 * Getting S/P info
 */
 function  vender_blur(){
 	var formObj=document.form;
 	var error_val="";
 	var lvobj=formObj.fm_vndr_prmry_seq.value;
 	if(lvobj !=""){
 		for (var i=0; i < lvobj.length; i++)
 		{
 			var oneChar=lvobj.charAt(i)
 			if (oneChar != "")
 			{
 				if (  (oneChar >= "0" && oneChar <= "9" )  ){
 				}else {
 					error_val="Y";
 					break;
 				}
 			}
 		}
 	}
 	if(error_val =="Y" ){
    	formObj.fm_vndr_prmry_seq.value = "";
 		return;
 	}
 	sheetObjects[0].RemoveEtcData();
 	formObj.f_cmd.value=SEARCH07;
 	var sXml = sheetObjects[0].GetSearchData("ESD_TRS_0220GS.do",TrsFrmQryString(formObj));
 	x1 = ComSearchEtcData(sheetObjects[0], "ESD_TRS_0220GS.do",TrsFrmQryString(formObj), 'VNDR_NM');
 	
 	if(x1 !="" && x1 != undefined){ //
 		formObj.fm_vndr_prmry_nm.value=x1;
 	}else{
 		formObj.fm_vndr_prmry_nm.value="";
 	}
 }
 /*
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick() {
	 var formObject=document.form;
	 var cmdt_cd_val="";   
	 var rep_cmdt_cd_val="";   
	 var cmdt_desc_val="";   
	 var classId="getCOM_ENS_rep";
	 var xx1="";  //CONTI
	 var xx2="";  //SUB CONTI
	 var xx3="";  //COUNTRY
	 var xx4="";  //STATE
	 var xx5="";  //CONTROL OFFIC
	 var xx6="";  //LOC CODE
	 var xx7="";  //LOC NAME
	 var xx8="";
	 var xx9="";
	 var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	 ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 699, 515, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
* Calling Service Provider popup : The case selecting one item at pop-up page
*/
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];
		formObj.fm_vndr_prmry_seq.value=colArray2;
		formObj.fm_vndr_prmry_nm.value=colArray4;
	}
}
/**
   * EVENT after inquiring
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet_main_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj=document.form;
	var cmd=formObj.f_cmd.value;
	var cur_page=formObj.cur_page_cnt.value;
	if( cmd == SEARCH01 && sheetObj.RowCount()> 0 && cur_page == "1") {
		var tot_cnt=sheetObj.GetEtcData('TOT_CNT');
    	formObj.tot_page_cnt.value=tot_cnt;
	}
}
/**
 *Reset
 */
function reset_all(){
	var formObject=document.form;
	formObject.tot_page_cnt.value="0";
	formObject.cur_page_cnt.value="1";
	sheetObjects[0].RemoveEtcData();
	sheetObjects[0].RemoveAll();
}
 /**
 * Onkeydown event
 */
 function gotopage(){
	 var formObject=document.form;
	 var tot_page="";
	 var cur_page="";
	 cur_page=formObject.cur_page_cnt.value;
	 tot_page=formObject.tot_page_cnt.value;
	 if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
		 var errMessage=ComGetMsg('TRS90351','','','');  
		 ComShowMessage(errMessage);
		 return;
	 }
	 doActionIBSheet(sheetObjects[0],formObject,"IBSEARCH"); 
 }
//UI 표준화관련 하단 여백 설정
function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
}

/**
 * Tool Tip
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 */
function sheet_main_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj = document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_nod_cd" :
		case "via_nod_cd" :
		case "to_nod_cd" :
		case "dor_nod_cd" :	
			setYdNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
			break;
		default : break;	
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param formObj
 */
function setYdNameToolTip(sheetObj, Row, Col, formObj) {
	var ydValue = sheetObj.GetCellValue(Row, Col);
	if(!ComIsNull(ydValue)) {
		var isYard = "Y"; // yard : Y, location : N
		if(ydValue.length == 5) { 
			isYard = "N"; 
		}
		sheetObj.SetToolTipText(Row, Col, GetYardName(sheetObj, formObj, ydValue, isYard));
	} else {
		sheetObj.SetToolTipText(Row, Col, "");
	}
}