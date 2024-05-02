/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0071.js
 *@FileTitle : BDR Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.21 김경섭
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
     * @extends 
     * @class esm_bkg_s007  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function esm_bkg_s007() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.sheet1_OnClick = sheet1_OnClick;
		this.sheet1_OnKeyUp = sheet1_OnKeyUp;
		this.setComboObject = setComboObject;
	}
	/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// MultiComboBox관련 변수
	var comboCnt = 0;
	var comboObjects = new Array();
	var bMultiComboDataAdded = false;
	var bMultiComboDataAdded2 = false;
	var prefix = "sheet1_";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1 = sheetObjects[0];
		var comboObject1 = comboObjects[0];
		/** **************************************************** */
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;
				case "btn_bkg_date":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// MultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		form.vvd_cd.focus();
	}
	function initControl() {
		var formObject = document.form;
		axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); // -
		// 키보드
		// 입력할때
		axon_event.addListenerForm('beforedeactivate', 'bkg_deactivate', formObject); // -
		// 포커스
		// 나갈때
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); // -
		// 포커스
		// 들어갈때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	function bkg_keypress() {
		switch (event.srcElement.dataformat) {
			case "ymd":
				// number
				ComKeyOnlyNumber(event.srcElement, "-");
				break;
			case "engup":
				// 영문대문자
				ComKeyOnlyAlphabet('upper');
				break;
			case "engupnum":
				// 숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "num":
				// 숫자 입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			default:
		}
	}
	/**
	 * HTML Control의 onBlur을 제어한다.
	 */
	function bkg_deactivate() {
		var formObj = document.form;
		switch (event.srcElement.getAttribute("name")) {
			case "bkg_from_dt":
				ComAddSeparator(event.srcElement);
				break;
			case "bkg_to_dt":
				ComAddSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 */
	function bkg_activate() {
		// 입력Validation 확인하기
		switch (event.srcElement.name) {
			case "bkg_from_dt":
				ComClearSeparator(event.srcElement);
				break;
			case "bkg_to_dt":
				ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 조회
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_S007GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				sheetObjects[0].Redraw = false;
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[0].LoadSearchXml(sXml);
				sheetObjects[0].Redraw = true;
				break;
			case SEARCH01: // 조회
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_S007GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var arrData = ComXml2ComboItem(arrXml[0], formObj.rhq_cd, "val", "val");
				var arrData = ComXml2ComboItem(arrXml[1], formObj.roll_ovr_rsn_cd, "val", "name");
				var arrData = ComXml2ComboItem(arrXml[2], formObj.ctrt_cd, "val", "name");
				break;
			case IBDOWNEXCEL: // 엑셀다운로드
				sheetObj.SpeedDown2Excel(1);
				break;
		}
	}
	/**
	 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboid) {
		var formObject = document.form
		switch (comboid) {
			case "slan_cd":
				with (comboObj) {
					// BackColor = "#CCFFFD";
					DropHeight = 100;
					MultiSelect = false;
					UseEdit = true;
					MaxSelect = 1;
					ColCnt = 1;
					UseCode = true;
				}
				break;
		}
	}
	// 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_from_dt) && ComIsNull(formObj.bkg_to_dt)) {
					ComShowCodeMessage('BKG00625');
					formObj.bkg_from_dt.focus();
					return false;
				}
				if (!dateCheck(formObj.bkg_from_dt)) {
					ComShowCodeMessage('BKG00921')
					formObj.bkg_from_dt.focus();
					return false;
				}
				if (!dateCheck(formObj.bkg_to_dt)) {
					ComShowCodeMessage('BKG00921')
					formObj.bkg_to_dt.focus();
					return false;
				}
				
				if (!ComIsNull(formObj.bkg_from_dt) 
		  			&& !ComIsNull(formObj.bkg_to_dt) 
		  			&& ComGetDaysBetween(formObj.bkg_from_dt.value, formObj.bkg_to_dt.value) > 31){
	           		 
         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
         			formObj.bkg_from_dt.focus();
         			return false;
         		}
		}
		return true;
	}
	/**
	 * 화면 yyyyMMd 날짜 체크
	 */
	function dateCheck(dateobj) {
		if (dateobj.value == "")
			return true;// null이면 체크 안함
		return ComIsDate(dateobj.value);
	}

	function isNullEtcData(xmlStr) {
		var rtn = false;
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null)
			return true;
		var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if (etcDataNode == null)
			return true;
		var etcNodes = etcDataNode.childNodes;
		if (etcNodes == null)
			return true;
		if (etcNodes.length == 0)
			rtn = true;
		return rtn;
	}
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetObj.id) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 410;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					var HeadTitle1 = "|Seq.|RHQ|Office|B/L No|Date|Shipper Code|Shipper Name|From VVD|To VVD|Reason of Roll Over";
					var headCount = ComCountHeadTitle(HeadTitle1);
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++ , dtSeq, 30, daCenter,false, "seq",     		   false, "", dfNone, 0, false,  true);
					InitDataProperty(0, cnt++, dtData, 55, daCenter, true, prefix + "rhq_ofc", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 55, daCenter, true, prefix + "bkg_ofc_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "bl_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "evnt_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "cust_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, true, prefix + "cust_nm", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "pre_vvd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "new_vvd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 150, daLeft, true, prefix + "roll_ovr_rsn_cd", false, "", dfNone, 0, false, false);
					/*
					 * 
					 * VO slan_cd skd_dir_cd vvd_cd pol_cd vps_etd_dt pod_cd
					 * trnk_bdr_dys trnk_bdr_dt trnk_bdr_flg fdr_bdr_dys
					 * feeder_bdr_dt feeder_bdr
					 * 
					 * period_type from_dt to_dt runtime
					 */
					// InitUserFormat2(0, prefix + "upd_dt", "####-##-##", "-|:" );
					// CountPosition = 0;
				}
				break;
		}
	}
	/* 개발자 작업 끝 */