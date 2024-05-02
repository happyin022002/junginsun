/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0915.js
 *@FileTitle : ESM_BKG_0915
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
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
 * @class ESM_BKG_0915 : ESM_BKG_0915 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0915() {
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
var check = true;

var state = "";

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

		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;	
			
		case "btn_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;

		case "btn_delete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;			

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;			
		case "btn_close":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
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
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
	// 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
	// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_save");
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	document.form.form1_imdg_un_no.focus()
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
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;		
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
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

	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 314;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// alert();
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(32, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|||||||||||||||||||||||||||||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cll_dg_seq");
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "vsl_cd", false,
					"", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "skd_voy_no", false,
					"", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "skd_dir_cd", false,
					"", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "port_cd",
					false, "", dfNone, 0, true, true, 11);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "bkg_no",
					false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_no", false,
					"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "imdg_un_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "imdg_clss_cd",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "dg_desc",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "emer_cntc_phn_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "imdg_pg_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "flsh_pnt_cdo_temp",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dg_rmk",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "emer_prc_no",
					false, "", dfNone, 0, true, true, 13);
			InitDataProperty(0, cnt++, dtData, 28, daRight, false, "dg_pck_grp_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 28, daRight, false, "polut_flg",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dg_lbl_cd",
					false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dg_lbl_desc",
					false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pck_qty",
					false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "tml_pck_ut_id",
					false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, false, "net_wgt",
					false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, false, "net_wgt_ut_cd",
					false, "", dfNone, 0, true, true, 1);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, false, "grs_cntr_wgt",
					false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "grs_wgt_ut_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 74, daRight, false, "meas_qty",
					false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 74, daCenter, false, "meas_ut_cd",
					false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 74, daCenter, false, "hzd_ctnt",
					false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 74, daCenter, false, "stwg_desc",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 74, daCenter, false, "cntr_lodg_no",
					false, "", dfNone, 0, true, true);


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
	// alert(sAction);
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction))
		{
			formObj.f_cmd.value = SEARCH;	
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0915GS.do", FormQueryString(formObj));
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			if ( sheetObj.RowCount == 0 )
			{
				formObj.currentSeq.value = "0";
				formObj.form1_bkg_no.value=formObj.in_bkg_no.value;
				formObj.form1_cntr_no.value=formObj.in_cntr_no.value;	
			} else {
				formObj.currentSeq.value = "1";
			}
			formObj.totalSeq.value = sheetObj.RowCount;
			
			state = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				if (sheetObj.RowCount > 0 )
				{
					check = false;
					ComBtnEnable("btn_save");
				} else {
					ComBtnDisable("btn_save");
				}
			}
			ComOpenWait(false);
		}
		break;
		
	case IBSAVE: // 조회

		formObj.f_cmd.value = MULTI;	
		sheetObj.WaitImageVisible = false;	
		ComOpenWait(true);
		
		if ( sheetObj.RowCount == 0 && check == false )
		{
			sheetObj.DataInsert(-1);
			sheetObj.CellValue(sheetObj.RowCount, "cll_dg_seq") = sheetObj.RowCount;
			sheetObj.CellValue(sheetObj.RowCount, "vsl_cd") = formObj.in_vsl_cd.value;
			sheetObj.CellValue(sheetObj.RowCount, "skd_voy_no") = formObj.in_skd_voy_no.value;
			sheetObj.CellValue(sheetObj.RowCount, "skd_dir_cd") = formObj.in_skd_dir_cd.value;
			sheetObj.CellValue(sheetObj.RowCount, "port_cd") = formObj.in_port_cd.value;
			sheetObj.CellValue(sheetObj.RowCount, "cntr_lodg_no") = formObj.in_cntr_lodg_no.value;
			sheetObj.CellValue(sheetObj.RowCount, "cll_dg_seq") = "0";
			// sheetObj.RowHidden(1) = true;
			// sheetObj.RowStatus(1) = "D";
			// alert(sheetObj.CellValue(sheetObj.RowCount, "ibflag"));
			sheetObj.CellValue(sheetObj.RowCount, "bkg_no") = formObj.in_bkg_no.value;
			sheetObj.CellValue(sheetObj.RowCount, "cntr_no") = formObj.in_cntr_no.value;
			sheetObj.DoAllSave("ESM_BKG_0915GS.do", FormQueryString(formObj));
			check = true;
			// sheetObj.RowDelete(1, false);
		} else {
			//alert();
			IBS_CopyFormToRow(formObj, sheetObj, formObj.currentSeq.value*1, "form1_");
			sheetObj.DoAllSave("ESM_BKG_0915GS.do", FormQueryString(formObj));
		}
		ComOpenWait(false);
		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		break;		
		
	case IBINSERT: // 입력
		IBS_CopyFormToRow(formObj, sheetObj, formObj.currentSeq.value*1, "form1_");
		sheetObj.DataInsert(-1);
		sheetObj.CellValue(sheetObj.RowCount, "cll_dg_seq") = sheetObj.RowCount;
		sheetObj.CellValue(sheetObj.RowCount, "vsl_cd") = formObj.in_vsl_cd.value;
		sheetObj.CellValue(sheetObj.RowCount, "skd_voy_no") = formObj.in_skd_voy_no.value;
		sheetObj.CellValue(sheetObj.RowCount, "skd_dir_cd") = formObj.in_skd_dir_cd.value;
		sheetObj.CellValue(sheetObj.RowCount, "port_cd") = formObj.in_port_cd.value;
		sheetObj.CellValue(sheetObj.RowCount, "cntr_lodg_no") = formObj.in_cntr_lodg_no.value;
		sheetObj.CellValue(sheetObj.RowCount, "bkg_no") = formObj.form1_bkg_no.value;
		sheetObj.CellValue(sheetObj.RowCount, "cntr_no") = formObj.form1_cntr_no.value;
		IBS_CopyRowToForm(sheetObj, formObj, sheetObj.RowCount, "form1_");
		formObj.currentSeq.value = sheetObj.RowCount;
		formObj.totalSeq.value = sheetObj.RowCount;		
		ComBtnEnable("btn_save");
		break;		

	case IBDELETE: // 저장

		sheetObj.RowDelete(formObj.currentSeq.value*1, false);
		if ( sheetObj.RowCount > 0 )
		{
			for ( var i=formObj.currentSeq.value*1 ; i<sheetObj.RowCount+1 ; i++ )
			{
				sheetObj.CellValue(i, "cll_dg_seq") = i;
			}
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			if ( sheetObj.RowCount == 0 )
			{		
				formObj.currentSeq.value = "0";
			} else {
				formObj.currentSeq.value = "1";
			}
			formObj.totalSeq.value = sheetObj.RowCount;	
		} else {
			formObj.currentSeq.value = "0";
			formObj.totalSeq.value = sheetObj.RowCount;	
		}
		break;
	case COMMAND01:
		
		
		if (validateForm(sheetObj, formObj, sAction))
		{			
			window.dialogArguments.setCheckBox(formObj.rowNum.value, "915", sheetObj.RowCount);
    		window.close();
		} else {
			doActionIBSheet(sheetObj, formObj, IBSAVE);
		}

	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회

		return true;
		break;
		
	case IBSAVE: // 조회

		return true;
		break;	
		
	case COMMAND01:
		//하나 이상 체크되었는지 확인
		var vIsCheck = true;
		for(var i=1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.RowStatus(i) == "I"||
				sheetObj.RowStatus(i) == "U"||
				sheetObj.RowStatus(i) == "D") {
				vIsCheck = false;
				break;
			}
		}
		if ( check == false && sheetObj.RowCount == 0 )
			vIsCheck = false;
		if (!vIsCheck) {
			//ComShowCodeMessage('BKG00265','');
			if ( confirm("Do you want to save your change(s)?") )
			{
				return false;
			}
		}		
		return true;
		break;			
	}
}

/**
* 다음 데이터 불러오기
*/
function goNext()
{
	
	var formObj = document.form;
	IBS_CopyFormToRow(formObj, sheetObjects[0], formObj.currentSeq.value*1, "form1_");
	var nextSeq = formObj.currentSeq.value*1 + 1;
	// alert(sheetObjects[0].RowCount);
	if ( nextSeq*1 <= sheetObjects[0].RowCount)
	{
		IBS_CopyRowToForm(sheetObjects[0], formObj, nextSeq, "form1_");
		formObj.currentSeq.value = nextSeq;
	}
}

/**
* 이전 데이터 불러오기
*/
function goPrev()
{
	
	var formObj = document.form;
	IBS_CopyFormToRow(formObj, sheetObjects[0], formObj.currentSeq.value*1, "form1_");
	var prevSeq = formObj.currentSeq.value*1 - 1;
	// alert(sheetObjects[0].RowCount);
	if ( prevSeq*1 >= 1)
	{
		IBS_CopyRowToForm(sheetObjects[0], formObj, prevSeq, "form1_");
		formObj.currentSeq.value = prevSeq;
	}
}




/* 개발자 작업 끝 */