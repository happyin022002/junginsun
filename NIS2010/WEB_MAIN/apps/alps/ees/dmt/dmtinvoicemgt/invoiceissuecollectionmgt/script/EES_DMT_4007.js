/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4007.js
*@FileTitle : Manual Invoice Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : Mun Jung Cheol
*@LastVersion : 1.0
* 2009.10.06 Mun Jung Cheol
* 1.0 Creation
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
    * @extends 
    * @class ui_dmt_4007 ui_dmt_4007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function ui_dmt_4007() {
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
                
                case "btn_downexcel":
                    sheetObjects[0].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
                break;
                
                case "btn_detail":
                    var url = "EES_DMT_4004P.do"
                        +"?dmdt_inv_no="+sheetObjects[0].CellValue ( sheetObjects[0].SelectRow , "invno" )
                        +"&caller=4007"
                        ;
                    var returnValue = ComOpenWindowCenter(url, "EES_DMT_4004", "1020","730", true);                    
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

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = 900; //mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(36, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    sheetObj.FrozenCols = 5;

                    var HeadTitle  = " ||Seq.|ISS OFC|Reason for Manual Invoice|Tariff|INV No.|A/R|STS|CNTR|INV Cur.|Total AMT|D/C AMT|Billing AMT|Tax AMT";
                    HeadTitle  += "|Payable AMT|BKG No.|B/L No.|VVD CD|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|ISS DT|ISS Name|I/F DT|I/F OFC|I/F Name|Payer|Payer|Credit/Ref.|Remark(s)";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //var sumLine = "|dcamt| + |bllamt| + |taxamt| + |payamt|";
                    var sumLine = "|totamt| - |bllamt|";

                    //데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty ( 0 , cnt++ , dtHiddenStatus ,   0 , daCenter , false , "Status"                                                 );
                    InitDataProperty ( 0 , cnt++ , dtHidden       ,  30 , daCenter , false , "Check"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtSeq          ,  30 , daCenter , false , "SEQ"                                                    );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  65 , daCenter , false , "issofc" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 175 , daLeft   , false , "reason" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  50 , daCenter , false , "tariff" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  70 , daCenter , false , "invno"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  40 , daCenter , false , "arif"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  30 , daCenter , false , "stscd"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  50 , daCenter , false , "cntr"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  60 , daCenter , false , "invcur" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 100 , daRight  , false , "totamt" , false , ""		, dfFloat , 2 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 100 , daRight  , false , "dcamt"  , false , sumLine	, dfFloat , 2 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 100 , daRight  , false , "bllamt" , false , ""		, dfFloat , 2 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 100 , daRight  , false , "taxamt" , false , ""      , dfFloat , 2 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 100 , daRight  , false , "payamt" , false , ""      , dfFloat , 2 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  90 , daCenter , false , "bkgno"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  90 , daCenter , false , "blno"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  80 , daCenter , false , "vvdcd"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  60 , daCenter , false , "porcd"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  60 , daCenter , false , "polcd"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  60 , daCenter , false , "podcd"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  60 , daCenter , false , "delcd"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  40 , daCenter , false , "bkgr"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  40 , daCenter , false , "bkgd"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  80 , daCenter , false , "scno"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  80 , daCenter , false , "rafno"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  80 , daCenter , false , "issdt"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 120 , daLeft   , false , "issnm"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  80 , daCenter , false , "ifdt"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  70 , daCenter , false , "ifofc"  , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 120 , daLeft   , false , "ifnm"   , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  70 , daCenter , false , "payrcd" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 200 , daLeft   , false , "payrnm" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         ,  80 , daCenter , false , "crdref" , false , ""      , dfNone  , 0 , false , false );
                    InitDataProperty ( 0 , cnt++ , dtData         , 200 , daLeft   , false , "rmrk"   , false , ""      , dfNone  , 0 , false , false );
                    
                    Ellipsis = true;
                }
            break;
        }
    }   

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;

                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("EES_DMT_4007GS.do", FormQueryString(formObj));

ComOpenWait(false);

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
                document.form.invqtybox.value = RowCount;
            } else {
                document.form.invqtybox.value = 0;
            }
DataRowHeight=20;
        }
    }
    
    // 마우스가 Sheet 위에서 움직일 때 발생하는 Event
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y)
    {
        with(sheetObj)
        {
            
            var colName = ColSaveName(MouseCol);        // SaveName을 가져온다.
            var msg = "";
            //alert(colName);
            switch(colName)
            {
                case "cntr":
                    msg = "Incl. CNTR Detail";
                    break;
                
                case "stscd":
                    if ( CellValue( MouseRow , MouseCol ) == "I" ) {
                        msg = "I:Issued";
                    } else if ( CellValue( MouseRow , MouseCol ) == "C" ) {
                        msg = "C:Credit Note";
                    } else if ( CellValue( MouseRow , MouseCol ) == "X" ) {
                        msg = "X:Cancelled";
                    }
                    break;
                
                default:
                    msg = "";
                    break;
            }
            ToolTipOption = "balloon:true;width:200";
            MouseToolTipText = msg;     // ToolTip의 내용 설정
            
        }
    }
