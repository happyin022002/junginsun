/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0065.js
*@FileTitle : (Vietnam) Invoice History Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.26 박정진
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
	 * @class FNS_INV_0065 : FNS_INV_0065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0065() {
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
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.iss_fm_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.iss_to_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btn_retrieve":
					// check box 전체 미선택후 처리
					sheetObj.CheckAll("select") = 0;
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
				
				case "btn_new":
					removeAll(formObj);
				break;
				
				case "btn_downexcel":
					sheetObj.SpeedDown2Excel(-1);
				break;
				
				case "btn_save":
					// check box 전체 선택후 처리
					sheetObj.CheckAll("select") = 1;
					
					doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
				
				case "btn_gotosend":
					goToSend(sheetObj,formObj);
				break;
				
				case "btns_cust1": //CUST 조회버튼
					var v_cust_cnt_cd = formObj.cust_cnt_cd.value;
					var v_cust_seq = formObj.cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_cust_cnt_cd = formObj.cust_cnt_cd.value;
					var v_cust_seq = formObj.cust_seq.value;
					var v_cust_nm = sheetObj.UrlEncoding(formObj.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
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
		var formObj = document.form;
		
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
		
		initControl();
		
//		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
//		
//		formObj.inv_no.focus();
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
		
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 420;
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
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					var HeadTitle1 = "|Sel|Issue Date|Invoice No.|Actual INV No.|B/L No.|VVD|Cust. Code|Cust. Name|Local Amount|User ID";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [	ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++,		dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0,		cnt++,		dtCheckBox,		40,		daCenter,	false,		"select",		false,		"",		dfNone,			0,		true,		false);
					InitDataProperty(0,		cnt++,		dtData,			80,		daCenter,	false,		"iss_dt",		false,		"",		dfDateYmd,		0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			80,		daCenter,	false,		"inv_no",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			95,		daCenter,	false,		"act_inv_no",	false,		"",		dfNone,			0,		true,		true,		6);
					InitDataProperty(0,		cnt++,		dtData,			95,		daCenter,	false,		"bl_src_no",	false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0,		cnt++,		dtData,			85,		daCenter,	false,		"vvd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			75,		daCenter,	false,		"customer",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			190,	daLeft,		false,		"cust_nm",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			120,	daRight,	false,		"lcl_amt",		false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			80,		daCenter,	false,		"cre_usr_id",	false,		"",		dfNone,			0,		false,		false);
					
					InitDataValid(0,	"act_inv_no",	vtNumericOnly);	// 숫자만 입력되도록 설정
					
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
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
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
			case "inv_type":		//type 
				with (comboObj) {
					InsertItem(0, "All",		"A");
					InsertItem(1, "FRT",		"F");
		            InsertItem(2, "THC",		"T");
		            InsertItem(3, "DHF",		"H");
		            InsertItem(4, "DMR/DTC",	"D");
		            InsertItem(5, "M&R",		"R");
		            InsertItem(6, "MRI",		"M");
		            InsertItem(7, "SLF",		"S");
		            InsertItem(8, "CLN",		"C");
		            InsertItem(9, "REF",		"E");
		            
		            Code = "A";
		            
		    		MultiSelect = true;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		SetColWidth("80");
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
	 * @version 2009.10.19
	 */
	function initControl() {
		var formObj = document.form;
		
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
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
					case "inv_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;

					case "bl_src_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					
					case "cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
					
					case "vvd":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;

					case "act_inv_no":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					
					case "iss_ofc_cd":	
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
	 * @version 2009.10.19
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
	 * @version 2009.10.19
	 */
	function obj_keyup() {
		var formObj = document.form;
		switch (event.srcElement.name) {
			case "iss_fm_dt":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObj.iss_to_dt.focus();
				}
	 		break;
	 		
			case "iss_to_dt":
				var toDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (toDt.length == 8) {
					formObj.iss_dt_blank.focus();
				}
	 		break;
		
			// 날짜 입력 input 뒤에 콤보박스가 올 경우 에러 메시지 2회 표시됨. 이를 방지하기 위해서 더미 input으로 처리한다. 
			case "iss_dt_blank":
				var issDtBlank = event.srcElement.value;
				
				if (issDtBlank == 'blank') {
					formObj.ar_ofc_cd.focus();
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
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "iss_fm_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			
			case "iss_to_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			
			case "cust_seq":
				if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
					var valueCustSeq = formObj.cust_seq.value;
					formObj.cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC20);
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
	 * @version 2009.04.27
	 */
	function ar_ofc_cd_OnChange(comboObj, Index_Code, Text){ 
		var formObj = document.form;
		
		// OFFICE
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		
		if (arrStr2!='') {
			formObj.copy_cnt.value = arrStr2[18];
		}
		else {
			formObj.copy_cnt.value = "";
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
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.office.value = arrStr2[1];
					
					var sheetObj1 = sheetObjects[0];
					
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0065GS.do", FormQueryString(formObj));
	     			sheetObj1.LoadSearchXml(sXml);
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.office.value = arrStr2[1];
					
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObjects[0].GetSaveString(true);
					
					if (sParam1 == "") {
						return;
					}
					else {
						sParam1 = ComSetPrifix(sParam1, "sheet1_");
						sParam = sParam + "&" + sParam1;
					}
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0065GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						ComShowCodeMessage("INV00051");
					}
					else {
						ComShowCodeMessage("INV00053");
					}
				}
			break;

			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH02;
 				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		
 				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
 				var arrStr = sStr.split("|");
		
 				MakeComboObject(formObj.ar_ofc_cd, arrStr);
		
 				var arrStr2 = arrStr[1].split("^");
 				var ar_ofc_cd = arrStr2[3];
 				formObj.ar_ofc_cd.text = ar_ofc_cd;
 				
 				// InvoiceCopyCnt
 				formObj.copy_cnt.value = arrStr2[18];
 			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.office.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.cust_cnt_cd.value;
				var actCustSeq = ComReplaceStr(formObj.cust_seq.value,",","");
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.cust_cnt_cd, CoInvShowXmlMessage(sXml));
				} else {
					var cust_seq = ComGetEtcData(sXml,"cust_seq");
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_seq.value = ComLpad(cust_seq,6,"0");
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.cust_seq.value = "";
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
	 * @version 2009.10.19
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:      //조회
				with(formObj){
					if (((inv_no.value == "") && (bl_src_no.value == "") && (act_inv_no.value == "")) && (iss_fm_dt.value == "")) {
						ComShowCodeMessage("INV00004");
						iss_fm_dt.focus();
						return false;
					}
					if (iss_fm_dt.value != "" && iss_to_dt.value != "") {
						//조회기간 입력값 체크(1달)
						var nextDate = ComGetDateAdd(iss_fm_dt.value, "M", 1);
						
						if (iss_to_dt.value >= nextDate) {
							ComShowCodeMessage("INV00043");
							iss_to_dt.focus();
							return false;
						}
					}					
					if(ar_ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ar_ofc_cd.focus();
						return false;
					}
					
					if(inv_type.text == "") {
						inv_type.text = 'All';
					}
				}
			break;
			case IBSEARCH_ASYNC11:      //경리환율 조회
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(eff_dt.text == "") {
						ComShowCodeMessage("INV00004");
						eff_dt.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
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
					if(inv_rmk.value == "") {
						ComShowCodeMessage("INV00004");
						inv_rmk.focus();
						return false;
					}
				}
			break;
			case IBSEARCH_ASYNC13:      //Row Add 버튼 클릭시.
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(eff_dt.value == "") {
						ComShowCodeMessage("INV00004");
						eff_dt.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
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
					if(amount.value == "") {
						ComShowCodeMessage("INV00004");
						amount.focus();
						return false;
					}
					if(inv_xch_rt.value == "") {
						ComShowCodeMessage("INV00004");
						inv_xch_rt.focus();
						return false;
					}
				}
			break;
		}
    	return true;
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
	 * @version 2009.10.19
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			
			if (ar_ofc_cd != '') {
				cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
			}
		}
		cmbObj.BackColor = "#CCFFFD";
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
     * @version 2009.07.27
     */  	
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		formObj.inv_no.focus();
	}
	
    /**
     * Est-Act의 값이 음수 이면 Accrual Cost의 값을 강제로 0으로 셋팅한다.<br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param sheetObj
     * @param Row
     * @param Col
     * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col){
    	if(Col===4) {
			var idx = sheetObj.RowCount;
			var actInvNo = sheetObj.CellValue(sheetObj.SelectRow, "act_inv_no");
			
			if (actInvNo != '') {
				sheetObj.CellValue2(sheetObj.SelectRow, "act_inv_no") = ComLpad(sheetObj.CellValue(sheetObj.SelectRow, "act_inv_no") , 6, "0");
				
				var plusPoint = 0;
				var invNo = sheetObj.CellValue(sheetObj.SelectRow, "inv_no");
				
				for (var j = sheetObj.SelectRow + 1 ; j < sheetObj.RowCount + 1 ; j++){
					if (sheetObj.CellValue(j, "act_inv_no") == '') {
						if (invNo != sheetObj.CellValue(j, "inv_no")) {
							plusPoint ++;
						}
						sheetObj.CellValue2(j, "act_inv_no")  = ComLpad(Number(actInvNo) + plusPoint, 6, "0");
						
						invNo = sheetObj.CellValue(j, "inv_no");
					}
					else {
						break;
					}
				}
			}
    	}
    }
	
 	/** 
 	 * inv_type 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
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
	function inv_type_OnCheckClick(comboObj, s_index, s_code) {
		if (s_code == "A") {
			if ((comboObj.Code).indexOf("A") >= 0) {
 				comboObj.CheckCode("F") = false;
 				comboObj.CheckCode("T") = false;
 				comboObj.CheckCode("H") = false;
 				comboObj.CheckCode("D") = false;
 				comboObj.CheckCode("R") = false;
 				comboObj.CheckCode("M") = false;
 				comboObj.CheckCode("S") = false;
 				comboObj.CheckCode("C") = false;
 				comboObj.CheckCode("E") = false;
 			}
 		} else {
 			if ((comboObj.Code).indexOf("A") >= 0) {
 				comboObj.CheckCode("A") = false;
 			}
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
		
		comboObjects[1].Code = "A";
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.inv_no.focus();
	}
	
	/**
	 * Invoice Issue (Email) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openEmail()
	 * </pre>
	 * @param sheetObj
	 * @param formObj
	 * @return 없음
	 * @author 박정진
	 * @version 2009.10.20
	 */ 
	function goToSend(sheetObj, formObj) {
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		var issOfcCd = arrStr2[1];
		formObj.ar_ofc_cd2.value = arrStr2[1];
		
		var invs = "";
		for (var i = 0; i < sheetObj.RowCount; i++) {
			if(sheetObj.CellValue(i+1, 'select') == "1") {
				invs = invs + "'" + sheetObj.CellValue(i+1, 'inv_no') + "',";
			}
		}
		
		if (invs == "") {
			ComShowCodeMessage("INV00025");
		}
		else {
			invs = invs + "''";	
			formObj.invs_email.value = invs;
			
			ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=R", "pop", 1010, 700);
		}
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
	 * @version 2009.10.19
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObj = document.form;
		
		formObj.cust_cnt_cd.value = colArray[8];
		formObj.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value = colArray[4];
	}

	/* 개발자 작업  끝 */