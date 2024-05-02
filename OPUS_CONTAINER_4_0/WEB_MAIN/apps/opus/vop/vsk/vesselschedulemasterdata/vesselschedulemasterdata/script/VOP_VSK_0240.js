/**
 * Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 * @FileName   : VOP_VSK_0240.js
 * @FileTitle  : Service Provider Group Registration (Pop-up
 * @author     : CLT
 * @version    : 1.0
 * @since      : 2014/07/21
 */

	// public variable
	var sheetObjects = new Array();
	var sheetIdx = 0;
	var isFirst = false;
	var arrXml;

	// Event handler processing by button click event */
	document.onclick = processButtonClick;

	// Event handler processing by button name.
	function processButtonClick() {
		var formObject = document.form;

		try {
			var srcName = ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			if (ComGetBtnDisable(srcName)) return false;

			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_add":
				appendSelectRowByVendor(sheetObjects[0]);
				break;
			case "btn_del":
				removeSelectRowByVendor(sheetObjects[0]);
				break;
			case "btn_new":
				clearAllData(sheetObjects[2]);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btn_rAdd":
				setAddLaneDir(sheetObjects[1], sheetObjects[1].GetSelectRow());
				break;
			case "btn_rDel":
				setDelLaneDir(sheetObjects[2], sheetObjects[2].GetSelectRow());
				break;
			}
		} catch(e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("VSK00011");
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetIdx++] = sheet_obj;
	}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj = document.form;

		for (i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}

	/**
	 * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
					var HeadTitle1=" |Sel.|Service Provider Code|Service Provider Name";
	
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sel",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"PopupEdit", Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					       
					InitColumns(cols);
	
					SetEditable(1);
					SetWaitImageVisible(0);
					SetShowButtonImage(1);
					SetColProperty(0 ,prefix+"vndr_seq" , {AcceptKeys:"N"});
					SetShowMsgMode(0);
			     	SetSheetHeight(130);
		      }


				break;
			case 2:      // sheet2 init
			    with(sheetObj){
				      var HeadTitle1="Lane\nCode|Lane Name||||||";
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      //var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"north_dir",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"south_dir",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bound1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bound2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cnl_agn_vndr_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hiddencheck" } ];
				       
			      	InitColumns(cols);

		      		SetEditable(0);
		      		SetWaitImageVisible(0);
		            SetColHidden("hiddencheck",1);
		            SetSheetHeight(290);
		      }


				break;     
			case 3:      // sheet3 init
			    with(sheetObj){
					var HeadTitle1="|Lane\nCode|Lane Name|North\nBound|South\nBound|DIR_SEQ1|DIR_SEQ2||||";
	
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"north_dir_cb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"south_dir_cb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"north_dir",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"south_dir",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bound1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bound2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cnl_agn_vndr_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hiddencheck" } ];
			       
					InitColumns(cols);
	
		      		SetEditable(1);
		      		SetWaitImageVisible(0);
		            SetColHidden("hiddencheck",1);
		           // InitComboNoMatchText(true);
		            SetSheetHeight(290);
		      }


				break;
	    }
	}

	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(true);

		switch(sAction) {
		case IBSEARCH : // Retrieve
			formObj.f_cmd.value = SEARCH;
			var arrPrefix = new Array("sheet1_", "sheet2_", "sheet3_");
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix);
			for (var i=0; i<sheetObjects.length; i++) {
				sheetObjects[i].SetWaitImageVisible(0);
			}

			ComOpenWait(true);
			var xmlData = sheetObj.GetSearchData("VOP_VSK_0240GS.do", sParam);
			arrXml = xmlData.split("|$$|");
			var sXml = arrXml[0];
			sheetObjects[0].RenderSheet(0);
			sheetObjects[0].LoadSearchData(sXml, {Sync:0});
			sheetObjects[0].RenderSheet(1);
			ComOpenWait(false);
			break;
		case IBSAVE : // Save
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;

				var arrPrefix = new Array("sheet1_", "sheet3_");
				sParam = sParam + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix);
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("VOP_VSK_0240GS.do", sParam);
				ComOpenWait(false);
				sheetObj.LoadSaveData(sXml);

				// in case SAVE OK, Retrieve again saved data.
				var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
				if (nodeText == "OK") {
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
				sheetObj.SetShowButtonImage(0);
			}
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:
//				for(var i=1; i<= sheetObjects[3].RowCount; i++){
//					if(sheetObjects[3].CellValue(i,"sheet4_serviceFlg") == "I" || sheetObjects[3].CellValue(i,"sheet4_serviceFlg") == "U"){
//						if(sheetObjects[3].CellValue(i,"sheet4_laneFlg") == "I" || sheetObjects[3].CellValue(i,"sheet4_laneFlg") == "U"){
//
	//						if(ComIsNull(sheetObjects[3].CellValue(i,"sheet4_bound_seq1"))){
	//							ComShowCodeMessage('VSK00027');
	//							sheetObjects[2].SelectCell(i,"sheet3_bound_seq1",true);
	//							return false;
	//						}
//
	//						if(ComIsNull(sheetObjects[3].CellValue(i,"sheet4_bound_seq2"))){
	//							ComShowCodeMessage('VSK00027');
	//							sheetObjects[2].SelectCell(i,"sheet3_bound_seq2",true);
	//							return false;
	//						}
	//					}
	//				}
	//			}
			break;
		}
		return true;
	}

	/**
	 * process after retrieve
	 * 
	 * @param sheetObj sheetObjects[0]
	 * @param formObj
	 * @param sXml
	 * @return
	 */
/*
	function showSheetData(sheetObj, formObj, sXmlArr){

		var vndrSeq = "";

		for (var i=0; i<arrXml.length; i++) {
			var curSheetObj = sheetObjects[i];
			var sXml = arrXml[i];
			var prefix = curSheetObj.id + "_";
			curSheetObj.RenderSheet(0);
			curSheetObj.LoadSearchData(sXml, {Sync:0});
			curSheetObj.RenderSheet(1);

			if (prefix == "sheet1_") {
				vndrSeq = curSheetObj.GetCellValue(curSheetObj.HeaderRows(), prefix + "vndr_seq");
			} else if (prefix == "sheet2_") {
				curSheetObj.ColumnSort(prefix + "vsl_slan_cd", "ASC");
			} else if (prefix == "sheet3_") {
				var curRow = sheetObj.GetSelectRow();
				if (VskIsNull(curRow)) curRow = sheetObj.HeaderRows();
				setLaneInfoByVendor(sheetObj, curRow);
				setDirectionByVendor(curSheetObj, sXml);
				initIbFlag(curSheetObj);
			}
		}
		showGetCountFormat(sheetObjects[2], sheetObjects[2].GetSelectRow());
		//Initializing All Check
		sheetObj.CheckAll(sheetObj.id+"_sel", 0);
	}
*/
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var headCnt=sheetObj.HeaderRows();
		if(NewRow >= headCnt && NewCol > 0){
			setLaneInfoByVendor(sheetObj, NewRow);
			showGetCountFormat(sheetObjects[2], sheetObjects[2].GetSelectRow());
		}
	}
//	function sheet1_OnDblClick(sheetObj, Row, Col) {
////		var formObj = document.form;
//		var rowCnt = sheetObj.RowCount;
//		var prefix = sheetObj.id + "_";
//
//		if(rowCnt > 0){
//			if(Col >= 2){
////				var vndrSeq = sheetObj.CellValue(Row, prefix+"vndr_seq");
////				if(VskIsNotNull(vndrSeq)){
////					sheetObjects[2].RemoveAll();
////					getHiddenGrid(sheetObj,formObj,vndrSeq,Row);
//					setLaneInfoByVendor(sheetObj, Row);
////				}
//			}
//		}
//	}

	/**
	 * Sheet1 Search End.
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.CheckAll(sheetObj.id+"_sel", 0);
		sheetObjects[1].RemoveAll()

		var sXml = arrXml[1];
		sheetObjects[1].RenderSheet(0);
		sheetObjects[1].LoadSearchData(sXml, {Sync:0});
		sheetObjects[1].RenderSheet(1);
	}

	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var rowCnt=sheetObj.RowCount();
		var formObj=document.form;
		if(rowCnt > 0){
			var url="/opuscntr/COM_ENS_0C1.do";
			var rtnFunName="getLaneCdHelp";
			ComOpenPopup(url, 700, 480, rtnFunName, '0,0,1', false, false, Row, Col, 0);
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var totCnt=sheetObj.LastRow();
		var sXml=null;
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"vndr_seq"){
				var vndrSeq=ComLpad(sheetObj.GetCellValue(Row, Col), 6, "0");
				for(var i=headCnt; i<totCnt; i++){
					if(vndrSeq == sheetObj.GetCellValue(i, prefix+"vndr_seq")){
						ComShowCodeMessage("VSK00002", vndrSeq);
						sheetObj.SetCellValue(Row, Col,"",0);
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
				}
				if(vndrSeq == "000000"){
					sheetObj.SetCellValue(Row, prefix+"vndr_seq","",0);
					sheetObj.SetCellValue(Row, prefix+"vndr_lgl_eng_nm","",0);
				}else{
					formObj.f_cmd.value=SEARCH02;
					formObj.vndr_seq.value=vndrSeq;
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0240GS.do", FormQueryString(formObj));
					var etcVndrSeq=ComGetEtcData(sXml, "vndr_seq");
					var etcVndrNm=ComGetEtcData(sXml, "vndr_nm");
					if(VskIsNull(etcVndrSeq) || VskIsNull(etcVndrNm)){
						ComShowCodeMessage("VSK00065", vndrSeq);
						sheetObj.SetCellValue(Row, Col,"",0);
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
					sheetObj.SetCellValue(Row, prefix+"vndr_seq",etcVndrSeq,0);
					sheetObj.SetCellValue(Row, prefix+"vndr_lgl_eng_nm",etcVndrNm,0);
				}
			}
		}
	}

	/**
	 * Sheet2 Search End.
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ColumnSort(sheetObj.id + "_vsl_slan_cd", "ASC");
		sheetObjects[2].RemoveAll()

		var sXml = arrXml[2];
		sheetObjects[2].RenderSheet(0);
		sheetObjects[2].LoadSearchData(sXml, {Sync:0});
		sheetObjects[2].RenderSheet(1);
	}

	function sheet2_OnDblClick(sheetObj, Row, Col) {
		setAddLaneDir(sheetObj, Row);
	}

	/**
	 * Sheet3 Search End.
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		var curRow = sheetObjects[0].GetSelectRow();
		if (VskIsNull(curRow)) curRow = sheetObjects[0].HeaderRows();
		setLaneInfoByVendor(sheetObjects[0], curRow);
		setDirectionByVendor(sheetObj);
		initIbFlag(sheetObj);
	}

	function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var headCnt=sheetObj.HeaderRows();
		if(NewRow >= headCnt && NewCol > 0){
			showGetCountFormat(sheetObj, NewRow);
		}
	}
	function sheet3_OnDblClick(sheetObj, Row, Col) {
		if(sheetObj.RowCount()> 0){
			if(Col <= 2){
				setDelLaneDir(sheetObj, Row);
			}
		}
	}
	function sheet3_OnComboChange(sheetObj, Row, Col, Code, Text) {
		if(Row >= sheetObj.HeaderRows()){
			var prefix=sheetObj.id + "_";
			var sDirCd=sheetObj.GetCellValue(Row, prefix+"bound1") + "|" + sheetObj.GetCellValue(Row, prefix+"bound2");
			var arrDirCd=sDirCd.split("|");
			if(sheetObj.ColSaveName(Col) == prefix+"north_dir_cb"){
				sheetObj.SetCellValue(Row, prefix+"north_dir",Code,0);
				for(var i=0; i<arrDirCd.length; i++){
					if(Code != arrDirCd[i]){
						sheetObj.SetCellValue(Row, prefix+"south_dir_cb",arrDirCd[i],0);
						sheetObj.SetCellValue(Row, prefix+"south_dir",arrDirCd[i],0);
						break;
					}
				}
			}else if(sheetObj.ColSaveName(Col) == prefix+"south_dir_cb"){
				sheetObj.SetCellValue(Row, prefix+"south_dir",Code,0);
				for(var i=0; i<arrDirCd.length; i++){
					if(Text != arrDirCd[i]){
						sheetObj.SetCellValue(Row, prefix+"north_dir_cb",arrDirCd[i],0);
						sheetObj.SetCellValue(Row, prefix+"north_dir",arrDirCd[i],0);
						break;
					}
				}
			}
		}
	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerForm("focus", "obj_focus", formObj);
	}
	function obj_focus() {
		if(event.srcElement.options){
			event.srcElement.focus();
		}else{
			event.srcElement.select();
		}
	}
	/*
	 * =====================================================================
	 * Handling Pop Up Data
	 * =====================================================================
	 */
	/**
	 * processing after popup of sheet1 close
	 * 
	 * @param rtnObjs
	 * @param Row
	 * @param Col
	 * @param sheetIdx
	 * @return
	 */
	function getLaneCdHelp(rtnObjs, Row, Col, sheetIdx){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var prefix=sheetObj.id + "_";
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObj.SetCellValue(Row, prefix+"vndr_seq",rtnDatas[2],0);
					sheetObj.SetCellValue(Row, prefix+"vndr_lgl_eng_nm",rtnDatas[4],0);
				}
			}
		}
	}

	/**
	 * Showing Lane of selected Vendor
	 */
	function setLaneInfoByVendor(sheetObj, Row){
		var vndrSeq = sheetObj.GetCellValue(Row, sheetObj.id+"_vndr_seq");
		if (VskIsNull(vndrSeq)) vndrSeq = "";
		var vndrSheetObj = sheetObjects[2];
		var prefix = vndrSheetObj.id + "_";
		var headCnt = vndrSheetObj.HeaderRows();
		var totCnt = vndrSheetObj.LastRow();
		vndrSheetObj.RenderSheet(0);
		for (var i=headCnt; i<=totCnt; i++) {
			if (VskIsNotNull(vndrSeq) && vndrSheetObj.GetCellValue(i, prefix + "cnl_agn_vndr_seq") == vndrSeq) {
				vndrSheetObj.SetRowHidden(i, 0);
			} else {
				vndrSheetObj.SetRowHidden(i,1);
			}
			if (vndrSheetObj.GetRowStatus(i) == "D")
			{
				vndrSheetObj.SetRowHidden(i, true);
			}
		}
		vndrSheetObj.RenderSheet(1);
	}

	/**
	 * Adding selected Lane to Vendor Lane List
	 * 
	 * @param sheetObj sheetObjects[1]
	 * @param Row
	 * @return
	 */
	function setAddLaneDir(sheetObj, Row) {
		// Vendor Sheet
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.GetCellValue(vndrSheetObj.GetSelectRow(), vndrSheetObj.id + "_vndr_seq");

		if (VskIsNull(vndrSeq)) {
			ComShowCodeMessage("VSK00106");
			return;
		}

		var originSheet = sheetObjects[1];
		var targetSheet = sheetObjects[2];
		var selectedRowStr = originSheet.GetSelectionRows("/");
		var selectedRows = selectedRowStr.split("/");

		for (var i=0; i<selectedRows.length; i++) {
			var rowIndex = selectedRows[i];
			var isDuplicate = false;
			for (var j=targetSheet.HeaderRows(); j<=targetSheet.LastRow(); j++) {
				if (originSheet.GetCellValue(rowIndex, originSheet.id + "_vsl_slan_cd") == targetSheet.GetCellValue(j, targetSheet.id + "_vsl_slan_cd")) {
					isDuplicate = true;
					originSheet.SetRowHidden(rowIndex, true);
					targetSheet.SetRowHidden(j, false);
					targetSheet.SetRowStatus(j, "R");
					break;
				}
			}

			if (!isDuplicate) {
				var laneCd = originSheet.GetCellValue(rowIndex, originSheet.id + "_vsl_slan_cd");
				var laneName = originSheet.GetCellValue(rowIndex, originSheet.id + "_vsl_slan_nm");
				var northDir = originSheet.GetCellValue(rowIndex, originSheet.id + "_north_dir");
				var southDir = originSheet.GetCellValue(rowIndex, originSheet.id + "_south_dir");
				var bound1 = originSheet.GetCellValue(rowIndex, originSheet.id + "_bound1");
				var bound2 = originSheet.GetCellValue(rowIndex, originSheet.id + "_bound2");
				originSheet.SetRowHidden(rowIndex, true)

				var insRow = targetSheet.DataInsert(-1);
				targetSheet.SetRowStatus(insRow, "I");
				targetSheet.SetCellValue(insRow, targetSheet.id + "_vsl_slan_cd", laneCd);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_vsl_slan_nm", laneName);
				if (VskIsNotNull(northDir)) {
					targetSheet.SetCellValue(insRow, targetSheet.id + "_north_dir_cb", northDir);
				} else {
					targetSheet.SetCellValue(insRow, targetSheet.id + "_north_dir_cb", bound1);
				}
				if (VskIsNotNull(southDir)) {
					targetSheet.SetCellValue(insRow, targetSheet.id + "_south_dir_cb", southDir);
				} else {
					targetSheet.SetCellValue(insRow, targetSheet.id + "_south_dir_cb", bound2);
				}
				targetSheet.SetCellValue(insRow, targetSheet.id + "_north_dir", northDir);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_south_dir", southDir);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_bound1", bound1);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_bound2", bound2);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_cnl_agn_vndr_seq", vndrSeq);
			}
		}


/*
		// Vendor Sheet
		var vndrSheetObj=sheetObjects[0];
		var vndrSeq=vndrSheetObj.GetCellValue(vndrSheetObj.GetSelectRow(), vndrSheetObj.id+"_vndr_seq");
		if(VskIsNull(vndrSeq)){
			ComShowCodeMessage("VSK00106");
			return;
		}
		// Vendor Lane List Sheet
		var targetSheetObj=sheetObjects[2];
		var targetPrefix=targetSheetObj.id + "_";
		var targetHeadCnt=targetSheetObj.LastRow();
		//var targetHeadCnt=targetSheetObj.HeaderRows();
		var beforeRowPos=targetSheetObj.LastRow();
		// not selected Lane List by Vendor
		var prefix=sheetObj.id + "_";
		alert( beforeRowPos );
		var selRowStr=sheetObj.GetSelectionRows("/");
		if(selRowStr =="0" || selRowStr =="") return;
		var selRowArr=selRowStr.split("/");
		var laneCdArr=new Array();
//		var ibFlagArr = new Array();
		for (var i=0; i<selRowArr.length; i++) {
//			var vRow = parseInt(selRowArr[i]);
			var laneCd=sheetObj.GetCellValue(selRowArr[i], prefix+"vsl_slan_cd");
			if(targetSheetObj.RowCount()> 0){
				for(var j=targetHeadCnt; j<=beforeRowPos; j++){
					// Deleting Lane which already added
					if(targetSheetObj.GetCellValue(j, targetPrefix+"vsl_slan_cd") == laneCd){
						targetSheetObj.SetRowHidden(j,0);
						appendComboItemBySheet(targetSheetObj, j);
						sheetObj.RowDelete(selRowArr[i], false);
//						targetSheetObj.RowDelete(j, false);
						break;
					}
					sheetObj.SetCellValue(selRowArr[i], "hiddencheck","Y",0);
					laneCdArr[i]=laneCd;
				}
			}else{
				sheetObj.SetCellValue(selRowArr[i], "hiddencheck","Y",0);
				laneCdArr[i]=laneCd;
			}
//			ibFlagArr[i] = sheetObj.CellValue(parseInt(selRowArr[i]), prefix+"ibflag");
		}
		//ComOpenWait(true);
		var saveColName="sheet2_vsl_slan_cd|sheet2_vsl_slan_nm|sheet2_north_dir|sheet2_south_dir|sheet2_bound1|sheet2_bound2|sheet2_cnl_agn_vndr_seq";
		var sXml=ComMakeSearchXml(sheetObj, false, "hiddencheck", saveColName, true);
//		sheetObj.ColumnSort(prefix+"lane_cd", "ASC");
		targetSheetObj.LoadSearchData(sXml.replace(/sheet2_/gi,{Sync:0} ));
		var targetTotCnt=targetSheetObj.LastRow();
		for(var i=0; i<laneCdArr.length; i++){
			for(var j=targetHeadCnt; j<=targetTotCnt; j++){
				if(laneCdArr[i] == targetSheetObj.GetCellValue(j, targetPrefix+"vsl_slan_cd")){
					targetSheetObj.SetCellValue(j, targetPrefix+"cnl_agn_vndr_seq",vndrSeq,0);
					appendComboItemBySheet(targetSheetObj, j);
//					var dirSeq1 = targetSheetObj.CellValue(j, targetPrefix+"dir_seq1");
//					var dirSeq2 = targetSheetObj.CellValue(j, targetPrefix+"dir_seq2");
//					var dirCds = dirSeq1 + "|" + dirSeq2;
//						 
//					targetSheetObj.CellComboItem(j, targetPrefix+"bound_seq1", dirCds, dirCds, 0);
//					targetSheetObj.CellComboItem(j, targetPrefix+"bound_seq2", dirCds, dirCds, 0);
//						
//					targetSheetObj.CellValue(j, targetPrefix+"bound_seq1") = dirSeq1;
//					targetSheetObj.CellValue(j, targetPrefix+"bound_seq2") = dirSeq2;
//
//					if(ibFlagArr[i] == "U"){
//						targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "I";
//						targetSheetObj.CellValue(j, targetPrefix+"vndr_seq") = vndrSeq;
//					}else if(ibFlagArr[i] == "D"){
//						targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "R";
//					}
////					targetSheetObj.CellEditable(j, targetPrefix+"lane_cd") = false;
////					targetSheetObj.CellEditable(j, targetPrefix+"lane_nm") = false;
//					
					break;
				}
			}
		}
		var newCurRow=0;
//		var newCurRow = getNewCurRow(targetSheetObj);
		showGetCountFormat(targetSheetObj, newCurRow);
*/
	}

	/**
	 * Deleting selected Lane from lower right-hand corner, and Adding Lane to lower left-hand corner 
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param Row
	 * @return
	 */
	function setDelLaneDir(sheetObj, Row){
		// Vendor Sheet
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.GetCellValue(vndrSheetObj.GetSelectRow(), vndrSheetObj.id + "_vndr_seq");

		var originSheet = sheetObjects[2];
		var targetSheet = sheetObjects[1];
		var selectedRowStr = originSheet.GetSelectionRows("/");
		var selectedRows = selectedRowStr.split("/");

		for (var i=0; i<selectedRows.length; i++) {
			var rowIndex = selectedRows[i];
			var isDuplicate = false;
			for (var j=targetSheet.HeaderRows(); j<=targetSheet.LastRow(); j++) {
				if (originSheet.GetCellValue(rowIndex, originSheet.id + "_vsl_slan_cd") == targetSheet.GetCellValue(j, targetSheet.id + "_vsl_slan_cd")) {
					isDuplicate = true;
					originSheet.SetRowHidden(rowIndex, true);
					targetSheet.SetRowHidden(j, false);
					break;
				}
			}

			if (!isDuplicate) {
				var laneCd = originSheet.GetCellValue(rowIndex, originSheet.id + "_vsl_slan_cd");
				var laneName = originSheet.GetCellValue(rowIndex, originSheet.id + "_vsl_slan_nm");
				var northDir = originSheet.GetCellValue(rowIndex, originSheet.id + "_north_dir");
				var southDir = originSheet.GetCellValue(rowIndex, originSheet.id + "_south_dir");
				var bound1 = originSheet.GetCellValue(rowIndex, originSheet.id + "_bound1");
				var bound2 = originSheet.GetCellValue(rowIndex, originSheet.id + "_bound2");
				if (originSheet.GetRowStatus(rowIndex) == "I") {
					originSheet.RowDelete(rowIndex);
				} else {
					originSheet.SetRowStatus(rowIndex, "D");
					originSheet.SetRowHidden(rowIndex, true)
				}

				var insRow = targetSheet.DataInsert(-1);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_vsl_slan_cd", laneCd);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_vsl_slan_nm", laneName);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_north_dir", northDir);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_south_dir", southDir);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_bound1", bound1);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_bound2", bound2);
				targetSheet.SetCellValue(insRow, targetSheet.id + "_cnl_agn_vndr_seq", "");
			}
		}


/*
		// Vendor Sheet
		var vndrSheetObj=sheetObjects[0];
		var vndrSeq=vndrSheetObj.GetCellValue(vndrSheetObj.GetSelectRow(), vndrSheetObj.id+"_vndr_seq");
		// not selected Lane List by Vendor
		var targetSheetObj=sheetObjects[1];
		var targetPrefix=targetSheetObj.id + "_";
		var targetHeadCnt=targetSheetObj.HeaderRows();
		var beforeRowPos=targetSheetObj.LastRow();
		// selected Lane List by Vendor
		var prefix=sheetObj.id + "_";
		var selRowStr=sheetObj.GetSelectionRows("/");
		if(selRowStr ==="0" || selRowStr ==="") return;
		var selRowArr=selRowStr.split("/");
		var laneCdArr=new Array();
		for (var i=0; i<selRowArr.length; i++) {
			if(sheetObj.GetCellValue(selRowArr[i], prefix+"cnl_agn_vndr_seq") == vndrSeq && sheetObj.GetRowHidden(selRowArr[i]) == false){
				laneCdArr[i]=sheetObj.GetCellValue(selRowArr[i], prefix+"vsl_slan_cd");
				sheetObj.SetCellValue(selRowArr[i], "hiddencheck","Y",0);
				removeLaneInfoByVendor(sheetObj, selRowArr[i]);
//				sheetObj.CellValue(selRowArr[i], prefix+"vndr_seq") = "";
//				sheetObj.CellValue(selRowArr[i], prefix+"vndr_flg") = "N";
//				sheetObj.CellValue(selRowArr[i], prefix+"bound_seq1") = "";
//				sheetObj.CellValue(selRowArr[i], prefix+"bound_seq2") = "";
////				sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq1", "", "", 0);
////				sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq2", "", "", 0);
//				sheetObj.RowHidden(selRowArr[i]) = true;
			}
		}
//		targetSheetObj.Redraw = false;
		var saveColName="sheet3_vsl_slan_cd|sheet3_vsl_slan_nm|sheet3_north_dir|sheet3_south_dir|sheet3_bound1|sheet3_bound2|sheet3_cnl_agn_vndr_seq";
		var sXml=ComMakeSearchXml(sheetObj, false, "hiddencheck", saveColName, false);
		targetSheetObj.LoadSearchData(sXml.replace(/sheet3_/gi,{Sync:0}) );
		var targetTotCnt=targetSheetObj.LastRow();
		// Initializing added Lane to not selected list
		for(var j=beforeRowPos; j<=targetTotCnt; j++){
			targetSheetObj.SetCellValue(j, targetPrefix+"cnl_agn_vndr_seq","",0);
//			targetSheetObj.CellValue2(j, targetPrefix+"vndr_flg") = "N";
			targetSheetObj.SetCellValue(j, targetPrefix+"north_dir","",0);
			targetSheetObj.SetCellValue(j, targetPrefix+"south_dir","",0);
		}
		//targetSheetObj.ColumnSort(targetPrefix+"vsl_slan_cd", "ASC");
//		targetSheetObj.Redraw = true;
		//Initializing All Check
//		sheetObj.CheckAll2("hiddencheck") = 0;
		for (var i=0; i<selRowArr.length; i++) {
			sheetObj.SetCellValue(selRowArr[i], "hiddencheck","N",0);
		}
		var newCurRow=0;
//		var newCurRow = getNewCurRow(sheetObj);
		showGetCountFormat(sheetObj, newCurRow);
*/
	}

	/**
	 * Setting Direction by Lane List by Vendor
	 */
	function setDirectionByVendor(sheetObj) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows();
		var totCnt = sheetObj.LastRow();

		var dirCds = "W|E|N|S";
		sheetObj.SetColProperty(0, prefix + "north_dir_cb", {ComboText:dirCds, ComboCode:dirCds});
		sheetObj.SetColProperty(0, prefix + "south_dir_cb", {ComboText:dirCds, ComboCode:dirCds});

		for (var i=headCnt; i<=totCnt; i++) {
//			if(laneCdArr[i] == targetSheetObj.CellValue(j, targetPrefix+"lane_cd")){
			appendComboItemBySheet(sheetObj, i);
//				if(ibFlagArr[i] == "U"){
//					targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "I";
//					targetSheetObj.CellValue(j, targetPrefix+"vndr_seq") = vndrSeq;
//				}else if(ibFlagArr[i] == "D"){
//					targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "R";
//				}
//				targetSheetObj.CellEditable(j, targetPrefix+"lane_cd") = false;
//				targetSheetObj.CellEditable(j, targetPrefix+"lane_nm") = false;
//				break;
//			}
		}
	}

	/**
	 * Setting Direction by Lane List by Vendor
	 */
	function appendComboItemBySheet(sheetObj, Row) {
		var prefix = sheetObj.id + "_";
		var bound1 = sheetObj.GetCellValue(Row, prefix + "bound1");
		var bound2 = sheetObj.GetCellValue(Row, prefix + "bound2");
/*
		var dirCds = bound1 + "|" + bound2;
		sheetObj.SetColProperty(Row, prefix + "north_dir_cb", {ComboText:dirCds, ComboCode:dirCds});
		sheetObj.SetColProperty(Row, prefix + "south_dir_cb", {ComboText:dirCds, ComboCode:dirCds});
*/
		var northDir = bound1;
		var southDir = bound2;
		if (VskIsNotNull(sheetObj.GetCellValue(Row, prefix + "north_dir"))) {
			northDir = sheetObj.GetCellValue(Row, prefix + "north_dir");
		} else {
			sheetObj.SetCellValue(Row, prefix + "north_dir", northDir, 0);
		}
		if (VskIsNotNull(sheetObj.GetCellValue(Row, prefix + "south_dir"))) {
			southDir = sheetObj.GetCellValue(Row, prefix + "south_dir");
		} else {
			sheetObj.SetCellValue(Row, prefix + "south_dir", southDir, 0);
		}
		sheetObj.SetCellValue(Row, prefix + "north_dir_cb", northDir, 0);
		sheetObj.SetCellValue(Row, prefix + "south_dir_cb", southDir, 0);
	}

	/**
	 * Adding Vendor
	 */
	function appendSelectRowByVendor(sheetObj) {
		var prefix = sheetObj.id + "_";
		sheetObj.DataInsert(-1);
		sheetObj.SelectCell(sheetObj.LastRow(), prefix + "vndr_seq");
		showGetCountFormat(sheetObjects[2]);
	}

	/**
	 * Deleting selected Vendor of Vendor List
	 * 
	 * @param sheetObj sheetObjects[0]
	 * @return
	 */
	function removeSelectRowByVendor(sheetObj){
		var prefix=sheetObj.id + "_";
//		var rowIdx = sheetObj.SelectRow + sheetObj.HeaderRows;
//		var vndrSeq = sheetObj.CellValue(sheetObj.SelectRow, prefix+"vndr_seq");
		var arrVndrSeq=new Array();
		var strSel=sheetObj.FindCheckedRow(prefix+"sel");
		if(strSel == "") {
			ComShowCodeMessage("COM12189");
			return false;
		}
		var arrSel=strSel.split("|"); //make array with selected row ( 결과 : "1|3|5| )"
		if(arrSel != null && arrSel != undefined && arrSel.length > 0){
			for(var i=0; i<arrSel.length; i++){
				arrVndrSeq[i]=sheetObj.GetCellValue(arrSel[i], prefix+"vndr_seq");
			}
		}
		if(arrVndrSeq != null && arrVndrSeq != undefined && arrVndrSeq.length > 0){
//			ComShowCodeMessage("VSK00005");
			if(ComRowHideDelete(sheetObj, prefix+"sel") > 0){
				var vndrSheetObj=sheetObjects[2];
				var vndrPrefix=vndrSheetObj.id + "_";
				var vndrHeadCnt=vndrSheetObj.HeaderRows();
				var vndrTotCnt=vndrSheetObj.LastRow();
				for(var i=vndrHeadCnt; i<=vndrTotCnt; i++){
					for(var j=arrVndrSeq.length-1; j>=0; j--){
						if(arrVndrSeq[j] == vndrSheetObj.GetCellValue(i, vndrPrefix+"cnl_agn_vndr_seq")){
							vndrSheetObj.SetCellValue(i, "hiddencheck","Y",0);
							removeLaneInfoByVendor(vndrSheetObj, i);
		//					vndrSheetObj.CellValue(i, vndrPrefix+"vndr_seq") = "";
		//					vndrSheetObj.CellValue(i, vndrPrefix+"vndr_flg") = "N";
		//					vndrSheetObj.CellValue(i, vndrPrefix+"bound_seq1") = "";
		//					vndrSheetObj.CellValue(i, vndrPrefix+"bound_seq2") = "";
		//					vndrSheetObj.RowHidden(i) = true;
						}
					}
				}
				// not selected Lane List by Vendor
				var targetSheetObj=sheetObjects[1];
				var targetPrefix=targetSheetObj.id + "_";
				var targetHeadCnt=targetSheetObj.HeaderRows();
				var beforeRowPos=targetSheetObj.LastRow();
				targetSheetObj.RenderSheet(0);
				var saveColName="sheet3_vsl_slan_cd|sheet3_vsl_slan_nm|sheet3_north_dir|sheet3_south_dir|sheet3_bound1|sheet3_bound2|sheet3_cnl_agn_vndr_seq";
				var sXml=ComMakeSearchXml(vndrSheetObj, false, "hiddencheck", saveColName, false);
				targetSheetObj.LoadSearchData(sXml.replace(/sheet3_/gi,{Sync:0} ));
				var targetTotCnt=targetSheetObj.LastRow();
				// Initializing added Lane to not selected list
				for(var j=beforeRowPos; j<=targetTotCnt; j++){
					targetSheetObj.SetCellValue(j, targetPrefix+"cnl_agn_vndr_seq","",0);
//					targetSheetObj.CellValue2(j, targetPrefix+"vndr_flg") = "N";
					targetSheetObj.SetCellValue(j, targetPrefix+"north_dir","",0);
					targetSheetObj.SetCellValue(j, targetPrefix+"south_dir","",0);
				}
				targetSheetObj.ColumnSort(targetPrefix+"vsl_slan_cd", "ASC");
				targetSheetObj.RenderSheet(1);
				sheetObj.SelectCell(sheetObj.LastRow(), prefix+"vndr_seq");
				showGetCountFormat(sheetObjects[2]);
			}
		}
	}
	/**
	 * Hidden Handling selected row from Lane List and initializing
	 * 
	 * @param sheetObj
	 * @param Row
	 * @return
	 */
	function removeLaneInfoByVendor(sheetObj, Row){
		var prefix=sheetObj.id + "_";
		sheetObj.SetCellValue(Row, prefix+"cnl_agn_vndr_seq","",0);
//		sheetObj.CellValue2(Row, prefix+"vndr_flg") = "N";
		sheetObj.SetCellValue(Row, prefix+"north_dir","",0);
		sheetObj.SetCellValue(Row, prefix+"south_dir","",0);
//		sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq1", "", "", 0);
//		sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq2", "", "", 0);
		sheetObj.SetRowHidden(Row,1);
	}

	/**
	 * Setting ibflag to 'R' with all retrieved data
	 * 
	 * @param sheetObj
	 * @return
	 */
	function initIbFlag(sheetObj) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows();
		var totCnt = sheetObj.LastRow();

		if (sheetObj.RowCount()> headCnt) {
			for (var i=headCnt; i<=totCnt; i++) {
				sheetObj.SetRowStatus(i, "R");
			}
		}
	}

	/**
	 * Setting CountFormat
	 * Calculating RowCount except Hidden
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param Row
	 * @return
	 */
	function showGetCountFormat(sheetObj, Row){
		var vndrSheetObj=sheetObjects[0];
		var vndrSeq=vndrSheetObj.GetCellValue(vndrSheetObj.GetSelectRow(), vndrSheetObj.id+"_vndr_seq");
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var totCnt=sheetObj.LastRow();
		var curTotCnt=0;		// count of Total Lane(except Hidden)
		var curRowIdx=0;		// count of RowCount()of selected Lane (shown RowCount()).
		var firstRow=0;		// count of RowCount()of first Lane (actual RowCount()).
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"cnl_agn_vndr_seq") == vndrSeq && sheetObj.GetRowHidden(i) == false){
				curTotCnt++;
				if(i == Row){
					curRowIdx=curTotCnt;
				}
				if(curTotCnt == 1){
					firstRow=i;
				}
			}
		}
		if(curRowIdx == 0 && firstRow > 0){
			curRowIdx=1;
			sheetObj.SelectCell(firstRow, prefix+"vsl_slan_cd");
		}
		var sCountFormat = ("["+curRowIdx+" / "+curTotCnt+"]");
		sheetObj.SetCountFormat(sCountFormat);
	}
	/**
	 * Initializing Direction grid
	 * 
	 * @param sheetObj
	 * @return
	 */
	function clearAllData(sheetObj){
//		sheetObj.SelectRow(3);
//		var selRowStr = sheetObj.GetSelectionRows("/");
//		alert(selRowStr);
//		setDelLaneDir(sheetObj, sheetObj.SelectRow);
		var vndrSheetObj=sheetObjects[0];
		var vndrSeq=vndrSheetObj.GetCellValue(vndrSheetObj.GetSelectRow(), vndrSheetObj.id+"_vndr_seq");
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var totCnt=sheetObj.LastRow();
		sheetObj.RenderSheet(0);
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"cnl_agn_vndr_seq") == vndrSeq && sheetObj.GetRowHidden(i) == false){
				setDelLaneDir(sheetObj, i);
			}
		}
		sheetObj.RenderSheet(1);
	}
