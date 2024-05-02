/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2002.js
*@FileTitle  : Guideline Creation [Copy]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends Pri
     * @class ESM_PRI_2002 : business script for ESM_PRI_2002 
     */
    function ESM_PRI_2002 () {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
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
    function processButtonClick () {
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
                case "btn_OK":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "btns_calendar1": 
                case "btns_calendar2": 
                    var cal=new ComCalendarFromTo();
                    cal.select(formObj.trgt_eff_dt, formObj.trgt_exp_dt, 'yyyy-MM-dd');
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
    function loadPage () {
    	
    	if (!opener) opener = window.dialogArguments;
   	 	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;
   	 	
        try {
            // initializing IBMultiCombo
            for ( var k=0; k < comboObjects.length; k++) {
                initCombo(comboObjects[k], k + 1);
            }
            for (i=0; i < sheetObjects.length; i++) {
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            initControl();
            initIBComboItem();
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
     * handling Axon event<br>
     */
    function initControl () {
        var formObj=document.form;
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
    }
    /**
     * handling OnBeforeActivate event <br>
     */
    function obj_activate () {
        var formObj=document.form;
        var eleName=event.srcElement.name;
        switch (eleName) {
            case "trgt_eff_dt":
            case "trgt_exp_dt":
                // deleting mask seperator
                ComClearSeparator(event.srcElement);
                break;
        }
    }
    /**
     * handling Onbeforedeactivate Event <br>
     */
    function obj_deactivate () {
        var formObj=document.form;
        var eleName=event.srcElement.name;
        switch (eleName) {
            case "trgt_eff_dt":
            case "trgt_exp_dt":
                ComChkObjValid(event.srcElement);
                break;
        }
    }
    /**
     * setting IBMultiCombo with retrieved Combo Item<br>
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects,'trgt_svc_scp_cd'),"|","\t");
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        var sheetId=sheetObj.id;
        switch (sheetId) {
        case "sheet1":
	        with(sheetObj){
	
	       var HeadTitle1="|Service Scope|Duration|Duration|Rate|Location\nGroup|Commodity\nGroup|Origin\nArbitrary|Destination\nArbitrary|rt_cmdt_chk|rt_loc_chk|aro_loc_chk|ard_loc_chk";
	       var HeadTitle2="|Service Scope|Effective|Expiration|Rate|Location\nGroup|Commodity\nGroup|Origin\nArbitrary|Destination\nArbitrary|rt_cmdt_chk|rt_loc_chk|aro_loc_chk|ard_loc_chk";
	       var headCount=ComCountHeadTitle(HeadTitle2);
	
	       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	       var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	       var headers = [ { Text:HeadTitle1, Align:"Center"},
	                     { Text:HeadTitle2, Align:"Center"} ];
	       InitHeaders(headers, info);
	
	       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
	                 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rate_chk" },
	                 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_chk" },
	                 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_chk" },
	                 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"arb_org_chk" },
	                 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"arb_des_chk" },
	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rt_cmdt_chk" },
	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rt_loc_chk" },
	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"aro_loc_chk" },
	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ard_loc_chk" } ];
	        
	       InitColumns(cols);
	
	       SetEditable(1);
	       SetWaitImageVisible(0);
	       SetCountPosition(0);
	       resizeSheet();//SetSheetHeight(95);
	       }
	       break;
        case "sheet2":  // hidden
	       with(sheetObj){

		   var HeadTitle="status";
		
		   SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		   var headers = [ { Text:HeadTitle, Align:"Center"} ];
		   InitHeaders(headers, info);
		
		   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		    
		   InitColumns(cols);
		
		   SetVisible(0);
        	}
	       break;

        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0], 100); }
    /**
     * initializing combo, header <br>
     * adding case in case of multiple combo <br>
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "trgt_svc_scp_cd":
                with (comboObj) {
                    SetDropHeight(120);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
        }
    }
    var isAuthUsr=false;
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: //retrieve
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    if ("sheet1" == sheetObj.id) {
                        formObj.f_cmd.value=SEARCH;
                         sheetObj.DoSearch("ESM_PRI_2002GS.do", FormQueryString(formObj), {Sync:2} );
                    }
                }
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01:
                var sParam="f_cmd="+COMMAND15+"&pagerows=&prc_ctrt_tp_cd=R&svc_scp_cd=" + getComboObject(comboObjects, "trgt_svc_scp_cd").GetSelectCode()+ "&usr_id=" + formObj.usr_id.value;
                 var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                var arrAuth=ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
                if (arrAuth != null && arrAuth.length > 0) {
                    isAuthUsr=true;
                } else {
                    isAuthUsr=false;
                }
                toggleButtons();
                break;
            case IBSAVE: //save
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction) && ComShowCodeConfirm('PRI00012')) {
                    formObj.f_cmd.value=MULTI;
                    sheetObj.DoAllSave("ESM_PRI_2002GS.do", FormQueryString(formObj));
                }
                ComOpenWait(false);
                break;
        }
    }
    /**
    * setting button control by user authority<br>
    */
    function toggleButtons() {
        if (isAuthUsr) {
            ComBtnEnable("btn_OK");
        } else {
            ComBtnDisable("btn_OK");
        }
    }
    /**
     * calling function when occurring OnChange Event <br>
     * setting automatically Group Commodity, Group Location when selecting Rate <br>
     */
    function sheet1_OnChange (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch (colname) {
            case "rate_chk":
                if (Value == 1) {
                	if (sheetObj.GetCellEditable(Row, "loc_chk") && sheetObj.GetCellValue(Row, "rt_loc_chk") == "1") {
                        sheetObj.SetCellValue(Row, "loc_chk",1,0);
                    }
                	if (sheetObj.GetCellEditable(Row, "cmdt_chk") && sheetObj.GetCellValue(Row, "rt_cmdt_chk") == "1") {
                        sheetObj.SetCellValue(Row, "cmdt_chk",1,0);
                    }
                }
                break;
            case "arb_org_chk":
                if (Value == 1) {
                	if (sheetObj.GetCellEditable(Row, "loc_chk") && sheetObj.GetCellValue(Row, "aro_loc_chk") == "1") {
                        sheetObj.SetCellValue(Row, "loc_chk",1,0);
                    }
                }
                break;
            case "arb_des_chk":
                if (Value == 1) {
                	if (sheetObj.GetCellEditable(Row, "loc_chk") && sheetObj.GetCellValue(Row, "ard_loc_chk") == "1") {
                        sheetObj.SetCellValue(Row, "loc_chk",1,0);
                    }
                }
                break;
            case "loc_chk":
                if (Value == 0) {
                	if (sheetObj.GetCellValue(Row, "rate_chk") == 1 && sheetObj.GetCellValue(Row, "rt_loc_chk") == "1") {
                        sheetObj.SetCellValue(Row, "rate_chk",0,0);
                    }
                	if (sheetObj.GetCellValue(Row, "arb_org_chk") == 1 && sheetObj.GetCellValue(Row, "aro_loc_chk") == "1") {
                        sheetObj.SetCellValue(Row, "arb_org_chk",0,0);
                    }
                	if (sheetObj.GetCellValue(Row, "arb_des_chk") == 1 && sheetObj.GetCellValue(Row, "ard_loc_chk") == "1") {
                        sheetObj.SetCellValue(Row, "arb_des_chk",0,0);
                    }
                }
                break;
            case "cmdt_chk":
            	if (Value == 0 && sheetObj.GetCellValue(Row, "rate_chk") == 1 && sheetObj.GetCellValue(Row, "rt_cmdt_chk") == "1") {
                    sheetObj.SetCellValue(Row, "rate_chk",0,0);
                }
                break;
        }// end switch
    }
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm (sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSAVE:
                // 1.IBSheet Data Check
            	if (sheetObj.GetCellValue(2, "rate_chk") != 1 && sheetObj.GetCellValue(2, "loc_chk") != 1
            			&& sheetObj.GetCellValue(2, "cmdt_chk") != 1 && sheetObj.GetCellValue(2, "arb_org_chk") != 1
            			&& sheetObj.GetCellValue(2, "arb_des_chk") != 1) {
                    ComShowCodeMessage('PRI01043');
                    return false;
                }
                // 2.IBMultiCombo Data Check
                if (getComboObject(comboObjects, "trgt_svc_scp_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI01029');
                    getComboObject(comboObjects, "trgt_svc_scp_cd").focus();
                    return false;
                }
                // 3.Form basic check 
                if (!ComChkValid(formObj))
                    return false;
                // 4.Effective Date Check
                formObj.f_cmd.value=SEARCH01;
                 sheetObjects[1].DoSearch("ESM_PRI_2002GS.do", FormQueryString(formObj), {Sync:2});
                if (sheetObjects[1].GetEtcData("valid") == "FALSE") {
                    formObj.trgt_eff_dt.select();
                    formObj.trgt_eff_dt.focus();
                    return false;
                }
                break;
        }
        return true;
    }
    /**
     * IBCombo에서 calling function when occurring OnChange Event <br>
     * showing description when trgt_svc_scp_cd combo value changed <br>
     */
    function trgt_svc_scp_cd_OnChange (comboObj, code, text) {
        var formObj=document.form;
        var arrText=text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.trgt_svc_scp_nm.value=arrText[1];
        } else {
            formObj.trgt_svc_scp_nm.value="";
        }
        checkAuthUser (comboObj);
    }
    /**
     * calling function when occurring IBMultiCombo OnClear Event <br>
     * initializing svc_scp_nm when deleting all svc_scp_cd combo data<br>
     */
    function trgt_svc_scp_cd_OnClear (comboObj) {
        var formObj=document.form;
        formObj.trgt_svc_scp_nm.value="";
        comboObj.SetSelectIndex(-1,false);
    }
    /**
     * calling function when occurring IBMultiCombo OnBlur Event <br>
     * showing description when svc_scp_cd combo focus out <br>
     */
    function trgt_svc_scp_cd_OnBlur (comboObj) {
        var formObj=document.form;
         var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != "") {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.trgt_svc_scp_nm.value) {
                formObj.trgt_svc_scp_nm.value=comboObj.GetText(code, 1);
            }
            checkAuthUser (comboObj);
        }
    }
    /**
     * checking authority of selected Service Scope<br>
     */
    function checkAuthUser (comboObj) {
        var formObj=document.form;
        var sheetObj2=sheetObjects[1];
        doActionIBSheet(sheetObj2, formObj, IBSEARCH_ASYNC01);
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     * prohibiting non data item<br>
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            var formObj=document.form;
            // check box enable/disable
            for ( var i = sheetObj.HeaderRows(), n = sheetObj.RowCount() + sheetObj.HeaderRows(); i < n; i++) {
            	if (sheetObj.GetCellValue(i, "rate_chk") != 1) {
                    sheetObj.SetCellEditable(i, "rate_chk",0);
                }
            	if (sheetObj.GetCellValue(i, "loc_chk") != 1) {
                    sheetObj.SetCellEditable(i, "loc_chk",0);
                }
            	if (sheetObj.GetCellValue(i, "cmdt_chk") != 1) {
                    sheetObj.SetCellEditable(i, "cmdt_chk",0);
                }
            	if (sheetObj.GetCellValue(i, "arb_org_chk") != 1) {
                    sheetObj.SetCellEditable(i, "arb_org_chk",0);
                }
            	if (sheetObj.GetCellValue(i, "arb_des_chk") != 1) {
                    sheetObj.SetCellEditable(i, "arb_des_chk",0);
                }
            }
            getComboObject(comboObjects, "trgt_svc_scp_cd").SetSelectCode(formObj.svc_scp_cd.value);
            formObj.trgt_svc_scp_nm.value=getComboObject(comboObjects, "trgt_svc_scp_cd").GetText(formObj.svc_scp_cd.value, 1)
        }
    }
    /**
     * calling function when occurring OnSaveEnd event  <br>
     * closing after successful copying<br>
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        	opener.reloadPostCopy(getComboObject(comboObjects, "trgt_svc_scp_cd").GetSelectCode(), sheetObj.GetEtcData("glineSeq"));
            ComClosePopup(); 
        }
    }
