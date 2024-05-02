/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2007.js
*@FileTitle  : RFA Proposal Creation [Request]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick () {
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch (srcName) {
                case "btn_AddTo":
                    var SRow=sheetObject1.GetSelectRow();
                    if (sheetObject1.GetCellValue(SRow, "type_flg") != 'U') {
                        return;
                    }
                    var usrId=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "usr_id");
                    if (-1 != sheetObject2.FindText("apro_rqst_ref_usr_id", usrId)
                            || -1 != sheetObject3.FindText("apro_rqst_ref_usr_id", usrId)) {
                        return;
                    }
                    doActionIBSheet(sheetObject2, formObj, IBINSERT);
                    break;
                case "btn_DeleteTo":
                    doActionIBSheet(sheetObject2, formObj, IBDELETE);
                    break;
                case "btn_AddCC":
                    var SRow=sheetObject1.GetSelectRow();
                    if (sheetObject1.GetCellValue(SRow, "type_flg") != 'U') {
                        return;
                    }
                    var usrId=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "usr_id");
                    if (-1 != sheetObject2.FindText("apro_rqst_ref_usr_id", usrId)
                            || -1 != sheetObject3.FindText("apro_rqst_ref_usr_id", usrId)) {
                        return;
                    }
                    doActionIBSheet(sheetObject3, formObj, IBINSERT);
                    break;
                case "btn_DeleteCC":
                    doActionIBSheet(sheetObject3, formObj, IBDELETE);
                    break;
                case "btn_Send":
                    doActionIBSheet(sheetObject2, formObj, IBSAVE);
                    break;
                case "btn_Search":
                    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    break;
                case "btn_close":
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
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject (sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage () {
        try {
            for (i=0; i < sheetObjects.length; i++) {
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            axon_event.addListenerForm('keydown', 'obj_keydown', document.form);
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
     * calling function when occurring keyDown event<br>
     */
    function obj_keydown () {
        var formObj=document.form;
        var eleName=event.srcElement.name;
        switch (eleName) {
            case "ofc_cd":
            case "usr_id":
            case "usr_nm":
                if (event.keyCode == 13) {
                    try {
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
                break;
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        switch (sheetNo) {
            case 1: //sheet1 init
                with(sheetObj){
                
		             var HeadTitle="ibflag||Organization|pnode_id|node_id|ofc_cd|usr_id|usr_nm|type_flg|auth_flg";
		             var headCount=ComCountHeadTitle(HeadTitle);
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1, ChildPage:10 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:10,   Align:"Left",    ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"node_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TreeCol:1 ,  LevelSaveName:"slevel" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"pnode_id" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"node_id" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"ofc_cd" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"usr_id" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"usr_nm" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"type_flg" },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"auth_flg" } ];
		              
		             InitColumns(cols);
		             resizeSheet(); //SetSheetHeight(260);
		             SetEditable(0);
		             SetWaitImageVisible(0);
		             //InitTreeInfo(2, "slevel", "#0000FFNAN");
             	}
                break;
            case 2: // sheet2 init
                with(sheetObj){
               
		             var HeadTitle="|prop_no|amdt_seq|rqst_tp_cd|rqst_ref_usr_seq|ofc_cd|User ID|To:";
		             var headCount=ComCountHeadTitle(HeadTitle);
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_tp_cd" },
		                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_usr_seq" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_usr_ofc_cd" },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_usr_id",      KeyField:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",  KeyField:0,   CalcLogic:"",   Format:"" } ];
		              
		             InitColumns(cols);
		             SetSheetHeight(125);
		             SetEditable(0);
		             SetWaitImageVisible(0);
                }
                break;
            case 3: // sheet3 init
                with(sheetObj){
                
		              var HeadTitle="|prop_no|amdt_seq|rqst_tp_cd|rqst_ref_usr_seq|ofc_cd|User ID|CC:";
		              var headCount=ComCountHeadTitle(HeadTitle);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_tp_cd" },
		                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_usr_seq" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_usr_ofc_cd" },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_ref_usr_id",      KeyField:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm", KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		              resizeSheet(); //SetSheetHeight(125);
		              SetEditable(0);
		              SetWaitImageVisible(0);
                }
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
        ComResizeSheet(sheetObjects[2]);
    }
    
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: //retrieve
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH;
                     sheetObj.DoSearch("ESM_PRI_2007GS.do", FormQueryString(formObj));
                }
                break;
            case IBSAVE: //save
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (!ComPriProcessYn("send")) {
                        return;
                    }
                    formObj.f_cmd.value=MULTI;
                    var sParam="";
                    var sParamSheet1=sheetObjects[1].GetSaveString();
                    var sParamSheet2=sheetObjects[2].GetSaveString();
                    if ((sheetObjects[1].IsDataModified()&& sParamSheet1 != "")
                            || (sheetObjects[2].IsDataModified()&& sParamSheet2 != "")) {
                        if (sheetObjects[1].IsDataModified()&& sParamSheet1 != "") {
                            sParam += "&" + sParamSheet1;
                        }
                        if (sheetObjects[2].IsDataModified()&& sParamSheet2 != "") {
                            sParam += "&" + sParamSheet2;
                        }
                    } else {
                        return;
                    }
                    sParam += "&" + FormQueryString(formObj);
                     var sXml=sheetObj.GetSaveData("ESM_PRI_2007GS.do", sParam);
                     sheetObjects[1].LoadSaveData(sXml);
                }
                ComOpenWait(false);
                break;
            case IBINSERT: 
                var newRow=sheetObj.DataInsert();
                sheetObj.SetCellValue(newRow, "prop_no",formObj.prop_no.value);
                sheetObj.SetCellValue(newRow, "amdt_seq",formObj.amdt_seq.value);
                sheetObj.SetCellValue(newRow, "apro_rqst_ref_tp_cd",(sheetObj.id == "sheet2") ? "T" : "C");
                sheetObj.SetCellValue(newRow, "apro_rqst_ref_usr_ofc_cd",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_cd"));
                sheetObj.SetCellValue(newRow, "apro_rqst_ref_usr_id",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"usr_id"));
                sheetObj.SetCellValue(newRow, "usr_nm",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "node_nm"));
                var seq=0;
                for ( var i = sheetObj.HeaderRows(), n = sheetObj.HeaderRows() + sheetObj.RowCount(); i < n; i++) {
                    sheetObj.SetCellValue(i, "apro_rqst_ref_usr_seq",++seq);
                }
                break;
            case IBDELETE: 
                sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
                var seq=0;
                for ( var i = sheetObj.HeaderRows(), n = sheetObj.HeaderRows() + sheetObj.RowCount(); i < n; i++) {
                    sheetObj.SetCellValue(i, "apro_rqst_ref_usr_seq",++seq);
                }
                break;
        }
    }
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm (sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSAVE:
                if (!sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
                    ComShowCodeMessage('PRI00301');
                    return false;
                }
                break;
        }
        return true;
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     * inputting icon in case of User Node after retrieving sheet<br>
     */
    function sheet1_OnSearchEnd (sheetObj, Code, ErrMsg) {
    	ComOpenWait(false)
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            var formObj=document.form;
            var indx=0;
            while (true) {
                indx=sheetObj.FindText("type_flg", "U", indx + 1);
                if (indx != -1) {
                     if (sheetObj.GetCellImage(indx, "node_nm") != "img/icon_tree_04.gif") {
                         sheetObj.SetCellImage(indx, "node_nm","img/icon_tree_04.gif");
                    }
                } else {
                    break;
                }
            }
            while (true) {
                indx=sheetObj.FindText("auth_flg", "Y", indx + 1);
                if (indx != -1) {
                     if (sheetObj.GetCellFontColor(indx, "node_nm") != "#0000FF")
                     {
                         sheetObj.SetCellFontColor(indx, "node_nm","#0000FF");
                     }
                } else {
                    break;
                }
            }
            if (formObj.usr_id.value != '') {
                indx=sheetObj.FindText("usr_id", formObj.usr_id.value);
                if (indx != -1) {
                    sheetObj.SelectCell(indx, "node_nm");
                }
            }
            if (formObj.ofc_cd.value != '') {
                indx=sheetObj.FindText("ofc_cd", formObj.ofc_cd.value);
                if (indx != -1) {
                    sheetObj.SelectCell(indx, "node_nm");
                }
            }
            if (formObj.usr_nm.value != '') {
                indx=sheetObj.FindText("usr_nm", formObj.usr_nm.value, 0, 2, false);
                if (indx != -1) {
                    sheetObj.SelectCell(indx, "node_nm");
                }
            }
           sheet1.SetRowExpanded(1,1);
        }
  }
    /**
     * calling function when occurring OnTreeChild event <br>
     * retrieving child data and expand tree when clicking tree's [+] button <br>
     */
    
    function sheet1_OnTreeChild (sheetObj, Row) {
    	var formObj=document.form;
        try {
        	ComOpenWait(true);
            sheetObj.DoSearchChild(Row, "ESM_PRI_2007GS.do", FormQueryString(formObj)+"&pnode_id=" + sheetObj.GetCellValue(Row,"node_id"));
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
     * calling function when occurring OnSaveEnd event  <br>
     * closing screen after saving sheet<br>
     */
    function sheet2_OnSaveEnd (sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            ComPopUpReturnValue("OK"); 
        }
    }
