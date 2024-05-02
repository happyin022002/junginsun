/* =========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1512.js
*@FileTitle : Approval Number and Place of Arrival Maintenance
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
					// Sheet내 Combo setting
					doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
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

		// Sheet내 Combo setting
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
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

					var HeadTitle = "|SEQ|DEL|POD Bonded Code|Expiry Date\n(DDMMYYYY)|Approval Number|Place of Arrival 1|Place of Arrival 2|Place of Arrival 3|Place of Arrival 4|Place of Arrival 5|Bonded Goods" +
					                // Hidden Column
					                "|org_cstms_cd|org_exp_dt|org_apro_no|org_trsp_mod_cd";
					var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);


					var cols = [ { Type:"Status",     Hidden:1,   Width:40,   Align:"Center",   ColMerge:0,   SaveName:"ibflag" },
								 { Type:"Seq",        Hidden:0,   Width:35,   Align:"Center",   ColMerge:0,   SaveName:"seq" },
								 { Type:"DummyCheck", Hidden:0,   Width:35,   Align:"Center",   ColMerge:0,   SaveName:"chk" },

								 { Type:"Combo",      Hidden:0,   Width:135,  Align:"Left",     ColMerge:0,   SaveName:"cstms_cd",      KeyField:1 },
								 { Type:"Text",       Hidden:0,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"exp_dt",        KeyField:1,   Edit:1,   EditLen:8,    AcceptKeys:"N" },
								 { Type:"Text",       Hidden:0,   Width:130,  Align:"Left",     ColMerge:0,   SaveName:"apro_no",       KeyField:1,   Edit:1,   EditLen:20,   AcceptKeys:"N" },
								 { Type:"Combo",      Hidden:0,   Width:120,  Align:"Left",     ColMerge:0,   SaveName:"cstms_cd1",     KeyField:1 },
								 { Type:"Combo",      Hidden:0,   Width:120,  Align:"Left",     ColMerge:0,   SaveName:"cstms_cd2" },
								 { Type:"Combo",      Hidden:0,   Width:120,  Align:"Left",     ColMerge:0,   SaveName:"cstms_cd3" },
								 { Type:"Combo",      Hidden:0,   Width:120,  Align:"Left",     ColMerge:0,   SaveName:"cstms_cd4" },
								 { Type:"Combo",      Hidden:0,   Width:120,  Align:"Left",     ColMerge:0,   SaveName:"cstms_cd5" },
								 { Type:"Combo",      Hidden:0,   Width:110,  Align:"Left",     ColMerge:0,   SaveName:"trsp_mod_cd",   KeyField:1 },

								 { Type:"Text",       Hidden:1,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"org_cstms_cd"      },
								 { Type:"Text",       Hidden:1,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"org_exp_dt"        },
								 { Type:"Text",       Hidden:1,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"org_apro_no"       },
								 { Type:"Text",       Hidden:1,   Width:100,  Align:"Center",   ColMerge:0,   SaveName:"org_trsp_mod_cd"   } ];

					InitColumns(cols);

					SetColProperty("trsp_mod_cd", {ComboText:"Truck|Ship|Barge|Rail Express|Other", ComboCode:"TR|SH|BA|RA|OT"});

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
			case SEARCH01:       // Sheet내 Combo setting (ESM_BKG_1511GS.do 이용)
				var rtnVal = ComXml2ComboString(shtObj.GetSearchData("ESM_BKG_1512GS.do", "f_cmd=" + SEARCH01), "cstms_cd", "cstms_cd");
				if (rtnVal[0] != undefined && rtnVal[0] != "") {
					shtObj.SetColProperty("cstms_cd", {ComboText:" |" + rtnVal[0], ComboCode:" |" + rtnVal[0]});
					shtObj.SetColProperty("cstms_cd1", {ComboText:" |" + rtnVal[0], ComboCode:" |" + rtnVal[0]});
					shtObj.SetColProperty("cstms_cd2", {ComboText:" |" + rtnVal[0], ComboCode:" |" + rtnVal[0]});
					shtObj.SetColProperty("cstms_cd3", {ComboText:" |" + rtnVal[0], ComboCode:" |" + rtnVal[0]});
					shtObj.SetColProperty("cstms_cd4", {ComboText:" |" + rtnVal[0], ComboCode:" |" + rtnVal[0]});
					shtObj.SetColProperty("cstms_cd5", {ComboText:" |" + rtnVal[0], ComboCode:" |" + rtnVal[0]});
				}
				break;

			case IBSEARCH:       // 조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1512GS.do", FormQueryString(frmObj) );
				ComOpenWait(false);
				break;

			case IBSAVE:    // 저장
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI;
				shtObj.DoSave("ESM_BKG_1512GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;
		}
	}


	function sheet1_OnEditValidation(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "exp_dt":
					if (Value.length > 0 || Value.length < 8) {
						var year = Value.substring(4);
						var month = Value.substring(2, 4);
						var day = Value.substring(0, 2);
						if ((ComParseInt(year) < 1900)  || !ComIsMonth(month) || !ComIsDay(year, month ,day)) {;
							ComShowMessage("Please enter a valid date format: [DDMMYYYY]");
							ValidateFail(1);
							return false;
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
		("COM130102", "Data");    // {?msg1} was saved successfully.
		// Retrieve after saving
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


/* 개발자 작업 끝 */
