/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4006.js
*@FileTitle : Manual Invoice Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.08.28 mun jung cheol
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
     * @class ui_dmt_4006 : ui_dmt_4006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_dmt_4006() {
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
                        var cal = new ComCalendarFromTo();
                        cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
                break;
            
                case "btn_downexcel":
                    sheetObjects[0].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'Check','',false,'',true);
                break;

                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;

                case "btn_new":
                    var formObj = document.form;
                    ComResetAll();
                    DmtComSetClassManyObjects('input1', formObj.fm_dt, formObj.to_dt);
                            
                    var ofcCurrDate = DmtComOfficeCurrDate(sheetObject1, formObject);
                    
                    // 조회기간(Period) 설정
                    //=========================================================================================
                    // 변경일자 : 2017.10.16 
                    // 변경내용 : Period 를 12개월로 변경함.
                    // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
                    //==========================================================================================                 
                    var fmDt = ComGetDateAdd(ofcCurrDate, "M", -1 * REPORT_INQUIRY_PERIOD);
                    var toDt = ofcCurrDate;
                    ComSetObjValue(formObj.fm_dt, fmDt);
                    ComSetObjValue(formObj.to_dt, toDt);
                    
                    ofc_rdo_flg_click();
                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                    comboObjects[1].Code = "All";
                break;

                case "btn_minimize":
                    var schCondDiv = document.getElementById("sch_cond_div");
                    if(schCondDiv.style.display == 'block') {   // 조건 선택부분 보임 상태
                        schCondDiv.style.display = 'none';
                        sheetObjects[0].style.height = 500;
                    } else {
                        schCondDiv.style.display = 'block';
                        sheetObjects[0].style.height = 405;
                    }
                break;

                case "btn_detatil":
                    doProcessPopup(srcName);
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

    // 팝업 처리
    function doProcessPopup(srcName) {
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var sUrl = '';
        var sWidth   = '';
        var sHeight  = '';
        
        with(sheetObj) {
            switch(srcName) {
                case 'btn_detatil':
                    
                    if(CheckedRows("Check") == 0) {
                        ComShowCodeMessage('COM12114', 'Manual Invoice');
                        return;
                    }
                    
                    var chkCnt = 0;
                    var chkRows = FindCheckedRow("Check").split("|");
                    
                    var prevOfcCd = CellValue(chkRows[0], "office");
                    var chkRsnCd = '';
                    var chkCurCd = '';
                    
                    for(var i=0; i < chkRows.length-1; i++) {
                        var currOfcCd = CellValue(chkRows[i], "office");
                        
                        // 한 Office 에 대해서만 복수건 선택가능(서로 다른 Office의 항목이 선택되었는지 체크)
                        if(currOfcCd != prevOfcCd) {
                            ComShowCodeMessage('DMT01066');
                            return;
                        }
                        
                        var rsnCd = CellValue(chkRows[i], "reasonn");
                        chkRsnCd += ',' + rsnCd; 
                        var curCd = CellValue(chkRows[i], "cur");
                        chkCurCd += ',' + curCd; 
                    }
                    
                    var fmdt = formObj.fm_dt.value;
                    var todt = formObj.to_dt.value;
                    var ofcflg = ComGetObjValue(formObj.ofc_rdo_flg);
                    
                    var paramVal =  '?fmdt='+fmdt+'&todt='+todt+'&ofcflg='+ofcflg+'&office='+prevOfcCd+'&reason='+chkRsnCd+'&selcur='+chkCurCd+'&issoff=&jspno=4006';
                    
                    sUrl    = 'EES_DMT_4007.do' + paramVal;
                break;
            }
        }
        ComOpenPopupWithTarget( sUrl , 905 , 600 , "" , "0,1,1,1,1,1,1" , true );
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
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBMultiCombo초기화 
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }

        //html컨트롤 이벤트초기화
        initControl();
        var formObj = document.form;
        
        DmtComSetClassManyObjects('input1', formObj.fm_dt, formObj.to_dt);
                
        var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
                
        // 조회기간(Period) 설정
        //==================================================================
        // 변경일자 : 2017.7.24  
        // 변경내용 : Period 를 3개월로 변경함.
        // 변경사유 : CSR #1613 [DMT] Report 메뉴 내 조회 기능 개선 요청
        //==================================================================
        var fmDt = ComGetDateAdd(ofcCurrDate, "M", -3);
        var toDt = ofcCurrDate;
        ComSetObjValue(formObj.fm_dt, fmDt);
        ComSetObjValue(formObj.to_dt, toDt);
        
        ofc_rdo_flg_click();
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
        comboObjects[1].Code = "All";
    }

   // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListener('blur',  'obj_blur', 'to_mvmt_mon', 'fm_dt', 'to_dt');   //- 포커스 나갈때
        axon_event.addListener('focus', 'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt');  //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('click', 'ofc_rdo_flg_click', 'ofc_rdo_flg');        // DEM/DET Office 라디오버튼 클릭시
        axon_event.addListener('click', 'dt_flg_click', 'dt_flg');          // Date 라디오버튼 클릭시
        axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');    // 'Incl. CNTR Column' CheckBox 클릭시
    }
     
    // DEM/DET Office Radio Button 클릭 이벤트 처리
    function ofc_rdo_flg_click() {
        var formObj = document.form;
        var ofcFlg = ComGetObjValue(formObj.ofc_rdo_flg);
        var comboObj = comboObjects[0];
        
        if(ofcFlg == 'R') {
            // RHQ
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
            ComEnableObject(formObj.chk_sub_ofc, false);
            ComEnableObject(formObj.office, false);
            ComClearObject(formObj.chk_sub_ofc);
            
            // RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
            var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
            if(usrRhqOfcCd == 'SELHO')
                usrRhqOfcCd = "All";
            else
                comboObj.Enable = false;
                
            ComSetObjValue(comboObj, usrRhqOfcCd);
            formObj.grpbyor.disabled = false;
        } else {
            // Office
            comboObj.Enable = true;
            doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            ComEnableObject(formObj.chk_sub_ofc, true);
            formObj.grpbyor.disabled = true;
            formObj.grpbyor.value = "0";
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
            /*
            case "engup":
                // 영문대+숫자 
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            */
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

    	 if (formObj.chk_sub_ofc.checked) { // Sub Office 포함
	          if (ComIsEmpty(comboObjects[0].Code)) {
	              ComShowCodeMessage('COM12113', "DEM/DET Office");
	              formObj.chk_sub_ofc.checked = false;
	              return;
	          }
	
	          formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
	          formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
	          doActionIBCombo( sheetObjects[0] , formObj , comboObjects[0] , IBSEARCH_ASYNC03);
	      } else {
	          ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
	      }
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
                    style.height = 414;
                    // 전체 너비 설정
                    SheetWidth = 1300;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    sheetObj.FrozenCols = 5;

                    var HeadTitle  = " ||Seq.|Office|Reason for Manual Invoice|TTL INV Q'TY|Cur.|TTL Billing AMT|DMIF|DMIF|DTIC|DTIC|DMOF|DMOF|DTOC|DTOC|CTIC|CTIC|CTOC|CTOC|";
                    var HeadTitle2  = " ||Seq.|Office|Reason for Manual Invoice|TTL INV Q'TY|Cur.|TTL Billing AMT|INV|AMT|INV|AMT|INV|AMT|INV|AMT|INV|AMT|INV|AMT|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus ,   0 , daCenter , true  , "Status"                                                 );
                    InitDataProperty( 0 , cnt++ , dtCheckBox     ,  30 , daCenter , true  , "Check"     , false , "" , dfNone    , 0 , true  , false );
                    InitDataProperty( 0 , cnt++ , dtSeq          ,  35 , daCenter , true  , "seq"                                                    );
                    InitDataProperty( 0 , cnt++ , dtData         ,  50 , daCenter , true  , "office"    , false , "" , dfNone    , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         , 175 , daLeft   , true  , "reason"    , false , "" , dfNone    , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  90 , daRight  , true  , "ttlinvqty" , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtData         ,  40 , daCenter , true  , "cur"       , false , "" , dfNone    , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , true  , "ttlbllamt" , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  50 , daRight  , false , "dmifinv"   , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , false , "dmifamt"   , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  50 , daRight  , false , "dticinv"   , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , false , "dticamt"   , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  50 , daRight  , false , "dmofinv"   , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , false , "dmofamt"   , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  50 , daRight  , false , "dtocinv"   , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , false , "dtocamt"   , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  50 , daRight  , false , "cticinv"   , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , false , "cticamt"   , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      ,  50 , daRight  , false , "ctocinv"   , false , "" , dfInteger , 0 , false , false );
                    InitDataProperty( 0 , cnt++ , dtAutoSum      , 100 , daRight  , false , "ctocamt"   , false , "" , dfFloat   , 2 , false , false );
                    InitDataProperty( 0 , cnt++ , dtHidden       , 100 , daRight  , false , "reasonn"   , false , "" , dfNone    , 0 , false , false );
                    
//                    CountPosition = 0;
//                    ExtendLastCol  = false;
                    
                    ToolTipOption = "balloon:true;width:50;";
                    ToolTipText(0,"ttlinvqty") = "Total No. of Invoices";
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
                formObj.ofc_flg.value = ComGetObjValue(formObj.ofc_rdo_flg);
                
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch("EES_DMT_4006GS.do", FormQueryString(formObj));
                
ComOpenWait(false);

                
            break;
                
            case IBSEARCH_ASYNC01:
                
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("EES_DMT_4006GS.do", FormQueryString(formObj));
                if (sXml != undefined && sXml != '') {             
                
                    comboObjects[1].RemoveAll();
                    comboObjects[1].MultiSelect = false;
//                    comboObjects[1].SetColWidth("45");
                    comboObjects[1].ValidChar(2);   // 영대문자만 사용
                    //MaxLength = 6;
                
                    var data = ComGetEtcData(sXml, "reasoncd");
                    var data2 = data.split("^");
                    if (data2 != undefined && data2 != '') {
                        comboObjects[1].InsertItem(0, "All", "All");
                        for (var i18 = 0 ; i18 < data2.length-1 ; i18++) {
                            var comboItems = data2[i18].split("||");
                            comboObjects[1].InsertItem(i18+1, comboItems[1], comboItems[0]);     
                        }
                    }
                }
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
            
            case "reasoncd": 
                with (comboObj) { 
                    MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left");   
                    SetColWidth("350");
                    DropHeight = 200;
//                    ColBackColor(0) = "#CCFFFD";
                    
                    ValidChar(2); // 영어대문자 사용
//                    MaxLength = 5;
                }
            break;
        }
    }
   
   
    // IBCombo 데이터 조회 및 세팅
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg = false;
         sheetObj.WaitImageVisible = false;
         
         formObj.f_cmd.value = formCmd;
         
         switch(formCmd) {
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = false;
                    SetColWidth("45");
                    ValidChar(2);   // 영대문자만 사용
                    //MaxLength = 6;
                }
            
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));                
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
            
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data = ComGetEtcData(sXml, "OFC_CD");
                
                if (data != undefined && data != '') {
                	var usrOfcCd = ComGetObjValue(formObj.h_user_office);
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
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
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
                
            case IBSEARCH_ASYNC03:      
                //3. Sub Office comboList
                formObj.f_cmd.value = COMMAND01;
                var sXml2 = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var subOfcCds = ComGetEtcData(sXml2, "OFC_CD");
                
                if (subOfcCds != undefined && subOfcCds != '') {
    	 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
					
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
                
                    var dtFlg = "P";
                    if(dtFlg == 'M') {
                        if(!ComIsDate(to_mvmt_mon, "ym")) {
                            ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Date Month'));
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
                    var ofcCd = comboObjects[0].Code;
                    if(ComIsEmpty(ofcCd)) {
                        ComShowCodeMessage('COM12113', "DEM/DET Office");
                        return false;
                    }
                    
                    ComSetObjValue(ofc_cd, ofcCd);
                    
                    break;
                
            } // switch - end
         } // with - end

         return true;
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
    
	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}


    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        with(sheetObj){
            sheetObj.ShowSubSum("office", "ttlinvqty|ttlbllamt|dmifinv|dmifamt|dticinv|dticamt|dmofinv|dmofamt|dtocinv|dtocamt|cticinv|cticamt|ctocinv|ctocamt", -1, true, false, -1, "Check=;office=%s;cur=;seq=S.TTL");
            SumText(0, "seq") = "TTL";
        }
    }
    
    // 멀티콤보 KeyDown Event Catch
    function office_OnKeyDown(comboObj, keycode, shift) {
        var formObj = document.form;
        
        if(formObj.chk_sub_ofc.checked) {
            ComShowCodeMessage('DMT00107');
        }
    }    
    
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    document.onkeypress = keyPress ;    