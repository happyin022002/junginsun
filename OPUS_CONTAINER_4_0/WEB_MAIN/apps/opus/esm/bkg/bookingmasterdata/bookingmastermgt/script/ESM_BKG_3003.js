/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3003.js
*@FileTitle  : BL Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/04
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var sheetObjects=new Array();
    var sheetCnt=0;
    
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
   			case "btn_Retrieve":
   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   				break;
   			case "btn_Select":
   				ComBkgPopupOK();
				break;
			case "btn_Close":
				ComClosePopup();
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:
            	with(sheetObj){                
                
            		var HeadTitle = "|Sel.|Seq|bl_grp_seq|BL Group Name|Description";
//	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                     {Type:"Radio",  	Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_grp_seq"},
			                     {Type:"Text",      Hidden:0, Width:200,  Align:"left",  ColMerge:0,   SaveName:"bl_grp_nm",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:200,  Align:"left",  ColMerge:0,   SaveName:"bl_grp_desc",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0} ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetCountPosition(0);
	                SetWaitImageVisible(0);                
//	                SetAutoRowHeight(0);
//	                SetDataRowHeight(22);
	                SetSheetHeight(170);
	                
                }
            break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
//        sheetObj.ShowDebugMsg(0);
        switch(sAction) {
           case IBSEARCH:
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sParam=FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_3003GS.do", sParam );
				ComOpenWait(false);
			break;
        }
    }
    
    /*
     * Popup Select...
     */
    function ComBkgPopupOK() {
    	callBkgParentFunc();
    }

    function callBkgParentFunc() {
    	var rArray = getBkgCheckedRows();							//check box
    	
    	if(rArray == null) {
    		ComShowCodeMessage("COM12114", "row");
    		return;
    	}
    	var bModal = false;
		if(!opener) {
			opener=parent;
			bModal = true;
		}
    	try {
    		opener.callBackBlGrp(rArray);							//Function = "callBackBlGrp"
    		ComClosePopup();
    	}catch(e) {
    	 	ComShowCodeMessage("COM12111");
    	}
    }

    function getBkgCheckedRows(colName) {
    	if(sheetObjects[0] == null) return null;
    	var colsCnt=sheetObjects[0].LastCol()+ 1;
    	var sCheckRows = sheetObjects[0].FindCheckedRow("chk");		//SaveName = "chk"
    	var arrRow = sCheckRows.split("|");
    	if(sCheckRows == "") return null;

    	var rArray=new Array(arrRow.length);
    	var cArray=null;
    	
    	for(idx=0; idx<arrRow.length; idx++){ 
    		cArray=null;
    		if(colName != null && colName != "") {
    			cArray=sheetObjects[0].GetCellValue(arrRow[idx], colName);
    		} else {
    			cArray=new Array(colsCnt);
      			for(var j=0; j<cArray.length; j++) {
      				cArray[j]=sheetObjects[0].GetCellValue(arrRow[idx], j);
                }
            }
            rArray[idx]=cArray;
    	}
      	return rArray;
    }
