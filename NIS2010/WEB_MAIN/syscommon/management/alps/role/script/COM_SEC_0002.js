/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : COM_SEC_0002.js
*@FileTitle : ALPS Role Request
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastVersion : 1.0
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
	* @class COM_SEC_0002 : COM_SEC_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	*/
	function COM_SEC_0002() {
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
    	    	case "btn_Add":
    	    		doActionIBSheet(sheetObj,formObj,IBINSERT);
    	    		break;
					
				case "btn_request":
					doActionIBSheet(sheetObj, formObj, IBSAVE);
					break;
					
				case "btn2_delete":
					if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk");
					} else {
						ComShowCodeMessage("MNR00150");
					}
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

		// ※※※ sheet1_OnLoadFinish 메서드 존재시 반드시 참조 ※※※
	}


	/**
	* 시트 초기설정값, 헤더 정의
	* param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj, shtNo) {
		with (sheetObj) {
			switch (sheetObj.id) {

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
					InitHeadMode(true, false, false, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle  = "||ALPS|Module|Role|Role" ;

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    false,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     40,     daCenter,    false,   "del_chk");
					InitDataProperty(0, cnt++ , dtCombo,    310,    daLeft,    false,   "req_menu",      true,    "",     dfNone,    0,    false,    true);
					InitDataProperty(0, cnt++ , dtCombo,    310,   	daLeft,    false,   "req_sub_menu",  true,    "",     dfNone,    0,    true,    true);
					InitDataProperty(0, cnt++ , dtCombo,    295,    daLeft,    false,   "usr_role_cd",		true,    "",     dfNone,    0,    true,    true);
					InitDataProperty(0, cnt++ , dtPopup,        15,     daCenter,    false,   "pgm_asgn");
				
					InitDataCombo (0, "req_menu", "", "");
					InitDataCombo (0, "req_sub_menu", "", "");
					InitDataCombo (0, "usr_role_cd", "", "");
					
					//comboBox 클릭시 direct open
					ComboOpenMode = true;
					//InitComboNoMatchText(true, "There is no role to request");
					
					//% 단위로 재설정하기
					FitColWidth("0|2|32|32|32|2");
					
					WaitImageVisible = false;
					ShowButtonImage = 2;
					break;
			}
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:    // 조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("COM_SEC_0002GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				
				if(!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				
				if (!sheetObj.IsDataModified) {
					ComShowCodeMessage("COM130503");
					return;
				} else if (ComShowCodeConfirm("COM130101", "data")) {    
					//저장처리
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					var saveCheck = sheetObj.DoSave("COM_SEC_0002GS.do", FormQueryString(formObj), -1, false);
					ComOpenWait(false);
					
					if(saveCheck){
		            	//공통함수사용: 화면을 초기화
						ComResetAll();
					}

				}
				break;

			case IBDOWNEXCEL:     //엑셀다운로드
				sheetObj.Down2Excel(1);
				break;
				
           case IBINSERT:      // 입력
        	   sheetObj.DataInsert();
        	   break;

		}
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	if (!ComChkValid(formObj)) return false;

        return true;
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */ 
 	function sheet1_OnValidation(sheetObj, Row, Col, Value){
 			
 	} 
	
	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		//doActionIBSheet(shtObj, document.form, IBSEARCH);
		
		var formObj = document.form;
		var pgm_level1 = 1;
		var sXml = sheetObj.GetSearchXml("COM_SEC_0002GS.do", "f_cmd=" + SEARCH01 + "&pgm_level="+pgm_level1);				
		var arrData = ComXml2ComboString(sXml, "pgm_no", "menu_nm");				
		sheetObj.InitDataCombo (0, "req_menu", " |" +arrData[1], " |" +arrData[0]);
		
	}

	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 저장 후 메시지
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// 저장 후 재조회
		//doActionIBSheet(shtObj, document.form, IBSEARCH);
	}

	
	/**
	 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */
	function sheet1_OnPopupClick(sheetObj, row, col) {
		switch (sheetObj.ColSaveName(col)) {
			case "pgm_asgn":
				var usr_role_cd = sheetObj.CellValue(row, "usr_role_cd");
				
				if(usr_role_cd != null && usr_role_cd != ""){
					
					var sText = sheetObj.GetComboInfo(row, "usr_role_cd", "Text");
					var sCode = sheetObj.GetComboInfo(row, "usr_role_cd", "Code");
					
					var arrText = sText.split("|");
					var arrCode = sCode.split("|");
					var role_nm = "";

					for(i=0; i<arrCode.length; i++) {
						if (usr_role_cd == arrCode[i]) {
							role_nm = arrText[i].split("-")[1].trim();
							break;
						}
					}
					
					var parent_pgm_no = "";
					
					if( typeof(curPgmNo) != 'undefined' ){
						parent_pgm_no = curPgmNo;
					}
					
					var param="role_cd="+ usr_role_cd + "&role_nm=" + escape(role_nm) + "&parent_pgm_no=" + parent_pgm_no;
					ComOpenPopup("programMapping.do?" + param, 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, row, col, 0);
					
				}

				break;
		}
	}

	function sheet1_OnChange(sheetObj, row, col, val){
		switch (sheetObj.ColSaveName(col)){
		case "req_menu":
			var pgm_level = 2;
			
			sheetObj.CellValue(row, "usr_role_cd") = "";
			sheetObj.CellComboItem(row, "usr_role_cd", "", "");
			sheetObj.CellValue(row, "req_sub_menu") = "";
			sheetObj.CellComboItem(row, "req_sub_menu", "", "");
			
			
			var sXml = sheetObj.GetSearchXml("COM_SEC_0002GS.do", "f_cmd=" + SEARCH01 + "&pgm_level="+pgm_level + "&prnt_pgm_no="+val);				
			var arrData = ComXml2ComboString(sXml, "sub_sys_cd", "sub_menu_nm");

			sheetObj.CellComboItem (row, "req_sub_menu", " |" +arrData[1], " |" +arrData[0]);
            
			break;
			
		case "req_sub_menu":

			sheetObj.CellValue(row, "usr_role_cd") = "";
			sheetObj.CellComboItem(row, "usr_role_cd", "", "");
			
			var sXml = sheetObj.GetSearchXml("COM_SEC_0002GS.do", "f_cmd=" + SEARCH02 + "&sub_sys_cd=" + val);				
			var arrData = ComXml2ComboString(sXml, "usr_role_cd", "usr_role_nm");
			if(arrData != null){
				sheetObj.CellComboItem(row, "usr_role_cd", " |" +arrData[1], " |" +arrData[0]);
			}else{
				sheetObj.CellComboItem(row, "usr_role_cd", "", "");
			}
            
			break;
 		case "usr_role_cd":
			var code = val;
			for(var int = 1; int <= sheetObj.RowCount; int++) {
				 var orlcode = sheetObj.CellValue(int, col);
				 if((int != row)&&(code!=""))
					 {
						 if(code == orlcode){
		 	   				 ComShowMessage("You have already role code( \"" + code + "\").");
		 	   				 	sheetObj.CellValue(row, "usr_role_cd") = "";
		 	   				 return;
		 	   			 }
					 }
 	   		 }
			break;
			
		}
	}
	
	function sheet1_OnClick(sheetObj, row, col, val){
		var formObj = document.form;
		switch (sheetObj.ColSaveName(col)){
			case "req_menu":
				break;
			
		}
	}
	
	function sheet1_OnResize(){
		var sheetObj = sheetObjects[0];
		sheetObj.FitColWidth("0|2|32|32|32|2");
	}
	

/* 개발자 작업 끝 */
