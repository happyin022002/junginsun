/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0008_02.js
 *@FileTitle : Expense Office Maintenance - Office Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.27 최정미
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
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는
 *        업무 스크립트를 정의한다.
 */
function cps_gem_0008_02() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.setComboObject = setComboObject;
	this.initCombo = initCombo;
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.initProperty = initProperty;
	this.newButtonClear = newButtonClear;
	this.isOfficeGubun = isOfficeGubun;
	this.isLangCheck = isLangCheck;
	this.isDeltFlg = isDeltFlg;	
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnMouseMove = sheet1_OnMouseMove;	
}

/* 개발자 작업 */

// ===================================================================================
// 공통전역변수
// ===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;

var sheet1 = null;
var sheet2 = null;

var frm = null;

// IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
 **/
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

//===================================================================================
//초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheet2 = sheetObjects[1];
	sheetCnt = sheetObjects.length;

	for (i = 0; i < sheetCnt; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	// combo
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}

	// html컨트롤 이벤트초기화
	initControl();
	
	 //iframe 사이즈 자동조절
	 resizeIframe("t2frame");
}

/**
* 화면 깜빡임 제거 하면서 로드시 초기Data조회
* @param sheetObj
* @return
*/
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;
	
	// 초기속성 지정
	initProperty(IBSEARCH);
		
	// 초기Data조회
	doActionIBSheet(IBSEARCH);

	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	sheetObj.WaitImageVisible = true;
}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
	comboObj.DropHeight = 190;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 405;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 18, 100);

			var HeadTitle1 = "|Office|CUR|Unit|Exchange\nRate|Control|Control|Control|Control|Control";
			var HeadTitle2 = "|Office|CUR|Unit|Exchange\nRate|RQST|RHQ/BU|TIC|COM|SLSOFCFLG";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
			
			InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"ofc_cd",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"locl_curr_cd", 	false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		"rqst_ut_val",		false,		"",			dfInteger);
			InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		"usd_locl_xch_rt",	false,		"",			dfInteger);
			InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"rqst_auth_flg",	false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"rhq_auth_flg",		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtCheckBox,			50,		daCenter,	true,		"tic_auth_flg",		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtCheckBox,			0,		daCenter,	true,		"cmit_auth_flg",	false,		"",			dfNone);
			
			// dtHidden
			InitDataProperty(0, cnt++ , dtHidden, 			60, 	daCenter, 	true,		"sls_ofc_flg", 		false, 		"", 		dfNone);
			
			sheetObj.HeadRowHeight = 23;
		}
		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 405;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 18, 100);

			var HeadTitle1 = "|Select|Expense|Expense|TIC|OFCCD|DELTFLG";
			var HeadTitle2 = "|Select|Code|Name|TIC|OFCCD|DELTFLG";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 2, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			// dtHiddenStatus
			InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		0,		daCenter,	true,		"delChk",		false,		"",			dfNone);
			
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"gen_expn_cd",	true,		"",			dfNone, 	0, true, true, 6, 	false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,		"expn_nm", 		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"tic_cd",		false,		"",			dfNone, 	0, true, true, 6, 	false, true, "", true);
			
			// dtHidden
			InitDataProperty(0, cnt++ , dtHidden, 		60, 	daCenter, 	true,		"ofc_cd", 		false, "", dfNone);
			InitDataProperty(0, cnt++ , dtHidden, 		60, 	daCenter, 	true,		"delt_flg", 	false, "", dfNone);
			
			InitDataValid(0,    "gen_expn_cd",   vtNumericOnly);
			InitDataValid(0,    "tic_cd",   vtEngUpOnly);
			
			sheetObj.HeadRowHeight = 23;
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction) {
	switch (sAction) {

		case IBSEARCH: // OPEN	  		
			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0013GS.do",FormQueryString(frm));
			var arrXml = sXml.split("|$$|");
  			
			// ---------------------------------
			// BU Office List(LEVEL2)
			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
			if (typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl1;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl, "", "");
	
				for ( var i = 0; i < comboListData.length; i++) {
					ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
				}
			}
	
			var langDiv = getColNameValue("sch_lang");
			// ---------------------------------
			// Group Expense
			// ---------------------------------
			var arrTempData = ComXml2ListMap(sXml);			
			combo1.InsertItem(0, "|", "");
			var k = 1;
			for ( var i = 0; i < arrTempData.length; i++) {
				var tempData = arrTempData[i];
	
				if (langDiv == "K") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|"+ tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if (langDiv == "E") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|"+ tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo1.Code = "";
	
			break;
		case SEARCHLIST: // 조회
			if (validateForm(sAction)) {
				frm.f_cmd.value = SEARCHLIST;
				frm.sch_expn_group.value = combo1.Code;
	
				var sXml = sheet1.GetSearchXml("CPS_GEM_0013GS.do",FormQueryString(frm));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheet1.LoadSearchXml(arrXml[0]);

					// 데이타가 존재하지 않는경우
					if (sheet1.RowCount <= 0) {
						sheet2.RemoveAll();
					}
				}
	
				if (arrXml.length > 1) {
					// sheet2
					sheet2.LoadSearchXml(arrXml[1]);
				}
				
				// 검색된 데이터의 값을 Setting
      			initProperty(sAction);
			}
			break;
		case SEARCHLIST01: // LEVEL3 조회
			frm.f_cmd.value = SEARCHLIST01;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
	
			// ---------------------------------
			// Major List(LEVEL3)
			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchMajorList").split("|");
			if (typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl2;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl, "", "");
	
				for (var i = 0; i < comboListData.length; i++) {
					ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
				}
			}
	
			break;
		case SEARCHLIST02: // LEVEL4 조회
			frm.f_cmd.value = SEARCHLIST02;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
	
			// ---------------------------------
			// Minor List(LEVEL4)
			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchMinorList").split("|");
			if (typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl3;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl, "", "");
	
				for (var i = 0; i < comboListData.length; i++) {
					ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
				}
			}
	
			break;
		case SEARCHLIST03: // sheet1에서 Row를 Click시 OFC_CD관련 EXPENSE 조회
			frm.f_cmd.value = SEARCHLIST03;
			var sXml = sheet2.GetSearchXml("CPS_GEM_0013GS.do",FormQueryString(frm));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				// sheet2
				sheet2.LoadSearchXml(arrXml[0]);
			}
			// 검색된 데이터의 값을 Setting
  			initProperty(SEARCHLIST03);
  			
			break;
		case SEARCHLIST04: // Group Expense
			frm.f_cmd.value = SEARCHLIST04;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0013GS.do",FormQueryString(frm));
	
			var langDiv = getColNameValue("sch_lang");
			var preCombo1 = combo1.Code;
			combo1.RemoveAll();
			// ---------------------------------
			// Group Expense
			// ---------------------------------
			var arrTempData = ComXml2ListMap(sXml);
			combo1.InsertItem(0, "|", "");
			var k = 1;
			for (var i = 0; i < arrTempData.length; i++) {
				var tempData = arrTempData[i];
	
				if (langDiv == "K") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|"+ tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if (langDiv == "E") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|"+ tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo1.Code = preCombo1;
			break;
		
		case IBSAVE: // 저장
			if(validateForm(sAction)) {
				// 저장하시겠습니까?
				if(!ComCodeMsgBySave()) return;
				
				frm.f_cmd.value = MULTI;
				var sXml = sheet2.DoSave("CPS_GEM_0008_02GS.do", FormQueryString(frm), -1, false);
				if(sXml) doActionIBSheet(SEARCHLIST);
				/*
				var sParam = FormQueryString(frm);
				var sParam1 = sheet2.GetSaveString(); 
				
				alert(sheet2.IsDataModified +"==>"+sParam1+"<");
				
				if (sheet2.IsDataModified && sParam1 == "") {				
					ComCodeMsgByNoContentsSave();
					return; 
				}
				sParam = sParam + "&" + sParam1;
				
    			var sXml = sheet2.GetSaveXml("CPS_GEM_0008_02GS.do", sParam);
				sheet2.LoadSearchXml(sXml);
				*/
			}
			break;
	
		case IBINSERT: // 입력
			break;
	}
}

//===================================================================================
//Form 이벤트 처리
// ===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
*/
function obj_keypress() {
	switch (event.srcElement.name) {
		case "sch_office_code":
			if(getColNameValue("sch_office_gbn") == "Y") ComKeyOnlyAlphabet('uppernum');
			else if(getColNameValue("sch_office_gbn") == "N") ComKeyOnlyNumber(event.srcElement);
			
			if(event.keyCode == 13) {doActionIBSheet(SEARCHLIST);}
			break;
	}
}

/**
* HTML Control Focus out
**/
function obj_deactivate() {
	switch (event.srcElement.name) {
		case "ofc_cd":
			break;
		default:
			//ComChkObjValid(event.srcElement);
	}
}

/**
* HTML Control Foucs in
*/
function obj_activate() {
	ComClearSeparator(event.srcElement);
}

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	// var sheetObject = sheetObjects[0];
	/** **************************************************** */
	// var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		// alert("srcName : "+srcName);
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(SEARCHLIST);
				break;
				
			case "btn_New":
				// Do you want to initialize unsaved data?
				if(!ComCodeMsgByInitializeUnsaved()) return;
				ComResetAll();
				newButtonClear();
				//combo1.RemoveAll();
				frm.sch_lvl1.focus();
				break;
				
			case "btn_Save":
				doActionIBSheet(IBSAVE);
				break;
				
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return false;
				}
				
				var selOfcCd = frm.hdn_ofc_cd.value;
				//sheet2.Down2Excel(1,false,false,true,"","",false,false,"Expense("+selOfcCd+")" );
				sheet2.SpeedDown2Excel(1,false,false,"","",false,false,"Expense("+selOfcCd+")");
			
				break;
				
			case "matrix_copy_btn":
				var param = "popup=Y";
				var url = "CPS_GEM_0110.do?" + param;
				var winName = "CPS_GEM_0110";
	
				var win = ComOpenWindowCenter(url, winName, 400, 260, false);
				win.focus();
				break;
				
			case "btn_RowAdd":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
				
				// Row Add시 속성값 초기화하기
				var row = sheet2.DataInsert(-1);				
				sheet2.SelectCell(row,"gen_expn_cd",true);
				sheet2.CellEditable(row, "expn_nm") = false;
				sheet2.CellEditable(row, "tic_cd") = false;
				
				break;
				
			case "btn_RowDelete":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
								
				ComRowHideDelete(sheet2, "delChk");
				break;			

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			// 지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
		}
	}
}

//===================================================================================
//Private function
// ===================================================================================
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sAction) {
	if (!ComChkValid(frm)) return false;

	if (sAction == SEARCHLIST) {
		if (frm.sch_lvl2.value != '') {
			if (!isRadioUnselected("sch_hohq_gbn")) {
				// GEM01040	ENG	W	HO or HQ를 선택하세요.
				ComShowCodeMessage("GEM01040");
				return false;
			}
		}
	} else if (sAction == IBSAVE) {
		
	}
	return true;
}

/**
* 검색된 데이터의 값을 체크해서 속성값을 Edittable시킴
* @return
*/
function initProperty(sAction) {
	switch (sAction) {
		case IBSEARCH: //Open시
			// 초기 Disabled
			// ComEnableObject(frm.sch_office_code, false);
			var obj = frm.sch_office_code;
			obj.disabled = true;
			obj.className = "input2";
			break;
		case SEARCHLIST:	// Retrive시
			// hidden text value settting
			frm.hdn_ofc_cd.value = sheet1.CellValue(2, "ofc_cd");
			frm.hdn_sls_ofc_flg.value = sheet1.CellValue(2, "sls_ofc_flg");
			
			if (sheet2.RowCount > 0) {
				for(var row=0; row<=sheet2.LastRow; row++) {
					sheet2.CellEditable(row, "gen_expn_cd") = false;
					sheet2.CellEditable(row, "expn_nm") = false;
					sheet2.CellEditable(row, "tic_cd") = false;
				}
			}
			break;
		case SEARCHLIST03:	// sheet1의 Row Click시
			if (sheet2.RowCount > 0) {
				for(var row=0; row<=sheet2.LastRow; row++) {
					sheet2.CellEditable(row, "gen_expn_cd") = false;
					sheet2.CellEditable(row, "expn_nm") = false;
					sheet2.CellEditable(row, "tic_cd") = false;
				}
			}
			break;
	}
}

/**
* New버튼 클릭시 초기화 이벤트
*/
function newButtonClear() {
	// sch_office_code
	// 초기 Disabled
	// ComEnableObject(frm.sch_office_code, false);
	var obj = frm.sch_office_code;
	obj.disabled = true;
	obj.className = "input2";
}

/**
 * Office인경우 Y, Expense인경우 N
 */
function isOfficeGubun(val) {
	var obj = frm.sch_office_code;
	obj.disabled = false;
	obj.className = "input";
	obj.value = "";
	obj.focus();
}

/**
 * 검색 언어 선택시 Expense, Accout, Group Expense의 값을 변경
 */
function isLangCheck(val) {
	// group expense
	doActionIBSheet(SEARCHLIST04);
}

/**
 * Delete Data를 조회한다.
 */
function isDeltFlg(val) {
	doActionIBSheet(SEARCHLIST);
}

//===================================================================================
//Sheet 이벤트 처리
// ===================================================================================
/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {ibsheet}
 *            row sheetObj의 선택된 Row
 * @param {ibsheet}
 *            col sheetObj의 선택된 Col
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	frm.hdn_ofc_cd.value = sheet1.CellValue(row, "ofc_cd");
	frm.hdn_sls_ofc_flg.value = sheet1.CellValue(row, "sls_ofc_flg");
	doActionIBSheet(SEARCHLIST03);
	
	
}

/**
 * sheet1 MouseMove 이벤트 
 * @param {ibsheet} sheet 해당 시트   
 * @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {long} X X 좌표
 * @param {long} Y Y 좌표
 */
function sheet1_OnMouseMove(sheet, button, shift, X, Y) {
	var sName = sheet1.ColSaveName(sheet1.MouseCol);
	if ("ofc_cd" == sName) {
		sheet1.MousePointer = "Hand";
	} else {
		sheet1.MousePointer = "Default";
	}
}

/**
* 셀의 값이 바뀌었을 때 발생하는 Event
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet2_OnChange(sheetObj, row, col) {
	switch (sheetObj.ColSaveName(col)) {
		case "gen_expn_cd" :
			// 1. 검색조건 expense, expense_group, lang_div의 값을전달
			// 2. sheet1의 ofc_cd, sls_div_flg값을 전달
			// 3. sheet2의 expense code의 값이 변경되었을경우 
			// 3_1. 입력된 Expense Code가 Level = '4'인지를 확인
			// 3_2. 입력된 Expense Code가 중복인지를 확인
			// 3_3. sheet1의 sls_div_flg가 Y인경우 gem_expense table의 gen_expn_sls_div_cd의 값이 C, Y인 Expense Code만 입력가능
			// 3_4. sheet1의 sls_div_flg가 N인경우 gem_expense table의 gen_expn_sls_div_cd의 값이 C, N인 Expense Code만 입력가능
						
			frm.f_cmd.value = SEARCHLIST01;
			var param = "?sch_office_code="+sheetObj.CellValue(row, "gen_expn_cd");			
			var sXml = sheet2.GetSearchXml("CPS_GEM_0008_02GS.do"+param, FormQueryString(frm));			
			var arrXml = sXml.split("|$$|");
			
			var errCode = ComGetEtcData(arrXml[0], "code").split("|");
			if (errCode != "0") {
				if (errCode == "1") {
					//GEM01015	ENG	W	데이터가 유효하지 않습니다.
					ComShowCodeMessage("GEM00001", "Expense Code");
				} else if (errCode == "2") {
					//GEM01015	ENG	W	입력 데이터가 중복되었습니다.
					ComShowCodeMessage("GEM00002", "Expense Code");
				} else if (errCode == "3") {
					//GEM01048	ENG	W	3_1에 위배되는경우 공통 및 영업비용 코드만 입력가능합니다. 
					ComShowCodeMessage("GEM01048");
				} else if (errCode == "4") {
					//GEM01049	ENG	W	3_1에 위배되는경우 공통 및 관리비용 코드만 입력가능합니다.
					ComShowCodeMessage("GEM01049");
				} 
				sheetObj.CellValue2(row, "gen_expn_cd") = "";
				sheetObj.SelectCell(row, "gen_expn_cd", true);
			}
			else if (errCode == "0") {
				// 입력된 Expense Code가 사용가능하면..
				var arrTempData = ComXml2ListMap(sXml);
				for (var i = 0; i < arrTempData.length; i++) {
					var tempData = arrTempData[i];
					
					sheetObj.CellValue2(row, "expn_nm") = tempData["expn_nm"];
					sheetObj.CellValue2(row, "tic_cd") = tempData["tic_cd"];
					sheetObj.CellValue2(row, "ofc_cd") = frm.hdn_ofc_cd.value;
				}				
			}			
			
			break;
	}
}

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
function combo1_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	comFocusChange('document.form.sch_lang[0]');
}

/**
 * 선택된 Item이 변경되었을 때 이벤트가 발생한다.
 * @param comboObj
 * @param KeyCode
 * @param Shift
 * @return
 */
function combo1_OnKeyUp(comboObj, KeyCode, Shift) {
	var sText = comboObj.Text;
	// 숫6자리만 입력
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		if (sText.length == 6) {
			frm.sch_expn_group.value = sText;
			// 다음 포커스로 이동
			comFocusChange('document.form.sch_lang[0]');
		}
	} else { 
		comboObj.Text = ""; 
	}
}

/* 개발자 작업 끝 */