/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0430.js
*@FileTitle  : CNTR History Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                btn2Retrieve();
                break;
            case "btn2_save":
                btn2Save();
                break;
            case "btn2_add":
                addRow();
                break;
            case "btn2_delete":
                if (sheetObjects[1].CheckedRows("del_chk") < 1) {
                    ComShowCodeMessage("CTM30001");
                    break;
                } else {
                    btn2Delete();
                }
                break;
            case "btn_close":
                ComClosePopup(); 
                break;
         } // end switch
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheetObj) {
   sheetObjects[sheetCnt++]=sheetObj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // CTM-COMMON
    setEventProcess();
    with (document.form) {
        if (p_cntrno.value != "") {
            doActionIBSheet(sheetObjects[1], document.form, SEARCH02)
        }
        if (auto_flg.value == "Y") {
            p_cntrno.readOnly=true;
            ComBtnDisable("btn_retrieve");
        }
        // focusing on page loading
        p_cntrno.focus();
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    switch (sheetNo) {
        case 1:    // sheet[0] init
            var cnt=0;
            with(sheetObj){
                var HeadTitle="CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|Booking No.|Booking No.|TP|B/L No.|Commodity";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",     Hidden:0,  Width:29,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no" },
                            {Type:"Text",     Hidden:0,  Width:72,   Align:"Center",  ColMerge:0,   SaveName:"vl" },
                            {Type:"Text",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"por_cd" },
                            {Type:"Text",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Relay" },
                            {Type:"Text",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
                            {Type:"Text",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"del_cd" },
                            {Type:"Text",     Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:"" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split" },
                            {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd" },
                            {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetSheetHeight(150);
            }

            break;
        case 2:    //sheet[1] init
            //setting height
            initSheet2();
            break;
    }
}

//handling process for Sheet
function doActionIBSheet(sheetObj, frmObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case SEARCH02:    // retrieving sheet1, sheet2 
            if (validateForm(sheetObj, frmObj, sAction)) {
                sheetObjects[0].SetWaitImageVisible(0);
                sheetObjects[1].SetWaitImageVisible(0);
                ComOpenWait(true);
                sheetObjects[0].RemoveAll();
                sheetObjects[0].RemoveEtcData();
                sheetObjects[1].RemoveAll();
                sheetObjects[1].RemoveEtcData();
                frmObj.f_cmd.value=SEARCH;
                var xml=sheetObj.GetSearchData("EES_CTM_0430GS.do", FormQueryString(frmObj));
                var rtnValue=xml.split("|$$|");
                sheetObjects[0].LoadSearchData(rtnValue[1],{Sync:1} );
                sheetObjects[1].LoadSearchData(rtnValue[0],{Sync:1} );
                
                //if(sheetObjects[1]) {
                sheetObjects[0].SetColFontColor("bkg_no","#0000FF");
                sheetObjects[0].SetColFontUnderline("bkg_no",1);
                sheetObjects[0].SetDataLinkMouse("bkg_no",1);
                sheetObjects[0].SelectCell(sheetObjects[0].RowCount(), 0);
                //}
                sheetObjects[0].SetWaitImageVisible(1);
                sheetObjects[1].SetWaitImageVisible(1);
            }
            break;
        case MULTI:    // saving sheet2 
            if (validateForm(sheetObj, frmObj, sAction)) {
                if (sheetObj.GetSaveString(false) == "") {
                    ComShowCodeMessage("CTM20118");
                    return;
                }
                sheetObj.RemoveEtcData();
                sheetObj.DoSave("EES_CTM_0430GS.do", "f_cmd=" + MULTI);
            }
            break;
    }
}

/**
 * handling OnSearchEnd event in Sheet1
 */
//function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
//    ComOpenWait(false);
//
//    if (Code == "0") {
//        with (sheetObj) {
//            SetColFontColor("bkg_no","#0000FF");
//            SetColFontUnderline("bkg_no",1);
//            SetDataLinkMouse("bkg_no",1);
//            GetSelectCell(LastRow(), 0);
//        }
//    }
//}

/**
 * calling Bkg Inquiry 
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
    var SaveName=sheetObj.ColSaveName(Col);
//    if (SaveName != "bkg_no") return;
    var bkgNo=sheetObj.GetCellValue(Row, SaveName);
    var param="?bkg_no="+ bkgNo + "&isPop=N" + "&pgmNo=ESM_BKG_0079_Q_POP";
    ComOpenPopup("/opuscntr/ESM_BKG_0079_Q_POP.do" + param, 1208, 730, "", "0,1");
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, frmObj, sAction) {
    with (frmObj) {
    }
    return true;
}

/**
 * event after saving IB sheet
 * @param {ibsheet} Event       
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        var rtnStr=sheetObj.GetEtcData("rtnStr");
        if (rtnStr != null && rtnStr != "" && rtnStr !=  "undefined") {
            ComShowMessage(rtnStr);
        } else {
            if (document.form.auto_flg.value == "Y") {
                var opener=window.dialogArguments;
                objSheet=opener.document.form.sheet1;
                for (var lpCnt=1; lpCnt < objSheet.LastRow(); lpCnt++) {
                    var pCntrNo=objSheet.GetCellValue(lpCnt, "cntr_no");
                    var cCntrNo=frmObj.p_cntrno.value;
                    if (cCntrNo == pCntrNo) {
                        objSheet.SetRowEditable(lpCnt,0);
                        rSts=objSheet.GetRowStatus(lpCnt);
                        objSheet.SetCellValue(lpCnt, "mvmt_cre_tp_cd","Y",0);
                        objSheet.SetRowStatus(lpCnt,rSts);
                    }
                }
            }
            ComShowCodeMessage("CTM10022", "CNTR History Update");
        }
        if (document.form.p_cntrno.value != "") {
            doActionIBSheet(sheetObj, document.form, SEARCH02);
        }
    }
}

/**
 * handling OnSearchEnd event in Sheet2
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        if (sheetObj.RowCount()> 0) {
            ComBtnEnable("btn2_add");
            ComBtnEnable("btn2_delete");
            ComBtnEnable("btn2_save");
            row_Editable4Sheet2();
        } else {
            ComBtnDisable("btn2_add");
            ComBtnDisable("btn2_delete");
            ComBtnDisable("btn2_save");
        }
    }
}


/**
 * common_0430.js
 *
 * function deleteCondition(rmSubstr)
 * function deleteRow(sheetObj, Row)
 * function row_Editable4Sheet2()
 * function sheet2_OnChange(sheetObj, Row, Col, Value)
 * function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH)
 */
