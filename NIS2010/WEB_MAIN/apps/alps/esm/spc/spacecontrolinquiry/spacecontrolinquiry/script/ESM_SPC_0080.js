/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0080.js
*@FileTitle : RDR Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2019.08.23
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0 
* 2010.08.23 CHOI.Y.S
* 1.0 Creation
* 2010.08.23 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발
* 2010.09.16 이윤정 [CHM-201005916-01] Weekly L/F by Carrier 화면 검색조건 추가 및 Display 조정
* 2010.12.10 이준범 [CHM-201007668] 정렬기준 변경
* 2011.03.03 이석준 [CHM-201109016-01] BSA Input Button 추가및 버튼 클릭시 PopUp(ESM_SPC_0084)
* 1) 작업내용
*  - subtrade_OnChange(), rlne_cd_OnChage() 추가
* 2011.07.01 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Total Weight 항목 추가
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
     * @class ESM_SPC_0080 : ESM_SPC_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0080() {
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
    var init_duration = '';
    
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
       				resetAll();

       				formObject.year.value = init_year;
					formObject.week.value = init_week;  
					formObject.duration.value = init_duration;  
					SpcSearchOptionWeek("week",false,document.form.year.value);
					
					SpcSearchOptionTrade("trade");
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("rlane_cd"); // 0207 SHKIM    
    				break;
    			
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				break;
    			
    			case "btn_downexcel_data":
    				doActionIBSheet(sheetObject1, formObject, "IBDOWNEXCELDATA");
    				break;
    			case "btn_bsa":
    				var sUrl = "/hanjin/ESM_SPC_0084.do";
    		          ComOpenPopup(sUrl, 600, 400, "", "0,0", true, false, "", "", "","BSA INPUT"); 
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
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = false;
    	document.getElementById("subtrade").Enable = false;
    	
     	SpcSearchOptionYear("year");
     	SpcSearchOptionWeek("week");
     	SpcSearchOptionDuration("duration", 15, 1);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionSubTrade("subtrade", true, true);
     	SpcSearchOptionLane("rlane_cd");
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
    	
    	// Operator Combo 초기화
    	var rtn = getCodeList("Operator", "");
    	initData_operator(rtn[0].split("|"), rtn[1].split("|"));
    	
    	document.form.year.focus();
    	
    	// TEST 용
    	//document.getElementById("year").value = "2009";
    	//document.getElementById("week").value = "35";
    	//comObjects[0].Text = "AES";
    	
    	init_year = document.form.year.value; // 년 초기화용
    	init_week = document.form.week.value; // 주차 초기화용
    	init_duration = document.form.duration.value; // 기간 초기화용
    	
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
    		InitRowInfo(2, 1, 5, 100);
    		
    		var weekArr = strWeeks.split("|");
    		var fdtdArr = strFdTds.split("|");
    		var columnCount = 3 + (weekArr.length) * 8;
    		
    		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    		InitColumnInfo(columnCount + 1, 3 , 0, true);
    		
    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
    		InitHeadMode(true, true, false, true, false,false) ;
    		
    		var HeadTitle0 = "Sub Trade\n/Lane|Carrier|";
    		var HeadTitle1 = "Sub Trade\n/Lane|Carrier|";
    		var WeekTitle  = "";
    		var FdTdTitle  = "";
    		var Title3     = "";
    		
    		for(var i = 0 ; i < weekArr.length ; i++) {
    			for(var h = 0 ; h < 8 ; h++) {
    				WeekTitle = WeekTitle + "|" + weekArr[i];
    				FdTdTitle = FdTdTitle + "|" + fdtdArr[i];
    			}
    		}
    		
    		HeadTitle0 = HeadTitle0 + WeekTitle;
    		HeadTitle1 = HeadTitle1 + FdTdTitle;
    		
    		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    		InitHeadRow(0, HeadTitle0, true);
    		InitHeadRow(1, HeadTitle1, true);
    		
    		var cnt = 0;
    		// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true,    "area"  ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true,    "opr_cd",     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenter,   true,    ""      ,     false,          "",       dfNone,       0,     true,       true);
    		
    		for(var j = 1 ; j < weekArr.length+1 ; j++){
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "bsa"      +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "full"     +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "empty"    +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_load" +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_wgt"  +j,     false,          "",       dfInteger,       0,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "full_lf"  +j,     false,          "",       dfNone   ,       1,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_lf"   +j,     false,          "",       dfNone   ,       1,     true,       true);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "ttl_wgt_lf"   +j,     false,          "",       dfNone   ,       1,     true,       true);
    		}
    		
    		CellBackColor(1,0) = RgbColor(222, 251, 248);
    		for(var m = 0 ; m <columnCount ; m ++) {
    			CellBackColor(1,m) = RgbColor(222, 251, 248);
    			CellBackColor(2,m) = RgbColor(222, 251, 248);
    		}
    		
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
    		InitColumnInfo(15, 0, 0, true);
    		
    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
    		InitHeadMode(true, true, false, true, false,false) ;
    		
    		var HeadTitle = "Carrier|Week|Trade|Sub-Trade|Lane|VVD|Bound|BSA|FULL|MTY|TTL LOAD|TTL WGT|FULL L/F|TTL L/F|TTL_WGT_L/F";
    		
    		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    		InitHeadRow(0, HeadTitle, true);
    		
    		var cnt = 0;
    		// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "opr_cd"    ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "week"      ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "trd_cd"    ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "sub_trd_cd",     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "lane"      ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "vvd"       ,     false,          "",       dfNone,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    70,    daCenter,   true ,    "bound"     ,     false,          "",       dfNone,       0,     true,       true);
    		
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "bsa"       ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "full"      ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "empty"     ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "ttl_load"  ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "ttl_wgt"   ,     false,          "",       dfInteger,       0,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "full_lf"   ,     false,          "",       dfNone   ,       1,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "ttl_lf"    ,     false,          "",       dfNone   ,       1,     true,       true);
    		InitDataProperty(0, cnt++ , dtData   ,    60,    daRight ,   false,    "ttl_wgt_lf"    ,     false,          "",       dfNone   ,       1,     true,       true);
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
            	
    			param = SpcFormString(formObj, 'year,week,duration,trade,subtrade,rlane_cd,bound,rhq,area,operator');//2010.09.16 이윤정 [CHM-201005916-01] 검색 조건 중 subtrade 추가 
    			rtn   = sheetObjects[0].GetSearchXml("ESM_SPC_0080GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
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
    				
    				rtn = sheetObjects[1].GetSearchXml("ESM_SPC_0080GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    				
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
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initData_operator(codes, names){
    	var sheetObj = document.getElementById("operator");
    	var cnt      = 0;
    	with(sheetObj){
    		RemoveAll();
    		SetTitle("Carrier");
    		//SetColWidth("60|250");
    		SetColAlign("left");
    		//ShowCol     = 0;
    		MultiSelect = false;
    		MaxSelect   = 1;
    		DropHeight  = 190;
    		
    		if(codes == undefined || codes == null){
    			return;
    		}
    		
    		if(codes.length > 2){
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for(var i = 0 ; i < codes.length - 1 ; i++){
    			var txt = names[i].split("~");
    			if(txt[1] == "1"){
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		}
    		
    		if(selectCode != ""){
    			Code = selectCode;
    		} else {
    			Index = 0;
    		}
    		Enable = (GetCount() > 1);
    		Enable = !(Index > 1);
    	}
    }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
  	 function initDataValue_operator(){
 	    var sheetObj = document.getElementById("operator");
 	    with(sheetObj){
 	        Index2 = 0;
 	    }
 	 } 
     /*
      * Trade OnChange시
      */  	 
     function trade_OnChange_t(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset2("trade",value,"true");   return;} // 0207 SHKIM
//      	if(value == "" ) return;
     	var repTrade = comObj.GetText(value,0);  
     	comObjects[1].Code2 = ""; //sub trade
     	comObjects[2].Code2 = ""; // lane
     	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("rlane_cd",true,false,'',value,'',true);	// 0207 SHKIM
     } 
     /*
      * Sub Trade OnChange시
      */
     function subtrade_OnChange_t(comObj,value,text ){  
//    	if(text == '||ALL'){   optionAllReset2("subtrade",document.form.trade.Code,"true"); return; } // 0207 SHKIM
    	SpcSearchOptionLane("rlane_cd",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    	 
    	if(value == "") return;
      	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    		comObjects[2].Code2 = '';
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[2].Code2 = '';
    	}       
     }
      
     /*
      * lane OnChange시
      */     
     function rlane_cd_OnChange_t(comObj,value,text ){
    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].Code2 = arrLane[0];
    		comObjects[1].Code2 = arrLane[1];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[1].Code2 = comObj.GetText(value,1);  
    	}	
     }      
      
     function initDataValue_trade(){
      	var sheetObj = document.getElementById("trade");
      	with(sheetObj){
      		Index2 = 0;
      	}
      }
      
      function initDataValue_subtrade(){
      	var sheetObj = document.getElementById("subtrade");
      	with(sheetObj){
      		Index2 = 0;
      	}
      }
      
      function initDataValue_rlane_cd(){
      	var sheetObj = document.getElementById("rlane_cd");
      	with(sheetObj){
      		Index2 = 0;
      	}
      }  

      /**
       * Start Week 의 year 변경시
       * Start Week 의 year 변경시 주차 변경
       */
      function checkWeek(){
      	SpcSearchOptionWeek("week",false,document.form.year.value);
      }  
      
      /**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
 	 /*
 	  * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
 	  */
 	 function trade_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("trade").focus(); 
 	 }

 	 function subtrade_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("subtrade").focus(); 
 	 }
 	 
 	 function rlane_cd_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("rlane_cd").focus(); 
 	 }
 	 
 	 function trade_OnChange(combj, value, text){
 		 var formObj = document.form;
 		 setTimeout(function(){trade_OnChange_t(combj,value,text)},10);
 	 }

 	 function subtrade_OnChange(combj, value, text){
 		 var formObj = document.form;
 		 setTimeout(function(){subtrade_OnChange_t(combj,value,text)},10);
 	 }
 	 function rlane_cd_OnChange(combj, value, text){
 		 var formObj = document.form;
 		 setTimeout(function(){rlane_cd_OnChange_t(combj,value,text)},10);
 	 }
	/** 개발자 작업  끝 */