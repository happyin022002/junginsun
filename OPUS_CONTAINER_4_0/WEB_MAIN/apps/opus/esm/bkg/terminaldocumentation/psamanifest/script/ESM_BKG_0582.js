	/*
	=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName   : ESM_BKG_0582.js
	*@FileTitle  : PSA Port Registeration 
	*@author     : CLT
	*@version    : 1.0
	*@since      : 4/28/2014
	=========================================================
	*/
	
	
	/**
	 * @extends
	 * @class ESM_BKG_0582 : business script for ESM_BKG_0582
	 */
	function esm_bkg_0582()
	{
		this.processButtonClick=processButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
		this.resetForm=resetForm;
	}
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_new":
				resetForm();	
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_rowAdd":
				sheetObjects[0].DataInsert(-1);
				break;
			case "btn_delete":
				if(ComShowCodeConfirm('BKG95003', 'delete')){ 
					doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
				}
				break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
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
		// process input Key
	//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
		case 1:      //sheet1 init
		    with(sheetObj){
		      var HeadTitle1="|Sel.|OPUS Port CD|OPUS Port CD|PSA Port CD";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",      KeyField:0,   CalcLogic:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, CaseSensitive: 1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tml_cd",      KeyField:0,   CalcLogic:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"psa_loc_cd",  KeyField:0,   CalcLogic:"",           PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
		      InitColumns(cols);
		      SetColProperty(0, "loc_cd" , {AcceptKeys:"N|E|", InputCaseSensitive: 1});
		      SetColProperty(0, "tml_cd" , {AcceptKeys:"N|E|", InputCaseSensitive: 1});
		      SetColProperty(0, "psa_loc_cd" , {AcceptKeys:"N|E|", InputCaseSensitive: 1});
		      SetEditable(1);
		      SetSheetHeight(400);
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
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBSEARCH:      //retrieve
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0582GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
			}
			break;
		case IBSAVE:        
				formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSave("ESM_BKG_0582GS.do",  FormQueryString(formObj));
				ComOpenWait(false);
			break;
			
		case IBDELETE:      
			ComRowHideDelete(sheetObj,"sel");
			break;
		}
	}
	/**
	* handling process for input validation <br>
	* @param sheetObj
	* @param formObj
	* @param sAction
	* @return boolean
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (port_cd.value.length == 0) {
				ComShowCodeMessage("BKG00424");
				return false;
			}
			if (port_cd.value.length < 5) {
				ComShowMessage(ComGetMsg("COM12174","Port CD", "5"));
				return false;
			}
		}
		return true;
	}
	//Clear screen
	function resetForm()
	{
		var formObj=document.form;
		sheetObjects[0].RemoveAll();
		formObj.reset();
	}
