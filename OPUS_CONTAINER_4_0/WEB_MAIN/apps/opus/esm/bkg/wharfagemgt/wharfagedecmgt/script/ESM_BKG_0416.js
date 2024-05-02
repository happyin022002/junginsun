/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0416.js
*@FileTitle  : Wharfage Port Berth Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/* developer's work*/

	// global variable

	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;

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
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
				break;
				case "btn_add":
					sheetObject1.DataInsert(-1);
					sheetObject1.SetCellValue( sheetObject1.RowCount(), 4 ,document.form.port_cd.value);
				break;
				case "btn_del":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;
				case "btn_select":
					try {
						var obj=new Object();
						obj.cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_brth_cd");
						//window.returnValue=obj;
						ComPopUpReturnValue(obj);
						ComClosePopup();
					}catch(e) {}
				break;
				case "btn_close":
					ComClosePopup();
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
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}
	/**
	 * Dynamic loading the event of  HTML Control in the page <br>
	 * initializing IBSheet Object when this function is called from {@link #loadPage} <br>
	 *
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects
	 */
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- out of focus
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus in
		axon_event.addListenerFormat('keypress',         'obj_keypress',    formObject); //- keyboard
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 *  onkeypress - controlling keyboard.
	 */
	function obj_keypress(){
		switch(event.srcElement.name){
			case "port_cd":
				ComKeyOnlyAlphabet();
				break;
			case "int":
				//number
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				//number+"."
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "eng":
				//only alphabet, alphabet + number -> ComKeyOnlyAlphabet('num');
				ComKeyOnlyAlphabet();
				break;
			case "engdn":
				//only alphabet lower case, only alphabet lower case + number -> ComKeyOnlyAlphabet('lowernum');
				ComKeyOnlyAlphabet('lower');
				break;
			case "engup":
				//only alphabet upper case, alphabet upper case + number -> ComKeyOnlyAlphabet('uppernum');
				//ComKeyOnlyAlphabet('num');
				ComKeyOnlyAlphabet('upper');
				break;
			default:
				//only number (inteager, date, time)
				ComKeyOnlyNumber(event.srcElement);
		}
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
				   //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				   var HeadTitle1="|Sel|반출입부두|항만";
				   var prefix='sheet1_';

				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				   InitHeaders(headers, info);

				   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						  {Type:"Radio",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk" },
						  {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"brth_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
						  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"brth_kr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
						  {Type:"Text",      Hidden:1, Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];

				   InitColumns(cols);
				   SetEditable(1);
	               SetSheetHeight(440);
				}
				break;
		 }
	 }
	// handling of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0416GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );//*****
				}
			break;
			case IBSAVE:
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=MULTI;
					if (! sheetObj.IsDataModified()){
						//alert("select no data.. ");
						ComShowCodeMessage('BKG00233');
						return;
					}
					var sParam=ComGetSaveString(sheetObjects);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var SaveXml=sheetObj.GetSaveData("ESM_BKG_0416GS.do", sParam);//*****
					sheetObj.LoadSaveData(SaveXml);//*****
				}
			break;
			case IBDELETE:
				var checked=0;
				for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
					if( sheetObj.GetCellValue(i,1) == '1' ){
						checked=1;
						if (sheetObj.GetCellValue(i,0) != "I"){
							if( sheetObj.GetCellValue(i,1) == '1' ){
								sheetObj.SetRowHidden( i ,1);
								sheetObj.SetRowStatus( i ,"D");
							}
						}else{
							if( sheetObj.GetCellValue(i,1) == '1' ){
								sheetObj.SetRowStatus( i ,"D");
								i--;
							}
						}
					}
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			break;
			case IBDOWNEXCEL:
				if( sheetObj.RowCount()> 0 ){
					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });//*****
				}else{
					ComShowCodeMessage('BKG00389');
				}
			break;
		}
	}
	 /**
	  * handling process for input validation
	  */
	 function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
				if (formObj.port_cd.value == "" ) {
					ComShowCodeMessage('BKG00887', 'Port');
					formObj.port_cd.focus();
					return false;
				}
				return true;
			break;
			case IBSAVE:
				for(var i=1; i<sheetObj.RowCount()+ 1 ; i++){
					if( sheetObj.GetCellValue(i,0) == 'I' ){
						if( formObj.port_cd.value == '' || sheetObj.GetCellValue(i,2) == '' ){
							ComShowCodeMessage('BKG00104');
							formObj.port_cd.focus();
							return false;
						} else {
							if(sheetObj.GetCellValue(i,4) == '')
								sheetObj.CellValue(i,4) = formObj.port_cd.value
						}
					}
				}
				return true;
			break;
			case IBDELETE:
				return true;
			break;
		}
	 }
	/* the end of developer's work */
