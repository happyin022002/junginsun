/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2018.js
 *@FileTitle : RFA Guideline Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
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
	function ESM_PRI_2018() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.setComboObject = setComboObject;
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
	
	var tabLoad = new Array();
	tabLoad[0] = 0;
	tabLoad[1] = 0;
	
	var subDataCnt = 0;
	var isAproUsr = false;
	
	var selectedGlineSeq = null;
	
	var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";
	var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif";
	
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
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				if (tabObjects[0].SelectedIndex == 0) {
					tab1_OnChange(tabObjects[0], 0);
				} else {
					tabObjects[0].SelectedIndex = 0;
				}
				break;
	
			case "btn_new":
				doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
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
	 * IBTab Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setTabObject(tab_obj);
	 * </pre>
	 * @param {ibtab} tab_obj 필수 IBTab Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
	 * IBCombo Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setComboObject(combo_obj);
	 * </pre>
	 * @param {ibcombo} combo_obj 필수 IBCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function loadPage() {
		for (var i = 0; i < sheetObjects.length; i++) {
			initSheet(sheetObjects[i], i + 1);
		}
	
		for (var k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
	}
	
	/**
	 * OnKeyPress event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_keypress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/**
	 * OnBeforeActivate   event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_activate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_activate() {
		var formObject = document.form;
	    var srcName = event.srcElement.getAttribute("name");
	    
	    if (srcName == "exp_dt" && formObject.exp_dt.value != "" && formObject.eff_dt_hidden.value != "") {
	    	var effDt = formObject.eff_dt_hidden.value;
	    	var expDt = formObject.exp_dt.value;
	    	
	    	formObject.eff_dt.value = formObject.eff_dt_hidden.value;
    		comboObjects[1].SetText(selectedGlineSeq, 0, effDt); 
			comboObjects[1].SetText(selectedGlineSeq, 1, expDt);
			comboObjects[1].SetText(selectedGlineSeq, 2, effDt);
			
			formObject.eff_dt_hidden.value = "";
			
	    	ComClearSeparator (event.srcElement);
	    } else if (srcName == "scope_year") {
	    	ComClearSeparator (event.srcElement);
	    }
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
	function obj_deactivate() {
		var formObject = document.form;
	    var srcName = event.srcElement.getAttribute("name");
	    
	    var svcScpCd = formObject.svc_scp_cd.value
	    
	    ComChkObjValid(event.srcElement);
	    
	    if (srcName == "scope_year") {
			selectedGlineSeq = null;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
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
			
			case IBSEARCH_ASYNC20: // 화면 로딩시 Tab Count 조회
				formObj.f_cmd.value = SEARCH10;
				subDataCnt = 0;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2018GS.do", FormQueryString(formObj));
				var arrTabCnt = ComPriXml2Array(sXml, "grp_loc_cnt|grp_cmdt_cnt|arb_cnt|rate_cnt");
				if (arrTabCnt != null && arrTabCnt.length > 0) {
					for (var i = 0; i < arrTabCnt[0].length; i++) {
						subDataCnt += parseInt(arrTabCnt[0][i]);
						if (parseInt(arrTabCnt[0][i]) > 0) {
							tabObjects[0].ImageUrl(i) = ICON_URL_EXIST;
						} else {
							tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
						}
					}
				}
				break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회
				comboObjects[0].RemoveAll();
				
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
				break;
				
			case IBSEARCH_ASYNC11: // Service Scope 선택시, Duration조회
				formObj.f_cmd.value = COMMAND15;
				var sParam = FormQueryString(formObj) + "&prc_ctrt_tp_cd=R&svc_scp_cd=" + comboObjects[0].Code + "&usr_id=" + formObj.usr_id.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
				var arrAuth = ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr = true;
				} else {
					isAproUsr = false;
				}
				
				comboObjects[1].RemoveAll();
				comboObjects[1].InsertItem(0, "||", "X");
				comboObjects[1].Code = "X";
				
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2018GS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.gline_seq, "gline_seq", "eff_dt|exp_dt|eff_dt", false);
	
				break;
			
			case IBSEARCH: // 조회
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					ComShowCodeMessage('PRI08001');
					return false;
				}
			
				if (comboObjects[1].Code == "X") {
					return false;
				}
				
				formObj.cfm_flg.value = "";
				formObj.cre_dt.value = "";
				formObj.cre_usr_nm.value = "";
				formObj.cre_ofc_cd.value = "";
				
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2018GS.do", FormQueryString(formObj));
				var arrData = ComPriXml2Array(sXml, "cfm_flg|cre_dt|cre_usr_nm|cre_ofc_cd|sales_cnt|loc_cnt|cmdt_cnt|arb_cnt|rate_cnt|goh_cnt|ctrt_cnt");
				
				if (arrData != null && arrData.length > 0) {
					formObj.cfm_flg.value = arrData[0][0];
					formObj.cre_dt.value = arrData[0][1];
					formObj.cre_usr_nm.value = arrData[0][2];
					formObj.cre_ofc_cd.value = arrData[0][3];
					
					enableAllTabPages(true);
					
					subDataCnt = 0;
					for (var i = 4; i < arrData[0].length; i++) {
						subDataCnt += parseInt(arrData[0][i]);
					}
				}
				
				break;
				
			case IBCREATE: // New
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				
				comboObjects[0].Index = -1;
				formObj.svc_scp_nm.value = "";
				formObj.scope_year.value = "";
				comboObjects[1].RemoveAll();
				clearAllTabPages();
				
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
				
				Visible = false;
			}
			break;
		}
	}
	
	/**
	 * Tab 기본 설정 탭의 항목을 설정한다.  <br>
	 * Tab이 다수일 경우 Tab 수만큼 case를 추가하여 Tab의 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initTab(tabObj,1);
	 * </pre>
	 * @param {tabObj} tabObj 필수 IBTab Object
	 * @param {int} tabNo 필수 IBTab Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt = 0;
				InsertTab(cnt++, "Location Group ", 0);
				InsertTab(cnt++, "Commodity Group ", 1);
				InsertTab(cnt++, "Arbitrary", 2);
				InsertTab(cnt++, "Rate", 3);
				
				ShowIcon = true;
				UseLargeIcon = false;
				
				ImageUrl(0) = ICON_URL_NOT_EXIST;
				ImageUrl(1) = ICON_URL_NOT_EXIST;
				ImageUrl(2) = ICON_URL_NOT_EXIST;
				ImageUrl(3) = ICON_URL_NOT_EXIST;
				
			}
			break;
		}
	}
	
	/**
	 * 콤보 초기설정값 정의 <br>
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initCombo(comboObj, comboNo);
	 * </pre>
	 * @param {ibcombo} sheetObj 필수 IBSheet Object
	 * @param {int} ComboNo 필수 IBCombo Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	
	            	IMEMode = 0;
	            	ValidChar(2, 0);
	            }
	            break;
	        
	        case "gline_seq":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            	
	            	SetColWidth("80|100|0");
	            	
	            	IMEMode = 0;
	            	ValidChar(2, 1);
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
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
				return false;
			}
			return true;
			break;
			
		case IBCREATE: // New
			return true;
			break;
	
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
	function tab1_OnChange(tabObj, tabIndex) {
		if (beforetab != tabIndex) {
		    var objs = document.all.item("tabLayer");

		    objs[tabIndex].style.display = "inline";
		    objs[beforetab].style.display = "none";
		    
		    //objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		}

	    beforetab = tabIndex;
	    
	    loadTabPage(tabIndex);
	}
	
	function loadTabPage(tabIndex) {
		var formObj = document.form;
		var sSvcScpCd = comboObjects[0].Code;
		var sGlineSeq = comboObjects[1].Code;
		
		if (tabIndex == null || tabIndex == "") {
			tabIndex = tabObjects[0].SelectedIndex;
		}
		
		var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
		
		if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			var sUrl = "";
			switch (tabIndex) {
			case 0:
				sUrl = "ESM_PRI_2018_01.do"; 
				break;
			case 1:
				sUrl = "ESM_PRI_2018_02.do"; 
				break;
			case 2:
				sUrl = "ESM_PRI_2018_03.do"; 
				break;
			case 3:
				sUrl = "ESM_PRI_2018_04.do"; 
				break;
			}
			objTabWindow.location.href = sUrl;
			return true;
		}
		
		if (sSvcScpCd != null && sSvcScpCd != "" && sGlineSeq != null && sGlineSeq != "" && parseInt(sGlineSeq) > 0) {
			// iframe내로 직접 포커스가 이동되면, comboObjects[1]의 값이 리셋된다.
			document.form.exp_dt.focus();
			if (objTabWindow.tabLoadSheet) {
				objTabWindow.tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES");
			}
		}
		
	}
	
	function clearAllTabPages() {
		for (var i = 0; i < tabObjects[0].GetCount(); i++) {
			tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
			}
		}
	}
	
	function enableAllTabPages(flag) {
		if (flag == null || flag == "") {
			if (isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES") {
				flag = true;
			} else {
				flag = false;
			}
		}
		
		for (var i = 0; i < tabObjects[0].GetCount(); i++) {
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
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
	function svc_scp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.svc_scp_nm.value = arrText[1];
			selectedGlineSeq = null;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
		}
	}
	
	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt = comboObj.Text;

		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}
	
	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index = -1;
	}
	
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    ssvc_scp_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function svc_scp_cd_OnBlur(comboObj) {
		var formObj = document.form;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
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
	function gline_seq_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		selectedGlineSeq = code;
		
		if (code == "" || text == "") {
			return;
		}
		
		var effText = comboObj.GetText(code, 0);
		var expText = comboObj.GetText(code, 1);
		
		formObj.eff_dt.value = effText;
		formObj.exp_dt.value = expText;
		
		if (code == null || code == "" || code == "X") {
			return true;
		}
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
		if (tabObjects[0].SelectedIndex == 0) {
			tab1_OnChange(tabObjects[0], 0);
		} else {
			tabObjects[0].SelectedIndex = 0;
		}
		
		setTabStyle();
	}
	
	function gline_seq_OnClear(comboObj) {
		var formObj = document.form;
		
		comboObj.Code = "X";
		formObj.eff_dt.value = "";
		formObj.exp_dt.value = "";
		formObj.cfm_flg.value = "";
		formObj.cre_dt.value = "";
		formObj.cre_usr_nm.value = "";
		formObj.cre_ofc_cd.value = "";
		
		clearAllTabPages();
	}
	
	function getSvcScpCd() {
		return comboObjects[0].Code;
	}
	
	function getGlineSeq() {
		return comboObjects[1].Code;
	}
	
	function getEffDt() {
		return document.form.eff_dt.value;
	}

	function getExpDt() {
		return document.form.exp_dt.value;
	}
	
	function getCfmFlg() {
		var formObj = document.form;
		
		if (formObj.cfm_flg.value != "" && formObj.cfm_flg.value.toUpperCase() == "YES") {
			return "Y";
		} else {
			return "N"
		}
	}
	
	function setTabStyle() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
	}
	
	function reloadPostCopy(svcScpCd, glineSeq) {
		var formObj = document.form;
		
		if (svcScpCd == null || svcScpCd == "" || glineSeq == null || glineSeq == "") {
			return false;
		}
		
		comboObjects[0].Code2 = svcScpCd;
		svc_scp_cd_OnChange(comboObjects[0], svcScpCd, comboObjects[0].GetText(svcScpCd, 0) + "|" + comboObjects[0].GetText(svcScpCd, 1));
		svc_scp_cd_OnBlur(comboObjects[0]);
		
		comboObjects[1].Code = glineSeq;
	}
	
/* 개발자 작업 끝 */