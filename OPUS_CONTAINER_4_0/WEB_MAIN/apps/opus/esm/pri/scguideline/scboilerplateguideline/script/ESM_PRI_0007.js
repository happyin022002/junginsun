/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0007.jsp
*@FileTitle  :  Boiler Plate Guideline
*@author     : CLT
*@version    : 1.0
*@since      : 2014/5/9
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
     * @extends
     * @class Standard Note Creation : Business Script for ESM_PRI_0007 
     */
   
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var trMode="R";
    var prevDtIdx=-1;
    var errMsg="";
    // Save Current Event
    var eventStatus="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
    		
            switch(srcName) {
                case "btn_rowadd":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;
                case "btn_rowadd2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;
                case "btn_rowcopy":
                    doActionIBSheet(sheetObjects[1],formObject,IBCOPYROW);
                    break;
                case "btn_rowcopy2":
                    doActionIBSheet(sheetObjects[2],formObject,IBCOPYROW);
                    break;
                case "btn_rowdelete":
                    doActionIBSheet(sheetObject2, formObject, IBDELETE);
                    break;
                case "btn_rowdelete2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                    break;
                case "btn_new":
                	if( $('input:text[name="blpl_ref_yr"]').val() == '') {
                		return;
                	}   
                    removeAll(document.form);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;
                case "btn_confirm":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                    break;
                case "btn_confirmcancel":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
                    break;
                case "btn_delete":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
                    break;
                case "btn_copy":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
                    break;
                case "btns_calendar": //Calendar Button
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
                    break;
                case "btn_downexcel":
            		doActionIBSheet(sheetObjects[3], formObject, IBDOWNEXCEL);
                    break;
            } // end switch
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
     * @version 2009.04.17
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
     * @version 2009.04.17
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        var formObj=document.form;
        formObj.blpl_ref_yr.focus();
        toggleButtons("INIT");
//      setConfirmButton();
    }
//    /**
//     * Process Onactivate event. <br>
//     * <br><b>Example :</b>
//     * <pre>
//     *     obj_activate()
//     * </pre>
//     * @param  void
//     * @return void
//     * @author 
//     * @version 2009.04.17
//     */
//    function obj_activate() {
//        ComClearSeparator (ComGetEvent());
//    }
//    /**
//     * Process OnDeactivate event. <br>
//     * <br><b>Example :</b>
//     * <pre>
//     *     obj_deactivate()
//     * </pre>
//     * @param  void
//     * @return void
//     * @author 
//     * @version 2009.04.17
//     */
//    function obj_deactivate() {
//        ComChkObjValid(ComGetEvent());
//    }
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
     * @version 2009.04.17
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet0":      //hidden
                with (sheetObj) {
                    // setting Host information[mandatory][HostIp, Port, PagePath]
//                    if (location.hostname != ""){
//                    	
//                    }
                }
                break;
            case "sheet1":      // sheet1 init
                with(sheetObj){
		                
//		              (8, 0, 0, true);
		              var HeadTitle="|Sel.|Del Check|Seq.|Title|blpl_hdr_seq|blpl_seq|dp_seq";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                     {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColHidden("del_chk",1);
		              SetSheetHeight(200);
              }
                break;
            case "sheet2":      // sheet2 init
                with(sheetObj){
		                
		              var HeadTitle="|Sel.|Del Check|Seq.|Contents|blpl_hdr_seq|blpl_seq|blpl_ctnt_seq|dp_seq";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                     {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0, Width:800,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3000 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColHidden("del_chk",1);
		              SetAutoRowHeight(0);
		              SetSheetHeight(220);
        	}
                break;
            case "sheet3":      // sheet3 init
	                  with(sheetObj){
  		              var HeadTitle="|Seq.|Title|Contents";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",  KeyField:1,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0, Width:800,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",    KeyField:1,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetAutoRowHeight(0);
		              SetVisible(false);
              }
                break;
        }
    }
    /**
     * Execute before click the check button on sheet. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} Row
     * @param {String} Col
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
        }
    }
    /**
     * Execute before click the check button on sheet. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} Row
     * @param {String} Col
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
        }
    }
    /**
     * Execute on saveEnd event triggered. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} ErrMsg
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet0_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {
        errMsg=ErrMsg;
        //ComPriSaveCompleted();
        //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        //}
    }
    /**
     * Execute on saveEnd event triggered. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} ErrMsg
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	sheetObj.ColumnSort();
        //if (ErrMsg != "") {
        errMsg=ErrMsg;
        //ComPriSaveCompleted();
        //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        //}
    }
    /**
     * Execute on saveEnd event triggered. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} ErrMsg
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
    	sheetObj.ColumnSort();
        if (ErrMsg != "") {
            //ComPriSaveCompleted();
            errMsg=ErrMsg;
        }
    }
    /**
     * Execute when cell on sheet clicked. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow
     * @param {int} OldCol
     * @param {int} NewRow
     * @param {int} NewCol
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange(OldRow, NewRow, OldCol, NewCol);
    }
    var isFiredNested=false;
    var supressConfirm=false;
    /**
     * It calls when OnSelectCell event triggered on sheet1. <br>
     * when you had modified data and tried to move focus to other cells, it shows save-notice message <br>
     * When you don't save yet, Move the focus to modified Cell by forced.<br>
     *
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow
     * @param {int} OldCol
     * @param {int} NewRow
     * @param {int} NewCol
     * @param {String} sAction
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;        
        var adjNewRow=NewRow;
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[1].IsDataModified()) {
                isFiredNested=true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                if (validateForm(sheetObjects[1],document.form,IBSAVE)) {
                    if (sAction != IBINSERT && sAction != IBCOPYROW) {
                        isFiredNested=true;
                        sheetObjects[1].SelectCell(NewRow, NewCol, false);
                        isFiredNested=false;
                    }
                } else {
                    isFiredNested=true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (sheetObjects[2].IsDataModified()) {
                isFiredNested=true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows());
                    var rslt=doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                    if (sAction != IBINSERT && sAction != IBCOPYROW) {
                        isFiredNested=true;
                        sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
                        isFiredNested=false;
                    }
                } else {
                    isFiredNested=true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (sAction == IBINSERT) {
                isFiredNested=true;
                var idx=sheetObjects[1].DataInsert();
                isFiredNested=false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested=true;
                var idx=sheetObjects[1].DataCopy();
                isFiredNested=false;
                return idx;
            } else {
            	formObj.blpl_seq.value=sheetObjects[1].GetCellValue(NewRow, "blpl_seq");
                if(formObj.blpl_seq.value == "undefined" || ComIsEmpty(formObj.blpl_seq.value)) {
                			formObj.blpl_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"blpl_seq");
                }
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
            }
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
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBCLEAR:
                removeAll();
                break;
            case IBCREATE: //  When Year selected, retrieve Duration
                /*formObj.f_cmd.value=SEARCH01;
                //var sXml = sheetObj.GetSearchXml("ESM_PRI_0007GS.do", FormQueryString(formObj));
                //ComPriXml2ComboItem(sXml, formObj.eff_dt, "eff_dt", "eff_dt|exp_dt");
                // since Duration of each years are the one, Retrieve together.
                var arrData=ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg|eff_dt|exp_dt");
                if (arrData != null && arrData.length > 0) {
                    formObj.blpl_hdr_seq.value=arrData[0][0];
                    formObj.cfm_flg.value=arrData[0][1];
//alert("formObj.blpl_hdr_seq.value " + FormQueryString(formObj))
                    formObj.exp_dt.value=arrData[0][2];
                    formObj.exp_dt.value=arrData[0][3];
                    if(formObj.cfm_flg.value == "") {
                        formObj.cfm_flg.value="N";
                    }
                }*/
                break;
            case IBSEARCH:      //Retrieving
                try {
                    for (var i=0; i < sheetObjects.length; i++) {
                        sheetObjects[i].SetWaitImageVisible(0);
                    }
                    ComOpenWait(true);
                    if ( sheetObj.id == "sheet0") {
                        if (validateForm(sheetObj,document.form,sAction)) {
                            removeSearchCondition(formObj);
                            formObj.f_cmd.value=SEARCH01;
                            var sXml=sheetObj.GetSearchData("ESM_PRI_0007GS.do", FormQueryString(formObj));
//                            var sXml = sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj) );
                            var arrData=ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg|eff_dt|exp_dt");
                            if (arrData != null && arrData.length > 0) {
                                formObj.blpl_hdr_seq.value=arrData[0][0];
                                formObj.cfm_flg.value=arrData[0][1];
                                formObj.eff_dt.value=arrData[0][2];
                                formObj.exp_dt.value=arrData[0][3];
                                formObj.eff_dt_hidden.value=arrData[0][2];
                                formObj.exp_dt_hidden.value=arrData[0][3];
                                setConfirmButton();
                            }
                        }
                    }
                    else if ( sheetObj.id == "sheet1") {
                        if (validateForm(sheetObj,document.form,sAction)) {
                            for (var i=0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }
                            formObj.f_cmd.value=SEARCH02;
                            sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj) );
                            formObj.eff_dt.value=formObj.eff_dt_hidden.value;
                            formObj.exp_dt.value=formObj.exp_dt_hidden.value;
                            setConfirmButton();
                        }
                    }
                    else if ( sheetObj.id == "sheet2") {
                        if (validateForm(sheetObj,document.form,sAction)) {
                            formObj.f_cmd.value=SEARCH03;
                            sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj) );
                            setConfirmButton();
                        }
                    }
                    ComOpenWait(false);
                } catch (e) {
                    if (e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e);
                    }
                } finally {
                    ComOpenWait(false);
                }
                break;
            case IBSAVE:        
                // When Save clicked after Copying
                if(eventStatus == "IBCOPY") {
                    if (!validateForm(sheetObj,document.form,IBSEARCH_ASYNC04)) return;
                    if (ComShowCodeConfirm('PRI00012')) {
                        formObj.f_cmd.value=MULTI05;
                        var sParam=FormQueryString(formObj);
                        var sParamSheet1=sheetObjects[1].GetSaveString();
                        if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
                            return;
                        }
                        sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                        var sParamSheet2=sheetObjects[2].GetSaveString();
                        if (sheetObjects[2].IsDataModified()&& sParamSheet2 == "") {
                            return;
                        }
                        sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                        try {
                            ComOpenWait(true);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0007GS.do", sParam);
                            //sheetObjects[0].LoadSaveXml(sXml);
                            sheetObjects[2].LoadSaveData(sXml);
                            sheetObjects[1].LoadSaveData(sXml);
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                        if(errMsg != "") {
                            errMsg="";
                        }
                        else {
                            ComPriSaveCompleted();
                            formObj.blpl_hdr_seq.value="";
                            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                        }
                        eventStatus="";
                        setConfirmButton();
                    }
                } else {
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    eventStatus="IBSAVE";
                    formObj.f_cmd.value=MULTI01;
                    var sParam=FormQueryString(formObj);
                    var sParamSheet1=sheetObjects[1].GetSaveString();
                    if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
                        return;
                    }
                    //DP_SEQ SETTING
                    setDpSeq(sheetObjects[1]);
                    setDpSeq(sheetObjects[2]);
                    sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                    var sParamSheet2=sheetObjects[2].GetSaveString();
                    if (sheetObjects[2].IsDataModified()&& sParamSheet2 == "") {
                        return;
                    }
                    sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                    if (!supressConfirm && !ComPriConfirmSave()) {
                        return false;
                    }
                    try {
                        ComOpenWait(true);
                        var sXml=sheetObj.GetSaveData("ESM_PRI_0007GS.do", sParam);
                        //sheetObjects[0].LoadSaveXml(sXml);
                        sheetObjects[2].LoadSaveData(sXml);
                        sheetObjects[1].LoadSaveData(sXml);
                        ComOpenWait(false);
                    } catch (e) {
                        if (e == "[object Error]") {
                            ComShowMessage(OBJECT_ERROR);
                        } else {
                            ComShowMessage(e);
                        }
                    } finally {
                        ComOpenWait(false);
                    }
                    if (sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
                        return false;
                    } else {
                        if(errMsg != "") {
                            errMsg="";
                        }
                        else {
                            ComPriSaveCompleted();
                            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//                          doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                            if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                                doRowChange(sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectRow()+ 1, sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol());
//                              formObj.blpl_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "blpl_seq");
//                              doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                            }
                        }
                        return true;
                    }
                    eventStatus="";
                    setConfirmButton();
                }
                break;
            case IBSEARCH_ASYNC01:        // Confirm
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (ComPriConfirmConfirm()) {
                        try {
                            ComOpenWait(true);
                            formObj.f_cmd.value=MULTI02;
                            //formObj.cfm_flg.value = "Yes";
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0007GS.do", sParam);
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                        if(errMsg != "") {
                            errMsg="";
                        }
                        else ComPriConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                        setConfirmButton();
                    }
                }
                break;
            case IBSEARCH_ASYNC02:        // Confirm CANCEL
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (ComPriConfirmCancelConfirm()) {
                        try {
                            ComOpenWait(true);
                            formObj.f_cmd.value=MULTI03;
                            //formObj.cfm_flg.value = "No";
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0007GS.do", sParam);
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                        if(errMsg != "") {
                            errMsg="";
                        }
                        else ComPriCancelConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                        setConfirmButton();
                    }
                }
                break;
            case IBSEARCH_ASYNC03:        //ALL DELETE
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (ComPriConfirmDeleteAll()) {
                        try {
                            ComOpenWait(true);
                            formObj.f_cmd.value=MULTI04;
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0007GS.do", sParam);
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                        if(errMsg != "") {
                            errMsg="";
                        }
                        else {
                            ComPriDeleteCompleted();
                            removeAll(formObj);
                        }
                    }
                }
                break;
            case IBCOPYROW: // Row Copy
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow,
//                      sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, "3");
//                      var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
//                      if (idx < 0) {
//                      return false;
//                      }
                        var idx=doRowChange(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, IBCOPYROW);
                        if (idx < 0) {
                            return false;
                        }
                        sheetObj.SetCellValue(idx, "blpl_hdr_seq",formObj.blpl_hdr_seq.value);
                        sheetObj.SetCellValue(idx, "blpl_seq",parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1);
                        sheetObjects[2].RemoveAll();
                    }
                    else if (sheetObj.id == "sheet2") {
                        var idx=sheetObj.DataCopy();
                        sheetObj.SetCellValue(idx, "blpl_hdr_seq",formObj.blpl_hdr_seq.value);
                        var blpl_seq=sheetObjects[2].GetCellValue(sheetObjects[1].GetSelectRow(), "blpl_seq");
                        sheetObj.SetCellValue(idx, "blpl_seq",blpl_seq);
                        sheetObj.SetCellValue(idx, "blpl_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "blpl_ctnt_seq")) + 1);
                    }
                }
                break;
            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow,
//                      sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, "2");
                        var idx=doRowChange(sheetObj.GetSelectRow(), sheetObj.GetSelectRow()+ 1, sheetObj.GetSelectCol(), sheetObj.GetSelectCol, IBINSERT);
                        if (idx < 0) {
                            return false;
                        }
//                      var idx = doRowChange(sheetObj, sheetObjects[2], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
//                      if (idx < 0) {
//                      return false;
//                      }
//                      var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
//                      if (idx < 0) {
//                      return false;
//                      }
                        sheetObj.SetCellValue(idx, "blpl_hdr_seq",formObj.blpl_hdr_seq.value);
                        sheetObj.SetCellValue(idx, "blpl_seq",parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1);
                        sheetObjects[2].RemoveAll();
                        sheetObj.SelectCell(idx, "blpl_tit_nm");
                    }
                    else if (sheetObj.id == "sheet2") {
                        var idx=sheetObj.DataInsert();
                        sheetObj.SetCellValue(idx, "blpl_hdr_seq",formObj.blpl_hdr_seq.value);
                        sheetObj.SetCellValue(idx, "blpl_seq",parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1);
                        var blpl_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "blpl_seq");
                        sheetObj.SetCellValue(idx, "blpl_seq",blpl_seq);
                        sheetObj.SetCellValue(idx, "blpl_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "blpl_ctnt_seq")) + 1);
                        sheetObj.SelectCell(idx, "blpl_ctnt");
                    }
                }
                break;
            case IBDELETE: // Delete
//              deleteRowCheck(sheetObj, "chk");
//              if (sheetObj.id == "sheet1") {
//              deleteRowCheck(sheetObjects[2], "chk");
//              }
//              break;
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (sheetObj.CheckedRows("chk") <= 0) {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
                }
//              var delCnt = deleteRowCheck(sheetObj, "chk");
//              if (delCnt > 0 && sheetObj.id == "sheet1") {
//              for (var i = sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount() > 0 && i <= sheetObjects[2].LastRow(); i++) {
//              sheetObjects[2].CellValue(i, "chk") = "1";
//              }
//              deleteRowCheck(sheetObjects[2], "chk");
//              }
                if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
                    sheetObjects[2].RemoveAll();
                }
                /*Please Check*/
                var delCnt = deleteRowCheck(sheetObj, "chk");
                if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "D") {
                    sheetObjects[2].RemoveAll();
                }
                /*End Please Check*/
                /*Please Check*/                
//                var delCnt=deleteRowCheck(sheetObj, "chk");
//                if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
//                    sheetObjects[2].RemoveAll();
//                }
                /*End Please Check*/
                break;
            case IBSEARCH_ASYNC04:        //COPY
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC04)) {
                    //alert("eoeoeoeo")
                    removeCopy(document.form);
                    eventStatus="IBCOPY";
                    toggleButtons(eventStatus);
                }
                break;
            case IBDOWNEXCEL:
                ComOpenWait(true);
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCH04;
                sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj) );
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
     * @return bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
            case IBCREATE: // When Service Scope selected
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                return true;
                break;
            case IBDOWNEXCEL: // Down Excel
            case IBSEARCH: // retrieving
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
                    ComShowCodeMessage('PRI00311');
                    document.form.blpl_ref_yr.value="";
                    return false;
                }
                if(document.form.blpl_ref_yr.value.length < 4) {
                    ComPriInputValueFailed("input","year 4 digit",formObj.blpl_ref_yr);
                    return false;
                }
                return true;
                break;
            case IBSAVE: // Saving
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
                    ComShowCodeMessage('PRI00311');
                    document.form.blpl_ref_yr.value="";
                    return false;
                }
                if(document.form.blpl_ref_yr.value.length < 4) {
                    ComPriInputValueFailed("input","year 4 digit",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.eff_dt.value > formObj.exp_dt.value) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }
                var blpl_ref_yr=formObj.blpl_ref_yr.value;
                if (blpl_ref_yr != formObj.eff_dt.value.substr(0,4) && blpl_ref_yr != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00324');
                    formObj.eff_dt.focus();
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                // Check Modification
                if ((formObj.eff_dt.value == formObj.eff_dt_hidden.value && formObj.exp_dt.value == formObj.exp_dt_hidden.value)
                        && !sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                if (sheetObjects[1].IsDataModified()) {
                    var rowM=sheetObjects[1].ColValueDup("blpl_hdr_seq|blpl_seq",false);
                    if (rowM >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet1", rowM);
                        return false;
                    }
                }
                if (sheetObjects[2].IsDataModified()) {
                    var rowD=sheetObjects[2].ColValueDup("blpl_hdr_seq|blpl_seq|blpl_ctnt_seq",false);
                    if (rowD >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet2", rowD);
                        return false;
                    }
                }
                //getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0
                // Check whether data saved at sheet1
                if (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                // Check whether data saved at sheet2 sheetObjects[1]
//              if (getValidRowCount(sheetObjects[1]) >= 1 && (getValidRowCount(sheetObjects[2]) <= 0 && sheetObjects[1].SelectRow <= 0)) {
////            chekRowStatus(sheetObjects[2])
//              ComShowCodeMessage("input", "Content");
//              doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
//              return false;
//              }
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("input", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }
                return true;
                break;
            case IBINSERT: // Row Add
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC01: //confirm
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (formObj.blpl_hdr_seq.value == "") {
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                // Check whether data saved at sheet1
                if (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("input", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }
                if (checkModified(formObj)) {
                    ComShowCodeMessage("PRI03009","");
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC02: //confirm cancel
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (formObj.blpl_hdr_seq.value == "") {
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.cfm_flg.value == "No") {
                    ComShowCodeMessage('PRI00106');
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC03: //all delete
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (formObj.blpl_hdr_seq.value == "") {
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                //2014.10.07 validation add
                if (!checkBoilerPlateGuidelineUse(formObj)) {
                	ComShowCodeMessage('PRI08007');
                    return false;
                }
                
                
                return true;
                break;
            case IBCOPYROW: // Row Copy
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;
            case IBDELETE: //row Delete
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","input",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","input",formObj.exp_dt);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC04: // COPY
                if (formObj.blpl_hdr_seq.value == "") {
                    ComShowCodeMessage('PRI08015');
                    return false;
                }
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
                    ComShowCodeMessage('PRI00311');
                    document.form.blpl_ref_yr.value="";
                    return false;
                }
                if(document.form.blpl_ref_yr.value.length < 4) {
                    ComPriInputValueFailed("input","year 4 digit",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.eff_dt.value > formObj.exp_dt.value) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }
                var blpl_ref_yr=formObj.blpl_ref_yr.value;
                if (blpl_ref_yr != formObj.eff_dt.value.substr(0,4) && blpl_ref_yr != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00324');
                    formObj.eff_dt.focus();
                    return false;
                }
        }
        return true;
    }
    
    /**
     * check to S/C(PRI_SP_MN Table) in use.<br>
     * @param {formObj} formObj
     * @return void
     * @author 
     * @version 2014.10.07
     */
    function checkBoilerPlateGuidelineUse(formObj) {
    	var result = true;
    	
    	formObj.f_cmd.value = COMMAND01;
        var sXml = sheetObjects[1].GetSearchData("ESM_PRI_0007GS.do", FormQueryString(formObj));

        var etcData = ComGetEtcData(sXml, "CNT");
        if (etcData != null && etcData != "") {
            if(parseInt(etcData) > 0) {
            	return false;
            }
        }
        
        return result;
    }
    
    /**
     * It calls whe OnKeyPress event triggered on Year.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchDuration
     * </pre>
     * @param {sheetObj} sheetObj
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function searchDuration() {
        if(ComIsEmpty(document.form.blpl_ref_yr)) return;
        if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
            ComShowCodeMessage('PRI00311');
            document.form.blpl_ref_yr.value="";
            return;
        }
        // Do not retreive, when the status is COPY.
        if (eventStatus == "IBCOPY") return;
        var length=document.form.blpl_ref_yr.value.length;
        if(length == 4) {
            if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
                removeSearchCondition(document.form);
                //headr
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                //title
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                document.form.eff_dt.focus();
            }
        }
    }
    /**
     * Return True when was modified<br>
     * <br><b>Example :</b>
     * <pre>
     *      checkModified(formObj)
     * </pre>
     * @return boolean <br>
     * @author 
     * @version 2009.06.10
     */
    function checkModified(formObj) {
        isModified=false;
        if (formObj.eff_dt.value != formObj.eff_dt_hidden.value
                || formObj.exp_dt.value != formObj.exp_dt_hidden.value
                || sheetObjects[1].IsDataModified()
                || sheetObjects[2].IsDataModified()) {
            isModified=true;
        }
        return isModified;
    }
    /**
     * Reset Whole objects in screen. <br>
     * Save in case of modified data.
     * <br><b>Example :</b>
     * <pre>
     *     removeAll(formObj)
     * </pre>
     * @param {formObj} formObj
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function removeAll(formObj) {
        if (checkModified(formObj)) {
            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm=true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm=false;
            } else {
                formObj.reset();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {
            formObj.reset();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
        formObj.blpl_ref_yr.focus();
        eventStatus="";
        toggleButtons("INIT");
    }
    /**
     * Reset the search condition. <br>
     * Save in case of modified data.
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {form} formObj
     * @param {String} gubun
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function removeSearchCondition(formObj) {
        if(eventStatus == "IBCOPY") return;
        // Reset the window, except years
        formObj.eff_dt.value="";
        formObj.exp_dt.value="";
        formObj.eff_dt_hidden.value="";
        formObj.exp_dt_hidden.value="";
        formObj.blpl_hdr_seq.value="";
        formObj.cfm_flg.value="";
        toggleButtons("INIT");
    }
    /**
     * when copy operation executed. After moving current search condition to hidden column, Reset search condition. <br>
     * <br><b>Example :</b>
     * <pre>
     *     removeCopy(formObj)
     * </pre>
     * @param {form} formObj
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function removeCopy(formObj) {
        if (eventStatus == "IBCOPY") {
            return false;
        }
        var blpl_hdr_seq_copy=formObj.blpl_hdr_seq.value;
//      sheetObjects[1].RemoveAll();
//      sheetObjects[2].RemoveAll();
        formObj.reset();
        formObj.blpl_hdr_seq_copy.value=blpl_hdr_seq_copy;
        formObj.blpl_hdr_seq.value=blpl_hdr_seq_copy;
        formObj.blpl_ref_yr.focus();
    }
    /**
     * Depend on status, Defines Button activate/deactivate.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function toggleButtons(mode) {
        switch (mode) {
            case "INIT":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_confirmcancel");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_copy");
                ComBtnEnable("btn_downexcel");
                ComBtnEnable("btn_rowadd");
                ComBtnEnable("btn_rowadd2");
                ComBtnEnable("btn_rowcopy");
                ComBtnEnable("btn_rowcopy2");
                ComBtnEnable("btn_rowdelete");
                ComBtnEnable("btn_rowdelete2");
                sheetControl(true);
                break;
            case "CONF_YES":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnDisable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnEnable("btn_confirmcancel");
                ComBtnDisable("btn_delete");
                ComBtnEnable("btn_copy");
                ComBtnEnable("btn_downexcel");
                ComBtnDisable("btn_rowadd");
                ComBtnDisable("btn_rowadd2");
                ComBtnDisable("btn_rowcopy");
                ComBtnDisable("btn_rowcopy2");
                ComBtnDisable("btn_rowdelete");
                ComBtnDisable("btn_rowdelete2");
                sheetControl(false);
                break;
            case "CONF_NO":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_confirm");
                ComBtnDisable("btn_confirmcancel");
                ComBtnEnable("btn_delete");
                ComBtnEnable("btn_copy");
                ComBtnEnable("btn_downexcel");
                ComBtnEnable("btn_rowadd");
                ComBtnEnable("btn_rowadd2");
                ComBtnEnable("btn_rowcopy");
                ComBtnEnable("btn_rowcopy2");
                ComBtnEnable("btn_rowdelete");
                ComBtnEnable("btn_rowdelete2");
                sheetControl(true);
                break;
            case "IBCOPY":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_confirmcancel");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_copy");
                ComBtnDisable("btn_rowadd");
                ComBtnDisable("btn_rowadd2");
                ComBtnDisable("btn_rowcopy");
                ComBtnDisable("btn_rowcopy2");
                ComBtnDisable("btn_rowdelete");
                ComBtnDisable("btn_rowdelete2");
                sheetControl(false);
                break;
        }
    }
    /**
     * Depend on IBSheet's Cell confirmed, decide Activate/Deactivate. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sheetControl(mode);
     * </pre>
     * @param   {boolean} flag Mandatory
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheetControl(flag) {
        var sheetObj1=sheetObjects[1];
        var sheetObj2=sheetObjects[2];
        for (var i=1; i <= sheetObj1.RowCount();i++) {
            sheetObj1.SetCellEditable(i, "chk",flag);
            sheetObj1.SetCellEditable(i, "blpl_tit_nm",flag);
        }
        for (var i=1; i <= sheetObj2.RowCount();i++) {
            sheetObj2.SetCellEditable(i, "chk",flag);
        }
    }
    /**
     * Depend on confirmation, Defines Button activate/deactivate.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setConfirmButton()
     * </pre>
     * @param {String} mode
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function setConfirmButton()  {
        var cfm_flg=document.form.cfm_flg.value;
        if(cfm_flg == "Yes") toggleButtons("CONF_YES");
        else if(cfm_flg == "No") toggleButtons("CONF_NO");
        else if(cfm_flg == "") toggleButtons("INIT");
    }
    /**
     * When sate the data, set the dp_seq <br>
     * <br><b>Example :</b>
     * <pre>
     *     setDpSeq(sheetObj)
     * </pre>
     * @param {sheetObj} sheetObj
     * @return void
     * @author 
     * @version 2009.06.10
     */
    function setDpSeq(sheetObj)  {
        if(!sheetObj.IsDataModified()) return;
        for(var i=1; i<=sheetObj.RowCount(); i++) {
            sheetObj.SetCellValue(i, "dp_seq",i,0);
            if(sheetObj.GetRowStatus(i) == "R") {
                sheetObj.SetRowStatus(i,"U");
            }
        }
    }
    /**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving
     * @return void
     * @author 
     * @version 2009.06.03
     */
    function sheet2_OnClick(sheetObj, Row, Col, Value) {
        var cfm_flg=document.form.cfm_flg.value;
        //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "blpl_ctnt":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,903,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,903,200);
                break;
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Execute Excel download after Sheet retrieve completely <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg selection
     * @returns void
     * @author 
     * @version 2010.04.23
     */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
    	if(sheetObjects[3].RowCount() < 1){
    		ComShowCodeMessage("COM132501");
    	}
    	else{
	        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
//	        	sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,URL:"apps/opus/esm/pri/scguideline/scboilerplateguideline/script/ESM_PRI_0007.xml"});
	        	sheetObj.Down2Excel({
	        		HiddenColumn: 1,
	        		SheetDesign: 1,
//	        		AutoSizeColumn : 1,
	        		ExcelFontSize : 10
	        	});
	        }
    	}
    }
