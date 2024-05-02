/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0089.jsp
*@FileTitle  : Guideline Clause & Standard Wording List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
    // Common Global Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
//다음의 화면들에서 호출됨
//ESM_PRI_0091
//ESM_PRI_0097
//ESM_PRI_0003_10
    
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.19
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } // end switch
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
     * Returnning information of selected row to parent window<br>
     * <br><b>Example :</b>
     * <pre>
     *     returnSelectedData();
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.12.16
     */    
    function returnSelectedData(sheetObj, Row) {
        var retVal=new Object();
        if(sheetObj == null){
            ComShowCodeMessage('PRI00011');
            return;
        }else if(sheetObj.id == "sheet1"){
        	retVal.ctnt=sheetObj.GetCellValue(Row, "ctrt_cluz_ctnt");
        	if (sheetObj.GetCellValue(Row, "note_clss_cd") == 'S') {
        		retVal.chgcd=sheetObj.GetCellValue(Row, "chg_cd");
            }
        }else if(sheetObj.id == "sheet2"){
        	retVal.ctnt=sheetObj.GetCellValue(Row, "stnd_wdg_ctnt");
        }
        ComPopUpReturnValue(retVal);
    }
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.05.19
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
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.19
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
	   	if (!opener) opener = window.opener;
	   	if (!opener) opener = parent;
	   	
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.05.19
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                var HeadTitle="|Seq.|Item|Surcharge|Clause";
//                var headCount=ComCountHeadTitle(HeadTitle);
//                (headCount, 0, 0, true);
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                    {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetEditableColorDiff(0);
                SetColProperty("note_clss_cd", {ComboText:itemComboText, ComboCode:itemComboValue} );
                SetColHidden("chg_cd",1);
                SetSheetHeight(120);

                }
                break;
            case "sheet2":
                with (sheetObj) {
                var HeadTitle="|Seq.|Standard Wording";
//                var headCount=ComCountHeadTitle(HeadTitle);
//                (headCount, 0, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"stnd_wdg_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetEditableColorDiff(0);
                SetSheetHeight(122);

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
     * @version 2009.05.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var sXml=sheetObj.GetSearchData("ESM_PRI_0089GS.do" , FormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                if (arrXml.length > 1) {
                    sheetObjects[1].LoadSearchData(arrXml[1]);
                }
                if (arrXml.length > 0) {
                    sheetObjects[0].LoadSearchData(arrXml[0]);
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
     * @version 2009.05.19
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//             if (!isNumber(formObj.iPage)) {
//          return false;
//          }
        }
        return true;
    }
    /**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.05.19
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
       // highlightGetSelectRow(sheetObj, NewRow);
    }
    /**
     * Calling Function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.05.19
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
       // highlightGetSelectRow(sheetObj, NewRow);
    }
    /**
     * Calling function in case of OnDblClick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTMLtag(Object) Object
     * @param {int} Row Mandatory, ,Cell's Row Index
     * @param {int} Col Mandatory, ,Cell's Column Index
     * @param {string} Value Mandatory, ,Cell's Value
     * @returns N/A
     * @author 
     * @version 2009.12.16
     */
    function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
        returnSelectedData(sheetObj, Row);
        return false;
    }
    /**
     * Calling function in case of OnDblClick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTMLtag(Object) Object
     * @param {int} Row Mandatory, ,Cell's Row Index
     * @param {int} Col Mandatory, ,Cell's Column Index
     * @param {string} Value Mandatory, ,Cell's Value
     * @returns N/A
     * @author 
     * @version 2009.12.16
     */
    function sheet2_OnDblClick (sheetObj, Row, Col, Value) {
        returnSelectedData(sheetObj, Row);
        return false;
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Making Surcharge column disable if Item is not Surcharge
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2009.07.10
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        var formObj=document.form;
        if (formObj.note_clss_cd.value == 'S') {
            sheetObj.SetColHidden("chg_cd",0);
        } else {
            sheetObj.SetColHidden("chg_cd",1);
        }
    }
    var hcurSheet=null;  // selected sheet
    var hcurRow=0;       // selected row
    /**
     * Highlighting selected row <br>
     * Rollbacking origin color in case of selecting other sheet<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     *     highlightSelectRow(sheetObj, 1);
     * </pre>
     * 
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} row Mandatory ,selected Row Index
     * @return N/A
     * @author 
     * @version 2009.05.19
     */
    function highlightGetSelectRow(sheetObj, row){
        if(sheetObj == hcurSheet && row == hcurRow){
            return;
        }
        //no support[implemented common]CLT sheetObj.SetRowBackColor(row,sheetObj.SelectBackColor);
        if(hcurSheet != null && hcurRow != 0){
            hcurSheet.SetRowBackColor(hcurRow,"#000000");
        }
        hcurSheet=sheetObj;
        hcurRow=row;
    }
    
    function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }
    
    function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }

