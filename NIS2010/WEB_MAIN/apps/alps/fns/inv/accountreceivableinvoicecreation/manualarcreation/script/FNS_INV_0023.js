/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0023.js
*@FileTitle : Other Revenue Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.04.27 박정진
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
     * @class fns_inv_0023 : fns_inv_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0023() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnScrollNext	= sheet1_OnScrollNext;
    }
    
   	/* 개발자 작업	*/

    //공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
				break;
								
				case "btn_new":
					removeAll(formObj);
				break;
				
				case "btn_downExcel":
					sheetObj1.SpeedDown2Excel(-1);
					//doActionIBSheet(sheetObj2,formObj,SEARCHLIST);
				break;
				
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.fm_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.to_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_cust1": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObj.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObj.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObj.act_cust_cnt_cd.value;
					var v_cust_nm = sheetObj1.UrlEncoding(formObj.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
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
	 * @version 2009.04.27
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
	 * @version 2009.04.27
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
	 * @version 2009.04.27
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
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
	 * @version 2009.04.27
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//alert(sheetObj.GetSheetHeight(19));
					//높이 설정
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					var HeadTitle = "|Seq|Office|G/L Date|Creation Date|Slip No|CR Acct|B/L No|I/F No|Actual Cust|Cur|Amount|Description|User ID|User Name";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "HidStatus");
					InitDataProperty(0, cnt++ , dtSeq,	   		 40,    daCenter,  true,    "Seq");
					InitDataProperty(0, cnt++ , dtData,     	 60,    daCenter,  true,    "ar_ofc_cd",   		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,     	 90,    daCenter,  true,    "gl_eff_dt",     	false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,     	 90,    daCenter,  true,    "cre_dt",   		false,    "",      dfNone,		0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    		 140,   daCenter,  true,    "slp_no",  			false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 70,    daCenter,  true,    "acct_cd",  		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 100,   daCenter,  true,    "bl_src_no",    	false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 100,   daCenter,  true,    "ar_if_no",    		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 90,    daCenter,  true,    "act_cust_cnt_cd", 	false,    "",      dfNone,		0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    		 50,    daCenter,  true,    "curr_cd",  		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 100,   daRight,   true,    "chg_amt",  		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 200,   daLeft,    true,    "chg_rmk",  		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 85,    daCenter,  true,    "cre_usr_id",  		false,    "",      dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 100,   daCenter,  true,    "usr_nm", 			false,    "",      dfNone,		0,	false,		false);
					
					CountPosition = 2;
					
					WaitImageVisible=false;
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
	 * @version 2009.04.27
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
			case "acct_cd":
				with (comboObj) {
					MultiSelect = false;
					DropHeight = 200;
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
	 * @version 2009.04.27
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerForm ('focus', 'obj_activate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
		axon_event.addListenerForm ('blur', 'obj_deactivate', form);
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
	 * @version 2009.04.27
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
					case "slp_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					
					case "ar_if_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;

					case "act_cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;

					case "port":	
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
	 * @version 2009.04.27
	 */
	function obj_activate() {
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
	 * @version 2009.04.27
	 */
	function obj_keyup() {
		var formObj = document.form;
		switch (event.srcElement.name) {
			case "fm_dt":
				var fmDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fmDt.length == 8) {
					formObj.to_dt.focus();
				}
	 		break;
			case "act_cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObj.act_cust_seq.focus();
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
	 * @version 2009.04.27
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "gl_eff_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			
			case "act_cust_seq":
				if (formObj.act_cust_cnt_cd.value != '' && formObj.act_cust_seq.value != '') {
					var valueCustSeq = formObj.act_cust_seq.value;
					formObj.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);
				}
				else {
					formObj.cust_nm.value = '';
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
	 * @version 2009.04.27
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
		
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		 			formObj.office.value = arrStr2[1];

		 			ComOpenWait(true); 
		 			
		 			sheetObj.DoSearch("FNS_INV_0023GS.do", FormQueryString(formObj));
		 			
		 			ComOpenWait(false); 
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
	 			formObj.f_cmd.value = SEARCH02;
	 			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			
	 			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
	 			var arrStr = sStr.split("|");
	 			var arrStr2 = arrStr[1].split("^");
	 			var ar_ofc_cd = arrStr2[3];
	 			
	 			var office_cnt_cd = "";
	 				
	 			//office
	 			MakeComboObject(formObj.ar_ofc_cd, arrStr);
	 			
	 			for (var i = 0; i < arrStr.length; i++) {
	 				var arrStr3 = arrStr[i].split("^");
	 				
		 			if (arrStr3[1] == ar_ofc_cd) {
		 				office_cnt_cd = arrStr3[6].substring(0,2);
		 			}
	 			}
	 			
	 			formObj.ar_ofc_cd.text = ar_ofc_cd;
	 			formObj.office_cnt_cd.value = office_cnt_cd;
			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.office.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);

				var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");    
				if (cust_nm != undefined) {
					formObj.cust_nm.value = cust_nm;
				} else {
					formObj.cust_nm.value = "";
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
	 * @version 2009.04.27
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
		case IBSEARCH:      //Retrieve
			with(formObj){
				if(fm_dt.value == "") {
					ComShowCodeMessage("INV00004");
					fm_dt.focus();
					return false;
				}
				if(to_dt.value == "") {
					ComShowCodeMessage("INV00004");
					to_dt.focus();
					return false;
				}
				
				if(ar_ofc_cd.text == "") {
					ComShowCodeMessage("INV00004");
					ar_ofc_cd.focus();
					return false;
				}
				var nextDate = ComGetDateAdd(fm_dt.value, "M", 3);
				if (to_dt.value >= nextDate) {
					ComShowCodeMessage("INV00043");
					to_dt.focus();
					return false;
				}
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
     * @version 2009.04.27
     */	  	
	function sheet1_OnLoadFinish(sheetObj){
		initControl();
		
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC10);
		
		MakeComboObject2(document.form.acct_cd);
		
		
		document.form.fm_dt.focus();
	}
	
	/**
	 * 셀을 클릭했을때 발생하는 이벤트 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.04.27
	 **/
	function sheet1_OnDblClick(sheetObj, Row, Col) {
	   	var formObj = document.form;

   		var arIfNo = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "ar_if_no"), ",", "");
   		var arOfcCd = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "ar_ofc_cd"), ",", "");
		//var arOfcCd = formObj.ar_ofc_cd.text;
		
		var classId = "FNS_INV_0022";
		var param = '?pgmNo=FNS_INV_0022&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId;
		
		ComOpenWindow('/hanjin/FNS_INV_0022_01.do' + param, 'FNS_INV_0022', 'width=1100,height=600');
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
	 * @version 2009.04.27
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.InsertItem(0, "All", "ALL^");
		cmbObj.BackColor = "#CCFFFD";
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
	 * @version 2009.12.01
	 */
    function ar_ofc_cd_OnChange(ar_ofc_cd , code, text) {
    	var formObject = document.form;
    	var expensInfo1 = code.split("^");
    	
    	ComSetObjValue(formObject.office,expensInfo1[1]);
    }
	
	/** 
	 * account code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function MakeComboObject2(cmbObj) {
		cmbObj.RemoveAll();
		
		var formObj = document.form;
    	var officeCntCd = formObj.office_cnt_cd.value;

		//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
	    var sTextKr = " \t \t "
	    	        +"|411911\tMIS. REVENUE(CNTR)-EQ RENTAL\t부대수입-컨테이너-EQ Rental"
			        +"|411531\tNON SHIPPING REVENUE-BUILDING RENTAL INCOME\t비해운수입-임대수입"
			        +"|411591\tNON SHIPPING REVENUE-OTHERS\t비해운수입-기타"
			        +"|411541\tNON SHIPPING REVENUE-PERSON SERVICE\t비해운수입-용역수입"
			        +"|411915\tMIS. REVENUE(CNTR)-OTHER\t부대수입-겉네이너-OTHER"
			        +"|212111\tV.A.T RECEIVED\t예수부가가치세"
			        +"|957112\tCLEARING AR AND FA FOR RETIREMENT\t정산-유형자산처분(AR/FA)"
			        +"|954111\tCLEARING AR AND AP\t정산-채권채무상계(AR/AP)"
			        +"|712911\tMIS.INCOME\t잡이익"
			        +"|422011\tMIS.INCOME\t잡이익";
	    			+"|411917\tVIP Incentive\tVIP";
		var sText = " \t "
			        +"|411911\tMIS. REVENUE(CNTR)-EQ RENTAL"
			        +"|411531\tNON SHIPPING REVENUE-BUILDING RENTAL INCOME"
			        +"|411591\tNON SHIPPING REVENUE-OTHERS"
			        +"|411541\tNON SHIPPING REVENUE-PERSON SERVICE"
			        +"|411915\tMIS. REVENUE(CNTR)-OTHER"
			        +"|212111\tV.A.T RECEIVED"
			        +"|957112\tCLEARING AR AND FA FOR RETIREMENT"
			        +"|954111\tCLEARING AR AND AP"
			        +"|712911\tMIS.INCOME"
			        +"|422011\tMIS.INCOME"
			        +"|411917\tVIP Incentive\tVIP";
    	
    	var comboVal = "|411911|411531|411591|411541|411915|212111|957112|954111|712911|422011|411917";
		var comboTxt = "";
		
		if (officeCntCd == "KR" || officeCntCd == "HQ") {
			cmbObj.SetColAlign("left|left|left");
			cmbObj.SetColWidth("65|310|190");
			
			comboTxt = sTextKr;
		}
		else {
			cmbObj.SetColAlign("left|left");
			cmbObj.SetColWidth("65|310");
			
			comboTxt = sText;
		}

		var arrTxt = comboTxt.split("|");
		var arrVal = comboVal.split("|");
		
		for (var i = 1; i < arrTxt.length;i++ ) {
			if (officeCntCd == "KR" || officeCntCd == "HQ") {
				var arrTxt2 = arrTxt[i].split("\t");
				cmbObj.InsertItem(i-1, arrTxt2[0]+"|"+arrTxt2[1]+"|"+arrTxt2[2], arrVal[i]);
			}
			else {
				var arrTxt2 = arrTxt[i].split("\t");
				cmbObj.InsertItem(i-1, arrTxt2[0]+"|"+arrTxt2[1], arrVal[i]);
			}
		}
		//cmbObj.BackColor = "#CCFFFD";
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
	 * @version 2009.04.27
	 */
	function removeAll(formObj) {
		formObj.reset();

		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		
		MakeComboObject2(document.form.acct_cd);
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
	 * @version 2009.04.27
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObj = document.form;
		
		formObj.act_cust_cnt_cd.value = colArray[8];
		formObj.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value = colArray[4];
	}


	/* 개발자 작업  끝 */