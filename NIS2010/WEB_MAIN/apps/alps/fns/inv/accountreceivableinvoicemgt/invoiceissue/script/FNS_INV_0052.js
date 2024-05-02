/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0052.js
*@FileTitle : (Korea) Terminal GIRO Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.23 박정진
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
	 * @class FNS_INV_0052 : FNS_INV_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0052() {
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
	 * @version 2009.09.23
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj1 = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;
		var prefix="sheet1_";
		var arrGiroCnt = formObj.row_index.value.split("/");

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btns_cust": //CUST 조회버튼
					var v_cust_cnt_cd = formObj.act_cust_cnt_cd.value;
					var v_cust_seq = formObj.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.iss_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_pre":
					if (arrGiroCnt[0] > 1) {
						setGiroAmt(sheetObj1, getGiroNo(sheetObj1, sheetObj1.selectRow, 'P'));
					}
				break;

				case "btns_next":
					if (arrGiroCnt[1] > arrGiroCnt[0]) {
						setGiroAmt(sheetObj1, getGiroNo(sheetObj1, sheetObj1.selectRow, 'N'));
					}
				break;
				
				case "btn_addRow":
					if(validateForm(sheetObj1,formObj,IBSEARCH_ASYNC13)) {
						sheetObj1.DataInsert(-1);
						
						var giroNo = getMaxGiroNo(sheetObj1);
						
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "giro_no")         = giroNo;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "bl_src_no")       = formObj.bl_src_no.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "ar_ofc_cd")       = formObj.ofc_cd.text;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "act_cust_cnt_cd") = formObj.act_cust_cnt_cd.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "act_cust_seq")    = Number(formObj.act_cust_seq.value);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "vsl_cd")          = formObj.vvd.value.substr(0,4);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "skd_voy_no")      = formObj.vvd.value.substr(4,4);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "skd_dir_cd")      = formObj.vvd.value.substr(8,1);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "sail_arr_dt")     = formObj.sail_arr_dt.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "spl_giro_amt")    = "0";
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "tva_giro_amt")    = "0";
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "iss_dt")          = formObj.iss_dt.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "due_dt")          = formObj.due_dt.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "giro_rmk")        = formObj.giro_rmk.value;
						
						setGiroAmt(sheetObj1, giroNo);
					}
				break;
				
				case "btn_deleteRow":
					sheetObj1.RowStatus(sheetObj1.SelectRow) = "D";
					
					if (getRowCount(sheetObj1) > 0) {
						if (sheetObj1.RowCount == sheetObj1.selectRow) {
							setGiroAmt(sheetObj1, getGiroNo(sheetObj1, sheetObj1.selectRow, 'P'));
						}
						else {
							setGiroAmt(sheetObj1, getGiroNo(sheetObj1, sheetObj1.selectRow, 'N'));
						}
					}
					else {
						sheetObj1.DataInsert(-1);
						
						var giroNo = getMaxGiroNo(sheetObj1);
						
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "giro_no")         = giroNo;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "bl_src_no")       = formObj.bl_src_no.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "ar_ofc_cd")       = formObj.ofc_cd.text;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "act_cust_cnt_cd") = formObj.act_cust_cnt_cd.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "act_cust_seq")    = Number(formObj.act_cust_seq.value);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "vsl_cd")          = formObj.vvd.value.substr(0,4);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "skd_voy_no")      = formObj.vvd.value.substr(4,4);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "skd_dir_cd")      = formObj.vvd.value.substr(8,1);
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "sail_arr_dt")     = formObj.sail_arr_dt.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "spl_giro_amt")    = "0";
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "tva_giro_amt")    = "0";
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "iss_dt")          = formObj.iss_dt.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "due_dt")          = formObj.due_dt.value;
						sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "giro_rmk")        = formObj.giro_rmk.value;
						
						setGiroAmt(sheetObj1, giroNo);
					}
				break;	

				case "btn_retrieve":
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
				break;
				
				case "btn_new":
					removeAll(formObj);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObj1,formObj,IBINSERT);
				break;
				
				case "btn_delete":
					doActionIBSheet(sheetObj1,formObj,IBSAVE);
				break;
				
				case "btn_print":
					rdOpen(rdObjects[0], formObj);
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
	 * @version 2009.09.23
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
	 * @version 2009.09.23
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
	 * @version 2009.09.23
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
		
		initRdConfig(rdObjects[0]);
		
		initControl();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		setDefaultDateValue(formObj);
		
		formObj.bl_src_no.focus();
		
    	//버튼 활성화/비활성화
		ComBtnDisable("btns_cust");
		
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_print");
		
		ComBtnDisable("btn_addRow");
		ComBtnDisable("btn_deleteRow");
		ComBtnDisable("btn_pre");
		ComBtnDisable("btns_next");
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
	 * @version 2009.09.23
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					var HeadTitle = "|giroNo|blSrcNo|arOfcCd|actCustCntCd|actCustSeq|vslCd|skdVoyNo|skdDirCd|sailArrDt|splGiroAmt|tvaGiroAmt|issDt|dueDt|giroRmk";
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
					
					var prefix="sheet1_";
					
					//데이터속성          [ROW,     COL,   DATATYPE,      WIDTH,   DATAALIGN,    COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++,	dtStatus,		30,		daCenter,		false,	prefix + "ibflag");
					InitDataProperty(0,		cnt++,	dtData,			110,	daCenter,		false,	prefix + "giro_no",			false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			110,	daCenter,		false,	prefix + "bl_src_no",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	prefix + "ar_ofc_cd",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	prefix + "act_cust_cnt_cd",	false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	prefix + "act_cust_seq",	false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	prefix + "vsl_cd",			false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	prefix + "skd_voy_no",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			60,		daCenter,		false,	prefix + "skd_dir_cd",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			60,		daCenter,		false,	prefix + "sail_arr_dt",		false,		"",		dfDateYmd,	0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			100,	daRight,		false,	prefix + "spl_giro_amt",	false,		"",		dfInteger,	0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			100,	daRight,		false,	prefix + "tva_giro_amt",	false,		"",		dfInteger,	0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			60,		daCenter,		false,	prefix + "iss_dt",			false,		"",		dfDateYmd,	0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			60,		daCenter,		false,	prefix + "due_dt",			false,		"",		dfDateYmd,	0,		true,		true);
					InitDataProperty(0,		cnt++,	dtData,			110,	daCenter,		false,	prefix + "giro_rmk",		false,		"",		dfNone,		0,		true,		true);
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
	 * @version 2009.09.23
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ofc_cd":
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
	 * RD 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {RdObject} rdObject
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.09.23
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;
		
		Rdviewer.style.height = 0;
		
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
	 * @version 2009.09.23
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
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
	 * @version 2009.09.23
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
					case "bl_src_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
	
					case "act_cust_cnt_cd":	
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
	 * @version 2009.09.23
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
	 * @version 2009.09.23
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "iss_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "act_cust_seq":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement,true, true, false);
				//마스크 구분자 없애기
				//ComClearSeparator (event.srcElement);
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
	 * @author 박정진
	 * @version 2009.09.23
	 */
	function obj_focusout() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "act_cust_seq":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				if (formObj.act_cust_cnt_cd.value != '' && formObj.act_cust_seq.value != '') {
					var valueCustSeq = formObj.act_cust_seq.value;
					formObj.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC20);
	
					var custCd = "";
					if (formObj.cust_nm.value != '') {
						custCd = formObj.act_cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
					}
					else {
						custCd = "";
						formObj.act_cust_seq.focus();
					}
					
					for(i=sheetObj.rowCount; i>0; i--){
						sheetObj.CellValue2(i, "cust_code") = custCd;
					}
				}
				else {
					formObj.cust_nm.value = '';
					
					for(i=sheetObj.rowCount; i>0; i--){
						sheetObj.CellValue2(i, "cust_code") = "";
					}
				}
			break;
			case "spl_amt":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				var valueSelectRow = formObj.select_row.value;
				if (formObj.giro_no.value != '') {
					if (formObj.spl_amt.value != '') {
						sheetObj.CellValue2(valueSelectRow, "sheet1_spl_giro_amt") = ComReplaceStr(formObj.spl_amt.value,",","");
					}
					else {
						sheetObj.CellValue2(valueSelectRow, "sheet1_spl_giro_amt") = "0";
					}
					
					setGiroAmt(sheetObj, sheetObj.CellValue(valueSelectRow, "sheet1_giro_no"));
				}
			break;
			case "tva_amt":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				var valueSelectRow = formObj.select_row.value;
				if (formObj.giro_no.value != '') {
					if (formObj.spl_amt.value != '') {
						sheetObj.CellValue2(valueSelectRow, "sheet1_tva_giro_amt") = ComReplaceStr(formObj.tva_amt.value,",","");
					}
					else {
						sheetObj.CellValue2(valueSelectRow, "sheet1_tva_giro_amt") = "0";
					}
					
					setGiroAmt(sheetObj, sheetObj.CellValue(valueSelectRow, "sheet1_giro_no"));
				}
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
	 * @version 2009.09.23
	 */
	function obj_keyup() {
		var formObj = document.form;
		switch (event.srcElement.name) {
			case "iss_dt":
				var issDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (issDt.length == 8) {
					formObj.ofc_cd.focus();
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
	 * @version 2009.09.23
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;

					var arrStr2 = formObj.ofc_cd.Code.split("^");
					formObj.ar_ofc_cd.value = arrStr2[1];
	     			
					var sheetObj1 = sheetObjects[0];
					
					var aryPrefix = new Array("main_", "sheet1_");
					
					ComOpenWait(true);  //대기이미지 표시
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0052GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					
					ComOpenWait(false); //대기이미지 숨김
					
					var arrXml = sXml.split("|$$|");
	     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
	     				var blSrcNo = formObj.bl_src_no.value;
	     				var issDt = formObj.iss_dt.value;
	     				var arOfcCd = formObj.ar_ofc_cd.text;
	     				
	     				removeAll(formObj);
	     				
	     				formObj.bl_src_no.value = blSrcNo;
	     				formObj.iss_dt.value = issDt;
	     				formObj.ar_ofc_cd.text = arOfcCd;
	     				
				    	ComBtnDisable("btn_save");
				    	ComBtnDisable("btn_delete");
				    	ComBtnDisable("btn_print");

	     				ComAlertFocus(formObj.bl_src_no, CoInvShowXmlMessage(arrXml[0]));
					} else {
						var invSplAmt = 0;
						var invTvaAmt = 0;
	     				
						if (arrXml.length > 0) {
							var list1 = ComXml2ListMap(arrXml[0]);
							
							var expensInfo1  = list1[0];
							
							var blSrcNo = expensInfo1["main_bl_src_no"];
							var giroNo = expensInfo1["main_giro_no"];
							var issDt = expensInfo1["main_iss_dt"];
							var actCustCntCd = expensInfo1["main_act_cust_cnt_cd"];
							var actCustSeq = expensInfo1["main_act_cust_seq"];
							var custNm = expensInfo1["main_locl_nm"];
							var custRgstNo = expensInfo1["main_cust_rgst_no"];
							var loclAddr = expensInfo1["main_locl_addr"];
							var ownrNm = expensInfo1["main_ownr_nm"];
							var bzctNm = expensInfo1["main_bzct_nm"];
							var vvd = expensInfo1["main_vvd"];
							var sailArrDt = expensInfo1["main_sail_arr_dt"];
							var dueDt = expensInfo1["main_due_dt"];
							var giroRmk = expensInfo1["main_giro_rmk"];
							invSplAmt = expensInfo1["main_inv_spl_amt"];
							invTvaAmt = expensInfo1["main_inv_tva_amt"];

							formObj.giro_no.value = giroNo;
							formObj.iss_dt.value = issDt;
							formObj.act_cust_cnt_cd.value = actCustCntCd;
							formObj.act_cust_seq.value = actCustSeq;
							formObj.cust_nm.value = custNm;
							formObj.cust_rgst_no.value = custRgstNo;
							formObj.locl_addr.value = loclAddr;
							formObj.ownr_nm.value = ownrNm;
							formObj.bzct_nm.value = bzctNm;
							formObj.vvd.value = vvd;
							formObj.sail_arr_dt.value = sailArrDt;
							formObj.due_dt.value = dueDt;
							formObj.giro_rmk.value = giroRmk;
							
							document.getElementById("inv_spl_amt").innerHTML = ComAddComma(invSplAmt);
							document.getElementById("inv_tva_amt").innerHTML = ComAddComma(invTvaAmt);
							
							document.getElementById("total_inv_amt").innerHTML = ComAddComma(Number(invSplAmt) + Number(invTvaAmt));
						}
				    	if (arrXml.length > 1) {
				    		sheetObj1.LoadSearchXml(arrXml[1]);
				    		
				    		if (sheetObj1.RowCount < 1) {
								sheetObj1.DataInsert(-1);
								
								var giroNo = getMaxGiroNo(sheetObj1);
								var prefix="sheet1_";
								
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "giro_no")         = giroNo;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "bl_src_no")       = formObj.bl_src_no.value;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "ar_ofc_cd")       = formObj.ofc_cd.text;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "act_cust_cnt_cd") = formObj.act_cust_cnt_cd.value;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "act_cust_seq")    = Number(formObj.act_cust_seq.value);
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "vsl_cd")          = formObj.vvd.value.substr(0,4);
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "skd_voy_no")      = formObj.vvd.value.substr(4,4);
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "skd_dir_cd")      = formObj.vvd.value.substr(8,1);
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "sail_arr_dt")     = formObj.sail_arr_dt.value;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "spl_giro_amt")    = ComAddComma(invSplAmt);
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "tva_giro_amt")    = ComAddComma(invTvaAmt);
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "iss_dt")          = formObj.iss_dt.value;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "due_dt")          = formObj.due_dt.value;
								sheetObj1.CellValue(sheetObj1.SelectRow, prefix + "giro_rmk")        = formObj.giro_rmk.value;
								
								setGiroAmt(sheetObj1, giroNo);
								
								ComBtnDisable("btn_print");
								ComBtnDisable("btn_delete");
				    		}
				    		else {
								ComBtnEnable("btn_print");
								ComBtnEnable("btn_delete");
				    		}
						}
				    	
				    	//버튼 활성화/비활성화
				    	ComBtnEnable("btns_cust");
				    	ComBtnEnable("btn_save");
						
						ComBtnEnable("btn_addRow");
						ComBtnEnable("btn_deleteRow");
						ComBtnEnable("btn_pre");
						ComBtnEnable("btns_next");
					}
				}
			break;
			
			case IBINSERT:        // 저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					var arrStr2 = formObj.ofc_cd.Code.split("^");
					formObj.ar_ofc_cd.value = arrStr2[1];
					
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObj.GetSaveString(true);
					
					if (sParam1 == "") {
						return;
					}
					else {
						sParam = sParam + "&" + sParam1;
					}
					
					ComOpenWait(true);  //대기이미지 표시
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0052GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						ComOpenWait(false); //대기이미지 숨김
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					else {
						ComOpenWait(false); //대기이미지 숨김
						ComShowCodeMessage("INV00053");
					}
				}
			break;
			
			case IBSAVE:        // 삭제
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI01;
					
					var arrStr2 = formObj.ofc_cd.Code.split("^");
					formObj.ar_ofc_cd.value = arrStr2[1];
					
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObj.GetSaveString(true);
					
					if (sParam1 == "") {
						return;
					}
					else {
						sParam = sParam + "&" + sParam1;
					}
					
					ComOpenWait(true);  //대기이미지 표시
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0052GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						ComOpenWait(false); //대기이미지 숨김
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					else {
						ComOpenWait(false); //대기이미지 숨김
						ComShowCodeMessage("INV00053");
					}
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("FNS_INV_0052GS.do", FormQueryString(formObj));
	
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
	
				MakeComboObject(formObj.ofc_cd, arrStr);
	
				var arrStr2 = arrStr[1].split("^");
				var ofc_cd = arrStr2[3];
				formObj.ofc_cd.text = ofc_cd;
				
        		var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
        		formObj.inv_prn_dvc_nm.value = sStr;
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
	 * @version 2009.09.23
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:      //조회
				with(formObj){
					if(bl_src_no.value == "") {          		 
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
				}
			break;
			
			case IBSEARCH_ASYNC13:      //조회
				with(formObj){
					if(bl_src_no.value == "") {          		 
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
				}
			break;
			
			case IBINSERT:      //btns_save
				with(formObj){
					//필수입력항목 체크
					if(bl_src_no.value == "") {          		 
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
					
					//발생금액과 합계금액 일치여부 체크
					var totalInvAmt = ComReplaceStr(document.getElementById("total_inv_amt").innerHTML,",","");
					var totalGiroAmt = ComReplaceStr(document.getElementById("total_giro_amt").innerHTML,",","");
					if (totalInvAmt != totalGiroAmt) {
						ComShowCodeMessage("INV00027");
						formObj.spl_amt.focus();
						return false;
					}
				}
			break;
			
			case IBSAVE:      //btns_delete
				if(!ComShowCodeConfirm("INV00028")) return;
				
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
				}
			break;
    	}
		return true;
	}
	
    /** 
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.09.23
     */
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		//조회된 지로 목록중 첫번째 내용, 페이지 값을 세팅한다.
		setGiroAmt(sheetObj, sheetObj.CellValue(1, "sheet1_giro_no"));
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
		var formObj = document.form;
		
//		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
//		
//		setDefaultDateValue(formObj);
//		
//		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC11);
//		
//		formObj.bl_src_no.focus();
//		
//    	//버튼 활성화/비활성화
//		ComBtnDisable("btns_cust");
//		
//		ComBtnDisable("btn_save");
//		ComBtnDisable("btn_delete");
//		ComBtnDisable("btn_print");
//		
//		ComBtnDisable("btn_addRow");
//		ComBtnDisable("btn_deleteRow");
//		ComBtnDisable("btn_pre");
//		ComBtnDisable("btns_next");
	}
	
    /** 
     * 조회된 지로 목록중 선택된 INDEX의 내용, 페이지 값을 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} giroNo
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.09.23
     */
	function setGiroAmt(sheetObj, giroNo) {
		var formObj = document.form;
		
		var prefix="sheet1_";
		
		var sumSplAmt = 0;
		var SumTvaAmt = 0;
		var splAmt = 0;
		var tvaAmt = 0;
		
		var rowIdx = 0;
		
		var totalRowCnt = 0;
		var selectRowIndex = 0;
		
		if(sheetObj.RowCount > 0) {
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (sheetObj.RowStatus(i) != 'D') {
					if (sheetObj.CellValue(i, "sheet1_giro_no") == giroNo) {
						splAmt = sheetObj.CellValue(i, "sheet1_spl_giro_amt");
						tvaAmt = sheetObj.CellValue(i, "sheet1_tva_giro_amt");
						
						rowIdx = i;
					}
					
					sumSplAmt = Number(sumSplAmt) + Number(sheetObj.CellValue(i, "sheet1_spl_giro_amt"));
					SumTvaAmt = Number(SumTvaAmt) + Number(sheetObj.CellValue(i, "sheet1_tva_giro_amt"));
					totalRowCnt++;
				}
			}
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (sheetObj.RowStatus(i) != 'D') {
					selectRowIndex ++;
					if (sheetObj.CellValue(i, "sheet1_giro_no") == giroNo) {
						break;
					}
				}
			}
			sheetObj.SelectRow = rowIdx;
		}
		
		formObj.giro_no.value = giroNo;
		
		document.getElementById("sum_spl_amt").innerHTML = ComAddComma(sumSplAmt);
		document.getElementById("sum_tva_amt").innerHTML = ComAddComma(SumTvaAmt);
		document.getElementById("total_giro_amt").innerHTML = ComAddComma(Number(sumSplAmt) + Number(SumTvaAmt));

		formObj.spl_amt.value = ComAddComma(splAmt);
		formObj.tva_amt.value = ComAddComma(tvaAmt);
		document.getElementById("total_amt").innerHTML = ComAddComma(Number(splAmt) + Number(tvaAmt));
		
		formObj.select_row.value = rowIdx;
		formObj.row_index.value = selectRowIndex + "/" + totalRowCnt;
	}
	
    /** 
     * type 에 따라 페이지 이동할 지로번호를 구한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} selectRow
	 * @param {string} getType
	 * @return giroNo
     * @see #
     * @author 박정진
     * @version 2009.09.23
     */
	function getGiroNo(sheetObj, selectRow, getType) {
		var formObj = document.form;
		
		var giroNo = "";
		var selectRow = formObj.select_row.value;
		var arrGiroCnt = formObj.row_index.value.split("/");
		
		if (getType == "P") {
			for(var i = Number(selectRow)-1; i > 0; i--){
				if (sheetObj.CellValue(i, "sheet1_ibflag") != 'D') {
					giroNo = sheetObj.CellValue(i, "sheet1_giro_no");
					break;
				}
			}
		}
		else if (getType == "N") {
			for(var i = Number(selectRow)+1; i <= sheetObj.Rows; i++){
				if (sheetObj.CellValue(i, "sheet1_ibflag") != 'D') {
					giroNo = sheetObj.CellValue(i, "sheet1_giro_no");
					break;
				}
			}
		}
		else {
			giroNo = sheetObj.CellValue(selectRow, "sheet1_giro_no");
		}
		
		return giroNo;
	}
	
    /** 
     * 그리드에서 삭제되지 않은 데이터의 총수를 구한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.09.23
     */
	function getRowCount(sheetObj) {
		var rowCnt = 0;
		for(var i = 1 ; i < sheetObj.Rows; i++){
			if (sheetObj.CellValue(i, "sheet1_ibflag") != 'D') {
				rowCnt++;
			}
		}
		
		return rowCnt;
	}
	
    /** 
     * 새로운 지로번호를 구한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	 * @param 없음
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.09.23
     */
	function getMaxGiroNo() {
		var formObj = document.form;
		
		var giroNo = "";
		var giroSeq = 0;
		var maxGiroNo = "";
		var maxGiroSeq = 0;
		
		if(sheetObjects[0].RowCount > 0) {
			for(i = 1 ; i < sheetObjects[0].Rows; i++){
				giroNo = sheetObjects[0].CellValue(i, "sheet1_giro_no");
				
				if (giroNo != '') {
					giroSeq = Number(giroNo.substr(12,2));
					
					if (giroSeq > maxGiroSeq) {
						maxGiroSeq = giroSeq;
					}
				}
			}
			
			maxGiroNo = formObj.bl_src_no.value+ComLpad(maxGiroSeq+1, 2, "0");
		}
		else {
			maxGiroNo = formObj.bl_src_no.value+'01';
		}
		
		return maxGiroNo;
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
	 * @version 2009.09.23
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		setDefaultDateValue(formObj);
		
		document.getElementById("inv_spl_amt").innerHTML = "0";
		document.getElementById("sum_spl_amt").innerHTML = "0";
		document.getElementById("inv_tva_amt").innerHTML = "0";
		document.getElementById("sum_tva_amt").innerHTML = "0";
		document.getElementById("total_inv_amt").innerHTML = "0";
		document.getElementById("total_amt").innerHTML = "0";
		document.getElementById("total_giro_amt").innerHTML = "0";
		
    	//버튼 활성화/비활성화
		ComBtnDisable("btns_cust");
		
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_print");
		
		ComBtnDisable("btn_addRow");
		ComBtnDisable("btn_deleteRow");
		ComBtnDisable("btn_pre");
		ComBtnDisable("btns_next");
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
	 * @version 2009.09.23
	 */
	function rdOpen(rdObject, formObj){
		var Rdviewer = rdObject ;
		
		var blSrcNo = formObj.bl_src_no.value;
		var invPrnDvcNm = formObj.inv_prn_dvc_nm.value;
		var arrStr2 = formObj.ofc_cd.Code.split("^");
		var ofcCd = arrStr2[1];
		var printOption = "";
		if (formObj.print_flg[0].checked) {
			printOption = "U";
		}
		else {
			printOption = "D";
		}
		
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
		var rdFile = "FNS_INV_0523.mrd";
		var rdParam = "/rv frm1_bl_src_no["+blSrcNo+"] frm1_ar_ofc_cd ["+ofcCd+"] frm1_print_option["+printOption+"]";
		
		// 열고자 하는 RD 파일을 지정한다.		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");
		
		//프린트세팅
		if(invPrnDvcNm != ""){
			Rdviewer.SetPrintInfo (invPrnDvcNm, 1, 1, 4);
		}
		
		Rdviewer.CMPrint();
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
	 * @version 2009.09.23
	 */
	function MakeComboObject(cmbObj, arrStr) {
 		cmbObj.RemoveAll(); 
 		
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ofc_cd = arrStr2[1];
 			
 			cmbObj.InsertItem(i-1, ofc_cd, arrStr[i]);
 		}
 		cmbObj.BackColor = "#CCFFFD";
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
	 * @version 2009.09.23
	 */
	function setDefaultDateValue(formObj) {
		today = new Date();
  		
		var year = today.getYear();
		var mon  = today.getMonth()+1;
		var sday = today.getDate();
		
		var vDay = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
		
		formObj.iss_dt.value = vDay;
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
	 * @version 2009.09.23
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
	 * @version 2009.09.23
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

	/* 개발자 작업  끝 */