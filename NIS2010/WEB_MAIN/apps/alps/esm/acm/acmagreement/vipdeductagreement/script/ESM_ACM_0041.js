/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : ESM_ACM_0041.js
 * @FileTitle : Container Type/Size
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.24 김상현 1.0 Creation.
 */

	/**
	 * @extends
	 * @class ESM_ACM_0041 : ESM_ACM_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_0041() {
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
				style.height = 100;

				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;

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

				var HeadTitle = "CHK|Group Name|Detail";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성     [ROW, COL,   DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,   cnt++, dtRadioCheck, 40,    daCenter,  false,    "chk");
                InitDataProperty(0,   cnt++, dtData,       120,   daCenter,  false,    "cntr_tpsz_grp_nm", false,    "",         dfNone,     0,          false);
                InitDataProperty(0,   cnt++, dtData,       500,   daLeft,    false,    "cntr_tpsz_cd",     false,    "",         dfNone,     0,          false);

				WaitImageVisible = false;
			}
			break;
		case "sheet2" :
			with (sheetObj) {
				// 높이 설정
				style.height = 200;
	
				// 전체 너비 설정
				SheetWidth = mainTable2.clientWidth;
	
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
	
				var HeadTitle = "CHK|Type/Size|Desc.";
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성     [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,   cnt++, dtCheckBox,  70,    daCenter,  false,    "chk");
				InitDataProperty(0,   cnt++, dtData,      150,   daCenter,  false,    "cntr_tpsz_cd",     false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0,   cnt++, dtData,      250,   daCenter,  false,    "cntr_tpsz_desc",   false,    "",         dfNone,     0,          false,      false);
	
				WaitImageVisible = false;
			}
			break;
		}
	}

	/**
	 * Sheet1 loading 종료 event
	 */
    function sheet1_OnLoadFinish(shtObj) {
        doActionIBSheet(shtObj, document.form, IBSEARCH);

        ACMCellEditable(sheetObjects[0], "chk", "cntr_tpsz_cd", true);
        ACMCellEditable(sheetObjects[1], "chk", "cntr_tpsz_desc", true);
        sheetObjects[1].DataBackColor = sheetObjects[1].EditableColor;
        shtObj.DataBackColor = shtObj.UnEditableColor;
    }

    /**
     * Sheet1 data 변경 event 처리
     */
	function sheet1_OnChange(shtObj, Row, Col, Value) {
		switch (shtObj.ColSaveName(Col)) {
		case "chk" :
			var cntrTpszCdStr = shtObj.CellValue(Row, "cntr_tpsz_cd");
			var tmpArr = cntrTpszCdStr.split(",");
			sheetObjects[1].CheckAll("chk") = 0;
			for (var i=0; i<tmpArr.length; i++) {
				var findRowIdx = sheetObjects[1].FindText("cntr_tpsz_cd", tmpArr[i]);
				if (findRowIdx > -1) {
					sheetObjects[1].CellValue(findRowIdx, "chk") = 1;
				}
			}
			break;
		}
	}

	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 */
	function sheet2_OnSearchEnd(shtObj) {
		var slctTpSz = document.form.slct_tpsz.value;

		if (slctTpSz != "") {
			var tmpArr = slctTpSz.split(",");
			shtObj.CheckAll("chk") = 0;
			for (var i=0; i<tmpArr.length; i++) {
				var findRowIdx = shtObj.FindText("cntr_tpsz_cd", tmpArr[i]);
				if (findRowIdx > -1) {
					shtObj.CellValue(findRowIdx, "chk") = 1;
				}
			}
		}
	}

	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event
	 */
	function sheet2_OnChange(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
			case "chk" :
				var chkRowArr = shtObj.FindCheckedRow(Col).split("|");
				var slctTpSz = document.form.slct_tpsz;
				if (chkRowArr.length > 1) {
					// 선택된 row의 Container TP/SZ Code를 textarea에 setting
					var tempArray = new Array();
					for (var i=0; i<chkRowArr.length-1; i++) {
						tempArray[tempArray.length] = shtObj.CellValue(chkRowArr[i], "cntr_tpsz_cd");
					}
					slctTpSz.value = tempArray.toString();
				} else {
					slctTpSz.value = "";
				}
				break;
            }
        }
    }

	/**
     * Sheet관련 프로세스 처리
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch (sAction) {
		case IBSEARCH : // 조회
			var xmlStr = sheetObj.GetSearchXml("ESM_ACM_0102GS.do", "f_cmd=" + SEARCH).split("|$$|");
            sheetObjects[0].LoadSearchXml(xmlStr[0]); // User Set List
            sheetObjects[1].LoadSearchXml(xmlStr[1]); // Container TP/SZ Code
			break;
		}
	}

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_clear" : // clear
			ComResetAll();
			document.form.slct_tpsz.value = "";
			doActionIBSheet(shtObj, document.form, IBSEARCH);
			break;
		case "btn_select" : // select
			var rArray = new Array();

			if (sheetObjects[1].CheckedRows("chk") < 1) {
				ComShowCodeMessage("COM12113", "[Container TP/SZ Code]"); // Please select {?msg1}
				return;
			}
			rArray[0] = document.form.slct_tpsz.value;
			eval("window.dialogArguments." + sFunc + "(rArray, iRow, iCol, iSheetIdx)"); // JSP에서 request.getParameter로 받은 param
			window.close();
			break;
		case "btn_close" : // close
			window.close();
			break;
		}
    }
