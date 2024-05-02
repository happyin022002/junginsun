/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0440.js
 * @FileTitle : VL/VD correction by VVD
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.06.02
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.06.02 1.0 Creation.
 * 2016.09.19 김상현 [CHM-201643119] VD row delete시 IC/TS/MT까지 일괄 삭제 (VL/VD Correction by VVD화면)
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
     * @class ees_ctm_0440 : ees_ctm_0440 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0440() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var uploadObjects = new Array();
var uploadCnt = 0;

var toDay = "";
var OrgValue = "";
var orgFlag = "";

var lastRetrieveDate = "";
	/**
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;

	/**
	 * Button event 처리
	 */
    function processButtonClick() {
        var formObject = document.form;
        var sheetObject = sheetObjects[0];

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            case "btn_retrieve" :
            	if (!checkFormField()) return;
            	sheetObject.WaitImageVisible = false;
            	doActionIBSheet(sheetObject, formObject, IBSEARCH);
            	sheetObject.WaitImageVisible = true;
            	break;

            case "btn_new" :
            	DomSetFormObjDisable(formObject, false);
            	formObject.p_yard2.Enable = true;
            	ComResetAll();
            	formObject.p_yard1.focus();
            	break;

            case "btn_update" :
            	sheetObject.WaitImageVisible = false;
            	doActionIBSheet(sheetObject, formObject, IBSAVE); // 저장
            	sheetObject.WaitImageVisible = true;
            	break;

            case "btn_delete" :
            	// "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
            	var sRowStr = sheetObject.FindCheckedRow("del_chk");
            	// 자바 스크립트 배열로 만들기
            	var arr = sRowStr.split("|");
            	var stsCond = formObj.p_status.value ;
            	for (i=0; i<arr.length - 1; i++) {
            		if (sheetObject.RowEditable(arr[i]) == true) {
            			// 2016.03.30 김상현 [CHM-201640816] Correction Reason 기능 추가1
            			//  - Correction reason 필수 입력 값으로 수정
            			if (sheetObject.CellValue(arr[i], "cnmv_corr_rsn") == "") {
                            ComShowCodeMessage("CTM00000", "Correction Reason");
                            sheetObject.SelectCell(arr[i], "cnmv_corr_rsn");
                            break;
            			}

            			sheetObject.RowStatus(arr[i]) = "D";  // 삭제를 위해 선택row의 Status를 D로 변경
            			sheetObject.RowHidden(arr[i]) = true; // 선택row를 숨김

            			var sts = sheetObject.CellValue(arr[i], "mvmt_sts_cd");
            			if (stsCond == "VD") {
            				if (sts == "VD") {
            					sheetObject.RowStatus(Number(arr[i]) + 1) = "D";  // 삭제를 위해 선택row의 Status를 D로 변경
            					sheetObject.RowHidden(Number(arr[i]) + 1) = true; // 선택row를 숨김
            					sheetObject.CellValue(Number(arr[i]) + 1, "cnmv_corr_rsn") = sheetObject.CellValue(arr[i], "cnmv_corr_rsn");
            				} else if (sts == "IC") {
            					sheetObject.RowStatus(arr[i] - 1) = "D";  // 삭제를 위해 선택row의 Status를 D로 변경
            					sheetObject.RowHidden(arr[i] - 1) = true; // 선택row를 숨김
            					sheetObject.CellValue(arr[i] - 1, "cnmv_corr_rsn") = sheetObject.CellValue(arr[i], "cnmv_corr_rsn");
            				}
            			}
            		}
            	}
            	break;

            case "btn_Calendar1" :
            	var cal = new ComCalendar();
            	cal.select(formObject.p_date0, 'yyyy-MM-dd');
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
     * DATE 값이 변경 되었을 때 값의 유효성을 체크
     */
	function checkDate(obj) {
		obj = event.srcElement;
		objValue = obj.value;

		// 전체 내용중 -를 삭제.
		objValue = ComGetUnMaskedValue(objValue, "ymd")
		if (!ComIsDateTime(objValue)) {
			ComShowCodeMessage("CTM00001");
			obj.value = objValue;
			obj.select();
			obj.focus();
			return;
		} else {
			objValue = ComGetMaskedValue(objValue, "ymd");
			obj.value = objValue;
			if (obj.name == "p_date1") {
				document.form.p_date2.select();
				document.form.p_date2.focus();
			}
		}
	}


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
           //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // IBMultiCombo초기화
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }

        // setEventProcess : 이벤트를 자동으로 생성한다. 파라미터로 넘어간 경우는 이벤트를 만들지 않고 반환한다.
        setEventProcess("p_yard1");
        axon_event.addListener("keypress", "obj_keypress", "p_yard1");
        axon_event.addListener("keyup", "yard_Change", "p_yard1");

        document.form.p_yard1.focus();
        ComConfigUpload(uploadObjects[0], "/hanjin/CTMCommonGS.do");
    }


    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboNo) {
        var formObject = document.form
        //var comboKey = COUNTRY;
        switch(comboNo) {
            case 1:
                with (comboObj) {
                    MultiSelect = false;
                    SetColAlign("left|left");
                    SetColWidth("30|200");
                    BackColor = "#EFEFEF";
                    FontColor = "#373737";
                    ColBackColor(0) = "#EFEFEF";
                    ColFontColor(0) = "#373737";
                    ColBackColor(1) = "#EFEFEF";
                    ColFontColor(1) = "#373737";
                    DropHeight = 160;
                }
                break;

            case 2:
                with (comboObj) {
                    MultiSelect = true;
                    SetColAlign("left|left");
                    SetColWidth("30|200");
                    BackColor = "#EFEFEF";
                    FontColor = "#373737";
                    ColBackColor(0) = "#EFEFEF";
                    ColFontColor(0) = "#373737";
                    ColBackColor(1) = "#EFEFEF";
                    ColFontColor(1) = "#373737";
                    DropHeight = 160;
                }
                break;
        }
    }


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;

		switch(sheetNo) {
		case 1 : //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 422;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(56, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "||Seq.|Container No.|T/S|CYC|STS|A/F||Origin YD|Origin YD|Event Date|VVD Code|Booking No.|Booking No.|Booking No.|B/L No.|F/M|I/O|MSG|TP|DM|D|E|R|SP|S/P|S/P|Mode|Correction Reason|File|Evidence Attached|Remark(s)|Update Date|Creation Date|Office|User Name|CNMV YR|CNMV SEQ|CNT";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 :   ROW,	COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,      30,   daCenter,  false,     "ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,      30,    daCenter,  false,     "del_chk",     false,          "",      dfNone      );
				InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,     "SEQ");
				InitDataProperty(0, cnt++ , dtData,      95,    daCenter,  false,     "cntr_no",  false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,     "cntr_tpsz_cd",     		false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      30,    daCenter,	 false,     "cnmv_cyc_no",  			false,          "",      dfNone,  			0,    false,		true);

				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "mvmt_sts_cd",     		false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,     "mvmt_cre_tp_cd",    			false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtHidden,      75,    daCenter,	 false,     "org_yd_cd",   	false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      55,    daCenter,	 false,     "org_yd_cd1",   	false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      30,    daCenter,	 false,     "org_yd_cd2",   	false,          "",      dfNone,  			0,    false,		true, 2);
				InitDataProperty(0, cnt++ , dtData,      115,   daCenter,  false,     "cnmv_evnt_dt",     	false,          "",      dfUserFormat2, 0,    true,		true);

				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "vvl_id",     		false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      20,    daCenter,	 false,     "bkg_knt",  	false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      95,    daCenter,  false,     "bkg_no",   false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      25,    daCenter,  false,     "bkg_no_split",   false,          "",      dfNone,  			0,    false,		true);
				InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,     "bl_no",     	false,          "",      dfNone,  			0,    false,		true);

                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,	 false,     "fcntr_flg",  				false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,     "ob_cntr_flg",     		false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "mvmt_inp_tp_cd",    		false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,	 false,     "bkg_rcv_term_cd",   			false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,     "cntr_dmg_flg",  			  false,          "",      dfNone,  			0,    false,		true);

                     InitDataProperty(0, cnt++ , dtData,      20,    daCenter,  false,     "cntr_disp_flg",     			false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      20,    daCenter,	 false,     "imdt_ext_flg",  				false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      20,    daCenter,  false,     "cntr_rfub_flg",   				false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,     "spcl_cgo_flg",   			false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "vndr_seq",     	false,          "",      dfNone,  			0,    false,		true);

                     InitDataProperty(0, cnt++ , dtData,      80,    daLeft,	 false,     "vndr_lgl_eng_nm",   		false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "mvmt_trsp_mod_cd",   		false,          "",      dfNone,  			0,    false,		true);
                     // 2016.03.30 김상현 [CHM-201640816] Correction Reason 기능 추가1
                     //  - Correction reason 추가
                     InitDataProperty(0, cnt++, dtCombo,        110,    daCenter,    false,    "cnmv_corr_rsn",      false,    "",    dfNone,        0,    true,     true);
                     InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    false,    "atch_file_sav_id",   false,    "",    dfNone,        0,    true,     true);
                     InitDataProperty(0, cnt++, dtPopup,        110,    daCenter,    false,    "atch_file_sav_nm",   false,    "",    dfNone,        0,    true,     true);
                     InitDataProperty(0, cnt++ , dtData,      500,   daLeft,  	 false,     "cnmv_rmk",   	false,          "",      dfNone,  			0,    true,		true);
                     InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "upd_locl_dt",     	false,          "",      dfUserFormat2, 0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "cre_locl_dt",     	false,          "",      dfUserFormat2, 0,    false,		true);
                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,	 false,     "ofc_cd",  		false,          "",      dfNone,  			0,    false,		true);

                     InitDataProperty(0, cnt++ , dtData,      100,   daLeft,  	 false,     "usr_nm",   		false,          "",      dfNone,  			0,    false,		true);

                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cnmv_yr",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cnmv_id_no",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cnmv_seq",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cnmv_co_cd",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "mvmt_edi_msg_tp_id",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cntr_xch_cd",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "mgst_no",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "chss_no",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "inp_yd_cd",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "dest_yd_cd",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cnmv_split_no",   	false,          "",      dfNone,  			0,    true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "pkup_no",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "wbl_no",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cntr_id",   	false,          "",      dfNone,  			0,    false,		true);

                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cnt",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "lst_flg",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "bkg_cgo_tp_cd",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "vl_date",   	false,          "",      dfNone,  			0,    false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      100,   daLeft,  	 false,     "cntr_svr_id",   	false,          "",      dfNone,  			0,    false,		true);

                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "upd_locl_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:" );
                     
                     InitDataValid(0, "org_yd_cd2", vtEngUpOther, "1234567890");    // 영대문자+숫자만

                     InitDataCombo(0, "cnmv_corr_rsn", cnmvCorrRsnValue, cnmvCorrRsnCode);

                     CountPosition = 0;
                     FrozenCols = 7;
                     SelectHighLight = false;
                }
                 break;

         }
     }

	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		case IBSEARCH : // 조회
			sheetObj.RemoveAll();
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
			var xml = sheetObj.GetSearchXml("EES_CTM_0440GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(xml);
			lastRetrieveDate = ComGetEtcData(xml, "last_retrieve_date");
			ComOpenWait(false);
			break;
		case IBSAVE : // 저장
			// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
			var sRowStr = sheetObj.FindStatusRow("D");
			var rowIndexs = sRowStr.split(";");
			var cntrNoArr = new Array();
			for (var i=0; i<rowIndexs.length - 1; i++) {
				cntrNoArr.push(sheetObj.CellValue(rowIndexs[i], "cntr_no"));
			}

			var param = "f_cmd=" + SEARCH03;
			param += "&cntr_no=" + cntrNoArr.join(",");
			param += "&upd_dt=" + lastRetrieveDate;
			var xml = sheetObj.GetSearchXml("EES_CTM_0430GS.do", param);
			var rowCount = ComGetEtcData(xml, "row_count");
			if (Number(rowCount) > 0) {
				ComShowCodeMessage("CTM30017");
				return;
			}

			if (validateForm(sheetObj, formObj, sAction)) {
            	// 삭제 data의 경우, 'VD' 처리에 대해서 재 검토 로직 추가
            	var sRowStr = sheetObj.FindCheckedRow("del_chk");
            	var arr = sRowStr.split("|");
            	for (i=0; i<arr.length - 1; i++) {
        			if (sheetObj.RowStatus(arr[i]) == "D" && sheetObj.CellValue(arr[i], "mvmt_sts_cd") == "VD") {
        				if (!(sheetObj.CellValue(Number(arr[i]) + 1, "mvmt_sts_cd") == "IC" || sheetObj.CellValue(Number(arr[i]) + 1, "mvmt_sts_cd") == "MT" || sheetObj.CellValue(Number(arr[i]) + 1, "mvmt_sts_cd") == "TS")
        					|| sheetObj.RowStatus(Number(arr[i]) + 1) != "D") {
        					ComShowCodeMessage("CTM20093");
							ComOpenWait(false);
							return;
        				}
        			}
            	}

				if (ComShowCodeConfirm("COM12147", "Origin YD")) { // 'Do you want to update {?msg1}?';
        			// if (sheetObj.isDataModified && sParam1 == "") return;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					startId = 1;

        			// 속도 향상을 위해 Ajax를 사용하여 내용을 최대 10개의 단위로 서버로 전송한다.
        			// MultiThread를 처리하기 위함.. xmlHttpPost는 CoCtm에 등록되어 있다
					while (startId <= sheetObj.LastRow) {
						queryString = getFastString(sheetObj, startId, sendRows, true);
						if (queryString[0] == 0 && sendCount == 0) {
							ComShowCodeMessage("CTM20118");
							ComOpenWait(false);
							return;
						} else if (queryString[0] > 0) {
							xmlHttpPost("EES_CTM_0440GS.do", queryString[1] + "&AJAX=Y&" + FormQueryString(formObj), "rtnUpdateParses", startId, true);
							sendCount++;
						}
						startId = Number(queryString[0]) + 1;
					}
				}
			}
			break;
		}
	}

   	function rtnUpdateParses(rtnXml, startId) {
		// 마지막 Line까지 처리가 끝나면 (서버로 전송할 때 sendCount를 1 증가 시키고 리턴이 올 때마다 1 감소시킨다.
		// 결과가 0이 되면 모든 return이 들어온 것으로 처리된다.
   		sendCount--;
   		var sheetObj = sheetObjects[0];
   		if (sendCount < 1) {
   			ComOpenWait(false);
   			sheetObj.LoadSaveXml(rtnXml);
   		}
   	}

   	/**
   	 * Search 완료 후에 editable setting
   	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if (sheetObj.RowCount > 0) {
				var frmObj = document.form;
				ComBtnEnable("btn_delete", "btn_update");
				sheetObj.ReDraw = false;

				for (i=1; i<=sheetObj.LastRow; i++) {
					cnt = sheetObj.CellValue(i, "cnt");
					stsCond = formObj.p_status.value;
					sts = sheetObj.CellValue(i, "mvmt_sts_cd");

					if (stsCond == "VL") {
						// VL일 경우 마지막 Row는 Delete 할때  Booking을 호출하게 된다. 마지막이라는 Flag를 가지고 있어야만 처리
						// 가능(java에서 처리하면 너무 복잡하다)하기 때문에 마지막 Row에 Flag를 가지도록 한다
						if (cnt != "1" || sts != "VL") {
							sheetObj.RowEditable(i) = false;
							sheetObj.CellEditable(i, "cnmv_rmk") = true;
							sheetObj.RowBackColor(i) = sheetObj.RgbColor(180, 252, 200);
							sheetObj.CellValue2(i, "cnmv_rmk") = "Next movement already created";
							sheetObj.CelLValue2(i, "lst_flg") = "";
							sheetObj.RowStatus(i) = "R";
						} else {
							sheetObj.CelLValue2(i, "lst_flg") = "1";
							sheetObj.RowStatus(i) = "R";
						}
					} else if (stsCond == "VD") {
						// VD일 경우 마지막 Row는 Delete 할때  Booking을 호출하게 된다. 마지막이라는 Flag를 가지고 있어야만 처리
						// 가능(java에서 처리하면 너무 복잡하다)하기 때문에 마지막 Row에 Flag를 가지도록 한다
						if (cnt != "2") {
							if (sheetObj.CellValue(i, "mvmt_cre_tp_cd") == "A" || sheetObj.CellValue(i, "mvmt_cre_tp_cd") == "C" || sheetObj.CellValue(i, "mvmt_cre_tp_cd") == "N") {
								sheetObj.RowHidden(i) = true;
							}
							sheetObj.RowEditable(i) = false;
							sheetObj.CellEditable(i, "cnmv_rmk") = true;
							sheetObj.RowBackColor(i) = sheetObj.RgbColor(180, 252, 200);
							sheetObj.CellValue2(i, "cnmv_rmk") = "You could delete 'VD' status in case last movement is IC, MT, TS which is automatically created after VD";
							sheetObj.CelLValue2(i, "lst_flg") = "";
							sheetObj.RowStatus(i) = "R";
						} else {
							if (sheetObj.CellValue(i, "mvmt_cre_tp_cd") == "C") {
								sheetObj.CelLValue2(i, "lst_flg") = "";
								sheetObj.RowHidden(i) = true;
								sheetObj.RowStatus(i) = "R";
							} else {
								sheetObj.CelLValue2(i, "lst_flg") = "1";
								sheetObj.RowStatus(i) = "R";
							}
						}
					}
				}
				sheetObj.ReDraw = true;
			}

			var param = "";
			param += "f_cmd=" + SEARCH01 + "&p_status=" + frmObj.p_status.value + "&p_yard1=" + frmObj.p_yard1.value;
			param += "&p_yard2=" + frmObj.p_yard2.value + "&p_date0=" + frmObj.p_date0.value + "&p_vvdcd=" + frmObj.p_vvdcd.value + "&p_type=" + frmObj.p_type.value;

     		var xmlStr = sheetObj.GetSearchXml("EES_CTM_0440GS.do", param);
     		for (i=1; i<=sheetObj.RowCount; i++) {
     			if (ComGetEtcData(xmlStr, "yd_cd").indexOf(sheetObj.CellValue(i, "org_yd_cd1")) >= 0) {
	     			if (ComGetEtcData(xmlStr, "yd_cd").indexOf(sheetObj.CellValue(i, "org_yd_cd")) < 0) {
	     				sheetObj.RowEditable(i) = true;
	     				sheetObj.CellBackColor(i, "org_yd_cd2") = sheetObj.RgbColor(0, 0, 0);
	     				sheetObj.CellEditable(i, "org_yd_cd2") = true;
	     				editCorrectionReason(sheetObj, i);
	     			}
     			}
     		}
        }
        ComOpenWait(false);

        if (sheetObj.RowCount > 0) {
        	// ComOpenWait후에 DomSetFormObjDisable을 실핼해야 하므로
        	DomSetFormObjDisable(frmObj, true);
        	frmObj.p_yard2.Enable = false;
        }
    }

	/**
	 * 저장 함수를 이용하여 저장이 완료되면 다시 조회
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg != "[object]") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
	}

	/**
	 * Data 변경시 발생 event.
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		sts = sheetObj.CellValue(Row, "mvmt_sts_cd");
		vl_date = sheetObj.CellValue(Row, "vl_date");
		cellDate = sheetObj.CellText(Row, "cnmv_evnt_dt");
		stsCond = formObj.p_status.value ;

		if (sheetObj.ColSaveName(Col) == "org_yd_cd2") {
			sheetObj.CellValue2(Row, "org_yd_cd") = sheetObj.CellValue(Row, "org_yd_cd1") + sheetObj.CellValue(Row, "org_yd_cd2");
		} else if (sheetObj.ColSaveName(Col) == "cnmv_corr_rsn" || sheetObj.ColSaveName(Col) == "atch_file_sav_id" || sheetObj.ColSaveName(Col) == "atch_file_sav_nm") {
			if (sts == "VD" && stsCond == "VD") {
				sheetObj.CellValue(Number(Row) + 1, "cnmv_corr_rsn") = sheetObj.CellValue(Row, "cnmv_corr_rsn");
			}
			if (orgFlag == "R") {
				sheetObj.RowStatus(Row) = "R";
				return;
			}
		} else {
			// Origin YD 수정시는 날짜 체크 제외
			// 이전 시간에 대해 점검한다.
			if (vl_date > cellDate) {
				ComShowCodeMessage("CTM10025"); // Message : Event date should be between previous & following event date.
				sheetObj.CellValue2(Row, Col) = OrgValue;
				clearStatus(sheetObj, Row);
				return;
			}

			// 오늘 이후 자료를 넣을 수 없도록 제한한다.
			var today = new Date();
			var y = today.getFullYear().toString();
			var m = (today.getMonth() + 1).toString();
			if (m.length == 1) {
				m = 0 + m;
			}
			var d = today.getDate().toString();
			if (d.length == 1) {
				d = 0 + d;
			}

			var ymd = y + m + d;
			cellDate = sheetObj.CellValue(Row, "cnmv_evnt_dt").substring(0, 8);

			if (ymd < cellDate) {
				//alert ("Event date should be between previous & following event date")
				ComShowCodeMessage("CTM10025");
				sheetObj.CellValue2(Row, Col) = OrgValue;
				clearStatus(sheetObj, Row);
				return;
			}
		}

		if (sts == "VD" && stsCond == "VD") {
			sheetObj.CellValue(Number(Row) + 1, "cnmv_evnt_dt") = sheetObj.CellValue(Row, "cnmv_evnt_dt");
			editCorrectionReason(sheetObj, Row);
		}
		sheetObj.CellValue2(Row, 1) = 1;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
		case IBSAVE : // 저장
			var sRowStr = sheetObj.FindStatusRow("U|I|D");
			var arr = sRowStr.split(";");

			for (var i=0; i<arr.length - 1; i++) {
				if (sheetObj.CellValue(arr[i], "cnmv_corr_rsn") == "") {
					ComShowCodeMessage("CTM00000", "Correction Reason");
					sheetObj.SelectCell(arr[i], "cnmv_corr_rsn");
					return false;
				}
			}
		}

		return true;
	}

    function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
        OrgValue = sheetObj.CellText(Row, Col);
        orgFlag = sheetObj.RowStatus(Row);
    }

	/**
	 * 야드가 변경 되었을 경우 야드를 체크한다
	 */
    function yard_Change(event) {
    	eventElement = event.srcElement;
        // 야드가 5자리를 채우지 못했을 경우 다음으로진행하지 않음.
        if (eventElement.value.length < 5) return;
        if (srcValue == eventElement.value) return;
        document.form.p_yard2.RemoveAll();
        onShowErrMsg = false;

        // 야드를 체크하는 함수는 CTM 공통임. 결과를 S/F로 리턴한다
        var rtn = yard_search();
        // 유효하지 않은 야드를 리턴했을 경우 yard2를 모두 지우고 경고창을 출력한 후 야드로 포커스를 이동한다.
        if (rtn && svrChk != "S") {
            document.form.p_yard2.RemoveAll();
            ComShowCodeMessage("CTM20072");
            eventElement.select();
            eventElement.focus();
            return;
        }

        if (rtn) {
            if (curKeyCode == "9") {
                // 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
                curKeyCode = "";
                srcValue = event.srcElement.value;
            } else {
                objTmp = setFocusIndex(eventElement, 1);
                try {
                    objTmp.focus();
                } catch (e) {}
                curKeyCode = "";
                srcValue = event.srcElement.value;
                return;
            }
        } else {
            eventElement.select();
            eventElement.focus();
        }
    }

    /**
     * File Upload.
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
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
	 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
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
		with (sheetObj) {
			// row클릭시 해당 Check Box도 체크
			if (sheetObj.ColSaveName(Col) != "del_chk") {
				// "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
				var sRowStr = GetSelectionRows("/");
				var arr = sRowStr.split("/");

				if (arr.length > 1) {
					for (i=0; i<arr.length; i++) {
						if (CellEditable(Row, "del_chk")) {
							CellValue2(arr[i], "del_chk") = "1";    // 선택된 행의 CheckBox 체크
						}
					}
				}
			} else {
				if (CellValue(Row, "mvmt_sts_cd") == "VD") {
					CellValue2(Row + 1, Col) = (Value == 0 ? 1 : 0);
				}
			}
		}
	}

	/**
	 * 2016.03.30 김상현 [CHM-201640816] Correction Reason 기능 추가1
	 *  - 수정 가능한 Row나 Cell이 있을 경우, correction reason 수정할 수 있도록 허용
	 * @param sheetObject
	 * @param rowIndex
	 */
	function editCorrectionReason(sheetObject, rowIndex) {
		sheetObject.CellEditable(rowIndex, "cnmv_corr_rsn") = true;
		sheetObject.CellBackColor(rowIndex, "cnmv_corr_rsn") = sheetObject.RgbColor(0, 0, 0);
		sheetObject.CellEditable(rowIndex, "atch_file_sav_id") = true;
		sheetObject.CellEditable(rowIndex, "atch_file_sav_nm") = true;
		sheetObject.CellBackColor(rowIndex, "atch_file_sav_nm") = sheetObject.RgbColor(0, 0, 0);
//		sheetObject.CellEditable(rowIndex, "cnmv_rmk") = true;
//		sheetObject.CellBackColor(rowIndex, "cnmv_rmk") = sheetObject.RgbColor(0, 0, 0);
    }
