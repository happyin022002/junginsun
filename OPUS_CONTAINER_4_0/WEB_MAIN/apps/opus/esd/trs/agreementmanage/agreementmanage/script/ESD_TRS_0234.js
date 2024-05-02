/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0234.jsp
*@FileTitle  : Agreement Rail Surcharge History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
/**
 * Define the initial values and headers of sheets
 * European S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject=sheetObjects[0]; 
  var cnt=0;
  switch(sheetNo) {
  	case 1: //sheet0 init ( Child S/P )
	  with (sheetObj) {        
        var HeadTitle1="Seq|Agreement\nNo|Rail Company|Rail Company|Surcharge\nKind|Route|Route|Route|Cargo\Type|Ratio(%)|Effective Date|Effective Date|Decimal|Over Weight\n(LBS)|Amount|Amount|Amount|Amount|Amount|FSC\nApply|Delete" ;
        var HeadTitle2="Seq|Agreement\nNo|Code|Name|Surcharge\nKind|All|ORG|DEST|Cargo\Type|Ratio(%)|From|To|Decimal|Over Weight\n(LBS)|Cur|All|20'|40'|45'|FSC\nApply|Delete" ;

        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rail_scg_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
            {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_rout_all_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
            {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rail_rto",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
            {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rail_rto_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
            {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lbs_ovr_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
            {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fx_scg_all_rt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
            {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fx_scg_20ft_rt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:15 },
            {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fx_scg_40ft_rt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
            {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fx_scg_45ft_rt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fuel_scg_aply_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
         
        InitColumns(cols);
        SetSheetHeight(ComGetSheetHeight(sheetObj,10));
        SetEditable(1);       
        SetRangeBackColor(1,0,1,19,"#555555");
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
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH, "Popup");

	getComboList(formObject.fm_fm_nod_cd, formObject.fm_fm_nod_yd, 'F');
    getComboList(formObject.fm_to_nod_cd, formObject.fm_to_nod_yd, 'T');
}
/*------------------ Defining general java script function   ------------------*/
/* General global variable */
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
   try {
       var srcName=ComGetEvent("name");
       switch(srcName) {
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject,formObject,IBSEARCH, "Retrieve");					
				}									
			break;
			case "btng_close":
				ComClosePopup(); 
    	        break;
			break;
			case "btn_frmnode": //FromNode Popup
				openHireYardPopup('getFromNode');
			break;
			case "btn_tonode": //ToNode Popup
				openHireYardPopup('getToNode');
			break;
			case "btng_calendar":
				getCalendar();
			break;
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
       } else {
			ComShowMessage(e.message);
       }
   }
}
function doActionIBSheet(sheetObj,formObj,sAction,srcName) {
    sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
    switch(sAction) {       
       case IBSEARCH:    	   
    	   switch(srcName) {
    	   		case "Retrieve":
    	   			formObj.f_cmd.value=SEARCH01;
    	   			sheetObj.DoSearch("ESD_TRS_0234GS.do", TrsFrmQryString(formObj) );
    		    break;
    	   		case "Popup":
    	   			formObj.f_cmd.value=SEARCH02;
    	   			sheetObj.DoSearch("ESD_TRS_0234GS.do", TrsFrmQryString(formObj) );
    		    break;
    	   }
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
/**
 * Loading the list of external combo box
 */
 function getComboList(obj, comObj, sep) { //object, value receiving part, kind of Node
	comObj = eval(comObj.id); 
 	var formObj=document.form;
 	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
 	obj.value=lvobj;
 	if( lvobj == "" ) {
 		obj.value="";
 		comObj.RemoveAll();
 		return false;
 	}
 	if( sep == 'F' ) {
 		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	} else if( sep == 'T' ) {
 		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	}
// 	comObj.focus();
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
 	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
 	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
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
  	formObject.fm_fm_nod_cd.value=lvLoc;
  	getYardCombo(fm_fm_nod_yd, sheetObjects[0], formObject, lvLoc);
  	document.form.fm_fm_nod_yd.CODE=lvYard;
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
  	formObject.fm_to_nod_cd.value=lvLoc;
  	getYardCombo(fm_to_nod_yd, sheetObjects[0], formObject, lvLoc);
  	document.form.fm_to_nod_yd.CODE=lvYard;
  }
  /*
   * Multi-Calendar input Pop-Up
   */
  function getCalendar() {
  	var cal=new ComCalendarFromTo();
  	cal.displayType="date";
  	cal.select(document.form.fm_eff_fm_dt1, document.form.fm_eff_to_dt1, 'yyyy-MM-dd');
  }
  /**
   * validating
   */
  function validateFormSearch(formObj){
		var lvFmEff=ComTrimAll(ComTrimAll(formObj.fm_eff_fm_dt1.value, " "), "-");
		var lvToEff=ComTrimAll(ComTrimAll(formObj.fm_eff_to_dt1.value, " "), "-");
		var lvFmNode=ComTrimAll(formObj.fm_fm_nod_cd.value, " ");
		var lvToNode=ComTrimAll(formObj.fm_to_nod_cd.value, " ");
		if( lvFmEff != "" ) { //The part of checking the date
			if( !ComIsDate(lvFmEff) ) {
				errMsg=ComGetMsg("TRS90070");
				ComShowMessage(errMsg);
				formObj.eff_dt.focus();
				return false;
			}
		}
		if( lvToEff != "" ) { //The part of checking the date
			if( !ComIsDate(lvToEff) ) {
				errMsg=ComGetMsg("TRS90070");
				ComShowMessage(errMsg);
				formObj.eff_dt.focus();
				return false;
			}
		}
		if( lvFmNode == "" && lvToNode == "" && !formObj.routeAll.checked ) {
			errMsg=ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
		if( lvFmNode == "" ) { 
			formObj.fm_fm_nod_cd.value="";
			fm_fm_nod_yd.RemoveAll(); // Removing combo data
		}
		if( lvToNode == "" ) { //To Node
			formObj.fm_to_nod_cd.value="";
			fm_to_nod_yd.RemoveAll(); // Removing combo data
		}
		formObj.hid_fm_eff_fm_dt1.value=lvFmEff; //From Effective Date
		formObj.hid_fm_eff_to_dt1.value=lvToEff; //to Effective Date
		formObj.fm_fm_nod_cd.value=lvFmNode.toUpperCase();
		formObj.fm_fm_nod_yd.value=lvToNode.toUpperCase();
		return true;
  }
  function fun_allRoute(){
		if(document.form.routeAll.checked == true){
			document.form.routeAll.value="Y";
		}		
	}
