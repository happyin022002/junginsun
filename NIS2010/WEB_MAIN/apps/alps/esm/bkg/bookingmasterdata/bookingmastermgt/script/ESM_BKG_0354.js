	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0354.js
	 *@FileTitle : Canada ACI: Location of Goods Setup
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.21
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.21 김경섭
	 * 1.0 Creation
	 * 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
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
	 * @class esm_bkg_0354  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_0354() {
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
	
	var prefix = "sheet1_";//IBSheet 구분자
	
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
	
		var comboObject1 = comboObjects[0];
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
	
	var ValidateFail = false;// sheet ValidateFail 속성을 읽을 수 없어 별도의 변수를 둔다.
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo, param) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
			case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction)) return;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.DoSearch("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				break;
				
			case SEARCH01: //조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param + "&" + ComGetPrefixParam(prefix));
				return ComGetEtcData(sXml, "EXIST_MSG");
				break;
				
			case SEARCH02: //Yard Description 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param + "&" + ComGetPrefixParam(prefix));
				return ComGetEtcData(sXml, "YD_DESC");
				break;
				
			case SEARCH03: //Location Description 조회
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param);
				return ComGetEtcData(sXml, "LOC_DESC");
				break;
	
			case IBSEARCHAPPEND: // 페이징 조회
			
			case IBINSERT: // 입력					
				sheetObj.DataInsert(-1);
				break;
	
			case IBSAVE: //저장
				if (!validateForm(sheetObj, formObj, sAction)) return;
				var sParam = sheetObj.GetSaveString().replace(/sheet1_/gi,"");
				if (sheetObj.IsDataModified && sParam == "")
					return;
				if (!validateForm(sheetObj, formObj, sAction)){
					return;
				}
				formObj.f_cmd.value = MULTI;
				sParam += "&" + FormQueryString(formObj);
//				sParam = sParam.replace(/sheet1_/gi,"");

				sheetObj.DoSave("ESM_BKG_0354GS.do", sParam);
				
				/*var sXml = sheetObj.GetSaveXml("ESM_BKG_0354GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);*/
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
	
	/*
	 * 페이징 처리
	 * */
	function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	
	}
	
	function sheet1_OnChange(sheetObj, rowIdx, colIdx, value) {
		var formObject = document.form;
		
		if (sheetObj.CellValue(rowIdx, prefix + "ibflag") == 'D') return;

		if( colIdx == sheetObj.SaveNameCol(prefix + "pod_cd") ){
			var pod_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.CellValue(rowIdx, prefix + "pod_cd"));
			sheetObj.CellValue2(rowIdx, prefix + "pod_desc") = pod_desc_val;
			sheetObj.CellValue2(rowIdx, prefix + "pod_cd_cpy") = sheetObj.CellValue(rowIdx, prefix + "pod_cd");
			if( pod_desc_val == "" ){
				ComShowCodeMessage("COM132201","POD Code");
				sheetObj.CellValue2(rowIdx, prefix + "pod_cd") = "";
				sheetObj.CellValue2(rowIdx, prefix + "pod_cd_cpy") = "";
				return;
			}
		} else if( colIdx == sheetObj.SaveNameCol(prefix + "pod_yd_no") ){
			sheetObj.CellValue(rowIdx, prefix + "pod_yd_no") = sheetObj.CellValue(rowIdx, prefix + "pod_yd_no").toUpperCase();
			var yd_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH02, rowIdx, colIdx, 1, "pod_yd_no="+sheetObj.CellValue(rowIdx, prefix + "pod_cd") + sheetObj.CellValue(rowIdx, prefix + "pod_yd_no"));
			sheetObj.CellValue2(rowIdx, prefix + "yd_desc") = yd_desc_val;
			if( sheetObj.CellValue(rowIdx, prefix + "pod_yd_no") != "" && yd_desc_val == "" ){
				ComShowCodeMessage("BKG01078",sheetObj.CellValue(rowIdx, prefix + "pod_yd_no"));
				sheetObj.CellValue2(rowIdx, prefix + "pod_yd_no") = "";
				return;
			}
		} else if( colIdx == sheetObj.SaveNameCol(prefix + "del_cd") ){
			var del_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.CellValue(rowIdx, prefix + "del_cd"));
			sheetObj.CellValue2(rowIdx, prefix + "del_desc") = del_desc_val;
			if( del_desc_val == "" ){
				ComShowCodeMessage("COM132201","DEL Code");
				sheetObj.CellValue2(rowIdx, prefix + "del_cd") = "";
				return;
			}
		} else if( colIdx == sheetObj.SaveNameCol(prefix + "hub_loc_cd") ){
			var hub_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.CellValue(rowIdx, prefix + "hub_loc_cd"));
			sheetObj.CellValue2(rowIdx, prefix + "hub_desc") = hub_desc_val;
			if( hub_desc_val == "" ){
				ComShowCodeMessage("COM132201","HUB Code");
				sheetObj.CellValue2(rowIdx, prefix + "hub_loc_cd") = "";
				return;
			}
		}
	}
	
	/*
	 * 저장을 위한 데이타 값 처리
	 * 
	 */
	/*function sheet1_OnValidation(sheetObj,rowIdx,colIdx,value) {
		
		sheetObj.ValidateFail = false;
		if (sheetObj.CellValue(rowIdx, prefix + "ibflag") == 'D')
			return;
	
		if (colIdx == sheetObj.SaveNameCol(prefix + "pod_cd")) {
			if (ComIsNull(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG00626", "POD Code");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			} else if (!ComIsAlphabet(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG95001", " enter correct 'POD Code'", "");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			} else if (value == sheetObj.CellValue(rowIdx, prefix + "del_cd")) {
				ValidateFail = true;
				ComShowCodeMessage("BKG95001", "Pod Code와 Del Code가 같습니다.", "");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
	
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "del_cd")) {
			if (ComIsNull(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG00626", "DEL Code");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			} else if (!ComIsAlphabet(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG95001", " enter correct 'DEL Code'", "");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
	
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "hub_loc_cd")) {
			if (ComIsNull(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG00626", "HUB Code");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			} else if (!ComIsAlphabet(value)) {
				ComShowCodeMessage("BKG95001", " enter correct 'HUB LOC Code'", "");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
	
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "trsp_mod_id")) {
			if (ComIsNull(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG00626", " Transport Mode");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			} else if (!ComIsAlphabet(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG95001", " enter correct 'Transport Mode ID'", "");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
	
		} else if (colIdx == sheetObj.SaveNameCol(prefix + "gds_desc")) {
			if (ComIsNull(value)) {
				ValidateFail = true;
				ComShowCodeMessage("BKG00626", "Location of Goods");
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
	}
	 */
	
	function setCelColor(flag, obj, idx, celName, color) {
		if (flag == "N")
			obj.CellFontColor(idx, celName) = color;
	
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (ComIsNull(formObj.p_pod_cd)) {
					ComShowCodeMessage('BKG00626', 'POD Code');
					return false;
				}
	
				if (formObj.p_pod_cd.value.length != 5) {
					ComShowCodeMessage('BKG95018', 'POD Code', '5');
					return false;
				}
	
				break;
			case IBSAVE:
				if( !sheetObj.IsDataModified ){
					return false;
				}
				
				var chgRow = "";
				for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
					if( sheetObj.RowStatus(idx) == "I" || sheetObj.RowStatus(idx) == "U" ){
						chgRow = chgRow + idx + ",";
					}
				}
				
				//Duplication Check
				chgRow = chgRow.substr(0,chgRow.length - 1);
				if( chgRow != "" ){
					var rowArr = chgRow.split(",");
					
					for( var idx = 0; idx < rowArr.length; idx++ ){
						for( var jdx = 0 + parseInt(sheetObj.HeaderRows); jdx <= sheetObj.LastRow; jdx++ ){
							if( parseInt(rowArr[idx]) != jdx ){
								if( sheetObj.CellValue(rowArr[idx], prefix + "pod_cd") == sheetObj.CellValue(jdx, prefix + "pod_cd")
								&& sheetObj.CellValue(rowArr[idx], prefix + "pod_yd_no") == sheetObj.CellValue(jdx, prefix + "pod_yd_no")
								&& sheetObj.CellValue(rowArr[idx], prefix + "del_cd") == sheetObj.CellValue(jdx, prefix + "del_cd")
								&& sheetObj.RowStatus(rowArr[idx]) != "D" && sheetObj.RowStatus(jdx) != "D" ){
									ComShowCodeMessage("BKG06134");
									return false;
								}
							}
						}
					}
				}

				/*
				 * DB 중복 키 검사
				 * */
				/*var tempParam = "pod_cd=";
				for ( var i = HeaderRows; i < RowCount + HeaderRows; i++) {
					if (CellValue(i, prefix + "ibflag") == 'R' || CellValue(i, prefix + "ibflag") == 'U' || CellValue(i, prefix + "ibflag") == 'D')
						continue;

					tempParam += CellValue(i, prefix + "pod_cd") + ">" + CellValue(i, prefix + "del_cd") + "|";
				}
				
				var returnVal = doActionIBSheet(sheetObj, formObj, SEARCH01, true, true, 1, tempParam);
				if (returnVal != "") {
					ComShowCodeMessage("COM12115", returnVal);
					return false;
				}*/
	
				break;
	
		}
		return true;
	}
	
	/**
	 * Grid내 중복 체크
	 */
	function checkDupGrid(sheetObj, idx, podCd, delCd) {
		with (sheetObj) {
			for ( var i = idx + 1; i < RowCount + HeaderRows; i++) {
				if (CellValue(i, prefix + "ibflag") == 'D')
					continue;
				if (podCd + delCd == CellValue(i, prefix + "pod_cd") + CellValue(i, prefix + "del_cd")) {
					ComShowCodeMessage("COM12115", "POD:" + podCd + " DEL:" + delCd);
					sheetObj.SelectCell(i, prefix + "pod_cd");
					return true;
				}
			}
		}
	
		return false;
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
					style.height = 422;
	
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
	
					var HeadTitle1 = "|Sel.|Seq|POD YARD|POD YARD|YARD Description|POD|POD Description|DEL|DEL Description|HUB|HUB Description|Transport Mode|Location of Goods|Customs Code";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(true, true, true, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, 	dtHiddenStatus, 	 0, daCenter, 	true, 		prefix + "ibflag");
					InitDataProperty(0, cnt++, 	dtCheckBox, 		40, daCenter, 	true, 		prefix + "del_chk");
					InitDataProperty(0, cnt++, 	dtHidden, 		    50, daCenter, 	true, 		prefix + "gds_loc_seq", false, 		"", 		dfNone, 			0, 	false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true, 		prefix + "pod_cd", 		true, 		"", 		dfNone, 			0, 	true, 		true, 		5);
					InitDataProperty(0, cnt++, 	dtData, 			30, daCenter, 	true, 		prefix + "pod_yd_no", 	false, 		"", 		dfNone, 			0, 	true, 		true, 		2);
					InitDataProperty(0, cnt++, 	dtData, 		   140, daLeft, 	true, 		prefix + "yd_desc", 	false, 		"", 		dfNone, 			0, 	false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true, 		prefix + "pod_cd_cpy", 	false, 		"", 		dfNone, 			0, 	false, 		false, 		5);
					InitDataProperty(0, cnt++, 	dtData, 		   140, daLeft, 	true, 		prefix + "pod_desc", 	false, 		"", 		dfNone, 			0, 	false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60,	daCenter, 	true, 		prefix + "del_cd", 		true, 		"", 		dfNone, 			0, 	true, 		true, 		5);
					InitDataProperty(0, cnt++, 	dtData, 		   140, daLeft, 	true, 		prefix + "del_desc", 	false, 		"", 		dfNone, 			0, 	false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true, 		prefix + "hub_loc_cd",	true, 		"", 		dfNone, 			0, 	true, 		true, 		5);
					InitDataProperty(0, cnt++, 	dtData, 		   140, daLeft, 	true, 		prefix + "hub_desc", 	false, 		"", 		dfNone, 			0, 	false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   110, daCenter, 	true, 		prefix + "trsp_mod_id", true, 		"", 		dfNone, 			0, 	true, 		true, 		3);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daLeft, 	true, 		prefix + "gds_desc", 	false, 		"", 		dfNone, 			0, 	true, 		true, 		100);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true, 		prefix + "cstms_cd", 	false, 		"", 		dfUserFormat, 		0, 	true, 		true, 		4);

					InitDataValid(0, prefix + "pod_cd", vtEngUpOnly, "");
					InitDataValid(0, prefix + "pod_yd_no", vtEngOther, "1234567890");
					InitDataValid(0, prefix + "del_cd", vtEngUpOnly, "");
					InitDataValid(0, prefix + "hub_loc_cd", vtEngUpOnly, "");
					InitDataValid(0, prefix + "trsp_mod_id", vtEngUpOnly, "");
					InitUserFormat(0, prefix + "cstms_cd", "####", "");
					//CountPosition = 0;//[1/3] 페이지 위치 
				}
	
				break;
			}
	}
	 
	/* 개발자 작업  끝 */
	
