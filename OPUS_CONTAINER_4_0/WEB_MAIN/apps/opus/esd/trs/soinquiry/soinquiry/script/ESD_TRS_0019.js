/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0019.js
*@FileTitle  :  SO Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04

=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/	  
/**
* @extends 
* @class ESD_TRS_0019 : business script for ESD_TRS_0019
*/
function ESD_TRS_0019() {
    this.processButtonClick=processButtonClick;
    this.setSheetObject=setSheetObject;
    this.setComboObject=setComboObject;
    this.setTabObject=setTabObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;        
    this.initControl=initControl;
    this.initTab=initTab;
    this.doActionIBSheet=doActionIBSheet;
    this.validateForm=validateForm;
}
var prefix='surcharge_';
var sheetObjects=new Array();
var sheetCnt=0;
var ctMode=0; 
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				// If you do not have DATE VVD, BKG, BL, EQ, SO, WO, INV, COP No One should be.
				if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
					if ( (ComIsNull(formObject.trunk_vvd) || ComIsEmpty(formObject.trunk_vvd))
						&& (ComIsNull(formObject.bkgnumber) || ComIsEmpty(formObject.bkgnumber))
						&& (ComIsNull(formObject.blnumber) || ComIsEmpty(formObject.blnumber))
						&& (ComIsNull(formObject.eqnumber) || ComIsEmpty(formObject.eqnumber))
						&& (ComIsNull(formObject.sonumber) || ComIsEmpty(formObject.sonumber))
						&& (ComIsNull(formObject.wonumber) || ComIsEmpty(formObject.wonumber))
						&& (ComIsNull(formObject.invoicenumber) || ComIsEmpty(formObject.invoicenumber))
						&& (ComIsNull(formObject.copnumber) || ComIsEmpty(formObject.copnumber))
						&& (ComIsNull(formObject.mtyrefnumber) || ComIsEmpty(formObject.mtyrefnumber))
						) 
					{
						ComShowCodeMessage("TRS90124");
						return false;
					}
				}
				// If you do not have office VVD, BKG, BL, EQ, SO, WO, INV, COP No One should be.
				if (ComIsNull(formObject.input_office) || ComIsEmpty(formObject.input_office)) {
					if ( (ComIsNull(formObject.trunk_vvd) || ComIsEmpty(formObject.trunk_vvd))
						&& (ComIsNull(formObject.bkgnumber) || ComIsEmpty(formObject.bkgnumber))
						&& (ComIsNull(formObject.blnumber) || ComIsEmpty(formObject.blnumber))
						&& (ComIsNull(formObject.eqnumber) || ComIsEmpty(formObject.eqnumber))
						&& (ComIsNull(formObject.sonumber) || ComIsEmpty(formObject.sonumber))
						&& (ComIsNull(formObject.wonumber) || ComIsEmpty(formObject.wonumber))
						&& (ComIsNull(formObject.invoicenumber) || ComIsEmpty(formObject.invoicenumber))
						&& (ComIsNull(formObject.copnumber) || ComIsEmpty(formObject.copnumber))
						&& (ComIsNull(formObject.mtyrefnumber) || ComIsEmpty(formObject.mtyrefnumber))
						) 
					{
						ComShowCodeMessage("TRS90124")+"\n 'Office Code'";
						return false;
					}
				}
				if(!TrsComValidFormat("WO", formObject.wonumber.value, true)) { return false; }
				if(!TrsComValidFormat("SO", formObject.sonumber.value, true)) { return false; }
				
				var chk_usrail=formObject.chk_usrail.checked;
				if( chk_usrail  ){
					var afterToDate  = ComGetDateAdd(formObject.from_date, "d","15", "");
					var days_between=ComGetDaysBetween(afterToDate, formObject.to_date) ;  // Inquiry Period
					if ( days_between > 0 ){
						if((ComIsNull(formObject.search_fm_loc) || ComIsEmpty(formObject.search_fm_yard) || ComIsNull(formObject.search_to_loc) || ComIsEmpty(formObject.search_to_yard)) && ComIsEmpty(formObject.search_fm_node))	{
							ComShowCodeMessage("TRS90431");
							return false;
						}
					}
				} else {
					var afterToDate  = ComGetDateAdd(formObject.from_date, "M", 1, "");
					var days_between=ComGetDaysBetween(afterToDate, formObject.to_date) ;  // Inquiry Period
					if ( days_between >= 0 ) {
						ComShowCodeMessage("TRS90424");
						return false;
					}
				}

				if(ComGetObjValue(document.form.port_io) != "A" && document.form.port_cd.value == "") {
			    	ComShowCodeMessage("TRS90410", "Port Code");
					return false;
				}
				
				doActionIBSheet(sheetObject,formObject,IBSEARCH, 'RTV');
			break;
			case "btn_reset":
				sheetObject.RemoveAll();
				search_fm_yard.RemoveAll();
				search_via_yard.RemoveAll();
				search_to_yard.RemoveAll();
				search_door_yard.RemoveAll();
				formObject.reset();
				formObject.input_office.value = formObject.cre_ofc_cd.value;
			break;
			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none") {
					document.all.MiniLayer.style.display="none";
				} else {
					document.all.MiniLayer.style.display="";
				}
				ComResizeSheet(sheetObjects[0]);
			break;
			case "btns_calendar1":
				var cal=new ComCalendar();
				cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
			break;
			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL, "");
			break;
			case "btns_frmnode": //FromNode Popup Window
				openHireYardPopup('getFromNode');
			break;
			case "btns_vianode": //ViaNode Popup Window
				openHireYardPopup('getViaNode');
			break;
			case "btns_tonode": //ToNode Popup Window
				openHireYardPopup('getToNode');
			break;
			case "btns_dorloc": //DoorLocation Popup Window
				openHireYardPopup('getDorLoc');
			break;
			case "btns_calendar":
				getCalendar();
			break;
			case "btng_provider":
				rep_OnPopupClick();
			break;
			case "btns_office": //M CNTR
				if( validation_check() ) {
					var ofc_cd=formObject.input_office.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'OpneHistoryWin', 'top=200, left=200, width=600, height=370, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				}
			break;
			case "btn_close":
				ComClosePopup(); 
    	    break;
			case "btns_multi_search_fm_node": {
				so_OnPopupClick('FM_NODE');
				break;
			}
			case "btns_multi_search_to_node": {
				so_OnPopupClick('TO_NODE');
				break;
			}
			case "btns_port":
				var sUrl="/opuscntr/ESD_TRS_0981.do?port_cd=" + formObject.port_cd.value;
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
			break;
			case "btng_frustrate":
				setFrustrate();
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Frustrate Flag
 **/
function setFrustrate() {
	var sRow  = sheetObjects[0].FindCheckedRow("part");
	if(sRow == '' ) {
		ComShowCodeMessage("COM12189");
		return false;
	}
	var resultFlg = true;
	var arrRow = sRow.split("|");
	for(var idx=0; idx<arrRow.length; idx++) {
		if(sheetObjects[0].GetCellValue(arrRow[idx], 'cgo_tp_cd') != "F") {
			resultFlg = false;
			ComShowCodeMessage("TRS90310");
			break;
		}
		if(sheetObjects[0].GetCellValue(arrRow[idx], 'so_del_flg') == "Y") {
			resultFlg = false;
			ComShowCodeMessage("TRS90490");
			break;
		}
		if(sheetObjects[0].GetCellValue(arrRow[idx], 'trsp_frst_flg') == "Y") {
			resultFlg = false;
			ComShowCodeMessage("TRS90491");
			break;
		}
		if(sheetObjects[0].GetCellValue(arrRow[idx], 'upln_so_flg') == "Y") {
			resultFlg = false;
			ComShowCodeMessage("TRS90492");
			break;
		}
	}
		if(resultFlg) {
		if(ComShowCodeConfirm('TRS90489')) {
			var chk_usrail=document.form.chk_usrail.checked;
			if(chk_usrail) {
			    document.form.f_cmd.value = MULTI03;
			    sheetObjects[0].DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(document.form), 'part', false);				
			} else {
			    document.form.f_cmd.value = MULTI01;
			    sheetObjects[0].DoSave("ESD_TRS_0023GS.do", TrsFrmQryString(document.form), 'part', false);				
			}
		}
	}
}

/**
* Common Trunk VVD popup
*/
function openMultipleinquiry(obj, obj2) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var classId="getTRS_ENS_906";
	var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title+"&pgmNo=ESD_TRS_0019";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 415, "getTRS_ENS_906", '0,1', true);
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComEnableObject(document.form.port_cd, false);
	document.form.btns_port.style.visibility="hidden";
	initControl();
}

/**
	* HTML Control on the page is dynamically loaded into the event. <br>
 **/
function initControl() {
	  axon_event.addListenerFormat('change',    'obj_change',     form);
	  if( !ComIsNull(sowonumber) ) {
		  document.form.sonumber.value = sowonumber;
		  document.form.input_office.value="";
		  if(!ComIsNull(railflg) && railflg == 'Y') {
			  document.form.chk_usrail.checked = true;
		  }
		  usrailOnly(document.form.chk_usrail);
		  retriveSo();
	  }
}
/**
 * Validation of HTML Control will check in onchange event. <br>
 **/
function obj_change(){
   var formObj=document.form;
   try {
       var srcName=ComGetEvent("name");
        switch(srcName) {
           case "port_cd":
               if(formObj.port_cd.value.length == 5){
                   doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
               } else if(formObj.port_cd.value.length == 0){
               	 formObj.port_cd.value = '';
               	 formObj.port_nm.value = '';
               } else {
               	ComShowCodeMessage("COM130402", "Port");
              	 formObj.port_cd.value = '';
              	 formObj.port_nm.value = '';
              	 formObj.port_cd.focus();
               }
               break;
        } 
   }catch(e) {
       if( e == "[object Error]") {
           ComShowMessage(OBJECT_ERROR);
       } else {
           ComShowMessage(e.message);
       }
   }
}
/**
 * Validation of HTML Control will check in onclick event. <br>
 **/
function port_io_click(obj){
	  var formObject = document.form;
	 if(obj.checked && obj.value == "A") {
		 formObject.port_cd.value = "";
		 formObject.port_nm.value = "";
		 ComEnableObject(formObject.port_cd, false);
		 formObject.btns_port.style.visibility="hidden";
	 } else {
		 ComEnableObject(formObject.port_cd, true);
		 formObject.btns_port.style.visibility="visible";
	 }
}

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0; 
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
			      var HeadTitle="Status||Seq.|EQ No.|TP/SZ|Org TP/SZ|Slot Ref No.|Cost Mode|Trans Mode|S/O TP|Unplanned|Frustrated|S/O No.|S/O CRE DT|S/O DEL|" +
			      "S/O DEL DT|S/O UPD ID|W/O No.|W/O Iss STS|W/O Iss DT|W/O ISS TP|W/O ISS OFC|W/O ISS ID|From|From|Via|Via|To|To|" +
			      "Door|Door|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|W/O S/P|W/O S/P|W/O S/P|Parent S/P|Parent S/P|Appt. Time|Deliv. Time|" +
			      "3rd Party|Cost OFC|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Calculation\nLogic|" +
			      "Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|Invoice S/P|Invoice S/P|Invoice No.|Reference No|INV STS|INV CNFM\nDT|CSR No.|" +
			      "INV OFC|INV User|Estimated Time|Estimated Time|Estimated Time|Estimated Time|COP No.|A/G SEQ|A/G Code|BKG No.|BL No.|BND|Term|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|BKG QTY|POR|POR|POL|POL|POD|POD|DEL|DEL|" +
			      "T.VVD|Lane|In VVD|Out VVD|CGO TP|BKG CGO SPE|Used|L/T|I.Exit|L/T EXP|Seal No.1|Seal No.2|";
			      
			      HeadTitle+= "VGM Weight\n(KGS)|VGM Weight\n(LBS)|Weight\n(KGS)|Weight\n(LBS)|No of PKG|PKG CD|Commodity DESC|C.LOC|USA Last City|F|O|C|IT No|" +
			      "Pickup No.|PU Yard|Available DT|Last Free DT|S/C No.|RFA No.|Door SVC TP|Shipper|Consignee|Notify|Ref.BKG No|" +
			      "Ref.BL No|Outgate Date|Ingate Date|MTY Reference No|Reason|Internal\nRemark|Special Instruction|W/O Instruction|CHZ Bundle|" +
			      "From(ID)|From(ID)|To|To|To|MT Info.|MT Info.|WEB M'ty|Grace End" ;
			      
			      var HeadTitle1="Status||Seq.|EQ No.|TP/SZ|Org TP/SZ|Slot Ref No.|Cost Mode|Trans Mode|S/O TP|Unplanned|Frustrated|S/O No.|S/O CRE DT|S/O DEL|" +
			      "S/O DEL DT|S/O UPD ID|W/O No.|W/O Iss STS|W/O Iss DT|W/O ISS TP|W/O ISS OFC|W/O ISS ID|From|From|Via|Via|To|To|" +
			      "Code|Name|Factory Name|Zip Code|Address|TEL|FAX|PIC|Type|Code|Name|Code|Name|Appt. Time|Deliv. Time|" +
			      "3rd Party|Cost OFC|Currency|Basic|Negotiated|Fuel|Additional|HZD|OVR|Usa Rail Surcharge|Total|W/O Amount Total(USD)|Exchange\nRate|Calculation\nLogic|" +
			      "Currency|Basic|Surcharge|Total|Invoice Amount Total(USD)|Code|Name|Invoice No.|Reference No|INV STS|INV CNFM\nDT|CSR No.|" +
			      "INV OFC|INV User|From Departure|To Arrival|Door Arrival|TRO Door Date|COP No.|A/G SEQ|A/G Code|BKG No.|BL No.|BND|Term|SEQ|CNFM|Office|User ID|Time|Rev Curr|Rev Amt|Manifested|Load Ref No|BKG QTY|POR|POR|POL|POL|POD|POD|DEL|DEL|" +
			      "T.VVD|Lane|In VVD|Out VVD|CGO TP|BKG CGO SPE|Used|L/T|I.Exit|L/T EXP|Seal No.1|Seal No.2|" ;
			      HeadTitle1+= "VGM Weight\n(KGS)|VGM Weight\n(LBS)|Weight\n(KGS)|Weight\n(LBS)|No of PKG|PKG CD|Commodity DESC|C.LOC|USA Last City|F|O|C|IT No|" +
			      "Pickup No.|PU Yard|Available DT|Last Free DT|S/C No.|RFA No.|Door SVC TP|Shipper|Consignee|Notify|Ref.BKG No|" +
			      "Ref.BL No|Outgate Date|Ingate Date|MTY Reference No|Reason|Internal\nRemark|Special Instruction|W/O Instruction|CHZ Bundle|" +
			      "Date|Yard|Date|Yard|Status|Date|Yard|WEB M'ty|Grace End" ;
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 ,FrozenCol:7} );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 
			             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
			             {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"part",                  KeyField:0 },
			             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_eq_tpsz",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_slt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upln_so_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"trsp_frst_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"so_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"so_cre_dt1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"so_del_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"so_del_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"wo_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_iss_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"wo_iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wo_iss_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_iss_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wo_iss_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"door",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"door_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"door_fctry_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"door_zip",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"dor_de_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"door_tel",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"door_fax",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"door_pic",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pvndr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"pvndr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"appt_time",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"deliv_time",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wo_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_bzc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_nego_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_fuel_scg_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_etc_add_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_hzd_mtrl_scg_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_ovr_wgt_scg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_usa_ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"wo_tot_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:160,  Align:"Right",   ColMerge:1,   SaveName:"wo_tot_amt_usd",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"inv_calc_lgc_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"inv_etc_add_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"inv_tot_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:160,  Align:"Right",   ColMerge:1,   SaveName:"inv_tot_amt_usd",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_vndr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_cfm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"car_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_cfm_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dor_nod_pln_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dor_arr_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"term",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_cnfm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_ofc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_usr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_upd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tro_rev_cur",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eur_tro_rev",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"manifested",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tro_lod_ref",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bkg_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"t_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ib_vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ob_vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_spe",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"used",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"i_exit",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lt_exp",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"seal_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"seal_no2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"right",   ColMerge:1,   SaveName:"vgm_kgs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"right",   ColMerge:1,   SaveName:"vgm_lbs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },			             
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"right",   ColMerge:1,   SaveName:"weight_kgs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"right",   ColMerge:1,   SaveName:"weight_lbs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"no_pkg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pkg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"c_loc",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_last_city",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"o",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"c",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"it_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pickup_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pu_yard_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"available_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"last_free_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"door_svc_tp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shipper",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"consignee",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"notify",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"org_gate_out_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dest_gate_in_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mty_ref_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_purp_rsn",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"spcl_instr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"wo_instr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"chz_bundle_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_yd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_yd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_sts",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mt_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mt_yd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"web_mt_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"grace_end",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"trsp_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"trsp_wo_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"conti_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetColProperty("so_cre_dt1", {Format:"####-##-####:##:##"} );
			      SetColProperty("so_del_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("wo_iss_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("appt_time", {Format:"####-##-####:##:##"} );
			      SetColProperty("deliv_time", {Format:"####-##-####:##:##"} );
			      SetColProperty("available_dt", {Format:"####-##-##"} );
			      SetColProperty("last_free_dt", {Format:"####-##-##"} );
			      SetColProperty("wo_rcv_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("org_gate_out_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("dest_gate_in_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("tro_cfm_upd", {Format:"####-##-####:##:##"} );
			      SetColProperty("n1st_nod_pln_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("lst_nod_pln_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("dor_nod_pln_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty("dor_arr_dt", {Format:"####-##-####:##:##"} );
			      ComResizeSheet(sheetObj);
	      }
		break;
		case 2: //surcharge sheet
		    with(sheetObj){
			      var HeadTitle="ibflag|ibcheck|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|trsp_step_tp_cd" ;
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 
			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_step_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_mgst_tpsz_cd',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no_split',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_mgst_tpsz_cd',       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_dry_run_rlbl_pty_tp_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fne_cuz_desc',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fumg_cost_tp_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_mgst_tpsz_cd',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_insp_rf_pti_cstms_tp_cd', KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_knt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_cuz_desc',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_stop_loc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_grs_wgt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incrt_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scl_stop_plc_nod_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_sto_dys',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no_split',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetVisible(false);
	            }
		   break;
	}
}
/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction, obj) {
	switch(sAction) {
		case IBSEARCH:      
				if(search_fm_yard.GetSelectCode()!= '' || formObj.search_fm_loc.value != '') {
					formObj.hid_from_node.value=formObj.search_fm_loc.value+search_fm_yard.GetSelectCode();
				}else{
					formObj.hid_from_node.value='';
				}
				if(search_via_yard.GetSelectCode()!= '' || formObj.search_via_loc.value != '') {
					formObj.hid_via_node.value=formObj.search_via_loc.value+search_via_yard.GetSelectCode();
				}else{
					formObj.hid_via_node.value='';
				}
				if(search_to_yard.GetSelectCode()!= '' || formObj.search_to_loc.value != '') {
					formObj.hid_to_node.value=formObj.search_to_loc.value+search_to_yard.GetSelectCode();
				}else{
					formObj.hid_to_node.value='';
				}
				if(search_door_yard.GetSelectCode()!= '' || formObj.search_door_loc.value != '') {
					formObj.hid_door_node.value=formObj.search_door_loc.value+search_door_yard.GetSelectCode();
				}else{
					formObj.hid_door_node.value='';
				}
			var sp_tp=checkParaminput(formObj.sp_tp);
			formObj.hid_from_date.value=removeBar(formObj.from_date.value);
			formObj.hid_to_date.value=removeBar(formObj.to_date.value);
			formObj.hid_provider.value=formObj.combo_svc_provider.value;
			formObj.hid_provider_type.value=sp_tp;
			formObj.f_cmd.value=SEARCH01;
			    formObj.hid_grid_flg.value='Y';
				IBS_DoSearchSax(sheetObj, "ESD_TRS_0019GS.do", TrsFrmQryString(formObj));
		break;
		case IBDOWNEXCEL:        // excel down
			if(sheetObj.RowCount() < 1){//no data	
				ComShowCodeMessage("COM132501");
			}else{	
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}	
		break;
		case SEARCH01: // search port
			sheetObj.SetWaitImageVisible(0);
            var rXml=sheetObj.GetSearchData("ESD_TRS_0981GS.do", "f_cmd=" + SEARCH + "&loc_cd=" + formObj.port_cd.value);
			var result = ComGetEtcData(rXml,'TRANS_RESULT_KEY');
			if(result == "S") {
				formObj.port_nm.value = ComGetEtcData(rXml,'PORT_NAME');
			}else {
            	ComShowCodeMessage("COM130402", "Port");
            	formObj.port_cd.value = "";
            	formObj.port_nm.value = "";
           	 	formObj.port_cd.focus();
			}
			sheetObj.SetWaitImageVisible(1);
			break;
	}
}
/**
 * sheet1_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {	 
//	if ( sheetObj.SearchRows()> 1999 ){   //2000 Row for more than part of the message output
//		ComShowCodeMessage("TRS90362");
//	} else {
		// 2015.05.19 CHAN WOO PARK
        // Empty Repo인 경우 Internal Remark를 입력할 수 없도록 수정
		var rows = sheetObj.HeaderRows() + sheetObj.RowCount();
        for(var row = sheetObj.HeaderRows(); row < rows; row++) {
//    		var formObj = document.form;
    		var trsp_so_tp_cd = sheetObj.GetCellValue(row, "trsp_so_tp_cd");
    		
    		if (trsp_so_tp_cd == "MT REPO") { // Empty S/O인 경우
    			sheetObj.SetCellEditable(row, "inter_rmk", 0); // inter_rmk 팝업 비활성화
//    			sheetObj.SetCellValue(row, "inter_rmk", "N/A"); // inter_rmk N/A로 표시
//    		} else {
//    			sheetObj.SetCellEditable(row, "inter_rmk", 1);
    		}
    		
    		// 2015.11.16	CHAN WOO PARK
    		// W/O Additional Surcharge 표기법 변경
    		// 1) JPY, KRW, TWD : 정수 표시
    		// 2) Other currency : 소수점 표시
//    		if(sheetObj.GetCellValue(i, 'wo_curr_cd') == 'JPY' || sheetObj.GetCellValue(i, 'wo_curr_cd') == 'KRW' || sheetObj.GetCellValue(i, 'wo_curr_cd') == 'TWD') {
//    			sheetObj.SetCellValue(row, 'wo_etc_add_amt', chkAmtPos_JPY(sheetObj.GetCellValue(row, 'wo_etc_add_amt')),0);
//    		} else {
//    			sheetObj.SetCellValue(row, 'wo_etc_add_amt', chkAmtPos(sheetObj.GetCellValue(row, 'wo_etc_add_amt')), 0);
//    		}
    		
    		// 2015.11.16	CHAN WOO PARK
    		// Invoice Additional Surcharge 소수점 표기되도록 수정
    		// 1) JPY, KRW, TWD : 정수 표시
    		// 2) Other currency : 소수점 표시
//    		if(sheetObj.GetCellValue(i, 'inv_curr_cd') == 'JPY' || sheetObj.GetCellValue(i, 'inv_curr_cd') == 'KRW' || sheetObj.GetCellValue(i, 'inv_curr_cd') == 'TWD') {
//    			sheetObj.SetCellValue(row, 'inv_etc_add_amt', chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_etc_add_amt')),0);
//    		} else {
//    			sheetObj.SetCellValue(row, 'inv_etc_add_amt', chkAmtPos(sheetObj.GetCellValue(row, 'inv_etc_add_amt')), 0);
//    		}
        } // end for
//	}
}
function sheet1_OnSaveEnd(sheetObj,errMsg) {
	var formObj=document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		var checkList=sheetObj.FindCheckedRow('part');
		var checkArray=checkList.split('|');
		if(formObj.f_cmd.value == MULTI01 || formObj.f_cmd.value == MULTI03){
			for(var i=0; i<checkArray.length; i++){
				sheetObj.SetCellValue(checkArray[i], 'trsp_frst_flg','Y',0);
				sheetObj.SetCellValue(checkArray[i], 'upd_usr_id',formObj.upd_usr_id.value  ,0);
			}
			ComShowCodeMessage('COM12156', 'Frustrate');
		}
	}
}
function sheet1_OnPopupClick (sheetObj , row , col )
{
	var colName=sheetObj.ColSaveName(col);
	var value=sheetObj.GetCellValue(row, colName);
	switch(colName)
	{
		case('n3pty_bil_flg'):
			pop3rdPartyBilling(sheetObj, row, col, 'search');
		break;
		case('wo_etc_add_amt'):
			// TODO S/O Inquiry 화면에서 Surcharge 팝업을 조회할 경우 수정할 것(CSR 요청들어오면 작업 진행할 것 FROM 박찬우)
			//if (sheetObj.GetCellValue(row, "trsp_so_tp_cd") != "RAIL BILLING") {
				popSurchargeInputInquiry(sheetObj, row, col, 'search','WO');
			//}
		break;
		case('inv_etc_add_amt'):
			if (sheetObj.GetCellValue(row, "trsp_so_tp_cd") != "RAIL BILLING") {
				popSurchargeInputInquiry(sheetObj, row, col, 'search','IV');
			}
		break;
		case('bkg_spe'):
			var myOption="top=200, left=200, width=900, height=420, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0";

		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var lvtro_seq=sheetObj.GetCellValue(row, "tro_seq");
		var lvui_conti_cd=sheetObj.GetCellValue(row, "conti_cd");
		if( sheetObj.GetCellValue(row, "bkg_spe") == 'DG' ) {
				var url="ESD_TRS_0938Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				 ComOpenWindow(url,  "openSpeCgoWin",  myOption);
		} else if( sheetObj.GetCellValue(row, "bkg_spe") == 'BB' ) {
				var url="ESD_TRS_0937Pop.do?bkg_no="+lvbkg;
				 ComOpenWindow(url,  "openSpeCgoWin",  myOption);
		} else if( sheetObj.GetCellValue(row, "bkg_spe") == 'AK' ) {
				var url="ESD_TRS_0936Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				 ComOpenWindow(url,  "openSpeCgoWin",  myOption);
		} else if( sheetObj.GetCellValue(row, "bkg_spe") == 'RF' ) {
				var url="ESD_TRS_0935Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				 ComOpenWindow(url,  "openSpeCgoWin",  myOption);
			}
		break;
		case('inter_rmk'):
			var lvbkg = sheetObj.GetCellValue(row, "bkg_no");
			var lveqno = sheetObj.GetCellValue(row, "eq_no");
			var url = "ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&inter_rmk_cd=I";
			ComOpenWindowCenter(url, "compopup", 1000, 570, true);
			break;
	}
}

/**
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @returns
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj=document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_nod_cd" :
		case "via_nod_cd" :
		case "to_nod_cd" :
			if(ComIsNull(sheetObj.GetToolTipText(mouseRow, mouseCol))) {
				sheetObj.SetToolTipText(mouseRow, mouseCol, sheetObj.GetCellValue(mouseRow, colSaveName + "_nm"));
			}
			break;
		case "por_cd" :
		case "pol_cd" :
		case "pod_cd" :
		case "del_cd" :
			if(ComIsNull(sheetObj.GetToolTipText(mouseRow, mouseCol))) {
				sheetObj.SetToolTipText(mouseRow, mouseCol, sheetObj.GetCellValue(mouseRow, colSaveName + "_nm"));
			}
			break;
		default : break;	
	}	
}
/**
* enter check
**/
function enterCheck(obj) {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if(event.keyCode == 13) {
		switch(ComGetEvent("name")){
			case 'combo_svc_provider': {
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}
}
function fun_Focus(obj){
	obj.select();
}

function fun_Focus_del(obj){
	var val=removeBar(obj.value);
	obj.value=val;
	obj.select();
}

function removeBar(str) {
	var value="";
	for ( var i=0; i < str.length; i++ ) {
		var ch=str.charAt(i);
		if ( ch != '-' ) value=value + ch;
	}
	return value;
}
//  Reads a string to store db hyphen ('-') is removed
function commaadd(str) {
	var value="";
	for ( var i=0; i < str.length; i++ ) {
		var ch=str.charAt(i);
		if ( ch == ',' ){
			value=value + "','";
		}else{
			value=value + ch;
		}
	}
	return value;
}
//  Reads a string to store db hyphen ('-') is removed
function removeDbval(str) {
	var value="";
	for ( var i=0; i < str.length; i++ ) {
		var ch=str.charAt(i);
		if ( ch != '　' ) value=value + ch;
	}
	return value;
}
// Check the data on blur
function BlurDate(obj) {
	var f=document.form;
	var dt=obj.value;
	if( dt == ""){
	} else {
		if ( isValidDate(dt)) {
			if( dt.length == 8 ) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage("TRS90070");
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage("TRS90070");
		obj.select();
		obj.focus();
		return;
	}
}
// Check the effective date of(2)
function isValidDate(date) {
	var year=date.substring(0,4);
	var month=date.substring(4,6);
	var day=date.substring(6,8);
	if (isDatecheck(year, month, day) ) {
		return true;
	} else {
		return false;
	}
}
// Check the effective date of(1)
function isDatecheck( year,month,day ) {
	if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) ) {
		return true;
	} else {
		return false;
	}
}
function checkMonth( month ) {
	var intmonth=parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12 ) {
		return true;
	} else {
		return false;
	}
}
// Check the effective date of
function checkDay( yyyy, mm, dd ) {
	var monthDD=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	var im=parseInt(mm,10) - 1;
	if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) ) {
		monthDD[1]=29;
	}
	if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] ) {
		return false;
	} else {
		return true;
	}
}
//Date format yyyy-mm-dd
function addBar(dt) {
	var dat="";
	if( dt.length == 8 ) {
		dat=dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}
//Date format yyyy-mm-dd
function addBar_from(obj) {
	var formObject=document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat=dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.from_date.value=dat;
}
//Date format yyyy-mm-dd
function addBar_to(obj) {
	var formObject=document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat=dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.to_date.value=dat;
}
/*
 * Calendar Pop-Up Multi-Input
 */
function getCalendar() {
	var cal=new ComCalendarFromTo();
	cal.displayType="date";
	cal.select(document.form.from_date, document.form.to_date, 'yyyy-MM-dd');
}
/**
 * From Node to pop the return value for
 */
function getFromNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_fm_loc.value=lvLoc;
	formObject.search_fm_node.value="";
	getYardCombo(search_fm_yard, sheetObjects[0], formObject, lvLoc);
	//search_fm_yard.CODE=lvYard;
	search_fm_yard.SetSelectCode(lvYard);
}
/**
 * The return value for the pop-up Via Node
 */
function getViaNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_via_loc.value=lvLoc;
	getYardCombo(search_via_yard, sheetObjects[0], formObject, lvLoc);
	//search_via_yard.CODE=lvYard;
	search_via_yard.SetSelectCode(lvYard);
}
/**
 * The return value for the pop-up To Node
 */
function getToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_to_loc.value=lvLoc;
	formObject.search_to_node.value="";
	getYardCombo(search_to_yard, sheetObjects[0], formObject, lvLoc);
	//search_to_yard.CODE=lvYard;
	search_to_yard.SetSelectCode(lvYard);
}
/**
 * Door Location pop-up for the return value
 */
function getDorLoc(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.search_door_loc.value=lvLoc;
	getZoneCombo(search_door_yard, sheetObjects[0], formObject, lvLoc);
	//search_door_yard.CODE=lvYard;
	search_door_yard.SetSelectCode(lvYard);
}
/*
 * Get a list of external combo box (ESD_TRS_0003.js also exists).
 */
function getComboList(obj, comObj, sep) { //object, Taking part in the value, 'Node kind
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
	var charval="Y";
	obj.value=lvobj;
	for (var i=0; i < lvobj.length; i++) {
		var oneChar=lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" )    ){
			}else {
				charval="N";
				break;
			}
		} else {
			charval="N";
			break;
		}
	}
	if(charval!="Y") {
		ComShowCodeMessage('COM12130','Location','Node Code','');
		obj.value="";
		obj.focus();
		return false;
	}
	if( lvobj == "" || lvobj.length < 5) {
		obj.value="";
		comObj.RemoveAll();
		return;
	} else {
		if( sep == 'F' ) {
			formObj.search_fm_node.value="";
			lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'V' ){
			lvViaNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'T' ){
			formObj.search_to_node.value="";
			lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc=getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}
		comObj.focus();
	}
}
/**
 * Pop-up call vvd
 */
function vvd_OnPopupClick() {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";
	var cmdt_desc_val="";  
	var classId="getCOM_ENS_VVD";
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
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 780, 490, 'getCOM_ENS_VVD', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location: If a pop-up from a single selection.
 */
function getCOM_ENS_VVD(rowArray) {
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[0];
		var colArray2=colArray[7];
		var x1=document.form.trunk_vvd.value;
		if(x1==""){
			document.form.trunk_vvd.value=colArray2;
			formObject.trunk_vvd.focus();
		} else {
			document.form.trunk_vvd.value=document.form.trunk_vvd.value+","+colArray2;
			formObject.trunk_vvd.focus();
		}
	}
}
/**
 * Pop-up call
 */
function so_OnPopupClick(val) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var classId="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var title=val;
	if (val == "sw" ) {
		if(formObject.radio_gubun[0].checked)  {
			title="S/O No.";
		} else {
			title="W/O No.";
		}
	}
	var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title+"&pgmNo=ESD_TRS_0019";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 415, 'getCOM_ENS_906', '0,1', true);
}
/**
 * Location: If a pop-up from a single selection.
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject=document.form;
	if(returnval=="T.VVD") {
		var x1=document.form.trunk_vvd.value;
		if(x1==""){
			document.form.trunk_vvd.value=rowArray;
			formObject.trunk_vvd.focus();
		}else{
			document.form.trunk_vvd.value=rowArray;
			formObject.trunk_vvd.focus();
		}
	}else if(returnval=="Booking No."){
		var x2=document.form.bkgnumber.value;
		if(x2==""){
			document.form.bkgnumber.value=rowArray;
			formObject.bkgnumber.focus();
		}else{
			document.form.bkgnumber.value=rowArray;
			formObject.bkgnumber.focus();
		}
	}else if(returnval=="B/L No."){
		var x3=document.form.blnumber.value;
		if(x3==""){
			document.form.blnumber.value=rowArray;
			formObject.blnumber.focus();
		}else{
			document.form.blnumber.value=rowArray;
			formObject.blnumber.focus();
		}
	}else if(returnval=="EQ No."){
		var x4=document.form.eqnumber.value;
		if(x4==""){
			document.form.eqnumber.value=rowArray;
			formObject.eqnumber.focus();
		}else{
		    document.form.eqnumber.value=rowArray;
			formObject.eqnumber.focus();
		}
  		if ( formObject.radio_eq[0].checked == true ) {
			document.form.eqnumber.value=multiCntrChkDgt(document.form.eqnumber.value);
	}		
	}else if(returnval=="SO No."){
		var x5=document.form.sonumber.value;
		if(x5==""){
			document.form.sonumber.value=rowArray;
			formObject.sonumber.focus();
		}else{
			document.form.sonumber.value=rowArray;
			formObject.sonumber.focus();
		}
	}else if(returnval=="WO No."){
		var x5=document.form.wonumber.value;
		if(x5==""){
			document.form.wonumber.value=rowArray;
			formObject.wonumber.focus();
		}else{
			document.form.wonumber.value=rowArray;
			formObject.wonumber.focus();
		}
	}else if(returnval=="Invoice No."){
		var x6=document.form.invoicenumber.value;
		if(x6==""){
			document.form.invoicenumber.value=rowArray;
			formObject.invoicenumber.focus();
		}else{
			document.form.invoicenumber.value=rowArray;
			formObject.invoicenumber.focus();
		}
	}else if(returnval=="MTY REF No."){
		var x6=document.form.mtyrefnumber.value;
		if(x6==""){
			document.form.mtyrefnumber.value=rowArray;
			formObject.mtyrefnumber.focus();
		}else{
			document.form.mtyrefnumber.value=rowArray;
			formObject.mtyrefnumber.focus();
		}
	}else if(returnval=="COP No."){
		var x6=document.form.copnumber.value;
		if(x6==""){
			document.form.copnumber.value=rowArray;
			formObject.copnumber.focus();
		}else{
			document.form.copnumber.value=rowArray;
			formObject.copnumber.focus();
		}
	}else if(returnval=="ZIP Code"){
		var x5=document.form.zip_code.value;
		if(x5==""){
			document.form.zip_code.value=rowArray;
			formObject.zip_code.focus();
		}else{
			document.form.zip_code.value=rowArray;
			formObject.zip_code.focus();
		}
	} else if( returnval == "FM_NODE" ) {
		formObject.search_fm_node.value=rowArray;
		resetLocYard("FROM");
	} else if( returnval == "TO_NODE" ) {
		formObject.search_to_node.value=rowArray;
		resetLocYard("TO");
	} else if( returnval == "Slot Ref No." ) {
		var x = document.form.cntr_slt_no.value;
		if(x ==""){
			document.form.cntr_slt_no.value=rowArray;
			formObject.cntr_slt_no.focus();
		}else{
			document.form.cntr_slt_no.value=rowArray;
			formObject.cntr_slt_no.focus();
		}
	}
}
/**
 * Pop-up call ofc
 */
function ofc_OnPopupClick(val) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var classId="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 768, 447, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location: If a pop-up from a single selection.
 */
function getCOM_ENS_071(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var in_val_2=colArray[3];
	document.form.input_office.value=in_val_2;
}
/**
 * SOcheck.
 */
function val_check(obj,val){
	var formObject=document.form;
	var inputStr=obj.value;
	var value=obj.value;
	var charval="Y";
	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
	lvobj=obj.value;
	if( lvobj != "" ) {
		for (var i=0; i < inputStr.length; i++) {
			var oneChar=inputStr.charAt(i)
			if (oneChar != "") {
				if (!( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == ",") || (oneChar == "-" ) || (oneChar == " " ) || (oneChar == "/" ) )){
					charval="N";
					break;
				}
			}else{
				charval="N";
				break;
			}
		}
		if(charval=="N"){
			var errMessage=ComGetMsg('TRS90083',val,'','');  
			ComShowMessage(errMessage);
			obj.value="";
			obj.focus();
		}
	}
}
//2008-03-27
/**
 * Combo Box -bound
 */
function bound_OnChange_1(obj) {
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_boundmode.value=codeval;
}
/**
 * Combo Box -cost
 */
function bound_OnChange_2(obj) {
    var codeval=obj.value;
    var formObject=document.form;
    formObject.hid_costmode.value=codeval;
    //cost mode based on the definition screen!
    setKindEnabled(); 
}
/**
 * Combo Box -trans
 */
function bound_OnChange_3(obj){
	 var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_transmode.value=codeval;
	//trans mode according to the definition screen!
	setKindEnabled();
}
/**
 * Combo Box -so
 */
function bound_OnChange_4(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_somode.value=codeval;
}
/**
 * Combo Box -wo
 */
function bound_OnChange_5(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_womode.value=codeval;
}
/**
 * Combo Box -invoice
 */
function bound_OnChange_6(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_invoicemode.value=codeval;
}
/**
 * Combo Box -cargo
 */
function bound_OnChange_7(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_cargomode.value=codeval;
}
function bound_OnChange_8(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_sotype.value=codeval;
}
function bound_OnChange_9(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_amount.value=codeval;
}
function bound_OnChange_10(obj){
	var codeval=obj.value;
	var formObject=document.form;
	formObject.hid_unplanned.value=codeval;
}
/**
 * Click the radio button
 */
function change_period(){
	var formObject=document.form;
	var sheetObject=formObject.sheet1;
	var val="";	
/*	if ( formObject.radio_period[0].checked == true ) {
		formObject.hid_period.value="S";   //S/O Creation  
	}else if( formObject.radio_period[1].checked == true ) {
		formObject.hid_period.value="W";   //W/O Issue
	}else if( formObject.radio_period[2].checked == true ) {
		formObject.hid_period.value="I";   //Invoice Confirm 
	}else if( formObject.radio_period[3].checked == true ) {
		formObject.hid_period.value="O";   //Invoice Confirm 
	}else if( formObject.radio_period[4].checked == true ) {
		formObject.hid_period.value="L";   //Invoice Confirm 
	}else if( formObject.radio_period[5].checked == true ) {
		formObject.hid_period.value="D";   //Invoice Confirm 
	}else{
		formObject.hid_period.value="";
	}
*/
	formObject.hid_period.value = formObject.sel_period.value;
}
/**
 * PClick the radio button
 */
function change_office(){
	var formObject=document.form;
	var sheetObject=formObject.sheet1;
	var val="";	
	if ( formObject.radio_office[0].checked == true ) {
		formObject.hid_radio_office.value="S";   //Issue
	}else if( formObject.radio_office[1].checked == true ) {
		formObject.hid_radio_office.value="V";   //Invoice
	}else{
		formObject.hid_radio_office.value="";
	}
}
/**
 * Click the radio button
 */
function change_user(){
	var formObject=document.form;
	var sheetObject=formObject.sheet1;
	var val="";	
	if ( formObject.radio_user[0].checked == true ) {
		formObject.hid_radio_user.value="S";   //Issue
	}else if( formObject.radio_user[1].checked == true ) {
		formObject.hid_radio_user.value="V";   //Invoice
	}else{
		formObject.hid_radio_user.value="";
	}
}
function change_eqno(){
	var formObject=document.form;
	var sheetObject=formObject.sheet1;
	var val="";	
	if ( formObject.radio_eq[0].checked == true ) {
		formObject.hid_radio_eq.value="CNTR";   //Container 
	}else if( formObject.radio_eq[1].checked == true ) {
		formObject.hid_radio_eq.value="CHS";   //Chassis   
	}else if( formObject.radio_eq[2].checked == true ) {
		formObject.hid_radio_eq.value="GEN";   //Genset  
	}else{
		formObject.hid_radio_eq.value="";
	}
}
/**
 * Click the radio button
 */
function change_number(){
	var formObject=document.form;
	var sheetObject=formObject.sheet1;
	var val="";	
	if ( formObject.radio_number[0].checked == true ) {
		formObject.hid_radio_number.value="S";  // S/C No. 
	}else if( formObject.radio_number[1].checked == true ) {
		formObject.hid_radio_number.value="R";  // RFA No.  
	}else{
		formObject.hid_radio_number.value="";
	}
}
/**
 * trunk_vvd_check.
 */
function vvd_check(obj){
	var formObject=document.form;
	var inputStr=obj.value;
	var value=obj.value;
	var charval="Y";
	for (var i=0; i < inputStr.length; i++) {
		var oneChar=inputStr.charAt(i);
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) ||(oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == ",")){
			}else {
				charval="N";
				break;
			}
		}else{
			charval="N";
			break;
		}
	}
	if(charval=="Y"){
		if(value !=""){
			//formObject.f_cmd.value = SEARCH04;
			//var queryString = "vndr_cd="+value+"&"+TrsFrmQryString(formObject);
			//formObject.sheet1.DoRowSearch("ESD_TRS_0075GS.do", queryString);
			//if(!check_vndr(formObject.sheet1.EtcData('CNT_CD'),obj)){
			//	formObject.vndr_cd.value="";
			//	formObject.vndr_nm.value="";
			//	formObject.vndr_cd.focus();
			//}
		}else{
			formObject.trunk_vvd.value="";
		}
	}else{
		formObject.trunk_vvd.value="";
		formObject.trunk_vvd.focus();
		var errMessage=ComGetMsg('COM12130','T.VVD','English or Number type','');  
		ComShowMessage(errMessage);
	}
}
/**
 * the presence of input Check trunk_vvd_check
 *
 */
function check_vndr(value, obj) {
	var formObject=document.form;
	if( value == 0) {
		var errMessage=ComGetMsg('COM12114','VNDR','','');  
		ComShowMessage(errMessage);
		return false;
	}else{
		formObject.trunk_vvd.value=value;
		return true;
	}
}
/**
 * office_check_check.
 */
function office_check(obj){ 
	var formObject=document.form;
	var inputStr=doSepRemove(obj.value.toUpperCase(), " ");
	var value=doSepRemove(obj.value.toUpperCase(), " ");
	var charval="Y";
	formObject.input_office.value=doSepRemove(obj.value.toUpperCase(), " ");
	for (var i=0; i < inputStr.length; i++) {
		var oneChar=inputStr.charAt(i)
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) ||(oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "0" && oneChar <= "9" )  ){
			}else {
				charval="N";
				break;
			}
		} else {
			charval="N";
			break;
		}
	}
	if(charval=="Y"){
		if(value !=""){
			formObject.f_cmd.value=SEARCH02;
			var queryString="office_cd="+value+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoRowSearch( "ESD_TRS_0075GS.do",queryString );
			if(!check_office(formObject.sheet1.GetEtcData('CNT_CD'),obj)){
				formObject.input_office.value="";
				formObject.input_office.focus();
			}
		}else{
			formObject.input_office.value="";
		}
	}else{
		formObject.input_office.value="";
		formObject.input_office.focus();
		ComShowCodeMessage('COM12130','Office Code','English or Number type','');
	}
}
/**
 * the presence of input Check office_check_check
 *
 */
function check_office(value, obj) {
	var formObject=document.form;
	if( value == 0) {
		ComShowCodeMessage('COM12114','OFFICE','','');  
		return false;
	}else{
		//formObject.input_office.value=value;
		return true;
	}
}
/**
 * user_check.
 */
function user_check(obj){ 
	var formObject=document.form;
	var inputStr=doSepRemove(obj.value, " ");
	var value=doSepRemove(obj.value, " ");
	var charval="Y";
	formObject.user_id.value=doSepRemove(obj.value, " ");
	for (var i=0; i < inputStr.length; i++) {
		var oneChar=inputStr.charAt(i);
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "a" && oneChar <= "z") || (oneChar >= 0 && oneChar <= 9) || oneChar =="_"  ){
			}else {
				charval="N";
				break;
			}
		}else{
			charval="N";
			break;
		}
	}
	if(charval=="Y"){
		if(value !=""){
		}else{
			formObject.user_id.value="";
		}
	}else{
		ComShowCodeMessage('COM12130','User ID','English or Number type','');  
		formObject.user_id.value="";
		formObject.user_id.focus();
	}
}
/**
 * so/wo number_check.
 */
function number_check(obj){ 
	var formObject=document.form;
	var inputStr=doSepRemove(obj.value.toUpperCase(), " ");
	var value=doSepRemove(obj.value.toUpperCase(), " ");
	var charval="Y";
	formObject.sc_rfa_cd.value=doSepRemove(obj.value.toUpperCase(), " ");
	for (var i=0; i < inputStr.length; i++) {
		var oneChar=inputStr.charAt(i);
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) ||(oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == ",")){
			}else {
				charval="N";
				break;
			}
		}else{
			charval="N";
			break;
		}
	}
	if(charval=="Y"){
		if(value !=""){
			//fn_revalue();
		}else{
			formObject.sc_rfa_cd.value="";
		}
	}else{
		ComShowCodeMessage('COM12130','Number','English or Number type',''); 
		formObject.sc_rfa_cd.value="";
		formObject.sc_rfa_cd.focus();
	}
}
/**
 * Common Node popup
 */
function openHireYardPopup(objName) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";
	var v6="";
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
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * combo_node add
 */
function node_add() {
	var formObj=document.form;
	if(search_fm_yard.GetSelectCode()!= '' && formObj.search_fm_loc.value != '') {
		formObj.chk_from_node.value=formObj.search_fm_loc.value+search_fm_yard.GetSelectCode();
	}else{
		formObj.chk_from_node.value='';
	}
	if(search_via_yard.GetSelectCode()!= '' && formObj.search_via_loc.value != '') {
		formObj.chk_via_node.value=formObj.search_via_loc.value+search_via_yard.GetSelectCode();
	}else{
		formObj.chk_via_node.value='';
	}
	if(search_to_yard.GetSelectCode()!= '' && formObj.search_to_loc.value != '') {
		formObj.chk_to_node.value=formObj.search_to_loc.value+search_to_yard.GetSelectCode();
	}else{
		formObj.chk_to_node.value='';
	}
	if(search_door_yard.GetSelectCode()!= '' && formObj.search_door_loc.value != '') {
		formObj.chk_door_node.value=formObj.search_door_loc.value+search_door_yard.GetSelectCode();
	}else{
		formObj.chk_door_node.value='';
	}
	var costMode=formObj.hid_costmode.value;
	var tranMode=formObj.hid_transmode.value;
	//COST MODE query conditions according to the activity / inactivation determine the conditions for setting the four kinds of
	if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode=1;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode=2;
	else if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode=3;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode=4;
}
/**
 * combo_search_door_yard_onChange
 */
function search_node_mode() {
	var formObj=document.form;
	//If you have the number in each mode.
	node_add(); 
	var fmNode=formObj.search_fm_loc.value+search_fm_yard.GetSelectCode();
	var viaNode=formObj.search_via_loc.value+search_via_yard.GetSelectCode();
	var toNode=formObj.search_to_loc.value+search_to_yard.GetSelectCode();
	var doorNode=formObj.search_door_loc.value+search_door_yard.GetSelectCode();
	switch(ctMode) {
		case 1:
			if(fmNode == toNode) {
				ComShowCodeMessage('COM12115', 'From yard And To yard');
				formObj.search_fm_loc.focus();
				return false;
			}
		break;
		case 2:
			if(formObj.search_via_loc.value == '' || search_via_yard.GetSelectCode()== '') {
				ComShowCodeMessage('COM12114', 'Via');
				formObj.search_via_loc.focus();
				return false;
			} else if(fmNode == toNode) {
				ComShowCodeMessage('COM12115', 'From yard And To yard');
				formObj.search_fm_loc.focus();
				return false;
			} else if(fmNode == viaNode) {
				ComShowCodeMessage('COM12115', 'From yard And Via yard');
				formObj.search_fm_loc.focus();
				return false;
			} else if(viaNode == toNode) {
				ComShowCodeMessage('COM12115', 'Via yard And To yard');
				formObj.search_via_loc.focus();
				return false;
			}
		break;
		case 3:
			if(formObj.search_door_loc.value == '' || search_door_yard.GetSelectCode()== '') {
				ComShowCodeMessage('COM12114', 'Door');
				formObj.search_door_loc.focus();
				return false;
			} else if(fmNode == doorNode) {
				ComShowCodeMessage('COM12115', 'From yard And Door yard');
				formObj.search_fm_loc.focus();
				return false;
			} else if(toNode == doorNode) {
				ComShowCodeMessage('COM12115', 'Door yard And To yard');
				formObj.search_door_loc.focus();
				return false;
			}
		break;
		case 4:
			if(formObj.search_via_loc.value == '' || search_via_yard.GetSelectCode()== '') {
				ComShowCodeMessage('COM12114', 'Via');
				formObj.search_via_loc.focus();
				return false;
			}else if(formObj.search_door_loc.value == '' || search_door_yard.GetSelectCode()== '') {
				ComShowCodeMessage('COM12114', 'Door');
				formObj.search_door_loc.focus();
				return false;
			}else if(fmNode == viaNode) {
				ComShowCodeMessage('COM12115', 'From yard And Via yard');
				formObj.search_fm_loc.focus();
				return false;
			}else if(viaNode == toNode) {
				ComShowCodeMessage('COM12115', 'Via yard And To yard');
				formObj.search_via_loc.focus();
				return false;
			}else if(fmNode == doorNode) {
				ComShowCodeMessage('COM12115', 'From yard And Door yard');
				formObj.search_fm_loc.focus();
				return false;
			}else if(toNode == doorNode) {
				ComShowCodeMessage('COM12115', 'Door yard And To yard');
				formObj.search_door_loc.focus();
				return false;
			}else if(viaNode == doorNode) {
				ComShowCodeMessage('COM12115', 'Via yard And Door yard');
				formObj.search_via_loc.focus();
				return false;
			}
		break;
	}
}
/**
 * COST MODE, TRANS MODE to select the query processing conditions enabled
 **/
function setKindEnabled() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var obj=document.form;
//		document.combo_svc_provider.Text = '';
//		formObj.svc_provider.value='';
	formObj.search_fm_loc.value='';
	search_fm_yard.RemoveAll();
	formObj.search_via_loc.value='';
	search_via_yard.RemoveAll();
	formObj.search_to_loc.value='';
	search_to_yard.RemoveAll();
	formObj.search_door_loc.value='';
	search_door_yard.RemoveAll();
	node_add();
	switch(ctMode) {
		case 1:
			obj.search_via_loc.disabled=true;
			obj.search_door_loc.disabled=true;
			search_via_yard.SetEnable(0);
			search_door_yard.SetEnable(0);
		break;
		case 2:
			obj.search_via_loc.disabled=false;
			obj.search_door_loc.disabled=true;
			search_via_yard.SetEnable(1);
			search_door_yard.SetEnable(0);
		break;
		case 3:
			obj.search_via_loc.disabled=true;
			obj.search_door_loc.disabled=false;
			search_via_yard.SetEnable(0);
			search_door_yard.SetEnable(1);
		break;
		case 4:
			obj.search_via_loc.disabled=false;
			obj.search_door_loc.disabled=false;
			search_via_yard.SetEnable(1);
			search_door_yard.SetEnable(1);
		break;
	}
}
/**
 * W/O PreView
 */
function woPreview(sheetObj){
	var chkRows=sheetObj.FindCheckedRow("part");
	var trsp_wo_ofc_cty_cd="";
	var trsp_wo_seq="";
	var emptyData="";
	if ( chkRows == "") {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var arrRow=chkRows.split("|");
	for (idx=0; idx<arrRow.length; idx++){ 
		if ( sheetObj.GetCellValue( arrRow[idx] , "wo_no" ) == "") {
			ComShowCodeMessage("TRS90377");
			return false;
		}		    
		trsp_wo_ofc_cty_cd += sheetObj.GetCellValue(arrRow[idx] , "trsp_wo_ofc_cty_cd")+ ",";
		trsp_wo_seq += sheetObj.GetCellValue(arrRow[idx] , "trsp_wo_seq")+ ",";
		emptyData += ",";
	}
	trsp_wo_ofc_cty_cd=trsp_wo_ofc_cty_cd.substring(0 , trsp_wo_ofc_cty_cd.length-1);
	trsp_wo_seq=trsp_wo_seq.substring(0 , trsp_wo_seq.length-1);
	var wo_cancel_flag='';
	var detain='';
	var bno_issue='';
	var eq_mode='IS';
	var issued='Y';
	var param="?trsp_wo_ofc_cty_cd="+trsp_wo_ofc_cty_cd+"&trsp_wo_seq="+trsp_wo_seq+"&wo_cancel_flag="+wo_cancel_flag+"&detain="+detain+"&eq_mode="+eq_mode+"&bno_issue="+bno_issue+"&isInquiry=Y"+"&pgmNo=ESD_TRS_0024";
	window.open('ESD_TRS_0024.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=1000,Height=800");
}
/**
 * W/O Issue History
 */
function woIssueHistory(sheetObj){
	var chkRows=sheetObj.FindCheckedRow("part");
	var woNo="";
	if ( chkRows == "") {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var arrRow=chkRows.split("|");
	for (idx=0; idx<arrRow.length; idx++){ 
		if ( sheetObj.GetCellValue( arrRow[idx] , "wo_no" ) == "") {
			ComShowCodeMessage("TRS90377");
			return false;
		}
		dupChk=woNo.indexOf(sheetObj.GetCellValue(arrRow[idx] , "wo_no"));
		if ( parseInt(dupChk) < 0 ) {
			woNo += sheetObj.GetCellValue(arrRow[idx] , "wo_no")+ ",";
		}
	}
	woNo=woNo.substring(0 , woNo.length-1);
	ComOpenWindow('ESD_TRS_0958.do?wo_history='+woNo, "ESD_TRS_0958", 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:900px;dialogHeight:400px', true);
}
/**
 * All S / O Frustrate possible
 */
function fn_popup(sheetObj, row, col) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var classId="getCOM_ENS_021";
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
	ComOpenPopup('/opuscntr/COM_ENS_021.do' + param, 780, 470, 'getCOM_ENS_021', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location: If a pop-up from a single selection.
 */
function getCOM_ENS_021(rowArray) {
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[0];
		var in_val=colArray[2];
		formObject.sc_rfa_cd.value=in_val;
	}
}
/**
 * sc-rfa verification
 */
function fn_revalue() {
	var formObject=document.form;
	formObject.f_cmd.value=SEARCH02;
	var value=formObject.sc_rfa_cd.value;
	var queryString="col=sc_no&row=&searchStr="+value+"&"+TrsFrmQryString(formObject);
	if(!checkCountry(formObject.sheet1.GetEtcData('CNT_CD'))) return;
}
/**
 * S / C Number presence of input Check
 *
 */
function checkCountry(value, row, col) {
	var formObject=document.form;
	if( value == 0) {
		var errMessage=ComGetMsg('COM12114','S/C No. - RFA No. Number','','');  
		ComShowMessage(errMessage);
		formObject.sc_rfa_cd.value="";
		formObject.sc_rfa_cd.focus();
		return false;
	} else {
		//formObject.sc_rfa_cd.focus();
		return true;
	}
}
/**
 * Pop-up call rep_commodity
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
	var xx5=formObject.input_office.value;  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&ofc_cd="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 650, 490, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity pop-up Call: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	//var comboObj = document.combo_svc_provider;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];
		//comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);
		formObj.combo_svc_provider.value=colArray2;
		formObj.svc_provider.value=colArray4;
	}
}
function retriveSo() {
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "RTV");
}


//Include Office for processing Logic
var request=null;
function createHttpRequest() {
	try{
		request=new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request=new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request=new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request=null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}
// When the Click Include Check Bok
function fun_chkOffice() {
	var doc_office=document.form.chk_office;
	var prm_office=doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked=false;
		document.form.input_office.value="";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url="ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value=prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value=document.form.old_ofc_cd.value;
	}
}
// Brings the value of Office.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml=request.responseXML;
			var rowXml=docXml.getElementsByTagName("row-count")[0];
			var subXml=null;
			var text_ofc="";
			for( var n=0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml=docXml.getElementsByTagName("sub-office")[n];
				text_ofc=text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.input_office.value=text_ofc.substring(0, text_ofc.length-1);
		}
	}
}
//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value=obj;
}
//Office-PopUp Validation Checked
function validation_check() {
	var doc_office=document.form.chk_office;
	var prm_office=doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice=prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value="";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}
/**
 * Radio box the return value of the item selected in
 */
function checkParaminput(oFrm){
    sRtn="";
    if( typeof( oFrm.length) != "undefined"){
        for(var i=0; i < oFrm.length; i++){
            if(oFrm[i].checked) sRtn=oFrm[i].value;
        }
    }else{
        if(oFrm.checked) sRtn=oFrm.value;
    }
    return sRtn;
}
/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col, mode,step) {
	var myOption="width=950,height=805,menubar=0,status=0,scrollbars=1,resizable=0";
	var url='ESD_TRS_0918.screen';
	url += '?unique_cd='+sheetObj.GetCellValue(row, 'trsp_so_seq');
	url += '&open_mode='+mode;
	url += '&step_cd='+step;
	url += '&main_row='+row;
	url += '&ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=1';
	url += '&curr_cd='+sheetObj.GetCellValue(row, 'wo_curr_cd');
	
	if (step == 'WO') {
		url += '&po_fuel_scg_rt='+sheetObj.GetCellValue(row, 'wo_fuel_scg_amt');
	}
	
	myWin=window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}
/**
 * 3pt bill Inquiry popup
 **/
function pop3rdPartyBilling(sheetObj, row, col, mode)
{
	var myOption="width=815,height=580,menubar=0,status=0,scrollbars=0,resizable=0";
	var url='ESD_TRS_0954.screen';
	url += '?unique_cd='+sheetObj.GetCellValue(row, 'trsp_so_seq');
	url += '&open_mode='+'search';
	url += '&step_cd=WO';
	url += '&main_row='+row;
	url += '&trsp_so_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&trsp_so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=1';
	url += '&bkg_no='+sheetObj.GetCellValue(row, 'bkg_no');
	url += '&eq_no='+sheetObj.GetCellValue(row, 'eq_no');
	url += '&wo_no='+sheetObj.GetCellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.GetCellValue(row, 'trsp_wo_seq');
	url += '&curr_cd='+sheetObj.GetCellValue(row, 'wo_curr_cd');
	ComOpenPopup(url, 1000, 580, "pop3rdPartyBilling", "1,0,1,1,1,1,1", true);
}
function sheet1_OnSelectMenu(sheetObj, MenuString){
	 switch(MenuString){
		case('Header Setting Save'):
			IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
		case('Header Setting Reset'):
			IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
		case('Header Setting Delete'):
			IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
	 }
}
/**
 * Check box is selected
 */
function usrailOnly(obj){
	var formObject=document.form;
	var val="";
	sheetObjects[0].RenderSheet(0);
	sheetObjects[0].RemoveAll();
	if ( obj.checked == true ) {
		sheetObjects[0].SetColHidden("wo_hzd_mtrl_scg_amt",0);
		sheetObjects[0].SetColHidden("wo_ovr_wgt_scg_amt",0);
		sheetObjects[0].SetColHidden("wo_usa_ttl_amt",0);
		formObject.hid_usrail.value='Y';
		formObject.sel_sotype.value='R';
		formObject.sel_costmode.value='ALL';
		formObject.sel_transmode.value='RD';
	//	formObject.input_office.value=formObject.cre_ofc_cd.value;
		formObject.port_io[0].checked = true;
		ComEnableObject(formObject.port_io[0], false);
		ComEnableObject(formObject.port_io[1], false);
		ComEnableObject(formObject.port_io[2], false);
		formObject.port_cd.value = "";
		formObject.port_nm.value = "";
		ComEnableObject(formObject.port_cd, false);
		formObject.btns_port.style.visibility="hidden";

	} else {
		sheetObjects[0].SetColHidden("wo_hzd_mtrl_scg_amt",1);
		sheetObjects[0].SetColHidden("wo_ovr_wgt_scg_amt",1);
		sheetObjects[0].SetColHidden("wo_usa_ttl_amt",1);
		formObject.hid_usrail.value='N';
		formObject.sel_sotype.value='ALL';
		formObject.sel_costmode.value='ALL';
		formObject.sel_transmode.value='ALL';
		formObject.port_io[0].checked = true;
		ComEnableObject(formObject.port_io[0], true);
		ComEnableObject(formObject.port_io[1], true);
		ComEnableObject(formObject.port_io[2], true);
		formObject.port_cd.value = "";
		formObject.port_nm.value = "";
	}
	bound_OnChange_8(formObject.sel_sotype);  // SO TYPE CHANGE Events.
	bound_OnChange_3(formObject.sel_transmode);  // TRANS MODE CHANGE Events.
	bound_OnChange_2(formObject.sel_costmode);  // COST CODE CHANGE Events
	getDateBetween(formObject.from_date);
	sheetObjects[0].RenderSheet(1);
}
/**
 * Check box is selected
 */
function usdropnpullOnly(obj){
	var formObject=document.form;
	sheetObjects[0].RenderSheet(0);
	if ( obj.checked == true ) {
		sheetObjects[0].SetColHidden("fm_dt",0);
		sheetObjects[0].SetColHidden("fm_yd",0);
		sheetObjects[0].SetColHidden("to_dt",0);
		sheetObjects[0].SetColHidden("to_yd",0);
		sheetObjects[0].SetColHidden("to_sts",0);
		sheetObjects[0].SetColHidden("mt_dt",0);
		sheetObjects[0].SetColHidden("mt_yd",0);
		sheetObjects[0].SetColHidden("web_mt_dt",0);
		sheetObjects[0].SetColHidden("grace_end",0);
		formObject.hid_usdropnpull.value='Y';
	} else {
		sheetObjects[0].SetColHidden("fm_dt",1);
		sheetObjects[0].SetColHidden("fm_yd",1);
		sheetObjects[0].SetColHidden("to_dt",1);
		sheetObjects[0].SetColHidden("to_yd",1);
		sheetObjects[0].SetColHidden("to_sts",1);
		sheetObjects[0].SetColHidden("mt_dt",1);
		sheetObjects[0].SetColHidden("mt_yd",1);
		sheetObjects[0].SetColHidden("web_mt_dt",1);
		sheetObjects[0].SetColHidden("grace_end",1);
		formObject.hid_usdropnpull.value='N';
	}
	sheetObjects[0].RenderSheet(1);
}
function checkDigit(obj){
	var formObj=document.form;
	if (obj == undefined){
		obj=formObj.eqnumber;
	}
	if(formObj.radio_eq[0].checked){
		obj.value=multiCntrChkDgt(obj.value);
	}
}

function resetLocYard(which) {
	var formObj = document.form;
	if(which=='FROM') {
		if(formObj.search_fm_node.value.length > 0) {
			formObj.search_fm_loc.value="";
			search_fm_yard.RemoveAll();
		}
	}else{
		if(formObj.search_to_node.value.length > 0) {
			formObj.search_to_loc.value="";
			search_to_yard.RemoveAll();
		}
	}
}

/**
 * Calling from [Port] Pop-up
 * @param rtnObjs
 * @return
 */
function returnPortHelp(rtnObjs){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.port_cd.value=rtnDatas[0];
				formObj.port_nm.value=rtnDatas[1];
			}
		}
	}
}

function getDateBetween(obj) {
	if(obj.value.length >= 8) {
		var chk_usrail=document.form.chk_usrail.checked;
		if(chk_usrail ) {
			document.form.to_date.value=ComGetDateAdd(obj.value, "d", "15", "-");
		} else {
			document.form.to_date.value=ComGetDateAdd(ComGetDateAdd(obj.value, "m", 1, ""), "d", "-1", "-");
		}
	}else{
		document.form.to_date.value="";
	}
}
