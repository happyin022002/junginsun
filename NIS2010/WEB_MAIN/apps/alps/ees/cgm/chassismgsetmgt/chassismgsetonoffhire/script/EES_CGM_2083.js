/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2083.js
 *@FileTitle : Chassis Type/Size Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.05.19 박의수
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
 * @class ees_cgm_2083 : ees_cgm_2083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2083() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
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
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	//var sheetObject2 = sheetObjects[1];

	/** *****************************************************/
	var formObject = document.form;

	//스크립트 에러 위치를 확인하기 위해 주석처리
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			//alert("btn_retrieve");
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_save":
			//alert("btn_save");
			doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;

		case "btn_add":
			//alert("btn_add");
			doActionIBSheet(sheetObject1,formObject,IBINSERT);
			break;

		case "btn_del":
			//alert("btn_del");
			doActionIBSheet(sheetObject1,formObject,REMOVE);
			break;

		} // end switch
		tRoleApply();
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
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.10.20
 */     
 function sheet1_OnLoadFinish(sheetObj) {
     sheetObj.WaitImageVisible = false;
  
 	 for (i = 0; i < sheetObjects.length; i++) {
		 doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	 }
 	
     doActionIBSheet(sheetObj,document.form,IBCLEAR);
     tRoleApply();
     sheetObj.WaitImageVisible = true; 
 }

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 240;
			
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// 헤더에서 전체 선택 기능을 해제 세번째 파라메타를 false 로 변경
			InitHeadMode(true, true, false, true, false, false);
			var HeadTitle = "|Sel|M.G.Set Type|Description|eq_knd_cd";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix="sheet1_";

            InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	false,     prefix + "ibflag",		false);
            InitDataProperty(0, cnt++ , dtCheckBox,		80,		daCenter,	false,     prefix + "del_chk",		false);
            InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	false,     prefix + "eq_tpsz_cd",	false,    "",      dfNone,	0,	true,	true,	3);
            InitDataProperty(0, cnt++ , dtData,			350,	daLeft,		false,     prefix + "diff_desc",		false,    "",      dfNone,	0,	true,	true,	40);
            InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,     prefix + "eq_knd_cd",		false,    "",      dfNone,	0,	false,	false,	1);
		}
		//값 입력 조건 제한
		sheetObj.InitDataValid(0, prefix + "eq_tpsz_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	//sheetObj.ShowDebugMsg = false;
	var form = document.form;
	var sheetObject1 = sheetObjects[0];
	switch (sAction) {

	case IBSEARCH: // 조회
	
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);	
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("EES_CGM_2083GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		
		ComOpenWait(false);	
		break;

	case IBSAVE: // 저장
		// 필수 입력값 검증
		var actionFlag = true; 

		for(i=1; i<=sheetObj.rowCount; i++){
			var invEqTpszCd = sheetObj.CellValue(i, prefix + "eq_tpsz_cd");
			var invDiffDesc = sheetObj.CellValue(i, prefix + "diff_desc");

			// 필수 입력값 검증
			if(invEqTpszCd == "" || invEqTpszCd == null) {
				ComShowCodeMessage("CGM10004", "M.G.Set Type");

				sheetObj.SelectCell(i, prefix + "eq_tpsz_cd", true);
				return;
			}

			if(invDiffDesc == "" || invDiffDesc == null){
				ComShowCodeMessage("CGM10004", "Description");

				sheetObj.SelectCell(i, prefix + "diff_desc", true);

				// 저장처리 수행여부 Flag 설정
				actionFlag = false;

				// 그리드에 포커스 이동 및 해당 컬럼에 편집 가능 모드로 수정
				sheetObj.focus();

				break;
			}
		}

		if(actionFlag){
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);				
			//alert(" Save ... ");
			formObj.f_cmd.value = MULTI;
			if(sheetObj.DoSave("EES_CGM_2083GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_")))
 			{
 				ComShowCodeMessage("CGM00003");
 			}else
 			{
 				
 			}
			
			ComOpenWait(false);				
		}
		break;

	case IBINSERT: // 입력
		//alert(" Add ...  ");
		sheetObj.DataInsert();
		
		// 히든 컬럼값 셋팅(CUD Query에서 필수 컬럼값)
		for(i=1; i<sheetObj.rowCount+1; i++){
			sheetObj.CellValue(i, prefix + "eq_knd_cd") = document.forms[0].eq_knd_cd.value;			
		}
        break;

	case REMOVE: // 삭제
	
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);	
		//alert(" Delete ... ");
	
		var sRow = sheetObject1.FindCheckedRow("sheet1_del_chk");
		var arrRow = sRow.split("|");
	 					
		for(var i=arrRow.length-2; i>=0; i--){
			formObj.f_cmd.value = SEARCH01;
			formObj.eq_tpsz_cd.value = sheetObject1.CellValue(arrRow[i],"sheet1_eq_tpsz_cd" );
			var sXml = sheetObject1.GetSearchXml("EES_CGM_2083GS.do", FormQueryString(formObj));
			// 데이터 건수
			var dataCount = ComGetTotalRows(sXml);
			if(dataCount > 0){
				// a.You cannot delete specification number with chassis. Please contact system manager.
				ComShowCodeMessage('CGM10070');
				ComOpenWait(false);	
				return;
			}
		}
		ComOpenWait(false);	
		
		ComRowHideDelete(sheetObject1,"sheet1_del_chk");
		break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}


/**
 * M.G.Set 중복 체크
 */
function sheet1_OnChange(sheetObj, Row, Col){
	var sheetObj = sheetObjects[0];
 	var formObj = document.form;
 	var prefix = "sheet1_";
 	var invRefNoCol = sheetObj.SaveNameCol(prefix + "eq_tpsz_cd");

 	if (Col == invRefNoCol && Row !=0) { 
 		var CellValue = sheetObj.cellValue(Row, Col);
 		var Row2 = sheetObj.FindText(Col, CellValue, -1);
	
 		if(Row2 > 0){
 			Row2 = sheetObj.FindText(Col, CellValue, Row2+1);
       
 			if (Row2 > 0) {
	        	//alert('CGM10017');
 				ComShowCodeMessage("CGM10017", "M.G.Set Type");
				// 해당 Cell 값을 Null로 설정
				sheetObj.CellValue2(Row, Col) = '';
				// 그리드에 포커스 이동
				sheetObj.SelectCell(Row, Col, true);
 			}
		}
	}
}

 /**
 * 기능(ex:btn_save)에 권한(trole) 적용  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2010.03.05
 */     
 function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_add");
		  ComBtnDisable("btn_del");
		  ComBtnDisable("btn_save");
	  }
 }  
/* 개발자 작업 끝 */
