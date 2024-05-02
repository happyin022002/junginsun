/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0282.js
 *@FileTitle : ESM_BKG-0282
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.27 임재택
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
 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_0282() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_trans":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');

	document.form.vvd_number.focus();
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
	case "sheet1": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 400;

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
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(24, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Sel.|Seq.|VVD|BKG No.|B/L No.|FA|RD|LS|B/POR|V/POL|V/POD|B/DEL|Weight|Weight|Package|Freight|RF|S.Date||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false,"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "Chk");
			InitDataProperty(0, cnt++, dtDataSeq, 35, daCenter, false, "Seq",
					false, "", dfNone, 0, false, false, -1, false, false, "",
					true, "IUD", false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false,
					"vvd_number", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false, "bkg_no",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 95, daCenter, false, "bl_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"mfsnd_code", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "term_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cnhkg_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "por_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"bv_pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"bv_pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "act_wgt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"wgt_ut_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "pck_qty",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"frt_term_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "rc_flg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false,
					"mf_snd_dt", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "vsl_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 35, daCenter, false,
					"skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false,
					"skd_dir_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 35, daCenter, false, "pol_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "pod_cd",
					false, "", dfNone, 0, false, false);
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: //조회

		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		initSheet(sheetObjects[0], 0);
		formObj.f_cmd.value = SEARCH;
		formObj.vsl_cd.value = formObj.vvd_number.value.substring(0, 4);
		formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4, 8);
		formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
		var frobs = formObj.elements("pol_flg");
		for (i = 0; i < frobs.length; i++) {
			if (frobs[i].checked) {
				if (frobs[i].value == "pol") {
					formObj.pol_cd.value = formObj.pol_code.value;
					formObj.pod_cd.value = "";
				} else {
					formObj.pod_cd.value = formObj.pol_code.value;
					formObj.pol_cd.value = "";
				}
			}
		}
		//alert(formObj.pol_flg.value);

		sheetObjects[0].RemoveAll();
		sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0282GS.do",
				FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
		}
		ComEtcDataToForm(formObj, sheetObj);
		
		sheetObj.CheckAll("Chk") = 1;
		ComOpenWait(false);

		break;
	case IBSAVE: //전송
	
	    chkSndEdi();
	
		formObj.f_cmd.value = MULTI;
		
		/*
		 * vIsCheck = 0;
		 * 
		 * for(i=1; i<=sheetObjects[0].RowCount; i++) {
		 * if(sheetObj.CellValue(i, "Chk") == 1) vIsCheck++; } if (vIsCheck ==
		 * 0) { ComShowCodeMessage('BKG00249'); return; } var count = 0;
		 */
		for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
			if (sheetObj.CellValue(i, "bv_pol_cd") == "CNHKG") {
				sheetObjects[0].CellValue2(i, "pol_cd") = formObj.pol_code.value;
			} else {
				sheetObjects[0].CellValue2(i, "pod_cd") = formObj.pol_code.value;
			}
			// 체크박스에 따라
			if (sheetObj.CellValue(i, "Chk") == "1") {
				sheetObjects[0].RowStatus(i) = "I";
			} else {
				sheetObjects[0].RowStatus(i) = "R";
			}
		}
		for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
		}
		
		if (ComShowCodeConfirm("BKG00217")) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			var sParam = "";
			var sParamSheet2 = sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
			}
			sParam += "&" + FormQueryString(formObj);

			var sXml = sheetObj.GetSaveXml("ESM_BKG_0282GS.do", sParam);
			
			// sheetObj.DoAllSave("ESM_BKG_0723GS.do",
			// FormQueryString(formObj));
			var key = ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId = setInterval(
					"doActionValidationResult(sheetObjects[0], '" + key + "');",
					3000);	
		}
		break;	
	}
}


/**
 * BackEndJob 실행결과조회.
 */
function doActionValidationResult(sheetObj, sKey) {
	sheetObjects[0].WaitImageVisble = false;
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0282GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowCodeMessage('BKG00204');
		//재조회
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		// ComShowMessage(ComResultMessage(sXml));
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회

		if (formObj.vvd_number.value == "") {
			ComShowCodeMessage('BKG00213');
			formObj.vvd_number.focus();
			return false;
		}
		if (formObj.pol_code.value == "") {
			ComShowCodeMessage('BKG00214');
			formObj.pol_code.focus();
			return false;
		}
		if (formObj.vvd_number.value.length > 0
				&& formObj.vvd_number.value.length < 9) {
			ComShowCodeMessage('BKG00213');
			formObj.vvd_number.focus();
			return false;
		}
		if (formObj.pol_code.value.length > 0
				&& formObj.pol_code.value.length < 5) {
			ComShowCodeMessage('BKG00214');
			formObj.pol_code.focus();
			return false;
		}
		return true;
		break;

	}
}
/**
 * radio버튼 클릭에 따라 조건 검색을 바꿔준다.
 * @param formObj
 * @return
 */
function OnClickRadioButton(formObj) {
	var frobs = formObj.elements("pol_flg");
	for (i = 0; i < frobs.length; i++) {
		if (frobs[i].checked) {
			if (frobs[i].value == "pol") {
				formObj.pol_cd.value = formObj.pol_code.value;
				alert(formObj.pol_cd.value);
			} else {
				formObj.pod_cd.value = formObj.pol_code.value;
			}

		}
	}
}
/**
 * HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
 **/
function obj_KeyUp() {

	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * 엔터 입력시 조회 
 * @return
 */
function obj_ComKeyEnter() {

	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");

	if (srcName != "") {
		ComKeyEnter();
	}
}
 
 function chkSndEdi(){
	 var formObj = document.form;
	 var cnt = sheetObjects[0].RowCount;
	 var sheetObj = sheetObjects[0];
	 for (var ix = 1; ix <= cnt; ix++ ){
		 var mf_snd_dt = sheetObj.CellValue(ix,"mf_snd_dt");
		
    		 if(ComIsNull(mf_snd_dt) != true){
    			 
    			 sheetObj.cellValue(ix,"Chk" )=1  	;		 	 
    			 
		 }
	 }
	// return true;
 }