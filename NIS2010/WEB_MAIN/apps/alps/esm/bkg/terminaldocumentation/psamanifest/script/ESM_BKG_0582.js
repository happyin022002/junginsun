/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0582.js
*@FileTitle : PSA Port Registeration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0582()
{
	this.processButtonClick		= processButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
	this.resetForm				= resetForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;

		case "btn_new":
			resetForm();	
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;

		case "btn_rowAdd":
			sheetObjects[0].DataInsert(-1);
			break;

		case "btn_delete":
			if(ComShowCodeConfirm('BKG95003', 'delete')){ 
				doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			}
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

	// Key 입력 처리
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
	case 1:      //sheet1 init
	with (sheetObj) {

		//AutoSizeMode = false;
		// 높이 설정
		//style.height = 100;
		//전체 너비 설정
		//SheetWidth = 300;
		
		///AutoSizeMode = false;
		// 높이 설정
		style.height = 300;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		var HeadTitle1 = "|Sel.|ALPS Port CD|ALPS Port CD|PSA Port CD";
		var headCount = ComCountHeadTitle(HeadTitle1);

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 23, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)


		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,			false,		"ibflag");
		InitDataProperty(0, cnt++ , dtCheckBox,			    50,		daCenter,			false,		"sel");
		InitDataProperty(0, cnt++ , dtData,					60,		daCenter,			false,		"loc_cd",				false,			"",      dfEngUpKey,			0,		false,		true, 5);
		InitDataProperty(0, cnt++ , dtData,					60,		daCenter,			false,		"tml_cd",			    false,			"",      dfEngUpKey,			0,		false,		true, 2);
		InitDataProperty(0, cnt++ , dtData,					40,		daCenter,			false,		"psa_loc_cd",			false,			"",      dfEngUpKey,			0,		true,		true, 5);
		
		InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");
		InitDataValid(0, "tml_cd", vtEngUpOther, "0123456789");
		InitDataValid(0, "psa_loc_cd", vtEngUpOther, "0123456789");
	}
	break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0582GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;

	case IBSAVE:        //저장
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSave("ESM_BKG_0582GS.do",  FormQueryString(formObj), -1, false);
			ComOpenWait(false);
		}
		break;

	case IBDELETE:      // 삭제
		ComRowHideDelete(sheetObj,"sel");
		break;

	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (port_cd.value.length < 5) {
			ComShowCodeMessage("BKG00424");
			port_cd.focus();
			return false;
		}
	}

	return true;
}

//화면 Clear
function resetForm()
{
	var formObj = document.form;
	
	sheetObjects[0].RemoveAll();
	formObj.reset();
}
