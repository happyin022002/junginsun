/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2049.js
*@FileTitle  : RFA Proposal & Amendment Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;

// Event handler processing by button click event
document.onclick=processButtonClick;

/** 
 * Event handler processing by button name  <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return void
 * @author 
 * @version 2009.10.05
 */
function processButtonClick () {
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        
        switch (srcName) {
            case "btn_Retrieve":
                if (formObj.trans_tp_cd[1].checked) {
                    doActionIBSheet(sheetObject2, formObj, IBSEARCH);
                } else {
                    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                }
                break;
            case "btn_Open":
                var propNo="";
                var curSheetCnt=0;
                if (formObj.trans_tp_cd[0].checked) {
                    propNo=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "prop_no");
                    curSheetCnt=sheetObject1.RowCount();
                } else if (formObj.trans_tp_cd[1].checked) {
                    propNo=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "prop_no");
                    curSheetCnt=sheetObject2.RowCount();
                }
                if (curSheetCnt == 0 || propNo ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }

                var pgmNo="ESM_PRI_2003";
                var pgmUrl="/opuscntr/ESM_PRI_2003.do"
                var params="&cond_prop_no=" + propNo;
                var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
                var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
                var sUrl="ESM_PRI_2003.do?parentPgmNo=" + parentPgmNo + src;
                var iWidth=1024;
                var iHeight=700;
                var leftpos=(screen.width - iWidth) / 2;
                if (leftpos < 0)
                    leftpos=0;
                var toppos=(screen.height - iHeight) / 2;
                if (toppos < 0)
                    toppos=0;
                var sFeatures="status=no, resizable=yes, scrollbars=yes, width="+iWidth+", left="+leftpos+", top="+toppos;
                window.open(sUrl, "");
                break;
            case "btn_calendar1": //Calendar Button1
            case "btn_calendar2": //Calendar Button2
                var cal=new ComCalendarFromTo();
                cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
                break;
            case "trans_tp_cd":
                if (formObj.trans_tp_cd[0].checked) {
                    sheetObject1.SetVisible(1);
                    sheetObject1.SetSheetHeight(500);
                    sheetObject2.SetVisible(0);
                    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                } else if (formObj.trans_tp_cd[1].checked) {
                    sheetObject2.SetVisible(1);
                    sheetObject2.SetSheetHeight(500);
                    sheetObject1.SetVisible(0);
                    doActionIBSheet(sheetObject2, formObj, IBSEARCH);
                }
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj mandatory IBSheet Object
 * @return void
 * @author 
 * @version 2009.10.05
 */
function setSheetObject (sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return void
 * @author 
 * @version 2009.10.05
 */
function loadPage () {
    try {
        for (i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var formObj=document.form;
        initCondition();
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Setting default value of condition.<br>
 * <br><b>Example :</b>
 * <pre>
 *     initCondition ();
 * </pre>
 * @return void
 * @author 
 * @version 2009.10.05
 */
function initCondition () {
    var formObj=document.form;
    // Default Date : from - a weeks ago, to - now
    formObj.eff_dt.value=ComGetDateAdd(null, "D", -7);
    formObj.exp_dt.value=ComGetNowInfo();
}

/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets  <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} sheetNo mandatory IBSheet Object Serial No
 * @return void
 * @author 
 * @version 2009.10.05
 */
function initSheet (sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
        case 1: // Received sheet1 init
            with(sheetObj){
                var HeadTitle1="|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|From|From|From|From|Date";
                var HeadTitle2="|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|Office|User ID|Code|Name|Date";
                var headCount=ComCountHeadTitle(HeadTitle2);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rqst_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prop_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"prop_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rfa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prog_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                       
                InitColumns(cols);
                
                SetEditable(0);
                SetWaitImageVisible(0);
                resizeSheet(); //SetSheetHeight(500);
            }

            break;
        case 2: // Sent sheet2 init
            with(sheetObj){
                var HeadTitle1="|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|To|To|To|To|Date";
                var HeadTitle2="|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|Office|User ID|Code|Name|Date";
                var headCount=ComCountHeadTitle(HeadTitle2);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rqst_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prop_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"prop_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rfa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prog_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
 
                InitColumns(cols);
                
                SetEditable(0);
                SetWaitImageVisible(0);
                SetVisible(0);
                resizeSheet();
            }

            break;
    }
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
	ComResizeSheet(sheetObjects[1]);
}

/**
 * Handling sheet's processes <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {form} formObj mandatory html form object
 * @param {int} sAction mandatory,Constant Variable
 * @return void
 * @author 
 * @version 2009.10.05
 */
function doActionIBSheet (sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: 
            ComOpenWait(true);
            if (validateForm(sheetObj, formObj, sAction)) {
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_PRI_2049GS.do", FormQueryString(formObj) );
            }
            break;
    }
}

/**
 * Calling Function in case of OnSearchEnd event <br>
 * Change the font & color after Sheet retrieve completely <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj Mandatory, IBSheet Object
 * @param {string} ErrMsg selection
 * @returns void
 * @author 
 * @version 2010.05.12
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        //changeGetRowFontColor(sheetObj);
        //changeSelectBackColor4Rate(sheetObj);
    }
}
/**
 * Calling Function in case of OnSearchEnd event <br>
 * Change the font & color after Sheet retrieve completely <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj Mandatory, IBSheet Object
 * @param {string} ErrMsg selection
 * @returns void
 * @author 
 * @version 2010.05.12
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        //changeGetRowFontColor(sheetObj);
        //changeSelectBackColor4Rate(sheetObj);
    }
}

/**
 * calling function in case of OnSelectCell event <br>
 * Display different Highlight color within Initial/Returned Row. <br>
 * <br>
 * <b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj Mandatory, IBSheet Object
 * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
 * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
 * @param {int} NewRow Mandatory, ,current selected cell's Row Index
 * @param {int} NewCol Mandatory, ,current selected cell's Column Index
 * @return void
 * @author 
 * @version 2009.05.17
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    if (OldRow != NewRow) {
        //changeSelectBackColor4Rate(sheetObj);
    }
}

/**
 * calling function in case of OnSelectCell event <br>
 * Display different Highlight color within Initial/Returned Row. <br>
 * <br>
 * <b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj Mandatory, IBSheet Object
 * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
 * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
 * @param {int} NewRow Mandatory, ,current selected cell's Row Index
 * @param {int} NewCol Mandatory, ,current selected cell's Column Index
 * @return void
 * @author 
 * @version 2009.05.17
 */
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    if (OldRow != NewRow) {
        //changeSelectBackColor4Rate(sheetObj);
    }
}

/**
 * Change the font & color of data that Status is Initial or Returned <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * changeRowFontColor(sheetObj);
 * </pre>
 * 
 * @param {ibsheet} sheetObj Mandatory, IBSheet Object
 * @returns void
 * @author 
 * @version 2010.05.12
 */
function changeGetRowFontColor(sheetObj) {
    for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+ sheetObj.RowCount(); i < n ; i++) {
        if (sheetObj.GetCellValue(i, "prop_sts_cd") == "I" || sheetObj.GetCellValue(i, "prop_sts_cd") == "R") {
            sheetObj.SetRowFontColor(i,"#FF0000");
        }
    }
}

/**
 * handling process for input validation <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *        handling logic
 *     }
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {form} formObj mandatory html form object
 * @param {int} sAction mandatory,Constant Variable
 * @returns bool <br>
 *          true  : valid<br>
 *          false : inValid
 * @author 
 * @version 2009.10.05
 */
function validateForm (sheetObj, formObj, sAction) {
    // Form base check - whole field of form validation Check ( maxlength, mandatory item, Etc.. )
    if (!ComChkValid(formObj)) {
        return false;
    }
    return true;
}

