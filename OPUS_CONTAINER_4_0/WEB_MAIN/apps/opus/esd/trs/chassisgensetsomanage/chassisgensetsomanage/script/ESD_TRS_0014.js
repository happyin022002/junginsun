/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0014.js
*@FileTitle  : Service Order creation - Chassis or Genset
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/***********************************************************************************************************************************************************************************************************************************************************************************************************
 * Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3; MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 **********************************************************************************************************************************************************************************************************************************************************************************************************/
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
var seqNo=1;
var nodeSearchFlag=false;
var checkedChassis='chassis';
var checkedHire='D';
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
    for(var i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}

/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */  
function processButtonClick(){
    /** ***Case more than two additional sheets tab sheet is used to specify a variable **** */
     var sheetObject=sheetObjects[0];
     var sheetObject1=sheetObjects[1];
     var sheetObject2=sheetObjects[2];
     var sheetObject3=sheetObjects[3];
     /** **************************************************** */
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                if(formObject.kind_manual[1].checked){
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                }   
                break;
            case "btn_reset":
                resetForm(formObject);
                break;
            case "btn_rowadd":
                addBundleUnit();
                break;
            case "btng_rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
            case "search_hiredate":
                var cal2=new ComCalendarFromTo();
                cal2.displayType="date";
                cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
                break;
            case "btng_delete":
                doActionIBSheet(sheetObject,formObject,IBDELETE);
                break;
            case "btng_downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "btng_unbundling":
                unBundle(sheetObject, formObject);
                break;
            case "btng_bundling":
                itemBundling(sheetObject, formObject);
                break;
            case "btng_socreation":
                doActionIBSheet(sheetObject,formObject, IBSAVE, 'C');
            break;
            case "btng_woissue":
                doActionIBSheet(sheetObject,formObject, IBSAVE, 'I');
            break;
            case "btng_fillineq":
                if(formObject.kind_manual[0].checked)
                popEqFileImport(sheetObject, formObject);
            break;
            case "btng_multipleapply":
                popMultiApply(sheetObject);
            break;
            case "btns_search":
                if(nodeSearchFlag) openHireYardPopup('getCOM_ENS_061_1'); 
            break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:
            with(sheetObj){
                var HeadTitle="STS||Bundle\nSeq.|Bundle\nKind|EQ No|EQ\nTP/SZ|From|From|To|To|Trans. Mode|Lessor"
                + "|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date"
                + "|Internal Remark|Reference\nCNTR No|Reference\nTP\SZ|Reference\nBKG No"
                + "|Reference\nB/L No|Outgate Date|Outgate Date|Ingate Date|Ingate Date"
                + "|Remark\n(Special Instruction)|Verify\nResult|row no";
                
                SetConfig( { SearchMode:0, FrozenCol:6, DataRowMerge:0, MergeSheet:7, Page:2 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_cmb_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                            {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                            {Type:"Combo",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                            {Type:"Combo",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                            {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                            {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"inter_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ref_bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ref_bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                            {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_gate_out_date",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_gate_out_time",  KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                            {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_gate_in_date",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_gate_in_time",  KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"spcl_instr_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"verify_result",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                            {Type:"Seq",       Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sheet_row" },
                            {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
                            {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_nm" },
                            {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_gate_out_dt" },
                            {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dest_gate_in_dt" } ];
                                           
                InitColumns(cols);
                SetEditable(1);
                SetColProperty(0, 'trsp_crr_mod_cd', {ComboText:"|"+trsp_crr_mod_cdText, ComboCode:"|"+trsp_crr_mod_cdCode} );
                SetColProperty(0, 'trsp_so_cmb_tp_cd', {ComboText:"|"+trsp_so_cmb_tp_cdText, ComboCode:"|"+trsp_so_cmb_tp_cdCode} );
                SetColProperty(0, 'eq_tpsz_cd', {ComboText:"|" + chss_eq_tpsz_cdText, ComboCode:"|" + chss_eq_tpsz_cdCode} );
                ComResizeSheet(sheetObj);
            }
            break;
        case 2:   
            with(sheetObj){
                cnt=0;
                var HeadTitle="sts|svc_ord|seq";
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
                                           
                InitColumns(cols);
                SetEditable(1);
                SetVisible(0);
            }

            break;
    }
}

/* Sheet processing-related processes */
function doActionIBSheet(sheetObj,formObj,sAction, trspSoStsCD) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:     // retrieve
            if(!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj) );
            break;
        case IBSAVE:        // SO Creation, WO Issue
            var sheetObj2=sheetObjects[1];
            if(trspSoStsCD == 'C'){
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                var checkList=sheetObj.FindCheckedRow('ibcheck');
                var checkArray=checkList.split('|');
                setGateOutDate(sheetObj, checkArray);
                sheetObj.RemoveEtcData();
                var queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
                if(queryStr=='') return false;
                formObj.f_cmd.value=SEARCH03;
                var searchXml=sheetObj.GetSaveData("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj));
                if (!getVerifyColumn(sheetObj) && !ComShowCodeConfirm('TRS90346')) {
                    var checkList=sheetObj.FindCheckedRow('ibcheck');
                    var checkArray=checkList.split('|');
                    for(var k=0; k<checkArray.length; k++) {
                        if( sheetObj.GetCellValue(checkArray[k], 'verify_result') != ''){
                            sheetObj.SetCellValue(checkArray[k], 'ibcheck', 0, 0);
                        }
                    }
                    return false;
                }
                formObj.f_cmd.value=ADD;
                formObj.TRSP_SO_TP_CD.value='H';
                formObj.TRSP_SO_STS_CD.value=trspSoStsCD; // SO -C, WO - I
                queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
                sheetObj2.DoSearch("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj),{Append:true} );
                ComShowCodeMessage('TRS90107');
            } else  if(trspSoStsCD == 'I'){
                if(sheetObj2.RowCount()< 1){
                    ComShowCodeMessage('TRS90110');
                    return false;
                }
                if(!ComShowCodeConfirm('TRS90227',sheetObj2.RowCount())) {
                    return false;
                }
                var cty_cd='';
                var seq_no='';
                for(var i=1; i<sheetObj2.RowCount()+1; i++) {
                    if(i != 1){
                        cty_cd += ',';
                        seq_no += ',';
                    }
                    cty_cd += sheetObj2.GetCellValue(i, 'trsp_so_ofc_cty_cd');
                    seq_no += sheetObj2.GetCellValue(i, 'trsp_so_seq');
                }
                document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
                document.woForm.trsp_so_seq.value=seq_no;
                document.woForm.eq_mode.value=document.form.kind_chassis.value;
                document.woForm.submit();
                return false;
            }
            break;
        case IBDELETE:
            deleteCheckedRow(sheetObj);
            break;
        case IBINSERT:    // input
            var Row=sheetObj.DataInsert(-1);
            break;
        case IBCLEAR:      // Clear
            sheetObj.RemoveAll();
            break;
        case IBDOWNEXCEL:  // Excel download
            if(sheetObj.RowCount() < 1){// no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObj.Down2Excel({ HiddenColumn:true, AutoSizeColumn : 1, ExcelFontSize : 10, ExcelRowHeight : "18", SheetDesign: 1 , OnlyHeaderMerge:1, Merge:1});
            }
            break;
        case IBLOADEXCEL:        // Excel upload
            sheetObj.LoadExcel();
            break;
    }
}
/**
 * When an error occurs, save the results to a common processing function DataSheetObject.prototype.event_OnSearchEnd defined in IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    }else{
        if(formObj.f_cmd.value == ADD){
            var checkList=sheetObjects[0].FindCheckedRow('ibcheck');
            var checkArray=checkList.split('|');
            for(var k=checkArray.length-1; k>=0; k--)
            {
                sheetObjects[0].RowDelete(checkArray[k], false);
            }
        }
    }
}
/**
 * When an error occurs, save the results to a common processing function DataSheetObject.prototype.event_OnSearchEnd defined in IBSheetConfig.js
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    switch(sAction) {
    case IBSEARCH:
        var lvfrmDate=doSepRemove(doSepRemove(formObj.fmdate.value, " "), "-");
        var lvtoDate=doSepRemove(doSepRemove(formObj.todate.value, " "), "-");
        if( lvfrmDate == "" ) { 
            errMsg=ComGetMsg("TRS90119");          
            ComShowMessage(errMsg);
            formObj.fmdate.focus();
            return false;
        }else if(lvtoDate == "" ) {
            errMsg=ComGetMsg("TRS90121");
            ComShowMessage(errMsg);
            formObj.todate.focus();
            return false;
        }else if( lvfrmDate != "" && lvtoDate != "" ) { 
        	if( ComGetDaysBetween(lvfrmDate, lvtoDate) > 30 ) {
        		ComShowCodeMessage("TRS90424");
				return false;
			} else if( ComGetDaysBetween(lvfrmDate, lvtoDate) < 0 ) {
				ComShowCodeMessage("TRS90118");
				return false;
			}
        }
        break;
        case IBSAVE:
            var checkList=sheetObj.FindCheckedRow('ibcheck');
            var checkArray=checkList.split('|');

            if(checkList == ''){
                ComShowCodeMessage('COM12176');
                return false;
            }
            
            var fmNode='';
            var toNode='';
            for(var k=0; k<checkArray.length; k++)
            {
                var row=checkArray[k];
                fmNode=sheetObj.GetCellValue(row, 'fm_loc_value')+sheetObj.GetCellValue(row, 'fm_yard_value');
                toNode=sheetObj.GetCellValue(row, 'to_loc_value')+sheetObj.GetCellValue(row, 'to_yard_value');
                if(fmNode == toNode)
                {
                    ComShowCodeMessage('COM12115', 'From Node and To Node');
                    sheetObj.SelectCell(row, 'fm_loc_value');
                    return false;
                }
            }
            var src_row=0;
            var tgt_row=0;
            var src_eq_no=null;
            var tgt_eq_no=null;
            var src_fm_loc_value=null;
            var tgt_fm_loc_value=null;
            var src_fm_yard_value=null;
            var tgt_fm_yard_value=null;
            for(var k=0; k<checkArray.length-1; k++)
            {
                src_row=checkArray[k];
                src_eq_no=sheetObj.GetCellValue(src_row, 'eq_no');
                src_fm_loc_value=sheetObj.GetCellValue(src_row, 'fm_loc_value');
                src_fm_yard_value=sheetObj.GetCellValue(src_row, 'fm_yard_value');
                if( src_eq_no != ''){
                    for(var j=k+1; j<checkArray.length; j++){
                        tgt_row=checkArray[j];
                        tgt_eq_no=sheetObj.GetCellValue(tgt_row, 'eq_no');
                        tgt_fm_loc_value=sheetObj.GetCellValue(tgt_row, 'fm_loc_value');
                        tgt_fm_yard_value=sheetObj.GetCellValue(tgt_row, 'fm_yard_value');
                        if(tgt_eq_no != '' &&
                            src_eq_no == tgt_eq_no &&
                            src_fm_loc_value == tgt_fm_loc_value &&
                            src_fm_yard_value == tgt_fm_yard_value ){
                            ComShowCodeMessage('COM12115', 'EQ No AND From Node');
                            sheetObj.SelectCell(tgt_row, 'eq_no');
                            return false;
                        }
                    }
                }
            }
            break;
    }
    return true;
}
function deleteCheckedRow(sheetObj)
{
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    if(checkList == '')
    {
        ComShowCodeMessage('COM12176');
        return false;
    }
    for(var k=checkArray.length-1; k>=0; k--)
    {
        sheetObj.RowDelete(Number(checkArray[k]), false);
    }
}
/**
 * kind query processing conditions
 */
function setKindEnabled(){
        var sheetObj=sheetObjects[0];
        var obj=document.form; 
        var k_c=obj.kind_chassis;
        var k_h=obj.kind_hire;
        var k_m=obj.kind_manual;
        var k_b=obj.kind_bundle;
        
        if (k_c[0].checked) {
        	sheetObj.SetColProperty(0, 'eq_tpsz_cd', {ComboText:"|" + chss_eq_tpsz_cdCode, ComboCode:"|" + chss_eq_tpsz_cdCode} );
        } else if (k_c[1].checked) {
        	sheetObj.SetColProperty(0, 'eq_tpsz_cd', {ComboText:"|" + gen_eq_tpsz_cdCode, ComboCode:"|" + gen_eq_tpsz_cdCode} );
        }
        
        if(sheetObj.RowCount()>0 && checkedChassis == 'chassis' && k_c[1].checked) {
            if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?')) {
                sheetObj.RemoveAll();
                checkedChassis='genset';
            } else {
                k_c[0].checked=true;
                checkedChassis='chassis';
                return;
            }
        } else if(sheetObj.RowCount()>0 &&checkedChassis == 'genset' && k_c[0].checked) {
            if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?')) {
                sheetObj.RemoveAll();
                checkedChassis='chassis';
            } else{
                k_c[1].checked=true;
                checkedChassis='genset';
                return;
            }
        } else if(sheetObj.RowCount()== 0) {
            if (k_c[0].checked) checkedChassis='chassis';
            else if (k_c[1].checked) checkedChassis='genset';
        }
        var k_h_value='';
        for(var i=0;i<k_h.length;i++) {
            if(k_h[i].checked) {
                k_h_value=k_h[i].value;
                break;
            }
        }
        if(sheetObj.RowCount()>0 && checkedHire != k_h_value) {
            if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?')) {
                sheetObj.RemoveAll();
                checkedHire=k_h_value;
            } else {
                for(var i=0; i<k_h.length;i++) {
                    if(k_h[i].value == checkedHire) {
                        k_h[i].checked=true;
                        return;
                    }
                }
            }
        } else {
            checkedHire=k_h_value;
        }
        k_h[0].disabled=false;
        k_h[1].disabled=false;
        k_h[2].disabled=false;
        k_m[0].disabled=false;
        k_m[1].disabled=false;
        k_b[0].disabled=false;
        k_b[1].disabled=false;
        k_b[2].disabled=false;
        if(k_c[0].checked) {
            k_m[0].disabled=false;
            k_m[1].disabled=false;
        } else if(k_c[1].checked) {
            k_m[0].disabled=false;
            k_m[1].disabled=true;
        }
        if( k_c[0].checked && k_h[0].checked ) {
            k_m[0].disabled=false;
            k_m[1].disabled=true;
        } else if(k_c[0].checked && k_h[1].checked) {
            k_m[0].disabled=false;
            k_m[1].disabled=false;
        } else if(k_c[0].checked && k_h[2].checked) {
            k_m[0].disabled=false;
            k_m[1].disabled=true;
        }
        if(k_m[1].disabled) k_m[0].checked=true;
        if(k_c[1].checked && k_m[0].checked) {
            k_b[0].disabled=false;
            k_b[1].disabled=true;
            k_b[2].disabled=true;
        }
        if(k_b[1].disabled) k_b[0].checked=true;
        setRestEnabled();    
 }
/**
 * Other query processing conditions
 */
function setRestEnabled()
{
    var obj=document.form;
    /* QTY enable / On Hire Creation Date / On Hire Yard */
    if(obj.kind_manual[0].checked)
    {
        obj.todate.disabled=true;
        obj.fmdate.disabled=true;
        obj.hire_loc.disabled=true;
        hire_yd.SetEnable(0);
        nodeSearchFlag=false;
    }else
    {
        obj.todate.disabled=false;
        obj.fmdate.disabled=false;
        obj.hire_loc.disabled=false;
        hire_yd.SetEnable(1);
        nodeSearchFlag=true;
    }
    if(obj.kind_bundle[0].checked)
    {
        obj.bundle_unit.disabled=true;
        obj.bundle_set.disabled=true;
        obj.unit_qty.disabled=false;
    }else{
        obj.bundle_unit.disabled=false;
        obj.bundle_set.disabled=false;
        obj.unit_qty.disabled=true;
    }
}
/**
 * sheet click evnet
 */
function sheet_OnClick(sheetObj, row, col, value)
{
    if(sheetObj.GetCellProperty(row, col, 0)==6)
    {   
        return;
    }
    var colName=sheetObj.ColSaveName(col);
    var k_h_value='';
    var k_h=document.form.kind_hire;
    for(var i=0;i<k_h.length;i++)
    {
        if(k_h[i].checked)
        {
            k_h_value=k_h[i].value;
            break;
        }
    }
    if(colName == 'fm_loc_value' && k_h_value == 'D'){
        document.form.TRSP_SO_EQ_KIND.value='A';
    }else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
//        document.form.TRSP_SO_EQ_KIND.value=k_h_value;
        document.form.TRSP_SO_EQ_KIND.value='A';
    }else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
        document.form.TRSP_SO_EQ_KIND.value='Y';
    }else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
        document.form.TRSP_SO_EQ_KIND.value='A';
    }else if(colName == 'to_loc_value' && k_h_value == 'F') {
        document.form.TRSP_SO_EQ_KIND.value='N';
    }else if(colName == 'fm_yard_value' && (k_h_value == 'N' || k_h_value == 'F')) {
    	document.form.TRSP_SO_EQ_KIND.value='Y';
    }
    switch(colName){
        case 'fm_yard_value':
        	if (sheetObj.GetCellValue(row, 'fm_loc_value') != "") {
        		getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'fm_loc_value'));
        	} else {
        		sheetObj.CellComboItem(row, colName, { ComboText : "|", ComboCode : "|" });
        	}
            break;
        case 'to_yard_value':
        	if (sheetObj.GetCellValue(row, 'to_loc_value') != "") {
        		getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'to_loc_value'));
        	} else {
        		sheetObj.CellComboItem(row, colName, { ComboText : "|", ComboCode : "|" });
        	}
            break;
        case 'eq_tpsz_cd':
            if(sheetObj.GetCellValue(row,'eq_no') == '' ) {
            	sheetObj.SetCellEditable(row,'eq_tpsz_cd',1);
            } else if(sheetObj.GetCellValue(row,'eq_no') != '') {
            	sheetObj.SetCellEditable(row,'eq_tpsz_cd',0);
            }
            break;
    }
}
function sheet_OnKeyDown(sheetObj, row, col, keycode, Shift) 
{
    var colName=sheetObj.ColSaveName(col);
    if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.GetCellValue(row,'eq_no') == '' ) sheetObj.SetCellEditable(row,'eq_tpsz_cd',1);
    else if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.GetCellValue(row,'eq_no') != '')sheetObj.SetCellEditable(row,'eq_tpsz_cd',0);
}
/**
 * sheet cell value change events that occur
 */
function sheet_OnChange(sheetObj, row, col, value){
    var formObject=document.form;
    var colName=sheetObj.ColSaveName(col);
    var k_h_value='';
    var k_h=document.form.kind_hire;
    for(var i=0;i<k_h.length;i++)
    {
        if(k_h[i].checked)
        {
            k_h_value=k_h[i].value;
            break;
        }
    }
    if(colName == 'fm_loc_value' && k_h_value == 'D'){
        document.form.TRSP_SO_EQ_KIND.value='A';
    }else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
//        document.form.TRSP_SO_EQ_KIND.value=k_h_value;
        document.form.TRSP_SO_EQ_KIND.value='A';
    }else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
        document.form.TRSP_SO_EQ_KIND.value='Y';
    }else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
        document.form.TRSP_SO_EQ_KIND.value='A';
    }else if(colName == 'to_loc_value' && k_h_value == 'F') {
        document.form.TRSP_SO_EQ_KIND.value='N';
    }
    switch(colName){
        case 'delflag':
        case 'ibcheck':
            toggleCheckBundle(sheetObj, row, col);
            break;
        case 'fm_loc_value':
        	if (sheetObj.GetCellValue(row, colName) != "") {
        		getYardSheetCombo(sheetObj, document.form, row, 'fm_yard_value', sheetObj.GetCellValue(row, colName));
                sheetObj.SetCellValue(row, 'ibcheck','1',0);
        	} else {
        		sheetObj.SetCellValue(row, 'fm_yard_value', '', 0); // Yard 초기화
        	}
        	break;
        case 'to_loc_value':
        	if (sheetObj.GetCellValue(row, colName) != "") {
        		getYardSheetCombo(sheetObj, document.form, row, 'to_yard_value', sheetObj.GetCellValue(row, colName));
                sheetObj.SetCellValue(row, 'ibcheck','1',0);
        	} else {
        		sheetObj.SetCellValue(row, 'to_yard_value', '', 0); // Yard 초기화
        	}
            break;
        case 'eq_no':
            if(value == '') {
                sheetObj.SetCellValue(row, 'vndr_abbr_nm','');
                sheetObj.SetCellValue(row, 'lstm_cd','');
                sheetObj.SetCellValue(row, 'ownr_co_cd','');
                sheetObj.SetCellValue(row, 'usr_co_cd','');
                sheetObj.SetCellValue(row, 'mvmt_sts_cd','');
                sheetObj.SetCellValue(row, 'lst_sts_yd_cd','');
                sheetObj.SetCellValue(row, 'mvmt_dt','');
            	return;
            }
            sheetObj.SetCellValue(row, colName,'',0);
            sheetObj.InitCellProperty(row, 'fm_yard_value',{ Type:"Data"} );
            sheetObj.InitCellProperty(row, 'to_yard_value',{ Type:"Data"} );
            sheetObj.SetCellValue(row, colName,value,0);
            if(formObject.kind_chassis[0].checked){
                formObject.f_cmd.value=SEARCH01;
            }else{
                formObject.f_cmd.value=SEARCH02;
            }
            sheetObj.SetCellValue(row, 'eq_tpsz_cd','',0);
            var queryString="row="+row+"&eq_no="+sheetObj.GetCellValue(row, colName)+"&"+TrsFrmQryString(formObject);
            sheetObj.DoRowSearch( row,"ESD_TRS_0014GS.do", queryString, {Sync:2});
            if (ComTrim(sheetObj.GetCellValue(row, 'eq_tpsz_cd')) == ''){
                ComShowCodeMessage('COM12161', value);
                sheetObj.SelectCell(row, colName);
                sheetObj.SetCellValue(row, 'fm_loc_value','',0);
                sheetObj.SetCellValue(row, 'fm_yard_value','',0);
            }
            if(!checkEqTypeSizeByBundle(sheetObj)){
                sheetObj.SetCellValue(row, 'eq_no','');
                sheetObj.SetCellValue(row, 'eq_tpsz_cd','');
                sheetObj.SetCellValue(row, 'vndr_abbr_nm','');
                sheetObj.SetCellValue(row, 'lstm_cd','');
                sheetObj.SetCellValue(row, 'ownr_co_cd','');
                sheetObj.SetCellValue(row, 'usr_co_cd','');
                sheetObj.SetCellValue(row, 'mvmt_sts_cd','');
                sheetObj.SetCellValue(row, 'lst_sts_yd_cd','');
                sheetObj.SetCellValue(row, 'mvmt_dt','');
                return;
            }
            sheetObj.SetCellValue(row, 'ibcheck','1',0);
            break;
//        case 'eq_tpsz_cd':
//            sheetObj.RemoveEtcData();
//            value=value.toUpperCase();
//            if(formObject.kind_chassis[0].checked) {
//                formObject.f_cmd.value=SEARCH12;
//            }else if(formObject.kind_chassis[1].checked){
//                formObject.f_cmd.value=SEARCH13;
//            }
//            formObject.EQ_TPSZ_CD.value=value;
//            sheetObj.DoRowSearch(row, "ESD_TRS_0014GS.do", TrsFrmQryString(formObject), {Sync:2} );
//            if (sheetObj.GetEtcData("eq_tpsz_cd") == undefined || sheetObj.GetEtcData("eq_tpsz_cd") == ''){
//                ComShowCodeMessage('COM12114', 'Type size Code');
//                sheetObj.SetCellValue( row, col,'',0);
//                return;
//            }
//            sheetObj.SetCellValue(row, 'eq_tpsz_cd',value);
//            if(!checkEqTypeSizeByBundle(sheetObj)){
//                sheetObj.SetCellValue(row, 'eq_tpsz_cd','');
//            }
//            break;
        case 'org_gate_out_date':
            if(value != '' && sheetObj.GetCellValue(row, 'org_gate_out_time')==''){
                sheetObj.SetCellValue(row, 'org_gate_out_time','000000',0);
            }else if(value == ''){
                sheetObj.SetCellValue(row, 'org_gate_out_time','',0);
            }
            break;
        case 'dest_gate_in_date':
            if(value != '' && sheetObj.GetCellValue(row, 'dest_gate_in_time')==''){
                sheetObj.SetCellValue(row, 'dest_gate_in_time','000000',0);
            }else if(value == ''){
                sheetObj.SetCellValue(row, 'dest_gate_in_time','',0);
            }
            break;
    }
    document.form.TRSP_SO_EQ_KIND.value=k_h_value;
}
/**
 * Get a list of external combo box
 */
function getComboList(obj)
{
    var formObj=document.form;
    obj.value=obj.value.toUpperCase();
    if(ComTrim(obj.value) == ''){
    	sheetObjects[0].RemoveAll();
        return;
    }
    /** Set according to the settings ON HIRE * */
    var k_h_value='';
    var k_h=document.form.kind_hire;
    for(var i=0;i<k_h.length;i++)
    {
        if(k_h[i].checked)
        {
            k_h_value=k_h[i].value;
            break;
        }
    }
    formObj.TRSP_SO_EQ_KIND.value=k_h_value;
    
    getYardCombo(hire_yd, sheetObjects[0], formObj, obj.value);
}
/**
 * enter check
 */
function enterCheck(obj)
{
    if(event.keyCode == 13){   getComboList(obj); }
}
/**
 * Bundle seq no return
 */
function getSeqNo()
{
    return seqNo++;
}
/**
 * Tied bundles period between when you click the check box
 */
function toggleCheckBundle(sheetObj, row, col)
{
    var value=sheetObj.GetCellValue(row, col);
    var bundle_seq=sheetObj.GetCellValue(row, 'trsp_so_cmb_seq');
    if(bundle_seq == '') return;
    for(var i=1; i<sheetObj.RowCount()+1; i++)
    {
        if(bundle_seq == sheetObj.GetCellValue(i, 'trsp_so_cmb_seq'))
        {
            sheetObj.SetCellValue(i, col, value);
        }
    }
}
/**
 * retrieve at the click of a button bundle units Restraints
 */
function retrieveBundleUnit(sheetObj)
{
    var formObj=document.form;
    var unit=document.form.bundle_unit.value;
    var set=document.form.bundle_set.value;
    var itemCnt=sheetObj.RowCount();
    if(set=='' || itemCnt< unit ) return;
    var share=Math.floor(Number(itemCnt) / Number(unit));
    if(share > set) share=set; 
    var cnt=1;
    for(var i=0; i<share; i++)
    {
        var seq=getSeqNo();
        for(var j=0; j<unit; j++)
        {
            if(formObj.kind_bundle[1].checked){
                sheetObj.SetCellValue(cnt, 'trsp_so_cmb_tp_cd','BS');
            }else if(formObj.kind_bundle[2].checked){
                sheetObj.SetCellValue(cnt, 'trsp_so_cmb_tp_cd','BF');
            }
            sheetObj.SetCellValue(cnt++, 'trsp_so_cmb_seq',seq);
        }
    }
}
/**
 * Click button to add a single unit to ADD
 */
function addSingleUnit()
{
    var obj=document.form;
    var sheetObj=sheetObjects[0];
    if(obj.unit_qty.value =='')
    {
        ComShowCodeMessage('COM12114', 'QTY');
        return;
    }
    for(var i=0; i< obj.unit_qty.value; i++)
    {
        sheetObj.DataInsert(-1);
    }
}
/**
 * Click button to add a single unit to ADD
 */
function addBundleUnit()
{
    var obj=document.form;
    var sheetObj=sheetObjects[0];
    if(obj.kind_bundle[0].checked)
    {
        addSingleUnit();
        return;
    }
    if(!obj.kind_manual[0].checked || !(obj.kind_bundle[1].checked || obj.kind_bundle[2].checked)) return;
    if(obj.bundle_set.value=='')
    {
        ComShowCodeMessage('COM12114', 'SET');
        return;
    }
    var unit=obj.bundle_unit.value;
    var set=obj.bundle_set.value;
    var sXml = "<SHEET><DATA COLORDER='trsp_so_cmb_seq|trsp_so_cmb_tp_cd'>";
    for(var i=0; i < set; i++)
    {
        var seq=getSeqNo();
        for(var j=0; j<unit; j++)
        {
        	sXml += "<TR>";
        	sXml += "<TD>"+seq+"</TD>";
        	if(obj.kind_bundle[1].checked){
        		sXml += "<TD>BS</TD>";
            }else if(obj.kind_bundle[2].checked){
            	sXml += "<TD>BF</TD>";
            }
        	sXml += "</TR>";
        }
    }
    sXml +="</DATA></SHEET>";
    sheetObj.LoadSearchData(sXml, { Append : 1 });
}
/**
 * bundle
 */
function unBundle(sheetObj, formObj)
{
    if(formObj.kind_chassis[1].checked) return;
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    if(checkList == ''){
        ComShowCodeMessage('COM12176');
        return false;
    }
	for(var k=checkArray.length-1; k>=0; k--) {
		sheetObj.RowDelete(checkArray[k], false);
	}
    for(var i=0; i< checkArray.length; i++) {
        sheetObj.DataInsert(-1);
        sheetObj.SetCellValue(i+1, 1, 1, 0);
    }
}
/**
 * sheet in the item to the bundling
 */
function itemBundling(sheetObj, formObj)
{
    if(formObj.kind_chassis[1].checked){
        ComShowCodeMessage('TRS90064');
        return;
    }
    if(formObj.kind_bundle[0].checked){
        ComShowCodeMessage('TRS90324');
        return;
    }
    if(!checkEqTypeSize(sheetObj)) return;
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    if(checkList == ''){
        ComShowCodeMessage('COM12176');
        return false;
    }
    var unit=document.form.bundle2_unit.value;
    var checkLength=checkArray.length;
    if(checkLength<unit)
    {
        ComShowCodeMessage('TRS90125');
        return;
    }
    unBundle(sheetObj, formObj);
    var share=Math.floor(Number(checkLength) / Number(unit));
    cnt=0;
    var sXml = "<SHEET><DATA COLORDER='ibcheck|trsp_so_cmb_seq|trsp_so_cmb_tp_cd'>";
    for(var i=0; i<share; i++)
    {
        var seq=getSeqNo();
        for(var j=0; j<unit; j++)
        {
        	sXml += "<TR>";
        	sXml += "<TD>1</TD>";
        	sXml += "<TD>"+seq+"</TD>";
        	if(formObj.kind_bundle[1].checked){
        		sXml += "<TD>BS</TD>";
            }else if(formObj.kind_bundle[2].checked){
            	sXml += "<TD>BF</TD>";
            }
        	sXml += "</TR>";
        }
    }
    sXml +="</DATA></SHEET>";
    sheetObj.LoadSearchData(sXml);
    
    for(var i=cnt; i<checkLength; i++){
        sheetObj.SetCellBackColor(checkArray[i], 'trsp_so_cmb_seq',"#EEFFE2");
    }
    cnt=1;
    for(var i=0; i< share*unit; i++)
    {
        if(cnt != checkArray[i]){
            sheetObj.DataMove(cnt++, checkArray[i]);
        }else{
            cnt++;
        }
    }
}
/**
 * check out the list that eq type size to see if there is a duplicate.
 */
function checkEqTypeSize(sheetObj)
{
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var src_type_size='';
    for(var k=1; k<checkArray.length; k++)
    {
        var row=checkArray[k];
        if(sheetObj.GetCellValue(checkArray[0], 'eq_tpsz_cd') != sheetObj.GetCellValue(row, 'eq_tpsz_cd'))
        {
            ComShowCodeMessage('COM12114', 'EQ Type Size');
            return false;
        }
    }
    return true;
}
/**
 * check out the list that eq type size to see if there is a duplicate.
 */
function checkEqTypeSizeByBundle(sheetObj)
{
    var row=sheetObj.GetSelectRow();
    var value=sheetObj.GetCellValue(row, 'eq_tpsz_cd');
    var bun_seq=sheetObj.GetCellValue(row, 'trsp_so_cmb_seq');
    if (bun_seq == '') return true;
    for(var k=1; k<sheetObj.RowCount()+1; k++)
    {
        if(sheetObj.GetCellValue(k, 'trsp_so_cmb_seq') == '') continue;
        if( k != row && 
            bun_seq == sheetObj.GetCellValue(k, 'trsp_so_cmb_seq') &&  
            sheetObj.GetCellValue(k, 'eq_tpsz_cd') != '' &&
            value != sheetObj.GetCellValue(k, 'eq_tpsz_cd') )
        {
            ComShowCodeMessage('COM12114', 'EQ Type Size');
            return false;
        }
    }
    return true;
}
/**
 * number check
 */
function checkNumber(obj, delflag)
{
    if(!ComIsNumber(obj))
    {
        ComShowCodeMessage('COM12122', obj.name);
        if (delflag) obj.value='';
    }
}
/**
 * S / O Creation create whether it within two weeks upon confirmation
 */
function getVerifyColumn(sheetObj)
{
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var returnFlag=true;
    if(checkList == '')
    {
        ComShowCodeMessage('COM12176');
        return false;
    }
    for(var k=0; k<checkArray.length; k++)
    {
        var row=checkArray[k];
        var eq_no=sheetObj.GetCellValue(row, 'eq_no');
        if(sheetObj.GetEtcData(eq_no) != '' &&  sheetObj.GetEtcData(eq_no) != undefined)
        {
            sheetObj.SetCellValue(row, 'verify_result',sheetObj.GetEtcData(eq_no),0);
            sheetObj.SetRowBackColor(row,"#EEFFE2");
            returnFlag=false;
        }
    }
    return returnFlag;
}
/**
 * query condition reset
 */
function resetForm(formObj)
{
    formObj.kind_chassis[0].checked=true;
    formObj.kind_hire[0].checked=true;
    formObj.kind_manual[0].checked=true;
    formObj.kind_bundle[0].checked=true;
    formObj.bundle_unit.options[0].selected=true;
    formObj.bundle_set.value='';
    formObj.unit_qty.value='';
    formObj.todate.value=today;
    formObj.fmdate.value=beforeOneMonth;
    formObj.hire_loc.value='';
    sheetObjects[0].RemoveAll();
    setKindEnabled();
}
/**
 * Common Node popup
 */
function openHireYardPopup(objName)
{   
    var formObject=document.form;
    var cmdt_cd_val="";   // Variables will be available for future use
    var rep_cmdt_cd_val="";   // Variables will be available for future use
    var cmdt_desc_val="";   // Variables will be available for future use
    var classId=objName;
    var xx1="";  // CONTI
    var xx2="";  // SUB CONTI
    var xx3="";  // COUNTRY
    var xx4="";  // STATE
    var xx5="";  // CONTROL OFFIC
    var xx6="";  // LOC CODE
    var xx7="";  // LOC NAME
    var xx8="";
    var xx9="";
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
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
 * Location : If a single selection from a pop-up..
 */
function getCOM_ENS_061_1(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.hire_loc.value=loc;
    getComboList(document.form.hire_loc);
    hire_yd.CODE=yard;
    hire_yd.SetSelectCode(yard);
}
/**
 * MULTIAPPLY Pop-up
 */
function popMultiApply(sheetObj)
{
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    if(checkList == ''){
        ComShowCodeMessage('COM12176');
        return false;
    }
    var myOption="width=550,height=230,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0015.screen';
    myWin=window.open(url, "popMultiApply", myOption);
}
/**
 * MULTIAPPLY Press APPLY to apply in the pop-up window
 */
function setPopupValue(fm_loc, fm_yd, to_loc, to_yd, trans_md, remark, popObj)
{
    var sheetObj=sheetObjects[0];
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    for(var k=0; k<checkArray.length; k++)
    {
        var row=checkArray[k];
        if(ComTrim(fm_loc) != '') sheetObj.SetCellValue(row, 'fm_loc_value',fm_loc);
        if(ComTrim(fm_yd) != '') {
            sheetObj.InitCellProperty(row, 'fm_yard_value',{ Type:"Data"} );
            sheetObj.SetCellValue(row, 'fm_yard_value',fm_yd);
        }
        if(ComTrim(to_loc) != '') sheetObj.SetCellValue(row, 'to_loc_value',to_loc);
        if(ComTrim(to_yd) != '') {
            sheetObj.InitCellProperty(row, 'to_yard_value',{ Type:"Data"} );
            sheetObj.SetCellValue(row, 'to_yard_value',to_yd);
        }
        if(ComTrim(trans_md) != '') sheetObj.SetCellValue(row, 'trsp_crr_mod_cd',trans_md);
        if(ComTrim(remark) != '') sheetObj.SetCellValue(row, 'inter_rmk',remark);
    }
    popObj.closePop();
}
function popEqFileImport(sheetObj, formObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
    var checkArray = checkList.split('|');
    if( checkArray == '' || checkArray == null) {
        ComShowCodeMessage('TRS90036');
        return;
    }
    for(var i=0; i<checkArray.length; i++){
        if(sheetObj.GetCellValue(checkArray[i], 'eq_no') != ''){
            ComShowCodeMessage('TRS90506');
            return;
        }
    }
    var myOption="dialogWidth:500px;dialogHeight:370px;help:no;status:no;resizable:yes;scroll=no;";
    ComOpenWindow("ESD_TRS_0911.do",  window,  myOption , true);
}
function importEqNo(popSheetObj, obj)
{
    var sheetObj=sheetObjects[0];
    var checkList=popSheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var row=0;
    var value='';
    if(document.form.kind_chassis[0].checked){
        document.form.f_cmd.value=SEARCH06;
    }else{
        document.form.f_cmd.value=SEARCH07;
    }
    var queryStr=popSheetObj.GetSaveString(false, false, "ibcheck");
    if(queryStr=='') {
        ComClosePopup(); 
        return false;
    }
    sheetObj.DoSearch("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(document.form),{Append:true} );
    ComClosePopup(); 
}
function setGateOutDate(sheetObj, checkArray){
    var row=0;
    for(var i=0; i<checkArray.length; i++){
        row=checkArray[i];
        if(sheetObj.GetCellValue(row, 'org_gate_out_date') == '') {
            sheetObj.SetCellValue(row, 'org_gate_out_dt','',0);
        }else{
            if(sheetObj.GetCellValue(row, 'org_gate_out_time') == '') {
                sheetObj.SetCellValue(row, 'org_gate_out_time','000000',0);
            }
            sheetObj.SetCellValue(row, 'org_gate_out_dt', sheetObj.GetCellValue(row, 'org_gate_out_date') +   sheetObj.GetCellValue(row, 'org_gate_out_time'));
        }
        if(sheetObj.GetCellValue(row, 'dest_gate_in_date') == '') {
            sheetObj.SetCellValue(row, 'dest_gate_in_dt','',0);
        }else{
            if(sheetObj.GetCellValue(row, 'dest_gate_in_time') == '') {
                sheetObj.SetCellValue(row, 'dest_gate_in_time','000000',0);
            }
            sheetObj.SetCellValue(row, 'dest_gate_in_dt', sheetObj.GetCellValue(row, 'dest_gate_in_date')  +   sheetObj.GetCellValue(row, 'dest_gate_in_time'));
        }
    }
}


function getDateBetween(obj) {
	if(obj.value.length >= 8) {
	    document.form.todate.value=ComGetDateAdd(obj.value,"D", 30, "-");
	}else{
		document.form.todate.value="";
	}
}