/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0033.js
 *@FileTitle : Monitoring Port Registration  
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.04.09
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.04 서창열
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
 * @class VOP_VSK_0033 : VOP_VSK_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0033() {
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
var sheetObjects = new Array();
var sheetCnt = 0;
var Ofc_cd_list = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_pop_ctn":
			var cnt_cd = formObj.cnt_cd.value;
			var loc_cd = formObj.loc_cd.value;
			var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
			ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 470, "countryCodeHelp",
					"1,0,1,1,1,1,1,1", true);
			break;

		case "btn_Retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;

		case "btn_close":
			self.close();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.cnt_cd.focus();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 282;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, true, true, false, false)

			var HeadTitle = "|Seq.|Country Name|Port|Port Name|VOSI RHQ|Office Code|Monitoring(Y/N)";

			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [	ROW, COL,  DATATYPE,   			WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus, 	30,	daCenter, 	false, 		prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,    		40,	daCenter,  	false);
			InitDataProperty(0, cnt++ , dtData,		   		170,daLeft,  	false,    	prefix+"cnt_nm",     			false, 		"", 		dfNone,		0,			false,		false,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,    			50,	daCenter,  	false,    	prefix+"loc_cd",    			false, 		"", 		dfNone,		0,			false,		false,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,    			170,daLeft,  	false,    	prefix+"loc_nm",    			false, 		"", 		dfNone,		0,			false,		false,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,    		70,	daCenter,  	false,    	prefix+"vskd_port_rhq_cd",		false, 		"", 		dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,   	 		70,	daCenter,  	false,    	prefix+"vop_port_ctrl_ofc_cd",  false, 		"", 		dfEngUpKey,	0,			true,		true,		6,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,   			60,	daCenter,  	false,    	prefix+"vop_port_mntr_flg", 	false, 		"", 		dfNone,		0,			true,		true,		1,			false,		false);
 
			InitDataCombo(0, prefix + "vop_port_mntr_flg", " Y|N", "Y|N");
			InitDataValid(0, prefix + "vop_port_ctrl_ofc_cd", vtEngUpOther, "0123456789");
			CountPosition = 0;
			SelectionMode = smSelectionList; // 추가
			// ColHidden("hiddencheck") = true;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;

			var prefix = sheetObj.id + "_";
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0033GS.do", sParam);
			ComOpenWait(false);

			Ofc_cd_list = ComGetEtcData(sXml, "vskOfcCd");
			var vskdPortRhqCd = ComGetEtcData(sXml, "vskdPortRhqCd");
			sheetObj.InitDataCombo(0, prefix + "vskd_port_rhq_cd", vskdPortRhqCd, 	vskdPortRhqCd);
			showSheetData(sheetObj, formObj, sXml);
		}
		break;

	case SEARCH02: // 조회
		    
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;

			var prefix = sheetObj.id + "_";
			var sParam = FormQueryString(formObj);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0033GS.do", sParam);
			ComOpenWait(false);

			Ofc_cd_list = ComGetEtcData(sXml, "vskOfcCd");
			
	
		break;	
		
	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;

			var sParam = ComGetSaveString(sheetObjects, false);
			if (sParam == ""){
				return;
			}
			sParam = sParam + "&" + FormQueryString(formObj);

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0033GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			ComOpenWait(false);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if (ComIsNull(formObj.cnt_cd.value)) {
			ComShowCodeMessage('VSK00027', "Country Code");
			formObj.cnt_cd.focus();
			return false;
		}
		break;

	}
	return true;
}

/**
 * 조회 후 처리로직.
 * 
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml) {
	var prefix = sheetObj.id + "_";
	var headCnt = sheetObj.HeaderRows;

	if (sXml != null) {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(sXml);

		var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
		if (dataNode) {
			var totValue = dataNode.value;

			if (totValue > 0) {
				sheetObj.Redraw = false;
				sheetObj.LoadSearchXml(sXml);
				var rowCnt = sheetObj.RowCount;
				sheetObj.Redraw = true;
			} else {
				sheetObj.LoadSearchXml(sXml);
			}
		} else {
			sheetObj.LoadSearchXml(sXml);
		}
	}
}

function sheet1_OnSearchEnd(sheetObj) {
	if (sheetObj.RowCount > 0) {
		for ( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
//			if (sheetObj.CellValue(i, "sheet1_vskd_port_rhq_cd") != "") {
//			2014.10.30 vskd_port_rhq_cd 항목을 변경할 수 있도록 처리함.
//				sheetObj.CellEditable(i, "sheet1_vskd_port_rhq_cd") = false;
//			}
//			sheetObj.CellValue2(i, "sheet1_ibflag") = "U";
			
			sheetObj.RowStatus(i) = "U";
		}
	}
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change', 'obj_change', form); // - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'obj_keypress', form); // - form 전체 컨트롤 중 dataformat 컨트롤의 처리
	axon_event.addListenerForm('keyup', 'obj_keyup', form); // - form 전체 컨트롤 중 dataformat 속성이 있는 이벤트에 코드 처리
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}

function obj_focus() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_change() {
	var formObj = document.form;
	var eleObj = window.event.srcElement;
	var srcName = eleObj.getAttribute("name");

	try {
		switch (srcName) {
		case "cnt_cd":
			if (eleObj.value.length == 2) {
				formObj.loc_cd.value = formObj.cnt_cd.value;
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "float":
		// 숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		// 영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		// 영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

function obj_keyup() {
	var formObj = document.form;
	var eleObj = window.event.srcElement;
	var srcName = eleObj.getAttribute("name");

	try {
		switch (srcName) {
		case "cnt_cd":
			if (eleObj.value.length == 2) {
				formObj.loc_cd.focus();
				formObj.loc_cd.value = formObj.cnt_cd.value;
			}
			break;

		case "loc_cd":
			if (eleObj.value.length == 5) {
				formObj.loc_nm.focus();
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Location by loc_cd 팝업에서 선택한 값 Setting.
 * 
 * @param rtnObjs
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function countryCodeHelp(rtnObjs, row, col, sheetIdx) {
	var formObj = document.form;
	formObj.cnt_cd.value = rtnObjs[0][3];
	formObj.loc_cd.focus();
	formObj.loc_cd.value = formObj.cnt_cd.value;
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var colSaveName = sheetObj.ColSaveName(Col);
	var headCnt = sheetObj.HeaderRows;
	var formObj = document.form;
	var sXml 	= null;
	
	switch(colSaveName){
		case "sheet1_vskd_port_rhq_cd":
			formObj.vop_port_rhq_cd.value = Value;
			
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			 
		break;
	
		case "sheet1_vop_port_ctrl_ofc_cd":
			
			var list = Ofc_cd_list.split("|");
			var mat = false;
			//alert(list);
			
			for( var i = 0 ; i < list.length ; i++ ){
				if( list[i] == Value ){
					mat = true;
				}
			}
			
			if( mat  ){
				
			}else{
				
				//ComShowCodeMessage('VSK00021',Value);
				//VSK00021
				//sheetObj.CellValue2( Row, Col ) = "";
			}
			
			break;
		
		default:
	}
}


/* 개발자 작업 끝 */