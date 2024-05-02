/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0015.js
*@FileTitle : Coastal SKD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.11 Jung Jinwoo
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 	Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.05.03 진마리아 CHM-201110591-01 	[VOP-VSK] Actual SKD 입력된 Port 이전의 Port에 대한 Skip 가능
* 2011.05.19 진마리아 CHM-201110591-01 	Actual이 입력된 Port의 이전 Port(Actual 미입력)에 대해 Skip 버튼 활성화
* 2011.07.13 김기종   	CHM-201112331-01 	1. Port 간 Distance 변경은 P/F에 설정된 Distance 보다 작거나 같도로 체크 로직 추가
*                                   	2. Phase out시 Distance는 0 으로 설정, Phase Out Cancel시 P/F Distance 로 설정
* 2012.03.20 진마리아 CHM-201216747-01 	Coastal SKD내 Actual SKD 바로 가기 버튼 추가
* 2012.07.25 진마리아 CHM-201219175-01 	e-mail 상 지연시간 표시
* 2013.08.26 정상기	[CHM-201326339]		[VOP-VSK] Distance 입력 값에 대한 제한 삭제 (PF distance 보다 작거나 같음)
* 2015.06.24 이병훈	[CHM-201536225] CSKED Update and Simulation 버튼 및 불필요한 기능 삭제
* 2015.07.03 이병훈	[CHM-201536734] [PSX] C SKED Update Add call 기능 관련 수정
* 2015.09.11 이병훈	[CHM-201537672] Sea delay time 로직 변경
=========================================================*/
/****************************************************************************************
 * 2009.06.24
 * 1. Port Time = (CGO(in)+CGO(out)) / TMNL Prod.
 *    CGO(in), CGO(out), TMNL Prod 가 변경이 되면 Port Time 계산하는 로직 추가.
 *    
 * 2009.06.30
 * 1. 조회조건 변경 시 SHEET 초기화
 * 2. SHEET 선택 시 해당 ROW의 VVD를 조회조건의 VVD로 셋팅.
 * 
 * 2010.07.08
 * 1. Auto Update 시(function calcSchedule) MNVR_IN, MNVR_OUT 이 0인 경우 특정값으로 변환(controlMnvrHrs) 하도록 수정.
 * 
 * 2010.07.12
 * <<20100712_01>>
 * ETD ~ ETA 항해시간으로 Sea Delay Time을 구하지 않고(기존)
 * P/F ETA보다 Delay 되었을때 Sea Delay Time을 계산한다. 그리고 그 값이 8이상일때만 Delay Reason Code 필수 체크한다.
 * 
 * 2010.07.20
 * <<20100720_01>>
 * 게시판에 등록되는 스케쥴 내용 변경
 * 
 * 2010.08.13
 * [CHM-201005103-01]
 * SKD 업데이트시 P/F SKD 정보도 변경
 * [CHM-201005084-01]
 * Sea delay time이 사라지면 입력된 Delay reason 삭제
 * [CHM-201005255-01]
 * SKD Auto Update시 Estimate SKD가 Advanced 상태이면 P/F SKD의 값을 취함
 * 
 * 2010.08.16
 * <<20100816_01>>
 * [CHM-201005255-01] 관련하여
 * AUTO UPDATE 시 어느 순간(ETA/ETB/ETD)에 회복(EST==PF)이 되면
 * 그 이후 스케쥴은 계산할 필요없이 무조건 PF로 적용한다.
 * 
 * 2010.08.31 유혁 위의 [CHM-201005255-01] 관련하여 PF 적용시
 * PF가 없는 경우도 있으므로(ex. Add Calling Port) getPfDateColName 함수를 이용한다.
 *
 * 2010.09.29 CHM-201005617-01 유혁 Coastal SKD Update 로직 변경 
 * 2010.10.13 CHM-201006456-01 유혁 SKD Auto Update 기능 보완
 * 2010.10.21 CHM-201006456-01 유혁 SKD Auto Update 기능 보완(Row Hide 관련)
 ****************************************************************************************/


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
	 * @class VOP_VSK_0015 : VOP_VSK_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_VSK_0015() {
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
	// 현재 포커스를 가지고 있는 객체명 변수
	var focusObj = null; 

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var SKD_SHEET_SIZE 		= 464;
	var PLN_SHEET_SIZE 		= 318;
	
	//
	var glbSheetFlg 		= "sheet1";
	var glbSheetHeight 		= PLN_SHEET_SIZE;
	var glbSkdPortFlgs 		= new Array();		// Coastal SKD Sheet의 Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
	var glbPlanPortFlgs 	= new Array();		// Recovery plan Sheet의 Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
	var glbTmlFlg 			= "N";				// yd_cd 변경 시 mnvr_in_hrs/mnvr_out_hrs 을 조회할 지 여부(Row 조회 시 yd_cd 변경 될 때에는 막음).
	var gblSheet1CngStsCd 	= "";				// Sheet1의 skd_cng_sts_cd 변경 시 phase in, phase out 만 저장되도록 하기 위해 선택했을 당시의 값을 임시로 저장.
	var gblSheet2CngStsCd 	= "";				// Sheet2의 skd_cng_sts_cd 변경 시 phase in, phase out 만 저장되도록 하기 위해 선택했을 당시의 값을 임시로 저장.
	var gblSheet3CngStsCd 	= "";
	
	// Form Data 선언.
	var glbSheet1FormData 	= null;
	var glbSheet2FormData 	= null;
	var glbSheet3FormData 	= null;
	
	// Color 전역변수
	var glbActualColor 		= null;
	var glbHQColor 			= null;
	var glbNoonColor 		= null;
	var glbDepartureColor 	= null;
	var glbInitialColor 	= null;

	var glbEditColor 		= null;
	var glbDelayFontColor 	= null;
	var glbAdvanceFontColor = null;
	var glbNormalFontColor 	= null;
	var glbTestColor 		= null;
	
	var glbMainVslCd 		= "";
	var glbMainSkdVoyNo 	= "";
	var glbMainSkdDirCd 	= "";
	var glbMainVslSlanCd 	= "";
	var glbMainVslEngNm 	= "";
	var glbMainVslKrnNm 	= "";
	
	// Bunker Additional Cost : calcBunkerAdditionalCost()
	var glbFocHr 			= 0.0;
	var glbSpdP 			= 0.0;
	var glbSlip 			= 0.0;

	var controlAuto			= 0;
	
	var updateMon			= 0;
	var updateVVD			= "";
	
	var conti_recovery		= "N";
	// to prevent yard change in the Double calling case. 2015.01.05
	var originalVVDYard		= null;
	var originalVVDSeq		= null;
	var addcallVVDYard		= null;
	var currentVVDYard		= null;
	var currentVVDSeq		= null;

	var yardCngFlg			= "N";
//	var arr = new Array(2);
//	for(var i=0; i<=4; i++){
//		arr[i] = new Array(5)
//	}
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * 
	 * @return
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  	= sheetObjects[0];   // t1sheet1
		var sheetObject2  	= sheetObjects[1];   // t1sheet2
		var sheetObject3  	= sheetObjects[2];   // t1sheet3
		/** **************************************************** */
		var formObject 		= document.form;
    	var sUrl 			= "";
		var sheetObj 		= null;

		if(glbSheetFlg == "sheet3"){
			sheetObj = sheetObject3;
		} else if(glbSheetFlg == "sheet2"){
			sheetObj = sheetObject2;
		} else {
			sheetObj = sheetObject1;
		}

		try {
	    	var prefix = sheetObj.id + "_";
			var srcName = window.event.srcElement.getAttribute("name");
			
			// disabled된 button은 Event 실행을 막는다.
			if(window.event.srcElement.className.indexOf('_1') > 0){
				return;
			}

			switch(srcName) {
				/*
				case "btn_row_hide_1":
				case "btn_row_hide_2":
					doActionIBSheet(sheetObj,formObject,COMMAND02);
					break;
				 */
				case "btn_skip_call_1":
				case "btn_skip_call_2":
					doActionIBSheet(sheetObj,formObject,COMMAND03);
					break;
	
				case "btn_add_call_1":
				case "btn_add_call_2":
					doActionIBSheet(sheetObj,formObject,COMMAND04);
					break;

				case "btn_reverse_call_1":
				case "btn_reverse_call_2":
					doActionIBSheet(sheetObj,formObject,COMMAND05);
					break;
				/*
				case "btn_row_hide_cancel_1":
				case "btn_row_hide_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND06);
					break;
				*/
				case "btn_cost_calculation_1":
					doActionIBSheet(sheetObjects[2],formObject,SEARCH13);
					break;
					
				case "btn_skip_call_cancel_1":
				case "btn_skip_call_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND07);
					break;

				case "btn_add_call_cancel_1":
				case "btn_add_call_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND08);
					break;

				case "btn_reverse_call_cancel_1":
				case "btn_reverse_call_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND09);
					break;

				case "btn_p_out_1":
				case "btn_p_out_2":
					doActionIBSheet(sheetObj,formObject,COMMAND20);
					break;

				case "btn_p_out_cancel_1":
				case "btn_p_out_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND21);
					break;
					
				case "btn_col_show":
				case "btn_plan_col_show":
					doActionIBSheet(sheetObj,formObject,COMMAND10);
					break;
					
				case "btn_col_hide":
				case "btn_plan_col_hide":
					doActionIBSheet(sheetObj,formObject,COMMAND11);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObj,formObject,IBSEARCH);
					break;

				case "btn_new":
					doActionIBSheet(sheetObj,formObject,IBCLEAR);
					break;

				case "btn_save":
					doActionIBSheet(sheetObj,formObject,IBSAVE);
					break;

				case "btn_gw_mail":
					doActionIBSheet(sheetObj,formObject,COMMAND18);
					break;

				case "btn_e_mail":
					doActionIBSheet(sheetObj,formObject,COMMAND22);
					break;

				case "btn_bulletin_board":
					doActionIBSheet(sheetObj,formObject,COMMAND19);
					break;

//				case "btn_settlement":
//					doActionIBSheet(sheetObj,formObject,COMMAND01);
//					break;

				case "btn_loadableweight":
					doActionIBSheet(sheetObj,formObject,COMMAND15);
					break;
					
				case "rdo_tran":
					doActionIBSheet(sheetObj,formObject,COMMAND12);
					break;
					
				case "btn_vvd_search":
					doActionIBSheet(sheetObj,formObject,COMMAND13);
					break;
					
//				case "btn_sim_no":
//					doActionIBSheet(sheetObj,formObject,COMMAND14);
//					break;
					
				case "btn_height_big":
					doActionIBSheet(sheetObj,formObject,COMMAND16);
					break;
					
				case "btn_height_sml":
					doActionIBSheet(sheetObj,formObject,COMMAND17);
					break;
					
				case "btn_send_edi_ckyh":
					////alert('btn_send_edi_ckyh');
					doActionIBSheet(sheetObj,formObject,COMMAND30);
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 * 
	 * @param combo_obj
	 * @return
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
		
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
			// Hidden Column Setting...
			showFieldControl(sheetObjects[i], document.form, false);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		initControl();
		
		// Color Setting...
		glbActualColor 		= sheetObjects[0].RgbColor(10	, 173	, 10	);
		glbHQColor 			= sheetObjects[0].RgbColor(248	, 92	, 33	);
		glbNoonColor 		= sheetObjects[0].RgbColor(77	, 85	, 249	);
		glbDepartureColor 	= sheetObjects[0].RgbColor(128	, 231	, 249	);
		glbInitialColor 	= sheetObjects[0].RgbColor(208	, 208	, 208	);

		glbEditColor 		= sheetObjects[0].RgbColor(128	, 255	, 255	);
		glbDelayFontColor 	= sheetObjects[0].RgbColor(255	, 0		, 0		);
		glbAdvanceFontColor = sheetObjects[0].RgbColor(0	, 0		, 255	);
		glbNormalFontColor 	= sheetObjects[0].RgbColor(0	, 0		, 0		);
		glbTestColor 		= sheetObjects[0].RgbColor(137	, 225	, 104	);
		
		initLoadDirection();
		
		initButton(sheetObjects[0]);

		document.form.rtv_flg.value = "N";
		
		btn2ControlHtml("div_col_show", "btn_col_show", "Expand >>", "btn2_2", "120");	// un_disabled
		btn2ControlHtml("div_col_hide", "btn_col_hide", "Hidden <<", "btn2_1", "120");	// disabled
		
		btn2ControlHtml("div_plan_col_show", "btn_plan_col_show", "Expand >>", "btn2_2", "120");	// un_disabled
		btn2ControlHtml("div_plan_col_hide", "btn_plan_col_hide", "Hidden <<", "btn2_1", "120");	// disabled
		
		// Form Data 초기화.
		glbSheet1FormData = new Usr_Coni_FormData();
		glbSheet2FormData = new Usr_Coni_FormData();
		
		document.form.vsl_cd.focus();
		


		
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

		switch(sheetID) {
			case "sheet1":      // sheet1 init
				with (sheetObj) {
					
					// 높이 설정
					style.height = glbSheetHeight;
					
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   // 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 15, 100);

					var HeadTitle1  = "|CONTI_CD|Seq|VVD|Carrier|CHK|Port\nCode|TMNL\nCode|T/Port\nIND|Turnning Port|Turnning Port|ETA|ETB|ETD|Delay|Delay|Delay|Change\nStatus|Update\nStatus|Dist|SPD|Sea\nTime|Port\nTime|Buffer Time|Buffer Time";
					HeadTitle1		= HeadTitle1 + "|Port Cost\n(USD)|trf_sg_cd_flg|FOC";
					var HeadTitle2  = "|CONTI_CD|Seq|VVD|Carrier|CHK|Port\nCode|TMNL\nCode|T/Port\nIND|Voyage|Dir.|ETA|ETB|ETD|TTL|Sea\n(Hours)|RSN|Change\nStatus|Update\nStatus|Dist|SPD|Sea\nTime|Port\nTime|Port|Sea";
					HeadTitle2		= HeadTitle2 + "|Port Cost\n(USD)|trf_sg_cd_flg|FOC";
					
					var HeadHidTitle = "|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VLS_SLAN_CD|SKD_STS_CD|SKD_VOY_TP_CD|SKD_USD_IND_CD|PF_SKD_TP_CD|ST_PORT_CD" +
							"|N1ST_PORT_BRTH_DT|PSDO_VVD_CD|CO_CD|SKD_RMK|CRE_ID|CRE_DT|UPD_ID|UPD_DT|CLPT_IND_SEQ|SLAN_CD|PORT_SKD_STS_CD|YD_CD" +
							"|CALL_YD_IND_SEQ" +
							"|PF_ETA_DT|PF_ETB_DT|PF_ETD_DT" +
							"|INIT_ETA_DT|INIT_ETB_DT|INIT_ETD_DT|VSL_DLAY_RSN_DESC|VSL_DLAY_RSN_LOC_CD" +
							"|SHP_CALL_NO|SHP_CALL_NO_UPD_USR_ID|SHP_CALL_NO_UPD_DT|TML_VSL_CD|TML_VOY_NO|FT_DT|PLISM_YD_CD|PLISM_VSL_CD|PLISM_VOY_NO" +
							"|TURN_PORT_IND_CD" +
// 							"|TURN_SKD_VOY_NO|TURN_SKD_DIR_CD" +
							"|TURN_CLPT_IND_SEQ|IB_CGO_QTY|OB_CGO_QTY" +
							"|VPS_RMK|PHS_IO_RSN_CD|PHS_IO_RMK|SKD_BRTH_NO|INIT_SKD_INP_FLG|OFC_INP_FLG|NOON_RPT_INP_FLG|DEP_RPT_INP_FLG|ACT_INP_FLG" +
							"|PRT_CHK_FLG|EDI_SND_KNT|PORT_SKP_TP_CD|PORT_SKP_RSN_CD|PORT_SKP_RSN_OFFR_RMK|TTL_DLAY_HRS|TS PORT|USD_FLG";
					// PF INFO
					HeadHidTitle = HeadHidTitle + "|PF_SVC_TP_CD|PORT_ROTN_SEQ|ETB_DY_CD|ETD_DY_CD|MNVR_IN_HRS|MNVR_OUT_HRS"
					// ETC INFO
					HeadHidTitle = HeadHidTitle + "|USR_HDN_FLG|ETA_DELAY_FLG|ETB_DELAY_FLG|ETD_DELAY_FLG|DELAY_DATE|TIME_DIFF|DIFF_RMK|BOUND|TMP_CNG_STS_CD|TMP_PHASE_FLAG" +
							"|CNG_LANE_CD|CNG_VSL_CD|CNG_SKD_VOY_NO|CNG_SKD_DIR_CD|TMP_BKG_VALID|NEW_CLPT_IND_SEQ|BFR_ACT_FLG" +
							"|TS_SKD_VOY_NO|TS_SKD_DIR_CD|TS_CLPT_IND_SEQ|RSN_SKD_VOY_NO|RSN_SKD_DIR_CD|RSN_CLPT_IND_SEQ|REMAINS_SEA_BUF|REMAINS_PORT_BUF|TMP_TZTM_HRS|TMP_ACT_WRK_HRS|TMP_LNK_SPD|PF_LNK_DIST|PF_LNK_SPD|PF_SEA_BUF_HRS|PF_PORT_BUF_HRS|PF_TZTM_HRS|PF_ACT_WRK_HRS|PF_MNVR_OUT_HRS|PF_MNVR_IN_HRS";
					
					HeadTitle1 = HeadTitle1 + HeadHidTitle;
					HeadTitle2 = HeadTitle2 + HeadHidTitle;
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					// 데이터속성 [	ROW, COL,  	DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		35,		daCenter,  false,   	prefix+"ibflag");
					////InitDataProperty(0, cnt++ , dtStatus,		35,		daCenter,  false,   	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		prefix+"conti_cd",			false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix+"clpt_seq",			false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				75,		daCenter,	true,		prefix+"vvd",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			75,		daCenter,	true,		prefix+"crr_cd",				false,		"",			dfNone,			0,			false,		false);

					InitDataProperty(0, cnt++ , dtCheckBox,			35,		daCenter,	true,		prefix+"auto_skd_cng_flg",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"vps_port_cd",		false,		"",			dfEngUpKey,		0,			false,		false		,5);
					InitDataProperty(0, cnt++ , dtCombo,			55,		daCenter,	true,		prefix+"tml_cd",			true,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,			45,		daCenter,	true,		prefix+"turn_port_flg",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		prefix+"turn_skd_voy_no",	false,		"",			dfNone,			0,			false,		false		,4);
					InitDataProperty(0, cnt++ , dtCombo,			45,		daCenter,	true,		prefix+"turn_skd_dir_cd",	false,		"",			dfEngUpKey,		0,			false,		false		,1);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"vps_eta_dt",		true,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"vps_etb_dt",		true,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"vps_etd_dt",		true,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		prefix+"dlay_date_text",	false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		prefix+"sea_date_text",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			40,		daCenter,	true,		prefix+"vsl_dlay_rsn_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,			65,		daCenter,	true,		prefix+"skd_cng_sts_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				75,		daCenter,	true,		prefix+"upd_sts",			false,		"",			dfNone,			0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"lnk_dist",			false,		"",			dfInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"lnk_spd",			false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tztm_hrs",			false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"act_wrk_hrs",		false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"port_buf_hrs",		false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"sea_buf_hrs",		false,		"",			dfNullFloat,	1,			true,		true);

					InitDataProperty(0, cnt++ , dtHidden,			75,		daRight,	true,		prefix+"port_tariff_usd_amt",	false,	"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			55,		daRight,	true,		prefix+"port_sur_or_dc_exist_yn",	false,	"",		dfNone,			1,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,			55,		daRight,	true,		prefix+"fcm_foc_qty",		false,	"",		dfNone,			1,			false,		false);
					
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_slan_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_voy_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_usd_ind_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_skd_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "st_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "n1st_port_brth_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "psdo_vvd_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "co_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "upd_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "upd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "slan_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skd_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "yd_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "call_yd_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etd_dt");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_eta_dt",		false,		"",			dfNone,	0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_etb_dt",		false,		"",			dfNone,	0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_etd_dt",		false,		"",			dfNone,	0,			true,		true);
					setHiddenInitDataProperty(sheetObj, cnt++, "init_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_etd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_desc");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_loc_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no_upd_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no_upd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "tml_vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "tml_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "ft_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "plism_yd_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "plism_vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "plism_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_port_ind_cd");
// 					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_voy_no");
// 					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_clpt_ind_seq");
					
					setHiddenInitDataProperty(sheetObj, cnt++, "ib_cgo_qty");
					setHiddenInitDataProperty(sheetObj, cnt++, "ob_cgo_qty");
					setHiddenInitDataProperty(sheetObj, cnt++, "vps_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "phs_io_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "phs_io_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_brth_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_skd_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "ofc_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "noon_rpt_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "dep_rpt_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "act_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "prt_chk_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "edi_snd_knt");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_offr_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "ttl_dlay_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "usd_flg");
					// PF INFO
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_svc_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_rotn_seq");
					//setHiddenInitDataProperty(sheetObj, cnt++, "pf_tp_cd");
					//setHiddenInitDataProperty(sheetObj, cnt++, "pf_rotn_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "etb_dy_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "etd_dy_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "mnvr_in_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "mnvr_out_hrs");
					// ETC INFO
					setHiddenInitDataProperty(sheetObj, cnt++, "usr_hdn_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "eta_delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "etb_delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "etd_delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "delay_date");
					setHiddenInitDataProperty(sheetObj, cnt++, "time_diff");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"time_diff",		false,		"",			dfNone,	0,			true,		true);
					setHiddenInitDataProperty(sheetObj, cnt++, "diff_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "bound");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_cng_sts_cd");	// 화면에서만 사용(skd_cng_sts_cd변경 후cancel 시 원래값을 찾기 위함).
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_phase_flag");	// 화면에서만 사용(Phase Out 시 해당 Row가 phase out 된 Row인지 판단하기 위함).
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_lane_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_bkg_valid");	// Booking 의 안정성을 위하여 Region 의 첫번째 Port 도착(ETA) 3일 이내의 스케줄은 삭제불가.
					setHiddenInitDataProperty(sheetObj, cnt++, "new_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "bfr_act_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_clpt_ind_seq");
					
					setHiddenInitDataProperty(sheetObj, cnt++, "rmn_sea_buf");
					setHiddenInitDataProperty(sheetObj, cnt++, "rmn_port_buf");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_tztm_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_act_wrk_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_lnk_spd");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"rmn_sea_buf",		false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"rmn_port_buf",		false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tmp_tztm_hrs",		false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tmp_act_wrk_hrs",	false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tmp_lnk_spd",		false,		"",			dfNullFloat,	1,			true,		true);
					
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_lnk_dist");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_lnk_spd");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_sea_buf_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_port_buf_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_tztm_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_act_wrk_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_mnvr_out_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_mnvr_in_hrs");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_lnk_dist"    ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_lnk_spd"     ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_sea_buf_hrs" ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_port_buf_hrs",	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_tztm_hrs"    ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_act_wrk_hrs" ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_mnvr_out_hrs",	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_mnvr_in_hrs" ,	false,		"",			dfNullFloat,	1,			false,		false);
					
					
					InitDataCombo(0, prefix+"turn_port_flg", "Y|N", "Y|N", "N");
					
					//::2013-10-18::init combo 추가:://
					//[mySheet.InitDataCombo(DataRow, Col, ComboText, ComboCode, [DefaultText], [DefaultCode], [ShowCol], [Reserved1], [Reserved2],[VisibleItem]) ]//
					//InitDataCombo(0, prefix+"tml_cd"			, " ", " ", " ");
					//InitDataCombo(0, prefix+"turn_skd_dir_cd"	, " ", " ", " ");
					//InitDataCombo(0, prefix+"vsl_dlay_rsn_cd"	, " ", " ", " ");
					//InitDataCombo(0, prefix+"skd_cng_sts_cd"	, " ", " ", " ");
					
					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
					
					//InitUserFormat2(0, prefix+"port_tariff_usd_amt", "#,###.##", "" );
					
					InitDataValid(0, prefix+"turn_skd_voy_no", vtNumericOnly);
					
					ColHidden(prefix+"turn_skd_voy_no") = true;
					ColHidden(prefix+"turn_skd_dir_cd") = true;
					
					
					// 포커스 선택 모드를 설정하거나 확인한다.
					SelectionMode = 3;
					
					CountPosition = "0";
					
					FrozenCols = SaveNameCol(prefix+"turn_skd_voy_no");
					
					// 화면 OPEN 시 SCROLL BAR 안보이게.
					ScrollBar = 0;
				}
				
				break;
				
			case "sheet2":
				with (sheetObj) {
					
					// 높이 설정
					style.height = 0;
					
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   	// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 15, 100);

					var HeadTitle1  = "|Seq|VVD|Port\nCode|TMNL\nCode|T/Port\nIND|Turnning Port|Turnning Port|ETA|ETB|ETD|Delay|Delay|Delay|Change\nStatus|Dist.|Sp'd|Sea\nTime|ZD|Maneuvering|Maneuvering|Port\nTime|Buffer|Buffer|ECV|ECV|TMNL\nProd.|TMNL\nProd.|Bunker Add. Cost|Bunker Add. Cost|TMNL Handling Cost|TMNL Handling Cost|TMNL Handling Cost|TMNL Handling Cost|Port Charge|Total Cost(USD)";
					var HeadTitle2  = "|Seq|VVD|Port\nCode|TMNL\nCode|T/Port\nIND|Voyage|Dir.|ETA|ETB|ETD|TTL|Sea|RSN|Change\nStatus|Dist.|Sp'd|Sea\nTime|ZD|In|Out|Port\nTime|Port|Sea|In|Out|EA|Vol.|Q'ty|Cost|20'(Vol.)|40'(Vol.)|20'(AMT)|40'(AMT)|Port Charge|Total Cost(USD)";
					var HeadTitle3  = "|Seq|VVD|Port\nCode|TMNL\nCode|T/Port\nIND|Voyage|Dir.|ETA|ETB|ETD|TTL|Sea|RSN|Change\nStatus|Dist.|Sp'd|Sea\nTime|ZD|In|Out|Port\nTime|Port|Sea|In|Out|EA|Vol.|Q'ty|Cost|20'(Vol.)|40'(Vol.)|20'(AMT)|40'(AMT)|Port Charge|Total Cost(USD)";
					
					var HeadHidTitle = "|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VLS_SLAN_CD|SKD_STS_CD|SKD_VOY_TP_CD|SKD_USD_IND_CD|PF_SKD_TP_CD|ST_PORT_CD" +
							"|N1ST_PORT_BRTH_DT|PSDO_VVD_CD|CO_CD|SKD_RMK|CRE_ID|CRE_DT|UPD_ID|UPD_DT|CLPT_IND_SEQ|SLAN_CD|PORT_SKD_STS_CD|YD_CD" +
							"|CALL_YD_IND_SEQ|PF_ETA_DT|PF_ETB_DT|PF_ETD_DT|INIT_ETA_DT|INIT_ETB_DT|INIT_ETD_DT|VSL_DLAY_RSN_DESC|VSL_DLAY_RSN_LOC_CD" +
							"|SHP_CALL_NO|SHP_CALL_NO_UPD_USR_ID|SHP_CALL_NO_UPD_DT|TML_VSL_CD|TML_VOY_NO|FT_DT|PLISM_YD_CD|PLISM_VSL_CD" +
							"|PLISM_VOY_NO|TURN_PORT_IND_CD|TURN_CLPT_IND_SEQ|VPS_RMK|PHS_IO_RSN_CD|PHS_IO_RMK" +
							"|SKD_BRTH_NO|INIT_SKD_INP_FLG|OFC_INP_FLG|NOON_RPT_INP_FLG|DEP_RPT_INP_FLG|ACT_INP_FLG|PRT_CHK_FLG|EDI_SND_KNT" +
							"|PORT_SKP_TP_CD|PORT_SKP_RSN_CD|PORT_SKP_RSN_OFFR_RMK|TTL_DLAY_HRS|TS PORT|USD_FLG|AUTO_SKD_CNG_FLG";
					// PF INFO
					HeadHidTitle = HeadHidTitle + "|PF_SVC_TP_CD|PORT_ROTN_SEQ|ETB_DY_CD|ETD_DY_CD|BNK_UNIT_QTY|BNK_UNIT_AMT|BNK_TOT_QTY|BNK_TOT_AMT"
					// ETC INFO
					HeadHidTitle = HeadHidTitle + "|USR_HDN_FLG|ETA_DELAY_FLG|ETB_DELAY_FLG|ETD_DELAY_FLG|DELAY_DATE|DIFF_RMK|BOUND|TMP_CNG_STS_CD|TMP_PHASE_FLAG" +
							"|CNG_LANE_CD|CNG_VSL_CD|CNG_SKD_VOY_NO|CNG_SKD_DIR_CD|TMP_BKG_VALID|NEW_CLPT_IND_SEQ|BFR_ACT_FLG" +
							"|TS_SKD_VOY_NO|TS_SKD_DIR_CD|TS_CLPT_IND_SEQ|RSN_SKD_VOY_NO|RSN_SKD_DIR_CD|RSN_CLPT_IND_SEQ|TML_HNDL_20FT_UNIT_AMT|TML_HNDL_40FT_UNIT_AMT" +
							"|REMAINS_SEA_BUF|REMAINS_PORT_BUF|TMP_TZTM_HRS|TMP_ACT_WRK_HRS|TMP_LNK_SPD|PF_LNK_DIST|PF_LNK_SPD|PF_SEA_BUF_HRS|PF_PORT_BUF_HRS|PF_TZTM_HRS|PF_ACT_WRK_HRS|PF_MNVR_OUT_HRS|PF_MNVR_IN_HRS";
// 					HeadHidTitle = HeadHidTitle + "|PF SPD";
					
					HeadTitle1 = HeadTitle1 + HeadHidTitle;
					HeadTitle2 = HeadTitle2 + HeadHidTitle;
					HeadTitle3 = HeadTitle3 + HeadHidTitle;
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false);

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					InitHeadRow(2, HeadTitle3, true);

					// 데이터속성 [	ROW, COL,  	DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,						KEYFIELD, CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,  false,   	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix+"clpt_seq",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix+"vvd",					false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"vps_port_cd",			false,		"",			dfEngUpKey,		0,			false,		false,		5);
					InitDataProperty(0, cnt++ , dtCombo,			45,		daCenter,	true,		prefix+"tml_cd",				true,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix+"turn_port_flg",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"turn_skd_voy_no",		false,		"",			dfNone,			0,			false,		false		,4);
					InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix+"turn_skd_dir_cd",		false,		"",			dfEngUpKey,		0,			false,		false		,1);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"vps_eta_dt",			true,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"vps_etb_dt",			true,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"vps_etd_dt",			true,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"dlay_date_text",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"sea_date_text",			false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix+"vsl_dlay_rsn_cd",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,			75,		daCenter,	true,		prefix+"skd_cng_sts_cd",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"lnk_dist",				false,		"",			dfInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"lnk_spd",				false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"tztm_hrs",				false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"time_diff",				false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"mnvr_in_hrs",			false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"mnvr_out_hrs",			false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"act_wrk_hrs",			false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"port_buf_hrs",			false,		"",			dfNullFloat,	1,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"sea_buf_hrs",			false,		"",			dfNullFloat,	1,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"ib_cgo_qty",			false,		"",			dfInteger,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"ob_cgo_qty",			false,		"",			dfInteger,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"crn_knt",				false,		"",			dfInteger,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daRight,	true,		prefix+"tml_prod_qty",			false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		prefix+"add_bnk_csm_qty",		false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		80,		daRight,	true,		prefix+"add_bnk_cost_amt",		false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"ts_20ft_ttl_qty",		false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"ts_40ft_ttl_qty",		false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtAutoSumEx,		60,		daRight,	true,		prefix+"ts_20ft_ttl_amt",		false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtAutoSumEx,		60,		daRight,	true,		prefix+"ts_40ft_ttl_amt",		false,		"",			dfInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix+"tml_hndl_20ft_ttl_qty",	false,		"",			dfNullInteger,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix+"tml_hndl_40ft_ttl_qty",	false,		"",			dfNullInteger,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		60,		daRight,	true,		prefix+"tml_hndl_20ft_ttl_amt",	false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		60,		daRight,	true,		prefix+"tml_hndl_40ft_ttl_amt",	false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		100,	daRight,	true,		prefix+"pe_usd_ttl_amt",		false,		"",			dfNullFloat,	1,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		0,		daRight,	true,		prefix+"total_cost",			false,		"",			dfNullFloat,	1,			false,		false);
					
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_slan_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_sts_cd");

					setHiddenInitDataProperty(sheetObj, cnt++, "skd_voy_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_usd_ind_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_skd_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "st_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "n1st_port_brth_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "psdo_vvd_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "co_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "upd_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "upd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "clpt_ind_seq");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"clpt_ind_seq",			false,		"",			dfInteger,		0,			true,		true);
					setHiddenInitDataProperty(sheetObj, cnt++, "slan_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skd_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "yd_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "call_yd_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_etd_dt");
//					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_desc");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_loc_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no_upd_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no_upd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "tml_vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "tml_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "ft_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "plism_yd_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "plism_vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "plism_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_port_ind_cd");
//					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_voy_no");
//					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "vps_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "phs_io_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "phs_io_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_brth_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_skd_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "ofc_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "noon_rpt_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "dep_rpt_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "act_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "prt_chk_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "edi_snd_knt");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_offr_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "ttl_dlay_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "usd_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "auto_skd_cng_flg");
					// PF INFO
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_svc_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_rotn_seq");
					//setHiddenInitDataProperty(sheetObj, cnt++, "pf_tp_cd");
					//setHiddenInitDataProperty(sheetObj, cnt++, "pf_rotn_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "etb_dy_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "etd_dy_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "bnk_unit_qty");
					setHiddenInitDataProperty(sheetObj, cnt++, "bnk_unit_amt");
					setHiddenInitDataProperty(sheetObj, cnt++, "bnk_tot_qty");
					setHiddenInitDataProperty(sheetObj, cnt++, "bnk_tot_amt");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"bnk_unit_qty",			false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"bnk_unit_amt",			false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"bnk_tot_qty",			false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"bnk_tot_amt",			false,		"",			dfInteger,		0,			true,		true);
					// ETC INFO
					setHiddenInitDataProperty(sheetObj, cnt++, "usr_hdn_flg");		// simulation table 에서 사용(화면의 Hidden 상태)
//					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		prefix+"usr_hdn_flg",		false,		"",			dfNone,			0,			true,		true);
					setHiddenInitDataProperty(sheetObj, cnt++, "eta_delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "etb_delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "etd_delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "delay_date");
					setHiddenInitDataProperty(sheetObj, cnt++, "diff_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "bound");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_cng_sts_cd");	// 화면에서만 사용(skd_cng_sts_cd 변경 후 cancel 시 원래값을 찾기 위함).
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_phase_flag");	// 화면에서만 사용(Phase Out 시 해당 Row가 phase out 된 Row인지 판단하기 위함).
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_lane_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "cng_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_bkg_valid");	// Booking 의 안정성을 위하여 Region 의 첫번째 Port 도착(ETA) 3일 이내의 스케줄은 삭제불가.
					setHiddenInitDataProperty(sheetObj, cnt++, "new_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "bfr_act_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "tml_hndl_20ft_unit_amt");
					setHiddenInitDataProperty(sheetObj, cnt++, "tml_hndl_40ft_unit_amt");
					
// 					setHiddenInitDataProperty(sheetObj, cnt++, "pf_spd");
					setHiddenInitDataProperty(sheetObj, cnt++, "rmn_sea_buf");
					setHiddenInitDataProperty(sheetObj, cnt++, "rmn_port_buf");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_tztm_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_act_wrk_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_lnk_spd");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"rmn_sea_buf",		false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"rmn_port_buf",		false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tmp_tztm_hrs",		false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tmp_act_wrk_hrs",	false,		"",			dfNullFloat,	1,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"tmp_lnk_spd",		false,		"",			dfNullFloat,	1,			true,		true);
					
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_lnk_dist");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_lnk_spd");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_sea_buf_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_port_buf_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_tztm_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_act_wrk_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_mnvr_out_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_mnvr_in_hrs");
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_lnk_dist"    ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_lnk_spd"     ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_sea_buf_hrs" ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_port_buf_hrs",	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_tztm_hrs"    ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_act_wrk_hrs" ,	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_mnvr_out_hrs",	false,		"",			dfNullFloat,	1,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	true,		prefix+"pf_mnvr_in_hrs" ,	false,		"",			dfNullFloat,	1,			false,		false);
					
					InitDataCombo(0, prefix+"turn_port_flg", "Y|N", "Y|N");

					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
					
					InitDataValid(0, prefix+"turn_skd_voy_no", vtNumericOnly);
					InitDataValid(0, prefix+"vps_port_cd", vtEngUpOther, "0123456789");
					
					ColHidden(prefix+"turn_skd_voy_no") = true;
					ColHidden(prefix+"turn_skd_dir_cd") = true;
					
					// 포커스 선택 모드를 설정하거나 확인한다.
					SelectionMode = 3;
					
					FrozenCols = SaveNameCol(prefix+"turn_skd_voy_no");
					
					CountPosition = "0";
				}
				break;
				
				/*
			case "sheet3":      // sheet3 init
			with (sheetObj) {
				
				var prefix	= "sheet3_";
				
				// 높이 설정
				style.height = 150;
				
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   // 전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);

				var HeadTitle1  = "vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq|clpt_seq|yd_cd|port_tariff_usd_amt|port_sur_or_dc_exist_yn";
				
				var headCount = ComCountHeadTitle(HeadTitle1);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//InitHeadMode(false, false, false, true, false, false)

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 [	ROW, COL,  	DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"vsl_cd",					false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_voy_no",				false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_dir_cd",				false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"vps_port_cd",				false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"clpt_ind_seq",				false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"clpt_seq",					false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"yd_cd",						false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	true,		prefix+"port_tariff_usd_amt",		false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	true,		prefix+"port_sur_or_dc_exist_yn",	false,		"",			dfNone,			0,			false,		false);	
			}
			break;				
				*/
			/////////////////////////////////////////////////////////////
			
			case "sheet3":      // sheet3 init
			with (sheetObj) {
				
				//var prefix	= "sheet3_";
				var prefix	= "";
				
				// 높이 설정
				style.height = 0;
				
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   // 전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);

				var HeadTitle1  = "flg|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq|clpt_seq|yd_cd|port_tariff_usd_amt|port_sur_or_dc_exist_yn";
				
				var headCount = ComCountHeadTitle(HeadTitle1);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, true, false, false)

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 [	ROW, COL,  	DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,			35,		daCenter,  false,   	prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"vsl_cd",					false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_voy_no",				false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_dir_cd",				false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"vps_port_cd",				false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"clpt_ind_seq",				false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"clpt_seq",					false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"yd_cd",						false,		"",			dfNone,			0,			false,		false);	
				InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	true,		prefix+"yd_ttl_usd_amt",			false,		"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	true,		prefix+"port_sur_or_dc_exist_yn",	false,		"",			dfNone,			0,			false,		false);	
			}
			break;			
			
			/////////////////////////////////////////////////////////////
			
			case "sheet4":      // sheet3 init
				with (sheetObj) {
					
					//var prefix	= "sheet3_";
					var prefix	= "sheet4_";
					
					// 높이 설정
					style.height = 0;
					
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   // 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1  = "flg|slan_cd|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_seq|yd_cd|clpt_ind_seq|pf_svc_tp_cd|pf_seq|skd_cng_sts_cd|ref_slan_cd|ref_vsl_cd|ref_skd_voy_no|ref_skd_dir_cd|ref_vps_port_cd|ref_clpt_seq|ref_yd_cd|ref_clpt_ind_seq|ref_pf_svc_tp_cd|ref_pf_seq";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성 [	ROW, COL,  	DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,			35,		daCenter,  false,   	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"slan_cd",					false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"vsl_cd",					false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_voy_no",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_dir_cd",				false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"vps_port_cd",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"clpt_seq",					false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"yd_cd",						false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"clpt_ind_seq",				false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"pf_svc_tp_cd",				false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"pf_seq",					false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"skd_cng_sts_cd",			false,		"",			dfNone,			0,			false,		false);	

					
					
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_slan_cd",					false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_vsl_cd",					false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_skd_voy_no",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_skd_dir_cd",				false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_vps_port_cd",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_clpt_seq",					false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_yd_cd",						false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_clpt_ind_seq",				false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_pf_svc_tp_cd",				false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		prefix+"ref_pf_seq",					false,		"",			dfNone,			0,			false,		false);	

				}
				break;			
			
		}
	}
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {
	    	case "remark":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("104");
  					DropHeight = 80;
// 					Enable = false;
   		    	}
   	    		break;
   	     }
   	}
	
	/**
	 * Hidden Col Setting...
	 * 
	 * @param sheetObj
	 * @param Col
	 * @param colName
	 * @return
	 */
	function setHiddenInitDataProperty(sheetObj, Col, colName){
		var prefix = sheetObj.id+"_";
		with (sheetObj) {
			//데이터속성    [	ROW, 	COL,  	DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, 	Col, 	dtHidden,				0,		daCenter,	true,		prefix+colName,		false,		"",			dfNone,			0,			false,		false);
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";
		
		switch(sAction) {

			case IBSEARCH:      //조회
				doActionSearch(sheetObj, formObj, IBSEARCH);
				break;

			case SEARCH01:		//Terminal(Yard) List
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH02:		// Distance
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH02;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH03:		// Port Change
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH03;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH04:      //Skip - Bunker Additional Cost
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH04;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH05:		//Terminal 변경 시 MNVR_IO 조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH05;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				} 
				break;
			case SEARCH06:		// Add Call
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH06;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH07:		//Turnning Port의 Direction Code 목록을 Setting.
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH07;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH08:		//Phase Out Cancel(sheet1)
				formObj.f_cmd.value = SEARCH08;
				var sParam = ComGetSaveString(sheetObjects, false);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);;
				
				var sXml = sheetObj.GetSaveXml("VOP_VSK_0015GS.do", sParam);
				return sXml;
				break;
			case SEARCH09:		//Phase Out Cancel(sheet2)
				formObj.f_cmd.value = SEARCH09;
				var sParam = ComGetSaveString(sheetObjects, false);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);;
				
				var sXml = sheetObj.GetSaveXml("VOP_VSK_0015GS.do", sParam);
				return sXml;
				break;
			case SEARCH10:		//Vsl_Cd Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH10;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH11:		// Skip(Distance)
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH11;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
			case SEARCH12:		// Port Change (of Add Call : sheet2)
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH12;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
					
					return sXml;
				}
				break;
				
			case SEARCH13:		// Port Tariff Calculation
			
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH13;
					var prefix			= "";

					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);

					if (sParam == "") return;
					
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					
					if(sheetObjects[2].RowCount == 0){
						sheetObjects[2].RemoveAll();
					}
					
					/* PORT TARIFF 조회실행 */
					var sXml = sheetObjects[2].GetSearchXml("VOP_VSK_0015GS.do", sParam);
					ComOpenWait(false);
					
					////alert(sXml);
					////showSheetDataPortTariff(sheetObj, formObj, sXml);
					
					if(sheetObjects[2].RowCount == 0){
						sheetObjects[2].LoadSearchXml(sXml);
					}
					
					/* PORT TARIFF 조회이후 SURCHARGE+DISCOUNT 존재유무파악을 위한 2차 조회실행 */
					formObj.f_cmd.value = SEARCH14;
					
					var headCnt = sheetObjects[2].HeaderRows;
					var rowCnt 	= sheetObjects[2].RowCount;
					var totCnt 	= getTotalRowCnt(sheetObjects[2]);
					
					for(var i=headCnt; i<=totCnt; i++){
						sheetObjects[2].CellValue2	(i, "ibflag") 	= "U";
						//sheetObjects[2].RowStatus	(i) 					= "U";
					}
					
					var sParam2 = ComGetSaveString(sheetObjects[2], true);
					if (sParam2 == "") return;
					sParam2 += "&" + FormQueryString(formObj);
					
					////alert(sParam2);
					var sXml = sheetObjects[2].GetSearchXml("VOP_VSK_0015GS.do", sParam2); //GetSaveXml
					
					////alert(sXml);
					sheetObjects[2].LoadSearchXml(sXml);
					
					////alert('sur or discount checking is ['+sXml+']');
					
					var prefix1	= "sheet1_";
					//var prefix3	= "sheet3_";
					var prefix3	= "";
					
					var headCnt0 	= sheetObjects[0].HeaderRows;
					var rowCnt0 	= sheetObjects[0].RowCount;
					var totCnt0 	= getTotalRowCnt(sheetObjects[0]);
					
					var headCnt2 	= sheetObjects[2].HeaderRows;
					var rowCnt2 	= sheetObjects[2].RowCount;
					var totCnt2 	= getTotalRowCnt(sheetObjects[2]);
					
					var basic_vvd	= formObj.vsl_cd.value+formObj.skd_voy_no.value+formObj.skd_dir_cd.value;
					
			    	for(var i=headCnt2; i<=totCnt2; i++) {
			    		for(var j=headCnt0; j<=totCnt0; j++){
				    		if(		(	sheetObjects[0].CellValue(j,prefix1+"vvd") 		== basic_vvd
				    				&&	sheetObjects[0].CellValue(j,prefix1+"vps_port_cd")+sheetObjects[0].CellValue(j,prefix1+"tml_cd") 	== sheetObjects[2].CellValue(i,prefix3+"yd_cd")
				    				)
				    				||
				    				(	sheetObjects[0].CellValue(j,prefix1+"vvd").substring(0,4)+sheetObjects[0].CellValue(j,prefix1+"turn_skd_voy_no")+sheetObjects[0].CellValue(j,prefix1+"turn_skd_dir_cd") 		
				    						== basic_vvd
						    		&&	sheetObjects[0].CellValue(j,prefix1+"vps_port_cd")+sheetObjects[0].CellValue(j,prefix1+"tml_cd") 	== sheetObjects[2].CellValue(i,prefix3+"yd_cd")
						    		)
				    		)
				    		{
				    			////alert('i=['+i+'], j=['+j+']   '+sheetObjects[0].CellValue(j,prefix+"vvd") +" vs " +sheetObjects[2].CellValue(i,"vsl_cd")+sheetObjects[2].CellValue(i,"skd_voy_no")+sheetObjects[2].CellValue(i,"skd_dir_cd"));
				    			////alert(sheetObjects[0].CellValue(j,prefix+"vps_port_cd")+sheetObjects[0].CellValue(j,prefix+"tml_cd") +" vs " +sheetObjects[2].CellValue(i,"yd_cd"));

				    			sheetObjects[0].CellValue2(j,prefix1+"port_sur_or_dc_exist_yn") 	= sheetObjects[2].CellValue(i,prefix3+"port_sur_or_dc_exist_yn");
				    			if(sheetObjects[2].CellValue(i,prefix3+"port_sur_or_dc_exist_yn") == "Y"){
				    				sheetObjects[0].CellFontColor(j,prefix1+"port_tariff_usd_amt") 		= glbDelayFontColor;		//glbDelayFontColor;
				    			//}else{
				    			//	sheetObjects[0].CellFontColor(j,prefix1+"port_tariff_usd_amt") 		= glbAdvanceFontColor;		//glbDelayFontColor;
				    			}
				    			sheetObjects[0].CellValue2   (j,prefix1+"port_tariff_usd_amt") 		= sheetObjects[2].CellValue(i,prefix3+"yd_ttl_usd_amt");
				    		}
			    		}
			    		
			    	}					
					
					ComOpenWait(false);
					
					//sheetObj.LoadSaveXml(sXml);
					
					//return sXml;
				}
				break;				
				
			case IBSAVE:        //저장
				doActionSave(sheetObj, formObj, sAction);
				break;

			case IBCLEAR:        //New
				clearAllData(sheetObj, formObj);
				break;

			case COMMAND01:        //
				doActionSave(sheetObj, formObj, sAction);
				break;

			case COMMAND02:        	// Row Hidden
				rowHideControl(sheetObj);
				break;

			case COMMAND03:        	// Skip Call
				sUrl = "/hanjin/VOP_VSK_0245.do";
        		ComOpenPopup(sUrl, 550, 280, "returnSkipCallHelp", "none", true);
				break;

			case COMMAND04:        	// Add Call
				var posFlg = isAddPositionFlag(sheetObj);		// position flag(before/after)
				sUrl = "/hanjin/VOP_VSK_0215.do?pos_flg=" + posFlg;
				var rtnObj = ComOpenPopup(sUrl, 400, 370, "", "0,0", true);
				returnAddCallHelp(sheetObj, rtnObj);
				break;

			case COMMAND05:        	// Reverse Call
				reverseCallControl(sheetObj);
				break;

			case COMMAND06:        	// Row Hidden Cancel
				rowHideCancel(sheetObj);
				break;

			case COMMAND07:        	// Skip Call Cancel
				skipCallCancel(sheetObj);
				break;

			case COMMAND08:        	// Add Call Cancel
				addCallCancel(sheetObj);
				break;

			case COMMAND09:        	// Reverse Call Change
				reverseCallChange(sheetObj);
				break;

			case COMMAND10:        	// Col Show
				showFieldControl(sheetObj, formObj, true);
				break;

			case COMMAND11:        	// Col Hidden
				showFieldControl(sheetObj, formObj, false);
				break;

			case COMMAND12:        	// Sheet Change(Coastal SKD/Recovery Plan)
				if(formObj.rdo_tran[0].checked){
					if(glbSheetFlg != "sheet1"){
						glbSheetFlg = "sheet1";
						showSheetForm("sheet1");
						
//						ComBtnDisable("btn_settlement");
//						ComEnableObject(formObj.btn_sim_no, false);
						
						document.getElementById("div_remark").style.display = "block";
						
						btnControlByLoadableWeight(sheetObjects[0], sheetObjects[0].SelectRow);
						
						//::jsk::2014-03-21:://
						ComBtnEnable("btn_send_edi_ckyh");
					}
				} else {
					if(glbSheetFlg != "sheet2"){
						glbSheetFlg = "sheet2";
						showSheetForm("sheet2");
						
//						ComBtnEnable("btn_settlement");
//						ComEnableObject(formObj.btn_sim_no, true);
						
						document.getElementById("div_remark").style.display = "none";
						btnControlByLoadableWeight(sheetObjects[1], sheetObjects[1].SelectRow);
						
						//::jsk::2014-03-21:://
						ComBtnDisable("btn_send_edi_ckyh");						
					}
				}
				
//				ComBtnDisable("btn_loadableweight");
				break;

			case COMMAND13:        	// VVD Search
				var vslCd = formObj.vsl_cd.value;
            	
            	if(vslCd == ""){
            		sUrl = "/hanjin/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;

			case COMMAND14:        	// Simulation No Search
				if(glbSheetFlg == "sheet2"){
            		var sUrl = "/hanjin/VOP_VSK_0201.do?uiFlg=B&vsl_slan_cd="+formObj.vsl_slan_cd.value;
            		ComOpenPopup(sUrl, 800, 470, "returnSimNoHelp", "0,0", true);
				}
				break;

			case COMMAND15:        	// Loadable Weight
				sUrl = "/hanjin/VOP_VSK_0247.do";
        		ComOpenPopup(sUrl, 818, 526, "returnLoadableHelp", "0,0", true);
				break;

			case COMMAND16:        	// btn_height_big
				glbSheetHeight = SKD_SHEET_SIZE;
				sheetObj.style.height = glbSheetHeight;
				break;

			case COMMAND17:        	// btn_height_sml
				glbSheetHeight = PLN_SHEET_SIZE;
				sheetObj.style.height = glbSheetHeight;
				break;

			case COMMAND18:        	// btn_gw_mail_send
				sendGroupwareMail(sheetObj, formObj);
				break;

			case COMMAND19:        	// btn_bulletin_board
				sendGroupwareBoard(sheetObj, formObj);
				break;

			case COMMAND20:        	// Phase Out
				if(validateForm(sheetObj, formObj, sAction)){
					var sRow = sheetObj.SelectRow;
					var param = "";
	        		param += "&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	        		param += "&vsl_cd=" + sheetObj.CellValue(sRow, prefix+"vsl_cd");
	        		param += "&voy_no=" + sheetObj.CellValue(sRow, prefix+"skd_voy_no");
	        		param += "&dir_cd=" + sheetObj.CellValue(sRow, prefix+"skd_dir_cd");
	        		param += "&port_cd=" + sheetObj.CellValue(sRow, prefix+"vps_port_cd");
	        		param += "&phase_type=O";
	        		param += "&clpt_ind_seq=" + sheetObj.CellValue(sRow, sheetObj.SelectCol);
	        		param += "&phase_date=" + ComGetNowInfo();
	        		param += "&parentUI=0015";
	        		
					sUrl = "/hanjin/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + param;
	// 				ComOpenPopup(sUrl, 650, 400, "returnPhaseOutHelp", "0,0", true);
	        		var rVal = ComOpenPopupWithTarget(sUrl, 650, 250, "", "0,0", true);
	        		returnPhaseOutHelp(sheetObj, sRow, rVal);
				}
				break;

			case COMMAND21:        	// Phase Out Cancel
				phaseOutCancelControl(sheetObj, formObj);
				break;

			case COMMAND22:        	// btn_e_mail_send
				sendMail(sheetObj, formObj);
				break;
				
			//::2007816:://
			case COMMAND30:        	// Sending EDI F/F to CKYH Alliance
				if(validateForm(sheetObj, formObj, sAction)){
					
					formObj.f_cmd.value = COMMAND01;
					var sParam 	= FormQueryString(formObj) + "&" + ComGetSaveString(sheetObj, true);
					
					////alert('CMD = ['+formObj.f_cmd.value+'], sParam === ['+sParam+']');
					
					ComOpenWait(true);
					var sXml 	= sheetObj.GetSearchXml("VOP_VSK_XCH_SKDGS.do", sParam);
					ComOpenWait(false);
					
					if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
						//::VSK57020:EDI transmitted sucessfully:://
							ComShowCodeMessage('VSK57020');
					}
					
				}
			
			break;				
				
			case IBINSERT:      // 입력
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction){
    	switch(sAction) {
			case IBSEARCH:      //조회
				if(sheetObj.id == "sheet1"){
					if(ComIsNull(formObj.vsl_cd.value)){
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.focus();
						return false;
					} else if (formObj.vsl_cd.value.length < 4) {
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.value = "";
						formObj.vsl_cd.focus();
						return false;
					} else if(ComIsNull(formObj.skd_voy_no.value)){
						ComShowCodeMessage('VSK00027', "Voyage No.");
					 	formObj.skd_voy_no.focus();
						return false;
					} else if (formObj.skd_voy_no.value.length < 4) {
						ComShowCodeMessage('VSK00027', "Voyage No.");
						formObj.skd_voy_no.value = "";
						formObj.skd_voy_no.focus();
						return false;
					} else if(ComIsNull(formObj.skd_dir_cd.value)){
						ComShowCodeMessage('VSK00027', "Direction Code");
						formObj.skd_dir_cd.focus();
						return false;
					}
				}else{
					if(formObj.sim_dt.value == ""){
						if(ComIsNull(formObj.vsl_cd.value)){
							ComShowCodeMessage('VSK00027', "Vessel Code");
							formObj.vsl_cd.focus();
							return false;
						} else if (formObj.vsl_cd.value.length < 4) {
							ComShowCodeMessage('VSK00027', "Vessel Code");
							formObj.vsl_cd.value = "";
							formObj.vsl_cd.focus();
							return false;
						} else if(ComIsNull(formObj.skd_voy_no.value)){
							ComShowCodeMessage('VSK00027', "Voyage No.");
						 	formObj.skd_voy_no.focus();
							return false;
						} else if (formObj.skd_voy_no.value.length < 4) {
							ComShowCodeMessage('VSK00027', "Voyage No.");
							formObj.skd_voy_no.value = "";
							formObj.skd_voy_no.focus();
							return false;
						} else if(ComIsNull(formObj.skd_dir_cd.value)){
							ComShowCodeMessage('VSK00027', "Direction Code");
							formObj.skd_dir_cd.focus();
							return false;
						}
					}
				}
				
				break;

			case IBSAVE:      //저장
				var headCnt 	= sheetObj.HeaderRows;
				var rowCnt 		= sheetObj.RowCount;
				var totCnt 		= getTotalRowCnt(sheetObj);
				var prefix 		= sheetObj.id + "_";
				
				if(rowCnt > 0){
					var turnVoyNo 		= "";
					var turnDirCd 		= "";
					var vvd 			= "";
					var chkTurnVoyNo 	= "";
					var chkTurnDirCd 	= "";
					var chkVvd 			= "";
					
					for(var i=headCnt; i<=totCnt; i++){
						//Total Row 는 Check 안함, Phase Out 되어 삭제 된 Port 는 Check 안함.
						if(sheetObj.CellValue(i, prefix+"vvd") != "" && sheetObj.CellValue(i, prefix+"tmp_phase_flag") != "H"){
							if(sheetObj.CellValue(i, prefix+"vsl_cd").length < 4){
								ComShowCodeMessage('VSK00027', "Vessel Code");
								sheetObj.SelectCell(i, prefix+"vvd");
								
								return false;
							}
							if(sheetObj.CellValue(i, prefix+"skd_voy_no").length < 4){
								ComShowCodeMessage('VSK00027', "Voyage No.");
								sheetObj.SelectCell(i, prefix+"vvd");
								
								return false;
							}
							if(sheetObj.CellValue(i, prefix+"skd_dir_cd").length < 1){
								ComShowCodeMessage('VSK00027', "Direction Code");
								sheetObj.SelectCell(i, prefix+"vvd");
								
								return false;
							}
							
							//Port Code Check...
							if(sheetObj.CellValue(i, prefix+"vps_port_cd").length < 5){
								ComShowCodeMessage('VSK00027', "Port Code");
								sheetObj.SelectCell(i, prefix+"vps_port_cd");
								return false;
							}
							
							//Terminal Code Check...
							var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
							if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
								if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
									if(sheetObj.CellValue(i, prefix+"tml_cd") == ""){
										ComShowCodeMessage("VSK00027", "Terminal Code");
										sheetObj.SelectCell(i, prefix+"tml_cd");
										return false;
									}else{
										if(sheetObj.CellValue(i, prefix+"tml_cd").length < 2){
											ComShowCodeMessage("VSK00027", "Terminal Code");
											sheetObj.SelectCell(i, prefix+"tml_cd");
											return false;
										}
									}
								}
							}
							
							//Turn Indicator 가 Y인 Row는 필수입력 - 저장 시 Validation Check 중 에러 시 해당 Port 이름 보여주고 해당 Cell로 포커스 이동.
							// Save 시 turn_skd_voy_no, turn_skd_dir_cd 가 Null 이면 입력하도록 유도(입력가능하게 해당 Column 을 보여줌).
							if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
//								if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no"))){
//									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
//									sheetObj.SelectCell(i, prefix+"turn_port_flg");
//									return false;
//								} else if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))) {
//									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
//									sheetObj.SelectCell(i, prefix+"turn_port_flg");
//									return false;
//								}
								
								if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
									
									////alert('sheetObj id >>> '+sheetObj.id+' :: turn_skd_voy_no >> '+ sheetObj.CellValue(i, prefix+"turn_skd_voy_no") + ' :: turn_skd_dir_cd >> '+ sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"));
									
									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
									
									// turn_port_flg 가 'Y' 이면서 turn_skd_voy_no 및 turn_skd_dir_cd 가 Null 인 건을 찾아 Edit 가능하게 변경.
									turnEditChange(sheetObj);
									
									sheetObj.ColHidden(prefix+"turn_skd_voy_no") = false;
									sheetObj.ColHidden(prefix+"turn_skd_dir_cd") = false;
									
									if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no"))){
										sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
									}else if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
										sheetObj.SelectCell(i, prefix+"turn_skd_dir_cd");
									}
									
									return false;
								}
	
								//Turn Indicator 가 Y이면 해당 Turn VVD가 동일한지 저장 시 체크
								turnVoyNo = sheetObj.CellValue(i, prefix+"turn_skd_voy_no");
								turnDirCd = sheetObj.CellValue(i, prefix+"turn_skd_dir_cd");
								vvd = sheetObj.CellValue(i, prefix+"vvd");
								if(chkTurnVoyNo == ""){
									chkTurnVoyNo = turnVoyNo;
									chkTurnDirCd = turnDirCd;
									chkVvd = vvd;
								}else{
									if(turnVoyNo != chkTurnVoyNo && vvd == chkVvd){
										ComShowCodeMessage("VSK00034", sheetObj.CellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_port_flg");
										return false;
									}else if(turnDirCd != chkTurnDirCd && vvd == chkVvd){
										ComShowCodeMessage("VSK00034", sheetObj.CellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_port_flg");
										return false;
									}
								}
							}
							
							//ETA 날짜 포맷 검사.
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//ETB 날짜 포맷 검사.
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//ETD 날짜 포맷 검사.
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							
							//ETA < ETB < ETD < Next ETA 순서를 유지.
							//if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
							if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
								if(sheetObj.CellValue(i, prefix+"vps_eta_dt") < sheetObj.CellValue(i, prefix+"vps_etb_dt")){
									if(sheetObj.CellValue(i, prefix+"vps_etb_dt") < sheetObj.CellValue(i, prefix+"vps_etd_dt")){
										if(i<totCnt){
											var nxtRow = getNotSkipRow(sheetObj, i, "N", true);
											if(nxtRow > 0){
												
												if(sheetObj.CellValue(i, prefix+"vps_etd_dt") < sheetObj.CellValue(nxtRow, prefix+"vps_eta_dt")){
													//pass
												}else{
													ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
													sheetObj.SelectCell(i, prefix+"vps_etd_dt");
													return false;
												}
											}
										}
									} else {
										ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"vps_etb_dt");
										return false;
									}
								} else {
									ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
									sheetObj.SelectCell(i, prefix+"vps_eta_dt");
									return false;
								}
							}
							
							//Delay Date Check
							/*
							 * Expand >> Delay Check 안함. 
							 * Hidden >> Delay Check
							 * Row Hidden >> Delay Check 안함. 
							 * Editable false >> Delay Check 안함. 
							 * Actual >> Delay Check 안함.
							 * 
							 * sheet1(Coastal SKD)에서만 Check(2009.11.27 - 김기원 K).
							 */
							if(sheetObj.id == "sheet1"){
								//Hidden - Delay Check
//	 							if(!sheetObj.ColHidden(prefix+"lnk_dist")){
									// Row Hidden >> Delay Check 안함
									if(!sheetObj.RowHidden(i)){
										//Skip >> Delay Check 안함
										if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
										//Editable false >> Delay Check 안함.
//	 									if(sheetObj.CellEditable(i, prefix+"vsl_dlay_rsn_cd")){
											// Virtual Port 제외.
//	 										var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
//	 										if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
											// Actual >> Delay Check 안함.
											if(sheetObj.CellValue(i, prefix+"bfr_act_flg") != "X" && sheetObj.CellValue(i, prefix+"act_inp_flg") != "Y"){
//												if(sheetObj.CellValue(i, prefix+"dlay_date_text") != ""){
												
												/* 
												 * 변경 : 20100712_01
												 * OLD : sea delay time이 존재할때 delay reason code는 반드시 있어야함
												 * NEW : PF ETA < VPS ETA 이고, sea delay time의 값이 7.5 이상(화면에는 반올림되어 8로 처리됨)일때 delay reason code는 반드시 있어야함.
												 * NEW2 : PF ETA < VPS ETA 이고, sea delay time의 값이 8 초과 일때 delay reason code는 반드시 있어야함. - 2015.09.08
												 */
												//OLD : if(sheetObj.CellValue(i, prefix+"sea_date_text") != ""){

												// 컬러 변경전 기본 컬러로 환원(SAVE 여러번 하는 경우에 필수 상태일때 변경된 색깔이, 필수 상태가 아닐때 복구되야 하므로) 
												sheetObj.CellBackColor(i, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(i, prefix+"sea_date_text")
//												if(getSeaDlayTime(sheetObj, i) >= 7.5){
												if(getSeaDlayTime(sheetObj, i) > 8){
													if(sheetObj.CellValue(i, prefix+"vsl_dlay_rsn_cd") == ""){
														
														ComShowCodeMessage("VSK00027", "Delay Date");
														sheetObj.CellBackColor(i, prefix+"vsl_dlay_rsn_cd") = glbEditColor;
														sheetObj.SelectCell(i, prefix+"vsl_dlay_rsn_cd");
														return false;
													}
												}
											}
										}
									}
//								}
							}
						}
					}
				}else{
					//선택된 행이 없습니다.
					ComShowCodeMessage("VSK00020");
					return false;
				}
				
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("VSK01018", "[Lane Code]");
// 					formObj.vsl_slan_cd.value = "";
// 					formObj.vsl_slan_cd.focus();
					
					return false;
				}
				
//				for(var i=0; i<5; i++){
//					if(currentVVDYard == arr[i][1] && Row != arr[i][0]){
//						ComShowCodeMessage("VSK57023");
//						var row = arr[i][0];
//						sheetObj.CellValue2(Row, prefix+"tml_cd") = originalVVDYard.substring(14,16);
//					}
//				}

				break;

			case COMMAND20:      // Phase Out
			
			case SEARCH13:      // Port Tariff Calculation
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("VSK00021","Searched data");
					formObj.vsl_cd.focus();
					return;
				}
				break;
				
			//::2007816:://
			case COMMAND30:
			
				var headCnt 	= sheetObj.HeaderRows;
				var rowCnt 		= sheetObj.RowCount;
				var totCnt 		= getTotalRowCnt(sheetObj);
				var prefix 		= sheetObj.id + "_";
				
				if(rowCnt == 0){
					//'There is no data to transfer';
					ComShowCodeMessage("VSK57019");
					return false;
				}
				
				var vvd			= formObj.vsl_cd.value+formObj.skd_voy_no.value+formObj.skd_dir_cd.value;
				
				if(!ComShowCodeConfirm("VSK57021",vvd))	return false;
			
		}

		return true;
	}
	
	/**
	 * 해당 목록을 조회
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionSearch(sheetObj, formObj, sAction){
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";
		
		if(validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH;
			
			if (sheetID == "sheet1"){
				formObj.rtv_flg.value = "N";
			}else{
				//시뮬레이션 데이타를 조회할건지 구분.
				if(formObj.sim_dt.value == "" && formObj.sim_no.value == ""){
					formObj.rtv_flg.value = "N";
				}else{
					formObj.rtv_flg.value = "Y";
				}
			}
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0015GS.do", sParam);
			ComOpenWait(false);
			showSheetData(sheetObj, formObj, sXml);
			
			// clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
			resetClptIndSeq(sheetObj);
		

//			var rowCount = 0;
//			for(var i=sheetObj.HeaderRows; i<=sheetObj.RowCount+1; i++){
//				var vvdYard1 = sheetObj.CellValue(i, prefix+"vvd") + sheetObj.CellValue(i, prefix+"vps_port_cd");
//				for(var j=sheetObj.HeaderRows; j<=sheetObj.RowCount+1; j++){
//					if(j!=i){
//						var vvdYard2 = sheetObj.CellValue(j, prefix+"vvd") + sheetObj.CellValue(j, prefix+"vps_port_cd");
//						if(vvdYard1 == vvdYard2){
//							arr[rowCount][0] = i;
//							arr[rowCount][1] = sheetObj.CellValue(i, prefix+"vvd") + sheetObj.CellValue(i, prefix+"vps_port_cd") + sheetObj.CellValue(i, prefix+"tml_cd");
//							rowCount++;
//						}
//					}
//			    }
//		    }
			
			
			
		}
	}
	
	/**
	 * 해당 목록을 저장
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionSave(sheetObj, formObj, sAction){
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";
		
		phaseInOutHistory(sheetObj);
		
		if(validateForm(sheetObj, formObj, sAction)){
			var headCnt = sheetObj.HeaderRows;
			var totCnt = getTotalRowCnt(sheetObj);
			
			// phase out 된 건들을 삭제 시키기 위해
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.CellValue(i, prefix+"tmp_phase_flag") == "H"){
//					sheetObj.CellValue2(i, prefix+"ibflag") = "D";
					sheetObj.RowStatus(i) = "D";
				}
			}
			
			if (sheetID == "sheet1" && sAction == IBSAVE){
				// Sheet1 Save
				formObj.f_cmd.value = MULTI;
				
//				pickPfData(sheetObj);

				var sParam = ComGetSaveString(sheetObjects, true);

				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj);
				
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("VOP_VSK_0015GS.do", sParam);
				ComOpenWait(false);
				
				sheetObj.LoadSaveXml(sXml);
				
				// SAVE OK 일 경우 저장된 내용 다시 조회.
				var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
				if(nodeText == "OK"){
					doActionSearch(sheetObj, formObj, IBSEARCH);
					sheetObjects[3].RemoveAll();
					addcallVVDYard = null;
				}
				
				
			}else if(sheetID == "sheet2"){
				if(sAction == IBSAVE){
					// Sheet2 Save
					formObj.f_cmd.value = MULTI01;
				}else if(sAction == COMMAND01){
					// Settlement
					formObj.f_cmd.value = MULTI02;
				}else{
					return false;
				}
				
				if(formObj.sim_dt.value == ""){
					//Simulation Table에 넣기 위하여 ibflag 값을 강제로 I로 변경.
					for(var i=headCnt; i<=totCnt; i++){
//						if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//							sheetObj.CellValue2(i, prefix+"ibflag") = "I";
//						}
						if(sheetObj.RowStatus(i) != "D"){
							sheetObj.RowStatus(i) = "I";
						}
					}
				}else{
					for(var i=headCnt; i<=totCnt; i++){
//						if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//							sheetObj.CellValue2(i, prefix+"ibflag") = "U";
//						}
						if(sheetObj.RowStatus(i) != "D"){
							sheetObj.RowStatus(i) = "U";
						}
					}
					//조회한 조건을 다시 Setting.
					formObj.vsl_cd.value = glbMainVslCd;
					formObj.skd_voy_no.value = glbMainSkdVoyNo;
			    	formObj.skd_dir_cd.value = glbMainSkdDirCd;
				}
				
				var sParam = ComGetSaveString(sheetObjects, true);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj);
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("VOP_VSK_0015GS.do", sParam);
				ComOpenWait(false);
				sheetObj.LoadSaveXml(sXml);
				
				var rootNode = VskGetXmlRootNode(sXml);
				var errDataNode = rootNode.selectSingleNode("//ERROR");
				if(!errDataNode){
					//simulation no. 를 새로 생성할 경우 
					if(formObj.sim_dt.value == ""){
						setDisplaySimNo(sheetObj, formObj, sXml);
					}
				}
				
				// SAVE OK 일 경우 저장된 내용 다시 조회.
				var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
				if(nodeText == "OK"){
					doActionSearch(sheetObj, formObj, IBSEARCH);
					addcallVVDYard = null;
				}
				
				
			}
		}
	}
    
    /**
     * 조회 후 처리로직.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml){
    	var prefix = sheetObj.id + "_";
    	var currVvd = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
    	var currVvdRow = null;	// 화면 조회 조건의 VVD로 최초 Focus 이동.
    	var currVvdFlg = true;	// 조회한 VVD를 찾기위한 변수.
    	var rowHdnFlg = false;	// Simulation 조회 시 Hidden 된 Row 가 있는지 여부
    	
    	// 조회한 VVD 를 저장해 둔다.
    	glbMainVslCd = formObj.vsl_cd.value;
    	glbMainSkdVoyNo = formObj.skd_voy_no.value;
    	glbMainSkdDirCd = formObj.skd_dir_cd.value;
    	
    	sheetObj.ScrollBar = 3;
    	
    	glbTmlFlg = "N";		// yd_cd 변경 시 mnvr_in_hrs/mnvr_out_hrs 을 조회할 지 여부(Row 조회 시 yd_cd 변경 될 때에는 막음).
    	
    	if(sheetObj.ColHidden(prefix+"turn_skd_voy_no") == false) sheetObj.ColHidden(prefix+"turn_skd_voy_no") = true;
		if(sheetObj.ColHidden(prefix+"turn_skd_dir_cd") == false) sheetObj.ColHidden(prefix+"turn_skd_dir_cd") = true;
    	
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					var bgRgbColors = new Array(sheetObj.RgbColor(255, 255, 60), sheetObj.RgbColor(255, 255, 165), null, sheetObj.RgbColor(187, 196, 247), sheetObj.RgbColor(103, 123, 237));

					sheetObj.Redraw = false;
					
					glbMainVslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
					
					var dlayRsnCd = ComGetEtcData(sXml, "dlay_rsn_cd");	// Delay Reason Code
					var dlayRsnNm = ComGetEtcData(sXml, "dlay_rsn_nm");	// Delay Reason Name
					var tmpCode = "";
					var tmpRsn = "";
					//lyjlyj
					
					var code1 = ["SBW","SMT","SVD","SDA","WAD","WPG","WPC","WPV","WMT","WCA","WIO","WNH","OTH"];
					var code2 = dlayRsnCd.split('|');
					var code3 = dlayRsnNm.split('|');
						
					for(i=0; i<=code1.length; i++){
						for(j=0; j<code2.length; j++){
							if(code1[i] == code2[j]){
								if( tmpCode == "" || tmpCode == null ){
									tmpCode += code2[j];
									tmpRsn += code3[j];
								}else{
									tmpCode += "|" + code2[j];
									tmpRsn += "|" + code3[j];
								}
								
							}
						}
					}
					sheetObj.InitDataCombo(0, prefix+"vsl_dlay_rsn_cd", " |"+tmpRsn, " |"+tmpCode, " ", " ");

					
					
					var chgStsCds = ComGetEtcData(sXml, "chg_sts_cd");	// Change Status Code
// 					var chgStsNms = ComReplaceStr(ComGetEtcData(sXml, "chg_sts_nm"), " calling", ""); //Change Status CodeName(code명이 길어서 줄임).
					var chgStsNms = ComGetEtcData(sXml, "chg_sts_nm"); 	// Change Status CodeName.
					sheetObj.InitDataCombo(0, prefix+"skd_cng_sts_cd", " |"+chgStsNms, " |"+chgStsCds);

					sheetObj.LoadSearchXml(sXml);
					initPortDataFlg(sheetObj);
					
					if(glbSheetFlg == "sheet1"){
						//Remark Setting.
						setRemarkCombo(sheetObj, formObj);
						
						// pf_tztm_hrs > tmp_tztm_hrs, pf_act_wrk_hrs > tmp_act_wrk_hrs
						setTmpHrs(sheetObj);
					}
					
					var headCnt = sheetObj.HeaderRows;
					var rowCnt = sheetObj.RowCount;
					var totCnt = getTotalRowCnt(sheetObj);
					var ydCds = ComGetEtcData(sXml, "tml_cd").split("|");
					var vvdIdx = getVvdCnt(sheetObj);
					var boundIdx = 2;
					if(vvdIdx == 3){
						boundIdx = 1;
					}else if(vvdIdx == 4){
						boundIdx = 0;
					}else if(vvdIdx == 5){
						boundIdx = 0; 
					}
					
//					if(ydCds == null || ydCds == undefined || ydCds == ""){
						// 해당 처리로직 미구현
//					}
					
					//sheet2
					if(formObj.sim_dt.value != ""){
						setSimulationForm(sheetObj, formObj);	//Simulation 조회값 Setting.
						currVvd = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
						
						// (Simulation 시점의) 조회한 VVD 를 저장해 둔다.
				    	glbMainVslCd = formObj.vsl_cd.value;
				    	glbMainSkdVoyNo = formObj.skd_voy_no.value;
				    	glbMainSkdDirCd = formObj.skd_dir_cd.value;
					}

					var sVvd = sheetObj.CellValue(headCnt, prefix+"vvd");
					// ydCds.length = sheetObj.RowCount
					for(var i=headCnt; i<=totCnt; i++) {
						//Terminal Code Setting.
						sheetObj.CellComboItem(i, prefix+"tml_cd", ydCds[i-headCnt], ydCds[i-headCnt]);
						sheetObj.CellValue2(i, prefix+"tml_cd") = ydCds[i-headCnt];
						
						var delay_str =   sheetObj.CellValue(i, prefix+"dlay_date_text"); 
						///*
						if( i+1 < totCnt && sheetObj.CellValue(i,  prefix +"conti_cd") != sheetObj.CellValue(i+1,  prefix +"conti_cd"))
						{
							if( delay_str != "" ){
								if(Number(delay_str.substring(0,2)) < 1 &&   Number(delay_str.substring(4).replace("H",""))< 12 )
								{
									sheetObj.CellValue2(i, prefix+"dlay_date_text") = "";
								
								}
							}
						}
						//*/
			    		var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
			    		if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
//					    	TURN_PORT_IND_CD가 (D, V, F)일 경우는 ETA, ETB, ETD만 수정가능.
//	 						Yard 변경가능하게 추가요청(임창빈 수석 - 2009.11.16)
//	 						Delay Reason 수정가능하게 변경(2009.11.16) - Virtual 도 Delay Date 수정가능게 변경해 달라고 요청받아 같이 수정.
			    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
			    			sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
			    		}
				    		
						//Row Color Setting...
			    		if(sVvd != sheetObj.CellValue(i, prefix+"vvd")){
			    			boundIdx++;
			    			sVvd = sheetObj.CellValue(i, prefix+"vvd");
			    		}
			    		//Row 의 배경색을 Bound 단위로 변경함.
			    		if(bgRgbColors[boundIdx] != null){
			    			sheetObj.RowBackColor(i) = bgRgbColors[boundIdx];
			    		}
			    		
			    		//조회한 VVD를 찾음.
			    		if(sheetObj.CellValue(i, prefix+"vvd") == currVvd && currVvdFlg){
			    			currVvdRow = i;
			    			currVvdFlg = false;
			    			sheetObj.CellValue(i, prefix+"tmp_bkg_valid") = "";
			    		}
							
						if(glbSheetFlg == "sheet1"){
				    		//FontColor Setting...
				    		if(sheetObj.CellValue(i, prefix+"eta_delay_flg") == "A"){
				    			sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbAdvanceFontColor;
				    		}else if(sheetObj.CellValue(i, prefix+"eta_delay_flg") == "D"){
				    			sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbDelayFontColor;
				    		}
				    		if(sheetObj.CellValue(i, prefix+"etb_delay_flg") == "A"){
				    			sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbAdvanceFontColor;
				    		}else if(sheetObj.CellValue(i, prefix+"etb_delay_flg") == "D"){
				    			sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbDelayFontColor;
				    		}
				    		if(sheetObj.CellValue(i, prefix+"etd_delay_flg") == "A"){
				    			sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbAdvanceFontColor;
				    		}else if(sheetObj.CellValue(i, prefix+"etd_delay_flg") == "D"){
				    			sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDelayFontColor;
				    		}
				    		
				    		//[Updated Status] Color Setting...
				    		if(sheetObj.CellValue(i, prefix+"upd_sts") == "Actual"){
				    			sheetObj.CellBackColor(i, prefix+"upd_sts") = glbActualColor;
				    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
				    		} else if (sheetObj.CellValue(i, prefix+"upd_sts") == "HQ/RSO") {
				    			sheetObj.CellBackColor(i, prefix+"upd_sts") = glbHQColor;
					    	} else if (sheetObj.CellValue(i, prefix+"upd_sts") == "Noon") {
					    		sheetObj.CellBackColor(i, prefix+"upd_sts") = glbNoonColor;
					    	} else if (sheetObj.CellValue(i, prefix+"upd_sts") == "Departure") {
					    		sheetObj.CellBackColor(i, prefix+"upd_sts") = glbDepartureColor;
					    	} else if (sheetObj.CellValue(i, prefix+"upd_sts") == "Initial") {
					    		sheetObj.CellBackColor(i, prefix+"upd_sts") = glbInitialColor;
				    		}
				    		
				    		if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "A"){
				    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
				    			
				    			sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
				    		} else if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "B") {
				    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
				    			sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
				    			
				    			sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
				    		} else if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "D") {
//					    		sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etd_dt") = false;
//					    			
//					    		sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"tml_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
				    			sheetObj.RowEditable(i) = false;
				    		}
						} else if (glbSheetFlg == "sheet2") {
				    		if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "A"){
				    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;

				    			sheetObj.CellEditable(i, prefix+"vvd") = false;
				    			sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
				    			sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
				    		} else if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "B") {
				    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
				    			sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
				    			
				    			sheetObj.CellEditable(i, prefix+"vvd") = false;
				    			sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
				    			sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
				    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
				    		} else if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "D") {
//					    		sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etd_dt") = false;
//					    			
//					    		sheetObj.CellEditable(i, prefix+"vvd") = false;
//					    		sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"tml_cd") = false;
				    			sheetObj.RowEditable(i) = false;
				    		}
				    		
				    		//Simulation 조회 시 해당 항목이 Y 이면 해당 Row 는 Hidden 처리
				    		if(sheetObj.CellValue(i, prefix+"usr_hdn_flg") == "Y"){
				    			sheetObj.RowHidden(i) = true;
				    			rowHdnFlg = true;
				    		}
						}// end sheet2
				    		
//			    		if(getSeaDlayTime(sheetObj, i) >= 7.5){
				    		sheetObj.CellValue2(i, prefix+"sea_date_text") = calcSeaDlayTime(sheetObj, i);
//			    		}else{
//			    			sheetObj.CellValue2(i, prefix+"sea_date_text") = "";
//			    			sheetObj.CellValue2(i, prefix+"vsl_dlay_rsn_cd") = "";
//			    			sheetObj.CellValue2(i, prefix+"vsl_dlay_rsn_desc") = "";
//			    		}

						// Save 시에 OFC_INP_FLG 컬럼을 'Y'로 변경(임창빈 수석 요청)
			    		sheetObj.CellValue(i, prefix+"ofc_inp_flg") = "Y";
			    		
			    		// 마지막 Actual 이전의 Port는 모두 수정 불가(Actual Port 는 port_skd_sts_cd 상태에 따라 판단).
			    		if(sheetObj.CellValue(i, prefix+"bfr_act_flg") == "X"){
			    			sheetObj.RowEditable(i) = false;
			    		}
					}// end for
					
					initButton(sheetObj);
					
					if(glbSheetFlg == "sheet1"){
//						ComBtnEnable("btn_row_hide_1");
					}else{
						sheetObj.SumText(0, prefix+"clpt_seq") = " ";
						sheetObj.SumText(0, prefix+"add_bnk_csm_qty") = "Total Cost";
// 						sheetObj.SumText(0, prefix+"ib_cgo_qty") = "Total Cost";//sheetObj.ShowSum();
// 						sheetObj.SumText(0, prefix+"ob_cgo_qty") = "Total Cost";
//						ComBtnEnable("btn_row_hide_2");

		    			if(rowHdnFlg){
//		    				ComBtnEnable("btn_row_hide_cancel_2");
		    			}
		    			
		    			calcTotalCost(sheetObj);
					}
					
					//첫번째 Delay(Sea, RSN)는 막음(김기원 K - 2009.12.07).
					sheetObj.CellEditable(headCnt, prefix+"vsl_dlay_rsn_cd") = false;
// 					sheetObj.CellBackColor(headCnt, prefix+"sea_date_text") = glbInitialColor;
// 					sheetObj.CellBackColor(headCnt, prefix+"vsl_dlay_rsn_cd") = glbInitialColor;
		    		
					// clpt_seq 새로 부여.
					resetClptSeq(sheetObj);
					
					// 버튼 활성화 상태처리.
					setRowControlBtnSts(sheetObj, sheetObj.SelectRow);
					
					sheetObj.Redraw = true;
		    		
					for(var i=headCnt; i<=totCnt; i++) {
						//Skip 한 Port 는 수정 불가
			    		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
			    			sheetObj.SelectCell(i, 1);
			    			sheetObj.RowEditable(i) = false;
			    			// sheetObj.Redraw = true 이후에 특정(=화면에 안보이거나 Editable 이 false 인 바탕색) Font Color 변경가능함.
			    			fontColorChangeBySkip(sheetObj, i);
			    		}
					}
					
					if(currVvdRow != null && currVvdRow != undefined && currVvdRow != ""){
						sheetObj.SelectCell(currVvdRow, 1);
						setFormData(sheetObj, currVvdRow, 1);
						
						glbMainVslSlanCd = formObj.vsl_slan_cd.value;
					}
					
					var lastPortWarnFlg = ComGetEtcData(sXml, "last_port_warn_flg");	// Vessel / Lane 의 Last Port Warning Flag
					if ("Y" == lastPortWarnFlg) {
						ComShowCodeMessage("VSK57026");
						//ComBtnDisable("btn_save");
					} else {
						ComBtnEnable("btn_save");
					}
				}else{
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}
		}
		
		glbTmlFlg = "Y";		// yd_cd 변경 시 mnvr_in_hrs/mnvr_out_hrs 을 조회할 지 여부(Row 조회 시 yd_cd 변경 될 때에는 막음).
    }
		
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */

//    function sheet1_OnBeforeEdit(sheetObj, Row, Col){
//    	
//		var prefix = sheetObj.id + "_";
//		var headCnt = sheetObj.HeaderRows;
//		var formObj = document.form;
//		
//		if(Row >= headCnt && Col > 0){
//			var colName = sheetObj.ColSaveName(Col);
//			switch(colName){
//				case prefix+"lnk_dist":
//					var dist = Number(sheetObj.CellValue(Row, prefix+"lnk_dist"));
//					var pfDist = Number(sheetObj.CellValue(Row, prefix+"pf_lnk_dist"));
//					if(dist>pfDist){
//						sheetObj.CellValue2(Row, prefix+"lnk_dist") = "";
//						ComShowCodeMessage("VSK00107", pfDist);
//						return false;
//					}
//					break;
//			}
//		}
//    	
//    }
    
    
    
	function sheet1_OnDblClick(sheetObj,Row,Col,Value) {
		var formObj 			= document.form;
		var prefix 				= "sheet1_";
		sheetObj.ShowDebugMsg 	= false;
		 
		switch (sheetObj.ColSaveName(Col)) 
		{
			case prefix + "upd_sts" :
				if(sheetObj.CellValue(Row, prefix+"upd_sts")=="Actual"){
					var vslCd = sheetObj.CellValue(Row, prefix+"vsl_cd");
					var skdVoyNo = sheetObj.CellValue(Row, prefix+"skd_voy_no");
					var skdDirCd = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
					var ydCd = sheetObj.CellValue(Row, prefix+"yd_cd");
					var clptIndSeq = sheetObj.CellValue(Row, prefix+"clpt_ind_seq");
					var url = "/hanjin/VOP_VSK_0025.do?vslCd="+ vslCd+"&skdVoyNo="+skdVoyNo+"&skdDirCd="+skdDirCd+"&ydCd="+ydCd+"&clptIndSeq="+clptIndSeq+"&popYn=Y";
					var rtnObj = ComOpenPopup(url, 1010, 655, "", "0,0", true);
				}
				break;
				
			case prefix + "port_tariff_usd_amt" :
				if(sheetObj.CellValue(Row, prefix+"port_sur_or_dc_exist_yn") == "Y"){
					
					var vps_port_cd	= sheetObj.CellValue(Row, prefix+"vps_port_cd"	);
					var yd_cd		= sheetObj.CellValue(Row, prefix+"tml_cd"		);
					
					var url			= "/hanjin/VOP_PSO_0036.do?port_cd="+vps_port_cd+"&btn_port_cd="+yd_cd;
					
					////alert(url);
					var rtnObj	= ComOpenPopup(url, 1000, 800, "pso_tariff_popup", "none", true);
				}	
					
				//String pop_port_cd = JSPUtil.getParameter(request, "port_cd"   , "");
				//String pop_btn_port_cd = JSPUtil.getParameter(request, "btn_port_cd", "");
				//String popup_flg        = (request.getParameter("port_cd") == null)? "N" : "Y";
				
				break;
		}
		
	}
	
	function sheet1_OnClick(sheetObj, Row, Col) {
		var prefix	= sheetObj.id + "_";
		var colName = sheetObj.ColSaveName(Col);
		
		if(colName == prefix+"tml_cd") {		
			if(glbTmlFlg == "Y"){
				// to prevent yard change in the Double calling case. 2015.01.05
				originalVVDYard = sheetObj.CellValue(Row, prefix+"vvd")+ sheetObj.CellValue(Row, prefix+"vps_port_cd") + sheetObj.CellValue(Row, prefix+"tml_cd"); 
				originalVVDSeq = sheetObj.CellValue(Row, prefix+"clpt_seq");
				yardCngFlg = "Y";
					
			}
		}
	}
	
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix	= sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml 	= null;
		
		////alert('sheet1_OnChange Row ['+Row+'] Col ['+Col+'] Value ['+Value+']');
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"vps_port_cd"){							//Port 변경 시
				glbSkdPortFlgs[Row-headCnt] = "N";
				
				// Termanal Code 조회
				formObj.loc_cd.value = sheetObj.CellValue(Row, prefix+"vps_port_cd");
				// Dist 조회
				if(Row > headCnt){
					var startRow = getNotSkipRow(sheetObj, Row, "P");
					var endRow = getNotSkipRow(sheetObj, Row, "N");
	    			if(startRow > 0 && endRow > 0){
						var fmLocCd = sheetObj.CellValue(startRow, prefix+"vps_port_cd");
						fmLocCd = fmLocCd + "|" + sheetObj.CellValue(Row, prefix+"vps_port_cd");
						var toLocCd = sheetObj.CellValue(Row, prefix+"vps_port_cd");
						toLocCd = toLocCd + "|" + sheetObj.CellValue(endRow, prefix+"vps_port_cd");
						
						formObj.fm_loc_cd.value = fmLocCd;
						formObj.to_loc_cd.value = toLocCd;
	    			}
				}
				
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
				
				if(isCheckPort(sheetObj, Row, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						var rootNode = VskGetXmlRootNode(sXml);
						var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue = dataNode.value;
	
							if(totValue > 0){
								setBaseInfo(sheetObj, sXml, Row, "PORT_CHANGE");
								
								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.CellValue2(Row, prefix+"tml_cd") = "";
							}
						}
					}
					glbSkdPortFlgs[Row-headCnt] = "Y";
				}else{
					glbSkdPortFlgs[Row-headCnt] = "N";
				}
				
				//각 VVD의 첫번째 ETB 가 변경될 경우 해당 VVD의 모든 ST_PORT_CD를 수정한다.
				if(colName == prefix+"vps_port_cd" && sheetObj.CellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					var stPortCd = sheetObj.CellValue(Row, prefix+"vps_port_cd");
					for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.CellValue(i+headCnt, prefix+"st_port_cd") = stPortCd;
						}
					}
				}
				
			}else if(colName == prefix+"vps_eta_dt"							// ETA, ETB, ETD 변경 시
					|| colName == prefix+"vps_etb_dt"
					|| colName == prefix+"vps_etd_dt"){
				
				//ETA, ETB, ETD 날짜 포맷 검사.
				if(VskIsDateValid(sheetObj, Row, Col) == false){
					return false;
				}

				//2015.02.04 delay OR Advnaced 된 month까지만 update되도록 로직 조정 <김기원차장님 요청>
				//alert( sheetObj.CellValue( Row, Col ) );
				var yymm = formObj.curr_yymm.value;
				updateMon = yymm.replace("-","");
				updateVVD = sheetObj.CellValue( Row,  prefix+"vvd" );
				//alert( updateMon);
				//return;
				
				//>>
				//>>if(!sheetObj.ColHidden(prefix+"lnk_dist")){
				//>>	calcSchedule(sheetObj, Row, Col);
				//>>}
				calcSchedule(sheetObj, Row, Col);//<<
				controlAuto++;
				
				//>>//Delay Date 계산
				//>>if(colName == prefix+"vps_etd_dt"){
				//>>	setDelayTime(sheetObj, Row, Col, prefix+"pf_etd_dt");
				//>>	if(Row < sheetObj.LastRow){
				//>>		
				//>>		if(getSeaDlayTime(sheetObj, Row+1) >= 7.5){
				//>>			sheetObj.CellValue2(Row+1, prefix+"sea_date_text") = calcSeaDlayTime(sheetObj, Row+1);
				//>>		}else{
				//>>			sheetObj.CellValue2(Row+1, prefix+"sea_date_text") = "";
				//>>		}
				//>>		
				//>>		// Sea Delay Time이 없으면 Delay Reason 정보도 삭제한다.
				//>>		if(sheetObj.CellValue(Row+1, prefix+"sea_date_text") == ""){
				//>>			sheetObj.CellValue2(Row+1, prefix+"vsl_dlay_rsn_cd") = "";
				//>>			sheetObj.CellValue2(Row+1, prefix+"vsl_dlay_rsn_desc") = "";
				//>>			sheetObj.CellBackColor(Row+1, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(Row+1, prefix+"sea_date_text");
				//>>		}
				//>>	}
				//>>}else if(colName == prefix+"vps_eta_dt"){
				//>>	if(Row > headCnt){
				//>>		
				//>>		if(getSeaDlayTime(sheetObj, Row) >= 7.5){
				//>>			sheetObj.CellValue2(Row, prefix+"sea_date_text") = calcSeaDlayTime(sheetObj, Row);
				//>>		}else{
				//>>			sheetObj.CellValue2(Row, prefix+"sea_date_text") = "";
				//>>		}
				//>>		
				//>>		// Sea Delay Time이 없으면 Delay Reason 정보도 삭제한다.
				//>>		if(sheetObj.CellValue(Row, prefix+"sea_date_text") == ""){
				//>>			sheetObj.CellValue2(Row, prefix+"vsl_dlay_rsn_cd") = "";
				//>>			sheetObj.CellValue2(Row, prefix+"vsl_dlay_rsn_desc") = "";
				//>>			sheetObj.CellBackColor(Row, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(Row, prefix+"sea_date_text");
				//>>		}
				//>>	}
				//>>}

				//각 VVD의 첫번째 ETB 가 변경될 경우 해당 VVD의 모든  N1ST_PORT_BRTH_DT를 수정한다.
				if(colName == prefix+"vps_etb_dt" && sheetObj.CellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					var n1stPortBrthDt = sheetObj.CellValue(Row, prefix+"vps_etb_dt");
					for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.CellValue(i+headCnt, prefix+"n1st_port_brth_dt") = n1stPortBrthDt;
						}
					}
				}
				if( controlAuto == 1 ){				
					if(!sheetObj.ColHidden(prefix+"lnk_dist")){
						calcPfData(sheetObj, Row, Col);
					}
				}
				
				conti_recovery = "N";
			}else if(colName == prefix+"lnk_dist" || colName == prefix+"lnk_spd"){							//SPD 변경 시
				/*
				 * lnk_dist(거리)
				 * lnk_spd 
				 * tztm_hrs(sea_time)
				 * act_wrk_hrs(port_time) 
				 * port_buf_hrs 
				 * sea_buf_hrs 
				 * mnvr_in_hrs
				 * mnvr_out_hrs 
				 * sea_time = lnk_dist(거리) / lnk_spd
				 */

				var yymm = formObj.curr_yymm.value;
				updateMon = yymm.replace("-","");
				updateVVD = sheetObj.CellValue( Row,  prefix+"vvd" );
				
				
				var dist	= Number(sheetObj.CellValue(Row, prefix+"lnk_dist"));
				var spd		= Number(sheetObj.CellValue(Row, prefix+"lnk_spd"));
				
				var pfDist	= Number(sheetObj.CellValue(Row, prefix+"pf_lnk_dist"));
				
				////alert('inner lnk_dist or lnk_spd dist ['+dist+'] pfDist ['+pfDist+']');
				
				/******************************************************
				 * AS-IS	: PORT DISTANCE 입력은 PF입력값 이하여야 함.
				 * TO-BD	: PORT DISTANCE PF입력값 비교로직삭제
				 * 	> PORT SKIP의 경우 DISTANCE가 길어지는경우도 존재함
				 *  > 2013.08.26 :: CHM-201326339 - [VOP-VSK] Distance 입력 값에 대한 제한 삭제 (PF distance 보다 작거나 같음)
				 */
				////if(dist>pfDist){
				////	ComShowCodeMessage("VSK00107", pfDist);
				////	sheetObj.CellValue2(Row, prefix+"lnk_dist") = "";
				////	sheetObj.SelectCell(Row, prefix+"lnk_dist", true);
				////	return false;
				////}
				
				sheetObj.CellValue2(Row, prefix+"tztm_hrs") = Math.round(dist/spd);
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"), true);
				
			}else if(colName == prefix+"act_wrk_hrs"){	//Port Time 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"), true);
				
			}else if(colName == prefix+"port_buf_hrs"){	//Buffer Time(Port) 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"), true);
				
			}else if(colName == prefix+"sea_buf_hrs"){	//Buffer Time(Sea) 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"), true);
				
			}else if(colName == prefix+"tml_cd") {
				
				if(glbTmlFlg == "Y"){
					if(sheetObj.CellValue(Row, prefix+"tml_cd") == ""){
						if(yardCngFlg == "Y"){
							// to prevent yard change in the Double calling case. 2015.01.05 
							currentVVDYard = sheetObj.CellValue(Row, prefix+"vvd")+ sheetObj.CellValue(Row, prefix+"vps_port_cd") + sheetObj.CellValue(Row, prefix+"tml_cd"); 
							currentVVDSeq = Number(sheetObj.CellValue(Row, prefix+"clpt_seq"));

							for(var i=headCnt; i<sheetObj.LastRow; i++){
								var compareVVDYard = sheetObj.CellValue(i, prefix+"vvd") + sheetObj.CellValue(i, prefix+"vps_port_cd") + sheetObj.CellValue(i, prefix+"tml_cd");
								var compareVVDSeq = Number(sheetObj.CellValue(i, prefix+"clpt_seq"));
								var	diffSeq = Math.abs(currentVVDSeq-compareVVDSeq);
								if(currentVVDYard == compareVVDYard && i != Row && diffSeq == 1){
									if(addcallVVDYard != null && currentVVDYard.substring(0,14) != addcallVVDYard){
										ComShowCodeMessage("VSK57023");
										sheetObj.CellValue2(Row, prefix+"tml_cd") = originalVVDYard.substring(14,16);
									}else{
										ComShowCodeMessage("VSK57023");
										sheetObj.CellValue2(Row, prefix+"tml_cd") = originalVVDYard.substring(14,16);
									}
								}
							}
						}

						formObj.yd_cd.value = "";
						sheetObj.CellValue2(Row, prefix+"mnvr_in_hrs") = "";
						sheetObj.CellValue2(Row, prefix+"mnvr_out_hrs") = "";
					}else{
						if(yardCngFlg == "Y"){
							// to prevent yard change in the Double calling case. 2015.01.05
							currentVVDYard = sheetObj.CellValue(Row, prefix+"vvd")+ sheetObj.CellValue(Row, prefix+"vps_port_cd") + sheetObj.CellValue(Row, prefix+"tml_cd"); 
							currentVVDSeq = Number(sheetObj.CellValue(Row, prefix+"clpt_seq"));
							for(var i=headCnt; i<sheetObj.LastRow; i++){
								var compareVVDYard = sheetObj.CellValue(i, prefix+"vvd") + sheetObj.CellValue(i, prefix+"vps_port_cd") + sheetObj.CellValue(i, prefix+"tml_cd");
								var compareVVDSeq = Number(sheetObj.CellValue(i, prefix+"clpt_seq"));
								var	diffSeq = Math.abs(currentVVDSeq-compareVVDSeq);
								if(currentVVDYard == compareVVDYard && i != Row && diffSeq == 1){
									if(addcallVVDYard != null && currentVVDYard.substring(0,14) != addcallVVDYard){
										ComShowCodeMessage("VSK57023");
										sheetObj.CellValue2(Row, prefix+"tml_cd") = originalVVDYard.substring(14,16);
									}else if(addcallVVDYard == null){
										ComShowCodeMessage("VSK57023");
										sheetObj.CellValue2(Row, prefix+"tml_cd") = originalVVDYard.substring(14,16);
									}
								}
							}
						}
						
						
						//formObj.yd_cd.value = formObj.loc_cd.value + sheetObj.CellValue(Row, prefix+"tml_cd");
						formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"vps_port_cd") + sheetObj.CellValue(Row, prefix+"tml_cd");
						
						sXml = doActionIBSheet(sheetObj, formObj ,SEARCH05);
						
						sheetObj.CellValue2(Row, prefix+"mnvr_in_hrs") = ComGetEtcData(sXml, "mnvr_in_hrs");
						sheetObj.CellValue2(Row, prefix+"mnvr_out_hrs") = ComGetEtcData(sXml, "mnvr_out_hrs");
						
						if(Row > headCnt){
							calcSchedule(sheetObj, Row-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
						}
					}
				}
				
			}else if(colName == prefix+"skd_cng_sts_cd"){
				var cngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				//var trnPrtCd = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd")
				if(cngStsCd != "" && cngStsCd != "I"){
					ComShowCodeMessage("VSK00078");
					sheetObj.CellValue2(Row, prefix+"skd_cng_sts_cd") = gblSheet1CngStsCd;
				}else{
					gblSheet1CngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				}
			}else if(colName == prefix+"turn_port_flg"){
				//turn_port_flg 을 'Y'로 변경 시 해당 VVD 의 Turnning 정보를 입력해 준다.
				// 'N'으로 변경 시는 Turnning 정보를 삭제해 준다.
				// 모든 turning 정보가 삭제되어도 상관없음(김기원 K - 2009.10.21).
				var turnPortFlg = sheetObj.CellValue(Row, prefix+"turn_port_flg");
				if(turnPortFlg == "Y"){
					
					sheetObj.ColHidden(prefix+"turn_skd_voy_no") = false;
					sheetObj.ColHidden(prefix+"turn_skd_dir_cd") = false;
					
					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					
					for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd && (i+headCnt) != Row){
							if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
								sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_voy_no");
								sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_dir_cd");
								break;
							}
						}
					}
					
					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = true;
					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = true;
					
					if(sheetObj.CellValue(Row, prefix+"port_rotn_seq") == "1"){
						sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "N";
					}else{
						sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "Y";
					}
				}else{
					sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = "";
					sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = "";
					
					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = false;
					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = false;
					
					sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "N";
				}
			}else if(colName == prefix+"vsl_dlay_rsn_cd"){
				// Delay Reason 변경 시 해당 desc 도 변경.
				var sText = sheetObj.GetComboInfo(Row, prefix+"vsl_dlay_rsn_cd", "Text");
				var arrText = sText.split("|");
				var idx   = sheetObj.GetComboInfo(Row, prefix+"vsl_dlay_rsn_cd", "SelectedIndex");
				var sSelText = arrText[idx];
				var arrSelText = sSelText.split("\t");
				sheetObj.CellValue2(Row, prefix+"vsl_dlay_rsn_desc") = arrSelText[1];
			}
			
			/*
			 * turn_port_flg가 'Y'인 Row가 변경될 경우 Virtual Port를 다시 생성하기 위하여
			 * 관련 Row들의 ibflag를 같이 변경해줌.
			 */
//			if(sheetObj.CellValue(Row, prefix+"turn_port_flg") == "Y"){
//				var vvd = sheetObj.CellValue(Row, prefix+"vvd");
//				
//				for(var i=0; i<sheetObj.RowCount; i++){
//					if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
//						if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
//							if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "I" 
//								&& sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "U"
//								&& sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//								sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = "U";
//							}
//						}
//					}
//				}
//			}
		}
	}
	
	function phaseInOutHistory(sheetObj){
		var prefix	= sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		
		for(var Row=headCnt; Row<headCnt+sheetObj.RowCount; Row++){
			var cngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
			var trnPrtCd = sheetObj.CellValue(Row, prefix+"turn_skd_voy_no");
			
			if(cngStsCd != "" && (cngStsCd == "I" || cngStsCd == "O" ) && trnPrtCd == "" && sheetObj.RowHidden(Row) != true){
				var rowIdx = sheetObjects[3].LastRow;
				sheetObjects[3].DataInsert(rowIdx);	
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_slan_cd") 	= sheetObj.CellValue(Row, prefix+"vsl_slan_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_vsl_cd") 		= sheetObj.CellValue(Row, prefix+"vsl_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_voy_no") 	= sheetObj.CellValue(Row, prefix+"skd_voy_no");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_dir_cd") 	= sheetObj.CellValue(Row, prefix+"skd_dir_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_vps_port_cd") = sheetObj.CellValue(Row, prefix+"vps_port_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_clpt_seq")	= sheetObj.CellValue(Row, prefix+"clpt_seq");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_yd_cd") 		= sheetObj.CellValue(Row, prefix+"yd_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_clpt_ind_seq") = sheetObj.CellValue(Row, prefix+"clpt_ind_seq");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_cng_sts_cd") = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
	
			}else if(cngStsCd != "" && (cngStsCd == "I" || cngStsCd == "O" ) && trnPrtCd != "" && sheetObj.RowHidden(Row) != true){
				var rowIdx = sheetObjects[3].LastRow;
				sheetObjects[3].DataInsert(rowIdx);	
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_slan_cd") 	= sheetObj.CellValue(Row, prefix+"vsl_slan_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_vsl_cd") 		= sheetObj.CellValue(Row, prefix+"vsl_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_voy_no") 	= sheetObj.CellValue(Row, prefix+"skd_voy_no");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_dir_cd") 	= sheetObj.CellValue(Row, prefix+"skd_dir_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_vps_port_cd") = sheetObj.CellValue(Row, prefix+"vps_port_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_clpt_seq")	= sheetObj.CellValue(Row, prefix+"clpt_seq");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_yd_cd") 		= sheetObj.CellValue(Row, prefix+"yd_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_clpt_ind_seq") = sheetObj.CellValue(Row, prefix+"clpt_ind_seq");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_cng_sts_cd") = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				
				var rowIdx = sheetObjects[3].LastRow;
				sheetObjects[3].DataInsert(rowIdx);	
//				sheetObjects[3].CellValue2(rowIdx+1, "slan_cd") 	= sheetObj.CellValue(Row, prefix+"vsl_slan_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_vsl_cd") 		= sheetObj.CellValue(Row, prefix+"vsl_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_voy_no") 	= sheetObj.CellValue(Row, prefix+"turn_skd_voy_no");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_skd_dir_cd") 	= sheetObj.CellValue(Row, prefix+"turn_skd_dir_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_vps_port_cd") = sheetObj.CellValue(Row, prefix+"vps_port_cd");
//				sheetObjects[3].CellValue2(rowIdx+1, "clpt_seq")	= sheetObj.CellValue(Row, prefix+"clpt_seq");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_yd_cd") 		= sheetObj.CellValue(Row, prefix+"yd_cd");
				sheetObjects[3].CellValue2(rowIdx+1, "sheet4_clpt_ind_seq") = sheetObj.CellValue(Row, prefix+"turn_clpt_ind_seq");
//				sheetObjects[3].CellValue2(rowIdx+1, "skd_cng_sts_cd") = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				
			}
		}
	}
	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"vps_port_cd"){
				glbPlanPortFlgs[Row-headCnt] = "N";
				
				// Termanal Code 조회
				formObj.loc_cd.value = sheetObj.CellValue(Row, prefix+"vps_port_cd");
				// Dist 조회
				if(Row > headCnt){
					var fmLocCd = sheetObj.CellValue(Row-1, prefix+"vps_port_cd");
					fmLocCd = fmLocCd + "|" + sheetObj.CellValue(Row, prefix+"vps_port_cd");
					var toLocCd = sheetObj.CellValue(Row, prefix+"vps_port_cd");
					toLocCd = toLocCd + "|" + sheetObj.CellValue(Row+1, prefix+"vps_port_cd");
					
					formObj.fm_loc_cd.value = fmLocCd;
					formObj.to_loc_cd.value = toLocCd;
				}
				
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
				
				if(isCheckPort(sheetObj, Row, sXml)){
				
					if(sXml != null && sXml != undefined && sXml != ""){
						var rootNode = VskGetXmlRootNode(sXml);
						var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue = dataNode.value;
	
							if(totValue > 0){
								setBaseInfo(sheetObj, sXml, Row, "PORT_CHANGE");
								
								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.CellValue2(Row, prefix+"tml_cd") = "";
							}
						}
					}
					glbPlanPortFlgs[Row-headCnt] = "Y";
				}else{
					glbPlanPortFlgs[Row-headCnt] = "N";
				}
				
				//각 VVD의 첫번째 ETB 가 변경될 경우 해당 VVD의 모든 ST_PORT_CD를 수정한다.
				if(colName == prefix+"vps_port_cd" && sheetObj.CellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					var stPortCd = sheetObj.CellValue(Row, prefix+"vps_port_cd");
					for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.CellValue(i+headCnt, prefix+"st_port_cd") = stPortCd;
						}
					}
				}
			}else if(colName == prefix+"vps_eta_dt"
					|| colName == prefix+"vps_etb_dt"
					|| colName == prefix+"vps_etd_dt"){
				
				//ETA, ETB, ETD 날짜 포맷 검사.
				if(VskIsDateValid(sheetObj, Row, Col) == false){
					return false;
				}
				
				calcSchedule(sheetObj, Row, Col);
				
				// 각 VVD의 첫번째 ETB 가 변경될 경우 해당 VVD의 모든 N1ST_PORT_BRTH_DT를 수정한다.
				if(colName == prefix+"vps_etb_dt" && sheetObj.CellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					var n1stPortBrthDt = sheetObj.CellValue(Row, prefix+"vps_etb_dt");
					for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.CellValue(i+headCnt, prefix+"n1st_port_brth_dt") = n1stPortBrthDt;
						}
					}
				}
			}else if(colName == prefix+"lnk_dist" || colName == prefix+"lnk_spd"){							//SPD 변경 시
				/*
				 * lnk_dist(거리) 
				 * lnk_spd 
				 * tztm_hrs(sea_time)
				 * act_wrk_hrs(port_time) 
				 * port_buf_hrs 
				 * sea_buf_hrs 
				 * mnvr_in_hrs
				 * mnvr_out_hrs 
				 * sea_time = lnk_dist(거리) / lnk_spd
				 */
				var dist = Number(sheetObj.CellValue(Row, prefix+"lnk_dist"));
				var spd = Number(sheetObj.CellValue(Row, prefix+"lnk_spd"));
				
				sheetObj.CellValue2(Row, prefix+"tztm_hrs") = Math.round(dist/spd);
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"), true);
				
				// Bunker Additional Cost
				calcBunkerAdditionalCostBySpeed(sheetObj, Row, formObj);
				
				// Total Cost
				calcTotalCost(sheetObj);
			}else if(colName == prefix+"act_wrk_hrs"){	//Port Time 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"), true);
				
			}else if(colName == prefix+"port_buf_hrs"){	//Buffer Time(Port) 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"), true);
				
			}else if(colName == prefix+"sea_buf_hrs"){	//Buffer Time(Sea) 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"), true);
				
			}else if(colName == prefix+"mnvr_in_hrs"){	//Maneuvering In 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_eta_dt"), true);
				
			}else if(colName == prefix+"mnvr_out_hrs"){	//Maneuvering Out 변경 시
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"), true);
				
			}else if (colName == prefix+"tml_cd") {
				if(glbTmlFlg == "Y"){
					if(sheetObj.CellValue(Row, prefix+"tml_cd") == ""){
						formObj.yd_cd.value = "";
						
						sheetObj.CellValue2(Row, prefix+"mnvr_in_hrs") = "";
						sheetObj.CellValue2(Row, prefix+"mnvr_out_hrs") = "";
					}else{
						formObj.yd_cd.value = formObj.loc_cd.value + sheetObj.CellValue(Row, prefix+"tml_cd");
						sXml = doActionIBSheet(sheetObj, formObj ,SEARCH12);
						
						sheetObj.CellValue2(Row, prefix+"mnvr_in_hrs") = ComGetEtcData(sXml, "mnvr_in_hrs");
						sheetObj.CellValue2(Row, prefix+"mnvr_out_hrs") = ComGetEtcData(sXml, "mnvr_out_hrs");
						
						if(Row > headCnt){
							calcSchedule(sheetObj, Row-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
						}
					}
					
					var ttlChgAmt = ComGetEtcData(sXml, "ttl_chg_amt");
					if(ttlChgAmt != null && ttlChgAmt != undefined && ttlChgAmt != ""){
						sheetObj.CellValue2(Row, prefix+"pe_usd_ttl_amt") = Number(ttlChgAmt) * (-1);
						calcTotalCost(sheetObj);
					}
				}
			}else if(colName == prefix+"skd_cng_sts_cd"){
				var cngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				if(cngStsCd != "" && cngStsCd != "I" && cngStsCd != "O"){
					ComShowCodeMessage("VSK00077");
					sheetObj.CellValue2(Row, prefix+"skd_cng_sts_cd") = gblSheet2CngStsCd;
				}else{
					gblSheet2CngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				}
			}else if(colName == prefix+"turn_port_flg"){
				//turn_port_flg 을 'Y'로 변경 시 해당 VVD 의 Turnning 정보를 입력해 준다.
				// 'N'으로 변경 시는 Turnning 정보를 삭제해 준다.
				// 모든 turning 정보가 삭제되어도 상관없음(김기원 K - 2009.10.21).
				var turnPortFlg = sheetObj.CellValue(Row, prefix+"turn_port_flg");
				if(turnPortFlg == "Y"){
//					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					
//					for(var i=0; i<sheetObj.RowCount; i++){
//						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd && (i+headCnt) != Row){
//							if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
//								sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_voy_no");
//								sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_dir_cd");
//								break;
//							}
//						}
//					}
//					
//					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = true;
//					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = true;
					
					if(sheetObj.CellValue(Row, prefix+"port_rotn_seq") == "1"){
						sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "N";
					}else{
						sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "Y";
					}
				}else{
//					sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = "";
// 					sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = "";
//					
// 					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = false;
// 					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = false;
					
					sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "N";
				}
			}
			
			/*
			 * turn_port_flg가 'Y'인 Row가 변경될 경우 Virtual Port를 다시 생성하기 위하여
			 * 관련 Row들의 ibflag를 같이 변경해줌.
			 */
//			if(sheetObj.CellValue(Row, prefix+"turn_port_flg") == "Y"){
//				var vvd = sheetObj.CellValue(Row, prefix+"vvd");
//				
//				for(var i=0; i<sheetObj.RowCount; i++){
//					if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
//						if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
//							if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "I" 
//								&& sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "U"
//								&& sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//								sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = "U";
//							}
//						}
//					}
//				}
//			}
		}
	}
	
	/**
	 * sheet1의 선택된 셀이 선택되었을때 발생하는 Event
	 * @param sheetObj
	 * @param OldRow
	 * @param OldCol
	 * @param NewRow
	 * @param NewCol
	 * @return
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		if(NewRow >= sheetObj.HeaderRows && NewCol > 0){
			var formObj = document.form;
			var headCnt = sheetObj.HeaderRows;
			var sXml = null;
			var prefix = sheetObj.id + "_";

			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
				if(!sheetObj.CellEditable(NewRow, NewCol)){
					setRowControlBtnSts(sheetObj, NewRow);
					btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button 활성화 Control.
					setFormData(sheetObj, NewRow, NewCol);
					return;
				}
				if(glbSkdPortFlgs[NewRow-headCnt] != "Y"){
//				if(glbSkdPortFlgs[NewRow-headCnt] == "N"){
					formObj.loc_cd.value = sheetObj.CellValue(NewRow, prefix+"vps_port_cd");
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
					}
					glbSkdPortFlgs[NewRow-headCnt] = "Y";
				}
			}else if(sheetObj.ColSaveName(NewCol) == prefix+"skd_cng_sts_cd"){
				gblSheet1CngStsCd = sheetObj.CellValue(NewRow, NewCol);
			}
			
			setRowControlBtnSts(sheetObj, NewRow);
			
			btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button 활성화 Control.
			
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	
	/**
	 * sheet2의 선택된 셀이 선택되었을때 발생하는 Event
	 * @param sheetObj
	 * @param OldRow
	 * @param OldCol
	 * @param NewRow
	 * @param NewCol
	 * @return
	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		if(NewRow >= sheetObj.HeaderRows && NewCol > 0){
			var formObj = document.form;
			var headCnt = sheetObj.HeaderRows;
			var sXml = null;
			var prefix = sheetObj.id + "_";
			
			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
				if(!sheetObj.CellEditable(NewRow, NewCol)){
					setRowControlBtnSts(sheetObj, NewRow);
					btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button 활성화 Control.
					setFormData(sheetObj, NewRow, NewCol);
					return;
				}
				if(glbSkdPortFlgs[NewRow-headCnt] != "Y"){
//				if(glbPlanPortFlgs[NewRow-headCnt] == "N"){
					formObj.loc_cd.value = sheetObj.CellValue(NewRow, prefix+"vps_port_cd");
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
					}
					glbPlanPortFlgs[NewRow-headCnt] = "Y";
				}
			}else if(sheetObj.ColSaveName(NewCol) == prefix+"skd_cng_sts_cd"){
				gblSheet2CngStsCd = sheetObj.CellValue(NewRow, NewCol);
			}
			
			setRowControlBtnSts(sheetObj, NewRow);
			
			btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button 활성화 Control.
			
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	
	/**
	 * Sheet1의 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		//Row 다중선택 확인하여 선택된 Row가 2줄인지 확인하여 Reverse Call Button Control
		btnReverseCallControl(sheetObj);
	}
	
	/**
	 * Sheet2의 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		//Row 다중선택 확인하여 선택된 Row가 2줄인지 확인하여 Reverse Call Button Control
		btnReverseCallControl(sheetObj);
	}
	
	/**
	 * Sheet1의 눌려진 마우스가 올라올 때 발생하는 Event
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y){
		//Row 다중선택 확인하여 선택된 Row가 2줄인지 확인하여 Reverse Call Button Control
		btnReverseCallControl(sheetObj);
	}
	
	/**
	 * Sheet2의 눌려진 마우스가 올라올 때 발생하는 Event
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet2_OnMouseUp(sheetObj, Button, Shift, X, Y){
		//Row 다중선택 확인하여 선택된 Row가 2줄인지 확인하여 Reverse Call Button Control
		btnReverseCallControl(sheetObj);
		
	}
	
	/**
	 * Sheet1의 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		btnControlByLoadableWeight(sheetObj, sheetObj.SelectRow);	//Loadable Weight Button 활성화 Control.
		originalVVDYard		= null;
		originalVVDSeq		= null;
		addcallVVDYard		= null;
		currentVVDYard		= null;
		currentVVDSeq		= null;
		yardCngFlg			= "N";
	}

	/**
	 * Sheet2의 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		//Total 자리이동..
// 		sheetObj.SumText(0,1)="";
// 		sheetObj.SumText(0,26)="Total Cost";
		btnControlByLoadableWeight(sheetObj, sheetObj.SelectRow);	//Loadable Weight Button 활성화 Control.
		originalVVDYard		= null;
		originalVVDSeq		= null;
		addcallVVDYard		= null;
		currentVVDYard		= null;
		currentVVDSeq		= null;
		yardCngFlg			= "N";
	}

	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function remark_OnChange(comboObj, Code, Text) {
//		isRmkModFlg = "Y";
// 		clearDescData(sheetObjects[0], document.form, "");
		var sheetObj = sheetObjects[0];
		
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"vvd") == Code){
				sheetObj.SelectCell(i, 1);
				break;
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 		// - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	// - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		// - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	// - form 전체 컨트롤 onkeydownup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	
    	setToday(document.form.curr_yymm, "ym");// 당월 
    	
	}
    
    
	function obj_change(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		try {
			if(glbSheetFlg == "sheet2"){
				sheetObj = sheetObjects[1];
			}
			
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	
	            case "vsl_cd":
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		Usr_setVslCd(formObj.vsl_cd.value);
		            	if(formObj.sim_dt.value == "" && sheetObj.RowCount > 0){
		            		resetAllData(sheetObj, formObj);
		            	}
	            		formNextFocus(formObj, srcName);
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	
	            case "skd_voy_no":
	            	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
	            	if(formObj.sim_dt.value == "" && sheetObj.RowCount > 0){
	            		resetAllData(sheetObj, formObj);
	            		formNextFocus(formObj, srcName);
	            	}
	            	
	            	break;
	
	            case "skd_dir_cd":
	            	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
	            	if(formObj.sim_dt.value == "" && sheetObj.RowCount > 0){
	            		resetAllData(sheetObj, formObj);
	            		formNextFocus(formObj, srcName);
	            	}
	            	
	            	break;
	
	            case "sim_dt":
	            	if(formObj.sim_dt.value == "" && formObj.sim_no.value == ""){
	            		formObj.rtv_flg.value = "N";
	            	}else{
	            		formObj.rtv_flg.value = "Y";
	            	}
	            	
	            	Usr_setSimDt(formObj.sim_dt.value);
	            	
	            	break;
	            	
	            case "sim_no":
	            	if(formObj.sim_dt.value == "" && formObj.sim_no.value == ""){
	            		formObj.rtv_flg.value = "N";
	            	}else{
	            		formObj.rtv_flg.value = "Y";
	            	}
	            	
	            	Usr_setSimNo(formObj.sim_no.value);
	            	
	            	break;
	
	            case "cre_dt":
	            	Usr_setCreDt(formObj.cre_dt.value);
	            	
	            	break;
	
	            case "cre_usr_id":
	            	Usr_setCreUsrId(formObj.cre_usr_id.value);
	            	
	            	break;
	
	            case "vsl_slan_cd":
	            	Usr_setVslSlanCd(formObj.vsl_slan_cd.value);
	            	
	            	break;
	
	            case "bound":
	            	Usr_setBound(formObj.bound.value);
	            	
	            	break;
	
	            case "upd_dt":
	            	Usr_setUpdDt(formObj.upd_dt.value);
	            	
	            	break;
	
	            case "upd_usr_id":
	            	Usr_setUpdUsrId(formObj.upd_usr_id.value);
	            	
	            	break;
	
	            case "skd_rmk":
	            	setRemarkDataByVvd(sheetObj, formObj.skd_rmk.value);
	            	Usr_setSkdRmk(formObj.skd_rmk.value);
	            	
	            	break;
	                
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function obj_keypress(){
		var formObj = document.form;
		switch (event.srcElement.name) {
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(document.form.skd_voy_no);
				break;

		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;

// 			case "skd_rmk":
// 				ComKeyOnlyAlphabet('upper');
// 				break;
		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    	}
				break; 
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    	}
				break;

		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.bound.focus();
// 					document.getElementById("btn_retrieve").focus();
		    	}
				break;
		}
	}
	
	function obj_keydown(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(focusObj=="vsl_cd"){
			var ctrl = event.ctrlKey;
			var code = event.keyCode;
			if(ctrl && code == 86){ 
				var clipData = window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData = clipData.toUpperCase();
					formObj.vsl_cd.value = clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value = clipData.substring(4, 8);
						formObj.skd_dir_cd.value = clipData.substring(8, 9);
					}
				}
				event.returnValue = false;
			}
		}
	}
		
	function obj_focus(){
		var eleObj = event.srcElement;
		
		if(eleObj.name){
			focusObj = eleObj.name;
		}else{
			focusObj = "";
		}
	}
	
	/*
	 * =====================================================================
	 * Button Event
	 * =====================================================================
	 */
    
    /**
	 * [Coastal SKD] / [Recovery Plan] Radio Button Control
	 * @param sheetName
	 * @return
	 */
    function showSheetForm(sheetName){
    	var formObj = document.form;
    	if(sheetName == "sheet1"){
    		var sheetObj = sheetObjects[0];
    		
    		formObj.vsl_cd.className = "input1";
    		formObj.skd_voy_no.className = "input1";
    		formObj.skd_dir_cd.className = "input1";
    		
    		document.getElementById("div_col_show").style.display = "block";
    		document.getElementById("div_col_hide").style.display = "block";
    		document.getElementById("div_plan_col_show").style.display = "none";
    		document.getElementById("div_plan_col_hide").style.display = "none";
    		
    		sheetObjects[0].style.height = glbSheetHeight;
    		sheetObjects[1].style.height = 0;
    		
// 			formObj.skd_rmk.className = "textarea2";
// 			formObj.skd_rmk.readOnly = true;
// 			ComEnableObject(formObj.skd_rmk, sheetObj.RowEditable(sheetObj.SelectRow));
    		
    		glbSheet1FormData.setAllFormData();	// Sheet1의 Form Data Setting...
    	}else{
    		formObj.vsl_cd.className = "input";
    		formObj.skd_voy_no.className = "input";
    		formObj.skd_dir_cd.className = "input";
    		
    		document.getElementById("div_col_show").style.display = "none";
    		document.getElementById("div_col_hide").style.display = "none";
    		document.getElementById("div_plan_col_show").style.display = "block";
    		document.getElementById("div_plan_col_hide").style.display = "block";
    		
    		sheetObjects[1].style.height = glbSheetHeight;
    		sheetObjects[0].style.height = 0;

    		formObj.skd_rmk.className = "textarea";
    		formObj.skd_rmk.readOnly = false;
    		
    		glbSheet2FormData.setAllFormData();	// Sheet2의 Form Data Setting...
    	}
    	
    	replaceButtonSet(formObj);
		
		formObj.vsl_cd.focus();
    }
	
	/**
	 * [Row Hide] Button Event : 선택된 Row를 숨긴다.
	 * @param sheetObj
	 * @return
	 */
	function rowHideControl(sheetObj){
		var prefix = sheetObj.id + "_";
		var selRowStr = sheetObj.GetSelectionRows("|");
		var selRows = selRowStr.split("|");
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		
		if(selRows){
			if(selRows.length > 0){
				
//				Actual SKD인 경우에도 Hide가 가능하도록 변경. 20100610
//				for (i=0; i<selRows.length; i++) {
//					if (sheetObj.CellValue(selRows[i], prefix+"act_inp_flg") == "Y"){
//						//Hidden 처리하기 위해 선택한 Port들 범위내에 Actual SKD이 입력되여 있을 경우.
//						//'Port ({?msg1}) has been already inputted Actual SKD. Please try again.'
//						ComShowCodeMessage("VSK00026", sheetObj.CellValue(selRows[i], prefix+"vps_port_cd"));
//						return;
//					}
//				}
			
				var rowsView = new Array();		// 현재 화면상에 보여지고 있는 Rows
				var	i = 0, k = 0;

				for (i=headCnt; i<headCnt + rowCnt; i++) {
					if (sheetObj.CellValue(i, prefix+"usr_hdn_flg") == "N") {
						// 현재 화면상에 보여지고 있는 Rows
						rowsView[k++] = i;
					}
				}
				
				var fmSelectRow = ComParseInt(selRows[0]); // 사용자가 선택한 첫번째 Row.
				var toSelectRow = ComParseInt(selRows[selRows.length - 1]); // 사용자가 선택한 마지막 Row.
				
				var fmViewRow = rowsView[0]; // 화면에 보여지는 첫번째 Row.
				var toViewRow = rowsView[rowsView.length - 1]; // 화면에 보여지는 마지막 Row.
				
				if (!(fmSelectRow == fmViewRow || toSelectRow == toViewRow)) {
					// 화면상에 보이는 Port 중에 첫번째 또는 마지막 Port는 항상 선택이 되어야 한다.
					// 중간에 Port 만 선택해서 Simulation을 할 수 없다.
					ComShowCodeMessage("VSK00035");
					return;
				}
				
				if ((toSelectRow - fmSelectRow + 1) != selRows.length){
					// Hidden 처리는 연속된 Port에 한에서 사용 가능한다.
					ComShowCodeMessage("VSK00037");
					return;
				}
				
				for (i=0; i<selRows.length; i++) { // Hidden 처리
					sheetObj.CellValue2(selRows[i], prefix+"usr_hdn_flg") = "Y";
					sheetObj.RowHidden(selRows[i]) = true;
				}
				
				if(sheetObj.id == "sheet1"){
//					ComBtnEnable("btn_row_hide_cancel_1");
				}else{
//					ComBtnEnable("btn_row_hide_cancel_2");
				}
			}else{
				//선택된 행이 없습니다.
				ComShowCodeMessage("VSK00020");
			}
		}
	}
	
	/**
	 * [Row Hide Cancel] Button Event : 숨겨진 Row를 모두 펼친다.
	 * @param sheetObj
	 * @return
	 */
	function rowHideCancel(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = getTotalRowCnt(sheetObj);
		
		for (i=headCnt; i<=totCnt; i++) {
//			if(sheetObj.CellValue(i, prefix+"ibflag") != "D"
//				&& sheetObj.CellValue(i, prefix+"tmp_phase_flag") != "H"){
			if(sheetObj.RowStatus(i) != "D"
				&& sheetObj.CellValue(i, prefix+"tmp_phase_flag") != "H"){
				if(sheetObj.RowHidden(i)){
					sheetObj.CellValue2(i, prefix+"usr_hdn_flg") = "N";
					sheetObj.RowHidden(i) = false;
				}
			}
		}
		
		if(sheetObj.id == "sheet1"){
//			ComBtnDisable("btn_row_hide_cancel_1");
		}else{
//			ComBtnDisable("btn_row_hide_cancel_2");
		}
	}
	
	/**
	 * [Skip Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallControl(sheetObj){
		var prefix = sheetObj.id + "_";
		var headRow = sheetObj.HeaderRows;
		var sRow = sheetObj.SelectRow;
		var formObj = document.form;

		formObj.vps_port_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
		formObj.clpt_ind_seq.value = sheetObj.CellValue(sRow, prefix+"clpt_ind_seq");
		
// 		VSK_PORT_DIST
		var sXml = doCallBaseInfo(sheetObj, sRow, "SKIP");
		
		sheetObj.Redraw = false;
		
		try{
			//Dist 및 Sea Time 을 새로 셋팅함.
			setBaseInfo(sheetObj, sXml, sRow, "SKIP");
			
			/*
			 * Hidden Col이 있으면 임시로 펼친다. 
			 * Skip 된 Row 는 font color를 back color로 변경해야 하는데 숨겨진 필드가 있으면 
			 * 변경이 안되므로 숨겨진 필드가 있으면 임시로 펼친 후 로직이 다 실행되면 다시 닫는다.
			 */
			var isColHidden = isHiddenState(sheetObj);
	
			if(isColHidden){
				showFieldControl(sheetObj, formObj, true);
			}
			
			//현재 상태값을 임시공간에 담아둔다.
			sheetObj.CellValue2(sRow, prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(sRow, prefix+"skd_cng_sts_cd");
			// 현재 상태값을 Skip으로 변경.
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "S";

			// Skip 한 Port Edit 불가.
			sheetObj.RowEditable(sRow) = false;
			
			// Delay Reason 이 입력필수 배경색이면 Disable 색으로 변경.
			sheetObj.CellBackColor(sRow, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(sRow, prefix+"sea_date_text");
			fontColorChangeBySkip(sheetObj, sRow);
			
			// skip 한 Row 부터 스케줄 다시 생성.
			// sheet1은 Expend 일 경우에만 스케줄 업데이트.
			if(sheetObj.id != "sheet1" || isColHidden == false){
				if(sRow == headRow){
					calcSchedule(sheetObj, sRow+1, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
				}else{
					calcSchedule(sheetObj, sRow-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
				}
			}
			
			if(isColHidden){
				showFieldControl(sheetObj, formObj, false);
			}
			sheetObj.Redraw = true;
		}catch(e) {
			sheetObj.Redraw = true;
			
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
		
		if(sheetObj.id == "sheet1"){
			ComBtnEnable("btn_skip_call_cancel_1");
			ComBtnDisable("btn_skip_call_1");
		}else{
			ComBtnEnable("btn_skip_call_cancel_2");
			ComBtnDisable("btn_skip_call_2");
		}
	}
	
	/**
	 * [Skip Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallCancel(sheetObj){
		var prefix = sheetObj.id + "_";
		var sRow = sheetObj.SelectRow;
		var formObj = document.form;
		
		if(sheetObj.CellValue(sRow, prefix+"skd_cng_sts_cd") == "S"){
			var sXml = doCallBaseInfo(sheetObj, sRow, "SKIP_CANCEL");
			
			sheetObj.Redraw = false;
			// Dist 및 Sea Time 을 새로 셋팅함.
			setBaseInfo(sheetObj, sXml, sRow, "SKIP_CANCEL");
			/*
			 * Hidden Col이 있으면 임시로 펼친다. 
			 * Skip Cancel된 Row 는 font color를 원래의 color(black)로 변경해야 하는데 
			 * 숨겨진 필드가 있으면 변경이 안되므로 숨겨진 필드가 있으면 임시로 펼친 후 로직이 다 실행되면 다시 닫는다.
			 */
			var isColHidden = isHiddenState(sheetObj);
			
			if(isColHidden){
				showFieldControl(sheetObj, formObj, true);
			}
			// Skip Cancel 한 Port Edit 가능하게.
			sheetObj.RowEditable(sRow) = true;
			
			//임시공간에 있던 상태값을 다시 원래 상태값으로 되돌린다.
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = sheetObj.CellValue(sRow, prefix+"tmp_cng_sts_cd");
			sheetObj.CellValue2(sRow, prefix+"port_skp_tp_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"port_skp_rsn_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"port_skp_rsn_offr_rmk") = "";
			sheetObj.CellValue2(sRow, prefix+"vps_rmk") = "";
			sheetObj.CellValue2(sRow, prefix+"ttl_dlay_hrs") = "";

			
			
			// sheet1, sheet2 공통
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_eta_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etb_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etd_dt");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"delay_date");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"dlay_date_text");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"sea_date_text");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"lnk_dist");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"lnk_spd");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"tztm_hrs");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"act_wrk_hrs");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"port_buf_hrs");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"sea_buf_hrs");
	
			// sheet2 전용
			if(glbSheetFlg == "sheet2"){
				var prePortRow = getNotSkipRow(sheetObj, sRow, "P");
				sheetObj.CellValue2(prePortRow, prefix+"add_bnk_csm_qty") = "";
				sheetObj.CellValue2(prePortRow, prefix+"add_bnk_cost_amt") = "";
				var tsRow = getTsPortRow(sheetObj, sRow);
				sheetObj.CellValue2(tsRow, prefix+"tml_hndl_20ft_ttl_qty") = "";
				sheetObj.CellValue2(tsRow, prefix+"tml_hndl_40ft_ttl_qty") = "";
				sheetObj.CellValue2(tsRow, prefix+"tml_hndl_20ft_ttl_amt") = "";
				sheetObj.CellValue2(tsRow, prefix+"tml_hndl_40ft_ttl_amt") = "";

				
				sheetObj.CellValue2(sRow, prefix+"ts_port_cd") = "";
				sheetObj.CellValue2(sRow, prefix+"ts_skd_voy_no") = "";
				sheetObj.CellValue2(sRow, prefix+"ts_skd_dir_cd") = "";
				sheetObj.CellValue2(sRow, prefix+"ts_clpt_ind_seq") = "";
				sheetObj.CellValue2(sRow, prefix+"port_skp_rsn_offr_rmk") = "";
				sheetObj.CellValue2(sRow, prefix+"rsn_skd_voy_no") = "";
				sheetObj.CellValue2(sRow, prefix+"rsn_skd_dir_cd") = "";
				sheetObj.CellValue2(sRow, prefix+"rsn_clpt_ind_seq") = "";
				sheetObj.CellValue2(sRow, prefix+"pe_usd_ttl_amt") = "";
				
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"time_diff");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"mnvr_in_hrs");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"mnvr_out_hrs");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"crn_knt");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_prod_qty");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ib_cgo_qty");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ob_cgo_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"add_bnk_csm_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"add_bnk_cost_amt");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_20ft_ttl_qty");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_40ft_ttl_qty");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_20ft_ttl_amt");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_40ft_ttl_amt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_amt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_amt");
				
				
			}
			
			// Total Cost
			calcTotalCost(sheetObj);
			
			//skip 한 Row 부터 스케줄 다시 생성.
			if(sheetObj.id != "sheet1" || isColHidden == false){
				if(sRow == sheetObj.HeaderRows){
					calcSchedule(sheetObj, sRow, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
				}else{
					calcSchedule(sheetObj, sRow-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
				}
			}
			
			//임시로 펼쳤던 Col이 있으면 닫는다.
			if(isColHidden){
				showFieldControl(sheetObj, document.form, false);
			}
			sheetObj.Redraw = true;
		
			if(sheetObj.id == "sheet1"){
				ComBtnEnable("btn_skip_call_1");
				ComBtnDisable("btn_skip_call_cancel_1");
			}else{
				ComBtnEnable("btn_skip_call_2");
				ComBtnDisable("btn_skip_call_cancel_2");
			}
		}
	}
	
	/**
	 * [Add Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallControl(sheetObj, rowData){
		var formObj = document.form;
		var sRow = sheetObj.SelectRow;
		var prefix = sheetObj.id + "_";
		
		var pos = rowData.position;
		
		sheetObj.Redraw = false;

		var isColHidden = true;
		if(sheetObj.id == "sheet1"){
			isColHidden = sheetObj.ColHidden(prefix+"lnk_dist");
		}else{
			isColHidden = sheetObj.ColHidden(prefix+"ib_cgo_qty");
		}

		if(pos == "before"){
			if(sheetObj.CellValue(sRow, prefix+"bfr_act_flg") == "X" || sheetObj.CellValue(sRow, prefix+"act_inp_flg") == "Y"){
				//Actual Schedule이 입력되었기 때문에 해당위치에는 Add Calling을 할 수 없습니다.
				ComShowCodeMessage("VSK00081");
				sheetObj.Redraw = true;
				return false;
			}
			
			//선택한 Row 이전에 ADD
			sheetObj.DataInsert(sRow-1);
			// Color Setting.
			sheetObj.RowBackColor(sRow) = sheetObj.RowBackColor(sRow+1);
	
			sheetObj.CellValue2(sRow, prefix+"vvd") = sheetObj.CellValue(sRow+1, prefix+"vvd");
			sheetObj.CellValue2(sRow, prefix+"vsl_cd") = sheetObj.CellValue(sRow+1, prefix+"vsl_cd");
			sheetObj.CellValue2(sRow, prefix+"skd_voy_no") = sheetObj.CellValue(sRow+1, prefix+"skd_voy_no");
			sheetObj.CellValue2(sRow, prefix+"skd_dir_cd") = sheetObj.CellValue(sRow+1, prefix+"skd_dir_cd");
			sheetObj.CellValue2(sRow, prefix+"vsl_slan_cd") = sheetObj.CellValue(sRow+1, prefix+"vsl_slan_cd");
			sheetObj.CellValue2(sRow, prefix+"slan_cd") = sheetObj.CellValue(sRow+1, prefix+"vsl_slan_cd");
				
			sheetObj.CellValue2(sRow, prefix+"vps_port_cd") = rowData.port_cd;
// 			Pop-up 미구현(YD_CD, ETA 추후 추가)
// 			sheetObj.CellValue2(sRow, prefix+"tml_cd") = rowData.yard_cd;
 			sheetObj.CellValue2(sRow, prefix+"vps_eta_dt") = rowData.eta;
			sheetObj.CellValue2(sRow, prefix+"vps_etb_dt") = rowData.etb;
			sheetObj.CellValue2(sRow, prefix+"vps_etd_dt") = rowData.etd;
			sheetObj.CellValue2(sRow, prefix+"init_eta_dt") = rowData.eta;
			sheetObj.CellValue2(sRow, prefix+"init_etb_dt") = rowData.etb;
			sheetObj.CellValue2(sRow, prefix+"init_etd_dt") = rowData.etd;
			
			// port_time
			var dateObj = new Usr_CalcTimeSet(rowData.etb);
			var timeDiff = parseInt(dateObj.getTimeDiff(rowData.etd), 10);
			sheetObj.CellValue2(sRow, prefix+"act_wrk_hrs") = timeDiff;
			if(rowData.turn_ind == "0"){
				sheetObj.CellValue(sRow, prefix+"turn_port_flg") = "Y";
			}
			
			formObj.loc_cd.value = rowData.port_cd;
			formObj.yd_cd.value = rowData.yard_cd;
// 			***********************************************************
			var sXml = doCallBaseInfo(sheetObj, sRow, "ADD");
// 			***********************************************************
			
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "A";
			 
			sheetObj.SelectCell(sRow, sheetObj.SelectCol);
			
			addcallVVDYard = sheetObj.CellValue(sRow+1, prefix+"vvd") + rowData.port_cd; 
//			alert(addcallVVDYard);
			
			// Dist 및 Sea Time을 새로 셋팅함. 
			if(sXml != null && sXml != undefined && sXml != ""){
				if(isColHidden == false){
					setBaseInfo(sheetObj, sXml, sRow, "ADD");
				}
			}
		}else{
			//선택한 Row 이후에 ADD
			sheetObj.DataInsert(sRow);
			// Color Setting.
			sheetObj.RowBackColor(sRow+1) = sheetObj.RowBackColor(sRow);
			
			sheetObj.CellValue2(sRow+1, prefix+"vvd") = sheetObj.CellValue(sRow, prefix+"vvd");
			sheetObj.CellValue2(sRow+1, prefix+"vsl_cd") = sheetObj.CellValue(sRow, prefix+"vsl_cd");
			sheetObj.CellValue2(sRow+1, prefix+"skd_voy_no") = sheetObj.CellValue(sRow, prefix+"skd_voy_no");
			sheetObj.CellValue2(sRow+1, prefix+"skd_dir_cd") = sheetObj.CellValue(sRow, prefix+"skd_dir_cd");
			sheetObj.CellValue2(sRow+1, prefix+"vsl_slan_cd") = sheetObj.CellValue(sRow, prefix+"vsl_slan_cd");
			sheetObj.CellValue2(sRow+1, prefix+"slan_cd") = sheetObj.CellValue(sRow, prefix+"vsl_slan_cd");
				
			sheetObj.CellValue2(sRow+1, prefix+"vps_port_cd") = rowData.port_cd;
// 			Pop-up 미구현(YD_CD, ETA 추후 추가)
// 			sheetObj.CellValue2(sRow+1, prefix+"tml_cd") = rowData.yard_cd;
 			sheetObj.CellValue2(sRow+1, prefix+"vps_eta_dt") = rowData.eta;
			sheetObj.CellValue2(sRow+1, prefix+"vps_etb_dt") = rowData.etb;
			sheetObj.CellValue2(sRow+1, prefix+"vps_etd_dt") = rowData.etd;
			sheetObj.CellValue2(sRow+1, prefix+"init_eta_dt") = rowData.eta;
			sheetObj.CellValue2(sRow+1, prefix+"init_etb_dt") = rowData.etb;
			sheetObj.CellValue2(sRow+1, prefix+"init_etd_dt") = rowData.etd;

			// port_time(ETD - ETB)
			var dateObj = new Usr_CalcTimeSet(rowData.etb);
			var timeDiff = parseInt(dateObj.getTimeDiff(rowData.etd), 10);
			sheetObj.CellValue2(sRow+1, prefix+"act_wrk_hrs") = timeDiff;
			if(rowData.turn_ind == "0"){
				sheetObj.CellValue(sRow+1, prefix+"turn_port_flg") = "Y";
			}
			
			formObj.loc_cd.value = rowData.port_cd;
			formObj.yd_cd.value = rowData.yard_cd;
// 			***********************************************************
			var sXml = doCallBaseInfo(sheetObj, sRow+1, "ADD");
// 			***********************************************************
			
			sheetObj.CellValue2(sRow+1, prefix+"skd_cng_sts_cd") = "A";
			
			sheetObj.SelectCell(sRow+1, sheetObj.SelectCol);
			
			addcallVVDYard = sheetObj.CellValue(sRow, prefix+"vvd") + rowData.port_cd; 
//			alert(addcallVVDYard);
			
			// Dist 및 Sea Time을 새로 셋팅함.
			if(sXml != null && sXml != undefined && sXml != ""){
				if(isColHidden == false){
					setBaseInfo(sheetObj, sXml, sRow+1, "ADD");
				}
			}
		}
		sheetObj.Redraw = true;
		
		resetClptSeq(sheetObj);		// clpt_seq 새로 부여.
		resetClptIndSeq(sheetObj);	// clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
		initPortDataFlg(sheetObj);	// Terminal 재조회 Flag 초기화.
		
		if(sheetObj.id == "sheet1"){
			ComBtnEnable("btn_add_call_cancel_1");
		}else{
			ComBtnEnable("btn_add_call_cancel_2");
		}
	}
	
	/**
	 * [Add Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallCancel(sheetObj){
		var sRow = sheetObj.SelectRow;
		var prefix = sheetObj.id + "_";
		
		if(sheetObj.CellValue(sRow, prefix+"skd_cng_sts_cd") == "A"){
//		if(sheetObj.CellValue(sRow, prefix+"ibflag") == "I"){
			var isColHidden = true;
			if(sheetObj.id == "sheet1"){
				isColHidden = sheetObj.ColHidden(prefix+"lnk_dist");
			}else{
				isColHidden = sheetObj.ColHidden(prefix+"ib_cgo_qty");
			}
			
			var sXml = doCallBaseInfo(sheetObj, sRow, "ADD_CANCEL");
			
			sheetObj.Redraw = false;
			
			if(isColHidden == false){
				//Dist 및 Sea Time을 새로 셋팅함.
				setBaseInfo(sheetObj, sXml, sRow, "ADD_CANCEL");
			}
			
//			if(sheetObj.CellValue(sRow, prefix+"ibflag") == "I"){
			if(sheetObj.RowStatus(sRow) == "I"){
				// 서버에 반영안된 Add 건들은 삭제
				sheetObj.RowDelete(sRow, false);
			}else{
				// 서버에 반영되어 있는 건들은 서버데이타 삭제하기위해 Hidden 처리
//				sheetObj.CellValue2(sRow, prefix+"ibflag") = "D";
				sheetObj.RowStatus(sRow) = "D";
				sheetObj.RowHidden(sRow) = true;
			}
			
			// clpt_seq 새로 부여.
			resetClptSeq(sheetObj);
			// clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
			resetClptIndSeq(sheetObj);
			// Terminal 재조회 Flag 초기화.
			initPortDataFlg(sheetObj);
			
			sheetObj.Redraw = true;
		}
		
		if(sheetObj.id == "sheet1"){
			ComBtnDisable("btn_add_call_cancel_1");
		}else{
			ComBtnDisable("btn_add_call_cancel_2");
		}
	}
	
	/**
	 * [Reverse Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function reverseCallControl(sheetObj){
		
		if(!rowDataChange(sheetObj)){
			return false;
		}
		
		if(sheetObj.id == "sheet1"){
			ComBtnDisable("btn_reverse_call_1");
		}else{
			ComBtnDisable("btn_reverse_call_2");
		}
	}
	
	/**
	 * [Reverse Call Change] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function reverseCallChange(sheetObj){
		
		if(!rowDataChange(sheetObj)){
			return false;
		}
		
//		if(sheetObj.id == "sheet1"){
//			ComBtnDisable("btn_reverse_call_cancel_1");
// 		}else{
// 			ComBtnDisable("btn_reverse_call_cancel_2");
// 		}
	}
	
	/**
	 * [Phase Out] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function phaseOutControl(sheetObj){
		var prefix = sheetObj.id + "_";
		var sRow = sheetObj.SelectRow;
		var headRow = sheetObj.HeaderRows;
		var totCnt = getTotalRowCnt(sheetObj);
		
		for(var i=sRow+1; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"tmp_phase_flag") != "H"){
				sheetObj.CellValue2(i, prefix+"tmp_phase_flag") = "H";
// 				sheetObj.CellValue2(i, prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(i,
// 				prefix+"skd_cng_sts_cd");
// 				sheetObj.CellValue2(i, prefix+"skd_cng_sts_cd") = "O";
				
				// Pop-up 에서 받아온 데이타
				sheetObj.CellValue2(i, prefix+"cng_lane_cd") = "";
				sheetObj.CellValue2(i, prefix+"cng_vsl_cd") = "";
				sheetObj.CellValue2(i, prefix+"cng_skd_voy_no") = "";
				sheetObj.CellValue2(i, prefix+"cng_skd_dir_cd") = "";
				
				sheetObj.RowHidden(i) = true;
			}
		}
		
		sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "O";
		sheetObj.CellValue2(sRow, prefix+"lnk_dist") = "0"; // Phase Out 이후 distance는 0
		
		if(sheetObj.id == "sheet1"){
			ComBtnDisable("btn_p_out_1");
			ComBtnEnable("btn_p_out_cancel_1");
		}else{
			ComBtnDisable("btn_p_out_2");
			ComBtnEnable("btn_p_out_cancel_2");
		}
	}
	
	/**
	 * [Phase Out Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function phaseOutCancelControl(sheetObj, formObj){
		var prefix = sheetObj.id + "_";
		var sRow = sheetObj.SelectRow;
		var headRow = sheetObj.HeaderRows;
		var totCnt = getTotalRowCnt(sheetObj);
		var isSvrFlg = true;
		
		sheetObj.CellValue2(sRow, prefix+"phs_io_rsn_cd") = "";
		sheetObj.CellValue2(sRow, prefix+"phs_io_rmk") = "";
		sheetObj.CellValue2(sRow, prefix+"lnk_dist") = sheetObj.CellValue(sRow, prefix+"pf_lnk_dist"); // Phase Out시 0으로 초기화 되었던 distance를 P/F 값으로 복귀 
		sheetObj.CellValue2(sRow, prefix+"port_skp_tp_cd") = "";
		
		for(var i=sRow+1; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"tmp_phase_flag") == "H" && sheetObj.RowHidden(i)){
				isSvrFlg = false;
				
				// 이전의 Port가 이전의 Phase Out 인 상태 제거.
				// 이전의 Port로 점검하는 이유는 서버에 반영된 Phase Out 과 구분하기 위해.
				if(sheetObj.CellValue(i-1, prefix+"skd_cng_sts_cd") == "O"){
					sheetObj.CellValue(i-1, prefix+"skd_cng_sts_cd") = "";
				}
				
//				sheetObj.CellValue2(i, prefix+"tmp_phase_flag") = "";
// 				sheetObj.CellValue2(i, prefix+"skd_cng_sts_cd") = sheetObj.CellValue(i, prefix+"tmp_cng_sts_cd");
				
				// Pop-up 에서 받아온 데이타
				sheetObj.CellValue2(i, prefix+"cng_lane_cd") = "";
				sheetObj.CellValue2(i, prefix+"cng_vsl_cd") = "";
				sheetObj.CellValue2(i, prefix+"cng_skd_voy_no") = "";
				sheetObj.CellValue2(i, prefix+"cng_skd_dir_cd") = "";
				
				
				sheetObj.RowHidden(i) = false;
			}
		}
		
		//서버에 반영된 Phase Out을 Cancel 시킬 경우.
		if(isSvrFlg){
//			formObj.vsl_slan_cd.value = rtnDatas[1];		// vsl_slan_cd
// 			formObj.pf_svc_tp_cd.value = ; 					//pf_svc_tp_cd
// 			formObj.vps_port_cd.value = rtnDatas[4]; 		//port_cd
// 			formObj.skd_dir_cd.value = rtnDatas[5]; 		//skd_dir_cd
// 			formObj.vsl_slan_dir_cd.value = rtnDatas[5];	//skd_dir_cd
// 			formObj.vps_etb_dt.value = ComReplaceStr(rtnDatas[7],"-","");
//			var sAction = SEARCH08;
//			if(sheetObj.id == "sheet2") sAction = SEARCH09;
			
//			var sXml = doActionIBSheet(sheetObj, formObj, sAction);
//			if(sXml != null){
//				var rootNode = VskGetXmlRootNode(sXml);
//				var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
//				if(dataNode){
//					var totValue = dataNode.value;
//
//					if(totValue > 0){
//						sheetObj.Redraw = false;
//						if(sheetObj.id == "sheet1"){
//							sheetObj.LoadSearchXml(sXml, true, totCnt+1);
//						}else{
//							sheetObj.LoadSearchXml(sXml, true, totCnt);
//						}
//						initPortDataFlg(sheetObj);
//						// clpt_seq 새로 부여.
//						resetClptSeq(sheetObj);
//						// clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
//						resetClptIndSeq(sheetObj);
//			
//			    		var ydCds = ComGetEtcData(sXml, "tml_cd").split("|");
//			    		var ydIdx = 0;
//				    	for(var i=sRow+1; i <= sheetObj.LastRow; i++) {
////				    		if(sheetObj.CellValue(i, prefix+"clpt_seq") != "TOTAL"){
//					    		sheetObj.CellComboItem(i, prefix+"tml_cd", ydCds[ydIdx], ydCds[ydIdx]);
////					    		sheetObj.CellValue2(i, prefix+"ibflag") = "I";
//					    		sheetObj.RowStatus(i) = "I";
//					    		ydIdx++;
//// 							}
//				    	}
//						
//						sheetObj.Redraw = true;
//						
//						sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "";
//						sheetObj.CellValue2(sRow, prefix+"port_skp_tp_cd") = "";
//						sheetObj.CellValue2(sRow, prefix+"phs_io_rsn_cd") = "";
//						sheetObj.CellValue2(sRow, prefix+"phs_io_rsn_cd") = "";
//						
//						if(sheetObj.id == "sheet1"){
//							ComBtnDisable("btn_p_out_cancel_1");
//							ComBtnEnable("btn_p_out_1");
//						}else{
//							ComBtnDisable("btn_p_out_cancel_2");
//							ComBtnEnable("btn_p_out_2");
//						}
//					}else{
//						// do not!
//					}
					
					
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"port_skp_tp_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"phs_io_rsn_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"phs_io_rmk") = "";
			
			if(sheetObj.id == "sheet1"){
				ComBtnDisable("btn_p_out_cancel_1");
				ComBtnEnable("btn_p_out_1");
			}else{
				ComBtnDisable("btn_p_out_cancel_2");
				ComBtnEnable("btn_p_out_2");
			}
		}
	}

    
    /**
     * [Expand]/[Hidden] Button Event
     * @param sheetObj
     * @param showFlg	true: 화면에 표시, false: 화면에서 숨김.
     * @return
     */
    function showFieldControl(sheetObj, formObj, showFlg){
    	var prefix = sheetObj.id + "_";
		if(sheetObj.id == "sheet1"){
	    	if(showFlg){
	    		//숨겨진 필드를 보여줌.
	    		btn2ControlHtml("div_col_show", "btn_col_show", "Expand >>", "btn2_1", "120");	// disabled
	    		document.getElementById("div_col_show").style.display = "none";
	    		btn2ControlHtml("div_col_hide", "btn_col_hide", "Hidden <<", "btn2_2", "120");	// un_disabled
	    		document.getElementById("div_col_hide").style.display = "Inline";
	    		if(sheetObj.ColHidden(prefix+"lnk_dist")){
	    			colHiddenControl(sheetObj, false);
	    		}
	    	} else {
	    		//필드 감춤.
	    		btn2ControlHtml("div_col_show", "btn_col_show", "Expand >>", "btn2_2", "120");	// un_disabled
	    		document.getElementById("div_col_show").style.display = "Inline";
	    		btn2ControlHtml("div_col_hide", "btn_col_hide", "Hidden <<", "btn2_1", "120");	// disabled
	    		document.getElementById("div_col_hide").style.display = "none";
	    		if(!sheetObj.ColHidden(prefix+"lnk_dist")){
	    			colHiddenControl(sheetObj, true);
	    		}
	    	}
		} else {
	    	if(showFlg){
	    		//숨겨진 필드를 보여줌.
	    		btn2ControlHtml("div_plan_col_show", "btn_plan_col_show", "Expand >>", "btn2_1", "120");	// disabled
	    		btn2ControlHtml("div_plan_col_hide", "btn_plan_col_hide", "Hidden <<", "btn2_2", "120");	// un_disabled
	    		if(sheetObj.ColHidden(prefix+"ib_cgo_qty")){
	    			colHiddenControl(sheetObj, false);
	    		}
	    	} else {
	    		//필드 감춤.
	    		btn2ControlHtml("div_plan_col_show", "btn_plan_col_show", "Expand >>", "btn2_2", "120");	// un_disabled
	    		btn2ControlHtml("div_plan_col_hide", "btn_plan_col_hide", "Hidden <<", "btn2_1", "120");	// disabled
	    		if(!sheetObj.ColHidden(prefix+"ib_cgo_qty")){
	    			colHiddenControl(sheetObj, true);
	    		}
	    	}
		}
    }
    
    /**
     * [Expand]/[Hidden] Button Control 의 상세 내용 기술.
     * @param sheetObj
     * @param bFlg		Hidden 구분: true : Hidden, false : Block
     * @return
     */
    function colHiddenControl(sheetObj, bFlg){
    	var prefix = sheetObj.id + "_";
    	if(sheetObj.id == "sheet1"){
	    	with(sheetObj){
				ColHidden(prefix+"lnk_dist") = bFlg;
				ColHidden(prefix+"lnk_spd") = bFlg;
				ColHidden(prefix+"tztm_hrs") = bFlg;
				ColHidden(prefix+"act_wrk_hrs") = bFlg;
				ColHidden(prefix+"port_buf_hrs") = bFlg;
				ColHidden(prefix+"sea_buf_hrs") = bFlg;
	    	}
    	}else{
	    	with(sheetObj){
    			ColHidden(prefix+"act_wrk_hrs") = bFlg;
    			ColHidden(prefix+"ib_cgo_qty") = bFlg;
    			ColHidden(prefix+"ob_cgo_qty") = bFlg;
    			ColHidden(prefix+"crn_knt") = bFlg;
    			ColHidden(prefix+"tml_prod_qty") = bFlg;
    			ColHidden(prefix+"add_bnk_csm_qty") = bFlg;
    			ColHidden(prefix+"add_bnk_cost_amt") = bFlg;
// 				ColHidden(prefix+"ts_20ft_ttl_qty") = bFlg;
// 				ColHidden(prefix+"ts_40ft_ttl_qty") = bFlg;
// 				ColHidden(prefix+"ts_20ft_ttl_amt") = bFlg;
// 				ColHidden(prefix+"ts_40ft_ttl_amt") = bFlg;
    			ColHidden(prefix+"tml_hndl_20ft_ttl_qty") = bFlg;
    			ColHidden(prefix+"tml_hndl_40ft_ttl_qty") = bFlg;
    			ColHidden(prefix+"tml_hndl_20ft_ttl_amt") = bFlg;
    			ColHidden(prefix+"tml_hndl_40ft_ttl_amt") = bFlg;
    			ColHidden(prefix+"pe_usd_ttl_amt") = bFlg;
    			ColHidden(prefix+"total_cost") = bFlg;
	    	}
    	}
    }
    
	
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
    
	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 처리.
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj = document.form;
    	
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value = rtnDatas[1];
					
					Usr_setVslCd(formObj.vsl_cd.value);
					
					var sheetObj = sheetObjects[0];
					if(glbSheetFlg == "sheet2"){
						sheetObj = sheetObjects[1];
					}
					if(formObj.sim_dt.value == "" && sheetObj.RowCount > 0){
	            		resetAllData(sheetObj, formObj);
	            	}
				}
			}
    	}
    }

    /**
     * VVD Code Help (Pop-Up)에서 받은 데이타 처리.
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj = document.form;
		
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value = rtnDatas[2];
					formObj.skd_dir_cd.value = rtnDatas[3];
					
					Usr_setSkdVoyNo(formObj.skd_voy_no.value);
					Usr_setSkdDirCd(formObj.skd_dir_cd.value);
					
					var sheetObj = sheetObjects[0];
					if(glbSheetFlg == "sheet2"){
						sheetObj = sheetObjects[1];
					}
					if(formObj.sim_dt.value == "" && sheetObj.RowCount > 0){
	            		resetAllData(sheetObj, formObj);
	            	}
				}
			}
    	}
    }
	
	/**
	 * Simulation No. Help (Pop-Up)에서 받은 데이타 처리.
	 * @param rtnObjs
	 * @return
	 */
	function returnSimNoHelp(rtnObjs){
		var formObj = document.form;
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					var simNo = rtnDatas[4];
					if(simNo != null && simNo != undefined != simNo != ""){
						clearAllData(sheetObjects[1], formObj);
						clearAllData(sheetObjects[3], formObj);
						
						formObj.sim_dt.value = simNo.substring(0,10);
						formObj.sim_no.value = simNo.substring(11);
					
						Usr_setSimDt(formObj.sim_dt.value);
						Usr_setSimNo(formObj.sim_no.value);
					}
				}
			}
		}
	}
	
	/**
	 * Port Skip Recorder for Statistics (Pop-Up)에서 받은 데이타 처리.
	 * [Skip Call] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnSkipCallHelp(rtnObjs){
		if(rtnObjs.length > 0){
			var formObj = document.form;
			var sheetObj = null;
			if(glbSheetFlg == "sheet1"){
				sheetObj = sheetObjects[0];
			}else{
				sheetObj = sheetObjects[1];
			}
			var prefix = sheetObj.id+"_";
			var headCnt = sheetObj.headerRows;
			var totCnt = getTotalRowCnt(sheetObj);
			var currRow = 0;
			var idx = 0;
			
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S" || i == sheetObj.SelectRow){
					var rtnDatas = rtnObjs[idx];
					if(rtnDatas != null && rtnDatas != undefined && rtnDatas.length > 0){
						sheetObj.CellValue2(i, prefix+"ts_port_cd") = rtnDatas[15];				// ts_port_cd
						sheetObj.CellValue2(i, prefix+"usd_flg") = rtnDatas[4];					// Report(DB:USD_FLG)
						sheetObj.CellValue2(i, prefix+"port_skp_tp_cd") = rtnDatas[6];			// Force Majeure(DB:PORT_SKP_TP_CD)
						sheetObj.CellValue2(i, prefix+"port_skp_rsn_offr_rmk") = rtnDatas[19];	// rsn_port_cd
						sheetObj.CellValue2(i, prefix+"port_skp_rsn_cd") = rtnDatas[8];			// 
						sheetObj.CellValue2(i, prefix+"ttl_dlay_hrs") = rtnDatas[9];			// Hours(DB:TTL_DLAY_HRS)
						sheetObj.CellValue2(i, prefix+"vps_rmk") = rtnDatas[11];					// vps_rmk
						
						sheetObj.CellValue2(i, prefix+"ts_skd_voy_no") = rtnDatas[16];			// ts_skd_voy_no
						sheetObj.CellValue2(i, prefix+"ts_skd_dir_cd") = rtnDatas[17];			// ts_skd_dir_cd
						sheetObj.CellValue2(i, prefix+"ts_clpt_ind_seq") = rtnDatas[18];		// ts_clpt_ind_seq
						sheetObj.CellValue2(i, prefix+"rsn_skd_voy_no") = rtnDatas[20];			// rsn_skd_voy_no
						sheetObj.CellValue2(i, prefix+"rsn_skd_dir_cd") = rtnDatas[21];			// rsn_skd_dir_cd
						sheetObj.CellValue2(i, prefix+"rsn_clpt_ind_seq") = rtnDatas[22];		// rsn_clpt_ind_seq
					}
					idx++;
				}
			} //end for
			
			skipCallControl(sheetObj);
		}
	}
	
	/**
	 * [Add Call] Button Click 후 Pop-up 실행 후 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnAddCallHelp(sheetObj, rtnObj){
		if(rtnObj){
			addCallControl(sheetObj, rtnObj);
		}
	}
	
//	/**
// 	 * [Phase In Call] Button Click 후 Pop-up에서 호출.
//	 * @param rtnObjs
//	 * @return
//	 */
//	function returnPhaseInHelp(rtnObjs){
//		var formObj = document.form;
//		var sheetObj = null;
//		
//		if(rtnObjs){
//			var rtnDatas = rtnObjs[0];
//			if(rtnDatas){
//				if(rtnDatas.length > 0){
////					formObj.sim_dt.value = rtnDatas[1];
////					formObj.sim_no.value = rtnDatas[2];
////					
////					Usr_setSimDt(formObj.sim_dt.value);
////					Usr_setSimNo(formObj.sim_no.value);
//
//					if(glbSheetFlg == "sheet1"){
//						sheetObj = sheetObjects[0];
//					}else{
//						sheetObj = sheetObjects[1];
//					}
//					phaseInControl(sheetObj);
//				}
//			}
//		}
//	}
	

	
	/**
	 * [Phase Out Call] Button Click 후 Pop-up에서 호출.
	 * @param rtnObj
	 * @return
	 */
	function returnPhaseOutHelp(sheetObj, Row, rtnObj){
		var formObj = document.form;
		var prefix = sheetObj.id + "_";
		if(rtnObj){
			sheetObj.CellValue2(Row, prefix+"phs_io_rsn_cd") = rtnObj.phs_io_rsn_cd;
			sheetObj.CellValue2(Row, prefix+"phs_io_rmk") = rtnObj.phs_io_rmk;
			sheetObj.CellValue2(Row, prefix+"port_skp_tp_cd") = rtnObj.port_skp_tp_cd;
//			if(glbSheetFlg == "sheet1"){
//				sheetObj = sheetObjects[0];
//			}else{
//				sheetObj = sheetObjects[1];
//			}
			phaseOutControl(sheetObj);
		}
	}
	
    /**
     * [New] Button Event : 화면을 초기화 한다.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	if(glbSheetFlg == "sheet1"){
			glbSheet1FormData = new Usr_Coni_FormData();
			glbSheet1FormData.setAllFormData();
			
			getComboObject("remark").RemoveAll();
		} else {
    		glbSheet2FormData = new Usr_Coni_FormData();
    		glbSheet2FormData.setAllFormData();
		}
    	
    	sheetObj.RemoveAll();
    	sheetObjects[3].RemoveAll();

    	
    	showFieldControl(sheetObj, formObj, false);
    	
    	initButton(sheetObj);
    	
    	formObj.vsl_cd.focus();
    }
	
	/**
	 * [Loadable Weight] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnLoadableHelp(rtnObjs){
		// do not
	}
    
    /**
     * [Reverse Call] Button Disabled Control...
     * @param sheetObj
     * @return
     */
    function btnReverseCallControl(sheetObj){
		var strSelRow = sheetObj.GetSelectionRows("|");
		var btnName = "";
		var btnChgName = "";
		
		if(sheetObj.id == "sheet1"){
			btnName = "btn_reverse_call_1";
// 			btnChgName = "btn_reverse_call_cancel_1";
    	}else{
			btnName = "btn_reverse_call_2";
// 			btnChgName = "btn_reverse_call_cancel_2";
    	}
		
		if(strSelRow != null && strSelRow != undefined && strSelRow != ""){
			var selRows = strSelRow.split("|");
			if(selRows.length == 2){
				var formObj = document.form;
				var prefix = sheetObj.id + "_";
				
				// port_skd_sts_cd 의 값이 A, B, D 중 하나라도 들어오면 Reverse 안됨.
				if(isSkipBtnSts(sheetObj, selRows[0]) && isSkipBtnSts(sheetObj, selRows[1])){
					var vvd1 = sheetObj.CellValue(selRows[0], prefix+"vvd");
					var vvd2 = sheetObj.CellValue(selRows[1], prefix+"vvd");
					
					// vvd가 다르면 Reverse 안됨.
					if(vvd1 == vvd2){
						ComBtnEnable(btnName);
//						var cellVal1 = sheetObj.CellValue(selRows[0], prefix+"skd_cng_sts_cd");
//						var cellVal2 = sheetObj.CellValue(selRows[1], prefix+"skd_cng_sts_cd");
//						
//						if(cellVal1 != "R" && cellVal2 != "R"){
//							ComBtnEnable(btnName);
//						}else if(cellVal1 == "R" && cellVal2 == "R"){
//							ComBtnDisable(btnName);
//							ComBtnEnable(btnChgName);
//						}else{
//							ComBtnDisable(btnName);
//							ComBtnDisable(btnChgName);
//						}
					}else{
						ComBtnDisable(btnName);
// 						ComBtnDisable(btnChgName);
					}
				}else{
					ComBtnDisable(btnName);
// 					ComBtnDisable(btnChgName);
				}
			}else{
				ComBtnDisable(btnName);
// 				ComBtnDisable(btnChgName);
			}
		}else{
			ComBtnDisable(btnName);
// 			ComBtnDisable(btnChgName);
		}
    }
	
	/*
	 * =====================================================================
	 * Data Control
	 * =====================================================================
	 */
    
    /**
	 * Turnning Port의 Direction Code 목록을 Setting.
	 * @param sheetObj
	 * @return
	 */
    function initLoadDirection(){
    	var sheetCnt = sheetObjects.length;

   		if(sheetCnt > 0){
    		for(var i=0; i<sheetCnt; i++){
    			var sheetObj 	= sheetObjects[i];
		    	var prefix 		= sheetObj.id + "_";
		    	var sXml 		= doActionIBSheet(sheetObj, document.form, SEARCH07);
		    	
		    	var sDirCds 	= ComGetEtcData(sXml, "direction_cd");
		    	
		    	if(sheetObj.id == "sheet1" || sheetObj.id == "sheet2"){
		    		sheetObj.InitDataCombo(0, prefix+"turn_skd_dir_cd", sDirCds, sDirCds, "", " ");
		    	}
    		}
    	}
    }
    
    /**
     * Terminal 재조회 방지위한 초기 데이타 처리.
     * @param sheetObj
     * @return
     */
    function initPortDataFlg(sheetObj){ 
    	var rows = sheetObj.Rows;
    	var headCnt = sheetObj.HeaderRows;
    	
    	for(var i=headCnt; i<rows; i++){
    		if(glbSheetFlg == "sheet1"){
    			glbSkdPortFlgs[i-headCnt] = "N";
    		}else{
    			glbPlanPortFlgs[i-headCnt] = "N";
    		}
    	}
    }
    
    /**
     * SKIP CALL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipBtnSts(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
    	// Virtual Port Add Call 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.CellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		// CHM-201110591-01 적용으로 주석 처리. 2011-05-19
		// 시작 -->>
//		//Actual 이 들어온 이전 Port 모두 막음.
//		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
//			return false;
//		}
		// <<-- 끝
		
		//Skip 이 되어 있는 Port 막음.
		if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
			return false;
		}
		
		return true;
    }
    
    /**
     * SKIP CALL CANCEL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipCancelBtnSts(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
    	// Virtual Port Add Call 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.CellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		// CHM-201110591-01 적용으로 주석 처리. 2011-05-19
		// 시작 -->>
//		//Actual 이 들어온 이전 Port 모두 막음.
//		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
//			return false;
//		}
		// <<-- 끝
		
		
		//Skip 이 되어 있는 Port 막음.
		if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
			return true;
		}
		
		return false;
    }
    
    /**
     * ADD CALL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isAddBtnSts(sheetObj, Row){
		var prefix = sheetObj.id + "_";
		
		// Virtual Port Add Call 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			if(Row != sheetObj.LastRow){
				return false;
			}
		}
		
		/*
		 * 마지막 Actual 이후에 Add Call 이 가능(단 해당 Port 가 Virtual 이면 막음).
		 * 마지막 Actual 에서 Add Call 할 경우 Add Call Pop-up 에서 before 는 막혀있고 after 만 가능하게 처리.
		 */
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		var actInpFlg = sheetObj.CellValue(Row, prefix+"act_inp_flg");

		//Actual 이 들어온 이전 Port 모두 막음.
		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}else if(portSts == "A" || portSts == "B" || portSts == "D" || actInpFlg == "Y"){
			// Actual 일 경우(마지막 Actual 일 경우) 해당 Port 가 Virtual 이면 막음(2010.04.07 김기원차장).
			var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				return false;
			}
		}
		
		return true;
    }
    
    /**
     * ADD CALL CANCEL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isAddCancelBtnSts(sheetObj, Row){
		var prefix = sheetObj.id + "_";
		
		// Virtual Port 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			if(Row != sheetObj.LastRow){
				return false;
			}
		}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.CellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}

		//Actual 이 들어온 이전 Port 모두 막음.
		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		
		if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "A"){
			return true;
		}
		
		return false;
    }
    
    /**
     * PhaseOut CALL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPhaseOutBtnSts(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
    	// Virtual Port 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.CellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		//Actual 이 들어온 이전 Port 모두 막음.
		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		
		//PhaseOut 이 되어 있는 Port 막음.
		if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "O"){
			return false;
		}
		
		//마지막 Row 는 Phase Out 막음.
//		if(sheetObj.LastRow == Row){
//			return false;
//		}
		
		return true;
    }
    
    /**
     * PhaseOut Cancel CALL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPhaseOutCancelBtnSts(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
    	// Virtual Port 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.CellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		//Actual 이 들어온 이전 Port 모두 막음.
		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		
		//PhaseOut 이 되어 있는 Port 막음.
		if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "O"){
			return true;
		}
		
		return false;
    }
    
    /**
     * Add Call 시 position(befor or after) flag 설정.
     * @param sheetObj
     * @return
     */
    function isAddPositionFlag(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var sRow = sheetObj.SelectRow;
    	
    	if(sheetObj.LastRow == sRow){
    		//Virtual Port Add Call 막음.
			var turnPortSts = sheetObj.CellValue(sRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts = sheetObj.CellValue(sRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
			}
    	}else{
    		//Virtual Port Add Call 막음.
    		var turnPortSts = sheetObj.CellValue(sRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts = sheetObj.CellValue(sRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
				
				var afTurnPortSts = sheetObj.CellValue(sRow+1, prefix+"turn_port_ind_cd");
				if(afTurnPortSts == "F" || afTurnPortSts == "V" || afTurnPortSts == "D"){
					return "A";
				}
			}
    	}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(sRow, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return "B";
		}else if(sheetObj.CellValue(sRow, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
//		// Actual 이 들어온 이전 Port 모두 막음.
//		if(sheetObj.CellValue(sRow, prefix+"bfr_act_flg") == "X"){
//			return "B";
//		}
		return "";
    }
    
    /**
     * 스케줄 생성하기 위한 기본정보 조회
     * @param sheetObj
     * @param sRow
     * @param evtFlg
     * @param eRow
     * @return
     */
    function doCallBaseInfo(sheetObj, sRow, evtFlg, eRow){
    	var formObj = document.form;
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt = getTotalRowCnt(sheetObj);
    	var sXml = null;
    	
    	if(evtFlg == "SKIP"){
    		if(sRow > headCnt){
    			var startRow = getNotSkipRow(sheetObj, sRow, "P");
    			var endRow = getNotSkipRow(sheetObj, sRow, "N");
    			if(startRow > 0 && endRow > 0){
    				formObj.yd_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd") + sheetObj.CellValue(sRow, prefix+"tml_cd");
    				formObj.vps_eta_dt.value = sheetObj.CellValue(sRow, prefix+"vps_eta_dt");
    				formObj.fm_loc_cd.value = sheetObj.CellValue(startRow, prefix+"vps_port_cd");
    				formObj.to_loc_cd.value = sheetObj.CellValue(endRow, prefix+"vps_port_cd");
    				
    				sXml = doActionIBSheet(sheetObj, formObj, SEARCH11);
    			}
    		}
    	}else if(evtFlg == "SKIP_CANCEL"){
    		if(sRow > headCnt){
    			var startRow = getNotSkipRow(sheetObj, sRow, "P");
    			if(startRow > 0){
    				formObj.fm_loc_cd.value = sheetObj.CellValue(startRow, prefix+"vps_port_cd");
        			formObj.to_loc_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
        			
        			sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
    			}
    		}
    		
    	}else if(evtFlg == "ADD"){
    		//Dist 조회
    		var portCd = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
    		
    		if(portCd != null && portCd != undefined && portCd != ""){
				if(sRow > headCnt && sRow < totCnt-1){
					var startRow = getNotSkipRow(sheetObj, sRow, "P");
					var endRow = getNotSkipRow(sheetObj, sRow, "N");
	    			if(startRow > 0 && endRow > 0){
						var fmLocCd = sheetObj.CellValue(startRow, prefix+"vps_port_cd");
						fmLocCd = fmLocCd + "|" + sheetObj.CellValue(sRow, prefix+"vps_port_cd");
						var toLocCd = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
						toLocCd = toLocCd + "|" + sheetObj.CellValue(endRow, prefix+"vps_port_cd");
						
						formObj.fm_loc_cd.value = fmLocCd;
						formObj.to_loc_cd.value = toLocCd;
						formObj.loc_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
						formObj.yd_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd") + sheetObj.CellValue(sRow, prefix+"tml_cd");
						
						sXml = doActionIBSheet(sheetObj, formObj, SEARCH06);
	    			}
				} else if(sRow < totCnt-1) {
					formObj.fm_loc_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
					formObj.to_loc_cd.value = sheetObj.CellValue(sRow+1, prefix+"vps_port_cd");
					formObj.loc_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
					formObj.yd_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd") + sheetObj.CellValue(sRow, prefix+"tml_cd");
					
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH06);
				} else {
					formObj.fm_loc_cd.value = sheetObj.CellValue(sRow-1, prefix+"vps_port_cd");
					formObj.to_loc_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
					formObj.loc_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
					formObj.yd_cd.value = sheetObj.CellValue(sRow, prefix+"vps_port_cd") + sheetObj.CellValue(sRow, prefix+"tml_cd");
					
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH06);
				}
    		}
    	}else if(evtFlg == "ADD_CANCEL"){
    		if(sRow > headCnt){
    			var startRow = getNotSkipRow(sheetObj, sRow, "P");
    			var endRow = getNotSkipRow(sheetObj, sRow, "N");
    			if(startRow > 0 && endRow > 0){
    				formObj.fm_loc_cd.value = sheetObj.CellValue(startRow, prefix+"vps_port_cd");
    				formObj.to_loc_cd.value = sheetObj.CellValue(endRow, prefix+"vps_port_cd");
    				
    				sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
    			}
    		}
    	}else if(evtFlg == "REVERSE"){
    		var portCd = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
    		if(portCd != null && portCd != undefined && portCd != ""){
				if(sRow > headCnt && eRow < totCnt){
					var sStartRow = getNotSkipRow(sheetObj, sRow, "P");
					var sEndRow = getNotSkipRow(sheetObj, sRow, "N");
					var eStartRow = getNotSkipRow(sheetObj, eRow, "P");
					var eEndRow = getNotSkipRow(sheetObj, eRow, "N");

	    			if(sStartRow > 0 && eEndRow > 0){
						var fmLocCd = sheetObj.CellValue(sStartRow, prefix+"vps_port_cd");
						fmLocCd = fmLocCd + "|" + sheetObj.CellValue(sRow, prefix+"vps_port_cd");
						fmLocCd = fmLocCd + "|" + sheetObj.CellValue(eStartRow, prefix+"vps_port_cd");
						fmLocCd = fmLocCd + "|" + sheetObj.CellValue(eRow, prefix+"vps_port_cd");
						var toLocCd = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
						toLocCd = toLocCd + "|" + sheetObj.CellValue(sEndRow, prefix+"vps_port_cd");
						toLocCd = toLocCd + "|" + sheetObj.CellValue(eRow, prefix+"vps_port_cd");
						toLocCd = toLocCd + "|" + sheetObj.CellValue(eEndRow, prefix+"vps_port_cd");
						
						formObj.fm_loc_cd.value = fmLocCd;
						formObj.to_loc_cd.value = toLocCd;
						
						sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
	    			}
				}
    		}
    	}
		
		return sXml;
    }
    
    /*
     * CHM-201006456-01 유혁 SKD Auto Update 기능 보완. 기존 파라미터에 rowHide 추가하여 대상에 포함 시킬것인지 말것인지 구분하였음.
     */
    /**
     * flag 값에 따라 sRow의 이전이나 이후의 Skip 이 아닌 Row 를 찾아 리턴한다.
     * 
     * @param sheetObj
     * @param sRow
     * @param flag P:이전 포트 검색, N:다음 포트 검색
     * @param rowHide Hide 된 Row에 대한 처리 구분
     * @return
     */
    function getNotSkipRow(sheetObj, sRow, flag, rowHide){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.headerRows;
    	var totCnt = getTotalRowCnt(sheetObj);
    	
    	if(flag == "P"){
    		if(sRow > headCnt){
	    		for(var i=Number(sRow)-1; i>=headCnt; i--){
	    			if(rowHide){
	    				if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
		    				return i;
		    			}
	    			}else{
		    			if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
		    				return i;
		    			}
	    			}
	    		}
    		}
    	}else if(flag == "N"){
    		if(sRow < totCnt){
    			for(var i=Number(sRow)+1; i<=totCnt; i++){
    				if(rowHide){
	    				if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
		    				return i;
		    			}
    				}else{
    					if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    	    				return i;
    	    			}
    				}
    			}
    		}
    	}
    	
    	return -1;
    }
    
    /**
     * 변경된 Remark 정보를 해당 VVD 에 Setting.
     * @param sheetObj
     * @param rmkVal
     * @return
     */
    function setRemarkDataByVvd(sheetObj, rmkVal){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.headerRows;
    	var totCnt = getTotalRowCnt(sheetObj);
    	
    	var sRow = sheetObj.SelectRow;
    	var selectVvd = sheetObj.CellValue(sRow, prefix+"vvd");
    	
    	for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"vvd") == selectVvd){
				sheetObj.CellValue(i, prefix+"skd_rmk") = rmkVal;
			}
		}
    }
    
    /**
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param sRow
     * @param sXml
     * @return
     */
    function isCheckPort(sheetObj, sRow, sXml){
    	var prefix = sheetObj.id + "_";
    	var chkPort = ComGetEtcData(sXml, "check_port");
		
		if(chkPort == "X"){
			return true;
		}else{
			//해당 Port({?msg1})가 존재하지 않습니다.
			ComShowCodeMessage("VSK00029", sheetObj.CellValue(sRow, prefix+"vps_port_cd"));
			
			sheetObj.CellValue2(sRow, prefix+"vps_port_cd") = "";
			sheetObj.SelectCell(sRow, prefix+"vps_port_cd");
		}
		
		return false;
    }
    
    /**
     * CLPT_SEQ 순차적으로 다시 생성
     * @param sheetObj
     * @return
     */
    function resetClptSeq(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totCnt = getTotalRowCnt(sheetObj);
    	var idx = 0;
    	var vIbFlag = "";
    	var preVvd = "";
    	var curVvd = "";
    	
    	for(var i=headCnt; i<=totCnt; i++){
    		curVvd = sheetObj.CellValue(i, prefix+"vvd");
    		if(preVvd != curVvd){
    			idx = 0;
    			preVvd = curVvd;
    		}
    		
//    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//    			vIbFlag = sheetObj.CellValue(i, prefix+"ibflag");
//    			idx++;
//    			if(sheetObj.id == "sheet2" && i == sheetObj.LastRow){
////    				sheetObj.CellValue2(i, prefix+"clpt_seq") = " ";
//    				sheetObj.SumText(0, prefix+"clpt_seq") = " ";
//    			}else{
//    				sheetObj.CellValue2(i, prefix+"clpt_seq") = idx;
//    			}
//    			sheetObj.CellValue2(i, prefix+"ibflag") = vIbFlag;
//    		}
    		
    		if(sheetObj.RowStatus(i) != "D"){
    			vIbFlag = sheetObj.RowStatus(i);
    			idx++;
    			if(sheetObj.id == "sheet2" && i == sheetObj.LastRow){
//    				sheetObj.CellValue2(i, prefix+"clpt_seq") = " ";
    				sheetObj.SumText(0, prefix+"clpt_seq") = " ";
    			}else{
    				sheetObj.CellValue2(i, prefix+"clpt_seq") = idx;
    			}
    			sheetObj.RowStatus(i) = vIbFlag;
    		}
    	}
    }
    
    /**
     * CLPT_IND_SEQ 다시 생성
     * @param sheetObj
     * @return
     */
    function resetClptIndSeq(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totCnt = getTotalRowCnt(sheetObj);
    	
    	var idx = 0;
    	var vIbFlag = "";
    	var preVvd = "";
    	var curVvd = "";
    	
    	for(var i=headCnt; i<=totCnt; i++){
    		idx = 0;
//    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
    		if(sheetObj.RowStatus(i) != "D"){
	    		for(var j=headCnt; j<=i; j++){
//	    			if(sheetObj.CellValue(j, prefix+"ibflag") != "D"){
	    			if(sheetObj.RowStatus(j) != "D"){
	    				if(sheetObj.CellValue(i, prefix+"vvd") == sheetObj.CellValue(j, prefix+"vvd")){
	    					if(sheetObj.CellValue(i, prefix+"vps_port_cd") == sheetObj.CellValue(j, prefix+"vps_port_cd")){
	    						idx++;
	    					}
	    				}
	    			}
	    		}//end for
//	    		vIbFlag = sheetObj.CellValue(i, prefix+"ibflag");
//    			sheetObj.CellValue2(i, prefix+"new_clpt_ind_seq") = idx;
//    			sheetObj.CellValue2(i, prefix+"ibflag") = vIbFlag;
	    		vIbFlag = sheetObj.RowStatus(i);
    			sheetObj.CellValue2(i, prefix+"new_clpt_ind_seq") = idx;
    			sheetObj.RowStatus(i) = vIbFlag;
    		}
    	}
    }
    
    /**
     * 시뮬레이션 저장 후 새로 생성된 시뮬레이션 number 를 화면에 보여줌.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function setDisplaySimNo(sheetObj, formObj, sXml){
    	if(sXml != null){
    		var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//MESSAGE");
			if(dataNode){
				var msgValue = dataNode.text;
				var flgIdx = msgValue.indexOf(":");
				if(flgIdx > 0){
					var simDt = ComGetMaskedValue(msgValue.substring(flgIdx-8, flgIdx), "ymd");
					var simNo = msgValue.substring(flgIdx+1);
					formObj.sim_dt.value = simDt;
			    	formObj.sim_no.value = ComLpad(simNo,   3, "0");
			    	
			    	glbSheet2FormData.setSimDt(formObj.sim_dt.value);
			    	glbSheet2FormData.setSimNo(formObj.sim_no.value);
				}
			}
    	}
    }
    
    /**
     * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
    		
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH10);
		
		var chkVslCd = ComGetEtcData(sXml, "vsl_chk");
		
		if(chkVslCd == "Y"){
    		//MDM_VSL_CNTR 에 Vessel Code가 존재
    		return true;
    	}else{
    		sheetObj.LoadSearchXml(sXml);
    		formObj.vsl_cd.value = "";
    		return false;
    	}
	}
    
    /**
     * VVD 건수를 확인하여 해당 값을 리턴.
     * 
     * @param sheetObj
     * @return
     */
    function getVvdCnt(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		var sVvd = "";
		var vvdCnt = 0;

    	for(var i=headCnt; i<=totCnt; i++){
    		if(sheetObj.CellValue(i, prefix+"clpt_seq") != "TOTAL"){
	    		if(sVvd != sheetObj.CellValue(i, prefix+"vvd")){
	    			vvdCnt++;
	    			sVvd = sheetObj.CellValue(i, prefix+"vvd");
	        	}
    		}
    	}
    	return vvdCnt;
	}
	
	/*
	 * =====================================================================
	 * 시간 계산
	 * =====================================================================
	 */
    
    /**
	 * Delay Time 을 구한다.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setDelayTime(sheetObj, Row, Col, pfCol){
    	var prefix = sheetObj.id + "_";
    	
    	var vpsDt = sheetObj.CellValue(Row, Col);
    	var pfDt = sheetObj.CellValue(Row, pfCol);
    	var depTimeDiff = "";
    	
    	if(vpsDt != null && vpsDt != ""){
    		if(pfDt != null && pfDt != ""){
    			depTimeDiff = setParsingDelayTime(pfDt, vpsDt);	// Delay Date = vpsEtdDt - pfEtdDt
    		}
    	}
//    	Delay Reason 은 Delay Sea Time 으로 Check 하도록 변경.
//    	if(depTimeDiff == ""){
//    		sheetObj.CellValue2(Row, prefix+"vsl_dlay_rsn_cd") = " ";
//    		sheetObj.CellBackColor(Row, prefix+"vsl_dlay_rsn_cd") = sheetObj.RgbColor(255, 255, 255);
//    		
//    		if(vpsDt != pfDt){
//    			sheetObj.CellFontColor(Row, Col) = glbAdvanceFontColor;
//    		}else{
//    			sheetObj.CellFontColor(Row, Col) = sheetObj.RgbColor(0, 0, 0);
//    		}
//    	}else{
//    		// Delay Reason 은 2번째 Row 부터(1번째 Row 는 입력 불가)
//    		if(Row > sheetObj.HeaderRows){
//    			// Delay 된 Port 는 Delay 입력하도록 유도(필수 입력 Color 로 변경).
//    			sheetObj.CellBackColor(Row, prefix+"vsl_dlay_rsn_cd") = glbEditColor;
//    		}
//    		sheetObj.CellFontColor(Row, Col) = glbDelayFontColor;
//    	}
    	
    	//kjh Costal 대양구간 12시간 이하 Delay 반영되지 않도록 수정 
    	
    	if( sheetObj.CellValue(Row,  prefix +"conti_cd") != sheetObj.CellValue(Row+1,  prefix +"conti_cd")){
			if(Number(depTimeDiff.substring(0,2)) < 1 &&   Number(depTimeDiff.substring(4).replace("H",""))< 12 )
			{
				conti_recovery = "Y";
				sheetObj.CellValue2(Row, prefix+"dlay_date_text") = depTimeDiff;
				sheetObj.CellValue2(Row+1, prefix+"dlay_date_text") = "";
				//alert(sheetObj.CellValue(Row, prefix+"vps_port_cd") );
				//alert(sheetObj.CellValue(Row+1, prefix+"vps_port_cd") );
			}else{
				sheetObj.CellValue2(Row, prefix+"dlay_date_text") = depTimeDiff;
			}
		}else{
			sheetObj.CellValue2(Row, prefix+"dlay_date_text") = depTimeDiff;
		}
    	//sheetObj.CellValue2(Row, prefix+"dlay_date_text") = depTimeDiff;
// 		formObj.dlay_dep_tm.value = depTimeDiff;
    	
    }
    
    /**
     * Delay Time을 정해진 Format 으로 변환.
     * - Delay가 발생된 건만 계산.
     * 
     * @param fmDate
     * @param toDate
     * @return
     */
    function setParsingDelayTime(fmDate, toDate){
    	var timeDiff = "";
    	var sign = "";
    	
    	var day = ComGetDaysBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd"), ComGetMaskedValue(toDate.substring(0,8), "ymd"));
		var time = getTimeDiff(fmDate.substring(8), toDate.substring(8));
		
		if(day >= 0){
			if(time >= 0){
				if(day == 0 && time == 0){
					return "";
				}
			}else{
				if(day > 0){
					day = Number(day) - 1;
					time = 24 + Number(time);
				}
				else{
//					time = time * (-1);
// 					sign = "-";
					return "";
				}
			}
		}
		else{
//			if(time >= 0){
//				if(time > 0){
//					day = Number(day) + 1;
//					time = 24 - Number(time);
//					sign = "-";
//				}else{
//					sign = "";
//				}
//			}else{
//				day = day * (-1);
//				time = time * (-1);
//				sign = "-";
//			}
			return "";
		}
		
		timeDiff = sign + ComLpad(day, 2, "0") + "D-" + ComLpad(time, 2, "0") + "H";
		
		return timeDiff;
    }
    
    /**
     * Total Delay Text 값을 시간단위로 계산한다.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function getTotalDelayHour(sheetObj, Row){
    	
    	if(sheetObj.LastRow<Row){
    		return false;
    	}
    	
    	var days = 0;
    	var hours = 0;
    	
    	var prefix = sheetObj.id + "_";
    	var dlayDateText = sheetObj.CellValue(Row, prefix + "dlay_date_text");
    	var dlayDateHours = 0;
    	
    	if(ComTrim(dlayDateText).length>0){
    		
    		days = Number(dlayDateText.substring(0, dlayDateText.indexOf("D")));
			hours = Number(dlayDateText.substring(dlayDateText.indexOf("-")+1, delayHours.indexOf("H")));
			dlayDateHours = days * 24 + hours;
			
    	}
    	
    	return dlayDateHours;
    }
    
    /**
     * 시간 차를 구한다.
     * @param fmTime
     * @param toTime
     * @return
     */
    function getTimeDiff(fmTime, toTime){
		var rtnTime = "";
// 		var convertTime = 10 * 24;
    	var convertTime = 10 * 10;
    	
    	rtnTime = Math.round((toTime - fmTime) / convertTime);

    	return rtnTime;
	}
	
	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
	
    /**
	 * 입력받은 param 의 해당 폼데이타 처리.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setFormData(sheetObj, Row, Col){
    	var formObj = document.form;
    	var prefix = sheetObj.id + "_";
    	
    	formObj.cre_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"cre_dt"));
    	formObj.cre_usr_id.value = sheetObj.CellValue(Row, prefix+"cre_usr_id");
    	formObj.upd_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"upd_dt"));
    	formObj.upd_usr_id.value = sheetObj.CellValue(Row, prefix+"upd_usr_id");
    	formObj.vsl_slan_cd.value = sheetObj.CellValue(Row, prefix+"vsl_slan_cd");
// 		formObj.vsl_slan_cd.value = sheetObj.CellValue(Row, prefix+"pf_svc_tp_cd");
    	
    	Usr_setCreDt(formObj.cre_dt.value);
    	Usr_setCreUsrId(formObj.cre_usr_id.value);
    	Usr_setVslSlanCd(formObj.vsl_slan_cd.value);
    	Usr_setUpdDt(formObj.upd_dt.value);
    	Usr_setUpdUsrId(formObj.upd_usr_id.value);
    	
    	if(sheetObj.id == "sheet1"){
    		getComboObject("remark").Code2 = sheetObj.CellValue(Row, prefix+"vvd");
// 			ComEnableObject(formObj.skd_rmk, sheetObj.RowEditable(Row));
    		formObj.skd_rmk.value = sheetObj.CellValue(Row, prefix+"skd_rmk");
    	}else{
    		formObj.skd_rmk.value = sheetObj.CellValue(Row, prefix+"diff_rmk");
    	}
		Usr_setSkdRmk(formObj.skd_rmk.value);
    	
    	// SHEET 선택 시 해당 ROW의 VVD를 조회조건의 VVD로 셋팅.
		formObj.vsl_cd.value = sheetObj.CellValue(Row, prefix+"vsl_cd");
    	formObj.skd_voy_no.value = sheetObj.CellValue(Row, prefix+"skd_voy_no");
    	formObj.skd_dir_cd.value = sheetObj.CellValue(Row, prefix+"skd_dir_cd");

    	Usr_setVslCd(formObj.vsl_cd.value);
    	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
    	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
    }
	
	/**
	 * 버튼2의 스타일, 활성화 상태 등을 조작한다.
	 * @param eleName
	 * @param btnName
	 * @param btnDply
	 * @param btnClass
	 * @param btnSize
	 * @return
	 */
	function btn2ControlHtml(eleName, btnName, btnDply, btnClass, btnSize){
		if(btnClass == null || btnClass == undefined || btnClass == ""){
			btnClass = "btn1";
		}
		if(btnSize == null || btnSize == undefined || btnSize == ""){
			btnSize = "140";
		}
		var ctlr = document.getElementById(eleName);
		var strHtml = '<table width="'+btnSize+'" border="0" cellpadding="0" cellspacing="0" class="button">\n';
		strHtml = strHtml + '<tr><td class="btn2_left"></td>\n';
		strHtml = strHtml + '<td class="'+btnClass+'" name="'+btnName+'" id="'+btnName+'">'+btnDply+'</td>\n';
		strHtml = strHtml + '<td class="btn2_right"></td>\n';
		strHtml = strHtml + '</tr>\n';
		strHtml = strHtml + '</table>';
		ctlr.innerHTML = strHtml;
	}
	
	/**
	 * [Coastal SKD] / [Recovery Plan] 상태에 따라 해당 Button 들을 호출(활성화).
	 * @param formObj
	 * @return
	 */
	function replaceButtonSet(formObj){
		if(formObj.rdo_tran[0].checked){
//			document.getElementById("div_row_hide_1").style.display = "block";
//			document.getElementById("div_row_hide_cancel_1").style.display = "block";
			document.getElementById("div_skip_call_1").style.display = "block";
			document.getElementById("div_skip_call_cancel_1").style.display = "block";
//			document.getElementById("div_cost_calculation_1").style.display = "block";
			
			document.getElementById("div_add_call_1").style.display = "block";
			document.getElementById("div_add_call_cancel_1").style.display = "block";
			document.getElementById("div_reverse_call_1").style.display = "block";
// 			document.getElementById("div_reverse_call_cancel_1").style.display = "block";
// 			document.getElementById("div_p_in_1").style.display = "block";
// 			document.getElementById("div_p_in_cancel_1").style.display = "block";
			document.getElementById("div_p_out_1").style.display = "block";
			document.getElementById("div_p_out_cancel_1").style.display = "block";
			
//			document.getElementById("div_row_hide_2").style.display = "none";
//			document.getElementById("div_row_hide_cancel_2").style.display = "none";
			document.getElementById("div_skip_call_2").style.display = "none";
			document.getElementById("div_skip_call_cancel_2").style.display = "none";
			document.getElementById("div_add_call_2").style.display = "none";
			document.getElementById("div_add_call_cancel_2").style.display = "none";
			document.getElementById("div_reverse_call_2").style.display = "none";
// 			document.getElementById("div_reverse_call_cancel_2").style.display = "none";
// 			document.getElementById("div_p_in_2").style.display = "none";
// 			document.getElementById("div_p_in_cancel_2").style.display = "none";
			document.getElementById("div_p_out_2").style.display = "none";
			document.getElementById("div_p_out_cancel_2").style.display = "none";
    	}else{
//			document.getElementById("div_row_hide_1").style.display = "none";
//			document.getElementById("div_row_hide_cancel_1").style.display = "none";
			document.getElementById("div_skip_call_1").style.display = "none";
			document.getElementById("div_skip_call_cancel_1").style.display = "none";
//			document.getElementById("div_cost_calculation_1").style.display = "none";
			
			document.getElementById("div_add_call_1").style.display = "none";
			document.getElementById("div_add_call_cancel_1").style.display = "none";
			document.getElementById("div_reverse_call_1").style.display = "none";
// 			document.getElementById("div_reverse_call_cancel_1").style.display = "none";
// 			document.getElementById("div_p_in_1").style.display = "none";
// 			document.getElementById("div_p_in_cancel_1").style.display = "none";
			document.getElementById("div_p_out_1").style.display = "none";
			document.getElementById("div_p_out_cancel_1").style.display = "none";
			
//			document.getElementById("div_row_hide_2").style.display = "block";
//			document.getElementById("div_row_hide_cancel_2").style.display = "block";
			document.getElementById("div_skip_call_2").style.display = "block";
			document.getElementById("div_skip_call_cancel_2").style.display = "block";
			document.getElementById("div_add_call_2").style.display = "block";
			document.getElementById("div_add_call_cancel_2").style.display = "block";
			document.getElementById("div_reverse_call_2").style.display = "block";
// 			document.getElementById("div_reverse_call_cancel_2").style.display = "block";
// 			document.getElementById("div_p_in_2").style.display = "block";
// 			document.getElementById("div_p_in_cancel_2").style.display = "block";
			document.getElementById("div_p_out_2").style.display = "block";
			document.getElementById("div_p_out_cancel_2").style.display = "block";
    	}
	}
    
	/**
	 * 버튼 초기화.
	 * @return
	 */
    function initButton(sheetObj){
    	var formObj = document.form;
    	
    	if(sheetObj.id == "sheet1"){
//	    	ComBtnDisable("btn_row_hide_1");
	    	ComBtnDisable("btn_skip_call_1");
	    	ComBtnDisable("btn_add_call_1");
	    	ComBtnDisable("btn_reverse_call_1");
	    	ComBtnDisable("btn_p_out_1");
//	    	ComBtnDisable("btn_row_hide_cancel_1");
	    	ComBtnDisable("btn_skip_call_cancel_1");
	    	ComBtnDisable("btn_add_call_cancel_1");
	    	ComBtnDisable("btn_cost_calculation_1");
// 			ComBtnDisable("btn_reverse_call_cancel_1");
	    	
//	    	ComBtnDisable("btn_settlement");
//	    	ComEnableObject(formObj.btn_sim_no, false);
    	}else{
//	    	ComBtnDisable("btn_row_hide_2");
	    	ComBtnDisable("btn_skip_call_2");
	    	ComBtnDisable("btn_add_call_2");
	    	ComBtnDisable("btn_reverse_call_2");
	    	ComBtnDisable("btn_p_out_2");
//	    	ComBtnDisable("btn_row_hide_cancel_2");
	    	ComBtnDisable("btn_skip_call_cancel_2");
	    	ComBtnDisable("btn_add_call_cancel_2");
// 			ComBtnDisable("btn_reverse_call_cancel_2");
	    	
//	    	ComBtnEnable("btn_settlement");
//	    	ComEnableObject(formObj.btn_sim_no, true);
    	}
    	
    	ComBtnEnable("btn_save");
    }
    
    /**
     * 버튼 활성화 상태처리.
     * 
     * @param sheetObj
     * @return
     */
    function setRowControlBtnSts(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
    	if(sheetObj.id == "sheet1"){
			//Skip Button
	    	if(isSkipBtnSts(sheetObj, Row) && !isSkipCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_1");
	    		document.getElementById("div_skip_call_1").style.display = "Inline";
	    		ComBtnDisable("btn_skip_call_cancel_1");
	    		document.getElementById("div_skip_call_cancel_1").style.display = "none";
	    	}else if (!isSkipBtnSts(sheetObj, Row) && isSkipCancelBtnSts(sheetObj, Row)) {
	    		ComBtnDisable("btn_skip_call_1");
	    		document.getElementById("div_skip_call_1").style.display = "none";
	    		ComBtnEnable("btn_skip_call_cancel_1");
	    		document.getElementById("div_skip_call_cancel_1").style.display = "Inline";
	    	} else {
	    		ComBtnDisable("btn_skip_call_1");
	    		document.getElementById("div_skip_call_1").style.display = "Inline";
	    		ComBtnDisable("btn_skip_call_cancel_1");
	    		document.getElementById("div_skip_call_cancel_1").style.display = "none";
	    	}
	    	// Add Call Cancel Button
	    	if(isAddCancelBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_cancel_1");
		    	document.getElementById("div_add_call_cancel_1").style.display = "Inline";
	    	}else{
				ComBtnDisable("btn_add_call_cancel_1");
				document.getElementById("div_add_call_cancel_1").style.display = "none";
			}
	    	//Add Call Button
	    	if (isAddBtnSts(sheetObj, Row)) {
	    		ComBtnEnable("btn_add_call_1");
	    	} else {
	    		ComBtnDisable("btn_add_call_1");
	    	}
			//Phase Out Button
	    	if(isPhaseOutBtnSts(sheetObj, Row) && !isPhaseOutCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_1");
	    		document.getElementById("div_p_out_1").style.display = "Inline";
	    		ComBtnDisable("btn_p_out_cancel_1");
	    		document.getElementById("div_p_out_cancel_1").style.display = "none";
	    	}else if (!isPhaseOutBtnSts(sheetObj, Row) && isPhaseOutCancelBtnSts(sheetObj, Row)) {
	    		ComBtnDisable("btn_p_out_1");
	    		document.getElementById("div_p_out_1").style.display = "none";
	    		ComBtnEnable("btn_p_out_cancel_1");
	    		document.getElementById("div_p_out_cancel_1").style.display = "Inline";
	    	} else {
	    		ComBtnDisable("btn_p_out_1");
	    		document.getElementById("div_p_out_1").style.display = "Inline";
	    		ComBtnDisable("btn_p_out_cancel_1");
	    		document.getElementById("div_p_out_cancel_1").style.display = "none";
	    	}
	    	//::2013-11-19:정상기:LIVE반영연기에 따른 주석처리:://
	    	//ComBtnEnable("btn_cost_calculation_1");//
    	}else{
    		//Skip Button
	    	if(isSkipBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_2");
	    	}else{
	    		ComBtnDisable("btn_skip_call_2");
	    	}
	    	//Skip Cancel Button
	    	if(isSkipCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_cancel_2");
	    	}else{
	    		ComBtnDisable("btn_skip_call_cancel_2");
	    	}
	    	//Add Button
	    	if(isAddBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_2");
	    	}else{
				ComBtnDisable("btn_add_call_2");
			}
	    	//Add Cancel Button
	    	if(isAddCancelBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_cancel_2");
	    	}else{
				ComBtnDisable("btn_add_call_cancel_2");
			}
			//Phase Out Button
	    	if(isPhaseOutBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_2");
	    	}else{
	    		ComBtnDisable("btn_p_out_2");
	    	}
	    	//Phase Out Cancel Button
	    	if(isPhaseOutCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_cancel_2");
	    	}else{
	    		ComBtnDisable("btn_p_out_cancel_2");
	    	}
    	}
    }
    
    /**
     * Loadable Weight Button 활성화 Control.
     *  
     * @param sheetObj
     * @param Row
     * @return
     */
    function btnControlByLoadableWeight(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
		if(sheetObj.CellValue(Row, prefix+"vps_port_cd") == "CNSHA"){
			if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") != "S"){
				ComBtnEnable("btn_loadableweight");
			}else{
				ComBtnDisable("btn_loadableweight");
			}
		}else{
			ComBtnDisable("btn_loadableweight");
		}
    }
    
    /**
     * turn_port_flg 가 'Y' 이면서 turn_skd_voy_no 및 turn_skd_dir_cd 가 Null 인 건을 찾아 Edit 가능하게 변경.
     * 
     * @param sheetObj
     * @return
     */
    function turnEditChange(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
		var totCnt = getTotalRowCnt(sheetObj);
		
		// turn_port_flg 가 'Y' 이면서 turn_skd_voy_no 및 turn_skd_dir_cd 가 Null 인 건을 찾아 Edit 가능하게 변경.
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
//				if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
					sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = true;
					sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = true;
// 				}
			}
		}
    }
    
    /**
     * 조회 조건 변경 시 Sheet 초기화.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function resetAllData(sheetObj, formObj){
    	formObj.cre_dt.value = "";
    	formObj.cre_usr_id.value = "";
    	formObj.vsl_slan_cd.value = "";
    	formObj.upd_dt.value = "";
    	formObj.upd_usr_id.value = "";
    	formObj.skd_rmk.value = "";
    	Usr_setCreDt(formObj.cre_dt.value);
    	Usr_setCreUsrId(formObj.cre_usr_id.value);
    	Usr_setVslSlanCd(formObj.vsl_slan_cd.value);
    	Usr_setUpdDt(formObj.upd_dt.value);
    	Usr_setUpdUsrId(formObj.upd_usr_id.value);
    	Usr_setSkdRmk(formObj.skd_rmk.value);
    	
    	if(glbSheetFlg == "sheet1"){
    		getComboObject("remark").RemoveAll();
    	}
    	sheetObj.RemoveAll();
    	
    	showFieldControl(sheetObj, formObj, false);
    	
    	initButton(sheetObj);
    }
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
	
	/**
	 * Remark Combo를 Setting.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function setRemarkCombo(sheetObj, formObj){
		var stndVvd = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
		
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		var vvdArr = new Array();
		var vvdIdx = 0;
		
		var currVvd = sheetObj.CellValue(headCnt, prefix+"vvd");
		vvdArr[vvdIdx] = currVvd;
		for(var i=headCnt; i<=totCnt; i++){
			if(currVvd != sheetObj.CellValue(i, prefix+"vvd")){
				currVvd = sheetObj.CellValue(i, prefix+"vvd");
				vvdArr[++vvdIdx] = currVvd;
			}
		}
		
		appendMultiComboItem(getComboObject("remark"), vvdArr, vvdArr, stndVvd);
	}
	
	/**
	 * 항해시간(TZTM_HRS), 작업시간(ACT_WRK_HRS)을 백업한다.
	 * 스케줄을 조정하다 보면 시간을 조정하게 되는데
	 * 여러가지 방법으로 조정하기 위해서는 초기 값을 유지해야 한다.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function setTmpHrs(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		for(var Row=headCnt; Row<=totCnt; Row++){
			sheetObj.CellValue2(Row, prefix+"tmp_tztm_hrs") = sheetObj.CellValue(Row, prefix+"tztm_hrs");
			sheetObj.CellValue2(Row, prefix+"tmp_act_wrk_hrs") = sheetObj.CellValue(Row, prefix+"act_wrk_hrs");
			sheetObj.CellValue2(Row, prefix+"tmp_lnk_spd") = sheetObj.CellValue(Row, prefix+"lnk_spd");
		}
	}
	
	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
		comboObj.RemoveAll();
		
    	for(var i=0; i<optionCds.length; i++) {
			comboObj.InsertItem(i, optionCds[i]+"|"+optionTxts[i], optionCds[i]);
		}
    	
		comboObj.Code2 = selCode;
	}
    
    /**
     * simulation no 로 조회 시 simulation 을 생성한 조건값 Setting...
     * 
     * 2010-01-26 임창빈 수석 요청.
     * bound 가 홀수인 경우는 가운데, 짝수인 경우는 무조건 첫번째 로 Focus 이동.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function setSimulationForm(sheetObj, formObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt = getTotalRowCnt(sheetObj);
    	
    	var bound = sheetObj.CellValue(headCnt, prefix+"bound");
    	var mIdx = 0;
    	var curVvd = "";
    	var newVvd = "";
    	
    	if(bound == 2 || bound == 4){
    		formObj.vsl_cd.value = sheetObj.CellValue(headCnt, prefix+"vsl_cd");
			formObj.skd_voy_no.value = sheetObj.CellValue(headCnt, prefix+"skd_voy_no");
			formObj.skd_dir_cd.value = sheetObj.CellValue(headCnt, prefix+"skd_dir_cd");
			Usr_setVslCd(formObj.vsl_cd.value);
	    	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
	    	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
	    	bound = Number(bound) + 1;
    	}else{
	    	for(var i=headCnt; i<=totCnt; i++){
	    		curVvd = sheetObj.CellValue(i, prefix+"vvd");
				if(curVvd != newVvd){
					newVvd = curVvd;
					mIdx++;
				}
				if(mIdx == parseInt(Number(bound)/2 + 1, 10)){
	    			formObj.vsl_cd.value = sheetObj.CellValue(i, prefix+"vsl_cd");
	    			formObj.skd_voy_no.value = sheetObj.CellValue(i, prefix+"skd_voy_no");
	    			formObj.skd_dir_cd.value = sheetObj.CellValue(i, prefix+"skd_dir_cd");
	
	    	    	Usr_setVslCd(formObj.vsl_cd.value);
	    	    	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
	    	    	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
	    			
	    			break;
				}
	    	}
    	}
    	
    	formObj.bound.value = bound;
    	Usr_setBound(formObj.bound.value);
    }
    
    /**
     * 
     * @param formObj
     * @param srcName
     * @return
     */
    function formNextFocus(formObj, srcName){
    	var objCnt = formObj.length;
    	
    	for(var i=0; i<objCnt-1; i++){
    		if(formObj.elements[i].name == srcName){
    			if(formObj.elements[i+1].focus()){
    				formObj.elements[i+1].focus();
    				return false;
    			}
    		}
    	}
    }
    
    /**
     * 메일 전송(외부메일).
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendMail(sheetObj, formObj){
    	
    	////alert(getWebMailSubject		(sheetObj, formObj));
    	////alert(getWebMailHtmlContents(sheetObj, formObj));
    	
    	formObj.com_subject.value = getWebMailSubject		(sheetObj, formObj);
    	formObj.com_content.value = getWebMailHtmlContents	(sheetObj, formObj);
    	ComSendMailModal();
    }
    
    /**
     * 메일 전송(그룹웨어).
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendGroupwareMail(sheetObj, formObj){
    	formObj.gw_subject.value = getGWSubject(sheetObj, formObj);
    	formObj.gw_contents.value = getGWMailHtmlContents(sheetObj, formObj);
//    	formObj.gw_contents.value = getGWMailTextContents(sheetObj, formObj);
//    	window.clipboardData.setData('Text', formObj.gw_contents.value);
    	ComOpenGroupwareMail(sheetObj, formObj);
    }
    
    /**
     * Groupware(Mail, Board)에 들어갈 제목을 형식에 맞춰 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getGWSubject(sheetObj, formObj){
    	var subject = "[" + formObj.vsl_slan_cd.value + "]";
    	subject = subject + " Coastal Schedule of VVD";
    	subject = subject + "(" + getVVDListInfo(sheetObj, "mail_title", "/") + ")";
    	
    	return subject;
    }
    
    /**
     * Groupware(Mail, Board)에 들어갈 제목을 형식에 맞춰 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getWebMailSubject(sheetObj, formObj){
    	var subject = "[" + formObj.vsl_slan_cd.value + "]";
    	subject = subject + " Coastal Schedule of VVD";
    	subject = subject + "(" + getVVDListInfo(sheetObj, "mail_title", "/") + ")";
    	
    	return subject;
    }    
    
    /**
     * VVD 목록을 정해진 형식 맞춰 반환한다.
     * 
     * @param sheetObj
     * @param sFlag
     * @param sDelim
     * @return
     */
    function getVVDListInfo(sheetObj, sFlag, sDelim){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totCnt = getTotalRowCnt(sheetObj);
    	var argVDs = "";
    	var curVD = "";
    	var nxtVD = "";
    	
    	if(rowCnt > 0){
    		if(sFlag == "mail_title"){
    			curVD = sheetObj.CellValue(headCnt, prefix+"vsl_cd") + sheetObj.CellValue(headCnt, prefix+"skd_voy_no") + sheetObj.CellValue(headCnt, prefix+"skd_dir_cd");
    		}else if(sFlag == "mail_body"){
    			curVD = sheetObj.CellValue(headCnt, prefix+"skd_voy_no") + sheetObj.CellValue(headCnt, prefix+"skd_dir_cd");
    		}
    		argVDs = curVD;
    		for(var i=headCnt; i<=totCnt; i++){
    			if(sFlag == "mail_title"){
    				nxtVD = sheetObj.CellValue(headCnt, prefix+"vsl_cd") + sheetObj.CellValue(i, prefix+"skd_voy_no") + sheetObj.CellValue(i, prefix+"skd_dir_cd");
    			}else if(sFlag == "mail_body"){
    				nxtVD = sheetObj.CellValue(i, prefix+"skd_voy_no") + sheetObj.CellValue(i, prefix+"skd_dir_cd");
        		}
    			if(curVD != nxtVD){
    				argVDs = argVDs + sDelim + nxtVD;
    				curVD = nxtVD;
    			}
    		}
    	}else{
    		return "";
    	}
    	
    	return argVDs;
    }
    
    /*
     * 	25th MAR 2010
		TO : ALL CONCERNED PARTIES
		FM : SML/Vessel Operation Team 
		RE : [SJX] M/V SMLINE PIRAEUS 00016W/0017E F/E C/SKED
		
		
		Dear, all concerned parties,
		
		Please refer to HJPI 0016W/0017E F/E C/sked for Asia region.
		
		
		Port           ETA       ETB       ETD     Remark
		------------------------------------------------------
		0016W
		JPTYO  APR   02/0500   02/0800   02/1400
		JPOSA        03/0900   03/1200   03/1800
		CNHKG        06/1300   06/1500   06/2100
		
		0017E
		MYPKG  APR   10/0700   10/0800   10/1500
		SGSIN        11/0300   11/0500   11/2100
		VNVUN        13/0500   13/0800   14/0001
		CNHKG        15/2200   16/0001   16/0500
		CNYIT        16/0900   16/1000   16/2000
		JPOSA        19/1400   19/1700   19/2100
		JPTYO        20/1800   20/2100   21/0200
		USLGB        30/0500
     */
    /**
     * Groupware(Mail)에 들어갈 내용을 Text 형식으로 반환한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWMailTextContents(sheetObj, formObj){
    	var year = ComGetNowInfo("yy");
    	var month = ComGetNowInfo("mm");
    	var day = ComGetNowInfo("dd");
    	var monthArr = new Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT" ,"NOV", "DEC");
    	var voyDirInfo = getVVDListInfo(sheetObj, "mail_body", "/");
    	
    	var contents = day + "th " + monthArr[month-1] + " " + year + "\n";
    	contents = contents + "TO : ALL CONCERNED PARTIES" + "\n";
    	contents = contents + "FM : SML/Vessel Operation Team" + "\n";
    	contents = contents + "RE : [" + glbMainVslSlanCd + "] M/V " + glbMainVslEngNm + " " + voyDirInfo + " F/E C/SKED" + "\n";
    	contents = contents + "\n";
    	contents = contents + "Dear, all concerned parties," + "\n";
    	contents = contents + "\n";
    	contents = contents + "Please refer to "+glbMainVslCd+" " + voyDirInfo + " F/E C/sked for Asia region." + "\n";
    	contents = contents + "\n";
    	contents = contents + "\n";
    	contents = contents + getGWMailTextDetailContents(sheetObj);
    	
    	return contents;
    }
    
    /**
     * Groupware(Mail)에 들어갈 상세내용을 Text 형식으로 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getGWMailTextDetailContents(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt = getTotalRowCnt(sheetObj);
    	var rowCnt = sheetObj.RowCount;
    	var colCnt = sheetObj.LastCol;
    	
    	var contents = "";
    	
    	if(rowCnt > 0){
//			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    		contents = contents + ComRpad("SEQ", 4, " ");
    		contents = contents + ComRpad("VOY NO", 8, " ");
    		contents = contents + ComRpad("Port", 8, " ");
    		contents = contents + ComRpad("ETA", 20, " ");
    		contents = contents + ComRpad("ETB", 20, " ");
    		contents = contents + ComRpad("ETD", 20, " ");
    		contents = contents + ComRpad("Status", 20, " ");
    		contents = contents + "Remark\n";
    		contents = contents + ComRpad("-", 120, "-") + "\n";
    		
    		for(var i=headCnt; i<=totCnt; i++){
//    			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"clpt_seq"), 4, " ");
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"skd_voy_no") + sheetObj.CellValue(i, prefix+"skd_dir_cd"), 8, " ");
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"vps_port_cd"), 8, " ");
    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_eta_dt"), 20, " ");
    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etb_dt"), 20, " ");
    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etd_dt"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_eta_dt"), "ymdhm"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etb_dt"), "ymdhm"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etd_dt"), "ymdhm"), 20, " ");
    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"skd_cng_sts_cd"), 20, " ");
    			contents = contents + sheetObj.CellValue(i, prefix+"vps_rmk") + "\n";
    		}// end for
    		
    		contents = contents + ComRpad("-", 120, "-") + "\n";
    	}
    	
    	return contents;
    }
    
    /**
     * Groupware(Mail)에 들어갈 내용을 HTML 형식으로 반환한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWMailHtmlContents(sheetObj, formObj){
    	var year 		= ComGetNowInfo("yy");
    	var month 		= ComGetNowInfo("mm");
    	var day 		= ComGetNowInfo("dd");
    	var monthArr 	= new Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT" ,"NOV", "DEC");
    	var voyDirInfo 	= getVVDListInfo(sheetObj, "mail_body", "/");
    	
    	var contents = "<BODY><div style='font-size: 14px;font-family: Consolas'>\n";
	    	contents = contents + day + "th " + monthArr[month-1] + " " + year + "<BR>\n";
	    	contents = contents + "TO : ALL CONCERNED PARTIES" + "<BR>\n";
	    	contents = contents + "FM : SML/Vessel Operation Team" + "<BR>\n";
	    	contents = contents + "RE : [" + glbMainVslSlanCd + "] M/V " + glbMainVslEngNm + " " + voyDirInfo + " F/E C/SKED" + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + "Dear, all concerned parties," + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + "Please refer to "+glbMainVslCd+" " + voyDirInfo + " F/E C/sked for Asia region." + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + getGWMailHtmlDetailContents(sheetObj)+"\n";
	    	contents = contents + "</div></BODY>";
    	
    	return contents;
    }
    
    /**
     * Groupware(Mail)에 들어갈 내용을 HTML 형식으로 반환한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getWebMailHtmlContents(sheetObj, formObj){
    	var year 		= ComGetNowInfo("yy");
    	var month 		= ComGetNowInfo("mm");
    	var day 		= ComGetNowInfo("dd");
    	var monthArr 	= new Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT" ,"NOV", "DEC");
    	var voyDirInfo 	= getVVDListInfo(sheetObj, "mail_body", "/");
    	
    	var contents = "<BODY><div style='font-size: 14px;font-family: Consolas'>\n";
	    	contents = contents + day + "th " + monthArr[month-1] + " " + year + "<BR>\n";
	    	contents = contents + "TO : ALL CONCERNED PARTIES" + "<BR>\n";
	    	contents = contents + "FM : SML/Vessel Operation Team" + "<BR>\n";
	    	contents = contents + "RE : [" + glbMainVslSlanCd + "] M/V " + glbMainVslEngNm + " " + voyDirInfo + " F/E C/SKED" + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + "Dear, all concerned parties," + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + "Please refer to "+glbMainVslCd+" " + voyDirInfo + " F/E C/SKED for Asia region." + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + "<BR>\n";
	    	contents = contents + getWebMailHtmlDetailContents(sheetObj)+"\n";
	    	contents = contents + "</div></BODY>";
    	
    	return contents;
    }
    
    /**
     * Groupware(Mail)에 들어갈 상세내용을 HTML 형식으로 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getWebMailHtmlDetailContents(sheetObj){
    	var prefix 	= sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt 	= getTotalRowCnt(sheetObj);
    	var rowCnt 	= sheetObj.RowCount;
    	var colCnt 	= sheetObj.LastCol;
    	
    	var contents = "";
    	
    	if(rowCnt > 0){
    		
//			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    		
    		//::2014-06-05:by KWK:://contents = contents + ComRpad("SEQ"			, 4	, "&nbsp;");
    		contents = contents + ComRpad("VoyNo."		, 8	, "&nbsp;");
    		contents = contents + ComRpad("Port"		, 8	, "&nbsp;");
    		contents = contents + ComRpad("ETA"			, 20, "&nbsp;");
    		contents = contents + ComRpad("ETB"			, 20, "&nbsp;");
    		contents = contents + ComRpad("ETD"			, 20, "&nbsp;");
//    		contents = contents + ComRpad("Status", 10, "&nbsp;");
    		
    		contents = contents + ComRpad("Delay(TTL)"	, 15, "&nbsp;");  //::jsk::2012.07.19//
    		
    		contents = contents + ComLpad("FOC"			, 10, "&nbsp;");
    		contents = contents + ComLpad("Remark"		, 15, "&nbsp;") + "<BR>\n";
    		
    		contents = contents + ComRpad("-", 120, "-");
    		contents = contents + "<BR>\n";
    		
    		var curVoyDir = "";
    		var preVoyDir = "";
    		
    		for(var i=headCnt; i<=totCnt; i++){
    			
    			curVoyDir = sheetObj.CellValue(i, prefix+"skd_voy_no") + sheetObj.CellValue(i, prefix+"skd_dir_cd");
//    			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    			//::2014-06-05:by KWK:://contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"clpt_seq"), 4, "&nbsp;");
    			if(preVoyDir != curVoyDir){
    				contents 	= contents + ComRpad(curVoyDir, 8, "&nbsp;");
    				preVoyDir 	= curVoyDir;
    			}else{
    				contents 	= contents + ComRpad("", 8, "&nbsp;");
    			}
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"vps_port_cd"), 8, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_eta_dt"), "ymdhm"), 20, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etb_dt"), "ymdhm"), 20, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etd_dt"), "ymdhm"), 20, "&nbsp;");
//    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"skd_cng_sts_cd"), 10, "&nbsp;");
    			
    			if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")=="S"){
    				contents = contents + ComRpad("", 75, "&nbsp;");
    			}else{
    				contents 	= contents + ComRpad(sheetObj.CellText(i, prefix+"vps_eta_dt")		, 20, "&nbsp;");
    				contents 	= contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etb_dt")		, 20, "&nbsp;");
    				contents 	= contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etd_dt")		, 20, "&nbsp;");
    				contents 	= contents + ComRpad(sheetObj.CellText(i, prefix+"dlay_date_text")	, 15, "&nbsp;");	//::jsk::2012.07.19//
    			}

    			if(sheetObj.CellText(i, prefix+"fcm_foc_qty") == null || sheetObj.CellText(i, prefix+"fcm_foc_qty") == ""){
    				contents 	= contents + ComLpad("", 10, "&nbsp;");
    			}else{
    				contents 	= contents + ComLpad(ComAddComma2(sheetObj.CellText(i, prefix+"fcm_foc_qty"),"#,###.0"), 10, "&nbsp;");
    			}
    		    
    			contents 		= contents + ComRpad(sheetObj.CellText(i, prefix+"vps_rmk")			, 15, "&nbsp;")+"<BR>\n";	
    			
    			////contents = contents + ComLpad(ComAddComma(sheetObj.CellText(i, prefix+"fcm_foc_qty")), 10, "&nbsp;")+"<BR>\n";
    			////contents = contents + ComAddComma(sheetObj.CellText(i, prefix+"fcm_foc_qty")) + "<BR>\n";
    		
    		}	// end for
    		
    		contents 			= contents + ComRpad("-", 120, "-");
    		contents 			= contents + "<BR>\n";
    	}
    	
    	return contents;
    }
    
    /**
     * Groupware(Mail)에 들어갈 상세내용을 HTML 형식으로 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getGWMailHtmlDetailContents(sheetObj){
    	var prefix 	= sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt 	= getTotalRowCnt(sheetObj);
    	var rowCnt 	= sheetObj.RowCount;
    	var colCnt 	= sheetObj.LastCol;
    	
    	var contents = "";
    	
    	if(rowCnt > 0){
//			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    		contents = contents + ComRpad("SEQ", 4, "&nbsp;");
    		contents = contents + ComRpad("VoyNo.", 8, "&nbsp;");
    		contents = contents + ComRpad("Port", 8, "&nbsp;");
    		contents = contents + ComRpad("ETA", 20, "&nbsp;");
    		contents = contents + ComRpad("ETB", 20, "&nbsp;");
    		contents = contents + ComRpad("ETD", 20, "&nbsp;");
//    		contents = contents + ComRpad("Status", 10, "&nbsp;");
    		
    		contents = contents + ComRpad("Delay(TTL)", 15, "&nbsp;");  //::jsk::2012.07.19//
    		
    		contents = contents + "Remark"+"<BR>\n";
    		contents = contents + ComRpad("-", 120, "-");
    		contents = contents + "<BR>\n";
    		
    		var curVoyDir = "";
    		var preVoyDir = "";
    		
    		for(var i=headCnt; i<=totCnt; i++){
    			curVoyDir = sheetObj.CellValue(i, prefix+"skd_voy_no") + sheetObj.CellValue(i, prefix+"skd_dir_cd");
//    			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"clpt_seq"), 4, "&nbsp;");
    			if(preVoyDir != curVoyDir){
    				contents = contents + ComRpad(curVoyDir, 8, "&nbsp;");
    				preVoyDir = curVoyDir;
    			}else{
    				contents = contents + ComRpad("", 8, "&nbsp;");
    			}
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"vps_port_cd"), 8, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_eta_dt"), "ymdhm"), 20, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etb_dt"), "ymdhm"), 20, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etd_dt"), "ymdhm"), 20, "&nbsp;");
//    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"skd_cng_sts_cd"), 10, "&nbsp;");
    			
    			if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")=="S"){
    				contents = contents + ComRpad("", 75, "&nbsp;");
    			}else{
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_eta_dt"), 20, "&nbsp;");
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etb_dt"), 20, "&nbsp;");
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etd_dt"), 20, "&nbsp;");
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"dlay_date_text"), 15, "&nbsp;");	//::jsk::2012.07.19//
    			}

    			contents = contents + sheetObj.CellValue(i, prefix+"vps_rmk") + "<BR>\n";
    		
    		}// end for
    		
    		contents = contents + ComRpad("-", 120, "-");
    		contents = contents + "<BR>\n";
    	}
    	
    	return contents;
    }
    
    /**
     * 게시판.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendGroupwareBoard(sheetObj, formObj){
//    	formObj.gw_subject.value = getGWSubject(sheetObj, formObj);
    	var sText = getGWBoardContents(sheetObj, formObj);
    	
    	window.clipboardData.setData('Text', sText);
    	
    	var gwUrl = formObj.encode_gw_url.value;
		if(formObj.target_server.value == "TEST"){
			// *** TEST ***
// 			sUrl = "http://gwdev.smlines.com/myoffice/ezBoardSTD/NewBoardItem.aspx?BoardID=" + pBoardID + "&Mode=new";
			sUrl = "http://gwdev.smlines.com/login.aspx?command=redirect&parameter=" + gwUrl;
		}else{
			// *** LIVE ***
// 			sUrl = "http://gw.smlines.com/myoffice/ezBoardSTD/NewBoardItem.aspx?BoardID=" + pBoardID + "&Mode=new";
			sUrl = "http://gwdev.smlines.com/login.aspx?command=redirect&parameter=" + gwUrl;
		}
		
		window.open(sUrl, "", "");
    }

    /*
### [AWH] M/V SMLINE MALTA  0150E Coastal Schedule ###
Lane : AWH

SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
-----------------------------------------------------------------------------------------------------
1	0150E	CNTAO	Aug   26/1700	26/1800		27/0600		 		
2	0150E	CNNBO	Aug   28/1000	28/1300		28/2300		 		
3	0150E	CNSHA	Aug   29/1700	29/2100		30/1900		 		
4	0150E	KRPUS	Sep   01/1100	01/1200		01/2200		 		
5	0150E	PAPAC	Sep   18/0100	18/0200		18/1800		 		
6	0150W	USNYC	Sep   22/1500	22/1800		23/2000		 		
7	0150W	USILM	Sep   25/0900	25/1200		26/0100		 		
8	0150W	USSAV	Sep   26/1500	26/1800		27/1000		 		
9	0150W	PAPAC	Oct   01/0100	01/0200		01/1800		 		
10	0150W	KRPUS	Oct   19/0500	19/0600		19/1600		 		
11	0150W	KRPYT	Oct   20/1500	20/1700		21/0100		 		
12	0150W	CNTAO	Oct   21/1700	21/1800		22/0600		 		
-----------------------------------------------------------------------------------------------------
     */
    /**
     * Groupware(Board)에 들어갈 내용을 Text 형식으로 반환한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWBoardContents(sheetObj, formObj){
    	var contents = "### [" + glbMainVslSlanCd + "] M/V " + glbMainVslEngNm + " " + glbMainSkdVoyNo + glbMainSkdDirCd + " Coastal Schedule ###\n";
    	contents = contents + "Lane : " + glbMainVslSlanCd + "\n \n";
    	contents = contents + getGWBoardDetailContents(sheetObj);
    	return contents;
    }
    
    /**
     * Groupware(Board)에 들어갈 상세내용을 Text 형식으로 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getGWBoardDetailContents(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt = getTotalRowCnt(sheetObj);
    	var rowCnt = sheetObj.RowCount;
    	var colCnt = sheetObj.LastCol;
    	
    	var contents = "";
    	
    	if(rowCnt > 0){
//			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
//    		contents = contents + ComRpad("SEQ", 4, " ");
    		contents = contents + ComRpad("VoyNo.", 7, " ");
    		contents = contents + ComRpad("Port", 7, " ");
    		contents = contents + ComRpad("ETA", 18, " ");
    		contents = contents + ComRpad("ETB", 18, " ");
    		contents = contents + ComRpad("ETD", 18, " ");
    		contents = contents + ComRpad("Status", 16, " ");
    		contents = contents + "Remark\n";
    		contents = contents + ComRpad("-", 92, "-") + "\n";
    		
    		for(var i=headCnt; i<=totCnt; i++){
    			
    			/* 
				 * 변경 : 20100720_01
				 * OLD : 
				 * NEW : 1. SKIP PORT는 스케쥴을 표시하지 않도록 변경.
				 * 		 2. change status가 있는 경우, 표시. change status가 없고 지연 시간이 12시간 이상인 경우 Delay Hour를 status에 표시
				 */
    			
//    			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
//    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"clpt_seq"), 4, " ");
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"skd_voy_no") + sheetObj.CellValue(i, prefix+"skd_dir_cd"), 7, " ");
    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"vps_port_cd"), 7, " ");
    			
    			if("S" == sheetObj.CellValue(i, prefix + "skd_cng_sts_cd")){
    				contents = contents + ComRpad("", 18, " ");
    				contents = contents + ComRpad("", 18, " ");
    				contents = contents + ComRpad("", 18, " ");
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"skd_cng_sts_cd"), 16, " ");
    			} else {
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_eta_dt"), 18, " ");
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etb_dt"), 18, " ");
    				contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etd_dt"), 18, " ");
    				if("" == sheetObj.CellValue(i, prefix + "skd_cng_sts_cd")){
    					// total delay hour 구함
    					var delayHours = sheetObj.CellValue(i, prefix + "dlay_date_text");
    					if("" == delayHours){
    						contents = contents + ComRpad("", 16, " ");
    					}else{
    						// total delay hour가 12시간 이상이면 게시판에 표기한다.
    						var day = delayHours.substring(0, delayHours.indexOf("D"));
    						var hours = delayHours.substring(delayHours.indexOf("-")+1, delayHours.indexOf("H"));
    						if(ComParseInt(day)>=1 || ComParseInt(hours)>=12){
    							contents = contents + ComRpad("DELAY " + delayHours, 16, " ");
    						}else{
    							contents = contents + ComRpad("", 16, " ");
    						}
    					}
    				}else{
    					contents = contents + ComRpad(sheetObj.CellText(i, prefix+"skd_cng_sts_cd"), 16, " ");
    				}
    			}
    			
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_eta_dt"), "ymdhm"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etb_dt"), "ymdhm"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etd_dt"), "ymdhm"), 20, " ");
    			
    			contents = contents + sheetObj.CellValue(i, prefix+"vps_rmk") + "\n";
    		}// end for
    		
    		contents = contents + ComRpad("-", 92, "-") + "\n";
    	}
    	
    	return contents;
    }
    
    
	/*
	 * =====================================================================
	 * Sheet Control
	 * =====================================================================
	 */
	
	/**
	 * Sheet의 Terminal Combo Data Setting...
	 * @param xmlStr
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
		var prefix = sheetObj.id + "_";
		var ydKindCode = " |" + ComGetEtcData(xmlStr, "yd_kind");
		var ydNm = " |" + ComGetEtcData(xmlStr, "yd_nm");
		var ydTxt = "";
		
		if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
			var ydKindCodeArr = ydKindCode.split("|");
			var ydNmArr = ydNm.split("|");
			var ydCnt = ydKindCodeArr.length;
			
			ydTxt = ydKindCodeArr[0] + "\t" + ydNmArr[0];
			for(var i=1; i<ydCnt; i++){
				ydTxt = ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
			}
			
			sheetObj.CellComboItem(Row, prefix+"tml_cd", ydTxt, ydKindCode);
// 			sheetObj.CellValue2(Row, prefix+"tml_cd") = ydNmArr[0];
		}
	}
	
	/**
	 * Sheet의 Terminal Combo Data Clear...
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetClearCombo(sheetObj, Row, Col){
		sheetObj.CellComboItem(Row, sheetObj.id+"_tml_cd", "", "");
	}
	
	/**
	 * Sheet의 Font Color를 Back Color로 변경.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function cellFontToBackColor(sheetObj, Row, Col){
		//화면에 나타나지 않는 Cell 들은 적용이 안되니 해당 Cell 로 Focus 를 이동 시킨 후 Font/Back Color 변경.
		sheetObj.SelectCell(Row, Col);
		sheetObj.CellFontColor(Row, Col) = sheetObj.CellBackColor(Row, Col);
	}
	
	/**
	 * Sheet의 Font Color를 기본 Font Color로 변경.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetFontToOriginColor(sheetObj, Row, Col){
		//화면에 나타나지 않는 Cell 들은 적용이 안되니 해당 Cell 로 Focus 를 이동 시킨 후 Font/Back Color 변경.
		sheetObj.SelectCell(Row, Col);
		sheetObj.CellFontColor(Row, Col) = sheetObj.RgbColor(0, 0, 0);
	}
	
	/**
	 * Expand / Hidden 상태값을 리턴한다.
	 * @param sheetObj
	 * @return
	 */
	function isHiddenState(sheetObj){
		var prefix = sheetObj.id + "_";
		var isColHidden = true;
		
		if(sheetObj.id == "sheet1"){
			isColHidden = sheetObj.ColHidden(prefix+"lnk_dist");
		}else{
			isColHidden = sheetObj.ColHidden(prefix+"ib_cgo_qty");
		}
		
		return isColHidden;
	}
	
	/**
	 * 선택된 2개의 Row의 데이타를 맞바꾼다.
	 * @param sheetObj
	 * @return
	 */
	function rowDataChange(sheetObj){
		var prefix = sheetObj.id + "_";
		var sRow = sheetObj.SelectRow;
		var headCnt = sheetObj.HeaderRows;
		
		var selRows = sheetObj.GetSelectionRows("|").split("|");
		if(selRows.length != 2){
			return false;
		}
		
		//Column Count
		var colCnt = sheetObj.LastCol;
		
		var vvd1 = sheetObj.CellValue(selRows[0], prefix+"vvd");
		var vvd2 = sheetObj.CellValue(selRows[1], prefix+"vvd");
		// VVD 가 다르면 Reverse 막음.
		if(vvd1 != vvd2){
			return false;
		}
		
		var chgStsCd1 = sheetObj.CellValue(selRows[0], prefix+"skd_cng_sts_cd");
		var chgStsCd2 = sheetObj.CellValue(selRows[1], prefix+"skd_cng_sts_cd");

//		if(chgStsCd1 == "R" && chgStsCd2 == "R"){
//			sheetObj.CellValue2(selRows[0], prefix+"skd_cng_sts_cd") = sheetObj.CellValue(selRows[0], prefix+"tmp_cng_sts_cd");
//			sheetObj.CellValue2(selRows[1], prefix+"skd_cng_sts_cd") = sheetObj.CellValue(selRows[1], prefix+"tmp_cng_sts_cd");
//		}else if(chgStsCd1 != "R" && chgStsCd2 != "R"){
//			sheetObj.CellValue2(selRows[0], prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(selRows[0], prefix+"skd_cng_sts_cd");
//			sheetObj.CellValue2(selRows[1], prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(selRows[1], prefix+"skd_cng_sts_cd");
//			sheetObj.CellValue2(selRows[0], prefix+"skd_cng_sts_cd") = "R";
//			sheetObj.CellValue2(selRows[1], prefix+"skd_cng_sts_cd") = "R";
//		}else{
//			return false;
//		}
		
		yardCngFlg = "N";
		
		var tempData = "";
		// 선택된 2개 Row 의 Data 를 바꾼다.
		for(var i=0; i<colCnt; i++){
			if(sheetObj.ColSaveName(i) == prefix+"tml_cd"){
				var sText1 = sheetObj.GetComboInfo(selRows[0], i, "Text");
				var sText2 = sheetObj.GetComboInfo(selRows[1], i, "Text");
				var sCode1 = sheetObj.GetComboInfo(selRows[0], i, "Code");
				var sCode2 = sheetObj.GetComboInfo(selRows[1], i, "Code");
				var sVal1 = sheetObj.CellValue(selRows[0], i);
				var sVal2 = sheetObj.CellValue(selRows[1], i);
				sheetObj.CellComboItem(selRows[0], i, sText2, sCode2);
				sheetObj.CellComboItem(selRows[1], i, sText1, sCode1);
				sheetObj.CellValue2(selRows[0], i) = sVal2;
				sheetObj.CellValue2(selRows[1], i) = sVal1;
			}else{
				tempData = sheetObj.CellValue(selRows[0], i);
				sheetObj.CellValue2(selRows[0], i) = sheetObj.CellValue(selRows[1], i);
				sheetObj.CellValue2(selRows[1], i) = tempData;
			}
		}
		
		//sheet1일 경우 Updated Status Color 변경
		if(sheetObj.id == "sheet1"){
			with(sheetObj){
				for(var i=0; i<selRows.length; i++){
					if(CellValue(selRows[i], prefix+"upd_sts") == "Actual"){
		    			CellBackColor(selRows[i], prefix+"upd_sts") = glbActualColor;
		    		} else if (CellValue(selRows[i], prefix+"upd_sts") == "HQ/RSO") {
		    			CellBackColor(selRows[i], prefix+"upd_sts") = glbHQColor;
			    	} else if (CellValue(selRows[i], prefix+"upd_sts") == "Noon") {
		    			CellBackColor(selRows[i], prefix+"upd_sts") = glbNoonColor;
			    	} else if (CellValue(selRows[i], prefix+"upd_sts") == "Departure") {
		    			CellBackColor(selRows[i], prefix+"upd_sts") = glbDepartureColor;
			    	} else if (CellValue(selRows[i], prefix+"upd_sts") == "Initial") {
		    			CellBackColor(selRows[i], prefix+"upd_sts") = glbInitialColor;
		    		}
				}
			}
			
			//Yard 변경 여부 Change
			var tpVal1 = glbSkdPortFlgs[selRows[0] - headCnt];
			var tpVal2 = glbSkdPortFlgs[selRows[1] - headCnt];
			glbSkdPortFlgs[selRows[0] - headCnt] = tpVal2;
			glbSkdPortFlgs[selRows[1] - headCnt] = tpVal1;
		}else{
			//Yard 변경 여부 Change
			var tpVal1 = glbPlanPortFlgs[selRows[0] - headCnt];
			var tpVal2 = glbPlanPortFlgs[selRows[1] - headCnt];
			glbPlanPortFlgs[selRows[0] - headCnt] = tpVal2;
			glbPlanPortFlgs[selRows[1] - headCnt] = tpVal1;
		}
		
		// P/F Date 삭제.
		sheetObj.CellValue2(selRows[0], prefix+"pf_eta_dt") = "";
		sheetObj.CellValue2(selRows[0], prefix+"pf_etb_dt") = "";
		sheetObj.CellValue2(selRows[0], prefix+"pf_etd_dt") = "";
		sheetObj.CellValue2(selRows[1], prefix+"pf_eta_dt") = "";
		sheetObj.CellValue2(selRows[1], prefix+"pf_etb_dt") = "";
		sheetObj.CellValue2(selRows[1], prefix+"pf_etd_dt") = "";
		
		sheetObj.SelectCell(selRows[1], sheetObj.SelectCol);
		
		var sXml = doCallBaseInfo(sheetObj, selRows[0], "REVERSE", selRows[1]);
// 		sheetObj.Redraw = true;
		// Dist 및 Sea Time을 새로 셋팅함.
		setBaseInfo(sheetObj, sXml, selRows[0], "REVERSE", selRows[1]);
		
		// clpt_seq 새로 부여.
		resetClptSeq(sheetObj);
		resetClptIndSeq(sheetObj);
		
// 		sheetObj.Redraw = true;
		
		return true;
	}
	
	/**
	 * 각 이벤트별 스케줄 생성에 필요한 기본 데이타를 재계산 한다.
	 * 
	 * @param sheetObj
	 * @param sXml
	 * @param sRow
	 * @param evtFlg
	 * @param eRow
	 * @return
	 */
	function setBaseInfo(sheetObj, sXml, sRow, evtFlg, eRow){
		var stndDist = ComGetEtcData(sXml, "stnd_dist");	// Dist
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		
		if(evtFlg == "SKIP"){
			if(sRow > headCnt){
				if(sheetObj.id == "sheet2"){
					var tsRow = getTsPortRow(sheetObj, sRow);
					sheetObj.CellValue2(tsRow, prefix+"tml_hndl_20ft_unit_amt") = ComGetEtcData(sXml, "tml_hndl_20ft_unit_amt");
					sheetObj.CellValue2(tsRow, prefix+"tml_hndl_40ft_unit_amt") = ComGetEtcData(sXml, "tml_hndl_40ft_unit_amt");
					sheetObj.CellValue2(tsRow, prefix+"tml_hndl_20ft_ttl_qty") = ComGetEtcData(sXml, "tml_hndl_20ft_ttl_qty");
					sheetObj.CellValue2(tsRow, prefix+"tml_hndl_40ft_ttl_qty") = ComGetEtcData(sXml, "tml_hndl_40ft_ttl_qty");
					sheetObj.CellValue2(tsRow, prefix+"tml_hndl_20ft_ttl_amt") = Number(sheetObj.CellValue(tsRow, prefix+"tml_hndl_20ft_unit_amt")) * Number(sheetObj.CellValue(tsRow, prefix+"tml_hndl_20ft_ttl_qty"));
					sheetObj.CellValue2(tsRow, prefix+"tml_hndl_40ft_ttl_amt") = Number(sheetObj.CellValue(tsRow, prefix+"tml_hndl_40ft_unit_amt")) * Number(sheetObj.CellValue(tsRow, prefix+"tml_hndl_40ft_ttl_qty"));
					sheetObj.CellValue2(sRow, prefix+"pe_usd_ttl_amt") = ComGetEtcData(sXml, "ttl_chg_amt");
				}
				
				var startRow = getNotSkipRow(sheetObj, sRow, "P");
    			if(startRow > 0){
					sheetObj.CellValue2(startRow, prefix+"lnk_dist") = stndDist;
					sheetObj.CellBackColor(startRow, prefix+"lnk_dist") = glbTestColor;
					
					var spd = sheetObj.CellValue(startRow, prefix+"lnk_spd");
					sheetObj.CellValue2(startRow, prefix+"tztm_hrs") = Math.round(Number(stndDist) / Number(spd));
					sheetObj.CellBackColor(startRow, prefix+"tztm_hrs") = glbTestColor;
    			}
    			
    			if(sheetObj.id == "sheet2"){
	    			// Bunker Additional Cost
	    			calcBunkerAdditionalCostBySkip(sheetObj, sRow);
	    			
	    			calcTotalCost(sheetObj);
    			}
			}
			
		}else if(evtFlg == "SKIP_CANCEL" || evtFlg == "ADD_CANCEL"){
			if(sRow > headCnt){
				var startRow = getNotSkipRow(sheetObj, sRow, "P");
    			if(startRow > 0){
					sheetObj.CellValue2(startRow, prefix+"lnk_dist") = stndDist;
					sheetObj.CellBackColor(startRow, prefix+"lnk_dist") = glbTestColor;
					
					var spd = sheetObj.CellValue(startRow, prefix+"lnk_spd");
					sheetObj.CellValue2(startRow, prefix+"tztm_hrs") = Math.round(Number(stndDist) / Number(spd));
					sheetObj.CellBackColor(startRow, prefix+"tztm_hrs") = glbTestColor;
    			}
			}
		}else if(evtFlg == "ADD" || evtFlg == "PORT_CHANGE"){
			var portCd = sheetObj.CellValue(sRow, prefix+"vps_port_cd");
			if(portCd != null && portCd != undefined && portCd != ""){
				if(sheetObj.id == "sheet2"){
					sheetObj.CellValue2(sRow, prefix+"pe_usd_ttl_amt") = ComGetEtcData(sXml, "ttl_chg_amt");
				}
				
				var xmlSpd = ComGetEtcData(sXml, "lnk_spd");
				var xmlSeaTime = ComGetEtcData(sXml, "tztm_hrs");
				var xmlTimeDiff = ComGetEtcData(sXml, "time_diff");
				var xmlMnvrInHrs = ComGetEtcData(sXml, "mnvr_in_hrs");
				var xmlMnvrOutHrs = ComGetEtcData(sXml, "mnvr_out_hrs");
				var xmlCrnKnt = ComGetEtcData(sXml, "crn_knt");
				var xmlTmlProdQty = ComGetEtcData(sXml, "tml_prod_qty");
				var xmlPortBufHrs = ComGetEtcData(sXml, "port_buf_hrs");
				
				sheetObj.CellValue2(sRow, prefix+"lnk_spd") = xmlSpd;
				sheetObj.CellValue2(sRow, prefix+"time_diff") = xmlTimeDiff;
				sheetObj.CellValue2(sRow, prefix+"mnvr_in_hrs") = xmlMnvrInHrs;
				sheetObj.CellValue2(sRow, prefix+"mnvr_out_hrs") = xmlMnvrOutHrs;
				sheetObj.CellValue2(sRow, prefix+"crn_knt") = xmlCrnKnt;
				sheetObj.CellValue2(sRow, prefix+"tml_prod_qty") = xmlTmlProdQty;
				sheetObj.CellValue2(sRow, prefix+"sea_buf_hrs") = "0";
				sheetObj.CellValue2(sRow, prefix+"port_buf_hrs") = xmlPortBufHrs;
// 				===========================================================
				sheetObj.CellBackColor(sRow, prefix+"lnk_spd") = glbTestColor;
				sheetObj.CellBackColor(sRow, prefix+"time_diff") = glbTestColor;
				sheetObj.CellBackColor(sRow, prefix+"mnvr_in_hrs") = glbTestColor;
				sheetObj.CellBackColor(sRow, prefix+"mnvr_out_hrs") = glbTestColor;
				sheetObj.CellBackColor(sRow, prefix+"crn_knt") = glbTestColor;
				sheetObj.CellBackColor(sRow, prefix+"tml_prod_qty") = glbTestColor;
// 				sheetObj.CellBackColor(sRow, prefix+"act_wrk_hrs") = glbTestColor;
				sheetObj.CellBackColor(sRow, prefix+"port_buf_hrs") = glbTestColor;
// 				===========================================================
				var stndDists = stndDist.split("|");
				if(stndDists.length > 0){
					//skip한 row는 건너뛰고 skip한 건이 있으면 skip한 건만큼 루프를 더 실행한다.
					var skipCnt = 0;
					for(var i=0; i<stndDists.length+skipCnt; i++){
						if(sheetObj.CellValue(sRow+i-1, prefix+"skd_cng_sts_cd") == "S"){
							skipCnt++;
						}else{
							if(sRow > headCnt){
								sheetObj.CellValue2(sRow+i-1, prefix+"lnk_dist") = stndDists[i-skipCnt];
								sheetObj.CellBackColor(sRow+i-1, prefix+"lnk_dist") = glbTestColor;
								
								var spd = sheetObj.CellValue(sRow+i, prefix+"lnk_spd");
								if(spd != null && spd != undefined && spd != "" && spd != 0){
									if(stndDists[i-skipCnt] == null || stndDists[i-skipCnt] == undefined || stndDists[i-skipCnt] == ""){
										sheetObj.CellValue2(sRow+i-1, prefix+"tztm_hrs") = "0";
									}else{
										sheetObj.CellValue2(sRow+i-1, prefix+"tztm_hrs") = Math.round(stndDists[i-skipCnt] / spd);
									}
									sheetObj.CellBackColor(sRow+i-1, prefix+"tztm_hrs") = glbTestColor;
								}else{
									sheetObj.CellValue2(sRow+i-1, prefix+"tztm_hrs") = "0";
									sheetObj.CellBackColor(sRow+i-1, prefix+"tztm_hrs") = glbTestColor;
								}
							}else{
								sheetObj.CellValue2(sRow+i, prefix+"lnk_dist") = stndDists[i-skipCnt];
								sheetObj.CellBackColor(sRow+i, prefix+"lnk_dist") = glbTestColor;
								
								var spd = sheetObj.CellValue(sRow+i, prefix+"lnk_spd");
								if(spd != null && spd != undefined && spd != "" && spd != 0){
									if(stndDists[i-skipCnt] == null || stndDists[i-skipCnt] == undefined || stndDists[i-skipCnt] == ""){
										sheetObj.CellValue2(sRow+i, prefix+"tztm_hrs") = "0";
									}else{
										sheetObj.CellValue2(sRow+i, prefix+"tztm_hrs") = Math.round(stndDists[i-skipCnt] / spd);
									}
									sheetObj.CellBackColor(sRow+i, prefix+"tztm_hrs") = glbTestColor;
								}else{
									sheetObj.CellValue2(sRow+i, prefix+"tztm_hrs") = "0";
									sheetObj.CellBackColor(sRow+i, prefix+"tztm_hrs") = glbTestColor;
								}
							}
						}
					}
				}
				
				if(sheetObj.id == "sheet2"){
	    			calcTotalCost(sheetObj);
    			}
			}
		}else if(evtFlg == "REVERSE"){
			if(sRow > sheetObj.HeaderRows){
				var sStartRow = getNotSkipRow(sheetObj, sRow, "P");
				var sEndRow = getNotSkipRow(sheetObj, sRow, "N");
				var eStartRow = getNotSkipRow(sheetObj, eRow, "P");
				var eEndRow = getNotSkipRow(sheetObj, eRow, "N");

    			if(sStartRow > 0 && eEndRow > 0){
    				var stndDists = stndDist.split("|");
    				var spd = "";
    				if(stndDists.length > 0){
    					sheetObj.CellValue2(sStartRow, prefix+"lnk_dist") = stndDists[0];
    					sheetObj.CellBackColor(sStartRow, prefix+"lnk_dist") = glbTestColor;
    					
    					spd = sheetObj.CellValue(sStartRow, prefix+"lnk_spd");
    					sheetObj.CellValue2(sStartRow, prefix+"tztm_hrs") = Number(stndDists[0]) / Number(spd);
    					sheetObj.CellBackColor(sStartRow, prefix+"tztm_hrs") = glbTestColor;
    					
    					sheetObj.CellValue2(sRow, prefix+"lnk_dist") = stndDists[1];
    					sheetObj.CellBackColor(sRow, prefix+"lnk_dist") = glbTestColor;

    					spd = sheetObj.CellValue(sRow, prefix+"lnk_spd");
    					sheetObj.CellValue2(sRow, prefix+"tztm_hrs") = Number(stndDists[1]) / Number(spd);
    					sheetObj.CellBackColor(sRow, prefix+"tztm_hrs") = glbTestColor;
    					
    					sheetObj.CellValue2(eStartRow, prefix+"lnk_dist") = stndDists[2];
    					sheetObj.CellBackColor(eStartRow, prefix+"lnk_dist") = glbTestColor;
    					
    					spd = sheetObj.CellValue(eStartRow, prefix+"lnk_spd");
    					sheetObj.CellValue2(eStartRow, prefix+"tztm_hrs") = Number(stndDists[2]) / Number(spd);
    					sheetObj.CellBackColor(eStartRow, prefix+"tztm_hrs") = glbTestColor;
    					
    					sheetObj.CellValue2(eRow, prefix+"lnk_dist") = stndDists[3];
    					sheetObj.CellBackColor(eRow, prefix+"lnk_dist") = glbTestColor;
    					
    					spd = sheetObj.CellValue(eRow, prefix+"lnk_spd");
    					sheetObj.CellValue2(eRow, prefix+"tztm_hrs") = Number(stndDists[3]) / Number(spd);
    					sheetObj.CellBackColor(eRow, prefix+"tztm_hrs") = glbTestColor;
    				}
    			}
			}
		}
	}
	
	/**
	 * Skip한 Row의 정보를 담아 리턴.
	 * @param sheetObj
	 * @return
	 */
	function getSkipPortRows(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		
		var skipRows = new Array();
		var idx = 0;
		
		for(var i=headCnt; i<totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
				skipRows[idx] = i;
				idx++;
			}
		}
		
		return skipRows;
	}
	
	/**
	 * 입력받은 Row의 TS Port 를 찾아 해당 Row 를 반환한다.
	 * 
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function getTsPortRow(sheetObj, sRow){
//		sheetObj.CellValue2(i, prefix+"ts_port_cd") = rtnDatas[13];				// ts_port_cd
//		sheetObj.CellValue2(i, prefix+"ts_skd_voy_no") = rtnDatas[14];			// ts_skd_voy_no
//		sheetObj.CellValue2(i, prefix+"ts_skd_dir_cd") = rtnDatas[15];			// ts_skd_dir_cd
//		sheetObj.CellValue2(i, prefix+"ts_clpt_ind_seq") = rtnDatas[16];		// ts_clpt_ind_seq
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		
		var tsSkdVoyNo = sheetObj.CellValue(sRow, prefix+"ts_skd_voy_no");
		var tsSkdDirCd = sheetObj.CellValue(sRow, prefix+"ts_skd_dir_cd");
		var tsPortCd = sheetObj.CellValue(sRow, prefix+"ts_port_cd");
		var tsClptIndSeq = sheetObj.CellValue(sRow, prefix+"ts_clpt_ind_seq");
		
		for(var i=headCnt; i<totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"skd_voy_no") == tsSkdVoyNo
					&& sheetObj.CellValue(i, prefix+"skd_dir_cd") == tsSkdDirCd
					&& sheetObj.CellValue(i, prefix+"vps_port_cd") == tsPortCd
					&& sheetObj.CellValue(i, prefix+"clpt_ind_seq") == tsClptIndSeq){
				return i;
			}
		}
		return sRow+1;
	}
	
	/**
	 * Skip 상태인 Row의 Font Color Setting.
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		var formObj = document.form;
		
		/*
		 * Hidden Col이 있으면 임시로 펼친다. 
		 * 숨겨진 필드가 있으면 font color 및 back color 가 변경이 안되므로 숨겨진 필드가 있으면 임시로 펼친 후 로직이 다 실행되면 다시 닫는다.
		 */
		var isColHidden = isHiddenState(sheetObj);
		if(isColHidden){
			showFieldControl(sheetObj, formObj, true);
		}
		
		// sheet1, sheet2 공통
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
// 		cellFontToBackColor(sheetObj, sRow, prefix+"delay_date");
		cellFontToBackColor(sheetObj, sRow, prefix+"dlay_date_text");
		cellFontToBackColor(sheetObj, sRow, prefix+"sea_date_text");
		cellFontToBackColor(sheetObj, sRow, prefix+"vsl_dlay_rsn_cd");
		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_dist");
		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_spd");
		cellFontToBackColor(sheetObj, sRow, prefix+"tztm_hrs");
		cellFontToBackColor(sheetObj, sRow, prefix+"act_wrk_hrs");
		cellFontToBackColor(sheetObj, sRow, prefix+"port_buf_hrs");
		cellFontToBackColor(sheetObj, sRow, prefix+"sea_buf_hrs");
		
		// sheet2 전용
		if(glbSheetFlg == "sheet2"){
			cellFontToBackColor(sheetObj, sRow, prefix+"time_diff");
			cellFontToBackColor(sheetObj, sRow, prefix+"mnvr_in_hrs");
			cellFontToBackColor(sheetObj, sRow, prefix+"mnvr_out_hrs");
			cellFontToBackColor(sheetObj, sRow, prefix+"crn_knt");
			cellFontToBackColor(sheetObj, sRow, prefix+"tml_prod_qty");
			cellFontToBackColor(sheetObj, sRow, prefix+"ib_cgo_qty");
			cellFontToBackColor(sheetObj, sRow, prefix+"ob_cgo_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"add_bnk_csm_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"add_bnk_cost_amt");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_20ft_ttl_qty");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_40ft_ttl_qty");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_20ft_ttl_amt");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_40ft_ttl_amt");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_amt");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_amt");
		}
		
		if(isColHidden){
			showFieldControl(sheetObj, formObj, false);
		}
	}
	
	/**
	 * Total Row 를 제외한 LastRow 의 Index 를 반환한다.
	 * @param sheetObj
	 * @return
	 */
	function getTotalRowCnt(sheetObj){
		var totCnt = sheetObj.LastRow;
		
		if(sheetObj.id == "sheet2"){
			totCnt = sheetObj.LastRow - 1;
		}
		
		return totCnt;
	}
	
	/**
	 * dateFlg(ETA/ETB/ETD) 에 따른 P/F 날짜를 판단하여 해당 Column Name 을 반환한다.
	 * P/F 날짜가 Null 이면 InitDate 를 반환.
	 * 
	 * @param sheetObj
	 * @param dateFlg
	 * @return
	 */
	function getPfDateColName(sheetObj, Row, dateFlg){
		var prefix = sheetObj.id + "_";
		var pfDate = "";
		var pfDtColNm = "";
		
		if(dateFlg == "ETA"){
			pfDate = sheetObj.CellValue(Row, prefix+"pf_eta_dt");
			pfDtColNm = prefix+"pf_eta_dt";
			if(pfDate == null || pfDate == undefined || pfDate == ""){
				pfDtColNm = prefix+"init_eta_dt";
			}
		}else if(dateFlg == "ETB"){
			pfDate = sheetObj.CellValue(Row, prefix+"pf_etb_dt");
			pfDtColNm = prefix+"pf_etb_dt";
			if(pfDate == null || pfDate == undefined || pfDate == ""){
				pfDtColNm = prefix+"init_etb_dt";
			}
		}else if(dateFlg == "ETD"){
			pfDate = sheetObj.CellValue(Row, prefix+"pf_etd_dt");
			pfDtColNm = prefix+"pf_etd_dt";
			if(pfDate == null || pfDate == undefined || pfDate == ""){
				pfDtColNm = prefix+"init_etd_dt";
			}
		}
		
		return pfDtColNm;
	}
	
	/*
	 * =====================================================================
	 * Etc Function...
	 * =====================================================================
	 */
	
//	/**
//	 * Kts(단위시간당 Speed만큼의 bnk 소모량) = Kh * Math.Pow( Speed / (1 - ( Slip / 100 )), 3) * 24
//	 * Kh = FOC(/Hrs) / Math.Pow(Spd(P), 3)
//	 */
//	function calcBunkerAdditionalCost(sheetObj, Row, lnkSpd){
//		/*
//		 * var foc_hr = 3.96;
//		 * var spd_p = 23;
//		 * var slip = 11.3;
//		 * var lnk_spd = 23;
//		 * 
//		 * var a = foc_hr/Math.pow(spd_p, 3);
//		 * var b = Math.pow(lnk_spd / (1 - (slip/100)), 3) * 24;
//		 */
//		var kh = glbFocHr / Math.pow(glbSpdP, 3);
//		var kts = kh * (Math.pow(lnkSpd / (1 - (glbSlip / 100)), 3) * 24);
//		var ktsRnd = Math.round(kts * 10) * 0.1;
//	}
	
	/**
	 * Speed 변경 시 해당 Port의 Speed 변경되기 전,후의 Bunker 량 및 가격정보 계산.<br>
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param formObj
	 * @return
	 */
	function calcBunkerAdditionalCostBySpeed(sheetObj, Row, formObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		
		if(Row < sheetObj.LastRow){
			var nextRow = getNotSkipRow(sheetObj, Row, "N");
			if(nextRow > 0){
				var preEtdDt = sheetObj.CellValue(Row, prefix+"vps_etd_dt");
				var nxtEtaDt = sheetObj.CellValue(nextRow, prefix+"vps_eta_dt");
				
				var dateObj = new Usr_CalcTimeSet(preEtdDt);
				var timeDiff = parseInt(dateObj.getTimeDiff(nxtEtaDt), 10);
				
				var bnkUnitQty = sheetObj.CellValue(Row, prefix+"bnk_unit_qty");
				var bnkUnitAmt = sheetObj.CellValue(Row, prefix+"bnk_unit_amt");
				
				var bnkTotQty = Number(bnkUnitQty) * Number(timeDiff);
				var bnkTotAmt = Number(bnkTotQty) * Number(bnkUnitAmt);
				
				// spd 가 변경된 후의 Unit Bunker 양을 구함.
				formObj.spd.value = sheetObj.CellValue(Row, prefix+"lnk_spd");
				var bnkXml = doActionIBSheet(sheetObj, formObj ,SEARCH04);
				
				var addBnkUnitQty = ComGetEtcData(bnkXml, "bnk_unit_qty");
				
				var addBnkCsmQty = Number(addBnkUnitQty) * Number(timeDiff);
				var addBnkCostAmt = Number(addBnkCsmQty) * Number(bnkUnitAmt);
				
				sheetObj.CellValue2(Row, prefix+"add_bnk_csm_qty") = addBnkCsmQty - bnkTotQty;
				sheetObj.CellValue2(Row, prefix+"add_bnk_cost_amt") = addBnkCostAmt - bnkTotAmt;
				
				// 변경 된 후의 Bunker 정보를 Setting.
				sheetObj.CellValue2(Row, prefix+"bnk_unit_qty") = addBnkUnitQty;
				sheetObj.CellValue2(Row, prefix+"bnk_tot_qty") = addBnkCsmQty;
				sheetObj.CellValue2(Row, prefix+"bnk_tot_amt") = addBnkCostAmt;
			}
		}
	}
	
	/**
	 * Skip 발생 시 해당 Port의 Bunker 관련 정보 계산.
	 * 
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function calcBunkerAdditionalCostBySkip(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		
		var prePortRow = getNotSkipRow(sheetObj, sRow, "P");
		var nxtPortRow = getNotSkipRow(sheetObj, sRow, "N");
		var preEtdDt = sheetObj.CellValue(prePortRow, prefix+"vps_etd_dt");
		var nxtEtaDt = sheetObj.CellValue(sRow, prefix+"vps_eta_dt");
		
		var dateObj = new Usr_CalcTimeSet(preEtdDt);
		var timeDiff = parseInt(dateObj.getTimeDiff(nxtEtaDt), 10);

		var bnkUnitQty = sheetObj.CellValue(prePortRow, prefix+"bnk_unit_qty");
		var bnkUnitAmt = sheetObj.CellValue(prePortRow, prefix+"bnk_unit_amt");
		
		var bnkTotQty = Number(bnkUnitQty) * Number(timeDiff);
		var bnkTotAmt = Number(bnkTotQty) * Number(bnkUnitAmt);
		
		// 현재 Bunker 양을 구함.
		sheetObj.CellValue2(prePortRow, prefix+"bnk_tot_qty") = bnkTotQty;
		// 현재 Bunker Cost를 구함.
		sheetObj.CellValue2(prePortRow, prefix+"bnk_tot_amt") = bnkTotAmt;
		
		if(sRow < sheetObj.LastRow){
			//Skip 이후의 ETA를 찾아서 시간차이를 다시 구함.
			nxtEtaDt = sheetObj.CellValue(nxtPortRow, prefix+"vps_eta_dt");
			timeDiff = parseInt(dateObj.getTimeDiff(nxtEtaDt), 10);
			
			var addBnkCsmQty = Number(bnkUnitQty) * Number(timeDiff);
			var addBnkCostAmt = Number(addBnkCsmQty) * Number(bnkUnitAmt);
			
			sheetObj.CellValue2(prePortRow, prefix+"add_bnk_csm_qty") = bnkTotQty - addBnkCsmQty;
			sheetObj.CellValue2(prePortRow, prefix+"add_bnk_cost_amt") = bnkTotAmt - addBnkCostAmt;
		}
	}
	
	/**
	 * Total Cost 를 계산한다.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function calcTotalCost(sheetObj){
		if(sheetObj.id == "sheet2"){
			var prefix = sheetObj.id + "_";
			var headCnt = sheetObj.HeaderRows;
			var totCnt = getTotalRowCnt(sheetObj);
			
			for(var i=headCnt; i<=totCnt; i++){
				sheetObj.CellValue2(i, prefix+"total_cost") = Number(sheetObj.CellValue(i, prefix+"add_bnk_cost_amt"))
															+ Number(sheetObj.CellValue(i, prefix+"tml_hndl_20ft_ttl_amt"))
															+ Number(sheetObj.CellValue(i, prefix+"tml_hndl_40ft_ttl_amt"))
															+ Number(sheetObj.CellValue(i, prefix+"pe_usd_ttl_amt"));
			}
		}
	}
	
	/*
	 * CHM-201005617-01 Coastal SKD Update 로직 변경
	 * CHM-201006456-01 SKD Auto Update 기능 보완
	 */
	/**
	 * ETA, ETB, ETD 변경 시 스케줄 조정 로직. 
	 * lnk_dist
	 * lnk_spd
	 * tztm_hrs(sea_time)
	 * act_wrk_hrs(port_time)
	 * port_buf_hrs
	 * sea_buf_hrs
	 * mnvr_in_hrs
	 * mnvr_out_hrs
	 * --------------------------------------------------------------------------
	 * ETB = ETA + mnvr_in_hrs 
	 * ETD = ETB + act_wrk_hrs(port_time) + port_buf_hrs
	 * ETA = ETD(Pre) + mnvr_out_hrs + tztm_hrs(sea_time) + sea_buf_hrs + (GMT = B_GMT - A_GMT)
	 */
	function calcSchedule(sheetObj, Row, Col, isChangedPF){
		
		var colName = sheetObj.ColSaveName(Col);
		var prefix = sheetObj.id + "_";
		var haederCnt = sheetObj.HeaderRows ;
		var bodyCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		var skipCnt = 0;
		
		var etaAddDate = null;
		var etbAddDate = null;
		var etdAddDate = null;
		
		var etaDate = null;
		var etbDate = null;
		var etdDate = null;
		
		var etaDelayTime = 0;
		var etbDelayTime = 0;
		var etdDelayTime = 0;
		
		var seaTime = 0.0;
		var portTime = 0.0;
		
		var isAdvanced = false;
		
		// C/SKD Update 시트인 경우 Expand 버튼에 의해 확장된 상태에서만 auto update가 된다.
		if(sheetObj.id=="sheet1" && sheetObj.ColHidden(prefix+"lnk_dist")){
			return;
		}
		
		if(colName == prefix+"vps_eta_dt"){
			
			if(!isChangedPF){
				// PF가 아닌 스케줄 정보가 변경된 경우 현재 포트 ETA Delay/Advance 에 따라 색깔 변경
				//if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") == sheetObj.CellValue(Row, prefix+"pf_eta_dt")){
				if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") == sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, "ETA"))){
					sheetObj.CellFontColor(Row, prefix+"vps_eta_dt") = glbNormalFontColor;
					isAdvanced = true;
				//}else if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") < sheetObj.CellValue(Row, prefix+"pf_eta_dt")){
				}else if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") < sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, "ETA"))){
					sheetObj.CellFontColor(Row, prefix+"vps_eta_dt") = glbAdvanceFontColor;
					isAdvanced = true;
				}else{
					sheetObj.CellFontColor(Row, prefix+"vps_eta_dt") = glbDelayFontColor;
				}
			}
			
			for(var i=Row; i<=totCnt; i++){
				if(!sheetObj.RowHidden(i)){
					
					//회복구간이 되면 정시처리되며 더이상 AutoCalculation을 타지 않는다.
					if(conti_recovery == "Y" && isAdvanced == false){
						conti_recovery = "N";
						return;
					}
					
					if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						skipCnt++;
					}else{
						
						if(i > Row){
							
							// auto_skd_cng_flg 에 체크가 되어 있지 않으면 업데이트
							if(sheetObj.CellValue(i, prefix+"auto_skd_cng_flg")=="0"){
													
								//Update Month  Check 2015.02.04
								var m_vsl = sheetObj.CellValue( i , prefix + "vvd"  );
								var m_voy = sheetObj.CellValue( i , prefix + "turn_skd_voy_no");
								var m_dir = sheetObj.CellValue( i , prefix + "turn_skd_dir_cd");
								var m_turn_vvd = m_vsl.substr(0,4) + m_voy + m_dir;
								var calc_val = false;
								if( updateVVD == sheetObj.CellValue( i , prefix + "vvd"  ) || updateVVD == m_turn_vvd ){
									
									
											
											if( updateVVD == sheetObj.CellValue( i , prefix + "vvd"  )){
												calc_val = true;	
											}else if(updateVVD == m_turn_vvd){
												calc_val = true;
												
												if( sheetObj.CellValue( i , prefix + "vps_eta_dt"  ).substr(0,6) == updateMon )
												{
													
													updateVVD = sheetObj.CellValue( i+1 , prefix + "vvd");
													
												}
											}else if( m_turn_vvd != sheetObj.CellValue( i+1 , prefix + "vvd"  ) ){
												
												if(sheetObj.CellValue( i , prefix + "vps_eta_dt"  ).substr(0,6) == updateMon ){
													updateVVD = sheetObj.CellValue( i+1 , prefix + "vvd"  );
													
												}else if( updateVVD != sheetObj.CellValue( i , prefix + "vvd"  ) ){
													
													if( updateVVD  != m_turn_vvd ){
														
														calc_val = false;
													}
													//updateVVD = m_turn_vvd;
													
												}
											}
										
											
									
								}
								if( calc_val == false ){
									return;
								}
								//end 
								// 이전 포트 ETD를 이용하여 ETA 계산
								// ETA = ETD + MNVR_OUT_HRS + SEA TIME(PF_TZTM_HRS) + 시차(당포트 GMT - 이전포트 GMT) + [TTL이 반영된 SEA_BUF_HRS]
								etdDate = new Usr_CalcTimeSet(sheetObj.CellValue(i-1-skipCnt, prefix+"vps_etd_dt"));
								seaTime = Number(controlMnvrHrs(sheetObj.CellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
//								        + Number(sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
										+ Number(sheetObj.CellValue(i-1-skipCnt, prefix+"tztm_hrs")) // 2011.04.14
								        + (Number(sheetObj.CellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.CellValue(i-1-skipCnt, prefix+"time_diff")));
								
								etdDelayTime = getDelayTime(sheetObj, i-1-skipCnt, "ETD");
								
								// [TTL이 반영된 SEA_BUF_HRS]
								// TTL보다 SEA_BUF_HRS가 크면 예정대로 진행될 수 있는 스케쥴이므로 [SEA_BUF_HRS - TTL]를 더하고
								// TTL이 더 크면 PF_SEA_BUF_HRS를 다 사용해야(즉, 버퍼가 없음) 하므로 0을 더한다.
								if(Number(etdDelayTime) <= Number(sheetObj.CellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60){
									
									var remainsBuffer = Number(sheetObj.CellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - Number(etdDelayTime);
									//sheetObj.CellValue2(i-1-skipCnt, prefix+"rmn_sea_buf") = remainsBuffer;
									//seaTime = seaTime*60 + remainsBuffer;
									sheetObj.CellValue2(i-1-skipCnt, prefix+"rmn_sea_buf") = "0";
									seaTime = seaTime*60;
									sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = seaTime/60;
									
								}else{
									sheetObj.CellValue2(i-1-skipCnt, prefix+"rmn_sea_buf") = "0";
									seaTime = seaTime*60;
									sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = seaTime/60;
									
								}
								   
								//etaDate = etdDate.getAddDate(seaTime);
								etaDate = getAddedTimeByMin(sheetObj.CellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTime, true);

								// <<20100816_01>>
								// 이미 Advanced 상황이거나, EST가 PF보다 이른 시간이면 EST는 PF 시간을 갖는다.
								if(isAdvanced || etaDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
									sheetObj.CellValue2(i, prefix+"vps_eta_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA"));
									sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbNormalFontColor;
									isAdvanced = true;
									
									// Auto Update 시 Advanced 상황에서는 항해시간(tztm_hrs)은 [P/F값+늘어난시간]을 갖는다.
									// Advanced 상황에서는 Auto Update를 하게되면 계속해서 시간이 당겨진 상태이어야 하지만
									// 위의 로직에서 P/F로 맞추어 주었으므로, 그 늘어난 시간만큼을 항해시간에 더해주어야 한다.
									var advancedTime = getTimeBetweenByMins(sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA")), etaDate);
									//sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs");
//									sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = getAddedHoursByMin(sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"), advancedTime, true);
									
								}else{
									sheetObj.CellValue2(i, prefix+"vps_eta_dt") = etaDate;
									sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbDelayFontColor;
									
									// Auto Update 시 Delay 상황에서는 항해시간(tztm_hrs)은 P/F 값을 갖는다.
//									sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs");
								}
																
							}
						}
						
						// auto_skd_cng_flg 에 체크가 되어 있지 않으면 업데이트
						if(sheetObj.CellValue(i, prefix+"auto_skd_cng_flg")=="0"){
							
							// 바뀐 ETA를 이용하여 ETB 계산
							// ETB = ETA + MNVR_IN_HRS
							etaDate = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_eta_dt"));
							
							//etbDate = etaDate.getAddDate(controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs")));
							etbDate = getAddedTimeByMin(sheetObj.CellValue(i, prefix+"vps_eta_dt"), controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs"))*60, true);

							// <<20100816_01>>
							// 이미 Advaned 상황이거나, EST가 PF보다 이른 시간이면 EST는 PF 시간을 갖는다.
							// 변경한 다음줄 부터 이 규칙을 적용한다.
							if(i>Row){
								if(isAdvanced || etbDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
									sheetObj.CellValue2(i, prefix+"vps_etb_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"));
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellValue2(i, prefix+"vps_etb_dt") = etbDate;
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbDelayFontColor;
								}
							}else{
								sheetObj.CellValue2(i, prefix+"vps_etb_dt") = etbDate;
								if(etbDate == sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else if(etbDate < sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbAdvanceFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbDelayFontColor;
								}
							}
							
							// 바뀐 ETB를 이용하여 ETD 계산
							// ETD = ETB + ACT_WRK_HRS + [Delay가 반영된 PORT_BUF_HRS]
							etbDate = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_etb_dt"));
//							portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs")) + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"));
							
							portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs"));
							etbDelayTime = getDelayTime(sheetObj, i, "ETB");
							
							// [Delay가 반영된 PORT_BUF_HRS]
							// Delay보다 PORT_BUF_HRS가 크면 예정대로 진행될 수 있는 스케쥴이므로 [PF_PORT_BUF_HRS - Delay]를 더하고
							// Delay가 더 크면 PORT_BUF_HRS를 다 사용해야(즉, 버퍼가 없음) 하므로 0을 더한다.
							if(etbDelayTime <= Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"))*60){
								portTime = portTime*60 + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"))*60 - etbDelayTime;
							}else{
								portTime = portTime*60;
							}
							
//							etdDate = etbDate.getAddDate(portTime);
							etdDate = getAddedTimeByMin(sheetObj.CellValue(i, prefix+"vps_etb_dt"), portTime, true);
							
							// <<20100816_01>>
							// 이미 Advaned 상황이거나, EST가 PF보다 이른 시간이면 EST는 PF 시간을 갖는다.
							// 변경한 다음줄 부터 이 규칙을 적용한다.
							if(i>Row){
								if(isAdvanced || etdDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.CellValue2(i, prefix+"vps_etd_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"));
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellValue2(i, prefix+"vps_etd_dt") = etdDate;
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDelayFontColor;
								}
							}else{
								sheetObj.CellValue2(i, prefix+"vps_etd_dt") = etdDate;
								if(etdDate == sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else if(etdDate < sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbAdvanceFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDelayFontColor;
								}
							}
						}
						
						// TOTAL Delay는 VPS_ETD와 PF_ETD간의 Delay
						setDelayTime(sheetObj, i, prefix+"vps_etd_dt", getPfDateColName(sheetObj, i, "ETD"));
						
						// 해당 row의 auto update 작업이 끝나면 skip count는 초기화시킨다.
						skipCnt = 0;
					}
				}
			}
		}else if(colName == prefix+"vps_etb_dt"){
			
			if(!isChangedPF){
				// 각 부분 주석은 vps_eta_dt 를 변경한 부분 참고
				if(sheetObj.CellValue(Row, prefix+"vps_etb_dt") == sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, "ETB"))){
					sheetObj.CellFontColor(Row, prefix+"vps_etb_dt") = glbNormalFontColor;
					isAdvanced = true;
				}else if(sheetObj.CellValue(Row, prefix+"vps_etb_dt") < sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, "ETB"))){
					sheetObj.CellFontColor(Row, prefix+"vps_etb_dt") = glbAdvanceFontColor;
					isAdvanced = true;
				}else{
					sheetObj.CellFontColor(Row, prefix+"vps_etb_dt") = glbDelayFontColor;
				}
			}
			
			for(var i=Row; i<=totCnt; i++){
				if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"auto_skd_cng_flg")=="0"){
					
					if(conti_recovery == "Y" && isAdvanced == false){
						conti_recovery = "N";
						return;
					}
					
					if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						skipCnt++;
					}else{
						
						if(i > Row){
							
							if(sheetObj.CellValue(i, prefix+"auto_skd_cng_flg")=="0"){
								//Update Month  Check 2015.02.04
								
								var m_vsl = sheetObj.CellValue( i , prefix + "vvd"  );
								var m_voy = sheetObj.CellValue( i , prefix + "turn_skd_voy_no");
								var m_dir = sheetObj.CellValue( i , prefix + "turn_skd_dir_cd");
								var m_turn_vvd = m_vsl.substr(0,4) + m_voy + m_dir;
								var calc_val = false;
								if( updateVVD == sheetObj.CellValue( i , prefix + "vvd"  ) || updateVVD == m_turn_vvd ){
									
									
											
											if( updateVVD == sheetObj.CellValue( i , prefix + "vvd"  )){
												calc_val = true;	
											}else if(updateVVD == m_turn_vvd){
												calc_val = true;
												
												if( sheetObj.CellValue( i , prefix + "vps_eta_dt"  ).substr(0,6) == updateMon )
												{
													
													updateVVD = sheetObj.CellValue( i+1 , prefix + "vvd");
													
												}
											}else if( m_turn_vvd != sheetObj.CellValue( i+1 , prefix + "vvd"  ) ){
												
												if(sheetObj.CellValue( i , prefix + "vps_eta_dt"  ).substr(0,6) == updateMon ){
													updateVVD = sheetObj.CellValue( i+1 , prefix + "vvd"  );
													
												}else if( updateVVD != sheetObj.CellValue( i , prefix + "vvd"  ) ){
													
													if( updateVVD  != m_turn_vvd ){
														
														calc_val = false;
													}
													//updateVVD = m_turn_vvd;
													
												}
											}
										
											
									
								}
								if( calc_val == false ){
									return;
								}
								
								//end 
								
								// ETA
								etdDate = new Usr_CalcTimeSet(sheetObj.CellValue(i-1-skipCnt, prefix+"vps_etd_dt"));
								seaTime = Number(controlMnvrHrs(sheetObj.CellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
//						        		+ Number(sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
										+ Number(sheetObj.CellValue(i-1-skipCnt, prefix+"tztm_hrs")) // 2011.04.14
						        		+ (Number(sheetObj.CellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.CellValue(i-1-skipCnt, prefix+"time_diff")));
								
								etdDelayTime = getDelayTime(sheetObj, i-1-skipCnt, "ETD");
								
								if(etdDelayTime <= Number(sheetObj.CellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60){
									//seaTime = seaTime*60 + Number(sheetObj.CellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - etdDelayTime;
									seaTime = seaTime*60;
								}else{
									seaTime = seaTime*60;
								}
								
								// <<20100816_01>>
								//etaDate = etdDate.getAddDate(seaTime);
								etaDate = getAddedTimeByMin(sheetObj.CellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTime, true);
								
								if(isAdvanced || etaDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
									sheetObj.CellValue2(i, prefix+"vps_eta_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA"));
									sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellValue2(i, prefix+"vps_eta_dt") = etaDate;
									sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbDelayFontColor;
								}
								
								// ETB
								etaDate = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_eta_dt"));
								//etbDate = etaDate.getAddDate(controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs")));
								etbDate = getAddedTimeByMin(sheetObj.CellValue(i, prefix+"vps_eta_dt"), controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs"))*60, true);
								
								// <<20100816_01>>
								if(isAdvanced || etbDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
									sheetObj.CellValue2(i, prefix+"vps_etb_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"));
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellValue2(i, prefix+"vps_etb_dt") = etbDate;
									sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbDelayFontColor;
								}
								
							}
						}
						
						if(sheetObj.CellValue(i, prefix+"auto_skd_cng_flg")=="0"){
							
							etbDate = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_etb_dt"));
//							portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs")) + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"));
							portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs"));
							etbDelayTime = getDelayTime(sheetObj, i, "ETB"); 
							
							if(etbDelayTime <= Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"))*60){
								portTime = portTime*60 + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"))*60 - etbDelayTime;
							}else{
								portTime = portTime*60;
							}
							
//							etdDate = etbDate.getAddDate(portTime);
							etdDate = getAddedTimeByMin(sheetObj.CellValue(i, prefix+"vps_etb_dt"), portTime, true);
							
							// <<20100816_01>>
							if(i>Row){
								if(isAdvanced || etdDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.CellValue2(i, prefix+"vps_etd_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"));
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellValue2(i, prefix+"vps_etd_dt") = etdDate;
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDelayFontColor;
								}
							}else{
								sheetObj.CellValue2(i, prefix+"vps_etd_dt") = etdDate;
								if(etdDate == sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbNormalFontColor;
									isAdvanced = true;
								}else if(etdDate < sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbAdvanceFontColor;
									isAdvanced = true;
								}else{
									sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDelayFontColor;
								}
							}
							
						}
						
						setDelayTime(sheetObj, i, prefix+"vps_etd_dt", getPfDateColName(sheetObj, i, "ETD"));
						skipCnt = 0;
					}
				}
			}
		}else{
			
			// 각 부분 주석은 vps_eta_dt 를 변경한 부분 참고
			
			if(!isChangedPF){
				if(sheetObj.CellValue(Row, prefix+"vps_etd_dt") == sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, "ETD"))){
					sheetObj.CellFontColor(Row, prefix+"vps_etd_dt") = glbNormalFontColor;
					isAdvanced = true;
				}else if(sheetObj.CellValue(Row, prefix+"vps_etd_dt") < sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, "ETD"))){
					sheetObj.CellFontColor(Row, prefix+"vps_etd_dt") = glbAdvanceFontColor;
					isAdvanced = true;
				}else{
					sheetObj.CellFontColor(Row, prefix+"vps_etd_dt") = glbDelayFontColor;
				}
			}
			
			setDelayTime(sheetObj, Row, prefix+"vps_etd_dt", getPfDateColName(sheetObj, Row, "ETD"));
			
			for(var i=Row+1; i<=totCnt; i++){
				//alert( "[[" + i + "]]   " +  sheetObj.CellValue(i, prefix+"auto_skd_cng_flg") );
				if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"auto_skd_cng_flg")=="0"){
					//Update Month  Check 2015.02.04
					
					var m_vsl = sheetObj.CellValue( i , prefix + "vvd"  );
					var m_voy = sheetObj.CellValue( i , prefix + "turn_skd_voy_no");
					var m_dir = sheetObj.CellValue( i , prefix + "turn_skd_dir_cd");
					var m_turn_vvd = m_vsl.substr(0,4) + m_voy + m_dir;
					var calc_val = false;
					if( updateVVD == sheetObj.CellValue( i , prefix + "vvd"  ) || updateVVD == m_turn_vvd ){
						
						
								
								if( updateVVD == sheetObj.CellValue( i , prefix + "vvd"  )){
									calc_val = true;	
								}else if(updateVVD == m_turn_vvd){
									calc_val = true;
									
									if( sheetObj.CellValue( i , prefix + "vps_eta_dt"  ).substr(0,6) == updateMon )
									{
										
										updateVVD = sheetObj.CellValue( i+1 , prefix + "vvd");
										
									}
								}else if( m_turn_vvd != sheetObj.CellValue( i+1 , prefix + "vvd"  ) ){
									
									if(sheetObj.CellValue( i , prefix + "vps_eta_dt"  ).substr(0,6) == updateMon ){
										updateVVD = sheetObj.CellValue( i+1 , prefix + "vvd"  );
										
									}else if( updateVVD != sheetObj.CellValue( i , prefix + "vvd"  ) ){
										
										if( updateVVD  != m_turn_vvd ){
											
											calc_val = false;
										}
										//updateVVD = m_turn_vvd;
										
									}
								}
							
								
						
					}
					if( calc_val == false ){
						
						return;
					}
					//end 
					if(conti_recovery == "Y" && isAdvanced == false){
						conti_recovery = "N";
						return;
					}
					
					if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						skipCnt++;
					}else{
						// ETA
						//alert( "MNVT OUT i-1:: " +  Number(controlMnvrHrs(sheetObj.CellValue(i-1-skipCnt, prefix+"mnvr_out_hrs"))));
						//alert( "SEA TIME i-1:: " + Number(sheetObj.CellValue(i-1-skipCnt, prefix+"tztm_hrs")));
						//alert( "time difff i :: "+ Number(sheetObj.CellValue(i-skipCnt, prefix+"time_diff")));
						//alert( "time difff i-1 :: " + Number(sheetObj.CellValue(i-1-skipCnt, prefix+"time_diff")));
						etdDate = new Usr_CalcTimeSet(sheetObj.CellValue(i-1-skipCnt, prefix+"vps_etd_dt"));
						seaTime = Number(controlMnvrHrs(sheetObj.CellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
//		        				+ Number(sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
								+ Number(sheetObj.CellValue(i-1-skipCnt, prefix+"tztm_hrs"))
		        				+ (Number(sheetObj.CellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.CellValue(i-1-skipCnt, prefix+"time_diff")));
						
						etdDelayTime = getDelayTime(sheetObj, i-1-skipCnt, "ETD");
						//alert("ETD Delay time ::" +  etdDelayTime);
						if(etdDelayTime <= Number(sheetObj.CellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60){
							//seaTime = seaTime*60 + Number(sheetObj.CellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - etdDelayTime;
							seaTime = seaTime*60;
						}else{
							seaTime = seaTime*60;
						}
						//alert(seaTime );
//						etaDate = etdDate.getAddDate(seaTime);
						etaDate = getAddedTimeByMin(sheetObj.CellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTime, true);
						
						// <<20100816_01>>
						if(isAdvanced || etaDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
							sheetObj.CellValue2(i, prefix+"vps_eta_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETA"));
							sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbNormalFontColor;
							isAdvanced = true;
						}else{
							sheetObj.CellValue2(i, prefix+"vps_eta_dt") = etaDate;
							sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbDelayFontColor;
						}
						
						// ETB
						etaDate = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_eta_dt"));
						//etbDate = etaDate.getAddDate(controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs")));
						etbDate = getAddedTimeByMin(sheetObj.CellValue(i, prefix+"vps_eta_dt"), controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs"))*60, true);
						
						if(isAdvanced || etbDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
							sheetObj.CellValue2(i, prefix+"vps_etb_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETB"));
							sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbNormalFontColor;
							isAdvanced = true;
						}else{
							sheetObj.CellValue2(i, prefix+"vps_etb_dt") = etbDate;
							sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbDelayFontColor;
						}
							
						// ETD
						etbDate = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_etb_dt"));
//						portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs")) + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"));
						portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs"));
						
						etbDelayTime = getDelayTime(sheetObj, i, "ETB"); 
						
						if(etbDelayTime <= Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"))*60){
							portTime = portTime*60 + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"))*60 - etbDelayTime;
						}else{
							portTime = portTime*60;
						}
						
//						etdDate = etbDate.getAddDate(portTime);
						etdDate = getAddedTimeByMin(sheetObj.CellValue(i, prefix+"vps_etb_dt"), portTime, true);
							
						// <<20100816_01>>
						if(isAdvanced || etdDate <= sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
							sheetObj.CellValue2(i, prefix+"vps_etd_dt") = sheetObj.CellValue(i, getPfDateColName(sheetObj, i, "ETD"));
							sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbNormalFontColor;
							isAdvanced = true;
						}else{
							sheetObj.CellValue2(i, prefix+"vps_etd_dt") = etdDate;
							sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDelayFontColor;
						}
							
						setDelayTime(sheetObj, i, prefix+"vps_etd_dt", getPfDateColName(sheetObj, i, "ETD"));
						skipCnt = 0;
					}
				}
			}
		}
		
		var targetRows = new Array();
		for(var Row=sheetObj.HeaderRows; Row<=sheetObj.LastRow; Row++){
			if(!sheetObj.RowHidden(Row) &&
				sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") != "S"){
				targetRows.push(Row);
			}
		}
		
		
		for(var i=0; i<targetRows.length; i++){
			if(i==0) continue;

//			if(getSeaDlayTime(sheetObj, targetRows[i]) >= 7.5){
				sheetObj.CellValue2(targetRows[i], prefix+"sea_date_text") = calcSeaDlayTime(sheetObj, targetRows[i]);
//			}else{
//				sheetObj.CellValue2(targetRows[i], prefix+"sea_date_text") = "";
//			}
			
			if(sheetObj.CellValue(targetRows[i], prefix+"sea_date_text") == ""){
				sheetObj.CellValue2(targetRows[i], prefix+"vsl_dlay_rsn_cd") = "";
				sheetObj.CellValue2(targetRows[i], prefix+"vsl_dlay_rsn_desc") = "";
				sheetObj.CellBackColor(targetRows[i], prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(targetRows[i], prefix+"sea_date_text");
			}
		}
		
	}
	
	function pickPfData(sheetObj){
		var prefix = sheetObj.id + "_";
		var headerCnt = sheetObj.HeaderRows ;
		var bodyCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		
		for(var Row=headerCnt; Row<=totCnt; Row++){
			if(sheetObj.CellValue(Row, prefix+"tztm_hrs")!=sheetObj.CellValue(Row, prefix+"tmp_tztm_hrs")){
				sheetObj.CellValue2(Row, prefix+"tztm_hrs")=sheetObj.CellValue(Row, prefix+"tmp_tztm_hrs");
			}
			if(sheetObj.CellValue(Row, prefix+"lnk_spd")!=sheetObj.CellValue(Row, prefix+"tmp_lnk_spd")){
				sheetObj.CellValue2(Row, prefix+"lnk_spd")=sheetObj.CellValue(Row, prefix+"tmp_lnk_spd");
			}
			if(sheetObj.CellValue(Row, prefix+"act_wrk_hrs")!=sheetObj.CellValue(Row, prefix+"tmp_act_wrk_hrs")){
				sheetObj.CellValue2(Row, prefix+"act_wrk_hrs")=sheetObj.CellValue(Row, prefix+"tmp_act_wrk_hrs");
			}
		}
			
	}
	
	/**
	 * PF SKD에 속하는 항목 계산 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function calcPfData(sheetObj, Row, Col){
		
		// 스케쥴이 변경되었을 경우, Sea Speed가 변경된다.
		var colName = sheetObj.ColSaveName(Col);
		var prefix = sheetObj.id + "_";
		var haederCnt = sheetObj.HeaderRows ;
		var bodyCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		var skipCnt = 0;
		
		var seaSpd = 0.0;
		var portTime = 0.0;
		
		var etbObj;
		var etdObj;
		
		for(var i=Row; i<totCnt; i++){
			if(!sheetObj.RowHidden(i)){
				etbObj = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_etb_dt"));
				etdObj = new Usr_CalcTimeSet(sheetObj.CellValue(i, prefix+"vps_etd_dt"));
				
				if(i<totCnt){
					seaSpd = Number(sheetObj.CellValue(i, prefix+"lnk_dist")) / sheetObj.CellValue(i, prefix+"tztm_hrs");
					seaSpd = Math.floor(seaSpd*10)/10;
					
//					sheetObj.CellValue2(i, prefix+"tmp_lnk_spd") = seaSpd;
					sheetObj.CellValue2(i, prefix+"lnk_spd") = seaSpd;		// 2011.04.14
					
				}
				
				// PORT TIME = 당포트 ETD와 ETB의 시간차
				portTime = Number(etbObj.getTimeDiff(sheetObj.CellValue(i, prefix+"vps_etd_dt")))
				portTime = Math.floor(portTime*10)/10;
//				sheetObj.CellValue2(i, prefix+"tmp_act_wrk_hrs") = portTime;
				
				sheetObj.CellValue2(i, prefix+"act_wrk_hrs") = portTime;	// 2011.04.14
			}
		}
	}
	
	/**
	 * Sea Dlay Time 을 계산하여 정해진 형식으로 리턴.
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function calcSeaDlayTime(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		var hourDiff = getSeaDlayTime(sheetObj, sRow);
		
		if(hourDiff == ""){
			return "";
		}
		
		var timeDiff = "";
		
		if (hourDiff > 0) {
			var intDiff = ComRound(hourDiff, 1);
			
			if ((intDiff - parseInt(intDiff)) > 0) {
				timeDiff = intDiff;
			} else {
				timeDiff = intDiff + ".0";
			}
		}
		
//		if(hourDiff >= 7.5){
		if(hourDiff > 8){
//			timeDiff = ComLpad(parseInt(hourDiff / 24, 10), 2, "0") + "D-" + ComLpad(Math.round(hourDiff % 24), 2, "0") + "H";
			
    		// Delay Reason 은 2번째 Row 부터(1번째 Row 는 입력 불가)
    		if(sRow > sheetObj.HeaderRows){
    			// Delay 된 Port 는 Delay 입력하도록 유도(필수 입력 Color 로 변경) 단, Actual 이 아닐 경우.
    			if(sheetObj.CellValue(sRow, prefix+"bfr_act_flg") != "X" && sheetObj.CellValue(sRow, prefix+"port_skd_sts_cd") != "D"){
    				sheetObj.CellBackColor(sRow, prefix+"vsl_dlay_rsn_cd") = glbEditColor;
    			}
    		}
		}else{
			sheetObj.CellValue2(sRow, prefix+"vsl_dlay_rsn_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"vsl_dlay_rsn_desc") = "";
//    		sheetObj.CellBackColor(sRow, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(sRow, prefix+"sea_date_text");//sheetObj.RgbColor(255, 255, 255);
		}
		
		return timeDiff;
	}
	
	/**
	 * 이전포트의 ETD와 당포트의 ETA와이 Sea Delay Time을 구한다.
	 * 
	 * @param sheetObj
	 * @param sRow 당포트
	 * @return
	 */
	function getSeaDlayTime(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		var haedCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = getTotalRowCnt(sheetObj);
		var pRow = "0";
		
		if(sRow > haedCnt){
			for(var i=sRow-1; i>=haedCnt; i--){
				if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
					pRow = i;
					break;
				}
			}
		}else{
			return "";
		}
		
		var vpsEtd = sheetObj.CellValue(pRow, prefix+"vps_etd_dt");
		var vpsEta = sheetObj.CellValue(sRow, prefix+"vps_eta_dt");
		var vpsEtdObj = new Usr_CalcTimeSet(vpsEtd);
		var pfEtd = sheetObj.CellValue(pRow, getPfDateColName(sheetObj, pRow, "ETD"));
		var pfEta = sheetObj.CellValue(sRow, getPfDateColName(sheetObj, sRow, "ETA"));
		// Add Call 한 경우 delay 계산하기 위한 기준값(init_eta_dt, init_etd_dt_ 날짜가 없으므로. 
		if(pfEta == "" || pfEtd == ""){
			return "";
		}
		
		// VPS_ETA가 PF_ETA보다 늦지 않은 경우
		// 이전 port ETD ~ ETA간 항해 시간과 상관없이 Delay가 아닌것으로 판단한다. (변경 20100712_01)
		var vpsEtaObj = new Usr_CalcTimeSet(vpsEta);
		if(vpsEtaObj.getTimeDiff(pfEta)>=0){
			return "";
		}
		
		// PF와 VPS의 이전포트 ETD ~ ETA간 항해 시간을 구하고 그 차이를 시간으로 변환하여 반환한다. 
		var pfEtdObj = new Usr_CalcTimeSet(pfEtd);
		var vpsDiff = vpsEtdObj.getTimeDiff(vpsEta);
		var pfDiff = pfEtdObj.getTimeDiff(pfEta);
		var hourDiff = Number(vpsDiff) - Math.abs(Number(pfDiff));
		
		return hourDiff;
	}
	
	/**
	 * 시간계산하기 위한 DataSet.
	 * @param sDate
	 * @return
	 */
	function Usr_CalcTimeSet(sDate){
		this.date = getDateObj(sDate);
		
		this.year = this.date.getFullYear();
		this.month = this.date.getMonth() + 1;
		this.day = this.date.getDate();
		
		this.hour = this.date.getHours();
		this.min = this.date.getMinutes();
	}
	
	/**
	 * 입력되어 있는 날짜에 sTime 를 더한 날짜를 반환한다.
	 * 
	 * @param sTime
	 */
	Usr_CalcTimeSet.prototype.getAddDate = function(sTime){
		if(sTime == null || sTime == undefined || sTime == "") sTime = 0;
		
// 		if(sTime < 0) sTime = sTime * (-1);

		var rtnDate = null;
		
		var totMin = this.min + Math.round((Number(sTime)%1) * 60);
		var tMin = totMin%60;				// 화면에 보여질 분
		
		// 30분 미만은 절삭, 30분 초과는 반올림, 30분은 그냥 그대로 표현
		if(tMin < 30){
			tMin = 0;
		} else if(tMin > 30) {
			tMin = 0;
			totMin = totMin + 30;
		}
		
//		var hMin = Usr_Trunc(totMin/60);	// 시간으로 환산될 분
		var hMin = parseInt(totMin/60, 10);		// 시간으로 환산될 분
		
// 		var totHour = this.hour + hMin + Usr_Trunc(sTime);
		var totHour = this.hour + hMin + parseInt(sTime, 10);
		
		var tHour = totHour%24;				// 화면에 보여질 시간
// 		var dHour = Usr_Trunc(totHour/24); //일로 환산될 시간
		var dHour = parseInt(totHour/24, 10);	// 일로 환산될 시간
		
		var tDate = this.year +""+ ComLpad(this.month,2,"0") +""+ ComLpad(this.day,2,"0");
		
// 		rtnDate = tDate;
		if(dHour < 1){
			rtnDate = tDate + "" + ComLpad(tHour,2,"0") + "" + ComLpad(tMin,2,"0"); 
		}else{
			rtnDate = ComGetDateAdd(tDate, "D", dHour, "") + "" + ComLpad(tHour,2,"0") + "" + ComLpad(tMin,2,"0");
		}
		return rtnDate;
	}
	
	/**
	 * 입력되어 있는 날짜와 입력한 날짜 sDate 와의 시간차를 계산하여 반환한다.
	 * @param sDate
	 */
	Usr_CalcTimeSet.prototype.getTimeDiff = function(sDate){
		var toDate = getDateObj(sDate);
		
		var hour  = 1000 * 3600; // 1시간

// 		return parseInt((toDate - this.date) / hour, 10);
		return (toDate - this.date) / hour;
	}
	
	function Usr_Coni_FormData(){
		this.vslCd = "";
		this.skdVoyNo = "";
		this.skdDirCd = "";
		this.simDt = "";
		this.simNo = "";
		this.creDt = "";
		this.creUsrId = "";
		this.vslSlanCd = "";
		this.bound = "3";
		this.updDt = "";
		this.updUsrId = "";
		this.skdRmk = "";
	}
	
	//Usr_Coni_FormData.Getter()
	Usr_Coni_FormData.prototype.getVslCd = function(){
		return this.vslCd;
	}
	
	Usr_Coni_FormData.prototype.getSkdVoyNo = function(){
		return this.skdVoyNo;
	}
	
	Usr_Coni_FormData.prototype.getSkdDirCd = function(){
		return this.skdDirCd;
	}
	
	Usr_Coni_FormData.prototype.getSimDt = function(){
		return this.simDt;
	}
	
	Usr_Coni_FormData.prototype.getSimNo = function(){
		return this.simNo;
	}
	
	Usr_Coni_FormData.prototype.getCreDt = function(){
		return this.creDt;
	}
	
	Usr_Coni_FormData.prototype.getCreUsrId = function(){
		return this.creUsrId;
	}
	
	Usr_Coni_FormData.prototype.getVslSlanCd = function(){
		return this.vslSlanCd;
	}
	
	Usr_Coni_FormData.prototype.getBound = function(){
		return this.bound;
	}
	
	Usr_Coni_FormData.prototype.getUpdDt = function(){
		return this.updDt;
	}
	
	Usr_Coni_FormData.prototype.getUpdUsrId = function(){
		return this.updUsrId;
	}
	
	Usr_Coni_FormData.prototype.getSkdRmk = function(){
		return this.skdRmk;
	}

	//Usr_Coni_FormData.Setter()
	Usr_Coni_FormData.prototype.setVslCd = function(sVslCd){
		this.vslCd = sVslCd;
	}
	
	Usr_Coni_FormData.prototype.setSkdVoyNo = function(sSkdVoyNo){
		this.skdVoyNo = sSkdVoyNo;
	}
	
	Usr_Coni_FormData.prototype.setSkdDirCd = function(sSkdDirCd){
		this.skdDirCd = sSkdDirCd;
	}
	
	Usr_Coni_FormData.prototype.setSimDt = function(sSimDt){
		this.simDt = sSimDt;
	}
	
	Usr_Coni_FormData.prototype.setSimNo = function(sSimNo){
		this.simNo = sSimNo;
	}
	
	Usr_Coni_FormData.prototype.setCreDt = function(sCreDt){
		this.creDt = sCreDt;
	}
	
	Usr_Coni_FormData.prototype.setCreUsrId = function(sCreUsrId){
		this.creUsrId = sCreUsrId;
	}
	
	Usr_Coni_FormData.prototype.setVslSlanCd = function(sVslSlanCd){
		this.vslSlanCd = sVslSlanCd;
	}
	
	Usr_Coni_FormData.prototype.setBound = function(sBound){
		this.bound = sBound;
	}
	
	Usr_Coni_FormData.prototype.setUpdDt = function(sUpdDt){
		this.updDt = sUpdDt;
	}
	
	Usr_Coni_FormData.prototype.setUpdUsrId = function(sUpdUsrId){
		this.updUsrId = sUpdUsrId;
	}
	
	Usr_Coni_FormData.prototype.setSkdRmk = function(sSkdRmk){
		this.skdRmk = sSkdRmk;
	}
	
	Usr_Coni_FormData.prototype.setAllFormData = function(){
		var formObj = document.form;
		
		formObj.vsl_cd.value = this.getVslCd();
		formObj.skd_voy_no.value = this.getSkdVoyNo();
		formObj.skd_dir_cd.value = this.getSkdDirCd();
		formObj.sim_dt.value = this.getSimDt();
		formObj.sim_no.value = this.getSimNo();
		formObj.cre_dt.value = this.getCreDt();
		formObj.cre_usr_id.value = this.getCreUsrId();
		formObj.vsl_slan_cd.value = this.getVslSlanCd();
		formObj.bound.value = this.getBound();
		formObj.upd_dt.value = this.getUpdDt();
		formObj.upd_usr_id.value = this.getUpdUsrId();
		formObj.skd_rmk.value = this.getSkdRmk();
	}
	
	function Usr_setVslCd(sVslCd){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setVslCd(sVslCd);
    	}else{
    		glbSheet2FormData.setVslCd(sVslCd);
    	}
	}
	
	function Usr_setSkdVoyNo(sSkdVoyNo){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSkdVoyNo(sSkdVoyNo);
    	}else{
    		glbSheet2FormData.setSkdVoyNo(sSkdVoyNo);
    	}
	}
	
	function Usr_setSkdDirCd(sSkdDirCd){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSkdDirCd(sSkdDirCd);
    	}else{
    		glbSheet2FormData.setSkdDirCd(sSkdDirCd);
    	}
	}
	
	function Usr_setSimDt(sSimDt){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSimDt(sSimDt);
    	}else{
    		glbSheet2FormData.setSimDt(sSimDt);
    	}
	}
	
	function Usr_setSimNo(sSimNo){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSimNo(sSimNo);
    	}else{
    		glbSheet2FormData.setSimNo(sSimNo);
    	}
	}
	
	function Usr_setCreDt(sCreDt){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setCreDt(sCreDt);
    	}else{
    		glbSheet2FormData.setCreDt(sCreDt);
    	}
	}
	
	function Usr_setCreUsrId(sCreUsrId){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setCreUsrId(sCreUsrId);
    	}else{
    		glbSheet2FormData.setCreUsrId(sCreUsrId);
    	}
	}
	
	function Usr_setVslSlanCd(sVslSlanCd){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setVslSlanCd(sVslSlanCd);
    	}else{
    		glbSheet2FormData.setVslSlanCd(sVslSlanCd);
    	}
	}
	
	function Usr_setBound(sBound){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setBound(sBound);
    	}else{
    		glbSheet2FormData.setBound(sBound);
    	}
	}
	
	function Usr_setUpdDt(sUpdDt){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setUpdDt(sUpdDt);
    	}else{
    		glbSheet2FormData.setUpdDt(sUpdDt);
    	}
	}
	
	function Usr_setUpdUsrId(sUpdUsrId){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setUpdUsrId(sUpdUsrId);
    	}else{
    		glbSheet2FormData.setUpdUsrId(sUpdUsrId);
    	}
	}
	
	function Usr_setSkdRmk(sSkdRmk){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSkdRmk(sSkdRmk);
    	}else{
    		glbSheet2FormData.setSkdRmk(sSkdRmk);
    	}
	}
	
	/**
	 * 소수점 아래 몇자리 이하 절삭.
	 *
	 * @param num 숫자
	 * @param place 자리수
	 * @return 절삭된 숫자
	 */
	function Usr_Trunc(num, place) {
		if(place == null || place == undefined || place == "") place = 0;

		return Math.floor( num * Math.pow(10, parseInt(place, 10)) ) / Math.pow(10, parseInt(place, 10)); 
	}
	
	/**
	 * manevering in 혹은 out 시간이 0인 경우, 특정값(시간)으로 변한해준다.
	 * 
	 * @param mnvrHrs
	 * @return
	 */
	function controlMnvrHrs(mnvrHrs){
		if(mnvrHrs=="0"){
			return "1";
		}else{
			return mnvrHrs;
		}
	}

	////////////////////////////////////////////////////////////////////
	// 시간 계산 관련 추가 함수
	////////////////////////////////////////////////////////////////////

	/**
	 * 어떤 시간(sBaseTime)을 기준으로 했을때, 그 시간과 또 다른 어떤 시간과의 차이를 구한다.
	 * 결과 오브젝트의 속성은 다음과 같다.
	 * 
	 * times[0] : 일
	 * times[1] : 시간
	 * times[2] : 분
	 * times[3] : 초
	 * isDelay : delay 일때 참
	 * isAdvance : advance 일때 참
	 *  
	 * @param sBaseDate 기준시간 yyyyMMddHHmm 형식 시간
	 * @param sSrcDate 비교시간 yyyyMMddHHmm 형식 시간
	 * @return
	 */
	function getTimeBetween(sBaseTime, sSrcTime){
		
		var timeBetween = new Object();
		
		var oBaseTime = getDateObj(sBaseTime);
		var oSrcTime = getDateObj(sSrcTime);
		var milliSecs = oBaseTime - oSrcTime;
		
		var iDay = 1000 * 60 * 60 * 24;
		var iHour = 1000 * 60 * 60;
		var iMin = 1000 * 60;
		var iSec = 1000;
		var iTmp = 0;
		
		var times = new Array();
		
		if(milliSecs>0){
			timeBetween.isAdvance = true;
			timeBetween.isDelay = false;
		} else if(milliSecs<0){
			timeBetween.isDelay = true;
			timeBetween.isAdvance = false;
			milliSecs = milliSecs * -1;
		} else {
			timeBetween.isAdvance = false;
			timeBetween.isDelay = false;
		}
		
		times[0] = iDay;
		times[1] = iHour;
		times[2] = iMin;
		times[3] = iSec;
		
		for(var i=0; i<times.length; i++){
			
			if(milliSecs==0){
				times[i] = -1;
				break;
			}
			
			if(times[i]<=milliSecs){
				iTmp = Math.floor(milliSecs/times[i]);
				milliSecs = milliSecs%times[i];
				times[i] = iTmp;
			}else{
				times[i] = 0;
			}
			
		}
		
		timeBetween.times = times;
		return timeBetween;
	}
	
	/**
	 * 어떤 시간(sBaseTime)을 기준으로 했을때, 그 시간과 또 다른 어떤 시간과의 지연 시간을 시분(hour, min) 값으로 구한다.
	 * 
	 * @param sBaseDate 기준시간 yyyyMMddHHmm 형식 시간
	 * @param sSrcDate 비교시간 yyyyMMddHHmm 형식 시간
	 * @return 00H-00M 형식 문자열
	 */
	function getDelayTimeWithFormat(sBaseTime, sSrcTime){
		var timeBetween = getTimeBetween(sBaseTime, sSrcTime);
		if(timeBetween.isDelay()){
			var h1 = Number(times[0]==-1?0:times[0]*24);
			var h2 = Number(times[1]==-1?0:times[1]*1);
			var h3 = Number(times[2]==-1?0:times[2]*1);
			return (h1+h2) + "H-" + h3 + "M";
		}else{
			return "";
		}
	}
	
	/**
	 * 어떤 시간(sBaseTime)을 기준으로 했을때, 그 시간과 또 다른 어떤 시간과의 차이를 분값으로 구한다.
	 * 지연 상태이면 음수값을 갖는다.
	 * 
	 * @param sBaseDate 기준시간 yyyyMMddHHmm 형식 시간
	 * @param sSrcDate 비교시간 yyyyMMddHHmm 형식 시간
	 * @return 분으로 환산된 시간 차이값
	 */
	function getTimeBetweenByMins(sBaseTime, sSrcTime){
		var timeBetween = getTimeBetween(sBaseTime, sSrcTime);
		var times = timeBetween.times;
		
		var h1 = Number(times[0]==-1?0:times[0]*24*60);
		var h2 = Number(times[1]==-1?0:times[1]*60);
		var h3 = Number(times[2]==-1?0:times[2]*1);
		
		return timeBetween.isDelay?(h1+h2+h3)*(-1):(h1+h2+h3);
	}
	
	/**
	 * PF 기준으로 Estimate Time 와의 지연 시간를 분값으로 구한다.
	 * 지연이 발생하지 않으면 0이다.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param dateFlg ETA/ETB/ETD
	 * @return 분으로 환산된 시간 차이값
	 */
	function getDelayTime(sheetObj, Row, dateFlg){
		var prefix = sheetObj.id + "_";
		var pfTime = sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, dateFlg));
		var estTime;
		if("ETA"==dateFlg){
			estTime = sheetObj.CellValue(Row, prefix+"vps_eta_dt");
		} else if("ETB"==dateFlg){
			estTime = sheetObj.CellValue(Row, prefix+"vps_etb_dt");
		} else if("ETD"==dateFlg){
			estTime = sheetObj.CellValue(Row, prefix+"vps_etd_dt");
		}

		var delayTime = getTimeBetweenByMins(pfTime, estTime);
		if(delayTime<0){
			return delayTime*(-1);
		}else{
			return 0;
		}
	}
	
	/**
	 * PF 기준으로 Estimate Time 와의 조기 실행(advance) 시간를 분값으로 구한다.
	 * 조기 실행이 발생하지 않으면 0이다.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param dateFlg ETA/ETB/ETD
	 * @return 분으로 환산된 시간 차이값
	 */
	function getAdvanceTime(sheetObj, Row, dateFlg){
		var prefix = sheetObj.id + "_";
		var pfTime = sheetObj.CellValue(Row, getPfDateColName(sheetObj, Row, dateFlg));
		var estTime;
		if("ETA"==dateFlg){
			estTime = sheetObj.CellValue(Row, prefix+"vps_eta_dt");
		} else if("ETB"==dateFlg){
			estTime = sheetObj.CellValue(Row, prefix+"vps_etb_dt");
		} else if("ETD"==dateFlg){
			estTime = sheetObj.CellValue(Row, prefix+"vps_etd_dt");
		}

		var delayTime = getTimeBetweenByMins(pfTime, estTime);
		if(delayTime>0){
			return delayTime;
		}else{
			return 0;
		}
	}
	
	/**
	 * 어떤 기준 시간에 임의의 분값(음수 가능)이 더해졌을때 결과 시간을 구한다.
	 * 반올림 처리를 하는 경우(isRound가 true)에는
	 * 30분을 기준으로 반올림 처리한다.  
	 * 
	 * @param sBaseTime 기준시간 yyyyMMddHHmm 형식 시간
	 * @param mins 더하거나 빼 분값
	 * @param isRound 반올림 유무
	 * @return yyyyMMddHHmm 형식 시간
	 */
	function getAddedTimeByMin(sBaseTime, mins, isRound){
		var oBaseTime = getDateObj(sBaseTime);
		//var targetTime = new Date(oBaseTime.getYear(), oBaseTime.getMonth(), oBaseTime.getDate(), oBaseTime.getHours(), eval(oBaseTime.getMinutes() + mins), oBaseTime.getSeconds());
		var targetTime = new Date(oBaseTime.getYear(), oBaseTime.getMonth(), oBaseTime.getDate(), oBaseTime.getHours(), oBaseTime.getMinutes() + mins, oBaseTime.getSeconds());

		if(!isRound){
			return targetTime.getYear()
				+ ComLpad(targetTime.getMonth()+1, 2, "0")
				+ ComLpad(targetTime.getDate(), 2, "0")
				+ ComLpad(targetTime.getHours(), 2, "0")
				+ ComLpad(targetTime.getMinutes(), 2, "0");
		}else{
			mins = targetTime.getMinutes();
			
			var result = "";
			if(mins>30){
				result = targetTime.getYear()
						+ ComLpad(targetTime.getMonth()+1, 2, "0")
						+ ComLpad(targetTime.getDate(), 2, "0")
						+ ComLpad(targetTime.getHours()+1, 2, "0")
						+ ComLpad(0, 2, "0");
			} else if(mins<30){
				result = targetTime.getYear()
						+ ComLpad(targetTime.getMonth()+1, 2, "0")
						+ ComLpad(targetTime.getDate(), 2, "0")
						+ ComLpad(targetTime.getHours(), 2, "0")
						+ ComLpad(0, 2, "0");
			} else {
				result = targetTime.getYear()
				+ ComLpad(targetTime.getMonth()+1, 2, "0")
				+ ComLpad(targetTime.getDate(), 2, "0")
				+ ComLpad(targetTime.getHours(), 2, "0")
				+ "30"
			}
			return result;
		}
	}
	
	/**
	 * 어떤 시간값에 임의의 분값(음수 가능)이 더해졌을때 결과 시간을 구한다.
	 * 반올림 처리를 하는 경우(isRound가 true)에는
	 * 30분을 기준으로 반올림 처리한다.  
	 * 
	 * @param sBaseHours 부동소수점형 시간값
	 * @param mins 더하거나 뺄 분값
	 * @param isRound 반올림유무
	 * @return 부동소수점형 시간값(소수점한자리)
	 */
	function getAddedHoursByMin(sBaseHours, mins, isRound){
		var baseMins = Number(sBaseHours) * 60;
		var targetMins = baseMins + mins;
		var xHours = 0;
		if(isRound){
			xHours = mins2hrs(targetMins);
		}else{
			xHours = Math.round(targetMins/60*10)/10;
		}
		return xHours;
	}
	
	/**
	 * 분값을 시간값으로 변환한다.
	 * VOP_VSK_0015에서는 30분을 0.5 시간으로 변환하여 반올림/버림 처리한다.
	 * 즉, 40분은 1시간, 25분은 0시간, 30분은 0.5 시간이다.
	 * 
	 * @param mins
	 * @return 부동소수점형 시간값(소수점한자리) 
	 */
	function mins2hrs(mins){
		var xHours = Math.floor(Number(mins)/30); // mins가 91이면 xHours=3
		var xMins = Number(mins) - xHours*30; // mins가 91이면 xMins=1
		if(xMins>30){
			xHours++;
		}
		return xHours * 0.5; // 30분을 0.5시간이므로 xHours=1.5
	}
    
	/* 개발자 작업  끝 */