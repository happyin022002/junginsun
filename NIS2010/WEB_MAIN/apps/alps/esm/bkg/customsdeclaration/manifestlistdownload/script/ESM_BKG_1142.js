/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1142.js
 *@FileTitle : Ghana Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.04.12 김보배
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
	 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를
	 *        정의한다.
	 */
	function ESM_BKG_1142() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.sheet1_OnClick = sheet1_OnClick;
	}
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//전역변수
//    var intervalId = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
		
				case "btn_trans":
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
		document.form.vvd_cd.focus();
		
		// 라디오 버튼 조건 체크
		for (var i = 0; i < document.form.port_flg.length; i++) {
			if (document.form.port_flg[i].checked == true) {
				document.form.port_flg[i].click();
			}
		}
		
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
	
		switch (sheetID) {
		case "sheet1": //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 400;
	
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle = "|Sel.|Seq.|VVD|BKG No.|B/L No.|FA|RD|LS|B/POR|V/POL|V/POD|B/DEL|Weight|Weight|Package|Freight|RF|S.Date||||||";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false,"ibflag");
				InitDataProperty(0, cnt++, dtCheckBox,	40, daCenter, false, "Chk");
				InitDataProperty(0, cnt++, dtDataSeq,	35, daCenter, false, "Seq",			false, "", dfNone, 0, false, false, -1, false, false, "", 	true, "IUD", false);
				InitDataProperty(0, cnt++, dtData,		90, daCenter, false, "vvd_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		95, daCenter, false, "bkg_no",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		95, daCenter, false, "bl_no",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		30, daCenter, false, "mfsnd_code",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		30, daCenter, false, "term_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		30, daCenter, false, "ghtem_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		50, daCenter, false, "por_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		50, daCenter, false, "bv_pol_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		50, daCenter, false, "bv_pod_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		50, daCenter, false, "del_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		65, daRight,  false, "act_wgt",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		30, daCenter, false, "wgt_ut_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		65, daRight,  false, "pck_qty",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		50, daCenter, false, "frt_term_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		35, daCenter, false, "rc_flg",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		120, daCenter, false, "mf_snd_dt",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	60, daCenter, false, "vsl_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	35, daCenter, false, "skd_voy_no",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	80, daCenter, false, "skd_dir_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	35, daCenter, false, "pol_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	80, daCenter, false, "pod_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	80, daCenter, false, "bkg_ofc_cd",	false, "", dfNone, 0, false, false);
			}
			break;
	
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
	
		switch (sAction) {
		case IBSEARCH: //조회
	
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			initSheet(sheetObjects[0], 0);
			
			formObj.f_cmd.value = SEARCH;
			
			sheetObjects[0].RemoveAll();
			sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1142GS.do", FormQueryString(formObj));
	
			var arrXml = sXml.split("|$$|");
	
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
			}
			ComEtcDataToForm(formObj, sheetObj);
			
			sheetObj.CheckAll("Chk") = 1;
			ComOpenWait(false);
	
			break;
			
			
		case IBSAVE: //전송
		
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
		
			for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
				// 체크박스에 따라
				if (sheetObj.CellValue(i, "Chk") == "1") {
					sheetObjects[0].RowStatus(i) = "I";
					/*
					 * Sitpro(ESM_BKG_0484) 쪽 전송 로직 수행시 필요한 RECEIVE ID 셋팅
					 */
					sheetObjects[0].CellValue(i, "bkg_ofc_cd") = "GCNET";
				} else {
					sheetObjects[0].RowStatus(i) = "R";
				}
			}
			
			if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
				return false;
			}
			
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				var sParam = "";
				var sParamSheet = sheetObj.GetSaveString();

				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
				
				formObj.f_cmd.value = MULTI;
				
				sParam += "&" + FormQueryString(formObj);
	
				/*
				 * sitpro(ESM_BKG_0484) 쪽 전송 로직을 수행 한다. 
				 */
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1142_1GS.do", sParam);
				
				var key = ComGetEtcData(sXml, "KEY");
				ComOpenWait(true);
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);	

				break;	
				
		case MULTI01: // 전송 성공 후 로그를 저장한다.
			
			for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
				// 체크박스에 따라
				if (sheetObj.CellValue(i, "Chk") == "1") {
					sheetObjects[0].RowStatus(i) = "I";
					sheetObjects[0].CellValue(i, "bkg_ofc_cd") = "GCNET";
				} else {
					sheetObjects[0].RowStatus(i) = "R";
				}
			}
			
//			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			
			var sParam = "";
			var sParamSheet = sheetObj.GetSaveString();

			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
			}
			
			formObj.f_cmd.value = MULTI01;
			
			sParam += "&" + FormQueryString(formObj);

			var sXml = sheetObj.GetSaveXml("ESM_BKG_1142GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);(sXml);
			var state = sheetObj.EtcData("TRANS_RESULT_KEY");
			
			if(state == "S") {
				// 성공메시지 보여주고
				ComShowCodeMessage('BKG00204');
				//재조회
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			ComOpenWait(false);

			break;					
		}
		
		
	}
	
	
	/**
	 * BackEndJob 실행결과조회.
	 */
	function doActionValidationResult(sheetObj, sKey) {
		sheetObjects[0].WaitImageVisble = false;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1142_1GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
		var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
		
		// 에러가 발생했을 경우 대기사항을 종료한다.
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			/*
			 * 전송 성공 후 LOG 저장
			 */
			doActionIBSheet(sheetObjects[0], document.form, MULTI01);
			// ComShowMessage(ComResultMessage(sXml));
			return;
		} else if (sJbStsFlg == "FAIL") {
			//에러
			clearInterval(intervalId);
			ComOpenWait(false);
			// 에러메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
		case IBSAVE: // 전송
			// 기본포멧체크
			if(!ComChkObjValid(formObj.vvd_cd)) return false;
			
			if (formObj.pol_cd.value == "" && formObj.pod_cd.value == "") {
				ComShowCodeMessage('BKG00214');
				formObj.pol_cd.focus();
				return false;
			}
			
			if (formObj.port_flg[0].checked && formObj.pol_cd.value.length > 0
					&& formObj.pol_cd.value.length < 5) {
				ComShowCodeMessage('BKG00214');
				formObj.pol_cd.focus();
				return false;
			}

			if (formObj.port_flg[1].checked && formObj.pod_cd.value.length > 0
					&& formObj.pod_cd.value.length < 5) {
				ComShowCodeMessage('BKG00214');
				formObj.pod_cd.focus();
				return false;
			}
			
			return true;
			break;
	
		}
	}

	/**
	 * HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
	 **/
	function obj_KeyUp() {
	
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	
	/**
     * 조회조건 입력할 때 처리
     */
	function obj_Clicked() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if(srcName == "port_flg"){
			if (srcValue == "pol") {
				document.form.pod_cd.value = "";
				document.form.pod_cd.disabled = true;
				document.form.pod_cd.readonly = true;
				document.form.pol_cd.disabled = false;
				document.form.pol_cd.readonly = false;
				document.form.pol_cd.className = "input1";
				document.form.pod_cd.className = "input2";
			} else {
				document.form.pol_cd.value = "";
				document.form.pol_cd.disabled = true;
				document.form.pol_cd.readonly = true;
				document.form.pod_cd.disabled = false;
				document.form.pod_cd.readonly = false;
	    		document.form.pol_cd.className = "input2";
	    		document.form.pod_cd.className = "input1";
			}

    	}
    } 