/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0300.js
*@FileTitle : ESM_BKG_0300
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects=new Array();
	var sheetCnt=0;
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
		sheet1_OnLoadFinish(sheet1);
	}
	/**
	 * event
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		//event
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	 }
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject=sheetObjects[0];
		 /*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
					case "btn_save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;
					case "btn_Close":
						ComClosePopup();
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":
				with(sheetObj){
				  var HeadTitle1="|ofc_cd|HDR_CTNT|FTR_CTNT|DECL_ADDR|BOD_CTNT";
				  var headCount=ComCountHeadTitle(HeadTitle1);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hdr_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftr_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"decl_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bod_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);

				  SetEditable(1);
				  SetCountPosition(0);
				  DataInsert(-1);
				  SetSheetHeight(100);
			}
			break;
		}
	}
	/**
	 * handling of Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSEARCH :
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				doActionIBSheet(sheetObj,formObj,SEARCH01); // searching existence of Office Code
				var exitOrg=sheetObj.GetEtcData("retExitOrg");
				if(exitOrg != "0") {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0300GS.do", FormQueryString(formObj), {Sync:2});
					if(sheetObj.RowCount()== 1){
						IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
					} else if(sheetObj.RowCount()== 0){
						initForm();
					}
				} else {
					initForm();
				}
				break;
			case IBSAVE :
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var exitOrg=sheetObj.GetEtcData("retExitOrg");
				if(exitOrg != "0") {
					IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
					sheetObj.SetCellValue(1, "ofc_cd", formObj.ofc_cd.value, 0);
					sheetObj.SetRowStatus(1, "U");
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESM_BKG_0300GS.do", FormQueryString(formObj), -1, false);
				}
				break;
			case SEARCH01 :	// searching existence of Office Code
				formObj.f_cmd.value=SEARCH01;
				sheetObj.DoSearch("ESM_BKG_0300GS.do", FormQueryString(formObj), {Sync:2});
				break;
		}
	}
	/**
	 * form clear
	 *
	 * @return
	 */
	function initForm() {
		sheetObjects[0].RemoveAll();
		sheetObjects[0].DataInsert(-1);
		IBS_CopyRowToForm(sheetObjects[0], document.form, 1, "form1_");
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH :
				//checking format
				if (!ComChkValid(formObj)) return false;
				break;
			case IBSAVE:
				//checking format
				if (!ComChkValid(formObj)) return false;
				break;
		}
		return true;
	}
	/**
	 * Enter event
	 * @return
	 */
	function obj_ComKeyEnter() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if(srcName != "form1_hdr_ctnt" && srcName != "form1_ftr_ctnt"
			&& srcName != "form1_decl_addr" && srcName != "form1_bod_ctnt") {
			ComKeyEnter();
		}
	}
	/**
	 * event after searching
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
		var exitOrg=sheetObj.GetEtcData("retExitOrg");
		if(exitOrg == "0") {
			//ComShowMessage("unusable Office code ");
			ComShowCodeMessage("BKG01107");
			return false;
		} else if(exitOrg == "") {
			if (ErrMsg == "") {
				if(sheetObj.RowCount()== 0) {
					ComShowCodeMessage("BKG00889");
					return false;
				}
			}
		} else {
		}
	}
	/**
	 * event after saving
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
		if (ErrMsg == "") {
			ComShowCodeMessage('BKG00102');
			return false;
		}
	}
