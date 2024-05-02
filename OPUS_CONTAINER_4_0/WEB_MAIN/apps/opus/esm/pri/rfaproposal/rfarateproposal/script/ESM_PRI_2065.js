/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2065.js
*@FileTitle  : RFA Proposal Creation - Rate [Load Excel] (V Type)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for Commodity Group 
     */
    function ESM_PRI_2065() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    // Common Global Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var timerID="";
    var jobKey="";
    var isOViaMandatory=false;
    var isDViaMandatory=false;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function processButtonClick() {
        var sheetObject1=sheetObjects[0];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
			case "btn_template":
				downform.submit();
				break;
            case "btn_openfile":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
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
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
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
	 * @version 2009.05.01
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
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function loadPage() {
        for (i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
        bIsReqUsr=document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
        bIsAproUsr=document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
        toggleButtons("INIT");
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
	 * @version 2009.05.01
	 */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch (sheetNo) {
        case 1: // sheet1 init
        with(sheetObj){

	    var HeadTitle1="|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)";
	    var HeadTitle2="|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo Type|Rate";
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
	     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
	     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
	     
	    InitColumns(cols);
	
	    SetEditable(1);
		SetShowButtonImage(2);
	    //no support[check again]CLT 	                ToolTipOption="balloon:true;width:1000;icon:3;title:Load Excel";
	    //conversion of function[check again]CLT 	                InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
	    //conversion of function[check again]CLT 	                InitDataValid(0, "cust_seq", vtEngUpOther, "0123456789");
	    //conversion of function[check again]CLT 	                InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
	    //conversion of function[check again]CLT 	                InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "0123456789");
	    //conversion of function[check again]CLT 	                InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "0123456789");
	    //conversion of function[check again]CLT 	                InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
		SetColProperty(0 ,"prc_cmdt_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		SetColProperty(0 ,"cust_seq" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		SetColProperty(0 ,"org_rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		SetColProperty(0 ,"org_rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		SetColProperty(0 ,"dest_rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		SetColProperty(0 ,"dest_rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		
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
                if (sheetObj.GetCellBackColor(Row, Col) == "#FF0000") {
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
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory
	 * @param {int} text Mandatory
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
                var validPerClass="A,F,O,Q,S,P";
                var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","");
                }
            }
        } else if (colName == "rat_ut_cd") {
            var validPerClass="A,F,O,Q,S,P";
            var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
                return;
            }
            if (perClass == "D") {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","DR");
            } else if (perClass == "R") {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","RF");
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","AK");
            } else {
            	if (sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK") {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","");
                }
            }
        } else if (colName == "prc_cmdt_def_cd") {
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
                var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
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
        } else if (colName == "cust_seq") {
            if (Value.length > 2 && Value.length <= 8) {
                Value=Value.substring(0, 2) + ComLpad(Value.substring(2, 8), 6, "0");
                sheetObj.SetCellValue(Row, Col,Value,0);
                formObj.f_cmd.value=COMMAND07;
                var param="&etc1=" + Value.substring(0, 2) + "&etc2=" + Value.substring(2, 8) + "&etc3=Y";
                 var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.SetCellValue(Row, "cust_lgl_eng_nm",arrData[1],0);
                } else {
                    sheetObj.SetCellValue(Row, "cust_lgl_eng_nm","",0);
                    sheetObj.SetCellValue(Row, "cust_seq","",0);
                    sheetObj.SelectCell(Row, "cust_seq", false);
                    return false;
                }
            } else {
                sheetObj.SetCellValue(Row, "cust_lgl_eng_nm","",0);
                sheetObj.SetCellValue(Row, "cust_seq","",0);
                sheetObj.SelectCell(Row, "cust_seq", false);
                return false;
            }
        } else if (colName == "org_rout_pnt_loc_def_cd") {
            if (Value.length == 5) {
                formObj.f_cmd.value=SEARCH05;
                var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
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
                var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
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
                var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
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
                var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
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
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        G_TMP_OBJECT = new tmp_object(sheetObj, Row, Col);
        
        if (colName == "prc_cmdt_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_4027.do?" + FormQueryString(document.form);
            sUrl += "&grp_cd=" + PRI_RP_SCP + "&commodity_cmd=CRG&prc_cmdt_tp_cd=C";
            sUrl += "&prc_cmdt_def_nm=" + sheetObj.GetCellValue(Row, Col);
            ComOpenPopup(sUrl, 600, 350, "prc_cmdt_def_nm_returnVal", "1,0,1,1,1,1,1", true);

        } else if (colName == "cust_lgl_eng_nm") {
            var sUrl="/opuscntr/ESM_PRI_4014_POP.do?" + FormQueryString(document.form);
            sUrl += "&is_popup=true&nmd_cust_flg=Y&cust_nm=" + sheetObj.GetCellValue(Row, Col);
            ComOpenPopup(sUrl, 640, 465, "cust_lgl_eng_nm_returnVal", "none", true);

        } else if (colName == "org_rout_pnt_loc_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=O";
            sUrl += "&loc_def_nm=" + sheetObj.GetCellValue(Row, Col);
            ComOpenPopup(sUrl, 700, 310, "org_rout_pnt_loc_def_nm_returnVal", "1,0,1,1,1,1,1", true);

        } else if (colName == "dest_rout_pnt_loc_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=D";
            sUrl += "&loc_def_nm=" + sheetObj.GetCellValue(Row, Col);
            ComOpenPopup(sUrl, 700, 310, "dest_rout_pnt_loc_def_nm_returnVal", "1,0,1,1,1,1,1", true);

        }
    }
    
    
    
    function prc_cmdt_def_nm_returnVal(rtnVal) {
		if (rtnVal != null){
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "prc_cmdt_def_cd",rtnVal.cd,0);
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "prc_cmdt_def_nm",rtnVal.nm,0);
		}
	}
    
    function cust_lgl_eng_nm_returnVal(rtnVal) {
		if (rtnVal != null){
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "cust_seq",rtnVal.custCntCd + ComLpad(rtnVal.custSeq, 6, "0"),0);
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "cust_lgl_eng_nm",rtnVal.custNm,0);
		}
	}
    
    function org_rout_pnt_loc_def_nm_returnVal(rtnVal) {
		if (rtnVal != null){
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "org_rout_pnt_loc_def_cd",rtnVal.cd,0);
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "org_rout_pnt_loc_def_nm",rtnVal.nm,0);
		}
	}
    
    function dest_rout_pnt_loc_def_nm_returnVal(rtnVal) {
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
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                ComOpenWait(true);
//            }
	        sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 조회
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
			case IBSEARCH_ASYNC02: // Open
// 				var strFilePath=sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
//				if (strFilePath != "<USER_CANCEL>") {
//					var sFileNm=strFilePath.substring(0, strFilePath.lastIndexOf("."));
//					if (sFileNm.substring(sFileNm.length - 1, sFileNm.length) == "H") {
//						ComShowCodeMessage("PRI01117");
//						return;
//					}
 					sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false,ColumnMapping:""});
//				}
				
		     	break;
	        case IBSEARCH_ASYNC01: // Check
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            break;
	        case IBSAVE: // Save
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComPriConfirmSave()) {
	                return false;
	            }
                formObj.f_cmd.value=MODIFY02;
                var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
                var sXml=sheetObj.GetSaveData("ESM_PRI_2065GS.do", sParam);
                 sheetObj.LoadSaveData(sXml);
                if (sXml.indexOf("ERROR") >= 0) {
                    return false;
                }
                ComPriSaveCompleted();
                ComClosePopup(); 
                opener.saveCurRowPos();
                opener.reloadPagePostTr();
	            break;
	        case IBCLEAR: 
	            var sXml=""; 
	            var arrTemp=new Array();
	            // per combo
	            formObj.f_cmd.value=SEARCH03;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
	            //common cargo
	            formObj.f_cmd.value=SEARCH19;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
	            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
	            //common Term Origin
	            formObj.f_cmd.value=SEARCH19;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
	            setIBCombo(sheetObj, sXml, "org_rcv_de_term_nm", true, 0);
	            //common Term Destination
	            formObj.f_cmd.value=SEARCH19;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
	            setIBCombo(sheetObj, sXml, "dest_rcv_de_term_nm", true, 0);
	            //common  Trans. Mode
	            formObj.f_cmd.value=SEARCH19;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
	            setIBCombo(sheetObj, sXml, "org_prc_trsp_mod_nm", true, 0);
	            setIBCombo(sheetObj, sXml, "dest_prc_trsp_mod_nm", true, 0);
	            break;
	        }
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
    function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
    	if(isExceedMaxRow(msg))return;
    	var formObj=document.form;
    	if (sheetObj.RowCount()> 0) {
			toggleButtons("LOAD");
			for (var i = sheetObj.HeaderRows(); sheetObj.RowCount() > 0 && i <= sheetObj.LastRow(); i++) {
				var custSeq=sheetObj.GetCellValue(i, "cust_seq");
				if (custSeq != null && custSeq.length > 2 && custSeq.length < 8) {
					custSeq=custSeq.substring(0, 2) + ComLpad(custSeq.substring(2, 8), 6, "0");
					sheetObj.SetCellValue(i, "cust_seq",custSeq,0);
				}
			}
		} else {
			toggleButtons("INIT");
		}
    }
	function getJobStatus() {
		var jobStatus=null;
		form.f_cmd.value=SEARCHLIST18;
 		var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
		jobStatus=ComGetEtcData(sXml, "JB_STS_FLG");
		if (jobStatus == "3") {
			clearInterval(timerID);
            opener.saveCurRowPos();
            opener.reloadPagePostTr();
            ComPriSaveCompleted();
            ComClosePopup(); 
		} else if (jobStatus == "4") {
			clearInterval(timerID);
			ComShowCodeMessage("PRI00201");
			return false;
		}
	}
    var isClear=true;
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
     * @version 2009.08.27
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC01: // Check
            if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
            if (sheetObj.RowCount() <= 0) {
                return false;
            }
            if (formObj.prc_prop_sts_cd.value != "I") {
                return false;
            }
            isClear=true;
            var prevCmdtRow=sheetObj.HeaderRows();
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
            ComOpenWait(true);
            clearTooltip();
            var cmdtCode=null;
            var cmdtDesc=null;
            var custCode=null;
            var custDesc=null;
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
            var perTypeCode=null;
            var cargoTypeCode=null;
            var propRate=0;
            var validPerClass="A,F,O,Q,S,P";
            var perClass=null;
            
            //2015.06.15 ADD (check the duplication of Comodity Seq)
            var duprowsCmdt = sheetObj.ColValueDupRows("cmdt_dp_seq",false,true,1);
            var arrRow = duprowsCmdt.split("|");
            if(arrRow.length > 1) {
            	var duparrRow = arrRow[1].split(",");
            	for(var i=0; i < duparrRow.length; i++ ){
	            	var sVal = sheetObj.GetCellValue(duparrRow[i], "cmdt_dp_seq");
	            	if(sVal != "") {
		            	add2Tooltip(duparrRow[i], "cmdt_dp_seq", ComGetMsg("PRI00332", "Commodity Seq"));
		                isClear=false;
	            	}
            	}
            }         
            
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
//                        if (cmdtCode.length == 6) {
//                            formObj.f_cmd.value = SEARCH08;
//                            var param = "&cd=" + cmdtCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
//                                isClear = false;
//                            }
//                        } else if (cmdtCode.length == 4) {
//                            formObj.f_cmd.value = COMMAND29;
//                            var param = "&cd=" + cmdtCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (cmdtCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH10;
//                            var param = "&cd=" + cmdtCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        }
//                        else {
                        if (cmdtCode.length != 4 && cmdtCode.length != 5 && cmdtCode.length != 6) {
                            add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "4 or 5 or 6"));
                            isClear=false;
                        }
                    }
                    else if (cmdtCode == "" && cmdtDesc != "") {
                        add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
                        isClear=false;
                    }
                }
                // Actual Customer Check.
                custCode=sheetObj.GetCellValue(i, "cust_seq");
                custDesc=sheetObj.GetCellValue(i, "cust_lgl_eng_nm");
                if (custCode != "") {
//                    if (custCode.length > 2 && custCode.length <= 8) {
//                        custCode = custCode.substring(0, 2) + ComLpad(custCode.substring(2, 8), 6, "0");
//                        sheetObj.CellValue2(i, "cust_seq") = custCode;
//                        
//                        formObj.f_cmd.value = COMMAND07;
//                        var param = "&etc1=" + custCode.substring(0, 2) + "&etc2=" + custCode.substring(2, 8);
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
                    if (custCode.length <= 2 || custCode.length > 8) {
                        add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
                        isClear=false;
                    }
                } else if (custCode == "" && custDesc != "") {
                    add2Tooltip(i, "cust_seq", ComGetMsg("PRI00335", "Customer Code"));
                    isClear=false;
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
//                        if (orgPntCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH05;
//                            var param = "&cd=" + orgPntCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (orgPntCode.length == 4) {
//                            formObj.f_cmd.value = SEARCH11;
//                            var param = "&cd=" + orgPntCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else {
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
//                    if (orgViaCode.length == 5) {
//                        formObj.f_cmd.value = SEARCH05;
//                        var param = "&cd=" + orgViaCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else if (orgViaCode.length == 4) {
//                        formObj.f_cmd.value = SEARCH11;
//                        var param = "&cd=" + orgViaCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
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
//                    if (destViaCode.length == 5) {
//                        formObj.f_cmd.value = SEARCH05;
//                        var param = "&cd=" + destViaCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else if (destViaCode.length == 4) {
//                        formObj.f_cmd.value = SEARCH11;
//                        var param = "&cd=" + destViaCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
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
//                        if (destPntCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH05;
//                            var param = "&cd=" + destPntCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (destPntCode.length == 4) {
//                            formObj.f_cmd.value = SEARCH11;
//                            var param = "&cd=" + destPntCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else {
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
                // Rate Mendatory Check.
                if (sheetObj.GetCellValue(i, "rout_dp_seq") != "") {
                    if (!chkMdtryRate) {
                        add2Tooltip(prevRouteRowRate, "rat_ut_cd", ComGetMsg("PRI00316", "Rate"));
                        add2Tooltip(prevRouteRowRate, "prc_cgo_tp_cd", ComGetMsg("PRI00316", "Rate"));
                        add2Tooltip(prevRouteRowRate, "prop_frt_rt_amt", ComGetMsg("PRI00316", "Rate"));
                        isClear=false;
                        prevRouteRowRate=i;
                    } else {
                        chkMdtryRate=false;
                        prevRouteRowRate=i;
                    }
                }
                // Rate & Surcharge Check.
                perTypeCode=sheetObj.GetCellValue(i, "rat_ut_cd");
                cargoTypeCode=sheetObj.GetCellValue(i, "prc_cgo_tp_cd");
                propRate=sheetObj.GetCellValue(i, "prop_frt_rt_amt");
                if (perTypeCode != "" || cargoTypeCode != "" || propRate !== "") {
                    chkMdtryRate=true;
                    if (perTypeCode == "") {
                        add2Tooltip(i, "rat_ut_cd", ComGetMsg("PRI00335", "PER"));
                        isClear=false;
                    }
                    if (cargoTypeCode == "") {
                        add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI00335", "Cargo Type"));
                        isClear=false;
                    }
                    if (propRate === "") {
        				add2Tooltip(i, "prop_frt_rt_amt", ComGetMsg("PRI00335", "Rate"));
        				isClear=false;
        			} else if (propRate != "" && parseFloat(propRate) >= 999999999.99) {
                        add2Tooltip(i, "prop_frt_rt_amt", ComGetMsg("PRI00336", "Rate", "999999999.99"));
                        isClear=false;
                    }
                    if (perTypeCode != "" && cargoTypeCode != "") {
                        if (cargoTypeCode == "AK") {
//                            var validPerClass = "A,F,O,Q,S,P";
                            perClass=perTypeCode.charAt(0);
                            if (validPerClass.indexOf(perClass) < 0) {
                                add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI08003"));
                                isClear=false;
                            }
                        }
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
            if (!chkMdtryRate) {
                add2Tooltip(prevRouteRowRate, "rat_ut_cd", ComGetMsg("PRI00316", "Rate"));
                add2Tooltip(prevRouteRowRate, "prc_cgo_tp_cd", ComGetMsg("PRI00316", "Rate"));
                add2Tooltip(prevRouteRowRate, "prop_frt_rt_amt", ComGetMsg("PRI00316", "Rate"));
                isClear=false;
            }
            formObj.f_cmd.value=SEARCH01;
            var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
             var sXml=sheetObject2.GetSearchData("ESM_PRI_2065GS.do", sParam);
            var arrErr=ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
            if (arrErr != null && arrErr.length > 0) {
                isClear=false;
                var msg=ComGetMsg("PRI00315");
                for (var i=0; i < arrErr.length; i++) {
                    add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows(), arrErr[i][1], msg);
                }
            }
            ComOpenWait(false);
            document.body.scroll="no";
            if (isClear) {
                toggleButtons("CHECK");
                return true;
            } else {
                toggleButtons("LOAD");
                return false;
            }
            break;
        case IBSAVE: // Saving
//            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
//                return false;
//            }
            return true;
            break;
        }
    }
    
    function clearTooltip() {
        var sheetObj=sheetObjects[0];
//        for (var i = sheetObj.HeaderRows(), n = sheetObj.HeaderRows()+sheetObj.RowCount() ; i < n; i++) {
//            for (var j = 0; j <= sheetObj.LastCol; j++) {
//                sheetObj.SetCellBackColor(i, j, sheetObj.EditableColor);
//                sheetObj.ToolTipText(i, j) = "";
//            }
//        }
        var n = sheetObj.HeaderRows()+sheetObj.RowCount();
        var m=sheetObj.LastCol();
        var i=sheetObj.HeaderRows();
        var j=0;
        for (i=sheetObj.HeaderRows() ; i < n; i++) {
            for (j=0 ; j <= m ; j++) {
                if (sheetObj.GetToolTipText(i, j) != "") {
                    sheetObj.SetCellBackColor(i, j, sheetObj.GetEditableColor());
                    sheetObj.SetToolTipText(i, j, "");
                }
            }
        }
    }
    function add2Tooltip(row, col, msg) {
        var sheetObj=sheetObjects[0];
        var toolTip=sheetObj.GetToolTipText(row, col) + "\n- " +  msg;
        sheetObj.SetCellBackColor(row, col, "#FF0000");
        sheetObj.SetToolTipText(row, col, toolTip);
    }
	/**
	 * Controlling all buttons of screen<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode Mandatory
	 * @author 
	 * @version 2009.05.01
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
