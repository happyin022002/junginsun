/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0246.js
*@FileTitle  : Disposal Performance by Buyer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                        MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                        OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Sheet Select Back Color */
var MNR_SELECT_BACK_COLOR="#99FFFF";
var MNR_TOTCOL_BACK_COLOR="#EFEBEF";
var cntrTpSz=new Array();
var chssTpSz=new Array();
var gsetTpSz=new Array();
var vCntrTpszHdr="| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
var vArrCntrTpsz=vCntrTpszHdr.split("|");
var vCntrTpszCnt=vArrCntrTpsz.length;
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObj=document.form;
    try {
        var srcObj=ComGetEvent();
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
                break;
            case "btn_New":
                ComResetAll();
                setDynamicEqTpszHeader(sheetObjects[0], "U");
                ComSetFocus(formObj.p_str_evnt_dt);
                for(var i=0; i < comboObjects.length; i++) {
                    comboObjects[i].SetSelectIndex(0);
                }
                break;
            case "btns_search": //retrieving Buyer popup
                openPopup("1");
                break;
            case "btns_calendar":   // Event Duration (FromTo)
                if ( srcObj.style.filter == "" ) {
                    var cal=new ComCalendarFromTo();
                    cal.select(formObj.p_str_evnt_dt, formObj.p_end_evnt_dt, 'yyyy-MM-dd');
                }
                break;
            case "btn_DownExcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
                }
                break;
        } // end switch
    } catch(e) {
        if(e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBMultiCombo Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    var formObj=document.form;
    for(i=0; i < sheetObjects.length; i++) {
        //
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        //
        ComEndConfigSheet(sheetObjects[i]);
    }
    /* initializing IBMultiCombo */
    for ( var k=0 ; k < comboObjects.length ; k++ ) {
        initCombo(comboObjects[k], k+1);
    }

    sheet1OnLoadFinish(sheetObjects[0]);
}
/**
 * handling event after ending sheet Load
 */
function sheet1OnLoadFinish(sheetObj) {
    var formObj=document.form;
    /* IBMulti Combo Item Setting */
    doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
    /* Axon Control Setting*/
    initControl();
    /* 초기 Focus Setting */
    ComSetFocus(formObj.p_str_evnt_dt);
}
// Axon handling event
// 1. event catch
function initControl() {
    var formObj=document.form;
    axon_event.addListenerFormat('blur',        'obj_blur',     formObj); 
    //axon_event.addListenerFormat('focus',       'obj_focus',    formObj); 
    axon_event.addListenerFormat('keypress',    'obj_keypress', formObj); 
    axon_event.addListenerFormat('keyup',       'obj_keyup',    formObj); 
    axon_event.addListenerForm('keydown',       'obj_keydown',  formObj); 
    axon_event.addListenerForm('change',        'obj_change',   formObj); 
}
//setting event duplicate
var preEventType=null;
// 2. handling event -- Start
/**
 * checking on HTML Control's onblur event.
 **/
function obj_blur() {
    var obj=ComGetEvent();
    if(preEventType == ComGetEvent("type")) {
        preEventType=null;
        return;
    }
    switch(ComGetEvent("name")) {
        default: //do nothing
            ComChkObjValid(obj);
            break;
    }
}
/**
 * checking on HTML Control's focus event.
 */
function obj_focus() {
    var obj=ComGetEvent();
    if(obj.readOnly) {
        ComSetNextFocus(obj);
    } else {
        //clearing mask separator
        ComClearSeparator(obj);
    }
}
/**
 * handling Change Event
 */
function obj_change() {
    var obj=ComGetEvent();
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var tabObj=tabObjects[0];
    switch(ComGetEvent("name")) {
        case "p_str_evnt_dt":
        case "p_end_evnt_dt":
            checkDurationDate(obj);
            break;
        case "p_eq_knd_cd":         //Equipment Type
            sheetObjects[0].RemoveAll();
            setDynamicEqTpszHeader(sheetObjects[0], obj.value);
            break;
        case "p_cust_cd":   //Buyer Code
            if ( ComTrim(obj.value) != "" ) {
                doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
            }
            break;
    }
}
/**
 * handling Key-Press Event
 */
function obj_keypress() {
    var obj=ComGetEvent();
    switch(ComGetEvent("dataformat")) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
        case "int":
            ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet();
            break;
        case "engup":
            if(obj.name == "p_cust_cd") {
                ComKeyOnlyAlphabet('uppernum');
            } else {
                ComKeyOnlyAlphabet('upper');
            }
            break;
        case "engdn":
            ComKeyOnlyAlphabet('lower');
            break;
        default:
            ComKeyOnlyNumber(obj);
            break;
    }
}
/**
 * handling Key-Up Event
 */
function obj_keyup() {
    var obj=ComGetEvent();
    var formObj=document.form;
    switch(ComGetEvent("name")) {
        case "p_cust_cd":
            if ( ComTrim(ComGetEvent("value")) == "" ) {
                clearForm(ComGetEvent("name"));
            } else {
                ComKeyEnter('LengthNextFocus');
            }
            break;
        default :
            ComKeyEnter('LengthNextFocus');
    }
}
/**
 * handling Key-Down Event
 */
function obj_keydown() {
    var obj=ComGetEvent();
    var vKeyCode=ComGetEvent("keyCode");
    var formObj=document.form;
    if(vKeyCode == 13) {
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    }
}
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
//2. handling event -- End
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var formObj=document.form;
    var sheetid=sheetObj.id;
    var cnt=0;
    switch(sheetid) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle="Buyer|Buyer|Currency||Result||G.TTL|Ratio"+ vCntrTpszHdr +"|";
                var headCount=ComCountHeadTitle(HeadTitle);
                    cnt=0;
                    SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:8, DataRowMerge:0, PrevColumnMergeMode:0} );
                    
                    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var colsList = new Array();
                    
					var cols = [{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:""},
					            {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:""},
					            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:""},
					            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cnt",         KeyField:0,   CalcLogic:"",   Format:"" },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rslt_tp_nm",       KeyField:0,   CalcLogic:"",   Format:""},
					            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rslt_tp_seq",      KeyField:0,   CalcLogic:"",   Format:""},
					            {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"pfmc_tpsz_dp00",   KeyField:0,   CalcLogic:"",   Format:""},
					            {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rato_tpsz_dp00",   KeyField:0,   CalcLogic:"",   Format:""}];

	                    for(var j = 1; j < vCntrTpszCnt; j++) {
	                        var tpsz_dp_no = "tpsz_dp"+ ComLpad(j, 2, "0");
	                        if(vArrCntrTpsz[j] != "" ){
	                        	cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pfmc_"+tpsz_dp_no, KeyField:0,   CalcLogic:"",   Format:""});
	                        	eval('SetColHidden("pfmc_tpsz_dp'+ ComLpad(j, 2, "0") + '",0);');
	                        }else{
	                        	cols.push({Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pfmc_"+tpsz_dp_no, KeyField:0,   CalcLogic:"",   Format:""});
	                        	eval('SetColHidden("pfmc_tpsz_dp'+ ComLpad(j, 2, "0") + '",1);');
	                        }
	                    }  

					InitColumns(cols);
					//SetSheetWidth(984);
                    SetEditable(0);
                    SetCountPosition(0);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
                //no support[implemented common]CLT                     SelectBackColor=MNR_SELECT_BACK_COLOR;
                        //SetCountFormat("[SELECTDATAROW / TOTALROWS]");
                    resizeSheet( sheetObj );
            }

            break;
    }
}
/**
 * setting combo initial values and header
 * param : comboObj, sheetNo
 * adding case as numbers of counting combos
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "combo2":
            with(comboObj) {
                SetDropHeight(150);
                SetUseAutoComplete(1);
                SetEnable(0);
                SetSelectIndex(0);
                SetMaxLength(6);
                SetSelectIndex(0);
            }
            break;
    }
}
/**
 * handling process for sheet
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param CondParam
 * @param PageNo
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCREATE:
            //Equipment Type/Size Grid Header Item Setting
            initDynamicEqTpszCd(sheetObj);
            setDynamicEqTpszHeader(sheetObj, formObj.p_eq_knd_cd.value);
            //Disposal Kind Combo Item Setting
            //retrieving common combo.
            var sCondition=new Array (
                new Array("MdmOrganization","RHQ","FALSE"), //RHQ_CD
                new Array("MnrGenCd","CD00038", "COMMON")   //DISP_RSN_CD
            )
            var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
            //setting combo data
            for(var i=0; i < comboList.length;i++){
                if(comboList[i] != null){
                    for(var j=0; j < comboList[i].length;j++){
                        var tempText=comboList[i][j].split("|");
                        if(i == 0) {
                            comboObjects[0].InsertItem(j, tempText[0] ,tempText[0]);
                        } else if(i == 1) {
                            comboObjects[2].InsertItem(j, tempText[1] ,tempText[0]);
                        }
                    }
                }
            }
            comboObjects[0].InsertItem(0 , 'ALL','');
            comboObjects[0].SetSelectIndex(0);
            comboObjects[2].InsertItem(0 , 'ALL','');
            comboObjects[2].SetSelectIndex(0);
            break;
        case IBSEARCH:          //retrieving
            if(validateForm(sheetObj, formObj, sAction)) {
                if(sheetObj.id == "sheet1") {
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSearchData("EES_MNR_0246GS.do", FormQueryString(formObj));
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    ComOpenWait(false);
                    sheetObj.SetWaitImageVisible(1);
                }
            }
            break;
        case IBSEARCH_ASYNC01:  // retrieving Buyer Code
            if(validateForm(sheetObj,formObj,sAction)) {
                if ( sheetObj.id == "sheet1") {
                    var vCustCntCd=formObj.p_cust_cd.value;
                    var param="f_cmd="+SEARCH+"&cust_cd="+ vCustCntCd.substr(0,2) +"&cust="+ vCustCntCd.substr(2);
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData("COM_ENS_041GS.do", param);
                    sheetObj.SetWaitImageVisible(1);
                    if ( ComGetTotalRows(sXml) != 1 ) {
                        ComShowCodeMessage("MNR00025", "Buyer");
                        clearForm("p_cust_cd");
                        ComSetFocus(formObj.p_cust_cd);
                    } else {
                        var aryData=MnrXmlToArray(sXml);
                        ComSetObjValue(formObj.p_vndr_nm, aryData[0][1]);
                        formObj.p_vndr_nm.focus();
                    }
                }
            }
            break;
    }
}

/**
 * sheet1_OnMouseMove :: handling event on Mouse Move
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    with(sheetObj) {
        if(/pfmc_tpsz_dp*/.test(ColSaveName(MouseCol())) == true) {
            if(MouseRow()> HeaderRows()) {
                SetDataLinkMouse(MouseCol(),1);
                if(MouseRow()> LastRow()-3) {
                    SetMousePointer("Hand");
                }
            }
        }
    }
}
/**
 * sheet1_OnDblClick
 */
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    var formObj=document.form;
    var sName=sheetObj.ColSaveName(Col);
var vVndrNm=sheetObj.GetCellValue(Row,"cust_nm");
    var params=ComGetObjValue(formObj.h_etc_params);
    switch (sName) {
        case "pfmc_tpsz_dp01": case "pfmc_tpsz_dp02": case "pfmc_tpsz_dp03":
        case "pfmc_tpsz_dp04": case "pfmc_tpsz_dp05": case "pfmc_tpsz_dp06":
        case "pfmc_tpsz_dp07": case "pfmc_tpsz_dp08": case "pfmc_tpsz_dp09":
        case "pfmc_tpsz_dp10": case "pfmc_tpsz_dp11": case "pfmc_tpsz_dp12":
        case "pfmc_tpsz_dp13": case "pfmc_tpsz_dp14": case "pfmc_tpsz_dp15":
        case "pfmc_tpsz_dp16": case "pfmc_tpsz_dp17": case "pfmc_tpsz_dp18":
        case "pfmc_tpsz_dp19": case "pfmc_tpsz_dp20": case "pfmc_tpsz_dp21":
        case "pfmc_tpsz_dp22": case "pfmc_tpsz_dp23": case "pfmc_tpsz_dp24":
        case "pfmc_tpsz_dp25": case "pfmc_tpsz_dp26": case "pfmc_tpsz_dp27":
        case "pfmc_tpsz_dp28": case "pfmc_tpsz_dp29": case "pfmc_tpsz_dp30":
            params += "&h_eq_tpsz_cd="+ sheetObj.GetCellText(0, Col);
            params += "&h_cust_cd="+ sheetObj.GetCellValue(Row,"cust_cd");
            if(vVndrNm == "S.TTL") {
                params += "&h_vndr_nm="+ sheetObj.GetCellValue(Row -3,"cust_nm");
                params += "&h_curr_cd=";
            } else {
                params += "&h_vndr_nm="+ sheetObj.GetCellValue(Row,"cust_nm");
                params += "&h_curr_cd="+ sheetObj.GetCellValue(Row,"curr_cd");
            }
            break;
        case "pfmc_tpsz_dp00":
            params += "&h_eq_tpsz_cd=";
            params += "&h_cust_cd="+ sheetObj.GetCellValue(Row,"cust_cd");
            if(vVndrNm == "S.TTL") {
                params += "&h_vndr_nm="+ sheetObj.GetCellValue(Row -3,"cust_nm");
                params += "&h_curr_cd=";
            } else {
                params += "&h_vndr_nm="+ sheetObj.GetCellValue(Row,"cust_nm");
                params += "&h_curr_cd="+ sheetObj.GetCellValue(Row,"curr_cd");
            }
            break;
    }
}
/**
 * sheet1_OnMouseDown
 * handling event on Mouse Down
 * retrieving DETAIL of SUMMARY
 */
function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {
    var formObj=document.form;
    var sRow=sheetObj.MouseRow();
    var sCol=sheetObj.MouseCol();
    var sName=sheetObj.ColSaveName(sCol);
    var params="";
    if(sheetObj.MouseRow()> sheetObj.LastRow()-3) {
        switch (sName) {
            case "pfmc_tpsz_dp01": case "pfmc_tpsz_dp02": case "pfmc_tpsz_dp03":
            case "pfmc_tpsz_dp04": case "pfmc_tpsz_dp05": case "pfmc_tpsz_dp06":
            case "pfmc_tpsz_dp07": case "pfmc_tpsz_dp08": case "pfmc_tpsz_dp09":
            case "pfmc_tpsz_dp10": case "pfmc_tpsz_dp11": case "pfmc_tpsz_dp12":
            case "pfmc_tpsz_dp13": case "pfmc_tpsz_dp14": case "pfmc_tpsz_dp15":
            case "pfmc_tpsz_dp16": case "pfmc_tpsz_dp17": case "pfmc_tpsz_dp18":
            case "pfmc_tpsz_dp19": case "pfmc_tpsz_dp20": case "pfmc_tpsz_dp21":
            case "pfmc_tpsz_dp22": case "pfmc_tpsz_dp23": case "pfmc_tpsz_dp24":
            case "pfmc_tpsz_dp25": case "pfmc_tpsz_dp26": case "pfmc_tpsz_dp27":
            case "pfmc_tpsz_dp28": case "pfmc_tpsz_dp29": case "pfmc_tpsz_dp30":
                params += "&h_eq_tpsz_cd="+ sheetObj.GetCellText(0, sCol);
                params += "&h_cust_cd="+ ComGetObjValue(formObj.h_cust_cd);
                params += "&h_vndr_nm="+ ComGetObjValue(formObj.p_vndr_nm);
                params += "&h_curr_cd=";
                break;
            case "pfmc_tpsz_dp00":
                params += "&h_eq_tpsz_cd=";
                params += "&h_cust_cd="+ ComGetObjValue(formObj.h_cust_cd);
                params += "&h_vndr_nm="+ ComGetObjValue(formObj.p_vndr_nm);
                params += "&h_curr_cd=";
                break;
        }
    }
}
/**
 * event after retrieving
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);


        var formObj=document.form;
        var viewCnt=0;
        if(sheetObj.LastRow()> 2) {
            for(var i=0; i <= sheetObj.LastRow()-3; i++) {
                if(sheetObj.GetCellValue(i, "cust_nm") == "S.TTL" ) {
                	sheetObj.SetRowBackColor(i,MNR_TOTCOL_BACK_COLOR);
                	sheetObj.SetCellAlign(i, "cust_nm","Center");
                }
            }

            for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
                var pfmcData=sheetObj.GetCellValue(sheetObj.LastRow()-2, "pfmc_tpsz_dp"+ ComLpad(i, 2, "0"));
                if(pfmcData <= 0) {
                	sheetObj.SetColHidden("pfmc_tpsz_dp"+ ComLpad(i, 2, "0") ,1);
                } else {
                	sheetObj.SetColHidden("pfmc_tpsz_dp"+ ComLpad(i, 2, "0"),0);
                    viewCnt++;
                }
            }
            if(550 + (viewCnt * 80) > 984) {
            	sheetObj.SetSheetWidth(984);
            } else {
            	sheetObj.SetSheetWidth(560 + (viewCnt * 80));
            }
            
            sheetObj.SetRangeBackColor(sheetObj.LastRow()-2, 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FFA7A7");
 			sheetObj.SetRangeFontBold(sheetObj.LastRow()-2, 0, sheetObj.LastRow(), sheetObj.LastCol(), 1);

            //sheetObj.RowDelete(sheetObj.LastRow()-5, false);
            /*sheetObj.RowDelete(LastRow()-4, false);
            sheetObj.RowDelete(LastRow()-3, false);*/
            
//            var mergeValue  ="" ;
//            var mergeIndex  = 6 ;
//            for(var idx=1; idx < sheetObj.LastRow() ; idx=idx+3){
//            	if (idx == 1) mergeValue = sheetObj.GetCellValue( idx , "cust_cd") ;
//            	if(  mergeValue == sheetObj.GetCellValue( idx+3 , "cust_cd") ){
//            		 sheetObj.SetMergeCell(idx , 0, mergeIndex, 1);
//            		 mergeIndex = mergeIndex+3;
//            	}else{
//            		mergeValue = sheetObj.GetCellValue( idx+3 , "cust_cd") ;
//            		mergeIndex =6;
//            	}
//            }
            
//            sheetObj.SetMergeCell(sheetObj.LastRow()-2 , 0, 3, 2);
//            sheetObj.SetMergeCell(sheetObj.LastRow()-2 , 2, 3, 1);
//            sheetObj.SetCellValue(sheetObj.LastRow()-2, "cust_cd","G.TTL",0);
//            sheetObj.SetCellValue(sheetObj.LastRow()-1, "cust_cd","G.TTL",0);
//            sheetObj.SetCellValue(sheetObj.LastRow(), "cust_cd","G.TTL",0);
            var formObj=document.form;
            formObj.h_cust_cd.value=ComGetObjValue(formObj.p_cust_cd);
            formObj.h_vndr_nm.value=ComGetObjValue(formObj.p_vndr_nm);    
            formObj.h_etc_params.value="&h_str_evnt_dt="+ ComGetObjValue(formObj.p_str_evnt_dt)
                                       + "&h_end_evnt_dt="+ ComGetObjValue(formObj.p_end_evnt_dt)
                                       + "&h_eq_knd_cd="+ ComGetObjValue(formObj.p_eq_knd_cd)
                                       + "&h_eq_knd_nm="+ ComGetObjText(formObj.p_eq_knd_cd)
                                       + "&h_disp_rsn_cd="+ ComGetObjValue(formObj.p_disp_rsn_cd)
                                       + "&h_disp_rsn_nm="+ ComGetObjText(combo3)
                                       + "&h_rhq_cd="+ ComGetObjValue(formObj.p_rhq_cd)
                                       + "&h_ofc_cd="+ ComGetObjValue(formObj.p_ofc_cd);
        }

}
/**
 * combo1_OnBlur
 */
function combo1_OnBlur(comboObj, Index_Code, Text) {
    var formObj=document.form;
    formObj.p_rhq_cd.value=ComGetObjValue(comboObj);
    if(ComGetObjValue(formObj.p_rhq_cd) == "ALL") {
        ComSetObjValue(formObj.p_rhq_cd, "");
    }
}
/**
 * combo1_OnChange
 */
function combo1_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, Text, Index_Code){
    var formObj=document.form;
    ComSetObjValue(formObj.p_ofc_cd, "");
    comboObjects[1].RemoveAll();
    if(Index_Code != "") {
        comboObjects[1].SetEnable(1);
        var sCondition=new Array (
            new Array("MdmOrganization","SEARCH",Index_Code)
        )
        var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
        if(comboList[0] != null){
            for(var j=0; j < comboList[0].length;j++){
                var tempText=comboList[0][j].split("|");
                comboObjects[1].InsertItem(j,comboList[0][j] ,tempText[0]);
            }
            comboObjects[1].InsertItem(0 , 'ALL','');
            comboObjects[1].SetSelectIndex(0);
        }
        ComSetFocus(combo2);
    } else {
        comboObjects[1].SetEnable(0);
    }
}
/**
 * cobo1_OnKeyDown
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    with(comboObj) {
        if(KeyCode == 13) {
            formObj.p_rhq_cd.value=ComGetObjValue(comboObj);
            if(ComGetObjValue(formObj.p_rhq_cd) == "ALL") {
                ComSetObjValue(formObj.p_rhq_cd, "");
            }
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    }
}
/**
 * combo2_OnBlur
 */
function combo2_OnBlur(comboObj, Index_Code, Text) {
    var formObj=document.form;
    var combTxt=ComGetObjValue(comboObj);
    if(combTxt == "" || combTxt == "ALL") {
        ComSetObjValue(formObj.p_ofc_cd, "");
        comboObj.SetSelectIndex(0);
    } else {
        formObj.p_ofc_cd.value=combTxt;
    }
}
/**
 * cobo2_OnKeyDown
 */
function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    with(comboObj) {
        if(KeyCode == 13) {
            formObj.p_ofc_cd.value=ComGetObjValue(comboObj);
            if(ComGetObjValue(formObj.p_ofc_cd) == "ALL") {
                ComSetObjValue(formObj.p_ofc_cd, "");
            }
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    }
}
/**
 * combo3_OnBlur
 */
function combo3_OnBlur(comboObj, Index_Code, Text) {
    var formObj=document.form;
    formObj.p_disp_rsn_cd.value=ComGetObjValue(comboObj);
    if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
        ComSetObjValue(formObj.p_disp_rsn_cd, "");
    }
}
/**
 * cobo3_OnKeyDown
 */
function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    with(comboObj) {
        if(KeyCode == 13) {
            formObj.p_disp_rsn_cd.value=ComGetObjValue(comboObj);
            if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
                ComSetObjValue(formObj.p_disp_rsn_cd, "");
            }
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    }
}
/**
 * Pop-up Open<br>
 * @param type 1:Location Code, 2:Currency Code
 * @param Row IBSheet Row index
 * @param Col IBSheet Col index
 */
function openPopup(type, Row, Col) {
    var formObj=document.form;
    if(type == "1") {
        ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 520, 'setPopData_BuyerCd', '1,0,1,1,1,1,1,1', true);
    }
    return;
}
/**
 * (Service Provider) handling Pop-up Return Value<br>
 * @param {arry} Return value array of returnedValues Pop-up
 * @param Row IBSheet Row index
 * @param Col IBSheet Col index
 * @param Sheet Array index
 */
function setPopData_BuyerCd(aryPopupData, Row, Col, SheetIdx) {
    var formObj=document.form;
    if ( aryPopupData.length > 0 ) {
        formObj.p_cust_cd.value=aryPopupData[0][3];
        formObj.p_vndr_nm.value=aryPopupData[0][4];
    }
}
/**
 * setting type size per EQ TYPE as list.
 */
function initDynamicEqTpszCd(sheetObj) {
    var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind","");
    if(arrXml != null) {
        for(var i=0; i < arrXml.length; i++) {
            if(i == 0){//U
                cntrTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
            } else if(i == 1){//Z
                chssTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
            } else if(i == 2){//G
                gsetTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
            }
        }
    }
}
/**
 * Equipment Type/Size Grid Header Setting
 */
function setDynamicEqTpszHeader(sheetObj, eqKndCd) {
    var eqTpSzAry=new Array();
    if(eqKndCd == "U") {
        eqTpSzAry=cntrTpSz;
    } else if(eqKndCd == "Z") {
        eqTpSzAry=chssTpSz;
    } else {//eqKndCd is 'G'
        eqTpSzAry=gsetTpSz;
    }
    if(eqTpSzAry.length > 0) {
        var eqTpSzStr="|"+ eqTpSzAry.toString().replace(/,/g, "|");
        vCntrTpszHdr=eqTpSzStr;
        vArrCntrTpsz=eqTpSzStr.split("|");
        vCntrTpszCnt=vArrCntrTpsz.length;
        for(i=0; i < sheetObjects.length; i++) {
            /* resetting IBSheet */
            //
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //
            ComEndConfigSheet(sheetObjects[i]);
        }
    }
}
/**
 * handling Validation Duration Date<br>
 */
function checkDurationDate(eventObj) {
    var formObj=document.form;
    var vEffDt=ComReplaceStr(ComGetObjValue(formObj.p_str_evnt_dt),"-","");
    var vExpDt=ComReplaceStr(ComGetObjValue(formObj.p_end_evnt_dt),"-","");
    /* Duration Date Validation(p_str_evnt_dt) */
    if(vEffDt == "" && eventObj == null) {
        ComShowCodeMessage("MNR00172", "Start Date");
        ComSetFocus(formObj.p_str_evnt_dt);
        return false;
    } else if(vEffDt == "" && eventObj.name == "p_str_evnt_dt") {
        ComShowCodeMessage("MNR00172", "Start Date");
        ComSetFocus(formObj.p_str_evnt_dt);
        return false;
    } else if (vEffDt != "" && !ComIsDate(formObj.p_str_evnt_dt) ) {
        ComShowCodeMessage("MNR00346");
        ComSetObjValue(formObj.p_str_evnt_dt,"");
        ComSetFocus(formObj.p_str_evnt_dt);
        return false;
    }
    /* Duration Date Validation(end_evnt_dt) */
    if(vExpDt == "" && eventObj == null) {
        ComShowCodeMessage("MNR00172", "End Date");
        ComSetFocus(formObj.p_end_evnt_dt);
        return false;
    } else if(vExpDt == "" && eventObj.name == "p_end_evnt_dt") {
        ComShowCodeMessage("MNR00172", "End Date");
        ComSetFocus(formObj.p_end_evnt_dt);
        return false;
    } else if (vExpDt != "" && !ComIsDate(formObj.p_end_evnt_dt) ) {
        ComShowCodeMessage("MNR00347");
        ComSetObjValue(formObj.p_end_evnt_dt,"");
        ComSetFocus(formObj.p_end_evnt_dt);
        return false;
    }
    /* Duration Date Validation(str_evnt_dt < end_evnt_dt) */
    if(vEffDt != "" && vExpDt != "") {
        if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
            ComShowCodeMessage("MNR00346");
            if(eventObj == null) {
                ComSetObjValue(formObj.p_end_evnt_dt,"");
                ComSetFocus(formObj.p_end_evnt_dt);
            } else {
                ComSetObjValue(eventObj,"");
                ComSetFocus(eventObj);
            }
            return false;
        }
    }
    return true;
}
/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        switch(sAction) {
            case IBSEARCH:      //retrieving
                if (!checkDurationDate()) {
                    return false;
                }
                return ComChkValid(formObj, true);
                break;
            default :   //do nothing
        }
    }
    return true;
}
/**
 * handling Form Element Clear.<br>
 * @param fieldName
 */
function clearForm(fieldName) {
    var formObj=document.form;
    switch(fieldName) {
        case "p_cust_cd":
            ComSetObjValue(formObj.p_cust_cd,   "");
            ComSetObjValue(formObj.p_vndr_nm,   "");
            ComSetFocus(formObj.p_cust_cd);
            break;
        default :   //do nothing
    }
}
/* developer job */
