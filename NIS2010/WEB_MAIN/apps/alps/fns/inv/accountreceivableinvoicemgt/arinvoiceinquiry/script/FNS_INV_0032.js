/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0032.js
*@FileTitle : Invoice Report by No Good & Not Issue
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
	 * @class fns_inv_0032 : fns_inv_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0032() {
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
	
	//공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
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
	 * @version 2009.10.20
	 */
	function processButtonClick(){
	/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			setRadioValue(formObject, srcName);
                                           
			switch(srcName) {
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;

				case "btn_new":
					sheetObjects[0].RemoveAll();
					
					with(formObject){
						office.value = "";

						date_option_sa.checked=false;
		    			date_option_sd.checked=false;
		    			date_option_si.checked=true;
						date_option.value = "I";
						from_date.value = "";
						to_date.value = "";

		     			select_option_ng.checked=true;
		     			select_option_ni.checked=false;
		     			select_option_rc.checked=false;
		     			select_option_nv.checked=false;
						select_option.value = "A";

						if_type_bl.checked=false;
		      			if_type_ca.checked=false;
		      			if_type_mri.checked=false;
		      			if_type_all.checked=true;
		      			rev_tp_cd.value = "";

		     			bound_ib.checked=false;
		     			bound_ob.checked=false;
		     			bound_all.checked=true;
		     			io_bnd_cd.value = "";

						port.value = "";
					}

					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC10);
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
	            
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObject.port.value;
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&loc_eq_ofc='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
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
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
			 ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		
		initControl();
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
					case "port":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
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
			case "from_date":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
			case "to_date":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
			case "port":
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
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_date":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_date.focus();
				}
	 		break;
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
	 * @version 2009.10.19
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 320;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					var HeadTitle = " |OFC|VVD|S/A Date|SAILING DATE|B/L No|I/F No|C/A NO|BKG NO|CUSTOMER|CUSTOMER NAME|REV TYPE|REV SRC|BND|POL|POD|Ex. Rate|Ex. Rate Type|USD CHG TOT|LCL CHG TOT|LCL_TOT_AMT|I/F DT|";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet1_";

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "ar_ofc_cd",		false,		"",		dfNone,			0,		false,		false,		10);
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daCenter,		false,		prefix + "vvd",				false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "sail_arr_dt",		false,		"",		dfDateYmd,		0,		false,		false,		12);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "sail_dt",			false,		"",		dfDateYmd,		0,		false,		false,		3);

					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bl_src_no",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "ar_if_no",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bkg_corr_no",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bkg_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "customer",		false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	150,	daCenter,		false,		prefix + "cust_nm",			false,		"",		dfNone,			0,		false,		false,		11);
					
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "rev_tp_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	80,		daCenter,		false,		prefix + "rev_src_cd",		false,		"",		dfDateYmd,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "io_bnd_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "pol_cd",			false,		"",		dfNone,			0,		false,		false,		20);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "pod_cd",			false,		"",		dfNone,			0,		false,		false,		3);

					InitDataProperty(0, cnt++ , dtData,    	 	100,	daRight,		false,		prefix + "inv_xch_rt",		false,		"",		dfNullFloat,	6,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "xch_rt_usd_tp_cd",		false,		"",		dfNone,	0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daRight,		false,		prefix + "usd_chg_tot",		false,		"",		dfNullFloat,	2,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daRight,		false,		prefix + "lcl_chg_tot",		false,		"",		dfNullFloat,	2,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daCenter,		false,		prefix + "inv_ttl_locl_amt",false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "bl_inv_if_dt",	false,		"",		dfDateYmd,		0,		false,		false);

					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "dp_prcs_knt",		false,		"",		dfNone,			0,		false,		false);

					CountPosition = 0;
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
					if (sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						
						sheetObjects[0].RemoveAll();
	
						//var filePath = "C:\\";
						var filePath = "C:\\Users\\Public\\";		// window 7
						
						var office = formObj.office.value;
						if ('' == office) office = "ALL";
						var selectOption = formObj.select_option.value;
						var downResult;
						
						if ('A' == selectOption) {
							filePath = filePath + office +"_NOGOOD.xls";
						} else if ('B' == selectOption) {
							filePath = filePath + office +"_NOTISSUE.xls";
						} else if ('C' == selectOption) {
							filePath = filePath + office +"_REPCUST.xls";
						} else if ('D' == selectOption) {
							filePath = filePath + office +"_NORATE.xls";
						}
						
						ComOpenWait(true);  //대기이미지 표시
						
						sheetObj.DoSearch("FNS_INV_0032GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
						
	      				if (sheetObj.RowCount > 0) {
							if(ComShowCodeConfirm("INV00049")) {
								ComOpenWait(false); //대기이미지 숨김	
								sheetObj.SpeedDown2Excel(-1);
							}
							else {
								downResult = sheetObj.SpeedDown2Excel(-1, false, false, filePath);
								
								ComOpenWait(false); //대기이미지 숨김
								
								if(downResult){
									alert("Saved File Path : "+ filePath);
								}
								else {
									ComShowCodeMessage("COM12151", "Excel File");
								}
							}
	      				}
	            		else {
	            			ComOpenWait(false); //대기이미지 숨김
	            		}
					}
				}
			break;

			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office List 조회
	 			formObj.f_cmd.value = SEARCH02;
	 			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			
	 			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
	 			var arrStr = sStr.split("|");
	 			
	 			MakeComboObject(formObj.ar_ofc_cd, arrStr);
			
	 			var arrStr2 = arrStr[1].split("^");
	 			var ar_ofc_cd = arrStr2[3];
	 			var hd_ofc_cd = arrStr2[0];
	 			
	 			formObj.ar_ofc_cd.text = ar_ofc_cd;
	 			formObj.hd_ofc_cd.value = hd_ofc_cd;
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
			 if(from_date.value == "") {          		 
				 ComShowCodeMessage("INV00004");
				 from_date.focus();
				 return false;
			 }
			 if(to_date.value == "") {          		 
				 ComShowCodeMessage("INV00004");
				 to_date.focus();
				 return false;
			 }
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
			
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.InsertItem(0, "ALL", "ALL^");
		
		cmbObj.BackColor = "#CCFFFD";
	}

	/** 
	 * 팝업창(COM_ENS_051_1()에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		
		document.all.port.value = colArray[3];
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
    			FormObj.date_option_si.checked=false;
    			FormObj.date_option.value="A";
    		break;
    		case "date_option_sd" :      
    			FormObj.date_option_sa.checked=false;
    			FormObj.date_option_sd.checked=true;
    			FormObj.date_option_si.checked=false;
    			FormObj.date_option.value="S";
    		break;
    		case "date_option_si" :      
    			FormObj.date_option_sa.checked=false;
    			FormObj.date_option_sd.checked=false;
    			FormObj.date_option_si.checked=true;
    			FormObj.date_option.value="I";
    		break;

     		case "select_option_ng" :      
     			FormObj.select_option_ng.checked=true;
     			FormObj.select_option_ni.checked=false;
     			FormObj.select_option_rc.checked=false;
     			FormObj.select_option_nv.checked=false;
     			FormObj.select_option.value="A";
     		break;
     		case "select_option_ni" :      
     			FormObj.select_option_ng.checked=false;
     			FormObj.select_option_ni.checked=true;
     			FormObj.select_option_rc.checked=false;
     			FormObj.select_option_nv.checked=false;
     			FormObj.select_option.value="B";
     		break;
     		case "select_option_rc" :      
     			FormObj.select_option_ng.checked=false;
     			FormObj.select_option_ni.checked=false;
     			FormObj.select_option_rc.checked=true;
     			FormObj.select_option_nv.checked=false;
     			FormObj.select_option.value="C";
     		break;
     		case "select_option_nv" :      
     			FormObj.select_option_ng.checked=false;
     			FormObj.select_option_ni.checked=false;
     			FormObj.select_option_rc.checked=false;
     			FormObj.select_option_nv.checked=true;
     			FormObj.select_option.value="D";
     		break;

      		case "if_type_bl" :      
      			FormObj.if_type_bl.checked=true;
      			FormObj.if_type_ca.checked=false;
      			FormObj.if_type_mri.checked=false;
      			FormObj.if_type_all.checked=false;
      			FormObj.rev_tp_cd.value="B";
      		break;
      		case "if_type_ca" :      
      			FormObj.if_type_bl.checked=false;
      			FormObj.if_type_ca.checked=true;
      			FormObj.if_type_mri.checked=false;
      			FormObj.if_type_all.checked=false;
      			FormObj.rev_tp_cd.value="C";
      		break;
      		case "if_type_mri" :      
      			FormObj.if_type_bl.checked=false;
      			FormObj.if_type_ca.checked=false;
      			FormObj.if_type_mri.checked=true;
      			FormObj.if_type_all.checked=false;
      			FormObj.rev_tp_cd.value="M";
      		break;
      		case "if_type_all" :      
      			FormObj.if_type_bl.checked=false;
      			FormObj.if_type_ca.checked=false;
      			FormObj.if_type_mri.checked=false;
      			FormObj.if_type_all.checked=true;
      			FormObj.rev_tp_cd.value="";
      		break;

     		case "bound_ib" :      
     			FormObj.bound_ib.checked=true;
     			FormObj.bound_ob.checked=false;
     			FormObj.bound_all.checked=false;
     			FormObj.io_bnd_cd.value="I";
     		break;
     		case "bound_ob" :      
     			FormObj.bound_ib.checked=false;
     			FormObj.bound_ob.checked=true;
     			FormObj.bound_all.checked=false;
     			FormObj.io_bnd_cd.value="O";
     		break;
     		case "bound_all" :      
     			FormObj.bound_ib.checked=false;
     			FormObj.bound_ob.checked=false;
     			FormObj.bound_all.checked=true;
     			FormObj.io_bnd_cd.value="";
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
	 * @version 2009.10.19
	 */
    function ar_ofc_cd_OnChange(ar_ofc_cd , code, text) {
    	var formObject = document.form;
    	var expensInfo1 = code.split("^");
    	
    	ComSetObjValue(formObject.office,expensInfo1[1]);
    }
   
	/**
	 * 날짜조건의 값을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param formObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function setDefaultDateValue(formObj) {
		today = new Date();
  		
		var year = today.getYear();
		var mon  = today.getMonth()+1;
		var sday = today.getDate();
		
		var vDay = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
		
		formObj.from_date.value = vDay;
		formObj.to_date.value = vDay;
	}
	
	/* 개발자 작업  끝 */