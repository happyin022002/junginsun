/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0034_01.js
 *@FileTitle : B/L Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.06.05 이수빈
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
	 * @class ESM_BKG_0034_01 : ESM_BKG_0034_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_0034_01() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
		
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_cust_s":
					document.form.cust_tp.value = "S";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					break;
				case "btn_cust_c":
					document.form.cust_tp.value = "C";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					break;
				case "btn_cust_n":
					document.form.cust_tp.value = "N";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
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
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
     	axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);

		// 페이지 로드 후 조회 되도록 해당 tab을 다시 호출하여 로드 
    	parent.loadTabPage(0);
	}

    /** 
     * Key Up 이벤트 처리
     */
	function obj_KeyUp() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name").substring(5);
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");

		if (srcName == "cust_cnt_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	
    /**
     * Key Down 이벤트 처리
     */ 
    function obj_KeyDown() {
    	var srcName = window.event.srcElement.getAttribute("name").substring(10);
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	
        switch(srcName) {
        case "nm":
       	    fncTextareaMaxLine(window.event.srcElement, 2);
       	    break;
        case "addr":
       	    fncTextareaMaxLine(window.event.srcElement, 3);
       	    break;
        }
    }
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		switch(sheetNo) {
		case 1:
		case 2:
			with (sheetObj) {
				// 높이 설정
				//style.height = 100;
				//전체 너비 설정
				//SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				var HeadTitle = "|cust_tp_cd|cust_cnt_cd|cust_seq|phn|fax|name|address";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus, 	30, 	daCenter, 	false, 		"ibflag");
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"bkg_cust_tp_cd",	false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"cust_cnt_cd",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"cust_seq",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"phn_no",			false,		"",	dfNone,			0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"fax_no",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"cust_nm",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"cust_addr",		false,		"",	dfNone,			0,		false,		false);
				
				CountPosition = 2; 
			}
			break;
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 조회
				if (validateForm(sheetObj,formObj,sAction)) {
					//ComOpenWait(true);
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_BKG_0034_01GS.do", FormQueryString(formObj));

					var idx;
					if( sheetObj.RowCount > 0 ) {
						idx = sheetObj.FindText("bkg_cust_tp_cd", "C");
						if(idx > 0) IBS_CopyRowToForm(sheetObj, formObj, idx, "cnee_");
						idx = sheetObj.FindText("bkg_cust_tp_cd", "N");
						if(idx > 0) IBS_CopyRowToForm(sheetObj, formObj, idx, "ntfy_");
						idx = sheetObj.FindText("bkg_cust_tp_cd", "S");
						if(idx > 0) IBS_CopyRowToForm(sheetObj, formObj, idx, "shpr_");
					}else{
						formObj.reset();
					}
					//ComOpenWait(false);
				}
				break;
				
			case IBSEARCHAPPEND: // 재조회
				if (!validateForm(sheetObj,formObj,sAction)) return false;

//				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY01;
				var custTp = formObj.cust_tp.value;
				
				var sheetObj2 = sheetObjects[1];
				sheetObj2.RemoveEtcData();
				
				sheetObj2.DoSearch("ESM_BKG_0034_01GS.do", FormQueryString(formObj));
//				ComOpenWait(false);
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.bl_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
	
		case IBSEARCHAPPEND: // 재조회
			var cust_cnt;
			var cust_seq;
						
			if (formObj.cust_tp.value == "S"){
				cust_cnt = formObj.shpr_cust_cnt_cd;
				cust_seq = formObj.shpr_cust_seq;
			}
			else if (formObj.cust_tp.value == "C"){
				cust_cnt = formObj.cnee_cust_cnt_cd;
				cust_seq = formObj.cnee_cust_seq;
			}
			else if (formObj.cust_tp.value == "N"){
				cust_cnt = formObj.ntfy_cust_cnt_cd;
				cust_seq = formObj.ntfy_cust_seq;
			}
			
	    	if (!ComChkObjValid(cust_cnt) || !ComChkObjValid(cust_seq, true, true, false)) return false;
	    	return true;
			break;
		}
	}

	/**
	 * 시트 데이터 조회 후 처리
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
		if (sheetObj.TotalRows == 0) {
			sheetObj.RemoveAll();
			var row = sheetObj.DataInsert();
			sheetObj.CellValue(row,"bkg_cust_tp_cd") = "C";
			row = sheetObj.DataInsert();
			sheetObj.CellValue(row,"bkg_cust_tp_cd") = "N";
			row = sheetObj.DataInsert();
			sheetObj.CellValue(row,"bkg_cust_tp_cd") = "S";
		}
	}

	/**
	 * 화살표 버튼 클릭 후 조회된 데이터 세팅
	 */
	function t1sheet2_OnSearchEnd(sheetObj2, ErrMsg)  {
		 if (ErrMsg == "") {
			var formObj = document.form;
			var custTp = formObj.cust_tp.value;	
			if(custTp == "C"){
				formObj.cnee_cust_nm.value = sheetObj2.EtcData("cust_nm");
				formObj.cnee_cust_addr.value = sheetObj2.EtcData("cust_addr");
			}
			else if(custTp == "N"){
				formObj.ntfy_cust_nm.value = sheetObj2.EtcData("cust_nm");
				formObj.ntfy_cust_addr.value = sheetObj2.EtcData("cust_addr");
			}
			else if(custTp == "S"){
				formObj.shpr_cust_nm.value = sheetObj2.EtcData("cust_nm");
				formObj.shpr_cust_addr.value = sheetObj2.EtcData("cust_addr");
			}
			
		}
	}

	/**
	 * 탭 클릭 시 조회
	 */
	function tabLoadSheet(strBlNo) {
		var formObject = document.form;
		formObject.bl_no.value = strBlNo;
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}
	
	/**
	 * 입력 폼, 시트 초기화
	 */
	function tabClearSheet() {
		var frmChild = document.getElementsByTagName("input");
		for(var i=0; i<frmChild.length; i++){
			if(frmChild[i].type != "hidden") {
	    		frmChild[i].value = "";
			}
	    }
		var frmChild2 = document.getElementsByTagName("textarea");
		for(var i=0; i<frmChild2.length; i++){
    		frmChild2[i].value = "";
	    }
		sheetObjects[0].RemoveAll();
	}

	/**
	 * 탭 활성화 처리
	 */
	var enableFlag = true;
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
	}
	
	/**
	 * 저장 할 데이터 스트링 생성 
	 */
	function getSaveString() {
		var newParam = ComSetPrifix(FormQueryString(document.form), "t1_new_");
		var oldParam = ComSetPrifix(sheetObjects[0].GetSaveString(true), "t1_old_");
		return newParam + "&" + oldParam;
	}
	
	/**
	 * form 데이터 값 반환 
	 */
	function getFormString(str) {
		var obj = document.getElementsByName(str);
		return ComReplaceStr(ComReplaceStr(obj[0].value, '[', '('), ']', ')');
	}
    
    /**
     * TextArea 라인 수를 제한한다.<br>
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 라인수를 제어한다. <br>
     */
    function fncTextareaMaxLine(obj, maxLine) {
   	    var str_len = obj.value;
   	    line = str_len.split("\r\n");
   	    ln = line.length;

   	    if(ln == maxLine && event.keyCode == 13) { 	  
   		    event.returnValue = false;
   	    }
    }
	
	/* 개발자 작업 끝 */