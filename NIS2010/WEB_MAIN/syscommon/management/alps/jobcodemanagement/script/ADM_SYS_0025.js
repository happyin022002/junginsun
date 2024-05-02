/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ADM_SYS_0025.js
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013-07-04
*@LastModifier : DukWoo	Choi
*@LastVersion : 1.0
* 2013-07-04 DukWoo	Choi
* 1.0 최초 생성
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
	 * @class Error Message Management : Error Message Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ADM_SYS_0025() {
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
	var tabCnt = 0 ;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 var shtObj = sheetObjects[0];
		 var frmObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_search":
					if (frmObj.search_text.value == "") return;
					findXML(frmObj.search.value, frmObj.search_text.value);
					break;

				case "btn_reset":
					ComResetAll();    //기본 object 초기화
					changeCompany("treeView", "hjs");    // 조직도 초기화 목적으로 사용
					officeSearch();    // 초기목록 조회
					break;

				case "btn_ok":		
                    doActionIBSheet(shtObj,frmObj,IBSAVE);
					break;

				case "btn_close":
					close();
					break;
			} // end switch

		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
	 * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
	 * @param {ibsheet} sheet_obj    IBSheet Object
	 **/
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
	 * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
	 **/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		initTree("treeView", "loadData");

		officeSearch();
	}

	/**
	 * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
	 * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 322;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					var HeadTitle = "||Name|Dept|Title||USR_ID" ;
					var headCount = ComCountHeadTitle(HeadTitle);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, false, true, false,false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성 [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    false,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,    false,    "check_val");
					InitDataProperty(0, cnt++ , dtData,     	120,    daLeft,      false,    "NAME",      false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,     	130,    daCenter,    false,    "TEAMNM",    false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtData,     	0,      daLeft,      false,    "BUJAE",     false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,      daCenter,    false,    "CN",        false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,      daCenter,    false,    "apro_usr_id",        false,    "",    dfNone,    0,    false,    false);

					CountPosition = 0;
				}
				break;
		}
	}


	/* Sheet관련 프로세스 처리 */
	 function doActionIBSheet(shtObj,frmObj,sAction) {

		 switch(sAction) {
			case IBSAVE:        //저장
				if (!shtObj.IsDataModified) {
					ComShowCodeMessage("COM130503");
					return;
				} else if (ComShowCodeConfirm("COM130101", "data")) {    // Do you want to save {?msg1}?
					//저장처리
					ComOpenWait(true);
					frmObj.f_cmd.value = MULTI;
//					alert(document.form.sel_cn.value);
					shtObj.DoSave("ADM_SYS_0025GS.do", FormQueryString(frmObj), -1, false);
					ComOpenWait(false);
				}
				break;
				
			case IBSEARCH:    // 조회
//				if (!ComChkValid(frmObj)) return;
//				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ADM_SYS_0025GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;
		}
	}


	// OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
	function loadData(data) {
		var sheetObject = sheetObjects[0];

		var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
		for( var i = 0 ; i < data.length ; i++ ) {
			sheetXml += "<TR><![CDATA[";
			sheetXml += "|" + "|" + data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4) + "|" + data[i].getPos(4);
			sheetXml += "]]></TR>";
		}
		sheetObject.LoadSearchXml(sheetXml+"</DATA></SHEET>");
	 }

	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnClick(shtObj, Row, Col, Value){
		with (shtObj) {
			switch (ColSaveName(Col)){
				case "check_val":			//check_val 컬럼만 선택시 작동
					if(Value == 0){
						//이미 Approver로 지정된 사람인지 중복여부 체크를 위한 조회
						var xmlStr = shtObj.GetSearchXml("ADM_SYS_0025GS.do", "f_cmd=" + SEARCH01 + "&apro_usr_id=" + shtObj.CellValue(Row, "CN"));
						//COM_USER 테이블에 정보 없을시...미존재 알림
						if(ComGetEtcData(xmlStr, "usr_yn") == "N"){
							ComShowCodeMessage("JOB00008", "'"+shtObj.CellValue(Row, "NAME")+"'");
							shtObj.CellValue2(Row, "check_val") = 1;
						} else {
							//COM_USER 테이블 및 COM_OFC_ROLE_APRO_USR 테이블에 모두 존재시(이미 APPROVER로 지정되었을때)
							if(ComGetEtcData(xmlStr, "usr_chk") == "Y" && ComGetEtcData(xmlStr, "apro_exist_id") == "Y"){
								ComShowCodeMessage("JOB00007", "'"+shtObj.CellValue(Row, "NAME")+"'");
								shtObj.CellValue2(Row, "check_val") = 1;
							} 
						}
					}
			}
		}
	}	
	
	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 에러가 발생했을 경우에 서버에서 리턴되는 메시지
	 */
	function sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("JOB00001", "Data", "saved");    // {?msg1} was {?msg2} successfully.
		// 저장 후  부모창 재조회
		var opener = window.dialogArguments;    // MODAL창에서 부모창 호출
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		window.close();
	}

	// 소속 Office 직원 리스트 자동 출력 처리
	function officeSearch() {
		findXML("TEAM", findUserInfo("CN", document.form.usr_id.value, "TEAM"));
	}


/* 개발자 작업  끝 */
