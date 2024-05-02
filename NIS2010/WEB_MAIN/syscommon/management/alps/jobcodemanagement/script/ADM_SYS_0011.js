/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ADM_SYS_0011.js
*@FileTitle : Job Code Adjustment Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.04.17 최덕우
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
	* @class ADM_SYS_0011 : ADM_SYS_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	*/
	function ADM_SYS_0011() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

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
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
				case "btn2_add":
					var addRow = shtObj.DataInsert(-1);
					shtObj.SelectCell(addRow, "usr_role_cd", true, "");
					break;

				case "btn2_delete":
					if(shtObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(shtObj,"del_chk");
					} else {
						ComShowCodeMessage("MNR00150");
					}
					break;

				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(shtObj,frmObj,IBSAVE);
					break;

				case "btn_downexcel":
					doActionIBSheet(shtObj,frmObj,IBDOWNEXCEL);
					break;
			} // end switch

		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
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

		initControl();

		// ※※※ sheet1_OnLoadFinish 메서드 존재시 반드시 참조 ※※※
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
					var cnt = 0;
					// 높이 설정
					style.height = GetSheetHeight(16);

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(1, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, false, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle  = "|Del|Job Code|Job Name|Job Description|Last Updated|Updated ID|Updated By|Office Assign|User Assigned|Program Assign|" ;

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    false,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,    false,   "del_chk");
					InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,   "usr_role_cd",      true,     "",     dfNone,    0,    false,    true,    5,    true);
					InitDataProperty(0, cnt++ , dtData,         110,    daCenter,    false,   "usr_role_nm",      true,     "",     dfNone,    0,    false,    true,    200);
					InitDataProperty(0, cnt++ , dtData,         160,    daLeft,      false,   "usr_role_desc");
					InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,   "upd_dt",           false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,   "upd_usr_id",       false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         120,    daCenter,    false,   "upd_usr_nm",       false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtPopup,        90,     daCenter,    false,   "ofc_ass");
					InitDataProperty(0, cnt++ , dtPopup,        90,     daCenter,    false,   "usr");
					InitDataProperty(0, cnt++ , dtPopup,        90,     daCenter,    false,   "pgm_ass");
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,    false,   "adm_ass");

					InitDataValid(0, "usr_role_cd", vtEngUpOther, "1234567890");    // 영대문자+숫자만
					InitDataValid(0, "usr_role_nm", vtEngOther, "1234567890 ");    // 영문자+숫자만+space

					WaitImageVisible = false;
					ShowButtonImage = 2;
					break;
			}
		}
	}


	/**
	* Form의 Conrol 초기화 및 초기 이벤트 등록
	*/
	function initControl() {
		axon_event.addListener("keypress", "frmObj_OnKeyPress2", "usr_role_cd");    // OnKeypress 이벤트2 - usr_role_cd의 특수성으로 인하여 현js에 별도 정의
		axon_event.addListener("keypress", "frmObj_OnKeyPress", "usr_role_nm");    // OnKeypress 이벤트 - CoJobcodemanagement.js에 정의
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction) {
		switch (sAction) {
			case IBSEARCH:    // 조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ADM_SYS_0011GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				if (!shtObj.IsDataModified) {
					ComShowCodeMessage("COM130503");
					return;
				} else if (ComShowCodeConfirm("COM130101", "data")) {    // Do you want to save {?msg1}?
					//저장처리
					ComOpenWait(true);
					frmObj.f_cmd.value = MULTI;
					shtObj.DoSave("ADM_SYS_0011GS.do", FormQueryString(frmObj), -1, false);
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:     //엑셀다운로드
				shtObj.Down2Excel(1);
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
		if (shtObj.RowCount > 0) {
			with (shtObj) {
				ReDraw = false;
				for (var i=HeaderRows; i<=LastRow; i++) {
					if (CellValue(i, "ofc_ass") == "O" || CellValue(i, "usr") == "O" || CellValue(i, "pgm_ass") == "O" || CellValue(i, "adm_ass") == "O") {
						CellEditable(i, "del_chk") = false;
					}
				}
				ReDraw = true;
			}
		}
	}


	/**
	 * Program Name Data List OpenWindow. <br>
	 * @param {int} Row 행번호
	 * @param {int} Col 컬럼번호
	 **/
	function sheet1_OnPopupClick(shtObj,Row,Col){
		var param = "usr_role_cd="+shtObj.CellValue(Row,"usr_role_cd")+"&usr_role_nm="+shtObj.CellValue(Row,"usr_role_nm");
		switch (shtObj.ColSaveName(Col)) {
			case "ofc_ass" :
				if (checkAleadySaveRow(shtObj, Row, Col)) {
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
					ComOpenPopup("ADM_SYS_0012.do?"+param, 700, 445, "", "0,0", true, false, Row, Col, 0);
				}
				break;

			case "usr":
				if (checkAleadySaveRow(shtObj, Row, Col)) {
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
					ComOpenPopup("ADM_SYS_0014.do?"+param, 780, 445, "", "0,0", true, false, Row, Col, 0);
				}
				break;

			case "pgm_ass":
				if (checkAleadySaveRow(shtObj, Row, Col)) {
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
					ComOpenPopup("ADM_SYS_0013.do?"+param+"&prnt_no=0011", 700, 445, "", "0,0", true, false, Row, Col, 0);
				}
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
				case "usr_role_cd":
					if (ComChkLen(Value, 5) < 2) {    // Value가 5글자일때만 2가 return
						ComShowCodeMessage("COM130201", "the characters in five (2 alphabet & 3 numbers)");    // Please input {?msg1}.
						SelectCell(Row, Col);
						return;
					}
					var tmpArr = [Value.substring(0, 2), Value.substring(2)];
					if (!ComIsAlphabet(tmpArr[0], "u") || !ComIsNumber(tmpArr[1])) {    // 앞3글자가 영문이 아니거나 뒷2글자가 숫자가 아닐 경우
						ComShowCodeMessage("JOB00002", "[Job Code] : " + Value, "(2 alphabet & 3 numbers)");    // {?msg1} is invalid. {?msg2}
						SelectCell(Row, Col, true, "");
						return;
					}
					// validation
					var xmlStr = shtObj.GetSearchXml("ADM_SYS_0011GS.do", "f_cmd=" + SEARCH01 + "&usr_role_cd=" + Value);
					if (ComParseInt(ComGetEtcData(xmlStr, "job_code_knt")) > 0) {
						ComShowCodeMessage("COM131302", "[Job Code] : " + Value);    // {?msg1} is duplicated.
						SelectCell(Row, Col, true, "");
					}
					break;
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
		// 저장 후 재조회
		//doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * Form Element의 OnKeyPress 이벤트 (공통에서 예외)
	 */
	function frmObj_OnKeyPress2() {
		var obj = window.event.srcElement;

		switch (obj.getAttribute("name")) {
			case "usr_role_cd":
				if (obj.value.length < 3) {
					ComKeyOnlyAlphabet("upper");
				} else {
					ComKeyOnlyNumber(obj);
				}
				break;
		}
	}


	/**
	 * Role이 저장되기 전에는 사용자와 프로그램 부여 불가
	 */
	function checkAleadySaveRow(sheetObj, Row, Col){
		var updateable = false;
		if (sheetObj.RowStatus(Row) == "I") {
			ComShowCodeMessage("JOB00006");
			updateable = false;
		} else if (sheetObj.CellValue(Row, "adm_yn") == "N") {
			ComShowCodeMessage("JOB00006");
			updateable = false;
		} else {
			updateable = true;
		}
		return updateable;
	}


/* 개발자 작업 끝 */
