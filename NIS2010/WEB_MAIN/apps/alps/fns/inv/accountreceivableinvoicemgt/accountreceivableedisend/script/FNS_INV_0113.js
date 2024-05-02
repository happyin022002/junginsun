/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0113.jsp
*@FileTitle : EDI Submission(GLOVIS)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.26
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.02 이석준
* 1.0 Creation
* History
* 2011.11.30 권 민 [CHM-201114839] [INV] Glovis Invoice EDI 전송 기능 보완
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
	 * @class FNS_INV_0113 : FNS_INV_0113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0113() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
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
	
	var total_frt_usd =0;
	var total_chg_krw =0;
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
	 * @author 이석준
	 * @version 2010.12.02
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
	             	cal.select(formObj.cre_fm_dt, 'yyyy-MM-dd');
	            break;
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.cre_to_dt, 'yyyy-MM-dd');
	            break;	
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.edi_snd_dt, 'yyyy-MM-dd');
	            break;							

				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			
				case "btn_New":
					removeAll(formObj);
				break;
			
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "sheet1_DelChk|sheet1_No");
				break;
			
				case "btn_SendBL":
				   formObj.btn_flag.value = "SEND";
				   doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC12);
				
					
				break;
				case "btn_ediCancel":
				   formObj.btn_flag.value = "CANCEL";
				   doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC12);
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
	 * @author 이석준
	 * @version 2010.12.02
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
	 * @author 이석준
	 * @version 2010.12.02
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
		initControl();
		
		//버튼 초기화
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_SendBL");
		ComBtnDisable("btn_ediCancel");
		
		formObj.cre_fm_dt.focus();
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
	 * @author 이석준
	 * @version 2010.12.02
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
		
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 282;
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
									
					var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|EDI Date|EDI Status||Cancel Flag|FRT_USD|Ex.Rate(USD)|FRT_KRW|FRT_EUR|Ex.Rate(EUR)|CHG_KRW|TTL_AMT_KRW(SML)|TTL_AMT_KRW(GLOVIS)|VVD|S/A Date|POR|POL|POD|DEL|||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, true, true, false, false);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
				
					var rowCnt = 0;
					
					var prefix="sheet1_";
				
					//데이터속성              [ROW,      COL,    DATATYPE,       WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	30,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(rowCnt,	cnt++,	dtCheckBox,		45,		daCenter,		false,		prefix + "DelChk");
					InitDataProperty(rowCnt,	cnt++,	dtSeq,			30,		daCenter,		false,		prefix + "No");
					InitDataProperty(rowCnt,	cnt++,	dtData,			90,	daCenter,		false,		prefix + "bl_src_no",			false,			"",		dfNone,      	0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			90,	daLeft,		false,		prefix + "inv_no",					false,			"",		dfNone,      	0,		false,		false,		10);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daCenter,		false,		prefix + "edi_snd_dt",			false,			"",		dfNone,	2,		false,		false,		17);
					InitDataProperty(rowCnt,	cnt++,	dtCombo,		75,		daCenter,		false,		prefix + "re_tp_cd",			false,			"",		dfNone,    2,		false,		false,		17);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		70,		daCenter,		false,		prefix + "cxl_flg",				false,			"",		dfNone,    2,		false,		false,		17);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		70,	daCenter,		false,		prefix + "post_cxl_flg",				false,			"",		dfNone,    2,		false,		false,		17);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daRight,		false,		prefix + "frt_usd",				false,			"",		dfFloat,	2,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daRight,		false,		prefix + "inv_xch_rt",			false,			"",		dfFloat,	2,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			120,	daRight,		false,		prefix + "ttl_usd_krw_amt",		false,			"",		dfFloat,		0,		false,		false,		12,		false,		true,		"FRT_USD * Ex.Rate(USD)");
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daRight,		false,		prefix + "frt_eur",				false,			"",		dfFloat,	2,		false,		false,		12,		false,		true,		"FRT_USD * Ex.Rate(USD) / Ex.Rate(EUR)");
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daRight,		false,		prefix + "euro_locl_xch_rt",	false,			"",		dfFloat,	2,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			120,	daRight,		false,		prefix + "chg_krw",				false,			"",		dfFloat,		0,		false,		false,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			125,	daRight,		false,		prefix + "ttl_amt_krw",			false,			"",		dfFloat,     	0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			150,	daRight,		false,		prefix + "glovis_ttl_amt_krw",			false,			"",		dfFloat,     	0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		prefix + "vvd",					false,			"",		dfNone,		0,		false,		false,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		prefix + "sail_arr_dt",			true,			"",		dfDateYmd,		0,		false,		false,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "por_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "pol_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "pod_cd",				false,			"",		dfNone,			-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "del_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					//Hidden
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "ar_if_no",			false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "if_seq",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "inv_rmk",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "locl_nm",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "cust_rgst_no",		false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "usr_locl_nm",			false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "usr_eml",			false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "cust_nm",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "cust_eml",			false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "chk_ind",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		50,		daCenter,		false,		prefix + "eur_gubun",			false,			"",		dfNone,    		-1,		false,		false,		5);
					
					
																			
					InitDataCombo(0, "sheet1_re_tp_cd", "접수 성공|접수 오류|청구 승인|청구 반려|삭제", "S|F|A|R|C");
					InitDataCombo(0, "sheet1_cxl_flg", "원본|취소|신규", "N|Y|A");
					InitDataCombo(0, "sheet1_post_cxl_flg", "취소|||", "Y|N|A|");
					
					CountPosition = 0;
					
					FrozenCols = 5;					
					
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
	 * @author 이석준
	 * @version 2010.12.02
	 */
	function initControl() {
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus',    'obj_activate', formObj);
		axon_event.addListenerForm   ('keyup',    'obj_keyup', formObj);
		axon_event.addListenerForm   ('blur',     'obj_deactivate', formObj);
		axon_event.addListenerForm   ('change',   'obj_onchange', formObj);
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
	 * @author 이석준
	 * @version 2010.12.02
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
					case "bl_src_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					
					case "ar_if_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
//
//					case "cust_cnt_cd":	
//						//영문대문자만입력하기		    	        
//						ComKeyOnlyAlphabet('upper'); 
//					break;
//
//					case "port":	
//						//영문대문자만입력하기		    	        
//						ComKeyOnlyAlphabet('upper'); 
//					break;
				}
				break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
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
	 * @author 이석준
	 * @version 2009.04.27
	 */
	function obj_onchange() {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;		
        switch(event.srcElement.name){
            case "rtv_opt":        		
			headerReset();
        		if (formObj.rtv_opt.value == "SAIL" || formObj.rtv_opt.value =="EDI") {
					formObj.cre_fm_dt.className = "input1";
					formObj.cre_to_dt.className = "input1";
					formObj.bl_src_no.className = "input2";
					formObj.cre_fm_dt.disabled = false;
					formObj.cre_to_dt.disabled = false;
					formObj.bl_src_no.value="";
					formObj.bl_src_no.disabled  = true;
					
				}else if (formObj.rtv_opt.value == "BL" || formObj.rtv_opt.value =="INV") {
					formObj.cre_fm_dt.value="";
					formObj.cre_to_dt.value="";
					formObj.cre_fm_dt.className = "input2";
					formObj.cre_to_dt.className = "input2";
					formObj.bl_src_no.className = "input1";	
					formObj.cre_fm_dt.disabled = true;
					formObj.cre_to_dt.disabled = true;				
					formObj.bl_src_no.disabled = false;
				}    
				
				if (formObj.rtv_opt.value == "EDI" || formObj.rtv_opt.value == "INV" ){
					formObj.edi_send_ind.value     = "Y";
					formObj.edi_send_ind.className = "input2";
					formObj.edi_send_ind.disabled  = true;					
				} else {
					// 삭제(N), 청구 승인(A)는 재전송할 수 없다.
					formObj.edi_send_ind.value = "A";
					formObj.edi_send_ind.className ="input";	
					formObj.edi_send_ind.disabled = false;	
				}		
           	break;
			case "io_bnd_cd":
			headerReset();
				if (formObj.io_bnd_cd.value =='O'){ // OutBound일때 ex.rate,sail date 수정 가능
					formObj.inv_xch_rt.value = 0;
					formObj.inv_xch_rt.disabled = false;
					formObj.inv_xch_rt.className = "input";			
					
					formObj.sail_arr_dt.value = "";
					formObj.sail_arr_dt.disabled = false;
					formObj.sail_arr_dt.className = "input";

					// Rate(EUR), S/A Date 항목 활성화화 한다. by Sang-Hyun Kim - 2012.03.12
					formObj.euro_locl_xch_rt.value = "";
					formObj.euro_locl_xch_rt.disabled = false;
					formObj.euro_locl_xch_rt.className = "input";

					formObj.inv_rmk.value = "";
//					formObj.inv_rmk.disabled = false;
//					formObj.inv_rmk.className = "";
				} else {
					// I/O Bound 선택시 Ex.Rate(USD) 항목을 입력가능하도록 활성화 시킨다. by Sang-Hyun Kim - 2012.03.12
					formObj.inv_xch_rt.value = 0;
					formObj.inv_xch_rt.disabled = false;
					formObj.inv_xch_rt.className = "input";

					// Rate(EUR), S/A Date 항목 비활성화화 한다. by Sang-Hyun Kim - 2012.03.12
					formObj.sail_arr_dt.value = "";
					formObj.sail_arr_dt.disabled = true;
					formObj.sail_arr_dt.className = "input2";

					formObj.euro_locl_xch_rt.value = "";
					formObj.euro_locl_xch_rt.disabled = true;
					formObj.euro_locl_xch_rt.className = "input2";
					
					formObj.inv_rmk.value = "";
//					formObj.inv_rmk.disabled = true;
//					formObj.inv_rmk.className = "textarea2";											
				}
				
			for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++) {
				if (sheetObject.CellValue(i,"sheet1_chk_ind") == "N" || sheetObject.CellValue(i,"sheet1_re_tp_cd") == "A" || formObj.io_bnd_cd.value == 'I' ){
					// 삭제(N), 청구 승인(A)는 재전송할 수 없다.
					alert("1111");
					sheetObject.RowEditable(i) = false;
					sheetObject.CellEditable(i,"sheet1_inv_xch_rt") = false;
					sheetObject.CellEditable(i,"sheet1_euro_locl_xch_rt") = false;
					sheetObject.CellEditable(i,"sheet1_sail_arr_dt") = false;
				} else { 
					if (formObj.io_bnd_cd.value == 'O') {
						sheetObject.RowEditable(i) = true;
						sheetObject.CellEditable(i,"sheet1_inv_xch_rt") = true;				
						sheetObject.CellEditable(i,"sheet1_euro_locl_xch_rt") = true;				
						sheetObject.CellEditable(i,"sheet1_sail_arr_dt") = true;	
					} else { // I/B 일 경우, Ex. Rate(USD) 값 수정할 수 있도록 처리. by Sang-Hyun Kim - 2012.03.12
						sheetObject.RowEditable(i) = true;
						sheetObject.CellEditable(i,"sheet1_inv_xch_rt") = true;
					}
				}
			}
						
			break;
			case "inv_xch_rt": // OutBound일경우 환율 변경시 선택된 row에 대해서 ex rate변경
				// I/B 일 경우, Ex. Rate(USD) 값 수정할 수 있도록 처리. by Sang-Hyun Kim - 2012.03.12
				//if (formObj.io_bnd_cd.value == 'O'){
					for (var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++) {
						if (sheetObject.CellValue(i,"sheet1_DelChk") == 1){
							sheetObject.CellValue(i,"sheet1_inv_xch_rt") = formObj.inv_xch_rt.value;
						} 
					}
					formObj.inv_xch_rt.value = ComAddComma2(formObj.inv_xch_rt.value, "#,###.00");
				//}				
			break;
			
			case "euro_locl_xch_rt": // OutBound이고 eur_gubun이 'Y'일 경우 환율 변경시 선택된 row에 대해서 ex rate변경
			if (formObj.io_bnd_cd.value == 'O'){
				for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++) {
					if (sheetObject.CellValue(i,"sheet1_DelChk") == 1 && sheetObject.CellValue(i,"sheet1_eur_gubun") == 'Y'){
						sheetObject.CellValue(i,"sheet1_euro_locl_xch_rt") = formObj.euro_locl_xch_rt.value;
					} 
				}
			}				
			break;
			
			case "inv_rmk":
			     if (formObj.io_bnd_cd.value == 'O'){
					  for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++) {
						if (sheetObject.CellValue(i,"sheet1_DelChk") == 1){
							sheetObject.CellValue2(i,"sheet1_inv_rmk") = formObj.inv_rmk.value;
						} 
					}
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
	 * @author 이석준
	 * @version 2010.12.02
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					
					// exchange reate,sail date,glovis 담당자, email 등을 초기화
					headerReset();
					formObj.f_cmd.value = SEARCH;
					
					if(formObj.send_type[0].checked) formObj.edi_type.value = 'ALL';
					if(formObj.send_type[1].checked) formObj.edi_type.value = 'SPC';
					formObj.eur_gubun.value =formObj.eur_gubun_flg.value;
					var aryPrefix = new Array("sheet1_");
					

	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0113GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     		 	sheetObj.LoadSearchXml(sXml);
	     		 	
	     		 	sheetObj.HeadCheck(0, "sheet1_DelChk") = false;

					ComBtnEnable("btn_DownExcel");
					ComBtnEnable("btn_SendBL");
					ComBtnEnable("btn_ediCancel");		
					
					
					setColor();
				}
			break;			
			case IBSEARCH_ASYNC12:        //send
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					if(formObj.send_type[0].checked) formObj.edi_type.value = 'ALL';
					if(formObj.send_type[1].checked) formObj.edi_type.value = 'SPC';
					
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObj.GetSaveString(false, true, "sheet1_DelChk");
					
					if (sParam1 == "") {
						return;
					}
					else {
						sParam = sParam + "&" + sParam1;
					}
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0113GS.do", sParam );

					
					if (sXml.indexOf("FAIL") > -1){
						// 실패 메시지 처리
						ComShowCodeMessage("INV00087");					
					} else if (sXml.indexOf("OK") > -1){
						//성공 메시지 처리
						ComShowCodeMessage("INV00086");
						//청구 일자 초기화
		                setDefaultDateValue(formObj);
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					} else {
						// 실패 메시지 처리
						ComShowCodeMessage("INV00087");
					}
					
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
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 이석준
	 * @version 2010.12.02
	 */
	function removeAll(formObj) {
		//입력폼 전체 초기화
		ComResetAll();
		 //청구일자 초기화
//		setDefaultDateValue(formObj);
		//버튼 초기화		
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_SendBL");
		ComBtnDisable("btn_ediCancel");
		
		formObj.cre_fm_dt.className = "input1";
		formObj.cre_to_dt.className = "input1";
		formObj.bl_src_no.className = "input2";
		formObj.cre_fm_dt.disabled = false;
		formObj.cre_to_dt.disabled = false;
		formObj.bl_src_no.value="";
		formObj.bl_src_no.disabled  = true;
		
		formObj.cre_fm_dt.focus();	
	}
	
	/** 
	 * 날짜조건의 값을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 이석준
	 * @version 2010.12.02
	 */
   	function setDefaultDateValue(formObj) {
   		today= new Date();
   		
   		var year = today.getYear();
   		var mon  = today.getMonth()+1;
   		var sday = today.getDate();		
   		var hrs = today.getHours();
		var min = today.getMinutes();
   		formObj.edi_snd_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0")+" "+ComLpad(hrs,2,"0")+":"+ComLpad(min,2,"0");
   	}

		/**
	 * 셀을 클릭했을때 발생하는 이벤트 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @return 이석준
     * @see #
     * @author 이석준
     * @version 2010.11.26
	 **/
	function sheet1_OnClick(sheetObj, Row, Col){
		var formObj = document.form;
		
		if (formObj.io_bnd_cd.value=='I') {
			var saDate = sheetObj.Cellvalue(Row,"sheet1_sail_arr_dt");
			formObj.sail_arr_dt.value = saDate.substring(0, 4) + "-" + saDate.substring(4, 6) + "-" + saDate.substring(6, 8);
			formObj.inv_xch_rt.value = ComAddComma2(sheetObj.Cellvalue(Row,"sheet1_inv_xch_rt"), "#,###.00");
			formObj.euro_locl_xch_rt.value = sheetObj.Cellvalue(Row,"sheet1_euro_locl_xch_rt");
		}		
		
		formObj.inv_rmk.value = sheetObj.Cellvalue(Row,"sheet1_inv_rmk");
		formObj.edi_snd_dt.value = sheetObj.Cellvalue(Row,"sheet1_edi_snd_dt");
		
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
     * @author 이석준
     * @version 2010.12.02
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) == 'sheet1_DelChk') {
			if (Value == 1) total_frt_usd += Number(sheetObj.CellValue(Row,'sheet1_frt_usd'));
			if (Value == 0) total_frt_usd -= Number(sheetObj.CellValue(Row,'sheet1_frt_usd'));

			formObj.bil_oft_amt.value = total_frt_usd;
			formObj.bil_oft_amt.value = ComAddComma2(formObj.bil_oft_amt, "#,###.00");
			
			if (Value == 1) total_chg_krw += Number(sheetObj.CellValue(Row,'sheet1_chg_krw'));
			if (Value == 0) total_chg_krw -= Number(sheetObj.CellValue(Row,'sheet1_chg_krw'));
			
			formObj.bil_chg_amt.value = total_chg_krw
			formObj.bil_chg_amt.value = ComAddComma2(formObj.bil_chg_amt, "#,###.00");	
			
//			if (Value == 1) total_chg_krw += Number(sheetObj.CellValue(Row,'sheet1_chg_krw'));
//			if (Value == 0) total_chg_krw -= Number(sheetObj.CellValue(Row,'sheet1_chg_krw'));
//			
//			formObj.bil_chg_amt.value = total_chg_krw
//			formObj.bil_chg_amt.value = ComAddComma2(formObj.bil_chg_amt, "#,###.00");	
										
		} else if (sheetObj.ColSaveName(Col) == 'sheet1_inv_xch_rt'){
			sheetObj.CellValue2(Row,"sheet1_ttl_amt_krw") = calKrwAmt(sheetObj,Value,Row);	
			
			sheetObj.CellValue2(Row,"sheet1_frt_eur") = calFrtEur_changedInvXchRt(sheetObj,Value,Row);
			sheetObj.CellValue2(Row,"sheet1_ttl_usd_krw_amt") = calKrwAmtEur_changedInvXchRt(sheetObj,Value,Row);	
			
		} else if (sheetObj.ColSaveName(Col) == 'sheet1_euro_locl_xch_rt'){	  
			sheetObj.CellValue2(Row,"sheet1_frt_eur") = calFrtEur(sheetObj,Value,Row);		
			sheetObj.CellValue2(Row,"sheet1_ttl_usd_krw_amt") = calKrwAmtEur(sheetObj,Row);
		} else if(sheetObj.ColSaveName(Col) == 'sheet1_sail_arr_dt') {
			if (Value.trim() == "") {
				ComShowCodeMessage("INV00004");
				sheetObj.SelectCell(Row,Col,true,ComGetMaskedValue(sheetObj.CellSearchValue(Row, Col),"ymd"));
			}
		 	
		 }
			
	}
	
     /** 
      * 청구금액 계산<br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj 
      * @param  {int}	row       
      * @return float
      */
 	function calKrwAmtEur(sheetObj,row) {
		
 		var chgKrwAmt = 0;
		var chgUsdAmt = 0;
		var ttl_usd_krw_amt = 0.0;
		var prefix="sheet1_";
 		ttl_usd_krw_amt = parseFloat(sheetObj.CellValue(row, prefix+"frt_usd"))
 						* parseFloat(sheetObj.CellValue(row, prefix+"inv_xch_rt"));
		
 		return ttl_usd_krw_amt;
 	}

      /** 
       * 청구금액 계산<br>
       * <br><b>Example :</b>
       * <pre>
       * </pre>
       * @param  {IBSheet} sheetObj 
       * @param  {int}	row       
       * @return float
       */
      function calKrwAmtEur_changedInvXchRt(sheetObj,inv_xch_rt,row) {
    	  
    	  var chgKrwAmt = 0;
    	  var chgUsdAmt = 0;
    	  var ttl_usd_krw_amt = 0.0;
    	  var prefix="sheet1_";
    	  if (sheetObj.CellValue(row,"sheet1_eur_gubun") == 'Y') {
	    	  ttl_usd_krw_amt = parseFloat(sheetObj.CellValue(row, prefix+"frt_usd"))
	    	  					* parseFloat(inv_xch_rt);
    	  }
    	  return ttl_usd_krw_amt;
      }
 	
 	/** 
 	 * 청구금액 계산<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param  {IBSheet} sheetObj 
 	 * @param  {float} euro_locl_xch_rt
 	 * @param  {int}	row       
 	 * @return float
 	 */
 	function calFrtEur_changedInvXchRt(sheetObj,inv_xch_rt,row) {
 		
 		var frt_amt = 0.0;
 		var prefix="sheet1_";
 		
 		if (sheetObj.CellValue(row, prefix+"euro_locl_xch_rt") !=0) {
 			frt_amt = parseFloat(sheetObj.CellValue(row, prefix+"frt_usd"))
 					* parseFloat(inv_xch_rt) / parseFloat(sheetObj.CellValue(row, prefix+"euro_locl_xch_rt"));
 			
 		}
 		return frt_amt;
 	}
 	 
 	 /** 
 	  * 청구금액 계산<br>
 	  * <br><b>Example :</b>
 	  * <pre>
 	  * </pre>
 	  * @param  {IBSheet} sheetObj 
 	  * @param  {float} euro_locl_xch_rt
 	  * @param  {int}	row       
 	  * @return float
 	  */
 	 function calFrtEur(sheetObj,euro_locl_xch_rt,row) {
 		 
 		 var frt_amt = 0.0;
 		 var prefix="sheet1_";
 		 
 		 if (euro_locl_xch_rt != 0){
	 		 frt_amt = parseFloat(sheetObj.CellValue(row, prefix+"frt_usd"))
	 		 		   * parseFloat(sheetObj.CellValue(row, prefix+"inv_xch_rt")) / parseFloat(euro_locl_xch_rt);
 		 }
 		 return frt_amt;
 	 }
     
    /** 
     * 청구금액 계산<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj 
     * @param  {float} invXchRt
     * @param  {int}	row       
     * @return float
     * @see #
     * @author 이석준
     * @version 2010.12.02
     */
	function calKrwAmt(sheetObj,invXchRt,row) {
		var formObj = document.form;
		
		//var oftAmt = 0;
		var chgKrwAmt = 0;
		var chgUsdAmt = 0;
		var ttl_amt_krw = 0.0;
		var prefix="sheet1_";
		
//		if (sheetObj.rowCount > 0 && invXchRt != "") {
//			for(var i=1; i<=sheetObj.rowCount; i++){
				//oftAmt = ComRound(parseFloat(oftAmt), 2) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"oft_amt")), 2);
//				chgKrwAmt = Number(chgKrwAmt) + Number(sheetObj.CellValue(i, prefix+"thc_amt")) + Number(sheetObj.CellValue(i, prefix+"whf_amt")) + Number(sheetObj.CellValue(i, prefix+"dhf_amt"));
//				chgUsdAmt = parseFloat(chgUsdAmt) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"oft_amt")), 2) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"cms_amt")), 2) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"otr_amt")), 2);
//alert(parseFloat(sheetObj.CellValue(row, prefix+"frt_usd")));
//alert(sheetObj.CellValue(row, prefix+"chg_krw"));

                ttl_amt_krw = (parseFloat(sheetObj.CellValue(row, prefix+"frt_usd"))* parseFloat(invXchRt))+Number(sheetObj.CellValue(row, prefix+"chg_krw"))
//			}
//			
//			formObj.bil_oft_amt.value = setCurrPointValue(chgUsdAmt,2);
//			formObj.bil_chg_amt.value = ComAddComma(chgKrwAmt);
//			formObj.bil_tax_amt.value = 0;
//		}
//		else {
//			formObj.bil_oft_amt.value = 0;
//			formObj.bil_chg_amt.value = 0;
//			formObj.bil_tax_amt.value = 0;
//		}

		return ttl_amt_krw;
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
	 * @author 이석준
	 * @version 2010.12.02
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
	 * 그리드를 제외한 입력항목의 화폐의 소수점 자리에 따라 값을 변경해준다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {object} amtVal        
     * @param {object} currPoint  
     * @return {object} return_value
     * @see #
     * @author 이석준
     * @version 2010.12.02
     */
	function setCurrPointValue(amtVal, currPoint) {
		var amountValue = amtVal+"";
		
		if (currPoint == '0') {
			return ComAddComma(amountValue);
		}
		else if (currPoint == '1') {
			var amountSplit = amountValue.split(".");
			
			amountSplit[0] = ComAddComma(amountSplit[0]);
            if (amountSplit.length == 1) {
            	return amountSplit[0]+".0";
            }
            else if (amountSplit.length == 2) {
            	return amountSplit[0]+"."+amountSplit[1];
            }
            else {
            	return "";		
            }
		}
		else if (currPoint == '2') {
			var amountSplit = amountValue.split(".");
			
			amountSplit[0] = ComAddComma(amountSplit[0]);
            if (amountSplit.length == 1) {
            	return amountSplit[0]+".00";
            }
            else if (amountSplit.length == 2) {
           		return amountSplit[0]+"."+ComRpad(amountSplit[1], 2, "0");
            }
            else {
            	return "";
            }
		}
		else if (currPoint == '3') {
			var amountSplit = amountValue.split(".");
			
			amountSplit[0] = ComAddComma(amountSplit[0]);
            if (amountSplit.length == 1) {
            	return amountSplit[0]+".000";
            }
            else if (amountSplit.length == 2) {
           		return amountSplit[0]+"."+ComRpad(amountSplit[1], 3, "0");
            }
            else {
            	return "";
            }
		}
	}
	
	/**
	 * Sheet1를 조회한후에 후속 처리.<br>
	 * 1. check Box edit 유무를 변경한다.
	 * @param {object} sheetObj
	 * @param {string} ErrMsg
     * @return 없음
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//		alert("on search end");
		sheetObj.reRedraw = false;

		for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
			// 삭제(N), 청구 승인(A)는 재전송할 수 없다.
			if (sheetObj.CellValue(i,"sheet1_chk_ind") == "N" || sheetObj.CellValue(i,"sheet1_re_tp_cd") == "A" ){
				sheetObj.RowEditable(i) = false;
				sheetObj.CellEditable(i,"sheet1_inv_xch_rt") = false;
				sheetObj.CellEditable(i,"sheet1_euro_locl_xch_rt") = false;
				sheetObj.CellEditable(i,"sheet1_sail_arr_dt") = false;
			} else {
				if (document.form.io_bnd_cd.value == 'O') {
					sheetObj.RowEditable(i) = true;
					sheetObj.CellEditable(i,"sheet1_inv_xch_rt") = true;	
					if (sheetObj.CellValue(i,"sheet1_eur_gubun") == "Y") {
						sheetObj.CellEditable(i,"sheet1_euro_locl_xch_rt") = true;	
					}  else {
						sheetObj.CellEditable(i,"sheet1_euro_locl_xch_rt") = false;	
					}
					sheetObj.CellEditable(i,"sheet1_sail_arr_dt") = true;	
				} else { // I/B 일 경우, Ex. Rate(USD) 값 수정할 수 있도록 처리. by Sang-Hyun Kim - 2012.03.12
					sheetObj.RowEditable(i) = true;
					sheetObj.CellEditable(i, "sheet1_inv_xch_rt") = true;
				}
			}
			
			if(sheetObj.CellValue(i,"sheet1_post_cxl_flg")== "Y"){
			    sheetObj.CellValue2(i,"sheet1_re_tp_cd") ="C";
			}
		}
		
		sheetObj.ColBackColor("sheet1_glovis_ttl_amt_krw") = sheetObj.WebColor("#CCFFFD");
		
		sheetObj.reRedraw = true;
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
	 * @author 이석준
	 * @version 2009.05.04
	 */
	function obj_activate() {
	   //마스크 구분자 없애기
	   if (event.srcElement.name != "edi_snd_dt") {
	   		ComClearSeparator(event.srcElement);
	   		event.srcElement.select();
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
	 * @author 이석준
	 * @version 2010.12.05
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "cre_fm_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "cre_to_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "sail_arr_dt":
				//입력Validation 확인 및 마스킹 처리
				 var result= ComChkObjValid(event.srcElement);
			    if (result == false) {
				 	formObj.sail_arr_dt.value="";
					formObj.sail_arr_dt.focus();
				 	break;
				 }
			     if (formObj.io_bnd_cd.value == 'O'){
					  for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++) {
						if (sheetObject.CellValue(i,"sheet1_DelChk") == 1){
							if (formObj.sail_arr_dt.value.trim() !="") {
								sheetObject.CellValue2(i,"sheet1_sail_arr_dt") = formObj.sail_arr_dt.value;
							}
						} 
					}
				}				 
			break;
			case "bil_oft_amt" :
				formObj.bil_oft_amt.value = ComAddComma2(event.srcElement.value, "#,###.00");
				break;
			case "bil_chg_amt" :
				formObj.bil_chg_amt.value = ComAddComma2(event.srcElement.value, "#,###.00");
				break;
			case "inv_xch_rt" :
				formObj.inv_xch_rt.value = ComAddComma2(event.srcElement.value, "#,###.00");
				break;
			case "euro_locl_xch_rt" :
				formObj.euro_locl_xch_rt.value = ComAddComma2(event.srcElement.value, "#,###.00");
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
	 * @version 2009.10.05
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      //조회
				with (formObj) {
					if (rtv_opt.value == "SAIL" || rtv_opt.value == "EDI") {
						if (cre_fm_dt.value == "") {
							ComShowCodeMessage("INV00004");
							cre_fm_dt.focus();
							return false;
						}
						if (cre_to_dt.value == "") {
							ComShowCodeMessage("INV00004");
							cre_to_dt.focus();
							return false;
						}
					}
					
					if (rtv_opt.value == "BL" || rtv_opt.value == "INV") {
						if (bl_src_no.value.length <=5) {
							ComShowCodeMessage("INV00004");
							bl_src_no.focus();
							return false;
						}
					}
				}
			break;			
			case IBSEARCH_ASYNC12:      //전송
				with (formObj) {
					if (io_bnd_cd.value == 'O'){
						for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
							if (sheetObj.CellValue(i,"sheet1_DelChk") == 1 && 
								sheetObj.CellValue(i,"sheet1_eur_gubun") == 'Y' &&
								sheetObj.CellValue(i,"sheet1_frt_usd") != 0) {
 
// 2016.01.08 백승일 [CHM-201539482] (GLOVIS) EURO 환율 미입력 시 EDI 전송되지 않는 건의 BLOCKING 삭제 
							
//								if (sheetObj.CellValue(i,"sheet1_euro_locl_xch_rt") == 0 ){
//									sheetObj.focus();
//									ComShowCodeMessage("INV00004");
//									sheetObj.SelectCell(i, "sheet1_euro_locl_xch_rt", true);
//									return false;
//								} 
								if (sheetObj.CellValue(i,"sheet1_inv_xch_rt") == 0 ){
									sheetObj.focus();
									ComShowCodeMessage("INV00004");
									sheetObj.SelectCell(i, "sheet1_inv_xch_rt", true);
									return false;
								} 
							} 
						}
					}
				}
		    break;
		}
		return true;
	}
	function headerReset(){
		var sheetObject = sheetObjects[0];
		formObj = document.form;
		
        formObj.inv_xch_rt.value = '0.00';
        formObj.euro_locl_xch_rt.value = '0.00';
		formObj.sail_arr_dt.value ="";
		formObj.bil_oft_amt.value =0.0;
		formObj.bil_chg_amt.value =0.0;
		formObj.inv_rmk.value ="";
		formObj.edi_snd_dt.value = "";
		
		sheetObject.RemoveAll();
		total_frt_usd = 0;
	    total_chg_krw = 0;
	}
	/* 개발자 작업  끝 */