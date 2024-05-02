/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1056.js
*@FileTitle : Match-back by Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.07.01 문중철
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
     * @class EES_EQR_1056 : EES_EQR_1056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1056() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

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

                case "btn_retrieve":
                    doActionIBSheet( sheetObject , formObject , IBSEARCH );
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

    function initControl(){
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- form OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
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
      //  var formObject = document.form;
       // alert();
    }

	function sheet1_OnLoadFinish(sheetObj) {
        sheetObj.WaitImageVisible = false;
        doActionIBSheet(sheetObj, document.form,IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObj, document.form , IBSEARCH );
        sheetObj.SelectRow = 0; 
        sheetObjects[1].SelectRow = 0; 
        sheetObjects[2].SelectRow = 0; 
		sheetObj.WaitImageVisible = true; 

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
                    style.height = 202;
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

                    var HeadTitle = "CNTR No.|TP/SZ|POL|POD|Bay|BKG No.";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtData , 100 , daCenter , true , "cntr_no"      , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 60  , daCenter , true , "cntr_tpsz_cd" , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "pol_cd"       , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "pod_cd"       , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "bay_no"       , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 100 , daCenter , true , "bkg_no"       , false , "" , dfNone , -1 , false , false );

                    CountPosition = 0;
                }
            break;

            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 202;
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

                    var HeadTitle = "CNTR No.|TP/SZ|POL|POD|Bay|BKG No.";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtData , 100 , daCenter , true , "cntr_no"      , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 40  , daCenter , true , "cntr_tpsz_cd" , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "pol_cd"       , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "pod_cd"       , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "bay_no"       , false , "" , dfNone , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 100 , daCenter , true , "bkg_no"       , false , "" , dfNone , -1 , false , false );

                    CountPosition = 0;
                }
            break;

            case "sheet3":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 42;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var sumLine = "|d2| + |d4| + |d5| + |d7| + |r2| + |r5| + |r9| + |o2| + |s2| + |o4| + |s4| + |o5| + |f2| + |a2| + |f4| + |a4| + |f5| + |a5|" ;

                    InitDataProperty( 0 , cnt++ , dtData , 100 , daRight , false , "total" , false , sumLine , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "d2"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "d4"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "d5"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "d7"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "r2"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "r5"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "r9"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "o2"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "s2"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "o4"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "s4"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "o5"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "f2"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "a2"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "f4"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "a4"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "f5"    , false , ""      , dfNullInteger , -1 ,false , false );
                    InitDataProperty( 0 , cnt++ , dtData , 45  , daRight , false , "a5"    , false , ""      , dfNullInteger , -1 ,false , false );

                    CountPosition = 0;
                }
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
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
                            
                        var sXml = sheetObj.GetSearchXml("EES_EQR_1056GS.do", FormQueryString(formObj));
                        var arrXml = sXml.split("|$$|");
                        for( var i = 0 ; i < arrXml.length ; i++ ){  
                            sheetObjects[i].LoadSearchXml(arrXml[i]);
                        }
                        
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
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1056GS.do",FormQueryString(formObj));
                    var sCheck = ComGetEtcData(sXml, "pod_list");
                    
                    if ( sCheck == "" || sCheck.length < 1 ){
                        ComShowCodeMessage("EQR90185");
                        document.form.vvd.value = "";
                        document.form.vvd.focus();
                        return false;
                    }else{
                        ComClearCombo( formObj.pod );
                        ComAddComboItem( formObj.pod , "" , "" );
                        var arrTpSz = sCheck.split("|");
                        for ( var i = 0 ; i < arrTpSz.length ; i++ ){
                            ComAddComboItem( formObj.pod , arrTpSz[i] , arrTpSz[i] );
                        }
                    } 
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
                if(document.form.vvd.value == ""){
                    ComShowCodeMessage("EQR90213","VVD Code ");
                    ComSetFocus(vvd);
                    return false;
                }
//                
//                if(pod.value == ""){
//                    ComShowCodeMessage("EQR21001","POD 코드는 ");
//                    ComSetFocus(pod);
//                    return false;
//                }
//
            }
        }
        return true;
    }
    
    // Total 행의 0을 제거한다.
    function removeZero(sheetObj)
    {
        with(sheetObj)
        {
            var sCol = 1;
            var eCol = LastCol;
            
            for (i = sCol; i <= eCol; i ++)
            {
                if (0 == SumText(0, i))
                    SumText(0, i) = "";
            }
        }
    }


    
    function obj_keypress(){
        switch(event.srcElement.name){
            case "vvd":
                ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
            break;
        }   
    }
    
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