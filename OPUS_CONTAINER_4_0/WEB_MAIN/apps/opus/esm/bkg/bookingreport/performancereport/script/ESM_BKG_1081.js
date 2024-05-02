	/*=========================================================
	 *Copyright(c) 2010 CyberLogitec
	 *@FileName : ESM_BKG_1081.js
	 *@FileTitle : Autorating Accuracy Monitoring Report
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier : 
	 *@LastVersion : 1.0
	=========================================================*/
	/****************************************************************************************
	 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ESM_BKG_1081 : business script for ESM_BKG_1081 
	 */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var combo1=null;
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/* */
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		var bkg_no="";
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_New":
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					break;
				case "btn_DownExcel_Summary":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
//						sheetObject1.SetHeaderBackColor("#CCCCCC");
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObject1), SheetDesign:1,Merge:1 });
//						sheetObject1.SetHeaderBackColor("#333333");
					}
				     
					break;
				case "btn_DownExcel_Detail":
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
//						sheetObject2.SetHeaderBackColor("#CCCCCC");						
						sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObject2), SheetDesign:1,Merge:1 });
//						sheetObject2.SetHeaderBackColor("#333333");						
					}
					break;
				case "auto_rat_cd":
					if (formObject.auto_rat_cd.checked)
					{
						document.all.span_autorated_bl.innerHTML="Autorated B/L List";
					}
					else
					{
						document.all.span_autorated_bl.innerHTML="Non Autorated B/L List";
					}
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	/**
	 */
	function initControl() {
		DATE_SEPARATOR="-";
		var formObject=document.form;
		axon_event.addListenerForm('blur', 'obj_deactivate', formObject); //
		axon_event.addListenerFormat('focus', 'obj_activate', formObject); //
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		combo1=comboObjects[0];
		comboCnt=comboObjects.length;
		// initializing IBMultiCombo
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
		ComSetObjValue(formObject.fr_dt, ComGetNowInfo());
		ComSetObjValue(formObject.to_dt, ComGetNowInfo());
	}
	
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
        ComResizeSheet(sheetObjects[1]);
    }
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
			case 1:
			    with(sheetObj){
			      var HeadTitle="No.|Scope|B.OFC|P.OFC|TTL B/L|Rated B/L|Auto|Non|Ratio(%)|||";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"no" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"region",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rate_cnt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"auto_cnt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"non_auto_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
			             {Type:"AutoAvg",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"ratio",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"t_ttl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"t_auto_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"t_ratio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
	              SetFocusEditMode(-1);
			      MultiSelection=false;
//		          SetSheetHeight(480);
			      resizeSheet();
			      break;
		      }


			case 2:
			    with(sheetObj){
			      var HeadTitle="No|BKG No|Scope|S/C No|Change History|Rater|Office";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"no" },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"change_history",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"rater",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rater_ofc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
//			      SetSheetHeight(480);
			      resizeSheet();
		            break;
		      }


		}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBCLEAR: // retrieving code on loading
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1081GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				ComXml2ComboItem(arrXml[0], region, "val", "val");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], region, "val", "val");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], ctrt_cd, "val", "name");
					region.SetSelectIndex(0);
					ctrt_cd.SetSelectIndex(1);
				break;
			case IBSEARCH: //retrieve	
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH01;
					sheetObjects[1].SetWaitImageVisible(0);
					sheetObjects[0].SetWaitImageVisible(0);
					ComOpenWait(true); //
					var sXml=sheetObj.GetSearchData("ESM_BKG_1081GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 1){
						sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					}
					if (arrXml.length > 0){
						sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					}
					ComOpenWait(false); //
				}
				break;
			case IBROWSEARCH: //retrieve
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH02;
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true); //
					var sXml=sheetObj.GetSearchData("ESM_BKG_1081GS.do", FormQueryString(formObj));
					//sheetObj.RemoveAll();
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0)
						sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
				}
				break;
			case "btn_New":
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				ComResetAll();
				break;
			case IBDOWNEXCEL: // 
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			switch (sAction) {
				case IBSEARCH: // 
					if (formObj.fr_dt.value.length != 10) {
						ComShowCodeMessage("BKG00870");
						formObj.fr_dt.focus();
						formObj.fr_dt.value="";
						return false;
					}
					if (formObj.to_dt.value.length != 10) {
						ComShowCodeMessage("BKG00871");
						formObj.to_dt.focus();
						formObj.to_dt.value="";
						return false;
					}					
					if (!ComChkValid(formObj))
						return false;
					if (!ComIsNull(formObj.fr_dt) && !ComIsNull(formObj.to_dt) && ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31) {
						ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
						formObj.fr_dt.focus();
						return false;
					}
					if ( formObj.svc_scp_cd.value == "" && formObj.sc_no.value=="" && formObj.bkg_ofc_cd.value=="" && (formObj.region.index != 'undefined' || formObj.region.index < 1) ) {
 			  			ComShowCodeMessage('BKG00626', '\n\n[Region,SVC Scope,S/C No,Booking Office] , One must have value');
 			  			return false;
 			  		}
					break;
			}
		}
		return true;
	}
	/**
	 * initializing Combo
	 * @param {IBMultiCombo} comboObj  comboObj
	 */
	function initCombo(comboObj) {
		comboObj.SetDropHeight(150);
	}
	/**
	 * from,to calendar pop up
	 */
	function callDatePop(val) {
		var cal=new ComCalendarFromTo();
		if (val == 'BKG_DATE') {
			cal.select(form.fr_dt, form.to_dt, 'yyyy-MM-dd');
		}
	}
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != '' ) {
			ComSetObjValue(formObj.sel_ofc_cd, sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
			ComSetObjValue(formObj.sel_scp_cd, sheetObj.GetCellValue(Row, "svc_scp_cd"));
			doActionIBSheet(sheetObjects[1], formObj, IBROWSEARCH);
		}
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.SetSumText(0,3, "TOTAL");
    	//var dataRowCnt=0;
    	//with(sheetObj){
    	//	SetSumText(0, "no","");
    		///SetSumText(0, "region","Total");
    		///SetSumText(0, "ratio",EtcData("t_ratio"));//ComRound(GetSumText(0, "auto_cnt") / GetSumText(0, "ttl") * 100,2);
    	//}
	}	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		comBkgIndicateLink(sheetObj,"bkg_no");
 		ComOpenWait(false); // 
  	}
	function sheet2_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
//			comBkgCallBkgDetail(sheetObj.CellValue(rowIdx, colName));
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}    
