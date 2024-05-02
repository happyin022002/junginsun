	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0115.js
	 *@FileTitle : Expense Plan and PFMC by HO
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.10.07
	 *@LastModifier : 민정호
	 *@LastVersion : 1.0
	 * 2009.10.07 민정호
	 * 1.0 Creation 
	 * 2014-04-01 Jonghee HAN CSR ID : CHM-201429360 Title : , ALPS MNR-Expense Creation_Inquiry에화면에 G.TTL 부분의 Ratio 에러 수정 요청 
	 *               -> initSheet 소수점 자리 2자리로, OnSearchEnd Total Rate Logic 추가
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
	 * @class EES_MNR_0115 : EES_MNR_0115 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0115() {
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
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;    
	
	var HOOfc = "";	
	var initLoader = 0;
	
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
			case "btn_Retrieve":
				document.form.rhq_only.checked = false; // 조회 전 rhq_only 해제
				sheetObjects[0].ColHidden("ofc_cd") = false; // 조회 전 시트 초기화
				doActionIBSheet(sheetObject1,formObject,IBBATCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break;						
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;
			case "cre_dt_cal_from":
				var cal = new ComCalendar();	
				cal.setDisplayType('month');		
				cal.select(formObject.from_mon, "yyyy-MM"); 
				break;	    						
			case "cre_dt_cal_to":
				var cal = new ComCalendar();	 			
				cal.setDisplayType('month');	 		   						
				cal.select(formObject.to_mon, 'yyyy-MM');	  	 
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
		comboObjects[comboCnt++] = combo_obj;  
	} 
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		initControl();    	  
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		//IBMultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k + 1);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
		var formObject = document.form
		switch(comboNo) {          	     
		case 1: 
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Period|Amount");				
				SetColAlign("left|left");						
				SetColWidth("110|90"); 						   
				DropHeight = 160;							 
				UseAutoComplete = true; 
			}      
			break;
		case 2: 
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
				SetColAlign("left|left");        
				//SetColWidth("100|150");
				DropHeight = 160;  
				UseAutoComplete = true;
			}      
			break;
		case 3: 
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
				SetColAlign("left|left");        
				//SetColWidth("100|150");
				DropHeight = 160;  
				UseAutoComplete = true;
			}          
			break;        	        	
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
			style.height = 442;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;	
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);
	
			var HeadTitle1 = "|Regional\nH/Q|Office" +
			"|511511\nRe-use CNTR|511511\nRe-use CNTR|511511\nRe-use CNTR" +
			"|511521\nOff-Hire CNTR|511521\nOff-Hire CNTR|511521\nOff-Hire CNTR" +
			"|511531\nRe-use CHSS|511531\nRe-use CHSS|511531\nRe-use CHSS" +
			"|511541\nOff-Hire CHSS|511541\nOff-Hire CHSS|511541\nOff-Hire CHSS" +
			"|511551\nReefer CNTR|511551\nReefer CNTR|511551\nReefer CNTR" +
			"|511561\nCHSS Trip Permit|511561\nCHSS Trip Permit|511561\nCHSS Trip Permit" +
			"|Total|Total|Total";	
			
			var HeadTitle2 = "|Regional\nH/Q|Office" +
			"|Budget|PFMC|Ratio(%)" +
			"|Budget|PFMC|Ratio(%)" +
			"|Budget|PFMC|Ratio(%)" +
			"|Budget|PFMC|Ratio(%)" +
			"|Budget|PFMC|Ratio(%)" +
			"|Budget|PFMC|Ratio(%)" +
			"|Budget|PFMC|Ratio(%)";                    
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(31, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			/* 2014-04-01 Jonghee HAN CSR ID : CHM-201429360 Title : , ALPS MNR-Expense Creation_Inquiry에화면에 G.TTL 부분의 Ratio 에러 수정 요청 
			 *               -> initSheet 소수점 자리 2자리로, OnSearchEnd Total Rate Logic 추가 */
			/* 2015-01-14 YouMok Lee CSR ID : CHM-201533561 
				1. 현재 Regional H/Q 항목(ex. HAMRU, NYCRA, SELHO 등)은 Retrieve 시 알파벳 순서대로 나열되게 되어 있음
					→ Regional H/Q 항목 중 SELHO 탭이 가장 상단에 조회되도록 수정 요청 (나머지는 SELHO 다음에 알파벳 순서대로 나열)
				2. 각 H/Q별(ex. HAMRU, NYCRA 등) 하위 Office의 각각의 수치만 나열되고 H/Q별 소계(Subtotal) 값이 없음
					→ 각 H/Q에 대한 S. Total 열을 추가해 해당 H/Q의 수치와 % 값이 보이도록 수정 요청 (단, SELHO 에 대해서는 S. Total 열 불필요)
				3. 가장 아래 조회되는 TOTAL 을 G. Total 로 수정 요청
				4. Ratio(%) 값으로 조회되는 모든 수치를 소수점 첫째자리에서 반올림해 정수(ex. 98%, 55%)로 조회되도록 수정 및 각 수치 뒤에 % 가 붙도록 수정 요청
			 */
			
						
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"Status");
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"rhq",			false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"ofc_cd",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pln_511511",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pfmc_511511",	false,	"",		dfNullFloat,		2,			true,		true); 										
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_511511",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pln_511521",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pfmc_511521",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_511521",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pln_511531",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pfmc_511531",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_511531",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pln_511541",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pfmc_511541",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_511541",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pln_511551",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pfmc_511551",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_511551",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pln_511561",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"pfmc_511561",	false,	"",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_511561",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"total",		false,	"|pln_511511|+|pln_511521|+|pln_511531|+|pln_511541|+|pln_511551|+|pln_511561|",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"total2",		false,	"|pfmc_511511|+|pfmc_511521|+|pfmc_511531|+|pfmc_511541|+|pfmc_511551|+|pfmc_511561|",		dfNullFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	"rate_total",	false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_h511511",	false,	"Round(|pfmc_511511| / |pln_511511| * 100,0)",		dfNullFloat,		-1,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_h511521",	false,	"Round(|pfmc_511521| / |pln_511521| * 100,0)",		dfNullFloat,		-1,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_h511531",	false,	"Round(|pfmc_511531| / |pln_511531| * 100,0)",		dfNullFloat,		-1,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_h511541",	false,	"Round(|pfmc_511541| / |pln_511541| * 100,0)",		dfNullFloat,		-1,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_h511551",	false,	"Round(|pfmc_511551| / |pln_511551| * 100,0)",		dfNullFloat,		-1,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_h511561",	false,	"Round(|pfmc_511561| / |pln_511561| * 100,0)",		dfNullFloat,		-1,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	false,	"rate_htotal",	false,	"Round(|total2| / |total| * 100,0)",				dfNullFloat,		-1,			false,		false);
			
			CountPosition = 0;		
			
		}		
		break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		case IBBATCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				if (sheetObj.id == "sheet1"){
					ComOpenWait(true,true);    
					formObj.f_cmd.value = COMMAND01; 
					sheetObj.WaitImageVisible = false;	
							 
					var sXml = sheetObj.GetSearchXml("EES_MNR_0115GS.do", FormQueryString(formObj));
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");	
					
					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 10000;	
						timer1 = setInterval(getBackEndJobStatus, 3000);
					}		
				}
			}
			break;
		case IBCLEAR:        //초기화
			MnrWaitControl(true);
			sheetObj.WaitImageVisible = false;
			if(initLoader == 0){
				//콤보 초기화 
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();       
				}					
				
				//콤보 셋팅
				var sCondition = new Array (
						new Array("MdmOrganization","RHQ","FALSE") 	//Regional HQ
						,new Array("MnrGenCd","CD00062", "COMMON")	//Report Type
				);   
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				for(var i=0; i<comboList.length; i++)
				{	
					if(i==1)
					{
						formObj.combo_report_type.RemoveAll();
						formObj.combo_report_type.Code2="-1";
					}
					if(comboList[i] != null)
					{
						for(var j = 0; j < comboList[i].length;j++)
						{   
							var xmlVal = comboList[i][j].split("|");  
							if(i==0){
								formObj.combo_rhq.InsertItem(j, comboList[i][j] ,xmlVal[0]);
							}else if(i==1){	
								var dpDesc = ""; 	
								if(xmlVal[0] == "BI"){	
									dpDesc = xmlVal[1] + "|Invoice Amt";
								} else {
									dpDesc = xmlVal[1] + "|W/O Amt";
								}
								formObj.combo_report_type.InsertItem(j, dpDesc ,xmlVal[0]);
							}
						}	
						if(i==0){
							formObj.combo_rhq.InsertItem(0, "ALL" ,"A" );
						}else if(i==1){
							formObj.combo_report_type.Code = "BW";
						}
					}
					else
					{
						if(i==0){
							ComShowCodeMessage("MNR00005", "Regional HQ   ");
						}else if(i==1){
							ComShowCodeMessage("MNR00005", "Report Typee   ");
						}
					}
					if(i==0)
					{
						formObj.combo_rhq.Code = "A";
						formObj.rhq.value = formObj.combo_rhq.Code;
						formObj.ofc_cd.value = formObj.combo_office.Code;
					}
				}
				
				initLoader = 1;	
			}
	
			//쉬트 초기화   
			for(i=0;i<sheetObjects.length;i++){   
				sheetObjects[i].RemoveAll();    
			}  
										
			formObj.from_mon.value = ComGetNowInfo("ym");
								
			//일단 임시로 1개월 이후로 세팅 	월기간 주기
			var sToday    = new Date();
            year    = sToday.getFullYear();					
            month   = sToday.getMonth()+ 1 + 0; 				
			formObj.to_mon.value = year + "-" + ComLpad(month,2,"0");	  
															    	
			formObj.combo_rhq.Code = "A";		
			formObj.combo_office.Code = "A";

			sheetObj.WaitImageVisible = true;
			MnrWaitControl(false);    			
			break;                 
	
		case IBDOWNEXCEL:
			//sheetObj.Down2Excel(-1);   
			sheetObj.SpeedDown2Excel(-1);   
			break;	                 
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}

	/**  
	 * combo_rhq Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  	
	function combo_report_type_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;       
		if(Index_Code==""){
			comboObj.Code="BW";
		}
		if(comboObj.Code=="BI"){
			formObj.report_type.value = "BI"; 
		}else{
			formObj.report_type.value = comboObj.Code; 
		}		
	}  	
	
	/**  
	 * combo_rhq Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  	
	function combo_rhq_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;       
		if(Index_Code==""){
			comboObj.Code="A";
		}
		if(comboObj.Code=="A"){
			formObj.rhq.value = "A"; 
		}else{
			formObj.rhq.value = comboObj.Code; 
		}
		comboOnChange(comboObj,Index_Code, Text);   		 
	}  
	
	/**
	 *  Regional HQ 에서 OnChange가 발생하는 경우 이벤트처리
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function comboOnChange(comboObj,Index_Code, Text){ 
		var formObj = document.form;
		formObj.combo_office.removeAll();
	
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
			);   
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
	
		if(comboList[0] != null){
			for(var i = 0; i < comboList[0].length;i++){ 
				var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				formObj.combo_office.InsertItem(i, comboList[0][i] , code);			   
			}
			formObj.combo_office.InsertItem(0, "ALL" , "A");
			formObj.combo_office.Code = "A";
		}	
	}	         
	
	/**  
	 * combo_office Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo_office_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;     
	
		if(Index_Code==""){
			comboObj.Code="A";
		}
		if(comboObj.Code=="A"){
			formObj.ofc_cd.value = "A"; 
		}else{
			formObj.ofc_cd.value = comboObj.Code; 
		}
	}       	
	
	function initControl() {  
		//Axon 이벤트 처리1. 이벤트catch  
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	}           
	
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
		obj = event.srcElement;    
		if(obj.dataformat == null) return; 
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {  
		case "ymd":   
		case "int":    
			ComKeyOnlyNumber(obj); 
			break;     
		case "float":   
			ComKeyOnlyNumber(obj, ".");
			break; 
		case "eng":   
			ComKeyOnlyAlphabet();
			break;   
		case "engup": 
			ComKeyOnlyAlphabet('uppernum');   
			break;	  
		case "YYMM":
			ComKeyOnlyNumber(obj);
			break;	        
		}
	} 	      
	   	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
			
		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_MNR_0115GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");

		if (jobState == "3") {
			getBackEndJobLoadFile();			
			clearInterval(timer1);
			change_value();
			ComOpenWait(false);
		} else if (jobState == "4") {
			ComShowCodeMessage("MNR00344");
			clearInterval(timer1);	
			ComOpenWait(false);
		} else if (jobState == "5") {
			ComShowCodeMessage("MNR00345");
			clearInterval(timer1);
			ComOpenWait(false);
		}
	}	
	
	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
			
	    formObj.f_cmd.value = COMMAND03;	
		sheetObj.DoSearch4Post("EES_MNR_0115GS.do",FormQueryString(formObj));	
		ComOpenWait(false);	
		sheetObj.WaitImageVisible = true;
	}
	
	/**
	* 조회후 처리
	*/		
	function change_value(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var i = 0;
		for(i = 2; i < sheetObj.RowCount+2; i++){
			var tempvalue_511511 = sheetObj.CellValue(i,"rate_h511511") +"(%)";
			    sheetObj.CellValue2(i,"rate_511511") = tempvalue_511511;
			    
			var tempvalue_511521 = sheetObj.CellValue(i,"rate_h511521") +"(%)";
			    sheetObj.CellValue2(i,"rate_511521") = tempvalue_511521;
			    
			var tempvalue_511531 = sheetObj.CellValue(i,"rate_h511531") +"(%)";
			    sheetObj.CellValue2(i,"rate_511531") = tempvalue_511531;
			    
			var tempvalue_511541 = sheetObj.CellValue(i,"rate_h511541") +"(%)";
			    sheetObj.CellValue2(i,"rate_511541") = tempvalue_511541;
			    
			var tempvalue_511551 = sheetObj.CellValue(i,"rate_h511551") +"(%)";
			    sheetObj.CellValue2(i,"rate_511551") = tempvalue_511551;
			    
			var tempvalue_511561 = sheetObj.CellValue(i,"rate_h511561") +"(%)";
			    sheetObj.CellValue2(i,"rate_511561") = tempvalue_511561;
			    
			var tempvalue_total = sheetObj.CellValue(i,"rate_htotal") +"(%)";
			    sheetObj.CellValue2(i,"rate_total") = tempvalue_total;
		}
	
	}
	
	/**  
	 * rhqOnly 체크박스 이벤트      
	 * @param  {Object}    rhqOnly  
	 */
	function showRhqOnly(rhqOnly){
		if(sheetObjects[0].Rows >= 3){
			if(rhqOnly.checked == true){ // 체크박스 선택 시, Sub Total 과 Grand Total만 나오도록 함
				sheetObjects[0].ColHidden("ofc_cd") = true;
				for(var i = 2; i < sheetObjects[0].Rows; i++){
					if(sheetObjects[0].CellValue(i,"ofc_cd") != "" && sheetObjects[0].CellValue(i,"ofc_cd") != "S.TTL" && sheetObjects[0].CellValue(i,"ofc_cd") != "SELCON"){
						sheetObjects[0].RowHidden(i) = true;
					}
				}
			} else{ // 체크박스 선택 해제 시, 모든 값들이 나오도록 함
				sheetObjects[0].ColHidden("ofc_cd") = false;
				for(var i = 2; i < sheetObjects[0].Rows; i++){
					sheetObjects[0].RowHidden(i) = false;
				}
			}
		}
	}
	
	/* 개발자 작업  끝 */