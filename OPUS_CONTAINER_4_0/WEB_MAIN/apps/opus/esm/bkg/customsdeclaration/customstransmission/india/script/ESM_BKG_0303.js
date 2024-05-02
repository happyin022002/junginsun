/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0303.js
*@FileTitle : ESM_BKG_0303
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
	 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
	 */
	/**
	 * @extends
	 * @class ESM_BKG_0303 : ESM_BKG_0303 business script.
	 */
	/* Developer Work	*/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
			 var sheetObject1=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
		   switch(srcName) {
				case "btn_download":
//					if(sheetObject1.RowCount() < 1){//no data
//						ComShowCodeMessage("COM132501");
//					}else{
						doActionIBSheet(sheetObject1,formObject,MULTI);
//					}
					break;
				case "btn_close":
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
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with(sheetObj){
					var HeadTitle="flatFile";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
					var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"flat_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					InitColumns(cols);
					SetEditable(1);
					SetVisible(0);
				}
			break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case MULTI:
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				sheetObj.RemoveAll()
				formObj.f_cmd.value = MULTI;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchData("ESM_BKG_0303GS.do", FormQueryString(formObj))
				if (sXml.indexOf("<MESSAGE>") > -1) {
					showErrorMsg(sXml);
				} else {
					sheetObj.DataInsert(1);
					var flatFiles = ComGetStrEtcData(sXml, "flatFile").split("||");
					sheetObj.SetCellText(1, "flat_file", flatFiles[1]);
					sheetObj.Down2Text({ ColDelim:"", FileName:flatFiles[0]+".txt", DownHeader:false});
				}
				ComOpenWait(false);
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case MULTI: {
				//Format Check
				if (!ComChkValid(formObj)) return false;
				break;
			}
		}
		return true;
	}
	/**
	 * when enter retrieve creteria, handling
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (srcName == "vvd_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	/* Developer Work End */
