/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0032.js
*@FileTitle : OW/LP/OL Auth creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.18 진준성
* 1.0 Creation
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
     * @class ees_lse_0032 : ees_lse_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_lse_0032() {
        this.processButtonClick = processButtonClick;
        this.setSheetObject     = setSheetObject;
        this.setComboObject     = setComboObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
        this.obj_change         = obj_change;
        this.obj_keypress       = obj_keypress;
        this.validateForm       = validateForm;
        this.loc_tp_OnChange    = loc_tp_OnChange;
        this.sheet1_OnSort      = sheet1_OnSort;
    }

/* 개발자 작업  */

// 공통전역변수
var vOrcCntrTpszCd = "";

var sheetObjects = new Array();
var sheetCnt = 0;

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

var curRow = 0;
var addColCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcObj  = window.event.srcElement;
            var srcName = window.event.srcElement.getAttribute("name");
                switch(srcName) {

                    case "Retrieve":
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;

                    case "New":
                        formObject.loc_cd.value   = "";
                        formObject.loc_tp[0].selected = true;
                        sheetObject.RemoveAll();
                        ComBtnDisable("Save");
                        formObject.loc_cd.focus();
                    break;

                    case "Save":                    	
                        if(ComIsBtnEnable("Save")){
                            if(sheetObjects[0].CheckedRows(1) > 0){
                        	    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                            }else{
                            	ComShowCodeMessage("LSE01045");
                            }
                        }
                    break;

                    case "btns_search1":   // onh_loc_cd Pop-up
                        if ( srcObj.style.filter == "" ) {
                            openPopup("1");
                        }
                    break;

                    case "btns_calendar1":
                        if ( srcObj.style.filter == "" ) {
                            var cal = new ComCalendar();
                            cal.select(formObject.start_dt, "yyyy-MM-dd");
                        }
                    break;

                    case "btns_calendar2":
                        if ( srcObj.style.filter == "" ) {
                            var cal = new ComCalendar();
                            cal.select(formObject.end_dt, "yyyy-MM-dd");
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
    function  sheet1_OnLoadFinish() {
    	/* IBMulti Combo Item Setting */
        doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
        document.form.loc_cd.focus();
    }
      
    function loadPage(){
    	for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

    	/* IBMultiCombo 초기화 */
        for ( var k = 0 ; k < comboObjects.length ; k++ ) {
            initCombo(comboObjects[k], k+1);
        }

        /* Axon Control Setting*/
        initControl();

        //버튼 비활성화
        ComBtnDisable("Save");   	  
    }
      
      
    function initControl() {
        var formObj = document.form;
        axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
        axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
        axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
        axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
        axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
        axon_event.addListenerForm('keydown','obj_keydown',	formObj); //- 키 눌렸을때
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:
                with (sheetObj) {

                    // 높이 설정
                    style.height = 439;
                    //전체 너비 설정
                    SheetWidth = 979;//mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|Sel|Seq.|LIST_KEY|CNTR No.|TP/SZ|P/Up Yard|P/Up Date|Auth No|AGMT No.|Lease Term|New Van| cntr_sts_seq |Auth VOL|P/Up VOL|Remark(s)";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true,  "ibflag");
                    InitDataProperty(0, cnt++ , dtDelCheck,     40,    daCenter,  true,  "dtChk",        false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtDataSeq,      35,    daCenter,  true,  "seq_num",      false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  true,  "list_key",     false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         85,    daCenter,  true,  "cntr_no",      false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         45,    daCenter,  true,  "tysz",         false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         65,    daCenter,  true,  "pup_yard",     false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         75,    daCenter,  true,  "pup_date",     false,          "",      dfDateYmd,        0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,        125,    daCenter,  true,  "auth_no",      false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,  "agmt_no",      false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         75,    daCenter,  true,  "lstm_cd",      false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,  "new_van_type", false,          "",      dfNone,           0,  false,   true);
                    InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  true,  "cntr_sts_seq", false,          "",      dfNone,           0,  false,   true);                    
                    InitDataProperty(0, cnt++ , dtData,         65,    daCenter,  true,  "auth_vol",     false,          "",      dfNullInteger,    0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,         65,    daCenter,  true,  "pup_vol",      false,          "",      dfNullInteger ,   0,  false,   true);
                    InitDataProperty(0, cnt++ , dtData,        135,    daCenter,  true,  "remark",       false,          "",      dfNone ,          0,  false,   true);
                    
                    SelectBackColor = LSE_SELECT_BACK_COLOR;
                    DataAutoTrim = true;
                }
                break;

            case 2:
                with (sheetObj) {

                // 높이 설정
                style.height = 335;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle = "0|LIST_KEY|auth_cntr_vol|pickup_vol|auth_vol|tysz|pup_yard|pkup_due_dt|auth_no|agmt_no1|agmt_no2|agmt_no|new_van_type|auth_cntr_vol_org|lstm_cd|remark";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter,  true,  "Sta");

                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "list_key",          false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "auth_cntr_vol",     false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "pickup_vol",        false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "auth_vol",          false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "tysz",              false,          "",      dfDateYmd,  0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "pup_yard",          false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "pkup_due_dt",       false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "auth_no",           false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "agmt_no1",          false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "agmt_no2",          false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "agmt_no",           false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "new_van_type",      false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "auth_cntr_vol_org", false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "lstm_cd",           false,          "",      dfNone,     0,  false,   true);
                InitDataProperty(0, cnt++ , dtData,         0,    daCenter,  true,  "remark",            false,          "",      dfNone,     0,  false,   true);

                SelectBackColor = LSE_SELECT_BACK_COLOR;
                DataAutoTrim = true;
            }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){
                    formObj.f_cmd.value = SEARCH;
                    
                    sheetObj.WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);                    

                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();

                    var sXml = sheetObj.GetSearchXml("EES_LSE_0032GS.do" , FormQueryString(formObj));
                    var arrXml = sXml.split("|$$|");
                    if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
                    if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);                    
                	subsheet_copy();
                	sheetObjects[0].ColumnSort("auth_no","DESC");

                	ComOpenWait(false);

                	if(sheetObj.RowCount > 0){
                        ComBtnEnable("Save");
                    }
                }
            break;
            
            case IBSAVE:            	
            if ( sheetObj.id == "sheet1") {
            	formObj.f_cmd.value = MULTI;
            	var sParam = sheetObj.GetSaveString(false, true, 1);
            	sParam += "&" + FormQueryString(formObj);            	
            	var sXml   = sheetObj.GetSaveXml("EES_LSE_0032GS.do", sParam);
            	sheetObj.LoadSaveXml(sXml);
            }            	
            break;
            
            case IBSEARCH_ASYNC01:	// Location 조회
    		if(validateForm(sheetObj,formObj,sAction)) {
    			if ( sheetObj.id == "sheet1") {
    				var vLocTp = formObj.loc_tp[formObj.loc_tp.selectedIndex].text;
    				var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
    				+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
    				sheetObj.WaitImageVisible = false; 						
    				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);

    				if ( sXml != "" ) {
    					if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
    						if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
    							var vLocCd = "";
    							switch (vLocTp) {
    							case "RCC":
    								vLocCd = ComGetEtcData(sXml, "rcc_cd");
    								break;
    							case "LCC":
    								vLocCd = ComGetEtcData(sXml, "lcc_cd");
    								break;															
    							}
    							formObj.loc_cd.value = vLocCd;
    							ComSetFocus(formObj.loc_cd);
    						} else {
    							ComShowCodeMessage("LSE01037");
    							formObj.loc_cd.value = "";
    							ComSetFocus(formObj.loc_cd);
    						}
    					} else {
    						var errMsg = LseComGetErrMsg(sXml);
    						if ( errMsg != "" ) {
    							ComShowMessage(errMsg);
    						}
    						formObj.loc_cd.value = "";
    						ComSetFocus(formObj.loc_cd);
    					}
    				}
    			}
    		}
    		break;            
        }
    }

    /**
      * Pop-up Open 부분<br>
      * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
      * @param object 대상 Object
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      */
    function openPopup(type, Row, Col) {
        var formObj = document.form;
        if ( type == "1" ) {
            var sUrl    = "";
            var iWidth  = 800;
            var iHeight = 430;
            var sTargetObjList = "";
            var sDisplay = "1,0,1,1,1,1,1,1";

            if(formObj.loc_tp[0].selected == true){
                sTargetObjList = "rcc_cd:loc_cd";
                sUrl    = '/hanjin/COM_ENS_051.do';
                ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
            }else if(formObj.loc_tp[1].selected == true){
                sTargetObjList = "lcc_cd:loc_cd";
                sUrl    = '/hanjin/COM_ENS_051.do';
                ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
            }
        }
    }

    /**
     * Location Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_yardCd(aryPopupData, Row, Col, sheetIdx) {
        if ( aryPopupData.length > 0 ) {
            document.form.loc_cd.value = aryPopupData[0][3];
        }
    }

    function obj_keypress() {
        var obj = event.srcElement;
        switch(obj.dataformat) {
            case "ymd":
            case "ym":
            case "hms":
            case "hm":
            case "jumin":
            case "saupja":
            case "int":
                ComKeyOnlyNumber(obj);
                break;
            case "float":
                ComKeyOnlyNumber(obj, "-.");
                break;
            case "eng":
                ComKeyOnlyAlphabet();
                break;
            case "engup":
            	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
                break;
            case "engdn":
                ComKeyOnlyAlphabet('lower');
                break;
            default:
                ComKeyOnlyNumber(obj);
            break;
        }
    }

    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) {
                case IBSEARCH:      //조회
                if ( formObj.loc_cd.value == "" ) {
    				ComShowCodeMessage("LSE01046");
    				ComSetFocus(formObj.loc_cd);
    				return false;
    				break;
    			}
                break;
            }
        }
        return true;
    }
    /**
     * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
     */
    function obj_focus(){
        var obj  = event.srcElement;
        if( obj.readOnly ) {
            ComSetNextFocus(obj);
        } else {
            //마스크구분자 없애기
            ComClearSeparator(event.srcElement);
        }
    }

    /**
      * sheet1_OnSaveEnd
      * 그리드 저장후 이벤트 처리
      * 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
      */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        /*
    	 if ( ErrMsg == "" ) {
        	//ComShowCodeMessage("LSE10001");    		
        } else {
            ComShowMessage(ErrMsg);
        }
        */
    }

    /**
     * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
     */
    function obj_blur(){
        var obj = event.srcElement;

        switch(obj.name){
            case "end_dt":
                //숫자이면서 천단위 구분을 하지 않는다.
                ComChkObjValid(obj);
            break;
            case "start_dt":
                //숫자이면서 천단위 구분을 하지 않는다.
                ComChkObjValid(obj);
            break;

            default:
                //Validation 전체 체크(길이,format,최대,최소 등등)
            break;
        }
    }

    /**
     * 서브그리드 카피
     */
    function subsheet_copy(){
        var pupDate = "";
        var pkupDueDt = "";
        var authCntrVol = 0;
        for(var i = 1 ; i <=  sheetObjects[0].RowCount ; i++ ){
        	
        	pupDate   = sheetObjects[0].CellValue(i, "pup_date");
        	if(pupDate != null && pupDate != ""){
                pupDate   = pupDate.replaceStr("-" , "");
        	}
        	var arrRows  = new Array();
        	var searchText = sheetObjects[0].CellValue(i, "list_key");
        	var strRows = ComFindAll(sheetObjects[1], 1, searchText);
        	strRows = strRows + "";        	
        	arrRows = strRows.replaceStr("|", ",").split(",");        	
        	
        	for(var k = 0 ; k <  arrRows.length ; k++){
        	   pkupDueDt = sheetObjects[1].CellValue(arrRows[k], "pkup_due_dt");
        	   if(pkupDueDt != null && pkupDueDt != ""){
                   pkupDueDt = pkupDueDt.replaceStr("-" , "");
        	   }               
               if(  Number(pupDate) <= Number(pkupDueDt)){
            	   authCntrVol = Number(sheetObjects[1].CellValue(arrRows[k],"auth_cntr_vol"));
            	   if(authCntrVol > 0){
                       sheetObjects[0].CellValue(i, "auth_no")  = sheetObjects[1].CellValue(arrRows[k], "auth_no");     //auth_no
                       sheetObjects[0].CellValue(i, "pup_vol")  = sheetObjects[1].CellValue(arrRows[k], "pickup_vol");  //pickup_vol
                       sheetObjects[0].CellValue(i, "auth_vol") = sheetObjects[1].CellValue(arrRows[k], "auth_vol");    //auth_vol
                       sheetObjects[0].CellValue(i, "lstm_cd")  = sheetObjects[1].CellValue(arrRows[k], "lstm_cd");     //lstm_cd
                       sheetObjects[0].CellValue(i, "remark")   = sheetObjects[1].CellValue(arrRows[k], "remark");      //remark
                       sheetObjects[1].CellValue(arrRows[k], "auth_cntr_vol") = authCntrVol -1;                         //auth_cntr_vol
                       sheetObjects[0].CellEditable(i, "dtChk") = true;
                       k = arrRows.length + 10;
                   }else{
                       sheetObjects[0].CellEditable(i, "dtChk") = false;
                       k = arrRows.length + 10;
                   }
               }        	  
        	}
        }
    }
     /**
      * HTML Control의 Value가 변경되었을 경우 처리한다.
      */
     function obj_change(){	 
     	var obj      = event.srcElement;
     	var formObj  = document.form;
     	if ( ComTrim(ComGetObjValue(obj)) != "" ) {
     		switch(obj.name) {
     		    case "loc_cd":		//Location Code
     		        if ( ComTrim(obj.value) != "" ) {
     			        if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L" ){
     				        doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
     			        }
     		        }
     		    break;
     		    case "loc_tp":
               	   formObj.loc_cd.value = "";
               	   formObj.loc_cd.focus();
                break;     		
     		}
     	}
     }	
     
      /**
      * Key-Down Event 처리
      */
      function obj_keydown() {
      	var obj      = event.srcElement;
      	var vKeyCode = event.keyCode;
      	var formObj  = document.form;
      	var srcObj  = window.event.srcElement;
      	if ( vKeyCode == 13 ) {
      		switch(obj.name) {
      		    case "aaa":
      		    default :
      			    if ( srcObj.style.filter == "" ) {
      				    sheetObjects[0].RemoveAll();				
      				    sheetObjects[1].RemoveAll();
      				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
      			    }
      	    }
      	}
      } 
      
  /* 개발자 작업  끝 */