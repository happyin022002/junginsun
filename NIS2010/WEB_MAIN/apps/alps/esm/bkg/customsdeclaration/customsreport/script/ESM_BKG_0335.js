/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0335.js
*@FileTitle : customs entry type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * 	JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0335()
{
	this.processButtonClick 	= processButtonClick;
	this.setSheetobject			= setSheetObject;
	this.loadPage				= loadPage;
	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
	this.obj_keypress			= obj_keypress;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.sheet1_OnClick			= sheet1_OnClick;
	this.select					= select;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var selRow = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_Select":
			doActionIBSheet(sheetObjects[0],formObject,SEARCH11);
			break;

		case "btn_Add":
			doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
			break;
			
		case "btn_Del":
			doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;

		case "btn_Close":
			window.close();
			break;
			
		case "btn_downexcel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;

		} // end switch
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
    			
}

/**
 * Sheet1 로드 완료 후 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;
	
	if (form.view_type.value=='create') {
		// CREATE 화면에서 호출할 경우  버튼 활성화
		ComBtnEnable("btn_Del");
		ComBtnEnable("btn_Add");
	}else {
		ComBtnDisable("btn_Del");
		ComBtnDisable("btn_Add");
		ComBtnDisable("btn_Save");
	}
	//if (form.cnt_cd.value.length > 1) doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 142;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;
		var CellEditable1 = false;
		if (document.form.view_type.value=='create') CellEditable1 = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 2, 100);

		var HeadTitle1 = "flag|Sel.|Seq.|Code|Name|Country";
		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	 	false,  	"ibflag");
		InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,		false,		"Sel",				false,	"",      dfNone,	0,		true,			true);
		InitDataProperty(0, cnt++ , dtSeq,	        40,		daCenter,	    false,		"Seq",	            false,	"",	     dfNone,	0,	    false,          false);
		InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		"cstms_entr_cd",	true,	"",      dfNone,	0,		false,			true,	2, true);
		InitDataProperty(0, cnt++ , dtData,			30,		daLeft,			true,		"entr_nm",			false,	"",      dfNone,	0,		CellEditable1,	true);
		InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,			true,		"cnt_cd");

		CountPosition = 2;
		//조회 창이면 Sel 칼럼을 숨기고 팝업일 경우와 creation 화면일 경우만 Sel이 보이게 한다.
		if (location.href.indexOf("pgmNo=ESM_BKG_0335_Q") > 0 ){
			ColHidden("Sel") = true;
		}
	}
	break;


	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		formObj.f_cmd.value = SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0335GS.do", FormQueryString(formObj));
			sheetObjects[0].Redraw = false; 
			sheetObjects[0].LoadSearchXml(sXml);
			sheetObjects[0].Redraw = true;
			ComOpenWait(false);
		}
		ComBtnDisable("btn_Save");
		break;

	case IBINSERT:      // 입력
		sheetObj.DataInsert(-1);
		ComBtnEnable("btn_Save");
		break;
	
	case IBDELETE:
		ComRowHideDelete(sheetObj,"Sel");
		ComBtnEnable("btn_Save");
		break;
		
	case IBSAVE:	// 추가/수정/삭제
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			ComBtnDisable("btn_Save");
			sheetObj.DoSave("ESM_BKG_0335GS.do", FormQueryString(formObj), -1, false);
			ComOpenWait(false);
			// 처리하고 나면 한번 더 조회한다
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	
	case SEARCH11:	// SELECT 버튼				
	    select(sheetObj, sheetObj.selectRow, '');
		break;	
		
	case IBDOWNEXCEL: // 엑셀
	if(!validateForm(sheetObj,formObj,sAction)) return false;

       var columnSkipList = "";
  
	     columnSkipList = "ibflag|Sel|cnt_cd";
  
         sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, columnSkipList, "");
			
	break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.cnt_cd.value.length < 2) {
			ComShowCodeMessage('BKG00186');
			formObj.cnt_cd.focus();
			return false;
		}
	}

	return true;
}

/**
 * 키 입력 처리
 * @return
 */
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
		else ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet(); break;
	case "engup":
		ComKeyOnlyAlphabet('upper'); break;
	case "engupnum":
		ComKeyOnlyAlphabet('uppernum'); break;
	case "engdn":
		if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
		else ComKeyOnlyAlphabet('lower');
		break;
	}
}

/**
 * 시트 Change 이벤트
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){

	var formObject = document.form;
	sheetObj.WaitImageVisible = false;
	try {
		sheetObj.CellValue(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
		sheetObj.CellValue(Row, "cnt_cd") = formObject.cnt_cd.value;
	}catch(e) {}
	if (formObject.view_type.value=='create') ComBtnEnable("btn_Save");
}
 
/**
 * 하나만 선택되게 하기
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	sheetObj.CheckAll("Sel")=0;
	sheetObj.CellValue(Row, "Sel") = 1;
	selRow = Row;
}

/**
 * select 버튼 클릭시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function select(sheetObj,Row,Col) {

	if (sheetObj.CellValue(sheetObj.selectRow, 'cstms_entr_cd').length < 1) {
		// 조회선택된것이 없는 경우 패스
	}else {
		try{    	
			var obj = new Object(); 
			obj.cd = sheetObj.CellValue(selRow, "cstms_entr_cd");
			window.returnValue = obj.cd;
			self.close();
		}catch(e){}
	}

}