/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5101.js
*@FileTitle : Hold Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : Mun Jung Cheol
*@LastVersion : 1.0
* 2009.10.12 Mun Jung Cheol
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
    * @class EES_DMT_5101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function ui_dmt_5101() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
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

                case "btn1_save":
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;

                case "btn1_close":
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
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); // HOLD REASON LIST
        document.form.holdRemrk.value = "";
        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    style.height = 120;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle  = "Sel.|Seq.|Invoice Hold Reason|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,    WIDTH, DATAALIGN, COLMERGE,     SAVENAME,               KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtRadioCheck , 0 , daCenter , true , "CheckBox"            );
                    InitDataProperty( 0 , cnt++ , dtSeq        , 0 , daCenter , true , "SEQ"                 );
                    InitDataProperty( 0 , cnt++ , dtData       , 0 , daLeft   , true , "intg_cd_val_dp_desc" , false , "" , dfNone , 0 , false , false);
                    InitDataProperty( 0 , cnt++ , dtHidden     , 0 , daLeft   , true , "intg_cd_val_ctnt"    , false , "" , dfNone , 0 , false , false);
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
                formObj.f_cmd.value = SEARCH01;
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                var sXml = sheetObj.GetSearchXml("EES_DMT_5101GS.do",FormQueryString(formObj));
                
ComOpenWait(false);
                
                var holdReason = ComGetEtcData(sXml, "holdReason");
                if ( holdReason != undefined && holdReason != '') {
                    var holdReasonArr = holdReason.split("||");
                    document.form.invoiceNo.value = holdReasonArr[0];
                    document.form.holdReasn.value = holdReasonArr[1];
                    document.form.holdRemrk.value = holdReasonArr[2];
                    document.form.holdYear .value = holdReasonArr[3];
                    document.form.holdOffc .value = holdReasonArr[4];
                    document.form.holdUser .value = holdReasonArr[5];
                    
                    for ( var i18 = 1 ; i18 < sheetObjects[0].RowCount+1 ; i18++  ) {
                        if ( holdReasonArr[1] == sheetObjects[0].CellValue( i18 , 3 ) ) {
                            sheetObjects[0].CellValue2( i18 , 0 ) = 1;
                        }
                    }
                }
            break;
            
            case IBSEARCH_ASYNC01:      //조회
                formObj.f_cmd.value = SEARCH;
                sheetObj.Reset();
                initSheet(sheetObjects[0], 1);
                
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch4Post( "EES_DMT_5101GS.do" , FormQueryString(formObj) );
                
ComOpenWait(false);
                
            break;

            case IBSAVE:        //저장
                formObj.f_cmd.value = MULTI;
                var holdRsnTxt = "";
                if ( sheetObjects[0].CellValue(4,0) == 1 ) {
                    if ( document.form.holdRemrk.value == "" || (document.form.holdRemrk.value).length < 10 ) {
                        ComShowCodeMessage( "DMT01106" );
                        document.form.holdRemrk.focus();
                        return false;
                    }
                }
                var cntChk = 0;
                for ( var i18 = 1 ; i18 < sheetObjects[0].RowCount+1 ; i18++  ) {
                    if ( sheetObjects[0].CellValue( i18 , 0 ) == 1 ) {
                        cntChk++;
                        holdRsnTxt = sheetObjects[0].CellText( i18 , "intg_cd_val_dp_desc" );
                    }
                }
                if ( cntChk == 0 ) {
                    ComShowCodeMessage( "DMT01107" );
                    return false;
                }
                document.form.holdRemrk.value = holdRsnTxt + " : " + document.form.holdRemrk.value;
                
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                
                var sXml = sheetObj.GetSaveXml("EES_DMT_5101GS.do", FormQueryString(formObj));
                
ComOpenWait(false);
                
                alert(dmtGetMsgText(sXml));
                var opener = window.dialogArguments;
                opener.document.form.chk_hold.value = "Y";
                opener.loadPage();
                window.close();
            break;
            
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }
        
        
        
    function sheet1_OnSearchEnd( sheetObj , ErrMsg ) {
        with (sheetObj) {
            
        }
    }
    
    function sheet1_OnClick( sheetObj , Row, Col, Value ) {
        with (sheetObj) {
            document.form.holdReasn.value = CellValue( Row , 3 );
        }
    }

function dmtGetMsgText(xmlStr){

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) 
         return;
        else
         return msgNode.firstChild.nodeValue;
   } catch(err) { ComFuncErrMsg(err.message); }
   
} 
