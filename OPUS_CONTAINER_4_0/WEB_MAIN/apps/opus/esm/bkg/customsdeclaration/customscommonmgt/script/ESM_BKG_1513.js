/* =========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1513.js
*@FileTitle : Manifest e-Maiil Notification Set-up
*@author : CLT
*@version : 1.0
*@since : 2014/11/06
 ========================================================= */
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT = 0; [입력]ADD = 1; [조회]SEARCH = 2; [리스트조회]SEARCHLIST = 3;
					[수정]MODIFY = 4; [삭제]REMOVE = 5; [리스트삭제]REMOVELIST = 6 [다중처리]MULTI = 7
					기타 여분의 문자상수  COMMAND01 = 11; ~ COMMAND20 = 30;
 ***************************************************************************************/


/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn2_row_add":
					var newRowIdx = shtObj.DataInsert(-1);
					shtObj.SetCellValue(newRowIdx, "cnt_cd", frmObj.cnt_cd.value);
					shtObj.SetCellValue(newRowIdx, "cnt_nm", frmObj.cnt_cd.options[frmObj.cnt_cd.selectedIndex].text);
					shtObj.SelectCell(newRowIdx, "edi_msg");
					break;

				case "btn2_row_del":
					ComRowHideDelete(shtObj, "chk");
					break;

				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
					break;

				case "btn_new":
					frmObj.cnt_cd.className = "input1";
					frmObj.cnt_cd.disabled = false;
					ComResetAll();
					ComBtnDisable("btn2_row_add");
					ComBtnDisable("btn2_row_del");
					break;

				case "btn_save":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
					break;
			} // end switch
		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}


	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		ComBtnDisable("btn2_row_add");
		ComBtnDisable("btn2_row_del");
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		switch (shtObj.id) {
			case "sheet1":
				with(shtObj) {
					var cnt = 0;

					SetEditEnterBehavior("tab");

					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

					var HeadTitle = "|SEQ|DEL|Customs Country|Type|Message Type|Load Port|Load Port|Dicharge Port|Dicharge Port|E-mail (To:)|E-mail (Cc:)|Last Updated by|Last Updated by" +
					                // Hidden Column
					                "|cnt_cd|org_edi_msg|org_edi_msg_tp_id|org_pol_cd|org_pod_cd";
					var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",     Hidden:1,   Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Seq",        Hidden:0,   Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					             {Type:"DummyCheck", Hidden:0,   Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					             {Type:"Text",       Hidden:0,   Width:125,  Align:"Center",  ColMerge:0,   SaveName:"cnt_nm",        KeyField:1,   Edit:0},
					             {Type:"Combo",      Hidden:0,   Width:125,  Align:"Left",    ColMerge:0,   SaveName:"edi_msg",       KeyField:1 },
					             {Type:"Combo",      Hidden:0,   Width:155,  Align:"Left",    ColMerge:0,   SaveName:"edi_msg_tp_id", KeyField:1 },
					             {Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",        KeyField:0,   Edit:1,   EditLen:5,    AcceptKeys:"E|N",   InputCaseSensitive:1 },
					             {Type:"Text",       Hidden:0,   Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pol_nm",        KeyField:0,   Edit:0 },
					             {Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   Edit:1,   EditLen:5,    AcceptKeys:"E|N",   InputCaseSensitive:1 },
					             {Type:"Text",       Hidden:0,   Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pod_nm",        KeyField:0,   Edit:0 },
					             {Type:"Text",       Hidden:0,   Width:200,  Align:"Left",    ColMerge:0,   SaveName:"to_eml_ctnt",   KeyField:0,   Edit:1,   EditLen:4000},
					             {Type:"Text",       Hidden:0,   Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cc_eml_ctnt",   KeyField:0,   Edit:1,   EditLen:4000},
					             {Type:"Text",       Hidden:0,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",        KeyField:0,   Edit:0 },
					             {Type:"Text",       Hidden:0,   Width:120,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",        KeyField:0,   Edit:0 },

					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd"            },
					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_edi_msg"       },
					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_edi_msg_tp_id" },
					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_pol_cd"        },
					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_pod_cd"        } ];
					InitColumns(cols);

					SetEditable(1);
					SetCountPosition(0);
					SetWaitImageVisible(0);
					SetShowButtonImage(3);
					SetSheetHeight(389);
				}
				break;
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case IBSEARCH:       // 조회
				ComOpenWait(true);
				setComboData(shtObj);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1513GS.do", FormQueryString(frmObj) );
				ComOpenWait(false);
				// HTML Object의 disabled는 ComOpenWait(false)이후에만 정상동작하므로, sheet1_OnSeachEnd가 아닌 여기에 위치
				if (shtObj.SearchRows()< 1) {
					frmObj.cnt_cd.className = "input1";
					frmObj.cnt_cd.disabled = false;
				} else {
					frmObj.cnt_cd.className = "input2";
					frmObj.cnt_cd.disabled = true;
				}
				break;

			case IBSAVE:    // 저장
				ComOpenWait(true);
				var dupRow = shtObj.ColValueDup("cnt_nm|edi_msg|edi_msg_tp_id|pol_cd|pod_cd", 0);
				if (dupRow > -1){
					ComOpenWait(false);
					ComShowCodeMessage("COM131302", "Row " + dupRow);    // '{?msg1} is duplicated.';
					shtObj.SelectCell(dupRow, "pol_cd");
					return;
				}
				frmObj.f_cmd.value = MULTI;
				shtObj.DoSave("ESM_BKG_1513GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;
		}
	}


	/**
	 * handling event after searching
	 */
	function sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMs) {
		if (Code < 0 || shtObj.RowCount < 1) return;
		ComBtnEnable("btn2_row_add");
		ComBtnEnable("btn2_row_del");
		if (document.form.cnt_cd.value == "JP") {
			with (shtObj) {
				for (var i=HeaderRows(); i<=LastRow(); i++) {
					if (GetCellValue(i, "edi_msg") == "ATD") SetCellEditable(i, "pod_cd", false);
				}
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnClick(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "to_eml_ctnt":
				case "cc_eml_ctnt":
					// MemoPad를 open시 해당Cell의 Editable속성이 false여야 함에 유의
					SetCellEditable(Row, Col, 0);
					ComShowMemoPad(shtObj, Row, Col, false);
					SetCellEditable(Row, Col, 1);
					break;
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnChange(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "edi_msg":
					if (Value == "ATD" && GetCellValue(Row, "cnt_cd") == "JP") {
						SetCellValue(Row, "pod_cd", "");
						SetCellEditable(Row, "pod_cd", false);
					} else {
						SetCellEditable(Row, "pod_cd", true);
					}
					break;
				case "pol_cd":
				case "pod_cd":
					if (ComTrim(Value) == "") {
						SetCellValue(Row, Col + 1, "", 0);
					} else {
						var xmlStr = GetSearchData("ESM_Booking_UtilGS.do", "f_cmd=" + SEARCHLIST17 + "&input_text=" + Value);
						var locNm = ComGetEtcData(xmlStr, "output_text");
						if (locNm == "") {
							ComShowCodeMessage("COM130402", "[" + Value + "]");    // '{?msg1} doesn\'t exist'
							SetCellValue(Row, Col, "", 0);
							SelectCell(Row, Col, true);
						} else {
							SetCellValue(Row, Col + 1, locNm, 0);
						}
					}
					break;
			}
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSaveEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// Retrieve after saving
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	function setComboData(shtObj) {
		with (shtObj) {
			var ediMsg = "";
			var ediMsgTpId = "";
			switch (document.form.cnt_cd.value) {
				case "US":
					ediMsg = "AMS|AMS VSL Departure";
					ediMsgTpId = "No Response|EDI Technical Failure|Rejection(Error)|DNL/DNL Removals|Hold/Hold Removals|Technical Errors";
					break;
				case "CA":
					ediMsg = "ACI";
					ediMsgTpId = "No Response|EDI Technical Failure|Rejection(Error)|DNL/DNL Removals|Hold/Hold Removals|Technical Errors";
					break;
				case "EU":
					ediMsg = "ENS|EXS|AN|Diversion";
					ediMsgTpId = "No Response|EDI Technical Failure|Rejection(Error)|DNL/DNL Removals|Hold/Hold Removals|Advisory|Missing Data";
					break;
				case "CN":
					ediMsg = "CCAM";
					ediMsgTpId = "No Response|EDI Technical Failure|Rejection(Error)|DNL/DNL Removals|Hold/Hold Removals";
					break;
				case "JP":
					ediMsg = "AMR/CMR|ATD";
					ediMsgTpId = "No Response|EDI Technical Failure|Rejection(Error)|DNL/DNL Removals|Hold/Hold Removals(HLD,DNU,SPD)";
					break;
			}
			SetColProperty("edi_msg", {ComboText:ediMsg, ComboCode:ediMsg});
			SetColProperty("edi_msg_tp_id", {ComboText:ediMsgTpId, ComboCode:ediMsgTpId});
		}
	}
/* 개발자 작업 끝 */
