/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0367_02.js
*@FileTitle  : EXPORT REFERENCES
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/16
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	/**
	 * Event handler processing by button name
	 */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
//		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_Select":
				var sheet1TotRow = sheetObject1.GetTotalRows();
				var sheet2TotRow = sheetObject2.GetTotalRows();
				if(sheet1TotRow == 0 && sheet2TotRow == 0){
					return;
				}
				
				var rArray = selectExpRef(sheetObject1, sheetObject2);
//				if(!opener) {
//					opener=parent;
//				}
				try {
					//callback_func
					opener.callBackExRef(rArray);
					ComClosePopup();
				}catch(e){
					ComShowCodeMessage("COM12111");
				}
	
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
			} // end switch
		} catch (ex) {
			if (ex == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				alert(ex.message);
			}
			bkg_error_alert('', ex);
		}
	}		


	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param sheet_obj
	 * @return 
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		if(!opener) opener=window.dialogArguments;
		if(!opener) opener=parent;
		
		if (document.form.bkg_no.value == ''){
			ComShowCodeMessage("BKG00463");
			ComClosePopup(); 
		}
		for (var i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1)
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (var k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //t1sheet1 init
		    with(sheetObj){
				var HeadTitle1="||Type|Reference|show";
				var prefix="sheet1_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_ref_tp_cd" },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_ref_tp_nm", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:600,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_ref_no_ctnt", 	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk",				KeyField:0,   CalcLogic:"",   Format:"",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
				InitColumns(cols);
				SetEditable(1);
				SetCountPosition(2);
				SetSheetHeight(350);
			}
			break;
		case 2:
			with(sheetObj){
				var HeadTitle1="||Type|Container No.|Reference|show";
				var prefix="sheet2_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_ref_tp_cd" },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_ref_tp_nm",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",				KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:500,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_ref_no_ctnt",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk",				KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				InitColumns(cols);
				SetEditable(1);
				SetCountPosition(2);
				SetSheetHeight(350);
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
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var aryPrefix=new Array("sheet1_", "sheet2_");
		switch (sAction) {
		case IBSEARCH: //retrieve
			ComSetObjValue(formObj.f_cmd, SEARCH);
	 		var sXml=sheetObj.GetSearchData("ESM_BKG_0367_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	 		var arrXml=sXml.split("|$$|");

	 		for ( var i=0; i < arrXml.length; i++) {
				sheetObjects[i].LoadSearchData(arrXml[i], {Sync:1} );
			}
			break;
		}
	}

	/**
	 * Tab option
	 * setting tab list
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				InsertItem( "BKG Reference", "");
				InsertItem( "Other Reference", "");
			}
			break;
		}
	}
	/**
	 * activating tab when click tab
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		// --------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab=nItem;
	}
	function bkg_error_alert(msg, ex) {
		alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
	}
	
	/**
	 * BKG Reference, Other Reference 선택
	 * @param sheetObject1 BKG Reference 선택
	 * @param sheetObject2 Other Reference 선택
	 * @returns [BKG Reference][Other Reference]2차원 배열로 리턴
	 */
	function selectExpRef(sheetObject1, sheetObject2) {
		var arrRow = new Array(2);
		var prefix1="sheet1_";
		var prefix2="sheet2_";
    	var rArray = new Array(2);
		
		var colsCnt=sheetObject1.LastCol()+ 1;
  		var sCheckRows1 = sheetObject1.FindCheckedRow(prefix1+"chk");
    	arrRow[0] = sCheckRows1.split("|");
 		if(sCheckRows1 == ""){
 			rArray[0]=new Array(0);
 		}else{
 			rArray[0]=new Array(arrRow[0].length);
 	    	for(var idx=0; idx<arrRow[0].length; idx++){ 
 	  			rArray[0][idx]=new Array(colsCnt);
 	  			for(var j=0; j<rArray[0][idx].length; j++) {
 	  				rArray[0][idx][j]=sheetObject1.GetCellValue(arrRow[0][idx], j);
 	            }
 	    	}
 		}

		colsCnt=sheetObject2.LastCol()+ 1;
  		var sCheckRows2 = sheetObject2.FindCheckedRow(prefix2+"chk");
    	arrRow[1] = sCheckRows2.split("|");
 		if(sCheckRows2 == ""){
 			rArray[1]=new Array(0);
 		}else{
 			rArray[1]=new Array(arrRow[1].length);
 	    	for(var idx=0; idx<arrRow[1].length; idx++){ 
 	  			rArray[1][idx]=new Array(colsCnt);
 	  			for(var j=0; j<rArray[1][idx].length; j++) {
 	  				rArray[1][idx][j]=sheetObject2.GetCellValue(arrRow[1][idx], j);
 	            }
 	    	}
 		}

	  	return rArray;
	}
