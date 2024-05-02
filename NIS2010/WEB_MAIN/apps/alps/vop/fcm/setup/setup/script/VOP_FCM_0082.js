/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0082.js
 *@FileTitle : Item Registration
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.01.02
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
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
 * @class VOP_FCM_0011 : VOP_FCM_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0082() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//grid combo
var comboText = "Y|N";
var comboCode = "Y|N"

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_Row_Add":
			    rowInsert(sheetObjects);
			break;
			
		case "btn_Row_Delete":
			if (sheetObjects[0].RowCount > 0) {
				rowDelete(sheetObjects)
	    	}
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
		
	}

//	showSheetData(sheetObjects[0])
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListener('keypress', 'eng_keypress', 'vsl_cd', 'vsl_eng_nm', 'crr_cd', 'call_sgn_no', 'lloyd_no'); // 영문 대문자만 입력하기
	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'crr_cd');

}

/**
 * Lease Term  클릭 이벤트 등록
 */
function skd_dir_cd_OnCheckClick(comboObj, index, code) {
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


function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;

	switch (event.srcElement.name) {
	case "vsl_cd":
		if (val == "") {
			formObj.vsl_eng_nm.value = "";
			formObj.tmp_vsl_cd.value = "";
		}

		if (!obj || val == "" || ComChkLen(val, 4) != 2) {
			break;
		}
		if (formObj.tmp_vsl_cd.value != obj.value) {
			sheetObj = sheetObjects[0];
			//doActionIBSheet(sheetObj, formObj, SEARCH01);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;

	case "crr_cd":
		if (val == "") {
			formObj.tmp_crr_cd.value = "";
		}

		if (!obj || val == "" || ComChkLen(val, 3) != 2) {
			break;
		}
		if (formObj.tmp_crr_cd.value != obj.value) {
			sheetObj = sheetObjects[0];
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			obj.focus();
		}
		break;
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function eng_keypress() {
	var obj = event.srcElement;
	switch (obj.name) {
	case "vsl_eng_nm":
		
		// CHM-201005418-01
		// 특수키(-, <, >, ., /, ', (, ), &, #) 입력되도록 수정
		var availKeyCode = "";
		if (event.keyCode === 32 // 공백입력가능
				|| event.keyCode === 45 // - 입력가능
				|| event.keyCode === 60 // < 입력가능
				|| event.keyCode === 62 // > 입력가능
				|| event.keyCode === 46 // . 입력가능
				|| event.keyCode === 47 // / 입력가능
				|| event.keyCode === 39 // ' 입력가능
				|| event.keyCode === 40 // ( 입력가능
				|| event.keyCode === 41 // ) 입력가능
				|| event.keyCode === 38 // & 입력가능
				|| event.keyCode === 35 // # 입력가능
				) {
			availKeyCode = String(event.keyCode); 
		}
		ComKeyOnlyAlphabet('uppernum', availKeyCode);
		break;
	case "vsl_cd":
	case "call_sgn_no":
		ComKeyOnlyAlphabet("uppernum");
		break;
	case "lloyd_no":
		ComKeyOnlyAlphabet("uppernum", "46"); // 영대문자, 숫자, 마침표 입력가능
		break;
	default:
		ComKeyOnlyAlphabet('upper');
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
    var sheetID = sheetObj.id;
	switch (sheetID) {
	
    case "sheet1":      //sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 500;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|SEL|Design\nCapa|Class\nSub Code|Item|Sub\nItem\n(Type)|Consumption\nRatio\n(%)|Unit\nPrice\n(USD)|trnd_line_seq1|Speed-load|Speed-load|Speed-load|Speed-load|TLSeq2|Speed-FOC|Speed-FOC|Speed-FOC|Speed-FOC|Add-Saving Ratio|Add-Saving Ratio|Add-Saving Ratio";
			var HeadTitle2 ="||Design\nCapa|Class\nSub Code|Item|Sub\nItem\n(Type)|Consumption\nRatio\n(%)|Unit\nPrice\n(USD)|trnd_line_seq1|Trend \nLine No.|X2|X|A|trnd_line_seq2|Trend \nLine No.|X2|X|A|X2|X|A"
			
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			sheetObj.FrozenCols = 3;
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet1_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	false,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		25,	daCenter,	true,	prefix+"Sel");
			InitDataProperty(0, cnt++ , dtCombo,		50,	daCenter,	true,	prefix+"cntr_vsl_clss_capa",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtCombo,		60,	daCenter,	true,	prefix+"vsl_clss_sub_cd",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		65,	daCenter,	true,	prefix+"sav_itm_cd",		false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtCombo,		45,	daCenter,	true,	prefix+"sav_csm_sub_itm_cd",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix+"itm_csm_rto",			false,	"",		dfNone,			10,			true,		true,7);
			InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,	prefix+"itm_ut_prc",			false,	"",		dfNone,			0,			true,		true,15);
			InitDataProperty(0, cnt++ , dtHidden,		60, daCenter,  false,   prefix+"trnd_line_seq1",        false,  "",     dfNone,	        0,          false,      false);
			InitDataProperty(0, cnt++ , dtPopup,		60,	daCenter,	false,	prefix+"trnd_line_no1",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	prefix+"n1st_coef_val1",		false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	prefix+"n2nd_coef_val1",		false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	prefix+"trnd_line_cons_val1",				false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtHidden,		60, daCenter,  false,   prefix+"trnd_line_seq2",        false,  "",     dfNone,	        0,          false,      false);
			InitDataProperty(0, cnt++ , dtPopup,		60,	daCenter,	false,	prefix+"trnd_line_no2",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	prefix+"n1st_coef_val2",		false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	prefix+"n2nd_coef_val2",		false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	prefix+"trnd_line_cons_val2",				false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	prefix+"n1st_coef_val3",		false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	prefix+"n2nd_coef_val3",		false,	"",		dfNone,			0,			true,		true,40);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	prefix+"trnd_line_cons_val3",				false,	"",		dfNone,			0,			true,		true,40);
			
			
			InitDataCombo(0, prefix+"sav_itm_cd",       "T/C Cut-Off|Additive|Hull Paint", "01|02|03");
			InitDataCombo(0, prefix+"sav_csm_sub_itm_cd",   "N", "N");
			//InitDataCombo(0, prefix+"vsl_clss_sub_cd", " |A|B|C|D|E", "|A|B|C|D|E");
			
			InitDataValid(0, prefix+"itm_csm_rto",  vtNumericOther,".");		
			InitDataValid(0, prefix+"itm_ut_prc",   vtNumericOther,"-.");
			
			InitDataCombo(0, prefix+"cntr_vsl_clss_capa", document.form.classList.value, document.form.classList.value);
	
		
			InitDataValid(0, prefix+"n1st_coef_val1",   vtNumericOther,".-");
			InitDataValid(0, prefix+"n2nd_coef_val1",   vtNumericOther,".-");	 
			InitDataValid(0, prefix+"trnd_line_cons_val1",        vtNumericOther,".-");	
			
			InitDataValid(0, prefix+"n1st_coef_val2",   vtNumericOther,".-");
			InitDataValid(0, prefix+"n2nd_coef_val2",   vtNumericOther,".-");	
			InitDataValid(0, prefix+"trnd_line_cons_val2",        vtNumericOther,".-");	
			
			InitDataValid(0, prefix+"n1st_coef_val3",   vtNumericOther,".-");
			InitDataValid(0, prefix+"n2nd_coef_val3",   vtNumericOther,".-");	
			InitDataValid(0, prefix+"trnd_line_cons_val3",        vtNumericOther,".-");	
			
			CountPosition = 2;
		}
		break;
    case "sheet2":      //sheet1 init
	    with (sheetObj) {
	    	tabIndex = -1;
	
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
	
			var HeadTitle ="|itm_trnd_line_cd|vsl_clss_sub_cd|sav_itm_cd|sav_csm_sub_itm_cd|itm_csm_rto|itm_ut_prc|cntr_vsl_clss_capa|trnd_line_seq|trnd_line_no|n1st_coef_val|n2nd_coef_val|trnd_line_cons_val"
			var headCount = ComCountHeadTitle(HeadTitle);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			sheetObj.FrozenCols = 3;
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet2_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	prefix+"itm_trnd_line_cd");
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	prefix+"vsl_clss_sub_cd",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	prefix+"sav_itm_cd",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	prefix+"sav_csm_sub_itm_cd",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	prefix+"itm_csm_rto",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,	prefix+"itm_ut_prc",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"cntr_vsl_clss_capa",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"trnd_line_seq",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"trnd_line_no",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"n1st_coef_val",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix+"n2nd_coef_val",						false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix+"trnd_line_cons_val",							false,	"",			dfNone,			0,			false,		false);
		
			CountPosition = 2;
		}
    break;	
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
	//	if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
	        sheetObj.RemoveAll();
			formObj.f_cmd.value = SEARCH;
			var aryPrefix = new Array("sheet2_");	//prefix 문자열 배열
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0082GS.do",
					FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
			sheetObj.LoadSearchXml(rXml);
			
			show_DataSet(sheetObjects)//조회후 sheet2의값을 sheet1에셋팅하여 보여줌
			
			ComOpenWait(false);
	//		showSheetData(sheetObjects[0])
	//	}
		break;

	case IBSAVE:
		if (!validateForm(sheetObj, formObj, sAction)) {
			ComShowMessage("There is no updated item.");
			return false;
		}
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		 var aryPrefix = new Array("sheet2_");	//prefix 문자열 배열
		 
		 sheet_DataSet(sheetObjects) //저장하기 전에 sheet1의값을 sheet2에 셋팅
		 var SaveStr = ComGetSaveString(sheetObjects);
		 
		 var sXml = sheetObj.GetSaveXml("VOP_FCM_0082GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		 ComOpenWait(false);
		 doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		break;

	}
}
/**
* 보여주기위한 값셋팅 select2후 sheet1의 값을 sheet1에 셋팅  <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {String} 	prefix   	변수 구분값
* @param {String} 	flag   		Row Add/Row Ins의 구분값
* @return {없음}
**/
function show_DataSet(sheetObjs){
	 var j =1
	  sheetObjs[0].RemoveAll();
	  for(var i=0;i<sheetObjs[1].RowCount;i++){  
		   if(sheetObjs[1].CellValue(i+1,"sheet2_itm_trnd_line_cd") == "01"){
			   j++;
			   sheetObjs[0].DataInsert(-1);
			   sheetObjs[0].CellValue2(j,"sheet1_ibflag")             = sheetObjs[1].CellValue(i+1,"sheet2_ibflag")
			   sheetObjs[0].CellValue2(j,"sheet1_sav_itm_cd")         = sheetObjs[1].CellValue(i+1,"sheet2_sav_itm_cd")
			   sheetObjs[0].CellValue2(j,"sheet1_vsl_clss_sub_cd")         = sheetObjs[1].CellValue(i+1,"sheet2_vsl_clss_sub_cd")
	           sheetObjs[0].CellValue2(j,"sheet1_sav_csm_sub_itm_cd")     = sheetObjs[1].CellValue(i+1,"sheet2_sav_csm_sub_itm_cd")
	           sheetObjs[0].CellValue2(j,"sheet1_itm_csm_rto")        = sheetObjs[1].CellValue(i+1,"sheet2_itm_csm_rto")       
	           sheetObjs[0].CellValue2(j,"sheet1_itm_ut_prc")         = sheetObjs[1].CellValue(i+1,"sheet2_itm_ut_prc")        
	           sheetObjs[0].CellValue2(j,"sheet1_cntr_vsl_clss_capa") = sheetObjs[1].CellValue(i+1,"sheet2_cntr_vsl_clss_capa")
	           sheetObjs[0].CellValue2(j,"sheet1_trnd_line_seq1")     = sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_seq")     
	           sheetObjs[0].CellValue2(j,"sheet1_trnd_line_no1")  = sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_no")
	           sheetObjs[0].CellValue2(j,"sheet1_n1st_coef_val1")     = sheetObjs[1].CellValue(i+1,"sheet2_n1st_coef_val")     
	           sheetObjs[0].CellValue2(j,"sheet1_n2nd_coef_val1")     = sheetObjs[1].CellValue(i+1,"sheet2_n2nd_coef_val")     
	           sheetObjs[0].CellValue2(j,"sheet1_trnd_line_cons_val1")          = sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_cons_val")          
		   }else if(sheetObjs[1].CellValue(i+1,"sheet2_itm_trnd_line_cd") == "02"){
			   sheetObjs[0].CellValue2(j,"sheet1_trnd_line_seq2") = sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_seq")
			   sheetObjs[0].CellValue2(j,"sheet1_trnd_line_no2")  = sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_no")
			   sheetObjs[0].CellValue2(j,"sheet1_vsl_clss_sub_cd")         = sheetObjs[1].CellValue(i+1,"sheet2_vsl_clss_sub_cd")
		       sheetObjs[0].CellValue2(j,"sheet1_n1st_coef_val2") = sheetObjs[1].CellValue(i+1,"sheet2_n1st_coef_val")
		       sheetObjs[0].CellValue2(j,"sheet1_n2nd_coef_val2") = sheetObjs[1].CellValue(i+1,"sheet2_n2nd_coef_val")
		       sheetObjs[0].CellValue2(j,"sheet1_trnd_line_cons_val2")      = sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_cons_val")      
		   }else if(sheetObjs[1].CellValue(i+1,"sheet2_itm_trnd_line_cd") == "03"){
			   sheetObjs[0].CellValue2(j,"sheet1_n1st_coef_val3") =  sheetObjs[1].CellValue(i+1,"sheet2_n1st_coef_val") 
			   sheetObjs[0].CellValue2(j,"sheet1_n2nd_coef_val3") =  sheetObjs[1].CellValue(i+1,"sheet2_n2nd_coef_val")
			   sheetObjs[0].CellValue2(j,"sheet1_trnd_line_cons_val3")      =  sheetObjs[1].CellValue(i+1,"sheet2_trnd_line_cons_val")   
		   }
	       
			sheetObjs[0].RowStatus(j) = "R";
		}
	 sheetObjs[1].RemoveAll();
}	

/**
* 저장하기 위하여 값을 셋팅 SHEET1의 값을 SHEET2로 셋팅 <br>
* @param {ibsheet} sheetObjs    IBSheet Objects
* @return {없음}
**/
function sheet_DataSet(sheetObjs){
	
	var sheetObjView = sheetObjs[0];
	var sheetObjData = sheetObjs[1];
	
	var startRow = sheetObjView.HeaderRows;
	var endRow = startRow + sheetObjView.RowCount;
	var tgtRow;
	
	for(var i=startRow;i<endRow;i++){
		if(sheetObjView.RowStatus(i)=="R"){
			continue;
		}
		 
		var j = sheetObjData.RowCount;
		tgtRow = sheetObjData.DataInsert(-1);
		
		if(sheetObjView.RowStatus(i)=="D"){
			sheetObjData.RowStatus(tgtRow) = "U";
			sheetObjData.RowStatus(tgtRow)="D";
		}else{
			sheetObjData.RowStatus(tgtRow) = sheetObjView.RowStatus(i);
		}
		
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_trnd_line_cd") ="01" ;
		sheetObjData.CellValue2(tgtRow,"sheet2_sav_itm_cd") = sheetObjView.CellValue(i,"sheet1_sav_itm_cd");
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_nm") = sheetObjView.CellText(i,"sheet1_sav_itm_cd")
		sheetObjData.CellValue2(tgtRow,"sheet2_sav_csm_sub_itm_cd") = sheetObjView.CellValue(i,"sheet1_sav_csm_sub_itm_cd"); 
		sheetObjData.CellValue2(tgtRow,"sheet2_vsl_clss_sub_cd") = sheetObjView.CellValue(i,"sheet1_vsl_clss_sub_cd"); 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_csm_rto") = sheetObjView.CellValue(i,"sheet1_itm_csm_rto");
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_ut_prc") = sheetObjView.CellValue(i,"sheet1_itm_ut_prc");
		sheetObjData.CellValue2(tgtRow,"sheet2_cntr_vsl_clss_capa") = sheetObjView.CellValue(i,"sheet1_cntr_vsl_clss_capa");
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_seq") = sheetObjView.CellValue(i,"sheet1_trnd_line_seq1");
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_no") = sheetObjView.CellValue(i,"sheet1_trnd_line_no1");
		sheetObjData.CellValue2(tgtRow,"sheet2_n1st_coef_val") = sheetObjView.CellValue(i,"sheet1_n1st_coef_val1");
		sheetObjData.CellValue2(tgtRow,"sheet2_n2nd_coef_val") = sheetObjView.CellValue(i,"sheet1_n2nd_coef_val1"); 
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_cons_val") = sheetObjView.CellValue(i,"sheet1_trnd_line_cons_val1");
		
		tgtRow = sheetObjData.DataInsert(-1);
		if(sheetObjView.RowStatus(i)=="D"){
			sheetObjData.RowStatus(tgtRow) = "U";
			sheetObjData.RowStatus(tgtRow)="D";
		}else{
			sheetObjData.RowStatus(tgtRow) = sheetObjView.RowStatus(i);
		}
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_trnd_line_cd") ="02" ;
		sheetObjData.CellValue2(tgtRow,"sheet2_sav_itm_cd") = sheetObjView.CellValue(i,"sheet1_sav_itm_cd") 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_nm") = sheetObjView.CellText(i,"sheet1_sav_itm_cd") 
		sheetObjData.CellValue2(tgtRow,"sheet2_sav_csm_sub_itm_cd") = sheetObjView.CellValue(i,"sheet1_sav_csm_sub_itm_cd") 
		sheetObjData.CellValue2(tgtRow,"sheet2_vsl_clss_sub_cd") = sheetObjView.CellValue(i,"sheet1_vsl_clss_sub_cd"); 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_csm_rto") = sheetObjView.CellValue(i,"sheet1_itm_csm_rto") 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_ut_prc") = sheetObjView.CellValue(i,"sheet1_itm_ut_prc") 
		sheetObjData.CellValue2(tgtRow,"sheet2_cntr_vsl_clss_capa") = sheetObjView.CellValue(i,"sheet1_cntr_vsl_clss_capa")
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_seq") = sheetObjView.CellValue(i,"sheet1_trnd_line_seq2")
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_no") = sheetObjView.CellValue(i,"sheet1_trnd_line_no2")
		sheetObjData.CellValue2(tgtRow,"sheet2_n1st_coef_val") = sheetObjView.CellValue(i,"sheet1_n1st_coef_val2") 
		sheetObjData.CellValue2(tgtRow,"sheet2_n2nd_coef_val") = sheetObjView.CellValue(i,"sheet1_n2nd_coef_val2") 
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_cons_val") = sheetObjView.CellValue(i,"sheet1_trnd_line_cons_val2") 

		tgtRow = sheetObjData.DataInsert(-1);
		if(sheetObjView.RowStatus(i)=="D"){
			sheetObjData.RowStatus(tgtRow) = "U";
			sheetObjData.RowStatus(tgtRow)="D";
		}else{
			sheetObjData.RowStatus(tgtRow) = sheetObjView.RowStatus(i);
		}
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_trnd_line_cd") ="03" ;
		sheetObjData.CellValue2(tgtRow,"sheet2_sav_itm_cd") = sheetObjView.CellValue(i,"sheet1_sav_itm_cd") 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_nm") = sheetObjView.CellText(i,"sheet1_sav_itm_cd") 
		sheetObjData.CellValue2(tgtRow,"sheet2_sav_csm_sub_itm_cd") = sheetObjView.CellValue(i,"sheet1_sav_csm_sub_itm_cd") 
		sheetObjData.CellValue2(tgtRow,"sheet2_vsl_clss_sub_cd") = sheetObjView.CellValue(i,"sheet1_vsl_clss_sub_cd"); 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_csm_rto") = sheetObjView.CellValue(i,"sheet1_itm_csm_rto") 
		sheetObjData.CellValue2(tgtRow,"sheet2_itm_ut_prc") = sheetObjView.CellValue(i,"sheet1_itm_ut_prc") 
		sheetObjData.CellValue2(tgtRow,"sheet2_cntr_vsl_clss_capa") = sheetObjView.CellValue(i,"sheet1_cntr_vsl_clss_capa")
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_seq") =""
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_no") =""
		sheetObjData.CellValue2(tgtRow,"sheet2_n1st_coef_val") = sheetObjView.CellValue(i,"sheet1_n1st_coef_val3") 
		sheetObjData.CellValue2(tgtRow,"sheet2_n2nd_coef_val") = sheetObjView.CellValue(i,"sheet1_n2nd_coef_val3") 
		sheetObjData.CellValue2(tgtRow,"sheet2_trnd_line_cons_val") = sheetObjView.CellValue(i,"sheet1_trnd_line_cons_val3");
		
		
		if(sheetObjView.RowStatus(i)=="D"){
			sheetObjData.RowStatus(tgtRow)="D";
		}
	       
	}
}	


/**
 * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix   	변수 구분값
 * @param {String} 	flag   		Row Add/Row Ins의 구분값
 * @return {없음}
 **/
function rowInsert(sheetObjs){
	var sheetObj = sheetObjs[0]; 
	sheetObj.Redraw = false;
	var row =sheetObj.DataInsert(-1);
	sheetObj.Redraw = true;
}

/**
 * IBSheet의 각 탭에 대한 Row를 삭제한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	flag   		Row Add/Row Ins의 구분값
 * @return {없음}
 **/ 
function rowDelete(sheetObjs){
	for(var i=0;i<sheetObjs[0].RowCount;i++){	  
		if(sheetObjs[0].CellValue(i+2,"sheet1_Sel") == 1){
			sheetObjs[0].RowHidden(i+2) = true;
			sheetObjs[0].RowStatus(i+2) = "D";
		}
	}
}

 /**
  * IBSheet2의  Row를 전부삭제 <br>
  * @param {ibsheet} sheetObj    IBSheet Object
  * @return {없음}
  **/
 function sheet2_rowDelete(sheetObjs){
	  for(var i=0;i<sheetObjs.RowCount;i++){	
			  sheetObjs.RowDelete(i, false);
	  }
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	switch(sAction){
		case IBSAVE:
			//sheetObj에 업데이트 내용이 있을 경우에 true, 그렇지 않으면 false
			var start = sheetObj.HeaderRows;
			var end = sheetObj.HeaderRows + sheetObj.SearchRows;
			var isUpdate = false;
			
			for(var i=start; i<start+end; i++){
				if(sheetObj.RowStatus(i)!="R"){
					isUpdate = true;
					break;
				}
			}
			return isUpdate;
			break;
			
		default:
			return true;
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
//	showData(sheetObj, Row);
	switch (sheetObj.ColSaveName(Col)) {
		case "sheet1_sav_itm_cd" :
			if(Value=="01"){
				sheetObj.CellComboItem(Row, "sheet1_sav_csm_sub_itm_cd",   "", "");
			}else{
				sheetObj.CellComboItem(Row, "sheet1_sav_csm_sub_itm_cd",   "A|B|C|D|E", "A|B|C|D|E");
			}
		break;
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	var saveName = sheetObj.ColSaveName(Col);
	switch(saveName){
		case "sheet1_trnd_line_no1":
		case "sheet1_trnd_line_no2":
		case "sheet1_trnd_line_no3":
			var sUrl = "VOP_FCM_0014.do";
			var rVal = ComOpenPopup(sUrl, 1015, 650, "setTrndLineInfo", "0,0", true, false, Row, Col, 0);
			break;
	}
}

function setTrndLineInfo(aryPopupData, row, col, sheetIdx){
	// aryPopupData : 팝업창에서 선책한 Row의 모든 데이터가 2x2 배열에 담겨있음. 순서는 팝업창 시트의 컬럼 정의 순서
	var sheetObj = sheetObjects[sheetIdx];
	var Row = Number(row);
	var Col = Number(col);
	
	sheetObj.CellValue2(Row, Col-1) = aryPopupData[0][0]; //trnd_line_seq
	sheetObj.CellValue2(Row, Col) = aryPopupData[0][14]; //trnd_line_no
	sheetObj.CellValue2(Row, Col+1) = aryPopupData[0][8]; //x2 계수
	sheetObj.CellValue2(Row, Col+2) = aryPopupData[0][9]; //x계수
	sheetObj.CellValue2(Row, Col+3) = aryPopupData[0][10]; //상수
}

function sheet1_OnClick(sheetObject, Row, Col, Value) {	 
	if(Col == '3'){
		var formObj = document.form;
		var cntr_vsl_clss_capa = sheetObject.CellValue(Row,"sheet1_cntr_vsl_clss_capa");
		var param = "f_cmd=" +SEARCH01;
		param += "&cntr_vsl_clss_capa=" + cntr_vsl_clss_capa
		var sXml = sheetObject.GetSearchXml("VOP_FCM_0082GS.do", param);	
		var sStr = ComGetEtcData(sXml,"vsl_clss_sub_cd");
		sheetObject.InitDataCombo(0, "sheet1_vsl_clss_sub_cd",sStr,sStr);
	}
}    

/* 개발자 작업 끝 */