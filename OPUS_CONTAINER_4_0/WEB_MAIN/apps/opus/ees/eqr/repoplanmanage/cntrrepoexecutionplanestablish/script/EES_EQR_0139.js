/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0139.js
*@FileTitle : EQR Organization Chart
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
	// common static variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(!ComIsBtnEnable(srcName) ) return;
			switch(srcName) {
				case "btn_new":
					formObject.reset();
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_print":
					break;	
				case "btn_close":
		            ComClosePopup(); 
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("EQR90004");
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
	function loadPage(list) {
		var cntList=list.split(",");
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i]);		
			initSheet(sheetObjects[i],i+1, cntList);
			ComEndConfigSheet(sheetObjects[i]);		
		}
		var sheetObj=sheetObjects[0];
		sheetObj.RemoveAll();
		doActionIBSheet(sheetObjects[0], document.form , IBSEARCH);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo, cntList) {
		var cnt=0;
		//alert(cntList[0]);
		switch(sheetNo) {
			case 1:      //t1sheet1 init
			    with(sheetObj){
		        
		      var HeadTitle="RCC("+cntList[0]+")|LCC("+cntList[1]+")|ECC("+cntList[2]+")|SCC("+cntList[3]+")";

		      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"scc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 19));
		            }
				break;
		}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCHLIST;
 				sheetObj.DoSearch("EES_EQR_0139GS.do", eqrFormQryStr(formObj) );
				break;
			case IBDOWNEXCEL:
 				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
				break;
		}
	}
	function sheet1_OnSaveEnd(sheetObj, errMsg){
		if(errMsg == ''){
			ComShowCodeMessage("EQR90106");
		}
	}

	