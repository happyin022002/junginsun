/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4018.js
*@FileTitle  : Surcharge Location Group Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/6/24

=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_4018 : business script for ESM_PRI_4018   
     */

    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // var isNew = false;
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    var eventStatus="";
    /**
     * Event handler processing by button name  <br>
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
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;
                case "btn_new":
                    removeAll(document.form);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
	   	 var formObj=document.form;
		 doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	     if(formObj.pre_svc_scp_cd.value != "") {
	         comboObjects[0].SetSelectCode(formObj.pre_svc_scp_cd.value);
	         formObj.svc_scp_nm.focus();
	         comboObjects[1].SetSelectCode(formObj.pre_chg_cd.value);
	         ComSetFocus(comboObjects[1]);
	         ComSetFocus(comboObjects[0]);
	     }
	     
    }
    /**
     * initializing combo, header <br>
     * adding case in case of multiple combo <br>
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "svc_scp_cd":
                var i=0;
                with(comboObj) {
                    Style=0;
                    //BackColor = "cyan";
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
            case "chg_cd":
                var i=0;
                with(comboObj) {
                    Style=0;
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
        }
    }
    /**
     * svc_scp_cd's getting value <br>
     */ 
    function getSvcScpCd() {
        return comboObjects[0].GetSelectCode();
    }
    /**
     * chg_cd's getting value <br>
     * <br><b>Example :</b>
     * <pre>
     *		getSvcScpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.07.29
     */
    function getChgCd() {
        return comboObjects[1].GetSelectCode();
    } 
    /**
     * calling function when occurring OnChange Event from IBCombo <br>
     */
    //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

    function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
//        var arrText=newIndex.split("|");
        if (newCode != null && newCode.length > 1) {
            formObj.svc_scp_nm.value=comboObj.GetText(newCode, 1);
            formObj.chg_nm.value="";
            doActionIBSheet(sheet0, document.form, IBSEARCH);
        }
    }
    /**
     * calling function when occurring IBMultiCombo OnBlur Event <br>
     */
    function svc_scp_cd_OnBlur (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != -1) {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value=text;
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        } else {
            formObj.svc_scp_nm.value="";
            comboObj.SetSelectCode(-1,false);
        }
    }
    /**
     * IBCombo에서 calling function when occurring OnChange Event <br>
     */
    function chg_cd_OnChange (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	
    	var formObj=document.form;
    	var chgText=comboObj.GetSelectText();
    	if (chgText == null || chgText == "" || chgText == undefined) {
			return false;
		}
    	
    	if(newCode != "") { //select
    		formObj.chg_nm.value=comboObj.GetText(newCode, 1);
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	} else { //manual input
    		comboObj.SetSelectCode(-1,false);
    		formObj.chg_nm.value="";
    	}
    }
//    /**
//     * calling function when occurring IBMultiCombo OnBlur Event <br>
//     */
//    function chg_cd_OnBlur (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//        var formObj=document.form;
//        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
//        if (code != -1) {
//            var text=comboObj.GetText(code, 1);
//            if (text != null && text != "" && text != formObj.chg_nm.value) {
//                formObj.chg_nm.value=text;
//                doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
//            }
//        } else {
//            formObj.chg_nm.value="";
//            comboObj.SetSelectCode(-1,false);
//        }
//    }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      */
    function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
            case "sheet0":      //hidden 
                 with (sheetObj) {
            		SetVisible(false);
                 }
                 break; 
            case "sheet1":      //sheet1 init
                 with (sheetObj) {
	                var HeadTitle="Seq.|Group\nCode|Description|Creation\nDate|svc_scp_cd|chg_cd|grp_loc_seq";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, Sort:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scg_grp_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"scg_grp_loc_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetWaitImageVisible(0);
	                SetAutoRowHeight(0);
	                resizeSheet();//SetSheetHeight(338);
                }
            	break;
            case "sheet2":      //sheet2 init
                 with (sheetObj) {
	                var HeadTitle="Seq.|Location\nType|Code|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_loc_cd|grp_loc_dtl_seq";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, Sort:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                       {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"dtl_loc_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dtl_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetWaitImageVisible(0);
	                //SetAutoRowHeight(0);
	                resizeSheet();//SetSheetHeight(338);
                }
            	break;
         }
     }
    function resizeSheet(){ ComResizeSheet(sheetObjects[1]); ComResizeSheet(sheetObjects[2]); }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBCLEAR:
                // when screen loading Service Scope retrieving
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
                //common - type
                sheetObjects[2].SetColProperty("dtl_loc_tp_cd", {ComboText:LOCATION_TYPE3[1] , ComboCode:LOCATION_TYPE3[0]} );
                break;  
            case IBSEARCH:      //retrieve
                if (sheetObj.id == "sheet0") {
                    // Surcharge combo
                    formObj.f_cmd.value=COMMAND12;
                    formObj.etc1.value=getSvcScpCd();
                    sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                    ComPriXml2ComboItem(sXml, chg_cd, "cd", "cd|nm");
                } else {
                	ComOpenWait(true);
                    if (validateForm(sheetObj,document.form,sAction)) {
                        if ( sheetObj.id == "sheet1") {
                            for (var i=0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }    
                            formObj.f_cmd.value=SEARCH01;
                            if (formObj.pre_svc_scp_cd.value != "") {
                            	sheetObj.DoSearch("ESM_PRI_4029GS.do", FormQueryString(formObj) );
                            } else {
                            	sheetObj.DoSearch("ESM_PRI_4018GS.do", FormQueryString(formObj) );
                            }
                        }       
                        else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value=SEARCH02;
                            if (formObj.pre_svc_scp_cd.value != "") {
                            	sheetObj.DoSearch("ESM_PRI_4029GS.do", FormQueryString(formObj) );
                            } else {
                            	sheetObj.DoSearch("ESM_PRI_4018GS.do", FormQueryString(formObj) );
                            }
                        }   
                    }
                    ComOpenWait(false);
                }
                break;
         }
     }
    /**
     * checking validation process of inputed form data <br>
     */
     function validateForm(sheetObj,formObj,sAction){
          switch (sAction) {
            case IBSEARCH: // retrieve
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if (comboObjects[1].GetSelectCode()== "") {
                    ComPriInputValueFailed("Select","Charge","");
                    return false;
                }   
                return true;
                break;
            }
         return true;
     }
     /**
      * initializing screen object value <br>
      */
    function removeAll(formObj) {
        if (sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm=true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm=false;
            } else {
                comboObjects[0].SetSelectIndex("-1");
                comboObjects[1].SetSelectIndex("-1");
                formObj.reset();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {    
            comboObjects[0].SetSelectIndex("-1");
            comboObjects[1].SetSelectIndex("-1");
            formObj.reset();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
    }
    /**
     * initializing retrieving parameter <br>
     */
    function searchConditionReset(formObj) {
        comboObjects[1].SetSelectIndex("-1");
        formObj.chg_nm.value="";  
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
    }
    /**
	 * calling function when occurring OnSelectCell Event <br>
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
    }
    var isFiredNested=false;
    var supressConfirm=false;
    /**
	 * when occurring Row Change event<br>
	 */
    function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
        var formObj=document.form;
        var adjNewRow=NewRow;
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetM.IsDataModified()) {
                isFiredNested=true;
                sheetM.SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                if (validateForm(sheetM,document.form,IBSAVE)) {
                    isFiredNested=true;
                    sheetM.SelectCell(NewRow, NewCol, false);
                    isFiredNested=false;
                } else {
                    isFiredNested=true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (sheetD.IsDataModified()) {
                isFiredNested=true;
                sheetM.SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
                    var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                    isFiredNested=true;
                    sheetM.SelectCell(adjNewRow, NewCol, false);
                    isFiredNested=false;
                } else {
                    isFiredNested=true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (appendRow) {
                isFiredNested=true;
                var idx=sheetM.DataInsert();
                isFiredNested=false;
                return idx;
            } else {
                formObj.f_cmd.value=SEARCH02;
                formObj.grp_loc_seq.value=sheetM.GetCellValue(NewRow,"grp_loc_seq");
                if(formObj.grp_loc_seq.value == "undefined" || ComIsEmpty(formObj.grp_loc_seq.value)) {
                	formObj.grp_loc_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"grp_loc_seq");
                }
                if (formObj.pre_svc_scp_cd.value != "") {
                	sheetD.DoSearch("ESM_PRI_4029GS.do", FormQueryString(formObj) );
                } else {
                	sheetD.DoSearch("ESM_PRI_4018GS.do", FormQueryString(formObj) );
                }
            }
        }
    }
    /**
     * calling event when occurring OnBeforeCheck event from sheet1 <br>
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
        }
    }
    /**
     * calling event when occurring OnBeforeCheck event sheet2 <br>
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
        }
    } 
	/**
     * calling function when Page Loading <br>
     */ 

    /**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet1_OnSearchEnd(ErrMsg)  {
        //alert(sheetObjects[1].EtcData("max_seq"))
        //if (ErrMsg == "") {
            var formObj=document.form;
            formObj.max_seq.value=sheetObjects[1].GetEtcData("max_seq");
        //}
    }
