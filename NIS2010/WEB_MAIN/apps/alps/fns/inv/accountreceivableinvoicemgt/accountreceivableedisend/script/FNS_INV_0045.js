/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0045.js
*@FileTitle : (Korea) Samsung Invoice EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.05 박정진
* 1.0 Creation
* 2012.02.21 권  민 [CHM-201216352] [INV] 삼성전자CS센터 (KR-038221) 에 대해서 거래상대방 CODE 를 C1T0S → C1T0W 로 변경 요청
* 2012.03.06 김상현 [CHM-201216560-01] [INV] [요청] 삼성 EDI 수신자(거래상대방) 코드 변경
* 2012.03.23 권  민 [CHM-201216902] [INV] 삼성 Display 분사에 따른 EDI 신규요청
* 2012.07.09 김상현 [CHM-201218835] (Korea) Samsung Invoice EDI > Invoice No. Numbering 요청
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
	 * @class FNS_INV_0045 : FNS_INV_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0045() {
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
	
	// 업체명, 코드, 고객코드 전역변수 선언(추후에 변동 생겼을 때 수정하기 편리하게...) 2012.02.21 권   민 [CHM-201216352]
	// [CHM-201216560-01]사용자 요청으로 원상태로 복원. by Sang-Hyun Kim - 2012.03.06
	// [CHM-201216902] [INV] 삼성 Display 분사에 따른 EDI 신규요청 - 2012.03.27 권 민
	// 업체명
	var entp_1	= "삼성전자로지텍";
	var entp_2	= "삼성전자로지텍 (OFS)";
	var entp_3	= "삼성전자CS센터";
	var entp_4	= "한국IPC";
	var entp_5	= "광주전자";
	var entp_6	= "삼성광통신";
	var entp_7	= "삼성Display";	
	var entp_8	= "삼성 메디슨";

	// 업체코드
	var entpCode_1	= "C1T0W";		// 삼성전자로지텍
	var entpCode_2	= "FSELC";		// 삼성전자로지텍 (OFS)
	var entpCode_3  = "C1T0S";		// 삼성전자CS센터
	var entpCode_4	= "C1T0M";		// 한국IPC
	var entpCode_5	= "110AL";		// 광주전자
	var entpCode_6	= "1S0AL";		// 삼성광통신
	var entpCode_7	= "C1T0P";		// 삼성Display
	var entpCode_8	= "C1T0X";		// 삼성메디슨	
	
	// 고객코드
	var custCode_1	= "000585";		// -> mapping C1T0W
	var custCode_2	= "010510";		// -> mapping FSELC
	var custCode_3	= "038221";		// -> mapping C1T0W
	var custCode_4	= "027679";		// -> mapping C1T0M
	var custCode_5	= "012641";		// -> mapping 110AL
	var custCode_6	= "046209";		// -> mapping 1S0AL
	var custCode_7	= "056269";		// -> mapping C1T0P		
	var custCode_8	= "062625";		// -> mapping C1T0X	
	
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
	            
				case "btn_RowAdd":
					sheetObj.DataInsert(-1);
					
					ComBtnDisable("btn_DownExcel");
					ComBtnDisable("btn_SendBL");
				break;
				
				case "btn_RowDelete":
					var idx = sheetObj.RowCount;
					for (var i = 1 ; i < idx+1 ; i++){
						for (var j = 1 ; j < sheetObj.RowCount+1 ; j++){
							if (sheetObj.CellValue(j,1) == '1'){
								sheetObj.RowDelete(j,false);
							}
						}
					}
					//no 다시 설정
					var k = 1;
					for (var i=1; i<=sheetObj.RowCount; i++) {  						
						sheetObj.CellText(i,"sheet1_No") = k++;
					}
					
					calKrwAmt(sheetObj);
					
					ComBtnDisable("btn_DownExcel");
					ComBtnDisable("btn_SendBL");
				break;
			
				case "btn_Retrieve":
					if (formObj.msg_no.text == '') {
						doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC10);
					}
					else {
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
				break;
			
				case "btn_New":
					removeAll(formObj);
				break;
			
				case "btn_Save":
					doActionIBSheet(sheetObj,formObj,IBINSERT);
				break;
				
				case "btn_Delete":
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC11);
				break;
				
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "sheet1_DelChk|sheet1_No");
				break;
			
				case "btn_SendBL":
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
		
		//청구일자 초기화
		setDefaultDateValue(formObj);
		
		//버튼 초기화
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDelete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_SendBL");
		
		formObj.vvd.focus();
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
				
					//var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|POR|POL|POD|DEL|D2|D4|D5|D7|Oth|Weight|Measure|OFT_USD|CMS_USD|O/F_USD|THC_KRW|DHF_KRW|WHF_KRW|CFR_KRW|BAF_KRW|Others|sndFlg";
					//var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|OFT_USD|CMS_USD|O/F_USD|THC_KRW|DHF_KRW|WHF_KRW|CFR_KRW|BAF_KRW|Others|POR|POL|POD|DEL|D2|D4|D5|D7|Oth|Weight|Measure|sndFlg";
					var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|OFT_USD|CMS_USD|O/F_USD|THC_KRW|DHF_KRW|WHF_KRW|SLF_KRW|Others|POR|POL|POD|DEL|D2|D4|D5|D7|Oth|Weight|Measure|sndFlg|CNTR NO|Group|Color|Sr Inv No";
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
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daCenter,		false,		prefix + "bl_src_no",			true,			"",		dfNone,      	0,		false,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daCenter,		false,		prefix + "sr_inv_no",			false,			"",		dfNone,      	0,		false,		false);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "oft_amt",				false,			"",		dfFloat,	2,		true,		true,		17);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "cms_amt",				false,			"",		dfFloat,    2,		true,		true,		17);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "otr_amt",				false,			"",		dfFloat,	2,		true,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "thc_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "dhf_amt",				false,			"",		dfInteger,     	0,		true,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "whf_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					//InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "cfr_amt",				false,			"",		dfInteger,		0,		true,		true,		12); 항목에서 삭제
					//InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "baf_amt",				false,			"",		dfInteger,	 	0,		true,		true,		12); 항목에서 삭제
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "slf_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "oth_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "por_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "pol_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "pod_cd",				false,			"",		dfNone,			-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "del_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d2_qty",		false,			"",		dfInteger,		0,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d4_qty",		false,			"",		dfInteger,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d5_qty",		false,			"",		dfInteger,		0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d7_qty",		false,			"",		dfInteger,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_etc_qty",		false,			"",		dfInteger,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		prefix + "grs_cntr_wgt",		false,			"",		dfNullFloat,    3,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		prefix + "grs_cbm_capa",		false,			"",		dfNullFloat,    3,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		75,		daCenter,		false,		prefix + "snd_flg",				false,			"",		dfNone,			0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		80,		daCenter,		false,		prefix + "cntr_no",				false,			"",		dfNone,      	0,		true,		true);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		80,		daCenter,		false,		prefix + "bl_cntr_grp_ctnt",	false,			"",		dfNone,      	0,		true,		true);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		80,		daCenter,		false,		prefix + "color",				false,			"",		dfNone,      	0,		true,		true);

					InitDataProperty(rowCnt,	cnt++,	dtHidden,		80,		daCenter,		false,		prefix + "sr_inv_no_seq",		false,			"",		dfNone,      	0,		true,		true);

					
					InitDataValid(rowCnt,		prefix + "bl_src_no",	vtEngUpOther,	"0123456789");	// 영대문자, 숫자만 입력되도록 설정
					
					CountPosition = 0;
					
					FrozenCols = 5;
				}
			break;
			
			case "sheet2":
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
				
					//var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|POR|POL|POD|DEL|D2|D4|D5|D7|Oth|Weight|Measure|OFT_USD|CMS_USD|O/F_USD|THC_KRW|DHF_KRW|WHF_KRW|CFR_KRW|BAF_KRW|Others|sndFlg";
					//var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|OFT_USD|CMS_USD|O/F_USD|THC_KRW|DHF_KRW|WHF_KRW|CFR_KRW|BAF_KRW|Others|POR|POL|POD|DEL|D2|D4|D5|D7|Oth|Weight|Measure|sndFlg";
					var HeadTitle = "|Sel.|No.|B/L No.|Inv No.|OFT_USD|CMS_USD|O/F_USD|THC_KRW|DHF_KRW|WHF_KRW|SLF_KRW|Others|POR|POL|POD|DEL|D2|D4|D5|D7|Oth|Weight|Measure|sndFlg|CNTR NO|Group|Color|Sr Inv No";
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
					InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daCenter,		false,		prefix + "bl_src_no",			true,			"",		dfNone,      	0,		false,		true,		12);					
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		prefix + "sr_inv_no",			false,			"",		dfNone,      	0,		false,		false,		10);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "oft_amt",				false,			"",		dfFloat,	2,		true,		true,		17);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "cms_amt",				false,			"",		dfFloat,    2,		true,		true,		17);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "otr_amt",				false,			"",		dfFloat,	2,		true,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "thc_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "dhf_amt",				false,			"",		dfInteger,     	0,		true,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "whf_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					//InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "cfr_amt",				false,			"",		dfInteger,		0,		true,		true,		12); 항목에서 삭제
					//InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "baf_amt",				false,			"",		dfInteger,	 	0,		true,		true,		12); 항목에서 삭제
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "slf_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daRight,		false,		prefix + "oth_amt",				false,			"",		dfInteger,		0,		true,		true,		12);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "por_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "pol_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "pod_cd",				false,			"",		dfNone,			-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		false,		prefix + "del_cd",				false,			"",		dfNone,    		-1,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d2_qty",		false,			"",		dfInteger,		0,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d4_qty",		false,			"",		dfInteger,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d5_qty",		false,			"",		dfInteger,		0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_d7_qty",		false,			"",		dfInteger,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			35,		daRight,		false,		prefix + "inv_edi_etc_qty",		false,			"",		dfInteger,     	0,		false,		false,		5);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		prefix + "grs_cntr_wgt",		false,			"",		dfNullFloat,    3,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		prefix + "grs_cbm_capa",		false,			"",		dfNullFloat,    3,		false,		false,		5);
					
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		75,		daCenter,		false,		prefix + "snd_flg",				false,			"",		dfNone,			0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		prefix + "cntr_no",				false,			"",		dfNone,      	0,		true,		true);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		prefix + "bl_cntr_grp_ctnt",	false,			"",		dfNone,      	0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		false,		prefix + "color",				false,			"",		dfNone,      	0,		false,		false);

					InitDataProperty(rowCnt,	cnt++,	dtHidden,		80,		daCenter,		false,		prefix + "sr_inv_no_seq",		false,			"",		dfNone,      	0,		false,		false);
					
					InitDataValid(rowCnt,		prefix + "bl_src_no",	vtEngUpOther,	"0123456789");	// 영대문자, 숫자만 입력되도록 설정
					
					CountPosition = 0;
					
					FrozenCols = 5;
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
			case "rcvr_id":		//업체명 50 line 참조
								//2012.02.21 권   민 [CHM-201216352]
				with (comboObj) {
					// [CHM-201216560-01] 사용자 요청으로 복원. by Sang-Hyun Kim - 2012.03.06
					InsertItem(0, "",		" ");
					InsertItem(1, entp_1,	entpCode_1);
		            InsertItem(2, entp_2,	entpCode_2);
		            InsertItem(3, entp_3,	entpCode_3);
		            InsertItem(4, entp_4,	entpCode_4);
		            InsertItem(5, entp_5,	entpCode_5);
		            InsertItem(6, entp_6,   entpCode_6);
		            InsertItem(7, entp_7,	entpCode_7);	
		            InsertItem(8, entp_8,	entpCode_8);	

		            Code = " ";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;
			case "msg_no":		//문서번호
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
			case "inv_msg_func_cd":		//원본여부
				with (comboObj) {
					InsertItem(0, "원본",	"9");
		            InsertItem(1, "사본",	"7");
		            
		            Code = "9";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;

			case "gerp_val_flg": 		//Validation Check
				with (comboObj) {
					InsertItem(0, "Y",		"Y");
		            InsertItem(1, "N",		"N");
		            
		            Code = "Y";
		            
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
					case "vvd":	
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
			case "eff_dt":
				var glEffDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (glEffDt.length == 8) {
					//입력Validation 확인 및 마스킹 처리
					ComChkObjValid(event.srcElement);
					
					formObj.cust_cnt_cd.focus();
					//Office AR Currency 경리환율 조회
					if(getLoclXchRt()) {
						//Amount 계산
						calLocalAmount();
						//CR Detail 그리드 세팅
						dtlGridSet('amount');
						//DR 그리드 세팅
						drGridSet();
						//CR 그리드 세팅
						crGridSet();
						//INV_AR_AMT 그리드 세팅
						amtGridSet();
					}
				}
	 		break;
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
			case "eff_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			
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
					
					for(i=sheetObject.rowCount; i>0; i--){
						sheetObject.CellValue2(i, "cust_code") = custCd;
					}
				}
				else {
					formObj.cust_nm.value = '';
					
					for(i=sheetObject.rowCount; i>0; i--){
						sheetObject.CellValue2(i, "cust_code") = "";
					}
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
        		var vvd = formObj.vvd.value;
        		var rcvrId = formObj.rcvr_id.Code;
        		
        		//입력폼 전체 초기화
        		formObj.reset();
        		//조회조건 설정
        		formObj.vvd.value = vvd;
        		
        		//Retrieve for revised amount 초기화
        		ComEnableObject(formObj.revised_amount, true);
        		
        		//청구일자 초기화
        		setDefaultDateValue(formObj);
        		
        		//B/L & Charge 그리드 초기화
        		sheetObjects[0].RemoveAll();
        		
        		//콤보 초기화
        		comboObjects[1].RemoveAll();	//문서번호
        		comboObjects[2].Code = "9";		//원본여부
        		comboObjects[3].Code = "Y";		//Validation Check
        		
        		//버튼 초기화
        		ComBtnDisable("btn_RowAdd");
        		ComBtnDisable("btn_RowDelete");
        		ComBtnDisable("btn_Save");
        		ComBtnDisable("btn_Delete");
        		ComBtnDisable("btn_DownExcel");
        		ComBtnDisable("btn_SendBL");
        		
        		//업체명에 맞는 hidden value 설정
        		formObj.act_cust_cnt_cd.value = 'KR';
        		
        		var custSeq = "";
        		var buyrRgstNo = ComReplaceStr(formObj.cust_rgst_no.value,"-","");
        		var buyrCoNm = formObj.locl_nm.value;
        		var buyrCeoNm = formObj.ownr_nm.value;
        		var buyrAddr1 = formObj.bzet_addr.value;
        		var buyrAddr2 = "";

        		// index code는 중복되므로 selected Index 로 수정, variable은 line 50 참조	2012.02.21 권   민 [CHM-201216352]
        		var idx	= formObj.rcvr_id.index;
        		if (idx == 1) {
        			custSeq = custCode_1;
        		}
        		else if (idx == 2) {
        			custSeq = custCode_2;
        		}
        		else if (idx == 3) {
        			custSeq = custCode_3;
        		}
        		else if (idx == 4) {
        			custSeq = custCode_4;
        		}
        		else if (idx == 5) {
        			custSeq = custCode_5;
        		}
        		else if (idx == 6) {
        			   custSeq = custCode_6;
        		}
        		else if (idx == 7) {	
        		       custSeq = custCode_7;	
        		}	

        		/*
        		if (rcvrId == 'C1T0W') {
        			custSeq = "000585";
        		}
        		else if (rcvrId == 'FSELC') {
        			custSeq = "010510";
        		}
        		else if (rcvrId == 'C1T0S') {
        			custSeq = "038221";
        		}
        		else if (rcvrId == 'C1T0M') {
        			custSeq = "027679";
        		}
        		else if (rcvrId == '110AL') {
        			custSeq = "012641";
        		}
        		else if (rcvrId == '1S0AL') {
        	        custSeq = "046209";
        	    }
        	    */
        		
        		formObj.act_cust_seq.value = custSeq;
        		formObj.buyr_rgst_no.value = buyrRgstNo;
        		formObj.buyr_co_nm.value = buyrCoNm;
        		formObj.buyr_ceo_nm.value = buyrCeoNm;
        		formObj.buyr_addr1.value = buyrAddr1;
        		formObj.buyr_addr2.value = buyrAddr2;            	
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
			case IBSEARCH_ASYNC10:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObjects[0].WaitImageVisible = false; 
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH01;
					
					var actCustCntCd = formObj.act_cust_cnt_cd.value;
					var actCustSeq = formObj.act_cust_seq.value;
					
					var aryPrefix = new Array("sheet1_");
					
					var revisedAmountYn = formObj.revised_amount.checked;
					
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     			
	     			if(CoInvShowXmlMessage(sXml) != "") {
	     				ComAlertFocus(formObj.vvd, CoInvShowXmlMessage(sXml));
					} else {
			 			var sStr = ComGetEtcData(sXml,"msg_no");
			 			
			 			if (sStr != '') {
				 			var arrStr = sStr.split("|");
				 			//msg no
				 			MakeComboObject(formObj.msg_no, arrStr);
				 			
				 			formObj.act_cust_cnt_cd.value 	= actCustCntCd;
			     		 	formObj.act_cust_seq.value 		= actCustSeq;
			     		 	
			     		 	if (revisedAmountYn) {
				     		 	formObj.inv_xch_rt.value 		= ComAddCommaRun(ComGetEtcData(sXml,"inv_xch_rt"));                              
				     		 	formObj.sail_arr_dt.value 		= ComGetEtcData(sXml,"sail_arr_dt");
				     		 	formObj.bil_dt.value 			= ComGetEtcData(sXml,"bil_dt");
				     		 	formObj.locl_nm.value 			= ComGetEtcData(sXml,"locl_nm");
				     		 	formObj.cust_rgst_no.value 		= ComGetEtcData(sXml,"cust_rgst_no");
				     		 	formObj.e_sign.value 			= ComGetEtcData(sXml,"e_sign");
				     		 	formObj.bzet_addr.value 		= ComGetEtcData(sXml,"locl_addr1") + ComGetEtcData(sXml,"locl_addr2");
				     		 	formObj.ownr_nm.value 			= ComGetEtcData(sXml,"ownr_nm");
				     		 	formObj.edi_hdr_rmk.value 		= ComGetEtcData(sXml,"edi_hdr_rmk");
				     		 	formObj.snd_flg.value 			= ComGetEtcData(sXml,"snd_flg");
				     		 	formObj.inv_msg_func_cd.Code 	= ComGetEtcData(sXml,"inv_msg_func_cd");
				     		 	formObj.gerp_val_flg.Code 		= ComGetEtcData(sXml,"gerp_val_flg");
				     		 	
				     		 	//sheetObj.LoadSearchXml(sXml);
				     		 	sheetObjects[1].LoadSearchXml(sXml);
				     		 	
				     		 //임시 데이타 시작
				     		 	/*
				     		 	var temp = "TRLU9668151";
				     		 	var temp2 = "TRLU9668152";
				     		 	var temp3 = "TRLU9668153";
				     		 	var temp4 = "TRLU9668154";
				     		 	var temp5 = "TRLU9668155";
				     		 	var temp6 = "TRLU9668156";
				     		 	var temp7 = "TRLU9668157";
				     		 	var temp8 = "TRLU9668158";
				     		 	
				     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
				     		 		if(i%2 == 0){
				     		 			sheetObjects[1].CellValue(i,"sheet1_cntr_no") = temp;
				     		 		}else{
				     		 			sheetObjects[1].CellValue(i,"sheet1_cntr_no") = temp3;
				     		 		}			     		 		
				     		 	}
				     		 	sheetObjects[1].CellValue(1,"sheet1_cntr_no") = temp;
				     		 	sheetObjects[1].CellValue(2,"sheet1_cntr_no") = temp3;
				     		 	sheetObjects[1].CellValue(3,"sheet1_cntr_no") = temp3+"|"+temp4;
				     		 	sheetObjects[1].CellValue(4,"sheet1_cntr_no") = temp7;
				     		 	sheetObjects[1].CellValue(5,"sheet1_cntr_no") = temp6;
				     		 	sheetObjects[1].CellValue(6,"sheet1_cntr_no") = temp5+"|"+temp6;
				     		 	sheetObjects[1].CellValue(7,"sheet1_cntr_no") = temp8;
				     		 	sheetObjects[1].CellValue(8,"sheet1_cntr_no") = temp8;
				     		 	*/
				     		 	//임시 데이타 끝
				     		 	//Group 시작
				     		 	var cnt = 1;
				     		 	var cntr_no = "";
				     		 	var group = "";
				     		 	var index = "";						     		 				     		 				     		 
				     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
				     		 		//addCellComboItem(sheetObjects[1],sheetObjects[1].CellText(i,"sheet1_cntr_no"),"sheet1_cntr_no",true, i);
				     		 		var group = sheetObjects[1].CellValue(i,"sheet1_bl_cntr_grp_ctnt");
				     		 		var cntr_no = sheetObjects[1].CellValue(i,"sheet1_cntr_no");
				     		 		var arrStr = cntr_no.split("|");
				     		 		//if(group == ""){
					     		 		for (var j = 0; j < arrStr.length;j++ ) {
					     		  			if(arrStr[j] != "")	{			     		  				
					     		  				for (var z=1; z<=sheetObjects[1].RowCount; z++) {
					     		  					var group2 = sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt");
					     		  					var cntr_no2 = sheetObjects[1].CellValue(z,"sheet1_cntr_no");
					     		  					var arrStr2 = cntr_no2.split("|");
					     		  					//if(i==8) alert("arrStr2 : "+arrStr2);
					     		  					//if(group2 == ""){
									     		 		for (var x = 0; x < arrStr2.length;x++ ) {
									     		 			if(arrStr[j] == arrStr2[x]){
									     		 				var index = ComFindAll(sheetObjects[1], "sheet1_cntr_no",arrStr2[x],false,2);
									     		 				var index_1 = index+"|";
									     		 				var index2 = index_1.split("|");
									     		 				var group3 = sheetObjects[1].CellValue(index2[0],"sheet1_bl_cntr_grp_ctnt");
									     		 				//if(i==8) alert(arrStr2[x]+"::"+index+"::"+group3);
									     		 				//if(index != -1 && group3 != ""){								     		 					
									     		 					//sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt") = group3;
									     		 				if(index != -1 && group != ""){
									     		 					sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt") = group;
									     		 				}else{								     		 					
									     		 					sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt") = cnt;
									     		 				}
									     		 			}
									     		 		}
					     		  					//}	
					     		  				}
					     		  			}		     		  			
					     		  		}
				     		 		//}
				     		 		cnt++;
				     		 	}

				     		 	// sheet2 -> sheet1 로 복사함			     		 	
				     		 	sheetObjects[0].RemoveAll();
				     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
				     		 		sheetObjects[0].DataInsert(-1);			     		 					     		 				     		 
				     		 	}
				     		 	sheetObjects[1].Copy2SheetCol(sheetObjects[0],"","",-1,-1);
				     		 	sheetObjects[1].RemoveAll();
				     		 	
				     		 	//SHEET1 COLOR 설정
				     		 	sheetObjects[0].ColumnSort("sheet1_bl_cntr_grp_ctnt");
				     		 	for (var i=1; i<=sheetObjects[0].RowCount; i++) {
				     		 		sheetObjects[0].CellValue(i,"sheet1_No") = i;
				     		 		sheetObjects[0].CellText(i,"sheet1_No") = i;
				     		 	}
				     		 	setColor();	
				     		 	//Group 끝
				     		 	
								ComBtnEnable("btn_RowAdd");
								ComBtnEnable("btn_RowDelete");
								ComBtnEnable("btn_Save");
			     		 	}
			     		 	else {
			     		 		ComEnableObject(formObj.revised_amount, false);
			     		 	}			     		 				     		 	
			 			}
			 			else {
			     		 	formObj.inv_xch_rt.value 		= ComAddCommaRun(ComGetEtcData(sXml,"inv_xch_rt"));                              
			     		 	formObj.sail_arr_dt.value 		= ComGetEtcData(sXml,"sail_arr_dt");
			     		 	formObj.bil_dt.value 			= ComGetEtcData(sXml,"bil_dt");
			     		 	formObj.locl_nm.value 			= ComGetEtcData(sXml,"locl_nm");
			     		 	formObj.cust_rgst_no.value 		= ComGetEtcData(sXml,"cust_rgst_no");
			     		 	formObj.e_sign.value 			= ComGetEtcData(sXml,"e_sign");
			     		 	formObj.bzet_addr.value 		= ComGetEtcData(sXml,"locl_addr1") + ComGetEtcData(sXml,"locl_addr2");
			     		 	formObj.ownr_nm.value 			= ComGetEtcData(sXml,"ownr_nm");
			     		 	formObj.edi_hdr_rmk.value 		= ComGetEtcData(sXml,"edi_hdr_rmk");
			     		 	formObj.snd_flg.value 			= ComGetEtcData(sXml,"snd_flg");
			     		 	formObj.inv_msg_func_cd.Code 	= ComGetEtcData(sXml,"inv_msg_func_cd");
			     		 	formObj.gerp_val_flg.Code 		= ComGetEtcData(sXml,"gerp_val_flg");
			     		 	
			     		 	//sheetObj.LoadSearchXml(sXml);
			     		 	sheetObjects[1].LoadSearchXml(sXml);
			     		 	
			     		 	//임시 데이타 시작
			     		 	/*
			     		 	var temp = "TRLU9668151";
			     		 	var temp2 = "TRLU9668152";
			     		 	var temp3 = "TRLU9668153";
			     		 	var temp4 = "TRLU9668154";
			     		 	var temp5 = "TRLU9668155";
			     		 	var temp6 = "TRLU9668156";
			     		 	var temp7 = "TRLU9668157";
			     		 	
			     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
			     		 		if(i%2 == 0){
			     		 			sheetObjects[1].CellValue(i,"sheet1_cntr_no") = temp;
			     		 		}else{
			     		 			sheetObjects[1].CellValue(i,"sheet1_cntr_no") = temp3;
			     		 		}			     		 		
			     		 	}
			     		 	sheetObjects[1].CellValue(1,"sheet1_cntr_no") = temp3+"|"+temp4;
			     		 	sheetObjects[1].CellValue(2,"sheet1_cntr_no") = temp5+"|"+temp4+"|"+temp6;
			     		 	sheetObjects[1].CellValue(3,"sheet1_cntr_no") = temp2;
			     		 	sheetObjects[1].CellValue(4,"sheet1_cntr_no") = temp4;
			     		 	sheetObjects[1].CellValue(5,"sheet1_cntr_no") = temp+"|"+temp2;
			     		 	sheetObjects[1].CellValue(6,"sheet1_cntr_no") = temp7;
			     		 	sheetObjects[1].CellValue(7,"sheet1_cntr_no") = temp4;
			     		 	sheetObjects[1].CellValue(8,"sheet1_cntr_no") = temp2;
			     		 	*/
			     		 	//임시 데이타 끝
			     		 	
			     		 	/*
			     		 	var cnt = 1;
			     		 	var cntr_no_all = "";
			     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
			     		 		cntr_no_all = cntr_no_all+"|"+sheetObjects[1].CellText(i,"sheet1_cntr_no");
			     		 	}
			     		 	var arrStr = cntr_no_all.split("|");
			     		 	for (var i = 0; i < arrStr.length;i++ ) {
			     		 		if(arrStr[i] != ""){
			     		 			var index = ComFindAll(sheetObjects[1], "sheet1_cntr_no",arrStr[i],false,2);			     		 			
			     		 			index = index+"|";
			     		 			var arrStr2 = index.split("|");
			     		 			var cntr_no = "";
			     		 			var group = "";
			     		 			//alert(arrStr2);
			     		 			for (var j = 0; j < arrStr2.length;j++ ) {
			     		 				if(arrStr2[j] != ""){
				     		 				group = sheetObjects[1].CellValue(arrStr2[j],"sheet1_bl_cntr_grp_ctnt");
				     		 				if(group == ""){
				     		 					sheetObjects[1].CellValue(arrStr2[j],"sheet1_bl_cntr_grp_ctnt") = cnt;
				     		 				}
			     		 				}
			     		 			}
			     		 			cnt++;
			     		 		}
			     		 	}*/			     		 	
			     		 	
			     		 	
			     		 	var cnt = 1;
			     		 	var cntr_no = "";
			     		 	var group = "";
			     		 	var index = "";						     		 				     		 				     		 
			     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
			     		 		//addCellComboItem(sheetObjects[1],sheetObjects[1].CellText(i,"sheet1_cntr_no"),"sheet1_cntr_no",true, i);
			     		 		var group = sheetObjects[1].CellValue(i,"sheet1_bl_cntr_grp_ctnt");
			     		 		var cntr_no = sheetObjects[1].CellValue(i,"sheet1_cntr_no");
			     		 		var arrStr = cntr_no.split("|");
			     		 		//if(group == ""){
				     		 		for (var j = 0; j < arrStr.length;j++ ) {
				     		  			if(arrStr[j] != "")	{			     		  				
				     		  				for (var z=1; z<=sheetObjects[1].RowCount; z++) {
				     		  					var group2 = sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt");
				     		  					var cntr_no2 = sheetObjects[1].CellValue(z,"sheet1_cntr_no");
				     		  					var arrStr2 = cntr_no2.split("|");
				     		  					//if(i==8) alert("arrStr2 : "+arrStr2);
				     		  					//if(group2 == ""){
								     		 		for (var x = 0; x < arrStr2.length;x++ ) {
								     		 			if(arrStr[j] == arrStr2[x]){
								     		 				var index = ComFindAll(sheetObjects[1], "sheet1_cntr_no",arrStr2[x],false,2);
								     		 				var index_1 = index+"|";
								     		 				var index2 = index_1.split("|");
								     		 				var group3 = sheetObjects[1].CellValue(index2[0],"sheet1_bl_cntr_grp_ctnt");
								     		 				//if(i==8) alert(arrStr2[x]+"::"+index+"::"+group3);
								     		 				//if(index != -1 && group3 != ""){								     		 					
								     		 					//sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt") = group3;
								     		 				if(index != -1 && group != ""){
								     		 					sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt") = group;
								     		 				}else{								     		 					
								     		 					sheetObjects[1].CellValue(z,"sheet1_bl_cntr_grp_ctnt") = cnt;
								     		 				}
								     		 			}
								     		 		}
				     		  					//}	
				     		  				}
				     		  			}		     		  			
				     		  		}
			     		 		//}
			     		 		cnt++;
			     		 	}

			     		 	// sheet2 -> sheet1 로 복사함			     		 	
			     		 	sheetObjects[0].RemoveAll();
			     		 	for (var i=1; i<=sheetObjects[1].RowCount; i++) {
			     		 		sheetObjects[0].DataInsert(-1);			     		 					     		 				     		 
			     		 	}
			     		 	sheetObjects[1].Copy2SheetCol(sheetObjects[0],"","",-1,-1);
			     		 	sheetObjects[1].RemoveAll();
			     		 	
			     		 	//SHEET1 COLOR 설정
			     		 	sheetObjects[0].ColumnSort("sheet1_bl_cntr_grp_ctnt");
			     		 	for (var i=1; i<=sheetObjects[0].RowCount; i++) {
			     		 		sheetObjects[0].CellValue(i,"sheet1_No") = i;
			     		 		sheetObjects[0].CellText(i,"sheet1_No") = i;
			     		 	}
			     		 	setColor();			     		 	
			     		 	
			     		 	ComBtnEnable("btn_RowAdd");
							ComBtnEnable("btn_RowDelete");
							ComBtnEnable("btn_Save");
			     		 		
			 			}
					}
	     			ComOpenWait(false);
	     			sheetObjects[0].WaitImageVisible = true;
				}
			break;
			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH02;
					
					var aryPrefix = new Array("sheet1_");
					
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

	     		 	formObj.inv_xch_rt.value 		= ComAddCommaRun(ComGetEtcData(sXml,"inv_xch_rt"));                              
	     		 	formObj.sail_arr_dt.value 		= ComGetEtcData(sXml,"sail_arr_dt");
	     		 	formObj.bil_dt.value 			= ComGetEtcData(sXml,"bil_dt");
	     		 	formObj.locl_nm.value 			= ComGetEtcData(sXml,"locl_nm");
	     		 	formObj.cust_rgst_no.value 		= ComGetEtcData(sXml,"cust_rgst_no");
	     		 	formObj.e_sign.value 			= ComGetEtcData(sXml,"e_sign");
	     		 	formObj.bzet_addr.value 		= ComGetEtcData(sXml,"locl_addr1") + ComGetEtcData(sXml,"locl_addr2");
	     		 	formObj.ownr_nm.value 			= ComGetEtcData(sXml,"ownr_nm");
	     		 	formObj.edi_hdr_rmk.value 		= ComGetEtcData(sXml,"edi_hdr_rmk");
	     		 	formObj.snd_flg.value 			= ComGetEtcData(sXml,"snd_flg");
	     		 	formObj.inv_msg_func_cd.Code 	= ComGetEtcData(sXml,"inv_msg_func_cd");
	     		 	formObj.gerp_val_flg.Code 		= ComGetEtcData(sXml,"gerp_val_flg");

	     		 	sheetObj.LoadSearchXml(sXml);
	     		 	
	     		 	sheetObj.HeadCheck(0, "sheet1_DelChk") = false;

					ComBtnEnable("btn_RowAdd");
					ComBtnEnable("btn_RowDelete");
					ComBtnEnable("btn_Save");
					ComBtnEnable("btn_Delete");
					ComBtnEnable("btn_DownExcel");
					ComBtnEnable("btn_SendBL");	
					
					setColor();
				}
			break;
			
			case IBINSERT:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI01;
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObj.GetSaveString(false, true, 1);
					if (sParam1 == "") {
						return;
					} else {
						sParam = sParam + "&" + sParam1;
					}

					var sXml = sheetObj.GetSaveXml("FNS_INV_0045GS.do", sParam);
					if (sXml.indexOf("ERROR") < 1){
						var msgNo = ComGetEtcData(sXml,"msg_no");

						if (msgNo == "Duplicated") {
							var message = ComGetMsg("INV00021");
							if (confirm(message)) {
								formObj.force_to_save.value = "Y";
								sParam = FormQueryString(formObj);
								sParam1 = sheetObj.GetSaveString(false, true, 1);
								if (sParam1 == "") {
									return;
								} else {
									sParam = sParam + "&" + sParam1;
								}

								sXml = sheetObj.GetSaveXml("FNS_INV_0045GS.do", sParam);
								if (sXml.indexOf("ERROR") < 1){
									msgNo = ComGetEtcData(sXml,"msg_no");
								} else {
									ComShowCodeMessage("INV00053");
									return;
								}
							} else {
								return;
							}
						}

		     		 	// 문서번호중 공백은 삭제한다.
		     		 	var code = comboObjects[1].FindIndex("", 0);
						if (comboObjects[1].getText("", 0) == '') {
							comboObjects[1].DeleteItem(code);
						}
						
						//리턴받은 문서번호를 문서번호 콤보박스에 넣어준다.
						comboObjects[1].InsertItem(-1, msgNo, msgNo);
						//comboObjects[1].Code = msgNo;
						formObj.msg_no.text2 = msgNo;
						
						//doActionIBSheet(sheetObj,formObj,IBSEARCH);
						
						ComEnableObject(formObj.revised_amount, false);

						for (var i=1; i<=sheetObj.RowCount; i++) {
							sheetObj.CellEditable(i, "sheet1_sr_inv_no") = false;
						}

						ComShowCodeMessage("INV00051");
					} else {
						ComShowCodeMessage("INV00053");
					}
					ComBtnDisable("btn_Save");
					ComBtnEnable("btn_DownExcel");
					ComBtnEnable("btn_SendBL");
				}
			break;
			
			case IBSEARCH_ASYNC11:      // 삭제
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI02;
					var sParam = FormQueryString(formObj);
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0045GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						removeAll(formObj);
						
						// 삭제 성공 메시지 처리
						ComShowCodeMessage("INV00057");
					}
					else {
						// 삭제 실패 메시지 처리
						ComShowCodeMessage("COM12197");
					}
				}
			break;
			
			case IBSEARCH_ASYNC12:        //send
				if (validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI03;
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObj.GetSaveString(false, true, 1);

					if (sParam1 == "") {
						return;
					}

					var params = sParam1.split("&sheet1_ibflag=");
					var maxSendCount = 50;
					var param = "";
					var isSuccess = true;
					for (var i=0; i<params.length; i++) {
						if (i != 0) {
							params[i] = "sheet1_ibflag=" + params[i];
						}
						param = param + "&" + params[i];

						if ((i != 0 && (i+1)%maxSendCount == 0) || (i == (params.length - 1))) {
							var num = new Number(i / maxSendCount);
							var startIdx = (parseInt(num) * maxSendCount) + 1;

							var sXml = sheetObj.GetSaveXml("FNS_INV_0045GS.do", (sParam + "&send_start_idx=" + startIdx + param));
							if (!(sXml.indexOf("OK") > -1)) {
								isSuccess = false;
								break;
							}
							param = "";
						}
					}

					if (isSuccess) {
						//성공 메시지 처리
						ComShowCodeMessage("INV00086");
					} else {
						// 실패 메시지 처리
						ComShowCodeMessage("INV00087");
					}
				}
			break;

			case IBSEARCH_ASYNC13:      //bl no 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH03;
					
					var actCustCntCd = formObj.act_cust_cnt_cd.value;
					var actCustSeq = formObj.act_cust_seq.value;
					
					var aryPrefix = new Array("sheet1_");
					
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     			
	     			if(CoInvShowXmlMessage(sXml) != ""  ||  ComGetEtcData(sXml,"bl_src_no") == "null" ) {
	     				ComShowCodeMessage("INV00088");
	     				sheetObj.CellValue2(sheetObj.SelectRow, 3) = "";
	     				sheetObj.SelectCell(sheetObj.SelectRow, "sheet1_bl_src_no");
					} else {
						var prefix="sheet1_";
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "bl_src_no") = ComGetEtcData(sXml,"bl_src_no");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "sr_inv_no") = ComGetEtcData(sXml,"sr_inv_no");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "por_cd") = ComGetEtcData(sXml,"por_cd");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "pol_cd") = ComGetEtcData(sXml,"pol_cd");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "pod_cd") = ComGetEtcData(sXml,"pod_cd");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "del_cd") = ComGetEtcData(sXml,"del_cd");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "inv_edi_d2_qty") = ComGetEtcData(sXml,"inv_edi_d2_qty");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "inv_edi_d4_qty")= ComGetEtcData(sXml,"inv_edi_d4_qty");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "inv_edi_d5_qty")= ComGetEtcData(sXml,"inv_edi_d5_qty")
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "inv_edi_d7_qty")= ComGetEtcData(sXml,"inv_edi_d7_qty");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "inv_edi_etc_qty")= ComGetEtcData(sXml,"inv_edi_etc_qty");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "grs_cntr_wgt")= ComGetEtcData(sXml,"grs_cntr_wgt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "grs_cbm_capa")= ComGetEtcData(sXml,"grs_cbm_capa");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "oft_amt")= ComGetEtcData(sXml,"oft_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "cms_amt")= ComGetEtcData(sXml,"cms_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "otr_amt")= ComGetEtcData(sXml,"otr_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "thc_amt")= ComGetEtcData(sXml,"thc_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "dhf_amt")= ComGetEtcData(sXml,"dhf_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "whf_amt")= ComGetEtcData(sXml,"whf_amt")
						//sheetObj.CellValue(sheetObj.SelectRow, prefix + "cfr_amt")= ComGetEtcData(sXml,"cfr_amt");
						//sheetObj.CellValue(sheetObj.SelectRow, prefix + "baf_amt")= ComGetEtcData(sXml,"baf_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "slf_amt")= ComGetEtcData(sXml,"slf_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "oth_amt")= ComGetEtcData(sXml,"oth_amt");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "snd_flg")= ComGetEtcData(sXml,"snd_flg");
						sheetObj.CellValue(sheetObj.SelectRow, prefix + "cntr_no")= ComGetEtcData(sXml,"cntr_no");
						/*
						sheetObj.CellValue(sheetObj.SelectRow, 3) = ComGetEtcData(sXml,"bl_src_no");
						sheetObj.CellValue(sheetObj.SelectRow, 4) = ComGetEtcData(sXml,"sr_inv_no");
						sheetObj.CellValue(sheetObj.SelectRow, 5) = ComGetEtcData(sXml,"por_cd");
						sheetObj.CellValue(sheetObj.SelectRow, 6) = ComGetEtcData(sXml,"pol_cd");
						sheetObj.CellValue(sheetObj.SelectRow, 7) = ComGetEtcData(sXml,"pod_cd");
						sheetObj.CellValue(sheetObj.SelectRow, 8) = ComGetEtcData(sXml,"del_cd");
						sheetObj.CellValue(sheetObj.SelectRow, 9) = ComGetEtcData(sXml,"inv_edi_d2_qty");
						sheetObj.CellValue(sheetObj.SelectRow, 10)= ComGetEtcData(sXml,"inv_edi_d4_qty");
						sheetObj.CellValue(sheetObj.SelectRow, 11)= ComGetEtcData(sXml,"inv_edi_d5_qty")
						sheetObj.CellValue(sheetObj.SelectRow, 12)= ComGetEtcData(sXml,"inv_edi_d7_qty");
						sheetObj.CellValue(sheetObj.SelectRow, 13)= ComGetEtcData(sXml,"inv_edi_etc_qty");
						sheetObj.CellValue(sheetObj.SelectRow, 14)= ComGetEtcData(sXml,"grs_cntr_wgt");
						sheetObj.CellValue(sheetObj.SelectRow, 15)= ComGetEtcData(sXml,"grs_cbm_capa");
						sheetObj.CellValue(sheetObj.SelectRow, 16)= ComGetEtcData(sXml,"oft_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 17)= ComGetEtcData(sXml,"cms_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 18)= ComGetEtcData(sXml,"otr_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 19)= ComGetEtcData(sXml,"thc_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 20)= ComGetEtcData(sXml,"dhf_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 21)= ComGetEtcData(sXml,"whf_amt")
						sheetObj.CellValue(sheetObj.SelectRow, 22)= ComGetEtcData(sXml,"cfr_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 23)= ComGetEtcData(sXml,"baf_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 24)= ComGetEtcData(sXml,"oth_amt");
						sheetObj.CellValue(sheetObj.SelectRow, 25)= ComGetEtcData(sXml,"snd_flg");
						*/
					}
	     			
	     			//group, 색 세팅	     			
	     			var cntr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_cntr_no");
	     			var arrStr = cntr_no.split("|");
	     			for (var j = 0; j < arrStr.length;j++ ) {
	     				var index = ComFindAll(sheetObjects[0], "sheet1_cntr_no",arrStr[j],false,2);
	     				index = index+"|";
 		 				var index2 = index.split("|");
	     				if(index2.length <= 2){	     					
	     					sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_bl_cntr_grp_ctnt") = Number(sheetObjects[0].CellValue(sheetObjects[0].RowCount-1,"sheet1_bl_cntr_grp_ctnt"))+1;
	     				}else{
	 		 				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_bl_cntr_grp_ctnt") = sheetObjects[0].CellValue(index2[0],"sheet1_bl_cntr_grp_ctnt");
	     				}
	     			}
	     			setColor();
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
					if(vvd.value == "") {
						ComShowCodeMessage("INV00004");
						vvd.focus();
						return false;
					}
					if(rcvr_id.text == "") {
						ComShowCodeMessage("INV00004");
						rcvr_id.focus();
						return false;
					}
					if(msg_no.text == "") {
						ComShowCodeMessage("INV00004");
						msg_no.focus();
						return false;
					}
				}
			break;
			
			case IBSEARCH_ASYNC10:      //문서번호 조회
				with(formObj){
					if(vvd.value == "") {
						ComShowCodeMessage("INV00004");
						vvd.focus();
						return false;
					}
					if(rcvr_id.text == "") {
						ComShowCodeMessage("INV00004");
						rcvr_id.focus();
						return false;
					}
				}
			break;
			
			case IBINSERT:      //저장
				with(formObj){
					if(vvd.value == "") {
						ComShowCodeMessage("INV00004");
						vvd.focus();
						return false;
					}
					if(rcvr_id.text == "") {
						ComShowCodeMessage("INV00004");
						rcvr_id.focus();
						return false;
					}
					
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
			
			case IBSEARCH_ASYNC13:      // bl no 조회
				with(formObj){
					var inputBlNo = sheetObj.CellValue(sheetObj.SelectRow, 3);
					var idx = sheetObj.RowCount;
					
					if (idx > 0) {
						for (var i = 1 ; i < idx+1 ; i++){
							for (var j = 1 ; j < sheetObj.RowCount+1 ; j++){
								if (j != sheetObj.SelectRow && sheetObj.CellValue(j,3) == inputBlNo){
									ComShowCodeMessage("INV00017");
									sheetObj.CellValue2(sheetObj.SelectRow, 3) = "";
									sheetObj.SelectCell(sheetObj.SelectRow, 3);
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
		//입력폼 전체 초기화
		formObj.reset();
		
		ComEnableObject(formObj.revised_amount, true);
	 	
		//청구일자 초기화
		setDefaultDateValue(formObj);
		
		//B/L & Charge 그리드 초기화
		sheetObjects[0].RemoveAll();
		
		//콤보 초기화
		comboObjects[1].RemoveAll();		//문서번호
		comboObjects[0].Code = "";			//업체명
		comboObjects[2].Code = "9";			//원본여부
		comboObjects[3].Code = "Y";			//Validation Check
		
		//버튼 초기화
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDelete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_SendBL");
		
		formObj.vvd.focus();
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
   		
   		formObj.bil_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
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
		calKrwAmt(sheetObj);
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
		
    	// B/L No
    	if (Col == 3 && Value != '') {
    		formObj.grid_bl_src_no.value = Value;
    		
    		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC13);
    	}
		
		calKrwAmt(sheetObj);
	}
	
    /** 
     * 청구금액 계산<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.10.05
     */
	function calKrwAmt(sheetObj) {
		var formObj = document.form;
		
		//var oftAmt = 0;
		var chgKrwAmt = 0;
		var chgUsdAmt = 0;
		var taxAmt = 0;
		var invXchRt = formObj.inv_xch_rt.value;
		
		var prefix="sheet1_";
		
		if (sheetObj.rowCount > 0 && invXchRt != "") {
			for(var i=1; i<=sheetObj.rowCount; i++){
				//oftAmt = ComRound(parseFloat(oftAmt), 2) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"oft_amt")), 2);
				chgKrwAmt = Number(chgKrwAmt) + Number(sheetObj.CellValue(i, prefix+"thc_amt")) + Number(sheetObj.CellValue(i, prefix+"whf_amt")) + Number(sheetObj.CellValue(i, prefix+"dhf_amt")) + Number(sheetObj.CellValue(i, prefix+"slf_amt"));
				chgUsdAmt = parseFloat(chgUsdAmt) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"oft_amt")), 2) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"cms_amt")), 2) + ComRound(parseFloat(sheetObj.CellValue(i, prefix+"otr_amt")), 2);
			}
			
			formObj.bil_oft_amt.value = setCurrPointValue(chgUsdAmt,2);
			formObj.bil_chg_amt.value = ComAddComma(chgKrwAmt);
			formObj.bil_tax_amt.value = 0;
		}
		else {
			formObj.bil_oft_amt.value = 0;
			formObj.bil_chg_amt.value = 0;
			formObj.bil_tax_amt.value = 0;
		}
	}
   	
	/** 
	 * rcvr_id(업체명) 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
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
	function rcvr_id_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var vvd = formObj.vvd.value;
		
		//입력폼 전체 초기화
		formObj.reset();
		//조회조건 설정
		formObj.vvd.value = vvd;
		
		//Retrieve for revised amount 초기화
		ComEnableObject(formObj.revised_amount, true);
		
		//청구일자 초기화
		setDefaultDateValue(formObj);
		
		//B/L & Charge 그리드 초기화
		sheetObjects[0].RemoveAll();
		
		//콤보 초기화
		comboObjects[1].RemoveAll();	//문서번호
		comboObjects[2].Code = "9";		//원본여부
		comboObjects[3].Code = "Y";		//Validation Check
		
		//버튼 초기화
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDelete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_SendBL");
		
		//업체명에 맞는 hidden value 설정
		formObj.act_cust_cnt_cd.value = 'KR';
		
		var custSeq = "";
		var buyrRgstNo = ComReplaceStr(formObj.cust_rgst_no.value,"-","");
		var buyrCoNm = formObj.locl_nm.value;
		var buyrCeoNm = formObj.ownr_nm.value;
		var buyrAddr1 = formObj.bzet_addr.value;
		var buyrAddr2 = "";
		
		// index code는 중복되므로 selected Index 로 수정, variable은 line 50 참조	2012.02.21 권   민 [CHM-201216352]
		var idx	= comboObj.index;
		if (idx == 1) {
			custSeq = custCode_1;
		}
		else if (idx == 2) {
			custSeq = custCode_2;
		}
		else if (idx == 3) {
			custSeq = custCode_3;
		}
		else if (idx == 4) {
			custSeq = custCode_4;
		}
		else if (idx == 5) {
			custSeq = custCode_5;
		}
		else if (idx == 6) {
			   custSeq = custCode_6;
		}
		else if (idx == 7) {
			   custSeq = custCode_7;
		}
		else if (idx == 8) {
			   custSeq = custCode_8;
		}
		/*
		if (Index_Code == 'C1T0W') {
			custSeq = "000585";
		}
		else if (Index_Code == 'FSELC') {
			custSeq = "010510";
		}
		else if (Index_Code == 'C1T0S') {
			custSeq = "038221";
		}
		else if (Index_Code == 'C1T0M') {
			custSeq = "027679";
		}
		else if (Index_Code == '110AL') {
			custSeq = "012641";
		}
		else if (Index_Code == '1S0AL') {
			   custSeq = "046209";
		}
		*/
		
		formObj.act_cust_seq.value = custSeq;
		formObj.buyr_rgst_no.value = buyrRgstNo;
		formObj.buyr_co_nm.value = buyrCoNm;
		formObj.buyr_ceo_nm.value = buyrCeoNm;
		formObj.buyr_addr1.value = buyrAddr1;
		formObj.buyr_addr2.value = buyrAddr2;
	}

	function inv_msg_func_cd_OnChange(comboObj, indexCode, text) {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;

		ComOpenWait(true);
		if (indexCode == 7) {
			if (document.form.revised_amount.checked == true && sheetObject.RowCount > 0) {
				var blSrcNo = "";
				var seq = 0;

				for (var i=1; i<=sheetObject.RowCount; i++) {
					if (blSrcNo != sheetObject.CellValue(i, "sheet1_bl_src_no")) {
						blSrcNo = sheetObject.CellValue(i, "sheet1_bl_src_no");
						var maxSrInvNo = sheetObject.CellValue(i, "sheet1_sr_inv_no_seq");
						var seqs = maxSrInvNo.split("-");
						if (seqs.length < 2) {
							seq = 1;
						} else {
							seq = parseInt(seqs[1]) + 1;
						}
					} else {
						seq = seq + 1;
					}


					var srInvNos = sheetObject.CellValue(i, "sheet1_sr_inv_no").split("-");
					var srInvNo = "";
					if (seq.toString().length > 1) {
						srInvNo = srInvNos[0] + "-" + seq;
					} else {
						srInvNo = srInvNos[0] + "-0" + seq;
					}

					sheetObject.CellValue2(i, "sheet1_sr_inv_no") = srInvNo;
					sheetObject.CellEditable(i, "sheet1_sr_inv_no") = true;
				}
			}
		} else {
			if (sheetObject.RowCount > 0) {
				for (var i=1; i<=sheetObject.RowCount; i++) {
					var srInvNos = sheetObject.CellValue(i, "sheet1_sr_inv_no").split("-");
					sheetObject.CellValue2(i, "sheet1_sr_inv_no") = srInvNos[0];
					sheetObject.CellEditable(i, "sheet1_sr_inv_no") = false;
				}
			}
		}

		ComOpenWait(false);
	}

	/** 
	 * msg_no(문서번호) 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
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
	function msg_no_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var vvd = formObj.vvd.value;
		var actCustCntCd = formObj.act_cust_cnt_cd.value;
		var actCustSeq = formObj.act_cust_seq.value;
		var revisedAmountYn = formObj.revised_amount.checked;
		
		//입력폼 전체 초기화
		formObj.reset();
		
		//조회조건 설정
		formObj.vvd.value = vvd;
		formObj.act_cust_cnt_cd.value = actCustCntCd;
		formObj.act_cust_seq.value = actCustSeq;
		formObj.revised_amount.checked = revisedAmountYn;

		//청구일자 초기화
		setDefaultDateValue(formObj);
		
		//B/L & Charge 그리드 초기화
		sheetObjects[0].RemoveAll();
		
		//콤보 초기화
		comboObjects[2].Code = "9";		//원본여부
		comboObjects[3].Code = "Y";		//Validation Check
		
		if (Text != '') {
			ComEnableObject(formObj.revised_amount, false);
			formObj.revised_amount.checked = false;
		}
		else {
			ComEnableObject(formObj.revised_amount, true);
			formObj.revised_amount.checked = true;
		}
		
		//버튼 초기화
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDelete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_SendBL");
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
	 * 그리드를 제외한 입력항목의 화폐의 소수점 자리에 따라 값을 변경해준다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {object} amtVal        
     * @param {object} currPoint  
     * @return {object} return_value
     * @see #
     * @author 박정진
     * @version 2009.10.05
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
	/* 개발자 작업  끝 */