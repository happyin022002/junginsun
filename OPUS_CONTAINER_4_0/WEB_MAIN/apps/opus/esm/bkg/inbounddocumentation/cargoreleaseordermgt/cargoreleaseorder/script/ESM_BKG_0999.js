/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0999.jsp
*@FileTitle  : Attorney Create Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class esm_bkg_0999 : esm_bkg_0999 business script for
     */
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /**************************************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Row_Add":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn_Row_Copy":
                    var index=sheetObjects[0].DataCopy();
                    break;
                case "btn_Row_Delete":
                    if(sheetObject1.FindCheckedRow("sheet1_del_chk") ==''){
                        ComShowCodeMessage("BKG00546");
                        return;
                    }
                    ComRowHideDelete(sheetObject1,"sheet1_del_chk");
                    break;
                case "btn_Retrieve":
                    if(sheetObject1.IsDataModified()){
                        if(ComShowCodeConfirm("BKG00824")){
                            doActionIBSheet(sheetObject1,formObject,IBSAVE);
                            break;
                        }else{
                            if( ComIsEmpty(formObject.cust_name.value) && ComIsEmpty(formObject.cust_biz_no.value)){
                                ComShowCodeMessage('BKG00701');
                                formObject.cust_name.focus();
                                return;
                            }
                            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                            break;
                        }
                    }else{
                        if( ComIsEmpty(formObject.cust_name.value) && ComIsEmpty(formObject.cust_biz_no.value)){
                            ComShowCodeMessage('BKG00701');
                            formObject.cust_name.focus();
                            return;
                        }
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        break;
                    }
                case "btn_Register":
                    ComOpenWindowCenter('/opuscntr/ESM_BKG_1000.do',"ESM_BKG_1000",900,485,false);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
                case "btn_Close":
                    if(sheetObject1.IsDataModified()){
                        if(ComShowCodeConfirm("BKG00168")){
                    		ComClosePopup(); 
                        }
                    }else{
                    	ComClosePopup(); 
                    }
                    break;
                case "pop_attorney":
                    attorneyPopOpen();
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
            ComSetFocus(document.form.cust_name)
//            axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); //- form 전체 컨트롤 중 모든 컨트롤의 OnBeforeDeactivateEvent에 코드 처리
//            axon_event.addListenerFormat('blur',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivateEvent에 코드 처리
//            axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypressEvent에 코드 처리
            axon_event.addListenerForm  ('change', 'obj_change', form);
            document.getElementsByName("rdo_flag")[0].checked=true;
            if(document.getElementById("cust_biz_no").value !='' ){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }
    function obj_deactivate(){
        ComChkObjValid(ComGetEvent());
    }
    function obj_activate(){
        ComClearSeparator(ComGetEvent());
    }
    /**
     * Initializing the cust_biz_no
     */
    function obj_change(){
        if(ComGetEvent().name == "cust_name"){
            document.getElementById("cust_biz_no").value='';
        }
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with(sheetObj){
            	         var HeadTitle1="|Sel.|Seq.|수임자|사업자 등록 번호|위임자|사업자 등록 번호|발효일자|만료일자|계산서|Remark|User Name|Office|Update Date|User ID|중복여부|현재날짜|현재날짜-만료일자";
            	         var headCount=ComCountHeadTitle(HeadTitle1);
            	         SetFocusEditMode(-1);
            	         var prefix="sheet1_";

            	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	         InitHeaders(headers, info);

            	         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"PopupEdit", Hidden:0, Width:143,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fm_atty_biz_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fm_atty_biz_no", KeyField:1,   CalcLogic:"",   Format:"SaupNo",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"PopupEdit", Hidden:0, Width:143,  Align:"Center",  ColMerge:1,   SaveName:prefix+"to_atty_biz_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"to_atty_biz_no", KeyField:1,   CalcLogic:"",   Format:"SaupNo",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",         KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"exp_dt",         KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"dup_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"current_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"calcu_dt",       KeyField:0,   CalcLogic:"",   Format:"DateDiff(d, |16|, |8|)",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	          
            	         InitColumns(cols);
            	         SetEditable(1);
            	         SetShowButtonImage(1);
            	         SetColProperty(prefix+"acct_flg", {ComboText:"No|Yes", ComboCode:"N|Y"} );
            	         SetSheetHeight(250);
            	         }
               break;
        }
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj, formObj, sAction, param, row) {
        switch(sAction) {
            //retrieve
            case IBSEARCH:
                try{
                    ComClearSeparator(document.getElementById("cust_biz_no"), "saupja", "-")
                }catch(e) {
                }
                var condition="?";
                if(document.getElementsByName("rdo_flag")[0].checked == true){
                    condition += "cust_type=to";
                }else{
                    condition += "cust_type=fm";
                }
                formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT                 sheetObj.DoSearch("ESM_BKG_0999GS.docondition", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                sheetObj.DoSearch("ESM_BKG_0999GS.do"+condition, FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                break;
            //Save
            case IBSAVE:
                if(sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D") == 0){
                    ComShowCodeMessage('BKG00743');
                    return false;
                }
                if(!validateForm(sheetObj, formObj, sAction)) {
                    return false;
                }//end if
                document.form.insertRow.value = sheetObj.RowCount("I");
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_BKG_0999GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),-1, true);
                break;
            // Insert
            case IBINSERT:
                //sheetObj.DataInsert(-1);
                var idx=sheetObj.DataInsert(-1);
                sheetObj.SelectCell(sheetObj.GetSelectRow(), "sheet1_mdtr_nm", true);
                sheetObj.SetCellValue(idx, "sheet1_upd_usr_nm",document.form.user_nm.value);
                sheetObj.SetCellValue(idx, "sheet1_upd_ofc_cd",document.form.ofc_cd.value);
                sheetObj.SetCellValue(idx, "sheet1_upd_usr_id",document.form.user_id.value);
                break;
        }
    }
    /**
     * HTML Control : onfocusEvent Validation check<br>
     **/
    function attorneyPopOpen(){
        var fnc="";
        var attyCustNm="";
        fnc="fncSetAttyBiz";
        document.getElementById("atty_cust_nm").value=document.getElementById("cust_name").value;
        var condition="?";
            condition += FormQueryString(document.form);
        ComOpenPopup("/opuscntr/ESM_BKG_1001.do"+condition, 400, 290, fnc, "1,0", true);
    }
    /**
     * Setting the retrieve option from Attorney Search popup
     */
    function fncSetAttyBiz(aryPopupData){
        document.getElementById("cust_name").value=aryPopupData[0][2];
        document.getElementById("cust_biz_no").value=aryPopupData[0][3];
    }
    /**
     * Calling the Attorney Search popup in grid
     */
    function sheet1_OnPopupClick(sheetObj,Row,Col){
document.getElementById("atty_cust_nm").value=sheetObj.GetCellValue(Row, Col);
        var condition="?";
            condition += FormQueryString(document.form);
        ComOpenPopup("/opuscntr/ESM_BKG_1001.do"+condition, 400, 250, "setParam", "1,0", false, false, Row, Col, 0);
    }
    /**
     * Setting the selected value from Attorney Search popup
     */
    function setParam(aryPopupData, row, col, sheetIdx){
        var prefix="sheet1_";
        var sheetObject=sheetObjects[0];
        sheetObject.SetCellValue(row,col,aryPopupData[0][2]);
        sheetObject.SetCellValue(row,parseInt(col)+1,aryPopupData[0][3]);
        if(sheetObjects[0].ColSaveName(col) =='sheet1_to_atty_biz_nm'){
            sheetObjects[0].SelectCell(row, "sheet1_fm_atty_biz_nm", true);
        }else{
            sheetObjects[0].SelectCell(row, "sheet1_eff_dt", true);
        }
    }
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            ComBkgSaveCompleted();  
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        switch (sAction) {
            case IBSEARCH: // Retrieve
                return true;
                break;
            case IBSAVE:   // Save
                if(!validGridDate(sheetObj)){
                    return false;
                }else if(!dupSaupjaCheck(sheetObj)){
                    return false;
                }
                return true;
                break;
        }
    }
    /**
     * Validation check for the biz_no in IBSheet
     */
    function validGridDate(sheetObj) {
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
if(sheetObj.GetRowStatus(idx) =='I' && sheetObj.GetCellValue(idx, "sheet1_fm_atty_biz_no")!=''){
if(!ComIsSaupjaNo(sheetObj.GetCellValue(idx, "sheet1_fm_atty_biz_no"))){
                    ComShowCodeMessage("BKG40001");
                    sheetObj.SelectCell(idx, "sheet1_fm_atty_biz_no", true);
                    return false;
                    break;
                }
            }
            // biz_no
if(sheetObj.GetRowStatus(idx) =='I' && sheetObj.GetCellValue(idx, "sheet1_to_atty_biz_no")!=''){
if(!ComIsSaupjaNo(sheetObj.GetCellValue(idx, "sheet1_to_atty_biz_no"))){
                    ComShowCodeMessage("BKG40001");
                    sheetObj.SelectCell(idx, "sheet1_to_atty_biz_no", true);
                    return false;
                    break;
                }
            }
            // exp_dt check
if(sheetObj.GetRowStatus(idx) =='I' || sheetObj.GetRowStatus(idx) =='U') {
if( ! ComIsEmpty(sheetObj.GetCellValue(idx, "sheet1_eff_dt")) &&
! ComIsEmpty(sheetObj.GetCellValue(idx, "sheet1_exp_dt")) &&
ComChkPeriod(sheetObj.GetCellValue(idx, "sheet1_eff_dt"), sheetObj.GetCellValue(idx, "sheet1_exp_dt")) < 1){
	                ComShowCodeMessage("BKG40002");
	                return false;
	                break;
	            }
	            // Max 5 years between exp_dt and eff_cd
if( ! ComIsEmpty(sheetObj.GetCellValue(idx, "sheet1_eff_dt")) &&
! ComIsEmpty(sheetObj.GetCellValue(idx, "sheet1_exp_dt"))){
var interval=(ComGetDaysBetween(sheetObj.GetCellValue(idx, "sheet1_eff_dt"), sheetObj.GetCellValue(idx, "sheet1_exp_dt"))/30/12)
	                if( interval > 5){
	                    ComShowCodeMessage("BKG40003");
	                    return false;
	                    break;
	                }
	            }
            }
        }
        return true;
    }
    /**
     * Checking the duplication data in IBSheet
     */
    function dupSaupjaCheck(sheetObj) {
        var dRow=sheetObj.ColValueDup("sheet1_fm_atty_biz_no|sheet1_to_atty_biz_no", false);
if(sheetObj.GetCellValue(dRow, "sheet1_fm_atty_biz_no") =='' || sheetObj.GetCellValue(dRow, "sheet1_to_atty_biz_no") ==''){
            return true;
        }
        if (dRow != -1) {
ComShowCodeMessage('COM12115', 'saupja: ['+sheetObj.GetCellValue(dRow, "sheet1_fm_atty_biz_no")+']');
            sheetObj.SelectCell(dRow, sheetObj.SaveNameCol("sheet1_fm_atty_biz_no"));
            return false;
        } else {
            return true;
        }
    }
    function saupja_lenght(obj) {
    }
    /**
     * Showing as RED color if exp_cd is in 7 days from today
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var prefix="sheet1_";
        if (ErrMsg == "") {
            for (var i=1; i<=sheetObj.RowCount(); i++) {
            	if( sheetObj.GetCellValue(i, prefix+'calcu_dt') <= 7){
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"seq","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"fm_atty_biz_nm","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"fm_atty_biz_no","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"to_atty_biz_nm","#FF0000");//RED color
//parameter changed[check again]CLT                    
            		sheetObj.SetCellFontColor(i, prefix+"to_atty_biz_no","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"eff_dt","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"exp_dt","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"diff_rmk","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"upd_usr_nm","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"upd_ofc_cd","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"upd_dt","#FF0000");//RED color
//parameter changed[check again]CLT                     
            		sheetObj.SetCellFontColor(i, prefix+"upd_usr_id","#FF0000");//RED color
                }
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
     * Initializing the biz_no if biz_nm initialized
     */
    function sheet1_OnAfterEdit(sheetObj, row, col) {
        var prefix="sheet1_";
        with (sheetObj) {
if (sheetObj.GetCellValue(row, prefix+'to_atty_biz_nm') == ''){
                sheetObj.SetCellValue(row, prefix+'to_atty_biz_no',"");
            }
if (sheetObj.GetCellValue(row, prefix+'fm_atty_biz_nm') == ''){
                sheetObj.SetCellValue(row, prefix+'fm_atty_biz_no',"");
            }
        }
    }
    /**
     * Enter key Event
     */
    function enterKeySearch(){
        var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var formObject=document.form;
        var srcName=ComGetEvent("name");
        if(ComIsEmpty(srcName)){
            return;
        }
        // Enter key(13)
        if (keyCode == 13) {
            if( ComIsEmpty(formObject.cust_name.value) && ComIsEmpty(formObject.cust_biz_no.value)){
                ComShowCodeMessage('BKG00701');
                eval("formObject."+srcName).focus();
                return false;
            }
            if(!ComIsEmpty(formObject.cust_biz_no.value) && !ComIsSaupjaNo(formObject.cust_biz_no.value)){
                ComShowCodeMessage("BKG40001");
                formObject.cust_biz_no.focus();
                return false;
            }
            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        } // end if
    }
