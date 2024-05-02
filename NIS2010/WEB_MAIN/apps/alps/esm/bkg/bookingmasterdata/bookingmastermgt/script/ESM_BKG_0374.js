	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0374.js
	 *@FileTitle : Arrival Notice: Destination Office (USA)
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
	 * @class esm_bkg_0374  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_0374() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업	*/
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var prefix = "";//IBSheet 구분자
	
	var selectedRowForSave = "";//저장 후 재조회 목적
	var selectedCustSeq = "";//현재 선택된 Customer Seq (데이타 카피 목적)
	var selectedRowForCopy = "";//현재 선택된 Customer Seq(데이타 카피 목적) 
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
	var comboObjects = new Array();
	/*********************** EDTITABLE MULIT COMBO END ********************/
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		initControl();
		//멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		//setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); },100);
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//form.cust_cnt_cd.focus();
	
	}
	
	function initControl() {
		var formObject = document.form;
	
		axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
		axon_event.addListenerForm('blur', 'bkg_blur', formObject); //- 포커스 나갈때     
		axon_event.addListenerFormat('focus', 'bkg_focus', formObject); //- 포커스 들어갈때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	
	/*********************** KEY EVENT START ********************/
	function bkg_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet('upper');
				break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdnnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('lowernum');
				break;
			case "num":
				//숫자 입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "address":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
				break;
			case "num":
			case "zipcode":
				//숫자 입력하기
				ComKeyOnlyNumber(event.srcElement, '-');
				break;
			default:
		}
	}
	
	/**
	 * HTML Control의 onBlur을 제어한다.
	 **/
	function bkg_blur() {
	
		var formObj = document.form;
		switch (event.srcElement.getAttribute("name")) {
			case "from_dt":
				ComAddSeparator(event.srcElement);
				break;
			case "to_dt":
				ComAddSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus() {
		var formObj = document.form;
		switch (event.srcElement.getAttribute("name")) {
			case "from_dt":
				ComClearSeparator(event.srcElement);
				break;
			case "to_dt":
				ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	
	/*********************** KEY EVENT END ********************/
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
	
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
	
				case "btn_Save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
	
				case "btn_RowAdd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
				case "btn_RowDelete":
					var iCheckRow = sheetObject1.FindCheckedRow(prefix + "del_chk");
					var arrRow = iCheckRow.split("|");
					//alert(arrRow);
					if (iCheckRow == "") {
						ComShowCodeMessage('COM12189');
						return;
					}
	
					ComRowHideDelete(sheetObject1, prefix + "del_chk");
					break;
				case "btn_New":
					form.reset();
					sheetObject1.RemoveAll();
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
					break;
				case "btn_RowCopy":
					sheetObject1.DataCopy();
					break;
				case "btn_Close":
					self.close();
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
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
			case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.DoSearch("ESM_BKG_0374GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				/*
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				//	alert(sXml);
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = false;	
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.Redraw = true;
				
				 */
				break;
			case SEARCH01: //조회
				break;
	
			case IBSEARCHAPPEND: // 페이징 조회
			case IBINSERT: // 입력					
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				sheetObj.DataInsert(-1);
				break;
	
			case IBSAVE: //저장
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = MULTI;
				var sParam = sheetObj.GetSaveString();
				if (sheetObj.IsDataModified && sParam == "")
					return;
				sParam += "&" + FormQueryString(formObj);
	
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0374GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				break;
			case IBDOWNEXCEL: // 엑셀다운로드
				sheetObj.SpeedDown2Excel(1);
				break;
	
		}
	}
	
	/**
	 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
	 * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @version 2009.05.17
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObject = document.form;
		if (ErrMsg == "") {
			ComBkgSaveCompleted();
			sheetObj.RemoveAll();
			doActionIBSheet(sheetObj, formObject, IBSEARCH);
		}
	}
	
	/**
	 * 조회 후 처리
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		if (sheetObj.RowCount > 0){
			ComSetObjValue(formObj.p_hndl_ofc_cd,sheetObj.CellValue(1,prefix + "hndl_ofc_cd"));
		}
	}
	
	/*
	 * 페이징 처리
	 * */
	function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	
	}
	
	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
	
		var temp = "";
		if (colName == prefix + "diff_rmk") {
			sheetObj.CellEditable(Row, colName) = false;
			ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200);
			sheetObj.CellEditable(Row, colName) = true;
		}
	}
	
	/**
	 *  Remark MemoPad 
	 */
	function sheet1_OnClick(sheetObj, row, col, value) {
	
		//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
		if (sheetObj.ColSaveName(col) == prefix + "diff_rmk") {
			//             	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)	 
			//      			ComShowMemoPad(sheetObj, row,8, null, null, null, 1000);
		}
	
	}
	
	/*
	 * 저장을 위한 데이타 값 처리
	 * 
	 */
	function sheet1_OnValidation(sheetObj, rowIdx, colIdx, value) {
		if (sheetObj.CellValue(rowIdx, prefix + "ibflag") == 'D')
			return;
	
		if (colIdx == sheetObj.SaveNameCol(prefix + "phn_no")) {
			if (!ComIsNull(value) && !ComIsNumber(value, "-")) {
				ComShowCodeMessage("BKG95001", " enter correct 'Tel No'", "(Format:123-1234-1234)");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
	
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "ntc_eml")) {
			if (!ComIsNull(value) && !ComIsEmailAddr(value)) {
				ComShowCodeMessage("BKG95001", " enter correct 'Email Address'", "");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
	
	}
	
	function setCelColor(flag, obj, idx, celName, color) {
		if (flag == "N")
			obj.CellFontColor(idx, celName) = color;
	
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (ComIsNull(formObj.p_eq_ctrl_ofc_cd)) {
			ComShowCodeMessage('BKG00626', 'EQ Office Code');
			formObj.p_eq_ctrl_ofc_cd.focus();
			return false;
		}
		if (formObj.p_eq_ctrl_ofc_cd.value.length != 5) {
			ComShowCodeMessage('BKG95018', 'EQ Office Code', '5');
			formObj.p_eq_ctrl_ofc_cd.focus();
			return false;
		}
	
		if (sAction == IBSEARCH)
			return true;
	
		if (ComIsNull(formObj.p_hndl_ofc_cd)) {
			ComShowCodeMessage('BKG00626', 'Handling Office Code');
			formObj.p_hndl_ofc_cd.focus();
			return false;
		}
	
		if (formObj.p_hndl_ofc_cd.value.length != 5) {
			ComShowCodeMessage('BKG95018', 'Handling Office Code', '5');
			formObj.p_hndl_ofc_cd.focus();
			return false;
		}
	
		switch (sAction) {
			case IBSEARCH:
				break;
			case IBSAVE:
				if (eval(sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U")) > 2) {
					ComShowCodeMessage('BKG01057');
					return false;
				}
	
				//if(eval(sheetObj.RowCount("D")+ sheetObj.RowCount("I") + sheetObj.RowCount("U")) ==0 )return; 
				//생성,수정시 중복된 Part Code가 있는지 확인한다.
				if (eval(sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U")) > 1) {
					var editCnt = 0;
					var editArr = new Array();
					var statusCode = "";
					for ( var index = 0 + sheetObj.HeaderRows; index <= sheetObj.RowCount; index++) {
						statusCode = sheetObj.CellValue(index, prefix + "ibflag");
						if (statusCode == "R" || statusCode == "U" || statusCode == "I") {
							editArr[editCnt] = sheetObj.CellValue(index, prefix + "dest_ofc_cntc_cd");
							editCnt++;
						}
					}
	
					if (editArr[0] == editArr[1]) {
						ComShowCodeMessage("BKG03056", "Name");
						return false;
					}
	
				}
	
				//alert(eval(sheetObj.RowCount("D")+ sheetObj.RowCount("I") + sheetObj.RowCount("U")));
	
				if (sheetObj.RowCount("U") + sheetObj.RowCount("I") > 0) {
	
				formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0374GS.do", FormQueryString(formObj));
	
					//var sXml = sheetObj.DoSearch("ESM_BKG_0374GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
					if (ComGetEtcData(sXml, "HQ_OFC_SELECT_FLAG") == "Y") {
						ComShowCodeMessage('BKG08112');
						return;
					}
				}
	
				break;
			case IBINSERT:
				//EQ Office Code - Handling Office Code 당 등록될 수 있는 Part Code는 2개임.		
				if (eval(sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U")) >= 2) {
					ComShowCodeMessage('BKG01057');
					return false;
				}
				break;
		}
		return true;
	}
	
	/**
	 * 화면 yyyyMMd 날짜 체크
	 */
	function dateCheck(dateobj) {
		if (dateobj.value == "")
			return true;//null이면 체크 안함
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
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetObj.id) {
	
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 187;
	
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 50);
	
					var HeadTitle1 = "|Sel.|||Name|Tel.|E-mail|Remark(s)";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(true, true, true, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag");
					InitDataProperty(0, cnt++, dtDelCheck, 40, daCenter, false, prefix + "del_chk");
					InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, prefix + "eq_ctrl_ofc_cd");
					InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, prefix + "hndl_ofc_cd");
					InitDataProperty(0, cnt++, dtCombo, 130, daCenter, false, prefix + "dest_ofc_cntc_cd", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, false, prefix + "phn_no", false, "", dfNone, 0, true, true, 20);
					InitDataProperty(0, cnt++, dtData, 240, daCenter, false, prefix + "ntc_eml", false, "", dfNone, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, prefix + "diff_rmk", false, "", dfNone, 0, true, true, 4000);
	
					InitDataCombo(0, prefix + "dest_ofc_cntc_cd", "Customer Service|Traffic(Delivery Order)", "I|D");
	
					Ellipsis = true;
					CountPosition = 0;//[1/3] 페이지 위치
				}
	
				break;
		}
	}
	
	/* 개발자 작업  끝 */
	
