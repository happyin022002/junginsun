/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0698.jsp
*@FileTitle  : Diff Amount
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
 // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
	  * Event handler processing by button name <br>
	  */
        function processButtonClick(){
             /* */
             var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
    					case "btn_Close":
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
         * registering IBSheet Object as list <br>
         * adding process for list in case of needing batch processing with other items <br>
         * defining list on the top of source <br>
         */ 
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet <br>
         * implementing onLoad event handler in body tag <br>
         * adding first-served functions after loading screen.. <br>
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        /**
         * setting sheet initial values and header <br>
         * adding case as numbers of counting sheets <br>
         */ 
        function initSheet(sheetObj,sheetNo) {
        	var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
	            case "sheet1":      //sheet1 init
                    with (sheetObj) {
	                var HeadTitle1="Charge|Booking|Booking|Contract|Contract|Diff Amount|Diff Amount|Accounting\nExchange Rate|USD Amount";
	                var HeadTitle2="Charge|Cur|Amt|Cur|Amt|Cur|Amt|Accounting\nExchange Rate|USD Amount";
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                        { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd_b",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt_b",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd_c",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt_c",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt_d",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Float",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"us_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"usd_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
	                InitColumns(cols);
	                SetEditable(0);
	                SetWaitImageVisible(0);
	                SetSheetHeight(250);
                   }
                    break;
            }
        }
        /**
         * handling process for Sheet <br>
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
            	case IBSEARCH:      //retrieve
	    			ComOpenWait(true);
            		formObj.f_cmd.value=SEARCH01;
            		sheetObj.DoSearch("ESM_BKG_0698GS.do", FormQueryString(formObj) );
            	    break;
            }
        }
        
        function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        	ComOpenWait(false);
        }