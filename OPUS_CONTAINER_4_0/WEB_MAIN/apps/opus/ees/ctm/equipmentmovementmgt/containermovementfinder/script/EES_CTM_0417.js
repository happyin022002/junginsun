/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0417.js
*@FileTitle : EDI Error Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
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
var dataRadioDisable=new Array();
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var frmObj=document.form;
        var sheetObj1=sheetObjects[0];   // sheet1
        var sheetObj2=sheetObjects[1];   // sheet2
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Calendar":
                    //if (!window.event.srcElement.disabled) {
                	if (!ComGetEvent("disabled")) {
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
                    p_yard2.RemoveAll();
                    doActionIBSheet(sheetObj2, frmObj, SEARCH01);
                    break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
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
        for(i=0; i<sheetObjects.length; i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(i=0;i<comboObjects.length;i++){
            initCombo(comboObjects[i], comboObjects[i].options.id);
        }
        // CTM-COMMON (exception)
        setEventProcess("rcc_cd", "lcc_cd", "yd_cd_disp", "data_radio");
        //OnKeyPress event (common function)
        axon_event.addListener('blur', 'obj_keypress', 'yd_cd_disp');
//        axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
        axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
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
        with (sheetObj) {
            switch(sheetNo) {
                case 1:    //sheet1 init
                                        
                    var HeadTitle0="Seq.|RCC|CN|LCC|LOC|Yard|Remained|Remained|Remained|Remained|Remained|Remained|Remained|Solved|Solved|Solved|Solved|Solved|Solved|Initial|Initial|Initial|Initial|Initial|Initial|Initial";
                    var HeadTitle1="Seq.|RCC|CN|LCC|LOC|Yard|Error|%|Ignored|%|OK|%|Total|Error|%|Ignored|%|Total|%|Error|%|Ignored|%|OK|%|Total";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                  { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcc",             KeyField:0,   CalcLogic:"",   Format:"" },
                              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cn",              KeyField:0,   CalcLogic:"",   Format:"" },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lcc",             KeyField:0,   CalcLogic:"",   Format:"" },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"loc",             KeyField:0,   CalcLogic:"",   Format:"" },
                              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yard",            KeyField:0,   CalcLogic:"",   Format:"" },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"corr_err",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"corr_err_ratio",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"corr_ignr",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"corr_ignr_ratio",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"corr_ok",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"corr_ok_ratio",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"corr_ttl",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slvd_err",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"slvd_err_ratio",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slvd_ignr",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"slvd_ignr_ratio",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slvd_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"slvd_ttl_ratio",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"init_err",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"init_err_ratio",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"init_ignr",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"init_ignr_ratio",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"init_ok",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Float",   	 Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"init_ok_ratio",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                              {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"init_ttl",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                              {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"divide" },
                              {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"p_date1" },
                              {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"p_date2" } ];
                     
                    InitColumns(cols);

                    SetEditable(0);
                    SetDataAutoTrim(1);
                    SetCountPosition(0);
                    SetWaitTimeOut(20000);
//                    SetSheetHeight(382);
                    resizeSheet();

                    break;
                case 2:   
                    
                	   var HeadTitle="Container No.|Type/size|Status|I/O status|Event Yard|Event date|receiving date|Error MSG";

                	   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                	   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	   InitHeaders(headers, info);

                	   var cols = [ {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"evnt_dt" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt" },
                	             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_rmk" } ];
                	    
                	   InitColumns(cols);

                	   SetEditable(0);
                	   SetDataAutoTrim(1);
                	   SetCountPosition(0);
                	   SetWaitTimeOut(20000);
                	   SetVisible(0);
                    break;
            }
        }
    }
    /**
     * setting combo text and initial values
     * param : sheetObj, sheetNo
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
            SetUseAutoComplete(1);
            //no support[check again]CLT ValidChar(2, 1);
        }
    }
    // handling process for Sheet
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
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    sheetObj.RemoveAll();
                    ComBtnDisable("btn_Retrieve");
                    ComBtnDisable("btn_New");
                    for (var k=0; k<frmObj.data_radio.length; k++) {
                         dataRadioDisable[k]=frmObj.data_radio[k].disabled;
                    }                    
                    DomSetFormObjDisable(form, true);                    
                    rcc_cd.SetEnable(0);
                    lcc_cd.SetEnable(0);
                    p_yard2.SetEnable(0);
                    frmObj.f_cmd.value=COMMAND01;
                    
                    var sXml=sheetObj.GetSearchData("EES_CTM_0417GS.do", FormQueryString(frmObj));
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                    //alert(backendJobKey);
                    if (backendJobKey.length > 0) {
                        frmObj.backendjob_key.value=backendJobKey;
                        sheetObj.SetWaitTimeOut(20000);
                        timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus in 3 seconds 
                    }
                }
                break;
            case SEARCH01:    // retrieving RCC_CD
                frmObj.f_cmd.value=SEARCH01;
                comboObj=rcc_cd;
                var rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(frmObj));
                if (rtn == "") return;
                rtn=ComGetEtcData(rtn, "rtn");
                var rtnList=rtn.split("^");
                //comboObj.RemoveAll();
                sheetObj.RemoveAll();
                idxSelect="";
                
                for (var i=0; i<=rtnList.length; i++) {
                	
                    if (rtnList[i]) {
                        rtnValue=rtnList[i].split("|");                        
                        comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);                        
                        if (rtnValue[1] == "1") {                        	
                        		idxSelect=rtnValue[0];
                        }
                    }
                }
                
                comboObj.InsertItem(comboObj.GetItemCount(), "ALL", "");
                
                if (idxSelect == "") {                	
                    comboObj.SetSelectText("ALL", true);
                } else {                	
                    comboObj.SetSelectText(idxSelect, true);
                }
                // setting LCC_CD 
                doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
                break;
            case SEARCH02:    // retrieving LCC_CD
                frmObj.f_cmd.value=SEARCH02;
                //comboObj=frmObj.lcc_cd;
                comboObj=lcc_cd;
                var rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(frmObj));
                if (rtn == "") return;
                rtn=ComGetEtcData(rtn, "rtn");
                var rtnList=rtn.split("^");
                comboObj.RemoveAll();
                //sheetObj.RemoveAll();
                comboObj.InsertItem(0, "", "");
                for (i=0; i<=rtnList.length; i++) {
                    if (rtnList[i]) {
                        rtnValue=rtnList[i].split("|");
                        comboObj.InsertItem(i+1, rtnValue[0], rtnValue[0]);
                    }
                }
                break;
            case COMMAND02:
                sheetObj.DoSearch  ("EES_CTM_0417GS.do", queryString + "&f_cmd=" + COMMAND02, { Sync : 1 } );
                break;
        }
    }

    function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        if(sheetObj.RowCount() < 1){
    		ComShowCodeMessage("COM132501");
    	}else{
    		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
    	}
    }
    /**
     * modifying sheet col format
     */
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
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var frmObj=document.form;
        rcc_cd.SetEnable(1);
        lcc_cd.SetEnable(1);
        p_yard2.SetEnable(1);
        DomSetFormObjDisable(frmObj, false);
        for (var k=0; k<frmObj.data_radio.length; k++) {
            frmObj.data_radio[k].disabled=dataRadioDisable[k];
        }
        if (ErrMsg == "") {
            with(sheetObj) {
                if (RowCount()> 0) {
//                    SetRowHidden(LastRow(),1);
                    SetDataLinkMouse("SEQ",0);
                    SetDataLinkMouse("rcc",0);
                    SetDataLinkMouse("cn",0);
                    SetDataLinkMouse("lcc",0);
                    SetDataLinkMouse("loc",0);
                    SetDataLinkMouse("yard",0);
                    SetDataLinkMouse("corr_err_ratio",0);
                    SetDataLinkMouse("corr_ignr_ratio",0);
                    SetDataLinkMouse("corr_ok_ratio",0);
                    SetDataLinkMouse("slvd_err_ratio",0);
                    SetDataLinkMouse("slvd_ignr_ratio",0);
                    SetDataLinkMouse("slvd_ttl_ratio",0);
                    SetDataLinkMouse("init_err_ratio",0);
                    SetDataLinkMouse("init_ignr_ratio",0);
                    SetDataLinkMouse("init_ok_ratio",0);
                	
					var corrErr = GetCellValue(LastRow(), "corr_err");
					var corrIgnr = GetCellValue(LastRow(), "corr_ignr");
					var corrOk = GetCellValue(LastRow(), "corr_ok");
					var corrTtl = GetCellValue(LastRow(), "corr_ttl");
					var slvdErr = GetCellValue(LastRow(), "slvd_err");
					var slvdIgnr = GetCellValue(LastRow(), "slvd_ignr");
					var slvdTtl = GetCellValue(LastRow(), "slvd_ttl");
					var initErr = GetCellValue(LastRow(), "init_err");
					var initIgnr = GetCellValue(LastRow(), "init_ignr");
					var initOk = GetCellValue(LastRow(), "init_ok");
					var initTtl = GetCellValue(LastRow(), "init_ttl");
					var initErrIgnr = initErr + initIgnr;
					SetCellValue(LastRow(), "corr_err_ratio", Math.round(corrErr / corrTtl * 1000) / 10);
					SetCellValue(LastRow(), "corr_ignr_ratio", Math.round(corrIgnr / corrTtl * 1000) / 10);
					SetCellValue(LastRow(), "corr_ok_ratio", Math.round(corrOk / corrTtl * 1000) / 10);
					SetCellValue(LastRow(), "slvd_err_ratio", Math.round(slvdErr / initErr * 1000) / 10);
					SetCellValue(LastRow(), "slvd_ignr_ratio", Math.round(slvdIgnr / initIgnr * 1000) / 10);
					SetCellValue(LastRow(), "slvd_ttl_ratio", Math.round(slvdTtl / initErrIgnr * 1000) / 10);
					SetCellValue(LastRow(), "init_err_ratio", Math.round(initErr / initTtl * 1000) / 10);
					SetCellValue(LastRow(), "init_ignr_ratio", Math.round(initIgnr / initTtl * 1000) / 10);
					SetCellValue(LastRow(), "init_ok_ratio", Math.round(initOk / initTtl * 1000) / 10);
					SetCellValue(LastRow(), "rcc", "Total");
					
					frmObj.corr_err.value=corrErr;
					frmObj.corr_err_ratio.value=GetCellValue(LastRow(), "corr_err_ratio") + " %";
					frmObj.init_err.value=initErr;
					frmObj.init_err_ratio.value=GetCellValue(LastRow(), "init_err_ratio") + " %";
					frmObj.init_ttl.value=initTtl;
					
//                    if (frmObj.data_radio[4].checked) {
                        colModify(sheetObj, "corr_err");
                        colModify(sheetObj, "corr_ok");
                        colModify(sheetObj, "corr_ttl");
                        colModify(sheetObj, "init_err");
                        colModify(sheetObj, "init_ok");
                        colModify(sheetObj, "init_ttl");
                        colModify(sheetObj, "corr_ignr");
                        colModify(sheetObj, "slvd_err");
                        colModify(sheetObj, "slvd_ignr");
                        colModify(sheetObj, "slvd_ttl");
                        colModify(sheetObj, "init_ignr");
//                    } else {
//                        SetDataLinkMouse("corr_err",0);
//                        SetDataLinkMouse("corr_ok",0);
//                        SetDataLinkMouse("corr_ttl",0);
//                        SetDataLinkMouse("init_err",0);
//                        SetDataLinkMouse("init_ok",0);
//                        SetDataLinkMouse("init_ttl",0);
//                    }
//                } else {
//                    SetDataLinkMouse("corr_err",0);
//                    SetDataLinkMouse("corr_ok",0);
//                    SetDataLinkMouse("corr_ttl",0);
//                    SetDataLinkMouse("init_err",0);
//                    SetDataLinkMouse("init_ok",0);
//                    SetDataLinkMouse("init_ttl",0);
                }
            }
        }
        ComBtnEnable("btn_Retrieve");
        ComBtnEnable("btn_New");
        ComOpenWait(false);
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
                        SetCellValue(Row, "divide",ColSaveName(Col),0);
    	                if (RowSaveStr(Row) == "") {
    	                	doActionIBSheet(sheetObjects[1], frmObj, COMMAND02, RowSaveStr(Row) + "&divide=" + GetCellValue(Row, "divide") + "&rcc=" + GetCellValue(Row, "rcc") + "&slvd_cnt_dt=" + frmObj.slvd_cnt_dt.value + "&data_radio=" + frmObj.data_radio.value + "&rcc_cd=" + frmObj.rcc_cd.value + "&lcc_cd=" + frmObj.lcc_cd.value + "&p_yard1=" + frmObj.p_yard1.value + "&p_yard2=" + frmObj.p_yard2.value + "&p_date1=" + frmObj.p_date1.value + "&p_date2=" + frmObj.p_date2.value);
    	                } else {
    	                	doActionIBSheet(sheetObjects[1], frmObj, COMMAND02, RowSaveStr(Row) + "&rcc_cd=" + frmObj.rcc_cd.value + "&lcc_cd=" + frmObj.lcc_cd.value + "&p_yard1=" + frmObj.p_yard1.value + "&p_yard2=" + frmObj.p_yard2.value + "&slvd_cnt_dt=" + frmObj.slvd_cnt_dt.value + "&data_radio=" + frmObj.data_radio.value);
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
        ComShowCodeMessage("CTM10115", "Data");
    }
    /**
     * handling OnChange event of rcc_cd[combo0] Object
     */
    //function rcc_cd_OnChange(comboObj, Index_Code, Text) {
    function rcc_cd_OnChange (comboObj, OldIndex, OldText, OldCode, NewIndex, text, code){
        var frmObj=document.form;
        // setting LCC_CD again
        doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    }
    /**
     * handling OnKeyDown event of rcc_cd[combo0] Object
     */
    function rcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    /**
     * handling OnChangeevent of lcc_cd[combo1] Object
     */
    //function lcc_cd_OnChange(comboObj, Index_Code, Text) {
    function lcc_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code){
        var frmObj=document.form;
        if (Text == "") {
            if (frmObj.yd_cd_disp.value.length < 1) {
                // HTML Object Enable
                ComEnableObject(frmObj.data_radio[0], true);
                ComEnableObject(frmObj.data_radio[1], true);
            }
        } else {
            // HTML Object Disable
            if (frmObj.data_radio[0].checked || frmObj.data_radio[1].checked) {
                frmObj.data_radio[2].checked=true;
            }
            ComEnableObject(frmObj.data_radio[0], false);
            ComEnableObject(frmObj.data_radio[1], false);
        }
    }
    /**
     * handling OnKeyDown event of lcc_cd[combo1] Object
     */
    function lcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    /**
     * handling OnChange event of p_yard2[combo2] Object
     */
    //function p_yard2_OnChange(comboObj, Index_Code, Text) {
    function p_yard2_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
        var frmObj=document.form;
        if (Text != "") {
            if (frmObj.data_radio[0].checked || frmObj.data_radio[1].checked || frmObj.data_radio[2].checked || frmObj.data_radio[3].checked) {
                frmObj.data_radio[4].checked=true;
            }
            // HTML Object Disable
            ComEnableObject(frmObj.data_radio[0], false);
            ComEnableObject(frmObj.data_radio[1], false);
            ComEnableObject(frmObj.data_radio[2], false);
            ComEnableObject(frmObj.data_radio[3], false);
        }
    }
    /**
     * handling OnKeyDown event of p_yard2[combo2] Object
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    /**
     * handling OnKeyUp event of HTML Object
     */
    function obj_onkeyup(event) {
        srcValue=event.srcElement.value;    
        var frmObj=document.form;
        var sheetObj=sheetObjects[0];
        switch(event.srcElement.name) {
            case "yd_cd_disp":
            	// handling by length of inputed yd_cd_disp
                var ydCdDisp=frmObj.yd_cd_disp;
                if (ydCdDisp.value.length > 0) {
                    frmObj.p_yard1.value=ydCdDisp.value.toUpperCase();
                    if (ydCdDisp.value.length > 4) {
                        // calling yard_search() in case p_yard1 entered 5 characters
                        if (!yard_search()) {
                              ydCdDisp.select();
                              ydCdDisp.focus();
                        } else {
                              frmObj.p_yard2.focus();
                        }
                    } else {
                        // HTML Object Enable
                        ComEnableObject(frmObj.data_radio[3], true);
                        ComEnableObject(frmObj.data_radio[2], true);
                        if (ydCdDisp.value.length < 1) {
                            ComEnableObject(frmObj.data_radio[1], true);
                            if (frmObj.lcc_cd.GetSelectText()== "") {
                                ComEnableObject(frmObj.data_radio[0], true);
                            }
                        }
                        frmObj.p_yard2.RemoveAll();
                    }
                    // HTML Object Disable
                    if (frmObj.data_radio[0].checked || frmObj.data_radio[1].checked || frmObj.data_radio[2].checked) {
                        frmObj.data_radio[3].checked=true;
                    }
                    ComEnableObject(frmObj.data_radio[0], false);
                    ComEnableObject(frmObj.data_radio[1], false);
                    ComEnableObject(frmObj.data_radio[2], false);
                } else {
                    frmObj.p_yard1.value="";
                    p_yard2.RemoveAll();
                    // HTML Object Enable
                    ComEnableObject(frmObj.data_radio[2], true);
                    if (frmObj.lcc_cd.value== "") {
                        ComEnableObject(frmObj.data_radio[1], true);
                        ComEnableObject(frmObj.data_radio[0], true);
                    }
                }
                break;
        }
        onShowErrMsg=false;
    }
    /**
     * calling BackEndJob function
     */
    function getBackEndJobStatus() {
        frmObj=document.form;
        var sheetObj=sheetObjects[0];
        frmObj.f_cmd.value=SEARCH;
         var sXml=sheetObj.GetSearchData("EES_CTM_0417GS.do", FormQueryString(frmObj));
        var jobState=ComGetEtcData(sXml, "jb_sts_flg");
        // alert("sheet1 :::>> jobState : "+jobState);
        if (jobState == "3") {
            getBackEndJobLoadFile();
            clearInterval(timer);
        } else if (jobState == "4") {
            ComOpenWait(false);
            // BackEndJob failed
            ComShowCodeMessage('CTM10024');
            clearInterval(timer);
        } else if (jobState == "5") {
            ComOpenWait(false);
            ComShowCodeMessage('CTM10024');
            clearInterval(timer);
        }
    }
    /**
     * down loading as XML file after end of BackEndJob
     */
    function getBackEndJobLoadFile() {
        frmObj=document.form;
        frmObj.f_cmd.value=SEARCHLIST;
        sheetObjects[0].DoSearch("EES_CTM_0417GS.do", FormQueryString(frmObj));
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, frmObj, sAction){
        with(frmObj){
        }
        return true;
    }
    function resizeSheet(){
            ComResizeSheet(sheetObjects[0], 75);
    }

