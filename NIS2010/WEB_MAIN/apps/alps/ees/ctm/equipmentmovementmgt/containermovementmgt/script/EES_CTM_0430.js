/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0430.js
 * @FileTitle : CNTR History Update
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2010-04-13
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2009.05.08 우경민 1.0 Creation
 * 2010-04-13 김상수
 * 1.98 Modify
 * --------------------------------------------------------
 * History
 * 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
 * 2013.03.15 강환 [CHM-201323277] [CTM] Modified event date history Inquiry (Remarks -mandatory, Gap(day) 값 변경)
 * 2015.09.22 김상현 1.1 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
 * 2016.07.20 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
 */
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
     * @class ees_ctm_0430 : ees_ctm_0430 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0430() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var uploadObjects = new Array();
var uploadCnt = 0;

var lastRetrieveDate = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_retrieve":    // Enter키 KeyPress시 Retrive가 되어야하므로 btn_retrieve로 네이밍 정의
                    // common_0430.js의 함수
                    btn2Retrieve();
                    break;
                case "btn_history_open" :
                	var sParam = "p_cntrno=" + document.form.p_cntrno.value;
                	sParam += "&check_digit=" + document.form.check_digit.value;
                	sParam += "&ctnr_tpsz_cd=" + document.form.ctnr_tpsz_cd.value;
                	ComOpenPopup("/hanjin/EES_CTM_0437.do?" + sParam, 1050, 650,'','0,1,1,1,1,1,1,1');
                	break;
                case "btn2_save":
                    // common_0430.js의 함수
        // [CHM-201323277] [CTM] Modified event date history Inquiry (Remarks -mandatory, Gap(day) 값 변경)
        // Remark가없을 경우 중단하도록 한다.
        with (sheetObjects[1]) {
        	for (var i=1; i<=sheetObjects[1].LastRow; i++) {
        		if (Cellvalue(i, "ibflag") == "U")
        		{
//			        if (CellValue(i, "cnmv_rmk") == "") {
//			        	if((CellValue(i, "mvmt_sts_cd") == "IC" || CellValue(i, "mvmt_sts_cd") == "TS" || CellValue(i, "mvmt_sts_cd") == "MT") && CellValue(i, "mvmt_cre_tp_cd") == "C")
//			        	{
//			        		
//			        	}
//			        	else
//			        	{
//				            RowStatus(i) = "R";
//				            ComShowCodeMessage("CTM20094");
//				            SelectCell(i, "cnmv_rmk");
//				            return;
//			        	}
//			        }
			        
			        if ((CellSearchValue(i, "mvmt_sts_cd") == "TN" || CellSearchValue(i, "mvmt_sts_cd") == "EN") && (CellValue(i - 1, "mvmt_sts_cd") == "MT")){
			        	
			        	if(CellValue(i + 1, "mvmt_sts_cd") == "OC")
			        	{
			        		var tmpCyc1 = CellText(i + 1, "cnmv_cyc_no")*1;
			        		var tmpCyc2 = CellText(i, "cnmv_cyc_no")*1;
			        		if(tmpCyc1 == tmpCyc2 + 1 )
			        		{
			        			CellValue(i, "bkg_no") = CellValue(i + 1, "bkg_no"); 
			        			CellValue(i, "bl_no") = CellValue(i + 1, "bl_no");
			        			CellValue(i, "cnmv_cyc_no") = CellValue(i + 1, "cnmv_cyc_no");
			        			CellValue(i, "bkg_cgo_tp_cd") = "F"; 
			        		}
			        	}
			        }
			        //- 2015.03.11 MT/OP(or MT/OC) not allow modification same time. One by One. 
		        	if( CellValue(i, "mvmt_sts_cd") == "OP" || CellValue(i, "mvmt_sts_cd") == "OC" ){
					    if (CellValue(i -1, "mvmt_sts_cd") == "MT" && Cellvalue(i -1, "ibflag") == "U"){
					    	ComShowCodeMessage("CTM99999","MT/OP(or MT/OC) should be saved one by one, not all together.");
                            return;
			        	}
			        }
        		}
        	}
        }
                    btn2Save();
                    break;

                case "btn2_add":
                    // common_0430.js의 함수
                    addRow();
                    break;

                case "btn2_delete":
                    // common_0430.js의 함수
                    btn2Delete();
                    break;

                case "btn_close":
                    window.close();
                    break;

                case "btn2_downexcel" :
                	sheetObjects[1].Down2Excel(0, false, false, true, "", "", false, false, "", false, "cnmv_id_no|cnmv_seq|cnmv_split_no|cntr_no|bkg_no_split|bkg_knt|bl_no|bl_no_tp|bl_no_chk|cnmv_yr|flg|cntr_tpsz_cd|vr_seq|cntr_svr_id|svr_id|mvmt_edi_tp_cd|mvmt_edi_msg_area_cd|mvmt_edi_msg_yrmondy|mvmt_edi_msg_seq|vvd_cd|ctrt_seq|lst_flg|chg_mvmt_dt_flg|cntr_xch_cd");
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
    function setSheetObject(sheetObj) {
       sheetObjects[sheetCnt++] = sheetObj;
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

        with (document.form) {
            if (p_cntrno.value != "") {
                doActionIBSheet(sheetObjects[1], document.form, SEARCH02)
            }
            if (auto_flg.value == "Y") {
                p_cntrno.readOnly = true;
                ComBtnDisable("btn_retrieve");
            }
            // 페이지 로딩시 focus
            p_cntrno.focus();
        }

        ComConfigUpload(uploadObjects[0], "/hanjin/CTMCommonGS.do");
    }

	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        switch (sheetNo) {

            case 1:    // sheet[0] init

                var cnt = 0;
                with (sheetObj) {

                    // 높이 설정
                    style.height = 80;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(16, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

//                    var HeadTitle  = "CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|Booking No.|Booking No.|TP|B/L No.|Commodity";
                    var HeadTitle  = "CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|Booking No.|Booking No.|TP|B/L No.|Commodity";

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,      29,     daCenter,    false,    "cnmv_cyc_no");
                    InitDataProperty(0, cnt++, dtData,      72,     daCenter,    false,    "vl"); 
                    InitDataProperty(0, cnt++, dtData,      45,     daCenter,    false,    "por_cd");
                    InitDataProperty(0, cnt++, dtData,      45,     daCenter,    false,    "pol_cd");
                    InitDataProperty(0, cnt++, dtData,      50,     daCenter,    false,    "Relay");
                    InitDataProperty(0, cnt++, dtData,      45,     daCenter,    false,    "pod_cd");
                    InitDataProperty(0, cnt++, dtData,      45,     daCenter,    false,    "del_cd");
                    InitDataProperty(0, cnt++, dtData,      10,     daCenter,    false,    "");
                    InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "bkg_no");
                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "bkg_no_split");
                    InitDataProperty(0, cnt++, dtData,      20,     daCenter,    false,    "bkg_cgo_tp_cd");
                    InitDataProperty(0, cnt++, dtData,      90,     daCenter,    false,    "bl_no");;
                    InitDataProperty(0, cnt++, dtData,      90,     daCenter,    false,    "rep_cmdt_nm", false,    "",    dfNone ,    0,    false,    false,    13);

//                    InitDataProperty(0, cnt++, dtData,    10,      daCenter,    false,    "rcv_term_cd");
//                    InitDataProperty(0, cnt++, dtData,    10,      daCenter,    false,    "de_term_cd");
//                    InitDataProperty(0, cnt++, dtData,    10,      daCenter,    false,    "bb_cgo_flg");

                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "rcv_term_cd");
                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "de_term_cd");
                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "bb_cgo_flg");

                    ScrollBars = 1;
                    CountPosition = 0;
                    SelectHighLight = false;
                }
                break;


            case 2:    //sheet[1] init
                // 높이 설정
                sheetObj.style.height = 282;

                // common_0430.js의 함수
                initSheet2();

                break;
        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, frmObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch (sAction) {
		case SEARCH02 : // sheet1, sheet2 조회
			if (validateForm(sheetObj, frmObj, sAction)) {
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[1].WaitImageVisible = false;
				ComOpenWait(true);
				sheetObjects[0].RemoveAll();
				sheetObjects[0].RemoveEtcData();
				sheetObjects[1].RemoveAll();
				sheetObjects[1].RemoveEtcData();
				frmObj.f_cmd.value = SEARCH;
				var xml = sheetObj.GetSearchXml("EES_CTM_0430GS.do", FormQueryString(frmObj));
				var rtnValue = xml.split("|$$|");
				sheetObjects[0].LoadSearchXml(rtnValue[1]);
				sheetObjects[1].LoadSearchXml(rtnValue[0]);
				lastRetrieveDate = ComGetEtcData(rtnValue[0], "last_retrieve_date");
				ComOpenWait(false);
				sheetObjects[0].WaitImageVisible = true;
				sheetObjects[1].WaitImageVisible = true;
			}
			break;
		case MULTI : // sheet2 저장
			if (validateForm(sheetObj, frmObj, sAction)) {
				if (sheetObj.GetSaveString(false) == "") {
					ComShowCodeMessage("CTM20118");
					return;
				}

				// Insert, Update가 있을 경우, 현재 화면에 출력된 데이터가 최신인지 아닌지 check logic 추가
				var sRowStr = sheetObj.FindStatusRow("I|D");
				if (sRowStr.length > 0) {
					var param = "f_cmd=" + SEARCH03;
					param += "&cntr_no=" + document.form.p_cntrno.value + document.form.check_digit.value;
					param += "&upd_dt=" + lastRetrieveDate;
					var xml = sheetObj.GetSearchXml("EES_CTM_0430GS.do", param);
					var rowCount = ComGetEtcData(xml, "row_count");
					if (Number(rowCount) > 0) {
						ComShowCodeMessage("CTM30017");
						return;
					}
				}

				sheetObj.RemoveEtcData();
				sheetObj.doSave("EES_CTM_0430GS.do", "f_cmd=" + MULTI);
			}
			break;
        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            with (sheetObj) {
                CellFont("FontBold", 1, "bkg_no", LastRow, "bkg_no") = true;
                ColFontColor("bkg_no") = RgbColor(0, 0, 255);
                ColFontUnderline("bkg_no") = true;
                DataLinkMouse("bkg_no") = true;
                SelectCell(LastRow, 0);
            }
        }
    }


    /**
     * Bkg Inquiry 호출
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var SaveName = sheetObj.ColSaveName(Col);
        if (SaveName != "bkg_no") return;
        var bkgNo = sheetObj.CellValue(Row, SaveName);
        var param = "?bkg_no="+ bkgNo +
                    "&isPop=N" +
                    "&pgmNo=ESM_BKG_0079_Q";
        ComOpenPopup("/hanjin/ESM_BKG_0079_Q.do" + param, 1024, 730, "", "0,1");
    }

    // 화면 폼입력값에 대한 유효성검증 프로세스 처리
	function validateForm(sheetObj, frmObj, sAction) {
		switch(sAction) {
		case MULTI : // sheet2 저장
			with (sheetObj) {
				var sRowStr = FindStatusRow("U|I|D");
				var arr = sRowStr.split(";");

				if (CellText(LastRow,"mvmt_sts_cd") == "OP" && CellText(LastRow,"bkg_no") == "") {
					ComShowCodeMessage("CTM10012");
					return false;
				}

				for (var i=0; i<arr.length - 1; i++) {
					if (CellValue(arr[i], "ibflag") == "U" || CellValue(arr[i], "ibflag") == "I") {
						if (CellValue(arr[i], "mvmt_sts_cd") == "VL" || CellValue(arr[i], "mvmt_sts_cd") == "VD") {
							if (CellValue(arr[i], "cntr_id") == "" || CellValue(arr[i], "cntr_id") == null) {
								ComShowCodeMessage("CTM00000", "VVD Code");
								RowStatus(arr[i]) = "R";
								SelectCell(arr[i], "cntr_id", true);
								return false;
							}
						}
					}
					if (CellValue(arr[i], "cnmv_corr_rsn") == "") {
						ComShowCodeMessage("CTM00000", "Correction Reason");
                        CellEditable(arr[i], "cnmv_corr_rsn") = true;
                        CellEditable(arr[i], "atch_file_sav_id") = true;
                        CellEditable(arr[i], "atch_file_sav_nm") = true;
						SelectCell(arr[i], "cnmv_corr_rsn");
						return false;
					}
				}
			}
		case SEARCH02 :
			with (frmObj) {
				frmObj.p_cntrno.value = frmObj.p_cntrno.value.trim();
				if (frmObj.p_cntrno.value == null || frmObj.p_cntrno.value == "") {
					ComShowCodeMessage("CTM00000", "container");
					ComSetFocus(frmObj.p_cntrno);
					return false;
				}
			}
			break;
		}
		return true;
	}

    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var rtnStr = sheetObj.EtcData("rtnStr");
            if (rtnStr != null && rtnStr != "" && rtnStr !=  "undefined") {
                ComShowMessage(rtnStr);
            } else {
                // 팝업으로 호출되었을때의 처리
                if (document.form.auto_flg.value == "Y") {
                    var opener = window.dialogArguments;
                    objSheet = opener.document.form.sheet1;
                    for (var lpCnt = 1; lpCnt < objSheet.LastRow; lpCnt++) {
                        var pCntrNo = objSheet.CellValue(lpCnt, "cntr_no");
                        var cCntrNo = frmObj.p_cntrno.value + frmObj.check_digit.value;
                        if (cCntrNo == pCntrNo) {
                            objSheet.RowEditable(lpCnt) = false;
                            rSts = objSheet.RowStatus(lpCnt);
                            objSheet.CellValue2(lpCnt, "mvmt_cre_tp_cd") = "Y";
                            objSheet.RowStatus(lpCnt) = rSts;
                        }
                    }
                }
                ComShowCodeMessage("CTM10022", "CNTR History Update");
            }
            doActionIBSheet(sheetObj, document.form, SEARCH02);
        }
    }


    /**
     * Sheet2의 OnSearchEnd 이벤트 처리
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            if (sheetObj.RowCount > 0) {
                ComBtnEnable("btn2_add");
                ComBtnEnable("btn2_delete");
                ComBtnEnable("btn2_save");
                // common_0430.js의 함수
                row_Editable4Sheet2();

            } else {
                ComBtnDisable("btn2_add");
                ComBtnDisable("btn2_delete");
                ComBtnDisable("btn2_save");
            }
        }
    }


    /**
     * 그 외 common_0430.js에 정의된 함수 (반드시 참조할것)
     *
     * function deleteCondition(rmSubstr)
     * function deleteRow(sheetObj, Row)
     * function row_Editable4Sheet2()
     * function sheet2_OnChange(sheetObj, Row, Col, Value)
     * function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH)
     */


/* 개발자 작업 끝 */