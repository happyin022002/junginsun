/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0002.js
*@FileTitle  : Service Order Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
var openWindownm='CYDR';
var tabCnt=0 ;
var beforetab=1;
var beforetab2=1;
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
var docUsrail="";
var docUnconfirm="";
var docUnplanshuttle="";
var R=222;
var G=251;
var B=248;
/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;

/* Eopmubyeol added to the bottom of the global variables are used to declare. */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var sheetObject3=sheetObjects[3];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) {
			return false;
		}
		switch(srcName) {
			case "btn_retrieve":
			if( validateFormSearch(formObject) ) {
					formObject.rad_dateSep[0].disabled=true;
					formObject.rad_dateSep[1].disabled=true;
					formObject.rad_dateSep[2].disabled=true;
					formObject.unplan_shuttle.disabled=true;
					formObject.tro_unconfirm_dr.disabled=true;
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
				}
			break;
			case "btn_new":
				formObject.reset();
				search_fm_yard.RemoveAll(); 
				search_via_yard.RemoveAll();
				search_to_yard.RemoveAll(); 
				search_door_yard.RemoveAll();
				fun_disabled();
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
			break;
			case "btn_minimize":
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject);		
			break;
			case "btng_officetransfer": //Office Transfer button
				if( doOfficeTrans(sheetObject) )
					ComOpenWindow('ESD_TRS_0930Pop.screen', 'ESD_TRS_0930Pop', 'top=200, left=200, width=500, height=180, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			break;
			case "btng_multipleapply": //Multiple Apply Concurrent
			    var lv_cost_mode_cd=null;
				if( doMultipleApply(sheetObject) ) {
              	for( var i=0; i<sheetObject.RowCount(); i++ ) {
              		if( sheetObject.GetCellValue(i+2, "chk1") == "1" ) {
              			lv_cost_mode_cd=sheetObject.GetCellValue(i+2, "trsp_cost_dtl_mod_cd");
              			break;
              		}
              	}				    
              	    ComOpenPopup('ESD_TRS_0003.do?cost_mode_cd='+lv_cost_mode_cd, 800, 440, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				}
			break;
			case "btns_calendar":
				getCalendar();
			break;
			case "btng_downexcel1": //sheet1 Excel download
				sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObject), SheetDesign:1, Merge:1 });
			break;
			case "btng_socreation1": //sheet1 S/O Creation
				if( validateForm(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBINSERT, "");
				}
			break;
			case "btng_woissue1": //sheet1 W/O Issue
				doActionIBSheet(sheetObject1, formObject, IBINSERT, "WO");
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
			case "btns_tvvd": //Trunk VVD Popup Window
				openTVVDPopup("getCOM_ENS_VVD_1");
			break;
			case "btns_fvvd": //Feeder VVD Popup Window
				openTVVDPopup("getCOM_ENS_VVD_2");
			break;
			case "btns_multivvd": //M Trunk VVD
				openMultipleinquiry('VVD', 'T.VVD');
			break;
			case "btns_multifvvd": //M Feeder VVD
				openMultipleinquiry('FVD', 'F.VVD');
			break;
			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;
			case "btns_multibl": //M B/L No
				openMultipleinquiry('BLN', 'B/L No');
			break;
			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;
			case "btns_office": //M CNTR
				if( validation_check() ) {
					var sUrl="/opuscntr/ESD_TRS_0964.do";
					 var param="?ctrl_ofc_cd="+formObject.ctrl_so_office.value;
					var ofc_cd=formObject.ctrl_so_office.value;
					var sFeatures="scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:400px;dialogHeight:390px"; 
					ComOpenWindow(sUrl+param, "ESD_TRS_0964", sFeatures, true);
				}
			break;
			case "btns_multizipcode":
				openMultipleinquiry('ZIP', 'ZIP Code');
			break;
			case "btns_contract":
				openContractNoPopup();
			break;
			case "btng_candidatedelete":
				deleteSOCandidate();
			break;
			case "btng_offhireverify":
			  offHireVerify();
			break;
			case "btns_multi_search_fm_node":
				openMultipleinquiry('FM_NODE', 'NODE Code');
			break;
			case "btns_multi_search_to_node":
				openMultipleinquiry('TO_NODE', 'NODE Code');
			break;
			case "btns_port":
				var sUrl="/opuscntr/ESD_TRS_0981.do?port_cd=" + formObject.port_cd.value;
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
			break;
			case "btns_multi_ecc_cd":
				openMultipleinquiry('ECC', 'ECC Code');
			break;
			case "btns_ecc_cd":
				openEccPopUp('getEccCode');
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
		} else {
		}
	}
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	var sheetObjLength = sheetObjects.length;
	for(var i=0; i < sheetObjLength;i++) {
		ComConfigSheet(sheetObjects[i] ); 
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (var k = 0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k+1);
    }
	initControl();
	ComEnableObject(document.form.port_cd, false);
	getCostModeCombo(sel_costmode);
	document.form.btns_port.style.visibility="hidden";
}
  /**
	* HTML Control on the page is dynamically loaded into the event. <br>
   **/
function initControl() {
	axon_event.addListener ('keydown', 'ComKeyEnter', document.form);
	axon_event.addListenerFormat('change',    'obj_change',     document.form);
	doActionIBSheet(sheetObjects[0], document.form, COMMAND01, "");
}

/**
 * 
 * @param comboObj
 * @param comboNo
 */
function initCombo(comboObj, comboNo) {
	var cnt  = 0 ;
	switch(comboObj.options.id) {
		default : {
		    comboObj.SetMultiSelect(1);
		    comboObj.SetColAlign(0, "left");
		    comboObj.SetColAlign(1, "left");
		    comboObj.SetMultiSeparator(",");
		    break;
		}
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
        } // end switch
   }catch(e) {
       if( e == "[object Error]") {
           ComShowMessage(OBJECT_ERROR);
       } else {
           ComShowMessage(e.message);
       }
   }
}

function initSheet(sheetObj, sheetNo) {
	switch(sheetObj.id) {
		case "t1sheet1": {
				  var HeadTitle0  ="Sel.|STS|CB|SOURCE|BKG\nStat.|BKG\nStat.|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|";
					  HeadTitle0 += "From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|Door Location|";
					  HeadTitle0 += "Door Information|Door Information|Door Information|Door Information|";
					  HeadTitle0 += "Door Information|Door Information|Door Information|Remark\n(Special Instruction)|";
					  HeadTitle0 += "Web D/O|Web D/O|Web D/O|Multi\nStop|Estimated Time|Estimated Time|";
					  HeadTitle0 += "Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|";
					  HeadTitle0 += "COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term|";
					  HeadTitle0 += "TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|";
					  HeadTitle0 += "TRO Information|TRO Information|TRO Information|TRO Information|";
					  HeadTitle0 += "TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|VGM Weight\n(KGS)|VGM Weight\n(LBS)|Weight|Weight\n(KGS)|Weight\n(LBS)|";
					  HeadTitle0 += "Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|";
					  HeadTitle0 += "in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|USA Rail|USA Rail|USA Rail|";
					  HeadTitle0 += "Customs\nC.LOC|USA\nLast City|";
					  HeadTitle0 += "F|O|C|Pickup No.|Avaliable DT|Avaliable DT|Last Free DT|Last Free DT|S/C No|";
					  HeadTitle0 += "Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|";
					  HeadTitle0 += "Door\nSVC TP|Internal\nRemark|S/O Office|IRG|";
					  HeadTitle0 += "Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result";
				  
				  var HeadTitle1  ="Sel.|STS|CB|SOURCE|BKG\nStat.|BKG\nStat.|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|";
					  HeadTitle1 += "Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Name|";
					  HeadTitle1 += "Actual\nCustomer|Factory\nName|Zip\nCode|Address|";
					  HeadTitle1 += "TEL|FAX|PIC|Remark\n(Special Instruction)|";
					  HeadTitle1 += "User Info|Time|Time|Multi\nStop|From Departure|From Departure|";
					  HeadTitle1 += "To Arrival|To Arrival|Door Arrival|Door Arrival|TRO Door Date|TRO Door Date|";
					  HeadTitle1 += "COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term";
					  HeadTitle1 += "|SEQ|CNFM|Office|User ID|";
					  HeadTitle1 += "Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No|";
					  HeadTitle1 += "TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|VGM Weight\n(KGS)|VGM Weight\n(LBS)|Weight|Weight\n(KGS)|Weight\n(LBS)|";
					  HeadTitle1 += "Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|";
					  HeadTitle1 += "in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|To Node|Creation Time|Creation Time|";
					  HeadTitle1 += "Customs\nC.LOC|USA\nLast City|";
					  HeadTitle1 += "F|O|C|Pickup No.|||||S/C No|";
					  HeadTitle1 += "Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|";
					  HeadTitle1 += "Door\nSVC TP|Internal\nRemark|S/O Office|IRG|";
					  HeadTitle1 += "Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result";
				
				  sheetObj.SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
				  sheetObj.InitHeaders(headers, info);
				  var cols = [ 
				               	 {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
								 {Type:"Status",    Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_cmb_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"source",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",  	Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",  	Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
								 {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
								 {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_yard",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
								 {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
								 {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_yard",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"dor_nod_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Popup",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_cust_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"fctry_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dor_pst_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
								 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"dor_de_addr",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
								 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_phn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_fax_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
								 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"spcl_instr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"usa_do_usr_info",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:255 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"do_cre_date",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:255 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"do_cre_time",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:255 },
								 {Type:"Popup",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mlt_stop_de_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt_hms",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt_hms",          KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_pln_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_pln_dt_hms",          KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dor_arr_dt_dd",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dor_arr_dt_hms",              KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_sts_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"prt_bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcvde_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_cnfm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_upd_dt1",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_upd_dt2",             KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tro_cfm_curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"tro_cfm_rev_amt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tro_lod_ref_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tro_rep_cmdt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"bkg_qty",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"sealno",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"sealno2",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vgm_kgs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vgm_lbs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",                    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_kgs_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_lbs_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,   Align:"Right",   ColMerge:1,   SaveName:"noofpkg",                     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pkgcode",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_name",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trunkvvd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ib_vvd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ob_vvd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Left",    ColMerge:1,   SaveName:"shpr_cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Left",    ColMerge:1,   SaveName:"cnee_cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Left",    ColMerge:1,   SaveName:"ntfy_cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rail_to_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rail_cre_dt_dd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rail_cre_dt_hms",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"ibd_cstms_clr_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"lst_loc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cgor_frt_pay_ind_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cgor_org_bl_rcvr_ind_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cgor_cstms_acpt_re_ind_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cntr_pkup_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"aval_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"aval_dt_hms",                 KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"lst_free_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"lst_free_dt_hms",             KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"customsclearance",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"customsclearanceNo",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rfano",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Combo",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dor_svc_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Left",    ColMerge:1,   SaveName:"irg",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trns_rqst_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trns_rqst_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"trns_rqst_rsn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lse_cntr_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"pod_conti_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"fm_loc_conti_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cust_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cnee_cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cnee_cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"shpr_cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"shpr_cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"act_cust_addr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rev_curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_rqst_ord_rev_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_nxt_port_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rail_cmb_thru_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"via_nod_yard2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"dor_nod_yard2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"dor_arr_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"dor_nod_pln",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_sep",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"upln_so_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"proc_cfm_ind_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"rc_seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_rqst_ord_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_rqst_ord_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"bkg_bdr_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"bkg_bdr_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"tro_sub_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1,  Width:10,    Align:"Center",  ColMerge:1,   SaveName:"feedervvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_fm_nod_yard",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_via_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_to_nod_yard",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_dor_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_fm_nod_cd",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_via_nod_cd",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_to_nod_cd",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
					             {Type:"Text",      Hidden:1,  Width:40,    Align:"Center",  ColMerge:1,   SaveName:"o_dor_nod_cd",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }		
				];
				  sheetObj.InitColumns(cols);
				  sheetObj.SetEditable(1);
				  sheetObj.SetColProperty(0, 'trsp_crr_mod_cd', {ComboText:trsp_crr_mod_cdText, ComboCode:trsp_crr_mod_cdCode} );
				  sheetObj.SetColProperty(0, 'dor_svc_tp_cd', {ComboText:dor_svc_tp_cdText, ComboCode:dor_svc_tp_cdCode} );
				  ComResizeSheet(sheetObj);
				  break;
		}
		case "sheet2": {
				  var HeadTitle0="Office Code|Seqence";
				  sheetObj.SetConfig( { SearchMode:2, Page:20} );
				  var headers = [ { Text:HeadTitle0, Align:"Center"} ];
				  sheetObj.InitHeaders(headers, {});
				  var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				  sheetObj.InitColumns(cols);
				  sheetObj.SetEditable(0);
				  sheetObj.SetVisible(false);
				  break;		  
	   }
		case "t4sheet1" :{
				  var HeadTitle0="RTN_VALUE|ACT_CUST_CNT_CD|ACT_CUST_SEQ|ACT_CUST_ADDR_SEQ|ACT_CUST_FCTRY_PST_CD|ACT_CUST_FCTRY_NM|ACT_CUST_FCTRY_ADDR|ACT_CUST_FCTRY_PHN_NO|ACT_CUST_FCTRY_FAX_NO|ACT_CUST_FCTRY_PIC_NO|ACT_CUST_EML|ACT_CUST_RMK";
				  sheetObj.SetConfig( { SearchMode:2} );
				  var headers = [ { Text:HeadTitle0, Align:"Center"} ];
				  sheetObj.InitHeaders(headers, {});
				  var cols = [ 	 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rtn_value",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_addr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_pst_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_pic_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				  sheetObj.InitColumns(cols);
				  sheetObj.SetEditable(0);
				  sheetObj.SetVisible(false);
				  break;
		}
		case "rtnsheet" : {
				  var HeadTitle0="CNTR_NO|OFFH_YD_CD";
				  sheetObj.SetConfig( { SearchMode:2} );
				  var headers = [ { Text:HeadTitle0, Align:"Center"} ];
				  sheetObj.InitHeaders(headers, {});
				  var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				  sheetObj.InitColumns(cols);
				  sheetObj.SetEditable(0);
				  sheetObj.SetVisible(false);
				  break;		  
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

function validateFormSearch(formObj) {
	var lvfrmDate=doSepRemove(doSepRemove(formObj.frm_plandate.value, " "), "-");
	var lvtoDate=doSepRemove(doSepRemove(formObj.to_plandate.value, " "), "-");
	var lvfrm_node=doSepRemove(formObj.search_fm_loc.value, " ");
	var lvvia_node=doSepRemove(formObj.search_via_loc.value, " ");
	var lvto_node=doSepRemove(formObj.search_to_loc.value, " ");
	var lvdor_loc=doSepRemove(formObj.search_door_loc.value, " ");
	var lvtrunk_vvd=doSepRemove(formObj.trunk_vvd.value, " ");
	var lvbkg_no=doSepRemove(formObj.bkg_no.value, " ");
	var lvbill_no=doSepRemove(formObj.bill_no.value, " ");
	var lvcntr_no=doSepRemove(formObj.cntr_no.value, " ");
	var lvcontract_no=formObj.contract_no.value;
	var lvfeeder_vvd=doSepRemove(formObj.txt_feeder_vvd.value, " ");
	var prm_office=doSepRemove(formObj.ctrl_so_office.value.toUpperCase(), " ");
	var lvzip_code=doSepRemove(formObj.zip_code.value, " ");
	if( prm_office == "" ) {
		ComShowCodeMessage("TRS90430");
		return false;
	} else {
		formObj.ctrl_so_office.value=prm_office;
	}
	if( lvfrmDate == "" ) //from date
		formObj.frm_plandate.value="";
	if( lvtoDate == "" ) //to date
		formObj.to_plandate.value="";
	if( lvtrunk_vvd == "" ) //T.VVD
		formObj.trunk_vvd.value="";
	if( lvbkg_no == "" ) //BKG No
		formObj.bkg_no.value="";
	if( lvbill_no == "" ) //B/L No
		formObj.bill_no.value="";
	if( lvcntr_no == "" ) //CNTR No
		formObj.cntr_no.value="";
	if( lvfeeder_vvd == "" ) //F.VVD
		formObj.txt_feeder_vvd.value="";
	if( lvzip_code == "" ) //Zip Code
		formObj.zip_code.value="";

	/* UNPLANNED SHUTTLE S/O */
	/* Mandatory   : TRUNK VVD or BKG# or B/L# or CNTR#    */
	if( document.form.unplan_shuttle.checked ) {
		if( lvfrm_node == "" && document.form.search_fm_node.value == "" ) {
			ComShowCodeMessage("TRS90499");
			return false;
		} else {
			if( lvtrunk_vvd == "" && lvbkg_no == "" && lvbill_no == "" && lvcntr_no == "" && lvcontract_no == "") {
				ComShowCodeMessage("TRS90499");
				return false;
			}
		}
	} else  {
		if( lvfrmDate == "" && lvtoDate != "" ) { //If either date is missing
			ComShowCodeMessage("TRS90119");
			return false;
		} else if( lvfrmDate != "" && lvtoDate == "" ) { //If either date is missing
			ComShowCodeMessage("TRS90121");
			return false;
		} else if( lvfrmDate != "" && lvtoDate != "" ) { //Check the date the part
			if( !doDatecheck(lvfrmDate) ) {
				ComShowCodeMessage("TRS90072");
				return false;
			} else if( !doDatecheck(lvtoDate) ) {
				ComShowCodeMessage("TRS90073");
				return false;
			}

	        // 2015.01.21    Hyungwook Choi
			if( ComGetDaysBetween(lvfrmDate, lvtoDate) > 30 ) {
				ComShowCodeMessage("TRS90424");
				return false;
			} else if( ComGetDaysBetween(lvfrmDate, lvtoDate) < 0 ) {
				ComShowCodeMessage("TRS90118");
				return false;
			}
		} else {
			if( lvtrunk_vvd == "" && lvbkg_no == "" && lvbill_no == "" && lvcntr_no == "" && lvcontract_no == "") {
				ComShowCodeMessage("TRS90410", "Date Range");
				return false;
			}
		}		
	}

	if(ComGetObjValue(document.form.port_io) != "A" && document.form.port_cd.value == "") {
    	ComShowCodeMessage("TRS90410", "Port Code");
		return false;
	}
	
	if( lvfrm_node == "" ) { //From Node
		formObj.search_fm_loc.value="";
		search_fm_yard.RemoveAll(); // Delete data combo
	}
	if( lvvia_node == "" ) { //Via Node
		formObj.search_via_loc.value="";
		search_via_yard.RemoveAll(); // Delete data combo
	}
	if( lvto_node == "" ) { //To Node
		formObj.search_to_loc.value="";
		search_to_yard.RemoveAll(); // Delete data combo
	}
	if( lvdor_loc == "" ) { //Door Node
		formObj.search_door_loc.value="";
		search_door_yard.RemoveAll(); // Delete data combo
	}
	if( !doengnumcheck(lvtrunk_vvd) ) {
		formObj.trunk_vvd.value="";
		return false;
	}
	if( !doengnumcheck(lvbkg_no) ) {
		formObj.bkg_no.value="";
		return false;
	}
	if( !doengnumcheck(lvbill_no) ) {
		formObj.bill_no.value="";
		return false;
	}
	if( !doengnumcheck(lvcntr_no) ) {
		formObj.cntr_no.value="";
		return false;
	}
	formObj.hid_frmdate.value=lvfrmDate; //from Date
	formObj.hid_todate.value=lvtoDate; //to Date
	formObj.search_fm_loc.value=lvfrm_node.toUpperCase();
	formObj.search_via_loc.value=lvvia_node.toUpperCase();
	formObj.search_to_loc.value=lvto_node.toUpperCase();
	formObj.search_door_loc.value=lvdor_loc.toUpperCase();
	formObj.trunk_vvd.value=lvtrunk_vvd.toUpperCase(); //T.VVD
	formObj.bkg_no.value=lvbkg_no.toUpperCase(); //BKG No.
	formObj.bill_no.value=lvbill_no.toUpperCase(); //B/L No
	formObj.cntr_no.value=lvcntr_no.toUpperCase(); //CNTR No
	// Unplanned Shuttle
	if( formObj.unplan_shuttle.checked ) {
	    //UNPLANNED SHUTTLE INDICATOR SET
		formObj.unplan_shuttle.value="US";   //Unplanned Shuttle S/O
	} else {
		formObj.unplan_shuttle.value="";
	}
	// Incl. TRO Unconfirmed Door
	if( formObj.tro_unconfirm_dr.checked ) {
	    //TRO UNCONFIRMED DOOR SET
		formObj.tro_unconfirm_dr.value="UD";    //Unconfirmed Door S/O
	} else {
		formObj.tro_unconfirm_dr.value="";
	}
	return true;
}
/*
 * Sheet processing-related processes
 */
function doActionIBSheet(sheetObj,formObj,sAction,sObj) {
	switch(sAction) {
		case COMMAND01: {
	        formObj.f_cmd.value = INIT;
	        ComOpenWait(true);
	        var sXml = sheetObj.GetSearchData("ESD_TRS_0002GS.do", FormQueryString(formObj), {sync:2});
	        var arrXml = sXml.split("|$$|");
	        ComXml2ComboItem(arrXml[0], eq_tpsz_cd, "cntr_tpsz_cd", "cntr_tpsz_cd");
	        eq_tpsz_cd.SetDropHeight(300);
	        ComOpenWait(false);
	        break;
	    }
		case IBSEARCH: 
		    fun_ParentOffice();
		    formObj.f_cmd.value=SEARCH;
            //UNPLANNED SHUTTLE INDICATOR
			if( document.form.unplan_shuttle.checked ) {
				docUnplanshuttle="Y";
			} else {
				docUnplanshuttle="";
			}
			//PROVISION CHECK INDICATOR
			if( document.form.tro_unconfirm_dr.checked ) {
				docUnconfirm="Y";
			} else {
				docUnconfirm="";
			}
 			sheetObj.DoSearch("ESD_TRS_0002GS.do", TrsFrmQryString(formObj)); //TrsFrmQryString(formObj)
		break;
		case IBINSERT: 
			if( sObj == "" || sObj == "CF" || sObj == "CS" ) {
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH20;
				formObj.cbstatus.value=sObj;
				var queryStr=sheetObj.GetSaveString(false, true, "chk1");
 				sheetObjects[1].DoSearch("ESD_TRS_0002GS.do", queryStr+"&"+TrsFrmQryString(formObj),{Sync:2} );
				ComOpenWait(false);
			} else if( sObj == "WO" ) {
				if( sheetObj.RowCount()< 1 ) {
					errMsg=ComGetMsg("TRS90110");
					ComShowMessage(errMsg);
					return false;
				}
				var cty_cd="";
				var seq_no="";
				for(var i=1; i<sheetObj.RowCount()+1; i++) {
					if( i == sheetObj.RowCount()) {
						cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd');
						seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq');
					} else {
						cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') + ",";
						seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq') + ",";
					}
				}
				document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
				document.woForm.trsp_so_seq.value=seq_no;
				document.woForm.eq_mode.value="CG";
				document.woForm.pgmNo.value="ESD_TRS_0023";
				document.woForm.parentPgmNo.value="ESD_TRS_M001";
				document.woForm.action="ESD_TRS_0023.screen";
				document.woForm.submit();
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
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
		}
	}
}
/*
 * tab1 sheet of information about
 */
function t1sheet1_OnClick(sheetObj, row , col , value) {
	if( sheetObj.GetCellProperty(row, col, dpDataType)== 6 ) {
		return;
	}
	if( sheetObj.ColSaveName(col) == "fm_nod_yard" ) {
		value=doSepRemove(sheetObj.GetCellValue(row, "fm_nod_cd"), " ");
		document.form.TRSP_SO_EQ_KIND.value="";
		if( value.length > 0 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		} else {
			sheetObj.SetCellValue(row, "fm_nod_cd","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "to_nod_yard" ) {
		value=doSepRemove(sheetObj.GetCellValue(row, "to_nod_cd"), " ");
		document.form.TRSP_SO_EQ_KIND.value="A";
		if( value.length > 0 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		} else {
			sheetObj.SetCellValue(row, "to_nod_cd","",0);
		}
	} else if (sheetObj.ColSaveName(col) == "via_nod_yard" ) {
		value=doSepRemove(sheetObj.GetCellValue(row, "via_nod_cd"), " ");
		document.form.TRSP_SO_EQ_KIND.value="";
		if( value.length > 0 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		} else {
			sheetObj.SetCellValue(row, "via_nod_cd","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "dor_nod_yard" ) {
		value=doSepRemove(sheetObj.GetCellValue(row, "dor_nod_cd"), " ");
		document.form.TRSP_SO_EQ_KIND.value="";
		if( value.length > 0 ) {
			getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		} else {
			sheetObj.SetCellValue(row, "dor_nod_cd","",0);
		}
	} 
	
	var colName=sheetObj.ColSaveName(col);
	switch(colName){
		case 'chk1': {
			if( sheetObj.GetCellValue(row, 'trsp_bnd_cd') == 'I' && sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd') == 'DOOR' && sheetObj.GetCellValue(row, 'bkg_bdr_flg') != 'Y'){
				ComShowCodeMessage('TRS90369');
			}
			break;
		}
	}
}
function t1sheet1_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.SetRowStatus(row,"I");
		} else {
			sheetObj.SetRowStatus(row,"R");
		}
	} else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
		var lvfm=doSepRemove(sheetObj.GetCellValue(row,"fm_nod_cd").toUpperCase(), " ");
		sheetObj.SetCellValue(row, "fm_nod_cd",lvfm,0);
		document.form.TRSP_SO_EQ_KIND.value="";
		if( doengnumcheck(lvfm) ) {
			if( lvfm.length == 5 ) {
				getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm);
				if( sheetObj.GetCellValue(row, "fm_nod_cd") != "" ) {
					getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
				} else {
					sheetObj.CellComboItem(row,"fm_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "fm_nod_yard","",0);
				}
			} else {
				if( lvfm.length == 0 ) {
					sheetObj.CellComboItem(row,"fm_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "fm_nod_yard","",0);
				} else {
					errMsg=ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.SetCellValue(row,"fm_nod_cd","",0);
					sheetObj.SelectCell(row,"fm_nod_cd");
					sheetObj.CellComboItem(row,"fm_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "fm_nod_yard","",0);
				}
			}
		} else {
			sheetObj.SetCellValue(row,"fm_nod_cd","",0);
			sheetObj.SelectCell(row,"fm_nod_cd");
			sheetObj.CellComboItem(row,"fm_nod_yard", {ComboText:"", ComboCode:""} );
			sheetObj.SetCellValue(row, "fm_nod_yard","",0);
		}
		} else if( sheetObj.ColSaveName(col) == "via_nod_cd" ) {
		var lvvia=doSepRemove(sheetObj.GetCellValue(row,"via_nod_cd").toUpperCase(), " ");
		sheetObj.SetCellValue(row,"via_nod_cd",lvvia);
		document.form.TRSP_SO_EQ_KIND.value="";
		if( doengnumcheck(lvvia) ) {
			if( lvvia.length == 5 ) {
				getYardSheetCombo1(sheetObj, document.form, row, col, "via_nod_yard", lvvia); //Varidation check
				if( sheetObj.GetCellValue(row, "via_nod_cd") != "" ) {
					getYardSheetCombo(sheetObj, document.form, row, "via_nod_yard", lvvia);
				} else {
					sheetObj.CellComboItem(row,"via_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "via_nod_yard","",0);
				}
			} else {
				if( lvvia.length == 0 ) {
					sheetObj.CellComboItem(row,"via_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "via_nod_yard","",0);
				} else {
					errMsg=ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.SetCellValue(row,"via_nod_cd","",0);
					sheetObj.SelectCell(row,"via_nod_cd");
					sheetObj.CellComboItem(row,"via_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "via_nod_yard","",0);
				}
			}
		} else {
			sheetObj.SetCellValue(row,"via_nod_cd","",0);
			sheetObj.SelectCell(row,"via_nod_cd");
			sheetObj.CellComboItem(row,"via_nod_yard", {ComboText:"", ComboCode:""} );
			sheetObj.SetCellValue(row, "via_nod_yard","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
		sheetObj.SetCellFontColor(row,"to_nod_cd","#000000")
		sheetObj.SetCellFontColor(row,"to_nod_yard","#000000")
		sheetObj.InitCellProperty(row,"to_nod_yard",{ Type:"Combo"});
		var lvto=doSepRemove(sheetObj.GetCellValue(row,"to_nod_cd").toUpperCase(), " ");
		sheetObj.SetCellValue(row,"to_nod_cd",lvto);
		document.form.TRSP_SO_EQ_KIND.value="A";
		if( doengnumcheck(lvto) ) {
			if( lvto.length == 5 ) {
				getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Varidation check
				if( sheetObj.GetCellValue(row, "to_nod_cd") != "" ) {
					getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
				} else {
					sheetObj.CellComboItem(row,"to_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "to_nod_yard","",0);
				}
			} else {
				if( lvto.length == 0 ) {
					sheetObj.CellComboItem(row,"to_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "to_nod_yard","",0);
				} else {
					errMsg=ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.SetCellValue(row,"to_nod_cd","",0);
					sheetObj.SelectCell(row,"to_nod_cd");
					sheetObj.CellComboItem(row,"to_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "to_nod_yard","",0);
				}
			}
		} else {
			sheetObj.SetCellValue(row,"to_nod_cd","",0);
			sheetObj.SelectCell(row,"to_nod_yard");
			sheetObj.CellComboItem(row,"to_nod_yard", {ComboText:"", ComboCode:""} );
			sheetObj.SetCellValue(row, "to_nod_yard","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "dor_nod_cd" ) {
		var lvdor=doSepRemove(sheetObj.GetCellValue(row,"dor_nod_cd").toUpperCase(), " ");
		sheetObj.SetCellValue(row,"dor_nod_cd",lvdor);
		document.form.TRSP_SO_EQ_KIND.value="";
		if( doengnumcheck(lvdor) ) {
			if( lvdor.length == 5 ) {
				getZoneSheetCombo2(sheetObj, document.form, row, col, "dor_nod_yard", lvdor);
				GetZoneName(sheetObj, row, "dor_nod_cd", "dor_nod_cd_nm", sheetObj.GetCellValue(row, "dor_nod_yard"));
			} else {
				if( lvdor.length == 0 ) {
					sheetObj.CellComboItem(row,"dor_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "dor_nod_yard","",0);
					sheetObj.SetCellValue(row, "dor_nod_cd_nm","",0);
				} else {
					ComShowMessage(ComGetMsg("TRS90122"));
					sheetObj.SetCellValue(row,"dor_nod_cd","",0);
					sheetObj.SelectCell(row,"dor_nod_cd");
					sheetObj.CellComboItem(row,"dor_nod_yard", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(row, "dor_nod_yard","",0);
					sheetObj.SetCellValue(row, "dor_nod_cd_nm","",0);
				}
			}
		} else {
			sheetObj.SetCellValue(row,"dor_nod_cd","",0);
			sheetObj.SelectCell(row,"dor_nod_cd");
			sheetObj.CellComboItem(row,"dor_nod_yard", {ComboText:"", ComboCode:""} );
			sheetObj.SetCellValue(row, "dor_nod_yard","",0);
			sheetObj.SetCellValue(row, "dor_nod_cd_nm","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "dor_nod_yard" ) {
		GetZoneName(sheetObj, row, "dor_nod_cd", "dor_nod_cd_nm", value);
	} else if( sheetObj.ColSaveName(col) == "trsp_crr_mod_cd" ) {
		var lvCrrmodcd=sheetObj.GetCellValue(row, "trsp_crr_mod_cd"); //TW, WT
		if( lvCrrmodcd.indexOf("D") < 0 ) {
			sheetObj.SetCellEditable(row, "via_nod_cd",1);
			sheetObj.SetCellEditable(row, "via_nod_yard",1);
		} else {
			sheetObj.SetCellEditable(row, "via_nod_cd",0);
			sheetObj.SetCellEditable(row, "via_nod_yard",0);
			sheetObj.SetCellValue(row, "via_nod_cd","",0);
			sheetObj.SetCellValue(row, "via_nod_yard","",0);
			sheetObj.CellComboItem(row,"via_nod_yard", {ComboText:"", ComboCode:""} );
		}
	} else if( sheetObj.ColSaveName(col) == "n1st_nod_pln_dt" ) {
        if(sheetObj.GetCellValue(row, "n1st_nod_pln_dt") == ""){
        	sheetObj.SetCellValue(row, "n1st_nod_pln_dt_hms", "", 0);
        }
	} else if( sheetObj.ColSaveName(col) == "lst_nod_pln_dt" ) {
        if(sheetObj.GetCellValue(row, "lst_nod_pln_dt") == ""){
        	sheetObj.SetCellValue(row, "lst_nod_pln_dt_hms", "", 0);
        }
	} else if( sheetObj.ColSaveName(col) == "dor_nod_pln_dt" ) {
        if(sheetObj.GetCellValue(row, "dor_nod_pln_dt") == ""){
        	sheetObj.SetCellValue(row, "dor_nod_pln_dt_hms", "", 0);
        }
	}
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.ctrl_so_office.value=obj;
}
//Addition to date.
function getDateBetween(obj) {
	if(obj.value.length >= 8) {
	    document.form.to_plandate.value=ComGetDateAdd(obj.value,"D", 30, "-");
	}else{
		document.form.to_plandate.value="";
	}
}
function t2sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk=sheetObj.GetCellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.SetRowStatus(row,"I");
			for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
				var lvchk2=sheetObj.GetCellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.SetRowStatus(i,"I");
					sheetObj.SetCellValue(i, "chk1","1",0);
				}
			}
		} else {
			sheetObj.SetRowStatus(row,"R");
			for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
				var lvchk2=sheetObj.GetCellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.SetRowStatus(i,"R");
					sheetObj.SetCellValue(i, "chk1","0",0);
				}
			}
		}
	}
}
function t3sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk=sheetObj.GetCellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.SetRowStatus(row,"I");
			for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
				var lvchk2=sheetObj.GetCellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.SetRowStatus(i,"I");
					sheetObj.SetCellValue(i, "chk1","1",0);
				}
			}
		} else {
			sheetObj.SetRowStatus(row,"R");
			for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
				var lvchk2=sheetObj.GetCellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.SetRowStatus(i,"R");
					sheetObj.SetCellValue(i, "chk1","0",0);
				}
			}
		}
	}
}
/**
* Screen form validation process for processing the input values
*/
function validateForm(sheetObj, formObj) {
	if( sheetObj.RowCount("I") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	
	if( docUnconfirm == 'Y' ) {
		ComShowCodeMessage("TRS90498");
		return false;		
	}	
	//Determine the number of data rows
	var fromRow=0;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		fromRow=arrRow[i];
		var trsp_dtl_mod=sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_sep");
		var doc_cfm_ind=sheetObj.GetCellValue(fromRow, "proc_cfm_ind_cd");
		var lvCrrmodcd=sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd");
		if( docUsrail == "Y" && lvCrrmodcd.indexOf("R") > -1 ) {
			ComShowCodeMessage("TRS90223");
			return false;
		}
		var lv_frm_node=doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_cd"), " ");
		var lv_to_node=doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_cd"), " ");
		var lv_via_node=doSepRemove(sheetObj.GetCellValue(fromRow, "via_nod_cd"), " ");
		var lvfmnod=lv_frm_node+doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_yard"), " ");
		var lvvinod=lv_via_node+doSepRemove(sheetObj.GetCellValue(fromRow, "via_nod_yard"), " ");
		var lvtonod=lv_to_node+doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_yard"), " ");
		var lvdrnod=doSepRemove(sheetObj.GetCellValue(fromRow, "dor_nod_cd"), " ")+doSepRemove(sheetObj.GetCellValue(fromRow, "dor_nod_yard"), " ");
		var lvoutints=sheetObj.GetCellValue(fromRow, "trsp_bnd_cd"); //IN, OUT, T/S
		var lvcostmod=sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd"); //CY, DOOR
		var lvcgo_tp_cd=sheetObj.GetCellValue(fromRow, "cgo_tp_cd"); //CGO_TP_CD Empty, Full division
		var lveq_no=doSepRemove(sheetObj.GetCellValue(fromRow, "eq_no"), " "); //TRO --> PROVISION
		var lvconti_cd=doSepRemove(sheetObj.GetCellValue(fromRow, "pod_conti_cd"), " ");
		var lv_fm_loc_conti_cd=doSepRemove(sheetObj.GetCellValue(fromRow, "fm_loc_conti_cd"), " ");
		var lvcost_act_grp_cd = doSepRemove(sheetObj.GetCellValue(fromRow, "cost_act_grp_cd"), " ");
		
		if(lvdrnod.length == 5 || (lvdrnod.length > 5 && lvdrnod.length != 7)) {
			ComShowCodeMessage("TRS90497");
			sheetObj.SelectCell(fromRow, "dor_nod_yard");
			return false;	
		}
		if( lvCrrmodcd.indexOf("D") > -1 ) {
			if( lvvinod != "" ) {
				ComShowCodeMessage("TRS90085");
				return false;
			}
		} else {
			if( lvvinod == "" ) {
				ComShowCodeMessage("TRS90104");
				return false;
			}
		}
		if( (lv_frm_node.substring(0, 2) == "US") || (lv_to_node.substring(0, 2) == "CA") ) {
			if( lvCrrmodcd.indexOf("R") > -1 ) {
				ComShowCodeMessage("TRS90223");
				return false;
			}
		}
//		if(!funcWoDateValidCheck(sheetObj, fromRow)) {
//			ComShowCodeMessage('TRS90462');
//    		return false;    
//      }				
		/**
		 * docUnconfirm: 'PROVISION' ilgyeongwoo 'Y' or 'N'
		 */
		/* 'Door' Term Only */
		if( lvcostmod == "DOOR" ) {
		    /* 'PROVISION' */
		    /* checked ... 'PROVISION' */
		    /** 
		     * <<TRO CONFIRM>>
		     * 'OUT BOUND'
		     * Americas+OutBound
		     * Europe 
		     * -----------------
		     * <<TRO Unconfirm>>
		     * 'OUT BOUND'
		     * Americas+InBound
		     * Asia 
		     */
		     /**   <<INBOUND DOOR>>
		      *    Container No Must Exist for ALL CONTINENTAL 
		      *    adding TRO must confirm for Exrope
		      */
		    /**  docUnconfirm <== PROVISION CHECK INDICATOR ['PROVISION' ilgyeongwoo 'Y' or 'N']
		     *   doc_cfm_ind  <== proc_cfm_ind_cd           ['C' : TRO Confirm]
		     */
			if( docUnconfirm == 'Y' ) {
				if( !(lv_fm_loc_conti_cd == 'M' && lvoutints == 'I') && lv_fm_loc_conti_cd != 'A' ) {
					if( doc_cfm_ind != 'C' ) {
						ComShowCodeMessage("TRS90302");
						return false;
					}
				}
				if( lvoutints == 'I' && (lveq_no == '' || lveq_no == null) ) {
				    if(lv_fm_loc_conti_cd == 'E' && doc_cfm_ind != 'C' ) {
				    	ComShowCodeMessage("TRS90302");
						return false;
				    } else {
				    	ComShowCodeMessage("TRS90389");
						return false;
				    }
				}	
		    /* None-Provision */
			} else {
				if( !(lv_fm_loc_conti_cd == 'M' && lvoutints == 'I') && lv_fm_loc_conti_cd != 'A' ) {
					if( doc_cfm_ind != 'C' ) {
						ComShowCodeMessage("TRS90302");
						return false;
					}
				}
				if( lvoutints == 'I' && (lveq_no == '' || lveq_no == null) ) {
				    if(lv_fm_loc_conti_cd == 'E' && doc_cfm_ind != 'C' ) {
				    	ComShowCodeMessage("TRS90302");
						return false;
				    }else{
				    	ComShowCodeMessage("TRS90389");
						return false;
				    }
				}				
			}
	    /* 'CY' + etc Term Only except 'DOOR' Term */
		}
		
		if( docUnplanshuttle == "Y" ) {
			if( sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd") == "" ) {
				ComShowCodeMessage("TRS90212");
				return false;
			}
			if( lvcostmod == "CY" ) {
				if( lvfmnod == lvtonod ) {
					ComShowCodeMessage("TRS90134");
					return false;
				}
			}
			
			if( lvfmnod.length < 7 || lvtonod.length < 7 ) {
				ComShowCodeMessage("TRS90104");
				return false;
			}
			if(lvcostmod == "DOOR" && lvdrnod.length < 7 ) {
				ComShowCodeMessage("TRS90145");
				return false;
			}
		} else {
			if( lvcgo_tp_cd == "M" ) { //Empty a difference a day if
				if( lvfmnod == lvtonod ) {
					ComShowCodeMessage("TRS90134");
					return false;
				}
			} else {
				if( lvoutints == "O" || lvoutints == "I" ) {
					if( lvcostmod == "CY" ) {
						if( lvfmnod.length < 7 || lvtonod.length < 7 ) {
							ComShowCodeMessage("TRS90104");
							return false;
						} else if( lvdrnod != "" ) {
							ComShowCodeMessage("TRS90085");
							return false;
						} else {
							if( lvfmnod == lvtonod ) {
								ComShowCodeMessage("TRS90134");
								return false;
							}
						}
					} else if( lvcostmod == "DOOR" ) {
						if( lvfmnod == "" || lvtonod == "" || lvdrnod == "" ) {
							ComShowCodeMessage("TRS90104");
							return false;
						}
					} else {
						return false;
					}
				} else if( lvoutints == "T" || lvcost_act_grp_cd == "TRWD" || lvoutints == "" ) {
					if( lvcostmod == "CY" ) {
						if( lvfmnod == "" || lvtonod == "" ) {
							ComShowCodeMessage("TRS90104");
							return false;
						} else if( lvdrnod != "" ) {
							ComShowCodeMessage("TRS90085");
							return false;
						} else {
							if( lvfmnod == lvtonod ) {
								ComShowCodeMessage("TRS90134");
								return false;
							}
						}
					} else {
						ComShowCodeMessage("TRS90049");
						return false;
					}
				} else {
//					Feeder T/S 구분을 위해서 Null 값 존재로 하기..							
//					ComShowCodeMessage("TRS90108");
				}
			}
		}
	}
	return true;
}
/*
* Work according to the Validation Check / Combined CNTR Trans. Check the relationship between Case One and Single Transportation
*/
function doDataEquals(sheetObj) { //In order to compare the data added.
	if( sheetObj.RowCount("I") < 2 ) {
		errMsg=ComGetMsg("TRS90037");
		ComShowMessage(errMsg);
		return false;
	}
	//Determine the number of data rows
	var fromRow=0;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		fromRow=arrRow[i];
		var lvFmnod=doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_cd")+sheetObj.GetCellValue(fromRow, "fm_nod_yard"), " ");
		var lvVinod=doSepRemove(sheetObj.GetCellValue(fromRow, "via_nod_cd")+sheetObj.GetCellValue(fromRow, "via_nod_yard"), " ");
		var lvTonod=doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_cd")+sheetObj.GetCellValue(fromRow, "to_nod_yard"), " ");
		var lvDrnod=doSepRemove(sheetObj.GetCellValue(fromRow, "dor_nod_cd")+sheetObj.GetCellValue(fromRow, "dor_nod_yard"), " ");
		var lvOutInTS=sheetObj.GetCellValue(fromRow, "trsp_bnd_cd"); //IN, OUT, T/S
		var lvCostMod=sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd"); //CY, DOOR
		var lvCrrmodcd=sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd"); //TW, WT
		if( lvCrrmodcd.indexOf("T") < 0 ) {
			sheetObj.SetRowStatus(fromRow,"R");//false
			sheetObj.SetCellValue(fromRow, "chk1","0",0);
			sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
		} else {
			if( sheetObj.GetCellValue(fromRow, "eq_tpsz_cd").substring(1) == "2" ) {
				if( lvOutInTS == "O" || lvOutInTS == "I" ) {
					if( lvCostMod == "CY" ) {
						if( lvFmnod == lvTonod ) {
							sheetObj.SetCellValue(fromRow, "chk1","0",0);
							sheetObj.SetRowStatus(fromRow,"R");
							sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
						} else {
							if( lvFmnod == "" || lvTonod == "" || lvDrnod != "" ) {
								sheetObj.SetCellValue(fromRow, "chk1","0",0);
								sheetObj.SetRowStatus(fromRow,"R");
								sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
							}
						}
					} else if( lvCostMod == "DOOR" ) {
						if( lvFmnod == "" || lvTonod == "" || lvDrnod == "" ) {
							sheetObj.SetCellValue(fromRow, "chk1","0",0);
							sheetObj.SetRowStatus(fromRow,"R");
							sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
						}
					} else {
						sheetObj.SetCellValue(fromRow, "chk1","0",0);
						sheetObj.SetRowStatus(fromRow,"R");
						sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
					}
				} else if( lvOutInTS == "T" ) {
					if( lvCostMod == "CY" ) {
						if( lvFmnod == lvTonod ) {
							sheetObj.SetCellValue(fromRow, "chk1","0",0);
							sheetObj.SetRowStatus(fromRow,"R");
							sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
						} else {
							if( lvFmnod == "" || lvTonod == "" ) {
								sheetObj.SetCellValue(fromRow, "chk1","0",0);
								sheetObj.SetRowStatus(fromRow,"R");
								sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
							}
						}
					} else {
						sheetObj.SetCellValue(fromRow, "chk1","0",0);
						sheetObj.SetRowStatus(fromRow,"R");
						sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
					}
				} else {
					sheetObj.SetCellValue(fromRow, "chk1","0",0);
					sheetObj.SetRowStatus(fromRow,"R");
					sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
				}
			} else {
				sheetObj.SetCellValue(fromRow, "chk1","0",0);
				sheetObj.SetRowStatus(fromRow,"R");
				sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
			}
		}
	}
	return true;
}
/*
* Combined CNTR Trans. Case Two out of
*/
function doOfficeTrans(sheetObj) {
	var fromRow=0;
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
/*
*Combined CNTR Trans. Case Two out of
*/
function doCombinedTwo(sheetObj) {
	var fromRow=0;
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");
		for( var i=0; i < arrRow.length; i++ ) {
			fromRow=arrRow[i];
			if( sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd").indexOf("T") < 0 ) {
				errMsg=ComGetMsg("TRS90060");
				ComShowMessage(errMsg);
				return false;
			} else {
				if( sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd") == "DOOR" ) {
					if( sheetObj.GetCellValue(fromRow, "trsp_bnd_cd") != "I" ) {
						errMsg=ComGetMsg("TRS90012");
						ComShowMessage(errMsg);
						return false;
					}
				}
			}
		}
	}
	return true;
}
/*
* Multiple Apply check for
* Generate Multiple Apply Popup
*/
function doMultipleApply(sheetObj) {
	objInit();
	var objArray=new Array(); //Cost Mode
	var objTrans=new Array(); //Transportation Mode
	var objFrm=new Array(); //From Node
	var objVia=new Array(); //Via Node
	var objTo=new Array(); //To Node
	var objDoor=new Array(); //Door Location
	var lvCostMode=""; //Cost Mode
	var lvTransMode=""; //Transportation Mode
	var lvFrmNode=""; //From Node
	var lvViaNode=""; //Via Node
	var lvToNode=""; //To Node
	var lvDoor=""; //Door Location
	var lv_conti_cd="";
	var lv_bound_cd="";
	var chkTM=true;
	var chkFN=true;
	var chkVN=true;
	var chkTN=true;
	var chkDR=true;
	var j=0;
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	for( var i=0; i<sheetObj.RowCount(); i++ ) {
		if( sheetObj.GetCellValue(i+2, "chk1") == "1" ) {
			objArray[j]=sheetObj.GetCellValue(i+2, "trsp_cost_dtl_mod_cd");
			objTrans[j]=sheetObj.GetCellValue(i+2, "trsp_crr_mod_cd");
			objFrm[j]=sheetObj.GetCellValue(i+2, "fm_nod_cd2") + "|" + sheetObj.GetCellValue(i+2, "fm_nod_yard2");
			objVia[j]=sheetObj.GetCellValue(i+2, "via_nod_cd2") + "|" + sheetObj.GetCellValue(i+2, "via_nod_yard2");
			objTo[j]=sheetObj.GetCellValue(i+2, "to_nod_cd2") + "|" + sheetObj.GetCellValue(i+2, "to_nod_yard2");
			objDoor[j]=sheetObj.GetCellValue(i+2, "dor_nod_cd2") + "|" + sheetObj.GetCellValue(i+2, "dor_nod_yard2");
			//jsk:20071210
			lv_conti_cd=sheetObj.GetCellValue(i+2, "fm_loc_conti_cd");
			//jsk:20071210		
			j++;
		}
	}
	/** MULTIPLE APPLY conditions
	 * 1. COST MODE
	 * 2. BOUND ?
	 */
	for( var i=0; i<objArray.length; i++ ) {
		lvCostMode=objArray[i]; //CostMode
		lvTransMode=objTrans[i]; //
		lvFrmNode=objFrm[i]; //From Node
		lvViaNode=objVia[i]; //Via Node
		lvToNode=objTo[i]; //To Node
		lvDoor=objDoor[i]; //Door Location
		for( var j=0; j<objArray.length; j++ ) {
			if( lvCostMode != objArray[j] ) 
				lvCostMode="NO"; //CostMode
			if( lvTransMode != objTrans[j] ) 
				chkTM=false; //Transprotation Mode
			if( lvFrmNode != objFrm[j] ) 
				chkFN=false; //From Node
			if( lvViaNode != objVia[j] ) 
				chkVN=false; //Via Node
			if( lvToNode != objTo[j] ) 
				chkTN=false; //To Node
			if( lvDoor != objDoor[j] ) 
				chkDR=false; //Door Location
		}
		if( lvCostMode == "NO" ) {
			errMsg=ComGetMsg("TRS90127");
			ComShowMessage(errMsg);
			return false;
			break;
		}
	}
	HPut("CM", lvCostMode); //Cost Mode
	if( chkTM ) HPut("TM", lvTransMode);
	else HPut("TM", "NULL");
	if( chkFN ) HPut("FN", lvFrmNode);
	else HPut("FN", "NULL");
	if( chkVN ) HPut("VN", lvViaNode);
	else HPut("VN", "NULL");
	if( chkTN ) HPut("TN", lvToNode);
	else HPut("TN", "NULL");
	if( chkDR ) HPut("DR", lvDoor);
	else HPut("DR", "NULL");
	//jsk:20071210-start
	if( chkDR ) HPut("CONTI_CD", lv_conti_cd);
	else HPut("CONTI_CD", "NULL");
	//jsk:20071210-end
	return true;
}

//From Node1 / 2, the date, time, Via Node1 / 2, To Node1 / 2, the date, time, Door Loc1 / 2, the date, time
function doTimeCheck(of, of2, ov, ov2, ot, ot2, od, od2, fs, fs2, ts, ts2, ds, ds2, fsec, fsec2, tsec, tsec2, dsec, dsec2) {
	var lvFtime=10000; //From Departure
	var lvTtime=10000; //To Departure
	var standTime=7200; //Every time interval
	var standTime2=-7200; //Every time interval
	var lvFdep=dateCalcuration(fs, fs2); //Planned Time(From Departure) : fs2-fs
	var lvTarr=dateCalcuration(ts, ts2); //Planned Time(To Arrival)     : ts2-ts
	if( of == of2 && ov == ov2 && ot == ot2 && od == od2 ) { //Comparison of Location Information
		if( fs!="" && fs2!="" && fsec!="" && fsec2!="" && ts!="" && ts2!="" && tsec!="" && tsec2!="" ) {
			if( lvFdep == -1 ) { //From Departure Time
				lvFtime=eval((Number(fsec.substring(0,2))+24)*60*60 + Number(fsec.substring(2,4))*60 + Number(fsec.substring(4))) - eval(Number(fsec2.substring(0,2))*60*60 + Number(fsec2.substring(2,4))*60 + Number(fsec2.substring(4)));
			} else if( lvFdep == 1 ) {
				lvFtime=eval((Number(fsec2.substring(0,2))+24)*60*60 + Number(fsec2.substring(2,4))*60 + Number(fsec2.substring(4))) - eval(Number(fsec.substring(0,2))*60*60 + Number(fsec.substring(2,4))*60 + Number(fsec.substring(4)));
			} else if( lvFdep == 0 ) { //If the same date
				lvFtime=eval(Number(fsec.substring(0,2))*60*60 + Number(fsec.substring(2,4))*60 + Number(fsec.substring(4))) - eval(Number(fsec2.substring(0,2))*60*60 + Number(fsec2.substring(2,4))*60 + Number(fsec2.substring(4)));
			} else {
				return false;
			}
			if( lvFtime > standTime || lvFtime < standTime2 ) { //From Departrue Planned Time is not within two hours
				return false;
			}
			if( lvTarr == -1 ) { //To Arrival Time
				lvTtime=eval((Number(tsec.substring(0,2))+24)*60*60 + Number(tsec.substring(2,4))*60 + Number(tsec.substring(4))) - eval(Number(tsec2.substring(0,2))*60*60 + Number(tsec2.substring(2,4))*60 + Number(tsec2.substring(4)));
			} else if( lvTarr == 1 ) {
				lvTtime=eval((Number(tsec2.substring(0,2))+24)*60*60 + Number(tsec2.substring(2,4))*60 + Number(tsec2.substring(4))) - eval(Number(tsec.substring(0,2))*60*60 + Number(tsec.substring(2,4))*60 + Number(tsec.substring(4)));
			} else if( lvTarr == 0 ) { //If the same date
				lvTtime=eval(Number(tsec.substring(0,2))*60*60 + Number(tsec.substring(2,4))*60 + Number(tsec.substring(4))) - eval(Number(tsec2.substring(0,2))*60*60 + Number(tsec2.substring(2,4))*60 + Number(tsec2.substring(4)));
			} else {
				return false;
			}
			if( lvTtime > standTime || lvTtime < standTime2 ) { //To Arrival Planned Time is not within two hours
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}
	return true;
}

function IBS_Sheet2SheetStatus3_2(fromSheet, sStatus, bgObj) {
	if (typeof fromSheet == null || fromSheet.tagName == "undefined")
		return false;
	
	var fromRow=0;
	var sRow=fromSheet.FindCheckedRow(sStatus);
	var arrRow=sRow.split("|");
	for( var ir=arrRow.length-1; ir >=0 ; ir-- ) {
		fromRow=arrRow[ir];
		fromSheet.RowDelete(fromRow, false);
	}
	if( bgObj == "YES" ) {
		IBS_Sheet2SheetStatus4(fromSheet);
	}
}
//If you open the pop-up handle to handle dtPopupEdit
var lvRow=0;
function t1sheet1_OnPopupClick(sheetObj, row, col) {
	if( sheetObj.ColSaveName(col) == "act_cust_cd" ) {
		lvRow=row;
		var lvdor_node=sheetObj.GetCellValue(row, "dor_nod_cd"     );
		if(lvdor_node == "" || lvdor_node == null)    return;  /* DOOR TERM 이 아닌경우 ACTUAL CUSTOMER POPUP DISABLED - 2007/11/23 */
		var lv_zone_cd=sheetObj.GetCellValue(row, "dor_nod_yard"   );
		var lv_act_cust_cd=sheetObj.GetCellValue(row, "act_cust_cd"    );
		var lv_fctry_nm=sheetObj.GetCellValue(row, "fctry_nm"       );
		var lv_conti_cd=sheetObj.GetCellValue(row, "fm_loc_conti_cd");
		var lv_bound_cd=sheetObj.GetCellValue(row, "trsp_bnd_cd"    );
		var url='ESD_TRS_0914.screen?act_loc='+lvdor_node+"&zone_cd="+lv_zone_cd+"&bound_cd="+lv_bound_cd+"&act_cust_cd="+lv_act_cust_cd+"&row="+row+"&conti_cd="+lv_conti_cd+"&fctry_nm="+lv_fctry_nm;
    	ComOpenPopup(url, 800, 600, 'window', '0,0', true);
	} else if( sheetObj.ColSaveName(col) == "mlt_stop_de_flg" ) {
		lvRow=row;
		if( sheetObj.GetCellValue(row, "mlt_stop_de_flg") == "Y" ) {
			var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
			var lvbl=sheetObj.GetCellValue(row, "bl_no");
			var lveq=sheetObj.GetCellValue(row, "eq_no");
			var lvts=sheetObj.GetCellValue(row, "eq_tpsz_cd");
			var lvtro=sheetObj.GetCellValue(row, "tro_seq");
			var url="ESD_TRS_0933.do?bkgnumber="+lvbkg+"&blnumber="+lvbl+"&cntrnumber="+lveq+"&tpsznumber="+lvts+"&troseqnumber="+lvtro;
			ComOpenPopup(url, 800, 420, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		}
	} else if( sheetObj.ColSaveName(col) == "spcl_cgo_cntr_tp_cd" ) {
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var lvtro_seq=sheetObj.GetCellValue(row, "tro_seq");
		var lvui_conti_cd=document.form.ui_conti_cd.value;
		if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'DG' ) {
			var url="ESD_TRS_0938Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			ComOpenPopup(url, 800, 570, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		} else if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'BB' ) {
			var url="ESD_TRS_0937Pop.do?bkg_no="+lvbkg;
			ComOpenPopup(url, 800, 570, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		} else if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'AK' ) {
			//Awkward Cargo Inquiry
			var url="ESD_TRS_0936Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			ComOpenPopup(url, 800, 570, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		} else if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'RF' ) {
			//Refer Cargo Inquiry
			var url="ESD_TRS_0935Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			ComOpenPopup(url, 800, 570, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		}
	} else if( sheetObj.ColSaveName(col) == "inter_rmk" ) { // Internal Remark Popup
		var lvbkg = sheetObj.GetCellValue(row, "bkg_no");
		var lveqno = sheetObj.GetCellValue(row, "eq_no");
		var url = "ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&inter_rmk_cd=T";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}
//Actual Customer's Return Value Pop-Up
/* 0. TARGET ROW
* 1. ACTUAL CUSTOMER CODE
* 2. ACTUAL CUSTOMER NAME
* 3. FACTORY NAME
* 4. FACTORY ZIP CODE
* 5. FACTORY ADDRESS
* 6. FACTORY ADDRESS SEQ.
* 7. TEL NO
* 8. FAX NO
* 9. PIC NAME
*/
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {
	if( sheetObjects[0].GetCellValue(selected_row, "trsp_cost_dtl_mod_cd") == "DOOR" ) {
  		sheetObjects[0].SetCellValue(selected_row, "act_cust_cd",act_cust_cd      ,0);/* act_cust_cnt_cd + act_cust_seq */
  		sheetObjects[0].SetCellValue(selected_row, "act_cust_cnt_cd",act_cust_cnt_cd  ,0);
  		sheetObjects[0].SetCellValue(selected_row, "act_cust_seq",act_cust_seq     ,0);
		sheetObjects[0].SetCellValue(selected_row, "act_cust_addr_seq",act_cust_addr_seq,0);
		sheetObjects[0].SetCellValue(selected_row, "fctry_nm",factory_nm       ,0);
		sheetObjects[0].SetCellValue(selected_row, "dor_pst_cd",factory_zip_code ,0);
		sheetObjects[0].SetCellValue(selected_row, "dor_de_addr",factory_addr     ,0);
		sheetObjects[0].SetCellValue(selected_row, "cntc_pson_phn_no",factory_tel_no   ,0);
		sheetObjects[0].SetCellValue(selected_row, "cntc_pson_fax_no",factory_fax_no   ,0);
		sheetObjects[0].SetCellValue(selected_row, "cntc_pson_nm",pic_nm           ,0);
	}
//  ComClosePopup(); 
}
//Changes the background color and the part of CB
function IBS_Sheet2SheetStatus4(fromSheet) {
	var iz=0;
	var cs=0;
	for( var i=0; i < fromSheet.RowCount(); i++ ) {
		if( i % 2 == 0 )
			iz++;
		if( cs == 0 )
			cs=1;
		else if( cs == 1 )
			cs=2;
		else if( cs == 2 )
			cs=1;
		if( iz % 2 == 0 ) {
			fromSheet.SetCellValue(i+2, "trsp_so_cmb_seq",iz+"-"+cs,0);
			fromSheet.SetRowBackColor(i+2,"#NANNANNAN");
		} else {
			fromSheet.SetCellValue(i+2, "trsp_so_cmb_seq",iz+"-"+cs,0);
			fromSheet.SetRowBackColor(i+2,"#FFFFFF");
		}
	}
}
/*
* Get a list of external combo box (ESD_TRS_0003.js also exists).
*/
function getComboList(obj, comObj, sep) { //object, taking the value portion, 'Node kind
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
	obj.value=lvobj;
	if( lvobj == "" || lvobj.length < 5) {
		obj.value="";
		comObj.RemoveAll();
		return false;
	} 
	if( !doengnumcheck(lvobj) ) {
		obj.value="";
		comObj.RemoveAll();
		return false;
	}
	if( sep == 'F' ) {
		formObj.TRSP_SO_EQ_KIND.value="";
		formObj.search_fm_node.value="";
		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'V' ) {
		formObj.TRSP_SO_EQ_KIND.value="";
		lvViaNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		formObj.TRSP_SO_EQ_KIND.value="A";
		formObj.search_to_node.value="";
		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'D' ) {
		formObj.TRSP_SO_EQ_KIND.value="";
		lvDoorLoc=getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.Focus();
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
		v6="zone";
	} else {
		v6="yard";
	}
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
* Common Node popup
*/
function openContractNoPopup() {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var classId="getContractNo";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="true";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var flag="";
	var cont_tp='';
	var cont_no='';
	if(formObject.contract_tp_cd[0].checked) flag="1";
	else if(formObject.contract_tp_cd[1].checked) flag="2";
	if(formObject.contract_no.value != '' && formObject.contract_no.value.length > 2) {
		cont_tp=formObject.contract_no.value.substring(0,3);
		cont_no=formObject.contract_no.value.substring(3);
	}
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	param += "&flag="+flag;
	param += "&cont_tp="+cont_tp;
	param += "&cont_no="+cont_no;
	ComOpenPopup('/opuscntr/COM_ENS_021.do' + param, 780, 465, 'getContractNo', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
function getContractNo(rowArray){
	var formObject=document.form;
	var colArray=rowArray[0];
	var in_val=colArray[2];
	formObject.contract_no.value=in_val;
}
/**
* popSearchPiCommCodeGrid process handling
*/
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl=getPopupURL(POPUP_PI_COMM);
	var myOption=getPopupOption(POPUP_PI_COMM);
	var url;
if(myWin!=null)  ComClosePopup(); 
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin=window.open(url, "piCommCodePop", myOption);
//	myWin.focus();
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
	search_door_yard.SetSelectCode(lvYard);
}
/**
* Common Trunk VVD popup
*/
function openTVVDPopup(obj) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var v1=""; //ETDETA
	var v2=""; //SDATE
	var v3=""; //EDATE
	var v4=""; //VVD_CD
	var v5=""; //LOC_CD
	var v6=""; //LANE_CD
	var v7=""; //OPER
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var classId=obj;
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 780, 490, classId, '1,0,1,1,1,1,1,1', true);
}
/**
* Trunk VVD return value
*/
function getCOM_ENS_VVD_1(rowArray) {
	var formObject=document.form;
	var gubun="";
	var colArray=rowArray[0];
	formObject.trunk_vvd.value=colArray[7] + gubun;
}

/**
* Feeder VVD return value
*/
function getCOM_ENS_VVD_2(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.txt_feeder_vvd.value = colArray[7] + gubun;
}

/**
* t1sheet1_OnSearchEnd
*/
function t1sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	formObj.rad_dateSep[0].disabled = false;
	formObj.rad_dateSep[1].disabled = false;
	formObj.rad_dateSep[2].disabled = false;
	formObj.unplan_shuttle.disabled = false;
	formObj.tro_unconfirm_dr.disabled = false;
    for(var k = sheetObj.HeaderRows(); k < sheetObj.RowCount() + sheetObj.HeaderRows(); k++)  {
        if(formObj.cydoor_div.value == "CY") {
       	    sheetObj.SetCellEditable(k, "dor_nod_pln_dt", 0);
       	    sheetObj.SetCellEditable(k, "dor_nod_pln_dt_hms", 0);
        } else {
            sheetObj.SetCellEditable(k, "dor_nod_pln_dt", 1);
            sheetObj.SetCellEditable(k, "dor_nod_pln_dt_hms", 1);
        }
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
function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj=document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_nod_yard" :
		case "via_nod_yard" :
		case "to_nod_yard" :
		case "dor_nod_yard" :  
			setYdNameToolTip(sheetObj, mouseRow, mouseCol, "o_" + colSaveName, formObj);
			break;
		case "fm_nod_cd" :
		case "via_nod_cd" :
		case "to_nod_cd" :
		case "dor_nod_cd" :	
			setLocationNameToolTip(sheetObj, mouseRow, mouseCol, "o_" + colSaveName, formObj);
			break;
		default : break;	
	}
}


/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param OrgNodYard
 * @param formObj
 */
function setYdNameToolTip(sheetObj, Row, Col, OrgNodYard, formObj) {
	var nodValue = sheetObj.GetCellValue(Row, Col-1);
	var ydValue = sheetObj.GetCellValue(Row, Col);
	var CurNodYard;
	if(!ComIsNull(ydValue)) {
		CurNodYard = nodValue + ydValue;
		if(CurNodYard != sheetObj.GetCellValue(Row, OrgNodYard )) {
			sheetObj.SetToolTipText(Row, Col, GetYardName(sheetObj, formObj, CurNodYard, "Y"));
			sheetObj.SetCellValue(Row, OrgNodYard, CurNodYard, 0);
		}
	} else {
		sheetObj.SetToolTipText(Row, Col, "");
		sheetObj.SetCellValue(Row, OrgNodYard, "", 0);
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param OrgNod
 * @param formObj
 */
function setLocationNameToolTip(sheetObj, Row, Col, OrgNod, formObj) {
	var nodValue = sheetObj.GetCellValue(Row, Col);
	if(!ComIsNull(nodValue)) {
		if(nodValue != sheetObj.GetCellValue(Row, OrgNod )) {
			sheetObj.SetToolTipText(Row, Col, GetYardName(sheetObj, formObj, nodValue, "N"));
			sheetObj.SetCellValue(Row, OrgNod, nodValue, 0);
		}
	} else {
		sheetObj.SetToolTipText(Row, Col, "");
		sheetObj.SetCellValue(Row, OrgNod, "", 0);
	}
}

/**
* sheet2_OnSearchEnd
*/
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObject=document.form;
	var cmbTbcd = document.form.cbstatus.value;
	var sheetObjOrigin;
	var cmbSep="";
	if( cmbTbcd == "" ) {
		sheetObjOrigin=sheetObjects[0];
		cmbSep="NO";
	} else if( cmbTbcd == "CF" ) {
		sheetObjOrigin=sheetObjects[1];
		cmbSep="YES";
	} else if( cmbTbcd == "CS" ) {
		sheetObjOrigin=sheetObjects[2];
		cmbSep="YES";
	}
	if( errMsg.length > 0 ) {
		return;
	} else {
		var f = formObject.f_cmd.value;
	    if( f != SEARCH20 && f != SEARCH19) {
		    ComShowMessage(ComGetMsg("TRS90107"));
		    IBS_Sheet2SheetStatus3_2(sheetObjOrigin, "chk1", cmbSep);
	    } else if(f == SEARCH20) {
	    	if(ComIsNull(errMsg)) {
	    		ComShowMessage(ComGetMsg("TRS90107"));
	    		IBS_Sheet2SheetStatus3_2(sheetObjOrigin, "chk1", cmbSep);
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
	var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 415, "getTRS_ENS_906", '0,1', true);
}
/**
* Location: If a pop-up from a single selection.
*/
function getTRS_ENS_906(rowArray, obj) {
	var reObj="";
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj=reObj + colArray;
		} else {
			reObj=reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value=reObj;
	} else if( obj == "BKG" ) {
		formObject.bkg_no.value=reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value=reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value=multiCntrChkDgt(reObj);
	} else if( obj == "FVD" ) {
		formObject.txt_feeder_vvd.value=reObj;
	} else if( obj == "ZIP" ) {
		formObject.zip_code.value=reObj;
	} else if( obj == "FM_NODE" ) {
		formObject.search_fm_node.value=reObj;
		resetLocYard("FROM");
	} else if( obj == "TO_NODE" ) {
		formObject.search_to_node.value=reObj;
		resetLocYard("TO");
	} else if( obj == "ECC") {
		formObject.ecc_cd.value=reObj;
	} else {
		errMsg=ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}
/*
* Calendar Pop-Up Multi-Input
*/
function getCalendar() {
	var cal=new ComCalendarFromTo();
	cal.displayType="date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}
function fun_checkcbox(lvobj) {
	sheetObjects[0].RemoveAll();
	if( lvobj == "01" ) {
		if( document.form.unplan_shuttle.checked ) {
			document.form.tro_unconfirm_dr.checked=false;
			document.form.frm_plandate.value="";
			document.form.to_plandate.value="";
			document.form.hid_frmdate.value="";
			document.form.hid_todate.value="";
			document.form.search_via_loc.value="";
			document.form.search_to_loc.value="";
			document.form.search_to_node.value="";
			document.form.search_door_loc.value="";
			search_via_yard.RemoveAll();
			search_to_yard.RemoveAll();
			search_door_yard.RemoveAll();
			sel_costmode.SetEnable(0);
			document.form.sel_bound[0].selected=true;
			document.form.sel_transmode[0].selected=true;
			document.getElementById("frm_plandate").className = "input2";
			document.getElementById("to_plandate").className = "input2";
			document.getElementById("search_fm_loc").className = "input1";
			document.form.frm_plandate.disabled=true;
			document.form.to_plandate.disabled=true;
			document.form.sel_bound.disabled=true;
			document.form.sel_transmode.disabled=true;
			document.form.search_via_loc.disabled=true;
			search_via_yard.SetEnable(0);
			document.form.search_to_loc.disabled=true;
			document.form.search_to_node.disabled=true;
			search_to_yard.SetEnable(0);
			document.form.search_door_loc.disabled=true;
			search_door_yard.SetEnable(0);
			document.form.btns_calendar.style.visibility="hidden";
			document.form.btns_vianode.style.visibility="hidden";
			document.form.btns_tonode.style.visibility="hidden";
			document.form.btns_multi_search_to_node.style.visibility="hidden";
			document.form.btns_dorloc.style.visibility="hidden";
		} else {
			fun_disabled();
		}
	} else if( lvobj == "02" ) {
	} else if( lvobj == "03" ) {
		fun_disabled();
		if( document.form.tro_unconfirm_dr.checked ) {
			document.form.unplan_shuttle.checked=false;
		}
	} else {
		fun_disabled();
		document.form.tro_unconfirm_dr.checked=false;
	}
	
	if(document.form.tro_unconfirm_dr.checked) {
		ComBtnDisable("btng_socreation1");
	} else {
		ComBtnEnable("btng_socreation1");
	}	
}
function fun_disabled() {
	document.getElementById("frm_plandate").className = "input1";
	document.getElementById("to_plandate").className = "input1";
	document.getElementById("search_fm_loc").className = "";
	document.form.frm_plandate.disabled=false;
	document.form.to_plandate.disabled=false;
	document.form.sel_bound.disabled=false;
	sel_costmode.SetEnable(1);
	document.form.sel_transmode.disabled=false;
	document.form.search_via_loc.disabled=false;
	search_via_yard.SetEnable(1);
	document.form.search_to_loc.disabled=false;
	document.form.search_to_node.disabled=false;
	search_to_yard.SetEnable(1);
	document.form.search_door_loc.disabled=false;
	search_door_yard.SetEnable(1);
	document.form.btns_calendar.style.visibility="visible";
	document.form.btns_vianode.style.visibility="visible";
	document.form.btns_tonode.style.visibility="visible";
	document.form.btns_multi_search_to_node.style.visibility="visible";
	document.form.btns_dorloc.style.visibility="visible";
}
//Object of passing on the pop-up Sheet
function openObjSheet() {
	return sheetObjects[0];
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
//When the Click Include Check Bok
function fun_chkOffice() {
	var doc_office=document.form.chk_office;
	var prm_office=doSepRemove(document.form.ctrl_so_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked=false;
		document.form.ctrl_so_office.value="";
		ComShowMessage("Please input the 'S/O Office'!!");
		document.form.ctrl_so_office.disabled=false;
		return false;
	}
	if( doc_office.checked == true ) {
		var url="ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value=prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=subCntorlOffice;
		request.send(null);
		document.form.ctrl_so_office.disabled=true;
	} else {
		document.form.ctrl_so_office.value=document.form.old_ofc_cd.value;
		document.form.ctrl_so_office.disabled=false;
	}
}
function fun_ParentOffice() {
	var doc_office=document.form.chk_office;
	if( doc_office.checked == true ) {
		document.form.prnt_ofc_cd.value=document.form.old_ofc_cd.value;
	} else {
		document.form.prnt_ofc_cd.value=document.form.ctrl_so_office.value;
	}
}
//Brings the value of Office.
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
			document.form.ctrl_so_office.value=text_ofc.substring(0, text_ofc.length-1);
		}
	}
}
//Office-PopUp Validation Checked
function validation_check() {
	var doc_office=document.form.chk_office;
	var prm_office=doSepRemove(document.form.ctrl_so_office.value.toUpperCase(), " "); //input text
	var aoffice=prm_office.split(",");
	if( prm_office == "" ) {
		document.form.ctrl_so_office.value="";
		ComShowCodeMessage("TRS90430");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowCodeMessage("TRS90429");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;
		} else {
			ComShowCodeMessage("TRS90429");
			return false;
		}
	}
}
//Text changes in Office
function fun_officeText() {
	document.form.ctrl_so_office.value=document.form.ctrl_so_office.value.toUpperCase();
	document.form.chk_office.checked=false;
}
function t1sheet1_OnSelectMenu(sheetObj, MenuString){
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
function deleteSOCandidate(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var checkList=sheetObj.FindCheckedRow('chk1');
	var checkArray=checkList.split('|');
	if(checkList == ''){
		ComShowCodeMessage('TRS90215');
		return false;
	}
  //N200902230070 2009-02-26 TRS SO delete Change the target range, TD -> full
	if(!confirm(ComGetMsg('COM12165', 'SO Candidates'))) return false;
	formObj.f_cmd.value=REMOVE01;
	sheetObj.DoSave("ESD_TRS_0002GS.do", TrsFrmQryString(formObj), 'chk1', false);
}
//Verify Check CNTR jikbannap
function offHireVerify(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.f_cmd.value=SEARCH07;
	var eqno="";
	if(sheetObj.RowCount()< 1){
		ComShowCodeMessage('TRS90386', 'First, Please inquiry');
		return false;
	}
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
    for( var i=1; i<sheetObj.RowCount()+2; i++ ) {
    	if( sheetObj.GetCellValue(i, "chk1") == "1" ) {
    		eqno=eqno + "&sel_cntr_no=" + sheetObj.GetCellValue(i, "eq_no");
    	}
    }
	eqno=eqno.substring(1, eqno.length);
 	sheetObjects[3].DoSearch("ESD_TRS_0002GS.do", eqno+'&'+TrsFrmQryString(formObj),{Sync:2} );
}
function rtnsheet_OnSearchEnd(sheetObj, errMsg) {
	var main_sheet=sheetObjects[0];
	var cnt=0;
	for(i=1;i<main_sheet.RowCount()+2;i++) {
		if( main_sheet.GetCellValue(i, "chk1") == "1" ) {
			for(j=1;j<sheetObj.RowCount()+1;j++) {
				if (main_sheet.GetCellValue(i, "eq_no") == sheetObj.GetCellValue(j, "cntr_no")) {
					main_sheet.SetCellValue(i, "to_nod_cd",sheetObj.GetCellValue(j, "offh_yd_cd").substring(0,5),0);
					main_sheet.InitCellProperty(i,"to_nod_yard",{ Type:"Text"});
					main_sheet.SetCellText(i, "to_nod_yard" ,sheetObj.GetCellValue(j, "offh_yd_cd").substring(5,7));
					main_sheet.SetCellValue(i, "lse_cntr_flg","Y",0);
					main_sheet.SetRangeFontColor(i,12,i,13,"#FF0000");
					cnt++;
				}
			}
		}
	}
	ComShowMessage("Off Hire Verify Success ("+ cnt +" case)");
}
/**
* t1sheet1_OnSaveEnd
*/
function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	 var formObj=document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == REMOVE01){
			if(!formObj.tro_unconfirm_dr.checked){
				var checkList=sheetObj.FindCheckedRow('chk1');
				var checkArray=checkList.split('|');
				for(var k=checkArray.length-1; k>=0; k--){
					sheetObj.RowDelete(checkArray[k], false);
				}
			}
			ComShowCodeMessage('COM12167', 'SO Candidates');
		}
	}
}
/**
* CY / DOOR classification views the Cost Mode
**/
function getCostModeList(sheetObj, formObject) {
	 formObject.f_cmd.value = SEARCH08;
	 var sXml = sheetObj.GetSearchData("ESD_TRS_0002GS.do", TrsFrmQryString(formObject));
	 return ComGetEtcData(sXml,'COST_MODE');
}
/**
* CY / DOOR classification according Cost Mode is set to combo lookup history.
**/
function getCostModeCombo(comboObj) {
	var formObj = document.form;
	var CostModeList = getCostModeList(sheetObjects[0], formObj);
	var CostModeArray = CostModeList.split("|");
	sel_costmode.RemoveAll();
	sel_costmode.InsertItem(0, "ALL", "ALL");
	for ( var i = 1; i < CostModeArray.length + 1; i++) {
		sel_costmode.InsertItem(i, CostModeArray[i - 1].substring(2), CostModeArray[i - 1].substring(0, 2));
	}
	sel_costmode.SetSelectIndex(0);
	var cydoor_div = formObj.cydoor_div.value;
	if (cydoor_div == "DR") {
		formObj.rad_dateSep[1].disabled = false;
	} else {
		formObj.rad_dateSep[0].checked = true;
		formObj.rad_dateSep[1].disabled = true;
	}
	sheetObjects[0].RemoveAll();
}


function resetLocYard(which) {
	var formObj = document.form;
	if(which == 'FROM') {
		if(formObj.search_fm_node.value.length > 0) {
			formObj.search_fm_loc.value = "";
			search_fm_yard.RemoveAll();
		}
	} else {
		if(formObj.search_to_node.value.length > 0) {
			formObj.search_to_loc.value = "";
			search_to_yard.RemoveAll();
		}
	}
}

/**
 * Calling from [Port] Pop-up
 * @param rtnObjs
 * @return
 */
function returnPortHelp(rtnObjs) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if(rtnObjs){
		var rtnDatas = rtnObjs;
		if(rtnDatas) {
			if(rtnDatas.length > 0) {
				formObj.port_cd.value=rtnDatas[0];
				formObj.port_nm.value=rtnDatas[1];
			}
		}
	}
}

/**
 * 
 * @param SheetObject
 * @param Row
 * @param ColCodeColumn
 * @param ColNameColumn
 * @param ZoneValue
 * @returns
 */
function GetZoneName(SheetObject, Row, ColCodeColumn, ColNameColumn, ZoneValue) {
	var YardValue = SheetObject.GetCellValue(Row, ColCodeColumn) + ZoneValue;
	if(YardValue != '') {
		if(YardValue.length == 5) {
			SheetObject.SetCellValue(Row, ColNameColumn, GetYardName(SheetObject, document.form, YardValue, "N"), 0);
		} else if(YardValue.length == 7) {
			SheetObject.SetCellValue(Row, ColNameColumn, GetYardName(SheetObject, document.form, YardValue, "Y"), 0);
		}        		
	}
}


/**
 * DATE VALIDATION LOGIC ON WORK ORDER POP UP VERIFICATION MSG
 * 
 * @param sheetObject
 * @param Row
 * @returns {Boolean}
 */
function funcWoDateValidCheck(sheetObject, Row) {
	var fromDt = sheetObject.GetCellValue(Row, "n1st_nod_pln_dt") + sheetObject.GetCellValue(Row, "n1st_nod_pln_dt_hms");
	if (fromDt.length < 8) {
		fromDt = "";
	} else if (fromDt.length == 8) {
		fromDt += "000000";
	}

	var toDt = sheetObject.GetCellValue(Row, "lst_nod_pln_dt") + sheetObject.GetCellValue(Row, "lst_nod_pln_dt_hms");
	if (toDt.length < 8) {
		toDt = "";
	} else if (toDt.length == 8) {
		toDt += "000000";
	}
	var doorDt = sheetObject.GetCellValue(Row, "dor_nod_pln_dt") + sheetObject.GetCellValue(Row, "dor_nod_pln_dt_hms");
	if (doorDt.length < 8) {
		doorDt = "";
	} else if (doorDt.length == 8) {
		doorDt += "000000";
	}

	if (fromDt != '' && toDt != '') {
		if (TrsComGetTimeBetween(fromDt, toDt) <= 0) {
			return false;
		}
	}
	if (fromDt != '' && doorDt != '') {
		if (TrsComGetTimeBetween(fromDt, doorDt) <= 0) {
			return false;
		}
	}
	if (doorDt != '' && toDt != '') {
		if (TrsComGetTimeBetween(doorDt, toDt) <= 0) {
			return false;
		}
	}
	return true;
}

//Focusing
function fun_Focus(obj) {
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

function toUpperCase(obj) {
    obj.value = obj.value.toUpperCase();
}

/**
* Common Node popup
*/
function openEccPopUp(objName) {
	var param = "?main_page=false&scc_flg=Y&title_flg=N"
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 425, objName, '0,0');
}

//ECC
function getEccCode(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.ecc_cd.value = colArray[7];
}
