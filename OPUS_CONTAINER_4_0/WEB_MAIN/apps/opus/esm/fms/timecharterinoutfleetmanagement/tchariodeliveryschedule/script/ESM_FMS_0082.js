/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0082.js
*@FileTitle  : Ship Yard Select – Pop up
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
     * @class Ship Yard Select ? Pop up : Ship Yard Select ? Pop up definition of biz script for creation screen
     */
    //  common global variables 
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
     * Registering IBSheet Object as Array
     * In case there is needs to do batch processing, process saving as Array can be added
     * defining array on the top of source
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
    	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Adding first-served function
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
         switch(sheetObj.id) {
         	case "sheet1":      //t1sheet1 init
         	    with(sheetObj){
               
		              var HeadTitle1="||Seq|Ship Yard Name|Ship Yard Name";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Radio",     Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"check",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"yd_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:"shp_yd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		           //   SetGetCountPosition()(0);
		              SetSheetHeight(220);
                    }


         		break;
         }
    }
    /**
     * Handling sheet process<br>
     */
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg(false);
 		switch(sAction) {
 			case IBSEARCH:      
 					formObj.f_cmd.value=SEARCH;
         	   		sheetObj.DoSearch("ESM_FMS_0082GS.do", FormQueryString(formObj) );
 					break;
 			case IBSAVE:      
 				if(validateForm(sheetObj,formObj,sAction))
 					alert (" Save .. ");
 					break;
 			case IBINSERT:    
 				break;
 		}
 	}
    /**
     * Handling process for input validation<br>
     */
 	function validateForm(sheetObj,formObj,sAction){		
        return true;
 	}
