/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0009.js
*@FileTitle  : S/C & TRI Authority Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    // common global variables
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
     * processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function processButtonClick(){
        /*      When the number of sheet is two or more on each tab, additional sheet variable should be defined *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                    break;
                case "btn_New":
                    //comboObjects[].SetSelectCode("");
                	svc_scp_cd.SetSelectCode(-1);
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
     * Afterward, when other items should be process in batch, you could add process putting in array 
     * the array defined at the top of this page
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj - Mandatory, IBSheet Object
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * Register IBMultiCombo Object as item of array 
     * Afterward, when other items should be process in batch, you could add process putting in array 
     * the array defined at the top of this page
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj - Mandatory, IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /**
     * Initialize and basic option setting Sheet
     * implementing onLoad event handler in body tag <br>
     * Adding the code that should be preprocessed after loading the screen in browser.
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                // Modifying the Environment setting function name
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                // Adding the Environment Setting function
                ComEndConfigSheet(sheetObjects[i]);
            }
            // IBMultiCombo Initialize
            for(var k=0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            var formObj=document.form;
            // Service Scope Combo Creation
            initIBComboItem ();
            // Organization Map retrieve
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            axon_event.addListenerForm('change', 'obj_change', formObj);
            axon_event.addListenerForm('blur', 'obj_deactivate', formObj);//deactivate
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
     * Setting the IBMultiCombo Object using combo item that retrieved  at the open event code
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return void
     * @author 
     * @version 2009.09.04
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }
    
    /**
     * The function called when OnChange event triggered
     * When Office Code is modified, the program should retrieve Organization Map, Employee Combobox Item and User privilege List
     * <br><b>Example :</b>
     * <pre>
     *     obj_change ();
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.02
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
                comboObject2.RemoveAll();
                sheetObject2.RemoveAll();
                if (formObj.ofc_cd.value == "") {
                    // When Office code is zero-length string, whole organization map retrieve
                    doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                } else {
                    var idx=sheetObject1.FindText("ofc_cd", formObj.ofc_cd.value);
                    if (idx != -1) {    //  when the user input Office code exist in organization map
                        // Expand to node that include the office code on organization map 
                        sheetObject1.ShowTreeLevel(0,1);
                        // Choose an item in organization map
                        sheetObject1.SelectCell(idx, "ofc_eng_nm");
                        // Retrieve Employee Combo item
                        doActionIBSheet(sheetObject3,formObj,IBSEARCH_ASYNC01);
                        if (comboObject1.GetSelectCode()!= "") {
                            // Retrieve User Privilege List
                            doActionIBSheet(sheetObject2,formObj,IBSEARCH);
                        }
                    } else {    // when the user input Office code is not exist in organization map
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
     * The function called when OnKeyUp event triggered
     * When Enter Key Pressed, The program call Retrieve function
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return void
     * @author 
     * @version 2010.02.04
     */
    function obj_keyup() {
        try {
            var formObj=document.form;
            var sheetObject2=sheetObjects[1];
            var srcName=ComGetEvent("name");
            if (event.keyCode == 13) {
                if (srcName == "ofc_cd") {
                    //When Enter Key pressed at Office Code, move the focus by force, it makes triggering other event
                    document.body.focus();
                } else {
                    // When Enter Key pressed at other than Office Code, it makes calling the Retrieve Function.
                    doActionIBSheet(sheetObject2, formObj, IBSEARCH);
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
     * The function called when OnBlur event triggered
     * When Office Code submitted, The program Retrieve User List in Office submitted
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function obj_deactivate() {
        ComChkObjValid(event.srcElement);
    }
    
    /**
     * Sheet Initialize, Header Definition
     * When Sheet is plural, compose sheet initialize module via adding case-statement
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, Sequence No. of IBSheet Object Tag ID
     * @param {int} sheetNo Mandatory, Sequence No. of IBCombo Object
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1: // sheet1 init
            	with(sheetObj){
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
//	        		InitTreeInfo(2, "slevel", "#0000FFNAN";
	        		resizeSheet();//SetSheetHeight(470);//resizeSheet();//SetSheetHeight(420);
	                //SetSheetWidth(550);
	        	}
	            break;
            case 2:      // sheet1 init 
            	with(sheetObj){
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
            		SetColProperty("auth_flg", {ComboText:authFlgText, ComboCode:authFlgValue} );
            		resizeSheet();//SetSheetHeight(470);//resizeSheet();//SetSheetHeight(420);
            		//SetSheetWidth(620);
            	}
            	break;
            case 3:     // Hidden sheet for Transaction
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
    function resizeSheet(){ ComResizeSheet(sheetObjects[1]); ComResizeSheet(sheetObjects[0]); }
    
    /**
	 * Combobox Initialize, Header Definition
     * When Combobox is plural, compose combobox initialize module via adding case-statement <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID 
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                    ValidChar(2);
                }
                break;
            case "usr_id":
                with (comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(1,3);
                }
                break;
        }
    }
    
    /**
     * Operate Sheet Process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, Process flag constant
     * @return void
     * @author 
     * @version 2009.06.02
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH_ASYNC01: // When Office Code inputted, Retrieve Employee ComboBox Item List 
                comboObjects[1].RemoveAll();
                formObj.f_cmd.value=SEARCH03;
//parameter changed[check again]CLT
                var sXml=sheetObj.GetSearchData("ESM_PRI_0009GS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, usr_id, "usr_id", "usr_id|usr_nm");
                getComboObject(comboObjects, "usr_id").InsertItem(0, '', '');
                break;
            case IBSEARCH:      //Retrieving // Main retrieve
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
                        sheetObj.DoSearch("ESM_PRI_0009GS.do", FormQueryString(formObj) );
                    } else if(sheetObj.id == "sheet2") {
                        formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT
                        sheetObj.DoSearch("ESM_PRI_0009GS.do", FormQueryString(formObj) );
                    }
                }
                ComOpenWait(false);
                break;
            case IBSAVE:         // Save
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (!ComPriConfirmSave()) {
                        return;
                    }
                    formObj.f_cmd.value=MULTI;
                    sheetObj.DoSave("ESM_PRI_0009GS.do", FormQueryString(formObj), -1, false);
                }
                ComOpenWait(false);
                break;
        }
    }
    
    /**
     * Operate validation process on user input value of form object <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic process;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, Process flag constant
     * @returns bool <br>
     *          true  : Valid. Pass the Validation Rule <br>
     *          false : inValid Violate the Validation Rule
     * @author 
     * @version 2009.06.02
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
            case IBSEARCH:
                if(sheetObj.id == "sheet2") {
                    if (comboObjects[0].GetSelectCode()== "") {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }
                    if (formObj.ofc_cd.value == "") {
                        ComShowCodeMessage('PRI00316', 'User Office');
                        formObj.ofc_cd.focus();
                        return false;
                    }
                }
                break;
        }
        return true;
    }
    
    /**
     * The function called when OnSearchEnd event triggered
     * After sheet has retrieved, expand the node <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Optional, Message
     * @returns void
     * @author 
     * @version 2009.06.03
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
       //     sheetObj.ShowTreeLevel(2, 1);
            sheetObj.ShowTreeLevel(1, 1);
        }
    }
    
    /**
     * The function called when OnSearchEnd event triggered
     * After sheet has retrieved, effective date of unauthorized item makes disabled <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Optional, Message 
     * @returns void
     * @author 
     * @version 2009.06.03
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
     * The function called when OnChange event triggered
     * When Authority Option is 'YES', Effective Date makes enabled, not in case, makes disabled. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} Row Mandatory, Row Index of the Cell that Onchange Event Trigged
     * @param {int} Col Mandatory, Column Index of the Cell that Onchange Event Trigged
     * @param {string} Value Mandatory,  Value of the Cell that Event Trigged
     * @return void
     * @author 
     * @version 2009.06.03
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname) {
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
     * The function called when OnClick event triggered
     * When Organization Name has clicked in Organization Map, Retrieve employee's User privilege info.  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTML Tag(Object)             // HTML Tag Object
     * @param {int} Row Mandatory,  Row Index of the Cell that Onchange Event Trigged
     * @param {int} Col Mandatory, Column Index of the Cell that Onchange Event Trigged
     * @param {string} Value Mandatory, Value of the Cell that Event Trigged
     * @returns void 
     * @author 
     * @version 2009.06.03
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
     * The function called when OnDblClick event triggered
     * When User ID on sheet has clicked, Open User Info Popup <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTML Tag(Object)              // HTML Tag Object                                     
     * @param {int} Row Mandatory,  Row Index of the Cell that Onchange Event Trigged   
     * @param {int} Col Mandatory, Column Index of the Cell that Onchange Event Trigged
     * @returns void
     * @author 
     * @version 2009.09.18
     */
    function sheet2_OnDblClick (sheetObj, Row, Col) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname) { 
            case "usr_id":
            	if (sheetObj.GetCellValue(Row,Col) != "") {
            		ComUserPopup(sheetObj.GetCellValue(Row,Col));
                }
                break;
        }
    }
    
    /**
     * The function called when OnChange event on IBCombo triggered
     * when Service Scope Code ComboBox has changed, Show the Description of selected Service Scope Code. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {string} code Mandatory, Value of Selected Item
     * @param {string} text Mandatory, Text of Selected Item
     * @returns void
     * @author 
     * @version 2009.06.02
     */
    function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
    	var formObj=document.form;
		formObj.svc_scp_nm.value=ComPriGetNameFromComboVal(comboObj, code);
    }

    /**
     * The function called when OnClear event on IBMultiCombo triggered
     * when Service Scope Code ComboBox has cleared, Clear the Name of Service Scope Code. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns void
     * @author 
     * @version 2009.06.02
     */
//    function svc_scp_cd_OnClear (comboObj) {
//        var formObj=document.form;
//        formObj.svc_scp_nm.value="";
////        comboObj.SetSelectIndex(-1,false);
//    }
    
    /**
     * The function called when OnChange event on IBCombo triggered
     * when User ID ComboBox has changed, Show the Name of selected User ID. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {string} code Mandatory, Value of Selected Item
     * @param {string} text Mandatory, Text of Selected Item 
     * @returns void
     * @author 
     * @version 2009.06.02
     */
    function usr_id_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
        
        var formObj=document.form;
		formObj.usr_nm.value=ComPriGetNameFromComboVal(comboObj, code);
		
        var sheetObj=sheetObjects[1];
        for (var i=1, n=sheetObj.RowCount(); i <= n; i++) {
        	if (sheetObj.GetCellValue(i, "usr_id") == comboObj.GetSelectCode()) {
                sheetObj.SelectCell(i, "usr_nm");
                break;
            }
        }
        
    }
    
    
    /**
     * The function called when OnClear event on IBMultiCombo triggered
     * when User ID ComboBox has cleared, Clear the Name of User ID. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns void
     * @author 
     * @version 2009.06.02
     */
    function usr_id_OnClear (comboObj) {
        var formObj=document.form;
        formObj.usr_nm.value="";
        //comboObj.SetSelectIndex(-1,false);
    }
