/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : ESM_ACM_0039.js
 * @FileTitle : VIP Agreement Creation
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.18 김상현 1.0 Creation.
 * 2016.07.27 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청
 *  - IBSheet 수정
 */

	/**
	 * @class ESM_ACM_0039 : ESM_ACM_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_ACM_0039() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var currentRow = 0;

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * Page 검색 조건에 값 setting.
	 */
	function setPagePopupData(aryPopupData, Row, Col, ShtIdx) {
		switch (ShtIdx) {
		case "0" :
			document.form.p_cust_grp_id.value = aryPopupData[0];
			break;
		case "1" :
			document.form.p_cntr_tpsz_grp_nm.value = aryPopupData[0];
			break;
		}
	}

	/**
	 * Button event 처리
	 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve" :
			doActionIBSheet(shtObj, frmObj, IBSEARCH);
			break;
		case "btn_save" :
			doActionIBSheet(shtObj, frmObj, IBSAVE);
			break;
		case "btn_downexcel" :
			ComOpenWait(true);
			shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "ibflag|check");
			ComOpenWait(false);
			break;
		case "btn_copy" :
			var newRow = shtObj.DataCopy();
			break;
		case "btn_add" :
			var newRow = shtObj.DataInsert();
			shtObj.CellValue2(newRow, "por_rout_cd") = "*";
			shtObj.CellValue2(newRow, "pol_rout_cd") = "*";
			shtObj.CellValue2(newRow, "pod_rout_cd") = "*";
			shtObj.CellValue2(newRow, "del_rout_cd") = "*";
			shtObj.CellValue2(newRow, "sc_no") = "*";
			shtObj.CellValue2(newRow, "rfa_no") = "*";
			shtObj.CellValue2(newRow, "taa_no") = "*";
			doActionIBSheet(shtObj, frmObj, IBINSERT, newRow);
			break;
		case "btn_popup_cust" :
			ComOpenPopup("ESM_ACM_0040.do", 650, 500, "setPagePopupData", "1,0,1,1,1,1,1", true, false, 1, 1, 0);
			break;
		case "btn_popup_type" :
			ComOpenPopup("ESM_ACM_0041.do?cntr_tpsz_cd=" + document.form.p_cntr_tpsz_grp_nm.value, 742, 600, "setPagePopupData", "1,0,1,1,1,1,1", true, false, 1, 1, 1);
			break;
        }
    }

	function setEQType(aryPopupData) {
		document.form.p_cntr_tpsz_grp_nm.value = aryPopupData[0];
	}

	/**
	 * Script function 초기화 처리
	 */
    function loadPage() {
    	// Sheet 초기화
    	for (var i=0; i<sheetObjects.length; i++) {
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i], i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	initControl();
    }

	/**
	 * Sheet 초기화.
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {
			case "sheet1" :
				var cnt = 0;

				// 높이 설정
				style.height = 389;

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
				InitRowInfo(1, 1, 13, 500);
				document.form.pagerows.value = 500;

				// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(true, false, true, true, false, false);

				// 컬럼 헤더타이틀
				var HeadTitle0 = "DEL|STS|SEQ|G.Customer Code|Customer Name||Trade|Tradebound||Haulbound|Sub Trade||POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|Rate|Rate|Rate|SC No.|RFA No.|TAA No.|Eff.Date|Exp.Date";

				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle0), 5, 0, true);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				// Enter키를 눌렀을때 Tab키처럼 작동
				EditEnterBehavior = "tab";

				// 데이터속성     [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME,                KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,   cnt++, dtDelCheck,  40,    daCenter,  true,     "check");
				InitDataProperty(0,   cnt++, dtStatus,    30,    daCenter,  true,     "ibflag");
				InitDataProperty(0,   cnt++, dtSeq,       30,    daCenter,  true,     "seq");
				InitDataProperty(0,   cnt++, dtPopup,     120,   daCenter,  true,     "cust_grp_id",           false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0,   cnt++, dtData,      120,   daCenter,  true,     "cust_grp_nm",           false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0,   cnt++, dtHidden,    0,     daCenter,  true,     "agmt_seq",              false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0,   cnt++, dtCombo,     70,    daCenter,  true,     "trd_cd",                false,    "",         dfNone,     0,          true,       true,       3);
				InitDataProperty(0,   cnt++, dtCombo,     70,    daCenter,  true,     "dir_cd_view",           false,    "",         dfNone,     0,          true,       true,       1);
				InitDataProperty(0,   cnt++, dtHidden,    0,     daCenter,  true,     "dir_cd",                false,    "",         dfNone,     0,          true,       true,       1);
				InitDataProperty(0,   cnt++, dtCombo,     70,    daCenter,  true,     "hul_bnd_cd",            false,    "",         dfNone,     0,          true,       true,       2);
				InitDataProperty(0,   cnt++, dtCombo,     70,    daCenter,  true,     "sub_trd_cd_view",       false,    "",         dfNone,     0,          true,       true,       2);
				InitDataProperty(0,   cnt++, dtHidden,    0,     daCenter,  true,     "sub_trd_cd",            false,    "",         dfNone,     0,          true,       true,       2);
				InitDataProperty(0,   cnt++, dtCombo,     90,    daCenter,  true,     "por_grp_tp_cd",         false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0,   cnt++, dtPopupEdit, 70,    daCenter,  true,     "por_rout_cd",           false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtCombo,     90,    daCenter,  true,     "pol_grp_tp_cd",         false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0,   cnt++, dtPopupEdit, 70,    daCenter,  true,     "pol_rout_cd",           false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtCombo,     90,    daCenter,  true,     "pod_grp_tp_cd",         false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0,   cnt++, dtPopupEdit, 70,    daCenter,  true,     "pod_rout_cd",           false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtCombo,     90,    daCenter,  true,     "del_grp_tp_cd",         false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0,   cnt++, dtPopupEdit, 70,    daCenter,  true,     "del_rout_cd",           false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtPopupEdit, 60,    daCenter,  true,     "cntr_tpsz_grp_nm_view", false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtHidden,    0,     daCenter,  true,     "cntr_tpsz_grp_nm",      false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtData,      70,    daCenter,  true,     "vip_bkg_rt",            false,    "",         dfNone,     0,          true,       true,       5);
				InitDataProperty(0,   cnt++, dtPopupEdit, 100,   daCenter,  true,     "sc_no",                 false,    "",         dfNone,     0,          true,       true,       20);
				InitDataProperty(0,   cnt++, dtPopupEdit, 100,   daCenter,  true,     "rfa_no",                false,    "",         dfNone,     0,          true,       true,       11);
				InitDataProperty(0,   cnt++, dtPopupEdit, 100,   daCenter,  true,     "taa_no",                false,    "",         dfNone,     0,          true,       true,       10);
				InitDataProperty(0,   cnt++, dtData,      90,    daCenter,  true,     "fm_eff_dt",             false,    "",         dfDateYmd,  0,          true,       true);
				InitDataProperty(0,   cnt++, dtData,      90,    daCenter,  true,     "to_eff_dt",             false,    "",         dfDateYmd,  0,          true,       true);

				// Sheet내 combo 설정
				InitDataCombo(0, "trd_cd", trdCdStr, trdCdStr, "");       // Trade Code setting.
				InitDataCombo(0, "dir_cd", "*", "*", "");                 // Tradebound Code setting.
				InitDataCombo(0, "hul_bnd_cd", "*|BH|HH", "*|BH|HH", ""); // Haulbound Code setting.
				InitDataCombo(0, "sub_trd_cd", "*", "*", "");             // Subtrade code setting.
				InitDataCombo(0, "por_grp_tp_cd", proTpText, proTpCode, "");
				InitDataCombo(0, "pol_grp_tp_cd", proTpText, proTpCode, "");
				InitDataCombo(0, "pod_grp_tp_cd", proTpText, proTpCode, "");
				InitDataCombo(0, "del_grp_tp_cd", proTpText, proTpCode, "");


				// Validation 체크
				InitDataValid(0, "por_rout_cd", vtEngUpOther, "0123456789*"); // 영대문자, 숫자, *만 입력되도록 설정
				InitDataValid(0, "pol_rout_cd", vtEngUpOther, "0123456789*"); // 영대문자, 숫자, *만 입력되도록 설정
				InitDataValid(0, "pod_rout_cd", vtEngUpOther, "0123456789*"); // 영대문자, 숫자, *만 입력되도록 설정
				InitDataValid(0, "del_rout_cd", vtEngUpOther, "0123456789*"); // 영대문자, 숫자, *만 입력되도록 설정
				InitDataValid(0, "sc_no", vtEngUpOther, "0123456789*");       // 영대문자, 숫자, *만 입력되도록 설정
				InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789*");      // 영대문자, 숫자, *만 입력되도록 설정
				InitDataValid(0, "taa_no", vtEngUpOther, "0123456789*");      // 영대문자, 숫자, *만 입력되도록 설정

				ShowButtonImage = 3; // Edit 가능할때 콤보와 팝업 이미지 표시
				WaitImageVisible = false;

				break;
            }
        }
    }

	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 */
	function sheet1_OnLoadFinish(shtObj) {
		// 조회조건의 Office Select Object 생성
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}

	function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		for (var i=1; i<=shtObj.RowCount; i++) {
			var dirCd = shtObj.CellValue(i, "dir_cd");
			var subTrdCd = shtObj.CellValue(i, "sub_trd_cd");
			var cntrTpszGrpNm = shtObj.CellValue(i, "cntr_tpsz_grp_nm");

			setTradeBound(shtObj, i, shtObj.CellValue(i, "trd_cd"));
			if (dirCd == "") {
				dirCd = "*";
			}
			shtObj.CellValue2(i, "dir_cd_view") = dirCd;

			setSubTrade(shtObj, i, shtObj.CellValue(i, "trd_cd"));
			if (subTrdCd == "") {
				subTrdCd = "*";
			}
			shtObj.CellValue2(i, "sub_trd_cd_view") = subTrdCd;

			if (cntrTpszGrpNm != "") {
				cntrTpszGrpNm = cntrTpszGrpNm.substr(0, cntrTpszGrpNm.length - 1);
				var tempArr = cntrTpszGrpNm.split(",");
				if (tempArr[0].substr(1, 1) === "2") {
					shtObj.CellValue(i, "cntr_tpsz_grp_nm_view") = "20";
				} else {
					shtObj.CellValue(i, "cntr_tpsz_grp_nm_view") = "40";
				}
				shtObj.CellValue(i, "cntr_tpsz_grp_nm") = cntrTpszGrpNm;
			} else {
				shtObj.CellValue(i, "cntr_tpsz_grp_nm_view") = "";
				shtObj.CellValue(i, "cntr_tpsz_grp_nm") = "";
			}

			shtObj.RowStatus(i) = "R";
		}
	}

	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.
		doActionIBSheet(shtObj, document.form, IBSEARCH);   // 저장 후 재조회
	}

	/**
	 * Trade code 변경시 trade bound 항목 변경
	 */
	function setTradeBound(sheetObj, row, trdCd) {
		var dirCd = "*|E|W|S|N";
		var dirText = "*|" + trdCd + "E|" + trdCd + "W|" + trdCd + "S|" + trdCd + "N";
		sheetObj.CellComboItem(row, "dir_cd_view", dirText, dirCd);
	}

	/**
	 * Trade code 변경시 sub trade 항목 변경
	 */
	function setSubTrade(sheetObj, row, trdCd) {
		var xmlStr = sheetObj.GetSearchXml("ESM_ACM_0039GS.do", "f_cmd=" + SEARCH01 + "&trd_cd=" + trdCd);
		var subTrdCdStr = "*|" + ComGetEtcData(xmlStr, "subTrdCdStr");
		sheetObj.CellComboItem(row, "sub_trd_cd_view", subTrdCdStr, subTrdCdStr);
	}

	/**
	 * Grid 입력값에 대한 OnChange Event 처리
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (Value == "") return;

		with(sheetObj) {
	        switch (ColSaveName(Col)) {
	        case "trd_cd" :
	        	if (Value != "*") {
		        	setTradeBound(sheetObj, Row, Value);
		        	setSubTrade(sheetObj, Row, Value);
	        	} else {
	        		CellComboItem(Row, "dir_cd_view", "*", "*");
	        		CellComboItem(Row, "sub_trd_cd_view", "*", "*");
	        	}
        		CellValue2(Row, "dir_cd") = "*";
        		CellValue2(Row, "sub_trd_cd") = "*";
	        	break;
	        case "dir_cd_view" :
	        	CellValue(Row, "dir_cd") = CellValue(Row, "dir_cd_view");
	        	break;
	        case "sub_trd_cd_view" :
	        	CellValue(Row, "sub_trd_cd") = CellValue(Row, "sub_trd_cd_view");
	        	break;
	        case "por_grp_tp_cd" :
	        case "pol_grp_tp_cd" :
	        case "pod_grp_tp_cd" :
	        case "del_grp_tp_cd" :
	        	if (Value == 5) {
	        		CellValue2(Row, (parseInt(Col) + 1)) = "";
	        	} else {
	        		CellValue2(Row, (parseInt(Col) + 1)) = "*";
	        	}
                break;
	        case "fm_eff_dt" :
	        case "to_eff_dt" :
	        	if (CellValue(Row, "fm_eff_dt") != "" && CellValue(Row, "to_eff_dt") != "") {
		        	if (CellValue(Row, "fm_eff_dt") > CellValue(Row, "to_eff_dt")) {
		        		ComShowCodeMessage("ACM00017", "Eff. Date", "Exp. Date");
		        		SelectCell(Row, Col, true, "");
		        	}
	        	}
	        	break;
	        case "sc_no" :
	        	if (Value != "" && Value != "*") {
	        		CellValue2(Row, "rfa_no") = "*";
	        		CellValue2(Row, "taa_no") = "*";
	        	}
	        	break;
	        case "rfa_no" :
	        	if (Value != "" && Value != "*") {
	        		CellValue2(Row, "sc_no") = "*";
	        		CellValue2(Row, "taa_no") = "*";
	        	}
	        	break;
	        case "taa_no" :
	        	if (Value != "" && Value != "*") {
	        		CellValue2(Row, "sc_no") = "*";
	        		CellValue2(Row, "rfa_no") = "*";
	        	}
	        	break;
	        }
		}
	}

	/**
	 * Pop-Up Return Value 처리 부분
	 * @param aryPopupData[0] : {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
	 * @param ShtIdx : 대상IBSheet의 Sheet Array index
	 */
	function setPopupData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
			with (sheetObjects[ShtIdx]) {
				switch (ColSaveName(Col)) {
				case "cust_grp_id" :
					CellValue(Row, Col) = aryPopupData[0];
					CellValue(Row, "cust_grp_nm") = aryPopupData[1];
					break;
				case "cntr_tpsz_grp_nm_view" :
					var tempArr = aryPopupData[0].split(",");
					CellValue(Row, Col) = tempArr.length;
					CellValue(Row, "cntr_tpsz_grp_nm") = aryPopupData[0];
					break;
				case "por_rout_cd" :
				case "pol_rout_cd" :
				case "pod_rout_cd" :
				case "del_rout_cd" :
					CellValue(Row, Col) = aryPopupData[0][3];
					break;
				}
			}
		}
	}

	var selectedRow = 0;
	var selectedCol = 0;

	/**
	 * Pop-Up Return Value 처리 부분
	 */
	function setPopupDataNo(rowArray) {
		var colArray = rowArray[0];
		sheetObjects[0].CellValue(selectedRow, selectedCol) = colArray[5];
	}

	/**
	 * Grid에서 OnPopupClick Event 처리
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var saveNm = sheetObj.ColSaveName(Col);
		var func = "setPopupData";
		var width = 775;
		var height = 482;

		switch (saveNm) {
		case "cust_grp_id" :
			ComOpenPopup("ESM_ACM_0040.do", 650, 500, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
			break;
		case "cntr_tpsz_grp_nm_view" :
			ComOpenPopup("ESM_ACM_0041.do?cntr_tpsz_cd=" + sheetObj.CellValue(Row, "cntr_tpsz_grp_nm"), 742, 600, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
			break;
		case "por_rout_cd" :
		case "pol_rout_cd" :
		case "pod_rout_cd" :
		case "del_rout_cd" :
			var grp_tp = sheetObj.CellValue(Row, parseInt(Col) - 1);
			var display = "1,0,1,1,1,1,1";
			var url = "";
		
			if (grp_tp == "1") {
				width = 306;
				height = 382;
				url = "COM_ENS_0H1.do";
			} else if (grp_tp == "2") {
				width = 406;
				height = 382;
				url = "COM_ENS_0I1.do";
			} else if (grp_tp == "3" ) {
				width = 566;
				height = 484;
				url = "COM_ENS_0M1.do";
			} else if (grp_tp == "4") {
				width = 526;
				height = 454;
				url = "COM_ENS_0J1.do";
			} else if (grp_tp == "5") {
				width = 775;
				height = 482;
				url = "COM_ENS_051.do";
			} else {
				if (saveNm == "por_rout_cd") {
					ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
				} else if (saveNm == "pol_rout_cd") {
					ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
				} else if (saveNm == "pod_rout_cd") {
					ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
				} else if (saveNm == "del_rout_cd") {
					ComShowMessage(ComGetMsg("COM12113", "DEL TYPE", "", ""));
				}
				sheetObj.SelectCell(Row, parseInt(Col) - 1);
		
				return false;
			}
		
			ComOpenPopup(url, width, height, func, display, true, false, Row, Col, 0);
			break;
		case "sc_no" :
            var funcNo = "setPopupDataNo";
        	selectedRow = Row;
        	selectedCol = Col;
            var url = "ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no=&bkg_vvd=&por_cd=&del_cd=&s_cust_cnt_cd=&s_cust_seq=&c_cust_cnt_cd=&c_cust_seq=&func=" + funcNo;
            ComOpenPopup(url, 860, 475, funcNo, "1,0,1,1,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
			break;
		case "rfa_no" :
            var funcNo = "setPopupDataNo";
        	selectedRow = Row;
        	selectedCol = Col;
            var url = "ESM_BKG_0654.do?pgmNo=ESM_BKG_0655&bkg_no=&bkg_vvd=&por_cd=&del_cd=&s_cust_cnt_cd=&s_cust_seq=&c_cust_cnt_cd=&c_cust_seq=&func=" + funcNo;
            ComOpenPopup(url, 860, 475, funcNo, "1,0,1,1,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
			break;
		case "taa_no" :
            var funcNo = "setPopupDataNo";
        	selectedRow = Row;
        	selectedCol = Col;
            var url = "ESM_BKG_1062.do?pgmNo=ESM_BKG_0655&bkg_no=&bkg_vvd=&por_cd=&del_cd=&s_cust_cnt_cd=&s_cust_seq=&c_cust_cnt_cd=&c_cust_seq=&func=" + funcNo;
            ComOpenPopup(url, 860, 475, funcNo, "1,0,1,1,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
            break;
		}
	}

	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		// 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트(키입력) - CoAcm.js에 정의
		axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
		axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
		axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
		// OnChange 이벤트
		// axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
	}

	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
		case IBSEARCH : // Retrieve
			ComOpenWait(true);
			frmObj.f_cmd.value = SEARCHLIST;
			shtObj.DoSearch("ESM_ACM_0039GS.do?cust_grp_id=" + frmObj.p_cust_grp_id.value + "&cntr_tpsz_grp_nm=" + frmObj.p_cntr_tpsz_grp_nm.value, FormQueryString(frmObj));
			ComOpenWait(false);
			break;
		case IBSAVE : // 저장
			ComOpenWait(true);
			frmObj.f_cmd.value = MULTI;
			shtObj.DoSave("ESM_ACM_0039GS.do", FormQueryString(frmObj));
			ComOpenWait(false);
			break;
		case IBINSERT : // 입력
			addRowData(CondParam);//(newRow, cntCd)
			break;
        }
    }

	/**
	 * 저장 버튼 클릭시 유효성검증 프로세스 처리
	 */
	function sheet1_OnValidation(sheetObj, Row, Col, Value) {
		var f_cmd = document.form.f_cmd.value;
		var val = ComTrim(Value);
		var subValue = "";

		if (f_cmd == MULTI) { // 저장시에만 체크한다.
			with (sheetObj) {
				var saveNm = ColSaveName(Col);
				var ibStatus = RowStatus(Row);

				if (ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U") {
					switch (saveNm) {
					case "cust_grp_id" :
						if (CellValue(Row, Col) == "") {
							ComShowMessage(ComGetMsg("COM130403", "G.Customer Code"));
							ValidateFail = true;
						}
						break;
					case "cntr_tpsz_grp_nm" :
						if (CellValue(Row, Col) == "") {
							ComShowMessage(ComGetMsg("COM130403", "Type/Size"));
							ValidateFail = true;
						}
						break;
					case "fm_eff_dt" :
						if (CellValue(Row, Col) == "") {
							ComShowMessage(ComGetMsg("COM130403", "Eff.Date"));
							ValidateFail = true;
						}
						break;
					case "to_eff_dt" :
						if (CellValue(Row, Col) == "") {
							ComShowMessage(ComGetMsg("COM130403", "Exp.Date"));
							ValidateFail = true;
						}
						break;
					case "por_grp_tp_cd" :
					case "pol_grp_tp_cd" :
					case "pod_grp_tp_cd" :
					case "del_grp_tp_cd" :
						if (val.length > 0 && val != "*") {
							subValue = ComTrim(CellValue(Row, Col + 1));
							if (subValue == "" || subValue == "*") {
								if (saveNm == "por_grp_tp_cd") {
									ComShowMessage(ComGetMsg("COM130201", "POR", "", ""));
								} else if (saveNm == "pol_grp_tp_cd") {
									ComShowMessage(ComGetMsg("COM130201", "POL", "", ""));
								} else if (saveNm == "pod_grp_tp_cd") {
									ComShowMessage(ComGetMsg("COM130201", "POD", "", ""));
								} else if (saveNm == "del_grp_tp_cd") {
									ComShowMessage(ComGetMsg("COM130201", "DEL", "", ""));
								}
								ValidateFail = true;
								SelectCell(Row, Col + 1);
							} else {
								if (saveNm == "por_grp_tp_cd" || saveNm == "pol_grp_tp_cd" || saveNm == "pod_grp_tp_cd" || saveNm == "del_grp_tp_cd") {
									if (checkSubLength(sheetObj, Row, Col, val) == false) {
										ValidateFail = true;
										SelectCell(Row, Col + 1);
									}
								}
							}
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 행추가
	 */
	function addRowData(newRow) {
		var sheetObj = sheetObjects[0];
		var nowDate = new Date();
		var nowDateStr = nowDate.getFullYear() + "-" + (nowDate.getMonth() + 1) + "-" + nowDate.getDate();
		sheetObj.CellValue2(newRow, "fm_eff_dt") = nowDateStr;
		sheetObj.CellValue2(newRow, "to_eff_dt") = "2999-12-31";
		sheetObj.CellValue2(newRow, "vip_bkg_rt") = 0;
	}

	/**
	 * 입력 길이 체크
	 */
	function checkSubLength(sheetObj, Row, Col, Value) {
		with(sheetObj) {
			Value = ComTrim(Value);
			var saveNm = ColSaveName(Col);
			var subValue = ComTrim(CellValue(Row, Col + 1));

			switch (Value) {
			case "1" :
				if (subValue.length > 1) {
					if (saveNm == "por_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POR", "1", ""));
					} else if (saveNm == "pol_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POL", "1", ""));
					} else if (saveNm == "pod_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POD", "1", ""));
					} else if(saveNm == "del_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "DEL", "1", ""));
					}
					return false;
				}
				break;
			case "2" :
			case "3" :
				if (subValue.length > 2) {
					if (saveNm == "por_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POR", "2", ""));
					} else if (saveNm == "pol_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POL", "2", ""));
					} else if(saveNm == "pod_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POD", "2", ""));
					} else if(saveNm == "del_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "DEL", "2", ""));
					}
					return false;
				}
				break;
			case "4" :
				if (subValue.length > 3) {
					if (saveNm == "por_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POR", "3", ""));
					} else if (saveNm == "pol_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POL", "3", ""));
					} else if (saveNm == "pod_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POD", "3", ""));
					} else if (saveNm == "del_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "DEL", "3", ""));
					}
					return false;
				}
				break;
			case "5" :
				if (subValue.length > 5) {
					if (saveNm == "por_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POR", "5", ""));
					} else if (saveNm == "pol_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POL", "5", ""));
					} else if (saveNm == "pod_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "POD", "5", ""));
					} else if (saveNm == "del_grp_tp_cd") {
						ComShowMessage(ComGetMsg("COM12173", "DEL", "5", ""));
					}
					return false;
				}
				break;
			}
		}

		return true;
    }
