/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0062.js
*@FileTitle : (Spain) Invoice Download for EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.10.26 권   민 [CHM-201114097] (Spain) Invoice Download for EDI
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
     * @class fns_inv_0062 : fns_inv_0062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0062() {
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
	 * @version 2009.04.27
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			// 단순 edi date update 와 구분짓기 위해 구분자
			// gubun = 'Y' release 본연의 기능으로 edi date 를 null 로 update
			formObject.gubun.value	= "N";
			
			switch(srcName) {
				case "btn_download":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
				
				case "btn_new":
					removeAll(formObject);
				break;
				
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.iss_dt, 'yyyy-MM-dd');
				break;
				/* send edi date를 null 초기화 기능 추가 2011.10.26 */
				case "btn_release":
					// 단순 edi date update 와 구분짓기 위해 구분자
					// gubun = 'Y' release 본연의 기능으로 edi date 를 null 로 update
					formObject.gubun.value	= "Y";
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
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
	 * @version 2009.04.27
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
	 * @version 2009.04.27
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
	 * @version 2009.04.27
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
	 	
		initControl();
		 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		
		document.form.iss_dt.focus();
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
	 * @version 2009.04.27
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var formObject = document.form;
		var dpPrcsKnt = formObject.dp_prcs_knt.value;

		switch(sheetNo) {
			case 1:
				with (sheetObj) {
					//높이 설정
					style.height = 100;
					
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
					
					var HeadTitle = " |IF NO|BL NO|BL TP|INV NO|CA NO|BKG NO|RHQ|CNTRY CD|CUST CD|OFC|REV TYP|REV SRC|VSL|VOY|DEP|PORT|LCL CURR|SVC SCP|SA DT|LANE|BND|T VVD|POR|POL|POD|DEL|EX RATE|LCL CHG|USD TOT|USD EQV|LCL TOT|WEIGHT|MEASURE|TEU|FEU|SC NO|AUTH NO|SLSMAN CD|DUE DT|IF DT|ISS DT|GOOD DT|EFF DT|SPLIT IND|ISS CNT|CHG SEQ|CHG TYP|CHG CUR|PER TYP|RATE|RATED AS|INV AMT|INV_XCH_RT|IVA|IVA|IVA|MF DIV CD %";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		"ar_if_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		"bl_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		"bl_tp_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		"inv_no",			false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daCenter,		false,		"bkg_corr_no",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		"bkg_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		"ar_hd_qtr_ofc_cd",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		"act_cust_cnt_cd",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		"act_cust_seq",		false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		"ar_ofc_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"rev_tp_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daRight,		false,		"rev_src_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"vsl_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"skd_voy_no",		false,		"",		dfNone,			0,		false,		false);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"skd_dir_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"port",				false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daCenter,		false,		"locl_curr_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"svc_scp_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"sail_arr_dt",		false,		"",		dfUserFormat2,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		"slan_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"io_bnd_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"t_vvd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"por_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"pol_cd",			false,		"",		dfNone,			0,		false,		false);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"pod_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"del_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"usd_xch_rt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"lcl_chg",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"usd_tot",			false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"usd_eqv",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"lcl_tot",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"cgo_wgt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"cgo_meas_qty",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"bkg_teu_qty",		false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"bkg_feu_qty",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"sc_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"rfa_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"srep_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"due_dt",			false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"bl_inv_if_dt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"iss_dt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"bl_inv_cfm_dt",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"gl_eff_dt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"inv_split_cd",		false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"inv_seq",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"chg_seq",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"chg_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"curr_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"per_tp_cd",		false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"trf_rt_amt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"rat_as_cntr_qty",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"chg_amt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"inv_xch_rt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"tva_flg",			false,		"",		dfNone,			0,		false,		false);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"iva_rate",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		"mf_div_cd",		false,		"",		dfNone,			0,		false,		false);
					
					InitUserFormat2(0, "sail_arr_dt", "########", "-" );
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
	 * @version 2009.04.27
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
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
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
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('click', 'obj_click', formObj); //- 변경될때.
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
	 * @version 2009.04.27
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
					
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
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
	 * @version 2009.04.27
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
	 * @version 2009.04.27
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
		
			case "fm_inv_no":
				return;
			break;
			
			case "to_inv_no":
				return;
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
	 * @version 2009.04.27
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_dt":
				var issFmDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (issFmDt.length == 8) {
					formObject.to_dt.focus();
				}
	 		break;
	 		
			case "prefix":
				var prefix	= event.srcElement.value;
				
				if (prefix.length == 3) {
					formObject.fm_inv_no.focus();
				}
	 		break;
	 		
			case "fm_inv_no":
				var fm_inv_no	= event.srcElement.value;
				
				if (fm_inv_no.length == 7) {
					formObject.to_inv_no.focus();
				}
	 		break;
		}
	}
	
	/** 
	 * 업무 자바스크립트 OnClick 이벤트 처리<br>
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
	function obj_click(){
		var formObj = document.form;
		with(formObj) {
			switch(event.srcElement.name){
	            case "option":
	            	formObj.iss_dt.value = "";
	            	formObj.from_dt.value = "";
	            	formObj.to_dt.value = "";
	            	
	            	if (formObj.option[0].checked) {
	            		formObj.iss_dt.className = "input1";
	            		formObj.iss_dt.readOnly = false;
	            		ComBtnEnable('btns_calendar1');
	            		
	            		formObj.from_dt.className = "input2";
	            		formObj.from_dt.readOnly = true;
	            		formObj.to_dt.className = "input2";
	            		formObj.to_dt.readOnly = true;
	            		ComBtnDisable('btns_calendar2');
	            		ComBtnDisable('btns_calendar3');

	            		formObj.iss_dt.focus();
	            	}
	            	else {
	            		formObj.iss_dt.className = "input2";
	            		formObj.iss_dt.readOnly = true;
	            		ComBtnDisable('btns_calendar1');
	            		
	            		formObj.from_dt.className = "input1";
	            		formObj.from_dt.readOnly = false;
	            		formObj.to_dt.className = "input1";
	            		formObj.to_dt.readOnly = false;
	            		ComBtnEnable('btns_calendar2');
	            		ComBtnEnable('btns_calendar3');

	            		formObj.from_dt.focus();
	            	}
	           	break;
			}
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
	 * @version 2009.04.27
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;

					// 단순 edi date update 와 구분짓기 위해 구분자
					formObj.gubun.value	= "N";
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.ofc_cd.value = arrStr2[1];

	     			var office = arrStr2[1];
	     			
					ComOpenWait(true);  //대기이미지 표시
					
					sheetObj.RemoveAll();
	      			
					var sXml = sheetObj.GetSearchXml("FNS_INV_0062GS.do", FormQueryString(formObj));
					
	      			formObj.dp_prcs_knt.value = ComGetEtcData(sXml,"dpPrcsKnt");
	      			
      				sheetObj.LoadSearchXml(sXml);
	            	if (sheetObj.RowCount > 0) {
	            		
	            		var rowCnt = ComGetEtcData(sXml,"row_cnt");
	            		var invCnt = ComGetEtcData(sXml,"inv_cnt");
	            		var loclTotSum = ComGetEtcData(sXml,"locl_tot_sum");
	            		
	            		var summary = "SUMMARY: "+rowCnt+" LINES   "+invCnt+"  INVOICES    "+loclTotSum+" TOTAL INVOICE "+arrStr2[4];
	            		//alert(summary);
	            		
	            		//sheetObj.DataInsert(0);
	            		//sheetObj.CellValue(1, "ar_if_no") = summary;
	            		
	            		var savedFileName = office+"_inv"+ ComReplaceStr(formObj.iss_dt.value,"-","");
	            		var returnVal = "";
	            		
						ComOpenWait(false); //대기이미지 숨김	
						returnVal = sheetObj.Down2Text(summary, "	", "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56", savedFileName, "C:\\Users\\Public\\", "", false, false, true);
						
						if (returnVal != '') {
							doActionIBSheet(sheetObj, formObj, IBSAVE);
						}
	            	}
	            	else {
						ComOpenWait(false); //대기이미지 숨김
	            	}
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ofc_cd.value = arrStr2[1];
					
					// gubun 값에 따라 f_cmd 값 분기
					// gubun = N : MULTI, gubun = Y : MULTI01 => 새로 추가된 기능 edi date null 로 update
					var gubun	= formObj.gubun.value;

					if(gubun == 'N'){
						formObj.f_cmd.value = MULTI;
					}else{
						formObj.f_cmd.value = MULTI01;
					}
					
					var sParam = FormQueryString(formObj);
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0062GS.do", sParam );
					if(CoInvShowXmlMessage(sXml) == "") {
						ComShowCodeMessage("INV00051");
					}
					else {
						ComShowCodeMessage("INV00053");
					}
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH01;
			
				// 단순 edi date update 와 구분짓기 위해 구분자
				formObj.gubun.value	= "N";
				
				var sXml = sheetObj.GetSearchXml("FNS_INV_0062GS.do", FormQueryString(formObj));
	
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var localTime = ComGetEtcData(sXml,"local_time");
				
				var arrStr = sStr.split("|");
	
				MakeComboObject(formObj.ar_ofc_cd, arrStr);
	
				var arrStr2 = arrStr[1].split("^");
				var ar_ofc_cd = arrStr2[3];
				formObj.ar_ofc_cd.text = ar_ofc_cd;
				
				formObj.iss_dt.value = localTime;
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
	 * @version 2009.04.27
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			var gubun_check = gubun.value;

			if(ar_ofc_cd.text == "") {
				 ComShowCodeMessage("COM12114", "Office");
				 ar_ofc_cd.focus();
				 return false;
			 }
			 //if(option[0].checked && iss_dt.value == "") {
			 if(iss_dt.value == "") {
				 ComShowCodeMessage("INV00004");
				 iss_dt.focus();
				 return false;
			 }
			 
			 if(gubun_check == 'Y'){
				 if(prefix.value == "") {
					 ComShowCodeMessage("INV00004");
					 prefix.focus();
					 return false;
				 }else if(prefix.value.length < 2){
					 ComShowCodeMessage("INV00149");
					 prefix.focus();
					 return false;
				 }
				 if(fm_inv_no.value == "") {
					 ComShowCodeMessage("INV00004");
					 fm_inv_no.focus();
					 return false;
				 }
				 if(to_inv_no.value == "") {
					 ComShowCodeMessage("INV00004");
					 to_inv_no.focus();
					 return false;
				 }
	
				 var fm_to_check	= to_inv_no.value - fm_inv_no.value;
				 if(fm_to_check < 0){
					 ComShowCodeMessage("INV00150");
					 fm_inv_no.focus();
					 return false;
				 }
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
	 * @version 2009.04.27
	 */
 	function MakeComboObject(cmbObj, arrStr) {
 		cmbObj.RemoveAll(); 
 		
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ar_ofc_cd = arrStr2[1];
 			
 			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
 		}
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
	 * @version 2009.04.27
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.iss_dt.focus();
	}
    
	/**
	 * Td 버튼 Disabled 상태 체크용 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} srcName  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function checkTdDisabled(srcName) {
		return !(document.getElementById(srcName).className.indexOf('2') == -1);
	}
    
	/**
	 * img 버튼 Disabled 상태 체크용 : 이전 input tag check<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} srcName  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function checkInputDisabled(srcName) {
		return (document.getElementById(srcName).getAttribute("readOnly") || document.getElementById(srcName).getAttribute("isDisabled"));
	}
	/* 개발자 작업  끝 */