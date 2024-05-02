/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0062.jsp
 *@FileTitle : IMO Type Portable Tanks - Inquiry
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
     * @class vop_scg_0062 : business javascript for vop_scg_0062 
     */

    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) { 
                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;
                case "btn1_Excel":
                    var paramObj=new Object();
                    paramObj.title="IMO Type Portable Tanks";
                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="2:10|3:65";
//                    paramObj.datarowheight="1:50|2:50";
//                    var url=ComScgGetPgmTitle(sheetObjects[0], paramObj); 
//                    if(sheetObjects[0].RowCount() < 1){//no data
//                    	ComShowCodeMessage("COM132501");
//                    }else{
//                    	 sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(                    sheetObjects[0]), SheetDesign:1,Merge:1 });
//                    }
					var sheetExcelObj = sheetObjects[0];
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
        // doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     
      //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
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
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    // setting height
            	
//            	(5, 0, 0, true);
            	var HeadTitle="|No.|IMO Type|Description|";

            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            Wrap:1 },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE",              Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_tnk_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1,     Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:750,  Align:"Left",    ColMerge:1,   SaveName:"imdg_tnk_tp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:300,   Wrap:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000,  Wrap:1 } ];
            	 
            	InitColumns(cols);
            	//SetSheetHeight(460);
            	resizeSheet();
            	SetEditable(0);
                }
                 break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH;
                         sheetObj.DoSearch("VOP_SCG_0044GS.do", FormQueryString(formObj) );
                    }
                }           
                break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
        return true;
     }
