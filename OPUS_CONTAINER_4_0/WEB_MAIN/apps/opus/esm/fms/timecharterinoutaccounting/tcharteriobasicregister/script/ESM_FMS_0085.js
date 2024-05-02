/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_FMS_0085.js
*@FileTitle  : E-mail List Registration 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry definition of biz script for creation screen
     */
   
	// common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	if(ComGetBtnDisable(srcName)) return false;
        	switch(srcName) {
	        	case "btn_retrieve":
					if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
			 		break;
    	    	case "btn_new":
    	    		if(!initConfirm()) return;
    		 		ComResetAll();
    		 		sheetObject.RemoveAll();
    		 		//sheetObject1.RemoveAll();
    	        	break;
    	    	case "btn_save":
    	    		doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    	    	case "btn_add":
					var row=sheetObject.DataInsert(-1);
					break;
    	    	case "btn_del":
					ComRowHideDelete(sheetObject, "DelChk");
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
    	}
    	sheet1_OnLoadFinish(sheetObjects[0]);
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
         	case 1:
         	    with(sheetObj){
              var HeadTitle1="|Sel|Seq|Personal Information|E-mail Address|eml_seq";
              var headCount=ComCountHeadTitle(HeadTitle1);
              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"DelChk" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_eml",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eml_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);
              SetEditable(1);
//            SetSheetHeight(520);
              resizeSheet();
           }
         		break;
    	}
    	
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    	case IBSEARCH:      
    		formObj.f_cmd.value=SEARCH;
    		sheetObj.DoSearch("ESM_FMS_0085GS.do", FormQueryString(formObj) );
    		break;
    	case IBSAVE:        
    		formObj.f_cmd.value=MULTI;
    		sheetObj.DoSave("ESM_FMS_0085GS.do", FormQueryString(formObj));
    		break;
    	case IBINSERT:      
    		break;
    	}
    }
    /**
     * Confirming implementation when Event is occurred  <br>
     * @return {boolean} okYn   In case of clicking OK button on Message confirm window okYn:true,  else okYn:false
     **/
    function initConfirm() {
     	var okYn=true;
     	if(sheetObjects[0].IsDataModified()) {
     		var okYn=ComShowCodeConfirm("FMS00002");
     	}
     	return okYn;
    }
    // Checking Email Validation <br>
    function checkMail(strMail) {
    	/** Check Point
         - In case amounts of '@' are more than two
         - Attached '.' 
         - '@.' or '.@' is existing
         - In case the first letter is '.'
         - More than one letter must be existing before '@'
         - Only one '@' is permitted
         - More than one '.' is required in Domain Name
         - Last letters of Domain Name must be 2~4 letters of English **/ 
    	var check1=/(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;  
        var check2=/^[a-zA-Z0-9\-\.\_]+\@[a-zA-Z0-9\-\.]/; 
     	if ( !check1.test(strMail) && check2.test(strMail) ) {
     		return true;
     	} else { 
     		return false; 
     	} 
    }
    /**
     * Checking Email Validation when OnChange Event of sheet1 is occurred<br>
     */
 	function sheet1_OnChange(sheetObj, row, col, value) {
        if(col == 4) {
        	if(!checkMail(value)) {
        		ComShowCodeMessage("FMS01147");
        		sheetObj.SetCellValue(row, "cntc_pson_eml","",0);
        		sheetObj.SelectCell(row, "cntc_pson_eml");
        	}
        }
 	}

 	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	} 	
 	