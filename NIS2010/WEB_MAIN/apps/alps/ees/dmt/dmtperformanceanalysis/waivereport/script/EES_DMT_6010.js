/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6010.js
*@FileTitle : Waive Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.21 mun jung cheol
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
     * @author 한진해운
     */

    /**
     * @extends 
     * @class EES_DMT_6010 : EES_DMT_6010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6010() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }

    // 공통전역변수
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
                    window.close();
                break;
                
                case "btn_down":
                    sheetObjects[0].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
                break;
                
                case "btn_bkg":
                    
                    document.form.bkg_no             .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "bkgno"  );
                    document.form.cntr_no            .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "cntrno" );
                    document.form.bl_no              .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "blno"   );
                    document.form.dmdt_trf_cd        .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "tariff" );
                    document.form.svr_id             .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "grpid"  );
                    document.form.cntr_cyc_no        .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "cycno"  );
                    document.form.dmdt_chg_loc_div_cd.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "divcd"  );
                    document.form.chg_seq            .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "chgseq" );
                    
                    if(ComGetObjValue(document.form.role_permit) == 'Y') {
                        // Calculation 화면
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_3002P.do?call_flag=P&bkg_no='     +document.form.bkg_no     .value+
                                                                              '&bl_no='      +document.form.bl_no      .value+
                                                                              '&dmdt_trf_cd='+document.form.dmdt_trf_cd.value, 1010, 680, "", "0,1,1,1,1,1,1", true);
                    } else {
                        // Inquiry 화면
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_3005P.do?call_flag=P&bkg_no='     +document.form.bkg_no     .value+
                                                                              '&bl_no='      +document.form.bl_no      .value+
                                                                              '&dmdt_trf_cd='+document.form.dmdt_trf_cd.value, 1010, 680, "", "0,1,1,1,1,1,1", true);
                    }
                    

                break;                

                case "btn_cntr":
                    var chkRow      = sheetObjects[0].SelectRow;
                    document.form.bkg_no             .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "bkgno"  );
                    document.form.cntr_no            .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "cntrno" );
                    document.form.bl_no              .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "blno"   );
                    document.form.dmdt_trf_cd        .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "tariff" );
                    document.form.svr_id             .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "grpid"  );
                    document.form.cntr_cyc_no        .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "cycno"  );
                    document.form.dmdt_chg_loc_div_cd.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "divcd"  );
                    document.form.chg_seq            .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "chgseq" );
                    if( ComGetObjValue(document.form.role_permit) == 'Y' && sheetObjects[0].CellValue(chkRow , "ofcrhqcd") == ComGetObjValue(document.form.h_rhq_off) ) {
                        // Calculation 화면
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_3003P.do?call_flag=P&cntr_no='            +document.form.cntr_no            .value+
                                                                              '&svr_id='             +document.form.svr_id             .value+
                                                                              '&cntr_cyc_no='        +document.form.cntr_cyc_no        .value+
                                                                              '&dmdt_chg_loc_div_cd='+document.form.dmdt_chg_loc_div_cd.value+
                                                                              '&chg_seq='            +document.form.chg_seq            .value+
                                                                              '&dmdt_trf_cd='        +document.form.dmdt_trf_cd        .value, 1020, 680, "", "0,1,1,1,1,1,1", true);
                    } else {
                        // Inquiry 화면
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_3006P.do?call_flag=P&cntr_no='            +document.form.cntr_no            .value+
                                                                              '&svr_id='             +document.form.svr_id             .value+
                                                                              '&cntr_cyc_no='        +document.form.cntr_cyc_no        .value+
                                                                              '&dmdt_chg_loc_div_cd='+document.form.dmdt_chg_loc_div_cd.value+
                                                                              '&chg_seq='            +document.form.chg_seq            .value+
                                                                              '&dmdt_trf_cd='        +document.form.dmdt_trf_cd        .value, 1020, 680, "", "0,1,1,1,1,1,1", true);
                    }                    

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

    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        ComOpenPopupWithTarget('/hanjin/EES_DMT_3006.do?call_flag=P&cntr_no='+sheetObj.CellValue(Row,"cntrno"), 1020, 650, "", "0,1,1,1,1,1,1", true);
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
        ComConfigSheet (sheetObjects[0] );
        initSheet(sheetObjects[0],1);
        ComEndConfigSheet(sheetObjects[0]);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    style.height = 300;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 7, 100);
                    
                    var HeadTitle1 = "Seq.|S/C No.|RFA No.|Customer|Customer|CTRT OFC|Tariff|STS|CNTR No.|T/S|DMT OFC|From YD|To YD|Fm|To|F/T|Over| ";
                            HeadTitle1 += "From Date|To Date|F/Time CMNC|F/Time End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Invoiced AMT|A/R|BKG No.|B/L No.|VVD CD|";
                            HeadTitle1 += "Lane|POR|POL|POD|DEL|R|D|INV No.|ISS DT|G/B|DAR APVL No.|Request|Request|Request|Approval|Approval|Approval|||||";
                            
                    var HeadTitle2 = "Seq.|S/C No.|RFA No.|Code|Name|CTRT OFC|Tariff|STS|CNTR No.|T/S|DMT OFC|From YD|To YD|Fm|To|F/T|Over| ";
                            HeadTitle2 += "From Date|To Date|F/Time CMNC|F/Time End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Invoiced AMT|A/R|BKG No.|B/L No.|VVD CD|";
                            HeadTitle2 += "Lane|POR|POL|POD|DEL|R|D|INV No.|ISS DT|G/B|DAR APVL No.|Date|Office|Name|Date|Office|Name|||||";
                            

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtSeq  ,  35 , daCenter , true , "seq"        , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  70 , daCenter , true , "scno"       , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "rfano"      , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  60 , daLeft   , true , "custcode"   , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData , 180 , daLeft   , true , "custname"   , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  75 , daCenter , true , "ctrtofc"    , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  50 , daCenter , true , "tariff"     , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "sts"        , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "cntrno"     , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "ts"         , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  65 , daCenter , true , "dmtofc"     , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  70 , daCenter , true , "fromyard"   , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  70 , daCenter , true , "toyard"     , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "fm"         , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "too"        , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "ft"         , false , "" , dfNullInteger , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  35 , daCenter , true , "over"       , false , "" , dfNullInteger , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  75 , daCenter , true , "fromdate"   , false , "" , dfDateYmd     , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  75 , daCenter , true , "todate"     , false , "" , dfDateYmd     , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "ftcmnc"     , false , "" , dfDateYmd     , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "ftend"      , false , "" , dfDateYmd     , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  40 , daCenter , true , "cur"        , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  95 , daRight  , true , "incurred"   , false , "" , dfNullFloat   , 2 );
                    InitDataProperty( 0 , cnt++ , dtData ,  95 , daRight  , true , "exceptionn" , false , "" , dfNullFloat   , 2 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daRight  , true , "dcamt"      , false , "" , dfNullFloat   , 2 );
                    InitDataProperty( 0 , cnt++ , dtData ,  95 , daRight  , true , "billable"   , false , "" , dfNullFloat   , 2 );
                    InitDataProperty( 0 , cnt++ , dtData ,  55 , daCenter , true , "cur2"       , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  95 , daRight  , true , "invoiced"   , false , "" , dfNullFloat   , 2 );
                    InitDataProperty( 0 , cnt++ , dtData ,  40 , daCenter , true , "ar"         , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  95 , daCenter , true , "bkgno"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  95 , daCenter , true , "blno"       , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "vvd"        , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  45 , daCenter , true , "lane"       , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  65 , daCenter , true , "por"        , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  65 , daCenter , true , "pol"        , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  65 , daCenter , true , "pod"        , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  65 , daCenter , true , "del"        , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "r"          , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  30 , daCenter , true , "d"          , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "invno"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daCenter , true , "issdt"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  35 , daCenter , true , "gb"         , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData , 115 , daCenter , true , "darapprno"  , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  70 , daCenter , true , "date1"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  60 , daCenter , true , "office1"    , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daLeft   , true , "name1"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  70 , daCenter , true , "date2"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  60 , daCenter , true , "office2"    , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtData ,  80 , daLeft   , true , "name2"      , false , "" , dfNone        , 0 );
                    InitDataProperty( 0 , cnt++ , dtHidden ,  80 , daCenter , true , "grpid"      , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtHidden ,  80 , daCenter , true , "cycno"      , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtHidden ,  80 , daCenter , true , "chgseq"      , false , "" , dfNone     , 0 );
                    InitDataProperty( 0 , cnt++ , dtHidden ,  80 , daCenter , true , "divcd"      , false , "" , dfNone      , 0 );
                    InitDataProperty( 0 , cnt++ , dtHidden ,  80 , daCenter , true , "ofcrhqcd"      , false , "" , dfNone      , 0 );
                    
                    sheetObj.FrozenCols = 3;
               }
            break;
        }
    }  

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCH;
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                sheetObj.DoSearch("EES_DMT_6010GS.do", FormQueryString(formObj));
                
ComOpenWait(false);
                
                // 페이지 접근 권한정보
                var rolePermit  = sheetObj.EtcData("ROLE_PERMIT");
                var roleAuth    = sheetObj.EtcData("ROLE_AUTH");
                ComSetObjValue(formObj.role_permit, rolePermit);
                ComSetObjValue(formObj.role_auth,   roleAuth);

            break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
        return true;
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        with(sheetObj){
            if ( RowCount > 0 ) {
                document.form.cntrqtybox         .value = ComAddComma(RowCount);
                document.form.bkg_no             .value = CellValue(2,"bkgno" );
                document.form.cntr_no            .value = CellValue(2,"cntrno");
                document.form.bl_no              .value = CellValue(2,"blno"  );
                document.form.dmdt_trf_cd        .value = CellValue(2,"tariff");
                document.form.svr_id             .value = CellValue(2,"grpid" );
                document.form.cntr_cyc_no        .value = CellValue(2,"cycno" );
                document.form.dmdt_chg_loc_div_cd.value = CellValue(2,"divcd" );
                document.form.chg_seq            .value = CellValue(2,"chgseq");
                
                if ( CellValue(2,"scno") == "" ) {
                    ColHidden("scno") = true;
                } else if ( CellValue(2,"rfano") == "" ) {
                    ColHidden("rfano") = true;
                }
                
            } else {
                document.form.cntrqtybox.value = 0;
            }
        }
    }

    
    function sheet1_OnClick(sheetObj, Row, Col, Value){
        with(sheetObj){
            if ( RowCount > 0 ) {
                document.form.bkg_no             .value = CellValue(Row,"bkgno" );
                document.form.cntr_no            .value = CellValue(Row,"cntrno");
                document.form.bl_no              .value = CellValue(Row,"blno"  );
                document.form.dmdt_trf_cd        .value = CellValue(Row,"tariff");
                document.form.svr_id             .value = CellValue(Row,"grpid" );
                document.form.cntr_cyc_no        .value = CellValue(Row,"cycno" );
                document.form.dmdt_chg_loc_div_cd.value = CellValue(Row,"divcd" );
                document.form.chg_seq            .value = CellValue(Row,"chgseq");                
            }
        }
    }    
