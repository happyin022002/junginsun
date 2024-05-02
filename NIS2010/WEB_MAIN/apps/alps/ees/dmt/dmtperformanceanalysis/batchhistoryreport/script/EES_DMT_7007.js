/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7007.js
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.12 최성환
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
     * @class EES_DMT_7007 : EES_DMT_7007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7007() {
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
    var set_day = 30;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var srcObj = window.event.srcElement;
	
			switch (srcName) {
         	case "btns_calendar": //달력 버튼
	         	if(srcObj.style.cursor == "hand") {
		            var cal = new ComCalendarFromTo();
		            cal.select(formObject.fm_dt,  formObject.to_dt,  'yyyy-MM-dd');
	         	}
				break;
			
 			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
	
			case "btn_new":				
				var formObject = document.form; 
			    //var data = getDefaultDate(set_day).split("|");
				//formObject.fm_dt.value = data[1];
				//formObject.to_dt.value = data[0];
				//사용자 Office 의 현재 날짜를 조회한다.
				var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject); 
				//조회한 날짜를 화면의 필드에 매핑 시킨다.
				ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //1달 이전 날짜.
				ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
				
				sheetObject1.RemoveAll();
				break;
	
			} // end switch
		} catch (e) {
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//html컨트롤 이벤트초기화
		initControl();
		
		// 초기 날짜 값 셋팅
		var formObject = document.form; 
//	    var data = getDefaultDate(set_day).split("|");
//		formObject.fm_dt.value = data[1];
//		formObject.to_dt.value = data[0];
		
		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject); 
		//조회한 날짜를 화면의 필드에 매핑 시킨다.
		ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //1달 이전 날짜.
		ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
		
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}

    function initControl() {
		axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',	'obj_activate',    form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); //- 키보드 입력할때
		axon_event.addListener('click', 'obj_click', 'cond_type'); 
	}
    function obj_click() {
    	 doEnableCondObj(event.srcElement.value);
    } 
     	

    //포커스가 나갈 때
    function obj_deactivate(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
	   	 switch(event.srcElement.dataformat){
	        	case "engup":
			    	// 영문대+숫자 
	        		ComKeyOnlyAlphabet('uppernum');
			        break;
	        	default:
		         	// 숫자만입력하기(정수,날짜,시간)
		            ComKeyOnlyNumber(event.srcElement);
	   	 }
    }	
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
	
		switch (sheetID) {
	
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 430;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 7, 100);
	
				var HeadTitle1 = "|Seq.|Date|KOR|KOR|CHN|CHN|SWA|SWA|USA|USA|EUR|EUR";
				var HeadTitle2 = "|Seq.|Date|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto";
	
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
						"Status");
				InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "SEQ", false,
						"", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "bat_his_dt",
						false, "", dfDateYmd, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 105, daCenter, true, "kor_bat_tm",
						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "kor_bat_typ",
						false, "", dfNone, 0, false, false, 50);
	
				InitDataProperty(0, cnt++, dtData, 105, daCenter, true, "chn_bat_tm",
						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "chn_bat_typ",
						false, "", dfNone, 0, false, false, 50);
				
				InitDataProperty(0, cnt++, dtData, 105, daCenter, true, "swa_bat_tm",
						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "swa_bat_typ",
						false, "", dfNone, 0, false, false, 50);
				
				InitDataProperty(0, cnt++, dtData, 105, daCenter, true, "usa_bat_tm",
						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "usa_bat_typ",
						false, "", dfNone, 0, false, false, 50);
				
				InitDataProperty(0, cnt++, dtData, 105, daCenter, true, "eur_bat_tm",
						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "eur_bat_typ",
						false, "", dfNone, 0, false, false, 50);
	
			}
			break;
	
		}
	}

   // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
			case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (!validateDate(formObj)) {
					return false
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("EES_DMT_7007GS.do",	FormQueryString(formObj));
		
				break;
		
		}
	}



   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj, formObj, sAction) {
    	  if(IBSEARCH == sAction ){
  			if(formObj.fm_dt.value.trimAll().lengthByte() <= 0){
  			    ComShowCodeMessage('DMT02002', "Period");
  				ComSetFocus(formObj.clk_stop_fm_dt);
  				return false;
  			} else if(formObj.to_dt.value.trimAll().lengthByte() <= 0){
  				ComShowCodeMessage('DMT02002', "Period");
  				ComSetFocus(formObj.clk_stop_to_dt);
  				return false;
  			} 
  		}
	
		return true;
	}

   /**
     * 날짜값의 유효성검증 프로세스 처리
     */
 	function validateDate(formObj){
 		if (ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) <= 0){
 			ComShowCodeMessage('DMT01020');
 			return false;
 		} 
 		return true;
 	}
     
	function keyPress() {
		var eventKey = window.event.keyCode ;
			if( eventKey == 13 ) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		}
	document.onkeypress = keyPress ;
     
	/* 개발자 작업  끝 */