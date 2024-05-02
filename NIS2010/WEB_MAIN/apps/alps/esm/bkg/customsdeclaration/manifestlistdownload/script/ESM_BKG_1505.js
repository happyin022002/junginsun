/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1505.js
*@FileTitle : Transmit Result Error Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.18
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.18 김상수
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
	 * @class ESM_BKG_1505 : ESM_BKG_1505 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1505() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.validateForm       = validateForm;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

//		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_close":
					window.close();
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

		// (sheet1_OnLoadFinish에 적용시에 Bug로 인하여 오류발생 됨)
		var frmObj = document.form;
		if (frmObj.jp_msg_tp_id.value == "SAS108") {
			if (frmObj.sc108_rst_dtl.value != "") {
				var sc108RstDtlArr = frmObj.sc108_rst_dtl.value.split("/");
				var newRowNum = 0;
				var attrCtnt =  "Discrepancy Identifier  ";
				with (sheetObjects[0]) {
					for (var k in sc108RstDtlArr) {
						if (sc108RstDtlArr[k] != "") {
							newRowNum = DataInsert(-1);
							CellValue2(newRowNum, "attr_ctnt1") = sc108RstDtlArr[k];
							switch (sc108RstDtlArr[k]) {
								case "H":
									CellValue2(newRowNum, "attr_ctnt2") = "AMR and CMR have been done. AHR and CHR have not been";
									CellValue2(newRowNum, "attr_ctnt4") = attrCtnt + "(no House B/L)";
									break;
								case "M":
									CellValue2(newRowNum, "attr_ctnt2") = "AMR and CMR have not been done. AHR and CHR have been";
									CellValue2(newRowNum, "attr_ctnt4") = attrCtnt + "(no Master B/L)";
									break;
								case "S":
									CellValue2(newRowNum, "attr_ctnt2") = "There is vessel information discrepancy between master B/L and house B/L";
									CellValue2(newRowNum, "attr_ctnt4") = attrCtnt + "(Discrepancy in Vessel Information)";
									break;
								case "T":
									CellValue2(newRowNum, "attr_ctnt2") = "Overdue Reporting";
									CellValue2(newRowNum, "attr_ctnt4") = (attrCtnt + "(Overdue Reporting)");
									break;
								case "A":
									CellValue2(newRowNum, "attr_ctnt2") = "Incomplete Advance Filing";
									CellValue2(newRowNum, "attr_ctnt4") = attrCtnt + "(Incomplete Advance Filing)";
									break;
								case "D":
									CellValue2(newRowNum, "attr_ctnt2") = "ATD has not been done";
									CellValue2(newRowNum, "attr_ctnt4") = attrCtnt + "(Incomplete Departure Time Registration)";
									break;
							}
						}
					}
					SelectCell(HeaderRows, "attr_ctnt2");
				}
			}
		} else {
			doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
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

				case "sheet1":    // 트랜잭션을 위해 사용되는 Dummy Sheet
					var cnt = 0;
					// 높이 설정
					style.height = GetSheetHeight(10);;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(1, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, false, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle  = "|Result Code|Relevant|Error Details|Options & Solutions";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    false,    "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtData,         75,    daCenter,    false,    "attr_ctnt1");
					InitDataProperty(0, cnt++, dtData,         125,   daCenter,    false,    "attr_ctnt2");
					InitDataProperty(0, cnt++, dtData,         170,   daLeft,      false,    "attr_ctnt4");
					InitDataProperty(0, cnt++, dtData,         170,   daLeft,      false,    "attr_ctnt5");

					ColIndent("attr_ctnt4") = 2;
					ColIndent("attr_ctnt5") = 2;

					WordWrap = true;
					WaitImageVisible = false;

					break;
			}
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction) {
		switch(sAction) {
			case IBSEARCH:    //조회
				if (!ComChkValid(frmObj)) return;
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1505GS.do", FormQueryString(frmObj));
				break;
		}
	}


/* 개발자 작업  끝 */
