/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0105.js
*@FileTitle : Budget VSL SKD Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
=========================================================*/
/**************************************************************************************
 * 2009.06.23 수정 및 요청사항
 * 
 * [완료][Row Add, Row Insert, Delete] Button은 TURN_PORT_IND_CD가 (D, V, F)일 경우는 막음.
 * [완료]TURN_PORT_IND_CD가 (D, V, F)일 경우는 ETA, ETB, ETD만 수정가능.
 * [완료]ETA, ETB, ETD 날짜 Validation Check는 해당 날짜 변경 시 바로 체크(이전 Port부터 다음 Port까지만 체크하면 됨).
 * [완료]날짜 체크중 에러 시 메세지([Port Code]에 ETA, ETB, ETD 날짜를 정확히 입력해 주세요.) 출력 후 해당 컬럼으로 포커스 이동
 * [완료]변경 못하는 셀 terminal 코드 조회 로직 제외시킴.
 * [완료]terminal 코드 조회 못하는 부분...확인
 * [완료]Turn Indicator 가 Y인 Row는 필수입력 - 해당 Turning Port VVD Cell 필수입력 가능하게 색깔변경.
 * [완료]Turn Indicator 가 Y인 Row는 필수입력 - 저장 시 Validation Check 중 에러 시 해당 Port 이름 보여주고 해당 Cell로 포커스 이동.
 * [완료]Turn Indicator 가 Y이면 해당 Turn VVD가 동일한지 저장 시 체크
 * [완료]TURN_PORT_IND_CD가 'D, V, F'인 것들(Virtual Port)도 해당 VVD를 찾아 수정
 * [완료]Validation Check 중 에러면 해당 Cell로 포커스 이동
 * --------------------------------------------------------------------------------------
 * 2009.06.26 수정 및 요청사항
 * 
 * [완료]저장 시 ETA, ETB, ETD 날짜 포맷 체크
 * --------------------------------------------------------------------------------------
 * 2009.07.13 수정 및 요청사항
 * 
 * [완료]저장 시 Yard Code Null 체크
 * [완료]조회조건 란의 Lane Code 수정가능
 * [완료]Rmk 수정(Save) 확인.
 * --------------------------------------------------------------------------------------
 * 2009.07.16 수정 및 요청사항
 * 
 * Call Indicator Col 제거
 * [완료]Rmk만 수정 시 저장 안됨.
 * [완료]Turn Indicator 'Y'에서 'N'으로 변경 시 해당 Virtual Port 정보도 같이 삭제되도록 수정
 * [완료]전체 삭제 혹은 Turn Indicator 'Y'인 Port 삭제 시 해당 Virtual Port 정보도 같이 삭제되도록 수정
 * [완료]전체 Check 후 조회하면 전체 Check 계속 남아 있음.
 * [완료]pf_svc_tp_cd 는 조회한 데이타로 Setting.
 * --------------------------------------------------------------------------------------
 * 2009.08.06 수정 및 요청사항
 * 
 * [완료]Row Insert 시 Turn Dir 최초 선택 안되어 있도록.
 * [완료]Turn Port를 모두 'N'으로 수정 시 해당 Virtual Port가 삭제 안됨(한건은 잘 지워짐).
 * [완료]Turn Port 에 자신의 항차입력 안되도록 체크.
 * Row Insert 후 Del 체크하면 Insert 한 Row가 사라짐.
 * [완료]Row Add 시 Virtual Port 바로 위에 Add 되도록 수정.
 * [완료]Turminal Code Combo에 Name도 같이 보여주도록 처리.
 */
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
	 * @class VOP_VSK_0105 : VOP_VSK_0105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_VSK_0105() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
    	this.initCombo            	= initCombo;
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
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var portDataFlgs = new Array();		//그리드의 Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
	
	var glbEditColor = null;
	var glbDisableColor = null;
	var glbFixColor = null;
	
	var glbBookingChk = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			//disabled된 button은 Event 실행을 막는다.
			if(window.event.srcElement.className.indexOf('_1') > 0){
				return;
			}

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				
				case "btn_new":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
					
				case "btn_pfsked":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
					break;
					
				case "btn_add":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
					
				case "btn_insert":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
					
				case "btn_del":
					doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;
					
				case "btn_vvd_search":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
					break;
					
				case "btn_vsl_slan_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND04);
					break;
					
//				case "btn_main_title":
//					doActionIBSheet(sheetObject,formObject,COMMAND33);
//					break;
					
//	                case "btn_CheckAll":
//	                	sheetObject.CheckAll2("del_chk") = 1;
//	                    break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
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
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}

		initLoadDirection(sheetObjects[0]);
		
		initControl();
		
		initButton(document.form);
		
		glbEditColor = sheetObjects[0].RgbColor(128, 255, 255);
		glbDisableColor = sheetObjects[0].RgbColor(239, 239, 239);
		glbFixColor = sheetObjects[0].RgbColor(255, 255, 255);
		
//		화면 Open시 첫번째 Row는 만들어 주세요. 
//		생성하는 화면이기 때문에 Row Add 버튼 클릭 없이 바로 Port 정보를 입력할 수 있어야 합니다.
		sheetObjects[0].DataInsert(-1);
		resetClptSeq(sheetObjects[0]);
		
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

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 345;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(84, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					/*
					 * mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
					 *  
					 * SortEnable Boolean 선택  해더 행의 소트 가능 여부, Default=true 
					 * ColumnMove Boolean 선택  해더 행의 컬럼 이동 가능 여부, Default=false
					 * AllCheckEnable Boolean 선택  해더 행의 전체 CheckBox 표시 여부, Default=true
					 * UserResize Boolean 선택  해더 행의 컬럼 너비 변경 가능 여부, Default=true
					 * RowMove Boolean 선택  좌측 해더의 행 이동 가능 여부, Default=false
					 * Head3D Boolean 선택  해더 셀의 모양의 입체 여부Default=true 
					 */
					InitHeadMode(false, false, true, true, false, false);

					var HeadTitle1 = "|Sel|Seq.|Port Code|TMNL Code|ETA|ETB|ETD|T/Port IND|Turning Port Information|Turning Port Information|Turning Port Information";
					var HeadTitle2 = "|Sel|Seq.|Port Code|TMNL Code|ETA|ETB|ETD|T/Port IND|Voyage No.|Direction|Call Indicator";
					

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);



					//데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  							KEYFIELD, 	CALCULOGIC, DATAFORMAT, 		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	FULLINPUT, 	SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,		prefix+"del_chk",					false,		"",			dfNone,				0,			true,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"clpt_seq",					false,		"",			dfNone,				0,			false,		false,		-1,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"vps_port_cd",				true,		"",			dfEngUpKey,			0,			false,		true,		5,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,		prefix+"tml_cd",					false,		"",			dfNone,				0,			true,		true,		2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,		prefix+"vps_eta_dt",				true,		"",			dfUserFormat2,		0,			true,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,		prefix+"vps_etb_dt",				true,		"",			dfUserFormat2,		0,			true,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,		prefix+"vps_etd_dt",				true,		"",			dfUserFormat2,		0,			true,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		90,		daCenter,	true,		prefix+"turn_port_flg",				true,		"",			dfNone,				0,			true,		true,		1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		prefix+"turn_skd_voy_no",			false,		"",			dfNone,				0,			false,		false,		4,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	false,		prefix+"turn_skd_dir_cd",			false,		"",			dfEngUpKey,			0,			false,		false,		1,			false,		false);
//					InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	false,		prefix+"turn_clpt_ind_seq",			false,		"",			dfNone,				0,			false,		false,		1,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix+"turn_clpt_ind_seq",			false,		"",			dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_cd",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_voy_no",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_dir_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_slan_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_sts_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_voy_tp_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_usd_ind_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pf_skd_tp_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"st_port_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"n1st_port_brth_dt",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"psdo_vvd_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"co_cd",						false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_rmk",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"cre_usr_id",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"cre_dt",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"upd_usr_id",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"upd_dt",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"clpt_ind_seq",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"slan_cd",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_skd_sts_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"call_yd_ind_seq",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pf_eta_dt",					false,		"",			dfUserFormat2,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pf_etb_dt",					false,		"",			dfUserFormat2,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pf_etd_dt",					false,		"",			dfUserFormat2,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"init_eta_dt",				false,		"",			dfUserFormat2,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"init_etb_dt",				false,		"",			dfUserFormat2,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"init_etd_dt",				false,		"",			dfUserFormat2,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_dlay_rsn_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_dlay_rsn_desc",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_dlay_rsn_loc_cd",		false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"shp_call_no",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"shp_call_no_upd_usr_id",	false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"shp_call_no_upd_dt",		false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"tml_vsl_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"tml_voy_no",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"ft_dt",						false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"plism_yd_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"plism_vsl_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"plism_voy_no",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_cng_sts_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"turn_port_ind_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"ib_cgo_qty",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"ob_cgo_qty",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vps_rmk",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"phs_io_rsn_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"phs_io_rmk",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_brth_no",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"init_skd_inp_flg",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"ofc_inp_flg",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"noon_rpt_inp_flg",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"dep_rpt_inp_flg",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"act_inp_flg",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"prt_chk_flg",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"edi_snd_knt",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_skp_tp_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_skp_rsn_cd",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_skp_rsn_offr_rmk",		false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"ttl_dlay_hrs",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"ts_port_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"usd_flg",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pf_svc_tp_cd",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_rotn_seq",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"dir_seq",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"new_clpt_ind_seq",			false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"lnk_spd",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"sea_buf_hrs",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_buf_hrs",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"tztm_hrs",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"act_wrk_hrs",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"lnk_dist",					false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"mnvr_out_hrs",				false,		"",			dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"mnvr_in_hrs",				false,		"",			dfNone,				0,			false,		true);
					
					InitDataCombo(0, prefix+"turn_port_flg", "Y|N", "Y|N", "N");
					
					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pf_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pf_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pf_etd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"init_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"init_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"init_etd_dt", "####-##-## ##:##", "-|:" );
//					InitUserFormat2(0, prefix+"turn_skd_voy_no", "####", "" );
					InitDataValid(0, prefix+"turn_skd_voy_no", vtNumericOnly);
					InitDataValid(0, prefix+"vps_port_cd", vtEngUpOther, "0123456789");
					
					SelectionMode = smSelectionFree;
					CountPosition = "0";
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
	    	case "pf_svc_tp_cd":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("50|40");
  					DropHeight = 160;
   		    	}
   	    		break;
   	     }
   	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var prefix = sheetObj.id + "_";
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}
				break;

			case SEARCH01:		//Terminal(Yard) List
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
					
					return sXml;
				}
						 
				break;
			case SEARCH02:		//pf_svc_tp_cd
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH02;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
					
					return sXml;
				}
						 
				break;
			case SEARCH03:		//Create SKD
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH03;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
					
					return sXml;
				}
						 
				break;
			case SEARCH04:		//initLoadDirection
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH04;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
					
					return sXml;
				}
						 
				break;
			case SEARCH05:		//Lane Code/Direction Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH05;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
					
					return sXml;
				}
						 
				break;
			case SEARCH10:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH10;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
					
					return sXml;
				}
						 
				break;

			case IBSAVE:        //Save
				if(validateForm(sheetObj,formObj,sAction)){
					var sParam = ComGetSaveString(sheetObjects, false);
					if (sParam == ""){
						return;
					} else {
						formObj.f_cmd.value = MULTI;
						sParam = sParam + "&" + FormQueryString(formObj);
					}
					
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0105GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
					
					//SAVE OK 일 경우 저장된 내용 다시 조회.
					var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}

				break;

			case IBCLEAR:      			// New
				clearAllData(sheetObj, formObj);
				break;

			case COMMAND01:		// P/F SKED Use
				if(validateForm(sheetObj, formObj, COMMAND01)){
					var urlTail = "vsl_slan_cd="+formObj.vsl_slan_cd.value;
					urlTail = urlTail + "&skd_dir_cd="+formObj.skd_dir_cd.value;
					urlTail = urlTail + "&pf_svc_tp_cd="+getComboObject("pf_svc_tp_cd").Code;
					var sUrl = "/hanjin/VOP_VSK_0109.do?" + urlTail;
                	ComOpenPopup(sUrl, 500, 310, "getPfSkdData", "0,0", true);
				}
				break;

			case COMMAND02:		// Row Add
//				var rowIdx = getLastRowAfterVirtual(sheetObj);	//Virtual Port 이전의 마지막 Port를 찾는다.
				var rowIdx = sheetObj.LastRow;
				
				sheetObj.DataInsert(rowIdx);
				resetClptSeq(sheetObj);
				setBaseRowData(sheetObj, formObj, rowIdx+1);
				initPortDataFlg(sheetObj);	// Terminal 재조회 Flag 초기화.
				sheetObj.SelectCell(rowIdx+1, prefix+"vps_port_cd", false);
				
				
				break;
				
			case IBINSERT:      		// Row Insert
				var rowIdx = sheetObj.SelectRow + sheetObj.HeaderRows - 1;
				if(rowIdx){
					if(rowIdx > sheetObj.HeaderRows){
						sheetObj.DataInsert(sheetObj.SelectRow);
						resetClptSeq(sheetObj);
						setBaseRowData(sheetObj, formObj, rowIdx);
						initPortDataFlg(sheetObj);	// Terminal 재조회 Flag 초기화.
						sheetObj.SelectCell(rowIdx, prefix+"vps_port_cd", false);
					}
				}
				break;
				
			case IBDELETE:      		// Row Delete
				var rowIdx = sheetObj.SelectRow + sheetObj.HeaderRows - 1;
				if(rowIdx){
					if(rowIdx > sheetObj.HeaderRows){
						ComRowHideDelete(sheetObj, prefix+"del_chk");
						resetClptSeq(sheetObj);
						resetClptIndSeq(sheetObj);	//clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
						initPortDataFlg(sheetObj);	// Terminal 재조회 Flag 초기화.
					}
				}
				break;

			case COMMAND03:      			// VVD Pop-up
				var vslCd = formObj.vsl_cd.value;
            	var sUrl = "";
            	
            	if(vslCd == ""){
            		sUrl = "/hanjin/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
            	}else{
            		sUrl = "/hanjin/VOP_VSK_0110.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
            	}
				break;

			case COMMAND04:      			// Slan Code Pop-up
				var sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				
            	ComOpenPopup(sUrl, 425, 470, "getLaneCodeData", "0,0", true);
            	
				if(validateForm(sheetObj, formObj, COMMAND04)){
	            	var sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
	            	
	            	
	            	if(sXml != null){
	            		var rootNode = VskGetXmlRootNode(sXml);
	        			var dataNode = rootNode.selectSingleNode("//ERROR/MESSAGE");
	        			if(dataNode){
	        				var nodeText = dataNode.text;

	        				if(nodeText != ""){
	        					sheetObj.LoadSearchXml(sXml);
	        					getComboObject("pf_svc_tp_cd").RemoveAll();
	        				}
	        			}else{
	        				setPfSvcTpCdCombo(sXml);
	        			}
	            	}
            	}
            	
				break;

//			case COMMAND33:      			// Test
//				if(validateForm(sheetObj,formObj,sAction)){
//					formObj.f_cmd.value = SEARCH33;
//					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
//					
//					alert(sXml);
//				}
//
//				break;
				
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = sheetObj.LastRow;
		
    	switch(sAction) {

			case IBSEARCH:      //조회
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				} else if (formObj.vsl_cd.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (formObj.skd_voy_no.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				}
				break;

			case COMMAND01:      	//Popup(p/f create)
				if(ComIsNull(formObj.vsl_slan_cd.value)){
					ComShowCodeMessage('VSK00027', "Lane Code");
					formObj.vsl_slan_cd.focus();
					return false;
				} else if (ComIsNull(formObj.vsl_cd.value)) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (ComIsNull(formObj.skd_voy_no.value)) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				}else if(formObj.skd_voy_no.value == "0000"){
					// '0000'항차는 못 만들도록 막음(김기원 차장 2010.03.13).
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.value = "";
					formObj.skd_voy_no.focus();
					return false;
				} else if (ComIsNull(formObj.skd_dir_cd.value)) {
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				}
				
				break;

			case COMMAND04:
			case COMMAND05:      	//vsl_slan_cd onChange Event
				if(!ComIsNull(formObj.vsl_slan_cd.value)){
					if(formObj.vsl_slan_cd.value.length < 3){
						ComShowCodeMessage("VSK01018", "[Lane Code]");
						getComboObject("pf_svc_tp_cd").RemoveAll();
						formObj.vsl_slan_cd.value = "";
						
						return false;
					}
				} else {
					getComboObject("pf_svc_tp_cd").RemoveAll();
					
					return false;
				}
				
				break;

			case COMMAND02:      //Row Add
				var turnPortIndCd = sheetObj.CellValue(totCnt-1, prefix+"turn_port_ind_cd");
				if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
					return false;
				}
				break;

			case IBSAVE:      //저장
				if(formObj.vsl_cd.value.length < 4){
					ComShowCodeMessage("VSK01018", "[Vessel Code]");
					formObj.vsl_cd.value = "";
					formObj.vsl_cd.focus();
					
					return false;
				}
				if(formObj.skd_voy_no.value.length < 4){
					ComShowCodeMessage("VSK01018", "[Voyage Number]");
					formObj.skd_voy_no.value = "";
					formObj.skd_voy_no.focus();
					
					return false;
				}else if(formObj.skd_voy_no.value == "0000"){
					// '0000'항차는 못 만들도록 막음(김기원 차장 2010.03.13).
					ComShowCodeMessage("VSK00101");
					formObj.skd_voy_no.value = "";
					formObj.skd_voy_no.focus();
					
					return false;
				}
				if(formObj.skd_dir_cd.value.length < 1){
					ComShowCodeMessage("VSK01018", "[Direction Code]");
					formObj.skd_dir_cd.value = "";
					formObj.vsl_slan_dir_cd.value = "";
					formObj.skd_dir_cd.focus();
					
					return false;
				}
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("VSK01018", "[Lane Code]");
					formObj.vsl_slan_cd.value = "";
					formObj.vsl_slan_cd.focus();
					
					return false;
				}
				
				if(formObj.vsl_svc_tp_cd.value != "O"){
					var comboObj = getComboObject("pf_svc_tp_cd");
					if(ComIsNull(comboObj.Code)){
						//VSK02005
						ComShowCodeMessage("VSK01018", "[Proforma Type Code]");
						comboObj.focus();
						
						return false;
					}
				}
				if(glbBookingChk == "X"){
					ComShowCodeMessage("VSK00093");
					return false;
				}
				if(glbBookingChk == "A"){
					ComShowCodeMessage("VSK00006");
					return false;
				}
//				if(1 < rowCnt){
//					//VSK02006
//					ComShowCodeMessage('VSK00027', "Direction Code");
//					return false;
//				}
				if(totCnt > headCnt){
					var turnVoyNo = "";
					var turnDirCd = "";
//					var turnSeq = "";
					var chkTurnVoyNo = "";
					var chkTurnDirCd = "";
					
					for(var i=headCnt; i<=totCnt; i++){
						//삭제한 Row는 체크 안함.
//						if(sheetObj.CellValue(i, prefix+"ibflag") != "D" && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
						if(sheetObj.RowStatus(i) != "D" && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
							/*
							 * Save시 Terminal Code가 입력되여 있는지 확인해 주세요.
							 * 해당 Row뿐만 아니고, 해당 VVD 전체 Teminal Code를 체크해 주시고,
							 * "Terminal Code를 입력해 주세요"라는 화면 메세지를 표시해 주시고,
							 * 입력되지 않은 Terminal Code 항목을 Focus On 해 주세요.
							 */
							var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
							if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
								if(sheetObj.CellValue(i, prefix+"tml_cd") == ""){
									ComShowCodeMessage("VSK00027", "Terminal Code");
									sheetObj.SelectCell(i, prefix+"tml_cd");
									return false;
								}
							}
							
							//Turn Indicator 가 Y인 Row는 필수입력 - 저장 시 Validation Check 중 에러 시 해당 Port 이름 보여주고 해당 Cell로 포커스 이동.
							if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
								if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no"))){
									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
									sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
									return false;
								} else if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))) {
									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
									sheetObj.SelectCell(i, prefix+"turn_skd_dir_cd");
									return false;
								}
	
								//Turn Indicator 가 Y이면 해당 Turn VVD가 동일한지 저장 시 체크
								turnVoyNo = sheetObj.CellValue(i, prefix+"turn_skd_voy_no");
								turnDirCd = sheetObj.CellValue(i, prefix+"turn_skd_dir_cd");
	//							turnSeq = sheetObj.CellValue(i, prefix+"turn_clpt_ind_seq");
								if(chkTurnVoyNo == ""){
									chkTurnVoyNo = turnVoyNo;
									chkTurnDirCd = turnDirCd;
								}else{
									if(turnVoyNo != chkTurnVoyNo){
										ComShowCodeMessage("VSK00034", sheetObj.CellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
										return false;
									}else if(turnDirCd != chkTurnDirCd){
										ComShowCodeMessage("VSK00034", sheetObj.CellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_skd_dir_cd");
										return false;
									}
								}
							}
//							else{
//								if(ComTrim(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd")) == ""){
//									sheetObj.CellValue2(i, prefix+"turn_skd_dir_cd") = ComTrim(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"));
//								}
//								if(ComTrim(sheetObj.CellValue(i, prefix+"turn_clpt_ind_seq")) == ""){
//									sheetObj.CellValue2(i, prefix+"turn_clpt_ind_seq") = ComTrim(sheetObj.CellValue(i, prefix+"turn_clpt_ind_seq"));
//								}
//							}
							
							//ETA 날짜 포맷 검사.
							if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//ETB 날짜 포맷 검사.
							if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//ETD 날짜 포맷 검사.
							if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							
							//ETA < ETB < ETD < Next ETA 순서를 유지.
							if(sheetObj.RowStatus(i) != "D" && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
								if(sheetObj.CellValue(i, prefix+"vps_eta_dt") < sheetObj.CellValue(i, prefix+"vps_etb_dt")){
									if(sheetObj.CellValue(i, prefix+"vps_etb_dt") < sheetObj.CellValue(i, prefix+"vps_etd_dt")){
										if(i<totCnt){
											for(var k=i+1; k<=totCnt; k++){
	//											if(sheetObj.CellValue(k, prefix+"ibflag") != "D" && sheetObj.CellValue(k, prefix+"skd_cng_sts_cd") != "S"){
												if(sheetObj.RowStatus(k) != "D" && sheetObj.CellValue(k, prefix+"skd_cng_sts_cd") != "S"){
													if(sheetObj.CellValue(i, prefix+"vps_etd_dt") < sheetObj.CellValue(k, prefix+"vps_eta_dt")){
														//pass
													}else{
														ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
														sheetObj.SelectCell(i, prefix+"vps_etd_dt");
														return false;
													}
													break;
												}
											}//end for
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
							
							//Port Code Check...
							if(sheetObj.CellValue(i, prefix+"vps_port_cd").length < 5){
								ComShowCodeMessage("VSK01018", "[Port Code]");
								sheetObj.SelectCell(i, prefix+"vps_port_cd");
								return false;
							}
							
							//Terminal Code Check...
							if(!ComIsNull(sheetObj.CellValue(i, prefix+"tml_cd"))){
								if(sheetObj.CellValue(i, prefix+"tml_cd").length < 2){
									ComShowCodeMessage("VSK01018", "[Yard Code]");
									sheetObj.SelectCell(i, prefix+"tml_cd");
									return false;
								}
							}
							
							//Turn Port 에 자신의 항차입력 안되도록 체크.
							if(sheetObj.CellValue(i, prefix+"vsl_cd") == ""){
								sheetObj.CellValue(i, prefix+"vsl_cd") = formObj.vsl_cd.value;
							}
							if(sheetObj.CellValue(i, prefix+"skd_voy_no") == ""){
								sheetObj.CellValue(i, prefix+"skd_voy_no") = formObj.skd_voy_no.value;
							}
							if(sheetObj.CellValue(i, prefix+"skd_dir_cd") == ""){
								sheetObj.CellValue(i, prefix+"skd_dir_cd") = formObj.skd_dir_cd.value;
							}
							if(sheetObj.CellValue(i, prefix+"skd_voy_no") == sheetObj.CellValue(i, prefix+"turn_skd_voy_no")
							   && sheetObj.CellValue(i, prefix+"skd_dir_cd") == sheetObj.CellValue(i, prefix+"turn_skd_dir_cd")){
								ComShowCodeMessage("VSK00052");
								sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
								return false;
							}
							
						}
					}//End for
				}
				break;
				
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
//    	formObj.f_cmd.value = sAction;
    	formObj.f_cmd.value = SEARCH;
    	
    	var prefix = sheetObj.id + "_";
		var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0105GS.do", sParam);
		ComOpenWait(false);
		
		showSheetData(sheetObj, formObj, sXml, false);
		
		initButton(formObj);

		//All Check 초기화
		sheetObj.CheckAll(prefix+"del_chk") = 0;
    }
    
    /**
     * 조회 후 처리로직.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @param isCreateFlg	스케줄 생성 여부.
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml, isCreateFlg){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	
    	glbBookingChk = "";
    	
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					//Booking 상태값.
					glbBookingChk = ComGetEtcData(sXml, "booking_chk");
					
					var vslSvcTpCd = ComGetEtcData(sXml, "vsl_svc_tp_cd");
					formObj.vsl_svc_tp_cd.value = vslSvcTpCd;
					
					sheetObj.Redraw = false;
					try{
						if(isCreateFlg){
							rowAllHiddenByCreate(sheetObj);
							sheetObj.LoadSearchXml(sXml, true);
						}else{
							sheetObj.RemoveAll();
							sheetObj.LoadSearchXml(sXml);
						}
						
						initPortDataFlg(sheetObj);
						
						var ydCds = ComGetEtcData(sXml, "tml_cd").split("|");
						var ydIdx = 0;
						if(ydCds != null && ydCds != undefined && ydCds != ""){
							// ydCds.length = sheetObj.RowCount
					    	for(var i=headCnt; i<=sheetObj.LastRow; i++) {
//					    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
					    		if(sheetObj.RowStatus(i) != "D"){
						    		sheetObj.CellComboItem(i, prefix+"tml_cd", ydCds[ydIdx], ydCds[ydIdx]);
						    		sheetObj.CellValue2(i, prefix+"tml_cd") = ydCds[ydIdx];
		
						    		var turnPortFlg = sheetObj.CellValue(i, prefix+"turn_port_flg");
						    		if(turnPortFlg == "N"){
						    			sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = false;
//						    			sheetObj.CellEditable(i, prefix+"turn_clpt_ind_seq") = false;
						    		}else{
						    			sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = true;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = true;
						    		}
						    		
						    		var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
						    		if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
//						    			TURN_PORT_IND_CD가 (D, V, F)일 경우는 ETA, ETB, ETD만 수정가능.
//						    			Yard Code 도 수정 가능하게 수정(2009.10.21 - 임창빈 수석)
//						    			sheetObj.CellEditable(i, prefix+"del_chk") = false;
						    			sheetObj.CellEditable(i, prefix+"clpt_seq") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
//						    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = false;
//						    			sheetObj.CellEditable(i, prefix+"") = false;
						    		}
						    		
//						    		Turn Indicator 가 Y인 Row는 필수입력 - 해당 Turning Port VVD Cell 필수입력 가능하게 색깔변경.
						    		if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
						    			sheetObj.CellBackColor(i, prefix+"turn_skd_voy_no") = glbEditColor;
						    			sheetObj.CellBackColor(i, prefix+"turn_skd_dir_cd") = glbEditColor;
//						    			sheetObj.CellBackColor(i, prefix+"turn_clpt_ind_seq") = glbEditColor;
						    		}
						    		
//						    		Arrival / Departure Report 가 존재하는 경우 삭제 불가
						    		var portSkdStsCd = sheetObj.CellValue(i, prefix+"port_skd_sts_cd");
						    		if(portSkdStsCd == "A"){
						    			sheetObj.CellEditable(i, prefix+"del_chk") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
						    			
						    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = false;
						    		} else if(portSkdStsCd == "B") {
						    			sheetObj.CellEditable(i, prefix+"del_chk") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
						    			
						    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = false;
						    		} else if(portSkdStsCd == "D") {
						    			sheetObj.CellEditable(i, prefix+"del_chk") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
						    			sheetObj.CellEditable(i, prefix+"vps_etd_dt") = false;
						    			
						    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = false;
						    			sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = false;
						    		}
						    		
						    		//Skip 한 Port 는 수정 불가
						    		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						    			rowEditableBySkip(sheetObj, i, false);
						    			fontColorChangeBySkip(sheetObj, i);
						    		}
						    		
						    		ydIdx++;
						    		
//						    		sheetObj.CellValue2(i, prefix+"ibflag") = "U";
						    		sheetObj.RowStatus(i) = "U";
					    		}
							} // end for
						}
						
						sheetObj.Redraw = true;
					}catch(e){
						ComShowMessage(e);
						sheetObj.Redraw = true;
					}
		    		
					
					var vslSlanCd = ComGetEtcData(sXml, "vsl_slan_cd");
					if(vslSlanCd != null && vslSlanCd != undefined){
						formObj.vsl_slan_cd.value = vslSlanCd;
					}
					
					var skdRmk = ComGetEtcData(sXml, "skd_rmk");
					if(skdRmk != null && skdRmk != undefined){
						formObj.skd_rmk.value = skdRmk;
					}
					
					setPfSvcTpCdCombo(sXml);
					
					setFormData(sheetObj, headCnt, 1);
					
					resetClptSeq(sheetObj);
				}else{
					//조회된 데이타가 없습니다.
					ComShowCodeMessage("VSK00043");

			    	formObj.vsl_slan_cd.value = "";
			    	formObj.cre_dt.value = "";
			    	formObj.cre_usr_id.value = "";
			    	formObj.upd_dt.value = "";
			    	formObj.upd_usr_id.value = "";
			    	formObj.skd_rmk.value = "";
			    	
			    	getComboObject("pf_svc_tp_cd").RemoveAll();
			    	
			    	sheetObj.RemoveAll();
			    	//VVD를 입력하고 조회해서 결과값이 없을 경우에도 한줄을 Insert를 해 주세요.
					sheetObj.DataInsert(-1);
					resetClptSeq(sheetObj);
					
					setBaseRowData(sheetObj, formObj, sheetObj.HeaderRows);
				}
			}else{
				sheetObj.LoadSearchXml(sXml);
			}
		}
    }
	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */

	function sheet1_OnClick(sheetObj, Row, Col) {
//		alert(sheetObj.CellValue(Row, Col));
//		alert(sheetObj.CellValue(Row, sheetObj.id+"_pf_eta_dt"));
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"vps_port_cd"){
//				변경 못하는 셀 terminal 코드 조회 로직 제외시킴
				if(!sheetObj.CellEditable(Row, Col)){
					return;
				}
				
				portDataFlgs[Row-headCnt] = "N";
				
				formObj.loc_cd.value = sheetObj.CellValue(Row, prefix+"vps_port_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
				
				var chkPort = ComGetEtcData(sXml, "check_port");
				
				if(chkPort == "X"){
					if(sXml != null && sXml != undefined && sXml != ""){
						var rootNode = VskGetXmlRootNode(sXml);
						var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue = dataNode.value;
	
							if(totValue > 0){
								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.CellValue2(Row, sheetObj.id+"_tml_cd") = "";
							}
						}
					}
					portDataFlgs[Row-headCnt] = "Y";
				}else{
					//해당 Port({?msg1})가 존재하지 않습니다.
					ComShowCodeMessage("VSK00029", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
					
					sheetObj.CellValue2(Row, prefix+"vps_port_cd") = "";
					sheetObj.SelectCell(Row, prefix+"vps_port_cd");
					
					portDataFlgs[Row-headCnt] = "N";
				}
				
				resetClptIndSeq(sheetObj);	//clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
			}
			else if(colName == prefix+"vps_eta_dt" || colName == prefix+"vps_etb_dt" || colName == prefix+"vps_etd_dt"){
				//ETA, ETB, ETD 날짜 포맷 검사.
				if(isDateValid(sheetObj, Row, Col) == false){
					return false;
				}
////				ETA, ETB, ETD 날짜 Validation Check는 해당 날짜 변경 시 바로 체크(이전 Port부터 다음 Port까지만 체크하면 됨).
////				날짜 체크중 에러 시 메세지([Port Code]에 ETA, ETB, ETD 날짜를 정확히 입력해 주세요.) 출력 후 해당 컬럼으로 포커스 이동
//				if(Row > headCnt){
//					if(sheetObj.CellValue(Row-1, prefix+"vps_etd_dt") < sheetObj.CellValue(Row, prefix+"vps_eta_dt")){
//						if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") < sheetObj.CellValue(Row, prefix+"vps_etb_dt")){
//							if(sheetObj.CellValue(Row, prefix+"vps_etb_dt") < sheetObj.CellValue(Row, prefix+"vps_etd_dt")){
//								if(Row < headCnt + sheetObj.RowCount){
//									if(sheetObj.CellValue(Row, prefix+"vps_etd_dt") < sheetObj.CellValue(Row+1, prefix+"vps_eta_dt")){
//										//pass
//									}else{
//										ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//										sheetObj.SelectCell(Row, Col);
//										return;
//									}
//								}
//							} else {
//								ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//								sheetObj.SelectCell(Row, Col);
//								return;
//							}
//						} else {
//							ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//							sheetObj.SelectCell(Row, Col);
//							return;
//						}
//					}else{
//						ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//						sheetObj.SelectCell(Row, Col);
//						return;
//					}
//				}else{
//					if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") < sheetObj.CellValue(Row, prefix+"vps_etb_dt")){
//						if(sheetObj.CellValue(Row, prefix+"vps_etb_dt") < sheetObj.CellValue(Row, prefix+"vps_etd_dt")){
//							if(sheetObj.CellValue(Row, prefix+"vps_etd_dt") < sheetObj.CellValue(Row+1, prefix+"vps_eta_dt")){
//								//pass
//							}else{
//								ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//								sheetObj.SelectCell(Row, Col);
//								return;
//							}
//						} else {
//							ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//							sheetObj.SelectCell(Row, Col);
//							return;
//						}
//					} else {
//						ComShowCodeMessage("VSK00032", sheetObj.CellValue(Row, prefix+"vps_port_cd"));
//						sheetObj.SelectCell(Row, Col);
//						return;
//					}
//				}
			}
			else if(colName == prefix+"turn_port_flg"){
//	    		Turn Indicator 가 Y인 Row는 필수입력 - 해당 Turning Port VVD Cell 필수입력 가능하게 색깔변경.
	    		if(sheetObj.CellValue(Row, prefix+"turn_port_flg") == "Y"){
	    			sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = true;
	    			sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = true;
	    			sheetObj.CellBackColor(Row, prefix+"turn_skd_voy_no") = glbEditColor;
	    			sheetObj.CellBackColor(Row, prefix+"turn_skd_dir_cd") = glbEditColor;
	    			
	    			/*
	    			 * 첫번째 Row는 Turn Flag가 'Y' 일 경우
	    			 * MDM_VSL_SVC_LANE_DIR 의 VSL_SLAN_DIR_SEQ 가 
	    			 * 1 이면 turn_port_ind_cd 는 'N' 이고
	    			 * 2 이면 turn_port_ind_cd 가 'Y'
	    			 * [2009.08.05 임창빈 수석 정의]
	    			 */
	    			if(headCnt == Row){
		    			if(sheetObj.CellValue(Row, prefix+"dir_seq") == "1"){
		    				sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "N";
		    			}else{
		    				sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "Y";
		    			}
	    			}else{
	    				sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "Y";
	    			}
	    		}else{
	    			sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = false;
	    			sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = false;
	    			sheetObj.CellBackColor(Row, prefix+"turn_skd_voy_no") = glbDisableColor;
	    			sheetObj.CellBackColor(Row, prefix+"turn_skd_dir_cd") = glbDisableColor;
	    			
	    			sheetObj.CellValue2(Row, prefix+"turn_port_ind_cd") = "N";
	    			sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = "";
	    			sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = "";
	    		}
			}
		}
	}
	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		
		if(NewRow >= headCnt && NewCol > 0){
			var sXml = null;
			var prefix = sheetObj.id + "_";
			
			//[Row Add, Row Insert, Delete] Button은 turn_port_ind_cd가 (D, V, F)일 경우는 막음.
			var turnPortIndCd = sheetObj.CellValue(NewRow, prefix+"turn_port_ind_cd");
			if(glbBookingChk != "X" && glbBookingChk != "A"){
				if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
	//				ComBtnDisable("btn_add");
					ComBtnDisable("btn_insert");
	//				ComBtnDisable("btn_del");
				}else{
	//				ComBtnEnable("btn_add");
					ComBtnEnable("btn_insert");
	//				ComBtnEnable("btn_del");
				}
			}
			
			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
//				변경 못하는 셀 terminal 코드 조회 로직 제외시킴
				if(!sheetObj.CellEditable(NewRow, NewCol)){
					return;
				}
//				if(portDataFlgs[NewRow-headCnt] == "N"){
				if(portDataFlgs[NewRow-headCnt] != "Y"){
					var locCd = sheetObj.CellValue(NewRow, prefix+"vps_port_cd");
					if(locCd != null && locCd != undefined && locCd != ""){
						formObj.loc_cd.value = locCd;
						sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
						
						if(sXml != null && sXml != undefined && sXml != ""){
							setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
						}
						portDataFlgs[NewRow-headCnt] = "Y";
					}
				}
			}
			
//			VSK_VSL_PORT_SKD의 데이타에서 VKS_VSL_SKD의 데이타로 변경되어 불필요함.
			setFormData(sheetObj, NewRow, NewCol);
		}
	}

	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
//	function pf_svc_tp_cd_OnChange(comboObj, Index_Code, Text) {
//		isRmkModFlg = "Y";
//	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
//    	axon_event.addListenerForm('activate', "obj_activate", form);
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
	}
    
	function obj_change(){
		var formObj = document.form;
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObj = sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var srcValue = window.event.srcElement.getAttribute("value");
	        switch(srcName) {
	
	            case "vsl_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		if(srcValue.length == 4){
				    		formObj.skd_voy_no.focus();
				    	}
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;

	            case "skd_voy_no":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 4){
			    		formObj.skd_dir_cd.focus();
			    	}
	            	break;
	            case "skd_dir_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 1){
			    		formObj.vsl_slan_cd.focus();
			    	}
	            	
	            	formObj.vsl_slan_dir_cd.value = formObj.skd_dir_cd.value;
	            	
	            	if(!isPfValid(sheetObj, formObj)){
	            		if(formObj.vsl_slan_cd.value != ""){
		            		formObj.vsl_slan_dir_cd.value = "";
		            		formObj.skd_dir_cd.value = "";
	            		}
	            	}
	            	break;
	
	            case "vsl_slan_cd":
	            	if(!isPfValid(sheetObj, formObj)){
	            		if(formObj.vsl_slan_dir_cd.value != "" || formObj.skd_dir_cd.value != ""){
	            			formObj.vsl_slan_cd.value = "";
	            		}
	            	}
	            	
	            	if(validateForm(sheetObj, formObj, COMMAND05)){
		            	var sXml = doActionIBSheet(sheetObj,formObj,SEARCH02);
		            	
		            	if(sXml != null){
		            		var rootNode = VskGetXmlRootNode(sXml);
		        			var dataNode = rootNode.selectSingleNode("//ERROR/MESSAGE");
		        			if(dataNode){
		        				var nodeText = dataNode.text;

		        				if(nodeText != ""){
		        					sheetObj.LoadSearchXml(sXml);
		        					formObj.vsl_slan_cd.value = "";
		        					getComboObject("pf_svc_tp_cd").RemoveAll();
		        				}
		        			}else{
		        				var svcTpCd = ComGetEtcData(sXml, "svc_tp_cd");
		    					formObj.vsl_svc_tp_cd.value = svcTpCd;
		        				setPfSvcTpCdCombo(sXml);
		        			}
		            	}
	            	}
	            	
	            	clearDescData(sheetObj, formObj, "");
	            	
	            	if(srcValue.length == 3){
			    		getComboObject("pf_svc_tp_cd").focus();
			    	}
	            	
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

		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;

		    case "skd_rmk":
		    	if(formObj.skd_rmk.value.length > 4000){
		    		ComShowCodeMessage("VSK01019", "[Remark]");
		    		return false;
		    	}
				break;
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
		    		formObj.vsl_slan_cd.focus();
		    	}

		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		getComboObject("pf_svc_tp_cd").focus();
		    	}
				break;
		}
	}
		
//	function obj_activate(){
//		var srcName = event.srcElement.name;
//	
//		switch(srcName){
//			case "vsl_cd":
//			case "skd_voy_no":
//			case "skd_dir_cd":
//				event.srcElement.select();
//				break;
//		}
//	}
    
	
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */

    /**
     * Slan Code Pop-up 처리.
     * @param rtnObjs
     * @return
     */
	function getLaneCodeData(rtnObjs){
		var formObj = document.form;
		
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_slan_cd.value = rtnDatas[1];
				}
			}
    	}
	}
    
	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.
	 * @param rtnObjs
	 * @return
	 */
    function getVslCdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value = rtnDatas[1];
				}
			}
    	}
    }

    /**
     * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.
     * @param rtnObjs
     * @return
     */
	function getVvdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value = rtnDatas[2];
					document.form.skd_dir_cd.value = rtnDatas[3];
					document.form.vsl_slan_dir_cd.value = rtnDatas[3];
				}
			}
    	}
    }
	
	/**
	 * Information Input for SKD Creation (P/F SKD Use) (Pop-Up)에서 받은 데이타 처리.
	 * @param rtnObjs
	 * @return
	 */
	function getPfSkdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					var formObj = document.form;
					var sheetObj = sheetObjects[0];
					
					formObj.vsl_slan_cd.value = rtnDatas[1];		//vsl_slan_cd
					getComboObject("pf_svc_tp_cd").Code2 = rtnDatas[3];
					formObj.vps_port_cd.value = rtnDatas[4];		//port_cd
					formObj.skd_dir_cd.value = rtnDatas[5];			//skd_dir_cd
					formObj.vsl_slan_dir_cd.value = rtnDatas[5];	//skd_dir_cd
					formObj.vps_etb_dt.value = ComReplaceStr(rtnDatas[7],"-","");			//vps_etb_dt
					formObj.clpt_seq.value = rtnDatas[8];	//clpt_seq
					
					//스케줄을 생성.
					creatSkd(sheetObj, formObj);
					
					getComboObject("pf_svc_tp_cd").Code2 = rtnDatas[3];
				}
			}
    	}
	}
    
	
	/*
	 * =====================================================================
	 * Etc Function
	 * =====================================================================
	 */

	
	/**
	 * 선택한 Row의 데이타를 해당 Form에 Setting.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setFormData(sheetObj, Row, Col){
    	var form = document.form;
    	var prefix = sheetObj.id + "_";
    	
    	form.cre_usr_id.value = sheetObj.CellValue(Row, prefix+"cre_usr_id");
    	form.cre_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"cre_dt"));
    	form.upd_usr_id.value = sheetObj.CellValue(Row, prefix+"upd_usr_id");
    	form.upd_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"upd_dt"));
    }
	
	
	/**
	 * Sheet의 Terminal Combo Data Setting...
	 * @param xmlStr
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
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
			
			sheetObj.CellComboItem(Row, sheetObj.id+"_tml_cd", ydTxt, ydKindCode);
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
	 * 스케줄을 생성한다.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function creatSkd(sheetObj, formObj){
		var sXml = doActionIBSheet(sheetObj,formObj,SEARCH03);
		sheetObj.RemoveAll();
		
		showSheetData(sheetObj, formObj, sXml, true);

		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		
		if(sheetObj.RowCount > 0){
			var stPortCd = "";			//첫번째 Port
			var n1stPortBrthDt = "";	//첫번째 ETB
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				if(sheetObj.RowHidden(i) == false){
//					sheetObj.CellValue2(i, prefix+"ibflag") = "I";
					sheetObj.RowStatus(i) = "I";
					sheetObj.CellValue2(i, prefix+"vsl_cd") = formObj.vsl_cd.value;
					sheetObj.CellValue2(i, prefix+"skd_voy_no") = formObj.skd_voy_no.value;
					sheetObj.CellValue2(i, prefix+"skd_dir_cd") = formObj.skd_dir_cd.value;
					sheetObj.CellValue2(i, prefix+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
					sheetObj.CellValue2(i, prefix+"slan_cd") = formObj.vsl_slan_cd.value;
					
					if(sheetObj.CellValue(i, prefix+"clpt_seq") == "1"){
						stPortCd = sheetObj.CellValue(i, prefix+"vps_port_cd");
						n1stPortBrthDt = sheetObj.CellValue(i, prefix+"vps_etb_dt");
					}
					sheetObj.CellValue2(i, prefix+"st_port_cd") = stPortCd;
					sheetObj.CellValue2(i, prefix+"n1st_port_brth_dt") = n1stPortBrthDt;
				}
			}
		}
		
		formObj.skd_rmk.value = "";
		
		resetClptIndSeq(sheetObj);
	}
	
	/**
	 * 해당 xml을 읽어 pf_svc_tp_cd Combo를 Setting.
	 * @param sXml
	 * @return
	 */
	function setPfSvcTpCdCombo(sXml){
		var pfLaneTypeArr = ("|" + ComGetEtcData(sXml, "pf_svc_type_list")).split("|");
		var slanStndFlgArr = ("|" + ComGetEtcData(sXml, "slan_stnd_flag_list")).split("|");
		var pfSkdTpCd = ComGetEtcData(sXml, "pf_skd_tp_cd");
    	
		if(pfLaneTypeArr != null && pfLaneTypeArr != undefined && pfLaneTypeArr != ""){
			if(pfSkdTpCd == null || pfSkdTpCd == undefined || pfSkdTpCd == ""){
				//pfSkdTpCd 가 없으면 기준이 되는 PF_SVC_TP_CD를 찾아 Setting.
				if(slanStndFlgArr != null && slanStndFlgArr != undefined && slanStndFlgArr != ""){
					for(var i=0; i<slanStndFlgArr.length; i++) {
						if(slanStndFlgArr[i] == "Y"){
							pfSkdTpCd = pfLaneTypeArr[i]; 
						}
					}
				}
			}
		}
		
		appendMultiComboItem(getComboObject("pf_svc_tp_cd"), pfLaneTypeArr, slanStndFlgArr, pfSkdTpCd);
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
     * Terminal 재조회 방지위한 초기 데이타 처리.
     * @param sheetObj
     * @return
     */
    function initPortDataFlg(sheetObj){ 
    	var rows = sheetObj.Rows;
    	var headCnt = sheetObj.HeaderRows;
    	
    	for(var i=headCnt; i<rows; i++){
    		portDataFlgs[i-headCnt] = "N";
    	}
    }
	
    /**
     * 화면을 초기화 한다.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	glbBookingChk = "";
    	
    	formObj.vsl_cd.value = "";
    	formObj.skd_voy_no.value = "";
    	formObj.skd_dir_cd.value = "";
    	formObj.vsl_slan_dir_cd.value = "";
    	formObj.vsl_slan_cd.value = "";
    	formObj.cre_dt.value = "";
    	formObj.cre_usr_id.value = "";
    	formObj.upd_dt.value = "";
    	formObj.upd_usr_id.value = "";
    	formObj.skd_rmk.value = "";
    	
    	getComboObject("pf_svc_tp_cd").RemoveAll();
    	
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    	resetClptSeq(sheetObj);
    	
    	//All Check 초기화
    	sheetObj.CheckAll(sheetObj.id+"_del_chk") = 0;
    	
    	formObj.vsl_cd.focus();
    	
    	initButton(formObj);
    }
    
    /**
     * 조회 조건이 아닌 모든 데이타 초기화.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearDescData(sheetObj, formObj, sData){
    	formObj.cre_dt.value = "";
    	formObj.cre_usr_id.value = "";
    	formObj.upd_dt.value = "";
    	formObj.upd_usr_id.value = "";
    	
    	if(sData != "skd_rmk"){
    		formObj.skd_rmk.value = "";
    	}
    	
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    	resetClptSeq(sheetObj);
    	
    	setBaseRowData(sheetObj, formObj, sheetObj.HeaderRows);
    	
    	//All Check 초기화
    	sheetObj.CheckAll(sheetObj.id+"_del_chk") = 0;
    }
    
    /**
     * 최초 Row Add, Row Insert, Delete 버튼 상태 Setting...
     * 
     * @return
     */
    function initButton(formObj){
		if(glbBookingChk == "X"){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_pfsked");
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_insert");
			ComBtnDisable("btn_del");
			ComEnableObject(formObj.skd_rmk, false);
			//booking Msg
			ComShowCodeMessage("VSK00007");
		}else if(glbBookingChk == "A"){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_pfsked");
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_insert");
			ComBtnDisable("btn_del");
			ComEnableObject(formObj.skd_rmk, false);
			//Actual Msg
			ComShowCodeMessage("VSK00006");
		}else{
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_pfsked");
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_insert");
			ComBtnEnable("btn_del");
			ComEnableObject(formObj.skd_rmk, true);
		}
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
    	var totCnt = sheetObj.LastRow;
    	var idx = 0;
    	var vIbFlag = "";
    	
    	for(var i=headCnt; i<=totCnt; i++){
//    		alert(idx + ":" + sheetObj.CellValue(i, prefix+"ibflag"));
//    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//    			vIbFlag = sheetObj.CellValue(i, prefix+"ibflag");
//    			idx++;
//    			sheetObj.CellValue2(i, prefix+"clpt_seq") = idx;
//    			sheetObj.CellValue2(i, prefix+"ibflag") = vIbFlag;
//    		}
    		
    		if(sheetObj.RowStatus(i) != "D"){
    			vIbFlag = sheetObj.RowStatus(i);
    			idx++;
    			sheetObj.CellValue2(i, prefix+"clpt_seq") = idx;
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
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var prefix = sheetObj.id + "_";
    	var idx = 0;
    	var vIbFlag = "";
    	var preVvd = "";
    	var curVvd = "";
    	
    	for(var i=0; i<rowCnt; i++){
    		idx = 0;
//    		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
    		if(sheetObj.RowStatus(i+headCnt) != "D"){
	    		for(var j=0; j<=i; j++){
//	    			if(sheetObj.CellValue(j+headCnt, prefix+"ibflag") != "D"){
	    			if(sheetObj.RowStatus(j+headCnt) != "D"){
    					if(sheetObj.CellValue(i+headCnt, prefix+"vps_port_cd") == sheetObj.CellValue(j+headCnt, prefix+"vps_port_cd")){
    						idx++;
    					}
	    			}
	    		}//end for
//	    		vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//    			sheetObj.CellValue2(i+headCnt, prefix+"new_clpt_ind_seq") = idx;
//    			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
	    		vIbFlag = sheetObj.RowStatus(i+headCnt);
    			sheetObj.CellValue2(i+headCnt, prefix+"new_clpt_ind_seq") = idx;
    			sheetObj.RowStatus(i+headCnt) = vIbFlag;
    		}
    	}
    }
    
    /**
     * Skip 상태인 Row의 Editable Setting.
     * 
     * @param sheetObj
     * @param sRow
     * @param flg
     * @return
     */
    function rowEditableBySkip(sheetObj, sRow, flg){
    	var prefix = sheetObj.id + "_";
    	
    	sheetObj.CellEditable(sRow, prefix+"vps_port_cd") = flg;
    	sheetObj.CellEditable(sRow, prefix+"tml_cd") = flg;
    	sheetObj.CellEditable(sRow, prefix+"vps_eta_dt") = flg;
    	sheetObj.CellEditable(sRow, prefix+"vps_etb_dt") = flg;
    	sheetObj.CellEditable(sRow, prefix+"vps_etd_dt") = flg;
    	sheetObj.CellEditable(sRow, prefix+"turn_port_flg") = flg;
    	sheetObj.CellEditable(sRow, prefix+"turn_skd_voy_no") = flg;
    	sheetObj.CellEditable(sRow, prefix+"turn_skd_dir_cd") = flg;
    }
    
    /**
	 * Skip 상태인 Row의 Font Color Setting.
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		
//		cellFontToBackColor(sheetObj, sRow, prefix+"vps_port_cd");
//		cellFontToBackColor(sheetObj, sRow, prefix+"tml_cd");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"turn_port_flg");
		cellFontToBackColor(sheetObj, sRow, prefix+"turn_skd_voy_no");
		cellFontToBackColor(sheetObj, sRow, prefix+"turn_skd_dir_cd");
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
     * Row 생성 시 해당 Row의 기본적이 Data Setting.
     * @param sheetObj
     * @param rowIdx
     * @return
     */
    function setBaseRowData(sheetObj, formObj, rowIdx){
    	var prefix = sheetObj.id + "_";
    	
    	sheetObj.CellValue2(rowIdx, prefix+"vsl_cd") = formObj.vsl_cd.value;
    	sheetObj.CellValue2(rowIdx, prefix+"skd_voy_no") = formObj.skd_voy_no.value;
    	sheetObj.CellValue2(rowIdx, prefix+"skd_dir_cd") = formObj.skd_dir_cd.value;
    	sheetObj.CellValue2(rowIdx, prefix+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
    	sheetObj.CellValue2(rowIdx, prefix+"slan_cd") = formObj.vsl_slan_cd.value;
    	
//    	sheetObj.CellValue2(rowIdx, prefix+"init_etd_dt") = sheetObj.CellValue(rowIdx-1, prefix+"init_etd_dt");
    }
	
	/**
	 * Sheet의 Font Color를 Back Color로 변경.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function cellFontToBackColor(sheetObj, Row, Col){
		sheetObj.CellFontColor(Row, Col) = sheetObj.CellBackColor(Row, Col);
	}
    
    /**
     * Turnning Port의 Direction Code 목록을 Setting.
     * @param sheetObj
     * @return
     */
    function initLoadDirection(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var sXml = doActionIBSheet(sheetObj, document.form, SEARCH04);
    	
    	var sDirCds = ComGetEtcData(sXml, "direction_cd");
    	
    	sheetObj.InitDataCombo(0, prefix+"turn_skd_dir_cd", sDirCds, sDirCds, "", " ");
    }
    
    /**
     * Add Row의 마지막 Row를 찾는다.
     * - Virtual Port 이전 Port를 찾는다.
     * @param sheetObj
     * @return
     */
    function getLastRowAfterVirtual(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var rowIdx = headCnt-1;
    	
    	for(var i=0; i<rowCnt; i++){
    		var turnPortInd = sheetObj.CellValue(i+headCnt, prefix+"turn_port_ind_cd")
    		if(turnPortInd == "F" || turnPortInd == "V" || turnPortInd == "D"){
    			break;
    		}
    		rowIdx++;
    	}
    	
    	return rowIdx;
    }
    
    /**
     * 입력한 Lane Code 내에 입력한 Direction 이 존재하는지 확인한다.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isPfValid(sheetObj, formObj){
    	if(formObj.vsl_slan_dir_cd.value == "" || formObj.vsl_slan_cd.value == ""){
    		return;
    	}
    	var sXml = doActionIBSheet(sheetObj, formObj, SEARCH05);
    	
    	var laneYN = ComGetEtcData(sXml, "lane_chk");
    	
    	if(laneYN == "Y"){
    		//해당 Lane 에 Direction 이 존재함.
    		return true;
    	}
    	
    	ComShowCodeMessage("VSK00072", formObj.vsl_slan_cd.value, formObj.vsl_slan_dir_cd.value);
    	return false;
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
     * ETA, ETB, ETD 정합성(날짜 포맷) 체크
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function isDateValid(sheetObj, Row, Col){
    	var prefix = sheetObj.id + "_";
//    	var colIdx = sheetObj.SaveNameCol(Col);
    	var colName = sheetObj.ColSaveName(Col);
    	var errMsg = "";
    	
    	if(colName == prefix+"vps_eta_dt"){
    		//ETA 에러 메세지
    		errMsg = "(ETA-"+sheetObj.CellValue(Row, Col)+")";
    	}else if(colName == prefix+"vps_etb_dt"){
			//ETB 에러 메세지
    		errMsg = "(ETB-"+sheetObj.CellValue(Row, Col)+")";
    	}else if(colName == prefix+"vps_etd_dt"){
			//ETD 에러 메세지
    		errMsg = "(ETD-"+sheetObj.CellValue(Row, Col)+")";
    	}

		//ETA, ETB, ETD 날짜 포맷 검사.
		if(sheetObj.CellValue(Row, Col).length < 12){
			ComShowCodeMessage("VSK01018", errMsg);
			sheetObj.SelectCell(Row, Col);
			return false;
		}else{
			if(!ComIsDate(sheetObj.CellValue(Row, Col).substring(0,8))){
				ComShowCodeMessage("VSK01018", errMsg);
				sheetObj.SelectCell(Row, Col);
				return false
			}
			if(!ComIsTime(sheetObj.CellValue(Row, Col).substring(8,12), "hm")){
				ComShowCodeMessage("VSK01018", errMsg);
				sheetObj.SelectCell(Row, Col);
				return false
			}
		}
    	
    	return true;
    }
    
    function rowAllHiddenByCreate(sheetObj){
    	var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = sheetObj.LastRow;

		if(rowCnt > 0){
			for(var i=headCnt; i<=totCnt; i++){
//				if(sheetObj.CellValue(i, prefix+"vps_port_cd") == ""){
//					sheetObj.RowDelete(i);
//				}else 
//				alert(i+":"+sheetObj.CellValue(i, prefix+"ibflag"));
//				if(sheetObj.CellValue(i, prefix+"ibflag") == "I"){
				if(sheetObj.RowStatus(i) == "I"){
					sheetObj.RowDelete(i, false);
				}else{
//					sheetObj.CellValue2(i, prefix+"ibflag") = "D";
//					sheetObj.RowHidden(i)= true;
					sheetObj.CellValue2(i, prefix+"del_chk") = true;
					ComRowHideDelete(sheetObj, prefix+"del_chk");
				}
			}
		}
    }
    
	/* 개발자 작업  끝 */