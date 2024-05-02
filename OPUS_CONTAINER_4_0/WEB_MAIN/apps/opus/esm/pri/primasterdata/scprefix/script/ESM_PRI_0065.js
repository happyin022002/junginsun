/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0065.js
*@FileTitle  : S/C Prefix & Scope Mapping Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    // global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
                case "btn_RowAdd":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
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
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
            		var HeadTitle="|Sel.|Seq.|SVC Scope|SVC Scope|Sub-continent|Sub-continent|S/C Prefix|S/C Prefix";
            		var headCount=ComCountHeadTitle(HeadTitle);

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    		Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"DummyCheck", 		Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            		             {Type:"Seq",      			Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
            		             {Type:"Combo", 		Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            		             {Type:"Text",      		Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"svc_scp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Combo", 		Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
            		             {Type:"Text",      		Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Combo", 		Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sc_pfx_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            		             {Type:"Text",      		Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"sc_pfx_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetColProperty("svc_scp_cd", {ComboText:svcScpComboText, ComboCode:svcScpComboValue} );
            		SetColProperty("sconti_cd", {ComboText:subContiComboText, ComboCode:subContiComboValue} );
            		SetColProperty("sc_pfx_cd", {ComboText:scPfxComboText, ComboCode:scPfxComboValue} );
            		SetWaitImageVisible(0);
                    InitComboNoMatchText(true);
                    resizeSheet();//SetSheetHeight(480);
            		SetComboOpenMode(1);
            	}
                break;
        }
    }
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
    
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
                sheetObj.DoSearch("ESM_PRI_0065GS.do", FormQueryString(formObj) );
                sheetObj.SetHeaderCheck(0,"chk",0);
                sheetObjects[0].RemoveAll();
                sheetObjects[0].ColumnSort("SVC Scope|SVC Scope|Sub-continent|Sub-continent|S/C Prefix|S/C Prefix", "ASC", "ASC|ASC", false);
                ComOpenWait(false);
                break;
            case IBSAVE:        //save
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                if (!ComPriConfirmSave()) {
                    return;
                }
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_PRI_0065GS.do", FormQueryString(formObj), -1, false);
                ComOpenWait(false);
                break;
            case IBINSERT:     
                var Row=sheetObj.DataInsert();
                sheetObj.SelectCell(Row, "svc_scp_cd");
                sheetObj.ReNumberSeq();
                break;
            case IBDELETE:      
                deleteRowCheck(sheetObj, "chk", true);
                break;
        }
    }
    
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction){
            case IBSAVE:
                var Row=sheetObj.ColValueDup("svc_scp_cd|sconti_cd");
                if(Row > -1){
                    ComShowCodeMessage('PRI00302');
                    sheetObj.SelectCell(Row, "svc_scp_cd");
                    return false;
                }
                break;
        }
        return true;
    }
    
    /**
     * calling function when occurring OnChange Event <br>
     * when selecting multi comboBox, showing description <br>
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "svc_scp_cd":
                getSheetMultiComboText(sheetObj, Row, "svc_scp_cd", "svc_scp_nm");
                break;
            case "sconti_cd":
                getSheetMultiComboText(sheetObj, Row, "sconti_cd", "sconti_nm");
                break;
            case "sc_pfx_cd":
                getSheetMultiComboText(sheetObj, Row, "sc_pfx_cd", "sc_pfx_desc");
                break;
        }
    }
    
    function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }

