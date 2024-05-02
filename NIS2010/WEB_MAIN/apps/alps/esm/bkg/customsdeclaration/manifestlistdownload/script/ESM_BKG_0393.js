/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0393.js
 *@FileTitle : House B/L Data Input Checklist
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.30
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.30 이수빈
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
 * @class House B/L Data Input Checklist : House B/L Data Input Checklist 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0393() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
// 공통전역변수
var tot_bkg = 0;
var tot_bl = 0;
var tot_mbl = 0;
var tot_hbl = 0;
var tot_fileno = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var rdObject = rdObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;
		
		case "btn_Print":
			doActionIBSheet(sheetObjects[0], document.form, RDPRINT);
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
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "mbl_filer":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#CCFFFD";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	}
}

/**
 * 콤보 Change 이벤트
 */
function mbl_filer_OnChange() {
	document.form.filer.value = comboObjects[0].Code;
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
	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	
	comboObjects[0].InsertItem(0, "ALL|ALL", "ALL");
	comboObjects[0].InsertItem(1, "01|Carrier Filing NVOCC", "1");
	comboObjects[0].InsertItem(2, "02|Self-Filing NVOCC", "2");
	comboObjects[0].InsertItem(3, "03|Not Applicable", "3");
	comboObjects[0].Code = 'ALL';
	
	initRdConfig(rdObjects[0]);
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	document.form.vvd.focus();
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		
	
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if ((srcName == "vvd" || srcName == "pol_cd" || srcName == "pod_cd" || srcName == "conti_cd" || srcName == "bkg_ofc_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2"&& keyValue != 9 && keyValue !=16 ) {
		ComSetNextFocus();
	}
}

/**
 * Click 이벤트 처리
 */
function obj_click() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");
	var srcVal = srcObj.getAttribute("value");
	
	var sheetObj = sheetObjects[0];
	if (srcName != "chk_err")
		return;
	if (srcVal == "err") {
		formObject.err_flg.value = 'Y';
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	} else {
		formObject.err_flg.value = 'N';
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}
}

/**
 * RD 설정
 */
function initRdConfig(rdObject) {
	
	var Rdviewer = rdObject;
	
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.IsShowDlg = 0;
	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.style.height = 0;
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
			style.height = 362;
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
			InitRowInfo(2, 1, 2, 100);
			
			var HeadTitle1 = "|Seq.|Booking No.|Status|B.POL|B.POD|DEL|Filer|B/L No.|vvd|House B/L|House B/L|House B/L|House B/L|Shipper|Shipper|BKG OFC|err|hbl_no|cntr_mf_no";
			var HeadTitle2 = "|Seq.|Booking No.|Status|B.POL|B.POD|DEL|Filer|B/L No.|vvd|Seq.|H.B/L|File#|C/M|Type|Name|BKG OFC|||";
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bkg_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "del_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "mbl_filer", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "vvd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "hbl_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 55, daCenter, true, "hbl_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "hbl_fileno_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 35, daCenter, true, "hbl_cm_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "shpr_tp", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "shpr_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bkg_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "err_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "hbl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "cntr_mf_no", false, "", dfNone, 0, false, false);
			
			InitDataCombo(0, "hbl_flg", "Y|N", "Y|N");
			InitDataCombo(0, "hbl_cm_flg", "Y|N", "Y|N");
			
			CountPosition = 0;
			
		}
		break;
	
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0393GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	
	case IBDOWNEXCEL: // EXCEL DOWNLOAD
		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage("BKG00109");
			return;
		} else {
			ComOpenWait(true);
			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			ComOpenWait(false);
		}
		break;
	
	case RDPRINT: //print
		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage("BKG00394");
			return;
		} else {
			rdOpen(rdObjects[0]);
		}
		break;
	}
}

/**
 * 조회 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	if (ErrMsg == "") {
		if (sheetObj.RowCount > 0) {
			formObj.tot_bkg.value = " BKG   [" + sheetObj.EtcData("tot_bkg") + "]";
			formObj.tot_bl.value = " Target B/L TTL [" + sheetObj.EtcData("tot_bl") + "]";
			formObj.tot_mbl_ttl.value = " M.B/L TTL [" + sheetObj.EtcData("tot_mbl") + "] => " + "01 M.B/L["
					+ sheetObj.EtcData("tot_mbl01") + "] + " + "02 M.B/L[" + sheetObj.EtcData("tot_mbl02") + "] + " + "03 M.B/L["
					+ sheetObj.EtcData("tot_mbl03") + "]";
			formObj.tot_mbl.value = " M.B/L [" + sheetObj.EtcData("tot_mbl") + "]";
			formObj.tot_hbl.value = " H.B/L TTL [" + sheetObj.EtcData("tot_hbl") + "]";
			formObj.tot_fileno.value = " File #   [" + sheetObj.EtcData("tot_fileno") + "]";
			formObj.tot_hbl_etc.value = " H.B/L TTL [" + sheetObj.EtcData("tot_hbl_etc") + "]";
			formObj.tot_fileno_etc.value = " File #   [" + sheetObj.EtcData("tot_fileno_etc") + "]";
			
			var redColor = sheetObj.RgbColor(256, 0, 0);
			var blueColor = sheetObj.RgbColor(0, 0, 256);
			for ( var i = 2; i < sheetObj.RowCount + 2; i++) {
				sheetObj.CellFont("FontUnderline", i, "bkg_no") = true;
				if (sheetObj.CellValue(i, "mbl_filer") == "01") {
					if (sheetObj.CellValue(i, "err_flg") == "Y") {
						sheetObj.CellFont("FontColor", i, "bkg_no") = redColor;
						if (sheetObj.CellValue(i, "hbl_flg") == 'N') {
							sheetObj.CellFont("FontColor", i, "hbl_flg") = redColor;
						} else {
							sheetObj.CellFont("FontColor", i, "hbl_flg") = blueColor;
						}
						if (sheetObj.CellValue(i, "hbl_fileno_flg") == 'N') {
							sheetObj.CellFont("FontColor", i, "hbl_fileno_flg") = redColor;
						} else {
							sheetObj.CellFont("FontColor", i, "hbl_fileno_flg") = blueColor;
						}
						if (sheetObj.CellValue(i, "hbl_cm_flg") == 'N') {
							sheetObj.CellFont("FontColor", i, "hbl_cm_flg") = redColor;
						} else {
							sheetObj.CellFont("FontColor", i, "hbl_cm_flg") = blueColor;
						}
					} else {
						sheetObj.CellFont("FontColor", i, "bkg_no") = blueColor;
						if (sheetObj.CellValue(i, "hbl_flg") == "Y") {
							sheetObj.CellFont("FontColor", i, "hbl_flg") = blueColor;
							sheetObj.CellFont("FontColor", i, "hbl_fileno_flg") = blueColor;
							sheetObj.CellFont("FontColor", i, "hbl_cm_flg") = blueColor;
						}
					}
				} else {
					if (sheetObj.CellValue(i, "hbl_flg") == 'Y') {
						sheetObj.CellFont("FontColor", i, "hbl_flg") = redColor;
					}
					if (sheetObj.CellValue(i, "hbl_fileno_flg") == 'Y') {
						sheetObj.CellFont("FontColor", i, "hbl_fileno_flg") = redColor;
					}
				}
			} // for end
		} else {
//			formObj.tot_bkg.value = " BKG   [0]";
//			formObj.tot_bl.value = " Target B/L TTL [0]";
//			formObj.tot_mbl_ttl.value = " M.B/L TTL [0] => " + "01 M.B/L[0] + " + "02 M.B/L[0] + " + "03 M.B/L[0]";
//			formObj.tot_mbl.value = " M.B/L [0]";
//			formObj.tot_hbl.value = " H.B/L TTL [0]";
//			formObj.tot_fileno.value = " File #   [0]";
			formObj.tot_bkg.value = "";
			formObj.tot_bl.value = "";
			formObj.tot_mbl_ttl.value = "";
			formObj.tot_mbl.value = "";
			formObj.tot_hbl.value = "";
			formObj.tot_fileno.value = "";
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //조회
		if (!ComChkValid(formObj))
			return false;
		return true;
		break;
	}
}

/**
 * Booking Creation 화면 이동
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	if (sheetObj.ColSaveName(Col) != "bkg_no") return;
	ComBkgCall0079(sheetObj.CellValue(Row, "bkg_no"));
}

/**
 * 시트에 마우스 오버 시 툴팁 보여주기
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	Col = sheetObj.MouseCol;
	if (sheetObj.ColSaveName(Col) == "bkg_no") {
		sheetObj.MousePointer = "Hand";
	} else {
		sheetObj.MousePointer = "Default";
	}
}
/**
 * RD 오픈
 */
function rdOpen(rdObject) {
	
	var formObject = document.form;
	
	var vvd = formObject.vvd.value;
	var polCd = formObject.pol_cd.value;
	var podCd = formObject.pod_cd.value;
	var ofcCd = formObject.bkg_ofc_cd.value;
	var repCd = formObject.ob_srep_cd.value;
	var mblFiler = formObject.filer.value;
	
	var totBkg = formObject.tot_bkg.value;
	var totMblTtl = formObject.tot_mbl_ttl.value;
	var totBl = formObject.tot_bl.value;
	var totMbl = formObject.tot_mbl.value;
	var totHbl = formObject.tot_hbl.value;
	var totFileno = formObject.tot_fileno.value;
	var customs = formObject.customs.value;
	var errFlg = formObject.err_flg.value;
	
	var param = "/rp [" + vvd + "][" + polCd + "][" + podCd + "][" + ofcCd + "][" + repCd + "][" + mblFiler + "][" + totBkg
			+ "][" + totMblTtl + "][" + totBl + "][" + totMbl + "][" + totHbl + "][" + totFileno + "][" + customs + "][" + errFlg
			+ "]";
	
	var sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
	sXml += "</SHEET>";
	
	var rdParam = param + " /riprnmargin /rwait";
	var strPath = RD_path + "apps/alps/esm/bkg/customsdeclaration/manifestlistdownload/report/ESM_BKG_0872.mrd";
	
	var Rdviewer = rdObject;
	Rdviewer.SetRData(sXml);
	Rdviewer.FileOpen(strPath, RDServer + rdParam);
	if (strCntCd == "US") {
		Rdviewer.SetPrint2(4, 1, 1, 100);
	}
	Rdviewer.PrintDialog();
}

/**
 * RD 출력
 * @param rdObject
 * @return
 */
function rdPrint(rdObject) {
	var Rdviewer = rdObject;
	
	Rdviewer.PrintDialog();
	// Rdviewer.CMPrint();
}
/* 개발자 작업  끝 */