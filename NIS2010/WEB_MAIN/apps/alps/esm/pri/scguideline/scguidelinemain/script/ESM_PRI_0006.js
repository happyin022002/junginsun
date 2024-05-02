/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0006.js
*@FileTitle : Guideline Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.16 김재연
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
     * @class ESM_PRI_0006 : ESM_PRI_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0006() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setComboObject 		= setComboObject;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var isAproUsr = false;
	
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
     * @version 2009.06.16
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
      
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
     		
             switch(srcName) {

 				case "btn_ok":
 					doActionIBSheet(sheetObject1, formObject, IBSAVE);
 					break;

 				case "btn_close":
 					window.close();
 					break;

 				case "btns_calendar": //달력버튼
	                var cal = new ComCalendarFromTo();
	                cal.select(formObject.trgt_eff_dt, formObject.trgt_exp_dt, 'yyyy-MM-dd');
	                break;     

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
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
     * @version 2009.06.16
     */
	function setSheetObject(sheet_obj){
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
     * @version 2009.06.16
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
     * @version 2009.06.16
     */
    function loadPage() {
    	
    	for(i=0;i<sheetObjects.length;i++) {
	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet (sheetObjects[i] );
	
	        initSheet(sheetObjects[i],i+1);
        
        	//khlee-마지막 환경 설정 함수 추가
        	ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	//IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    
    	initControl();
    	
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	comboObjects[0].Code = document.form.svc_scp_cd.value;
    	document.form.trgt_svc_scp_nm.value = comboObjects[0].GetText(comboObjects[0].FindIndex(comboObjects[0].Code, 0), 1);
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
     * @version 2009.06.16
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetid = sheetObj.id;
		
		switch (sheetid) {
			case "sheet1":
	            with (sheetObj) {
	
	                // 높이 설정
	                style.height = 80;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(1, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)
	
	                var HeadTitle = "stat";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	                //KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 
	                //FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,   cnt++, dtStatus, 	 60,    daCenter,  false,   "ibflag");
	                
	                AutoRowHeight = false;
	                WaitImageVisible = false;
	            }
	            break;
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
     * @version 2009.06.16
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH_ASYNC01:
				comboObjects[0].RemoveAll();

				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.trgt_svc_scp_cd, "cd", "cd|nm");
				break;
				
			case IBSEARCH_ASYNC11:
				var sParam = "f_cmd="+COMMAND15+"&pagerows=&prc_ctrt_tp_cd=S&svc_scp_cd=" + comboObjects[0].Code + "&usr_id=" + formObj.usr_id.value;

				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
				var arrAuth = ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr = true;
				} else {
					isAproUsr = false;
				}
				toggleButtons();
				break;
				
			case IBSEARCH:
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_0006GS.do", FormQueryString(formObj));
				var arrDesc = ComPriXml2Array(sXml, "grp_loc_cnt|grp_cmdt_cnt|org_arb_cnt|dest_arb_cnt|rate_cnt|goh_cnt");
				setTermsCheck(arrDesc);
				ComOpenWait(false);
				break;
				
			case IBSAVE:
				ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI01;
				var sXml = sheetObj.GetSaveXml("ESM_PRI_0006GS.do", FormQueryString(formObj), true);
				var arrDesc = ComPriXml2Array(sXml, "trgt_gline_seq");
				if(arrDesc != null && arrDesc != "") {
					formObj.trgt_gline_seq.value = arrDesc[0][0];
				}
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
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
     * @author 김재연
     * @version 2009.05.20
     */
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
 		var formObj = document.form;
		if (ErrMsg == "") {
			var trgtSvcScpCd = comboObjects[0].Code;
			var trgtGlineSeq = formObj.trgt_gline_seq.value;
			dialogArguments.reloadPostCopy(trgtSvcScpCd, trgtGlineSeq);
		    self.close();
		}
	}
 	
 	/**
     * IBMultiCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * trgt_svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} value 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 김재연
     * @version 2009.06.16
     */
	function trgt_svc_scp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.trgt_svc_scp_nm.value = arrText[1];
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
		}
		
	}
	
	/**
     * IBMultiCombo에서 OnClear 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 김재연
     * @version 2009.06.16
     */
	function trgt_svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.trgt_svc_scp_nm.value = "";
		
		comboObj.Index2 = -1;
	}
	
	/**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * trgt_svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 김재연
     * @version 2009.06.16
     */
	function trgt_svc_scp_cd_OnBlur(comboObj) {
		var formObj = document.form;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.trgt_svc_scp_nm.value) {
				formObj.trgt_svc_scp_nm.value = comboObj.GetText(code, 1);
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
			}
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
     * @version 2009.06.16
	 **/
	function initControl() {
		//** Date 구분자 **/
		//DATE_SEPARATOR = "/";
	
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerForm('click', 'obj_click', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	}
	
	/** 
	 * Object 의 Keypress 이벤트핸들러 <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.06.16
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
	       
			case "ymd":
		        //날짜만입력하기
		        ComKeyOnlyNumber(event.srcElement, "-");
	            break;
		}
	}
	
	/** 
	 * Object 의 OnFocus 이벤트핸들러 <br>
	 * 날짜타입에서 '-'을 삭제하여 보여준다.  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.06.16
	 */ 
	function obj_activate() {
		switch(event.srcElement.name) {
		 	case "trgt_eff_dt":
		 		ComClearSeparator(event.srcElement);
		 		break;
		 		
		 	case "trgt_exp_dt":
		 		ComClearSeparator(event.srcElement);
		 		break;
	}
	}
	 
	/** 
	 * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.06.16
	 */ 
	function obj_deactivate() {
		 switch(event.srcElement.name) {
		 	case "trgt_eff_dt":
		 		ComChkObjValid(event.srcElement);
		 		break;
		 		
		 	case "trgt_exp_dt":
		 		ComChkObjValid(event.srcElement);
		 		break;
		}
	 }
	 
	/** 
	 * Object 의 OnClick 이벤트핸들러 <br>
	 * 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.06.16
	 */ 
	function obj_click() {
		var formObj = document.form;
		
		switch(event.srcElement.name) {
		
			case "rate":
		 		if(event.srcElement.checked) {
		 			if(formObj.loc_grp.disabled == false) {
		 				formObj.loc_grp.checked = true;
		 			}
		 			if(formObj.cmdt_grp.disabled == false) {
		 				formObj.cmdt_grp.checked = true;
		 			}
		 		}
		 		break;
		}
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
     * @version 2009.06.16
     */ 
    function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "trgt_svc_scp_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;
	    }
	}
	
    /**
     * check box의 check 여부를 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setTermsCheck(arrDesc);
     * </pre>
     * @param {array} arrDesc 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.06.16
     */ 
	function setTermsCheck(arrDesc) {
		var formObj = document.form;
		 
		if(arrDesc[0][0] > 0 ) {
			formObj.loc_grp.checked = true;
		} else {
			formObj.loc_grp.checked = false;
			formObj.loc_grp.disabled = true;
		}
		 
		if(arrDesc[0][1] > 0 ) {
			formObj.cmdt_grp.checked = true;
		} else {
			formObj.cmdt_grp.checked = false;
			formObj.cmdt_grp.disabled = true;
		}
		 
		if(arrDesc[0][2] > 0 ) {
			formObj.org_arb.checked = true;
		} else {
			formObj.org_arb.checked = false;
			formObj.org_arb.disabled = true;
		}
		 
		if(arrDesc[0][3] > 0 ) {
			formObj.dest_arb.checked = true;
		} else {
			formObj.dest_arb.checked = false;
			formObj.dest_arb.disabled = true;
		}
		 
		if(arrDesc[0][4] > 0 ) {
			formObj.rate.checked = true;
		} else {
			formObj.rate.checked = false;
			formObj.rate.disabled = true;
		}
		 
		if(arrDesc[0][5] > 0 ) {
			formObj.goh.checked = true;
		} else {
			formObj.goh.checked = false;
			formObj.goh.disabled = true;
		}
	}
	 
	/**
     * 권한에 따른 button 사용 여부 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	toggleButtons();
     * </pre>
     * @param {array} arrDesc 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.06.16
     */ 
	function toggleButtons() {
		if (!isAproUsr) {
			ComBtnDisable("btn_ok");
		} else {
			ComBtnEnable("btn_ok");
		}
	}
	 
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.06.16
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSAVE:
				if(!ComChkRequired(formObj)) return false;
				
				if(ComChkPeriod(formObj.trgt_eff_dt.value, formObj.trgt_exp_dt) == 0) { 
					ComShowCodeMessage('PRI00306');
					return false;
				}
				if(!ComShowCodeConfirm('PRI08006')) {
					return false;
				}
				break;
		  }
		return true;
	}

	/* 개발자 작업  끝 */