/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7006.js
*@FileTitle : Fax/E-mail Sending History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.14 mun jung cheol
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
     * @class ui_dmt_7006 : ui_dmt_7006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_dmt_7006() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;


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

                case "btns_calendar":
                    if ( document.form.selectOpt[0].checked ) {
                        var cal = new ComCalendarFromTo();
                        cal.select(formObject.sndfrdt, formObject.sndtodt, 'yyyy-MM-dd');
                    }
                break;
            
                case "btn_downexcel":
                    sheetObjects[0].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
                break;

                case "btn_retrieve":
                    doActionIBSheet ( sheetObjects[0] , formObject , IBSEARCH );
                break;

                case "btn_new":
                    var formObj = document.form;
                    ComResetAll();
                    DmtComSetClassManyObjects('input1', formObj.sndfrdt, formObj.sndtodt);
                            
                    //var CURR_DATE = ComGetNowInfo();
                    var CURR_DATE = DmtComOfficeCurrDate(sheetObjects[0], formObj);
                    
                    // 조회기간(Period) 설정
                    var fmDt = ComGetDateAdd(CURR_DATE, "M", -1);
                    var toDt = CURR_DATE;
                    ComSetObjValue(formObj.sndfrdt, fmDt);
                    ComSetObjValue(formObj.sndtodt, toDt);
                    doActionIBCombo(sheetObjects[0], document.form, comboObjects[0], SEARCHLIST02);
                    document.form.sndrnmm.value = "";
                    document.form.sndrcdd.value = "";
                    document.form.invoice.value = "";
                    document.form.payercd.value = "";
                    document.form.payernm.value = "";                    
                                
                    document.form.sndfrdt.readOnly = false;
                    document.form.sndtodt.readOnly = false;
                    document.form.sndrcdd.readOnly = false;
                    comboObjects[0].Enable = true;
                    document.form.sndfrdt.className = 'input1';
                    document.form.sndtodt.className = 'input1';
                    document.form.sndrcdd.className = 'input';
            
                    document.form.invoice.readOnly = true;
                    document.form.invoice.className = 'input2';
            
                    document.form.payercd.readOnly = true;
                    document.form.payernm.readOnly = true;
                    document.form.payercd.className = 'input2';
                    document.form.payernm.className = 'input2';
                    
                    document.form.sndrcdd.value = "";
                    document.form.invoice.value = "";
                    document.form.payercd.value = "";
                    document.form.payernm.value = "";

                break;

                case "btn_minimize":
                    var schCondDiv = document.getElementById("sch_cond_div");
                    if(schCondDiv.style.display == 'block') {   // 조건 선택부분 보임 상태
                        schCondDiv.style.display = 'none';
                        sheetObjects[0].style.height = 500;
                    } else {
                        schCondDiv.style.display = 'block';
                        sheetObjects[0].style.height = 400;
                    }
                break;
                
                case "btns_payer_cd":
                    if ( document.form.selectOpt[2].checked ) {
                        openPopup("payercd","");
                    }
                break; 
                
                case "btns_inv_no":
                    if ( document.form.selectOpt[1].checked ) {
                        openPopup('invoice');
                    }
                break; 
                
                case "btns_sender_cd":
                    if ( document.form.selectOpt[0].checked ) {
                        openPopup("sndrnmm","");
                    }
                break; 
                
                case "btn_Close":
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

    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
        var formObj = document.form;

        // 팝업으로 호출시에 타이틀 표시 처리
        if( formObj.h_jspno.value != "" && formObj.h_jspno.value != "EES_DMT_7006" ) {
            
            //팝업으로 호출시에 Close 버튼을 보여준다.
            //btnCloseLayer.style.display  = "inline";
        }        
        
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBMultiCombo초기화 
        initCombo(comboObjects[0],1);

        //html컨트롤 이벤트초기화
        initControl();
        var formObj = document.form;
        
        DmtComSetClassManyObjects('input1', formObj.sndfrdt, formObj.sndtodt);
                
        //var CURR_DATE = ComGetNowInfo();
        var CURR_DATE = DmtComOfficeCurrDate(sheetObjects[0], formObj);
                
        // 조회기간(Period) 설정
        var fmDt = ComGetDateAdd(CURR_DATE, "M", -1);
        var toDt = CURR_DATE;
        ComSetObjValue(formObj.sndfrdt, fmDt);
        ComSetObjValue(formObj.sndtodt, toDt);

        doActionIBCombo(sheetObjects[0], document.form, comboObjects[0], SEARCHLIST02);
        comboObjects[0].Code = "All";

        document.form.sndfrdt.readOnly = false;
        document.form.sndtodt.readOnly = false;
        document.form.sndrcdd.readOnly = false;
        comboObjects[0].Enable = true;
        document.form.sndfrdt.className = 'input1';
        document.form.sndtodt.className = 'input1';
        document.form.sndrcdd.className = 'input';

        document.form.invoice.readOnly = true;
        document.form.invoice.className = 'input2';

        document.form.payercd.readOnly = true;
        document.form.payernm.readOnly = true;
        document.form.payercd.className = 'input2';
        document.form.payernm.className = 'input2';
        
        ComEnableManyObjects(true, document.form.tempuser, document.form.btns_calendar);
        ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sntoff);
        ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sender_cd);
        ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
        ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);
                
        if ( document.form.h_jspno.value != "EES_DMT_7006" ) {
 
            if ( document.form.h_jspno.value == "EES_DMT_4011" || document.form.h_jspno.value == "EES_DMT_4018" ) {

                document.form.sndfrdt.readOnly = true;
                document.form.sndtodt.readOnly = true;
                document.form.sndrcdd.readOnly = true;
                comboObjects[0].Enable = false;
                document.form.sndfrdt.className = 'input2';
                document.form.sndtodt.className = 'input2';
                document.form.sndrcdd.className = 'input2';
                
                document.form.invoice.readOnly = true;
                document.form.invoice.className = 'input2';
                
                document.form.payercd.readOnly = false;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input1';
                document.form.payernm.className = 'input2';
                
                document.form.selectOpt[2].checked = true;
                document.form.shttppp.value = "O";
                
                document.form.sndfrdt.value = "";
                document.form.sndtodt.value = "";
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                comboObjects[0].Code = -1;
                
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);
                
                var opener_obj = window.dialogArguments;
                document.form.payercd.value = opener_obj.document.form.payc.value;
                document.form.payernm.value = opener_obj.document.form.payn.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            
            } else if ( document.form.h_jspno.value == "EES_DMT_3109" ) {
                
                document.form.sndfrdt.readOnly = true;
                document.form.sndtodt.readOnly = true;
                document.form.sndrcdd.readOnly = true;
                comboObjects[0].Enable = false;
                document.form.sndfrdt.className = 'input2';
                document.form.sndtodt.className = 'input2';
                document.form.sndrcdd.className = 'input2';
                
                document.form.invoice.readOnly = true;
                document.form.invoice.className = 'input2';
                
                document.form.payercd.readOnly = false;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input1';
                document.form.payernm.className = 'input2';
                
                document.form.selectOpt[2].checked = true;
                document.form.shttppp.value = "D";
                
                document.form.sndfrdt.value = "";
                document.form.sndtodt.value = "";
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                comboObjects[0].Code = -1;
                
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);
                
                var opener_obj = window.dialogArguments;
                document.form.payercd.value = opener_obj.document.form.payer_cd.value;
                document.form.payernm.value = opener_obj.document.form.payer_nm.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                
            } else if ( document.form.h_jspno.value == "EES_DMT_3108" ) {
                
                document.form.sndfrdt.readOnly = true;
                document.form.sndtodt.readOnly = true;
                document.form.sndrcdd.readOnly = true;
                comboObjects[0].Enable = false;
                document.form.sndfrdt.className = 'input2';
                document.form.sndtodt.className = 'input2';
                document.form.sndrcdd.className = 'input2';
                
                document.form.invoice.readOnly = true;
                document.form.invoice.className = 'input2';
                
                document.form.payercd.readOnly = false;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input1';
                document.form.payernm.className = 'input2';
                
                document.form.selectOpt[2].checked = true;
                document.form.shttppp.value = "G";
                
                document.form.sndfrdt.value = "";
                document.form.sndtodt.value = "";
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                comboObjects[0].Code = -1;
                
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);
                
                var opener_obj = window.dialogArguments;
                document.form.payercd.value = opener_obj.document.form.payer_cd.value;
                document.form.payernm.value = opener_obj.document.form.payer_nm.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                
            } else {
                    
                document.form.sndfrdt.readOnly = true;
                document.form.sndtodt.readOnly = true;
                document.form.sndrcdd.readOnly = true;
                comboObjects[0].Enable = false;
                document.form.sndfrdt.className = 'input2';
                document.form.sndtodt.className = 'input2';
                document.form.sndrcdd.className = 'input2';
            
                document.form.invoice.readOnly = false;
                document.form.invoice.className = 'input1';
            
                document.form.payercd.readOnly = true;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input2';
                document.form.payernm.className = 'input2';
                    
                document.form.sndfrdt.value = "";
                document.form.sndtodt.value = "";
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                comboObjects[0].Code = -1;                
                    
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);
                
                document.form.selectOpt[1].checked = true;
                document.form.invoice.value = document.form.h_invoice.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                    
            }
        }
    }

   // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListener('blur',  'obj_blur', 'sndfrdt', 'sndtodt' );   //- 포커스 나갈때
        axon_event.addListener('blur',  'obj_blur2', 'payercd');   //- 포커스 나갈때
        axon_event.addListener('focus', 'obj_focus', 'sndfrdt', 'sndtodt');  //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('click', 'obj_click', 'form');
    }
    
    function obj_click(){
 
        var obj = event.srcElement;
        if(obj.name == 'selectOpt') {

            if ( ComGetObjValue( obj ) == "0" ) {

                //var CURR_DATE = ComGetNowInfo();
                var CURR_DATE = DmtComOfficeCurrDate(sheetObjects[0], document.form);
                var fmDt = ComGetDateAdd(CURR_DATE, "M", -1);
                var toDt = CURR_DATE;
                ComSetObjValue(document.form.sndfrdt, fmDt);
                ComSetObjValue(document.form.sndtodt, toDt);
                doActionIBCombo(sheetObjects[0], document.form, comboObjects[0], SEARCHLIST02);
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                document.form.invoice.value = "";
                document.form.payercd.value = "";
                document.form.payernm.value = ""; 
                
                document.form.sndfrdt.readOnly = false;
                document.form.sndtodt.readOnly = false;
                document.form.sndrcdd.readOnly = false;
                comboObjects[0].Enable = true;
                document.form.sndfrdt.className = 'input1';
                document.form.sndtodt.className = 'input1';
                document.form.sndrcdd.className = 'input';
        
                document.form.invoice.readOnly = true;
                document.form.invoice.className = 'input2';
        
                document.form.payercd.readOnly = true;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input2';
                document.form.payernm.className = 'input2';
                
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);                
                
            } else if ( ComGetObjValue( obj ) == "1" ) {
                
                document.form.sndfrdt.readOnly = true;
                document.form.sndtodt.readOnly = true;
                document.form.sndrcdd.readOnly = true;
                comboObjects[0].Enable = false;
                document.form.sndfrdt.className = 'input2';
                document.form.sndtodt.className = 'input2';
                document.form.sndrcdd.className = 'input2';
        
                document.form.invoice.readOnly = false;
                document.form.invoice.className = 'input1';
        
                document.form.payercd.readOnly = true;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input2';
                document.form.payernm.className = 'input2';
                
                document.form.sndfrdt.value = "";
                document.form.sndtodt.value = "";
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                document.form.payercd.value = "";
                document.form.payernm.value = "";
                comboObjects[0].Code = -1;                
                
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);
                
            } else if ( ComGetObjValue( obj ) == "2" ) {
                
                document.form.sndfrdt.readOnly = true;
                document.form.sndtodt.readOnly = true;
                document.form.sndrcdd.readOnly = true;
                comboObjects[0].Enable = false;
                document.form.sndfrdt.className = 'input2';
                document.form.sndtodt.className = 'input2';
                document.form.sndrcdd.className = 'input2';
        
                document.form.invoice.readOnly = true;
                document.form.invoice.className = 'input2';
        
                document.form.payercd.readOnly = false;
                document.form.payernm.readOnly = true;
                document.form.payercd.className = 'input1';
                document.form.payernm.className = 'input2';
                
                document.form.sndfrdt.value = "";
                document.form.sndtodt.value = "";
                document.form.sndrcdd.value = "";
                document.form.sndrnmm.value = "";
                document.form.invoice.value = "";
                comboObjects[0].Code = -1;
                
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);  
            }
        }
    }
   
    //포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        ComChkObjValid(obj);
    }
    
    //포커스가 나갈 때
    function obj_blur2(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        if(obj.name == 'payercd') {
            doActionText(sheetObjects[0], document.form, obj, SEARCH20);
        }
    }    
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        var obj = event.srcElement;
        ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){

            case "engup":
                // 영문대+숫자 
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;

            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
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

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 7, 100);

                    var HeadTitle1 = "Seq.|INV No./Payer|Type|Fax/E-mail|Result|Sent Date|Sent Office|Sender ID|Sender Name|";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty ( 0 , cnt++ , dtSeq    ,  35 , daCenter , true , "seq"    , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtData   , 100 , daCenter , true , "invnoo" , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtData   ,  40 , daCenter , true , "shtype" , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtData   , 150 , daCenter , true , "faxeml" , false , "" , dfNone , 0 , false , false , 50 );
                    InitDataProperty ( 0 , cnt++ , dtData   , 260 , daLeft   , true , "rstmsg" , false , "" , dfNone , 0 , false , false , 50 );
                    InitDataProperty ( 0 , cnt++ , dtData   , 105 , daCenter , true , "snddat" , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtData   ,  75 , daCenter , true , "sndoff" , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtData   ,  75 , daCenter , true , "sndrid" , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtData   , 100 , daLeft   , true , "sndrnm" , false , "" , dfNone , 0 , false , false      );
                    InitDataProperty ( 0 , cnt++ , dtHidden ,  75 , daCenter , true , "payerr" , false , "" , dfNone , 0 , false , false      );
                    Ellipsis = true;
                }
            break;
        }
    }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return;
                
                formObj.f_cmd.value = SEARCH;
                
                ComOpenWait(true);
                sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch("EES_DMT_7006GS.do", FormQueryString(formObj));
                
                ComOpenWait(false);
            break;
         }
     }


     /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj = document.form;
        
        switch(comboObj.id) {  
        
            case "office": 
                with (comboObj) { 
                    //MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left");
                    DropHeight = 160;
                    ColBackColor(0) = "#CCFFFD";
                    
                    ValidChar(2); // 영어대문자 사용
                    MaxLength = 5;
                }
            break;
        }
    }
   
   
    // IBCombo 데이터 조회 및 세팅
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg = false;
         sheetObj.WaitImageVisible = false;
         
         formObj.f_cmd.value = formCmd;
         var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
         
         switch(formCmd) {
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = false;
                    SetColWidth("45");
                    ValidChar(2);   // 영대문자만 사용
                    //MaxLength = 6;
                }
                
                var data = ComGetEtcData(sXml, "common_cd");
                if (data != undefined && data != '') {
                    var comboItems = data.split("|");
                    comboObj.InsertItem(0, "All", "All");
                    
                    for (var i = 0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);     
                    }
                }
                break;
         
            case SEARCHLIST02: // Office
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = true;
                    SetColWidth("95");
                    ValidChar(2, 2); // 영대문자, 특수문자만 가능
                }
                
                var data = ComGetEtcData(sXml, "OFC_CD");
                if (data != undefined && data != '') {
                    var comboItems = data.split("|");
                    for (var i = 0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i, comboItems[i], comboItems[i]);       
                    }
                    
                    // 로그인 User Office를 Default
                        var usr_ofc_cd = document.form.h_user_office.value;
                        comboObjects[0].Code = usr_ofc_cd;
                    
                        if(comboObjects[0].Code != usr_ofc_cd) {
                            comboObjects[0].InsertItem(0, usr_ofc_cd, usr_ofc_cd);
                            comboObjects[0].Code = usr_ofc_cd;
                        } 
                }
                break;
                
            case COMMAND01: // Incl. Sub Office
//                var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
//                if(subOfcCds != '')
//                    comboObj.Code = subOfcCds;

                
                   if (sXml != undefined && sXml != '') {
                        var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
                        var comboObj = comboObjects[0];
                        if(ofc_cds != '') 
                            comboObj.Code = ofc_cds;
                        var usr_ofc_cd = document.form.h_user_office.value;
                        comboObjects[0].Code = usr_ofc_cd;                        
                    }else{
                        var usr_ofc_cd = document.form.h_user_office.value;
                        comboObjects[0].Code = usr_ofc_cd;
                    }                
                
                
                
                break;
                

        }
         
         sheetObj.WaitImageVisible = true;
    }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             switch(sAction) {
             
                case IBSEARCH:

                    if ( document.form.selectOpt[0].checked ) {
                        
                        if(!ComIsDate(sndfrdt)) {
                            ComAlertFocus(sndfrdt, ComGetMsg('COM12134', 'Period From Date'));
                            return false;
                        }
                        if(!ComIsDate(sndtodt)) {
                            ComAlertFocus(sndtodt, ComGetMsg('COM12134', 'Period To Date'));
                            return false;
                        }
                        
                        var startDt = ComGetUnMaskedValue(sndfrdt, 'ymd');
                        var endDt = ComGetUnMaskedValue(sndtodt, 'ymd');
                        // 기간체크
                        if (ComChkPeriod(startDt, endDt) == 0) {
                            ComShowCodeMessage("DMT01020");
                            return false;
                        }
                        
                        // DEM/DET Office
                        var ofcCd = comboObjects[0].Code;
                        if(ComIsEmpty(ofcCd)) {
                            ComShowCodeMessage('COM12113', "DEM/DET Office");
                            return false;
                        }
                        
                        ComSetObjValue(sndoffc, ofcCd);
                        document.form.seloptt.value = "0";
                        
                    } else if ( document.form.selectOpt[1].checked ) {
                        
                        var invno = document.form.invoice.value;
                        if(ComIsEmpty(invno)) {
                            ComShowCodeMessage('DMT03028', "Invoice No");
                            return false;
                        }
                        ComSetObjValue(sndoffc, "");
                        document.form.seloptt.value = "1";
                        
                    } else if ( document.form.selectOpt[2].checked ) {
                        
                        var payer = document.form.payercd.value;
                        if(ComIsEmpty(payer)) {
                            ComShowCodeMessage('DMT03028', "Payer");
                            return false;
                        }
                        ComSetObjValue(sndoffc, "");
                        document.form.seloptt.value = "2";
                    }
                    
                break;
                
            } // switch - end
         } // with - end
         return true;
    }
      
      
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
    	
        with(sheetObj) {
        	// CHM-201534104 : DAR-Before / After BKG 승인으로 INV CXL/재발행시 이전/이후 INV의 전송 현황 조회
        	// 아래 화면에서 호출시에는 조회결과에 존재하는 Invoice No. 목록을 조회조건에 추가해준다.
        	// EES_DMT_4002	: Invoice Creation & Issue - Booking, 
        	// EES_DMT_4004	: Manual Invoice Creation & Issue
        	// EES_DMT_4016	: SZPSC DEM Calculation & Issue
        	if (RowCount > 0 && ComGetObjValue(formObj.h_selectOpt) == "1" && ComGetObjValue(formObj.selectOpt) == "1") {
        		var inpInvNo = ComGetObjValue(formObj.invoice);

        		for (var i=HeaderRows; i<=RowCount; i++) {

        			if (inpInvNo.indexOf(CellValue(i, "invnoo")) == -1) {
        				inpInvNo = inpInvNo + "," + CellValue(i, "invnoo");
        			}
        		}
        		ComSetObjValue(formObj.invoice, inpInvNo);
        	}
        }
    }
    
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    document.onkeypress = keyPress ;

    
    /*
     * 각 공통팝업창 호출 함수 
     */
    function openPopup(flag, arg) {
        
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var sUrl    = '';
        var sWidth  = '';
        var sHeight = '';
        
        with(sheetObj) {
            switch(flag) {
                case 'payercd':       // Customer Inquiry Popup
                    ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
                break;
                
                case 'sndrnmm':        // Issue Name Inquiry Popup
                    ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
                break;
                
                case 'invoice':        // CNTR No. 멀티입력 팝업 호출
                	var returntitle = 'Invoice No.';
                	var param = "?returnval=" + flag + "&returntitle=" + returntitle;
                    ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                break;

            } // switch-end
        } // with-end
        
        if(sUrl != '') {
            var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
            ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
        }
    }
    
    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
        var targObj = eval("document.form." + return_val);
        var retStr = rArray.toString().toUpperCase();
        
        ComSetObjValue(targObj, retStr);
    }    

    /*
     * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
     */
    function getPayerCd(aryPopupData) {
        document.form.payercd.value = aryPopupData[0][3];
        document.form.payernm.value = aryPopupData[0][4];
    }
    

    /*
     * Issue Name 공통팝업에서 선택한 Issue Name, Issue Code값을 해당 필드에 설정 
     */
    function setUsrNm(aryPopupData){
        document.form.sndrnmm.value = aryPopupData[0][5];
        document.form.sndrcdd.value = aryPopupData[0][4];
    }

    //Payer 체크
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.payercd)));
        
        if(cust_len == 0) {
            ComSetObjValue(formObj.payernm, "");
            //ComSetFocus(formObj.payercd);
            return;
        }
        
        if(cust_len == 6) {
            ComSetObjValue(formObj.s_cust_gubun, "1");
            ComSetObjValue(formObj.s_cust_cd, formObj.payercd.value);
        }else if(cust_len > 6) {
            ComSetObjValue(formObj.s_cust_gubun, "2");
            ComSetObjValue(formObj.s_cust_cd, formObj.payercd.value);
        }else {
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.payercd, "");
            ComSetObjValue(formObj.payernm, "");
            ComSetFocus(formObj.payercd);
            ComShowCodeMessage("COM12143", "Payer", "6");
            return;
        }
        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_cd = ComGetEtcData(sXml, "PAYER_CODE");
        var cust_nm = ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
        
        if( cust_nm == null || cust_nm == "" ) {
            ComShowCodeMessage("COM132201", "Payer", "8");
            ComSetFocus(formObj.payercd);
                document.form.s_cust_gubun.value = "";
                document.form.payercd.value = "";
                document.form.payernm.value = "";                
        }else{
            ComSetObjValue(formObj.payernm, cust_nm);
            document.form.payercd.value = cust_cd;
        }
        sheetObj.WaitImageVisible = true;
        
    }
    
    
    // 마우스가 Sheet 위에서 움직일 때 발생하는 Event
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
            
            var colName = ColSaveName(MouseCol);        // SaveName을 가져온다.
            var msg = "";
            //alert(colName);
            switch(colName) {
                case "faxeml":
                    msg = CellValue( MouseRow , MouseCol );
                break;
                
                case "rstmsg":
                    msg = CellValue( MouseRow , MouseCol );
                break;
                
                default:
                    msg = "";
                break;
            }
            ToolTipOption = "balloon:true;width:200";
            MouseToolTipText = msg;     // ToolTip의 내용 설정
            
        }
    }    