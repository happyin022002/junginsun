/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0077.js
*@FileTitle  : Item Detail Management - Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
/****************************************************************************************
 event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Item Detail Management - Window : Item Detail Management - Window definition of biz script for creation screen
     */
	// common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name  */
    function processButtonClick(){
     var sheetObject=sheetObjects[0];
     var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
				case "btn_retrieve":
					if (formObject.carr_nm.value.length < 1) {
						ComAlertFocus(formObject.carr_nm, ComGetMsg('FMS01080'));
						return;
					}
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
				case "btn_confirm":
					comPopupOK();
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
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		initControl();
    }
   /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
//        axon_event.addListener ('keypress', 'eng_keypress');
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        document.form.carr_nm.focus();
    }
    //Handling Business Javascript OnKeyPress event
//    function eng_keypress() {
//        ComKeyOnlyAlphabet('upper');
//    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		              var HeadTitle0="||Seq|Carrier Code|Carrier Code|Carrier Code";
		              var HeadTitle1="||Seq|Carrier Code|Carrier Name|";
		
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1,};
		              var headers = [ { Text:HeadTitle0, Align:"Center"},
		                          { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Radio",     Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"radio",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"crr_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(240);
//		              SetMergeCell(0, 2, 2, 1);
		              //SetMergeCell(0, 4, 2, 1);
//		              SetMergeCell(0, 3, 1, 2);
                    }
                break;
        }
    }
   /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     * @param {String}  gubun     	gubun value
     **/
    function doActionIBSheet(sheetObj,formObj,sAction, col) {
//        sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value=SEARCH;
         	   		sheetObj.DoSearch("ESM_FMS_0077GS.do", FormQueryString(formObj) );
        		}
        		break;
        }
    }
    /**
     * handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	mandatory html form object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj Input Value
     * @return {boolean} bool <br>
	 *          true  : Valid<br>
	 *          false : inValid
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
