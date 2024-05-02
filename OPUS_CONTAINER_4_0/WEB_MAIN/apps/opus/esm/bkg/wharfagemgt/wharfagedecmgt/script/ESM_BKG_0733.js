/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0733.js
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
				break;
				case "btn_del":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
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
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
			 ComEndConfigSheet(sheetObjects[i]);
		 }
		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 initControl();
	 }
	 /**
	  * loading HTML Control event <br>
	  * @param sheetObj
	  * @param sheetNo
	  */
	 function initControl() {
		var formObject=document.form;
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		ComSetFocus(formObject.loc_cd);
	 }
	 /**
	  * process when input retrieve keyword
	  */
	 function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	 }
	 /**
	 * control keyboard input at onkeypress event of HTML Control
	 */
//     function obj_keypress(){
// 		switch(event.srcElement.dataformat){
// 	    	case "int":
// 		        ComKeyOnlyNumber(event.srcElement);
// 		        break;
// 	        case "float":
// 	            ComKeyOnlyNumber(event.srcElement, ".");
// 	            break;
// 	        case "eng":
// 	            ComKeyOnlyAlphabet();
// 	            break;
// 	        case "engdn":
// 	            ComKeyOnlyAlphabet('lower');
// 	            break;
// 	        case "engup":
// 	            ComKeyOnlyAlphabet('upper');
// 	            break;
// 	        default:
// 	            ComKeyOnlyNumber(event.srcElement);
// 	    }
// 	}
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	 function initSheet(sheetObj,sheetNo) {
		 var cnt=0;
		 var sheetId=sheetObj.id;
		 switch(sheetId) {
			 case "sheet1":
				 with(sheetObj){
					var HeadTitle1="|Sel|" + document.form.companyCd.value + " Code|MF Code";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix='sheet1_';
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
								{Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
								{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"un_loc_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
								{Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"oloc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
								{Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"oun_loc_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];

					InitColumns(cols);
					SetCountPosition(0);
					SetColProperty(0, prefix +"loc_cd",  {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0, prefix +"un_loc_id", {AcceptKeys:"E|N" , InputCaseSensitive:1});
//					SetSheetHeight(342);
					resizeSheet();
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
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0733GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				}
			break;
			case IBSAVE:
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=MULTI;
					if (! sheetObj.IsDataModified()){
						ComShowCodeMessage('BKG00233');
						return;
					}
					var sParam=ComGetSaveString(sheetObjects);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var SaveXml=sheetObj.GetSaveData("ESM_BKG_0733GS.do", sParam);
					sheetObj.LoadSaveData(SaveXml);
				}
			break;
			case IBDELETE:
				var checked=0;
				for (var i=1 ; i <= sheetObj.RowCount(); i++){
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

				if( sheetObj.RowCount()> 0 )
					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
				else
					ComShowCodeMessage('BKG00389');
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
		switch (sAction) {
			case IBSEARCH: // retrieve
				//if( ComChkLen(formObj.loc_cd.value, 5) != "2"  ){
				if( formObj.loc_cd.value == "" && formObj.un_loc_id.value == "" ){
					if( formObj.loc_cd.value == ""  ){
						ComShowCodeMessage('BKG00887', formObj.companyCd.value +' Code');
						formObj.loc_cd.focus();
						return false;
					}
					if( formObj.un_loc_id.value == ""  ){
						ComShowCodeMessage('BKG00887', 'MF Code');
						formObj.un_loc_id.focus();
						return false;
					}
				}
				return true;
			break;
			case IBSAVE:
				//if ( ComShowCodeConfirm('BKG00386') == false ) return false;
				return true;
			break;
			case IBDELETE:
				if (formObj.port_cd.value == "" )
				{
					ComShowCodeMessage('BKG00266');
					formObj.port_cd.focus();
					return false;
				}
				return true;
			break;
		}
	  }
	  /**
	   * setting data type in case of addrow
	   */
	  function addRowEdit(sheetObj,formObj){
		 //var Row = sheetObj.SelectRow;
		 //sheetObj.CellValue2(Row,1) = "1";
		 //sheetObj.CellEditable(Row, 5) = false;
	  }

	  function resizeSheet(){
		  ComResizeSheet(sheetObjects[0]);
	  }

