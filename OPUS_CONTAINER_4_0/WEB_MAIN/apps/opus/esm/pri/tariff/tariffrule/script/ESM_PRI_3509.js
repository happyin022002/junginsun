/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3509.js
*@FileTitle  : Tariff Rule History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name  <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return void
 * @author 
 * @version 2010.10.13
 */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_new":
                doActionIBSheet(sheetObject1,formObject,IBCREATE);
                break;
            case "btn_retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "btn_print":
                doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
                break;
            case "btn_amendcompare":
                doActionIBSheet(sheetObject2,formObject,MODIFY07);
                break;                  
            case "btn_calendar": //Calendar Button                                     
                var cal=new ComCalendar();
                cal.select(formObject.access_dt, 'yyyy-MM-dd');
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
* @param {ibsheet} sheet_obj mandatory IBSheet Object
* @return void
* @author 
* @version 2010.10.13
*/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
* registering IBCombo Object as list</b>
* adding process for list in case of needing batch processing with other items<br>
* defining list on the top of source <br>
* <br><b>Example :</b>
* <pre>
*     setComboObject(comboObj);
* </pre>
* @param {ibcombo} combo_obj Mandatory IBCombo Object
* @return void
* @author 
* @version 2010.10.13
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
* @return void
* @author 
* @version 2010.10.13
*/
function loadPage() {
    var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //Add Environment Setting Function
        ComEndConfigSheet(sheetObjects[i]);
    }
    //Initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    // Axon Event Initialize
    initControl();
    // Tariff Code Combo Setting
    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );  
    // It calls when moves on Inquiry window.
    if(formObj.trf_no.value != "") {
        var trfPfxCd=formObj.trf_pfx_cd.value;
        var trfNo=formObj.trf_no.value;
        var trfRuleNo=formObj.trf_rule_no.value;
        var trfCd=trfPfxCd + "-" + trfNo;           
        comboObjects[0].SetSelectCode(trfCd);
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);          
        var Row=sheetObjects[0].FindText("trf_rule_no", trfRuleNo);
        sheetObjects[0].SelectCell(Row, "trf_rule_no");
    }
    tariff_cd.Focus();   
    
}

/**
 * Catching events for Axon event.<br>
 * <br><b>Example :</b>
 * <pre>
 *     initControl()
 * </pre>
 * @param  void
 * @return void
 * @author 
 * @version 2010.10.13
 */         
 function initControl() {
    // Process Axon Event No.1, Event Catch             
    axon_event.addListenerForm('beforeactivate', 'obj_onActivate', document.form);
    axon_event.addListenerForm('beforedeactivate', 'obj_onDeactivate', document.form);
    //axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);  
    axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
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
 * @version 2010.10.13
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle="Flag|Seq.|Rule No.|Rule Name" +
                "|1|2";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                            {Type:"Text",      Hidden:0,  Width:600,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" } ];
                                                          
                InitColumns(cols);
                
                SetEditable(0);
                SetWaitImageVisible(0);
                SetSelectionMode(smSelectionRow);//1
                SetAutoRowHeight(0);
                SetSheetHeight(130);
            }

            break;
        case "sheet2":
            with(sheetObj){
                var HeadTitle="Flag|Sel.|Seq.|Amend\nNo.|Rule Name|Charge\nCode|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Status|Request\nOffice|Creation\nStaff|Approval\nOffice " + "|1|2|3|4|5|6";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk_diff"},
                            {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pub_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"trf_rule_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
      //                      {Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_rule_ctnt" } ];
                                                          
                InitColumns(cols);
                SetColProperty("trf_rule_sts_cd", {ComboText:trfRuleStsCdComboText, ComboCode:trfRuleStsCdComboValue} );
                
                SetEditable(1);
                SetWaitImageVisible(0);
                //SetAutoRowHeight(0);
                SetSheetHeight(130);
            }
            break;
    }
}

/**
* setting intial combo value <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} comboObj Mandatory IBMultiCombo Object
* @param {int} comboNo Mandatory IBMultiCombo's Serial No
* @return void
* @author 
* @version 2010.10.13
*/ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "tariff_cd":
            with(comboObj) {
                SetDropHeight(260);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(8);
                SetUseAutoComplete(1);
                ValidChar(2,3);
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
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @param {int} sAction mandatory,Constant Variable
* @return void
* @author 
* @version 2010.10.13
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    try {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {              
            case IBSEARCH: // retrieving
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                ComOpenWait(true);
                
                // modify
                sheetObjects[1].RemoveAll();
                formObj.rule_ctnt.value="";
                
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("ESM_PRI_3509GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                break;
            case IBSEARCHAPPEND: // Retrieving  
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH02;
                var sXml=sheetObj.GetSearchData("ESM_PRI_3509GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                break;
            case IBSEARCH_ASYNC01: // Print
//                if (!validateForm(sheetObj,document.form,sAction)) {
//                    return false;
//                }
                var sParam="trf_pfx_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                    + "&trf_no="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                    + "&amdt_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                    + "&trf_rule_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
                ComOpenPopup("ESM_PRI_3508.do?"+sParam,1024, 650, "", "1,0", true);
                break;
            case MODIFY07: // amendcompare
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                var checkedRows=sheetObj.FindCheckedRow("chk_diff");
                var arrCheckRows=checkedRows.split("|");
                var sUrl="/opuscntr/ESM_PRI_3599.do";
                var selectRow=arrCheckRows[0];
                var trf_rule_no=sheetObj.GetCellValue(selectRow,"trf_rule_no");
                var trf_pfx_cd=sheetObj.GetCellValue(selectRow,"trf_pfx_cd");
                var trf_no=sheetObj.GetCellValue(selectRow,"trf_no");
                var amdt_seq2=sheetObj.GetCellValue(arrCheckRows[0],"amdt_seq");
                var amdt_seq1=sheetObj.GetCellValue(arrCheckRows[1],"amdt_seq");
                var param="?trf_rule_no="+trf_rule_no+"&trf_pfx_cd="+trf_pfx_cd+"&trf_no="+trf_no+"&amdt_seq1="+amdt_seq1+"&amdt_seq2="+amdt_seq2
                var sFeatures="toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes,alwaysRaised,dependent,titlebar=no,width=1024,height=700";
                ComOpenPopup(sUrl+param, 1024, 700, "", "1,0", true);
            break;                  
        }
    }catch(e){
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }finally {
         ComOpenWait(false);
    }
}

/**
* Calling function in case of Onclick event <br>
* Manage the contents input/output, Button Control option, Privilege control when selecting rows on sheet. <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
* @param {int} OldRow Mandatory Onclick ,Cell's Row Index
* @param {int} OldCol Mandatory Onclick ,Cell's Column Index
* @param {int} NewRow Mandatory Onclick ,Cell's Row Index
* @param {int} NewCol Mandatory Onclick ,Cell's Column Index
* @return void
* @author 
* @version 2010.10.13
*/  
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    var formObj=document.form;
    if (OldRow != NewRow) {
        formObj.trf_rule_no.value=sheetObj.GetCellValue(NewRow, "trf_rule_no");
        doActionIBSheet(sheetObjects[1], formObj, IBSEARCHAPPEND);
    }
}

/**
* Calling function in case of Onclick event <br>
* Manage the contents input/output, Button Control option, Privilege control when selecting rows on sheet. <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
* @param {int} OldRow Mandatory Onclick ,Cell's Row Index
* @param {int} OldCol Mandatory Onclick ,Cell's Column Index
* @param {int} NewRow Mandatory Onclick ,Cell's Row Index
* @param {int} NewCol Mandatory Onclick ,Cell's Column Index
* @return void
* @author 
* @version 2010.10.13
*/  
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    var formObj=document.form;
    if (OldRow != NewRow) {             
        // Contents In/output Management
        setRuleContents(sheetObj, NewRow, NewCol);
    }
}

/**
 * Calling Function in case of OnSearchEnd event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {string} ErrMsg mandatory from server
 * @return void
 * @author 
 * @version 2010.10.13
 */
function sheet2_OnSearchEnd(sheetObj, errMsg){
    var formObj=document.form;
    if(sheetObj.RowCount()< 1) {
        formObj.rule_ctnt.value="";
    }
}

/**
 * Calling function in case of Onclick event <br>
 * Depend on Status, setting input/ouptu option of Rule Contents. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
 * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
 * @return void
 * @author 
 * @version 2010.10.13
 */ 
function setRuleContents(sheetObj, NewRow, NewCol)  {       
    var formObj=document.form;        
var aCtnt=sheetObj.GetCellValue(NewRow, "trf_rule_ctnt");
    if(sheetObj.RowCount()> 0) {
        formObj.rule_ctnt.scrollTop=0;
        formObj.rule_ctnt.value=aCtnt;
    }       
}

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
* @version 2010.10.13
*/
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH: // retrieving
        if(!ComChkObjValid(formObj.access_dt)){
            return false;
        }
        if (comboObjects[0].GetSelectCode()== "") {
            ComShowCodeMessage("PRI00308","select", "Tariff Code");
            tariff_cd.Focus();
            return false;
        }
        break;
    case IBSEARCH_ASYNC01:
        if (comboObjects[0].GetSelectCode()== "") {
            ComShowCodeMessage("PRI00308","select", "Tariff Code");
            tariff_cd.Focus();
            return false;
        }
        if(sheetObj.GetCellValue(sheetObj.selectRow, "trf_rule_no") == "") {
            return false;
        }
        break;
    case MODIFY07:
        if(sheetObj.CheckedRows("chk_diff") != 2) {
            ComShowCodeMessage("PRI06012");                 
            return false;
        }
        break;          
    }
    return true;
}

/**
 * Calling Function in case of OnChange event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 * @param {int} code Mandatory Onclick 
 * @param {int} text Mandatory 
 * @return void
 * @author 
 * @version 2010.10.13
 */
function tariff_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
    var formObj=document.form;
    var arrText=text.split("|");
    if (arrText != null && arrText.length > 1) {
        var arr=code.split("-");              
        formObj.trf_pfx_cd.value=arr[0];
        formObj.trf_no.value=arr[1];      
    }
}

/**
 * calling function in case of OnClear event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 * @return void
 * @author 
 * @version 2010.10.13
 */
function tariff_cd_OnClear(comboObj) {
    var formObj=document.form;        
    comboObj.SetSelectIndex(-1);
}

/**
 * event in case of losting IBMulti Combo's focus<br>
 * <br><b>Example :</b>
 * <pre>
 *    tariff_cd_OnBlur(comboObj);
 * </pre>
 * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
 * @return void
 * @author 
 * @version 2010.10.13
 */     
function tariff_cd_OnBlur(comboObj) {
    var formObj=document.form;
    var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
    if (code != null && code != "" && code != "-1") {
        var arr=code.split("-");              
        formObj.trf_pfx_cd.value=arr[0];
        formObj.trf_no.value=arr[1];
    }
}

/**
 * Calling Function in case of OnKeyDown event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 * @param {int} code Mandatory Onclick 
 * @param {int} text Mandatory 
 * @return void
 * @author 
 * @version 2010.10.13
 */
function tariff_cd_OnKeyDown(comboObj, KeyCode) {
    var formObj=document.form;
    if (KeyCode == 13){         
        if (comboObj.GetSelectIndex()> -1){
        	var tariffCode = comboObj.GetSelectCode();
            var arr=tariffCode.split("-");              
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
}

/**
 * Handling OnKeyPress<br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_onKeypress()
 * </pre>
 * @param  void
 * @return void
 * @author 
 * @version 2010.10.13
 */ 
function obj_onKeypress() {
    switch (event.srcElement.dataformat) {  
        case "engup":
            if (event.srcElement.name == "rule_no") {
                //ComKeyOnlyAlphabet('uppernum',"45");
            }    
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
* Handling OnKeyDown even <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param  void
* @return void
* @author 
* @version 2010.10.13
*/  
function obj_onKeydown(){
    //Proposal No,S/C No.,Retrieving by enter key
    var eleName=ComGetEvent("name");//event.srcElement.name;
    if (eleName == "rule_no" || eleName == "rule_nm" || eleName == "access_dt"){
        var keyValue=null;
        if(event == undefined || event == null) {
            keyValue=13;
        }else{
            keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        }
        if (keyValue == 13){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
}

/**
* handling OnBeforeActivate event<br>
* <br><b>Example :</b>
* <pre>
*     obj_activate()
* </pre>
* @param  void
* @return void
* @author 
* @version 2010.10.13
*/   
function obj_onActivate() {
    var formObj=document.form;
    var srcName=ComGetEvent("name");
    ComClearSeparator (event.srcElement);
}

/**
* Handling Onbeforedeactivate event<br>
* <br><b>Example :</b>
* <pre>
*     obj_onDeactivate()
* </pre>
* @param  void
* @return void
* @author 
* @version 2010.10.13
*/   
function obj_onDeactivate() {
    var eleName=event.srcElement.name;
    switch(eleName){          
        case "access_dt":
            ComChkObjValid(event.srcElement);   
            break;
    }
}    
