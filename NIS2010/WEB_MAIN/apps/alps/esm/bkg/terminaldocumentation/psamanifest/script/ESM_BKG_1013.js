/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : esm_bkg_1013.js
*@FileTitle : PSA Vessel Registeration : Import Schedule
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
function esm_bkg_1013()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.initSheet					= initSheet;
	this.doActionIBSheet			= doActionIBSheet;
	this.validateForm				= validateForm;
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
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_calendar1":
			var cal = new ComCalendarFromTo(); 
			cal.select(formObject.etb_dt1,formObject.etb_dt2, 'yyyy-MM-dd'); 
			break;
			
		case "btn_Close":
			self.close();
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

		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);

	}

	// Key 입력 처리
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.form.port_cd.focus();
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

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|SEQ|SEL|NIS VVD|NIS VVD|NIS VVD|PSA Vessel Name|Voyage/Direction";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW,   COL,    DATATYPE,           WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
			InitDataProperty(0,		cnt++ , dtDataSeq,			50,		daCenter,		true,		"Seq",					false,     "",		dfNone,			0,		false, false, 0, 		false, false);
			InitDataProperty(0,		cnt++ , dtCheckBox,			50,		daCenter,		true,		"Sel",					false,		"",		dfNone,			0,		true,	true);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"vsl_cd",				true,		"",		dfEngUpKey,		0,		true,	true,	4,		true);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"skd_voy_no",			true,		"",		dfEngUpKey,		0,		true,	true,	4,		true);
			InitDataProperty(0,		cnt++ , dtData,				30,		daCenter,		true,		"skd_dir_cd",			true,		"",		dfEngUpKey,		0,		true,	true,	1,		true);
			InitDataProperty(0,		cnt++ , dtData,				400,	daLeft,			true,		"psa_vsl_nm",			true,		"",		dfEngUpKey,		0,		true,	true,	100);
			InitDataProperty(0,		cnt++ , dtData,				120,	daLeft,			true,		"psa_voy_dir_cd",		true,		"",		dfEngUpKey,		0,		true,	true,	6);

			CountPosition = 0;

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
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1013GS.do",  FormQueryString(formObj));
			opener.sheetObjects[0].LoadSearchXml(sXml);
			for(var i=1; i <=opener.sheetObjects[0].RowCount; i++) {
				opener.sheetObjects[0].RowStatus(i) = "I";
			}
			self.close();
		}
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
		if (etb_dt1.value.length < 10) {
			ComShowCodeMessage("BKG00755");
			etb_dt1.focus();
			return false;
		}
		if (etb_dt2.value.length < 10) {
			ComShowCodeMessage("BKG00755");
			etb_dt2.focus();
			return false;
		}
		
		if (ComGetDaysBetween(etb_dt1.value, etb_dt2.value) > 40) {
			ComShowCodeMessage("COM132001",ComGetDaysBetween(etb_dt1.value, etb_dt2.value)+" Days " ,"40 Days");
			return false;
		}
	}

	return true;
}
