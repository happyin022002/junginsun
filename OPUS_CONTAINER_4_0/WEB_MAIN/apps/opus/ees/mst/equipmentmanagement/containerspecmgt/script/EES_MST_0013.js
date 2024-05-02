/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0013.js
*@FileTitle  : Equipment Organization Chart
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class ees_mst_0013 : business script for ees_mst_0013
 */
    // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick()
        {
	        var sheetObject1=sheetObjects[0];
  	        var sheetObject2=sheetObjects[1];
            var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) 
                {
   				case "btn_downexcel":
   					if(sheetObject1.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObject1.Down2Excel({ HiddenColumn:true});
   					}
   				break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
        		} else {
        			ComShowCodeMessage("MST00011",e);
        		}
        	}
        }
        /**
         * registering IBsheet Object as list
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj)
        {
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() 
        {
	   		for(i=0;i<sheetObjects.length;i++)
	   		{
	   		    ComConfigSheet(sheetObjects[i] );
	   		    initSheet(sheetObjects[i],i+1);
	   		    ComEndConfigSheet(sheetObjects[i]);
	   		}
	   		/**
	   		 * Dung.Nguyen: On Load Finish
	   		 */
	   		sheetObj = sheetObjects[0];
	   		sheetObj.SetWaitImageVisible(0);
	   		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
            sheetObj.SetWaitImageVisible(1);
            //sheet1_OnLoadFinish(sheetObj);
        }
        
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) 
        {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){
	                  var HeadTitle="|Seq.|RCC|LCC|ECC|SCC|SCC Name";
	                  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                       {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"Seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			                       {Type:"Text",   Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                       {Type:"Text",   Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                       {Type:"Text",   Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                       {Type:"Text",   Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"scc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"scc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                       {Type:"AutoSum",      Hidden:1,  Width:110,  Align:"Center"}
			                      
			                    ];
	                  InitColumns(cols);
	                  SetCountFormat("");
	                  //SetSheetHeight(550);
	                  resizeSheet();
	                }
                break;
                
                case 2:      //sheet2 init
                    with(sheetObj){
	                  var HeadTitle="Yard Code";
	                  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ {Type:"Text",   Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  InitColumns(cols);
	                  //SetCountFormat("");
	                  SetEditable(0);
	                  //SetSheetHeight(550);
	                  resizeSheet();
	                }
                break;
            }
        }
        // handling process for sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	sheetObj.ShowDebugMsg(false);
        	switch(sAction) {
             case IBSEARCH:      //retrieve
			   sheetObj.SetWaitImageVisible(0);
			   if ( sheetObj.id == "sheet1")
			   {
				    sheetObj.SetWaitImageVisible(0);
				    ComOpenWait(true);				   
			   		formObj.f_cmd.value=SEARCH;
	 				var xml="";
	 				xml=sheetObj.GetSearchData("EES_MST_0013GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchData(xml,{Sync:1} );
	 				ComOpenWait(false);	 				
			   }
			   else if ( sheetObj.id == "sheet2")
			   {
				    sheetObj.SetWaitImageVisible(0);
				    ComOpenWait(true);				   
			   		formObj.f_cmd.value=SEARCH01;
	 				var xml="";
	 				xml=sheetObj.GetSearchData("EES_MST_0013GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchData(xml,{Sync:1} );
	 				ComOpenWait(false);
			   }
			break;
        	}
        }
	    /**
	     *  handling double click event onsheet1
	     */
	    function sheet1_OnDblClick(sheetObj, row, col, value) 
	    {
	    	var scc_cd=sheetObj.GetCellValue(row, "scc_cd");
	        // inserting selected SSC code
	        document.form.scc_cd.value=scc_cd;
	        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	    }
	    
	    function sheet1_OnLoadFinish(sheetObj){
	   		// showing yard code of first selected row
	   		var scc_cd=sheetObj.GetCellText(1, "scc_cd");
            document.form.scc_cd.value=scc_cd;
	   		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
      	}
	    
	    
	   	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg)
	   	{ 
	   		with(sheetObj)
	   		{
		   		var row = sheetObj.ColValueDupRows("rcc_cd");
		   		if(row != ""){
		   		    arrRows = row.split(",");
		   		} else {
		   		    arrRows = ""; 
		   		}		   		
		   		var totalRows=sheetObj.RowCount();
		   		SetSumText(0,"rcc_cd",totalRows - arrRows.length);
		   		
		   		row = sheetObj.ColValueDupRows("lcc_cd");
		   		if(row != ""){
		   		    arrRows = row.split(",");
		   		} else {
		   		    arrRows = ""; 
		   		}
		   		SetSumText(0,"lcc_cd",totalRows - arrRows.length);
		   		
		   		row = sheetObj.ColValueDupRows("ecc_cd");
		   		if(row != ""){
		   		    arrRows = row.split(",");
		   		} else {
		   		    arrRows = ""; 
		   		}
		   		SetSumText(0,"ecc_cd",totalRows - arrRows.length);
		   		
		   		row = sheetObj.ColValueDupRows("scc_cd");
		   		SetSumText(0,"scc_cd",totalRows);
	   		}
	   		var scc_cd=sheetObjects[0].GetCellValue(1, "scc_cd");
            document.form.scc_cd.value=scc_cd;
            sheetObj.SetSumValue(1,"TOTAL");
	   	}
	   	
	   	function sheet2_OnSearchEnd(sheetObj, code, ErrMsg)
	   	{
	   		//var row = sheetObj.DataInsert(-1);
	   		//sheetObj.SetCellValue(row, "yd_cd", sheetObj.LastRow() - sheetObj.HeaderRows());
	   		//sheetObj.SetCellBackColor(row,"yd_cd", "#EAF1FB");

	   	}
	   	
	   	function resizeSheet(){
	        ComResizeSheet(sheetObjects[0]);
	        ComResizeSheet(sheetObjects[1]);
	      }