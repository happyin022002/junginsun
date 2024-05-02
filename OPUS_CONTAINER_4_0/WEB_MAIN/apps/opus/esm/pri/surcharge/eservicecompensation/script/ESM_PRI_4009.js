/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4009.js
*@FileTitle  : E-Service Compensation Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends Pri
 * @class ESM_PRI_4009 : business script for ESM_PRI_4009
 */
    //  ===================================================================================
    //  Global Variable
    //  ===================================================================================
    //  Common Global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var comboObjects=new Array();
    var comboCnt=0;
    //  BIZ Global Variable
    var gCurrRow1=0;
    var gSvcScpCd;
    var gScNo, gRfaNo;
    var gRgnCdS, gRgnNmS, gDestCdS, gDestNmS;
    var gCurrDate;
    //  ===================================================================================
    //  Event handler processing by button click event
    //  ===================================================================================
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function processButtonClick(){
        var form=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheet1, form, IBSEARCH);
                    break;
                case "btn_new":
                    form.sc_no.value="";
                    svc_scp_cd.SetSelectCode("");
                    form.svc_scp_nm.value="";
                    chg_cd.SetSelectCode("");
                    //form.prc_ctrt_tp_cd.Code = "";
                    org_rgn_cd.RemoveAll();
                    form.org_rgn_cd.SetDropHeight(10);
                    org_rgn_cd.InsertItem(0, "", "");
                    dest_rgn_cd.RemoveAll();
                    form.dest_rgn_cd.SetDropHeight(10);
                    dest_rgn_cd.InsertItem(0, "", "");
                    form.eff_dt.value=gCurrDate;
                    sheet1.RemoveAll();
                    break;
                case "btns_calendar": 
                    var cal=new ComCalendar();
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
                    break;
                case "btn_add":
                    doActionIBSheet(sheet1, form, IBINSERT);
                    break;
                case "btn_del":
                    doActionIBSheet(sheet1, form, IBDELETE);
                    break;
                case "btn_save":
                    doActionIBSheet(sheet1, form, IBSAVE);
                    break;
            } //end switch
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
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function loadPage() {
        var form=document.form;
        //IBMultiCombo Initialization
        comboCnt=comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }
        //IBSheet Initialization
        sheet1=sheetObjects[0];
        sheetCnt=sheetObjects.length ;
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); 
        }
        //html control event Initialization
        axon_event.addListenerForm('focus', 'obj_activate', form);
//        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('blur', 'obj_deactivate', form);
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        initIBComboItem();
        sheet1.SetWaitImageVisible(0);
        form.eff_dt.value=ComGetNowInfo('ymd', '-');
        gCurrDate=ComGetNowInfo('ymd', '-');
        doActionIBSheet(sheet1, form, IBSEARCH);
    }
    /**
     * Setting item into IBMultiCombo  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.12.15
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(chargeComboValue,   chargeComboText,   getComboObject(comboObjects, 'chg_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(ctrtTypeCode, ctrtTypeText, getComboObject(comboObjects, 'prc_ctrt_tp_cd') ,"|","\t" );
        prc_ctrt_tp_cd.SetSelectCode("R",false);
        prc_ctrt_tp_cd.SetEnable(0);
    }
    /**
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : Sheet Object
     * @param {int} sheetNo : Sheet Object Tag's ID Serial No
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheet1){
		              var HeadTitle1="chk|cmpn_seq|ibflag|Scope|Origin|Dest.|RFA No.|E-SVC Type|E-SVC Type|E-SVC Type|Charge|Discount|Discount|Discount|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate";
		              var HeadTitle2="chk|cmpn_seq|ibflag|Scope|Origin|Dest.|RFA No.|Web|EDI|Desk\nTop|Charge|Cur.|Amount|Percentage|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cmpn_seq",          KeyField:1,   CalcLogic:"",   Format:"" },
		                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_rgn_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dest_rgn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_esvc_tp_cd_w",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_esvc_tp_cd_e",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_esvc_tp_cd_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
		                     {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dc_per",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
		                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cmpn_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColProperty("svc_scp_cd", {ComboText:svcScpCdComboText, ComboCode:svcScpCdComboValue} );
		              SetColProperty("org_rgn_cd", {ComboText:originComboText, ComboCode:originComboValue} );
		              SetColProperty("chg_cd", {ComboText:chargeComboText, ComboCode:chargeComboValue} );
		              SetColProperty("dest_rgn_cd", {ComboText:destComboText, ComboCode:destComboValue} );
		              SetColProperty("curr_cd", {ComboText:curComboText, ComboCode:curComboValue} );
		              InitComboNoMatchText(true);
		              SetColHidden("chk",1);
		              SetColHidden("cmpn_seq",1);
		              SetSheetHeight(435);
            		}
                break;
        }
    }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBMultiCombo} comboObj : Sheet Object
     * @param {int} comboNo : Combo Object Tag's ID Serial No
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Only upper case
                    SetMaxLength(3);
                }
                break;
            case "chg_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    //no support[check again]CLT ValidChar(2, 0);    // Only upper case
                    SetMaxLength(3);
                }
                break;
            case "org_rgn_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(10);
                    SetUseAutoComplete(1);
                    //no support[check again]CLT ValidChar(2, 0);    // Only upper case
                    SetMaxLength(3);
                }
                break;
            case "dest_rgn_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(10);
                    SetUseAutoComplete(1);
                    //no support[check again]CLT ValidChar(2, 0);    // Only upper case
                    SetMaxLength(3);
                }
                break;
            case "prc_ctrt_tp_cd":
                with(comboObj) {
                    Style=1;
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(0);
                    SetColWidth(0, "18");
                    SetColWidth(1, "50");
                }
                break;
        }
    }
    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /**
     * Objet's Keypress Event handler <br>
     * Checking a validation about inputed data by object's dataformat.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
//    function obj_keypress(){
//        var obj=ComGetEvent();
//        if(obj.dataformat == null) return;
//        window.defaultStatus=obj.dataformat;
//        switch(obj.dataformat){
//            case "ymd": 
//                ComKeyOnlyNumber(obj,"-");
//                break;
//            case "uppernum": //Only upper case and numbers
//                ComKeyOnlyAlphabet('uppernum');
//                break;
//            default:
//                ComKeyOnlyNumber(ComGetEvent());
//            break;
//        }
//    }
    /**
     * Handling OnBeforeActivate event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2010.02.26
     */
    function obj_activate() {
        ComClearSeparator(ComGetEvent());
    }
    /**
     *  Objet's Onbeforedeactivate Event handler<br>
     * Checking a validation about inputed data by object's dataformat <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function obj_deactivate() {
        var formObj=ComGetEvent();
        var srcName=ComGetEvent("name");
        var objValue;
        switch(srcName) {
            case "sc_no":
                break;
            case "svc_scp_cd":
                break;
            default :
                ComChkObjValid(formObj);
        }
    }
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**
     * svc_scp_cd_OnChange event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} comboObj : Combo Object
     * @param  {IBMultiCombo} objCd : Selected code value
     * @param  {IBMultiCombo} objTxt :Selected code text
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Code, Text) {
        var form=document.form;
        var cText=comboObj.GetText(Code, 1);
        form.svc_scp_nm.value=cText;
    }
    /**
     * svc_scp_cd_OnBlur event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} comboObj : Combo Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var form=document.form;
        var comboOrgRgnCd=form.org_rgn_cd;
        var comboDestRgnCd=form.dest_rgn_cd;
        //var code = comboObj.FindIndex(comboObj.Code, 0);
        var code=comboObj.GetSelectCode();
        if (code != null && code != "") {
            doActionIBSheet(sheet1, form, IBSEARCH_ASYNC02);
        }else{
            comboOrgRgnCd.RemoveAll();
            comboDestRgnCd.RemoveAll();
        }
    }
    /**
     * Function to call Retrieving/Saving server function<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : Form Object
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                sheet1.DoSearch("ESM_PRI_4009GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01: //origin, dest Combo 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheet1.GetSearchData("ESM_PRI_4009GS.do", FormQueryString(formObj) + "&svc_scp_cd=" + gSvcScpCd + "&delt_flg=N" );
                var arrData=ComPriXml2Array(sXml, "rgn_cd|rgn_nm|org_dest_cd"); //"☜☞"
                var arrRow;
                gRgnCdS=""; gRgnNmS=""; gDestCdS=""; gDestNmS="";
                for(var i=0; i < arrData.length; i++) {
                    arrRow=arrData[i];
                    if(arrRow[2] == "O") {
                        if(gRgnCdS.length == 0) {
                            gRgnCdS=arrRow[0];
                            gRgnNmS=arrRow[0] + "\t" + arrRow[1];
                        } else {
                            gRgnCdS += "|" + arrRow[0];
                            gRgnNmS += "|" + arrRow[0] + "\t" + arrRow[1];
                        }
                    } else if (arrRow[2] == "D") {
                        if(gDestCdS.length == 0) {
                            gDestCdS=arrRow[0];
                            gDestNmS=arrRow[0] + "\t" + arrRow[1];
                        } else {
                            gDestCdS += "|" + arrRow[0];
                            gDestNmS += "|" + arrRow[0] + "\t" + arrRow[1];
                        }
                    }
                }
                gRgnCdS=" |" + gRgnCdS;
                gRgnNmS=" |" + gRgnNmS;
                gDestCdS=" |" + gDestCdS;
                gDestNmS=" |" + gDestNmS;
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC02: //Retrieving origin, dest multi-Combo
                formObj.f_cmd.value=SEARCH01;
                var param="f_cmd=" + formObj.f_cmd.value + "&svc_scp_cd=" + formObj.svc_scp_cd.GetSelectCode();
                var sXml=sheet1.GetSearchData("ESM_PRI_4009GS.do", param);
                var arrData=ComPriXml2Array(sXml, "rgn_cd|rgn_nm|org_dest_cd"); //"☜☞"
                var arrRow;
                var comboOrgRgnCd=formObj.org_rgn_cd;
                var comboDestRgnCd=formObj.dest_rgn_cd;
                comboOrgRgnCd.RemoveAll();
                comboDestRgnCd.RemoveAll();
                comboOrgRgnCd.InsertItem(0, "", "");
                comboDestRgnCd.InsertItem(0,  "", "");
                for(var i=0; i < arrData.length; i++) {
                    arrRow=arrData[i];
                    if(arrRow[2] == "O") {
                        comboOrgRgnCd.InsertItem(-1, arrRow[0] + "|" + arrRow[1], arrRow[0]);
                    } else if (arrRow[2] == "D") {
                        comboDestRgnCd.InsertItem(-1, arrRow[0] + "|" + arrRow[1], arrRow[0]);
                    }
                }
                break;
            /* S/C NO
            case IBSEARCH_ASYNC04: 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH04;
                sheet1.SetCellValue(gCurrRow1, "sc_no","",0);
	 			var sXml=sheet1.GetSearchData("ESM_PRI_4009GS.do", "f_cmd=" + formObj.f_cmd.value + "&sc_no=" + gScNo );
                var chkScNo=ComGetEtcData(sXml, "SC_NO");
                if(chkScNo.length > 0 && gScNo == chkScNo) {
                    sheet1.SetCellValue(gCurrRow1, "sc_no",chkScNo,0);
                } else {
                    sheet1.SetCellValue(gCurrRow1, "sc_no","",0);
                    ComShowCodeMessage("PRI02014");
                }
                ComOpenWait(false);
                break;
             */
            case IBSEARCH_ASYNC05: //Retrieving RFA NO 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH05;
                sheet1.SetCellValue(gCurrRow1, "sc_no","",0);
                var sXml=sheet1.GetSearchData("ESM_PRI_4009GS.do", "f_cmd=" + formObj.f_cmd.value + "&rfa_no=" + gRfaNo );
                var chkRfaNo=ComGetEtcData(sXml, "RFA_NO");
                if(chkRfaNo.length > 0 && gRfaNo == chkRfaNo) {
                    sheet1.SetCellValue(gCurrRow1, "sc_no",chkRfaNo,0);
                } else {
                    sheet1.SetCellValue(gCurrRow1, "sc_no","",0);
                    ComShowCodeMessage("PRI02015");
                }
                ComOpenWait(false);
                break;
            case IBINSERT: //Row Add
                var idx=sheet1.DataInsert();
                sheet1.SetCellValue(idx, "cmpn_seq",getMaxCmpnSeq());
                sheet1.CellComboItem(idx,"org_rgn_cd", {ComboText:"", ComboCode:""} );
                sheet1.CellComboItem(idx,"dest_rgn_cd", {ComboText:"", ComboCode:""} );
                sheet1.SelectCell(idx, "svc_scp_cd", true);
                break;
            case IBDELETE: //Delete
                deleteRowCheck(sheet1, "chk", true);
                break;
            case IBSAVE:   //Save
                ComOpenWait(true);
                if (!validateForm(sheet1, form, IBSAVE)) {
                    return;
                }
                if (!ComPriConfirmSave()) {
                    return;
                }
                formObj.f_cmd.value=MULTI; //7
                var param="f_cmd=" + formObj.f_cmd.value;
                sheet1.DoSave("ESM_PRI_4009GS.do", param, -1, false);
                ComOpenWait(false);
                break;
        }
    }
    /**
     *  sheet1_OnChange event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {IBSheet} Row 
     * @param  {IBSheet} Col 
     * @param  {IBSheet} Value
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
        var form=document.form;
        var colName=sheet1.ColSaveName(Col);
        switch (colName) {
            case "svc_scp_cd":
                var colValue=Value;
                colValue=colValue.replace(/ /g,"");
                if(colValue == "") {
                    sheet1.CellComboItem(Row,"org_rgn_cd", {ComboText:"", ComboCode:""} );
                    sheet1.CellComboItem(Row,"dest_rgn_cd", {ComboText:"", ComboCode:""} );
                    return;
                }
                gSvcScpCd=colValue;
                sheetObj.SetWaitImageVisible(0);
                doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01);
                sheet1.CellComboItem(Row,"org_rgn_cd", {ComboText:gRgnNmS, ComboCode:gRgnCdS} );
                sheet1.CellComboItem(Row,"dest_rgn_cd", {ComboText:gDestNmS, ComboCode:gDestCdS} );
                break;
            case "sc_no":
                var colValue=Value;
                colValue=colValue.replace(/ /g,"");
                var valueLen=colValue.length;
                gCurrRow1=Row;
                /* S/C NO 
                if(valueLen < 10) {
                    gScNo=colValue;
                    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC04);
                } else {
                    //} else if(valueLen == 10) {
                    gRfaNo=colValue;
                    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC05);
                }
                */
                /* else { 
	                sheet1.SetCellValue(Row, "sc_no","",0);
	                ComShowCodeMessage("PRI02013");
	                return;
	            }
                 */
                if(valueLen > 9) {
                	gRfaNo=colValue;
                    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC05);
                } else {
                	sheet1.SetCellValue(Row, "sc_no","",0);
                	sheet1.SelectCell(Row, Col);
                }
                break;
            case "eff_dt":
            case "exp_dt":
            	var effDt=sheet1.GetCellValue(Row, "eff_dt");
            	var expDt=sheet1.GetCellValue(Row, "exp_dt");
                if(effDt != "" && expDt != "") {
                    if(effDt >= expDt) {
                        ComShowCodeMessage("PRI00321","Expiration Date","Effective Date");
                        sheet1.SelectCell(Row, colName, true);
                        sheet1.SetCellValue(Row, colName,"",0);
                        return false;
                    }
                }
                break;
        }
    }
    /**
     * sheet1_OnAfterEdit event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {Long} Row : Cell's Row Index
     * @param  {Long} Col : Cell's Column Index
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
        var colName=sheet1.ColSaveName(Col);
        switch (colName) {
            case "curr_cd":
            	var colValue=sheet1.GetCellValue(Row, "curr_cd");
                colValue=colValue.replace(/ /g,"");
                var orgCurrCd=sheet1.CellSearchValue(Row, "curr_cd").replace(/ /g,"");
                if(colValue != "") { // inputting dc_amt 
                    sheet1.SetCellValue(Row, "dc_per","",0);
                    sheet1.SetCellEditable(Row, "dc_per",0);
                    sheet1.SetCellEditable(Row, "dc_amt",1);
                    if(colValue == orgCurrCd) {
                        sheet1.SetCellValue(Row, "dc_amt",sheet1.CellSearchValue(Row, "dc_amt"),0);
                    }else{
                        sheet1.SetCellValue(Row, "dc_amt","",0);
                    }
                    sheet1.SelectCell(Row, "dc_amt", true);
                }else{ // inputting dc_per
                    sheet1.SetCellValue(Row, "dc_amt","",0);
                    sheet1.SetCellEditable(Row, "dc_amt",0);
                    sheet1.SetCellEditable(Row, "dc_per",1);
                    if(colValue == orgCurrCd) {
                        sheet1.SetCellValue(Row, "dc_per",sheet1.CellSearchValue(Row, "dc_per"),0);
                    }else{
                        sheet1.SetCellValue(Row, "dc_per","",0);
                    }
                    sheet1.SelectCell(Row, "dc_per", true);
                }
                break;
        }
    }
    /**
     * sheet1_OnClick event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {IBSheet} Row
     * @param  {IBSheet} Col 
     * @param  {IBSheet} Value : 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        //showing memopad in case of clicking desc column (MemoPad editable)
        var colName=sheet1.ColSaveName(Col);
        switch (colName) {
            case "cmpn_rmk":
                ComShowMemoPad(sheet1,null,null,null,200,180,500);
                break;
        }
    }
    /**
     * OnSearchEnd event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
        if (errMsg == "") {
            var chkCurrCd;
            var startRow=sheet1.HeaderRows();
            var endRow = sheet1.HeaderRows() + sheet1.RowCount();
            for(var i=startRow; i < endRow; i++ ) {
            	chkCurrCd=sheet1.GetCellValue(i,"curr_cd").replace(/ /g,"");
                if(chkCurrCd == "") {
                    sheet1.SetCellEditable(i, "dc_amt",0);
                    sheet1.SetCellEditable(i, "dc_per",1);
                } else {
                    sheet1.SetCellEditable(i, "dc_amt",1);
                    sheet1.SetCellEditable(i, "dc_per",0);
                }
                sheet1.SetCellBackColor(i, "cmpn_rmk", "#000000");
            }
        }
    }
    /**
     * Calling function in case of OnSaveEnd Event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Selection, message after saving
     * @returns N/A
     * @author 
     * @version 2010.04.29
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }
    /**
     * Getting max seq<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return int maxSeq
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function getMaxCmpnSeq() {
        var maxSeq=0; cmpnSeq=0;
        var startRow=sheet1.HeaderRows();
        var endRow = sheet1.HeaderRows() + sheet1.RowCount();
        for(var i=startRow; i < endRow; i++ ) {
        	cmpnSeq=parseInt(sheet1.GetCellValue(i,"cmpn_seq"),10);
            if(cmpnSeq > maxSeq) {
                maxSeq=cmpnSeq;
            }
        }
        return maxSeq + 1;
    }
    /**
     * handling process for input validation<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function validateForm(sheetObj, formObj, sAction){
        switch (sAction) {
            case IBSAVE: //저장
                if (sheet1.IsDataModified()) {
                    var chkCurrCd, chkDcAmt, chkDcPer;
                    var startRow=sheet1.HeaderRows();
                    var endRow = sheet1.HeaderRows() + sheet1.RowCount();
                    var rowStatus;
                    for(var i=startRow; i < endRow; i++ ) {
                    	rowStatus=sheet1.GetRowStatus(i);
                        if(rowStatus != "D") {
							chkSvcScpCd=sheet1.GetCellValue(i,"svc_scp_cd").replace(/ /g,"");
							chkScNo=sheet1.GetCellValue(i,"sc_no");
							chkESVCType=sheet1.GetCellValue(i,"prc_esvc_tp_cd_w") + sheet1.GetCellValue(i,"prc_esvc_tp_cd_e") + sheet1.GetCellValue(i,"prc_esvc_tp_cd_d");
							chkCurrCd=sheet1.GetCellValue(i,"curr_cd").replace(/ /g,"");
							chkChgCd=sheet1.GetCellValue(i,"chg_cd").replace(/ /g,"");
							chkDcAmt=sheet1.GetCellValue(i,"dc_amt");
							chkDcPer=sheet1.GetCellValue(i,"dc_per");
							chkEffDt=sheet1.GetCellValue(i,"eff_dt");
							chkExpDt=sheet1.GetCellValue(i,"exp_dt");
                            if(chkSvcScpCd == "") {
                                ComShowCodeMessage("PRI00337","Scope");
                                sheet1.SelectCell(i, "svc_scp_cd");
                                return false;
                            }
                            if(chkScNo == "") {
                                ComShowCodeMessage("PRI00335","RFA & S/C No");
                                sheet1.SelectCell(i, "sc_no");
                                return false;
                            }
                            if(chkESVCType == 0) {
                                ComShowCodeMessage("PRI00337","E-SVC Type");
                                sheet1.SelectCell(i, "prc_esvc_tp_cd_w");
                                return false;
                            }
                            if(chkChgCd == 0) {
                                ComShowCodeMessage("PRI00337","Charge");
                                sheet1.SelectCell(i, "chg_cd");
                                return false;
                            }
                            if(chkCurrCd == "") {
                                if(chkDcPer == 0 || chkDcPer == "" ) {
                                    ComShowCodeMessage("PRI00335","Percentage");
                                    sheet1.SelectCell(i, "dc_per", true);
                                    return false;
                                }
                            } else {
                                if(chkDcAmt == 0 || chkDcAmt == "") {
                                    ComShowCodeMessage("PRI00335","Amount");
                                    sheet1.SelectCell(i, "dc_amt", true);
                                    return false;
                                }
                            }
                            if(chkEffDt == "") {
                                ComShowCodeMessage("PRI00335","Effective Date");
                                sheet1.SelectCell(i, "eff_dt");
                                return false;
                            }
                            if(chkExpDt == "") {
                                ComShowCodeMessage("PRI00335","Expiration Date");
                                sheet1.SelectCell(i, "exp_dt");
                                return false;
                            }
                            if(chkEffDt >= chkExpDt) {
                                ComShowCodeMessage("PRI00321","Expiration Date","Effective Date");
                                sheet1.SelectCell(i, "exp_dt", true);
                                return false;
                            }
                        }
                    }
                    var dupRow=sheet1.ColValueDup("svc_scp_cd|org_rgn_cd|desc_rgn_cd|sc_no|chg_cd", false);
                    if(dupRow > 0) {
                        ComShowCodeMessage("PRI00302"); //in case of duplication
                        return false;
                    }
                } else {
                    ComShowCodeMessage("PRI00301"); //in case of not modifying
                    return false;
                }
                return true;
                break;
        }
    }