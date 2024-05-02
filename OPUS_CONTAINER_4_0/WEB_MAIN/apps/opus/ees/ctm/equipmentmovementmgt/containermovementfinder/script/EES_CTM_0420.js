/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0420.js
*@FileTitle  : EDI Result Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

// Event handler processing by button click event  */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    var sheetObj1=sheetObjects[0];   // sheet1
    var sheetObj2=sheetObjects[1];   // sheet2
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Calendar":
            	var evtObj = ComGetEvent();
                if (!evtObj.disabled) {
                    var cal=new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                }
                break;
            case "btn_Retrieve":
                if (!checkFormField()) return;
                doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                break;
            case "btn_New":
                DomSetFormObjDisable(frmObj, false);
                rcc_cd.SetEnable(1);
                lcc_cd.SetEnable(1);
                p_yard2.SetEnable(1);
                ComResetAll();
                frmObj.p_yard1.value="";	// Yard 값 Reset 수정 by 2015/06/02 황미연
                //p_yard2.RemoveAll();
                // RCC_CD 기본셋팅
                doActionIBSheet(sheetObj2, frmObj, SEARCH01);
                break;
            case "btn_downExcel":
                sheetObj1.SetWaitImageVisible(0);
                if(sheetObj1.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  sheetObj1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1 });
                }
                sheetObj1.SetWaitImageVisible(1);
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
    for(i=0; i<sheetObjects.length; i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for(i=0;i<comboObjects.length;i++){
        initCombo(comboObjects[i], comboObjects[i].options.id);
    }
    // CTM-COMMON
    setEventProcess("rcc_cd", "lcc_cd", "yd_cd_disp", "gap_radio");
    axon_event.addListener('blur', 'obj_onkeyup', 'yd_cd_disp');
//  axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
//    axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
    //axon_event.addListener("click", "obj_onclick", "gap_radio");
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    // focusing on page loading
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
        SetWaitTimeOut(20000);
        if (sheetNo == 1) {    // sheet1 init
            var HeadTitle0="SEQ|RCC|CN|LCC|LOC|Yard|Initial|Initial|Initial|Initial|Initial|Initial|Initial|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)|EDI (Only OK data)";
            var HeadTitle1="SEQ|RCC|CN|LCC|LOC|Yard|Error|%|Ignored|%|OK|%|Total|12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total";
            
            SetConfig( { SearchMode:2, MergeSheet:7, FrozenCol:0, Page:20, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1, Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"}];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcc",              KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cn",               KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lcc",              KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"loc",              KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"yard",             KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"int_err",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"int_err_ratio",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"int_ignr",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"int_ignr_ratio",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"int_ok",           KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"int_ok_ratio",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"int_ttl",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"edi_12h",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"edi_12h_ratio",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"edi_24h",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"edi_24h_ratio",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"edi_48h",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"edi_48h_ratio",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"edi_over",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"edi_over_ratio",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                        {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"edi_ttl",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"divide" },
                        {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"gap_radio" },
                        {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"p_date1" },
                        {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"p_date2" } ];
        } else {    //hidden sheet
            var HeadTitle="Container No.|Type/size|Status|I/O status|Method|Event Yard|Event date|receiving date|Error MSG|GAP";
        
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"method" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_rmk" },
                        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gap" } ];
        }

        InitColumns(cols);
        
        SetEditable(0);
        SetDataAutoTrim(1);
        SetCountPosition(0);
        SetWaitImageVisible(0);
//        SetSheetHeight(382);
        resizeSheet();
    }
}

/**
 * setting combo Text, Value
 * param : comboObj ==> combo object, comboNo ==> combo seq
 */
function initCombo(comboObj, comboId) {
    with (comboObj) {
        SetUseAutoComplete(1);
        //no support[check again]CLT ValidChar(2, 1);
    }
}

//handling process for Sheet
function doActionIBSheet(sheetObj, frmObj, sAction, queryString) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:    
            if (validateForm(sheetObj, frmObj, sAction)) {
                if (ComGetUnMaskedValue(ComGetDateAdd(frmObj.p_date1.value, "M", 3), "ymd") < ComGetUnMaskedValue(frmObj.p_date2.value, "ymd")) {
                    ComShowCodeMessage("CTM30012", "3 months");
                    frmObj.p_date1.focus();
                    return;
                }
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                sheetObj.RemoveAll();
                sheetObjects[1].RemoveAll();
                frmObj.edi_12h.value="";
                frmObj.edi_12h_ratio.value="";
                frmObj.edi_24h.value="";
                frmObj.edi_24h_ratio.value="";
                frmObj.edi_48h.value="";
                frmObj.edi_48h_ratio.value="";
                frmObj.edi_over.value="";
                frmObj.edi_over_ratio.value="";
                frmObj.edi_ttl.value="";
                ComBtnDisable("btn_Retrieve");
                ComBtnDisable("btn_New");
                //DomSetFormObjDisable(frmObj, true);
                rcc_cd.SetEnable(0);
                lcc_cd.SetEnable(0);
                p_yard2.SetEnable(0);
                frmObj.f_cmd.value=COMMAND01;
                var sXml=sheetObj.GetSearchData("EES_CTM_0420GS.do", FormQueryString(frmObj));
                var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey")
                if (backendJobKey.length > 0) {
                    frmObj.backendjob_key.value=backendJobKey;
                    sheetObj.SetWaitTimeOut(10000);
                    timer=setInterval(getBackEndJobStatus, 3000); //executing getBackEndJobStatus function in 3 seconds
                }
            }
            break;
        case SEARCH01:    
            frmObj.f_cmd.value=SEARCH01;
            comboObj=rcc_cd;
            var rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(frmObj));
            if (rtn == "") return;
            rtn=ComGetEtcData(rtn, "rtn");
            var rtnList=rtn.split("^");
            rcc_cd.RemoveAll();
            var idxSelect="";
            for (i=0; i<=rtnList.length; i++) {
                if (rtnList[i]) {
                    rtnValue=rtnList[i].split("|");
                    rcc_cd.InsertItem(i, rtnValue[0].toString(), rtnValue[0].toString());
                    if (rtnValue[1] == "1") idxSelect=rtnValue[0];
                }
            }
            rcc_cd.InsertItem(rcc_cd.GetItemCount(), "ALL", "");
            if (idxSelect == "") {
                rcc_cd.SetSelectText("ALL");
            } else {
                rcc_cd.SetSelectText(idxSelect);
                document.form.rcc_cd_text.value = idxSelect;
            }
            // setting LCC_CD 
            doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
            break;
        case SEARCH02:    // retrieving LCC_CD
            frmObj.f_cmd.value=SEARCH02;
            comboObj=lcc_cd;
            var rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(frmObj));
            if (rtn == "") return;
            rtn=ComGetEtcData(rtn, "rtn");
            var rtnList=rtn.split("^");
            lcc_cd.RemoveAll();
            lcc_cd.InsertItem(0, "", "");
            for (i=0; i<=rtnList.length; i++) {
                if (rtnList[i]) {
                    rtnValue=rtnList[i].split("|");
                    lcc_cd.InsertItem(i+1, rtnValue[0].toString(), rtnValue[0].toString());
                }
            }
            break;
        case COMMAND02:
            sheetObj.DoSearch("EES_CTM_0420GS.do", queryString + "&f_cmd=" + COMMAND02, { Sync : 1 } );
            break;
    }
}

//function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
//    ComOpenWait(false);
//}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    if(sheetObj.RowCount() < 1){//no data
      ComShowCodeMessage("COM132501");
    }else{
      sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
    }
}

function colModify(sheetObj, colName) {
    with (sheetObj) {
        SetCellFont("FontBold", 2, colName, LastRow(), colName,1);
        SetColFontColor(colName,"#0000FF");
        SetDataLinkMouse(colName,1);
    }
}

/**
 * handling OnSearchEnd event in sheet1 object
 */
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg, StCode, StMsg) {
    var frmObj=document.form;
    DomSetFormObjDisable(frmObj, false);
    ComOpenWait(false);
    rcc_cd.SetEnable(1);
    lcc_cd.SetEnable(1);
    p_yard2.SetEnable(1);
    if (ErrMsg == "") {
        with(sheetObj) {
            if (RowCount()> 0) {
//                SetRowHidden(LastRow(),1);
                RenderSheet(0);
                colModify(sheetObj, "int_err");
                colModify(sheetObj, "int_ok");
                colModify(sheetObj, "int_ttl");
                colModify(sheetObj, "edi_12h");
                colModify(sheetObj, "edi_24h");
                colModify(sheetObj, "edi_48h");
                colModify(sheetObj, "edi_over");
                colModify(sheetObj, "edi_ttl");
                colModify(sheetObj, "int_ignr");
                SetDataLinkMouse("SEQ",0);
                SetDataLinkMouse("rcc",0);
                SetDataLinkMouse("cn",0);
                SetDataLinkMouse("lcc",0);
                SetDataLinkMouse("loc",0);
                SetDataLinkMouse("yard",0);
                SetDataLinkMouse("int_err_ratio",0);
                SetDataLinkMouse("int_ignr_ratio",0);
                SetDataLinkMouse("int_ok_ratio",0);
                SetDataLinkMouse("edi_12h_ratio",0);
                SetDataLinkMouse("edi_24h_ratio",0);
                SetDataLinkMouse("edi_48h_ratio",0);
                SetDataLinkMouse("edi_over_ratio",0);
                RenderSheet(1);
                
				var intErr = GetCellValue(LastRow(), "int_err");
				var intIgnr = GetCellValue(LastRow(), "int_ignr");
				var intOk = GetCellValue(LastRow(), "int_ok");
				var intTtl = GetCellValue(LastRow(), "int_ttl");
				var edi12h = GetCellValue(LastRow(), "edi_12h");
				var edi24h = GetCellValue(LastRow(), "edi_24h");
				var edi48h = GetCellValue(LastRow(), "edi_48h");
				var ediOver = GetCellValue(LastRow(), "edi_over");
				SetCellValue(LastRow(), "int_err_ratio", Math.round(intErr / intTtl * 1000) / 10);
				SetCellValue(LastRow(), "int_ignr_ratio", Math.round(intIgnr / intTtl * 1000) / 10);
				SetCellValue(LastRow(), "int_ok_ratio", Math.round(intOk / intTtl * 1000) / 10);
				SetCellValue(LastRow(), "edi_12h_ratio", Math.round(edi12h / intOk * 1000) / 10);
				SetCellValue(LastRow(), "edi_24h_ratio", Math.round(edi24h / intOk * 1000) / 10);
				SetCellValue(LastRow(), "edi_48h_ratio", Math.round(edi48h / intOk * 1000) / 10);
				SetCellValue(LastRow(), "edi_over_ratio", Math.round(ediOver / intOk * 1000) / 10);
				SetCellValue(LastRow(), "rcc", "Total");
				
                frmObj.int_err.value=intErr;
                frmObj.int_err_ratio.value=Math.round(intErr / intTtl * 1000) / 10 + "%";
                frmObj.int_ok.value=intOk;
                frmObj.int_ok_ratio.value=Math.round(intOk / intTtl * 1000) / 10 + "%";
                if (form.gap_radio[1].checked == true) {
                    frmObj.edi_12h.value=edi12h;
                    frmObj.edi_12h_ratio.value=Math.round(edi12h / intOk * 1000) / 10 + "%";
                    frmObj.edi_24h.value="";
                    frmObj.edi_24h_ratio.value="";
                    frmObj.edi_48h.value="";
                    frmObj.edi_48h_ratio.value="";
                    frmObj.edi_over.value=parseInt(edi24h) + parseInt(edi48h) + parseInt(ediOver);
                    frmObj.edi_over_ratio.value=Math.round(parseInt(edi24h) + parseInt(edi48h) + parseInt(ediOver) / intOk * 1000) / 10 + "%";
                    frmObj.edi_ttl.value=intOk;
                } else if (form.gap_radio[2].checked == true) {
                    frmObj.edi_12h.value="";
                    frmObj.edi_12h_ratio.value="";
                    frmObj.edi_24h.value=parseInt(edi12h) + parseInt(edi24h);
                    frmObj.edi_24h_ratio.value=Math.round(parseInt(edi12h) + parseInt(edi24h) / intOk * 1000) / 10 + "%";
                    frmObj.edi_48h.value="";
                    frmObj.edi_48h_ratio.value="";
                    frmObj.edi_over.value=parseInt(edi48h) + parseInt(ediOver);
                    frmObj.edi_over_ratio.value=Math.round(parseInt(edi48h) + parseInt(ediOver) / intOk * 1000) / 10 + "%";
                    frmObj.edi_ttl.value=intOk;
                } else if (form.gap_radio[3].checked == true) {
                    frmObj.edi_12h.value="";
                    frmObj.edi_12h_ratio.value="";
                    frmObj.edi_24h.value="";
                    frmObj.edi_24h_ratio.value="";
                    frmObj.edi_48h.value=parseInt(edi12h) + parseInt(edi24h) + parseInt(edi48h);
                    frmObj.edi_48h_ratio.value=Math.round(parseInt(edi12h) + parseInt(edi24h) + parseInt(edi48h) / intOk * 1000) / 10 + "%";
                    frmObj.edi_over.value=ediOver;
                    frmObj.edi_over_ratio.value=Math.round(ediOver / intOk * 1000) / 10 + "%";
                    frmObj.edi_ttl.value=intOk;
                } else {
                    frmObj.edi_12h.value=edi12h;
                    frmObj.edi_12h_ratio.value=Math.round(edi12h / intOk * 1000) / 10 + "%";
                    frmObj.edi_24h.value=edi24h;
                    frmObj.edi_24h_ratio.value=Math.round(edi24h / intOk * 1000) / 10 + "%";
                    frmObj.edi_48h.value=edi48h;
                    frmObj.edi_48h_ratio.value=Math.round(edi48h / intOk * 1000) / 10 + "%";
                    frmObj.edi_over.value=ediOver;
                    frmObj.edi_over_ratio.value=Math.round(ediOver / intOk * 1000) / 10 + "%";
                    frmObj.edi_ttl.value=intOk;
                }
            } else {
                DomSetFormObjDisable(frmObj, false);
                rcc_cd.SetEnable(1);
                lcc_cd.SetEnable(1);
                p_yard2.SetEnable(1);
                frmObj.int_err.value="";
                frmObj.int_err_ratio.value="";
                frmObj.int_ok.value="";
                frmObj.int_ok_ratio.value="";
                frmObj.edi_12h.value="";
                frmObj.edi_12h_ratio.value="";
                frmObj.edi_24h.value="";
                frmObj.edi_24h_ratio.value="";
                frmObj.edi_48h.value="";
                frmObj.edi_48h_ratio.value="";
                frmObj.edi_over.value="";
                frmObj.edi_over_ratio.value="";
                frmObj.edi_ttl.value="";
            }
        }
    }
    ComBtnEnable("btn_Retrieve");
    ComBtnEnable("btn_New");
    sheetObj.SetWaitImageVisible(1);
}

/**
 * handling OnDblClick event in sheet1 object
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
    var frmObj=document.form;
    with (sheetObj) {
    	if (GetDataLinkMouse(Col)) {
	    	if (GetCellValue(Row, Col) < 1) {
	                    return;
	        } else if (GetCellValue(Row, Col) > 10000) {
	            ComShowCodeMessage("CTM20112");
	            return;
	        } else {
	            if (ComShowCodeConfirm("CTM30006")) {
	                if (ColSaveName(Col).substring(0, 4) == "int_") {
	                    sheetObjects[1].SetColHidden("method",1);
	                    sheetObjects[1].SetColHidden("mvmt_edi_rmk",0);
	                    sheetObjects[1].SetColHidden("gap",1);
	                } else {
	                    sheetObjects[1].SetColHidden("method",0);
	                    sheetObjects[1].SetColHidden("mvmt_edi_rmk",1);
	                    sheetObjects[1].SetColHidden("gap",0);
	                }
	                SetCellValue(Row, "divide",ColSaveName(Col),0);
	                if (RowSaveStr(Row) == "") {
	                	doActionIBSheet(sheetObjects[1], frmObj, COMMAND02, RowSaveStr(Row) + "&divide=" + GetCellValue(Row, "divide") + "&rcc=" + GetCellValue(Row, "rcc") + "&gap_radio=" + frmObj.gap_radio.value + "&rcc_cd=" + frmObj.rcc_cd.value + "&lcc_cd=" + frmObj.lcc_cd.value + "&p_yard1=" + frmObj.p_yard1.value + "&p_yard2=" + frmObj.p_yard2.value + "&p_date1=" + frmObj.p_date1.value + "&p_date2=" + frmObj.p_date2.value);
	                } else {
	                	doActionIBSheet(sheetObjects[1], frmObj, COMMAND02, RowSaveStr(Row) + "&rcc_cd=" + frmObj.rcc_cd.value + "&lcc_cd=" + frmObj.lcc_cd.value + "&p_yard1=" + frmObj.p_yard1.value + "&p_yard2=" + frmObj.p_yard2.value);
	                }
	            }
	        }
	      } else {
		      return;
		  }
    }
}

/**
 * handling OnDownFinish event in sheet2 object
 */
function sheet2_OnDownFinish(DownloadType, SaveAsName) {
    //ComShowCodeMessage("CTM10115", "Data");
}

/**
 * handling OnChange event in rcc_cd[combo0] Object
 */
function rcc_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
    var frmObj=document.form;
    document.form.rcc_cd_text.value = rcc_cd.GetText(parseInt(rcc_cd.GetSelectIndex()), 0);
    // resetting LCC_CD 
    doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}
function rcc_cd_OnBlur() {
	document.form.rcc_cd_text.value = rcc_cd.GetText(parseInt(rcc_cd.GetSelectIndex()), 0);
}
function lcc_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
    var frmObj=document.form;
    document.form.lcc_cd_text.value = lcc_cd.GetText(parseInt(lcc_cd.GetSelectIndex()), 0);
    // resetting LCC_CD 
    //doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}
//function lcc_cd_OnBlur() {
//	document.form.lcc_cd_text.value = lcc_cd.GetText(parseInt(lcc_cd.GetSelectIndex()), 0);
//}
function p_yard2_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
    var frmObj=document.form;
    document.form.p_yard2_text.value = p_yard2.GetText(parseInt(p_yard2.GetSelectIndex()), 0);
    // resetting LCC_CD 
    //doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}
//function p_yard2_OnBlur() {
//	document.form.p_yard2_text.value = p_yard2.GetText(parseInt(p_yard2.GetSelectIndex()), 0);
//}
/**
 * handling OnKeyDown event in rcc_cd[combo0] Object
 */
function rcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

/**
 * handling OnKeyDown event in lcc_cd[combo1] Object
 */
function lcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

/**
 * handling OnKeyDown event in p_yard2[combo2]
 */
function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
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
            if (ydCdDisp.value.length > 0) {
                frmObj.p_yard1.value=ydCdDisp.value.toUpperCase();
                if (ydCdDisp.value.length > 4) {
                    if (!yard_search()) {
                          ydCdDisp.select();
                          ydCdDisp.focus();
                    } else {
                          //p_yard2.focus();
                    }
                } else {
                    //p_yard2.RemoveAll();
                }
            } else {
                frmObj.p_yard1.value="";
                p_yard2.RemoveAll();
            }
            break;
    }
    onShowErrMsg=false;
}

/**
 * handling OnClick event in HTML Object
 */
function obj_onclick(event) {
    srcValue=ComGetEvent("value");    
    var frmObj=document.form;
    switch(ComGetEvent("name")) {
        case "gap_radio":
            with (sheetObjects[0]) {
                RemoveAll();
                sheetObjects[1].RemoveAll();
                frmObj.edi_12h.value="";
                frmObj.edi_12h_ratio.value="";
                frmObj.edi_24h.value="";
                frmObj.edi_24h_ratio.value="";
                frmObj.edi_48h.value="";
                frmObj.edi_48h_ratio.value="";
                frmObj.edi_over.value="";
                frmObj.edi_over_ratio.value="";
                frmObj.edi_ttl.value="";
                if (form.gap_radio[1].checked == true) {
                    SetColHidden("edi_12h",0);
                    SetColHidden("edi_12h_ratio",0);
                    SetColHidden("edi_24h",1);
                    SetColHidden("edi_24h_ratio",1);
                    SetColHidden("edi_48h",1);
                    SetColHidden("edi_48h_ratio",1);
                } else if (form.gap_radio[2].checked == true) {
                    SetColHidden("edi_12h",1);
                    SetColHidden("edi_12h_ratio",1);
                    SetColHidden("edi_24h",0);
                    SetColHidden("edi_24h_ratio",0);
                    SetColHidden("edi_48h",1);
                    SetColHidden("edi_48h_ratio",1);
                } else if (form.gap_radio[3].checked == true) {
                    SetColHidden("edi_12h",1);
                    SetColHidden("edi_12h_ratio",1);
                    SetColHidden("edi_24h",1);
                    SetColHidden("edi_24h_ratio",1);
                    SetColHidden("edi_48h",0);
                    SetColHidden("edi_48h_ratio",0);
                } else {
                    SetColHidden("edi_12h",0);
                    SetColHidden("edi_12h_ratio",0);
                    SetColHidden("edi_24h",0);
                    SetColHidden("edi_24h_ratio",0);
                    SetColHidden("edi_48h",0);
                    SetColHidden("edi_48h_ratio",0);
                }
            }
            break;
    }
    onShowErrMsg=false;
}

/**
 * BackEndJob calling function
 */
function getBackEndJobStatus() {
    frmObj=document.form;
    var sheetObj=sheetObjects[0];
    frmObj.f_cmd.value=SEARCH;
    var sXml=sheetObj.GetSearchData("EES_CTM_0420GS.do", FormQueryString(frmObj));
    var jobState=ComGetEtcData(sXml, "jb_sts_flg")
    // alert("sheet1 :::>> jobState : "+jobState);
    if (jobState == "3") {
        getBackEndJobLoadFile();
        clearInterval(timer);
    } else if (jobState == "4") {
        // BackEndJob failed
        ComShowCodeMessage('CTM10024');
    } else if (jobState == "5") {
        // already read BackEndJob result file
        ComShowCodeMessage('CTM10024');
    }
}

/**
 * downloading XML file after BackEndJob(Request Expense Inital)
 */
function getBackEndJobLoadFile() {
    frmObj=document.form;
    frmObj.f_cmd.value=SEARCHLIST;
    sheetObjects[0].DoSearch("EES_CTM_0420GS.do", FormQueryString(frmObj));
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, frmObj, sAction){
    with(frmObj){
    }
    return true;
}

function dateCheck() {
    srcValue=ComGetEvent("value");    
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    switch(ComGetEvent("name")) {
        case "p_date1":
            if (frmObj.p_date1.value !="") {
                checkDate(frmObj.p_date1);
              }
        break;
        case "p_date2":
            if (frmObj.p_date2.value !="") {
                checkDate(frmObj.p_date2);  
            }
        break;
    }
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0],75);
}
