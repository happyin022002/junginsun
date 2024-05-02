/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0923.js
 *@FileTitle : Inbound Cargo Release for POD Office_Popup History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.08.14 박만건
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Inbound Cargo Release for POD Office_Popup History에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class esm_bkg_0923 : esm_bkg_0923 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0923() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

/* 개발자 작업  */


//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];
    /*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_Close":
                self.close();
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, Sheet개체
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);

        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);

        document.form.bl_no.value= parBlNo;
    }

    doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
}

///**
// * 화면을 Load한 후 조회해야 할 경우를 처리한다.<br>
// * @param {Object} sheetObj 필수, 시트객체
// * @return void
// * @author Park Mangeon
// * @version 2009.11.13
// */
//function sheet1_OnLoadFinish(sheetObj) {
//    doActionIBSheet(sheetObj, document.form,IBSEARCH);
//}


/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo 필수, Sheet Index
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 260;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |B/L|Last Update|F|O|C|CR|Hold|Team|Service Name|User Name";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성          [ROW, COL,  DATATYPE,       WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,    cnt++,    dtSeq,            30,     daCenter,    false,    "seq");
                InitDataProperty(0,    cnt++,    dtData,          100,     daCenter,    false,    "bl_no",              false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,          110,     daCenter,    false,    "evnt_dt",            false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,           40,     daCenter,    false,    "frt_clt_flg",        false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,           40,     daCenter,    false,    "obl_rdem_flg",       false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,           40,     daCenter,    false,    "cstms_clr_cd",       false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,           40,     daCenter,    false,    "mrn_tml_edi_snd_cd", false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,           40,     daCenter,    false,    "do_hld_flg", 		false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,          100,     daLeft,      false,    "cgor_team_cd_desc",  false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,          100,     daLeft,      false,    "cgor_evnt_nm",       false,        "",      dfNone,       0,        false,       false,      0,       true,     false);
                InitDataProperty(0,    cnt++,    dtData,           30,     daLeft,      false,    "usr_nm",             false,        "",      dfNone,       0,        false,       false,      0,       true,     false);


				WaitImageVisible = false;
            }
            break;

    }
}

/**
 * Sheet관련 프로세스 처리<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:      //조회
            if(!validateForm(sheetObj,formObj,sAction)) return;
               formObj.f_cmd.value = SEARCH;
			   ComOpenWait(true);
               sheetObj.DoSearch("ESM_BKG_0923GS.do" ,FormQueryString(formObj));
            break;

    }
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if("CA" == document.form.cnt_cd.value){
		sheetObjects[0].ColHidden("cstms_clr_cd") = true;
	}else{
		sheetObjects[0].ColHidden("cstms_clr_cd") = false;
	}
	ComOpenWait(false);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리를 수행<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form 객체
 * @param {int} sAction 필수, 처리할 작업 코드
 * @return boolean 유효성 여부
 * @author Park Mangeon
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
//    with(formObj){
//        if (!isNumber(formObj.iPage)) {
//            return false;
//        }
//    }
    return true;
}


   /* 개발자 작업  끝 */