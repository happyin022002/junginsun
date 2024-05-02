/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0051.js
*@FileTitle  : CY & Door 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
//var tabObjects = new Array();
var tabCnt=0 ;
var beforetab=1;
var beforetab2=1;
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
var R=222;
var G=251;
var B=248;
var doc_tabObj=null; 
document.onclick=processButtonClick;
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var sheetObject3=sheetObjects[3];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve": {
				if( validateFormSearch(formObject) ) {
					formObject.rad_wo_issued[0].disabled=true;
					formObject.rad_wo_issued[1].disabled=true;
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
				}
				break;
			}
			case "btn_new": {
				formObject.reset();
				search_fm_yard.RemoveAll();
				search_via_yard.RemoveAll();
				search_to_yard.RemoveAll();
				search_door_yard.RemoveAll();
				formObject.rad_dateSep[3].disabled=true;
				formObject.wo_no.disabled=true;
				formObject.wo_no.value="";
				formObject.btns_multiwono.disabled=true;
				if( formObject.rad_dateSep[3].checked == true ) {
					formObject.rad_dateSep[0].checked=true;
				}
				document.all["id_woissue"].style.display = "inline";
				document.all["id_woissueno"].style.display = "none";
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				break;
			}
			case "btn_minimize":  {
				if(document.all.MiniLayer.style.display != "none") {
				    document.all.MiniLayer.style.display="none";                
				} else {
				    document.all.MiniLayer.style.display="";                
				}
				ComResizeSheet(sheetObject);
				break;
			}
			case "btng_multipleapply": {
				if(!checkChgIndFlg(sheetObject)) {
					return false;
				}				
				if( validationCheck(sheetObject) ) {
					if( doMultipleApply(sheetObject) ) {
						ComOpenPopup('ESD_TRS_0003.do', 800, 440, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
					}
				}
				break;
			}
			case "btns_calendar": {
				getCalendar();
				break;
			}
			case "btng_downexcel1": {
				if(sheetObject.RowCount() < 1) { 
					ComShowCodeMessage("COM132501");
				} else {
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObject), SheetDesign:1, Merge:1 });
				}
				break;
			}
			case "btng_socreation1": {
				if(!checkChgIndFlg(sheetObject)) {
					return false;
				}
				if(formObject.rad_wo_issued[1].checked) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "AA");
				} else {
					if( validationCheck(sheetObject) ) {
						if( validateForm(sheetObject, formObject) ) {
							doActionIBSheet(sheetObject, formObject, IBSAVE, "");
						}
					}
				}
				break;
			}
			case "btng_woissue1": {
				if(!checkChgIndFlg(sheetObject)) {
					return false;
				}
				doActionIBSheet(sheetObject1, formObject, IBSAVE, "WO");
				break;
			}
			case "btns_frmnode": {
				//FromNode Popup Window
				openHireYardPopup('getFromNode');
				break;
			}
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
				openTVVDPopup();
				break;
			case "btns_multivvd": //M Trunk VVD
				openMultipleinquiry('VVD', 'T.VVD');
			break;
			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;
			case "btns_multibl": { //M B/L No
				openMultipleinquiry('BLN', 'B/L No');
				break;
			}
			case "btns_multisono": { //S/O No
				openMultipleinquiry('SON', 'S/O No');
				break;
			}
			case "btns_multiwono": { //W/O No
				if( formObject.rad_wo_issued[1].checked == true ) {
					openMultipleinquiry('WON', 'W/O No');
				}
				break;
			}
			case "btns_multicntr": {
				openMultipleinquiry('CNT', 'CNTR No');
				break;
			}
			case "btng_containerselect": {
				if( validationCheck(sheetObject) ) {
					if( doContainerSelect(sheetObject) ) {
						if( document.form.hid_bkg.value == "" ) {
							ComShowMessage(ComGetMsg("TRS90114"));
						} else {
							ComOpenWindow("ESD_TRS_0908.do?mainSheetArrayNo=0",  'ESD_TRS_0908',  "width=750; height=500; help:no; status:no; resizable:no; scroll=no;" , false);
						}
					}
				}
				break;
			}
			case "btng_sodelete": {
				if(!checkChgIndFlg(sheetObject)) {
					return false;
				}
				doActionIBSheet(sheetObject, formObject, IBDELETE, "");
				break;
			}
			case "btns_vender": {
				rep_OnPopupClick();
				break;
			}
			case "btns_multizipcode": {
				openMultipleinquiry('ZIP', 'ZIP Code');
				break;
			}
			case "btng_offhireverify": {
				offHireVerify();
				break;
			}
			case "btns_multi_search_fm_node": {
				openMultipleinquiry('FM_NODE', 'NODE Code');
				break;
			}
			case "btns_multi_search_to_node": {
				openMultipleinquiry('TO_NODE', 'NODE Code');
				break;
			}
			case "btns_port": {
				var sUrl="/opuscntr/ESD_TRS_0981.do?port_cd=" + formObject.port_cd.value;
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
				break;
			}
            case "btns_cntr_slt_no": {
				openMultipleinquiry('SLOT_NO', 'SLOT Ref No');
                break;
            }
		}
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Shipment Change Check
 */
function checkChgIndFlg(SheetObject) {
	var checkList=SheetObject.FindCheckedRow('chk1');
	var arrRow=checkList.split("|");
    if(checkList == '') {
        ComShowCodeMessage('COM12176');
        return false;
    }	
    for (var idx=0; idx < arrRow.length; idx++) { 
    	var iCngIndFlg = SheetObject.GetCellValue( arrRow[idx] , "cng_ind_flg");
    	 if(iCngIndFlg == 'Y') {
         	ComShowCodeMessage('TRS90443');
         	return false;    
         }
    }
    return true;
}

/**
 * Register as an array IBSheet Object
 * setSheetObject
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * loadPage
 * After loading in your browser should display the ability to add pre-processing
 */
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); 
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); 
	}
	initControl();
	ComEnableObject(document.form.port_cd, false);
	document.form.btns_port.style.visibility="hidden";
}

/**
 * initControl
 **/
function initControl() {
    axon_event.addListenerFormat('blur',    'obj_blur',     form);
    axon_event.addListenerFormat('focus',   'obj_focus',    form);
    axon_event.addListenerFormat('change',  'obj_change',   form);  
}
/**
 * Validation of HTML Control will check in the onblur event. <br>
 **/
function obj_blur(){
    return ComChkObjValid(ComGetEvent());
}
/**
 * Validation of HTML Control will check in the onblur event. <br>
 **/
function obj_focus(){
    ComClearSeparator(ComGetEvent());
}
/**
 * Validation of HTML Control will check in onchange event. <br>
 **/
function obj_change(){
	var formObj=document.form;
	try {
		switch(ComGetEvent("name")) {
			case "port_cd": {
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
		}
	} catch(e) {
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
 * Sheet, the initial setting, the header definition
 * initSheet
 */
function initSheet(sheetObj,sheetNo) {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var sheetObject3=sheetObjects[3];
	var cnt=0;
	switch(sheetNo) {
		case 1: {
			with(sheetObj) {
				var HeadTitle0  ="Sel.|STS|SOURCE|SHPMT\nCM|SHPMT\nCM|S/O Candidate\nDelete|BKG\nStat.|S/O No|W/O No|trsp_so_sts_cd|Slot Ref No.|CNTR No.|TP / SZ|Original\nTP / SZ|Cost\nMode|CB\nSEQ|Trans\nMode";
					HeadTitle0 += "|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|Door Location" ;
					HeadTitle0 += "|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information" ;
					HeadTitle0 += "|Multi\nStop|Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|Latest Movement Status|Latest Movement Status|Latest Movement Status" ;
					HeadTitle0 += "|COP No|A/G SEQ|A/G Code|BKG No|BL No|BND|Term" ;
					HeadTitle0 += "|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information" ;
					HeadTitle0 += "|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|VGM Weight\n(KGS)|VGM Weight\n(LBS)|Weight|Weight\n(KGS)|Weight\n(LBS)|Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription" ;
					HeadTitle0 += "|Trunk\nVVD|Lane|in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.";
					HeadTitle0 += "|Available DT|Available DT|Last Free DT|Last Free DT|S/C No|Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit";
					HeadTitle0 += "|L/T|L/T\nEXP|Door\nSVC TP|Internal\nRemark|Remark\n(Special Instruction)|IRG";
					HeadTitle0 += "|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result";
					
				var HeadTitle1  ="Sel.|STS|SOURCE|SHPMT\nCM|SHPMT\nCM|S/O Candidate\nDelete|BKG\nStat.|S/O No|W/O No|trsp_so_sts_cd|Slot Ref No.|CNTR No.|TP / SZ|Original\nTP / SZ|Cost\nMode|CB\nSEQ|Trans\nMode";
					HeadTitle1 += "|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Name";
					HeadTitle1 += "|Actual\nCustomer|Factory\nName|Zip\nCode|Address|TEL|FAX|PIC";
					HeadTitle1 += "|Multi\nStop|From Departure|From Departure|To Arrival|To Arrival|Door Arrival|Door Arrival|Status|Yard|Date";
					HeadTitle1 += "|COP No|A/G SEQ|A/G Code|BKG No|BL No|BND|Term" ;
					HeadTitle1 += "|SEQ|CNFM|Office|User ID|Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No" ;
					HeadTitle1 += "|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|VGM Weight\n(KGS)|VGM Weight\n(LBS)|Weight|Weight\n(KGS)|Weight\n(LBS)|Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription" ;
					HeadTitle1 += "|Trunk\nVVD|Lane|in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.";
					HeadTitle1 += "|Available DT|Available DT|Last Free DT|Last Free DT|S/C No|Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit" ;
					HeadTitle1 += "|L/T|L/T\nEXP|Door\nSVC TP|Internal\nRemark|Remark\n(Special Instruction)|IRG" ;
					HeadTitle1 += "|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:11} );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk1" },
				             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"source",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Image",  	Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cng_ind_flg_img",          	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   ImgWidth:13, ImgHeight:13},
			                 {Type:"Text",  	Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cng_ind_flg",              	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
				             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trsp_rqst_bkg_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  	Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_slt_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_cost_dtl_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_yard",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"via_nod_yard",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_yard",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_yard",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dor_nod_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"fctry_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dor_pst_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"dor_de_addr",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_phn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_fax_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mlt_stop_de_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_nod_pln_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n1st_nod_pln_dt_hms",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lst_nod_pln_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lst_nod_pln_dt_hms",          KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_pln_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_pln_dt_hms",          KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",              	 KeyField:0,   CalcLogic:"",   Format:"",         	 PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",              	 KeyField:0,   CalcLogic:"",   Format:"",         	 PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",              		 KeyField:0,   CalcLogic:"",   Format:"",         	 PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cop_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_act_grp_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_act_grp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_bnd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rcvde_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_cnfm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_upd_dt1",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_upd_dt2",             KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"trsp_rqst_ord_rev_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tro_lod_ref_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_qty",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cntr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sealno",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sealno2",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vgm_kgs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",      		 PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vgm_lbs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",       	 PointCount:3,   UpdateEdit:0,   InsertEdit:0 },				             
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",                    KeyField:0,   CalcLogic:"",   Format:"",       	 PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_kgs_wgt",                KeyField:0,   CalcLogic:"",   Format:"",       	 PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_lbs_wgt",                KeyField:0,   CalcLogic:"",   Format:"",       	 PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"wgt_meas_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"noofpkg",                     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pkgcode",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_name",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trunkvvd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ib_vvd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ob_vvd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"shpr_cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cnee_cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ntfy_cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibd_cstms_clr_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_loc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cgor_frt_pay_ind_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cgor_org_bl_rcvr_ind_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cgor_cstms_acpt_re_ind_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_pkup_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"aval_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"aval_dt_hms",                 KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt_hms",             KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"customsclearance",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"customsclearanceNo",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rfano",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_exp_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dor_svc_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inter_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"spcl_instr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"irg",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trns_rqst_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trns_rqst_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"trns_rqst_rsn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"lse_cntr_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sub_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_nomi_trkr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rail_cmb_thru_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_yard2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"via_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"via_nod_yard2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_yard2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_yard2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_cost_dtl_mod_sep",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rc_seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ref_id",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"repo_pln_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"pln_yrwk",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"ref_seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"trsp_so_cmb_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dor_svc_tp_cd2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"act_cust_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"act_cust_addr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"conti_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnee_cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnee_cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"shpr_cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"shpr_cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpln_umch_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_fm_nod_yard",           	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_via_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_to_nod_yard",           	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_dor_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_fm_nod_cd",           	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_via_nod_cd",           	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_to_nod_cd",           	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_dor_nod_cd",           	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_seq",           	 	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"before_eq_no",           	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }	
				             ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetRangeBackColor(1, 13, 1, 28,"#555555");
		      SetRangeBackColor(1, 29, 1, 38,"#555555");
		      SetRangeBackColor(1, 42, 1, 54,"#555555");
		      SetRangeBackColor(1, 83, 1, 84,"#555555");
		      SetColProperty(0, 'trsp_rqst_bkg_flg', {ComboText:'YES|NO', ComboCode:'Y|N'} );
		      SetColProperty(0, 'trsp_crr_mod_cd', {ComboText:trsp_crr_mod_cdText, ComboCode:trsp_crr_mod_cdCode} );
		      SetColProperty(0, 'dor_svc_tp_cd', {ComboText:dor_svc_tp_cdText, ComboCode:dor_svc_tp_cdCode} );
		      ComResizeSheet(sheetObj);
			}
			break;
		}
		case 2: {
		    with(sheetObj) {
			      var HeadTitle0="Office Code|Seqence";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetVisible(false);
	            }
		    break;
		}
		case 3: {
		    with(sheetObj){
			      var HeadTitle0="RTN_VALUE|ACT_CUST_CNT_CD|ACT_CUST_SEQ|ACT_CUST_ADDR_SEQ|ACT_CUST_FCTRY_PST_CD|ACT_CUST_FCTRY_NM|ACT_CUST_FCTRY_ADDR|ACT_CUST_FCTRY_PHN_NO|ACT_CUST_FCTRY_FAX_NO|ACT_CUST_FCTRY_PIC_NO|ACT_CUST_EML|ACT_CUST_RMK";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rtn_value",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_addr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_pst_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_fctry_pic_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 } 
					             ];
			       
			      InitColumns(cols);
			      SetEditable(0);
			      SetVisible(false);
	            }
		    break;
		}
		case 4: {
		    with(sheetObj){
			      var HeadTitle0="CNTR_NO|OFFH_YD_CD";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];   
			      InitColumns(cols);
			      SetEditable(0);
			      SetVisible(false);
	            }
		    break;	
		}
	}
}
/*
 * When Enter Key
 */
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
		}
	}
}
/*
 * CONTAINER NO IMPORT section on
 */
function doContainerSelect(sheetObj) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var lvBkg="";
	//Determine the number of data rows
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "eq_no").length > 0 ) {
			ComShowMessage(ComGetMsg("TRS90045"));
			return false;
		}
		if( i == ( arrRow.length - 2 ) ) {
			lvBkg=lvBkg + sheetObj.GetCellValue(arrRow[i], "bkg_no");
		} else {
			lvBkg=lvBkg + sheetObj.GetCellValue(arrRow[i], "bkg_no") + ",";
		}
	}
	document.form.hid_bkg.value=lvBkg;
	return true;
}
/*
 * Lookup for the validity check
 */
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
	var lvwo_no=doSepRemove(formObj.wo_no.value, " ");
	var lvso_no=doSepRemove(formObj.so_no.value, " ");
	var lvzip_code=doSepRemove(formObj.zip_code.value, " ");
	if( lvfrmDate == "" ) //from date
		formObj.frm_plandate.value="";
	if( lvtoDate == "" ) //to date
		formObj.to_plandate.value="";
	if( lvtrunk_vvd == "" ) { //T.VVD
		formObj.trunk_vvd.value="";
	}
	if( lvbkg_no == "" ) { //BKG No
		formObj.bkg_no.value="";
	}
	if( lvbill_no == "" ) { //B/L No
		formObj.bill_no.value="";
	}
	if( lvcntr_no == "" ) { //CNTR No
		formObj.cntr_no.value="";
	}
	if( lvwo_no == "" ) { //W/O No
		formObj.wo_no.value="";
	}
	if( lvso_no == "" ) { //S/O No
		formObj.so_no.value="";
	}
	if( lvzip_code == "" ) { //Zip Code
		formObj.zip_code.value="";
	}
	if( lvfrmDate == "" && lvtoDate != "" ) {
		ComShowCodeMessage("TRS90119");
		return false;
	} else if( lvfrmDate != "" && lvtoDate == "" ) {
		ComShowCodeMessage("TRS90121");
		return false;
	} else if( lvfrmDate != "" && lvtoDate != "" ) {
		if( !doDatecheck(lvfrmDate) ) {
			ComShowCodeMessage("TRS90072");
			formObj.frm_plandate.focus();
			return false;
		} else if( !doDatecheck(lvtoDate) ) {
			ComShowCodeMessage("TRS90073");
			formObj.to_plandate.focus();
			return false;
		}
		if( ComGetDaysBetween(lvfrmDate, lvtoDate) > 30 ) {
			ComShowCodeMessage("TRS90424");
			return false;
		} else if( ComGetDaysBetween(lvfrmDate, lvtoDate) < 0 ) {
			ComShowCodeMessage("TRS90118");
			return false;
		}

	} else {
		if( lvtrunk_vvd == "" && lvbkg_no == "" && lvbill_no == "" && lvcntr_no == "" && lvwo_no == "" && lvso_no == "" ) {
			ComShowCodeMessage("TRS90124");
			return false;
		}
	}
	if(!TrsComValidFormat("SO", formObj.so_no.value, true)) { return false; }
	if(!TrsComValidFormat("WO", formObj.wo_no.value, true)) { return false; }
	if(ComGetObjValue(document.form.port_io) != "A" && document.form.port_cd.value == "") {
    	ComShowCodeMessage("TRS90410", "Port Code");
		return false;
	}
	
	if( lvfrm_node == "" ) { //From Node
		formObj.search_fm_loc.value="";
		search_fm_yard.RemoveAll(); // combo Deletion of data
	}
	if( lvvia_node == "" ) { //Via Node
		formObj.search_via_loc.value="";
		search_via_yard.RemoveAll(); // combo Deletion of data
	}
	if( lvto_node == "" ) { //To Node
		formObj.search_to_loc.value="";
		search_to_yard.RemoveAll(); // combo Deletion of data
	}
	if( lvdor_loc == "" ) { //Door Node
		formObj.search_door_loc.value="";
		search_door_yard.RemoveAll(); // combo Deletion of data
	}
	if( !doengnumcheck(lvtrunk_vvd) ) {
		formObj.trunk_vvd.value="";
		formObj.trunk_vvd.focus();
		return false;
	}
	if( !doengnumcheck(lvbkg_no) ) {
		formObj.bkg_no.value="";
		formObj.bkg_no.focus();
		return false;
	}
	if( !doengnumcheck(lvbill_no) ) {
		formObj.bill_no.value="";
		formObj.bill_no.focus();
		return false;
	}
	if( !doengnumcheck(lvcntr_no) ) {
		formObj.cntr_no.value="";
		formObj.cntr_no.focus();
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
	formObj.wo_no.value=lvwo_no.toUpperCase(); //W/O No
	formObj.so_no.value=lvso_no.toUpperCase(); //S/O No
	return true;
}
/* 
 * Sheet processing-related processes
 */
function doActionIBSheet(sheetObj,formObj,sAction,sObj) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      
			if( formObj.rad_wo_issued[1].checked == true ) {
				formObj.f_cmd.value=SEARCH10; // W/O Issue
			} else {
				formObj.f_cmd.value=SEARCHLIST; // W/O Not Issue
			}
			sheetObj.DoSearch("ESD_TRS_0051GS.do", TrsFrmQryString(formObj) );
		break;
		case IBSAVE: {
			if( sObj == "WO" ) {
				if( sheetObj.RowCount() < 1 ) {
					ComShowMessage(ComGetMsg("TRS90350"));
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
			} else {
				if( sheetObj.CheckedRows("chk1") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				}
				if(ComShowCodeConfirm("COM130101")) {
					if( sObj == "") {
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH13;
						formObj.cbstatus.value=sObj;
						var queryStr=sheetObj.GetSaveString(false, true, "chk1");
						sheetObjects[1].DoSearch("ESD_TRS_0051GS.do", queryStr+"&"+TrsFrmQryString(formObj),{Append:true, Sync:2} );
						ComOpenWait(false);
					} else if( sObj == "SP" ) {
						formObj.f_cmd.value=MODIFY01;
						formObj.cbstatus.value="SO";
						sheetObj.DoSave("ESD_TRS_0051GS.do", TrsFrmQryString(formObj), "chk1", false, true);
					} else if( sObj == "AA" ) {
						formObj.f_cmd.value=MODIFY02;
						sheetObj.DoSave("ESD_TRS_0051GS.do", TrsFrmQryString(formObj), "chk1", false, true);
					}
				}
			}
			break;
		}
		case IBDELETE:
			if( sheetObj.CheckedRows("chk1") < 1 ) {
				ComShowCodeMessage("TRS90036");
				return false;
			} else {
				if(!ComShowCodeConfirm("COM12165")) {
					return false;
				}
				formObj.f_cmd.value=REMOVE;
				sheetObj.DoSave("ESD_TRS_0051GS.do", {Param:TrsFrmQryString(formObj), Quest:false, Sync:2 });
				doActionIBSheet(sheetObj, formObj, IBSEARCH, "");
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
/*
 * W / O Issued or S / O Creation change No, Yes
 *
 */
function fun_wosoChange(obj) {
	sheetObjects[0].RemoveAll();
	if( obj == "YES" ) {
		document.form.rad_dateSep[3].disabled=false;
		document.form.wo_no.disabled=false;
		document.form.btns_multiwono.disabled=false;
		document.all["id_woissue"].style.display = "none";
		document.all["id_woissueno"].style.display = "inline";		

	} else {
		document.form.rad_dateSep[3].disabled=true;
		document.form.wo_no.disabled=true;
		document.form.wo_no.value="";
		document.form.btns_multiwono.disabled=true;
		if( document.form.rad_dateSep[3].checked == true ) {
			document.form.rad_dateSep[0].checked=true;
		}
		document.all["id_woissue"].style.display = "inline";
		document.all["id_woissueno"].style.display = "none";
	}
}
/*
 * If DOOR Arrival Time Cost Mode is only if the Door is viewed.
 */
function fun_datesep(obj) {
	if( obj == "D" ) {
		for( var v=0; v < document.form.sel_costmode.length; v++ ) {
			if( document.form.sel_costmode.options[v].value == "DR" ) {
				document.form.sel_costmode.options[v].selected=true;
				document.form.sel_costmode.disabled=true;
			}
		}
	} else {
		document.form.sel_costmode.options[0].selected=true;
		document.form.sel_costmode.disabled=false;
	}
}
/*
 * Separate from the existing Single Unmap combined data.
 *
 */
function doSeparateRemove(sheetObj) {
	var fromRow = 0;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		fromRow=arrRow[i];
		if( sheetObj.GetCellValue(fromRow, "trsp_so_cmb_seq").length > 0 ) {
			sheetObj.SetCellValue(fromRow, "trsp_so_cmb_seq","",0);
			sheetObj.SetCellEditable(fromRow, "trsp_crr_mod_cd",1);
			sheetObj.SetCellEditable(fromRow, "fm_nod_cd",1);
			sheetObj.SetCellEditable(fromRow, "fm_nod_yard",1);
			sheetObj.SetCellEditable(fromRow, "via_nod_cd",1);
			sheetObj.SetCellEditable(fromRow, "via_nod_yard",1);
			sheetObj.SetCellEditable(fromRow, "to_nod_cd",1);
			sheetObj.SetCellEditable(fromRow, "to_nod_yard",1);
			sheetObj.SetCellEditable(fromRow, "dor_nod_cd",1);
			sheetObj.SetCellEditable(fromRow, "dor_nod_yard",1);
			sheetObj.SetCellEditable(fromRow, "act_cust_cd",1);
			sheetObj.SetCellEditable(fromRow, "mlt_stop_de_flg",1);
			sheetObj.SetCellEditable(fromRow, "n1st_nod_pln_dt",1);
			sheetObj.SetCellEditable(fromRow, "n1st_nod_pln_dt_hms",1);
			sheetObj.SetCellEditable(fromRow, "lst_nod_pln_dt",1);
			sheetObj.SetCellEditable(fromRow, "lst_nod_pln_dt_hms",1);
			sheetObj.SetCellEditable(fromRow, "dor_nod_pln_dt",1);
			sheetObj.SetCellEditable(fromRow, "dor_nod_pln_dt_hms",1);
			sheetObj.SetCellEditable(fromRow, "spcl_cgo_cntr_tp_cd",1);
			sheetObj.SetCellEditable(fromRow, "dor_svc_tp_cd",1);
			sheetObj.SetCellEditable(fromRow, "inter_rmk",1);
			sheetObj.SetCellEditable(fromRow, "spcl_instr_rmk",1);
			if( sheetObj.GetCellEditable(fromRow, "trsp_cost_dtl_mod_cd") == "DOOR" ) {
				sheetObj.SetCellEditable(fromRow, "dor_de_addr", 1);
				sheetObj.SetCellEditable(fromRow, "dor_pst_cd", 1);
				sheetObj.SetCellEditable(fromRow, "fctry_nm", 1);
				sheetObj.SetCellEditable(fromRow, "cntc_pson_phn_no", 1);
				sheetObj.SetCellEditable(fromRow, "cntc_pson_fax_no", 1);
				sheetObj.SetCellEditable(fromRow, "cntc_pson_nm", 1);
			}
		} 
	}
}
/*
 * Check logic for CB Seq
 */
function validationCheck(sheetObj) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "trsp_so_cmb_seq").length > 0 ) {
			ComShowMessage(ComGetMsg("TRS90062"));
			return false;
		}
	}
	return true;
}
/*
 * tab1 sheet of information about
 */
function t1sheet1_OnClick(sheetObj, row , col , value) {
	var ColSaveName = sheetObj.ColSaveName(col);
	if( document.form.rad_wo_issued[0].checked) {
		if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
			if( ColSaveName == "trsp_rqst_bkg_flg" ) {
				ComShowMessage(ComGetMsg("TRS90062"));
			}
			return false;
		}
		if( ColSaveName == "fm_nod_yard" ) {
			value=doSepRemove(sheetObj.GetCellValue(row, "fm_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value="";
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.SetCellValue(row, "fm_nod_cd","",0);
			}
		} else if( ColSaveName == "to_nod_yard" ) {
			value=doSepRemove(sheetObj.GetCellValue(row, "to_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value="A";
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.SetCellValue(row, "to_nod_cd","",0);
			}
		} else if (ColSaveName == "via_nod_yard" ) {
			value=doSepRemove(sheetObj.GetCellValue(row, "via_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value="";
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.SetCellValue(row, "via_nod_cd","",0);
			}
		} else if( ColSaveName == "dor_nod_yard" ) {
			value=doSepRemove(sheetObj.GetCellValue(row, "dor_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value="";
			if( value.length > 0 ) {
				getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.SetCellValue(row, "dor_nod_cd","",0);
			}
		} 		
	}
}
var doc_row=0; //container check..
function t1sheet1_OnChange(sheetObj, row, col, value) {
	var ColSaveName = sheetObj.ColSaveName(col);
	if( document.form.rad_wo_issued[1].checked == true ) {
		if( sheetObj.ColSaveName(col) == "chk1" ) {
			if( value == "1" ) {
				sheetObj.SetRowStatus(row,"U");
				if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
					for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
						if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq") == sheetObj.GetCellValue(i, "trsp_so_cmb_seq") ) {
							sheetObj.SetRowStatus(i,"U");
							sheetObj.SetCellValue(i, "chk1","1",0);
						}
					}
				}
			} else {
				sheetObj.SetRowStatus(row,"R");
				if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
					for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
						if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq") == sheetObj.GetCellValue(i, "trsp_so_cmb_seq") ) {
							sheetObj.SetRowStatus(i,"R");
							sheetObj.SetCellValue(i, "chk1","0",0);
						}
					}
				}
			}		
		} else if( sheetObj.ColSaveName(col) == "eq_no" ) {
			var doc_eq_no=sheetObj.GetCellValue(row, "eq_no");
			if( doengnumcheck(doc_eq_no) ) {
				sheetObj.SetCellValue(row, "eq_no",cntrCheckDigit(doc_eq_no).toUpperCase(),0);
			} else {
				sheetObj.SetCellValue(row, "eq_no","",0);
			}
		}
	/* Work Order Not Issued */
	} else {
		if( ColSaveName == "chk1" ) {
			if( value == "1" ) {
				sheetObj.SetRowStatus(row,"U");
				if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
					for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
						if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq") == sheetObj.GetCellValue(i, "trsp_so_cmb_seq") ) {
							sheetObj.SetRowStatus(i,"U");
							sheetObj.SetCellValue(i, "chk1","1",0);
						}
					}
				}
			} else {
				sheetObj.SetRowStatus(row,"R");
				if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
					for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
						if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq") == sheetObj.GetCellValue(i, "trsp_so_cmb_seq") ) {
							sheetObj.SetRowStatus(i,"R");
							sheetObj.SetCellValue(i, "chk1","0",0);
						}
					}
				}
			}
		} else if( ColSaveName == "fm_nod_cd" ) {
			var lvfm=doSepRemove(value.toUpperCase(), " ");
			sheetObj.SetCellValue(row, "fm_nod_cd",lvfm,0);
			if( doengnumcheck(lvfm) ) {
				if( lvfm.length == 5 ) {
					document.form.TRSP_SO_EQ_KIND.value="";
					getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
					if( sheetObj.GetCellValue(row, "fm_nod_cd") != "" ) {
						getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
					} else {
						sheetObj.CellComboItem(row,"fm_nod_yard",  {ComboText:"", ComboCode:""});
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
		} else if( ColSaveName == "via_nod_cd" ) {
			var lvvia=doSepRemove(value.toUpperCase(), " ");
			sheetObj.SetCellValue(row, "via_nod_cd",lvvia,0);
			if( doengnumcheck(lvvia) ) {
				if( lvvia.length == 5 ) {
					document.form.TRSP_SO_EQ_KIND.value="";
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
						ComShowMessage(ComGetMsg("TRS90122"));
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
		} else if( ColSaveName == "to_nod_cd" ) {
			var lvto=doSepRemove(value.toUpperCase(), " ");
			sheetObj.SetCellValue(row, "to_nod_cd",lvto,0);
			if( doengnumcheck(lvto) ) {
				if( lvto.length == 5 ) {
					document.form.TRSP_SO_EQ_KIND.value="A";
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
						ComShowMessage(ComGetMsg("TRS90122"));
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
		} else if( ColSaveName == "dor_nod_cd" ) {
			var lvdor=doSepRemove(value.toUpperCase(), " ");
			sheetObj.SetCellValue(row, "dor_nod_cd", lvdor,0);
			if( doengnumcheck(lvdor) ) {
				if( lvdor.length == 5 ) {
					document.form.TRSP_SO_EQ_KIND.value="";
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
        }  else if( ColSaveName == "dor_nod_yard" ) {
        	GetZoneName(sheetObj, row, "dor_nod_cd", "dor_nod_cd_nm", value);
        } else if( ColSaveName == "trsp_crr_mod_cd" ) {
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
		} else if( ColSaveName == "trsp_rqst_bkg_flg" ) {
			if( sheetObj.GetCellValue(row,"trsp_rqst_bkg_flg") == "Y" ) {
				if( confirm(ComGetMsg("TRS90342")) ) {
				} else {
					sheetObj.SetCellValue(row,"trsp_rqst_bkg_flg","",0);
				}
			}
		} else if( ColSaveName  == "eq_no" ) {
			var doc_eq_no=sheetObj.GetCellValue(row, "eq_no");
			if( doengnumcheck(doc_eq_no) ) {
				sheetObj.SetCellValue(row, "eq_no",cntrCheckDigit(doc_eq_no).toUpperCase(),0);
			} else {
				sheetObj.SetCellValue(row, "eq_no","",0);
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

// Brings the value of Office.
function containerVerify() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml=request.responseXML;
			var rowXml=docXml.getElementsByTagName("row-count")[0];
			if( rowXml.firstChild.nodeValue == 1 ) {
				sheetObjects[0].SetCellValue(doc_row, "eq_no",docXml.getElementsByTagName("cntr-no")[0].firstChild.nodeValue,0);
			} else {
				sheetObjects[0].SetCellValue(doc_row, "eq_no","",0);
				ComShowMessage("No Data!");
			}
		}
	}
}
// Addition to date.
function getDateBetween(obj) {
	if(document.form.frm_plandate.value != "" && document.form.frm_plandate.value.split("-").join("").length == 8) {
	    document.form.to_plandate.value=ComGetDateAdd(obj.value,"D", 30, "-");
	}
}

function t2sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk=sheetObj.GetCellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.SetRowStatus(row,"U");
			for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
				var lvchk2=sheetObj.GetCellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.SetRowStatus(i,"U");
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
			sheetObj.SetRowStatus(row,"U");
			for( var i=2; i<(sheetObj.RowCount()+2); i++ ) {
				var lvchk2=sheetObj.GetCellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.SetRowStatus(i,"U");
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
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	//Confirm the number of data rows
	var fromRow=0;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) { //If you pass in Case One
		fromRow=arrRow[i];
		var lvCrrmodcd=sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd");
		var trsp_dtl_mod=sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_sep");
		var lv_frm_node=doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_cd"), " ");
		var lv_to_node=doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_cd"), " ");
		var lv_via_node=doSepRemove(sheetObj.GetCellValue(fromRow, "via_nod_cd"), " ");
		var lvfmnod=lv_frm_node+doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_yard"), " ");
		var lvvinod=lv_via_node+doSepRemove(sheetObj.GetCellValue(fromRow, "via_nod_yard"), " ");
		var lvtonod=lv_to_node+doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_yard"), " ");
		var lvdrnod=doSepRemove(sheetObj.GetCellValue(fromRow, "dor_nod_cd"), " ")+doSepRemove(sheetObj.GetCellValue(fromRow, "dor_nod_yard"), " ");
		var lvoutints=sheetObj.GetCellValue(fromRow, "trsp_bnd_cd"); //IN, OUT, T/S
		var lvcostmod=sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd"); //CY, DOOR
		var lvcgo_tp_cd=sheetObj.GetCellValue(fromRow, "cgo_tp_cd"); //CGO_TP_CD
		//지연대리 요청 20070510 다시 추가
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
		//지연대리 요청 20070510
		if( (lv_frm_node.substring(0, 2) == "US") || (lv_to_node.substring(0, 2) == "CA") ) {
			if( lvCrrmodcd.indexOf("R") > -1 ) {
				ComShowCodeMessage("TRS90223");
				return false;
			}
		}
		//김종욱수석 요청 20070511
		if( lvcostmod == "CY" ) {
			if( trsp_dtl_mod == "TS" || trsp_dtl_mod == "LS" ) {
				if( lv_frm_node != lv_to_node ) {
					ComShowCodeMessage("TRS90210");
					return false;
				}
				if( lvfmnod == lvtonod) { 
					ComShowCodeMessage("TRS90134");
					return false;
				}
			}
		}
		if( lvoutints == "O" || lvoutints == "I" ) {
			if( lvcostmod == "CY" ) {
				if( lvfmnod == "" || lvtonod == "" ) {
					ComShowCodeMessage("TRS90104");
					return false;
				} else if( lvdrnod != "" ) {
					ComShowCodeMessage("TRS90085");
					return false;
				} else {
					if( lvfmnod == lvtonod) {
						ComShowCodeMessage("TRS90134");
						return false;
					}
				}
			} else if( lvcostmod == "DOOR" ) {
				if( lvfmnod == "" || lvtonod == "" || lvdrnod == "" ) {
					ComShowCodeMessage("TRS90104");
					return false;
				}
				//else { 
				//	if( lvfmnod == lvtonod ) {
				//		return false;
				//	}
				//}
			} else {
				return false;
			}
		} else if( lvoutints == "T" || lvoutints == "" ) {
			if( lvcostmod == "CY" ) {
				if( lvfmnod == "" || lvtonod == "" ) {
					ComShowCodeMessage("TRS90104");
					return false;
				} else if( lvdrnod != "" ) {
					ComShowCodeMessage("TRS90085");
					return false;
				} else {
					if( lvfmnod == lvtonod) {
						ComShowCodeMessage("TRS90134");
						return false;
					}
				}
			} else {
				ComShowCodeMessage("TRS90049");
				return false;
			}
		} else {
			if( lvcgo_tp_cd == "M" ) {
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
				return false;
			}
		}
	}
	return true;
}
/*
 * Work according to the Validation Check / Combined CNTR Trans. Check the relationship between Case One and Single Transportation
 */
function doDataEquals(sheetObj) { //In order to compare the data added.
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
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
 * Multiple Apply check for
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
	var chkTM=true;
	var chkFN=true;
	var chkVN=true;
	var chkTN=true;
	var chkDR=true;
	var j=0;
	if( sheetObj.CheckedRows("chk1") < 1 ) {
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
			j++;
		}
	}
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
			ComShowMessage(ComGetMsg("TRS90127"));
			return false;
			break;
		}
	}
	HPut("CM", lvCostMode); //Cost Mode
	if( chkTM ) {
		HPut("TM", lvTransMode)
	} else  {
		HPut("TM", "NULL");
	}
	if( chkFN )  {
		HPut("FN", lvFrmNode);
	} else {
		HPut("FN", "NULL");
	}
	if( chkVN ) {
		HPut("VN", lvViaNode);
	} else {
		HPut("VN", "NULL");
	}
	if( chkTN ) {
		HPut("TN", lvToNode);
	} else {
		HPut("TN", "NULL");
	}
	if( chkDR ) {
		HPut("DR", lvDoor);
	} else {
		HPut("DR", "NULL");
	}
	return true;
}

/*
 * From Node1 / 2, the date, time, Via Node1 / 2, To Node1 / 2, the date, time, Door Loc1 / 2, the date, time
 */
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

var lvRow=0;
function t1sheet1_OnPopupClick(sheetObj, row, col) {
	var ColSaveName = sheetObj.ColSaveName(col);
	if( ColSaveName == "act_cust_cd" && sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd') != 'CY') {
		lvRow=row;
		var lvdor_node=sheetObj.GetCellValue(row, "dor_nod_cd");
		var lvac_cust_cd=sheetObj.GetCellValue(row, "act_cust_cd");
		var lv_fctry_nm=sheetObj.GetCellValue(row, "fctry_nm");
    	var url='ESD_TRS_0914.screen?act_loc='+lvdor_node+"&act_cust_cd="+lvac_cust_cd+"&row="+row+"&fctry_nm="+lv_fctry_nm;   	
		 ComOpenPopup(url, 800, 570, 'window', '0,0', true);
	} else if( ColSaveName == "mlt_stop_de_flg" ) {
		lvRow=row;
		if( sheetObj.GetCellValue(row, "mlt_stop_de_flg") == "Y" ) {
			var myOption="dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
			var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
			var lvbl=sheetObj.GetCellValue(row, "bl_no");
			var lveq=sheetObj.GetCellValue(row, "eq_no");
			var lvts=sheetObj.GetCellValue(row, "eq_tpsz_cd");
			var lvtro=sheetObj.GetCellValue(row, "tro_seq");
			var url="ESD_TRS_0933.do?bkgnumber="+lvbkg+"&blnumber="+lvbl+"&cntrnumber="+lveq+"&tpsznumber="+lvts+"&troseqnumber="+lvtro;
			ComOpenPopup(url, 800, 407, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		}
	} else if( ColSaveName == "spcl_cgo_cntr_tp_cd" ) {
		var myOption="dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var lvtro_seq=sheetObj.GetCellValue(row, "tro_seq");
		var lvui_conti_cd=sheetObj.GetCellValue(row, "conti_cd");
		if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'DG' ) {
			var url="ESD_TRS_0938Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			 ComOpenPopup(url, 800, 407, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		} else if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'BB' ) {
			var url="ESD_TRS_0937Pop.do?bkg_no="+lvbkg;
			ComOpenPopup(url, 800, 437, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		} else if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'AK' ) {
			var url="ESD_TRS_0936Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			ComOpenPopup(url, 800, 415, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		} else if( sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd") == 'RF' ) {
			var url="ESD_TRS_0935Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			ComOpenPopup(url, 800, 445, 'window', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		}
	} else if (ColSaveName == "inter_rmk" ) { // 2015.05.06 CHAN WOO PARK
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var lvsono=sheetObj.GetCellValue(row, "trsp_so_ofc_seq");
		var lvwono=sheetObj.GetCellValue(row, "trsp_wo_ofc_seq");
		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&wo_no=" + lvwono + "&inter_rmk_cd=T";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}

/**
 * 
 * @param winObj
 * @param selected_row
 * @param act_cust_cd
 * @param act_cust_cnt_cd
 * @param act_cust_seq
 * @param act_cust_addr_seq
 * @param act_cust_nm
 * @param factory_nm
 * @param factory_zip_code
 * @param factory_addr
 * @param factory_tel_no
 * @param factory_fax_no
 * @param pic_nm
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
}

/**
 * Get a list of external combo box (ESD_TRS_0003.js also exists).
 * @param obj
 * @param comObj
 * @param sep
 * @returns {Boolean}
 */
function getComboList(obj, comObj, sep) { //object, taking the value portion, 'Node kind
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
	obj.value=lvobj;
	if( obj.value == "" || obj.length < 5) {
		comObj.RemoveAll();
		return false;
	} 
	if( !doengnumcheck(lvobj) ) {
		obj.value="";
		comObj.RemoveAll();
		obj.focus();
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
		v6="zone"
	} else {
		v6="yard";
	}
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
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
	myWin.focus();
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
	search_fm_yard.SetSelectCode(lvYard, true);
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
	search_via_yard.SetSelectCode(lvYard, true);
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
	search_to_yard.SetSelectCode(lvYard, true);
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
	search_door_yard.SetSelectCode(lvYard, true);
}
/**
 * Common Trunk VVD popup
 */
 function openTVVDPopup() {
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
	var classId="getCOM_ENS_VVD_1";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 780, 490, classId, '1,0,1,1,1,1,1,1');
}
function getCOM_ENS_VVD_1(rowArray) {
	var formObject=document.form;
	var gubun="";
	var colArray=rowArray[0];
	formObject.trunk_vvd.value=colArray[7] + gubun;
}
/**
 * When the error occurs on the result of a lookup function to handle common
 */
function t1sheet1_OnSearchEnd(sheetObj,errMsg){
	var formObj=document.form;
	formObj.rad_wo_issued[0].disabled=false;
	formObj.rad_wo_issued[1].disabled=false;
}

/**
 * When an error occurs, save the results to a common processing function
 */
function t1sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if(errCode >= 0 ) {
		if( document.form.f_cmd.value == REMOVE ) {
			ComShowCodeMessage("TRS90109");
			IBS_Sheet2SheetStatus3_3(sheetObj, "chk1");
		} else if( document.form.f_cmd.value == MODIFY01 ){
			ComShowCodeMessage("TRS90105");
			doSeparateRemove(sheetObj);
		} else if( document.form.f_cmd.value == MODIFY02 ) {
			ComShowCodeMessage("TRS90105");
		} else if( document.form.f_cmd.value == MULTI01 ) {
		} else {
			ComShowCodeMessage("TRS90105");
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
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 415, "getTRS_ENS_906", '0,1',true);
}
/**
 * Location: In the single-selection pop-up hangyeongwoo.
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
		formObject.cntr_no.value=reObj;
	} else if( obj == "SON" ) {
		formObject.so_no.value=reObj;
	} else if( obj == "WON" ) {
		formObject.wo_no.value=reObj;
	} else if( obj == "ZIP" ) {
		formObject.zip_code.value=reObj;
	} else if( obj == "FM_NODE" ) {
		formObject.search_fm_node.value=reObj;
		resetLocYard("FROM");
	} else if( obj == "TO_NODE" ) {
		formObject.search_to_node.value=reObj;
		resetLocYard("TO");
	} else if( obj == "SLOT_NO" ) {
		formObject.cntr_slt_no.value=reObj;
	} else {
		ComShowMessage(ComGetMsg("TRS90132"));
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
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 800, 520, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity pop-up Call: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];
		formObj.combo_svc_provider.value=colArray2;
		formObj.svc_provider.value=colArray4;
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
/**
 * Modify the results when the error occurred processing functions common
 */
function sheet2_OnSearchEnd(sheetObj, errCode, errMsg) {
	 var formObject=document.form;
	 if( errCode >= 0 ) {
		 if(formObject.f_cmd.value == SEARCH13){
			 ComShowMessage(ComGetMsg("TRS90105"));
		 } 
	}
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

/**
 * On Off Hire Verify 
 * @returns {Boolean}
 */
function offHireVerify(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.f_cmd.value=SEARCH07;
	var eqno="";
	if(sheetObj.RowCount()< 1){
		ComShowCodeMessage('TRS90386', 'First, Please inquiry');
		return false;
	}
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	for( var i=1; i<sheetObj.RowCount()+2; i++ ) {
		if( sheetObj.GetCellValue(i, "chk1") == "1" ) {
			eqno=eqno + "&sel_cntr_no=" + sheetObj.GetCellValue(i, "eq_no");
        }
    }
	eqno=eqno.substring(1, eqno.length);
	sheetObjects[3].DoSearch("ESD_TRS_0002GS.do", eqno+'&'+TrsFrmQryString(formObj),{Append:false} );
}

/**
 * 
 * @param sheetObj
 * @param errMsg
 */
function rtnsheet_OnSearchEnd(sheetObj, errMsg) {
	var main_sheet=sheetObjects[0];
	var cnt=0;
	for(i=1;i<main_sheet.RowCount()+2;i++) {
		if( main_sheet.GetCellValue(i, "chk1") == "1" ) {
			for(j=1;j<sheetObj.RowCount()+1;j++) {
				if (main_sheet.GetCellValue(i, "eq_no") == sheetObj.GetCellValue(j, "cntr_no")) {
					main_sheet.SetCellValue(i, "to_nod_cd",sheetObj.GetCellValue(j, "offh_yd_cd").substring(0,5),0);
					main_sheet.SetCellText(i, "to_nod_yard" ,sheetObj.GetCellValue(j, "offh_yd_cd").substring(5,7));
					main_sheet.SetCellValue(i, "lse_cntr_flg","Y",0);
					main_sheet.SetRangeFontColor(i,16,i,17,"#FF0000");
					cnt++;
				}
			}
		}
	}
	ComShowMessage("Off Hire Verify Success ("+ cnt +" case)");
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
		case "to_nod_yard" : {
			setYdNameToolTip(sheetObj, mouseRow, mouseCol, "o_" + colSaveName, formObj, "");
			break;
		}
		case "fm_nod_cd" : 
		case "via_nod_cd" : 
		case "to_nod_cd" : {
			setLocationNameToolTip(sheetObj, mouseRow, mouseCol, "o_" + colSaveName, formObj, "");
			break;
		}
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
function setYdNameToolTip(sheetObj, Row, Col, OrgNodYard, formObj, ColSaveName) {
	var nodValue = sheetObj.GetCellValue(Row, Col - 1);
	var ydValue = sheetObj.GetCellValue(Row, Col);
	var CurNodYard;
	if(!ComIsNull(ydValue)) {
		CurNodYard = nodValue + ydValue;
		if(CurNodYard != sheetObj.GetCellValue(Row, OrgNodYard )) {
			var yardName = GetYardName(sheetObj, formObj, CurNodYard, "Y");
			sheetObj.SetToolTipText(Row, Col, yardName);
			sheetObj.SetCellValue(Row, OrgNodYard, CurNodYard, 0);
			if(ColSaveName != "") {
				sheetObj.SetCellValue(Row, ColSaveName, yardName, 0);
			}
			
		}
	} else {
		sheetObj.SetToolTipText(Row, Col, "");
		sheetObj.SetCellValue(Row, OrgNodYard, "", 0);
		if(ColSaveName != "") {
			sheetObj.SetCellValue(Row, ColSaveName, "", 0);
		}
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
function setLocationNameToolTip(sheetObj, Row, Col, OrgNod, formObj, ColSaveName) {
	var nodValue = sheetObj.GetCellValue(Row, Col);
	if(!ComIsNull(nodValue)) {
		if(nodValue != sheetObj.GetCellValue(Row, OrgNod )) {
			var yardName = GetYardName(sheetObj, formObj, nodValue, "N");
			sheetObj.SetToolTipText(Row, Col, yardName);
			sheetObj.SetCellValue(Row, OrgNod, nodValue, 0);
			sheetObj.SetCellValue(Row, ColSaveName, yardName, 0);
		}
	} else {
		sheetObj.SetToolTipText(Row, Col, "");
		sheetObj.SetCellValue(Row, OrgNod, "", 0);
		sheetObj.SetCellValue(Row, ColSaveName, "", 0);
	}
}