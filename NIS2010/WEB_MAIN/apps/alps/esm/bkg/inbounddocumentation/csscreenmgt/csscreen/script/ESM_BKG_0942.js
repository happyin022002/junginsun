/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0942.js
 *@FileTitle : Inbound C/S Screen_Inquiry Pop up1(Multi container No Inquiry)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.16
 *@LastModifier : 안진응
 *@LastVersion : 1.0
 * 2009.06.16 안진응
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Inbound C/S Screen_Inquiry Pop up1(Multi container No Inquiry)에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class esm_bkg_0942 : esm_bkg_0942 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0942() {
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

var sheetObjects = new Array();
var sheetCnt = 0;
    

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
    
    
    /*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn1_Close":
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }    
    
    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    SheetGetData();
    
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
    var sheetId = sheetObj.id;

    switch(sheetId) {
        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 130;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                 var HeadTitle1 = "|SEQ||B/L No.|CNEE Name|Bkg No.|B/L Type|SPLIT FLG";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,    COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,     true,    "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,              30,    daCenter,    false,    "Seq");
                InitDataProperty(0, cnt++ , dtRadioCheck,        0,    daCenter,    false,    "radio",       false,      "",     dfNone,         0,      true,       true);
                InitDataProperty(0, cnt++ , dtData,            100,    daCenter,    false,    "bl_no",        false,        "",        dfNone,            0,        false,        true);                     
                InitDataProperty(0, cnt++ , dtData,            200,    daLeft,      false,    "cstms_desc",    false,        "",        dfNone,            0,        false,        true);
                InitDataProperty(0, cnt++ , dtData,            100,    daCenter,    false,    "bkg_no",        false,        "",        dfNone,            0,        false,        true);
                InitDataProperty(0, cnt++ , dtHidden,          100,    daCenter,    false,    "bl_tp_cd",    false,        "",        dfNone,            0,        false,        true);
                InitDataProperty(0, cnt++ , dtHidden,          100,    daCenter,    false,    "split_flg",    false,        "",        dfNone,            0,        false,        true);

                ColHidden("radio") = true;

                DataLinkMouse("mst_cvrd_bl_no") = true;
                DataLinkMouse("cntr_cmdt_desc") = true;
                DataLinkMouse("bkg_no")  = true;
                     
               CountPosition = 0;
            }
            break;
    }
}

/**
 * Sheet관련 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {String} sAction 필수, 작업코드
 * @param {String} CondParam 선택, 이전 조회 조건정보
 * @param {int} pageNo 선택, 페이지 번호
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_BKG_0942GS.do",FormQueryString(formObj));
            break;
    }
}



//     /**
//      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//      */
//     function validateForm(sheetObj,formObj,sAction){
//         with(formObj){
//            case IBSEARCH:
//             
//                 if(ComIsEmpty(formObj.frm_cntr_no.value) && ComIsEmpty(formObj.frm_po_no.value)){
//                     alert("검색할  Container No 또는 P/O No가 없습니다.");
//                     return false;
//                     
//                     break
//
//                 }
//                 
//             return true;
//     }


/**
 * 조회된 데이터를 더블 클릭 할 때 팝업을 띄워준다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {int} Row 필수, 행번호
 * @param {int} Col 필수, 열번호
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
    sheetObj.CellValue(Row, "radio") = 1;
    comPopupOK();
}

/**
 * Opener의 Sheet에서 Data를 가져온다.
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */      
function SheetGetData() {
    //
    var opener = window.dialogArguments;
    var sXml = opener.form.xmlData.value;
    sheetObjects[0].LoadSearchXml(sXml);
}

/**
* Opener의 Sheet에 Data를 기록한다.
* @param {void}
* @return void
 * @author Park Mangeon
 * @version 2009.10.01
*/      
function SheetSetData() {
    //
    var opener = window.dialogArguments;
    opener.sheetObjects[3].RemoveAll();
    opener.sheetObjects[3].LoadSearchXml(IBS_GetDataSearchXml(sheetObjects[0]));
}      

/* 개발자 작업  끝 */          