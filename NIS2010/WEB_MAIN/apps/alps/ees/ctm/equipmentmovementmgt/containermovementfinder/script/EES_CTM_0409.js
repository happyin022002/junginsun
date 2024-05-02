/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0409.js
 * @FileTitle : Each Booking
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.05.30
 * @LastModifier : 김상현
 * @LastVersion : 1.1
 * 2009.05.25 김상수 1.0 Creation.
 * 2016.05.30 김상현 1.1 [CHM-201641787] 야드 정보 표시 기능 추가
 */

    /**
     * @extends
     * @class ees_ctm_0409 : ees_ctm_0409 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0409() {
        this.processButtonClick    = tprocessButtonClick;
        this.setSheetObject        = setSheetObject;
        this.loadPage              = loadPage;
        this.initSheet             = initSheet;
        this.doActionIBSheet       = doActionIBSheet;
        this.validateForm          = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {

        var sheetObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
                    if (!checkFormField()) return;
                    if (frmObj.bkg_no.value.trim() != "") {
                        var bkgNo = frmObj.bkg_no.value.trim();
                        // 모든객체 초기화
                        obj_clear();
                        // HTML Object에 변수값 세팅
                        frmObj.bkg_no.value =  bkgNo;
                    } else if (frmObj.bl_no.value.trim() != "") {
                        var fullBlNo = frmObj.bl_no.value.trim();
                        // 모든객체 초기화
                        obj_clear();
                        // HTML Object에 변수값 세팅
                        frmObj.bl_no.value = fullBlNo;
                    } else {
                        ComShowCodeMessage("CTM00000");
                        frmObj.bkg_no.focus();
                        return;
                    }
                    // 조회
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;

                case "btn_new":
                    // 모든객체 초기화
                    obj_clear();
                    frmObj.bkg_no.value = "";    // 팝업으로 호출시 bkg_no가 기본value이므로 다시 Clear
                    // 버튼 Disable
                    ComBtnDisable("btn_eachcntr");
                    ComBtnDisable("btn_report");
                    frmObj.bkg_no.focus();
                    break;

                case "btn_eachcntr":
                    // function sheet1_OnDblClick 호출
                    sheet1_OnDblClick(sheetObj, sheetObj.SelectRow);
                    break;

                case "btn_report":
                    // /rp [bkg_no][usrId][usrOfc][preVvd][postVvd][splitInfo]
                    //     [cntrTpszCd0][opCntrQty0][cntrTpszCd1][opCntrQty1][cntrTpszCd2][opCntrQty2]
                    // /rp [bkg_no][usrId][usrOfc]
                    //     [preVvd][postVvd][splitInfo][cntrTpszCd]
                    var paperType = "";
                    if (document.form.cnt_cd.value == "US") {
                        paperType = "/rpaper [LETTER] ";
                    } else {
                        paperType = "/rpaper [A4] ";
                    }
                    frmObj.com_mrdArguments.value = paperType + "/rp [" + frmObj.bkg_no.value + "][" + frmObj.usrId.value + "][" + frmObj.usrOfc.value + "]" +
                                                    "[" + frmObj.pre_vvd.Text + "][" + frmObj.post_vvd.Text + "][" + frmObj.split_info.Text + "][" + frmObj.cntr_tpsz_cd.Text + "]";
                    ComOpenRDPopup("resizable=yes, width=1000, height=600");
                    break;

                case "btn_close":
                    window.close();
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
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

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // CTM-COMMON
        setEventProcess();

        // 버튼 Disable
        ComBtnDisable("btn_eachcntr");
        ComBtnDisable("btn_report");

        // 로그인한 사용자의 Office코드로 Country코드를 조회
        doActionIBSheet(sheetObjects[0], document.form, COMMAND05);

        // bkg_no input에 value가 있다면 Onload시 조회
        if (document.form.bkg_no.value) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }

        // 페이지 로딩시 focus
        document.form.bkg_no.focus();
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj) {

                    // 높이 설정
                    style.height = 322;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "Seq.|Container No.|T/S|STS|Event Date|Origin YD||Return YD||Seal No.|Chassis No.|M.G Set|Update Date|Creation Date";

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtSeq,     40,     daCenter,    false,    "SEQ");
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "cntr_no",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    50,     daCenter,    false,    "cntr_tpsz_cd", false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    50,     daCenter,    false,    "mvmt_sts_cd",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "cnmv_evnt_dt", false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "org_yd_cd",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtHidden,  0,      daCenter,    false,    "org_yd_nm",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "dest_yd_cd",   false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtHidden,  0,      daCenter,    false,    "dest_yd_nm",   false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "cntr_seal_no", false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    90,     daCenter,    false,    "chss_no",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    90,     daCenter,    false,    "mgst_no",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "upd_dt",       false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "cre_dt",       false,    "",    dfNone,    0,    true,    true);

                    CountPosition = 0;
                    ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
               }
               break;

        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:    //조회
                if(validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj.DoSearch4Fx("EES_CTM_0409GS.do", "f_cmd=" + SEARCH + "&bkg_no=" + frmObj.bkg_no.value + "&bl_no=" + frmObj.bl_no.value);
                }
                break;

            case COMMAND05:
                // 로그인한 사용자의 Office코드로 국가코드를 조회
                frmObj.cnt_cd.value = ComGetEtcData(sheetObj.GetSearchXml("CTMCommonGS.do?f_cmd=" + COMMAND05), "rtnValue");
                break;
        }
    }


    /**
     * 모든객체 초기화
     */
    function obj_clear() {
        ComResetAll();
        sheetObjects[0].RemoveEtcData();
        for (i=0; i<comboObjects.length; i++) {
            comboObjects[i].RemoveAll();
        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            with (sheetObj) {
               // ETC-DATA 체크
                if (EtcData("bkg_no") != undefined) {
                    var frmObj = document.form;
                    // ETC-DATA로 넘어온 부분은 HTML의 FORM element에 셋팅
                    ComEtcDataToForm(frmObj, sheetObj);
                    // ETC-DATA로 넘어온 부분중 Combo용 데이터를 이용하여 IBMulticombo생성 (CoCtm.js)
                    parseMultiCombo(frmObj.pre_vvd, EtcData("preVvd_comboCode"), EtcData("preVvd_comboText"));
                    parseMultiCombo(frmObj.split_info, EtcData("splitInfo_comboCode"), EtcData("splitInfo_comboText"));
                    parseMultiCombo(frmObj.post_vvd, EtcData("postVvd_comboCode"), EtcData("postVvd_comboText"));
                    parseMultiCombo(frmObj.cntr_tpsz_cd, EtcData("cntrTpsz_comboCode"), EtcData("cntrTpsz_comboText"));
                    // IBMulticombo의 초기 설정값 지정
                    frmObj.pre_vvd.Code = EtcData("pre_pol_cd");
                    frmObj.split_info.Code = EtcData("split_bkg_no_split");
                    frmObj.post_vvd.Code = EtcData("post_pol_cd");
                    frmObj.cntr_tpsz_cd.Index = 0;
                    // IBMulticombo의 헤더값 설정
                    frmObj.split_info.SetTitle("Booking No.||B/L No.");
                    // btn_report 버튼 Enable
                    ComBtnEnable("btn_report");
                }
                // function sheet1_OnClick 호출 (SHEET에 조회된 데이터가 있으면 버튼 활성화)
                sheet1_OnClick(sheetObj, SelectRow, "cntr_no");
            }
        }
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            // 클릭한 row의 "cntr_no"컬럼 값이 있으면
            if (ComGetLenByByte(Cellvalue(Row, "cntr_no")) > 0) {
                // btn_eachbkg 버튼 Enable
                ComBtnEnable("btn_eachcntr");
            } else {
                // btn_eachbkg 버튼 Disable
                ComBtnDisable("btn_eachcntr");
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            // 더블클릭한 row의 "cntr_no"컬럼 값이 있으면
            if (ComGetLenByByte(Cellvalue(Row, "cntr_no")) > 0) {
                var cnmvEvntDt = Cellvalue(Row , "cnmv_evnt_dt").substring(0, 10);
                ComOpenPopup("/hanjin/EES_CTM_0408.do?" +
                             "p_cntrno=" + Cellvalue(Row , "cntr_no").substring(0, 10) + "&" +
                             "check_digit=" + Cellvalue(Row , "cntr_no").substring(10, 11) + "&" +
                             "ctnr_tpsz_cd=" + Cellvalue(Row , "cntr_tpsz_cd") + "&" +
                             "p_date1=" + ComGetDateAdd(cnmvEvntDt, "M", -1) + "&" +
                             "p_date2=" + ComGetDateAdd(cnmvEvntDt, "M", 1), 1020, 682, "", "0,1");
            }
        }
	}

	/**
	 * OnMouse event 처리
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		if (sheetObj.RowCount > 0) {
			// 마우스 위치를 행과 컬럼과 값 가져오기
			var Row = sheetObj.MouseRow;
			var Col = sheetObj.MouseCol;

			if (Row > 0) {
				switch (sheetObj.ColSaveName(Col)) {
				case "org_yd_cd" :
					var orgYdNm = sheetObj.CellValue(Row, "org_yd_nm");
					if (orgYdNm != "") {
						sheetObj.MouseToolTipText = orgYdNm;
						sheetObj.MousePointer = "Hand";
					} else {
						sheetObj.MouseToolTipText = "";
						sheetObj.MousePointer = "Default";
					}
					break;
				case "dest_yd_cd" :
					var destYdNm = sheetObj.CellValue(Row, "dest_yd_nm");
					if (destYdNm != "") {
						sheetObj.MouseToolTipText = destYdNm;
						sheetObj.MousePointer = "Hand";
					} else {
						sheetObj.MouseToolTipText = "";
						sheetObj.MousePointer = "Default";
					}
					break;
				default :
					sheetObj.MouseToolTipText = "";
					sheetObj.MousePointer = "Default";
					break;
				}
			}
		}    
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with(frmObj) {
        }
        return true;
    }


/* 개발자 작업 끝 */
