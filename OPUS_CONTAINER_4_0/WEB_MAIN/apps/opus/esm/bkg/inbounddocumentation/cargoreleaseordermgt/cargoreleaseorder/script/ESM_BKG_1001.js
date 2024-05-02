/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1001.js
*@FileTitle  : Attorney Search Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class esm_bkg_1001 : business script for esm_bkg_1001
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // calling retrieve event in case of clicking enter key
    function enterKeyNextSearch(){
        var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var formObject=document.form;
        if (keyCode == 13) {
            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        } // end if
    }
    // Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
             var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                    break;
                case "btn_select":
                    comPopupOK();
                break;
                case "btn_close":
                	ComClosePopup(); 
                break;
            } // end switch
        } catch(e) {
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
            if(!ComIsEmpty(document.form.atty_cust_nm)){
                doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            }
        }
        //Axon event handling
//        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 
//        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); 
//        axon_event.addListenerFormat('keypress',         'obj_keypress',    form);
    }
    //Axon event handling
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with(sheetObj){
                
            var HeadTitle1="|Sel.|사업자명|사업자 등록 번호";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"" },
             {Type:"Radio",     Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"atty_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"atty_biz_no",   KeyField:0,   CalcLogic:"",   Format:"SaupNo",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);
            SetEditable(1);
//            SetColHidden("radio",1);
            SetDataLinkMouse("atty_cust_nm",1);
            SetDataLinkMouse("atty_biz_no",1);
            SetSheetHeight(130);
            }


                break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction)){
                    formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT                     
                    sheetObj.DoSearch("ESM_BKG_1001GS.do", FormQueryString(formObj) );
                    break;
                }
        }
    }
    /**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction){
        var oForm=document.form;
        with(formObj){
            if(ComIsEmpty(oForm.atty_cust_nm)){
                ComShowCodeMessage('BKG40005');
                ComSetFocus(oForm.atty_cust_nm)
                return false;
            }
        }
        return true;
    }
   /**
    * in case of double click retrieved data
    */
    function sheet1_OnDblClick(sheetObj, Row, Col){
        sheetObj.SetCellValue(Row, "radio",1);
        comPopupOK();
    }
