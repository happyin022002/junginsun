/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_FMS_0097.js
*@FileTitle : (New)Owner’s Account
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
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
	 * @author 
	 */

	/**
	 * @extends 
	 * @class ESM_FMS_0097 : ESM_FMS_0097 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_FMS_0097() {
		this.processButtonClick			= processButtonClick;
		this.setSheetObject				= setSheetObject;
		this.initCombo					= initCombo;
		this.loadPage					= loadPage;
		this.sheet_OnLoadFinish			= sheet_OnLoadFinish;
		this.initSheet					= initSheet;
		this.initControl				= initControl;
		this.doActionIBSheet			= doActionIBSheet;
		this.obj_deactivate				= obj_deactivate;
		this.obj_keypress				= obj_keypress;
		this.eng_keypress				= eng_keypress;
		this.obj_change					= obj_change;
		this.checkVvdCode				= checkVvdCode;
		this.checkApDesc				= checkApDesc;
		this.checkCell					= checkCell;
		this.validateForm				= validateForm;
		this.setVslCd					= setVslCd;
		this.setLocCd					= setLocCd;
		this.initConfirm				= initConfirm;
		this.sheet_OnSearchEnd			= sheet_OnSearchEnd;
		this.sheet_OnSelectCell			= sheet_OnSelectCell;
		this.sheet_OnChange				= sheet_OnChange;
		this.sheet_OnClick				= sheet_OnClick;
		this.sheet_OnPopupClick			= sheet_OnPopupClick;
		this.sheet_OnMouseMove			= sheet_OnMouseMove;
		this.obj_activate				= obj_activate;
		this.makeComboObject			= makeComboObject;
		this.chkPeriod					= chkPeriod;
		this.setFocus					= setFocus;
		this.setItemNm					= setItemNm;
		this.setItemNm_sht				= setItemNm_sht;
		this.setItemNameClear			= setItemNameClear;
		this.cmb_sttlmnt_OnCheckClick	= cmb_sttlmnt_OnCheckClick;
		this.fmsFileUploadPopUp			= fmsFileUploadPopUp;
		this.FnIsSttlmntEditable		= FnIsSttlmntEditable;
	}
	
	/* 개발자 작업	*/

	// 공통전역변수

//	var tabObjects = new Array();
//	var tabCnt = 0 ;
//	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var prefix = "sheet_";
	
	var oldValue = null;	// Settlement Combo cell 이 가지고 있던 정보를 잠시 저장합니다.(매우 중요) 
			
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한  *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_new":
					if(!initConfirm()) return;
					fnReset();
					break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_saveToFile":
					if(sheetObjects[0].RowCount == 0) {
						ComShowCodeMessage("FMS00016");
						return;
					}
					
					sheetObjects[0].SpeedDown2Excel(-1);
					break;
					
				case "btn_effDt1":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.eff_dt1, 'yyyy-MM');
					break;
					
				case "btn_effDt2":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.eff_dt2, 'yyyy-MM');
					break;
					
				case "btn_vslPop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
					break;
					
				case "btn_locPop":
					ComOpenPopup("COM_ENS_051.do", 720, 430, "setLocCd", "1,0,1,1,1", true, false, null, null, null, "com_ens_051");
					break;
					
				case "btn_test":
					var row = sheetObject.DataInsert(-1);
					break;
					
				case "item_name":
					ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OW", 550, 455, "setItemNm", "0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0076");
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
	 * Combo Object 초기화  <br>
	 * @param  {object} comboObj	필수 Combo Object
	 * @return 없음
	 * @author 
	 * @version 2013.03.25
	 */ 
	function initCombo(comboObj) {
		 switch(comboObj.id) {
			case "cmb_sttlmnt":
				with(comboObj) {
					MultiSelect = true;
					MultiSeparator = ",";
					DropHeight = 130;
				}
			break;
		}
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

		// IBMultiCombo 초기화
		comboObjects[comboCnt++] = document.cmb_sttlmnt;
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k]);
		}
		
		sheetObjects[0].ExtendLastCol = true;
		
		fnReset();
		initControl();
	}
	
	/**
	 * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function sheet_OnLoadFinish(sheetObj) { 
		sheetObj.WaitImageVisible = false;
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
		sheetObj.WaitImageVisible = true;   
	}
	
	/**
	 * 조회조건 및 Sheet 초기화
	 */
	function fnReset() {
		var formObj		= document.form;
		var sheetObj	= sheetObjects[0];
		
		// 현재월
		var sysDate	= new Date();
		
		// 현재월의 3개월 이전
		var beforeDate	= new Date();
		beforeDate.setMonth(sysDate.getMonth() - 2)
		
		var tYear	= sysDate.getFullYear();
		var bYear	= beforeDate.getFullYear();
		var tMonth	= sysDate.getMonth()+1;
		var bMonth	= beforeDate.getMonth()+1;
		
		var tomonth = ComLpad(tYear, 4, "0") + "-" + ComLpad(tMonth, 2, "0");
		var beforemonth = ComLpad(bYear, 4, "0") + "-" + ComLpad(bMonth, 2, "0");
		
		// Sheet Object Initialization
		sheetObj.RemoveAll();
		
		// Search Condition Object Initialization
		formObj.eff_dt1.value = beforemonth;
		formObj.eff_dt2.value = tomonth;
		formObj.vsl_cd.value = "";
		formObj.acct_itm_nm.value = "";
		formObj.acct_cd.value = "";
		formObj.acct_itm_seq.value = "";
		formObj.chk_item_name.disabled = true;
		formObj.chk_item_name.checked = true;
		formObj.loc_cd.value = "";
		comboObjects[0].Index = 0;
		
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:	  //t1sheet1 init
//				var prefix = "sheet_";
				with (sheetObj) {
					
					// 높이 설정
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone] // msPrevColumnMerge + msHeaderOnly
					MergeSheet =  msNone;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(false, true, false, true, false,false)
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "|Seq|Settlement|Attach|O/A Item|DESC|VVD|Amount(USD)|LCL|Amount|CSR Slip No|Eff. Date|Ex. Rate|Matching\nCSR Slip No|Internal\nMemo|Hire No.|Location|Account Code|Account Item Seq.|Condition CSR Slip No";

					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					cnt = 0;
//					InitDataProperty(0, cnt++, dtStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	prefix + "ibflag");
					InitDataProperty(0, cnt++, dtSeq,			30,		daCenter,	false,	prefix + "Seq");
					InitDataProperty(0, cnt++, dtCombo,			130,	daCenter,	false,	prefix + "oa_stl_sts_cd",		false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtPopupFormat,	60,		daCenter,	false,	prefix + "attach",				false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtPopupFormat,	250,	daLeft,		false,	prefix + "acct_itm_nm",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			150,	daLeft,		false,	prefix + "ap_desc",				false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "vvd",					false,	"",	dfNone,		0, false, false, 10);
					InitDataProperty(0, cnt++, dtData,			90,		daRight,	false,	prefix + "usd_amt",				false,	"",	dfFloat,	2, false, false);
					InitDataProperty(0, cnt++, dtData,			60,		daCenter,	false,	prefix + "lcl",					false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			70,		daRight,	false,	prefix + "amount",				false,	"",	dfFloat,	2, false, false);
					InitDataProperty(0, cnt++, dtData,			160,	daCenter,	false,	prefix + "csr_slip_no",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "eff_dt",				false,	"",	dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "ex_rate",				false,	"", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			160,	daCenter,	false,	prefix + "matching_csr_slip_no",false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			150,	daLeft,	    false,	prefix + "internal_memo",		false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "ppay_hir_no",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,	false,	prefix + "oa_loc_cd",			false,	"",	dfNone,		0, false, false);
					// ---------------------------------------------------------------------
					InitDataProperty(0, cnt++, dtHidden,		30,		daCenter,	false,	prefix + "acct_cd",				false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		30,		daCenter,	false,	prefix + "acct_itm_seq",		false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		160,	daCenter,	false,	prefix + "cond_csr_slip_no",	false,	"",	dfNone,		0, false, false);
					// ---------------------------------------------------------------------
					
					ShowButtonImage = 2;
					FocusAfterProcess = false;

					InitDataValid(0, prefix + "vvd", vtEngUpOther, "0123456789");
					
				}
				break;
		}
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj	IBSheet Object
	 * @param {int}	 sheetNo	 sheetObjects 배열에서 순번
	 **/
	function initControl() {
		
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate', form);	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('keypress'			, 'obj_keypress'  , form);	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		
		axon_event.addListenerForm  ('keypress',	'eng_keypress',	form);	//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
		axon_event.addListenerForm  ('change',		'obj_change',	form);	//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
		axon_event.addListenerFormat('focus',		'obj_activate',	form);
		
		axon_event.addListener      ('blur',		'obj_blur',		'eff_dt1', 'eff_dt2');
		axon_event.addListener      ('keypress', 'engnum_keypress', 'loc_cd', 'vsl_cd'); // 입력 시 영문 대문자/숫자만 입력하기
	}

	/**
	 * Sheet관련 프로세스를 처리한다.<br>
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,objNm,row) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:	// 조회
				if(objNm == "vsl_cd") {
					formObj.f_cmd.value = SEARCH01;
					
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
					var vslEngNm = ComGetEtcData(sXml, "vslEngNm");

					if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
						formObj.vsl_eng_nm.value = vslEngNm;
					} else {
						formObj.vsl_cd.value = "";
						// 존재하지 않는 Vessel Code입니다
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
						return;
					}
					
				} else if(objNm == "loc_cd") {
					formObj.f_cmd.value = SEARCH03;

					var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
					var locNm = ComGetEtcData(sXml, "locNm");
					
					if(typeof locNm != "undefined" && locNm != "" ) {
						formObj.loc_nm.value = locNm;
					} else {
						formObj.loc_cd.value = "";
						// 존재하지 않는 Location Code입니다
						ComAlertFocus(formObj.loc_cd, ComGetMsg("FMS00006", "KK Code"));
						return;
					}
					
				} else {
					if(validateForm(sheetObj,formObj,sAction,objNm)) {
						formObj.f_cmd.value = SEARCH;
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0097GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						
						if (sXml.length > 0) sheetObj.LoadSearchXml(sXml);
					}
				}
				break;

			case IBSAVE:		// 저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
				
					var sParam = "";
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					
					sParam += FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) + "&" + sParamSheet1;
					
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0097GS.do", sParam);
					
					if (sXml.length > 0) sheetObj.LoadSearchXml(sXml);
					
				}
				break;
				
			case IBROWSEARCH:	// O/A Item 조회 및 조회조건, Sheet Combo 세팅한다.
				
				/*
				BL - Blank : O/A 전표 승인 후, 담당자 확인전 상태
				RC - Received : 증빙이 문제 없을경우 담당자 변경, 정산 대상 => Payment Slip 에서 나오게 처리
				EA - Editing Attachment : 증빙 문제 있을 경우 상태값 변경 및 수정 요청
				HD - Holding : CTF 요청 등의 사유로 정산 보류시(Final시 최종 정리 등)
				CN - Cancelled :  (07P 전표)  (Approval N) 생성 전에 O/A 전표(952111 ? 07S)를 취소(07C 전표)한 경우  (상태 자동 처리)
					=> Payment Slip 에서 안 나오게 처리
				RF - Refund : (07P 전표)  (Approval Y) 생성 후에 O/A 전표(952111 ? 07S)를 취소(07C 전표)한 경우  (자동 처리)
					=> Payment Slip 에서 나오게 처리
				ST - Settled : 선주 차감/환불한 경우 (Received, Refund) Approval Y 인 전표 Slip (자동 처리)
				 */
				var strCdSttlmnt	= "BL|RC|EA|HD|CN|RF|ST ";
				var strTxtSttlmnt	= " |Received|Editing Attachment|Holding|Cancelled|Refund|Settled ";
				/*
				 * Condintion Combo Settting
				 * See CoObject.js
				 */ 
				makeComboObject(formObj.cmb_sttlmnt, strTxtSttlmnt, strCdSttlmnt, 2)
				
				/*
				 * Sheet Combo Setting
				 * See CoFms.js 
				 */
				CoFmsSetMakeCombo(sheetObj, strTxtSttlmnt, strCdSttlmnt, prefix + 'oa_stl_sts_cd')
				
				break;
				
			case IBSEARCH_ASYNC01: // VVD Validation Check
				
				formObj.f_cmd.value = COMMAND01;
				
				var ibflag;
				
				for(var row=1; row<=sheetObj.LastRow; row++) {
					ibflag = sheetObj.CellValue(row, prefix + "ibflag");
					
					if(ibflag == "U") {
						
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0097GS.do?vvd_cd="+sheetObj.CellValue(row, prefix + "vvd") + "&f_cmd=" + formObj.f_cmd.value);
					}
					
					if(CoFmsShowXmlMessage(sXml) != "") {
						sheetObj.CellValue2(row, prefix + "vvd") = "";
						ComShowMessage(CoFmsShowXmlMessage(sXml));
						sheetObj.SelectCell(row, prefix + "vvd");
						return false;
					}
				}
				
				return true;
				break;
		}
	}
	
	/**
	 * HTML Control의 onblur이벤트에서 Effective Date의 Validation을 체크한다.<br>
	 **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
		
	}
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력가능하게 처리한다.<br>
	 **/
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력가능하게 처리한다.<br>
	 **/
	function eng_keypress() {
		//영대문자 자동변환
		ComKeyOnlyAlphabet('upper');
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	//* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
	function engnum_keypress() {
		//영대문자 자동변환
		ComKeyOnlyAlphabet('uppernum');
	}
	
	/**
	 * HTML Control의 onchange이벤트에서 Vessel Code, Location변경 시 Validtion을 체크하다.<br>
	 **/
	function obj_change() {
		var formObj = document.form;
//		alert("obj_change : " + event.srcElement.name);
		
		if((event.srcElement.name == "vsl_cd")) {
			sheetObjects[0].RemoveAll();
			formObj.vsl_eng_nm.value = "";
			
			if(!ComIsEmpty(formObj.vsl_cd.value)) {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
			} else {
				formObj.vsl_cd.value = "";
			}
			
		} else if((event.srcElement.name == "loc_cd")) { 
			formObj.loc_nm.value = "";
			
			if(!ComIsEmpty(formObj.loc_cd.value)) {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"loc_cd");
			} else {
				formObj.loc_cd.value = "";
			}
		}
	}
	
	function obj_blur(){
		var formObj = document.form;
//		alert("obj_blur : " + event.srcElement.name);
		
		/*if(!chkPeriod(formObj.eff_dt1, formObj.eff_dt2)) {
			ComSetObjValue(formObj.eff_dt2, "");
			setFocus("eff_dt2");
		}*/
	}
	
	/**
	 * VVD Code의 Validation을 체크한다.
	 */
	function checkVvdCode(sheetObj, formObj, row) {
		
		var vvdCd = sheetObj.CellValue(row, prefix + "vvd");
		
		if(vvdCd.trim() == "") {
			// VVD Code은(는) 필수 입력항목입니다
			ComShowCodeMessage("FMS00004", "VVD Code");
			sheetObj.SelectCell(row, prefix + "vvd");
			return false;
		} else if(vvdCd.length != 10) {
			// msgs['FMS01442'] = 'Please input VVD Code with 10 digit number.';
			ComShowCodeMessage("FMS01442");
			sheetObj.CellValue2(row, prefix + "vvd") = "";
			sheetObj.SelectCell(row, prefix + "vvd");
			return false;
		}
		
		if(!doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01)) {
			return false;
		}
		
		return true;
	}

	/**
	 * Description 입력여부를 체크한다.<br>
	 */
	function checkApDesc(sheetObj, formObj, row) {
		var apDesc = sheetObj.CellValue(row, prefix + "ap_desc");
		// Description을 입력하지 않은 경우 Validation체크 시 Focus가 이동하면 Merge가 깨지므로 스페이스로 처리한다.
		if(apDesc.trim() == "") {
			sheetObj.CellValue(row, prefix + "ap_desc")  = "";
			
			// Description은(는) 필수 입력항목입니다
			ComShowCodeMessage("FMS00004", "Description");
			sheetObj.SelectCell(row, prefix + "ap_desc");
			return false;
		}
		
		return true;
	}
   
	/**
	 * VVD Code와 Description입력여부를 체크한다.<br>
	 */
	function checkCell(sheetObj, formObj) {
		var ibflag;
		for(var row=1; row<=sheetObj.LastRow; row++) {
			ibflag = sheetObj.CellValue(row, prefix + "ibflag");
			
			if(ibflag == "U") {
				
				if(!checkApDesc(sheetObj, formObj, row)) {
					return false;
				}
				
				if(!checkVvdCode(sheetObj, formObj, row)) {
					return false;
				}
			}
		}

		return true;
	}
	 
	/**
	 * 화면 폼입력값에 대한 Validation을 체크한다.<br>
	 */
	function validateForm(sheetObj,formObj,sAction,objNm){
		if(sAction == IBSAVE) {
			if((sheetObjects[0].isDataModified == false)) {
				ComShowCodeMessage("FMS00007");
				return false;
			}
			
			if(!checkCell(sheetObjects[0], formObj)) {
				return false;
			}
		} else {
			if (!ComChkValid(formObj)) return false;
		}
		
		 return true;
	}

	/**
	 * Vessel Code 팝업창에서 선택한 Vessel정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
	}

	/**
	 * Location Code 팝업창에서 선택한 Location정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setLocCd(aryPopupData) {
		form.loc_cd.value = aryPopupData[0][3];
		form.loc_nm.value = aryPopupData[0][4];
	}

	/**
	 * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
	 **/
	function initConfirm() {
		var okYn = true;
		if(sheetObjects[0].isDataModified) {
			// 입력 및 변경된 데이터가 있습니다.\n\n계속 진행하시겠습니까?
			okYn = ComShowCodeConfirm("FMS00002");
		}
		
		return okYn;
	}

	/**
	 * Sheet에 OnSearchEnd 이벤트 발생시 Apply이미지 버튼을 적용시킨다.<br>
	 * 
	 * Settlement Code
	 * BL : Blanked
	 * RC : Received
	 * EA : Editing Attachment
	 * HD : Holding
	 * CN : Cancelled
	 * RF : Refund
	 * ST : Settled
	 */
	function sheet_OnSearchEnd(sheetObj, ErrMsg) {

		if(sheetObj.RowCount > 0) {

			for(var idx = 1; idx <= sheetObj.RowCount; idx++) {
				if(FnIsSttlmntEditable(sheetObj, idx)) {
//				if(true) {
					sheetObj.CellEditable(idx, prefix + "oa_stl_sts_cd") = true;
					sheetObj.CellEditable(idx, prefix + "acct_itm_nm") = true;
					sheetObj.CellEditable(idx, prefix + "ap_desc") = true;
					sheetObj.CellEditable(idx, prefix + "vvd") = true;
					
				}
				
				sheetObj.CellEditable(idx, prefix + "attach") = true;
				sheetObj.CellFont("FontUnderline", idx, prefix + "csr_slip_no") = true;
				sheetObj.CellFont("FontUnderline", idx, prefix + "matching_csr_slip_no") = true;
			}
		}
		
	}
	
	/**
	 * Sheet의 OnSelectCell 이벤트 발생시<br>
	 */
	function sheet_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {

		// cell 이 가지고 있던 정보를 잠시 저장합니다.(매우 중요)
		if(sheetObj.ColSaveName(NewCol) == prefix + "oa_stl_sts_cd") {
			oldValue = sheetObj.CellValue(NewRow, NewCol);
//			alert(oldValue);
		}

	}
	
	/**
	 * Sheet의 OnChange 이벤트 발생시 <br>
	 */
	function sheet_OnChange(sheetObj, row, col, value) {
		// Settlement Change
		if(col == 2) {
			
			if(!FnIsSttlmntEditable(sheetObj, row)) {
				sheetObj.CellValue2(row, col) = oldValue;
//				alert("Cancelled, Refund, Settled 로는 변경이 불가능합니다.");
				// msgs['FMS20008'] = 'Impossible to be changed by {?msg1}!';
				ComShowMessage(ComGetMsg("FMS20008","Cancelled, Refund or Settled"));
				return;
			}
			
			oldValue = value;
		}
		// VVD
//		else if(col == 6) {
//			
//			if(!ComIsEmpty(sheetObj.CellValue(row, col))) {
//				
//				if(!checkVvdCode(sheetObj, document.form, row)) {
//					return;
//				}
//			}
//		}
	}
	
	/**
	 * Sheet의 OnClick 이벤트 발생시<br>
	 */
	function sheet_OnClick(sheetObj, row, col, value) {
		var csrNo = "";
		var csrNo2 = "";
		
		switch(sheetObj.ColSaveName(col)) {
			case prefix + "csr_slip_no":
				csrNo = sheetObj.CellValue(row, col);
				if(csrNo.length-4 == 19){
					csrNo2 = csrNo.substr(0,19);
				}else{
					csrNo2 =csrNo.substr(0,20);					
				}
				
//				var paramCSN = "s_csr_no=" + csrNo2+ "&s_flg=R1";
				var paramCSN = "s_csr_no=" + csrNo2;				
				ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + paramCSN, 1024, 590, "setCorrection", "0,0,1,1,1,1", true);				
				break;
				
			case prefix + "matching_csr_slip_no":				
				csrNo = sheetObj.CellValue(row, col);
				if(csrNo.length-4 == 19){
					csrNo2 = csrNo.substr(0,19);
				}else{
					csrNo2 =csrNo.substr(0,20);					
				}
				
//				var paramMCSN = "s_csr_no=" + csrNo2 + "&s_flg=R1";
				var paramMCSN = "s_csr_no=" + csrNo2;				
				ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + paramMCSN, 1024, 590, "setCorrection", "0,0,1,1,1,1", true);
				break;
		}
		
	}
	
	/**
	 * Sheet Data Cell의 Popup Button이 눌러졌을 때 발생하는 Event.<br>
	 * 
	 * @param {object} sheetObj 쉬트오브젝트
	 * @param {int} Row 행번호
	 * @param {int} Col 컬럼번호
	 */
	function sheet_OnPopupClick(sheetObj, Row, Col) {
		
		switch (sheetObj.ColSaveName(Col)) {
		
			case prefix + "attach":
				
				var strCSN = sheetObj.CellValue(Row, prefix + "csr_slip_no");
				
				if(strCSN.trim() == "") {
					return;
				}
				
				if(sheetObj.CellEditable(Row, prefix + "oa_stl_sts_cd")) {
					
					fmsFileUploadPopUp(sheetObj, Row, "Y", strCSN);
				} else {
					fmsFileUploadPopUp(sheetObj, Row, "N", strCSN);
				}
				break;
				
			case prefix + "acct_itm_nm":
				if(sheetObj.CellEditable(Row, Col)) {
					//ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OW", 350, 355, "setItemNm_sht", "1,0,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0076");
					ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OW", 550, 455, "setItemNm_sht", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0076");
				}
				break;
			
		}
	}
	
	/**
	 * Sheet의 OnMouseMove 이벤트 발생시 CSR No이 'Y'인 경우 마우스커서 모양을 Default로 변경한다.<br>
	 */
	function sheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		
		// CSR Slip No, Matching CSR Slip No
		if(sheetObj.MouseCol == 10 || sheetObj.MouseCol == 13) {
			sheetObj.MousePointer = "Hand";
		} 
		// Settlement, Attatch,m O/A Item
		else if(sheetObj.MouseCol == 2 || sheetObj.MouseCol == 3 || sheetObj.MouseCol == 4) {
			if(sheetObj.CellEditable(sheetObj.MouseRow, sheetObj.MouseCol)) {
				sheetObj.MousePointer = "Hand";
			}
		}
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
	 */
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	/** 
	* Combo Object 에 값을 추가하는 처리 <br>
	* @param  {object}	cmbObj	필수 Combo Object
	* @param  {String}	strTxt	필수 Combo Text에 표시할 Text( Separator : "|" )
	* @param  {String}	srtCd	필수 Combo Code에 표시할 Text( Separator : "|" )
	* @param  {int}		opt		필수 공백코드 추가여부 (0:추가안함, 1:공백문자 추가, 2:All 추가)
	* @return 없음
	* @author 
	* @version 2016.02.24
	*/ 
	function makeComboObject(cmbObj, strTxt, srtCd, opt) {
		cmbObj.RemoveAll();
		var arrTxt = strTxt.split("|");
		var arrCd = srtCd.split("|");
		
		if(opt == 0) {
			for (var i = 0; i < arrTxt.length;i++ ) {
				
			cmbObj.InsertItem(i, arrTxt[i], arrCd[i]);
			}
		} else if(opt == 1){
			cmbObj.InsertItem(0,"","");
			for (var i = 0; i < arrTxt.length;i++ ) {
				
			cmbObj.InsertItem(i+1, arrTxt[i], arrCd[i]);
			}
		} else if(opt == 2){
			cmbObj.InsertItem(0,"All","");
			for (var i = 0; i < arrTxt.length;i++ ) {
				
			cmbObj.InsertItem(i+1, arrTxt[i], arrCd[i]);
			}
		}
		
		cmbObj.Index2 = "" ;
	}
	
	/**
	 * Effective Date obj_deactivate에서 호출
	 * Maximum duration 3개월 처리
	 */
	function chkPeriod(frmObj, toObj) {
		
		var chkFlag = true;
		if(frmObj.value != "" && toObj.value != "") {
						
			var input1=ComReplaceStr(frmObj.value,"-","");
			var input2=ComReplaceStr(toObj.value,"-","");
			
			var date1 = new Date(input1.substr(0,4),input1.substr(4,2)-1);
			var date2 = new Date(input2.substr(0,4),input2.substr(4,2)-1);
			var interval = date2 - date1;
			var day = 1000*60*60*24;
			var month = day*30;
			
			month = parseInt(interval/month)+1;
			if ( month > 3 ) {
				// msgs['COM132001'] = '{?msg1} exceeds maximum duration {?msg2}.';
				ComShowMessage(ComGetMsg("COM132001","Period","3 month"));
				chkFlag = false;
			}
		}
		return chkFlag;
	}
	
	/**
	 * Move Focus in Object
	 */
	function setFocus(name) {
		ComSetFocus(eval("document.form."+name));
		eval("document.form."+name).select();
	}
	
	/**
	 * O/A Item 조회조건 CallBack Function.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setItemNm(aryPopupData, row, col, sheetIdx){
		
		var strAcctItmNm = "";
		var strAcctCd = "";
		var strAcctItmSeq = "";
				
		for (var i = 0; i < aryPopupData.length;i++ ) {
			strAcctItmNm += aryPopupData[i][2] + ",";
			strAcctCd += aryPopupData[i][3] + ",";
			strAcctItmSeq += aryPopupData[i][4] + ",";
		}
		
		if(aryPopupData.length > 0) {
			strAcctItmNm	= strAcctItmNm.substr(0,strAcctItmNm.length -1);
			strAcctCd		= strAcctCd.substr(0,strAcctCd.length -1);
			strAcctItmSeq	= strAcctItmSeq.substr(0,strAcctItmSeq.length -1);
		}
		
		form.acct_itm_nm.value = strAcctItmNm;
		form.acct_cd.value = strAcctCd;
		form.acct_itm_seq.value = strAcctItmSeq;
		
		form.chk_item_name.disabled = false;
		form.chk_item_name.checked = true;
	}
	
	/**
	 * O/A Item Sheet CallBack Function.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setItemNm_sht(aryPopupData, row, col, sheetIdx){
//		alert("row, col, sheetIdx : " + row + ", " + col + ", " + sheetIdx);
		var sheetObj	= sheetObjects[sheetIdx];
		
		sheetObj.CellValue2(row, prefix + "acct_itm_nm") = aryPopupData[0][2];
		sheetObj.CellValue2(row, prefix + "acct_cd") = aryPopupData[0][3];
		sheetObj.CellValue2(row, prefix + "acct_itm_seq") = aryPopupData[0][4];
		
	}
	
	/**
	 * O/A Item 항목 초기화 <br>
	 **/
	function setItemNameClear() {
		if(!form.chk_item_name.checked) {
			form.acct_itm_nm.value = "";
			form.acct_cd.value = "";
			form.acct_itm_seq.value = "";
		}
	}
	
	/**
	 * Settlement Combo Check Event
	 * 
	 * All 선택시 다중선택 불가
	 * 나머지 항목 다중선택 가능
	 */
	function cmb_sttlmnt_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}
	
	/**
	 * FMS File Upload 팝업 오픈
	 */
	function fmsFileUploadPopUp(sheetObj, Row, edit_able, csr_no) {
		
		if (csr_no == undefined || csr_no == null || ComTrim(csr_no) == ''){
			csr_no = '';
		}
		
		var param = "?atch_file_flet_lnk_id=" +
						 "&csr_no=" + csr_no +
						 "&edit_able=" + edit_able +
						 "&tab_gubun="+ prefix +
						 "&chk_flg="+ "Y" +
						 "&row=" + Row
						 ;
		ComOpenPopup("/hanjin/ESM_FMS_0092.do" + param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
	}
	
	/**
	 * Sheet의 Settlement Cell이 Cancelled, Refund, Settled인지 확인
	 * 
	 * 해당 값이 Cancelled, Refund, Settled중 하나일 경우엔 False 반환
	 */
	function FnIsSttlmntEditable(sheetObj, row) {
		var strOaStlStsCd = sheetObj.CellValue(row, prefix + "oa_stl_sts_cd")
		
		if(strOaStlStsCd == "CN" || strOaStlStsCd == "RF" || strOaStlStsCd == "ST") {
			return false;
		}
		return true;
		
	}
	
	/* 개발자 작업  끝 */