/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0127.js
*@FileTitle : Invoice Issue Inquiry by Invoice No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.27 박정진
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
	 * @class fns_inv_0127 : fns_inv_0127 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0127() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	var kindValue = "N";
	
	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
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
		var sheetObject1 = sheetObjects[0];
		
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;

				case "btn_new":
					removeAll(formObject);
				break;
				
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.select(formObject.upd_dt, 'yyyy-MM-dd');
				break;
				
				case "btn_DownExcel":
					//sheetObjects[0].SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|chk");		
					sheetObjects[0].SpeedDown2Excel(-1);
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
		 
		var param = '?cust_cnt_cd='+sheetObj.CellValue(Row, 'cust_cnt_cd')
		+'&cust_seq='+ComLpad(sheetObj.CellValue(Row, 'cust_seq'), 6, "0")
		//+'&cust_seq='+sheetObj.CellValue(Row, 'cust_seq')
		+'&cust_lgl_eng_nm='+sheetObj.CellValue(Row, 'cust_lgl_eng_nm');
		
		ComOpenPopup('/hanjin/FNS_INV_0128.do'+param, 950, 480, 'popupFinish1', '1,0,1,1,1,1,1,1', true);
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

		// 오늘날자 설정

		var today = ComGetNowInfo("ymd" );
		form.upd_dt.value = today;
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
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 322;
					//전체 너비 설정
					SheetWidth = clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle = "|Office|Customer Code|Customer Name|Update Date|Reason for control|Credit Control Office|Update By|Sales Rep.||";
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,  false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  false,   "ofc_cd",		false,    "",    dfNone);
					InitDataProperty(0, cnt++ , dtData,    		120,    	daCenter,  false,   "bad_cust_knd_cd",		false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		240,    	daLeft	,	  false,   "cust_lgl_eng_nm",		false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		100,    	daCenter,  false,   "upd_dt",					false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		160,    	daLeft,		 false,   "bad_cust_rsn",			false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		140,    	daCenter,  false,   "cr_clt_ofc_cd",			false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		100,    	daCenter,  false,   "upd_ofc",					false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		80,    		daCenter,  false,   "srep_cd",					false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		100,    	daCenter,  false,   "cust_cnt_cd",				false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		100,    	daCenter,  false,   "cust_seq",					false,    "",    dfNone    ,0,	false,		false);
					
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
	 * @version 2009.10.19
	 */
  	function initCombo(comboObj, comboNo) {
		 
		switch (comboObj.id) {
			case "ar_hd_qtr_ofc_cd":
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
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');		
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
				ComKeyOnlyAlphabet('upper');
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
		switch(event.srcElement.name){
			case "upd_dt":
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
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					
					formObj.f_cmd.value = SEARCH;
					var arrStr2 = formObj.ar_hd_qtr_ofc_cd.Code.split("^");
	     			formObj.ofc_cd.value = arrStr2[1];

	     			ComOpenWait(true);
						     			
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0127GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
	     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
	     			
	     			} else {
	     				
	     				sheetObj.LoadSearchXml(sXml);
	     					     				
	     				if (sheetObj.TotalRows > 0) {
	     					for (var ir = 1; ir <= sheetObj.TotalRows; ir++ ) {
	     						
	     						var custCntCd = sheetObj.CellValue(ir, "cust_cnt_cd");
	     						custCntCd = custCntCd +"-" +  ComLpad(sheetObj.CellValue(ir, "cust_seq"),6, "0");
	     						sheetObj.CellValue2(ir,"bad_cust_knd_cd")  = custCntCd;
	     					}
	     				}
	     				
	     			}
	     			
	     			ComOpenWait(false);	     			
				}
 												
 			break;
 					
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
			
				//AR Office 에서 AR RHQ OFFICE로 변경됨!
				//formObj.f_cmd.value = SEARCH02;
				//var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
				
				//var sStr = "|ALL^ALL^^ALL"+ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");
				//var arrStr = sStr.split("|");
	
				//MakeComboObject(formObj.ar_hd_qtr_ofc_cd, arrStr);

				//var arrStr2 = arrStr[2].split("^");
				////var arrStr2 = arrStr[1].split("^");
				
				//var var_ar_hd_qtr_ofc_cd = arrStr2[3];
				//formObj.ar_hd_qtr_ofc_cd.text = var_ar_hd_qtr_ofc_cd;

				//formObj.f_cmd.value = SEARCH01;
				formObj.f_cmd.value = SEARCH18;
				//var sXml = sheetObj.GetSearchXml("FNS_INV_0069GS.do", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
 				
				var sStr ="|ALL"+ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");
 				var arrStr = sStr.split("|");
		
 				MakeComboObject(formObj.ar_hd_qtr_ofc_cd, arrStr);
 				
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
		
		 with(formObj){

			 if(upd_dt.value == "") {
				 ComShowCodeMessage("COM12114", "Update date");
				 upd_dt.focus();
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
 	 * @version 2009.10.19
 	 */
 	function sheet1_OnLoadFinish(sheetObj){
 		  		
 		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		formObj.upd_dt.focus();
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

//		 cmbObj.RemoveAll(); 
//		
//		for (var i = 1; i < arrStr.length;i++ ) {
//			var arrStr2 = arrStr[i].split("^");
//			var ar_hd_qtr_ofc_cd = arrStr2[1];
//			
//			cmbObj.InsertItem(i-1, ar_hd_qtr_ofc_cd, arrStr[i]);
//		}
//		cmbObj.BackColor = "#CCFFFD";
		
		
		cmbObj.RemoveAll();
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var ar_hd_qtr_ofc_cd = '';
			if (arrStr[i] != '') {
				ar_hd_qtr_ofc_cd = arrStr[i];
			}
			cmbObj.InsertItem(i-1, ar_hd_qtr_ofc_cd, ar_hd_qtr_ofc_cd);
		}
		
		cmbObj.Code = arrStr[1];
		cmbObj.BackColor = "#CCFFFD";
		
	}
	 
	/**
	 * Customer Code 입력시 Customer Name을 가져온다.<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_cust_nm();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function fn_cust_nm(){
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "" )){
			form.cust_seq.value = ComLpad(form.cust_seq.value.trim(), 6, "0");			
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			
			if (cust_nm == undefined) {
				form.cust_nm.value="";
				ComShowCodeMessage("INV00008");
				form.cust_seq.value="";	
				form.cust_seq.focus();				
				return;
			} else { 	
				form.cust_nm.value=cust_nm;
			}
		} else {
			form.cust_nm.value = "";
		}
		
		// 시트를 초기화한다 
		sheetObjects[0].RemoveAll();
		
		// 오늘날자 설정
		var today = ComGetNowInfo("ymd" );
		form.upd_dt.value = today;
	
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
		
		formObj.cust_cnt_cd.focus();
		
		// 오늘날자 설정
		var today = ComGetNowInfo("ymd" );
		form.upd_dt.value = today;
	}
	 
	
	function ar_hd_qtr_ofc_cd_OnChange(comboObj,value,text){ 
		
		// 시트를 초기화한다
		sheetObjects[0].RemoveAll();
		// 오늘날자 설정
		var today = ComGetNowInfo("ymd" );
		form.upd_dt.value = today;
	}
	
	
	function cust_cnt_cd_OnChange(){ 
		
		form.cust_nm.value = "";
		// 시트를 초기화한다
		sheetObjects[0].RemoveAll();
		// 오늘날자 설정
		var today = ComGetNowInfo("ymd" );
		form.upd_dt.value = today;
	}
	
	function upd_dt_OnChange(){ 
		
		// 시트를 초기화한다
		sheetObjects[0].RemoveAll();
		// 오늘날자 설정
		var today = ComGetNowInfo("ymd" );
		form.upd_dt.value = today;
	}
	 
	 
	function fn_ComGetMaskedValue(elNm) {
		
		var formObj = form.upd_dt;			
		var value = formObj.value;
		
		value = ComReplaceStr(value,"-","");
		if(value=='') return;
		if (value.length != 8) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		
		var ret = ComGetMaskedValue(value, "ymd")  ; 
		formObj.value = ret;
		
		// 시트를 초기화한다 
		sheetObjects[0].RemoveAll();
		
	} 
	 
	function fn_kindFlag() {
		

		if (kindValue == "N" &&  form.bad_cust_knd_cd[1].checked == true) {
			sheetObjects[0].RemoveAll();		
			kindValue = "F";
		}

		if (kindValue == "F" &&  form.bad_cust_knd_cd[0].checked == true) {
			sheetObjects[0].RemoveAll();		
			kindValue = "N";
		}

	}

	/** 
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * - curr_cd별 amount 합계를 계산하기 위한 함수
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */ 	  	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		
		var formObject = document.form;

		var curs = "";
		var sums = 0;
	
		if(sheetObj.RowCount > 0) {
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (curs.indexOf(sheetObj.CellValue(i, "curr_cd")) == -1) {
					curs = curs + sheetObj.CellValue(i, "curr_cd") +"|";
					sums = Number(sums) + Number(sheetObj.CellValue(i, "grid_total"));
				}
			}
		}
		
		sheetObj.SumValue(0,"local_total") = sums;
	} 
	/* 개발자 작업  끝 */