/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0423.js
*@FileTitle  : Restuffing Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job    */
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
 
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                if (!checkFormField()) return;
                if (!ofcCheck()) return;
                if (checkValidation(formObject))
                    doActionIBSheet(sheetObject,formObject,IBSEARCH)
                break;
            case "btn_new":
                p_reson_op.SetSelectIndex(-1);
                formObject.reset();
                formObject.p_cntrno.value="";
//                formObject.check_digit.value="";
                formObject.p_reson.value="";
                sheetObject.RemoveAll();
                //loadPage();
                comboObjects[0].RemoveAll();                
                break;
            case "btn_Calendar1":
            case "btn_Calendar2":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
                break;
            case "btn_Combo":
             break;
            case "btn_DownExcel":
                if(sheetObject.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1});
                }
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
 * validation
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function checkValidation(formObject) {
   return true
}

/**
 * registering IBCombo Object as list
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    // initializing IBMultiCombo
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }

    cdate=new Date();
    maxYr=cdate.getFullYear();

    // CTM-COMMON (exception)
    setEventProcess("cntrno_disp");
    //axon_event.addListener("keypress", "obj_keypress", "cntrno_disp");
    //axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp");
    doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
    document.form.p_yard1.focus();
}

/**
 * setting Combo initial values
 * param : sheetObj, sheetNo
 * adding case as numbers of counting Combo
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
//                SetFontColor("#373737");
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
//                SetFontColor("#373737");
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
 * handling OnKeyDown event of p_yard2 Object
 */
function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}


/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}

function p_reson_op_OnBlur() {
    strRtn=document.form.p_reson_op_text.value;
    strTmp=strRtn.split(",");
    strRtn="";

    for (i=0; i < strTmp.length; i++) {
        if (i == 0) strRtn="'" + strTmp[i] + "'";
        else strRtn += ",'" + strTmp[i] + "'";
    }

    if (strRtn == '\'\'') strRtn='';

    document.form.p_reson.value=strRtn;
}

/**
 * handling OnKeyDown event of p_reson_op Object
 */
function p_reson_op_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
        case 1:      //t1sheet1 init
        with(sheetObj){
            var HeadTitle1="|Seq.|Object|Object|Object|Object|Object|Object|Replaced|Replaced|Replaced|Replaced|Replaced|Replaced|Date|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Yard|Office|Remark(s)";
            var HeadTitle2="|Seq.|Container No.|T/S|STS|CYC|Booking No.|Booking No.|Container No.|T/S|STS|CYC|Booking No.|Booking No.|Date|BE|CM|DM|DP|ET|OD|OT|OW|OZ|RC|RP|SM|Yard|Office|Remark(s)";
            
            SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5, Page:20, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"HidSta" },
                        {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                        {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_cyc_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no_split",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"xch_cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"xch_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"pre_cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"xch_cntr_cyc_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no_split",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"be",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dp",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"et",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"od",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ot",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ow",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"oz",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rp",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"org_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"xch_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"xch_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                                                          
            InitColumns(cols);
            
            SetEditable(1);
            SetCountPosition(0);
//            SetSheetHeight(460);
            resizeSheet();
        }

        break;
    }
}

//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:     
            if (validateForm(sheetObj,formObj,sAction)) {
                if(sheetObj.id == "sheet1") {
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.DoSearch("EES_CTM_0423GS.do", FormQueryString(formObj) );
                    sheetObj.SetWaitImageVisible(1);
                }
            }
            break;
        case SEARCH02:      
            if(validateForm(sheetObj,formObj,sAction)) {
                formObj.f_cmd.value=SEARCH06;
                xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
                rtnValue=ComGetEtcData(xml, "rtnValue");
                parseYardMultiCombo(rtnValue, comboObjects[1]);
            }
            break;
        }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * handling OnKeyUp event in HTML Object
 */
function obj_onkeyup(event) {
    srcValue=ComGetEvent("value");    
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    switch(ComGetEvent("name")) {
        case "cntrno_disp":
            // handling by length of inputed cntrno_disp
            frmObj.cntrno_disp.value=frmObj.cntrno_disp.value.toUpperCase();
            var cntrnoDisp=frmObj.cntrno_disp;
            if (cntrnoDisp.value.length > 1) {
                frmObj.p_cntrno.value=cntrnoDisp.value;
                if (cntrnoDisp.value.length > 9) {
                    // calling cntr_search() of CTM common function in case of inputting 10 characters in p_cntrno 
                    if (!cntr_search()) {
                    	frmObj.cntrno_disp.value="";
                        frmObj.p_cntrno.value="";
//                        frmObj.check_digit.value="";
                        cntrnoDisp.select();
                        cntrnoDisp.focus();
                    } else {
                        setFocusIndex(ComGetEvent(), 1);
                    }
//                } else {
//                    frmObj.check_digit.value="";
                }
            } else {
                frmObj.p_cntrno.value="";
//                frmObj.check_digit.value="";
            }
            break;
    }

    onShowErrMsg=false;   
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
    }
     return true;
}

/**
 *  OnChange 
 */
function ofcCheck() {
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    var ofc=frmObj.p_office.value ;
    if (ofc != "" ){
        var coCtmXml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH19 + "&code_value=" + ofc + "&column_nm=OFC_CD&table_nm=MDM_ORGANIZATION");
        var rtnValue=ComGetEtcData(coCtmXml, "rtnValue");
        if (rtnValue != "1") {
            ComShowCodeMessage("COM132201", "Office")
            frmObj.p_office.value="";
            return false;
        }else{
            return true;
        } 
    }
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}