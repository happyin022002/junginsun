/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0002_07.js
 *@FileTitle : SC Guideline Contract Clause Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.01
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.10.01 최성민
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
	 * @class ESM_PRI_0002_07 : ESM_PRI_0002_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_0002_07() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var enableFlg = true;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	
	function processButtonClick(){
	}
	 
	
	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * setSheetObject(sheetObj);
	 * </pre>
	 * 
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 최성민
	 * @version 2009.10.28
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.17
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		toggleButtons("CLEAR");
		parent.loadTabPage();
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.22
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
	
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 382;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "|Sel.|Del Check.|Seq.|Item|svc_scp_cd|gline_seq|ctrt_cluz_seq";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "chk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter, true, "del_chk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtDataSeq, 28, daCenter, false, "Seq");
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, false, "note_clss_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ctrt_cluz_seq", false, "", dfNone, 0, false, false);
	
                InitDataCombo(0, "note_clss_cd", noteClssCdComboText, noteClssCdComboValue);
				ColHidden("del_chk") = true;
				CountPosition = 0;
                WaitImageVisible = false;
			}
			break;
	
		case "sheet2":
			with (sheetObj) {
				// 높이 설정
				style.height = 382;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "|Sel.|Del Check.|Seq.|Surcharge|Clause|svc_scp_cd|gline_seq|note_clss_cd|ctrt_cluz_dtl_seq";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "chk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter, true, "del_chk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtDataSeq, 28, daCenter, false, "Seq");
				InitDataProperty(0, cnt++, dtCombo, 120, daLeft, false, "chg_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "ctrt_cluz_ctnt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ctrt_cluz_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ctrt_cluz_dtl_seq", false, "", dfNone, 0, false, false);
	
				InitDataCombo(0, "chg_cd", chgCdComboText, chgCdComboValue);
				
				ColHidden("del_chk") = true;
				CountPosition = 0;
				AutoRowHeight = false;
                WaitImageVisible = false;
			}
			break;
	
		}
	}
	/**
	 * OnClick 이벤트 발생시 호출되는 function <br>
	 * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
	 * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.19
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
	/**
	 * SHEET의 ROW을 클릭할때 호출되는 function <br>
	 * sheet의 Row를 선택하면 해당 Row를 해당하는 자식SHEET를 조회한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
	 * </pre>
	 * @param {ibsheet} sheetM 필수 HTML태그(Object) 오브젝트
	 * @param {ibsheet} sheetD 필수 HTML태그(Object) 오브젝트
	 * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} appendRow 필수 SHEET Row 추가 유무
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.19
	 */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
	
		if (OldRow != NewRow) {
	
			formObj.f_cmd.value = SEARCH02;
			formObj.ctrt_cluz_seq.value = sheetM.CellValue(adjNewRow, "ctrt_cluz_seq");
			if (formObj.ctrt_cluz_seq.value == "undefined" || ComIsEmpty(formObj.ctrt_cluz_seq.value)) {
				formObj.ctrt_cluz_seq.value = sheetM.CellValue(sheetM.SelectRow, "ctrt_cluz_seq");
			}
			sheetD.DoSearch("ESM_PRI_0002_07GS.do", FormQueryString(formObj));
		}
	}
	
	/**
	 * 아이템 선택시 surCharge 콤보로 변경하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *	setSurchargeCombo();
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.19
	 */
	function setSurchargeCombo() {
		//////////////아이템 선택시 surCharge 콤보로 변경// //////////////////////////
		var formObj = document.form;
		var note_clss_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd");
	
		// 마스터에서 SURCHARGE를 선택했으면 surcharge 컬럼을 보인다.
		if (note_clss_cd == "S") {
			sheetObjects[1].ColHidden("chg_cd") = false;
	
		} else {
			sheetObjects[1].ColHidden("chg_cd") = true;
		}
		//////////////////////////////////////////////////////////////////////////		
	
	}
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 *  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {string} errMsg 필수 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.19
	 */
	function sheet2_OnSearchEnd(ErrMsg) {
		setSurchargeCombo();
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.22
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			case IBSEARCH: //조회	
				if (validateForm(sheetObj, document.form, sAction)) {
					if (sheetObj.id == "sheet1") {
		  				ComOpenWait(true);
						for ( var i = 0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}
		
						formObj.f_cmd.value = SEARCH01;
						sheetObjects[0].DoSearch("ESM_PRI_0002_07GS.do", FormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				break;
			}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         로직처리;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 최성민
	 * @version 2009.04.17
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
	
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			}
			return true;
			break;
		}
	
		return true;
	}
	
	/**
	 * OnClick 이벤트 발생시 호출되는 function <br>
	 * 주소입력시 메모장을 화면에 표시한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
	 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
	 * @return 없음
	 * @author 공백진
	 * @version 2009.06.03
	 */
	function sheet2_OnClick(sheetObj, Row, Col, Value) {
		//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
		var colname = sheetObj.ColSaveName(Col);
	
		switch (colname) {
		case "ctrt_cluz_ctnt":
			ComShowMemoPad(sheetObj, Row, Col, true, 678, 200);
			break;
		}
	
	}
	
	/**
	 * 버튼을 컨트롤하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {string} mode 필수 mode 세팅 값 
	 * @return 없음
	 * @author 공백진
	 * @version 2009.06.03
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_Retrieve");
			break;
		case "INIT":
			enableButton("btn_Retrieve");
			break;
		case "READONLY":
			enableButton("btn_Retrieve");
			break;
		}
	}
	/**
	 * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
	 * 화면이 보여지며 조회를 한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * tabLoadSheet("ACE", "1")
	 * </pre>
	 * @param {string} sPropNo 필수 prop_no 값
	 * @param {string} sAmdtSeq 필수 amdt_seq 값
	 * @param {string} sSvcScpCd 필수 svc_scp_cd 값
	 * @param {string} sConChk 필수 Conversion check 값
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.21
	 */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
	
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
	
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
			if (enableFlag && isAproUsr) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}
		}
	}
	/**
	 * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * tabClearSheet()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */
	function tabClearSheet() {
		var formObject = document.form;
	
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
	
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	/**
	 * 메인에서 호출하는 function <br>
	 * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * tabEnableSheet(flag)
	 * </pre>
	 * 
	 * @param {boolean} flag 필수 메인화면에서 넘긴다.
	 * @return 없음
	 * @author 최성민
	 * @version 2009.04.17
	 */
	function tabEnableSheet(flag) {
		var formObject = document.form;
	
		enableFlag = flag;
	
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}

/* 개발자 작업  끝 */