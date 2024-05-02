/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0426.js
*@FileTitle  : Release/Re-delivery Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var sheet2_errMsg = "";


// Event handler processing by button click event  */
document.onclick = processButtonClick;

function processButtonClick(){
    var sheetObj=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Calendar":
                var cal=new ComCalendarFromTo();
                cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
                if (!checkFormField()) return;
                doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                break;
            case "btn_new":
                ComResetAll();
                if (comboObjects[0].GetItemCount() > 0) {
                    comboObjects[0].SetSelectIndex(0);
                }
                p_yard2.RemoveAll();
                // button Disable
                ComBtnDisable("btn_settled");
                break;
            case "btn_downExcel":
                sheetObj.Down2Excel({ HiddenColumn:-1});
                break;
            case "btn_settled":
                if(ComGetBtnDisable("btn_settled")){
                    return;
                }
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                doActionIBSheet(sheetObj, frmObj, IBSAVE);    
                ComOpenWait(false);
                sheetObj.SetWaitImageVisible(1);
                break;
            case "btn_preview":
                with (sheetObj) {
                    if (CheckedRows("Sel") < 1) {
                        ComShowCodeMessage("CTM30001");
                        return;
                    } else {
                        var arr=FindCheckedRow("Sel").split("|");
                        for (var i=0; i<arr.length; i++) {
                            //checking empty_cy
                            if (GetCellValue(arr[i], "empty_cy") == "") {
                                ComShowCodeMessage("CTM30002");
                                return;
                            //checking empty_cy in case CheckedRows > 0
                            } else if (i > 0 && GetCellValue(arr[i], "empty_cy") != GetCellValue(arr[0], "empty_cy")) {
                                ComShowCodeMessage("CTM30005");
                                return;
                            //checking pd_date 
                            } else if (GetCellValue(arr[i], "pd_date") == "" || !ComIsDate(GetCellValue(arr[i], "pd_date"))) {
                                ComShowCodeMessage("CTM30003");
                                return;
                            //checking qty
                            } else if (!GetColHidden("qty") && (GetCellValue(arr[i], "qty") == "" || GetCellValue(arr[i], "qty") < 1 || GetCellValue(arr[i], "qty") > GetCellValue(arr[i], "o_qty"))) {
                                ComShowCodeMessage("CTM30004");
                                return;
                            }
                        }
                        ComOpenPopup("EES_CTM_0451.do", 800, 600, "", "0,1", false);
                    }
                    break;
                }
        } // end switch
    } catch(e) {
        if ( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBMultiCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //setEventProcess("yd_cd_disp");
    //axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
    //axon_event.addListener("change", "obj_onchange", "type", "issued");
    // button Disable
    ComBtnDisable("btn_settled");
    sheetObjects[0].SetColHidden("lstm_cd",1);
    doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    document.form.p_date1.focus();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    with(sheetObj){
        var HeadTitle="s|c|No.|I.Office|BD|Mode|Type|POL|POD|Empty CY|S/P|P/D Date|Container No.|Q'ty|O.Q'ty|TP|Term|CB|Empty Dest|Fax No.|E-mail Address|Office|User ID" +
                      "|Issue Date|Fax/E-mail/EDI Result|Booking No.|B/L No.|VVD Code|W/O No.|Special Instruction|SHPR Name|CNEE Name|NTFY Name";
        HeadTitle += "|org_empty_cy|pd_date|tro_seq|bd|type_cd|so_ofc_cty_cd|so_seq|vndr_lgl_eng_nm";

        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },//16
                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"i_office",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bd_disp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mode_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"type_disp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"empty_cy",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N", InputCaseSensitive:1 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"s_p",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pd_date_disp",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"qty",              KeyField:0,   CalcLogic:"",   Format:"Int",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tp",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cb",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"empty_dest",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"email",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"office",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"user_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:0,   SaveName:"issue_dt",         KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"fax_email_rst",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"spcl_inst",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:490 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"shpr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnee",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ntfy",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_empty_cy" },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pd_date" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq" },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bd" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"type_cd" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"so_ofc_cty_cd" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"so_seq" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_lgl_eng_nm" } ];
         
        InitColumns(cols);

        SetSelectionMode(3);
        SetDataAutoTrim(1);
        SetCountPosition(0);
        if (sheetNo == 1) {
//            SetSheetHeight(420);
        	resizeSheet();
        } else {
            SetVisible(0);
        }

    }
}
    
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    var frmObj=document.form;
    switch (sAction) {
        case IBSEARCH:  
            if (validateForm(sheetObj, frmObj, sAction)) {
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                frmObj.office.value=comboObjects[0].GetText(parseInt(comboObjects[0].GetSelectIndex()), 1);
                frmObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("EES_CTM_0426GS.do", FormQueryString(frmObj) );
            }
            break;
        case IBSAVE:    //Settled
            if (validateForm(sheetObj, formObj, sAction)) {
                if (ComShowCodeConfirm("CTM30006")) {
                    frmObj.f_cmd.value=MULTI;
                    sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel");
                }
            }
            break;
        case SEARCH01:    // retrieving TerritoryList for Multicombo by user office code
            var xml=sheetObj.GetSearchData("EES_CTM_0426GS.do", "f_cmd=" + SEARCH01);
            ComXml2ComboItem(xml, comboObjects[0], "cntr_stk_terr_cd", "cntr_stk_terr_txt");
            if (comboObjects[0].GetItemCount() > 0) {
                comboObjects[0].SetSelectIndex(0);
            }
            break;
        case SEARCH02:    
            break;
        case MULTI02:   
            sheet2_errMsg="";    // initializing variables used in RDPopup
            // START LINE : modify 2014-10-15 Sung-Wook Kim
            //frmObj.f_cmd.value=MULTI02;
            //sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel", false);
            if(frmObj.issue_type.value == "D"){
				var sRowStr = sheetObj.FindCheckedRow("Sel");
				var arr = sRowStr.split("|");
            	var xml = sheetObj.GetSearchData("EES_CTM_0426GS.do", "f_cmd=" + MULTI03 + "&empty_cy=" + sheetObj.GetCellValue(arr[0], "empty_cy"));
            	var ediYardSetup = ComGetEtcData(xml, "edi_yard_setup");
            	var yardCd = ComGetEtcData(xml, "yard_cd");
            	//ediYardSetup = 'Y';
            	if(ediYardSetup == "Y"){
	            	frmObj.f_cmd.value = MULTI02;
	                sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel", false);
            	}else{
            		ComShowCodeMessage("CTM30013" , yardCd);
            		sheet2_errMsg = "no EDI connection err"; 
            	}
        	} else {
                frmObj.f_cmd.value = MULTI02;
                sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel", false);
        	}
            // END LINE : modify 2014-10-15 Sung-Wook Kim
            break;
        case COMMAND05:    // retrieving country code by login user office code
            frmObj.sender_usr_cnt.value=ComSearchEtcData(sheetObj, "CTMCommonGS.do", "f_cmd=" + COMMAND05, "rtnValue");
            break;
    }
}
/**
 * handling OnChange event in HTML Object
 */
function obj_onchange(event) {
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    switch(ComGetEvent("name")) {
        // handling by Type option
        case "type":
            with (sheetObj) {
                if (frmObj.type.value == "RDV") {    //in case of Re-Delivery 
                    SetCellText(0, "MTYDest" ,"Empty Org");
                    SetColHidden("qty",1);
                    SetColHidden("q_qty",1);
                    SetColHidden("lstm_cd",0);
                } else {                             //in case of Release
                    SetCellText(0, "MTYDest" ,"Empty Dest");
                    SetColHidden("qty",0);
                    SetColHidden("q_qty",0);
                    SetColHidden("lstm_cd",1);
                }
            }
            break;
        // handling by Issued option
        case "issued":
            if (frmObj.issued.value == "N") {        //in case of No 
                ComBtnDisable("btn_settled");
            } else {    //in case of Yes 
                ComBtnEnable("btn_settled");
            }
            break;
    }
    onShowErrMsg=false;
}
/**
 * handling OnKeyUp event in HTML Object
 */
function obj_onkeyup(event) {
    srcValue=ComGetEvent("value");    
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    switch(ComGetEvent("name")) {
        case "yd_cd_disp":
            var ydCdDisp=frmObj.yd_cd_disp;
            var pYard2=document.getElementById("p_yard2");
            if (ydCdDisp.value.length > 1) {
                frmObj.p_yard1.value=ydCdDisp.value.toUpperCase();
                if (ydCdDisp.value.length > 4) {
                      // calling yard_search() in case inputed 5 characters in p_yard1
                      if (!yard_search()) {
                            ydCdDisp.select();
                            ydCdDisp.focus();
                      } else {
                            frmObj.p_yard2.focus();
                      }
                } else {
                    pYard2.RemoveAll();
                }
            } else {
                frmObj.p_yard1.value="";
                pYard2.RemoveAll();
            }
            break;
    }
    onShowErrMsg=false;
}
/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    if (ErrMsg == "") {
        with (sheetObj) {
            if (RowCount()> 0) {
                for (var i=1; i<RowCount()+1; i++) {
                    if (document.form.issued.value == "Y") {    
                        SetCellEditable(i, "empty_cy",0);
                        SetCellEditable(i, "qty",0);
                    } else {                                    
                        if (GetCellValue(i, "type_cd") != "M") {
                            SetCellEditable(i, "empty_cy",0);
                        }
                    }
                }
            }
        }
    }
    sheetObjects[1].RemoveAll();
    ComOpenWait(false);
    sheetObj.SetWaitImageVisible(1);
}
/**
 * event when clicking cell in IBsheet data part
 * @param {sheetObj} String :  IBSheet cell name
 * @param {Row} Long : cell Row Index
 * @param {Col} Long : cell Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : cell x-coordinate
 * @param {CellY} Long : cell y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell height
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    if (sheetObj.ColSaveName(Col) != "Sel") {
        with(sheetObj) {
            var sRowStr=GetSelectionRows("/");
            var arr=sRowStr.split("/");
            if (arr.length > 1) {
                for (i=0; i<arr.length; i++) {
                    SetCellValue(arr[i], "Sel","1",0);
                }
            }
        }
    }
}
/**
 * handling OnChange event in Sheet
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    var frmObj=document.form;
    with (sheetObj) {
        if (ColSaveName(Col) != "Sel") {
            SetCellValue(Row, "Sel","1",0);
        }
        switch(ColSaveName(Col)) {
            case "empty_cy":
                var xml=sheetObj.GetSearchData("EES_CTM_0426GS.do", "f_cmd=" + SEARCH02 + "&empty_cy=" + GetCellValue(Row, Col));
                if (!ComGetEtcData(xml, "ydCd")) {
                    LoadSearchData(xml,{Sync:1} );
                    SetCellValue(Row, Col, CellSearchValue(Row, Col),0);
                    SelectCell(Row, Col, true);
                } else {
                    SetCellValue(Row, "fax_no",ComGetEtcData(xml, "faxNo"));
                    SetCellValue(Row, "email",ComGetEtcData(xml, "ydEml"));
                }
                break;
            case "pd_date_disp":
                if (!ComIsDate(GetCellText(Row, Col))) {
                    ComShowCodeMessage("CTM00001");
                    SelectCell(Row, Col, true, GetCellValue(Row, "pd_date"));
                } else {
                    SetCellValue(Row, "pd_date",GetCellText(Row, Col),0);
                }
                break;
            case "qty":
                if (GetCellValue(Row, Col) == "" || GetCellValue(Row, Col) < 1 || GetCellValue(Row, Col) > GetCellValue(Row, "o_qty")) {
                    ComShowCodeMessage("CTM30004");
                    SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                }
                break;
        }
    }
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg == "") {
        ComShowCodeMessage("CTM10022", "Release/Redelivery Order");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    sheet2_errMsg=ErrMsg;
}
/**
 * handling OnKeyDown event in territory[combo0] Object
 */
function territory_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}
/**
 * handling OnKeyDown event in p_yard2[combo1] 
 */
function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}
 /**
  * handling process for input validation
  */
function validateForm(sheetObj, formObj, sAction){
    with(formObj){
    }
    return true;
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}
