/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0227.js
*@FileTitle  : Agreement Rate History Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/**
 * Define the initial values and headers of sheets
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject=sheetObjects[0];
  var cnt=0;
  switch(sheetNo) {
  case 1: //sheet0 init
	    with(sheetObj){
		    var HeadTitle1="Seq|Equipment|No of\nChassis|Weight\nTier|UOM|Rank|Effective Date|Effective Date|Currency|Rate|Rate|Feeder Term|Feeder Term|Reverse|COA|Route|Route|Route|Route|Update\nDate|Update\nUser|Delete Y/N" ;
		    var HeadTitle2="Seq|Equipment|No of\nChassis|Weight\nTier|UOM|Rank|From|To|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|Reverse|COA|From|Via|Door|To|Update\nDate|Update\nUser|Delete Y/N" ;
		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:6 } );
		    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		    var headers = [ { Text:HeadTitle1, Align:"Center"},
		                { Text:HeadTitle2, Align:"Center"} ];
		    InitHeaders(headers, info);
		    var cols = [ 
		           {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"seq_no",                 KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		           {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"trsp_agmt_eq_tp_sz_cd",  KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		           {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"trsp_agmt_bdl_qty",      KeyField:0,  CalcLogic:"",  Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		           {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"to_wgt",                 KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		           {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"wgt_meas_ut_cd",         KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,  SaveName:"rk",                     KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		           {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"eff_fm_dt",              KeyField:0,  CalcLogic:"",  Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		           {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"eff_to_dt",              KeyField:0,  CalcLogic:"",  Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		           {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"curr_cd",                KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		           {Type:"Float",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"trsp_one_wy_rt",         KeyField:0,  CalcLogic:"",  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		           {Type:"Float",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"trsp_rnd_rt",            KeyField:0,  CalcLogic:"",  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"wtr_rcv_term_cd",        KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"wtr_de_term_cd",         KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		           {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"trsp_rnd_aply_flg",      KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                   {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,  SaveName:"agmt_cost_flg",          KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
		           {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"fm_nod_cd",              KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		           {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"via_nod_cd",             KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		           {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"dor_nod_cd",             KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		           {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"to_nod_cd",              KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		           {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,  SaveName:"upd_dt",                 KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		           {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"upd_usr_id",             KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		           {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"delt_flg",               KeyField:0,  CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 } ];
		     
		    InitColumns(cols);
		    SetRangeBackColor(1,6,1,7,"#555555");
		    SetRangeBackColor(1,9,1,12,"#555555");
		    SetRangeBackColor(1,15,1,18,"#555555");
		    SetEditable(0);
		    SetSheetHeight(325);
          }
  break;
  }
}

/**
* Setting sheets and initialization 
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); 
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); 
	}
}

/* General global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
var Mincount=0;

function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
   try {
       var srcName=ComGetEvent("name");
       if(ComGetBtnDisable(srcName)) return false;
       switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			case "btn_minimize":
				Mincount=(Mincount+1)%2;
				Minimize(Mincount);
			break;
			case "btn_creation":
				openAgmtHdrPopup();
			break;
			case "btn_rowadd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;
			case "btn_delete":
			break;
			case "btn_save":
			break;
			case "btn_rowadd":
			break;
			case "btng_fileselect":
				document.all.btng_verify2.disabled=true;
				doActionIBSheet(sheetObjects[1],formObject,IBLOADEXCEL);
			break;
			case "btng_delete":
			break;
			case "btng_reset":
			  reset_all();
			break;
			case "btng_verify":
			break;
			case "btng_update":
			    update(formObject);
			break;
			case "btng_downexcel":
			  var sheet2_count=sheetObjects[1].RowCount();
			  if(sheet2_count > 0){
			    doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
			  }
			break;
			case "btng_provider":
			rep_OnPopupClick();
			break;
       }
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
       } else {
			ComShowMessage(e.message);
       }
   }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
	var x1="";
	switch(sAction) {
	case IBSEARCH:
		formObj.f_cmd.value=SEARCH01;
 		sheetObj.DoSearch("ESD_TRS_0227GS.do", TrsFrmQryString(formObj) );
		break;
	}
}

/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

function openAgmtHdrPopup() {
	var formObject=document.form;
	var Option="width=724,height=290,menubar=0,status=0,scrollbars=0,resizable=0";
	var agmt_no=formObject.fm_agmtno.value;  
	var agmt_no="";
	var param="?agmt_no="+agmt_no;
	window.open('/opuscntr/ESD_TRS_0220.do' + param, "popup", Option);
}

/**
 * Loading the list of external combo box
 */
 function getComboList(obj, comObj, sep) { 
 	var formObj=document.form;
 	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
 	obj.value=lvobj;
 	if( lvobj == "" ) {
 		obj.value="";
 		comObj.RemoveAll();
 		return false;
 	} else if( lvobj.length != 5 ) {
 		errMsg=ComGetMsg("TRS90074");
 		ComShowMessage(errMsg);
 		obj.focus();
 		return false;
 	}
 	if( !dohancheck(lvobj) ) {
 		obj.value="";
 		comObj.RemoveAll();
 		obj.focus();
 		return false;
 	}
 	if( sep == 'F' ) {
 		formObj.TRSP_SO_EQ_KIND.value="";
 		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 		formObj.fm_fm_nod_yd.value=fm_nod_yd;
 	} else if( sep == 'V' ) {
 		formObj.TRSP_SO_EQ_KIND.value="";
 		lvViaNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	} else if( sep == 'T' ) {
 		formObj.TRSP_SO_EQ_KIND.value="A";
 		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	} else if( sep == 'D' ) {
 		formObj.TRSP_SO_EQ_KIND.value="";
 		lvDoorLoc=getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
 	}
 	comObj.focus();
 }
 
 /**
 * Resizing sheet
 */
function Minimize(nItem) {
	var objs=document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display="none";
	} else {
		objs.style.display="inline";
	}
}

/**
 * Tool Tip
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 */
function sheet0_OnMouseMove(sheetObj, Button, Shift, X, Y) {
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
