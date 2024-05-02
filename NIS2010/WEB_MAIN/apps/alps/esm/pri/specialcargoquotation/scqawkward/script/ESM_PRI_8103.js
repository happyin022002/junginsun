/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_8103.js
 *@FileTitle : Commodity Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.04.28 김재연
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 사용예) ********************************************************************************
 *****************************************************************************************
 var sUrl = "/hanjin/ESM_PRI_8103.do?" + FormQueryString(document.form);
 	 sUrl += "&grp_cd=" + PRI_SP_SCP;   											// (1) 
 	 sUrl += "&commodity_cmd=CG";													// (2)
 	 sUrl += "&prc_cmdt_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "prc_cmdt_tp_cd"); 	// (3)
 	 sUrl += "&multi_yn=N"; 														// (4)

 var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_8103", 600, 320, true);

 ==========================================================================================
 (1) 현재화면에 맞는 상수를 선택한다.
 	 PRI_RG          = 0;  // RFA Guideline
 	 PRI_RP_SCP      = 1;  // RFA Proposal
 	 PRI_SG          = 2;  // S/C Guideline
 	 PRI_SP_SCP      = 3;  // S/C Proposal
 	 PRI_CMPB      	 = 5;  // CMPB Guideline
 	 PRI_SQ      	 = 6;  // SQ Guideline
 	 PRI_RQ      	 = 7;  // RQ Guideline
 
 (2) COMMODITY TYPE을 선택(다중선택)예)"CRG"
	 C:Commodity
	 R:Rep
	 G:Group
 (3) 화면에서 선택한 COMMODITY TYPE에 맞는 화면을 보여주기 위해 사용 
     (데이터가 없을 경우 DEFAULT:(2)번의 첫번째 TYPE에 해당하는 화면)
 
 (4) TRI GRI에서만 사용됨(멀티선택) - 메인화면에서 받음
 ==========================================================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */
	
	/**
	 * @extends
	 * @class ESM_PRI_8103 : ESM_PRI_8103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_8103() {
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
	
	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function processButtonClick() {
		
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/** **************************************************** */
		
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_t1Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_t2Retrieve":
					doActionIBSheet(sheetObject2, formObject, IBSEARCH_ASYNC01);
					break;
				
				case "btn_t3Retrieve":
					doActionIBSheet(sheetObject3, formObject, IBSEARCH_ASYNC02);
					break;
					
				case "btn_t1New":
					ComClearManyObjects(formObject.cmdt_cd, formObject.cmdt_nm);
					sheetObject1.RemoveAll();
					break;
				
				case "btn_t2New":
					ComClearManyObjects(formObject.rep_cmdt_cd, formObject.rep_cmdt_nm);
					sheetObject2.RemoveAll();
					break;
		
				case "btn_Ok":
					if(formObject.multi_yn.value != "Y") {
						returnObject(); // One Row Return
					} else {
						returnMultiObject(); // Multi Row Return
					}
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
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
     * @author 김재연
     * @version 2009.04.29
     */
	function loadPage() {
    	var formObj = document.form; 
		for (i = 0; i < sheetObjects.length; i++) {
	
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			
			if(formObj.multi_yn.value != "Y") {
				sheetObjects[i].InitDataProperty2(0, 1, dtHidden, "width=40; data-align=daCenter");
		    }
			
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		
		pageOnLoadFinish();
	}
	
	/**
     * Page Loding시 최초 상태 설정 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initRadioCheck();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function initRadioCheck(){
		var formObj = document.form;
		var cmd = formObj.commodity_cmd.value;
		var prcCmdtTpCd = formObj.prc_cmdt_tp_cd.value;
		
		if(cmd == "C") {
			formObj.radio_type[0].checked = true;
			formObj.radio_type[1].disabled = true;
			formObj.radio_type[2].disabled = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
		} else if(cmd == "R") {
			formObj.radio_type[1].checked = true;
			formObj.radio_type[0].disabled = true;
			formObj.radio_type[2].disabled = true;
			document.getElementById("radioLayer1").style.display = 'none';
			document.getElementById("radioLayer2").style.display = 'Inline';
			document.getElementById("radioLayer3").style.display = 'none';
		} else if(cmd == "G") {
			formObj.radio_type[2].checked = true;
			formObj.radio_type[0].disabled = true;
			formObj.radio_type[1].disabled = true;
			document.getElementById("radioLayer1").style.display = 'none';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'Inline';
		} else if(cmd == "CR") {
			formObj.radio_type[0].checked = true;
			formObj.radio_type[2].disabled = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
		} else if(cmd == "CG") {
			formObj.radio_type[0].checked = true;
			formObj.radio_type[1].disabled = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
		} else if(cmd == "RG") {
			formObj.radio_type[1].checked = true;
			formObj.radio_type[0].disabled = true;
			document.getElementById("radioLayer1").style.display = 'none';
			document.getElementById("radioLayer2").style.display = 'Inline';
			document.getElementById("radioLayer3").style.display = 'none';
		} else if(cmd == "CRG") {
			formObj.radio_type[0].checked = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
		} else {
			formObj.radio_type[0].checked = true;
			formObj.radio_type[2].disabled = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
		}
		
		if(prcCmdtTpCd == "C") {
			formObj.radio_type[0].checked = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
			if(!ComIsNull(formObj.cmdt_nm.value)) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
		} else if(prcCmdtTpCd == "R") {
			formObj.radio_type[1].checked = true;
			document.getElementById("radioLayer1").style.display = 'none';
			document.getElementById("radioLayer2").style.display = 'Inline';
			document.getElementById("radioLayer3").style.display = 'none';
		} else if(prcCmdtTpCd == "G") {
			formObj.radio_type[2].checked = true;
			document.getElementById("radioLayer1").style.display = 'none';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'Inline';
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
		} else {
			formObj.radio_type[0].checked = true;
			document.getElementById("radioLayer1").style.display = 'Inline';
			document.getElementById("radioLayer2").style.display = 'none';
			document.getElementById("radioLayer3").style.display = 'none';
			if(!ComIsNull(formObj.cmdt_nm.value)) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
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
     * @author 김재연
     * @version 2009.04.29
     */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;
		
		switch (sheetid) {
			// Commodity
			case "sheet1":
				with (sheetObj) {
		
					// 높이 설정
					if(ComIsNull(document.form.commodity_cmd.value)) {
						style.height = 460;
					} else {
						style.height = 140;
					}
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
		
					var HeadTitle = "|Sel.|Seq.|Code|Description|Rep. Code";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30,	daCenter,	false,	"Status");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++, dtSeq, 			50, daCenter, 	false, 	"Seq");
					InitDataProperty(0, cnt++, dtData, 			100,daCenter, 	false, 	"cmdt_cd",  false, "", dfNone, 0, false, false);
					if(ComIsNull(document.form.commodity_cmd.value)) {
						InitDataProperty(0, cnt++, dtData, 			700, 	daLeft, 	false, "cmdt_nm", false, "", dfNone, 0, false, false);
					} else {
						InitDataProperty(0, cnt++, dtData, 			230, 	daLeft, 	false, "cmdt_nm", false, "", dfNone, 0, false, false);
					}
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	"rep_cmdt_cd", false, "", dfNone, 0, false, false);
		
					InitDataValid(0, "cmdt_cd", vtNumericOnly);
					AutoRowHeight = false;
					WaitImageVisible = false;
				}
				break;
			// Rep Commodity
			case "sheet2":
				with (sheetObj) {
		
					// 높이 설정
					if(ComIsNull(document.form.commodity_cmd.value)) {
						style.height = 440;
					} else {
						style.height = 100;
					}
					
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
		
					var HeadTitle = "|Sel.|Seq.|Code|Description";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30,		daCenter, 	false, 	"Status");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40,   	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++, dtSeq, 			50, 	daCenter, 	false, 	"Seq");
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	"rep_cmdt_cd", false, "", dfNone, 0, false, false, 6);
					InitDataProperty(0, cnt++, dtData, 			280, 	daLeft, 	false, 	"rep_cmdt_nm", false, "", dfNone, 0, false, false, 40);
		
					InitDataValid(0, "rep_cmdt_cd", vtNumericOnly);
					AutoRowHeight = false;
					WaitImageVisible = false;
				}
				break;
			// Group Commodity
			case "sheet3":
				with (sheetObj) {
		
					// 높이 설정
					style.height = 100;
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
		
					var HeadTitle = "|Sel.|Seq.|Code|Description";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter,	false,	"Status");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40,   	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++, dtSeq, 			50, 	daCenter, 	false,	"Seq");
					InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, 	false, 	"cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			280, 	daLeft, 	false, 	"nm",	false, "", dfNone, 0, false, false, 40);
					
					AutoRowHeight = false;
					WaitImageVisible = false;
				}
				break;
			}
	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.04.29
	 **/
	function initControl() {
		//** Date 구분자 **/
		DATE_SEPARATOR = "/";
	
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm	('change', 	'grp_cmdt_seq_OnChange', 'grp_cmdt_seq');
		axon_event.addListenerForm  ('click', 	'obj_click', 	form	);  
		axon_event.addListenerFormat('keypress','obj_keypress', form	);
		axon_event.addListener 		('keydown', 'getKeyEnter', 'form');
	}
	
	/**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * grp_cmdt_seq 콤보에서 값을 변경하면 선택한 값에 대한 list를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function grp_cmdt_seq_OnChange(comboObj, code, text) {
		if(ComIsNull(code)) {
			return;
		}
		var formObj = document.form;
		var arrText = text.split("|");		
		formObj.prc_grp_cmdt_desc.value = arrText[1];
		
		formObj.f_cmd.value = SEARCH02;
		sheetObjects[1].DoSearch("ESM_PRI_8103GS.do", FormQueryString(formObj));
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC02);
	}
	
	/**
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * commodity code에 0을 포함해 6자리로 만들어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function obj_deactivate() {
		
		if(event.srcElement.name == "cmdt_cd") {
			if (!ComIsNull(event.srcElement) && ComGetLenByByte(event.srcElement) < 6) {
				event.srcElement.value = ComLpad(event.srcElement, 6, '0');
				return;
			}
		}
	}
	
	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * radi type 에 맞는 화면을 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function obj_click(){
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		var formObj = document.form;
		
		if (event.srcElement.name == "radio_type") {
			if (event.srcElement.value == "C") {
				document.getElementById("radioLayer1").style.display = 'Inline';
				document.getElementById("radioLayer2").style.display = 'none';
				document.getElementById("radioLayer3").style.display = 'none';
				
				ComClearManyObjects(formObj.rep_cmdt_cd, formObj.rep_cmdt_nm, formObj.prc_grp_cmdt_desc);
				comboObjects[0].Code = -1;
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			} else if(event.srcElement.value == "R") {
				document.getElementById("radioLayer1").style.display = 'none';
				document.getElementById("radioLayer2").style.display = 'Inline';
				document.getElementById("radioLayer3").style.display = 'none';
				
				ComClearManyObjects(formObj.cmdt_cd, formObj.cmdt_nm, formObj.prc_grp_cmdt_desc);
				comboObjects[0].Code = -1;
				sheetObjects[0].RemoveAll();
				sheetObjects[2].RemoveAll();
			}  else if (event.srcElement.value == "G") {
				document.getElementById("radioLayer1").style.display = 'none';
				document.getElementById("radioLayer2").style.display = 'none';
				document.getElementById("radioLayer3").style.display = 'Inline';
				
				ComClearManyObjects(formObj.cmdt_cd, formObj.cmdt_nm, formObj.rep_cmdt_cd, formObj.rep_cmdt_nm);
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
			}
		}
	}
	
    /**
     * HTML태그(Object)의 onKeyDown 이벤트에서 이 함수를 호출할수 있으며, Enter키를 눌렀을때 자동화 기능을 처리한다. <br>
     * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
     * sFlag = 설정안한경우      : sFlag="Search"의 경우와 동일하게 처리한다.<br>
     * sFlag = "Search"          : Enter키가 누르면 조회버튼(btn_Retrieve 또는 btn_retrieve)이 눌린것처럼 처리한다.OnKeyDown에서 호출할것!<br>
     * sFlag = "NextFocus"       : Enter키를 누르면 Tab키를 누른것 처럼 다음 입력필드로 포커스를 이동한다.OnKeyDown에서 호출할것!<br>
     * sFlag = "LengthNextFocus" : 입력필드의 maxlength길이만큼 모두 입력되면 자동으로 포커스를 다음으로 이동하고, Enter키를 누르면 길이에 관계없이 Tab을 누른것처럼 옆으로 이동한다. OnKeyUp에서 호출할 것!<br>
     * sFlag = Function명문자열  : 특정Function명 문자열을 인자로 받아서 Enter키를 누르면 해당 함수를 호출한다. OnKeyDown에서 호출할 것!<br>
     * sFlag = "LengthNextFocus"는 OnKeyUp이벤트에서 호출하여야 하고, 나머지는 모두 OnKeyDown이벤트에서 호출해야 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;form name="form" onKeyDown="ComKeyEnter()"&gt; 					//조회조건Form에서 주로 사용
     *     &lt;form name="form" onKeyDown="ComKeyEnter('NextFocus')"&gt;		//저장Form에서 주로 사용
     *     &lt;form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')"&gt;	//저장Form에서 주로 사용
     * </pre>
     * @param {string} sFlag 선택,키처리 구분, default="Search"
     * @see #ComSetNextFocus
     */
    function getKeyEnter(sFlag)
    {
    	var formObj = document.form;
     	var radioType = ComGetObjValue(formObj.radio_type);
      	try {
      		var keyValue = null;
          	if(event == undefined || event == null) {
          		keyValue = 13;
          	} else {
          		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
          	}
          	
          	if (keyValue != 13) return;
      		var obj = null;
      		if(radioType == "C") {
      			obj = document.getElementById("btn_t1Retrieve");
      		} else if(radioType == "R") {
      			obj = document.getElementById("btn_t2Retrieve");
      		} else if(radioType == "G") { 
      			obj = document.getElementById("btn_t3Retrieve");
      		}
      		if (obj) obj.fireEvent("onclick");
         } catch(err) { ComFuncErrMsg(err.message); }
    }
     
	/**
     * OnKeyPress시 호출되는 function <br>
     * HTML Control의 onkeypress 이벤트에서 해당 key만 입력되게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function obj_keypress(){
		switch (event.srcElement.dataformat) {
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
				
			case "eng":
		        //영문만입력하기
	            ComKeyOnlyAlphabet('upper');
	            break;
	            
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		}
	}
	
    /**
     * Sheet1 OnDbClick 이벤트 발생시 호출되는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
	function sheet1_OnDblClick(sheetObj, Row, Col) {
	    try{
	    	var formObj = document.form;
			var Row = sheetObj.SelectRow;
			var multiYn = formObj.multi_yn.value; 
		    var rtnArray = new Array();
		  	var rtnObject = new Object(); 
		  	
		  	rtnObject.cd = sheetObjects[0].CellValue(Row, "cmdt_cd");
			rtnObject.nm = sheetObjects[0].CellValue(Row, "cmdt_nm");
			rtnObject.tp = "C";
			
		  	if(multiYn != "Y") {
				window.returnValue = rtnObject;
			} else {
				rtnArray[0] = rtnObject;
				window.returnValue = rtnArray;
			}
		    self.close();
	    }catch(e){}
	}
	
	/**
     * Sheet2 OnDbClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
	function sheet2_OnDblClick(sheetObj, Row, Col) {
	    try{
	    	var formObj = document.form;
			var Row = sheetObj.SelectRow;
			var multiYn = formObj.multi_yn.value; 
		    var rtnArray = new Array();
		  	var rtnObject = new Object(); 
		  	
		  	rtnObject.cd = sheetObjects[1].CellValue(Row, "rep_cmdt_cd");
			rtnObject.nm = sheetObjects[1].CellValue(Row, "rep_cmdt_nm");
			rtnObject.tp = "R";
			
			if(multiYn != "Y") {
				window.returnValue = rtnObject;
			} else {
				rtnArray[0] = rtnObject;
				window.returnValue = rtnArray;
			}
	    }catch(e){}
	}
		
	/**
     * Sheet3 OnDbClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
	function sheet3_OnDblClick(sheetObj, Row, Col) {
	    try{
	    	var formObj = document.form;
			var Row = sheetObj.SelectRow;
			var multiYn = formObj.multi_yn.value; 
		    var rtnArray = new Array();
		  	var rtnObject = new Object(); 
	    	
	    	rtnObject.cd = comboObjects[0].Text;
			rtnObject.nm = formObj.prc_grp_cmdt_desc.value;
			rtnObject.tp = "G";
			
			if(multiYn != "Y") {
				window.returnValue = rtnObject;
			} else {
				rtnArray[0] = rtnObject;
				window.returnValue = rtnArray;
			}
	    }catch(e){}
	}
	
    /**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
		initRadioCheck(); //Radio Button default
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
     * @author 김재연
     * @version 2009.04.29
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
			case IBSEARCH: // Commodity
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_PRI_8103GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;
				
//			case IBSEARCH_ASYNC01: // Rep Commodity
//				ComOpenWait(true);
//				if (!validateForm(sheetObj, formObj, sAction)) {
//					ComOpenWait(false);
//					return false;
//				}
//			
//				formObj.f_cmd.value = SEARCH04;
//				sheetObj.DoSearch("ESM_PRI_8103GS.do", FormQueryString(formObj));
//				ComOpenWait(false);
//				break;
//			
//			case IBSEARCH_ASYNC02: // Group Commodity
//				ComOpenWait(true);
//				if (!validateForm(sheetObj, formObj, sAction)) {
//					ComOpenWait(false);
//					return false;
//				}
//			
//				formObj.f_cmd.value = SEARCH02;
//				sheetObj.DoSearch("ESM_PRI_8103GS.do", FormQueryString(formObj));
//				ComOpenWait(false);
// 				break;
//			
//			case IBSEARCH_ASYNC10: // 조회
//				formObj.f_cmd.value = SEARCH03;
//				var sXml = sheetObj.GetSearchXml("ESM_PRI_8103GS.do", FormQueryString(formObj));
//				ComPriXml2ComboItem(sXml, formObj.grp_cmdt_seq, "seq", "cd|nm");
//				break;
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
     * @author 김재연
     * @version 2009.04.29
     */
	function validateForm(sheetObj, formObj, sAction) {
		 
		 switch (sAction) {
		 	case IBSEARCH: //Commodity 선택
//				if (ComIsNull(formObj.cmdt_cd) && ComIsNull(formObj.cmdt_nm)) {
//					ComShowCodeMessage("PRI04005","Code","Description");
//					ComSetFocus(formObj.cmdt_cd);
//					return false;
//				}
//				
//				if (!ComIsNull(formObj.cmdt_cd) && ComGetLenByByte(formObj.cmdt_cd) < 2) {
//					ComShowCodeMessage("PRI04004","Code","2","6");
//					ComSetFocus(formObj.cmdt_cd);
//					return false;
//				}
//				
//				if (!ComIsNull(formObj.cmdt_nm) && ComGetLenByByte(formObj.cmdt_nm) < 2) {
//					ComShowCodeMessage("PRI04004","Description","2","40");
//					ComSetFocus(formObj.cmdt_nm);
//					return false;
//				}
				return true;
				break;
				
//		 	case IBSEARCH_ASYNC01: //Rep Commodity 선택
//			 	if (ComIsNull(formObj.rep_cmdt_cd) && ComIsNull(formObj.rep_cmdt_nm)) {
//			 		ComShowCodeMessage("PRI04005","Code","Description");
//			 		ComSetFocus(formObj.rep_cmdt_cd);
//					return false;
//				}
//				
//				if (!ComIsNull(formObj.rep_cmdt_cd) && ComGetLenByByte(formObj.rep_cmdt_cd) < 2) {
//					ComShowCodeMessage("PRI04004","Code","2","6");
//					ComSetFocus(formObj.rep_cmdt_cd);
//					return false;
//				}
//				
//				if (!ComIsNull(formObj.rep_cmdt_nm) && ComGetLenByByte(formObj.rep_cmdt_nm) < 2) {
//					ComShowCodeMessage("PRI04004","Description","2","40");
//					ComSetFocus(formObj.rep_cmdt_nm);
//					return false;
//				}
//		 		return true;
//		 		break;
//		 	
//			case IBSEARCH_ASYNC02: //Group Commodity 선택	
//				if (ComIsNull(ComGetObjValue(formObj.grp_cmdt_seq))) {
//					ComShowCodeMessage("PRI04007","Code");
//					ComSetFocus(formObj.grp_cmdt_seq);
//					return false;
//				}
//				return true;
//				break;
		}
		return true;
	}
	
    /**
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function initCombo(comboObj, comboNo) {
    	 
	    switch(comboObj.id) {
	    
	        case "grp_cmdt_seq":
	            var i=0;
	            with(comboObj) {
	            	//BackColor = "cyan";
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;
	    }
	}
	
    /**
     * OK button Click 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    buttonOkClick(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */
	function buttonOkClick(sheetObj) {
		var formObj = document.form;
		var Row = sheetObj.SelectRow;
		var radioType = ComGetObjValue(formObj.radio_type);
		var multiYn = formObj.multi_yn.value;
	    var rtnArray = new Array();
	  	var rtnObject = new Object(); 
	  	
		if(Row < 1) {
			ComShowCodeMessage("PRI04006");
			return false;
		}
		
		if(radioType == "C") {
			rtnObject.cd = sheetObjects[0].CellValue(Row, "cmdt_cd");
			rtnObject.nm = sheetObjects[0].CellValue(Row, "cmdt_nm");
			rtnObject.tp = "C";
		} else if(radioType == "R") {
			rtnObject.cd = sheetObjects[1].CellValue(Row, "rep_cmdt_cd");
			rtnObject.nm = sheetObjects[1].CellValue(Row, "rep_cmdt_nm");
			rtnObject.tp = "R";
		} else if(radioType == "G") {
			rtnObject.cd = comboObjects[0].Text;
			rtnObject.nm = formObj.prc_grp_cmdt_desc.value;
			rtnObject.tp = "G";
		}
		
		window.returnValue = rtnObject;
	    self.close();
	}
	
    /**
     * 단일 선택 항목을 Return 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    returnObject()
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
	function returnObject() {
		var formObj = document.form;
		var radioType = ComGetObjValue(formObj.radio_type);
		var rtnArray = new Array();
	  	var rtnObject = new Object();
	  	
	  	if(radioType == "C") {
	  		var Row = sheetObjects[0].SelectRow;
	  		if(Row < 1) {
	  			ComShowCodeMessage("PRI04006");
				return false;
			}
			rtnObject.cd = sheetObjects[0].CellValue(Row, "cmdt_cd");
			rtnObject.nm = sheetObjects[0].CellValue(Row, "cmdt_nm");
			rtnObject.tp = "C";
		} else if(radioType == "R") {
			var Row = sheetObjects[1].SelectRow;
	  		if(Row < 1) {
	  			ComShowCodeMessage("PRI04006");
				return false;
			}
			rtnObject.cd = sheetObjects[1].CellValue(Row, "rep_cmdt_cd");
			rtnObject.nm = sheetObjects[1].CellValue(Row, "rep_cmdt_nm");
			rtnObject.tp = "R";
		} else if(radioType == "G") {
	  		if(comboObjects[0].Code == "") {
	  			ComShowCodeMessage("PRI04006");
				return false;
			}
			rtnObject.cd = comboObjects[0].Text;
			rtnObject.nm = formObj.prc_grp_cmdt_desc.value;
			rtnObject.tp = "G";
		}
	  	window.returnValue = rtnObject;
	    self.close();
	}
	
	/**
     * 다중 선택 항목을 Return 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    returnObject()
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
	function returnMultiObject() {
		var formObj = document.form;
		var radioType = ComGetObjValue(formObj.radio_type);
		var rtnArray = new Array();
	  	var arrayCnt = 0;
	  	
	  	if(radioType == "C") { //Commodity
	  		var Row = sheetObjects[0].SelectRow;
	  		if(Row < 1) { //선택한 Row가 없을경우
	  			ComShowCodeMessage("PRI04006");
				return false;
			}
	  		
	  		// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[0], "chk");
			if(chkArr.length == 0){
				sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"chk")= "1";
			}
			chkArr = ComPriSheetCheckedRows(sheetObjects[0], "chk");
			
			for(var i=0; i<chkArr.length; i++) {
				var rtnObject = new Object();
				rtnObject.cd = sheetObjects[0].CellValue(chkArr[i], "cmdt_cd");
			   	rtnObject.nm = sheetObjects[0].CellValue(chkArr[i], "cmdt_nm");
			   	rtnObject.tp = "C";
								
			   	rtnArray[arrayCnt]= rtnObject; //Object List 형태로 Return
				arrayCnt++;
			}
	  	} else if(radioType == "R") {
	  		var Row = sheetObjects[1].SelectRow;
	  		if(Row < 1) {
	  			ComShowCodeMessage("PRI04006");
				return false;
			}
	  		
	  		// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[1], "chk");
			if(chkArr.length == 0){
				sheetObjects[1].CellValue2(sheetObjects[1].SelectRow,"chk")= "1";
			}
			
			chkArr = ComPriSheetCheckedRows(sheetObjects[1], "chk");
			
			for(var i=0; i<chkArr.length; i++) {
				var rtnObject = new Object();
				rtnObject.cd = sheetObjects[1].CellValue(chkArr[i], "rep_cmdt_cd");
			   	rtnObject.nm = sheetObjects[1].CellValue(chkArr[i], "rep_cmdt_nm");
			   	rtnObject.tp = "C";
								
			   	rtnArray[arrayCnt]= rtnObject; //Object List 형태로 Return
				arrayCnt++;
			}
	  	} else if(radioType == "G") {
	  		if(comboObjects[0].Code == "") {
	  			ComShowCodeMessage("PRI04006");
				return false;
			}
	  		var rtnObject = new Object();
			rtnObject.cd = comboObjects[0].Text;
			rtnObject.nm = formObj.prc_grp_cmdt_desc.value;
			rtnObject.tp = "G";
			rtnArray[arrayCnt] = rtnObject; //Object List 형태로 Return
	  	}
	  	window.returnValue = rtnArray;
	    self.close();
	}
	/* 개발자 작업 끝 */