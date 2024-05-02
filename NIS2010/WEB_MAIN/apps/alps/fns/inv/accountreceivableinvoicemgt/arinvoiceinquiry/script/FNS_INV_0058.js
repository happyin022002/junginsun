/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0058.js
*@FileTitle : Invoice Issue Term Analysis
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.04 박정진
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
	 * @class fns_inv_0058 : fns_inv_0058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0058() {
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
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	//RD
    var rdObjects = new Array();
	var rdCnt = 0;
	
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
		var sheetObject1 = sheetObjects[0];
		
		var rdObject = rdObjects[0];
		/*******************************************************/
		var formObject = document.form;
		
		setRadioValue(formObject, srcName);
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "btn_new":
					removeAll(formObject);
				break;
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1);
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
			
					//ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 920, 660, 'getFNS_INV_0013', '1,0,1,1,1', true);
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_nm = sheetObject1.UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
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
		for(i=0;i<sheetObjects.length;i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		//RD
		initRdConfig(rdObjects[0]);
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
					// 높이 설정
					style.height = 440;
					
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					var HeadTitle = "|Aging|Aging|Aging|Total|~ -10D|-10~0D|0~10D|10~20D|20~30D|30~40D|40~50D|50D~";
					var HeadTitle1 = "|Office|Month|Bound|Average|Average|Average|Average|Average|Average|Average|Average|Average";
					var HeadTitle2 = "| | | |Count|Count|Count|Count|Count|Count|Count|Count|Count";
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 3, 2, 2, 100);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
					InitHeadMode(false, true, false, true, false, false);
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);
					InitHeadRow(2, HeadTitle2, false);
					
					var rowCnt = 0;
					
					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,	30,    daCenter,  false,   "ibflag");
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daCenter,  true,	   "office",		false,    "",    dfNone, 		0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daCenter,  true,    "month",	  		false,    "",    dfDateYm,		0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daCenter,  true,    "io_bnd_cd",   	false,    "",    dfNone, 		0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "total_average",	false,    "",    dfNullFloat, 	1);
					
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "below",	  		false,    "",    dfNullFloat, 	1);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "average10_0",	false,    "",    dfNullFloat, 	1);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "average0_10",	false,    "",    dfNullFloat, 	1);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "average10_20",	false,    "",    dfNullFloat, 	1);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "average20_30",  false,    "",    dfNullFloat, 	1);
					
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "average30_40",	false,    "",    dfNullFloat, 	1);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "average40_50",	false,    "",    dfNullFloat, 	1);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "over",   		false,    "",    dfNullFloat, 	1);
					
					rowCnt++;
					cnt = 0;
					
					InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,	30,    daCenter,  false,   "ibflag");
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daCenter,  true,	   "office",		false,    "",    dfNone, 		0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daCenter,  true,    "month",	  		false,    "",    dfDateYm,		0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daCenter,  true,    "io_bnd_cd",   	false,    "",    dfNone, 		0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "total_cnt",		false,    "",    dfInteger, 	0);
					
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "below_cnt",	 	false,    "",    dfInteger, 	0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "cnt10_0",   	false,    "",    dfInteger, 	0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "cnt0_10",		false,    "",    dfInteger, 	0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "cnt10_20",	  	false,    "",    dfInteger, 	0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "cnt20_30",   	false,    "",    dfInteger, 	0);
					
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "cnt30_40",		false,    "",    dfInteger, 	0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "cnt40_50",	  	false,    "",    dfInteger, 	0);
					InitDataProperty(rowCnt, cnt++ , dtData,    		80,    daRight,   false,   "over_cnt",   	false,    "",    dfInteger, 	0);
					
		            //RangeBackColor(1, 11, 1, 15) = RgbColor(222, 251, 248);    // alps
					DataBackColor = RgbColor(235,245,225);
                    DataAltanateBackColor = RgbColor(255,255,255);  //  짝수행 색상 변경, 해당페이지의 경우에는  sheet명_OnSearchEnd() 같이 적용
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
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
	                //LineColor = "#ffffff";
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
			case "rev_tp_cd": 
				with (comboObj) {
					InsertItem(0, "All",    "A");
		            InsertItem(1, "B/L",    "B");
		            InsertItem(2, "C/A",    "C");
		            InsertItem(3, "MRI",    "M");
		            
		            Code = "A";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 200;
				}
				break;
		}
	}
	
	/** 
	 * RD 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {RdObject} rdObject
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
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
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
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
		switch(event.srcElement.name){
			case "from_date":
			case "to_date":
			case "act_cust_cnt_cd":
			case "act_cust_seq":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
				event.srcElement.select();
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
					formObject.cust_nm.value = '';
				}
	        break;
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
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
	 * @version 2009.10.19
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
			// 날짜 입력 input 뒤에 콤보박스가 올 경우 에러 메시지 2회 표시됨. 이를 방지하기 위해서 더미 input으로 처리한다. 
			case "date_blank":
				var issDtBlank = event.srcElement.value;
				
				if (issDtBlank == 'blank') {
					formObject.rev_tp_cd.focus();
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
	 * @version 2009.10.19
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
	
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					if (formObj.ar_ofc_cd.text != "All") {
						formObj.office.value = arrStr2[1];
					}
					else {
						formObj.office.value = "A";
					}
					
	     			sheetObj.DoSearch("FNS_INV_0058GS.do", FormQueryString(formObj));
	     			
	     			for(var j = 1; j <= sheetObj.RowCount+2; j++){
						if (sheetObj.CellValue(j, "io_bnd_cd") == "ALL") {
			     			sheetObj.RowBackColor(j) = sheetObj.SumBackColor;
			     			j++;
			     			sheetObj.RowBackColor(j) = sheetObj.SumBackColor;
						}
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
				formObj.office.value = ar_ofc_cd;
			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.office.value = arrStr2[1];
				formObj.f_cmd.value = SEARCH03;

				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;
	
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
	 * @version 2009.10.19
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(ar_ofc_cd.text == "") {
				ComShowCodeMessage("COM12114", "Office");
				ar_ofc_cd.focus();
				 return false;
			}
			if((from_date.value == "") && (to_date.value == "")) {          		 
				ComShowCodeMessage("INV00004");
				from_date.focus();
				return false;
			}
			else {
				var nextDate = ""; 
				if(ar_ofc_cd.text == "All") {
					nextDate = ComGetDateAdd(from_date.value, "M", 1);
				} else {
					nextDate = ComGetDateAdd(from_date.value, "M", 6);
				}
				
				if (to_date.value >= nextDate) {
					ComShowCodeMessage("INV00043");
					to_date.focus();
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
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 */ 	  	
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
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
	 * @version 2009.10.19
	 */
 	function MakeComboObject(cmbObj, arrStr) {
 		cmbObj.RemoveAll(); 
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ar_ofc_cd = arrStr2[1];
 			
 			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
 		}
 		cmbObj.InsertItem(0, 	"All",	"A");
 		cmbObj.BackColor = "#CCFFFD";
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
		
		formObj.from_date.focus();
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
	 * @version 2009.10.19
	 */
	function getFNS_INV_0013() {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
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
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}
	 
	/**
	 * Effective Option 버튼 처리  <br>
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} srcName	필수 document 내의 객체명
	 * @return 없음
	 * @author 박정진
	 * @version 2009.05.26
	 */ 
	function setRadioValue(FormObj, srcName){
		switch(srcName) {
			case "date_option_sa" :      
				FormObj.date_option_sa.checked=true;
				FormObj.date_option_sd.checked=false;
				FormObj.date_option.value="A";
				break;
			case "date_option_sd" :      
				FormObj.date_option_sa.checked=false;
				FormObj.date_option_sd.checked=true;
				FormObj.date_option.value="S";
				break;
		}
	}
	
	/** 
	 * Rd 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {RdObject} rdObject
	 * @param  {object} formObj    
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function rdOpen(rdObject, formObj){
		var Rdviewer = rdObject;
		
		var actCustCntCd = formObj.act_cust_cnt_cd.value;
		var actCustSeq = formObj.act_cust_seq.value;
		var revTpCd = formObj.rev_tp_cd.Code;

		var rdParam = "/rp " + "['"+formObj.ar_ofc_cd.text+"']['"+formObj.from_date.value+"']['"+formObj.to_date.value+"']";
		
		if (actCustCntCd != '') {
			rdParam = rdParam +"['"+formObj.act_cust_cnt_cd.value+"']";
		}
		else {
			rdParam = rdParam +"[]";
		}
		if (actCustSeq != '') {
			rdParam = rdParam +"['"+formObj.act_cust_seq.value+"']";
		}
		else {
			rdParam = rdParam +"[]";
		}
		if (revTpCd != 'A') {
			rdParam = rdParam +"['"+formObj.rev_tp_cd.Code+"']";
		}
		else {
			rdParam = rdParam +"[]";
		}
		
		formObj.com_mrdPath.value      = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/FNS_INV_0528.mrd";
		formObj.com_mrdArguments.value = rdParam;
		
		ComOpenRDPopup();
	}
	/* 개발자 작업  끝 */