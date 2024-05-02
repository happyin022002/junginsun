/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : common_0430.js
 * @FileTitle : CNTR History Update - javascript sub file
 *              (EES_CTM_0430과 EES_CTM_0414에서 공통으로 사용되는 부분만 별도로 모음)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2010-05-04
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2010-05-04 김상수 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
 * 2014.02.04 강환 [CHM-201328232] B.Bulk Bkg의 auto created MVMT에 삭제/수정 기능 추가 
 * 2014.04.11 강환 [CHM-201429549] Bkg route와 비교하여 MVMT에 VL-VD누락된 경우, VL-VD Insert 허용
 * 2014.04.15 강환 [CHM-201429756] SOC ID-XX 삭제 시 Master Call
 * 2015.09.22 김상현 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
 * 2016.06.13 김상현 [CHM-201641731] VGM 항목 추가
 */

	// 공통전역변수
	// sheet2 : 삭제 확인용 변수
	var delConfirm = true;
	// sheet2 : 입력시 ID를 최종 값으로 설정하기 위한 전역변수
	var maxId = "";
	var maxYr = "";
	// sheet2 : 변경 내역을 추적하기 위한 변수
	var maxIa = [["",""],["",""],["",""]]; 
	var orgFlag = "";

	/**
	 * 조회 처리
	 */
	function btn2Retrieve() {
		if (!checkFormField()) return;
		doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
	}

	/**
	 * Save 처리
	 */
	function btn2Save() {
		sheetObjects[0].WaitImageVisible = false;
		sheetObjects[1].WaitImageVisible = false;
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[1], document.form, MULTI); // 저장
		ComOpenWait(false);
		sheetObjects[1].WaitImageVisible = true;
		sheetObjects[0].WaitImageVisible = true;
	}

	/**
	 * Delete 처리
	 */
	function btn2Delete() {
		with (sheetObjects[1]) {
			var sRowStr = FindCheckedRow("del_chk");
			var arr = sRowStr.split("|");

			// 첫번째 row일 경우는 update는 가능하나 삭제는 불가능(신조 MT 제외) (2008이전 Cut된 MST쪽 컨테이너정보와 비동기화 우려)
			if (arr[0] == 1 && (CellValue(arr[0], "mvmt_sts_cd") != "MT" || CellValue(arr[0], "cnmv_seq") != 1 || CellValue(arr[0], "cnmv_cyc_no") != 1)) {
				ComShowCodeMessage("CTM10031", "first row");
				return;
			} else {
				// 2014.04.15 강환 [CHM-201429756] SOC ID-XX 삭제 시 Master Call
				var delIdXx = 0;

				for (var i=0; i<arr.length-1; i++) {
					if (RowEditable(arr[i])) {
						var sts = CellValue(arr[i], "mvmt_sts_cd");
						if ((CellValue(arr[i], "mvmt_sts_cd") == "ID") && (CellValue(parseInt(arr[i], 10) + 1, "mvmt_cre_tp_cd") == "C"
								&& CellValue(parseInt(arr[i],10)+1, "mvmt_sts_cd") == "XX")) {
							delIdXx = 1;
						}
					}
				}

				if (delIdXx == 1 && i > 1) {
					ComShowCodeMessage("CTM20122");
					return;
				}

				for (var i=0; i<arr.length - 1; i++) {
					if (RowEditable(arr[i])) {
						var sts = CellValue(arr[i], "mvmt_sts_cd");
						// VD이후 자동생성된 Status 자동 삭제
						if (sts == "VD" || sts == "CD") {
							// VD이후 자동생성된 Line 이외의 자료가 있을경우 삭제 금지
							if (sts == "VD") {
								for (var x=Number(arr[i])+1; x<=LastRow; x++) {
									if (CellValue(x, "mvmt_cre_tp_cd") != "C") {
										ComShowCodeMessage("CTM20093");
										for (var k=0; k<arr.length - 1; k++) {
											CellValue2(arr[k], "del_chk") = 0;
										}
										return;
									}
								}
							}

							// Correction Reason가 없을 경우 중단하도록 한다.
							if (CellValue(arr[i], "cnmv_corr_rsn") == "") {
								ComShowCodeMessage("CTM00000", "Correction Reason");
								CellEditable(arr[i], "cnmv_corr_rsn") = true;
								CellEditable(arr[i], "atch_file_sav_id") = true;
								CellEditable(arr[i], "atch_file_sav_nm") = true;
								CellValue2(arr[i], "del_chk") = 0;
								RowStatus(arr[i]) = "R";
								SelectCell(arr[i], "cnmv_corr_rsn");
								return;
							} else {
								// VD 이후 자동생성 된 내역은 모두 함께 삭제한다. remark도 복사한다.
								for (var j=arr[i]; j<=LastRow; j++) {
									if (j == arr[i] || CellValue(j, "mvmt_cre_tp_cd") == "C") {
										CellValue(j, "cnmv_rmk") = CellValue(arr[i], "cnmv_rmk");
										CellValue(j, "cnmv_corr_rsn") = CellValue(arr[i], "cnmv_corr_rsn");
										CellValue(j, "lst_flg") = "1";
										RowStatus(j) = "D";
										RowHidden(j) = true;
									} else {
										break;
									}
								}
							}
						} else if (sts == "OP" && arr[i] != LastRow) { // OP 이후 마지막 row까지 함께 삭제할 때만 삭제 가능 - 2010-07-08 : Rqst by IHJang
							for (var x=Number(arr[i])+1; x<=LastRow; x++) {
								if (CellValue(x, "del_chk") != 1 && CellValue(x, "mvmt_cre_tp_cd") != "C") {
									ComShowCodeMessage("CTM20109");
									for (var k=0; k<arr.length-1; k++) {
										CellValue2(arr[k], "del_chk") = 0;
									}
									return;
								}
							}
							// 현재 Script 파일에 정의된 함수
							if (deleteRow(sheetObjects[1], arr[i]) == false) {
								return;
							}
						} else if (sts == "MT" && CellValue(arr[i], "cnmv_seq") == 1 && CellValue(arr[i], "cnmv_cyc_no") == 1 && arr[arr.length - 2] < LastRow) { // 신조 MT 이고 그 이후 자료가 있을경우 삭제 금지
							CellValue2(arr[i], "del_chk") = 0;
							RowStatus(arr[i]) = "R";
							ComShowCodeMessage("CTM20103");
							return;
						} else {
							// 현재 Script 파일에 정의된 함수
							if (deleteRow(sheetObjects[1], arr[i]) == false) {
								return;
							}
						}
					}
				}
			}

			// OP이후 모든 Status가 삭제되면 OP를 마지막에 지운걸로 취급하도록 한다
			for (var i = LastRow; i >= 1; i--) {
				if (RowStatus(i) != "D") {
					break;
				} else {
					if (CellValue(i, "mvmt_sts_cd") == "OP") {
						CellValue2(i, "lst_flg") = "1";
						break;
					}
				}
			}

			delConfirm = true;
		}
	}

    // function initSheet()에서 사용 (S) ======================================= //
    function initSheet2() {

        var cnt = 0;
        with (sheetObjects[1]) {

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            //InitColumnInfo(58, 5, 0, true);
            InitColumnInfo(64, 5, 0, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle  = "|Sel.|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No." +
                             "|F/M|I/O|MSG|TP|DM|D|E|R|SP" +
                             "|Service Provider|Service Provider|Mode|Chassis No.|M.G Set|Seal No.|VGM|Waybill|Pick Up No.|Correction Reason|File|Evidence Attached|Remark(s)|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)" +
                             "|Office|User Name|ID|SEQ|NO|CNTR_NO|BKG_NO|BKG_SPLIT|BKG_KNT|BL_NO|BL_NO_TYPE|BL_NO_CHK|YEAR|FLG|TPSZ|MAX SEQ|CNTR_SVR ID|SVR_ID|EDI1|EDI2|EDI3|EDI4|VVD||||Last BKG No.|";

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

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

            var sTipIO = "Bound indicator"; //
            var sTipTP = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
            var sTipDM = "Damage, Y";
            var sTipHR = "Hanger Rack, Y";
            var sTipHB = "Hanger Bar";
            var sTipD  = "Disposal Candidate, Y";
            var sTipE  = "Immediate Exit, Y";
            var sTipR  = "Re-furbishing, Y";
            var sTipSP = "Special, Y";

            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 30,     daCenter,    false,    "ibflag");
            InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    false,    "del_chk",            false,    "",    dfNone);
            InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "cnmv_cyc_no",        true,     "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "cnmv_co_cd",         true,     "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "mvmt_sts_cd",        true,     "",    dfNone,        0,    true,     true,    2);
            InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "mvmt_cre_tp_cd",     false,    "",    dfNone,        0,    false,    false,   1,     false,    true,    sTipAF);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "org_yd_cd",          true,     "",    dfNone,        0,    true,     true,    7);
            InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "dest_yd_cd",         false,    "",    dfNone,        0,    true,     true,    7);
            InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "cnmv_evnt_dt",       true,     "",    dfUserFormat2, 0,    true,     true);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "cntr_id",            false,    "",    dfNone,        0,    true,     true,    9);
            InitDataProperty(0, cnt++, dtData,	       100,    daCenter,    false,    "bkg_no",				false,    "",    dfNone,        0,    true,     true,    12);
            InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "fcntr_flg",          false,    "",    dfNone,        0,    true,     true,    1);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "ob_cntr_flg",        false,    "",    dfNone,        0,    true,     true,    1);
            InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "mvmt_edi_msg_tp_id", false,    "",    dfNone,        0,    false,    true,    3);
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "bkg_cgo_tp_cd",      false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipTP);
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "cntr_dmg_flg",       false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipDM);
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "cntr_disp_flg",      false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipD);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "imdt_ext_flg",       false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipE);
            //  InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "cntr_xch_cd",        false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipR);
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "cntr_rfub_flg",      false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipR);
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "spcl_cgo_flg",       false,    "",    dfNone,        0,    false,    true,    1,     false,    true,    sTipSP);
            InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "vndr_seq",           false,    "",    dfNone,        0,    true,     true,    6,     false,    true);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "vndr_abbr_nm",       false,    "",    dfNone,        0,    false,    true,    100);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "mvmt_trsp_mod_cd",   false,    "",    dfNone,        0,    true,     true,    1);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "chss_no",            false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "mgst_no",            false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "cntr_seal_no",       false,    "",    dfNone);
            InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "vgm",                false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         85,     daCenter,    false,    "wbl_no",             false,    "",    dfNone);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "pkup_no",            false,    "",    dfNone);
            InitDataProperty(0, cnt++, dtCombo,        110,    daCenter,    false,    "cnmv_corr_rsn",      false,    "",    dfNone,        0,    true,     true);
            InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    false,    "atch_file_sav_id",   false,    "",    dfNone,        0,    true,     true);
            InitDataProperty(0, cnt++, dtPopup,        110,    daCenter,    false,    "atch_file_sav_nm",   false,    "",    dfNone,        0,    true,     true);
            InitDataProperty(0, cnt++, dtData,         160,    daLeft,      false,    "cnmv_rmk",           false,    "",    dfNone,        0,    true,     true,    500);
            InitDataProperty(0, cnt++ ,dtData,         100,    daCenter,    false,    "upd_locl_dt",        false,    "",    dfUserFormat2, 0,    false,    false);
            InitDataProperty(0, cnt++ ,dtData,         100,    daCenter,    false,    "cre_locl_dt",        false,    "",    dfUserFormat2, 0,    false,    false);
            InitDataProperty(0, cnt++ ,dtData,         100,    daCenter,    false,    "upd_dt",             false,    "",    dfUserFormat2, 0,    false,    false);
            InitDataProperty(0, cnt++ ,dtData,         100,    daCenter,    false,    "cre_dt",             false,    "",    dfUserFormat2, 0,    false,    false);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "ofc_cd",             false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         130,    daLeft,      false,    "usr_nm",             false,    "",    dfNone,        0,    false,    false);
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cnmv_id_no"); 
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cnmv_seq");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cnmv_split_no");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cntr_no");
//            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bkg_no");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bkg_no_split");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bkg_knt");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bl_no");
//            InitDataProperty(0, cnt++, dtData,       100,    daCenter,    false,    "bl_no");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bl_no_tp");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bl_no_chk");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cnmv_yr");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "flg");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cntr_tpsz_cd");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "vr_seq");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "cntr_svr_id");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "svr_id");
            // 컬럼추가시 OnChange, addRow의 ROW 복사 등. 로직에 주의
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "mvmt_edi_tp_cd");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "mvmt_edi_msg_area_cd");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "mvmt_edi_msg_yrmondy");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "mvmt_edi_msg_seq");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "vvd_cd");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "ctrt_seq");
            InitDataProperty(0, cnt++, dtHidden,       160,    daCenter,    false,    "lst_flg");
            InitDataProperty(0, cnt++, dtHidden,       160,    daCenter,    false,    "chg_mvmt_dt_flg");
            InitDataProperty(0, cnt++, dtHidden,        25,    daCenter,    false,    "cntr_xch_cd");
            InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "lst_bkg_no");

            InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:");
            InitUserFormat2(0, "upd_locl_dt", "####-##-## ##:##", "-|:");
            InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:");
            InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:");
            InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:");

            // 영문자 또는 숫자만 입력
            InitDataValid(0, "mvmt_sts_cd", vtEngUpOnly);
            InitDataValid(0, "org_yd_cd", vtEngUpOther, "1234567890");
            InitDataValid(0, "dest_yd_cd", vtEngUpOther, "1234567890");
            InitDataValid(0, "cntr_id", vtEngUpOther, "1234567890");
            InitDataValid(0, "fcntr_flg", vtEngUpOnly);
            InitDataValid(0, "ob_cntr_flg", vtEngUpOnly);
            InitDataValid(0, "mvmt_edi_msg_tp_id", vtEngUpOther, "1234567890");
            InitDataValid(0, "bkg_cgo_tp_cd", vtEngUpOnly);
            InitDataValid(0, "cntr_dmg_flg", vtEngUpOnly);
            InitDataValid(0, "cntr_disp_flg", vtEngUpOnly);
            InitDataValid(0, "imdt_ext_flg", vtEngUpOnly);
            InitDataValid(0, "cntr_rfub_flg", vtEngUpOnly);
            InitDataValid(0, "spcl_cgo_flg", vtEngUpOnly);
            InitDataValid(0, "vndr_seq", vtNumericOnly);
            InitDataValid(0, "mvmt_trsp_mod_cd", vtEngUpOther, "1234567890");
            InitDataValid(0, "cntr_seal_no", vtEngUpOther, "1234567890");
            InitDataValid(0, "wbl_no", vtEngUpOther, "1234567890");
            InitDataValid(0, "pkup_no", vtEngUpOther, "1234567890");

            InitDataCombo(0, "cnmv_corr_rsn", cnmvCorrRsnValue, cnmvCorrRsnCode);

            ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0; title:";
            PlusChar2Encoding = true;
            CountPosition = 0;
            SelectHighLight = false;
        }
    }
    // function initSheet()에서 사용 (E) ======================================= //

    // Open Popup
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var formObj = document.form;
		var upObj = uploadObjects[0];

		var fileName = sheetObj.OpenFileDialog("파일선택");
		if (fileName.indexOf("\\") !=-1) {
			// 먼저 기존파일을 모두 지운후 추가함
			upObj.Files = "";
			var ret = upObj.AddFile(fileName);

			upObj.ExtendParam = "f_cmd=" + COMMAND06;

			var sXml = upObj.DoUpload(true);
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, "atch_file_sav_nm") = fileName;
			var fileSaveId = ComGetEtcData(sXml, "fileSaveId");
			sheetObj.CellValue2(Row, "atch_file_sav_id") = fileSaveId;
		}
    }

	/**
	 * Sheet2의 OnChange 이벤트 처리
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var rtnXml = "";
		var rtnValue = "";
		var rtnName = "";

		with (sheetObj) {
			var preStatus = CellValue(Row-1, "mvmt_sts_cd");
			var curStatus = CellValue(Row, "mvmt_sts_cd");
			var nexStatus = CellValue(Row+1, "mvmt_sts_cd");

			switch (ColSaveName(Col)) {

                case "cnmv_evnt_dt":
                    var nowEvent = CellText(Row, Col);
                    // Event Date를 수정한 경우 날짜포맷을 확인한다.
                    if (!ComIsDateTime(nowEvent, "", "hm")) {
                        ComShowCodeMessage("CTM00001");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                    // Event Date를 수정한 경우 상 하 EventDate를 비교한다.
                    var befEvent = CellText(Row-1, Col);
                    var aftEvent = CellText(Row+1, Col);
                    var mRow = LastRow;
                    var nextCreCd = CellValue(Row+1, "mvmt_cre_tp_cd");
                    if (nextCreCd == "C") aftEvent = "";
                    // 다음 시간이 C가 아닌 것만 가져오도록 변경
                    for (var i = Row+1; i <= mRow; i++) {
                        atStatus = CellValue(i, "mvmt_cre_tp_cd");
                        if (atStatus != "C") {
                            aftEvent = CellText(i, Col);
                            break;
                        }
                    }
                    if (aftEvent == null || aftEvent == "") aftEvent = nowEvent;
                    if (nowEvent > aftEvent) {
                        ComShowCodeMessage("CTM20087");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                    copyValue2NextRow(sheetObj, Row, Col, Value);    // Value를 다음 row에 복사하는 내부 function호출
                    if (Row == 1 && Row == mRow) {
                        changeColor(sheetObj, Row);
                    } else if (nowEvent > aftEvent && Row == 1) {
                        ComShowCodeMessage("CTM20087");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if (befEvent > nowEvent && Row == mRow) {
                        ComShowCodeMessage("CTM20087");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if ((befEvent > nowEvent || nowEvent > aftEvent) && (Row != mRow && Row != 1)) {
                        ComShowCodeMessage("CTM20087");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                    changeColor(sheetObj, Row);
                    preSts = CellValue(Row - 1, "mvmt_sts_cd");
                    if (CellValue(Row, "mvmt_sts_cd") == "OC" && (preSts != "EN" && preSts != "TN")) {
                        CellValue2(Row, "lst_flg") = "O";
                    }
                    CellValue2(Row, "chg_mvmt_dt_flg") = "Y";
                    
                    if(curStatus == "VD"){
                    	CellValue2(Row + 1, "cnmv_evnt_dt") = nowEvent;
                    	CellValue2(Row + 1, "chg_mvmt_dt_flg") = "Y";
                    	CellValue(Row + 1, "ibflag") = "U";
                    }
                    break;

                case "mvmt_sts_cd":
                    // Status가 VL이전에 IC,ID 또는 VD이후 OP,OC여서는 안된다
                    rtnXml = GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH09 + "&mvmt_sts_cd=" + curStatus);
                    rtnValue = ComGetEtcData(rtnXml, "rtnValue");
                    if (rtnValue == "0" || rtnValue == "") {
                        ComShowCodeMessage("CTM20102");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                    var AfCd = CellText(Row, "mvmt_cre_tp_cd");
                    var preAfCd = CellText(Row-1, "mvmt_cre_tp_cd");
                    if (AfCd == "C") {
                        for (var i = Row - 1; i > 0; i--) {
                            AfC = CellText(i, "mvmt_cre_tp_cd");
                            if (AfC != "C") {
                                preStatus = CellText(i, "mvmt_sts_cd");
                                AfCd = CellText(i, "mvmt_cre_tp_cd");
                                break;
                            }
                        }
                    }
                    
                    // ID/MT 다음 OP/OC 이면 cyc 1 증가
                    for(var i=1;i<LastRow;i++){ //[CHM-201222045] CHM-201220798 보완 
                    	if( "I"==CellValue(i, "ibflag") || "U"==CellValue(i, "ibflag") ){
                    		// ID/MT - OP/OC
                    		if (( "ID" == CellValue(i-1, "mvmt_sts_cd") || "MT" == CellValue(i-1, "mvmt_sts_cd") )
                    			&& ( "OP" == CellValue(i, "mvmt_sts_cd") || "OC" == CellValue(i, "mvmt_sts_cd") )){
                    			var nextCycNo = 0;
                    			var nextOriRow = 0; 
                    			for(var j=i;j<=LastRow;j++){ // 원래 있던 다음 줄의 cnmv_cyc_no 값 찾기
                    				if(CellValue(j, "ibflag") != "I"){
                    					nextCycNo = CellText(j, "cnmv_cyc_no")*1;
                    					nextOriRow = j;
                    					break;
                    				}
                    			}
            					copyValueFromToRow(sheetObj,i,nextOriRow); // 아랫줄에서 booking 정보 복사 해옴 //[CHM-201222045]
                				if(CellText(i-1, "cnmv_cyc_no")*1 < nextCycNo){ // cyc 1 증가
                					CellValue2(i, "cnmv_cyc_no") = CellText(i-1, "cnmv_cyc_no")*1+1;
                				}
                    		}else{
                    			copyValueFromToRow(sheetObj,i,i-1);//윗줄에서 booking 정보 복사 해옴 
                    			CellValue2(i, "cnmv_cyc_no") = CellText(i-1, "cnmv_cyc_no")*1; // 윗줄에서 cyc 복사 
                    		}
                    	}
                    }
                    
                    if (curStatus == "XX") {
                        ComShowCodeMessage("CTM20088");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if (((preStatus == "TS" || preStatus == "IC") && preAfCd == "C") && (curStatus == "OP" || curStatus == "OC")) {
                        ComShowCodeMessage("CTM10029");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if (nexStatus == "VL" && (curStatus == "IC" || curStatus == "ID")) {
                        ComShowCodeMessage("CTM10029");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if (nexStatus == "XX") {
                        ComShowCodeMessage("CTM20090");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    // 2014.04.11 강환 [CHM-201429549] Bkg route와 비교하여 MVMT에 VL-VD누락된 경우, VL-VD Insert 허용
                    // } else if (curStatus == "VL" && preStatus != "TS") {
                    } else if (curStatus == "VL" && preStatus != "TS" && preStatus != "OC") {
                        ComShowCodeMessage("CTM20091");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if (curStatus == "VD" && preStatus != "VL") {
                        ComShowCodeMessage("CTM20091");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }else if ((curStatus == "MT" && (preStatus == "EN" || preStatus == "TN")) || ((curStatus == "EN" || curStatus == "TN") && preStatus == "MT")) {
                        //**************//
                        //** ROW 복사 **//
                        //**************//
                        for (var x = 19; x < 27; x++) {
                            CellValue2(Row, x) = "";
                        }
                        CellValue2(Row, "fcntr_flg") = "M";
                        CellValue2(Row, "bkg_cgo_tp_cd") = "";
                        CellValue2(Row, "mvmt_edi_msg_tp_id") = "";
                        for (var x = 44; x < 48; x++) {
                            CellValue2(Row, x) = "";
                        }
                        CellValue2(Row, "vvd_cd") = "";
                    } else if (curStatus == "MT" && (preStatus == "ID" || preStatus == "IC")) {
                        CellValue2(Row, "fcntr_flg") = "M";
                    } else if (curStatus == "OP"){ // CHM-201219637 
                    	CellValue2(Row, "fcntr_flg") = "M";
                    	CellValue2(Row, "ob_cntr_flg") = "O";
                    }
                    if ((CellSearchValue(Row, Col) == "TN" || CellSearchValue(Row, Col) == "EN") && curStatus == "MT" && Row == LastRow){
                        ComShowCodeMessage("CTM20102");
                    	CellValue2(Row, "mvmt_cre_tp_cd") = CellSearchValue(Row, "mvmt_cre_tp_cd");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        SelectCell(Row, Col, true);
                        return;                    	
                    }
                    if ((CellSearchValue(Row, Col) == "TN" || CellSearchValue(Row, Col) == "EN") && curStatus == "OP" && Row == LastRow){
                        if (CellText(Row, "bkg_no") == ""){
                        	ComShowCodeMessage("CTM10012");
                            CellEditable(Row, "bkg_no") = true;
                        	SelectCell(Row, "bkg_no", true);
                        	return;
                        }
                    }                    
                    if ((CellSearchValue(Row, Col) == "TN" || CellSearchValue(Row, Col) == "EN") && (preStatus == "IC" || preStatus == "MT")){
                    	CellValue2(Row, "mvmt_cre_tp_cd") = "B";
                    }

                    if (curStatus == "OC" || (preStatus == "OC" && (curStatus == "TN" || curStatus == "EN"))){ //[CHM-201220807]
                    	CellValue2(Row, "fcntr_flg") = "F";
                    	CellValue2(Row, "ob_cntr_flg") = "O";
					}
                    // Add 2014.08.07 Validation
                    if (curStatus == "OP" && CellText(Row, "bkg_no") == ""){
                        ComShowCodeMessage("CTM10012");
                        CellEditable(Row, "bkg_no") = true;
                        SelectCell(Row, "bkg_no", true);
                        //alert("NO Delete This Msg");
                    	if (Row == LastRow -1 && (CellSearchValue(Row, Col) == "EN" || CellSearchValue(Row, Col) == "TN")){
               				CellValue2(Row, "bkg_cgo_tp_cd") = "F";
               				if (CellText(Row, "bkg_no") == "") CellValue2(Row, "bkg_no") = CellText(Row +1, "bkg_no");
               				if (CellText(Row, "bkg_no") != "" && CellText(Row, "bkg_no") != CellText(Row -1, "bkg_no")){
                   				CellValue2(Row, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1+1;
                   				CellValue2(Row +1, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1;
               				}
                    	}
       					return;
                    }
                    // Add 2014.07.22 Validation
                    if (Row == LastRow){
                    	if (curStatus == "OC" && CellSearchValue(Row, Col) == "MT"){
	                    	if(preStatus == "ID"){
	                            ComShowCodeMessage("CTM20102");
	                            CellValue2(Row, Col) = CellSearchValue(Row, Col);
	                            clearStatus(sheetObj, Row);
	                            SelectCell(Row, Col, true);
	                            return;
	                    	}else if(preStatus == "OP"){
	                    		if(preStatus == "OP"){
		                    		CellValue2(Row, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1;
		                    		CellValue2(Row, "bkg_no") = CellText(Row -1, "bkg_no");
		               				CellValue2(Row, "bkg_cgo_tp_cd") = "F";
		                    	}else{
		                            ComShowCodeMessage("CTM20102");
		                            CellValue2(Row, Col) = CellSearchValue(Row, Col);
		                            clearStatus(sheetObj, Row);
		                            SelectCell(Row, Col, true);
		                            return;                    		
		                    	}
	                    	}else if(preStatus == "EN"||preStatus == "TN"){
	                    		if(CellText(Row -1, "fcntr_flg") == "M" && CellText(Row -1, "bkg_cgo_tp_cd") == "" && CellText(Row -1, "bkg_no") == ""){
		                    		CellValue2(Row -1, "mvmt_sts_cd") = "OP";
		               				CellValue2(Row -1, "bkg_cgo_tp_cd") = "F";
		               				CellValue2(Row -1, "ob_cntr_flg") = "O";
		               				if (CellText(Row -1, "bkg_no") == "") CellValue2(Row -1, "bkg_no") = CellText(Row, "bkg_no");
		                    		
		               				if (CellText(Row, "bkg_no") != "" && CellText(Row, "bkg_no") != CellText(Row -2, "bkg_no")){
		               					CellValue2(Row -1, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1+1;
		               					CellValue2(Row, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1;
		               				}
		               				CellValue2(Row, "bkg_cgo_tp_cd") = "F";
		               				
		               				if (CellText(Row -1, "bkg_no") == "" || CellText(Row, "bkg_no") == ""){		               					
			                            ComShowCodeMessage("CTM10012");
			                            SelectCell(Row, "bkg_no", true);
		               					return;
		               				}
	
	                    		}else{
		                            ComShowCodeMessage("CTM20102");
		                            CellValue2(Row, Col) = CellSearchValue(Row, Col);
		                            clearStatus(sheetObj, Row);
		                            SelectCell(Row, Col, true);
		                            return;
	                    		}
	                    	}
                    	}
                    }else if(Row == LastRow -1){
                    	if (curStatus = "OP" && (CellSearchValue(Row, Col) == "EN" || CellSearchValue(Row, Col) == "TN")){
                    		CellEditable(Row, "bkg_no") = true;
                    		if (CellText(Row, "bkg_no") != "" && CellText(Row, "bkg_no") != CellText(Row -1, "bkg_no")){
                    			CellValue2(Row, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1+1;
                    			CellValue2(Row +1, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1;
                    		}
               				CellValue2(Row, "bkg_cgo_tp_cd") = "F";
               				if (CellText(Row, "bkg_no") == "") CellValue2(Row, "bkg_no") = CellText(Row +1, "bkg_no");
                    	}
                    }
                    
                    changeColor(sheetObj, Row);
                    break;

                case "cntr_id":
                    // VVD는 BKG_VVD에 같은 데이터가 존재해야한다.
                    // VL일때 -> POL_CD
                    // VD일때 -> POD_CD
                    // VVD -> VSL_CD, SKD_VOY_NO, SKD_DIR_CD
                    var orgYard = CellText(Row, "org_yd_cd");
                    var vvdCode = CellText(Row, Col); 
                    if (vvdCode == "") {
                        rtnValue == "S"
                    } else {
                        var rtnXml = GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&p_yard1=" + orgYard + "&vvdcode=" + vvdCode + "&p_vvd_type=" + curStatus);
                        rtnValue = ComGetEtcData(rtnXml, "rtnValue");
                    }
                    if (rtnValue != "S") {
                        LoadSearchXml(rtnXml);
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                    
                    var ibFlg = CellValue(Row, "ibflag");
                    var curVVD = CellText(Row, Col);
                    var cycle = CellValue(Row, "cnmv_cyc_no");
                    var selectbkgRow = sheetObjects[0].FindText("cnmv_cyc_no", cycle, -1);
                    var bkgNo = sheetObjects[0].CellValue(selectbkgRow, "bkg_no");
                    var cntrId = CellValue(Row, "cntr_id");
                    //신규 생성이고 VL, VD인 경우 VVD의 POL, POD LCC가 같은지 체크. 같을 경우 입력 제한.
                    if(ibFlg == "I" && (curStatus == "VD" || curStatus == "VL")){
	                    var xml = sheetObj.GetSearchXml("EES_CTM_0430GS.do", "f_cmd=" + SEARCH02 + "&bkg_no=" + bkgNo + "&cntr_id=" + cntrId);
		                var polLccCd = ComGetEtcData(xml, "POL_LCC_CD");
		                var podLccCd = ComGetEtcData(xml, "POD_LCC_CD");
		                var podCd = ComGetEtcData(xml, "POD_CD");
		                if(polLccCd == "" || polLccCd == null){
		                	ComShowCodeMessage("CTM20073");
		                	CellValue2(Row, Col) = CellSearchValue(Row, Col);
	                        SelectCell(Row, Col, true);
	                        return;
		                }else if(polLccCd == podLccCd){
		                	ComShowCodeMessage("CTM20078");
		                	CellValue2(Row, Col) = CellSearchValue(Row, Col);
	                        SelectCell(Row, Col, true);
	                        return;
		                }
		                //VD 신규 생성의 경우 bkg pod 와 비교하여 TS 혹은 IC 자동 생성
		                if(curStatus == "VD"){
		                	var orgYdCd = CellValue(Row, "org_yd_cd").substr(0,5);
		                	addRow();
		                	CellValue2(Row+1, "cntr_id") = "";
		                	CellValue2(Row+1, "org_yd_cd") = CellValue(Row, "org_yd_cd");
		                	CellValue2(Row+1, "cnmv_evnt_dt") = CellValue(Row, "cnmv_evnt_dt");
		                	if(podCd == orgYdCd){
			                	CellValue2(Row+1, "mvmt_sts_cd") = "IC";
			                }else{
			                	CellValue2(Row+1, "mvmt_sts_cd") = "TS";
			                }
		                	CellValue2(Row+1, "bkg_no") = CellValue(Row, "bkg_no");
		                }
                    }
                    // VL, VD인 경우 VVD는 VL과 VD가 같아야 한다.
                    if (curStatus == "VL" && nexStatus == "VD") {
                        if (confirm(ComGetMsg("CTM20100"))) {
                            CellValue2(Row+1, "cntr_id") = curVVD;
                            changeColor(sheetObj, Row+1);
                        } else {
                            CellValue2(Row, Col) = CellSearchValue(Row, Col);
                            clearStatus(sheetObj, Row);
                            SelectCell(Row, Col, true);
                            return;
                        }
                    } else if (curStatus == "VD" && preStatus == "VL") {
                        if (confirm(ComGetMsg("CTM20101"))) {
                            CellValue2(Row -1, Col) = curVVD;
                            changeColor(sheetObj, Row-1);
                        } else {
                            CellValue2(Row, Col) = CellSearchValue(Row, Col);
                            clearStatus(sheetObj, Row);
                            SelectCell(Row, Col, true);
                            return;
                        }
                    }
                    changeColor(sheetObj, Row);
                    break;

                case "org_yd_cd":
                case "dest_yd_cd":
                    var newValue = "";
                    var param = Value;
                    if (param == "") {
                        rtnValue = "S";
                        svrChk = "S";
                    } else {
                        newValue = param.substring(0,5)
                        rtmXml = GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH14 + "&p_yard1=" + param);
                        rtnValue = ComGetEtcData(rtmXml, "rtnValue");
                        svrChk = ComGetEtcData(rtmXml, "svrChk");
                    }
                    if (rtnValue != "S") {
                        ComShowCodeMessage ("CTM10001");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else if (svrChk != "S") {
                        ComShowCodeMessage("CTM20072");
                        //alert ("사용자와 야드의 Server 정보 불 일치");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                    // VL/VD일때
                    if (curStatus == "VL" || curStatus == "VD") {
                        // 입력값이 조회된 Yard와 같지 않을때
                        if (param != CellSearchValue(Row, Col)) {
                            // 입력값이 조회된 Yard앞5자리(LOC_CD)가 와 같지 않을때
                            if (newValue != CellSearchValue(Row, Col).substring(0, 5)) {
                                ComShowCodeMessage("CTM20092");
                                if (RowBackColor(Row) != RgbColor(124, 252, 0)) {
                                    CellValue2(Row, Col) = CellSearchValue(Row, Col);
                                    clearStatus(sheetObj, Row);
                                    SelectCell(Row, Col, true);
                                    return;
                                }
                            }
                            changeColor(sheetObj, Row);
                        }
                    } else {
                        changeColor(sheetObj, Row);
                    }
                    // 다음row Yard도 변경
                    var nowYard = Value;
                    if (ColSaveName(Col) == "org_yd_cd" && nowYard != CellValue(Row+1, Col)) {
                        copyValue2NextRow(sheetObj, Row, Col, Value);    // Value를 다음 row에 복사하는 내부 function호출
                    }
                    break;

                case "fcntr_flg":
                    if (Value == "F" || Value == "M") {
                        changeColor(sheetObj, Row);
                        copyValue2NextRow(sheetObj, Row, Col, Value);    // Value를 다음 row에 복사하는 내부 function호출
                    } else {
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                    }
                    break;

                case "ob_cntr_flg":
                    if (Value == "I" || Value == "O") {
                        changeColor(sheetObj, Row);
                        copyValue2NextRow(sheetObj, Row, Col, Value);    // Value를 다음 row에 복사하는 내부 function호출
                    } else {
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                    }
                    break;

                case "vndr_seq":
                    if (Value == "") {
                        rtnValue = "S";
                        rtnName  = "";
                    } else {
                        rtmXml = GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH15 + "&p_vender=" + Value);
                        rtnValue = ComGetEtcData(rtmXml, "rtnValue");
                        rtnName  = ComGetEtcData(rtmXml, "rtnName");
                    }
                    if (rtnValue != "S") {
                        LoadSearchXml(rtmXml);
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    } else {
                        CellValue2(Row, "vndr_abbr_nm") = rtnName;
                        changeColor(sheetObj, Row);
                    }
                    break;

                case "cntr_dmg_flg":
                case "cntr_disp_flg":
                case "imdt_ext_flg":
                case "cntr_rfub_flg":
                case "spcl_cgo_flg":
                    if ((Value != "Y" && Value != "")) {
                        CellValue2(Row, Col) = "Y";
                        changeColor(sheetObj, Row);
                    }
                    break;

                case "mvmt_trsp_mod_cd":
                    if (Value != "T" && Value != "R" && Value != "B") {
                        ComShowCodeMessage("CTM10016");
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                    }
                    break;
                case "bkg_no":
                    // 결과값이 false면 Table에 해당 value가 없다는 것이므로 해당 Cell에 focus
                	if (Value.length == 11 ) {					//길이가 11자리면 DMST에서 확인
                    	 if (Value != "" && !code_search(Value, "DMST_BKG_NO", "DOM_BOOKING")) {
                    		 sheetValidation = false;
                             SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                    	 } else {
                    		 sheetValidation = true;
                    	 }
                    	 if (curStatus == "OC" && preStatus == "OP"){
                         	if (Row == LastRow && (CellText(Row -1, "bkg_no") == "" || CellText(Row -1, "bkg_no") == CellText(Row, "bkg_no")) && 
                         			(CellText(Row, "bkg_no") != CellText(Row -2, "bkg_no"))){
                         		CellValue2(Row - 1, "bkg_no") = Value;
                         		if(CellText(Row, "cnmv_cyc_no") == CellText(Row -2, "cnmv_cyc_no")){
                         			CellValue2(Row, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1+1;
                         			CellValue2(Row -1, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1;
                         		}
                         	}
                    	 }
                    } else {										// 그외는 BKG에서 확인
                        if (Value != "" && !code_search(Value, "BKG_NO", "BKG_BOOKING")) {
                            sheetValidation = false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation = true;
                            CellValue2(Row, "bl_no") = Value;  
                            if(curStatus == "VD"){
                            	CellValue2(Row + 1, "bl_no") = Value;
//                            	CellValue2(Row + 1, "bl_no") = "Y";
                            	CellValue2(Row + 1, "bkg_no") = Value;
//                            	CellValue2(Row + 1, "bkg_no") = "Y";
                            	CellValue(Row + 1, "ibflag") = "U";
                            }else if (curStatus == "OP" && Row == LastRow ){
                             	if (CellText(Row, "bkg_no") == ""){
                                	ComShowCodeMessage("CTM10012");
                                	SelectCell(Row, "bkg_no", true);
                                	return;
                             	}else{
                             		if(CellText(Row, "bkg_no") != CellText(Row -1, "bkg_no")){
                           				CellValue2(Row, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1+1;
                             		}else{
                                        CellValue2(Row, "cnmv_cyc_no") = CellSearchValue(Row, "cnmv_cyc_no");
                             		}
                             	}
                            }else if (curStatus == "OC" && preStatus == "OP"){
                            	if (Row == LastRow){
                            		CellValue2(Row - 1, "bkg_no") = Value;
                            	}
                             	if (Row == LastRow && (CellText(Row -1, "bkg_no") == CellText(Row, "bkg_no")) && 
                             			(CellText(Row, "bkg_no") != CellText(Row -2, "bkg_no"))){
                             		CellValue2(Row - 1, "bkg_no") = Value;
                             		if(CellText(Row, "cnmv_cyc_no") == CellText(Row -2, "cnmv_cyc_no")){
                             			CellValue2(Row, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1+1;
                             			CellValue2(Row -1, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1;
                             		}
                             	}
                            }else if (curStatus == "OP" && nexStatus == "MT"){
                             	if (Row == LastRow -1 && (CellText(Row -1, "bkg_no") != CellText(Row, "bkg_no"))){
                             		//CellValue2(Row - 1, "bkg_no") = Value;
                             		if(CellText(Row, "cnmv_cyc_no") == CellText(Row -1, "cnmv_cyc_no")){
                             			CellValue2(Row, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1+1;
                             			CellValue2(Row +1, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1;
                             		}
                             	}
                            }
                        }
                    }
					break;
				case "cnmv_corr_rsn" :
					if (RowStatus(Row) === "I") { // 해당 Row가 Insert일 경우, Correction Reason를 위/아래 movement를 체크해서 같이 변경하도록 수정
						if (Row > 1 && RowStatus(Row - 1) === "U" && CellValue(Row - 1, "cnmv_corr_rsn") == "") {
							CellValue2(Row - 1, "cnmv_corr_rsn") = Value;
						}
						if (Row < LastRow && RowStatus(Row + 1) === "U" && CellValue(Row + 1, "cnmv_corr_rsn") == "") {
							CellValue2(Row + 1, "cnmv_corr_rsn") = Value;
						}
					}

					if (orgFlag == "R") {
						RowStatus(Row) = "R";
					}
					break;
                default:
                    changeColor(sheetObj, Row);
                    break;
            }
        }
    }

    /**
     * sheet2의 onChange 이벤트시 특정 조건에 맞는 경우 다음row에도 해당 Cellvalue복사
     */
    function copyValue2NextRow(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            var preStatus = CellValue(Row-1, "mvmt_sts_cd");
            var curStatus = CellValue(Row, "mvmt_sts_cd");
            var nexStatus = CellValue(Row+1, "mvmt_sts_cd");
            var nextCreCd = CellValue(Row+1, "mvmt_cre_tp_cd");
            // ID다음 row가 XX(C)일때
            if (curStatus == "ID" && (nextCreCd == "C" && nexStatus == "XX")) {
                CellValue2(Row+1, Col) = Value;
                changeColor(sheetObj, Row+1)
                RowEditable(Row + 1) = true;
            // VD, CD
            } else if ((curStatus == "VD" || curStatus == "CD") && (nexStatus == "ID" || nexStatus == "CM" || nexStatus == "IC" || nexStatus == "TS" || nexStatus == "MT")) {
                for (var i = Row+1; i <= LastRow; i++) {
                    var tempCreCd = CellValue(i, "mvmt_cre_tp_cd");
                    var tempStatus = CellValue(i, "mvmt_sts_cd");
                    if (tempCreCd == "C" && (tempStatus == "ID" || tempStatus == "CM" || tempStatus == "IC" || tempStatus == "TS" || tempStatus == "MT" || tempStatus == "XX")) {
                        CellValue2(i, Col) = Value;
                        changeColor(sheetObj, i);
                        RowEditable(i) = true;
                    } else {
                        break;
                    }
                }
            }
            
        }
    }

	function sheet2_OnBeforeEdit(sheetObj, Row, Col) {
		orgFlag = sheetObj.RowStatus(Row);
	}

    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "del_chk") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (RowEditable(arr[i])) {
                            CellValue(arr[i], "del_chk") = "1";    // 선택된 행의 CheckBox 체크
                            RowStatus(arr[i]) = "R";
                        }
                    }
                }
            }
            // click한 row와 아래 row가 모두 RowEditable이 false면 btn2_add를 disable - 2010-07-08 : Rqst by IHJang
            if (!RowEditable(Row) && !RowEditable(Row + 1)) {
                ComBtnDisable("btn2_add");
            } else {
                ComBtnEnable("btn2_add");
            }
            //2014.09.16 Revenue MT Bkg/Soc VD-MT-XX Case
            if(sheetObjects[0].CellText(sheetObjects[0].LastRow, "bkg_cgo_tp_cd") == "R" && 
            	sheetObjects[0].CellText(sheetObjects[0].LastRow, "pod_cd") != sheetObjects[0].CellText(sheetObjects[0].LastRow, "del_cd")){
            	if (CellText(Row, "mvmt_sts_cd") == "MT" &&
            			CellText(Row -1, "mvmt_sts_cd") == "VD" && CellText(Row +1, "mvmt_sts_cd") == "XX"){
                    ComBtnEnable("btn2_add");
            	}
            }            
        }
    }


    /**
     * sheet2의 add row 에 대한 처리
     * 새로운 row를 추가한다.
     */
    function addRow() {
        with (sheetObjects[1]) {
            if (SearchRows < 1) return;
            // 마지막 행에 추가 불가.
            var nowRow = SelectRow;
            var maxRow = LastRow;
            var Sts  = CellText(nowRow, "mvmt_sts_cd");
            if (Sts == "VD" && CellValue(nowRow, "ibflag") != "I") {
                ComShowCodeMessage("CTM20083");
                return false;
            } else if (nowRow == maxRow) {
                ComShowCodeMessage("CTM20084");
                return false;
            } else {
                // 현재 ID의 최종 자료를 불러온다.
                var curId  = CellText(nowRow, "cnmv_seq");
                var uprDpi = CellText(nowRow, "cnmv_split_no");
                var cyclNo = CellText(nowRow, "cnmv_cyc_no");
                var compNo = CellText(nowRow, "cnmv_co_cd");
                var nowSel = DataInsert();
                var curYear = CellText(nowRow, "cnmv_yr");
                // 정렬 순서를 재조합 한다.
                // RowBackColor(nowSel) = RgbColor(124,252,0);
                var maxId = "";
                for (i = 0; i < 3; i++) {
                    if (maxIa[i][0] == curYear) {
                        maxIa[i][1] = Number(maxIa[i][1]) + 1;
                        maxId = maxIa[i][1];
                        break;
                    }
                }
                CellValue2(nowRow+1, "cnmv_id_no") = maxId;
                //**************/
                //** ROW 복사 **/
                //**************/
                var usrOffice = document.form.usr_office.value;
                for (x = 13; x < 19; x++) {
                    CellValue2(nowRow+1, x) = CellText(nowRow, x);
                }
                for (x = 19; x < 27; x++) {
                    CellValue2(nowRow+1, x) = CellText(nowRow, x);
                }
                CellValue2(nowRow+1, "fcntr_flg") = CellText(nowRow, "fcntr_flg");
                CellValue2(nowRow+1, "ob_cntr_flg") = CellText(nowRow, "ob_cntr_flg");
                for (x = 39; x < 54; x++) {
                    CellValue2(nowRow+1, x) = CellText(nowRow, x);
                }
                CellValue2(nowRow+1, "vvd_cd") = CellText(nowRow, "vvd_cd");
                CellValue2(nowRow+1, "ctrt_seq") = CellText(nowRow, "ctrt_seq");
                CellValue2(nowRow+1, "cnmv_cyc_no") = cyclNo;
                CellValue2(nowRow+1, "cnmv_co_cd") = compNo;
                maxId++;

                CellValue2(nowRow+1, "cnmv_seq") = curId;
                CellValue2(nowRow+1, "cnmv_yr") = curYear;
                CellValue2(nowRow+1, "flg") = "Y";
                CellValue2(nowRow+1, "mvmt_cre_tp_cd") = "M";
                CellValue2(nowRow+1, "ofc_cd") = usrOffice;
                CellValue2(nowRow+1, "cnmv_corr_rsn") = "";

                // SPLIT이 NULL(2 Space)일 때 A, B로 세팅해준다.
                if (uprDpi == "  " || uprDpi == ""|| uprDpi == " ") {
                    CellValue2(nowRow, "cnmv_split_no") = "A";
                    CellValue2(nowRow+1, "cnmv_split_no") = "B";
                    if (RowStatus(nowRow) != "I" && RowStatus(nowRow) != "D")
                        RowStatus(nowRow) = "U";
                    changeColor(sheetObjects[1], nowRow);
                } else {
                    // 아스키 값에서 1을 증가시킨다.
                    var chrCode = uprDpi.charCodeAt(0) + 1;
                    for (var i = nowRow+1; i <= LastRow; i++) {
                        if ((CellText(i, "cnmv_seq") == curId)) {
                            CellValue2(i, "cnmv_split_no") = String.fromCharCode(chrCode);
                            var curSts = RowStatus(i);
                            if (curSts != "I" && curSts != "D") {
                                RowStatus(i) = "U";
                            }
                            chrCode++;
                        } else break;
                    }
                }
                changeColor(sheetObjects[1] , nowSel);
                return true;
            }
        }
    }

	/**
	 * sheet2의 delete row에 대한 처리
	 * param : sheetObj ==> 시트오브젝트, Row ==> Sheet Object의 라인 번호
	 * 현재 선택된 row를 지운다
	 */
	function deleteRow(sheetObj, Row) {
		with (sheetObj) {
			var rmValue = CellValue(Row, "cnmv_rmk");
			var status = CellValue(Row, "mvmt_sts_cd");
			var autoFlag = CellValue(Row, "mvmt_cre_tp_cd");

			// 신규 생성된 행은 바로 삭제한다.
			if (CellValue(Row, "flg") == "Y") {
				RowDelete(Row);
				return true;
			}

			if ((status == "VL" || status == "VD" || autoFlag == "C") && Row != LastRow) {
				if (Row != LastRow && CellValue(LastRow, "mvmt_cre_tp_cd") != "C") {
					CellValue2(Row, "del_chk") = 0;
					RowStatus(Row) = "R";
					ComShowCodeMessage("CTM20093");
				} else {
					RowStatus(Row) = "D";
					RowHidden(Row) = true;
					if (autoFlag == "C") {
						CellEditable(LastRow, "cnmv_corr_rsn") = true;
						CellEditable(LastRow, "atch_file_sav_id") = true;

						CellValue(LastRow, "cnmv_rmk") = CellValue(Row, "cnmv_rmk");
						CellValue(LastRow, "cnmv_corr_rsn") = CellValue(Row, "cnmv_corr_rsn");
						CellValue(LastRow, "atch_file_sav_id") = CellValue(Row, "atch_file_sav_id");

						if (CellValue(LastRow, "cnmv_corr_rsn") == "") {
							ComShowCodeMessage("CTM00000", "Correction Reason");
							SelectCell(LastRow, "cnmv_corr_rsn");
							return false;
						}
						RowStatus(LastRow) = "D";
						RowHidden(LastRow) = true;
					}
				}
			} else if (Row == LastRow && autoFlag == "C") {
				if (CellValue(Row, "cnmv_corr_rsn") == "") {
					ComShowCodeMessage("CTM00000", "Correction Reason");
					SelectCell(Row, "cnmv_corr_rsn");
					return false;
				}
				RowStatus(Row) = "D";
				RowHidden(Row) = true;
			} else if (CellValue(Row, "cnmv_corr_rsn") == "") {
				ComShowCodeMessage("CTM00000", "Correction Reason");
				CellEditable(Row, "cnmv_corr_rsn") = true;
				CellEditable(Row, "atch_file_sav_id") = true;
				CellEditable(Row, "atch_file_sav_nm") = true;
				sheetObj.SelectCell(Row, "cnmv_corr_rsn");
				return false;
			} else if (status == "XX" || autoFlag == "E" || (status == "MT" && deleteCondition(rmValue.substring(0, 3)))) { // MT일때는 deleteCondition함수호출
				CellValue2(Row, "del_chk") = 0;
				RowStatus(Row) = "R";
				ComShowCodeMessage("CTM20095");
			} else if ((Row == LastRow - 1 && status == "ID") && (CellValue(LastRow, "mvmt_cre_tp_cd") == "C" && CellValue(LastRow, "mvmt_sts_cd") == "XX")) {
				// 마지막 선택 row의 Status가 ID이고 바로아래(마지막)row가 자동생성된 XX이면 함께 삭제한다. remark도 복사한다.
				CellEditable(LastRow, "cnmv_corr_rsn") = true;
				CellEditable(LastRow, "atch_file_sav_id") = true;
				CellEditable(LastRow, "atch_file_sav_nm") = true;

				CellValue(LastRow, "cnmv_corr_rsn") = CellValue(Row, "cnmv_corr_rsn");
				CellValue(LastRow, "atch_file_sav_id") = CellValue(Row, "atch_file_sav_id");
				CellValue(LastRow, "cnmv_rmk") = CellValue(Row, "cnmv_rmk");

				if (CellValue(LastRow, "cnmv_corr_rsn") == "") {
					ComShowCodeMessage("CTM00000", "Correction Reason");
					SelectCell(LastRow, "cnmv_corr_rsn");
					return false;
				}

				RowStatus(Row) = "D";
				RowHidden(Row) = true;
				RowStatus(LastRow) = "D";
				RowHidden(LastRow) = true;
			} else {
				RowStatus(Row) = "D";
				RowHidden(Row) = true;
			}
		}
		return true;
	}

	/**
	 * Sheet2의 조회후 ROW의 편집상태 변경
	 */
	function row_Editable4Sheet2() {
		var rowDiableCount = 0; // RowEditable이 false로 지정될 때 counting

		with (sheetObjects[1]) {
			Redraw = false;
			// 조회된 데이터가 1건이면 삭제버튼 비활성화 (2008이전 Cut된 MST쪽 컨테이너정보와 비동기화 우려)
			if (RowCount < 2) {
				// 1건이지만 신조 MT장비이면 삭제버튼 활성화
				if (CellValue(LastRow, "mvmt_sts_cd") == "MT" && CellValue(LastRow, "cnmv_seq") == 1 && CellValue(LastRow, "cnmv_cyc_no") == 1) {
					ComBtnEnable("btn2_delete");
				} else {
					ComBtnDisable("btn2_delete");
				}
			} else {
				ComBtnEnable("btn2_delete");
			}

			// Editable
			for (i = 0; i < 3; i++) {
				maxIa[i][0] = "";
				maxIa[i][1] = "";
			}

			var lastCyc = CellText(LastRow, "cnmv_cyc_no");
			var screenNo = location.pathname.substring(location.pathname.lastIndexOf("_") + 1, location.pathname.lastIndexOf("."));

			for (i=1; i<=LastRow; i++) {
				if (CellValue(i, "svr_id") != "1") { // 로그인한 사용자와의 SVR_ID가 같지 않으면 Disable
					RowEditable(i) = false;
					rowDiableCount++;
				} else if (CellValue(i, "mvmt_cre_tp_cd") == "C") { // 자동생성Flag가 C이면 Disable
                	// 2014.02.04 강환 [CHM-201328232] B.Bulk Bkg의 auto created MVMT에 삭제/수정 기능 추가
                	// Term이 Tackle이고, Break Bulk 화물이면 수정 가능
					if (screenNo == "0430") {
						var bkgline = sheetObjects[0].FindText("cnmv_cyc_no", CellValue(i, "cnmv_cyc_no"));

						if (bkgline > 0) {
							if (CellValue(i, "ob_cntr_flg") == "O" && sheetObjects[0].CellValue(bkgline, "rcv_term_cd") == "T"
									&& sheetObjects[0].CellValue(bkgline, "bb_cgo_flg") == "Y" && (CellValue(i, "mvmt_sts_cd") == "ID" || CellValue(i, "mvmt_sts_cd") == "MT")) {
								RowEditable(i) = true;
							} else if (CellValue(i, "ob_cntr_flg") == "I" && sheetObjects[0].CellValue(bkgline, "de_term_cd") == "T"
									&& sheetObjects[0].CellValue(bkgline, "bb_cgo_flg") == "Y" && (CellValue(i, "mvmt_sts_cd") == "ID" || CellValue(i, "mvmt_sts_cd") == "MT")) {
								RowEditable(i) = true;
							} else {
								RowEditable(i) = false;
							}
						} else {
							RowEditable(i) = false;
						}

						if (CellText(i, "mvmt_sts_cd") == "XX" && CellText(i, "bkg_cgo_tp_cd") == "R") {
							RowEditable(i) = true;
							for (var ii=1; ii<=LastCol; ii++) {
								if (ColSaveName(ii) == "cnmv_evnt_dt" || ColSaveName(ii) == "cnmv_rmk" || ColSaveName(ii) == "cnmv_corr_rsn"
										|| ColSaveName(ii) == "atch_file_sav_id" || ColSaveName(ii) == "atch_file_sav_nm") {
									CellEditable(i, ii) = true;
								} else {
									CellEditable(i, ii) = false;
								}
							}
						}

						// 2014.09.16 Revenue MT Bkg/Soc VD-MT-XX Case
						if (sheetObjects[0].CellText(sheetObjects[0].LastRow, "bkg_cgo_tp_cd") == "R"
								&& sheetObjects[0].CellText(sheetObjects[0].LastRow, "pod_cd") != sheetObjects[0].CellText(sheetObjects[0].LastRow, "del_cd")) {
							if (i == LastRow && CellText(LastRow, "mvmt_sts_cd") == "XX"
									&& CellText(LastRow -1, "mvmt_sts_cd") == "MT" && CellText(LastRow -2, "mvmt_sts_cd") == "VD") {
								CellEditable(i, "org_yd_cd") = true;
								CellEditable(i, "cnmv_corr_rsn") = true;
								CellEditable(i, "atch_file_sav_id") = true;
								CellEditable(i, "atch_file_sav_nm") = true;
							}
						}
					} else {
						RowEditable(i) = false;
					}
					rowDiableCount++;
				} else {
					var currCyc = CellText(i, "cnmv_cyc_no");

					if (CellText(i, "mvmt_sts_cd") == "XX" && CellText(i, "bkg_cgo_tp_cd") == "R") {
						CellEditable(i, "cnmv_evnt_dt") = true;
						CellEditable(i, "cnmv_rmk") = true;
						CellEditable(i, "cnmv_corr_rsn") = true;
						CellEditable(i, "atch_file_sav_id") = true;
						CellEditable(i, "atch_file_sav_nm") = true;
					}

					// 2014.09.16 Revenue MT Bkg/Soc VD-MT-XX Case
					if (sheetObjects[0].CellText(sheetObjects[0].LastRow, "bkg_cgo_tp_cd") == "R"
							&& sheetObjects[0].CellText(sheetObjects[0].LastRow, "pod_cd") != sheetObjects[0].CellText(sheetObjects[0].LastRow, "del_cd")) {
						if (i == LastRow && CellText(LastRow, "mvmt_sts_cd") == "XX"
								&& CellText(LastRow -1, "mvmt_sts_cd") == "MT" && CellText(LastRow -2, "mvmt_sts_cd") == "VD") {
							CellEditable(i, "org_yd_cd") = true;
							CellEditable(i, "cnmv_corr_rsn") = true;
							CellEditable(i, "atch_file_sav_id") = true;
							CellEditable(i, "atch_file_sav_nm") = true;
						}
					}

					if ((lastCyc - currCyc) < 3) { // Last Cycle보다 Cycle이 작은 마지막 3개 항목만 수정가능
						var status = CellValue(i, "mvmt_sts_cd");
						var autoFlag = CellValue(i, "mvmt_cre_tp_cd");

						if (status == "XX" || autoFlag == "E" || (status == "MT" && deleteCondition(CellValue(i, "cnmv_rmk").substring(0, 3)))) { // MT일때는 deleteCondition함수호출
							for (var j=0; j<=LastCol; j++) {
								if (ColSaveName(j) == "cnmv_evnt_dt" || ColSaveName(j) == "cnmv_corr_rsn"
										|| ColSaveName(j) == "atch_file_sav_id" || ColSaveName(j) == "atch_file_sav_nm") {
									CellEditable(i, j) = true;
								} else {
									CellEditable(i, j) = false;
								}
							}
						} else if (status == "VL" || status == "VD") {
							// VL, VD는 Status를 수정 할 수 없도록 제한한다.
							CellEditable(i, "mvmt_sts_cd") = false;
						}
						if (status == "ID" || status == "MT") {
							for (var j=0; j<=LastCol; j++) {
								if (ColSaveName(j) == "bkg_no") {
									if (screenNo == "0430") {
										var bkgline = sheetObjects[0].FindText("cnmv_cyc_no", CellValue(i, "cnmv_cyc_no"));

										if (bkgline > 0) {
											if (sheetObjects[0].CellValue(bkgline, "bkg_no") != CellValue(i, "bkg_no")) {
												CellEditable(i, j) = true;
												CellEditable(i, "cnmv_corr_rsn") = true;
												CellEditable(i, "atch_file_sav_id") = true;
												CellEditable(i, "atch_file_sav_nm") = true;
											} else {
												CellEditable(i, j) = false;
											}
										}
									} else {
										CellEditable(i, j) = false;
									}
								}
							}
						} else {
							CellEditable(i, "bkg_no") = false;
						}
					} else {
						RowEditable(i) = false;
						rowDiableCount++;
					}
				}

				// 년도 별 최종 ID값을 얻어온다.
				for (var x0=0; x0<3; x0++) {
					if (maxIa[x0][0] == "") {
						maxIa[x0][0] = CellValue(i, "cnmv_yr");
						maxIa[x0][1] = CellValue(i, "vr_seq");
						break;
					} else if (maxIa[x0][0] == CellValue(i, "cnmv_yr")) {
						maxIa[x0][1] = CellValue(i, "vr_seq");
						break;
					}
				}
			}

			if (LastRow > 1) {
				CellValue2(LastRow, "lst_flg") = "1";
				RowStatus(LastRow) = "R";
			}
			if (CellValue(LastRow - 1, "mvmt_sts_cd") == "VD") {
				CellValue2(LastRow - 1, "lst_flg") = "1";
				RowStatus(LastRow - 1) = "R";
			}
			SelectCell(LastRow, 0);

			// rowDiableCount와 전체 row수가 같으면 btn2_add를 disable로 하여 row add 방지
			if (RowCount <= rowDiableCount) {
				ComBtnDisable("btn2_add");
			} else {
				ComBtnEnable("btn2_add");
			}

			Redraw = true;
		}
	}

	/**
	 * MT일때 RowDepete 가능여부 Validation
	 */
	function deleteCondition(rmSubstr) {
		if (rmSubstr == "LSI" ||
				rmSubstr == "DII" ||
				rmSubstr == "SBI" ||
				rmSubstr == "SBR" ||
				rmSubstr == "MUI" ||
				rmSubstr == "MUR" ||
				rmSubstr == "SRI" ||
				rmSubstr == "SRR" ||
				rmSubstr == "TTL" ||
				rmSubstr == "TLL" ||
				rmSubstr == "SCR" ||
				rmSubstr == "DON" ||
				rmSubstr == "SLD" ||
				rmSubstr == "FND") {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * FrRow 의 Booking 관련 정보 등을 ToRow 로 복사한다. //copyValueFromNextRow
	 */
	function copyValueFromToRow(sheetObj,ToRow,FrRow) { //FrRow 의 값을 ToRow 로 복사한다
		with (sheetObj) {
			CellValue2(ToRow, "bkg_no")        = CellText(FrRow, "bkg_no");
			CellValue2(ToRow, "bkg_split_no")  = CellText(FrRow, "bkg_split_no");
			CellValue2(ToRow, "bkg_knt")       = CellText(FrRow, "bkg_knt");
			CellValue2(ToRow, "bl_no")         = CellText(FrRow, "bl_no");
			CellValue2(ToRow, "bl_no_tp")      = CellText(FrRow, "bl_no_tp");
			CellValue2(ToRow, "bl_no_chk")     = CellText(FrRow, "bl_no_chk");
			CellValue2(ToRow, "vvd_cd")        = CellText(FrRow, "vvd_cd");
			CellValue2(ToRow, "ctrt_seq")      = CellText(FrRow, "ctrt_seq");
		}
	}
