/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1136.js
*@FileTitle  : Container Loading Cross-Check (KOR)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	//Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	//Event handler processing by button name */
	function processButtonClick() {
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			case "btn_New":
				doActionIBSheet(sheetObject,formObject,IBRESET);	
			break;
			case "btn_Downexcel":
				if(sheetObject.RowCount() < 1){//no data						
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}
			break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage(dType, callGubun) {
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initControl();
		
	}
	
	/**
	 * @param{ibsheet}
	 *            sheetObj IBSheet Object
	 * @param{int}
	 *            sheetNo sheetObjects
	 */
	function initControl(){
		
		var formObject = document.form;
		
		//The required events on the screen
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	
	/**
	 * Post-processing 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(ErrMsg == "" && sheetObj.RowCount()>0) {					
			var rowCnt=sheetObj.RowCount();
			sheetObjects[1].RemoveAll();
			sheetObjects[1].DataInsert(-1);
//			var val_total_cnt = sheetObj.GetCellValue(2,"total_cnt");
//			var val_match_cnt = sheetObj.GetCellValue(2,"match_cnt");
//			var val_unmatch_cnt = sheetObj.GetCellValue(2,"unmatch_cnt");
//			if(val_total_cnt != -1 && val_match_cnt != -1 && val_unmatch_cnt != -1){
//				sheetObjects[1].SetCellValue(1,"Total",sheetObj.GetCellValue(2,"total_cnt"),0);
//				sheetObjects[1].SetCellValue(1,"Matched",sheetObj.GetCellValue(2,"match_cnt"),0);
//				sheetObjects[1].SetCellValue(1,"Unmatched",sheetObj.GetCellValue(2,"unmatch_cnt"),0);
//			}
			sheetObjects[1].SetCellValue(1,"Total",sheetObj.GetCellValue(2,"total_cnt"),0);
			sheetObjects[1].SetCellValue(1,"Matched",sheetObj.GetCellValue(2,"match_cnt"),0);
			sheetObjects[1].SetCellValue(1,"Unmatched",sheetObj.GetCellValue(2,"unmatch_cnt"),0);
			for(var i=2; i<=rowCnt+1; i++){
				if(sheetObj.GetCellValue(i,"pod_m") == 'U'){
					sheetObj.SetRowFontColor(i,"#FF0000");// read
				}
			}
			for(var k=rowCnt+1; k>=2; k--){
				if(sheetObj.GetCellValue(k,"bl") == ''){
					sheetObj.RowDelete(k,false);
				}		
			}
			for(var m=2; m<=sheetObj.RowCount()+1; m++){
				sheetObj.SetCellText(m,"seq" ,m-1);
			}
		}
	 }
	 /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //IBSheet1 init
		    with(sheetObj){
	        
		      //if (location.hostname != "")
		      //no support[check again]CLT 				InitHostInfo(location.hostname, location.port, page_path);
		      var HeadTitle1="No.|Booking No.|POD|POD|POD|Container No.|Container No.|Container No.|||||";
		      var HeadTitle2="No.|B/L|CLL|B/L|M|CLL|B/L|M|||||";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"bl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"pod_cll",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"pod_bl",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_m",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"cntrno_cll",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"cntrno_bl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntrno_m",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"total_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"match_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"unmatch_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);		  		      	    	  
		      SetSheetHeight(418);
	      	}
			break;
		case 2:      //sheet2 init
		    with(sheetObj){			
			    var HeadTitle1="Total|Matched|Un-matched";
			
			    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
			
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			    InitHeaders(headers, info);
			
			    var cols = [ {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"Total",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"Matched",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"Unmatched",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      
			    InitColumns(cols);
			    SetEditable(1);		    
			    SetSheetHeight(100);
			    SetCountPosition(0);
				}
				break;		
		}
	}
	/**
	 * Sheet handling process
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: //조회
			if (!validateForm(sheetObj, formObj, sAction))
			return;	
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH; 		
			sheetObj.DoSearch("ESM_BKG_1136GS.do", FormQueryString(formObj) );
			sheetObj.SetFocusAfterProcess(0);
			ComOpenWait(false);	
			break;
		case IBDOWNEXCEL: // 엑셀
		 	if(sheetObj.RowCount()< 1) return;
		    sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true); 		
			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
			ComOpenWait(false); 
		    sheetObj.SetWaitImageVisible(1);
			break;
						
		case IBRESET: // New
			formObj.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.vvd.focus();
			break;				
		}
	}
	/**
	 * handling process for input validation
	 * @param sheetObj 
	 * @param formObj 
	 * @param sAction 
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (!ComChkValid(formObj))
					return false;		
			break;
		}
		return true;
	}

