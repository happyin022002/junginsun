/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0033.js
*@FileTitle  : Monitoring Port Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    var sheetObj=sheetObjects[0];
    /** **************************************************** */
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
        switch (srcName) {
        case "btn_pop_ctn":
            var cnt_cd=formObj.cnt_cd.value;
            var loc_cd=formObj.loc_cd.value;
            var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
            ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 470, "countryCodeHelp",
                    "1,0,1,1,1,1,1,1", true);
            break;
        case "btn_Retrieve":
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
            break;
        case "btn_save":
            doActionIBSheet(sheetObj, formObj, IBSAVE);
            break;
        case "btn_close":
            ComClosePopup(); 
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
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
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    document.form.cnt_cd.focus();
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    var prefix=sheetID + "_";
    switch (sheetNo) {
    case 1: // sheet1 init
        with(sheetObj){
            var HeadTitle="|Seq.|Country Name|Port|Port Name|VOSI RHQ|Office Code|Monitoring(Y/N)";
            var headCount=ComCountHeadTitle(HeadTitle);
            
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                        {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
                        {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cnt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                        {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:prefix+"loc_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                        {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vskd_port_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sls_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                        {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vop_port_mntr_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
                               
            InitColumns(cols);
            
            SetEditable(1);
            SetCountPosition(0);
            SetSelectionMode(smSelectionList);
            SetSheetHeight(282);
        }

        break;
    }
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBSEARCH: // Retrieve
        if (validateForm(sheetObj, formObj, sAction)) {
            formObj.f_cmd.value=SEARCH;
            sheetObj.SetWaitImageVisible(0);
            var prefix=sheetObj.id + "_";
            var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchData("VOP_VSK_0033GS.do", sParam);
            var vskdPortRhqCd=ComGetEtcData(sXml, "vskdPortRhqCd");
            
            sheetObj.SetColProperty(prefix+"vskd_port_rhq_cd", {ComboText:vskdPortRhqCd, ComboCode:vskdPortRhqCd} );
            sheetObj.SetColProperty(prefix+"vop_port_mntr_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
            
            showSheetData(sheetObj, formObj, sXml);
        }
        break;
    case IBSAVE: // Save
        if (validateForm(sheetObj, formObj, sAction)) {
            formObj.f_cmd.value=MULTI;
            var sParam=ComGetSaveString(sheetObjects, false);
            if (sParam == ""){
                return;
            }
            sParam=sParam + "&" + FormQueryString(formObj);
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var sXml=sheetObj.GetSaveData("VOP_VSK_0033GS.do", sParam);
            sheetObj.LoadSaveData(sXml);
        }
        break;
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH: // Retrieve
        if (ComIsNull(formObj.cnt_cd.value)) {
            ComShowCodeMessage('VSK00027', "Country Code");
            formObj.cnt_cd.focus();
            return false;
        }
        break;
    }
    return true;
}

/**
 * process after retrieve
 * 
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml) {
    if (sXml != null) {
        sheetObj.LoadSearchData(sXml,{Sync:1} );
    }
}

function sheet1_OnSearchEnd(sheetObj) {
    ComOpenWait(false);
    if (sheetObj.RowCount()> 0) {
        for ( var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++) {
            sheetObj.SetRowStatus(i,"U");
        }
    }
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * registering initial event 
 */
function initControl() {
    var formObj=document.form;
    axon_event.addListenerForm('change', 'obj_change', form);
    //axon_event.addListenerForm('keypress', 'obj_keypress', form);
    //axon_event.addListenerForm('keyup', 'obj_keyup', form);
    //axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('focus', 'obj_focus', formObj);
}
function obj_focus() {
    if (ComGetEvent("options")) {
        ComGetEvent("focus");
    } else {
        ComGetEvent("select");
    }
}
function obj_change() {
    var formObj=document.form;
    var eleObj=window.event.srcElement;
    var srcName=eleObj.getAttribute("name");
    try {
        switch (srcName) {
        case "cnt_cd":
            if (eleObj.value.length == 2) {
                formObj.loc_cd.value=formObj.cnt_cd.value;
            }
            break;
        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('VSK00011');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Handling key press event
 */
function obj_keypress() {
    switch (event.srcElement.dataformat) {
    case "float":
        ComKeyOnlyNumber(ComGetEvent(), ".");
        break;
    case "eng":
        ComKeyOnlyAlphabet();
        break;
    case "engdn":
        ComKeyOnlyAlphabet('lower');
        break;
    case "engup":
        var obj=ComGetEvent();
        switch(ComGetEvent("name")) {
        case "loc_nm":
            break;
        default:
            ComKeyOnlyAlphabet('upper');
        }
        break;
    default:
        ComKeyOnlyNumber(ComGetEvent());
    }
}

function obj_keyup() {
    var formObj=document.form;
    var eleObj=window.event.srcElement;
    var srcName=eleObj.getAttribute("name");
    try {
        switch (srcName) {
        case "cnt_cd":
            if (eleObj.value.length == 2) {
                formObj.loc_cd.focus();
                formObj.loc_cd.value=formObj.cnt_cd.value;
            }
            break;
        case "loc_cd":
            if (eleObj.value.length == 5) {
                formObj.loc_nm.focus();
            }
            break;
        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('VSK00011');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Setting Country Code from Location by loc_cd popup
 * 
 * @param rtnObjs
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function countryCodeHelp(rtnObjs, row, col, sheetIdx) {
    var formObj=document.form;
    formObj.cnt_cd.value=rtnObjs[0][3];
    formObj.loc_cd.focus();
    formObj.loc_cd.value=formObj.cnt_cd.value;
}
