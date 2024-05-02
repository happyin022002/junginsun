/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4019.js
*@FileTitle  : Surcharge Commodity Group Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/6/24
*
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
    var comboObjects=new Array();
    var comboCnt=0;
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
     * @version 2009.06.05
     */
    function processButtonClick () {
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch (srcName) {
                case "btn_retrieve":
                	ComOpenWait(true);
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                    ComOpenWait(false);
                    break;
                case "btn_new":
                    searchConditionReset(document.form);
                    break;
                case "btn_downexcel":
                    if(sheetObject3.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
                        }
                    break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
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
     * @version 2009.06.05
     */
    function setSheetObject (sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.06.05
     */
    function setComboObject (combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
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
     * @version 2009.06.05
     */
    function loadPage () {
        try {
            for (i=0; i < sheetObjects.length; i++) {
                //Modify Environment Setting Function's name
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                //Add Environment Setting Function
                ComEndConfigSheet(sheetObjects[i]);
            }
            //Initializing IBMultiCombo
            for ( var k=0; k < comboObjects.length; k++) {
                initCombo(comboObjects[k], k + 1);
            }
            doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
            
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.06.05
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    ValidChar(2);
                    SetMaxLength(3);

                }
                break;
        }
    }
    /**
     * Calling Function in case of OnChange event <br>
     * Showing description by svc_scp_cd value <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns void
     * @author 
     * @version 2009.06.05
     */
    //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

    function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        if(comboObjects[0].GetItemCount() > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
        	ComOpenWait(true);
            var formObj=document.form;
            var desc=null;
            if (isNaN(parseInt(newCode, 10))) {
                desc=svc_scp_cd.GetText(newCode,1);
            } else {
                desc=svc_scp_cd.GetText(newCode,1);
            }
            formObj.svc_scp_nm.value=desc;
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
            ComOpenWait(false);
        }
    }
    /**
     * calling function in case of OnBlur event of IBMultiCombo <br>
     * Showing description of selected code when focus move out from svc_scp_cd <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @returns void
     * @author 
     * @version 2009.06.02
     */
    //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

    function svc_scp_cd_OnBlur (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != "-1") {
            var text=comboObj.GetText(comboObj.GetSelectText(), 1);
            if (text == "" && !ComIsEmpty(comboObj.GetSelectText())) {
                formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
                searchConditionReset(formObj,"1");
                doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
//                formObj.svc_scp_nm.focus();
            }
        } else {
//            ComShowCodeMessage("PRI00315");
            comboObj.SetSelectText("");
            comboObj.SetSelectIndex("-1");
            formObj.svc_scp_nm.value="";
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
    }
    /**
     * calling function in case of OnClear event of IBMultiCombo<br>
     * Showing description of selected code when focus move out from svc_scp_cd <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @returns void
     * @author 
     * @version 2009.06.02
     */
//    function svc_scp_cd_OnClear (comboObj) {
//        var formObject = document.form;
//        formObject.svc_scp_nm.value = "";
//        comboObj.Index2 = -1;
//    }
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
     * @version 2009.06.05
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
            case "sheet0": //hidden 
                with (sheetObj) {
                    SetVisible(false);
                }
                break;
            case "sheet1": // 
                with (sheetObj) {
                    if (location.hostname != "")
                    var HeadTitle="|Group\nCode|Group Name|Delete\nMark|Creation\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq";
                    var headCount=ComCountHeadTitle(HeadTitle);
    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scg_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                     {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
                     {Type:"Date",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
    
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    resizeSheet();//SetSheetHeight(480);
                }
                break;
            case "sheet2": // 
                with (sheetObj) {
                    var HeadTitle="|Seq.|Commodity\nCode|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq|scg_grp_cmdt_dtl_seq";
                    var headCount=ComCountHeadTitle(HeadTitle);
    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                     {Type:"Text",      Hidden:0,  Width:410,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
    
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    SetShowButtonImage(2);
                    resizeSheet();//SetSheetHeight(480);
                }
                break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0]); ComResizeSheet(sheetObjects[1]); }
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
     * @version 2009.06.05
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBCLEAR:
                // Retrieve Service Scope when screen is loading
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
//                comboObjects[0].Index = "-1";
//                comboObjects[0].Code = "TPW";
                break;
            case IBSEARCH: 
                if (validateForm(sheetObj, document.form, sAction)) {
                    try {
//                        ComOpenWait(true);
                        if (sheetObj.id == "sheet1") {
                            for ( var i=0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }
                            formObj.f_cmd.value=SEARCH01;
                            sheetObj.DoSearch("ESM_PRI_4019GS.do", FormQueryString(formObj) );
                        } else if (sheetObj.id == "sheet2") {
                            formObj.f_cmd.value=SEARCH02;
                            sheetObj.DoSearch("ESM_PRI_4019GS.do", FormQueryString(formObj) );
                        }
//                        ComOpenWait(false);
                    } catch (e) {
                        if (e == "[object Error]") {
                            ComShowMessage(OBJECT_ERROR);
                        } else {
                            ComShowMessage(e.message);
                        }
                    } finally {
//                        ComOpenWait(false);
                    }
                }
                break;
            case IBDOWNEXCEL:
                ComOpenWait(true);
                sheetObj.Down2Excel({ HiddenColumn:-1});
                ComOpenWait(false);
                break;
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
     * @version 2009.06.05
     */
    function validateForm (sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSEARCH: // retrieving
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                break;
            case IBDOWNEXCEL: // excel down
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                break;
        }
        return true;
    }
    /**
     * Calling function in case of Onclick event <br>
     * Highlighting selected row<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.19
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, false);
    }
    var isFiredNested=false;
    var supressConfirm=false;
    /**
     * in case of modifying row on Sheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.05.19
     */ 
    function doRowChange (sheetM, sheetD, OldRow, NewRow, OldCol, appendRow) {
        try {
            var formObj=document.form;
            if (!isFiredNested && (OldRow != NewRow)) {
                if (sheetM.IsDataModified()) {
                    isFiredNested=true;
                    if (!validateForm(sheetM, document.form, IBSAVE)) {
                        sheetM.SelectCell(OldRow, OldCol, false);
                        isFiredNested=false;
                        return -1;
                    }
                    isFiredNested=false;
                }
                if (sheetD.IsDataModified()) {
                    if (ComShowCodeConfirm("PRI00006")) {
                        supressConfirm=true;
                        var rslt=doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                        supressConfirm=false;
                        if (!rslt) {
                            isFiredNested=true;
                            sheetM.SelectCell(OldRow, OldCol, false);
                            isFiredNested=false;
                            return -1;
                        }
                    }
                }
                if (appendRow) {
                    isFiredNested=true;
                    var idx=sheetM.DataInsert();
                    isFiredNested=false;
                    return idx;
                } else {
                    formObj.f_cmd.value=SEARCH02;
                    formObj.scg_grp_cmdt_seq.value=sheetM.GetCellValue(NewRow, "scg_grp_cmdt_seq");
                    doActionIBSheet(sheetD, document.form, IBSEARCH);
                }
            }
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            //ComOpenWait(false);
        }
    }
