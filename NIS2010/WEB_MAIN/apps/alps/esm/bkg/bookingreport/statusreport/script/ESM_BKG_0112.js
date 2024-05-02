/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0112.js
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.03
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.08.03 강동윤
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
 * @class ESM_BKG_0112_01 : ESM_BKG_0111_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0112_01() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/ 

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var seqSheet1 = 0;
var seqSheet2 = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

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

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	
	document.form.vvd.focus();
	initControl();
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd)) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
     var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     
     //alert("keyValue : " + keyValue);
	 
	 
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if ( keyValue != 9 && keyValue !=16 && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
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
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드 입력할때

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key 처리
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "int":
		//숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		//숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
            
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(44, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Seq|B/L No.|Booking No.|Customs Type\nException|AES|In-Bond\nNumber|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|No. of PKG/CNTR|M&D|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|DG|Auto|Via S/I|Via S/I|Q'ty|Q'ty|Container|Container";
			var HeadTitle2 = "Seq|B/L No.|Booking No.|Customs Type\nException|AES|In-Bond\nNumber|NM|AD|CT|CN|ZIP|NM|AD|CT|ST|CN|ZIP|NM|AD|CT|ST|CN|ZIP|No. of PKG/CNTR|M&D|Package|Package|Package|Weight|Weight|Measure|Measure|DG|Auto|Receiving|Via|BKG|CNTR|Container|S";			

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]	
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 84, daCenter, true, "entr_clss_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "aes_inlnd_trns_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "entr_clss_rmk", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "s_cust_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "s_cust_addr_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_cty_nm_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cstms_decl_cnt_cd_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_zip_id_s", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cust_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_addr_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_cty_nm_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_ste_cd_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cstms_decl_cnt_cd_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_zip_id_c", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "n_cust_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_addr_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_cty_nm_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_ste_cd_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cstms_decl_cnt_cd_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_zip_id_n", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "pck_cmdt_desc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "md", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "pck_qty_da", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pck_tp_cd", false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "pck_qty_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "act_wgt", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "act_wet_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "meas_qty_da", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "meas_qty_chk", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "dcgo_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 46, daCenter, true, "veh_cmdt_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "si_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 32, daCenter, true, "xter_si_cd", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 47, daCenter, false, "bkg_qty", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 47, daCenter, false, "cntr_qty", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_seal_seq", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "good_idx");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "error_idx");

			CountPosition = 0;
			DataAutoTrim = false;//공백을 트림하지 않겠다는 것으로 데이타 값이 없을 경우 즉 NULL일 경우 merge를 하지 않는다.
		}
		break;

	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_New":
			ComResetAll();

			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.vvd,"");
			ComClearManyObjects(document.form.pol_cd,"");
			ComClearManyObjects(document.form.pod_cd,"");
			
			break;

		case "btn_SaveExcel":
			sheetObject1.SpeedDown2Excel(-1);
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		sheetObj.FocusAfterProcess = false;
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0112GS.do", FormQueryString(formObj));

		sheetObj.SelectCell(0, 0, false);

		ComOpenWait(false);
		break;

	case COMMAND01: //CODE 조회						
		formObj.f_cmd.value = SEARCH01;
		var searchXml = sheetObj.GetSearchXml("ESM_BKG_0112GS.do", FormQueryString(formObj));

		var sXml = searchXml.split("|$$|");

		// US Customs Type nException
		ComBkgXml2ComboItem(sXml[0], formObj.entr_clss_tp_gubun, "val", "name");

		//formObj.entr_clss_tp_gubun.InsertItem(0,"","");
		//formObj.entr_clss_tp_gubun.InsertItem(0,"G","G");		
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	if (formObj.vvd.value == '' || formObj.vvd.value.length != 9) {

		ComShowCodeMessage("BKG00007");// VVD is not available !
		formObj.vvd.focus();
		return false;
	} else {

		formObj.vsl_cd.value = formObj.vvd.value.substring(0, 4);
		formObj.skd_voy_no.value = formObj.vvd.value.substring(4, 8);
		formObj.skd_dir_cd.value = formObj.vvd.value.substring(8);
	}

	if (formObj.pol_cd.value == '' && formObj.pod_cd.value == '') {

		ComShowCodeMessage("BKG00137");// POL/POD is not available
		formObj.pol_cd.focus();
		return false;
	}

	if (formObj.pol_nod_cd.value != '') {

		formObj.pol_yd_cd.value = formObj.pol_cd.value + formObj.pol_nod_cd.value;
	} else {

		formObj.pol_yd_cd.value = "";
	}

	if (formObj.pod_nod_cd.value != '') {

		formObj.pod_yd_cd.value = formObj.pod_cd.value + formObj.pod_nod_cd.value;
	} else {

		formObj.pod_yd_cd.value = "";
	}

	return true;
}



// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet1_OnSearchEnd(sheetObj)// 변수명 임의 생성
{
	with (sheetObj) {
		var redColor = RgbColor(255, 0, 0);
		var blueColor = RgbColor(0, 0, 255);

		for ( var i = 2; i <= LastRow; i++) {

			CellFontColor(i, "bkg_no") = blueColor;
			CellFontUnderline(i, "bkg_no") = true;
			CellFontColor(i, "bl_no") = blueColor;
			CellFontUnderline(i, "bl_no") = true;

			if ( CellValue(i, "bkg_qty") != CellValue(i, "cntr_qty") ) { 
				CellFontColor(i, "bkg_qty") = redColor;
				CellFontColor(i, "cntr_qty") = redColor;
			}
			
			if ("E" == CellValue(i, "pck_qty_chk")) {
				CellFontColor(i, "pck_qty_chk") = redColor;
			}

			if ("E" == CellValue(i, "act_wet_chk")) {
				CellFontColor(i, "act_wet_chk") = redColor;
			}

			if ("E" == CellValue(i, "meas_qty_chk")) {
				CellFontColor(i, "meas_qty_chk") = redColor;
			}
			if ("N" == CellValue(i, "cntr_mf_no")) {
				CellFontColor(i, "cntr_mf_no") = redColor;
			}
			if ("E" == CellValue(i, "cntr_seal_seq")) {
				CellFontColor(i, "cntr_seal_seq") = redColor;
			}

			if ("E" == CellValue(i, "cust_nm_s")) {
				CellFontColor(i, "cust_nm_s") = redColor;
			}

			if ("E" == CellValue(i, "cust_addr_s")) {
				CellFontColor(i, "cust_addr_s") = redColor;
			}

			if ("E" == CellValue(i, "cust_cty_nm_s")) {
				CellFontColor(i, "cust_cty_nm_s") = redColor;
			}

			if ("E" == CellValue(i, "cstms_decl_cnt_cd_s")) {
				CellFontColor(i, "cstms_decl_cnt_cd_s") = redColor;
			}

			if ("E" == CellValue(i, "cust_zip_id_s")) {
				CellFontColor(i, "cust_zip_id_s") = redColor;
			}

			if ("E" == CellValue(i, "cust_nm_c")) {
				CellFontColor(i, "cust_nm_c") = redColor;
			}

			if ("E" == CellValue(i, "cust_addr_c")) {
				CellFontColor(i, "cust_addr_c") = redColor;
			}

			if ("E" == CellValue(i, "cust_cty_nm_c")) {
				CellFontColor(i, "cust_cty_nm_c") = redColor;
			}

			if ("E" == CellValue(i, "cust_ste_cd_c")) {
				CellFontColor(i, "cust_ste_cd_c") = redColor;
			}

			if ("E" == CellValue(i, "cstms_decl_cnt_cd_c")) {
				CellFontColor(i, "cstms_decl_cnt_cd_c") = redColor;
			}

			if ("E" == CellValue(i, "cust_zip_id_c")) {
				CellFontColor(i, "cust_zip_id_c") = redColor;
			}

			if ("E" == CellValue(i, "cust_nm_n")) {
				CellFontColor(i, "cust_nm_n") = redColor;
			}

			if ("E" == CellValue(i, "cust_addr_n")) {
				CellFontColor(i, "cust_addr_n") = redColor;
			}

			if ("E" == CellValue(i, "cust_cty_nm_n")) {
				CellFontColor(i, "cust_cty_nm_n") = redColor;
			}

			if ("E" == CellValue(i, "cust_ste_cd_n")) {
				CellFontColor(i, "cust_ste_cd_n") = redColor;
			}

			if ("E" == CellValue(i, "cstms_decl_cnt_cd_n")) {
				CellFontColor(i, "cstms_decl_cnt_cd_n") = redColor;
			}

			if ("E" == CellValue(i, "cust_zip_id_n")) {
				CellFontColor(i, "cust_zip_id_n") = redColor;
			}

			if ("E" == CellValue(i, "pck_qty_chk")) {
				CellFontColor(i, "pck_qty_chk") = redColor;
			}

			if ("E" == CellValue(i, "act_wet_chk")) {
				CellFontColor(i, "act_wet_chk") = redColor;
			}

			if ("E" == CellValue(i, "meas_qty_chk")) {
				CellFontColor(i, "meas_qty_chk") = redColor;
			}
		}

		document.form.master_tot.value = "Total : " + CellValue(LastRow, "Seq") + " (Good : " + CellValue(LastRow, "good_idx")
				+ " , Error : " + CellValue(LastRow, "error_idx") + ")";
		document.getElementById('tab_tot').innerHTML = document.form.master_tot.value;

	}
}

/*
 *  Search Option or Item Option Modify
 * */
function sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {

	if (colIdx == sheetObj.SaveNameCol("bkg_no")) {
		comBkgCallBkgDetail(sheetObj.CellValue(rowIdx, "bkg_no"));

	} else if (colIdx == sheetObj.SaveNameCol("bl_no")) {
		var param = "?bkg_no=" + sheetObj.CellValue(rowIdx, "bkg_no");
		ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do" + param, "BL Preview", 1024, 740, true, "scrollbars=yes,resizable=yes");
	}
}

/* 개발자 작업 끝 */