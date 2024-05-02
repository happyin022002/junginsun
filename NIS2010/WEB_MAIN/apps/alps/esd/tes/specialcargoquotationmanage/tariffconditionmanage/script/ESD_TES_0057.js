/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0057.js
*@FileTitle : Tariff Condition List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.06
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
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
	 * @author SM LINE
	 */
	
	/**
	 * @extends
	 * @class ESD_TES_0057 : ESD_TES_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_0057() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1 = sheetObjects[0];
		var formObj = document.form;
		var opener = window.dialogArguments;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObj,IBSEARCH);
				break;
				
			case "btn_OK":
				buttonOkClick(sheetObject1); 
	            break;
	            
			case "btn_Close":
				window.close();
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
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		formObj.tml_awk_cgo_cond_tp_nm.value = formObj.tml_awk_cgo_trf_tp_cd.value;
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 300;
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
				// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
				InitHeadMode(true, false, true, true, false, true);
	
				SelectionMode = smSelectionList;
	
				var HeadTitle1 = "||Type|ID|Tariff Condition|Update User|Update Date";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				var prefix = "sheet1_";
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,  30, 	daCenter, 	false, "ibflag");
				InitDataProperty(0, cnt++, dtHidden,  		30, 	daCenter, 	false, "tml_awk_cgo_cond_tp_cd");
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true,  "tml_awk_cgo_cond_tp_nm", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true,  "cond_no", 					false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			350,	daLeft, 	true,  "cond_desc", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, 	true,  "upd_usr_id", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			90, 	daCenter, 	true,  "upd_dt", 					false, "", dfNone, 0, false, false);
			}
			break;
		}
	}
	
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	 	var sheetObject = sheetObjects[0];
		sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
			case IBSEARCH: //조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESD_TES_0057GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
			break;
	    }
	} 
	
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm('focus', 'obj_activate', formObj);
		axon_event.addListenerForm('keypress', 'eng_keypress', formObj); // - 영문자 입력하기
		axon_event.addListenerForm('keypress', 'num_keypress', formObj); // - 숫자 입력하기
		axon_event.addListenerForm('keypress', 'enter_keypress', formObj); // - Enter 키처리
	}
	
	function buttonOkClick(sheetObj) {
		var rtnObject = new Object();
		var formObj = document.form;
		var Row = sheetObj.SelectRow;
		if(formObj.ui_id.value == "ESD_TES_0050" || formObj.ui_id.value == "ESD_TES_0051" || formObj.ui_id.value == "ESD_TRS_0250" || sheetObj.CellValue(Row, "tml_awk_cgo_cond_tp_cd")=="C"){
			rtnObject.cond_no 	= sheetObj.CellValue(Row, "cond_no");		
			rtnObject.cond_desc = sheetObj.CellValue(Row, "cond_desc");
			window.returnValue = rtnObject;
		    self.close();
		}else{	
			if(chkTrfCondTp(sheetObj)){
				rtnObject.tml_awk_cgo_cond_tp_cd 	= sheetObj.CellValue(Row, "tml_awk_cgo_cond_tp_cd");				
				rtnObject.cond_no 	= sheetObj.CellValue(Row, "cond_no");		
				rtnObject.cond_desc = sheetObj.CellValue(Row, "cond_desc");	
				window.returnValue = rtnObject;
			    self.close();
			}
		}	
	}
	
	function sheet1_OnSearchEnd(sheet1, ErrMsg){
		setTooltip(sheet1,'cond_desc');
	}
	
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		buttonOkClick(sheetObj);
	}
	
	function chkTrfCondTp(sheetObj) {
		var formObj = document.form;
		if(formObj.tml_awk_cgo_trf_tp_cd.value != sheetObj.CellValue(sheetObj.SelectRow, "tml_awk_cgo_cond_tp_cd")){
			ComShowCodeMessage('TES90114'); //Please select Tariff Condition applicable to type.
			return false;
		}
		return true;
	}
	
	function obj_change() {
		var formObj = document.form;
		formObj.tml_awk_cgo_cond_tp_cd.value = formObj.tml_awk_cgo_cond_tp_nm.value; 
	}
	
/* 개발자 작업 끝 */