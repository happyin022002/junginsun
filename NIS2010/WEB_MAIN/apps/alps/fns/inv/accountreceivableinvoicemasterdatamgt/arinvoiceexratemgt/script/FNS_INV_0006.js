/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0006.js
*@FileTitle : Ex. Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.04.24 박정진
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
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
	 * @class fns_inv_0006 : fns_inv_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0006() {
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
	
	var rdObjects = new Array();
	 var rdCnt = 0;
	
	var trMode = "R";
	var prevDtIdx = -1;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;
		
		try {
			var xchRtTpCd = formObj.xch_rt_tp_cd.Code;
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.from_day, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.to_day, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar3": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('month');
	             	cal.select(formObj.from_month, 'yyyy-MM');
				break;
				
				case "btns_calendar4": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('month');
	             	cal.select(formObj.to_month, 'yyyy-MM');
				break;
				
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObj.port_cd.value;
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
				break;
				
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
				break;
				
				case "btn_new":
					removeAll(formObj);
				break;
				
				case "btn_downExcel":
					sheetObj.Down2Excel(-1);
				break;
				
				case "btn_print":
					if (sheetObj.RowCount == 0) {
						ComShowCodeMessage("INV00095");
						return false;
					}
					rdOpen(formObj.xch_rt_tp_cd.Code);
				break;
				
				case "btn_close":
					window.close();
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/** 
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function loadPage() {
		//IBMultiCombo초기화
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		for (var i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			
			initSheet(sheetObjects[i], i + 1);
			
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();
		
		initRdConfig(rdObjects[0]);
	}		
	
	// 업무 자바스크립트 OnLoadFinish 이벤트 처리
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
		
		var vvdCd = formObj.view_vvd_cd.value;
		var portCd = formObj.view_port_cd.value;
		var loclCurrCd = formObj.view_locl_curr_cd.value;
		var svcScpCd = formObj.view_svc_scp_cd.value;
		var ioBndCd = formObj.view_io_bnd_cd.value;
		
		//팝업창 조회시
		if(vvdCd != "") {
			//조회조건 입력창 비활성화
			ComEnableObject(formObj.chg_curr_cd,	false);	// X
			ComEnableObject(formObj.locl_curr_cd,	false);	// X
			ComEnableObject(formObj.vvd_cd,			false);	// X
			ComEnableObject(formObj.port_cd,		false);	// X
			ComEnableObject(formObj.cust_cnt_cd,	false);	// X
			ComEnableObject(formObj.cust_seq,		false);	// X
			ComEnableObject(formObj.from_day,		false);	// X
			ComEnableObject(formObj.to_day,			false);	// X
			ComEnableObject(formObj.from_month,		false);	// X
			ComEnableObject(formObj.to_month,		false);	// X

			formObj.xch_rt_tp_cd.Enable = false;			// X
			formObj.svc_scp_cd.Enable = false;				// X
			formObj.io_bnd_cd.Enable = false;				// X
			
			document.getElementById('Date_A').style.display = "block";
			document.getElementById('Date_B').style.display = "none";
			
			sheetObj.Reset();
			initSheet(sheetObj,1);
			
			//조회조건 세팅
			formObj.vvd_cd.value = vvdCd;
			formObj.port_cd.value = portCd;
			formObj.locl_curr_cd.value = "";
			if (svcScpCd != '') {
				formObj.svc_scp_cd.Code = svcScpCd;
			}
			else {
				formObj.svc_scp_cd.Code = "ALL";
			}
			if (ioBndCd != '') {
				formObj.io_bnd_cd.Code = ioBndCd;
			}
			else {
				formObj.io_bnd_cd.Code = "ALL";
			}
			
			//VVD 조회
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		}
		
		//Scope 리스트 조회
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		formObj.vvd_cd.focus();
	}
	
	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var formObj = document.form;
		
		var xchRtTpCd = formObj.xch_rt_tp_cd.Code;
		
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					var HeadTitle = "";
					if (xchRtTpCd == 'V') {
						HeadTitle = "|VVD|Port|Bound|ETA/ETD|Scope|Office|Charge Cur|Local Cur|Ex.Rate|Inverse Rate";
					}
					else if (xchRtTpCd == 'I') {
						HeadTitle = "|Office|Customer|Bound|From Date|To Date|Charge Cur|Local Cur|Ex.Rate";
					}
					else if (xchRtTpCd == 'C') {
						HeadTitle = "|Office|Bound|From Date|To Date|Charge Cur|Local Cur|Ex.Rate";
					}
					else if (xchRtTpCd == 'D') {
						HeadTitle = "|Office|Date|Charge Cur|Local Cur|Ex.Rate";
					}
					else if (xchRtTpCd == 'A') {
						HeadTitle = "|Month|Cur|Ex.Rate(USD:LCL)|Ex.Rate(LCL:KRW)";
					}
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if (xchRtTpCd == 'V') {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,    "ibflag");
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,    "vvd_cd",			false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,    "port_cd",			false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,    "io_bnd_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,    "etda_dt",			false,    "",      dfDateYmd,	0,	false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,    "svc_scp_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,    "ar_ofc_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,    "chg_curr_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,    "locl_curr_cd",	false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			140,	daRight,	true,    "inv_xch_rt",		false,    "",      dfNullFloat,	6,	false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			140,	daRight,	true,    "ivs_xch_rt",		false,    "",      dfNullFloat,	6,	false,		false);
					}
					else if (xchRtTpCd == 'I') {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,    "ibflag");
						InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,    "ar_ofc_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			180,	daCenter,	true,    "cust_seq",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,    "io_bnd_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,    "fm_dt",			false,    "",      dfDateYmd,	0,	false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,    "to_dt",			false,    "",      dfDateYmd,	0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			105,	daCenter,	true,    "chg_curr_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			105,	daCenter,	true,    "locl_curr_cd",	false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,    "inv_xch_rt",		false,    "",      dfNullFloat,	6,	false,		false);
					}
					else if (xchRtTpCd == 'C') {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,    "ibflag");
						InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,    "ar_ofc_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,    "io_bnd_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,    "fm_dt",			false,    "",      dfDateYmd,	0,	false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,    "to_dt",			false,    "",      dfDateYmd,	0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,    "chg_curr_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			105,	daCenter,	true,    "locl_curr_cd",	false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,    "inv_xch_rt",		false,    "",      dfNullFloat,	6,	false,		false);
					}
					else if (xchRtTpCd == 'D') {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,    "ibflag");
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,    "ar_ofc_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,    "fm_dt",			false,    "",      dfDateYmd,	0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			105,	daCenter,	true,    "chg_curr_cd",		false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			105,	daCenter,	true,    "locl_curr_cd",	false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,    "inv_xch_rt",		false,    "",      dfNullFloat,	6,	false,		false);
					}
					else if (xchRtTpCd == 'A') {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,    "ibflag");
						InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,    "acct_xch_rt_yrmon",false,   "",      dfDateYm,	0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,    "curr_cd",			false,    "",      dfNone,		0,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			200,	daRight,	true,    "usd_locl_xch_rt",	false,    "",      dfNullFloat,	6,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			200,	daRight,	true,    "locl_krw_xch_rt",	false,    "",      dfNullFloat,	6,	false,		false);
					}
				}
			break;
		}
	}
	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "xch_rt_tp_cd": 
				with (comboObj) {
					InsertItem(0, "VVD",				"V");
					InsertItem(1, "Customer",			"I");
					InsertItem(2, "Daily",				"D");
					InsertItem(3, "China",				"C");
					InsertItem(4, "Monthly Accounting",	"A");
					
					Code = "V";
					
					SetColAlign("left");
					MultiSelect = false;
					UseAutoComplete = true;
					UseCode = true;
					DropHeight = 190;
					BackColor = "#CCFFFD";
				}
			break;
		
			case "svc_scp_cd":
				with(comboObj) {
					SetColAlign("left");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 190;
					ValidChar(2,1);
					MaxLength = 3;
				}
			break;
			
			case "io_bnd_cd":
				with (comboObj) {
					InsertItem(0, "All",	"ALL");
					InsertItem(1, "O/B",	"O");
					InsertItem(2, "I/B",	"I");
					
					Code = "ALL";
					
					SetColAlign("left");
					SetColWidth("50");
					MultiSelect = false;
					UseCode = true;
					DropHeight = 190;
				}
			break;
		}
	}
	
	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initControl() {
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function obj_keypress() {
		var formObj = document.form;
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".-");
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement,"-");
			break;
			case "engup":
				switch(event.srcElement.name){
					case "chg_curr_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper');
					break;
					
					case "locl_curr_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper');
					break;
					
					case "vvd_cd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					
					case "port_cd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					
					case "cust_cnt_cd":
						//영문대문자만입력하기	        
						ComKeyOnlyAlphabet('upper');
					break;
				}
			break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
            break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function obj_activate() {
		var formObj = document.form;
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
	}
	
	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function obj_keyup() {
		var formObj = document.form;
		
		switch (event.srcElement.name) {
			case "from_day":
				var fmDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fmDt.length == 8) {
					formObj.to_day.focus();
				}
	 		break;
			case "from_month":
				var fmDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fmDt.length == 6) {
					formObj.to_month.focus();
				}
	 		break;
			case "cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObj.cust_seq.focus();
				}
	 		break;
		}
	}

	/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "eff_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			
			case "cust_seq":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
					var valueCustSeq = formObj.cust_seq.value;
					formObj.cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);

					var custCd = "";
					//if (formObj.cust_nm.value != '') {
					if (formObj.cust_seq.value != '') {
						custCd = formObj.cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
					}
					else {
						custCd = "";
						formObj.cust_seq.focus();
					}
					
					for(i=sheetObject.rowCount; i>0; i--){
						sheetObject.CellValue2(i, "cust_code") = custCd;
					}
				}
				else {
					//formObj.cust_nm.value = '';
					
					for(i=sheetObject.rowCount; i>0; i--){
						sheetObject.CellValue2(i, "cust_code") = "";
					}
				}
			break;
			
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
				
				var sStr = ComGetEtcData(sXml,"svc_scp_cd1")+"|KOJ";
				var arrStr = sStr.split("|");
				
				MakeComboObject(formObj.svc_scp_cd, arrStr);
			break;
			
			case IBSEARCH_ASYNC02: // 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH02;
					
					var xchRtTpCd = formObj.xch_rt_tp_cd.Code;
					
					if (xchRtTpCd == "A") {
						formObj.from_dt.value = ComReplaceStr(formObj.from_month.value,"-","");
						formObj.to_dt.value = ComReplaceStr(formObj.to_month.value,"-","");
					}
					else if (xchRtTpCd == "D") {
						formObj.from_dt.value = ComReplaceStr(formObj.from_day.value,"-","");
						formObj.to_dt.value = ComReplaceStr(formObj.to_day.value,"-","");
						formObj.svc_scp_cd.value = "";
						formObj.io_bnd_cd.value = "";
					}
					else {
						formObj.from_dt.value = ComReplaceStr(formObj.from_day.value,"-","");
						formObj.to_dt.value = ComReplaceStr(formObj.to_day.value,"-","");
					}
					
					//alert(FormQueryString(formObj));
					
					sheetObj.DoSearch("FNS_INV_0006GS.do", FormQueryString(formObj));
				}
			break;
		}
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH_ASYNC02:      //문서번호 조회
				with(formObj){
					if(xch_rt_tp_cd.text == "") {
						ComShowCodeMessage("INV00004");
						xch_rt_tp_cd.focus();
						return false;
					}
					
					var xchRtTpCd = formObj.xch_rt_tp_cd.Code;
					//VVD 조회
					if (xchRtTpCd == "V") {
						if(vvd_cd.value == "") {
							ComShowCodeMessage("INV00004");
							vvd_cd.focus();
							return false;
						}
					}
					//Customer 조회
					else if (xchRtTpCd == "I") {
						if(cust_cnt_cd.value == "") {
							ComShowCodeMessage("INV00004");
							cust_cnt_cd.focus();
							return false;
						}
						if(cust_seq.value == "") {
							ComShowCodeMessage("INV00004");
							cust_seq.focus();
							return false;
						}
						if(from_day.value == "") {
							ComShowCodeMessage("INV00004");
							from_day.focus();
							return false;
						}
						if(to_day.value == "") {
							ComShowCodeMessage("INV00004");
							to_day.focus();
							return false;
						}
					}
					//Daily 조회 
					else if (xchRtTpCd == "D") {
						if(locl_curr_cd.value == "") {
							ComShowCodeMessage("INV00004");
							locl_curr_cd.focus();
							return false;
						}
						if(from_day.value == "") {
							ComShowCodeMessage("INV00004");
							from_day.focus();
							return false;
						}
						if(to_day.value == "") {
							ComShowCodeMessage("INV00004");
							to_day.focus();
							return false;
						}
					}
					//China 조회
					else if (xchRtTpCd == "C") {
						if(locl_curr_cd.value == "") {
							ComShowCodeMessage("INV00004");
							locl_curr_cd.focus();
							return false;
						}
						if(from_day.value == "") {
							ComShowCodeMessage("INV00004");
							from_day.focus();
							return false;
						}
						if(to_day.value == "") {
							ComShowCodeMessage("INV00004");
							to_day.focus();
							return false;
						}
					}
					//Monthly Accounting
					else if (xchRtTpCd == "A") {
						if(from_month.value == "") {
							ComShowCodeMessage("INV00004");
							from_month.focus();
							return false;
						}
						if(to_month.value == "") {
							ComShowCodeMessage("INV00004");
							to_month.focus();
							return false;
						}
					}

				}
			break;
		}

		return true;
	}
	
	/** 
	 * xch_rt_tp_cd 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} Index_Code
	 * @param {object} Text
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function xch_rt_tp_cd_OnChange(comboObj, Index_Code, Text) {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		var xchRtTpCd = formObj.xch_rt_tp_cd.Code;
		
		formObj.chg_curr_cd.value = "";
		formObj.locl_curr_cd.value = "";
		formObj.vvd_cd.value = "";
		formObj.port_cd.value = "";
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
		formObj.from_day.value = "";
		formObj.to_day.value = "";
		formObj.from_month.value = "";
		formObj.to_month.value = "";
		formObj.svc_scp_cd.Code = "ALL";
		formObj.io_bnd_cd.Code = "ALL";

		//VVD 조회
		if (Index_Code == 'V') {
			ComEnableObject(formObj.chg_curr_cd,	true);	//선택
			ComEnableObject(formObj.locl_curr_cd,	true);	//선택
			ComEnableObject(formObj.vvd_cd,			true);	//필수
			ComEnableObject(formObj.port_cd,		true);	//선택
			ComEnableObject(formObj.cust_cnt_cd,	false);	// X
			ComEnableObject(formObj.cust_seq,		false);	// X
			ComEnableObject(formObj.from_day,		false);	// X
			ComEnableObject(formObj.to_day,			false);	// X
			ComEnableObject(formObj.from_month,		false);	// X
			ComEnableObject(formObj.to_month,		false);	// X
			
			formObj.vvd_cd.className = "input1";

			formObj.svc_scp_cd.Enable = true;				//선택
			formObj.io_bnd_cd.Enable = true;				//선택
			
			document.getElementById('Date_A').style.display = "block";
			document.getElementById('Date_B').style.display = "none";
			
			sheetObj.Reset();
			initSheet(sheetObj,1);
			
			formObj.vvd_cd.focus();
		}
		//Customer 조회
		else if (Index_Code == 'I') {
			ComEnableObject(formObj.chg_curr_cd,	true);	//선택
			ComEnableObject(formObj.locl_curr_cd,	true);	//선택
			ComEnableObject(formObj.vvd_cd,			false);	// X
			ComEnableObject(formObj.port_cd,		false);	// X
			ComEnableObject(formObj.cust_cnt_cd,	true);	// 필수
			ComEnableObject(formObj.cust_seq,		true);	// 필수
			ComEnableObject(formObj.from_day,		true);	// 필수
			ComEnableObject(formObj.to_day,			true);	// 필수
			ComEnableObject(formObj.from_month,		false);	// X
			ComEnableObject(formObj.to_month,		false);	// X
			
			formObj.cust_cnt_cd.className = "input1";
			formObj.cust_seq.className = "input1";
			formObj.from_day.className = "input1";
			formObj.to_day.className = "input1";

			formObj.svc_scp_cd.Enable = false;				// X
			formObj.io_bnd_cd.Enable = true;				// 선택

			document.getElementById('Date_A').style.display = "block";
			document.getElementById('Date_B').style.display = "none";
			
			sheetObj.Reset();
			initSheet(sheetObj,1);
			
			formObj.cust_cnt_cd.focus();
		}
		//Daily 조회 
		else if (Index_Code == 'D') {
			ComEnableObject(formObj.chg_curr_cd,	true);	//선택
			ComEnableObject(formObj.locl_curr_cd,	true);	//필수
			ComEnableObject(formObj.vvd_cd,			false);	// X
			ComEnableObject(formObj.port_cd,		false);	// X
			ComEnableObject(formObj.cust_cnt_cd,	false);	// X
			ComEnableObject(formObj.cust_seq,		false);	// X
			ComEnableObject(formObj.from_day,		true);	//필수
			ComEnableObject(formObj.to_day,			true);	//필수
			ComEnableObject(formObj.from_month,		false);	// X
			ComEnableObject(formObj.to_month,		false);	// X
			
			formObj.locl_curr_cd.className = "input1";
			formObj.from_day.className = "input1";
			formObj.to_day.className = "input1";

			formObj.svc_scp_cd.Enable = false;				// X
			formObj.io_bnd_cd.Enable = false;				// X

			document.getElementById('Date_A').style.display = "block";
			document.getElementById('Date_B').style.display = "none";
			
			sheetObj.Reset();
			initSheet(sheetObj,1);
			
			formObj.locl_curr_cd.focus();
		}
		//China 조회
		else if (Index_Code == 'C') {
			ComEnableObject(formObj.chg_curr_cd,	true);	//선택
			ComEnableObject(formObj.locl_curr_cd,	true);	//필수
			ComEnableObject(formObj.vvd_cd,			false);	// X
			ComEnableObject(formObj.port_cd,		false);	// X
			ComEnableObject(formObj.cust_cnt_cd,	false);	// X
			ComEnableObject(formObj.cust_seq,		false);	// X
			ComEnableObject(formObj.from_day,		true);	//필수
			ComEnableObject(formObj.to_day,			true);	//필수
			ComEnableObject(formObj.from_month,		false);	// X
			ComEnableObject(formObj.to_month,		false);	// X
			
			formObj.locl_curr_cd.className = "input1";
			formObj.from_day.className = "input1";
			formObj.to_day.className = "input1";

			formObj.svc_scp_cd.Enable = false;				// X
			formObj.io_bnd_cd.Enable = true;				//선택
			
			document.getElementById('Date_A').style.display = "block";
			document.getElementById('Date_B').style.display = "none";
			
			sheetObj.Reset();
			initSheet(sheetObj,1);
			
			formObj.locl_curr_cd.focus();
		}
		//Monthly Accounting
		else if (Index_Code == 'A') {
			ComEnableObject(formObj.chg_curr_cd,	false);	// X
			ComEnableObject(formObj.locl_curr_cd,	true);	//선택
			ComEnableObject(formObj.vvd_cd,			false);	// X
			ComEnableObject(formObj.port_cd,		false);	// X
			ComEnableObject(formObj.cust_cnt_cd,	false);	// X
			ComEnableObject(formObj.cust_seq,		false);	// X
			ComEnableObject(formObj.from_day,		false);	// X
			ComEnableObject(formObj.to_day,			false);	// X
			ComEnableObject(formObj.from_month,		true);	//필수
			ComEnableObject(formObj.to_month,		true);	//필수
			
			formObj.from_month.className = "input1";
			formObj.to_month.className = "input1";

			formObj.svc_scp_cd.Enable = false;				// X
			formObj.io_bnd_cd.Enable = false;				// X
			
			document.getElementById('Date_A').style.display = "none";
			document.getElementById('Date_B').style.display = "block";
			
			sheetObj.Reset();
			initSheet(sheetObj,1);
			
			formObj.from_month.focus();
		}
	}
	
	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.xch_rt_tp_cd.focus();
	}
	
	/** 
	 * Scope List select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		var defaultCode = "";
		
		cmbObj.InsertItem(0, "All", "ALL");
		for (var i = 1; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
		//cmbObj.BackColor = "#CCFFFD";
		cmbObj.Code = "ALL";
	}
	
	/** 
	 * 팝업창(COM_ENS_051)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		document.all.port_cd.value = colArray[3];
	}
	
	/**
     * RD Object 초기화 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initRdConfig(rdObject)
     * </pre>
     * @param {rdviewer} rdObject Rdviewer Object
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */ 
    function initRdConfig(rdObject){
	     var Rdviewer = rdObject;
	     Rdviewer.style.height = 0;
	     Rdviewer.style.width = 0;
	    
	     Rdviewer.AutoAdjust = true;
	     Rdviewer.ViewShowMode(0);
	    
		 Rdviewer.setbackgroundcolor(128,128,128);
		 Rdviewer.SetPageLineColor(128,128,128);
	 }
	
	/**
	 * print화면 오픈
	 * @param vvd VVD
	 * @param pod POD
	 * @param del DEL
	 * @param bl BL No.
	 */
	function rdOpen(xch_rt_tp_cd) {
		var sXml = "";
		var form = document.form;
		var sheet_obj1 = document.sheet1;

		sXml = "<?xml version='1.0' ?><SHEET>";
		sXml += RD_GetDataSearchXml(sheet_obj1, 1);
		sXml += "<ETC>";
		sXml += "<chg_curr_cd>" + form.chg_curr_cd.value + "</chg_curr_cd>"
		sXml += "<locl_curr_cd>" + form.locl_curr_cd.value + "</locl_curr_cd>"
		sXml += "<vvd_cd>" + form.vvd_cd.value + "</vvd_cd>"
		sXml += "<port_cd>" + form.port_cd.value + "</port_cd>"
		sXml += "<svc_scp_cd>" + form.svc_scp_cd.value + "</svc_scp_cd>"
		sXml += "<io_bnd_cd>" + form.io_bnd_cd.value + "</io_bnd_cd>"
		sXml += "<cust_cnt_cd>" + form.cust_cnt_cd.value + "</cust_cnt_cd>"
		sXml += "<cust_seq>" + form.cust_seq.value + "</cust_seq>"
		sXml += "<from_day>" + form.from_day.value + "</from_day>"
		sXml += "<to_day>" + form.to_day.value + "</to_day>"
		sXml += "<from_month>" + form.from_month.value + "</from_month>"
		sXml += "<to_month>" + form.to_month.value + "</to_month>"
		sXml += "</ETC>";
		sXml += "</SHEET>";
		
		rdObjects[0].SetRData(sXml);
		
		var rdFile = "";
		if(xch_rt_tp_cd == "V"){
			rdFile = "FNS_INV_0006_VVD.mrd";
		}else if(xch_rt_tp_cd == "I"){
			rdFile = "FNS_INV_0006_CUSTOMER.mrd";
		}else if(xch_rt_tp_cd == "D"){
			rdFile = "FNS_INV_0006_DAILY.mrd";
		}else if(xch_rt_tp_cd == "C"){
			rdFile = "FNS_INV_0006_CHINA.mrd";
		}else if(xch_rt_tp_cd == "A"){
			rdFile = "FNS_INV_0006_MONTHLY.mrd";
		}
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemasterdatamgt/arinvoiceexratemgt/report/";
			
		rdObjects[0].FileOpen(RD_path + rdUrl + rdFile, RDServer + "/rpagenuminit [1] /riprnmargin /rwait");
		//rdObjects[0].FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + "/rpagenuminit [1] /riprnmargin /rwait");		
		rdObjects[0].CMPrint ();
	}
	
	/* 개발자 작업  끝 */