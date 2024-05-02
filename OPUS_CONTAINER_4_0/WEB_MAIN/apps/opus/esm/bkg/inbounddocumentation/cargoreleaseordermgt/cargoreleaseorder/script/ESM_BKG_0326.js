/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0326.js
*@FileTitle      : Japan Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
     * @extends 
     * @class ESM_BKG_0326 : business script for ESM_BKG_0326
*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheetNames=new Array("blInfo", "refInfo", "cstmsInfo", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "japDoInfo", "partial", "otsRcvPop"); //  otsRcvPop

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler */
function processButtonClick(){
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        //disabled -> return
        if(srcName!="btn_bl_surr_rmk" && srcName!="btn_cct" && srcName!="btn_third_cct" && srcName!="btn_tpb" && srcName!="img_exp_del_dt" && srcName!="btn_hold_remark"){
	        if(!ComIsBtnEnable(srcName)){
	            return;
	        }
        }
        switch(srcName) {
            //Retrieve
            case "btn_retrieve":
                //Check change and ask save
                doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
            break;
            //Save
            case "btn_save":
                doActionIBSheet(sheetObjects["blIss"], formObject,IBSAVE);
            break;
            //Hold
            case "btn_hold":
                doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI04);
            break;
            //Cancel
            case "btn_cancel":
                doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI02);
            break;
            //Assign /Issue
            case "btn_assign":
                doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI01);
            break;
            //DOR/ IF
            case "btn_if":
                doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI03);
            break;
            //DOR/ IF
            case "btn_dorcancel":
                doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI06);
            break;
            //RCV Cancel
            case "btn_obl_cancel":
                oblInit();
            break;
            //D/O ID SAVE
            case "btn_do_id_save":
                doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI05);
            break;
            //Remark
            case "btn_remark":
                //Window  Open 
                var condition="?";
                condition += "do_no="+document.getElementById("do_no").value+document.getElementById("do_no_split").value;
                condition += "&pgmNo=ESM_BKG_1018";
                ComOpenWindowCenter('ESM_BKG_1018.do'+condition, 'remark', 530, 290, false);
            break;
            //History
            case "btn_history":
                //Window  Open 
                var condition="?";
                condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                condition += "&bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                condition += "&pgmNo=ESM_BKG_0711";
                ComOpenWindowCenter('ESM_BKG_0711.do'+condition, 'history', 800, 430, false);
            break;
            case "img_exp_del_dt":
                var cal=new ComCalendar();
                cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
            break;
            case "btn_cct":
                blOutstandingAmountPopOpen(true);
            break;
            case "btn_third_cct":
                blOutstandingAmountPopOpen(false);
            break;
            case "btn_dem_retrieve":
                doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND07);
            break;
            case "btn_dmdt":
                var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                var blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                var trfCd=document.getElementById("demur_type").value;
                var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&pgmNo=EES_DMT_3002P";
                ComOpenWindowCenter('EES_DMT_3002P.do' + paramVal, 'dmdt', 1050, 670, false,"yes");
                
                break;
            case "btn_tpb":
                var frDate=ComGetDateAdd(null, "D", -60);
                var toDate=ComGetNowInfo("ymd", "");
                var otsStsCd="";
                if (document.form.tpb_status.value == "1") {
                    otsStsCd="P";
                } else {
                    otsStsCd="T";
                }
                var condition="?";
                condition += "s_state=BKG";
                condition += "&s_bkg_no_all="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                condition += "&s_bl_no_all="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                condition += "&s_ots_sts_cd=" + otsStsCd;
                condition += "&pgmNo=ESD_TPB_0134";
                ComOpenWindowCenter('ESD_TPB_0134.do'+condition, 'TPB', 1024, 318, true);
            break;
            case "btn_bl_surr_rmk":
                var condition="?";
                condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                condition += "&inquery_only=Y";
                condition += "&pgmNo=ESM_BKG_0400";
                ComOpenWindowCenter('ESM_BKG_0400_POP.do'+condition, 'bl_surr_rmk', 900, 300, true);
            break;
            //Form Setting
            case "btn_form_setup":
                var condition="?";
                condition += "pgmNo=ESM_BKG_0137";
                condition += "&office="+lginOfcCd;
                ComOpenWindowCenter('ESM_BKG_0137_POP.do'+condition, 'setting', 1024, 480, false,"yes");
            break;
            case "btn_receiverinfo":
                var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
                if(doNo == undefined){
                    doNo='';
                }
                var condition="?";
                condition += "do_no="+doNo;
                condition += "&pgmNo=ESM_BKG_0130";
                ComOpenWindowCenter('ESM_BKG_0130.do'+condition, 'receiverinfo', 500, 260, true);
            break;
            case "btn_doprint": // btn_doprint
                doPreview();
            break;
            case "btn_print": // btn_doprint
                doPrint();
            break;
            case "btn_recprint": // btn_recprint
                //recRdPrint();
                receiptPreview();
            break;
            case "btn_hold_remark":
                var paramVal="?sheet_name=R&pgmNo=ESM_BKG_1089";
                ComOpenWindowCenter('/opuscntr/ESM_BKG_1089.do' + paramVal, 'remark', 600, 270, false);
            break;
            case "btn_close":
               	ComClosePopup(); 
             break;              
        } // end switch
    }catch(e) {
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
   sheetObjects[sheet_obj.id]=sheet_obj; //registering IBSheet Object as list
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    var formObj=document.form;
    fnInSetComboBox(formObj.blIss_bl_otr_doc_rcv_cd, evtCode, evtValue, "|", "", "", true, "");
    for(i=0;i<sheetNames.length;i++){
        ComConfigSheet (sheetObjects[sheetNames[i]] );
        initSheet(sheetObjects[sheetNames[i]],i+1);
        ComEndConfigSheet(sheetObjects[sheetNames[i]]);
    }
//    for(i=0;i<rdObjects.length;i++){
//        initRdConfig(rdObjects[i]);
//    }
    //Axon Event
    initControl();
    ComBtnDisable("btn_dmdt");
    ComSetFocus(document.form.bl_no)
    document.getElementById("cstmsInfo_info_cgo_flg").value='Y';
    buttonDisabledAll();
    
    //@ Test Code Start ----------
//    form.bkg_no.value = 'NYC400441600';//NYC400392400
    //@ Test Code End   ----------
    
    if (document.form.bkg_no.value != "" || document.form.bl_no.value != "" ) {
        doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
    }

}
/**
 * Initialize RD
 */
function initRdConfig(rdObject){
    var Rdviewer=rdObject ;
    Rdviewer.AutoAdjust=true;
    Rdviewer.ViewShowMode(0);
    Rdviewer.SetBackgroundColor(128,128,128);
    Rdviewer.SetPageLineColor(128,128,128);
    Rdviewer.ApplyLicense("0.0.0.0");
}
/**
 * Handle events that occur on the screen
 * Axon event 
 */
function initControl(){
    axon_event.addListenerForm('keypress' , 'obj_keypress'   , form);
    axon_event.addListenerForm('click'    , 'obj_click'      , form);
    axon_event.addListenerForm('change'   , 'obj_change'     , form);
    axon_event.addListenerForm('blur'     , 'obj_deactivate' , form);
    axon_event.addListenerForm('focus'    , 'obj_focus'      , form);
}
/************************************************************************************
    Handle events that occur on the screen
************************************************************************************/
/**
 * HTML Control  onkeypress Event.
 */
function obj_keypress(){
    var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName=ComGetEvent("name");
    if (keyCode == 13 && (srcName == 'bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no')) {
        conditionReset();
        if (srcName == 'cntr_no'){
            if(!ComChkObjValid(document.form.cntr_no)) {
                return false;
            }
            if(!ComChkObjValid(document.form.cntr_no)) {
                return false;
            }
            fnSearchContainer();
        } else {
           doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
        }
    } // end if
    else if (keyCode == 13 && srcName == 'exp_del_dt') {
        if(sheetObjects["blInfo"].GetCellValue(1,"blInfo_bkg_no") != undefined){
            doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND07);
        }
    }
}
/**
 * HTML Control onClick Event.
 */
function obj_click(){
    if (ComGetEvent("name") == "bl_no") {
        showHideLayers();
    }
}
/**
 * HTML Control onchange Event Validation check.
 */
//@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
var onchangeFlag = true;
function obj_change(){
    var oForm=document.form;
    conditionTrim();
    //set dirty_flag for check modified form
    if(ComGetEvent("name") == "cntr_no" || ComGetEvent("name") == "cstmsInfo_info_cgo_flg" || ComGetEvent("name") == "blIss_bl_otr_doc_rcv_cd" || ComGetEvent("name") == "blIss_otr_doc_cgor_flg" || ComGetEvent("name") == "blIss_ibd_doc_rcv_flg" || ComGetEvent("name") == "refInfo_inter_rmk"){
        document.form.dirty_flag.value="Y";
    }
    if(ComGetEvent("name") == "bl_no" || ComGetEvent("name") == "bkg_no" ){
    	//@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
    	if(onchangeFlag){
    		conditionReset();
    	}
    }
    if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
        return false;
    }
    if(ComGetEvent("name") == 'blIss_obl_rdem_knt' || ComGetEvent("name") == 'blIss_bl_otr_doc_rcv_cd' || ComGetEvent("name") == 'blIss_otr_doc_cgor_flg'){
        if (ComGetEvent("name") == 'blIss_bl_otr_doc_rcv_cd') {
            if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
               document.getElementById("blIss_otr_doc_cgor_flg").disabled=false;
               document.getElementById("blIss_otr_doc_cgor_flg").value='N';
            } else {
               document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex=0;
               document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
            }
        }
        //Original Bill of Lading Status N => Y : History 
        if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
            return;
        }
        //History -> obl cancel or obl Clear
        if( document.getElementById("blIss_obl_rdem_knt").value >0 || (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0 && document.getElementById("blIss_otr_doc_cgor_flg").value =='Y')){
            document.getElementById("obl_cng_flg").value='Y';
            document.getElementById("do_cng_evnt_cd").value='RB';
        }
    }
}
/**
 * Form Object Deactive Event Handling
 * @return
 */
function obj_deactivate(){
    var objName=ComGetEvent("name");
    var formObj=document.form;
    // B/L No SelectBox 
    if(blLayer.style.visibility == "visible"){
        blLayer.style.visibility="hidden";
    }
    /*****************************************
    switch(objName) {
        case "exp_del_dt":
            ComChkObjValid(ComGetEvent());
        break;
    }
    *****************************************/
}
function obj_focus(){
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "exp_del_dt":
            formObj.exp_del_dt.value=formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
        break;
    }
}
/************************************************************************************
    End of event processing that occurs
************************************************************************************/
/**
 * All buttons on the screen non-activated.
 */
function buttonDisabledAll(){
    ComBtnDisable("btn_do_id_save");
    ComBtnDisable("btn_obl_cancel");
    ComBtnDisable("btn_erp");
    ComBtnDisable("btn_dem_retrieve");
    ComBtnDisable("btn_dmdt");
    ComBtnDisable("btn_save");
    ComBtnDisable("btn_hold");
    ComBtnDisable("btn_history");
    ComBtnDisable("btn_receiverinfo");
    ComBtnDisable("btn_remark");
    ComBtnDisable("btn_assign");
    ComBtnDisable("btn_cancel");
    ComBtnDisable("btn_if");
    ComBtnDisable("btn_dorcancel");
    ComBtnDisable("btn_doprint");
    ComBtnDisable("btn_print");
    ComBtnDisable("btn_recprint");
    if(document.getElementById("btn_do_id_save").style.color == 'rgb(247,217,9)'){
        document.getElementById("btn_do_id_save").style.color='rgb(192,192,192)';
    }
    document.getElementById("btn_tpb").style.visibility="hidden";
}
/**
 * Initialize all input values
 */
function inputParamReset(){
    for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
        if ( document.form.getElementsByTagName("input")[i].name != "bl_no"   &&
             document.form.getElementsByTagName("input")[i].name != "cntr_no" &&
             document.form.getElementsByTagName("input")[i].name != "bkg_no"
            ){
                document.form.getElementsByTagName("input")[i].value="";
            }
    }
    //Initialize sheet
    var resetSheetNames=new Array("blInfo", "refInfo", "cstmsInfo", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "japDoInfo", "otsRcvPop"); //prefix string array
    for(var idx=0; idx < resetSheetNames.length; idx++){
        sheetObjects[resetSheetNames[idx]].RemoveAll();
    }
    document.form.refInfo_inter_rmk.value = '';
    document.getElementById("blIss_otr_doc_cgor_flg").value='';
    document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
    document.getElementById("cstmsInfo_info_cgo_flg").value='';
    document.getElementById("blIss_ibd_doc_rcv_flg").value='';
    document.getElementById("tot_ots_amt").value='';
    document.getElementById("tot_bil_amt").value='';
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "blInfo":
            with(sheetObj){
                var HeadTitle=" |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|DSCH_LOC|BL_TP_CD|OBL_ISS_RMK|lcloblissueflg";
                var headCount=ComCountHeadTitle(HeadTitle);
                var prefix="blInfo_";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vessel", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_prt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scust_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dsch_loc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lcloblissueflg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetVisible(0);
            }
                
            break;
        case "refInfo":
            /****************************************************************
            //Japan D/O Release Reference 
            *****************************************************************/
            with(sheetObj){
                var HeadTitle=" |BKG_NO|INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG";
                var prefix="refInfo_";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_ref_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cstms_ref_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cy_op_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"info_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetVisible(0);
            }
                
            break;
        case "cstmsInfo":
            /****************************************************************
            //Japanese Customs - B/L INFO extraction
            *****************************************************************/
            with(sheetObj){
                var HeadTitle=" |full_mty_cd|cy_op_cd|info_cgo_flg";
                var prefix="cstmsInfo_";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"full_mty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cy_op_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"info_cgo_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetVisible(0);
            }

            break;
        case "doRlseSts":
            /****************************************************************
            // B/L D/O STATUS(ASSIGN, RELEASE, ISSUE) Detail INFO
            *****************************************************************/
            with(sheetObj){
                var HeadTitle=" |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT";
                var headCount=ComCountHeadTitle(HeadTitle);
                var prefix="doRlseSts_";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no_split",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetSheetHeight(80,1);
            }

            break;
        case "blIss":
            with(sheetObj){
                var HeadTitle=" |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG|obl_iss_usr_id|obl_rdem_usr_id|otr_doc_rcv_usr_id|bl_tp_cd|del_cnt_cd|ibd_doc_rcv_flg|ibd_doc_rcv_ofc_cd|ibd_doc_rcv_usr_id|ibd_doc_rcv_dt";
                var headCount=ComCountHeadTitle(HeadTitle);
                var prefix="blIss_";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_cpy_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_cgor_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetVisible(0);
            }
                    
            break;
        case "otsRcvInfo":
            /****************************************************************
            //Fare Payment and Outstanding Amounts Info
            *****************************************************************/
            with(sheetObj){
                var HeadTitle=" |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
                var headCount=ComCountHeadTitle(HeadTitle);
                var prefix="otsRcvInfo_";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetVisible(0);
            }
                
            break;
        case "demInfo":
            /****************************************************************
            //DEM.DET I/F
            *****************************************************************/
            with(sheetObj){
                var HeadTitle=" |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";
                var prefix="demInfo_";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fx_ft_ovr_dys", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                        {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                        {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                        {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetSheetHeight(92,1);
            }
                
            break;
        case "demDtl":
            /****************************************************************
            //Container Demurrage 
            *****************************************************************/
            with(sheetObj){
                var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
                var prefix="demDtl_";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_inv_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_ar_if_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetSheetHeight(110);
            }
            
            break;
        case "totBlbAmt":
            /****************************************************************
            //Total Billable Amount
            *****************************************************************/
            with(sheetObj){
                var HeadTitle1="|curr_cd|tot_bil_amt";
                var headCount=ComCountHeadTitle(HeadTitle1);
                prefix="totBlbAmt_";
                
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetVisible(0);
            }
                
            break;
        case "partial":
            /****************************************************************
            //partial Container Info
            *****************************************************************/
            with(sheetObj){
                var HeadTitle1="|SEQ||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
                var headCount=ComCountHeadTitle(HeadTitle1);
                prefix="partial_";
                
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
                            {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cstms_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetVisible(0);
            }
                
            break;
        case "japDoInfo":
            with(sheetObj){
                var HeadTitle1="|jp_do_snd_sts_cd|jp_do_id|bkg_no";
                var headCount=ComCountHeadTitle(HeadTitle1);
                prefix="japDoInfo_";
                
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"jp_do_snd_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"jp_do_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetDataAutoTrim(0);
                SetVisible(0);
            }
                
            break;
        case "otsRcvPop":
            /****************************************************************
            //CCT,Third Office(CCT)  Pop-up query
            *****************************************************************/
            with(sheetObj){
                var HeadTitle1="|OUTSTANDING|OUTSTANDING";
                var headCount=ComCountHeadTitle(HeadTitle1);
                prefix="otsRcvPop_";
                
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_ots_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetVisible(0);
            }
            
            break;
    }
}
// Sheet handling process
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch(sAction) {
        case IBSEARCH: //Retrieve
            if(!validateForm(sheetObj,formObj,sAction)){
            	return;
            }
            
            ComOpenWait(true);
            
            //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
            onchangeFlag = false;
            
            setTimeout( function () { //@ setTimeout ###########################################################
                //Initialization parameters
                inputParamReset();
                //Button Settings
                buttonDisabledAll();
                formObj.f_cmd.value=SEARCH;
                var temp_bl=formObj.bl_no.value;
                var temp_bkg=formObj.bkg_no.value;
                
                formObj.bl_no.value=temp_bl;
                formObj.bkg_no.value=temp_bkg;
                if(formObj.bl_no.value !=''){
                    var blNo=formObj.bl_no.value;
                    var suffix=blNo.substring(formObj.bl_no.value.length-1)
                    if(suffix =='W' || suffix =='S'){
                        formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
                    }
                }
                //Multiple retrieve
                var aryPrefix=new Array("blInfo_", "refInfo_", "cstmsInfo_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_", "japDoInfo_"); //prefix string array
                var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0326GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                 if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
                    document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
                }
                if(undefined != ComGetEtcData(arrXml[0], "dorStowage") && ComGetEtcData(arrXml[0], "dorStowage") != 'null'){
                    document.getElementById("dorStowage").value=ComGetEtcData(arrXml[0], "dorStowage");
                }
                if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
                    document.getElementById("tpb_status").value=ComGetEtcData(arrXml[0], "tpbStatus");
                }
                if(undefined != ComGetEtcData(arrXml[0], "mrdId") && ComGetEtcData(arrXml[0], "mrdId") != 'null'){
                    var mrdId=ComGetEtcData(arrXml[0], "mrdId");
                    var arrMrd=mrdId.split("@@");
                    document.getElementById("mrd_id").value=arrMrd[0];
                    if (arrMrd.length > 1) {
                        document.getElementById("mrd_param").value=arrMrd[1];
                    } else {
                        document.getElementById("mrd_param").value="";
                    }
                }
                for(var idx=0; idx < arrXml.length; idx++){
                    if(idx > 0) {
                        sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
                    }
                    sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
                }
                
                //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
                onchangeFlag = true;
                
              //@releaseRemarkFlag 초기화 한다. 
				releaseRemarkFlag =false;
            
            } , 100);//@ setTimeout end ###########################################################                
            
        break;
        case COMMAND07: 
            if(!validateForm(sheetObj,formObj,sAction)){
            	return;
            }
                if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                    ComShowCodeMessage('BKG01072'); 
                    ComSetFocus(formObj.bl_no)
                    return false;
                }
                formObj.f_cmd.value=SEARCH;
                ComOpenWait(true);
                
                setTimeout( function () { //@ setTimeout ###########################################################
                	
		                //Multiple retrieve
		                var aryPrefix=new Array("blInfo_", "refInfo_", "cstmsInfo_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_", "japDoInfo_"); //prefix string array
		                var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0326GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                var arrXml=sXml.split("|$$|");
		                if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
		                    document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
		                }
		                for(var idx=6; idx < arrXml.length; idx++){
		                    if(idx > 0) {
		                        sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
		                    }
		                    sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
		                }
            
                } , 100);//@ setTimeout end ###########################################################
        break;
        case IBSAVE:   //Save
            if(validateForm(sheetObj, formObj, sAction)){
                if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                    ComShowCodeMessage('BKG01072'); 
                    ComSetFocus(formObj.bl_no)
                    return false;
                }
                formObj.f_cmd.value=MODIFY;
                CopyFormToRow(formObj, sheetObjects["refInfo"], 1, "");
                CopyFormToRow(formObj, sheetObjects["blIss"], 1, "");
                CopyFormToRow(formObj, sheetObjects["cstmsInfo"], 1, "");
                var sParam1=sheetObjects["refInfo"].GetSaveString(true);   //Japan D/O Release Reference Info
                var sParam2=sheetObjects["blIss"].GetSaveString(true);     //Original B/L   Detail Info
                var sParam3=sheetObjects["cstmsInfo"].GetSaveString(true); //CY Operator Code change
                //Check for changes in the Grid
                
                if(!sheetObjects["refInfo"].IsDataModified() && !sheetObjects["blIss"].IsDataModified() && !sheetObjects["cstmsInfo"].IsDataModified()){
                    ComShowCodeMessage('BKG00797');
                    return false;
                }
                if( !ComShowCodeConfirm('COM12147', 'data' ) ){
                    return false;
                }
                var aryPrefix=new Array("refInfo_", "blIss_", "cstmsInfo_");
                var sparam=sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                var sXml=sheetObj.GetSaveData("ESM_BKG_0326GS.do", sparam);
                sheetObjects["refInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);  
            }
        break;
        case MULTI01: // Assign-Issue
            if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            if(document.getElementById("evnt_flag").value == 'R'){
                ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Assign / Issue");
                return;
            }
            
        	//	GAP Display Credit Risk (2014.10.14 An Jin Eung)
        	if(!fnExistBlackListedCustomer(formObj.bkg_no.value)){
//                return false;
            }             
            //wonjoo 2015-01-29
        	if(sheetObjects["refInfo"].GetCellValue(1, "refInfo_cy_op_cd") == "" ){
        		ComShowMessage ('Please enter the "CY Oeperator Code" and click the Save button to save it');
        		return;
        	}
        	
            //Freight Received Status <> Y -> Remark for Release            
            if(document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='N'){
                if(!remarkForReleasePop()){
                    return false;
                }
            }
            //Are you sure to Assign?
            if(!ComShowCodeConfirm('BKG00672')){
                return false;
            }
            formObj.f_cmd.value=MULTI01;
            var aryPrefix=new Array("doRlseSts_", "refInfo_");    //prefix string array
            var sParam1=sheetObjects["doRlseSts"].GetSaveString(true);
            var sParam2=sheetObjects["refInfo"].GetSaveString(true);   //Japan D/O Release Reference Info
            var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0326GS.do", sparam);
            sheetObjects["doRlseSts"].LoadSaveData(sXml);
            sXml=ComDeleteMsg(sXml); 
        break;
        case MULTI02:// Cancel
            if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            if(document.getElementById("evnt_flag").value == 'R'){
                ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"),"D/O Cancel");
                return;
            }
            //Are you sure to Cancel?
            if(!ComShowCodeConfirm('BKG00670')){
                return false;
            }
            formObj.f_cmd.value=MULTI02;
            sheetObjects["doRlseSts"].SetRowStatus(1,"U");
            sheetObj.DoSave("ESM_BKG_0326GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("doRlseSts_"),-1,0);
        break;
        case MULTI03:// DOR /IF
            if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            
            if(!ComChkObjValid(formObj.cstmsInfo_cy_op_cd)) return false;
            
            if(document.getElementById("blIss_obl_rdem_flg").value =='N'){
                ComShowCodeMessage('BKG40066');
                return;
            }
            if(document.getElementById("evnt_flag").value == 'R'){
                ComShowCodeMessage('BKG40107' , sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "DOR /IF");
                return;
            }
            // Empty Container Check!
            if(document.form.cstmsInfo_full_mty_cd.value == 'EMPTY'){
                ComShowCodeMessage('BKG43039');
                return;                    
            }
            
        	//GAP Display Credit Risk (2014.10.14 An Jin Eung)
        	if(!fnExistBlackListedCustomer(formObj.bkg_no.value)){
//                return false;
            }
        	
            //Are you sure to Assign?
            if(!ComShowCodeConfirm('BKG00722', document.getElementById("japDoInfo_jp_do_id").value)){
                return false;
            }
            formObj.f_cmd.value=MULTI03;
            document.getElementById("svc_cd").value='D';
            sheetObjects["doRlseSts"].SetRowStatus(1,"U");
            sheetObjects["blIss"].SetRowStatus(1,"U");
            var aryPrefix=new Array("doRlseSts_", "blIss_");    //prefix string array
            var sParam1=sheetObjects["doRlseSts"].GetSaveString();
            var sParam2=sheetObjects["blIss"].GetSaveString();
            document.getElementById("do_no").value=sheetObjects["japDoInfo"].GetCellValue(1, "japDoInfo_jp_do_id");
            var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0326GS.do", sparam);
            sheetObjects["doRlseSts"].LoadSaveData(sXml);
            sXml=ComDeleteMsg(sXml); 
        break;
        case MULTI06:// DOR /IF CANCEL
            if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            if(document.getElementById("evnt_flag").value == 'R'){
                ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "DOR Cancel");
                return;
            }
            //Are You Sure To DO CANCEL With DO ID?
            if(!ComShowCodeConfirm('BKG00723', document.getElementById("japDoInfo_jp_do_id").value)){
                return false;
            }
            formObj.f_cmd.value=MULTI06;
             document.getElementById("svc_cd").value='D';
            sheetObjects["doRlseSts"].SetRowStatus(1,"U");
            sheetObjects["blIss"].SetRowStatus(1,"U");
            var aryPrefix=new Array("doRlseSts_", "blIss_");    //prefix string array
            var sParam1=sheetObjects["doRlseSts"].GetSaveString();
            var sParam2=sheetObjects["blIss"].GetSaveString();
            document.getElementById("do_no").value=sheetObjects["japDoInfo"].GetCellValue(1, "japDoInfo_jp_do_id");
            var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0326GS.do", sparam);
            sheetObjects["doRlseSts"].LoadSaveData(sXml);
            sXml=ComDeleteMsg(sXml); 
        break;
        case MULTI04:// Hold
            if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            if(document.getElementById("evnt_flag").value =='H'){
                //Are you sure to Hold?
                if(!ComShowCodeConfirm('BKG00671')){
                    return false;
                }
            }
            formObj.f_cmd.value=MULTI04;
            var aryPrefix=new Array("blInfo_");    //prefix string array
            var sParam1=sheetObjects["blInfo"].GetSaveString(true);
            var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0326GS.do", sparam);
            sheetObjects["blInfo"].LoadSaveData(sXml);
            sXml=ComDeleteMsg(sXml);   
        break;
        case MULTI05:// JP DO ID Save
            if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            CopyFormToRow(formObj, sheetObjects["japDoInfo"], 1, "");
            //Check for changes in the Grid
            if(! sheetObjects["japDoInfo"].IsDataModified()){
                ComShowCodeMessage('BKG00797');
                return false;
            }
            formObj.f_cmd.value=MULTI05;
            sheetObjects["japDoInfo"].SetRowStatus(1,"U");
            var aryPrefix=new Array("japDoInfo_");    //prefix string array
            var sParam1=sheetObjects["japDoInfo"].GetSaveString();
            var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0326GS.do", sparam);
            sheetObjects["japDoInfo"].LoadSaveData(sXml);
            sXml=ComDeleteMsg(sXml); 
        break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction){
    var oForm=document.form;
    if(sAction ==IBSAVE){
        if(parseInt(document.getElementById("blIss_obl_cpy_knt").value) < parseInt(document.getElementById("blIss_obl_rdem_knt").value)){
            //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.\nYou have input the number in Received field less or the same number of B/L Released.
            ComShowCodeMessage('BKG40065');
            document.getElementById("blIss_obl_rdem_knt").focus();
            return false;
        }
        if(!ComChkObjValid(oForm.cstmsInfo_cy_op_cd)) return false;
    }else if(sAction ==IBSEARCH){
        conditionTrim();
        if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.bkg_no)){
            ComShowCodeMessage('BKG40097'); 
            ComSetFocus(oForm.bl_no)
            return false;
        }
        if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
            return false;
        }
    //DEM.DET Retrieve
    }else if(sAction == COMMAND07){
        if(!ComChkObjValid(oForm.exp_del_dt)) {
            return false;
        }
        var toDay=ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
        var expDelDt=formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
        if(toDay > expDelDt){
            ComShowCodeMessage('BKG40114', expDelDt);
            return false;
        }
    }
    return true;
}
/**************************************************************
    TRIC SELECT BOX CODE START
**************************************************************/
/**
 * HTML Control  deactivate Event <br>
 **/
function showHideLayers() {
    var el=ComGetEvent();
    if(el.tagName.toLowerCase() !='input'){
        return;
    }
    if(blLayer.style.visibility == "visible"){
        blLayer.style.visibility="hidden";
    }else{
        var rect=el.getBoundingClientRect();
        $('#blLayer').css('top', (rect.top + 25) + 'px')
                     .css('left', rect.left + 'px')
                     .css('border-color',rgbToHex($(el).css('borderTopColor')))
                     .css('width', (rect.width - 2) + 'px');

        blLayer.style.visibility="visible";
    }
}

/**
 * Convert rgb color to hex
 * @param val - rgb(r, g, b)
 */
function rgbToHex(rgbString) {
	var parts = rgbString.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
	delete(parts[0]);
	for (var i = 1; i <= 3; ++i) {
	    parts[i] = parseInt(parts[i]).toString(16);
	    if (parts[i].length == 1) parts[i] = '0' + parts[i];
	} 
	return '#' + parts.join('').toUpperCase();
}
/**
 * TRiC SELECT BOX setting
 */

function conditionSet(aryPopupData){
   	
	if(aryPopupData != undefined){
        document.getElementById("bl_no").value  = aryPopupData[0][3]+aryPopupData[0][6];
        document.getElementById("bkg_no").value = aryPopupData[0][5];
    }
	
	$("#blLayer").empty();
	
    for (idx=1; idx<=sheetObjects["partial"].RowCount(); idx++) {
        if(document.getElementById("bl_no").value == sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")){
            $("#blLayer").append("<table><tr><td><input  type='text' name='hdn_bl_no' id='hdn_bl_no' class='input'  value='"+sheetObjects["partial"].GetCellValue(idx, "partial_bl_no")+' '+sheetObjects["partial"].GetCellValue(idx, "partial_bl_tp_cd")+"' readonly style='border:0; height:15;background-color:rgb(49,106,197);COLOR:#FFFFFF' onmouseover='blNoSelect("+idx+");' onclick='blNoSelect("+idx+")'></td></tr></table>");
        }else{
        	$("#blLayer").append("<table><tr><td><input type='text' name='hdn_bl_no' id='hdn_bl_no'  class='input' value='"+sheetObjects["partial"].GetCellValue(idx, "partial_bl_no")+' '+sheetObjects["partial"].GetCellValue(idx, "partial_bl_tp_cd")+"' readonly style='border:0; height:15;' onmouseover='blNoSelect("+idx+");' onclick='blNoSelect("+idx+")'></td></tr></table>");
        }
    }
    ComSetFocus(document.form.bl_no);
}


/**
 * Call Select Container partial Bl_No pop-up <br>
 **/
function blSelectPopOpen(){
    var sXml=IBS_GetDataSearchXml(sheetObjects["partial"]);
    document.form.xmlData.value=sXml;
    ComOpenPopup("/opuscntr/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
}
function blNoSelect(idx){
document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bkg_no");
document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_tp_cd");
    var length=document.getElementsByName("hdn_bl_no").length;
    if(document.getElementsByName("hdn_bl_no").length > 1){
        for(var i=1; i<=length; i++){
            if(i==idx){
                document.all.hdn_bl_no[i-1].style.backgroundColor='rgb(49,106,197)';
                document.all.hdn_bl_no[i-1].style.color='#FFFFFF';
            }else{
                document.all.hdn_bl_no[i-1].style.backgroundColor='#FFFFFF';
                document.all.hdn_bl_no[i-1].style.color='black';
            }
        }
    }
}
/**
 * BL_NO input BKG_NO, CNTR_NO initialization<br>
 */
function conditionReset(){
    if (ComGetEvent("name") == "bl_no") {
        document.getElementById("bkg_no").value='';
        document.getElementById("blInfo_split_flg").value='';
        document.getElementById("cntr_no").value='';
        document.getElementById("h_cntr_no").value='';
    }else if (ComGetEvent("name") == "bkg_no") {
        document.getElementById("bl_no").value='';
        document.getElementById("cntr_no").value='';
        document.getElementById("h_cntr_no").value='';
    }else if (ComGetEvent("name") == "cntr_no") {
        document.getElementById("bl_no").value='';
        document.getElementById("bkg_no").value='';
        document.getElementById("blInfo_split_flg").value='';
        document.getElementById("h_cntr_no").value='';
    }
    if(ComGetEvent("name") == "bkg_no" ){
        try {
            $("#blLayer").empty();
        }catch(e){}
    }
}
/**
 * End of Search condition remove the spaces
 */
function conditionTrim(){
    document.getElementById("bl_no").value=document.getElementById("bl_no").value.trim();
    document.getElementById("bkg_no").value=document.getElementById("bkg_no").value.trim();
    document.getElementById("cntr_no").value=document.getElementById("cntr_no").value.trim();
}
/**
 * O/BL Received set
 */
function obl_rdem_knt_change(obj){
    var sheetObj=sheetObjects["blIss"];
    if (sheetObj.LastRow()== 0 ) {return;}
    var blTpCd=sheetObj.GetCellValue(1, "blIss_bl_tp_cd");
    var oblRedmFlg=sheetObj.GetCellValue(1, "blIss_obl_rdem_flg");
    var delCntCd=sheetObj.GetCellValue(1, "blIss_del_cnt_cd");
    if (blTpCd == "S" || blTpCd == "W") {
        //document.form.blIss_obl_rdem_flg.value = "Y";
        ComBtnDisable("btn_obl_cancel");
        document.getElementById("blIss_obl_rdem_knt").disabled=true;
        document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=true;
        document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
    } else if (document.form.blIss_obl_rdem_flg.value == "Y") {
        ComBtnEnable("btn_obl_cancel");
        document.getElementById("blIss_obl_rdem_knt").disabled=false;
        document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=true;
        document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
    } else {
        ComBtnDisable("btn_obl_cancel");
        document.getElementById("blIss_obl_rdem_knt").disabled=false;
        document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=false;
        if (document.form.blIss_obl_rdem_flg.value == "N" && document.getElementById("blIss_bl_otr_doc_rcv_cd").value !=''){
            document.getElementById("blIss_otr_doc_cgor_flg").disabled=false;
        }else{
            document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
        }
    }
}
//By receiving information from ERP set Select Box
function addSel(sheetObj) {
    var sel=document.form.tot_ots_amt;
    var prefix="otsRcvInfo_";
    for (i=sel.length-1; i>=0; i--){
        sel.options[i]=null
    }
    //Recovery of receivables
    if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='C'){
        // btn_cct disable
        document.getElementById("div_btn_cct").style.visibility="hidden";
        document.getElementById("div_btn_third_cct").style.visibility="hidden";
    } else if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='N'){
        // btn_cct, div_btn_third_cct visible
    if (sheetObj.GetCellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
          document.getElementById("div_btn_cct").style.visibility="visible";
        }else {
          document.getElementById("div_btn_cct").style.visibility="hidden";
        }
    if (sheetObj.GetCellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
          document.getElementById("div_btn_third_cct").style.visibility="visible";
        } else {
          document.getElementById("div_btn_third_cct").style.visibility="hidden";
        }
    } else {
        document.form['tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
        document.getElementById("tot_ots_amt").className="input2_1";
        // btn_cct disable
        document.getElementById("div_btn_cct").style.visibility="hidden";
        document.getElementById("div_btn_third_cct").style.visibility="hidden";
        return;
    }
    var unit="";
    var amount="";
    var colorFlg="";
    for (j=0; j<5; j++){
        unit=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
        amount=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_amt"+parseInt(j+1));
        if(! ComIsEmpty(unit)){
            if (amount > 0) {
                colorFlg="Y";
            }
            document.form['tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);                
        }
    }
    if (colorFlg == "Y") {
        //Bold font color to red
        document.getElementById("tot_ots_amt").className="input2_1";
    } else {
        document.getElementById("tot_ots_amt").className="input2";
    }
}
//Remark For Release Popup Call

var releaseRemarkFlag = false;
function remarkForReleasePop(){
	 if(releaseRemarkFlag == false){
        var condition = "?bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
        ComOpenPopup("/opuscntr/ESM_BKG_0954.do"+condition, 600, 250, "callBack0954", '0,1,1,1,1,1,1', true);
        return false;
    }
    return true;
}
/**
 * Popup Ok Event Handling.<br>
 */
function callBack0954(result){
	 if(!ComIsNull(result)){
		 ComShowCodeMessage("BKG00166"); //Data Saved Successfully!!
		 
	   	 document.form.releaseRemark.value =result;
	   	 releaseRemarkFlag = true;
	   	 
	   	 //@ Pop-Up 레이어를 닫기 위해 시간차를 둠
	   	 setTimeout( function () { //@ setTimeout ###########################################################
	       	 //Release 함.
	       	 var formObject=document.form;
	       	 doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI01);
	   	 } , 100);//@ setTimeout end ###########################################################
    }
 }    


function tpbImgSet(tpbStatus) {
    if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
    if(document.getElementById("tpb_status").value == "1"){
        document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
        document.getElementById("tpb_cd").value='C';
        document.getElementById("btn_tpb").style.visibility="visible";
        //tooltip C=Cleared
        document.getElementById("tpb_cd").setAttribute("title", "Cleared");
    }else if(document.getElementById("tpb_status").value == "0"){
        document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
        document.getElementById("tpb_cd").value='P';
        document.getElementById("btn_tpb").style.visibility="visible";
        //tooltip P=Processing
        document.getElementById("tpb_cd").setAttribute("title", "Processing");
    }else{
        document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
        document.getElementById("tpb_cd").value='';
        document.getElementById("btn_tpb").style.visibility="hidden";
        document.getElementById("tpb_cd").removeAttribute("title");
    }
}
//OBL Cancel button click -> Initialize the value of OBL
function oblInit(){
    document.getElementById("blIss_otr_doc_cgor_flg").value='';
    document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
    document.getElementById("blIss_obl_rdem_knt").value='0';
    document.getElementById("blIss_obl_rdem_ofc_cd").value='';
    document.getElementById("blIss_obl_rdem_usr_id").value='';
    document.getElementById("blIss_obl_rdem_dt").value='';
    document.getElementById("bl_surr_rmk_flg").value='';
    document.getElementById("blIss_otr_doc_rcv_ofc_cd").value='';
    document.getElementById("blIss_otr_doc_rcv_usr_id").value='';
    document.getElementById("blIss_otr_doc_rcv_dt").value='';
    document.getElementById("blIss_ibd_doc_rcv_flg").value='N';
    document.getElementById("blIss_ibd_doc_rcv_ofc_cd").value='';
    document.getElementById("blIss_ibd_doc_rcv_dt").value='';
    document.getElementById("blIss_ibd_doc_rcv_usr_id").value='';
    //CR : Cancelled O/BL Received
    document.getElementById("do_cng_evnt_cd").value='CR';
    document.getElementById("pre_ctnt").value='N';
    document.getElementById("crnt_ctnt").value='Y';
    document.getElementById("obl_cng_flg").value='Y';
}
/************************************************************************************
    IBSHEET  OnSaveEnd Event Processing Start
************************************************************************************/
/**
 * handling After save  blInfo 
 */
function blInfo_OnSaveEnd(sheetObj, ErrMsg){
        doActionIBSheet(sheetObj, document.form,IBSEARCH);
}
/**
 * handling After save  refInfo
 */
function refInfo_OnSaveEnd(sheetObj, ErrMsg){
        doActionIBSheet(sheetObj, document.form,IBSEARCH);
}
/**
 * handling After save  doRlseSts
 */
function doRlseSts_OnSaveEnd(sheetObj, ErrMsg){
        doActionIBSheet(sheetObj, document.form,IBSEARCH);
}
/**
 * handling After save  JP DO ID
 */
function japDoInfo_OnSaveEnd(sheetObj, ErrMsg){
        doActionIBSheet(sheetObj, document.form,IBSEARCH);
}
/************************************************************************************
/************************************************************************************
    IBSHEET  OnSearchEnd Event Processing Start
************************************************************************************/
/**
 * handling After  search IBSheet
 */
function partial_OnSearchEnd(sheetObj,Code,ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        try {
        	$("#blLayer").empty();
        }catch(e){}
        if(sheetObj.RowCount()> 1){
            blSelectPopOpen();
        }else if(sheetObj.RowCount()== 1){
            document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(1, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(1, "partial_"+"bl_tp_cd");
            document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(1, "partial_"+"bkg_no");
            conditionSet();
            doActionIBSheet(sheetObjects["blInfo"], document.form ,IBSEARCH);
        }else{
            sheetObjects["partial"].RemoveAll();
            ComShowCodeMessage('BKG00379');
        }
    }
}
/**
 * Japan D/O Release General Information search
 * handling After  search IBSheet
 */
function blInfo_OnSearchEnd(sheetObj,Code, ErrMsg){
    //Wait Image Show Hidden
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            ComCopyRowToForm(sheetObj, 1, form, "");
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_hold");
            //Search conditions
            document.getElementById("bkg_no").value=sheetObj.GetCellValue(1,"blInfo_bkg_no");
            if(sheetObj.GetCellValue(1,"blInfo_bl_tp_cd") !='B'){
                document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no")+sheetObj.GetCellValue(1,"blInfo_bl_tp_cd");
            }else{
                document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no");
            }
        }
        /*************************************************************
            TPB status=> 0 : red 1 : green -1 : gray
        *************************************************************/
        tpbImgSet(document.getElementById("tpb_status").value);
        // Button to Enable
        ComBtnEnable("btn_erp");
        ComBtnEnable("btn_dem_retrieve");
        ComBtnEnable("btn_dmdt");
        ComBtnEnable("btn_history");
        if (sheetObj.GetCellValue(1,"blInfo_lcloblissueflg") == "Y") {
            ComShowCodeMessage("BKG00667");
        }
        if (document.getElementById("blInfo_cntr_prt_flg").value == "Y") {
            //Bold font color to red
            document.getElementById("blInfo_cntr_prt_flg").style.color="red";               
            document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="bold";
        } else {
            document.getElementById("blInfo_cntr_prt_flg").style.color="";
            document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="normal";
        }
        if (document.getElementById("blInfo_soc_flg").value == "Y") {
            //Bold font color to red
            document.getElementById("blInfo_soc_flg").style.color="red";                
            document.getElementById("blInfo_soc_flg").style.fontWeight="bold";
        } else {
            document.getElementById("blInfo_soc_flg").style.color="";
            document.getElementById("blInfo_soc_flg").style.fontWeight="normal";
        }
    }else{
        var resetSheetNames=new Array("blInfo", "refInfo", "cstmsInfo", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "japDoInfo", "otsRcvPop"); //prefix string array
        for(var idx=0; idx < resetSheetNames.length; idx++){
            sheetObjects[resetSheetNames[idx]].RemoveAll();
        }
    }
}
/**
 * Japan D/O Release Reference Info Search
 * handling After  search IBSheet
 */
function refInfo_OnSearchEnd(sheetObj, Code,ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            ComCopyRowToForm(sheetObj, 1, form, "");
            if(sheetObj.GetCellValue(1, "refInfo_do_hld_flg") =='N'){
                document.getElementById("hold_flag").className="input2";
                document.getElementById("evnt_flag").value='H';
                document.getElementById("hld").style.display="";
                document.getElementById("uhld").style.display="none";
            }else if(sheetObj.GetCellValue(1, "refInfo_do_hld_flg") =='Y'){
                document.getElementById("hold_flag").className="input2_1";
                document.getElementById("hold_flag").value='Hold';
                document.getElementById("evnt_flag").value='R';
                document.getElementById("hld").style.display="none";
                document.getElementById("uhld").style.display="";
            }else{
                document.getElementById("hold_flag").className="input2";
                document.getElementById("evnt_flag").value='H';
                document.getElementById("hld").style.display="";
                document.getElementById("uhld").style.display="none";
            }
            var cstmsInfo_info_cgo_flg=sheetObj.GetCellValue(1, "cstmsInfo_info_cgo_flg");
            if(cstmsInfo_info_cgo_flg !='N'){ 
                cstmsInfo_info_cgo_flg='Y';
            }
            document.getElementById("cstmsInfo_info_cgo_flg").value=cstmsInfo_info_cgo_flg;
            chkRemark();
        }
    }
}
/**
 * Hidden IBSheet post-processing
 */
function blIss_OnSearchEnd(sheetObj, code ,ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            ComCopyRowToForm(sheetObj, 1, form, "");
        }
        if (document.form.blIss_bl_tp_cd.value == "") {
            document.form.blIss_bl_tp_cd.value="B";
        }
        if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
            document.getElementById("blIss_obl_rdem_flg").style.color='blue';
        }else if(document.getElementById("blIss_obl_rdem_flg").value =='N'){
            document.getElementById("blIss_obl_rdem_flg").style.color='red';
        }
        document.getElementById("h_ori_obl_rdem_flg").value=document.getElementById("blIss_obl_rdem_flg").value;
        document.getElementById("h_aft_obl_rdem_flg").value=document.getElementById("blIss_obl_rdem_flg").value;
        //D/O EVENT Value before the change. -->
        document.getElementById("pre_ctnt").value=document.getElementById("blIss_obl_rdem_knt").value;
        obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"))
        if (sheetObj.GetCellValue(1, "blIss_bl_tp_cd") == "S") {
            document.getElementById("bl_surr_rmk_flg").value="Y";
            document.getElementById("div_btn_bl_surr_flg").style.visibility="visible";
        } else {
            document.getElementById("bl_surr_rmk_flg").value="";
            document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
        }
    }
    //O/BL Received Value before the change
    document.getElementById("old_obl_rdem_knt").value=sheetObj.GetCellValue(1, "blIss_obl_rdem_knt");
}
/**
 * Hidden IBSheet post-processing
 */
function demInfo_OnSearchEnd(sheetObj, code ,ErrMsg){
    //Wait Image Show Hidden
    ComOpenWait(false);
    sheetObj.FitColWidth();

    ComBtnEnable("btn_dem_retrieve"); //DMDT
    ComBtnEnable("btn_dmdt");         //RCV Cancel
}
/**
 * Hidden IBSheet post-processing
 */
function demDtl_OnSearchEnd(sheetObj, code ,ErrMsg){
    ComOpenWait(false);
    sheetObj.FitColWidth();
    var invTotBilAmt=0;
    //Container Information the container number of the first
    var fist_cntr_no=sheetObjects["demInfo"].GetCellValue(1, "demInfo_cntr_no");
    for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        //INVOICE =  first container number -> show
        if(fist_cntr_no != sheetObjects["demDtl"].GetCellValue(idx, "demDtl_cntr_no")){
            sheetObjects["demDtl"].SetRowHidden(idx,1);
        }
    }
}
/**
 * Hidden IBSheet post-processing
 */
function totBlbAmt_OnSearchEnd(sheetObj, code, ErrMsg){
    ComOpenWait(false);
    var sel=document.form.tot_bil_amt;
    //Initialization SELECT BOX 
    for (i=sel.length-1; i>=0; i--){
        sel.options[i]=null
    }
    var currCd="";
    var bilAmt="";
    var demSts=false;
    if (sheetObj.RowCount()> 0) {
        for (j=0; j<sheetObj.RowCount(); j++){
            currCd=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
            bilAmt=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");
            if (parseInt(bilAmt) > 0) {
              demSts=true;
            }
            document.form['tot_bil_amt'][j]=new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
        }
        if (demSts == true) {
            document.getElementById("demur_sts").value="N";
            document.getElementById("demur_sts").style.color='red';
            document.getElementById("tot_bil_amt").className="input2_1";
        } else {
            document.getElementById("demur_sts").value="Y";
            document.getElementById("demur_sts").style.color='blue';
            document.getElementById("tot_bil_amt").className="input2";
        }
    } else {
        document.getElementById("demur_sts").value="Y";
        document.getElementById("demur_sts").style.color='blue';
        document.form['tot_bil_amt'][0]=new Option('0');
        document.getElementById("tot_bil_amt").className="input2";
    }
    ComSetUIItem(sheetObjects["blInfo"], document.form, "BKG", "ESM_BKG_0326");
}
/**
 * Hidden IBSheet post-processing
 * Japanese Customs - B/L INFO extraction
 */
function cstmsInfo_OnSearchEnd(sheetObj, code, ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            ComCopyRowToForm(sheetObj, 1, form, "");
        }
    }
}
/**
 * Hidden IBSheet post-processing
 * Fare Payment and Outstanding Amounts Info
 */
function otsRcvInfo_OnSearchEnd(sheetObj, code, ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            ComCopyRowToForm(sheetObj, 1, form, "");
            addSel(sheetObj);
            if( document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='Y'){
                document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='blue';
            }else if(document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='N'){
                document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='red';
            }
        }
    }
}
/**
 * Hidden IBSheet post-processing
 * B/L D/O STATUS(ASSIGN, RELEASE, ISSUE) Detail Info
 */
function doRlseSts_OnSearchEnd(sheetObj, code, ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            //D / O state is set to Hidden Value.
            for(var idx=1; idx <= sheetObj.RowCount(); idx++){
                //value setting before cancel 
                if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") != 'C'){
                    document.getElementById("rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
                }
                //value setting last row 
                if(idx == sheetObj.RowCount()){
                    document.getElementById("last_rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
                }
                //Button Control
                if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'I'){
                    ComBtnEnable("btn_cancel");
                    ComBtnEnable("btn_if");
                    ComBtnEnable("btn_do_id_save");
                }else if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'D'){
                    ComBtnDisable("btn_cancel");
                    ComBtnDisable("btn_if");
                    ComBtnDisable("btn_do_id_save");
                }
                ComBtnEnable("btn_remark");
                ComBtnEnable("btn_receiverinfo");
                ComBtnEnable("btn_doprint");
                ComBtnEnable("btn_print");
                ComBtnEnable("btn_recprint");
                ComBtnDisable("btn_assign");
            }
            // D/O_No setting hidden value
            document.getElementById("do_no").value=sheetObj.GetCellValue(1, "doRlseSts_do_no");
            document.getElementById("do_no_split").value=sheetObj.GetCellValue(1, "doRlseSts_do_no_split");
            //result Retrieve  : Cancel
            if(sheetObj.RowCount()== 1 && sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd") == 'C'){
                ComBtnDisable("btn_cancel");
                ComBtnDisable("btn_if");
                ComBtnEnable("btn_assign");
                ComBtnDisable("btn_remark");
                ComBtnDisable("btn_do_id_save");
            }
            //D/O EVENT Value before the change. -->
            document.getElementById("pre_ctnt").value=sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd");
            //High-Light last row the show 
//            sheetObj.SelectCell(sheetObj.RowCount(),0)
        }else{
            ComBtnEnable("btn_assign");
        }
    }
}
/**
 * Hidden IBSheet post-processing
 * JP DO ID information processing
 */
function japDoInfo_OnSearchEnd(sheetObj, code, ErrMsg){
    ComOpenWait(false);
    if (ErrMsg == "") {
        if(sheetObj.RowCount()> 0){
            //Grid Data copy to Html argument .
            ComCopyRowToForm(sheetObj, 1, form, "");
        if(sheetObj.GetCellValue(1, "japDoInfo_jp_do_snd_sts_cd") == 'S'){
                ComBtnEnable("btn_dorcancel");
            }else{
                ComBtnDisable("btn_dorcancel");
            }
            //* '          ' Space 10
        if(sheetObj.GetCellValue(1, "japDoInfo_jp_do_id") == '          '){
                document.getElementById("btn_do_id_save").style.color='rgb(247,217,9)';
            }
        }
    }
}
/************************************************************************************
    IBSHEET OnSearchEnd Event Processing End
************************************************************************************/
/************************************************************************************
    IBSHEET OnClick Event Processing Start
************************************************************************************/
/**
 * OnClick event of the Grid: Displays INVOICE information 
 */
function demInfo_OnDblClick(sheetObj, row, col){
    //Container Information the container number of the first
    var click_cntr_no=sheetObj.GetCellValue(row, "demInfo_cntr_no");
    //click -> the pop-up calls
    demDtlPopOpen(click_cntr_no)
}
/**
 * DEM.DET pop-up 
 */
function demDtlPopOpen(cntr_no){
    var sXml=IBS_GetDataSearchXml(sheetObjects["demDtl"]);
    document.form.demDtlXmlData.value=sXml;
    var condition="?";
    condition += "cntr_no="+cntr_no;
    ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
}
/**
 * CCT,Third Office(CCT) <br>
 **/
function blOutstandingAmountPopOpen(flag){
    if (sheetObjects["otsRcvInfo"].RowCount()== 0) {
        alert("Outstanding Amount 값이 존재하지 않습니다.");
        return;
    }
    sheetObjects["otsRcvPop"].RemoveAll();
    var maxRow=sheetObjects["otsRcvInfo"].LastRow();
    var cellValue="";
    var prefix="otsRcvInfo_";
    var curr_cd="";
    var ots_amt=0;
    for(i=1;i <= maxRow ; i++){
        //Set the text color depending on the state
        for(var q=1;q<6;q++){
            if (flag == true) { // selected CCT 
                if (sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                    curr_cd=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_curr_cd" + q);
                    ots_amt=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q);
                    sheetObjects["otsRcvPop"].DataInsert(-1);
                    sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_curr_cd",curr_cd,0);
                    sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_tot_ots_amt",ots_amt,0);
                }
            } else {            //selected Third Office(CCT)
                if (sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                    curr_cd=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                    ots_amt=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q);
                    sheetObjects["otsRcvPop"].DataInsert(-1);
                    sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_curr_cd",curr_cd,0);
                    sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_tot_ots_amt",ots_amt,0);
                }
            }
        }
    }
    if (sheetObjects["otsRcvPop"].RowCount()> 0) {
        var sXml=IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
        document.form.oaXmlData.value=sXml;
        ComOpenPopup("/opuscntr/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
    }
}
function fncTextareaMaxLine(obj){
    var str_line=obj;
    line=str_line.split("\r\n");
    ln=line.length;
    if(ln == 5 && event.keyCode == 13){
        event.returnValue=false;
    }
}
function fnSearchContainer(){
    var formObj=document.form;
    if (ComIsNull(formObj.cntr_no)) return;
    if(document.getElementById("h_cntr_no").value == document.getElementById("cntr_no").value) {
        return;
    }
    //Prevent re-viewed as cntr_no
    document.getElementById("h_cntr_no").value=document.getElementById("cntr_no").value;
    //Pop-up call
    formObj.f_cmd.value=SEARCH01;
    sheetObjects["partial"].DoSearch("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("partial_") );
}
function doPreview() {
    var formObject=document.form;
    if(document.getElementById("evnt_flag").value == 'R'){
        ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "D/O Preview");
        return;
    }
    if(document.getElementById("mrd_id").value == ""){
        ComShowCodeMessage("BKG40080");
        return;
    }
    var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
    var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no")
    formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + formObject.mrd_id.value + ".mrd";
    formObject.com_mrdArguments.value="/rv form_doNo['"+doNo+"'] form_bkgNo['"+bkgNo+"'] form_usrId['"+strUsr_id+"']  form_mainOnly[N] form_ofcCd['" + lginOfcCd + "'] " + formObject.mrd_param.value; // *Change the parameters to fit mrd
    formObject.com_mrdBodyTitle.value="DELIVERY ORDER";
    
    ComOpenRDPopup();
}

function doPrint() {
//    var Rdviewer=rdObjects[0];
	var appendReport = [];
	var formObject=document.form;

    if(document.getElementById("evnt_flag").value == 'R'){
        ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "D/O Preview");
        return;
    }
    
    if(document.getElementById("mrd_id").value == ""){
        ComShowCodeMessage("BKG40080");
        return;
    }
    
    var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
    if(doNo == ""){
        var blNo="";
        if (sheetObjects["blInfo"].RowCount()> 0) {
        	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
        }
        ComShowCodeMessage("BKG40059", blNo);
        return;
    }

    
    var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no")
    formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + formObject.mrd_id.value + ".mrd";

    var strArg="/rv form_doNo['"+doNo+"'] form_bkgNo['"+bkgNo+"'] form_usrId['"+strUsr_id+"']  form_mainOnly[N] form_ofcCd['" + lginOfcCd + "'] " + formObject.mrd_param.value; // *Change the parameters to fit mrd
    var rdParam=strArg + " /riprnmargin /rwait";
    var strPath=RD_path+ formObject.com_mrdPath.value;
    
    formObject.com_mrdBodyTitle.value="DELIVERY ORDER";
    
    appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
    directReportDownload(appendReport);
//    viewer.openFile(strPath, RDServer + rdParam, {timeout:1800});
//    viewer.print({isServerSide:true});
}

function receiptPreview() {
    var formObject=document.form;
    if(document.getElementById("evnt_flag").value == 'R'){
        ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Receipt Preview");
        return;
    }
    var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
    var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no")
    var rdParam="/rv form_bkgNo['"+bkgNo+"'] "
                + "form_doNo['"+doNo+"'] "
                + "form_type[2] "
                + "form_dataOnly[N] "
                + "form_usrId['"+strUsr_id+"'] "
                + "form_ofcCd['" + lginOfcCd + "'] "
                + "form_hiddeData[N] "
                + "form_Cntr[1] "
                + "form_level[(5)] "
                + "form_remark[] "
                + "form_mainOnly[N] "
                + "form_CorrNo[] "
                + "form_manifest[N] "
                + "form_his_cntr[BKG_CONTAINER] "
                + "form_his_bkg[BKG_BOOKING] "
                + "form_his_mkd[BKG_BL_MK_DESC] "
                + "form_his_xpt[BKG_XPT_IMP_LIC] "
                + "form_his_bl[BKG_BL_DOC] "
                + "/rp [] "
                + "/riprnmargin ";
    formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + 'ESM_BKG_0327.mrd';
    formObject.com_mrdArguments.value=rdParam;
    formObject.com_mrdBodyTitle.value="RECEIPT";
    ComOpenRDPopup();
}
/**
 * the value exists - Button Enable and Button color Red
 */
function chkRemark() {
   if (document.form.refInfo_inter_rmk.value.length > 0 ) {
       // if the Items value exists 
       buttonColorSet("btn_hold_remark", "red");
   } else {
       // if the Items  value not exists 
       buttonColorSet("btn_hold_remark", "gray");
   }
}
 /**
  * Button disabled
  * @param  void
  * @return void
  * @author
  * @version 2009.11.01
  **/
function buttonColorSet(btn_name, color){
    var tds=document.getElementsByTagName("td");
    var curFlag=null;
    curFlag="hand";
    for(var i=0; i < tds.length; i++) {
        var td=tds[i];
        if(td.name == '?' + btn_name){
            td.style.color=color;
            td.style.cursor=curFlag;
            if (btn_name == "btn_hold_remark") {
                document.form.h_hold_remark.value=color;
            }
            break;
        }else if(td.name == btn_name){
            td.style.color=color;
            td.style.cursor=curFlag;
            if (btn_name == "btn_hold_remark") {
                document.form.h_hold_remark.value=color;
            }
            break;
        }else{
            continue;
        }
    }
}
function funcSetRemark(remark) {
   document.form.refInfo_inter_rmk.value=remark;
   chkRemark();
}
/**
 * BCheck modified from and ask saved  
 * @param  void
 * @return void
 * @author  MoonHwan Choi
 * @version 2013.05.29
 **/
function chksaved() {
    var formObject=document.form;
    if(formObject.dirty_flag.value == "Y"){
        if(ComShowCodeConfirm("BKG00254")){
            doActionIBSheet(sheetObjects["blIss"], formObject,IBSAVE);
            formObject.dirty_flag.value="N";                
        }
    }
}

//GAP Display Credit Risk (2014.10.14 An Jin Eung)
/**
 * fnExistBlackListedCustomer  
 * param :_val
 */
function fnExistBlackListedCustomer(bkgNo) {
	
	var formObj = document.form;
	var sheetObj = sheetObjects["blInfo"];

	var param = "&f_cmd=" + COMMAND02 + "&input_text=" + bkgNo;
	
	var sXml = sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	var output_text=ComGetEtcData(sXml, "output_text");    	

	if (output_text != '') {
		ComShowMessage(ComGetMsg("BKG43055", output_text ));
		return false;// Y-> error
	}
	return true;
}
 