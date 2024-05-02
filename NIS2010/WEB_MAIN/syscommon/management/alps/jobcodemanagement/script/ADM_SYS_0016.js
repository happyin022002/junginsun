/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ADM_SYS_0016.js
*@FileTitle : Job Code Request
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.05.24 최덕우
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
	* @class ADM_SYS_0016 : ADM_SYS_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	*/
	function ADM_SYS_0016() {
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
				case "btn_close":
					window.close();
					break;

				case "btn_usr_popup":
					ComOpenPopup("ADM_SYS_0017.do?ofc_cd="+frmObj.rqst_ofc_cd.value, 700, 445, "", "0,0", true, false);
					break;

				case "btn_request":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
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

		// ※※※ sheet1_OnLoadFinish 메서드 반드시 참조 ※※※

		if (document.form.prnt_no.value == "0015") {
			document.getElementById("request_area").style.display = "inline";    // ADM_SYS_0015에서 호출했을때만 display 함
		}
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
					style.height = GetSheetHeight(0);

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
					var HeadTitle  = "STS|Request|Job Code|Job Name|Program Assign";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,      daCenter,    false,    "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtCheckBox,     60,      daCenter,    false,    "check_val");
					InitDataProperty(0, cnt++, dtData,         150,     daCenter,    false,    "usr_role_cd",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         300,     daLeft,      false,    "usr_role_nm",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtPopup,        150,     daCenter,    false,    "pgm_asgn");

					ColIndent("usr_role_nm") = 2;

					WaitImageVisible = false;
					SelectHighLight = false;
					// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
					EditableColorDiff = false;
					ShowButtonImage = 2;
					break;
			}
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		// textArea용 maxlength제한 OnKeypress / OnKeyUp 이벤트 (CoJobcodemanagement.js에 정의)
		axon_event.addListener("keypress", "frmObj_OnKeyPress4TextArea", "rqst_rmk");
		axon_event.addListener("keyup", "frmObj_OnKeyUp4TextArea", "rqst_rmk");
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case IBSEARCH:    // 조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ADM_SYS_0016GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;

			case IBSAVE:    //저장
				if (!ComChkValid(frmObj)) return;
				if (!shtObj.IsDataModified) {
					ComShowCodeMessage("COM130503");
					return;
				} else if (ComShowCodeConfirm("COM130101", "data")) {    // Do you want to save {?msg1}?
					//저장처리
					ComOpenWait(true);
					frmObj.f_cmd.value = MULTI;
					shtObj.DoSave("ADM_SYS_0016GS.do", FormQueryString(frmObj), -1, false);
					ComOpenWait(false);
				}
				break;
		}
	}


	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	 function sheet1_OnLoadFinish(shtObj) {
		if (document.form.prnt_no.value == "0015") {
			shtObj.style.height = shtObj.GetSheetHeight(8);    // ADM_SYS_0015에서 호출했을때 Height 설정
		} else {
			shtObj.style.height = shtObj.GetSheetHeight(12);    // 그외 화면에서 호출했을때 Height 설정
		}
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		if (shtObj.RowCount < 1) {
			// 등록된 Job Code가 없으면 Request버튼 비활성화
			ComBtnDisable("btn_request");
		} else {    // 아니면 ETC-DATA에서 apro_usr_id와 apro_usr_nm을 가져옴
			document.form.apro_usr_id.value = shtObj.EtcData("apro_usr_id");
			if(shtObj.EtcData("apro_usr_nm") == null){
				document.form.apro_usr_nm.value = "";
			} else {
				document.form.apro_usr_nm.value = shtObj.EtcData("apro_usr_nm");
			}
		}
	}


	/**
	 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */
	function sheet1_OnPopupClick(shtObj, Row, Col) {
		switch (shtObj.ColSaveName(Col)) {

			case "pgm_asgn":
				var param = "usr_role_cd=" + shtObj.CellValue(Row,"usr_role_cd") + "&usr_role_nm=" + shtObj.CellValue(Row,"usr_role_nm");
				// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
				ComOpenPopup("ADM_SYS_0013.do?" + param, 700, 445, "", "0,0", true, false, Row, Col, 0);
				break;
		}
	}


	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 에러가 발생했을 경우에 서버에서 리턴되는 메시지
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("JOB00001", "Data", "requested");    // {?msg1} was {?msg2} successfully.
		// 저장 후  부모창 재조회
		var opener = window.dialogArguments;    // MODAL창에서 부모창 호출
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		window.close();
	}

/* 개발자 작업 끝 */
