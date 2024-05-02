/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0001.js
*@FileTitle : 항목별 조건목록 등록
*Open Issues :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2006-10-26 IM OKYOUNG
* 1.0 최초 생성
* =========================================================
*Change history :
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2008.09.09 전성진 CSR No.N200808228856
* 					- [001] Special Type Size 관련 쿼리 변경 
* 2009.07.10 박은주 New Framework 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
=========================================================*/ 

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btng_Save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;

			case "btn_Close":
				window.close();
			break;

			case "btng_RowAdd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
		      ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i]);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj) {

	var cnt = 0;
	with (sheetObj) {

	SheetWidth = mainTable.clientWidth;						//전체 너비 설정
	if (location.hostname != "")
		InitHostInfo(location.hostname, location.port, page_path);		//Host정보 설정[필수][HostIp, Port, PagePath]
	MergeSheet = msHeaderOnly;									//전체Merge 종류 [선택, Default msNone]
	Editable = true;														//전체Edit 허용 여부 [선택, Default false]
	InitRowInfo( 2, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	InitColumnInfo(7, 0, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	InitHeadMode(false, false, false, true, false,false)		//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

	var HeadTitle0 = "Del.|STS|Seq.|EQ|SP Group / EQ Repo. Contribution|SP Group / EQ Repo. Contribution|SP Group / EQ Repo. Contribution" ;
	var HeadTitle1 = "Del.|STS|Seq.|EQ|SP CNTR|Repo.Chk|Desc" ;

	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	InitHeadRow(0, HeadTitle0, true);
	InitHeadRow(1, HeadTitle1, false);

	//데이터속성[row,col,			datatype,	 width,	dataalign,	colmerge,  savename,			keyfield,	calculogic,	dataformat,	pointcount,	 updateedit,	insertedit,	editlen,fullinput,sortenable,tooltip,allcheck,savestatus,formatfix]
	InitDataProperty(0,cnt++,	dtCheckBox,		30,	daCenter,	true,	   "delt_flg");
	InitDataProperty(0,cnt++,	dtStatus,		30,	daCenter,	true,	   "ibflag");
	InitDataProperty(0,cnt++,	dtSeq,			30,	daCenter,	true,	   "",				     false,		"",		dfNone,		0,		false,		false);
	InitDataProperty(0,cnt++,	dtData,			40,	daCenter,	true,      "cntr_tpsz_cd",	     true,		"",		dfNone,		0,		true,		true,	2);
	InitDataProperty(0,cnt++,	dtData,		    60,	daCenter,	true,      "spcl_cntr_tpsz_cd",  false,		"",		dfNone,		0,		true,		true,	3);
	InitDataProperty(0,cnt++,	dtCheckBox,		60,	daCenter,	true,      "repo_flg",           false,		"",		dfNone,		0,		true,		true);
	InitDataProperty(0,cnt++,	dtData,			60,	daLeft,		true,      "list_bx_desc",	     false,		"",		dfNone,		0,		true,		true,	100);

	CountPosition  = 0 ;
	RangeBackColor(1, 3, 1, 6) = RgbColor(222, 251, 248);// ENIS
	style.height = GetSheetHeight(12) ;
	}
}

/*화면이 로드 되면서 바로 retrieve 되도록 */
function setRetrieveAction(){
	sheetObject = sheetObjects[0];
	formObject = document.form;
	
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSEARCH:		//조회
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch4Post("ESM_MAS_0001GS.do", masFormQueryString(formObj, 'select'));
			ComOpenWait(false);
			break;

		case IBSAVE:				//저장
			if(validateForm(sheetObj,formObj,sAction)){
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_MAS_0001GS.do", masFormQueryString(formObj, 'select'));
			//sheetObj.DoAllSave("ESM_MAS_0001GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			}
			break;

		case IBINSERT:			// 입력
			sheetObj.DataInsert();
			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	//	if (!isNumber(iPage)) {
	//
	//		return false;
	//	}
	}

	return true;
}
