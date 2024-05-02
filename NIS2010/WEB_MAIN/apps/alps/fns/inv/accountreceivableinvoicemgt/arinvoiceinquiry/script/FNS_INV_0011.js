/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0011.js
*@FileTitle : Invoice Inquiry by I/F No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.16 박정진
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
     * @class fns_inv_0011 : fns_inv_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0011() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
		
		// sheet
		this.t2sheet2_OnClick = t2sheet2_OnClick;
		this.t2sheet2_OnMouseMove = t2sheet2_OnMouseMove;
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
	
	var sheet_container = null;

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
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btns_cust": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_container":
					ComOpenPopup('/hanjin/FNS_INV_0098.do', 700, 380, '', '0,0');
				break;
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
					
				case "btn_new":
					removeAll(formObject);
				break; 
				
				case "btn_close":
					window.close();
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
	 * 페이지에 생성된 IBTab Object를 배열로 등록<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBTab} tab_obj    IBTab Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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
		var formObj = document.form;
		sheet_container = sheetObjects[2];
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		initControl();
		
		setSearchValueType();
		
		// 메뉴에서 오픈시
		if (formObj.view_ar_if_no.value == '' && formObj.view_ar_ofc_cd.value == '') {
			//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
			
			document.form.ar_if_no.focus();
		}
		// 팝업화면 조회시
		else {
			//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
			
			formObj.ar_ofc_cd.text = formObj.view_ar_ofc_cd.value;
			formObj.ar_if_no.value = formObj.view_ar_if_no.value;
			formObj.inv_split_cd.value = formObj.view_inv_split_cd.value;
			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
		var formObject = document.form;
		
		var cnt = 0;
		var dpPrcsKnt = formObject.dp_prcs_knt.value;
		var dpPrcsKntLocal = formObject.dp_prcs_knt_local.value;
		
		switch(sheetNo) {
			case 1:      //t2sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 115;
					//전체 너비 설정
					SheetWidth = 550;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Cur|Amount|Ex. Rate|Local Cur|Local Amount";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,  false,   "curr_cd",     		false,    "",      dfNone);
					if (dpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData,	120,	daRight,   false,   "chg_amt",   		false,    "",      dfNullFloat,		dpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,	120,	daRight,   false,   "chg_amt",   		false,    "",      dfInteger);
					}
					InitDataProperty(0, cnt++ , dtData,		90,		daRight,   false,   "inv_xch_rt",   	false,    "",      dfNullFloat,	6);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,  false,   "locl_curr_cd",		false,    "",      dfNone);
					if (dpPrcsKntLocal > 0) {
						InitDataProperty(0, cnt++ , dtAutoSum,	120,	daRight,   false,   "local_total",		false,    "",      dfNullFloat,		dpPrcsKntLocal);
					}
					else {
						InitDataProperty(0, cnt++ , dtAutoSum,	120,	daRight,   false,   "local_total",		false,    "",      dfInteger);
					}
					
					WaitImageVisible=false;
				}
			break;
                  
			case 2:      //t2sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 240;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 15, 100);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					if(formObject.ar_ofc_cd.value == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						var HeadTitle = "Seq.|CHG|M/N|Cur|Rate|Rated As|Per|Amount|VAT|CGST|SGST|UGST|IGST|Remark(s)";
					} else {
						var HeadTitle = "Seq.|CHG|M/N|Cur|Rate|Rated As|Per|Amount|VAT|Remark(s)";
					}
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,		40,		daCenter,	false,	"Seq");
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"chg_cd",			false,      "",      dfNone,  		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"mnl_flg",   		false,      "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"curr_cd",   		false,      "",      dfNone,  		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"trf_rt_amt",    	false,      "",      dfNone,	 	0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"rat_as_cntr_qty",  false,      "",      dfNullFloat, 	3,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"per_tp_cd",   		false,      "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"chg_amt",     		false,      "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"tva_flg",  		false,      "",      dfNone,  		0,     true,       true);
					
					if(formObject.ar_ofc_cd.value == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,	"ida_cgst_amt",     		false,      "",      dfNone, 		0,     true,       true);
						InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,	"ida_sgst_amt",     		false,      "",      dfNone, 		0,     true,       true);
						InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,	"ida_ugst_amt",     		false,      "",      dfNone, 		0,     true,       true);
						InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,	"ida_igst_amt",     		false,      "",      dfNone, 		0,     true,       true);
					}
					
					InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		false,	"chg_rmk",  		false,      "",      dfNone,  		0,     true,       true);
					
					WaitImageVisible=false;
				}
			break;
			case 3:      //Container init
				with (sheetObj) {
					// 높이 설정
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
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(3, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle1 = " |Cntr_tpsz_cd|Cntr_no";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
	                InitHeadRow(0, HeadTitle1, true);
	                
	                WaitImageVisible = false;
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,   "ibflag");
	                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "cntr_tpsz_cd", 	false,     "",      dfNone,    0,  false,	false);
	                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "cntr_no",   		false,     "",      dfNone,    0,  false,	false);

	                CountPosition = 0;   
	                
	                WaitImageVisible=false;
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
		switch (comboObj.id) {
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
	 * Tab 기본 설정<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 탭의 항목을 설정한다.
	 * </pre>
	 * @param {IBTab} tabObj
	 * @param {object} tabNo
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++ , "General" , -1 );
					InsertTab( cnt++ , "Charge" , -1 );
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
	 * @version 2009.10.19
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('click', 'revType_click', 'chk_rev_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
					case "ar_if_no":
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
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bkg_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "act_cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "inv_cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "cr_curr_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "cr_clt_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "vvd":
						//영문대문자+숫자입력하기
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
			case "date_value":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
			case "port":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
        }
	}

	function revType_click() {
		var obj = event.srcElement;
		doEnableRevType(obj);
	}

	function doEnableRevType(obj) {
		var formObj = document.form;
   	 
		// All (전체)
		if(obj.value == 'A') {
			if(obj.checked) {
				ComEnableObject(formObj.chk_rev_type[1], false);
				ComEnableObject(formObj.chk_rev_type[2], false);
				ComEnableObject(formObj.chk_rev_type[3], false);
				ComEnableObject(formObj.chk_rev_type[4], false);
				
	 	 		formObj.chk_rev_type[1].checked = false;
	 	 		formObj.chk_rev_type[2].checked = false;
	 	 		formObj.chk_rev_type[3].checked = false;
	 	 		formObj.chk_rev_type[4].checked = false;
	 	 		
	 	 		formObj.rev_type_A.value = "A";
	 	 		
	 	 		formObj.rev_type_B.value = "";
	 	 		formObj.rev_type_C.value = "";
	 	 		formObj.rev_type_D.value = "";
	 	 		formObj.rev_type_M.value = "";
			} else {
				ComEnableObject(formObj.chk_rev_type[1], true);
				ComEnableObject(formObj.chk_rev_type[2], true);
				ComEnableObject(formObj.chk_rev_type[3], true);
				ComEnableObject(formObj.chk_rev_type[4], true);
				
	 	 		formObj.rev_type_A.value = "";
			}
		}
		// B/L:B(REV_TP_CD = 'B')
		else if(obj.value == 'B') {
			if(obj.checked) {
				formObj.rev_type_B.value = "B";
			} else {
				formObj.rev_type_B.value = "";
			}
		}
		// C/A:C(REV_TP_CD = 'C')
		else if(obj.value == 'C') {
			if(obj.checked) {
				formObj.rev_type_C.value = "C";
			} else {
				formObj.rev_type_C.value = "";
			}
		}
		// DEM:D(REV_TP_CD = 'M' REV_SRC_CD = 'DT')
		else if(obj.value == 'D') {
			if(obj.checked) {
				formObj.rev_type_D.value = "D";
			} else {
				formObj.rev_type_D.value = "";
			}
		}
		// DEM:D(REV_TP_CD = 'M' REV_SRC_CD <> 'DT')
		else if(obj.value == 'M') {
			if(obj.checked) {
				formObj.rev_type_M.value = "M";
			} else {
				formObj.rev_type_M.value = "";
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
	 * @version 2009.10.19
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					sheetObjects[0].Reset();
					
					// 탭위치 초기화
					//tabObjects[0].SelectedIndex = 0;
					
					ComOpenWait(true);
					
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0011GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
	     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
	     				var arIfNo = formObj.ar_if_no.value;
	     				var arOfcCd = formObj.ar_ofc_cd.text;
	     				
	     				removeAll(formObj);
	     				
	     				formObj.ar_if_no.value = arIfNo;
	     				formObj.ar_ofc_cd.text = arOfcCd;
	     				
	     				ComAlertFocus(formObj.ar_if_no, CoInvShowXmlMessage(arrXml[0]));
					} else {
						if (arrXml.length > 0) {
							var currPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt");
							var lclCurrPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt_local");
							
							var list = ComXml2ListMap(arrXml[0]);
							
							//조회조건 저장
							var arIfNo = formObj.ar_if_no.value;
							var blSrcNo = formObj.bl_src_no.value;
							var bkgNo = formObj.bkg_no.value;
							var arOfcCd = formObj.ar_ofc_cd.text;
		
							if (list.length > 0) {
								var expensInfo  = list[0];
								
								if (expensInfo["act_cust_cnt_cd"] != '') {
								
									var vRevTpCd = "";
									var vRevSrcCd = "";
									
									formObj.reset();
									
									ComMapToForm(formObj,expensInfo);
								}
								else {
									ComResetAll();
									
									formObj.ar_if_no.value = arIfNo;
									formObj.ar_ofc_cd.text = arOfcCd;
									
									ComShowCodeMessage("INV00095");
								}
							}
							
							formObj.dp_prcs_knt.value = currPoint;
							formObj.dp_prcs_knt_local.value = lclCurrPoint;
						}
						
						if (arrXml.length > 1) {
							initSheet(sheetObjects[0],1);
							
							sheetObjects[0].LoadSearchXml(arrXml[1]);
						}
						
						if (arrXml.length > 2) {
							initSheet(sheetObjects[1],2);
							sheetObjects[1].LoadSearchXml(arrXml[2]);
						}
						
						if (arrXml.length > 3) {
							sheetObjects[2].LoadSearchXml(arrXml[3]);
						}
					}
	     			
	     			ComOpenWait(false);
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

		 	case IBINSERT:      // 입력
		 	break;
		 }
	}

	/** 
	 * Tab 클릭시 이벤트 관련 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 선택한 탭의 요소가 활성화 된다.
	 * </pre>
     * @param {IBTab} tabObj 필수 tabObj Object        
     * @param {object} nItem
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.10.19
     */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");
		
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
		
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
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
			 if(ar_if_no.value == "") {          		 
				 ComShowCodeMessage("COM12114", "I/F No.");
				 ar_if_no.focus();
				 return false;
			 }
			 if(ar_ofc_cd.text == "") {
				 ComShowCodeMessage("COM12114", "Office");
				 ar_ofc_cd.focus();
				 return false;
			 }
		}

		return true;
	}

	/**
	 * 셀을 클릭했을때 발생하는 이벤트 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} row     	sheetObj의 선택된 Row
	 * @param {ibsheet} col     	sheetObj의 선택된 Col
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	**/
	function t2sheet2_OnClick(sheetObj, row, col, value) {
		switch (sheetObj.ColSaveName(col)) {
	  		case "chg_rmk":
	    		sheetObj.CellEditable(row,"chg_rmk") = false;
    			readOnly = true;
	    		ComShowMemoPad(sheetObj, row, col, readOnly, 310, 60);
	    	break;
		}
	}

	/**
	 * 조회된 그리드의 특정항목 Edittable = false 시킴
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sAction
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initProperty(sAction) {
		switch (sAction) {
			case IBSEARCH: //Open시
				// 초기 Disabled
				var obj = frm.sch_office_code;
				obj.disabled = true;
				obj.className = "input2";
				
				// SUMUP Office Reset
				combo1.RemoveAll();
				combo1.Enable = false;
						
				break;
			case SEARCHLIST: //조회
				// 1. 로딩시 비활성화 항목 : ofc_cd, ofc_eng_nm, ctr_cd, ap_ctrl_ofc_cd, locl_curr_cd
				for(var row=2; row<=sheet1.LastRow; row++) {			
					sheet1.CellEditable(row,"ofc_cd") = false;
					sheet1.CellEditable(row, "ofc_eng_nm") = false;
					sheet1.CellEditable(row, "ctr_cd") = false;
					sheet1.CellEditable(row, "ap_ctrl_ofc_cd") = false;
					
					// 이미지 변경하기
					if(sheet1.CellValue(row, "ofc_his_cnt") > 0) {
						sheet1.CellImage(row, "hisPopup") = 1;
					}
					else {
						sheet1.CellImage(row, "hisPopup") = 0;
					}
				}
				break;	
		}
	}

	/**
	 * 조회조건 입력상태 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	*/
	function setSearchValueType() {
		var formObj = document.form;
		
		if (formObj.view_ar_if_no.value == '' && formObj.view_ar_ofc_cd.value == '') {
			ComEnableObject(formObj.ar_if_no,true);
			
			formObj.ar_if_no.className = "input1";
			formObj.ar_if_no.tabIndex = "";
			
			formObj.ar_if_no.focus();
		}
		else {
			ComEnableObject(formObj.ar_if_no,false);
			
			formObj.ar_ofc_cd.Enable = false; 
		}
	}

	/** 
	 * 팝업창(FNS_INV_0099)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function getFNS_INV_0099(rowArray, row, col) {
		var colArray = rowArray[0];	
		var sheetObject = sheetObjects[1];
        sheetObject.CellValue(row,col+1)= colArray[3];
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
	function getFNS_INV_0013(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
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
		
		// 탭위치 초기화
		tabObjects[0].SelectedIndex = 0;
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
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
		cmbObj.BackColor = "#CCFFFD";
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
	 * @version 2009.10.19
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
	 * @version 2009.10.19
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
						case "cr_amt":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "cgo_wgt":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
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
						case "inv_rmk":
							form.elements[i].value = ComReplaceStr(xvalue,"◀▶"," ");
						break;
						case "cust_rgst_no":
							form.elements[i].value = ComGetMaskedValue(xvalue, "saupja");
						break;
						case "frt_fwrd_cust_seq":
							if (xvalue != '' && xvalue != '0') {
								form.elements[i].value = ComLpad(xvalue, 6, '0');
							}
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