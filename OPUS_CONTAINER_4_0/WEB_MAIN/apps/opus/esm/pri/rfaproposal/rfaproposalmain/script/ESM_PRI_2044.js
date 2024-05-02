/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2044.js
*@FileTitle  : RFA Proposal Creation [Copy] 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
     * @class ESM_PRI_2044 : Business Script for ESM_PRI_2044
     */
    // common global variables
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
     * @version 2009.09.30
     */
    function processButtonClick () {
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /** **************************************************** */
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch (srcName) {
                case "btn_Ok":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "afil_chk_frm":
                    if (formObj.afil_chk_frm.checked) {
                        sheetObject1.SetCellValue(1,"afil_chk",1);
                    } else {
                        sheetObject1.SetCellValue(1,"afil_chk",0);
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
     * @version 2009.09.30
     */
    function setSheetObject(sheet_obj){
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
     * @version 2009.09.30
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
     			initSheet(sheetObjects[i],i+1);
     			ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * @version 2009.09.30
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
            case "sheet1":  // hidden
                with (sheetObj) {
	                var HeadTitle="|||Affiliate";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				                 {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"afil_chk" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetWaitImageVisible(0);
	                SetVisible(false);
                }
                break;
            case "sheet2":
                with (sheetObj) {
	                var HeadTitle="|Seq.|||SVC\nScope|SVC\nScope|Group\nLocation|Group\nCommodity|Origin\nArbitrary|Destination\nArbitrary|Rate|Special\nNote|rate_cmdt_cnt|rate_loc_ctn|ao_loc_cnt|ad_loc_cnt";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"scp_chk" },
				                 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loca_chk" },
				                 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_chk" },
				                 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"aror_chk" },
				                 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"arde_chk" },
				                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rate_chk" },
				                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"spnt_chk" },
				                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rt_cmdt_cnt" },
				                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rt_loc_cnt" },
				                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ao_loc_cnt" },
				                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ad_loc_cnt" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetWaitImageVisible(0);
	                resizeSheet(); //SetSheetHeight(130);
                }
                break;
        }
    }
    
    function resizeSheet(){
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
     * @version 2009.09.30
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // retrieving
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var sXml=sheetObj.GetSearchData("ESM_PRI_2044GS.do" , FormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                for (var i=0 , n=arrXml.length; i < n; i++) {
                    sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
                }
                ComOpenWait(false);
                break;
            case IBSAVE: // Saving
                ComOpenWait(true);
                if (!validateForm (sheetObjects[1], formObj, sAction)) {
                    return;
                }
                if (!ComShowCodeConfirm('PRI00012')) {
                    return;
                }
                for (var i=1, n=sheetObjects[0].RowCount(); i <= n; i++) {
                	if (sheetObjects[0].GetCellValue(i, "afil_chk") == 1) {
                        sheetObjects[0].SetRowStatus(i,"U");
                    } else {
                        sheetObjects[0].SetRowStatus(i,"R");
                    }
                }
                for (var i=1, n=sheetObjects[1].RowCount(); i <= n; i++) {
                	if (sheetObjects[1].GetCellValue(i, "scp_chk") == 1) {
                        sheetObjects[1].SetRowStatus(i,"U");
                    } else {
                        sheetObjects[1].SetRowStatus(i,"R");
                    }
                }
                formObj.f_cmd.value=MULTI;
                var sParam="";
                var sParamSheet1=sheetObjects[0].GetSaveString();
                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2=sheetObjects[1].GetSaveString();
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj);
                var sXml=sheetObj.GetSaveData("ESM_PRI_2044GS.do", sParam);
                	sheetObjects[0].LoadSaveData(sXml);
                ComOpenWait(false);
                break;
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Apply the retrieved sheet data to form. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.09.30
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            var formObj=document.form;
            if (sheetObj.SearchRows()== 1) {
            	formObj.afil_chk_frm.checked=(sheetObj.GetCellValue(1, "afil_chk")==1);
            	formObj.afil_chk_frm.disabled=(sheetObj.GetCellValue(1, "afil_chk")==0);
            }
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * In case of item without data, you cannot select it.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.09.30
     */
    function sheet2_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            for (var i=sheetObj.HeaderRows(), n=sheetObj.RowCount()+sheetObj.HeaderRows(); i < n; i++) {
                for (var j=sheetObj.SaveNameCol("scp_chk"); j <= sheetObj.SaveNameCol("spnt_chk") ; j++) {
                	if (sheetObj.GetCellValue(i, j) != 1) {
                        sheetObj.SetCellEditable(i, j,0);
                    }
                }
            }
        }
    }
    /**
     * Calling Function in case of OnChange event <br>
     * When SVC Scope Unchecked, 12 item of that row are all unchecked <br>
     * When SVC Scope checked, 12 item of that row are all checked <br>
     * When check it after uncheck, Display check sign the same item of checked when it opened. <br>
     * When Rate Option selected, Origin, Destination, Group Commodity, Group Location selected automatically<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.09.30
     */
    function sheet2_OnChange (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch (colname) {
            case "scp_chk":
                for (var i=sheetObj.SaveNameCol("loca_chk"); i <= sheetObj.SaveNameCol("spnt_chk"); i++) {
                    if (sheetObj.GetCellEditable(Row, i)) {
                        sheetObj.SetCellValue(Row, i,Value,0);
                    }
                }
                break;
            case "rate_chk":
                if (Value == 1) {
                	if (sheetObj.GetCellEditable(Row, "loca_chk") && sheetObj.GetCellValue(Row, "rt_loc_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "loca_chk",1,0);
                    }
                	if (sheetObj.GetCellEditable(Row, "cmdt_chk") && sheetObj.GetCellValue(Row, "rt_cmdt_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "cmdt_chk",1,0);
                    }
                }
                break;
            case "aror_chk":
                if (Value == 1) {
                	if (sheetObj.GetCellEditable(Row, "loca_chk") && sheetObj.GetCellValue(Row, "ao_loc_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "loca_chk",1,0);
                    }
                }
                break;
            case "arde_chk":
                if (Value == 1) {
                	if (sheetObj.GetCellEditable(Row, "loca_chk") && sheetObj.GetCellValue(Row, "ad_loc_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "loca_chk",1,0);
                    }
                }
                break;
            case "loca_chk":
                if (Value == 0) {
                	if (sheetObj.GetCellValue(Row, "rate_chk") == 1 && sheetObj.GetCellValue(Row, "rt_loc_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "rate_chk",0,0);
                    }
                	if (sheetObj.GetCellValue(Row, "aror_chk") == 1 && sheetObj.GetCellValue(Row, "ao_loc_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "aror_chk",0,0);
                    }
                	if (sheetObj.GetCellValue(Row, "arde_chk") == 1 && sheetObj.GetCellValue(Row, "ad_loc_cnt") == "1") {
                        sheetObj.SetCellValue(Row, "arde_chk",0,0);
                    }
                }
                break;
            case "cmdt_chk":
            	if (Value == 0 && sheetObj.GetCellValue(Row, "rate_chk") == 1 && sheetObj.GetCellValue(Row, "rt_cmdt_cnt") == "1") {
                    sheetObj.SetCellValue(Row, "rate_chk",0,0);
                }
                break;
        }// end switch
        if (Value == 1) {
        	if (sheetObj.GetCellValue(Row, "scp_chk") != 1) {
                sheetObj.SetCellValue(Row, "scp_chk",1,0);
            }
        } else {
            var b=true;
            // Check Terms checkbox 
            for (i=sheetObj.SaveNameCol("loca_chk"); i <= sheetObj.SaveNameCol("spnt_chk"); i++) {
            	if (sheetObj.GetCellValue(Row, i) == 1) {
                    b=false;
                }
            }
            if (b) {
                // When All Terms become unchecked, Scope also make unchecked.
                sheetObj.SetCellValue(Row, "scp_chk",0,0);
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
     * @version 2009.09.30
     */
    function validateForm (sheetObj, formObj, sAction) {
        with (sheetObj) {
            switch (sAction) {
                case IBSAVE:
                    if (FindCheckedRow("scp_chk") == "") {
                        ComShowCodeMessage('PRI01007');
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Running below logic after saving.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.09.30
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            var newPropNo=sheetObj.GetEtcData("newPropNo");
//            window.returnValue=newPropNo;
//            ComClosePopup();
            ComPopUpReturnValue(newPropNo);
        }
    }
