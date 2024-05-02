/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0451.js
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.04
 *@LastModifier : jsy
 *@LastVersion : 1.0
 * 2011.10.04 jsy
 * 1.0 Creation
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */
	/**
	 * @extends 
	 * @class esm_bkg_0451 : esm_bkg_0451 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_0451() {
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
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/**
	 * 콤보 초기설정값
	 * @param {IBMultiCombo} comboObj  comboObj
	 */
	function initCombo(comboObj) {
		comboObj.DropHeight = 300;
	}  
  
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
		//IBMultiCombo초기화
//		for(var k=0; k<comboObjects.length; k++){
//		    initCombo(comboObjects[k]);
//		}
//		document.form.sr_due_dt.value = getCalculatedDate(0, 0, -1, "-");
		doActionIBSheet(sheetObjects[0], document.form, INIT);
//		ComBtnDisable("btn_del");
//		ComBtnDisable("btn_save");
//		ComBtnDisable("btn_transfer");
//		ComBtnDisable("btn_sitrans");
//		ComBtnDisable("btn_match");
//		setAmend();
		initControl();
	}
 
	/**
	 * 조회조건 입력할 때 처리
	 */
	function obj_KeyUp() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		
		var formObject = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
//		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');//Enter key 처리
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		//window.attachEvent("onbeforeunload",checkClosePage);

	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetNo) {
		 
			case 1: //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 200;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll; //msNone;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					var HeadTitle = "|Seq.|Sr No|Fax Log Ref No|Seq|Process|Evnt Dt|Evnt Usr Id|Category|Previous|Current|Event(GMT)|Cre dt|Cre Usr Id";
					var headCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(headCount, 0, 0, true);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true, 	"ibflag");
					InitDataProperty(0, cnt++, dtSeq, 			30, 	daCenter, false, 	"Seq");
					InitDataProperty(0, cnt++, dtHidden, 			30, 	daCenter, false, 	"sr_no", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 			30, 	daCenter, false, 	"fax_log_ref_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 			50, 	daCenter, false, 	"sr_proc_seq", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			140, 	daCenter, true, 	"sr_proc_tp_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 			70, 	daCenter, false, 	"evnt_dt", 			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 			70, 	daCenter, false, 	"evnt_usr_id", 		false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, true, 	"his_cate_nm", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"pre_ctnt", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"crnt_ctnt", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			140, 	daCenter, false, 	"evnt_gdt", 		false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtHidden, 			120, 	daCenter, false, 	"cre_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 			150, 	daCenter, false, 	"cre_usr_id", 	false, "", dfNone, 0, false, true);
					
					//InitUserFormat2(0, "RECEIVE", "####-##-## ##:##", "-|:" ); 
					CountPosition = 0;
					//WordWrap = true;
				}
				break;
		}
	}
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_retrieve":
					//doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
					break;

				case "btn_Close":
//					if (checkClosePage() == false) return;
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
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
			case INIT: //open
				
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH;
				var searchXml = sheetObj.GetSearchXml("ESM_BKG_0451GS.do", FormQueryString(formObj));
			
				var arrXml = searchXml.split("|$$|");
				sheetObj.LoadSearchXml(arrXml[0]);

				break;
			case COMMAND01: //retrieve
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH01;
				var searchXml = sheetObj.GetSearchXml("ESM_BKG_0451GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(searchXml);
				break;
 	
		}
	}
 
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (formObj.sr_no.value == '') {
			ComShowCodeMessage("BKG08096"); //You Must Input S/R NO
			return false;
		}
		
		with(formObj){
	      	switch(sAction) {
		     	case ADD: // 조회시 확인
 
			  		break;
		     	case IBSAVE: // 저장시 확인
			  		//if (!ComChkValid(formObj)) return false;
			  		break;	
	      	}	
	    }		
		return true;
	}
 
 
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
        var formObj = document.form;
        switch (event.srcElement.getAttribute("name")) {
            case "sr_due_dt":
                ComAddSeparator(event.srcElement);
            break;
 
        }
    }	
    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        //입력Validation 확인하기
        switch (event.srcElement.name) {
            case "sr_due_dt":
                ComClearSeparator(event.srcElement);
            break;
 
        }
    }    
	/* 개발자 작업  끝 */