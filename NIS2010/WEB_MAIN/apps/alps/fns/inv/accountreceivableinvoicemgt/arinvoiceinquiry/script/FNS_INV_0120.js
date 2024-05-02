/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName   : FNS_INV_0120.js
*@FileTitle  : Report for Reverse Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.04.18 최도순
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
	 * @class fns_inv_0120 : fns_inv_0120 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0120() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
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
	 * @version 2010.12.14
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
	             	cal.select(formObject.fm_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.to_dt, 'yyyy-MM-dd');
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
	 * @author KIM HYUN HWA
	 * @version 2010.12.14
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
	 * @author KIM HYUN HWA
	 * @version 2010.12.14
	 */
	function loadPage() {
		sheet1 = sheetObjects[0];
		sheetCnt = sheetObjects.length ;
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
				
		var formObj = document.form;
		
		doActionIBSheet(sheet1, formObj, IBSEARCH_ASYNC20);
		
		initControl();
		
		formObj.fm_dt.focus();
	
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
	 * @author KIM HYUN HWA
	 * @version 2010.12.14
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 380;
					
					//전체 너비 설정
					SheetWidth = mainTable1.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					var HeadTitle = "";
				
						HeadTitle = "|Office|G/L Date|Customer \n Code|Customer Name|Country \n Code|Customer \n VAT ID|Invoice \n Amount|Invoice No.|B/L No.|POR|POL|POD|DEL";
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성          [ROW, COL,  DATATYPE,  		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,    		50,     daCenter,  false,	"ar_ofc_cd",	 false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		65,     daCenter,  false,	"gl_eff_dt",      	 false,    "",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,    		65,     daCenter,  false,	"cust_cd", false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		230,  	daLeft,    false,	"cust_lgl_eng_nm",     	 false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		60,     daCenter,  false,	"cnt_cd",      false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		90,  	daLeft,    false,	"cust_rgst_no",     	 false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		60,  	daRight,   false,	"inv_amt",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		70,		daCenter,  false,	"inv_no",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		90,		daCenter,  false,	"bl_src_no",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		50,		daCenter,  false,	"por_cd",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		50,		daCenter,  false,	"pol_cd",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		50,		daCenter,  false,	"pod_cd",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		50,		daCenter,  false,	"del_cd",     	false,    "",	dfNone);
					
					
					CountPosition = 2;
					
					WaitImageVisible=false;
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
	 * @author KIM HYUN HWA
	 * @version 2009.05.04
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		//axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
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
	 * @author KIM HYUN HWA
	 * @version 2009.05.04
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
	
				case "if_no":
					//영문대문자+숫자입력하기
					ComKeyOnlyAlphabet('uppernum');
				break;
				case "inv_no":
					//영문대문자+숫자입력하기
					ComKeyOnlyAlphabet('uppernum');
				break;
				case "ar_ofc_cd":
					//영문대문자만입력하기
					ComKeyOnlyAlphabet('upper'); 
				break;
				case "ar_hd_qtr_ofc_cd":
					//영문대문자만입력하기
					ComKeyOnlyAlphabet('upper'); 
				break;
				case "bl_no":
					//영문대문자+숫자입력하기
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
	 * @author KIM HYUN HWA
	 * @version 2009.05.04
	 */
	function obj_activate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "fm_dt":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			case "to_dt":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			default:
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
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
	 * @author KIM HYUN HWA
	 * @version 2009.05.04
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "fm_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
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
	 * @author KIM HYUN HWA
	 * @version 2009.05.04
	 */
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		
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
	 * @author KIM HYUN HWA
	 * @version 2009.05.04
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "fm_dt":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_dt.focus();
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
	 * @author KIM HYUN HWA
	 * @version 2010.12.14
	 */
	function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
                    sheetObjects[0].RemoveAll();
		 			ComOpenWait(true);					
					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0120GS.do", FormQueryString(formObj));
	 				
                    sheetObjects[0].Reset();
		 			initSheet(sheetObjects[0], 1);
	     			sheetObj.LoadSearchXml(sXml);
	     			
	     			ComOpenWait(false); 
	
				}
			break;
			
 		    case IBSEARCH_ASYNC20: 
 		    	ComOpenWait(true);
 				
 				formObj.f_cmd.value = SEARCH02;
 				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
 				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
 				var arrStr = sStr.split("|");
 			
 				MakeComboObject2(formObj.ar_ofc_cd, arrStr);
 			
 				var arrStr2 = arrStr[1].split("^");
 				var ar_ofc_cd = arrStr2[3];
 				formObj.ar_ofc_cd.text = ar_ofc_cd;
 				formObj.ofc_cd.value = ar_ofc_cd;
 				
 				ComOpenWait(false);
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
	 * @author KIM HYUN HWA
	 * @version 2010.12.22
	 */
	function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
			 var arOfcCd = formObj.ar_ofc_cd.text;
			 var nextDate = "";
			 
			 if(((fm_dt.value == "") && (to_dt.value == "")) ) {          		 
				 ComShowCodeMessage("INV00004");
				 fm_dt.focus();
				 return false;
			 }
			 		
			 nextDate = ComGetDateAdd(fm_dt.value, "M", 12);
			 
			 if (to_dt.value >= nextDate) {
				 ComShowCodeMessage("INV00043");
				 to_dt.focus();
				 return false;
			 }
		 }
		 return true;
	}

	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author KIM HYUN HWA
	 * @version 2010.12.22
	 */
	function removeAll(formObj) {
		formObj.reset();
		

		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC20);
		
	    formObj.fm_dt.focus();
	}

	 /**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
		}
	
		cmbObj.DropHeight = 190;
	}       
	 

      
  	/**
 	 * 날짜조건의 값을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 	 * 
	 	 * @param formObj
	 * @return 없음
	 * @see #
	 * @author 
	 * @version 2009.06.03
 	 */
 	function setDefaultDateValue(formObj) {
 		today= new Date();
 		
 		var year  =today.getYear();
 		var mon  =today.getMonth()+1;
 		var sday =today.getDate();
 		
 		formObj.fm_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday-11,2,"0");
 		formObj.to_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
 	}     
  
 	/**
 	 * 콤보박스 ar_ofc_cd 변경시 실행되는 function<br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *   ar_ofc_cd_OnChange(document.form.ar_ofc_cd,'HAMBB','HAMBB');
 	 * </pre>
 	 * @param object comboObj
 	 * @param String value
 	 * @param String text
 	 * @author Choi Do Soon
 	 * @version 2009.10.06
 	 */	
 	function ar_ofc_cd_OnChange(comboObj,value,text){ 
 		sheetObjects[0].RemoveAll();
 	
 		arrStr = value.split("^");    	
 		document.form.ofc_cd.value = arrStr[1];
 	}  	 
     	 
      
	/* 개발자 작업  끝 */