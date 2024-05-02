/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1022.js
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.12 문중철
* 1.0 Creation
* ======================================================
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
* 2012.10.31 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
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
     * @class ees_eqr_1022 : ees_eqr_1022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1022() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var IBSEARCH02  = 30;
//    
//    var PREFIX00  = "sheet1_";
//    var PREFIX01  = "sheet2_";
//    var PREFIX02  = "sheet3_";
    
    var PREFIX00  = "";
    var PREFIX01  = "";
    var PREFIX02  = "";    
    
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];


         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_Retrieve":
                	doActionIBSheet( sheetObject , formObject , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObject , formObject , IBSEARCH );
                break;

                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    formObject.reset();
                    document.getElementById("vvd").focus();
                    setHRText2();
                    break;
                break;

                case "btn_downexcel":
                    if ( sheetObjects[0].RowCount > 0 ) {
                        sheetObjects[0].SpeedDown2Excel( -1 , false , false , "" , "" , false );
                    }
                    if ( sheetObjects[1].RowCount > 0 ) {
                        sheetObjects[1].SpeedDown2Excel( -1 , true  , false , "" , "" , false );
                    }
                    if ( sheetObjects[2].RowCount > 0 ) {
                        sheetObjects[2].SpeedDown2Excel( -1 , true  , false , "" , "" , false );
                    }
                break;
                
                case "btn_vvd": //vvd 조회 팝업
                    var param = "?vvd_cd=" + formObject.vvd.value ;
                    ComOpenPopup( "/hanjin/COM_ENS_0B2.do" , 755, 450 , "popupFinish" , "1,0,1,1,1,1,1,1" , true );
                break;

                case "HRBTN":
                    var param = "?version=H&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/hanjin/EES_EQR_1057.do"+param , 940, 600 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                
                case "RMBTN":
                    var param = "?vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/hanjin/EES_EQR_1056.do"+param , 910, 620 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                
                case "DMBTN":
                    var param = "?version=D&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/hanjin/EES_EQR_1057.do"+param , 940, 600 , "" , "1,0,1,1,1,1,1,1" , true );
                break;                
                
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                alert("지금은 사용하실 수가 없습니다 ");
            } else {
                alert(e);
            }
        }
    }

    function popHRBTN(){
        var formObject = document.form;
        var param = "?version=H&vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/hanjin/EES_EQR_1057.do"+param , 940, 550 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    
    function popRMBTN(){
        var formObject = document.form;
        var param = "?vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/hanjin/EES_EQR_1056.do"+param , 910, 600 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    
    function popDMBTN(){
        var formObject = document.form;
        var param = "?version=D&vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/hanjin/EES_EQR_1057.do"+param , 940, 550 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    
    /**
     * lane code 팝업에서 선택한 값 Setting.
     */
    function popupFinish(aryPopupData, row, col, sheetIdx) {
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        formObject.vvd.value = aryPopupData[0][7];
        formObject.lane.value = aryPopupData[0][3];
        formObject.bay.value = aryPopupData[0][4];
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
    
    function form_click(){
    	srcName = window.event.srcElement.getAttribute("name");
    	
    	if ( srcName == "user"){
    		var userId = document.form.user.value;
    		if ( userId != "" ){
   				ComUserPopup(userId);
    		}
    	}
    }

    function initControl(){
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- form OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        axon_event.addListenerForm('click', 'form_click',    document.form); //- 클릭시
        document.form.vvd.focus();
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
        
        initControl();
        setHRText2();
        sheetObjects[0].ColHidden(4) = true;
        sheetObjects[0].ColHidden(5) = true;
        
//        sheetObjects[0].ColHidden(24) = true;
//        sheetObjects[0].ColHidden(25) = true;
//        sheetObjects[0].ColHidden(26) = true;
//        sheetObjects[0].ColHidden(27) = true;
//        
//        sheetObjects[1].ColHidden(24) = true;
//        sheetObjects[1].ColHidden(25) = true;
//        sheetObjects[1].ColHidden(26) = true;
//        sheetObjects[1].ColHidden(27) = true;
//        
//        sheetObjects[2].ColHidden(24) = true;
//        sheetObjects[2].ColHidden(25) = true;
//        sheetObjects[2].ColHidden(26) = true;
//        sheetObjects[2].ColHidden(27) = true;
        
        sheetObjects[0].ColHidden(25) = true;
        sheetObjects[0].ColHidden(26) = true;
        sheetObjects[0].ColHidden(27) = true;
        sheetObjects[0].ColHidden(28) = true;
        
        sheetObjects[1].ColHidden(25) = true;
        sheetObjects[1].ColHidden(26) = true;
        sheetObjects[1].ColHidden(27) = true;
        sheetObjects[1].ColHidden(28) = true;
        
        sheetObjects[2].ColHidden(25) = true;
        sheetObjects[2].ColHidden(26) = true;
        sheetObjects[2].ColHidden(27) = true;
        sheetObjects[2].ColHidden(28) = true;        

    }

    function setHRText2(){
        HRTEXT.innerText = "HR :    ";
        RMTEXT.innerText = "Rev. MTY :    ";
        DMTEXT.innerText = "DMG :    ";
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

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 102;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);
                    var HeadTitle = "|||MTY Volume|MTY Volume|MTY Volume|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|P2|P4|T2|T4";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    sheetObj.FrozenCols = 2;
    
                    var sumLine = "|"+PREFIX00+"d2| + |"+PREFIX00+"d4| + |"+PREFIX00+"d5| + |"+PREFIX00+"d7| + |"+PREFIX00+"r2| + |"+PREFIX00+"r5| + |"+PREFIX00+"r9| + |"+PREFIX00+"o2| + " +
                                  "|"+PREFIX00+"o4| + |"+PREFIX00+"o5| + |"+PREFIX00+"s2| + |"+PREFIX00+"s4| + |"+PREFIX00+"f2| + |"+PREFIX00+"f4| + |"+PREFIX00+"f5| + |"+PREFIX00+"a4| + " +
                                  "|"+PREFIX00+"a2| + |"+PREFIX00+"a5| + |"+PREFIX00+"p2| + |"+PREFIX00+"p4| + |"+PREFIX00+"t2| + |"+PREFIX00+"t4|";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30  , daCenter , false , PREFIX00+"ibflag"                                                             );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 20  , daCenter , false , PREFIX00+"del_chk"                                                            );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 0   , daCenter , true  , PREFIX00+"status"                                                             );
                    InitDataProperty( 0 , cnt++ , dtData         , 180 , daCenter , true  , PREFIX00+"pod_cd"  , false , ""      , dfNone        , -1 , false , false , 5 );
                    InitDataProperty( 0 , cnt++ , dtData         , 0   , daCenter , true  , PREFIX01+"yd_cd"   , false , ""      , dfNone        , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtData         , 0   , daCenter , true  , PREFIX01+"etb"     , false , ""      , dfDateYmd     , -1 , false , false     );      
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 50  , daRight  , false , PREFIX00+"total"   , false , sumLine , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"d2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"d4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"d5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"d7"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"r2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"r5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"r9"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"o2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"s2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"o4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"s4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"o5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"f2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"a2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"f4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"a4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"f5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 44  , daRight  , false , PREFIX00+"a5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"p2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"p4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"t2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"t4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    CountPosition = 0;

                }
            break;

            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 4, 100);

                    var HeadTitle = "|||POL|POL|ETD|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|P2|P4|T2|T4";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var sumLine2 = "|"+PREFIX01+"d2| + |"+PREFIX01+"d4| + |"+PREFIX01+"d5| + |"+PREFIX01+"d7| + |"+PREFIX01+"r2| + |"+PREFIX01+"r5| + |"+PREFIX01+"r9| + " +
                                   "|"+PREFIX01+"o2| + |"+PREFIX01+"o4| + |"+PREFIX01+"o5| + |"+PREFIX01+"s2| + |"+PREFIX01+"s4| + |"+PREFIX01+"f2| + |"+PREFIX01+"f4| + " +
                                   "|"+PREFIX01+"f5| + |"+PREFIX01+"a4| + |"+PREFIX01+"a5| + |"+PREFIX01+"a2| + |"+PREFIX01+"p2| + |"+PREFIX01+"p4| + |"+PREFIX01+"t2| + |"+PREFIX01+"t4|";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30 , daCenter , false , PREFIX01+"ibflag"                                                          );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 20 , daCenter , false , PREFIX01+"del_chk"                                                         );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 0  , daCenter , true  , PREFIX01+"status"                                                          );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenter , true  , PREFIX01+"pod_cd"  , false , ""       , dfNone        , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 40 , daCenter , true  , PREFIX01+"yd_cd"   , false , ""       , dfNone        , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenter , true  , PREFIX01+"etb"     , false , ""       , dfDateYmd     , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 50 , daRight  , false , PREFIX01+"total"   , false , sumLine2 , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"d2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"d4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"d5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"d7"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"r2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"r5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"r9"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"o2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"s2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"o4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"s4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"o5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"f2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"a2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"f4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"a4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"f5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX01+"a5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"p2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"p4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"t2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"t4"      , false , ""       , dfNullInteger , -1 , false , false );
                    CountPosition = 0;
                    
                }
            break;

            case "sheet3":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|||POD|POD|ETB|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|P2|P4|T2|T4";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var sumLine3 = "|"+PREFIX02+"d2| + |"+PREFIX02+"d4| + |"+PREFIX02+"d5| + |"+PREFIX02+"d7| + |"+PREFIX02+"r2| + |"+PREFIX02+"r5| + |"+PREFIX02+"r9| + |"+PREFIX02+"o2| + " +
                                   "|"+PREFIX02+"o4| + |"+PREFIX02+"o5| + |"+PREFIX02+"s2| + |"+PREFIX02+"s4| + |"+PREFIX02+"f2| + |"+PREFIX02+"f4| + |"+PREFIX02+"f5| + |"+PREFIX02+"a4| + " +
                                   "|"+PREFIX02+"a2| + |"+PREFIX02+"a5| + |"+PREFIX02+"p2| + |"+PREFIX02+"p4| + |"+PREFIX02+"t2| + |"+PREFIX02+"t4|";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30 , daCenter , false , PREFIX02+"ibflag"                                                          );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 20 , daCenter , false , PREFIX02+"del_chk"                                                         );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 0  , daCenter , true  , PREFIX02+"status"                                                          );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenter , true  , PREFIX02+"pod_cd"  , false , ""       , dfNone        , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 40 , daCenter , true  , PREFIX02+"yd_cd"   , false , ""       , dfNone        , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenter , true  , PREFIX02+"etb"     , false , ""       , dfDateYmd     , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 50 , daRight  , false , PREFIX02+"total"   , false , sumLine3 , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"d2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"d4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"d5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"d7"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"r2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"r5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"r9"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"o2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"s2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"o4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"s4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"o5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"f2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"a2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"f4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"a4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"f5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 44 , daRight  , false , PREFIX02+"a5"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"p2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"p4"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"t2"      , false , ""       , dfNullInteger , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"t4"      , false , ""       , dfNullInteger , -1 , false , false );
                    CountPosition = 0;

                    InitDataValid( 0 , PREFIX02+"pod_cd" , vtEngUpOnly , "" ); //대문자만
                }
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == 'sheet1') { 
                        for( var i = 0 ; i < sheetObjects.length ; i++ ){
                            sheetObjects[i].RemoveAll();    
                        }               
                		sheetObj.WaitImageVisible = false;
                		ComOpenWait(true);
                        formObj.f_cmd.value = SEARCH;    
                            
                        var sXml = sheetObj.GetSearchXml("EES_EQR_1024GS.do", FormQueryString(formObj));
                        var arrXml = sXml.split("|$$|");
                        var sCheck = ComGetEtcData(arrXml[0], "check");
                        var arrTpSz = sCheck.split("|");
                        if(arrTpSz[0] == '') arrTpSz[0] = 0;
                        if(arrTpSz[1] == '') arrTpSz[1] = 0;
                        if(arrTpSz[2] == '') arrTpSz[2] = 0;
                        HRTEXT.innerText = "HR : "       + arrTpSz[0];
                        RMTEXT.innerText = "Rev. MTY : " + arrTpSz[2];
                        DMTEXT.innerText = "DMG : "      + arrTpSz[1];
                        for( var i = 0 ; i < arrXml.length ; i++ ){  
                            sheetObjects[i].LoadSearchXml(arrXml[i]);
                        }
                		sheetObj.WaitImageVisible = true;
                		ComOpenWait(false);
                    }                     
                } else {
                    return;
                }
            break;

            case IBSEARCH_ASYNC01:      // VVD 조회
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = SEARCH01;
                    sheetObj.WaitImageVisible = false;
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1024GS.do",FormQueryString(formObj));
                    var sCheck = ComGetEtcData(sXml, "check");
                    var arrTpSz = sCheck.split("|");
//                    alert("sCheck [" + sCheck + "]");
                    document.form.lane.value = arrTpSz[0];
                    document.form.bay.value = arrTpSz[1];
                //    document.form.version.value = arrTpSz[2];
                    if(arrTpSz[2] == "C"){
                    	document.form.version.value = "C";
                	}
                    else{
                    	document.form.version.value = "##";
                    }
                    document.form.remark.value = arrTpSz[4];
                    sheetObj.WaitImageVisible = true;
                } else {
                    return;
                }
            break;
        }
    }
  
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction == IBSEARCH){
                if(vvd.value == ""){
//                    ComShowCodeMessage("EQR21001","VVD Code ");
                    ComShowCodeMessage("EQR90191","VVD Code ");
					
                    ComSetFocus(vvd);
                    return false;
                }                
            }
        }
        return true;
    }
    
    // Total 행의 0을 제거한다.
    function removeZero(sheetObj) {
        with(sheetObj) {
            var sCol = 6;
            var eCol = LastCol;
            for ( i = sCol ; i <= eCol ; i++ ) {
                if ("" == SumText(0, i) ) {
                    SumText(0, i) = "0";
                }
            }
        }
    }
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
            ColBackColor(PREFIX00+"pod_cd") = RgbColor(229, 234, 255);
            //SumText(0, PREFIX00+"pod_cd") = "Onboard Total";
            MessageText("Sum") = "Onboard Total";
            CellAlign(0,PREFIX00+"pod_cd") = daCenter;
            removeZero(sheetObj);
            sheetObjects[0].ColHidden(4) = true;
            sheetObjects[0].ColHidden(5) = true;
        }
    }

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
            SumText ( 0 , PREFIX01 + "pod_cd") = "Additonal Load Total";
   //         SumText ( 0 , PREFIX01 + "yd_cd" ) = "Additonal Load Total";
   //         SumText ( 0 , PREFIX01 + "etb"   ) = "Additonal Load Total";
            SetMergeCell(LastRow, 3 , 1 , 3); 
            CellAlign(LastRow	 ,PREFIX01 + "pod_cd") = daCenter;

           // SumText ( 0 , PREFIX01 + "pod_cd") = "Add. Load";
           // SumText ( 0 , PREFIX01 + "yd_cd" ) = "Total";
           // SumText ( 0 , PREFIX01 + "etb"   ) = "";
            removeZero(sheetObj);
            //for ( var i = 7 ; i < 27 ; i++ ) {
            for ( var i = 7 ; i < 28 ; i++ ) {	
                sheetObjects[0].CellValue2(2,i) = SumValue(0, i);
            }
        }
    }

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
            SumText(0, PREFIX02+"pod_cd") = "Discharge Total";
            SetMergeCell(LastRow, 3 , 1 , 3); 
            CellAlign(LastRow	 ,PREFIX02+"pod_cd") = daCenter;
            removeZero(sheetObj);
            var tVer = document.form.version.value;
            if ( tVer == "I" ) {
                //for( var i = 7 ; i < 27 ; i++ ) {
                for( var i = 7 ; i < 28 ; i++ ) {    	
                    sheetObjects[0].CellValue2(1,i) = sheetObj.SumValue(0,i);
                }
            }
        }
    }
     
   /* 
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate() {
        switch (event.srcElement.name) {
            case "vvd":
                if(event.srcElement.value != ""){
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                }
            break;
        }           
        return true;
    }
    */
    /**
     * 
     */
	function obj_keypress(){
	    //alert("event.srcElement.name ["+event.srcElement.name+"]");
	    switch(event.srcElement.name){
	        case "vvd":
	            ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
	        break;
	    }   
	}    
        