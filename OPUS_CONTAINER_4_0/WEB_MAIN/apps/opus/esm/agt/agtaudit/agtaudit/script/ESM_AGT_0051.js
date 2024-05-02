// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

//Event handler processing by button click event
document.onclick = processButtonClick;

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]); //Changing Start Environment Setting Method's Name
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //Adding Last Environment Setting method
    }

    // S/A Date Unit Date Setting
    var formObj = document.form;
    var today = ComGetNowInfo();
    var frday = ComGetDateAdd(today, "D", -7);
    formObj.search_dt_fr.value = frday;
    formObj.search_dt_to.value = today;
    formObj.ar_ofc_cd.focus();
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {

                style.height = GetSheetHeight(15);                                                      //setting height
                SheetWidth = mainTable1.clientWidth;                                                    //Whole setting width
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //setting Host information[mandatory][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                                                              //Whole Merge kind [Optional, Default msNone]
                Editable = true;                                                                        //Edit kind [Optional, Default false]
                InitRowInfo(1, 1, 9, 1000);                                                             //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(11, 4, 0, true);                                                         //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, true, true, false, false);                                     //Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle = "STS|CHK|No.|B/L No.|BKG No.|VVD|BKG Sts|BKG Ofc|BKG Date|Comm Cnt|Remarks";
                InitHeadRow(0, HeadTitle, true);

                //Data  properties    [ROW, COL,   DATATYPE,  WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,30,   daCenter,   true,       "ibflag",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtCheckBox,  40,     daCenter,   true,       "check",    false,      "",         dfNone,     0,          true,       false);
                InitDataProperty(0, cnt++, dtSeq,       30,     daCenter,   true,       "seq",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bl_no",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bkg_no",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      80,     daCenter,   true,       "vvd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      55,     daCenter,   true,       "bkg_sts_cd",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    55,     daCenter,   true,       "bkg_ofc_cd",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      75,     daCenter,   true,       "bkg_cre_dt",  false,      "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      65,     daCenter,   true,       "agt_comm_cnt",  false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      300,    daLeft,     true,       "rsn",      false,      "",         dfNone,     0,          false,      false);
            }
            break;
        case 2:      //sheet2 init
            with (sheetObj) {

                style.height = GetSheetHeight(10);                                                      //setting height
                SheetWidth = mainTable2.clientWidth;                                                    //Whole setting width
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //setting Host information[mandatory][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                                                              //Whole Merge kind [Optional, Default msNone]
                Editable = false;                                                                       //Edit kind [Optional, Default false]
                InitRowInfo(2, 1, 9, 1000);                                                             //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(27, 3, 0, true);                                                         //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, false, true, false, false);                                     //Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle1 = "STS|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|PRE AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
                var HeadTitle2 = "STS|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|PRE AMT|Common1|Common2|BRKG|CHF|T/S|T/R|SOC|Cross|DOC|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //Data  properties    [ROW, COL,   DATATYPE,  WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,30,   daCenter,   true,       "ibflag",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtSeq,       30,     daCenter,   true,       "seq",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bl_no",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bkg_no",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      30,     daCenter,   true,       "io_bnd_cd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      80,     daCenter,   true,       "vvd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,     daCenter,   true,       "port",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,     daCenter,   true,       "sail_arr_dt",   false,      "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      35,     daCenter,   true,       "ac_seq",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 70,     daRight,    true,       "pre_amt",   false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 65,     daRight,    false,      "comm1",  false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 65,     daRight,    false,      "comm2",  false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "brkg",     false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "chf",      false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "ts",       false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "tr",       false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "soc",      false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "cross",    false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "doc",      false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,     daRight,    true,       "usd_amt",   false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,     daRight,    true,       "ex_rate",   false,      "",         dfFloat,    4,          false,      false);
                InitDataProperty(0, cnt++, dtData,      40,     daCenter,   true,       "curr_cd",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,     daRight,    true,       "lcl_amt",   false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtData,      45,     daCenter,   true,       "comm_proc_sts_cd",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      500,    daLeft,     true,       "comm_proc_sts_rsn",   false,      "",         dfNone,     0,          true,       false);
                InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,   true,       "ar_ofc_cd",  false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,   true,       "agn_cd",    false,      "",         dfNone,     0,          false,      false);

                RangeBackColor(1,10,1,18) = RgbColor(222, 251, 248);   // Current AMT
            }
            break;
    }
}

/*
 * Event handler processing by button name
 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject,formObj,IBSEARCH);
                break;

            case "btn_recalculate":
                doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
                break;

            case "btn_downexcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;

            case "btn_cal_fr":
            	var cal = new ComCalendar();
				 cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
                break;

            case "btn_cal_to":
            	var cal = new ComCalendar();
                cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
                break;

        } // end switch

    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage("COM12111", "", "");
        } else {
            ComShowMessage(e);
        }
    }
}

/*
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //Retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = SEARCH;
            //alert("http://127.0.0.1:9001/opuscntr/ESM_AGT_0051GS.do?" + agtQryStr(formObj));

            //alert("ESM_AGT_0051GS.do?" + agtQryStr(formObj));
            sheetObj.DoSearch4Post("ESM_AGT_0051GS.do", agtQryStr(formObj));

            sheetObj.SumText(0,1) = "";
            sheetObj.SumText(0,2) = "";
            sheetObj.SumText(0,3) = "TOTAL";

            //Showing the color according to the status
            var rows = sheetObj.RowCount;
            for (var i=0; i<rows; i++) {
                cnt = sheetObj.CellValue(i+1,"agt_comm_cnt");

                if (cnt == "0") {
                    sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
                }
            }

            var sheetObj2 = sheetObjects[1];
            sheetObj2.RemoveAll();

            break;

        case IBSEARCH_ASYNC02:  //Re-calculate
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = REPLY;
            sheetObj.DoSave("ESM_AGT_0051GS.do", agtQryStr(formObj));

            var sheetObj2 = sheetObjects[1];
            sheetObj2.RemoveAll();

            break;

        case IBDOWNEXCEL:   //Down Excel
            sheetObj.SpeedDown2Excel(-1);
            break;
    }
}

/*
 * handling process for Sheet
 */
function doActionIBSheet2(sheetObj,formObj,sAction) {
    var sheetObject2 = sheetObjects[1];
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //Retrieve
            formObj.f_cmd.value = SEARCHLIST;
            param = sheetObj.RowSaveStr(sheetObj.SelectRow);

            sheetObject2.DoSearch4Post("ESM_AGT_0051GS.do", agtQryStr(formObj) + param);

            sheetObject2.SumText(0,1) = "";
            sheetObject2.SumText(0,2) = "";
            sheetObject2.SumText(0,3) = "TOTAL";

            //Showing the color according to the status
            var rows = sheetObject2.RowCount;
            for (var i=0; i<rows; i++) {
                sts = sheetObject2.CellValue(i+2,"status");

                if (sts == "CE") {
                    sheetObject2.RowFontColor(i+2) = sheetObject2.RgbColor(255,0,0); //red
                } else if(sts == "RS" || sts == "RM") {
                    sheetObject2.RowFontColor(i+2) = sheetObject2.RgbColor(0,255,0); //green
                } else if(sts == "AS" || sts == "IF") {
                    sheetObject2.RowFontColor(i+2) = sheetObject2.RgbColor(0,0,255); //blue
                }
            }

            break;
    }
}

// Retrieving Detail information of sheet2 by double clicking sheet1
function sheet1_OnDblClick(sheetObj, row, col) {
    var formObj = document.form;
    doActionIBSheet2(sheetObj,formObj,IBSEARCH);
}

/**
 * Retrieving Subject Office On changing A/R Office.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj1 = sheetObjects[0];
    var sheetObj2 = sheetObjects[1];

    //Grid Reset
    sheetObj1.RemoveAll();
    sheetObj2.RemoveAll();

    //Sub Office ComboBox Setting
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0051FR.do";
    formObj.submit();
}

/**
 * Initializing the grid on changing Subject Office.
 */
function agn_cd_OnChange(obj){
    var sheetObj1 = sheetObjects[0];
    var sheetObj2 = sheetObjects[1];

    //Grid Reset
    sheetObj1.RemoveAll();
    sheetObj2.RemoveAll();
}


/*
 * Setting the text to Whole optional On Focusing.
 */
function search_dt_fr_onfocus(obj){
    if (obj.value.length > 0) {
        delete_Char(obj,'-');   
        obj.select();   
    }
}

/*
 * Setting the text to Whole optional On Focusing.
 */
function search_dt_to_onfocus(obj){
    if (obj.value.length > 0) {
        delete_Char(obj,'-');   
        obj.select();   
    }
}

/**
 * Showing the checked Date when the date is changed
 */
function search_dt_fr_onchange(obj){
    var str = "";

    if (obj.value.length > 0) {
        str = delete_Char(obj.value,'-');
    }

    if (!ComIsDate(obj) && str.length != 0) {
        ComShowCodeMessage("COM12179", "", "", "");
        obj.focus();
    } else {
        if (str.length == 8) {
            obj.value = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
        }
    }
}

/**
 * Showing the checked Date when the date is changed
 */
function search_dt_to_onchange(obj){
    var str = "";

    if (obj.value.length > 0) {
        str = delete_Char(obj.value,'-');
    }

    if (!ComIsDate(obj) && str.length != 0) {
        ComShowCodeMessage("COM12179", "", "", "");
        obj.focus();
    } else {
        if (str.length == 8) {
            obj.value = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
        }
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//        if (!ComIsNumber(iPage)) {
//            return false;
//        }

        switch(sAction) {
            case IBSEARCH:  //Retrieve
                //alert("bl = " + bl.value + ",  selBlNo = " + selBlNo.value);
                if(s_bl_no.value == "" && bl_nos.value == "") {
                    ComShowCodeMessage("COM12113", "B/L", "", "");
                    s_bl_no.focus();
                    return false;
                }

                if(search_dt_fr.value.length > 0 && search_dt_to.value.length > 0 && search_dt_fr.value > search_dt_to.value){
                    //TO DATE must be greater than FROM DATE.
                    ComShowCodeMessage("COM12133", "End date", "start date", "greater");
                    search_dt_fr.focus();
                    return false;
                }

                break;

            case IBSEARCH_ASYNC02:  //Re-calculate
                //Optional check
                var checkCnt = sheetObj.CheckedRows("check");
                if(checkCnt < 1){
                    //Please select **.
                    ComShowCodeMessage("COM12113", "row for re-calculate", "", "");
                    return false;
                }

                //200 check
                if(checkCnt > 200){
                    //Please select **.
                    ComShowCodeMessage("COM12113", "under 200 B/Ls at a time when you re-calculate.", "", "");
                    return false;
                }

                break;

        }
    }

    return true;
}

