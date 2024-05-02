/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : esm_bkg_0661.js
*@FileTitle : Awkward Dimension Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author
     */
    /**
     * @extends 
     * @class esm_bkg_0661 : business script for esm_bkg_0661
     */
    function esm_bkg_0661() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // Common global variable    
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function processButtonClick() {
        /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_close":
                	ComClosePopup(); 
                    break;
            }
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
    * registering IBSheet Object as list<br>
    * adding process for list in case of needing batch processing with other items <br>
    * defining list on the top of source <br>
    * 
    * @param {IBSheet} sheet_obj mandatory, IBSheet control
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen. <br>
    * 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    /**
    * setting sheet initial values and header<br>
    * adding case as numbers of counting sheets <br>
    * 
    * @param {ibsheet} sheetObj mandatory, IBSheet Object
    * @param {number}  sheetNo mandatory, IBSheet Object serial number
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="Seq.|Total Dimension(Cm)|Total Dimension(Cm)|Total Dimension(Cm)|Over Dimension(Cm)|Over Dimension(Cm)|Over Dimension(Cm)|Over Dimension(Cm)|Over Dimension(Cm)";
		              var HeadTitle2="Seq.|Length|Width|Height|Front|Rear|Height|Left|Right";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq" },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_len",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_wdt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_hgt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 },
		                     {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"ovr_fwrd_len",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 },
		                     {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"ovr_bkwd_len",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 },
		                     {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"ovr_hgt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 },
		                     {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"ovr_lf_len",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 },
		                     {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"ovr_rt_len",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1 } ];
		              InitColumns(cols);
		              SetEditable(0);
		              SetSheetHeight(120);
                    }
              break;
        }
    }
    /**
    * Sheet handling process <br>
    * 
    * @param {ibsheet} sheetObj mandatory, IBSheet Object
    * @param {object}  formObj  mandatory, HTML Form Object
    * @param {string}  sAction  mandatory, Action Name 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH:      //Retrieve
            	if(!validateForm(sheetObj,formObj,sAction)) return;
                ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
               	sheetObj.DoSearch("ESM_BKG_0661GS.do", FormQueryString(formObj) );
            	ComOpenWait(false);
                break;
        }
    }
    /**
    * handling process for input validation <br>
    * 
    * @param {ibsheet} sheetObj mandatory, IBSheet Object
    * @param {object}  formObj  mandatory, HTML Form Object
    * @param {string}  sAction  mandatory, Action Name 
    * @return boolean Form Returns whether the object is validated. (valid true -> true, valid false -> false)
    * @author 
    * @version 2009.07.09
    */
    function validateForm(sheetObj,formObj,sAction) {
        switch(sAction) {
        case IBSEARCH:
            if (!ComChkValid(formObj)) return false;
        	with(formObj) {
            }
        	break;
        }
        return true;
    }
