/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1504.js
*@FileTitle  : JMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
 ========================================================= */
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT = 0; [입력]ADD = 1; [조회]SEARCH = 2; [리스트조회]SEARCHLIST = 3;
					[수정]MODIFY = 4; [삭제]REMOVE = 5; [리스트삭제]REMOVELIST = 6 [다중처리]MULTI = 7
					기타 여분의 문자상수  COMMAND01 = 11; ~ COMMAND20 = 30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */
	/**
	 * @extends
	 * @class ESM_BKG_1504 : ESM_BKG_1504 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
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
				case "btn_calendar":    // 캘린더 호출
					if (window.event.srcElement.disabled) return;
					var cal = new ComCalendarFromTo();
					cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
					break;
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
					break;
				case "btn_bl_inquiry":
					if (shtObj.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");
						return;
					}
					var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
					// 선택된 row들의 bl_no 비교 (ColMerge 때문)
					var blNo = shtObj.GetCellValue(chkRowArr[0], "bl_no");
					for (var i = 1; i<chkRowArr.length-1; i++) {
						if (blNo != shtObj.GetCellValue(chkRowArr[i], "bl_no")) {
							ComShowCodeMessage("BKG01134");
							return;
						}
					}
					ComOpenPopup("ESM_BKG_1502.do?pop_mode=Y&bl_no=" + blNo, 1002, 585, "", "1,0", false);
					break;
				case "btn_down_excel":
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
		for (var i = 0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj == > 시트오브젝트, shtNo == > 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {
				case "sheet1":
					var cnt = 0;
					document.form.pagerows.value = 500;
					var HeadTitle = "|SEQ|SEL|VVD|B/L No.|POL|POD|DEL|Sent Type|Ack. Status|Send Date|Received Date|Sender";
					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

					var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
								  {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
								  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"jp_snd_log_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ack_sts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					InitColumns(cols);
					SetEditable(1);
					SetWaitImageVisible(0);
					SetEditableColorDiff(0);
					SetSheetHeight(389);
				break;
			}
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		// 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
//		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case IBSEARCH:       // 조회
				if (!ComChkValid(frmObj)) return;
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1504GS.do", FormQueryString(frmObj) );
				ComOpenWait(false);
				break;
		}
	}
/* 개발자 작업 끝 */
