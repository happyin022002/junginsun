/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_1035.js
*@FileTitle      : CY or Destuffing Setup(Vietnam) Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.02
*@LastModifier   : 안진응
*@LastVersion    : 1.0
* 2009.07.02 안진응
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
     * @author 임진영
     */

    /**
     * @extends
     * @class esm_bkg_1035 : esm_bkg_1035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1035() {
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

    var sheet1 = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[sheet1];
        /*******************************************************/

//        try {
            var srcName = window.event.srcElement.getAttribute("name");


            switch(srcName) {
                case "btn_Setup":
                    doActionIBSheet(sheetObject1,document.form,IBINSERT);
                    window.close();
                break;

                case "btn_Close":
                    window.close();
                    break;
            } // end switch
//      }catch(e) {
//          if( e == "[object Error]") {
//              ComShowMessage(OBJECT_ERROR);
//          } else {
//              ComShowMessage(e);
//          }
//      }
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
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }

        if (document.form.bkg_no.value != '') {
            doActionIBSheet(sheetObjects[sheet1],document.form,IBSEARCH);
        }
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      //sheet1 init
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
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle1 = "ibflag|bkg_no|rlse_seq|vn_cgo_de_cd";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true)


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix="sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,    true,     prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,        125,    daCenter,    true,     prefix + "bkg_no",        false,    "",      dfNone,          0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        125,    daCenter,    true,     prefix + "rlse_seq",      false,    "",      dfNone,          0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        125,    daCenter,    true,     prefix + "vn_cgo_de_cd",  false,    "",      dfNone,          0,     false,       false);

					CountPosition = 0;
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;

                ComOpenWait(true);
                sheetObjects[sheet1].WaitImageVisible = false;
                formObj.f_cmd.value = SEARCH;

                var aryPrefix = new Array("sheet1_"); //prefix 문자열 배열
                var sXml = sheetObj.GetSearchXml("ESM_BKG_1035GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

                var arrXml = sXml.split("|$$|");
                for(var idx = 0; idx < arrXml.length; idx++){

                    sheetObjects[idx].Redraw = false;
                    if(idx > 0) {

                        sheetObjects[idx].WaitImageVisible = false;
                    }
                    sheetObjects[idx].LoadSearchXml(arrXml[idx]);
                    sheetObjects[idx].Redraw = true;
                }

                sheetObjects[sheet1].WaitImageVisible = true;

            break;

            case IBINSERT:
                //if(!validateForm(sheetObj,formObj,sAction)) return false;

                formObj.f_cmd.value = MULTI;

                copyFormTosheet1();

                var sParam1 = sheetObjects[sheet1].GetSaveString();

                //그리드의 변경 여부 체크
                if(! sheetObjects[sheet1].IsDataModified){
                    ComShowCodeMessage('BKG00743');
                    return false;
                }

                if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
                    return false;
                }

                var aryPrefix = new Array("sheet1_");    //prefix 문자열 배열
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_1035GS.do", sparam);

                sheetObjects[sheet1].LoadSaveXml(sXml);

                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
            break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
            case IBSEARCH:
                if(ComIsEmpty(formObj.bkg_no.value)){
                    ComShowCodeMessage('BKG00554');
                    return false;
                }
            break;

            case IBINSERT:
                if(ComIsEmpty(formObj.bkg_no.value)){
                    ComShowCodeMessage('BKG00554');
                    return false;
                }
            break;
        }
        return true;
    }

    /**
     * sheet1를 저장하고 나서 처리할 사항
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
           doActionIBSheet(sheetObjects[sheet1],document.form,IBSEARCH);
        }
    }

    /**
     * 화면에 입력한 값을 sheet1에 Copy한다.
     */
    function copyFormTosheet1() {
        var rowCnt = sheetObjects[sheet1].RowCount;
        var prefix="sheet1_";

        if (rowCnt > 0) {      //기존 자료가 존재하는 경우
//          2010.04.09 수정 지침에 따라서 수정(안진응)
//            sheetObjects[sheet1].CellValue2(rowCnt,prefix + "ibflag") = "U";
        	sheetObjects[sheet1].RowStatus(rowCnt) = "U";
        } else {               //신규 입력인 경우
            rowCnt = sheetObjects[sheet1].DataInsert(-1);
//      2010.04.09 수정 지침에 따라서 수정(안진응)
//            sheetObjects[sheet1].CellValue2(rowCnt,prefix + "ibflag") = "I";
        	sheetObjects[sheet1].RowStatus(rowCnt) = "I";
        }

        sheetObjects[sheet1].CellValue2(rowCnt,prefix + "bkg_no")       = document.form.bkg_no.value;
        sheetObjects[sheet1].CellValue2(rowCnt,prefix + "vn_cgo_de_cd") = document.form.vn_cgo_de_cd.value;
    }

    /**
     * sheet1의 조회가 완료된 시점에 값을 설정한다.
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var prefix = "sheet1_";
        var formObject = document.form;

        if (ErrMsg == "") {
            //if(sheetObj.RowCount > 0){
            if(sheetObj.CellValue(1, prefix + "vn_cgo_de_cd") !=''){//2009-12-29 임진영
                document.form.vn_cgo_de_cd.value = sheetObj.CellValue(1, prefix + "vn_cgo_de_cd");
            }else{
                document.form.vn_cgo_de_cd.options.value = 'A';
            }
        }
        ComOpenWait(false);
    }
    /* 개발자 작업  끝 */