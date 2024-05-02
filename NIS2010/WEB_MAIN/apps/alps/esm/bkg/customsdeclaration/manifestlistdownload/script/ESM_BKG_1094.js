/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_1094.js
 *@FileTitle : ESM_BKG-1094
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.06.03 김승민
 * 1.0 Creation
 * ----------------------------------------------------
 * History
 * 2012.06.20 김보배 [CHM-201218454] [BKG] [ROCS] 타 VVD에 기존재하는 CRN 생성 방지 Validation
 * 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
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
 * @class ESM_BKG-1094 : ESM_BKG-1094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1094() {
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

var state = "";
var resultVVD = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_close":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
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
 * @param sheet_obj IBSheet Object
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

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.vsl_call_ref_no_new.focus();

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
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

}

/**
 * 조회조건 입력할 때 처리
 */
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
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "num":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyNumber('num', '-');
		break;
	case "num2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyNumber('num', '.');
		break;
	case "num3":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyNumber('num', '');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
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
			InitColumnInfo(7, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|vsl_call_ref_no_old|vsl_call_ref_no_new|vsl_cd|skd_voy_no|skd_dir_cd|pod_clpt_ind_seq";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "vsl_call_ref_no_old");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "vsl_call_ref_no_new");
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vsl_cd");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "skd_voy_no");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "skd_dir_cd");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_clpt_ind_seq");
		}
		break;

	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSAVE: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			//alert("TEST");
			sheetObj.DataInsert(-1);
			sheetObj.CellValue(1,"vsl_call_ref_no_old") = formObj.vsl_call_ref_no_old.value;
			sheetObj.CellValue(1,"vsl_call_ref_no_new") = formObj.vsl_call_ref_no_new.value;
			sheetObj.CellValue(1,"vsl_cd")				= formObj.vvd_cd.value.substring(0,4);
			sheetObj.CellValue(1,"skd_voy_no")			= formObj.vvd_cd.value.substring(4,8);
			sheetObj.CellValue(1,"skd_dir_cd") 			= formObj.vvd_cd.value.substring(8);
			sheetObj.CellValue(1,"pod_clpt_ind_seq") 	= formObj.pod_clpt_ind_seq.value;
			
			//alert("TEST2");
			// alert(sheetObj.RowCount);
			formObj.f_cmd.value = MULTI;
			
			// 2015.04.01
			//sheetObj.DoAllSave("ESM_BKG_1094GS.do", FormQueryString(formObj));
			//state = sheetObj.EtcData("TRANS_RESULT_KEY");
			
			var sParam = ComGetSaveString(sheetObj);
			sParam += "&" + FormQueryString(formObj);
			
			var sXml = sheetObj.GetSaveXml("ESM_BKG_1094GS.do", sParam);
	 	    
			state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	 	    
	 	    resultVVD = ComGetEtcData(sXml, "err_msg");
	 	    	
			if (state == "S") {
				
				var msg_cd = resultVVD.split("&")[0];
	 	    	var msg_vvd = resultVVD.split("&")[1];
	 	    	var msg_seq = resultVVD.split("&")[2];
	 	    	
	 	    	if(msg_cd == "EXIST"){
	 	    		// turn vvd의 crn no.도 같이 update되었다는 안내 문구
	 	    		ComShowCodeMessage("BKG06162", msg_vvd, msg_seq);
	 	    		
	 	    		formObj.vsl_call_ref_no_old.value = formObj.vsl_call_ref_no_new.value;
					formObj.vsl_call_ref_no_new.value = "";
					window.dialogArguments.retrieve(formObj.vsl_call_ref_no_old.value);
					
	 	    	}else if(msg_cd == "ERROR"){
	 	    		if(msg_vvd == "BKG06165"){
	 	    			var err_vvd = msg_seq.substr(0,9);
	 	    			var err_calling = msg_seq.substr(9,1);
	 	    			ComShowCodeMessage("BKG06165", err_vvd,err_calling );
		 	    		
	 	    		}else if (msg_vvd =="BKG00889"){
	 	    			ComShowCodeMessage("BKG00889");
	 	    		}else if (msg_vvd =="BKG00608"){
	 	    			ComShowCodeMessage("BKG00608");
	 	    		}else{
	 	    			ComShowMessage(msg_cd+"--"+msg_vvd);
	 	    		}
	 	    		
	 	    	}else{
					ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
					
					formObj.vsl_call_ref_no_old.value = formObj.vsl_call_ref_no_new.value;
					formObj.vsl_call_ref_no_new.value = "";
					window.dialogArguments.retrieve(formObj.vsl_call_ref_no_old.value);
					
	 	    	}
				
			}else{
				ComShowMessage(ComResultMessage(sXml));
			}
			
			sheetObj.RemoveAll();
			
			ComOpenWait(false);
		}
		break;
		
	case COMMAND01: // 조회
		window.close();
	break;		
	}
}

/**
 * 팝업창에서 부모창 retrieve
 */
function retrieve() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE:
		if (formObj.vsl_call_ref_no_new.value == "" || formObj.vsl_call_ref_no_new.value.length != 13) {
			ComShowCodeMessage("BKG01101", "New CRN");
			formObj.vsl_call_ref_no_new.focus();
			return false;
		}

		return true;
		break;
	}
}
/* 개발자 작업 끝 */