/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1067.js
*@FileTitle : Pick up upload history
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
     * @author
     */

    /**
     * @extends 
     * @class ESM_BKG_1067 : It defines business script that using screen for ESM_BKG_1067 creation.
     */
    function ESM_BKG_1067() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // Common global variables
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // Event Handler definition for Button Click event */
    document.onclick = processButtonClick;
    
    /**
     * Event Handler for branch processing by judging button name <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
       /***** using extra sheet valuable if there are more 2 sheets *****/
                var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            case "btn_close":
            	ComClosePopup();
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
     *
     * Registering IBSheet Object in to Array
     * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
     * The array is defined at upper part of source
     * 
     * @param {IBSheet} sheet_obj mandatory, IBSheet control
     * @return none
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }


      /**
      * Sheet basic setting & initializing
      * onLoad Event HandlerImplementation of body tag
      * After loading screen in the browser, add function in pre-processing
      * 
      * @return none
      */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }


     /**
      * Definition for sheet initial setting value, header
      * param : sheetObj ==> sheet object, 
      * sheetNo ==> If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module.<br>
      * 
      * @param {ibsheet} sheetObj mandatory, IBSheet object
      * @param {number}  sheetNo  mandatory, IBSheet object serial number
      * @return none
      */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

            		var HeadTitle1 = "|Seq.|B/L No.|Container|POD|IT LOC|DEL|TERM|Pick up No.|PICK YD|RTN YD|Rail Load Date|AR DT|Available Date|Last Free Date|Update DT|Update USER|Update OFC|Update Date";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);                    
    
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                                 
	                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_hub_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                                 
	                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },                 
	                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },                                 
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rail_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rail_dep_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pkup_aval_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },                                 
	                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },                                 
	                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pkup_upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                                 
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                                 
	    			 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"pkup_upd_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];                    
	                   
	                  InitColumns(cols);
	                  SetEditable(1);
//	                  SetColProperty("rail_arr_dt", {Format:"####-##-##"} );
//	                  SetColProperty("rail_dep_dt", {Format:"####-##-##"} );
//	                  SetColProperty("pkup_aval_dt", {Format:"####-##-####:##"} );
//	                  SetColProperty("lst_free_dt", {Format:"####-##-####:##:##"} );
//	                  SetColProperty("pkup_upd_dt", {Format:"####-##-####:##:##"} );
	                  SetSheetHeight(380);
	                  SetVisible(true);
            }
               
            break;

        }
    }
    

   /**
     * Handling process about Sheet <br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {object}  formObj  mandatory,HTML Form object
     * @param {string}  sAction  mandatory,Action name 
     * @return none
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.WaitImageVisible = false;
    	
        switch(sAction) {

        case IBSEARCH:      
            if(validateForm(sheetObj,formObj,sAction) == false) break;
            
            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;

            sheetObj.DoSearch("ESM_BKG_1067GS.do", FormQueryString(formObj));
            
            ComOpenWait(false);
        
            break;
        }
    }



    /**
     * Handling validity verification process about screen form input value.<br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {object}  formObj  mandatory,HTML Form object
     * @param {string}  sAction  mandatory,Action name
     * @return boolean Returning whether Form object validate. if valid, true, if not false
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }

        return true;
    }