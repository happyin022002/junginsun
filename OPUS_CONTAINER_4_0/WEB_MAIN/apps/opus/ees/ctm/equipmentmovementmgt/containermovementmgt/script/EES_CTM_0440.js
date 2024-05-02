/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0440.js
*@FileTitle  : VL/VD correction by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job    */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var toDay="";
var OrgValue="";
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    var formObject=document.form;
    var sheetObject=sheetObjects[0];
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                if (!checkFormField()) return;
                sheetObject.SetWaitImageVisible(0);
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                sheetObject.SetWaitImageVisible(1);
                break;
            case "btn_new":
                DomSetFormObjDisable(formObject, false);
                p_yard2.SetEnable(1);
                ComResetAll();
                //formObject.p_yard1.focus();
                break;
            case "btn_update":
                sheetObject.SetWaitImageVisible(0);
                doActionIBSheet(sheetObject, formObject, IBSAVE);  
                sheetObject.SetWaitImageVisible(1);
                break;
            case "btn_delete":
                var sRowStr=sheetObject.FindCheckedRow("del_chk");
                if (sRowStr == "") {
                 ComShowCodeMessage("CTM30001"); 
                 return ;
                }
                // making as javascripe array
                var arr=sRowStr.split("|");
                var stsCond=formObj.p_status.value ;
                
                for (i=0; i<arr.length ; i++) {
                    if (sheetObject.GetRowEditable(arr[i]) == true) {
                        sheetObject.SetRowStatus(arr[i],"D");// changing selected row's status to 'D' for deleting
                        sheetObject.SetRowHidden(arr[i],1);// hiding selected row
                        var sts=sheetObject.GetCellValue(arr[i], "mvmt_sts_cd");
                        if (stsCond == "VD") {
                            if (sts == "VD") {
                                sheetObject.SetRowStatus(Number(arr[i]) + 1,"D");// changing selected row's status to 'D' for deleting
                                sheetObject.SetRowHidden(Number(arr[i]) + 1,1);// hiding selected row
                            } else if (sts == "IC") {
                                sheetObject.SetRowStatus(arr[i] - 1,"D");// changing selected row's status to 'D' for deleting
                                sheetObject.SetRowHidden(arr[i] - 1,1);// hiding selected row
                            }
                        }
                    }
                }
                break;
            case "btn_Calendar1":
                var cal=new ComCalendar();;
                cal.select(formObject.p_date0, 'yyyy-MM-dd');
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
 * validating when changing date value
 */
function checkDate(obj) {
    obj=ComGetEvent();
    objValue=obj.value;
    // deleting '-'
    objValue=ComGetUnMaskedValue(objValue, "ymd")
    if (!ComIsDateTime(objValue)) {
        ComShowCodeMessage("CTM00001");
        obj.value=objValue;
        obj.select();
        obj.focus();
        return;
    } else {
        objValue=ComGetMaskedValue(objValue, "ymd");
        obj.value=objValue;
        if (obj.name == "p_date1") {
            document.form.p_date2.select();
            document.form.p_date2.focus();
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // initializing IBMultiCombo
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    // setEventProcess : auto creating event
    setEventProcess("p_yard1");
    //axon_event.addListener("keypress", "obj_keypress", "p_yard1");
    //axon_event.addListener("keyup", "yard_Change", "p_yard1");
    document.form.p_yard1.focus();
}
/**
 * setting Combo initial 
 * param : sheetObj, sheetNo
 * adding case as numbers of counting Combos
 */
function initCombo(comboObj, comboNo) {
    var formObject=document.form
    //var comboKey = COUNTRY;
    switch(comboNo) {
        case 1:
            with (comboObj) {
                SetMultiSelect(0);
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "30");
                SetColWidth(1, "200");
                SetBackColor("#EFEFEF");
                SetFontColor("#373737");
                SetColBackColor(0,"#EFEFEF");
                SetColFontColor(0,"#373737");
                SetColBackColor(1,"#EFEFEF");
                SetColFontColor(1,"#373737");
                SetDropHeight(160);
            }
            break;
        case 2:
            with (comboObj) {
                SetMultiSelect(1);
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "30");
                SetColWidth(1, "200");
                SetBackColor("#EFEFEF");
                SetFontColor("#373737");
                SetColBackColor(0,"#EFEFEF");
                SetColFontColor(0,"#373737");
                SetColBackColor(1,"#EFEFEF");
                SetColFontColor(1,"#373737");
                SetDropHeight(160);
            }
            break;
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle1="||Seq.|Container No.|T/S|CYC|STS|A/F|Origin YD|Event Date|VVD Code|Booking No.|Booking No.|Booking No.|B/L No.|F/M|I/O|MSG|TP|DM|D|E|R|R|SP|S/P|S/P|Mode|Update Date (L)|Creation Date (L)|Office|User Name|Remark(s)|CNMV YR|CNMV SEQ|CNT";
                
                SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:5, Page:20, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvl_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_knt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_inp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,    ToolTipText:"Re-stuffing, F(From), T(To)" },
                            {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_yr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_id_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_co_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_xch_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"mgst_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"chss_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"inp_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_split_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pkup_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"wbl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"lst_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vl_date",             KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_svr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                          
                InitColumns(cols);
                
                SetEditable(1);
                //SetColProperty("cnmv_evnt_dt", {Format:"####-##-## ##:##:##"} );
                //SetColProperty("upd_locl_dt", {Format:"####-##-####:##"} );
                //SetColProperty("cre_locl_dt", {Format:"####-##-####:##"} );
                SetCountPosition(0);
                FrozenCols=7;
//                SetSheetHeight(422);
                resizeSheet();
            }

            break;
    }
}
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:     
            sheetObj.RemoveAll();
            //ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("EES_CTM_0440GS.do", FormQueryString(formObj) );
            break;
        case IBSAVE:        
            if(validateForm(sheetObj,formObj,sAction)) {
                //if (sheetObj.isDataModified && sParam1 == "") return;
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI;
                startId=1;
                while (startId <= sheetObj.LastRow()) {
                    queryString=getFastString(sheetObj, startId, sendRows, true);
                    if(queryString[0] == 0 && sendCount == 0) {
                        ComShowCodeMessage("CTM20118");
                        ComOpenWait(false);
                        return;
                    } else if (queryString[0] > 0) {
                        xmlHttpPost ("EES_CTM_0440GS.do", queryString[1] + "&AJAX=Y&" + FormQueryString(formObj), "rtnUpdateParses", startId, true);
                        sendCount++;
                    }
                    startId=Number(queryString[0]) + 1;
                }
                for(var i=1; i<=sheetObj.LastRow(); i++){
                    sheetObj.SetCellValue(i, "del_chk", 0, 0);                	
                }
            }
            break;
    }
}
function rtnUpdateParses(rtnXml, startId) {
    sendCount--;
    var sheetObj=sheetObjects[0];
    if (sendCount < 1) {
        ComOpenWait(false);
    }
}
/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        if (sheetObj.RowCount()> 0) {
            var frmObj=document.form;
            ComBtnEnable("btn_delete", "btn_update");
            sheetObj.ReDraw=false;
            for (i=1; i <= sheetObj.LastRow(); i++ ) {
                cnt=sheetObj.GetCellValue(i, "cnt")
                stsCond=formObj.p_status.value ;
                sts=sheetObj.GetCellValue(i, "mvmt_sts_cd");
                if (stsCond == "VL") {
                    if (cnt != "1" || sts != "VL") {
                        sheetObj.SetRowEditable(i,0);
                        sheetObj.SetCellEditable(i, "cnmv_rmk",1);
                        sheetObj.SetRowBackColor(i,"#B4FCC8");
                        sheetObj.SetCellValue(i, "cnmv_rmk","Next movement already created",0);
                        sheetObj.SetCellValue(i, "lst_flg","");
                        sheetObj.SetRowStatus(i,"R");
                    } else {
                        sheetObj.SetCellValue(i, "lst_flg","1");
                        sheetObj.SetRowStatus(i,"R");
                    }
                } else if (stsCond == "VD") {
                    if (cnt != "2") {
                        if (sheetObj.GetCellValue(i, "mvmt_cre_tp_cd") == "A" || sheetObj.GetCellValue(i, "mvmt_cre_tp_cd") == "C" || sheetObj.GetCellValue(i, "mvmt_cre_tp_cd") == "N") {
                            sheetObj.SetRowHidden(i,1);
                        }
                           sheetObj.SetRowEditable(i,0);
                           sheetObj.SetCellEditable(i, "cnmv_rmk",1);
                           sheetObj.SetRowBackColor(i,"#B4FCC8");
                           sheetObj.SetCellValue(i, "cnmv_rmk","You could delete 'VD' status in case last movement is IC, MT, TS which is automatically created after VD",0);
                           sheetObj.SetCellValue(i, "lst_flg","");
                           sheetObj.SetRowStatus(i,"R");
                    } else {
                        if (sheetObj.GetCellValue(i, "mvmt_cre_tp_cd") == "C") {
                           sheetObj.SetCellValue(i, "lst_flg","");
                           sheetObj.SetRowHidden(i,1);
                           sheetObj.SetRowStatus(i,"R");
                    } else {
                           sheetObj.SetCellValue(i, "lst_flg","1");
                           sheetObj.SetRowStatus(i,"R");
                           }
                    }
                }
                sheetObj.SetCellValue(i, "del_chk", "0", 0);
            }
            //sheetObj.ReDraw=true;
        }
    }

    if (sheetObj.RowCount()> 0) {
        //DomSetFormObjDisable(frmObj, true);
        p_yard2.SetEnable(0);
    }
}
/**
 * event after saving IBSheet 
 * @param {ibsheet} Event     
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg != "[object]") {
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    sts=sheetObj.GetCellValue(Row, "mvmt_sts_cd");
    //vl_date=sheetObj.GetCellValue(Row, "vl_date");
    //cellDate=sheetObj.GetCellText(Row, "cnmv_evnt_dt");
    vl_date=sheetObj.GetCellValue(Row, "vl_date").substring(0,12);
    cellDate=sheetObj.GetCellValue(Row, "cnmv_evnt_dt").substring(0,12);    
    stsCond=formObj.p_status.value ;
    if (vl_date > cellDate) {
        //alert ("Event date should be between previous & following event date")
        ComShowCodeMessage("CTM10025");
        sheetObj.SetCellValue(Row, Col,OrgValue,0);
        clearStatus(sheetObj, Row);
        return;
    }
    var today=new Date();
    var y=today.getFullYear().toString();
    var m=(today.getMonth()+1).toString();
    if (m.length==1) {
        m=0 + m;
    }
    var d=today.getDate().toString();
    if (d.length==1) {
        d=0+d;
    }
    var ymd=y+m+d;
    cellDate=sheetObj.GetCellValue(Row, "cnmv_evnt_dt").substring(0,8);
    if (ymd < cellDate) {
        //alert ("Event date should be between previous & following event date")
        ComShowCodeMessage("CTM10025");
        sheetObj.SetCellValue(Row, Col,OrgValue,0);
        clearStatus(sheetObj, Row);
        return;
    }
    if (sts == "VD" && stsCond == "VD") {
        sheetObj.SetCellValue(Number(Row) + 1, "cnmv_evnt_dt",sheetObj.GetCellValue(Row, "cnmv_evnt_dt"));
    }
    //sheetObj.SetCellValue(Row, 1,1,0);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
    }
    return true;
}
function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
    OrgValue=sheetObj.GetCellText(Row, Col);
}
/**
 * checking yard when changing yard
 */
function yard_Change(event) {
    eventElement=ComGetEvent();
    if (eventElement.value.length < 5) return;
    if (srcValue == eventElement.value) return;
    p_yard2.RemoveAll();
    onShowErrMsg=false;
    var rtn=yard_search();
    if (rtn && svrChk != "S") {
        p_yard2.RemoveAll();
        ComShowCodeMessage("CTM20072");
        eventElement.select();
        //eventElement.focus();
        return;
    }
    if (rtn) {
        if (curKeyCode == "9") {
            curKeyCode="";
            srcValue=ComGetEvent("value");
        } else {
            objTmp=setFocusIndex(eventElement, 1)
            try {
                //objTmp.focus();
            } catch (e) {
            }
            curKeyCode="";
            srcValue=ComGetEvent("value");
            return;
        }
    } else {
        eventElement.select();
        //eventElement.focus();
    }
}
/**
 * event when clicking cell in IBSheet data part
 * @param {sheetObj} String :  IBSheet cell name
 * @param {Row} Long : cell Row Index
 * @param {Col} Long : cell Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : cell x-coordinate
 * @param {CellY} Long : cell y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell length
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    with (sheetObj) {
        if (sheetObj.ColSaveName(Col) != "del_chk") {
            var sRowStr=GetSelectionRows("/");
            var arr=sRowStr.split("/");
            if (arr.length > 1) {
                for (i=0; i<arr.length; i++) {
                    if (sheetObj.GetCellEditable(Row, "del_chk")) {
                    	sheetObj.SetCellValue(arr[i], "del_chk","1",0);
                    }
                }
            }
        } else {
            if (sheetObj.GetRowEditable(Row) == false) {
                ComShowCodeMessage("COM130302"," this data"); 
            }
            if (sheetObj.GetCellValue(Row, "mvmt_sts_cd") == "VD") {
            	sheetObj.SetCellValue(Row + 1, Col,(Value == 0 ? 1 : 0),0);
            }
        }
    }
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}