/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1508.js
*@FileTitle : JMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.05.14 김상수
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends
	 * @class ESM_BKG_1508 : ESM_BKG_1508 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1508() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
		this.frmObj_OnChange    = frmObj_OnChange;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var selectAll = false;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

//		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {

				case "date_vvd_div":
					if (frmObj.date_vvd_div[0].checked) {
						frmObj.date_fm.readOnly = false;
						frmObj.date_fm.className = "input1";
						frmObj.date_fm.setAttribute("required", "");
						frmObj.date_to.readOnly = false;
						frmObj.date_to.className = "input1";
						frmObj.date_to.setAttribute("required", "");
						ComEnableObject(frmObj.btn_calendar, true);
						frmObj.vvd.value = "";
						frmObj.vvd.removeAttribute("required");
						frmObj.vvd.className = "input2";
						frmObj.vvd.readOnly = false;
					} else {
						frmObj.vvd.readOnly = false;
						frmObj.vvd.className = "input1";
						frmObj.vvd.setAttribute("required", "");
						frmObj.date_fm.value = "";
						frmObj.date_fm.removeAttribute("required");
						frmObj.date_fm.className = "input2";
						frmObj.date_fm.readOnly = true;
						frmObj.date_to.value = "";
						frmObj.date_to.removeAttribute("required");
						frmObj.date_to.className = "input2";
						frmObj.date_to.readOnly = true;
						ComEnableObject(frmObj.btn_calendar, false);
					}
					break;

				case "btn_calendar":    // 캘린더 호출
					if (window.event.srcElement.disabled) return;
					var cal = new ComCalendarFromTo();
					cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
					break;

				case "btn2_selectall":
					// Head AllCheck에서 지원하지 않는 기능이어서 별도 구현
					with (shtObj) {
						if (selectAll) {
							CheckAll2("chk") = 0;
							selectAll = false;
						} else {
							if (RowCount > 0) {
								ReDraw = false;
								var rngTxtArr = GetRangeText(HeaderRows, SaveNameCol("ib_skd_voy_no"), LastRow, SaveNameCol("ob_skd_dir_nm")).split("^");
								for (var i=rngTxtArr.length-1; i>-1; i--) {
									if (rngTxtArr[i].split("|").join("").trim() != "") {
										CellValue2(i+HeaderRows, "chk") = 1;
										selectAll = true;
									}
								}
								ReDraw = true;
							}
						}
					}
				break;

				case "btn2_rowadd":
					var newRowIdx = shtObj.DataInsert(-1);
					shtObj.SelectCell(newRowIdx, "vvd");
					if (!ComIsBtnEnable("btn_save")) {
						ComBtnEnable("btn2_delete");
						ComBtnEnable("btn_save");
						ComBtnEnable("btn_down_excel");
					}
				break;

				case "btn2_delete":
					ComRowHideDelete(shtObj, "chk");
				break;

				case "btn_new":
					shtObj.RemoveEtcData();
					ComResetAll();
					ComBtnDisable("btn2_delete");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_down_excel");
					frmObj.date_vvd_div[0].fireEvent("onclick");    // 강제로 OnClick이벤트 발생
					break;

				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
					break;

				case "btn_down_excel":
					ComOpenWait(true);
					shtObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk", "", false, "", false);
					ComOpenWait(false);
					break;

				case "btn_upload_excel":
					ComOpenWait(true);
					shtObj.LoadExcel(-2, 1, "", -1, -1, "", false);
					ComOpenWait(false);
					// ComOpenWait(false) 이후에 작동되어야 하므로..
					if (shtObj.RowCount > 0) {
						ComBtnEnable("btn2_delete");
						ComBtnEnable("btn_save");
						ComBtnEnable("btn_down_excel");
					}
					break;

			} // end switch

//		} catch(e) {
//			if (e == "[object Error]") {
//				ComShowMessage(OBJECT_ERROR);
//			} else {
//				ComShowMessage(e);
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
		initControl();

		ComBtnDisable("btn2_delete");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_down_excel");

		document.form.date_vvd_div[0].fireEvent("onclick");    // 강제로 OnClick이벤트 발생
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {

				case "sheet1":
				case "sheet2":    // DUP체크용 Dummy Sheet
					var cnt = 0;

					// 높이 설정
					if (shtObj.id == "sheet1") {
						style.height = GetSheetHeight(20);
					} else {
						style.height = 0;
					}

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(2, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 컬럼 헤더타이틀
					var HeadTitle0 = "|Seq.|Sel.|ALPS VVD|Lane\nCode|OPR\nCode|VSL Name|IMO Code|Public VVD|Public VVD|Public VVD|Public VVD|Public VVD|ETA|ETB|ETD|Remark";
					var HeadTitle1 = "|Seq.|Sel.|ALPS VVD|Lane\nCode|OPR\nCode|VSL Name|IMO Code|VSL Code|I/B|I/B|O/B|O/B|ETA|ETB|ETD|Remark";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, false, true, false, false);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,     "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtDataSeq,      40,    daCenter,    true,     "seq");
					InitDataProperty(0, cnt++, dtCheckBox,     40,    daCenter,    true,     "chk");
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,     "vvd",              true,     "",    dfNone,    0,    false,    true,    9,     true);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,     "slan_cd",          false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,     "crr_cd",           false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         130,   daLeft,      true,     "vsl_eng_nm",       false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    true,     "lloyd_no",         false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    false,    "vsl_cd",           false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    false,    "ib_skd_voy_no",    false,    "",    dfNone,    0,    true,     true,    20);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    false,    "ib_skd_dir_nm",    false,    "",    dfNone,    0,    true,     true,    20);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    false,    "ob_skd_voy_no",    false,    "",    dfNone,    0,    true,     true,    20);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    false,    "ob_skd_dir_nm",    false,    "",    dfNone,    0,    true,     true,    20);
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,     "eta_dt",           false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,     "etb_dt",           false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,     "etd_dt",           false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         300,   daLeft,      true,     "mf_rmk",           false,    "",    dfNone,    0,    true,     true,    3998);

					ColIndent("vsl_eng_nm") = 2;
					ColIndent("mf_rmk") = 2;

					// 입력제한
					InitDataValid(0, "vvd", vtEngUpOther, "0123456789");
					InitDataValid(0, "ib_skd_voy_no", vtEngUpOther, "0123456789-");
					InitDataValid(0, "ib_skd_dir_nm", vtEngUpOther, "0123456789-");
					InitDataValid(0, "ob_skd_voy_no", vtEngUpOther, "0123456789-");
					InitDataValid(0, "ob_skd_dir_nm", vtEngUpOther, "0123456789-");
					InitDataValid(0, "mf_rmk", vtEngOther, "0123456789~!@#$%^&*()-_=+\|[{]};:'\",<.>/? ");

					WaitImageVisible = false;
					EditableColorDiff = true;
					SelectHighLight = false;

					break;
			}
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		// 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction) {
		switch (sAction) {

			case IBSEARCH:       // btn_retrieve
				if (frmObj.date_vvd_div[0].checked) {
					frmObj.date_fm.setAttribute("required", "");
					frmObj.date_to.setAttribute("required", "");
				}
				if (!ComChkValid(frmObj)) return;
				if (!validateForm(shtObj, frmObj, sAction)) return;
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1508GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				// ComOpenWait(false) 이후에 작동되어야 하므로..
				if (shtObj.RowCount > 0) {
					if (frmObj.search_div[0].checked) {
						ComBtnDisable("btn2_delete");
					} else {
						ComBtnEnable("btn2_delete");
					}
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_down_excel");
				}
				break;

			case IBSAVE:       // btn_save
				frmObj.date_fm.removeAttribute("required");
				frmObj.date_to.removeAttribute("required");
				if (!ComChkValid(frmObj)) return;
				with (shtObj) {
					var chkRowArr = FindCheckedRow("chk").split("|");
					chkRowArr.pop();    // Array에서 마지막 빈 값 삭제
					var stsRowArr = FindStatusRow("D").split(";");
					stsRowArr.pop();    // Array에서 마지막 빈 값 삭제
					if (chkRowArr.length < 1 && stsRowArr.length < 1) {
						ComShowCodeMessage("COM130503");    // "There is no updated data to save."
						return;
					}
					if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
					if (chkRowArr.length > 0 && shtObj.GetSaveString(false, true, "chk") == "") return; // Sheet1의 Mandatory Check 용도

					ComOpenWait(true);

					for (var c in chkRowArr) {
						var rngTxt = GetRangeText(chkRowArr[c], SaveNameCol("ib_skd_voy_no"), chkRowArr[c], SaveNameCol("ob_skd_dir_nm"));
						if (rngTxt.split("|").join("").trim() == "") {
							ComOpenWait(false);
							ComShowMessage("Mandatory item is missing. Please insert.");
							CellValue2(chkRowArr[c], "chk") = 0;
							SelectCell(chkRowArr[c], "chk");
							return;
						}
					}

					ReDraw = false;
					// 중복체크(S)
					for (var h=HeaderRows; h<=LastRow; h++) RowBackColor(h) = RgbColor(256,256,256);;
					sheetObjects[1].RemoveAll();
					Copy2SheetCol(sheetObjects[1], "vvd", "vvd", -1, -1, -1, 2, true, false, "chk");
					var dupRowArray = sheetObjects[1].ColValueDupRows("vvd").split(",");
					var firstDupRow = 0;
					for (var k=0; k<dupRowArray.length; k++) {
						if (dupRowArray[k].trim() != "") {
							// return값이 하나일경우 숫자형이므로 "|"으로 split되지 않음에 유의
							var sameRows = ComFindAll(shtObj, "vvd", sheetObjects[1].CellValue(dupRowArray[k], "vvd")).toString().split("|");
							for (var i in sameRows) {
								if (CellValue(sameRows[i], "chk") == 1) {
									if (k == 0) firstDupRow = sameRows[i];
									RowBackColor(sameRows[i]) = RgbColor(256,256,192);
								}
							}
						}
					}
					ReDraw = true;
					if (firstDupRow > 0) {
						ComOpenWait(false);
						ComShowCodeMessage("COM12115", "VVD");    // "{?msg1} has been duplicated."
						SelectCell(firstDupRow, "vvd");
						return;
					}
					// 중복체크(E)

					frmObj.f_cmd.value = MULTI;
					var saveString = "";
					for (var s in stsRowArr) saveString = (saveString + RowSaveStr(stsRowArr[s]) + "&");
					LoadSaveXml(GetSaveXml("ESM_BKG_1508GS.do", FormQueryString(frmObj) + "&" + ComSetPrifix(saveString + GetSaveString(false, true, "chk"), "sheet1_")));
					ComOpenWait(false);
				}
			break;
		}
	}


	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		selectAll = false;
	}


	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnChange(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "chk":
					var rngTxt = GetRangeText(Row, SaveNameCol("ib_skd_voy_no"), Row, SaveNameCol("ob_skd_dir_nm"));
					if (rngTxt.split("|").join("").trim() == "") {
						ComShowMessage("Mandatory item is missing. Please insert.");
						CellValue2(Row, "chk") = 0;
						SelectCell(Row, "ib_skd_voy_no");
					}
				break;
			}

		}
	}


	/**
	 * IBSeet LoadExcel 함수를 이용하여 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 */
	function sheet1_OnLoadExcel(shtObj) {
		selectAll = false;
		if (shtObj.RowCount > 0) {
			// 엑셀 loading후 빈 row는 삭제
			with (shtObj) {
				ReDraw = false;
				var rngTxtArr = GetRangeText(HeaderRows,  SaveNameCol("vvd"), LastRow, SaveNameCol("etd_dt")).split("^");
				for (var i=rngTxtArr.length-1; i>-1; i--) {
					if (rngTxtArr[i].split("|").join("").trim() == "") {
						RowDelete(i+HeaderRows, false);
					}
				}
				ReDraw = true;
			}
		}
	}


	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 저장 후 메시지
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// Public SKD로 저장 후 재조회
		document.form.search_div[1].checked = true;;
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param {Object} shtObj
	 * @param {Object} formObj
	 * @param {Object} sAction
	 */
	function validateForm(shtObj, frmObj, sAction) {
		with (frmObj){
			if (ComGetDaysBetween(frmObj.date_fm.value, frmObj.date_to.value) > 61) {
				ComShowCodeMessage("COM132001","Period","62 days");    // {?msg1} exceeds maximum duration {?msg2}.
				ComSetFocus(frmObj.date_to);
				return false;
			}
		}
		return true;
	}


/* 개발자 작업 끝 */
