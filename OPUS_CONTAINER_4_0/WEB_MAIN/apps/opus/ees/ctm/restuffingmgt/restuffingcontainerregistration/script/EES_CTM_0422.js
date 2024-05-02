/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0422.js
*@FileTitle  : Restuffing Creation
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
var comboObjects=new Array(); 
var comboCnt=0;
var sheetObjects=new Array();
var sheetCnt=0;
var cntrSts="";
var sheetContainerFlg1=false;
var sheetContainerFlg2=false;
var sheetContainer1=null;
var sheetContainer2=null;
var sheetFrm=0;

// Event handler processing by button click event */
document.onclick=processButtonClick;

var errorRow=-1;
var errorBack=-1;

// Event handler processing by button name */
function processButtonClick() {
    var frm=document.form;
    var obj1=sheetObjects[0];
    var obj2=sheetObjects[1];
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_add":
                obj2.DataInsert(-1);
                lstRow=obj2.LastRow();
                obj1.SetCellValue(1, "cnmv_evnt_dt2",frm.p_date0.value);
              //vvd 값 못 받아오는 에러 수정 2015.05.26 by 황미연
                obj2.SetCellValue(lstRow, "vvd_cd",obj1.GetCellValue(1, "vvd_cd"));
                obj2.SetCellValue(lstRow, "bkg_no",obj1.GetCellValue(1, "bkg_no"));
                obj2.SetCellValue(lstRow, "cnmv_id_no",obj1.GetCellValue(1, "cnmv_id_no"));
                obj2.SetCellValue(lstRow, "cnmv_yr",obj1.GetCellValue(1, "cnmv_yr"));
                obj2.SetCellValue(lstRow, "reson_cd",obj1.GetCellValue(1, "reson_cd"));
                obj2.SetCellValue(lstRow, "org_yd_cd",obj1.GetCellValue(1, "org_yd_cd"));
                obj2.SetCellValue(lstRow, "save_flg","N");
                obj2.SetCellValue(lstRow, "xch_rmk",frm.p_rmk.value);
                obj2.SetCellValue(lstRow, "cnmv_evnt_dt2",frm.p_date0.value);
                ComBtnEnable("btn_del");
                ComBtnDisable("btn_mvmt");
                ComBtnDisable("btn_Calendar1");
//                sheet1.SetEnable(0);
                frm.p_yard1.disabled=true;
                frm.p_date.disabled=true;
                frm.p_time.disabled=true;
                p_reson_op.SetEnable(0);
                p_yard2.SetEnable(0);
                break;
            case "btn_del":
                obj2.RowDelete(obj2.GetSelectRow());
                if (obj2.LastRow()== 0) {
                    ComBtnEnable("btn_mvmt");
  //                  sheet1.SetEnable(1);
                }
                break;
            case "btn_new":
                frm.p_yard1.value="";
                frm.p_yard1.disabled=false;
                frm.p_date.disabled=false;
                frm.p_time.disabled=false;
                p_reson_op.SetEnable(1);
                p_yard2.SetEnable(1);
                p_yard2.SetSelectText(-1, true);
               // p_yard2.RemoveAll();
                p_reson_op.SetSelectText(-1, true);
                frm.p_rmk.value="";
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
               // p_reson_op_OnCheckClick();
      //          sheet1.SetEnable(0);
      //          sheet2.SetEnable(0);
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_mvmt");
                ComBtnDisable("btn_add");
                ComBtnEnable("btn_Calendar1");
                break;
            case "btn_save":
                sheetObjects[0].SetCellValue(1, "xch_rmk",frm.p_rmk.value);
                if (sheetObjects[0].GetCellValue(1, "cntr_tpsz_cd") == '' || sheetObjects[0].GetCellValue(1, "cntr_tpsz_cd").toString() == '-1') {
                    ComShowCodeMessage("CTM10004");
                    return;
                }
                if (p_reson_op.GetSelectText() == "") {
                    ComShowCodeMessage("CTM10049", "reson code");
                    return;
                }
                if (p_yard2.GetSelectText() == '') {
                    ComShowCodeMessage("CTM10049", "yard cd");
                    return;
                }
                for (i=1; i <= sheetObjects[1].LastRow(); i++) {
                    sheetObjects[1].SetCellValue(i, "xch_rmk",frm.p_rmk.value);
                    cntr=sheetObjects[1].GetCellValue(i, "cntr_no");
                    if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == '') {
                        ComShowCodeMessage("CTM10004");
                        return;
                    }
                    for (j=Number(i+1); j <= sheetObjects[1].LastRow(); j++) {
                        if (cntr == sheetObjects[1].GetCellValue(j, "cntr_no")) {
                            ComShowCodeMessage("CTM20098");
                            return;
                        }
                    }
                }
                doActionIBSheet(obj1, frm, IBSAVE);
                break;
            case "btn_mvmt":
                frm.p_yard1.disabled=true;
                frm.p_date.disabled=true;
                frm.p_time.disabled=true;
                ComBtnDisable("btn_Calendar1");
                p_reson_op.SetEnable(0);
                p_yard2.SetEnable(0);
                var yardCd=frm.p_yard1.value + p_yard2.GetSelectText();
                var cntrNo=sheetObjects[0].GetCellValue(1,"cntr_no");
//                var checkDigit=sheetObjects[0].GetCellValue(1,"check_digit");
                var typeSize=sheetObjects[0].GetCellValue(1,"cntr_tpsz_cd");
                var sUrl="EES_CTM_0445.do?cntrNo=" + cntrNo + "&typeSize=" + typeSize + "&yd=" + yardCd;
                var iWidth="720";
                var iHeight="500";
                var bModal=true;
                //p_reson 값 못 받아오는 에러 수정 2015.05.26 by 황미연
                sheetObjects[0].SetCellValue(1, "reson_cd", formObj.p_reson.value, "");
                ComOpenPopup(sUrl, iWidth, iHeight, "setSheetFromMvmtHistoryPopup", "0,1", bModal);
                break;
            case "btn_Calendar1":
                var cal=new ComCalendar();;
                cal.select(frm.p_date, 'yyyy-MM-dd');
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

function setSheetFromMvmtHistoryPopup(rtnValue) {
    var frm=document.form;
    var obj1=sheetObjects[0];
    var obj2=sheetObjects[1];
    if (rtnValue == "" || rtnValue == undefined) return;
    var rtnStr=rtnValue.split("|");
    if (rtnStr.length > 0) {
        obj1.SetCellValue(1, "cntr_seal_no",rtnStr[0], 0);
        obj1.SetCellValue(1, "chss_no",rtnStr[1], 0);
        obj1.SetCellValue(1, "mgst_no",rtnStr[2], 0);
        obj1.SetCellValue(1, "bkg_no",rtnStr[3], 0);
        obj1.SetCellValue(1, "vvd_cd",rtnStr[4], 0);
        obj1.SetCellValue(1, "org_yd_cd",rtnStr[5], 0);
        obj1.SetCellValue(1, "cnmv_id_no",rtnStr[6], 0);
        obj1.SetCellValue(1, "cnmv_yr",rtnStr[7], 0);
        obj1.SetCellValue(1, "mvmt_sts_cd",rtnStr[8], 0);
        obj1.SetCellValue(1, "cntr_no",rtnStr[9], 0);
        obj1.SetCellValue(1, "cntr_tpsz_cd",rtnStr[10], 0);
//        obj1.SetCellValue(1, "check_digit",rtnStr[11], 0);
        obj1.SetCellValue(1, "save_flg","D");	//restuffing container를 MT 상태로 update by 2015/06/01 황미연 
        obj1.SetCellValue(1, "cnmv_evnt_dt2",frm.p_date0.value, 0);
        obj1.SetCellValue(1, "cnmv_evnt_dt",rtnStr[11], 0);
        obj1.SetCellValue(1, "bkg_cgo_tp_cd",rtnStr[12], 0);
        sheetFrm=1;

        var prvdt = obj1.GetCellValue(1, "cnmv_evnt_dt");
        var evntdt = obj1.GetCellValue(1, "cnmv_evnt_dt2");
        if (prvdt > evntdt) {
        	ComShowCodeMessage("CTM30015");
            obj1.RowDelete(1, false);
            obj1.DataInsert();
            obj1.SelectCell(1, "cntr_no", true);
        	return;
        }
        
        for (var xx=1; xx <= obj2.LastRow(); xx++) {
            obj2.SetCellValue(xx, "vvd_cd",obj1.GetCellValue(1, "vvd_cd"), 0);
            obj2.SetCellValue(xx, "bkg_no",obj1.GetCellValue(1, "bkg_no"), 0);
            obj2.SetCellValue(xx, "cnmv_id_no",obj1.GetCellValue(1, "cnmv_id_no"), 0);
            obj2.SetCellValue(xx, "cnmv_yr",obj1.GetCellValue(1, "cnmv_yr"), 0);
            obj2.SetCellValue(xx, "reson_cd",obj1.GetCellValue(1, "reson_cd"), 0);
            obj2.SetCellValue(xx, "org_yd_cd",obj1.GetCellValue(1, "org_yd_cd"), 0);
            obj2.SetCellValue(xx, "save_flg","N", 0);
            obj2.SetCellValue(xx, "xch_rmk",frm.p_rmk.value, 0);
            obj2.SetCellValue(xx, "cnmv_evnt_dt2",frm.p_date0.value, 0);
        }
        ComBtnEnable("btn_add");
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * registering IBCombo Object as list
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
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // initializing IBMultiCombo
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    document.form.p_date.value=ComGetNowInfo();
    document.form.p_time.value=ComGetNowInfo("hm");
    document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
    ComBtnDisable("btn_del");
    ComBtnDisable("btn_mvmt");
    ComBtnDisable("btn_add");
    // OnKeyPress event
    //setEventProcess("p_rmk", "p_time");
    //axon_event.addListener("blur", "yard_Change", "p_yard1");
    //axon_event.addListener("blur", "date_Change", "p_date");
    //axon_event.addListener("focus", "date_focus", "p_date");
    //axon_event.addListener("change", "time_Change", "p_time");
    //axon_event.addListener("keypress", "obj_onkeypress", "p_rmk");
    sheetObjects[0].SetEnable(1);
    sheetObjects[1].SetEnable(1);
    document.form.p_yard1.focus();

    sheet1_OnLoadFinish()
}

/**
* checking date. prohibiting to input the date after today
* @return
*/
function date_Change() {
    obj=document.form.p_date;
    objValue=obj.value;
    // deleting '-'
    objValue=ComGetMaskedValue(objValue, "ymd")
    if (objValue != false) {
        obj.value=objValue;
        if (obj.name == "p_date") {
            //document.form.p_date0.select();
        }
    } else {
        ComShowCodeMessage("CTM00001");
        // obj.value = objValue;
        document.form.p_date.value=ComGetNowInfo();
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
        obj.select();
        obj.focus();
        return;
    }
    document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value
    idx=document.form.p_date0.value;
    offSet=getDateDiff(idx);
    if (offSet >= 1) {
        ComShowCodeMessage("CTM10053");
        // alert ("Event date can't exceed+0 Days from today.");
        document.form.p_date.value=ComGetNowInfo();
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
        obj.select();
        obj.focus();
    }
}
/**
 * checking in case time changed
 * @return
 */
function time_Change() {
    obj=document.form.p_time;
    objValue=obj.value;
    // deleting '-'
    objValue=ComGetMaskedValue(objValue, "hm")
    if (objValue == '') 
    {
        ComShowCodeMessage("CTM00001");
        document.form.p_time.value=ComGetNowInfo("hm");
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
        obj.focus();
        return;
    }
    if (objValue != false) {
        obj.value=objValue;
        if (obj.name == "p_time") {
        }
    } else {
        ComShowCodeMessage("CTM00001");
        document.form.p_time.value=ComGetNowInfo("hm");
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
        obj.select();
        obj.focus();
        return;
    }
    document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value
}

function p_reson_op_OnChange(comObj, OldIndex, OldText, OldCode, s_index,s_text,  s_code) {
    for (i=0; i < 4; i++) {
        obj=document.getElementById("dm"+i);
        obj.value='';
        obj.style.display='none';
        obj=document.getElementById("sm"+i);
        obj.value='';
        obj.style.display='none';
    }
    strRtn=s_code;
    if (strRtn != null && strRtn != "") {
        strTmp=strRtn.split(",");
        strRtn="";
        idx=0;
        for (i=0; i < strTmp.length; i++) {
            if (i >= 4) break;
            if (i == 0) strRtn=strTmp[i];
            else strRtn += "," + strTmp[i];
            strValue=p_reson_op.GetText (strTmp[i], 1);
            obj=document.getElementById("dm"+i);
            obj.value=strValue;
            obj.style.display='';
            obj=document.getElementById("sm"+i);
            obj.value=strTmp[i];
            obj.style.display='';
            idx=i;
        }
        document.form.p_reson.value=strRtn;
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

/**
 * setting Combo initial values
 * param : sheetObj, sheetNo
 * adding case as numbers of counting Combo
 */
function initCombo(comboObj, comboNo) {
    var formObject=document.form
    switch(comboNo) {
        case 1:
            with (comboObj) {
                SetMultiSelect(0);
                SetUseAutoComplete(1);
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "30");
                SetColWidth(1, "200");
                //SetFontColor("#373737");
                SetColBackColor(0,"#7F9DB9");
                SetColFontColor(0,"#373737");
                SetColBackColor(1,"#EFEFEF");
                SetColFontColor(1,"#373737");
                SetDropHeight(160);
            }
            break;
        case 2:
            with (comboObj) {
                SetMultiSelect(1);
                SetUseAutoComplete(1);
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "30");
                SetColWidth(1, "200");
                //SetFontColor("#373737");
                SetColBackColor(0,"#EFEFEF");
                SetColFontColor(0,"#373737");
                SetColBackColor(1,"#EFEFEF");
                SetColFontColor(1,"#373737");
                SetMaxSelect(4);
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
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle="|Seq.|Container No.|TP/SZ|Seal No.|Chassis No.|STS|VVD Code|Booking No.|Booking No.|Id No.|cnmv_yr|reson_cd|org_yd|flg|Previous Event Date";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
//                            {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check_digit",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"reson_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"save_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"xch_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                          
                InitColumns(cols);
                
                SetEditable(1);
                SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//                SetColProperty(0 ,"check_digit" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"mvmt_sts_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"cntr_seal_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"chss_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                
                SetWaitImageVisible(0);
              //  SetFocusEditMode("-1");
                SetShowButtonImage(2);
                SetSheetHeight(140);
            }

            break;
        case 2:      //sheet2 init
            with(sheetObj){
                var HeadTitle="|Seq.|Container No.|TP/SZ|Seal No.|Chassis No.|STS|VVD Code|Booking No.|Id No.|cnmv_yr|reson_cd|org_yd|flg|Previous Event Date";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
//                            {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check_digit",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"reson_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"save_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"xch_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                          
                InitColumns(cols);
                
                SetEditable(1);
                SetWaitImageVisible(0);
                SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//                SetColProperty(0 ,"check_digit" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"mvmt_sts_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"cntr_seal_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"chss_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//                SetFocusEditMode("-1");
                SetShowButtonImage(2);
                SetSheetHeight(140);
                resizeSheet();
            }

            break;
    }
}

//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	var cnmvDt = "";
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:
            if(validateForm(sheetObj,formObj,sAction))
                if(sheetObj.id == "sheet1")
                    sheetObj.DoSearch("UI_CTM_0422_DATA1.html" );
                else if(sheetObj.id == "sheet2")
                    sheetObj.DoSearch("UI_CTM_0422_DATA2.html" );
            break;
        case SEARCH02:
            if(validateForm(sheetObj,formObj,sAction)) {
                formObj.f_cmd.value=SEARCH06;
                xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
                rtnValue=ComGetEtcData(xml, "rtnValue");
                parseYardMultiCombo(rtnValue, comboObjects[1]);
            }
            break;
        case IBSAVE:
            if(validateForm(sheetObj,formObj,sAction)) {
                if (sheetObjects[1].LastRow()== 1 && sheetObjects[0].GetCellValue(1, "cntr_no") == sheetObjects[1].GetCellValue(1, "cntr_no")) {
                    ComShowCodeMessage("CTM20106")
                    return;
                }
                if (sheetObjects[1].LastRow()== 0) {
                    ComShowCodeMessage("CTM20106")
                    return;
                }
                if (sheetObjects[0].GetCellValue(1, "reson_cd") == "") {
                    ComShowCodeMessage("CTM10049", "reson cd")
                    p_reson_op.focus();
                    return;
                }
                if (sheetObjects[0].GetCellValue(1, "xch_rmk") == "") {
                    ComShowCodeMessage("CTM10049", "remark")
                    document.form.p_rmk.focus();
                    return;
                }
                ComBtnDisable("btn_save");
                cnmvDt = sheetObjects[1].GetCellValue(1, "cnmv_evnt_dt2");
                sheetObjects[0].SetCellValue(1, "cnmv_evnt_dt", sheetObjects[0].GetCellValue(1, "cnmv_evnt_dt2").replace(/-/g, ""));
                for (var ii=1; ii <= sheetObjects[1].LastRow(); ii++) {
                	sheetObjects[1].SetCellValue(ii, "cnmv_evnt_dt", sheetObjects[1].GetCellValue(ii, "cnmv_evnt_dt2").replace(/-/g, ""));
                }
                formObj.f_cmd.value=MULTI;
                //ComOpenWait(true);
                queryString=sheetObjects[0].GetSaveString() + "&" + sheetObjects[1].GetSaveString() + "&" + FormQueryString(formObj);
                rtnXml=sheetObj.GetSaveData("EES_CTM_0422GS.do",  queryString);
                rtn=rtnXml.split("TR-ALL");
                if (rtn.length == 3) {
                    if (rtn[1].substring(1, 3) == "OK") {
                        ComShowCodeMessage("CTM10022", "Restuffing Creation");
                    } else {
                        ComBtnEnable("btn_save");
                        ComShowCodeMessage("CTM10024");
                    }
                } else {
                    ComBtnEnable("btn_save");
                    ComShowCodeMessage("CTM10024");
                }
                sheetObjects[0].SetCellValue(1, "cnmv_evnt_dt2", cnmvDt);
                for (var ii=1; ii <= sheetObjects[1].LastRow(); ii++) {
                	sheetObjects[1].SetCellValue(ii, "cnmv_evnt_dt2", cnmvDt);
                }
                //ComOpenWait(false);
            }
            break;
    }
}

/**
 * event after saving IBSheet
 * @param {ibsheet} Event       
 */
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {

    ComOpenWait(false);
    if (ErrMsg == "") {
        ComShowCodeMessage("CTM10022", "Release/Redelivery History");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}

function sheet2_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        ComShowCodeMessage("CTM10022", "Release/Redelivery History");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}


function validateForm(sheetObj,formObj,sAction){
    return true;
}

/**
 * saving contaienr number for tracking container number changing history
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
/*function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
    selectedRow=Row;
    if (Row < 1) return;
    var SaveName=sheetObj.ColSaveName(Col);
    if (SaveName == "cntr_no") {
        sheetContainer1=sheetObj.GetCellValue(Row, Col);
    }
}
*/

/**
 * saving contaienr number for tracking container number changing history
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
/*function sheet2_OnBeforeEdit(sheetObj, Row, Col) {
    selectedRow=Row;
    if (Row < 1) return;
    var SaveName=sheetObj.ColSaveName(Col);
    if (SaveName == "cntr_no") {
        sheetContainer2=sheetObj.GetCellValue(Row, Col);
    }
}
*/

/**
 * monitoring Key Event for validating checking when changing container number
 * @param sheetObj
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
//    newValue=sheetObj.EditValue;
    var frm=document.form;
    frm.p_yard1.disabled=true;
    frm.p_date.disabled=true;
    frm.p_time.disabled=true;
    ComBtnDisable("btn_Calendar1");
    p_reson_op.SetEnable(0);
    p_yard2.SetEnable(0);
    if (Row < 1) return;
    var SaveName=sheetObj.ColSaveName(Col);
    if (SaveName == "cntr_no") {
      /*  if (sheetContainer1 == Value) {
            return;
        } */
        sheetFrm=0;
        sheetContainerFlg1=false;
        sheetCheckValue(sheetObj, Row, Col, false, "1");
    }
}

/**
 * validating after checking Focus cell contaienr when clicking Mouse or moving Focus by tab
 * @param sheetObj
 * @param OldRow
 * @param OldCol
 * @param NewRow
 * @param NewCol
 * @return
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	/*    if (Row < 1) return;
    var Row=OldRow;
    var Col=OldCol;
    newValue=sheetObj.GetCellValue(Row, Col);
    var SaveName=sheetObj.ColSaveName(Col);
    if (newValue =="") return;
    if (SaveName == "cntr_no") {
        if ((sheetContainerFlg1 == false && Row >= sheetObj.HeaderRows()) || (sheetContainerFlg1 == false && sheetContainer1 != newValue)) {
            sheetCheckValue(sheetObj, Row, Col, true, "1");
        }
    }*/
    }

/**
 * monitoring Key evnet for validating when changing container number
 * @param sheetObj
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
//    newValue=sheetObj.EditValue;
    var frm=document.form;
    frm.p_yard1.disabled=true;
    frm.p_date.disabled=true;
    frm.p_time.disabled=true;
    ComBtnDisable("btn_Calendar1");
    p_reson_op.SetEnable(0);
    p_yard2.SetEnable(0);
    if (Row < 1) return;
    var SaveName=sheetObj.ColSaveName(Col);
    if (SaveName == "cntr_no") {
     /*   if (sheetContainer2 == Value) {
            return;
        } */
        sheetContainerFlg2=false;
        sheetCheckValue(sheetObj, Row, Col, false, "2");
    }
}

/**
 * validating after checking Focus cell contaienr when clicking Mouse or moving Focus by tab
 * @param sheetObj
 * @param OldRow
 * @param OldCol
 * @param NewRow
 * @param NewCol
 * @return
 */
 function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
 {
	 /*	 if (Row < 1) return;
    var Row=OldRow;
    var Col=OldCol;
    newValue=sheetObj.GetCellValue(Row, Col);
    var SaveName=sheetObj.ColSaveName(Col);

   // if (Row < 1) return;
    if (NewRow == OldRow && OldCol == NewCol) {
        return;
    } else if (errorRow > 0 && (NewRow != errorRow || OldCol != NewCol)) {
         errorRow=-1;
         errorBack=-1;
         return;
    } else if (errorBack == 1 && (OldRow != NewRow || OldCol != NewCol)) {
         errorBack=-1;
         errorRow=-1;
         // return;
    } else {
        if (SaveName == "cntr_no") {
            if ((sheetContainerFlg2 == false && Row >= sheetObj.HeaderRows()) || (sheetContainerFlg2 == false && sheetContainer2 != newValue)) {
                sheetCheckValue(sheetObj, Row, Col, true, "2");
            }
         }
    }*/
    }

/**
 * validating conatainer number
 * @param sheetObj     :Sheet Object
 * @param Row          :Grid Row
 * @param Col          :Grid Col
 * @param isOut        :sperater for Focus Out and Key Event true : focus out
 * @param sheetName    :Sheet name 
 * @return
 */
function sheetCheckValue(sheetObj, Row, Col, isOut, sheetName) {
    var SaveName = sheetObj.ColSaveName(Col);
    var formObj = document.form;
    switch(SaveName)
    {
        case "cntr_no":
/*            if (isOut)
                cntr_no = sheetObj.GetCellValue(Row, "cntr_no");
            else
                cntr_no = sheetObj.EditValue;
            if(cntr_no == undefined)
                cntr_no = sheetObj.GetCellValue(Row, "cntr_no");*/
                cntr_no = sheetObj.GetCellValue(Row, "cntr_no");
            
            if (sheetName == "2" && cntr_no.length < 1){
                sheetContainerFlg2 = true;
                return;
            }
            if (sheetName == "1" && cntr_no.length < 1){
                sheetContainerFlg1 = true;
                return;
            }
            if (cntr_no.length < 10 && isOut == false) {
                return;
//            } else if (cntr_no.length == 11) {
//                cntr_no = cntr_no.substring(0,10);
//                sheetObj.SetCellValue(Row, "cntr_no",cntr_no,0);
            }
            if (sheetName == "2") {
                if (sheetFrm == 1) {
                    if (sheetObjects[0].GetCellValue(1, "cntr_no") == cntr_no) {
                         ComShowCodeMessage("CTM20105")
                         errorRow = Row;
                         errorBack = 1;
                         sheetObj.SelectCell(Row, "cntr_no", true, "");
                         return;
                    }
                }
                formObj.f_cmd.value=SEARCH20;
                p_yard1 = formObj.p_yard1.value;
//                var p_yard2=p_yard2.GetSelectCode();
                queryString = "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntr_no + "&p_yard1=" + p_yard1;
                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                rtnValue = ComGetEtcData(xml, "rtnValue");
                if (rtnValue == null) {
                    ComShowCodeMessage("CTM10004");
                    errorRow = Row;
                    errorBack = 1;
                    sheetObj.SetCellValue(Row, "cntr_no", "", "");
                    sheetObj.SelectCell(Row, "cntr_no", true, "");
                    return;
                } else {
                    rtnStr = rtnValue.split("|");
                    ydCd = p_yard1 + document.form.p_yard2.value;
                    if (sheetObjects[1].GetCellValue(Row, "cntr_no") == sheetObjects[0].GetCellValue(1, "cntr_no")) {
                    } else  if (rtnStr[3] != ydCd) {
                        ComShowCodeMessage("CTM20057");
                        errorRow = Row;
                        errorBack = 1;
                        sheetObj.SetCellValue(Row, "cntr_no", "", "");
                        sheetObj.SelectCell(Row, "cntr_no", true, "");
                        return;
                    } else if (rtnStr[1] != "MT" ) {
                        ComShowCodeMessage("CTM20056");
                        errorRow = Row;
                        errorBack = 1;
                        sheetObj.SetCellValue(Row, "cntr_no", "", "");
                        sheetObj.SelectCell(Row, "cntr_no", true, "");
                        return;
                    }
                    sheetObj.SetCellValue(Row, "cntr_tpsz_cd", rtnStr[2], 0);
                    sheetObj.SetCellValue(Row, "mvmt_sts_cd", rtnStr[1], 0);
                    sheetObj.SetCellValue(Row, "cnmv_yr", document.form.p_date0.value.substring(0,4), 0);
                    sheetObj.SetCellValue(Row, "cnmv_evnt_dt", rtnStr[7], 0);
                    sheetObj.SetCellValue(Row, "cnmv_evnt_dt2", document.form.p_date0.value, 0);
                    var prvdt = sheetObjects[1].GetCellValue(Row, "cnmv_evnt_dt");
                    var evntdt = document.form.p_date0.value;
                    if (prvdt > evntdt) {
                    	ComShowCodeMessage("CTM30015");
                        errorRow = Row;
                        errorBack = 1;
                        //sheetObj.ReDraw = false;
                        sheetObj.RowDelete(Row, false);
                        sheetObj.DataInsert();
                        //sheetObj.ReDraw = true;
                        sheetObj.SelectCell(Row, "cntr_no", true);
                    	return;
                    }
                    vr = rtnStr[0].substring(10,11);
//                    if (vr != null) {
//                        sheetObj.SetCellValue(Row, "check_digit", vr, 0);
//                    }
                    sheetContainerFlg2=true;
                }
                if (sheetFrm == 1) {
                    if (sheetObjects[0].GetCellValue(1, "cntr_no") == cntr_no) {
                        ComShowCodeMessage("CTM20105")
                        errorRow = Row;
                        errorBack = 1;
                        sheetObj.SelectCell(Row, "cntr_no");
                        return;
                    } else {
                    }
                }
            } else {
                p_yard1 = formObj.p_yard1.value;
//                var p_yard2=p_yard2.GetSelectCode();
                queryString = "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntr_no + "&p_yard1=" + p_yard1;
                xml = sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                rtnValue = ComGetEtcData(xml, "rtnValue");
                if (rtnValue == null) {
                    ComShowCodeMessage("CTM10004");
                    errorRow=Row;
                    errorBack=1;
                    sheetObj.SetCellValue(Row, "cntr_no", "", "");
                    sheetObj.SelectCell(Row, "cntr_no", true, "");
                    return;
                } else {
                    rtnStr = rtnValue.split("|");
                    vr = rtnStr[0].substring(10,11);
                    if (rtnStr[3].substring(0,2) != p_yard1.substring(0,2)) {
                        ComShowCodeMessage("CTM10007");
                        errorRow = Row;
                        errorBack = 1;
                        sheetObj.SetCellValue(Row, "cntr_no", "", 0);
                        sheetObj.SelectCell(Row, "cntr_no", true, 0);
                        return;
                    }
//                    if (vr != null) {
//                        sheetObjects[0].SetCellValue(Row, "check_digit",vr);
//                    }
                    sheetObjects[0].SetCellValue(Row, "cntr_tpsz_cd",rtnStr[2]);
                    cntrSts=rtnStr[1];
                    queryString="f_cmd=" + SEARCH + "&cntr_no=" + cntr_no;
                    xml = sheetObjects[0].GetSearchData("EES_CTM_0422GS.do", queryString);
                    sheetObjects[0].LoadSearchData(xml, {Sync: 1});
                    sheetObjects[0].SetCellValue(1, "save_flg","D", "");
                    sheetObjects[0].SetCellValue(1, "reson_cd", formObj.p_reson.value, "");
                    sheetObjects[0].SetCellValue(1, "cnmv_evnt_dt2", document.form.p_date0.value, 0);
                    sts = sheetObjects[0].GetCellValue(1, "mvmt_sts_cd");
                    if (sts == "VL" || sts == "VD" || sts == "EN" || sts == "TN" || sts == "MT") {
                        ComShowCodeMessage("CTM20054");
                        errorRow = Row;
                        errorBack = 1;
                        //sheetObj.ReDraw = false;
                        sheetObj.RowDelete(Row, false);
                        sheetObj.DataInsert();
                        //sheetObj.ReDraw = true;
                        sheetObj.SelectCell(Row, "cntr_no", true);
                        return;
                    }
                    if (sheetObjects[0].GetCellValue(1, "bkg_cgo_tp_cd") == "") {
                    	ComShowCodeMessage("CTM99999", "Booking Cargo Type is missing.");
                        errorRow = Row;
                        errorBack = 1;
                        //sheetObj.ReDraw = false;
                        sheetObj.RowDelete(Row, false);
                        sheetObj.DataInsert();
                        //sheetObj.ReDraw = true;
                        sheetObj.SelectCell(Row, "cntr_no", true);
                        return;
                    }
                    var prvdt = sheetObjects[0].GetCellValue(1, "cnmv_evnt_dt");
                    var evntdt = document.form.p_date0.value;
                    if (prvdt > evntdt) {
                    	ComShowCodeMessage("CTM30015");
                        errorRow = Row;
                        errorBack = 1;
                        //sheetObj.ReDraw = false;
                        sheetObj.RowDelete(Row, false);
                        sheetObj.DataInsert();
                        //sheetObj.ReDraw = true;
                        sheetObj.SelectCell(Row, "cntr_no", true);
                    	return;
                    }
                    strRtn=ComGetEtcData(xml, "Split");
                    rtnVal=strRtn.split ("^^");
                    comboText="";
                    comboVal="";
                    var tmpStr;
                    for (xid=0; xid < rtnVal.length-1; xid++) {
                       tmpStr=rtnVal[xid].split("|");
                       comboText=comboText + "|" + tmpStr[0] + "\t" + tmpStr[1];
                       comboVal=comboVal + "| " + tmpStr[1] ;
                    }
                    obj1=sheetObjects[0];
                    obj2=sheetObjects[1];
                    for (var xx=1; xx <= sheetObjects[1].LastRow(); xx++) {
                        obj2.SetCellValue(xx, "vvd_cd", obj1.GetCellValue(1, "vvd_cd"), 0);
                        obj2.SetCellValue(xx, "bkg_no", obj1.GetCellValue(1, "bkg_no"), 0);
                        obj2.SetCellValue(xx, "cnmv_id_no", obj1.GetCellValue(1, "cnmv_id_no"), 0);
                        obj2.SetCellValue(xx, "cnmv_yr", obj1.GetCellValue(1, "cnmv_yr"), 0);
                        obj2.SetCellValue(xx, "reson_cd", obj1.GetCellValue(1, "reson_cd"), 0);
                        obj2.SetCellValue(xx, "org_yd_cd", obj1.GetCellValue(1, "org_yd_cd"), 0);
                    }
                    obj1.SetCellValue(Row, "bl_no", tmpStr[1], 0);
//                    sheetObjects[0].SetColProperty("bl_no", {ComboText:comboText, ComboCode:comboVal} );
                }
                sheetContainerFlg1=true;
                errorRow=-1;
                errorBack=-1;
            }
            break;
        case "chss_no":
            queryString=""; // chss_no
            p_chassis_no=sheetObj.GetCellValue(Row, "chss_no");
            if (p_chassis_no == '') {
                rtnValue='OK';
            } else {
                queryString="f_cmd=" + SEARCH08 + "&p_chassis_no=" + p_chassis_no;
                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                rtnValue=ComGetEtcData(xml, "rtnValue");
                rtnName=ComGetEtcData(xml, "rtnName");
            }
            if (rtnValue != 'OK') {
                if (!ComShowCodeConfirm("CTM20116")) {
                    sheetObj.SetCellValue(Row, Col,OrgValue,0);
                    clearStatus(sheetObj, Row);
                    return;
                } else return;
            }
            changeColor(sheetObj, Row);
            break;
        case "mgst_no":
            queryString=""; // chss_no
            mgset=sheetObj.GetCellValue(Row, "mgst_no");
            if (mgset == '') {
                rtnValue='OK';
            } else {
                queryString="f_cmd=" + SEARCH07 + "&p_mgset=" + mgset;
                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                rtnValue=ComGetEtcData(xml, "rtnValue");
                rtnName=ComGetEtcData(xml, "rtnName");
            }
            if (rtnValue != 'OK') {
                ComShowCodeMessage("CTM20115")
                sheetObj.SetCellValue(Row, Col,OrgValue,0);
                clearStatus(sheetObj, Row);
                return;
            }
            break;
    }
}

/**
* checking time gap comparing with today
*/
function getDateDiff(idx) {
    endDt=idx.substring(0,4) + idx.substring(5,7) + idx.substring(8,10);
    strTime=new Date();
    y=strTime.getFullYear();
    m=strTime.getMonth() + 1;
    d=strTime.getDate();
    h=strTime.getHours();
    n=strTime.getMinutes();
    if (m < 10) m="0" + m;
    if (d < 10) d="0" + d;
    if (h < 10) h="0" + h;
    if (n < 10) n="0" + n;
    strDt=y + "" + m + "" + d ;
    if (endDt > strDt) return 999;
}

/**
 * checking time gap comparing with today
 */
function getDateDiffTim(idx) {
    var startDt=new Date();
    var endDt=new Date(Number(idx.substring(0,4)),Number(idx.substring(5,7))-1,Number(idx.substring(8,10)));
    resultDt=Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));
    return resultDt;
}

/**
 * checking time gap comparing with today
 */
function getTimeDiff(idx) {
    var startDt=new Date();
    var endDt=new Date(Number(idx.substring(0,4)),Number(idx.substring(5,7))-1,Number(idx.substring(8,10)), Number(idx.substring(11,13)), Number(idx.substring(14,16)));
    resultDt=Math.floor(endDt.valueOf()/(60*60*1000)- startDt.valueOf()/(60*60*1000));
    return resultDt;
}

function yard_Change (event) {
    eventElement=ComGetEvent();
    if (eventElement.value.length < 5){
        eventElement.focus();
        return;
    }
    //if (srcValue == eventElement.value) return;
    p_yard2.RemoveAll();
    onShowErrMsg=false;
    rtn=yard_search()
    if (rtn && ofcChk != "S") {
        p_yard2.RemoveAll();
        ComShowCodeMessage("CTM20072");
        eventElement.value = "";
        eventElement.focus();
        return;
    }
    else if (rtn && ofcChk == "S") {
        p_yard2.Focus();
    } else {
        document.form.p_yard1.value = "";
        document.form.p_yard1.focus();
    }
}

function p_yard2_OnBlur() {
	 strRtn=p_yard2.GetSelectText(1,1); // strRtn=p_yard2.GetText(1,1);
    if (strRtn == '') {
        ComBtnDisable("btn_mvmt");
        ComBtnDisable("btn_add");
        sheet1.RemoveAll();
        sheet1.DataInsert(-1);
      //sheet 비활성화 수정 2015.05.26 by 황미연
        sheet1.SetEnable(1);
        sheet2.RemoveAll();
        sheet2.DataInsert(-1);
        sheet2.SetEnable(1);
    } else {
        ComBtnEnable("btn_mvmt");
        ComBtnEnable("btn_add");
        sheet1.RemoveAll();
        sheet1.DataInsert(-1);
        sheet1.SetEnable(1);
        sheet2.RemoveAll();
        sheet2.DataInsert(-1);
        sheet2.SetEnable(1);
    }
}

/**
 * handling OnKeyDown event in HTML Object
 */
function obj_onkeypress() {
    // English, numbers, space, @ only
    //ComKeyOnlyAlphabet("num","32|64");
}

function sheet1_OnLoadFinish() {
    doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[1],75);
}
