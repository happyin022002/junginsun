/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2066.js
*@FileTitle  : Rate Creation - Excel Import(Horizontal)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
     * @class Commodity Group :business script for Commodity Group 
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var isOViaMandatory=false;
    var isDViaMandatory=false;
    var isDirCallVisible = false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     *     processButtonClick();
     * </pre>
     * 
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function processButtonClick() {
        var sheetObject1=sheetObjects[0];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
            case "btn_openfile":
//            	var strFilePath=sheetObject1.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
//                if (strFilePath != "<USER_CANCEL>") {
                	sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false,ColumnMapping:""});
//                }
                break;
            case "btn_check":
                doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
                break;
            case "btn_save":
                doActionIBSheet(sheetObject1, document.form, IBSAVE);
                break;
            case "btn_close":
            	ComClosePopup(); 
                break;
            case "btn_Template":
                downform.submit();
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
     * @version 2009.08.25
     */
    function setSheetObject(sheet_obj) {
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
     * @version 2009.08.25
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
        try {
            for (i=0; i < sheetObjects.length; i++) {
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            bIsReqUsr=document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
            bIsAproUsr=document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
            toggleButtons("INIT");
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
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
    * @version 2009.08.25
    */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch (sheetNo) {
        case 1: // sheet1 init
        
        	with(sheetObj){

	            var HeadTitle1="|CMDT\nSeq|Commodity Group|Commodity Group|Route\nSeq|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)";
	            var HeadTitle2="|CMDT\nSeq|Code|Description|Route\nSeq|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Dry 20'|Dry 40'|Dry 40'HC|Dry 45'|Reefer 40'HC";
	            var headCount=ComCountHeadTitle(HeadTitle2);

	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},
	                    { Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);

	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry20",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry40",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry40hc",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry45",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_rf40hc",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
	             
	            InitColumns(cols);
	        	SetColProperty("org_rcv_de_term_nm", {ComboText:termOrgComboText, ComboCode:termOrgComboValue} );
	        	SetColProperty("dest_rcv_de_term_nm", {ComboText:termDestComboText, ComboCode:termDestComboValue} );
	        	SetColProperty("org_prc_trsp_mod_nm", {ComboText:transMdComboText, ComboCode:transMdComboValue} );
	        	SetColProperty("dest_prc_trsp_mod_nm", {ComboText:transMdComboText, ComboCode:transMdComboValue} );

	        	SetColProperty(0 ,"prc_cmdt_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"org_rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"org_rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"dest_rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"dest_rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	        	
	            SetEditable(1);
	            SetWaitImageVisible(0);
	            SetShowButtonImage(2);
	            resizeSheet(); //SetSheetHeight(440);

	            }
	            break;

        case 2:  // hidden 
        	with(sheetObj){

			var HeadTitle="status";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetVisible(0);
        	}
			break;

        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
    /**
     * Calling funciton of OnKeyUp event<br>
     * when error exists, tab key press, focus move to the Cell error happened.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
     * @param {int} Col Mandatory Cell's Column Index
     * @param {int} KeyCode Mandatory Ascii code of Keyboard
     * @param {int} Shift Mandatory Shift key pressed : 1, Ctrl key pressed : 2, ETC : 0
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (!isClear && KeyCode == 9) {
            while (true) {
                Col++;
                if (Col > sheetObj.LastCol()) {
                    Row++;
                    Col=1;
                }
                if (Row > sheetObj.LastRow()) {
                    Row=sheetObj.HeaderRows();
                }
                if (sheetObj.GetCellBackColor(Row, Col) == "FF0000") {
                    sheetObj.SelectCell(Row, Col, false);
                    break;
                }
            }
        }
    }
    /**
     * Calling Function in case of OnChange event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int}Row Index
     * @param {int}Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        if (colName == "prc_cmdt_def_cd") {
            if (Value.length == 6) {
                formObj.f_cmd.value=SEARCH08;
                var param="&cd=" + Value;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
                    sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
                    return false;
                }
            } else if (Value.length == 4) {
                formObj.f_cmd.value=COMMAND29;
                var param="&cd=" + Value;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
                    sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
                    return false;
                }
            } else if (Value.length == 5) {
                formObj.f_cmd.value=SEARCH10;
                var param="&cd=" + Value + "&nm=rg" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
                    sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
                    sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
                    return false;
                }
            } else {
                sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
                sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
                sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
                return false;
            }
        } else if (colName == "org_rout_pnt_loc_def_cd") {
            if (Value.length == 5) {
                formObj.f_cmd.value=SEARCH05;
                var param="&cd=" + Value + "&nm=rg&etc4=O";
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_nm","",0);
                    sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_cd","",0);
                    sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else if (Value.length == 4) {
                formObj.f_cmd.value=SEARCH11;
                var param="&cd=" + Value + "&nm=rg" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value + "&etc3=O";
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_nm","",0);
                    sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_cd","",0);
                    sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else {
                sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_nm","",0);
                sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_cd","",0);
                sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
                return false;
            }
        } else if (colName == "dest_rout_pnt_loc_def_cd") {
            if (Value.length == 5) {
                formObj.f_cmd.value=SEARCH05;
                var param="&cd=" + Value + "&nm=rg&etc4=D";
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_nm","",0);
                    sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_cd","",0);
                    sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else if (Value.length == 4) {
                formObj.f_cmd.value=SEARCH11;
                var param="&cd=" + Value + "&nm=rg" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value + "&etc3=D";
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_nm","",0);
                    sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_cd","",0);
                    sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else {
                sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_nm","",0);
                sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_cd","",0);
                sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
                return false;
            }
        }
    }
    
    function tmp_object(sheet, row, col){
		this.sheet = sheet;
		this.row = row;
		this.col = col;
	}
	var G_TMP_OBJECT;
	
    /**
     * Calling function in case of OnDblClick event <br>
     * Open popup proper to selected item. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @returns void
     * @author 
     * @version 2009.08.25
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        G_TMP_OBJECT = new tmp_object(sheetObj, Row, Col);
        formObj.f_cmd.value=-1;   // FormCommand Initialize
        if (colName == "prc_cmdt_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_4027.do?" + FormQueryString(document.form);
            sUrl += "&grp_cd=" + PRI_RP_SCP + "&commodity_cmd=CRG&prc_cmdt_tp_cd=C";
            sUrl += "&prc_cmdt_def_nm=" + sheetObj.GetCellValue(Row, Col);
            ComOpenPopup(sUrl, 700, 345, "ESM_PRI_4027", "1,0", true);
            
        } else if (colName == "org_rout_pnt_loc_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=O";
            sUrl += "&loc_def_nm=" + sheetObj.GetCellValue(Row, Col);
            ComOpenPopup(sUrl, 700, 310, "ESM_PRI_4026_1", "1,0", true);
            
        } else if (colName == "dest_rout_pnt_loc_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=D";
            sUrl += "&loc_def_nm=" + sheetObj.GetCellValue(Row, Col);
            sUrl += "&func=ESM_PRI_4026_2";
            ComOpenPopup(sUrl, 700, 310, "ESM_PRI_4026_2", "1,0", true);
        }
    }
    
    function ESM_PRI_4027(rtnVal) {
    	if (rtnVal != null){
    		G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "prc_cmdt_def_cd",rtnVal.cd,0);
    		G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "prc_cmdt_def_nm",rtnVal.nm,0);
        }
    }
    
    function ESM_PRI_4026_1(rtnVal) {
    	if (rtnVal != null){
    		G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "org_rout_pnt_loc_def_cd",rtnVal.cd,0);
    		G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "org_rout_pnt_loc_def_nm",rtnVal.nm,0);
        }
    }

	function ESM_PRI_4026_2(rtnVal) {
		 if (rtnVal != null){
			 G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "dest_rout_pnt_loc_def_cd",rtnVal.cd,0);
			 G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "dest_rout_pnt_loc_def_nm",rtnVal.nm,0);
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
     * @version 2009.08.25
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 
                var sXml="";
                isOViaMandatory=false;
                isDViaMandatory=false;
                formObj.f_cmd.value=COMMAND17;
                sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
                var arrTemp=ComPriXml2Array(sXml, "cd|nm");
                if (arrTemp != null && arrTemp.length > 0) {
                    for (var i=0; i < arrTemp.length; i++) {
                        var pptCd=arrTemp[i][1];
                        if (pptCd == "ROVA") {
                            isOViaMandatory=true;
                        } else if (pptCd == "RDVA") {
                            isDViaMandatory=true;
                        }
                    }
                }
                break;
            case IBSEARCH_ASYNC01: // Check
                ComOpenWait(true);
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                ComOpenWait(false);
                break;
            case IBSAVE: // Save
                ComOpenWait(true);
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!ComPriConfirmSave()) {
                    return false;
                }
                formObj.f_cmd.value=MODIFY01;
                sheetObj.DoSave("ESM_PRI_2066GS.do", FormQueryString(formObj), -1, false);
                ComOpenWait(false);
                break;
        }
    }
    var isClear=true;
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
     * @version 2009.08.25
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSEARCH_ASYNC01: // Check
                if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                    return false;
                }
                if (sheetObj.RowCount() <= 0) {
                    return false;
                }
                isClear=true;
                var prevCmdtRow=sheetObj.HeaderRows();
                var prevRouteRow=sheetObj.HeaderRows();
                var prevRouteRowOPnt=sheetObj.HeaderRows();
                var prevRouteRowOVia=sheetObj.HeaderRows();
                var prevRouteRowDVia=sheetObj.HeaderRows();
                var prevRouteRowDPnt=sheetObj.HeaderRows();
                var prevRouteRowRate=sheetObj.HeaderRows();
                var chkMdtryCmdt=true;
                var chkMdtryOrgPnt=true;
                var chkMdtryOrgVia=true;
                var chkMdtryDestVia=true;
                var chkMdtryDestPnt=true;
                var chkMdtryRate=true;
                var sheetObject2=sheetObjects[1];
                clearTooltip();
                var cmdtCode=null;
                var cmdtDesc=null;
                var orgPntCode=null;
                var orgPntDesc=null;
                var orgPntTerm=null;
                var orgPntTrans=null;
                var orgViaCode=null;
                var destViaCode=null;
                var destPntCode=null;
                var destPntDesc=null;
                var destPntTerm=null;
                var destPntTrans=null;
                var rateDry20=0;
                var rateDry40=0;
                var rateDry40hc=0;
                var rateDry45=0;
                var rateRf40hc=0;
                for (var i = sheetObj.HeaderRows(), n = sheetObj.HeaderRows()+sheetObj.RowCount() ; i < n; i++) {
                    // Commodity Group Mendatory Check.
                	if (sheetObj.GetCellValue(i, "cmdt_dp_seq") != "") {
                        if (!chkMdtryCmdt) {
                            add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
                            isClear=false;
                            prevCmdtRow=i;
                        } else {
                            chkMdtryCmdt=false;
                            prevCmdtRow=i;
                        }
                    }
                    // Commodity Check.
                	cmdtCode=sheetObj.GetCellValue(i, "prc_cmdt_def_cd");
                	cmdtDesc=sheetObj.GetCellValue(i, "prc_cmdt_def_nm");
                    if (cmdtCode != "" || cmdtDesc != "") {
                        chkMdtryCmdt=true;
                        if (cmdtCode != "") {
                            if (cmdtCode.length != 4 && cmdtCode.length != 5 && cmdtCode.length != 6) {
                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "4 or 5 or 6"));
                                isClear=false;
                            }
                        }
                        if (cmdtCode == "" && cmdtDesc != "") {
                            add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
                            isClear=false;
                        }
                    }
                    // Origin Point Mendatory Check.
                    if (sheetObj.GetCellValue(i, "rout_dp_seq") != "") {
                        if (!chkMdtryOrgPnt) {
                            add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
                            add2Tooltip(prevRouteRowOPnt, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
                            isClear=false;
                            prevRouteRowOPnt=i;
                        } else {
                            chkMdtryOrgPnt=false;
                            prevRouteRowOPnt=i;
                        }
                    }
                    // Origin Point Check.
                    orgPntCode=sheetObj.GetCellValue(i, "org_rout_pnt_loc_def_cd");
                    orgPntDesc=sheetObj.GetCellValue(i, "org_rout_pnt_loc_def_nm");
                    orgPntTerm=sheetObj.GetCellValue(i, "org_rcv_de_term_nm");
                    orgPntTrans=sheetObj.GetCellValue(i, "org_prc_trsp_mod_nm");
                    if (orgPntCode != "" || orgPntDesc != "" || orgPntTerm != "" || sheetObj.GetCellText(i, "org_rcv_de_term_nm").trim() != ""
                        || orgPntTrans != "" || sheetObj.GetCellText(i, "org_prc_trsp_mod_nm").trim() != "") {
                        chkMdtryOrgPnt=true;
                        if (orgPntCode != "") {
                            if (orgPntCode.length != 4 && orgPntCode.length != 5) {
                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                                isClear=false;
                            }
                        } else {
                            add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Origin Code"));
                            isClear=false;
                        }
                        if (orgPntTerm == "") {
                            if (sheetObj.GetCellText(i, "org_rcv_de_term_nm").trim() != "") {
                                add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00315"));
                                isClear=false;
                            } else {
                                add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
                                isClear=false;
                            }
                        }
                        if (orgPntTrans == "" && sheetObj.GetCellText(i, "org_prc_trsp_mod_nm").trim() != "") {
                            add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
                            isClear=false;
                        }
                    }
                    // Origin Via Mendatory Check.
                    if (isOViaMandatory && sheetObj.GetCellValue(i, "rout_dp_seq") != "") {
                        if (!chkMdtryOrgVia) {
                            add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
                            isClear=false;
                            prevRouteRowOVia=i;
                        } else {
                            chkMdtryOrgVia=false;
                            prevRouteRowOVia=i;
                        }
                    }
                    // Origin Via Check.
                    orgViaCode=sheetObj.GetCellValue(i, "org_rout_via_port_def_cd");
                    if (orgViaCode != "") {
                        chkMdtryOrgVia=true;
                        if (orgViaCode.length != 4 && orgViaCode.length != 5) {
                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            isClear=false;
                        }
                    }
                    // Destination Via Mendatory Check.
                    if (isDViaMandatory && sheetObj.GetCellValue(i, "rout_dp_seq") != "") {
                        if (!chkMdtryDestVia) {
                            add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
                            isClear=false;
                            prevRouteRowDVia=i;
                        } else {
                            chkMdtryDestVia=false;
                            prevRouteRowDVia=i;
                        }
                    }
                    // Destination Via Check.
                    destViaCode=sheetObj.GetCellValue(i, "dest_rout_via_port_def_cd");
                    if (destViaCode != "") {
                        chkMdtryDestVia=true;
                        if (destViaCode.length != 4 && destViaCode.length != 5) {
                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            isClear=false;
                        }
                    }
                    // Destination Point Mendatory Check.
                    if (sheetObj.GetCellValue(i, "rout_dp_seq") != "") {
                        if (!chkMdtryDestPnt) {
                            add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
                            add2Tooltip(prevRouteRowDPnt, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
                            isClear=false;
                            prevRouteRowDPnt=i;
                        } else {
                            chkMdtryDestPnt=false;
                            prevRouteRowDPnt=i;
                        }
                    }
                    // Destination Point Check.
                    destPntCode=sheetObj.GetCellValue(i, "dest_rout_pnt_loc_def_cd");
                    destPntDesc=sheetObj.GetCellValue(i, "dest_rout_pnt_loc_def_nm");
                    destPntTerm=sheetObj.GetCellValue(i, "dest_rcv_de_term_nm");
                    destPntTrans=sheetObj.GetCellValue(i, "dest_prc_trsp_mod_nm");
                    if (destPntCode != "" || destPntDesc != "" || destPntTerm != "" || sheetObj.GetCellText(i, "dest_rcv_de_term_nm").trim() != ""
                        || destPntTrans != "" || sheetObj.GetCellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
                        chkMdtryDestPnt=true;
                        if (destPntCode != "") {
                            if (destPntCode.length != 4 && destPntCode.length != 5) {
                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                                isClear=false;
                            }
                        } else {
                            add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Destination Code"));
                            isClear=false;
                        }
                        if (destPntTerm == "") {
                            if (sheetObj.GetCellText(i, "dest_rcv_de_term_nm").trim() != "") {
                                add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00315"));
                                isClear=false;
                            } else {
                                add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
                                isClear=false;
                            }
                        }
                        if (destPntTrans == "" && sheetObj.GetCellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
                            add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
                            isClear=false;
                        }
                    }
                    // Rate & Surcharge Check.
                    rateDry20=sheetObj.GetCellValue(i, "rate_dry20");
                    rateDry40=sheetObj.GetCellValue(i, "rate_dry40");
                    rateDry40hc=sheetObj.GetCellValue(i, "rate_dry40hc");
                    rateDry45=sheetObj.GetCellValue(i, "rate_dry45");
                    rateRf40hc=sheetObj.GetCellValue(i, "rate_rf40hc");
                    if (sheetObj.GetCellValue(i, "rout_dp_seq") != "") {
                        prevRouteRowRate=i;
                        if (rateDry20 == "" && rateDry40 == "" && rateDry40hc == "" && rateDry45 == "" && rateRf40hc == ""
                        && (rateDry20 != "0" && rateDry40 != "0" && rateDry40hc != "0" && rateDry45 != "0" && rateRf40hc != "0")) {
                            add2Tooltip(prevRouteRowRate, "rate_dry20", ComGetMsg("PRI00316", "Rate"));
                            add2Tooltip(prevRouteRowRate, "rate_dry40", ComGetMsg("PRI00316", "Rate"));
                            add2Tooltip(prevRouteRowRate, "rate_dry40hc", ComGetMsg("PRI00316", "Rate"));
                            add2Tooltip(prevRouteRowRate, "rate_dry45", ComGetMsg("PRI00316", "Rate"));
                            add2Tooltip(prevRouteRowRate, "rate_rf40hc", ComGetMsg("PRI00316", "Rate"));
                            isClear=false;
                        }
                    }
                    // Rate Mendatory Check.
                    if (rateDry20 != "") {
                        if (rateDry20 != "" && parseFloat(rateDry20) >= 9999999.99) {
                            add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                            isClear=false;
                        }
                    }
                    if (rateDry40 != "") {
                        if (rateDry40 != "" && parseFloat(rateDry40) >= 9999999.99) {
                            add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                            isClear=false;
                        }
                    }
                    if (rateDry40hc != "") {
                        if (rateDry40hc != "" && parseFloat(rateDry40hc) >= 9999999.99) {
                            add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                            isClear=false;
                        }
                    }
                    if (rateDry45 != "") {
                        if (rateDry45 != "" && parseFloat(rateDry45) >= 9999999.99) {
                            add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                            isClear=false;
                        }
                    }
                    if (rateRf40hc != "") {
                        if (rateRf40hc != "" && parseFloat(rateRf40hc) >= 9999999.99) {
                            add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                            isClear=false;
                        }
                    }
                }
                if (!chkMdtryCmdt) {
                    add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
                    isClear=false;
                }
                if (!chkMdtryOrgPnt) {
                    add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
                    add2Tooltip(prevRouteRowOPnt, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
                    isClear=false;
                }
                if (isOViaMandatory && !chkMdtryOrgVia) {
                    add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
                    isClear=false;
                }
                if (isDViaMandatory && !chkMdtryDestVia) {
                    add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
                    isClear=false;
                }
                if (!chkMdtryDestPnt) {
                    add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
                    add2Tooltip(prevRouteRowDPnt, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
                    isClear=false;
                }
                formObj.f_cmd.value=SEARCH01;
                var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
                var sXml=sheetObject2.GetSearchData("ESM_PRI_2066GS.do", sParam);
                var arrErr=ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
                if (arrErr != null && arrErr.length > 0) {
                    isClear=false;
                    var msg=ComGetMsg("PRI00315");
                    for (var i=0; i < arrErr.length; i++) {
                        add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows(), arrErr[i][1], msg);
                    }
                }
                if (isClear) {
                    toggleButtons("CHECK");
                    return true;
                } else {
                    toggleButtons("LOAD");
                    return false;
                }
                break;
            case IBSAVE: // Saving
                if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                    return false;
                }
                return true;
                break;
        }
    }
    /**
     * Clear the contents of Tooltip.<br>
     * <br><b>Example :</b>
     * <pre>
     *     clearTooltip();
     * </pre>
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.08.25
     */
    function clearTooltip() {
        var sheetObj=sheetObjects[0];
        var n = sheetObj.HeaderRows()+sheetObj.RowCount();
        var m=sheetObj.LastCol();
        var i=sheetObj.HeaderRows();
        var j=0;
        for (i=sheetObj.HeaderRows() ; i < n; i++) {
            for (j=0 ; j <= m ; j++) {
                if (sheetObj.GetToolTipText(i, j) != "") {
                    sheetObj.SetCellBackColor(i, j, sheetObj.GetEditableColor());
                    sheetObj.SetToolTipText(i, j,"");
                }
            }
        }
    }
    /**
     * Clear the contents of Tooltip.<br>
     * <br><b>Example :</b>
     * <pre>
     *     add2Tooltip(1, 1, "Sample Message");
     * </pre>
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.08.25
     */
    function add2Tooltip(row, col, msg) {
        var sheetObj=sheetObjects[0];
        var toolTip=sheetObj.GetToolTipText(row, col) + "\n- " +  msg;
        sheetObj.SetCellBackColor(row, col, "#FF0000");
        sheetObj.SetToolTipText(row, col, toolTip);
    }
    /**
     * Button Enable/Disable function <br>
     * Depend on each step, decide buttons enable/disable options.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons("INIT");
     * </pre>
     * @param {string} step Mandatory , Step Code
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function toggleButtons(step) {
        switch (step) {
            case "INIT":
            	ComBtnEnable("btn_openfile");
                ComBtnDisable("btn_check");
                ComBtnDisable("btn_save");
                break;
            case "LOAD":
            	ComBtnEnable("btn_openfile");
            	ComBtnEnable("btn_check");
                ComBtnDisable("btn_save");
                break;
            case "CHECK":
                ComBtnEnable("btn_openfile");
                ComBtnEnable("btn_check");
                ComBtnEnable("btn_save");
                break;
        }
    }
    /**
     * calling function when occurring OnSaveEnd event <br>
     * After save completed, No Error found, Retrieve main page again and close popup window.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.08.28
     */
    function sheet1_OnSaveEnd (sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            // Retrieve Main Window
            opener.reloadPage();
            ComClosePopup(); 
        }
    }
    
    function sheet1_OnLoadExcel(sheetObj, result, code, msg){
    	if(isExceedMaxRow(msg))return;
    	if (sheetObj.RowCount() > 0) {
            toggleButtons("LOAD");
        } else {
            toggleButtons("INIT");
        }
	}
