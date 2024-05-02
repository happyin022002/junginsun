/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_2069.js
*@FileTitle  : TDR Details
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
　
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------For JSDoc ------------------*/
 

    /**
     * @extends 
     * @class VOP_OPF_2069 : VOP_OPF_2069 business script for
     */
   	/* Developer performance	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1Width=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	　
    	var sheetObject1=sheetObjects[0];   //t1sheet1
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
				case "btn_Excel":
					//sheetObject1.Down2Excel(-1);
 					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
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
    	var formObject=document.form;
        //setting sheet column by Group By
        if(formObject.group_by.value == "L"){
        	sheet1Width=67;
        }else{
        	sheet1Width=79;
        }
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //setting sheet column by Group By
        if(formObject.group_by.value == "L"){
        	sheetObjects[0].SetColHidden("sheet1_month",1);
        	sheetObjects[0].SetColHidden("sheet1_tdr_qty",1);
        }else{
        	sheetObjects[0].SetColHidden("sheet1_lane",1);
        	sheetObjects[0].SetColHidden("sheet1_vvd",1);
        	sheetObjects[0].SetColHidden("sheet1_ata",1);
        	sheetObjects[0].SetColHidden("sheet1_atd",1);
        	sheetObjects[0].SetColHidden("sheet1_tml_prod_rpt_rsn_cd",1);
        }
        sheet1_OnLoadFinish(sheet1);
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
     * Handling Sheet1 OnLoadFinish Event 
     * param : sheetObj
     * 
     */
 	function sheet1_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
            case "sheet1":
              with(sheetObj){
              var HeadTitle1="|Port|Yard|Lane|VVD|ATA|ATD|Month|TTL TDR|TTL\nMoves|Gross\nWorking\nHRS|Gross\nGang\nHRS|Gross\nTMNL\nPROD|Gross\nGang\nPROD|Average\nNo. of\nCrane|Excluded\nReason";
              var headCount=ComCountHeadTitle(HeadTitle1);
              var prefix="sheet1_";
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"yard",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lane",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ata",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:0,   SaveName:prefix+"atd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"month",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"tdr_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:sheet1Width,Align:"Right",   ColMerge:0,   SaveName:prefix+"tot_mvs",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:sheet1Width,Align:"Right",   ColMerge:0,   SaveName:prefix+"work_gross",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:sheet1Width,Align:"Right",   ColMerge:0,   SaveName:prefix+"gang_gross",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:sheet1Width,Align:"Right",   ColMerge:0,   SaveName:prefix+"tmnl_prod",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:sheet1Width,Align:"Right",   ColMerge:0,   SaveName:prefix+"gang_prod",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:sheet1Width,Align:"Right",   ColMerge:0,   SaveName:prefix+"avg_clan",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:sheet1Width,Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_prod_rpt_rsn_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              SetSheetHeight(282);
              InitColumns(cols);

              SetEditable(0);
           }
		}
    }
	// handling process related Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
 			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
	        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 				var sXml=sheetObj.GetSearchData("VOP_OPF_2069GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
 				break;				
		}
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount()> 0){
 	 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
 	 				if(sheetObj.GetCellValue(i, "sheet1_yard") == "S.Total"){
  	 					sheetObj.SetCellFont("FontBold", i,"sheet1_yard",1);
 	 					sheetObj.SetCellAlign(i, "sheet1_yard","Left");
 	 					for(var j=1 ; j<=15 ; j++){
 	 						sheetObj.SetCellBackColor(i, j,"#E8E7EC");
 	 					}
 	 				}
 	 			} 	 			
 	 			if(sheetObj.RowCount()> 2){
	 	 			//setting Grand Total RGB 
	 	 			var allRowCount=sheetObj.LastRow();
	 	 			sheetObj.SetCellFont("FontBold", allRowCount-1, 1,15);
	 	 			sheetObj.SetCellFont("FontBold", allRowCount, 1,15);
	 	 			for(var j=1 ; j<=15 ; j++){
	 	 				sheetObj.SetCellBackColor(allRowCount-1, j,"#F7E1EC");
	 	 				sheetObj.SetCellBackColor(allRowCount, j,"#F7E1EC");
	 	 			}
 	 			}
 				//sheetObj.RowMerge(sheetObj.LastRow-1) = true;
 				//sheetObj.RowMerge(sheetObj.LastRow) = true;
 				sheetObj.SetCellAlign(sheetObj.LastRow()-1, "sheet1_port","Left");
 				sheetObj.SetCellAlign(sheetObj.LastRow(), "sheet1_port","Left");
 				sheetObj.SetMergeCell(sheetObj.LastRow(), 1, 1, 2);
 	 		} 			
		}
	}	
	/* Developer performance  end */
