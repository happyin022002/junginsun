/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1107.js
*@FileTitle : Chassis Estimate Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.08 조재성
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
	 * @class EES_CGM_1107 : EES_CGM_1107 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CGM_1107() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject	 = setComboObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
		this.obj_change		 = obj_change;
		this.obj_keypress	   = obj_keypress;
		this.validateForm	   = validateForm;		
		this.sheet1_OnSort	  = sheet1_OnSort;
		this.sheet1_OnDblClick  = sheet1_OnDblClick;   
	}
	
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;	

	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	function firstDayInPreviousMonth(yourDate) {
		var d = new Date(yourDate);
		d.setDate(1);
		d.setMonth(d.getMonth() - 1);
		return d;
	}

	function initControl() {
		var formObj = document.form;
		axon_event.addListenerForm('click','obj_click',formObj);			//- 변경될때.
		axon_event.addListenerFormat('change','obj_change',formObj);		//- 변경될때.
		axon_event.addListenerFormat('keypress','obj_keypress',formObj);	//- 키 눌렸을때
		axon_event.addListenerFormat('blur','obj_blur',formObj);			//- 포커스 나갈때
		axon_event.addListenerFormat('focus','obj_focus',formObj);			//- 포커스 들어갈때
		axon_event.addListener('keyup', 'enterFire', 'period_eddt');
		axon_event.addListener('click', 'doc_type_change', 'doc_type');
		
		var d = firstDayInPreviousMonth(new Date());
		var y = d.getYear(); 
		var m = "";
		var mtmp = d.getMonth()+1;
		if(mtmp<10)	m = '0'+mtmp; 
		else m = ''+ mtmp;
		formObj.period_eddt.value = y+m;

		formObj.doc_type[0].checked=true;
		doc_type_change();
		ComBtnDisable("btn_save");
		
		formObj.div.Text = "";
		formObj.rev_month.value = "";
		formObj.rev_yrmon.value = "";
		
		div_change();
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
				
			case "btn_calendarRevMonth":
				if ( srcObj.style.filter == "" ) {
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.rev_month, "yyyy-MM");
					break;		
				}
				break;
				
			case "btn_calendarRevYrmon":
				if ( srcObj.style.filter == "" ) {
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.rev_yrmon, "yyyy-MM");
					break;		
				}
				break;
				
			case "btn_Retrieve":
				if ( srcObj.style.filter == "" ) {
					if(formObject.doc_type[0].checked==true) { //Detail
						sheetObjects[0].RemoveAll();
					}
					ComBtnDisable("btn_save");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
				break;
				
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;
				
			case "btn_New":
				initControl();
				break;
				
			case "btn_Calculation":
				if ( srcObj.style.filter == "" ) {
					sheetObjects[0].RemoveAll();
//					document.form.div.Index2 = -1;
//					document.form.rev_month.value = "";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
				}	
				break;
			case "btn_save":
				if(ComIsBtnEnable("btn_save")){				
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
				}
				break;	
			case "btn1_Report":
				Report();
				break;				
			} // end switch
			tRoleApply();
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
	}


   /**
	* Sheet 로딩 후 기본 설정 및 초기화 <br>
	* @param  없음
	* @return 없음
	* @author 조재성
	* @version 2009.10.20
	*/	 
	function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
	 
		// Multi Combo 초기화
	 	comboObjects[comboCnt++] = document.div;
	 	
	  	for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k]);
		}  
	  	
	  	//Group MultiCombo 값 초기화
	  	var arrGroup = new Array();
	  	arrGroup[0] = "LT|LT";
	  	arrGroup[1] = "ST|ST";
	  	arrGroup[2] = "CP|CP";
	  	arrGroup[3] = "NP|NP";
	  	arrGroup[4] = "ZP|ZP";
	  	makeComboObject(document.form.div, arrGroup, 1, 0, 0);
	  	
		initControl();
		ComBtnDisable("btn_save");
	 	
		doActionIBSheet(sheetObj,document.form,IBCLEAR);
		
		tRoleApply();
		
		document.form.period_eddt.focus();
		//document.form.div.focus()
		sheetObj.WaitImageVisible = true; 
	}	

	/** 
	 * Combo Object 초기화  <br>
	 * @param  {object} comboObj	필수 Combo Object
	 * @return 없음
	 * @author 조재성
	 * @version 2009.07.16
	 */ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
		/*
	   	case "div":
		 		var cnt=0;
	 			with(comboObj) {
	 				Code = "";
	 				Text = "";
	 				DropHeight = 100;
	 				MultiSelect = false;
	 				MaxSelect = 1;		
	 				UseCode = true;
	 				Enable = true;
	 			}
	 			break;
	 	*/
		case "div":
			var cnt=0;
			with(comboObj) {
				Code = "";
				Text = "";
				DropHeight = 100;
				MultiSelect = true;
				MaxSelect = 100;		
				UseCode = true;
				Enable = true;
			  
				ValidChar(2,3);		 // 영어 대문자, 숫자포함+특수(',')
				IMEMode = 0;			// 영문
				MaxLength = 20;		 // 100자까지 입력
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
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":	  //sheet1 init  DETAIL
			with (sheetObj) {
	
				// 높이 설정
				style.height = 402;
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
	
				var HeadTitle1 = "|SEQ|Execute Month|SYS Name|Cost Month|ACCT Code|AGMT NO|AGMT LSTM CD|CHSS POOL CD|INVO NO|COST VVD|||||REV VVD|Estimated Cost|Actual Cost|Accrual AMT|Charge Creation User|Charge Creation Date|Calculation Update User|Calculation Update Date";
	
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 8, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,   	  0,  daCenter, false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,	   		 50,  daCenter, false,	"seq",		   	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		  		 90,  daCenter, false,	"exe_yrmon",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 80,  daCenter, false,	"sys_src_id",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 80,  daCenter, false,	"rev_yrmon",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 80,  daCenter, false,	"acct_cd",	   	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daCenter, false,	"agmt_no",	   	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daCenter, false,	"agmt_lstm_cd", false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daCenter, false,	"chss_pool_cd", false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		120,  daCenter, false,	"invo_no",  	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daCenter, false,	"cost_vvd",	  	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,			 90,  daCenter, false,	"vsl_cd",		false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,			 80,  daCenter, false,	"skd_voy_no",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,	   		120,  daCenter, false,	"skd_dir_cd",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,			 60,  daCenter, false,	"rev_dir_cd",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daCenter, false,	"rev_vvd",	   	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daRight,  false,	"estm_amt",	  	false,  "",   dfFloat,  2,  true,    true);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daRight,  false,	"act_amt",   	false,  "",   dfFloat,  2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daRight,  false,	"accl_amt",	  	false,  "",   dfFloat,  2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"cre_usr_id",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"cre_dt",		false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"upd_usr_id",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"upd_dt",		false,  "",   dfNone,   0,  false,   false);
			 
				CountPosition   = 0;
				EditableColorDiff = true;
			}
			break;
			case "sheet2":	  //sheet1 init	SUMMARY
			with (sheetObj) {

				// 높이 설정
				style.height = 402;
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

				var HeadTitle1 = "|SEQ|Execute Month|SYS Name|Cost Month|ACCT Code|COST VVD|||||Estimated Cost|Actual Cost|Accrual AMT|Charge Creation User|Charge Creation Date|Calculation Update User|Calculation Update Date";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 	  0,  daCenter, false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,	  		 50,  daCenter, false,	"seq",		   	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 90,  daCenter, false,	"exe_yrmon",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 80,  daCenter, false,	"sys_src_id",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 80,  daCenter, false,	"rev_yrmon",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		 80,  daCenter, false,	"acct_cd",	   	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daCenter, false,	"cost_vvd",	  	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,			 90,  daCenter, false,	"vsl_cd",		false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,			 80,  daCenter, false,	"skd_voy_no",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,	   		120,  daCenter, false,	"skd_dir_cd",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,			 60,  daCenter, false,	"rev_dir_cd",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daRight,  false,	"estm_amt",	  	false,  "",   dfFloat,  2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daRight,  false,	"act_amt",   	false,  "",   dfFloat,  2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		100,  daRight,  false,	"accl_amt",	  	false,  "",   dfFloat,  2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"cre_usr_id",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"cre_dt",		false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"upd_usr_id",	false,  "",   dfNone,   0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		 		140,  daCenter, false,	"upd_dt",		false,  "",   dfNone,   0,  false,   false);
			 
				CountPosition   = 0;
				EditableColorDiff = true;
			}
			break;
		}
	}

	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetObject1 = sheetObjects[1];	//Summary
		var sheetObject2 = sheetObjects[0];	//Detail
		switch(sAction) {
			case IBSEARCH:	//조회
				if(formObj.doc_type[0].checked==true) //DETAIL	  
				{
					if(validateForm(sheetObject2,formObj,sAction)){
						formObj.f_cmd.value = SEARCH;			
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);						
						sheetObject2.DoSearch("EES_CGM_1107GS.do",FormQueryString(formObj)); 
						ComOpenWait(false);
					}
				}else{  //SUMMARY	
					if(validateForm(sheetObject1,formObj,sAction)){
						formObj.f_cmd.value = SEARCH02;			
				 		sheetObj.WaitImageVisible=false;
				 		ComOpenWait(true);						
						sheetObject1.DoSearch("EES_CGM_1107GS.do",FormQueryString(formObj)); 	  
				 		ComOpenWait(false);
					}
				}
				break;
			
			case IBSEARCH_ASYNC01:	//계산
				if(formObj.doc_type[0].checked==true) { //DETAIL	
				
					if ( validateForm(sheetObject2, formObj, IBSEARCH) ) {
						
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						
						// msgs['COM12183'] = 'It is possible to take a long time.\n\nYou must not navigate away from this page during approval.\n\nDo you want to continue?';
						if(ComShowCodeConfirm('COM12183')) {
							
							formObj.f_cmd.value = SEARCH01;
//							prompt("",FormQueryString(formObj)); return;
							
//							sheetObject2.DoSearch("EES_CGM_1107GS.do", FormQueryString(formObj));
							var sXml = sheetObject2.GetSearchXml("EES_CGM_1107GS.do", FormQueryString(formObj));
							
							var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
							
							if (backendJobKey.length > 0) {
								ComSetObjValue(formObj.backendjob_key, backendJobKey);
								sheetObject2.RequestTimeOut = 7200;
								timer1 = setInterval(getBackEndJobStatus, 5000); // 5초 단위로
							}
							
						} else {
							ComOpenWait(false);
							return;
						}
					}
				}
				
				break;	
			
			case IBSAVE:	//저장
				if(formObj.doc_type[0].checked==true) //DETAIL
				{
					if(validateForm(sheetObject2,formObj,sAction)) {
						formObj.f_cmd.value = MULTI;
						sheetObj.WaitImageVisible = false;	
						ComOpenWait(true);
						
						var sParam = sheetObject2.GetSaveString(true);
						sParam += "&" + FormQueryString(formObj);
						var sXml   = sheetObject2.GetSaveXml("EES_CGM_1107GS.do", sParam);
						sheetObject2.LoadSaveXml(sXml);
						
						ComOpenWait(false);	
					}
				}
				break;
				
			case IBDOWNEXCEL:	//엑셀 다운로드
				if(formObj.doc_type[0].checked==true) //DETAIL
				{
					sheetObject2.SpeedDown2Excel(-1);
				}else{ //SUMMARY	 
					sheetObject1.SpeedDown2Excel(-1);
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
					case IBSEARCH:	  //저장						  
	
						if ( formObj.period_eddt.value == "" ) {
							ComShowCodeMessage("CGM10004", "Period");
							ComSetFocus(formObj.period_eddt);
							return false;
						}
		
						if( formObj.period_eddt.value.length == 6 || formObj.period_eddt.value.length == 7) {
							//"200912" or "2009-12"
						}else
						{
							return false;
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
		case "rev_month":
		case "rev_yrmon":
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
				ComOpenWait(false);	
				ComShowCodeMessage("CGM00003");
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
		var obj	  = event.srcElement;
		var formObj  = document.form;
		//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
		switch(obj.name) {

			case "period_eddt":		//Location Code

				break; 	

		}
	//}
	}	

	/** 
	 * 기본조건 입력 후 ENTER키 적용 <br>
	 * @param  없음
	 * @return 없음
	 * @author 조재성
	 * @version 2009.10.08
	 */ 
	 function enterFire() {
  	   var formObj = document.form;
  	   var sheetObj = sheetObjects[0];
  	   
  	   if(event.keyCode == 13)
  	   {
  		   if(validateForm(sheetObj,formObj,IBSEARCH))
  		   {
  			   ComKeyEnter('search');
  		   }
  	   }
  	 	 
	 }   
	 
	 /**
	  * Sheet1 의 OnSearchEnd 이벤트처리 <br>
	  * @param  {object} sheetObj	필수	 Sheet Object
	  * @param  {string} ErrMsg		필수 String
	  * @return 없음
	  * @author 조재성
	  * @version 2009.11.12
	  */ 
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	 {
	 	with(sheetObj)
	 	{
	 		for(var i=1; i<= rowcount; i++)
	 		{
	 			cellValue2(i,'cost_vvd') = cellValue(i,'vsl_cd') + cellValue(i,'skd_voy_no') + cellValue(i,'skd_dir_cd') + cellValue(i, 'rev_dir_cd');
	 		}
	 	}
	 }	 
	  
	/**
	 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @author 조재성
	 * @version 2009.11.19
	 */ 
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
	  	{
	  		for(var i=1; i<= rowcount; i++)
	  		{
	  			cellValue2(i,'cost_vvd') = cellValue(i,'vsl_cd') + cellValue(i,'skd_voy_no') + cellValue(i,'skd_dir_cd') + cellValue(i, 'rev_dir_cd');
	  		}
	  	}
	}
	
	/** 
	 * Combo Object 에 값을 추가하는 처리 <br>
	 * @param  {object} cmbObj	필수 Combo Object
	 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
	 * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
	 * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
	 * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
	 * @return 없음
	 * @author 조재성
	 * @version 2009.07.16
	 */ 
	function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	 	cmbObj.RemoveAll();
	 	
	 	if(opt == 0) {
	 		for (var i = 0; i < arrStr.length;i++ ) {
	 			var arrCode = arrStr[i].split("|");
		 		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
			 }
	 	} else if(opt == 1){
	 		cmbObj.InsertItem(0,"","");
	 		for (var i = 0; i < arrStr.length;i++ ) {
	 			var arrCode = arrStr[i].split("|");
		 		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			 }
	 	}
	 	
	 	cmbObj.Index2 = "" ;
	}   

	/**
	 * Summary/Detail Change <br>
	 * @param  없음
	 * @return 없음
	 * @author 조재성
	 * @version 2009.08.14
	 */ 
	function doc_type_change() {
		var formObj = document.form;

		if(formObj.doc_type[0].checked==true) //Detail
		{
			document.getElementById('detailLayer').style.display = "block";
			document.getElementById('summaryLayer').style.display = "none";
			document.getElementById('glMonthLayer').style.display = "block";
			//sheet 초기화
//			sheetObjects[0].RemoveAll();
//			sheetObjects[1].RemoveAll();
			ComBtnEnable("btn_Calculation");

			/*
			formObj.div.Enable = false;
			//REV MONTH DISABLE
			formObj.rev_month.disabled = true;
			var styleCursor = "";
			var styleFilter = "progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
			var obj = document.getElementsByTagName("img");
			for ( var i = 0; i < obj.length; i++) {
				if (obj[i].getAttribute("name") == "btn_calendarRevMonth" ) {
					obj[i].className = styleCursor;
					obj[i].disabled = true;
					obj[i].style.filter = styleFilter;
				}
			} 
			*/
		} 
		else //Summary
		{
			document.getElementById('detailLayer').style.display = "none";
			document.getElementById('summaryLayer').style.display = "block";
			document.getElementById('glMonthLayer').style.display = "none";
			
			//sheet 초기화
//			sheetObjects[0].RemoveAll();
//			sheetObjects[1].RemoveAll();
			ComBtnDisable("btn_Calculation");
			
			/*
			formObj.div.Enable = true;
			//REV MONTH ENABLE
			formObj.rev_month.disabled = false;
			var styleCursor = "cursor"
			var styleFilter = "";
			var obj = document.getElementsByTagName("img");
			for ( var i = 0; i < obj.length; i++) {
				if (obj[i].getAttribute("name") == "btn_calendarRevMonth" ) {
					obj[i].className = styleCursor;
					obj[i].disabled = false;
					obj[i].style.filter = styleFilter;
				}
			}
			*/
		}
		
		ComBtnDisable("btn_save");
	}

	/**
	 * 팝업 
	 * @return
	 */
	function Report(){
   	  	var formObj = document.form;
		var chss_pool_tp_cd	= "";
		var year 			= document.form.period_eddt.value;
		if(formObj.period_eddt.value == ''){
			ComShowCodeMessage('CGM10004','Year');
	  		 formObj.period_eddt.focus();
	  		 return false; 
		} else {
			chss_pool_tp_cd = document.div.Text;
			var param = "?pgmNo=EES_CGM_1126";
   		   	param = param + "&f_cmd=" + SEARCH; 
   			param = param + "&chss_pool_tp_cd=" + chss_pool_tp_cd;		   	
   		   	param = param + "&year=" + year;//.substring(0,4);
   			ComOpenPopup('/hanjin/EES_CGM_1126.do' + param, 800, 450, "", "1,0", true, false);
		}
  			
	 }	 
	 
 /** 
  * div 의 change 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.12.08
  */
  function div_change(){
	  var formObj = document.form;
	  if(formObj.div.Text != "")
	  {
		  ComBtnEnable("btn1_Report");
	  }
	  else
	  {
		  ComBtnDisable("btn1_Report");
	  }
  }	 
  
  
  /**
   * 기능(ex:btn_save)에 권한(trole) 적용  <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2010.03.05
   */	 
   function tRoleApply() {
 	  var formObj = document.form;
 	  if(formObj.trole.value == "Authenticated")
 	  {

 	  }else
 	  {
 		  ComBtnDisable("btn_save");
 	  }
   } 
   
   /**
	* Location Multi-Combo 의 OnChange 이벤트처리 <br>
	* @param  {object} ComboObj	필수	 Sheet Object
	* @param  {int} 	Index_Code	필수
	* @param  {string} Text		필수
	* @return 없음
	* @version 2009.07.16
	*/ 
	function div_OnChange(ComboObj, Index_Code, Text){
		div_change();
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("EES_CGM_1107GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		
		if (jobState == "3") {
			getBackEndJobLoadFile();
			ComBtnEnable("btn_save");
			clearInterval(timer1);
			ComOpenWait(false);
		} else if (jobState == "4") {
			// msgs['CGM20037'] = 'BackEndJob Request Fail!';
			ComShowCodeMessage("CGM20037");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer1);
		} else if (jobState == "5") {
			// msgs['CGM20038'] = 'It was already created. Please check it again.';
			ComShowCodeMessage("CGM20038");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
			
		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.DoSearch("EES_CGM_1107GS.do", FormQueryString(formObj));
		ComOpenWait(false);	
		sheetObj.WaitImageVisible = true;
	}
	
	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var colNm = sheetObj.ColSaveName(Col);
		var acclAmt = 0;
		if( colNm == "estm_amt" ){
			acclAmt = parseFloat(sheetObj.CellValue(Row,"estm_amt")) - parseFloat(sheetObj.CellValue(Row,"act_amt"));
			
			if( acclAmt < 0 ){
				acclAmt = 0;
			}
			
			sheetObj.CellValue2(Row,"accl_amt") = acclAmt;
		}
	}

	/* 개발자 작업  끝 */