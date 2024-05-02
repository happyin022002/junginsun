/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0304.js
*@FileTitle  : Vessel Information & IGM No. Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                break;
            case "btn_new":
                doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;
            case "btn_save":
                doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;  
            case "btn_delete":
                doActionIBSheet(sheetObject1, formObject, REMOVE);
                break;   
            case "btn_popup1" :
                var sUrl="/opuscntr/ESM_BKG_0334_POP.do?main_page=false";
                //var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0334", 720, 450, true);
                
                ComOpenPopup(sUrl, 1024, 650, "searchPortArrival", "1,0", true);
                
                
                //if (rtnVal != null){
                //    formObject.form1_port_cd.value=rtnVal.cd;
                //}
                break;
            case "btn_popup2" :
                var sUrl="/opuscntr/ESM_BKG_0305_P.do";
               // var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0305", 1010, 430, true);
                
                ComOpenPopup(sUrl, 1024, 650, "searchCFSCode", "1,0", true);
                
                //if (rtnVal != null){
                //    formObject.form1_ida_cfs_id.value=rtnVal.cd;
                //}
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}



function searchPortArrival(rtnVal) {
	if (rtnVal != null) document.form.form1_port_cd.value = rtnVal.cd;
}

function searchCFSCode(rtnVal) {
	if (rtnVal != null) document.form.form1_ida_cfs_id.value = rtnVal.cd;
}


/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //The required events on the screen
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');

    sheet1OnLoadFinish(sheetObjects[0]);
}
/**
 * Event  after loading 
 * @param sheetObj
 * @return
 */
function sheet1OnLoadFinish(sheetObj) {
    var formObj=document.form;
    initSheetData(sheetObjects[0], formObj);
    ComSetFocus(formObj.form1_vvd_cd);
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle1="| |vvd_cd|vsl_cd|skd_voy_no|skd_dir_cd|pod_cd|ida_decl_vsl_no|ida_yr_no|vsl_decl_dt|vsl_nm|call_sgn_no|ida_voy_no|ida_line_no|ida_agn_id|cnt_cd|port_cd|arr_dt|arr_dt2|ida_cfs_id|ib_area_cd|ibd_no|trns_opr_id|crr_agn_cd|ida_mrn_line_opr_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
                var headCount=ComCountHeadTitle(HeadTitle1);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_decl_vsl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_yr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_decl_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"call_sgn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_line_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_agn_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cnt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"port_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"arr_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"arr_dt2",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_cfs_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"bd_area_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ibd_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trns_opr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"crr_agn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_mrn_line_opr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                InitViewFormat(0, "vsl_decl_dt", "yyyymmdd");
                InitViewFormat(0, "arr_dt", "yyyymmdd");
                InitViewFormat(0, "arr_dt2", "yyyymmdd");
                SetSheetHeight(302);
                SetWaitImageVisible(0);
                SetVisible(0);
            }
            break;
    }
}
/**
 * Sheet handling process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH : //Retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            formObj.vvd_cd.value=formObj.form1_vvd_cd.value;
            formObj.pod_cd.value=formObj.form1_pod_cd.value;
            sheetObj.DoSearch("ESM_BKG_0304GS.do", FormQueryString(formObj)  );
            break;
        case IBINSERT : // Insert
            initSheetData(sheetObj, formObj);
            ComSetFocus(formObj.form1_vvd_cd);
            break;
        case IBSAVE :   // Save,Modify
            if(!validateForm(sheetObj,formObj,sAction))return;
            if(formObj.form1_ida_yr_no.value == "") {
                formObj.form1_ida_yr_no.value=ComGetNowInfo("yy").substr(2,2);
            }
            IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI;
            sheetObj.DoSave("ESM_BKG_0304GS.do", FormQueryString(formObj));
            ComOpenWait(false);
            break;
        case REMOVE: // Delete
            if(!validateForm(sheetObj,formObj,sAction))return;
            ComOpenWait(true);
            sheetObj.SetRowStatus(1,"D");
            formObj.f_cmd.value=MULTI;
            formObj.f_cmd_detail.value="D";
            sheetObj.DoSave("ESM_BKG_0304GS.do", FormQueryString(formObj));
            ComOpenWait(false);
            initSheetData(sheetObj, formObj);
            break;
    }
}
// Sheet data initialization
function initSheetData(sheetObj, formObj) {
    sheetObj.RemoveAll();
    sheetObj.DataInsert(-1);
    IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    switch(sAction) {
        case IBSEARCH: { // Retrieve
            if(!ComChkObjValid(formObj.form1_vvd_cd) || !ComChkObjValid(formObj.form1_pod_cd)) return false; 
            break;
        }
        case IBSAVE: { // Save
            //Check the default format
            if (!ComChkValid(formObj)) return false;
            if (formObj.form1_call_sgn_no.value == "") {
                ComShowCodeMessage('BKG00715', "VSL Code(Call Sign)");
                ComSetFocus(formObj.form1_call_sgn_no);
                return false;
            }
            if (formObj.form1_ida_voy_no.value == "") {
                ComShowCodeMessage('BKG00715', "Voyage");
                ComSetFocus(formObj.form1_ida_voy_no);
                return false;
            }
            if (formObj.form1_crr_agn_cd.value == "") {
                ComShowCodeMessage('BKG00715', "Agent Code");
                ComSetFocus(formObj.form1_crr_agn_cd);
                return false;
            }
            if (formObj.form1_port_cd.value == "") {
                ComShowCodeMessage('BKG00715', "Port of Arrival");
                ComSetFocus(formObj.form1_port_cd);
                return false;
            }
            if (formObj.form1_ida_cfs_id.value == "") {
                ComShowCodeMessage('BKG00715', "CFS Code");
                ComSetFocus(formObj.form1_ida_cfs_id);
                return false;
            }
            if(formObj.form1_ida_yr_no.value != "") {
                var yy=parseInt(formObj.form1_ida_yr_no.value); 
                if(ComChkLen(formObj.form1_ida_yr_no.value, 2) != "2" || (yy <= 0 && yy >= 13 ) ) {
                    ComShowCodeMessage('BKG00651', "IGM YEAR");
                    ComSetFocus(formObj.form1_ida_yr_no);
                    return false;                   
                }
            }
            break;
        }
        case REMOVE : { // Delete
            //Check the default format
            if (!ComChkValid(formObj)) return false;
            if(sheetObj.RowCount()== 0) {
                ComShowCodeMessage('BKG00889');
                return false;
            }
            if(sheetObj.RowCount()== 1) {
                if(sheetObj.GetCellValue(1,"vvd_cd") == "" || sheetObj.GetCellValue(1,"pod_cd") == "") {
                    ComShowCodeMessage('BKG00889');
                    return false;
                }
            }
            break;
        }
    } // end switch
    return true;
 }
/**
 * Events after Save
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        if (document.form.f_cmd.value == MULTI && document.form.f_cmd_detail.value != "D") {
            ComShowCodeMessage('BKG00102');
            return false;
        } 
        if(document.form.f_cmd_detail.value == "D") {
            ComShowCodeMessage('BKG00593');
            return false;
        }
    } 
}
/**
 * The event after  Retrieve
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    ComOpenWait(false);
    var formObj = document.form;
    if (ErrMsg == "") {
        if(sheetObj.Rowcount == 0) {
            ComShowCodeMessage('BKG00800');
        }
        if(sheetObj.RowCount()== 1){
            IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
            formObj.form1_vsl_decl_dt.value=ComGetMaskedValue(formObj.form1_vsl_decl_dt.value, "ymd");
            formObj.form1_arr_dt.value=ComGetMaskedValue(formObj.form1_arr_dt.value, "ymd");
            formObj.form1_arr_dt2.value=ComGetMaskedValue(formObj.form1_arr_dt2.value, "ymd");
        } else if(sheetObj.RowCount()== 0){
            initSheetData(sheetObj, formObj);
            formObj.form1_vvd_cd.value=formObj.vvd_cd.value;
            formObj.form1_pod_cd.value=formObj.pod_cd.value;
        }
    } 
}
