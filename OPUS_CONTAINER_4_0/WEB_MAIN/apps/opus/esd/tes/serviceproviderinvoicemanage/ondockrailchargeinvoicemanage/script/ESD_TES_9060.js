/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9060.jsp
*@FileTitle  : Total Amount
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/

// global variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
         	    case "btn_ok":
         	    	ComClosePopup(); 
        	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
                 
               //(3, 0, 0, true);
		               var HeadTitle="Cost Group|Cost Code|Amount";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ 
		                      {Type:"Text",      Hidden:1, 	Width:150,  Align:"Center",  ColMerge:1,   SaveName:"calc_cost_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               ShowSubSum([{StdCol:"calc_cost_grp_cd", SumCols:"inv_amt", CaptionText:"Storage Sub Total" }]);
		               SetSheetHeight(240);
                     }


                break;
        }
    }
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:	  //Retrieve
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value=SEARCHLIST;
 			    sheetObj.DoSearch("ESD_TES_9060Popup.do", tesFrmQryStr(formObj) );
			    break;
			case IBSAVE:		//Save
				break;
			case IBINSERT:	  //Input
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //excel down
 				sheetObj.Down2Excel({ HiddenColumn:true});
				break;
		}
	}
	function sheet_OnSearchEnd(sheetObj,errMsg){
		
		//sheetObj.ShowSubSum([{StdCol:"calc_cost_grp_cd", SumCols:"2", Sort:false, ShowCumulate:false, CaptionText:"lgs_cost_cd=StorageSubTotal"}]);
		sheetObj.SetSumText(0,"lgs_cost_cd","Total");
	}
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
