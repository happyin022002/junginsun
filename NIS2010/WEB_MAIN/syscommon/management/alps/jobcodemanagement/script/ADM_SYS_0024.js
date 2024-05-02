/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ADM_SYS_0024.js
*@FileTitle : Job Code Approver Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.07.09 최덕우
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
	* @class ADM_SYS_0024 : ADM_SYS_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	*/
	function ADM_SYS_0024() {
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
					ComOpenPopup("ADM_SYS_0025.do", 700, 445, "", "0,0", true, false);
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
					
				case "btn_ofc_pop":
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
					ComOpenPopup("COM_ENS_071.do?ofc_cd=" + frmObj.ofc_cd.value, 700, 445, "setPopupData_ofcCd", "1,0,1,1,1,1,1", true);
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
					var HeadTitle  = "|Sel.|ID|Approver Name|Office Name|Office Code|Last Updated|Updated ID|Updated By" ;

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    false,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     40,     daCenter,    false,   "del_chk");
					InitDataProperty(0, cnt++ , dtData,         80,    daCenter,    false,   "apro_usr_id",      false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         150,   	daLeft,    	 false,   "apro_usr_nm",      false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         300,    daCenter,    false,   "ofc_nm",			  false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         80,    daCenter,    false,   "ofc_cd",			  false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         90,    daCenter,    false,   "upd_dt",           false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         90,    daCenter,    false,   "upd_usr_id",       false,    "",     dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,         110,    daCenter,    false,   "upd_usr_nm",       false,    "",     dfNone,    0,    false,    false);
				
					WaitImageVisible = false;
					ShowButtonImage = 2;
					break;
			}
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction) {
		switch (sAction) {
			case IBSEARCH:    // 조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ADM_SYS_0024GS.do", FormQueryString(frmObj));
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
					shtObj.DoSave("ADM_SYS_0024GS.do", FormQueryString(frmObj), -1, false);
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:     //엑셀다운로드
				shtObj.Down2Excel(1);
				break;
		}
	}
	
	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_OnLoadFinish(shtObj) {
		doActionIBSheet(shtObj, document.form, IBSEARCH);
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
	 * Pop-Up Return Value 처리 부분<br>
	 * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
	 */
	function setPopupData_ofcCd(aryPopupData) {
		if (aryPopupData.length > 0 ) {
			document.form.ofc_cd.value = aryPopupData[0][3];
		}
	}

/* 개발자 작업 끝 */
