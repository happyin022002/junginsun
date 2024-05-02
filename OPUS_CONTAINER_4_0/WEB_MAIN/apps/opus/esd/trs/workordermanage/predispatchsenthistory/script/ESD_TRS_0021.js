/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0021.js
*@FileTitle  : Pre-Dispatch Sent History Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/*------------------ Defining general java script function   ------------------*/
/* General global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
var docMonth=new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
var R=222;
var G=251;
var B=248;
var parmObj = new Array();
var frmObj = new Array();
/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization 
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
}
/**
 * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
}
/**
 * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {
   ComKeyOnlyAlphabet('uppernum');
}
/**
 * Booking number manual control <br>
 **/
function manual_click() {
    //Activating Bkg_no to edit mode when manual check box is checked
   form.boo_bkg_no.readOnly=!form.manual.checked;
}
/**
 * Processing when booking number of tap BKG Creation is changed
 **/
function bkgno_keyup() {
}
/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){
   return ComChkObjValid(ComGetEvent());
}
/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(ComGetEvent());
}
/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
   ComKeyOnlyNumber(ComGetEvent());
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle=" |STS|Seq.|Reference No.|Vendor|Vendor|S/N|Sent Time|Fax 1 Number|Fax1 Status|Fax 2 Number|Fax 2 Status|Fax3 Number|Fax3 Status|E-mail 1 Address|E-Mail 1 Status|E-Mail 2 Address|E-Mail 2 Status|E-Mail 3 Address|E-Mail 3 Status" ;
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
                            {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_dis_ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trsp_dis_iss_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"snt_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dis_n1st_fax_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dis_n1st_fax_rslt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"dis_n2nd_fax_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dis_n2nd_fax_rslt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"dis_n3rd_fax_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dis_n3rd_fax_rslt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dis_n1st_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dis_n1st_eml_rslt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dis_n2nd_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dis_n2nd_eml_rslt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dis_n3rd_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dis_n3rd_eml_rslt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dly_dis_snt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trsp_cntr_aval_snt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                           
                InitColumns(cols);
                
                SetEditable(1);
                SetHeaderRowHeight(25);
                //SetSheetHeight(420);
                resizeSheet(sheetObj);

            }

        break;
    }
}
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
    /***** Adding additional sheet variables to use more than one sheet per a tab *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                if( validateFormSearch(formObject) ) {
                    doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
                }
            break;
            case "btn_new":
                sheetObject.RemoveAll();
                formObject.reset();
            break;
            case "btn_minimize":
                Mincount=(Mincount+1)%2;
                Minimize(Mincount);
            break;
            case "btng_downexcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
            break;
            case "btng_statushistory":
                doActionIBSheet(sheetObject, formObject, IBSEARCH, "02");
            break;
            case "btng_preview":
                doActionIBSheet(sheetObject, formObject, IBSEARCH, "04");
            break;
            case "btns_calendar":
                getCalendar();
            break;
            case "btns_vender": //Service Provider
                rep_OnPopupClick();
            break;
            case "btns_multicntr": //M CNTR
                openMultipleinquiry('CNT', 'CNTR No');
            break;
            case "btns_multibl": //M B/L No
                openMultipleinquiry('BLN', 'B/L No');
            break;
            case "btns_multibkg": //M BKG No
                openMultipleinquiry('BKG', 'BKG No');
            break;
            case "btns_multiwrk": //Work Order No
                openMultipleinquiry('WON', 'W/O No');
            break;
            case "btns_woissoffice": //W/O Issue Office
                open_WoissOffice();
            break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            errMsg=ComGetMsg("TRS90106");
            ComShowMessage(errMsg);
        } else {
            ComShowMessage(e.message);
        }
    }
}
//validating
function validateFormSearch(formObj) {
    var lvFrmDate=doSepRemove(doSepRemove(formObj.frm_plandate.value, " "), "-");
    var lvToDate=doSepRemove(doSepRemove(formObj.to_plandate.value , " "), "-");
    var lvBkg_no=doSepRemove(formObj.bkg_no.value , " ");
    var lvBill_no=doSepRemove(formObj.bill_no.value, " ");
    var lvCntr_no=doSepRemove(formObj.cntr_no.value, " ");
    var lvWo_no=doSepRemove(formObj.wo_no.value  , " ");
    var lvWo_iss_ofc=doSepRemove(formObj.wo_iss_ofc_cd.value, " ");
    if( lvFrmDate == "" ) //from date
        formObj.frm_plandate.value="";
    if( lvToDate == "" ) //to date
        formObj.to_plandate.value="";
    if( lvBkg_no == "" ) //BKG No
        formObj.bkg_no.value="";
    if( lvBill_no == "" ) //B/L No
        formObj.bill_no.value="";
    if( lvCntr_no == "" ) //CNTR No
        formObj.cntr_no.value="";
    if( lvWo_no == "" ) //CNTR No
        formObj.wo_no.value="";
    if( lvFrmDate == "" || lvToDate == "" ) { 
        if(formObj.reference_no.value == '' && formObj.wo_no.value == ''
            && formObj.bkg_no.value == '' && formObj.bill_no.value == ''
            && formObj.cntr_no.value == ''){
            errMsg=ComGetMsg("TRS90124");
            ComShowMessage(errMsg);
            return false;
        }       
    }
    var days_between=ComGetDaysBetween(formObj.frm_plandate , formObj.to_plandate) ;  
    if( days_between  < 0) {
        ComShowCodeMessage("TRS90118");
        formObj.frm_plandate.focus();
        return false;
    } 
    if ( days_between > 30 ) {
        ComShowMessage(" Possible inquiry period is limited to 1 month.");
        return false;
    }
    if( !doengnumcheck(lvBkg_no) ) {
        formObj.bkg_no.value="";
        formObj.bkg_no.focus();
        return false;
    }
    if( !doengnumcheck(lvBill_no) ) {
        formObj.bill_no.value="";
        formObj.bill_no.focus();
        return false;
    }
    if( !doengnumcheck(lvCntr_no) ) {
        formObj.cntr_no.value="";
        formObj.cntr_no.focus();
        return false;
    }
    if( !doengnumcheck(lvWo_no) ) {
        formObj.wo_no.value="";
        formObj.wo_no.focus();
        return false;
    }
    formObj.hid_frmdate.value=lvFrmDate; //from Date
    formObj.hid_todate.value=lvToDate;  //to Date
    formObj.bkg_no.value=lvBkg_no.toUpperCase();  //BKG No.
    formObj.bill_no.value=lvBill_no.toUpperCase(); //B/L No
    formObj.cntr_no.value=lvCntr_no.toUpperCase(); //CNTR No
    formObj.wo_no.value=lvWo_no.toUpperCase();   //W/O No
    formObj.wo_iss_ofc_cd.value=lvWo_iss_ofc.toUpperCase();
    return true;
}
function doActionIBSheet(sheetObj, formObj, sAction, obj) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //Retrieve
            if( obj == "01" ) {
                formObj.f_cmd.value=SEARCH;
                formObj.rtv_flg.value="D";
                sheetObj.DoSearch("ESD_TRS_0021GS.do", TrsFrmQryString(formObj) );
            } else if( obj == "02" ) {
                if( sheetObj.RowCount("U") < 1 ) {
                    errMsg=ComGetMsg("TRS90036");
                    ComShowMessage(errMsg);
                } else {
                    for(var i=1;i<=sheetObj.RowCount();i++){
                        if(sheetObj.GetCellValue(i,"chk1") == "1"){
                            document.formRd.ref_no.value=sheetObj.GetCellValue(i,"trsp_dis_ref_no");
                            document.formRd.vndr_seq.value=sheetObj.GetCellValue(i, "vndr_seq");
                        }
                    }

                    var lvDate = document.formRd.ref_no.value;
                    var lvVndr = document.formRd.vndr_seq.value;
                    var lvMon="";
                   if( lvDate != "" && lvVndr != "" ) {
                        if( lvDate > 7 ) {
                            lvMon=lvDate.substring(6, 8) + docMonth[eval(lvDate.substring(4, 6))-1] + lvDate.substring(2, 4);
                        } else {
                            lvMon=lvDate;
                        }
                        if( lvVndr == "" ) {
                            lvVndr=0;
                        }
                        document.formRd.so_ofc_cty_cd.value=sheetObj.GetCellValue(i, "trsp_so_ofc_cty_cd");
                        document.formRd.so_seq.value=sheetObj.GetCellValue(i, "trsp_so_seq");
                        document.formRd.wo_ofc_cty_cd.value=sheetObj.GetCellValue(i, "trsp_wo_ofc_cty_cd");
                        document.formRd.wo_seq.value=sheetObj.GetCellValue(i, "trsp_wo_seq");
                        document.formRd.ddl.value=sheetObj.GetCellValue(i, "dly_dis_snt_dt");
                        document.formRd.can.value=sheetObj.GetCellValue(i, "trsp_cntr_aval_snt_dt");
                        document.formRd.sep_privew.value=sheetObj.GetCellValue(i, "trsp_dis_iss_seq");
                        document.formRd.loc_date.value=lvMon+" 02:20:04 am";
                        document.formRd.tit_date.value=lvMon;
                        var queryStr=sheetObj.GetSaveString(false, false, "chk1");
                        formObj.f_cmd.value="";
                        formObj.queryParam.value=queryStr;
                        formObj.action="ESD_TRS_0020.do?pgmNo=ESD_TRS_0020";
                        formObj.submit();
                    } else {
                        errMsg=ComGetMsg("TRS90132");
                        ComShowMessage(errMsg);
                    }
                }
            } else if( obj == "03" && lvParam != '' ) {
                formObj.f_cmd.value=SEARCH01;
                formObj.rtv_flg.value="I";
                sheetObj.DoSearch("ESD_TRS_0021GS.do", lvParam+"&"+TrsFrmQryString(formObj) );
            } else if( obj == "04" ) {
                if( sheetObj.RowCount("U") < 1 ) {
                    errMsg=ComGetMsg("TRS90036");
                    ComShowMessage(errMsg);
                    return false;
                } else {
                    for(var i=1;i<=sheetObj.RowCount();i++){
                        if(sheetObj.GetCellValue(i,"chk1") == "1"){
                            document.formRd.ref_no.value=sheetObj.GetCellValue(i,"trsp_dis_ref_no");
                            document.formRd.vndr_seq.value=sheetObj.GetCellValue(i, "vndr_seq");
                            document.formRd.ddl.value=sheetObj.GetCellValue(i,"dly_dis_snt_dt");
                            document.formRd.can.value=sheetObj.GetCellValue(i, "trsp_cntr_aval_snt_dt");
                            document.formRd.sep_privew.value=sheetObj.GetCellValue(i, "trsp_dis_iss_seq");
                        }
                    }
                    var ddlDate=document.formRd.ddl.value;
                    var canDate=document.formRd.can.value;  
                    var sep_privew=document.formRd.sep_privew.value;
                    if( ddlDate != "" && canDate != "" && sep_privew == "1" ) {
//                        var parmObj=new Array();
//                        var frmObj=new Array();
                        frmObj[0]=document.formRd;
                        parmObj[0]="1";
                        parmObj[1]="";
                        parmObj[2]="N";
                        parmObj[3]=RD_path+"apps/opus/esd/trs/workordermanage/predispatchsenthistory/report/ESD_TRS_0027.mrd";
                        parmObj[4]="";//sheetObject;
                        parmObj[5]=frmObj;
                        rdObjModaless(RdReport, parmObj, 800, 700);
                    } else if( ddlDate != "" && canDate == "" && sep_privew == "1" ) {
//                        var parmObj=new Array();
//                        var frmObj=new Array();
                        frmObj[0]=document.formRd;
                        parmObj[0]="1";
                        parmObj[1]="";
                        parmObj[2]="N";
                        parmObj[3]=RD_path+"apps/opus/esd/trs/workordermanage/predispatchstatus/report/ESD_TRS_0026.mrd";
                        parmObj[4]="";//sheetObject;
                        parmObj[5]=frmObj;
                        rdObjModaless(RdReport, parmObj, 800, 700);
                    } else {
                        errMsg=ComGetMsg("TRS90132");
                        ComShowMessage(errMsg);
                    }
                }
            }
        break;
        case IBDOWNEXCEL:        //Excel Download
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                sheetObj.Down2Excel({ HiddenColumn:true,Merge:true});
            }
        break;
    }
}
function doSearchEnter() {
    if( ComGetEvent("keycode") == 13 ) {
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        if( validateFormSearch(formObject) ) {
            doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
        }
    }
}
function getDateBetween(obj) {
    document.form.to_plandate.value=ComGetDateAdd(obj.value, 14);
}
/**
 * Event clicking a tab
 * Activating the selected tab 
 */
function Minimize(nItem) {
    var objs=document.all.item("showMin");
    if( nItem == "1" ) {
        objs.style.display="none";
        //sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(22);
        //sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 22));
    } else {
        objs.style.display="inline";
//        sheetObjects[0].SetSheetHeight(300);
       // sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 17));
    }
    resizeSheet(sheet1);
}
/*
 * Multi-Calendar input Pop-Up
 */
function getCalendar() {
    var cal=new ComCalendarFromTo();
    cal.displayType="date";
    cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}
/**
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick() {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var classId="getCOM_ENS_rep";
    var xx1="";  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
//    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
  ComOpenPopup('/opuscntr/COM_ENS_011.do' + param, 772, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray) {
    var formObj=document.form;
    for(var i=0; i<rowArray.length; i++) {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[3];
        var colArray4=colArray[4];
        formObj.combo_svc_provider.value=colArray2;
        formObj.trsp_so_vndr_no.value=colArray4;
    }
}

/**
 * General Trunk VVD popup
 */
function openMultipleinquiry(obj, obj2) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var xx1=""; //CONTI
    var xx2=""; //SUB CONTI
    var xx3=""; //COUNTRY
    var xx4=""; //STATE
    var xx5=""; //CONTROL OFFIC
    var xx6=""; //LOC CODE
    var xx7=""; //LOC NAME
    var xx8="";
    var xx9="";
    var classId="getTRS_ENS_906";
    var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
   // ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
    ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", "1,0", true);
}
/**
 * Location : The case selecting one item at pop-up page
 */
function getTRS_ENS_906(rowArray, obj) {
    var reObj="";
    var formObject=document.form;
    for(var i=0; i<rowArray.length; i++) {
        var colArray=rowArray[i];
        if( i == rowArray.length-1 ) {
            reObj=reObj + colArray;
        } else {
            reObj=reObj + colArray + ",";
        }
    }
    if( obj == "BKG" ) {
        formObject.bkg_no.value=reObj;
    } else if( obj == "BLN" ) {
        formObject.bill_no.value=reObj;
    } else if( obj == "CNT" ) {
        formObject.cntr_no.value=multiCntrChkDgt(reObj);
    } else if( obj == "WON" ) {
        formObject.wo_no.value=reObj;
    } else {
        errMsg=ComGetMsg("TRS90132");
        ComShowMessage(errMsg);
    }
}
/**
 * W/O Issue Office
 */
function open_WoissOffice() {
    ComOpenPopup("/opuscntr/COM_ENS_071.do", 770, 480, "getCOM_ENS_071", "1,0,1,1,1,1,1,1", true);
}
/**
 * W/O Issue Office : The case selecting one item at pop-up page
 */
function getCOM_ENS_071(rowArray) {
    var colArray=rowArray[0];   
    document.form.wo_iss_ofc_cd.value=colArray[3];
}
function sheet1_OnSearchEnd(sheetObj,errMsg){
    if( errMsg.length > 0 ) {
        ComShowMessage(errMsg);
    } else {
        var rtv_flg=document.form.rtv_flg.value;
        if (rtv_flg == "I") {
            var formObj=document.formRd;
            for(var i=1;i<=sheetObj.RowCount();i++){
                document.formRd.ref_no.value=sheetObj.GetCellValue(i,"trsp_dis_ref_no");
                document.formRd.vndr_seq.value=sheetObj.GetCellValue(i, "vndr_seq");
                if( formObj.ref_no.value != "" && formObj.vndr_seq.value != "" )  {
                    sheetObj.SetCellValue(i, "chk1","1",0);
                }
            }
        }
    }
}


function resizeSheet(sheetObj){
    ComResizeSheet(sheetObj);
}

