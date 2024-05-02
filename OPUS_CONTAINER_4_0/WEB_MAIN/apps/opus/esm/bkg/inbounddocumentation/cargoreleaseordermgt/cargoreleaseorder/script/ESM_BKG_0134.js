/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1034.js
*@FileTitle  : D/O EDI Transmit log List Inquiry(Korea e-D/O Sent History)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/24
=========================================================**/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /** Start of developer's work*/

    // global variable
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
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
                case "btn_new":
                	document.form.sch_tp[1].checked=true;
                	formObject.rcv_fm_dt.value=ComGetNowInfo("ymd", "");  //setting current date
                    formObject.rcv_to_dt.value=ComGetNowInfo("ymd", "");  //setting current date
                    formObject.bl_no.value="";    //clear BL_NO 
                    ComSetFocus(document.form.rcv_fm_dt);
                break;
                case "btns_calendar2":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.elements["rcv_fm_dt"], formObject.elements["rcv_to_dt"],'yyyy-MM-dd');
                break;
                } // end switch
            }catch(e) {
                if( e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e);
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
            }
            initControl();
            
//            var opener = window.dialogArguments;
//            if (!opener) opener = parent;
//            if(document.form.frm_bl_no.value == ""){
//            	document.form.frm_bl_no.value = opener.document.form.bl_no.value;
//            }
            if (document.form.frm_bl_no.value != "") {
            	document.form.sch_tp[0].checked=true;
            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
            
        }
        /**
         *  setting event and initial value of control.
         */
        function initControl() {
			initText();
            axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
            axon_event.addListenerForm  ('focus',   'obj_activate',    form);
            //axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- keyboard
            //axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
        }
        
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
        }

        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){                    
	                  var HeadTitle="|Seq|B/L No|MRN|MSN|Error Reason|Result|Received Date";
	                  var prefix="sheet1_";
	
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mf_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"mf_seq_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0, Width:430,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ack_msg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rslt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0, Width:135,  Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rcv_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                   
	                  InitColumns(cols);
	
	                  SetEditable(1);
	                  SetColProperty(prefix+"edo_rcv_dt", {Format:"####-##-####:##:##"} );	                  
	                  ScrollBar=2;
//	                  SetSheetHeight(415);
	                  resizeSheet();
	                  }

                	
                    break;
            }
        }
        /**
         * handling of Sheet 
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {
                case IBSEARCH:      
                    if(!validateForm(sheetObj,formObj,sAction)) return false;
                    formObj.f_cmd.value=SEARCH;
                    if(sheetObj.id == "sheet1"){
                    	sheetObj.DoSearch("ESM_BKG_0134GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                    }
                break;
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction) {
            case IBSEARCH:
            	if (document.form.sch_tp[1].checked == true) {
                    formObj.frm_sch_tp.value="A";
            		if(ComIsEmpty(formObj.rcv_fm_dt.value) && ComIsEmpty(formObj.rcv_to_dt.value)){
	                    ComShowCodeMessage('BKG00554');
	                    formObj.rcv_fm_dt.focus();
	                    return false;
	                }
	                var v_sdate=formObj.rcv_fm_dt.value;//from date
	                var v_edate=formObj.rcv_to_dt.value;//to date
	                if(!ComIsDate(v_sdate, 'yyyy-MM-dd') || !ComIsDate(v_edate, 'yyyy-MM-dd')){
	                    ComShowCodeMessage("BKG00421");
	                    formObj.rcv_fm_dt.focus();
	                    return false;
	                }
	                if(ComGetDaysBetween(v_edate, v_sdate) > 0){
	                    ComShowCodeMessage("BKG00421");
	                    formObj.rcv_fm_dt.focus();
	                    return false;
	                }
	                //  checking range of period (10 Days)
	                if(ComGetDaysBetween(v_sdate,v_edate) > 10){
	                    ComShowCodeMessage("BKG00555","10 Days");
	                    formObj.rcv_fm_dt.focus();
	                    return false;
	                }
            	} else {
                    formObj.frm_sch_tp.value="B";
                	if(ComIsEmpty(formObj.bl_no.value)){
                        ComShowCodeMessage('BKG00266');
                        formObj.bl_no.focus();
                        return false;
                    }
                	formObj.frm_bl_no.value=formObj.bl_no.value;
                }
                return true;
                break;
            }
            return true;
        }
        /**
         *  handling OnFocus 
         */
        function obj_activate() {
            var objName=event.srcElement.name;
            var formObj=document.form;
            switch(objName) {
//                case "rcv_fm_dt":
//                    formObj.rcv_fm_dt.value=formObj.rcv_fm_dt.value.replace(eval("/-/gi"), "");
//                    break;
//                case "rcv_to_dt":
//                    formObj.rcv_to_dt.value=formObj.rcv_to_dt.value.replace(eval("/-/gi"), "");
//                    break;
            }
        }
        /**
        * handling Blur 
        */
        function obj_deactivate(){
            //checking Validation 
//            ComChkObjValid(event.srcElement);
        }
        /**
         * contolling onkeypress 
         **/
        function obj_keypress(){
            switch(event.srcElement.dataformat){
//                case "float":
//                    //number+"."
//                    ComKeyOnlyNumber(event.srcElement, ".");
//                    break;
//                case "eng":
//                    //only alphabet, alphabet + number -> ComKeyOnlyAlphabet('num');
//                    ComKeyOnlyAlphabet('uppernum');
//                    break;
//                case "engdn":
//                    //only alphabet lower case, only alphabet lower case + number -> ComKeyOnlyAlphabet('lowernum');
//                    ComKeyOnlyAlphabet('lower');
//                    break;
//                case "engup":
//                    //only alphabet upper case, alphabet upper case + number -> ComKeyOnlyAlphabet('uppernum');
//                    ComKeyOnlyAlphabet('upper');
//                    break;
//                default:
//                    //only number (inteager, date, time)
//                    ComKeyOnlyNumber(event.srcElement);
            }
        }
        /**
         * initializing field 
         **/
        function initText() {
            var formObject=document.form;
            if (formObject.frm_edo_rqst_dt_s.value.length > 0) {
                formObject.rcv_fm_dt.value=formObject.frm_edo_rqst_dt_s.value;
                formObject.rcv_to_dt.value=formObject.frm_edo_rqst_dt_e.value;
                formObject.bl_no.value=formObject.frm_bl_no.value;
            } else {
                formObject.rcv_fm_dt.value=ComGetNowInfo("ymd", "");  //setting date
                formObject.rcv_to_dt.value=ComGetNowInfo("ymd", "");  //setting date
                formObject.bl_no.value=formObject.frm_bl_no.value;
            }
        }
        /**
         *  calling function of searching when enter key is clicked
         */
        function enterKeySearch(){
            var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            var formObject=document.form;
            var srcName=ComGetEvent("name");
            if(ComIsEmpty(srcName)){
                return;
            }
            // enter key(13)
            if (keyCode == 13 && (srcName == 'rcv_fm_dt' || srcName == 'rcv_to_dt' || srcName == 'bl_no')) {
            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            } // end if
        }
    /* the end of developer's work */
 