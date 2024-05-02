/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0030.js
*@FileTitle  : Guideline MQC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/26
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @
     * @author 
     */
    /**
     * @extends Pri
     * @class ESM_PRI_0030 : Business Script for Guideline MQC
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
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
     * @version 2009.04.22
     */
    function processButtonClick () {
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch (srcName) {
                case "btn_RowAdd":
                    doActionIBSheet(sheetObject1, formObject, IBINSERT);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE);
                    break;
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
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
     * @version 2009.04.22
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
     * @version 2009.04.22
     */
    function loadPage () {
        try {
            var formObj=document.form;
            for (i=0; i < sheetObjects.length; i++) {
                //Modify Environment Setting Function's name
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                //Add Environment Setting Function
                ComEndConfigSheet(sheetObjects[i]);
            }
            var formObj=document.form;
            buttonControl(formObj);
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
     * Button Enable/Disable Control <br>
     * Implement onLoad Event Handler of body tags in Guideline Rate screen <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl(document.form);
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.22
     */
    function buttonControl(formObj) {
        if (formObj.enable_flg.value == 'false') {
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_RowAdd");
            ComBtnDisable("btn_Delete");
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
     * @version 2009.04.22
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        switch (sheetNo) {
            case 1: // sheet1 init
                with(sheetObj){
                
             //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
             var HeadTitle="|Sel|Seq.|||||MIN|MAX";
             var headCount=ComCountHeadTitle(HeadTitle);

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_seq" },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_fm_qty",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_to_qty",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 } ];
              
             InitColumns(cols);
             SetSheetHeight(160);
             SetEditable(1);
             SetWaitImageVisible(0);
             SetColProperty(0 ,"mqc_rng_fm_qty" , {AcceptKeys:"N"});
             SetColProperty(0 ,"mqc_rng_to_qty" , {AcceptKeys:"N"});
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
     * @version 2009.04.22
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: 
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH;
                         sheetObj.DoSearch("ESM_PRI_0030GS.do", FormQueryString(formObj) );
                    }
                }
                ComOpenWait(false);
                break;
            case IBSAVE: // Save
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=MULTI;
                        sheetObj.DoSave("ESM_PRI_0030GS.do", FormQueryString(formObj));
                    }
                }
                ComOpenWait(false);
                break;
            case IBINSERT:
                var Row=sheetObj.DataInsert();
                if (Row == 1) {
                    sheetObj.SetCellValue(Row, "mqc_rng_fm_qty",1,0);
                } else {
                    var validRow=getPrevValidRow(sheetObj, Row);
                    if (validRow != 0 && sheetObj.GetCellValue(validRow, "mqc_rng_to_qty") != '') {
                    	sheetObj.SetCellValue(Row, "mqc_rng_fm_qty",Number(sheetObj.GetCellValue(validRow, "mqc_rng_to_qty")) + 1,0);
                    }
                }
                sheetObj.SetCellValue(Row, "svc_scp_cd",formObj.svc_scp_cd.value,0);
                sheetObj.SetCellValue(Row, "gline_seq",formObj.gline_seq.value,0);
                sheetObj.SetCellValue(Row, "prc_cust_tp_cd",formObj.prc_cust_tp_cd.value,0);
                break;
            case IBDELETE: 
                deleteRowCheck(sheetObj, "chk", true);
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
     *         true  : Valid<br>
     *         false : Invalid
     * @author 
     * @version 2009.04.22
     */
    function validateForm (sheetObj, formObj, sAction) {
        with (sheetObj) {
            if (sAction == IBSAVE) {
                var cnt=sheetObj.LastRow();
                var validRow;
                for ( var i=1; i <= cnt; i++) {
                	if (sheetObj.GetRowStatus(i) == "D") {
                        continue;
                    }
                    // MIN > 0
                	if (Number(sheetObj.GetCellValue(i, "mqc_rng_fm_qty")) == 0) {
                        ComShowCodeMessage('PRI00321', "MIN","0");
                        sheetObj.SelectCell(i, "mqc_rng_fm_qty");
                        return false;
                    }
                    // Validation of MIN and MAX 
                	if (Number(sheetObj.GetCellValue(i, "mqc_rng_fm_qty")) >= Number(sheetObj.GetCellValue(i, "mqc_rng_to_qty"))) {
                        ComShowCodeMessage('PRI08008');
                        sheetObj.SelectCell(i, "mqc_rng_to_qty", true, Number(sheetObj.GetCellValue(i, "mqc_rng_fm_qty")) + 1);
                        return false;
                    }
                    if (i != cnt) {
                        // Current Row Max = Next Row Min - 1
                        validRow=getNextValidRow(sheetObj, i);
                        if (validRow != 0 && Number(sheetObj.GetCellValue(i, "mqc_rng_to_qty")) != Number(sheetObj.GetCellValue(validRow, "mqc_rng_fm_qty"))-1) {
                            ComShowCodeMessage('PRI08009');
                            sheetObj.SelectCell(i, "mqc_rng_to_qty", true, Number(sheetObj.GetCellValue(validRow, "mqc_rng_fm_qty"))-1);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Showing saving confirmation message <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.04.22
     */
    function sheet1_OnSaveEnd (sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            try {
                doActionIBSheet(sheetObj, document.form, IBSEARCH);
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
    }
    /**
     * Calling Function in case of OnChange event <br>
     * When Min/Max value changed, validation check again. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
     * @param {int} Col Mandatory Cell's Column Index
     * @param {string, int, number, bool} Value Mandatory Cell's Value
     * @return void
     * @author 
     * @version 2009.04.22
     */
    function sheet1_OnChange (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch (colname) {
            case "mqc_rng_fm_qty":
                if (Value != '') {
                    if (sheetObj.RowCount()> 1 && Row != 1) {
                        //var max = getPreviousRowMaxValue(sheetObj, Row, "mqc_rng_to_qty");
                        var validPrevRow=getPrevValidRow(sheetObj, Row);
                        if (validPrevRow != 0) {
                        	sheetObj.SetCellValue(validPrevRow, "mqc_rng_to_qty",Number(sheetObj.GetCellValue(Row, "mqc_rng_fm_qty")) - 1,0);
                        }
                    }
                }
                break;
            case "mqc_rng_to_qty":
                if (Value != '') {
                    if (sheetObj.RowCount()> 1 && Row != sheetObj.RowCount()) {
                        //var min = getNextRowMinValue(sheetObj, Row, "mqc_rng_fm_qty");
                        var validNextRow=getNextValidRow(sheetObj, Row);
                        if (validNextRow != 0) {
                        	sheetObj.SetCellValue(validNextRow, "mqc_rng_fm_qty",Number(sheetObj.GetCellValue(Row, "mqc_rng_to_qty")) + 1,0);
                        }
                    }
                }
                break;
        }
    }
