/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0374.js
*@FileTitle  : Arrival Notice: Destination Office (USA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var prefix="";//
	var selectedRowForSave="";//for re-retrieve after saving
	var selectedCustSeq="";//selected Customer Seq (for data copy)
	var selectedRowForCopy="";//selected Customer Seq(for data copy) 
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	/*********************** EDTITABLE MULIT COMBO END ********************/
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
		//setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); },100);
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//form.cust_cnt_cd.focus();
	}
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerForm('blur', 'bkg_blur', formObject); 
		axon_event.addListenerForm('keydown', 'ComKeyEnter', formObject);
		axon_event.addListenerForm('keyup', 'obj_keyup', formObject);
	}
	/*********************** KEY EVENT START ********************/
	function bkg_keypress() {

	}
	/**
	 * onBlur event
	 **/
	function bkg_blur() {
		var formObj=document.form;
		switch (event.srcElement.getAttribute("name")) {
			default:
				break;
		}
	}
	/**
	 * onFocus evetn - checking Validation <br>
	 **/
	function bkg_focus() {
		var formObj=document.form;
		switch (event.srcElement.getAttribute("name")) {
			default:
				break;
		}
	}
	/*********************** KEY EVENT END ********************/
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/* */
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
				case "btn_RowDelete":
					var iCheckRow=sheetObject1.FindCheckedRow(prefix + "del_chk");
					var arrRow=iCheckRow.split("|");
					//alert(arrRow);
					if (iCheckRow == "") {
						ComShowCodeMessage('COM12189');
						return;
					}
					ComRowHideDelete(sheetObject1, prefix + "del_chk");
					break;
				case "btn_New":
					form.reset();
					sheetObject1.RemoveAll();
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
					break;
				case "btn_RowCopy":
					sheetObject1.DataCopy();
					break;
				case "btn_Close":
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
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value=SEARCH;
				var sXml = sheetObj.DoSearch("ESM_BKG_0374GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );

				break;
			case SEARCH01: //retrieve
				break;
			case IBSEARCHAPPEND: // 
			case IBINSERT: // 					
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				sheetObj.DataInsert(-1);
				break;
			case IBSAVE: //
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value=MULTI;
				var sParam=sheetObj.GetSaveString();
				if (sheetObj.IsDataModified()&& sParam == "")
					return;
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0374GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				break;
			case IBDOWNEXCEL: // 
				sheetObj.Down2Excel({ HiddenColumn:1});
				break;
		}
	}
	/**
	 * event after saving
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObject=document.form;
		if (ErrMsg == "") {
			ComBkgSaveCompleted();
			sheetObj.RemoveAll();
			doActionIBSheet(sheetObj, formObject, IBSEARCH);
		}
	}
	/**
	 * handling event after retrieving
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		if (sheetObj.RowCount()> 0){
ComSetObjValue(formObj.p_hndl_ofc_cd,sheetObj.GetCellValue(1,prefix + "hndl_ofc_cd"));
		}
	}
//method change[check again]CLT 	function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {	}
	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var temp="";
		if (colName == prefix + "diff_rmk") {
			//sheetObj.SetCellEditable(Row, colName,0);
			ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200);
			//sheetObj.SetCellEditable(Row, colName,1);
		}
	}
	/**
	 *  Remark MemoPad 
	 */
	function sheet1_OnClick(sheetObj, row, col, value) {
		//applying MemoPad function in case of clicking desc cell
		if (sheetObj.ColSaveName(col) == prefix + "diff_rmk") {
			//             	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)	 
			//      			ComShowMemoPad(sheetObj, row,8, null, null, null, 1000);
		}
	}
	/*
	 * validation
	 * 
	 */
	function sheet1_OnValidation(sheetObj, rowIdx, colIdx, value) {
if (sheetObj.GetCellValue(rowIdx, prefix + "ibflag") == 'D')
			return;
		if (colIdx == sheetObj.SaveNameCol(prefix + "phn_no")) {
			if (!ComIsNull(value) && !ComIsNumber(value, "-")) {
				ComShowCodeMessage("BKG95001", " enter correct 'Tel No'", "(Format:123-1234-1234)");
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "ntc_eml")) {
			if (!ComIsNull(value) && !ComIsEmailAddr(value)) {
				ComShowCodeMessage("BKG95001", " enter correct 'Email Address'", "");
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
	}
	function setCelColor(flag, obj, idx, celName, color) {
		if (flag == "N")
			obj.SetCellFontColor(idx, celName,color);
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (ComIsNull(formObj.p_eq_ctrl_ofc_cd)) {
			ComShowCodeMessage('BKG00626', 'EQ Office Code');
			formObj.p_eq_ctrl_ofc_cd.focus();
			return false;
		}
		if (formObj.p_eq_ctrl_ofc_cd.value.length != 5) {
			ComShowCodeMessage('BKG95018', 'EQ Office Code', '5');
			formObj.p_eq_ctrl_ofc_cd.focus();
			return false;
		}
		if (sAction == IBSEARCH)
			return true;
		if (ComIsNull(formObj.p_hndl_ofc_cd)) {
			ComShowCodeMessage('BKG00626', 'Handling Office Code');
			formObj.p_hndl_ofc_cd.focus();
			return false;
		}
		if (formObj.p_hndl_ofc_cd.value.length != 5) {
			ComShowCodeMessage('BKG95018', 'Handling Office Code', '5');
			formObj.p_hndl_ofc_cd.focus();
			return false;
		}
		switch (sAction) {
			case IBSEARCH:
				break;
			case IBSAVE:
				if (eval(sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U")) > 2) {
					ComShowCodeMessage('BKG01057');
					return false;
				}
				//if(eval(sheetObj.RowCount("D")+ sheetObj.RowCount("I") + sheetObj.RowCount("U")) ==0 )return; 
				//checking duplicate Part Code in case of creating and updating
				if (eval(sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U")) > 1) {
					var editCnt=0;
					var editArr=new Array();
					var statusCode="";
					for ( var index=0 + sheetObj.HeaderRows(); index <= sheetObj.RowCount(); index++) {
statusCode=sheetObj.GetCellValue(index, prefix + "ibflag");
						if (statusCode == "R" || statusCode == "U" || statusCode == "I") {
editArr[editCnt]=sheetObj.GetCellValue(index, prefix + "dest_ofc_cntc_cd");
							editCnt++;
						}
					}
					if (editArr[0] == editArr[1]) {
						ComShowCodeMessage("BKG03056", "Name");
						return false;
					}
				}
				//alert(eval(sheetObj.RowCount("D")+ sheetObj.RowCount("I") + sheetObj.RowCount("U")));
				if (formObj.p_eq_ctrl_ofc_cd.value != formObj.p_hndl_ofc_cd.value && sheetObj.RowCount("U") < 1 && sheetObj.RowCount("I") > 0) {
					//no need to check in case of eq = hq. no need to check in case of existing data to update
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0374GS.do", FormQueryString(formObj));
					//var sXml = sheetObj.DoSearch("ESM_BKG_0374GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
					if (ComGetEtcData(sXml, "HQ_OFC_SELECT_FLAG") == "Y") {
						ComShowCodeMessage('BKG08112', ComGetEtcData(sXml, "EQ_OFC_CD"), ComGetEtcData(sXml, "HQ_OFC_CD"));
						return;
					}
				}
				break;
			case IBINSERT:
				//EQ Office Code -  2 Part Code can be registered each Handling Office Code	
				if (eval(sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U")) >= 2) {
					ComShowCodeMessage('BKG01057');
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * data validation - yyyyMMd
	 */
	function dateCheck(dateobj) {
		if (dateobj.value == "")
			return true;//
		return ComIsDate(dateobj.value);
	}
	function isNullEtcData(xmlStr) {
		var rtn=false;
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot=xmlDoc.documentElement;
		if (xmlRoot == null)
			return true;
		var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if (etcDataNode == null)
			return true;
		var etcNodes=etcDataNode.childNodes;
		if (etcNodes == null)
			return true;
		if (etcNodes.length == 0)
			rtn=true;
		return rtn;
	}
	
	
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetObj.id) {
			case "sheet1":
			    with(sheetObj){
				
				      var HeadTitle1="|Sel.|||Name|Tel.|E-mail|Remark(s)";
				      var headCount=ComCountHeadTitle(HeadTitle1);

				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_ctrl_ofc_cd" },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hndl_ofc_cd" },
				             {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dest_ofc_cntc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0, Width:240,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ntc_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 } ];
				        //     {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000, MultiLineText:1 } ]; 
				       
				      InitColumns(cols);

				      SetEditable(1);
				      SetEllipsis(1);
				      SetCountPosition(0);
//				      SetSheetHeight(387);
				      SetColProperty(prefix+"dest_ofc_cntc_cd", {ComboText:"CustomerService|Traffic(DeliveryOrder)", ComboCode:"I|D"} );
				      resizeSheet();
			}


				break;
		}
	}
 