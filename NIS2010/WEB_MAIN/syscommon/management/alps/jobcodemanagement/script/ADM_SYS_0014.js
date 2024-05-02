/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ADM_SYS_0014.js
*@FileTitle : Job Code user Inquiry
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
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 /******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			/***********************************************************************************************************
				이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
				공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.
			 **********************************************************************************************************/

			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			  case "btn_close":
					self.close();
					break;

			  case "btn_downexcel":
				  doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
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

/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

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
//		alert('loadPage1');

		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

	  var formObject = document.form;
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			doActionIBSheet2(sheetObjects[1],formObject,IBSEARCH);
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
					style.height = 265 ;
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
					InitColumnInfo(4, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false) ;
					var HeadTitle = "Level|OfficeCode|English Office Name|Korean Office Name";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
					//데이터속성    [ROW, 	COL,  	DATATYPE,   	WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtCheckBox,   20,  	daCenter,    false,   	"checkbox");
					InitDataProperty(0, cnt++ , dtData,       	70,  	daCenter,    false,   	"level",        false,        "",       dfNone,     0,       false,       true);
					InitDataProperty(0, cnt++ , dtData,       	80,  	daCenter,    false,   	"ofc_cd",       false,        "",       dfNone,     0,       false,       false);
					InitDataProperty(0, cnt++ , dtData,      	180, 	daLeft,      false,   	"ofc_eng_nm",   false,        "",       dfNone,	   	0,       false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	180, 	daLeft,      false,   	"ofc_krn_nm",   false,        "",       dfNone,	   	0,       false,       false);

					WaitImageVisible = false;

					InitTreeInfo(0, "level");
			   }
			 break;
			case 2:	  //IBSheet2 init
				with (sheetObj) {

					// 높이 설정
					style.height = 265 ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 14, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(7, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다[정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Sel.|STS|User ID|User Name|Updated by|Updated Date|User Local Name" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);

					//데이터속성    [ROW,  COL,    DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCheckBox,     50,    daCenter,  false,   "check_val");
					InitDataProperty(0, cnt++ , dtHiddenStatus, 40,    daCenter,  false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,         80,    daCenter,    false,   "usr_id",           true,        "",     dfNone,           0,    false,       false);
					InitDataProperty(0, cnt++ , dtData,        120,    daCenter,    false,   "usr_nm",           true,        "",     dfNone,           0,    false,       false);
					InitDataProperty(0, cnt++ , dtData,        120,    daCenter,    false,   "upd_usr_id",           false,        "",     dfNone,           0,    false,       false);
					InitDataProperty(0, cnt++ , dtData,         80,    daCenter,    false,   "upd_dt",           false,        "",     dfNone,           0,    false,       false);
					InitDataProperty(0, cnt++ , dtHidden,      150,    daLeft,    false,   "usr_locl_nm",      true,        "",     dfNone,           0,    false,       false);

					WaitImageVisible = false;
			   }
			   break;
		}
	}


	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ADM_SYS_0014GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}

	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ADM_SYS_0014GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBSAVE:		//저장
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ADM_SYS_0014GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}

	function chkBox(checked) {
		if(checked==true)
		{
			for(var idx = 1; idx <= sheetObjects[1].RowCount; idx++){
				if(sheetObjects[1].CellValue(idx,'check_val') == 1 ){
					sheetObjects[1].RowHidden(idx) = false;
				} else {
					sheetObjects[1].RowHidden(idx) = true;
				}
			}
		} else {
			for(var idx = 1; idx <= sheetObjects[1].RowCount; idx++) {
				sheetObjects[1].RowHidden(idx) = false;
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */
	function sheet1_OnDblClick(shtObj, Row, col){
		var formObject = document.form;
		formObject.ofc_cd.value = sheetObj.CellValue(Row,"ofc_cd");
		doActionIBSheet2(sheetObjects[1], formObject, IBSEARCH);
		if(formObject.showAll.checked) chkBox(true);
	}
