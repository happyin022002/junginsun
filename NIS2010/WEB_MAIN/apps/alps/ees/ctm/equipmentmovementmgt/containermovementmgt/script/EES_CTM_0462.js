/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : EES_CTM_0462.js
 *@FileTitle : Auto-created Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.01.27
 *@LastModifier :
 *@LastVersion : 1.0
 * 2010.01.27
 * 1.0 Creation
 * 2013.03.15 강환 [CHM-201323277] Modified event date history Inquiry (Remarks -mandatory, Gap(day) 값 변경)
=========================================================*/
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
     * @class EES_CTM_0462 : EES_CTM_0462 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0462() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }
/* 개발자 작업	*/


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var uploadObjects = new Array();
var uploadCnt = 0;

// 이벤트 시간이 잘못 된 경우 되돌리기 위한 전역 변수
var OrgValue = "";
var orgFlag = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var sheetObj = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {

                case "btn_Retrieve":
                    if (document.form.loc_cd.value == '') {
                        ComShowCodeMessage("CTM00000", "LCC/Location");
                        return;
                    }
                    if (checkFormField())
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;

                case "btn_New":
                    document.form.reset();
                    sheetObjects[0].RemoveAll();
                    // 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
                    strTime = new Date();
                    y = strTime.getYear();
                    m = strTime.getMonth() + 1;
                    d = strTime.getDate();
                    if (m < 10) m = "0" + m;
                    if (d < 10) d = "0" + d;
                    document.form.p_date2.value = y + "-" + m + "-" + d;
                    document.form.p_date1.value = ComGetDateAdd(document.form.p_date2.value, "D", -15)
                    ComBtnDisable("btn_Save");
                    ComBtnDisable("btn_eachcntr");
                    break;

                case "btn_Calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
                    }
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    break;

                case "btn_DownExcel":
                    sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Sel");
                    break;

                case "btn_eachcntr":
                    with (sheetObjects[0]) {
                        // 더블클릭한 row의 "cntr_no"컬럼 값이 있으면
                        if (ComGetLenByByte(Cellvalue(SelectRow, "cntr_no")) > 0) {
                            var cnmvEvntDt = ComGetMaskedValue(Cellvalue(SelectRow , "tar_date").substring(0,8), "ymd");
                            /*
                            ComOpenPopup("/hanjin/EES_CTM_0408.do?" +
                            "p_cntrno=" + Cellvalue(SelectRow , "cntr_no").substring(0,10) + "&" +
                            "check_digit=" + Cellvalue(SelectRow , "cntr_no").substring(10,11) + "&" +
                            "ctnr_tpsz_cd=" + Cellvalue(SelectRow , "tp_sz") //+ "&" +
                            , 1020, 682, "", "0,1");
                             */
                            ComOpenPopup("/hanjin/EES_CTM_0430.do?" +
                            "cntrNo=" + Cellvalue(SelectRow , "cntr_no").substring(0, 10) + "&" +
                            "chkDgt=" + Cellvalue(SelectRow , "cntr_no").substring(10, 11) + "&" +
                            "tpSz=" + Cellvalue(SelectRow , "tp_sz") + "&autoFlg=Y", 1020, 682, "", "0,1", true);
                        }
                    }
                    break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                alert("지금은 사용하실 수가 없습니다 ");
            } else {
                alert(e);
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
        for (i = 0; i < sheetObjects.length; i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for (i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        // 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
        strTime = new Date();
        y = strTime.getYear();
        m = strTime.getMonth() + 1;
        d = strTime.getDate();
        if (m < 10) m = "0" + m;
        if (d < 10) d = "0" + d;
        document.form.p_date2.value = y + "-" + m + "-" + d;
        document.form.p_date1.value = ComGetDateAdd(document.form.p_date2.value, "D", -15);
        ComBtnDisable("btn_eachcntr");
        ComBtnDisable("btn_Save");

        ComConfigUpload(uploadObjects[0], "/hanjin/CTMCommonGS.do");

        setEventProcess("loc_cd");
        axon_event.addListener("focusout", "yard_Change", "loc_cd");
        axon_event.addListener("keypress", "obj_keypress", "loc_cd");
    }

	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    function yard_Change(event) {
        eventElement = event.srcElement;
        // alert (obj_keyup(event))
        if (eventElement.value.length < 5) return;
        if (srcValue == eventElement.value) return;
        onShowErrMsg = false;
        rtn = loc_search();

        if (rtn == true && svrChk != 'S') {
            //alert (eventElement.value)
            ComShowCodeMessage("CTM20072");
            // alert ("사용자와 야드의 Server 정보 불 일치");
            eventElement.value = '';
            eventElement.select();
            eventElement.focus();
        } else if (rtn == true && svrChk == 'S') {
            document.form.cre_tp_cd.focus();
        } else {
            eventElement.value = '';
            eventElement.select();
            eventElement.focus();
        }
    }


    /**
     * YARD 이벤트
     * Yard Code Change혹은 Focus Out으로 발생하고 리턴은 true/false만 해준다.
     */
    function loc_search() {
        formObj = document.form;
        p_yard = formObj.loc_cd.value;

        if (p_yard.length >= 5) {
            if (onShowErrMsg) {
                onShowErrMsg = false; //이미 동일한 오브젝트에 동일한 내용으로 이벤트를 수행 하였다.
                // document.form.p_vvdcd.value = document.form.p_vvdcd.value + ":" + event.type;
                return false;
            }
            onShowErrMsg = true; // 체크 로직을 수행한다.

            var sheetObj = sheetObjects[0];
            formObj.f_cmd.value = SEARCH11;
            xml = sheetObj.GetSearchXml ("CTMCommonGS.do", FormQueryString(formObj) + "&p_yard1=" + p_yard);
            rtnValue = ComGetEtcData(xml, "rtnValue");
            svrChk = ComGetEtcData(xml, "svrChk");
            if (rtnValue == null) {
                sheetObj.LoadSearchXml(xml);
                return false;
            } else {
                return true;
            }
        } else return false;
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch (sheetNo) {
            case 1: //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 442;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(33, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "|Sel.|Seq.|STS|Container No.|T/S|BkgNo.|Origin Yard|Event Date|Creation Date|Pre STS|Pre Origin Yard|Pre Event Date|Modified|Correction Reason|File|Evidence Attached|Remark||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,    daCenter,  false,    "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,  false,    "SEQ");
                    InitDataProperty(0, cnt++, dtData,          40,    daCenter,  false,    "sts_cd",         false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          90,   daCenter,  false,    "cntr_no",        false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          40,    daCenter,  false,    "tp_sz",          false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          80,   daCenter,  false,    "bkg_no",         false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          70,    daCenter,  false,    "yd_cd",          false,    "",     dfNone,        0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,          100,   daCenter,  false,    "tar_date",       false,    "",     dfUserFormat2);
                    InitDataProperty(0, cnt++, dtData,          100,   daCenter,  false,    "cre_dt",         false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          50,    daCenter,  false,    "pre_sts",        false,    "",     dfNone,        0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,          90,    daCenter,  false,    "pre_yd_cd",      false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          100,   daCenter,  false,    "pre_evnt_dt",    false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    "mvmt_cre_tp_cd", false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,         110,   daCenter,  false,    "cnmv_corr_rsn",  false,    "",     dfNone,        0,    true,     true);
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,  false,    "atch_file_sav_id",false,   "",     dfNone,        0,    true,     true);
                    InitDataProperty(0, cnt++, dtPopup,         110,   daCenter,  false,    "atch_file_sav_nm",false,   "",     dfNone,        0,    true,     true);
                    InitDataProperty(0, cnt++, dtData,          60,    daLeft,	  false,    "cnmv_rmk", 	  false,    "",     dfNone);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "cnmv_yr",        false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "cnmv_id",        false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "event_dt",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "cnmv_seq",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "cnmv_split_no",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "fcntr_flg",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "bkg_cgo_tp_cd",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "mvmt_edi_tp_cd",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "vndr_seq",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "cnmv_cyc_no",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "imdt_ext_flg",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "crnt_vsl_cd",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "crnt_skd_dir_cd",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "crnt_skd_voy_no",       false,    "",     dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        80,    daCenter,  false,    "mvmt_edi_msg_tp_id",       false,    "",     dfNone,        0,    false,    false);

                    InitUserFormat2(0, "tar_date", "####-##-## ##:##", "-|:" );
                    CountPosition = 0;

                    InitDataCombo(0, "cnmv_corr_rsn", cnmvCorrRsnValue, cnmvCorrRsnCode);
                }
                break;
        }
    }

    function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var formObj = document.form;
		var upObj = uploadObjects[0];

		var fileName = sheetObj.OpenFileDialog("파일선택");
		if (fileName.indexOf("\\") !=-1) {
			// 먼저 기존파일을 모두 지운후 추가함
			upObj.Files = "";
			var ret = upObj.AddFile(fileName);
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, "atch_file_sav_nm") = fileName;

			upObj.ExtendParam = "f_cmd=" + COMMAND06;

			var sXml = upObj.DoUpload(true);
			var fileSaveId = ComGetEtcData(sXml, "fileSaveId");
			sheetObj.CellValue2(Row, "atch_file_sav_id") = fileSaveId;
		}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch (sAction) {
            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                    // p_date1과 p_date2가 3개월이 넘으면 return
                    if (ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "D", 15), 'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
                        ComShowCodeMessage("CTM30012", "15 days");
                        return;
                    }
                    sheetObj.RemoveAll();
                    ComBtnDisable("btn_Retrieve");
                    ComBtnDisable("btn_New");
                    ComBtnDisable("btn_eachcntr");

                    DomSetFormObjDisable(form, true);
                    ComOpenWait(true);
                    sheetObj.WaitImageVisible = false;
                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("EES_CTM_0462GS.do", FormQueryString(formObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                    // BackEnd Job호출하고 key를 리턴 받는다. 리턴 받은 키를 3초에 한번씩 서버로 보내
                    // 작업이 완료 되었는지 확인 후 완료되면 결과를 받아온다
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value = backendJobKey;
                        sheetObj.WaitImageVisible = false;
                        sheetObj.RequestTimeOut = 10000;
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                    }
                }
                break;
            case IBSAVE : //저장
            	if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = MULTI;
            	}

                StrQ = sheetObj.GetSaveString(false);
                if (StrQ == "") {
                    ComShowCodeMessage("CTM20118");
                    return;
                }

                // [CHM-201323277] [CTM] Modified event date history Inquiry (Remarks -mandatory, Gap(day) 값 변경)
                // Remark가없을 경우 중단하도록 한다.
                for (var i=1; i<=sheetObj.LastRow; i++) {
                	if (sheetObj.Cellvalue(i, "ibflag") == "U") {
                		if (sheetObj.CellValue(i, "cnmv_corr_rsn") == "") {
                			ComOpenWait(false);
                			ComShowCodeMessage("CTM00000", "Correction Reason");
                			sheetObj.SelectCell(i, "cnmv_corr_rsn");
                			return;
                		}
                	}
                }

                xml = sheetObj.doSave("EES_CTM_0462GS.do",  FormQueryString(formObj));
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
            case IBINSERT: // 입력
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
        with (formObj) {
            /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
//            if (sAction == IBSEARCH) {
//             if (cancelDate == false) return false;
//            }
        	var tmpobjValue = formObj.p_date1.value;
        	var tmpobjValue2 = formObj.p_date2.value;
            // 전체 내용중 -를 삭제.
        	
        	tmpobjValue = ComGetUnMaskedValue(tmpobjValue, "ymd");
            tmpobjValue2 = ComGetUnMaskedValue(tmpobjValue2, "ymd");
            if (!ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue2) || !ComIsDate(tmpobjValue2)) {
				return false;
            } else {
                    date1 = document.getElementById("p_date1").value;
                    date2 = document.getElementById("p_date2").value;
                    date1 = ComGetUnMaskedValue(date1, "ymd");
                    date2 = ComGetUnMaskedValue(date2, "ymd");
                    if (date1 == '' || date2 == '') return;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	formObj.p_date1.focus();
                        return false;
                    }

            }
        }
        return true;
    }


    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with (sheetObj) {
            CellBackColor(i, "EventDate") = RgbColor(204, 255, 253);
        }
    }


    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     */
    function getBackEndJobStatus() {
        formObj = document.form;
        var sheetObj1 = sheetObjects[0];
        formObj.f_cmd.value = SEARCH;
        sheetObj1.WaitImageVisible = false;
        var sXml = sheetObj1.GetSearchXml("EES_CTM_0462GS.do",
        FormQueryString(formObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")
        // alert("sheet1 :::>> jobState : "+jobState);

        if (jobState == "3") {
            getBackEndJobLoadFile();
            clearInterval(timer);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
            ComBtnEnable("btn_eachcntr");
            ComBtnEnable("btn_Save");
        } else if (jobState == "4") {
            // BackEndJob을 실패 하였습니다.
            ComShowCodeMessage('CTM10024');
            ComOpenWait(false);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
            SearchEnd(sheetObj1, "")
        } else if (jobState == "5") {
            // 이미 BackEndJob 결과 파일을 읽었습니다.
            ComShowCodeMessage('CTM10024');
            ComOpenWait(false);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
            SearchEnd(sheetObj1, "")
        }

    }

    /**
     * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)
     */
    function getBackEndJobLoadFile() {
        formObj = document.form;
        formObj.f_cmd.value = SEARCHLIST;
        ComOpenWait(false);
        var sheetObj = sheetObjects[0];
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var sXml = sheetObj.DoSearch4Fx("EES_CTM_0462GS.do", FormQueryString(formObj));
        DomSetFormObjDisable(form, false);
    }


    function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
        OrgValue = sheetObj.CellText(Row, Col);
		orgFlag = sheetObj.RowStatus(Row);
    }


    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        OrgValue = sheetObj.CellText(NewRow, NewCol);
    }


    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var SaveName = sheetObj.ColSaveName(Col);
        if (SaveName == "tar_date") {
            // Event Date를 수정한 경우 상 하 EventDate를 비교한다.
            preEvent = sheetObj.CellText(Row, "pre_evnt_dt");
            nowEvent = sheetObj.CellText(Row, Col);
            srcEvent = sheetObj.CellText(Row, "event_dt");
            // 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
            strTime = new Date();
            y = strTime.getYear();
            m = strTime.getMonth() + 1;
            d = strTime.getDate();
            if (m < 10) m = "0" + m;
            if (d < 10) d = "0" + d;
            hours = strTime.getHours();
            minutes = strTime.getMinutes();
            if (minutes < 10)
                minutes = "0" + minutes;
            if (hours < 10)
                hours = "0" + hours;
            nowDate = y + "-" + m + "-" + d + " " + hours + ":" + minutes
            if (nowEvent < preEvent) {
                ComShowCodeMessage("CTM10025");
                sheetObj.CellValue2(Row, Col) = OrgValue;
                clearStatus(sheetObj, Row);
                return;
            }
            if (nowEvent >= srcEvent) {
                ComShowCodeMessage("CTM10025");
                sheetObj.CellValue2(Row, Col) = OrgValue;
                clearStatus(sheetObj, Row);
                return;
            }
            if (nowEvent > nowDate) {
                ComShowCodeMessage("CTM10053");
                sheetObj.CellValue2(Row, Col) = OrgValue;
                clearStatus(sheetObj, Row);
                return;
            }
            sheetObj.CellValue2(Row, "del_chk") = "1";
            if (sheetObj.CellValue(Row, "cntr_no") == sheetObj.CellValue(Number(Row) + 1, "cntr_no")) {
                if (ComGetUnMaskedValue(OrgValue, 'ymdhm').replace(' ','').replace(':','') == ComGetUnMaskedValue(sheetObj.CellValue(Number(Row) + 1, "pre_evnt_dt"), 'ymdhm') && sheetObj.CellValue(Row, "sts_cd") == sheetObj.CellValue(Number(Row) + 1, "pre_sts")) {
                    sheetObj.CellValue2(Number(Row) + 1, "pre_evnt_dt") = nowEvent;
                    clearStatus(sheetObj, Number(Row) + 1);
                }
            }
        } else if (SaveName == "cnmv_corr_rsn") {
			if (orgFlag == "R") {
				sheetObj.RowStatus(Row) = "R";
			}
        }
    }

    function initCombo(comboObj, comboId) {
        var frmObj = document.form;
        with (comboObj) {
        UseCode = true;
        switch (comboId) {
            case "stsCombo":    // ComboObject Value Settting
                MultiSelect = true;
                DropHeight = 160;
                InsertItem(0, "ALL", "");
                InsertItem(1, "OP", "OP");
                InsertItem(2, "EN", "EN");
                InsertItem(3, "TN", "TN");
                InsertItem(4, "OC", "OC");
                InsertItem(5, "IC", "IC");
                InsertItem(6, "ID", "ID");
                InsertItem(7, "MT", "MT");
                InsertItem(8, "CP", "CP");
                InsertItem(9, "CT", "CT");
                InsertItem(10, "CE", "CE");
                InsertItem(11, "CO", "CO");
                InsertItem(12, "CI", "CI");
                InsertItem(13, "CD", "CD");
                InsertItem(14, "CM", "CM");
                if (frmObj.sts_cd.value != "") {
                    //Text = ComReplaceStr(frmObj.edi_mvmt_sts_cd.value, "'", "");
                } else {
                    Text = "ALL";
                }
                break;
        }
        }
    }


    /**
     * Combo1의 MultiSelection OnCheckClick 이벤트 처리
     */
    function stsCombo_OnCheckClick(comboObj, index, code) {
        var ediMvmtStsCd = document.form.edi_mvmt_sts_cd;
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (!comboObj.Text) {
            document.form.sts_cd.value = "";
            comboObj.CheckIndex(0) = true;
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
        } else if (index == 0) {
            for(var i=1; i<comboObj.GetCount(); i++) {
                comboObj.CheckIndex(i) = false;
            }
            // Submit할 내용도 Clear
            document.form.sts_cd.value = "";
            // 다른Index가 선택된 경우는 Index 0을 해제
        } else {
            comboObj.CheckIndex(0) = false;
            // Submit할 내용 Define
            document.form.sts_cd.value = "'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'";
        }
    }


/* 개발자 작업  끝 */