// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab1 = 1;
var beforetab2 = 1

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];

    /** **************************************************** */
    var formObject = document.form;
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            break;

        case "btn_new":
            formObject.reset();
            sheetObject1.removeall();
            break;

        case "btn_downexcel":
            doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
            break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('COM12111'))
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
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);

        //doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
    }

    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'port_code', 'hub_code', 'lane_code', 'bs_code', 'dest');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    switch (sheetObj.id) {
    case "sheet1": //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 405;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 15, 100);

            var HeadTitle1 = "|NO.|PORT|HUB|LANE|BS CODE|DEST";
            var headCount = ComCountHeadTitle(HeadTitle1);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus,  0,      daCenter, true, "ibflag");
            InitDataProperty(0, cnt++, dtSeq,           50,     daCenter, true, "",             false, "", dfNone, 0, true,  true);
            InitDataProperty(0, cnt++, dtData,          130,    daCenter, true, "port_code",    false, "", dfNone, 0, false, true);
            InitDataProperty(0, cnt++, dtData,          130,    daCenter, true, "hub_code",     false, "", dfNone, 0, false, true);
            InitDataProperty(0, cnt++, dtData,          130,    daCenter, true, "lane_code",    false, "", dfNone, 0, false, true);
            InitDataProperty(0, cnt++, dtData,          130,    daCenter, true, "bs_code",      false, "", dfNone, 0, false, true);
            InitDataProperty(0, cnt++, dtData,          130,    daCenter, true, "dest",         false, "", dfNone, 0, false, true);

            // CountPosition = 0;

        }
        break;

    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;
    switch (sAction) {
        case IBSEARCH: //조회
            if (validateForm(sheetObj, formObj, sAction))
                if (sheetObj.id == "sheet1") {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Post("ESD_PRD_0072GS.do", PrdFQString(formObj));
                }

            break;

        case IBDOWNEXCEL: //엑셀 다운로드

            sheetObj.SpeedDown2Excel(-1, false, false);
            break;

    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
        //            if (!isNumber(formObj.iPage)) {
        //                return false;
        // }
    }

    return true;
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab2_OnChange(tabObj, nItem) {

    var objs = document.all.item("tabLayer2");

    objs[nItem].style.display = "Inline";
    objs[beforetab2].style.display = "none";

    // --------------- 요기가 중요 --------------------------//
    objs[beforetab2].style.zIndex = objs[nItem].style.zIndex - 1;
    // ------------------------------------------------------//
    beforetab2 = nItem;
}
