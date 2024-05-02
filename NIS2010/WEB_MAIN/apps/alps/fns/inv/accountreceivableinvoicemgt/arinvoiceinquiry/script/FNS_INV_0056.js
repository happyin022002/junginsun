/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0056.js
*@FileTitle : Invoice Not Issued Aging Inquiry by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.27 박정진
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
	 * @class FNS_INV_0056 : FNS_INV_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0056() {
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
	 * @version 2009.07.27
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
			switch(srcName) {
				case "btn_retrive":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			
				case "btn_new":
					removeAll(formObject);
				break;
			
				case "btn_downExcel":
					sheetObject.Down2Excel(-1);
				break;
				
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.as_of_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_cust1": //CUST 조회버튼
					var v_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_nm = sheetObjects[0].UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
				break;
				
				case "btns_SCP": //SCP 조회버튼
					var v_svc_scp_cd = formObject.svc_scp_cd.value;
					var classId = "COM_ENS_0L1";
					var param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
			
					ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 500, 450, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
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
	 * @version 2009.07.27
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
	 * @version 2009.07.27
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
	 * @version 2009.07.27
	 */
	function loadPage() {
		var formObject = document.form;
		
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
	 * @version 2009.07.27
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 388;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 3, 3, 3, 100);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);
					
					var dpPrcsKnt = formObject.dp_prcs_knt.value;
					
					var day1 = formObject.day1.value;
					var day2 = formObject.day2.value;
					var day3 = formObject.day3.value;
					var day4 = formObject.day4.value;
					var day5 = formObject.day5.value;
				
					var HeadTitle  = " |Office|BND||CNT|Not Arrived||CNT|Below "+day1+" D|CNT|Below "+day4+" D| | | | ";
					var HeadTitle1 = " |Office|BND|TTL AMT|CNT|W/I Term|TTL L/T AMT|CNT|Below "+day2+" D|CNT|Below "+day5+" D| | | | ";
					var HeadTitle2 = " |Office|BND|TTL CNT|CNT|TTL W/I Term|L/T CNT|CNT|Below "+day3+" D|CNT|Over "+day5+" D| | | | ";

					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);
					
					var OFFICE = 70;
					var BND = 40;
					var TTLAMT = 135;
					var TTLCNT = 60;
					var NotArrived = 135;
					var LT = 135;
				
					var CNT2 = 60;
					var Below30D = 135;
					var CNT3 = 60;
					var Below120D = 135;
				
					var rowCnt = 0;
				
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if (dpPrcsKnt > 0) {
						InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,0,			daCenter,	false,	"ibflag");
						InitDataProperty(rowCnt, cnt++ , dtData,		OFFICE,		daCenter,	true,	"ar_ofc_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		BND,		daCenter,	true,	"io_bnd_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		TTLAMT,		daRight,	false,	"",					false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLCNT,		daRight,	false,	"not_arrived_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		NotArrived,	daRight,	false,	"not_arrived_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtData,		LT,			daRight,	false,	"",					false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT2,		daRight,	false,	"below_day1_cnt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below30D,	daRight,	false,	"below_day1_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT3,		daRight,	false,	"below_day4_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below120D,	daRight,	false,	"below_day4_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"cr_clt_ofc_cd");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"cr_amt");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"ib_cr_term_dys");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"ob_cr_term_dys");
						
						rowCnt++;
						cnt= 0;
					
						InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,0,			daCenter,	false,	"ibflag");
						InitDataProperty(rowCnt, cnt++ , dtData,		OFFICE,		daCenter,	true,	"ar_ofc_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		BND,		daCenter,	true,	"io_bnd_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLAMT,		daRight,	false,	"ttl_amt",			false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLCNT,		daRight,	false,	"wi_term_cnt",		false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		NotArrived,	daRight,	false,	"wi_term_amt",		false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		LT,			daRight,	false,	"ttl_lt_amt",		false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT2,		daRight,	false,	"below_day2_cnt", 	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below30D,	daRight,	false,	"below_day2_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT3,		daRight,	false,	"below_day5_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below120D,	daRight,	false,	"below_day5_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						
						rowCnt++;
						cnt= 0;
					
						InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,0,			daCenter,	false,	"ibflag");
						InitDataProperty(rowCnt, cnt++ , dtData,		OFFICE,		daCenter,	true,	"ar_ofc_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		BND,		daCenter,	true,	"io_bnd_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLAMT,		daRight,	false,	"ttl_cnt",			false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLCNT,		daRight,	false,	"ttl_wi_term_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		NotArrived,	daRight,	false,	"ttl_wi_term_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		LT,			daRight,	false,	"lt_cnt",			false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT2,		daRight,	false,	"below_day3_cnt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below30D,	daRight,	false,	"below_day3_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT3,		daRight,	false,	"over_day5_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below120D,	daRight,	false,	"over_day5_amt",	false,		"",		dfNullFloat, dpPrcsKnt);
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
					}
					else {
						InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,0,			daCenter,	false,	"ibflag");
						InitDataProperty(rowCnt, cnt++ , dtData,		OFFICE,		daCenter,	true,	"ar_ofc_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		BND,		daCenter,	true,	"io_bnd_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		TTLAMT,		daRight,	false,	"",					false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLCNT,		daRight,	false,	"not_arrived_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		NotArrived,	daRight,	false,	"not_arrived_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtData,		LT,			daRight,	false,	"",					false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT2,		daRight,	false,	"below_day1_cnt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below30D,	daRight,	false,	"below_day1_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT3,		daRight,	false,	"below_day4_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below120D,	daRight,	false,	"below_day4_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"cr_clt_ofc_cd");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"cr_amt");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"ib_cr_term_dys");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"ob_cr_term_dys");
	
						rowCnt++;
						cnt= 0;
					
						InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,0,			daCenter,	false,	"ibflag");
						InitDataProperty(rowCnt, cnt++ , dtData,		OFFICE,		daCenter,	true,	"ar_ofc_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		BND,		daCenter,	true,	"io_bnd_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLAMT,		daRight,	false,	"ttl_amt",			false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLCNT,		daRight,	false,	"wi_term_cnt",		false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		NotArrived,	daRight,	false,	"wi_term_amt",		false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		LT,			daRight,	false,	"ttl_lt_amt",		false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT2,		daRight,	false,	"below_day2_cnt", 	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below30D,	daRight,	false,	"below_day2_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT3,		daRight,	false,	"below_day5_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below120D,	daRight,	false,	"below_day5_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						
						rowCnt++;
						cnt= 0;
					
						InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,0,			daCenter,	false,	"ibflag");
						InitDataProperty(rowCnt, cnt++ , dtData,		OFFICE,		daCenter,	true,	"ar_ofc_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtData,		BND,		daCenter,	true,	"io_bnd_cd",		false,		"",		dfNone);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLAMT,		daRight,	false,	"ttl_cnt",			false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		TTLCNT,		daRight,	false,	"ttl_wi_term_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		NotArrived,	daRight,	false,	"ttl_wi_term_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		LT,			daRight,	false,	"lt_cnt",			false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT2,		daRight,	false,	"below_day3_cnt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below30D,	daRight,	false,	"below_day3_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		CNT3,		daRight,	false,	"over_day5_cnt",	false,		"",		dfInteger);
						
						InitDataProperty(rowCnt, cnt++ , dtAutoSum,		Below120D,	daRight,	false,	"over_day5_amt",	false,		"",		dfInteger);
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
						InitDataProperty(rowCnt, cnt++ , dtHidden,		0,			daCenter,	false,	"");
					}
					//HighLight를 설정하지 않음
					SelectHighLight = false;

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
	 * @version 2009.07.27
	 */
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "curr_flag": 
				with (comboObj) {
					InsertItem(0, "LCL",   "L");
					InsertItem(1, "USD",   "U");
					
					Code = "L";
					BackColor = "#CCFFFD";
					
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,0);
					MaxLength = 3;
				}
			break;
			case "ex_rate_flag": 
				with (comboObj) {
					InsertItem(0, "With Ex. Rate",  "A");
					InsertItem(1, "Without Ex. Rate",   "B");
					
					Code = "A";
					BackColor = "#CCFFFD";
					
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = false;
					DropHeight = 200;
					ValidChar(2,0);
					MaxLength = 3;
				}
			break;
			case "amt_option": 
				with (comboObj) {
					InsertItem(0, "All",    "A");
					InsertItem(1, "Plus",   "P");
					InsertItem(2, "Minus",  "M");
					
					Code = "A";
					BackColor = "#CCFFFD";
					
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = false;
					DropHeight = 200;
					ValidChar(2,0);
					MaxLength = 3;
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
	 * @version 2009.07.27
	 */
	function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('click', 'change_event_checkbox', 'aging_option');
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
	 * @version 2009.07.27
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
					
					case "svc_scp_cd":	
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
	 * @version 2009.07.27
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
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
	 * @version 2009.07.27
	 */
	function obj_keyup() {
		var formObject = document.form;
		
		switch (event.srcElement.name) {
			case "act_cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObject.act_cust_seq.focus();
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
	 * @version 2009.07.27
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "act_cust_seq":
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value != '') {
					var valueCustSeq = formObject.act_cust_seq.value;
					formObject.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
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
	 * aging_option OnChange 이벤트 처리<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.27
	 */
	function change_event_checkbox(){
		var formObject = document.form;
		if(formObject.aging_option.checked) {
			ComEnableObject(formObject.day1,true);
			ComEnableObject(formObject.day2,true);
			ComEnableObject(formObject.day3,true);
			ComEnableObject(formObject.day4,true);
			ComEnableObject(formObject.day5,true);
			
			formObject.day1.className = "input1";
			formObject.day2.className = "input1";
			formObject.day3.className = "input1";
			formObject.day4.className = "input1";
			formObject.day5.className = "input1";
			
			formObject.day1.tabIndex = "";
			formObject.day2.tabIndex = "";
			formObject.day3.tabIndex = "";
			formObject.day4.tabIndex = "";
			formObject.day5.tabIndex = "";
		}
		else {
			ComEnableObject(formObject.day1,false);
			ComEnableObject(formObject.day2,false);
			ComEnableObject(formObject.day3,false);
			ComEnableObject(formObject.day4,false);
			ComEnableObject(formObject.day5,false);
			
			formObject.day1.className = "input2";
			formObject.day2.className = "input2";
			formObject.day3.className = "input2";
			formObject.day4.className = "input2";
			formObject.day5.className = "input2";
			
			formObject.day1.tabIndex = "-1";
			formObject.day2.tabIndex = "-1";
			formObject.day3.tabIndex = "-1";
			formObject.day4.tabIndex = "-1";
			formObject.day5.tabIndex = "-1";

			formObject.day1.value = "30";
			formObject.day2.value = "60";
			formObject.day3.value = "90";
			formObject.day4.value = "120";
			formObject.day5.value = "180";
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
	 * @version 2009.07.27
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
            		sheetObj.Reset();
					formObj.f_cmd.value = SEARCH;
		
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		 			formObj.ofc_cd.value = arrStr2[1];
		 			
		 			var sXml = sheetObj.GetSearchXml("FNS_INV_0056GS.do", FormQueryString(formObj));
		 			
		 			// 소수점 자리수 설정
		 			formObj.dp_prcs_knt.value = ComGetEtcData(sXml,"dp_prcs_knt");
		 			// 타이틀 기간 설정
            		formObj.day1.value = ComGetEtcData(sXml, "day1");
            		formObj.day2.value = ComGetEtcData(sXml, "day2");
            		formObj.day3.value = ComGetEtcData(sXml, "day3");
            		formObj.day4.value = ComGetEtcData(sXml, "day4");
            		formObj.day5.value = ComGetEtcData(sXml, "day5");

            		formObj.cr_clt_ofc_cd.value = ComGetEtcData(sXml, "cr_clt_ofc_cd");
            		formObj.cr_amt.value = ComAddComma(ComGetEtcData(sXml, "cr_amt"));
            		formObj.ob_cr_term_dys.value = ComAddComma(ComGetEtcData(sXml, "ob_cr_term_dys"));
            		formObj.ib_cr_term_dys.value = ComAddComma(ComGetEtcData(sXml, "ib_cr_term_dys"));

		 			initSheet(sheetObj,1);
		 			
		 			sheetObj.MessageText("Sum") = "TTL";
		 			sheetObj.LoadSearchXml(sXml);
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
	 * @version 2009.07.27
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:      //조회
				with(formObj){
					if(act_cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_cnt_cd.focus();
						return false;
					}
					
					if(act_cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_cnt_cd.focus();
						return false;
					}
					
					if(ar_ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ar_ofc_cd.focus();
						return false;
					}
					
					if(curr_flag.text == "") {
						ComShowCodeMessage("INV00004");
						curr_flag.focus();
						return false;
					}
					
					if(ex_rate_flag.text == "") {
						ComShowCodeMessage("INV00004");
						ex_rate_flag.focus();
						return false;
					}
					
					if(amt_option.text == "") {
						ComShowCodeMessage("INV00004");
						amt_option.focus();
						return false;
					}
					
					if(as_of_dt.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_cnt_cd.focus();
						return false;
					}
					
					if(day1.value == "") {
						ComShowCodeMessage("INV00004");
						day1.focus();
						return false;
					}
					
					if(day2.value == "") {
						ComShowCodeMessage("INV00004");
						day2.focus();
						return false;
					}
					
					if(day3.value == "") {
						ComShowCodeMessage("INV00004");
						day3.focus();
						return false;
					}
					
					if(day4.value == "") {
						ComShowCodeMessage("INV00004");
						day4.focus();
						return false;
					}
					
					if(day5.value == "") {
						ComShowCodeMessage("INV00004");
						day5.focus();
						return false;
					}

					if (parseInt(ComReplaceStr(day1.value,",","")) > parseInt(ComReplaceStr(day2.value,",",""))) {
						ComShowCodeMessage("INV00042","Aging Option1","Aging Option2");
						day2.focus();
						return false;
					}
					else if (parseInt(ComReplaceStr(day2.value,",","")) > parseInt(ComReplaceStr(day3.value,",",""))) {
						ComShowCodeMessage("INV00042","Aging Option2","Aging Option3");
						day3.focus();
						return false;
					}
					else if (parseInt(ComReplaceStr(day3.value,",","")) > parseInt(ComReplaceStr(day4.value,",",""))) {
						ComShowCodeMessage("INV00042","Aging Option3","Aging Option4");
						day4.focus();
						return false;
					}
					else if (parseInt(ComReplaceStr(day4.value,",","")) > parseInt(ComReplaceStr(day5.value,",",""))) {
						ComShowCodeMessage("INV00042","Aging Option4","Aging Option5");
						day5.focus();
						return false;
					}
				}
			break;
		}
		return true;
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
     * @version 2009.07.27
     */  	
	function sheet_OnLoadFinish(sheetObj){
		var formObject = document.form;
		
		doActionIBSheet(sheetObj, formObject, IBSEARCH_ASYNC10);
		
		setDefaultDateValue(formObject);
		
		formObject.act_cust_cnt_cd.focus();
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
	 * @version 2009.07.27
	 */
	function removeAll(formObj) {
		formObj.reset();
	 	
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		setDefaultDateValue(formObj);
		
		formObj.act_cust_cnt_cd.focus();
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
	 * @version 2009.07.27
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		
		cmbObj.InsertItem(0, "All", "ALL^");
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
	 * 날짜조건의 값을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {object} formObj        
     * @return {object} 없음
     * @see #
     * @author 박정진
     * @version 2009.07.27
     */
   	function setDefaultDateValue(formObj) {
   		today= new Date();
   		
   		var year = today.getYear();
   		var mon  = today.getMonth()+1;
   		var sday = today.getDate();
   		
   		formObj.as_of_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
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
	 * @version 2009.07.27
	 */
	function getCOM_ENS_0L1_1(rowArray) {
		var colArray = rowArray[0];	
		document.all.svc_scp_cd.value = colArray[3];
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
	 * @version 2009.07.27
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}

	/* 개발자 작업  끝 */