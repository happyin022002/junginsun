/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_9450.js
*@FileTitle  : Container Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
            /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
            var sheetObject1=sheetObjects[0];
            /*******************************************************/
            var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
                	case "btn_Downexcel":
                		if(sheetObject1.RowCount() < 1){//no data
                			ComShowCodeMessage("COM132501");
                		}else{
    	    				sheetObject1.Down2Excel({DownCols: "1|2|3|4|5", SheetDesign:1, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:"N" });
                		}
    					break;
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
            //khlee- Preferences change the name of the function to start
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
            //khlee- The final configuration functions added
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            sheet1_OnLoadFinish(sheetObjects[0]);
        }
      	function sheet1_OnLoadFinish(sheetObj) {   
     		sheetObj.SetWaitImageVisible(0);
     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		sheetObj.SetWaitImageVisible(1);
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
                    
                  var HeadTitle1="|Seq.|Container No.|TP/SZ|BD & B|BD & B";

                  SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:10,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"mcntr_bdl_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"bdl_btm_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" } ];
                   
                  InitColumns(cols);

                  SetEditable(1);
                  SetCountPosition(0);
                  sheetObjects[0].ToolTipOption="balloon:true;width:250;backcolor:#FFFFFF;forecolor:#000000;icon:1";
                  sheetObjects[0].SetToolTipText(0,4,"Bundle & Bottom");
                  sheetObjects[0].SetToolTipText(0,5,"Bundle & Bottom");
                  SetSheetHeight(322);
                  }


                   break;
            }
        }
      // Sheet handling process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) 
            {
               case IBSEARCH:      //Retrieve
            	   formObj.f_cmd.value=SEARCH;		
            	   sheetObj.DoSearch("ESM_BKG_9450GS.do", FormQueryString(formObj) );
                   break;
            }           
        }
