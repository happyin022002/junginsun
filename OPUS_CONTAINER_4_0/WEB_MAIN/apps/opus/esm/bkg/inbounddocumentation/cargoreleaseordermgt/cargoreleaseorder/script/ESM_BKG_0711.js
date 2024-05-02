/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0711.js
*@FileTitle  : 
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
     * @class ui_bkg_0711 : business script for ui_bkg_0711
     */
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn_close":
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
            if (document.form.bl_no.value != "") {
            	if (document.form.h_bl_tp_cd != "") {
            		document.form.h_bl_no.value=document.form.bl_no.value + document.form.h_bl_tp_cd.value; 
            	} else {
            		document.form.h_bl_no.value=document.form.bl_no.value;
            	}
            } else {
            	document.form.h_bl_no.value="";
            }
            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        initControl();
        ComSetFocus(document.form.bl_no)
        //document.getElementsByName("rdo_flag")[0].checked = true;
    }
    function initControl(){
        //Axon event handling1. event catch
//        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
//        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);
//        axon_event.addListenerFormat('keypress',         'obj_keypress',    form);
        axon_event.addListenerForm  ('change', 'obj_change', form);
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
              
		            var HeadTitle="Seq.| |Item|New|Old|User Name|Office|Update Time|User ID";
		
		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		
		            var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"do_cng_evnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"do_cng_evnt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"crnt_ctnt_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"pre_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		             
		            InitColumns(cols);
		
		            SetEditable(1);
		            //SetColProperty("evnt_dt", {Format:"####-##-####:##"} );
//		            SetSheetHeight(240);
		            resizeSheet();
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
        var form=document.form;
        switch(sAction) {
            case IBSEARCH:      //retrieve
                    formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT                    
                    sheetObj.DoSearch("ESM_BKG_0711GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * checking Validation at onchange event of HTML Control
     **/
    function obj_change(){
        var oForm=document.form;
        if (event.srcElement.name == "bl_no") {
            document.getElementsByName("rdo_flag")[0].checked=true;
            oForm.bkg_no.value='';
            oForm.cntr_no.value='';
        }else if (event.srcElement.name == "cntr_no") {
            document.getElementsByName("rdo_flag")[1].checked=true;
            oForm.bkg_no.value='';
            oForm.bl_no.value='';
        }else if (event.srcElement.name == "bkg_no") {
            document.getElementsByName("rdo_flag")[2].checked=true;
            oForm.bl_no.value='';
            oForm.cntr_no.value='';
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
        if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.cntr_no) && ComIsNull(oForm.bkg_no)){
            ComShowCodeMessage('BKG00786');
            ComSetFocus(oForm.bl_no)
            return false;
        }else if (!ComIsNull(oForm.bl_no) && ComChkLen(oForm.bl_no, 12) != 2){
            ComShowCodeMessage('BKG00652'); //B/L No's prefix is invalid
            ComSetFocus(oForm.bl_no)
            return false;
        }else if (!ComIsNull(oForm.cntr_no) && ComChkLen(oForm.cntr_no, 14) != 2){
            ComShowCodeMessage('BKG00700');   //Container No's prefix is invalid
            ComSetFocus(oForm.cntr_no)
            return false;
        }else if (!ComIsNull(oForm.bkg_no) && ( oForm.bkg_no.value.length != 13 && oForm.bkg_no.value.length != 11)){
            ComShowCodeMessage('BKG00651'); //BKG prefix is invalid
            ComSetFocus(oForm.bkg_no)
            return false;
        }
        return true;
    }
   /**
    * sheet1 MouseMove event
    * @param  sheet
    * @param  button
    * @param  shift
    * @param  X
    * @param  Y
    */
    function sheet1_OnMouseMove(sheetObj, row, col, value, button, shift, X, Y) {
        var sName=sheetObj.ColSaveName(sheetObj.MouseCol());
        if ("crnt_ctnt" != sName ){
            return;
        }
if (sheetObj.GetCellValue(sheetObj.MouseRow(),'crnt_ctnt') == 'YES' && sheetObj.GetCellValue(sheetObj.MouseRow(),'do_cng_evnt_cd') == 'RR') {
            sheetObj.SetMousePointer("Hand");
        } else {
            sheetObj.SetMousePointer("Default");
        }
    }
    /**
     * handle the details after IBSheet retrieve
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 10){//
                //no support[implemented common]CLT sheetObj.ScrollBar=2;
            }else{
                //no support[implemented common]CLT sheetObj.ScrollBar=0;
            }
            for (var i=1; i<=sheetObj.RowCount(); i++) {
            	if( sheetObj.GetCellValue(i,'crnt_ctnt') == 'YES' && sheetObj.GetCellValue(i,'do_cng_evnt_cd') == 'RR'){
//parameter changed[check again]CLT 
            		sheetObj.SetCellFontUnderline(i,'crnt_ctnt',1);
//parameter changed[check again]CLT  
            		sheetObj.SetCellFontColor(i, "crnt_ctnt","#0000FF");
                }
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    function sheet1_OnClick(sheetObj, Row, Col, Value){
    	if(sheetObj.ColSaveName(Col) =='crnt_ctnt' && sheetObj.GetCellValue(Row, "crnt_ctnt") == 'YES' && sheetObj.GetCellValue(sheetObj.MouseRow(),'do_cng_evnt_cd') == 'RR'){
        }
    }
