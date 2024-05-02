/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1001.js
*@FileTitle  : Chassis Type/Size Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1001 : ees_cgm_1001 business script for
 */
	function ees_cgm_1001() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* developer jop */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** use additional sheet var in case of more than 2 tap each sheet *****/
		var sheetObject1=sheetObjects[0];
		//var sheetObject2 = sheetObjects[1];
		/** *****************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve":
				//alert("btn_retrieve");
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_save":
				//alert("btn_save");
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn_add":
				//alert("btn_add");
				doActionIBSheet(sheetObject1,formObject,IBINSERT);
				break;
			case "btn_del":
				//alert("btn_del");
				doActionIBSheet(sheetObject1,formObject,REMOVE);
				break;
			} // end switch
			tRoleApply();
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
			// 
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// 
			ComEndConfigSheet(sheetObjects[i]);
		}
		var formObject=document.form;
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		tRoleApply();
	}
	/**
	 * sheet setting and init in case of load finish <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */     
	 function sheet1_OnLoadFinish(sheetObj) {
	     sheetObj.SetWaitImageVisible(0);
	 	 for (i=0; i < sheetObjects.length; i++) {
		     doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
		 }
	     doActionIBSheet(sheetObj,document.form,IBCLEAR);
	     sheetObj.SetWaitImageVisible(1);
	 }
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
			      var HeadTitle="|Sel|Display Seq.|Chassis Type/Size|Description|Size||Old Chassis Type/Size";
			      var prefix="sheet1_";
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:40 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_tpsz_rep_cd" },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_knd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
				             //20160517 added by Jun Kato 
				             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",    ColMerge:0,   SaveName:prefix+"modi_eq_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 }];
			      			 //
			      InitColumns(cols);
			      SetEditable(1);
			      sheetObj.SetColProperty(0 , prefix+"eq_tpsz_rep_cd", {ComboText:"20|40|45", ComboCode:"20|40|45"} );
			      sheetObj.SetColProperty(0 , prefix+"eq_tpsz_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			      //20160517 added by Jun Kato
			      sheetObj.SetColProperty(0 , prefix+"modi_eq_tpsz_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			      //
//			      SetSheetHeight(362);
			      resizeSheet();
	            }
			break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
	
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var prefix="sheet1_";
		//sheetObj.ShowDebugMsg = false;
		var form=document.form;
		var sheetObject1=sheetObjects[0];
		switch (sAction) {
		case IBSEARCH: // retrieve
			//alert(" Retrieve .. ");
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);		 	
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("EES_CGM_1001GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
	 		ComOpenWait(false);
			break;
		case IBSAVE: // saving
			//alert(" Save .. ");
			for(i=1; i<sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, prefix + "eq_tpsz_cd") == "" || sheetObj.GetCellValue(i, prefix + "eq_tpsz_cd") == null){
					ComShowCodeMessage("CGM10004", "Chassis Type/Size");
					sheetObj.SelectCell(i, prefix + "eq_tpsz_cd", true);
					return
				}
				if(sheetObj.GetCellValue(i, prefix + "diff_desc") == "" || sheetObj.GetCellValue(i, prefix + "diff_desc") == null){
					ComShowCodeMessage("CGM10004", "Description");
					sheetObj.SelectCell(i, prefix + "diff_desc", true);
					return
				}
				
				//Added by Jun Kato
				if(sheetObj.GetCellValue(i, prefix + "modi_eq_tpsz_cd") == "" || sheetObj.GetCellValue(i, prefix + "modi_eq_tpsz_cd") == null){
					ComShowCodeMessage("CGM10004", "Old Chassis Type/Size");
					sheetObj.SelectCell(i, prefix + "modi_eq_tpsz_cd", true);
					return
				}
				//
			}
			sheetObj.SetWaitImageVisible(0);
	 		ComOpenWait(true);		 	
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("EES_CGM_1001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	 		ComOpenWait(false);		 
			break;
		case IBINSERT: // inserting
			sheetObj.DataInsert(0);
			// setting hidden culumn value(CUD Query mandatory culumn value)
			var seq=1;
			for(i=1; i<sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, prefix + "ibflag") == "D") {
					continue;
				}
				// setting hidden culumn value
				sheetObj.SetCellValue(i, prefix + "eq_knd_cd",document.forms[0].eq_knd_cd.value);
				//
				//alert(sheetObj.RowCount());
				sheetObj.SetCellValue(i, prefix + "dp_seq",seq);
				seq++;
			}
	        break;
		case REMOVE: // deleting
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sRow=sheetObject1.FindCheckedRow("sheet1_del_chk");
			var arrRow=sRow.split("|");
			for(var i=arrRow.length-1; i>=0; i--){
				formObj.f_cmd.value=SEARCH01;
				formObj.eq_tpsz_cd.value=sheetObject1.GetCellValue(arrRow[i],"sheet1_eq_tpsz_cd" );
				var sXml=sheetObject1.GetSearchData("EES_CGM_1001GS.do", FormQueryString(formObj));
				// data count
				var dataCount=ComGetTotalRows(sXml);
				if(dataCount > 0){
					ComShowCodeMessage('CGM10070');
					ComOpenWait(false);	
					return;
				}
			}	
			ComOpenWait(false);	
			ComRowHideDelete(sheetObject1, prefix + "del_chk");
			var seq=1;
			for(i=1; i<sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, prefix + "ibflag") == "D") {
					continue;
				}
				sheetObj.SetCellValue(i, prefix + "dp_seq",seq);
				seq++;
			}
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			// if (!isNumber(formObj.iPage)) {
			// return false;
			// }
		}
		return true;
	}
	/**
	 * M.G.Set  duplication check
	 */
	function sheet1_OnChange(sheetObj, Row, Col){
		var sheetObj=sheetObjects[0];
	 	var formObj=document.form;
	 	var prefix="sheet1_"; 
	 	var invRefNoCol=sheetObj.SaveNameCol(prefix + "eq_tpsz_cd");
	 	if (Col == invRefNoCol && Row !=0) { 
	 		var GetCellValue=sheetObj.GetCellValue(Row, Col);
	 		var Row2=sheetObj.FindText(Col, GetCellValue, Row, -1, false);

	 		if(Row2 > 0){
	 			var startRow = parseInt(Row2)+1;
	 			Row2=sheetObj.FindText(Col, GetCellValue, startRow, -1, false);
	 			if (Row2 > 0) {
		        	alert('Please check up the Duplicated Chassis Type/Size');
					// Setting Cell value to Null
					sheetObj.SetCellValue(Row, Col,'',0);
					// focus to grid
					sheetObj.SelectCell(Row, Col, 1);
	 			}
			}
		}
	 	//20160517 added by Jun Kato
	 	var invRefNoCol2=sheetObj.SaveNameCol(prefix + "modi_eq_tpsz_cd");
	 	if (Col == invRefNoCol2 && Row !=0) { 
	 		var GetCellValue=sheetObj.GetCellValue(Row, Col);
	 		var Row2=sheetObj.FindText(Col, GetCellValue, Row, -1, false);

	 		if(Row2 > 0){
	 			var startRow = parseInt(Row2)+1;
	 			Row2=sheetObj.FindText(Col, GetCellValue, startRow, -1, false);
	 			if (Row2 > 0) {
		        	alert('The Old Chassis Type/Size is duplicated.');
					// Setting Cell value to Null
					sheetObj.SetCellValue(Row, Col,'',0);
					// focus to grid
					sheetObj.SelectCell(Row, Col, 1);
	 			}
			}
		}
	 	//
	 	
	}
	 /**
	  * function(ex:btn_save) role(trole) apply  <br>
	  * @param 
	  * @return 
	  * @author 
	  * @version 
	  */     
	  function tRoleApply() {
//		  var formObj=document.form;
//		  if(formObj.trole.value == "Authenticated")
//		  {
//		  }else
//		  {
//			  ComBtnDisable("btn_save");
//			  ComBtnDisable("btn_del");
//			  ComBtnDisable("btn_add");
//		  }
	  } 
	/* developer jop end */
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if (errMsg == null || errMsg == 0 || errMsg == "" || errMsg == undefined) {
			ComShowCodeMessage("CGM00003");
		}
	}