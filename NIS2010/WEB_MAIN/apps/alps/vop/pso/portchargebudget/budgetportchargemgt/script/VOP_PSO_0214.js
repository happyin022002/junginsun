/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0214.js
 *@FileTitle : Invoice Summary Detail
 *Open Issues :
 *Change history : 
 *@LastModifyDate : 2011.03.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.12.09
 * 1.0 Creation
 * 
 * History
 * 2010.09.15 CHM-201005696-01 진마리아 지점및 지역 본부에서 Port charge inovice summary 수정 변경
 * 										1) CSR I/F Inquiry와 동일한 기능은 CSR I/F Inquiry화면에 invocie No.로 조회하는 기능 추가하여 Port charge inovice summary 메뉴에서는 해당 기능을 삭제
 *										2) 지역본부및 office별, Port별 S/P No.로 발생한 Actual invoice를 조회하기 위한 조건 추가및 Grid내 칼럼 추가
 * 2011.03.04 CHM-201109192-01 진마리아 Detail버튼 클릭 시 팝업화면 맨뒤 항목에 Remark 추가
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
 */
function VOP_PSO_0214() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;    	
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
﻿// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_DownExcel":
				sheetObjects[0].SpeedDown2Excel(-1);
				break;
			
			case "btn_close":
				self.close();
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}


/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);

		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}

	initControl(sheetObjects[0]);  

	ComOpenWait(true);
	xsheet1_OnLoadFinish(sheetObjects[0]);
	ComOpenWait(false);
}

/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  {object} sheetObj	필수
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */
function initControl(sheetObj){
	// Form 객체 선언
	var formObj = document.form;
	// axon event 등록
}


/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 280;
			
			MultiSelection = false;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "CSR No.|INV.No.|Status|VVD|Rev Lane|Rev DIR|Account Code|Cost Code|Cost Code\nDescription|I/O|Tariff Cost|Adjustment\nCost|Amount|Formula|Formula|Remark";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,		prefix+"csr_no",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,		prefix+"inv_no",  		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		prefix+"status",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"vvd",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"rlane_cd",   	false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"rev_dir_cd",   	false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		prefix+"acct_cd",		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix+"cost_cd",  		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,		prefix+"cost_nm",  		false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		prefix+"io",  			false,		"",			dfNone,			0,		true,  		true);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	false,		prefix+"calc_amt",   	false,		"",			dfNullFloat,	2,		true,  		true);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	false,		prefix+"adj_amt",   	false,		"",			dfNullFloat,	2,		true,  		true);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	false,		prefix+"locl_amt",   	false,		"",			dfNullFloat,	2,		true,  		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,		prefix+"xpr_desc",   	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,		prefix+"foml_desc",   	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,		prefix+"rmk",   	false);


			CountPosition = 0;
			ShowButtonImage = 1;
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // 조회
			var aryPrefix = new Array( "sheet1_");       
			formObj.f_cmd.value = SEARCH;
			
			sheetObjects[0].WaitImageVisible = false;
			sheetObjects[0].Redraw = false;

			var sXml = sheetObj.GetSearchXml("VOP_PSO_0214GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			
			sheetObjects[0].LoadSearchXml(arrXml[0]); 
			sheetObjects[0].Redraw = true;
			
		break;

	}
}

/********************************************************************************************************************
 * <OnLoadFinish : OnLoadFinish가 OnLoad보다 먼저 발생하여 문제가 되므로, 이의 해결을 위해 loadPage()에서 xsheet1_OnLoadFinish()을 호출함>                                       
 ********************************************************************************************************************
 *                                                    
 ********************************************************************************************************************/
function xsheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;
	var port = document.getElementById("port_cd").value;
	
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
//뭐임이건
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var prefix = "sheet1_";
	
	//Sub Sum
	//sheetObj.ShowSubSum("vvd", "calc_amt|locl_amt|usd_amt", -1, false, false, 0, "1=;6=Sub Total;7=");
	sheetObj.ShowSubSum(prefix + "vvd", prefix + "calc_amt" + "|" + prefix + "adj_amt" + "|" + prefix + "locl_amt", -1, false, false, 1, "1=SUB. Total");
	
	//Total Sum
	//sheetObj.SumText(0, prefix + "vvd") = "Grand TTL";
	sheetObj.SumText(0, prefix + "csr_no") = "";
	sheetObj.SumText(0, prefix + "rlane_cd") = "Grand TTL";
	//sheetObj.SumText(0, prefix + "rev_dir_cd") = "Grand TTL";
	//sheetObj.SetMergeCell(sheetObj.LastRow, 0, 1, 3);
	sheetObj.CellAlign(sheetObj.LastRow, prefix + "rlane_cd") = daCenter;
}

	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
 		var prefix = sheetObj.id+"_";
 		var Row = sheetObj.MouseRow;
 		var Col = sheetObj.MouseCol;
 		var colName = sheetObj.ColSaveName(Col);
 		sheetObj.MouseToolTipText="";
 		
 		if(Row>=sheetObj.HeaderRows && Row!=sheetObj.LastRow-1 && colName==prefix+"rmk"){
 			var tipText = sheetObj.CellText(Row, prefix + "rmk");
 			sheetObj.MouseToolTipText = tipText;
 		}
 	}

/* 개발자 작업  끝 */