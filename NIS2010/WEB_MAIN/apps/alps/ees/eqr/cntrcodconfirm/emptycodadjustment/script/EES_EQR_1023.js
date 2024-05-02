/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1023.js
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
     * @class EES_EQR_1023 : EES_EQR_1023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1023() {
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

var enterSwitch = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];


        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_Retrieve":
                	obj_click();
                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
                    sheetObjects[0].SelectRow = 0;
                break;
    
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    formObject.reset();
                    document.getElementById("fromdate").focus();
                break;
                        
                case "btn_downExcel":
                    sheetObject.Down2Excel(-1, false, false, true);
                break;
                        
                case "btn_print":
                    if( sheetObject.rowcount==0 ) {
                       // errMsg = 'No data found.';
                        ComShowCodeMessage("EQR90224");
                        return;
                    }

                    formObject.f_cmd.value = IBSEARCH_ASYNC02;
                    ComOpenPopupWithTarget('/hanjin/EES_EQR_1064.do', 775, 750, "", "0,1,1,1,1,1,1", true);
                break;

                case "btns_calendarfm":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.fromdate, formObject.enddate, 'yyyy-MM-dd');
                break;
                case "btns_calendarto":
                    var cal = new ComCalendarFromTo();
                    cal.setEndFunction("nextFocusOut");
                    cal.select(formObject.fromdate, formObject.enddate, 'yyyy-MM-dd');
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

    function nextFocusOut(){
        document.form.location.focus();
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
        axon_event.addListener      ( 'blur'     , 'obj_blur'       , 'location'    );
      //  axon_event.addListener      ( 'click'    , 'obj_click'      , 'div'    		);
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- form OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        document.form.fromdate.focus();
    }    
    
    function obj_click(){
        var check = "";
        for(var i = 0 ; i < document.form.div.length ; i++){
            if(document.form.div[i].checked){
            	check = document.form.div[i].value;
            }
        }
        
        sheetObjects[0].Reset();
    	
    	initSheet(sheetObjects[0],1,check);  
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,"D");
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
    }


    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,option) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
        
            case "sheet1":

                with (sheetObj) {

                    // 높이 설정
                    style.height = 410;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(option == "A"){
                    	InitRowInfo(1, 2, 3, 100);
                    }
                    else{
                    	InitRowInfo(1, 1, 3, 100);
                    }

                    var HeadTitle = "Port|VVD|ETB|DIV|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var rowCnt = 0;

                    var sumLine = "|d2| + |d4| + |d5| + |d7| + |r2| + |r5| + |r9| + |o2| + |s2| + |o4| + |s4| + |o5| + |f2| + |a2| + |f4| + |a4| + |f5| + |a5|";
                    //var sumLine2 = "|d22| + |d42| + |d52| + |d72| + |r22| + |r52| + |o22| + |s22| + |o42| + |s42| + |f22| + |a22| + |f42| + |a42| + |f52|";

                    //데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                    
                	cnt = 0;
                	rowCnt = 0;
                    InitDataProperty( rowCnt , cnt++ , dtData    , 60  , daCenterTop , true  , "port"  , false , ""      , dfNone        );
                    InitDataProperty( rowCnt , cnt++ , dtData    , 100 , daCenter , true , "vvd"   , false , ""      , dfNone        );
                    InitDataProperty( rowCnt , cnt++ , dtData    , 70  , daCenter , true , "etb"   , false , ""      , dfDateYmd     );
                    InitDataProperty( rowCnt , cnt++ , dtData    , 50  , daCenter , false , "div"   , false , ""      , dfNone        );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "total" , false , sumLine , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d2"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d4"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d5"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d7"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "r2"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "r5"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "r9"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "o2"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "s2"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "o4"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "s4"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "o5"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "f2"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "a2"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "f4"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "a4"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "f5"    , false , ""      , dfNullInteger );
                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "a5"    , false , ""      , dfNullInteger );
                    
                    if(option == "A"){
                   	
	                    cnt = 0;
	                    rowCnt++;
	
	                    InitDataProperty( rowCnt , cnt++ , dtData    , 60  , daCenterTop , true  , "port"  , false , ""      , dfNone     , 1     );
	                    InitDataProperty( rowCnt , cnt++ , dtData    , 100 , daCenter , true , "vvd"   , false , ""      , dfNone        , 1   );
	                    InitDataProperty( rowCnt , cnt++ , dtData    , 70  , daCenter , true , "etb"   , false , ""      , dfDateYmd     , 1   );
	                    InitDataProperty( rowCnt , cnt++ , dtData    , 50  , daCenter , false , "div"   , false , ""      , dfNone        , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "total" , false , sumLine , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d2"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d4"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d5"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "d7"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "r2"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "r5"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "r9"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "o2"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "s2"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "o4"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "s4"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "o5"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "f2"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "a2"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "f4"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "a4"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "f5"    , false , ""      , dfNullInteger , -1 , false , false );
	                    InitDataProperty( rowCnt , cnt++ , dtAutoSum , 60  , daRight  , false , "a5"    , false , ""      , dfNullInteger , -1 , false , false );
                    
                    }
                   // SetSumColMerge();           // 합계의 세로 머지를 설정한다.
                    
                    CountPosition = 0;

                }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:  // 조회
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == "sheet1")
                		sheetObj.WaitImageVisible = false;
            			ComOpenWait(true);
                        formObj.f_cmd.value = SEARCH;
                        sheetObj.doSearch4Post("EES_EQR_1023GS.do",FormQueryString(formObj));
                		sheetObj.WaitImageVisible = true;
            			ComOpenWait(false);
                } else {
                    return;
                }
            break;

            case IBSEARCH_ASYNC01:  // Location
                if ( validateForm(sheetObj, formObj, sAction) ) {
                    
                    var xLocationBy = "";
                    for(var i = 0 ; i < document.form.inquirylevel.length ; i++){
                        if(document.form.inquirylevel[i].checked){
                            xLocationBy = document.form.inquirylevel[i].value;
                        }
                    }                    
                    
                    formObj.f_cmd.value = SEARCH01;
                    if ( formObj.location.value == "" ) {
                        return false;
                    }
                    if ( formObj.inquirylevel.value == "" ) {
                        return false;
                    }
                    formObj.inquiryLevel.value = xLocationBy;
                    if ( formObj.prelocation.value == formObj.location.value ) {
                        return false;
                    }
                    sheetObj.WaitImageVisible = false;
                    var sXml = sheetObj.GetSearchXml( "EES_EQR_1023GS.do" , FormQueryString(formObj) );
                    var sCheck = ComGetEtcData( sXml, "check" );

                    if (sCheck != "OK") {
                        if (document.form.location.value != "") {
                            if (xLocationBy == "R") {
                                ComShowCodeMessage("EQR90201");
                                document.form.location.value = "";
                                sheetObj.WaitImageVisible = true;
                                ComSetFocus(document.form.location);
                                return false;
                            } else if (xLocationBy == "L") {
                                ComShowCodeMessage("EQR90202");
                                document.form.location.value = "";
                                sheetObj.WaitImageVisible = true;
                                ComSetFocus(document.form.location);
                                return false;
                            } else if (xLocationBy == "E") {
                                ComShowCodeMessage("EQR90203");
                                document.form.location.value = "";
                                sheetObj.WaitImageVisible = true;
                                ComSetFocus(document.form.location);
                                return false;
                            } else if (xLocationBy == "S") {
                                ComShowCodeMessage("EQR90204");
                                document.form.location.value = "";
                                sheetObj.WaitImageVisible = true;
                                ComSetFocus(document.form.location);
                                return false;
                            }
                        } else {
                            return true;
                        }
                    }
                    else{
                    	formObj.prelocation.value = formObj.location.value;
                    }

                    sheetObj.WaitImageVisible = true;
                    var f = document.getElementById("tpszlist");
                    ComSetFocus(f);
                } else {
                    return;
                }
            break;

        }
    }

    function form_keyup() {
        var obj = null;
        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
                : event.charCode;
        if (keyValue != 13) {
            ComKeyEnter('lengthnextfocus');
        } else {
            if (obj_deactivate()) {
              //  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    
    function obj_keypress(){
        switch(event.srcElement.name){
            case "location":
                ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
            break;
            case "fromdate":
                // 숫자만 + "-"만 입력허용
                ComKeyOnlyNumber(event.srcElement);
            break;
            case "enddate":
                // 숫자만 + "-"만 입력허용
                ComKeyOnlyNumber(event.srcElement);
            break;
        }   
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate() {
        var f = document.getElementById("fromdate");
        var t = document.getElementById("enddate");
        sVal1 = f.value.replace(/\/|\-|\./g, "");
        sVal2 = t.value.replace(/\/|\-|\./g, "");

        switch (event.srcElement.name) {
            case "fromdate":    
                if (ComChkObjValid(event.srcElement, false)) {
                    
                    if (f.getAttribute("dataformat") == "ymd") {
            
                        if (sVal1 != "" && sVal2 != "") {
                            var flag = ComChkPeriod(sVal1, sVal2);
                            if (flag < 1) {
                                if(event.srcElement.name == "enddate"){
                                    event.srcElement.value = "";
                                    ComShowCodeMessage("EQR90223");
                                    enterSwitch = false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                                else{
                                    t.value = "";
                                    enterSwitch = false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            else{
                                if(chkToDateWeekBlur() == false){
                                    event.srcElement.value = "";
                                    enterSwitch = false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            enterSwitch = true;
                        }
                
                    }

                } else {
                    if (f.getAttribute("dataformat") == "ymd") {
                        
                        if (sVal1.length > 0 && !ComIsDate(sVal1)  && event.srcElement.name == 'fromdate') {
                            
                            enterSwitch = false;
                            ComShowCodeMessage("EQR90222", "YYYYMMDD");
                            event.srcElement.value = "";
                            event.srcElement.focus();
                            event.srcElement.select();
                            return false;
                        }
                    }
                }
                
                break;
            case "enddate":  
                if (ComChkObjValid(event.srcElement, false)) {
                    
                    if (t.getAttribute("dataformat") == "ymd") {
            
                        if (sVal1 != "" && sVal2 != "") {
                            var flag = ComChkPeriod(sVal1, sVal2);
                            if (flag < 1) {
                                if(event.srcElement.name == "enddate"){
                                    event.srcElement.value = "";
                                    ComShowCodeMessage("EQR90223");
                                    enterSwitch = false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                                else{
                                    t.value = "";
                                    enterSwitch = false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            else{
                            	
                                if(chkToDateWeekBlur() == false){
                                    event.srcElement.value = "";
                                    ComShowCodeMessage("EQR90221");
                                    enterSwitch = false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            enterSwitch = true;
                        }
                
                    }

                } else {
                    if (t.getAttribute("dataformat") == "ymd") {
                        
                        if (sVal2.length > 0 && !ComIsDate(sVal2)  && event.srcElement.name == 'enddate') {
                            enterSwitch = false;
                            
                            document.getElementById("enddate").value = "";
                            ComShowCodeMessage("EQR90222", "YYYYMMDD");
                            
                            t.focus();
                            t.select();
                            return false;
                        }
                    }
                    
                }
                
                break;
                
            }   
        
        return true;
    }

    function lastDay(y, m) {
        var d, d2, s = "";
        d = new Date();
        d2 = new Date(y, m, "");
        s = d2.getDate();
        return (s);
    }
    
    function chkToDateWeekBlur(){
        var period = document.form.period.value;
        var toDate = document.form.enddate.value;
        var frDate = document.form.fromdate.value;

        var toYearDate = toDate.substring(0,4);
        var frYearDate = frDate.substring(0,4);
        var toMonthDate = toDate.substring(5,7);
        var frMonthDate = frDate.substring(5,7);
        var frDayDate = "";
        var toDayDate = "";
        
        if(frDate.length > 7){
            frDayDate = frDate.substring(8,10);
            toDayDate = toDate.substring(8,10);
        }
        else{
            frDayDate = "01";
            toDayDate = lastDay(toYearDate, toMonthDate);
        }
        
        var frDateFull = new Date(frYearDate, frMonthDate-1, frDayDate);
        var toDateFull = new Date(toYearDate, toMonthDate-1, toDayDate);
        var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
        var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
        var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate,10) - parseInt(frMonthDate,10));
        var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
        var week = "";
        var fromTo = 52;
        
        if(period == "M"){
            if(retMonth>=12 ){
                if(event.srcElement.name == "enddate"){
                	//ComShowCodeMessage("EQR90221");
                    return false;
                }
            }
        }else if(period == "W"){
            if ( frYearDate == toYearDate ) {
                week = eval(toMonthDate) - eval(frMonthDate) + 1;
            } else {
                betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
                if ( (eval(toYearDate) - eval(frYearDate) ) == 1 ) {     //1년 차이일때
                    week = betwMonth;
                } else {
                    week = (eval(toYearDate) - eval(frYearDate) -1 ) * fromTo + betwMonth;
                }
            }

            if(week>12){
                ComShowCodeMessage("EQR90221");
                document.getElementById("fromdate").value = "";
                document.getElementById("enddate").value = "";
                ComSetFocus(document.getElementById("fromdate"));
                return;
            }
        }
        return true;
    }
    
    function obj_activate() {
        ComClearSeparator(event.srcElement);
        ComSetFocus(event.srcElement);
    }    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             if(sAction != IBSEARCH_ASYNC01){
                if(period.value == "M"){
                    if(fromdate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(fromdate);
                        return false;
                    }
                    else if(enddate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(enddate);
                        return false;
                    }
                }else if(period.value == "W"){
                    if(fromdate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(fromdate);
                        return false;
                    }
                    else if(enddate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(enddate);
                        return false;
                    }
                }
                
                
                if( location.value == "" ){
                    ComShowCodeMessage("EQR90213","Location ");
                    ComSetFocus(location);
                    return false;
                }
                
                if (fromdate.value.length < 8) {
                    return false;
                } else if (enddate.value.length < 8) {
                    
                    return false;
                }
                if(!enterSwitch){
                    return false;
                }
             }
         } // end of with
         return true;
    }
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {

            var check2 = "";
            for(var i = 0 ; i < document.form.div.length ; i++){
                if(document.form.div[i].checked){
                    check2 = document.form.div[i].value;
                }
            }

            
/*
            for ( var x = 0; x < RowCount; x++) {
                if (sheetObj.CellValue(x, 1) == "Total") {
                	if(check2 == "L"){
                		if(CellValue(x,"div") == "Load"){
	                		RowBackColor(x) = RgbColor(201, 213, 235);
                		}
                		else{
                			//RowHidden(x) = true;
                			RowDelete(x,false);
                		}
                	}
                	else if(check2 == "D"){
                		if(CellValue(x,"div") == "Disc"){
                		
                			
                		}
                		else{
                			//RowHidden(x) = true;
                			RowDelete(x,false);
                			RowBackColor(x) = RgbColor(201, 213, 235);
                		}
                		
                	}
                	else{
                		RowBackColor(x) = RgbColor(201, 213, 235);
                	}
                }
            }
*/
            //for ( var i = 4; i < 22 ; i++) {
            for ( var i = 4; i < 23 ; i++) { 	
                if( RowCount > 0 ){
                    if ( ComIsNull( CellValue(RowCount-1, i) ) || ComIsNull( CellValue(RowCount, i) ) ) {
                    	if(check2 == "L" || check2 == "D"){
                    		SumText(0,i) = "";
                    	}
                    	else{
                    		SumText(1,i) = "";
                    		SumText(0,i) = "";
                    	}
                    }else{
                    	if(check2 == "L"){
	                        SumValue(0,i) = CellValue(RowCount-1,i);
	                        
                    	}
                    	else if(check2 == "D"){
                    	
                    		SumValue(0,i) = CellValue(RowCount  ,i);
                    	}
                    	else{
	                        SumValue(0,i) = CellValue(RowCount-1,i);
	                        SumValue(1,i) = CellValue(RowCount  ,i);
                    	}
                    }
                }
            }            
 
            if (RowCount > 0) {
            	RowHidden(RowCount-1) = true;
            	RowHidden(RowCount) = true;
            }

            if(check2 == "L"){
                SumText(0, 0) = "Grand Total";
                SumText(0, 1) = "Grand Total";
                SumText(0, 2) = "Grand Total";
            	SumText(0, "div") = "Load";
                CellAlign(0, 0) = daCenter;
                CellAlign( LastRow     , "div" ) = daCenter   ;
                SetMergeCell( LastRow  , 0 , 1, 3 );
            }
            else if(check2 == "D"){
                SumText(0, 0) = "Grand Total";
                SumText(0, 1) = "Grand Total";
                SumText(0, 2) = "Grand Total";
            	SumText(0, "div") = "Disc";
                CellAlign(0, 0) = daCenter;
                CellAlign( LastRow     , "div" ) = daCenter   ;
                SetMergeCell( LastRow  , 0 , 1, 3 );
            }
            else{
                if(LastRow > 1){
                	SumText(0, 0) = "";
                	SumText(0, 1) = "Grand Total";
/*
                	SumText(1, 0) = "Grand Total";
                    SumText(0, 1) = "Grand Total";
                    SumText(1, 1) = "Grand Total";
                    SumText(0, 2) = "Grand Total";
                    SumText(1, 2) = "Grand Total";
*/                    
                    SumText(0, "div") = "Load";
                    SumText(1, "div") = "Disc";
                    CellAlign( LastRow - 1 , "div" ) = daCenter   ;
                    CellAlign( LastRow     , "div" ) = daCenter   ;
	       			CellAlign( LastRow - 1 , "port"  ) = daCenter;
	       			CellAlign( LastRow - 1 , "vvd"  ) = daCenter;
	       			CellAlign( LastRow , "vvd"  ) = daCenter;
	            //    SetMergeCell(  LastRow-1 , 0 , 2, 3 );
                }
 
            }

            document.form.rpt_fromdate.value = document.form.fromdate.value;
            document.form.rpt_enddate .value = document.form.enddate .value;
            document.form.rpt_location.value = document.form.location.value;
            
            var check = "";
            for(var i = 0 ; i < document.form.inquirylevel.length ; i++){
                if(document.form.inquirylevel[i].checked){
                    check = document.form.inquirylevel[i].value;
                }
            }

            if ( check == "R" ) {
                document.form.rpt_inpuirylevel.value = "RCC";
            } else if ( check == "L" ) {
                document.form.rpt_inpuirylevel.value = "LCC";
            } else if ( check == "E" ) {
                document.form.rpt_inpuirylevel.value = "ECC";
            } else if ( check == "S" ) {
                document.form.rpt_inpuirylevel.value = "SCC";
            }
            
            if ( check2 == "A" ) {
                document.form.rpt_div.value = "ALL";
            } else if ( check2 == "L" ) {
                document.form.rpt_div.value = "Loading";
            } else if ( check2 == "D" ) {
                document.form.rpt_div.value = "Discharging";
            }
            document.form.rpt_tpsz    .value = document.getElementById('tpsz').options[document.getElementById('tpsz').options.selectedIndex].text;
            document.form.rpt_tpszlist.value = document.form.tpszlist.value;
           
        }
    }

    function obj_change(){
        obj = event.srcElement;
        if(obj.name == "tpsz"){
            if (obj.value == "A") {
                document.form.tpszlist.value = "";
            } else if (obj.value == "D") {
                document.form.tpszlist.value = "D2, D4, D5, D7";
            } else if (obj.value == "S") {
                document.form.tpszlist.value = "O2, S2, O4, S4, O5, F2, A2, F4, A4, F5, A5";
            } else if (obj.value == "R") {
                document.form.tpszlist.value = "R2, R5, R9";
            }
        }
    }
    
    function obj_blur() {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }