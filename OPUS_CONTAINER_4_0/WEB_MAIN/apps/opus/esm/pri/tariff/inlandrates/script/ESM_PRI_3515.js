/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3515.js
*@FileTitle  : Inland Rates Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
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
                    doActionIBSheet(sheetObjects[0],formObject,IBCREATE);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                    break;
                case "btn_creation":
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
                    break;
                case "btn_history":
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC02);
                    break;
                case "btn_downexcel":
                    if(sheetObjects[2].RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                    }else{
                        doActionIBSheet(sheetObjects[2],formObject,IBSEARCH_ASYNC03);
                    }

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
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * registering IBMulti Combo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj Mandatory IBMulti Combo Object
     * @return N/A
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
    * @return N/A
    * @author 
    * @version 2010.10.27
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            initSheet(sheetObjects[i],i+1);
            ComConfigSheet (sheetObjects[i] );
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        //Setting IBMultiCombo data
        //Tariff No
        ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
        //Status
        ComPriTextCode2ComboItem(trfInlndStsCdComboValue, trfInlndStsCdComboText, getComboObject(comboObjects, 'trf_inlnd_sts_cd') ,"|","\t" );
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
    }
    
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                    SetColProperty("trf_inlnd_sts_cd", {ComboText:trfInlndStsCdComboText, ComboCode:trfInlndStsCdComboValue} );
                    SetColProperty("trf_inlnd_amdt_tp_cd", {ComboText:trfInlndAmdtTpCdComboText, ComboCode:trfInlndAmdtTpCdComboValue} );
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|"
                        + "Inland Rates Name|Effective Date|Status|Amend No.|"
                        + "EXP_DT|PUB_DT|RQST_OFC_CD|APRO_OFC_CD|CRE_DT|CRE_USR_ID|ATCH_FILE_ID|ATCH_FILE_NM|Amend Type";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:0 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:400, Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pub_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"atch_file_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"atch_file_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
     
                    
                    InitColumns(cols);
                    
                    // 2014-08-25 Initiating Combo Data -- correction start
                    InitDataCombo(0, "trf_inlnd_sts_cd", trfInlndStsCdComboText, trfInlndStsCdComboValue);
                    InitDataCombo(0, "trf_inlnd_amdt_tp_cd", trfInlndAmdtTpCdComboText, trfInlndAmdtTpCdComboValue);
                    // -- correction end
                    
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetSheetHeight(150);
                }
                break;


            case "sheet2":  //download
                with(sheetObj){
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|File Name|Download|1|2|3|4|5|6";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"atch_file_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"file_dn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_path_url" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"atch_file_id" },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd" },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_no" },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_seq" },
                                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetImageList(0,"/opuscntr/img/ico_attach.gif");
                    SetCountPosition(0);
                    SetWaitImageVisible(0);
                    SetRowHidden(0, 1);
                    SetDataLinkMouse("file_dn",1);
                    SetShowButtonImage(1);
                    SetAutoRowHeight(0);
                }
                break;
            case "sheet3":
                with(sheetObj){
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle1="| | | | | | | | | | | | |"
                            + "One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
                    var HeadTitle2="Flag|Seq.|Loc.\nCode|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN<=|Weight\nMAX>=|Weight\nUnit|Type|Currency|"
                            + "Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";
                    var headCount=ComCountHeadTitle(HeadTitle1);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                          KeyField:0,   CalcLogic:"",   Format:"Integer" },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_bse_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_via_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_inlnd_rt_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_min_lmt_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_bx_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_hc_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_bx_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_20ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_hc_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_45ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    resizeSheet(); //SetSheetHeight(210);
                }
                break;
        }
    }
    
    function resizeSheet(){
	    ComResizeSheet(sheetObjects[2]);
	}
    
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2010.10.27
     */        
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {     
            case "tariff_cd":
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(false);
                    SetMaxSelect(1);
                    SetUseAutoComplete(true);
                    SetMaxLength(8);
                    ValidChar(2,3);
                }
                break;
            case "trf_inlnd_sts_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(false);
                    SetMaxSelect(1);
                    SetUseAutoComplete(true);
                    SetMaxLength(10);
                    //SetEditable(false)
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
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            sheetObj.ShowDebugMsg(false);
            switch (sAction) {
                case IBSEARCH: // Retrieving
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    formObj.f_cmd.value=SEARCHLIST01;
                    var param="f_cmd="             + formObj.f_cmd.value
                              + "&trf_pfx_cd="       + formObj.trf_pfx_cd.value
                              + "&trf_no="           + formObj.trf_no.value
                              + "&trf_inlnd_sts_cd=" + comboObjects[1].GetSelectCode();
                    ComOpenWait(true); //->waiting->start
//parameter changed[check again]CLT                     
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3515GS.do", param);
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    if(sheetObj.RowCount() > 0 ) {
//                    	sheetObjects[0].SelectCell(1, 1);
                    } else {
//                    	sheetObjects[0].SelectCell(-1, -1);
                    	sheet1_OnSelectCell(sheetObjects[0], -2, 0, -1, 0);
                    }
                    
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
                    changeHeadTitle(sheetObjects[0], sheetObjects[2], false);
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
                case IBSEARCH_ASYNC03: // Down Excel
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                    break;
            }
        }catch(e){
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
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
     *         handling logic;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2010.10.13
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSEARCH: // Retrieving
                if (comboObjects[0].GetSelectCode()== "" || comboObjects[0].GetSelectText()== "") {
                    ComShowCodeMessage("PRI00308","select", "Tariff Code");
                    tariff_cd.Focus();
                    return false;
                }           
                break;
            case IBSEARCH_ASYNC01:
                if (comboObjects[0].GetSelectCode()== "" || comboObjects[0].GetSelectText()== "") {
                    ComShowCodeMessage("PRI00308","select", "Tariff Code");
                    tariff_cd.Focus();
                    return false;
                }
                if (sheetObj.RowCount()< 1) {
                    ComShowCodeMessage("PRI00337","Inland Rates Name");
                    return false;
                }
                break;
            case IBSEARCH_ASYNC02:
                if (comboObjects[0].GetSelectCode()== "" || comboObjects[0].GetSelectText()== "") {
                    ComShowCodeMessage("PRI00308","select", "Tariff Code");
                    tariff_cd.Focus();
                    return false;
                }
                if (sheetObj.RowCount()< 1) {
                    ComShowCodeMessage("PRI00337","Inland Rates Name");
                    return false;
                }
                break;
            case IBSEARCH_ASYNC03:
                if (comboObjects[0].GetSelectCode()== "" || comboObjects[0].GetSelectText()== "") {
                    ComShowCodeMessage("PRI00308","select", "Tariff Code");
                    tariff_cd.Focus();
                    return false;
                }
                if (sheetObj.RowCount()< 1) {
                    ComShowCodeMessage("PRI00337","Inland Rates Name");
                    return false;
                }
                break;
        }
        return true;
    }
    
/////////////////////// Sheet Event (S) ///////////////////////
    /**
     * Calling Function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        var formObj=document.form;
        if (OldRow != NewRow) { 
            formObj.f_cmd.value=SEARCH01;
            var param="f_cmd="           + formObj.f_cmd.value
                      + "&trf_pfx_cd="     + sheetObj.GetCellValue(NewRow, "trf_pfx_cd")
                      + "&trf_no="         + sheetObj.GetCellValue(NewRow, "trf_no")
                      + "&trf_inlnd_seq="  + sheetObj.GetCellValue(NewRow, "trf_inlnd_seq")
                      + "&amdt_seq="       + sheetObj.GetCellValue(NewRow, "amdt_seq");
//          alert   (param);
            ComOpenWait(true); //->waiting->start
            sheetObjects[1].RemoveAll();
//parameter changed[check again]CLT             
            var sXml=sheetObj.GetSearchData("ESM_PRI_3515GS.do", param);
            sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
        }
        ComOpenWait(false); //->waiting->End
//      sheetObj.selectCell(NewRow, 1);
    }
    
    /**
     * Calling function in case of OnMouseMove event<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {Integer} Button Mandatory : direction, 1:left, 2:right
     * @param {Integer} Shift Mandatory , 1:Shift, 2:Ctrl, 0 :other
     * @param {Long} X Mandatory X 
     * @param {Long} Y Mandatory Y 
     * @return N/A
     * @author 
     * @version 2010.11.17
     */
    function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y)  {
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        if(Row == 1 && (Col == 1 || Col == 2)) {
            sheetObj.SetToolTipText(Row, Col,sheetObj.GetCellText(Row, "atch_file_nm"));
        }
    }
    
    /**
     * Downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row         sheetObj의 selection된 Row
     * @param {ibsheet} Col         sheetObj의 selection된 Col
     * @param {String}  Value       file name
     * @return N/A
     * @author 
     * @version 2010.11.17
     */
    function sheet2_OnClick(sheetObj,Row,Col,Value){
        if(sheetObj.ColSaveName(Col)!="file_dn") return;
        location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "atch_file_id");
        return;
    }
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        ComOpenWait(false);
    }
    
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function sheet3_OnSearchEnd(sheetObj, errMsg){
        var formObj=document.form;
        var mainSheetObj=sheetObjects[0];
        var selRow=mainSheetObj.GetSelectRow();
        // SEtting retrieved data to form object
        formObj.cre_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "cre_dt"), "ymd");
        formObj.eff_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "eff_dt"), "ymd");
        formObj.exp_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "exp_dt"), "ymd");
        formObj.pub_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "pub_dt"), "ymd");
        formObj.rqst_ofc_cd.value=mainSheetObj.GetCellValue(selRow, "rqst_ofc_cd");
        formObj.cre_usr_id.value=mainSheetObj.GetCellValue(selRow, "cre_usr_id");
        formObj.apro_ofc_cd.value=mainSheetObj.GetCellValue(selRow, "apro_ofc_cd");
//      formObj.attach_file.value = mainSheetObj.GetCellValue(selRow, "attach_file");
        comboValue2Text(mainSheetObj.GetCellValue(selRow, "trf_inlnd_amdt_tp_cd"));
        //Attach file 
        if(mainSheetObj.GetCellValue(selRow, "atch_file_id") != "") {
            //ComPriXml2Sheet(sheetObjects[1], sXml);
            sheetObjects[1].DataInsert(-1);
            sheetObjects[1].SetCellValue(1, "atch_file_nm",mainSheetObj.GetCellValue(selRow, "atch_file_nm"),0);
            sheetObjects[1].SetCellValue(1, "atch_file_id",mainSheetObj.GetCellValue(selRow, "atch_file_id"),0);
            sheetObjects[1].SetCellValue(1, "file_dn",0,0);
        } else {
            sheetObjects[1].RemoveAll();
        }
        //setting Sheet Head Title
        if(mainSheetObj.RowCount()> 0){
            changeHeadTitle(mainSheetObj, sheetObj, true);
        }else{
            changeHeadTitle(mainSheetObj, sheetObj, false);
        }
    }
    
/////////////////////// Sheet Event (E) ///////////////////////
/////////////////////// Combo Event (S) ///////////////////////
    function tariff_cd_OnChange(comboObj, oldindex, oldtext, oldcode , newindex, newtext , newcode){
        var formObj=document.form;
        var arrText=newtext.split("-");
        if (arrText != null && arrText.length > 0) {
            if (ComIsEmpty(comboObj.GetSelectText())) {
                formObj.trf_pfx_cd.value="";
                formObj.trf_no.value="";
                formObj.tariff_nm.value="";
            }else{
                var arr=newcode.split("-");
                formObj.trf_pfx_cd.value=arr[0];
                formObj.trf_no.value=arr[1];
                formObj.tariff_nm.value=comboObj.GetText(newcode, 1);
            }
        }
    }
    
    /**
     * calling function in case of onBlur event of tariff_cd<br>
     * <br><b>Example :</b>
     * <pre>
     *    tariff_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2010.10.27
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
            formObj.tariff_nm.value=comboObj.GetText(code, 1);
        }
//          alert("code:"+code+":");
//          alert("tariff_cd_OnBlur:"+formObj.trf_pfx_cd.value+":"+formObj.trf_no.value+":");
//          doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
    
    /**
     * Calling Function in case of OnKeyDown event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory
     * @param {int} text Mandatory
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function tariff_cd_OnKeyDown(comboObj, KeyCode) {
        var formObj=document.form;
        if (KeyCode == 13){
            if (comboObj.GetSelectIndex()> 0){
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
     * @param {int} code Mandatory
     * @param {int} text Mandatory
     * @return N/A
     * @author 
     * @version 2010.10.27
     */
    function trf_inlnd_sts_cd_OnKeyDown(comboObj, KeyCode) {
        var formObj=document.form;
        if (KeyCode == 13){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
/////////////////////// Combo Event (E) ///////////////////////
    /**
     * clearing all forms and IBMulti combo<br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms()
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2010.10.27
     */  
     function clearAllForms(){
         var formObj=document.form;
//         comboObjects[0].Index = -1;
//         comboObjects[1].Index = -1;
//         formObj.trf_pfx_cd.value="";
//         formObj.trf_no.value="";
//         formObj.trf_inlnd_sts_cd.value="";
//         formObj.trf_inlnd_nm.value="";
//         formObj.amend_seq.value="";
//         formObj.status.value="";
         formObj.cre_dt.value="";
         formObj.eff_dt.value="";
         formObj.exp_dt.value="";
         formObj.pub_dt.value="";
         formObj.rqst_ofc_cd.value="";
         formObj.cre_usr_id.value="";
         formObj.apro_ofc_cd.value="";
//         formObj.attach_file.value="";
     }
     
     /**
      * Setting text with combo value to form object <br>
      * <br><b>Example :</b>
      * <pre>
      *     comboValue2Text()
      * </pre>
      * @param {String} Amdt Type Code Mandatory
      * @return N/A
      * @author 
      * @version 2010.11.09
      */ 
     function comboValue2Text(amdtTp){
         var trfInlndAmdtTpCdValueArr=trfInlndAmdtTpCdComboValue.split("|");
         var trfInlndAmdtTpCdTextArr=trfInlndAmdtTpCdComboText.split("|");
         var formObj=document.form;
         var arrIdx=0;
         if(amdtTp == "") formObj.trf_inlnd_amdt_tp_cd.value="";
         else {
             var amdtTpLen=trfInlndAmdtTpCdValueArr.length;
             if(amdtTpLen > 0){
                 for(i=0 ; i<amdtTpLen ; i++){
                     if(amdtTp == trfInlndAmdtTpCdValueArr[i]){
                         arrIdx=i;
                     }
                 }
                 formObj.trf_inlnd_amdt_tp_cd.value=trfInlndAmdtTpCdTextArr[arrIdx];
             }
         }
     }
     
    /**
     * Setting Sheet Head Title <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {int} sheetObj sheetObject
     * @author 
     * @version 2010.11.08
     */
    function changeHeadTitle(mainSheetObj, sheetObj, flg) { 
        var title="";
        if(flg){        
        	title=mainSheetObj.GetCellValue(mainSheetObj.GetSelectRow(), "trf_pfx_cd") + "-"
                  + mainSheetObj.GetCellValue(mainSheetObj.GetSelectRow(), "trf_no")     + " "
                  + document.form.tariff_nm.value                                + " - "
                  + mainSheetObj.GetCellValue(mainSheetObj.GetSelectRow(), "trf_inlnd_nm");
        }else{
            title=" ";
        }
        
        sheetObj.SetCellText(0, 1 ,title);
        sheetObj.SetCellText(0, 2 ,title);
        sheetObj.SetCellText(0, 3 ,title);
        sheetObj.SetCellText(0, 4 ,title);
        sheetObj.SetCellText(0, 5 ,title);
        sheetObj.SetCellText(0, 6 ,title);
        sheetObj.SetCellText(0, 7 ,title);
        sheetObj.SetCellText(0, 8 ,title);
        sheetObj.SetCellText(0, 9 ,title);
        sheetObj.SetCellText(0, 10 ,title);
        sheetObj.SetCellText(0, 11 ,title);
        sheetObj.SetCellText(0, 12 ,title);
        
//        var HeadTitle1="|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"
//                       + "One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
//        var HeadTitle2="Flag|Seq.|Loc.\nCode|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN<=|Weight\nMAX>=|Weight\nUnit|Type|Currency|"
//                       + "Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";
        //setting header Row information[Mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//no support[implemented common]CLT         sheetObj.InitHeadRow(0, HeadTitle1, true);
//no support[implemented common]CLT         sheetObj.InitHeadRow(1, HeadTitle2, true);
//      sheetObj.CellAlign(0, 1) = daLeft;
    }
    
    /**
     * Openning creation screen as main when clicking Open Creation button<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {int} sheetObj sheetObject
     * @author 
     * @version 2010.11.08
     */   
    function goCreation(sheetObj){
        var params="trfPfxCd="      + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                   + "&trfNo="         + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                   + "&trfInlndSeq="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
                   + "&amdtSeq="       + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                   + "&MENU=Y&pgmNo=ESM_PRI_3514&parentPgmNo=ESM_PRI_M001&main_page=true";
        var winObj=window.open("/opuscntr/ESM_PRI_3514.do?" + params); 
    }
    
    /**
     * Openning History screen as main when clicking History button <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @author 
     * @version 2010.11.08
     */   
    function goHistory(sheetObj){
        var params="trfPfxCd="      + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                   + "&trfNo="         + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                   + "&trfInlndSeq="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
                   + "&amdtSeq="       + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                   + "&MENU=Y&pgmNo=ESM_PRI_3516&parentPgmNo=ESM_PRI_M001&main_page=true";
        var winObj=window.open("/opuscntr/ESM_PRI_3516.do?" + params); 
    }
