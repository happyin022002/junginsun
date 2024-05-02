/*=========================================================
 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0026.js
 *@FileTitle  : Surcharge for USA/CA Rail
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/06/30
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0026 : Morecandidate
 */
// General global variable
var sheetObjects = new Array();
var sheetCnt = 0;

var prefix = 'surcharge_';
document.onclick = processButtonClick;

function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_apply": {
				applyMoreCandidates(sheetObject);
//				if (applyMoreCandidates(sheetObject)) {
//					//ComClosePopup();
//				}
				break;
			}
			case "btn_close":
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

/**
 * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 */
function initControl() {
}

function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
         case 1: 
             with(sheetObj) {
             var HeadTitle1="|Status|Rail Company|Rail Company|AGMT No.|Surcharge|Surcharge|Common|Auto\nApply|Rail ORG.|Rail DEST.|Fixed\nRatio Div|Fixed\nRatio Div" + 
                            "|Ratio|Rate|Rate|Rate|Rate|Applied\nAmount|Cargo\nNature|EQ\nType/Size|Weight|UOM|Effective Date|Effective Date|Effective Date|UDU|SeqNo|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ|Basic\nAmount|Rail Ratio No";
             var HeadTitle2="|Status|Rail Company|Rail Company|AGMT No.|Surcharge|Surcharge|Common|Auto\nApply|Rail ORG.|Rail DEST.|Fixed\nRatio Div|Fixed\nRatio Div" + 
                            "|Ratio|Currency|Amount|One Way\n(CY rate)|Round Trip\n(DR rate)|Applied\nAmount|Cargo\nNature|EQ\nType/Size|Weight|UOM|From|To|Status|UDU|SeqNo|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ|Basic\nAmount|Rail Ratio No";
             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 4, ComboMaxHeight:200 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                             { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [
                 {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"ibchk" },
                 {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },                                            
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Left",   ColMerge:1, SaveName:"vndr_seq",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:0, Width:70,  Align:"Left",   ColMerge:1, SaveName:"vndr_nm",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Left",   ColMerge:1, SaveName:"agmt_no",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_rail_scg_cd_",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"trsp_rail_scg_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:50 },                                              
                 {Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                 {Type:"CheckBox", Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0}, 
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_cd_",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_cd",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Float",    Hidden:0, Width:50,  Align:"Right",  ColMerge:1, SaveName:"trsp_rail_rto",          KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rt",                KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },                                             
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },                                             
                 {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"appl_rt",                KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:0, EditLen:15 },                                             
                 
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd",    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:4 },
                 
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_eq_sz_no",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:4 },
                 {Type:"Text",     Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"lbs_ovr_wgt",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:9 },
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:3 },
                 {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                 {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Left",   ColMerge:1, SaveName:"rate_sts",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:20 },
                 {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:500 },
                 {Type:"Seq",      Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:8 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:3 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:4 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_nod_seq",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_rt_seq",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Left",   ColMerge:1, SaveName:"trsp_agmt_scg_seq",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"appl_rt_hidden",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:0, EditLen:15 },
                 {Type:"Text",     Hidden:1, Width:70,  Align:"Left",   ColMerge:1, SaveName:"trsp_so_ofc_cty_cd",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Text",     Hidden:1, Width:70,  Align:"Left",   ColMerge:1, SaveName:"trsp_so_seq",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Text",     Hidden:1, Width:70,  Align:"Left",   ColMerge:1, SaveName:"sub_rail_seq",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_knd_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"com_scg_seq",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},                                             
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"bzc_amt",                KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:0, EditLen:15 },                                             
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"rail_rto_no",            KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:0, UpdateEdit:1, InsertEdit:0, EditLen:15 }
             ];
             InitColumns(cols);
             SetEditable(1);
             SetSheetHeight(360);
             SetRowHeight(30);
             SetCountPosition(0);
         }
         break;
    }
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0026GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:
            formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0026GS.do", TrsFrmQryString(formObj),"ibflag", false, false);
			break;
	}
}

function sheet0_OnSearchEnd(sheetObj, code, errMsg) {
	if(code != 0) {
		return;
	}
    
	for ( var b = 2; b < sheetObj.RowCount()+2; b++) {
		if ( sheetObj.GetCellValue(b, 'ibchk') != '1') {
			sheetObj.SetCellEditable(b, 'appl_rt', 0);
		}
		if(sheetObj.GetCellValue(b, 'rate_sts') != '') {
			sheetObj.SetRowFontColor(b, "255, 0, 0");
		}
	}
}

/**
 * Defining OnChange Event of sheet
 */
function sheet0_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    var formObj = document.form;
    var std = 1;
    switch(colName) {
        case 'ibchk':
    	    var isChecked = sheetObj.GetCellValue(row, 'ibchk');
    	    
        	if(isChecked) {                                                         // WHEN isChecked IS TRUE
        		// UNCHECK all of the same surcharge
//            	for ( var b = 2; b < sheetObj.RowCount()+2; b++) {
//            		if (b != row && sheetObj.GetCellValue(b, 'trsp_rail_scg_cd') == sheetObj.GetCellValue(row, 'trsp_rail_scg_cd')) {
//            			sheetObj.SetCellValue(b, 'ibchk', 0, 1);
//            		}
//            	}
            	
        		if(sheetObj.GetCellValue(row, "appl_rt_hidden")=="") {                  // WHEN appl_rt_hidden IS NULL
        			sheetObj.SetCellEditable(row, 'appl_rt', 1);
        			
        			if(sheetObj.GetCellValue(row, "agmt_scg_rt_div_cd")=="Ratio") {         // WHEN Ratio
        				var newVal = chkAmtPos(sheetObj.GetCellValue(row, 'trsp_rail_rto') * sheetObj.GetCellValue(row, 'bzc_amt') / 100, sheetObj.GetCellValue(row, 'rail_rto_no'));
            			sheetObj.SetCellValue(row, 'appl_rt', newVal, 0);
        			} else {                                                                // WHEN Fixed
            			sheetObj.SetCellValue(row, 'appl_rt', sheetObj.GetCellValue(row, 'trsp_rt'), 0);
        			}
        		} else {                                                                // WHEN appl_rt_hidden IS NOT NULL
        			sheetObj.SetCellEditable(row, 'appl_rt', 1);
        			sheetObj.SetCellValue(row, 'appl_rt', sheetObj.GetCellValue(row, 'appl_rt_hidden'), 0);
        		}
        	} else {                                                                // WHEN isChecked IS FALSE
    			sheetObj.SetCellValue(row, 'appl_rt', '', 0);
    			sheetObj.SetCellEditable(row, 'appl_rt', 0);
        	}
        break;
    }
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet0_OnSaveEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    } else {
    	var opener_obj = window.dialogArguments;
    	if (!opener_obj)
    		opener_obj = parent;
    	if (!opener_obj)
    		opener_obj = opener;
    	var opnSheet = opener_obj.sheetObjects[0];
    	//opener_obj.doActionIBSheet(opener_sheet, opener_obj.document.form, IBSEARCH, "01");
    	var fsgSum = 0.00;
    	var hzsSum = 0.00;
    	var owsSum = 0.00;
    	var ttlSum = 0.00;
        
    	for ( var b = 2; b < sheetObj.RowCount()+2; b++) {
    		if ( sheetObj.GetCellValue(b, 'trsp_rail_scg_cd') == 'FSG') {
    			fsgSum += parseFloat(ComNullToZero(sheetObj.GetCellValue(b, 'appl_rt')));
    		} else if ( sheetObj.GetCellValue(b, 'trsp_rail_scg_cd') == 'OWS') {
    			owsSum += parseFloat(ComNullToZero(sheetObj.GetCellValue(b, 'appl_rt')));
    		} else if ( sheetObj.GetCellValue(b, 'trsp_rail_scg_cd') == 'HZS') {
    			hzsSum += parseFloat(ComNullToZero(sheetObj.GetCellValue(b, 'appl_rt')));
    		} else if ( sheetObj.GetCellValue(b, 'trsp_rail_scg_cd') == 'TTL') {
    			ttlSum += parseFloat(ComNullToZero(sheetObj.GetCellValue(b, 'appl_rt')));
    		}
    	}
    	var opnSheetRow = opnSheet.GetSelectRow();
    	opnSheet.SetCellValue(opnSheetRow, "fuel_scg_amt", fsgSum, 0);
    	opnSheet.SetCellValue(opnSheetRow, "ovr_wgt_scg_amt", owsSum, 0);
    	opnSheet.SetCellValue(opnSheetRow, "hzd_mtrl_scg_amt", hzsSum, 0);
    	opnSheet.SetCellValue(opnSheetRow, "etc_add_amt", ttlSum, 0);
    	opnSheet.SetCellValue(opnSheetRow, "scg_amt", fsgSum + hzsSum + owsSum + ttlSum, 0);
    	opnSheet.SetCellValue(opnSheetRow, "tot_amt", fsgSum + hzsSum + owsSum + ttlSum + parseFloat(opnSheet.GetCellValue(opnSheetRow, "bzc_amt")), 0);
    	
    	ComClosePopup();
    }
}

function applyMoreCandidates(sheetObj) {
//	var checkedRows = sheetObj.FindCheckedRow("ibchk");
//	if(checkedRows == "") {
//		ComShowCodeMessage('TRS90382');
//		return false;
//	}

	// UNCHECK all of the same surcharge
//	var temp = "";
//	for ( var b = 2; b < sheetObj.RowCount()+2; b++) {
//		if (sheetObj.GetCellValue(b, 'ibchk') == "1") {
//			var val = sheetObj.GetCellValue(b, 'vndr_seq') + "|" + sheetObj.GetCellValue(b, 'trsp_rail_scg_cd');
//			if(temp.indexOf(val) > -1) {
//				ComShowCodeMessage('TRS90459');
//				return false;
//			}else{
//				temp = temp + "," + val;
//			}
//		}
//	}
	doActionIBSheet(sheetObj, document.form, IBSAVE);
	
	return true;
}

/*
 * format number
 * ex) formatDecimal(37, 3) => 37.000, formatDecimal(37.9, 2) => 37.90
 */
function formatDecimal(val, p){
    var s = val.toString();
    if (s.indexOf('.') == -1) s += '.';
    while (s.length <= s.indexOf('.') + p) s += '0';
    return s;
}
