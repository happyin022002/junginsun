	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0085.js
	 *@FileTitle : (India) Freight and Charge List
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.09
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.06.09 정휘택
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
	 * fns_inv_0085 : fns_inv_0085 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0085()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0085() {
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
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var cal = new ComCalendar();
			
			switch(srcName) {
	
			case "btn_retrieve":
				if(formObject.date_option[0].checked) {
				   var dateOption = "V";
				}else {
				   var dateOption = "S";
				}
	   			chkOption(dateOption);
               // sheetObjects[0].Reset();
	 			initSheet(sheetObjects[0], 1, dateOption);
     			
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						
				break;
	
			case "btn_new":
				
			    formObject.vvd.value = "";
				formObject.vsl_eng_nm.value = "";
				// 2010.09.06  추가 KHH
			    formObject.from_date.value = ""; 
			    formObject.to_date.value = "";
				formObject.port2.value = "";
		    	formObject.date_option[0].checked = true;
				chkOption("V");
				break;
			// 2010.09.06  추가 KHH						
			case "btns_calendar1":      		
				cal.setDisplayType('date');
				cal.select(form.from_date, 'yyyy-MM-dd');
				break;
				// 2010.09.06  추가 KHH	
			case "btns_calendar2":
				cal.setDisplayType('date');
				cal.select(form.to_date, 'yyyy-MM-dd');
				break;
				
			case "btn_downExcel":
				//sheetObject1.SpeedDown2Excel(-1);
				
				if (sheetObject1.RowCount > 0) {
					
					var bound = formObject.bound.value == "I" ? "I\/B" : "O\/B";

					sheetObject2.DataInsert(-1);
					if(formObject.date_option[0].checked) {
					   sheetObject2.CellValue(1, 0) = "VVD : "+formObject.vvd.value+" "+formObject.vsl_eng_nm.value;
					   sheetObject2.CellValue(1, 1) = "VVD : "+formObject.vvd.value+" "+formObject.vsl_eng_nm.value;
					   sheetObject2.CellValue(1, 2) = "VVD : "+formObject.vvd.value+" "+formObject.vsl_eng_nm.value;
					   sheetObject2.CellValue(1, 3) = "VVD : "+formObject.vvd.value+" "+formObject.vsl_eng_nm.value;
					   sheetObject2.CellValue(1, 4) = "VVD : "+formObject.vvd.value+" "+formObject.vsl_eng_nm.value;
					   sheetObject2.CellValue(1, 5) = "VVD : "+formObject.vvd.value+" "+formObject.vsl_eng_nm.value;
					} else{
					   sheetObject2.CellValue(1, 0) = "S/A Date : "+formObject.from_date.value+" ~ "+formObject.to_date.value;
					   sheetObject2.CellValue(1, 1) = "S/A Date : "+formObject.from_date.value+" ~ "+formObject.to_date.value;
					   sheetObject2.CellValue(1, 2) = "S/A Date : "+formObject.from_date.value+" ~ "+formObject.to_date.value;
					   sheetObject2.CellValue(1, 3) = "S/A Date : "+formObject.from_date.value+" ~ "+formObject.to_date.value;
					   sheetObject2.CellValue(1, 4) = "S/A Date : "+formObject.from_date.value+" ~ "+formObject.to_date.value;
					   sheetObject2.CellValue(1, 5) = "S/A Date : "+formObject.from_date.value+" ~ "+formObject.to_date.value;
					}
					sheetObject2.DataInsert(-1);
					sheetObject2.CellValue(2, 0) = "BOUND : "+bound;
					sheetObject2.CellValue(2, 1) = "BOUND : "+bound;
					sheetObject2.CellValue(2, 2) = "BOUND : "+bound;
					sheetObject2.CellValue(2, 3) = "BOUND : "+bound;
					sheetObject2.CellValue(2, 4) = "BOUND : "+bound;
					sheetObject2.CellValue(2, 5) = "BOUND : "+bound;
					sheetObject2.DataInsert(-1);
					sheetObject2.CellValue(3, 0) = "PORT : "+formObject.port2.value;
					sheetObject2.CellValue(3, 1) = "PORT : "+formObject.port2.value;
					sheetObject2.CellValue(3, 2) = "PORT : "+formObject.port2.value;
					sheetObject2.CellValue(3, 3) = "PORT : "+formObject.port2.value;
					sheetObject2.CellValue(3, 4) = "PORT : "+formObject.port2.value;
					sheetObject2.CellValue(3, 5) = "PORT : "+formObject.port2.value;
					
					sheetObject2.RowMerge(1) = true;
					sheetObject2.RowMerge(2) = true;
					sheetObject2.RowMerge(3) = true;
				
					sheetObject2.Down2Excel4FreeForm(-1);
					sheetObject1.SpeedDown2Excel(-1, true, false);
				}
				
				sheetObject2.RemoveAll(); 
				
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function setSheetObject(sheetObj){
	
		sheetObjects[sheetCnt++] = sheetObj;
	
	}    
	
   /**
	 * Vessel 명 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getVslNm()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getVslNm() {
		var sheetObject = sheetObjects[1];
		var formObject = document.form;
		if (formObject.vvd.value != "") {
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10);	 	
		} else {
			formObject.vsl_eng_nm.value = "";
		}
	} 
	
   /**
	 * 업무 자바스크립트 OnKeyPress 이벤트 Catch <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    initControl()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function initControl() {
	    // Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'objKeypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'objActivate', form);
		axon_event.addListenerForm ('beforedeactivate', 'objDeactivate', form);
		axon_event.addListenerForm ('keyup', 'objKeyup', document.form); 
	
	}
	
    /**
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeypress()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objKeypress() {
		switch(event.srcElement.dataformat){
		case "float":
			// 숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, "."); break;
	
		case "int":
			// 숫자만 입력하기
			ComKeyOnlyNumber(event.srcElement); break;
	
		case "engup":
	
			switch(event.srcElement.name){
			case "vvd":	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;
			case "port2":	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;
			}         	    	
	
			break;
	
		default:
			// 숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
		}
	}
	
    /**
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objActivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objActivate() {
		// 마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
	
	}
	
	/**
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objDeactivate(){
	
		switch(event.srcElement.name){
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(event.srcElement);
		}
	
	} 
	
	  /**
	   * 업무 자바스크립트 OnKeyUp 이벤트 처리 <br>
	   * <br><b>Example :</b>
	   * <pre>
	   *    objKeyup()
	   * </pre>
	   * @param 없음
	   * @return 없음
	   * @author 김현화
	   * @version 2010.09.07
	  */
		function objKeyup() {
			var formObject = document.form;
			var srcName = window.event.srcElement.getAttribute("name");	
			if (srcName == "from_date" ) {
				var v_from_date = formObject.from_date.value
				if (v_from_date.length == 8) {
					formObject.to_date.focus();	   
	    		 		
				}
			}	
		}
	 
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function loadPage() {
		 chkOption("V");
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1, "V");
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj, 0,headType)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */ 
	function initSheet(sheetObj,sheetNo,headType ) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 465;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//MergeSheet = msAll;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(13, 0, 0, true);
				
				//var dateOption = formObj.date_option.value;
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
				
				var HeadTitle1 = "";
				var HeadTitle2 = "";
				if (headType == "V") {
				  	 HeadTitle1 = "B/L No.|CNTR|CNTR|Prepaid|Prepaid|Prepaid|Prepaid|Collect|Collect|Collect|Collect|SubTotal|Ex. Rate";
			         HeadTitle2 = "B/L No.|20 |40 |USD AMT|EQV AMT|INR AMT|Total|USD AMT|EQV AMT|INR AMT|Total|SubTotal|Ex. Rate";
				}else {
		 		     HeadTitle1 = "VVD|CNTR|CNTR|Prepaid|Prepaid|Prepaid|Prepaid|Collect|Collect|Collect|Collect|SubTotal|Ex. Rate";
					 HeadTitle2 = "VVD|20 |40 |USD AMT|EQV AMT|INR AMT|Total|USD AMT|EQV AMT|INR AMT|Total|SubTotal|Ex. Rate";
								}
					
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daCenter,		true,		"bl_no",		false,		"",		dfNone,				0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"cnt20",		false,		"",		dfInteger,		    2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"cnt40",		false,		"",		dfInteger,		    2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"p_usd_amt",	false,		"",		dfNullFloat,		2,		false, false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"p_eqv_amt",	false,		"",		dfNullFloat,		2,		false, false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"p_inr_amt",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"p_inr_tot",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"c_usd_amt",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"c_eqv_amt",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"c_inr_amt",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		false,		"c_inr_tot",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,		80,		daRight,		true,		"s_inr_tot",	false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		true,		"ex_rate",		false,		"",		dfNullFloat,		2,		false);
	
				//CountPosition = 0;
			}
			break;
			
		case "sheet2":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 100;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msHeaderOnly;
				MergeSheet = msAll;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
	
				var HeadTitle1 = "1|1|1|1|1|1";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				RowHidden(0) = true;
				
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daLeft,		true,		"1",				false,		"",		dfNone,				0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daLeft,		true,		"2",				false,		"",		dfNone,				0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daLeft,		true,		"3",				false,		"",		dfNone,				0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daLeft,		true,		"4",				false,		"",		dfNone,				0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daLeft,		true,		"5",				false,		"",		dfNone,				0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		100,	daLeft,		true,		"6",				false,		"",		dfNone,				0,		false);
				
			}
			break;
			
		
		}
	}
	
    /**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH_ASYNC10: // vsl name 조회
	
		formObj.f_cmd.value = SEARCH06;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
	
    	var vsl_eng_nm = ComGetEtcData(sXml,"vsl_eng_nm");    
		if (vsl_eng_nm != undefined) {
			formObj.vsl_eng_nm.value = vsl_eng_nm;
		} else {
			formObj.vsl_eng_nm.value = "";
		}			
	
		break;
	
		case IBSEARCH:      //조회
			
		if(validateForm(sheetObj,formObj,sAction)) {
			if(formObj.port2.value == "") {
				formObj.port.value = "IN";
			}else{
				formObj.port.value = formObj.port2.value
			}
			
			formObj.f_cmd.value = SEARCH;	            
			sheetObj.DoSearch("FNS_INV_0085GS.do", FormQueryString(formObj));
	
			sheetObj.SumText(0,"vvd")="Grand Total";		
	
	
		}
		break;
	
		case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction))	
			break;
	
		case IBINSERT:      // 입력
	
		break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     validateForm(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			var v_vvd = vvd.value;
			if(date_option[0].checked && v_vvd.length != 9) {          		 
				ComShowCodeMessage("COM12114", "VVD");
				vvd.focus();
				return false;
			}
			if(date_option[1].checked) {
		       if(from_date.value > to_date.value) {
				ComShowCodeMessage("INV00043");     
				return false;
			    }
	
			    if((from_date.value == "") || (to_date.value == "")) {          		 
				   ComShowCodeMessage("INV00043");    
				   from_date.focus();
				   return false;
			    }
	
			    if(ComGetDaysBetween(from_date.value, to_date.value) > 30) {
				   ComShowCodeMessage("INV00043");        		 
				  return false;
			   }
			}
			var v_port = port2.value;
			if(v_port != "" && v_port.substr(0,2) != "IN") {          		 
				ComShowCodeMessage("INV00050");
				port2.focus();
				return false;
			}
		}
	
		return true;
	}
	 
	 /**
		 * 라디오버튼 선택시 유형에 따라 화면 세팅<br>
		 * <br><b>Example : </b>
		 * <pre>
		 *   chkOption('V');
		 * </pre>
		 * @param String checkedVal
		 * @author Kim hyun Hwa
		 * @version 2010.09.09
		 */
		function chkOption(checkedVal){
			if(checkedVal=="S"){
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
		
				ComShowObject(document.form.btns_calendar1,true);
				ComShowObject(document.form.btns_calendar2,true);
				document.form.from_date.disabled=false;
				document.form.to_date.disabled=false;
				document.form.vvd.disabled=true;
				document.form.vvd.value = "";
				document.form.vsl_eng_nm.value = "";
			    document.form.from_date.className = "input1";
				document.form.to_date.className = "input1";	
				document.form.vvd.className = "input2";
		
			
	
			}else if(checkedVal=="V"){
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
		
				ComShowObject(document.form.btns_calendar1,false);
				ComShowObject(document.form.btns_calendar2,false);
				document.form.from_date.disabled=true;
				document.form.to_date.disabled=true;
				document.form.vvd.disabled=false;
				document.form.from_date.value="";
				document.form.to_date.value="";
				document.form.from_date.className = "input2";
				document.form.to_date.className = "input2";
				document.form.vvd.className = "input1";
		
  					

			}
		} 
	
	/* 개발자 작업  끝 */