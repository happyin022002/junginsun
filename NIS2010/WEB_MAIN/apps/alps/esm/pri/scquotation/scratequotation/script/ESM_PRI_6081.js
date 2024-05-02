/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_6081.js
 *@FileTitle : Surcharge Adjust-Location
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.08
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2009.07.08 송민석
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
 * @class ESM_PRI_6081 : ESM_PRI_6081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_6081() {
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

var orgLocDefCd = "";
var orgViaLocDefCd = "";
var destViaLocDefCd = "";
var destLocDefCd = "";

var orgLocTpCd = "";
var orgViaLocTpCd = "";
var destViaLocTpCd = "";
var destLocTpCd = "";



// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/** 
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 *
 * @return 없음
 */ 
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {


		case "btn1_OK":
			buttonOkClick(sheetObject1)
			break;

		case "btn1_Close":
			self.close();
			break;
		case "loc_type" :
			processChangedLocType();
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
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 *
 * @param  {object}   sheet_obj 필수, sheet Object
 * @return 없음
 */ 
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}
/** 
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * 
 * @return 없음
 */ 
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComOpenWait(true);
	initParams(document.form);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	ComOpenWait(false);
}
 /**  
  * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
  * 저장해 놓는다.
  *  
  * <br><b>Example :</b>
  * <pre>
  *   initParams(formObj)
  * </pre>
  *
  * @param {object} formObj 필수, html document form Object
  * @return 없음
  */   
function initParams(formObj) {
	var args = window.dialogArguments
	var arrParams = args.Params;
	formObj.qttn_no.value = arrParams["qttn_no"];
	formObj.qttn_ver_no.value = arrParams["qttn_ver_no"];
	orgLocDefCd = arrParams["org_loc_def_cd"];
	orgViaLocDefCd = arrParams["org_via_loc_def_cd"];
	destViaLocDefCd = arrParams["dest_via_loc_def_cd"];
	destLocDefCd = arrParams["dest_loc_def_cd"];
	
	orgLocTpCd = arrParams["org_loc_tp_cd"];
	orgViaLocTpCd = arrParams["org_via_loc_tp_cd"];
	destViaLocTpCd = arrParams["dest_via_loc_tp_cd"];
	destLocTpCd = arrParams["dest_loc_tp_cd"];

	
	ComPriCheckRadioButton(formObj.loc_type, arrParams["loc_type"]);
}

/** 
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {object} sheetObj 필수, sheet Object
 * @param {String} sheetNo 필수, sheet의 ID
 * @return 없음
 */ 
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	sheetObj.WaitImageVisible = false;
	switch (sheetObj.id) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 170;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			MultiSelection = false;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Sel.|Seq.|Location Code|Description|qttn_no|qttn_ver_no|grp_loc_seq|rout_loc_tp_cd|org_dest_tp_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	"Status");
			InitDataProperty(0, cnt++, dtRadioCheck, 40, daCenter, true,"sel_chk", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq", false,	"", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "loc_def_cd",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, true,	"prc_grp_loc_desc", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_no",false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_ver_no",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "grp_loc_seq",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true,	"rout_loc_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "org_dest_tp_cd", false, "", dfNone, 0, false, true);

			CountPosition = 0;

		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 170;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			MultiSelection = false;
			SelectHighLight = false;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Location Code|Description";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					"Status");

			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq", false,	"", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "loc_cd",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "loc_nm", false, "", dfNone, 0, false, true);

			CountPosition = 0;
			PopupImage = "img/btns_search.gif";
			ShowButtonImage = 1;

		}
		break;
	}
}
 
 /**  
 * HTML Radio Object에서 check된 index에 해당하는 <BR> 
 * value값을 찾아서 return한다.
 *  
 * <br><b>Example :</b>
 * <pre>
 *   locType = getRadioSelectedValue(formObj.loc_type); // check된 radio button의  value
 * </pre>
 *
 * @param {object} radioObj 필수, html document radio Object
 * @return string, check된 radio의 value
 */   
function getRadioSelectedValue(radioObj) {
	var rValue = "";
	for ( var i = 0; i < radioObj.length; i++) {
		if (radioObj[i].checked) {
			rValue = radioObj[i].value;
			break;
		}
	}
	return rValue;
}
/** 
 * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {object} sheetObj 필수, sheet Object
 * @param {object} formObj 필수, html document form Object
 * @param {int} sAction 필수, action의 구분
 * @return 없음
 */  
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var locType = getRadioSelectedValue(formObj.loc_type);

	switch (sAction) {
	case IBSEARCH: //조회
		switch (sheetObj.id) {
		case "sheet1":
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;

			var params = FormQueryString(formObj) + "&table_cd=SP"

			if (locType == "OG" || locType == "DS") {
				params = params + "&select_type=ORI"
			} else if (locType == "OV" || locType == "DV") {
				params = params + "&select_type=VIA"
			}
			if (locType == "OG" || locType == "OV") {
				params = params + "&org_dest_tp_cd=O"
			} else if (locType == "DS" || locType == "DV") {
				params = params + "&org_dest_tp_cd=D"
			}

			sheetObj.DoSearch("ESM_PRI_6081GS.do", params);
			ComOpenWait(false);
			break;
		case "sheet2":
			ComOpenWait(true);
			if (validateForm(sheetObj, formObj, sAction)){
				formObj.f_cmd.value = SEARCH02;
			}
			var selectedRow = sheetObjects[0].SelectRow;
 			
			var param = FormQueryString(formObj) + "&table_cd=SP";
			param = param + "&grp_loc_seq="	+ sheetObjects[0].CellValue(selectedRow, "grp_loc_seq");
			param = param + "&loc_cd=" + sheetObjects[0].CellValue(selectedRow, "loc_def_cd");
			param = param + "&rout_loc_tp_cd=" + sheetObjects[0].CellValue(selectedRow, "rout_loc_tp_cd");
			sheetObj.DoSearch("ESM_PRI_6081GS.do", param);
			ComOpenWait(false);
			break;

		}
		break;
	}
}

 /** 
  *  OK 버튼에 대한 프로세스 처리<BR>
  *  팝업을 닫기전 return 값을 assign한후 화면을 닫는다.
  * <br><b>Example :</b>
  * <pre>
  *      buttonOkClick(sheetObjects[0]);
  * </pre>
  * @param {object} sheetObj 필수, sheet Object
  * @return 없음
  */  	
function buttonOkClick(sheetObj) {
	var rtnObject = new Object();
	rtnObject.orgLocDefCd = orgLocDefCd;
	rtnObject.orgViaLocDefCd = orgViaLocDefCd;
	rtnObject.destViaLocDefCd = destViaLocDefCd;
	rtnObject.destLocDefCd = destLocDefCd;
	
	rtnObject.orgLocTpCd = orgLocTpCd;
	rtnObject.orgViaLocTpCd = orgViaLocTpCd;
	rtnObject.destViaLocTpCd = destViaLocTpCd;
	rtnObject.destLocTpCd = destLocTpCd;
	
	window.returnValue = rtnObject;
	self.close();
}

/** 
* sheet에서 check box에 check(선택된)된 row의<BR>
* location정보를 global 변수에 저장해 놓는다.
* <br><b>Example :</b>
* <pre>
*       setLocationRoutePoint(sheetObj,sheetObj.MouseRow,"sel_chk");
* </pre>
* @param {object} sheetObj 필수, sheet Object
* @param {int} selectedRow 필수, 선택된 row index
* @param {string} col 필수, 선택된 col name
* @return 없음
*/    
 function setLocationRoutePoint(sheetObj,selectedRow,col){
	 	var formObj = document.form;
		var locType = getRadioSelectedValue(formObj.loc_type);
		
		var locDefCd = "";
		var locTpCd = "";
		
		var selRow = sheetObj.FindCheckedRow(col);
		if( selRow != "" ){
			var arrRow = selRow.split("|")
			//uncheck한 것임
			if( arrRow[0] == selectedRow ){
				locDefCd = "";
				locTpCd = "";
			}else{
				locDefCd = sheetObj.CellValue(selectedRow,"loc_def_cd");
				locTpCd = sheetObj.CellValue(selectedRow,"rout_loc_tp_cd");
			}
		}else{
			locDefCd = sheetObj.CellValue(selectedRow,"loc_def_cd");
			locTpCd = sheetObj.CellValue(selectedRow,"rout_loc_tp_cd");
		}
		

		
		if (locType == "OG" ){
			orgLocDefCd = locDefCd;
			orgLocTpCd = locTpCd;
		}else if( locType == "OV") {
			orgViaLocDefCd = locDefCd;
			orgViaLocTpCd = locTpCd;
		}else if (locType == "DS" ){
			destLocDefCd = locDefCd;
			destLocTpCd = locTpCd;
		}else if( locType == "DV") {
			destViaLocDefCd = locDefCd;
			destViaLocTpCd = locTpCd;
		}	 
		
 }

 /** 
  * radio button이 클릭되 route point type이 바뀌면<BR>
  * 그에 맞는 정보를 재 조회 한다.
  * 
  * <br><b>Example :</b>
  * <pre>
  *       processChangedLocType();
  * </pre>
  * @return 없음
  */    
 function processChangedLocType(){
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 }
 
 
 /** 
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  * <br><b>Example :</b>
  * <pre>
  *      if (!validateForm(sheetObj,document.form,sAction)) {
  *          return false;
  *       }
  * </pre>
  * @param {object} sheetObj 필수, sheet Object
  * @param {object} formObj 필수, html document form Object
  * @param {int} sAction 필수, action의 구분
  *
  * @return boolean, true: 유효, false: 비유효
  */ 
function validateForm(sheetObj, formObj, sAction) {

	return true;
}

/** 
 * sheet를 마우스 클릭 했을경우 자동 호출됨 
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {int} x 필수, X 좌표
 * @param {int} y 필수, Y 좌표
 * @return 없음
 */  
function sheet1_OnMouseDown(sheetObj, shift, x, y) {
	if (sheetObj.ColSaveName(sheetObj.MouseCol) == "sel_chk") {
		setLocationRoutePoint(sheetObj,sheetObj.MouseRow,"sel_chk");
	}
}
 
 /** 
  * sheet를 마우스 클릭 했을경우 자동 호출됨 
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * @param {object} sheetObj 필수, sheet Object
  * @param {int} row 필수, 클릭된 row index
  * @param {int} col 필수, 클릭된 col index
  * @param {string} value 필수, 클릭된 cell의 값
  * @return 없음
  */    
function sheet1_OnClick(sheetObj, row, col, value) {
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
}
 
  /** 
   * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
   * <br><b>Example :</b>
   * <pre>
   * </pre>
   * @param {object} sheetObj 필수, sheet Object
   * @param {String} ErrMsg 필수, sheet의 결과 메시지
   * @return 없음
   */    
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	var formObj = document.form;
	if (sheetObj.SearchRows != 0) {
		var locType = getRadioSelectedValue(formObj.loc_type);
		
		var routePoint = "";

		
		if (locType == "OG" ){
			routePoint = orgLocDefCd;
		}else if( locType == "OV") {
			routePoint = orgViaLocDefCd;
		}else if (locType == "DS" ){
			routePoint = destLocDefCd;
		}else if( locType == "DV") {
			routePoint = destViaLocDefCd;
		}
		var row = sheetObj.FindText("loc_def_cd", routePoint);
		if (row >= 0) {
			sheetObj.CellValue2(row, "sel_chk") = 1;
		} else {
			row = sheetObj.HeaderRows;
		}
		sheetObj.SelectRow = row;
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
}
/* 개발자 작업  끝 */