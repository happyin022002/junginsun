/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0017.js
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.29 김진일
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
     * @class vop_pso_0017 : vop_pso_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0017() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject			= setComboObject; //combo Object setting
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo				= initCombo;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;

    	this.sheet1_OnClick = sheet1_OnClick;
    }

   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var LANE = "vendor";
    var ROWMARK = "|";
    var FIELDMARK = "";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];
             var comboObject1 = comboObjects[0]; 

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	            	  case "btn_New"://검색조건 초기화
	            	  		formObject.reset();
	            	  		setToday(document.form.revyrmon, "ym");
	            	  		comboObjects[0].Code="";
	            	  		sheetObject1.RemoveAll();
	            	  		break;
			          case "btn_Retrieve":
			        	  	//필수 입력 조건인 WorkMonth의 값이 설정 되어있는가를 확인한다.
			        	  	if(formObject.revyrmon.value === "" || formObject.revyrmon.value === undefined){
			        	  		ComShowCodeMessage("PSO00003", "Work Month");  
			        	  		formObject.revyrmon.focus();
			        	  		return;
			        	  	}
			        	  	//IBCOMBO에 설정된 값을 vndr_seq파라미터에 셋팅한다.
			        	  	formObject.vndr_seq.value = comboObject1.Code;
			        	  	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							break;
			          case "btns_calendar":
			        	  openCalendar("ym");
			        	  break;
			          case "btns_search":
			        	  openLaneCode();
			        	  break;
		        	  default : break;
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
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */ 
	function setComboObject(combo_obj) {  
	     comboObjects[comboCnt++] = combo_obj;  
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
		/*
		 for(i=0;i<sheetObjects.length;i++){
		 doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
		 }
		 */
	
		initControl();
	}
	/**
	 * 화면 깜박임 처리 
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
	
		//
	}
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */
	function initCombo(comboObj, comboNo) {
		var formObject = document.form
		switch (comboNo) {
		case 1:
			with (comboObj) {
				MultiSelect = true;
				UseAutoComplete = true;
				MultiSeparator = "|"; // Separator를 명시적으로 지정
				// SetColAlign("left|left");
				// SetColWidth("30|150");
				// BackColor = "#CCFFFD";
				// FontColor = "#FB1901";
				// ColBackColor(0) = "#CCFFFD";
				// ColFontColor(0) = "#FB1901";
				// ColBackColor(1) = "#CCFFFD";
				// ColFontColor(1) = "#FB1901";
				// DropHeight = 160;
			}
			doActionIBCombo(sheetObjects[0], formObject, IBSEARCH, comboObj, LANE);
			break;
		}
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetid = sheetObj.id;
		switch (sheetid) {
	
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 450;
	
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
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|Sel.|Pay To|Lane|VVD|Transit Date|Payable Due\nDate|Advance Payment\nStatus|ADV Payment\nRev.Month|Invoice\nStatus|Invoice\nRev.Month|MSA|Result|vnderSEq|callSeq|ydCd";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				/*
				 * mySheet.InitHeadMode([SortEnable], [ColumnMove],
				 * [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				 */
				InitHeadMode(false, true, false, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				var prefix = "sheet1_";
				InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true, "Status");
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix + "del_chk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "pay_to", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "lane", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 85, daCenter, true, prefix + "vvd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 85, daCenter, true, prefix + "trns_dt", false, "", dfDateYmd, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix + "py_due_dt", false, "", dfDateYmd, 0, false, true);
				InitDataProperty(0, cnt++, dtImage, 120, daCenter, true, prefix + "adv_py_sts", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix + "adv_py_rev_mon", false, "", dfDateYm, 0, false, true);
				
				InitDataProperty(0, cnt++, dtImage, 100, daCenter, true, prefix + "inv_sts", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 85, daCenter, true, prefix + "inv_rev_mon", false, "", dfDateYm, 0, false, true);	
				InitDataProperty(0, cnt++, dtImage, 100, daCenter, true, prefix + "msa", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix + "rslt", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, prefix + "vndr_seq", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, prefix + "call_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, prefix + "yd_cd", false, "", dfNone, 0, false, true);
	
				ImageList(0) = "img/btng_ready.gif"; // READY
				ImageList(1) = "img/btng_requested.gif"; // READY
				ImageList(2) = "img/btng_requested2.gif"; // READY
				ImageList(3) = "img/btng_requested3.gif"; // READY
				ImageList(4) = "img/btng_requested4.gif"; // READY
				ImageList(5) = "img/btng_requested5.gif"; // READY
				ImageList(6) = "img/btng_requested6.gif"; // READY
				ImageList(7) = "img/btng_requested7.gif"; // READY
				ImageList(8) = "img/btng_requested8.gif"; // READY
				ImageList(9) = "img/btng_requested9.gif"; // READY
				ImageList(10) = "img/btng_approved.gif"; // RECEIVED2
				ImageList(11) = "img/btng_complete.gif"; // RECEIVED
				ImageList(12) = "img/btng_paid.gif"; // COMPLETED
	
			}
			break;
	
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible=false;
		switch (sAction) {
	
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			if (validateForm(sheetObj, formObj, sAction))
				if (sheetObj.id == "sheet1"){
					ComOpenWait(true);
					sheetObj.DoSearch("VOP_PSO_0017GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam("sheet1_"));
					ComOpenWait(false);
				}
			break;
		}
	}
	
	// 조회조건필드인 Lane SVC Type 데이터 조회
	function doActionIBCombo(sheetObj, formObj, sAction, sComboObj, sComboKey) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible=false;
		switch (sAction) {
	
		case IBSEARCH: // 조회
	
			if (validateForm(sheetObj, formObj, sAction))
				if (sheetObj.id == "sheet1") {
					//콤보필드를 초기화시킨다.
					sComboObj.RemoveAll();
	
					formObj.f_cmd.value = COMMAND01;
					// var sXml = sheetObj.GetSearchXml("VSK_COMGS.do",
					// FormQueryString(formObj));
					// --> 내 SC에서 BC를 Implement해야 된다.
					var sXml = sheetObj.GetSearchXml("VOP_PSO_0017GS.do",
							FormQueryString(formObj));
	
					var comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
					addComboItem(sComboObj, comboItems);
	
				}
			;
	
			break;
		}
	}
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */
	function addComboItem(comboObj, comboItems) {
		for ( var i = 0; i < comboItems.length; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
		}
		//comboObj.InsertItem(0, "ALL","");
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			//                if (!isNumber(formObj.iPage)) {
			//                    return false;
			// }
		}
	
		return true;
	}
	
	/**
	 * 
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		//        	alert('Row:='+Row+" Col:="+Col+" Value:="+Value);
		var url = "";
		var formObject = document.form;
		// alert("Value:="+Value);
		if (Value !== null && Value !== "undefined" && Value !== "-1"
				&& Value !== "0") {
			switch (Col) {
			case 7://전도금
				url = "/hanjin/VOP_PSO_0018.do?vvd="
						+ sheetObj.CellValue(Row, 'sheet1_vvd') + "&ydCd="
						+ sheetObj.CellValue(Row, 'sheet1_yd_cd')
						+ "&callSeq="
						+ sheetObj.CellValue(Row, 'sheet1_call_seq')
						+ "&vndrSeq="
						+ sheetObj.CellValue(Row, 'sheet1_vndr_seq')
//						+ "&dueDt=" 
//						+ sheetObj.CellValue(Row, 'py_due_dt')
						+ "&revYrmon="
						+ sheetObj.CellValue(Row, 'sheet1_adv_py_rev_mon')
						+ "&row=" + Row + "&col=" + Col + "&sts="
						+ sheetObj.CellValue(Row, 'sheet1_adv_py_sts')
						+ "&trnsDt="+sheetObj.CellValue(Row, 'sheet1_trns_dt');
				// alert(url);
				ComOpenPopup(url, 1024, 480, '', '0,0', true, true);
				break;
			case 9://Invoice
				url = "/hanjin/VOP_PSO_0019.do?vvd="
						+ sheetObj.CellValue(Row, 'sheet1_vvd') + "&ydCd="
						+ sheetObj.CellValue(Row, 'sheet1_yd_cd') + "&callSeq="
						+ sheetObj.CellValue(Row, 'sheet1_call_seq') + "&vndrSeq="
						+ sheetObj.CellValue(Row, 'sheet1_vndr_seq') + "&trnsDt="
						+ sheetObj.CellValue(Row, 'sheet1_trns_dt') + "&revYrmon="
						+ formObject.revyrmon.value.replace(/-/gi, "") + "&row="
						+ Row + "&col=" + Col + "&sts="
						+ sheetObj.CellValue(Row, 'sheet1_inv_sts');
				// alert("url:="+url);
				ComOpenPopup(url, 1024, 660, '', '0,0', true, true);
				break;
			case 11://MSA
				url = "/hanjin/VOP_PSO_0020.do?vvd="
						+ sheetObj.CellValue(Row, 'sheet1_vvd')
						+ "&portNm="
						+ sheetObj.CellValue(Row, 'sheet1_yd_cd').replace(/T1/gi,
								"") + "&ydCd="
						+ sheetObj.CellValue(Row, 'sheet1_yd_cd') + "&vndrNm="
						+ sheetObj.CellValue(Row, 'sheet1_pay_to') + "&vndrSeq="
						+ sheetObj.CellValue(Row, 'sheet1_vndr_seq') + "&revYrmon="
						+ formObject.revyrmon.value.replace(/-/gi, "") + "&row="
						+ Row + "&col=" + Col + "&sts="
						+ sheetObj.CellValue(Row, 'sheet1_msa');
				ComOpenPopup(url, 1024, 550, '', '0,0', true, true);
				break;
			default:
				break;
			}//end of switch
		}//end of if
		return;
	}
	/**
	 * 전도금 정보를 PopUp에서 설정한다. 
	 * @return
	 */
	function setAdvPyStatus(sts, row, col, duedt) {
		//        	 alert("setAdvPyStatus:="+sts+"Row:="+row+"Col:="+col);
		if (sts === "A") {
			sheetObjects[0].CellValue(row, col) = 10;
			if (duedt !== "" && duedt !== undefined)
				sheetObjects[0].CellValue(row, col - 1) = duedt;
		} else if (sts === "R") {
			sheetObjects[0].CellValue(row, col) = 0;
			sheetObjects[0].CellValue(row, "sheet1_rslt") = "Rejected";
			sheetObjects[0].CellValue(row, col - 1) = "";// Due_DT Clear
		}
	}
	/**
	 * Invoice Status 정보를 설정한다. 
	 * @param sts
	 * @param row
	 * @param col
	 * @param duedt
	 * @return
	 */
	function setInvStatus(sts, row, col, duedt) {
		//        	 alert("setAdvPyStatus:="+sts+"Row:="+row+"Col:="+col);
		if (sts === "A") {
			sheetObjects[0].CellValue(row, col) = 10;
		} else if (sts === "R") {
			sheetObjects[0].CellValue(row, col) = 0;
			sheetObjects[0].CellValue(row, "sheet1_rslt") = "Rejected";
		}
	}
	/**
	 * Form데이터포멧 키 프레스 관련 
	 */
	// 업무 자바스크립트 OnKeyPress 이벤트 Catch
	function initControl() {
		axon_event.addListenerForm('change', 'obj_change', form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('blur', 'obj_deactivate', form); // - form 전체
																		// 컨트롤 중
																		// rdoCity를
																		// 제외한 모든
																		// 컨트롤의
																		// OnBeforeDeactivate이벤트에
																		// 코드 처리
		axon_event.addListenerFormat('focus', 'obj_activate', form); // - form 전체
																		// 컨트롤 중
																		// dataformat
																		// 속성이 있는 모든
																		// 컨트롤의
																		// OnBeforeActivate이벤트에
																		// 코드 처리
		// Today Setting ..
		setToday(document.form.revyrmon, "ym");
	
		// focusSetting
		document.form.revyrmon.focus();
		// ComSetFocus(document.form.revyrmon);
	
	}
	function obj_change() {
		var formObject = document.form;
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
		var sheetObject = sheetObjects[0];
		/** **************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
			case "port_cd":
				formObject.loc_cd.value = formObject.port_cd.value.substring(0, 5);
				formObject.vndr_seq.value = "";// vndr_seq를 클리어한다.
				doActionIBCombo(sheetObjects[0], formObject, IBSEARCH,
						comboObjects[0], LANE);
				break;
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate() {
		ComChkObjValid(event.srcElement);
	}
	
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	function obj_keypress() {
		obj = event.srcElement;
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
	
		if (obj.dataformat == null)
			return;
	
		if (keyValue === 13) {
			//필수 입력 조건인 WorkMonth의 값이 설정 되어있는가를 확인한다.
			var formObject = document.form;
			if (formObject.revyrmon.value === ""
					|| formObject.revyrmon.value === undefined) {
				ComShowCodeMessage("PSO00003", "Work Month");
				formObject.revyrmon.focus();
				return;
			}
			//IBCOMBO에 설정된 값을 vndr_seq파라미터에 셋팅한다.
			formObject.vndr_seq.value = comboObjects[0].Code;
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	
			return true;
		}
	
		window.defaultStatus = obj.dataformat;
	
		switch (obj.dataformat) {
		case "ymd":
		case "ym":
		case "hms":
		case "hm":
		case "jumin":
		case "saupja":
			ComKeyOnlyNumber(obj);
			break;
		case "int":
			if (obj.name == "txtInt")
				ComKeyOnlyNumber(obj, "-")
			else
				ComKeyOnlyNumber(obj);
			break;
		case "float":
			ComKeyOnlyNumber(obj, "-.");
			break;
		case "eng":
			ComKeyOnlyAlphabet();
			break;
		case "engup":
			if (obj.name == "txtEngUp2")
				ComKeyOnlyAlphabet('uppernum')
			else if(obj.name==="vsl_slan_cd") 
				ComKeyOnlyAlphabet('uppernum');	//영대문자와 숫자
			else
				ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
			if (obj.name == "txtEngDn2")
				ComKeyOnlyAlphabet('lowernum')
			else
				ComKeyOnlyAlphabet('lower');
			break;
		}
	}
	
	function openCalendar(mode) {
		switch (mode) {
		case "ym":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(document.form.revyrmon, "yyyy-MM");
			break;
		default:
			break;
		}
	}
	/**
	 * VOP_VSK-0202 Lance Code Help 팝업 창 오픈 
	 */
	function openLaneCode() {
		ComOpenPopup('/hanjin/VOP_VSK_0202.do', 420, 470, 'setLaneCode', '0,0',
				false, false);
	}
	
	function setLaneCode(aryPopupData, row, col, sheetIdx) {
		document.form.vsl_slan_cd.value = aryPopupData[0][1];
	}
	   
   	/* 개발자 작업  끝 */