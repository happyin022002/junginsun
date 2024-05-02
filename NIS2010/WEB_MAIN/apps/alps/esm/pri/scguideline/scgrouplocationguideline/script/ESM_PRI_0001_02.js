/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0001_02.js
 *@FileTitle : Locaton Group Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.21 박성수
 * 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
	 * @class Guideline Creation : Guideline Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
	 *        정의한다.
	 */
	function ESM_PRI_0001_02() {
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
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tabLoad = new Array();
	tabLoad[0] = 0;
	tabLoad[1] = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
		
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
					break;
		
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
					
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
		
				case "btn_delete1":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;
					
				case "btn_delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 321;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Code|Description";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, true, true, 4, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, true, true, 100);
					
					InitDataValid(0, "prc_grp_loc_cd", vtEngUpOnly);
					ShowButtonImage = 2;
					
					MessageText("UserMsg17") = " " + ComGetMsg("PRI00317");
		
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 321;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Code|Description|Subcontinent Code|Subcontinent";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_dtl_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "loc_nm", true, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "sconti_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sconti_nm", false, "", dfEngKey, 0, false, false);
					
					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				InitDataValid(0, "loc_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
                    
					ShowButtonImage = 2;
					
					MessageText("UserMsg17") = " " + ComGetMsg("PRI00318");
		
				}
				break;

			case "sheet3":
				with (sheetObj) {
					// 높이 설정
					style.height = 270;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Group Code|Description|Location Code|Description|Subcontinent Code|Subcontinent";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "gline_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "grp_loc_dtl_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, true, true, 4, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "loc_nm", true, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "sconti_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sconti_nm", false, "", dfEngKey, 0, false, false);
		
					Visible = false;
				}
				break;
		}
	}
	
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
	
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
	 
	/**
	 * OnBeforeEdit 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "prc_grp_loc_cd") {

		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "prc_grp_loc_cd") {
			if (Value != sheetObj.CellSearchValue(Row, "prc_grp_loc_cd")) {
				formObj.f_cmd.value = SEARCH10;
				var sParam = FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
				var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_02GS.do", sParam);
				var arrTemp = ComPriXml2Array(sXml, "etc1");
				
				if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
					var cntRateInUse = parseInt(arrTemp[0][0]);
					var cntArbInUse = parseInt(arrTemp[1][0]);
					
					if (cntRateInUse > 0) {
						sheetObj.CellValue2(Row, "prc_grp_loc_cd") = sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
						ComShowCodeMessage("PRI01126", "Rate");
						return false;
					}
					if (cntArbInUse > 0) {
						sheetObj.CellValue2(Row, "prc_grp_loc_cd") = sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
						ComShowCodeMessage("PRI01126", "[Arbitrary]");
						return false;
					}
				}
			}
			
			if (Value.length != 4) {
				sheetObj.CellValue2(Row, "prc_grp_loc_cd") = "";
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				
				return false;
			}
		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "loc_cd") {
			if (Value.length == 5) {		
				formObj.f_cmd.value = SEARCH05;
				var sParam = FormQueryString(formObj) + "&" + "cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObjects[1].CellValue2(Row, "loc_nm") = arrDesc[0][1];
					sheetObjects[1].CellValue2(Row, "sconti_cd") = arrDesc[0][2];
					sheetObjects[1].CellValue2(Row, "sconti_nm") = arrDesc[0][3];
				} else {
					sheetObj.CellValue2(Row, "loc_cd") = "";
					sheetObj.CellValue2(Row, "loc_nm") = "";
					sheetObj.CellValue2(Row, "sconti_cd") = "";
					sheetObj.CellValue2(Row, "sconti_nm") = "";
					sheetObj.SelectCell(Row, "loc_cd", false);
					
					//ComShowCodeMessage("PRI00315");
					return false;
				}
			} else {
				sheetObj.CellValue2(Row, "loc_cd") = "";
				sheetObj.CellValue2(Row, "loc_nm") = "";
				sheetObj.CellValue2(Row, "sconti_cd") = "";
				sheetObj.CellValue2(Row, "sconti_nm") = "";
				sheetObj.SelectCell(Row, "loc_cd", false);
				
				//ComShowCodeMessage("PRI00318");
				return false;
			}
		}
	}
	
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "loc_cd") {
			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=L&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			
			}
		}
	}
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			sheetObj.Down2Excel();
		}
	}
	
	var isFiredNested = false;
	var supressConfirm = false;
	/**
	 * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested = true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (sheetD.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetM.DataInsert();
				isFiredNested = false;
				return idx;
			} else {
				formObj.grp_loc_seq.value = sheetM.CellValue(adjNewRow, "grp_loc_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
            
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
				case IBSEARCH: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
						for (var i = 0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}
						
						formObj.f_cmd.value = SEARCH01;
						sheetObj.DoSearch("ESM_PRI_0001_02GS.do" , FormQueryString(formObj));
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
					
				case IBSEARCHAPPEND: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0001_02GS.do" , FormQueryString(formObj));
					}
					break;
			
				case IBSAVE: // 저장
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
	// 저장시 변경한 Group Location이 Rate나 ARB에서 사용중인지 체크. -> OnBeforeEdit에서 체크하는것으로 변경
	//				for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i < sheetObj.LastRow; i++) {
	//					if (sheetObj.RowStatus(i) == "U" && sheetObj.CellValue(i, "prc_grp_loc_cd") !=  sheetObj.CellSearchValue(i, "prc_grp_loc_cd")) {
	//						formObj.f_cmd.value = SEARCH10;
	//						var sParam = FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.CellSearchValue(i, "prc_grp_loc_cd");
	//						var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_02GS.do", sParam);
	//						var arrTemp = ComPriXml2Array(sXml, "etc1");
	//						
	//						if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
	//							var cntRateInUse = parseInt(arrTemp[0][0]);
	//							var cntArbInUse = parseInt(arrTemp[1][0]);
	//							
	//							if (cntRateInUse > 0) {
	//								ComShowCodeMessage("PRI01022", "[Rate]");
	//								return false;
	//							}
	//							if (cntArbInUse > 0) {
	//								ComShowCodeMessage("PRI01022", "[Arbitrary]");
	//								return false;
	//							}
	//						} else {
	//							return false;
	//						}
	//					}
	//				}
					
					formObj.f_cmd.value = MULTI01;
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
					var sParamSheet2 = sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
	
					if (!supressConfirm && !ComPriConfirmSave()) {
						return false;
					}
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0001_02GS.do", sParam);
					sheetObjects[1].LoadSaveXml(sXml);
					sheetObjects[0].LoadSaveXml(sXml);
					
					if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
						return false;
					} else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, false);
						}
						
						parent.setTabStyle();
						ComPriSaveCompleted();
						return true;
					}
					break;
				
				case IBDOWNEXCEL:
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value = SEARCH03;
						sheetObj.DoSearch("ESM_PRI_0001_02GS.do" , FormQueryString(formObj));
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
					
				case IBINSERT: // Row Add
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (sheetObj.id == "sheet1") {
						var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);
						if (idx < 0) {
							return false;
						}
						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
						sheetObjects[1].RemoveAll();
						sheetObj.CellValue(idx, "grp_loc_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1;
						
						sheetObj.SelectCell(idx, "prc_grp_loc_cd", false);
					}
					if (sheetObj.id == "sheet2") {
						var idx = sheetObj.DataInsert();
						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
						var grp_loc_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
						sheetObj.CellValue(idx, "grp_loc_seq") = grp_loc_seq;
						sheetObj.CellValue(idx, "grp_loc_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1;
						
						sheetObj.SelectCell(idx, "loc_cd", false);
					}
					break;
					
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}
		        	
					if (sheetObj.id == "sheet1") {
						var arrChecked = sheetObj.FindCheckedRow("chk").split("|");
						for (var i = 0; i < arrChecked.length; i++) {
							if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
								continue;
							}
							
							formObj.f_cmd.value = SEARCH10;
							var sParam = FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.CellValue(arrChecked[i], "prc_grp_loc_cd");
							var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_02GS.do", sParam);
							var arrTemp = ComPriXml2Array(sXml, "etc1");
							
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntRateInUse = parseInt(arrTemp[0][0]);
								var cntArbInUse = parseInt(arrTemp[1][0]);
								
								if (cntRateInUse > 0) {
									ComShowCodeMessage("PRI01126", "Rate");
									return false;
								}
								if (cntArbInUse > 0) {
									ComShowCodeMessage("PRI01126", "Arbitrary");
									return false;
								}
							} else {
								return false;
							}
						}
					}
					
					if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
						sheetObjects[1].RemoveAll();
					}
					
		        	var delCnt = deleteRowCheck(sheetObj, "chk");
					if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
						sheetObjects[1].RemoveAll();
					}
					
					//DETAIL의 모든 ROW를 삭제할경우 체크
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) <= 0) {
						if (ComShowCodeConfirm("PRI00021")){
			  				//MASTER에 체크되어 있는 데이터를 언체크한다.
							sheetObjects[0].CheckAll2("chk") = 0;
							//ARB, RATE화면에서 사용중인지 체크한다. 사용중이면 재조회
							formObj.f_cmd.value = SEARCH10;
							var sParam = FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "prc_grp_loc_cd");
							var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0001_02GS.do", sParam);
							var arrTemp = ComPriXml2Array(sXml, "etc1");
							
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntRateInUse = parseInt(arrTemp[0][0]);
								var cntArbInUse = parseInt(arrTemp[1][0]);
								
								if (cntRateInUse > 0) {
									ComShowCodeMessage("PRI01126", "Rate");
									formObj.grp_loc_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
									doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									return false;
								} else if (cntArbInUse > 0) {
									ComShowCodeMessage("PRI01126", "Arbitrary");
									formObj.grp_loc_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
									doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									return false;
								} else {
									sheetObjects[1].RemoveAll();
									sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "chk") = "1";
									deleteRowCheck(sheetObjects[0], "chk");
								}
								

							}
						}
					}
					break;
					
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
	
		case IBSAVE: // 저장
			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
				ComShowCodeMessage("PRI00319", "Location Group");
				return false;
			}
			
			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			
			if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			
			var rowM = sheetObjects[0].ColValueDup("svc_scp_cd|gline_seq|prc_grp_loc_cd", false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			
			var rowD = sheetObjects[1].ColValueDup("svc_scp_cd|gline_seq|grp_loc_seq|loc_cd", false);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			
			return true;
			break;
			
		case IBDOWNEXCEL: // 엑셀저장
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBINSERT: // Row Add
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
			if (sheetObj.id == "sheet2") {
				if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
					return false;
				}
			}
			
			return true;
			break;
			
		case IBDELETE: // Delete
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
	
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_downexcel");
			disableButton("btn_rowadd1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete1");
			disableButton("btn_delete2");
			
			sheetObjects[0].Editable = false;
			sheetObjects[1].Editable = false;
			break;
		case "INIT":
			enableButton("btn_retrieve");
			enableButton("btn_save");
			enableButton("btn_downexcel");
			enableButton("btn_rowadd1");
			enableButton("btn_rowadd2");
			enableButton("btn_delete1");
			enableButton("btn_delete2");
			
			sheetObjects[0].Editable = true;
			sheetObjects[1].Editable = true;
			break;
		case "READONLY":
			enableButton("btn_retrieve");
			disableButton("btn_save");
			enableButton("btn_downexcel");
			disableButton("btn_rowadd1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete1");
			disableButton("btn_delete2");
			
			sheetObjects[0].Editable = false;
			sheetObjects[1].Editable = false;
			break;
		}
	}
	
	/**
	 * 탭안의 화면이 로드되었을때 상위에서 호출하는 함수. 초기값을 세팅하고 화면을 조회한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag = true;
            } else {
            	enableFlag = false;
            }
			
			if (enableFlag && isAproUsr) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}
		}
	}
	
	/**
	 * 화면의 모든 내용을 초기화하는 함수로, 상위프레임에서 호출된다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
		formObject.grp_loc_seq.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
		
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
	
	/* 개발자 작업 끝 */