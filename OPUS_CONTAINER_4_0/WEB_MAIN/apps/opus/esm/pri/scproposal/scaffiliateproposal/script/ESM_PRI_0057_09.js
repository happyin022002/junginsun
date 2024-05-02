/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_09.js (ESM_PRI_0025 Reference)
 *@FileTitle  : Amendment History Inquiry - Affiliate Company
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
    /**
     * @extends
     * @class ESM_PRI_0057_09 : business script for Commodity Group
     */
    function ESM_PRI_0057_09() {
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.processButtonClick=processButtonClick;
        this.doActionIBSheet=doActionIBSheet;
    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var comboObjects=new Array();
    var comboCnt=0;
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 
     * @see #
     * @author 
     * @version 2009.09.15
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  
     * @return 
     * @see #
     * @author 
     * @version 2009.09.15
     */
    function loadPage() {
        var form=document.form;
        sheet1=sheetObjects[0];
        sheetCnt=sheetObjects.length ;
        for (i=0 ; i < sheetCnt ; i++) {
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        loadSts=true;
        sheet1.SetWaitImageVisible(0);
        parent.loadTabPage();
        sheet1.SetWaitImageVisible(1);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : Sheet Obejct
     * @param {int} sheetNo : Sheet Serial No
     * @return 
     * @see #
     * @author
     * @version 2009.09.15
     */
    function initSheet(sheetObj, sheetNo) {
        var form=document.form;
        var cnt=0;
        var sheetID=sheetObj.id;
        var amdt_seq=document.form.amdt_seq.value;
        switch(sheetID) {
            case "sheet1":
				with(sheet1){
					var HeadTitle1="Seq.|propno|amdtseq|afilseq|Customer code|Customer code|Mannual Input|Customer Name|Address|Location|Effective Date|Effective Date|Source|Status|||||||";
					var headCount=ComCountHeadTitle(HeadTitle1);
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"afil_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					 {Type:"CheckBox",  Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"mnl_inp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
					 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cust_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_tmp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:2 },
					 {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq_tmp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(320);
					SetEditable(0);
					SetEllipsis(1);
					SetWaitImageVisible(0);
					SetColProperty("src_info_cd", {ComboText:infoCdComboText, ComboCode:infoCdComboValue} );
					SetColProperty("prc_prog_sts_cd", {ComboText:stsCdComboText, ComboCode:stsCdComboValue} );
				}
                break;
        }
    }
    
    function resizeSheet() {
	    ComResizeSheet(sheetObjects[0]);
	}
    //===================================================================================
    //Handling Button event
    //===================================================================================
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  
     * @return 
     * @see #
     * @author 
     * @version 2009.09.15
     */
    function processButtonClick(){
        var form=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheet1, form, IBSEARCH);
                    break;
            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    //===================================================================================
    //Axson Event Handler
    //===================================================================================
    //===================================================================================
    //UI Object Event Handler
    //===================================================================================
    //===================================================================================
    //Retrieving/Saving
    //===================================================================================
    /**
     * Handling sheet Process <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction Mandatory ,Process Contant value
     * @return N/A
     * @see #
     * @author 
     * @version 2009.09.15
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH01;
                sheet1.DoSearch("ESM_PRI_0057_09GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
        }
    }
    /**
     * Calling event in case of clicking tab on parent screen<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sConChk Mandatory Conversion check 
     * @return N/A
     * @author 
     * @version 2009.05.21
     */
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
        var form=document.form;
        if (form.prop_no.value != sPropNo || form.svc_scp_cd.value != sSvcScpCd || form.amdt_seq.value != sAmdtSeq) {
            form.prop_no.value=sPropNo;
            form.amdt_seq.value=sAmdtSeq;
            form.svc_scp_cd.value=sSvcScpCd;
            form.lgcy_if_flg.value=sLgcyIfFlg;
            doActionIBSheet(sheet1, form, IBSEARCH);
        }
    }
    /**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.05.20
     */
    function tabClearSheet() {
        var formObject=document.form;
        formObject.prop_no.value="";
        formObject.amdt_seq.value="";
        formObject.svc_scp_cd.value="";
        sheet1.RemoveAll();
    }
    var loadSts=false;
    /**
     * Function to check whether Tab screen of Parent is loaded from Frame or not<br>
     * <br><b>Example :</b>
     * <pre>
     *      loadFinishCheck()
     * </pre>
     * @param N/A
     * @return bool  loadSts  <br>
     *              true  : load Completed
     *              false : load not complted
     * @author 
     * @version 2009.05.20
     */
    function loadFinishCheck() {
        return loadSts;
    }
    /**
     * Calling event in case of OnSearchEnd event<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return N/A
     * @author 
     * @version 2009.05.20
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        var sCols="";
        searchEndFontChange(sheetObj, sCols, document.form.lgcy_if_flg.value);
    }
    /**
     * Calling event in case of  OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,Previous selected Cell's Row Index
     * @param {int} OldCol Mandatory Previous selected Cell's Column Index
     * @param {int} NewRow Mandatory ,Current selected Cell's Row Index
     * @param {int} NewCol Mandatory ,Current selected Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (OldRow != NewRow) {

        }
    }
    /**
     * Calling event in case of OnClick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick  ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving
     * @return N/A
     * @author 
     * @version 2009.06.03
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
        var colname=sheetObj.ColSaveName(Col);
        var readOnly=true;
        switch (colname) {
            case "cust_nm":
            case "cust_addr":
                ComShowMemoPad(sheetObj, Row, Col, readOnly, 450, 80);
                break;
        }
    }