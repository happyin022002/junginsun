/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3017.js
*@FileTitle  : TAA Creation & Amendment [Amend]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends Pri
     * @class ESM_PRI_3017 : Business Script for ESM_PRI_3017
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.12.01
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_OK":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "btns_calendar": //calendar button
                    var cal=new ComCalendarFromTo();
                    cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
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
     * @return void
     * @author 
     * @version 2009.12.01
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
     * @version 2009.12.01
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
        var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        if (!isNaN(amdtSeq)) {
            formObj.amdt_seq.value=Number(amdtSeq) + 1;
        }
        formObj.eff_dt.focus();
//        document.getElementById("eff_dt").focus();
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
     * @version 2009.12.01
     */
    function initControl () {
        var formObj=document.form;
        // Process Axon Event No.1, Event Catch 
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
    }
    /**
     * Process Onbeforedeactivate Event. <br>
     * Process Date Masking <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.01
     */
    function obj_deactivate () {
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        if (srcName == "eff_dt" && formObj.eff_dt.value != "" && !check_eff_date()) {
            return false;
        }
        ComChkObjValid(event.srcElement);
    }
    /**
     * Process OnBeforeActivate Event. <br>
     * Process Date Unmasking <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.01
     */
    function obj_activate () {
        var sElement=event.srcElement;
        ComClearSeparator(sElement);
    }
    /**
     * Check Amend Effective Date. <br>
     * <br><b>Example :</b>
     * <pre>
     *     if(check_eff_date()) {
     *         ........
     *     }
     * </pre>
     * @param  void
     * @return {boolean}
     * @author 
     * @version 2009.12.21
     */
    function check_eff_date() {
        var formObj=document.form;
        if (ComGetDaysBetween(formObj.eff_dt.value, formObj.old_eff_dt.value) >= 0){
            ComShowCodeMessage("PRI05006", "["+formObj.old_eff_dt.value+"]");
            formObj.eff_dt.focus();
            formObj.eff_dt.select();
            return false;
        } else {
            return true;
        }
    }
    /**
     * Handling OnKeyPress<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.21
     */     
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
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
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, IBSheet Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.12.01
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
				
				var HeadTitle="ibflag";
				var headCount=ComCountHeadTitle(HeadTitle);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetVisible(0);
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
     * @return void
     * @author 
     * @version 2009.12.01
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSAVE:        
                ComOpenWait(true);
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=MULTI;
                var sParam=FormQueryString(formObj);
                 var sXml=sheetObj.GetSaveData("ESM_PRI_3017GS.do", sParam);
                 sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
                break;
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
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process Flag constant variable
     * @returns bool, <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.11.20
     */
    function validateForm(sheetObj,formObj,sAction){
        var taa_no=formObj.taa_no.value;
        switch (sAction) {
            case IBSEARCH: // retrieving
                if (taa_no == null) {
                    ComShowCodeMessage('PRI00316','TAA Number');
                    formObj.taa_no.focus();
                    return false;
                }
                break;
            case IBSAVE: // Save
                if(!ComChkRequired(formObj)){
                    return false;
                }
                return check_eff_date();
                break;
        }
        return true;
    }
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Display the data on form after Sheet retrieve completely <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg selection
     * @returns void
     * @author 
     * @version 2009.11.30
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            var formObj=document.form;
            var obj=new Object();
            obj.taaNo=formObj.taa_no.value;
            obj.amdtSeq=formObj.amdt_seq.value;
            ComPopUpReturnValue(obj);
        }
    }
