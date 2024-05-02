/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3504.js
*@FileTitle : Tariff General Information History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastVersion : 1.0
* 2010.11.01 
* 1.0 Creation
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
     * @return void
     * @author 
     * @version 2010.10.13
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
            
            switch (srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btns_calendar": //Calendar Button                                     
                    var cal=new ComCalendar();
                    cal.select(formObject.access_dt, 'yyyy-MM-dd');
                    break;  
                case "btn_print":
                    doActionIBSheet(sheetObject2,formObject,SEARCH04);
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
    * <pre> formObj
    *     loadPage();
    * </pre>
    * @return void
    * @author 
    * @version 2010.10.13
    */
    function loadPage() {   
        for (i=0; i < sheetObjects.length; i++) {
            // Modify Enviroment Setting Function's name
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            // Add Environment Setting Function 
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
        tariff_cd.Focus();
        var formObj=document.form;
        if (formObj.trf_no.value != "") {// Call in another window. "Tariff General Information Inquiry" window queried             
            tariff_cd.value=formObj.trf_pfx_cd.value + "-" + formObj.trf_no.value;
            comboObjects[0].SetSelectText(tariff_cd.value);
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
       }
        
    }
    /**
    * Registering event listener<br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl();
    * </pre>
    * @return void
    * @author 
    * @version 2009.08.25
    */
   function initControl() {
       // Process Axon Event No.1, Event Catch 
//       axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//       axon_event.addListener('keyup', "ComKeyEnter('LengthNextFocus')", document.form);
       axon_event.addListenerFormat('keypress', 'obj_KeyPress', document.form);
       axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
       axon_event.addListenerForm('beforedeactivate', 'obj_onDeactivate', document.form);
       ComClearSeparator (document.form.access_dt,"eng"); // Block Korean Input key
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
     * @version 2010.11.09
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "tariff_cd":
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
 //no support[check again]CLT                   IMEMode=0;
                    SetUseAutoComplete(1);
                    ValidChar(2, 3);    // Uppercase, Numeric and including special char.
                    SetMaxLength(8);
                }
                break;          
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
      * @version 2010.10.13
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
        case "sheet1":
            with(sheetObj){
            
          var HeadTitle="Tariff Code|Tariff Name|Tariff Type";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tariff_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:"trf_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
                 {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetWaitImageVisible(0);
          SetSheetHeight(200);
                }


            break;
        case "sheet2":
            with(sheetObj){
          var HeadTitle="Amend\nNo.|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Status|Inland Rates|Request\nOffice|Creation\nStaff|Approval\nOffice";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pub_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_sts_cd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_wgt_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_vol_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_cntc_pson_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_cty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_ste_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_zip_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_fax_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:500,  Align:"Left",    ColMerge:0,   SaveName:"trf_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"trf_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetWaitImageVisible(0);
          SetSheetHeight(160);
                }


            break;
        case "sheet3":
            with(sheetObj){
            
          var HeadTitle="|SEQ|Origin|Origin Description";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetWaitImageVisible(0);
          SetSheetHeight(150);
                }


            break;
        case "sheet4":
            with(sheetObj){
            
          var HeadTitle="|SEQ|Destination|Destination Description";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetWaitImageVisible(0);
          SetSheetHeight(150);
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
                    if ( sheetObj.id == "sheet1") {
                        if (!validateForm(sheetObj,document.form,sAction)) {
                            return false;
                        }
                        ComOpenWait(true);              
                        formObj.f_cmd.value=SEARCH01;
                        if (ComIsEmpty(comboObjects[0].GetSelectText())){
                            formObj.trf_pfx_cd.value="";
                            formObj.trf_no.value="";
                            formObj.trf_nm.value="";      
                        }
                        sheetObjects[1].RemoveAll();
                        sheetObjects[2].RemoveAll();
                        sheetObjects[3].RemoveAll();
                        ComClearManyObjects(formObj.sh_trf_cd, formObj.trf_nm, formObj.rqst_ofc_cd, formObj.cre_usr_id
                                ,formObj.apro_ofc_cd, formObj.amdt_seq, formObj.eff_dt, formObj.exp_dt, formObj.pub_dt, formObj.cre_dt
                                ,formObj.trf_bzc_tp_cd, formObj.trf_bzc_wgt, formObj.trf_bzc_wgt_ut_cd,formObj.trf_bzc_vol_qty,formObj.trf_bzc_vol_ut_cd,formObj.curr_cd                                         
                                ,formObj.pub_cntc_pson_nm,formObj.pub_ofc_addr,formObj.pub_ofc_phn_no,formObj.pub_ofc_cty_nm,formObj.pub_ofc_ste_cd
                                ,formObj.pub_ofc_zip_cd,formObj.pub_ofc_cnt_nm,formObj.pub_ofc_fax_no);
                        var sXml=sheetObj.GetSearchData("ESM_PRI_3504GS.do", FormQueryString(formObj));
                        sheetObj.LoadSearchData(sXml,{Sync:1} );
                    }
                    break;  
                case SEARCH04: // Print
                    if(sheetObj.GetSelectRow() == '-1'){
                        ComShowCodeMessage('PRI00337','Amend No.');
                        return false;
                    }
                   sParam="trfPfxCd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                            + "&trfNo="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                            + "&amdtSeq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
                   ComOpenPopup("/opuscntr/ESM_PRI_3506.do?"+sParam, 1024, 650, '','1,0', true);
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
     * @version 2010.11.01
     */
    function tariff_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
        var formObj=document.form;
        var arrText=text.split("|");
        
        if (arrText != null) {
            formObj.trf_nm_title.value=comboObj.GetText(code, 1);
                if (ComIsEmpty(comboObj.GetSelectText())) {
                    formObj.trf_pfx_cd.value="";
                    formObj.trf_no.value="";
                    formObj.trf_nm_title.value="";                          
                }else{
                    var arr=code.split("-");
                    formObj.trf_pfx_cd.value=arr[0];
                    formObj.trf_no.value=arr[1];
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
         * @version 2010.11.01
         */
        function tariff_cd_OnKeyDown(comboObj, KeyCode) {
            var formObj=document.form;
            if (KeyCode == 13){                             
                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
     * @version 2010.11.01
     */     
    function tariff_cd_OnBlur(comboObj) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
        if (code != null && code != "" && code != "-1") {
            var arr=code.split("-");                
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
            formObj.trf_nm_title.value=comboObj.GetText(code, 1);
        }
    }
    /**
     * calling function in case of OnSelectCell event <br>
     * When click it, Retrieve sub-level data <br>
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
     * @version 2010.11.02
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
        if(OldRow != NewRow){
            sheetObjects[1].RemoveAll();
            var formObj=document.form;
            formObj.f_cmd.value=SEARCH02;
            var param="f_cmd="           + formObj.f_cmd.value
                      + "&trf_pfx_cd="     + sheetObj.GetCellValue(NewRow, "trf_pfx_cd")
                      + "&trf_no="         + sheetObj.GetCellValue(NewRow, "trf_no")
                      + "&access_dt="         + formObj.access_dt.value;
            var sXml=sheetObjects[1].GetSearchData("ESM_PRI_3504GS.do", param);
            sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
        }
    }
    /**
     * calling function in case of OnSelectCell event <br>
     * When click it, Retrieve sub-level data <br>
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
     * @version 2010.11.02
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            var formObj=document.form;
            if(sheetObj.RowCount()>0){
                formObj.sh_trf_cd.value=sheetObj.GetCellValue(NewRow, "trf_pfx_cd")+"-"+sheetObj.GetCellValue(NewRow, "trf_no");
                formObj.trf_nm.value=sheetObj.GetCellValue(NewRow, "trf_nm");
                formObj.rqst_ofc_cd.value=sheetObj.GetCellValue(NewRow, "rqst_ofc_cd");
                formObj.cre_usr_id.value=sheetObj.GetCellValue(NewRow, "cre_usr_id");
                formObj.apro_ofc_cd.value=sheetObj.GetCellValue(NewRow, "apro_ofc_cd");
                formObj.amdt_seq.value=sheetObj.GetCellValue(NewRow, "amdt_seq");
                formObj.eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(NewRow, "eff_dt"), "ymd");
                formObj.exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(NewRow, "exp_dt"), "ymd");
                formObj.pub_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(NewRow, "pub_dt"), "ymd");
                formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(NewRow, "cre_dt"), "ymd");
                formObj.trf_bzc_tp_cd.value=sheetObj.GetCellValue(NewRow, "trf_bzc_tp_cd");
                                    formObj.trf_bzc_wgt.value=sheetObj.GetCellText(NewRow, "trf_bzc_wgt");
                formObj.trf_bzc_wgt_ut_cd.value=sheetObj.GetCellValue(NewRow, "trf_bzc_wgt_ut_cd");
                                    formObj.trf_bzc_vol_qty.value=sheetObj.GetCellText(NewRow, "trf_bzc_vol_qty");
                formObj.trf_bzc_vol_ut_cd.value=sheetObj.GetCellValue(NewRow, "trf_bzc_vol_ut_cd");
                formObj.curr_cd.value=sheetObj.GetCellValue(NewRow, "curr_cd");
                formObj.pub_cntc_pson_nm.value=sheetObj.GetCellValue(NewRow, "pub_cntc_pson_nm");
                formObj.pub_ofc_addr.value=sheetObj.GetCellValue(NewRow, "pub_ofc_addr");
                formObj.pub_ofc_phn_no.value=sheetObj.GetCellValue(NewRow, "pub_ofc_phn_no");
                formObj.pub_ofc_cty_nm.value=sheetObj.GetCellValue(NewRow, "pub_ofc_cty_nm");
                formObj.pub_ofc_ste_cd.value=sheetObj.GetCellValue(NewRow, "pub_ofc_ste_cd");
                formObj.pub_ofc_zip_cd.value=sheetObj.GetCellValue(NewRow, "pub_ofc_zip_cd");
                formObj.pub_ofc_cnt_nm.value=sheetObj.GetCellValue(NewRow, "pub_ofc_cnt_nm");
                formObj.pub_ofc_fax_no.value=sheetObj.GetCellValue(NewRow, "pub_ofc_fax_no");
            }
            formObj.f_cmd.value=SEARCH03;
            var param="f_cmd="           + formObj.f_cmd.value
              + "&trf_pfx_cd="     + sheetObj.GetCellValue(NewRow, "trf_pfx_cd")
              + "&trf_no="         + sheetObj.GetCellValue(NewRow, "trf_no")
              + "&amdt_seq="       + sheetObj.GetCellValue(NewRow, "amdt_seq");
            var sXml=sheetObj.GetSearchData("ESM_PRI_3504GS.do", param);
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
                if (arrXml.length > 1){
                    sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
                }
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
      * @version 2010.11.02
      */
    function validateForm(sheetObj, formObj, sAction) {
        if(!ComChkObjValid(formObj.access_dt)){
            return false;
        }
         switch (sAction) {
         }
        return true;
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
        // Retrieving Enter key
        var eleName=ComGetEvent("name");
        if (eleName == "access_dt"){
            var keyValue=null;
            if(event == undefined || event == null) {
                keyValue=13;
            }else{
                keyValue=ComGetEvent("keyCode") ? ComGetEvent("keyCode") : ComGetEvent("which") ? ComGetEvent("which") : ComGetEvent("charCode");
            }
            if (keyValue == 13){
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
       /**
        * When key pressed, setting dataformat
        * @author  
        * @version 2010.11.15
        */
     function obj_KeyPress(){
         var keyValue=ComGetEvent("keyCode") ? ComGetEvent("keyCode") : ComGetEvent("which") ? ComGetEvent("which") : ComGetEvent("charCode");
         var srcName=ComGetEvent("name");
         var srcValue=ComGetEvent("value");
         switch(ComGetEvent("dataformat")) {
             case "ymd":
              ComKeyOnlyNumber(ComGetEvent());
              if (srcValue.length == 6) {
                document.form.elements[srcName].value=srcValue.substring(0,4) + "-" + srcValue.substring(4,6) + "-"
              }
              break;
         }
      }      
     /**
      * Handling Onbeforedeactivate event<br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_onDeactivate()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2010.10.13
      */   
      function obj_onDeactivate() {
          var eleName=ComGetEvent("name");
          switch(eleName){          
              case "access_dt":
                  ComChkObjValid(ComGetEvent());   
                  break;
          }
      }          


  	function sheet3_OnSort(sheetObj, Col, SortArrow  ) {
  		sheetObj.ReNumberSeq();    
  	}

  	function sheet4_OnSort(sheetObj, Col, SortArrow  ) {
  		sheetObj.ReNumberSeq();    
  	}

