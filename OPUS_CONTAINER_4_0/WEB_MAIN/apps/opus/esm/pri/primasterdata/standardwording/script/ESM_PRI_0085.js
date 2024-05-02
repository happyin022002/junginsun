/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0085.js
*@FileTitle  : Standard Wording for S/C Notes
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event
    document.onclick = processButtonClick;

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
                case "btn_RowAdd":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    break;
                case "btn_Retrieve":
                	sheetObject1.ColumnSort();
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
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
                ComShowMessage(e);
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
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            	with(sheetObj){
	            	var HeadTitle="|Sel.|Seq.||Standard Wording";
	
	            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	            	             {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"stnd_wdg_seq" },
	            	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"stnd_wdg_ctnt",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	 
	            	InitColumns(cols);
	
	            	SetWaitImageVisible(0);
	            	SetAutoRowHeight(0);
	            	resizeSheet(); //SetSheetHeight(535);
            	}
                break;
        }
    }
    
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
    
    
    function sheet1_OnSort(sheetObj ,Col, SortArrow){
    	  sheet1.ReNumberSeq();   
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
                sheetObj.DoSearch("ESM_PRI_0085GS.do", FormQueryString(formObj) );
                break;
            case IBSAVE:        //save
                ComOpenWait(true);
                if(!validateForm(sheetObj,formObj,sAction)) return;
                if (!ComPriConfirmSave())  return;
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_PRI_0085GS.do", FormQueryString(formObj),-1,false);
                break;
            case IBINSERT:      
                var Row=sheetObj.DataInsert();
                break;
            case IBDELETE:     
                deleteRowCheck(sheetObj, "sel_chk", true);
                break;
        }
    }
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    /**
     * calling function when occurring OnClick Event <br>
     * showing memopad when clicking desc cell (MemoPad editable)<br>
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        var formObj=document.form;
        var colname=sheetObj.ColSaveName(Col);
        switch (colname) {
            case "stnd_wdg_ctnt":
                ComShowMemoPad(sheetObj, Row, Col, false, 884);
                break;
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
    
    function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	sheetObj.ColumnSort();
    	ComOpenWait(false);
    }
