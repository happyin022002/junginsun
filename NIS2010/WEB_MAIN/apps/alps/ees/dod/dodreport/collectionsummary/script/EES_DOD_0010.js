/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_DOD_0010.js
*@FileTitle : DOD Collection Summary by Office Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-18
*@LastModifier : Won-ki Eo
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class EES_DOD_0010 : 예)DOD Collection Summary by Office Detail 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_DOD_0010() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.initCombo				= initCombo;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수 
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code
	
	var timer = null;
	var sheetNum = null;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				init_form();
				break;				
			case "btn_close":
				window.close();
			    break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

	 
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		formObj = document.form;
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
		
 		//html컨트롤 이벤트초기화
 		initControl();
 		init_form();
 		
   		var item_list = window.dialogArguments['item_list'];
   		var ar_if = window.dialogArguments['ar_if'];
   		var cust_cd = window.dialogArguments['cust_cd'];
   		var from = window.dialogArguments['from'];
   		var to = window.dialogArguments['to'];
   		var period = window.dialogArguments['period'];
 		
 		formObj.item_list.value = item_list;
 		formObj.ar_if.value = ar_if;
 		formObj.cust_cd.value = cust_cd;
 		formObj.s_from.value = from;
 		formObj.s_to.value = to;
 		formObj.period.value = period;
 		
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
//		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
//		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
//		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
  	}
  	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {

			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(19);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);
					
					var HeadTitle = "|SEQ|Office|CNTR No.|TP/SZ|BKG DEL|TRO RTN CY|Actual\nRTN Yard|RTN Date|TRO Date|BKG No.|POR|POL|POD|DEL|S/C No.|RFA No.|Special Cust|Special Cust|Invoice Cust|Invoice Cust|Cur.|General Tariff|Special Tariff|Adjust AMT|Invoice AMT|Invoice AMT\n(USD)|Pending AMT|Exemption|INV Office|I/F Date|I/F User";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,	0,		daCenter,	false,	"ibflag",			false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtSeq,		50,		daCenter,	false,	"seq",				false,    		"",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"cfm_ofc_cd",false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"cntr_no",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"cntr_tpsz_cd",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	false,	"bkg_del",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"tro_cntr_rtn_yd_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,	    70,		daCenter,	false,	"actual_rtn_yard",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"rtn_date",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"tro_dt",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		110,	daCenter,		false,	"bkg_no",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	false,	"por_cd",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"pol_cd",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,		false,	"pod_cd",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,		false,	"del_cd",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	false,	"sc_no",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		110,	daCenter,	false,	"rfa_no",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,		false,	"customer",	false,          "",   dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		160,		daLeft,	false,	"cust_lgl_eng_nm",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"invoice_cust_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		160,		daLeft,	false,	"invoice_cust_name",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	false,	"curr_cd",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"gen_trf_amt",			false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"spcl_trf_amt",			false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,		daRight,	false,	"adjust_amt",		false,          "",       dfFloat,   2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,		daRight,	false,	"invoice_amt",			false,          "",       dfFloat,   2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,		daRight,	false,	"invoice_usd_amt",			false,          "",       dfFloat,   2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"pending_amt",			false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	false,	"exemption",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"inv_ofc",false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"ar_if_dt",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"cre_usr_id",			false,          "",       dfNone,    0,    false,       true);

					
					ColHidden('ibflag')= true;

				}
				break;
			case "sheet2":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "";
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,    50,  	daCenter, false,    "ibflag",         	false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("EES_DOD_0010GS.do", FormQueryString(formObj));
				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}

	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
			break;
		}
		
		return result;
	}
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  

		}
	}

  	/**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	var sParam = Array();
    	var formObj = document.form;

		return;
    }


	
