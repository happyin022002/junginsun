/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2003.js
*@FileTitle  : Customs Error Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0;
					[input]ADD=1;
					[Retrieve]SEARCH=2;
					[List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4;
					[remove]REMOVE=5;
					[list remove]REMOVELIST=6
					[multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects = new Array();
var sheetCnt = 0;
var dupRows = new Array();  // 중복체크용 전역변수


	// Event handler processing by button click event */
	document.onclick=processButtonClick;

	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_RowAdd":
				sheetObj.SetCellValue(sheetObj.DataInsert(-1), "cnt_cd", formObj.frm_cnt_cd.value, 0);
				//RowBackColor(nowRow) = "#FFCCFF";
				break;
			case "btn_RowDel":
				ComRowHideDelete(sheetObj, "check");
				break;
			case "btn_save":
				doActionIBSheet(sheetObj, formObj, MULTI);
				break;
			case "btn_exceldown":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL, "", "");
				break;
			case "btn_excelup":
				doActionIBSheet(sheetObj, formObj, IBLOADEXCEL);
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
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


	/**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// Necessary event at screen
		axon_event.addListener("keydown", "ComKeyEnter", "form");
	}


	/**
	* setting sheet initial values and header
	* @param sheetObj
	* @param sheetNo
	* @return
	*/
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      // sheet1 init
				with(sheetObj){
					var HeadTitle="|Del.|Seq|Country|Error Code|Error Description|Error Content";
					var headCount=ComCountHeadTitle(HeadTitle);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",     Hidden:1, Width:30,  Align:"Center", SaveName:"ibflag" },
								{Type:"DummyCheck", Hidden:0, Width:45,  Align:"Center", SaveName:"check" },
								{Type:"Seq",        Hidden:0, Width:30,  Align:"Center", SaveName:"seq" },
								{Type:"Text",       Hidden:0, Width:100, Align:"Center", SaveName:"cnt_cd",       KeyField:1, UpdateEdit:0, InsertEdit:1, AcceptKeys:"E",   EditLen:2,   InputCaseSensitive:1, FullInput:2 },
								{Type:"Text",       Hidden:0, Width:120, Align:"Center", SaveName:"cstms_err_cd", KeyField:1, UpdateEdit:0, InsertEdit:1, AcceptKeys:"E|N", EditLen:3,   InputCaseSensitive:1 },
								{Type:"Text",       Hidden:0, Width:400, Align:"Left",   SaveName:"err_cd_desc",  KeyField:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },
								{Type:"Text",       Hidden:0, Width:200, Align:"Left",   SaveName:"err_tp_ctnt",  KeyField:0, UpdateEdit:1, InsertEdit:1, EditLen:4000 },
								{Type:"Text",       Hidden:1, Width:50,  Align:"Left",   SaveName:"dup_chk_rst"},
								{Type:"Text",       Hidden:1, Width:50,  Align:"Left",   SaveName:"chk_cstms_err_cd"}];
					InitColumns(cols);

					SetEditable(1);
					SetWaitImageVisible(0);
					SetAutoRowHeight(0);
					SetDataRowHeight(22);
					SetSheetHeight(440);
				}
			break;
		}
	}


	/**
	* handling sheet process
	* @param sheetObj
	* @param formObj
	* @param sAction
	*/
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return;
				}
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_2003GS.do", sParam );
				ComOpenWait(false);
				break;

			case MULTI: // Save
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return;
				}
				formObj.f_cmd.value = MULTI;
				var sParam = sheetObj.GetSaveString({"AllSave":1}); // 전체 저장
				var sXml = sheetObj.GetSaveData("ESM_BKG_2003GS.do", "f_cmd=" + MULTI + "&" + sParam);
				sheetObj.LoadSaveData(sXml);
				break;

			case IBDOWNEXCEL:
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1} );
				break;

			case IBLOADEXCEL:
				sheetObj.RemoveAll();
				sheetObj.RenderSheet(0);
				sheetObj.LoadExcel({ Mode:"HeaderMatch"} );
				sheetObj.RenderSheet(1);
				break;
		}
	}


	/**
	* handling process for input validation
	* @param SheetObj
	* @param formObj
	* @param sAction
	* @return
	*/
	function validateForm(sheetObj, formObj, sAction){
		switch(sAction) {
			case IBSEARCH: // retrieve
				if (!ComChkValid(formObj)) return false;
				var frmCntCd = formObj.frm_cnt_cd.value;
					//ComShowMessage("[" + etaDt + "][" + blNo +"]["+ cntrNo + "]");
				if (frmCntCd == "") {
					ComShowCodeMessage("BKG01101", "Country Code");
					ComSetFocus(formObj.frm_cnt_cd);
					return false;
				}
				if (formObj.frm_cnt_cd.value.length != 2) {
					ComShowCodeMessage("BKG95018", "Country Code", "2");
					ComSetFocus(formObj.frm_cnt_cd);
					return false;
				}
				break;

			case MULTI : {
				with (sheetObj) {
					if (dupRows.toString() != "") {
						// 중복체크 row 색상을 원복
						SetRangeBackColor(HeaderRows(), SaveNameCol("cnt_cd"), SearchRows(), SaveNameCol("cstms_err_cd"), "#eff0f3");
						SetRangeBackColor(SearchRows()+1, SaveNameCol("cnt_cd"), RowCount(), SaveNameCol("cstms_err_cd"), "#ffffff");
						RenderSheet(1);
					}
					if (!ComChkValid(formObj)) return false;
					if (!IsDataModified()) {
						ComShowCodeMessage("COM130503");    // "There is no updated data to save."
						return false;
					}
					if (!ComShowCodeConfirm("COM130101", "data")) return false;    // "Do you want to save {?msg1}?"
					if (RowCount() > 0 && GetSaveString(0) == "") return false;    // Sheet1의 Mandatory Check 용도
					var fstErrRow = -1;
					// 전역변수에 setting - 중복체크(삭제행제외, 최초행포함, 전체 데이터 영역 검사) / 단어구분 "|", 줄구분","
					dupRows = ComReplaceStr(ColValueDupRows("cnt_cd|cstms_err_cd", 0, 1), "|", ",").split(",");
					if (dupRows.toString() != "") {
						RenderSheet(0);
						for (var i=0 in dupRows){
							if(i == 0) fstErrRow = parseInt(dupRows[i]);
							SetRangeBackColor(parseInt(dupRows[i]), SaveNameCol("cnt_cd"), parseInt(dupRows[i]), SaveNameCol("cstms_err_cd"), "#ffcccc");
						}
						RenderSheet(1);
						ComShowCodeMessage("BKG00460", "Error Code is duplicated.\n Please check Pink Box." );    // "Duplication occurred.({?msg1})"
						SelectCell(fstErrRow,"cstms_err_cd");
						return false;
					}
				}
				break;
			}
		} // end switch()
		return true;
	}

	/**
	* 
	* @param sheetObj, Code
	*/
	function sheet1_OnSaveEnd(sheetObj, Code){
		ComOpenWait(false);
		if(Code > 0) return;
		if(sheetObj.RowCount() > 0){
			with (sheetObj) {
				if (sheetObj.GetEtcData("TRANS_RESULT_KEY") == "S") {
					if(sheetObj.GetEtcData("err_chk_rst") == "Y"){ // 중복 발생 or 에러코드 사이즈 오버 발생
						var fstErrRow = -1;
						RenderSheet(0);
						// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
						var dupRows = ComFindAll(sheetObj,"dup_chk_rst","Y").toString().split("|");
						for (var i=0 in dupRows){
							if(i == 0) fstErrRow = parseInt(dupRows[i]);
							// 중복 에러코드 색칠
							SetRangeBackColor(parseInt(dupRows[i]), SaveNameCol("cnt_cd"), parseInt(dupRows[i]), SaveNameCol("cstms_err_cd"), "#ffcccc");
						}

						var errCdRows = ComFindAll(sheetObj,"chk_cstms_err_cd","Y").toString().split("|");
						for (var i=0 in errCdRows){
							if(i == 0 && fstErrRow < 0) fstErrRow = parseInt(errCdRows[i]);
							SetCellBackColor(parseInt(errCdRows[i]), "cstms_err_cd", "#ffffbb"); // 중복 에러코드 색칠
						}
						ComShowCodeMessage("BKG08334","Please check the colored box.\nYellow box is over-length and pink box is duplicated error code.");   // "Error occured. Please check the colored box.\n ({?msg1})";
						RenderSheet(1);
						
						//시트상 제일 위에있는 에러코드 셀로 포커스
						if(fstErrRow > -1){
							SelectCell(fstErrRow,"cstms_err_cd");
						}
					} else { // 정상 저장
						ComShowCodeMessage("BKG00166");
						doActionIBSheet(sheetObj, document.form, IBSEARCH);
					}
//				}else{ // 저장 오류 발생
//					ComShowCodeMessage("BKG00167");
//					return false;
				}
			}
		}	
	}

	/*
	* setting key input on the sheet
	*/
	function obj_KeyPress(){
		switch(event.srcElement.dataformat) {
			case "engup":
				ComKeyOnlyAlphabet("upper"); break;
				break;
		}
	}
