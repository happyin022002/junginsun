/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6015_02.js
*@FileTitle : RFA Quotation Commodity Group Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
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
     * @class ESM_PRI_6015_02 : ESM_PRI_6015_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6015_02() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

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
	  * @author 이승준
	  * @version 2009.04.17
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
     * @author 이승준
     * @version 2009.04.17
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
     * @author 이승준
     * @version 2009.04.17
     */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var iWidth = window.document.body.clientWidth;
        
        if(iWidth > 1024) {
        	sheetColResize();
        }
		
	}
	
	
	/**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnLoadFinish(sheetObj) {
	   	sheetObj.WaitImageVisible = false; 
	   	doActionIBSheet(sheetObjects[1], document.form, IBCLEAR); 
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
     * @author 이승준
     * @version 2009.04.17
     */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 265;
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
					InitColumnInfo(8, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Seq.|qttn_no|qttn_ver_no|Group Commodity Seq.|Group Code|Description|src_info_cd";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_cmdt_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_grp_cmdt_cd", false, "", dfEngUpKey, 0, true, true, 4, false);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "prc_grp_cmdt_desc", false, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "src_info_cd", false, "", dfNone, 0, false, false);
					
					InitDataValid(0, "prc_grp_cmdt_cd", vtEngUpOnly);
					ShowButtonImage = 2;
					WaitImageVisible = false;
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 265;
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
		
					var HeadTitle = "|Seq.|qttn_no|qttn_ver_no|Group Commodity Seq.|Group Commodity Detail Seq.|CMDT Type|CMDT Code|Description|src_info_cd|Source";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_cmdt_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_cmdt_dtl_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "prc_cmdt_tp_cd", false, "", dfEngUpKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "prc_cmdt_def_cd", false, "", dfEngKey, 0, true, true, 6, false);
					InitDataProperty(0, cnt++, dtData,		170,	daLeft,	  true,	  "prc_cmdt_def_nm",	false,	"",	dfNone,	0, false,  false);	
					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "src_info_nm", false, "", dfEngKey, 0, false, false);
					
					InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
					InitDataValid(0, "prc_cmdt_def_nm", vtEngUpOnly);
					ShowButtonImage = 2;
					WaitImageVisible = false;
//					MessageText("UserMsg17") = " " + ComGetMsg("PRI00318");
		
				}
				break;

			case "sheet3":
				with (sheetObj) {
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "status";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					WaitImageVisible = false;
					Visible = false;
				}
				break;
			
		}
	}
	
	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
	
	var isFiredNested = false;
	var supressConfirm = false;
	 /**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 선택한 로우에 대한 디테일 정보를 조회한다. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} appendRow
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			
			formObj.grp_cmdt_seq.value = sheetM.CellValue(adjNewRow, "grp_cmdt_seq");
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
     * @author 이승준
     * @version 2009.04.17
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		
			case IBCLEAR: // 화면 로딩시 
				var sXml = "";
				
				//공통 cmdt type
				sheetObj.InitDataCombo(0,"prc_cmdt_tp_cd", COMODITY_TYPE3[1], COMODITY_TYPE3[0], "", "R", 0); 			
	//			formObj.f_cmd.value = SEARCH19;
	//			formObj.cd.value="CD01703";
	//			sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	//			setIBCombo(sheetObj,sXml,"prc_cmdt_tp_cd",false,0);
				
				break;
		
			case IBSEARCH: // 조회
				if (validateForm(sheetObj,document.form,sAction)) {
					try {
						for (var i = 0; i < sheetObjects.length; i++) {
		                	sheetObjects[i].WaitImageVisible = false;
		                	sheetObjects[i].RemoveAll();
		                }
						ComOpenWait(true);
						
						formObj.f_cmd.value = SEARCH01;
						sheetObj.DoSearch("ESM_PRI_6015_02GS.do" , FormQueryString(formObj));
						ComOpenWait(false);

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
				break;
				
			case IBSEARCHAPPEND: // 조회
				if (validateForm(sheetObj,document.form,sAction)) {
					try {
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_6015_02GS.do" , FormQueryString(formObj));
						ComOpenWait(false);

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
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		var qttn_sts_cd  = parent.document.form.qttn_sts_nm_read.value;
		
		switch (sAction) {
		case IBSEARCH: // 조회
			if (ComIsEmpty(qttn_sts_cd)) {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (ComIsEmpty(qttn_sts_cd)) {
				return false;
			} else {
				return true;
			}
			break;
	
		
		}
	}
	
	/**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function toggleButtons(mode) {
			
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_retrieve");
			break;
		case "INIT":
			if(validateForm(sheetObjects[0],document.form,IBSEARCH)) {
				ComBtnEnable("btn_retrieve");
			} else {
				ComBtnDisable("btn_retrieve");
			}	
			break;
		case "READONLY":
			if(validateForm(sheetObjects[0],document.form,IBSEARCH)) {
				ComBtnEnable("btn_retrieve");
			} else {
				ComBtnDisable("btn_retrieve");
			}	
			break;
		}
	}
	
    /**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 활성화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr)
     * </pre>
     * @param {String} qttn_no   	
     * @param {String} qttn_ver_no 
     * @param {String} svc_scp_cd 
     * @param {String} eff_dt 
     * @param {String} exp_dt 
     * @param {boolean} isAproUsr  권한이 있는지 여부
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr) {
		var formObject = document.form;

		if (formObject.qttn_no.value != qttn_no || formObject.qttn_ver_no.value != qttn_ver_no) {
			formObject.qttn_no.value = qttn_no;
			formObject.qttn_ver_no.value = qttn_ver_no;
			formObject.svc_scp_cd.value = svc_scp_cd;
			formObject.eff_dt.value = eff_dt;
			formObject.exp_dt.value = exp_dt;
			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			
			if (enableFlag && isAproUsr) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}
		}
	}
	
	/**
    * 메인화면에서 호출한다.<br>
    * 메인화면에서 탭화면을 초기화시킨다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     tabClearSheet()
    * </pre>
    * @param 없음 
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function tabClearSheet() {
		var formObject = document.form;
		
//		formObject.qttn_no.value = "";
//		formObject.qttn_ver_no.value = "";
//		formObject.grp_loc_seq.value = "";
//		formObject.svc_scp_cd.value = "";
		
		formObject.reset();
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	/**
    * 메인화면에서 호출한다.<br>
    * 메인화면에서 탭화면을 입력 조회 또는 조회만 할 수 있도록 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     tabEnableSheet(flag)
    * </pre>
    * @param {boolean} flag	true; 입력,조회 false : 조회 
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function tabEnableSheet(flag) {
		
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
	
	/**
 	 * window가 resize 시 sheet col width를 재조정한다.<br>
 	 * <br><b>Example :</b>
     * <pre>
     *    onResize="cellWidthResize();"
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheetColResize() {
 		
 		var sheetObj2 = sheetObjects[1];
 		sheetObj2.FitColWidth("0|8|0|0|0|0|20|17|31|0|18");
  		
 	}

	/* 개발자 작업  끝 */