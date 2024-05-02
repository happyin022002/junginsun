/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0096.js
*@FileTitle  : S/C Copy Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // global variables
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
        /** **************************************************** */
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_Ok":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "blpl_chk_frm":
                    if (formObj.blpl_chk_frm.checked) {
                        sheetObject1.SetCellValue(1,"blpl_chk",1);
                    } else {
                        sheetObject1.SetCellValue(1,"blpl_chk",0);
                    }
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
            case "sheet1":
                with (sheetObj) {
	                var HeadTitle="|||Boiler Plate|Affiliate|Legacy IF Flag";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		                       {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		                       {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"blpl_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"afil_chk" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prc_prop_cre_tp_cd" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetWaitImageVisible(0);
	                SetVisible(false);
                }
                break;
            case "sheet2":
                with (sheetObj) {
	                var HeadTitle="|SEQ|prop_no|amdt_seq|prc_prop_cre_tp_cd|SVC\nScope|SVC\nScope|Origin|Destination|Group\nLocation|Group\nCommodity|Origin\nArbitrary|Destination\nArbitrary|General\nRate|Special\nRate|Special\nNote|Loading\nAgent|GOH";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",  Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prop_cre_tp_cd" },
		                       {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"scp_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"orgn_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loca_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"aror_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"arde_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"grate_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"srate_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"spnt_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"load_chk" },
		                       {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"goh_chk" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetWaitImageVisible(0);
	                SetSheetHeight(120);
                }
                break;
        }
    }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // retrieve
            	ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var sXml=sheetObj.GetSearchData("ESM_PRI_0096GS.do" , FormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                for (var i=0 , n=arrXml.length; i < n; i++) {
                    sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
                }
                ComOpenWait(false);
                break;
            case IBSAVE: // save
                ComOpenWait(true);
                if (!validateForm (sheetObjects[1], formObj, sAction)) {
                    return;
                }
                if (!ComShowCodeConfirm('PRI00012')) {
                	return;
                }
                for (var i=1, n=sheetObjects[0].RowCount(); i <= n; i++) {
                	if (sheetObjects[0].GetCellValue(i, "blpl_chk") == 1 || sheetObjects[0].GetCellValue(i, "afil_chk") == 1) {
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
                var sXml=sheetObjects[1].GetSaveData("ESM_PRI_0096GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                ComOpenWait(false);
                break;
        }
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            var formObj=document.form;
            if (sheetObj.SearchRows()== 1) {
            	formObj.blpl_chk_frm.checked=(sheetObj.GetCellValue(1, "blpl_chk")==1);
            	formObj.afil_chk_frm.checked=(sheetObj.GetCellValue(1, "afil_chk")==1);
            	formObj.blpl_chk_frm.disabled=(sheetObj.GetCellValue(1, "blpl_chk")==0);
            	formObj.afil_chk_frm.disabled=(sheetObj.GetCellValue(1, "afil_chk")==0);
            }
        }
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */
    function sheet2_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            for (var i=1, n=sheetObj.RowCount(); i <= n; i++) {
            	sheetObj.SetCellValue(i, "prc_prop_cre_tp_cd",sheetObjects[0].GetCellValue(1, "prc_prop_cre_tp_cd"),0);
                for (var j=sheetObj.SaveNameCol("scp_chk"), k=sheetObj.LastCol(); j <= k ; j++) {
                	if (sheetObj.GetCellValue(i, j) != 1) {
                        sheetObj.SetCellEditable(i, j,0);
                    }
                }
            }
        }
    }
    /**
     * calling function when occurring OnChange Event <br>
     */
    function sheet2_OnChange (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch (colname) {
            case "scp_chk":
//                var chk = sheetObj.CellValue(Row, "scp_chk");
                for (i=7; i <= 18; i++) {
                    if (sheetObj.GetCellEditable(Row, i)) {
                        sheetObj.SetCellValue(Row, i,Value,0);
                    }
                }
                break;
            case "grate_chk":
                if (Value == 1) {
                    if (sheetObj.GetCellEditable(Row, "orgn_chk")) {
                        sheetObj.SetCellValue(Row, "orgn_chk",1,0);
                    }
                    if (sheetObj.GetCellEditable(Row, "dest_chk")) {
                        sheetObj.SetCellValue(Row, "dest_chk",1,0);
                    }
                    if (sheetObj.GetCellEditable(Row, "loca_chk")) {
                        sheetObj.SetCellValue(Row, "loca_chk",1,0);
                    }
                    if (sheetObj.GetCellEditable(Row, "cmdt_chk")) {
                        sheetObj.SetCellValue(Row, "cmdt_chk",1,0);
                    }
                }
                break;
            case "srate_chk":
                if (Value == 1) {
                    if (sheetObj.GetCellEditable(Row, "orgn_chk")) {
                        sheetObj.SetCellValue(Row, "orgn_chk",1,0);
                    }
                    if (sheetObj.GetCellEditable(Row, "dest_chk")) {
                        sheetObj.SetCellValue(Row, "dest_chk",1,0);
                    }
                    if (sheetObj.GetCellEditable(Row, "loca_chk")) {
                        sheetObj.SetCellValue(Row, "loca_chk",1,0);
                    }
                    if (sheetObj.GetCellEditable(Row, "cmdt_chk")) {
                        sheetObj.SetCellValue(Row, "cmdt_chk",1,0);
                    }
                }
                break;
            case "loca_chk":
                if (Value == 0) {
                    sheetObj.SetCellValue(Row, "grate_chk",0,0);
                    sheetObj.SetCellValue(Row, "srate_chk",0,0);
                }
                break;
            case "cmdt_chk":
                if (Value == 0) {
                    sheetObj.SetCellValue(Row, "grate_chk",0,0);
                    sheetObj.SetCellValue(Row, "srate_chk",0,0);
                }
                break;
        }// end switch
        if (Value == 1) {
            sheetObj.SetCellValue(Row, "scp_chk",1,0);
        } else {
            var b=true;
            for (i=7; i <= 18; i++) {
            	if (sheetObj.GetCellValue(Row, i) == 1) {
                    b=false;
                }
            }
            if (b) {
                sheetObj.SetCellValue(Row, "scp_chk",0,0);
            }
        }
    }
    /**
     * checking validation process of inputed form data <br>
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
     * calling function when occurring OnSaveEnd event  <br>
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            var newPropNo=sheetObj.GetEtcData("newPropNo");
            ComPopUpReturnValue(newPropNo);
        }
    }
