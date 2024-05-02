/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0059.js
*@FileTitle : e-mail / Auto FAX Invoice Sent Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.04 박정진
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
 * 2014.11.13 최도순 [CHM-201432755] ALPS>AR INVOICE> e-mail / Auto FAX Invoice Sent Result
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
	 * @class fns_inv_0059 : fns_inv_0059 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0059() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.initCombo				= initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	//공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
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
	 * @version 2009.05.04
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.from_dt, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.to_dt, 'yyyy-MM-dd');
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
					var v_svc_scp_cd = formObject.svc_scp_cd.value;
					var classId = "COM_ENS_0L1";
					var param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
			
					ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 500, 450, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
				break;
				
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_new":
					sheetObject1.RemoveAll();
					
					formObject.reset();
 					 
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC10);
					
					formObject.io_bnd_cd.Code = "A";
					formObject.date_type.Code = "C";
					
					formObject.from_dt.value =  ComGetNowInfo();
					formObject.to_dt.value =  ComGetNowInfo();
					formObject.from_dt.focus();
				break;
				
				case "btn_downexcel":
					sheetObject1.SpeedDown2Excel(-1);
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
	 * @version 2009.05.04
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
	 * @version 2009.05.04
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
	 * @version 2009.05.04
	 */
	function loadPage() {
		sheet1 = sheetObjects[0];
		sheetCnt = sheetObjects.length ;
		var frm = document.form;
		// combo
		combo1 = comboObjects[1];
		comboCnt = comboObjects.length;
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initControl();

		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		frm.from_dt.value =  ComGetNowInfo();
		frm.to_dt.value =  ComGetNowInfo();
//		frm.to_dt.value = ComGetDateAdd(ComGetNowInfo(),"D", 1, "-");
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
	 * @version 2009.05.04
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 386;
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
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(14, 0, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					var HeadTitle = "Office|Sent By|Result|Bound|VVD|Port|Cust. Code|B/L No.|Invoice No.|Auto|Receiver No.|User ID|Time Requested|Time Sent"; //|Currency|Amt
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//colHidden(9) = true;
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,   60,   daCenter,   false,     "iss_ofc_cd",   		false,    "",      dfNone,   		0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtData,   70,   daCenter,  	false,     "sent_by",   		false,    "",      dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   65,   daCenter,   false,     "result",    		false,    "",      dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   65,   daCenter,   false,     "io_bnd_cd",    		false,    "",      dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   80,   daCenter,   false,     "vvd",	    		false,    "",      dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   65,   daCenter,   false,     "port",	    		false,    "",      dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   80,   daCenter,   false,     "cust_code",    		false,    "",      dfNone,   		0,     true,       true);
										
					InitDataProperty(0, cnt++ , dtData,   95,   daCenter,  	false,     "bl_src_no",   		false,    "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   100,  daCenter,   false,     "inv_no",    		false,    "",      dfNone,     		0,     true,       true);
					InitDataProperty(0, cnt++, dtData,    65,	daCenter,  	false,	   "auto_inv_iss_flg",  false,    "",	   dfNone,     		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   160,  daLeft,  	false,     "received_no",   	false,    "",      dfNone,     		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   80,   daCenter,  	false,     "cre_usr_id",   		false,    "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   120,  daCenter,   false,     "time_requested",    false,    "",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,   120,  daCenter,  	false,     "time_sent",   		false,    "",      dfUserFormat2, 	0,     true,       true);
//					InitDataProperty(0, cnt++ , dtData,   80,  daCenter,  	false,     "curr_cd",   		false,    "",      dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtData,   80,  daRight,  	false,     "chg_amt",   		false,    "",      dfFloat, 		0,     true,       true);
					
					InitUserFormat2(0, "time_requested", "####-##-## ##:##:##", "-|:" );
					InitUserFormat2(0, "time_sent", "####-##-## ##:##:##", "-|:" );
					
					//WordWrap = true;
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
	 * @version 2009.05.04
	 */
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "date_type": 
				with (comboObj) {
	
					InsertItem(0, "Creation date", "C");
		            InsertItem(1, "Sent date",    "S");
		            
		            Code = "C";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
				break;
			case "io_bnd_cd": 
				with (comboObj) {
					InsertItem(0, "All",    "A");
		            InsertItem(1, "I/B",    "I");
		            InsertItem(2, "O/B",    "O");
		            
		            Code = "A";
		            
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
			case "sent_by": 
				with (comboObj) {
					InsertItem(0, "All",    	"");
		            InsertItem(1, "Paper",    	"P");
		            InsertItem(2, "E-Mail",    	"E");
		            InsertItem(3, "Fax",    	"F");
	    		
		    		MultiSelect = true;
		    		UseCode = true;

		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;		    		
		            CheckCode("") = true;
				}
				break;			
	    }

	}
	
	/** 
	 * sent_by 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} s_index
	 * @param {object} s_code
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.12.01
	 */
	function sent_by_OnCheckClick(comboObj, s_index, s_code) {
		//alert(comboObj+":"+s_index+":"+s_code);
		if(s_code == ""){
			if(comboObj.CheckCode("") == true){
				comboObj.CheckCode("P") = false;
		        comboObj.CheckCode("E") = false;
		        comboObj.CheckCode("F") = false;		        
			}
		}else{
			comboObj.CheckCode("") = false;
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
	 * @version 2009.05.04
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
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
					case "iss_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper');
					break;
					
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

					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					
					case "inv_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;					
					
					case "bkg_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					
					case "port":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					
	    	        case "svc_scp_cd":
	    	        	//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper');
					break;
				}
			break;
			
			case "eng":
				switch(event.srcElement.name){
					case "cre_usr_id":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('num');
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
	 * @version 2009.05.04
	 */
	function obj_activate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_dt":
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
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "act_cust_seq":
	            //자리수 채우기
	        	var v_tmp = "";
	            if (formObject.act_cust_seq.value.length != 0 && formObject.act_cust_seq.value.length < 6) {
	            	for(i = 0; i < 6 - formObject.act_cust_seq.value.length; i++){
	            		v_tmp = v_tmp + "0";
	            	}
	            	formObject.act_cust_seq.value = v_tmp+formObject.act_cust_seq.value;
	        	}
	            
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value) {
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
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
	 * @version 2009.05.04
	 */
	function obj_keyup() {
		var formObj = document.form;
		switch (event.srcElement.name) {
			case "from_dt":
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
	 * @version 2009.05.04
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
		
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		 			formObj.ofc_cd.value = arrStr2[1];
		 			formObj.svr_id.value = arrStr2[7];
		 			
		 			sheetObj.DoSearch("FNS_INV_0059GS.do", FormQueryString(formObj));
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
			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
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
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
     */  	
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		formObj.from_dt.focus();
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
     * @version 2009.05.04
	 */ 	  	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObject = document.form;
		var emailCnt = 0;
		var faxCnt = 0;
		var paperCnt = 0;
		var totalCnt = sheetObj.RowCount;
		var sentCnt = 0;
		var sentRt = 0;
		
		if(sheetObj.RowCount > 0) {
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (sheetObj.CellValue(i, "sent_by") == "e-mail") {
					emailCnt ++
				}
				if (sheetObj.CellValue(i, "sent_by") == "FAX") {
					faxCnt ++
				}
				if (sheetObj.CellValue(i, "sent_by") == "Paper") {
					paperCnt ++
				}
				// 아주,미주
				if (sheetObj.CellValue(i, "result") == "SUCCESS") {
					sentCnt ++
				}
				// 구주 
				if (sheetObj.CellValue(i, "result") == "RECEIVED") {
					sentCnt ++
				}
			}
			//totalCnt = emailCnt + faxCnt + paperCnt;
			
			if (sentCnt > 0 && totalCnt > 0) {
				sentRt = sentCnt / totalCnt * 100;
			}
		}
		
		formObject.eml_cnt.value = ComAddComma(emailCnt);
		formObject.fax_cnt.value = ComAddComma(faxCnt);
		formObject.paper_cnt.value = ComAddComma(paperCnt);
		formObject.ttl_cnt.value = ComAddComma(totalCnt);
		formObject.snd_cnt.value = ComAddComma(sentCnt);
		formObject.snd_rt.value = ComRound(sentRt,2);
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
	 * @version 2009.05.04
	 */
	function validateForm(sheetObj,formObj,sAction){
		 switch(sAction) {
		 	case IBSEARCH:      //Retrieve
		 		with(formObj){
		 			if(bl_src_no.value == "" && inv_no.value == "" && vvd.value == "") { 

		 				if(date_type.text == "" ){
		 					ComShowCodeMessage('COM130201', 'Invoice Date Type'); // Invoice Date 값을 입력하셔야 합니다;
		 					return false;
		 				}
		 				
		 				if(from_dt.value == "") {
			 				ComShowCodeMessage("COM130201","B/L No. or Invoice No. or VVD or Sent Date");
			 				from_dt.focus();
							return false;
						}
						if(to_dt.value == "") {
							ComShowCodeMessage("COM130201","B/L No. or Invoice No. or VVD or Sent Date");
							to_dt.focus();
							return false;
						}
						
						if (from_dt.value != "" && to_dt.value != "") {
							//조회기간 입력값 체크(1달)
							var nextDate ="";
							if(ar_ofc_cd.text =="All"){ 
								
								nextDate = ComGetDateAdd(from_dt.value, "D", 10);
							}else{
								nextDate = ComGetDateAdd(from_dt.value, "D", 31);
							}
							
							if (to_dt.value >= nextDate) {
								ComShowCodeMessage("INV00043");
								to_dt.focus();
								return false;
							}
						}
		 			}
					if(ar_ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ar_ofc_cd.focus();
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
	 * @version 2009.05.04
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		
		cmbObj.InsertItem(0, "All", "ALL^^^^^^^"+ arrStr2[7]);
		
//		var userCntCd = document.form.user_cnt_cd.value;
//		if (userCntCd == 'KR') {
//			cmbObj.InsertItem(0, "All", "ALL^^^^^^^KOR");
//		}
//		else {
//			cmbObj.InsertItem(0, "All", "ALL^^^^^^^");
//		}
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
	 * @version 2009.10.19
	 */
    function ar_ofc_cd_OnChange(ar_ofc_cd , code, text) {
    	var formObject = document.form;
    	var expensInfo1 = code.split("^");
    	
    	ComSetObjValue(formObject.ofc_cd,expensInfo1[1]);
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
	 * @version 2009.05.04
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
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
	 * @version 2009.05.04
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
	 * @version 2009.05.04
	 */
	function getCOM_ENS_0L1_1(rowArray) {
		var colArray = rowArray[0];
		
		document.all.svc_scp_cd.value = colArray[3];
	}

	/* 개발자 작업  끝 */