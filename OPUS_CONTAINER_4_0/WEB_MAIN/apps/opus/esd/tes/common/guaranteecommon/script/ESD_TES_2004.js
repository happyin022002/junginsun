/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2004.js
*@FileTitle : Ref.No. Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * Event handler processing by button click event 
 */
document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 **/
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					if ( ComIsNull ( document.getElementById("cntr_no").value ) && ComIsNull ( document.getElementById("bl_no").value ) ) {
						ComShowCodeMessage('TES70201');    // Please enter Item.
						document.getElementById("cntr_no").focus();
						return false;
					}
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_select":
					var selectedRow=sheetObject1.GetSelectionRows('|').split('|');
					var	rowArray=new Array();
					for(var i=selectedRow.length - 1; i >= 0; i-- ) {
						if(selectedRow[i]=="") // 29/07/2014
							selectedRow[i]="0"; // 29/07/2014
						if (sheetObject1.GetCellValue(selectedRow[i], "ref_no") != null ) {
							rowArray[0]=sheetObject1.GetCellValue(selectedRow[i], "ref_no");
							rowArray[1]=sheetObject1.GetCellValue(selectedRow[i], "inv_no");
						}
					}
//					window.dialogArguments.getRefNo(rowArray);
					 var opener=window.dialogArguments;
				     if (!opener) opener=parent;
				     opener.getRefNo(rowArray);
				
					ComClosePopup(); 
					break; 
				case "btn_close":
					ComClosePopup(); 
					break; 
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');   //The service is not available now
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source. <br>
	 * @param{ibsheet}		sheet_obj		IBSheet Object
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
	 }
	/**
	 * setting sheet initial values and header
	 * adding case as numbers of counting sheets
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,string}  sheetNo		Sheet Object 
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
			    with(sheetObj){
		        
			    var HeadTitle1="||REF No.|INV No.";
			      var headCount=ComCountHeadTitle(HeadTitle1);
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      //to-be templatePop.jsp에 <%@include file="/bizcommon/include/common.jsp"%> 포함되어 앞의 컬럼 하나를 Hidden처리 해버림
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetCountPosition(0);
			      SetSheetHeight(162);
			     }
				break;
		}
	}
	/**
	 * IBhandling sheet process.<br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {Object}		formObj		Form Object
	 * @param {String}		sAction		Action Command
	 */	
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;	
 				sheetObj.DoSearch("ESD_TES_2004GS.do", tesFrmQryStr(formObj)  );				
				break;
		}
	}
