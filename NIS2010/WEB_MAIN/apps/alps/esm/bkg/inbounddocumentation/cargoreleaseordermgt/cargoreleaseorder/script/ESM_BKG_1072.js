/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_1072.js
*@FileTitle      : Cargo Release Order Demurrage
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-12-08
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009-12-08 임진영
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Cargo Release Order Demurrage 업무에서 사용하는 자바스크립트파일.
     * @author 임진영
     */

    /* 개발자 작업  */

    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_close":
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
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        SheetGetData();
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 110;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = " |Invoicing|Settled|DEM Commence|InvoiceUpto|Invoice Amounts|Invoice Amounts|CNTR_NO|";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,                    KEYFIELD,    CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="demDtl_";
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,    daCenter,  false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"dmdt_inv_sts_cd",  false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"dmdt_ar_if_cd",    false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          100,   daCenter,  false,     prefix +"ft_end_dt",        false,       "",         dfDateYmd,  0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"to_mvmt_dt",       false,       "",         dfDateYmd,  0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          40,    daCenter,  false,     prefix +"inv_curr_cd",      false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,    daCenter,  false,     prefix +"bil_amt",          false,       "",         dfNumber,   0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,    daCenter,  false,     prefix +"cntr_no",          false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,    daRight,   false,     prefix +"inv_chg_amt",      false,       "",         dfNumber,   0,          false,       true);

                    CountPosition = 0;
                }
            break;
        }
    }

    /**
     * Opener의 Sheet에서 Data를 가져온다.
     * @param {void}
     * @return void
     */      
    function SheetGetData() {
        var sXml = dialogArguments.form.demDtlXmlData.value;
        sheetObjects[0].LoadSearchXml(sXml);
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
    function sheet1_OnSearchEnd(sheetObj){

        var invTotBilAmt = 0;

        //부모창에서 선택 된 컨테이너 번호
        var cntr_no = document.getElementById("cntr_no").value;

        for(var idx=1; idx <= sheetObj.RowCount; idx++){
            //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
            if(cntr_no != sheetObjects[0].CellValue(idx, "demDtl_cntr_no")){
                sheetObjects[0].RowHidden(idx) = true;
            }
        }
    }