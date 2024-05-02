/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : ESM_ACM_0040.js
 * @FileTitle : Group Customer Inquiry.
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.23 김상현 1.0 Creation.
 */

	/**
	 * @extends
	 * @class ESM_ACM_0040 : ESM_ACM_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_0040() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
	function processButtonClick() {
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
			case "btn_retrieve" :
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_ok" :
				buttonOkClick(sheetObjects[0]);
				break;
			case "btn_close":
				window.close();
				break;
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * IBSheet Object를 배열로 등록
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch (sheetID) {
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 260;

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") {
					InitHostInfo(location.hostname, location.port, page_path);
				}

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)

				var HeadTitle = "Group Customer Code|Group Customer Name|Office|Sales Rep Code";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성     [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,   cnt++, dtData,      120,   daCenter,  true,     "cust_grp_id",      false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0,   cnt++, dtData,      250,   daCenter,  true,     "cust_grp_nm",      false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0,   cnt++, dtData,      80,    daCenter,  true,     "ofc_cd",           false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0,   cnt++, dtData,      60,    daCenter,  true,     "srep_cd",          false,    "",         dfNone,     0,          false,      false);

				WaitImageVisible = false;
			}
			break;
		}
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다.
	 */
	function initControl() {
		// Axon 이벤트 처리1. event catch
		axon_event.addListenerForm("blur", "obj_blur", form); 	        // form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat("keypress", "obj_keypress", form); // form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		axon_event.addListener("keydown", "ComKeyEnter", "form");
	}

	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다.
	 */ 
	function obj_blur() {
		if (event.srcElement.name == "cust_seq") {
			if (!ComIsNull(event.srcElement) && ComGetLenByByte(event.srcElement) < 6) {
				event.srcElement.value = ComLpad(event.srcElement, 6, "0");
				return;
			}
		} 
	}

	/**
	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.
	 */ 
	function obj_keypress() {
		switch(event.srcElement.dataformat) {
			case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "eng":
		        //영문만입력하기
	            ComKeyOnlyAlphabet("uppernum");
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		}
	}

	/**
     * Sheet관련 프로세스 처리
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch (sAction) {
		case IBSEARCH : // 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch("ESM_ACM_0040GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;
		}
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj, formObj, sAction) {
		return true;
	}

	/**
     * OnDbClick 이벤트 발생시 호출되는 function
     */ 
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		buttonOkClick(sheetObj)
	}

	/**
     * OK button Click 이벤트 발생시 호출되는 function
     */
	function buttonOkClick(sheetObj) {
		var rArray = new Array();
		var Row = sheetObj.SelectRow;

		if (Row < 1) {
			ComShowCodeMessage(ComGetMsg("COM12113", "Row"));
			return;
		}

		rArray[0] = sheetObj.CellValue(Row, "cust_grp_id");
		rArray[1] = sheetObj.CellValue(Row, "cust_grp_nm");

		eval("window.dialogArguments." + sFunc + "(rArray, iRow, iCol, iSheetIdx)");
	    self.close();
	}
