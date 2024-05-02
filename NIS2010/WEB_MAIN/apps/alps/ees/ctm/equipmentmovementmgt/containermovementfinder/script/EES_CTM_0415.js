/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0415.js
*@FileTitle : Deleted CNTR MVMT History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.11 김상수
* 1.0 Creation
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
     * @class ees_ctm_0415 : ees_ctm_0415 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0415() {
        this.processButtonClick    = processButtonClick;
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

        var sheetObject = sheetObjects[0];
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
                    doActionIBSheet(sheetObject, frmObj, IBSEARCH);
                    break;

                case "btn_new":
                    ComResetAll();
                    frmObj.p_cntrno.focus();
                    break;

                case "btn_close":
                    window.close();
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

        for (i=0; i<sheetObjects.length; i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // CTM-COMMON
        setEventProcess();

        // 각 input에 value가 있다면 Onload시 조회한다.
        if (document.form.p_cntrno.value && document.form.check_digit.value && document.form.ctnr_tpsz_cd.value)
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

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
            case 1:      //t1sheet1 init
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
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(37, 8, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|Booking No.|B/L No.|F/M|I/O|MSG|TP|DM|D|E|R|SP|";
                        HeadTitle += "S/P|S/P|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Delete Date (S)|DEL User ID|DEL User Name|Remark(s)";


                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus, 0,      daCenter,    false,    "HidSta");
                    InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "cnmv_cyc_no");
                    InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "cnmv_co_cd");
                    InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "cnmv_sts_cd");
                    InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "mvmt_cre_tp_cd");
                    InitDataProperty(0, cnt++,    dtData,         65,     daCenter,    false,    "org_yd_cd");
                    InitDataProperty(0, cnt++,    dtData,         65,     daCenter,    false,    "dest_yd_cd");
                    InitDataProperty(0, cnt++,    dtData,         110,    daCenter,    false,    "cnmv_evnt_dt");
                    InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "fdr_cd");
                    InitDataProperty(0, cnt++,    dtData,         20,     daCenter,    false,    "bkg_knt");
                    InitDataProperty(0, cnt++,    dtData,         90,     daCenter,    false,    "bkg_no");
                    InitDataProperty(0, cnt++,    dtData,         90,     daCenter,    false,    "bl_no");
                    InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "fcntr_flg");
                    InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "ob_cntr_flg");
                    InitDataProperty(0, cnt++,    dtData,         35,     daCenter,    false,    "mvmt_edi_msg_tp_id");
                    InitDataProperty(0, cnt++,    dtData,         25,     daCenter,    false,    "bkg_cgo_tp_cd");
                    InitDataProperty(0, cnt++,    dtData,         25,     daCenter,    false,    "cntr_dmg_flg");
                    InitDataProperty(0, cnt++,    dtData,         25,     daCenter,    false,    "cntr_disp_flg");
                    InitDataProperty(0, cnt++,    dtData,         25,     daCenter,    false,    "imdt_ext_flg");
                    InitDataProperty(0, cnt++,    dtData,         25,     daCenter,    false,    "cntr_rfub_flg");
                    InitDataProperty(0, cnt++,    dtData,         25,     daCenter,    false,    "spcl_cgo_flg");
                    InitDataProperty(0, cnt++,    dtData,         50,     daCenter,    false,    "vndr_seq");
                    InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "vndr_abbr_nm");
                    InitDataProperty(0, cnt++,    dtData,         40,     daCenter,    false,    "mvmt_trsp_mod_cd");
                    InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "chss_no");
                    InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "mgst_no");
                    InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "cntr_seal_no");
                    InitDataProperty(0, cnt++,    dtData,         85,     daCenter,    false,    "wbl_no");
                    InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "pkup_no");
                    InitDataProperty(0, cnt++,    dtData,         110,    daCenter,    false,    "upd_locl_dt");
                    InitDataProperty(0, cnt++,    dtData,         110,    daCenter,    false,    "cre_locl_dt");
                    InitDataProperty(0, cnt++,    dtData,         110,    daCenter,    false,    "upd_dt");
                    InitDataProperty(0, cnt++,    dtData,         110,    daCenter,    false,    "cre_dt");
                    InitDataProperty(0, cnt++,    dtData,         110,    daCenter,    false,    "delt_dt");
                    InitDataProperty(0, cnt++,    dtData,         90,     daLeft,      false,    "delt_usr_id");
                    InitDataProperty(0, cnt++,    dtData,         100,    daLeft,      false,    "usr_nm");
                    InitDataProperty(0, cnt++,    dtData,         100,    daLeft,      false,    "cnmv_rmk");

                    CountPosition = 0;

               }
                break;

        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:      // 조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    frmObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Fx("EES_CTM_0415GS.do", FormQueryString(frmObj));
                }
                break;

        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction){
        with (frmObj) {
     		if (sAction == IBSEARCH) {
  	          if (cancelDate == false){
  	        	  return false;
  	          }
  	        	  
  	         }
        }
        return true;
    }


/* 개발자 작업 끝 */
