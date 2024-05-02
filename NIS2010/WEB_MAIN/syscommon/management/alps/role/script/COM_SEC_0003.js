/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_SEC_0003.js
*@FileTitle : ALPS Role Authority Approval Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
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
	* @class COM_SEC_0003 : COM_SEC_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	*/
	function COM_SEC_0003() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
    	    	case "btn_save":
    	    		doActionIBSheet(sheetObj, formObj, IBSAVE);
    	    		break;
    	    	case "btn_retrieve":
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH);
    	    		break;
    	    		
				case "btn_DownExcel":
            		doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
            		break;	
					
			} // end switch

		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}


	/**
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
//		initControl();

		// ※※※ sheet1_OnLoadFinish 메서드 존재시 반드시 참조 ※※※
	}


	/**
	* 시트 초기설정값, 헤더 정의
	* param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {

				case "sheet1":
					var cnt = 0;
					// 높이 설정
					style.height = GetSheetHeight(16);

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(1, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, true, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle  = "STS|User ID|User Name|Office|Requested \nDate|Module|Requested \nRole|Role Name|Request Reason|Approval|Approval \nRole|Comment|apro_rqst_no|apro_rqst_seq ";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,      daCenter,    false,    "ibflag");    // [필수]

					InitDataProperty(0, cnt++, dtData,         70,      daCenter,    false,    "rqst_usr_id",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         100,      daCenter,    false,   "rqst_usr_nm",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         60,      daCenter,    false,    "rqst_ofc_cd",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         80,    	daCenter,    false,    "rqst_st_dt",      false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         60,      daCenter,    false,    "role_module",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtPopup,        70,      daCenter,    false,    "usr_role_cd",     false,     "",    dfNone,    0,    true,     false);
					InitDataProperty(0, cnt++, dtData,         180,     daLeft,      false,    "usr_role_nm",     false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         150,     daLeft,      false,    "rqst_rmk",        false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtComboEdit,    80,     daCenter,    false,     "apsts_cd",        true,     "",    dfNone,    0,    true,     true);
					InitDataProperty(0, cnt++, dtComboEdit,    200,     daLeft,      false,    "apro_role_cd",    false,     "",    dfNone,    0,    true,     true);
					InitDataProperty(0, cnt++, dtData,         150,     daLeft,      false,    "apro_rmk",       false,     "",    dfNone,    0,    true,     true,  300);
					
					InitDataProperty(0, cnt++, dtHidden,         150,     daLeft,      false,    "apro_rqst_no",       false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtHidden,         150,     daLeft,      false,    "apro_rqst_seq",       false,     "",    dfNone,    0,    false,     false);
					
					InitDataCombo(0, "apsts_cd", " |Yes|No", "P|C|R");
					InitDataCombo(0, "apro_role_cd", "", "");
					
					//comboBox 클릭시 direct open
					//ComboOpenMode = true;
					ShowButtonImage = 3;

					WaitImageVisible = false;
					WordWrap = true;
					
					break;
			}
		}
	}


	/**
	* Form의 Conrol 초기화 및 초기 이벤트 등록
	*/
	function initControl() {
		// 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력) - CoJobcodemanagement.js에 정의
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH: 
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("COM_SEC_0003GS.do", FormQueryString(formObj));
				ComOpenWait(false);	
				
				ComEtcDataToForm(formObj, sheetObj, "", true);
				
				break;
				
			case IBSAVE:	//저장
				
				if (!sheetObj.IsDataModified) {
					ComShowCodeMessage("COM130503");
					return;
				} else if (ComShowCodeConfirm("COM130101", "data")) { 
					
					//저장처리
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					var saveCheck = sheetObj.DoSave("COM_SEC_0003GS.do", FormQueryString(formObj), -1, false);
					ComOpenWait(false);
				}
				
				break;
				
			case IBDOWNEXCEL:		// Excel download
				sheetObj.Down2Excel(-1, true, true, false);
                break;
		}
	}
	
	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 저장 후 메시지
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// 저장 후 재조회
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction){
		//return true;
	}
	
	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
	
	/**
	 * IBSeet role Combobox을 세팅해준다.
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_ComboBoxLoad(){
		for(var int = 1; int <= sheetObj.RowCount; int++) {
			var usr_role_cd = sheetObj.CellValue(int, "usr_role_cd");
			var usr_role_nm = sheetObj.CellValue(int, "usr_role_nm");
			
			sheetObj.CellComboItem(int, "apro_role_cd", usr_role_cd + " - " + usr_role_nm, usr_role_cd);
			sheetObj.CellValue(int, "apro_role_cd") = usr_role_cd;
		}
	}
	
	/**
	 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */
	function sheet1_OnPopupClick(sheetObj, row, col) {
		switch (sheetObj.ColSaveName(col)) {
			case "usr_role_cd":
				var usr_role_cd = sheetObj.CellValue(row, "usr_role_cd");
				var usr_role_nm = escape(sheetObj.CellValue(row, "usr_role_nm"));
				
				var parent_pgm_no = "";
				
				if( typeof(curPgmNo) != 'undefined' ){
					parent_pgm_no = curPgmNo;
				}

				var param="role_cd="+ usr_role_cd + "&role_nm=" + usr_role_nm + "&parent_pgm_no=" + parent_pgm_no;
				ComOpenPopup("programMapping.do?" + param, 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, row, col, 0);

				break;
		}
	}
	
	/**
	 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */		
	function sheet1_OnChange(sheetObj, row, col, val){
		switch (sheetObj.ColSaveName(col)){
		case "apsts_cd":
			
			//Approval Role Validation Check
			if(sheetObj.CellValue(row, "apsts_cd") == "C"){
				var rqst_usr_id = sheetObj.CellValue(row, "rqst_usr_id");
				var usr_role_cd = sheetObj.CellValue(row, "usr_role_cd");
				var apro_role_cd = sheetObj.CellValue(row, "apro_role_cd");
				
				if(apro_role_cd != null && apro_role_cd != ""){
					usr_role_cd = apro_role_cd;
				}
				
				var sXml = sheetObj.GetSearchXml("COM_SEC_0003GS.do", "f_cmd=" + SEARCH02 + "&usr_role_cd=" + usr_role_cd + "&rqst_usr_id=" + rqst_usr_id);

				var rqstRoleStatus = ComGetEtcData(sXml, "rqstRoleStatus");
				
				if(rqstRoleStatus != 'none'){
					ComShowCodeMessage("ROLE00001", usr_role_cd);
					sheetObj.CellValue(row, "apsts_cd") = "";
				}
			}
			break;
 		case "apro_role_cd":
 			
			var sel_rqst_usr_id = sheetObj.CellValue(row, "rqst_usr_id");
			var sel_apro_role_cd = sheetObj.CellValue(row, "apro_role_cd");

			for(var int = 1; int <= sheetObj.RowCount; int++) {
				var orl_rqst_usr_id = sheetObj.CellValue(int, "rqst_usr_id");
				var orl_apro_role_cd = sheetObj.CellValue(int, "apro_role_cd");

				 if((int!= row)&&(sel_apro_role_cd!="")){
					 if((sel_rqst_usr_id == orl_rqst_usr_id) && (sel_apro_role_cd == orl_apro_role_cd)){
						 ComShowMessage("You have already role code( \"" + sel_apro_role_cd + "\").");
						 sheetObj.CellValue(row, "apro_role_cd") = "";
						 return;
		 	   		}
				}
 	   		 }
			break;
		}
	}
	
	function sheet1_OnClick(sheetObj, row, col, val){
		switch (sheetObj.ColSaveName(col)){
			case "apro_role_cd":
				
				var role_module = sheetObj.CellValue(row, "role_module");
				var usr_role_cd = sheetObj.CellValue(row, "usr_role_cd");
				var ursRoleNm = sheetObj.CellValue(row, "usr_role_nm");
				var rqstUsrId = sheetObj.CellValue(row, "rqst_usr_id");
 
				var sXml = sheetObj.GetSearchXml("COM_SEC_0002GS.do", "f_cmd=" + SEARCH03 + "&sub_sys_cd=" + role_module + "&rqst_usr_id=" + rqstUsrId);
				var arrData = ComXml2ComboString(sXml, "usr_role_cd", "usr_role_nm");
				
				if(arrData != null){
					sheetObj.CellComboItem(row, "apro_role_cd", " |" + arrData[1], " |" + arrData[0]);
					//sheetObj.CellValue(row, "apro_role_cd") = usr_role_cd;
				}else{
					sheetObj.CellComboItem(row, "apro_role_cd", "", "");
				}
			 
			 break;
		}
	}
	
	function sheet1_OnResize(){
		var sheetObj = sheetObjects[0];
		//% 단위로 재설정하기
		sheetObj.FitColWidth("0|6|10|5|10|5|7|15|19|8|15|19");
	}
	
/* 개발자 작업 끝 */
