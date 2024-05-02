/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0058.js
 *@FileTitle : New container Receiving Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.12
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.08.12 진준성
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
 * @class EES_LSE_0058 : EES_LSE_0058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_LSE_0058() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.setComboObject     = setComboObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
	this.obj_change         = obj_change;
	this.obj_keypress       = obj_keypress;
	this.validateForm       = validateForm;
	this.loc_tp_OnChange    = loc_tp_OnChange;
	this.sheet1_OnSort      = sheet1_OnSort;
	this.sheet1_OnDblClick  = sheet1_OnDblClick;
	this.combo2_OnCheckClick 	= combo2_OnCheckClick;
	this.combo2_OnBlur 			= combo2_OnBlur;
	this.combo2_OnKeyDown 		= combo2_OnKeyDown;
}

/* 개발자 작업	*/
//공통전역변수
var vXmlBuff;
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;


//Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;


//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
	axon_event.addListenerFormat('change','obj_change',formObj);       //- 변경될때.
	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
			}
			break;
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}

			break;

		case "btn_DownExcel":
			sheetObjects[1].WaitImageVisible = false;
			ComOpenWait(true);
			sheetObjects[1].LoadSearchXml(vXmlBuff);
			sheetObjects[1].SpeedDown2Excel(-1);
			ComOpenWait(false);
			sheetObjects[1].WaitImageVisible = true;
			break;

		case "btn_New":
			sheetObjects[0].RemoveAll();

			formObject.sn_eng_range1.value = "";
			formObject.sn_num_range1.value = "";
			formObject.sn_eng_range2.value = "";
			formObject.sn_num_range2.value = "";
			formObject.sn_num.value = "";
			formObject.report_type[0].selected = true;

			formObject.period_stdt.value = "";
			formObject.period_eddt.value = "";

			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
				comboObjects[0].CheckIndex(i)=false;
			}
			formObject.cntr_tpsz_cd.value = "";
			comboObjects[0].CheckIndex(0) = true;
			Detail_text.innerHTML = "";
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
* IBMultiCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
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

	initControl();

	/* IBMultiCombo 초기화 */
	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
}


function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	comboObjects[0].CheckIndex(0) = true;
	document.form.sn_eng_range1.focus();
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
		style.height = 355;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msNone;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

     	//전체 데이터는 XML로 저장하고, 페이지 개수 만큼만 표시하고, 나머지는 자동 스크롤 방식
     	ScrollTrack = false;
     	MassOfSearch = 1;

		var HeadTitle1 = "|Seq.|Container No.|TP/SZ|Received Date|Yard|Seq.|Container No.|TP/SZ|Received Date|Yard";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,   0,	  	daCenter,	false,		"Status");
		InitDataProperty(0, cnt++ , dtData,			50,		    daCenter,	false,		"seq1",        	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"cntrno1",     	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	    "tysz1",  	  	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			130,		daCenter,	false,		"rcive_dt1",  	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"yard1",    	false,	"",		dfNone,     0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			50,		    daCenter,	false,		"seq2",        	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"cntrno2",      false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	    "tysz2",  	  	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			130,		daCenter,	false,		"rcive_dt2",  	false,	"",		dfNone,		0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"yard2",    	false,	"",		dfNone,     0,	true,		true);

		ColBackColor("seq1") = sheetObjects[0].RgbColor(192,192,192);
		ColBackColor("seq2") = sheetObjects[0].RgbColor(192,192,192);
		SelectBackColor = LSE_SELECT_BACK_COLOR;
		CountPosition   = 0;
	}
	break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 355;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 500);

			var HeadTitle1 = "|Seq.|Container No.|TP/SZ|Received Date|Yard|Seq.|Container No.|TP/SZ|Received Date|Yard";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,   0,	  	daCenter,	false,		"Status");
			InitDataProperty(0, cnt++ , dtData,			50,		    daCenter,	false,		"seq1",        	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"cntrno1",     	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	    "tysz1",  	  	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			130,		daCenter,	false,		"rcive_dt1",  	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"yard1",    	false,	"",		dfNone,     0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		    daCenter,	false,		"seq2",        	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"cntrno2",      false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	    "tysz2",  	  	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			130,		daCenter,	false,		"rcive_dt2",  	false,	"",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,		"yard2",    	false,	"",		dfNone,     0,	true,		true);

			CountPosition   = 0;
		}

 	break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
	if(validateForm(sheetObj,formObj,sAction)){
		if(sheetObj.id == "sheet1"){
			formObj.f_cmd.value = SEARCH;
			//sheetObj.DoSearch("EES_LSE_0058GS.do",FormQueryString(formObj));

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			vXmlBuff = sheetObj.GetSearchXml("EES_LSE_0058GS.do",FormQueryString(formObj));
			sheetObj.LoadSearchXml(vXmlBuff);
			ComOpenWait(false);

			Detail_text.innerHTML  = " Total : " + ComGetEtcData(vXmlBuff, "data_cnt");
			sheetObjects[0].ColBackColor("seq1") = sheetObjects[0].RgbColor(238,238,238);
			sheetObjects[0].ColBackColor("seq2") = sheetObjects[0].RgbColor(238,238,238);
		}
	}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;

		if ( sXml2 != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml2, comboObjects[0], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");
		}
		break;

	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:      //조회


			if ( formObj.sn_eng_range1.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_eng_range1);
				return false;
				break;
			}

			if ( formObj.sn_num_range1.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_num_range1);
				return false;
				break;
			}

			if ( formObj.sn_eng_range2.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_range2);
				return false;
				break;
			}

			if ( formObj.sn_num_range2.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_num_range2);
				return false;
				break;
			}

			if ( Number(formObj.sn_num.value) > 10000 ) {
				ComShowCodeMessage("LSE01147");
				ComSetFocus(formObj.sn_num_range2);
				return false;
				break;
			}

			break;
			}
		}
	}
	return true;
}


/**
* HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
*/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){
	case "period_stdt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "period_eddt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "sn_eng_range1":
		//if(document.form.sn_eng_range1.value.length == 4){
		document.form.sn_eng_range2.value = document.form.sn_eng_range1.value;
		//}
		break;
	case "sn_num_range1":
		var num1 = document.form.sn_num_range1.value;
		var num2 = document.form.sn_num_range2.value;
		if(num1 != "" && num2 != "" ){
		   if(Number(num1) > Number(num2) ){
			   document.form.sn_num_range2.value = "";
			   document.form.sn_num.value  = "";
			   document.form.sn_num_range2.focus();
			   return;
		   }
		   document.form.sn_num.value = Number(num2) - Number(num1) + 1;
		}
		break;
	case "sn_num_range2":

		var num1 = document.form.sn_num_range1.value;
		var num2 = document.form.sn_num_range2.value;
		if(num1 != "" && num2 != "" ){
			if(Number(num1) > Number(num2) ){
				document.form.sn_num_range2.value = "";
				document.form.sn_num.value  = "";
				document.form.sn_num_range2.focus();
				return;
			}
		    document.form.sn_num.value = Number(num2) - Number(num1) + 1;
		}
		break;

	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
	break;
	}
}
/**
* HTML Control의 키보드 이벤트 방 포멧처리 한다.
*/
function obj_keypress() {
	var obj = event.srcElement;
	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
	case "int":
		ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		ComKeyOnlyAlphabet('upper');
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	default:
		ComKeyOnlyNumber(obj);
	break;
	}
}

/**
* 콤보 초기설정값, 헤더 정의
* param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
	case "combo2":
		with(comboObj) {
			DropHeight = 200;
			MultiSelect = true;
			//MaxSelect = 1;
			MultiSeparator = ",";
			Style = 0;
			UseAutoComplete = true;
			//영문(대)+특수문자,숫자 - TP/SZ
			ValidChar(2,3);
		}
		break;

	}
}
/**
* MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
* @return
*/
function combo2_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * combo2_OnBlur
 */
function combo2_OnBlur(comboObj, Index_Code, Text) {
	var formObj = document.form;
	if( comboObj.CheckIndex(0)){
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = false;
		}
		formObj.cntr_tpsz_cd.value = "";
	}else if(comboObj.Text == ""){
		comboObj.CheckIndex(0) = true;
		formObj.cntr_tpsz_cd.value = "";
	}else{
	    formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
	}
}

/**
 * combo2_OnKeyDown
 */
function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
			comboObj.Text = "";
		}else if(KeyCode == 13){
			sheetObjects[0].RemoveAll();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
}

/**
* HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
*/
function obj_focus(){
	var obj  = event.srcElement;
	if( obj.readOnly ) {
		ComSetNextFocus(obj);
	} else {
		//마스크구분자 없애기
		ComClearSeparator(event.srcElement);
	}
}


/**
* HTML Control의 Value가 변경되었을 경우 처리한다.
*/
function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
	switch(obj.name) {

	case "period_stdt":		//Location Code
	if(formObj.period_eddt.value != ""){
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	}
	break;

	case "period_eddt":		//Location Code
	checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	break;
	}
    //}
}
/**
* Key-Down Event 처리
*/
function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;
	var srcObj  = window.event.srcElement;
	if ( vKeyCode == 13 ) {
		switch(obj.name) {
		    case "aaa":
		    default :
			    if ( srcObj.style.filter == "" ) {
				    sheetObjects[0].RemoveAll();
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			    }
	    }
	}
}
/* 개발자 작업  끝 */