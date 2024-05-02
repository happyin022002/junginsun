/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0405.js
 * @FileTitle : Empty VL List without BKG
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.05.14
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2009.05.14 김상수 1.0 Creation
 * 2016.06.22 김상현 [CHM-201641960] Correction Reason 항목 추가화면 기능 추가
 */

/**
 * @extends
 * @class ees_ctm_0405 : ees_ctm_0405 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_ctm_0405() {
	this.processButtonClick    = processButtonClick;
	this.setSheetObject        = setSheetObject;
	this.loadPage              = loadPage;
	this.initSheet             = initSheet;
	this.doActionIBSheet       = doActionIBSheet;
	this.validateForm          = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var uploadObjects = new Array();
var uploadCnt = 0;

var errorXml = "";

var lastRetrieveDate = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
	
	     var sheetObj = sheetObjects[0];
	     var frmObj = document.form;
	
	    try {
	        var srcName = window.event.srcElement.getAttribute("name");
	
	        switch(srcName) {
	            case "btn_Calendar":
	                if (!window.event.srcElement.disabled) {
	                    var cal = new ComCalendarFromTo();
	                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
	                }
	                break;
	
	            case "btn_delete":
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                doActionIBSheet(sheetObj, frmObj, IBSAVE);    // 저장
	                ComOpenWait(false);
	                sheetObj.WaitImageVisible = true;
	                break;
	
	            case "btn_retrieve":
	                if (!checkFormField()) return;
	                sheetObj.HeadCheck(0, "Sel") = false;
	                doActionIBSheet(sheetObj, frmObj, IBSEARCH);
	                break;
	
	            case "btn_new":
	                ComResetAll();
	                comboObjects[0].RemoveAll();
	                frmObj.lcc_cd.focus();
	                break;
	
	            case "btn_downexcel":
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Sel");
	                ComOpenWait(false);
	                sheetObj.WaitImageVisible = true;
	                break;
	
	        } // end switch
	
	    } catch(e) {
	        if( e == "[object Error]") {
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
    function setSheetObject (sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    /**
     * IBMultiCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++] = combo_obj;
    }

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	    }

	    setEventProcess("lcc_cd", "yd_cd_disp"); // CTM-COMMON ("lcc_cd", "yd_cd_disp"예외처리)

	    // OnKeyPress 이벤트 (공통function)
	    axon_event.addListener("keypress", "obj_keypress", "lcc_cd", "yd_cd_disp");
	    // OnKeyUp 이벤트 (자체function)
	    axon_event.addListener("keyup", "obj_onkeyup", "lcc_cd", "yd_cd_disp");

	    // btn_del 버튼 Disable
	    ComBtnDisable("btn_delete");

	    // 페이지 로딩시 focus
	    document.form.lcc_cd.focus();

        ComConfigUpload(uploadObjects[0], "/hanjin/CTMCommonGS.do");
	    cancelDate = true;
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet (sheetObj, sheetNo) {
	    var cnt = 0;
	
	    with (sheetObj) {
	
	        // 높이 설정
	        style.height = 442;
	
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
	        InitColumnInfo(33, 0, 0, true);
	
	        // 헤더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, true, true, false, false);

	        // Ctrl키를 눌러 다중행 선택가능
	        MultiSelection = true;
	        SelectionMode = smSelectionList;

	        var HeadTitle = "|Seq.|Container No.|TP/SZ|STS|Event date|Origin Yard|EDI POD|VVD|Call sign|Lloyd|Remark(s)|Correction Reason|File|Evidence Attached";

	        // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        InitHeadRow(0, HeadTitle, true);

	        // Enter키를 눌렀을때 Tab키처럼 작동
	        EditEnterBehavior = "tab";

	        // 자동 트림하여 조회및 저장
	        DataAutoTrim = true;

	        // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	        InitDataProperty(0, cnt++, dtDummyCheck, 25,     daCenter,   false,    "Sel",                false,    "",    dfNone,    0,    true,     true);
	        InitDataProperty(0, cnt++, dtSeq,        30,     daCenter,   false,    "Seq");
	        InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "cntr_no",            false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       50,     daCenter,   false,    "cntr_tpsz_cd",       false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       50,     daCenter,   false,    "mvmt_sts_cd",        false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       120,    daCenter,   false,    "cnmv_evnt_dt",       false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       80,     daCenter,   false,    "org_yd_cd",          false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       90,     daCenter,   false,    "bkg_pod_cd",         false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       90,     daCenter,   false,    "vvd_cd",             false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       90,     daCenter,   false,    "call_sgn_no",        false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       90,     daCenter,   false,    "lloyd_no",           false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtData,       260,    daLeft,     false,    "mty_repo_vl_rmk",    false,    "",    dfNone,    0,    false,    false);
	        InitDataProperty(0, cnt++, dtCombo,      110,    daCenter,   false,    "cnmv_corr_rsn",      false,    "",    dfNone,    0,    true,     true);
	        InitDataProperty(0, cnt++, dtHidden,     0,      daCenter,   false,    "atch_file_sav_id",   false,    "",    dfNone,    0,    true,     true);
	        InitDataProperty(0, cnt++, dtPopup,      110,    daCenter,   false,    "atch_file_sav_nm",   false,    "",    dfNone,    0,    true,     true);

	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cnmv_yr");            // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cnmv_id_no");         // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cntr_svr_id");        // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "lst_flg");            // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "bkg_cgo_tp_cd");      // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cnmv_seq");           // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cnmv_co_cd");         // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "mvmt_edi_msg_tp_id"); // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "mvmt_cre_tp_cd");     // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cntr_xch_cd");        // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "mgst_no");            // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "chss_no");            // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "inp_yd_cd");          // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "dest_yd_cd");         // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cnmv_split_no");      // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "pkup_no");            // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "wbl_no");             // 삭제시 필요조건 (EES_CTM_0440.js와 동일)
	        InitDataProperty(0, cnt++, dtHidden,     100,    daCenter,   false,    "cntr_id");            // 삭제시 필요조건 (EES_CTM_0440.js와 동일)

	        InitDataCombo(0, "cnmv_corr_rsn", cnmvCorrRsnValue, cnmvCorrRsnCode);
	        CountPosition = 0;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, frmObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		case IBSEARCH : // 조회
			if (validateForm(sheetObj, frmObj, sAction)) {
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
				var xml = sheetObj.GetSearchXml("EES_CTM_0405GS.do", FormQueryString(frmObj));
				sheetObj.LoadSearchXml(xml);
				lastRetrieveDate = ComGetEtcData(xml, "last_retrieve_date");
//				sheetObj.DoSearch4Fx("EES_CTM_0405GS.do", FormQueryString(frmObj));
			}
			break;
		case IBSAVE : // 저장
			if (sheetObj.CheckedRows("Sel") < 1) {
				ComShowCodeMessage("CTM30001");
				return;
			}

			with (sheetObj) {
				var checkIdxArr = (FindCheckedRow("Sel").substring(0, FindCheckedRow("Sel").length - 1)).split("|");

				// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
				var cntrNoArr = new Array();
				for (var i=0; i<checkIdxArr.length; i++) {
					if (CellValue(checkIdxArr[i], "cnmv_corr_rsn") == "") {
						ComShowCodeMessage("CTM00000", "Correction Reason");
						SelectCell(checkIdxArr[i], "cnmv_corr_rsn");
						return false;
					}
					cntrNoArr.push(CellValue(checkIdxArr[i], "cntr_no"));
				}

				var param = "f_cmd=" + SEARCH03;
				param += "&cntr_no=" + cntrNoArr.join(",");
				param += "&upd_dt=" + lastRetrieveDate;
				xml = GetSearchXml("EES_CTM_0430GS.do", param);
				var count = ComGetEtcData(xml, "row_count");
				if (Number(count) > 0) {
					ComShowCodeMessage("CTM30017");
					return;
				}

				if (ComShowCodeConfirm("CTM30006")) {
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					// 전역변수 초기화
					errorXml = "";
					// Object Disable
					ComOpenWait(true);
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_retrieve");
					ComBtnDisable("btn_new");
					ComBtnDisable("btn_downexcel");
					DomSetFormObjDisable(frmObj, true);
					frmObj.p_yard2.Enable = false;

					var queryString = "";
					var startIdx = 0;
					var endIdx = 0;
					var checkCount = checkIdxArr.length;
					var loopCount = 0;

					if (checkCount < (sendRows * maxThreadCount) + 1) { // check된 행갯수가 sendRows * maxThreadCount(공통)보다 작을 경우
						loopCount = Math.ceil(checkCount / sendRows);
				    } else {                                            // check된 행갯수가 sendRows * maxThreadCount(공통)보다 클 경우
				    	sendRows = Math.ceil(checkCount / maxThreadCount);
				    	loopCount = maxThreadCount;
				    }

					for (var i=1; i<=loopCount; i++) {
						if (i == loopCount) {
							endIdx = checkCount - 1;
						} else {
							endIdx += sendRows;
							var currStartIdx = Number(startIdx) + Number(endIdx);
							var currEndIdx = endIdx;
				        }

						// row data추출
						var tempString = "";
						for (var h=startIdx; h<=endIdx; h++) {
							tempString = ("&mty_repo_vl_rmk=" + CellValue(checkIdxArr[h], "mty_repo_vl_rmk"));
							queryString += ("ibflag=D&" + ComReplaceStr(RowSaveStr(checkIdxArr[h]), tempString, "") + "&");
							tempString = "";
						}

						// 전송
						xmlHttpPost ("EES_CTM_0440GS.do", queryString + "AJAX=Y&f_cmd=" + MULTI, "rtnUpdateParses", checkIdxArr[startIdx]);
						queryString = "";
				
						startIdx = endIdx + 1;
						sendCount++;
					}
					HeadCheck(0, "Sel") = false;
				}
			}

			break;
		}
	}

	function rtnUpdateParses(rtnXml, startId) {
		sendCount--;
		if (ComGetEtcData(rtnXml, "TRANS_RESULT_KEY") == "F") {
			errorXml = rtnXml;
		}

		if (sendCount < 1) {
			var frmObj = document.form;

			// Object Enable
			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_new");
			ComBtnEnable("btn_downexcel");
			DomSetFormObjDisable(frmObj, false);
			frmObj.p_yard2.Enable = true;
			ComOpenWait(false);
			sheetObjects[0].WaitImageVisible = true;

			if (errorXml != "") {
				if (sheetObjects[0].RowCount > 0) {
					// btn_del 버튼 Enable
					ComBtnEnable("btn_delete");
				} else {
					// btn_del 버튼 Enable
					ComBtnDisable("btn_delete");
				}
				sheetObjects[0].LoadSaveXml(errorXml);
			} else {
				ComShowCodeMessage("CTM10022", "Empty VL List without BKG");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		}
	}

    /**
     * HTML Object의 OnKeyUp이벤트 처리
     */
    function obj_onkeyup(event) {
        srcValue = event.srcElement.value;    // CoCtm.js의 공통스크립트의 자동실행 방지용
        var frmObj = document.form;
        var sheetObj = sheetObjects[0];

        switch(event.srcElement.name) {
            case "lcc_cd":
            // lcc_cd에 입력되는 값의 length에 따른 처리
                var lcc_cd = event.srcElement;
                // lcc_cd에 5글자가 채워지면 CTM공통함수의 code_search() 호출
                if (lcc_cd.value.length > 4) {
                    var lccChechXml = sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH13 + "&p_yard1=" + lcc_cd.value);
                    var rtnValue = ComGetEtcData(lccChechXml, "rtnValue");
                    if (rtnValue) {
                        if (rtnValue == "S") {
                            setFocusIndex(lcc_cd, 1);
                        } else {
                            ComShowCodeMessage("CTM20072");
                            lcc_cd.value = "";
                            lcc_cd.focus();
                        }
                    } else {
                        ComShowCodeMessage("CTM20072");
                        lcc_cd.value = "";
                        lcc_cd.focus();
                    }
                }
                break;

            case "yd_cd_disp":
            // yd_cd_disp에 입력되는 값의 length에 따른 처리
                var ydCdDisp = frmObj.yd_cd_disp;
                if (ydCdDisp.value.length > 1) {
                    frmObj.p_yard1.value = ydCdDisp.value.toUpperCase();
                    if (ydCdDisp.value.length > 4) {
                          // p_yard1에 5글자가 채워지면 CTM공통함수의 yard_search() 호출
                          if (!yard_search()) {
                                ydCdDisp.select();
                                ydCdDisp.focus();
                          } else {
                                frmObj.p_yard2.focus();
                          }
                    } else {
                        frmObj.p_yard2.RemoveAll();
                    }
                } else {
                    frmObj.p_yard1.value = "";
                    frmObj.p_yard2.RemoveAll();
                }
                break;

        }
        onShowErrMsg = false;

    }

    // Open Popup
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var formObj = document.form;
		var upObj = uploadObjects[0];

		var fileName = sheetObj.OpenFileDialog("파일선택");
		if (fileName.indexOf("\\") !=-1) {
			ComOpenWait(true);
			// 먼저 기존파일을 모두 지운후 추가함
			upObj.Files = "";
			var ret = upObj.AddFile(fileName);

			upObj.ExtendParam = "f_cmd=" + COMMAND06;

			var sXml = upObj.DoUpload(true);
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, "atch_file_sav_nm") = fileName;
			var fileSaveId = ComGetEtcData(sXml, "fileSaveId");
			sheetObj.CellValue2(Row, "atch_file_sav_id") = fileSaveId;
			ComOpenWait(false);
		}
    }

    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            // 조회결과가 있으면
            if (sheetObj.RowCount > 0) {
                // btn_del 버튼 Enable
                ComBtnEnable("btn_delete");
            } else {
                // btn_del 버튼 Enable
                ComBtnDisable("btn_delete");
            }
        }
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
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
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "Sel")) {
                            CellValue2(arr[i], "Sel") = "1";    // 선택된 행의 CheckBox 체크
                        }
                    }
                }
            }
        }
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,frmObj,sAction) {
		with (frmObj) {
			if (sAction == IBSEARCH) {
				if (cancelDate == false) return false;
			}
		}

		return true;
	}
