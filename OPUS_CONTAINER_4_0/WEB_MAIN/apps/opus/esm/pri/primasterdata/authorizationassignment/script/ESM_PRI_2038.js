/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2038.js
*@FileTitle  : RFA Authority Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================**/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    // Common Global Variable

    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.07.24
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
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                    break;
                case "btn_New":
                	//ComResetAll();
                    comboObjects[0].SetSelectIndex(-1);
                    formObject.svc_scp_nm.value="";
                    formObject.ofc_cd.value="";
                    comboObjects[1].RemoveAll();
                    sheetObject1.ShowTreeLevel(0, 1);
                    sheetObject2.RemoveAll();
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject2,formObject,IBSAVE);
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
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory, IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory, IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
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
     * @version 2009.07.24
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            for(var k=0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            var formObj=document.form;
            // Creating Service Scope Combo
            initIBComboItem();
            // Retrieving organization map
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            //doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01); //sheet2의 값을 받아와서 조회조건 자리에 셋팅함
            axon_event.addListenerForm('change', 'obj_change', formObj);
            axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
            axon_event.addListener ('keyup', 'obj_keyup', 'form');
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
     * Setting retrieved items to IBMultiCombo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.09.04
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }
    /**
     * Calling Function in case of OnChange event <br>
     * Retrieving user list by Office Code<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function obj_change () {
        try {
            var formObj=document.form;
            var srcName=ComGetEvent("name");
            var sheetObject1=sheetObjects[0];
            var sheetObject2=sheetObjects[1];
            var sheetObject3=sheetObjects[2];
            var comboObject1=comboObjects[0];
            var comboObject2=comboObjects[1];
            if (srcName == "ofc_cd") {
                if (formObj.ofc_cd.value == "") {
                    comboObject2.RemoveAll();
                    sheetObject2.RemoveAll();
                    // Retrieving all organization map
//                    doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                } else {
                    comboObject2.RemoveAll();
                    sheetObject2.RemoveAll();
                    var idx=sheetObject1.FindText("ofc_cd", formObj.ofc_cd.value);
                    if (idx != -1) {
                        sheetObject1.ShowTreeLevel(0,1);
                        // Tree에서 selection
                        sheetObject1.SelectCell(idx, "ofc_eng_nm");
                        doActionIBSheet(sheetObject3,formObj,IBSEARCH_ASYNC01);
                        if (comboObject1.GetSelectCode()!= "") {
                            // retrieving authority
                            doActionIBSheet(sheetObject2,formObj,IBSEARCH);
                        }
                    } else {
                    	ComShowCodeMessage ( 'COM132201', "User Office" );
                        formObj.ofc_cd.value="";
                        sheetObject1.SelectCell(1, "ofc_eng_nm");
                        sheetObject1.ShowTreeLevel(2, 1);
                    }
                }
            }
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
     * Calling funciton of OnKeyUp event<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return N/A
     * @author 
     * @version 2010.02.04
     */
    function obj_keyup () {
//        try {
//            var formObj=document.form;
//            var sheetObject2=sheetObjects[1];
//            var srcName=ComGetEvent("name");
//            if (event.keyCode == 13) {
//                if (srcName == "ofc_cd") {
//                    document.body.focus();
//                } else {
//                    doActionIBSheet(sheetObject2, formObj, IBSEARCH);
//                }
//            }
//        } catch(e) {
//            if( e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e.message);
//            }
//        } finally {
//            ComOpenWait(false);
//        }
    }
    /**
     * Calling funciton of OnBlur event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function obj_deactivate() {
        ComChkObjValid(event.srcElement);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, IBSheet Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1: // sheet1 init
                with(sheetObj){		                
		              //if (location.hostname != "")
		              //no support[check again]CLT InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle="||Name||";
		              var headCount=ComCountHeadTitle(HeadTitle);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Left",    ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ofc_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TreeCol:1 ,  LevelSaveName:"slevel" },
		                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"prnt_ofc_cd" },
		                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"ofc_cd" } ];
		               
		              InitColumns(cols);		
		              SetEditable(0);
		              SetWaitImageVisible(0);
		              SetCountPosition(0);
		              SetRowHidden(0, 1);
                      //InitTreeInfo(2, "slevel", "#0000FFNAN");
		              resizeSheet();//SetSheetHeight(400);
		              //no support[implemented common]CLT GridLine=0;
              	}
                break;
            case 2:      // sheet1 init
                with(sheetObj){		                
		              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle="|ID|Name|Title|Authority|Effective Date|";
		              var headCount=ComCountHeadTitle(HeadTitle);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:"usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"grd_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"auth_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColProperty("auth_flg", {ComboText:"YES|NO", ComboCode:"Y|N"} );
		              resizeSheet();//SetSheetHeight(400);
                }
                break;
            case 3:     // Hidden sheet for Transaction
                with(sheetObj){
		              //if (location.hostname != "")
		              //no support[check again]CLT InitHostInfo(location.hostname, location.port, page_path);
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
    function resizeSheet(){ ComResizeSheet(sheetObjects[1]); ComResizeSheet(sheetObjects[0]); }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {int} comboNo Mandatory, IBMultiCombo Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
            case "usr_id":
                with (comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(0);
                    //no support[check again]CLT ValidChar(1, 3);
                }
                break;
        }
    }
    /**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process Flag constant variable
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH_ASYNC01:            	
                comboObjects[1].RemoveAll();
                formObj.f_cmd.value=SEARCH03;                 
                var sXml=sheetObj.GetSearchData("ESM_PRI_2038GS.do", FormQueryString(formObj));
                
                ComPriXml2ComboItem(sXml, usr_id, "usr_id", "usr_id|usr_nm");
                getComboObject(comboObjects, "usr_id").InsertItem(0, '', '');
                break;
            case IBSEARCH:                
                if (validateForm(sheetObj,formObj,sAction)) {
                	ComOpenWait(true);
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH01;                         
                        sheetObj.DoSearch("ESM_PRI_2038GS.do", FormQueryString(formObj) );
                    } else if(sheetObj.id == "sheet2") {
                        formObj.f_cmd.value=SEARCH02;                         
                        sheetObj.DoSearch("ESM_PRI_2038GS.do", FormQueryString(formObj) );
                    }
                }
                ComOpenWait(false);
                break;
            case IBSAVE:                
                if (validateForm(sheetObj,formObj,sAction)) {
                	ComOpenWait(true);
                    if(sheetObj.id == "sheet2"){
                        if (!ComPriConfirmSave()) {
                            return;
                        }
                        formObj.f_cmd.value=MULTI;
                        sheetObj.DoSave("ESM_PRI_2038GS.do", FormQueryString(formObj), -1, false);
                    }
                }
                ComOpenWait(false);
                break;
        }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         handling logic;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process Flag constant variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2009.07.24
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction){
            case IBSAVE:
                if(sheetObj.id == "sheet2") {
                    for(var i=1, n=sheetObj.RowCount(); i <= n; i++) {
                    	if (sheetObj.GetCellValue(i, "auth_flg") == "Y" && sheetObj.GetCellValue(i, "eff_dt") == "") {
                            ComShowCodeMessage('PRI01001');
                            sheetObj.SelectCell(i,"eff_dt");
                            return false;
                        }
                    }
                }
                break;
            case IBSEARCH:
                if(sheetObj.id == "sheet2") {
                    if (comboObjects[0].GetSelectCode()== "") {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }
                    if (formObj.ofc_cd.value == "") {
                        // ComShowCodeMessage('PRI01001');
                        ComShowCodeMessage('PRI00316', 'User Office');
                        formObj.ofc_cd.focus();
                        return false;
                    }
                }
    			if ( sheetObjects[1].IsDataModified()) {
                	if ( ComShowCodeConfirm("PRI00010") ) {
                		return true;
                	}else {
                		return false;
                	}				
    			}
                break;
        }
        return true;
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Expanding nodes after retrieving<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg selection
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            sheetObj.ShowTreeLevel(2, 1);
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * making effective date diable in case of no authority after retrieving<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg selection
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        var comboObj=comboObjects[1];
        for (var i=1, n=sheetObj.RowCount(); i <= n; i++) {
        	if (sheetObj.GetCellValue(i, "auth_flg") == "N") {
                sheetObj.SetCellEditable(i, "eff_dt",0);
            }
        	if (sheetObj.GetCellValue(i, "usr_id") == comboObj.GetSelectCode()) {
                sheetObj.SelectCell(i, "usr_nm");        		
            }
        }
    }
    /**
     * Calling Function in case of OnChange event <br>
     * if Authority= 'YES',Effective date : enable. other,Effective date : disable<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} Row Mandatory, OnChange ,Cell's Row Index
     * @param {int} Col Mandatory, OnChange ,Cell's Column Index
     * @param {string} Value Mandatory, ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.24
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "auth_flg":
                if (Value == "Y") {
                    sheetObj.SetCellEditable(Row, "eff_dt",1);
                } else {
                    sheetObj.SetCellEditable(Row, "eff_dt",0);
                    sheetObj.SetCellValue(Row, "eff_dt","");
                }
                break;
        }
    }
    /**
     * Calling function in case of Onclick event <br>
     * Expanding nodes after retrieving<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTMLtag(Object) Object
     * @param {int} Row Mandatory, Onclick ,Cell's Row Index
     * @param {int} Col Mandatory, Onclick ,Cell's Column Index
     * @param {string} Value Mandatory, ,Cell's Value
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function sheet1_OnClick (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "ofc_eng_nm":
                try {
                    var formObj=document.form;
                    formObj.ofc_cd.value=sheetObj.GetCellValue(Row, "ofc_cd");
                    doActionIBSheet(sheetObjects[2],formObj,IBSEARCH_ASYNC01);
                    if (comboObjects[0].GetSelectCode()!= "") {
                        doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
                    }
                } catch(e) {
                    if( e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e.message);
                    }
                } finally {
                    ComOpenWait(false);
                }
                break;
        }
    }
    /**
     * Calling function in case of Onclick event <br>
     * Calling User Info Popup<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTMLtag(Object) Object
     * @param {int} Row Mandatory, Onclick ,Cell's Row Index
     * @param {int} Col Mandatory, Onclick ,Cell's Column Index
     * @param {string} Value Mandatory, ,Cell's Value
     * @returns N/A
     * @author 
     * @version 2009.09.18
     */
    function sheet2_OnClick (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "usr_id":
                if (Value != "") {
                    ComUserPopup(Value);
                }
                break;
        }
    }
    /**
     * IBCombo에서 Calling Function in case of OnChange event <br>
     * Showing description by svc_scp_cd value <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {string} code Mandatory, selectied  value
     * @param {string} text Mandatory, selectied  text
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */   
    function svc_scp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var codeText = comboObj.GetText(NewCod, 1);
        
        if(codeText != null  && codeText != 'undefind' && codeText != "") {
        	formObj.svc_scp_nm.value=codeText;
        } else {
        	comboObj.SetSelectIndex(-1, true);
        	formObj.svc_scp_nm.value="";
        }
    }
    /**
     * calling function in case of OnClear event of IBMultiCombo <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function svc_scp_cd_OnClear (comboObj) {
        var formObj=document.form;
        formObj.svc_scp_nm.value="";
        svc_scp_cd.SetSelectIndex(-1,false);
    }
    /**
     * calling function in case of OnBlur event of IBMultiCombo  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj=document.form;         
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
        if (code != null && code != "" && code != "-1") {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
            }
        }
    }
    /**
     * Calling Function in case of OnChange event <br>
     * showing user name according to usr_id value <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {string} code Mandatory, selected value
     * @param {string} text Mandatory, selected text
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function usr_id_OnChange (comboObj, code, text) {
        var formObj=document.form;
        var sheetObj=sheetObjects[1];
        var arrText=text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.usr_nm.value=arrText[1];
        } else {
            formObj.usr_nm.value="";
        }
        for (var i=1, n=sheetObj.RowCount(); i <= n; i++) {
        	if (sheetObj.GetCellValue(i, "usr_id") == comboObj.GetSelectCode()) {
                sheetObj.SelectCell(i, "usr_nm");
                break;
            }
        }
    }
    /**
     * calling function in case of OnBlur event of IBMultiCombo <br>
     * showing description according to usr_id value. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns N/A
     * @author 
     * @version 2009.08.17
     */
    function usr_id_OnBlur (comboObj) {
        var formObj=document.form;         
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != "") {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.usr_nm.value) {
                formObj.usr_nm.value=comboObj.GetText(code, 1);
            }
        } else {
            formObj.usr_nm.value="";
        }
    }
    /**
     * calling function in case of OnClear event of IBMultiCombo<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns N/A
     * @author 
     * @version 2009.07.24
     */
    function usr_id_OnClear (comboObj) {
        var formObj=document.form;
        formObj.usr_nm.value="";
        usr_id.SetSelectIndex(-1,false);
    }
    