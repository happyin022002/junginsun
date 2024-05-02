/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0408.js
 * @FileTitle : Each Container
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015.09.22
 * @LastModifier : 김상현
 * @LastVersion : 1.1
 * 2009.05.19 김상수 1.0 Creation.
 * 2015.09.22 김상현 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
 * 2016.06.10 김상현 [CHM-201641731] VGM 항목 추가
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
     * @class ees_ctm_0408 : ees_ctm_0408 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0408() {
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


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Calendar":
                    var cal = new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    break;

                case "btn_retrieve":
                	
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObj, frmObj, SEARCH01, 1);
                    break;

                case "btn_new":
                    ComResetAll();
                    // 팝업으로 호출시 Request로 넘어온 기본value 다시 Clear
                    frmObj.p_cntrno.value = "";
                    frmObj.check_digit.value = "";
                    frmObj.ctnr_tpsz_cd.value = "";
                    frmObj.p_date1.value = frmObj.temp_date1.value;
                    frmObj.p_date2.value = frmObj.temp_date2.value;
                    // btn_eachbkg 버튼 Disable
                    ComBtnDisable("btn_eachbkg");
                    frmObj.p_cntrno.focus();
                    break;

                case "btn_eachbkg":
                    // function sheet1_OnDblClick 호출
                    sheet1_OnDblClick(sheetObj, sheetObj.SelectRow);
                    break;

                case "btn_delhist":
                    if (validateForm(sheetObj, frmObj)) {
                        ComOpenPopup("/hanjin/EES_CTM_0415.do?" +
                                     "p_cntrno=" + frmObj.p_cntrno.value + "&" +
                                     "check_digit=" + frmObj.check_digit.value + "&" +
                                     "ctnr_tpsz_cd=" + frmObj.ctnr_tpsz_cd.value + "&" +
                                     "p_date1=" + frmObj.p_date1.value + "&" +
                                     "p_date2=" + frmObj.p_date2.value, 1020, 682, "", "0,1");
                    }
                    break;

                case "btn_close":
                    window.close();
                    break;
                    
                case "btn_bkg_inquiry":
                	if (sheetObj.SelectRow < 0) {
                		ComShowCodeMessage("CTM20071");
                		return;
                	}
                	
                	var sUrl = "ESM_BKG_0079_Q.do?bkg_no="+sheetObj.CellValue(sheetObj.SelectRow,"bkg_no"); 
                	ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, true, "yes");
                	break;

                case "btn_downExcel" :
                	sheetObj.Down2Excel();
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // CTM-COMMON
        setEventProcess();

        // btn_eachbkg 버튼 Disable
        ComBtnDisable("btn_eachbkg");
        // btn_bkg_inquiry 버튼 Disable
        ComBtnDisable("btn_bkg_inquiry");

        // p_cntrno에 value가 있다면 Onload시 조회한다.
        if (document.form.p_cntrno.value) doActionIBSheet(sheetObjects[0], document.form, SEARCH01, 2);

        // 페이지 로딩시 focus
        document.form.p_cntrno.focus();
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 342;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(43, 7, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "CYC|C|STS|A/F|Origin YD||Return YD||Event Date|VVD Code|Booking No.|Booking No.|B/L No.|F/M|I/O|MSG|TP|DM|HR|HB|D|E|R|SP|S/P|S/P|Mode|Chassis No.|M.G Set|Seal No.|VGM|Waybill|Pick Up No.|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Office|User Name|Correction Reason|Remark(S)|Last BKG No.|";

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
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

                    var sTipIO = "Bound indicator"; //
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
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cnmv_cyc_no",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    true,     "cnmv_co_cd",              false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "mvmt_sts_cd",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "mvmt_cre_tp_cd",          false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipAF);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "org_yd_cd",               false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  0,      daCenter,    false,    "org_yd_nm");
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "dest_yd_cd",              false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  0,      daCenter,    false,    "dest_yd_nm");
                    InitDataProperty(0, cnt++,    dtData,    100,    daCenter,    false,    "cnmv_evnt_dt",            false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "vvd_cd",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "bkg_knt",                 false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "bkg_no",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "bl_no",                   false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "fcntr_flg",               false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "ob_cntr_flg",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipIO);
                    InitDataProperty(0, cnt++,    dtData,    35,     daCenter,    false,    "mvmt_edi_msg_tp_id",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "bkg_cgo_tp_cd",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipTP);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cntr_dmg_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipDM);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cntr_hngr_rck_cd",        false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipHR);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cntr_hngr_bar_atch_knt",  false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipHB);
                    InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "cntr_disp_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipD);
                    InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "imdt_ext_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipE);
                    InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "cntr_rfub_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipR);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "spcl_cgo_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipSP);
                    InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    false,    "vndr_seq",                false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "vndr_abbr_nm",            false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    false,    "mvmt_trsp_mod_cd",        false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "chss_no",                 false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "mgst_no",                 false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "cntr_seal_no",            false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daRight,     false,    "vgm",                     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "wbl_no",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "pkup_no",                 false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "upd_locl_dt",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "cre_locl_dt",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "upd_dt",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "cre_dt",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    false,    "ofc_cd",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daLeft,      false,    "usr_nm",                  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    120,    daCenter,    false,    "modi_tp",                 false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    150,    daLeft,      false,    "cnmv_rmk",                false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  150,    daLeft,      false,    "lst_bkg_no",              false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  150,    daLeft,      false,    "cnmv_his_col_nm",         false,    "",    dfNone,    0,    true,    true);

                    ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
                    CountPosition = 0;
                }
                break;

             case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 62;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    // 자동 트림하여 조회
                    DataAutoTrim = true;

                    var HeadTitle = "ORG YD|Event Date|Receiving Date|Booking No.|B/L No.|VVD Code|VVD Code|VVD Code|STS|I/O|F/M|E/I|Result error message";

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,    true,    "evnt_yd_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    110,   daCenter,    true,    "evnt_dt",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    110,   daCenter,    true,    "cre_locl_dt",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,    "bkg_no",              false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,    "bl_no",               false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,    true,    "crnt_vsl_cd",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,    true,    "crnt_skd_voy_no",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,    true,    "crnt_skd_dir_cd",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,    true,    "edi_mvmt_sts_cd",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,    true,    "edi_gate_io_cd",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,    true,    "cntr_full_sts_cd",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,    true,    "mvmt_edi_sght_cd",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++ , dtData,    150,   daLeft,      true,    "mvmt_edi_rmk",        false,    "",    dfNone,    0,    true,    true);

                    CountPosition = 0;
                }
                break;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, condParam) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case SEARCH01:      //조회
        	if (condParam == 1) {
                if (!validateForm(sheetObj,frmObj,sAction)) break;
        	}
                //if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);

                    frmObj.f_cmd.value = SEARCH;
                    var xml = sheetObj.GetSearchXml("EES_CTM_0408GS.do", FormQueryString(frmObj));
                    var rtnValue = xml.split("|$$|");
                    sheetObjects[0].LoadSearchXml(rtnValue[0]);
                    sheetObjects[1].LoadSearchXml(rtnValue[1]);
                    // 조회데이터의 마지막 row가 선택되어있게 한다.
                    sheetObjects[0].SelectCell(sheetObjects[0].LastRow, 0);
                    sheetObjects[1].SelectCell(sheetObjects[1].LastRow, 0);
                    // SHEET에 조회된 데이터가 있으면 버튼 활성화를 위해 호출
                    sheet1_OnClick(sheetObj, sheetObj.SelectRow, "bkg_no");
//                }
                break;

        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    	for(var i=1; i<=sheetObj.LastRow; i++){
			var modi_tp = sheetObj.CellValue(i, "modi_tp");
			var cnmv_his_col_nm = sheetObj.CellValue(i, "cnmv_his_col_nm");
			if(modi_tp == 'Update' && cnmv_his_col_nm.length > 0){
				var colArray = cnmv_his_col_nm.split(":");
				for(var k=0;k<colArray.length;k++){
					if(colArray[k] != 'ofc_cd' && colArray[k] != 'usr_nm'){
						if(colArray[k] == 'vndr'){
							sheetObj.CellBackColor(i,"vndr_seq") = sheetObj.RgbColor(255, 246, 18);
							sheetObj.CellBackColor(i,"vndr_abbr_nm") = sheetObj.RgbColor(255, 246, 18);
						}else{
							sheetObj.CellBackColor(i,colArray[k]) = sheetObj.RgbColor(255, 246, 18);
						}
					}
					
				}
			}else if(modi_tp == 'Insert'){
				sheetObj.CellBackColor(i,"modi_tp") = sheetObj.RgbColor(255, 246, 18);
			}
		}
    	
    	
        ComOpenWait(false);
        sheetObjects[1].WaitImageVisible = true;
        sheetObjects[0].WaitImageVisible = true;
        
        
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
            // 클릭한 row의 "bkg_no"컬럼 값이 있으면
            if (ComGetLenByByte(Cellvalue(Row, "bkg_no")) > 0) {
            	if (CellValue(Row, "bkg_cgo_tp_cd") == "P") {
            		ComBtnDisable("btn_bkg_inquiry");
            	} else {
            		ComBtnEnable("btn_bkg_inquiry");
            	}
                // btn_eachbkg 버튼 Enable
                ComBtnEnable("btn_eachbkg");
            } else {
                // btn_eachbkg 버튼 Disable
                ComBtnDisable("btn_eachbkg");
                ComBtnDisable("btn_bkg_inquiry");
            }
        }
    }
    
    /**
 	 * validating after checking Focus cell contaienr when clicking Mouse or moving Focus by tab
 	 * @param sheetObj
 	 * @param OldRow
 	 * @param OldCol
 	 * @param NewRow
 	 * @param NewCol
 	 * @return
 	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        with (sheetObj) {
            // 클릭한 row의 "bkg_no"컬럼 값이 있으면
            if (ComGetLenByByte(Cellvalue(NewRow, "bkg_no")) > 0) {
            	if (CellValue(NewRow, "bkg_cgo_tp_cd") == "P") {
            		ComBtnDisable("btn_bkg_inquiry");
            	} else {
            		ComBtnEnable("btn_bkg_inquiry");
            	}
                // btn_eachbkg 버튼 Enable
                ComBtnEnable("btn_eachbkg");
            } else {
                // btn_eachbkg 버튼 Disable
                ComBtnDisable("btn_eachbkg");
                ComBtnDisable("btn_bkg_inquiry");
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
            // 더블클릭한 row의 "bkg_no"컬럼 값이 있으면
            if (ComGetLenByByte(Cellvalue(Row, "bkg_no")) > 0) {
                ComOpenPopup("/hanjin/EES_CTM_0409.do?" +
                             "bkg_no=" + Cellvalue(Row , "bkg_no"), 1020, 682, "", "0,1");
            }
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with (frmObj) {
    		if (sAction == SEARCH01) {
    			
    	          if (cancelDate == false){
    	        	  return false;
    	          }
    	        	  
    	         }


        }
        return true;
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

/* 개발자 작업  끝 */
