/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : VOP_OPF_0095.js
 *@FileTitle : Missing TDR Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.26
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2010.11.26 박희동
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
 * @class VOP_OPF_0095 : VOP_OPF_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_OPF_0095() {
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

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix="sheet1_";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_new":
			UF_reset();
			break;

		case "btn_downexcel":
			sheetObj.Down2Excel(-1, true, true, true, "", "", false, false, "", true, "", "", false, false, "");
			break;

		case "btns_port":
	    	var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="+formObj.port_cd.value;
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);

			if(rVal){
				sheetObjects[0].RemoveAll();
				formObj.port_cd.value = rVal;
				port_cd_keyup();//RHQ_OFC_CD setting하기				
			} 
			break;

		case "btns_slan":
			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+formObj.slan_cd.value, 420, 480, "slan_cd_pop_event", "0,0", true);
			break;
			
        case "btns_period": // From 달력버튼
        	var cal = new ComCalendarFromTo();
        	cal.endFunction = "cal_end_func";
        	cal.select(formObj.fr_dt, formObj.to_dt, 'yyyy-MM-dd');
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
 * Calendar From To 선택 후 호출하는 함수
 */
function cal_end_func(){
	sheetObjects[0].RemoveAll();
}

/**
 * Lane Code 선택 후 호출하는 함수
 */
function slan_cd_pop_event(aryPopupData) {
	sheetObjects[0].RemoveAll();
	document.form.slan_cd.value = aryPopupData[0][1];
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	document.form.fr_dt.value = frDt;
	document.form.to_dt.value = toDt;
	initControl();
}

/**
* 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
* {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {int}     sheetNo     sheetObjects 배열에서 순번
**/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
 //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup'           , 'obj_keyup'     ,  formObj);
	axon_event.addListenerFormat('click'           , 'obj_onclick'   , 	formObj);

	axon_event.addListener('click', 'change_event_radio', 'crr_cd');
}

/**
* Form KeyUp
* @return
*/
function obj_keyup(){
	ComKeyEnter('lengthnextfocus');

	obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
	case "port_cd":
		if (formObj.port_cd.value.length == 5) {
			port_cd_keyup();
		}
		break;
	case "slan_cd":
		if (formObj.slan_cd.value.length == 3) {
			slan_cd_keyup();
		}
		break;
	}
}

/**
 * OnBlur
 * 
 * @return
 */
function obj_deactivate(){
	ComChkObjValid(event.srcElement);
}

/**
* OnFocus
* @return
*/
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")

	if (src == "port_cd"){
		ComKeyOnlyAlphabet('upper');
	}else if (src == "slan_cd"){
		ComKeyOnlyAlphabet('uppernum');
	}else if (src == "fr_dt" || src == "to_dt"){
		ComKeyOnlyNumber(this, '');
	} 
	
}

function obj_onclick(){
	//var src = window.event.srcElement.getAttribute("name")
}

function change_event_radio(){
	sheetObjects[0].RemoveAll();
	
	//2011.01.04 P.H.D Carrier가 Other 이면 TDR All로 변경 
	//2014.06.27 P.H.D Carrier가 Other인 경우에도 TOR MSS로 처리
	//if (document.form.crr_cd[1].checked){
	//	document.form.tdr_flg.Text2 = "All";
	//}else{
	//	document.form.tdr_flg.Code2 = "MSS";
	//}
	document.form.tdr_flg.Code2 = "MSS";
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 388;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle  = "SEQ|RHQ|Carrier|Port|Terminal|Terminal|Lane|Type|VVD|Arrival date|Departure date|Moves|Moves|Moves|Moves|Moves|Bay Plan|TOR";
			var HeadTitle1 = "SEQ|RHQ|Carrier|Port|Yard|Name|Lane|Type|VVD|Arrival date|Departure date|Total|SML|SML|Other|Other|Bay Plan|TOR";

			var headCount = ComCountHeadTitle(HeadTitle);
 
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			InitHeadRow(1, HeadTitle1, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq ,  30, daRight , true, prefix+"seq");
			InitDataProperty(0, cnt++, dtData    ,  55, daCenter, true, prefix+"rhq_ofc_cd"          , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, prefix+"crr_cd"              , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  55, daCenter, true, prefix+"port_cd"             , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  65, daCenter, true, prefix+"yd_cd"               , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    , 150, daLeft  , true, prefix+"yd_nm"               , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  45, daCenter, true, prefix+"slan_cd"             , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  45, daCenter, true, prefix+"svc_tp_cd"           , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  80, daCenter, true, prefix+"vvd"                 , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    , 105, daCenter, true, prefix+"ar_dt"               , false, "", dfUserFormat2);
			InitDataProperty(0, cnt++, dtData    , 105, daCenter, true, prefix+"dp_dt"               , false, "", dfUserFormat2);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight , true, prefix+"mv_cnt"              , false, "", dfNumber);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, prefix+"hjs_mvs_flg"         , false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daRight , true, prefix+"hjs_mvs"             , false, "", dfNumber);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, prefix+"oth_mvs_flg"         , false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daRight , true, prefix+"oth_mvs"             , false, "", dfNumber);
			InitDataProperty(0, cnt++, dtData    ,  60, daCenter, true, prefix+"bay_pln_flg"         , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, prefix+"tdr_flg"             , false, "", dfNone);
			
			InitUserFormat2(0, prefix+"ar_dt" , "####-##-## ##:##", "-|:");
			InitUserFormat2(0, prefix+"dp_dt" , "####-##-## ##:##", "-|:");
		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0095GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
//			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
//			}
			break;
	}
}

/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
*/ 

function initCombo(comboObj, comboNo) {
	var formObj = document.form

	switch (comboObj.id) {
	// Carrier Code
	case "rhq_ofc_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);// 영문대문자만 입력가능
			MaxLength = 5;
			var i = 0;
			InsertItem(i++, "All", " ");
			InsertItem(i++, "HAMRU", "HAMRU");
			InsertItem(i++, "NYCRA", "NYCRA");
			InsertItem(i++, "SELIB", "SELIB");
			InsertItem(i++, "TYOIB", "TYOIB");
			InsertItem(i++, "SHARC", "SHARC");
			InsertItem(i++, "SINRS", "SINRS");
			InsertItem(i++,  "VVOIA", 	"VVOIA");
		}
		// Login Office 의 RHQ가 있으면 그것으로 하고 아니면 첫번째 RHQ를 default로 한다.
		var dfltInx = comboObj.FindIndex(rhqOfcCd, 0);
		comboObj.Text2 = (dfltInx == "-1"?"All":dfltInx);
		break;

	// Trade Code
	case "tdr_flg":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);// 영문대문자만 입력가능
			MaxLength = 3;
		}

		UF_setComboItem(comboObj, tdrList.split("|"));
		comboObj.Code2 = "MSS";
		break;

	case "svc_tp_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("35");
			DropHeight = 160;
			ValidChar(2, 1);// 영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
		UF_setComboItem(comboObj, svcList.split("|"));
		comboObj.Code2 = "TRK";
		break;
		
	case "ex_tpr_flg":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);// 영문대문자만 입력가능
			MaxLength = 3;
		}
		UF_setComboItem(comboObj, "Y,Y|N,N".split("|"));
		comboObj.Index2 = 1;
		break;
		
	case "bayplan":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);// 영문대문자만 입력가능
			MaxLength = 3;
		}
		UF_setComboItem(comboObj, "ALL,ALL|Y,Y|N,N".split("|"));
		comboObj.Index2 = 0;
		break;
	}
}
 
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			break;
	}
	return true;
}

/**
* 조회가 끝난 다음
* @param sheetObj
* @param ErrMsg
* @return
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//
}

/**
 * Port Code Key-in시 5자리 입력 후 호출
 */
function port_cd_keyup(){
	var formObj = document.form;
	sheetObjects[0].WaitImageVisible=false;
	
	formObj.f_cmd.value = SEARCH01;
	var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0095GS.do", FormQueryString(formObj));
	
	if(ComGetEtcData(sRhqXml, "PORT_CD") == ""){		
		ComAlertFocus(formObj.port_cd, ComGetMsg("OPF50004", "'Port Code'"));
		formObj.port_cd.value = "";
	}else{
		var rhqOfcCd = ComGetEtcData(sRhqXml, "RHQ_OFC_CD");
		formObj.rhq_ofc_cd.Code2 = rhqOfcCd == "" ? " " : rhqOfcCd; 
		ComKeyEnter('lengthnextfocus');
	}
}

/**
 * LANE COde Key-In시 3자리 완료했을 때 호출하는 함수
 */
function slan_cd_keyup(){
	var formObj = document.form;
	sheetObjects[0].WaitImageVisible=false;

	formObj.f_cmd.value = COMMAND12;
	var lanXml = sheetObjects[0].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
	
	var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");

	if(ComTrim(strLanCdDesc) == ""){
		ComAlertFocus(formObj.slan_cd, ComGetMsg("OPF50004", "'Lane Code'"));
		formObj.slan_cd.value = "";
	}else{
		ComKeyEnter('lengthnextfocus');
	}	
}

/**
 * Combo Item setting
 * @param comboObj
 * @param comboItems
 */
function UF_setComboItem(comboObj, comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(",");
		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
	}   		
}

/**
 * RHQ onChange이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function rhq_ofc_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
}

/**
 * TDR onChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function tdr_flg_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
}

/**
 * Service OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
//function svc_tp_cd_OnChange(comboObj, Code, Text){
//	sheetObjects[0].RemoveAll();
//	
//	/*if (Code == "TRK"){
//		document.form.tdr_flg.Code2 = "MSS";
//	}else{
//		document.form.tdr_flg.Text2 = "All";
//	}*/
//	
//	document.form.tdr_flg.Code2 = "MSS";
//}

function ex_tpr_flg_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
}

function UF_reset(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.fr_dt.value = frDt;
	formObj.to_dt.value = toDt;
	var dfltInx = comboObjects[0].FindIndex(rhqOfcCd, 0);
	comboObjects[0].Text2 = (dfltInx == "-1"?"All":dfltInx);
	
	formObj.port_cd.value = "";
	formObj.slan_cd.value = "";
	formObj.crr_cd[0].checked = true;
	formObj.tdr_flg.Code2 = "MSS";
	formObj.svc_tp_cd.Code2 = "TRK";
	formObj.ex_tpr_flg.Code2 = "N";
	formObj.bayplan.Code2 = "N";
	sheetObj.RemoveAll();	
}
/* 개발자 작업  끝 */