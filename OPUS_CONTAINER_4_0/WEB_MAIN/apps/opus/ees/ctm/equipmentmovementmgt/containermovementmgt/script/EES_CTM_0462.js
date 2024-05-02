/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0462.js
*@FileTitle  : Auto-created Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
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
var OrgValue="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    var sheetObj=sheetObjects[0];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                if (document.form.loc_cd.value == '') {
                    ComShowCodeMessage("CTM00000", "LCC/Location");
                    return;
                }
                if (checkFormField())
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
            case "btn_New":
                document.form.reset();
                sheetObjects[0].RemoveAll();
                // initializing date. setting current time as event time
                strTime=new Date();
                y=strTime.getFullYear();
                m=strTime.getMonth() + 1;
                d=strTime.getDate();
                if (m < 10) m="0" + m;
                if (d < 10) d="0" + d;
                document.form.p_date2.value=y + "-" + m + "-" + d;
                document.form.p_date1.value=ComGetDateAdd(document.form.p_date2.value, "D", -15)
                ComBtnDisable("btn_Save");
                ComBtnDisable("btn_eachcntr");
                break;
            case "btn_Calendar":
                var evtObj = ComGetEvent();
                if (!evtObj.disabled) {
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
                }
                break;
            case "btn_Save":
                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
            case "btn_DownExcel":
                if(sheetObjects[0].RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
                }
                break;
            case "btn_eachcntr":
                with (sheetObjects[0]) {
                    if (ComGetLenByByte(GetCellValue(GetSelectRow(), "cntr_no")) > 0) {
                        var cnmvEvntDt=ComGetMaskedValue(GetCellValue(GetSelectRow(), "tar_date").substring(0,8), "ymd");
                        ComOpenPopup("/opuscntr/EES_CTM_0430_POP.do?" +
                        "cntrNo=" + GetCellValue(GetSelectRow() , "cntr_no") + "&" +
//                        "chkDgt=" + GetCellValue(GetSelectRow() , "cntr_no").substring(10, 11) + "&" +
                        "tpSz=" + GetCellValue(GetSelectRow() , "tp_sz") + "&autoFlg=Y", 1020, 682, "", "0,1", true);
                    }
                }
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            alert("지금은 사용하실 수가 없습니다 ");
        } else {
            alert(e);
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
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (i=0;i<comboObjects.length;i++) {
        initCombo(comboObjects[i], comboObjects[i].options.id);
    }
    // initializing date. setting current time as event time
    strTime=new Date();
    y=strTime.getFullYear();
    m=strTime.getMonth() + 1;
    d=strTime.getDate();
    if (m < 10) m="0" + m;
    if (d < 10) d="0" + d;
    document.form.p_date2.value=y + "-" + m + "-" + d;
    document.form.p_date1.value=ComGetDateAdd(document.form.p_date2.value, "D", -15);
    ComBtnDisable("btn_eachcntr");
    ComBtnDisable("btn_Save");
    //setEventProcess("loc_cd");
    //axon_event.addListener("focusout", "yard_Change", "loc_cd");
    //axon_event.addListener("keypress", "obj_keypress", "loc_cd");
}
function yard_Change(event) {
    eventElement=ComGetEvent();
    // alert (obj_keyup(event))
    if (eventElement.value.length < 5) return;
    if (srcValue == eventElement.value) return;
    onShowErrMsg=false;
    rtn=loc_search();
    if (rtn == true && svrChk != 'S') {
        //alert (eventElement.value)
        ComShowCodeMessage("CTM20072");
        eventElement.value='';
        eventElement.select();
        eventElement.focus();
    } else if (rtn == true && svrChk == 'S') {
        document.form.cre_tp_cd.focus();
    } else {
        eventElement.value='';
        eventElement.select();
        eventElement.focus();
    }
}
/**
 * YARD event
 * occuring in case of Yard Code Change or Focus Out
 * true/false return
 */
function loc_search() {
    formObj=document.form;
    p_yard=formObj.loc_cd.value;
    if (p_yard.length >= 5) {
        if (onShowErrMsg) {
            onShowErrMsg=false; 
            return false;
        }
        onShowErrMsg=true; 
        var sheetObj=sheetObjects[0];
        formObj.f_cmd.value=SEARCH11;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj) + "&p_yard1=" + p_yard);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        svrChk=ComGetEtcData(xml, "svrChk");
        if (rtnValue == null) {
            sheetObj.LoadSearchData(xml,{Sync:1} );
            return false;
        } else {
            return true;
        }
    } else return false;
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
        case 1: //t1sheet1 init
            with(sheetObj){
                var HeadTitle1="|Sel.|Seq.|STS|Container No.|T/S|BkgNo.|EQR Ref. No.|Origin Yard|Event Date|Creation Date|Pre STS|Pre Origin Yard|Pre Event Date|Modified||";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tp_sz",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"tar_date",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pre_sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pre_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pre_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"event_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                //SetColProperty("tar_date", {Format:"####-##:## ##:##"} );
                SetCountPosition(0);
//                SetSheetHeight(442);
                resizeSheet();
            }

            break;
    }
}
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:     
            if(validateForm(sheetObj,formObj,sAction)) {
                if (ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "D", 15), 'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
                    ComShowCodeMessage("CTM30012", "15 days");
                    return;
                }
                sheetObj.RemoveAll();
                ComBtnDisable("btn_retrieve");
                ComBtnDisable("btn_New");
                ComBtnDisable("btn_eachcntr");
                DomSetFormObjDisable(form, true);
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                formObj.f_cmd.value=COMMAND01;
                var sXml=sheetObj.GetSearchData("EES_CTM_0462GS.do", FormQueryString(formObj));
                var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey")
                if (backendJobKey.length > 0) {
                    formObj.backendjob_key.value=backendJobKey;
                    sheetObj.SetWaitImageVisible(0);
                    sheetObj.SetWaitTimeOut(10000);
                    timer=setInterval(getBackEndJobStatus, 3000); 
                }
            }
            break;
        case IBSAVE: 
            if (validateForm(sheetObj, formObj, sAction))
                formObj.f_cmd.value=MULTI;
            StrQ=sheetObj.GetSaveString(false);
            if (StrQ == '') {
                ComShowCodeMessage('CTM20118');
                return;
            }
            xml=sheetObj.DoSave("EES_CTM_0462GS.do",  FormQueryString(formObj) );
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            break;
        case IBINSERT: // 입력
            break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
    }
    return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    with (sheetObj) {
        ComOpenWait(false);
        SetCellBackColor(i, "EventDate","#CCFFFD");
    }
}
/**
 * checking BackEndJob until Status='3' 
 */
function getBackEndJobStatus() {
    formObj=document.form;
    var sheetObj1=sheetObjects[0];
    formObj.f_cmd.value=SEARCH;
    sheetObj1.SetWaitImageVisible(0);
    var sXml=sheetObj1.GetSearchData("EES_CTM_0462GS.do",
    FormQueryString(formObj));
    var jobState=ComGetEtcData(sXml, "jb_sts_flg")
    // alert("sheet1 :::>> jobState : "+jobState);
    if (jobState == "3") {
        getBackEndJobLoadFile();
        clearInterval(timer);
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_New");
        ComBtnEnable("btn_eachcntr");
        ComBtnEnable("btn_Save");
    } else if (jobState == "4") {
        ComShowCodeMessage('CTM10024');
        ComOpenWait(false);
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_New");
        SearchEnd(sheetObj1, "")
    } else if (jobState == "5") {
        ComShowCodeMessage('CTM10024');
        ComOpenWait(false);
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_New");
        SearchEnd(sheetObj1, "")
    }
}
function getBackEndJobLoadFile() {
    formObj=document.form;
    formObj.f_cmd.value=SEARCHLIST;
    ComOpenWait(false);
    var sheetObj=sheetObjects[0];
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);
    var sXml = sheetObj.DoSearchFx("EES_CTM_0462GS.do", FormQueryString(formObj) );
    DomSetFormObjDisable(form, false);
}
function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
    OrgValue=sheetObj.GetCellText(Row, Col);
}
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    OrgValue=sheetObj.GetCellText(NewRow, NewCol);
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    var SaveName=sheetObj.ColSaveName(Col);
    if (SaveName == "tar_date") {
        preEvent=sheetObj.GetCellText(Row, "pre_evnt_dt");
        nowEvent=sheetObj.GetCellText(Row, Col);
        srcEvent=sheetObj.GetCellText(Row, "event_dt");
        // initializing date. setting current time as event time
        strTime=new Date();
        y=strTime.getFullYear();
        m=strTime.getMonth() + 1;
        d=strTime.getDate();
        if (m < 10) m="0" + m;
        if (d < 10) d="0" + d;
        hours=strTime.getHours();
        minutes=strTime.getMinutes();
        if (minutes < 10)
            minutes="0" + minutes;
        if (hours < 10)
            hours="0" + hours;
        nowDate=y + "-" + m + "-" + d + " " + hours + ":" + minutes
        if (nowEvent < preEvent) {
            ComShowCodeMessage("CTM10025");
            sheetObj.SetCellValue(Row, Col,OrgValue,0);
            clearStatus(sheetObj, Row);
            return;
        }
        if (nowEvent >= srcEvent) {
            ComShowCodeMessage("CTM10025");
            sheetObj.SetCellValue(Row, Col,OrgValue,0);
            clearStatus(sheetObj, Row);
            return;
        }
        if (nowEvent > nowDate) {
            ComShowCodeMessage("CTM10053");
            sheetObj.SetCellValue(Row, Col,OrgValue,0);
            clearStatus(sheetObj, Row);
            return;
        }
        sheetObj.SetCellValue(Row, "del_chk","1",0);
        if (sheetObj.GetCellValue(Row, "cntr_no") == sheetObj.GetCellValue(Number(Row) + 1, "cntr_no")) {
            if (ComGetUnMaskedValue(OrgValue, 'ymdhm').replace(' ','').replace(':','') == ComGetUnMaskedValue(sheetObj.GetCellValue(Number(Row) + 1, "pre_evnt_dt"), 'ymdhm') && sheetObj.GetCellValue(Row, "sts_cd") == sheetObj.GetCellValue(Number(Row) + 1, "pre_sts")) {
                sheetObj.SetCellValue(Number(Row) + 1, "pre_evnt_dt",nowEvent,0);
                clearStatus(sheetObj, Number(Row) + 1);
            }
        }
    }
}
function initCombo(comboObj, comboId) {
    var frmObj=document.form;
    with (comboObj) {
        switch (comboId) {
            case "stsCombo":    // ComboObject Value Settting
                SetMultiSelect(1);
                SetDropHeight(160);
                InsertItem(0, "ALL", "");
                InsertItem(1, "OP", "OP");
                InsertItem(2, "EN", "EN");
                InsertItem(3, "TN", "TN");
                InsertItem(4, "OC", "OC");
                InsertItem(5, "IC", "IC");
                InsertItem(6, "ID", "ID");
                InsertItem(7, "MT", "MT");
                InsertItem(8, "CP", "CP");
                InsertItem(9, "CT", "CT");
                InsertItem(10, "CE", "CE");
                InsertItem(11, "CO", "CO");
                InsertItem(12, "CI", "CI");
                InsertItem(13, "CD", "CD");
                InsertItem(14, "CM", "CM");
                if (frmObj.sts_cd.value != "") {
                    //Text = ComReplaceStr(frmObj.edi_mvmt_sts_cd.value, "'", "");
                } else {
                    //Text="ALL";
                    //SetSelectText("ALL");
                    //document.form.stsCombo_text.value = "ALL";
                    SetItemCheck(0, true, false);
                    //document.form.sts_cd.value="'" + ComReplaceStr(GetSelectCode(), ",", "', '") + "'";
                    document.form.sts_cd.value="";
                }
                break;
        }
    }
}
/**
 * handling MultiSelection OnCheckClick event in Combo1
 */
function stsCombo_OnCheckClick(comboObj, index, text, code) {
    // CoCtm.multiComboOnCheckClick
    multiComboOnCheckClick(comboObj, index, document.form.sts_cd);
    
/*    
    if (!index==0) { // click combo item except 'ALL'
        if(comboObj.GetSelectCode() == "") { // when unchecked all items
        	document.form.sts_cd.value="";
            comboObj.SetItemCheck(0, true, false);
        } else {                             // when any item remains checked
	        document.form.sts_cd.value="'" + ComReplaceStr(comboObj.GetSelectCode(), ",", "', '") + "'";
	        comboObj.SetItemCheck(0, false, false);
	    }
    } else { // click combo item 'ALL'
    	if(code) { // when checked
	        for(var i=1; i<comboObj.GetItemCount(); i++) {
	            comboObj.SetItemCheck(i, false, false);
	        }
    	}
        document.form.sts_cd.value="";
    }
*/
}

//function stsCombo_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
//  if (!comboObj.GetItemCheck(0) && index==0) {
//}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}