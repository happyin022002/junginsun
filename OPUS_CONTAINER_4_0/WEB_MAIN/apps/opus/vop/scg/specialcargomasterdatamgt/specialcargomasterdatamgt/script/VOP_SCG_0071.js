/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0071.jsp
 *@FileTitle : Segregation Group - Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0071 : business javascript for vop_scg_0071 
     */

    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefixs=new Array("sheet1_","sheet2_");  
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() {
		/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified다 *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1]; 
		var formObj=document.form; 
		/*******************************************************/
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn1_Retrieve":
					doActionIBSheet(sheetObject1, formObj,IBSEARCH);
					break;
				case "btn1_Down_Excel":
                    var paramObj=new Object();
                    paramObj.title="Segregation Group";
                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="2:80";
//                    var url=ComScgGetPgmTitle(sheetObject1, paramObj); 
//                    sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					var sheetExcelObj = sheetObject1;
                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
                    paramObj.datarowheight="0:25";
                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
                    
                    if(sheetExcelObj.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
	       	       		var str = sheetExcelObj.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}
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
    
    function sheet1_OnDownFinish(type,result){
    	var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		if(sheetObject2.RowCount()>0){
	    	 var paramObj2=new Object();
	         paramObj2.title=document.getElementById("subTitle").innerText;
	         paramObj2.orientation="Portrait";
//	         paramObj2.columnwidth="2:80";
//	         var url=ComScgGetPgmTitle(sheetObject2, paramObj2); 
//	         sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
//	         sheetObject2.ComOpenWait(false);
			var sheetExcelObj = sheetObject2;
            paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
            paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
            paramObj.datarowheight="0:25";
            var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
            
            if(sheetExcelObj.RowCount() < 1){//no data
        		  ComShowCodeMessage("COM132501");
	       	}else{
   	       		var str = sheetExcelObj.GetSearchData(url);
   	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
   	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
	       	}	         
		}
    }
    
    function setSheetObject(sheet_obj) {
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
        //resizeSheet();
        //initial Segregation Group List retrieve
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":      //t2sheet1 init
               with (sheetObj) {
                    //setting height
        		
        		var HeadTitle1="|No.|Segregation Groups";
        		var headCount=ComCountHeadTitle(HeadTitle1);

        		SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"ibflag" },
        		             {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_segr_grp_no", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
        		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefixs[0]+"imdg_segr_grp_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
        		 
        		InitColumns(cols);
        		SetSheetHeight(535);//464        		
        		SetEditable(0);
				}
                break;
			case "sheet2":      //t2sheet1 init
               with (sheetObj) {
                    //setting height
				
				var HeadTitle1="||No.|UN No.";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"ibflag" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"imdg_segr_grp_no", KeyField:0,   CalcLogic:"" },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
				             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefixs[1]+"imdg_un_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 } ];
				 
				InitColumns(cols);
				SetSheetHeight(535);				
				SetEditable(0);
//				SetGetCountPosition()(0);
				}
                break;
        }
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
        ComResizeSheet(sheetObjects[1]);
    }

    /**
     * Handling Sheet1 Cell Select Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected Row ==> NewRow, selected Col ==> NewCol
     * 
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObj, sheetObjects[1], OldRow, NewRow, OldCol);
	} 	
    /**
     * Handling Sheet1 Cell Select Event 
     * param : sheet1 ==> sheet object, sheet2 ==> sheet object, OldRow ==> before selecting Row, selected Row ==> NewRow, OldCol ==> before selecting Col
     */
    function doRowChange(sheet1, sheet2, OldRow, NewRow, OldCol) {		
 		var formObj=document.form;
		if (OldRow != NewRow) {
			//Setting title of Heavy metals and their salts.
			document.getElementById("subTitle").innerText=sheet1.GetCellValue(NewRow,prefixs[0]+"imdg_segr_grp_nm");
			//Retrieving Heavy metals and their salts according to Segregation Group.
			formObj.imdg_segr_grp_no.value=sheet1.GetCellValue(NewRow,prefixs[0]+"imdg_segr_grp_no");
			doActionIBSheet(sheet2,formObj,IBSEARCH);
		}
		return;
	}
 	/**
     * Handling Sheet related Transaction Event 
     * param : sheetObj ==> sheet object, formObj ==> form object, sAction ==> Event
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					//Segregation Group retrieve
					if (sheetObj.id == "sheet1"){
						formObj.f_cmd.value=SEARCH01;						
 						sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(new Array(prefixs[0],prefixs[1])) );
					}
					//Heavy metals and their salts retrieve
					else if ( sheetObj.id == "sheet2") {
						formObj.f_cmd.value=SEARCH02;
 					  	sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[1]) );
				   }	
				}					
                break;
        }
		return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
