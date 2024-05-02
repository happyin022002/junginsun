/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ui_pri_0001_01.js
 *@FileTitle : Sales Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
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
	 * @class Guideline Creation : Guideline Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
	 *        정의한다.
	 */
	function ESM_PRI_0001_01() {
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
		
				case "btn_rowadd":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
		
				case "btn_rowcopy":
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
		
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
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
		
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		
		toggleButtons("CLEAR");
		
		parent.loadTabPage();
	}
	
	/**
	 * Onbeforedeactivate  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_deactivate(){
		if (ComChkObjValid(window.event.srcElement)) {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
			    case "ref_ctnt":
			        sheetObjects[0].CellValue(sheetObjects[0].SelectRow , "ref_ctnt") = document.form.ref_ctnt.value;
			        break;
			}
			
			return true;
		} else {
			return false;
		}
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
					style.height = 179;
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
		
					var HeadTitle = "|Sel.|Seq.|Service Scope|Gline Seq.|Ref Seq.|Title|Content";
		
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
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ref_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ref_tit_nm", true, "", dfNone, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ref_ctnt", true, "", dfNone, 0, true, true, 4000);
					
					ColHidden("ref_ctnt") = true;
		
				}
				break;
	
		}
	}
	
	/**
	 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		if (ErrMsg == "") {
			parent.setTabStyle();
			ComPriSaveCompleted();
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
		var formObj = document.form;
		
		if (OldRow != NewRow) {
			formObj.ref_ctnt.value = sheetObj.CellValue(NewRow, "ref_ctnt");
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
						formObj.f_cmd.value = SEARCH01;
						sheetObj.WaitImageVisible = false;
						sheetObj.DoSearch("ESM_PRI_0001_01GS.do", FormQueryString(formObj));
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
			
				case IBSAVE: // 저장
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComPriConfirmSave()) {
						return false;
					}
					
					formObj.f_cmd.value = MULTI01;
					sheetObj.DoSave("ESM_PRI_0001_01GS.do", FormQueryString(formObj), -1, false);
					break;
					
				case IBINSERT: // Row Add
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var idx = sheetObj.DataInsert();
					sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
					sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
					sheetObj.CellValue(idx, "ref_seq") = parseInt(ComPriGetMax(sheetObj, "ref_seq")) + 1;
					
					sheetObj.SelectCell(idx, "ref_tit_nm", false);
					break;
					
				case IBCOPYROW: // Row Copy
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var idx = sheetObj.DataCopy();
					sheetObj.CellValue(idx, "ref_seq") = parseInt(ComPriGetMax(sheetObj, "ref_seq")) + 1;
					break;
					
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}
					
					deleteRowCheck(sheetObj, "chk");
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
	
		case IBSAVE: // 저장
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBINSERT: // Row Add
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBCOPYROW: // Row Copy
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "" || sheetObj.SelectRow < 0) {
				return false;
			} else {
				return true;
			}
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
			disableButton("btn_rowadd");
			disableButton("btn_rowcopy");
			disableButton("btn_delete");
			
			sheetObjects[0].Editable = false;
			break;
		case "INIT":
			enableButton("btn_retrieve");
			enableButton("btn_save");
			enableButton("btn_rowadd");
			enableButton("btn_rowcopy");
			enableButton("btn_delete");
			
			sheetObjects[0].Editable = true;
			break;
		case "READONLY":
			enableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_rowadd");
			disableButton("btn_rowcopy");
			disableButton("btn_delete");
			
			sheetObjects[0].Editable = false;
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
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			
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
		
		sheetObjects[0].RemoveAll();
		
		formObject.ref_ctnt.value = "";
		
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
		formObject.ref_ctnt.disabled = !flag;
		
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
	
	/* 개발자 작업 끝 */