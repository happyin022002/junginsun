/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0758.js
*@FileTitle  : C/A Kind Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/28
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
     * @class esm_bkg_0758 : It defines business script that using screen for esm_bkg_0758 creation.
     * 
     */
    // Common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;    
    //Event Handler definition for Button Click event */
    document.onclick=processButtonClick;
	//Event Handler for branch processing by judging button name */
    function processButtonClick(){
        sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {			    	
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
    	}
    }
     /**
      * Registering IBSheet Object in to Array
      * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
      * The array is defined at upper part of source
      */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
     /**
      * Sheet basic setting & initializing
      * onLoad Event HandlerImplementation of body tag
      * After loading screen in the browser, add function in pre-processing
      */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        //initParam();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }
     /**
      * Definition for sheet initial setting value, header
      * param : sheetObj ==> sheet object, 
      * sheetNo ==> If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module.
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
                with(sheetObj){
                	var HeadTitle="||Kind|C/A Kind Description";
                	var headCount=ComCountHeadTitle(HeadTitle);

                	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:1, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
         
                	InitColumns(cols);
                	SetSheetHeight(260);
                	SetEditable(1);
			}
		 break; 
		}
	}
    // Handling process about Sheet
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="sheet1") {
	      	    	formObj.f_cmd.value=SEARCH;
	      	    	sheetObj.DoSearch("ESM_BKG_0758GS.do", FormQueryString(formObj) );
      	    	} 
                break;
        }
    }
    //######################[1.Etc]##############################################################	
