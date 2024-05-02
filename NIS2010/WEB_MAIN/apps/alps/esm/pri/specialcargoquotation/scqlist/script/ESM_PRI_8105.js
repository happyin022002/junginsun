/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_8105.js
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.04.29 김재연
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 사용예) ********************************************************************************
 *****************************************************************************************
 var sUrl = "/hanjin/ESM_PRI_8105.do?" + FormQueryString(document.form);
 	 sUrl += "&is_popup=true";			   											// (1) 
 	 sUrl += "&nmd_cust_flg=Y";														// (2)
 	 sUrl += "&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "loc_tp_cd"); 	// (3)
 	 sUrl += "&org_dest_cd=O"; 														// (4)
 	 sUrl += "&multi_yn=N"; 														// (5)

 var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 280, true);
 if (rtnVal != null){
	sheetObj.CellValue2(Row, "loc_cd") = rtnVal.cd;
	sheetObj.CellValue2(Row, "loc_nm") = rtnVal.nm;
	sheetObj.CellValue2(Row, "loc_tp") = rtnVal.tp;
 )
 ==========================================================================================
 (1) 현재화면에 맞는 상수를 선택한다.
 	 PRI_RG          = 0;  // RFA Guideline
 	 PRI_RP_SCP      = 1;  // RFA Proposal
 	 PRI_SG          = 2;  // S/C Guideline
 	 PRI_SP_SCP      = 3;  // S/C Proposal
 	 PRI_CMPB      	 = 5;  // CMPB Guideline
 	 PRI_SQ      	 = 6;  // SQ Guideline
 	 PRI_RQ      	 = 7;  // RQ Guideline
 
 (2) LOCATION TYPE을 선택(다중선택)예)"LGTCR"
	 L:Location
	 G:Group Location
	 T:State
	 C:Country
	 R:Region
 (3) 화면에서 선택한 LOCATION TYPE에 맞는 화면을 보여주기 위해 사용 
     (데이터가 없을 경우 DEFAULT:(2)번의 첫번째 TYPE에 해당하는 화면)
 
 (4) RFA에서 사용(LOCATION CODE) - 메인화면에서 받음
 (5) TRI GRI에서만 사용됨(멀티선택) - 메인화면에서 받음
 ==========================================================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */
	
	/**
	 * @extends
	 * @class ESM_PRI_8105 : ESM_PRI_8105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_8105() {
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
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
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
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_ok":
					buttonOkClick(sheetObject1);
					break;
		
				case "btn_close":
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

		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		pageOnLoadFinish();
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
		var sheetID = sheetObj.id;
		
		switch (sheetID) {
		 	case "sheet1":
				with (sheetObj) {
					// 높이 설정
					if(document.form.is_popup.value == "true") {
						style.height = 260;
					} else {
						style.height = 440;
					}
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
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "Customer Code|Customer Name|Address|Type|S.OFC|S.REP|Segment|||";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, 	true, 	"cust_cd", 				false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		230, 	daLeft, 	true, 	"cust_lgl_eng_nm", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		230, 	daLeft, 	true, 	"bzet_addr", 			false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		50,		daCenter, 	true, 	"rvis_cntr_cust_tp_nm", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true,	"ofc_cd", 				false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true, 	"srep_cd", 				false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true, 	"vbs_clss_nm", 			false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, 	"loc_cd", 				false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, 	"cust_cnt_cd", 			false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, 	"cust_seq", 			false, "", dfNone, 0, false, false);
					
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
		axon_event.addListenerForm  ('blur', 	'obj_blur',  	form	); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('keypress','obj_keypress', form	); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		axon_event.addListener		('keydown', 'ComKeyEnter', 'form'	);
	}
	
	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 * 
	 * <br><b>Example :</b>
     * <pre>
     *     obj_blur();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.04.29
	 **/ 
	function obj_blur(){
		if(event.srcElement.name == "cust_seq") {
			if(!ComIsNull(event.srcElement) && ComGetLenByByte(event.srcElement) < 6) {
				event.srcElement.value = ComLpad(event.srcElement, 6, '0');
				return;
			}
		} 
	}
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	 * 
	 * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.04.29
	 **/ 
	function obj_keypress(){
		
		switch(event.srcElement.dataformat) {
		
			case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
				
			case "eng":
		        //영문만입력하기
	            ComKeyOnlyAlphabet("uppernum");
	            break;
	            
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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
     * @author 김재연
     * @version 2009.04.29
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 조회
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value = SEARCH01;
				//if(formObj.is_popup.value == "true") {
					sheetObj.DoSearch("ESM_PRI_8105GS.do", FormQueryString(formObj));
				//} else {
					//sheetObj.DoSearch("ESM_PRI_4030GS.do", FormQueryString(formObj));
				//}
				ComOpenWait(false);
				break;
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
		with (formObj) {
			if(ComIsNull(formObj.cust_cnt_cd) && ComIsNull(formObj.cust_seq) &&ComIsNull(formObj.cust_lgl_eng_nm)) {
				ComShowCodeMessage("PRI04005","Customer Code","Customer Name");
				return false;
			}
			
			if(!ComIsNull(formObj.cust_cnt_cd) && ComGetLenByByte(formObj.cust_cnt_cd) < 2) {
				ComShowCodeMessage("PRI04003","Country code","2");
				return false;
			}else{
				if (ComIsNull(formObj.cust_seq) && ComGetLenByByte(formObj.cust_lgl_eng_nm) < 3){
					ComShowCodeMessage("PRI04004","Customer Name","3","100");
					return false;
				}
			}
			
//			if(ComIsNull(formObj.cust_cnt_cd) && ComGetLenByByte(formObj.cust_lgl_eng_nm) < 5) {
//				ComShowCodeMessage("PRI04004","Customer Name","5","100");
//				return false;
//			}
		}
	
		return true;
	}
	
	/**
     * OnDbClick 이벤트 발생시 호출되는 function <br>
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
	    	buttonOkClick(sheetObj)
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
		if(!ComIsNull(document.form.cust_cnt_cd.value) || !ComIsNull(document.form.cust_seq.value) || !ComIsNull(document.form.cust_lgl_eng_nm.value)) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
		var rtnObject = new Object(); 
		var Row = sheetObj.SelectRow;
	
		if(Row < 1) {
			ComShowCodeMessage("PRI04006");
			return;
		}
		
		rtnObject.custCd 	= sheetObj.CellValue(Row, "cust_cd");				//Customer Number
		rtnObject.custNm 	= sheetObj.CellValue(Row, "cust_lgl_eng_nm");		//Customer English Name
		rtnObject.custTpCd 	= sheetObj.CellValue(Row, "rvis_cntr_cust_tp_cd");	
		rtnObject.LocCd 	= sheetObj.CellValue(Row, "loc_cd");
		rtnObject.Addr 		= sheetObj.CellValue(Row, "bzet_addr");
		rtnObject.custCntCd = sheetObj.CellValue(Row, "cust_cnt_cd");
		rtnObject.custSeq 	= sheetObj.CellValue(Row, "cust_seq");
		
		window.returnValue = rtnObject;
	    self.close();
	}
	
/* 개발자 작업 끝 */