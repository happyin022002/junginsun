/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0554.js
*@FileTitle : Package Table
 *@author     : CLT 
 *@version    : 1.0
 *@since      : 2014/06/05
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class esm_bkg_0554 : business script for esm_bkg_0554
	 */
	function esm_bkg_0554() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
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
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					case "btn_new":
						sheetObjects[0].RemoveAll();
						ComResetAll();
						ComSetObjValue(formObject.ibflag,"I");
					break;
					case "btn_del":
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;
					case "btn_inquiry":
						//ComOpenWindow2("ESM_BKG_0345.do?pgmNo=ESM_BKG_0345&cnt_cd="+formObject.cnt_cd.value,"ESM_BKG_0345", "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=1024,height=520");
						document.location.href="/opuscntr/ESM_BKG_0345.do?pgmNo=ESM_BKG_0345&cnt_cd="+formObject.cnt_cd.value;
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
		initControl();
	}
	/**
	 * loading HTML Control event <br>
	 * initializing initControl
	 * @param sheetObj IBSheet Object
	 * @param sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		var formObject=document.form;
		// Axon event handling. event catch
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- in case of typing keyboard
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus out
		axon_event.addListenerForm('keydown', 'ComKeyEnter', formObject);
	}
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj,sheetNo) {
	 var cnt=0;
	   switch(sheetNo) {
		   case 1:   //sheet1 init
				with(sheetObj){

			 var HeadTitle1=" |";

			 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			 InitHeaders(headers, info);

			 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" } ];

			 InitColumns(cols);

			 SetEditable(1);
			 //SetSheetHeight(0);
			 SetVisible(0);
				   }
			   break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateSearchForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0554GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
				}
				break;
			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)) {
					if (ComShowCodeConfirm("BKG00535") == false) return;
					formObj.f_cmd.value=MULTI;
					//행 삭제 FLAG처리
					sheetObj.SetCellValue(1, "ibflag","D",0);
					ComSetObjValue(formObj.ibflag,"D");
					var SaveXml = sheetObj.GetSaveData("ESM_BKG_0554GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveData(SaveXml,{Sync:1});
				}
				break;
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					var SaveXml = sheetObj.GetSaveData("ESM_BKG_0554GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveData(SaveXml,{Sync:1});   
				}
				break;
			case IBRESET:      //location retrieve
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0554GS.do", FormQueryString(formObj));
				if (ComGetEtcData(sXml,"loc_nm") == undefined){
					ComShowCodeMessage('BKG00061',formObj.loc_cd.value);
					formObj.loc_cd.value="";
					formObj.loc_nm.value="";
					formObj.loc_cd.focus();
				}else{
					formObj.loc_nm.value=ComGetEtcData(sXml,"loc_nm");
				}
				break;
		}
	}
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var cnt_cd=formObj.cnt_cd.value;
		var wh_cd=formObj.wh_cd.value;
		 if (ErrMsg == "") {
			if (ComGetObjValue(formObj.ibflag) == "D"){
				ComShowCodeMessage('BKG00593');
				ComSetObjValue(formObj.ibflag,"I");
				ComResetAll();
				formObj.cnt_cd.value=cnt_cd;
				formObj.wh_cd.value=wh_cd;
			}else{
				sheetObj.SetCellValue(1, "ibflag","U",0);
				ComSetObjValue(formObj.ibflag,"U");
				ComBkgSaveCompleted();  //server message handling
			}
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 }
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var cnt_cd=formObj.cnt_cd.value;
		var wh_cd=formObj.wh_cd.value;
		with (sheetObj) {
			if (RowCount("R") == 0){
				sheetObj.RemoveEtcData();
				sheetObj.SetCellValue(1, "ibflag","I",0);
				ComEtcDataToForm(formObj, sheetObj);
				ComSetObjValue(formObj.ibflag,"I");
				formObj.cnt_cd.value=cnt_cd;
				formObj.wh_cd.value=wh_cd;
				ComShowCodeMessage('BKG00095');
			}else{
				sheetObj.SetCellValue(1, "ibflag","U",0);
				ComEtcDataToForm(formObj, sheetObj);
				ComSetObjValue(formObj.ibflag,"U");
			}
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateSearchForm(sheetObj, formObj,sAction){
		if (formObj.cnt_cd.value == ""){
			ComShowCodeMessage('BKG00626', 'Country Code');
			formObj.cnt_cd.focus();
			return false;
		}
		if (formObj.wh_cd.value == ""){
			ComShowCodeMessage('BKG00626', 'Bonded Area Code');
			formObj.wh_cd.focus();
			return false;
		}
		return true;
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj,sAction){
		if (!ComChkValid(formObj)) return false;
		return true;
	}
	/**
	 * control keyboard input at onkeypress event of HTML Control
	 **/
	function obj_deactivate() {
		var formObj=document.form;
		switch (ComGetEvent("name")) {
		case "loc_cd":
			if (event.srcElement.value != ''){
				doActionIBSheet(sheetObjects[0],document.form,IBRESET);
			}else{
				formObj.loc_nm.value="";
			}
			break;
		default:
			break;
		}
	}
