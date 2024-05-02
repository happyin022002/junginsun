/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0184.js
*@FileTitle  : Customer Code Entry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Customer Code Entry : business script for Customer Code Entry
     */
    function esm_bkg_0184() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    /* developer job	*/
    // common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
    function processButtonClick(){
    	var sheetObject1 = sheetObjects[0];
        var formObject = document.form;
     	try {
     		var srcName=ComGetEvent("name");
 					switch(srcName) {
 						case "btn_DownExcel":
// 							sheetObject1.Down2Excel({ HiddenColumn:-1});
 			                if(sheetObject1.RowCount() < 1){//no data
 			                    ComShowCodeMessage("COM132501");
 			                    return;
 			                }
 							sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),  Merge:1});
 		 					break;
 						case "btn_close":
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1" :
			    with(sheetObj){
				      var HeadTitle1="|Seq.|Message Detail";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus",  Wrap:1 },
						           {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
						           {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"edi_msg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 } 
					             ];
				      InitColumns(cols);
				      SetSheetHeight(500);
				      SetEditable(1);
			     }
			break;
		}
	}
    
    // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					var target;
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0184GS.do", FormQueryString(formObj));
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
				}
			break;
         }
     }
    
     /**
     * handling process for input validation
     */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	 		case IBSEARCH: // retrieve
	 			/*
	 			if (formObj.bl_no.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00266');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			*/				
	 			return true;
	 		break;	 			 			
  	}
}