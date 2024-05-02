//=========================================================
//*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
//*@FileName   esm_bkg_0696.js
//*@FileTitle  : Package Table
//*@author     : CLT
//*@version    : 1.0
//*@since      : 2014/04/08
//=========================================================
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author
 */
	/**
	 * @extends 
	 * @class esm_bkg_0696 : esm_bkg_0696 - task script definition for screen
	 */

	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var formObject=document.form;
		var sheetObject=sheetObjects[0];
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_select":
				if(sheetObj.CheckedRows("check") ==  0){
					ComShowMessage("Please check row") ;
					return false;
				}
				
				if(sheetObj.GetSelectRow()!=-1){
					var obj=new Object(); 
					obj.cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pck_cd");
					obj.nm=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pck_nm");
					obj.usa_cstms=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "usa_cstms_pck_cd");				
					ComPopUpReturnValue(obj);
				}else{
					ComClosePopup(); 
				}

				break;
			case "btn_Close":
					ComClosePopup(); 
				break;
			case "btn_downexcel":
				if(sheetObject.RowCount() < 1){//no data		
					ComShowCodeMessage("COM132501");		
					}else{
						sheetObject.SetHeaderBackColor("#CCCCCC");
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
						sheetObject.SetHeaderBackColor("#333333");						
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
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * load HTML Control event on the page <br>
	 * {@link #loadPage}call the function and init IBSheet Object <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 
	 */
	function initControl() {
		var formObject=document.form;
		// Axon Event process1 Event catch(Develoer can change)
//		axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); //- in case of keyboard input
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * setting sheet initial values and header
	 * 
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
	    	case 1: // sheet1 init
	    	with(sheetObj){
		      var HeadTitle1="Sel.|Sel.|Seq.|Code|Description|US Customs";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Radio",     Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"check",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"pck_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"usa_cstms_pck_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		      if (location.href.indexOf("POP") < 1 ){
		    	  SetColHidden("radio",1);
		      }
		      InitColumns(cols);
//		      SetColHidden("check",1);
		      SetWaitImageVisible(0);
		      if (location.href.indexOf("POP") < 1 ){
			      	SetSheetHeight(347);
			      }
			      else
			      {
			    	  SetSheetHeight(247);
			      }
	        }
	    	break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
			ComOpenWait(true);
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0696GS.do", FormQueryString(formObj )
						+ "&" + ComGetPrefixParam(""));
			}
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		}
		return true;
	}

   function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
   }
   function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {	   
	   //if ( Col == "1") {
		   if(sheetObj.CheckedRows("check") > 0){
			   sheetObj.CheckAll(1, 0, 0)
			   sheetObj.SetCellValue(Row, 1, 1, 0);
		   } else {
			   sheetObj.SetCellValue(Row, 1, 1, 0);
		   }
	   //}
   }
   
   