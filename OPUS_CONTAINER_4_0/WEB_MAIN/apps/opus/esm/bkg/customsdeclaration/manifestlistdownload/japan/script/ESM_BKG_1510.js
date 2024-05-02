/* =========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1510.js
*@FileTitle : Approval Number for Bonded Transportation
*@author : CLT
*@version : 1.0
*@since : 2014/10/08
 ========================================================= */
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT = 0; [입력]ADD = 1; [조회]SEARCH = 2; [리스트조회]SEARCHLIST = 3;
					[수정]MODIFY = 4; [삭제]REMOVE = 5; [리스트삭제]REMOVELIST = 6 [다중처리]MULTI = 7
					기타 여분의 문자상수  COMMAND01 = 11; ~ COMMAND20 = 30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author CyberLogitec
	 */

/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var saveCount = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH, "");
					break;

				case "btn_save":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
					break;

				case "btn_del":
					frmObj.delt_flg.value = "Y";
					frmObj.apro_no.value = "";
					frmObj.cstms_cd.value = "";
					frmObj.wh_nm.value = "";
					frmObj.trsp_mod_cd.value = "";
					break;

				case "btn_close":
					if (saveCount > 0) {
						// 저장이 한번이라도 되었으면 부모창 재조회
						var opener = window.dialogArguments;
						if (!opener) opener = parent;
						opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
					}
					ComClosePopup();
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
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "DELT_FLG");
	}


	/**
	 * setting form control  & event
	 */
	function initControl() {
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var frmObj = document.form;
		frmObj.delt_flg.value = "";

		var elementName = ComGetEvent("name");
		switch (elementName) {
			case "apro_no":
				with (sheetObjects[0]) {
					var aproNoRow = FindText("apro_no", frmObj.apro_no.value);
					if (aproNoRow > -1) {
						frmObj.cstms_cd.value = GetCellValue(aproNoRow, "cstms_cd");
						frmObj.wh_nm.value = GetCellValue(aproNoRow, "wh_nm");
						frmObj.trsp_mod_cd.value = GetCellValue(aproNoRow, "trsp_mod_cd");
					} else {
						frmObj.cstms_cd.value = "";
						frmObj.wh_nm.value = "";
						frmObj.trsp_mod_cd.value = "";
					}
				}
			break;
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with(shtObj) {
			switch (shtObj.id) {
				case "sheet1":    // from BKG_CSTMS_JP_WH_ROUT
				case "sheet2":    // from BKG_CSTMS_JP_BL
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
					var HeadTitle = "|apro_no|cstms_cd|wh_nm|trsp_mod_cd";
					var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status", Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,  SaveName:"ibflag" },
								{Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,  SaveName:"apro_no" },
								{Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,  SaveName:"cstms_cd" },
								{Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,  SaveName:"wh_nm" },
								{Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,  SaveName:"trsp_mod_cd" } ];
					InitColumns(cols);

					SetEditable(0);
					SetWaitImageVisible(0);
					SetSheetHeight(200);
					SetVisible(0);
				break;
			}
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, sParam) {
		switch(sAction) {
			case IBSEARCH:    //조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				var xmlArr = shtObj.GetSearchData("ESM_BKG_1510GS.do", FormQueryString(frmObj)).split("|$$|");
				ComResetAll();    //기본 object 초기화
				shtObj.LoadSearchData(xmlArr[0], {Sync:1});
				sheetObjects[1].LoadSearchData(xmlArr[1], {Sync:1});

				if (sParam == "") frmObj.delt_flg.value = "";
				if (frmObj.delt_flg.value != "Y") {
					if (sheetObjects[1].SearchRows() > 0 && sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "apro_no") != "") {
						with (sheetObjects[1]) {
							frmObj.apro_no.value = GetCellValue(HeaderRows(), "apro_no");
							frmObj.cstms_cd.value = GetCellValue(HeaderRows(), "cstms_cd");
							frmObj.wh_nm.value = GetCellValue(HeaderRows(), "wh_nm");
							frmObj.trsp_mod_cd.value = GetCellValue(HeaderRows(), "trsp_mod_cd");
						}
					} else if (shtObj.SearchRows() == 1) {
						with (shtObj) {
							frmObj.apro_no.value = GetCellValue(HeaderRows(), "apro_no");
							frmObj.cstms_cd.value = GetCellValue(HeaderRows(), "cstms_cd");
							frmObj.wh_nm.value = GetCellValue(HeaderRows(), "wh_nm");
							frmObj.trsp_mod_cd.value = GetCellValue(HeaderRows(), "trsp_mod_cd");
						}
					} else {
						frmObj.apro_no.value = "";
						frmObj.cstms_cd.value = "";
						frmObj.wh_nm.value = "";
						frmObj.trsp_mod_cd.value = "";
					}
				}
				ComOpenWait(false);
				break;

			case IBSAVE:    // 저장
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI;
				shtObj.LoadSaveData(shtObj.GetSaveData("ESM_BKG_1510GS.do", FormQueryString(frmObj)));
				ComOpenWait(false);
				break;
		}
	}


	/**
	 * handling event after searching
	 */
	function sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		var frmObj = document.form;
		ComClearCombo(frmObj.apro_no);
		if (Code < 0 || shtObj.SearchRows() < 1) return;
		with (shtObj) {
			// Combo Item 생성
			ComAddComboItem(frmObj.apro_no, "", "");
			for (var i=HeaderRows(); i<=LastRow(); i++) {
				var aproNo = GetCellValue(i, "apro_no");
				ComAddComboItem(frmObj.apro_no, aproNo, aproNo);
			}
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSaveEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		saveCount++;    // 저장여부를 알기위하여 사용됨
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
	}


/* 개발자 작업  끝 */
