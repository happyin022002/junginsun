/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0161.js
*@FileTitle  : Sort Option 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* Developer Work */
	// global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** using extra sheet valuable if there are more 2 sheets **** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_ok":
				var returnCode="";
				if (select1.GetSelectCode()!= "")
					returnCode=returnCode + select1.GetSelectCode()+ ",";
				if (select2.GetSelectCode()!= ""
						&& select1.GetSelectCode()== select2.GetSelectCode()) {
					ComShowCodeMessage('BKG06018');
					return;
				}
				if (select2.GetSelectCode()!= "")
					returnCode=returnCode + select2.GetSelectCode()+ ",";
				if (select3.GetSelectCode()!= ""
						&& (select1.GetSelectCode()== select3.GetSelectCode()||
							select2.GetSelectCode()== select3.GetSelectCode())	) {
					ComShowCodeMessage('BKG06018');
					return;
				}
				if (select3.GetSelectCode()!= "")
					returnCode=returnCode + select3.GetSelectCode()+ ",";
				if (select4.GetSelectCode()!= ""
						&& (select1.GetSelectCode()== select4.GetSelectCode()||
							select2.GetSelectCode()== select4.GetSelectCode()||
							select3.GetSelectCode()== select4.GetSelectCode())	) {
					ComShowCodeMessage('BKG06018');
					return;
				}
				if (select4.GetSelectCode()!= "")
					returnCode=returnCode + select4.GetSelectCode()+ ",";
				if (select5.GetSelectCode()!= ""
						&& (select1.GetSelectCode()== select5.GetSelectCode()||
							select2.GetSelectCode()== select5.GetSelectCode()||
							select3.GetSelectCode()== select5.GetSelectCode()||
							select4.GetSelectCode()== select5.GetSelectCode())	) {
					ComShowCodeMessage('BKG06018');
					return;
				}
				if (select5.GetSelectCode()!= "")
					returnCode=returnCode + select5.GetSelectCode()+ ",";
				if (returnCode.length > 0)
					returnCode=returnCode.substring(0, returnCode.length - 1);
					//var opener=window.dialogArguments;
					if (!opener) opener=parent; //이 코드 추가할것
					opener.setOrderBy(returnCode);
					ComClosePopup(); 
					//
				break;
			case "btn_close":
				ComClosePopup(); 
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
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Set IBCombo Object In comboObjects array
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 * @param comb_obj IBComb Object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
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
		// IBMultiComboInitialization
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	}
	/**
	 * set initial value in Combo
	 * @param {IBMultiCombo} comboObj  comboObj
	 */
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetLineColor("#ffffff");
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": //sheet1 init
		    with(sheetObj){
	      if (location.hostname != "")
	      var HeadTitle1="|";
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"}];
	      InitHeaders(headers, info);
	      var cols = [ {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"Priority",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"Select",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      //InitColumns(cols);
	      SetEditable(1);
	     // SetSheetHeight(97);
//	      SetRowHidden(0, 1);
	      }
			break;
		}
	}
	/**
	 * handling sheet process
	 * @param sheetObj Sheet
	 * @param formObj form object
	 * @param sAction 
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case COMMAND01: // insert
			formObj.f_cmd.value=INIT;
//			var sXml=sheetObj.GetSearchData("ESM_BKG_0161GS.do", FormQueryString(formObj));
			var sXml=sheetObj.GetSearchData("ESM_BKG_0161GS.do", "f_cmd="+formObj.f_cmd.value+"&code="+formObj.codeGubun.value);
//			var arrXml=sXml.split("|$$|");
			var codeGubun=formObj.codeGubun.value;
			if (codeGubun == "CD02298") { //Container Loading List(0159)
				ComXml2ComboItem(sXml, select1, "val", "name");
				ComXml2ComboItem(sXml, select2, "val", "name");
				ComXml2ComboItem(sXml, select3, "val", "name");
				ComXml2ComboItem(sXml, select4, "val", "name");
				ComXml2ComboItem(sXml, select5, "val", "name");
			} else if (codeGubun == "CD02196") { //BST(0103)
				ComXml2ComboItem(sXml, select1, "name", "desc");
				ComXml2ComboItem(sXml, select2, "name", "desc");
				ComXml2ComboItem(sXml, select3, "name", "desc");
				ComXml2ComboItem(sXml, select4, "name", "desc");
				ComXml2ComboItem(sXml, select5, "name", "desc");
			} else if (codeGubun == "CD02347") { //Group & Multi B/L Print(0278)
				ComXml2ComboItem(sXml, select1, "val", "desc");
				ComXml2ComboItem(sXml, select2, "val", "desc");
				ComXml2ComboItem(sXml, select3, "val", "desc");
				ComXml2ComboItem(sXml, select4, "val", "desc");
				ComXml2ComboItem(sXml, select5, "val", "desc");
			} else if (codeGubun == "CD02377") { //Print by VVD/Port(0274)
				ComXml2ComboItem(sXml, select1, "val", "name");
				ComXml2ComboItem(sXml, select2, "val", "name");
				ComXml2ComboItem(sXml, select3, "val", "name");
				ComXml2ComboItem(sXml, select4, "val", "name");
				ComXml2ComboItem(sXml, select5, "val", "name");
			} else{ //NEW REPORT(1701,1702,..)
				ComXml2ComboItem(sXml, select1, "name", "desc");
				ComXml2ComboItem(sXml, select2, "name", "desc");
				ComXml2ComboItem(sXml, select3, "name", "desc");
				ComXml2ComboItem(sXml, select4, "name", "desc");
				ComXml2ComboItem(sXml, select5, "name", "desc");
			}
			break;
		}
	}
	/* Developer Work End */
