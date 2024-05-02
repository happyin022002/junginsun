/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EES_DMT_7018.js
 *@FileTitle : RHQ 하위 Office 조회팝업
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.29
 *@LastModifier : 이성훈
 *@LastVersion : 1.0
 * 2015.01.29 이성훈
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
	 * @class EES_DMT_7018 : EES_DMT_7018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_DMT_7018() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";

	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_close":
					window.close();
				break;
				
				case "btn_apply":
					comPopupOK();
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		
		//페이지 로딩시 그리드 데이터 조회
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: //sheet1 init
			with (sheetObj) {
	
				// 높이 설정
		    	style.height = 337;
				SheetWidth = mainTable.clientWidth;
		
			 	// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
		
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
		
				var HeadTitle = "||Seq.|Office|Office Name";
				var headCount = ComCountHeadTitle(HeadTitle);
		
		        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		        InitColumnInfo(headCount, 0, 0, true);
		
		        // 해더에서 처리할 수 있는 각종 기능을 설정한다
		        InitHeadMode(true, true, true, true, false, false);
		        
		        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		        InitHeadRow(0, HeadTitle, true);
		        
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	 30,	daCenter,	true,	"ibflag");   
                InitDataProperty(0, cnt++,	dtCheckBox,		 30,	daCenter,	true,  	"checkbox");		
                InitDataProperty(0, cnt++ , dtSeq,       	 30,    daCenter,  	false,  "seq",     		false,      "",     dfNone,   	0,      false,       true);
				InitDataProperty(0, cnt++ , dtData,		 	 70,	daCenter,	true,	"ofc_cd",		false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		 	300,	daCenter,	true,	"ofc_eng_nm",	false,		"",		dfNone,		0,		false,		false);

		        ShowButtonImage = 2;
			}
			break;
		}
	
	}
	/**
	 * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
	 * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {form}    formObj     Form Object
	 * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
	 * @param {String}  gubun     	처리할 gubun 값
	 **/
	function doActionIBSheet(sheetObj, formObj, sAction) {
		
		switch (sAction) {
			case IBSEARCH: //조회
				//1. [RHQ] 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,  COMMAND21); // DMTCommonSC.searchSubOfficeListByRHQ
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
            	//1.Office Combo - setting
				searchLoadXml(ComGetEtcData(sXml, "OFC_CD"));

			break;
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {form} formObj     	화면 form Object
	 * @param {ibsheet} sAction     IBSheet Object
	 * @param {String}  value    	sheetObj의 입력값
	 * @return {boolean} 정상 여부
	 * @see #ComChkValid
	 **/
	function validateForm(sheetObj, formObj, sAction) {
	
		return true;
	}
	
	/*
	 * 조회결과를 Grid 에 매핑해준다.
	 */
	function searchLoadXml(sXml) {
		var arrRowData = sXml.split(ROWMARK);

		for (var i=0; i<arrRowData.length; i++) {
			
			var arrColData = arrRowData[i].split(FIELDMARK);

			var nRow = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(nRow, "ofc_cd")     = arrColData[0];
			sheetObjects[0].CellValue(nRow, "ofc_eng_nm") = arrColData[1];
		}
	}
	
	/* 개발자 작업  끝 */