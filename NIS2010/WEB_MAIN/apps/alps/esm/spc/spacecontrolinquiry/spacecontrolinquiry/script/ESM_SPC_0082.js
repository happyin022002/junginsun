/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0082.js
*@FileTitle : L/F Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.10.19 CHOI.Y.S
* 1.0 Creation
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
* 2011.01.19 최윤성 [CHM-201108422-01] L/F Summary 화면 하드코딩 및 보완 요청
*  - IAS/IP sub-trade 에 한하여 BSA 는 Full BKG volume 과 동일하게 보여지도록 수정
*  - IAS 한하여 Empty 값은 From ~ To 의 Conti 가 모두 A 인 값만 보이고 나머지는 0.
*  - 화면에 주차별로 display 된 데이터의 총합을 보여주는 열 추가.
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_SPC_0082 : ESM_SPC_0082 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0082() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/** 개발자 작업	*/
    
    // 공통전역변수
    var sheetObjects = new Array();
    var comObjects   = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var param    = "";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var sheetObject  = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var formObject  = document.form;
    	 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			
    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				ComResetAll();
    				formObject.year.value = init_year;
					formObject.week.value = init_week;
					SpcSearchOptionWeek("week",false,document.form.year.value);         
					SpcSearchOptionTrade("trade", true, true);
	     			SpcSearchOptionSubTrade("subtrade");
    				break;
    			
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				break;
    			
    			case "btn_downexcel_data":
    				doActionIBSheet(sheetObject1, formObject, "IBDOWNEXCELDATA");
    				break;
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
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
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//ie11  ibcombo 잔상 개선
    	document.getElementById("trade").Enable = false;
    	document.getElementById("subtrade").Enable = false;
    	
    	SpcSearchOptionYear("year");
    	SpcSearchOptionWeek("week");
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionBound("bound",false,true,false,false);
    	
    	for(i=0;i<sheetObjects.length;i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	var sheetResizeFull = true;
    	document_onresize();
    	
    	document.form.year.focus();
    	
    	// TEST 용
    	//document.getElementById("year").value = "2009";
    	//document.getElementById("week").value = "35";
    	//comObjects[0].Text = "AES";
    	init_year = document.form.year.value; // 년 초기화용
    	init_week = document.form.week.value; // 주차 초기화용
    	setMonFlg();
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = true;
    	document.getElementById("subtrade").Enable = true;
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	
    	switch(sheetNo) {
    		case 1:      //sheet1 init
    			sheetObj.style.height = sheetObj.getSheetHeight(17) ;
    			initSheet1(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120");
    			break;
    		
    		case 2:      //sheet2 init
    			sheetObj.style.height = sheetObj.getSheetHeight(17) ;
    			initSheet2(sheetObj);
    			break;
    	}
    }
    
    /**
     * Sheet1에서 조회후 타이틀 변경
     */
    function initSheet1(sheetObj, strWeeks, strFdTds) {
    	with (sheetObj) {
    		// 높이 설정
    		//style.height = getSheetHeight(17) ;
    		// 전체 너비 설정
    		SheetWidth = mainTable.clientWidth;
    		
    		// Host정보 설정[필수][HostIp, Port, PagePath]
    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    		
    		// 전체Merge 종류 [선택, Default msNone]
    		MergeSheet = msPrevColumnMerge;
    		
    		// 전체Edit 허용 여부 [선택, Default false]
    		Editable = false;
    		FocusEditMode = default_edit_mode;
    		
    		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    		InitRowInfo(3, 1, 5, 100);
    		
    		var weekArr = strWeeks.split("|");
    		var fdtdArr = strFdTds.split("|");

    		// 2011.01.19 - 열의 Total 값 필드를 추가하여 6개 늘어남
    		var columnCount = 2 + (weekArr.length) * 7 + 7;
    		
    		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    		InitColumnInfo(columnCount + 1, 2 , 0, true);
    		
    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
    		InitHeadMode(true, true, false, true, false,false) ;
    		
    		var HeadTitle0 = "Sub Trade\n/Lane|";
    		var HeadTitle1 = "Sub Trade\n/Lane|";
    		var HeadTitle2 = "BSA|FULL|EMPTY|TTL LOAD|FULL L/F|TTL L/F|TTL WGT L/F";
    		var WeekTitle  = "";
    		var FdTdTitle  = "";
    		var Title3     = "";
    		
    		for(var i = 0 ; i < weekArr.length ; i++) {
    			for(var h = 0 ; h < 7 ; h++) {
    				WeekTitle = WeekTitle + "|" + weekArr[i];
    				FdTdTitle = FdTdTitle + "|" + fdtdArr[i];
    			}
    			Title3 = Title3 + "|" + HeadTitle2;
    		}
    		
    		// 2011.01.19 - G.TTL 추가 관련 하여 Title 세팅
    		for(var h = 0 ; h < 7 ; h++) {
				WeekTitle = WeekTitle + "|G.TTL";
				FdTdTitle = FdTdTitle + "|G.TTL";
			}
			Title3 = Title3 + "|" + HeadTitle2;
    		
    		HeadTitle0 = HeadTitle0 + WeekTitle;
    		HeadTitle1 = HeadTitle1 + FdTdTitle;
    		HeadTitle2 = "Sub Trade\n/Lane| " + Title3;
    		
    		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    		InitHeadRow(0, HeadTitle0, true);
    		InitHeadRow(1, HeadTitle1, true);
    		InitHeadRow(2, HeadTitle2, true);
    		
    		var cnt = 0;
    		// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true,    "area"  ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenter,   true,    ""      ,     false,          "",       dfNone,       0,     true,       true);
    		
    		for(var j = 1 ; j < weekArr.length+1 ; j++){
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "bsa"      +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "full"     +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "empty"    +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_load" +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "full_lf"  +j,     false,          "",       dfNone   ,       1,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_lf"   +j,     false,          "",       dfNone   ,       1,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_wgt_lf"   +j,     false,          "",       dfNone   ,       1,     true,       true);
    		}
    		
    		// 2011.01.19 - G.TTL 추가 관련 하여 필드 세팅
    		InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_bsa"     ,     false,          "",       dfInteger,       0,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_full"    ,     false,          "",       dfInteger,       0,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_empty"   ,     false,          "",       dfInteger,       0,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_ttl_load",     false,          "",       dfInteger,       0,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_full_lf" ,     false,          "",       dfNone   ,       1,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_ttl_lf"  ,     false,          "",       dfNone   ,       1,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "t_ttl_wgt_lf"  ,     false,          "",       dfNone   ,       1,     true,       true);			
//    		CellBackColor(1,0) = RgbColor(222, 251, 248);
    		
    		HeadRowHeight = 20;
    		HeadRowHeight = 21;
    	}
    }
    
    /**
     * Sheet1에서 조회후 타이틀 변경
     */
    function initSheet2(sheetObj) {
    	with (sheetObj) {
    		// 높이 설정
    		//style.height = getSheetHeight(17) ;
    		// 전체 너비 설정
    		SheetWidth = mainTable.clientWidth;
    		
    		// Host정보 설정[필수][HostIp, Port, PagePath]
    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    		
    		// 전체Merge 종류 [선택, Default msNone]
    		MergeSheet = msNone;
    		
    		// 전체Edit 허용 여부 [선택, Default false]
    		Editable = false;
    		FocusEditMode = default_edit_mode;
    		
    		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    		InitRowInfo(1, 1, 5, 100);
    		
    		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    		InitColumnInfo(12, 0, 0, true);
    		
    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
    		InitHeadMode(true, true, false, true, false,false) ;
    		
    		var HeadTitle = "Week|Trade|Sub-Trade|Lane|Bound|VVD|BSA|FULL|MTY|TTL LOAD|FULL L/F|TTL L/F";
    		
    		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    		InitHeadRow(0, HeadTitle, true);
    		
    		var cnt = 0;
    		// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "week"      ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "trd_cd"    ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "sub_trd_cd",     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "lane"      ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "dir_cd"    ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "vvd"       ,     false,          "",       dfNone,       0,     true,       true);
    		
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "bsa"       ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "full"      ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "empty"     ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "ttl_load"  ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "full_lf"   ,     false,          "",       dfNone   ,       1,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "ttl_lf"    ,     false,          "",       dfNone   ,       1,     true,       true);
    	}
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    }
    
    // Sheet1관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(!validateForm(sheetObj,formObj,sAction)) {
    				return false;
    			}
    			
    			formObj.f_cmd.value = SEARCHLIST01;
    			
    			sheetObjects[0].RemoveAll(); 
            	sheetObjects[0].Redraw = false;
            	formObj.rev_month.value = ComReplaceStr(formObj.rev_month.value,"-","");
    			param = SpcFormString(formObj, 'mon_flg,rev_month,year,week,duration,trade,subtrade,bound,rhq'); 
    			rtn   = sheetObjects[0].GetSearchXml("ESM_SPC_0082GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    			week  = getEtcDataFromXml(rtn, "week");
            	fdtd  = getEtcDataFromXml(rtn, "fdtd");
            	sheetObj.Reset();
            	
            	initSheet1(sheetObj, week, fdtd);
            	sheetObj.LoadSearchXml(rtn);
            	sheetObjects[0].Redraw = true;
            	
    			break;
    		
    		case IBDOWNEXCEL:        //엑셀 다운로드
    			sheetObj.Down2Excel(-1);
    			break;
    		
    		case "IBDOWNEXCELDATA":        //엑셀 다운로드
    			
    			if(param != "") {
    				formObj.f_cmd.value = SEARCHLIST02;
    				
    				rtn = sheetObjects[1].GetSearchXml("ESM_SPC_0082GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    				
    				initSheet2(sheetObj);
    				sheetObj.LoadSearchXml(rtn);
    			}
    			sheetObj.Down2Excel(-1);
    			break;
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
    	var dur   = formObj.duration.value;
    	var trade = comObjects[0].Code;
    	var rhq   = formObj.rhq.value;
    	
    	if(trade == "") {
    		ComShowMessage(getMsg("SPC90114", "Trade"));
    		comObjects[0].focus();
    		return false;
    	}
    	
    	if(rhq == "") {
    		ComShowMessage(getMsg("SPC90114", "RHQ"));
    		formObj.rhq.focus();
    		return false;
    	}
    	
    	if(trade == "IAS" && dur > 6) {
    		formObj.duration.value = 5;
    	}
    	
    	if(formObj.f_mon_flg.checked){
    		if(formObj.rev_month.length >= 6){
    			ComShowMessage(getMsg("SPC90114", "Revenue Month"));
        		formObj.rev_month.focus();
        		return false;
    		}
    	}
    	
    	return true;
    }
    
    function getEtcDataFromXml(xml, str){
    	var pos = xml.indexOf("ETC KEY=\""+str+"\"");
    	if(pos < 0) return "";
		pos = xml.indexOf(">", pos + 1);
		if(pos < 0) return "";
		var epos = xml.indexOf("</ETC>", pos + 1);
		var rtn = "";
		if(epos < 0){
			rtn = xml.substring(pos + 1);
		}
		else{
			rtn = xml.substring(pos + 1, epos);
		}
		return rtn;
	}
    
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week",false,document.form.year.value);
    	
    }   

    function trade_OnChange(comObj,value,text ){
//    	if(value == "" ) return;
    	var repTrade = comObj.GetText(value,0);  
    	comObjects[1].Code2 = ""; //sub trade
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
    } 
    
    function subtrade_OnChange(comObj,value,text ){
    	if(value == "" ) return;
    	
    	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    	}  
    	
    } 

    
    function setMonFlg(){
    	if(document.form.f_mon_flg.checked){
    		document.form.year.disabled = "disabled";
    		document.form.week.disabled = "disabled";
    		document.form.duration.disabled = "disabled";
    		document.form.rev_month.disabled = "";
    		document.form.mon_flg.value = "Y";

    	}else{
    		document.form.year.disabled = "";
    		document.form.week.disabled = "";
    		document.form.duration.disabled = "";
    		document.form.rev_month.value = "";
    		document.form.rev_month.disabled = "disabled";
    		document.form.mon_flg.value = "N";

    	}
    	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * ie11 관련 개선 lane 콤보 
     */
    function trade_OnFocus(combj, value, text){
    	document.getElementById("year").focus();
        document.getElementById("trade").focus(); 
    }
    /**
     * ie11 관련 개선 lane 콤보 
     */
    function subtrade_OnFocus(combj, value, text){
    	document.getElementById("year").focus();
        document.getElementById("subtrade").focus(); 
    }

    
	/** 개발자 작업  끝 */