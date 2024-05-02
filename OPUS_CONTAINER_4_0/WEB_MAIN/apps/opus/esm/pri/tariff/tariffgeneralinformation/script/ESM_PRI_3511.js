/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3511.js
*@FileTitle  : Tariff General Information Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
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
     * @version 2010.10.27
     */
    function processButtonClick(){
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch (srcName) {
                case "btn_new":
                    doActionIBSheet(sheetObjects[1],formObject,IBCREATE);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                    break;
                case "btn_creation":
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01);
                    break;
                case "btn_history":
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC02);
                    break;
                case "btn_print":
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC03);
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
     * @version 2010.10.27
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
     * @version 2010.10.27
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
    * @version 2010.10.27
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
        //Setting IBMultiCombo data
        //Tariff No
        ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
        //Status
        ComPriTextCode2ComboItem(trfBzcStsCdComboValue, trfBzcStsCdComboText, getComboObject(comboObjects, 'trf_bzc_sts_cd') ,"|","\t" );
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
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
     * @version 2010.10.27
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                    
                    //  no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|TRF_PFX_CD|TRF_NO|TRF_NM|TRF_ORZ_NM|TRF_ORZ_TP_NM|AMDT_SEQ|TRF_BZC_STS_CD|TRF_BZC_STS_NM|EFF_DT|EXP_DT|PUB_DT|CRE_DT|UPD_DT|"
                        +"RQST_OFC_CD|CRE_USR_ID|APRO_OFC_CD|TRF_BZC_TP_CD|TRF_BZC_WGT|TRF_BZC_WGT_UT_CD|TRF_BZC_VOL_QTY|TRF_BZC_VOL_UT_CD|CURR_CD|"
                        +"PUB_CNTC_PSON_NM|PUB_OFC_ADDR|PUB_OFC_PHN_NO|PUB_OFC_CTY_NM|PUB_OFC_STE_CD|PUB_OFC_ZIP_CD|PUB_OFC_CNT_NM|PUB_OFC_FAX_NO|PRE_PUB_DT";
                    var headCount=ComCountHeadTitle(HeadTitle);
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_orz_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_orz_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_wgt_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_vol_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_cntc_pson_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_cty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_ste_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_zip_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_fax_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pre_pub_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    
                    SetSheetHeight(250);
                }
                break;
            case "sheet2":
                with(sheetObj){
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|TRF_PFX_CD|TRF_NO|Tariff Code|Tariff Name|Tariff Type|Effective Date|Publish Date|Status|Inland Rates|Amend No.";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:1,   SaveName:"trf_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                       
                    InitColumns(cols);
                    
                    SetColProperty("trf_bzc_sts_cd", {ComboText:trfBzcStsCdComboText, ComboCode:trfBzcStsCdComboValue} );

                    SetEditable(1);
                    SetWaitImageVisible(false);
                    SetSheetHeight(150);
                }
                break;
            case "sheet3":
                with(sheetObj){
                    
                    //  no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|SEQ|Origin|Origin Description";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                                 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(false);
                    resizeSheet();//SetSheetHeight(150);
                }
                break;
            case "sheet4":
                with(sheetObj){
                    
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|SEQ|Destination|Destination Description";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                                 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(false);
                    resizeSheet();//SetSheetHeight(150);
                }
                break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[2]); ComResizeSheet(sheetObjects[3]); }
    /**
     * setting intial combo value <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2010.10.27
     */        
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {     
            case "tariff_cd":
//              var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
//no support[check again]CLT                    IMEMode=0;
                    SetUseAutoComplete(1);
					ValidChar(2,3);
                    SetMaxLength(8);
                }
                break;
            case "trf_bzc_sts_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    //no support[check again]CLT ValidChar(1, 0);
                    SetMaxLength(10);
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
   * @version 2010.10.27
   */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            sheetObj.ShowDebugMsg(false);
            switch (sAction) {
                case IBSEARCH: // retrieving
                    formObj.f_cmd.value=SEARCHLIST01;
                    var param="f_cmd="           + formObj.f_cmd.value
                              + "&trf_pfx_cd="     + formObj.trf_pfx_cd.value
                              + "&trf_no="         + formObj.trf_no.value
                              + "&trf_bzc_sts_cd=" + comboObjects[1].GetSelectCode();
                    ComOpenWait(true); //->waiting->start
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3511GS.do", param);
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    if(sheetObjects[1].rowCount == 0){
                        clearAllForms();
                    }
                    //ComOpenWait(false); //->waiting->End
                    sheetObjects[1].SelectCell(1, 1);
                    break;
                case IBCREATE: // New
                    ComOpenWait(true); //->waiting->start
                    clearAllForms();
                    comboObjects[0].SetSelectIndex(-1);
                    comboObjects[1].SetSelectIndex(-1);
                    formObj.trf_pfx_cd.value="";
                    formObj.trf_no.value="";
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    sheetObjects[3].RemoveAll();
                    ComOpenWait(false); //->waiting->End
                    tariff_cd.Focus();
                    break;
                case IBSEARCH_ASYNC01: // Open Creation
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    goCreation(sheetObj);
                    break;
                case IBSEARCH_ASYNC02: // History
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    goHistory(sheetObj);
                    break;
                case IBSEARCH_ASYNC03: // Print
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    goPrint(sheetObj);
                    break;
            }
        }catch(e){
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally {
             ComOpenWait(false);
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
     * @version 2010.12.24
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC01:
            if (sheetObj.RowCount()< 1) {
                ComShowCodeMessage("PRI00337","Tariff Code");
                return false;
            }
            break;
        case IBSEARCH_ASYNC02:
            if (sheetObj.RowCount()< 1) {
                ComShowCodeMessage("PRI00337","Tariff Code");
                return false;
            }
            break;
        case IBSEARCH_ASYNC03:
            if (sheetObj.RowCount()< 1) {
                ComShowCodeMessage("PRI00337","Tariff Code");
                return false;
            }
            break;
        }
        return true;
    }
/////////////////////// Sheet Event (S) ///////////////////////
    /**
     * calling function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,previous selected cell's Row Index
     * @param {int} OldCol Mandatory Previous selected Cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2010.10.27
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        var formObj=document.form;
        if (OldRow != NewRow) { 
            formObj.f_cmd.value=SEARCH01;
            var param="f_cmd="           + formObj.f_cmd.value
                      + "&trf_pfx_cd="     + sheetObj.GetCellValue(NewRow, "trf_pfx_cd")
                      + "&trf_no="         + sheetObj.GetCellValue(NewRow, "trf_no")
                      + "&amdt_seq="       + sheetObj.GetCellValue(NewRow, "amdt_seq");
    //      alert   (param);
//parameter changed[check again]CLT             
            var sXml=sheetObj.GetSearchData("ESM_PRI_3511GS.do", param);
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                if (arrXml.length > 1){
                sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
                }
                if (arrXml.length > 2){
                sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
                }
            }
        }
        //sheetObj.SelectCell(NewRow, 1);
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
     * @version 2010.10.27
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        ComOpenWait(false);
        var formObj=document.form;
        // SEtting retrieved data to form object
//      formObj.trf_pfx_cd.value = sheetObj.CellValue(1, "trf_pfx_cd");
//      formObj.trf_no.value = sheetObj.CellValue(1, "trf_no");
//      formObj.trf_bzc_sts_cd.value = sheetObj.CellValue(1, "trf_bzc_sts_nm");
        if(sheetObj.RowCount()>0){
            formObj.sh_trf_cd.value=sheetObj.GetCellValue(1, "trf_pfx_cd")+"-"+sheetObj.GetCellValue(1, "trf_no")
            formObj.trf_nm.value=sheetObj.GetCellValue(1, "trf_nm");
            formObj.rqst_ofc_cd.value=sheetObj.GetCellValue(1, "rqst_ofc_cd");
            formObj.cre_usr_id.value=sheetObj.GetCellValue(1, "cre_usr_id");
            formObj.apro_ofc_cd.value=sheetObj.GetCellValue(1, "apro_ofc_cd");
            formObj.amdt_seq.value=sheetObj.GetCellValue(1, "amdt_seq");
            formObj.eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "eff_dt"), "ymd");
            formObj.exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "exp_dt"), "ymd");
            formObj.pub_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "pub_dt"), "ymd");
            formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "cre_dt"), "ymd");
            formObj.trf_bzc_tp_cd.value=sheetObj.GetCellValue(1, "trf_bzc_tp_cd");
            formObj.trf_bzc_wgt.value=sheetObj.GetCellText(1, "trf_bzc_wgt");
            formObj.trf_bzc_wgt_ut_cd.value=sheetObj.GetCellValue(1, "trf_bzc_wgt_ut_cd");
            formObj.trf_bzc_vol_qty.value=sheetObj.GetCellText(1, "trf_bzc_vol_qty");
            formObj.trf_bzc_vol_ut_cd.value=sheetObj.GetCellValue(1, "trf_bzc_vol_ut_cd");
            formObj.curr_cd.value=sheetObj.GetCellValue(1, "curr_cd");
            formObj.pub_cntc_pson_nm.value=sheetObj.GetCellValue(1, "pub_cntc_pson_nm");
            formObj.pub_ofc_addr.value=sheetObj.GetCellValue(1, "pub_ofc_addr");
            formObj.pub_ofc_phn_no.value=sheetObj.GetCellValue(1, "pub_ofc_phn_no");
            formObj.pub_ofc_cty_nm.value=sheetObj.GetCellValue(1, "pub_ofc_cty_nm");
            formObj.pub_ofc_ste_cd.value=sheetObj.GetCellValue(1, "pub_ofc_ste_cd");
            formObj.pub_ofc_zip_cd.value=sheetObj.GetCellValue(1, "pub_ofc_zip_cd");
            formObj.pub_ofc_cnt_nm.value=sheetObj.GetCellValue(1, "pub_ofc_cnt_nm");
            formObj.pub_ofc_fax_no.value=sheetObj.GetCellValue(1, "pub_ofc_fax_no");
        }
    }
/////////////////////// Sheet Event (E) ///////////////////////
/////////////////////// Combo Event (S) ///////////////////////
    /**
     * event in case of changing selected item of IBMulti Combo<br>
     * <br><b>Example :</b>
     * <pre>
     *      tariff_cd_OnChange(comboObj, code, text)
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param   {string} code Mandatory code
     * @param   {string} text charater on screen 
     * @return void
     * @author 
     * @version 2010.10.27
     */
    function tariff_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
        var formObj=document.form;
        var arrText=text.split("|");
        if (arrText != null && arrText.length > 0) {
            if (ComIsEmpty(comboObj.GetSelectText())) {
                formObj.trf_pfx_cd.value="";
                formObj.trf_no.value="";
            }else{
                var arr=code.split("-");
                formObj.trf_pfx_cd.value=arr[0];
                formObj.trf_no.value=arr[1];
            }
        }
    }
    /**
     * event in case of losting IBMulti Combo's focus<br>
     * <br><b>Example :</b>
     * <pre>
     *    tariff_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2010.10.13
     */     
    function tariff_cd_OnBlur(comboObj) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
        var text=comboObj.GetText(code, 1);
        if(ComIsEmpty(code) || text == null || text == "") code="";     
        if (code == null || code == "" || code == "-1") {
            formObj.trf_pfx_cd.value="";
            formObj.trf_no.value="";
        }else {
            var arr=code.split("-");
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
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
    function tariff_cd_OnKeyDown(comboObj, KeyCode) {
        var formObj=document.form;
        if (KeyCode == 13){
            doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
    function trf_bzc_sts_cd_OnKeyDown(comboObj, KeyCode) {
        var formObj=document.form;
        if (KeyCode == 13){
            doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        }
    }
/////////////////////// Combo Event (E) ///////////////////////
    /**
     * Clearing inputted fields on screen and a value of IBMulti Combo Object <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2010.10.27
     */  
     function clearAllForms(){
         var formObj=document.form;
//         comboObjects[0].Index = -1;
//         comboObjects[1].Index = -1;
//         formObj.trf_pfx_cd.value="";
//         formObj.trf_no.value="";
//         formObj.trf_bzc_sts_cd.value="";
         formObj.sh_trf_cd.value="";
         formObj.trf_nm.value=""
         formObj.rqst_ofc_cd.value="";
         formObj.cre_usr_id.value="";
         formObj.apro_ofc_cd.value="";
         formObj.amdt_seq.value="";
         formObj.eff_dt.value="";
         formObj.exp_dt.value="";
         formObj.pub_dt.value="";
         formObj.cre_dt.value="";
         formObj.trf_bzc_tp_cd.value="";
         formObj.trf_bzc_wgt.value="";
         formObj.trf_bzc_wgt_ut_cd.value="";
         formObj.trf_bzc_vol_qty.value="";
         formObj.trf_bzc_vol_ut_cd.value="";
         formObj.curr_cd.value="";
         formObj.pub_cntc_pson_nm.value="";
         formObj.pub_ofc_addr.value="";
         formObj.pub_ofc_phn_no.value="";
         formObj.pub_ofc_cty_nm.value="";
         formObj.pub_ofc_ste_cd.value="";
         formObj.pub_ofc_zip_cd.value="";
         formObj.pub_ofc_cnt_nm.value="";
         formObj.pub_ofc_fax_no.value="";
     }
    /**
     * When Print button clicked, Open Print window using main. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {int} sheetObj sheetObject
     * @author 
     * @version 2010.10.27
     */   
  function goPrint(sheetObj){
      sParam="trfPfxCd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
             + "&trfNo="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
             + "&amdtSeq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
      ComOpenPopup("ESM_PRI_3506.do?"+sParam,  1024, 650, '','1,0', true);
  }
    /**
     * Openning History screen as main when clicking History button <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {int} sheetObj sheetObject
     * @author 
     * @version 2010.11.08
     */   
    function goHistory(sheetObj){
        var sParam="&trfPfxCd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
               + "&trfNo="    + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
               + "&amdtSeq="  + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
               + "&parentPgmNo=ESM_PRI_M001&pgmNo=ESM_PRI_3504&MENU=Y&menuflag=true&mainPage=true";
        var winObj=window.open("/opuscntr/ESM_PRI_3504.do?parentPgmNo=ESM_PRI_M001" + sParam); 
    }
    /**
     * Openning creation screen as main when clicking Open Creation button<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {int} sheetObj sheetObject
     * @author 
     * @version 2010.10.27
     */   
    function goCreation(sheetObj){
        var sParam="trfPfxCd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                   + "&trfNo="    + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                   + "&amdtSeq="  + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                   + "&parentPgmNo=ESM_PRI_M001&pgmNo=ESM_PRI_3501&MENU=Y&menuflag=true&mainPage=true";
        var winObj=window.open("/opuscntr/ESM_PRI_3501.do?" + sParam); 
}
