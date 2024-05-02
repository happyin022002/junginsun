/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0437.js
 * @FileTitle : Correction History Inquiry
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.03.03
 * @LastModifier : 두기민
 * @LastVersion : 1.0
 * 2016.03.03 두기민 1.0 Creation.
 * 2016.09.19 김상현 Script 오류 수정.
 *  - Container No. 없이 전송되는 경우 발생.
 */
/**
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 */

    // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/**
	 * @extends
	 * @class EES_CTM_0437 : EES_CTM_0437 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_ctm_0437() {
		this.processButtonClick    = tprocessButtonClick;
		this.setSheetObject        = setSheetObject;
		this.loadPage              = loadPage;
		this.initSheet             = initSheet;
		this.doActionIBSheet       = doActionIBSheet;
		this.validateForm          = validateForm;
	}

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	function processButtonClick() {
		var sheetObj = sheetObjects[0];
		var frmObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
			case "btn_Calendar" :
				var cal = new ComCalendarFromTo();
				cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
				break;
			case "btn_retrieve" :
				doActionIBSheet(sheetObj, frmObj, IBSEARCH);
				break;
			case "btn_new" :
				ComResetAll();
				// 팝업으로 호출시 Request로 넘어온 기본 value 다시 Clear.
				frmObj.cntrno_disp.style.background = "#CCFFFF";
				frmObj.cntrno_disp.disabled = false;
				frmObj.cntrno_disp.value = "";
				frmObj.check_digit.value = "";
				frmObj.ctnr_tpsz_cd.value = "";
				frmObj.p_date1.value = frmObj.temp_date1.value;
				frmObj.p_date2.value = frmObj.temp_date2.value;
				multi = "N";
				frmObj.cntrno_disp.focus();
				break;
			case "btn_downexcel" :
				ComOpenWait(true);
				sheetObj.Down2Excel(0, false, false, true, "", "", false, false, "", false, "atch_file_sav_id");
				ComOpenWait(false);
				break;
			case "btn_close":
				window.close();
				break;
			}
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
		for (i=0; i<sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		// CTM-COMMON (& 예외처리)
		setEventProcess("cntrno_disp"); 
		// OnKeyPress 이벤트 (공통function)
		axon_event.addListener("keypress", "obj_keypress", "cntrno_disp");
		// OnKeyUp 이벤트 (자체function)
		axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp");
		// 페이지 로딩시 focus
		document.form.cntrno_disp.focus();

		if (document.form.cntrno_disp.value != "") {
			document.form.cntr_no.value =  document.form.cntrno_disp.value + document.form.check_digit.value;
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
		case 1 : // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 442;

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(41, 5, 0, true);
		
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "Seq|Container No.|TP/SZ|Correction Type|Correction Type|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|F/M|I/O|MSG|TP|DM|D|E|R|SP|Service Provider|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Correction Reason|Evidence Attached|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Office|User Name|Remark(S)||Input Div";

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 헤더 툴팁
				var sTipAF = "";
				sTipAF += "[ Auto Flag ]\n";
				sTipAF += "A : Missing status automatically created by system.\n";
				sTipAF += "C : (International) \"TS, IC, MT\" Status automatically created after \"VD\"\n";
				sTipAF += "      (USA domestic) \"CM\" Status automatically created after \"CD\"\n";
				sTipAF += "N : Once automatically created status (\"A\") modified by manual,\n";
				sTipAF += "      \"A\" changed to \"N\"\n";
				sTipAF += "M : Added status.\n";
				sTipAF += "U : Status updated due to next status.\n";
				sTipAF += "E : Status created by Master/Lease.\n";
				sTipAF += "S : Once automatically created status (\"A\") modified by late EDI,\n";
				sTipAF += "      \"A\" changed to \"S\"\n";
				sTipAF += "B : Status updated by manual due to error.\n";
				sTipAF += "G : Once created without VGM, missing VGM is retroactively inserted by later EDI message.";

				var sTipIO = "Bound indicator";
				var sTipTP = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
				var sTipDM = "Damage, Y";
				var sTipHR = "Hanger Rack, Y";
				var sTipHB = "Hanger Bar";
				var sTipD  = "Disposal Candidate, Y";
				var sTipE  = "Immediate Exit, Y";
				var sTipR  = "Re-furbishing, Y";
				var sTipSP = "Special, Y";

				// 자동 트림하여 조회및 저장
				DataAutoTrim = true;

				// 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "his_seq",	              false,    "",    dfNone,    0,    true,    true,    -1,    false,    false); 
				InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    true,    "cntr_no",	              false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    true,    "cntr_tpsz_cd",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    50,     daLeft,      true,    "modi_tp",                 false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    45,     daLeft,      true,    "dat_div_flg",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false); 
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "cnmv_cyc_no",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    true,    "cnmv_co_cd",              false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "mvmt_sts_cd",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "mvmt_cre_tp_cd",          false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipAF);
				InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    true,    "org_yd_cd",               false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    true,    "dest_yd_cd",              false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    100,    daCenter,    true,    "cnmv_evnt_dt",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    true,    "vvd_cd",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    true,    "bkg_no",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "fcntr_flg",               false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "ob_cntr_flg",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipIO);
				InitDataProperty(0, cnt++,    dtData,    35,     daCenter,    true,    "mvmt_edi_msg_tp_id",      false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "bkg_cgo_tp_cd",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipTP);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "cntr_dmg_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipDM);
				InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    true,    "cntr_disp_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipD);
				InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    true,    "imdt_ext_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipE);
				InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    true,    "cntr_rfub_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipR);
				InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "spcl_cgo_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipSP);
				InitDataProperty(0, cnt++,    dtData,    130,    daCenter,    true,    "vndr_seq",                false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    true,    "mvmt_trsp_mod_cd",        false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,    "chss_no",                 false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,    "mgst_no",                 false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,    "cntr_seal_no",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    true,    "wbl_no",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    true,    "pkup_no",                 false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    200,    daLeft,      true,    "cnmv_corr_rsn",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtImageText,    80, daCenter,  true,    "atch_file",               false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    true,    "upd_locl_dt",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    true,    "cre_locl_dt",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    true,    "upd_dt",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    true,    "cre_dt",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    true,    "ofc_cd",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    70,     daLeft,      true,    "usr_nm",                  false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtData,    150,    daLeft,      true,    "cnmv_rmk",                false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtHidden,  40,    daCenter,    true,    "atch_file_sav_id",        false,    "",    dfNone,    0,    true,    true,    -1,    false,    false);
				InitDataProperty(0, cnt++,    dtHidden,  40,  	 daCenter,    false,   "inp_div_flg",		      false,    "",    dfNone,    0,    true,    true);
				ImageList("atch_file")= "/hanjin/img/ico_attach.gif";
				InitDataImage(0, "atch_file", daCenter);

				ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
				CountPosition = 0;
			}
			break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, frmObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch (sAction) {
		case IBSEARCH : // 조회
			if (validateForm(sheetObj, frmObj, sAction)) {
				sheetObjects[0].WaitImageVisible = false;
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;

				var xml = sheetObj.GetSearchXml("EES_CTM_0437GS.do", FormQueryString(frmObj));
				var rtnValue = xml.split("|$$|");
				sheetObjects[0].RemoveAll();
				sheetObjects[0].LoadSearchXml(rtnValue[0]);
				sheetObjects[0].SelectCell(sheetObjects[0].LastRow, 0); // 조회데이터의 마지막 row가 선택되어있게 한다.
			}
			break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, frmObj, sAction) {
		switch (sAction) {
		case IBSEARCH :
			if (frmObj.cntrno_disp.value == "" || frmObj.check_digit.value == "") {
				ComShowCodeMessage("CTM00000", "Container No.");
				return false;
			} else if (frmObj.cntr_no.value == "") {
				frmObj.cntr_no.value =  frmObj.cntrno_disp.value + frmObj.check_digit.value;
			}
			break;
		}

		return true;
	}

	/**
	 * Sheet1의 OnSearchEnd 이벤트 처리
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {  	   	
		var seq = 0;
		var perSeq = 0;

		// update는 하나로 묶어서 Seq 구현
		for(var i=1; i<=sheetObj.LastRow; i++) {
			if (perSeq != sheetObj.CellValue(i, "his_seq")) {
				seq = seq + 1;
			}   		
			perSeq = sheetObj.CellValue(i, "his_seq");
			sheetObj.CellValue(i, "his_seq") = seq;

			// Insert나 Delete의 경우 Correction Type merge
			if ("Update" != sheetObj.CellValue(i, "modi_tp")) {
				sheetObj.CellBackColor(i, 3) = sheetObj.RgbColor(255, 246, 18);
				sheetObj.CellValue(i, 4) = "";
				sheetObj.CellBackColor(i, 4) = sheetObj.RgbColor(255, 246, 18);
			}

			// update는 변경값 배경색 표시
			if ("Update" == sheetObj.CellValue(i, "modi_tp")) {
				if ("To" == sheetObj.CellValue(i, "dat_div_flg")) {
					sheetObj.CellValue(i-1, "cnmv_corr_rsn") = "";
					for (var x=5; x<=29; x++) {
						if (sheetObj.CellValue(i-1, x) != sheetObj.CellValue(i, x)) {
							sheetObj.CellBackColor(i, x) = sheetObj.RgbColor(255, 246, 18);
						}
					}
				}
			}

			if (sheetObj.CellValue(i, "atch_file_sav_id") == "") {
				sheetObj.CellValue(i, "atch_file") = "N";
			} else {
				sheetObj.CellImage(i, "atch_file") = "atch_file";
			}
		} 

		ComOpenWait(false);
		sheetObjects[0].WaitImageVisible = true;       
		sheetObj.SelectHighLight = true;
		sheetObj.Redraw = true;
	}

	/**
	 * 파일 다운받기
	 * @param {ibsheet} sheet    IBSheet Object
	 * @param {ibsheet} row     	sheet 선택된 row
	 * @param {ibsheet} col     	sheet 선택된 col
	 * @param {String} 	value     	파일명
	 **/
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		if (sheetObj.ColSaveName(Col) == "atch_file" && sheetObj.CellValue(Row, "atch_file_sav_id") != "") {
			var key_id = sheetObj.CellValue(Row, "atch_file_sav_id");
			hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
		}
	}

	/**
	 * 마우스 포인터 이동시 발생하는 이벤트
	 * @param {ibsheet} sheet    IBSheet Object
	 * @param {ibsheet} Button     	sheet 선택된 Button
	 * @param {ibsheet} Shift     	sheet 선택된 Shift
	 * @param {int} 	X     		X좌표값
	 * @param {int} 	Y     		Y좌표값
	 */
	function sheet1_OnMouseMove(sheet, Button, Shift, X, Y) {
		var row = sheet.MouseRow;
		var col = sheet.MouseCol;

		if (row>sheet.HeaderRows && sheet.ColSaveName(col) == "atch_file") {
			if (sheet.CellValue(row, "atch_file") != "N") {
				sheet.MousePointer = "Hand";
			}
		}
	}

	/**
	 * HTML Object의 OnKeyUp이벤트 처리
	 */
	function obj_onkeyup(event) {
		srcValue = event.srcElement.value; // CoCtm.js의 공통스크립트의 자동실행 방지용
		var frmObj = document.form;
		var sheetObj = sheetObjects[0];

		switch (event.srcElement.name) {
		case "cntrno_disp" : // cntrno_disp에 입력되는 값의 length에 따른 처리
			frmObj.cntrno_disp.value = frmObj.cntrno_disp.value.toUpperCase();
			var cntrnoDisp = frmObj.cntrno_disp;

			if (cntrnoDisp.value.length > 1) {
				frmObj.p_cntrno.value = cntrnoDisp.value;
				if (cntrnoDisp.value.length > 9) {
					// p_cntrno에 10글자가 채워지면 CTM공통함수의 cntr_search 호출
					if (!cntr_search()) {
						cntrnoDisp.select();
						cntrnoDisp.focus();
						frmObj.cntr_no.value = "";
						frmObj.cntrno_disp.value = "";
						frmObj.check_digit.value = "";
					} else {
						// 정상적인 경우 CTM공통함수의 setFocusIndex호출(다음 Element에 Focus)
						setFocusIndex(event.srcElement, 1);
						frmObj.cntr_no.value =  frmObj.cntrno_disp.value + frmObj.check_digit.value;
					}
				} else {
					frmObj.check_digit.value = "";
				}
			} else {
				frmObj.p_cntrno.value = "";
				frmObj.check_digit.value = "";
			}
			break;
	    }

		onShowErrMsg = false; // CoCtm.js의 공통스크립트의 자동실행 방지용
	}

	/**
	 * Multi Container No. 입력창 popup
	 * @param srcName
	 * @param arg
	 */
	function doProcessPopup(srcName, arg) {
		var sheetObj = sheetObjects[0];
		var formObj	= document.form;

		with (sheetObj) {
			switch(srcName) {
			case "m_cntr_no" : // CNTR No. 멀티입력 팝업 호출
				var flag = ComReplaceStr(srcName, "m_", "");
				var orgval = formObj.cntr_no.value;
				// 멀티입력 팝업 타이틀 세부 내용 지정
				var returntitle = "";
				if (flag == "cntr_no") {
					returntitle = "CNTR No.";
				}

				var param = "?returnval=" + flag + "&returntitle=" + returntitle+ "&orgval=" + orgval;
				ComOpenPopup("EES_CTM_0464.do" + param, 400, 380, "getCntr_Multi", "1,0,1,1,1,1,1,1,1,1,1,1", true);
				formObj.cntrno_disp.value = formObj.cntr_no.value.substring(0, 10);
				formObj.check_digit.value = formObj.cntr_no.value.substring(10, 11);
				if (formObj.cntr_no.value.length > 12) {
					formObj.cntrno_disp.style.background = "#FFCCFF";
					formObj.cntrno_disp.disabled = true;
				} else {
					formObj.cntrno_disp.style.background = "#CCFFFF"; 
					formObj.cntrno_disp.disabled = false;
				}
				break;
			}
		}
	}

	var multi = "N";

	/**
	 * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
	 * - 해당 필드에 멀티 입력값을 설정해준다.
	 */
	function getCntr_Multi(rArray, return_val) {
		multi = "Y";
		var targObj = eval("document.form." + return_val);
		var retStr = rArray.toString().toUpperCase();

		ComSetObjValue(targObj, retStr);
	}    
