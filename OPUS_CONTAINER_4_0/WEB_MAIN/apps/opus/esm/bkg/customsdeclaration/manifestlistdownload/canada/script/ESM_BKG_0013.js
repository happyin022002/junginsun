/*=========================================================
 *Copyright(c) 2014 CyberLogitec All Rights Reserved
 *@FileName : ESM_BKG_0013.js
 *@FileTitle : CndManifestListDownload
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.22
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
    /* */
    var sheetObject=sheetObjects[0];
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0], document.form, SEARCH);
            break;
        case "btn_new":
            doActionIBSheet(sheetObjects[0], document.form, "NEW");
            break;
        case "btn_save":
            doActionIBSheet(sheetObject, formObject, MULTI);
            break;
        case "btn_downexcel":
            if(sheetObject.RowCount() < 1){//no data
              ComShowCodeMessage("COM132501");
            }else{
//              sheetObject.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
              sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
            }
            break;
        case "btn_create":
            doActionIBSheet(sheetObject, formObject, SEARCH11);
            break;
        case "btn_calendar":
            var cal=new ComCalendarFromTo();
            cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
            break;
        case "btn_delete":
			sUrl = "ESM_BKG_1178.do?";
			sParam = "pgmNo=ESM_BKG_1178";
			ComOpenPopup("/opuscntr/ESM_BKG_1178_POP.do?"+sParam, 900, 500, "", "1,0", true);
			break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComFuncErrMsg(e);
        } else {
            ComFuncErrMsg(e);
        }
    }
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
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
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
        sheetObjects[i].SetWaitImageVisible(0);
    }
    
    doActionIBSheet(sheetObjects[0], document.form, INIT);
    axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj 
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    var sheetID = sheetObj.id;



    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
          
          if (location.hostname != "")
          var HeadTitle1="|Sel.|Lane|VVD|Operator|POD|ETA|CRN|||||||";
          var headCount=ComCountHeadTitle(HeadTitle1);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:165,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"crr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cvy_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"is_crn_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"check_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"upd_crn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pre_crr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
           
          InitColumns(cols);

          SetEditable(1);
//          SetColProperty("vps_eta_dt", {Format:"####-##-## ##:##"} );
          SetColProperty("vps_eta_dt", {Format:"YmdHm"} );
                //기능변경[확인요망]:           InitDataValid(0, "cvy_ref_no", vtEngUpOther, "1234567890");
                
//          SetSheetHeight(420);
          resizeSheet();
          }
    break;
    }
}
/**
 * handling process for Sheet
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value=sAction;
    switch (sAction) {
    case INIT: //init
        formObj.s_vps_eta_dt.value=ComGetNowInfo('ymd', '-');
        formObj.e_vps_eta_dt.value=ComGetDateAdd(null, 'd', 14, '-');
        formObj.vps_port_cd.focus();
        formObj.vps_port_cd.value='CA';
        break;
    case "NEW":
        formObj.reset();
        initSheet(sheetObj, 1);
        formObj.s_vps_eta_dt.value=ComGetNowInfo('ymd', '-');
        formObj.e_vps_eta_dt.value=ComGetDateAdd(null, 'd', 14, '-');
        formObj.vps_port_cd.value='CA';
        formObj.vps_port_cd.focus();
        sheetObj.RemoveAll();
        break;
    case SEARCH: //Retrieve
        if (validateForm(sheetObj, formObj, sAction)) {
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchData("ESM_BKG_0013GS.do", FormQueryString(formObj));
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            ComOpenWait(false);
        }
        break;
    case MULTI: //Save
        if (validateForm(sheetObj, formObj, sAction)) {
            formObj.f_cmd.value=MULTI;
            for ( var i=1; i <= sheetObj.RowCount(); i++) {
                if (sheetObj.GetCellValue(i, "upd_crn") != "") {
                    //                          sheetObj.CellValue2(i,"cvy_ref_no") = sheetObj.CellValue(i, "upd_crn");
                }
                if (sheetObj.GetRowStatus(i) == "U" && sheetObj.GetCellValue(i, "is_crn_no") == "0") {
                    sheetObj.SetRowStatus(i,"I");
                }
            }
            var sParam=ComGetSaveString(sheetObj);
            if (sParam == "") {
                ComShowCodeMessage('BKG00743');
                return;
            }
            sParam += "&" + FormQueryString(formObj);
            if (ComShowCodeConfirm("BKG00350")) {
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveData("ESM_BKG_0013GS.do", sParam);
                if (ComBkgErrMessage(sheetObj, sXml)) {
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("ESM_BKG_0013GS.do", FormQueryString(formObj) );
                } else {
                    for ( var i=1; i <= sheetObj.RowCount(); i++) {
                        sheetObj.SetCellEditable(i, "cvy_ref_no",1);
                    }
                }
                ComOpenWait(false);
            }
        }
        break;
    case SEARCH11: // CRN Create
        if (validateForm(sheetObj, formObj, sAction)) {
            if (ComShowCodeConfirm("BKG00390")) {
//                ComOpenWait(true);
//                formObj.f_cmd.value=SEARCH11;
//                var sXml=sheetObj.GetSearchData("ESM_BKG_0013GS.do", FormQueryString(formObj));
//                var sMaxCvyRefNo=ComGetEtcData(sXml, "max_cvy_ref_no");
//                var sPrefix="9525CE";
//                var vIndex=1;
//                var vVsl_cd;
//                var vSkd_voy_no;
//                var vSkd_dir_cd;
                for ( var i=1; i <= sheetObj.RowCount(); i++) {
                    if (sheetObj.GetCellValue(i, "check") == 1) {
                        sheetObj.SetCellValue(i, "cvy_ref_no", sheetObj.GetCellValue(i, "pre_crr"));
                    }
                }
//                ComOpenWait(false);
            }
        }
        break;
    }
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case SEARCH:
        if (!ComChkValid(formObj))
            return false;
        // retrieving after saving in case of existing changed data
        if (sheetObj.IsDataModified()) {
            if (ComShowCodeConfirm("BKG00386")) {
                doActionIBSheet(sheetObj, formObj, MULTI);
                return false;
            }
        }
        //checking null
        if ((ComIsNull(formObj.vps_port_cd) || ComIsNull(formObj.s_vps_eta_dt) || ComIsNull(formObj.e_vps_eta_dt))
                && (ComIsNull(formObj.vvd_cd)) && (ComIsNull(formObj.cvy_ref_no))) {
            ComShowCodeMessage('BKG00626', '(POD and ETA) or (VVD) or (CRN)');
            ComSetFocus(form.vps_port_cd)
            return false;
        }
        break;
    case MULTI:
        for ( var i=1; i <= sheetObj.RowCount(); i++) {
            var vCRN=sheetObj.GetCellValue(i, "cvy_ref_no");
            var vVvd=sheetObj.GetCellValue(i, "vvd_cd");
            var vCrr=sheetObj.GetCellValue(i, "crr_cd");
            var vPreCrr=sheetObj.GetCellValue(i, "pre_crr");
            if (sheetObj.GetRowStatus(i) != "R") {
                if (vPreCrr == "")
                {
                    ComShowMessage('This Operator[' + vCrr + '] does not exist!');
                    return false;
                }
                if (!ComIsNull(vCRN)) {
//                    if (ComChkLen(vCRN, 7) == 1) {
//                        ComShowCodeMessage('BKG00388', 'CRN');
//                        return false;
//                    }
//                    if (vCrr == "YML" || vCrr == "COS") {
//                        if (vCRN.substr(0, 4) != vPreCrr) {
//                            ComShowCodeMessage('BKG00796', vCRN, vVvd, vCrr);
//                            return false;
//                        }
//                    } else {
//                        if (vCRN.substr(0, 6) != vPreCrr + "CE") {
//                            ComShowCodeMessage('BKG00796', vCRN, vVvd, vCrr);
//                            return false;
//                        }
//                    }
                }
            }
        }
        break;
    case SEARCH11:
        var vIsCheck=false;
        for ( var i=1; i <= sheetObj.RowCount(); i++) {
                if (sheetObj.GetCellValue(i, "check") == 1) {
                vIsCheck=true;
                break;
            }
        }
        if (!vIsCheck) {
            ComShowCodeMessage('BKG00333');
            return false;
        }
    }
    return true;
}
/**
 * when inputting search condition
 */
function obj_KeyUp() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcValue=window.event.srcElement.getAttribute("value");
    if ((srcName == "vps_port_cd" || srcName == "slan_cd" || srcName == "crr_cd" || srcName == "vvd_cd")
            && ComChkLen(srcValue, srcMaxLength) == "2") {
        ComSetNextFocus();
    }
}


function sheet1_OnSearchEnd(sheetObj,  ErrMsg){
	
	var formObj = document.form;
	
    for ( var i=1; i <= sheetObj.RowCount(); i++) {
    	if (sheetObj.GetCellValue(i, "check_flag") == "T") {
    		sheetObj.SetCellEditable(i, "check",1);
    	}
   }

}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

