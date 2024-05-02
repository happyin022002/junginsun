/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : VOP_OPF_0405.js
 *@FileTitle : Port Time Activity Creation by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2012.02.08
 * 1.0 Creation
 * 2012.02.08 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
 * 2012.04.06 김민아 [선반영] Port Time Activity Creation by VVD 로직 수정 - 전체 Max duration 및 Item 별 전후 duration 을 각각 120 hours, ±72 hours로 변경
 * 2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
 * 2012.09.05 김상근 [CHM-201220011] [TOR] Port Time Activity 입력값 validation 변경
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
 * @class VOP_OPF_0405 : VOP_OPF_0405 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_OPF_0405() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var tabObjects = new Array();
var tabCnt     = 0;
var beforetab  = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix1 = "sheet1_";
var prefix2 = "sheet2_";
var prefix3 = "sheet3_";

//var btn1Sts = false;
//var btn2Sts = false;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var tabObj   = tabObjects[0];

	/*******************************************************/
	var formObj = document.form;
	var selTabIdx = tabObj.SelectedIndex;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
		case "btns_searchVvd":
			var vslcd = document.form.vsl_cd.value;
			var sUrl = "";
			
			if(vslcd == ""){
				sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
				ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
			}else{
				sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslcd;
				ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
			}

			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
			break;
			
		case "btn_new":
			initAll();
			break;
			
		case "btn_save":
		case "btn_save2":
			doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
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
	//IBMultiCombo 초기화
	for (var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	
	//IBTab 초기화
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
	//IBSheet 초기화
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	document.form.vsl_cd.focus();
	
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt = 0;
				InsertTab(cnt++, "Port Time Activity"	, -1);
				InsertTab(cnt++, "Cargo Handling Type"	, -1);
			}
			break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "t1sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 450;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle  = "Port Time Activity|Port Time Activity|Performance|Operation Stoppage|Data type|Remark|User ID|Creation date(L)|Update date(L)|ibflag|port_act_ctnt|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq";

			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData    	,  70, daCenter, true, 	prefix1+"port_act_grp_desc"	, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtImageText	, 150, daLeft	, true, prefix1+"port_act_desc"		, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    	, 100, daCenter, true, 	prefix1+"wrk_perf_dt"		, false, "", dfUserFormat2,	-1, true	, true);
			InitDataProperty(0, cnt++, dtCombo   	, 130, daLeft	, true, prefix1+"op_stpg_ctnt"		, false, "", dfNone, 		-1, true	, true);
			InitDataProperty(0, cnt++, dtCombo   	,  70, daCenter, true, 	prefix1+"src_svr_nm"		, false, "", dfNone, 		-1, true	, true);
			InitDataProperty(0, cnt++, dtData    	, 160,	daLeft	, true, prefix1+"diff_rmk"			, false, "", dfNone, 		-1, true	, true	, 500);
			InitDataProperty(0, cnt++, dtData    	, 100, daCenter, true, 	prefix1+"cre_usr_id"		, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    	, 100, daCenter, true, 	prefix1+"cre_dt"			, false, "", dfUserFormat2, -1, false	, false);
			InitDataProperty(0, cnt++, dtData    	, 100, daCenter, true, 	prefix1+"upd_dt"			, false, "", dfUserFormat2, -1, false	, false);

			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, true, prefix1+"ibflag");
			InitDataProperty(0, cnt++, dtHidden    	,  70, daCenter, true, 	prefix1+"port_act_ctnt"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    	,  50, daCenter, true, 	prefix1+"vsl_cd"			, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    	,  50, daCenter, true, 	prefix1+"skd_voy_no"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    	,  50, daCenter, true, 	prefix1+"skd_dir_cd"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    	,  50, daCenter, true, 	prefix1+"vps_port_cd"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    	,  50, daCenter, true, 	prefix1+"clpt_ind_seq"		, false, "", dfNone, 		-1, false, false);
			
			SetMergeCell(0, 0, 1, 2);
			InitUserFormat2(0, prefix1+"wrk_perf_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix1+"cre_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix1+"upd_dt"		, "####-##-## ##:##", "-|:" );
			InitDataValid(0, prefix1+"diff_rmk", vtEngOther, "1234567890~!@#$%^&*()_+-=,./{}[]:;' ")
			ToolTipOption="balloon:true;width:1000;forecolor:#000000;icon:1";
			ImageList(0) = "img/ico_star.gif";
			WaitImageVisible=false;
		}
		break;
		
	case "t2sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 450;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle  = "Twin Lift|Dual Cycle|Restow|Remark|User ID|Creation date(L)|Update date(L)|ibflag|port_act_ctnt|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq";

			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData    ,  70, daCenter, true, 	prefix2+"twin_lift_cnt"		, false, "", dfNullInteger,	-1, true	, true,  4, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  70, daCenter, true, 	prefix2+"dual_cycle_cnt"	, false, "", dfNullInteger,	-1, true	, true,  4, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  70, daCenter, true, 	prefix2+"restow_cnt"		, false, "", dfNullInteger,	-1, true	, true,  4, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    , 200, daLeft	, true, 	prefix2+"diff_rmk"			, false, "", dfNone, 		-1, true	, true, 500);
			InitDataProperty(0, cnt++, dtData    , 100, daCenter, true, 	prefix2+"cre_usr_id"		, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 100, daCenter, true, 	prefix2+"cre_dt"			, false, "", dfUserFormat2, -1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 100, daCenter, true, 	prefix2+"upd_dt"			, false, "", dfUserFormat2, -1, false	, false);

			InitDataProperty(0, cnt++, dtHiddenStatus  ,  30, daCenter, true, 	prefix2+"ibflag");
			InitDataProperty(0, cnt++, dtHidden    ,  70, daCenter, true, 	prefix2+"port_act_ctnt"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    ,  50, daCenter, true, 	prefix2+"vsl_cd"			, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    ,  50, daCenter, true, 	prefix2+"skd_voy_no"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    ,  50, daCenter, true, 	prefix2+"skd_dir_cd"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    ,  50, daCenter, true, 	prefix2+"vps_port_cd"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtHidden    ,  50, daCenter, true, 	prefix2+"clpt_ind_seq"		, false, "", dfNone, 		-1, false, false);
			
			InitUserFormat2(0, prefix2+"cre_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix2+"upd_dt"		, "####-##-## ##:##", "-|:" );
			
			InitDataValid(0, prefix2+"diff_rmk", vtEngOther, "1234567890~!@#$%^&*()_+-=,./{}[]:;' ")
			
			ToolTipOption="balloon:true;width:1000;forecolor:#000000;icon:1";
			
			WaitImageVisible=false;
		}
		break;
		
	case "tmpsheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 450;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle  = "Port Time Activity|Port Time Activity|cntr_hndl_knt|Remark|User ID|Creation date(L)|Update date(L)|ibflag|port_act_ctnt|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq";

			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData    ,  70, daCenter, true, 	prefix3+"port_act_grp_desc"	, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 150, daLeft	, true, 	prefix3+"port_act_desc"		, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 150, daLeft	, true, 	prefix3+"cntr_hndl_knt"		, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 200, daLeft	, true, 	prefix3+"diff_rmk"			, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 100, daCenter, true, 	prefix3+"cre_usr_id"		, false, "", dfNone, 		-1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 100, daCenter, true, 	prefix3+"cre_dt"			, false, "", dfUserFormat2, -1, false	, false);
			InitDataProperty(0, cnt++, dtData    , 100, daCenter, true, 	prefix3+"upd_dt"			, false, "", dfUserFormat2, -1, false	, false);

			InitDataProperty(0, cnt++, dtStatus  ,  30, daCenter, true, 	prefix3+"ibflag");
			InitDataProperty(0, cnt++, dtData    ,  70, daCenter, true, 	prefix3+"port_act_ctnt"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, 	prefix3+"vsl_cd"			, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, 	prefix3+"skd_voy_no"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, 	prefix3+"skd_dir_cd"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, 	prefix3+"vps_port_cd"		, false, "", dfNone, 		-1, false, false);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, 	prefix3+"clpt_ind_seq"		, false, "", dfNone, 		-1, false, false);
			
			
			SetMergeCell(0, 0, 1, 2);
			
			InitUserFormat2(0, prefix3+"cre_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix3+"upd_dt"		, "####-##-## ##:##", "-|:" );
			
			WaitImageVisible=false;
			
		}
		break;
	}
}

/**
 * Combo 설정
 * @param comboObj
 * @return
 */
function initCombo(comboObj) {
	with(comboObj) {
		switch(id) {
			//2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
			case "vps_port_cd_1":
				SetTitle("Port|D/Call");
	            SetColWidth("50|50")
				DropHeight = 200;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	UseAutoComplete = true;
	        	SetColAlign("center|center");
//	        	MaxLength = 5;
	        	IMEMode = 0;
//	        	SetColWidth("50");
	        	ValidChar(2, 1);// 영문대문자+숫자 입력가능
	            break;
		}
	}
}

function initControl() {
	axon_event.addListenerForm  ('blur',		'obj_deactivate',	form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerForm	('keyup',		'obj_keyup',		form);
	axon_event.addListenerForm  ('change',  	'obj_change',		form);
    axon_event.addListenerFormat('focus',		'obj_activate',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
    axon_event.addListenerFormat('keypress',	'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
}

function obj_deactivate(){
	ComChkObjValid(event.srcElement);
}

function obj_keyup() {
	ComKeyEnter('LengthNextFocus');
}

function obj_activate(){
	if(event.srcElement.name == "vsl_cd" || event.srcElement.name == "skd_voy_no" || event.srcElement.name == "skd_dir_cd"){
		event.srcElement.select();
	}
}

function obj_keypress() {
	switch(event.srcElement.dataformat){
	case "engup":
		switch(event.srcElement.name){
			case "vsl_cd":	
				//영문대문자 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
			case "skd_voy_no":	
				//숫자입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "skd_dir_cd":	
				//영문대문자 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
		}
		break;
	}
}

function obj_change() {
	var elementObj = event.srcElement;
	var formObj = document.form;
	if(elementObj.name=="vsl_cd"){
		formObj.skd_voy_no.value = "";
		formObj.skd_dir_cd.value = "";
		formObj.slan_cd.value = "";
		comboObjects[0].RemoveAll();
		
		var vslCd = elementObj.value;
		if(!isNull(vslCd)) {
			/*VSL CD 조회*/
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_0405GS.do", FormQueryString(formObj));
			var sCode = ComGetEtcData(sXml, "VSL_CD");
			setSheetData(sheetObjects[0]);
			if(isNull(sCode)) {
				ComShowCodeMessage("OPF50004", vslCd);
				formObj.vsl_cd.value = "";
				formObj.vsl_cd.focus();
				return false;
			}else {
				formObj.skd_voy_no.focus();
			}
		}else {
			initAll();
		}
		
	}else if(elementObj.name=="skd_voy_no"){
		setSheetData(sheetObjects[0]);
		formObj.skd_dir_cd.value = "";
		formObj.slan_cd.value = "";
		comboObjects[0].RemoveAll();
		formObj.skd_dir_cd.focus();
	}else if(elementObj.name=="skd_dir_cd"){
		setSheetData(sheetObjects[0]);
		formObj.slan_cd.value = "";
		comboObjects[0].RemoveAll();
		
		var vvd = formObj.vsl_cd.value+formObj.skd_voy_no.value+elementObj.value;
		setPortLane(vvd);
	}
	
	setVms();
}

/**
 * PORT CD & LANE CD 조회
 * @param vvd
 */
function setPortLane(vvd) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH02;
	var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_0405GS.do", FormQueryString(formObj));
	var sCode = ComGetEtcData(sXml, "LANE_CD");
	if(isNull(sCode)) {
		ComShowCodeMessage("OPF50004", vvd);
		initAll();
    	return false;
    }
	formObj.slan_cd.value = sCode;
	
	var sCode2 = ComGetEtcData(sXml, "PORT_CD");
	if(isNull(sCode2)) {
		ComShowCodeMessage("OPF50004", vvd);
		initAll();
    	return false;
    }
    
	setComboItem(comboObjects[0], sCode2);
	comboObjects[0].focus();
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	
	var tabObj = tabObjects[0];
	var selTabIdx = tabObj.SelectedIndex;
	var prefixs = new Array(prefix1, prefix3);
	
	switch (sAction) {
		case IBSEARCH: //조회
			//MultiCombo의 Clpt Ind Seq (두번째 컬럼값) 값을 form 값에 셋팅한다.
			formObj.clpt_ind_seq.value = comboObjects[0].GetIndexText(comboObjects[0].Index, 1);
			
			//2012.05.03 조경완  [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
			//MultiCombo의 vps_port_cd (첫번째 컬럼값) 값을 form 값에 셋팅한다.
			formObj.vps_port_cd.value = comboObjects[0].GetIndexText(comboObjects[0].Index, 0);
			
			formObj.f_cmd.value = SEARCH;
			
			sheetObj.Redraw = false;
			
			ComOpenWait(true);
			
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0405GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs));
			var arrXml = sXml.split("|$$|");
			if(arrXml.length > 0) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
			}
			if(arrXml.length > 1) {
				sheetObjects[2].LoadSearchXml(arrXml[1]);
			}
			ComOpenWait(false);
			sheetObj.Redraw = true;
			
			setVms();
			
			break;
			
		case IBSAVE:
			if(selTabIdx == 1) {
				sheetObj = sheetObjects[2];
			}
			//1. 데이타 수정 유무 체크
			if(sheetObjects[0].IsDataModified || sheetObjects[2].IsDataModified) {
			
				//2. 저장전 체크 사항
				if(selTabIdx == 0) {
					//Tab1 필수 입력 사항 유무 체크
					if(!validateSheet1()) return;
					//Tab2 필수 입력 사항 유무 체크
					if(!validateSheet2()) return;
				}else if(selTabIdx == 1) {
					//Tab2 필수 입력 사항 유무 체크
					if(!validateSheet2()) return;
					//Tab1 필수 입력 사항 유무 체크
					if(!validateSheet1()) return;
				}
				
				if (!ComShowCodeConfirm("OPF50001")) {
	                return false;
	            }
	            
				formObj.vps_port_cd.value = comboObjects[0].GetIndexText(comboObjects[0].Index, 0);
				formObj.f_cmd.value = MULTI;
				var param = ComGetSaveString(sheetObjects[0]) + "&" + ComGetSaveString(sheetObjects[2]);
				var sXml = sheetObj.GetSaveXml("VOP_OPF_0405GS.do", FormQueryString(formObj) + "&" + param + "&" + ComGetPrefixParam(prefixs));
				sheetObj.LoadSaveXml(sXml);
			}else {
				ComShowCodeMessage("OPF50029");
				return false;
			}
			break;
					
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
		case IBSAVE:
			if(isNull(formObj.vsl_cd.value)){
				ComShowCodeMessage("OPF50009", "VVD");
				formObj.vsl_cd.focus();
				return false;
			}
			if(isNull(formObj.skd_voy_no.value)){
				ComShowCodeMessage("OPF50009", "VVD");
				formObj.skd_voy_no.focus();
				return false;
			}
			if(isNull(formObj.skd_dir_cd.value)){
				ComShowCodeMessage("OPF50009", "VVD");
				formObj.skd_dir_cd.focus();
				return false;
			}
			if(isNull(comboObjects[0].Code)){
				ComShowCodeMessage("OPF50009", "Port");
				return false;
			}
			break;
	}
	return true;
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * @param tabObj
 * @param nItem
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
//	//Save 버튼 제어
//	if(nItem == 0) {
//		if(btn1Sts) ComBtnEnable("btn_save");
//		else ComBtnDisable("btn_save");
//	}else if(nItem == 1) {
//		if(btn2Sts) ComBtnEnable("btn_save");
//		else ComBtnDisable("btn_save");
//	}
	
}

/**
 * OnLoadFinish 이벤트
 * sheet combo data 셋팅
 * @param sheetObj
 */
function t1sheet1_OnLoadFinish(sheetObj) {
	//1. Operation Stoppage 셋팅
	if(!isNull(oprStopCd)){
		var dataList = oprStopCd.split("|");
		var comboText = " ";
		var comboCode = " ";
		
		for(var i = 0 ; i < dataList.length ; i++) {
			var comboItem = dataList[i].split(",");
			comboText += "|" + comboItem[1];
			comboCode += "|" + comboItem[0];
		}
		sheetObj.InitDataCombo(0, prefix1+"op_stpg_ctnt", comboText, comboCode);
	}
	
	//2. Data type 셋팅
	sheetObj.InitDataCombo(0, prefix1+"src_svr_nm", " |VMS", " |VMS");
	
	initAll();
	
	setVms();
}

//Anchor Drop(VMS) / Anchor Away(VMS) 입력 불가
function setVms(){
	sheetObjects[0].RowEditable(3) = false;
	sheetObjects[0].RowEditable(4) = false;
}

/**
 * OnChange 이벤트
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
	if(sheetObj.ColSaveName(Col)==prefix1+"wrk_perf_dt") {
		var tmpDate = sheetObj.CellValue(Row, Col);
		if(tmpDate != "") {
			//포맷 Check
			if(!checkDateFormat(sheetObj, Row, Col, tmpDate)) {
				return;
			}
			//Performance Check
			if(!checkPerformancePreDate(sheetObj, Row, Col, tmpDate)) {
				return;
			}
			if(!checkPerformanceNextDate(sheetObj, Row, Col, tmpDate)) {
				return;
			}
			if(!checkPerformanceMinMax(sheetObj, Row, Col, tmpDate)) {
				return;
			}
		}
	}
}

var arrTitleNm = Array(3);
arrTitleNm[0] = "Performance";
arrTitleNm[1] = "Operation Stoppage";
arrTitleNm[2] = "Data type";

/**
 * Save 전 sheet1 Validation 
 * @return
 */
function validateSheet1() {
	if(sheetObjects[0].IsDataModified) {
		var sheetObj = sheetObjects[0];
		
		//First move, Last move 의 Performance 는 필수
		var idx1 = sheetObj.FindText(prefix1+"port_act_ctnt", "PTA0018");
		var idx2 = sheetObj.FindText(prefix1+"port_act_ctnt", "PTA0019");
		
		if(sheetObj.CellValue(idx1, prefix1+"wrk_perf_dt") == "") {
			changeTab(0);
			ComShowCodeMessage("OPF50009", "Performance");
			sheetObj.SelectCell(idx1, prefix1+"wrk_perf_dt", true);
			return false;
		}
		if(sheetObj.CellValue(idx2, prefix1+"wrk_perf_dt") == "") {
			changeTab(0);
			ComShowCodeMessage("OPF50009", "Performance");
			sheetObj.SelectCell(idx2, prefix1+"wrk_perf_dt", true);
			return false;
		}
		
		var idxs = sheetObj.FindStatusRow("U");
		var arrRow = idxs.split(";"); 
		for(var i=sheetObj.HeaderRows ; i<=sheetObj.LastRow ; i++) {
			
			//Port Time Activity 이 'Drift/Anchor' 일때 체크
			if( (sheetObj.CellValue(i,prefix1+"port_act_grp_desc") == "Drift/Anchor") 
			  && (sheetObj.CellValue(i,prefix1+"port_act_desc").indexOf("(BBO)") > -1) ){

				var num = i%2;
				if(num == 0){
					//End
					if(!isNull(sheetObj.CellValue(i, prefix1+"wrk_perf_dt")) && isNull(sheetObj.CellValue(i-1, prefix1+"wrk_perf_dt"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i-1, prefix1+"port_act_desc"), arrTitleNm[0]);
						sheetObj.SelectCell(i-1, prefix1+"wrk_perf_dt");
						return false;
					}else if(!isNull(sheetObj.CellValue(i, prefix1+"op_stpg_ctnt")) && isNull(sheetObj.CellValue(i-1, prefix1+"op_stpg_ctnt"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i-1, prefix1+"port_act_desc"), arrTitleNm[1]);
						sheetObj.SelectCell(i-1, prefix1+"op_stpg_ctnt");
						return false;
					}else if(!isNull(sheetObj.CellValue(i, prefix1+"src_svr_nm")) && isNull(sheetObj.CellValue(i-1, prefix1+"src_svr_nm"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i-1, prefix1+"port_act_desc"), arrTitleNm[2]);
						sheetObj.SelectCell(i-1, prefix1+"src_svr_nm");
						return false;
					}
				}else{
					//Start
					if(!isNull(sheetObj.CellValue(i, prefix1+"wrk_perf_dt")) && isNull(sheetObj.CellValue(i+1, prefix1+"wrk_perf_dt"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i+1, prefix1+"port_act_desc"), arrTitleNm[0]);
						sheetObj.SelectCell(i+1, prefix1+"wrk_perf_dt");
						return false;
					}else if(!isNull(sheetObj.CellValue(i, prefix1+"op_stpg_ctnt")) && isNull(sheetObj.CellValue(i+1, prefix1+"op_stpg_ctnt"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i+1, prefix1+"port_act_desc"), arrTitleNm[1]);
						sheetObj.SelectCell(i+1, prefix1+"op_stpg_ctnt");
						return false;
					}else if(!isNull(sheetObj.CellValue(i, prefix1+"src_svr_nm")) && isNull(sheetObj.CellValue(i+1, prefix1+"src_svr_nm"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i+1, prefix1+"port_act_desc"), arrTitleNm[2]);
						sheetObj.SelectCell(i+1, prefix1+"src_svr_nm");
						return false;
					} 
				}
				
				//Port Time Activity 이 'Drift/Anchor' 일때 Remark 필수입력 체크
				if(isNull(sheetObj.CellValue(i, prefix1+"diff_rmk"))){
					if(!isNull(sheetObj.CellValue(i, prefix1+"wrk_perf_dt"))){
						ComShowCodeMessage("OPF50025", sheetObj.CellValue(i, prefix1+"port_act_desc"), "Remark");
						sheetObj.SelectCell(i, prefix1+"diff_rmk");
						return false;
					}
				}
			}
			else
			{
				for(var j=0 ; j<arrRow.length-1 ; j++) {
					if(i == arrRow[j]) {
						if(sheetObj.CellValue(i, prefix1+"wrk_perf_dt") == "") {
							changeTab(0);
							ComShowCodeMessage("OPF50009", "Performance");
							sheetObj.SelectCell(i, prefix1+"wrk_perf_dt", true);
							return false;
						}
					}
				}
				
				//Format 체크 & Performance Date 체크
				if(sheetObj.CellValue(i, prefix1+"wrk_perf_dt") != "") {
					var val = sheetObj.CellValue(i, prefix1+"wrk_perf_dt");
					//Format 체크
					if(!checkDateFormat(sheetObj, i, prefix1+"wrk_perf_dt", val)) {
						return false;
					}
					//Performance Date 체크
					if(!checkPerformancePreDate(sheetObj, i, prefix1+"wrk_perf_dt", val)) return false;
					if(!checkPerformanceNextDate(sheetObj, i, prefix1+"wrk_perf_dt", val)) return false;
					if(!checkPerformanceMinMax(sheetObj, i, prefix1+"wrk_perf_dt", val)) return false;
				}
			}
		}
	}
	return true;
}

/**
 * Save 전 sheet2 Validation
 * @return
 */
function validateSheet2() {
	if(sheetObjects[2].IsDataModified) {
		//Tab2 필수 입력 사항 유무 체크
		if(isNullZero(sheetObjects[1].CellValue(1, prefix2+"twin_lift_cnt")) 
		&& isNullZero(sheetObjects[1].CellValue(1, prefix2+"dual_cycle_cnt"))
		&& isNullZero(sheetObjects[1].CellValue(1, prefix2+"restow_cnt"))
		&& sheetObjects[1].CellValue(1, prefix2+"diff_rmk") != "") {
			changeTab(1);
			ComShowCodeMessage("OPF50009", "Cargo Handling Count");
			sheetObjects[1].SelectCell(1, prefix2+"twin_lift_cnt", true);
			return false;
		}
	}
	return true;
}

/**
 * Tab change
 * @param selIdx
 * @return
 */
function changeTab(selIdx) {
	if(tabObjects[0].SelectedIndex != selIdx){
		tabObjects[0].SelectedIndex = selIdx;
	}
}

/**
 * Performance Date Format 체크
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function checkDateFormat(sheetObj, Row, Col, Value) {
	if(!ComIsDate(Value.substring(0, 8), "ymd") || !ComIsTime(Value.substring(8), "hm")) {
		changeTab(0);
		ComShowCodeMessage('COM12187', 'yyyy-mm-dd hh:mm');
		sheetObj.SelectCell(Row, Col, true);
		return false;
	}
	return true;
}

/**
 * Performance PreDate ±72 이내 체크
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function checkPerformancePreDate(sheetObj, Row, Col, Value) {
	for(var i = Row-1 ; i > 6 ; i--) {   //72h validation check에서 Drift,Anchor row(6개) 제외, 2013.05.14
		var preDate = sheetObj.CellValue(i, prefix1+"wrk_perf_dt");
		var portActCtnt = sheetObj.CellValue(Row, prefix1+"port_act_ctnt"); ////2012.09.05 [CHM-201220011] 추가 PTA0019
		if(ComIsDate(preDate.substring(0, 8), "ymd") && ComIsTime(preDate.substring(8), "hm")) {
			//2012.09.05 [CHM-201220011] 추가
			if( portActCtnt == "PTA0019" ) {
				var minDate = getAddHour(preDate, -360);  
				var maxDate = getAddHour(preDate, 360);
//				alert("minDate:"+minDate +", maxDate:"+maxDate);
				if(setString2Date(Value) < setString2Date(minDate) || setString2Date(Value) > setString2Date(maxDate)) {
					changeTab(0);
					ComShowCodeMessage("OPF50037", sheetObj.CellValue(Row, prefix1+"port_act_desc"), sheetObj.CellValue(i, prefix1+"port_act_desc"));
					sheetObj.SelectCell(Row, Col, true);  //OPF50034<-OPF50037
					return false;
				}else {
					return true;
				}
			} else {
				var minDate = getAddHour(preDate, -72);
				var maxDate = getAddHour(preDate, 72);
				if(setString2Date(Value) < setString2Date(minDate) || setString2Date(Value) > setString2Date(maxDate)) {
					changeTab(0);
					ComShowCodeMessage("OPF50031", sheetObj.CellValue(Row, prefix1+"port_act_desc"), sheetObj.CellValue(i, prefix1+"port_act_desc"));
					sheetObj.SelectCell(Row, Col, true);
					return false;
				}else {
					return true;
				}
			}
		}
	}
	return true;
}

/**
 * Performance NextDate ±72 이내 체크
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function checkPerformanceNextDate(sheetObj, Row, Col, Value) {
	if(Row > 6){       //72h validation check에서 Drift,Anchor row(6개) 제외, 2013.05.14
	for(var j = Row+1 ; j <= sheetObj.LastRow ; j++) {
		var nextDate = sheetObj.CellValue(j, prefix1+"wrk_perf_dt");
		var portActCtnt = sheetObj.CellValue(Row, prefix1+"port_act_ctnt"); ////2012.09.05 [CHM-201220011] 추가 PTA0019
		if(ComIsDate(nextDate.substring(0, 8), "ymd") && ComIsTime(nextDate.substring(8), "hm")) {
			//2012.09.05 [CHM-201220011] 추가
			if( portActCtnt == "PTA0018" ) {
				var minDate = getAddHour(nextDate, -360);  //-120 -> 240 -> 360
				var maxDate = getAddHour(nextDate, 360);
				if(setString2Date(Value) < setString2Date(minDate) || setString2Date(Value) > setString2Date(maxDate)) {
					changeTab(0);
					ComShowCodeMessage("OPF50037", sheetObj.CellValue(Row, prefix1+"port_act_desc"), sheetObj.CellValue(j, prefix1+"port_act_desc"));
					sheetObj.SelectCell(Row, Col, true);   //OPF50034<-OPF50037
					return false;
				}else {
					return true;
				}
			} else {
				var minDate = getAddHour(nextDate, -72);
				var maxDate = getAddHour(nextDate, 72);
				if(setString2Date(Value) < setString2Date(minDate) || setString2Date(Value) > setString2Date(maxDate)) {
					changeTab(0);
					ComShowCodeMessage("OPF50031", sheetObj.CellValue(Row, prefix1+"port_act_desc"), sheetObj.CellValue(j, prefix1+"port_act_desc"));
					sheetObj.SelectCell(Row, Col, true);
					return false;
				}else {
					return true;
				}
			}
		}
	}
	}
	return true;
}

/**
 * Performance Date 360 이내 체크
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function checkPerformanceMinMax(sheetObj, Row, Col, Value) {
	var minDate;
	var maxDate;
	var minRow;
	var maxRow;
	
	for(var i=sheetObj.HeaderRows+6 ; i<=sheetObj.LastRow ; i++) {  //360h validation check에서 Drift,Anchor row(6개) 제외, 2013.05.14
		var val = sheetObj.CellValue(i, prefix1+"wrk_perf_dt");
		if(!isNull(val)) {
			if(isNull(minDate) && isNull(maxDate)) {
				minDate = val;
				maxDate = val;
				minRow = i;
				maxRow = i;
			}
			if(setString2Date(val) < setString2Date(minDate)) {
				minDate = val;
				minRow = i;
			}
			if(setString2Date(val) > setString2Date(maxDate)) {
				maxDate = val;
				maxRow = i;
			}
		}
	}

	if(Row == minRow || Row == maxRow) {
		if(setString2Date(getAddHour(minDate, 360)) < setString2Date(maxDate)) { 
			changeTab(0);
			ComShowCodeMessage("OPF50036", sheetObj.CellValue(minRow, prefix1+"port_act_desc"), sheetObj.CellValue(maxRow, prefix1+"port_act_desc"));
			sheetObj.SelectCell(Row, Col, true);        //OPF50032<-OPF50036
			return false;
		}
	}
	return true;
}

/**
 * 해당 date 에 시간을 더해 Date 형으로 리턴한다.
 * @param date
 * @param val
 * @return String
 */
function getAddHour(date, val) {
	var dt = setString2Date(date);
	dt.setTime(Date.parse(dt)+(val*60*60*1000));

	var yy = dt.getFullYear();
	var mm = dt.getMonth()+1;
	var dd = dt.getDate();
	var hr = dt.getHours();
	var mi = dt.getMinutes();
	
	return yy + ComLpad(mm,2,"0") + ComLpad(dd,2,"0") + ComLpad(hr,2,"0") + ComLpad(mi,2,"0");
}

/**
 * OnSaveEnd 이벤트
 * @param sheetObj
 * @param ErrMsg
 */
function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

/**
 * OnSearchEnd 이벤트
 * @param sheetObj
 * @param ErrMsg
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		if(RowCount > 0) {
			setCellImage(sheetObj);
			ComBtnEnable("btn_save");
//			btn1Sts = true;
		}
	}
}

function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sheetObj2 = sheetObjects[2];
	var colNm = sheetObj.ColSaveName(Col);
	if(colNm == prefix2+"twin_lift_cnt") 
		sheetObj2.CellValue2(sheetObj2.FindText(prefix3+"port_act_ctnt", "CHT0001"), prefix3+"cntr_hndl_knt") = Value;
	else if(colNm == prefix2+"dual_cycle_cnt") 
		sheetObj2.CellValue2(sheetObj2.FindText(prefix3+"port_act_ctnt", "CHT0002"), prefix3+"cntr_hndl_knt") = Value;
	else if(colNm == prefix2+"restow_cnt") 
		sheetObj2.CellValue2(sheetObj2.FindText(prefix3+"port_act_ctnt", "CHT0003"), prefix3+"cntr_hndl_knt") = Value;
	else if(colNm == prefix2+"diff_rmk") {
		for(var i=1 ; i<=sheetObj2.LastRow ; i++) {
			sheetObj2.CellValue2(i, prefix3+"diff_rmk") = Value;
		}
	}
		
}

/**
 * OnSaveEnd 이벤트
 * @param sheetObj
 * @param ErrMsg
 */
function tmpsheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

function tmpsheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var sheetObj1 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj1.DataInsert();
	with(sheetObj) {
		if(RowCount > 0) {
			
			sheetObj1.CellValue2(1, prefix2+"twin_lift_cnt")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0001"), prefix3+"cntr_hndl_knt");
			sheetObj1.CellValue2(1, prefix2+"dual_cycle_cnt")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0002"), prefix3+"cntr_hndl_knt");
			sheetObj1.CellValue2(1, prefix2+"restow_cnt")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0003"), prefix3+"cntr_hndl_knt");
			sheetObj1.CellValue2(1, prefix2+"diff_rmk")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0001"), prefix3+"diff_rmk");
			
			//Creation date 최초값 찾기
			var twinListCreDt  = sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0001"), prefix3+"cre_dt");
			var dualCycleCreDt = sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0002"), prefix3+"cre_dt");
			var restowCreDt    = sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0003"), prefix3+"cre_dt");
			
			var iTwinListCreDt  = setString2Date(twinListCreDt);
			var iDualCycleCreDt = setString2Date(dualCycleCreDt);
			var iRestowCreDt    = setString2Date(restowCreDt);
			
			var gubun;
			
			if(iTwinListCreDt <= iDualCycleCreDt) {
				if(iTwinListCreDt <= iRestowCreDt) {
					gubun = "CHT0001";
				}else {
					gubun = "CHT0003";
				}
			}else {
				if(iDualCycleCreDt <= iRestowCreDt) {
					gubun = "CHT0002";
				}else {
					gubun = "CHT0003";
				}
			}
//			alert(gubun+":"+sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", gubun), prefix3+"cre_dt"));
			
			sheetObj1.CellValue2(1, prefix2+"cre_dt")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", gubun), prefix3+"cre_dt");
			sheetObj1.CellValue2(1, prefix2+"cre_usr_id")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", gubun), prefix3+"cre_usr_id");
			
			//Update date 최근값 찾기
			var twinListUpdDt  = sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0001"), prefix3+"upd_dt");
			var dualCycleUpdDt = sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0002"), prefix3+"upd_dt");
			var restowUpdDt    = sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", "CHT0003"), prefix3+"upd_dt");
			
			var iTwinListUpdDt  = setString2Date(twinListUpdDt);
			var iDualCycleUpdDt = setString2Date(dualCycleUpdDt);
			var iRestowUpdDt    = setString2Date(restowUpdDt);
			
			var gubun2;
			
			if(iTwinListUpdDt >= iDualCycleUpdDt) {
				if(iTwinListUpdDt >= iRestowUpdDt) {
					gubun2 = "CHT0001";
				}else {
					gubun2 = "CHT0003";
				}
			}else {
				if(iDualCycleUpdDt >= iRestowUpdDt) {
					gubun2 = "CHT0002";
				}else {
					gubun2 = "CHT0003";
				}
			}
			
			sheetObj1.CellValue2(1, prefix2+"upd_dt")
			= sheetObj.CellValue(sheetObj.FindText(prefix3+"port_act_ctnt", gubun2), prefix3+"upd_dt");
			
			ComBtnEnable("btn_save");
//			btn2Sts = true;
			
		}
	}
}


function setString2Date(sDate){
    sDate = sDate.replace(/\/|\-|\.|\:|\ /g,"");  //날짜구분자,시간구분자,스페이스 없애기
    
    var arr = ComNumberArray(7);
    var iLen = sDate.length;
    
    if (iLen>=4) arr[0]  = sDate.substr(0,4);		//year
	if (iLen>=6) arr[1]  = sDate.substr(4,2)-1;		//month
	if (iLen>=8) arr[2]  = sDate.substr(6,2);		//day
	
    if (iLen>=10) arr[3] = sDate.substr(8,2);		//hours
    if (iLen>=12) arr[4] = sDate.substr(10,2);		//minutes
    if (iLen>=14) arr[5] = sDate.substr(12,2);		//seconds
    if (iLen<=17) arr[6] = sDate.substr(14);		//hour
    
    return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
}

/**
 * Port OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function vps_port_cd_OnChange(comboObj, Code, Text){
//	sheetObjects[0].RemoveAll();
	setSheetData(sheetObjects[0]);
}

/**
 * 콤보필드에 데이터를 셋팅한다.
 * @param comboObj
 * @param comboItems
 */
function setComboItem(comboObj,comboItems) {
	comboObj.RemoveAll();
 	var dataList = comboItems.split("|");
 	
 	for (var i = 0 ; i < dataList.length ; i++) {                    		
 		var comboItem = dataList[i].split(",");
 		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[2]);
 	}
}

/**
 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
 * @param {arry} aryPopupData
 */
function setCallBackVSL(aryPopupData) {
	var formObj = document.form;
	formObj.vsl_cd.value = aryPopupData[0][1];
	formObj.skd_voy_no.focus();
} 
	
/**
 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
 * @param {arry} aryPopupData
 */
function setCallBackVVD(aryPopupData) {
	var formObj = document.form;
	formObj.skd_voy_no.value = aryPopupData[0][2];
	formObj.skd_dir_cd.value = aryPopupData[0][3];
	formObj.slan_cd.value    = aryPopupData[0][5];
	
	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix1+"vsl_cd") 	  = aryPopupData[0][1];
	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix1+"skd_voy_no") = aryPopupData[0][2];
	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix1+"skd_dir_cd") = aryPopupData[0][3];
	
	setPortLane(formObj.skd_voy_no.value+formObj.skd_dir_cd.value+formObj.slan_cd.value);
}

/**
 * Form Setting 및 Sheet Data Setting
 */
function initAll(){
	//Form Setting
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	sheetObj.Redraw = false;
	
	formObj.vsl_cd.value = "";
	formObj.skd_voy_no.value = "";
	formObj.skd_dir_cd.value = "";
	formObj.slan_cd.value = "";
	
	comboObjects[0].RemoveAll();
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	
	//Sheet Data Setting
	setSheetData(sheetObj);
	
	sheetObj.Redraw = true;
	
	formObj.vsl_cd.focus();
	
}

function setSheetData(sheetObj) {
	sheetObj.Redraw = false;
	sheetObj.RemoveAll();
	var arrData = initDataCd.split("|");
	
	for(var i=0 ; i<arrData.length ; i++) {
		sheetObj.DataInsert();
		var code = arrData[i].split(",");
		sheetObj.CellValue2(i+1, prefix1+"port_act_grp_desc") = code[0];
		sheetObj.CellValue2(i+1, prefix1+"port_act_desc") = code[1];
		sheetObj.CellValue2(i+1, prefix1+"port_act_ctnt") = code[2];
	}
	setCellImage(sheetObj);
	
	sheetObj.SelectCell(1, prefix1+"port_act_grp_desc");
	
	var sheetObj2 = sheetObjects[1];
	sheetObj2.RemoveAll();
	sheetObj2.DataInsert();
	
//	btn1Sts = false;
//	btn2Sts = false;
	ComBtnDisable("btn_save");
	
	sheetObj.Redraw = true;
}

/**
 * 필수 입력 사항 이미지 셋팅
 * @param sheetObj
 */
function setCellImage(sheetObj) {
	sheetObj.CellImage(sheetObj.FindText(prefix1+"port_act_ctnt", "PTA0018"), prefix1+"port_act_desc") = 0;
	sheetObj.CellImage(sheetObj.FindText(prefix1+"port_act_ctnt", "PTA0019"), prefix1+"port_act_desc") = 0;
}

/**
 * 화면 폼입력값에 Null Check
 * @param itemValue
 */
function isNull(itemValue){
    if(itemValue==null || itemValue=="null" || itemValue=="" || itemValue=="undefined"){
    	return true;
    }
    else{
    	return false;
    }
}

/**
 * 화면 폼입력값에 Null Zero Check
 * @param itemValue
 */
function isNullZero(itemValue){
    if(itemValue==null || itemValue=="null" || itemValue=="" || itemValue=="undefined" || itemValue==0){
    	return true;
    }
    else{
    	return false;
    }
}

/* 개발자 작업  끝 */