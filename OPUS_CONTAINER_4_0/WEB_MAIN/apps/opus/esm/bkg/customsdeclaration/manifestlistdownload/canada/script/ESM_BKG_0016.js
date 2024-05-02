/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0016.js
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
                    [Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * Define business script using on the screen.
 */

//Common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event Handler definition for Button Click event */
document.onclick=processButtonClick;
/**
 *  Event Handler for branch processing by judging button name.
 */
function processButtonClick() {
     /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject=sheetObjects[0];
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
        switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0], document.form, SEARCH);
            break;
        case "btn_save":
            doActionIBSheet(sheetObject, formObject, MULTI);
            break;
        case "s_btn_calendar":
            var cal=new ComCalendar();
            cal.select(formObject.s_vps_eta_dt, 'yyyy-MM-dd');
            break;
        case "e_btn_calendar":
            var cal=new ComCalendar();
            cal.select(formObject.e_vps_eta_dt, 'yyyy-MM-dd');
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComFuncErrMsg(e);
        } else {
            ComFuncErrMsg(e);
        }
    }
}
/**
 * Registering IBSheet Object in to Array
 * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
 * The array is defined at upper part of source
 * 
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet basic setting & initializing
 * onLoad Event HandlerImplementation of body tag
 * After loading screen in the browser, add function in pre-processing
 */
function loadPage() {
    for (i=0; i < sheetObjects.length; i++) {
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        // khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], document.form, INIT);
    document.form.frm_vsl_cd.focus();
    // 화면에서 필요한 이벤트
    axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    if (document.form.office.value == "Origin") {
        ComBtnDisable("btn_save");
    }
}
/**
 *  Definition for sheet initial setting value, header
 * param : sheetObj ==> sheet object, sheetNo ==> If the serial number ID tag attached to the sheet are many,
 * adding 'Case' clause as a number of sheets, configures initial module.
 * @param sheetObj sheet objec
 * @param sheetNo Sheet object tag ID attached serial number
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
        
            var HeadTitle1="|Vessel Code|Lloyd No.|Country|Name|Registry Port|Registry Official No.|Registry Date|Gross Weight|Net Weight|Dead Weight|Crew|Call Sign|L.O.A.|Safety Construction|Safety Radio|Safety Equipment|Loadline|Derat|Carrier Code";
            var headCount=ComCountHeadTitle(HeadTitle1);
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lloyd_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_rgst_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgst_port_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgst_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgst_dt",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"grs_rgst_tong_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"net_rgst_tong_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dwt_wgt",                     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crw_knt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"loa_len",                     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_sft_cstru_certi_exp_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_sft_rdo_certi_exp_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_sft_eq_certi_exp_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_lod_line_certi_exp_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_derat_certi_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
            InitColumns(cols);
            
            SetEditable(1);
            SetSheetHeight(100);
            SetVisible(0);
        }

        break;
    }
}

/**
 * Handling process about Sheet
 * @param sheetObj Sheet
 * @param formObj form object
 * @param sAction job processing code
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case SEARCH: //Retrieve
        if (validateForm(sheetObj, formObj, sAction)) {
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_0016GS.do", FormQueryString(formObj) );
        }
        break;
    case MULTI: //Save
        if (sheetObj.RowCount()> 0) {
            if (validateForm(sheetObj, formObj, sAction)) {
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI;
                IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
                sheetObj.DoSave("ESM_BKG_0016GS.do", FormQueryString(formObj));
                ComOpenWait(false);
            }
        } else {
            ComShowCodeMessage('BKG000012');
            return;
        }
        break;
    }
}
/**
 * Handling validity verification process about screen form input value.
 * @param sheetObj Sheet
 * @param formObj form object
 * @param sAction job processing code
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case SEARCH:
        //checking basic format
        if (!ComChkObjValid(formObj.frm_vsl_cd))
            return false;
        break;
    case MULTI:
        //checking basic format
        if (!ComChkValid(formObj))
            return false;
        break;
    }
    return true;
}


function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
    var formObj= document.form;
    if (sheetObj.RowCount()> 0) {
        IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
        formObj.frm_grs_rgst_tong_wgt.value=ComAddComma2(formObj.frm_grs_rgst_tong_wgt, "#,###.00");
        formObj.frm_net_rgst_tong_wgt.value=ComAddComma2(formObj.frm_net_rgst_tong_wgt, "#,###.00");
        formObj.frm_dwt_wgt.value=ComAddComma2(formObj.frm_dwt_wgt, "#,###.00");
        formObj.frm_crw_knt.value=ComAddComma2(formObj.frm_crw_knt, "#,###");
        formObj.frm_loa_len.value=ComAddComma2(formObj.frm_loa_len, "#,###.00");
    } else {
        for ( var i=0; i < formObj.getElementsByTagName("input").length; i++) {
            if (formObj.getElementsByTagName("input")[i].name != "frm_vsl_cd") {
                formObj.getElementsByTagName("input")[i].value="";
            }
        }
    }
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
}
