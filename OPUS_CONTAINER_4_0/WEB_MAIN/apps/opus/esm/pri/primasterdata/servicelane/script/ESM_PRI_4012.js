/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4012.js
*@FileTitle  : Lane Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/25/08
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
     * @class ESM_PRI_4012 : Business Script for ESM_PRI_4012
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
//다음의 화면들에서 호출됨
//ESM_PRI_0031
//ESM_PRI_0032
//ESM_PRI_0033
//ESM_PRI_0100
//ESM_PRI_0101
//ESM_PRI_0102
    
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.26
     */
    function processButtonClick () {
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch (srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btn_Ok":
                    returnSelectCode(sheetObject1);
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
     * @version 2009.05.26
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
     * @version 2009.05.26
     */
    function loadPage () {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
        try {
            for (i=0; i < sheetObjects.length; i++) {
                //Modify Environment Setting Function's name
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                //Add Environment Setting Function
                ComEndConfigSheet(sheetObjects[i]);
            }
            axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            document.form.vsl_slan_cd.focus();
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
     * @version 2009.05.26
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        switch (sheetObj.id) {
            case "sheet1": // sheet1 init
                with (sheetObj) {
	                var HeadTitle="|Code|Description";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
				                 {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"vsl_slan_nm",  KeyField:0,   CalcLogic:"",   Format:"" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetWaitImageVisible(0);
	                resizeSheet(); //SetSheetHeight(155);
                }
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
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
     * @version 2009.05.26
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: 
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("ESM_PRI_4012GS.do", FormQueryString(formObj) );
                }
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
     * @version 2009.05.26
     */
    function validateForm (sheetObj, formObj, sAction) {
        with (sAction) {
            switch (sAction) {
                case IBSEARCH:
                    var len=formObj.vsl_slan_cd.value.length;
                    if (len > 0 && len < 2) {
                        ComShowCodeMessage("PRI04001", "2");
                        formObj.vsl_slan_cd.select();
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    /**
     * Calling function in case of OnDblClick event <br>
     * when d-click on sheet, return the selected row's code to main window and close it
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.26
     */
    function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
        returnSelectCode(sheetObj);
        return false;
    }
    /**
     * Returning selected row's code to main page<br>
     * <br><b>Example :</b>
     * <pre>
     *     returnSelectCode(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.05.26
     */
    function returnSelectCode (sheetObj) {
    	//2014.09.15
    	var rtnValue = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vsl_slan_cd");
    	ComPopUpReturnValue(rtnValue);
    }
