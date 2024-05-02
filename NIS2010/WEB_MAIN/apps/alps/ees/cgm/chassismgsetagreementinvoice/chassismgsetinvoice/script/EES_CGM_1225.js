/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_CGM_1225.js
*@FileTitle : NP(ZP) Pool Chassis Estimated Expense Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : Chang-Young Kim
*@LastVersion : 1.0
* 2015.07.23 Chang-Young Kim
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
	 * @class EES_CGM_1225 : EES_CGM_1225 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CGM_1225() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject			= setSheetObject;
		this.setComboObject			= setComboObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
	}
	
	/* 개발자 작업	*/


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		
		var sheetObject1 = sheetObjects[0];
		
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			 switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
					break;

				case "btn1_Save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				
				case "btns_Calendar":
					var cal = new ComCalendar();
					cal.setDisplayType("year");
					cal.select(formObject.year, "yyyy");
					break;
				case "btn_New":
					formObj.reset();
					formObj.chss_pool_co_cd.text = "";
					sheetObject1.RemoveAll();
					
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
					initFormControl(false);
					break;
				case "btn_Calculation":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
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
		formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
			sheetObjects[i].ExtendLastCol = false;
			
		}
		
//		comboObjects[comboCnt++] = document.chss_pool_co_cd;
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k]);
		}
		
		axon_event.addListenerForm  ('beforedeactivate',	'obj_deactivate',	formObj);
		axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//		axon_event.addListener('focusout', 'obj_focusout', 'curr_cd'); 

	}
	
	/**
	 *
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
		
		initControl(sheetObjects[0]);   
		sheetObj.WaitImageVisible = true; 
	}
	
	/**
	 * Form의 Conrol 를 초기화 시킨다. <br>
	 * @param  {object} sheetObj	필수
	 * @return 없음
	 * @author 최민회
	 * @version 2009.05.20
	 */
	function initControl(sheetObj){
		// Form 객체 선언
		  formObj = document.form;
		// axon event 등록
		
		// Lease Term Combo Control에  초기값을  설정한다.
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		initFormControl(false);
		//formObj.chss_pool_co_cd.focus();

	}
	
	/**
	 * 버튼및 조회 조건 제어
	 * @param chk
	 * @return
	 */
	function initFormControl(chk){
//		formObj.chss_pool[0].disabled = chk;
//		formObj.chss_pool[1].disabled = chk;
		
		formObj.year.readOnly	= chk;
		
		if(chk == true){
			ComEnableObject(formObj.btns_Calendar, false);
			formObj.chss_pool_co_cd.Enable   = false; 
			formObj.year.className = "input2";
		} else {
			ComEnableObject(formObj.btns_Calendar, true);
			formObj.chss_pool_co_cd.Enable   = true; 
			formObj.year.className = "input1";
			
			//chungpa 20100429 year초기화 start
			var sysDate   = new Date();
			var year = sysDate.getFullYear();
			formObj.year.value = ComLpad(year, 4, "0");
			//chungpa 20100429 year초기화 end
		}
	}
	
	/** 
	 * MultiCombo 의 초기화  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
			 case "chss_pool_co_cd":
				 with(comboObj) {
					DropHeight = 500;
					SetColWidth("50|280");
					SetColAlign("center|left");
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
			 case 1:	  // sheet1 init
				 with (sheetObj) {
					// 높이 설정
					style.height = 440;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 13, 100);

					 var HeadTitle1  = "|Month|Est. Amount|Act. Amount|Fix|month|estm_yrmon|chss_pool_tp_cd|chss_pool_cd|curr_cd||";
					 var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					 //데이터속성	[ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, false, "ibflag");										  
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter, false, "month_nm"		, false, "", dfNone	 , 0, false, false);
					InitDataProperty(0, cnt++ , dtData,			330,daRight,  false, "estm_amt"		, false, "", dfNullFloat, 2, true,  true);
					InitDataProperty(0, cnt++ , dtData,			330,daRight,  false, "inv_smry_amt"	, false, "", dfNullFloat, 2, false, false);
					InitDataProperty(0, cnt++ , dtCheckBox,		60,	daCenter, false, "estm_amt_fx_flg" , false, "", dfNone	 , 0, true, true);
					
					
					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter, false, "month"		   , false, "", dfNone,	  0, true, true);
					InitDataProperty(0, cnt++ , dtHidden,	   160,	daRight,  false, "estm_yrmon"	  , false, "", dfNone,	  0, true, true);
					InitDataProperty(0, cnt++ , dtHidden,	   160,	daCenter, false, "chss_pool_tp_cd" , false, "", dfNone,	  0, true, true);
					
					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter, false, "chss_pool_cd"	, false, "", dfNone,	  0, true, true);
					InitDataProperty(0, cnt++ , dtHidden,	   160,	daRight,  false, "curr_cd"		 , false, "", dfNone,	  0, true, true);
					
					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter, false, "agmt_ofc_cty_cd"	, false, "", dfNone,	  0, true, true);
					InitDataProperty(0, cnt++ , dtHidden,	   160,	daCenter, false, "agmt_seq"		 , false, "", dfNone,	  0, true, true);
					
					CountPosition = 0;
					FitColWidth();
					
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:	  // Calculation(MAS)
				if(validateForm(sheetObj,formObj,sAction)){
					
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					
					// msgs['COM12183'] = 'It is possible to take a long time.\n\nYou must not navigate away from this page during approval.\n\nDo you want to continue?';
					if(ComShowCodeConfirm('COM12183')) {
						formObj.f_cmd.value = SEARCH;
						formObj.chss_pool_cd.value = formObj.chss_pool_co_cd.Code;
						
						var sXml = sheetObj.GetSearchXml("EES_CGM_1225GS.do", FormQueryString(formObj));
						
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
						
						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.RequestTimeOut = 7200;
							timer1 = setInterval(getBackEndJobStatus, 5000); // 5초 단위로
						}
						
					} else {
						ComOpenWait(false);
						return;
					}
					

					/*
					sheetObj.LoadSearchXml(sXml);
					formObj.curr_cd.value = sheetObj.CellValue(1, "curr_cd") ;
					
					for(i=1; i<=sheetObj.rowCount; i++){
						if(sheetObj.CellValue(i, "estm_amt_fx_flg")==1){
							sheetObj.CellEditable(i, "estm_amt")= false;
						} else {
							sheetObj.CellEditable(i, "estm_amt")= true;
						}
						
					}
					
					if(formObj.curr_cd.value==""){
						formObj.curr_cd.value = "USD";
					}
					*/
				}
				
				break;
				
			case IBSEARCH_ASYNC03:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH01;
					formObj.chss_pool_cd.value = formObj.chss_pool_co_cd.Code;
//					prompt("", FormQueryString(formObj)); return;
					var sXml = sheetObj.DoSearch("EES_CGM_1225GS.do" , FormQueryString(formObj)); 
					sheetObj.LoadSearchXml(sXml);
					formObj.curr_cd.value = sheetObj.CellValue(1, "curr_cd") ;
					
					for(i=1; i<=sheetObj.rowCount; i++){
						if(sheetObj.CellValue(i, "estm_amt_fx_flg")==1){
							sheetObj.CellEditable(i, "estm_amt")= false;
						} else {
							sheetObj.CellEditable(i, "estm_amt")= true;
						}
						
					}
					
					if(formObj.curr_cd.value==""){
						formObj.curr_cd.value = "USD";
					}
				}
				break;
				
			case IBSAVE:		//저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					formObj.chss_pool_cd.value = formObj.chss_pool_co_cd.Code;
					
					for(i=1; i<sheetObj.rowCount+1; i++){
						if(sheetObj.CellValue(i, "estm_yrmon")==""){
//							sheetObj.RowStatus(i) = "I";
							
							sheetObj.CellValue(i, "chss_pool_cd") = formObj.chss_pool_co_cd.Code ;
							sheetObj.CellValue(i, "curr_cd") = formObj.curr_cd.value ;
						} else {
//							sheetObj.RowStatus(i) = "U";
							sheetObj.CellValue(i, "curr_cd") = formObj.curr_cd.value ;
						}
					}
					
//					prompt("", sParam); return;
					if(sheetObj.DoSave("EES_CGM_1225GS.do", FormQueryString(formObj)))
					{
						
					} 
				}			
				break;

			case IBSEARCH_ASYNC01:	// CP Combo 조회
				formObj.f_cmd.value = SEARCH21;
				
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
				
				var cols = new Array();
				var txts = new Array();
				var coltxt = new Array();
				cols = ComGetEtcData(sXml, "code").split("|");
				txts = ComGetEtcData(sXml, "text").split("|");
				
				for(var idx=0; idx < cols.length; idx++) {
					coltxt[idx] = cols[idx] + "|" + txts[idx];
				}
				
				//IBSHEET GRID 밖에 있는 콤보
				makeZPMultiCombo(formObj.chss_pool_co_cd, coltxt, 0, 0);
				break;
				
//			case IBSEARCH_ASYNC02:	// CP Combo 조회
//				formObj.f_cmd.value = SEARCH;
//				var sXml = sheetObj.GetSearchXml("EES_CGM_CURRENCYGS.do", FormQueryString(formObj));
//				var dataCount = ComGetTotalRows(sXml);
//				if(dataCount==0){
//					ComShowCodeMessage('CGM10041','Currency');
//					formObj.curr_cd.focus();
//					formObj.curr_cd.value ="";
//				}
//				break;
		 }
	 }



	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		  switch(sAction) {
			case IBSEARCH:
			case IBSEARCH_ASYNC03:
				if(formObj.year.value == ''){
					ComShowCodeMessage('CGM10004','Year');
					 formObj.year.focus();
					 return false; 
				}	
				if(formObj.chss_pool_co_cd.text == ''){
					 ComShowCodeMessage('CGM10004','chss_pool_cd');
					 return false; 
				}	
				break;
			case IBSAVE:
				if(formObj.curr_cd.value == ''){
					ComShowCodeMessage('CGM10004','Currency');
					 formObj.curr_cd.focus();
					 return false; 
				}	
				break;
		}
		
		return true;
	}
	
	/**
	 * Object 의 activate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 최민회
	 * @version 2009.07.17
	 */
	function obj_activate(){
		ComClearSeparator(event.srcElement);
	}
	
	/** 
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 최민회
	 * @version 2009.05.20
	 */ 
	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
		
		window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "yyyy":
				if(event.keyCode==13) {
					set_serch();
				}
				ComKeyOnlyNumber(obj);
				break;
			case "eng":
				if(event.keyCode==13) {
					set_serch();
				}
				ComKeyOnlyAlphabet('upper');
				break;
		}
	}
	
	/** 
	 * CP Combo Object 에 값을 추가하는 처리 <br>
	 * @param  {object} cmbObj	필수 Combo Object
	 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
	 * @param  {int}	txtCol	필수 Combo Text에 표시할 Colume Index 번호
	 * @param  {int}	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
	 * @return 없음
	 * @author Chang-Young Kim
	 * @version 2015.07.22
	 */ 
	function makeZPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		// LOOP를 돌리기 위해 데이타 갯수를 구함 
		if(arrStr == undefined ){
			cmbObj.Index2 = "" ;
		} else {
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCodeCol = arrStr[i].split("|");
				cmbObj.InsertItem(i, arrStr[i], arrCodeCol[codeCol]);
				
			}
		}
	}
	
	/** 
	 * Object 의 deactivate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 최민회
	 * @version 2009.05.20
	 */
	function obj_deactivate() {
		var formObj = document.form;
		obj = event.srcElement;
		
		if(obj.name=="year") {
			
			ComChkObjValid(event.srcElement);
		}
	}
	
	/**
	 * 저장후 조회 호츨
	 * @return
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			set_serch();
		}
	}
	
	/**
	 * 저장후 조회 호츨
	 * @return
	 */
	function set_serch()
	{
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
	}
	
	/**
	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
	 * Agreement No 과 Referece No 의 유효성을 체크한다. 
	 */
	function sheet1_OnChange(sheetObj, Row, Col){
		
//		sheetObj.RowStatus(Row) = "U";
		
		if(Col == 4){ // Fix
			if(sheetObj.CellValue(Row, "estm_amt_fx_flg")==1) {
				if ( ComShowCodeConfirm("CGM10085") ){ 
					sheetObj.CellValue2(Row, "estm_amt") = sheetObj.CellValue(Row, "inv_smry_amt");
					sheetObj.CellEditable(Row, "estm_amt")= false;
				} else {
					sheetObj.CellEditable(Row, "estm_amt")= true;
					sheetObj.CellValue(Row, "estm_amt_fx_flg") = 0;
				}
				
			} else {
				sheetObj.CellEditable(Row, "estm_amt")= true;
			}
		}
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("EES_CGM_1225GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		
		if (jobState == "3") {
			getBackEndJobLoadFile();
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
		var sXml = sheetObj.DoSearch("EES_CGM_1225GS.do", FormQueryString(formObj));
		ComOpenWait(false);	
		sheetObj.WaitImageVisible = true;
	}
	
	/**
	 * 콤보 변경시 데이터 재조회
	 * @param  {object} ComboObj	필수	Sheet Object
	 * @param  {int}	Index_Code	필수
	 * @param  {string} Text		필수
	 * @return 없음
	 * @version 2009.07.16
	 */ 
	function chss_pool_co_cd_OnChange(comboObj, Index_Code, Text){
		
//		set_serch();
	}
	
	/**
	 * curr_cd 값 체크 
	 * @return
	 */
//	function obj_focusout(){
//		 var formObj = document.form;
//		 var sheetObj = sheetObjects[0];
//		 obj = event.srcElement;
//		 switch(obj.name){
//			case "curr_cd":
//				if(formObj.curr_cd.value != ''){
//					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
//				}
//				break;
//		}
//	}
	/* 개발자 작업  끝 */