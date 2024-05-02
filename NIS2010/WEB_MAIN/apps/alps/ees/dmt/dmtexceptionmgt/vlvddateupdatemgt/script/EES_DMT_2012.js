﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_2012.js
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김재진
*@LastVersion : 1.0
* 2009.08.26 김재진
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
     * @class ees_dmt_2012 : ees_dmt_2012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_2012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    
   	/* 개발자 작업	*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var set_day = 30;

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

                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;

                case "btn_new":
                    var formObject = document.form;
                    formObject.reset();
                    formObject.mvmt.focus();
                    document.getElementById("vvdc").className = "input2";
                    document.getElementById("frdt").className = "input1";
                    document.getElementById("todt").className = "input1";                    
//                    var data = getDefaultDate(set_day).split("|");
//                    formObject.frdt.value = data[1];
//                    formObject.todt.value = data[0];
                    
					//Period Date 초기화
					//사용자 Office 의 현재 날짜를 조회한다.
					var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject);
					var fmMvmtDt = ComGetDateAdd(formObject.ofcCurrDate, "D", -30);
					var toMvmtDt = ofcCurrDate;
					ComSetObjValue(formObject.frdt, fmMvmtDt);
					ComSetObjValue(formObject.todt, toMvmtDt); 
					
                    sheetObject1.RemoveAll();
                    initSheet(sheetObject1,0);
                break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
//                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;

                case "btns_calendarfm":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                
                case "btns_calendarto":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
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
        initControl();
        var formObject = document.form; 
//        var data = getDefaultDate(set_day).split("|");
//        formObject.frdt.value = data[1];
//        formObject.todt.value = data[0];        

		//Period Date 초기화
		//사용자 Office 의 현재 날짜를 조회한다.
		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject);
		var fmMvmtDt = ComGetDateAdd(formObject.ofcCurrDate, "D", -30);
		var toMvmtDt = ofcCurrDate;
		ComSetObjValue(formObject.frdt, fmMvmtDt);
		ComSetObjValue(formObject.todt, toMvmtDt); 	     
     
     }

    function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerForm  ( 'change'   , 'obj_change'    , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form ); //- 키보드 입력할때
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
        axon_event.addListener      ( 'click'    , 'dayVvdR_click' , 'dayVvdR'     );
        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'    , form          );
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
                    style.height = 430;
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
                    
                    var xVal = document.form.mvmt.value;
                    
                    var HeadTitle1 = "";
                    var HeadTitle2 = "";
                    
                    if ( xVal == "VL" ) {                    
                    
                        HeadTitle1 = "||Seq.|Lane|VVD CD|P/F SKD|P/F SKD|ETA|ETD|First VL MVMT|Last VL MVMT|VL Date in Charge|VL Date in Charge|Update|Update|Update||";
                        HeadTitle2 = "||Seq.|Lane|VVD CD|ETA|ETD|ETA|ETD|First VL MVMT|Last VL MVMT|Now|To Be|Date|Office|Name||";
                    
                    } else {
                        
                        HeadTitle1 = "||Seq.|Lane|VVD CD|P/F SKD|P/F SKD|ETA|ETD|First VD MVMT|Last VD MVMT|F/Time Commence Date|F/Time Commence Date|Update|Update|Update||";
                        HeadTitle2 = "||Seq.|Lane|VVD CD|ETA|ETD|ETA|ETD|First VD MVMT|Last VD MVMT|Now|To Be|Date|Office|Name||";
                        
                    }

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVename,  keyfield, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30  , daCenter , false , "ibflag"  );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 30  , daCenter , true  , "status"  );
                    InitDataProperty( 0 , cnt++ , dtSeq          , 30  , daCenter , true  , "seq"     );
                    InitDataProperty( 0 , cnt++ , dtData         , 50  , daCenter , true  , "lane"    , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 80  , daCenter , true  , "vvd"     , false , "" , dfNone    , -1 , false , false );
                    
                    InitDataProperty( 0 , cnt++ , dtData         , 105  , daCenter , true  , "pf_eta"     , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 105  , daCenter , true  , "pf_etd"     , false , "" , dfNone    , -1 , false , false );                    
                    
                    InitDataProperty( 0 , cnt++ , dtData         , 80  , daCenter , true  , "eta"     , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 80  , daCenter , true  , "etd"     , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 105 , daCenter , true  , "firstvl" , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 105 , daCenter , true  , "lastvl"  , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 90  , daCenter , true  , "vldaten" , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 90  , daCenter , true  , "vldateb" , false , "" , dfDateYmd , -1 , true  , true  );
                    InitDataProperty( 0 , cnt++ , dtData         , 90  , daCenter , true  , "updated" , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 60  , daCenter , true  , "updateo" , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 50  , daLeft   , true  , "updaten" , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus , 50  , daCenter , true  , "updatei" , false , "" , dfNone    , -1 , false , false );
                    InitDataProperty( 0 , cnt++ , dtHidden       , 50  , daCenter , true  , "clpt_ind_seq" , false , "" , dfNone    , -1 , false , false );

                    //InitUserFormat2( 0 , "firstvl" , "####-##-## ##:##" , "-|:" );
                    //InitUserFormat2( 0 , "lastvl"  , "####-##-## ##:##" , "-|:" );
                    CountPosition = 0;
                    
                    RequestTimeOut = 600;

                }

            break;

        }

    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                if ( validateForm(sheetObj,formObj,sAction) ) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.Reset();
                    initSheet(sheetObj, 0);
                    
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                    
                    sheetObj.DoSearch4Post( "EES_DMT_2012GS.do" , FormQueryString(formObj) );
                    
ComOpenWait(false);
                    
                    DmtComEnableManyBtns( true , "btn_retrieve" );
                }
            break;
            
            case IBSAVE:        //저장
                //if(validateForm(sheetObj,formObj,sAction))
                
                // 10 일이 넘는지 체크
                for( var i = 1 ; i < sheetObjects[0].RowCount+2 ; i++ ){
                    if ( sheetObjects[0].CellValue(i,12) != "" ) {
                        var xDayTerm = ComGetDaysBetween ( sheetObjects[0].CellValue(i,7) , sheetObjects[0].CellValue(i,12) );
                        if ( xDayTerm < -10 || xDayTerm > 10 ) {
                            ComShowCodeMessage('DMT01079', sheetObjects[0].CellValue(i,4));
                            sheetObjects[0].SelectCell( i , 10 , true , "" );
                            return false;
                        }
                    }
                }            
            
                formObj.f_cmd.value = MULTI;                
                var sParam1 = sheetObjects[0].GetSaveString(true);
                sParam = sParam1 + "&" + FormQueryString(formObj);
                
ComOpenWait(true);
sheetObj.WaitImageVisible = false;                
                
                var sXml = sheetObj.GetSaveXml("EES_DMT_2012GS.do", sParam);
                
ComOpenWait(false);
                
                sheetObjects[0].LoadSaveXml(sXml);
                
ComOpenWait(true);
sheetObj.WaitImageVisible = false; 
                
                doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
                
ComOpenWait(false);
                
            break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
         
        with(formObj){
            if (port.value == "") {
                ComShowCodeMessage('DMT00102', "Port code");
                port.focus();
                return false;
            }
            
            if(port.value.length < 5) {
	 			ComShowCodeMessage('DMT00110', 'Location');
	 			port.value = "";
	            loc_cd.value = "";
	            port.focus();
	            return false;
        	}
            
            if ( formObj.dayVvdR[0].checked ) {
                if ( formObj.frdt.value == "" ) {
                    ComShowCodeMessage('DMT00102', "From date");
                    formObj.frdt.focus();
                    return false;
                }
                if ( formObj.todt.value == "" ) {
                    ComShowCodeMessage('DMT00102', "To date");
                    formObj.todt.focus();
                    return false;
                }
                if( document.form.todt.value.length==10 ){
                    var xDayTerm = ComGetDaysBetween ( document.form.frdt.value , document.form.todt.value );
                    if( xDayTerm < 0 || xDayTerm > 30 ){
                        ComShowCodeMessage("DMT00162","1 month ");
                        ComSetFocus(document.form.frdt);
                        return false;
                    }
                }
                ComChkObjValid(obj);
            }
            
            if ( formObj.dayVvdR[1].checked ) {
                if ( formObj.vvdc.value == "" ) {
                    ComShowCodeMessage('DMT00102', "VVD code");
                    formObj.vvdc.focus();
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
     
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대+숫자 
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "engup2":
                // 영문대+숫자+예외문자
                DmtComKeyOnlyAlphabet('uppernum', ',');
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
    
    // VL, VD 변경시 GRID HEADER TEXT 변경
    function obj_change() {
        obj = event.srcElement;
        if (obj.name == "mvmt") {
            if (obj.value == "VL") {
                document.form.type.value = "DMOF, CTOC";
            } else {
                document.form.type.value = "DMIF, CTIC";
            }
            initSheet( sheetObjects[0] , 0 );
        }
    }

    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {

    }    
    
    function obj_keyup() {
        var srcObj = event.srcElement;
        var tRHQ = document.form.h_rhq_off.value;
//        if ( tRHQ == "SELHO" ) {
//            checkLocYdCd(srcObj);
//        } else {
//            checkLocYdCd2(srcObj,tRHQ);
//        }
        
        checkLocYdCd(srcObj);
    }
    
    function checkLocYdCd(srcObj) {
        var formObj = document.form;
        var cd = ComTrim(ComGetObjValue(srcObj));
        
        if (cd.length == 5) {
            doActionIBCombo(sheetObjects[0], formObj, COMMAND07, srcObj);
            /*
            if ( document.form.dayVvdR[0].checked ) {
                ComSetFocus(formObj.frdt);
            } else {
                ComSetFocus(formObj.vvdc);
            }*/  
        }
    }
    
    function checkLocYdCd2(srcObj,tRHQ) {
        var formObj = document.form;
        var cd = ComTrim(ComGetObjValue(srcObj));
        
        if (cd.length == 5) {
            //doActionIBCombo2(sheetObjects[0], formObj, COMMAND16, srcObj,tRHQ);
            doActionIBCombo2(sheetObjects[0], formObj, COMMAND07, srcObj,tRHQ);
            if ( document.form.dayVvdR[0].checked ) {
                ComSetFocus(formObj.frdt);
            } else {
                ComSetFocus(formObj.vvdc);
            }
        }
    }
    
    function doActionIBCombo(sheetObj, formObj, formCmd, srcObj) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        formObj.f_cmd.value = formCmd;
        formObj.loc_cd.value = formObj.port.value;
        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var comboDatas;
        comboDatas = ComGetEtcData(sXml, "LOC_CD");
        
        if (comboDatas != undefined && comboDatas != '') {
        	var usrRhqOfcCd = ComGetObjValue(form.h_rhq_off);
        	if(usrRhqOfcCd != 'SELHO') {
        		var locRhqCd = ComGetEtcData(sXml, "LOC_RHQ_CD");
        		if(usrRhqOfcCd != locRhqCd) {
					ComShowCodeMessage('DMT01129');
					formObj.port.value = "";
		            formObj.loc_cd.value = "";
		            srcObj.focus();
				}
        	}
        } else {	
            ComShowCodeMessage('DMT00110', "Location");
            formObj.port.value = "";
            formObj.loc_cd.value = "";
            srcObj.focus();
        }
        sheetObj.WaitImageVisible = true;
    }
    
    function doActionIBCombo2(sheetObj, formObj, formCmd, srcObj,tRHQ) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        formObj.f_cmd.value = formCmd;
        formObj.loc_cd.value = formObj.port.value;
        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var comboDatas;
        comboDatas = ComGetEtcData(sXml, "LOC_CD");
        
        if ( tRHQ != comboDatas ) {
            ComShowCodeMessage('DMT01129');
            formObj.port.value = "";
            formObj.loc_cd.value = "";
            formObj.port.focus();
        } else {
            checkLocYdCd(srcObj);
        }
        sheetObj.WaitImageVisible = true;
    }
    
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        var formObj = document.form;
        
        if ( ( obj.name == 'frdt' || obj.name == 'todt' ) && formObj.frdt.value != "" && formObj.todt.value != "" ) {
            ComChkObjValid(obj);

        } /*else if(obj.name == 'port'){
        	if(obj.value.length > 0 && obj.value.length < 5) {
	 			ComShowCodeMessage('DMT00110', 'Location');
	 			formObj.port.value = "";
	            formObj.loc_cd.value = "";
	            obj.focus();
        	}
        }*/
    }
    
    function dayVvdR_click(){
        if ( document.form.dayVvdR[0].checked  ) {
            document.getElementById("vvdc").className = "input2";
            document.getElementById("frdt").className = "input1";
            document.getElementById("todt").className = "input1";
            document.form.vvdc.value = "";
            document.form.vvdc.readOnly = true;
            document.form.frdt.readOnly = false;
            document.form.todt.readOnly = false;
//            var data = getDefaultDate(set_day).split("|");
//            document.form.frdt.value = data[1];
//            document.form.todt.value = data[0];

            //Period Date 초기화
			//사용자 Office 의 현재 날짜를 조회한다.
			var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], document.form);
			var fmMvmtDt = ComGetDateAdd(document.form.ofcCurrDate, "D", -30);
			var toMvmtDt = ofcCurrDate;
			ComSetObjValue(document.form.frdt, fmMvmtDt);
			ComSetObjValue(document.form.todt, toMvmtDt); 	
        } else {
            document.getElementById("vvdc").className = "input1";
            document.getElementById("frdt").className = "input2";
            document.getElementById("todt").className = "input2";
            document.form.vvdc.readOnly = false;
            document.form.frdt.readOnly = true;
            document.form.todt.readOnly = true;
            document.form.frdt.value = "";
            document.form.todt.value = "";
        }
    }
    
    function obj_focus() {
        ComClearSeparator(event.srcElement);
        ComSetFocus(event.srcElement);
    }
    
    function chkToDateWeekBlur(){
        var period = "M";
        var toDate = document.form.todt.value;
        var frDate = document.form.frdt.value;

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
            if(retMonth>=6 ){
                if(event.srcElement.name == "todt"){
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
                ComShowCodeMessage("DMT01100");
                document.getElementById("frdt").value = "";
                document.getElementById("todt").value = "";
                ComSetFocus(document.getElementById("frdt"));
                return;
            }
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
    
function form_keyup() {
    var obj = null;
    var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
            : event.charCode;
    if (keyValue != 13) {
        //ComKeyEnter('lengthnextfocus');
    } else {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

/*
    function keyPress() {
        var eventKey = window.event.keyCode ;
            if( eventKey == 13 ) {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    document.onkeypress = keyPress ;
    */

    function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
        if(KeyCode == 13){
            var formObject = document.form;                 
            if (SheetObj.RowCount > 0){
                doActionIBSheet(SheetObj,formObject,IBSEARCH);
            }               
        }
    }    
	/* 개발자 작업  끝 */