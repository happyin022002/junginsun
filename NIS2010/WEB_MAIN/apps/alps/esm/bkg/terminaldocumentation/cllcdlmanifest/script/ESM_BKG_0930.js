/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0930.js
 *@FileTitle : ESM_BKG_0930
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.11
 *@LastModifier : 계기훈
 *@LastVersion : 1.1
 * 2009.07.10 김승민
 * 1.0 Creation
 * 2012.01.26 박성호[CHM-201215846] BKG CLL 수신 ID 추가 건 ( KRINCYG, KRKIMYG)
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
 * @class ESM_BKG_0930 : ESM_BKG_0930 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0930(){
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName){
		case "btn_EDISend":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;

		case "btn_finalEDISend":
			// Final EDI Send 일땐 Flag를 'Y'로 저장.
			formObject.in_final_edi_flg.value = "Y";
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
			
		case "btn_CopyTsPodMlbDel":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;

		case "btn_RowAdd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;

		case "btn_Delete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_New":
			document.form.reset();
			sheetObject.RemoveAll();
			formObject.in_vvd_cd.focus();
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;

		case "btn_DownExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;

		case "btn_PrintPreview":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
			break;

		case "btn_Summary":
			doActionIBSheet(sheetObject, formObject, COMMAND04);
			break;

		case "btn_Special_CGO":
			doActionIBSheet(sheetObject, formObject, COMMAND05);
			break;

		}// end switch
	}catch(e){
		if(e == "[object Error]"){
			ComShowMessage(OBJECT_ERROR);
		}else{
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(){
	for(i = 0; i < sheetObjects.length; i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// for(i = 0; i < sheetObjects.length; i++){
	// doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	// }
	
	document.form.in_vvd_cd.focus();
	initControl();
	doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 *{@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param{ibsheet}
 *            sheetObj IBSheet Object
 * @param{int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl(){
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
	ComBtnDisable("btn_CopyTsPodMlbDel");
	ComBtnDisable("btn_PrintPreview");
	ComBtnDisable("btn_Summary");
	ComBtnDisable("btn_Special_CGO");
	ComBtnDisable("btn_EDISend");
	ComBtnDisable("btn_finalEDISend");
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp(){
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if(ComChkLen(srcValue, srcMaxLength) == "2"){
		ComSetNextFocus();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
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
function initSheet(sheetObj, sheetNo){

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch(sheetId){

	case "sheet1":
		with(sheetObj){

			// 높이 설정
			style.height = 282;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if(location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 14, 100);

			var HeadTitle1 = "|Seq.|Sel.|Container No.|TP|F/M|Seal No.|Weight|Weight|VGM|VGM|VGM Signature|VGM Method|R/D|TS|Special Cargo|Special Cargo|Stow|BS|MP|SG|LQ|POD|POD|MLB|A.POD|T/S VVD|BKG No.|B/L No.|VVD|VVD|VVD|POL|POL|Ov L|Ov W|Ov H|Min T|Max T|PC|UN No|IMDG|Temp|Vent|HTS Code|HS Code|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 14, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false,
					"del_chk");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cntr_no",
					true, "", dfNone, 0, true, true, 11);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"cntr_tpsz_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"mty_bkg_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "seal_no",
					false, "", dfNone, 0, true, true, 15);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "bl_wgt",
					false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"wgt_ut_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vgm_wgt", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daRight, false, "vgm_wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vgm_vrfy_sig_ctnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vgm_mzd_tp_cd", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"rcv_term_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ts_flg",
					false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 180, daCenter, false,
					"cll_rmk1", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cll_rmk2",
					false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "stwg_cd",
					false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bc_cd",
					false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"mrn_polut_flg", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sg",
					false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "lq",
					false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod_cd",
					false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"pod_yd_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"blck_stwg_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "a_pod_cd",
					false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,
					"ts_vvd_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_no",
					false, "", dfNone, 0, true, true, 11);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bl_no",
					false, "", dfNone, 0, true, true, 13);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",
					false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"skd_voy_no", false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"skd_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol_cd",
					false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"pol_yd_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"ovr_len_qty", false, "", dfNone, 0, true, true, 12);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"ovr_wgt_qty", false, "", dfNone, 0, true, true, 12);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"ovr_hgt_qty", false, "", dfNone, 0, true, true, 12);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "min_temp",
					false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "max_temp",
					false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"kr_tml_prct_id", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"imdg_un_no", false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"imdg_clss_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cdo_temp",
					false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"cntr_vent_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,
					"hamo_trf_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"cmdt_hs_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false,
					"bkg_pol_cd", false, "", dfNone, 0, true, true, 5);
			// InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
			// "xter_rmk",
			// false, "", dfNone, 0, true, true, 4000);
			InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "mty_bkg_cd", vtEngUpOther);
//			InitDataValid(0, "seal_no", vtEngUpOther, "0123456789");
			InitDataValid(0,  "seal_no",   	vtEngOther, "1234567890~!@#$%^&*()--_+={}[]|\:;<.>/?");
			// InitDataValid(0, "bl_wgt", vtNumericOnly);
			InitDataValid(0, "rcv_term_cd", vtEngUpOnly);
			InitDataValid(0, "ts_flg", vtEngUpOnly);
			InitDataValid(0, "cll_rmk1", vtEngUpOther, "0123456789-.,/: ");
			InitDataValid(0, "cll_rmk2", vtEngUpOther, "0123456789-.,/: ");
			InitDataValid(0, "mrn_polut_flg", vtEngUpOnly);
			InitDataValid(0, "pod_cd", vtEngUpOnly);
			InitDataValid(0, "pod_yd_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "blck_stwg_cd", vtEngUpOnly);
			InitDataValid(0, "a_pod_cd", vtEngUpOnly);
			InitDataValid(0, "ts_vvd_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "bkg_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "bl_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "vsl_cd", vtEngUpOnly);
			InitDataValid(0, "skd_voy_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "skd_dir_cd", vtEngUpOnly);
			InitDataValid(0, "sg", vtEngUpOther, "0123456789");
			InitDataValid(0, "lq", vtNumericOther, ".");
			InitDataValid(0, "pol_cd", vtEngUpOnly);
			InitDataValid(0, "pol_yd_cd", vtEngUpOnly);
			InitDataValid(0, "ovr_len_qty", vtNumericOther, ".");
			InitDataValid(0, "ovr_wgt_qty", vtNumericOther, ".");
			InitDataValid(0, "ovr_hgt_qty", vtNumericOther, ".");
			InitDataValid(0, "min_temp", vtNumericOther, ".");
			InitDataValid(0, "max_temp", vtNumericOther, ".");
			InitDataValid(0, "kr_tml_prct_id", vtEngUpOnly);
			InitDataValid(0, "imdg_un_no", vtNumericOnly);
			InitDataValid(0, "imdg_clss_cd", vtNumericOther, ".");
			InitDataValid(0, "cdo_temp", vtNumericOther, ".");
			InitDataValid(0, "cntr_vent_cd", vtEngUpOnly);
			InitDataValid(0, "stwg_cd", vtEngUpOnly);
			CountPosition = 0;
		}
		break;
		
	case "sheet2":
		with(sheetObj){
			// 높이 설정
			style.height = 282;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if(location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 14, 100);

			var HeadTitle1 = "|val";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 11, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,	"ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "val",	false, "", dfNone, 0, false, false);
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
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col){
	sheetObj.ShowDebugMsg = false;
	switch(sAction){
	case SEARCH01: // STWG Code valid check
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0930GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		break;
	case IBSEARCH: // 조회
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.WaitImageVisible = false;	
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		if(formObj.in_cll_type_tmp(0).checked)
			formObj.in_cll_type.value = "CLL";
		else if(formObj.in_cll_type_tmp(1).checked)
			formObj.in_cll_type.value = "LOCAL";
		else if(formObj.in_cll_type_tmp(2).checked)
			formObj.in_cll_type.value = "TS";
		else if(formObj.in_cll_type_tmp(3).checked)
			formObj.in_cll_type.value = "EMPTY";

		if(formObj.in_bkg_sts_cd_tmp(0).checked)
			formObj.in_bkg_sts_cd.value = "";
		else if(formObj.in_bkg_sts_cd_tmp(1).checked)
			formObj.in_bkg_sts_cd.value = "F";
		else if(formObj.in_bkg_sts_cd_tmp(2).checked)
			formObj.in_bkg_sts_cd.value = "W";

		if(formObj.in_cntr_cfm_flg_tmp(0).checked)
			formObj.in_cntr_cfm_flg.value = "";
		else if(formObj.in_cntr_cfm_flg_tmp(1).checked)
			formObj.in_cntr_cfm_flg.value = "Y";
		else if(formObj.in_cntr_cfm_flg_tmp(2).checked)
			formObj.in_cntr_cfm_flg.value = "N";
		
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0930GS.do", FormQueryString(formObj));
		
		sheetObj.LoadSearchXml("<?xml version='1.0' ?>"+ComReplaceStr(sXml));
		
		ComEtcDataToForm(formObj, sheetObj);

		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if(state == "S"){
			var d2 = 0;
			var d4 = 0;
			var d5 = 0;
			var d7 = 0;
			var d8 = 0;
			var d9 = 0;
			var dw = 0;
			var dx = 0;
			var r2 = 0;
			var r4 = 0;
			var r5 = 0;
			var f2 = 0;
			var f4 = 0;
			var f5 = 0;
			var o2 = 0;
			var o4 = 0;
			var o5 = 0;
			var o7 = 0;
			var s2 = 0;
			var s4 = 0;
			var t2 = 0;
			var t4 = 0;
			var a2 = 0;
			var a4 = 0;
			var a5 = 0;
			var p2 = 0;
			var p4 = 0;
			var z2 = 0;
			var z4 = 0;
			var d3 = 0;
			var r9 = 0;
			var etc = 0;
			var totalTpSize = 0;
			var local = 0;
			var localFull = 0;
			var localEmpty = 0;
			var ts = 0;
			var tsFull = 0;
			var tsEmpty = 0;
			var wgt = 0;
			for( var i = 1; i <= sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "seq") == ""){
					sheetObj.RowEditable(i) = false;
				}
				if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D2"){
					d2 = d2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D4"){
					d4 = d4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D5"){
					d5 = d5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D7"){
					d7 = d7 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D8"){
					d8 = d8 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D9"){
					d9 = d9 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "DW"){
					dw = dw + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "DX"){
					dx = dx + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "R2"){
					r2 = r2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "R4"){
					r4 = r4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "R5"){
					r5 = r5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "F2"){
					f2 = f2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "F4"){
					f4 = f4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "F5"){
					f5 = f5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "O2"){
					o2 = o2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "O4"){
					o4 = o4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "O5"){
					o5 = o5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "O7"){
					o7 = o7 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "S2"){
					s2 = s2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "S4"){
					s4 = s4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "T2"){
					t2 = t2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "T4"){
					t4 = t4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "A2"){
					a2 = a2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "A4"){
					a4 = a4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "A5"){
					a5 = a5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "P2"){
					p2 = p2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "P4"){
					p4 = p4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "Z2"){
					z2 = z2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "Z4"){
					z4 = z4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D3"){
					d3 = d3 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "R9"){
					r9 = r9 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else{ 
					if(sheetObj.CellValue(i, "cntr_tpsz_cd") != ""){
						etc = etc + 1;
						totalTpSize = totalTpSize + 1;
						wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
					}
				
				}
				
				if(formObj.in_cll_type.value == "TS"){
					if(sheetObj.CellValue(i, "seq") != ""){
						ts = ts + 1;
						if(sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
					}
				}else{
					if(sheetObj.CellValue(i, "ts_flg") == "TS"
							|| sheetObj.CellValue(i, "ts_flg") == "TT"){
						ts = ts + 1;
						if(sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
					}
					if(sheetObj.CellValue(i, "ts_flg") == ""
							&& sheetObj.CellValue(i, "seq") != ""){
						local = local + 1;
						if(sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							localFull = localFull + 1;
						else
							localEmpty = localEmpty + 1;
					}
				}
			}
			formObj.d2.value = d2;
			formObj.d4.value = d4;
			formObj.d5.value = d5;
			formObj.d7.value = d7;
			formObj.d8.value = d8;
			formObj.d9.value = d9;
			formObj.dw.value = dw;
			formObj.dx.value = dx;
			formObj.r2.value = r2;
			formObj.r4.value = r4;
			formObj.r5.value = r5;
			formObj.f2.value = f2;
			formObj.f4.value = f4;
			formObj.f5.value = f5;
			formObj.o2.value = o2;
			formObj.o4.value = o4;
			formObj.o5.value = o5;
			formObj.o7.value = o7;
			formObj.s2.value = s2;
			formObj.s4.value = s4;
			formObj.t2.value = t2;
			formObj.t4.value = t4;
			formObj.a2.value = a2;
			formObj.a4.value = a4;
			formObj.a5.value = a5;
			formObj.p2.value = p2;
			formObj.p4.value = p4;
			formObj.z2.value = z2;
			formObj.z4.value = z4;
			formObj.d3.value = d3;
			formObj.r9.value = r9;
			formObj.etc.value = etc;
			formObj.totalTpSize.value = totalTpSize;
			formObj.local.value = local;
			formObj.localFull.value = localFull;
			formObj.localEmpty.value = localEmpty;
			formObj.ts.value = ts;
			formObj.tsFull.value = tsFull;
			formObj.tsEmpty.value = tsEmpty;
			formObj.wgt.value = wgt;

			var rowCnt = sheetObj.RowCount;

			if(rowCnt == 0){
				ComBtnDisable("btn_CopyTsPodMlbDel");
				ComBtnDisable("btn_PrintPreview");
				ComBtnDisable("btn_Summary");
				ComBtnDisable("btn_Special_CGO");
				ComBtnDisable("btn_EDISend");
				ComBtnDisable("btn_finalEDISend");
			}else{
				
				ComBtnEnable("btn_CopyTsPodMlbDel");
				if(formObj.in_cll_type_tmp(0).checked){
					ComBtnEnable("btn_PrintPreview");
					ComBtnEnable("btn_Summary");
					ComBtnEnable("btn_Special_CGO");
					ComBtnEnable("btn_EDISend");
					ComBtnEnable("btn_finalEDISend");
				}else{
					ComBtnDisable("btn_PrintPreview");
					ComBtnDisable("btn_Summary");
					ComBtnDisable("btn_Special_CGO");
					ComBtnDisable("btn_EDISend");
					ComBtnDisable("btn_finalEDISend");
				}
			}
			sheetObj.CheckAll("del_chk") = 1;

			formObj.wgt.value = ComGetMaskedValue(formObj.wgt.value, 'int');
		}
		ComOpenWait(false);
		break;

	case IBSAVE: // 저장
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.WaitImageVisible = false;	
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		if(formObj.in_cll_type_tmp(0).checked)
			formObj.in_cll_type.value = "CLL";
		else if(formObj.in_cll_type_tmp(1).checked)
			formObj.in_cll_type.value = "LOCAL";
		else if(formObj.in_cll_type_tmp(2).checked)
			formObj.in_cll_type.value = "TS";
		else if(formObj.in_cll_type_tmp(3).checked)
			formObj.in_cll_type.value = "EMPTY";
		// alert(sheetObj.GetSaveString(true));
		// alert(sheetObj.CellValue(1, "cntr_no"));
		// alert(sheetObj.CellValue(sheetObj.RowCount, "cntr_no"));
		for( var i = 1; i < sheetObj.RowCount + 1; i++){
			if(sheetObj.CellValue(i, "cntr_tpsz_cd") != "" && sheetObj.CellValue(i, "ibflag") != "D"){
				sheetObj.CellValue(i, "ibflag") = "U";
			}
		}
		sheetObj.DoSave("ESM_BKG_0930GS.do", FormQueryString(formObj));
		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if(state == "S"){
			document.form.in_cll_type_tmp(0).checked = true;
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		ComOpenWait(false);
		break;

	case IBDELETE: // 입력
		// alert("test1");
		if(!validateForm(sheetObj, formObj, sAction))
			return;

		for( var i = sheetObj.RowCount; i >= 1; i--){
			if(sheetObj.CellValue(i, "del_chk") == 1){
				//alert(i);
				sheetObj.RowHidden(i) = true;
				sheetObj.RowStatus(i) = "D";
			}
		}

		var vIsCheck = false;
		// alert(sheetObj.RowCount);
		for( var i = 1; i <= sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "del_chk") == 0
					&& sheetObj.CellValue(i, "cntr_tpsz_cd") != ""){
				vIsCheck = true;
				break;
			}
		}

		//alert(vIsCheck);
		if(!vIsCheck){
			for( var i = sheetObj.RowCount; i >= 1; i--){
				sheetObj.RowHidden(i) = true;
				if(sheetObj.CellValue(i, "cntr_tpsz_cd") != "")
					sheetObj.RowStatus(i) = "D";
			}
		}

		/*var delrows = sheetObj.FindCheckedRow("del_chk");
		 alert(delrows);
		var arrRow = delrows.split("|");
		 alert(arrRow);
		for( var i = 0; i < arrRow.length - 1; i++){
			sheetObj.RowHidden(arrRow[i]) = true;
			sheetObj.RowStatus(arrRow[i]) = "D";
		}*/
		// }
		// alert("test4");
		break;

	case COMMAND01: // 입력
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.WaitImageVisible = false;	
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI01;
		sheetObj.DoAllSave("ESM_BKG_0930GS.do", FormQueryString(formObj));
		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if(state == "S"){
			document.form.in_cll_type_tmp(0).checked = true;
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}else{
			document.form.in_cll_type_tmp(0).checked = true;
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		ComOpenWait(false);
		break;

	case COMMAND02: // 입력
		if(formObj.in_cll_type_tmp(0).checked)
			formObj.in_cll_type.value = "CLL";
		else if(formObj.in_cll_type_tmp(1).checked)
			formObj.in_cll_type.value = "LOCAL";
		else if(formObj.in_cll_type_tmp(2).checked)
			formObj.in_cll_type.value = "TS";
		else if(formObj.in_cll_type_tmp(3).checked)
			formObj.in_cll_type.value = "EMPTY";
		var sUrl = "/hanjin/ESM_BKG_1014.do?pgmNo=ESM_BKG_1014&inCllType="
				+ formObj.in_cll_type.value;
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
		ComOpenWindowCenter(sUrl, "ESM_BKG_1014", 322, 204, false);

		break;

	case COMMAND03: // 입력
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		// if(formObj.in_cll_type_tmp(0).checked)
		formObj.in_cll_type.value = "CLL";
		// else if(formObj.in_cll_type_tmp(1).checked)
		// formObj.in_cll_type.value = "LOCAL";
		// else if(formObj.in_cll_type_tmp(2).checked)
		// formObj.in_cll_type.value = "TS";
		// else if(formObj.in_cll_type_tmp(3).checked)
		// formObj.in_cll_type.value = "EMPTY";

		if(formObj.in_bkg_sts_cd_tmp(0).checked)
			formObj.in_bkg_sts_cd.value = "";
		else if(formObj.in_bkg_sts_cd_tmp(1).checked)
			formObj.in_bkg_sts_cd.value = "F";
		else if(formObj.in_bkg_sts_cd_tmp(2).checked)
			formObj.in_bkg_sts_cd.value = "W";

		if(formObj.in_cntr_cfm_flg_tmp(0).checked)
			formObj.in_cntr_cfm_flg.value = "";
		else if(formObj.in_cntr_cfm_flg_tmp(1).checked)
			formObj.in_cntr_cfm_flg.value = "Y";
		else if(formObj.in_cntr_cfm_flg_tmp(2).checked)
			formObj.in_cntr_cfm_flg.value = "N";

		var sUrl = "/hanjin/ESM_BKG_0931.do?pgmNo=ESM_BKG_0931&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		// alert(sUrl);
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		ComOpenWindow(sUrl, "ESM_BKG_0931",
				"width=1024,height=600,scrollbars=yes", false);
		// location.href=sUrl;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0931", 1024, 600, false);

		break;

	case COMMAND04: // 입력
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		// if(formObj.in_cll_type_tmp(0).checked)
		formObj.in_cll_type.value = "CLL";
		// else if(formObj.in_cll_type_tmp(1).checked)
		// formObj.in_cll_type.value = "LOCAL";
		// else if(formObj.in_cll_type_tmp(2).checked)
		// formObj.in_cll_type.value = "TS";
		// else if(formObj.in_cll_type_tmp(3).checked)
		// formObj.in_cll_type.value = "EMPTY";

		if(formObj.in_bkg_sts_cd_tmp(0).checked)
			formObj.in_bkg_sts_cd.value = "";
		else if(formObj.in_bkg_sts_cd_tmp(1).checked)
			formObj.in_bkg_sts_cd.value = "F";
		else if(formObj.in_bkg_sts_cd_tmp(2).checked)
			formObj.in_bkg_sts_cd.value = "W";

		if(formObj.in_cntr_cfm_flg_tmp(0).checked)
			formObj.in_cntr_cfm_flg.value = "";
		else if(formObj.in_cntr_cfm_flg_tmp(1).checked)
			formObj.in_cntr_cfm_flg.value = "Y";
		else if(formObj.in_cntr_cfm_flg_tmp(2).checked)
			formObj.in_cntr_cfm_flg.value = "N";

		var sUrl = "/hanjin/ESM_BKG_0932.do?pgmNo=ESM_BKG_0932&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		// alert(sUrl);
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		ComOpenWindow(sUrl, "ESM_BKG_0932",
				"width=1024,height=600,scrollbars=yes,resizable=yes", false);
		// location.href=sUrl;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0931", 1024, 600, false);

		break;

	case COMMAND05: // 입력
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		// if(formObj.in_cll_type_tmp(0).checked)
		formObj.in_cll_type.value = "CLL";
		// else if(formObj.in_cll_type_tmp(1).checked)
		// formObj.in_cll_type.value = "LOCAL";
		// else if(formObj.in_cll_type_tmp(2).checked)
		// formObj.in_cll_type.value = "TS";
		// else if(formObj.in_cll_type_tmp(3).checked)
		// formObj.in_cll_type.value = "EMPTY";

		if(formObj.in_bkg_sts_cd_tmp(0).checked)
			formObj.in_bkg_sts_cd.value = "";
		else if(formObj.in_bkg_sts_cd_tmp(1).checked)
			formObj.in_bkg_sts_cd.value = "F";
		else if(formObj.in_bkg_sts_cd_tmp(2).checked)
			formObj.in_bkg_sts_cd.value = "W";

		if(formObj.in_cntr_cfm_flg_tmp(0).checked)
			formObj.in_cntr_cfm_flg.value = "";
		else if(formObj.in_cntr_cfm_flg_tmp(1).checked)
			formObj.in_cntr_cfm_flg.value = "Y";
		else if(formObj.in_cntr_cfm_flg_tmp(2).checked)
			formObj.in_cntr_cfm_flg.value = "N";

		var sUrl = "/hanjin/ESM_BKG_0933.do?pgmNo=ESM_BKG_0933&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		// alert(sUrl);
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		ComOpenWindow(sUrl, "ESM_BKG_0933",
				"width=1024,height=600,scrollbars=yes", false);
		// location.href=sUrl;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0931", 1024, 600, false);

		break;

	case IBINSERT: // 입력
		sheetObj.DataInsert(-1);
		break;
	case IBDOWNEXCEL:
		var noRows = "";
		if(validateForm(sheetObj, formObj, sAction)){
			for( var i = 1; i <= sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "cntr_tpsz_cd") == ""
						|| sheetObj.CellValue(i, "del_chk") == 0){
					noRows = noRows + i + "|";
				}
			}

			//alert(noRows.length);
			// alert(noRows.length-1);
			// alert(noRows.length-2);
			// var noRows2 = "";
			if(noRows.length > 0)
				noRows = noRows.substring(0, noRows.length - 1);
			// alert(noRows);
			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false,
					"", false, "del_chk|del_chk", noRows);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction){
	case IBSEARCH: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if(formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9){
			ComShowCodeMessage('BKG00710');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if(formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5){
			ComShowCodeMessage('BKG00711');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	case IBSAVE: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if(formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9){
			ComShowCodeMessage('BKG00710');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if(formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5){
			ComShowCodeMessage('BKG00711');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND01: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if(formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9){
			ComShowCodeMessage('BKG00710');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if(formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5){
			ComShowCodeMessage('BKG00711');
			formObj.in_pol_cd.focus();
			return false;
		}

		if(formObj.in_ktml_cd.value == ""){
			ComShowCodeMessage('BKG00763');
			formObj.in_ktml_cd.focus();
			return false;
		}

		if(formObj.in_rcv_id.value == ""){
			//ComShowCodeMessage('BKG00763');
			ComShowCodeMessage('BKG00625');
			formObj.in_rcv_id.focus();
			return false;
		}
		return true;
		break;
	case IBDELETE: // 조회
		var vIsCheck = false;
		// alert(sheetObj.RowCount);
		if(!ComShowCodeConfirm("COM12188")){
			//alert();
			return false;
		}
		for( var i = 1; i <= sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "del_chk") == 1){
				vIsCheck = true;
				break;
			}
		}
		if(!vIsCheck){
			ComShowCodeMessage('BKG00249', '');
			return false;
		}

		return true;
		break;

	case IBDOWNEXCEL: // 조회
		var vIsCheck = false;
		// alert(sheetObj.RowCount);
		for( var i = 1; i <= sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "del_chk") == 1){
				vIsCheck = true;
				break;
			}
		}
		if(!vIsCheck){
			ComShowCodeMessage('BKG00249', '');
			return false;
		}

		return true;
		break;

	case COMMAND03: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if(formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9){
			ComShowCodeMessage('BKG00710');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if(formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5){
			ComShowCodeMessage('BKG00711');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND04: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if(formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9){
			ComShowCodeMessage('BKG00710');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if(formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5){
			ComShowCodeMessage('BKG00711');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND05: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if(formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9){
			ComShowCodeMessage('BKG00710');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if(formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5){
			ComShowCodeMessage('BKG00711');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	}
}

/**
 * 팝업화면에서 부모창 조회처리
 */
function goSearch(){
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 팝업화면에서 부모창의 Sheet의 start_index에서 end_index까의 값을 변경
 * @param start_index start_index
 * @param end_index end_index
 * @param ts ts
 * @param pod pod
 * @param mlb mlb
 * @param yd yd
 */
function setData(start_index, end_index, ts, pod, mlb, yd){
	//alert(start_index+":"+end_index+":"+ts+":"+pod+":"+mlb+":"+del);
	for( var i = 1; i <= sheetObjects[0].RowCount; i++){
		if(sheetObjects[0].CellValue(i, "seq") * 1 >= start_index * 1
				&& sheetObjects[0].CellValue(i, "seq") * 1 <= end_index * 1){
			if(ts != "")
				sheetObjects[0].CellValue(i, "ts_flg") = ts;
			if(pod != "")
				sheetObjects[0].CellValue(i, "pod_cd") = pod;
			if(mlb != "")
				sheetObjects[0].CellValue(i, "blck_stwg_cd") = mlb;
			if(yd != "")
				sheetObjects[0].CellValue(i, "pol_yd_cd") = yd;
		}
	}
}


	/**
	 * 시트 Change 이벤트
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
  function sheet1_OnChange(sheetObj, Row, Col, Value){
		 var formObject = document.form;
  	var stwgCd = "";
  	var sheetObj2 = sheetObjects[1];
  	var sheetObjRowCnt = sheetObj2.RowCount;
  	if (sheetObj.ColSaveName(Col) == "stwg_cd") {
  		stwgCd = sheetObj.CellValue(Row, "stwg_cd");
  		
  		var flag = false;
  		for(var i=1; i<= sheetObjRowCnt; i++){
  			if(stwgCd != '' && stwgCd == sheetObj2.CellValue(i, "val")){
  				flag = true;
  				break;
  			}
  		}
  		if(!flag){
  			ComShowCodeMessage('BKG01127');
  			sheetObj.CellValue2(Row, "stwg_cd") = "";
  		}
  	}
  } 
 
/* 개발자 작업 끝 */