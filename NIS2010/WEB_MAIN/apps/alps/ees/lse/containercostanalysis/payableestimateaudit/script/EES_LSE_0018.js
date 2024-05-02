/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0018.js
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.06 진준성
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
     * @class EES_LSE_0018 : EES_LSE_0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0018() {
    	this.processButtonClick = processButtonClick;
    	this.setSheetObject     = setSheetObject;
    	this.setComboObject     = setComboObject;
    	this.loadPage           = loadPage;
    	this.initSheet          = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet    = doActionIBSheet;    	
    	this.validateForm       = validateForm;
    	this.obj_change         = obj_change;
    	this.obj_keypress       = obj_keypress;
    	this.validateForm       = validateForm;    	
    	this.sheet1_OnSort      = sheet1_OnSort;
    	this.sheet1_OnDblClick  = sheet1_OnDblClick;   
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
		this.delayActionIBSheet = delayActionIBSheet;
		this.callbackPopupMail  = callbackPopupMail;
    }
    
   	/* 개발자 작업	*/
  //공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;


    //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
    	axon_event.addListenerFormat('change','obj_change',formObj);       //- 변경될때.	
    	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
    	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
    	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
    	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
    }

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
    		case "btn_calendar":
    			if ( srcObj.style.filter == "" ) {
    				var cal = new ComCalendar();
    				cal.setDisplayType('month');
    				cal.select(formObject.period_eddt, "yyyy-MM");
    				break;		
    			}
    			break;
    		case "btn_Retrieve":
    			if ( srcObj.style.filter == "" ) {
    				sheetObjects[0].RemoveAll();
    				ComBtnDisable("btn_save");
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			}
    			break;
    		case "btn_DownExcel":			
    			sheetObjects[0].SpeedDown2Excel(-1);			
    			break;			

    		case "btn_New":
    			sheetObjects[0].RemoveAll();
    			ComBtnDisable("btn_save");
    			formObject.period_eddt.value = "";    		
    			break;
    		case "btn_Calculation":
    			if ( srcObj.style.filter == "" ) {
    				sheetObjects[0].RemoveAll();
    				//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);    				
					doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
    			}	
    			break;
    		case "btn_save":
    			if(ComIsBtnEnable("btn_save")){				
    				doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
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
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	initControl();
    }


    function sheet1_OnLoadFinish(){
    	document.form.period_eddt.focus();
		ComBtnDisable("btn_save");	
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
    	case "sheet1":      //sheet1 init
    	with (sheetObj) {

    		// 높이 설정
    		style.height = 422;
    		//전체 너비 설정
    		SheetWidth = mainTable.clientWidth;

    		//Host정보 설정[필수][HostIp, Port, PagePath]
    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    		//전체Merge 종류 [선택, Default msNone]
    		MergeSheet = msNone;

    		//전체Edit 허용 여부 [선택, Default false]
    		Editable = true;

    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    		InitRowInfo(1, 1, 3, 100);

    		var HeadTitle1 = "|Seq.|Actual Month|SYS Name|REV Month|ACCT Code|AGMT No.|BIZ Unit|REV VVD|TP/SZ|EST Q'ty|Estimated Cost|Actual Cost|Accural AMT|Created UserID|Created Date|Update UserID|Update Date"
    			           + "|H_loc_cd|H_vsl_cd|H_skd_voy_no|H_skd_dir_cd|H_REV_DIR_CD";

    		var headCount = ComCountHeadTitle(HeadTitle1);

    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    		InitColumnInfo(headCount, 0, 0, true);

    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
    		InitHeadMode(true, true, false, true, false,false)

    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    		InitHeadRow(0, HeadTitle1, true);

    		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,   0,  daCenter, false,    "ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,       50,  daCenter, false,    "seq",              false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          85,  daCenter, false,    "actual_month",     false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          80,  daCenter, false,    "sys_name",         false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          80,  daCenter, false,    "rev_month",        false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          80,  daCenter, false,    "acct_code",        false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          90,  daCenter, false,    "agmt_no",          false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          80,  daCenter, false,    "biz_unit",         false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         120,  daCenter, false,    "rev_vvd",          false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          60,  daCenter, false,    "tp_sz",            false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         100,  daRight,  false,    "est_qty",          false,  "",   dfNullInteger,  0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         100,  daRight,  false,    "estimated_cost",   false,  "",   dfFloat,   		2,  true,   true);
			InitDataProperty(0, cnt++ , dtData,         100,  daRight,  false,    "actual_cost",      false,  "",   dfFloat,   		2,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         100,  daRight,  false,    "accural_amt",      false,  "",   dfFloat,   		2,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         100,  daCenter, false,    "cre_usr_id",       false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         100,  daCenter, false,    "cre_dt",           false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,         100,  daCenter, false,    "upd_usr_id",       false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtData,          80,  daCenter, false,    "upd_dt",           false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, false,    "loc_cd",           false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, false,    "vsl_cd",           false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, false,    "skd_voy_no",       false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, false,    "skd_dir_cd",       false,  "",   dfNone,   		0,  false,   false);
			InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, false,    "rev_dir_cd",       false,  "",   dfNone,   		0,  false,   false);
            
    		SelectBackColor = LSE_SELECT_BACK_COLOR;  
    		CountPosition   = 0;
    	}
    	break;
    	}
    }

    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

    	case IBSEARCH:      //조회
	    	if(validateForm(sheetObj,formObj,sAction)){
	    		if(sheetObj.id == "sheet1"){
	    			formObj.f_cmd.value = SEARCH;
	    			sheetObj.WaitImageVisible = false;
	    			ComOpenWait(true);
	    			sheetObj.DoSearch("EES_LSE_0018GS.do",FormQueryString(formObj));
	    			ComOpenWait(false);
	    		}	
	    	}
	    	break;
	    
    	case IBBATCH:      //조회-BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = COMMAND01;
						sheetObj.WaitImageVisible = false;
						sheetObj.Redraw = false;
						ComOpenWait(true);
              		var sXml = sheetObj.GetSearchXml("EES_LSE_0018GS.do", FormQueryString(formObj));
			    		var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.RequestTimeOut = 10000;
							timer1 = setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;
    	
    	case IBSEARCH_ASYNC01:	
	    	if ( validateForm(sheetObj, formObj, sAction) ) {    		
	    		formObj.f_cmd.value = SEARCH01;
	    		sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
	    		sheetObj.DoSearch("EES_LSE_0018GS.do",FormQueryString(formObj));
	    		ComOpenWait(false);
	    		if(sheetObj.RowCount > 0){
	    		    ComBtnEnable("btn_save");
	    		}
	    	}
	    	break;	
    	
    	case IBSAVE:        //저장
	    	if(validateForm(sheetObj,formObj,sAction)) {
	    		if ( sheetObj.id == "sheet1") {    	
	    			formObj.f_cmd.value = MULTI;			    		
	    			var sParam = sheetObj.GetSaveString(true);
	    			sParam += "&" + FormQueryString(formObj);
	
	    			sheetObj.WaitImageVisible = false;
	    			ComOpenWait(true);
	
	    			var sXml   = sheetObj.GetSaveXml("EES_LSE_0018GS.do", sParam);
	    			sheetObj.LoadSaveXml(sXml);
	
	    			ComOpenWait(false);	
	    		}
	    	}
	    	break;    	
    	}
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj){
    		with(formObj){
    			switch(sAction) {
    			case IBSEARCH:      //조회					      
    			case IBBATCH:      // bACK-END jOB조회					         			
    			//case IBSEARCH_ASYNC01:  	
    			if ( formObj.period_eddt.value == "" ) {
        			ComShowCodeMessage("LSE01010");
        			ComSetFocus(formObj.period_eddt);
        			return false;
        			break;
        		}   
    			break;
    			}
    		}
    	}
    	return true;
    }		


    /**
    * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
    */
    function obj_blur(){
    	var obj = event.srcElement;
    	switch(obj.name){
    	case "period_eddt":
    		//숫자이면서 천단위 구분을 하지 않는다.
    		ComChkObjValid(obj);
    		break;      
    
    	default:
    		//Validation 전체 체크(길이,format,최대,최소 등등)
    	break;
    	}
    }
    /**
    * HTML Control의 키보드 이벤트 방 포멧처리 한다.
    */
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
    		ComKeyOnlyAlphabet('upper'); 	        	
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
    * sheet1_OnSaveEnd
    * 그리드 저장후 이벤트 처리
    * 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
    */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == "" ) {
    			
    		if(document.form.f_cmd.value == MULTI){
    			ComShowCodeMessage("LSE10001");
    		}
    	} else {
    			
    		ComShowMessage(ErrMsg);
    	}
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
    * HTML Control의 Value가 변경되었을 경우 처리한다.
    */
    function obj_change(){	 
    	var obj      = event.srcElement;
    	var formObj  = document.form;
    	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
    	switch(obj.name) {

    	case "period_eddt":		//Location Code
    	
    	break; 	

    	}
    //}
    }	

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj  = document.form;

		with(sheetObj) {			
			sheetObj.Redraw = true;
    	}
		if (formObj.f_cmd.value == 13){
	    	//case IBBATCH:      // bACK-END jOB조회			         			
	    	if(sheetObj.RowCount > 0){
	    	    ComBtnEnable("btn_save");
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
    				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    			    }
    	    }
    	}
    }
    
	 /**
	 * 메일팝업 화면이 종료시 호출되는 콜백메서드
	 */
	function callbackPopupMail(interval) {
		timer2 = setInterval(delayActionIBSheet, interval);
	}
	
    
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0018GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = COMMAND03;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0018GS.do", FormQueryString(form));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
	}

	/**
	 * 지연된 Sheet관련 프로세스 처리
	 */
	function delayActionIBSheet() {
		var formObj = document.form;
		//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
		clearInterval(timer2);
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var colNm = sheetObj.ColSaveName(Col);
		var acclAmt = 0;
		if( colNm == "estimated_cost" ){
			acclAmt = parseFloat(Value) - parseFloat(sheetObj.CellValue(Row,"actual_cost"));
			
			if( acclAmt < 0 ){
				acclAmt = 0;
			}
			
			sheetObj.CellValue2(Row,"accural_amt") = acclAmt;
		}
	}
        
	/* 개발자 작업  끝 */