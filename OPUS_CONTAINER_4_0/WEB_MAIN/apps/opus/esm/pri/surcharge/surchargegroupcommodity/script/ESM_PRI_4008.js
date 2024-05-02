/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4008.js
*@FileTitle  : Surcharge Commodity Group Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
    
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    var eventStatus="";
    
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_add":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;
                case "btn_del":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;
                case "btn_add2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;
                case "btn_del2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;      
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;
                case "btn_new":
                    searchConditionReset(document.form);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[3],document.form,IBDOWNEXCEL);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     * setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj Mandatory IBMulti Combo Object
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function setComboObject(combo_obj){
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
     * @version 2009.04.17
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        
        doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
    }
    
    /**
     * IBSHEET COMBO Loading Function.<br>
     * <br><b>Example :</b>
     * <pre>
     *      initCombo(comboObj, comboNo)
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "svc_scp_cd":
                var i=0;
                with(comboObj) {
                    Style=0;
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                    ValidChar(2);
                }
                break;
        }
    }
    
    /**
     * Return Code value of comboObjects[0]<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 
     * @version 2009.06.10
     */
    function getSvcScpCd() {
        return comboObjects[0].GetSelectCode();
    }
    
    /**
     * Return Text value of comboObjects[0]<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getSvcScpTxt(code);
     * </pre>
     * @param {String} code
     * @return String <br>
     * @author 
     * @version 2009.06.10
     */
    function getSvcScpTxt(code) {
        return comboObjects[0].GetText(code,1);
    }
    
    /**
     * Execute when the focus move out from service scope combo <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {comboObj} comboObj
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj=document.form;
//parameter changed[check again]CLT
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != "-1") {
            var text=comboObj.GetText(comboObj.GetSelectText(), 1);
            if (text == "" && !ComIsEmpty(comboObj.GetSelectText())) {
                formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
                searchConditionReset(formObj,"1");
                doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
                formObj.svc_scp_nm.focus();
            } else if (text != "") {
            	formObj.svc_scp_nm.value=text;
            }
        } else {
            comboObj.SetSelectText("");
            comboObj.SetSelectIndex("-1");
            formObj.svc_scp_nm.value="";
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();           
        }
    }
    
    /**
     * Activate when service scope combo changed <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {comboObj} comboObj    Mandatory,comboObj Object
     * @param {String} code
     * @param {String} text
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
        if(comboObjects[0].GetItemCount () > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
            var formObj=document.form;
            var desc=null;
            if (isNaN(parseInt(code, 10))) {
                desc=svc_scp_cd.GetText(code,1);
            } else {
                desc=svc_scp_cd.GetText(code,1);
            }
            formObj.svc_scp_nm.value=desc;
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
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
     * @version 2009.04.17
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet0":      //hidden
                with (sheetObj) {
                }
                break;
            case "sheet1":  
                with(sheetObj){
                    var HeadTitle="|Sel.|Group\nCode|Group Name|Delete\nMark|Creation\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scg_grp_cmdt_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0,TrueValue:"Y", FalseValue:"N"},
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    resizeSheet(); //SetSheetHeight(458);
                    SetColProperty(0 ,"scg_grp_cmdt_cd" , {AcceptKeys:"N"});
                }
                break;
            case "sheet2": 
                with(sheetObj){
                    var HeadTitle="|Sel.|Seq.|Commodity\nCode|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq|scg_grp_cmdt_dtl_seq";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",   Sort:0 },
                                 {Type:"PopupEdit", Hidden:0, Width:110,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                                 {Type:"Text",      Hidden:0,  Width:330,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                                 {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty(0 ,"cmdt_cd" , {AcceptKeys:"N"});
                    resizeSheet(); //SetSheetHeight(458);
                }
                break;
            case "sheet3":
                with(sheetObj){
                    var HeadTitle="Seq.|Service Scope|Charge|Group\nCode|Group Name|Delete\nMark|Creation\nDate|Commodity\nCode|Description|Effective\nDate|Update\nDate";

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"delt_flg",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cre_dt",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_des",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetVisible(0);
                    SetWaitImageVisible(0);
                    SetSheetHeight(270);
                }
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
        ComResizeSheet(sheetObjects[2]);
    }

    function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
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
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBCLEAR:
                // Retrieve Service Scope when screen is loading
                formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
                break;
            case IBSEARCH:      //Retrieving
                if (validateForm(sheetObj,document.form,sAction)) {
                    try {
                        ComOpenWait(true);
                        if ( sheetObj.id == "sheet1") {
                            for (var i=0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }
                            formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
                            sheetObj.DoSearch("ESM_PRI_4008GS.do", FormQueryString(formObj) );
                        }
                        else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT
                            sheetObj.DoSearch("ESM_PRI_4008GS.do", FormQueryString(formObj) );
                        }
                        ComOpenWait(false);
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
                break;
            case IBSAVE:        
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }
                eventStatus="IBSAVE";
                formObj.f_cmd.value=MULTI01;
                var sParam=FormQueryString(formObj);
                sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                
                var saveMode = 1;
                var groupKey = "";
                if(!sheetObjects[1].IsDataModified() && sheetObjects[2].IsDataModified()) {
                	saveMode = 2;
                	groupKey = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"scg_grp_cmdt_seq");
                }
                
                
                try {
                    ComOpenWait(true);

                    var sXml=sheetObj.GetSaveData("ESM_PRI_4008GS.do", sParam);

                    sheetObjects[2].LoadSaveData(sXml);
                    sXml=ComDeleteMsg(sXml);

                    sheetObjects[1].LoadSaveData(sXml);
                    
                    retrieveSheet(saveMode,groupKey);

                    ComOpenWait(false);
                } catch (e) {
                    if (e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e.message);
                    }
                } finally {
                    ComOpenWait(false);
                }
                eventStatus="";
                break;
            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        var idx=doRowChange(sheetObj, sheetObjects[2], sheetObj.GetSelectRow(), sheetObj.GetSelectRow() + 1, sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
                        if (idx < 0) {
                            return false;
                        }
                        //service scoup
                        sheetObj.SetCellValue(idx, "svc_scp_cd",getSvcScpCd());
                        sheetObj.SetCellValue(idx, "chg_cd",formObj.chg_cd.value);
                        // Setting Max Sequence
                        sheetObj.SetCellValue(idx, "scg_grp_cmdt_seq",parseInt(formObj.max_seq.value, 10) + 1);
                        // GROUP CODE Sequence Auto creation.
                        var scg_grp_cmdt_cd="01";
                        if(sheetObj.RowCount()> 1) {
                            var max_seq=(parseInt(formObj.max_seq.value, 10) + 1) + "";
                            if(max_seq.length ==1) {
                                scg_grp_cmdt_cd="0" + max_seq;
                            }
                            else if(max_seq.length ==2) {
                                scg_grp_cmdt_cd=max_seq;
                            }
                            else if(max_seq.length ==3) {
                                return;
                            }
                        }
                        sheetObj.SetCellValue(idx, "scg_grp_cmdt_cd",scg_grp_cmdt_cd,0);
                        sheetObjects[2].RemoveAll();
                        // max 1 increase
                        formObj.max_seq.value=sheetObj.GetCellValue(idx, "scg_grp_cmdt_seq");
                        sheetObj.SelectCell(idx,"scg_grp_cmdt_desc");
                    } else if (sheetObj.id == "sheet2") {
                        var idx=sheetObj.DataInsert();
                        sheetObj.SetCellValue(idx, "svc_scp_cd",getSvcScpCd());
                        sheetObj.SetCellValue(idx, "chg_cd",formObj.chg_cd.value);
                        var scg_grp_cmdt_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "scg_grp_cmdt_seq");
                        sheetObj.SetCellValue(idx, "scg_grp_cmdt_seq",scg_grp_cmdt_seq);
                        sheetObj.SetCellValue(idx, "scg_grp_cmdt_dtl_seq",parseInt(ComPriGetMax(sheetObj, "scg_grp_cmdt_dtl_seq"), 10) + 1);
                        //exp_date
                        sheetObj.SetCellValue(idx, "exp_dt","99991231");
                        sheetObj.SelectCell(idx,"cmdt_cd");
                    }
                }
                break;
            case IBDELETE: // Delete
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                
                var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                if(chkArr.length==0) {
                	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk", 1, false);
                	chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                }
                
                for(i=0 ; i< chkArr.length ; i++){
 					if ( sheetObj.id == "sheet1" )sheetObjects[2].RemoveAll();
 					sheetObj.SetCellValue( chkArr[i] , "ibflag","D", false);
 					sheetObj.SetCellValue( chkArr[i] , "chk", 0, false);
 					sheetObj.SetRowHidden( chkArr[i] ,1);  //.SetRowHidden(Row,Hidden) Get : 1 이면 숨기 상태, 0이면 보이는 상태)
	 			}
                
                formObj.max_seq.value=ComPriGetMaxExceptDelete(sheetObj, "scg_grp_cmdt_seq");
                break;
            case IBDOWNEXCEL:
                if (validateForm(sheetObj,document.form,sAction)) {
                    formObj.f_cmd.value=SEARCH03;
                    var xml=sheetObj.GetSearchData("ESM_PRI_4008GS.do", FormQueryString(formObj) );
                    var dataCount=ComGetTotalRows(xml);
                    if(dataCount < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		sheetObj.LoadSearchData(xml,{Sync:1} );
                		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                	}
                }
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
     * @return bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
            case IBSEARCH: // retrieving
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if ( sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
                    if ( ComShowCodeConfirm("PRI00010") ) {
                        return true;
                    }else {
                        return false;
                    }               
                }
                return true;
                break;
            case IBSAVE: // Saving
                if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[2].IsDataModified()&& sheetObjects[2].GetSaveString() == "") {
                    return false;
                }
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if (!sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                if (sheetObjects[1].IsDataModified()) {
                    var rowM=sheetObjects[1].ColValueDup("svc_scp_cd|chg_cd|scg_grp_cmdt_cd",false);
                    if (rowM >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet", rowM);
                        return false;
                    }
                }
                if (sheetObjects[2].IsDataModified()) {
                    var rowD=sheetObjects[2].ColValueDup("cmdt_cd",false);
                    if (rowD >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet", rowD);
                        return false;
                    }
                }
                // Check whether data saved at sheet1
                if (!sheetObjects[1].IsDataModified() && (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) ) {
                	ComShowCodeMessage("PRI00308","Input","Group Code");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                if (!sheetObjects[1].IsDataModified() && !sheetObjects[2].IsDataModified() && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("PRI00319", "Commodity Code");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }
                return true;
                break;
            case IBINSERT: // Row Add
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if(sheetObj.id == "sheet2" && sheetObjects[1].RowCount() <= 0) {
                	ComShowCodeMessage("PRI00308","Input","Group Code");
                	doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                	return false;
                }

                return true;
                break;
            case IBDELETE: // Delete
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                return true;
                break;
            case IBDOWNEXCEL:      // excel down
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                return true;
                break;
        }
        return true;
    }
    
    /**
     * Execute when data of sheet changed. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row
     * @param {int} Col
     * @param {String} Value
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
        setDeltFlg(Row);
    }
    
    /**
     * Execute when data of sheet changed. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row
     * @param {int} Col
     * @param {String} Value
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value){
    	var formObj=document.form
        var colname=sheetObj.ColSaveName(Col);
        switch(colname) {
            case "cmdt_cd":
                if (Value.length==6){
                    formObj.f_cmd.value=SEARCH08;
                    formObj.cd.value=sheetObj.GetCellValue(Row,Col);

                    var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                    var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                    if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                        sheetObj.SetCellValue(Row,"cmdt_des",arrData[1],0);
                    }else{
                        ComShowCodeMessage("PRI00315");
                        sheetObj.SetCellValue(Row,"cmdt_cd","",0);
                        sheetObj.SetCellValue(Row,"cmdt_des","",0);
                        sheetObj.SelectCell(Row,"cmdt_cd");
                    }
                }else{
                    ComShowCodeMessage("PRI00315");
                    sheetObj.SetCellValue(Row,"cmdt_cd","",0);
                    sheetObj.SetCellValue(Row,"cmdt_des","",0);
                    sheetObj.SelectCell(Row,"cmdt_cd");
                }
            break;
        }
    }
    
    /**
     * Reset the search condition. <br>
     * Save in case of modified data.
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {form} formObj
     * @param {String} gubun
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function searchConditionReset(formObj) {
        if (sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm=true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm=false;
            } else {
                //sc change
            	comboObjects[0].SetSelectIndex(-1);
                formObj.svc_scp_nm.value="";
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {
            //sc change        	
            comboObjects[0].SetSelectIndex(-1);
            formObj.svc_scp_nm.value="";
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
    }
    
    /**
     * Execute when cell on sheet clicked. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow
     * @param {int} OldCol
     * @param {int} NewRow
     * @param {int} NewCol
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
    }
    
    var isFiredNested=false;
    var supressConfirm=false;
    /**
     * It calls when OnSelectCell event triggered on sheet1. <br>
     * when you had modified data and tried to move focus to other cells, it shows save-notice message <br>
     * When you don't save yet, Move the focus to modified Cell by forced.<br>
     *
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow
     * @param {int} OldCol
     * @param {int} NewRow
     * @param {int} NewCol
     * @param {String} sAction
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
        var formObj=document.form;
        var adjNewRow=NewRow;
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetM.IsDataModified()) {
                isFiredNested=true;
                sheetM.SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                if (validateForm(sheetM,document.form,IBSAVE)) {
                    isFiredNested=true;
                    sheetM.SelectCell(NewRow, NewCol, false);
                    isFiredNested=false;
                } else {
                    isFiredNested=true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (sheetD.IsDataModified()) {
                isFiredNested=true;
                sheetM.SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
                    var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                    isFiredNested=true;
                    sheetM.SelectCell(adjNewRow, NewCol, false);
                    isFiredNested=false;
                } else {
                    isFiredNested=true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (appendRow) {
                isFiredNested=true;
                var idx=sheetM.DataInsert(-1);
                isFiredNested=false;
                return idx;
            } else {
                formObj.f_cmd.value=SEARCH02;
                formObj.scg_grp_cmdt_seq.value=sheetM.GetCellValue(NewRow,"scg_grp_cmdt_seq");
                if(formObj.scg_grp_cmdt_seq.value == "undefined" || ComIsEmpty(formObj.scg_grp_cmdt_seq.value)) {
                    formObj.scg_grp_cmdt_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"scg_grp_cmdt_seq");
                }
                try {
                    ComOpenWait(true);
                    var sXml=sheetD.GetSearchData("ESM_PRI_4008GS.do", FormQueryString(formObj));
                    if(sXml != null) sheetD.LoadSearchData(sXml,{Sync:1} );
	                ComOpenWait(false);
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
        }
    }
    
    /**
     * Calling function in case of OnPopupClick event<br>
     * Calling Location PopUp <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
     * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
     * @return void
     * @author 
     * @version 2009.05.07
     */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        if (colName == "cmdt_cd"){
            var sUrl="/opuscntr/ESM_PRI_4027.do?commodity_cmd=C";
            ComOpenPopup(sUrl, 700, 345, "callbackesmpri4008", "1,0", true);
        }
    }

    function callbackesmpri4008(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
            sheet2.SetCellValue(sheet2.GetSelectRow(), "cmdt_des",rtnVal.nm,0);
        }
    }
    
    /**
     * Execute before click the check button on sheet. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} Row
     * @param {String} Col
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, colName);
        }
    }
    
    /**
     * Execute before click the check button on sheet. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} Row
     * @param {String} Col
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, colName);
        }
    }
    
    /**
     * When retrieves data, set the max sequence from etc-data. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {String} ErrMsg
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnSearchEnd(ErrMsg)  {
        var formObj=document.form;
        formObj.max_seq.value=sheetObjects[1].GetEtcData("max_seq");
    }
    
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Execute it after Sheet save completely <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg selection
     * @return void
     * @author 
     * @version 2010.03.11
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj=document.form;
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                doRowChange(sheetObjects[1], sheetObjects[2], -1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol(), false);
            }
        }
    }
    
    function retrieveSheet(type, groupKey) {
    	var formObj=document.form;
        if (type == 1) {
        	doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
        } else if (type == 2) {
        	formObj.f_cmd.value=SEARCH02;
        	formObj.scg_grp_cmdt_seq.value= groupKey;
            try {
                ComOpenWait(true);
                var sXml=sheetObjects[2].GetSearchData("ESM_PRI_4008GS.do", FormQueryString(formObj));
                if(sXml != null) sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
                ComOpenWait(false);
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
        
        
    }
    
    /**
     * When delt_flag on row is checked, Make disabled the row and detail sheet. <br>
     * <br><b>Example :</b>
     * <pre>
     *     setDeltFlg(Row)
     * </pre>
     * @param {String} Row
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function setDeltFlg(Row)  {
        var formObj=document.form;
        var delt_flg=sheetObjects[1].GetCellValue(Row,"delt_flg");
        if(delt_flg == "1") {
            sheetObjects[1].SetCellEditable(Row, "scg_grp_cmdt_desc",false);
        }
        else if(delt_flg == "0") {
            sheetObjects[1].SetCellEditable(Row, "scg_grp_cmdt_desc",true);
        }
    }
