/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0111.jsp
*@FileTitle : HP EDI Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.08.09 최도순
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
	 * @class FNS_INV_0111 : FNS_INV_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0111() {
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
	 * @version 2009.10.05
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
			switch(srcName) {
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.bil_dt, 'yyyy-MM-dd');
	            break;
			
				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			
				case "btn_New":
					removeAll(formObj);
				break;
			
				case "btn_SendBL":
					doActionIBSheet(sheetObj,formObj,IBINSERT);
				break;
				
				case "btn_custNm":
					var Row = 1;
					var Col = 1;
					param = '?pgmNo=FNS_INV_0086&cust_seq='+formObj.cust_seq.value+'&cust_cnt_cd='+formObj.cust_cnt_cd.value;
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
				break;
				
				case "btn_actcust":
					var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObj.cust_cnt_cd.value+'&cust_seq='+formObj.cust_seq.value+'&pop_yn=Y';
					var Row = 1;
					var Col = 1;
					ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break;
				
				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.select(formObj.fm_dt,'yyyy-MM-dd');
					break;
		
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObj.to_dt,'yyyy-MM-dd');
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
	 * @version 2009.10.05
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
	 * @version 2009.10.05
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
	 * @version 2009.10.05
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
		
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01); 	
		
		//버튼 초기화
		ComBtnDisable("btn_SendBL");
		ComBtnDisable("btn_PartialBL");		
		
		formObj.retr_input.focus();
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
	 * @version 2009.10.05
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
		
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 350;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;//msPrevColumnMerge + msHeaderOnly; //msHeaderOnly;
				
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
				
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
				
					var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|Issue Date|Charge Amount|EDI Amount|Currency|VVD|POL|POD|Cust. Code|Shipper's Country Code|Shipper's Country Full Name|Consignee's Country Code|Consignee's Country Full Name|Ship ID|Part No.|Validation|Sent Status|Accept/Reject Status|User ID";
					var headCount = ComCountHeadTitle(HeadTitle);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, true, true, false, false);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
				
					var rowCnt = 0;
					
					//데이터속성              [ROW,      COL,    DATATYPE,       WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	30,		daCenter,		false,		 "ibflag");
					InitDataProperty(rowCnt,	cnt++,	dtCheckBox,		45,		daCenter,		false,		 "DelChk");
					InitDataProperty(rowCnt,	cnt++,	dtSeq,			30,		daCenter,		false,		 "No");
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daCenter,		false,		 "bl_src_no",			true,			"",		dfNone,      	0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		 "inv_no",			false,			"",		dfNone,      	0,		false,		false,		10);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		false,		 "iss_dt",				false,			"",		dfNone,	2,		false,		false,		17);
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daRight,		false,		 "chg_amt",				false,			"",		dfFloat,    2,		false,		false,		17);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		 "edi_amt",				false,			"",		dfFloat,	2,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		false,		 "curr_cd",				false,			"",		dfNone,		0,		false,		false,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		false,		 "vvd",				false,			"",		dfNone,     	0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		 "pol_cd",				false,			"",		dfNone,		0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		 "pod_cd",				false,			"",		dfNone,		0,		false,		false,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		false,		 "cust_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			150,	daCenter,		false,		 "shipper_cnt_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			170,	daCenter,		false,		 "shipper_cnt_nm",				false,			"",		dfNone,			-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			170,	daCenter,		false,		 "consignee_cnt_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			180,	daCenter,		false,		 "consignee_cnt_nm",		false,			"",		dfNone,		0,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		false,		 "ship_id",		false,			"",		dfNone,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		false,		 "part_no",		false,			"",		dfNone,		0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		false,		 "valid",		false,			"",		dfNone,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		false,		 "edi_snd_flg",		false,			"",		dfNone,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			140,	daCenter,		false,		 "hp_ack_cd",		false,			"",		dfNone,    0,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		false,		 "upd_usr_id",		false,			"",		dfNone,    0,		false,		false,		5);
										
					InitDataValid(rowCnt,		 "bl_src_no",	vtEngUpOther,	"0123456789");	// 영대문자, 숫자만 입력되도록 설정
					
					CountPosition = 2;
					
					FrozenCols = 5;
					
					SelectHighLight = false;

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
	 * @version 2009.10.05
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "retr_opt":
				with (comboObj) {
					InsertItem(0, "B/L No.",				"B");
					InsertItem(1, "Invoice No.",			"N");
		            InsertItem(2, "VVD",					"V");
		            InsertItem(3, "Invoice Issue Date",		"I");
		            InsertItem(4, "Good Date",				"G");
		            
		            Code = "B";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;
			
			case "sent_stat":
				with (comboObj) {
					InsertItem(0, "SENT",	"Y");
		            InsertItem(1, "NOT SENT",	"N");
		            
		            Code = "Y";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;
			
			case "change_type":
				with (comboObj) {
					InsertItem(0, "Minus",	"M");
		            InsertItem(1, "Plus",	"P");
		            
		            Code = "M";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
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
	 * @version 2009.10.05
	 */
	function initControl() {
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
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
	 * @version 2009.10.05
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
					case "retr_input":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					
					case "ar_if_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;

					case "cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;

					case "port":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
				}
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
	 * @version 2009.10.05
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
	 * @version 2009.10.05
	 */
	function obj_keyup() {
		var formObj = document.form;
		
		switch (event.srcElement.name) {
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
	 * @version 2009.10.05
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			
			case "cust_seq":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
					var valueCustSeq = formObj.cust_seq.value;
					formObj.cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);

					var custCd = "";
					if (formObj.cust_nm.value != '') {
						custCd = formObj.cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
					}
					else {
						custCd = "";
						formObj.cust_seq.focus();
					}
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
	 * 업무 자바스크립트 OnChange 이벤트 처리<br>
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
	function obj_onchange() {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
        switch(event.srcElement.name){
            case "vvd":
        		
        		
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
	 * @version 2009.10.05
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");
			
			MakeComboObject2(formObj.ar_ofc_cd, arrStr);
		
			var arrStr2 = "";
			var ar_ofc_cd = "";
		
			for(i=1;i<arrStr.length;i++){
				arrStr2 = arrStr[i].split("^");
				if(arrStr2[1]==arrStr2[3]){
					ar_ofc_cd = arrStr2[1];
		
					formObj.ofc.value = ar_ofc_cd;
					formObj.ofc_cd.value = formObj.ofc.value;	
					if(arrStr2[7]=="EUR"){
						ComSetDisplay("partial_bl",false);
						ComSetDisplay("chg_type1",false);
						ComSetDisplay("chg_type2",false);
					}
				}
			}
			formObj.ar_ofc_cd.text = ar_ofc_cd;	
			
			ComOpenWait(false);
			
			break;
			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0111GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					
					if (sXml.indexOf("ERROR") < 1){
						if ( arrXml[0] != null){
							sheetObj.LoadSearchXml(arrXml[0]);
							if(sheetObjects[0].RowCount==0){
								ComShowCodeMessage("COM130401");
								formObj.retr_input.select();
							}
						}
					}
						     		 	
	     		 	ComBtnEnable("btn_SendBL");	
					
					setColor();
				}
			break;
			
			case IBINSERT:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					var iCheckRow = sheetObj.FindCheckedRow("DelChk");
					
					if (iCheckRow== "") {
						ComShowCodeMessage("INV00025");
						return;
					}
					
					var sParam = sheetObj.GetSaveString(false, true, 1);
					if (sParam == "") {
						return;
					}
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0111GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"DelChk"),"sheet1_") );
					if (sXml.indexOf("ERROR") < 1){
						//var invNoCnt = ComGetEtcData(sXml,"inv_no_cnt");
		     		 	
						//formObj.inv_no_cnt.vlaue = invNoCnt;
						
						ComShowCodeMessage("INV00051");
					}
					else {
						ComShowCodeMessage("INV00053");
					}
					ComBtnDisable("btn_SendBL");
				}
			break;
		}
	}
	
	/** 
     * sheet에서 COLOR 설정. <br>
     * curr_cd : currency code 세팅
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	*/
	function setColor(){
		var color_gb = "";
		var cnt = 0;
		for (var i=1; i<=sheetObjects[0].RowCount; i++) {
			var group_num = sheetObjects[0].CellValue(i,"sheet1_bl_cntr_grp_ctnt");
			var group_num_be = sheetObjects[0].CellValue(i-1,"sheet1_bl_cntr_grp_ctnt");
	 		var group_num_af = sheetObjects[0].CellValue(i+1,"sheet1_bl_cntr_grp_ctnt");
	 		var color = sheetObjects[0].CellValue(i,"sheet1_color");
	 		var color_be = sheetObjects[0].CellValue(i-1,"sheet1_color");
	 		
	 		if(group_num != ""){
	 			if(i == 1){
		 			sheetObjects[0].CellValue(i,"sheet1_color") = "A";
		 		}else{
		 			//alert(group_num+"::"+group_num_be+"::"+color_be);
		 			if(group_num == group_num_be){
		 				if(color_be == "A"){
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "A";
		 				}else{
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "B";
		 				}
			 		}else{
			 			if(color_be == "A"){
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "B";
		 				}else{
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "A";
		 				}
			 		}
		 		}
	 			
	 			if(group_num == group_num_af){
 					//sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(237,248,90);
	 			}else if(group_num == group_num_be){
	 				//sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(237,248,90);
	 			}else{
	 				sheetObjects[0].CellValue(i,"sheet1_color") = "C";
	 			}
	 			
	 			if(sheetObjects[0].CellValue(i,"sheet1_color") == "A"){
	 				sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(237,248,90);
	 			}else if(sheetObjects[0].CellValue(i,"sheet1_color") == "B"){
	 				sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(248,252,192);
	 			}
	 		}
		}
	}
	
	function setColor2(){
		for (var i=1; i<=sheetObjects[0].RowCount; i++) {
	 		var group_num = sheetObjects[0].CellValue(i,"sheet1_bl_cntr_grp_ctnt");
	 		var group_num_be = sheetObjects[0].CellValue(i-1,"sheet1_bl_cntr_grp_ctnt");
	 		var color = sheetObjects[0].CellValue(i,"sheet1_color");
	 		var color_be = sheetObjects[0].CellValue(i-1,"sheet1_color");
	 		
	 		if(group_num != ""){
		 		if(i == 1){
		 			sheetObjects[0].CellValue(i,"sheet1_color") = "A";
		 			sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(237,248,90);
		 		}else{
		 			//alert(group_num+"::"+group_num_be+"::"+color_be);
		 			if(group_num == group_num_be){
		 				if(color_be == "A"){
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "A";
		 					sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(237,248,90);
		 				}else{
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "B";
		 					sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(248,252,192);
		 				}
			 		}else{
			 			if(color_be == "A"){
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "B";
		 					sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(248,252,192);
		 				}else{
		 					sheetObjects[0].CellValue(i,"sheet1_color") = "A";
		 					sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(237,248,90);
		 				}
			 		}
		 		}
	 		}	
	 	}
	}
	
	
	/** 
     * sheet상에서 데이타를 받아 sheet의 콤보박스에 세팅. <br>
     * curr_cd : currency code 세팅
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {String} comboValues : 세팅할 값
     * @param  {String} colName : sheet에서 세팅할 컬럼
     * @return (boolean) isCellCombo : CellComboItem, InitDataCombo
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo, sRow) {
		//var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var ROWMARK = "|";
		var FIELDMARK = "=";

		comboValues = "|"+" "+comboValues;		
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 1 ; i < comboItems.length ; i++) {				
				comboItem = comboItems[i].split(FIELDMARK);
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					comboVal += comboItem[0];
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}
			}
		}
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
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
	 * @version 2009.10.05
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      //조회
				with(formObj){
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
					if(ComGetDaysBetween(fm_dt.value,to_dt.value)>90){
						ComShowCodeMessage("INV00043");
						to_dt.focus();
						return;
					}
				}
			break;
			
					
			case IBINSERT:      //저장
				with(formObj){
					var chkCnt = 0;
					var idx = sheetObj.RowCount;
					if (idx > 0) {
						for (var i = 1 ; i < idx+1 ; i++){
							for (var j = 1 ; j < sheetObj.RowCount+1 ; j++){
								if (sheetObj.CellValue(j,1) == '1'){
									chkCnt ++;
								}
							}
						}
						if (chkCnt < 1) {
							ComShowCodeMessage("INV00025");
							return false;
						}
					}
					else {
						ComShowCodeMessage("INV00091");
						return false;
					}
				}
			break;
			
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
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function removeAll(formObj) {
		
		//B/L & Charge 그리드 초기화
		sheetObjects[0].RemoveAll();
		
		//콤보 초기화
		comboObjects[0].Code = "B";			
		comboObjects[1].Code = "S";			
		comboObjects[3].Code = "M";			
		
		//버튼 초기화
		ComBtnDisable("btn_SendBL");
		
		formObj.retr_input.value="";
		formObj.cust_cnt_cd.value="";
		formObj.cust_seq.value="";
		formObj.cust_nm.value="";
		//formObj.inv_no_cnt.value="";
		formObj.retr_input.focus();
	}
	
	/** 
	 * 날짜조건의 값을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
   	function setDefaultDateValue(formObj) {
   		today= new Date();
   		
   		var year = today.getYear();
   		var mon  = today.getMonth()+1;
   		var sday = today.getDate();
   		
   		formObj.fm_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
   		formObj.to_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
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
     * @version 2009.10.05
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 var rowCnt = sheetObj.RowCount;
 		
 		for(var i=1; i <= rowCnt ; i++){
 			if(sheetObj.CellValue(i,'valid')!=''&&sheetObj.CellValue(i,'valid')=='N'){
 				sheetObj.RowBackColor(i) = sheetObj.WebColor("FFFF00");
 				sheetObj.CellEditable(i, 'DelChk') = false; 
 			}
 		}
 		sheetObj.SelectCell(0,0,false);
	}
	
    /** 
     * OnChange 이벤트 발생시[CR 그리드 입력항목 변경] 호출되는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj        
     * @param  {rownum} Row        
     * @param  {colnum} Col        
     * @param  {object} Value        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.10.05
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
		var formObj = document.form;
		
	}
   
   	
	/** 
	 * retr_opt(조회옵션) 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} Index_Code
	 * @param {object} Text
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function retr_opt_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		
		if(Index_Code == "B") { 
			formObj.retr_input.readOnly = false;
			formObj.fm_dt.readOnly = true;
			formObj.to_dt.readOnly = true;
			formObj.retr_input.className = "input1";
			formObj.fm_dt.className = "input2";
			formObj.to_dt.className = "input2";
			formObj.fm_dt.value = "";
			formObj.to_dt.value = "";
			formObj.retr_input.focus();
		}else if(Index_Code == "N"){
			formObj.retr_input.readOnly = false;
			formObj.fm_dt.readOnly = true;
			formObj.to_dt.readOnly = true;
			formObj.retr_input.className = "input1";
			formObj.fm_dt.className = "input2";
			formObj.to_dt.className = "input2";
			formObj.fm_dt.value = "";
			formObj.to_dt.value = "";
			formObj.retr_input.focus();
		}else if(Index_Code == "V"){
			formObj.retr_input.readOnly = false;
			formObj.fm_dt.readOnly = true;
			formObj.to_dt.readOnly = true;
			formObj.retr_input.className = "input1";
			formObj.fm_dt.className = "input2";
			formObj.to_dt.className = "input2";
			formObj.fm_dt.value = "";
			formObj.to_dt.value = "";
			formObj.retr_input.focus();
		}else if(Index_Code == "I"){
			formObj.retr_input.readOnly = true;
			formObj.fm_dt.readOnly = false;
			formObj.to_dt.readOnly = false;
			formObj.retr_input.className = "input2";
			formObj.fm_dt.className = "input1";
			formObj.to_dt.className = "input1";
			formObj.retr_input.value = "";
			formObj.fm_dt.focus();
			
		}else if(Index_Code == "G"){
			formObj.retr_input.readOnly = true;
			formObj.fm_dt.readOnly = false;
			formObj.to_dt.readOnly = false;
			formObj.retr_input.className = "input2";
			formObj.fm_dt.className = "input1";
			formObj.to_dt.className = "input1";
			formObj.retr_input.value = "";
			formObj.fm_dt.focus();
		}
		
		//B/L & Charge 그리드 초기화
		sheetObjects[0].RemoveAll();
		
		//콤보 초기화
		comboObjects[1].Code = "S";	//문서번호
		comboObjects[3].Code = "M";		//Validation Check
		
		//버튼 초기화
		ComBtnDisable("btn_SendBL");
		
	}
	 
	 /**
		 * fm_dt,to_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
		 * <br><b>Example : </b>
		 * <pre>
		 *   fn_ComGetMaskedValue('fm_dt');
		 * </pre>
		 * @param String value
		 * @author Choi Do Soon
		 * @version 2009.10.06
		 */
		function fn_ComGetMaskedValue(elNm) {
		
			var formObj;
			if (elNm == "fm_dt") {
				formObj = form.fm_dt;
			} else {
				formObj = form.to_dt;
			}
			var value = formObj.value;
			if (value=='') return;
			value = ComReplaceStr(value,"-","");
			if (value.length < 8) {
				ComShowCodeMessage("INV00024");
				return;
			} 
		
			if (value.substring(4,6) > 12) {
				ComShowCodeMessage("INV00024");
				return;
			} 
			if (value.substring(4,6) == 00) {
				ComShowCodeMessage("INV00024");
				return;
			} 
			if (value.substring(6,8) > 31) {
				ComShowCodeMessage("INV00024");
				return;
			} 
			if (value.substring(6,8) == 00) {
				ComShowCodeMessage("INV00024");
				return;
			} 
			var ret = ComGetMaskedValue(value, "ymd")  ; 
			formObj.value = ret;
			
			if(elNm == "fm_dt"){
				if(form.to_dt.value==""){
					form.to_dt.value = ret;
				}
				form.to_dt.select(); 
			}
		}
	
	/**
	 * 선택된 탭의 fm_dt 자릿수 체크하여  to_dt로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('20090901');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	function checkFmDtLeng(value){    	  
		if(ComTrimAll(value," ", "-", ":").length==8){
			if(document.form.to_dt.value==""){
				document.form.to_dt.value = ComTrimAll(value," ", "-", ":");
			}
			document.form.to_dt.select(); 
		}
	}
		
	
	/** 
	 * 문서번호 select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function MakeComboObject(cmbObj, arrStr) {
		var formObj = document.form;
		
		cmbObj.RemoveAll();
		var defaultCode = "";
		
		var revisedAmountYn = formObj.revised_amount.checked;
		
		if (revisedAmountYn) {
			cmbObj.InsertItem(0, "", "");
		}
		
		for (var i = 1; i < arrStr.length;i++ ) {
			if (i == 1) {
				defaultCode = arrStr[i];
			}
			
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.Code = defaultCode;
		
		if (revisedAmountYn) {
			cmbObj.text = "";
		}
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
	 * VoList를 array[array[name]]형태로 변환<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function ComXml2ListMap(xmlStr) {
		var rtnArr = new Array();

		if (xmlStr == null || xmlStr == "") {
			return rtnArr;
		}

		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return rtnArr;
			}

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return rtnArr;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChileNodes = dataNode.childNodes;
			if (dataChileNodes == null) {
				return rtnArr;
			}

			for ( var i = 0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				
				var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

				var subDataArr = new Array();
				
				for ( var j = 0; j < arrData.length; j++) {
					subDataArr[colArr[j]] = arrData[j];
				}
				
				rtnArr[i] = (subDataArr);
			}

		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return rtnArr;
	}

	/** 
	 * Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {form} form html 폼 
	 * @param {map} Array[name] 의 값 
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function ComMapToForm(form, map) {		
		//사용가능한 컨트롤을 배열로 생성한다.
		var len = form.elements.length;
		for (var i = 0; i < len; i++) {
			if (form.elements[i].classid == undefined) {
				var xvalue = map[form.elements[i].name];
				if (xvalue == undefined)
					continue;
				switch (form.elements[i].type) {
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
					var eRadio = document.all[form.elements[i].name];
					var idx = 0;
					for ( var k = 0; k < eRadio.length; k++) {
						if (eRadio[k].value == xvalue) {
							idx = k;
							break;
						}
					}
					eRadio[idx].checked = true;
					break;
				case "checkbox":
					form.elements[i].checked = xvalue;
					break;
				case "select-one":
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						for ( var k = 0; k < opt_len; k++) {
							if (eOpt[k].value == xvalue) {
								idx = k;
								break;
							}
						}
					}
					form.elements[i].selectedIndex = idx;
					break;
				case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						var tvalue = xvalue.split("|");
						var tval_len = tvalue.length;
						for ( var k = 0; k < opt_len; k++) {
							for ( var m = 0; m < tval_len; m++) {
								if (eOpt[k].value == tvalue[m])
									eOpt[k].selected = true;
							}
						}
					}
					break;
				default:
					switch (form.elements[i].name) {
//						case "curr_cd":
//							form.elements[i].value = xvalue;
//						break;
//						case "ar_tax_ind_cd":
//							form.elements[i].value = xvalue;
//						break;
						case "cgo_meas_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "bkg_teu_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "bkg_feu_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "good":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "nogood":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "cust_rgst_no":
							form.elements[i].value = ComGetMaskedValue(xvalue, "saupja");
						break;
						default:
							form.elements[i].value = xvalue;
						break;
					}
				}
			}
		}
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
		}
	
	}
	 
	 /**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_1(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.cust_cnt_cd.value = colArray[8];
		document.form.cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_cust_nm();
	}
		 
		 
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office값 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		sheetObjects[0].RemoveAll();
	
		arrStr = value.split("^");
		document.form.ofc.value = arrStr[1];
		document.form.ofc_cd.value = arrStr[1];
	}
	/* 개발자 작업  끝 */