/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0254.js
*@FileTitle : Container Seal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.08.17 김상수
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.08.17 김상수 [CHM-201112813-01] ALPS MNR-Seal management-Inquiry (신규화면 개발)
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
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
     * @extends
     * @class ees_mnr_0254  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0254() {
        this.processButtonClick = processButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
        this.setComboObject = setComboObject;
    }

/* 개발자 작업    */


// 공통전역변수
var sheetCnt = 0;
var sheetObjects = new Array();
var comboCnt = 0;
var comboObjects = new Array();


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var frmObj = document.form;
        var sheetObj = sheetObjects[0];

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_fr_yy": //calender button
                    var cal = new ComCalendar();
                    cal.setDisplayType('year');
                    cal.select(frmObj.fr_yy, 'yyyy');
                    break;

                case "btn_to_yy": //calender button
                    var cal = new ComCalendar();
                    cal.setDisplayType('year');
                    cal.select(frmObj.to_yy, 'yyyy');
                    break;

                case "btn_Retrieve":
                    sheetObj.RemoveEtcData();
                    sheetObj.RemoveAll();
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;

                case "btn_New":
                    sheetObj.RemoveEtcData();
                    ComResetAll();
                    break;

                case "btn_DownExcel":
                    sheetObj.Down2Excel(-1);
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //MultiCombo초기화
        for(var k=0;k<comboObjects.length;k++) {
            initCombo(comboObjects[k], comboObjects[k].id);
        }

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
        ComSetFocus(document.form.fr_yy);
    }


     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
     }


    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    //ComComboObject생성자 메소드에서 호출됨
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
      * Combo 기본 설정
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initCombo(comboObj, comboId) {
        switch(comboId) {
            case "ofc_cd":
                with (comboObj) {
                    MultiSeparator = "|";
                    SetTitle("Office Code|Office Name");
                    SetColAlign("left|left");
                    DropHeight = 160;
                    UseAutoComplete = true;
                }
                break;
         }
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        with (sheetObj) {

            cnt = 0;

            // 높이 설정
            style.height = GetSheetHeight(20);

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;  //msNone; msHeaderOnly; msPrevColumnMerge;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
            InitRowInfo(1, 1, 9, 100);

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            var HeadTitle = "|Office|Plan Year|Plan Year|Kind of Seal|Plan Qty|Serial Range|Serial Range|Serial Range|Serial Range|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|G.TTL|Other Qty|Lost Qty|Current QTY";

            var headCount = ComCountHeadTitle(HeadTitle);

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(headCount, 10, 0, true);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
            InitHeadMode(true, true, true, true, false, false);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
            InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "ofc_cd",               false, "", dfNone);
            InitDataProperty(0, cnt++, dtAutoSum,      35,  daCenter, true,  "plan_year",            false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         50,  daCenter, true,  "plan_half",            false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         75,  daCenter, false, "seal_knd_nm",          false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "pln_qty",              false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         30,  daCenter, false, "seal_no_pfx_nm",       false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         70,  daCenter, false, "n1st_ser_rng_seal_no", false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         15,  daCenter, false, "seal_delim",           false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         70,  daCenter, false, "lst_ser_rng_seal_no",  false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_01",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_02",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_03",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_04",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_05",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_06",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_07",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_08",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_09",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_10",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_11",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_12",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "mm_ttl",               false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "mm_13",                false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         50,  daRight,  false, "cntr_seal_lost_qty",   false, "", dfInteger);
            InitDataProperty(0, cnt++, dtData,         80,  daRight,  false, "curr_qty",             false, "", dfInteger);

            CountPosition = 0;
            WaitImageVisible = false;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, Row, Col) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      // 조회
                if(!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                sXml = sheetObj.GetSearchXml("EES_MNR_0254GS.do", FormQueryString(frmObj));
                
                var backendJobKey1 = ComGetEtcData(sXml, "BackEndJobKey1");
                var backendJobKey2 = ComGetEtcData(sXml, "BackEndJobKey2");
					
				if (backendJobKey1.length > 0 && backendJobKey2.length > 0) {
					ComSetObjValue(frmObj.back_end_job_key1, backendJobKey1);
					ComSetObjValue(frmObj.back_end_job_key2, backendJobKey2);
					sheetObj.RequestTimeOut = 30000;	
					timer1 = setInterval(getBackEndJobStatus, 3000);
				}
                
                break;

            case IBSEARCH_ASYNC01:
                var sCondition = new Array (
                    new Array("MdmOrganization", "SEARCH", "A")
                )
                var comboList = MnrComSearchCombo(sheetObjects[0], sCondition);
                frmObj.ofc_cd.InsertItem(0, "ALL", "ALL");
                if(comboList[0] != null){
                    for(var j = 0; j < comboList[0].length;j++){
                        var tempText = comboList[0][j].split("|");
                        frmObj.ofc_cd.InsertItem(j + 1, comboList[0][j], tempText[0]);
                    }
                }
                frmObj.ofc_cd.Text = "ALL";

        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            document.form.out_qty.value = ComAddComma(sheetObj.EtcData("out_qty"));
            with (sheetObj) {
                if (SearchRows > 0) {
                    ReDraw = false;
                    CellValue2(LastRow, "plan_year") = "";
                    CellValue2(LastRow, "seal_delim") = " ";
                    RowHidden(LastRow-1) = true;
                    for (var i=SaveNameCol("pln_qty"); i < LastCol+1 ;i++) {
                        CellValue2(LastRow, i) = CellValue(LastRow-1, i);
                    }
                    ReDraw = true;
                }
            }
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with (frmObj) {
            if (!ComChkObjValid(frmObj.fr_yy)) return;
            if (!ComChkObjValid(frmObj.to_yy)) return;
        }
        return true;
    }

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
			
		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("EES_MNR_0254GS.do", FormQueryString(formObj));
		var jobState1 = ComGetEtcData(sXml, "jb_sts_flg1");
		var jobState2 = ComGetEtcData(sXml, "jb_sts_flg2");

		if (jobState1 == "3" && jobState2 == "3") {
			getBackEndJobLoadFile();			
			clearInterval(timer1);			
			ComOpenWait(false);
		} else if (jobState1 == "4" || jobState2 == "4") {
			ComShowCodeMessage("MNR00344");
			clearInterval(timer1);	
			ComOpenWait(false);
		} else if (jobState1 == "5" || jobState2 == "5") {
			ComShowCodeMessage("MNR00345");
			clearInterval(timer1);
			ComOpenWait(false);
		}
	}
	
	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
			
	    formObj.f_cmd.value = COMMAND02;	
		sheetObj.DoSearch("EES_MNR_0254GS.do",FormQueryString(formObj));	
		ComOpenWait(false);	
		sheetObj.WaitImageVisible = true;
	}	
/* 개발자 작업  끝 */
