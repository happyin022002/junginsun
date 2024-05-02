/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0694.js
 *@FileTitle : DO LIST CHECK REPORT(JAPAN)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.05.19 박만건
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2012.06.28 김보배 [CHM-201218501] [BKG] Japan Cargo Release Performance에 DOR I/F 처리 결과에 대한 표시 컬럼 추가 요청
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview DO LIST CHECK REPORT(JAPAN)에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class esm_bkg_0694 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0694() {
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

            case "btn_Retrieve":
                // VVD조회일 경우 내부 변수로 VVD 값을 복사한다.
                if (formObject.rd_flag[0].checked) {
                    formObject.vsl_cd.value     = formObject.vvd.value.substring(0,4);
                    formObject.skd_voy_no.value = formObject.vvd.value.substring(4,8);
                    formObject.skd_dir_cd.value = formObject.vvd.value.substring(8,9);
                }
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;

            case "btn_Downexcel":
                fnExcelSheet(sheetObject1);
                break;

            case "btn_cargo":
                fnMoveToCargoRelease(sheetObject1);
                break;

            case "btn_print":
                fnPrintSheet(sheetObject1);
                break;
                
            case "btn_if":
            	sendEdi(sheetObject1);
            	break;

            case "btn_evnt_dt":
                formObject.rd_flag[1].checked = true;
            	fnSetUpUIByRdFlag();
            	var cal = new ComCalendarFromTo();
                cal.select(formObject.evnt_dt_start, formObject.evnt_dt_end, 'yyyy-MM-dd');
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
    		sheetInit(i);
        }
    }

    // 상단 조회조건 Control
    fnSetUpUIByRdFlag();

    initControl();
    //초기화시 처리필요

//    form.vvd.value="HNCS0021W";
//    form.pod_cd.value="JPUKB";
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
        case "sheet1":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 450;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                //MergeSheet = msPrevColumnMerge;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 2, 100);
                
                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false,false);
                
                var HeadTitle1 = "|Sel|No.|VVD|POD|DEL|Issue OFC|B/L No.|D/O ID|DOR I/F|Issue Date|Consignee|Notify|Issue Pop-up|Remark(s)|BkgNo|cgo remark|evntUsrId|rlse_seq|OB/L Rdem|Hold|Full/Mty";

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                var headCount = ComCountHeadTitle(HeadTitle1);
                
                InitColumnInfo(headCount, 0, 0, true);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);


                //데이터속성  [ROW,   COL,  DATATYPE,      WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter,   true,  "ibflag");
                InitDataProperty(0, cnt++,  dtCheckBox,     40,  daCenter,    false, "chk_edi");
                InitDataProperty(0, cnt++ , dtSeq,          30,   daCenter,   true,  "Seq",         false,        "",      dfNone,       -1     ,   false);

                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   true,  "vvd",         false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         45,   daCenter,   true,  "pod_cd",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         45,   daCenter,   true,  "del_cd",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         65,   daCenter,   true,  "evnt_ofc_cd", false,        "",      dfNone,       -1     ,   false);

                InitDataProperty(0, cnt++ , dtData,         85,   daCenter,   true,  "bl_no",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         95,   daCenter,   true,  "do_no",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         55,   daCenter,   true,  "dor_if",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   true,  "evnt_dt",     false,        "",      dfDateYmd,    -1     ,   false);

                InitDataProperty(0, cnt++ , dtData,         120,  daCenter,   true,  "cn_nm",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         120,  daCenter,   true,  "nf_nm",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   true,  "do_rsn_rmk",  false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         135,  daCenter,   true,  "do_rmk",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtHidden,       100,  daCenter,   false, "bkg_no",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtHidden,       100,  daCenter,   false, "cgo_rmk",     false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtHidden,       100,  daCenter,   false, "evnt_usr_id", false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtHidden,       100,  daCenter,   false, "rlse_seq", false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         70,  daCenter,   false, "obl_rdem_flg", false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         40,  daCenter,   false, "do_hld_flg", false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         55,  daCenter,   false, "full_mty_cd", false,        "",      dfNone,       -1     ,   false);
                
                CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
                SelectionMode = smSelectionList;
                Ellipsis  = true;
                WaitImageVisible = false;
                
                ToolTipOption="balloon:true;width:320;forecolor:#666666;backcolor:#FFFFFF;icon:1";
            }
            break;

        case "sheet2":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 0;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                //MergeSheet = msPrevColumnMerge;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, true, false,false)

                var HeadTitle1 = "VVD|POD|DEL|Issue OFC|B/L No.|D/O ID|Issue Date|Remark|Consignee|Notify|Remark for Release";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);


                //데이터속성  [ROW,   COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   true,  "vvd",         false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         45,   daCenter,   true,  "pod_cd",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         45,   daCenter,   true,  "del_cd",      false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   true,  "evnt_ofc_cd", false,        "",      dfNone,       -1     ,   false);

                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,   true,  "bl_no",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         75,   daCenter,   true,  "do_no",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         85,   daCenter,   true,  "evnt_dt",     false,        "",      dfDateYmd,    -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         85,   daCenter,   true,  "do_rmk",      false,        "",      dfNone,       -1     ,   false);

                InitDataProperty(0, cnt++ , dtData,         140,  daCenter,   true,  "cn_nm",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         140,  daCenter,   true,  "nf_nm",       false,        "",      dfNone,       -1     ,   false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   true,  "do_rsn_rmk",  false,        "",      dfNone,       -1     ,   false);

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
    ////sheetObj.ShowDebugMsg = true;

    //다중조회

    switch(sAction) {

        case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
            if(validateForm(sheetObj,formObj,sAction)) {
                if(formObj.rd_flag[1].checked == true) {
                 	if (!ComBkgMonthsBetweenCheck(formObj.evnt_dt_start.value, formObj.evnt_dt_end.value, 1, "-")) {
                 		// only less than {?msg1}-month periods allowed
                 		ComShowCodeMessage("BKG40013", "1");
                 		return;
                 	}
                 }

            	if(sheetObj.id == "sheet1") {
            		ComOpenWait(true,true);
                    sheetObj.DoSearch("ESM_BKG_0694GS.do",FormQueryString(formObj) ,"page_no=1", false);
                }
            }

            break;

        case IBSEARCHAPPEND:
        	ComOpenWait(true,true);
            sheetObj.DoSearch("ESM_BKG_0694GS.do"
                    , CondParam
                    ,"page_no=" + PageNo
                    , true
             );
            break;

    }
}

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
    axon_event.addListenerForm('click', 'objClick', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('focus', 'objFocus', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);
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
        case "rd_flag":
            fnSetUpUIByRdFlag();
            break;
        case "vvd":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "pod_cd":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "rlse_sts_cd":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_ofc_cd":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_start":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_end":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
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
	   case "evnt_ofc_cd":
	   	   ComKeyOnlyAlphabet('upper');
		   break;
	   case "evnt_dt_start":
	   	   obj_KeyPress(event.srcElement);
		   break;
	   case "evnt_dt_end":
	   	   obj_KeyPress(event.srcElement);
		   break;
   }
}


/**
 * 화면 개체이 포커스를 받았을 때의 이벤트 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objFocus() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "vvd":
        case "pod_cd":
        case "rlse_sts_cd":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_ofc_cd":
        case "evnt_dt_start":
        case "evnt_dt_start":
        case "evnt_dt_s":
        case "evnt_dt_s":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
    }
}

/**
 * radio버튼에 따라 상단 조회조건 상태를 변경한다.<br>
 * param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnSetUpUIByRdFlag() {
    var formObj = document.form;
    with(formObj) {
        if(rd_flag[0].checked == true) {
            document.getElementsByName("vvd")[0].setAttribute("required", true);
            document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
            document.getElementsByName("pod_cd")[0].setAttribute("required", true);
            document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
            document.getElementsByName("rlse_sts_cd")[0].setAttribute("required", true);

            document.getElementsByName("evnt_ofc_cd")[0].removeAttribute("required");
            document.getElementsByName("evnt_ofc_cd")[0].removeAttribute("fullfill");
            document.getElementsByName("evnt_dt_start")[0].removeAttribute("required");
            document.getElementsByName("evnt_dt_end")[0].removeAttribute("required");

        } else {

            document.getElementsByName("vvd")[0].removeAttribute("required");
            document.getElementsByName("vvd")[0].removeAttribute("fullfill");
            document.getElementsByName("pod_cd")[0].removeAttribute("required");
            document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
            document.getElementsByName("rlse_sts_cd")[0].removeAttribute("required");

            document.getElementsByName("evnt_ofc_cd")[0].setAttribute("required", true);
            document.getElementsByName("evnt_ofc_cd")[0].setAttribute("fullfill", true);
            document.getElementsByName("evnt_dt_start")[0].setAttribute("required", true);
            document.getElementsByName("evnt_dt_end")[0].setAttribute("required", true);
        }
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
    switch (sAction){
        case IBSEARCH:
            if(!ComChkValid(formObj)) return false;
            break;
    }

    return true;
}

/**
 * ibSheet OnClick이벤트를 처리한다.<br>
 * 고객명을 선택하면 전체 고객명을 메모페드를 이용하여 보여준다.<br>
 * @param {Object} sheetObj필수, Sheet
 * @param {int} row 필수, 행번호
 * @param {int} col 필수, 열번호
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

/**
 * Sheet Click시 발생하는 Event<br>
 * FOC가 Clear된 경우에는 Pick-Up번호를 보여준다.<br>
 * @param {Object} sheetObj 필수, Sheet
 * @param {int} PageNo 필수, next Page no
 * @param {int} OnePageRows 필수, page size
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnClick(sheetObj, row, col) {
    var eventCol = sheetObj.ColSaveName(col);
    var eventValue = sheetObj.CellValue(row, col);
    switch (eventCol) {
        case "do_rsn_rmk":
	        if(eventValue == "Yes" ) {
	        	var condition = "?";
	            condition += "bkg_no="+sheetObj.CellValue(row, "bkg_no");
	            condition += "&remark="+encodeURI(sheetObj.CellValue(row, "cgo_rmk"));
	            condition += "&evnt_dt="+sheetObj.CellValue(row, "evnt_dt");
	            condition += "&evnt_usr_id="+sheetObj.CellValue(row, "evnt_usr_id");
	            result = ComOpenWindowCenter('/hanjin/ESM_BKG_0954.do' + condition, "ESM_BKG_0954", 500, 200, true);
	        }
        	break;
    }
}

/**
 * Scroll이 닿을 때 Next Page처리<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {String} CondParam 필수, 조회조건
 * @param {int} PageNo 필수, 페이지 번호
 * @param {int} OnePageRows 선택, 페이지당 조회수
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
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
    if(sheetObj.RowCount("R")<=0) return;

    var startRow = 1;
    var maxRow = sheetObj.LastRow;

    if (maxRow < 101) {
        startRow = 1;
    } else if (((maxRow - 1.0)%100.0) == 0 ) {
        startRow = maxRow - 100 + 1;
    } else {
        startRow = maxRow - ((maxRow - 1.0)%100.0);
    }

}



/**
 * 선택된 row를 Cargo Relese로 보낸다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToCargoRelease(sheetObj) {
    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" || sRowStr == "" ) {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return ;
	}
    //alert(sRowStr);
    var sRowArr = sRowStr.split("|");
    //alert(sRowArr[0]);
    var bkgNo = sheetObj.CellValue(sRowArr[0], "bkg_no");
    if(bkgNo == "") {
    	// As there is no result retrieved..
     	ComShowCodeMessage("BKG00221");
    	return; // 조회 실패로 데이터가 없어도, No Search 인경우 sRowStr == 0을 통과함에 따라 처리
    }

    if(sRowArr.length > 1){
        //대상을 하나만 지정해주시기 바랍니다.
        ComShowCodeMessage("BKG00362");
        return;
    }

    var blNo = sheetObj.CellValue(sRowArr[0], "bl_no");
    var cntrNo = sheetObj.CellValue(sRowArr[0], "cntr_no");

    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_0326.do?";
    param += "mainPage=true"
    param += "&pgmNo=ESM_BKG_0326";
    param += "&bl_no=" + blNo;
    param += "&cntr_no=" + cntrNo;

    //선택되지 않을경우는 No Action
    location.href=goUrl + param;
    //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
}

/**
 * 선택한 row를 copy하고 Print한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnPrintSheet(sheetObj) {
	//2010-03-19 by sungho
	if(sheetObj.rowcount < 1){//결과가 없을경우
		ComShowCodeMessage("BKG00109");
	}else{
		//mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],
		//         [ReportPageUrl], [HideExcelMsg],[WriteTreeLevel], [WorkSheetName],
		//         [FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect],[bFormula],
		//         [IncludeImageType])

		//sheetObject1.Down2Excel(true, false, false, true, "",
		//    "", false, false, "",
		//    true);//열린 탭에 따라 엑셀다운로드

		sheetObj.Down2Print(true,2, "DO List Check Report (JAPAN)");

	}
	return;

	//다음의 부분은 사용되지 않는 소스부분입니다.
	sheetInit(1);
	var prtSheet = sheetObjects[1];
	prtSheet.removeAll();
	ComOpenWait(true);

    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" || sRowStr == "" ) {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
     	ComOpenWait(false);
    	return ;
    }

    var sRowArr = sRowStr.split("|");
    var bkgNo = sheetObj.CellValue(sRowArr[0], "bkg_no");
    if(bkgNo == "") {
    	// As there is no result retrieved..
     	ComShowCodeMessage("BKG00221");
     	ComOpenWait(false);
    	return; // 조회 실패로 데이터가 없어도, No Search 인경우 sRowStr == 0을 통과함에 따라 처리
    }

    for (var idx=0; idx <sRowArr.length; idx++) {
        fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
    }

    ComOpenWait(false);
    prtSheet.Down2Print(true,2, "DO List Check Report (JAPAN)");
}

/**
 * 선택한 row를 copy하고 Excel로 추출한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnExcelSheet(sheetObj) {
	//2010-03-19 by sungho
	if(sheetObj.rowcount < 1){//결과가 없을경우
		ComShowCodeMessage("BKG00109");
	}else{
		//mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],
		//         [ReportPageUrl], [HideExcelMsg],[WriteTreeLevel], [WorkSheetName],
		//         [FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect],[bFormula],
		//         [IncludeImageType])

		//sheetObject1.Down2Excel(true, false, false, true, "",
		//    "", false, false, "",
		//    true);//열린 탭에 따라 엑셀다운로드

		sheetObj.SpeedDown2Excel(-1);

	}

	//다음의 부분은 사용되지 않는 소스부분입니다.
	return;
	// SHEET INIT
	sheetInit(1);
	var prtSheet = sheetObjects[1];
	prtSheet.removeAll();
    ComOpenWait(true);

    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" || sRowStr == "" ) {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
     	ComOpenWait(false);
    	return ;
    }

    var sRowArr = sRowStr.split("|");
    var bkgNo = sheetObj.CellValue(sRowArr[0], "bkg_no");
    if(bkgNo == "") {
    	// As there is no result retrieved..
     	ComShowCodeMessage("BKG00221");
     	ComOpenWait(false);
    	return; // 조회 실패로 데이터가 없어도, No Search 인경우 sRowStr == 0을 통과함에 따라 처리
    }

    for (var idx=0; idx <sRowArr.length; idx++) {
        fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
    }

    prtSheet.SpeedDown2Excel();
    ComOpenWait(false);
}

/**
 * targetObj에 새로운 라인을 추가하여 source의 특정 row를 복사한다.<br>
 * @param {Object} targetObj 필수, 목적객체
 * @param {Object} sourceObj 필수, 소스객체
 * @param {int} row 필수, 행번호
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnCopyRow(targetObj, sourceObj, row) {
    var lastIdx = targetObj.LastCol;
    var newIdx = targetObj.DataInsert(-1);
    for (var idx=0; idx<= lastIdx; idx++) {
        targetObj.CellValue2(newIdx, targetObj.ColSaveName(idx)) = sourceObj.CellValue(row, targetObj.ColSaveName(idx));
    }
}


/**
 * DOR EDI 전송
 */
var intervalId;
function sendEdi(sheetObj) {
	
	if (sheetObj.CheckedRows("chk_edi") < 1){
		//msgs['BKG43052'] = "Please select at least one row by mouse click in order to Edi"
        ComShowCodeMessage("BKG43052");
        return;
    }
		
        //SaveName이 "pass_yn"인 행에서만 체크된 행의 번호를 읽어온다.
        var checkedRows = sheetObj.FindCheckedRow("chk_edi");
//alert(checkedRows);
        //가져온 행을 배열로 반든다.
        var arrRow = checkedRows.split("|");
        for (var i = 0; i < arrRow.length -1; i++){
        	//alert(sheetObj.CellValue(arrRow[idx], "blIss_ibflag") = 'U');
        	
//        	alert(sheetObj.CellValue(arrRow[i], "bl_no"));
        	if(ComIsNull(sheetObj.CellValue(arrRow[i], "do_no"))){
        		//msgs['BKG03061'] = "{?msg1} is not available."
        		ComShowCodeMessage("BKG03061","BL_NO:"+sheetObj.CellValue(arrRow[i], "bl_no") + "(D/O ID is NULL) ");
        		sheetObj.SelectCell(arrRow[i],"do_no"); 
        		return;
        	}
        	if(sheetObj.CellValue(arrRow[i], "dor_if") == "Y"){
        		//msgs['BKG03061'] = "{?msg1} is not available."
        		sheetObj.CellValue2(arrRow[i],"chk_edi") = 0;
        		ComShowCodeMessage("BKG03061","BL_NO:"+sheetObj.CellValue(arrRow[i], "bl_no") + "(DOR IF is 'Y') ");
        		sheetObj.SelectCell(arrRow[i],"dor_if"); 
        		return;
        	}
        	//Original Bill of Lading Status N 이면 Release 진행 불가
        	if(sheetObj.CellValue(arrRow[i], "obl_rdem_flg") == "N"){
        		sheetObj.CellValue2(arrRow[i],"chk_edi") = 0;
        		ComShowCodeMessage("BKG03061","BL_NO:"+sheetObj.CellValue(arrRow[i], "bl_no") + "(Original Bill of Lading Status is 'N') ");
        		sheetObj.SelectCell(arrRow[i],"obl_rdem_flg"); 
        		return;
        	}
        	
        	//do_hld_flg Y이면 진행불가
        	if(sheetObj.CellValue(arrRow[i], "do_hld_flg") == "Y"){
        		sheetObj.CellValue2(arrRow[i],"chk_edi") = 0;
        		ComShowCodeMessage("BKG03061","BL_NO:"+sheetObj.CellValue(arrRow[i], "bl_no") + "(Hold is 'Yes') ");
        		sheetObj.SelectCell(arrRow[i],"do_hld_flg"); 
        		return;
        		
        	}
        	
        	//// Empty Container Check!
        	if(sheetObj.CellValue(arrRow[i], "full_mty_cd") == "EMPTY"){
        		sheetObj.CellValue2(arrRow[i],"chk_edi") = 0;
        		ComShowCodeMessage("BKG03061","BL_NO:"+sheetObj.CellValue(arrRow[i], "bl_no") + "(Container is Empty) ");
        		sheetObj.SelectCell(arrRow[i],"full_mty_cd"); 
        		return;
        	}
        }
        	
        
        //msgs['BKG00722'] = "Are You Sure To Transmit With DO ID [{?msg1}]?"
        if(!ComShowCodeConfirm('BKG00722', " The selected B/L NOs")){
            return false;
        }
        
        var formObj = document.form;
         formObj.f_cmd.value = MULTI01;
         ComOpenWait(true);
         var sXml = sheetObj.GetSaveXml("ESM_BKG_0694GS.do", FormQueryString(formObj) + "&svc_cd=D&" + sheetObj.GetSaveString(false, false, "chk_edi"));
         var key = ComGetEtcData(sXml, "KEY");
         intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
}


/**
 * BackEndJob : retrieve<br>
 * 
 * @param sheetObj
 * @param sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0694GS.do?f_cmd=" + SEARCH09 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	
	// ending waiting status in case of erro
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowCodeMessage('BKG00101'); 
		doActionIBSheet(sheetObj,form,IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
}




       /* 개발자 작업  끝 */