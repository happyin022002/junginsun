/* =========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1514.js
*@FileTitle : Australia Cargo List Report - CARLST
*@author : CLT
*@version : 1.0
*@since : 2014/11/13
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
		var shtObj1 = sheetObjects[0];
		var shtObj2 = sheetObjects[1];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(shtObj1, frmObj, IBSEARCH);
				break;

				case "btn_new":
					ComResetAll();
					ComBtnDisable("btn2_row_add");
					ComBtnDisable("btn2_row_del");
				break;

				case "btn_carlst":
					var checkedRows = shtObj1.CheckedRows("chk");
					if (checkedRows < 1) {
						ComShowCodeMessage("COM12189");    // 'Nothing selected'
						return;
					} else if (checkedRows > 1) {
						ComShowCodeMessage("COM12177");    // 'Please select one only.'
						return;
					}
					ComOpenWindowCenter("ESM_BKG_1515.do?edi_ref_id=" + shtObj1.GetCellValue(shtObj1.FindCheckedRow("chk").split("|")[0], "edi_ref_id"), "ESM_BKG_1515", 700, 350);
				break;

				case "btn_transmit":
					doActionIBSheet(shtObj1, frmObj, COMMAND01);
				break;

				case "btn2_row_add":
					var newRowIdx = shtObj1.DataInsert(-1);
					shtObj1.SelectCell(newRowIdx, "cntr_no");
				break;

				case "btn2_row_del":
					ComRowHideDelete(shtObj1, "chk");
				break;

				case "btn2_load_excel":
					shtObj1.LoadExcel( {Append:1} );
				break;

				case "btn2_down_form":
					shtObj2.Down2Excel();
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

					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

					var HeadTitle = "|Seq.|Sel.|Container No.|POL|Status|Send Date|Receive Result"
					              // Hidden columne
					              + "|bkg_no";
					var info = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ { Type:"Status",     Hidden:1,   Width:40,   Align:"Center",   ColMerge:0,   SaveName:"ibflag" },
								 { Type:"Seq",        Hidden:0,   Width:35,   Align:"Center",   ColMerge:0,   SaveName:"seq" },
								 { Type:"DummyCheck", Hidden:0,   Width:50,   Align:"Center",   ColMerge:0,   SaveName:"chk" },

								 { Type:"Text",       Hidden:0,   Width:150,  Align:"Center",   ColMerge:0,   SaveName:"cntr_no",        Edit:1,   KeyField:1,   AcceptKeys:"N|E",   InputCaseSensitive:1,   EditLen:20 },
								 { Type:"Text",       Hidden:0,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"vvd_pol",        Edit:1,   KeyField:1,   AcceptKeys:"N|E",   InputCaseSensitive:1,   EditLen:10 },
								 { Type:"Combo",      Hidden:0,   Width:150,  Align:"Center",   ColMerge:0,   SaveName:"cntr_cgo_ind",   Edit:1,   KeyField:1 },
								 { Type:"Text",       Hidden:0,   Width:140,  Align:"Center",   ColMerge:0,   SaveName:"snd_dt",         Edit:0 },
								 { Type:"Text",       Hidden:0,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"rcv_rslt",       Edit:0 },

								 { Type:"Text",       Hidden:1,   Width:120,  Align:"Center",   ColMerge:0,   SaveName:"bkg_no" } ]
					InitColumns(cols);

					SetColProperty("cntr_cgo_ind", {ComboText:" |Carbotage|Empty|Export", ComboCode:" | C|E|X", DefaultValue:" "});

					SetEditable(1);
					SetCountPosition(0);
					SetWaitImageVisible(0);
					SetShowButtonImage(3);
					SetSheetHeight(450);
				}
			break;

			case "sheet2":
				with(shtObj) {
					var cnt = 0;

					SetEditEnterBehavior("tab");

					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

					var HeadTitle = "Container No.|POL|Status";
					var info = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ { Type:"Text",       Hidden:0,   Width:200,  Align:"Left",   ColMerge:0,   SaveName:"cntr_no" },
								 { Type:"Text",       Hidden:0,   Width:100,  Align:"Left",   ColMerge:0,   SaveName:"vvd_pol" },
								 { Type:"Combo",      Hidden:0,   Width:150,  Align:"Left",   ColMerge:0,   SaveName:"cntr_cgo_ind" } ];
					InitColumns(cols);

					SetEditable(1);
					SetCountPosition(0);
					SetWaitImageVisible(0);
					SetSheetHeight(100);
					SetVisible(0);
				}
			break;
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case IBSEARCH:       // Retrieve
				if (!ComChkValid(frmObj)) return;
				ComOpenWait(true);
				shtObj.SetHeaderCheck(1, "chk", 0);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1514GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
			break;

			case COMMAND01:    // Transmit
				if (!ComChkValid(frmObj)) return;
				if (shtObj.CheckedRows("chk") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				frmObj.f_cmd.value = COMMAND01;
				var saveString = ComSetPrifix(shtObj.GetSaveString(false, true, "chk"), "sheet_");
				if (saveString == "") return;
				ComOpenWait(true);
				var xmlStr = shtObj.GetSaveData("ESM_BKG_1514GS.do", FormQueryString(frmObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					shtObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;
		}
	}


	/**
	 * Call - BackEndJob : check jobState : '3'
	 */
	function getBackEndJobStatus() {
		var shtObj = sheetObjects[0];
		var xmlStr = shtObj.GetSearchData("ESM_BKG_1514GS.do", "f_cmd=" + COMMAND02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");
		if (jbStsFlg == "3") {
			ComOpenWait(false);
			shtObj.LoadSaveData(shtObj.GetSaveData("ESM_BKG_1514GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey), {Sync:1});
			clearInterval(timer);
			backEndJobKey = "";

		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSaveEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
		// Retrieve after saving
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


/* 개발자 작업 끝 */
