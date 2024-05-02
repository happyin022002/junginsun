/*=========================================================
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0924.js
*@FileTitle : Yard Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
         var sheetObject=sheetObjects[0];
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
    			ComShowMessage(OBJECT_ERROR);
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
        sheet1_OnLoadFinish(sheetObj);
    }
	/*
	* Sheet processing to eliminate screen blinks
	*/
    function sheet1_OnLoadFinish(sheetObj) {   
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
	}   
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
                
	              var HeadTitle1="|YARD|S.Day|40'|20'|AK40|AK20|DG40|DG20|RF40'|RF20'";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"s_day",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"ft40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"ft20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"ak40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"ak20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"dg40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"dg20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"rf40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"rf20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	               
	              ShowSubSum([{StdCol:prefix1+"yd_cd", SumCols:prefix1+"ft40|"+prefix1+"ft20|"+prefix1+"ak40|"+prefix1+"ak20|"+prefix1+"dg40|"+prefix1+"dg20|"+prefix1+"rf40|"+prefix1+"rf20", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"SubTotal"}]);
	              InitColumns(cols);
	              SetEditable(1);
	              SetCountPosition(0);
	              SetWaitImageVisible(0);
	              SetSheetHeight(250);
              }
			break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
       var arrPreFix=new Array("sheet1_");
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //retrieve
          		ComOpenWait(true);
				formObj.f_cmd.value=SEARCH; 
				var sXml=sheetObj.GetSearchData("ESM_BKG_0924GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break; 
        }
    }
		// rretrieve happened and completion Event using retrieve
	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
		ComOpenWait(false);
		sheetObj.SetSumText(1, "Grand Total")
		var sRow=sheetObj.FindSubSumRow(prefix1 +"yd_cd");
        var arrRow=sRow.split("|");
		for (idx=0; idx<arrRow.length-1; idx++) { 
			sheetObj.SetCellFont("FontBold", arrRow[idx],1, arrRow[idx],LastCol(),1);
		}
	}
