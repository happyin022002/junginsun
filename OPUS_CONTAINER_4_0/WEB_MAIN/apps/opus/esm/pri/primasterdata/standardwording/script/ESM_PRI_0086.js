/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0086.js
*@FileTitle  : Standard Wording for S/C Notes - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    // Common Global Variable
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
     * @return N/A
     * @author 
     * @version 2009.10.06
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
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
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.10.06
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
     * @return N/A
     * @author 
     * @version 2009.10.06
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * @version 2009.10.06
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
            		var HeadTitle="Seq.||Standard Wording";
            		var headCount=ComCountHeadTitle(HeadTitle);

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"stnd_wdg_seq" },
            		             {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"stnd_wdg_ctnt" } ];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetWaitImageVisible(0);
                    SetAutoRowHeight(0);
                    resizeSheet();//SetSheetHeight(565);
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
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @return N/A
     * @author 
     * @version 2009.10.06
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:    
                if(sheetObj.id == "sheet1"){
                	ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
                    sheetObj.DoSearch("ESM_PRI_0086GS.do", FormQueryString(formObj) );
                    ComOpenWait(false);
                }
                break;
        }
    }
    
    /**
     * Calling function in case of Onclick event <br>
     * Showing Memopad when clicking Desc Cell(MemoPad : Editable)<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.10.06
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        var formObj=document.form;
        var colname=sheetObj.ColSaveName(Col);
        switch (colname) {
            case "stnd_wdg_ctnt":
                ComShowMemoPad(sheetObj, Row, Col, true, 884);
            break;
        }
    }


	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}
    