/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3512.js
*@FileTitle  : Tariff Rule Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================**/

/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    var sheetObjects=new Array();
    var sheetCnt=0;
    
    var comboObjects=new Array();
    var comboCnt=0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_new":
                    doActionIBSheet(sheetObject1,formObject,IBCREATE);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn_openc":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC03);
                    break;
                case "btn_history":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
                    break;
                case "btn_print":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
                    break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
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
    * @version 2010.10.13
    */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
  /**
    * registering IBCombo Object as list</b>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(comboObj);
    * </pre>
    * @param {ibcombo} combo_obj Mandatory IBCombo Object
    * @return void
    * @author 
    * @version 2010.10.13
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
    * @version 2010.10.13
    */
    function loadPage() {
        var formObj=document.form;
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
        // Axon Event Initialize
        initControl();
        // Tariff Code Combo Setting
        ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );      
        // Status Code Combo Setting
        ComPriTextCode2ComboItem(trfRuleStsCdComboValue, trfRuleStsCdComboText, getComboObject(comboObjects, 'trf_rule_sts_cd'),"|","\t" );

        tariff_cd.Focus();
    }
    
    /**
     * Catching events for Axon event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2010.10.13
     */         
     function initControl() {
        // Process Axon Event No.1, Event Catch             
        axon_event.addListenerForm('beforeactivate', 'obj_onActivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);               
        axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
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
     * @version 2010.10.13
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                    var HeadTitle="Flag|Seq.|Rule\nNo.|Rule Name|Charge\nCode|Amend\nType|Approval\nOffice|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Amend\nNo. " +
                    "|Status|Request\nOffice|Creation\nStaff" +
                    "|1|2|3|4|5|6";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                           {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"trf_rule_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                           {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                           {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pub_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
                           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
                           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_rule_ctnt" },
                           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bef_trf_rule_ctnt" },
                           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_flg" },
                           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt" } ];
                     
                     InitColumns(cols);
                     SetColProperty("trf_rule_chg_cd", {ComboText:trfRuleChgCdComboText, ComboCode:trfRuleChgCdComboValue} );
                     SetColProperty("trf_rule_amdt_tp_cd", {ComboText:trfRuleAmdtTpCdComboText, ComboCode:trfRuleAmdtTpCdComboValue} );
                     SetColProperty("trf_rule_sts_cd", {ComboText:trfRuleStsCdComboText, ComboCode:trfRuleStsCdComboValue} );
                     SetColProperty("apro_ofc_cd", {ComboText:aproOfcCdComboText, ComboCode:aproOfcCdComboValue} );                      
                     SetEditable(0);
                     SetWaitImageVisible(0);
                     SetSelectionMode(smSelectionRow);//1
                     //SetAutoRowHeight(0);
                     SetSheetHeight(280);
                }


                break;
        }
    }
   /**
    * setting intial combo value <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
    * @param {int} comboNo Mandatory IBMultiCombo's Serial No
    * @return void
    * @author 
    * @version 2010.10.13
    */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "tariff_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(8);
                    SetUseAutoComplete(1);
                    ValidChar(2, 3);    // Uppercase, Numeric and including special char.
                }
                break;
            case "trf_rule_sts_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(10);
                    SetUseAutoComplete(1);
                    ValidChar(1, 0);    // Alphabet Only 
                }
                break;  
        }
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
   * @version 2010.10.13
   */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            sheetObj.ShowDebugMsg(false);
            switch (sAction) {              
                case IBSEARCH: // retrieving
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);                  
                    formObj.rule_ctnt.value="";
                    formObj.f_cmd.value=SEARCH01;    
                    sheetObj.DoSearch("ESM_PRI_3512GS.do", FormQueryString(formObj));
                    //var sXml=sheetObj.GetSearchData("ESM_PRI_3512GS.do", FormQueryString(formObj));
                    //sheetObj.LoadSearchData(sXml,{Sync:1} );
                    break;              
                case IBCREATE: // New
                    comboObjects[0].SetSelectIndex(-1);
                    comboObjects[1].SetSelectIndex(-1);
                    formObj.trf_pfx_cd.value="";
                    formObj.trf_no.value="";    
                    formObj.trf_rule_no.value="";
                    formObj.rule_ctnt.value="";
                    formObj.trf_rule_ctnt.value="";
                    sheetObj.RemoveAll();
                    tariff_cd.Focus();
                    break;
                case IBSEARCH_ASYNC01: // History
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }           
                    var pgmNo="ESM_PRI_3509";
                    var pgmUrl="/opuscntr/ESM_PRI_3509.do"
                    var params="&trf_pfx_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd");
                        params += "&trf_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no");
                        params += "&trf_rule_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
                    var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
                    var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
                    var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
                    var winObj = window.open(pgmUrl+"?parentPgmNo=" + parentPgmNo + src);                
                    break;
                case IBSEARCH_ASYNC02: // Print
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var sParam="trf_pfx_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                        + "&trf_no="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                        + "&amdt_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                        + "&trf_rule_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
                    ComOpenPopup("ESM_PRI_3508.do?"+sParam,1024, 650,  "", "1,0", true);
                    break;
                case IBSEARCH_ASYNC03: // Open Creation
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }           
                    var pgmNo="ESM_PRI_3507";
                    var pgmUrl="/opuscntr/ESM_PRI_3507.do";
                    var params="&trf_pfx_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd");
                        params += "&trf_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no");
                        params += "&trf_rule_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
                    var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
                    var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
                    var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
                    var winObj = window.open(pgmUrl+"?parentPgmNo=" + parentPgmNo + src);                
                    break;
            }
        }catch(e){
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
   /**
    * Calling function in case of Onclick event <br>
    * Manage the contents input/output, Button Control option, Privilege control when selecting rows on sheet. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return void
    * @author 
    * @version 2010.10.13
    */  
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        var formObj=document.form;
        if (OldRow != NewRow) {
                // Contents In/output Management
                setRuleContents(sheetObj, NewRow, NewCol);
        }
    }   
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        ComOpenWait(false);
 
        var formObj=document.form;
        if(sheetObj.RowCount()< 1) {
            formObj.rule_ctnt.value="";
        }
    }
    /**
     * Calling function in case of Onclick event <br>
     * Depend on Status, setting input/ouptu option of Rule Contents. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
     * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
     * @return void
     * @author 
     * @version 2010.10.13
     */ 
    function setRuleContents(sheetObj, NewRow, NewCol)  {       
        var formObj=document.form;      
        var aCtnt=sheetObj.GetCellValue(NewRow, "trf_rule_ctnt");
        if(sheetObj.RowCount()> 0) {
            formObj.rule_ctnt.scrollTop=0;          
            formObj.rule_ctnt.value=aCtnt;
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
     * @version 2010.10.13
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // retrieving
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            break;
        case IBCREATE: // New
            break;
        case IBSEARCH_ASYNC01:
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (sheetObj.RowCount()< 1) {
                ComShowCodeMessage("PRI00337","Rule No.");
                return false;
            }
            break;
        case IBSEARCH_ASYNC02:
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (sheetObj.RowCount()< 1) {
                ComShowCodeMessage("PRI00337","Rule No.");
                return false;
            }
            break;
        case IBSEARCH_ASYNC03:
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (sheetObj.RowCount()< 1) {
                ComShowCodeMessage("PRI00337","Rule No.");
                return false;
            }
            break;
        }
        return true;
    }
    /**
     * Calling Function in case of OnChange event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory Onclick 
     * @param {int} text Mandatory 
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function tariff_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, text, code){
        var formObj=document.form;
        var arrText=text.split("|");
        if (arrText != null && arrText.length > 0) {
            var arr=code.split("-");                
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
        }
    }
    /**
     * calling function in case of OnClear event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function tariff_cd_OnClear(comboObj) {
        var formObj=document.form;      
        comboObj.SetSelectIndex(-1);
    }
    /**
     * Calling Function in case of OnKeyDown event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory Onclick 
     * @param {int} text Mandatory 
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function tariff_cd_OnKeyDown(comboObj, KeyCode) {
        var formObj=document.form;
        if (KeyCode == 13){         
            if (comboObj.GetSelectIndex()> -1){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }
    /**
     * Calling Function in case of OnKeyDown event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory Onclick 
     * @param {int} text Mandatory 
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function trf_rule_sts_cd_OnKeyDown(comboObj, KeyCode) {
        var formObj=document.form;
        if (KeyCode == 13){         
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
     /**
      * Handling OnKeyPress<br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_onKeypress()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2010.10.13
      */ 
    function obj_onKeypress() {
        switch (ComGetEvent("dataformat")) {  
            case "engup":
                if (ComGetEvent("name") == "trf_rule_no") {
                   // ComKeyOnlyAlphabet('uppernum',"45");
                }    
                break;
            case "int":
                ComKeyOnlyNumber(ComGetEvent());
                break;
            case "float":
                ComKeyOnlyNumber(ComGetEvent(), ".");
                break;
            case "ymd":
                ComKeyOnlyNumber(ComGetEvent(), "-");
                break;
            default:
        }
    }    
   /**
    * handling OnBeforeActivate event<br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_onActivate()
    * </pre>
    * @param  void
    * @return void
      * @author 
      * @version 2010.10.13
    */   
    function obj_onActivate() {
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        ComClearSeparator (ComGetEvent());
    }
   /**
    * Handling OnKeyDown even <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2010.10.13
    */  
    function obj_onKeydown(){
        //Proposal No,S/C No.,Retrieving by enter key
        var eleName=ComGetEvent("name");
        if (eleName == "trf_rule_no" || eleName == "trf_rule_ctnt"){
            var keyValue=null;
            if(event == undefined || event == null) {
                keyValue=13;
            }else{
            	keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            }
            if (keyValue == 13){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }
    /**
     * event in case of losting IBMulti Combo's focus<br>
     * <br><b>Example :</b>
     * <pre>
     *    trf_rule_sts_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2010.10.13
     */     
    function trf_rule_sts_cd_OnBlur(comboObj) {
        var formObj=document.form;          
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != "" && code != "-1") {
            var text=comboObj.GetText(code, 1); 
        }
    }
 