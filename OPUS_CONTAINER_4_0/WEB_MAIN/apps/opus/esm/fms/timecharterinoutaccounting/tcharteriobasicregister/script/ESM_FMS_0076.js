/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0076.js
*@FileTitle  : Item Name
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Item Name : Item Name definition of biz script for creation screen
     */	
	// common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
	     var sheetObject1=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
				case "btn1_Confirm":
					comPopupOK();
	                    break;
				case "btn1_Close":
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
            sheet1_OnLoadFinish(sheet1);
        }
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Handling Sheet1 OnLoadFinish Event
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
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
               
		              var HeadTitle="||Item Name|Acct Code";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Radio",     Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",     Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",   KeyField:0 },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",       KeyField:0 },
		                     {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:0,   SaveName:"acct_itm_seq" } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(330);
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
    function doActionIBSheet(sheetObj,formObj,sAction) {
//        sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value=SEARCH;
         			sheetObj.DoSearch("ESM_FMS_0076GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
        		}
        		break;
        }
    }
    /**
     * Handling process for input validation<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj insert value
     * @return {boolean} bool
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
