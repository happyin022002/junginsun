/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0066.js
*@FileTitle : Invoice Summary Inquiry by Date & Source
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.29 박정진
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
	 * @class FNS_INV_0066 : FNS_INV_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0066() {
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

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	

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
	 * @version 2009.07.29
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrive":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
				case "btn_new":
					removeAll(formObject);
				break;
	
				case "btn_downExcel":
					sheetObject1.SpeedDown2Excel(-1);
				break;
				
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.from_date, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.to_date, 'yyyy-MM-dd');
				break;
				
				case "btns_cust1": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_nm = sheetObject1.UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
				break;
				
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObject.port.value;
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
				break;
				
				case "btns_SCP": //SCP 조회버튼
					var v_svc_scp_cd = formObject.scope.value;
					var classId = "COM_ENS_0L1";
					var param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
			
					ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 500, 450, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
				break;
			} // end switch
		}
		catch(e) {
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
	 * @version 2009.07.29
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
	 * @version 2009.07.29
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
	 * @version 2009.07.29
	 */
	function loadPage() {
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		for(i=0;i<sheetObjects.length;i++){
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
			 ComEndConfigSheet(sheetObjects[i]);
		}
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
	 * @version 2009.07.29
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		var cnt = 0;
		var sheetID = sheetObj.id;
		
		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
				
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
				
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var dpPrcsKnt = formObject.dp_prcs_knt.value;
					var arCurrCd = formObject.ar_curr_cd.value;
					
					var dateOption = formObject.date_option.options[formObject.date_option.selectedIndex].text; 
					
					var HeadTitle1 = "|Office|"+dateOption+"|Bound|Count|USD AMT|USD EQV AMT|LCL AMT|3RD CUR EQV AMT|TTL LCL AMT";

					var headCount = ComCountHeadTitle(HeadTitle1);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
				
					if (arCurrCd == 'USD') {
						colHidden(4) = true;
						colHidden(5) = true;
					}
					else {
						colHidden(4) = false;
						colHidden(5) = false;
					}
					
					var rowCnt = 0;
					if (dpPrcsKnt > 0) {
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	00,		daCenter,		false,		"hdnStatus");
						InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		"ar_ofc_cd",		false,		"",		dfDateYmd,			0,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		"date_value",		false,		"",		dfDateYmd,			0,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		"io_bnd_cd",		false,		"",		dfNone,				0,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		60,		daRight,		false,		"count",			false,		"",		dfNullInteger,		0,		false,		false);
						
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"usd_amt",			false,		"",		dfNullFloat,		2,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"usd_eqv_amt",		false,		"",		dfNullFloat,		dpPrcsKnt,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"lcl_amt",			false,		"",		dfNullFloat,		dpPrcsKnt,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"etc_cur_eqv_amt",	false,		"",		dfNullFloat,		dpPrcsKnt,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		140,	daRight,		false,		"ttl_lcl_amt",		false,		"",		dfNullFloat,		dpPrcsKnt,		false,		false);
					}
					else {
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	00,		daCenter,		false,		"hdnStatus");
						InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		"ar_ofc_cd",		false,		"",		dfDateYmd,			0,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		"date_value",		false,		"",		dfDateYmd,			0,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		"io_bnd_cd",		false,		"",		dfNone,				0,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		60,		daRight,		false,		"count",			false,		"",		dfNullInteger,		0,		false,		false);
						
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"usd_amt",			false,		"",		dfNullFloat,		2,		false,		false);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"usd_eqv_amt",		false,		"",		dfInteger);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"lcl_amt",			false,		"",		dfInteger);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		135,	daRight,		false,		"etc_cur_eqv_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		140,	daRight,		false,		"ttl_lcl_amt",		false,		"",		dfInteger);
					}
				
					//CountPosition = 0;
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
	 * @param comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "date_option": 
				with (comboObj) {
					InsertItem(0, "Good Date",   "G");
		            InsertItem(1, "I/F Date",    "I");
		            InsertItem(2, "Eff. Date",   "E");
		            InsertItem(3, "Issue Date",  "S");
		            InsertItem(4, "S/A Date",    "A");
		            
		            Code = "G";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
				break;
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
			case "chg_cd": 
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,0);
					MaxLength = 3;
				}
			break;
			
			case "rev_src_cd":
				with (comboObj) {
					InsertItem(0, "All",    "A");

		    		MultiSelect = true;
		    		UseCode = true;

		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;		    		
		            CheckCode("A") = true;
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
	 * @version 2009.07.29
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
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
	 * @version 2009.07.29
	 */
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "engup":
				switch(event.srcElement.name){
					case "act_cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
	    	        case "act_cust_seq":	    	        	
	    	        	// 숫자만입력하기
	        	        ComKeyOnlyNumber(event.srcElement);
					break;
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
	    	        case "scope":
	    	        	//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "port":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
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
	 * @version 2009.07.29
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
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
	 * @version 2009.07.29
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "act_cust_seq":	        	
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value != '') {
					var valueCustSeq = formObject.act_cust_seq.value;
					formObject.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
				else {
					formObject.act_cust_seq.value = '';
					formObject.cust_nm.value = '';
					//formObject.act_cust_seq.focus();
				}
	        break;
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	/** 
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "to_date":
				//조회기간 입력값 체크(1달)ComReplaceStr(formObject.from_date.value,"-","");
				var nextDate = ComGetDateAdd(formObject.from_date.value, "M", 3);
				
				if (ComReplaceStr(formObject.to_date.value,"-","") >= ComReplaceStr(nextDate,"-","")) {
					ComShowCodeMessage("INV00043");
					formObject.to_date.focus();
				}		
			break;
	    }
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
	 * @version 2009.07.29
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_date":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_date.focus();
				}
	 		break;
			case "act_cust_cnt_cd":
				var actCustCntCd = ComReplaceStr(event.srcElement.value,"-","");
				
				if (actCustCntCd.length == 2) {
					formObject.act_cust_seq.focus();
				}
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
	 * @version 2009.07.29
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.Reset();
					
					formObj.f_cmd.value = SEARCH;

					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					if (arrStr2[1] != undefined) { 
						formObj.office.value = arrStr2[1];
					}
					else {
						formObj.office.value = formObj.ar_ofc_cd.text;
					}
					
					formObj.chg_cd.text;
	     			
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0066GS.do", FormQueryString(formObj));
	     			
		 			// 소수점 자리수 설정
		 			formObj.dp_prcs_knt.value = ComGetEtcData(sXml,"dp_prcs_knt");
		 			initSheet(sheetObj,1);
		 			
		 			sheetObj.MessageText("SubSum") = "Total";
		 			sheetObj.MessageText("Sum") = "Grand Total";
		 			sheetObj.LoadSearchXml(sXml);
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH01;
 				var sXml = sheetObj.GetSearchXml("FNS_INV_0066GS.do", FormQueryString(formObj));
		
 				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
 				var arrStr = sStr.split("|");
		
 				MakeComboObject(formObj.ar_ofc_cd, arrStr);
		
 				var arrStr2 = arrStr[1].split("^");
 				
 				var ar_ofc_cd = arrStr2[3];
 				formObj.ar_ofc_cd.text = ar_ofc_cd;

	 			// 로그인한 사용자의  office 정보를 가져온다.
	 			var ofcStr;
	 			var ofcStr2;
	 			
	 			for (var i=0; i < arrStr.length; i++) {
	 				var sStr9 = arrStr[i].split("^");
	 				if (sStr9[1] == ar_ofc_cd) {
	 					ofcStr = arrStr[i]
	 				}
	 			}
	 			var ofcStr2 = ofcStr.split("^");

 				// OFC의 AR CUR
	 			formObj.ar_curr_cd.value = ofcStr2[4];
	 			
		        //chg code 세팅
				var sStrChg = ComGetEtcData(sXml,"chg_cd");
				var arrStrChg = sStrChg.split("|");
				MakeComboObject2(formObj.chg_cd, arrStrChg);
				
				formObj.rev_src_cd.RemoveAll();
				formObj.rev_src_cd.InsertItem(0, "All",    	"A");
				formObj.rev_src_cd.CheckCode("A") = true;
 			break;
 			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.office.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;

				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = ComReplaceStr(formObj.act_cust_seq.value,",","");
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.act_cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.act_cust_seq, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.act_cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
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
	 * @version 2009.07.29
	 */
	function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
			 if(((from_date.value == "") && (to_date.value == "")) && (vvd.value == "")) {          		 
				 ComShowCodeMessage("INV00004");
				 from_date.focus();
				 return false;
			 }
			 var nextDate = ComGetDateAdd(from_date.value, "M", 1);
			 if (to_date.value >= nextDate) {
				 ComShowCodeMessage("INV00043");
				 to_date.focus();
				 return false;
			 }
		 }
		 return true;
	}
	
    /** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.07.29
     */  	
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		formObj.from_date.focus();
	}
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.07.29
	 */ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var arOfcCd = document.form.ar_ofc_cd.text;
		
		// 단일 오피스로 조회할 경우 bound 에 따라 소계
		if (arOfcCd != 'All') {
			sheetObj.showSubSum("io_bnd_cd", "4|5|6|7|8|9", 2, true, false, 1);
		}
		// 전체 오피스로 조회할 경우 오피스에 따라 소계
		else {
			sheetObj.showSubSum("ar_ofc_cd", "4|5|6|7|8|9", -1, false, false, 1);
		}
	}
	
	/** 
	 * ar_ofc_cd 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} Index_Code
	 * @param {object} Text
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function ar_ofc_cd_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		
		// OFFICE
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		sheetObjects[0].RemoveAll();
		if (arrStr2!='') {
			formObj.ar_curr_cd.value = arrStr2[4];
		}
		initSheet(sheetObjects[0],1);
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
	 * @version 2009.07.29
	 */
	function removeAll(formObj) {
		formObj.reset();
	 	
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.from_date.focus();
	}

	/** 
	 * office code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		
		cmbObj.InsertItem(0, "All", "ALL^");
	}
	
	/** 
	 * ar_ofc_cd 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
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
    function ar_ofc_cd_OnChange(ar_ofc_cd , code, text) {
    	var formObject = document.form;
    	var expensInfo1 = code.split("^");
    	
    	ComSetObjValue(formObject.office,expensInfo1[1]);
    }
	 
	/** 
	 * rev_src_cd 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} s_index
	 * @param {object} s_code
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function rev_src_cd_OnCheckClick(comboObj, s_index, s_code) {
		if(s_code == "A"){
			if(comboObj.CheckCode("A") == true){
				comboObj.CheckCode("BL") = false;
		        comboObj.CheckCode("CS") = false;
		        comboObj.CheckCode("CC") = false;
		        comboObj.CheckCode("CA") = false;
		        comboObj.CheckCode("CC") = false;
		        comboObj.CheckCode("IV") = false;
		        comboObj.CheckCode("IC") = false;
		        comboObj.CheckCode("CT") = false;
		        comboObj.CheckCode("OC") = false;
		        comboObj.CheckCode("EQ") = false;
		        comboObj.CheckCode("TS") = false;
		        comboObj.CheckCode("DM") = false;
		        comboObj.CheckCode("DT") = false;
		        comboObj.CheckCode("RD") = false;
		        comboObj.CheckCode("TH") = false;
		        comboObj.CheckCode("TP") = false;
		        comboObj.CheckCode("TM") = false;
		        comboObj.CheckCode("TN") = false;
		        comboObj.CheckCode("WC") = false;
		        comboObj.CheckCode("LS") = false;
		        comboObj.CheckCode("DO") = false;
			}
		} else {
			comboObj.CheckCode("A") = false;
		}
	}
	
	/** 
	 * currency code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		cmbObj.InsertItem(0, "All", "");
		for (var i = 2; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
		}
		cmbObj.Index = 0;
	}
	
	/** 
	 * Rev Type 콤보박스의 변화에 따라 Rev Source 콤보박스를 재설정한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} thisObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function doChange(thisObj){
 		var val = thisObj.options[thisObj.selectedIndex].value;
 		var targetE = document.form.rev_src_cd;
 		targetE.RemoveAll();

 		targetE.InsertItem(0, "All",    	"A");
 		if(val == 'B'){
 			targetE.InsertItem(1, "BBL",    "BL");
 			targetE.InsertItem(2, "BCS",    "CS");
 			targetE.InsertItem(3, "BCC",    "CC"); 		
 		} else if(val == 'C'){
 			targetE.InsertItem(1, "CCA",    "CA");
 			targetE.InsertItem(2, "CCC",    "CC");
 		} else if(val == 'M'){
 			targetE.InsertItem(1, "MIV",    "IV");
 			targetE.InsertItem(2, "MIC",    "IC");
 			targetE.InsertItem(3, "MCT",    "CT");
 			targetE.InsertItem(4, "MOC",    "OC");
 			targetE.InsertItem(5, "MEQ",    "EQ");
 			targetE.InsertItem(6, "MTS",    "TS");
 			targetE.InsertItem(7, "MDM",    "DM");
 			targetE.InsertItem(8, "MDT",    "DT");
 			targetE.InsertItem(9, "MRD",    "RD");
 			targetE.InsertItem(10, "MTH",    "TH");
 			targetE.InsertItem(11, "MTP",    "TP");
 			targetE.InsertItem(12, "MTM",    "TM");
 			targetE.InsertItem(13, "MTN",    "TN");
 			targetE.InsertItem(14, "MWC",    "WC");
 			targetE.InsertItem(15, "MLS",    "LS");
 			targetE.InsertItem(16, "MDO",    "DO");
 		}
 		targetE.text = "All";
	}
	
	/** 
	 * 콤보박스에 옵션을 추가한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} text
	 * @param {object} value
	 * @param {message} e
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function addOption(text,value, e){
	    var o = new Option(text,value);
	    try{
	        e.add(o);
	    }catch(ee){
	        e.add(o, null);
	    }
	}

	/** 
	 * 콤보박스의 옵션을 전부 삭제한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} thisObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function removeCombo(e){
	    for(var i = 0, limit = e.options.length; i < limit - 1; ++i){
	        e.remove(1);
	    }
	}

	/** 
	 * 팝업창(FNS_INV_0013)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function getFNS_INV_0013() {
		
	}
	
	/** 
	 * 팝업창(COM_ENS_051_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		document.all.port.value = colArray[3];
	}

	/** 
	 * 팝업창(COM_ENS_0L1_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function getCOM_ENS_0L1_1(rowArray) {
		var colArray = rowArray[0];	
		document.all.scope.value = colArray[3];
	}
	 
	/** 
	 * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}
	
	/* 개발자 작업  끝 */