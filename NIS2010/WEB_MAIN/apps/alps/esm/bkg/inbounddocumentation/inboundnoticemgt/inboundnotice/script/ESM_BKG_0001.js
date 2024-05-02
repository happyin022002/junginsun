/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0001.js
 *@FileTitle : Arrival Notice Notice Sent History
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
 * @fileoverview Arrival Notice Notice Sent History에서 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author Park Mangeon
 */

/**
 * @extends
 * @class esm_bkg_0001 : esm_bkg_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0001() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
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
var sheetInits   = new Array(   false,    false);

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, Sheet개체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    var sheetObject1 = sheetObjects[0];

    /*******************************************************/
    var formObject = document.form;

    //try {
    var srcName = window.event.srcElement.getAttribute("name");
    if (!ComIsBtnEnable(srcName)){ return; }
    switch(srcName) {
        case "btn_snd_dt":
            var cal = new ComCalendarFromTo();
            formObject.sch_tp[1].checked = true;
            fnToggleSchTp("D", formObject);
            cal.select(formObject.snd_dt_fm, formObject.snd_dt_to, 'yyyy-MM-dd');
            break;
        case "btn_Retrieve":
            if (!validateForm(sheetObject1, formObject, IBSEARCH)) {return; }

            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;

        case "btn_DownExcel":
            if (!validateForm(sheetObject1, formObject, IBDOWNEXCEL)) {return; }

            doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
            break;
        case "btn_ANSend":
            fnMoveToANSend(sheetObjects[0], formObject);
            break;

        case "btn_PrePickup":
            fnMoveToPrePickup(sheetObjects[0], formObject);
            break;
        case "btn_PreHold":
            fnMoveToPreHold(sheetObjects[0], formObject);
            break;

        case "btn_InboundCS":
            fnMoveToInboundCS(sheetObjects[0], formObject);
            break;

    } // end switch
        //}catch(e) {
        //    if( e == "[object Error]") {
        //        ComShowMessage(OBJECT_ERROR);
        //    } else {
        //        ComShowMessage(e);
        //    }
        //}
}


/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, 등록할 개체
 * @return void
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
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function loadPage() {

    for(i=0;i<sheetNames.length;i++){
        if(sheetNames[i] == "sheet1") {
            sheetInit(i);
        }
    }
    if(parNtcKndCd == "AN"){
    	document.form.ntc_knd_cd.options[1].selected = true;
    }
    initControl();

    if (parAutoSearchFlg == "Y" ) {

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "", "");
    }

}

/**
 * Sheet를 초기화 하는 함수
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {int} idx 필수, Sheet의 인덱스
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheetInit(idx) {
    if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx] = true;
    }
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initControl() {
   //Axon 이벤트 처리1. 이벤트catch
   //대문자로 변경
    axon_event.addListenerForm('click', 'objClick', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);

   var formObj = document.form;

   /* DEFAULT VALUE 처리 */
   formObj.ofc_cd.value = strOfc_cd;  // default office - login office

   // calendar 처리 (from은 3주전, to는 오늘)
   formObj.snd_dt_to.value=ComGetNowInfo('ymd','-');
   formObj.snd_dt_fm.value=ComGetDateAdd(null, 'd', -21, '-');

   // 버튼처리
   if (strCnt_cd== null || strCnt_cd != "US") {
       ComBtnDisable("btn_PrePickup");
       ComBtnDisable("btn_PreHold");
   }

   var schTp = "";
   formObj.bl_no.value = parBlNo;
   formObj.vvd.value   = parVvd;
   formObj.pod_cd.value = parPodCd;
   if (parSchTp == "") {
       formObj.sch_tp[1].checked = true;
       schTp = formObj.sch_tp[1].value;
   } else {
       for (var idx = 0; idx < formObj.sch_tp.length; idx++) {
           if (formObj.sch_tp[idx].value == parSchTp) {
               formObj.sch_tp[idx].checked = true;
               formObj.sch_tp.value = parSchTp;
               schTp = parSchTp;
               break;
           }
       }
   }

   fnToggleSchTp(schTp, formObj);
}

///**
// * Sheet로딩 후 후속작업 처리를 수행<br>
// * @param {Object} sheetObj 필수, 작업이 끝난 개체<br>
// * <br><b>Example : </b>
// * <pre>
// * </pre>
// * @param {void}
// * @return void
// * @author Park Mangeon
// * @version 2009.10.01
// */
//function sheet1_OnLoadFinish(sheetObj) {
//
//    if (parAutoSearchFlg == "Y" ) {
//        sheetObj.WaitImageVisible = false;
//
//        doActionIBSheet(sheetObj,document.form,IBSEARCH, "", "");
//        sheetObj.WaitImageVisible = true;
//    }
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
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    var sheetID = sheetObj.id;
    switch (sheetID) {

    case "sheet1"://Detail Grid
        with (sheetObj) {
            style.height = 420;
            Editable = true;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 200);
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false)
            
            var HeadTitle = "|#|Notice type|BL No.|Consigne|Notify|Sent Result|Sent Result|Sent Result|FAX/EMAIL Address|Sent RQST|Final Sent|Sent Office|Sent ID|User Name||";
            
            var headCount = ComCountHeadTitle(HeadTitle);
            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    		InitColumnInfo(headCount, 0, 0, true);

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]

            InitDataProperty(0, cnt++ , dtHiddenStatus,   30, daCenter, false, "ibflag");
            InitDataProperty(0, cnt++ , dtSeq,      30, daCenter, true, "Seq"                  , false);
            InitDataProperty(0, cnt++ , dtData,     75, daCenter, true, "ntc_knd_cd_desc"      , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, "bl_no"                , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    130, daLeft,   true, "cn_nm"                , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    130, daLeft,   true, "nf_nm"                , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     25, daCenter, true, "bkg_ntc_snd_rslt_cd"  , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, "bkg_ntc_snd_rslt_ctnt", false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    20, daCenter, true, "bkg_cust_tp_cd"       , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    150, daLeft,   true, "ntc_fax_no_eml"       , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     95, daCenter, true, "snd_rqst_dt"          , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     95, daCenter, true, "snd_dt"               , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     85, daCenter, true, "snd_ofc_cd"           , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    120, daCenter, true, "snd_usr_id"           , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, "usr_nm"               , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtHidden,    0, daCenter, true, "snd_gdt"              , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtHidden,    0, daCenter, true, "bkg_no"               , false,        "",    dfNone,        0,        false,        false);

            CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
            MultiSelection=false;

            ToolTipOption="balloon:true;width:320;title:Final Sent (GMT)";
            Ellipsis  = true;

            WaitImageVisible = false;
        }
        break;

    case "sheet2"://Detail Grid
        with (sheetObj) {
            style.height = 0;
            Editable = false;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 200);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(12, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false)

            var HeadTitle = "Notice type|BL No.|Consigne|Notify|Sent Result|Sent Result|FAX/EMAIL Address|Sent RQST|Final Sent|Sent Office|Sent ID|User Name";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]

            InitDataProperty(0, cnt++ , dtData,     75, daCenter, true, "ntc_knd_cd_desc"      , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, "bl_no"                , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    130, daLeft,   true, "cn_nm"                , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    130, daLeft,   true, "nf_nm"                , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     25, daCenter, true, "bkg_ntc_snd_rslt_cd"  , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, "bkg_ntc_snd_rslt_ctnt", false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    150, daLeft,   true, "ntc_fax_no_eml"       , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     85, daCenter, true, "snd_rqst_dt"          , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     85, daCenter, true, "snd_dt"               , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,     85, daCenter, true, "snd_ofc_cd"           , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    120, daCenter, true, "snd_usr_id"           , false,        "",    dfNone,        0,        false,        false);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, "usr_nm"               , false,        "",    dfNone,        0,        false,        false);
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
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {

    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {

        case IBSEARCH:      //조회

            formObj.f_cmd.value = SEARCH;
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0001GS.do"
                   ,FormQueryString(formObj)
                   , "page_no=1"
                   , false
                   );

             //조회 완료이벤트 발생후 로직처리필요.(sheet1_OnSearchEnd 함수로 이동)
            break;

        case IBSEARCHAPPEND:
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0001GS.do"
                   , CondParam + "&mtch_chk_flg=N"
                   ,"page_no=" + PageNo
                   , true
            );
            break;

        case IBDOWNEXCEL:   // EXCEL 다운로드
            formObj.f_cmd.value = SEARCH;
            ComOpenWait(true);
            sheetInit(1);
            sheetObj.DoSearch("ESM_BKG_0001GS.do"
                  , FormQueryString(formObj)  + "&excel_flg=Y"
                 );
            break;
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
    var formObj = document.form;
    with(formObj){
        switch (sAction){
        case IBSEARCH:
            if(!ComChkValid(formObj)) return false;

            // maximum조회기간이 3개월
            if(formObj.sch_tp[1].checked
                    && !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value,  3))
            {
                ComShowCodeMessage("BKG40013", "3");
                ComSetFocus(formObj.snd_dt_to);
                return false;
            }
            break;

        case IBDOWNEXCEL:
            if(!ComChkValid(formObj)) return false;

            // maximum조회기간이 3개월
            if(formObj.sch_tp[1].checked
                    && !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value,  3))
            {
                ComShowCodeMessage("BKG40013", "3");
                ComSetFocus(formObj.snd_dt_to);
                return false;
            }

            break;
        }
    }

    return true;
}


/**
 * 조회후 작업 처리 -row에 색상 등을 처리, 툴팁 정보 등 추가<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errXml 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, errXml) {
    var startRow = 1;
    var maxRow = sheetObj.LastRow;

    //sheetObj.RowHeight(0) = 10;
    if (maxRow < 100) {
        startRow = 1;
    } else if ((maxRow%100.0) == 0 ) {
        startRow = maxRow - 200 ;
        if (startRow < 1) {
            startRow = 1;
        }
    } else {
        startRow = maxRow - ((maxRow - 1.0)%200.0);
    }

    var vColorRed  = sheetObj.RgbColor(255,0,0);  // 성능 향상을 위해 변수로 적용 20100204
    var vColorBlue = sheetObj.RgbColor(0,0,255);
    var vColorPink = sheetObj.RgbColor(255,0,192);

    for (var idx = startRow; idx <= maxRow; idx ++) {
//        if (sheetObj.CellValue(idx, "bkg_ntc_snd_rslt_cd") == "F") {
//            sheetObj.RowFontColor(idx) = sheetObj.vColorRed;  // fail은 Row가 Red로
//        }
        with (sheetObj) {
            rsltCd = CellValue(idx, "bkg_ntc_snd_rslt_cd");

            if (rsltCd == "F") { // Red
                CellFont("FontColor", idx,"bkg_ntc_snd_rslt_cd") = vColorRed;
                CellFont("FontColor", idx,"bkg_ntc_snd_rslt_ctnt") = vColorRed;
                CellFont("FontColor", idx,"ntc_fax_no_eml") = vColorRed;
            } else if (rsltCd == "S" ) { // blue
                CellFont("FontColor", idx,"bkg_ntc_snd_rslt_cd") = vColorBlue;
                CellFont("FontColor", idx,"bkg_ntc_snd_rslt_ctnt") = vColorBlue;
                CellFont("FontColor", idx,"ntc_fax_no_eml") = vColorBlue;
            } else { // pink
                CellFont("FontColor", idx,"bkg_ntc_snd_rslt_cd") = vColorPink;
                CellFont("FontColor", idx,"bkg_ntc_snd_rslt_ctnt") = vColorPink;
                CellFont("FontColor", idx,"ntc_fax_no_eml") = vColorPink;
            }
            sheetObj.ToolTipText(idx, "snd_dt") = sheetObj.CellValue(idx, "snd_gdt");
        }
        sheetObj.ToolTipText(idx, "snd_dt") = sheetObj.CellValue(idx, "snd_gdt");
    }
	ComOpenWait(false);
}

/**
 * Excel에 대한 Search 종료시 이벤트 처리한다.(엑셀 추출)<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errXml 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet2_OnSearchEnd(sheetObj, errXml) {
    sheetObj.SpeedDown2Excel();
    ComOpenWait(false);
}


/**
 * sch_tp를 변경할 때에 조정되어야 할 화면 속성들을 정의한다.<br>
 * 화면 필수요건 등이 변경된다.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {String} vSchTp 필수, Radio 버튼 값
 * @param {Object} formObj 필수, Form객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnToggleSchTp (vSchTp, formObj) {
    if (vSchTp=="V") {
         document.getElementsByName("vvd")[0].setAttribute("required", true);
         document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
         document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
         document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
         document.getElementsByName("bl_no")[0].removeAttribute("required");

         document.getElementsByName("pod_cd")[0].setAttribute("required", true);
         document.getElementsByName("ofc_cd")[0].setAttribute("required", true);
     } else if (vSchTp=="D") {
         document.getElementsByName("vvd")[0].removeAttribute("required");
         document.getElementsByName("vvd")[0].removeAttribute("fullfill");
         document.getElementsByName("snd_dt_fm")[0].setAttribute("required", true);
         document.getElementsByName("snd_dt_to")[0].setAttribute("required", true);
         document.getElementsByName("bl_no")[0].removeAttribute("required");

         document.getElementsByName("pod_cd")[0].setAttribute("required", true);
         document.getElementsByName("ofc_cd")[0].setAttribute("required", true);
     } else if (vSchTp=="B") {
         document.getElementsByName("vvd")[0].removeAttribute("required");
         document.getElementsByName("vvd")[0].removeAttribute("fullfill");
         document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
         document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
         document.getElementsByName("bl_no")[0].setAttribute("required", true);
         document.getElementsByName("pod_cd")[0].removeAttribute("required");
         document.getElementsByName("ofc_cd")[0].removeAttribute("required");
     }
}

/**
 * 화면 개체에 클릭했을 때의 이벤트 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objClick() {
   var objName = event.srcElement.name;
   var formObj = document.form;
   switch(objName) {
       case "sch_tp":
           var vSchTp = "";
           for (var i=0; i<formObj.sch_tp.length; i++) {
               if (formObj.sch_tp[i].checked) {
                   vSchTp = formObj.sch_tp[i].value;
               }
           }
           formObj.sch_tp.value = vSchTp;
           fnToggleSchTp(vSchTp, formObj);
           break;
       case "vvd":
           formObj.sch_tp[0].checked = true;
           fnToggleSchTp("V", formObj);
           break;
       case "snd_dt_fm":
           formObj.sch_tp[1].checked = true;
           fnToggleSchTp("D", formObj);
           break;
       case "snd_dt_to":
           formObj.sch_tp[1].checked = true;
           fnToggleSchTp("D", formObj);
           break;
       case "bl_no":
           formObj.sch_tp[2].checked = true;
           fnToggleSchTp("B", formObj);
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
    case "vvd":
        ComKeyOnlyAlphabet('uppernum');
        break;
    case "pod_cd":
        ComKeyOnlyAlphabet('uppernum');
        break;
    case "bl_no":
        ComKeyOnlyAlphabet('uppernum');
        break;
    case "ofc_cd":
        ComKeyOnlyAlphabet('upper');
        break;
    case "snd_dt_fm":
        obj_KeyPress(event.srcElement);
        break;
    case "snd_dt_to":
        obj_KeyPress(event.srcElement);
        break;

    }
}

/**
 * Cargo Release 화면으로 이동한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToANSend(sheetObj, formObj) {
    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return ;
    }

    var sRowArr = sRowStr.split("|");
    if(sRowArr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG00362");
        return;
    }

    var blNo = sheetObj.CellValue(sRowArr[0], "bl_no");

    if(blNo=="") {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return;  // 조회 실패로 데이터가 없어도, No Search 인경우 sRowStr == 0을 통과함에 따라 처리
    }

    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_0381.do?";
    param += "1=1";
    param += "&pgmNo=ESM_BKG_0381";
    param += "&sch_tp=B";
    param += "&bl_no=" + blNo;
    param += "&autoSearchFlg=Y";


    //선택되지 않을경우는 No Action
    //location.href=goUrl + param;
    //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
    ComOpenWindowCenter(goUrl + param, "ESM_BKG_0381", 1024, 640, true);
}

/**
 * Pre Pick-up 화면으로 이동한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToPrePickup(sheetObj, formObj) {
    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) { return ; }

    var sRowArr = sRowStr.split("|");
    if(sRowArr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG00362");
        return;
    }

    var blNo = sheetObj.CellValue(sRowArr[0], "bl_no");

    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_1066.do?";
    param += "1=1";
    param += "&pgmNo=ESM_BKG_1066";
    param += "&sch_tp=B";
    param += "&bl_no=" + blNo;


   //선택되지 않을경우는 No Action
   //location.href=goUrl + param;
   //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
    ComOpenWindowCenter(goUrl + param, "ESM_BKG_1066", 1024, 700, true);
}

/**
 * Pre-Hold 화면으로 이동한다.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToPreHold(sheetObj, formObj) {
    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) { return ; }

    var sRowArr = sRowStr.split("|");
    if(sRowArr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG00362");
        return;
    }

    var blNo = sheetObj.CellValue(sRowArr[0], "bl_no");

    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_0510.do?";
    param += "1=1";
    param += "&pgmNo=ESM_BKG_0510";
    param += "&sch_tp=B";
    param += "&bl_no=" + blNo;


    //선택되지 않을경우는 No Action
    //location.href=goUrl + param;
    //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
    ComOpenWindowCenter(goUrl + param, "ESM_BKG_0510", 1024, 700, true);
}


/**
 * Inbound CS 화면으로 이동한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToInboundCS(sheetObj, formObj) {
    var sRowStr = sheetObj.GetSelectionRows("|");

    if (sRowStr == "0" ) {
    	// 조회가 되지 않음 -- Please retrieve data first.
    	ComShowCodeMessage("BKG00012");
    	return ;
    }

    var sRowArr = sRowStr.split("|");
    if(sRowArr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG00362");
        return;
    }

    var blNo  = sheetObj.CellValue(sRowArr[0], "bl_no");
    var bkgNo = sheetObj.CellValue(sRowArr[0], "bkg_no");

    if (bkgNo == "") {
    	// 조회결과에 bkg_no가 없음 (즉 조회조건이 맞지않아 조회되지 않은경우) -- Please retrieve data first.
    	ComShowCodeMessage("BKG00012");
    	return;
    }

    var goUrl = "";
    var param = "";
    var actDoName = "";
    var actDoPageName = "";
    if (strCnt_cd == "US") {
        actDoName = "ESM_BKG_0668_01";
        actDoPageName = "06";
    } else {
        actDoName = "ESM_BKG_0292";
        actDoPageName = "04";
    }

    goUrl = "/hanjin/" + actDoName + ".do?";
    param += "1=1";
    param += "&pgmNo=" + actDoName ;
    param += "&bkg_no=" + bkgNo;


   //선택되지 않을경우는 No Action
   //location.href=goUrl + param;
   //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
  // ComOpenWindowCenter(goUrl + param, actDoName, 1024, 650, false);
   ComOpenWindowCenter(goUrl + param, actDoName, 1024, 700, true,"yes");
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {String} CondParam 필수, Query
 * @param {int} PageNo 필수, next Page no
 * @param {int} OnePageRows 필수, page size
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}


/**
 * ibSheet Double Click이벤트를 처리한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, sheet
 * @param {int} row 필수, row
 * @param {int} col 필수, column
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnDblClick(sheetObj, row, col) {
   var eventCol = sheetObj.ColSaveName(col);
   var eventValue = sheetObj.CellValue(row, col);
   switch (eventCol) {
       case "cn_nm":
           ComShowMemoPad(sheetObj, row, "cn_nm", true, 200, 100, 200 );
           break;
       case "nf_nm":
           ComShowMemoPad(sheetObj, row, "nf_nm", true, 200, 100, 200 );
           break;
   }
}

/* 개발자 작업  끝 */