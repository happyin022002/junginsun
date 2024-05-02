/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0034_07.js
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
	 * @class ESM_BKG_0034_07 : ESM_BKG_0034_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_0034_07() {
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

		// 페이지 로드 후 조회 되도록 해당 tab을 다시 호출하여 로드 
    	parent.loadTabPage(6);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
				// 높이 설정
				style.height = 280;
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
				InitColumnInfo(12, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Seq.|AMS File No.|Filer|F/O/C|Piece Count|Piece Count|IT No.|HUB|DEL|CNTR No.|TY/SZ|Consignee";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);


				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,		35,		daCenter,	false,		"Seq");
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		"bl_no",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"cstms_file_tp_cd",		false,		"",	dfUserFormat2,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,		"foc",					false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"pck_qty",				false,		"",	dfNone,		0,		false,		false);

				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,		"ams_pck_tp_cd",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"ibd_trsp_no",			false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,		"hub_loc_cd",			false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,		"del_cd",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		"cntr_no",				false,		"",	dfNone,		0,		false,		false);

				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,		"cntr_tpsz_cd",			false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		false,		"cnee",					false,		"",	dfNone,		0,		false,		false);

				InitUserFormat2(0, "cstms_file_tp_cd", "00", "" );
				
				WordWrap = true;

				//카운트를 표시할 포지션 /0의 경우 비표시 
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
		sheetObj.WaitImageVisible = false;
		
		switch (sAction) {
			case IBSEARCH: // 조회
				if (validateForm(sheetObj,formObj,sAction)) {
//					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_BKG_0034_07GS.do", FormQueryString(formObj));
//					ComOpenWait(false);
				}
				break;
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
		}
	}

	/**
	 * 탭 클릭 시 조회
	 */
	function tabLoadSheet(strBlNo) {
		//alert("tabLoadSheet: 7");
		var formObject = document.form;
		
		if (formObject.bl_no.value != strBlNo) {
			formObject.bl_no.value = strBlNo;
			
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
	}

	/**
	 * 탭 데이터 초기화
	 */
	function tabClearSheet() {
		document.form.bl_no.value = "";
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
	
	/* 개발자 작업 끝 */