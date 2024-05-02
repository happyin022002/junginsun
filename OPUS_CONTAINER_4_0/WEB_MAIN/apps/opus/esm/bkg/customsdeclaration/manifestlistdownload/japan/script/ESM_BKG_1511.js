/* =========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1511.js
*@FileTitle : Bonded Place Code Maintenance
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
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
//		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn2_rowadd":
					var newRowIdx = shtObj.DataInsert(-1);
					shtObj.SelectCell(newRowIdx, "yd_cd");
					break;

				case "btn2_rowdel":
					ComRowHideDelete(shtObj, "chk");
					break;

				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
					break;

				case "btn_new":
					frmObj.cnt_cd.className = "input1";
					frmObj.cnt_cd.disabled = false;
					ComResetAll();
					break;

				case "btn_save":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
					break;
			} // end switch
//		} catch(e) {
//			if (e == "[object Error]") {
//				ComShowMessage(OBJECT_ERROR);
//			} else {
//				ComShowMessage(e.message);
//			}
//		}
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

					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

					var HeadTitle = "|SEQ|DEL|Yard Code|Bonded Place Code|Bonded Place Name" +
					                // Hidden Column
					                "|org_cstms_cd|org_wh_nm";
					var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",     Hidden:1,   Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Seq",        Hidden:0,   Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					             {Type:"DummyCheck", Hidden:0,   Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					             {Type:"Text",       Hidden:0,   Width:200,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",      KeyField:1,   Edit:1,   EditLen:7,   InputCaseSensitive:1,   AcceptKeys:"E|N" },
					             {Type:"Text",       Hidden:0,   Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cstms_cd",   KeyField:1,   Edit:1,   EditLen:10,  InputCaseSensitive:1 },
					             {Type:"Text",       Hidden:0,   Width:500,  Align:"Left",    ColMerge:0,   SaveName:"wh_nm",      KeyField:0,   Edit:1,   EditLen:500 },

					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd"    },
					             {Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_cstms_cd" } ];

					InitColumns(cols);

					SetEditable(1);
					SetCountPosition(0);
					SetWaitImageVisible(0);
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
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1511GS.do", FormQueryString(frmObj) );
				ComOpenWait(false);
				break;

			case IBSAVE:    // 저장
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI;
				shtObj.DoSave("ESM_BKG_1511GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;
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
				case "yd_cd":
					var xmlStr = shtObj.GetSearchData("ESM_BKG_CSTMS_COMMON_GS.do", "rtn_col_1=YD_CD AS RTN_COL_1&tbl_nm_1=MDM_YARD&whr_val_1=YD_CD \= '" + Value + "'&whr_val_2=NVL(DELT_FLG, 'N') = 'N'");
					var rtnCol = ComGetEtcData(xmlStr, "rtn_col_1");
					if (rtnCol == undefined || rtnCol == "") {
						ComShowCodeMessage("COM130402", "[" + Value + "]");    // '{?msg1} doesn\'t exist'
						SetCellValue(Row, Col, "", 0);
						SelectCell(Row, Col, true);
					}
					break;

				case "cstms_cd":
					var xmlStr = shtObj.GetSearchData("ESM_BKG_CSTMS_COMMON_GS.do", "rtn_col_1=CSTMS_CD AS RTN_COL_1&tbl_nm_1=BKG_WAREHOUSE&whr_val_1=CSTMS_CD \= '" + Value + "'");
					var rtnCol = ComGetEtcData(xmlStr, "rtn_col_1");
					if (rtnCol == undefined || rtnCol == "") {
						ComShowCodeMessage("COM130402", "[" + Value + "]");    // '{?msg1} doesn\'t exist'
						SetCellValue(Row, Col, "", 0);
						SelectCell(Row, Col, true);
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


/* 개발자 작업 끝 */
