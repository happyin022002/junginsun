/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2018_01.js
 *@FileTitle : RFA Guideline Inquiry - Location Group
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.23
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.10.23 최성민
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
	function ESM_PRI_2018_01() {
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
     * @author 최성민
     * @version 2009.10.28
     */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;		
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
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
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		   
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        
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
					style.height = 360;
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
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Ori/Dst|Group\nCode|Description";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 70, daLeft, false, "org_dest_tp_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_grp_loc_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "prc_grp_loc_desc", false, "", dfEngKey, 0, false, false, 50);
					
					ShowButtonImage = 2;
					
					MessageText("UserMsg17") = " " + ComGetMsg("PRI00317");
                    WaitImageVisible = false;
		
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 360;
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
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Location\nCode|Description|Subcontinent Code|Subcontinent";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_dtl_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100, daCenter, false, "loc_cd", false, "", dfEngUpKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "loc_nm", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "sconti_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sconti_nm", false, "", dfEngKey, 0, false, false);
					
					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					ShowButtonImage = 2;
					
					MessageText("UserMsg17") = " " + ComGetMsg("PRI00318");
                    WaitImageVisible = false;
		
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
		
					var HeadTitle = "Seq.|Ori/Dst|Group Code|Description|Location Code|Description|Subcontinent Code|Subcontinent";
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
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "org_dest_tp_desc", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_grp_loc_cd", false, "", dfEngUpKey, 0, true, true, 4, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "prc_grp_loc_desc", false, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_cd", false, "", dfEngUpKey, 0, true, true, 5, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "loc_nm", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "sconti_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sconti_nm", false, "", dfEngKey, 0, false, false);
		
					Visible = false;
                    WaitImageVisible = false;
				}
				break;
				
			case "sheet4":  //메세지 처리용
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
		
					var HeadTitle = "|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Location\nCode|Description|Subcontinent Code|Subcontinent";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_loc_dtl_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "loc_cd", false, "", dfEngUpKey, 0, true, true, 5, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "loc_nm", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "sconti_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sconti_nm", false, "", dfEngKey, 0, false, false);
					
					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					
					ShowButtonImage = 2;
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
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
      * @return 없음
      * @author 최성민
      * @version 2009.05.19
      */		
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
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
		
		if (OldRow != NewRow) {
			formObj.grp_loc_seq.value = sheetM.CellValue(NewRow, "grp_loc_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
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
    * @author 최성민
    * @version 2009.05.22
    */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
		sheetObj.ShowDebugMsg = false;
			switch (sAction) {
				case IBCLEAR: // 화면 로딩시 
	  				ComOpenWait(true);
					formObj.f_cmd.value = SEARCH19;
					formObj.cd.value = "CD02166";
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
					setIBCombo(sheetObj, sXml, "org_dest_tp_cd", true, 0);
					break;
	
				case IBSEARCH: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						
						formObj.f_cmd.value = SEARCH01;
						sheetObj.DoSearch("ESM_PRI_2018_01GS.do" , FormQueryString(formObj));
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
					
				case IBSEARCHAPPEND: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_2018_01GS.do" , FormQueryString(formObj));
					}
					break;
			
				case IBDOWNEXCEL:
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value = SEARCH03;
						sheetObj.DoSearch("ESM_PRI_2018_01GS.do" , FormQueryString(formObj));
						sheetObj.Down2Excel();
					} else {
						ComShowCodeMessage('PRI08001');
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
	
		case IBDOWNEXCEL: // 엑셀저장
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;			
		}
	}
    /**
    * 버튼 컨트롤하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     toggleButtons(mode)
    * </pre>
    * @param {string} mode 세팅값
    * @return 없음
    * @author 최성민
    * @version 2009.05.22
    */	 
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_retrieve");
			disableButton("btn_downexcel");
			break;
		case "INIT":
			enableButton("btn_retrieve");
			enableButton("btn_downexcel");
			break;
		case "READONLY":
			enableButton("btn_retrieve");
			enableButton("btn_downexcel");
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
    * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
    * @param {string} sPropStsCd 필수 pro_sts_cd 값
    * @param {string} sEffDt 필수 eff_dt 값
    * @param {string} sExpDt 필수 exp_dt 값
    * @param {string} sPreExpDt 필수 pre_exp_dt 값
    * @return 없음
    * @author 최성민
    * @version 2009.05.21
    */ 	
	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;

			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			
			if (enableFlag) {
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
		formObject.grp_loc_seq.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
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
	
	/* 개발자 작업 끝 */