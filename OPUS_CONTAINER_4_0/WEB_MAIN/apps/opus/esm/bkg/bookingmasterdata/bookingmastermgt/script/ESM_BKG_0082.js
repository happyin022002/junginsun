/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0082.js
*@FileTitle  : Booking Creation 1_MT P/UP CY inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// public variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			// ComDebug(srcName);
			switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_confirm":
				callPopupOK(sheetObject);
	     			break;
			case "btn_close":
                ComClosePopup(); 
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}

	/**
	 * load HTML Control event on the page <br>
	 * {@link #loadPage}call the function and init IBSheet Object <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {int} sheetNo sheetObjects 
	 */
	function initControl() {
		var formObject=document.form;
		// Axon Event process1 Event catch(Develoer can change)
		//axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); 
		//axon_event.addListenerForm ('keydown', 'ComKeyEnter', document.form);
		//axon_event.addListener('change', 'yd_cd_change', 'yd_cd'); //- Yd
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * setting sheet initial values and header  adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: 
            with(sheetObj){
                var HeadTitle1=" ||Yard|YD_NM|PHN_NO|YD_PIC_NM";
                
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:0,   SaveName:"yd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:0,   SaveName:"phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:0,   SaveName:"yd_pic_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(312);
            }
			break;
		case 2: // t1sheet1 init
            with(sheetObj){
                var tempTilte="Available EQ Status per Day(estimated)";
                var HeadTitle="Booking|Booking|Available EQ Status per Day(estimated)";
                for (var i=1; i < 15; i++) {
                    HeadTitle=HeadTitle + "|" + tempTilte;
                }
                var HeadTitle2="TP/SZ|QTY|Today|D+1|D+2|D+3|D+4|D+5|D+6|D+7|D+8|D+9|D+10|D+11|D+12|D+13";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty1",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty2",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty3",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty4",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty5",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty6",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty7",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty8",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty9",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty10",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty11",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty12",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",  ColMerge:1,   SaveName:"fcast_qty13",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(250);
            }
      

			break;
		}
	}
	/**
	 * event after retrieve <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {col} ErrMsg 
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObjects[1].RemoveAll();
		sheet1_OnClick(sheetObjects[0], 1, 1, '');
	}
	/**
	 * event after sheet click <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {col} ErrMsg 
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		// var sheetObject = sheetObjects[1];
		if (sheetObj.RowCount() > 0) {
	        ComSetObjValue(formObj.yd_nm, sheetObj.GetCellValue(Row, "yd_nm"));
	        ComSetObjValue(formObj.phn_no, sheetObj.GetCellValue(Row, "phn_no"));
	        ComSetObjValue(formObj.yd_pic_nm, sheetObj.GetCellValue(Row, "yd_pic_nm"));
	        formObj.selectSheetYdCd.value=sheetObj.GetCellValue(Row, "yd_cd");
	        if (sheetObj.GetCellValue(Row, "yd_nm") != ''){
				doActionIBSheet(sheetObjects[1], formObj, IBROWSEARCH);
			}
		}
	}
		// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		// sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("ESM_BKG_0082GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
			}
			break;
		case IBROWSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;
 	   			var sXml=sheetObj.GetSearchData("ESM_BKG_0082GS.do" , FormQueryString(formObj));
	   			var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
				setMakeChildSheetVal(formObj);
				ComOpenWait(false);
			}
			break;
		}
	}
	/**
	 * display values from mother screen<br>
	 * 
	 * @param {form} formObj 
	 */
	function setMakeChildSheetVal(formObj){
		var  parentRefSheet ;
		var win = opener || parent;
		if (formObj.callSheetIdx.value !=""){
			parentRefSheet=win.sheetObjects[formObj.callSheetIdx.value];
		}else{
			parentRefSheet=win.sheetObjects[0];
		}
		var  mySheet=sheetObjects[1];
		for (i=2; i<= mySheet.LastRow(); i++) {
			for (j=0; j<= parentRefSheet.LastRow(); j++) {
				if (mySheet.GetCellText(i, "cntr_tpsz_cd") == parentRefSheet.GetCellText(j, "cntr_tpsz_cd")){
                    mySheet.SetCellValue(i, "op_cntr_qty",ComAddComma(parentRefSheet.GetCellValue(j, "op_cntr_qty")));
				}
			}
		}
		for (k=1; k<= parentRefSheet.LastRow(); k++) {
			if (isSheetCheckVal(mySheet,"cntr_tpsz_cd",parentRefSheet.GetCellText(k, "cntr_tpsz_cd")) == false){
				var iRow = mySheet.DataInsert(-1);
				mySheet.SetCellText(iRow,"cntr_tpsz_cd" ,parentRefSheet.GetCellText(k, "cntr_tpsz_cd"));
				mySheet.SetCellText(iRow,"op_cntr_qty" ,ComAddComma(parentRefSheet.GetCellText(k, "op_cntr_qty")));
				sheetCnt++
			}
		}
	}
	/**
	 * In case of checking on popup, sending values to mother screen <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {col} formObj
	 * @param {val) check
	 * @return {boolean} 
	 */
	function isSheetCheckVal(sheetObj,col,checkVal){
		for (i=1; i<= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellText(i, col) == checkVal){
				return true;
			}
		}
		return false;
	}
	/**
	 * In case of checking on popup, sending values to mother screen  <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {String} value 
	 */
	function callPopupOK(sheetObj) {
		var formObj=document.form;
		var calllFunc;
		var rArray=null;
		rArray=getLocalCheckedRows(sheetObj);
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc=formObj.calllFunc.value;
		if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
        else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
        ComClosePopup(); 
	}
	/**
	 * row value return <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {String} column name
	 */
	function getLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt=sheetObj.LastCol()+ 1;
 		var rows=sheetObj.LastRow() +1;
		var rArray=null; // Array for row
		var cArray=null; // Array for column
		checkRows=sheetObj.FindCheckedRow('check');
		if(checkRows == "") return null;
		var arrRow = checkRows.split("|");
		rArray=new Array(arrRow.length-1);
		for(var i=0; i<arrRow.length; i++){
			var iRow = arrRow[i];
		    cArray=null;
  			// In case of define column name
  			if(colName != null && colName != "") {
                cArray=sheetObj.GetCellValue(iRow, colName);
		  	} else {
		  		cArray=new Array(colsCnt);
				for(var j=0; j<cArray.length; j++) {
                    cArray[j]=sheetObj.GetCellValue(iRow, j);
	            }
	        }
	        rArray[i]=cArray;
		}
	  	return rArray;
	}
	/**
	 * handling process for input validation <br>
	 * 
	 * @param {ibsheet} sheetObj 
	 * @param {form} formObj 
	 * @param {ibsheet} sAction 
	 * @param {String} value 
	 * @return {boolean}
	 * @see #ComChkValid
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			switch (sAction) {
			case IBSEARCH:
    			if(ComIsNull(formObj.loc_cd)){	
    				ComShowCodeMessage("BKG00545", 'Yard Code');		
    				formObj.loc_cd.focus();
    				return false;    			    				    				
    			}else if (!ComIsNull(formObj.loc_cd) && formObj.loc_cd.value.length < 5) {
    				formObj.loc_cd.focus();
    			}
				break;
			}
		}
		return true;
	}
