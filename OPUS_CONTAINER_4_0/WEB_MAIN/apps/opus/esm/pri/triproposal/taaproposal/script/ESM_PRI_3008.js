/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3008.js
*@FileTitle  : TAA No Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_PRI_3008 : business script for ESM_PRI_3008 
     */
    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
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
                case "btn_OK":
                    if (sheetObject1.RowCount()== 0) {
                        ComShowCodeMessage("PRI00011");
                        return;
                    } else {
                    	var returnValue=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "taa_no");
                    	 ComPopUpReturnValue(returnValue);
                    }
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn_New":
                    formObject.reset();
                    getComboObject(comboObjects, "svc_scp_cd").SetSelectCode("");
                    sheetObject1.RemoveAll();
                    break;
                case "btn_ctrt_cust":
                    var param="is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObject.ctrt_cust_cnt_cd.value+"&cust_seq="+formObject.ctrt_cust_seq.value;
                    ComOpenPopup("/opuscntr/ESM_PRI_4014_POP.do?"+param, 640, 465, "findCtrtCust", "none", false);
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
     * registering IBMultiCombo Object as array <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setComboObject (combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initIBComboItem();
        initControl();
        
    }
    /**
     * setting IBMultiCombo with retrieved combo item <br>
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }
    /**
     * handling Axon event<br>
     */
    function initControl () {
        var formObj=document.form;
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('blur', 'obj_deactivate', formObj);
//        axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * handling OnKeyPress events <br>
     */
    function obj_keypress () {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "ymd":
                ComKeyOnlyNumber(event.srcElement, "-");
                break;
            default:
        }
    }
    /**
     * handling Onbeforedeactivate Event <br>
     */
    function obj_deactivate () {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var eleName=event.srcElement.name;
        switch (eleName) {
            case "ctrt_cust_cnt_cd":
                //cust name find
                if (formObj.ctrt_cust_cnt_cd.value != "") {
                    custNameFind(eleName);
                } else {
                    clearCustName();
                }
                break;
            case "ctrt_cust_seq":
                var custSeq=formObj.ctrt_cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0) {
                    formObj.ctrt_cust_seq.value=ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (formObj.ctrt_cust_seq.value != "") {
                    custNameFind(eleName);
                } else {
                    clearCustName();
                }
                break;
            default:
                ComChkObjValid(event.srcElement);
        }
    }
    /**
     * handling OnBeforeActivate event <br>
     */
    function obj_activate () {
        var formObj=document.form;
        var sElement=event.srcElement;
        var srcName=sElement.getAttribute("name");
        ComClearSeparator(sElement);
    }
    /**
     * retrieving information about customer<br>
     */
    function custNameFind (eleName) {
        var formObj=document.form;
        var sheetObj=sheetObjects[1];
        var ctrt_cust_cnt_cd=formObj.ctrt_cust_cnt_cd.value;
        var ctrt_cust_seq=formObj.ctrt_cust_seq.value;
        if (ctrt_cust_cnt_cd != "" && ctrt_cust_seq != "") {
            var sParam="f_cmd=" + SEARCH02 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
             var sXml=sheetObj.GetSearchData("ESM_PRI_3008GS.do", sParam);
            var arrText=ComPriXml2Array(sXml,"prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            if (arrText == undefined) {
                clearCustName();
                formObj.ctrt_cust_cnt_cd.focus();
            } else {
                formObj.ctrt_cust_nm.value=arrText[0][1];
            }
        }
    }
    /**
     * initializing Html Object value about customer<br>
     */
    function clearCustName () {
        var formObj=document.form;
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_cust_nm.value="";
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
               
              var HeadTitle="|Seq.|TAA No.|SVC Scope|Office|Sale Rep.|Sale Rep.|Customer|Customer|Duration|Duration";
              var HeadTitle1="|Seq.|TAA No.|SVC Scope|Office|Code|Description|Code|Description|Effective Date|Expiration Date";
              var headCount=ComCountHeadTitle(HeadTitle);
              //(headCount, 0, 0, true);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"taa_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"respb_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"respb_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"respb_srep_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"ctrt_cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetWaitImageVisible(0);
            //  SetCountPosition()(0);
              SetShowButtonImage(2);
              resizeSheet(); //SetSheetHeight(130);
              }


                break;
            case "sheet2":  // hidden
                with(sheetObj){
                var HeadTitle="status";
              var headCount=ComCountHeadTitle(HeadTitle);
             // (headCount, 0, 0, true);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetVisible(0);
//              SetSheetHeight(182);
                    }


                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

    /**
     * initializing combo, header <br>
     * adding case in case of multiple combo <br>
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    //no support[check again]CLT ValidChar(2, 0);
                    SetMaxLength(3);
                    ValidChar(2);
                }
                break;
        }
    }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                formObj.f_cmd.value=SEARCH01;
                 sheetObj.DoSearch("ESM_PRI_3008GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
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
     * calling event when occurring OnDblClick event <br>
     */
    function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        var returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "taa_no");
        ComPopUpReturnValue(returnValue);
        
        return false;
    }
    /**
     * calling function when occurring OnChange Event from IBCombo <br>
     */
    function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var arrText=newText.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.svc_scp_nm.value=arrText[1];
        } else {
            formObj.svc_scp_nm.value="";
        }
    }
    /**
     * calling function when occurring IBMultiCombo OnClear Event <br>
     */
    function svc_scp_cd_OnClear (comboObj) {
        var formObj=document.form;
        formObj.svc_scp_nm.value="";
        comboObj.SetSelectIndex(-1,false);
    }
    /**
     * calling function when occurring IBMultiCombo OnBlur Event <br>
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj=document.form;
         var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != -1) {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
            }
        }
    }
    
    function findCtrtCust(rowArray) {

   	 var formObject=document.form;
	      if (rowArray != null){
	      formObject.ctrt_cust_cnt_cd.value=rowArray.custCntCd;
	      formObject.ctrt_cust_seq.value=rowArray.custSeq;
	      formObject.ctrt_cust_nm.value=rowArray.custNm;
	      custNameFind("ctrt_cust_cnt_cd");
        }
   }
