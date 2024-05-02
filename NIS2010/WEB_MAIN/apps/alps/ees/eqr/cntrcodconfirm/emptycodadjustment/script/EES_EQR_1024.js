/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1024.js
*@FileTitle : MTY COD Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.07.01 문중철
* 1.0 Creation
* History
* ======================================================
* 2011.05.03 나상보 [CHM-201110558-01] [EQR] MTY COD Confirmation의 Created by 컬럼 수정 요청
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
* 2012.10.18 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
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
     * @class EES_EQR_1024 : EES_EQR_1024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1024() { 
        this.processButtonClick     = processButtonClick;
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
                    sheetObjects[0].SelectRow = 0;
                    sheetObjects[1].SelectRow = 0;
                    sheetObjects[2].SelectRow = 0;

                break;

                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    formObject.reset();
                    document.getElementById("vvd").focus();
                    ComBtnDisable("btn_save");
                    ComBtnDisable("btn_remove");
                    ComBtnDisable("btn_rowadd");
                    ComBtnDisable("btn_delete");
                    ComBtnDisable("btn_rowadd2");
                    ComBtnDisable("btn_delete2");
                    setHRText2();
                    break;
                break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                break;

                case "btn_downexcel":
                	/*
                    if ( sheetObjects[0].RowCount > 0 ) {
                        sheetObjects[0].SpeedDown2Excel( -1 , false , false , "" , "" , false,false,"",false ,"" , "" ,false ,"",true);
                    }
                    if ( sheetObjects[1].RowCount > 0 ) {
                        sheetObjects[1].SpeedDown2Excel( -1 , true  , false , "" , "" , false,false,"",false ,"" , "" ,false ,"",true );
                    }
                    if ( sheetObjects[2].RowCount > 0 ) {
                        sheetObjects[2].SpeedDown2Excel( -1 , true  , false , "" , "" , false,false,"",false ,"" , "" ,false ,"",true );
                    }
                    */
                	if(sheetObjects[0].RowCount > 0) sheetObjects[0].Down2Excel(-1,false,false);
                 	
                	if(sheetObjects[1].RowCount > 0) sheetObjects[1].Down2Excel(-1,true,false);
                	if(sheetObjects[2].RowCount > 0) sheetObjects[2].Down2Excel(-1,true,false);
                break;

                case "btn_rowadd":
                    doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;

                case "btn_delete":
                    if ( sheetObject1.FindCheckedRow(PREFIX01+"del_chk") == "" ){
                        ComShowCodeMessage("EQR90214");
                    }else if ( ComShowCodeConfirm("EQR90193") ){ 
                        doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    }
                break;

                case "btn_rowadd2":
                    doActionIBSheet2(sheetObject2, formObject, IBINSERT);
                break;

                case "btn_delete2":
                    if ( sheetObject2.FindCheckedRow(PREFIX02+"del_chk") == "" ){
                        ComShowCodeMessage("EQR90214");
                    }else if ( ComShowCodeConfirm("EQR90193") ){ 
                        doActionIBSheet2(sheetObject2,formObject,IBDELETE);
                    }
                break;

                case "btn_revenue":
                
                break;

                case "btn_remove":
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC04);
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
        ComBtnDisable("btn_save");
        ComBtnDisable("btn_remove");
        ComBtnDisable("btn_rowadd");
        ComBtnDisable("btn_delete");
        ComBtnDisable("btn_rowadd2");
        ComBtnDisable("btn_delete2");
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
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);
                    var HeadTitle = "|||MTY Volume|MTY Volume|MTY Volume|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|P2|P4|T2|T4|";
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
                    InitDataProperty( 0 , cnt++ , dtHidden , 20  , daCenter , false , PREFIX00+"del_chk"                                                            );
                    InitDataProperty( 0 , cnt++ , dtHidden , 0   , daCenter , true  , PREFIX00+"status"                                                             );
                    InitDataProperty( 0 , cnt++ , dtData         , 180 , daCenter , true  , PREFIX00+"pod_cd"  , false , ""      , dfNone        , -1 , false , false , 5 );
                    InitDataProperty( 0 , cnt++ , dtData         , 0   , daCenter , true  , PREFIX01+"yd_cd"   , false , ""      , dfNone        , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtData         , 0   , daCenter , true  , PREFIX01+"etb"     , false , ""      , dfDateYmd     , -1 , false , false     );      
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 50  , daRight  , false , PREFIX00+"total"   , false , sumLine , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"d2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"d4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"d5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"d7"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"r2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"r5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"r9"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"o2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"s2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"o4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"s4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"o5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"f2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"a2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"f4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"a4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"f5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 43  , daRight  , false , PREFIX00+"a5"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"p2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"p4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"t2"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 40  , daRight  , false , PREFIX00+"t4"      , false , ""      , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtHidden    	 , 0   , daRight  , false , PREFIX00+"clptindseq"   , false , ""       , dfNone );
                    CountPosition = 0;

                }
            break;

            case "sheet2":
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
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 4, 100);

                    var HeadTitle = "|||POL|POL|ETD|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|P2|P4|T2|T4|";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var sumLine2 = "|"+PREFIX01+"d2| + |"+PREFIX01+"d4| + |"+PREFIX01+"d5| + |"+PREFIX01+"d7| + |"+PREFIX01+"r2| + |"+PREFIX01+"r5| + |"+PREFIX01+"r9| + " +
                    		       "|"+PREFIX01+"o2| + |"+PREFIX01+"o4| + |"+PREFIX01+"o5| + |"+PREFIX01+"s2| + |"+PREFIX01+"s4| + |"+PREFIX01+"f2| + |"+PREFIX01+"f4| + " +
                    		       "|"+PREFIX01+"f5| + |"+PREFIX01+"a4| + |"+PREFIX01+"a5| + |"+PREFIX01+"a2| + |"+PREFIX01+"p2| + |"+PREFIX01+"p4| + |"+PREFIX01+"t2| + |"+PREFIX01+"t4|";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30 , daCenter , false , PREFIX01+"ibflag"                                                              );
                    InitDataProperty( 0 , cnt++ , dtCheckBox   , 20 , daCenter , false , PREFIX01+"del_chk"                                                             );
                    InitDataProperty( 0 , cnt++ , dtHidden , 0  , daCenterTop , true  , PREFIX01+"status"                                                              );
                    InitDataProperty( 0 , cnt++ , dtData         , 60 , daCenterTop , true  , PREFIX01+"pod_cd"  , false , ""       , dfNone        , -1 , true  , true  , 5 );
                    InitDataProperty( 0 , cnt++ , dtData        , 30 , daCenterTop , true  , PREFIX01+"yd_cd"   , false , ""       , dfNone        , -1 , true , true ,2    );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenterTop , true  , PREFIX01+"etb"     , false , ""       , dfDateYmd     , -1 , true , true     );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 50 , daRight  , false , PREFIX01+"total"   , false , sumLine2 , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"d2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"d4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"d5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"d7"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"r2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"r5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"r9"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"o2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"s2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"o4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"s4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"o5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"f2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"a2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"f4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"a4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"f5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX01+"a5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"p2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"p4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"t2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX01+"t4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 0 , daRight  , false , PREFIX01+"clptindseq"      , false , ""    , dfNone   );
                    CountPosition = 0;
                    
                   // InitComboNoMatchText(true);
                    InitDataValid( 0 , PREFIX01+"pod_cd" , vtEngUpOnly , "" ); //대문자만
                    InitDataValid( 0 , PREFIX01+"yd_cd" , vtEngUpOther , "0,1,2,3,4,5,6,7,8,9" ); //대문자만

                }
            break;

            case "sheet3":
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
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|||POD|POD|ETB|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|P2|P4|T2|T4|";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var sumLine3 = "|"+PREFIX02+"d2| + |"+PREFIX02+"d4| + |"+PREFIX02+"d5| + |"+PREFIX02+"d7| + |"+PREFIX02+"r2| + |"+PREFIX02+"r5| + |"+PREFIX02+"r9| + |"+PREFIX02+"o2| + " +
                    		       "|"+PREFIX02+"o4| + |"+PREFIX02+"o5| + |"+PREFIX02+"s2| + |"+PREFIX02+"s4| + |"+PREFIX02+"f2| + |"+PREFIX02+"f4| + |"+PREFIX02+"f5| + |"+PREFIX02+"a4| + " +
                    		       "|"+PREFIX02+"a2| + |"+PREFIX02+"p2| + |"+PREFIX02+"a5|  + |"+PREFIX02+"p4| + |"+PREFIX02+"t2| + |"+PREFIX02+"t4|";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30 , daCenter , false , PREFIX02+"ibflag"                                                              );
                    InitDataProperty( 0 , cnt++ , dtCheckBox   , 20 , daCenter , false , PREFIX02+"del_chk"                                                             );
                    InitDataProperty( 0 , cnt++ , dtHidden , 0  , daCenterTop , true  , PREFIX02+"status"                                                              );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenterTop , true  , PREFIX02+"pod_cd"  , false , ""       , dfNone        , -1 , true  , true  , 5 );
                    InitDataProperty( 0 , cnt++ , dtData         , 40 , daCenterTop , true  , PREFIX02+"yd_cd"   , false , ""       , dfNone        , -1 , true , true   , 2   );
                    InitDataProperty( 0 , cnt++ , dtData         , 70 , daCenterTop , true  , PREFIX02+"etb"     , false , ""       , dfDateYmd     , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 50 , daRight  , false , PREFIX02+"total"   , false , sumLine3 , dfNullInteger , -1 , false , false     );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"d2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"d4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"d5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"d7"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"r2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"r5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"r9"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"o2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"s2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"o4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"s4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"o5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"f2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"a2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"f4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"a4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"f5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 43 , daRight  , false , PREFIX02+"a5"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"p2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"p4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"t2"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtAutoSumEx    , 40 , daRight  , false , PREFIX02+"t4"      , false , ""       , dfNullInteger , -1 , true  , true      );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 0 , daRight  , false , PREFIX02+"clptindseq"   , false , ""       , dfNone );
                    CountPosition = 0;

                    InitDataValid( 0 , PREFIX02+"pod_cd" , vtEngUpOnly , "" ); //대문자만
                    InitDataValid( 0 , PREFIX02+"yd_cd" , vtEngUpOther , "0,1,2,3,4,5,6,7,8,9"); //대문자만
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
                    document.form.version.value = arrTpSz[2];
                    document.form.remark.value = arrTpSz[4];
                    if(arrTpSz[3] != null && arrTpSz[3] != ""){
	                    document.form.userid.value = arrTpSz[3];
	                    document.form.date.value = arrTpSz[5];
                    }else{
                    	document.form.userid.value = document.form.session_user_id.value;
	                    document.form.date.value = "";
                    }
                    sheetObj.WaitImageVisible = true;
                } else {
                    return;
                }
            break;
            
            case IBSEARCH_ASYNC02:      // PORT 조회
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = SEARCH04;
                    sheetObj.WaitImageVisible = false;
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1024GS.do",FormQueryString(formObj));
                    var sCheck = ComXml2ComboString(sXml, "yd_cd", "etb");

                    if ( sCheck == undefined  || sCheck == "" || sCheck.length < 1){
                        var tR = formObj.editRow.value;
                        ComShowCodeMessage("EQR90205");
                        sheetObjects[1].InitCellProperty(tR,PREFIX01+"yd_cd",dtData);
                        sheetObjects[1].SelectCell(tR, 3, true); 
                        sheetObjects[1].CellValue2(tR,PREFIX01+"yd_cd") = "";
                        sheetObjects[1].CellValue2(tR,PREFIX01+"etb") = "";
                        sheetObjects[1].CellValue2(tR,PREFIX01+"clptindseq") = "";
                        return false;
                    }else{
                        var tR = formObj.editRow.value;
                        if(sCheck[0].length > 2){
                            sheetObjects[1].InitCellProperty(tR,PREFIX01+"yd_cd",dtComboEdit);
                            arrText = sCheck[0].split("|");
                            arrValue = sCheck[1].split("|");
                            var comboText = "";
                            var comboValue = "";

                            for(var i = 0 ; i < arrValue.length-1 ; i++){
                            	arrValue2 = arrValue[i].split("&&");
                            	
                            	comboText += arrText[i]+"\t"+arrValue2[i]+"|";
                            	comboValue += arrText[i]+"\t"+arrValue2[i]+arrValue2[i+1]+"|";
        			   	  	}
                            arrValue2 = arrValue[arrValue.length-1].split("&&");
                            comboText += arrText[arrValue.length-1]+"\t"+arrValue2[0];
                            comboValue += arrText[arrValue.length-1]+"\t"+arrValue2[0]+arrValue2[1];
                            
    			   	  		sheetObjects[1].CellComboItem(tR, PREFIX01+"yd_cd", "| |"+comboText, "| |"+comboValue);
    			   	  		sheetObjects[1].SelectCell(tR, 4, true); 
                        }
                        else{
                        	sheetObjects[1].InitCellProperty(tR,PREFIX01+"yd_cd",dtData);
	                        sheetObjects[1].CellValue2(tR,PREFIX01+"yd_cd") = sCheck[0];
	                        arrValue3 = sCheck[1].split("&&");
	                        sheetObjects[1].CellValue2(tR,PREFIX01+"etb") = arrValue3[0];
	                        sheetObjects[1].CellValue2(tR,PREFIX01+"clptindseq") = arrValue3[1];
                        }
                        
                        
                    }
                    
                    if(sCheck == ","){
                    	var tR = formObj.editRow.value;
                    	 sheetObjects[1].CellValue2(tR,PREFIX01+"clptindseq") = "0";
                    }
                    
                    sheetObj.WaitImageVisible = true;
                } else {
                    return;
                }
            break;

            case IBSEARCH_ASYNC03:      // PORT 조회
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = SEARCH02;
                    sheetObj.WaitImageVisible = false;
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1024GS.do",FormQueryString(formObj));
                    var sCheck = ComXml2ComboString(sXml, "yd_cd", "etb");
                    
                    if ( sCheck == undefined  || sCheck == "" || sCheck.length < 1){
                        var tR = formObj.editRow.value;
                        ComShowCodeMessage("EQR90205");
                        sheetObjects[2].InitCellProperty(tR,PREFIX02+"yd_cd",dtData);
                        sheetObjects[2].SelectCell(tR, 3, true,""); 
                        sheetObjects[2].CellValue2(tR,PREFIX02+"yd_cd") = "";
                        sheetObjects[2].CellValue2(tR,PREFIX02+"etb") = "";
                        sheetObjects[2].CellValue2(tR,PREFIX02+"clptindseq") = "";
                        return false;
                    }else{
                        var tR = formObj.editRow.value;
                        if(sCheck[0].length > 2){
                            sheetObjects[2].InitCellProperty(tR,PREFIX02+"yd_cd",dtComboEdit);
                            arrText = sCheck[0].split("|");
                            arrValue = sCheck[1].split("|");
                            var comboText = "";
                            var comboValue = "";

                            for(var i = 0 ; i < arrValue.length-1 ; i++){
                            	arrValue2 = arrValue[i].split("&&");
                            	
                            	comboText += arrText[i]+"\t"+arrValue2[i]+"|";
                            	comboValue += arrText[i]+"\t"+arrValue2[i]+arrValue2[i+1]+"|";
        			   	  	}
                            arrValue2 = arrValue[arrValue.length-1].split("&&");
                            comboText += arrText[arrValue.length-1]+"\t"+arrValue2[0];
                            comboValue += arrText[arrValue.length-1]+"\t"+arrValue2[0]+arrValue2[1];
                            
    			   	  		sheetObjects[2].CellComboItem(tR, PREFIX02+"yd_cd", "| |"+comboText, "| |"+comboValue);
    			   	  		sheetObjects[2].SelectCell(tR, 4, true); 
                        }
                        else{
                        	sheetObjects[2].InitCellProperty(tR,PREFIX01+"yd_cd",dtData);
	                        sheetObjects[2].CellValue2(tR,PREFIX02+"yd_cd") = sCheck[0];
	                        arrValue3 = sCheck[1].split("&&");
	                        sheetObjects[2].CellValue2(tR,PREFIX02+"etb") = arrValue3[0];
	                        sheetObjects[2].CellValue2(tR,PREFIX02+"clptindseq") = arrValue3[1];
                        }
                        
                        
                    }
                    
                    if(sCheck == ","){
                    	var tR = formObj.editRow.value;
                    	 sheetObjects[2].CellValue2(tR,PREFIX02+"clptindseq") = "0";
                    }
                    sheetObj.WaitImageVisible = true;
                } else {
                    return;
                }
            break;            

            case IBSEARCH_ASYNC05:      // yd_cd validate check
                if (validateForm(sheetObj, formObj, sAction)) {
                	var tR = formObj.editRow.value;
                    formObj.f_cmd.value = SEARCH03;
                    formObj.yardcode.value = sheetObj.CellValue(tR,3)+sheetObj.CellValue(tR,4).substring(0,2);
                    if(sheetObj.CellValue(tR,4).substring(3,11) != ""){
                    	sheetObj.CellValue2(tR,PREFIX01+"etb") = sheetObj.CellValue(tR,4).substring(3,11);
                    }
                    if(sheetObj.CellValue(tR,4).substring(11,12) != ""){
                    	sheetObj.CellValue2(tR,PREFIX01+"clptindseq") = sheetObj.CellValue(tR,4).substring(11,12);
                    }
                    
                    if(sheetObj.CellValue(tR,4).substring(0,2) != ""){
	                    sheetObj.WaitImageVisible = false;
	                    var sXml = sheetObj.GetSearchXml("EES_EQR_1024GS.do",FormQueryString(formObj));
	                    var sCheck = ComGetEtcData(sXml, "check");
	    				if (sCheck != "OK") {
	    					
							ComShowCodeMessage("EQR90218");
							sheetObj.SelectCell(tR, 4, true,""); 
							return false;
	    				}
                    }
                    sheetObj.WaitImageVisible = true;
                } else {
                    return;
                }

            break;
            
            case IBSEARCH02:      //조회
                
            break;            
            
            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)) {
                    for( var i = 7 ; i < 26 ; i++ ){
                        if ( sheetObjects[0].SumValue(0,i) != sheetObjects[2].SumValue(0,i) ) {
                        	ComShowCodeMessage("EQR90220",sheetObjects[0].ColSaveName(i).toUpperCase());
                            sheetObjects[1].SelectCell(1,i);
                            i = 9999;
                            return false;
                        }
                    }
                    var rCnt01 = sheetObjects[1].RowCount+1;
                    var rCnt02 = sheetObjects[2].RowCount+1;
                    for ( var i = 1 ; i < rCnt01 ; i++ ) {
                        if ( sheetObjects[1].CellValue(i,3) ==  "" &&  sheetObjects[1].CellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Port Code ");
                            sheetObjects[1].SelectCell(i, 3, true); 
                            return false;
                        }
                        if ( sheetObjects[1].CellValue(i,4) ==  "" &&  sheetObjects[1].CellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Yard Code ");
                            sheetObjects[1].SelectCell(i, 3, true); 
                            return false;
                        }
                        if ( sheetObjects[1].CellValue(i,5) == "" &&  sheetObjects[1].CellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","ETD Code ");
                            sheetObjects[1].SelectCell(i, 3, true); 
                            return false;
                        }
                    }
                    for ( var i = 1 ; i < rCnt02 ; i++ ) {
                        if ( sheetObjects[2].CellValue(i,3) ==  "" &&  sheetObjects[2].CellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Port Code ");
                            sheetObjects[2].SelectCell(i, 3, true); 
                            return false;
                        }
                        if ( sheetObjects[2].CellValue(i,4) ==  "" &&  sheetObjects[2].CellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","Yard Code ");
                            sheetObjects[2].SelectCell(i, 3, true); 
                            return false;
                        }
                        if ( (sheetObjects[2].CellValue(i,5) == "" || sheetObjects[2].CellValue(i,5) == "SKIP") &&  sheetObjects[2].CellValue(i,0) !=  "D" ) {
                            ComShowCodeMessage("EQR90213","ETB ");
                            sheetObjects[2].SelectCell(i, 3, true); 
                            return false;
                        }
                    }
                    sheetObjects[2].ColumnSort(PREFIX02+"etb","ASC");
                    document.form.n1stEtb.value = sheetObjects[2].CellValue( 1 , PREFIX02+"etb" );
                    //alert("ETB [" + document.form.n1stEtb.value + "]");

                    if ( sheetObj.id == "sheet1") {
                
                        formObj.f_cmd.value = MULTI;                
                        var sParam1 = sheetObjects[0].GetSaveString(true);
                        var sParam2 = sheetObjects[1].GetSaveString(true);
                        var sParam3 = sheetObjects[2].GetSaveString(true);
//                      if (sParam1 == "") { // 변경된 값이 없으면...
//                			ComShowCodeMessage("EQR90225");
//                			return;
//                		}
                        
                        formObj.sh2RC.value = sheetObjects[1].LastRow - 1;
//                    alert(document.form.sh2RC.value);                        
//                        alert("sheetObjects[0].LastRow [" + sheetObjects[0].LastRow + "] sheetObjects[1].LastRow [" + sheetObjects[1].LastRow + "] sheetObjects[2].LastRow [" + sheetObjects[2].LastRow + "]");
                        //alert(sParam1);
                        sParam = sParam1 +  "&" + sParam2 +  "&" + sParam3 +  "&" + FormQueryString(formObj);
                        var sXml   = sheetObj.GetSaveXml("EES_EQR_1024GS.do", sParam);
                        sheetObjects[0].LoadSaveXml(sXml);
                    }
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
                }
            break;

            case IBSEARCH_ASYNC04:        //저장
            	if (!ComShowCodeConfirm("EQR90219",document.form.vvd.value)) return;
                    formObj.f_cmd.value = MULTI01;                
                    var sParam1 = sheetObjects[0].GetSaveString(true);
                    var sParam2 = sheetObjects[1].GetSaveString(true);
                    var sParam3 = sheetObjects[2].GetSaveString(true);
                    sParam = sParam1 +  "&" + sParam2 +  "&" + sParam3 +  "&" + FormQueryString(formObj);
                    var sXml   = sheetObj.GetSaveXml("EES_EQR_1024GS.do", sParam);
                    sheetObjects[0].LoadSaveXml(sXml);
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
                        
            break;            
            
            case IBINSERT:      // 입력
                sheetObj.DataInsert();
                var rCnt01 = sheetObjects[1].RowCount;
                for ( var i = 0 ; i < rCnt01 ; i++ ) {
                 //   sheetObjects[1].CellEditable(i,4) = false;
                 //   sheetObjects[1].CellEditable(i,5) = false;
                    sheetObjects[1].CellEditable(i,6) = false;
                }
                removeZero2(sheetObjects[1]);
                sheetObj.SumText(0, PREFIX01+"pod_cd") = "Additonal Load Total";
   //             sheetObj.SumText(0, PREFIX01+"yd_cd") = "Additonal Load Total";
   //             sheetObj.SumText(0, PREFIX01+"etb") = "Additonal Load Total";
                sheetObj.SetMergeCell(sheetObj.LastRow, 3 , 1 , 3); 
                sheetObj.CellAlign(sheetObj.LastRow	 ,PREFIX01 + "pod_cd") = daCenter;
            break;

            case IBDELETE:      // 삭제
                if (sheetObj.id == 'sheet2') {  

                    sheetObj.SelectFontBold = false;
                    if(sheetObj.FindCheckedRow(PREFIX01+"del_chk") != ""){
                        ComRowHideDelete(sheetObj,PREFIX01+"del_chk"); 
                        sheetObj.SelectFontBold = true;
                        rcnt = sheetObj.RowCount;
                        if( rcnt == 0 ){
                            for( var i = 5 ; i < 25 ; i++ ){
                                sheetObjects[0].CellValue(2,i) = "";
                            }
                        }else{
                            sheet2_OnSearchEnd (sheetObjects[1], "");
                        }
                    } else {     
                    }
                }               
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet2( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBINSERT:      // 입력
                sheetObj.DataInsert();
                var rCnt01 = sheetObjects[2].RowCount;
                for ( var i = 0 ; i < rCnt01 ; i++ ) {
            //        sheetObjects[2].CellEditable(i,4) = false;
                    sheetObjects[2].CellEditable(i,5) = false;
                    sheetObjects[2].CellEditable(i,6) = false;
                }
                removeZero2(sheetObjects[2]);
                sheetObj.SumText(0, PREFIX02+"pod_cd") = "Discharge Total";
                sheetObj.SetMergeCell(sheetObj.LastRow, 3 , 1 , 3); 
                sheetObj.CellAlign(sheetObj.LastRow	 ,PREFIX02+"pod_cd") = daCenter;
            break;

            case IBDELETE:      // 삭제
            if (sheetObj.id == 'sheet3') {  
                sheetObj.SelectFontBold = false;
                if(sheetObj.FindCheckedRow(PREFIX02+"del_chk") != ""){
                    ComRowHideDelete(sheetObj,PREFIX02+"del_chk"); 
                    rcnt = sheetObj.RowCount;
                    if( rcnt == 0 ){
                    }else{
                    	sheet3_OnDeleteEnd (sheetObjects[2], "");
                    }
                } else {     
                }
            }               
            break;
        }
    }

  
  
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction == IBSEARCH || sAction == IBSEARCH_ASYNC01){
                if(vvd.value == "" && sAction == IBSEARCH){
                    ComShowCodeMessage("EQR90198");
                    ComSetFocus(vvd);
                    return false;
                } 
                else if(vvd.value == ""){
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
                if (0 == SumText(0, i) ) {
                    SumText(0, i) = "0";
                }
                if ("" == SumText(0, i) ) {
                    SumText(0, i) = "0";
                }
            }
        }
    }

    // Total 행의 0을 제거한다.
    function removeZero2(sheetObj) {
        with(sheetObj) {
            var sCol = 6;
            var eCol = LastCol;
            var rCnt = sheetObj.RowCount + 1;
            for ( var o = 1 ; o < rCnt ; o++ ) {
                for ( i = sCol ; i <= eCol ; i++ ) {
                    if ( "" == CellValue( o , i) ) {
                        CellValue2(o, i) = "0";
                    }
                }
            }
        }
    }    
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
            ColBackColor(PREFIX00+"pod_cd") = RgbColor(229, 234, 255);
             

      //      SelectBackColor  = RgbColor(255,255,255);

            removeZero(sheetObj);
            MessageText("Sum") = "Onboard Total";
        }
    }

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
     //   	SelectBackColor  = RgbColor(255,255,255);
        	MessageText("Sum") = "";
            SumText ( 0 , PREFIX01 + "pod_cd") = "Additonal Load Total";
      //      SumText ( 0 , PREFIX01 + "yd_cd" ) = "Additonal Load Total";
      //      SumText ( 0 , PREFIX01 + "etb"   ) = "Additonal Load Total";
            SetMergeCell(LastRow, 3 , 1 , 3); 
            CellAlign(LastRow	 ,PREFIX01 + "pod_cd") = daCenter;
            removeZero(sheetObj);
            var rCnt01 = sheetObjects[1].RowCount;
            for ( var i = 0 ; i < rCnt01 ; i++ ) {
         //       sheetObjects[1].CellEditable(i,4) = false;
        //        sheetObjects[1].CellEditable(i,5) = false;
                sheetObjects[1].CellEditable(i,6) = false;
            }
            for ( var i = 7 ; i < 27 ; i++ ) {
                sheetObjects[0].CellValue2(2,i) = SumValue(0, i);
            }
        }
    }

    function sheet2_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift) {
		if(ComGetLenByByte(sheetObjects[1].EditValue) == 5 && Col == 3){
			
			sheetObjects[1].SelectCell(Row,Col+1,false);
		}
    }
    
    function sheet3_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift) {
		if(ComGetLenByByte(sheetObjects[2].EditValue) == 5 && Col == 3){
			
			sheetObjects[2].SelectCell(Row,Col+1,false);
		}
    }
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        with(sheetObj) {
        	MessageText("Sum") = "";
            SumText(0, PREFIX01+"pod_cd") = "Additonal Load Total";
      //      SumText(0, PREFIX01+"yd_cd") = "Additonal Load Total";
      //      SumText(0, PREFIX01+"etb") = "Additonal Load Total";
            
            SetMergeCell(LastRow, 3 , 1 , 3); 
            CellAlign(LastRow	 ,PREFIX02 + "pod_cd") = daCenter;
            removeZero(sheetObj);
            var formObj = document.form;
            if ( Col == 3 ) {

                var rCnt01 = sheetObjects[1].RowCount + 1;
                var rCnt02 = sheetObjects[2].RowCount + 1;
                for ( var i = 1 ; i < rCnt01 ; i++ ) {
                    if ( sheetObjects[1].CellValue(i,Col) ==  Value && Row != i && sheetObjects[1].CellValue(i,0) != "D" ) {
                    	ComShowCodeMessage("EQR90194");
                        sheetObj.SelectCell(Row, Col, true, ""); 
                        return false;
                    }
                }
                
                formObj.editRow.value = Row;
                formObj.editPort.value = Value;
                formObj.editIbFlag.value = sheetObj.CellValue(Row,0);
                if(ComGetLenByByte(sheetObjects[1].CellValue(Row,Col)) == 5){
                	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC02 );
                }
                else{
                    ComShowCodeMessage("EQR90205");
                    sheetObj.SelectCell(Row, 3, true); 
                    sheetObj.CellValue2(Row,PREFIX01+"yd_cd") = "";
                    sheetObj.CellValue2(Row,PREFIX01+"etb") = "";
                }
            } else {
            	
                if ( Col > 6 ) {
                    sheetObjects[0].CellValue2(2,Col) = SumValue(0, Col);
                }
                else if ( Col == 4 ) { // yd_cd 컬럼
                	
                	if(CellValue(Row,Col) != ''){
	                	formObj.editRow.value = Row;
	                	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC05);
                	}
                }
            }
        }
    }
        
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet3_OnDeleteEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
        	MessageText("Sum") = "";
            SumText(0, PREFIX02+"pod_cd") = "Discharge Total";
            SetMergeCell(LastRow, 3 , 1 , 3); 
            CellAlign(LastRow	 ,PREFIX02+"pod_cd") = daCenter;
            removeZero(sheetObj);
            var rCnt01 = sheetObjects[2].RowCount;
            for ( var i = 0 ; i < rCnt01 ; i++ ) {
               // sheetObjects[2].CellEditable(i,4) = false;
                sheetObjects[2].CellEditable(i,5) = false;
                sheetObjects[2].CellEditable(i,6) = false;
            }
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_remove");
            ComBtnEnable("btn_rowadd");
            ComBtnEnable("btn_delete");
            ComBtnEnable("btn_rowadd2");
            ComBtnEnable("btn_delete2");
        }
    }

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
        	MessageText("Sum") = "";
            SumText(0, PREFIX02+"pod_cd") = "Discharge Total";
            SetMergeCell(LastRow, 3 , 1 , 3); 
            CellAlign(LastRow	 ,PREFIX02+"pod_cd") = daCenter;
            removeZero(sheetObj);
            var tVer = document.form.version.value;
            if ( tVer == "I" || tVer == "B") {
                for( var i = 7 ; i < 27 ; i++ ) {
                    sheetObjects[0].CellValue2(1,i) = sheetObj.SumValue(0,i);
                }
            }
            var rCnt01 = sheetObjects[2].RowCount;
            for ( var i = 0 ; i < rCnt01 ; i++ ) {
               // sheetObjects[2].CellEditable(i,4) = false;
                sheetObjects[2].CellEditable(i,5) = false;
                sheetObjects[2].CellEditable(i,6) = false;
            }
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_remove");
            ComBtnEnable("btn_rowadd");
            ComBtnEnable("btn_delete");
            ComBtnEnable("btn_rowadd2");
            ComBtnEnable("btn_delete2");
        }
    }
    
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
        with(sheetObj) {
            removeZero(sheetObj);
            MessageText("Sum") = "";
            var formObj = document.form;
            if( Col == 3 ) {

                var rCnt01 = sheetObjects[1].RowCount + 1;
                var rCnt02 = sheetObjects[2].RowCount + 1;
//                for ( var i = 1 ; i < rCnt01 ; i++ ) {
//                    if ( sheetObjects[1].CellValue(i,Col) ==  Value && sheetObjects[1].CellValue(i,0) != "D" ) {
//                        alert("동일한 Port_Cd가 존재합니다.");
//                        sheetObj.SelectCell(Row, Col, true, ""); 
//                        return false;
//                    }
//                }
                for ( var i = 1 ; i < rCnt02 ; i++ ) {
                    if ( sheetObjects[2].CellValue(i,Col) ==  Value && Row != i && sheetObjects[2].CellValue(i,0) != "D" ) {
                    	ComShowCodeMessage("EQR90194");
                        sheetObj.SelectCell(Row, Col, true, ""); 
                        return false;
                    }
                } 
                
                formObj.editRow.value = Row;
                formObj.editPort.value = Value;
                formObj.editIbFlag.value = sheetObj.CellValue(Row,0);
                
                if(ComGetLenByByte(sheetObj.CellValue(Row,Col)) == 5){
                	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC03 );
                }
                else{
                    ComShowCodeMessage("EQR90205");
                    sheetObj.SelectCell(Row, 3, true); 
                    sheetObj.CellValue2(Row,PREFIX02+"yd_cd") = "";
                    sheetObj.CellValue2(Row,PREFIX02+"etb") = "";
                }
                
                
            }
            else if ( Col == 4 ) { // yd_cd 컬럼
            	formObj.editRow.value = Row;
            	doActionIBSheet( sheetObj , formObj , IBSEARCH_ASYNC05);
            }

        }
    }
       
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate() {
        switch (event.srcElement.name) {
            case "vvd":
                if(event.srcElement.value != ""){
              //      doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                }
            break;
        }           
        return true;
    }
    
function obj_keypress(){
    //alert("event.srcElement.name ["+event.srcElement.name+"]");
    switch(event.srcElement.name){
        case "vvd":
            ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
        break;
    }   
}    
        