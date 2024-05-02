/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0764.js
 *@FileTitle : Customer Data Management Update History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.04.28 박만건
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview Customer Data Management Update History에서 공통으로 사용하는 자바스크립트 함수가 정의되어 있다.
  * @author Park Mangeon
  */

/**
 * @extends
 * @class esm_bkg_0764 : esm_bkg_0764 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0764() {
    this.processButtonClick        = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage                 = loadPage;
    this.initSheet                 = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet         = doActionIBSheet;
    this.setTabObject             = setTabObject;
    this.validateForm             = validateForm;
    this.obj_keypress             = obj_keypress;
    this.setComboObject         = setComboObject;
}

/* 개발자 작업    */



// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var sheetNames   = new Array("sheet1", "sheet2");

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
    var sheetObject2 = sheetObjects[1];

    /*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

            case "btn_cng_dt":
                var cal = new ComCalendarFromTo();
                cal.select(formObject.cng_dt_s, formObject.cng_dt_e, 'yyyy-MM-dd');
                break;

            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;

            case "btn_Close":
                window.close();
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

    for(i=0;i<sheetNames.length;i++){
    	if(sheetNames[i] == "sheet1") {
	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet (sheetObjects[i] );
    	}

        initSheet(sheetObjects[i],i+1);
        if(sheetNames[i] == "sheet1") {
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
    }

    initControl();

    // 초기 loading을 수행한다
    var formObj = document.form;
    formObj.cust_cnt_cd.value = parCustCntCd;
    formObj.cust_seq.value = parCustSeq;
    formObj.ofc_cd.value = strOfc_cd;
//    if (parCustCntCd != null && parCustCntCd != ""
//    	&& parCustSeq != null && parCustSeq != "" ) {
//        formObj.cust_cnt_cd.value = parCustCntCd;
//        formObj.cust_seq.value = parCustSeq;
//        formObj.ofc_cd.value = strOfc_cd;
//        doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
//    } else {
//        doActionIBSheet(sheetObjects[1],document.form,SEARCH02);
//        return;
//    }

    // cust_cnt_cd, cust_seq, ofc_cd가 있으면 일단 조회한다.
    if (formObj.cust_cnt_cd.value.trim() != ""
         && formObj.cust_seq.value.trim() != ""
         && formObj.ofc_cd.value.trim() != "") {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }


}

///**
// * 화면을 Load한 후 조회해야 할경우를 처리한다.<br>
// * @param {Object} sheetObj 필수, 시트객체
// * @return void
// * @author Park Mangeon
// * @version 2009.11.13
// */
//function sheet1_OnLoadFinish(sheetObj) {
//    // 초기 loading을 수행한다
//    var formObj = document.form;
//    formObj.cust_cnt_cd.value = parCustCntCd;
//    formObj.cust_seq.value = parCustSeq;
//    formObj.ofc_cd.value = strOfc_cd;
////    if (parCustCntCd != null && parCustCntCd != ""
////    	&& parCustSeq != null && parCustSeq != "" ) {
////        formObj.cust_cnt_cd.value = parCustCntCd;
////        formObj.cust_seq.value = parCustSeq;
////        formObj.ofc_cd.value = strOfc_cd;
////        doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
////    } else {
////        doActionIBSheet(sheetObjects[1],document.form,SEARCH02);
////        return;
////    }
//
//    // cust_cnt_cd, cust_seq, ofc_cd가 있으면 일단 조회한다.
//    if (formObj.cust_cnt_cd.value.trim() != ""
//         && formObj.cust_seq.value.trim() != ""
//         && formObj.ofc_cd.value.trim() != "") {
//        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//    }
//
//}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initControl() {
    var formObj = document.form;

    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm ('change', 'obj_change', form);
    axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);
    axon_event.addListenerForm('keyup', 'objKeyUp', form);

    formObj.cng_dt_s.value=ComGetDateAdd(null, 'd', -14, '-');
    formObj.cng_dt_e.value=ComGetNowInfo('ymd','-');
}


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
    var sheetID = sheetObj.id;
    switch(sheetID) {

        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 282;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3, 100);

                var HeadTitle1 = "|SEQ|Concerned Party|Fax No./E-Mail Address|Fax No./E-Mail Address|Manual\n/ Auto|B/L No|Do Not\nSend|Update Time|User ID|Office|User Name";
                var HeadTitle2 = "|SEQ|Concerned Party|New|Old|Manual\n/ Auto|B/L No|Do Not\nSend|Update Time|User ID|Office|User Name";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,                KEYFIELD, CALCULOGIC,    DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,  cnt++ , dtHiddenStatus, 30,    daCenter,  true,     "hdnStatus");
                InitDataProperty(0,  cnt++ , dtSeq,          40,    daCenter,  true,     "SEQ");
                InitDataProperty(0,  cnt++ , dtData,         120,   daLeft,  true,     "cust_cntc_tp_cd_desc",  false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         120,   daLeft,  true,     "new_cntc_ctnt",         false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         120,   daLeft,  true,     "old_cntc_ctnt",         false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         55,    daCenter,  true,     "auto_mnl_flg_desc",     false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         100,   daCenter,  true,     "bl_no",                 false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         55,    daCenter,  true,     "snd_sel_flg_desc",      false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         120,   daCenter,  true,     "cng_dt",                false,        "",        dfUserFormat2,  0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         70,    daCenter,  true,     "cng_usr_id",            false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         50,    daCenter,  true,     "ofc_cd",                false,        "",        dfNone,         0,        false,       false,      0,       true,     false);
                InitDataProperty(0,  cnt++ , dtData,         50,    daCenter,  true,     "cng_usr_nm",            false,        "",        dfNone,         0,        false,       false,      0,       true,     false);


                InitUserFormat2(0, "cng_dt", "####-##-## ##:##", "-|:" );

                ShowButtonImage = 2;
                CountPosition = 0;
				Ellipsis = true;

                RowHeight(0) = 10;
                RowHeight(1) = 10;
                WaitImageVisible = false;

            }
            break;
        case "sheet2":
            with (sheetObj) {

                // 높이 설정
                style.height = 0;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                var HeadTitle1 = "|SEQ|Concerned Party|Fax No./E-Mail Address|Fax No./E-Mail Address|Manual\n/ Auto|B/L No|Do Not\nSend|Update Time|User ID|Office|User Name";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,                KEYFIELD, CALCULOGIC,    DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,  cnt++ , dtHiddenStatus, 30,    daCenter,  true,     "hdnStatus");

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
 * @param {String} CondParam 필수, 서버전송 정보
 * @param {int} PageNo 선택, 페이지 번호
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:      //조회
            if(!validateForm(sheetObj,formObj,sAction)) {return; }
            formObj.f_cmd.value=SEARCH;
            ComOpenWait(true,true);
            sheetObj.DoSearch("ESM_BKG_0764GS.do", FormQueryString(formObj));
            break;
        case SEARCH01: // 고객명 조회
            // 고객코드가 양쪽 다 들어와 있는지 확인
            if ((formObj.cust_cnt_cd.value == null || formObj.cust_cnt_cd.value == "" )
                    &&( formObj.cust_seq.value == null || formObj.cust_seq.value == "" )) {
                return;
            } else {
                if (formObj.cust_cnt_cd.value.length < 2) {
                    ComShowCodeMessage("BKG00186");
                    formObj.cust_cnt_cd.focus();
                    return;
                } else if(formObj.cust_seq.value.value = "") {
                    ComShowCodeMessage("BKG00187");
                    formObj.cust_seq.focus();
                    return;
                }
            }
            formObj.f_cmd.value=SEARCH01;
            var sXml = sheetObjects[1].getSearchXml("ESM_BKG_0764GS.do", FormQueryString(formObj));
            sheetObjects[1].loadSearchXml(sXml);
            var isError = sXml.substring(1,6);
            if (isError == "ERROR") {
                formObj.cust_nm.value = "";
//                ComShowCodeMessage("BKG01061", formObj.cust_cnt_cd.value + formObj.cust_seq.value);
//                formObj.cust_seq.focus();
                //ComSetFocus(formObj.cust_seq);
                return;
            }

            var sCustNm = ComGetEtcData(sXml, "cust_nm");
            if (sCustNm == null ) {
                axon_event.removeListener ("cust_seq", "beforedeactivate", "obj_deactivate");
                formObj.cust_seq.focus();
                axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
                return;
            }
            formObj.cust_nm.value = sCustNm;
        break;
//        case SEARCH02: // OFFICE의 국가 조회
//            formObj.f_cmd.value=SEARCH02;
//            var sXml = sheetObjects[1].getSearchXml("ESM_BKG_0764GS.do", FormQueryString(formObj));
//            var sCntCd =  ComGetEtcData(sXml, "cust_cnt_cd");
//            if (sCntCd != null ) {
//                formObj.cust_cnt_cd.value = sCntCd;
//                formObj.cust_seq.focus();
//            }
    }
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
    with(formObj){
        if(!ComChkValid(formObj)) return false;

        if(!ComBkgMonthsBetweenCheck(formObj.cng_dt_s.value,formObj.cng_dt_e.value, 3)) {
            ComShowCodeMessage("BKG40013", 3);
            ComSetFocus(formObj.cng_dt_e);
            return false;
        }
    }
    return true;
}

/**
 * 폼객체에서 발생한 키보드 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function obj_keydown() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    var evtCode = (window.netscape) ? ev.which : event.keyCode;
    switch(objName) {
        case "cust_seq":
//            if (evtCode == 9) { // tab event
//                doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
//            }
            break;
        default:
            ComKeyEnter();
            break;
    }
}

/**
 * form object가 변경될 경우 발생하는 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function obj_change() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {

        case "auto_mnl_flg":
            if (formObj.auto_mnl_flg.value == "Y") {
                formObj.snd_sel_flg.disabled = true;
            } else {
                formObj.snd_sel_flg[0].selected = true;
                formObj.snd_sel_flg.disabled = false;
            }

//            if (formObj.auto_mnl_flg.value == "N") {
//                formObj.bl_no.disabled = true;
//            } else {
//                formObj.bl_no.disabled = false;
//            }
            break;
    }

}


/**
 * 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "cust_cnt_cd":
	        ComKeyOnlyAlphabet('upper');
            break;
	    case "cust_seq":
	    	ComKeyOnlyNumber(event.srcElement);
		    break;
	    case "cng_dt_s":
	   	    obj_KeyPress(event.srcElement);
		    break;
	    case "cng_dt_e":
	   	    obj_KeyPress(event.srcElement);
		    break;
    }
}

/**
 * 개체에서 키보드를 땠을때 발생하는 이벤트를 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objKeyUp() {
    ComKeyEnter('LengthNextFocus');
}


/**
 * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function obj_deactivate(){
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "cust_seq":
            if (formObj.cust_seq.value != "") {
                doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
            }
            break;
    }
}

/**
 * 조회후 처리
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errStr 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, errXml) {
	ComOpenWait(false);
}
    /* 개발자 작업  끝 */