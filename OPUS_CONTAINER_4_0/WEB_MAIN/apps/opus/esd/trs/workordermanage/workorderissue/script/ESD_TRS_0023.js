/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0023.js
*@FileTitle  : W/O Issue 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var wo_radio_check = '0';
var prefix = 'surcharge_';
var processFlag = false;
var popVar = null;
var previewPopObject = new Array();

document.onclick = processButtonClick;

function processButtonClick() {
    /***** Adding additional sheet variables to use more than one sheet per a tab *****/
    var sheetObject  = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case 'btn_reset': {
                if(processFlag) {
                	return;
                }
                formObject.reset();
                resetSearchCondition(formObject);
                break;
            }
            case "btn_retrieve": {
            	fnOpenRetrieveEvent();
                break;
            } case "btng_rowadd": {
                if(processFlag) return;
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
            }
            case "btng_downexcel": {
                if(processFlag) return;
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            }
            case "btn_minimize": {
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject, 100);
                break;
            }
            case "btng_provider": {
                if(processFlag) return;
                rep_OnPopupClick();
                break;
            }
            case 'btns_calendar': {
                if(processFlag) return;
                getCalendar();
                break;
            }
            case 'btns_calendar_single': {
                if(processFlag) return;
                getCalendarSingle();
                break;
            }
            case "btns_wo_no": { 
                if(processFlag) return;
                if(formObject.wo_radio[2].checked) {
                    return false;
                }
                rep_Multiful_inquiry(srcName);
                break;
            }
            case "btns_dor_pst_cd":
            case "btns_tvvd_no":
            case "btns_fvvd_no":
            case "btns_cop_no":
            case "btns_bkg_no":
            case "btns_bl_no":
            case "btns_eq_no":
            case "btns_so_no":
            case "btns_mty_rfrn_no":
            case "btns_fm_lcc_cd":
            case "btns_to_lcc_cd":
            case "btns_ecc_cd": 
            case "btns_cntr_slt_no": {
                if(processFlag) return;
                rep_Multiful_inquiry(srcName);
                break;
            }
            case 'btng_wopreview': {
                if(processFlag) return;
                var checkList=sheetObject.FindCheckedRow('ibcheck');
                var arrRow=checkList.split("|");
                if(checkList == '') {
                    ComShowCodeMessage('COM12176');
                    return false;
                }            
                for (idx=0; idx < arrRow.length; idx++) { 
                    var loc=sheetObject.GetCellValue( arrRow[idx] , "fm_loc_value" );
                    var zip=sheetObject.GetCellValue( arrRow[idx] , "dor_pst_cd" );
                    var cost_mod=sheetObject.GetCellValue( arrRow[idx] , "trsp_cost_dtl_mod_nm");
                    var trsp_mod=sheetObject.GetCellValue( arrRow[idx] , "trsp_crr_mod_nm");
                    var iWoIssued = sheetObject.GetCellValue( arrRow[idx] , "wo_issued");
                    var iTrsSubStsCd = sheetObject.GetCellValue( arrRow[idx] , "trs_sub_sts_cd");
                    var iCancelCheck = sheetObject.GetCellValue( arrRow[idx] , "cancel_check");
                    var iCngIndFlg = sheetObject.GetCellValue( arrRow[idx] , "cng_ind_flg");
                    var iVndrCm = sheetObject.GetCellValue( arrRow[idx] , "vndr_cm");
                    var iDoHldFlg = sheetObject.GetCellValue( arrRow[idx] , "do_hld_flg"); // EU Cargo Release "Hold" Status(I/B Only)
                    
                    if(iWoIssued == 'N' && iTrsSubStsCd == 'DF' &&  iCancelCheck == 1) {
                    	ComShowCodeMessage('TRS90439');
                    	return false;    
                    }
                    if(iCngIndFlg == 'Y' || iVndrCm == 'Y') {
                    	ComShowCodeMessage('TRS90443');
                    	return false;    
                    }
                    if(cost_mod == 'DOOR' && trsp_mod == 'TD') {
                        if( loc.substring(0,2) == 'US' && (zip =="" ||!ComIsNumber(zip)||zip.length != 5)) {
                        	ComShowCodeMessage('TRS90438');
                            sheetObject.SelectCell(arrRow[idx], "dor_pst_cd" );
                            return false ;    
                        }                                                             
                    }
                    if(!funcWoDateValidCheck(sheetObject, arrRow[idx])) {
                    	ComShowCodeMessage('TRS90462');
                    	return false;    
                    }
                    if(iDoHldFlg == 'Y') { // EU Cargo Release "Hold" Status(I/B Only)
                    	ComShowCodeMessage('TRS90488');
                    	return false;
                    }
                }
                doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;
            }
            case 'btng_draft': {
                if(processFlag) return;
                var checkList=sheetObject.FindCheckedRow('ibcheck');
                var arrRow=checkList.split("|");
                if(checkList == '') {
                    ComShowCodeMessage('COM12176');
                    return false;
                }            
                for (idx=0; idx<arrRow.length; idx++) { 
                    var loc=sheetObject.GetCellValue( arrRow[idx] , "fm_loc_value" );
                    var zip=sheetObject.GetCellValue( arrRow[idx] , "dor_pst_cd" );
                    var cost_mod=sheetObject.GetCellValue( arrRow[idx] , "trsp_cost_dtl_mod_nm" );
                    var trsp_mod=sheetObject.GetCellValue( arrRow[idx] , "trsp_crr_mod_nm" );
                    if(cost_mod == 'DOOR' && trsp_mod == 'TD') {
                        if( loc.substring(0,2) == 'US' && (zip =="" ||!ComIsNumber(zip)||zip.length != 5)) {
                        	ComShowCodeMessage('TRS90438');
                            sheetObject.SelectCell(arrRow[idx], "dor_pst_cd" );
                            return false ;    
                        }                                                             
                    }
                    if(!funcWoDateValidCheck(sheetObject, arrRow[idx])) {
                    	ComShowCodeMessage('TRS90462');
                    	return false;    
                    }
                }
                doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
                break;
            }
            case 'btng_trnasp_status_update': {
            	if (sheetObject.RowCount() < 1){
            		ComShowCodeMessage('TRS90411');
            	    return false;
            	}
	        	 var checkList=sheetObject.FindCheckedRow('ibcheck');
	        	 var arrRow=checkList.split("|");
	             if(checkList == '') {
	                 ComShowCodeMessage('COM12176');
	                 return false;
	             } 
            	for (idx=0; idx < arrRow.length; idx++) { 
                     var iCngIndFlg = sheetObject.GetCellValue( arrRow[idx] , "cng_ind_flg");
                     var iVndrCm = sheetObject.GetCellValue( arrRow[idx] , "vndr_cm");
                     if(iCngIndFlg == 'Y' || iVndrCm == 'Y') {
                     	ComShowCodeMessage('TRS90443');
                     	return false;    
                     }
                }
            	doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC03);
            	break;
            }
            case 'btng_frustrate': {
                if(processFlag) return;
                setFrustrate(sheetObject);
                break;
            }
            case 'btng_spselect':{
                if(processFlag) return;
                fnCloseWoPreview();
                popSpselect(sheetObject);
                break;
            }
            case "btns_frmnode": {
                openHireYardPopup('getFromNode');
                break;
            }
            case "btns_vianode": { 
                openHireYardPopup('getViaNode');
                break;
            }
            case "btns_tonode": {
                openHireYardPopup('getToNode');
                break;
            }
            case "btns_dorloc": {
                openHireYardPopup('getDorLoc');
                break;
            }
            case "btns_office": {
                if( validation_check()) {
                    var ofc_cd=formObject.input_office.value;
                    ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'OpneHistoryWin', 'top=200, left=200, width=600, height=370, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
                }
                break;
            }
            case "btns_tvvd_s_no": {
                if(processFlag) return;
                openTVVDPopup();
                break;
        	}
            case "btns_fvvd_s_no": {
                if(processFlag) return;
                openFVVDPopup();
                break;
            }
            case "btng_surchargeapply": {
                if(processFlag) return;
                popSurchargeInputInquiry(sheetObject, '', '', 'multiple', 'WO');
                break;
            }
            case "btng_cmdtl": {
                popCmDtail(sheetObject, formObject);
                break;                
            }
            case "btng_morecandidate": {
            	if(processFlag)  return;
            	fnCloseWoPreview();
				multi_moreCandidate(sheetObject);
				break; 
            }
            case "btng_vndrcm": {
            	popupVndrCm();
				break; 
            }
            case "btng_joedihis": {
            	popupJoEdiHistory();
				break; 
            }
            case "btng_cycntrupd": {
            	updateCYContainerNo();
            	break; 
            }
//			case "btn_template": 		
//				var retVal=ComOpenPopup('/opuscntr/ESM_BKG_0104.do?p_bkg_rpt_knd_cd=B', 850, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
//            	break;
			case "btn_template_SaveAs":
				var retVal = ComOpenPopup('/opuscntr/ESD_TRS_0912.do?tmpl_desc='+templateCombo.GetSelectText(), 400, 180, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
				retVal.focus();
				//doActionIBSheetForTemplate(sheetObject4, formObject, IBINSERT);
				// 1. set temporary form element(template old name, new name & value)
				// 2. URLencode value and send(old name is null then insert, not null then update new name & value by old name)
				// 3. retrieve template combo again
				//doActionIBSheetForTemplate(sheetObject4, formObject, IBSEARCH);
            	break;
			case "btn_template_Save":
				if(templateCombo.GetSelectIndex() < 0) {
					ComShowCodeMessage('COM12113', 'Template to save');
					return;
				} else if (ComShowCodeConfirm("COM130101", "Template [" + templateCombo.GetSelectText() + "]")) {
					doActionIBSheetForTemplate(sheetObject4, formObject, IBSAVE);
					// 1. set temporary form element(template name & value)
					// 2. URLencode value and send
					// 3. retrieve template combo again
					//doActionIBSheetForTemplate(sheetObject4, formObject, IBSEARCH);
				}
            	break;
			case "btn_template_Delete":
				if(templateCombo.GetSelectIndex() < 0) {
					ComShowCodeMessage('COM12113', 'Template to delete');
					return;
				} else if (ComShowCodeConfirm("COM12165", "Template [" + templateCombo.GetSelectText() + "]")) {
					doActionIBSheetForTemplate(sheetObject4, formObject, IBDELETE);
					// 1. send template combo name(combo text)
					// 2. retrieve template combo again
					//doActionIBSheetForTemplate(sheetObject4, formObject, IBSEARCH);
				}
            	break;
        } 
    } catch(e) {
        if( e == "[object Error]")  {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * W/O Preview Pop-Up  Close.
 */
function fnCloseWoPreview() {
	for(var i = 0;  i < previewPopObject.length; i++) {
		previewPopObject[i].close();
	}
	previewPopObject = new Array();
}

/**
 * Register IBSheet Object with array
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
	document.form.hid_wo_radio.value = "";
    for(var i=0;i<sheetObjects.length;i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (var k=0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k + 1);
    }
    initControl();
    if(init_searchStr) {
    	document.form.eq_radio.value = document.form.EQ_MODE.value;
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

function initControl() {
    DATE_SEPARATOR="-";
    var formObject=document.form;
    axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - Focus
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
}

/**
 * 
 * @param comboObj
 * @param comboNo
 */
function initCombo(comboObj, comboNo) {
	 var cnt  = 0 ;
	switch(comboObj.options.id) {
		case 'trs_sub_sts_cd' :  {
			 comboObj.SetMultiSelect(1);
			 comboObj.InsertItem(cnt ++, "Draft", "DF");
			 comboObj.InsertItem(cnt ++, "Ordered", "OR");
			 comboObj.InsertItem(cnt ++, "Started", "ST");
			 comboObj.InsertItem(cnt ++, "Accepted", "AC");
			 comboObj.InsertItem(cnt ++, "Completed", "CM");
			 comboObj.SetColAlign(0, "left");
			 comboObj.SetMultiSeparator(",");
			break;
		}
		case 'templateCombo' :  {
			 comboObj.SetMultiSelect(0);
			 comboObj.InsertItem(cnt ++, "", "");
			 comboObj.SetColAlign(0, "left");
			break;
		}
		case 'search_fm_yard'   :
		case 'search_via_yard'	: 
		case 'search_to_yard' 	:
		case 'search_door_yard' : {
			 comboObj.SetMultiSelect(0);
			 comboObj.InsertItem(cnt ++, "", "");
			 comboObj.SetColAlign(0, "left");
			break;
		}
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
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetNo) {
       case 1: {
            with(sheetObj) {
                  var HeadTitle1="|Rerate|SHPMT\nCM|SHPMT\nCM|VNDR\nCM|VNDR\nCM|Issue\ncancel|BKG\nStat.|BKG\nStat.|Cancel\nReason|Slot Ref No.|B-\nNumber\nIssue|W/O\nIssued|Detain|Transp\nStatus|Attached\nFlag|EQ No.|TP/SZ"+
                  "|GENSET|CB\nSEQ|Bundle Kind|ECC|Cargo\nType|Revenue\nEmpty\nContainer|Cost\nMode|Trans\nMode|S/O Type"+
                  "|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Door\nLocation"+
                  "|Door Information|Door Information|Door Information|Door Information"+
                  "|Door Information|Door Information|Door Information"+
                  "|Multi\nStop|F|O|C|Pickup No."+
                  "|Estimated Time\n(From Departure)|Estimated Time\n(To Arrival)|Estimated Time\n(Door Arrival)"+
                  "|Latest Movement Status|Latest Movement Status|Latest Movement Status|Full CGO CCT|Port CCT|COP No|A/G SEQ|A/G Code"+
                  "|BKG No|BL No|BND|TRO Information|TRO Information|TRO Information|TRO Information"+
                  "|TRO Information|TRO Information|TRO Information|TRO Information"+
                  "|BKG QTY|Weight(KGS)|Weight(KGS)|Weight(KGS)|Weight(KGS)|Weight(LBS)|Weight(LBS)|Weight(LBS)|Weight(LBS)|BKG\nSPE|T.VVD|Lane|In VVD|Out VVD"+
                  "|Shipper|Consignee|Notify"+
                  "|MTY Reference No|S/O No|S/O\nCreation\nUser Name|S/O\nCreation\nTime"+
                  "|W/O No|W/O\nCreation\nUser Name|W/O\nIssue\nTime"+
                  "|Default\nS/P|CNT|Customer\nCode|S/P\nCode|S/P\nName|W/O\nEDI\nUse|AGMT\nType|One Way/\nRound Trip|Currency"+
                  "|Basic|Negotiated|Fuel|Additional"+
                  "|Total|Total(USD)|More\nCandidates|3rd Party"+
                  "|Internal\nRemark|Internal\nRemark|Remark\n(Special Instruction)|W/O Instruction|Frustrate";
                  
                  var HeadTitle2="|Rerate|SHPMT\nCM|SHPMT\nCM|VNDR\nCM|VNDR\nCM|Issue\ncancel|BKG\nStat.|BKG\nStat.|Cancel\nReason|Slot Ref No.|B-\nNumber\nIssue|W/O\nIssued|Detain|Transp\nStatus|Attached\nFlag|EQ No.|TP/SZ"+
                  "|GENSET|CB\nSEQ|Bundle Kind|ECC|Cargo\nType|Revenue\nEmpty\nContainer|Cost\nMode|Trans\nMode|S/O Type"+
                  "|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Door\nLocation"+
                  "|Actual\nCustomer|Factory\nName|Zip\nCode|Address"+
                  "|TEL|FAX|PIC"+
                  "|Multi\nStop|F|O|C|Pickup No."+
                  "|Estimated Time\n(From Departure)|Estimated Time\n(To Arrival)|Estimated Time\n(Door Arrival)"+
                  "|Status|Yard|Date|Full CGO CCT|Port CCT|COP No|A/G SEQ|A/G Code"+
                  "|BKG No|BL No|BND|SEQ|CNFM|Office|User ID"+
                  "|Time|Time|Revenue\nCurrency|Revenue\nAmount"+
                  "|BKG QTY|VGM|Net|Tare|Gross|VGM|Net|Tare|Gross|BKG\nSPE|T.VVD|Lane|In VVD|Out VVD"+
                  "|Shipper|Consignee|Notify"+
                  "|MTY Reference No|S/O No|S/O\nCreation\nUser Name|S/O\nCreation\nTime"+
                  "|W/O No|W/O\nCreation\nUser Name|W/O\nIssue\nTime"+
                  "|Default\nS/P|CNT|Customer\nCode|S/P\nCode|S/P\nName|W/O\nEDI\nUse|AGMT\nType|One Way/\nRound Trip|Currency"+
                  "|Basic|Negotiated|Fuel|Additional"+
                  "|Total|Total(USD)|More\nCandidates|3rd Party"+
                  "|Internal\nRemark|Internal\nRemark|Remark\n(Special Instruction)|W/O Instruction|Frustrate";
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:10 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1};
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [
                              {Type:"CheckBox",  Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
                              {Type:"CheckBox",  Hidden:0,  Width:65,  Align:"Center",  ColMerge:0,   SaveName:"more_candi_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:1, TrueValue:"Y", FalseValue:"N" },
                              {Type:"Image",  	 Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"cng_ind_flg_img",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   ImgWidth:13, ImgHeight:13},
                              {Type:"Text",  	 Hidden:1,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"cng_ind_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Image",  	 Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"vndr_cm_img",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   ImgWidth:13, ImgHeight:13},
                              {Type:"Text",  	 Hidden:1,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"vndr_cm",              	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"CheckBox",  Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"cancel_check",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:1, TrueValue:"Y", FalseValue:"N" },
                              {Type:"Text",  	 Hidden:1,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",  	 Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Combo",     Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"trsp_rjct_rsn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                              {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"cntr_slt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"CheckBox",  Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"wo_bl_no_iss_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:1, TrueValue:"Y", FalseValue:"N" },
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"wo_issued",           	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"CheckBox",  Hidden:0,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"dtn_use_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:1, TrueValue:"Y", FalseValue:"N" },
                              {Type:"Combo",     Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"trs_sub_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"cop_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                              {Type:"Text",      Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"eq_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                              {Type:"Text",      Hidden:0,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"pwr_spl_cbl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_tp_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"rvn_mpt_cntr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"trsp_cost_dtl_mod_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_tp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"via_loc_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"via_yard_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"dor_loc_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"dor_yard_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",  	 Hidden:0,  Width:100, Align:"left",    ColMerge:0,   SaveName:"dor_nod_cd_nm",			   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"act_cust_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"fctry_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"dor_pst_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"dor_de_addr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"left",    ColMerge:0,   SaveName:"cntc_pson_phn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"left",    ColMerge:0,   SaveName:"cntc_pson_fax_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                              {Type:"Text",      Hidden:0,  Width:100, Align:"left",    ColMerge:0,   SaveName:"cntc_pson_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                              {Type:"Popup",     Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"mlt_stop_de_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"cgo_frt_rcv_ind_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
     			              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"cgo_obl_rcv_ind_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0},
     			              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"cgo_cstms_clr_ind_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
     			              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"cntr_pkup_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Date",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"n1st_nod_pln_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                              {Type:"Date",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"lst_nod_pln_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                              {Type:"Date",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"dor_nod_pln_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",              	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"r_cct",					   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"t_cct",					   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"cop_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"cost_act_grp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"cost_act_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"bl_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"trsp_bnd_cd" ,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"tro_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"tro_cnfm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"tro_cfm_upd_tm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"rev_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:70,  Align:"right",   ColMerge:0,   SaveName:"revenue",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"left",    ColMerge:0,   SaveName:"bkg_qty",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"vgm_kgs_wgt",              KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"kgs_net_wgt",              KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:3,   UpdateEdit:1,   InsertEdit:0,	  EditPointCount:3},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"kgs_tare_wgt",             KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"kgs_gross_wgt",            KeyField:0,   CalcLogic:"|kgs_net_wgt|+|kgs_tare_wgt|",   Format:"",       	  PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"vgm_lbs_wgt",              KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"lbs_net_wgt",              KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:3,   UpdateEdit:1,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"lbs_tare_wgt",             KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"lbs_gross_wgt",            KeyField:0,   CalcLogic:"|lbs_net_wgt|+|lbs_tare_wgt|",   Format:"",       	  PointCount:3,   UpdateEdit:0,   InsertEdit:0},                         
                              {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"t_vvd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"lane",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"ib_vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"ob_vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"shpr_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"cnee_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"ntfy_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:120, Align:"Center",  ColMerge:0,   SaveName:"ref_id",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"so_cre_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"so_cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"wo_cre_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:130, Align:"Center",  ColMerge:0,   SaveName:"wo_issue_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"trsp_dflt_vndr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"po_sp_type",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"vndr_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"wo_edi_use_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Text",      Hidden:1,  Width:80,  Align:"left",    ColMerge:0,   SaveName:"po_trsp_agmt_rt_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Combo",     Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"po_way_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0},
                              {Type:"Combo",     Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"po_local_curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                              {Type:"Float",     Hidden:0,  Width:80,  Align:"right",   ColMerge:0,   SaveName:"po_basic_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
                              {Type:"Float",     Hidden:0,  Width:100, Align:"right",   ColMerge:0,   SaveName:"nego_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                              {Type:"Float",     Hidden:0,  Width:100, Align:"right",   ColMerge:0,   SaveName:"po_fuel_scg_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
                              {Type:"Popup",     Hidden:0,  Width:100, Align:"right",   ColMerge:0,   SaveName:"etc_add_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                              {Type:"Float",     Hidden:0,  Width:110, Align:"right",   ColMerge:0,   SaveName:"po_local_curr_tot_amt",    KeyField:0,   CalcLogic:"|po_basic_rt|+|po_fuel_scg_rt|+|nego_amt|+|etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
                              {Type:"Float",     Hidden:0,  Width:110, Align:"right",   ColMerge:0,   SaveName:"po_usd_curr_tot_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
                              {Type:"Popup",     Hidden:1,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"more_candidates",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                              {Type:"Popup",     Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                              {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"inter_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Image",	 Hidden:0,  Width:20,  Align:"Center",  ColMerge:0,   SaveName:"inter_rmk_img",		       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   ImgHeight:20, ImgWidth:19 },
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"spcl_instr_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                              {Type:"Text",      Hidden:0,  Width:150, Align:"left",    ColMerge:0,   SaveName:"wo_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000 },
                              {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"trsp_frst_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Status",    Hidden:0,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_tp_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_cost_dtl_mod_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"surcharge_key" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_tp_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"po_cust_cnt_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"po_cust_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"bundling_no" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"po_trsp_agmt_ofc_cty_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"po_trsp_agmt_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"po_trsp_agmt_rt_tp_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"po_cust_nomi_trkr_flg" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"preset_vndr_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"bkg_tro_no" },
                              {Type:"CheckBox",  Hidden:0,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"rejected_check" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"cntr_wgt" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"wgt_meas_ut_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_amt" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_vndr_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_ofc_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_desc" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_cust_seq" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_cust_cnt_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_tp_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bzc_curr_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"via_nod_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"dor_nod_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd" },
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt" },
                              {Type:"CheckBox",  Hidden:1,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"frust_chk" },
                              {Type:"Text",  	 Hidden:1,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"do_hld_flg" },
                              {Type:"Text",  	 Hidden:1,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd_nm" },
                              {Type:"Text",  	 Hidden:1,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"via_nod_cd_nm" },
                              {Type:"Text",  	 Hidden:1,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd_nm" },
                              {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"conti_cd" },
                              {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"scg_ind_cd" }
                              ];
                  InitColumns(cols);
                  SetEditable(1);
                  SetColHidden('ibflag',1);
                  SetColHidden('surcharge_key',1);
                  SetColHidden('rejected_check',1);
                  SetColProperty('trsp_rjct_rsn_cd', {ComboText:"RejectedByS/P|S/O Cand.Delet|TRSOwnReason", ComboCode:"R|B|O"} );
                  SetColProperty('trs_sub_sts_cd', {ComboText:"|Draft|Ordered|Accepted|Started|Completed", ComboCode:"|DF|OR|AC|ST|CM"} );
                  SetColProperty('po_way_type', {ComboText:"|OneWay(CYrate)|RoundTrip(DRrate)", ComboCode:"|ONE|RND"} );
                  SetColProperty('po_local_curr_cd', {ComboText:po_local_curr_cdText, ComboCode:po_local_curr_cdCode} );
                  ComResizeSheet(sheetObj, 100);
                  SetRangeBackColor(1, 28, 1, 34,"#555555");// ENIS
                  SetRangeBackColor(1, 42, 1, 44,"#555555");// ENIS
                  SetImageList(0,"img/ico_g.gif");
                  SetImageList(1,"img/btns_search_g.gif");
            }
            break;
       	}
        case 2: {
        	//surcharge sheet
            with(sheetObj) {
                  var HeadTitle="ibflag|ibcheck|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|trsp_step_tp_cd" ;
                  SetConfig( { SearchMode:0 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [
                         {Type:"Status",    Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                         {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_step_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_no',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incur_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_no',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incur_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_curr_cd',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_agmt_ofc_cty_cd',        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_agmt_seq',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_agmt_rt_tp_ser_no',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_agmt_scg_nod_seq',       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_agmt_scg_rt_seq',        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fuel_rto',        		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'com_scg_knd_cd',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'com_scg_seq',      		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_dtl_seq',      		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+'curr_cd',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'wo_scg_xch_rt',               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'org_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
                         ];
                   
                  InitColumns(cols);
                  SetEditable(1);
                  SetVisible(false);
                }
           break;
        }
        case 3: {
        	//wo issued so no sheet
            with(sheetObj) {                    
                  var HeadTitle="OFC_CD|SO_SEQ" ;
                  SetHeaderRowHeight(30);
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:'trsp_so_ofc_cty_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'trsp_so_seq',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];                   
                  InitColumns(cols);        
                  SetEditable(1);
                  SetVisible(false);
                }
           break;  
        }
        case 4: {
            with(sheetObj){        
		            var HeadTitle="OFC_CD|SO_SEQ" ;
		            SetHeaderRowHeight(30);
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:'trsp_so_ofc_cty_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'trsp_so_seq',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];                   
		            InitColumns(cols);        
		            SetEditable(1);
		            SetVisible(false);
                }
           break;  
        }
        case 5: {
            with(sheetObj){        
		            var HeadTitle="ibflag|ibcheck|OFC_CD|PGM_NO|SEQ_NO|TMPL_DESC|COND_PRM|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|DELT_YN";
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,  Align:"Center", ColMerge:0, SaveName:"ibflag" },
		                         {Type:"CheckBox",  Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"ibcheck" },
		                         {Type:"Text",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'ofc_cd',     KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'pgm_no',     KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center", ColMerge:0, SaveName:'seq_no',     KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:140, Align:"Left",   ColMerge:0, SaveName:'tmpl_desc',  KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:200, Align:"Left",   ColMerge:0, SaveName:'cond_prm',   KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'cre_usr_id', KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Date",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'cre_dt',     KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'upd_usr_id', KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Date",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'upd_dt',     KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:0,  InsertEdit:1 },
		                         {Type:"Text",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:'delt_yn',    KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1,  InsertEdit:1 } ];                   
		            InitColumns(cols);
		            SetEditable(1);
		            SetVisible(false);
                }
           break;  
        }
    }
}

function sheet_OnPopupClick (sheetObj , row , col ) {
    var colName=sheetObj.ColSaveName(col);
    var value=sheetObj.GetCellValue(row, colName);
    switch(colName) {
        case('more_candidates'): {
        	var oTrsSubStsCdVal = sheetObj.GetCellValue(row, 'trs_sub_sts_cd');	
        	var oWoIssued =  sheetObj.GetCellValue(row, 'wo_issued');
        	var oMcntrBdlGrpSeq =  sheetObj.GetCellValue(row, 'mcntr_bdl_grp_seq');
        	var oMcntrBdlSeq =  sheetObj.GetCellValue(row, 'mcntr_bdl_seq');
            if(oWoIssued == 'Y' || (oWoIssued == 'N' && oTrsSubStsCdVal == 'DF')) {
            	return false;
            }
            if (oMcntrBdlGrpSeq != "" && oMcntrBdlSeq != "1" ){
				return false;
			}
            var url='?targetRow='+row;
            url += '&trsp_so_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
            url += '&trsp_so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq');
            url += '&ctrl_ofc_cd='+sheetObj.GetCellValue(row, 'cre_ofc_cd');
            url += '&vndr_seq='+sheetObj.GetCellValue(row, 'vndr_seq');
            url += '&basis_dt='+sheetObj.GetCellValue(row, 'so_cre_dt');
            url += '&eq_knd_cd='+sheetObj.GetCellValue(row, 'eq_knd_cd');
            url += '&eq_tp_sz_cd='+sheetObj.GetCellValue(row, 'eq_tpsz_cd');
            url += '&cmb_tp_cd='+sheetObj.GetCellValue(row, 'trsp_so_cmb_tp_cd');
            url += '&cgo_tp_cd='+sheetObj.GetCellValue(row, 'cgo_tp_cd');
            url += '&bound_cd='+sheetObj.GetCellValue(row, 'trsp_bnd_cd');
            url += '&crr_mod_cd='+sheetObj.GetCellValue(row, 'trsp_crr_mod_cd');
            url += '&cost_mod_cd='+sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd');
            url += '&cust_cnt_cd='+sheetObj.GetCellValue(row, 'po_cust_cnt_cd');
            url += '&cust_seq='+sheetObj.GetCellValue(row, 'po_cust_seq');
            url += '&cmdt_cd='+sheetObj.GetCellValue(row, 'cmdt_cd');
            url += '&from_nod_cd='+sheetObj.GetCellValue(row, 'fm_loc_value')+sheetObj.GetCellValue(row, 'fm_yard_value');
            url += '&via_nod_cd='+sheetObj.GetCellValue(row, 'via_loc_value')+sheetObj.GetCellValue(row, 'via_yard_value');
            url += '&door_nod_cd='+sheetObj.GetCellValue(row, 'dor_loc_value')+sheetObj.GetCellValue(row, 'dor_yard_value');
            url += '&to_nod_cd='+sheetObj.GetCellValue(row, 'to_loc_value')+sheetObj.GetCellValue(row, 'to_yard_value');
            url += '&bundle_cnt='+sheetObj.GetCellValue(row, 'bundling_no');
            url += '&wgt_uom='+sheetObj.GetCellValue(row, 'wgt_meas_ut_cd');
            url += '&wgt_qty='+sheetObj.GetCellValue(row, 'cntr_wgt');
            url += '&agmt_ofc_cty_cd='+sheetObj.GetCellValue(row, 'agmt_ofc_cty_cd');
            url += '&agmt_seq='+sheetObj.GetCellValue(row, 'agmt_seq');
            url += '&way_type='+sheetObj.GetCellValue(row, 'po_way_type');
            ComOpenWindow('ESD_TRS_0921.do'+url, 'ESD_TRS_0921', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:1200px;dialogHeight:560px', true);
            break;
        }
        case('n3pty_bil_flg'): {
            pop3rdPartyBilling(sheetObj, row, col, 'modify');
            break;
        }
        case('etc_add_amt'): {
			var conti_cd             = sheetObj.GetCellValue(row, 'conti_cd');
			var scg_ind_cd           = sheetObj.GetCellValue(row, 'scg_ind_cd');
			var etc_add_amt          = Number(sheetObj.GetCellValue(row, 'etc_add_amt'));
			
			var mode = "search";
			// 구주이면서 Additional Amount가 0이면 Surcharge Popup에서 변경 가능
        	if(conti_cd == "E" && (etc_add_amt == 0 || scg_ind_cd == "S")) {
        		mode = "modify";
        	}
            popSurchargeInputInquiry(sheetObj, row, col, mode, '');
            
            break;
        }
        case('mlt_stop_de_flg'): {
            var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
            var lvbl=sheetObj.GetCellValue(row, "bl_no");
            var lveq=sheetObj.GetCellValue(row, "eq_no");
            var lvts=sheetObj.GetCellValue(row, "eq_tpsz_cd");
            var lvtro=sheetObj.GetCellValue(row, "tro_seq");
            if(lvbkg != '' && lvbl != '' &&  sheetObj.GetCellValue(row, 'mlt_stop_de_flg') == 'Y') {
                var url="ESD_TRS_0933.do?bkgnumber="+lvbkg+"&blnumber="+lvbl+"&cntrnumber="+lveq+"&tpsznumber="+lvts+"&troseqnumber="+lvtro;
                ComOpenWindow(url, "ESD_TRS_0933", 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:1200px;dialogHeight:460px', true);
            }
            break;
        }
        case('spcl_cgo_cntr_tp_cd'): {
        	return;
            var myOption="top=200, left=200, width=900, height=420, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0";
            var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
            var lvbkgst=sheetObj.GetCellValue(row, "bkg_no").substring(11, 13);
            var lveqno=sheetObj.GetCellValue(row, "eq_no");
            var lvbkg_tro_no=sheetObj.GetCellValue(row, "bkg_tro_no");
            var vSpclCgoCntrTpCd  = sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd");
            if( lvbkgst == "" ) {
                lvbkgst = "  ";
            }
            if( vSpclCgoCntrTpCd == 'DG' ) {
                var url="ESD_TRS_0938.do?bkg_no="+lvbkg+"&bkg_no_split="+lvbkgst+"&cntr_no="+lveqno+"&bkg_tro_no="+lvbkg_tro_no;
                ComOpenWindow(url,  "openSpeCgoWin",  myOption);
            } else if( vSpclCgoCntrTpCd == 'BB' ) {
                var url="ESD_TRS_0937.do?bkg_no="+lvbkg+"&bkg_no_split="+lvbkgst+"&cntr_no="+lveqno;
                ComOpenWindow(url,  "openSpeCgoWin",  myOption);
            } else if( vSpclCgoCntrTpCd == 'AK' ) {
                var url="ESD_TRS_0936.do?bkg_no="+lvbkg+"&bkg_no_split="+lvbkgst+"&cntr_no="+lveqno+"&bkg_tro_no="+lvbkg_tro_no;
                ComOpenWindow(url,  "openSpeCgoWin",  myOption);
            } else if( vSpclCgoCntrTpCd == 'RF' ) {
                var url="ESD_TRS_0935.do?bkg_no="+lvbkg+"&bkg_no_split="+lvbkgst+"&cntr_no="+lveqno+"&bkg_tro_no="+lvbkg_tro_no;
                ComOpenWindow(url,  "openSpeCgoWin",  myOption );
            } 
            break;
        }
    }
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @returns {Boolean}
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch(sAction) {
        case COMMAND01: {
            formObj.f_cmd.value = INIT;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var sXml = sheetObj.GetSearchData("ESD_TRS_0023GS.do", FormQueryString(formObj), {sync:2});
            var arrXml = sXml.split("|$$|");
            ComXml2ComboItem(arrXml[0], cgo_tp_cd, "val", "name");
            cgo_tp_cd.SetDropHeight(300);
            ComXml2ComboItem(arrXml[1], spcl_cgo_cntr_tp_cd, "val", "val");
            spcl_cgo_cntr_tp_cd.SetDropHeight(300);
            ComXml2ComboItem(arrXml[2], eq_tpsz_cd, "cntr_tpsz_cd", "cntr_tpsz_cd");
            eq_tpsz_cd.SetDropHeight(300);
            ComOpenWait(false);
            break;
        }
        case IBSEARCH: {
        	repalceDateField(formObj);
        	if(!init_searchStr) {
	            if(formObj.fmdate.value == '' || formObj.todate.value == '') {
	                if(formObj.tvvd_no.value == '' && formObj.fvvd_no.value == ''
	                && formObj.bkg_no.value == '' && formObj.bl_no.value == ''
	                && formObj.eq_no.value == '' && formObj.so_no.value == ''
	                && formObj.wo_no.value == '' && formObj.mty_rfrn_no.value == ''
	                && formObj.search_fm_loc.value == '' 
	                && formObj.search_to_loc.value == ''
	                && formObj.search_door_loc.value == ''
	                && formObj.fm_lcc_cd.value == ''
	                && formObj.to_lcc_cd.value == ''
	                )
	                {
	                    ComShowCodeMessage("TRS90124");
	                    return false;
	                }
	            }
        	
	            var days_between=ComGetDaysBetween(formObj.fmdate, formObj.todate);
	    	    if( days_between < 0 ) {
	                ComShowCodeMessage("TRS90118");
	                formObj.fmdate.focus();
	                return false;
	            }
	            if ( days_between > 30 ) {
	            	ComShowCodeMessage("TRS90424");
	                return false;
	            }
        	}
        	if(!TrsComValidFormat("SO", formObj.so_no.value, true)) { return false; }
        	if(!TrsComValidFormat("WO", formObj.wo_no.value, true)) { return false; }
        	
            formObj.f_cmd.value = SEARCH;
            ComOpenWait(true);
            processFlag = true;
            formObj.wo_radio[0].disabled = true;
            formObj.wo_radio[1].disabled = true; 
            formObj.wo_radio[2].disabled = true;
            if(formObj.ruoh.checked == true) {
                formObj.ruoh.value = "Y";
            } else {
                formObj.ruoh.value = "";
            }
            sheetObj.DoSearch("ESD_TRS_0023GS.do", TrsFrmQryString(formObj),{ Sync : 2 } );
            processFlag = false;
            ComOpenWait(false);
            formObj.wo_radio[0].disabled = false;
            formObj.wo_radio[1].disabled = false;
            formObj.wo_radio[2].disabled = false;
            break;
        }
        case IBSAVE:  {
            processFlag = true;
            if(!validateForm(sheetObjects[0],formObj,sAction)) {
                processFlag = false;
                return false;
            }
            document.woForm.reset();
            addSurchargeData();
            formObj.p_draft_flg.value = "";
            if(sheetObj.RowCount() > 0) {
                formObj.f_cmd.value = ADD;
                var surchargeQuery=sheetObj.GetSaveString(true, false);
                sheetObj.DoSearch("ESD_TRS_0918GS.do", surchargeQuery+'&'+TrsFrmQryString(formObj), {Sync:2, Append:true});
            } else {
            	document.woForm.scg_grp_seq.value = "";
                gotoPreview(sheetObjects[0], formObj);
            }
            processFlag = false;
            break;
        }
        
        case IBSEARCH_ASYNC01: {       //DRAFT
            processFlag = true;
            if(!validateForm(sheetObjects[0], formObj, sAction)) {
                processFlag = false;
                return false;
            }
            document.woForm.reset();
            addSurchargeData();
            formObj.p_draft_flg.value = "DF";
            repalceDateField(formObj);
            if(sheetObj.RowCount() > 0) {
                formObj.f_cmd.value = ADD;
                var surchargeQuery = sheetObj.GetSaveString(true, false);
                sheetObj.DoSearch("ESD_TRS_0918GS.do", surchargeQuery+'&'+TrsFrmQryString(formObj), {Sync:2,Append:true});
            } else {
            	document.woForm.scg_grp_seq.value = "";
                gotoPreview(sheetObjects[0], formObj);
            }                
            processFlag = false;
            break;            
        }
        
        case IBDOWNEXCEL: {
        	//Excel Download
            if(sheetObj.RowCount() < 1) {    
                ComShowCodeMessage("COM132501");
            } else {    
                if(sheetObj.RowCount() < 1) {
                      ComShowCodeMessage("COM132501");
                } else {
                	var excludeField = ["ibcheck", "cng_ind_flg_img", "vndr_cm_img", "inter_rmk_img"];
                	var includeField = ["cng_ind_flg", "vndr_cm"];
                	sheetObj.Down2Excel( {DownCols: makeExcelDownSkipColumn(sheetObj, true, excludeField, includeField), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
                }
            }    
            break;
        }
        case IBINSERT: {
            sheetObj.DataInsert();
            break;
        }
        case IBSEARCH_ASYNC02: {
        	if (sheetObj.RowCount() < 1){
        		ComShowMessage(ComGetMsg('TRS90411'));
        	    return false;
        	}
        	if (sheetObj.CheckedRows('ibcheck') < 1){
        		ComShowMessage(ComGetMsg('TRS90382'));
        		return false;
        	}
        	processFlag=true;
            formObj.f_cmd.value=MULTI02;
            var param=sheetObj.GetSaveString(false, true, 'ibcheck');
            repalceDateField(formObj);       
            sheetObj.DoSearch("ESD_TRS_0023GS.do", param+'&'+TrsFrmQryString(formObj),{Sync:2,Append:true} );
            processFlag=false;
            break; 
        }
        case IBSEARCH_ASYNC03: {
            formObj.f_cmd.value=SEARCH10;
            repalceDateField(formObj);
            var tempIssueCnt = 0;	
            var checkCnt =0; 
            var arr = new Array();
            for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){            	
            	if(sheetObj.GetCellValue(i,'ibcheck') == true){
            		var oTrsSubStsCdVal = sheetObj.GetCellValue(i, 'trs_sub_sts_cd');	
            		if(sheetObj.GetCellValue(i,'wo_issued') == 'N' && oTrsSubStsCdVal != 'DF'){
            			tempIssueCnt++;
            			if(tempIssueCnt > 0) {
            				break;
            			}
            		} else {
            			checkCnt++;
            		}
            	}
            }
            if(tempIssueCnt > 0) {
            	ComShowCodeMessage("TRS90435");
            	return false;
            }
            var param=sheetObj.GetSaveString(false, true, 'ibcheck');
            sheetObj.DoSearch("ESD_TRS_0023GS.do", param+'&'+TrsFrmQryString(formObj),{Sync:2, Append:true} );
            break; 
        }
        case IBSEARCH_ASYNC04: {
            formObj.f_cmd.value=MULTI03;
            sheetObj.DoSave("ESD_TRS_0023GS.do", {Param:TrsFrmQryString(formObj), Col:"ibcheck", Quest:0 } );
            break; 
        }        
    }
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @returns {Boolean}
 */
function doActionIBSheetForTemplate(sheetObj, formObj, sAction, templateComboIndex) {
    switch(sAction) {
	    case IBSEARCH: {
	        formObj.f_cmd.value = COMMAND01;
	        sheetObj.SetWaitImageVisible(0);
	        ComOpenWait(true);
	        var sXml = sheetObj.GetSearchData("ESD_TRS_0912GS.do", FormQueryString(formObj), {sync:2});
	        //var arrXml = sXml.split("|$$|");
	        if(sXml != null) {
	        	sheetObj.LoadSearchData(sXml);
				initSearchTemplate(sXml, templateComboIndex);
			}
	        ComOpenWait(false);
	        break;
	    }
        case IBINSERT:  {
            processFlag = true;
            formObj.f_cmd.value = ADD;
            var row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(row, "ofc_cd", formObj.old_ofc_cd.value, 0);
            sheetObj.SetCellValue(row, "pgm_no", formObj.pgm_no.value, 0);
            sheetObj.SetCellValue(row, "tmpl_desc", formObj.temp_tmpl_desc.value, 0);
            sheetObj.SetCellValue(row, "cond_prm", JoinFormElements(formObj), 0);
            sheetObj.SetCellValue(row, "delt_yn", "N", 0);
            
            sheetObj.CheckAll("ibcheck", 0, 0);
            sheetObj.SetCellValue(row, "ibcheck", 1, 0);
            sheetObj.DoSave("ESD_TRS_0912GS.do", { Param : FormQueryString(formObj), Col : "ibcheck", Quest : 0 });
            processFlag = false;
            break;
        }
        case IBSAVE:  {
            processFlag = true;
            formObj.f_cmd.value = MODIFY;
            var row = sheetObj.FindCheckedRow("ibcheck").split("|")[0];
            sheetObj.SetCellValue(row, "cond_prm", JoinFormElements(formObj), 0);
            sheetObj.DoSave("ESD_TRS_0912GS.do", { Param : FormQueryString(formObj), Col : "ibcheck", Quest : 0 });
            processFlag = false;
            break;
        }
        case IBDELETE:  {
            processFlag = true;
            formObj.f_cmd.value = MODIFY;
            var row = sheetObj.FindCheckedRow("ibcheck");
            sheetObj.SetCellValue(row, "delt_yn", "Y", 0);

            sheetObj.DoSave("ESD_TRS_0912GS.do", { Param : FormQueryString(formObj), Col : "ibcheck", Quest : 0 });
            processFlag = false;
            break;
        }
    }
}

function repalceDateField(formObj) {
	  formObj.fmdate.value = formObj.fmdate.value.split('-').join('');
      formObj.todate.value = formObj.todate.value.split('-').join('');
      formObj.dor_arr_dt.value = formObj.dor_arr_dt.value.split('-').join('');
}

/**
 * When you click the radio button to delete the status change and add hidden value, the opposite value.
 */
function change_eq_val() {
   var formObject = document.form;
   if ( formObject.eq_radio[0].checked == true ) {
       formObject.eq_radio.value = "U";
   } else if( formObject.eq_radio[1].checked == true ) {
	   formObject.eq_radio.value = "Z";
   } else if( formObject.eq_radio[2].checked == true ) {
	   formObject.eq_radio.value = "G";
   }
   
   var a = doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet_OnSaveEnd(sheetObj, errCode, errMsg) {
	if (errCode >= 0) {
    var formObj=document.form;
        if(formObj.f_cmd.value == MULTI01) {
			var checkList = sheetObj.FindCheckedRow('ibcheck');
            var checkArray=checkList.split('|');
            for(var i=0; i < checkArray.length; i++)    {
                sheetObj.SetCellValue(checkArray[i], 'trsp_frst_flg','Y',0);
            }
            ComShowCodeMessage('COM12156', 'Frustrate');
        } else if(formObj.f_cmd.value == MULTI03){
        	 doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	 ComShowCodeMessage('COM12156');
        }
    }
}

function getDateBetween(obj) {
    if(obj.value == ""){
        document.form.todate.value="";
    }else{
        document.form.todate.value=ComGetDateAdd(obj.value, "D", 30);  
    }
}

/**
 * Cost Mode == CY && Door Node is Not null => Door Information Field Disabled.
 * 
 * @param sheetObj
 * @param Row
 */
function sheet_OnRowSearchEnd(SheetObject, Row) {
	if(SheetObject.GetCellValue(Row, 'trsp_cost_dtl_mod_cd') == 'CY' && ComIsEmpty(SheetObject.GetCellValue(Row, 'dor_loc_value'))) {
		SheetObject.SetCellEditable(Row, 'act_cust_cd', 0);
		SheetObject.SetCellEditable(Row, 'fctry_nm', 0);
		SheetObject.SetCellEditable(Row, 'dor_pst_cd', 0);
		SheetObject.SetCellEditable(Row, 'dor_de_addr', 0);
		SheetObject.SetCellEditable(Row, 'cntc_pson_phn_no', 0);
		SheetObject.SetCellEditable(Row, 'cntc_pson_fax_no', 0);
		SheetObject.SetCellEditable(Row, 'cntc_pson_nm', 0);
	}
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    var fmDate = formObj.fmdate.value;
    if(fmDate != "") {
    	formObj.fmdate.value = fmDate.substring(0, 4) + "-"+fmDate.substring(4, 6)+"-" + fmDate.substring(6);
    }
    var toDate = formObj.todate.value;
    if(toDate != "") {
    	formObj.todate.value = toDate.substring(0, 4)+"-"+toDate.substring(4, 6)+"-"+toDate.substring(6);
    }
    
    var dorArrDt = formObj.dor_arr_dt.value;
    if(dorArrDt != "") {
    	formObj.dor_arr_dt.value = dorArrDt.substring(0, 4)+"-"+dorArrDt.substring(4, 6)+"-"+dorArrDt.substring(6);
    }

    if( errMsg != '' )  {
        ComShowMessage(errMsg);
    } else {
        if(formObj.f_cmd.value == SEARCH || formObj.f_cmd.value == SEARCH01) {
            for(var i=2; i<sheetObj.RowCount()+2; i++){
                if(sheetObj.GetCellValue(i, 'po_local_curr_cd') == 'JPY' || sheetObj.GetCellValue(i, 'po_local_curr_cd') == 'KRW' || sheetObj.GetCellValue(i, 'po_local_curr_cd') == 'TWD'){
                    setDecimalType(sheetObj, i);
                } else {
                    setFloatingType(sheetObj, i);
                }
                
                // WHEN S/O type is supplement THEN currency code can't be editable
                // but can be editable in S/O creation/correction
    			var sheet1_x1 = sheetObj.GetCellValue(i, "trsp_so_tp_cd");
    			if (sheet1_x1 == "S") {
    				sheetObj.SetCellEditable(i, "po_local_curr_cd", 0);
    			}
            }
            var scgXml=sheetObj.GetEtcData("scgXml");
            if( scgXml == undefined || ComTrim(scgXml) == ''){
                sheetObjects[1].RemoveAll();
                return;
            }
            scgXml=scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
            scgXml=scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
            sheetObjects[1].LoadSearchData(scgXml, {Sync:1 } );
            sheetObj.RemoveEtcData();
        } else if(formObj.f_cmd.value == MULTI02){
        	if(errMsg == "0")  {
        		ComShowCodeMessage('TRS90405'); 
        	}
            sheetObjects[1].RemoveAll();
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        } else if(formObj.f_cmd.value == SEARCH10){
        	var stsCnt = sheetObj.GetEtcData("stsCnt");
        	if(parseInt(stsCnt) > 0){
        		ComShowCodeMessage('TRS90468'); 
        		return false;
        	}
        	ComOpenPopup('/opuscntr/ESD_TRS_0978.do', 450, 200, "", "0,0", true);
        }
     
        
        // 2015.05.19 CHAN WOO PARK
        // Empty Repo, Chassis/Genset인 경우 Internal Remark를 직접 입력하도록 수정
        for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
        	var vTtrspSoTpCd = sheetObj.GetCellValue(row, "trsp_so_tp_cd");
    		var vTrspBndCd = sheetObj.GetCellValue(row, "trsp_bnd_cd");
    		var vDoHldFlg = sheetObj.GetCellValue(row, "do_hld_flg");
    		var vWoIssued = sheetObj.GetCellValue(row, "wo_issued");
    		
    		if (vTtrspSoTpCd == "M" || vTtrspSoTpCd == "H") {
    			sheetObj.SetCellEditable(row, "inter_rmk", 1);
    		}
    		
    		if(vDoHldFlg == "Y") {
    			sheetObj.SetCellValue(row, "dtn_use_flg", 1, 0);
    			sheetObj.SetCellEditable(row, "dtn_use_flg", 0);
    		}
    		
    		if(vTrspBndCd != 'O') {
    			sheetObj.SetCellEditable(row, "kgs_net_wgt", 0);
    			sheetObj.SetCellEditable(row, "lbs_net_wgt", 0);
    		} else {
    			sheetObj.SetCellEditable(row, "kgs_net_wgt", 1);
    			sheetObj.SetCellEditable(row, "lbs_net_wgt", 1);
    		}
    		
    		if(vWoIssued == "N") {
    			sheetObj.SetCellEditable(row, "more_candi_flg", 0);
    		}
        }
    }
}

/**
 * 
 * @param main_sheetObj
 * @param scg_sheetObj
 */
function setUniqueCd(main_sheetObj, scg_sheetObj) {
    var uni_cd=null;
    var idx=-1;
    var before_uni_cd=null;
    for(var i=1; i<scg_sheetObj.RowCount()+1; i++){
        uni_cd=scg_sheetObj.GetCellValue(i, prefix+'trsp_so_seq');
        if( before_uni_cd != uni_cd || idx == -1 ){
            idx=main_sheetObj.FindText('trsp_so_seq', uni_cd);
        }
        if(idx != -1){
            scg_sheetObj.SetCellValue(i, prefix+'unique_cd',main_sheetObj.GetCellValue(idx, 'surcharge_key'),0);
        }
        before_uni_cd=uni_cd;
    }
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    if( errMsg != null && errMsg != '' ) {
        ComEnableObject(document.form.btng_wopreview, true);
        sheetObj.SetWaitImageVisible(false);
        ComOpenWait(false);
        ComShowMessage(errMsg);
    } else {
        var formObj=document.form;
        if(formObj.f_cmd.value == ADD) {
        	formObj.f_cmd.value = "";
            document.woForm.scg_grp_seq.value=sheetObj.GetEtcData('scg_grp_seq');
            gotoPreview(sheetObjects[0], formObj);
        }
        // reset scg_amt
        for(var i=1; i < sheetObj.RowCount()+1; i++){
            if(sheetObj.GetCellValue(i, prefix + 'lgs_cost_cd') == 'SCFAAL'
            	&& Number(sheetObj.GetCellValue(i, prefix + 'fuel_rto')) != '0' && sheetObj.GetCellValue(i, prefix + 'fuel_rto') != '') {
            	var Row1 = sheetObjects[0].FindText("trsp_so_ofc_cty_cd_seq", sheetObj.GetCellValue(i, prefix + 'trsp_so_seq'), 0, 1, 0);
            	sheetObj.SetCellValue(i, prefix + 'scg_amt', Number(sheetObjects[0].GetCellValue(Row1, 'po_fuel_scg_rt')), 0);
            }
        }
        ComEnableObject(document.form.btng_wopreview, true);
        sheetObj.SetWaitImageVisible(false);
        ComOpenWait(false);
    }
}

function sheet5_OnSaveEnd(sheetObj, errMsg) {
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    } else {
    	ComShowCodeMessage('COM132601'); //Data Saved Successfully!!
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
    * Validating inputted values of form
 */
function validateForm(sheetObj,formObj,sAction) {
    var surcharge_sheetObj=sheetObjects[1];
    switch(sAction) {
            case IBSAVE:
                var checkList=sheetObj.FindCheckedRow('ibcheck');
                if(checkList == ''){
                    ComShowCodeMessage('COM12176');
                    return false;
                }
                var vTrspSoOfcCtyCd = ''; 
                var checkArray=checkList.split('|');
                var frstCnfmChk = false;
                for(var i=0; i<checkArray.length; i++) {
                	if(i == 0) {
                		vTrspSoOfcCtyCd = sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
                	} else {
	                	if(vTrspSoOfcCtyCd != sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd')) {
	                		return false;
	                	}
                	}
                    if(sheetObj.GetCellValue(checkArray[i], 'vndr_seq') == undefined || ComTrim(sheetObj.GetCellValue(checkArray[i], 'vndr_seq')) == ''){
                        ComShowCodeMessage('TRS90099');
                        sheetObj.SelectCell(checkArray[i], 'vndr_seq');
                        return false;
                    }else if(sheetObj.GetCellValue(checkArray[i], 'po_local_curr_cd') == undefined || ComTrim(sheetObj.GetCellValue(checkArray[i], 'po_local_curr_cd')) == ''){
                        ComShowCodeMessage('TRS90228');
                        sheetObj.SelectCell(checkArray[i], 'po_local_curr_cd');
                        return false;
                    } else if(sheetObj.GetCellValue(checkArray[i], 'cancel_check') == '1' && sheetObj.GetCellValue(checkArray[i], 'trsp_frst_flg') == 'Y') {
                    	if(!frstCnfmChk) { // not confirm OK
	                    	if(confirm(ComGetMsg('TRS90231'))) { // confirm OK
	                    		frstCnfmChk = true;
	                    	} else { // confirm NOT OK
	                    		frstCnfmChk = false;
		                        sheetObj.SelectCell(checkArray[i], 'trsp_frst_flg');
		                        return false;
	                    	}
                    	}
                    }else if(sheetObj.GetCellValue(checkArray[i], 'cancel_check') == '1' &&  sheetObj.GetCellValue(checkArray[i], 'trsp_rjct_rsn_cd') == ''){
                        ComShowCodeMessage('TRS90232');
                        sheetObj.SelectCell(checkArray[i], 'trsp_rjct_rsn_cd');
                        return false;
                    }
                }
            break;
            case IBSEARCH_ASYNC01:
                var checkList=sheetObj.FindCheckedRow('ibcheck');
                if(checkList == ''){
                    ComShowCodeMessage('COM12176');
                    return false;
                }
                var checkArray=checkList.split('|');
                var vTrspSoOfcCtyCd = ''; 
                for(var i=0; i<checkArray.length; i++)
                {
                	if(i == 0) {
                		vTrspSoOfcCtyCd = sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
                	} else {
	                	if(vTrspSoOfcCtyCd != sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd')) {
	                		return false;
	                	}
                	}
                	var oTrsSubStsCdVal = sheetObj.GetCellValue(checkArray[i], 'trs_sub_sts_cd');	
                	if(sheetObj.GetCellValue(checkArray[i], 'wo_issued') == 'Y' && !(oTrsSubStsCdVal == 'DF' || ComIsNull(oTrsSubStsCdVal))) {
                		return false;
                	}
                    if(sheetObj.GetCellValue(checkArray[i], 'vndr_seq') == undefined || ComTrim(sheetObj.GetCellValue(checkArray[i], 'vndr_seq')) == ''){
                        ComShowCodeMessage('TRS90099');
                        sheetObj.SelectCell(checkArray[i], 'vndr_seq');
                        return false;
                    }else if(sheetObj.GetCellValue(checkArray[i], 'po_local_curr_cd') == undefined || ComTrim(sheetObj.GetCellValue(checkArray[i], 'po_local_curr_cd')) == ''){
                        ComShowCodeMessage('TRS90228');
                        sheetObj.SelectCell(checkArray[i], 'po_local_curr_cd');
                        return false;
                    } else if(sheetObj.GetCellValue(checkArray[i], 'cancel_check') == '1' && sheetObj.GetCellValue(checkArray[i], 'trsp_frst_flg') == 'Y' && !confirm(ComGetMsg('TRS90231'))) {
                        sheetObj.SelectCell(checkArray[i], 'trsp_frst_flg');
                        return false;
                    }else if(sheetObj.GetCellValue(checkArray[i], 'cancel_check') == '1' &&  sheetObj.GetCellValue(checkArray[i], 'trsp_rjct_rsn_cd') == ''){
                        ComShowCodeMessage('TRS90232');
                        sheetObj.SelectCell(checkArray[i], 'trsp_rjct_rsn_cd');
                        return false;
                    }
                }
            break;            
    }
    return true;
}


// 2014.11.11    Modified by Hyungwook Choi
// Work Order Issued Radio 항목 추가 - No, Yes ===> All, No, Yes
function setWOIssue(selObj) {
    var formObj  = document.form;
    var sheetObj = sheetObjects[0];
    var sheetObj1 = sheetObjects[1];
    if(selObj.name == 'wo_radio') {
        if(formObj.wo_radio[0].checked) {
            if(sheetObj.RowCount() > 0) {
                if(confirm(ComGetMsg('TRS90230'))) {
                    formObj.hid_wo_radio.value = "";
                    sheetObj.RemoveAll();
                    funcSetSumArea(sheetObj);
                    sheetObj1.RemoveAll();
                } else {
                    if(formObj.hid_wo_radio.value == "") {
                        formObj.wo_radio[0].checked = true;
                    } else if(formObj.hid_wo_radio.value == "N") {
                        formObj.wo_radio[1].checked = true;
                    } else if(formObj.hid_wo_radio.value == "Y") {
                        formObj.wo_radio[2].checked = true;
                    }
                    return;
                }
            } else {
                formObj.hid_wo_radio.value = "";
            }
            formObj.wo_iss_sts_cd.disabled = false;
        } else if(formObj.wo_radio[1].checked)  {
            if(sheetObj.RowCount() > 0) {
                if(confirm(ComGetMsg('TRS90230'))) {
                    formObj.hid_wo_radio.value = "N";
                    sheetObj.RemoveAll();
                    funcSetSumArea(sheetObj);
                    sheetObj1.RemoveAll();
                } else  {
                    if(formObj.hid_wo_radio.value == "") {
                        formObj.wo_radio[0].checked = true;
                    } else if(formObj.hid_wo_radio.value == "N") {
                        formObj.wo_radio[1].checked = true;
                    } else if(formObj.hid_wo_radio.value == "Y") {
                        formObj.wo_radio[2].checked = true;
                    }
                    return;
                }
            } else {
                formObj.hid_wo_radio.value = "N";
            }
            formObj.wo_iss_sts_cd.value = "";
            formObj.wo_iss_sts_cd.disabled = true;
        } else if(formObj.wo_radio[2].checked) {
            if(sheetObj.RowCount() > 0) {
                if(confirm(ComGetMsg('TRS90230'))) {
                    formObj.hid_wo_radio.value = "Y";
                    sheetObj.RemoveAll();
                    funcSetSumArea(sheetObj);
                    sheetObj1.RemoveAll();
                } else {
                    if(formObj.hid_wo_radio.value == "") {
                        formObj.wo_radio[0].checked = true;
                    } else if(formObj.hid_wo_radio.value == "N") {
                        formObj.wo_radio[1].checked = true;
                    }
                    else if(formObj.hid_wo_radio.value == "Y") {
                        formObj.wo_radio[2].checked = true;
                    }
                    return;
                }
            } else {
                formObj.hid_wo_radio.value = "Y";
            }
            formObj.wo_iss_sts_cd.disabled = false;
        }
        if(formObj.wo_radio[0].checked && formObj.dt_radio[3].checked) {
            formObj.dt_radio[2].checked = true;
        } else if(formObj.wo_radio[1].checked && formObj.dt_radio[3].checked) {
            formObj.dt_radio[2].checked = true;
        }
    }
    if(selObj.value == 'N')  {
        formObj.dt_radio[3].disabled = true;
        formObj.wo_no.value = '';
        formObj.wo_no.readOnly = true;
    } else {
        formObj.dt_radio[3].disabled = false;
        formObj.wo_no.readOnly = false;
    }
    ComOpenWait(false);
}


function openFmLccPopUp(param1, param2) {
    var dispaly = "0,0";
    var helpFunc;
    if(param1 == 'Y') {
        helpFunc = 'locCodeHelp1';
    } else {
        helpFunc = 'locCodeHelp4';
    }
    ComOpenPopup('/opuscntr/COM_ENS_051.do?main_page=false&scc_flg='+param1+'&title_flg='+param2, 800, 425, helpFunc, dispaly, true);
}

function openToLccPopUp(param1, param2) {
    var dispaly = "0,0";
    var helpFunc;
    if(param1 == 'Y') {
        helpFunc = 'locCodeHelp2';
    } else {
        helpFunc = 'locCodeHelp4';
    }
    ComOpenPopup('/opuscntr/COM_ENS_051.do?main_page=false&scc_flg='+param1+'&title_flg='+param2, 800, 425, helpFunc, dispaly, true);
}

function openEccPopUp(param1, param2) {
    var dispaly = "0,0";
    var helpFunc;
    if(param1 == 'Y') {
        helpFunc = 'locCodeHelp3';
    } else {
        helpFunc = 'locCodeHelp4';
    }
    ComOpenPopup('/opuscntr/COM_ENS_051.do?main_page=false&scc_flg='+param1+'&title_flg='+param2, 800, 425, helpFunc, dispaly, true);
}

// FROM LCC
function locCodeHelp1(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.fm_lcc_cd.value = colArray[8];
}

// TO LCC
function locCodeHelp2(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.to_lcc_cd.value = colArray[8];
}

// ECC
function locCodeHelp3(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.ecc_cd.value = colArray[7];
}

// SCC
function locCodeHelp4(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.scc_cd.value = colArray[6];
}

/**
 * Pop-up call ofc
 */
function ofc_OnPopupClick(val)
{
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
    ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 768, 487, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Pop-up call office code: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_071(rowArray)
{
    var formObject=document.form;
    var colArray=rowArray[0];
    var in_val_2=colArray[3];
    formObject.wo_issue_office.value=in_val_2;
}


/**
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick()
{
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
        ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 640, 530, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1',true);
}

/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray) {
    var formObj=document.form;
    for(var i=0; i<rowArray.length; i++)
    {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[4];
        formObj.combo_svc_provider.value=colArray2;
        formObj.svc_provider.value=colArray3;
    }
}

function getCalendar()
{
    var cal2=new ComCalendarFromTo();
    cal2.displayType="date";
    cal2.select(document.form.fmdate,document.form.todate,'yyyy-MM-dd');
}

function getCalendarSingle()
{
    var cal2=new ComCalendar();
    //cal2.displayType="date";
    cal2.select(document.form.dor_arr_dt, 'yyyy-MM-dd');
}

/**
 * Calling rep_commodity pop-up
 */
function rep_Multiful_inquiry(btn_obj)
{
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var classId="getTRS_ENS_906";
    var xx1=btn_obj;  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var returntitle="";
    switch(btn_obj)
    {
        case "btns_tvvd_no":
            returntitle = "T.VVD";
            break;
        case "btns_fvvd_no":
            returntitle = "F.VVD";
            break;
        case "btns_bkg_no":
            returntitle = "BKG NO";
            break;
        case "btns_bl_no":
            returntitle = "B/L NO";
            break;
        case "btns_eq_no":
            returntitle = "EQ NO";
            break;
        case "btns_so_no":
            returntitle = "SO NO";
            break;
        case "btns_mty_rfrn_no":
            returntitle = "T.VVD";
            break;
        case "btns_dor_pst_cd":
            returntitle = "Zip Code";
            break;
        case "btns_cop_no":
            returntitle = "COP No.";
            break;

        // 2015.02.04    Hyungwook Choi
        case "btns_fm_lcc_cd":
            returntitle = "From-LCC";
            break;
        case "btns_to_lcc_cd":
            returntitle = "To-LCC";
            break;
        case "btns_ecc_cd":
            returntitle = "ECC";
            break;
        case "btns_cntr_slt_no":
            returntitle = "Slot Ref No.";
            break;
    }

    var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+returntitle;
    ComOpenPopup('ESD_TRS_0906.do'+param, 400, 405, "getTRS_ENS_906", "1,0", true);
}

/**
 * Location : The case selecting one item at pop-up page
 */
function getTRS_ENS_906(rowArray, x1)
{
    var obj=eval("document.form."+x1.substring(x1.indexOf("btns_")+5));
    obj.value = rowArray;
    obj.value = obj.value.toUpperCase();
    if(obj.name == "eq_no") {
        checkDigit(obj);
    }
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

/**
 * Defining OnChange Event of sheet
 */
function sheet_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    var formObj = document.form;
    var std = 1;
    var wo_cd_src = '';
    var wo_cd_tgt = '';
    switch(colName) {
        case('ibcheck'): {
        	var oTrsSubStsCdVal = sheetObj.GetCellValue(row, 'trs_sub_sts_cd');	
        	var oWoIssued =  sheetObj.GetCellValue(row, 'wo_issued');
            if(oWoIssued == 'Y' || (oWoIssued == 'N' && oTrsSubStsCdVal == 'DF') ) {
                wo_cd_src = sheetObj.GetCellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.GetCellValue(row, 'trsp_wo_seq');
                for(var i=2; i<sheetObj.RowCount()+2; i++)  {
                    wo_cd_tgt=sheetObj.GetCellValue(i, 'trsp_wo_ofc_cty_cd') + sheetObj.GetCellValue(i, 'trsp_wo_seq');
                    if(wo_cd_src == wo_cd_tgt) {
                    	sheetObj.SetCellValue(i, col, value, 0);
                    }
                }
            } else {
                wo_cd_src=ComTrim(sheetObj.GetCellValue(row, 'trsp_so_cmb_seq'));
                if(wo_cd_src.length > 0){
                    for(var i=2;i<sheetObj.RowCount()+2; i++){
                        wo_cd_tgt=sheetObj.GetCellValue(i, 'trsp_so_cmb_seq');
                        if(wo_cd_src == wo_cd_tgt) sheetObj.SetCellValue(i, col,value,0);
                    }
                }
            }
            funcSetSumArea(sheetObj);
            break;
        }
        case('cancel_check'): {
        	var iCancelCheck = sheetObj.GetCellValue(row, 'cancel_check');
        	var iWoIssued = sheetObj.GetCellValue(row, 'wo_issued');
        	var iWoCdSrc = ComTrim(sheetObj.GetCellValue(row, 'trsp_so_cmb_seq'));
        	var iTrsSubStsCd = sheetObj.GetCellValue(row, 'trs_sub_sts_cd');
        	
        	if(iCancelCheck == 1 && iWoIssued == 'N') {
        		if(iTrsSubStsCd != 'DF') {
        			sheetObj.SetCellValue(row, 'cancel_check', 0, 0);
        			break;
        		}
        	}
            if(iCancelCheck == 1) {
                sheetObj.SetCellValue(row,  'trsp_rjct_rsn_cd','O',0);
            }
            for(var i=2; i < sheetObj.RowCount()+2; i++) {
                wo_cd_tgt=sheetObj.GetCellValue(i, 'trsp_so_cmb_seq');
                if(row==i || (iWoCdSrc != '' && iWoCdSrc == wo_cd_tgt)){
                    if(value == 0 && sheetObj.GetCellValue(i, 'rejected_check')==1){
                        sheetObj.SetCellValue(i,  'rejected_check',value,0);
                    }
                    if(value == 0){
                        sheetObj.SetCellValue(i,  'trsp_rjct_rsn_cd','',0);
                    }
                    sheetObj.SetCellValue(i,  'cancel_check',value,0);
                }
            }
            break;
        }
        case('trsp_rjct_rsn_cd'): {
            if(value != '' && sheetObj.GetCellValue(row, 'cancel_check') == 0){
                sheetObj.SetCellValue(row, 'trsp_rjct_rsn_cd','',0);
                sheetObj.SelectCell(row, 'cancel_check');
                ComShowCodeMessage('TRS90221');
            }else if(value == 'R'){
                sheetObj.SetCellValue(row, 'rejected_check','1',0);
            }else{
                sheetObj.SetCellValue(row, 'rejected_check','0',0);
            }
            if(value == 'B') ComShowCodeMessage('TRS90400');
            break;
        }
        case('po_local_curr_cd'): {
            if(value == 'JPY' || value == 'KRW' || value == 'TWD') {
                setDecimalType(sheetObj, row);
            }else{
                setFloatingType(sheetObj, row);
            }
            searchLocalCurr2UsdCurr(sheetObj, formObj, row);
            break;
        }
        case('nego_amt'): {
            var surcharge_sheetObj = sheetObjects[1];
        	// basic + nego
        	var basic_total = sheetObj.GetCellValue(row, 'po_basic_rt') + sheetObj.GetCellValue(row, 'nego_amt');
        	var fuel_total = 0;
        	// find Fuel & calculate by Ratio or Fixed and summarize
            for(var i=1; i<surcharge_sheetObj.RowCount()+1; i++)  {
            	var so_cd_src = sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd_seq');
                var so_cd_tgt = surcharge_sheetObj.GetCellValue(i, prefix+'trsp_so_ofc_cty_cd') + surcharge_sheetObj.GetCellValue(i, prefix+'trsp_so_seq');
                var lgs_cost_cd = surcharge_sheetObj.GetCellValue(i, prefix+'lgs_cost_cd');
                if(so_cd_src == so_cd_tgt && lgs_cost_cd.substring(0,3) == 'SCF') {
                	if(surcharge_sheetObj.GetCellValue(i, prefix+'fuel_rto') != '' && Number(surcharge_sheetObj.GetCellValue(i, prefix+'fuel_rto')) != 0) {
                		var new_fuel_rto = (basic_total * Number(surcharge_sheetObj.GetCellValue(i, prefix+'fuel_rto')) / 100).toFixed(2);
                		surcharge_sheetObj.SetCellValue(i, prefix+'scg_amt', new_fuel_rto, 0);
                	}
            		fuel_total += surcharge_sheetObj.GetCellValue(i, prefix+'scg_amt');
                }
            }
            // set Fuel surcharge amount
        	sheetObj.SetCellValue(row, "po_fuel_scg_rt", fuel_total, 0);
            
            // set total of US dollar
            searchLocalCurr2UsdCurr(sheetObj, formObj, row);
            valueDuplicate(colName, row, 'on');
            break;
        }
        case('etc_add_amt'): {
            if(value == '' || Number(value) == 0) {
                var surcharge_sheetObj=sheetObjects[1];
                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
                for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--) {
                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
                }
                sheetObj.SetCellValue(row, 'n3pty_bil_flg','');
                if(sheetObj.GetCellValue(row, 'po_local_curr_cd') == 'JPY' || sheetObj.GetCellValue(row, 'po_local_curr_cd') == 'KRW' || sheetObj.GetCellValue(row, 'po_local_curr_cd') == 'TWD')
                {
                    sheetObj.SetCellValue(row, 'etc_add_amt', '0');
                } else {
                    sheetObj.SetCellValue(row, 'etc_add_amt', '0.00');
                }
            } else {
                var surcharge_sheetObj=sheetObjects[1];
                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
                var sum=0;
                for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--) {
                	// 2015.06.10	CHAN WOO PARK
                    // 비교 시 Fuel Scg는 제외
                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd && surcharge_sheetObj.GetCellValue(a, prefix+'lgs_cost_cd').substring(2, 4) != "FU")
                        sum += Number(surcharge_sheetObj.GetCellValue(a, prefix+'scg_amt'));
                }
                if(sum != Number(deleteComma(value))){
                    ComShowCodeMessage('COM12114', 'Additional Etc Amount');
                    sheetObj.SetCellValue(row, 'etc_add_amt',0,0);
                    for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--) {
                        if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
                    }
                }
            }
            searchLocalCurr2UsdCurr(sheetObj, formObj, row);
            break;
        }
        case('n3pty_bil_flg'): {
            if(value== ''){
                var surcharge_sheetObj=sheetObjects[1];
                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
                for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
                {
                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd){
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_bil_flg','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'cust_cnt_cd','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'cust_cnt_cd','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_vndr_seq','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_ofc_cd','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_amt','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_desc','',0);
                    }
                }
            }
            break;
        }
        case 'kgs_net_wgt' : {
        	var chgWghValue = 0;
        	var wgtMeasUtCd = sheetObj.GetCellValue(row, 'wgt_meas_ut_cd');
            if(value != ''){
            	chgWghValue = fnNetWeightChange(formObj, 'LBS', value);
            	sheetObj.SetCellValue(row, 'lbs_net_wgt', chgWghValue, 0);
            } else {
            	sheetObj.SetCellValue(row, col, 0, 0);
            	sheetObj.SetCellValue(row, 'lbs_net_wgt', 0, 0);
            }            
            if(wgtMeasUtCd == 'KGS') {
        		sheetObj.SetCellValue(row, 'cntr_wgt', value, 0);
        	} else {
        		sheetObj.SetCellValue(row, 'cntr_wgt', chgWghValue, 0);
        	}
//            $('#sum_ttlwgtkgs').val(TrsComGetCurrFormat(sheetObj.ComputeSum("|kgs_gross_wgt|"), 3));
//            $('#sum_ttlwgtlbs').val(TrsComGetCurrFormat(sheetObj.ComputeSum("|lbs_gross_wgt|"), 3));
            funcSetSumArea(sheetObj);        
            break;
        }
        case 'lbs_net_wgt' : {
        	var chgWghValue = 0;
        	var wgtMeasUtCd = sheetObj.GetCellValue(row, 'wgt_meas_ut_cd');
            if(value != ''){
            	chgWghValue = fnNetWeightChange(formObj, 'KGS', value);
            	sheetObj.SetCellValue(row, 'kgs_net_wgt', chgWghValue, 0);
            } else {
            	sheetObj.SetCellValue(row, col, 0, 0);
            	sheetObj.SetCellValue(row, 'kgs_net_wgt', 0, 0);
            }
            if(wgtMeasUtCd == 'LBS') {
        		sheetObj.SetCellValue(row, 'cntr_wgt', value, 0);
        	} else {
        		sheetObj.SetCellValue(row, 'cntr_wgt', chgWghValue, 0);
        	}
//          $('#sum_ttlwgtkgs').val(TrsComGetCurrFormat(sheetObj.ComputeSum("|kgs_gross_wgt|"), 3));
//          $('#sum_ttlwgtlbs').val(TrsComGetCurrFormat(sheetObj.ComputeSum("|lbs_gross_wgt|"), 3));
            funcSetSumArea(sheetObj);
            break;
        }
            }
        }

var arrIncludeEqTpSz = ["D2,D4,D5,D7,R2,R4,R5,F2,F4,F5,O2,O4,A2,A4,S2,S4"];

/**
 * Total Area - Data Setting
 * @param sheetobj
 */
function funcSetSumArea(sheetobj) {
	var ttlwgtkgs = 0.00;
	var ttlwgtlbs = 0.00;
	var ttlteu = 0;
	var ttlfeu = 0;
	var ttlbox = 0;
	var hashObject = {};
	var checkList=sheetobj.FindCheckedRow('ibcheck');
	if(checkList != '') {
		var eqTpszCd = "";
		var checkRows = checkList.split('|');
		for(var i = 0; i < checkRows.length; i++) {
			eqTpszCd = sheetobj.GetCellValue(checkRows[i], "eq_tpsz_cd");
			if(arrIncludeEqTpSz != null && arrIncludeEqTpSz != undefined) {
				if(arrIncludeEqTpSz.toString().indexOf(eqTpszCd) > -1 ) {
					ttlwgtkgs += parseFloat(sheetobj.GetCellValue(checkRows[i], "kgs_gross_wgt"));
					ttlwgtlbs += parseFloat(sheetobj.GetCellValue(checkRows[i], "lbs_gross_wgt"));
				}
				if(eqTpszCd.substring(1, 2) == "2") {
					ttlteu++;
				} else {
					ttlfeu++;
				}
				if(hashObject[eqTpszCd] != undefined) {
					hashObject[eqTpszCd] += 1;
				} else {
					hashObject[eqTpszCd] = 1;
				}
			} else {
				ttlwgtkgs += parseFloat(sheetobj.GetCellValue(checkRows[i], "kgs_gross_wgt"));
				ttlwgtlbs += parseFloat(sheetobj.GetCellValue(checkRows[i], "lbs_gross_wgt"));
				if(eqTpszCd.substring(1, 2) == "2") {
					ttlteu++;
				} else {
					ttlfeu++;
				}
				if(hashObject[eqTpszCd] != undefined) {
					hashObject[eqTpszCd] += 1;
				} else {
					hashObject[eqTpszCd] = 1;
				}
			}
		}
	}
	$("#ttl_layer input:text").each(function(index) {
		$(this).val(0);
	});
	$.each(hashObject, function(key, value) {
		$("#sum_" + key.toLowerCase()).val(value);
	})
	$('#sum_ttlwgtkgs').val(TrsComGetCurrFormat(ttlwgtkgs, 3));
	$('#sum_ttlwgtlbs').val(TrsComGetCurrFormat(ttlwgtlbs, 3));    
	$('#sum_ttlteu').val(ttlteu);    
	$('#sum_ttlfeu').val(ttlfeu);    
	$('#sum_ttlbox').val(ttlteu+ttlfeu);    
}

/**
 * 
 * @param orgUnit
 * @param destUnit
 * @param value
 */
function fnNetWeightChange(formObj, wgtMeasUtCd, cntrWgt) {
	var sheetObj = sheetObjects[3];
    formObj.f_cmd.value=SEARCH06;
    var queryString='wgt_meas_ut_cd='+ wgtMeasUtCd+ '&cntr_wgt='+cntrWgt + "&" +TrsFrmQryString(formObj);
    var sXml = sheetObj.GetSearchData("ESD_TRS_0999GS.do",queryString);
    return ComGetEtcData(sXml,'cntr_wgt');
}


/**
 * Currenct : Local -> USD
 * @param sheetObj
 * @param formObj
 * @param row
 */
function searchLocalCurr2UsdCurr(sheetObj, formObj, row){
	var sheet4 = sheetObjects[3];
    if(sheetObj.GetCellValue(row, 'po_local_curr_cd') == '') return;
    var basicRt   = parseFloat(Number(sheetObj.GetCellValue(row, 'po_basic_rt')));
    var fuelScgRt = parseFloat(Number(sheetObj.GetCellValue(row, 'po_fuel_scg_rt')));
    var negoAmt   = parseFloat(Number(sheetObj.GetCellValue(row, 'nego_amt')));
    var etcAddAmt = parseFloat(Number(sheetObj.GetCellValue(row, 'etc_add_amt')));
    var currency = sheetObj.GetCellValue(row, 'po_local_curr_cd');
    var total = basicRt + fuelScgRt + negoAmt + etcAddAmt;
    if(total > 0 && currency != "" && currency != "USD") {
    	var url='LOCAL_TOT_AMT='+ (basicRt + fuelScgRt + negoAmt + etcAddAmt) + '&CURR_CD='+ currency ;
        formObj.f_cmd.value=SEARCH03;
        sheet4.RemoveEtcData();
        repalceDateField(formObj);
        sheet4.DoSearch("ESD_TRS_0023GS.do", url+'&'+TrsFrmQryString(formObj),{Sync:2, Append:true} );
        if(sheet4.GetEtcData('amt_usd') != undefined && sheet4.GetEtcData('amt_usd') != ''){
        	sheetObj.SetCellValue(row, 'po_usd_curr_tot_amt',sheet4.GetEtcData('amt_usd'), 0);
        }
    } else {
    	if(currency == 'USD' && total > 0) {
    		sheetObj.SetCellValue(row, 'po_usd_curr_tot_amt', total, 0);
    	}
    	if(total == 0) {
    		sheetObj.SetCellValue(row, 'po_usd_curr_tot_amt', total, 0);
    	}
    }
}

/**
 * Duplicate Check
 * @param col
 * @param row
 * @param action
 */
function valueDuplicate(col, row, action){
    var formObj2=document.negoForm;
    var nego_sheetObj=sheetObjects[0];        
    var nego_amt=formObj2.nego_amt.value;
    var insert_nego=nego_sheetObj.GetCellValue(row,col);
    if(action == 'db') {        
    	nego_sheetObj.SetCellValue(row,col,nego_amt);
    } else if(action == 'on'){    
        formObj2.nego_amt.value=nego_sheetObj.GetCellValue(row,col);
    }    
}

/**
 * Resetting the searching option
 */
function setDecimalType(sheetObj, row){
    sheetObj.InitCellProperty(row, 'po_basic_rt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'po_fuel_scg_rt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'po_local_curr_tot_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.SetCellValue(row, 'po_basic_rt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'po_basic_rt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'po_fuel_scg_rt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'po_fuel_scg_rt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'po_local_curr_tot_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'po_local_curr_tot_amt')),0);
    var surcharge_sheetObj=sheetObjects[1];
    var sur_key=sheetObj.GetCellValue(row, 'surcharge_key');
    for(var i=1; i<surcharge_sheetObj.RowCount()+1; i++){
        if(sur_key == surcharge_sheetObj.GetCellValue(i, prefix+'unique_cd')){
            surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
            surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
            surcharge_sheetObj.SetCellValue(i, prefix+'scg_amt',chkAmtPos_JPY(surcharge_sheetObj.GetCellValue(i, prefix+'scg_amt')),0);
            surcharge_sheetObj.SetCellValue(i, prefix+'n3pty_amt',chkAmtPos_JPY(surcharge_sheetObj.GetCellValue(i, prefix+'n3pty_amt')),0);
        }
    }
}

/**
 * Resetting the searching option
 */
function setFloatingType(sheetObj, row)
{
    sheetObj.InitCellProperty(row, 'po_basic_rt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'po_fuel_scg_rt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'po_local_curr_tot_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.SetCellValue(row, 'po_basic_rt',chkAmtPos(sheetObj.GetCellValue(row, 'po_basic_rt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'po_fuel_scg_rt',chkAmtPos(sheetObj.GetCellValue(row, 'po_fuel_scg_rt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'po_local_curr_tot_amt',chkAmtPos(sheetObj.GetCellValue(row, 'po_local_curr_tot_amt')),0);
    var surcharge_sheetObj=sheetObjects[1];
    var sur_key=sheetObj.GetCellValue(row, 'surcharge_key');
    
    for(var i=1; i<surcharge_sheetObj.RowCount()+1; i++)
    {
        if(sur_key == surcharge_sheetObj.GetCellValue(i, prefix+'unique_cd'))
        {
            surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
            surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
            surcharge_sheetObj.SetCellValue(i, prefix+'scg_amt',chkAmtPos(surcharge_sheetObj.GetCellValue(i, prefix+'scg_amt')),0);
            surcharge_sheetObj.SetCellValue(i, prefix+'n3pty_amt',chkAmtPos(surcharge_sheetObj.GetCellValue(i, prefix+'n3pty_amt')),0);
        }
    }
}

/**
 * Resetting the searching option
 */
function resetSearchCondition(formObj) {
    formObj.dt_radio[2].checked=true;
    formObj.fmdate.value='';
    formObj.todate.value='';
    formObj.combo_svc_provider.value='';
    formObj.svc_provider.value='';
    formObj.wo_no.value='';
    formObj.trs_cost_md_cd.options[0].selected=true;
    formObj.trs_md_cd.options[0].selected=true;
    formObj.trs_bnd_cd.options[0].selected=true;
    
    formObj.temp_cgo_tp_cd.value='';
    formObj.temp_eq_tpsz_cd.value='';
    formObj.temp_spcl_cgo_cntr_tp_cd.value='';
    
    // uncheck all items of all IBMultiCombo
    for (var k=0; k < comboObjects.length; k++) {
		comboObjects[k].SetSelectCode(-1, false);
    }
    
    search_fm_yard.RemoveAll();
    search_to_yard.RemoveAll();
    search_via_yard.RemoveAll();
    search_door_yard.RemoveAll();
}

/*
* /
/**
 * Move to Work Order Preview
 */
function gotoPreview(sheetObj,formOb) {
    var cty_cd='';
    var seq_no='';
    var cancel_check='';
    var dtn_use_flg='';
    var wo_bl_no_iss_flg='';
    var vndr_seq='';
    var po_local_curr_cd='';
    var po_basic_rt='';
    var nego_amt='';
    var etc_add_amt='';
    var po_fuel_scg_rt='';
    var n3pty_bil_flg='';
    var po_usd_curr_tot_amt='';
    var scg_grp_se='';     
    var cust_cnt_cd='';    
    var cust_seq='';      
    var cust_nomi_trkr_flg='';
    var trsp_agmt_rt_tp_cd='';
    var trsp_agmt_wy_tp_cd='';
    var trsp_frst_flg='';
    var trsp_rjct_rsn_cd='';
    var trsp_dflt_vndr_flg='';
    var n1st_nod_pln_dt='';
    var lst_nod_pln_dt='';
    var dor_nod_pln_dt='';
    var inter_rmk='';
    var spcl_instr_rmk='';
    var FORM_FCTRY_NM='';
    var FORM_DOR_PST_CD='';
    var FORM_CNTC_PSON_PHN_NO='';
    var FORM_CNTC_PSON_FAX_NO='';
    var FORM_CNTC_PSON_NM='';
    var N3PTY_CUST_CNT_CD='';
    var N3PTY_CUST_SEQ='';
    var N3PTY_DESC='';
    var N3PTY_VNDR_SEQ='';
    var N3PTY_OFC_CD='';
    var N3PTY_BIL_BZC_AMT='';
    var N3PTY_BIL_TP_CD='';
    var N3PTY_CURR_CD='';
    var inTrspAgmtOfcCtyCd = '';
    var inTrspAgmtSeq = '';
    var wgtMeasUtCd = "";
    var inLbsNetWgt = "";
    var inKgsNetWgt = "";
    var inCntrPkupNo = "";
    var scg_ind_cd = "";
    
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    if(checkList == '') {
        ComShowCodeMessage('COM12176');
        return false;
    }
    var checkArray=checkList.split('|');
    for(var i=0; i < checkArray.length; i++) {
        if(i != 0) {
            cty_cd                += ',';
            seq_no                += ',';
            cancel_check          += ',';
            dtn_use_flg           += ','; 
            wo_bl_no_iss_flg      += ',';
            vndr_seq              += ',';
            po_local_curr_cd      += ',';
            po_basic_rt           += ',';
            nego_amt              += ',';
            etc_add_amt           += ',';
            po_fuel_scg_rt        += ',';
            n3pty_bil_flg         += ',';
            po_usd_curr_tot_amt   += ',';
            cust_cnt_cd           += ',';  
            cust_seq              += ',';     
            cust_nomi_trkr_flg    += ',';
            trsp_agmt_rt_tp_cd    += ',';
            trsp_agmt_wy_tp_cd    += ',';
            trsp_frst_flg         += ',';
            trsp_rjct_rsn_cd      += ',';
            trsp_dflt_vndr_flg    += ',';
            n1st_nod_pln_dt       += ',';
            lst_nod_pln_dt        += ',';
            dor_nod_pln_dt        += ',';
            inter_rmk             += ',';
            spcl_instr_rmk        += ',';
            FORM_FCTRY_NM         += ',';
            FORM_DOR_PST_CD       += ',';
            FORM_CNTC_PSON_PHN_NO += ',';
            FORM_CNTC_PSON_FAX_NO += ',';
            FORM_CNTC_PSON_NM     += ',';
            N3PTY_CUST_CNT_CD     += ',';
            N3PTY_CUST_SEQ        += ',';
            N3PTY_DESC            += ',';
            N3PTY_VNDR_SEQ        += ',';
            N3PTY_OFC_CD          += ',';
            N3PTY_BIL_BZC_AMT     += ',';
            N3PTY_BIL_TP_CD       += ',';
            N3PTY_CURR_CD         += ',';
            inTrspAgmtOfcCtyCd    += ',';
            inTrspAgmtSeq         += ',';
            wgtMeasUtCd           += ',';
            inKgsNetWgt           += ',';
            inLbsNetWgt           += ',';
            inCntrPkupNo          += ',';
            scg_ind_cd            += ',';
            
        }
        cty_cd                += sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
        seq_no                += sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq');
        cancel_check          += sheetObj.GetCellValue(checkArray[i], 'cancel_check');
        dtn_use_flg           += sheetObj.GetCellValue(checkArray[i], 'dtn_use_flg');
        wo_bl_no_iss_flg      += sheetObj.GetCellValue(checkArray[i], 'wo_bl_no_iss_flg');
        vndr_seq              += sheetObj.GetCellValue(checkArray[i], 'vndr_seq');
        po_local_curr_cd      += getSpace(sheetObj.GetCellValue(checkArray[i], 'po_local_curr_cd'));
        po_basic_rt           += sheetObj.GetCellValue(checkArray[i], 'po_basic_rt').toString();
        nego_amt              += sheetObj.GetCellValue(checkArray[i], 'nego_amt').toString();
        etc_add_amt           += sheetObj.GetCellValue(checkArray[i], 'etc_add_amt').toString();;
        po_fuel_scg_rt        += sheetObj.GetCellValue(checkArray[i], 'po_fuel_scg_rt').toString();;
        n3pty_bil_flg         += (sheetObj.GetCellValue(checkArray[i], 'n3pty_bil_flg')=='Y'?'Y':'N');
        po_usd_curr_tot_amt   += sheetObj.GetCellValue(checkArray[i], 'po_usd_curr_tot_amt').toString();;
        cust_cnt_cd           += getSpace(sheetObj.GetCellValue(checkArray[i], 'po_cust_cnt_cd'));
        cust_seq              += getSpace(sheetObj.GetCellValue(checkArray[i], 'po_cust_seq'));
        cust_nomi_trkr_flg    += (sheetObj.GetCellValue(checkArray[i], 'po_cust_nomi_trkr_flg')=='Y'?'Y':'N');
        trsp_agmt_rt_tp_cd    += getSpace(sheetObj.GetCellValue(checkArray[i], 'po_trsp_agmt_rt_tp_cd'));
        trsp_agmt_wy_tp_cd    += getSpace(sheetObj.GetCellValue(checkArray[i], 'po_way_type'));
        trsp_frst_flg         += (sheetObj.GetCellValue(checkArray[i], 'trsp_frst_flg')=='Y'?'Y':'N');
        trsp_rjct_rsn_cd      += getSpace(sheetObj.GetCellValue(checkArray[i], 'trsp_rjct_rsn_cd'));
        trsp_dflt_vndr_flg    += (sheetObj.GetCellValue(checkArray[i], 'trsp_dflt_vndr_flg')=='Y'?'Y':'N');
        n1st_nod_pln_dt       += getSpace(sheetObj.GetCellValue(checkArray[i], 'n1st_nod_pln_dt'));
        lst_nod_pln_dt        += getSpace(sheetObj.GetCellValue(checkArray[i], 'lst_nod_pln_dt'));
        dor_nod_pln_dt        += getSpace(sheetObj.GetCellValue(checkArray[i], 'dor_nod_pln_dt'));
        inter_rmk             += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'inter_rmk')));
        spcl_instr_rmk        += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'spcl_instr_rmk')));
        FORM_FCTRY_NM         += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'fctry_nm')));
        FORM_DOR_PST_CD       += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'dor_pst_cd')));
        FORM_CNTC_PSON_PHN_NO += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'cntc_pson_phn_no')));
        FORM_CNTC_PSON_FAX_NO += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'cntc_pson_fax_no')));
        FORM_CNTC_PSON_NM     += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'cntc_pson_nm')));
        N3PTY_CUST_CNT_CD     += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_cust_cnt_cd')));
        N3PTY_CUST_SEQ        += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_cust_seq')));
        N3PTY_DESC            += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_desc')));
        N3PTY_VNDR_SEQ        += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_vndr_seq')));
        N3PTY_OFC_CD          += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_ofc_cd')));
        N3PTY_BIL_BZC_AMT     += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_amt'))).toString();
        N3PTY_BIL_TP_CD       += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_tp_cd')));
        N3PTY_CURR_CD         += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'n3pty_bzc_curr_cd')));
        inTrspAgmtOfcCtyCd    += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'po_trsp_agmt_ofc_cty_cd')));
        inTrspAgmtSeq         += getSpaceCode(toHtml(sheetObj.GetCellValue(checkArray[i], 'po_trsp_agmt_seq')));
        wgtMeasUtCd        	  += sheetObj.GetCellValue(checkArray[i], 'wgt_meas_ut_cd').toString();
        inLbsNetWgt        	  += sheetObj.GetCellValue(checkArray[i], 'lbs_net_wgt').toString();
        inKgsNetWgt        	  += sheetObj.GetCellValue(checkArray[i], 'kgs_net_wgt').toString();
        inCntrPkupNo          += getSpace(sheetObj.GetCellValue(checkArray[i], 'cntr_pkup_no'));
        scg_ind_cd            += getSpace(sheetObj.GetCellValue(checkArray[i], 'scg_ind_cd'));

    }
    
    if(checkArray.length > 1) {
        for(var i=0; i < checkArray.length - 1; i++) {
        	var oTrsSubStsCdVal = sheetObj.GetCellValue(checkArray[i], 'trs_sub_sts_cd');	
        	var nTrsSubStsCdVal = sheetObj.GetCellValue(checkArray[i+1], 'trs_sub_sts_cd')
        	var oWoIssued =  sheetObj.GetCellValue(checkArray[i], 'wo_issued');
        	var nWoIssued =  sheetObj.GetCellValue(checkArray[i+1], 'wo_issued')
        	
        	// Issue Yes / No Check
            if(oWoIssued != nWoIssued) {
                ComShowCodeMessage('TRS90436');
                return false;
            }
        	// Issue No  ->   Trs Sub Stratus 비교 (Draft , Non Draft)
            if(oWoIssued == 'N' && oTrsSubStsCdVal != nTrsSubStsCdVal) {
            	ComShowCodeMessage('TRS90437');
                return false;
            }
        }
    }
    if(sheetObj.GetCellValue(checkArray[0], 'trs_sub_sts_cd') == 'DF') {
    	document.woForm.issued.value = 'Y';
    } else {
    	document.woForm.issued.value = sheetObj.GetCellValue(checkArray[0], 'wo_issued');
    }
    document.woForm.pgmNo.value='ESD_TRS_0024';
    document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
    document.woForm.trsp_so_seq.value=seq_no;
    document.woForm.wo_cancel_flag.value=cancel_check;
    document.woForm.dtn_use_flg.value=dtn_use_flg;
    document.woForm.wo_bl_no_iss_flg.value=wo_bl_no_iss_flg;
    document.woForm.vndr_seq.value=vndr_seq;
    document.woForm.po_local_curr_cd.value=po_local_curr_cd;
    document.woForm.po_basic_rt.value=po_basic_rt;
    document.woForm.nego_amt.value=nego_amt;
    document.woForm.etc_add_amt.value=etc_add_amt;
    document.woForm.po_fuel_scg_rt.value=po_fuel_scg_rt;
    document.woForm.n3pty_bil_flg.value=n3pty_bil_flg;
    document.woForm.po_usd_curr_tot_amt.value=po_usd_curr_tot_amt;
    document.woForm.cust_cnt_cd.value=cust_cnt_cd;
    document.woForm.cust_seq.value=cust_seq;
    document.woForm.cust_nomi_trkr_flg.value=cust_nomi_trkr_flg;
    document.woForm.trsp_agmt_rt_tp_cd.value=trsp_agmt_rt_tp_cd;
    document.woForm.trsp_agmt_wy_tp_cd.value=trsp_agmt_wy_tp_cd;
    
    document.woForm.trsp_frst_flg.value=trsp_frst_flg;
    document.woForm.trsp_rjct_rsn_cd.value=trsp_rjct_rsn_cd;
    document.woForm.trsp_dflt_vndr_flg.value=trsp_dflt_vndr_flg;
    
    document.woForm.n1st_nod_pln_dt.value=n1st_nod_pln_dt;
    document.woForm.lst_nod_pln_dt.value=lst_nod_pln_dt;
    document.woForm.dor_nod_pln_dt.value=dor_nod_pln_dt;
    document.woForm.inter_rmk.value=inter_rmk;
    document.woForm.spcl_instr_rmk.value=spcl_instr_rmk;
    
    document.woForm.form_fctry_nm.value=FORM_FCTRY_NM;
    document.woForm.form_dor_pst_cd.value=FORM_DOR_PST_CD;
    document.woForm.form_cntc_pson_phn_no.value=FORM_CNTC_PSON_PHN_NO;
    document.woForm.form_cntc_pson_fax_no.value=FORM_CNTC_PSON_FAX_NO;
    document.woForm.form_cntc_pson_nm.value=FORM_CNTC_PSON_NM;
    
    document.woForm.n3pty_cust_cnt_cd.value=N3PTY_CUST_CNT_CD;
    document.woForm.n3pty_cust_seq.value=N3PTY_CUST_SEQ;
    document.woForm.n3pty_desc.value=N3PTY_DESC;
    document.woForm.n3pty_vndr_seq.value=N3PTY_VNDR_SEQ;
    document.woForm.n3pty_ofc_cd.value=N3PTY_OFC_CD;
    document.woForm.n3pty_bil_bzc_amt.value=N3PTY_BIL_BZC_AMT;
    document.woForm.n3pty_bil_tp_cd.value=N3PTY_BIL_TP_CD;
    document.woForm.n3pty_curr_cd.value=N3PTY_CURR_CD;
    
    document.woForm.trsp_agmt_ofc_cty_cd.value = inTrspAgmtOfcCtyCd;
    document.woForm.trsp_agmt_seq.value = inTrspAgmtSeq;
    
    document.woForm.wgt_meas_ut_cd.value = wgtMeasUtCd;
    document.woForm.cntr_kgs_wgt.value = inKgsNetWgt;
    document.woForm.cntr_lbs_wgt.value = inLbsNetWgt;
    document.woForm.cntr_pkup_no.value = inCntrPkupNo;
    document.woForm.scg_ind_cd.value = scg_ind_cd;
    
    document.woForm.draft_flg.value = document.form.p_draft_flg.value;
    var myWin=window.open("about:blank", "gotoPreview", "width=1060,height=680,menubar=0,status=0,scrollbars=yes,resizable=1");
    previewPopObject.push(myWin);
    document.woForm.target="gotoPreview";
    document.woForm.action='ESD_TRS_0024.screen';
    document.woForm.submit();       
    myWin.focus();  
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col, mode, step_cd)
{
    var checkList=null;
    var checkArray=null;

    if(mode == 'multiple'){
        checkList=sheetObj.FindCheckedRow('ibcheck');
        checkArray=checkList.split('|');
        if( checkArray == '') {
            ComShowCodeMessage('TRS90036');
            return false;
        } else {
            row= checkArray[0];
        }
    }
    var formObject = document.form;
    formObject.f_cmd.value = "";
    var formObj=document.scgForm;
    formObj.unique_cd.value=sheetObj.GetCellValue(row, 'surcharge_key');
    formObj.open_mode.value=mode;
    formObj.step_cd.value=step_cd;
    formObj.main_row.value=row;
    formObj.sheet_arr_no.value='1';
    formObj.ofc_cty_cd.value=sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
    formObj.so_seq.value=sheetObj.GetCellValue(row, 'trsp_so_seq');
    formObj.curr_cd.value=sheetObj.GetCellValue(row, 'po_local_curr_cd');

    // 2014.12.11    Hyungwook Choi
    formObj.vndr_seq.value             = sheetObj.GetCellValue(row, 'vndr_seq');
    formObj.trsp_crr_mod_cd.value      = sheetObj.GetCellValue(row, 'trsp_crr_mod_cd');
    formObj.trsp_cost_dtl_mod_cd.value = sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd');
    formObj.cgo_tp_cd.value            = sheetObj.GetCellValue(row, 'cgo_tp_cd');
    formObj.trsp_bnd_cd.value          = sheetObj.GetCellValue(row, 'trsp_bnd_cd');
    formObj.fm_nod_cd.value            = sheetObj.GetCellValue(row, 'fm_nod_cd');
    formObj.via_nod_cd.value           = sheetObj.GetCellValue(row, 'via_nod_cd');
    formObj.dor_nod_cd.value           = sheetObj.GetCellValue(row, 'dor_nod_cd');
    formObj.to_nod_cd.value            = sheetObj.GetCellValue(row, 'to_nod_cd');
    formObj.cre_dt.value               = sheetObj.GetCellValue(row, 'cre_dt');
    formObj.eq_knd_cd.value            = sheetObj.GetCellValue(row, 'eq_knd_cd');
    formObj.eq_tpsz_cd.value           = sheetObj.GetCellValue(row, 'eq_tpsz_cd');
    formObj.po_fuel_scg_rt.value       = sheetObj.GetCellValue(row, 'po_fuel_scg_rt');

    if(mode == 'modify') {
    	formObj.scg_ind_cd.value = 'S';
    } else {
    	formObj.scg_ind_cd.value = 'M';
    }
    

    formObj.action='ESD_TRS_0918.screen';
    formObj.target='popSurchargeInputInquiry';
    if(mode == 'multiple'){
        formObj.multi_ofc_cty_cd.value=getSoOfcCdArray(sheetObj, checkArray);
        formObj.multi_so_seq.value=getSoSeqArray(sheetObj, checkArray);
        formObj.multi_cgo_tp_cd.value=getCgoTpCdArray(sheetObj, checkArray);
        formObj.check_row.value=getRowArray(sheetObj, checkArray);
    }
    var url = "ESD_TRS_0918.screen?" + $('#scgForm').serialize();
    ComOpenPopup(url, 950, 800, "ESD_TRS_0918", "1,0,1,1,1,1,1", true);
}

function getSoOfcCdArray(sheetObj, checkArray)
{
    var returnStr='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        returnStr += sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
    }
    return returnStr;
}

function getSoSeqArray(sheetObj, checkArray)
{
    var returnStr='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        returnStr += sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq');
    }
    return returnStr;
}

function getCgoTpCdArray(sheetObj, checkArray){
    var returnStr='';
    var cgo_tp_cd='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        cgo_tp_cd=sheetObj.GetCellValue(checkArray[i], 'cgo_tp_cd');
        if (cgo_tp_cd == 'F') cgo_tp_cd='C';
        else cgo_tp_cd='M';
        returnStr += cgo_tp_cd
    }
    return returnStr;
}

function getRowArray(sheetObj, checkArray){
    var returnStr='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        returnStr += checkArray[i];
    }
    return returnStr;
}

/**
 * Surcharge Input Inquiry popup
 **/
function pop3rdPartyBilling(sheetObj, row, col, mode)
{
    var myOption="width=815,height=580,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0954.screen';
    url += '?unique_cd='+sheetObj.GetCellValue(row, 'trsp_so_seq');
    url += '&open_mode='+mode;
    url += '&step_cd=WO';
    url += '&main_row='+row;
    url += '&trsp_so_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
    url += '&trsp_so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq');
    url += '&sheet_arr_no=1';
    url += '&bkg_no='+sheetObj.GetCellValue(row, 'bkg_no');
    url += '&eq_no='+sheetObj.GetCellValue(row, 'eq_no');
    url += '&wo_no='+sheetObj.GetCellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.GetCellValue(row, 'trsp_wo_seq');
    url += '&curr_cd='+sheetObj.GetCellValue(row, 'po_local_curr_cd');
    
    ComOpenPopup(url, 1000, 540, "pop3rdPartyBilling", "1,0,1,1,1,1,1", true);
}

/**
 * Getting data from MoreCandidate popup
 **/
function setMoreCandidate(winObj)
{
  ComClosePopup(); 
}

/**
 * Removing NULL value
 **/
function getSpace(src)
{
    if (src == undefined || src == '') return ' ';
    return src;
}

/**
 * Removing NULL value
 **/
function getSpaceCode(src) {
    if (src == undefined || src == '') return '@null;';
    return src;
}

/**
 * Frustrate Flag
 **/
function setFrustrate(sheetObj) {
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if (checkList == '') {
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');
	for ( var i = 0; i < checkArray.length; i++) {
		if (sheetObj.GetCellValue(checkArray[i], 'wo_issued') == 'N' && sheetObj.GetCellValue(checkArray[i], 'trs_sub_sts_cd') != 'DF') {
		ComShowCodeMessage('TRS90311');
		return false;
			 }
	
		if (sheetObj.GetCellValue(checkArray[i], 'trsp_so_tp_cd') != 'Y') {
	        ComShowCodeMessage('TRS90310');
	        return false;
	    }
		
		if(sheetObj.GetCellValue(checkArray[i], 'trsp_frst_flg') == 'Y'){
	        ComShowCodeMessage('TRS90491');
	    	return false;
	    }
	
		if (sheetObj.GetCellValue(checkArray[i], "cng_ind_flg") == 'Y' || sheetObj.GetCellValue(checkArray[i], "vndr_cm") == 'Y') {
			ComShowCodeMessage('TRS90443');
			return false;
			 }
		}	    
	if (ComShowCodeConfirm('TRS90456')) {
	    document.form.f_cmd.value=MULTI01;
		sheetObj.DoSave("ESD_TRS_0023GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
	}
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSpselect(sheetObj) {
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var iCngIndFlg = 'N';
    var iVndrCm = 'N';
    
    if(checkList == '') {
        ComShowCodeMessage('COM12176');
        return false;
    }
    for(var i=0; i<checkArray.length; i++) {
        iCngIndFlg = sheetObj.GetCellValue( checkArray[i] , "cng_ind_flg");
        iVndrCm = sheetObj.GetCellValue( checkArray[i] , "vndr_cm");
        if(iCngIndFlg == 'Y' || iVndrCm == 'Y') {
        	ComShowCodeMessage('TRS90443');
        	return false;    
        }
        if(sheetObj.GetCellValue(checkArray[i], 'trsp_so_tp_cd') == 'S'){
        	ComShowCodeMessage('TRS90458');
        	return false;
        }
    }

    if(checkArray.length > 1) {
        for(var i=0; i < checkArray.length - 1; i++) {
            if(sheetObj.GetCellValue(checkArray[i], 'wo_issued') != sheetObj.GetCellValue(checkArray[i+1], 'wo_issued')) {
                ComShowCodeMessage('TRS90436');
                return false;
            }
        }
    }
    var radio = sheetObj.GetCellValue(checkArray[0], 'wo_issued');
    if(radio == "Y") {
        ComShowCodeMessage('TRS90136');
        return false;
    }

    var checkList=null;
    var checkArray=null;
    checkList=sheetObj.FindCheckedRow('ibcheck');
    checkArray=checkList.split('|');
    if(checkArray == '') {
        ComShowCodeMessage('TRS90036');
        return false;
    } else {
        row=checkArray[0];
    }
    var myOption="width=750,height=193,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0961.screen';
    url += '?wo_radio='+radio;
    url += '&cust_cnt_cd_seq='+sheetObj.GetCellValue(row, 'cust_cnt_cd_seq');
    ComOpenPopup(url, 800, 300, "ESD_TRS_0961", '1,0,1,1,1,1,1,1,1,1,1,1',true);   
}

/**
 * enter check
 **/
function enterCheck(obj) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(event.keyCode == 13) {
        switch(ComGetEvent("name")) {
            case 'combo_svc_provider': {
                getTextVendorSeq(sheetObj, formObj, obj.value);
                break;
            }
            case 'search_fm_loc':
            case 'search_via_loc':
            case 'search_to_loc':
            case 'search_door_loc': {
                getComboList(obj);
                break;
            }
            case 'tvvd_no':
            case 'fvvd_no':
            case 'bkg_no':
            case 'bl_no':
            case 'eq_no':
            case 'so_no':
            case 'wo_no':
            case 'mty_rfrn_no':
            case 'fm_lcc_cd':
            case 'to_lcc_cd':
            case 'ecc_cd': {
            	obj.value=obj.value.toUpperCase();
                break;
            }
        }
    }
}

/**
 * Upper Case
 * 2015.01.28    Hyungwook Choi
 **/
function toUpperCase(obj) {
    obj.value = obj.value.toUpperCase();
}

/**
 * Loading the list of external combo box
 **/
function getComboList(obj) {
	if(obj == undefined) {
		obj = ComGetEvent();
	}
	
    var yard_obj=null;
    var formObj=document.form;
    obj.value=obj.value.toUpperCase();
    var locValue=obj.value;
    var yardZoneList;
    
    // set IBMultiCombo Object
    if(obj.name == 'search_fm_loc'){
        yard_obj=search_fm_yard;
    }else if(obj.name == 'search_via_loc'){
        yard_obj=search_via_yard;
    }else if(obj.name == 'search_to_loc'){
        yard_obj=search_to_yard;
    }else if(obj.name == 'search_door_loc'){
        yard_obj=search_door_yard;
    }
    
    if(locValue != null && locValue.length > 0) {
	    // set Yard Item to IBMultiCombo
	    if(obj.name == 'search_door_loc') {
	    	yardZoneList = getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	    }else{
	    	yardZoneList = getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
	    }
	    
	    // check Items on IBMultiCombo from Template data
	    if(yardZoneList != null && yardZoneList != "") {
	        setYardFromTemplate(obj, yard_obj);
	    }
    } else {
    	yard_obj.RemoveAll();
    }
}

/**
 * FORM Object crnt_yd_cd(Latest MVMT Yard)의 입력값 검증
 * @param obj
 */
function checkYardCode(obj) {
	if(obj == undefined) //return;
		obj = ComGetEvent();
	if(obj.value.length == 0)
		return;
    obj.value = obj.value.toUpperCase();

    var fm_yard_value = getYardList(sheetObjects[0], document.form, obj.value);
    
	if (fm_yard_value.length < 1 || fm_yard_value == 'undefined') {
		ComShowCodeMessage('TRS90122', obj.value);
		obj.value = "";
		obj.focus();
	}
}

function setYardFromTemplate(locObj, yardComboObj) {
	var formObj = document.form;
	var yardValue;
	var codeArray;
	
	// find form element of Template data
    if(locObj.name == 'search_fm_loc'){
		yardValue = formObj.temp_search_fm_yard.value;
    }else if(locObj.name == 'search_via_loc'){
		yardValue = formObj.temp_search_via_yard.value;
    }else if(locObj.name == 'search_to_loc'){
		yardValue = formObj.temp_search_to_yard.value;
    }else if(locObj.name == 'search_door_loc'){
		yardValue = formObj.temp_search_door_yard.value;
    }
    
    // check Items
	if(yardValue != null && yardValue.length > 0) {
		codeArray = yardValue.split(",");
		for(var i=0; i < codeArray.length; i++ ) {
			yardComboObj.SetSelectCode(codeArray[i], false);
		}
	}
}

// Focusing
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

/**
 * Adding Fuel surcharge to surcharge sheet 
 **/
function addSurchargeData()
{
    var mainSheetObj=sheetObjects[0];
    var surchargeSheetObj=sheetObjects[1];
    var checkList=mainSheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var temp_lgs_cost_cd='';
    var vSurchargeArray = new Array();
    // 2015.01.20    Hyungwook Choi
    for(var a=surchargeSheetObj.LastRow(); a>0 ;a--) {
        temp_lgs_cost_cd=surchargeSheetObj.GetCellValue(a, prefix+'lgs_cost_cd');
        temp_lgs_cost_cd=temp_lgs_cost_cd.substring(2, 4);
        if( temp_lgs_cost_cd == 'FU' || surchargeSheetObj.GetCellValue(a, prefix+'lgs_cost_cd') == 'SCFAAL') {
        	var vSurchargeObject = {
        			trsp_so_ofc_cty_cd : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_so_ofc_cty_cd'),
        			trsp_so_seq : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_so_seq'),
        			unique_cd : surchargeSheetObj.GetCellValue(a,  prefix+'unique_cd'),
        			lgs_cost_cd : surchargeSheetObj.GetCellValue(a,  prefix+'lgs_cost_cd'),
        			lgs_cost_full_nm : surchargeSheetObj.GetCellValue(a,  prefix+'lgs_cost_full_nm'),
        			cre_ofc_cd : surchargeSheetObj.GetCellValue(a,  prefix+'cre_ofc_cd'),
        			cre_usr_id : surchargeSheetObj.GetCellValue(a,  prefix+'cre_usr_id'),
        			trsp_agmt_ofc_cty_cd : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_agmt_ofc_cty_cd'),
        			trsp_agmt_seq : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_agmt_seq'),
        			trsp_agmt_rt_tp_ser_no : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_agmt_rt_tp_ser_no'),
        			trsp_agmt_scg_nod_seq : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_agmt_scg_nod_seq'),
        			trsp_agmt_scg_rt_seq : surchargeSheetObj.GetCellValue(a,  prefix+'trsp_agmt_scg_rt_seq'),
        			fuel_rto : surchargeSheetObj.GetCellValue(a,  prefix+'fuel_rto'),
        			com_scg_knd_cd : surchargeSheetObj.GetCellValue(a,  prefix+'com_scg_knd_cd'),
        			com_scg_seq : surchargeSheetObj.GetCellValue(a,  prefix+'com_scg_seq'),
        			scg_dtl_seq : surchargeSheetObj.GetCellValue(a,  prefix+'scg_dtl_seq'),
        			curr_cd : surchargeSheetObj.GetCellValue(a,  prefix+'curr_cd'),
        			wo_scg_xch_rt : surchargeSheetObj.GetCellValue(a,  prefix+'wo_scg_xch_rt'),
        			org_scg_amt : surchargeSheetObj.GetCellValue(a,  prefix+'org_scg_amt')
        	};
        	vSurchargeArray.push(vSurchargeObject);
        	surchargeSheetObj.RowDelete(a, false);
        }
    }

    var iTrspSoOfcCtyCd;
    var iTrspSoSeq;
    for(var k=0; k<checkArray.length; k++) {
        var main_row=checkArray[k];
        var fuelSurcharge=mainSheetObj.GetCellValue(main_row, 'po_fuel_scg_rt');
        var cgo_tp_cd=mainSheetObj.GetCellValue(main_row, 'cgo_tp_cd');
        if (cgo_tp_cd == 'F') {
        	cgo_tp_cd='C';
        } else {
        	cgo_tp_cd='M';
        }
        if(Number(fuelSurcharge) != 0) {
            var surcharge_row=surchargeSheetObj.DataInsert(-1);
            var trans_md=mainSheetObj.GetCellValue(main_row, 'trsp_crr_mod_cd');
            if(trans_md == 'RW') {
            	trans_md='WR';
            } else if(trans_md == 'TW') {
            	trans_md='WT';
            } else if(trans_md == 'TR') {
            	trans_md='RT';
            } 
            iTrspSoOfcCtyCd = mainSheetObj.GetCellValue(main_row, 'trsp_so_ofc_cty_cd');
            iTrspSoSeq = mainSheetObj.GetCellValue(main_row, 'trsp_so_seq');
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_so_ofc_cty_cd', mainSheetObj.GetCellValue(main_row, 'trsp_so_ofc_cty_cd'), 0);
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_so_seq', mainSheetObj.GetCellValue(main_row, 'trsp_so_seq'), 0);
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'unique_cd', mainSheetObj.GetCellValue(main_row, 'surcharge_key'), 0);
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'lgs_cost_cd', 'S'+cgo_tp_cd+'FU'+trans_md, 0);
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'scg_amt', mainSheetObj.GetCellValue(main_row, 'po_fuel_scg_rt'), 0);
            for(var s =0; s < vSurchargeArray.length; s++) {
            	if(iTrspSoOfcCtyCd == vSurchargeArray[s].trsp_so_ofc_cty_cd && iTrspSoSeq == vSurchargeArray[s].trsp_so_seq) {
           		 	 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'lgs_cost_full_nm', vSurchargeArray[s].lgs_cost_full_nm, 0);
       		 		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'cre_ofc_cd', vSurchargeArray[s].cre_ofc_cd, 0);
       		 		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'cre_usr_id', vSurchargeArray[s].cre_usr_id, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_agmt_ofc_cty_cd', vSurchargeArray[s].trsp_agmt_ofc_cty_cd, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_agmt_seq', vSurchargeArray[s].trsp_agmt_seq, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_agmt_rt_tp_ser_no', vSurchargeArray[s].trsp_agmt_rt_tp_ser_no, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_agmt_scg_nod_seq', vSurchargeArray[s].trsp_agmt_scg_nod_seq, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'trsp_agmt_scg_rt_seq', vSurchargeArray[s].trsp_agmt_scg_rt_seq, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'fuel_rto', vSurchargeArray[s].fuel_rto, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'com_scg_knd_cd', vSurchargeArray[s].com_scg_knd_cd, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'com_scg_seq', vSurchargeArray[s].com_scg_seq, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'scg_dtl_seq', vSurchargeArray[s].scg_dtl_seq, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'curr_cd', vSurchargeArray[s].curr_cd, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'wo_scg_xch_rt', vSurchargeArray[s].wo_scg_xch_rt, 0);
            		 surchargeSheetObj.SetCellValue(surcharge_row, prefix+'org_scg_amt', vSurchargeArray[s].org_scg_amt, 0);
            		 break;
            	}
            }
        }
    }
}

/**
* General Node popup
*/
function openHireYardPopup(objName)
{
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var v6=""; //mode
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
    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 510, objName, '1,0,1,1,1,1,1,1,1,1,1,1',true);    
}

/**
* The return value of From Node popup
*/
function getFromNode(rowArray)
{
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_fm_loc.value=lvLoc;
    getYardCombo(search_fm_yard, sheetObjects[0], formObject, lvLoc);
    search_fm_yard.SetItemCheck(lvYard, true);
}
/**
* The return value of Via Node popup
*/
function getViaNode(rowArray)
{
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_via_loc.value=lvLoc;
    getYardCombo(search_via_yard, sheetObjects[0], formObject, lvLoc);
    search_via_yard.SetItemCheck(lvYard, true); 
}

/**
* The return value of To Node popup
*/
function getToNode(rowArray)
{
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_to_loc.value=lvLoc;
    getYardCombo(search_to_yard, sheetObjects[0], formObject, lvLoc);
    search_to_yard.SetItemCheck(lvYard, true);
}

/**
* The return value of Door Location popup
*/
function getDorLoc(rowArray)
{
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_door_loc.value=lvLoc;
    getZoneCombo(search_door_yard, sheetObjects[0], formObject, lvLoc);
    search_door_yard.SetItemCheck(lvYard, true);
}

/**
 * General Trunk VVD popup
 */
function openTVVDPopup()
{
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
    var classId="getCOM_ENS_TVVD";
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 772, 480, classId, '1,0,1,1,1,1,1,1',true);
}
 
function getCOM_ENS_TVVD(rowArray)
{
    var formObject=document.form;
    var gubun="";
    var colArray=rowArray[0];
    formObject.tvvd_no.value=colArray[7] + gubun;
}

/**
 * General Trunk VVD popup
 */
function openFVVDPopup()
{
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
    var classId="getCOM_ENS_FVVD";
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 772, 480, classId, '1,0,1,1,1,1,1,1',true);
}

function getCOM_ENS_FVVD(rowArray)
{
    var formObject=document.form;
    var gubun="";
    var colArray=rowArray[0];
    formObject.fvvd_no.value=colArray[7] + gubun;
}

function checkDigit(obj) {
    var formObj=document.form;
    if (obj == undefined) {
        obj=formObj.eq_no;
    }
    if(formObj.eq_radio[0].checked) {
        obj.value=multiCntrChkDgt(obj.value);
    }
}


/**
 * The function called after confirming at TPL_ETS_024 (OnSaveEnd) 
 * 
 * Getting wo_prv_grp_seq and wo_iss_no of TRS_TRSP_WRK_ORD_PRV_TMP
 * Selecting trsp_so_ofc_cty_cd and trsp_so_seq of TRS_TRSP_WRK_ORD_PRV_TMP
 * Deleting the value from the grid if that value is in sheetObjects
 * 
 * @param wo_prv_grp_seq TRS_TRSP_WRK_ORD_PRV_TMP
 * @param wo_iss_no TRS_TRSP_WRK_ORD_PRV_TMP 
 */
function processConfirmedWOData(wo_prv_grp_seq,wo_iss_no) {
    document.form.wo_prv_grp_seq.value=wo_prv_grp_seq;
    document.form.wo_iss_no.value=wo_iss_no;
    var formObj = document.form;
    formObj.fmdate.value = formObj.fmdate.value.split('-').join('');
    formObj.todate.value = formObj.todate.value.split('-').join('');
    formObj.dor_arr_dt.value = formObj.dor_arr_dt.value.split('-').join('');
    var sheetObj = sheetObjects[0];
    formObj.f_cmd.value = SEARCH;
    sheetObj.DoSearch("ESD_TRS_0023GS.do", TrsFrmQryString(formObj), {Sync:2});
   }

/**
 * Getting wo_prv_grp_seq and wo_iss_no of TRS_TRSP_WRK_ORD_PRV_TMP
 * Selecting trsp_so_ofc_cty_cd and trsp_so_seq of TRS_TRSP_WRK_ORD_PRV_TMP
 * Deleting the value from the grid if that value is in sheetObjects
 * 
 * @param wo_prv_grp_seq
 * @param wo_iss_no
 **/
function removeConfirmedWOData(wo_prv_grp_seq,wo_iss_no)
{
    var formObj=document.form;
    var sheetObj=sheetObjects[2];
     var sheetObj0=sheetObjects[0];
    var selRow=0;
     if(document.form.wo_radio[0].checked == true){
         var woradio = 0;
     }else{
          var woradio = 1;
     }

     formObj.f_cmd.value=SEARCH06;        
     sheetObj.DoSearch("ESD_TRS_0023GS.do", TrsFrmQryString(formObj),{Sync:2} );

     var delcnt=sheetObj.RowCount();
     for(var i=0 ; i < delcnt ; i++){
           var ofc=sheetObj.GetCellValue(i+1,'trsp_so_ofc_cty_cd');
           var seq=sheetObj.GetCellValue(i+1, 'trsp_so_seq');
           selRow=sheetObj0.FindText('trsp_so_seq',seq,0);
         if( selRow >=0 ){ 
             if(woradio == 1 && sheetObj0.GetCellValue(selRow, 'cancel_check') == 0 ){
             }else{
                 sheetObj0.RowDelete(selRow,false);
              }
        }
    }
}// end function


function multi_moreCandidate(sheetObj) {
	var ip_pass = "N";
	var url = "";
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray;
	if(checkList == '') {
		checkList = sheetObj.FindCheckedRow('more_candi_flg');
		if(checkList == '') {
			checkArray = [sheetObj.GetSelectRow()];
			if(checkArray < 2) {
				ComShowCodeMessage('COM12176');
				return false;
			}
		}else{
			checkArray = checkList.split('|');
		}
	} else {
		checkArray = checkList.split('|');
	}

	var ip_trsp_so_ofc_cty_cd = "";
	var ip_trsp_so_seq = "";
	var ip_basis_dt = "";
	var ip_cmdt_cd = "";
	var ip_wo_issued = "";
	var ip_eq_tp_sz_cd = "";
	var ip_cgo_tp_cd = "";
	var ip_cost_mod_cd = "";
	var ip_crr_mod_cd = "";
	var ip_bound_cd = "";
	var ip_from_node_cd = "";
	var ip_via_nod_cd = "";
	var ip_door_nod_cd = "";
	var ip_to_nod_cd = "";
	var ip_ctrl_ofc_cd = "";
	var ip_vndr_seq = "";
	var ip_vndr_nm = "";
	var ip_cust_cnt_cd = "";
	var ip_cust_seq = "";
	var ip_eq_knd_cd = "";
	var ip_cmb_tp_cd = "";
	var ip_trsp_so_tp_cd = "";
	//var ip_wgt_uom = "";
	//var ip_wgt_qty = "";
	var ip_bundle_cnt = "";
	var ip_mcntr_bdl_grp_seq = "";
	var ip_spcl_cgo_cntr_tp_cd = "";
	var ip_basic_rt = "";
	var ip_nego_amt = "";
	var ip_fuel_scg_rt = "";
	var ip_etc_add_amt = "";
	var ip_trsp_agmt_ofc_cty_cd = "";
	var ip_trsp_agmt_seq = "";
	var ip_rvn_mpt_cntr = "";
	var ip_conti_cd = "";
	var ip_scg_ind_cd = "";

	var oTrsSubStsCdVal = "";
	var oWoIssued = "";
	var oMcntrBdlGrpSeq = "";
	var oMcntrBdlSeq = "";
	var iCngIndFlg = "";
	var iVndrCm = "";
	
	for(var i=0; i < checkArray.length; i++) {
       	oTrsSubStsCdVal = sheetObj.GetCellValue(checkArray[i], 'trs_sub_sts_cd');
    	oWoIssued =  sheetObj.GetCellValue(checkArray[i], 'wo_issued');
    	oMcntrBdlGrpSeq = sheetObj.GetCellValue(checkArray[i], 'mcntr_bdl_grp_seq');
    	oMcntrBdlSeq = sheetObj.GetCellValue(checkArray[i], 'mcntr_bdl_seq');

        iCngIndFlg = sheetObj.GetCellValue( checkArray[i] , "cng_ind_flg");
        iVndrCm = sheetObj.GetCellValue( checkArray[i] , "vndr_cm");
        
        if(iCngIndFlg == 'Y' || iVndrCm == 'Y') {
        	ComShowCodeMessage('TRS90443');
        	return false;    
        }

    	oMcntrBdlSeq = "1";
		if(oMcntrBdlGrpSeq != "" && oMcntrBdlSeq != "1") {
			ComShowCodeMessage('TRS90450');
			return false;
		} else {
			if( i == 0 ) {
				ip_trsp_so_ofc_cty_cd   = sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
				ip_trsp_so_seq          = sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq');
				ip_basis_dt             = sheetObj.GetCellValue(checkArray[i], 'so_cre_dt');
				ip_cmdt_cd              = sheetObj.GetCellValue(checkArray[i], 'cmdt_cd');
				ip_wo_issued            = sheetObj.GetCellValue(checkArray[i], 'wo_issued');
				ip_eq_tp_sz_cd          = sheetObj.GetCellValue(checkArray[i], 'eq_tpsz_cd');
				ip_cgo_tp_cd            = sheetObj.GetCellValue(checkArray[i], 'cgo_tp_cd');
				ip_cost_mod_cd          = sheetObj.GetCellValue(checkArray[i], 'trsp_cost_dtl_mod_cd');
				ip_crr_mod_cd           = sheetObj.GetCellValue(checkArray[i], 'trsp_crr_mod_cd');
				ip_bound_cd             = sheetObj.GetCellValue(checkArray[i], 'trsp_bnd_cd');
				ip_from_node_cd         = sheetObj.GetCellValue(checkArray[i], 'fm_loc_value')+sheetObj.GetCellValue(checkArray[i], 'fm_yard_value');
				ip_via_nod_cd           = sheetObj.GetCellValue(checkArray[i], 'via_loc_value')+sheetObj.GetCellValue(checkArray[i], 'via_yard_value');
				ip_door_nod_cd          = sheetObj.GetCellValue(checkArray[i], 'dor_loc_value')+sheetObj.GetCellValue(checkArray[i], 'dor_yard_value');
				ip_to_nod_cd            = sheetObj.GetCellValue(checkArray[i], 'to_loc_value')+sheetObj.GetCellValue(checkArray[i], 'to_yard_value');
				ip_ctrl_ofc_cd          = sheetObj.GetCellValue(checkArray[i], 'cre_ofc_cd');
				ip_vndr_seq             = sheetObj.GetCellValue(checkArray[i], 'vndr_seq');
				ip_vndr_nm              = sheetObj.GetCellValue(checkArray[i], 'vndr_nm');
				ip_cust_cnt_cd          = sheetObj.GetCellValue(checkArray[i], 'po_cust_cnt_cd');
				ip_cust_seq             = sheetObj.GetCellValue(checkArray[i], 'po_cust_seq');
				ip_eq_knd_cd            = sheetObj.GetCellValue(checkArray[i], 'eq_knd_cd');
				ip_cmb_tp_cd            = sheetObj.GetCellValue(checkArray[i], 'trsp_so_cmb_tp_cd');
				//ip_wgt_uom            = sheetObj.GetCellValue(checkArray[i], 'wgt_meas_ut_cd');
				//ip_wgt_qty            = sheetObj.GetCellValue(checkArray[i], 'cntr_wgt');
				ip_bundle_cnt           = sheetObj.GetCellValue(checkArray[i], 'bundling_no');
				ip_trsp_so_tp_cd        = sheetObj.GetCellValue(checkArray[i], 'trsp_so_tp_cd');
				ip_spcl_cgo_cntr_tp_cd  = sheetObj.GetCellValue(checkArray[i], 'spcl_cgo_cntr_tp_cd');
				ip_basic_rt             = sheetObj.GetCellValue(checkArray[i], 'po_basic_rt');
				ip_nego_amt             = sheetObj.GetCellValue(checkArray[i], 'nego_amt');
				ip_fuel_scg_rt          = sheetObj.GetCellValue(checkArray[i], 'po_fuel_scg_rt');
				ip_etc_add_amt          = sheetObj.GetCellValue(checkArray[i], 'etc_add_amt');
				ip_trsp_agmt_ofc_cty_cd = sheetObj.GetCellValue(checkArray[i], 'po_trsp_agmt_ofc_cty_cd');
				ip_trsp_agmt_seq        = sheetObj.GetCellValue(checkArray[i], 'po_trsp_agmt_seq');
				ip_rvn_mpt_cntr         = sheetObj.GetCellValue(checkArray[i], 'rvn_mpt_cntr');
				ip_conti_cd             = sheetObj.GetCellValue(checkArray[i], 'conti_cd');
				ip_scg_ind_cd           = sheetObj.GetCellValue(checkArray[i], 'scg_ind_cd');
				if(ip_scg_ind_cd == "") {
					ip_scg_ind_cd = "M";
				}
				ip_pass = "Y";
			} else {
				if( ip_basis_dt.substring(0,10) != sheetObj.GetCellValue(checkArray[i], 'so_cre_dt').substring(0,10)) {
					ComShowCodeMessage('TRS90451');
					ip_pass = "N";
					return false;
				}
				
				if( ip_wo_issued != sheetObj.GetCellValue(checkArray[i], 'wo_issued')
					|| ip_eq_tp_sz_cd != sheetObj.GetCellValue(checkArray[i], 'eq_tpsz_cd')
					|| ip_cgo_tp_cd != sheetObj.GetCellValue(checkArray[i], 'cgo_tp_cd') 
					|| ip_cost_mod_cd != sheetObj.GetCellValue(checkArray[i], 'trsp_cost_dtl_mod_cd')
					|| ip_crr_mod_cd != sheetObj.GetCellValue(checkArray[i], 'trsp_crr_mod_cd') 
					|| ip_bound_cd != sheetObj.GetCellValue(checkArray[i], 'trsp_bnd_cd')
					|| ip_from_node_cd != (sheetObj.GetCellValue(checkArray[i], 'fm_loc_value')+sheetObj.GetCellValue(checkArray[i], 'fm_yard_value'))
					|| ip_via_nod_cd != (sheetObj.GetCellValue(checkArray[i], 'via_loc_value')+sheetObj.GetCellValue(checkArray[i], 'via_yard_value'))
					|| ip_door_nod_cd != (sheetObj.GetCellValue(checkArray[i], 'dor_loc_value')+sheetObj.GetCellValue(checkArray[i], 'dor_yard_value'))
					|| ip_to_nod_cd != (sheetObj.GetCellValue(checkArray[i], 'to_loc_value')+sheetObj.GetCellValue(checkArray[i], 'to_yard_value'))
					|| ip_ctrl_ofc_cd != sheetObj.GetCellValue(checkArray[i], 'cre_ofc_cd') 
					|| ip_vndr_seq != sheetObj.GetCellValue(checkArray[i], 'vndr_seq')
					|| ip_eq_knd_cd != sheetObj.GetCellValue(checkArray[i], 'eq_knd_cd') 
					|| ip_trsp_so_tp_cd != sheetObj.GetCellValue(checkArray[i], 'trsp_so_tp_cd')
					|| ip_cust_cnt_cd != sheetObj.GetCellValue(checkArray[i], 'po_cust_cnt_cd') 
					|| ip_cust_seq != sheetObj.GetCellValue(checkArray[i], 'po_cust_seq')
					|| ip_spcl_cgo_cntr_tp_cd != sheetObj.GetCellValue(checkArray[i], 'spcl_cgo_cntr_tp_cd')
				) {
					ComShowCodeMessage('TRS90450');
					ip_pass = "N";
					return false;
				}
			}
		}
	}
	if( ip_pass == "Y" ) {
		url = '?trsp_so_ofc_cty_cd='+ip_trsp_so_ofc_cty_cd;
		url += '&trsp_so_seq='+ip_trsp_so_seq;
		url += '&ctrl_ofc_cd='+ip_ctrl_ofc_cd;
		url += '&vndr_seq='+ip_vndr_seq;
		url += '&vndr_nm='+ip_vndr_nm;
		url += '&basis_dt='+ip_basis_dt;
		url += '&eq_knd_cd='+ip_eq_knd_cd;
		url += '&eq_tp_sz_cd='+ip_eq_tp_sz_cd;
		url += '&cmb_tp_cd='+ip_cmb_tp_cd;
		url += '&cgo_tp_cd='+ip_cgo_tp_cd;
		url += '&bound_cd='+ip_bound_cd;
		url += '&crr_mod_cd='+ip_crr_mod_cd;
		url += '&cost_mod_cd='+ip_cost_mod_cd;
		url += '&cust_cnt_cd='+ip_cust_cnt_cd;
		url += '&cust_seq='+ip_cust_seq;
		url += '&cmdt_cd='+ip_cmdt_cd;
		url += '&from_nod_cd='+ip_from_node_cd;
		url += '&via_nod_cd='+ip_via_nod_cd;
		url += '&door_nod_cd='+ip_door_nod_cd;
		url += '&to_nod_cd='+ip_to_nod_cd;
		url += '&bundle_cnt='+ip_bundle_cnt;
		url += '&wo_issued='+ip_wo_issued;
		url += '&spcl_cgo_cntr_tp_cd='+ip_spcl_cgo_cntr_tp_cd;
		//url += '&wgt_uom='+ip_wgt_uom;
		//url += '&wgt_qty='+ip_wgt_qty;
		url += '&basic_rt='+ip_basic_rt;
		url += '&nego_amt='+ip_nego_amt;
		url += '&fuel_scg_rt='+ip_fuel_scg_rt;
		url += '&etc_add_amt='+ip_etc_add_amt;
		url += '&trsp_agmt_ofc_cty_cd='+ip_trsp_agmt_ofc_cty_cd;
		url += '&trsp_agmt_seq='+ip_trsp_agmt_seq;
		url += '&rvn_mpt_cntr='+ip_rvn_mpt_cntr;
		url += '&conti_cd='+ip_conti_cd;
		url += '&scg_ind_cd='+ip_scg_ind_cd;
		url += '&single_multi_sep=M';
        ComOpenWindow('ESD_TRS_0921.do'+url, 'ESD_TRS_0921', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:1200px;dialogHeight:560px', true);
	}
}

function popupVndrCm() {
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var soNoArray = Array();
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	for(var i=0; i < checkArray.length; i++) {
		soNoArray.push(sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd') + sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq'));
	}	
	if(soNoArray.length > 0) {
		ComOpenWindow('ESD_TRS_0972.do?so_no=' + soNoArray, 'ESD_TRS_0972', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:1200px;dialogHeight:560px', true);
	} 
}

function popupJoEdiHistory() {
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var soNoArray = Array();
	if(checkList == ''){
		checkList =  sheetObj.GetSelectionRows('|');
		checkArray = checkList.split('|');
	}
	for(var i=0; i < checkArray.length; i++) {
		soNoArray.push(sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd') + sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq'));
	}
	ComOpenWindow('ESD_TRS_0973.do?so_no=' + soNoArray, 'ESD_TRS_0973', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:1200px;dialogHeight:560px', true);
}

/**
 * CM Detail popup
 **/
function popCmDtail(sheetObj, formObj) {
    var checkList = sheetObj.FindCheckedRow('ibcheck');
    var checkArray = checkList.split('|');

    if(checkList == '') {
        ComShowCodeMessage('COM12176');
        return false;
    }
    ComOpenWindow('ESD_TRS_0977.do', 'ESD_TRS_0977', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:900px;dialogHeight:600px', true);
}

/**
 * 
 */
function fnOpenRetrieveEvent() {
	var formObject = document.form;
	if(processFlag) {
    	return;
    }
    sheetObjects[1].RemoveAll();
    if(init_searchStr) {
        document.getElementById('init_trsp_so_ofc_cty_cd').value = '';
        document.getElementById('init_trsp_so_seq').value = '';
        init_searchStr = false;
    }
    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);	
}

/**
 * 
 */
function updateCYContainerNo() {
	var formObject = document.form;
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	if(checkList == '') {
        ComShowCodeMessage('COM12176');
        return false;
    }
	for(var i=0; i < checkArray.length; i++) {
		if(sheetObj.GetCellValue(checkArray[i], 'cop_flg') != "Y") {
			 ComShowCodeMessage('TRS90457');
			return;
		}
	}
	
	if (ComShowCodeConfirm("COM130501")) {
		doActionIBSheet(sheetObj, formObject, IBSEARCH_ASYNC04);
	}	
}
function sheet_OnClick(sheetObj, row, col, value) {
	var colName=sheetObj.ColSaveName(col);
	switch(colName) {
		case "inter_rmk_img" :
			if(sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'M' 
			&& sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'H'
			&& sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'O') {
			var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
			var lveqno=sheetObj.GetCellValue(row, "eq_no");
			var lvsono=sheetObj.GetCellValue(row, "trsp_so_ofc_cty_cd_seq");
			var lvwono=sheetObj.GetCellValue(row, "trsp_wo_ofc_cty_cd_seq");
			var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&wo_no=" + lvwono + "&inter_rmk_cd=T";
			ComOpenWindowCenter(url, "compopup", 1000, 570, true);
		}
		break;
	}
}


/**
 * DATE VALIDATION LOGIC ON WORK ORDER POP UP VERIFICATION MSG
 * @param sheetObject
 * @param Row
 * @returns {Boolean}
 */
function funcWoDateValidCheck(sheetObject, Row) {
//    var defaultTm = "00:00:00";
    var fromDt = "";
    var toDt = "";
    var doorDt = "";
	fromDt = sheetObject.GetCellValue(Row, "n1st_nod_pln_dt");
	toDt = sheetObject.GetCellValue(Row, "lst_nod_pln_dt");
	doorDt = sheetObject.GetCellValue(Row, "dor_nod_pln_dt");
    
    if(fromDt != '' && toDt != '') {
        if(TrsComGetTimeBetween(fromDt, toDt) <= 0) {
        	return false;
        }
    }
    if(fromDt != '' && doorDt != '') {
        if(TrsComGetTimeBetween(fromDt, doorDt) <= 0) {
        	return false;
        }
    }
    if(doorDt != '' && toDt != '') {
        if(TrsComGetTimeBetween(doorDt, toDt) <= 0) {
        	return false;
        }
    }
    return true;
}

function initSearchTemplate(sXml, templateComboIndex) {
	ComXml2ComboItem(sXml, templateCombo, "seq_no", "tmpl_desc");
	templateCombo.InsertItem(0, "New Template", "");
	// set default
	var ndx = 0;
	if(templateComboIndex != null && templateComboIndex != "") {
		ndx = templateComboIndex;
	}
	templateCombo.SetSelectIndex(ndx, false);
}

function setCondition(sqlCtnt) {
	var formNameValue;
	var formElement;
	var formElementArray = [];
	var formElementArrayIndex = 0;
	// 1. check contents is empty
	if(sqlCtnt == undefined || sqlCtnt == "") return;
	// 2. arrange key/value from contents
	var arrSqlCtnt = sqlCtnt.split("|");
	// 3. set each form element from contents
	try {
		for (var i=0; i < arrSqlCtnt.length; i++) {
			// 3.1. divide key, value
   			formNameValue = arrSqlCtnt[i].split("=");
   			
   			// 3.2. when name is 'templateCombo' or start with 'temp_' then skip
   			if(formNameValue[0].substring(formNameValue[0].indexOf("_text")) > 0) {
   				alert(formNameValue[0]);
   			}
   			if (formNameValue[0].substring(0,5) == "temp_" || formNameValue[0] == "templateCombo" || formNameValue[0].substring(formNameValue[0].indexOf("_text")) == "_text") {
   				continue;
   			}
   			
   			// 3.3. when name is like 'search_%_yard' then change the name as 'temp_search_%_yard'
   			//		change cgo_tp_cd, eq_tpsz_cd, spcl_cgo_cntr_tp_cd as temp_cgo_tp_cd, 'temp_eq_tpsz_cd', 'temp_spcl_cgo_cntr_tp_cd'
   			//      this element's value is set on change event process 
   			if(formNameValue[0].indexOf("_yard") >= 0 || formNameValue[0] == "cgo_tp_cd" || formNameValue[0] == "eq_tpsz_cd" || formNameValue[0] == "spcl_cgo_cntr_tp_cd") {
   				formNameValue[0] = "temp_" + formNameValue[0];
   			}

   			// 3.4. check IBMultiCombo items
			var isCombo = false;
		    for (var k=0; k < comboObjects.length; k++) {
		        if(comboObjects[k].options.id == formNameValue[0]) {
		    		var codeArray = formNameValue[1].split(",");
		    		for(var j=0; j < codeArray.length; j++ ) {
		    			comboObjects[k].SetSelectCode(codeArray[j], false);
		    		}
		    		
		        	isCombo = true;
		        	break;
		        }
		    }
		    if(isCombo) {
		    	continue;
		    }
   			
   			// 3.5. find form elements by name
   			formElement = document.getElementsByName(formNameValue[0]);
   			if(formElement[0] == undefined || formElement[0] == null){
   				alert("form element <" + formNameValue[0] + "> is undefined or null");
   				continue;
   			}
   			
   			if (formElement[0].type == null) {
   				alert("form element[0] " + formNameValue[0] + " type is null");
//   			} else {
//   				alert(formNameValue[0]);
   			}
   			
   			// 3.6. collect form elements which is need to invoke change event
   			if(formNameValue[0].substring((formNameValue[0].length-4)) == '_loc') {
   	   			formElementArray[formElementArrayIndex] = formElement[0];
   	   			formElementArrayIndex ++;
   			}
   			// set form elements even if it's value is blank
   			//if(formNameValue[1] == "") continue;
   			
   			// 3.7. set form element's value by it's type
   			if(formElement[0].type == "checkbox") {
   				formElement[0].checked = true;
			}else if(formElement[0].type == "radio") {
				for(var j=0; j < formElement.length; j++) {
					if(formElement[j].value == formNameValue[1]) {
						formElement[j].checked = true;
						break;
					}
				}
			}else if(formElement[0].type == "select-one") {
				for(var j=0; j < formElement[0].options.length; j++) {
					if(formElement[0].options[j].value == formNameValue[1]) {
						formElement[0].options[j].selected = true;
						break;
					}
				}
			}else if(formElement[0].type == "combo") {
				formElement[0].SetSelectCode(formNameValue[1].URLDecode());
			}else if(formElement[0].type == "multi") {
				formElement[0].SetSelectCode(formNameValue[1].URLDecode());
			}else{
				formElement[0].value = formNameValue[1];
			}
   		} //end for

		// 4. invoke form element's change event for it's post process(Yard)
		for (var m=0; m < formElementArray.length; m++) {
   			ComFireEvent(formElementArray[m], "change");
   		}
		
		// 5. set Equipment No. radio and Code
		//    set IBMultiCombo change cgo_tp_cd, eq_tpsz_cd, spcl_cgo_cntr_tp_cd
		var invokerIsTemplate = true;
		setEquipment();
		
		// 6. invoke Work Order Issued radio click event
		setWOIssue(document.form.wo_radio);

		// 7. set Service Provider Name
		getTextVendorSeq(sheetObjects[0], document.form, document.form.combo_svc_provider.value);
	}catch(e){
		alert(e.message);
	}
}

function templateCombo_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	var formObject = document.form;
	// 1. reset form
    formObject.reset();
    // 2. initialize form, IBMultiCombo
    resetSearchCondition(formObject);
    // 3. set form, IBMultiCombo
    var row = sheetObjects[4].FindText("seq_no", NewCode);
    var qryStr = sheetObjects[4].GetCellValue(row, "cond_prm");
	setCondition(decodeURIComponent(qryStr));
	// 4. reset template combo index
	comboObj.SetSelectIndex(NewIndex, false);
	// 5. check selected template
	sheetObjects[4].CheckAll("ibcheck", 0, 0);
	sheetObjects[4].SetCellValue(row, "ibcheck", 1, 0);
}

function setEquipment() {
   var formObject = document.form;
   if ( formObject.eq_radio.value == "U" ) {
       formObject.eq_radio[0].checked = true;
   } else if( formObject.eq_radio.value == "Z" ) {
	   formObject.eq_radio[1].checked = true;
   } else if( formObject.eq_radio.value == "G" ) {
	   formObject.eq_radio[2].checked = true;
   }
   
   var a = doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
   
   // reset template data to Combo 'Cargo Type', 'BKG CGO SPE', 'EQ TP/SZ'
	var codeArray = formObject.temp_cgo_tp_cd.value.split(",");
	for(var j=0; j < codeArray.length; j++ ) {
		cgo_tp_cd.SetSelectCode(codeArray[j], false);
	}
	codeArray = formObject.temp_eq_tpsz_cd.value.split(",");
	for(var j=0; j < codeArray.length; j++ ) {
		eq_tpsz_cd.SetSelectCode(codeArray[j], false);
	}
	codeArray = formObject.temp_spcl_cgo_cntr_tp_cd.value.split(",");
	for(var j=0; j < codeArray.length; j++ ) {
		spcl_cgo_cntr_tp_cd.SetSelectCode(codeArray[j], false);
	}
}

/**
 * Invoked from Save as Popup(ESD_TRS_0921)
 * @param tmpl_desc
 */
function saveAsTemplate(tmpl_desc) {
	var formObj = document.form;
    var sheetObject4 = sheetObjects[4];
	formObj.temp_tmpl_desc.value = tmpl_desc;
	doActionIBSheetForTemplate(sheetObject4, formObj, IBINSERT);
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
function sheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj=document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_loc_value":
		case "fm_yard_value":
			if(ComIsNull(sheetObj.GetToolTipText(mouseRow, mouseCol))) {
				sheetObj.SetToolTipText(mouseRow, mouseCol, sheetObj.GetCellValue(mouseRow, "fm_nod_cd_nm"));
			}
			break;
		case "via_loc_value":
		case "via_yard_value":
			if(ComIsNull(sheetObj.GetToolTipText(mouseRow, mouseCol))) {
				sheetObj.SetToolTipText(mouseRow, mouseCol, sheetObj.GetCellValue(mouseRow, "via_nod_cd_nm"));
			}
			break;
		case "to_loc_value":
		case "to_yard_value":
			if(ComIsNull(sheetObj.GetToolTipText(mouseRow, mouseCol))) {
				sheetObj.SetToolTipText(mouseRow, mouseCol, sheetObj.GetCellValue(mouseRow, "to_nod_cd_nm"));
			}
			break;
	}	
}


/**
 * Change Management 처리 후 호출
 */
function afterChangeMgmt() {
	var formObject = document.form;
	if (processFlag) {
		return;
	}
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	if (init_searchStr) {
		document.getElementById('init_trsp_so_ofc_cty_cd').value = '';
		document.getElementById('init_trsp_so_seq').value = '';
		init_searchStr = false;
	}
	formObject.search_keep_flg.value = "Y";
	var vKeepSoNo = "";
	var arrow = sheetObjects[0].FindCheckedRow("ibcheck");
	var s = arrow.split("|");
	for(var i =0; i < s.length ; i++) {
		vKeepSoNo += sheetObjects[0].GetCellValue(s[i], 'trsp_so_ofc_cty_cd_seq');
		if(i < s.length -1) {
			vKeepSoNo += ",";
		}
	}
	formObject.keep_so_no.value = vKeepSoNo;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	formObject.search_keep_flg.value = "N";
	formObject.keep_so_no.value = "";
}