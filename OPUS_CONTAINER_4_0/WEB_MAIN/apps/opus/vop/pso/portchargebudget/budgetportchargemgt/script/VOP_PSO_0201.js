/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0201.js
*@FileTitle  : Expense Plan Per VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_pso_0201 : business script for vop_pso_0201
     */
 // public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
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
     * adding first-served functions after loading screen
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
			var sheetid=sheetObj.id;
      switch(sheetid) {
				case "sheet1":
				    with(sheetObj){
			        
						      var HeadTitle1="|Seq.|Rev. Month|Lane|VVD|Port|Account CD|Estimate(USD)|Actual(USD Invoice)";
						      /*if("0" == document.form.gubun.value){
						    	  var HeadTitle1="|Seq.|YYYYMM|VVD|Port|Account CD|Estimate|Actual";
						      }else{
						    	  var HeadTitle1="|Seq.|YYYYMM|VVD|Lane|Account CD|Estimate|Actual";
						      }*/
						      
						      
						      var headCount=ComCountHeadTitle(HeadTitle1);
						      //(headCount, 0, 0, true);
						      var prefix="sheet1_";
			
						      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			
						      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						      InitHeaders(headers, info);
			
						      var cols = [ 
						             {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
						             {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yyyy_mm",      KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"account_code", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estimate",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"actual",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
						       
						      InitColumns(cols);
			
//						      SetEditable(1);
						      //SetSheetHeight(230);
						      SetSumRowHidden(1);
						      resizeSheet()
			            }


						break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        	case IBSEARCH:      //Retrieving
               	if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH;
 						sheetObj.DoSearch("VOP_PSO_0201GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
						ComOpenWait(false);
					}
               	}
    			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObjects[0].SetSumRowHidden(0);
        ComOpenWait(false);
        sheetObjects[0].SetSumValue("Seq","TOTAL");
	}    

	function resizeSheet(){
		for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
