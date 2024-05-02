/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : office_management.js
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var initLoad = true;

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends
	 * @class office_management : office_management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ADM_SYS_0012() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}


	/* 개발자 작업	*/
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 *****/
		var shtObj = sheetObjects[0];
		/*******************************************************/
		var frmObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_save":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
					break;

				case "btn_close":
					window.close();
					break;

				case "btn_downexcel":
					doActionIBSheet(shtObj, frmObj, IBDOWNEXCEL);
					break;

				case "map_ofc_chk":    // Show Mapped Office Only 체크박스
					with (shtObj) {
						ReDraw = false;
						if (frmObj.map_ofc_chk.checked) {
							for (var i=HeaderRows; i<=LastRow; i++) {
								if (CellValue(i, "check_val") == 0) RowHidden(i) = true;
							}
						} else {
							//모든 항목 출력
							for (var i=HeaderRows; i<=LastRow; i++) {
								RowHidden(i) = false;
							}
						}
						ReDraw = true;
					}
					break;

				case "ofc_tp_chk":    // Office Type 체크박스
					chkbox_ofc();
					break;

			}    // end switch
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for (i=0;i<sheetObjects.length;i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();

		// ※※※ sheet1_OnLoadFinish 메서드 반드시 참조 ※※※
	}


	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		sheetObj.WaitImageVisible = false;

		switch(sheetNo) {
			case 1:      //IBSheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 260 ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				var HeadTitle = "|AS-IS|TO-BE||Office|Office Name|Office Type|Office Type|Location";
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false) ;
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				//데이터속성    [ ROW, COL,   DATATYPE,    		WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,       	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 80,     daCenter,    false,    "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox	,   60,     daCenter,    false,    "check_val_read",	false,    "",    	dfNone,    		0,    	false,    false);
				InitDataProperty(0, cnt++ , dtCheckBox,     60,     daCenter,    false,    "check_val",			false,    "",    	dfNone,    		0,    	true,     false);
				InitDataProperty(0, cnt++ , dtHidden,       80,     daCenter,    false,    "level",             false,    "",    	dfNone,    		0,    	false,    true);
				InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,    "ofc_cd",            false,    "",    	dfNone,    		0,    	false,    false);
				InitDataProperty(0, cnt++ , dtData,         200,    daLeft,      false,    "ofc_eng_nm",        false,    "",    	dfNone,    		0,    	false,    false);
				InitDataProperty(0, cnt++ , dtHidden,       80,    	daCenter,    false,    "ofc_tp_cd",         false,    "",    	dfNone,    		0,    	false,    false);
				InitDataProperty(0, cnt++ , dtData,         120,    daCenter,    false,    "ofc_tp_nm",         false,    "",    	dfNone,    		0,    	false,    false);
				InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    false,    "ar_ofc_cd",         false,    "",    	dfNone,    		0,    	false,    false);

				CountPosition = 0;
				WaitImageVisible = false;

				InitTreeInfo(2, "level");

			}
			break;
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction) {
		shtObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ADM_SYS_0012GS.do", FormQueryString(frmObj));
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
					shtObj.DoSave("ADM_SYS_0012GS.do", FormQueryString(frmObj), -1, false);
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:	//엑셀다운로드
				shtObj.Down2Excel(1);
				break;
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		axon_event.addListener("change", "frmObj_OnChange", "ofc_tp");    // OnChange 이벤트 - CoJobcodemanagement.js에 정의
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
	 * @param {ErrMsg} String : 에러가 발생했을 경우에 서버에서 리턴되는 메시지
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// 저장 후  부모창 재조회
		var opener = window.dialogArguments;    // MODAL창에서 부모창 호출
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		window.close();
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var elementName = window.event.srcElement.getAttribute("name");
		var shtObj = sheetObjects[0];
		with (document.form) {
			switch (elementName) {

				case "ofc_tp":
					chkbox_ofc();
					break;
			}
		}
	}


	/**
	 * Show Mapped Office only / Office Type 체크박스에 따른 Sheet내용 숨김 또는 보임
	 */
	function chkbox_ofc() {
		var frmObj = document.form;
		var shtObj = sheetObjects[0];

		with (shtObj) {
			ReDraw = false;
			if (frmObj.map_ofc_chk.checked) {
				if (frmObj.ofc_tp_chk.checked && frmObj.ofc_tp.value != "") {
					for (var i=HeaderRows; i<=LastRow; i++) {
						if (CellValue(i, "check_val") == 1 || CellValue(i, "ofc_tp_cd") == frmObj.ofc_tp.value) {
							RowHidden(i) = false;
						} else {
							RowHidden(i) = true;
						}
					}
				} else {
					for (var i=HeaderRows; i<=LastRow; i++) {
						if (CellValue(i, "check_val") == 1) {
							RowHidden(i) = false;
						} else {
							RowHidden(i) = true;
						}
					}
				}
			} else {
				if (frmObj.ofc_tp_chk.checked && frmObj.ofc_tp.value != "") {
					for (var i=HeaderRows; i<=LastRow; i++) {
						if (CellValue(i, "ofc_tp_cd") == frmObj.ofc_tp.value) {
							RowHidden(i) = false;
						} else {
							RowHidden(i) = true;
						}
					}
				} else {
					for (var i=HeaderRows; i<=LastRow; i++) {
						RowHidden(i) = false;
					}
				}
			}
			ReDraw = true;
		}
	}


/* 개발자 작업  끝 */
