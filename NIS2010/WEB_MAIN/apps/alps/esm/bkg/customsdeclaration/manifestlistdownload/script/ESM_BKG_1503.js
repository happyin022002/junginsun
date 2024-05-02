/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1503.js
*@FileTitle : Departure Time Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.06.28 김상수
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
	 * @class ESM_BKG_1503 : ESM_BKG_1503 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1503() {
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


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

//		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {

				case "btn_calendar":    // 캘린더 호출
					if (window.event.srcElement.disabled) return;
					var cal = new ComCalendar();
					cal.select(frmObj.etd_date, "yyyy-MM-dd");
					break;

				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
				break;

				case "btn_new":
					frmObj.pol_split_no.className = "input";
					frmObj.pol_split_no.disabled = false;
					ComResetAll();
				break;

				case "btn_transmit":
					doActionIBSheet(shtObj, frmObj, COMMAND01);
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

		ComBtnDisable("btn_transmit");

		initControl();

		// sheet1_OnLoadFinish 메서드 존재시 반드시 참조
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {

				case "sheet1":    // 트랜잭션을 위해 사용되는 Dummy Sheet
					var cnt = 0;
					// 높이 설정
					style.height = 0;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(1, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, true, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle  = "status";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");    // [필수]

					WaitImageVisible = false;

					break;
			}
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);    // 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case IBSEARCH:    // 조회
				frmObj.etd_date.removeAttribute("required");
				frmObj.etd_time.removeAttribute("required");
				// ETD_DATE를 제외하고 Validation
				if (!ComChkObjValid(frmObj.vvd) || !ComChkObjValid(frmObj.pol_cd)) return;
				ComOpenWait(true);
				var vvd = frmObj.vvd.value;
				var polCd = frmObj.pol_cd.value;
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1503GS.do", FormQueryString(frmObj));
				frmObj.vvd.value = vvd;
				frmObj.pol_cd.value = polCd;
				ComOpenWait(false);
				// HTML Object의 disabled는 ComOpenWait(false)이후에 동작하므로, sheet1_OnSeachEnd가 아닌 여기에 위치
				if (parseInt(shtObj.EtcData("data_rows")) < 1) {
					frmObj.pol_split_no.className = "input";
					frmObj.pol_split_no.disabled = false;
					frmObj.etd_date.value = "";
					frmObj.etd_time.value = "";
					ComBtnDisable("btn_transmit");
					ComShowCodeMessage("COM130401");    // There is no data to search.
				} else {
					frmObj.pol_split_no.className = "input2";
					frmObj.pol_split_no.disabled = true;
					ComBtnEnable("btn_transmit");
					// 조회된 ETC데이터를 Form의 Element에 setting
					frmObj.etd_date.value = shtObj.EtcData("etd_date");
					frmObj.etd_time.value = shtObj.EtcData("etd_time");
					if (shtObj.EtcData("rlx_div") == "1") {
						frmObj.rlx_div.checked = true;
					} else {
						frmObj.rlx_div.checked = false;
					}
				}
				break;

			case COMMAND01:    // EDI Transmit
				frmObj.etd_date.setAttribute("required", "");
				frmObj.etd_time.setAttribute("required", "");
				if (!ComChkValid(frmObj)) return;
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;
				shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_BKG_1503GS.do", FormQueryString(frmObj)));
				ComOpenWait(false);
			break;
		}
	}


	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 저장 후 메시지
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
	}


/* 개발자 작업 끝 */
