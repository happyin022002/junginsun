/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0013.js
*@FileTitle  : S/C & TRI Authority Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

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
        //var sheetObject1 = sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        //var sheetObject3 = sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
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
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
        try {
            // initializing IBMultiCombo
            for(var k=0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            var formObj=document.form;
            // Service Scope Combo 생성
            initIBComboItem ();
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            axon_event.addListenerForm('change', 'obj_change', formObj);
            axon_event.addListenerForm('blur', 'obj_deactivate', formObj);
            //axon_event.addListener ('keyup', 'obj_keyup', 'form');
            axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
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
     * setting IBMultiCombo with retrieved Combo Item<br>
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }
    
    /**
     * calling function when occurring OnChange Event <br>
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
                    doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                } else {
                    comboObject2.RemoveAll();
                    sheetObject2.RemoveAll();
                    var idx=sheetObject1.FindText("ofc_cd", formObj.ofc_cd.value);
                    if (idx != -1) {
                        sheetObject1.ShowTreeLevel(0,1);
                        sheetObject1.SelectCell(idx, "ofc_eng_nm");
                        doActionIBSheet(sheetObject3,formObj,IBSEARCH_ASYNC01);
                        doActionIBSheet(sheetObject2,formObj,IBSEARCH);
                    } else {
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
     * calling event when occurring OnKeyUp event <br>
     */
    function obj_keyup () {
        try {
            var formObj=document.form;
            var sheetObject2=sheetObjects[1];
            var srcName=ComGetEvent("name");
            if (event.keyCode == 13) {
                if (srcName == "ofc_cd") {
                    document.body.focus();
                } else {
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
     * calling function when occurring OnBlur event <br>
     */
    function obj_deactivate() {
        ComChkObjValid(event.srcElement);
        
        var formObj=document.form;
        var code=svc_scp_cd.GetSelectText();
        var text=svc_scp_cd.GetText(code, 1);
        setSvcCdCombo(svc_scp_cd, code, text);
    }
    
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
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
//                  InitTreeInfo(2, "slevel", "#0000FFNAN";
            		resizeSheet();//SetSheetHeight(400);
              	}
                break;
            case 2:      // sheet1 init
                with(sheetObj){
            		var HeadTitle="ID|Name|Title|Svc Scope|Effective Date|Authorized By|Update Date||";
            		var headCount=ComCountHeadTitle(HeadTitle);

            		SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 ,  PrevColumnMergeMode:0} );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"grd_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:220,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetWaitImageVisible(0);
            		resizeSheet();//SetSheetHeight(400);
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
            case IBSEARCH_ASYNC01: 
                comboObjects[1].RemoveAll();
                formObj.f_cmd.value=SEARCH03;
//parameter changed[check again]CLT
                var sXml=sheetObj.GetSearchData("ESM_PRI_0013GS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, usr_id, "usr_id", "usr_id|usr_nm");
                getComboObject(comboObjects, "usr_id").InsertItem(0, '', '');
                break;
            case IBSEARCH:      //retrieve
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
                        sheetObj.DoSearch("ESM_PRI_0013GS.do", FormQueryString(formObj) );
                    } else if(sheetObj.id == "sheet2") {
                        formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT
                        sheetObj.DoSearch("ESM_PRI_0013GS.do", FormQueryString(formObj) );
                    }
                }
                ComOpenWait(false);
                break;
        }
    }
    
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction){
            case IBSEARCH:
                if(sheetObj.id == "sheet2") {
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
     * calling function when occurring OnSearchEnd Event <br>
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            sheetObj.ShowTreeLevel(1, 1);
        }
    }
    
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        var comboObj=comboObjects[1];
        for (var i=1, n=sheetObj.RowCount(); i <= n; i++) {
        	if (sheetObj.GetCellValue(i, "usr_id") == comboObj.GetSelectCode()) {
                sheetObj.SelectCell(i, "usr_nm");
                break;
            }
        }
    }
    
    /**
     * calling function when occurring OnClick Event <br>
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
                    doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
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
     * calling function when occurring OnClick Event <br>
     */
    function sheet2_OnClick (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch (colname) {
            case "usr_id":
                if (Value != "") {
                    ComUserPopup(Value);
                }
                break;
        }
    }
    
    /**
     * IBCombo에서 calling function when occurring OnChange Event <br>
     */
    function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
    	setSvcCdCombo(comboObj, code, text);
    }
    
    /**
     * set service code and name Event <br>
     */
    function setSvcCdCombo(comboObj, text, code) {
    	var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != -1) {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
            }
        }
        
        if(code == "" && text == "") {
      	  svc_scp_cd_OnClear(comboObj);
        }
    }
    
    /**
     * calling function when occurring IBMultiCombo OnClear Event <br>
     */
    function svc_scp_cd_OnClear (comboObj) {
        var formObj=document.form;
        formObj.svc_scp_nm.value="";
//        comboObj.SetSelectIndex(-1,false);
    }
    
    /**
     * IBCombo에서 calling function when occurring OnChange Event <br>
     */
    function usr_id_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != -1) {
		    var text=comboObj.GetText(code, 1);
		    if (text != null && text != "" && text != formObj.usr_nm.value) {
		        formObj.usr_nm.value=comboObj.GetText(code, 1);
			}
	        var sheetObj=sheetObjects[1];
	        var b=false;
	        for (var i=1, n=sheetObj.RowCount(); i <= n; i++) {
	        	if (sheetObj.GetCellValue(i, "usr_id") == comboObj.GetSelectCode()) {
	                sheetObj.SelectCell(i, "usr_nm");
	                b=true;
	                break;
	            }
	        }
	        if (!b && comboObj.GetSelectCode()!= "") {
	            ComShowCodeMessage('PRI00013');
	        }
		} else {
		    formObj.usr_nm.value="";
		}
		
		if(code == "" && text =="") {
			formObj.usr_nm.value="";
		}
    }
    
    /**
     * calling function when occurring IBMultiCombo OnBlur Event <br>
     */
    function usr_id_OnBlur (comboObj) {
    }
    
    /**
     * calling function when occurring IBMultiCombo OnClear Event <br>
     */
    function usr_id_OnClear (comboObj) {
        var formObj=document.form;
        formObj.usr_nm.value="";
//        comboObj.SetSelectIndex(-1,false);
    }
