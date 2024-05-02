/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0354.js
*@FileTitle  : Canada ACI: Location of Goods Setup
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
	var prefix="sheet1_";
	var selectedRowForSave="";
	var selectedCustSeq="";
	var selectedRowForCopy=""; 
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
		form.p_pod_cd.focus();
	}
	function initControl() {
		var formObject=document.form;
//		axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); 
		axon_event.addListenerForm('blur', 'bkg_blur', formObject);      
		axon_event.addListenerFormat('focus', 'bkg_focus', formObject); 
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/*********************** KEY EVENT START ********************/
	function bkg_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				ComKeyOnlyAlphabet('upper');
				break;
			case "engupnum":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdnnum":
				ComKeyOnlyAlphabet('lowernum');
				break;
			case "num":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "address":
				ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
				break;
			case "num":
			case "zipcode":
				ComKeyOnlyNumber(event.srcElement, '-');
				break;
			default:
		}
	}
	/**
	 * onBlur Event inf HTML Control
	 **/
	function bkg_blur() {
		var formObj=document.form;
		switch (event.srcElement.getAttribute("name")) {
			case "from_dt":
				ComAddSeparator(event.srcElement);
				break;
			case "to_dt":
				ComAddSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	/**
	 * onFocus Event HTML Control
	 **/
	function bkg_focus() {
		var formObj=document.form;
		switch (event.srcElement.getAttribute("name")) {
			case "from_dt":
				ComClearSeparator(event.srcElement);
				break;
			case "to_dt":
				ComClearSeparator(event.srcElement);
				break;
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
		var comboObject1=comboObjects[0];
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
					if(sheetObject1.RowCount() == 0) {
						alert("Can not copy the Row Data. There is exist only Header.");
						return false;
					}else{
						var oldIdx=sheetObject1.GetSelectRow();
						var newIdx=sheetObject1.DataCopy();
						if(newIdx > 0) {                 
//							sheetObject1.SetCellValue(oldIdx, prefix +"del_chk",0,0);
							sheetObject1.SetCellValue(newIdx, prefix +"gds_loc_seq","",0);
						}                                                               
					}
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
	var ValidateFail = false;
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo, param) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value=SEARCH;
				var sXml = sheetObj.DoSearch("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				break;
			case SEARCH01: //retrieve
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param + "&" + ComGetPrefixParam(prefix));
				return ComGetEtcData(sXml, "EXIST_MSG");
				break;
				
			case SEARCH02: //Yard Description 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchData("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param + "&" + ComGetPrefixParam(prefix));
				return ComGetEtcData(sXml, "YD_DESC");
				break;
				
			case SEARCH03: //Location Description 조회
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchData("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param);
				return ComGetEtcData(sXml, "LOC_DESC");
				break;
				
			case IBSEARCHAPPEND: // Paging
			case IBINSERT: // Insert					
				sheetObj.DataInsert(-1);
				break;
			case IBSAVE: //Save
				if (!sheetObj.IsDataModified()) {
					return;
				}
				var sParam=sheetObj.GetSaveString();
				if (sheetObj.IsDataModified()&& sParam == "")
					return;
				if (!validateForm(sheetObj, formObj, sAction)){
					return;
				}
				
	            if(!ComShowCodeConfirm("BKG00350")) {
	            	return false;
	            }
				
				formObj.f_cmd.value=MULTI;
				sParam += "&" + FormQueryString(formObj);
				
				var sXml=sheetObj.GetSaveData("ESM_BKG_0354GS.do", sParam );
				sheetObj.LoadSaveData(sXml, {Sync:1});
				
				break;
			case IBDOWNEXCEL: // Excel download
				if (sheetObj.RowCount()== 0 ) {
			   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
			   	    return;
			   	} else {
			   		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			   	}
				
				break;
		}
	}
//	/**
//	 * OnSaveEnd Event 
//	 */
//	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//		var formObject=document.form;
//		if (ErrMsg == "") {
//			ComBkgSaveCompleted();
//			sheetObj.RemoveAll();
//			doActionIBSheet(sheetObj, formObject, IBSEARCH);
//		}
//	}
	/*
	 * Paging Event
	 * */
	function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	}
	
	function sheet1_OnChange(sheetObj, rowIdx, colIdx, value) {
		var formObject=document.form;
		
		if (sheetObj.GetCellValue(rowIdx, prefix + "ibflag") == 'D') return;
		
		if (colIdx == sheetObj.SaveNameCol(prefix + "pod_cd")) {
			sheetObj.SetCellValue(rowIdx, prefix + "pod_cd",sheetObj.GetCellValue(rowIdx, prefix + "pod_cd").toUpperCase(), 0);
			var pod_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.GetCellValue(rowIdx, prefix + "pod_cd"));
			sheetObj.SetCellValue(rowIdx, prefix + "pod_desc", pod_desc_val, 0);
			sheetObj.SetCellValue(rowIdx, prefix + "pod_cd_cpy", sheetObj.GetCellValue(rowIdx, prefix + "pod_cd"), 0);
			if( pod_desc_val == "" ){
				ComShowCodeMessage("COM132201","POD Code");
				sheetObj.SetCellValue(rowIdx, prefix + "pod_cd", "", 0);
				sheetObj.SetCellValue(rowIdx, prefix + "pod_cd_cpy", "", 0);
				sheetObj.SelectCell(rowIdx, prefix + "pod_cd");
				return;
			}
			
		} else if( colIdx == sheetObj.SaveNameCol(prefix + "pod_yd_no") ){
			sheetObj.SetCellValue(rowIdx, prefix + "pod_yd_no", sheetObj.GetCellValue(rowIdx, prefix + "pod_yd_no").toUpperCase(), 0)
			var yd_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH02, rowIdx, colIdx, 1, "pod_yd_no="+sheetObj.GetCellValue(rowIdx, prefix + "pod_cd") + sheetObj.GetCellValue(rowIdx, prefix + "pod_yd_no"));
			sheetObj.SetCellValue(rowIdx, prefix + "yd_desc", yd_desc_val, 0);
			if( sheetObj.GetCellValue(rowIdx, prefix + "pod_yd_no") != "" && yd_desc_val == "" ){
				ComShowCodeMessage("BKG01078",sheetObj.GetCellValue(rowIdx, prefix + "pod_yd_no"));
				sheetObj.SetCellValue(rowIdx, prefix + "pod_yd_no", "", 0);
				sheetObj.SelectCell(rowIdx, prefix + "pod_yd_no", "");
				return;
			}
			
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "del_cd")) {
			sheetObj.SetCellValue(rowIdx, prefix + "del_cd",sheetObj.GetCellValue(rowIdx, prefix + "del_cd").toUpperCase(), 0);
			
			var del_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.GetCellValue(rowIdx, prefix + "del_cd"));
			sheetObj.SetCellValue(rowIdx, prefix + "del_desc",del_desc_val, 0);
			if( del_desc_val == "" ){
				ComShowCodeMessage("COM132201","DEL Code");
				sheetObj.SetCellValue(rowIdx, prefix + "del_cd", "", 0);
				sheetObj.SelectCell(rowIdx, prefix + "del_cd");
				return;
			}			
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "hub_loc_cd")) {
			sheetObj.SetCellValue(rowIdx, prefix + "hub_loc_cd",sheetObj.GetCellValue(rowIdx, prefix + "hub_loc_cd").toUpperCase(), 0);
			var hub_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.GetCellValue(rowIdx, prefix + "hub_loc_cd"));
			sheetObj.SetCellValue(rowIdx, prefix + "hub_desc", hub_desc_val, 0);
			if( hub_desc_val == "" ){
				ComShowCodeMessage("COM132201","HUB Code");
				sheetObj.SetCellValue(rowIdx, prefix + "hub_loc_cd", "", 0);
				sheetObj.SelectCell(rowIdx, prefix + "hub_loc_cd");
				return;
			}
			
			
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "trsp_mod_id")) {
			sheetObj.SetCellValue(rowIdx, prefix + "trsp_mod_id",sheetObj.GetCellValue(rowIdx, prefix + "trsp_mod_id").toUpperCase(), 0);
		}
		
	}
	function setCelColor(flag, obj, idx, celName, color) {
		if (flag == "N") {
			obj.SetCellFontColor(idx, celName,color);
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (ComIsNull(formObj.p_pod_cd)) {
					ComShowCodeMessage('BKG00626', 'POD Code');
					return false;
				}
				if (formObj.p_pod_cd.value.length != 5) {
					ComShowCodeMessage('BKG95018', 'POD Code', '5');
					return false;
				}
				break;
			case IBSAVE:
				if( !sheetObj.IsDataModified ){
					return false;
				}
				
				var chgRow = "";
				for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
					if( sheetObj.GetRowStatus(idx) == "I" || sheetObj.GetRowStatus(idx) == "U" ){
						chgRow = chgRow + idx + ",";
					}
				}
				
				//Duplication Check
				chgRow = chgRow.substr(0,chgRow.length - 1);
				if( chgRow != "" ){
					var rowArr = chgRow.split(",");
					
					for( var idx = 0; idx < rowArr.length; idx++ ){
						for( var jdx = 0 + parseInt(sheetObj.HeaderRows); jdx <= sheetObj.LastRow; jdx++ ){
							if( parseInt(rowArr[idx]) != jdx ){
								if( sheetObj.GetCellValue(rowArr[idx], prefix + "pod_cd") == sheetObj.GetCellValue(jdx, prefix + "pod_cd")
								&& sheetObj.GetCellValue(rowArr[idx], prefix + "pod_yd_no") == sheetObj.GetCellValue(jdx, prefix + "pod_yd_no")
								&& sheetObj.GetCellValue(rowArr[idx], prefix + "del_cd") == sheetObj.GetCellValue(jdx, prefix + "del_cd")
								&& sheetObj.GetRowStatus(rowArr[idx]) != "D" && sheetObj.GetRowStatus(jdx) != "D" ){
									ComShowCodeMessage("BKG06134");
									return false;
								}
							}
						}
					}
				}				break;
		}
		return true;
	}
	/**
	 * Check the duplication
	 */
	function checkDupGrid(sheetObj, idx, podCd, delCd) {
		with (sheetObj) {
			for ( var i=idx + 1; i < RowCount()+ HeaderRows; i++) {
				if (GetCellValue(i, prefix + "ibflag") == 'D')
					continue;
				if (podCd + delCd == GetCellValue(i, prefix + "pod_cd") + GetCellValue(i, prefix + "del_cd")) {
					ComShowCodeMessage("COM12115", "POD:" + podCd + " DEL:" + delCd);
					sheetObj.SelectCell(i, prefix + "pod_cd");
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Check the data
	 */
	function dateCheck(dateobj) {
		if (dateobj.value == "")
			return true;
		return ComIsDate(dateobj.value);
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
				      //if (location.hostname != "")
				      //no support[check again]CLT 						InitHostInfo(location.hostname, location.port, page_path);
					  var HeadTitle1 = "|Sel.|Seq|POD YARD|POD YARD|YARD Description|POD|POD Description|DEL|DEL Description|HUB|HUB Description|Transport Mode|Location of Goods|Customs Code";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gds_loc_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_yd_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys : "E|N", InputCaseSensitive :1,	EditLen:2 },
				             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_desc",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd_cpy",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"del_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hub_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"hub_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trsp_mod_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"gds_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
			             	 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_cd",    KeyField:0,   CalcLogic:"",   Format:"", 			PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys : "N", EditLen:4 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
//				      SetSheetHeight(422);
				      ComResizeSheet(sheetObj);
		        }
				break;
		}
	}

	
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @version 2009.05.17
     */ 	
	 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	 		var formObject=document.form;
	 		if (ErrMsg == "") {
				ComBkgSaveCompleted();
			}
		}
	