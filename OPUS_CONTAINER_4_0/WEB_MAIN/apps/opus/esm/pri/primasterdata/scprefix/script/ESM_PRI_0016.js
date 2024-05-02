/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0016.js
*@FileTitle  : S/C Prefix Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
 	// global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    /**
     * Event handler processing by button name 
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	    		case "btn_Retrieve":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * Initializing and setting Sheet basics<br> 
     * Setting body tag's onLoad event handler<br>
     * Adding pre-handling function after loading screen on the browser <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	//no support[check again]CLT 	pageOnLoadFinish();
    }
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
	    	case 1:      // sheet1 init
	    	    with(sheetObj){
	    			//no support[check again]CLT 		    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    			var HeadTitle="Seq.|Code|Description";
	    			var headCount=ComCountHeadTitle(HeadTitle);

	    			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

	    			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    			var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    			InitHeaders(headers, info);

	    			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",    Sort:0 },
	    			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"sc_pfx_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"sc_pfx_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	           
	    			InitColumns(cols);

	    			SetEditable(0);
	    			SetWaitImageVisible(0);
	                SetAutoRowHeight(0);
	                resizeSheet();//SetSheetHeight(500);
	    		}
	    	    break;
    	}
    }
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
    
	/**
	 * Handling sheet process<br>
	*/
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
	    	case IBSEARCH:    
	    		if ( sheetObj.id == "sheet1"){
	    			ComOpenWait(true);
	    			formObj.f_cmd.value=SEARCH01;
 	    			sheetObj.DoSearch("ESM_PRI_0016GS.do", FormQueryString(formObj) );
	    			ComOpenWait(false);
	    		}
		    	break;
	    }
    }
    
    /**
    * checking validation process of inputted form data <br>
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj){
    	    var Row=sheetObj.ColValueDup("sc_pfx_cd");
    	    if(Row > -1){
    	        ComShowCodeMessage('PRI00302');
    	        sheetObj.SelectCell(Row, "sc_pfx_cd");
    	        return false;
    	    }
    	}
    	return true;
    }
    
    function sheet1_OnSort(sheetObj ,Col, SortArrow){
    	sheetObj.ReNumberSeq();   
  	 }