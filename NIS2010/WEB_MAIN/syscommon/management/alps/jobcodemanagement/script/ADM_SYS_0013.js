/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ADM_SYS_0013.js
*@FileTitle : 프로그램 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-22
*@LastModifier : DukWoo Choi
*@LastVersion : 1.0
* 2013-05-22 DukWoo Choi
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 공통전역변수 */
//var calPop = new calendarPopupGrid();
var sheetObjects = new Array();
var sheetCnt = 0;


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		 var shtObj0 = sheetObjects[0];
		 var shtObj1 = sheetObjects[1];
		 /******************************************************/
		 var frmObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			/***********************************************************************************************************
				이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
				공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.
			 **********************************************************************************************************/
			/*
				이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
				메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
				(순서상도 form[1]이 되겠죠?)
				그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
				document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
			*/
			switch(srcName) {
				case "showAll1":
					with (shtObj1) {
						ReDraw = false;
						if (frmObj.showAll1.checked) {
							for (var i=HeaderRows; i<=LastRow; i++) {
								if (CellValue(i, "check_val") == 1) {
									RowHidden(i) = false;
								} else {
									RowHidden(i) = true;
								}
							}
						} else {
							for (var i=HeaderRows; i<=LastRow; i++) {
								RowHidden(i) = false;
							}
						}
						ReDraw = true;
					}
					break;

				case "btn_save":
					doActionIBSheet2(shtObj1, frmObj, IBSAVE);
					break;

				case "btn_downexcel":
					doActionIBSheet2(shtObj1, frmObj, IBDOWNEXCEL);
					break;

				case "btn_close":
					window.close();
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
	 * comSheetObject(id)에서 호출한다
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		// ※※※ sheet1_OnLoadFinish 메서드 반드시 참조 ※※※
		// ※※※ sheet2_OnLoadFinish 메서드 반드시 참조 ※※※
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			 case 1:      //IBSheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 240 ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false) ;
					var HeadTitle = "|Level|Menu No|Menu Name|Korean Office Name";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,    0,    daCenter,    false,   "auth");
					InitDataProperty(0, cnt++ , dtData,      70,   daCenter,    false,   "level",     false,    "",       dfNone,    0,    false,    true);
					InitDataProperty(0, cnt++ , dtData,      100,  daCenter,    false,   "pgm_no",    false,    "",       dfNone,    0,    false,    true);
					InitDataProperty(0, cnt++ , dtData,      180,  daLeft,      false,   "pgm_nm",    false,    "",       dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++ , dtHidden,    180,  daLeft,      false,   "pgm_nm",    false,    "",       dfNone,    0,    false,    false);

					WaitImageVisible = false;
					InitTreeInfo(1, "level");
			   }
			 break;


			case 2:	  //IBSheet2 init
				with (sheetObj) {

					// 높이 설정
					style.height = 240 ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다[정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle = "|STS|Program No|Program Name|Program Name" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);

					//데이터속성    [ROW,  COL,    DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,  false,   "check_val");
					InitDataProperty(0, cnt++ , dtHiddenStatus, 40,    daCenter,  false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,         100,   daLeft,    false,   "pgm_no",    true,        "",     dfNone,           0,    false,       false);
					InitDataProperty(0, cnt++ , dtData,         150,   daLeft,    false,   "pgm_nm",    true,        "",     dfNone,           0,    false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       150,   daLeft,    false,   "pgm_nm",    true,        "",     dfNone,           0,    false,       false);

					WaitImageVisible = false;
			   }
			   break;
		}
	}


	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(shtObj, frmObj, sAction) {
		shtObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:	  //조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;//role_cd 추가로 메소드 변경
				shtObj.DoSearch("ADM_SYS_0013GS.do", FormQueryString(frmObj));
				shtObj.ShowTreeLevel(1, 1);
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:  //엑셀내려받기
				shtObj.Down2Excel(true);
				break;
		}
	}


	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet2(shtObj, frmObj, sAction) {
		shtObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:	  //조회
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH01;
				shtObj.DoSearch("ADM_SYS_0013GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;

			case IBSAVE:		//저장
				if (!shtObj.IsDataModified) {
					ComShowCodeMessage("COM130503");
					return;
				} else if (ComShowCodeConfirm("COM130101", "data")) {    // Do you want to save {?msg1}?
					//저장처리
					ComOpenWait(true);
					frmObj.f_cmd.value = MULTI;
					shtObj.DoSave("ADM_SYS_0013GS.do", FormQueryString(frmObj), -1, false);
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:  //엑셀내려받기
				shtObj.Down2Excel(true);
				break;
		}
	}


	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_OnLoadFinish(shtObj) {
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet2_OnLoadFinish(shtObj) {
		doActionIBSheet2(shtObj, document.form, IBSEARCH);
	}


	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var frmObj = document.form;
		frmObj.pgm_no_form.value = sheetObj.CellValue(Row, "pgm_no");
		doActionIBSheet2(sheetObjects[1], frmObj, IBSEARCH);
	}


	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 에러가 발생했을 경우에 서버에서 리턴되는 메시지
	 */
	function sheet2_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// 저장 후  부모창 재조회
		var opener = window.dialogArguments;    // MODAL창에서 부모창 호출
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		window.close();
	}
