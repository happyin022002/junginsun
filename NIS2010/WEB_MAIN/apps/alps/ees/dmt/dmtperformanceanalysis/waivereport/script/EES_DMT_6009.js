/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6009.js
*@FileTitle : Waive Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.19 mun jung cheol
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
     * @class EES_DMT_6009 : EES_DMT_6009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6009() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        try {
            var srcObj = window.event.srcElement;
            var srcName = srcObj.getAttribute("name");

                switch(srcName) {
                
                    case "btns_calendar":
                        if(srcObj.style.cursor == "hand") {
                            var cal = new ComCalendarFromTo();
                            cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
                        }
                    break;

                    case "btn_retrieve":
                        doActionIBSheet(sheetObj,formObj,IBSEARCH);
                    break;

                    case "btn_new":
                        doInit();
                    break;

                    case "btn_minimize":
                        var schCondDiv = document.getElementById("sch_cond_div");
                        if(schCondDiv.style.display == 'block') {
                            schCondDiv.style.display = 'none';
                            sheetObj.style.height = 490;    //sheetObj.GetSheetHeight(23); //300+145;
                        } else {
                            schCondDiv.style.display = 'block';
                            sheetObj.style.height = 350;    //sheetObj.GetSheetHeight(14); //300;
                        }
                    break;

                    case "btn_downexcel":
                        //sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
                        sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', true,'','',false,'',true);
                    break;
                        
                    case "btns_ctrt_ofc":
                        var ofcFlg = ComGetObjValue(formObj.ofc_flg2);
                        if ( ofcFlg == "O" ) {                        
                            ComOpenPopup('COM_ENS_071.do', 770, 470, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
                        }
                    break;

                    case "btn_detail":
                            document.form.slcttrfcd.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "tariff" );
                            document.form.slctscno .value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "scno" );
                            document.form.slctrfano.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "rfano" );
                            document.form.slctofccd.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "office" );
                            document.form.curr_flg2.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "localcur" );                            
                            var param = "?fm_dt="     + formObj.start_dt.value  +
                                        "&to_dt="     + formObj.end_dt.value    +
                                        "&slctofccd=" + formObj.slctofccd.value +
                                        "&reqapp="    + formObj.reqapp.value    +
                                        "&ofc_flg2="  + ComGetObjValue(formObj.ofc_flg2)    +
                                        "&ofc_cd2="  + ComGetObjValue(formObj.ofc_cd2)    +
                                        "&slctTrfCd=" + formObj.slcttrfcd.value +
                                        "&slctScNo="  + formObj.slctscno.value  +
                                        "&curr_flg="  + formObj.curr_flg2.value  +
                                        "&dmdt_cntr_tp_cd="  + formObj.dmdt_cntr_tp_cd.value  +
                                        "&slctRfaNo=" + formObj.slctrfano.value ;
                            ComOpenPopup( "/hanjin/EES_DMT_6010.do"+param , 905, 485 , "" , "1,0,1,1,1,1,1,1" , true );

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

    function getCtrtOfcCd(aryPopupData) {
        document.form.ofc_cd2.value = aryPopupData[0][3];
        
        var ofcFlg = ComGetObjValue(document.form.ofc_flg2);
        if ( ofcFlg == "R" ) {
            ComboObjects[1].Code = aryPopupData[0][3];
        } else if ( ofcFlg == "O" ) {
            document.form.location.value = aryPopupData[0][3];
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

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBMultiCombo초기화 
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();
        

        ComBtnDisable("btn_downexcel");
        ComBtnDisable("btn_detail");
        
        document.form.slctofccd.value = "";
        document.form.location.value = document.form.usr_ofc_cd.value; 
    }
    
    
    // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListener('blur',  'obj_blur', 'to_mvmt_mon', 'fm_dt', 'to_dt'); //- 포커스 나갈때
        axon_event.addListener('focus', 'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt'); //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
        axon_event.addListenerFormat('keypress','keyPress', document.form); //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
        axon_event.addListener('click', 'ofc_flg2_click', 'ofc_flg2');
        axon_event.addListener('click', 'dt_flg_click', 'dt_flg');
        axon_event.addListener('change', 'reqapp_change', 'reqapp');
    }
    
    
	// BKG No, BL No 입력값의  Validation을 처리하기 위한 이벤트 함수
	function reqapp_change() {
		//var obj = event.srcElement;
		var formObj = document.form;
		var obj = formObj.reqapp;
		
		if(ComGetObjValue(obj) == 'A') {	// (A: Approval / R: Request)
			if(ComGetObjValue(formObj.ofc_flg2) == 'O') {
				ComSetObjValue(formObj.ofc_flg2, "R");
				ofc_flg2_click();
			}
			ComEnableObject(formObj.ofc_flg2[1], false);
		} else {
			ComEnableObject(formObj.ofc_flg2[1], true);
		}
	}
    
    
    // 화면 초기화 설정
    function doInit() {
        var formObj = document.form;
        
        ComResetAll();
        
        // To MVMT Date 검색 조건 초기화
        dt_flg_click();
        
        // DEM/DET Office 검색 조건 초기화 (Default: RHQ)
        if(formObj.ofc_flg2[1].disabled)
        	ComEnableObject(formObj.ofc_flg2[1], true);
        
        ofc_flg2_click();
        ofc_flg_click();
        
        document.form.slctofccd.value = "";
        document.form.location.value = document.form.usr_ofc_cd.value; 
    }
    
    function dt_flg_click() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        
        with(formObj) {
            var dtFlg = ComGetObjValue(dt_flg);
            var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
            
            if(dtFlg == 'M') {
                ComEnableObject(to_mvmt_mon, true);
                ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
                DmtComSetClassManyObjects('input1', to_mvmt_mon);
                DmtComSetClassManyObjects('input2', fm_dt, to_dt);
                
                //ComSetObjValue(to_mvmt_mon, ComGetNowInfo("ym"));
    	 		ComSetObjValue(to_mvmt_mon, ofcCurrDate.substring(0, 7));
                ComClearManyObjects(fm_dt, to_dt);
            } else {
                ComEnableObject(to_mvmt_mon, false);
                ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
                DmtComSetClassManyObjects('input1', fm_dt, to_dt);
                DmtComSetClassManyObjects('input2', to_mvmt_mon);
                
                // 조회기간(Period) 설정
                //=========================================================================================
                // 변경일자 : 2017.10.16 
                // 변경내용 : Period 를 12개월로 변경함.
                // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
                //==========================================================================================                
                var fmDt = ComGetDateAdd(ofcCurrDate, "M", -1 * REPORT_INQUIRY_PERIOD);
                var toDt = ofcCurrDate;
                ComSetObjValue(fm_dt, fmDt);
                ComSetObjValue(to_dt, toDt);
                
                ComClearManyObjects(to_mvmt_mon);
            }
        } // with-end
    }
    
    
    // DEM/DET Office Radio Button 클릭 이벤트 처리
    function ofc_flg_click() {
        var formObj = document.form;
        var ofcFlg = ComGetObjValue(formObj.ofc_flg);
        var comboObj = comboObjects[2];
        
        if(ofcFlg == 'R') {
            // RHQ
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
            ComEnableObject(formObj.chk_sub_ofc, false);
            ComClearObject(formObj.chk_sub_ofc);
            
            // RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
            var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
            if(usrRhqOfcCd == 'SELHO')
                usrRhqOfcCd = "All";
            
            ComSetObjValue(comboObj, usrRhqOfcCd);
        } else {
            // Office
            doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            ComEnableObject(formObj.chk_sub_ofc, true);
        }
    }
    
    // DEM/DET Office Radio Button 클릭 이벤트 처리
    function ofc_flg2_click() {
        var formObj = document.form;
        var ofcFlg = ComGetObjValue(formObj.ofc_flg2);
        var comboObj = comboObjects[1];
        
        if(ofcFlg == 'R') {
            div_ofc2_txt.style.display = "none";
            div_ofc2_com.style.display = "";            
            // RHQ
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
            ComBtnDisable("btns_ctrt_ofc");
            
            // RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
            var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
            if(usrRhqOfcCd == 'SELHO')
                usrRhqOfcCd = "All";
            
            ComSetObjValue(comboObj, usrRhqOfcCd);
            document.form.location.value = "";
            document.form.grp_flg.disabled = false;
            ComEnableManyObjects(false, document.form.tempuser, document.form.btns_ctrt_ofc);
        } else {
            // Office
            div_ofc2_txt.style.display = "";
            div_ofc2_com.style.display = "none";            
//            doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            ComBtnEnable("btns_ctrt_ofc");
            comboObjects[1].Code = -1;
//            ComEnableObject(formObj.chk_sub_ofc, true);
            document.form.grp_flg.disabled = true;
            document.form.grp_flg.value = "O";
            ComEnableManyObjects(true, document.form.tempuser, document.form.btns_ctrt_ofc);
            document.form.location.value = document.form.usr_ofc_cd.value; 
        }
    }
     
    //포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        ComChkObjValid(obj);
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

    
    /*
     * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
     */
    function doInclSubOfc() {
        var formObj = document.form;
        var comboObj = comboObjects[2];
        
        if(formObj.chk_sub_ofc.checked) {   // Sub Office 포함
            if( ComIsEmpty(comboObj.Code) ) {
                ComShowCodeMessage('COM12113', "Office");
                formObj.chk_sub_ofc.checked = false;
                return;
            }
            formObj.ofc_cd.value = ComGetObjValue(comboObj);
            formObj.tmp_ofc_cd.value = ComGetObjValue(comboObj);
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
            
        } else {
            ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
        }
    }

    // 멀티콤보 KeyDown Event Catch
    function office_OnKeyDown(comboObj, keycode, shift) {
        var formObj = document.form;
        
        if(formObj.chk_sub_ofc.checked) {
            ComShowCodeMessage('DMT00107');
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
                    style.height = 350;
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
                    
                    var HeadTitle1 = "||Seq.|Request|Tariff|S/C No.|RFA No.|Customer|Customer|Cur.|Incurred|Incurred|CMDT Exception|CMDT Exception|Exception(A)|Exception(A)|Discount(B)|Discount(B)|Waived Total(A+B)|Waived Total(A+B)|Waived Total(A+B)";
                    var HeadTitle2 = "||Seq.|Request|Tariff|S/C No.|RFA No.|Code|Name|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|vs. Incurred";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true); 
                    
                    var avgLine = "Trunc ( ( ( |amt5| / |amt1| ) * 100 ), 2 )";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHidden ,  35 , daCenter , true , "chk"      , false , ""      , dfNone        , 0                 );
                    InitDataProperty( 0 , cnt++ , dtHidden     ,  40 , daCenter , true , "localcur" , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtSeq        ,  35 , daCenter , true , "seq"                                                            );
                    InitDataProperty( 0 , cnt++ , dtData       ,  80 , daCenter , true , "office"   , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData       ,  50 , daCenter , true , "tariff"   , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData       ,  90 , daCenter , true , "scno"     , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData       , 100 , daCenter , true , "rfano"    , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData       ,  60 , daLeft   , true , "cuscode"  , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData       , 180 , daLeft   , true , "cusname"  , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData       ,  40 , daCenter , true , "cur"      , false , ""      , dfNone        , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    ,  45 , daRight  , true , "cntr1"    , false , ""      , dfNullInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    , 100 , daRight  , true , "amt1"     , false , ""      , dfNullFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    ,  45 , daRight  , true , "cntr2"    , false , ""      , dfNullInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    , 100 , daRight  , true , "amt2"     , false , ""      , dfNullFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    ,  45 , daRight  , true , "cntr3"    , false , ""      , dfNullInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    , 100 , daRight  , true , "amt3"     , false , ""      , dfNullFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    ,  45 , daRight  , true , "cntr4"    , false , ""      , dfNullInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    , 100 , daRight  , true , "amt4"     , false , ""      , dfNullFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    ,  45 , daRight  , true , "cntr5"    , false , ""      , dfNullInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    , 100 , daRight  , true , "amt5"     , false , ""      , dfNullFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum    , 100 , daRight  , true , "incurred" , false , avgLine , dfNullFloat   , 2 , false , false );
                    
                    ExtendLastCol  = false;
                    sheetObj.FrozenCols = 6;
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
                
                var sXml = sheetObj.GetSearchXml("EES_DMT_6009GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchXml(sXml);                
                
                ComOpenWait(false);
                break;
    
             case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                break;
    
            case IBINSERT:      // 입력
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
                    
                    //ValidChar(2); // 영어대문자 사용
                    //MaxLength = 6;
                }
                break;
                
            case "office2": 
                with (comboObj) { 
                    //MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left");
                    DropHeight = 160;
                    ColBackColor(0) = "#CCFFFD";
                    
                    //ValidChar(2); // 영어대문자 사용
                    //MaxLength = 6;
                }
                break;
                
            case "tariff_type":
                with (comboObj) { 
                    MultiSelect = true;
                    SetColAlign("left");        
                    SetColWidth("45");
                    DropHeight = 160;
                    ColBackColor(0) = "#CCFFFD";
                }
                break; 
                
            case "cntr_type":
                with (comboObj) { 
                    MultiSelect = false;
                    SetColAlign("left");        
                    SetColWidth("45");
                    DropHeight = 160;
                    //ColBackColor(0) = "#CCFFFD";
                }
                
                comboObj.InsertItem(0, "All",       "A");
                comboObj.InsertItem(1, "Dry",       "D");
                comboObj.InsertItem(2, "Reefer",    "R");
                comboObj.InsertItem(3, "Special",   "S");
                comboObjects[3].Code = "A";
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
            case SEARCHLIST:    // tariff type
                var data = ComGetEtcData(sXml, "common_tariff_cd");
                if (data != undefined && data != '') {
                    comboObj.InsertItem(0, "All", "All");
                    var comboItems = data.split("|");
                    
                    for(var i=0; i < comboItems.length; i++) {
                        var item = comboItems[i].split("=");
                        comboObj.InsertItem(i+1, item[0], item[0]);
                    }
                }
                break;
            
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
                	var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
 					var idx = 0;
 					
 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx = 1;
 					}
 					
 		    	    var comboItems = data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
 	    	  		
 	    	  		// 로그인 User Office를 Default로 설정
	    	  		comboObj.Code = usrOfcCd;
                }
                break;
                
            case COMMAND01: // Incl. Sub Office
	            var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	    	 	
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
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
                    
                    var dtFlg = ComGetObjValue(dt_flg);
                    if(dtFlg == 'M') {
                        if(!ComIsDate(to_mvmt_mon, "ym")) {
                            ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'To MVMT Date Month'));
                            return false;
                        }
                        
                        var toMvmtMon = ComGetUnMaskedValue(to_mvmt_mon, 'ym');
                        var lastDay = ComGetLastDay(ComParseInt(toMvmtMon.substring(0, 4)), ComParseInt(toMvmtMon.substring(4)));
                        var startDt = toMvmtMon + '01';
                        var endDt = toMvmtMon + '' + lastDay;
                        
                        ComSetObjValue(start_dt, startDt);
                        ComSetObjValue(end_dt, endDt);
                        
                    } else {
                        if(!ComIsDate(fm_dt)) {
                            ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
                            return false;
                        }
                        if(!ComIsDate(to_dt)) {
                            ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
                            return false;
                        }
                        
                        var startDt = ComGetUnMaskedValue(fm_dt, 'ymd');
                        var endDt = ComGetUnMaskedValue(to_dt, 'ymd');
                        /*
                        ComChkPeriod(fromDate, toDate)
                        0 : fromDate > toDate
                        1 : fromDate < toDate
                        2 : fromDate = toDate
                        */
                        // 기간체크
                        if (ComChkPeriod(startDt, endDt) == 0) {
                            ComShowCodeMessage("DMT01020");
                            return false;
                        }
                        
	                      //=========================================================================================
	                     // 변경일자 : 2017.10.16 
	                     // 변경내용 : Period 를 12개월로 변경함.
	                     // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
	                     //==========================================================================================                                               
                        var limitDt = ComGetDateAdd(startDt, "M", REPORT_INQUIRY_PERIOD);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", REPORT_INQUIRY_PERIOD + " month");
                        	return false;
                        }
                        
                        ComSetObjValue(start_dt, startDt);
                        ComSetObjValue(end_dt, endDt);
                    }
                    
                    // DEM/DET Office
                    var ofcFlg = ComGetObjValue(formObj.ofc_flg2);
                    if ( ofcFlg == "R" ) {
                        var ofcCd2 = comboObjects[1].Code;
                        if(ComIsEmpty(ofcCd2)) {
                            ComShowCodeMessage('COM12113', "Waive Office");
                            return false;
                        }
                        ComSetObjValue(ofc_cd2, ofcCd2);
                    } else if ( ofcFlg == "O" ) {
                        var ofcCd2 = document.form.location.value;
                        if(ComIsEmpty(ofcCd2)) {
                            ComShowCodeMessage('COM12113', "Waive Office");
                            return false;
                        }
                        ComSetObjValue(ofc_cd2, ofcCd2);
                    }

                    var ofcCd = comboObjects[2].Code;
                    if(ComIsEmpty(ofcCd)) {
                        ComShowCodeMessage('COM12113', "DEM/DET Office");
                        return false;
                    }
                    
                    ComSetObjValue(ofc_cd, ofcCd);
                    
                    // Tariff Type
                    var trfCd = comboObjects[0].Code;
                    if(ComIsEmpty(trfCd)) {
                        ComShowCodeMessage('COM12113', "Tariff Type");
                        return false;
                    }
                    
                    // 전체선택이면, 'All'값을 제거해서 보냄.(DBDAO 내부로직 필요상)
                    if(trfCd.indexOf('All') != -1)
                        trfCd = ComReplaceStr(trfCd, "All,", "");
                        
                    ComSetObjValue(dmdt_trf_cd, trfCd);
            
                    
                    // CNTR Type
                    var cntrType2 = comboObjects[3].Code;
                    if(ComIsEmpty(cntrType2)) {
                        ComShowCodeMessage('COM12113', "CNTR Type");
                        return false;
                    }
                    
                    // 전체선택이면, 전송할 Code값을 'A'로 설정. 나머지 경우는 그대로 보냄.(DBDAO 내부로직 필요상)
//                    if(cntrType == 'A')
//                        cntrType = "D,R,S";
                    
                    ComSetObjValue(dmdt_cntr_tp_cd, cntrType2);
                    break;
                    
            } // switch - end
        } // with(formObj) - end

        return true;
    }
    
    
    /*
     * 각 팝업 호출 처리
     */
    function doProcessPopup(srcName) {
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var sUrl     = '';
        var sWidth   = '';
        var sHeight  = '';
        var paramVal = '';
        
        with(sheetObj) {
            if(CheckedRows("chk") == 0) {
                ComShowCodeMessage('COM12114', 'Detail Charge');
                return;
            }
            
            var chkCnt = 0;
            var chkRows = FindCheckedRow("chk").split("|");
            
            var prevOfcCd = CellValue(chkRows[0], "ofc_cd");
            var chkTrfCd = '';
            
            for(var i=0; i < chkRows.length-1; i++) {
                var currOfcCd = CellValue(chkRows[i], "ofc_cd");
                
                // 한 Office 에 대해서만 복수건 선택가능(서로 다른 Office의 항목이 선택되었는지 체크)
                if(currOfcCd != prevOfcCd) {
                    ComShowCodeMessage('DMT01066');
                    return;
                }
                
                var trfCd = CellValue(chkRows[i], "dmdt_trf_cd");
                chkTrfCd += ',' + trfCd; 
            }
            
            chkTrfCd = chkTrfCd.substring(1);
            
            var startDt = ComGetObjValue(formObj.start_dt);
            var endDt   = ComGetObjValue(formObj.end_dt);
            var grpFlg  = ComGetObjValue(formObj.grp_flg);
            var cntrTp  = ComGetObjValue(formObj.dmdt_cntr_tp_cd);

            paramVal = "?start_dt=" + startDt + "&end_dt=" + endDt + "&grp_flg=" + grpFlg
                        + "&ofc_cd=" + prevOfcCd + "&dmdt_trf_cd=" + chkTrfCd + "&dmdt_cntr_tp_cd=" + cntrTp;
            
            var dtlFlg = '';
            
            switch(srcName) {
                case 'btn_Detail':
                    break;
                    
                case 'btn_DetailA':
                    dtlFlg = 'A';
                    break;
                    
                case 'btn_DetailB':
                    dtlFlg = 'B';
                    break;
                    
                case 'btn_DetailC':
                    dtlFlg = 'C';
                    break;
            }
        }
        
        sUrl    = 'EES_DMT_6002.do' + paramVal + "&dtl_flg=" + dtlFlg;
        sWidth  = '1020';
        sHeight = '567';
        
        var sWinName = ComReplaceStr(sUrl, '.do', '');
        ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
    }

     
    // Office IBMultiCombo 초기화
    function initComboValue_tariff_type() {
        ComSetObjValue(comboObjects[0], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
    }
    
    
    // CNTR Type IBMultiCombo 초기화
    function initComboValue_cntr_type() {
        ComSetObjValue(comboObjects[2], "A");
    }
    
    
    // 'Incl. Sub Office' 체크박스가 체크된 상태에서  Office 멀티콤보를 선택하지 못하도록 한다.
    function office_OnCheckClick(comboObj, index, code) {
        var formObj = document.form;
        
        if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
    }
    

    //Tariff Type IBMultiCombo 클릭 이벤트 처리
    function tariff_type_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else if(comboObj.CheckIndex(0)) {
            comboObj.CheckIndex(0) = false;
        } else if(comboObj.Code == 'DMIF,DTIC,DMOF,DTOC,CTIC,CTOC') {
            comboObj.CheckIndex(0) = true;
        }
    }
    
    
    // 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
    function sheet1_OnLoadFinish() {
        var formObj = document.form
        sheetObjects[0].WaitImageVisible = false;

        // Tariff Type MultiCombo List조회
        doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);
        
        //OPEN화면 호출
        doInit();
        sheetObjects[0].WaitImageVisible = true;   
    } 
    
    function sheet1_OnBeforeCheck( sheetObj , Row , Col ) {
        
        with (sheetObj) {
            if ( Row > 1 && Col == 0 ) {
                var tCntChkd = 0;
                for ( var x = 2 ; x < LastRow ; x++ ) {
                    if ( CellValue( x , 0 ) == 1 ) {
                        tCntChkd++;
                    }
                }
                
                if ( tCntChkd == 0 ) {
                    document.form.slctofccd.value = "";
                }
                var tSlctOfcCd = document.form.slctofccd.value;
                if ( tSlctOfcCd == '' ) {
                    
                    document.form.slctofccd.value = CellText( Row , "office" );
                    
                } else {
                    
                    if ( tSlctOfcCd != CellText( Row , "office" ) ) {
                        ComShowCodeMessage('DMT01066');
                        AllowCheck = false;
                    }
                    
                }

            }
            
        }
        
    }
    

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
        with(sheetObj)
        {
            sheetObj.ShowSubSum("office", "cntr1|amt1|cntr2|amt2|cntr3|amt3|cntr4|amt4|cntr5|amt5", -1, true, false, -1, "chk=;office=%s;tariff=;cur=;seq=S.TTL;incurred=Trunc(((|amt5|/|amt1|)*100),2)");
            sheetObj.ShowSubSum("tariff", "cntr1|amt1|cntr2|amt2|cntr3|amt3|cntr4|amt4|cntr5|amt5", -1, true, false, -1, "chk=;office=%s;tariff=%s;cur=;seq=S.TTL;incurred=Trunc(((|amt5|/|amt1|)*100),2)");            
            SumText(0, "seq") = "TTL";

            if ( RowCount <= 0 ) {
                ComBtnDisable("btn_downexcel");
                ComBtnDisable("btn_detail");
                return; 
            }            
            
            if ( ComGetObjValue(document.form.reqapp) == "R" ) {
                CellValue2(0,3) = "Request";
                CellValue2(1,3) = "Request";
            } else {
                CellValue2(0,3) = "Approval";
                CellValue2(1,3) = "Approval";
            }
            
            for ( var x = 2 ; x < LastRow ; x++ ) {
                var tCVAL = CellValue(x,LastCol);
                p = tCVAL.split(".");
                p[0] = ComAddComma(p[0]);
                if ( p.length == 1 ) {
                    CellText(x,LastCol) =  p[0]+".00%";
                } else if (p.length == 2) {
                    if ( p[1].length == 1 ) {
                        CellText(x,LastCol) =  p[0]+"."+p[1]+"0%";                                
                    } else {
                        CellText(x,LastCol) =  p[0]+"."+p[1]+"%";
                    }
                } else {
                    CellText(x,LastCol) =  "";
                }                    
            }
            SumValue(0,LastCol) = DmtAddComma( ComRound ( SumValue(0,"amt5") / SumValue(0,"amt1") * 100 ) + "" , "#,###.00");
            SumText(0,LastCol) = SumValue(0,LastCol)+"%";
            
            ComBtnEnable("btn_downexcel");
            ComBtnEnable("btn_detail");
            document.form.slctofccd.value = "";
            
            //RowMerge(row) = true;
            //CellAlign(row, "chk") = daRight;
        }
    }
    
    // 마우스가 Sheet 위에서 움직일 때 발생하는 Event
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
            var colName = ColSaveName(MouseCol);        // SaveName을 가져온다.
            var msg = "";
            switch(colName) {
            
                case "cntr1":
                case "amt1":
                    msg = "DEM/DET Incurrence per Basic Tariff";
                break;
                
                case "cntr2":
                case "amt2":
                    msg = "Exception per Commodity Exception Tariff";
                break;
                
                case "cntr3":
                case "amt3":
                    msg = "Exception per S/C Exception Tariff/Before Booking";
                break;
                
                case "cntr4":
                case "amt4":
                    msg = "Discount per After Booking";
                break;
                
                case "cntr5":
                case "amt5":
                case "incurred":
                    msg = "Exception + Discount";
                break;
                
                default:
                    msg = "";
                break;
                
            }
            ToolTipOption = "balloon:true;width:50;";
            MouseToolTipText = msg;     // ToolTip의 내용 설정
        }
    }
    
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    document.onkeypress = keyPress ;
    
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
                    var formObj = document.form;
                        document.form.slcttrfcd.value = sheetObj.CellValue( Row , "tariff" );
                        document.form.slctscno .value = sheetObj.CellValue( Row , "scno" );
                        document.form.slctrfano.value = sheetObj.CellValue( Row , "rfano" );
                        document.form.slctofccd.value = sheetObj.CellValue( Row , "office" );
                        document.form.curr_flg2.value = sheetObj.CellValue( Row , "localcur" );
                        var param = "?fm_dt="     + formObj.start_dt.value  +
                                    "&to_dt="     + formObj.end_dt.value    +
                                    "&slctofccd=" + formObj.slctofccd.value +
                                    "&reqapp="    + formObj.reqapp.value    +
                                    "&ofc_flg2="  + ComGetObjValue(formObj.ofc_flg2)    +
                                    "&ofc_cd2="  + ComGetObjValue(formObj.ofc_cd2)    +
                                    "&slctTrfCd=" + formObj.slcttrfcd.value +
                                    "&slctScNo="  + formObj.slctscno.value  +
                                    "&curr_flg="  + formObj.curr_flg2.value  +
                                    "&dmdt_cntr_tp_cd="  + formObj.dmdt_cntr_tp_cd.value  +
                                    "&slctRfaNo=" + formObj.slctrfano.value ;
                        ComOpenPopup( "/hanjin/EES_DMT_6010.do"+param , 905, 485 , "" , "1,0,1,1,1,1,1,1" , true );
        }
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
                    var formObj = document.form;
                        document.form.slcttrfcd.value = sheetObj.CellValue( Row , "tariff" );
                        document.form.slctscno .value = sheetObj.CellValue( Row , "scno" );
                        document.form.slctrfano.value = sheetObj.CellValue( Row , "rfano" );
                        document.form.slctofccd.value = sheetObj.CellValue( Row , "office" );
                        document.form.curr_flg2.value = sheetObj.CellValue( Row , "localcur" );
        }
    }
    
    /**
     * 문자열을 숫자포멧에 맞게 변경하여 리턴한다. 숫자포멧으로 설정할수 있는 값은 다음과 같다. <br>
     * sFormat="#,###"    : 천단위구분만 하는것으로 {@link #ComAddComma} 함수와 동일하다. <br>
     * sFormat="#,###.0"  : 천단위구분과 소숫점한자리를 표시한다. <br>
     * sFormat="#,###.00" : 천단위구분과 소숫점두자리를 표시한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     ret = ComAddComma2("1000", "#,###")        //결과 : "1,000"
     *     ret = ComAddComma2("1000", "#,###.0")      //결과 : "1,000.0"
     *     ret = ComAddComma2("1000", "#,###.00")     //결과 : "1,000.00"
     *     ret = ComAddComma2("1000.1", "#,###")      //결과 : "1,000.1"
     *     ret = ComAddComma2("1000.1", "#,###.0")    //결과 : "1,000.1"
     *     ret = ComAddComma2("1000.1", "#,###.00")   //결과 : "1,000.1"
     *     ret = ComAddComma2("-1,000.12", "#,###.0") //결과 : "-1,000.12"
     * </pre>
     * @param {string,object}   obj      필수,숫자문자열 또는 HTML태그(Object)
     * @param {string}          sFormat  숫자 포멧
     * @returns string, 숫자포멧이 설정된 문자열<br>
     *          "":sVal인자의 값이 잘못된 경우 공백("")을 리턴한다.
     * @see #ComAddComma
     * @see #ComGetMaskedValue
     */
    function DmtAddComma(obj,sFormat)
    {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = getArgValue(obj);

            switch(sFormat)
            {
                case "#,###" :
                        return ComAddComma(sVal);
                case "#,###.0" :
                        p = sVal.split(".");
                        p[0] = ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".0";
                        else if (p.length == 2) return p[0]+"."+p[1];
                        else return "";
                case "#,###.00" :
                        p = sVal.split(".");
                        p[0] = ComAddComma(p[0]);
                        if      (p.length == 1) {
                            return p[0]+".00";
                        } else if (p.length == 2) {
                            if ( p[1].length == 1 ) {
                                return p[0]+"."+p[1]+"0";                                
                            } else {
                                return p[0]+"."+p[1];
                            }
                        } else {
                            return "";
                        }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /* 개발자 작업  끝 */