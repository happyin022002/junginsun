/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0650.js
*@FileTitle  : Transhipment Route and VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // Common global variable
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
        function processButtonClick(){
             /* */
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
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
        			ComShowCodeMessage("COM12111");
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
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                        var HeadTitle="|Seq.|POL|POL|POD|POD|VVD|Lane|POL ETD|POL ETD|POD ETD|POD ETD";
                        
                        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                        
                        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                        var headers = [ { Text:HeadTitle, Align:"Center"} ];
                        InitHeaders(headers, info);
                        
                        var cols = [ {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Popup",     Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"etd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"etd_time",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eta",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eta_time",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                        
                        InitColumns(cols);
                        
                        SetEditable(1);
                        SetShowButtonImage(2);
                        SetWaitImageVisible(0);
//                        SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
                        resizeSheet();
                    }
                    

                    break;
            }
        }
        
        function resizeSheet(){
       	         ComResizeSheet(sheetObjects[0]);
       }
      // handling process for Sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
              case IBSEARCH:      //retrieve
            	  formObj.f_cmd.value=SEARCH;		
     			  sheetObj.DoSearch("ESM_BKG_0650GS.do", FormQueryString(formObj) );
              break;
            }
        }
        // deleting Row in case of not existing data after retrieving
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
     		for ( i=sheetObj.LastRow() ; i > 0 ; i-- ){
                if(sheetObj.GetCellValue(i, "vsl_cd_seq") == ""){
    				sheetObj.RowDelete(i,false);
    			}
    		}    		
    	}
        // calling VVD Popup 
    	function sheet1_OnPopupClick( sheetObj, Row, Col )
    	{
    		comBkgCallPop0019(	"", sheetObj.GetCellValue(Row, "vvd"),
                                    sheetObj.GetCellValue(Row, "pol_cd"),
                                    sheetObj.GetCellValue(Row, "pod_cd"), false);
    	}
